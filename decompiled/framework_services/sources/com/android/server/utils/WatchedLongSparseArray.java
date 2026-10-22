package com.android.server.utils;

import android.util.LongSparseArray;

/* JADX INFO: loaded from: classes3.dex */
public class WatchedLongSparseArray<E> extends WatchableImpl implements Snappable {
    private final Watcher mObserver;
    private final LongSparseArray<E> mStorage;
    private volatile boolean mWatching;

    @Override // com.android.server.utils.Snappable
    public /* bridge */ /* synthetic */ Object snapshot() {
        return snapshot();
    }

    private void onChanged() {
        dispatchChange(this);
    }

    private void registerChild(Object o) {
        if (this.mWatching == true) goto L5;
        return;
    L5:
        if ((o instanceof Watchable) == false) goto L9;
        ((Watchable) o).registerObserver(this.mObserver);
        return;
    }

    private void unregisterChild(Object o) {
        if (this.mWatching == true) goto L5;
        return;
    L5:
        if ((o instanceof Watchable) == false) goto L9;
        ((Watchable) o).unregisterObserver(this.mObserver);
        return;
    }

    private void unregisterChildIf(Object o) {
        if (this.mWatching == true) goto L5;
        return;
    L5:
        if ((o instanceof Watchable) == true) goto L7;
        return;
    L7:
        if (this.mStorage.indexOfValue(o) != (-1)) goto L12;
        ((Watchable) o).unregisterObserver(this.mObserver);
        return;
    }

    @Override // com.android.server.utils.WatchableImpl, com.android.server.utils.Watchable
    public void registerObserver(Watcher observer) {
        super.registerObserver(observer);
        if (registeredObserverCount() != 1) goto L7;
        this.mWatching = true;
        int end = this.mStorage.size();
        int i = 0;
    L5:
        if (i >= end) goto L9;
        registerChild(this.mStorage.valueAt(i));
        i = i + 1;
        goto L5
    L9:
        return;
    }

    @Override // com.android.server.utils.WatchableImpl, com.android.server.utils.Watchable
    public void unregisterObserver(Watcher observer) {
        super.unregisterObserver(observer);
        if (registeredObserverCount() != 0) goto L10;
        int end = this.mStorage.size();
        int i = 0;
    L5:
        if (i >= end) goto L7;
        unregisterChild(this.mStorage.valueAt(i));
        i = i + 1;
        goto L5
    L7:
        this.mWatching = false;
        return;
    }

    public WatchedLongSparseArray() {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = new LongSparseArray();
    }

    public WatchedLongSparseArray(int initialCapacity) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = new LongSparseArray(initialCapacity);
    }

    public WatchedLongSparseArray(LongSparseArray<E> c) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = c.clone();
    }

    public WatchedLongSparseArray(WatchedLongSparseArray<E> r) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = r.mStorage.clone();
    }

    public void copyFrom(LongSparseArray<E> src) {
        clear();
        int end = src.size();
        int i = 0;
    L3:
        if (i >= end) goto L6;
        put(src.keyAt(i), src.valueAt(i));
        i = i + 1;
        goto L3
    }

    public void copyTo(LongSparseArray<E> dst) {
        dst.clear();
        int end = size();
        int i = 0;
    L3:
        if (i >= end) goto L6;
        dst.put(keyAt(i), valueAt(i));
        i = i + 1;
        goto L3
    }

    public LongSparseArray<E> untrackedStorage() {
        return this.mStorage;
    }

    public E get(long key) {
        return this.mStorage.get(key);
    }

    public E get(long key, E valueIfKeyNotFound) {
        return this.mStorage.get(key, valueIfKeyNotFound);
    }

    public void delete(long key) {
        E old = this.mStorage.get(key, null);
        this.mStorage.delete(key);
        unregisterChildIf(old);
        onChanged();
    }

    public void remove(long key) {
        delete(key);
    }

    public void removeAt(int index) {
        E old = this.mStorage.valueAt(index);
        this.mStorage.removeAt(index);
        unregisterChildIf(old);
        onChanged();
    }

    public void put(long key, E value) {
        E old = this.mStorage.get(key);
        this.mStorage.put(key, value);
        unregisterChildIf(old);
        registerChild(value);
        onChanged();
    }

    public int size() {
        return this.mStorage.size();
    }

    public long keyAt(int index) {
        return this.mStorage.keyAt(index);
    }

    public E valueAt(int index) {
        return this.mStorage.valueAt(index);
    }

    public void setValueAt(int index, E value) {
        E old = this.mStorage.valueAt(index);
        this.mStorage.setValueAt(index, value);
        unregisterChildIf(old);
        registerChild(value);
        onChanged();
    }

    public int indexOfKey(long key) {
        return this.mStorage.indexOfKey(key);
    }

    public int indexOfValue(E value) {
        return this.mStorage.indexOfValue(value);
    }

    public int indexOfValueByValue(E value) {
        return this.mStorage.indexOfValueByValue(value);
    }

    public void clear() {
        int end = this.mStorage.size();
        int i = 0;
    L3:
        if (i >= end) goto L5;
        unregisterChild(this.mStorage.valueAt(i));
        i = i + 1;
        goto L3
    L5:
        this.mStorage.clear();
        onChanged();
    }

    public void append(long key, E value) {
        this.mStorage.append(key, value);
        registerChild(value);
        onChanged();
    }

    public String toString() {
        return this.mStorage.toString();
    }

    @Override // com.android.server.utils.Snappable
    public WatchedLongSparseArray<E> snapshot() {
        WatchedLongSparseArray<E> l = new WatchedLongSparseArray(size());
        snapshot(l, this);
        return l;
    }

    public void snapshot(WatchedLongSparseArray<E> r) {
        snapshot(this, r);
    }

    public static <E> void snapshot(WatchedLongSparseArray<E> r6, WatchedLongSparseArray<E> r7) {
        if (r6.size() != 0) goto L10;
        int r0 = r7.size();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        Object r2 = Snapshots.maybeSnapshot(r7.valueAt(r1));
        long r3 = r7.keyAt(r1);
        ((WatchedLongSparseArray) r6).mStorage.put(r3, (E) r2);
        r1 = r1 + 1;
        goto L5
    L7:
        r6.seal();
        return;
    L10:
        throw new IllegalArgumentException("snapshot destination is not empty");
    }
}
