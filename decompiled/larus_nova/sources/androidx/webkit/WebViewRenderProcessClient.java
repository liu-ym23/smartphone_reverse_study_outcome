package androidx.webkit;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes17.dex */
public abstract class WebViewRenderProcessClient {
    public WebViewRenderProcessClient() {
    }

    public abstract void onRenderProcessResponsive(WebView r100, WebViewRenderProcess r101);

    public abstract void onRenderProcessUnresponsive(WebView r100, WebViewRenderProcess r101);
}
