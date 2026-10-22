package androidx.webkit.internal;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
public class ApiHelperForQ {
    private ApiHelperForQ() {
    }

    public static int getForceDark(WebSettings r100) {
        return r100.getForceDark();
    }

    public static WebViewRenderProcess getWebViewRenderProcess(WebView r100) {
        return r100.getWebViewRenderProcess();
    }

    public static WebViewRenderProcessClient getWebViewRenderProcessClient(WebView r100) {
        return r100.getWebViewRenderProcessClient();
    }

    public static boolean terminate(WebViewRenderProcess r100) {
        return r100.terminate();
    }

    public static void setForceDark(WebSettings r100, int r101) {
        r100.setForceDark(r101);
    }

    public static void setWebViewRenderProcessClient(WebView r100, androidx.webkit.WebViewRenderProcessClient r101) {
        if (r101 == null) goto L4;
        WebViewRenderProcessClientFrameworkAdapter r102 = new WebViewRenderProcessClientFrameworkAdapter(r101);
    L5:
        r100.setWebViewRenderProcessClient(r102);
        return;
    L4:
        r102 = null;
        goto L5
    }

    public static void setWebViewRenderProcessClient(WebView r100, Executor r101, androidx.webkit.WebViewRenderProcessClient r102) {
        if (r102 == null) goto L4;
        WebViewRenderProcessClientFrameworkAdapter r103 = new WebViewRenderProcessClientFrameworkAdapter(r102);
    L5:
        r100.setWebViewRenderProcessClient(r101, r103);
        return;
    L4:
        r103 = null;
        goto L5
    }
}
