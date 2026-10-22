package reactor.core.scheduler;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class SchedulerTask implements Runnable, Disposable, Callable<Void> {
    volatile Future<?> future;
    volatile Disposable parent;
    final Runnable task;
    Thread thread;
    static final Future<Void> FINISHED = new FutureTask(new e(3));
    static final Future<Void> CANCELLED = new FutureTask(new e(4));
    static final Disposable TAKEN = Disposables.disposed();
    static final AtomicReferenceFieldUpdater<SchedulerTask, Future> FUTURE = AtomicReferenceFieldUpdater.newUpdater(SchedulerTask.class, Future.class, "future");
    static final AtomicReferenceFieldUpdater<SchedulerTask, Disposable> PARENT = AtomicReferenceFieldUpdater.newUpdater(SchedulerTask.class, Disposable.class, "parent");

    public SchedulerTask(Runnable runnable, @Nullable Disposable disposable) {
        this.task = runnable;
        PARENT.lazySet(this, disposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$static$0() throws Exception {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$static$1() throws Exception {
        return null;
    }

    @Override // reactor.core.Disposable
    public void dispose() {
        Disposable disposable;
        Disposable disposable2;
        Future<Void> future;
        while (true) {
            Future<?> future2 = this.future;
            if (future2 == FINISHED || future2 == (future = CANCELLED)) {
                break;
            } else if (FUTURE.compareAndSet(this, future2, future)) {
                if (future2 != null) {
                    future2.cancel(this.thread != Thread.currentThread());
                }
            }
        }
        do {
            disposable = this.parent;
            disposable2 = TAKEN;
            if (disposable == disposable2 || disposable == null) {
                return;
            }
        } while (!PARENT.compareAndSet(this, disposable, disposable2));
        disposable.dispose();
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        Future<?> future = this.future;
        return FINISHED == future || CANCELLED == future;
    }

    @Override // java.lang.Runnable
    public void run() {
        call();
    }

    public void setFuture(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.future;
            if (future2 == FINISHED) {
                return;
            }
            if (future2 == CANCELLED) {
                future.cancel(this.thread != Thread.currentThread());
                return;
            }
        } while (!FUTURE.compareAndSet(this, future2, future));
    }

    @Override // java.util.concurrent.Callable
    @Nullable
    public Void call() {
        Future<?> future;
        Disposable disposable;
        Future<Void> future2;
        boolean zCompareAndSet;
        this.thread = Thread.currentThread();
        Disposable disposable2 = null;
        do {
            try {
                disposable2 = this.parent;
                disposable = TAKEN;
                if (disposable2 != disposable && disposable2 != null) {
                }
            } finally {
                this.thread = null;
                do {
                    future = this.future;
                    if (future == CANCELLED) {
                        break;
                    }
                } while (!FUTURE.compareAndSet(this, future, FINISHED));
                if (disposable2 != null) {
                    disposable2.dispose();
                }
            }
        } while (!PARENT.compareAndSet(this, disposable2, disposable));
        try {
            this.task.run();
        } catch (Throwable th) {
            Schedulers.handleError(th);
        }
        do {
            if (future == future2) {
                break;
            }
        } while (!zCompareAndSet);
        return null;
    }
}
