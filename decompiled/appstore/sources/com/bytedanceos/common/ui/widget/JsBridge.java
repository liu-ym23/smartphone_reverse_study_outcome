package com.bytedanceos.common.ui.widget;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes2.dex */
public class JsBridge {
    private static final String TAG = "JsBridge";
    private JsBridgeOwner mOwner;
    private final ASWebView mWebView;

    public interface JsBridgeOwner {
        Fragment getFragment();

        Activity getHostActivity();

        WebView getWebView();
    }

    static {
    }

    public JsBridge(JsBridgeOwner r10, ASWebView r11) {
        this.mOwner = r10;
        this.mWebView = r11;
    }

    public static String appendParameter(String r10) {
        return r10;
    }

    @JavascriptInterface
    public void clearCache(String r10) {
        ASWebView r11 = this.mWebView;
        if (r11 == null) goto L6;
        r11.setWebChromeClient(null);
        this.mWebView.setWebViewClient(null);
        this.mWebView.getSettings().setJavaScriptEnabled(false);
        this.mWebView.clearCache(true);
        return;
    }

    @JavascriptInterface
    public void closePage(String r10) {
        JsBridgeOwner r11 = this.mOwner;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.getHostActivity() == null) goto L9;
        this.mOwner.getHostActivity().finish();
        return;
    }
}
