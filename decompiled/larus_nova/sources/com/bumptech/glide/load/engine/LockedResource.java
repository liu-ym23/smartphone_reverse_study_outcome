package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

/* JADX INFO: loaded from: classes39.dex */
final class LockedResource<Z> implements Resource<Z>, FactoryPools.Poolable {
    private static final Pools.Pool<LockedResource<?>> POOL = null;
    private boolean isLocked;
    private boolean isRecycled;
    private final StateVerifier stateVerifier;
    private Resource<Z> toWrap;

    private void release() {
        this.toWrap = null;
        POOL.release(this);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L8
        this.isRecycled = true;     // Catch: Throwable -> L8
        if (this.isLocked == true) goto L6;
        this.toWrap.recycle();     // Catch: Throwable -> L8
        release();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void unlock() {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L12
        if (this.isLocked == false) goto L11;
        this.isLocked = false;     // Catch: Throwable -> L12
        if (this.isRecycled == false) goto L8;
        recycle();     // Catch: Throwable -> L12
    L8:
        monitor-exit(this);
        return;
    L11:
        throw new IllegalStateException("Already unlocked");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    static {
        POOL = FactoryPools.threadSafe(20, new AnonymousClass1());
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Z get() {
        return this.toWrap.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Z> getResourceClass() {
        return this.toWrap.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.toWrap.getSize();
    }

    public LockedResource() {
        this.stateVerifier = StateVerifier.newInstance();
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    private void init(Resource<Z> r100) {
        this.isRecycled = false;
        this.isLocked = true;
        this.toWrap = r100;
    }

    public static <Z> LockedResource<Z> obtain(Resource<Z> r100) {
        LockedResource<Z> r101 = (LockedResource) Preconditions.checkNotNull(POOL.acquire());
        r101.init(r100);
        return r101;
    }
}
