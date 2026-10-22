package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    public static final class SimpleStatsCounter implements StatsCounter {
        private final LongAddable evictionCount;
        private final LongAddable hitCount;
        private final LongAddable loadExceptionCount;
        private final LongAddable loadSuccessCount;
        private final LongAddable missCount;
        private final LongAddable totalLoadTime;

        public SimpleStatsCounter() {
            this.hitCount = LongAddables.create();
            this.missCount = LongAddables.create();
            this.loadSuccessCount = LongAddables.create();
            this.loadExceptionCount = LongAddables.create();
            this.totalLoadTime = LongAddables.create();
            this.evictionCount = LongAddables.create();
        }

        public void incrementBy(StatsCounter r10) {
            CacheStats r11 = r10.snapshot();
            this.hitCount.add(r11.hitCount());
            this.missCount.add(r11.missCount());
            this.loadSuccessCount.add(r11.loadSuccessCount());
            this.loadExceptionCount.add(r11.loadExceptionCount());
            this.totalLoadTime.add(r11.totalLoadTime());
            this.evictionCount.add(r11.evictionCount());
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordEviction() {
            this.evictionCount.increment();
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordHits(int r10) {
            this.hitCount.add(r10);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadException(long r10) {
            this.loadExceptionCount.increment();
            this.totalLoadTime.add(r10);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadSuccess(long r10) {
            this.loadSuccessCount.increment();
            this.totalLoadTime.add(r10);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordMisses(int r10) {
            this.missCount.add(r10);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public CacheStats snapshot() {
            return new CacheStats(this.hitCount.sum(), this.missCount.sum(), this.loadSuccessCount.sum(), this.loadExceptionCount.sum(), this.totalLoadTime.sum(), this.evictionCount.sum());
        }
    }

    public interface StatsCounter {
        void recordEviction();

        void recordHits(int r10);

        void recordLoadException(long r10);

        void recordLoadSuccess(long r10);

        void recordMisses(int r10);

        CacheStats snapshot();
    }

    public AbstractCache() {
    }

    @Override // com.google.common.cache.Cache
    public ConcurrentMap<K, V> asMap() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void cleanUp() {
    }

    @Override // com.google.common.cache.Cache
    public V get(K r10, Callable<? extends V> r11) throws ExecutionException {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public ImmutableMap<K, V> getAllPresent(Iterable<?> r10) {
        LinkedHashMap r11 = Maps.newLinkedHashMap();
        Iterator<?> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Object r13 = r12.next();
        if (r11.containsKey(r13) == true) goto L4;
        V r14 = getIfPresent(r13);
        if (r14 == null) goto L4;
        r11.put(r13, r14);
        goto L4
    L11:
        return ImmutableMap.copyOf(r11);
    }

    @Override // com.google.common.cache.Cache
    public void invalidate(Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll(Iterable<?> r10) {
        Iterator<?> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        invalidate(r11.next());
        goto L4
    }

    @Override // com.google.common.cache.Cache
    public void put(K r10, V r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void putAll(Map<? extends K, ? extends V> r10) {
        Iterator<Map.Entry<? extends K, ? extends V>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r12 = r11.next();
        put(r12.getKey(), r12.getValue());
        goto L4
    }

    @Override // com.google.common.cache.Cache
    public long size() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public CacheStats stats() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll() {
        throw new UnsupportedOperationException();
    }
}
