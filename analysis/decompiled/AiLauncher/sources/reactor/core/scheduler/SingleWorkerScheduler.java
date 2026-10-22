package reactor.core.scheduler;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.core.scheduler.ExecutorScheduler;
import reactor.core.scheduler.Scheduler;

/* loaded from: classes5.dex */
final class SingleWorkerScheduler implements Scheduler, Executor, Scannable {
    final Scheduler.Worker main;

    public SingleWorkerScheduler(Scheduler scheduler) {
        this.main = scheduler.createWorker();
    }

    @Override // reactor.core.scheduler.Scheduler
    public Scheduler.Worker createWorker() {
        return new ExecutorScheduler.ExecutorSchedulerWorker(this);
    }

    @Override // reactor.core.scheduler.Scheduler, reactor.core.Disposable
    public void dispose() {
        this.main.dispose();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.main.schedule(runnable);
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        return this.main.isDisposed();
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return (attr == Scannable.Attr.TERMINATED || attr == Scannable.Attr.CANCELLED) ? Boolean.valueOf(isDisposed()) : attr == Scannable.Attr.PARENT ? this.main : attr == Scannable.Attr.NAME ? toString() : Scannable.from(this.main).scanUnsafe(attr);
    }

    @Override // reactor.core.scheduler.Scheduler
    public Disposable schedule(Runnable runnable) {
        return this.main.schedule(runnable);
    }

    @Override // reactor.core.scheduler.Scheduler
    public Disposable schedulePeriodically(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return this.main.schedulePeriodically(runnable, j10, j11, timeUnit);
    }

    public String toString() {
        Scannable scannableFrom = Scannable.from(this.main);
        if (scannableFrom.isScanAvailable()) {
            return "singleWorker(" + scannableFrom.scanUnsafe(Scannable.Attr.NAME) + ")";
        }
        return "singleWorker(" + this.main.toString() + ")";
    }

    @Override // reactor.core.scheduler.Scheduler
    public Disposable schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        return this.main.schedule(runnable, j10, timeUnit);
    }
}
