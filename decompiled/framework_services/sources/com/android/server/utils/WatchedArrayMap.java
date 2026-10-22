package com.android.server.utils;

import android.util.ArrayMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class WatchedArrayMap<K, V> extends WatchableImpl implements Map<K, V>, Snappable {
    private final Watcher mObserver;
    private final ArrayMap<K, V> mStorage;
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
        if (this.mStorage.containsValue(o) == true) goto L12;
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

    public WatchedArrayMap() {
        this(0, false);
    }

    public WatchedArrayMap(int capacity) {
        this(capacity, false);
    }

    public WatchedArrayMap(int capacity, boolean identityHashCode) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = new ArrayMap(capacity, identityHashCode);
    }

    public WatchedArrayMap(Map<? extends K, ? extends V> map) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = new ArrayMap();
        if (map == null) goto L6;
        putAll(map);
        return;
    }

    public WatchedArrayMap(ArrayMap<K, V> c) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = new ArrayMap(c);
    }

    public WatchedArrayMap(WatchedArrayMap<K, V> c) {
        this.mWatching = false;
        this.mObserver = new AnonymousClass1(this);
        this.mStorage = new ArrayMap(c.mStorage);
    }

    public void copyFrom(ArrayMap<K, V> src) {
        clear();
        int end = src.size();
        this.mStorage.ensureCapacity(end);
        int i = 0;
    L3:
        if (i >= end) goto L6;
        put(src.keyAt(i), src.valueAt(i));
        i = i + 1;
        goto L3
    }

    public void copyTo(ArrayMap<K, V> dst) {
        dst.clear();
        int end = size();
        dst.ensureCapacity(end);
        int i = 0;
    L3:
        if (i >= end) goto L6;
        dst.put(keyAt(i), valueAt(i));
        i = i + 1;
        goto L3
    }

    public ArrayMap<K, V> untrackedStorage() {
        return this.mStorage;
    }

    @Override // java.util.Map
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

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return this.mStorage.containsKey(key);
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return this.mStorage.containsValue(value);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return Collections.unmodifiableSet(this.mStorage.entrySet());
    }

    @Override // java.util.Map
    public boolean equals(Object o) {
        if ((o instanceof WatchedArrayMap) == false) goto L6;
        WatchedArrayMap w = (WatchedArrayMap) o;
        return this.mStorage.equals(w.mStorage);
    L6:
        return false;
    }

    @Override // java.util.Map
    public V get(Object key) {
        return this.mStorage.get(key);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.mStorage.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.mStorage.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return Collections.unmodifiableSet(this.mStorage.keySet());
    }

    @Override // java.util.Map
    public V put(K key, V value) {
        V result = this.mStorage.put(key, value);
        registerChild(value);
        onChanged();
        return result;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        Iterator<Map.Entry<? extends K, ? extends V>> r0 = map.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> element = r0.next();
        put(element.getKey(), element.getValue());
        goto L4
    }

    @Override // java.util.Map
    public V remove(Object key) {
        V result = this.mStorage.remove(key);
        unregisterChildIf(result);
        onChanged();
        return result;
    }

    @Override // java.util.Map
    public int size() {
        return this.mStorage.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return Collections.unmodifiableCollection(this.mStorage.values());
    }

    public K keyAt(int index) {
        return this.mStorage.keyAt(index);
    }

    public V valueAt(int index) {
        return this.mStorage.valueAt(index);
    }

    public int indexOfKey(K key) {
        return this.mStorage.indexOfKey(key);
    }

    public int indexOfValue(V value) {
        return this.mStorage.indexOfValue(value);
    }

    public V setValueAt(int index, V value) {
        V result = this.mStorage.setValueAt(index, value);
        if (value == result) goto L5;
        unregisterChildIf(result);
        registerChild(value);
        onChanged();
    L5:
        return result;
    }

    public V removeAt(int index) {
        V result = this.mStorage.removeAt(index);
        unregisterChildIf(result);
        onChanged();
        return result;
    }

    @Override // com.android.server.utils.Snappable
    public WatchedArrayMap<K, V> snapshot() {
        WatchedArrayMap<K, V> l = new WatchedArrayMap();
        snapshot(l, this);
        return l;
    }

    public void snapshot(WatchedArrayMap<K, V> r) {
        snapshot(this, r);
    }

    public static <K, V> void snapshot(WatchedArrayMap<K, V> r5, WatchedArrayMap<K, V> r6) {
        if (r5.size() != 0) goto L10;
        int r0 = r6.size();
        ((WatchedArrayMap) r5).mStorage.ensureCapacity(r0);
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        Object r2 = Snapshots.maybeSnapshot(r6.valueAt(r1));
        K r3 = r6.keyAt(r1);
        ((WatchedArrayMap) r5).mStorage.put(r3, (V) r2);
        r1 = r1 + 1;
        goto L5
    L7:
        r5.seal();
        return;
    L10:
        throw new IllegalArgumentException("snapshot destination is not empty");
    }
}
