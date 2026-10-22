package androidx.webkit.internal;

import android.content.pm.PackageInfo;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: compiled from: ApiHelperForO.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void a(WebSettings r0, boolean r1) {
        r0.setSafeBrowsingEnabled(r1);
    }

    public static boolean a(WebSettings r0) {
        return r0.getSafeBrowsingEnabled();
    }

    public static WebViewClient a(WebView r0) {
        return r0.getWebViewClient();
    }

    public static WebChromeClient b(WebView r0) {
        return r0.getWebChromeClient();
    }

    public static PackageInfo a() {
        return WebView.getCurrentWebViewPackage();
    }
}
