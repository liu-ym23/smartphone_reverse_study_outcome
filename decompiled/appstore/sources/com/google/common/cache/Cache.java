package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public interface Cache<K, V> {
    ConcurrentMap<K, V> asMap();

    void cleanUp();

    V get(K r10, Callable<? extends V> r11) throws ExecutionException;

    ImmutableMap<K, V> getAllPresent(Iterable<?> r10);

    @NullableDecl
    V getIfPresent(@CompatibleWith("K") Object r10);

    void invalidate(@CompatibleWith("K") Object r10);

    void invalidateAll();

    void invalidateAll(Iterable<?> r10);

    void put(K r10, V r11);

    void putAll(Map<? extends K, ? extends V> r10);

    long size();

    CacheStats stats();
}
