package org.apache.http.util;

import java.util.Collection;

/* JADX INFO: loaded from: classes4.dex */
public class Args {
    public Args() {
    }

    public static void check(boolean r10, String r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r11);
    }

    public static <T extends CharSequence> T containsNoBlanks(T r10, String r11) {
        if (r10 == null) goto L13;
        if (r10.length() == 0) goto L11;
        if (TextUtils.containsBlanks(r10) == true) goto L9;
        return r10;
    L9:
        throw new IllegalArgumentException(r11 + " may not contain blanks");
    L11:
        throw new IllegalArgumentException(r11 + " may not be empty");
    L13:
        throw new IllegalArgumentException(r11 + " may not be null");
    }

    public static <T extends CharSequence> T notBlank(T r10, String r11) {
        if (r10 == null) goto L9;
        if (TextUtils.isBlank(r10) == true) goto L7;
        return r10;
    L7:
        throw new IllegalArgumentException(r11 + " may not be blank");
    L9:
        throw new IllegalArgumentException(r11 + " may not be null");
    }

    public static <T extends CharSequence> T notEmpty(T r10, String r11) {
        if (r10 == null) goto L9;
        if (TextUtils.isEmpty(r10) == true) goto L7;
        return r10;
    L7:
        throw new IllegalArgumentException(r11 + " may not be empty");
    L9:
        throw new IllegalArgumentException(r11 + " may not be null");
    }

    public static int notNegative(int r10, String r11) {
        if (r10 < 0) goto L5;
        return r10;
    L5:
        throw new IllegalArgumentException(r11 + " may not be negative");
    }

    public static <T> T notNull(T r10, String r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new IllegalArgumentException(r11 + " may not be null");
    }

    public static int positive(int r10, String r11) {
        if (r10 <= 0) goto L5;
        return r10;
    L5:
        throw new IllegalArgumentException(r11 + " may not be negative or zero");
    }

    public static void check(boolean r10, String r11, Object... r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(r11, r12));
    }

    public static long notNegative(long r10, String r11) {
        if (r10 < 0) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException(r11 + " may not be negative");
    }

    public static long positive(long r10, String r11) {
        if (r10 <= 0) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException(r11 + " may not be negative or zero");
    }

    public static void check(boolean r10, String r11, Object r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(r11, new Object[]{r12}));
    }

    public static <E, T extends Collection<E>> T notEmpty(T r10, String r11) {
        if (r10 == null) goto L9;
        if (r10.isEmpty() == true) goto L7;
        return r10;
    L7:
        throw new IllegalArgumentException(r11 + " may not be empty");
    L9:
        throw new IllegalArgumentException(r11 + " may not be null");
    }
}
