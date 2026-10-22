package cd4;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public interface h {
    void a(AppCompatActivity r100, WebView r101, qd4.a r102);

    of4.a b(AppCompatActivity r100, WebView r101, qd4.a r102);

    void c(String r100);

    String d(AppCompatActivity r100, List r101);

    void e(WebView r100, WebViewClient r101);

    String f(AppCompatActivity r100, Function1 r101);

    void g(com.android.ttcjpaysdk.base.h5.f r100);

    void h(String r100, JSONObject r101, WebView r102);

    boolean i(WebView r100, String r101);

    boolean j(String r100);

    void k(String r100);
}
