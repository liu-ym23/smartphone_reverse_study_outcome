package com.fasterxml.jackson.core.util;

import b8.q0;
import com.fasterxml.jackson.core.util.RecyclerPool;
import g5.f;
import java.lang.invoke.VarHandle;
import java.util.Optional;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class JsonRecyclerPools {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
            f.s(k0.a.j(i, "capacity must be > 0, was: "));
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ RecyclerPool.StatefulImplBase lambda$readResolve$0() {
            return construct(this._serialization);
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool.StatefulImplBase
        public BufferRecycler createPooled() {
            return new BufferRecycler();
        }

        public Object readResolve() {
            Optional<RecyclerPool.StatefulImplBase<P>> optional_resolveToShared = _resolveToShared(GLOBAL);
            q0 q0Var = new q0(1);
            q0Var.f2013f = this;
            VarHandle.storeStoreFence();
            return optional_resolveToShared.orElseGet(q0Var);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class ConcurrentDequePool extends RecyclerPool.ConcurrentDequePoolBase<BufferRecycler> {
        protected static final ConcurrentDequePool GLOBAL = new ConcurrentDequePool(-1);
        private static final long serialVersionUID = 1;

        public ConcurrentDequePool(int i) {
            super(i);
        }

        public static ConcurrentDequePool construct() {
            return new ConcurrentDequePool(1);
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool.StatefulImplBase
        public BufferRecycler createPooled() {
            return new BufferRecycler();
        }

        public Object readResolve() {
            return _resolveToShared(GLOBAL).orElseGet(new a(0));
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        @Override // com.fasterxml.jackson.core.util.RecyclerPool.StatefulImplBase
        public BufferRecycler createPooled() {
            return new BufferRecycler();
        }

        public Object readResolve() {
            return _resolveToShared(GLOBAL).orElseGet(new a(1));
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class NonRecyclingPool extends RecyclerPool.NonRecyclingPoolBase<BufferRecycler> {
        protected static final NonRecyclingPool GLOBAL = new NonRecyclingPool();
        private static final long serialVersionUID = 1;

        @Override // com.fasterxml.jackson.core.util.RecyclerPool.NonRecyclingPoolBase, com.fasterxml.jackson.core.util.RecyclerPool
        public BufferRecycler acquirePooled() {
            return new BufferRecycler();
        }

        public Object readResolve() {
            return GLOBAL;
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
}
