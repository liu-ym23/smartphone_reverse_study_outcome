package reactor.core.scheduler;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;

/* loaded from: classes5.dex */
final class ExecutorServiceWorker implements Scheduler.Worker, Disposable, Scannable {
    final Disposable.Composite disposables = Disposables.composite();
    final ScheduledExecutorService exec;

    public ExecutorServiceWorker(ScheduledExecutorService scheduledExecutorService) {
        this.exec = scheduledExecutorService;
    }

    @Override // reactor.core.Disposable
    public void dispose() {
        this.disposables.dispose();
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        return this.disposables.isDisposed();
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.disposables.size()) : (attr == Scannable.Attr.TERMINATED || attr == Scannable.Attr.CANCELLED) ? Boolean.valueOf(isDisposed()) : attr == Scannable.Attr.NAME ? "ExecutorServiceWorker" : Schedulers.scanExecutor(this.exec, attr);
    }

    @Override // reactor.core.scheduler.Scheduler.Worker
    public Disposable schedule(Runnable runnable) {
        return Schedulers.workerSchedule(this.exec, this.disposables, runnable, 0L, TimeUnit.MILLISECONDS);
    }

    @Override // reactor.core.scheduler.Scheduler.Worker
    public Disposable schedulePeriodically(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return Schedulers.workerSchedulePeriodically(this.exec, this.disposables, runnable, j10, j11, timeUnit);
    }

    @Override // reactor.core.scheduler.Scheduler.Worker
    public Disposable schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        return Schedulers.workerSchedule(this.exec, this.disposables, runnable, j10, timeUnit);
    }
}
