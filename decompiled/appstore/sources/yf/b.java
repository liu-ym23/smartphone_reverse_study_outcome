package yf;

import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends a {
    public static int a(double r10) {
        if (Double.isNaN(r10) == true) goto L13;
        if (r10 <= 2.147483647E9d) goto L8;
        return Channel.UNLIMITED;
    L8:
        if (r10 >= (-2.147483648E9d)) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) Math.round(r10);
    L13:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static int b(float r10) {
        if (Float.isNaN(r10) == true) goto L7;
        return Math.round(r10);
    L7:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static final long c(double r10) {
        if (Double.isNaN(r10) == true) goto L7;
        return Math.round(r10);
    L7:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static long d(float r10) {
        return c(r10);
    }
}
