package B2;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.monitor.webview.WebViewMonitorHelper;

/* loaded from: classes2.dex */
public final class f implements View.OnAttachStateChangeListener {
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        if (view instanceof WebView) {
            WebView webView = (WebView) view;
            if (WebViewMonitorHelper.b.isNeedAutoReport(webView)) {
                WebViewMonitorHelper.getInstance().report(webView);
            }
        }
    }
}
