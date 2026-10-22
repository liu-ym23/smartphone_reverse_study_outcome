package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class RequestFuture<T> implements Future<T>, Response.Listener<T>, Response.ErrorListener {
    private VolleyError mException;
    private Request<?> mRequest;
    private T mResult;
    private boolean mResultReceived;

    private RequestFuture() {
        this.mResultReceived = false;
    }

    private synchronized T doGet(Long r10) throws InterruptedException, ExecutionException, TimeoutException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mException != null) goto L30;
        if (this.mResultReceived == false) goto L13;
        T r11 = this.mResult;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r11;
    L13:
        if (r10 != null) goto L16;
        wait(0);     // Catch: Throwable -> L10
    L19:
        if (this.mException != null) goto L28;
        if (this.mResultReceived == false) goto L26;
        T r12 = this.mResult;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r12;
    L26:
        throw new TimeoutException();     // Catch: Throwable -> L10
    L28:
        throw new ExecutionException(this.mException);     // Catch: Throwable -> L10
    L16:
        if (r10.longValue() <= 0) goto L19;
        wait(r10.longValue());     // Catch: Throwable -> L10
        goto L19
    L30:
        throw new ExecutionException(this.mException);     // Catch: Throwable -> L10
    }

    public static <E> RequestFuture<E> newFuture() {
        return new RequestFuture();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean r10) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mRequest != null) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (isDone() == true) goto L16;
        this.mRequest.cancel();     // Catch: Throwable -> L14
        monitor-exit(this);
        return true;
    L16:
        monitor-exit(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        return doGet(null);
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Request<?> r10 = this.mRequest;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.isCanceled();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mResultReceived == false) goto L6;
    L13:
        boolean r10 = true;
    L14:
        monitor-exit(this);
        return r10;
    L6:
        if (this.mException != null) goto L13;
        if (isCancelled() == true) goto L13;
        r10 = false;
        goto L14
    }

    @Override // com.android.volley.Response.ErrorListener
    public synchronized void onErrorResponse(VolleyError r10) {
        monitor-enter(this);
        this.mException = r10;     // Catch: Throwable -> L6
        notifyAll();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.volley.Response.Listener
    public synchronized void onResponse(T r10) {
        monitor-enter(this);
        this.mResultReceived = true;     // Catch: Throwable -> L7
        this.mResult = r10;     // Catch: Throwable -> L7
        notifyAll();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setRequest(Request<?> r10) {
        this.mRequest = r10;
    }

    @Override // java.util.concurrent.Future
    public T get(long r10, TimeUnit r11) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(TimeUnit.MILLISECONDS.convert(r10, r11)));
    }
}
