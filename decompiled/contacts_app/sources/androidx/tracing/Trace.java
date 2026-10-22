package androidx.tracing;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class Trace {
    static final String TAG = "Trace";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    public static boolean isEnabled() {
        if (sIsTagEnabledMethod != null) goto L7;
        return android.os.Trace.isEnabled();
    L7:
        return isEnabledFallback();
    }

    public static void beginSection(String r0) {
        TraceApi18Impl.beginSection(r0);
    }

    public static void endSection() {
        TraceApi18Impl.endSection();
    }

    public static void beginAsyncSection(String r1, int r2) {
        if (sAsyncTraceBeginMethod != null) goto L6;
        TraceApi29Impl.beginAsyncSection(r1, r2);     // Catch: Throwable -> L8
        return;
    L6:
        beginAsyncSectionFallback(r1, r2);
    }

    public static void endAsyncSection(String r1, int r2) {
        if (sAsyncTraceEndMethod != null) goto L6;
        TraceApi29Impl.endAsyncSection(r1, r2);     // Catch: Throwable -> L8
        return;
    L6:
        endAsyncSectionFallback(r1, r2);
    }

    public static void setCounter(String r1, int r2) {
        if (sTraceCounterMethod != null) goto L6;
        TraceApi29Impl.setCounter(r1, r2);     // Catch: Throwable -> L8
        return;
    L6:
        setCounterFallback(r1, r2);
    }

    private static boolean isEnabledFallback() {
    L8:
        e = move-exception;
        handleException("isTagEnabled", e);
        return false;
    L4:
        if (sIsTagEnabledMethod != null) goto L6;
        sTraceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);     // Catch: Exception -> L8
        sIsTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});     // Catch: Exception -> L8
    L6:
        return ((Boolean) sIsTagEnabledMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp)})).booleanValue();
    }

    private static void beginAsyncSectionFallback(String r8, int r9) {
    L8:
        e = move-exception;
        handleException("asyncTraceBegin", e);
        return;
    L4:
        if (sAsyncTraceBeginMethod != null) goto L6;
        sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L8
    L6:
        sAsyncTraceBeginMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r8, Integer.valueOf(r9)});     // Catch: Exception -> L8
    }

    private static void endAsyncSectionFallback(String r8, int r9) {
    L8:
        e = move-exception;
        handleException("asyncTraceEnd", e);
        return;
    L4:
        if (sAsyncTraceEndMethod != null) goto L6;
        sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L8
    L6:
        sAsyncTraceEndMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r8, Integer.valueOf(r9)});     // Catch: Exception -> L8
    }

    private static void setCounterFallback(String r8, int r9) {
    L8:
        e = move-exception;
        handleException("traceCounter", e);
        return;
    L4:
        if (sTraceCounterMethod != null) goto L6;
        sTraceCounterMethod = android.os.Trace.class.getMethod("traceCounter", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L8
    L6:
        sTraceCounterMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r8, Integer.valueOf(r9)});     // Catch: Exception -> L8
    }

    private static void handleException(String r2, Exception r3) {
        if ((r3 instanceof InvocationTargetException) == false) goto L10;
        Throwable r4 = r3.getCause();
        if ((r4 instanceof RuntimeException) == false) goto L9;
        throw ((RuntimeException) r4);
    L9:
        throw new RuntimeException(r4);
    L10:
        Log.v(TAG, "Unable to call " + r2 + " via reflection", r3);
    }

    private Trace() {
    }
}
