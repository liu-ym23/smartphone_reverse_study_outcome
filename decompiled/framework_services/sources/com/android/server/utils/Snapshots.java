package com.android.server.utils;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.SparseSetArray;

/* JADX INFO: loaded from: classes3.dex */
public class Snapshots {
    public Snapshots() {
    }

    public static <T> T maybeSnapshot(T r1) {
        if ((r1 instanceof Snappable) == true) goto L5;
        return r1;
    L5:
        return (T) ((Snappable) r1).snapshot();
    }

    public static <E> void copy(SparseArray<E> dst, SparseArray<E> src) {
        if (dst.size() != 0) goto L10;
        int end = src.size();
        int i = 0;
    L5:
        if (i >= end) goto L8;
        dst.put(src.keyAt(i), src.valueAt(i));
        i = i + 1;
        goto L5
    L8:
        return;
    L10:
        throw new IllegalArgumentException("copy destination is not empty");
    }

    public static <E> void copy(SparseSetArray<E> dst, SparseSetArray<E> src) {
        if (dst.size() != 0) goto L13;
        int end = src.size();
        int i = 0;
    L5:
        if (i >= end) goto L11;
        int size = src.sizeAt(i);
        int j = 0;
    L7:
        if (j >= size) goto L9;
        dst.add(src.keyAt(i), src.valueAt(i, j));
        j = j + 1;
        goto L7
    L9:
        i = i + 1;
        goto L5
    L11:
        return;
    L13:
        throw new IllegalArgumentException("copy destination is not empty");
    }

    public static void snapshot(SparseIntArray dst, SparseIntArray src) {
        if (dst.size() != 0) goto L10;
        int end = src.size();
        int i = 0;
    L5:
        if (i >= end) goto L8;
        dst.put(src.keyAt(i), src.valueAt(i));
        i = i + 1;
        goto L5
    L8:
        return;
    L10:
        throw new IllegalArgumentException("snapshot destination is not empty");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E extends Snappable<E>> void snapshot(SparseArray<E> r4, SparseArray<E> src) {
        if (r4.size() != 0) goto L10;
        int end = src.size();
        int i = 0;
    L5:
        if (i >= end) goto L8;
        r4.put(src.keyAt(i), (Snappable) src.valueAt(i).snapshot());
        i = i + 1;
        goto L5
    L8:
        return;
    L10:
        throw new IllegalArgumentException("snapshot destination is not empty");
    }

    public static <E extends Snappable<E>> void snapshot(SparseSetArray<E> dst, SparseSetArray<E> src) {
        if (dst.size() != 0) goto L13;
        int end = src.size();
        int i = 0;
    L5:
        if (i >= end) goto L11;
        int size = src.sizeAt(i);
        int j = 0;
    L7:
        if (j >= size) goto L9;
        dst.add(src.keyAt(i), (Snappable) ((Snappable) src.valueAt(i, j)).snapshot());
        j = j + 1;
        goto L7
    L9:
        i = i + 1;
        goto L5
    L11:
        return;
    L13:
        throw new IllegalArgumentException("snapshot destination is not empty");
    }
}
