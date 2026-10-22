package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.alipay.sdk.m.u.i;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class RequestManager implements ComponentCallbacks2, LifecycleListener, ModelTypes<RequestBuilder<Drawable>> {
    private static final RequestOptions DECODE_TYPE_BITMAP = null;
    private static final RequestOptions DECODE_TYPE_GIF = null;
    private static final RequestOptions DOWNLOAD_ONLY_OPTIONS = null;
    private final Runnable addSelfToLifecycle;
    private final ConnectivityMonitor connectivityMonitor;
    protected final Context context;
    private final CopyOnWriteArrayList<RequestListener<Object>> defaultRequestListeners;
    protected final Glide glide;
    final Lifecycle lifecycle;
    private final Handler mainHandler;
    private boolean pauseAllRequestsOnTrimMemoryModerate;
    private RequestOptions requestOptions;
    private final RequestTracker requestTracker;
    private final TargetTracker targetTracker;
    private final RequestManagerTreeNode treeNode;

    public static class ClearTarget extends CustomViewTarget<View, Object> {
        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable r100) {
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public void onResourceCleared(Drawable r100) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object r100, Transition<? super Object> r101) {
        }

        public ClearTarget(View r100) {
            super(r100);
        }
    }

    public class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
        private final RequestTracker requestTracker;
        final /* synthetic */ RequestManager this$0;

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void onConnectivityChanged(boolean r100) {
            if (r100 == false) goto L11;
            RequestManager r101 = this.this$0;
            monitor-enter(r101);
            this.requestTracker.restartRequests();     // Catch: Throwable -> L8
            monitor-exit(r101);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public RequestManagerConnectivityListener(RequestManager r100, RequestTracker r101) {
            this.this$0 = r100;
            this.requestTracker = r101;
        }
    }

    public synchronized RequestOptions getDefaultRequestOptions() {
        monitor-enter(this);
        RequestOptions r100 = this.requestOptions;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isPaused() {
        monitor-enter(this);
        boolean r100 = this.requestTracker.isPaused();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        monitor-enter(this);
        this.targetTracker.onDestroy();     // Catch: Throwable -> L11
        Iterator<Target<?>> r100 = this.targetTracker.getAll().iterator();     // Catch: Throwable -> L11
    L5:
        if (r100.hasNext() == false) goto L7;
        clear(r100.next());     // Catch: Throwable -> L11
        goto L5
    L7:
        this.targetTracker.clear();     // Catch: Throwable -> L11
        this.requestTracker.clearRequests();     // Catch: Throwable -> L11
        this.lifecycle.removeListener(this);     // Catch: Throwable -> L11
        this.lifecycle.removeListener(this.connectivityMonitor);     // Catch: Throwable -> L11
        this.mainHandler.removeCallbacks(this.addSelfToLifecycle);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        this.glide.unregisterRequestManager(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStart() {
        monitor-enter(this);
        resumeRequests();     // Catch: Throwable -> L6
        this.targetTracker.onStart();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStop() {
        monitor-enter(this);
        pauseRequests();     // Catch: Throwable -> L6
        this.targetTracker.onStop();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void pauseAllRequests() {
        monitor-enter(this);
        this.requestTracker.pauseAllRequests();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void pauseAllRequestsRecursive() {
        monitor-enter(this);
        pauseAllRequests();     // Catch: Throwable -> L10
        Iterator<RequestManager> r100 = this.treeNode.getDescendants().iterator();     // Catch: Throwable -> L10
    L5:
        if (r100.hasNext() == false) goto L8;
        r100.next().pauseAllRequests();     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void pauseRequests() {
        monitor-enter(this);
        this.requestTracker.pauseRequests();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void pauseRequestsRecursive() {
        monitor-enter(this);
        pauseRequests();     // Catch: Throwable -> L10
        Iterator<RequestManager> r100 = this.treeNode.getDescendants().iterator();     // Catch: Throwable -> L10
    L5:
        if (r100.hasNext() == false) goto L8;
        r100.next().pauseRequests();     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void resumeRequests() {
        monitor-enter(this);
        this.requestTracker.resumeRequests();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void resumeRequestsRecursive() {
        monitor-enter(this);
        Util.assertMainThread();     // Catch: Throwable -> L10
        resumeRequests();     // Catch: Throwable -> L10
        Iterator<RequestManager> r100 = this.treeNode.getDescendants().iterator();     // Catch: Throwable -> L10
    L5:
        if (r100.hasNext() == false) goto L8;
        r100.next().resumeRequests();     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized String toString() {
        monitor-enter(this);
        String r100 = super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + i.f25855d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        DECODE_TYPE_BITMAP = RequestOptions.decodeTypeOf(Bitmap.class).lock();
        DECODE_TYPE_GIF = RequestOptions.decodeTypeOf(GifDrawable.class).lock();
        DOWNLOAD_ONLY_OPTIONS = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
    }

    public RequestBuilder<Bitmap> asBitmap() {
        return as(Bitmap.class).apply(DECODE_TYPE_BITMAP);
    }

    public RequestBuilder<Drawable> asDrawable() {
        return as(Drawable.class);
    }

    public RequestBuilder<File> asFile() {
        return as(File.class).apply(RequestOptions.skipMemoryCacheOf(true));
    }

    public RequestBuilder<GifDrawable> asGif() {
        return as(GifDrawable.class).apply(DECODE_TYPE_GIF);
    }

    public RequestBuilder<File> downloadOnly() {
        return as(File.class).apply(DOWNLOAD_ONLY_OPTIONS);
    }

    public List<RequestListener<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    private void untrackOrDelegate(Target<?> r100) {
        boolean r101 = untrack(r100);
        Request r102 = r100.getRequest();
        if (r101 == false) goto L5;
        return;
    L5:
        if (this.glide.removeFromManagers(r100) == true) goto L10;
        if (r102 == null) goto L11;
        r100.setRequest(null);
        r102.clear();
        return;
    L11:
        return;
    }

    private synchronized void updateRequestOptions(RequestOptions r100) {
        monitor-enter(this);
        this.requestOptions = this.requestOptions.apply(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public RequestManager addDefaultRequestListener(RequestListener<Object> r100) {
        this.defaultRequestListeners.add(r100);
        return this;
    }

    public synchronized RequestManager applyDefaultRequestOptions(RequestOptions r100) {
        monitor-enter(this);
        updateRequestOptions(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public <ResourceType> RequestBuilder<ResourceType> as(Class<ResourceType> r100) {
        return new RequestBuilder(this.glide, this, r100, this.context);
    }

    public void clear(View r100) {
        clear(new ClearTarget(r100));
    }

    public RequestBuilder<File> download(Object r100) {
        return downloadOnly().load(r100);
    }

    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> r100) {
        return this.glide.getGlideContext().getDefaultTransitionOptions(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Bitmap r100) {
        return asDrawable().load(r100);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r100) {
        if (r100 == 60) goto L5;
        return;
    L5:
        if (this.pauseAllRequestsOnTrimMemoryModerate == false) goto L9;
        pauseAllRequestsRecursive();
        return;
    }

    public synchronized RequestManager setDefaultRequestOptions(RequestOptions r100) {
        monitor-enter(this);
        setRequestOptions(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public void setPauseAllRequestsOnTrimMemoryModerate(boolean r100) {
        this.pauseAllRequestsOnTrimMemoryModerate = r100;
    }

    public synchronized void setRequestOptions(RequestOptions r100) {
        monitor-enter(this);
        this.requestOptions = r100.clone().autoClone();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean untrack(Target<?> r100) {
        monitor-enter(this);
        Request r101 = r100.getRequest();     // Catch: Throwable -> L16
        if (r101 != null) goto L9;
        monitor-exit(this);
        return true;
    L9:
        if (this.requestTracker.clearAndRemove(r101) == false) goto L13;
        this.targetTracker.untrack(r100);     // Catch: Throwable -> L16
        r100.setRequest(null);     // Catch: Throwable -> L16
        monitor-exit(this);
        return true;
    L13:
        monitor-exit(this);
        return false;
    L16:
        th = move-exception;
        throw th;
    }

    public void clear(Target<?> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        untrackOrDelegate(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Drawable r100) {
        return asDrawable().load(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Uri r100) {
        return asDrawable().load(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(File r100) {
        return asDrawable().load(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Integer r100) {
        return asDrawable().load(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Object r100) {
        return asDrawable().load(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(String r100) {
        return asDrawable().load(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(URL r100) {
        return asDrawable().load(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(byte[] r100) {
        return asDrawable().load(r100);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(Bitmap r100) {
        return load(r100);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(Drawable r100) {
        return load(r100);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(Uri r100) {
        return load(r100);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(File r100) {
        return load(r100);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(Integer r100) {
        return load(r100);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(Object r100) {
        return load(r100);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(String r100) {
        return load(r100);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(URL r100) {
        return load(r100);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(byte[] r100) {
        return load(r100);
    }

    public synchronized void track(Target<?> r100, Request r101) {
        monitor-enter(this);
        this.targetTracker.track(r100);     // Catch: Throwable -> L6
        this.requestTracker.runRequest(r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public RequestManager(Glide r100, Lifecycle r101, RequestManagerTreeNode r110, Context r111) {
        this(r100, r101, r110, new RequestTracker(), r100.getConnectivityMonitorFactory(), r111);
    }

    public RequestManager(Glide r100, Lifecycle r101, RequestManagerTreeNode r102, RequestTracker r103, ConnectivityMonitorFactory r104, Context r105) {
        this.targetTracker = new TargetTracker();
        Runnable r106 = new AnonymousClass1(this);
        this.addSelfToLifecycle = r106;
        Handler r107 = new Handler(Looper.getMainLooper());
        this.mainHandler = r107;
        this.glide = r100;
        this.lifecycle = r101;
        this.treeNode = r102;
        this.requestTracker = r103;
        this.context = r105;
        ConnectivityMonitor r108 = r104.build(r105.getApplicationContext(), new RequestManagerConnectivityListener(this, r103));
        this.connectivityMonitor = r108;
        if (Util.isOnBackgroundThread() == false) goto L5;
        r107.post(r106);
    L6:
        r101.addListener(r108);
        this.defaultRequestListeners = new CopyOnWriteArrayList(r100.getGlideContext().getDefaultRequestListeners());
        setRequestOptions(r100.getGlideContext().getDefaultRequestOptions());
        r100.registerRequestManager(this);
        return;
    L5:
        r101.addListener(this);
        goto L6
    }
}
