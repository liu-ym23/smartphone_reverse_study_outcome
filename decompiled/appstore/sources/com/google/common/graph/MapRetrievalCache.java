package com.google.common.graph;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
class MapRetrievalCache<K, V> extends MapIteratorCache<K, V> {

    @NullableDecl
    private transient CacheEntry<K, V> cacheEntry1;

    @NullableDecl
    private transient CacheEntry<K, V> cacheEntry2;

    public static final class CacheEntry<K, V> {
        final K key;
        final V value;

        public CacheEntry(K r10, V r11) {
            this.key = r10;
            this.value = r11;
        }
    }

    public MapRetrievalCache(Map<K, V> r10) {
        super(r10);
    }

    private void addToCache(K r10, V r11) {
        addToCache(new CacheEntry(r10, r11));
    }

    @Override // com.google.common.graph.MapIteratorCache
    public void clearCache() {
        super.clearCache();
        this.cacheEntry1 = null;
        this.cacheEntry2 = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.MapIteratorCache
    public V get(@NullableDecl Object r10) {
        V r11 = getIfCached(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        V r12 = getWithoutCaching(r10);
        if (r12 == null) goto L8;
        addToCache(r10, r12);
    L8:
        return r12;
    }

    @Override // com.google.common.graph.MapIteratorCache
    public V getIfCached(@NullableDecl Object r10) {
        V r11 = (V) super.getIfCached(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        CacheEntry<K, V> r12 = this.cacheEntry1;
        if (r12 != null) goto L8;
    L11:
        CacheEntry<K, V> r13 = this.cacheEntry2;
        if (r13 != null) goto L14;
        return null;
    L14:
        if (r13.key != r10) goto L19;
        addToCache(r13);
        return r13.value;
    L19:
        return null;
    L8:
        if (r12.key != r10) goto L11;
        return r12.value;
    }

    private void addToCache(CacheEntry<K, V> r10) {
        this.cacheEntry2 = this.cacheEntry1;
        this.cacheEntry1 = r10;
    }
}
