package com.android.contacts.util;

import android.util.LruCache;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class ExpirableCache<K, V> {
    private LruCache<K, CachedValue<V>> mCache;
    private final AtomicInteger mGeneration;

    public interface CachedValue<V> {
        V getValue();

        boolean isExpired();
    }

    private static class GenerationalCachedValue<V> implements CachedValue<V> {
        private final AtomicInteger mCacheGeneration;
        private final int mGeneration;
        public final V mValue;

        public GenerationalCachedValue(V r1, AtomicInteger r2) {
            this.mValue = r1;
            this.mCacheGeneration = r2;
            this.mGeneration = r2.get();
        }

        @Override // com.android.contacts.util.ExpirableCache.CachedValue
        public V getValue() {
            return this.mValue;
        }

        @Override // com.android.contacts.util.ExpirableCache.CachedValue
        public boolean isExpired() {
            if (this.mGeneration == this.mCacheGeneration.get()) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private ExpirableCache(LruCache<K, CachedValue<V>> r2) {
        this.mCache = r2;
        this.mGeneration = new AtomicInteger(0);
    }

    public CachedValue<V> getCachedValue(K r1) {
        return this.mCache.get(r1);
    }

    public V getPossiblyExpired(K r1) {
        CachedValue<V> r0 = getCachedValue(r1);
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getValue();
    }

    public V get(K r1) {
        CachedValue<V> r0 = getCachedValue(r1);
        if (r0 != null) goto L5;
    L8:
        return null;
    L5:
        if (r0.isExpired() == true) goto L8;
        return r0.getValue();
    }

    public void put(K r2, V r3) {
        this.mCache.put(r2, newCachedValue(r3));
    }

    public void expireAll() {
        this.mGeneration.incrementAndGet();
    }

    public CachedValue<V> newCachedValue(V r2) {
        return new GenerationalCachedValue(r2, this.mGeneration);
    }

    public static <K, V> ExpirableCache<K, V> create(LruCache<K, CachedValue<V>> r1) {
        return new ExpirableCache(r1);
    }

    public static <K, V> ExpirableCache<K, V> create(int r1) {
        return create(new LruCache(r1));
    }
}
