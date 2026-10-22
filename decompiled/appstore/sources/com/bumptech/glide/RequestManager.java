package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
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
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class RequestManager implements LifecycleListener, ModelTypes<RequestBuilder<Drawable>> {
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

    @GuardedBy("this")
    private RequestOptions requestOptions;

    @GuardedBy("this")
    private final RequestTracker requestTracker;

    @GuardedBy("this")
    private final TargetTracker targetTracker;

    @GuardedBy("this")
    private final RequestManagerTreeNode treeNode;

    public static class ClearTarget extends ViewTarget<View, Object> {
        public ClearTarget(@NonNull View r10) {
            super(r10);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object r10, @Nullable Transition<? super Object> r11) {
        }
    }

    public class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {

        @GuardedBy("RequestManager.this")
        private final RequestTracker requestTracker;
        final /* synthetic */ RequestManager this$0;

        public RequestManagerConnectivityListener(@NonNull RequestManager r10, RequestTracker r11) {
            this.this$0 = r10;
            this.requestTracker = r11;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void onConnectivityChanged(boolean r10) {
            if (r10 == false) goto L11;
            RequestManager r11 = this.this$0;
            monitor-enter(r11);
            this.requestTracker.restartRequests();     // Catch: Throwable -> L8
            monitor-exit(r11);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
        DECODE_TYPE_BITMAP = RequestOptions.decodeTypeOf(Bitmap.class).lock();
        DECODE_TYPE_GIF = RequestOptions.decodeTypeOf(GifDrawable.class).lock();
        DOWNLOAD_ONLY_OPTIONS = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
    }

    public RequestManager(@NonNull Glide r10, @NonNull Lifecycle r11, @NonNull RequestManagerTreeNode r12, @NonNull Context r13) {
        this(r10, r11, r12, new RequestTracker(), r10.getConnectivityMonitorFactory(), r13);
    }

    private void untrackOrDelegate(@NonNull Target<?> r10) {
        if (untrack(r10) == false) goto L5;
        return;
    L5:
        if (this.glide.removeFromManagers(r10) == false) goto L7;
        return;
    L7:
        if (r10.getRequest() == null) goto L12;
        Request r11 = r10.getRequest();
        r10.setRequest(null);
        r11.clear();
        return;
    }

    private synchronized void updateRequestOptions(@NonNull RequestOptions r10) {
        monitor-enter(this);
        this.requestOptions = this.requestOptions.apply(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public RequestManager addDefaultRequestListener(RequestListener<Object> r10) {
        this.defaultRequestListeners.add(r10);
        return this;
    }

    @NonNull
    public synchronized RequestManager applyDefaultRequestOptions(@NonNull RequestOptions r10) {
        monitor-enter(this);
        updateRequestOptions(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    @NonNull
    @CheckResult
    public <ResourceType> RequestBuilder<ResourceType> as(@NonNull Class<ResourceType> r10) {
        return new RequestBuilder(this.glide, this, r10, this.context);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Bitmap> asBitmap() {
        return as(Bitmap.class).apply(DECODE_TYPE_BITMAP);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> asDrawable() {
        return as(Drawable.class);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> asFile() {
        return as(File.class).apply(RequestOptions.skipMemoryCacheOf(true));
    }

    @NonNull
    @CheckResult
    public RequestBuilder<GifDrawable> asGif() {
        return as(GifDrawable.class).apply(DECODE_TYPE_GIF);
    }

    public void clear(@NonNull View r10) {
        clear(new ClearTarget(r10));
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> download(@Nullable Object r10) {
        return downloadOnly().load(r10);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> downloadOnly() {
        return as(File.class).apply(DOWNLOAD_ONLY_OPTIONS);
    }

    public List<RequestListener<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    public synchronized RequestOptions getDefaultRequestOptions() {
        monitor-enter(this);
        RequestOptions r10 = this.requestOptions;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @NonNull
    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> r10) {
        return this.glide.getGlideContext().getDefaultTransitionOptions(r10);
    }

    public synchronized boolean isPaused() {
        monitor-enter(this);
        boolean r10 = this.requestTracker.isPaused();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(@Nullable Bitmap r10) {
        return load(r10);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onDestroy() {
        monitor-enter(this);
        this.targetTracker.onDestroy();     // Catch: Throwable -> L7
        Iterator<Target<?>> r10 = this.targetTracker.getAll().iterator();     // Catch: Throwable -> L7
    L5:
        if (r10.hasNext() == false) goto L9;
        clear(r10.next());     // Catch: Throwable -> L7
        goto L5
    L9:
        this.targetTracker.clear();     // Catch: Throwable -> L7
        this.requestTracker.clearRequests();     // Catch: Throwable -> L7
        this.lifecycle.removeListener(this);     // Catch: Throwable -> L7
        this.lifecycle.removeListener(this.connectivityMonitor);     // Catch: Throwable -> L7
        this.mainHandler.removeCallbacks(this.addSelfToLifecycle);     // Catch: Throwable -> L7
        this.glide.unregisterRequestManager(this);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
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
        pauseRequests();     // Catch: Throwable -> L8
        Iterator<RequestManager> r10 = this.treeNode.getDescendants().iterator();     // Catch: Throwable -> L8
    L5:
        if (r10.hasNext() == false) goto L10;
        r10.next().pauseRequests();     // Catch: Throwable -> L8
        goto L5
    L10:
        monitor-exit(this);
        return;
    L8:
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
        Util.assertMainThread();     // Catch: Throwable -> L8
        resumeRequests();     // Catch: Throwable -> L8
        Iterator<RequestManager> r10 = this.treeNode.getDescendants().iterator();     // Catch: Throwable -> L8
    L5:
        if (r10.hasNext() == false) goto L10;
        r10.next().resumeRequests();     // Catch: Throwable -> L8
        goto L5
    L10:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @NonNull
    public synchronized RequestManager setDefaultRequestOptions(@NonNull RequestOptions r10) {
        monitor-enter(this);
        setRequestOptions(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setRequestOptions(@NonNull RequestOptions r10) {
        monitor-enter(this);
        this.requestOptions = r10.clone().autoClone();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String toString() {
        monitor-enter(this);
        String r10 = super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + "}";     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void track(@NonNull Target<?> r10, @NonNull Request r11) {
        monitor-enter(this);
        this.targetTracker.track(r10);     // Catch: Throwable -> L6
        this.requestTracker.runRequest(r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean untrack(@NonNull Target<?> r10) {
        monitor-enter(this);
        Request r11 = r10.getRequest();     // Catch: Throwable -> L13
        if (r11 != null) goto L9;
        monitor-exit(this);
        return true;
    L9:
        if (this.requestTracker.clearRemoveAndRecycle(r11) == false) goto L15;
        this.targetTracker.untrack(r10);     // Catch: Throwable -> L13
        r10.setRequest(null);     // Catch: Throwable -> L13
        monitor-exit(this);
        return true;
    L15:
        monitor-exit(this);
        return false;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized void clear(@Nullable Target<?> r10) {
        monitor-enter(this);
        if (r10 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        untrackOrDelegate(r10);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(@Nullable Drawable r10) {
        return load(r10);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(@Nullable Uri r10) {
        return load(r10);
    }

    public RequestManager(Glide r10, Lifecycle r11, RequestManagerTreeNode r12, RequestTracker r13, ConnectivityMonitorFactory r14, Context r15) {
        this.targetTracker = new TargetTracker();
        Runnable r16 = new AnonymousClass1(this);
        this.addSelfToLifecycle = r16;
        Handler r17 = new Handler(Looper.getMainLooper());
        this.mainHandler = r17;
        this.glide = r10;
        this.lifecycle = r11;
        this.treeNode = r12;
        this.requestTracker = r13;
        this.context = r15;
        ConnectivityMonitor r18 = r14.build(r15.getApplicationContext(), new RequestManagerConnectivityListener(this, r13));
        this.connectivityMonitor = r18;
        if (Util.isOnBackgroundThread() == false) goto L5;
        r17.post(r16);
    L6:
        r11.addListener(r18);
        this.defaultRequestListeners = new CopyOnWriteArrayList(r10.getGlideContext().getDefaultRequestListeners());
        setRequestOptions(r10.getGlideContext().getDefaultRequestOptions());
        r10.registerRequestManager(this);
        return;
    L5:
        r11.addListener(this);
        goto L6
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(@Nullable File r10) {
        return load(r10);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(@Nullable @DrawableRes @RawRes Integer r10) {
        return load(r10);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(@Nullable Object r10) {
        return load(r10);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(@Nullable String r10) {
        return load(r10);
    }

    @Override // com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(@Nullable URL r10) {
        return load(r10);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(@Nullable byte[] r10) {
        return load(r10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Bitmap r10) {
        return asDrawable().load(r10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Drawable r10) {
        return asDrawable().load(r10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable String r10) {
        return asDrawable().load(r10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Uri r10) {
        return asDrawable().load(r10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable File r10) {
        return asDrawable().load(r10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable @DrawableRes @RawRes Integer r10) {
        return asDrawable().load(r10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    public RequestBuilder<Drawable> load(@Nullable URL r10) {
        return asDrawable().load(r10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable byte[] r10) {
        return asDrawable().load(r10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Object r10) {
        return asDrawable().load(r10);
    }
}
