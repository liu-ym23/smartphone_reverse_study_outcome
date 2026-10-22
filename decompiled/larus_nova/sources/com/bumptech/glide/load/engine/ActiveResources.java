package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes39.dex */
final class ActiveResources {
    final Map<Key, ResourceWeakReference> activeEngineResources;

    /* JADX INFO: renamed from: cb, reason: collision with root package name */
    private volatile DequeuedResourceCallback f33690cb;
    private final boolean isActiveResourceRetentionAllowed;
    private volatile boolean isShutdown;
    private EngineResource.ResourceListener listener;
    private final Executor monitorClearedResourcesExecutor;
    private final ReferenceQueue<EngineResource<?>> resourceReferenceQueue;

    public interface DequeuedResourceCallback {
        void onResourceDequeued();
    }

    public static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {
        final boolean isCacheable;
        final Key key;
        Resource<?> resource;

        public void reset() {
            this.resource = null;
            clear();
        }

        public ResourceWeakReference(Key r100, EngineResource<?> r101, ReferenceQueue<? super EngineResource<?>> r102, boolean r103) {
            super(r101, r102);
            this.key = (Key) Preconditions.checkNotNull(r100);
            if (r101.isMemoryCacheable() == false) goto L6;
            if (r103 == false) goto L6;
            Resource<?> r104 = (Resource) Preconditions.checkNotNull(r101.getResource());
        L7:
            this.resource = r104;
            this.isCacheable = r101.isMemoryCacheable();
            return;
        L6:
            r104 = null;
            goto L7
        }
    }

    public void shutdown() {
        this.isShutdown = true;
        Executor r100 = this.monitorClearedResourcesExecutor;
        if ((r100 instanceof ExecutorService) == false) goto L6;
        Executors.shutdownAndAwaitTermination((ExecutorService) r100);
        return;
    }

    public void cleanReferenceQueue() {
    L3:
        if (this.isShutdown == true) goto L9;
        cleanupActiveReference((ResourceWeakReference) this.resourceReferenceQueue.remove());     // Catch: InterruptedException -> L8
        DequeuedResourceCallback r100 = this.f33690cb;     // Catch: InterruptedException -> L8
        if (r100 == null) goto L3;
        r100.onResourceDequeued();     // Catch: InterruptedException -> L8
    L8:
        ThreadMethodProxy.currentThread().interrupt();
        goto L3
    }

    public ActiveResources(boolean r100) {
        this(r100, PThreadExecutorsUtils.newSingleThreadExecutor(new AnonymousClass1()));
    }

    public void cleanupActiveReference(ResourceWeakReference r100) {
        monitor-enter(this);
        this.activeEngineResources.remove(r100.key);     // Catch: Throwable -> L13
        if (r100.isCacheable == false) goto L11;
        Resource<?> r101 = r100.resource;     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L13
        EngineResource<?> r102 = new EngineResource(r101, true, false, r100.key, this.listener);
        this.listener.onResourceReleased(r100.key, r102);
        return;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized void deactivate(Key r100) {
        monitor-enter(this);
        ResourceWeakReference r101 = this.activeEngineResources.remove(r100);     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        r101.reset();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized EngineResource<?> get(Key r100) {
        monitor-enter(this);
        ResourceWeakReference r101 = this.activeEngineResources.get(r100);     // Catch: Throwable -> L13
        if (r101 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        EngineResource<?> r102 = r101.get();     // Catch: Throwable -> L13
        if (r102 != null) goto L11;
        cleanupActiveReference(r101);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return r102;
    L13:
        th = move-exception;
        throw th;
    }

    public void setDequeuedResourceCallback(DequeuedResourceCallback r100) {
        this.f33690cb = r100;
    }

    public void setListener(EngineResource.ResourceListener r100) {
        monitor-enter(r100);
        monitor-enter(this);     // Catch: Throwable -> L11
        this.listener = r100;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public ActiveResources(boolean r100, Executor r101) {
        this.activeEngineResources = new HashMap();
        this.resourceReferenceQueue = new ReferenceQueue();
        this.isActiveResourceRetentionAllowed = r100;
        this.monitorClearedResourcesExecutor = r101;
        r101.execute(new AnonymousClass2(this));
    }

    public synchronized void activate(Key r100, EngineResource<?> r101) {
        monitor-enter(this);
        ResourceWeakReference r102 = new ResourceWeakReference(r100, r101, this.resourceReferenceQueue, this.isActiveResourceRetentionAllowed);     // Catch: Throwable -> L8
        ResourceWeakReference r103 = this.activeEngineResources.put(r100, r102);     // Catch: Throwable -> L8
        if (r103 == null) goto L6;
        r103.reset();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
