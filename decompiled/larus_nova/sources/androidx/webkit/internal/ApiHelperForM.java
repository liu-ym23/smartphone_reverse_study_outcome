package androidx.webkit.internal;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;

/* JADX INFO: loaded from: classes17.dex */
public class ApiHelperForM {
    private ApiHelperForM() {
    }

    public static void close(WebMessagePort r100) {
        r100.close();
    }

    public static WebMessage createWebMessage(WebMessageCompat r100) {
        return new WebMessage(r100.getData(), WebMessagePortImpl.compatToPorts(r100.getPorts()));
    }

    public static WebMessagePort[] createWebMessageChannel(WebView r100) {
        return r100.createWebMessageChannel();
    }

    public static WebMessageCompat createWebMessageCompat(WebMessage r100) {
        return new WebMessageCompat(r100.getData(), WebMessagePortImpl.portsToCompat(r100.getPorts()));
    }

    public static CharSequence getDescription(WebResourceError r100) {
        return r100.getDescription();
    }

    public static int getErrorCode(WebResourceError r100) {
        return r100.getErrorCode();
    }

    public static boolean getOffscreenPreRaster(WebSettings r100) {
        return r100.getOffscreenPreRaster();
    }

    public static void postMessage(WebMessagePort r100, WebMessage r101) {
        r100.postMessage(r101);
    }

    public static void setOffscreenPreRaster(WebSettings r100, boolean r101) {
        r100.setOffscreenPreRaster(r101);
    }

    public static void setWebMessageCallback(WebMessagePort r100, final WebMessagePortCompat.WebMessageCallbackCompat r101) {
        r100.setWebMessageCallback(new AnonymousClass1(r101));
    }

    public static void postVisualStateCallback(WebView r100, long r101, final WebViewCompat.VisualStateCallback r102) {
        r100.postVisualStateCallback(r101, new AnonymousClass3(r102));
    }

    public static void postWebMessage(WebView r100, WebMessage r101, Uri r102) {
        r100.postWebMessage(r101, r102);
    }

    public static void setWebMessageCallback(WebMessagePort r100, final WebMessagePortCompat.WebMessageCallbackCompat r101, Handler r102) {
        r100.setWebMessageCallback(new AnonymousClass2(r101), r102);
    }
}
