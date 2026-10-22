package com.android.ttcjpaysdk.ttcjpayapi;

import android.webkit.WebView;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface TTCJPayObserver {
    void onEvent(String r100, Map<String, String> r101);

    void onMonitor(String r100, int r101, JSONObject r102);

    void onPayCallback(TTCJPayResult r100);

    void onWebViewInit(WeakReference<WebView> r100);
}
