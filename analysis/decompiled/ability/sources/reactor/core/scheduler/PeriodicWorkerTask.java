package reactor.core.scheduler;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.Disposable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class PeriodicWorkerTask implements Runnable, Disposable, Callable<Void> {
    volatile Future<?> future;
    volatile Disposable.Composite parent;
    final Runnable task;
    Thread thread;
    static final Disposable.Composite DISPOSED = new EmptyCompositeDisposable();
    static final Future<Void> CANCELLED = new FutureTask(new e(2));
    static final AtomicReferenceFieldUpdater<PeriodicWorkerTask, Future> FUTURE = AtomicReferenceFieldUpdater.newUpdater(PeriodicWorkerTask.class, Future.class, "future");
    static final AtomicReferenceFieldUpdater<PeriodicWorkerTask, Disposable.Composite> PARENT = AtomicReferenceFieldUpdater.newUpdater(PeriodicWorkerTask.class, Disposable.Composite.class, "parent");

    public PeriodicWorkerTask(Runnable runnable, Disposable.Composite composite) {
        this.task = runnable;
        PARENT.lazySet(this, composite);
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
            Future<?> future = this.future;
            Future<Void> future2 = CANCELLED;
            if (future == future2) {
                break;
            } else if (FUTURE.compareAndSet(this, future, future2)) {
                if (future != null) {
                    future.cancel(this.thread != Thread.currentThread());
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
        return this.future == CANCELLED;
    }

    @Override // java.lang.Runnable
    public void run() {
        call();
    }

    public void setFuture(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.future;
            if (future2 == CANCELLED) {
                future.cancel(this.thread != Thread.currentThread());
                return;
            }
        } while (!FUTURE.compareAndSet(this, future2, future));
    }

    @Override // java.util.concurrent.Callable
    @Nullable
    public Void call() {
        this.thread = Thread.currentThread();
        try {
            this.task.run();
        } finally {
            try {
                return null;
            } finally {
            }
        }
        return null;
    }
}
