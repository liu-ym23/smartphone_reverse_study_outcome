package androidx.webkit.internal;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;

/* JADX INFO: loaded from: classes17.dex */
public class WebViewRenderProcessClientFrameworkAdapter extends WebViewRenderProcessClient {
    private androidx.webkit.WebViewRenderProcessClient mWebViewRenderProcessClient;

    public androidx.webkit.WebViewRenderProcessClient getFrameworkRenderProcessClient() {
        return this.mWebViewRenderProcessClient;
    }

    public WebViewRenderProcessClientFrameworkAdapter(androidx.webkit.WebViewRenderProcessClient r100) {
        this.mWebViewRenderProcessClient = r100;
    }

    @Override // android.webkit.WebViewRenderProcessClient
    public void onRenderProcessResponsive(WebView r100, WebViewRenderProcess r101) {
        this.mWebViewRenderProcessClient.onRenderProcessResponsive(r100, WebViewRenderProcessImpl.forFrameworkObject(r101));
    }

    @Override // android.webkit.WebViewRenderProcessClient
    public void onRenderProcessUnresponsive(WebView r100, WebViewRenderProcess r101) {
        this.mWebViewRenderProcessClient.onRenderProcessUnresponsive(r100, WebViewRenderProcessImpl.forFrameworkObject(r101));
    }
}
