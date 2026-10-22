package com.bytedance.common.utility.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ArrayUtils {
    private ArrayUtils() {
    }

    public static long[] toLongArray(List<Long> r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        long[] r0 = new long[r4.size()];
        int r1 = 0;
    L7:
        if (r1 >= r4.size()) goto L9;
        r0[r1] = r4.get(r1).longValue();
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    public static List<Long> toList(long[] r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        r0.add(Long.valueOf(r5[r2]));
        r2 = r2 + 1;
        goto L6
    L8:
        return r0;
    }

    public static <T> T[] combineArray(T[] r3, T[] r4) {
        T[] r0 = (T[]) copyOfRange(r3, 0, r3.length + r4.length);
        System.arraycopy(r4, 0, r0, r3.length, r4.length);
        return r0;
    }

    public static <T> T[] insert(T[] r3, int r4, T r5) {
        T[] r0 = (T[]) ((Object[]) Array.newInstance(r3.getClass().getComponentType(), r3.length + 1));
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L11;
        if (r1 >= r4) goto L7;
        T r2 = r3[r1];
    L10:
        r0[r1] = r2;
        r1 = r1 + 1;
        goto L4
    L7:
        if (r1 != r4) goto L9;
        r2 = r5;
        goto L10
    L9:
        r2 = r3[r1 - 1];
        goto L10
    L11:
        return r0;
    }

    public static <T> T[] copyOfRange(T[] r2, int r3, int r4) {
        int r0 = r2.length;
        if (r3 > r4) goto L11;
        if (r3 < 0) goto L9;
        if (r3 > r0) goto L9;
        int r5 = r4 - r3;
        int r1 = Math.min(r5, r0 - r3);
        T[] r6 = (T[]) ((Object[]) Array.newInstance(r2.getClass().getComponentType(), r5));
        System.arraycopy(r2, r3, r6, 0, r1);
        return r6;
    L9:
        throw new ArrayIndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException();
    }
}
