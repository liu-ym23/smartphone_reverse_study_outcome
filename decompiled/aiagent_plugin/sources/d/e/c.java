package d.e;

/* JADX INFO: compiled from: progressionUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static final int a(int r0, int r1) {
        int r2 = r0 % r1;
        if (r2 < 0) goto L6;
        return r2;
    L6:
        return r2 + r1;
    }

    private static final long a(long r2, long r4) {
        long r3 = r2 % r4;
        if (r3 < 0) goto L6;
        return r3;
    L6:
        return r3 + r4;
    }

    private static final int b(int r0, int r1, int r2) {
        return a(a(r0, r2) - a(r1, r2), r2);
    }

    private static final long b(long r0, long r2, long r4) {
        return a(a(r0, r4) - a(r2, r4), r4);
    }

    public static final int a(int r0, int r1, int r2) {
        if (r2 <= 0) goto L6;
        if (r0 < r1) goto L13;
        return r1;
    L13:
        return r1 - b(r1, r0, r2);
    L6:
        if (r2 >= 0) goto L12;
        if (r0 > r1) goto L10;
        return r1;
    L10:
        return r1 + b(r0, r1, -r2);
    L12:
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final long a(long r7, long r9, long r11) {
        if (r11 > 0) goto L5;
        if (r11 >= 0) goto L15;
        if (r7 > r9) goto L13;
        return r9;
    L13:
        return r9 + b(r7, r9, -r11);
    L15:
        throw new IllegalArgumentException("Step is zero.");
    L5:
        if (r7 < r9) goto L16;
        return r9;
    L16:
        return r9 - b(r9, r7, r11);
    }
}
