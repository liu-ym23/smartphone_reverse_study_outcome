package androidx.core.util;

import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: Preconditions.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static void a(boolean r0) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static void a(boolean r0, Object r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r1));
    }

    public static <T> T a(T r0) {
        Objects.requireNonNull(r0);
        return r0;
    }

    public static <T> T a(T r0, Object r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(String.valueOf(r1));
    }

    public static void a(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(r1);
    }

    public static void b(boolean r1) {
        a(r1, null);
    }

    public static int a(int r3, int r4) {
        if ((r3 & r4) != r3) goto L6;
        return r3;
    L6:
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(r3) + ", but only 0x" + Integer.toHexString(r4) + " are allowed");
    }

    public static int a(int r0, String r1) {
        if (r0 < 0) goto L5;
        return r0;
    L5:
        throw new IllegalArgumentException(r1);
    }

    public static int a(int r0) {
        if (r0 < 0) goto L5;
        return r0;
    L5:
        throw new IllegalArgumentException();
    }

    public static int a(int r5, int r6, int r7, String r8) {
        if (r5 < r6) goto L9;
        if (r5 > r7) goto L7;
        return r5;
    L7:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{r8, Integer.valueOf(r6), Integer.valueOf(r7)}));
    L9:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{r8, Integer.valueOf(r6), Integer.valueOf(r7)}));
    }
}
