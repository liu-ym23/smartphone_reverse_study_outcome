package com.bytedance.android.live.browser.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ies.web.jsbridge2.x;

/* JADX INFO: loaded from: classes45.dex */
public class SSWebView extends WebView implements x {
    @Override // com.bytedance.ies.web.jsbridge2.x
    public String getSafeUrl() {
        return "";
    }

    public SSWebView(Context r100) {
        super(r100);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient r100) {
        super.setWebViewClient(r100);     // Catch: Exception -> L4
        return;
    }

    public SSWebView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public SSWebView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
