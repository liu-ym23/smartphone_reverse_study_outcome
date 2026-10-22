package androidx.webkit.internal;

import android.os.Looper;
import android.webkit.TracingConfig;
import android.webkit.TracingController;
import android.webkit.WebView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ApiHelperForP.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static TracingController a() {
        return TracingController.getInstance();
    }

    public static boolean a(TracingController r0) {
        return r0.isTracing();
    }

    public static void a(TracingController r4, androidx.webkit.e r5) {
        r4.start(new TracingConfig.Builder().addCategories(new int[]{r5.a()}).addCategories(r5.b()).setTracingMode(r5.c()).build());
    }

    public static boolean a(TracingController r2, OutputStream r3, Executor r4) {
        return r2.stop(r3, (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin"));
    }

    public static ClassLoader b() {
        return WebView.getWebViewClassLoader();
    }

    public static Looper a(WebView r0) {
        return r0.getWebViewLooper();
    }

    public static void a(String r0) {
        WebView.setDataDirectorySuffix(r0);
    }
}
