package org.apache.http.util;

/* JADX INFO: loaded from: classes4.dex */
public final class LangUtils {
    public static final int HASH_OFFSET = 37;
    public static final int HASH_SEED = 17;

    private LangUtils() {
    }

    public static boolean equals(Object r10, Object r11) {
        if (r10 != null) goto L7;
        if (r11 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r10.equals(r11);
    }

    public static int hashCode(int r10, int r11) {
        return (r10 * 37) + r11;
    }

    public static boolean equals(Object[] r10, Object[] r11) {
        if (r10 != null) goto L8;
        if (r11 != null) goto L7;
        return true;
    L7:
        return false;
    L8:
        if (r11 != null) goto L10;
    L19:
        return false;
    L10:
        if (r10.length != r11.length) goto L19;
        int r12 = 0;
    L13:
        if (r12 >= r10.length) goto L18;
        if (equals(r10[r12], r11[r12]) == false) goto L16;
        r12 = r12 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    }

    public static int hashCode(int r10, boolean r11) {
        return hashCode(r10, r11 ? 1 : 0);
    }

    public static int hashCode(int r10, Object r11) {
        if (r11 == null) goto L4;
        int r12 = r11.hashCode();
    L6:
        return hashCode(r10, r12);
    L4:
        r12 = 0;
        goto L6
    }
}
