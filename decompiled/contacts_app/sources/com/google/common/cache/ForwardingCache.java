package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingObject;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingCache<K, V> extends ForwardingObject implements Cache<K, V> {

    public static abstract class SimpleForwardingCache<K, V> extends ForwardingCache<K, V> {
        private final Cache<K, V> delegate;

        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        protected SimpleForwardingCache(Cache<K, V> r1) {
            this.delegate = (Cache) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        protected final Cache<K, V> delegate() {
            return this.delegate;
        }
    }

    @Override // com.google.common.collect.ForwardingObject
    protected abstract Cache<K, V> delegate();

    @Override // com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    protected ForwardingCache() {
    }

    @Override // com.google.common.cache.Cache
    @Nullable
    public V getIfPresent(Object r1) {
        return delegate().getIfPresent(r1);
    }

    @Override // com.google.common.cache.Cache
    public V get(K r1, Callable<? extends V> r2) throws ExecutionException {
        return delegate().get(r1, r2);
    }

    @Override // com.google.common.cache.Cache
    public ImmutableMap<K, V> getAllPresent(Iterable<?> r1) {
        return delegate().getAllPresent(r1);
    }

    @Override // com.google.common.cache.Cache
    public void put(K r1, V r2) {
        delegate().put(r1, r2);
    }

    @Override // com.google.common.cache.Cache
    public void putAll(Map<? extends K, ? extends V> r1) {
        delegate().putAll(r1);
    }

    @Override // com.google.common.cache.Cache
    public void invalidate(Object r1) {
        delegate().invalidate(r1);
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll(Iterable<?> r1) {
        delegate().invalidateAll(r1);
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll() {
        delegate().invalidateAll();
    }

    @Override // com.google.common.cache.Cache
    public long size() {
        return delegate().size();
    }

    @Override // com.google.common.cache.Cache
    public CacheStats stats() {
        return delegate().stats();
    }

    @Override // com.google.common.cache.Cache
    public ConcurrentMap<K, V> asMap() {
        return delegate().asMap();
    }

    @Override // com.google.common.cache.Cache
    public void cleanUp() {
        delegate().cleanUp();
    }
}
