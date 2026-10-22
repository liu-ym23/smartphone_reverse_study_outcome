package androidx.core.os;

import android.os.Trace;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    static class Api18Impl {
        private Api18Impl() {
        }

        static void beginSection(String r0) {
            Trace.beginSection(r0);
        }

        static void endSection() {
            Trace.endSection();
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static boolean isEnabled() {
            return Trace.isEnabled();
        }

        static void endAsyncSection(String r0, int r1) {
            Trace.endAsyncSection(r0, r1);
        }

        static void beginAsyncSection(String r0, int r1) {
            Trace.beginAsyncSection(r0, r1);
        }

        static void setCounter(String r0, long r1) {
            Trace.setCounter(r0, r1);
        }
    }

    static {
    }

    public static boolean isEnabled() {
        return Api29Impl.isEnabled();
    }

    public static void beginSection(String r0) {
        Api18Impl.beginSection(r0);
    }

    public static void endSection() {
        Api18Impl.endSection();
    }

    public static void beginAsyncSection(String r0, int r1) {
        Api29Impl.beginAsyncSection(r0, r1);
    }

    public static void endAsyncSection(String r0, int r1) {
        Api29Impl.endAsyncSection(r0, r1);
    }

    public static void setCounter(String r2, int r3) {
        Api29Impl.setCounter(r2, r3);
    }

    private TraceCompat() {
    }
}
