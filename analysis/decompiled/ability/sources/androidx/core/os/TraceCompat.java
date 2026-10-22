package androidx.core.os;

import android.os.Trace;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

@Deprecated
/* loaded from: classes2.dex */
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void beginAsyncSection(String str, int i) {
            Trace.beginAsyncSection(str, i);
        }

        public static void endAsyncSection(String str, int i) {
            Trace.endAsyncSection(str, i);
        }

        public static boolean isEnabled() {
            return Trace.isEnabled();
        }

        public static void setCounter(String str, long j5) {
            Trace.setCounter(str, j5);
        }
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(String str, int i) {
        Api29Impl.beginAsyncSection(str, i);
    }

    public static void beginSection(String str) {
        Trace.beginSection(str);
    }

    public static void endAsyncSection(String str, int i) {
        Api29Impl.endAsyncSection(str, i);
    }

    public static void endSection() {
        Trace.endSection();
    }

    public static boolean isEnabled() {
        return Api29Impl.isEnabled();
    }

    public static void setCounter(String str, int i) {
        Api29Impl.setCounter(str, i);
    }
}
