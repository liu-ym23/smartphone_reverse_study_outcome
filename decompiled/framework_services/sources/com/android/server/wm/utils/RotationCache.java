package com.android.server.wm.utils;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes3.dex */
public class RotationCache<T, R> {
    private final SparseArray<R> mCache;
    private T mCachedFor;
    private final RotationDependentComputation<T, R> mComputation;

    @FunctionalInterface
    public interface RotationDependentComputation<T, R> {
        R compute(T r1, int r2);
    }

    public RotationCache(RotationDependentComputation<T, R> computation) {
        this.mCache = new SparseArray(4);
        this.mComputation = computation;
    }

    public R getOrCompute(T t, int rotation) {
        if (t == this.mCachedFor) goto L5;
        this.mCache.clear();
        this.mCachedFor = t;
    L5:
        int idx = this.mCache.indexOfKey(rotation);
        if (idx >= 0) goto L8;
        R result = this.mComputation.compute(t, rotation);
        this.mCache.put(rotation, result);
        return result;
    L8:
        return this.mCache.valueAt(idx);
    }
}
