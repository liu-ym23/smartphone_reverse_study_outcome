package com.stepos.perf.nativecode;

import android.util.Log;

/* loaded from: classes.dex */
public final class GcPendingHelper {
    public static final int DEFAULT_MAX_BLOCK_MS = 2000;
    private static final String TAG = "GcPendingHelper";

    public static native int nativeDisable();

    public static native int nativeEnable(String str, int i);

    public static native long[] nativeGetStats();

    public static native int nativeInit();

    public static native boolean nativeIsAvailable();

    public static native int nativeUpdate(String str, int i);

    static {
        try {
            System.loadLibrary("gcpending");
            Log.i(TAG, "GC 抑制库加载成功");
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "GC 抑制库加载失败", e);
        }
    }

    private GcPendingHelper() {
    }

    public static boolean init() {
        return nativeInit() == 0;
    }

    public static boolean isAvailable() {
        return nativeIsAvailable();
    }

    public static boolean enable(String reason, int maxBlockMs) {
        boolean ok = nativeEnable(reason, maxBlockMs) == 0;
        if (ok) {
            Log.i(TAG, "GC 抑制开启: reason=" + reason + ", maxBlockMs=" + maxBlockMs);
        } else {
            Log.e(TAG, "GC 抑制开启失败");
        }
        return ok;
    }

    public static boolean enable(String reason) {
        return enable(reason, DEFAULT_MAX_BLOCK_MS);
    }

    public static boolean enable() {
        return enable("未指定原因", DEFAULT_MAX_BLOCK_MS);
    }

    public static boolean disable() {
        boolean ok = nativeDisable() == 0;
        if (ok) {
            Log.i(TAG, "GC 抑制关闭");
        } else {
            Log.e(TAG, "GC 抑制关闭失败");
        }
        return ok;
    }

    public static boolean update(String reason, int maxBlockMs) {
        return nativeUpdate(reason, maxBlockMs) == 0;
    }

    public static final class Stats {
        public final long pendingFlushed;
        public final long runBlocked;
        public final long runForceReleased;
        public final long runInvocations;
        public final long suppressedRequests;
        public final long totalRequests;

        public Stats(long totalRequests, long suppressedRequests, long runInvocations, long runBlocked, long runForceReleased, long pendingFlushed) {
            this.totalRequests = totalRequests;
            this.suppressedRequests = suppressedRequests;
            this.runInvocations = runInvocations;
            this.runBlocked = runBlocked;
            this.runForceReleased = runForceReleased;
            this.pendingFlushed = pendingFlushed;
        }
    }

    public static Stats stats() {
        long[] a = nativeGetStats();
        return new Stats(get(a, 0), get(a, 1), get(a, 2), get(a, 3), get(a, 4), get(a, 5));
    }

    private static long get(long[] a, int i) {
        if (a == null || i >= a.length) {
            return 0L;
        }
        return a[i];
    }
}
