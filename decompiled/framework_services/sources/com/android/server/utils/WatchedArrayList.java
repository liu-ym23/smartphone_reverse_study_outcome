package com.android.server.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class WatchedArrayList<E> extends WatchableImpl implements Snappable {
    private final Watcher mObserver;
    private final ArrayList<E> mStorage;
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
        registerChild(this.mStorage.get(i));
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
        unregisterChild(this.mStorage.get(i));
        i = i + 1;
        goto L5
    L7:
        this.mWatching = false;
        return;
    }

    public WatchedArrayList() {
        this(0);
    }

    public WatchedArrayList(int capacity) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = new ArrayList(capacity);
    }

    public WatchedArrayList(Collection<? extends E> c) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = new ArrayList();
        if (c == null) goto L6;
        this.mStorage.addAll(c);
        return;
    }

    public WatchedArrayList(ArrayList<E> c) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = new ArrayList(c);
    }

    public WatchedArrayList(WatchedArrayList<E> c) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = new ArrayList(c.mStorage);
    }

    public void copyFrom(ArrayList<E> src) {
        clear();
        int end = src.size();
        this.mStorage.ensureCapacity(end);
        int i = 0;
    L3:
        if (i >= end) goto L6;
        add(src.get(i));
        i = i + 1;
        goto L3
    }

    public void copyTo(ArrayList<E> dst) {
        dst.clear();
        int end = size();
        dst.ensureCapacity(end);
        int i = 0;
    L3:
        if (i >= end) goto L6;
        dst.add(get(i));
        i = i + 1;
        goto L3
    }

    public ArrayList<E> untrackedStorage() {
        return this.mStorage;
    }

    public boolean add(E value) {
        boolean result = this.mStorage.add(value);
        registerChild(value);
        onChanged();
        return result;
    }

    public void add(int index, E value) {
        this.mStorage.add(index, value);
        registerChild(value);
        onChanged();
    }

    public boolean addAll(Collection<? extends E> c) {
        if (c.size() <= 0) goto L10;
        Iterator<? extends E> r0 = c.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        E e = r0.next();
        this.mStorage.add(e);
        goto L6
    L8:
        onChanged();
        return true;
    L10:
        return false;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        if (c.size() <= 0) goto L10;
        Iterator<? extends E> r0 = c.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        E e = r0.next();
        this.mStorage.add(index, e);
        index = index + 1;
        goto L6
    L8:
        onChanged();
        return true;
    L10:
        return false;
    }

    public void clear() {
        if (this.mWatching == false) goto L7;
        int end = this.mStorage.size();
        int i = 0;
    L5:
        if (i >= end) goto L7;
        unregisterChild(this.mStorage.get(i));
        i = i + 1;
    L7:
        this.mStorage.clear();
        onChanged();
    }

    public boolean contains(Object o) {
        return this.mStorage.contains(o);
    }

    public boolean containsAll(Collection<?> c) {
        return this.mStorage.containsAll(c);
    }

    public void ensureCapacity(int min) {
        this.mStorage.ensureCapacity(min);
    }

    public E get(int index) {
        return this.mStorage.get(index);
    }

    public int indexOf(Object o) {
        return this.mStorage.indexOf(o);
    }

    public boolean isEmpty() {
        return this.mStorage.isEmpty();
    }

    public int lastIndexOf(Object o) {
        return this.mStorage.lastIndexOf(o);
    }

    public E remove(int index) {
        E result = this.mStorage.remove(index);
        unregisterChildIf(result);
        onChanged();
        return result;
    }

    public boolean remove(Object o) {
        if (this.mStorage.remove(o) == false) goto L6;
        unregisterChildIf(o);
        onChanged();
        return true;
    L6:
        return false;
    }

    public E set(int index, E value) {
        E result = this.mStorage.set(index, value);
        if (value == result) goto L5;
        unregisterChildIf(result);
        registerChild(value);
        onChanged();
    L5:
        return result;
    }

    public int size() {
        return this.mStorage.size();
    }

    public boolean equals(Object o) {
        if ((o instanceof WatchedArrayList) == false) goto L6;
        WatchedArrayList w = (WatchedArrayList) o;
        return this.mStorage.equals(w.mStorage);
    L6:
        return false;
    }

    public int hashCode() {
        return this.mStorage.hashCode();
    }

    @Override // com.android.server.utils.Snappable
    public WatchedArrayList<E> snapshot() {
        WatchedArrayList<E> l = new WatchedArrayList(size());
        snapshot(l, this);
        return l;
    }

    public void snapshot(WatchedArrayList<E> r) {
        snapshot(this, r);
    }

    public static <E> void snapshot(WatchedArrayList<E> r4, WatchedArrayList<E> r5) {
        if (r4.size() != 0) goto L10;
        int r0 = r5.size();
        ((WatchedArrayList) r4).mStorage.ensureCapacity(r0);
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        Object r2 = Snapshots.maybeSnapshot(r5.get(r1));
        ((WatchedArrayList) r4).mStorage.add((E) r2);
        r1 = r1 + 1;
        goto L5
    L7:
        r4.seal();
        return;
    L10:
        throw new IllegalArgumentException("snapshot destination is not empty");
    }
}
