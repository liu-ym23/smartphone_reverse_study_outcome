package bg;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h extends g {
    public static double b(double r10, double r11) {
        if (r10 < r11) goto L5;
        return r10;
    L5:
        return r11;
    }

    public static float c(float r10, float r11) {
        if (r10 < r11) goto L5;
        return r10;
    L5:
        return r11;
    }

    public static int d(int r10, int r11) {
        if (r10 < r11) goto L4;
        return r10;
    L4:
        return r11;
    }

    public static long e(long r10, long r11) {
        if (r10 < r11) goto L5;
        return r10;
    L5:
        return r11;
    }

    public static float f(float r10, float r11) {
        if (r10 > r11) goto L5;
        return r10;
    L5:
        return r11;
    }

    public static int g(int r10, int r11) {
        if (r10 > r11) goto L4;
        return r10;
    L4:
        return r11;
    }

    public static long h(long r10, long r11) {
        if (r10 > r11) goto L5;
        return r10;
    L5:
        return r11;
    }

    public static double i(double r10, double r11, double r12) {
        if (r11 > r12) goto L12;
        if (r10 >= r11) goto L8;
        return r11;
    L8:
        if (r10 <= r12) goto L10;
        return r12;
    L10:
        return r10;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r12 + " is less than minimum " + r11 + '.');
    }

    public static float j(float r10, float r11, float r12) {
        if (r11 > r12) goto L12;
        if (r10 >= r11) goto L8;
        return r11;
    L8:
        if (r10 <= r12) goto L10;
        return r12;
    L10:
        return r10;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r12 + " is less than minimum " + r11 + '.');
    }

    public static int k(int r10, int r11, int r12) {
        if (r11 > r12) goto L9;
        if (r10 >= r11) goto L5;
        return r11;
    L5:
        if (r10 <= r12) goto L7;
        return r12;
    L7:
        return r10;
    L9:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r12 + " is less than minimum " + r11 + '.');
    }

    public static long l(long r10, long r11, long r12) {
        if (r11 > r12) goto L12;
        if (r10 >= r11) goto L8;
        return r11;
    L8:
        if (r10 <= r12) goto L10;
        return r12;
    L10:
        return r10;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r12 + " is less than minimum " + r11 + '.');
    }

    public static a m(int r10, int r11) {
        return a.f5997d.a(r10, r11, -1);
    }

    public static int n(c r10, Random r11) {
        q.g(r10, "<this>");
        q.g(r11, "random");
        return kotlin.random.d.f(r11, r10);
    L5:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    public static a o(a r10, int r11) {
        q.g(r10, "<this>");
        if (r11 <= 0) goto L5;
        boolean r12 = true;
    L6:
        g.a(r12, Integer.valueOf(r11));
        a.C0067a r13 = a.f5997d;
        int r14 = r10.a();
        int r15 = r10.b();
        if (r10.c() > 0) goto L11;
        r11 = -r11;
    L11:
        return r13.a(r14, r15, r11);
    L5:
        r12 = false;
        goto L6
    }

    public static c p(int r10, int r11) {
        if (r11 > Integer.MIN_VALUE) goto L7;
        return c.f6005e.a();
    L7:
        return new c(r10, r11 - 1);
    }
}
