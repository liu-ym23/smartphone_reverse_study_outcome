package reactor.core.scheduler;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.Disposable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class InstantPeriodicWorkerTask implements Disposable, Callable<Void> {
    final ExecutorService executor;
    volatile Future<?> first;
    volatile Disposable.Composite parent;
    volatile Future<?> rest;
    final Runnable task;
    Thread thread;
    static final Disposable.Composite DISPOSED = new EmptyCompositeDisposable();
    static final Future<Void> CANCELLED = new FutureTask(new e(0));
    static final AtomicReferenceFieldUpdater<InstantPeriodicWorkerTask, Future> REST = AtomicReferenceFieldUpdater.newUpdater(InstantPeriodicWorkerTask.class, Future.class, "rest");
    static final AtomicReferenceFieldUpdater<InstantPeriodicWorkerTask, Future> FIRST = AtomicReferenceFieldUpdater.newUpdater(InstantPeriodicWorkerTask.class, Future.class, "first");
    static final AtomicReferenceFieldUpdater<InstantPeriodicWorkerTask, Disposable.Composite> PARENT = AtomicReferenceFieldUpdater.newUpdater(InstantPeriodicWorkerTask.class, Disposable.Composite.class, "parent");

    public InstantPeriodicWorkerTask(Runnable runnable, ExecutorService executorService) {
        this.task = runnable;
        this.executor = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$static$0() throws Exception {
        return null;
    }

    @Override // reactor.core.Disposable
    public void dispose() {
        Disposable.Composite composite;
        Disposable.Composite composite2;
        while (true) {
            Future<?> future = this.first;
            Future<Void> future2 = CANCELLED;
            if (future == future2) {
                break;
            } else if (FIRST.compareAndSet(this, future, future2)) {
                if (future != null) {
                    future.cancel(this.thread != Thread.currentThread());
                }
            }
        }
        while (true) {
            Future<?> future3 = this.rest;
            Future<Void> future4 = CANCELLED;
            if (future3 == future4) {
                break;
            } else if (REST.compareAndSet(this, future3, future4)) {
                if (future3 != null) {
                    future3.cancel(this.thread != Thread.currentThread());
                }
            }
        }
        do {
            composite = this.parent;
            composite2 = DISPOSED;
            if (composite == composite2 || composite == null) {
                return;
            }
        } while (!PARENT.compareAndSet(this, composite, composite2));
        composite.remove(this);
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        return this.rest == CANCELLED;
    }

    public void setFirst(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.first;
            if (future2 == CANCELLED) {
                future.cancel(this.thread != Thread.currentThread());
                return;
            }
        } while (!FIRST.compareAndSet(this, future2, future));
    }

    public void setRest(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.rest;
            if (future2 == CANCELLED) {
                future.cancel(this.thread != Thread.currentThread());
                return;
            }
        } while (!REST.compareAndSet(this, future2, future));
    }

    @Override // java.util.concurrent.Callable
    @Nullable
    public Void call() {
        this.thread = Thread.currentThread();
        try {
            this.task.run();
            setRest(this.executor.submit(this));
        } finally {
            try {
                return null;
            } finally {
            }
        }
        return null;
    }

    public InstantPeriodicWorkerTask(Runnable runnable, ExecutorService executorService, Disposable.Composite composite) {
        this.task = runnable;
        this.executor = executorService;
        PARENT.lazySet(this, composite);
    }
}
