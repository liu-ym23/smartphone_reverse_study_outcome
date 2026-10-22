package androidx.collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f1206a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long[] f1207b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object[] f1208c = null;

    static {
        f1206a = new int[0];
        f1207b = new long[0];
        f1208c = new Object[0];
    }

    public static int a(int[] r10, int r11, int r12) {
        int r13 = r11 - 1;
        int r14 = 0;
    L3:
        if (r14 > r13) goto L11;
        int r15 = (r14 + r13) >>> 1;
        int r16 = r10[r15];
        if (r16 < r12) goto L6;
        if (r16 <= r12) goto L9;
        r13 = r15 - 1;
        goto L3
    L9:
        return r15;
    L6:
        r14 = r15 + 1;
        goto L3
    L11:
        return ~r14;
    }

    public static int b(long[] r10, int r11, long r12) {
        int r13 = r11 - 1;
        int r14 = 0;
    L3:
        if (r14 > r13) goto L11;
        int r15 = (r14 + r13) >>> 1;
        long r16 = r10[r15];
        if (r16 < r12) goto L6;
        if (r16 <= r12) goto L9;
        r13 = r15 - 1;
        goto L3
    L9:
        return r15;
    L6:
        r14 = r15 + 1;
        goto L3
    L11:
        return ~r14;
    }

    public static boolean c(Object r10, Object r11) {
        if (r10 == r11) goto L8;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals(r11) == false) goto L7;
    L8:
        return true;
    }

    public static int d(int r10) {
        int r11 = 4;
    L4:
        if (r11 >= 32) goto L9;
        int r12 = (1 << r11) - 12;
        if (r10 <= r12) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r12;
    L9:
        return r10;
    }

    public static int e(int r10) {
        return d(r10 * 4) / 4;
    }

    public static int f(int r10) {
        return d(r10 * 8) / 8;
    }
}
