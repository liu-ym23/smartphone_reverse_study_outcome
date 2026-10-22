package com.bytedance.bdtracker;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: classes.dex */
public final class z4 extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        Tracker.onProgressChanged(this, webView, i);
        super.onProgressChanged(webView, i);
    }
}
