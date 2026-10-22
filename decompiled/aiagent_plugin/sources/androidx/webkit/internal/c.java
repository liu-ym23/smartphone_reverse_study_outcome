package androidx.webkit.internal;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ApiHelperForM.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(WebMessagePort r0, WebMessage r1) {
        r0.postMessage(r1);
    }

    public static void a(WebMessagePort r0) {
        r0.close();
    }

    public static void a(WebMessagePort r1, final androidx.webkit.g.a r2) {
        r1.setWebMessageCallback(new ApiHelperForM$1(r2));
    }

    public static void a(WebMessagePort r1, final androidx.webkit.g.a r2, Handler r3) {
        r1.setWebMessageCallback(new ApiHelperForM$2(r2), r3);
    }

    public static WebMessage a(androidx.webkit.f r2) {
        return new WebMessage(r2.a(), m.a(r2.b()));
    }

    public static androidx.webkit.f a(WebMessage r2) {
        return new androidx.webkit.f(r2.getData(), m.a(r2.getPorts()));
    }

    public static int a(WebResourceError r0) {
        return r0.getErrorCode();
    }

    public static CharSequence b(WebResourceError r0) {
        return r0.getDescription();
    }

    public static void a(WebSettings r0, boolean r1) {
        r0.setOffscreenPreRaster(r1);
    }

    public static boolean a(WebSettings r0) {
        return r0.getOffscreenPreRaster();
    }

    public static void a(WebView r2, long r3, androidx.webkit.j.a r5) {
        final androidx.webkit.j.a r6 = (androidx.webkit.j.a) ZeusTransformUtils.wrapperContextForParams(r5, androidx.webkit.j.a.class, "com.obric.aiagent.plugin");
        r2.postVisualStateCallback(r3, new ApiHelperForM$3(r6));
    }

    public static void a(WebView r0, WebMessage r1, Uri r2) {
        r0.postWebMessage(r1, r2);
    }

    public static WebMessagePort[] a(WebView r0) {
        return r0.createWebMessageChannel();
    }
}
