package androidx.webkit.internal;

import android.content.pm.PackageInfo;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes17.dex */
public class ApiHelperForO {
    private ApiHelperForO() {
    }

    public static PackageInfo getCurrentWebViewPackage() {
        return WebView.getCurrentWebViewPackage();
    }

    public static boolean getSafeBrowsingEnabled(WebSettings r100) {
        return r100.getSafeBrowsingEnabled();
    }

    public static WebChromeClient getWebChromeClient(WebView r100) {
        return r100.getWebChromeClient();
    }

    public static WebViewClient getWebViewClient(WebView r100) {
        return r100.getWebViewClient();
    }

    public static void setSafeBrowsingEnabled(WebSettings r100, boolean r101) {
        r100.setSafeBrowsingEnabled(r101);
    }
}
