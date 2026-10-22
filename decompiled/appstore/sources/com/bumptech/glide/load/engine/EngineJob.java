package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    private static final EngineResourceFactory DEFAULT_FACTORY = null;
    private final GlideExecutor animationExecutor;
    final ResourceCallbacksAndExecutors cbs;
    DataSource dataSource;
    private DecodeJob<R> decodeJob;
    private final GlideExecutor diskCacheExecutor;
    EngineResource<?> engineResource;
    private final EngineResourceFactory engineResourceFactory;
    GlideException exception;
    private boolean hasLoadFailed;
    private boolean hasResource;
    private boolean isCacheable;
    private volatile boolean isCancelled;
    private Key key;
    private final EngineJobListener listener;
    private boolean onlyRetrieveFromCache;
    private final AtomicInteger pendingCallbacks;
    private final Pools$Pool<EngineJob<?>> pool;
    private Resource<?> resource;
    private final GlideExecutor sourceExecutor;
    private final GlideExecutor sourceUnlimitedExecutor;
    private final StateVerifier stateVerifier;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorPool;

    public class CallLoadFailed implements Runnable {

        /* JADX INFO: renamed from: cb, reason: collision with root package name */
        private final ResourceCallback f6226cb;
        final /* synthetic */ EngineJob this$0;

        public CallLoadFailed(EngineJob r10, ResourceCallback r11) {
            this.this$0 = r10;
            this.f6226cb = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            EngineJob r10 = this.this$0;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.cbs.contains(this.f6226cb) == false) goto L9;
            this.this$0.callCallbackOnLoadFailed(this.f6226cb);     // Catch: Throwable -> L7
        L9:
            this.this$0.decrementPendingCallbacks();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
        }
    }

    public class CallResourceReady implements Runnable {

        /* JADX INFO: renamed from: cb, reason: collision with root package name */
        private final ResourceCallback f6227cb;
        final /* synthetic */ EngineJob this$0;

        public CallResourceReady(EngineJob r10, ResourceCallback r11) {
            this.this$0 = r10;
            this.f6227cb = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            EngineJob r10 = this.this$0;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.cbs.contains(this.f6227cb) == false) goto L9;
            this.this$0.engineResource.acquire();     // Catch: Throwable -> L7
            this.this$0.callCallbackOnResourceReady(this.f6227cb);     // Catch: Throwable -> L7
            this.this$0.removeCallback(this.f6227cb);     // Catch: Throwable -> L7
        L9:
            this.this$0.decrementPendingCallbacks();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
        }
    }

    @VisibleForTesting
    public static class EngineResourceFactory {
        public EngineResourceFactory() {
        }

        public <R> EngineResource<R> build(Resource<R> r10, boolean r11) {
            return new EngineResource(r10, r11, true);
        }
    }

    public static final class ResourceCallbackAndExecutor {

        /* JADX INFO: renamed from: cb, reason: collision with root package name */
        final ResourceCallback f6228cb;
        final Executor executor;

        public ResourceCallbackAndExecutor(ResourceCallback r10, Executor r11) {
            this.f6228cb = r10;
            this.executor = r11;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof ResourceCallbackAndExecutor) == true) goto L5;
            return false;
        L5:
            return this.f6228cb.equals(((ResourceCallbackAndExecutor) r10).f6228cb);
        }

        public int hashCode() {
            return this.f6228cb.hashCode();
        }
    }

    public static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {
        private final List<ResourceCallbackAndExecutor> callbacksAndExecutors;

        public ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
        }

        private static ResourceCallbackAndExecutor defaultCallbackAndExecutor(ResourceCallback r10) {
            return new ResourceCallbackAndExecutor(r10, Executors.directExecutor());
        }

        public void add(ResourceCallback r10, Executor r11) {
            this.callbacksAndExecutors.add(new ResourceCallbackAndExecutor(r10, r11));
        }

        public void clear() {
            this.callbacksAndExecutors.clear();
        }

        public boolean contains(ResourceCallback r10) {
            return this.callbacksAndExecutors.contains(defaultCallbackAndExecutor(r10));
        }

        public ResourceCallbacksAndExecutors copy() {
            return new ResourceCallbacksAndExecutors(new ArrayList(this.callbacksAndExecutors));
        }

        public boolean isEmpty() {
            return this.callbacksAndExecutors.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<ResourceCallbackAndExecutor> iterator() {
            return this.callbacksAndExecutors.iterator();
        }

        public void remove(ResourceCallback r10) {
            this.callbacksAndExecutors.remove(defaultCallbackAndExecutor(r10));
        }

        public int size() {
            return this.callbacksAndExecutors.size();
        }

        public ResourceCallbacksAndExecutors(List<ResourceCallbackAndExecutor> r10) {
            this.callbacksAndExecutors = r10;
        }
    }

    static {
        DEFAULT_FACTORY = new EngineResourceFactory();
    }

    public EngineJob(GlideExecutor r10, GlideExecutor r11, GlideExecutor r12, GlideExecutor r13, EngineJobListener r14, Pools$Pool<EngineJob<?>> r15) {
        this(r10, r11, r12, r13, r14, r15, DEFAULT_FACTORY);
    }

    private GlideExecutor getActiveSourceExecutor() {
        if (this.useUnlimitedSourceGeneratorPool == false) goto L6;
        return this.sourceUnlimitedExecutor;
    L6:
        if (this.useAnimationPool == false) goto L9;
        return this.animationExecutor;
    L9:
        return this.sourceExecutor;
    }

    private boolean isDone() {
        if (this.hasLoadFailed == false) goto L5;
    L10:
        return true;
    L5:
        if (this.hasResource == true) goto L10;
        if (this.isCancelled == true) goto L10;
        return false;
    }

    private synchronized void release() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.key == null) goto L11;
        this.cbs.clear();     // Catch: Throwable -> L8
        this.key = null;     // Catch: Throwable -> L8
        this.engineResource = null;     // Catch: Throwable -> L8
        this.resource = null;     // Catch: Throwable -> L8
        this.hasLoadFailed = false;     // Catch: Throwable -> L8
        this.isCancelled = false;     // Catch: Throwable -> L8
        this.hasResource = false;     // Catch: Throwable -> L8
        this.decodeJob.release(false);     // Catch: Throwable -> L8
        this.decodeJob = null;     // Catch: Throwable -> L8
        this.exception = null;     // Catch: Throwable -> L8
        this.dataSource = null;     // Catch: Throwable -> L8
        this.pool.release(this);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IllegalArgumentException();     // Catch: Throwable -> L8
    }

    public synchronized void addCallback(ResourceCallback r10, Executor r11) {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L6
        this.cbs.add(r10, r11);     // Catch: Throwable -> L6
        if (this.hasResource == false) goto L9;
        incrementPendingCallbacks(1);     // Catch: Throwable -> L6
        r11.execute(new CallResourceReady(this, r10));     // Catch: Throwable -> L6
    L12:
        monitor-exit(this);
        return;
    L9:
        if (this.hasLoadFailed == false) goto L11;
        incrementPendingCallbacks(1);     // Catch: Throwable -> L6
        r11.execute(new CallLoadFailed(this, r10));     // Catch: Throwable -> L6
        goto L12
    L11:
        Preconditions.checkArgument(!this.isCancelled, "Cannot add callbacks to a cancelled EngineJob");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void callCallbackOnLoadFailed(ResourceCallback r10) {
        monitor-enter(this);
        r10.onLoadFailed(this.exception);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        throw th;
    L8:
        throw new CallbackException(th);     // Catch: Throwable -> L9
    }

    public synchronized void callCallbackOnResourceReady(ResourceCallback r10) {
        monitor-enter(this);
        r10.onResourceReady(this.engineResource, this.dataSource);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        throw th;
    L8:
        throw new CallbackException(th);     // Catch: Throwable -> L9
    }

    public void cancel() {
        if (isDone() == false) goto L5;
        return;
    L5:
        this.isCancelled = true;
        this.decodeJob.cancel();
        this.listener.onEngineJobCancelled(this, this.key);
    }

    public synchronized void decrementPendingCallbacks() {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L12
        Preconditions.checkArgument(isDone(), "Not yet complete!");     // Catch: Throwable -> L12
        int r10 = this.pendingCallbacks.decrementAndGet();     // Catch: Throwable -> L12
        if (r10 < 0) goto L6;
        boolean r11 = true;
    L7:
        Preconditions.checkArgument(r11, "Can't decrement below 0");     // Catch: Throwable -> L12
        if (r10 != 0) goto L15;
        EngineResource<?> r12 = this.engineResource;     // Catch: Throwable -> L12
        if (r12 == null) goto L14;
        r12.release();     // Catch: Throwable -> L12
    L14:
        release();     // Catch: Throwable -> L12
    L15:
        monitor-exit(this);
        return;
    L6:
        r11 = false;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public synchronized void incrementPendingCallbacks(int r10) {
        monitor-enter(this);
        Preconditions.checkArgument(isDone(), "Not yet complete!");     // Catch: Throwable -> L9
        if (this.pendingCallbacks.getAndAdd(r10) != 0) goto L11;
        EngineResource<?> r11 = this.engineResource;     // Catch: Throwable -> L9
        if (r11 == null) goto L11;
        r11.acquire();     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public synchronized EngineJob<R> init(Key r10, boolean r11, boolean r12, boolean r13, boolean r14) {
        monitor-enter(this);
        this.key = r10;     // Catch: Throwable -> L6
        this.isCacheable = r11;     // Catch: Throwable -> L6
        this.useUnlimitedSourceGeneratorPool = r12;     // Catch: Throwable -> L6
        this.useAnimationPool = r13;     // Catch: Throwable -> L6
        this.onlyRetrieveFromCache = r14;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isCancelled() {
        monitor-enter(this);
        boolean r10 = this.isCancelled;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public void notifyCallbacksOfException() {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L8
        if (this.isCancelled == false) goto L11;
        release();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.cbs.isEmpty() == true) goto L25;
        if (this.hasLoadFailed == true) goto L23;
        this.hasLoadFailed = true;     // Catch: Throwable -> L8
        Key r10 = this.key;     // Catch: Throwable -> L8
        ResourceCallbacksAndExecutors r11 = this.cbs.copy();     // Catch: Throwable -> L8
        incrementPendingCallbacks(r11.size() + 1);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        this.listener.onEngineJobComplete(this, r10, null);
        Iterator<ResourceCallbackAndExecutor> r12 = r11.iterator();
    L18:
        if (r12.hasNext() == false) goto L20;
        ResourceCallbackAndExecutor r13 = r12.next();
        r13.executor.execute(new CallLoadFailed(this, r13.f6228cb));
        goto L18
    L20:
        decrementPendingCallbacks();
        return;
    L23:
        throw new IllegalStateException("Already failed once");     // Catch: Throwable -> L8
    L25:
        throw new IllegalStateException("Received an exception without any callbacks to notify");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void notifyCallbacksOfResult() {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L8
        if (this.isCancelled == false) goto L11;
        this.resource.recycle();     // Catch: Throwable -> L8
        release();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.cbs.isEmpty() == true) goto L25;
        if (this.hasResource == true) goto L23;
        this.engineResource = this.engineResourceFactory.build(this.resource, this.isCacheable);     // Catch: Throwable -> L8
        this.hasResource = true;     // Catch: Throwable -> L8
        ResourceCallbacksAndExecutors r10 = this.cbs.copy();     // Catch: Throwable -> L8
        incrementPendingCallbacks(r10.size() + 1);     // Catch: Throwable -> L8
        Key r11 = this.key;     // Catch: Throwable -> L8
        EngineResource<?> r12 = this.engineResource;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        this.listener.onEngineJobComplete(this, r11, r12);
        Iterator<ResourceCallbackAndExecutor> r13 = r10.iterator();
    L18:
        if (r13.hasNext() == false) goto L20;
        ResourceCallbackAndExecutor r14 = r13.next();
        r14.executor.execute(new CallResourceReady(this, r14.f6228cb));
        goto L18
    L20:
        decrementPendingCallbacks();
        return;
    L23:
        throw new IllegalStateException("Already have resource");     // Catch: Throwable -> L8
    L25:
        throw new IllegalStateException("Received a resource without any callbacks to notify");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onLoadFailed(GlideException r10) {
        monitor-enter(this);
        this.exception = r10;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        notifyCallbacksOfException();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onResourceReady(Resource<R> r10, DataSource r11) {
        monitor-enter(this);
        this.resource = r10;     // Catch: Throwable -> L7
        this.dataSource = r11;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        notifyCallbacksOfResult();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean onlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    public synchronized void removeCallback(ResourceCallback r10) {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L10
        this.cbs.remove(r10);     // Catch: Throwable -> L10
        if (this.cbs.isEmpty() == false) goto L15;
        cancel();     // Catch: Throwable -> L10
        if (this.hasResource == true) goto L13;
        if (this.hasLoadFailed == false) goto L15;
    L13:
        if (this.pendingCallbacks.get() != 0) goto L15;
        release();     // Catch: Throwable -> L10
    L15:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void reschedule(DecodeJob<?> r10) {
        getActiveSourceExecutor().execute(r10);
    }

    public synchronized void start(DecodeJob<R> r10) {
        monitor-enter(this);
        this.decodeJob = r10;     // Catch: Throwable -> L6
        if (r10.willDecodeFromCache() == false) goto L8;
        GlideExecutor r11 = this.diskCacheExecutor;     // Catch: Throwable -> L6
    L9:
        r11.execute(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L8:
        r11 = getActiveSourceExecutor();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public EngineJob(GlideExecutor r10, GlideExecutor r11, GlideExecutor r12, GlideExecutor r13, EngineJobListener r14, Pools$Pool<EngineJob<?>> r15, EngineResourceFactory r16) {
        this.cbs = new ResourceCallbacksAndExecutors();
        this.stateVerifier = StateVerifier.newInstance();
        this.pendingCallbacks = new AtomicInteger();
        this.diskCacheExecutor = r10;
        this.sourceExecutor = r11;
        this.sourceUnlimitedExecutor = r12;
        this.animationExecutor = r13;
        this.listener = r14;
        this.pool = r15;
        this.engineResourceFactory = r16;
    }
}
