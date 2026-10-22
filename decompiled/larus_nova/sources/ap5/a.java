package ap5;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.alibaba.fastjson.JSONObject;
import swb.k;
import swb.o;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    public static boolean b(WebView r100) {
        if (r100 != null) goto L5;
        o.a("SafeJSExecutor", new IllegalStateException("execJS no webView !"));
        return true;
    L5:
        return false;
    }

    public static void a(WebView r100, String r101, JSONObject r102, ValueCallback<String> r103) {
        if (b(r100) == false) goto L5;
        return;
    L5:
        r100.evaluateJavascript(k.a(r101, r102), r103);
    }
}
