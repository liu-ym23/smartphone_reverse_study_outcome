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
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.i;
import com.bumptech.glide.manager.k;
import com.bumptech.glide.manager.l;
import com.bumptech.glide.manager.m;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class RequestManager implements ComponentCallbacks2, i {
    private static final com.bumptech.glide.request.h DECODE_TYPE_BITMAP = null;
    private static final com.bumptech.glide.request.h DECODE_TYPE_GIF = null;
    private static final com.bumptech.glide.request.h DOWNLOAD_ONLY_OPTIONS = null;
    private final Runnable addSelfToLifecycle;
    private final com.bumptech.glide.manager.c connectivityMonitor;
    protected final Context context;
    private final CopyOnWriteArrayList<com.bumptech.glide.request.g<Object>> defaultRequestListeners;
    protected final Glide glide;
    final com.bumptech.glide.manager.h lifecycle;
    private final Handler mainHandler;
    private boolean pauseAllRequestsOnTrimMemoryModerate;
    private com.bumptech.glide.request.h requestOptions;
    private final l requestTracker;
    private final m targetTracker;
    private final k treeNode;

    private static class a extends CustomViewTarget<View, Object> {
        @Override // com.bumptech.glide.request.target.i
        public void a(Object r1, com.bumptech.glide.request.a.b<? super Object> r2) {
            com.bumptech.glide.request.a.b r0 = (com.bumptech.glide.request.a.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.request.a.b.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bumptech.glide.request.target.i
        public void b(Drawable r1) {
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public void d(Drawable r1) {
        }

        a(View r1) {
            super(r1);
        }
    }

    private class b implements com.bumptech.glide.manager.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestManager f3216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final l f3217b;

        b(RequestManager r1, l r2) {
            this.f3216a = r1;
            this.f3217b = r2;
        }

        @Override // com.bumptech.glide.manager.c.a
        public void a(boolean r1) {
            if (r1 == false) goto L11;
            RequestManager r2 = this.f3216a;
            monitor-enter(r2);
            this.f3217b.f();     // Catch: Throwable -> L8
            monitor-exit(r2);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo20load(Bitmap r1) {
        return load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo21load(Drawable r1) {
        return load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo22load(Uri r1) {
        return load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo23load(File r1) {
        return load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo24load(Integer r1) {
        return load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo25load(Object r1) {
        return load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo26load(String r1) {
        return load(r1);
    }

    @Deprecated
    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo27load(URL r1) {
        return load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo28load(byte[] r1) {
        return load(r1);
    }

    static {
        DECODE_TYPE_BITMAP = (com.bumptech.glide.request.h) ZeusTransformUtils.preCheckCast(com.bumptech.glide.request.h.b(Bitmap.class).i(), com.bumptech.glide.request.h.class, "com.obric.aiagent.plugin");
        DECODE_TYPE_GIF = (com.bumptech.glide.request.h) ZeusTransformUtils.preCheckCast(com.bumptech.glide.request.h.b(GifDrawable.class).i(), com.bumptech.glide.request.h.class, "com.obric.aiagent.plugin");
        DOWNLOAD_ONLY_OPTIONS = (com.bumptech.glide.request.h) ZeusTransformUtils.preCheckCast(((com.bumptech.glide.request.h) ZeusTransformUtils.preCheckCast(com.bumptech.glide.request.h.b(j.f3677c).a(e.f3297d), com.bumptech.glide.request.h.class, "com.obric.aiagent.plugin")).b(true), com.bumptech.glide.request.h.class, "com.obric.aiagent.plugin");
    }

    public RequestManager(Glide r10, com.bumptech.glide.manager.h r11, k r12, Context r13) {
        com.bumptech.glide.manager.h r4 = (com.bumptech.glide.manager.h) ZeusTransformUtils.wrapperContextForParams(r11, com.bumptech.glide.manager.h.class, "com.obric.aiagent.plugin");
        k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r12, k.class, "com.obric.aiagent.plugin");
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        this(r10, r4, r5, new l(), r10.getConnectivityMonitorFactory(), r8);
    }

    RequestManager(Glide r5, com.bumptech.glide.manager.h r6, k r7, l r8, com.bumptech.glide.manager.d r9, Context r10) {
        com.bumptech.glide.manager.h r11 = (com.bumptech.glide.manager.h) ZeusTransformUtils.wrapperContextForParams(r6, com.bumptech.glide.manager.h.class, "com.obric.aiagent.plugin");
        k r12 = (k) ZeusTransformUtils.wrapperContextForParams(r7, k.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.manager.d r13 = (com.bumptech.glide.manager.d) ZeusTransformUtils.wrapperContextForParams(r9, com.bumptech.glide.manager.d.class, "com.obric.aiagent.plugin");
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        this.targetTracker = new m();
        Runnable r0 = new AnonymousClass1(this);
        this.addSelfToLifecycle = r0;
        Handler r2 = new Handler(Looper.getMainLooper());
        this.mainHandler = r2;
        this.glide = r5;
        this.lifecycle = r11;
        this.treeNode = r12;
        this.requestTracker = r8;
        this.context = ZeusTransformUtils.wrapperContext(r14, "com.obric.aiagent.plugin");
        com.bumptech.glide.manager.c r15 = r13.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r14.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), new b(this, r8));
        this.connectivityMonitor = r15;
        if (com.bumptech.glide.f.k.d() == false) goto L5;
        r2.post(r0);
    L6:
        r11.a(r15);
        this.defaultRequestListeners = new CopyOnWriteArrayList(((GlideContext) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getGlideContext(), "com.obric.aiagent.plugin"), GlideContext.class, "com.obric.aiagent.plugin")).getDefaultRequestListeners());
        setRequestOptions(((GlideContext) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getGlideContext(), "com.obric.aiagent.plugin"), GlideContext.class, "com.obric.aiagent.plugin")).getDefaultRequestOptions());
        r5.registerRequestManager(this);
        return;
    L5:
        r11.a(this);
        goto L6
    }

    public synchronized void setRequestOptions(com.bumptech.glide.request.h r3) {
        monitor-enter(this);
        this.requestOptions = (com.bumptech.glide.request.h) ZeusTransformUtils.preCheckCast(((com.bumptech.glide.request.h) ZeusTransformUtils.preCheckCast(r3.c(), com.bumptech.glide.request.h.class, "com.obric.aiagent.plugin")).j(), com.bumptech.glide.request.h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void updateRequestOptions(com.bumptech.glide.request.h r3) {
        monitor-enter(this);
        this.requestOptions = (com.bumptech.glide.request.h) ZeusTransformUtils.preCheckCast(this.requestOptions.b(r3), com.bumptech.glide.request.h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized RequestManager applyDefaultRequestOptions(com.bumptech.glide.request.h r1) {
        monitor-enter(this);
        updateRequestOptions(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized RequestManager setDefaultRequestOptions(com.bumptech.glide.request.h r1) {
        monitor-enter(this);
        setRequestOptions(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public RequestManager addDefaultRequestListener(com.bumptech.glide.request.g<Object> r3) {
        com.bumptech.glide.request.g<Object> r4 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.g.class, "com.obric.aiagent.plugin");
        this.defaultRequestListeners.add(r4);
        return this;
    }

    public void setPauseAllRequestsOnTrimMemoryModerate(boolean r1) {
        this.pauseAllRequestsOnTrimMemoryModerate = r1;
    }

    public synchronized boolean isPaused() {
        monitor-enter(this);
        boolean r0 = this.requestTracker.a();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void pauseRequests() {
        monitor-enter(this);
        this.requestTracker.b();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void pauseAllRequests() {
        monitor-enter(this);
        this.requestTracker.c();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void pauseAllRequestsRecursive() {
        monitor-enter(this);
        pauseAllRequests();     // Catch: Throwable -> L10
        Iterator<RequestManager> r0 = this.treeNode.a().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L8;
        ((RequestManager) ZeusTransformUtils.preCheckCast(r0.next(), RequestManager.class, "com.obric.aiagent.plugin")).pauseAllRequests();     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void pauseRequestsRecursive() {
        monitor-enter(this);
        pauseRequests();     // Catch: Throwable -> L10
        Iterator<RequestManager> r0 = this.treeNode.a().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L8;
        ((RequestManager) ZeusTransformUtils.preCheckCast(r0.next(), RequestManager.class, "com.obric.aiagent.plugin")).pauseRequests();     // Catch: Throwable -> L10
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
        this.requestTracker.d();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void resumeRequestsRecursive() {
        monitor-enter(this);
        com.bumptech.glide.f.k.a();     // Catch: Throwable -> L10
        resumeRequests();     // Catch: Throwable -> L10
        Iterator<RequestManager> r0 = this.treeNode.a().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L8;
        ((RequestManager) ZeusTransformUtils.preCheckCast(r0.next(), RequestManager.class, "com.obric.aiagent.plugin")).resumeRequests();     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.manager.i
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

    @Override // com.bumptech.glide.manager.i
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

    @Override // com.bumptech.glide.manager.i
    public synchronized void onDestroy() {
        monitor-enter(this);
        this.targetTracker.onDestroy();     // Catch: Throwable -> L10
        Iterator<com.bumptech.glide.request.target.i<?>> r0 = this.targetTracker.a().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L7;
        clear((com.bumptech.glide.request.target.i) ZeusTransformUtils.preCheckCast(r0.next(), com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10
        goto L5
    L7:
        this.targetTracker.b();     // Catch: Throwable -> L10
        this.requestTracker.e();     // Catch: Throwable -> L10
        this.lifecycle.b(this);     // Catch: Throwable -> L10
        this.lifecycle.b(this.connectivityMonitor);     // Catch: Throwable -> L10
        this.mainHandler.removeCallbacks(this.addSelfToLifecycle);     // Catch: Throwable -> L10
        this.glide.unregisterRequestManager(this);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public g<Bitmap> asBitmap() {
        return as(Bitmap.class).a(DECODE_TYPE_BITMAP);
    }

    public g<GifDrawable> asGif() {
        return as(GifDrawable.class).a(DECODE_TYPE_GIF);
    }

    public g<Drawable> asDrawable() {
        return as(Drawable.class);
    }

    public g<Drawable> load(Bitmap r1) {
        return asDrawable().a(r1);
    }

    public g<Drawable> load(Drawable r1) {
        return asDrawable().a(r1);
    }

    public g<Drawable> load(String r1) {
        return asDrawable().a(r1);
    }

    public g<Drawable> load(Uri r1) {
        return asDrawable().a(r1);
    }

    public g<Drawable> load(File r1) {
        return asDrawable().a(r1);
    }

    public g<Drawable> load(Integer r1) {
        return asDrawable().a(r1);
    }

    @Deprecated
    public g<Drawable> load(URL r1) {
        return asDrawable().a(r1);
    }

    public g<Drawable> load(byte[] r1) {
        return asDrawable().a(r1);
    }

    public g<Drawable> load(Object r1) {
        return asDrawable().a(r1);
    }

    public g<File> downloadOnly() {
        return as(File.class).a(DOWNLOAD_ONLY_OPTIONS);
    }

    public g<File> download(Object r1) {
        return downloadOnly().a(r1);
    }

    public g<File> asFile() {
        return as(File.class).a(com.bumptech.glide.request.h.c(true));
    }

    public <ResourceType> g<ResourceType> as(Class<ResourceType> r4) {
        return new g(this.glide, this, r4, this.context);
    }

    public void clear(View r2) {
        clear(new a(r2));
    }

    public void clear(com.bumptech.glide.request.target.i<?> r3) {
        com.bumptech.glide.request.target.i<?> r4 = (com.bumptech.glide.request.target.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        untrackOrDelegate(r4);
    }

    private void untrackOrDelegate(com.bumptech.glide.request.target.i<?> r3) {
        com.bumptech.glide.request.target.i<?> r4 = (com.bumptech.glide.request.target.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin");
        boolean r0 = untrack(r4);
        com.bumptech.glide.request.d r1 = r4.a();
        if (r0 == false) goto L5;
        return;
    L5:
        if (this.glide.removeFromManagers(r4) == true) goto L10;
        if (r1 == null) goto L11;
        r4.a(null);
        r1.b();
        return;
    L11:
        return;
    }

    synchronized boolean untrack(com.bumptech.glide.request.target.i<?> r4) {
        monitor-enter(this);
        com.bumptech.glide.request.target.i<?> r5 = (com.bumptech.glide.request.target.i) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        com.bumptech.glide.request.d r0 = r5.a();     // Catch: Throwable -> L16
        if (r0 != null) goto L9;
        monitor-exit(this);
        return true;
    L9:
        if (this.requestTracker.b(r0) == false) goto L14;
        this.targetTracker.b(r5);     // Catch: Throwable -> L16
        r5.a(null);     // Catch: Throwable -> L16
        monitor-exit(this);
        return true;
    L14:
        monitor-exit(this);
        return false;
    L16:
        th = move-exception;
        throw th;
    }

    synchronized void track(com.bumptech.glide.request.target.i<?> r3, com.bumptech.glide.request.d r4) {
        monitor-enter(this);
        com.bumptech.glide.request.target.i<?> r5 = (com.bumptech.glide.request.target.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        com.bumptech.glide.request.d r6 = (com.bumptech.glide.request.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        this.targetTracker.a(r5);     // Catch: Throwable -> L6
        this.requestTracker.a(r6);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    List<com.bumptech.glide.request.g<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    synchronized com.bumptech.glide.request.h getDefaultRequestOptions() {
        monitor-enter(this);
        com.bumptech.glide.request.h r0 = this.requestOptions;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    <T> h<?, T> getDefaultTransitionOptions(Class<T> r3) {
        return ((GlideContext) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.glide.getGlideContext(), "com.obric.aiagent.plugin"), GlideContext.class, "com.obric.aiagent.plugin")).getDefaultTransitionOptions(r3);
    }

    public synchronized String toString() {
        monitor-enter(this);
        String r0 = super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + "}";     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r2) {
        if (r2 == 60) goto L5;
        return;
    L5:
        if (this.pauseAllRequestsOnTrimMemoryModerate == false) goto L9;
        pauseAllRequestsRecursive();
        return;
    }
}
