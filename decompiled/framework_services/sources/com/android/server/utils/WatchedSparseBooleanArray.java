package com.android.server.utils;

import android.util.SparseBooleanArray;

/* JADX INFO: loaded from: classes3.dex */
public class WatchedSparseBooleanArray extends WatchableImpl implements Snappable {
    private final SparseBooleanArray mStorage;

    @Override // com.android.server.utils.Snappable
    public /* bridge */ /* synthetic */ Object snapshot() {
        return snapshot();
    }

    private void onChanged() {
        dispatchChange(this);
    }

    public WatchedSparseBooleanArray() {
        this.mStorage = new SparseBooleanArray();
    }

    public WatchedSparseBooleanArray(int initialCapacity) {
        this.mStorage = new SparseBooleanArray(initialCapacity);
    }

    public WatchedSparseBooleanArray(SparseBooleanArray c) {
        this.mStorage = c.clone();
    }

    public WatchedSparseBooleanArray(WatchedSparseBooleanArray r) {
        this.mStorage = r.mStorage.clone();
    }

    public void copyFrom(SparseBooleanArray src) {
        clear();
        int end = src.size();
        int i = 0;
    L3:
        if (i >= end) goto L6;
        put(src.keyAt(i), src.valueAt(i));
        i = i + 1;
        goto L3
    }

    public void copyTo(SparseBooleanArray dst) {
        dst.clear();
        int end = size();
        int i = 0;
    L3:
        if (i >= end) goto L6;
        dst.put(keyAt(i), valueAt(i));
        i = i + 1;
        goto L3
    }

    public SparseBooleanArray untrackedStorage() {
        return this.mStorage;
    }

    public boolean get(int key) {
        return this.mStorage.get(key);
    }

    public boolean get(int key, boolean valueIfKeyNotFound) {
        return this.mStorage.get(key, valueIfKeyNotFound);
    }

    public void delete(int key) {
        this.mStorage.delete(key);
        onChanged();
    }

    public void removeAt(int index) {
        this.mStorage.removeAt(index);
        onChanged();
    }

    public void put(int key, boolean value) {
        this.mStorage.put(key, value);
        onChanged();
    }

    public int size() {
        return this.mStorage.size();
    }

    public int keyAt(int index) {
        return this.mStorage.keyAt(index);
    }

    public boolean valueAt(int index) {
        return this.mStorage.valueAt(index);
    }

    public void setValueAt(int index, boolean value) {
        if (this.mStorage.valueAt(index) == value) goto L6;
        this.mStorage.setValueAt(index, value);
        onChanged();
        return;
    }

    public void setKeyAt(int index, int key) {
        if (this.mStorage.keyAt(index) == key) goto L6;
        this.mStorage.setKeyAt(index, key);
        onChanged();
        return;
    }

    public int indexOfKey(int key) {
        return this.mStorage.indexOfKey(key);
    }

    public int indexOfValue(boolean value) {
        return this.mStorage.indexOfValue(value);
    }

    public void clear() {
        this.mStorage.clear();
        onChanged();
    }

    public void append(int key, boolean value) {
        this.mStorage.append(key, value);
        onChanged();
    }

    public int hashCode() {
        return this.mStorage.hashCode();
    }

    public boolean equals(Object o) {
        if ((o instanceof WatchedSparseBooleanArray) == false) goto L6;
        WatchedSparseBooleanArray w = (WatchedSparseBooleanArray) o;
        return this.mStorage.equals(w.mStorage);
    L6:
        return false;
    }

    public String toString() {
        return this.mStorage.toString();
    }

    @Override // com.android.server.utils.Snappable
    public WatchedSparseBooleanArray snapshot() {
        WatchedSparseBooleanArray l = new WatchedSparseBooleanArray(this);
        l.seal();
        return l;
    }

    public void snapshot(WatchedSparseBooleanArray r) {
        snapshot(this, r);
    }

    public static void snapshot(WatchedSparseBooleanArray dst, WatchedSparseBooleanArray src) {
        if (dst.size() != 0) goto L10;
        int end = src.size();
        int i = 0;
    L5:
        if (i >= end) goto L7;
        dst.mStorage.put(src.keyAt(i), src.valueAt(i));
        i = i + 1;
        goto L5
    L7:
        dst.seal();
        return;
    L10:
        throw new IllegalArgumentException("snapshot destination is not empty");
    }
}
