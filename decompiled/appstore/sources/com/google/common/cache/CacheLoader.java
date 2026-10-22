package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public abstract class CacheLoader<K, V> {

    public static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Function<K, V> computingFunction;

        public FunctionToCacheLoader(Function<K, V> r10) {
            this.computingFunction = (Function) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K r10) {
            return this.computingFunction.apply((K) Preconditions.checkNotNull(r10));
        }
    }

    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String r10) {
            super(r10);
        }
    }

    public static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Supplier<V> computingSupplier;

        public SupplierToCacheLoader(Supplier<V> r10) {
            this.computingSupplier = (Supplier) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(Object r10) {
            Preconditions.checkNotNull(r10);
            return this.computingSupplier.get();
        }
    }

    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
        public UnsupportedLoadingOperationException() {
        }
    }

    public CacheLoader() {
    }

    @GwtIncompatible
    public static <K, V> CacheLoader<K, V> asyncReloading(final CacheLoader<K, V> r10, final Executor r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return new AnonymousClass1(r10, r11);
    }

    public static <K, V> CacheLoader<K, V> from(Function<K, V> r10) {
        return new FunctionToCacheLoader(r10);
    }

    public abstract V load(K r10) throws Exception;

    public Map<K, V> loadAll(Iterable<? extends K> r10) throws Exception {
        throw new UnsupportedLoadingOperationException();
    }

    @GwtIncompatible
    public ListenableFuture<V> reload(K r10, V r11) throws Exception {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return Futures.immediateFuture(load(r10));
    }

    public static <V> CacheLoader<Object, V> from(Supplier<V> r10) {
        return new SupplierToCacheLoader(r10);
    }
}
