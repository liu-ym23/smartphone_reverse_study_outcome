package stepos.support.v7.app;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class r0 extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewActivity f12476a;

    public r0(WebViewActivity webViewActivity) {
        this.f12476a = webViewActivity;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        webView.loadUrl("javascript:(function(){ document.body.style.paddingBottom = '" + this.f12476a.f12263c + "px'})();");
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            int i = WebViewActivity.f12262h;
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}
