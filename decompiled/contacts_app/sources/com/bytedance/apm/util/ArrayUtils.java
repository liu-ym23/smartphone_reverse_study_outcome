package com.bytedance.apm.util;

/* JADX INFO: loaded from: classes2.dex */
public class ArrayUtils {
    public ArrayUtils() {
    }

    public static int indexOfFirst(Object[] r4, Class<?> r5) {
        if (r4 != null) goto L5;
    L15:
        return -1;
    L5:
        if (r4.length == 0) goto L15;
        int r1 = r4.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L15;
        Object r3 = r4[r2];
        if (r3 == null) goto L14;
        if (r3.getClass().equals(r5) == false) goto L14;
        return r2;
    L14:
        r2 = r2 + 1;
        goto L8
    }
}
