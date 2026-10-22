package com.bumptech.glide.util.pool;

import B0.e;
import B0.f;
import B0.g;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class FactoryPools {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final Resetter<Object> EMPTY_RESETTER = new Resetter<Object>() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(Object obj) {
        }
    };
    private static final String TAG = "FactoryPools";

    public interface Factory<T> {
        T create();
    }

    public static final class FactoryPool<T> implements e<T> {
        private final Factory<T> factory;
        private final e<T> pool;
        private final Resetter<T> resetter;

        public FactoryPool(e<T> eVar, Factory<T> factory, Resetter<T> resetter) {
            this.pool = eVar;
            this.factory = factory;
            this.resetter = resetter;
        }

        @Override // B0.e
        public T acquire() {
            T tAcquire = this.pool.acquire();
            if (tAcquire == null) {
                tAcquire = this.factory.create();
                if (Log.isLoggable(FactoryPools.TAG, 2)) {
                    Log.v(FactoryPools.TAG, "Created new " + tAcquire.getClass());
                }
            }
            if (tAcquire instanceof Poolable) {
                tAcquire.getVerifier().setRecycled(false);
            }
            return (T) tAcquire;
        }

        @Override // B0.e
        public boolean release(T t10) {
            if (t10 instanceof Poolable) {
                ((Poolable) t10).getVerifier().setRecycled(true);
            }
            this.resetter.reset(t10);
            return this.pool.release(t10);
        }
    }

    public interface Poolable {
        StateVerifier getVerifier();
    }

    public interface Resetter<T> {
        void reset(T t10);
    }

    private FactoryPools() {
    }

    private static <T extends Poolable> e<T> build(e<T> eVar, Factory<T> factory) {
        return build(eVar, factory, emptyResetter());
    }

    private static <T> Resetter<T> emptyResetter() {
        return (Resetter<T>) EMPTY_RESETTER;
    }

    public static <T extends Poolable> e<T> simple(int i10, Factory<T> factory) {
        return build(new f(i10), factory);
    }

    public static <T extends Poolable> e<T> threadSafe(int i10, Factory<T> factory) {
        return build(new g(i10), factory);
    }

    public static <T> e<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    private static <T> e<T> build(e<T> eVar, Factory<T> factory, Resetter<T> resetter) {
        return new FactoryPool(eVar, factory, resetter);
    }

    public static <T extends Poolable> e<T> threadSafe(int i10, Factory<T> factory, Resetter<T> resetter) {
        return build(new g(i10), factory, resetter);
    }

    public static <T> e<List<T>> threadSafeList(int i10) {
        return build(new g(i10), new Factory<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public List<T> create() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            public void reset(List<T> list) {
                list.clear();
            }
        });
    }
}
