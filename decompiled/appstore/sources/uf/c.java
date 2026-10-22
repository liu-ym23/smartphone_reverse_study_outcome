package uf;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public static final int a(int r10, int r11, int r12) {
        return e(e(r10, r12) - e(r11, r12), r12);
    }

    public static final long b(long r10, long r11, long r12) {
        return f(f(r10, r12) - f(r11, r12), r12);
    }

    public static final int c(int r10, int r11, int r12) {
        if (r12 <= 0) goto L6;
        if (r10 < r11) goto L13;
        return r11;
    L13:
        return r11 - a(r11, r10, r12);
    L6:
        if (r12 >= 0) goto L12;
        if (r10 > r11) goto L10;
        return r11;
    L10:
        return r11 + a(r10, r11, -r12);
    L12:
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final long d(long r10, long r11, long r12) {
        if (r12 > 0) goto L5;
        if (r12 >= 0) goto L15;
        if (r10 > r11) goto L13;
        return r11;
    L13:
        return r11 + b(r10, r11, -r12);
    L15:
        throw new IllegalArgumentException("Step is zero.");
    L5:
        if (r10 < r11) goto L16;
        return r11;
    L16:
        return r11 - b(r11, r10, r12);
    }

    public static final int e(int r10, int r11) {
        int r12 = r10 % r11;
        if (r12 < 0) goto L6;
        return r12;
    L6:
        return r12 + r11;
    }

    public static final long f(long r10, long r11) {
        long r12 = r10 % r11;
        if (r12 < 0) goto L6;
        return r12;
    L6:
        return r12 + r11;
    }
}
