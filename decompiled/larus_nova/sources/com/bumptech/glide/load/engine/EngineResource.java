package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes39.dex */
class EngineResource<Z> implements Resource<Z> {
    private int acquired;
    private final boolean isMemoryCacheable;
    private final boolean isRecyclable;
    private boolean isRecycled;
    private final Key key;
    private final ResourceListener listener;
    private final Resource<Z> resource;

    public interface ResourceListener {
        void onResourceReleased(Key r100, EngineResource<?> r101);
    }

    public synchronized void acquire() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.isRecycled == true) goto L9;
        this.acquired++;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IllegalStateException("Cannot acquire a recycled resource");     // Catch: Throwable -> L10
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.acquired > 0) goto L15;
        if (this.isRecycled == true) goto L13;
        this.isRecycled = true;     // Catch: Throwable -> L16
        if (this.isRecyclable == false) goto L10;
        this.resource.recycle();     // Catch: Throwable -> L16
    L10:
        monitor-exit(this);
        return;
    L13:
        throw new IllegalStateException("Cannot recycle a resource that has already been recycled");     // Catch: Throwable -> L16
    L15:
        throw new IllegalStateException("Cannot recycle a resource while it is still acquired");     // Catch: Throwable -> L16
    }

    public void release() {
        monitor-enter(this);
        int r100 = this.acquired;     // Catch: Throwable -> L15
        if (r100 <= 0) goto L14;
        boolean r101 = true;
        int r102 = r100 - 1;     // Catch: Throwable -> L15
        this.acquired = r102;     // Catch: Throwable -> L15
        if (r102 == 0) goto L9;
        r101 = false;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r101 == false) goto L19;
        this.listener.onResourceReleased(this.key, this);
        return;
    L19:
        return;
    L14:
        throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Z get() {
        return this.resource.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Z> getResourceClass() {
        return this.resource.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.resource.getSize();
    }

    public synchronized String toString() {
        monitor-enter(this);
        String r100 = "EngineResource{isMemoryCacheable=" + this.isMemoryCacheable + ", listener=" + this.listener + ", key=" + this.key + ", acquired=" + this.acquired + ", isRecycled=" + this.isRecycled + ", resource=" + this.resource + '}';     // Catch: Throwable -> L7
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public Resource<Z> getResource() {
        return this.resource;
    }

    public boolean isMemoryCacheable() {
        return this.isMemoryCacheable;
    }

    public EngineResource(Resource<Z> r100, boolean r101, boolean r102, Key r103, ResourceListener r104) {
        this.resource = (Resource) Preconditions.checkNotNull(r100);
        this.isMemoryCacheable = r101;
        this.isRecyclable = r102;
        this.key = r103;
        this.listener = (ResourceListener) Preconditions.checkNotNull(r104);
    }
}
