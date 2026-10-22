package com.bumptech.glide.f;

import android.os.Build;
import android.os.SystemClock;

/* JADX INFO: compiled from: LogTime.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double f3328a = 0.0d;

    static {
        double r1 = 1.0d;
        if (Build.VERSION.SDK_INT < 17) goto L5;
        r1 = 1.0d / Math.pow(10.0d, 6.0d);
    L5:
        f3328a = r1;
    }

    public static long a() {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return SystemClock.elapsedRealtimeNanos();
    L7:
        return SystemClock.uptimeMillis();
    }

    public static double a(long r2) {
        return (a() - r2) * f3328a;
    }
}
