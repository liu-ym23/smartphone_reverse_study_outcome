package R3;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class c {
    public static long a(AtomicLong atomicLong, long j5) {
        long j6;
        do {
            j6 = atomicLong.get();
            if (j6 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j6, c(j6, j5)));
        return j6;
    }

    public static long b(AtomicLong atomicLong, long j5) {
        long j6;
        do {
            j6 = atomicLong.get();
            if (j6 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j6 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j6, c(j6, j5)));
        return j6;
    }

    public static long c(long j5, long j6) {
        long j7 = j5 + j6;
        if (j7 < 0) {
            return Long.MAX_VALUE;
        }
        return j7;
    }

    public static long d(AtomicLong atomicLong, long j5) {
        long j6;
        long j7;
        do {
            j6 = atomicLong.get();
            if (j6 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j7 = j6 - j5;
            if (j7 < 0) {
                S3.a.r(new IllegalStateException("More produced than requested: " + j7));
                j7 = 0L;
            }
        } while (!atomicLong.compareAndSet(j6, j7));
        return j7;
    }
}
