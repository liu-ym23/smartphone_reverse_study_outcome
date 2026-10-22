package com.bytedance.android.monitor.webview;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* loaded from: classes2.dex */
public class WebViewMonitorWebChromeClient extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        WebViewMonitorHelper.getInstance().onProgressChanged(webView, i);
    }
}
