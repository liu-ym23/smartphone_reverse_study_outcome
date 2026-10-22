package androidx.webkit.internal;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;

/* JADX INFO: loaded from: classes.dex */
public class WebViewRenderProcessClientFrameworkAdapter extends WebViewRenderProcessClient {
    private androidx.webkit.m mWebViewRenderProcessClient;

    public WebViewRenderProcessClientFrameworkAdapter(androidx.webkit.m r1) {
        this.mWebViewRenderProcessClient = r1;
    }

    @Override // android.webkit.WebViewRenderProcessClient
    public void onRenderProcessUnresponsive(WebView r1, WebViewRenderProcess r2) {
        this.mWebViewRenderProcessClient.a(r1, u.a(r2));
    }

    @Override // android.webkit.WebViewRenderProcessClient
    public void onRenderProcessResponsive(WebView r1, WebViewRenderProcess r2) {
        this.mWebViewRenderProcessClient.b(r1, u.a(r2));
    }

    public androidx.webkit.m getFrameworkRenderProcessClient() {
        return this.mWebViewRenderProcessClient;
    }
}
