package com.bytedance.android.monitor.webview;

import B2.b;
import B2.c;
import B2.d;
import B7.a;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.Keep;
import com.bytedance.android.monitor.logger.MonitorLog;
import java.lang.ref.WeakReference;

@Keep
/* loaded from: classes2.dex */
public class TTLiveWebViewMonitorJsBridge {
    private WeakReference<WebView> mWebViewRef;
    private Handler mainHanlder = new Handler(Looper.getMainLooper());

    public TTLiveWebViewMonitorJsBridge(WebView webView) {
        this.mWebViewRef = new WeakReference<>(webView);
    }

    @JavascriptInterface
    public void cover(String str, String str2) {
        if (WebViewMonitorHelper.b.isNeedMonitor(this.mWebViewRef.get())) {
            MonitorLog.d("TTLiveWebViewMonitorJsBridge", "cover: service:" + str2 + " json : " + str);
            this.mainHanlder.post(new b(this, str, str2, 0));
        }
    }

    @JavascriptInterface
    public void customReport(String str, String str2, String str3, String str4) {
        if (WebViewMonitorHelper.b.isNeedMonitor(this.mWebViewRef.get())) {
            StringBuilder sbW = a.w("customReport: merticJson:", str, " categoryJson : ", str2, " extraJson:");
            sbW.append(str3);
            sbW.append(" type:");
            sbW.append(str4);
            MonitorLog.d("TTLiveWebViewMonitorJsBridge", sbW.toString());
            this.mainHanlder.post(new c(this, str2, str, str3, str4));
        }
    }

    @JavascriptInterface
    public void reportDirectly(String str, String str2) {
        if (WebViewMonitorHelper.b.isNeedMonitor(this.mWebViewRef.get())) {
            MonitorLog.d("TTLiveWebViewMonitorJsBridge", "reportDirectly: service:" + str2 + " json : " + str);
            this.mainHanlder.post(new b(this, str2, str, 1));
        }
    }

    @JavascriptInterface
    public void reportPageLatestData(String str) {
        if (WebViewMonitorHelper.b.isNeedMonitor(this.mWebViewRef.get())) {
            MonitorLog.d("TTLiveWebViewMonitorJsBridge", "reportPageLatestData: json:" + str);
            this.mainHanlder.post(new d(this, str, 1));
        }
    }

    @JavascriptInterface
    public void sendInitTimeInfo(String str) {
        if (WebViewMonitorHelper.b.isNeedMonitor(this.mWebViewRef.get())) {
            MonitorLog.d("TTLiveWebViewMonitorJsBridge", "sendInitTimeInfo: json:" + str);
            this.mainHanlder.post(new d(this, str, 0));
        }
    }
}
