package com.android.server.utils;

import android.util.ArraySet;
import android.util.SparseSetArray;

/* JADX INFO: loaded from: classes3.dex */
public class WatchedSparseSetArray<T> extends WatchableImpl implements Snappable {
    private final SparseSetArray mStorage;

    private void onChanged() {
        dispatchChange(this);
    }

    public WatchedSparseSetArray() {
        this.mStorage = new SparseSetArray();
    }

    public WatchedSparseSetArray(WatchedSparseSetArray<T> watchedSparseSetArray) {
        this.mStorage = new SparseSetArray(watchedSparseSetArray.untrackedStorage());
    }

    public WatchedSparseSetArray(SparseSetArray<T> sparseSetArray) {
        this.mStorage = sparseSetArray;
    }

    public SparseSetArray<T> untrackedStorage() {
        return this.mStorage;
    }

    public boolean add(int n, T value) {
        boolean res = this.mStorage.add(n, value);
        onChanged();
        return res;
    }

    public void addAll(int n, ArraySet<T> values) {
        this.mStorage.addAll(n, values);
        onChanged();
    }

    public void clear() {
        this.mStorage.clear();
        onChanged();
    }

    public boolean contains(int n, T value) {
        return this.mStorage.contains(n, value);
    }

    public ArraySet<T> get(int n) {
        return this.mStorage.get(n);
    }

    public boolean remove(int n, T value) {
        if (this.mStorage.remove(n, value) == false) goto L6;
        onChanged();
        return true;
    L6:
        return false;
    }

    public void remove(int n) {
        this.mStorage.remove(n);
        onChanged();
    }

    public int size() {
        return this.mStorage.size();
    }

    public int keyAt(int index) {
        return this.mStorage.keyAt(index);
    }

    public int sizeAt(int index) {
        return this.mStorage.sizeAt(index);
    }

    public T valueAt(int r2, int r3) {
        return (T) this.mStorage.valueAt(r2, r3);
    }

    public void copyFrom(SparseSetArray<T> c) {
        clear();
        int end = c.size();
        int i = 0;
    L3:
        if (i >= end) goto L5;
        int key = c.keyAt(i);
        ArraySet<T> set = c.get(key);
        this.mStorage.addAll(key, set);
        i = i + 1;
        goto L3
    L5:
        onChanged();
    }

    @Override // com.android.server.utils.Snappable
    public Object snapshot() {
        WatchedSparseSetArray l = new WatchedSparseSetArray(this);
        l.seal();
        return l;
    }

    public void snapshot(WatchedSparseSetArray<T> r) {
        snapshot(this, r);
    }

    public static void snapshot(WatchedSparseSetArray dst, WatchedSparseSetArray src) {
        if (dst.size() != 0) goto L13;
        int arraySize = src.size();
        int i = 0;
    L5:
        if (i >= arraySize) goto L10;
        ArraySet<T> r2 = src.get(i);
        int setSize = r2.size();
        int j = 0;
    L7:
        if (j >= setSize) goto L9;
        dst.mStorage.add(src.keyAt(i), r2.valueAt(j));
        j = j + 1;
        goto L7
    L9:
        i = i + 1;
        goto L5
    L10:
        dst.seal();
        return;
    L13:
        throw new IllegalArgumentException("snapshot destination is not empty");
    }
}
