package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes39.dex */
public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {
    private static final Waiter DEFAULT_WAITER = null;
    private boolean assertBackgroundThread;
    private GlideException exception;
    private final int height;
    private boolean isCancelled;
    private boolean loadFailed;
    private Request request;
    private R resource;
    private boolean resultReceived;
    private final Waiter waiter;
    private final int width;

    public static class Waiter {
        public Waiter() {
        }

        public void notifyAll(Object r100) {
            r100.notifyAll();
        }

        public void waitForTimeout(Object r100, long r101) throws InterruptedException {
            r100.wait(r101);
        }
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        return doGet(null);
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized Request getRequest() {
        monitor-enter(this);
        Request r100 = this.request;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        monitor-enter(this);
        boolean r100 = this.isCancelled;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.isCancelled == false) goto L6;
    L11:
        boolean r100 = true;
    L12:
        monitor-exit(this);
        return r100;
    L6:
        if (this.resultReceived == true) goto L11;
        if (this.loadFailed == true) goto L11;
        r100 = false;
        goto L12
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable r100) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable r100) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback r100) {
    }

    static {
        DEFAULT_WAITER = new Waiter();
    }

    private synchronized R doGet(Long r100) throws ExecutionException, InterruptedException, TimeoutException {
        monitor-enter(this);
    L51:
        th = move-exception;
        throw th;
    L4:
        if (this.assertBackgroundThread == false) goto L9;
        if (isDone() == true) goto L9;
        Util.assertBackgroundThread();     // Catch: Throwable -> L51
    L9:
        if (this.isCancelled == true) goto L50;
        if (this.loadFailed == true) goto L48;
        if (this.resultReceived == false) goto L18;
        R r101 = this.resource;     // Catch: Throwable -> L51
        monitor-exit(this);
        return r101;
    L18:
        if (r100 != null) goto L21;
        this.waiter.waitForTimeout(this, 0);     // Catch: Throwable -> L51
    L29:
        if (Thread.interrupted() == true) goto L46;
        if (this.loadFailed == true) goto L44;
        if (this.isCancelled == true) goto L42;
        if (this.resultReceived == false) goto L40;
        R r102 = this.resource;     // Catch: Throwable -> L51
        monitor-exit(this);
        return r102;
    L40:
        throw new TimeoutException();     // Catch: Throwable -> L51
    L42:
        throw new CancellationException();     // Catch: Throwable -> L51
    L44:
        throw new ExecutionException(this.exception);     // Catch: Throwable -> L51
    L46:
        throw new InterruptedException();     // Catch: Throwable -> L51
    L21:
        if (r100.longValue() <= 0) goto L29;
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L51
        long r104 = r100.longValue() + r103;     // Catch: Throwable -> L51
    L24:
        if (isDone() == true) goto L29;
        if (r103 >= r104) goto L29;
        this.waiter.waitForTimeout(this, r104 - r103);     // Catch: Throwable -> L51
        r103 = System.currentTimeMillis();     // Catch: Throwable -> L51
        goto L24
    L48:
        throw new ExecutionException(this.exception);     // Catch: Throwable -> L51
    L50:
        throw new CancellationException();     // Catch: Throwable -> L51
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r100) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (isDone() == false) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L15
        return false;
    L8:
        this.isCancelled = true;     // Catch: Throwable -> L15
        this.waiter.notifyAll(this);     // Catch: Throwable -> L15
        Request r101 = null;
        if (r100 == false) goto L11;
        Request r102 = this.request;     // Catch: Throwable -> L15
        this.request = null;     // Catch: Throwable -> L15
        r101 = r102;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r101 == null) goto L14;
        r101.clear();
    L14:
        return true;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(SizeReadyCallback r100) {
        r100.onSizeReady(this.width, this.height);
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onLoadFailed(Drawable r100) {
        monitor-enter(this);
        monitor-exit(this);
    }

    public void setAssertBackgroundThread(boolean r100) {
        this.assertBackgroundThread = r100;
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void setRequest(Request r100) {
        monitor-enter(this);
        this.request = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public RequestFutureTarget(int r100, int r101) {
        this(r100, r101, true, DEFAULT_WAITER);
    }

    @Override // java.util.concurrent.Future
    public R get(long r100, TimeUnit r101) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(r101.toMillis(r100)));
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onResourceReady(R r100, Transition<? super R> r101) {
        monitor-enter(this);
        monitor-exit(this);
    }

    public RequestFutureTarget(int r100, int r101, boolean r102, Waiter r103) {
        this.width = r100;
        this.height = r101;
        this.assertBackgroundThread = r102;
        this.waiter = r103;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onLoadFailed(GlideException r100, Object r101, Target<R> r102, boolean r103) {
        monitor-enter(this);
        this.loadFailed = true;     // Catch: Throwable -> L8
        this.exception = r100;     // Catch: Throwable -> L8
        this.waiter.notifyAll(this);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onResourceReady(R r100, Object r101, Target<R> r102, DataSource r103, boolean r104) {
        monitor-enter(this);
        this.resultReceived = true;     // Catch: Throwable -> L8
        this.resource = r100;     // Catch: Throwable -> L8
        this.waiter.notifyAll(this);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L8:
        th = move-exception;
        throw th;
    }
}
