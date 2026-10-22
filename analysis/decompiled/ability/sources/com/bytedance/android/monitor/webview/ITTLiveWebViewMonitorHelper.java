package com.bytedance.android.monitor.webview;

import B2.a;
import G.b;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import java.util.Set;

/* loaded from: classes2.dex */
public interface ITTLiveWebViewMonitorHelper {
    void addConfig(a aVar);

    a buildConfig();

    String createWebViewKey(WebView webView);

    void customParams(WebView webView, String str);

    void customParseKey(WebView webView, Set<String> set);

    void customReport(WebView webView, String str, String str2, String str3, String str4);

    void customReport(WebView webView, String str, String str2, String str3, String str4, String str5, String str6);

    void destroy(WebView webView);

    void dispatchTouchEvent(WebView webView, MotionEvent motionEvent);

    void goBack(WebView webView);

    void handleFetchError(WebView webView, G.a aVar);

    void handleFetchSuccess(WebView webView);

    void handleJSBError(WebView webView, b bVar);

    void handleRequestError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError);

    @Deprecated
    void initConfig(a aVar);

    void onClientOffline(WebView webView, String str, boolean z10);

    void onLoadUrl(WebView webView, String str);

    void onOffline(WebView webView, String str, boolean z10);

    void onOfflineInfoExtra(WebView webView, String str, String str2, String str3, String str4, String str5);

    void onPageFinished(WebView webView, String str);

    void onPageStarted(WebView webView, String str);

    @Deprecated
    void onPageStarted(WebView webView, String str, Bitmap bitmap);

    void onProgressChanged(WebView webView, int i);

    void reload(WebView webView);

    void removeWebViewKey(String str);

    void report(WebView webView);

    void reportTruly(WebView webView);

    void setDefaultConfig(a aVar);

    void setGeckoClient(F.a aVar);
}
