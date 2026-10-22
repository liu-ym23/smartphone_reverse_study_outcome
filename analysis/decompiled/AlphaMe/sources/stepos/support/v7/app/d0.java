package stepos.support.v7.app;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: classes2.dex */
public final class d0 extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewActivity f14446a;

    public d0(WebViewActivity webViewActivity) {
        this.f14446a = webViewActivity;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        webView.loadUrl("javascript:(function(){ document.body.style.paddingBottom = '" + this.f14446a.f14358a + "px'})();");
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            int i4 = WebViewActivity.f14357d;
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}
