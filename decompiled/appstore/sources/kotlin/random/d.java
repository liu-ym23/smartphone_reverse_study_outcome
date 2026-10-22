package kotlin.random;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {
    public static final String a(Object r10, Object r11) {
        q.g(r10, "from");
        q.g(r11, "until");
        return "Random range is empty: [" + r10 + ", " + r11 + ").";
    }

    public static final void b(double r10, double r11) {
        if (r11 <= r10) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(a(Double.valueOf(r10), Double.valueOf(r11)).toString());
    }

    public static final void c(int r10, int r11) {
        if (r11 <= r10) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(a(Integer.valueOf(r10), Integer.valueOf(r11)).toString());
    }

    public static final void d(long r10, long r11) {
        if (r11 <= r10) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(a(Long.valueOf(r10), Long.valueOf(r11)).toString());
    }

    public static final int e(int r10) {
        return 31 - Integer.numberOfLeadingZeros(r10);
    }

    public static final int f(Random r10, bg.c r11) {
        q.g(r10, "<this>");
        q.g(r11, "range");
        if (r11.isEmpty() == true) goto L13;
        if (r11.b() >= Integer.MAX_VALUE) goto L8;
        return r10.nextInt(r11.a(), r11.b() + 1);
    L8:
        if (r11.a() <= Integer.MIN_VALUE) goto L11;
        return r10.nextInt(r11.a() - 1, r11.b()) + 1;
    L11:
        return r10.nextInt();
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r11);
    }

    public static final int g(int r10, int r11) {
        return (r10 >>> (32 - r11)) & ((-r11) >> 31);
    }
}
