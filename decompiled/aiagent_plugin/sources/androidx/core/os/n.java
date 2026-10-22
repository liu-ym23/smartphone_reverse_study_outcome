package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TraceCompat.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class n {
    private static final String TAG = "TraceCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f1278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f1279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f1280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f1281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f1282e;

    /* JADX INFO: compiled from: TraceCompat.java */
    static class a {
        static void a(String r0) {
            Trace.beginSection(r0);
        }

        static void a() {
            Trace.endSection();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 29) goto L14;
        f1278a = Trace.class.getField("TRACE_TAG_APP").getLong(null);     // Catch: Exception -> L8
        f1279b = Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});     // Catch: Exception -> L8
        f1280c = Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L8
        f1281d = Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L8
        f1282e = Trace.class.getMethod("traceCounter", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        a(TAG, "Unable to initialize via reflection.", e);
        return;
    }

    public static void a(String r2) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        a.a(r2);
        return;
    }

    public static void a() {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        a.a();
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2, r3);
    }
}
