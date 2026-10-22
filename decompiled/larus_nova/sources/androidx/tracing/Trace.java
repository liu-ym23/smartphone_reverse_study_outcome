package androidx.tracing;

import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class Trace {
    static final int MAX_TRACE_LABEL_LENGTH = 127;
    static final String TAG = "Trace";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static boolean sHasAppTracingEnabled;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    public static boolean isEnabled() {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return TraceApi29Impl.isEnabled();
    L7:
        return isEnabledFallback();
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

    public static void forceEnableAppTracing() {
        if (Build.VERSION.SDK_INT >= 31) goto L13;
    L8:
        e = move-exception;
        handleException("setAppTracingAllowed", e);
        return;
    L5:
        if (sHasAppTracingEnabled == true) goto L14;
        sHasAppTracingEnabled = true;     // Catch: Exception -> L8
        android.os.Trace.class.getMethod("setAppTracingAllowed", new Class[]{Boolean.TYPE}).invoke(null, new Object[]{Boolean.TRUE});     // Catch: Exception -> L8
        return;
    L14:
        return;
    }

    private Trace() {
    }

    public static void endSection() {
        TraceApi18Impl.endSection();
    }

    public static void beginSection(String r100) {
        TraceApi18Impl.beginSection(truncatedTraceSectionLabel(r100));
    }

    private static String truncatedTraceSectionLabel(String r100) {
        if (r100.length() > 127) goto L6;
        return r100;
    L6:
        return r100.substring(0, 127);
    }

    public static void beginAsyncSection(String r100, int r101) {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        TraceApi29Impl.beginAsyncSection(truncatedTraceSectionLabel(r100), r101);
        return;
    L5:
        beginAsyncSectionFallback(truncatedTraceSectionLabel(r100), r101);
    }

    private static void beginAsyncSectionFallback(String r100, int r101) {
    L8:
        e = move-exception;
        handleException("asyncTraceBegin", e);
        return;
    L4:
        if (sAsyncTraceBeginMethod != null) goto L6;
        sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L8
    L6:
        sAsyncTraceBeginMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r100, Integer.valueOf(r101)});     // Catch: Exception -> L8
    }

    public static void endAsyncSection(String r100, int r101) {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        TraceApi29Impl.endAsyncSection(truncatedTraceSectionLabel(r100), r101);
        return;
    L5:
        endAsyncSectionFallback(truncatedTraceSectionLabel(r100), r101);
    }

    private static void endAsyncSectionFallback(String r100, int r101) {
    L8:
        e = move-exception;
        handleException("asyncTraceEnd", e);
        return;
    L4:
        if (sAsyncTraceEndMethod != null) goto L6;
        sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L8
    L6:
        sAsyncTraceEndMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r100, Integer.valueOf(r101)});     // Catch: Exception -> L8
    }

    private static void handleException(String r100, Exception r101) {
        if ((r101 instanceof InvocationTargetException) == false) goto L11;
        Throwable r102 = r101.getCause();
        if ((r102 instanceof RuntimeException) == false) goto L9;
        throw ((RuntimeException) r102);
    L9:
        throw new RuntimeException(r102);
    }

    public static void setCounter(String r100, int r101) {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        TraceApi29Impl.setCounter(truncatedTraceSectionLabel(r100), r101);
        return;
    L5:
        setCounterFallback(truncatedTraceSectionLabel(r100), r101);
    }

    private static void setCounterFallback(String r100, int r101) {
    L8:
        e = move-exception;
        handleException("traceCounter", e);
        return;
    L4:
        if (sTraceCounterMethod != null) goto L6;
        sTraceCounterMethod = android.os.Trace.class.getMethod("traceCounter", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L8
    L6:
        sTraceCounterMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp), r100, Integer.valueOf(r101)});     // Catch: Exception -> L8
    }
}
