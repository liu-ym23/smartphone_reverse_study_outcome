package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.RecyclerPool;

/* loaded from: classes2.dex */
public final class JsonRecyclerPools {

    public static class BoundedPool extends RecyclerPool.BoundedPoolBase<BufferRecycler> {
        protected static final BoundedPool GLOBAL = new BoundedPool(-1);
        private static final long serialVersionUID = 1;

        public BoundedPool(int i) {
            super(i);
        }

        public static BoundedPool construct(int i) {
            if (i > 0) {
                return new BoundedPool(i);
            }
            throw new IllegalArgumentException(B7.a.h(i, "capacity must be > 0, was: "));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ RecyclerPool.StatefulImplBase lambda$readResolve$0() {
            return construct(this._serialization);
        }

        public Object readResolve() {
            return _resolveToShared(GLOBAL).orElseGet(new a(this, 0));
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool.StatefulImplBase
        public BufferRecycler createPooled() {
            return new BufferRecycler();
        }
    }

    public static class ConcurrentDequePool extends RecyclerPool.ConcurrentDequePoolBase<BufferRecycler> {
        protected static final ConcurrentDequePool GLOBAL = new ConcurrentDequePool(-1);
        private static final long serialVersionUID = 1;

        public ConcurrentDequePool(int i) {
            super(i);
        }

        public static ConcurrentDequePool construct() {
            return new ConcurrentDequePool(1);
        }

        public Object readResolve() {
            return _resolveToShared(GLOBAL).orElseGet(new C3.a(3));
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

        public LockFreePool(int i) {
            super(i);
        }

        public static LockFreePool construct() {
            return new LockFreePool(1);
        }

        public Object readResolve() {
            return _resolveToShared(GLOBAL).orElseGet(new C3.a(4));
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

    public static RecyclerPool<BufferRecycler> newBoundedPool(int i) {
        return BoundedPool.construct(i);
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
