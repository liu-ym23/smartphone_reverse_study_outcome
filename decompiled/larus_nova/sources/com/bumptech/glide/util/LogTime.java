package com.bumptech.glide.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes39.dex */
public final class LogTime {
    private static final double MILLIS_MULTIPLIER = 0.0d;

    static {
        MILLIS_MULTIPLIER = 1.0d / Math.pow(10.0d, 6.0d);
    }

    public static long getLogTime() {
        return SystemClock.elapsedRealtimeNanos();
    }

    private LogTime() {
    }

    public static double getElapsedMillis(long r100) {
        return (getLogTime() - r100) * MILLIS_MULTIPLIER;
    }
}
