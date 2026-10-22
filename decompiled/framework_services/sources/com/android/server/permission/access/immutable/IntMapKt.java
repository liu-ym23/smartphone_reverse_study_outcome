package com.android.server.permission.access.immutable;

import android.util.SparseArray;

/* JADX INFO: compiled from: IntMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntMapKt {
    public static final <T> T putReturnOld(SparseArray<T> r2, int key, T r4) {
        int index = r2.indexOfKey(key);
        if (index < 0) goto L5;
        T r1 = r2.valueAt(index);
        r2.setValueAt(index, r4);
        return r1;
    L5:
        r2.put(key, r4);
        return null;
    }

    public static final <T> T removeAtReturnOld(SparseArray<T> r1, int index) {
        T r0 = r1.valueAt(index);
        r1.removeAt(index);
        return r0;
    }

    public static final <T> void gc(SparseArray<T> r0) {
        r0.size();
    }
}
