package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements Disposable, SchedulerRunnableIntrospection {
    protected static final FutureTask<Void> DISPOSED = null;
    protected static final FutureTask<Void> FINISHED = null;
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;

    static {
        FINISHED = new FutureTask(Functions.EMPTY_RUNNABLE, null);
        DISPOSED = new FutureTask(Functions.EMPTY_RUNNABLE, null);
    }

    AbstractDirectTask(Runnable r1) {
        this.runnable = r1;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Future<?> r0 = get();
        if (r0 == FINISHED) goto L15;
        FutureTask<Void> r1 = DISPOSED;
        if (r0 != r1) goto L7;
        return;
    L7:
        if (compareAndSet(r0, r1) == false) goto L17;
        if (r0 != null) goto L10;
        return;
    L10:
        if (this.runner == Thread.currentThread()) goto L12;
        boolean r2 = true;
    L13:
        r0.cancel(r2);
        return;
    L12:
        r2 = false;
        goto L13
    L17:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        Future<?> r1 = get();
        if (r1 != FINISHED) goto L5;
    L8:
        return true;
    L5:
        if (r1 == DISPOSED) goto L8;
        return false;
    }

    public final void setFuture(Future<?> r3) {
    L2:
        Future<?> r0 = get();
        if (r0 == FINISHED) goto L19;
        if (r0 == DISPOSED) goto L8;
        if (compareAndSet(r0, r3) == false) goto L2;
        return;
    L8:
        if (this.runner == Thread.currentThread()) goto L10;
        boolean r2 = true;
    L11:
        r3.cancel(r2);
        return;
    L10:
        r2 = false;
        goto L11
    }

    @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
    public Runnable getWrappedRunnable() {
        return this.runnable;
    }
}
