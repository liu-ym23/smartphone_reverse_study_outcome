package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
final class ActiveResources {

    @VisibleForTesting
    final Map<Key, ResourceWeakReference> activeEngineResources;

    /* JADX INFO: renamed from: cb, reason: collision with root package name */
    @Nullable
    private volatile DequeuedResourceCallback f6223cb;
    private final boolean isActiveResourceRetentionAllowed;
    private volatile boolean isShutdown;
    private EngineResource.ResourceListener listener;
    private final Executor monitorClearedResourcesExecutor;
    private final ReferenceQueue<EngineResource<?>> resourceReferenceQueue;

    @VisibleForTesting
    public interface DequeuedResourceCallback {
        void onResourceDequeued();
    }

    @VisibleForTesting
    public static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {
        final boolean isCacheable;
        final Key key;

        @Nullable
        Resource<?> resource;

        public ResourceWeakReference(@NonNull Key r10, @NonNull EngineResource<?> r11, @NonNull ReferenceQueue<? super EngineResource<?>> r12, boolean r13) {
            super(r11, r12);
            this.key = (Key) Preconditions.checkNotNull(r10);
            if (r11.isCacheable() == false) goto L6;
            if (r13 == false) goto L6;
            Resource<?> r14 = (Resource) Preconditions.checkNotNull(r11.getResource());
        L7:
            this.resource = r14;
            this.isCacheable = r11.isCacheable();
            return;
        L6:
            r14 = null;
            goto L7
        }

        public void reset() {
            this.resource = null;
            clear();
        }
    }

    public ActiveResources(boolean r10) {
        this(r10, Executors.newSingleThreadExecutor(new AnonymousClass1()));
    }

    public synchronized void activate(Key r10, EngineResource<?> r11) {
        monitor-enter(this);
        ResourceWeakReference r12 = new ResourceWeakReference(r10, r11, this.resourceReferenceQueue, this.isActiveResourceRetentionAllowed);     // Catch: Throwable -> L7
        ResourceWeakReference r13 = this.activeEngineResources.put(r10, r12);     // Catch: Throwable -> L7
        if (r13 == null) goto L9;
        r13.reset();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void cleanReferenceQueue() {
    L3:
        if (this.isShutdown == true) goto L9;
        cleanupActiveReference((ResourceWeakReference) this.resourceReferenceQueue.remove());     // Catch: InterruptedException -> L8
        DequeuedResourceCallback r10 = this.f6223cb;     // Catch: InterruptedException -> L8
        if (r10 == null) goto L3;
        r10.onResourceDequeued();     // Catch: InterruptedException -> L8
    L8:
        Thread.currentThread().interrupt();
        goto L3
    }

    public void cleanupActiveReference(@NonNull ResourceWeakReference r10) {
        EngineResource.ResourceListener r11 = this.listener;
        monitor-enter(r11);
        monitor-enter(this);     // Catch: Throwable -> L14
        this.activeEngineResources.remove(r10.key);     // Catch: Throwable -> L16
        if (r10.isCacheable == false) goto L18;
        Resource<?> r12 = r10.resource;     // Catch: Throwable -> L16
        if (r12 == null) goto L18;
        EngineResource<?> r13 = new EngineResource(r12, true, false);     // Catch: Throwable -> L16
        r13.setResourceListener(r10.key, this.listener);     // Catch: Throwable -> L16
        this.listener.onResourceReleased(r10.key, r13);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L14
        return;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L14
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized void deactivate(Key r10) {
        monitor-enter(this);
        ResourceWeakReference r11 = this.activeEngineResources.remove(r10);     // Catch: Throwable -> L7
        if (r11 == null) goto L9;
        r11.reset();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Nullable
    public synchronized EngineResource<?> get(Key r10) {
        monitor-enter(this);
        ResourceWeakReference r11 = this.activeEngineResources.get(r10);     // Catch: Throwable -> L12
        if (r11 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        EngineResource<?> r12 = r11.get();     // Catch: Throwable -> L12
        if (r12 != null) goto L14;
        cleanupActiveReference(r11);     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);
        return r12;
    L12:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public void setDequeuedResourceCallback(DequeuedResourceCallback r10) {
        this.f6223cb = r10;
    }

    public void setListener(EngineResource.ResourceListener r10) {
        monitor-enter(r10);
        monitor-enter(this);     // Catch: Throwable -> L8
        this.listener = r10;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public void shutdown() {
        this.isShutdown = true;
        Executor r10 = this.monitorClearedResourcesExecutor;
        if ((r10 instanceof ExecutorService) == false) goto L6;
        com.bumptech.glide.util.Executors.shutdownAndAwaitTermination((ExecutorService) r10);
        return;
    }

    @VisibleForTesting
    public ActiveResources(boolean r10, Executor r11) {
        this.activeEngineResources = new HashMap();
        this.resourceReferenceQueue = new ReferenceQueue();
        this.isActiveResourceRetentionAllowed = r10;
        this.monitorClearedResourcesExecutor = r11;
        r11.execute(new AnonymousClass2(this));
    }
}
