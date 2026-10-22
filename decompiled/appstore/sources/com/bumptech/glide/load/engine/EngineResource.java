package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
class EngineResource<Z> implements Resource<Z> {
    private int acquired;
    private final boolean isCacheable;
    private final boolean isRecyclable;
    private boolean isRecycled;
    private Key key;
    private ResourceListener listener;
    private final Resource<Z> resource;

    public interface ResourceListener {
        void onResourceReleased(Key r10, EngineResource<?> r11);
    }

    public EngineResource(Resource<Z> r10, boolean r11, boolean r12) {
        this.resource = (Resource) Preconditions.checkNotNull(r10);
        this.isCacheable = r11;
        this.isRecyclable = r12;
    }

    public synchronized void acquire() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.isRecycled == true) goto L11;
        this.acquired++;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IllegalStateException("Cannot acquire a recycled resource");     // Catch: Throwable -> L8
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Z get() {
        return this.resource.get();
    }

    public Resource<Z> getResource() {
        return this.resource;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<Z> getResourceClass() {
        return this.resource.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.resource.getSize();
    }

    public boolean isCacheable() {
        return this.isCacheable;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.acquired > 0) goto L18;
        if (this.isRecycled == true) goto L16;
        this.isRecycled = true;     // Catch: Throwable -> L11
        if (this.isRecyclable == false) goto L13;
        this.resource.recycle();     // Catch: Throwable -> L11
    L13:
        monitor-exit(this);
        return;
    L16:
        throw new IllegalStateException("Cannot recycle a resource that has already been recycled");     // Catch: Throwable -> L11
    L18:
        throw new IllegalStateException("Cannot recycle a resource while it is still acquired");     // Catch: Throwable -> L11
    }

    public void release() {
        ResourceListener r10 = this.listener;
        monitor-enter(r10);
        monitor-enter(this);     // Catch: Throwable -> L15
        int r11 = this.acquired;     // Catch: Throwable -> L10
        if (r11 <= 0) goto L18;
        int r12 = r11 - 1;     // Catch: Throwable -> L10
        this.acquired = r12;     // Catch: Throwable -> L10
        if (r12 != 0) goto L12;
        this.listener.onResourceReleased(this.key, this);     // Catch: Throwable -> L10
    L12:
        monitor-exit(this);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L18:
        throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized void setResourceListener(Key r10, ResourceListener r11) {
        monitor-enter(this);
        this.key = r10;     // Catch: Throwable -> L6
        this.listener = r11;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String toString() {
        monitor-enter(this);
        String r10 = "EngineResource{isCacheable=" + this.isCacheable + ", listener=" + this.listener + ", key=" + this.key + ", acquired=" + this.acquired + ", isRecycled=" + this.isRecycled + ", resource=" + this.resource + '}';     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }
}
