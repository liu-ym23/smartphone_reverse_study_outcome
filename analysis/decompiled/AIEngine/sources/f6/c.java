package f6;

import android.os.SystemClock;
import com.stepos.base.model.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile int f8764a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static volatile long f8765b = Long.MIN_VALUE;

    public static int a(boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && f8764a >= 0 && jElapsedRealtime - f8765b < 1000) {
            return f8764a;
        }
        b.C0044b c0044bE = com.stepos.base.model.b.f6348a.e();
        long j10 = c0044bE.f6355a;
        if (j10 < 0 && c0044bE.f6356b < 0) {
            return -1;
        }
        long jMax = Math.max(c0044bE.f6356b, 0L) + Math.max(j10, 0L);
        if (jMax > 2147483647L) {
            jMax = 2147483647L;
        }
        int i10 = (int) jMax;
        f8764a = i10;
        f8765b = jElapsedRealtime;
        return i10;
    }
}
