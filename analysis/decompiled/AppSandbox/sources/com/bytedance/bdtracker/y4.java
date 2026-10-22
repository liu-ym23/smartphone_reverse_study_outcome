package com.bytedance.bdtracker;

import com.bytedance.applog.tracker.Tracker;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

/* loaded from: classes.dex */
public final class y4 extends WebChromeClient {
    public void onProgressChanged(WebView webView, int i) {
        Tracker.onProgressChanged(this, webView, i);
        super.onProgressChanged(webView, i);
    }
}
