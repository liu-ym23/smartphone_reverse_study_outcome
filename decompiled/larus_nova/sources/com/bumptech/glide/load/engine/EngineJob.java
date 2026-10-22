package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.GlideLogUtil;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    private static final EngineResourceFactory DEFAULT_FACTORY = null;
    private static final String LOG_TAG = "EngineJob";
    private final GlideExecutor animationExecutor;
    final ResourceCallbacksAndExecutors cbs;
    DataSource dataSource;
    private DecodeJob<R> decodeJob;
    private final GlideExecutor diskCacheExecutor;
    private final EngineJobListener engineJobListener;
    EngineResource<?> engineResource;
    private final EngineResourceFactory engineResourceFactory;
    GlideException exception;
    private boolean hasLoadFailed;
    private boolean hasResource;
    private boolean isCacheable;
    private volatile boolean isCancelled;
    private Key key;
    private boolean onlyRetrieveFromCache;
    private final AtomicInteger pendingCallbacks;
    private final Pools.Pool<EngineJob<?>> pool;
    private Resource<?> resource;
    private final EngineResource.ResourceListener resourceListener;
    private final GlideExecutor sourceExecutor;
    private final GlideExecutor sourceUnlimitedExecutor;
    private final StateVerifier stateVerifier;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorPool;

    public class CallLoadFailed implements Runnable {

        /* JADX INFO: renamed from: cb, reason: collision with root package name */
        private final ResourceCallback f33693cb;
        final /* synthetic */ EngineJob this$0;

        @Override // java.lang.Runnable
        public void run() {
            com_bumptech_glide_load_engine_EngineJob$CallLoadFailed_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bumptech_glide_load_engine_EngineJob$CallLoadFailed__run$___twin___() {
            Object r100 = this.f33693cb.getLock();
            monitor-enter(r100);
            EngineJob r101 = this.this$0;     // Catch: Throwable -> L16
            monitor-enter(r101);     // Catch: Throwable -> L16
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L7:
            if (this.this$0.cbs.contains(this.f33693cb) == false) goto L9;
            this.this$0.callCallbackOnLoadFailed(this.f33693cb);     // Catch: Throwable -> L13
        L9:
            this.this$0.decrementPendingCallbacks();     // Catch: Throwable -> L13
            monitor-exit(r101);     // Catch: Throwable -> L13
            monitor-exit(r100);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bumptech_glide_load_engine_EngineJob$CallLoadFailed_com_larus_apm_impl_protector_RunnableLancet_run(CallLoadFailed r100) {
            r100.com_bumptech_glide_load_engine_EngineJob$CallLoadFailed__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public CallLoadFailed(EngineJob r100, ResourceCallback r101) {
            this.this$0 = r100;
            this.f33693cb = r101;
        }
    }

    public class CallResourceReady implements Runnable {

        /* JADX INFO: renamed from: cb, reason: collision with root package name */
        private final ResourceCallback f33694cb;
        final /* synthetic */ EngineJob this$0;

        @Override // java.lang.Runnable
        public void run() {
            com_bumptech_glide_load_engine_EngineJob$CallResourceReady_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bumptech_glide_load_engine_EngineJob$CallResourceReady__run$___twin___() {
            Object r100 = this.f33694cb.getLock();
            monitor-enter(r100);
            EngineJob r101 = this.this$0;     // Catch: Throwable -> L16
            monitor-enter(r101);     // Catch: Throwable -> L16
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L7:
            if (this.this$0.cbs.contains(this.f33694cb) == false) goto L9;
            this.this$0.engineResource.acquire();     // Catch: Throwable -> L13
            this.this$0.callCallbackOnResourceReady(this.f33694cb);     // Catch: Throwable -> L13
            this.this$0.removeCallback(this.f33694cb);     // Catch: Throwable -> L13
        L9:
            this.this$0.decrementPendingCallbacks();     // Catch: Throwable -> L13
            monitor-exit(r101);     // Catch: Throwable -> L13
            monitor-exit(r100);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bumptech_glide_load_engine_EngineJob$CallResourceReady_com_larus_apm_impl_protector_RunnableLancet_run(CallResourceReady r100) {
            r100.com_bumptech_glide_load_engine_EngineJob$CallResourceReady__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public CallResourceReady(EngineJob r100, ResourceCallback r101) {
            this.this$0 = r100;
            this.f33694cb = r101;
        }
    }

    public static class EngineResourceFactory {
        public EngineResourceFactory() {
        }

        public <R> EngineResource<R> build(Resource<R> r100, boolean r101, Key r110, EngineResource.ResourceListener r111) {
            return new EngineResource(r100, r101, true, r110, r111);
        }
    }

    public static final class ResourceCallbackAndExecutor {

        /* JADX INFO: renamed from: cb, reason: collision with root package name */
        final ResourceCallback f33695cb;
        final Executor executor;

        public int hashCode() {
            return this.f33695cb.hashCode();
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof ResourceCallbackAndExecutor) == true) goto L5;
            return false;
        L5:
            return this.f33695cb.equals(((ResourceCallbackAndExecutor) r100).f33695cb);
        }

        public ResourceCallbackAndExecutor(ResourceCallback r100, Executor r101) {
            this.f33695cb = r100;
            this.executor = r101;
        }
    }

    public static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {
        private final List<ResourceCallbackAndExecutor> callbacksAndExecutors;

        public ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
        }

        public void clear() {
            this.callbacksAndExecutors.clear();
        }

        public ResourceCallbacksAndExecutors copy() {
            return new ResourceCallbacksAndExecutors(new ArrayList(this.callbacksAndExecutors));
        }

        public boolean isEmpty() {
            return this.callbacksAndExecutors.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator<ResourceCallbackAndExecutor> iterator() {
            return this.callbacksAndExecutors.iterator();
        }

        public int size() {
            return this.callbacksAndExecutors.size();
        }

        public ResourceCallbacksAndExecutors(List<ResourceCallbackAndExecutor> r100) {
            this.callbacksAndExecutors = r100;
        }

        private static ResourceCallbackAndExecutor defaultCallbackAndExecutor(ResourceCallback r100) {
            return new ResourceCallbackAndExecutor(r100, Executors.directExecutor());
        }

        public boolean contains(ResourceCallback r100) {
            return this.callbacksAndExecutors.contains(defaultCallbackAndExecutor(r100));
        }

        public void remove(ResourceCallback r100) {
            this.callbacksAndExecutors.remove(defaultCallbackAndExecutor(r100));
        }

        public void add(ResourceCallback r100, Executor r101) {
            this.callbacksAndExecutors.add(new ResourceCallbackAndExecutor(r100, r101));
        }
    }

    private synchronized void release() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.key == null) goto L9;
        this.cbs.clear();     // Catch: Throwable -> L10
        this.key = null;     // Catch: Throwable -> L10
        this.engineResource = null;     // Catch: Throwable -> L10
        this.resource = null;     // Catch: Throwable -> L10
        this.hasLoadFailed = false;     // Catch: Throwable -> L10
        this.isCancelled = false;     // Catch: Throwable -> L10
        this.hasResource = false;     // Catch: Throwable -> L10
        this.decodeJob.release(false);     // Catch: Throwable -> L10
        this.decodeJob = null;     // Catch: Throwable -> L10
        this.exception = null;     // Catch: Throwable -> L10
        this.dataSource = null;     // Catch: Throwable -> L10
        this.pool.release(this);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IllegalArgumentException();     // Catch: Throwable -> L10
    }

    public void decrementPendingCallbacks() {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L15
        Preconditions.checkArgument(isDone(), "Not yet complete!");     // Catch: Throwable -> L15
        int r100 = this.pendingCallbacks.decrementAndGet();     // Catch: Throwable -> L15
        if (r100 < 0) goto L6;
        boolean r101 = true;
    L7:
        Preconditions.checkArgument(r101, "Can't decrement below 0");     // Catch: Throwable -> L15
        if (r100 != 0) goto L10;
        EngineResource<?> r102 = this.engineResource;     // Catch: Throwable -> L15
        release();     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r102 == null) goto L20;
        r102.release();
        return;
    L20:
        return;
    L10:
        r102 = null;
        goto L11
    L6:
        r101 = false;
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isCancelled() {
        monitor-enter(this);
        boolean r100 = this.isCancelled;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public void notifyCallbacksOfException() {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L24
        if (this.isCancelled == false) goto L9;
        release();     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L9:
        if (this.cbs.isEmpty() == true) goto L23;
        if (this.hasLoadFailed == true) goto L21;
        this.hasLoadFailed = true;     // Catch: Throwable -> L24
        Key r100 = this.key;     // Catch: Throwable -> L24
        ResourceCallbacksAndExecutors r101 = this.cbs.copy();     // Catch: Throwable -> L24
        incrementPendingCallbacks(r101.size() + 1);     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        this.engineJobListener.onEngineJobComplete(this, r100, null);
        Iterator<ResourceCallbackAndExecutor> r102 = r101.iterator();
    L16:
        if (r102.hasNext() == false) goto L18;
        ResourceCallbackAndExecutor r103 = r102.next();
        r103.executor.execute(new CallLoadFailed(this, r103.f33695cb));
        goto L16
    L18:
        decrementPendingCallbacks();
        return;
    L21:
        throw new IllegalStateException("Already failed once");     // Catch: Throwable -> L24
    L23:
        throw new IllegalStateException("Received an exception without any callbacks to notify");     // Catch: Throwable -> L24
    L24:
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
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L24
        if (this.isCancelled == false) goto L9;
        this.resource.recycle();     // Catch: Throwable -> L24
        release();     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L9:
        if (this.cbs.isEmpty() == true) goto L23;
        if (this.hasResource == true) goto L21;
        this.engineResource = this.engineResourceFactory.build(this.resource, this.isCacheable, this.key, this.resourceListener);     // Catch: Throwable -> L24
        this.hasResource = true;     // Catch: Throwable -> L24
        ResourceCallbacksAndExecutors r100 = this.cbs.copy();     // Catch: Throwable -> L24
        incrementPendingCallbacks(r100.size() + 1);     // Catch: Throwable -> L24
        Key r101 = this.key;     // Catch: Throwable -> L24
        EngineResource<?> r102 = this.engineResource;     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        this.engineJobListener.onEngineJobComplete(this, r101, r102);
        Iterator<ResourceCallbackAndExecutor> r103 = r100.iterator();
    L16:
        if (r103.hasNext() == false) goto L18;
        ResourceCallbackAndExecutor r104 = r103.next();
        r104.executor.execute(new CallResourceReady(this, r104.f33695cb));
        goto L16
    L18:
        decrementPendingCallbacks();
        return;
    L21:
        throw new IllegalStateException("Already have resource");     // Catch: Throwable -> L24
    L23:
        throw new IllegalStateException("Received a resource without any callbacks to notify");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    static {
        DEFAULT_FACTORY = new EngineResourceFactory();
    }

    private GlideExecutor getActiveSourceExecutor() {
        GlideExecutor r100 = this.decodeJob.getSourceExecutor();
        if (this.useUnlimitedSourceGeneratorPool == false) goto L6;
        return this.sourceUnlimitedExecutor;
    L6:
        if (this.useAnimationPool == true) goto L13;
        if (r100 == null) goto L11;
        return r100;
    L11:
        return this.sourceExecutor;
    L13:
        return this.animationExecutor;
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

    public void cancel() {
        if (isDone() == false) goto L5;
        return;
    L5:
        this.isCancelled = true;
        DecodeJob<R> r100 = this.decodeJob;
        if (r100 == null) goto L8;
        r100.cancel();
    L8:
        this.engineJobListener.onEngineJobCancelled(this, this.key);
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public boolean onlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    public void callCallbackOnLoadFailed(ResourceCallback r100) {
        r100.onLoadFailed(this.exception);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new CallbackException(th);
    }

    public void callCallbackOnResourceReady(ResourceCallback r100) {
        r100.onResourceReady(this.engineResource, this.dataSource);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new CallbackException(th);
    }

    public synchronized void incrementPendingCallbacks(int r100) {
        monitor-enter(this);
        Preconditions.checkArgument(isDone(), "Not yet complete!");     // Catch: Throwable -> L10
        if (this.pendingCallbacks.getAndAdd(r100) != 0) goto L8;
        EngineResource<?> r101 = this.engineResource;     // Catch: Throwable -> L10
        if (r101 == null) goto L8;
        r101.acquire();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onLoadFailed(GlideException r100) {
        monitor-enter(this);
        this.exception = r100;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        notifyCallbacksOfException();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void removeCallback(ResourceCallback r100) {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L18
        this.cbs.remove(r100);     // Catch: Throwable -> L18
        if (this.cbs.isEmpty() == false) goto L16;
        cancel();     // Catch: Throwable -> L18
        if (this.hasResource == false) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L16;
        if (this.pendingCallbacks.get() != 0) goto L16;
        release();     // Catch: Throwable -> L18
        goto L16
    L8:
        if (this.hasLoadFailed == true) goto L11;
        r101 = false;
    L16:
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void reschedule(DecodeJob<?> r100) {
        getActiveSourceExecutor().execute(r100);
    }

    public synchronized void start(DecodeJob<R> r100) {
        monitor-enter(this);
        this.decodeJob = r100;     // Catch: Throwable -> L10
        if (r100.willDecodeFromCache() == false) goto L6;
        GlideExecutor r101 = this.diskCacheExecutor;     // Catch: Throwable -> L10
    L7:
        r101.execute(r100);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r101 = getActiveSourceExecutor();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void addCallback(ResourceCallback r100, Executor r101) {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L14
        this.cbs.add(r100, r101);     // Catch: Throwable -> L14
        if (this.hasResource == false) goto L7;
        incrementPendingCallbacks(1);     // Catch: Throwable -> L14
        r101.execute(new CallResourceReady(this, r100));     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L7:
        if (this.hasLoadFailed == false) goto L10;
        incrementPendingCallbacks(1);     // Catch: Throwable -> L14
        r101.execute(new CallLoadFailed(this, r100));     // Catch: Throwable -> L14
        goto L12
    L10:
        if (this.isCancelled == false) goto L12;
        GlideLogUtil.e(LOG_TAG, "Cannot add callbacks to a cancelled EngineJob");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onResourceReady(Resource<R> r100, DataSource r101) {
        monitor-enter(this);
        this.resource = r100;     // Catch: Throwable -> L7
        this.dataSource = r101;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        notifyCallbacksOfResult();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized EngineJob<R> init(Key r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        monitor-enter(this);
        this.key = r100;     // Catch: Throwable -> L6
        this.isCacheable = r101;     // Catch: Throwable -> L6
        this.useUnlimitedSourceGeneratorPool = r102;     // Catch: Throwable -> L6
        this.useAnimationPool = r103;     // Catch: Throwable -> L6
        this.onlyRetrieveFromCache = r104;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public EngineJob(GlideExecutor r110, GlideExecutor r111, GlideExecutor r112, GlideExecutor r113, EngineJobListener r114, EngineResource.ResourceListener r115, Pools.Pool<EngineJob<?>> r116) {
        this(r110, r111, r112, r113, r114, r115, r116, DEFAULT_FACTORY);
    }

    public EngineJob(GlideExecutor r100, GlideExecutor r101, GlideExecutor r102, GlideExecutor r103, EngineJobListener r104, EngineResource.ResourceListener r105, Pools.Pool<EngineJob<?>> r106, EngineResourceFactory r107) {
        this.cbs = new ResourceCallbacksAndExecutors();
        this.stateVerifier = StateVerifier.newInstance();
        this.pendingCallbacks = new AtomicInteger();
        this.diskCacheExecutor = r100;
        this.sourceExecutor = r101;
        this.sourceUnlimitedExecutor = r102;
        this.animationExecutor = r103;
        this.engineJobListener = r104;
        this.resourceListener = r105;
        this.pool = r106;
        this.engineResourceFactory = r107;
    }
}
