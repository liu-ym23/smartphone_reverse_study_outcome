package B2;

import android.webkit.WebView;
import com.bytedance.android.monitor.webview.WebViewMonitorHelper;

/* loaded from: classes2.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final WebView f187a;
    public final /* synthetic */ WebViewMonitorHelper b;

    public e(WebViewMonitorHelper webViewMonitorHelper, WebView webView) {
        this.b = webViewMonitorHelper;
        this.f187a = webView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.reportTruly(this.f187a);
    }
}
