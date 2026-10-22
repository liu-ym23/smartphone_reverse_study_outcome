package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static long a(long r10, long r11) {
        long r12 = r10 + r11;
        if (r12 >= 0) goto L6;
        return Long.MAX_VALUE;
    L6:
        return r12;
    }

    public static long b(AtomicLong r10, long r11) {
    L2:
        long r12 = r10.get();
        if (r10.compareAndSet(r12, a(r12, r11)) == false) goto L2;
        return r12;
    }

    public static long c(AtomicLong r10, long r11) {
    L2:
        long r12 = r10.get();
        if (r12 == Long.MAX_VALUE) goto L4;
        long r13 = r12 - r11;
        if (r13 < 0) goto L11;
        if (r10.compareAndSet(r12, r13) == false) goto L2;
        return r13;
    L11:
        throw new IllegalStateException("More produced than requested: " + r13);
    L4:
        return Long.MAX_VALUE;
    }

    public static boolean d(long r10) {
        if (r10 < 0) goto L9;
        if (r10 == 0) goto L6;
        return true;
    L6:
        return false;
    L9:
        throw new IllegalArgumentException("n >= 0 required but it was " + r10);
    }
}
