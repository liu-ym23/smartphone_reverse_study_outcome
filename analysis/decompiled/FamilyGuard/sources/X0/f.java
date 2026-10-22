package X0;

import android.os.SystemClock;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final double f5790a = 1.0d / Math.pow(10.0d, 6.0d);

    public static double a(long j5) {
        return (b() - j5) * f5790a;
    }

    public static long b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
