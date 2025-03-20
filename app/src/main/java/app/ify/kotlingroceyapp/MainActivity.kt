package app.ify.kotlingroceyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.ify.kotlingroceyapp.ui.theme.KotlinGroceyAppTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyColumnWithStickyHeader()
        }
        }
    }

 @OptIn(ExperimentalFoundationApi::class)
 @Composable
 fun LazyColumnWithStickyHeader() {
     val groupedItems = mapOf(
         //1 - Creating the data source : map with key-value pairs
         "Fruits" to listOf("Apple", "Banana", "Cherry", "Mango", "Grapes", "WaterMelon"),
         "vegetables" to listOf("Carrot", "Lettuce", "Tomato","Onions","Potato","Eggplant")
     )
     val myfruits = groupedItems["Fruits"]

     // Lazy Column
     LazyColumn {
         groupedItems.forEach {
             (header, items) ->
             stickyHeader {
           MyCustomHeader(title = header)
             }
             items (items){
                 item -> MyCustomItem(itemTitle = item)
             }
         }
     }
 }

  @Composable
  fun MyCustomHeader(title: String){
     Text(
         text = title,
         fontSize = 32.sp,
         modifier = Modifier.fillMaxWidth()
             .background(Color.Red)
             .padding(8.dp)

     )
  }

   @Composable
   fun MyCustomItem(itemTitle: String){
       Card {
           Text(text = itemTitle,
               modifier = Modifier.padding(8.dp),
               fontSize = 24.sp
           )
       }
   }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinGroceyAppTheme {

    }
}