package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
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

/* JADX INFO: loaded from: classes.dex */
public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {
    private static final Waiter DEFAULT_WAITER = null;
    private final boolean assertBackgroundThread;

    @Nullable
    private GlideException exception;
    private final int height;
    private boolean isCancelled;
    private boolean loadFailed;

    @Nullable
    private Request request;

    @Nullable
    private R resource;
    private boolean resultReceived;
    private final Waiter waiter;
    private final int width;

    @VisibleForTesting
    public static class Waiter {
        public Waiter() {
        }

        public void notifyAll(Object r10) {
            r10.notifyAll();
        }

        public void waitForTimeout(Object r10, long r11) throws InterruptedException {
            r10.wait(r11);
        }
    }

    static {
        DEFAULT_WAITER = new Waiter();
    }

    public RequestFutureTarget(int r10, int r11) {
        this(r10, r11, true, DEFAULT_WAITER);
    }

    private synchronized R doGet(Long r10) throws ExecutionException, InterruptedException, TimeoutException {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.assertBackgroundThread == false) goto L11;
        if (isDone() == true) goto L11;
        Util.assertBackgroundThread();     // Catch: Throwable -> L8
    L11:
        if (this.isCancelled == true) goto L52;
        if (this.loadFailed == true) goto L50;
        if (this.resultReceived == false) goto L20;
        R r11 = this.resource;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L20:
        if (r10 != null) goto L23;
        this.waiter.waitForTimeout(this, 0);     // Catch: Throwable -> L8
    L31:
        if (Thread.interrupted() == true) goto L48;
        if (this.loadFailed == true) goto L46;
        if (this.isCancelled == true) goto L44;
        if (this.resultReceived == false) goto L42;
        R r12 = this.resource;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r12;
    L42:
        throw new TimeoutException();     // Catch: Throwable -> L8
    L44:
        throw new CancellationException();     // Catch: Throwable -> L8
    L46:
        throw new ExecutionException(this.exception);     // Catch: Throwable -> L8
    L48:
        throw new InterruptedException();     // Catch: Throwable -> L8
    L23:
        if (r10.longValue() <= 0) goto L31;
        long r13 = System.currentTimeMillis();     // Catch: Throwable -> L8
        long r14 = r10.longValue() + r13;     // Catch: Throwable -> L8
    L26:
        if (isDone() == true) goto L31;
        if (r13 >= r14) goto L31;
        this.waiter.waitForTimeout(this, r14 - r13);     // Catch: Throwable -> L8
        r13 = System.currentTimeMillis();     // Catch: Throwable -> L8
        goto L26
    L50:
        throw new ExecutionException(this.exception);     // Catch: Throwable -> L8
    L52:
        throw new CancellationException();     // Catch: Throwable -> L8
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean r10) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (isDone() == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        this.isCancelled = true;     // Catch: Throwable -> L15
        this.waiter.notifyAll(this);     // Catch: Throwable -> L15
        if (r10 == false) goto L17;
        Request r11 = this.request;     // Catch: Throwable -> L15
        if (r11 == null) goto L17;
        r11.clear();     // Catch: Throwable -> L15
        this.request = null;     // Catch: Throwable -> L15
    L17:
        monitor-exit(this);
        return true;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        return doGet(null);
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    public synchronized Request getRequest() {
        monitor-enter(this);
        Request r10 = this.request;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(@NonNull SizeReadyCallback r10) {
        r10.onSizeReady(this.width, this.height);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        monitor-enter(this);
        boolean r10 = this.isCancelled;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isCancelled == false) goto L6;
    L13:
        boolean r10 = true;
    L14:
        monitor-exit(this);
        return r10;
    L6:
        if (this.resultReceived == true) goto L13;
        if (this.loadFailed == true) goto L13;
        r10 = false;
        goto L14
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@Nullable Drawable r10) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onLoadFailed(@Nullable Drawable r10) {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(@Nullable Drawable r10) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onResourceReady(@NonNull R r10, @Nullable Transition<? super R> r11) {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(@NonNull SizeReadyCallback r10) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void setRequest(@Nullable Request r10) {
        monitor-enter(this);
        this.request = r10;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public RequestFutureTarget(int r10, int r11, boolean r12, Waiter r13) {
        this.width = r10;
        this.height = r11;
        this.assertBackgroundThread = r12;
        this.waiter = r13;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onLoadFailed(@Nullable GlideException r10, Object r11, Target<R> r12, boolean r13) {
        monitor-enter(this);
        this.loadFailed = true;     // Catch: Throwable -> L8
        this.exception = r10;     // Catch: Throwable -> L8
        this.waiter.notifyAll(this);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onResourceReady(R r10, Object r11, Target<R> r12, DataSource r13, boolean r14) {
        monitor-enter(this);
        this.resultReceived = true;     // Catch: Throwable -> L8
        this.resource = r10;     // Catch: Throwable -> L8
        this.waiter.notifyAll(this);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // java.util.concurrent.Future
    public R get(long r10, @NonNull TimeUnit r11) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(r11.toMillis(r10)));
    }
}
