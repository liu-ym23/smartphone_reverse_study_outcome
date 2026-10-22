package org.apache.http.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class BasicFuture<T> implements Future<T>, Cancellable {
    private final FutureCallback<T> callback;
    private volatile boolean cancelled;
    private volatile boolean completed;
    private volatile Exception ex;
    private volatile T result;

    public BasicFuture(FutureCallback<T> r10) {
        this.callback = r10;
    }

    private T getResult() throws ExecutionException {
        if (this.ex != null) goto L11;
        if (this.cancelled == true) goto L9;
        return this.result;
    L9:
        throw new CancellationException();
    L11:
        throw new ExecutionException(this.ex);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r10) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.completed == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return false;
    L10:
        this.completed = true;     // Catch: Throwable -> L8
        this.cancelled = true;     // Catch: Throwable -> L8
        notifyAll();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        FutureCallback<T> r11 = this.callback;
        if (r11 == null) goto L15;
        r11.cancelled();
    L15:
        return true;
    }

    public boolean completed(T r10) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.completed == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return false;
    L10:
        this.completed = true;     // Catch: Throwable -> L8
        this.result = r10;     // Catch: Throwable -> L8
        notifyAll();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        FutureCallback<T> r11 = this.callback;
        if (r11 == null) goto L15;
        r11.completed(r10);
    L15:
        return true;
    }

    public boolean failed(Exception r10) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.completed == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return false;
    L10:
        this.completed = true;     // Catch: Throwable -> L8
        this.ex = r10;     // Catch: Throwable -> L8
        notifyAll();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        FutureCallback<T> r11 = this.callback;
        if (r11 == null) goto L15;
        r11.failed(r10);
    L15:
        return true;
    }

    @Override // java.util.concurrent.Future
    public synchronized T get() throws InterruptedException, ExecutionException {
        monitor-enter(this);
    L13:
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.completed == true) goto L8;
        wait();     // Catch: Throwable -> L6
        goto L13
    L8:
        T r10 = getResult();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.completed;
    }

    @Override // java.util.concurrent.Future
    public synchronized T get(long r10, TimeUnit r11) throws InterruptedException, ExecutionException, TimeoutException {
        monitor-enter(this);
        Args.notNull(r11, "Time unit");     // Catch: Throwable -> L12
        long r12 = r11.toMillis(r10);     // Catch: Throwable -> L12
        if (r12 > 0) goto L6;
        long r13 = 0;
    L8:
        if (this.completed == false) goto L14;
        T r14 = getResult();     // Catch: Throwable -> L12
        monitor-exit(this);
        return r14;
    L14:
        if (r12 <= 0) goto L27;
        long r15 = r12;
    L16:
        wait(r15);     // Catch: Throwable -> L12
        if (this.completed == true) goto L18;
        r15 = r12 - (System.currentTimeMillis() - r13);     // Catch: Throwable -> L12
        if (r15 > 0) goto L16;
        throw new TimeoutException();     // Catch: Throwable -> L12
    L18:
        T r16 = getResult();     // Catch: Throwable -> L12
        monitor-exit(this);
        return r16;
    L27:
        throw new TimeoutException();     // Catch: Throwable -> L12
    L6:
        r13 = System.currentTimeMillis();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.http.concurrent.Cancellable
    public boolean cancel() {
        return cancel(true);
    }
}
