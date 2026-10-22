package androidx.core.util;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static void a(boolean r10) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static void b(boolean r10, Object r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r11));
    }

    public static int c(int r10, int r11, int r12, String r13) {
        if (r10 < r11) goto L8;
        if (r10 > r12) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{r13, Integer.valueOf(r11), Integer.valueOf(r12)}));
    L8:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{r13, Integer.valueOf(r11), Integer.valueOf(r12)}));
    }

    public static int d(int r10) {
        if (r10 < 0) goto L5;
        return r10;
    L5:
        throw new IllegalArgumentException();
    }

    public static int e(int r10, String r11) {
        if (r10 < 0) goto L5;
        return r10;
    L5:
        throw new IllegalArgumentException(r11);
    }

    public static int f(int r10, int r11) {
        if ((r10 & r11) != r10) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(r10) + ", but only 0x" + Integer.toHexString(r11) + " are allowed");
    }

    public static Object g(Object r10) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw null;
    }

    public static Object h(Object r10, Object r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(String.valueOf(r11));
    }

    public static void i(boolean r10, String r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(r11);
    }
}
