package b36;

import android.content.Context;
import android.webkit.WebView;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.service.base.web.WebChromeClientDispatcher;
import com.bytedance.ies.bullet.service.webkit.WebViewDelegate;

/* JADX INFO: loaded from: classes19.dex */
public interface h {
    WebViewDelegate a(SSWebView r100);

    WebViewDelegate b(Context r100, String r101);

    WebChromeClientDispatcher c();

    WebView d(Context r100, String r101);

    void destroy();

    r e();

    com.bytedance.ies.bullet.service.webkit.b f();

    WebView getWebView();
}
