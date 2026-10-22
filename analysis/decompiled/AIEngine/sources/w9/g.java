package w9;

import android.os.Process;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static long f13620b = -1;

    /* renamed from: d, reason: collision with root package name */
    public static long f13622d;

    /* renamed from: a, reason: collision with root package name */
    public static final g f13619a = new g();

    /* renamed from: c, reason: collision with root package name */
    public static final int f13621c = Process.myPid();

    public final synchronized long a() {
        long jCurrentTimeMillis;
        try {
            jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis < f13620b) {
                f13620b = jCurrentTimeMillis;
            }
            if (f13620b == jCurrentTimeMillis) {
                long j10 = (f13622d + 1) & 3;
                f13622d = j10;
                if (j10 == 0) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    while (jCurrentTimeMillis2 <= jCurrentTimeMillis) {
                        jCurrentTimeMillis2 = System.currentTimeMillis();
                    }
                    jCurrentTimeMillis = jCurrentTimeMillis2;
                }
            } else {
                f13622d = 0L;
            }
            f13620b = jCurrentTimeMillis;
        } catch (Throwable th) {
            throw th;
        }
        return ((jCurrentTimeMillis - 1498608000000L) << 2) | (f13621c << 40) | f13622d;
    }
}
