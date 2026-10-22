package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CacheLoader<K, V> {

    private static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Function<K, V> computingFunction;

        public FunctionToCacheLoader(Function<K, V> r1) {
            this.computingFunction = (Function) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K r1) {
            return this.computingFunction.apply((K) Preconditions.checkNotNull(r1));
        }
    }

    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String r1) {
            super(r1);
        }
    }

    private static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Supplier<V> computingSupplier;

        public SupplierToCacheLoader(Supplier<V> r1) {
            this.computingSupplier = (Supplier) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(Object r1) {
            Preconditions.checkNotNull(r1);
            return this.computingSupplier.get();
        }
    }

    static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
        UnsupportedLoadingOperationException() {
        }
    }

    public abstract V load(K r1) throws Exception;

    protected CacheLoader() {
    }

    public ListenableFuture<V> reload(K r1, V r2) throws Exception {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return Futures.immediateFuture(load(r1));
    }

    public Map<K, V> loadAll(Iterable<? extends K> r1) throws Exception {
        throw new UnsupportedLoadingOperationException();
    }

    public static <K, V> CacheLoader<K, V> from(Function<K, V> r1) {
        return new FunctionToCacheLoader(r1);
    }

    public static <V> CacheLoader<Object, V> from(Supplier<V> r1) {
        return new SupplierToCacheLoader(r1);
    }

    public static <K, V> CacheLoader<K, V> asyncReloading(final CacheLoader<K, V> r1, final Executor r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass1(r1, r2);
    }
}
