package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingObject;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public abstract class ForwardingCache<K, V> extends ForwardingObject implements Cache<K, V> {

    public static abstract class SimpleForwardingCache<K, V> extends ForwardingCache<K, V> {
        private final Cache<K, V> delegate;

        public SimpleForwardingCache(Cache<K, V> r10) {
            this.delegate = (Cache) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public final Cache<K, V> delegate() {
            return this.delegate;
        }
    }

    public ForwardingCache() {
    }

    @Override // com.google.common.cache.Cache
    public ConcurrentMap<K, V> asMap() {
        return delegate().asMap();
    }

    @Override // com.google.common.cache.Cache
    public void cleanUp() {
        delegate().cleanUp();
    }

    @Override // com.google.common.collect.ForwardingObject
    public abstract Cache<K, V> delegate();

    @Override // com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.cache.Cache
    public V get(K r10, Callable<? extends V> r11) throws ExecutionException {
        return delegate().get(r10, r11);
    }

    @Override // com.google.common.cache.Cache
    public ImmutableMap<K, V> getAllPresent(Iterable<?> r10) {
        return delegate().getAllPresent(r10);
    }

    @Override // com.google.common.cache.Cache
    @NullableDecl
    public V getIfPresent(Object r10) {
        return delegate().getIfPresent(r10);
    }

    @Override // com.google.common.cache.Cache
    public void invalidate(Object r10) {
        delegate().invalidate(r10);
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll(Iterable<?> r10) {
        delegate().invalidateAll(r10);
    }

    @Override // com.google.common.cache.Cache
    public void put(K r10, V r11) {
        delegate().put(r10, r11);
    }

    @Override // com.google.common.cache.Cache
    public void putAll(Map<? extends K, ? extends V> r10) {
        delegate().putAll(r10);
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
    public void invalidateAll() {
        delegate().invalidateAll();
    }
}
