package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api29Impl {
        public static boolean isEnabled() {
            return Trace.isEnabled();
        }

        private Api29Impl() {
        }

        public static void beginAsyncSection(String r100, int r101) {
            Trace.beginAsyncSection(r100, r101);
        }

        public static void endAsyncSection(String r100, int r101) {
            Trace.endAsyncSection(r100, r101);
        }

        public static void setCounter(String r100, long r101) {
            Trace.setCounter(r100, r101);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) goto L9;
        sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);     // Catch: Exception -> L6
        Class r100 = Long.TYPE;     // Catch: Exception -> L6
        sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", new Class[]{r100});     // Catch: Exception -> L6
        Class r101 = Integer.TYPE;     // Catch: Exception -> L6
        sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", new Class[]{r100, String.class, r101});     // Catch: Exception -> L6
        sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", new Class[]{r100, String.class, r101});     // Catch: Exception -> L6
        sTraceCounterMethod = Trace.class.getMethod("traceCounter", new Class[]{r100, String.class, r101});     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public static boolean isEnabled() {
        if (Build.VERSION.SDK_INT < 29) goto L10;
        return Api29Impl.isEnabled();
    L10:
        return ((Boolean) sIsTagEnabledMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp)})).booleanValue();
    L12:
        return false;
    }

    private TraceCompat() {
    }

    public static void endSection() {
        Trace.endSection();
    }

    public static void beginSection(String r100) {
        Trace.beginSection(r100);
    }

    public static void beginAsyncSection(String r100, int r101) {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Api29Impl.beginAsyncSection(r100, r101);
        return;
    L8:
        sAsyncTraceBeginMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r100, Integer.valueOf(r101)});     // Catch: Exception -> L7
        return;
    }

    public static void endAsyncSection(String r100, int r101) {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Api29Impl.endAsyncSection(r100, r101);
        return;
    L8:
        sAsyncTraceEndMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r100, Integer.valueOf(r101)});     // Catch: Exception -> L7
        return;
    }

    public static void setCounter(String r100, int r101) {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Api29Impl.setCounter(r100, r101);
        return;
    L8:
        sTraceCounterMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r100, Integer.valueOf(r101)});     // Catch: Exception -> L7
        return;
    }
}
