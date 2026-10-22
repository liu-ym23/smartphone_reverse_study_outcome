package com.bytedance.applog.tracker;

import android.util.LruCache;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.util.WebViewJsUtil;
import com.bytedance.bdtracker.b;
import com.bytedance.bdtracker.b5;
import com.bytedance.bdtracker.x4;
import com.bytedance.bdtracker.y4;
import com.bytedance.bdtracker.z4;
import java.util.Collections;

/* loaded from: classes.dex */
public class WebViewUtil {
    public static final LruCache<String, Long> a = new LruCache<>(100);
    public static final LruCache<String, Long> b = new LruCache<>(100);

    public static WebChromeClient a(WebView webView) {
        return webView.getWebChromeClient();
    }

    public static boolean a(LruCache<String, Long> lruCache, View view) {
        if (view == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(view.hashCode());
        sb.append("$$");
        sb.append(view.getId());
        return lruCache.get(sb.toString()) == null;
    }

    public static void b(LruCache<String, Long> lruCache, View view) {
        if (view == null) {
            return;
        }
        lruCache.put(view.hashCode() + "$$" + view.getId(), Long.valueOf(System.currentTimeMillis()));
    }

    public static void injectWebViewBridges(View view, String str) {
        boolean z;
        LruCache<String, Long> lruCache = b;
        boolean z2 = true;
        if (a(lruCache, view) && b.b(b.b) && x4.a(view, str)) {
            b(lruCache, view);
            z = true;
        } else {
            z = false;
        }
        LruCache<String, Long> lruCache2 = a;
        if (a(lruCache2, view) && b.b(b.c)) {
            WebViewJsUtil.injectNativeReportCallback(view);
            b(lruCache2, view);
        } else {
            z2 = z;
        }
        if (z2 && b5.a(view)) {
            if (b5.b(view)) {
                com.tencent.smtt.sdk.WebView webView = (com.tencent.smtt.sdk.WebView) view;
                if (webView.getWebChromeClient() == null) {
                    webView.setWebChromeClient(new y4());
                    return;
                }
                return;
            }
            try {
                if (a((WebView) view) == null) {
                    ((WebView) view).setWebChromeClient(new z4());
                }
            } catch (Throwable th) {
                LoggerImpl.global().error(Collections.singletonList("WebViewUtil"), "getWebChromeClient failed", th, new Object[0]);
            }
        }
    }

    public static void injectWebViewJsCode(View view, String str) {
        x4.a(view);
        if (b.b(b.c)) {
            WebViewJsUtil.injectCollectJs(view, str);
        }
    }
}
