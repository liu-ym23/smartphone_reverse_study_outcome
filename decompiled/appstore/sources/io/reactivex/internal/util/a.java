package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static long a(AtomicLong r10, long r11) {
    L2:
        long r12 = r10.get();
        if (r12 == Long.MAX_VALUE) goto L4;
        if (r10.compareAndSet(r12, c(r12, r11)) == false) goto L2;
        return r12;
    L4:
        return Long.MAX_VALUE;
    }

    public static long b(AtomicLong r10, long r11) {
    L2:
        long r12 = r10.get();
        if (r12 == Long.MIN_VALUE) goto L4;
        if (r12 == Long.MAX_VALUE) goto L7;
        if (r10.compareAndSet(r12, c(r12, r11)) == false) goto L2;
        return r12;
    L7:
        return Long.MAX_VALUE;
    L4:
        return Long.MIN_VALUE;
    }

    public static long c(long r10, long r11) {
        long r12 = r10 + r11;
        if (r12 >= 0) goto L6;
        return Long.MAX_VALUE;
    L6:
        return r12;
    }

    public static long d(long r10, long r11) {
        long r12 = r10 * r11;
        if (((r10 | r11) >>> 31) != 0) goto L5;
    L8:
        return r12;
    L5:
        if ((r12 / r10) == r11) goto L8;
        return Long.MAX_VALUE;
    }

    public static long e(AtomicLong r10, long r11) {
    L2:
        long r12 = r10.get();
        if (r12 == Long.MAX_VALUE) goto L4;
        long r13 = r12 - r11;
        if (r13 >= 0) goto L9;
        qf.a.e(new IllegalStateException("More produced than requested: " + r13));
        r13 = 0;
    L9:
        if (r10.compareAndSet(r12, r13) == false) goto L2;
        return r13;
    L4:
        return Long.MAX_VALUE;
    }

    public static long f(AtomicLong r10, long r11) {
    L2:
        long r12 = r10.get();
        if (r12 == Long.MIN_VALUE) goto L4;
        if (r12 == Long.MAX_VALUE) goto L7;
        long r13 = r12 - r11;
        if (r13 >= 0) goto L12;
        qf.a.e(new IllegalStateException("More produced than requested: " + r13));
        r13 = 0;
    L12:
        if (r10.compareAndSet(r12, r13) == false) goto L2;
        return r13;
    L7:
        return Long.MAX_VALUE;
    L4:
        return Long.MIN_VALUE;
    }
}
