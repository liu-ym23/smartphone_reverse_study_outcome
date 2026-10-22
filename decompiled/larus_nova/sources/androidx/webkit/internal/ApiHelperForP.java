package androidx.webkit.internal;

import android.os.Looper;
import android.webkit.TracingController;
import android.webkit.WebView;
import androidx.webkit.TracingConfig;
import java.io.OutputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
public class ApiHelperForP {
    public static TracingController getTracingControllerInstance() {
        return TracingController.getInstance();
    }

    public static ClassLoader getWebViewClassLoader() {
        return WebView.getWebViewClassLoader();
    }

    private ApiHelperForP() {
    }

    public static Looper getWebViewLooper(WebView r100) {
        return r100.getWebViewLooper();
    }

    public static boolean isTracing(TracingController r100) {
        return r100.isTracing();
    }

    public static void start(TracingController r100, TracingConfig r101) {
        r100.start(new android.webkit.TracingConfig.Builder().addCategories(new int[]{r101.getPredefinedCategories()}).addCategories(r101.getCustomIncludedCategories()).setTracingMode(r101.getTracingMode()).build());
    }

    public static boolean stop(TracingController r100, OutputStream r101, Executor r102) {
        return r100.stop(r101, r102);
    }
}
