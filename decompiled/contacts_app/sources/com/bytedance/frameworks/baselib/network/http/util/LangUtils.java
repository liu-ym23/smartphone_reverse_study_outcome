package com.bytedance.frameworks.baselib.network.http.util;

/* JADX INFO: loaded from: classes2.dex */
public final class LangUtils {
    public static final int HASH_OFFSET = 37;
    public static final int HASH_SEED = 17;

    public static int hashCode(int r0, int r1) {
        return (r0 * 37) + r1;
    }

    private LangUtils() {
    }

    public static int hashCode(int r0, boolean r1) {
        return hashCode(r0, r1 ? 1 : 0);
    }

    public static int hashCode(int r0, Object r1) {
        if (r1 == null) goto L4;
        int r2 = r1.hashCode();
    L6:
        return hashCode(r0, r2);
    L4:
        r2 = 0;
        goto L6
    }

    public static boolean equals(Object r0, Object r1) {
        if (r0 != null) goto L7;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r0.equals(r1);
    }

    public static boolean equals(Object[] r5, Object[] r6) {
        if (r5 != null) goto L7;
        if (r6 != null) goto L6;
        return true;
    L6:
        return false;
    L7:
        if (r6 != null) goto L9;
    L18:
        return false;
    L9:
        if (r5.length != r6.length) goto L18;
        int r2 = 0;
    L12:
        if (r2 >= r5.length) goto L17;
        if (equals(r5[r2], r6[r2]) == false) goto L15;
        r2 = r2 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    }
}
