package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap;
import java.io.Serializable;
import java.util.Map;
import java.util.function.BiConsumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class LRUMap<K, V> implements LookupCache<K, V>, Serializable {
    private static final long serialVersionUID = 2;
    protected final int _initialEntries;
    protected final transient PrivateMaxEntriesMap<K, V> _map;
    protected final int _maxEntries;

    public LRUMap(int i, int i3) {
        this._initialEntries = i;
        this._maxEntries = i3;
        this._map = new PrivateMaxEntriesMap.Builder().initialCapacity(i).maximumCapacity(i3).concurrencyLevel(4).build();
    }

    @Override // com.fasterxml.jackson.databind.util.LookupCache
    public void clear() {
        this._map.clear();
    }

    @Override // com.fasterxml.jackson.databind.util.LookupCache
    public void contents(BiConsumer<K, V> biConsumer) {
        for (Map.Entry<K, V> entry : this._map.entrySet()) {
            biConsumer.accept(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.fasterxml.jackson.databind.util.LookupCache
    public LookupCache<K, V> emptyCopy() {
        return new LRUMap(this._initialEntries, this._maxEntries);
    }

    @Override // com.fasterxml.jackson.databind.util.LookupCache
    public V get(Object obj) {
        return this._map.get(obj);
    }

    @Override // com.fasterxml.jackson.databind.util.LookupCache
    public V put(K k10, V v10) {
        return this._map.put(k10, v10);
    }

    @Override // com.fasterxml.jackson.databind.util.LookupCache
    public V putIfAbsent(K k10, V v10) {
        return this._map.putIfAbsent(k10, v10);
    }

    public Object readResolve() {
        return new LRUMap(this._initialEntries, this._maxEntries);
    }

    @Override // com.fasterxml.jackson.databind.util.LookupCache
    public int size() {
        return this._map.size();
    }
}
