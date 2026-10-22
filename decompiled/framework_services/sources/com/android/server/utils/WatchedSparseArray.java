package com.android.server.utils;

import android.util.SparseArray;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class WatchedSparseArray<E> extends WatchableImpl implements Snappable {
    private final Watcher mObserver;
    private final SparseArray<E> mStorage;
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

    public WatchedSparseArray() {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = new SparseArray();
    }

    public WatchedSparseArray(int initialCapacity) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = new SparseArray(initialCapacity);
    }

    public WatchedSparseArray(SparseArray<E> c) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = c.clone();
    }

    public WatchedSparseArray(WatchedSparseArray<E> r) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = r.mStorage.clone();
    }

    public void copyFrom(SparseArray<E> src) {
        clear();
        int end = src.size();
        int i = 0;
    L3:
        if (i >= end) goto L6;
        put(src.keyAt(i), src.valueAt(i));
        i = i + 1;
        goto L3
    }

    public void copyTo(SparseArray<E> dst) {
        dst.clear();
        int end = size();
        int i = 0;
    L3:
        if (i >= end) goto L6;
        dst.put(keyAt(i), valueAt(i));
        i = i + 1;
        goto L3
    }

    public SparseArray<E> untrackedStorage() {
        return this.mStorage;
    }

    public boolean contains(int key) {
        return this.mStorage.contains(key);
    }

    public E get(int key) {
        return this.mStorage.get(key);
    }

    public E get(int key, E valueIfKeyNotFound) {
        return this.mStorage.get(key, valueIfKeyNotFound);
    }

    public void delete(int key) {
        E child = this.mStorage.get(key);
        this.mStorage.delete(key);
        unregisterChildIf(child);
        onChanged();
    }

    public E removeReturnOld(int r2) {
        E r0 = (E) this.mStorage.removeReturnOld(r2);
        unregisterChildIf(r0);
        return r0;
    }

    public void remove(int key) {
        delete(key);
    }

    public void removeAt(int index) {
        E child = this.mStorage.valueAt(index);
        this.mStorage.removeAt(index);
        unregisterChildIf(child);
        onChanged();
    }

    public void removeAtRange(int index, int size) {
        ArrayList<E> children = new ArrayList();
        int i = 0;
    L3:
        if (i < size) goto L23;
    L21:
        this.mStorage.removeAtRange(index, size);     // Catch: Throwable -> L15
        int i2 = 0;
    L11:
        if (i2 >= size) goto L13;
        unregisterChildIf(children.get(i2));
        i2 = i2 + 1;
        goto L11
    L13:
        onChanged();
        return;
    L15:
        th = move-exception;
        int i3 = 0;
    L17:
        if (i3 >= size) goto L20;
        unregisterChildIf(children.get(i3));
        i3 = i3 + 1;
        goto L17
    L20:
        throw th;
    L23:
        children.add(this.mStorage.valueAt(i + index));     // Catch: Exception -> L6
        i = i + 1;
        goto L3
    }

    public void put(int key, E value) {
        E old = this.mStorage.get(key);
        this.mStorage.put(key, value);
        unregisterChildIf(old);
        registerChild(value);
        onChanged();
    }

    public int size() {
        return this.mStorage.size();
    }

    public int keyAt(int index) {
        return this.mStorage.keyAt(index);
    }

    public E valueAt(int index) {
        return this.mStorage.valueAt(index);
    }

    public void setValueAt(int index, E value) {
        E old = this.mStorage.valueAt(index);
        this.mStorage.setValueAt(index, value);
        if (value == old) goto L6;
        unregisterChildIf(old);
        registerChild(value);
        onChanged();
        return;
    }

    public int indexOfKey(int key) {
        return this.mStorage.indexOfKey(key);
    }

    public int indexOfValue(E value) {
        return this.mStorage.indexOfValue(value);
    }

    public int indexOfValueByValue(E value) {
        return this.mStorage.indexOfValueByValue(value);
    }

    public void clear() {
        if (this.mWatching == false) goto L7;
        int end = this.mStorage.size();
        int i = 0;
    L5:
        if (i >= end) goto L7;
        unregisterChild(this.mStorage.valueAt(i));
        i = i + 1;
    L7:
        this.mStorage.clear();
        onChanged();
    }

    public void append(int key, E value) {
        this.mStorage.append(key, value);
        registerChild(value);
        onChanged();
    }

    public int hashCode() {
        return this.mStorage.hashCode();
    }

    public boolean equals(Object o) {
        if ((o instanceof WatchedSparseArray) == false) goto L6;
        WatchedSparseArray w = (WatchedSparseArray) o;
        return this.mStorage.equals(w.mStorage);
    L6:
        return false;
    }

    public String toString() {
        return this.mStorage.toString();
    }

    @Override // com.android.server.utils.Snappable
    public WatchedSparseArray<E> snapshot() {
        WatchedSparseArray<E> l = new WatchedSparseArray(size());
        snapshot(l, this);
        return l;
    }

    public void snapshot(WatchedSparseArray<E> r) {
        snapshot(this, r);
    }

    public static <E> void snapshot(WatchedSparseArray<E> r5, WatchedSparseArray<E> r6) {
        if (r5.size() != 0) goto L10;
        int r0 = r6.size();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        Object r2 = Snapshots.maybeSnapshot(r6.valueAt(r1));
        int r3 = r6.keyAt(r1);
        ((WatchedSparseArray) r5).mStorage.put(r3, (E) r2);
        r1 = r1 + 1;
        goto L5
    L7:
        r5.seal();
        return;
    L10:
        throw new IllegalArgumentException("snapshot destination is not empty");
    }
}
