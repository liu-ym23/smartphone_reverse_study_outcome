package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
import qf.a;

/* JADX INFO: loaded from: classes4.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {
    static final Object ASYNC_DISPOSED = null;
    static final Object DONE = null;
    static final int FUTURE_INDEX = 1;
    static final Object PARENT_DISPOSED = null;
    static final int PARENT_INDEX = 0;
    static final Object SYNC_DISPOSED = null;
    static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;

    static {
        PARENT_DISPOSED = new Object();
        SYNC_DISPOSED = new Object();
        ASYNC_DISPOSED = new Object();
        DONE = new Object();
    }

    public ScheduledRunnable(Runnable r10, DisposableContainer r11) {
        super(3);
        this.actual = r10;
        lazySet(0, r11);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    L2:
        Object r10 = get(1);
        if (r10 == DONE) goto L19;
        Object r11 = SYNC_DISPOSED;
        if (r10 == r11) goto L19;
        Object r12 = ASYNC_DISPOSED;
        if (r10 == r12) goto L19;
        if (get(2) == Thread.currentThread()) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L16;
        r11 = r12;
    L16:
        if (compareAndSet(1, r10, r11) == false) goto L2;
        if (r10 == null) goto L19;
        ((Future) r10).cancel(r13);
        goto L19
    L12:
        r13 = false;
    L19:
        Object r14 = get(0);
        if (r14 == DONE) goto L40;
        Object r15 = PARENT_DISPOSED;
        if (r14 == r15) goto L41;
        if (r14 == null) goto L42;
        if (compareAndSet(0, r14, r15) == false) goto L19;
        ((DisposableContainer) r14).delete(this);
        return;
    L42:
        return;
    L41:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Object r10 = get(0);
        if (r10 != PARENT_DISPOSED) goto L5;
    L6:
        return true;
    L5:
        if (r10 == DONE) goto L6;
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        lazySet(2, Thread.currentThread());
        this.actual.run();     // Catch: Throwable -> L5
    L7:
        lazySet(2, null);
        Object r10 = get(0);
        if (r10 == PARENT_DISPOSED) goto L13;
        if (compareAndSet(0, r10, DONE) == false) goto L13;
        if (r10 == null) goto L13;
        ((DisposableContainer) r10).delete(this);
    L13:
        Object r11 = get(1);
        if (r11 == SYNC_DISPOSED) goto L50;
        if (r11 == ASYNC_DISPOSED) goto L19;
        if (compareAndSet(1, r11, DONE) == false) goto L13;
        return;
    L19:
        return;
    L50:
        return;
    L5:
        th = move-exception;
        a.e(th);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        lazySet(2, null);
        Object r12 = get(0);
        if (r12 == PARENT_DISPOSED) goto L27;
        if (compareAndSet(0, r12, DONE) == false) goto L27;
        if (r12 == null) goto L27;
        ((DisposableContainer) r12).delete(this);
    L27:
        Object r13 = get(1);
        if (r13 == SYNC_DISPOSED) goto L34;
        if (r13 == ASYNC_DISPOSED) goto L34;
        if (compareAndSet(1, r13, DONE) == false) goto L27;
    L34:
        throw th;
    }

    public void setFuture(Future<?> r10) {
    L2:
        Object r11 = get(1);
        if (r11 == DONE) goto L4;
        if (r11 == SYNC_DISPOSED) goto L7;
        if (r11 == ASYNC_DISPOSED) goto L11;
        if (compareAndSet(1, r11, r10) == false) goto L2;
        return;
    L11:
        r10.cancel(true);
        return;
    L7:
        r10.cancel(false);
        return;
    }
}
