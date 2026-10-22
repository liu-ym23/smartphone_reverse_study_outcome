package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class Engine implements EngineJobListener, MemoryCache.ResourceRemovedListener, EngineResource.ResourceListener {
    private static final int JOB_POOL_SIZE = 150;
    private static final String TAG = "Engine";
    private static final boolean VERBOSE_IS_LOGGABLE = false;
    private final ActiveResources activeResources;
    private final MemoryCache cache;
    private final DecodeJobFactory decodeJobFactory;
    private final LazyDiskCacheProvider diskCacheProvider;
    private final EngineJobFactory engineJobFactory;
    private final Jobs jobs;
    private final EngineKeyFactory keyFactory;
    private final ResourceRecycler resourceRecycler;

    @VisibleForTesting
    public static class DecodeJobFactory {
        private int creationOrder;
        final DecodeJob.DiskCacheProvider diskCacheProvider;
        final Pools$Pool<DecodeJob<?>> pool;

        public DecodeJobFactory(DecodeJob.DiskCacheProvider r10) {
            this.pool = FactoryPools.threadSafe(150, new AnonymousClass1(this));
            this.diskCacheProvider = r10;
        }

        public <R> DecodeJob<R> build(GlideContext r20, Object r21, EngineKey r22, Key r23, int r24, int r25, Class<?> r26, Class<R> r27, Priority r28, DiskCacheStrategy r29, Map<Class<?>, Transformation<?>> r30, boolean r31, boolean r32, boolean r33, Options r34, DecodeJob.Callback<R> r35) {
            DecodeJob r10 = (DecodeJob) Preconditions.checkNotNull(this.pool.acquire());
            int r11 = this.creationOrder;
            this.creationOrder = r11 + 1;
            return r10.init(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r11);
        }
    }

    @VisibleForTesting
    public static class EngineJobFactory {
        final GlideExecutor animationExecutor;
        final GlideExecutor diskCacheExecutor;
        final EngineJobListener listener;
        final Pools$Pool<EngineJob<?>> pool;
        final GlideExecutor sourceExecutor;
        final GlideExecutor sourceUnlimitedExecutor;

        public EngineJobFactory(GlideExecutor r10, GlideExecutor r11, GlideExecutor r12, GlideExecutor r13, EngineJobListener r14) {
            this.pool = FactoryPools.threadSafe(150, new AnonymousClass1(this));
            this.diskCacheExecutor = r10;
            this.sourceExecutor = r11;
            this.sourceUnlimitedExecutor = r12;
            this.animationExecutor = r13;
            this.listener = r14;
        }

        public <R> EngineJob<R> build(Key r10, boolean r11, boolean r12, boolean r13, boolean r14) {
            return ((EngineJob) Preconditions.checkNotNull(this.pool.acquire())).init(r10, r11, r12, r13, r14);
        }

        @VisibleForTesting
        public void shutdown() {
            Executors.shutdownAndAwaitTermination(this.diskCacheExecutor);
            Executors.shutdownAndAwaitTermination(this.sourceExecutor);
            Executors.shutdownAndAwaitTermination(this.sourceUnlimitedExecutor);
            Executors.shutdownAndAwaitTermination(this.animationExecutor);
        }
    }

    public static class LazyDiskCacheProvider implements DecodeJob.DiskCacheProvider {
        private volatile DiskCache diskCache;
        private final DiskCache.Factory factory;

        public LazyDiskCacheProvider(DiskCache.Factory r10) {
            this.factory = r10;
        }

        @VisibleForTesting
        public synchronized void clearDiskCacheIfCreated() {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.diskCache != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            this.diskCache.clear();     // Catch: Throwable -> L10
            monitor-exit(this);
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider
        public DiskCache getDiskCache() {
            if (this.diskCache != null) goto L18;
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L6:
            if (this.diskCache != null) goto L11;
            this.diskCache = this.factory.build();     // Catch: Throwable -> L8
        L11:
            if (this.diskCache != null) goto L13;
            this.diskCache = new DiskCacheAdapter();     // Catch: Throwable -> L8
        L13:
            monitor-exit(this);     // Catch: Throwable -> L8
        L18:
            return this.diskCache;
        }
    }

    public class LoadStatus {

        /* JADX INFO: renamed from: cb, reason: collision with root package name */
        private final ResourceCallback f6225cb;
        private final EngineJob<?> engineJob;
        final /* synthetic */ Engine this$0;

        public LoadStatus(Engine r10, ResourceCallback r11, EngineJob<?> r12) {
            this.this$0 = r10;
            this.f6225cb = r11;
            this.engineJob = r12;
        }

        public void cancel() {
            Engine r10 = this.this$0;
            monitor-enter(r10);
            this.engineJob.removeCallback(this.f6225cb);     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        VERBOSE_IS_LOGGABLE = Log.isLoggable(TAG, 2);
    }

    public Engine(MemoryCache r15, DiskCache.Factory r16, GlideExecutor r17, GlideExecutor r18, GlideExecutor r19, GlideExecutor r20, boolean r21) {
        this(r15, r16, r17, r18, r19, r20, null, null, null, null, null, null, r21);
    }

    private EngineResource<?> getEngineResourceFromCache(Key r10) {
        Resource<?> r11 = this.cache.remove(r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        if ((r11 instanceof EngineResource) == false) goto L9;
        return (EngineResource) r11;
    L9:
        return new EngineResource(r11, true, true);
    }

    @Nullable
    private EngineResource<?> loadFromActiveResources(Key r10, boolean r11) {
        if (r11 == true) goto L5;
        return null;
    L5:
        EngineResource<?> r12 = this.activeResources.get(r10);
        if (r12 == null) goto L8;
        r12.acquire();
    L8:
        return r12;
    }

    private EngineResource<?> loadFromCache(Key r10, boolean r11) {
        if (r11 == true) goto L5;
        return null;
    L5:
        EngineResource<?> r12 = getEngineResourceFromCache(r10);
        if (r12 == null) goto L8;
        r12.acquire();
        this.activeResources.activate(r10, r12);
    L8:
        return r12;
    }

    private static void logWithTimeAndKey(String r10, long r11, Key r12) {
        Log.v(TAG, r10 + " in " + LogTime.getElapsedMillis(r11) + "ms, key: " + r12);
    }

    public void clearDiskCache() {
        this.diskCacheProvider.getDiskCache().clear();
    }

    public synchronized <R> LoadStatus load(GlideContext r32, Object r33, Key r34, int r35, int r36, Class<?> r37, Class<R> r38, Priority r39, DiskCacheStrategy r40, Map<Class<?>, Transformation<?>> r41, boolean r42, boolean r43, Options r44, boolean r45, boolean r46, boolean r47, boolean r48, ResourceCallback r49, Executor r50) {
        monitor-enter(this);
        boolean r10 = VERBOSE_IS_LOGGABLE;     // Catch: Throwable -> L8
        if (r10 == false) goto L10;
        long r11 = LogTime.getLogTime();     // Catch: Throwable -> L8
    L7:
        long r12 = r11;
        EngineKey r13 = this.keyFactory.buildKey(r33, r34, r35, r36, r41, r37, r38, r44);     // Catch: Throwable -> L8
        EngineResource<?> r14 = loadFromActiveResources(r13, r45);     // Catch: Throwable -> L8
        if (r14 == null) goto L18;
        r49.onResourceReady(r14, DataSource.MEMORY_CACHE);     // Catch: Throwable -> L8
        if (r10 == false) goto L16;
        logWithTimeAndKey("Loaded resource from active resources", r12, r13);     // Catch: Throwable -> L8
    L16:
        monitor-exit(this);
        return null;
    L18:
        EngineResource<?> r15 = loadFromCache(r13, r45);     // Catch: Throwable -> L8
        if (r15 == null) goto L25;
        r49.onResourceReady(r15, DataSource.MEMORY_CACHE);     // Catch: Throwable -> L8
        if (r10 == false) goto L23;
        logWithTimeAndKey("Loaded resource from cache", r12, r13);     // Catch: Throwable -> L8
    L23:
        monitor-exit(this);
        return null;
    L25:
        EngineJob<?> r16 = this.jobs.get(r13, r48);     // Catch: Throwable -> L8
        if (r16 == null) goto L33;
        r16.addCallback(r49, r50);     // Catch: Throwable -> L8
        if (r10 == false) goto L30;
        logWithTimeAndKey("Added to existing load", r12, r13);     // Catch: Throwable -> L8
    L30:
        LoadStatus r17 = new LoadStatus(this, r49, r16);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r17;
    L33:
        EngineJob<R> r18 = this.engineJobFactory.build(r13, r45, r46, r47, r48);     // Catch: Throwable -> L8
        DecodeJob<R> r19 = this.decodeJobFactory.build(r32, r33, r13, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r48, r44, r18);     // Catch: Throwable -> L8
        this.jobs.put(r13, r18);     // Catch: Throwable -> L8
        r18.addCallback(r49, r50);     // Catch: Throwable -> L8
        r18.start(r19);     // Catch: Throwable -> L8
        if (r10 == false) goto L36;
        logWithTimeAndKey("Started new load", r12, r13);     // Catch: Throwable -> L8
    L36:
        LoadStatus r20 = new LoadStatus(this, r49, r18);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r20;
    L10:
        r11 = 0;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public synchronized void onEngineJobCancelled(EngineJob<?> r10, Key r11) {
        monitor-enter(this);
        this.jobs.removeIfCurrent(r11, r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public synchronized void onEngineJobComplete(EngineJob<?> r10, Key r11, EngineResource<?> r12) {
        monitor-enter(this);
        if (r12 != null) goto L14;
    L9:
        this.jobs.removeIfCurrent(r11, r10);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    L14:
        r12.setResourceListener(r11, this);     // Catch: Throwable -> L7
        if (r12.isCacheable() == false) goto L9;
        this.activeResources.activate(r11, r12);     // Catch: Throwable -> L7
        goto L9
    }

    @Override // com.bumptech.glide.load.engine.EngineResource.ResourceListener
    public synchronized void onResourceReleased(Key r10, EngineResource<?> r11) {
        monitor-enter(this);
        this.activeResources.deactivate(r10);     // Catch: Throwable -> L6
        if (r11.isCacheable() == false) goto L8;
        this.cache.put(r10, r11);     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);
        return;
    L8:
        this.resourceRecycler.recycle(r11);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener
    public void onResourceRemoved(@NonNull Resource<?> r10) {
        this.resourceRecycler.recycle(r10);
    }

    public void release(Resource<?> r10) {
        if ((r10 instanceof EngineResource) == false) goto L7;
        ((EngineResource) r10).release();
        return;
    L7:
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @VisibleForTesting
    public void shutdown() {
        this.engineJobFactory.shutdown();
        this.diskCacheProvider.clearDiskCacheIfCreated();
        this.activeResources.shutdown();
    }

    @VisibleForTesting
    public Engine(MemoryCache r11, DiskCache.Factory r12, GlideExecutor r13, GlideExecutor r14, GlideExecutor r15, GlideExecutor r16, Jobs r17, EngineKeyFactory r18, ActiveResources r19, EngineJobFactory r20, DecodeJobFactory r21, ResourceRecycler r22, boolean r23) {
        this.cache = r11;
        LazyDiskCacheProvider r10 = new LazyDiskCacheProvider(r12);
        this.diskCacheProvider = r10;
        if (r19 != null) goto L5;
        ActiveResources r24 = new ActiveResources(r23);
    L6:
        this.activeResources = r24;
        r24.setListener(this);
        if (r18 != null) goto L9;
        EngineKeyFactory r25 = new EngineKeyFactory();
    L10:
        this.keyFactory = r25;
        if (r17 != null) goto L13;
        Jobs r26 = new Jobs();
    L14:
        this.jobs = r26;
        if (r20 != null) goto L17;
        EngineJobFactory r27 = new EngineJobFactory(r13, r14, r15, r16, this);
    L18:
        this.engineJobFactory = r27;
        if (r21 != null) goto L21;
        DecodeJobFactory r28 = new DecodeJobFactory(r10);
    L22:
        this.decodeJobFactory = r28;
        if (r22 != null) goto L25;
        ResourceRecycler r29 = new ResourceRecycler();
    L26:
        this.resourceRecycler = r29;
        r11.setResourceRemovedListener(this);
        return;
    L25:
        r29 = r22;
        goto L26
    L21:
        r28 = r21;
        goto L22
    L17:
        r27 = r20;
        goto L18
    L13:
        r26 = r17;
        goto L14
    L9:
        r25 = r18;
        goto L10
    L5:
        r24 = r19;
        goto L6
    }
}
