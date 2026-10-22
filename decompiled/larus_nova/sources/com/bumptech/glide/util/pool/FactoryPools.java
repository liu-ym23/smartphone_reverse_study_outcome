package com.bumptech.glide.util.pool;

import androidx.core.util.Pools;
import com.bumptech.glide.util.GlideLogUtil;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public final class FactoryPools {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final Resetter<Object> EMPTY_RESETTER = null;
    private static final String TAG = "FactoryPools";

    public interface Factory<T> {
        T create();
    }

    public static final class FactoryPool<T> implements Pools.Pool<T> {
        private final Factory<T> factory;
        private final Pools.Pool<T> pool;
        private final Resetter<T> resetter;

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T r100 = this.pool.acquire();
            if (r100 != null) goto L6;
            r100 = this.factory.create();
            GlideLogUtil.v(FactoryPools.TAG, "Created new " + r100.getClass());
        L6:
            if ((r100 instanceof Poolable) == false) goto L8;
            ((Poolable) r100).getVerifier().setRecycled(false);
        L8:
            return r100;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(T r100) {
            if ((r100 instanceof Poolable) == false) goto L5;
            ((Poolable) r100).getVerifier().setRecycled(true);
        L5:
            this.resetter.reset(r100);
            return this.pool.release(r100);
        }

        public FactoryPool(Pools.Pool<T> r100, Factory<T> r101, Resetter<T> r102) {
            this.pool = r100;
            this.factory = r101;
            this.resetter = r102;
        }
    }

    public interface Poolable {
        StateVerifier getVerifier();
    }

    public interface Resetter<T> {
        void reset(T r100);
    }

    private FactoryPools() {
    }

    static {
        EMPTY_RESETTER = new AnonymousClass1();
    }

    public static <T> Pools.Pool<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    private static <T> Resetter<T> emptyResetter() {
        return (Resetter<T>) EMPTY_RESETTER;
    }

    public static <T> Pools.Pool<List<T>> threadSafeList(int r100) {
        return build(new Pools.SynchronizedPool(r100), new AnonymousClass2(), new AnonymousClass3());
    }

    private static <T extends Poolable> Pools.Pool<T> build(Pools.Pool<T> r100, Factory<T> r101) {
        return build(r100, r101, emptyResetter());
    }

    public static <T extends Poolable> Pools.Pool<T> simple(int r100, Factory<T> r101) {
        return build(new Pools.SimplePool(r100), r101);
    }

    public static <T extends Poolable> Pools.Pool<T> threadSafe(int r100, Factory<T> r101) {
        return build(new Pools.SynchronizedPool(r100), r101);
    }

    private static <T> Pools.Pool<T> build(Pools.Pool<T> r100, Factory<T> r101, Resetter<T> r102) {
        return new FactoryPool(r100, r101, r102);
    }
}
