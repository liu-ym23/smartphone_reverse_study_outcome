package org.apache.http.util;

/* JADX INFO: loaded from: classes4.dex */
public class Asserts {
    public Asserts() {
    }

    public static void check(boolean r10, String r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(r11);
    }

    public static void notBlank(CharSequence r10, String r11) {
        if (TextUtils.isBlank(r10) == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(r11 + " is blank");
    }

    public static void notEmpty(CharSequence r10, String r11) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(r11 + " is empty");
    }

    public static void notNull(Object r10, String r11) {
        if (r10 == null) goto L5;
        return;
    L5:
        throw new IllegalStateException(r11 + " is null");
    }

    public static void check(boolean r10, String r11, Object... r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.format(r11, r12));
    }

    public static void check(boolean r10, String r11, Object r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.format(r11, new Object[]{r12}));
    }
}
