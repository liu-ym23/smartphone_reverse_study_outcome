package com.bytedance.android.monitorV2.webview.ttweb;

import android.webkit.WebView;
import com.bytedance.android.monitorV2.util.f;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class TTUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f163378a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f163379b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f163380c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f163381d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f163382e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f163383f = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/ttweb/TTUtils$MetricsArgs;", "", "", "args", "Ljava/lang/String;", "getArgs", "()Ljava/lang/String;", "Metrics", "Errors", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum MetricsArgs extends Enum<MetricsArgs> {
        public static final MetricsArgs Errors = null;
        public static final MetricsArgs Metrics = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MetricsArgs[] f163384a = null;
        private final String args;

        public static MetricsArgs valueOf(String r100) {
            return (MetricsArgs) r27.a.a(MetricsArgs.class, r100);
        }

        public static MetricsArgs[] values() {
            return (MetricsArgs[]) f163384a.clone();
        }

        static {
            MetricsArgs r100 = new MetricsArgs("Metrics", 0, "{\"loading\":{}}");
            Metrics = r100;
            MetricsArgs r101 = new MetricsArgs("Errors", 1, "{\"webview_error\":{}}");
            Errors = r101;
            f163384a = new MetricsArgs[]{r100, r101};
        }

        public final String getArgs() {
            return this.args;
        }

        public MetricsArgs(String r100, int r101, String r102) {
            super(r100, r101);
            this.args = r102;
        }
    }

    public TTUtils() {
    }

    static {
        f163378a = LazyKt.lazy(TTUtils$ttWebSdkClazz$2.INSTANCE);
        f163379b = LazyKt.lazy(TTUtils$ttWebViewExtensionClazz$2.INSTANCE);
        f163380c = LazyKt.lazy(TTUtils$isTTWebViewMethod$2.INSTANCE);
        f163381d = LazyKt.lazy(TTUtils$isHookSuccessMethod$2.INSTANCE);
        f163382e = LazyKt.lazy(TTUtils$ttWebViewExtensionConstructor$2.INSTANCE);
        f163383f = LazyKt.lazy(TTUtils$getPerformanceMetricsMethod$2.INSTANCE);
    }

    public static boolean a(WebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Method r101 = (Method) f163381d.getValue();     // Catch: Throwable -> L7
        if (r101 == null) goto L12;
        r101.setAccessible(true);     // Catch: Throwable -> L7
        Object r102 = r101.invoke(null, new Object[]{r100});     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L7
        return ((Boolean) r102).booleanValue();
    L12:
        return false;
    L7:
        th = move-exception;
        f.b(th);
        return false;
    }

    public static JSONObject b(WebView r100, MetricsArgs r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "args");
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L9
        Constructor r103 = (Constructor) f163382e.getValue();     // Catch: Throwable -> L9
        if (r103 == null) goto L14;
        Method r104 = (Method) f163383f.getValue();     // Catch: Throwable -> L9
        if (r104 == null) goto L15;
        Object r105 = r104.invoke(r103.newInstance(new Object[]{r100}), new Object[]{r101.getArgs()});     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L9
        return new JSONObject((String) r105);
    L15:
        return r102;
    L14:
        return r102;
    L9:
        th = move-exception;
        f.b(th);
        return new JSONObject();
    }
}
