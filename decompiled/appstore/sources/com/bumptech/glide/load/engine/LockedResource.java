package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

/* JADX INFO: loaded from: classes.dex */
final class LockedResource<Z> implements Resource<Z>, FactoryPools.Poolable {
    private static final Pools$Pool<LockedResource<?>> POOL = null;
    private boolean isLocked;
    private boolean isRecycled;
    private final StateVerifier stateVerifier;
    private Resource<Z> toWrap;

    static {
        POOL = FactoryPools.threadSafe(20, new AnonymousClass1());
    }

    public LockedResource() {
        this.stateVerifier = StateVerifier.newInstance();
    }

    private void init(Resource<Z> r10) {
        this.isRecycled = false;
        this.isLocked = true;
        this.toWrap = r10;
    }

    @NonNull
    public static <Z> LockedResource<Z> obtain(Resource<Z> r10) {
        LockedResource<Z> r11 = (LockedResource) Preconditions.checkNotNull(POOL.acquire());
        r11.init(r10);
        return r11;
    }

    private void release() {
        this.toWrap = null;
        POOL.release(this);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Z get() {
        return this.toWrap.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<Z> getResourceClass() {
        return this.toWrap.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.toWrap.getSize();
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L7
        this.isRecycled = true;     // Catch: Throwable -> L7
        if (this.isLocked == true) goto L9;
        this.toWrap.recycle();     // Catch: Throwable -> L7
        release();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void unlock() {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L9
        if (this.isLocked == false) goto L14;
        this.isLocked = false;     // Catch: Throwable -> L9
        if (this.isRecycled == false) goto L11;
        recycle();     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);
        return;
    L14:
        throw new IllegalStateException("Already unlocked");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }
}
