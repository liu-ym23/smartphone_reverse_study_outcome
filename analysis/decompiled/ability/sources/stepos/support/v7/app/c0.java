package stepos.support.v7.app;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: classes4.dex */
public final class c0 extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewActivity f6293a;

    public c0(WebViewActivity webViewActivity) {
        this.f6293a = webViewActivity;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        webView.loadUrl("javascript:(function(){ document.body.style.paddingBottom = '" + this.f6293a.f6239a + "px'})();");
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            int i = WebViewActivity.d;
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}
