package com.android.server.utils;

import android.util.ArraySet;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public class WatchedArraySet<E> extends WatchableImpl implements Snappable {
    private final Watcher mObserver;
    private final ArraySet<E> mStorage;
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
        if (this.mStorage.contains(o) == true) goto L12;
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

    public WatchedArraySet() {
        this(0, false);
    }

    public WatchedArraySet(int capacity) {
        this(capacity, false);
    }

    public WatchedArraySet(int capacity, boolean identityHashCode) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = new ArraySet(capacity, identityHashCode);
    }

    public WatchedArraySet(E[] array) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = new ArraySet(array);
    }

    public WatchedArraySet(ArraySet<E> c) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = new ArraySet(c);
    }

    public WatchedArraySet(WatchedArraySet<E> c) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = new ArraySet(c.mStorage);
    }

    public void copyFrom(ArraySet<E> src) {
        clear();
        int end = src.size();
        this.mStorage.ensureCapacity(end);
        int i = 0;
    L3:
        if (i >= end) goto L6;
        add(src.valueAt(i));
        i = i + 1;
        goto L3
    }

    public void copyTo(ArraySet<E> dst) {
        dst.clear();
        int end = size();
        dst.ensureCapacity(end);
        int i = 0;
    L3:
        if (i >= end) goto L6;
        dst.add(valueAt(i));
        i = i + 1;
        goto L3
    }

    public ArraySet<E> untrackedStorage() {
        return this.mStorage;
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

    public boolean contains(Object key) {
        return this.mStorage.contains(key);
    }

    public int indexOf(Object key) {
        return this.mStorage.indexOf(key);
    }

    public E valueAt(int index) {
        return this.mStorage.valueAt(index);
    }

    public boolean isEmpty() {
        return this.mStorage.isEmpty();
    }

    public boolean add(E value) {
        boolean result = this.mStorage.add(value);
        registerChild(value);
        onChanged();
        return result;
    }

    public void append(E value) {
        this.mStorage.append(value);
        registerChild(value);
        onChanged();
    }

    public void addAll(Collection<? extends E> collection) {
        this.mStorage.addAll(collection);
        onChanged();
    }

    public void addAll(WatchedArraySet<? extends E> array) {
        int end = array.size();
        int i = 0;
    L3:
        if (i >= end) goto L6;
        add(array.valueAt(i));
        i = i + 1;
        goto L3
    }

    public boolean remove(Object o) {
        if (this.mStorage.remove(o) == false) goto L6;
        unregisterChildIf(o);
        onChanged();
        return true;
    L6:
        return false;
    }

    public E removeAt(int index) {
        E result = this.mStorage.removeAt(index);
        unregisterChildIf(result);
        onChanged();
        return result;
    }

    public boolean removeAll(ArraySet<? extends E> array) {
        int end = array.size();
        boolean any = false;
        int i = 0;
    L3:
        if (i >= end) goto L12;
        if (remove(array.valueAt(i)) == true) goto L9;
        if (any == true) goto L9;
        boolean r3 = false;
    L10:
        any = r3;
        i = i + 1;
    L9:
        r3 = true;
        goto L10
    L12:
        return any;
    }

    public int size() {
        return this.mStorage.size();
    }

    public boolean equals(Object object) {
        if ((object instanceof WatchedArraySet) == false) goto L7;
        return this.mStorage.equals(((WatchedArraySet) object).mStorage);
    L7:
        return this.mStorage.equals(object);
    }

    public int hashCode() {
        return this.mStorage.hashCode();
    }

    public String toString() {
        return this.mStorage.toString();
    }

    @Override // com.android.server.utils.Snappable
    public WatchedArraySet<E> snapshot() {
        WatchedArraySet<E> l = new WatchedArraySet();
        snapshot(l, this);
        return l;
    }

    public void snapshot(WatchedArraySet<E> r) {
        snapshot(this, r);
    }

    public static <E> void snapshot(WatchedArraySet<E> dst, WatchedArraySet<E> src) {
        if (dst.size() != 0) goto L10;
        int end = src.size();
        ((WatchedArraySet) dst).mStorage.ensureCapacity(end);
        int i = 0;
    L5:
        if (i >= end) goto L7;
        Object r2 = Snapshots.maybeSnapshot(src.valueAt(i));
        ((WatchedArraySet) dst).mStorage.append(r2);
        i = i + 1;
        goto L5
    L7:
        dst.seal();
        return;
    L10:
        throw new IllegalArgumentException("snapshot destination is not empty");
    }
}
