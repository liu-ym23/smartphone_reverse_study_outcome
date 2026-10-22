package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.JsonRecyclerPools;
import com.fasterxml.jackson.core.util.RecyclerPool;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class JsonRecyclerPools {

    public static class BoundedPool extends RecyclerPool.BoundedPoolBase<BufferRecycler> {
        protected static final BoundedPool GLOBAL = new BoundedPool(-1);
        private static final long serialVersionUID = 1;

        public BoundedPool(int i10) {
            super(i10);
        }

        public static BoundedPool construct(int i10) {
            if (i10 > 0) {
                return new BoundedPool(i10);
            }
            throw new IllegalArgumentException("capacity must be > 0, was: " + i10);
        }

        public Object readResolve() {
            return _resolveToShared(GLOBAL).orElseGet(new Supplier() { // from class: com.fasterxml.jackson.core.util.a
                @Override // java.util.function.Supplier
                public final Object get() {
                    return JsonRecyclerPools.BoundedPool.construct(this.f19337a._serialization);
                }
            });
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool.StatefulImplBase
        public BufferRecycler createPooled() {
            return new BufferRecycler();
        }
    }

    public static class ConcurrentDequePool extends RecyclerPool.ConcurrentDequePoolBase<BufferRecycler> {
        protected static final ConcurrentDequePool GLOBAL = new ConcurrentDequePool(-1);
        private static final long serialVersionUID = 1;

        public ConcurrentDequePool(int i10) {
            super(i10);
        }

        public static ConcurrentDequePool construct() {
            return new ConcurrentDequePool(1);
        }

        public Object readResolve() {
            return _resolveToShared(GLOBAL).orElseGet(new Supplier() { // from class: com.fasterxml.jackson.core.util.b
                @Override // java.util.function.Supplier
                public final Object get() {
                    return JsonRecyclerPools.ConcurrentDequePool.construct();
                }
            });
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool.StatefulImplBase
        public BufferRecycler createPooled() {
            return new BufferRecycler();
        }
    }

    @Deprecated
    public static class LockFreePool extends RecyclerPool.LockFreePoolBase<BufferRecycler> {
        protected static final LockFreePool GLOBAL = new LockFreePool(-1);
        private static final long serialVersionUID = 1;

        public LockFreePool(int i10) {
            super(i10);
        }

        public static LockFreePool construct() {
            return new LockFreePool(1);
        }

        public Object readResolve() {
            return _resolveToShared(GLOBAL).orElseGet(new Supplier() { // from class: com.fasterxml.jackson.core.util.c
                @Override // java.util.function.Supplier
                public final Object get() {
                    return JsonRecyclerPools.LockFreePool.construct();
                }
            });
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool.StatefulImplBase
        public BufferRecycler createPooled() {
            return new BufferRecycler();
        }
    }

    public static class NonRecyclingPool extends RecyclerPool.NonRecyclingPoolBase<BufferRecycler> {
        protected static final NonRecyclingPool GLOBAL = new NonRecyclingPool();
        private static final long serialVersionUID = 1;

        public Object readResolve() {
            return GLOBAL;
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool.NonRecyclingPoolBase, com.fasterxml.jackson.core.util.RecyclerPool
        public BufferRecycler acquirePooled() {
            return new BufferRecycler();
        }
    }

    public static class ThreadLocalPool extends RecyclerPool.ThreadLocalPoolBase<BufferRecycler> {
        protected static final ThreadLocalPool GLOBAL = new ThreadLocalPool();
        private static final long serialVersionUID = 1;

        private ThreadLocalPool() {
        }

        public Object readResolve() {
            return GLOBAL;
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool.ThreadLocalPoolBase, com.fasterxml.jackson.core.util.RecyclerPool
        public BufferRecycler acquirePooled() {
            return BufferRecyclers.getBufferRecycler();
        }
    }

    public static RecyclerPool<BufferRecycler> defaultPool() {
        return threadLocalPool();
    }

    public static RecyclerPool<BufferRecycler> newBoundedPool(int i10) {
        return BoundedPool.construct(i10);
    }

    public static RecyclerPool<BufferRecycler> newConcurrentDequePool() {
        return ConcurrentDequePool.construct();
    }

    @Deprecated
    public static RecyclerPool<BufferRecycler> newLockFreePool() {
        return LockFreePool.construct();
    }

    public static RecyclerPool<BufferRecycler> nonRecyclingPool() {
        return NonRecyclingPool.GLOBAL;
    }

    public static RecyclerPool<BufferRecycler> sharedBoundedPool() {
        return BoundedPool.GLOBAL;
    }

    public static RecyclerPool<BufferRecycler> sharedConcurrentDequePool() {
        return ConcurrentDequePool.GLOBAL;
    }

    @Deprecated
    public static RecyclerPool<BufferRecycler> sharedLockFreePool() {
        return LockFreePool.GLOBAL;
    }

    public static RecyclerPool<BufferRecycler> threadLocalPool() {
        return ThreadLocalPool.GLOBAL;
    }
}
