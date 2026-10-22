package com.android.ttcjpaysdk.facelive.utils;

/* JADX INFO: loaded from: classes28.dex */
public final class CJPayFaceLangUtils {
    public static final int HASH_OFFSET = 37;
    public static final int HASH_SEED = 17;

    public static int hashCode(int r100, int r101) {
        return (r100 * 37) + r101;
    }

    private CJPayFaceLangUtils() {
    }

    public static boolean equals(Object r100, Object r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r100.equals(r101);
    }

    public static int hashCode(int r100, Object r101) {
        if (r101 == null) goto L4;
        int r102 = r101.hashCode();
    L6:
        return hashCode(r100, r102);
    L4:
        r102 = 0;
        goto L6
    }
}
