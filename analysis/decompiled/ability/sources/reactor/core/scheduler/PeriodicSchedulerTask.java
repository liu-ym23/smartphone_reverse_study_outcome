package reactor.core.scheduler;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.Disposable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class PeriodicSchedulerTask implements Runnable, Disposable, Callable<Void> {
    static final Future<Void> CANCELLED = new FutureTask(new e(1));
    static final AtomicReferenceFieldUpdater<PeriodicSchedulerTask, Future> FUTURE = AtomicReferenceFieldUpdater.newUpdater(PeriodicSchedulerTask.class, Future.class, "future");
    volatile Future<?> future;
    final Runnable task;
    Thread thread;

    public PeriodicSchedulerTask(Runnable runnable) {
        this.task = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$static$0() throws Exception {
        return null;
    }

    @Override // reactor.core.Disposable
    public void dispose() {
        Future<?> future;
        Future<Void> future2;
        do {
            future = this.future;
            future2 = CANCELLED;
            if (future == future2) {
                return;
            }
        } while (!FUTURE.compareAndSet(this, future, future2));
        if (future != null) {
            future.cancel(this.thread != Thread.currentThread());
        }
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
