package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.util.d;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FactoryPools {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final Resetter<Object> EMPTY_RESETTER = null;
    private static final String TAG = "FactoryPools";

    public interface Factory<T> {
        T create();
    }

    public static final class FactoryPool<T> implements Pools$Pool<T> {
        private final Factory<T> factory;
        private final Pools$Pool<T> pool;
        private final Resetter<T> resetter;

        public FactoryPool(@NonNull Pools$Pool<T> r10, @NonNull Factory<T> r11, @NonNull Resetter<T> r12) {
            this.pool = r10;
            this.factory = r11;
            this.resetter = r12;
        }

        @Override // androidx.core.util.Pools$Pool
        public T acquire() {
            T r10 = this.pool.acquire();
            if (r10 != null) goto L8;
            r10 = this.factory.create();
            if (Log.isLoggable(FactoryPools.TAG, 2) == false) goto L8;
            Log.v(FactoryPools.TAG, "Created new " + r10.getClass());
        L8:
            if ((r10 instanceof Poolable) == false) goto L10;
            ((Poolable) r10).getVerifier().setRecycled(false);
        L10:
            return r10;
        }

        @Override // androidx.core.util.Pools$Pool
        public boolean release(@NonNull T r10) {
            if ((r10 instanceof Poolable) == false) goto L5;
            ((Poolable) r10).getVerifier().setRecycled(true);
        L5:
            this.resetter.reset(r10);
            return this.pool.release(r10);
        }
    }

    public interface Poolable {
        @NonNull
        StateVerifier getVerifier();
    }

    public interface Resetter<T> {
        void reset(@NonNull T r10);
    }

    static {
        EMPTY_RESETTER = new AnonymousClass1();
    }

    private FactoryPools() {
    }

    @NonNull
    private static <T extends Poolable> Pools$Pool<T> build(@NonNull Pools$Pool<T> r10, @NonNull Factory<T> r11) {
        return build(r10, r11, emptyResetter());
    }

    @NonNull
    private static <T> Resetter<T> emptyResetter() {
        return (Resetter<T>) EMPTY_RESETTER;
    }

    @NonNull
    public static <T extends Poolable> Pools$Pool<T> simple(int r10, @NonNull Factory<T> r11) {
        return build(new d(r10), r11);
    }

    @NonNull
    public static <T extends Poolable> Pools$Pool<T> threadSafe(int r10, @NonNull Factory<T> r11) {
        return build(new Pools$SynchronizedPool(r10), r11);
    }

    @NonNull
    public static <T> Pools$Pool<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    @NonNull
    private static <T> Pools$Pool<T> build(@NonNull Pools$Pool<T> r10, @NonNull Factory<T> r11, @NonNull Resetter<T> r12) {
        return new FactoryPool(r10, r11, r12);
    }

    @NonNull
    public static <T> Pools$Pool<List<T>> threadSafeList(int r10) {
        return build(new Pools$SynchronizedPool(r10), new AnonymousClass2(), new AnonymousClass3());
    }
}
