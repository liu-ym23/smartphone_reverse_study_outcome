package cf8;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.view.screenmenu.widget.MenuStyle;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public interface c {
    void a(View r100, String r101, JSONObject r102);

    boolean b(String r100, List<? extends ot8.a> r101);

    Unit c();

    Pair<String, String> d(Context r100, View r101, String r102, Long r103, float r104, float r105, List<? extends List<? extends ot8.a>> r106, @MenuStyle String r107);

    boolean e(String r100);

    String f();
}
