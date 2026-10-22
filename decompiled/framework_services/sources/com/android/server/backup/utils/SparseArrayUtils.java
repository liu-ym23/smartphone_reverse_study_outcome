package com.android.server.backup.utils;

import android.util.SparseArray;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class SparseArrayUtils {
    private SparseArrayUtils() {
    }

    public static <V> HashSet<V> union(SparseArray<HashSet<V>> sets) {
        HashSet<V> unionSet = new HashSet();
        int n = sets.size();
        int i = 0;
    L3:
        if (i >= n) goto L9;
        HashSet<V> ithSet = sets.valueAt(i);
        if (ithSet == null) goto L7;
        unionSet.addAll(ithSet);
    L7:
        i = i + 1;
        goto L3
    L9:
        return unionSet;
    }
}
