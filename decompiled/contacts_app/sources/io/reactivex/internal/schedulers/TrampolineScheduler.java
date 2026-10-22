package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class TrampolineScheduler extends Scheduler {
    private static final TrampolineScheduler INSTANCE = null;

    static final class SleepingRunnable implements Runnable {
        private final long execTime;
        private final Runnable run;
        private final TrampolineWorker worker;

        SleepingRunnable(Runnable r1, TrampolineWorker r2, long r3) {
            this.run = r1;
            this.worker = r2;
            this.execTime = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.worker.disposed == true) goto L18;
            long r0 = this.worker.now(TimeUnit.MILLISECONDS);
            long r2 = this.execTime;
            if (r2 <= r0) goto L13;
            Thread.sleep(r2 - r0);     // Catch: InterruptedException -> L9
        L9:
            e = move-exception;
            Thread.currentThread().interrupt();
            RxJavaPlugins.onError(e);
            return;
        L13:
            if (this.worker.disposed == true) goto L19;
            this.run.run();
            return;
        L19:
            return;
        }
    }

    static final class TimedRunnable implements Comparable<TimedRunnable> {
        final int count;
        volatile boolean disposed;
        final long execTime;
        final Runnable run;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(TimedRunnable r1) {
            return compareTo2(r1);
        }

        TimedRunnable(Runnable r1, Long r2, int r3) {
            this.run = r1;
            this.execTime = r2.longValue();
            this.count = r3;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(TimedRunnable r5) {
            int r0 = ObjectHelper.compare(this.execTime, r5.execTime);
            if (r0 == 0) goto L5;
            return r0;
        L5:
            return ObjectHelper.compare(this.count, r5.count);
        }
    }

    static final class TrampolineWorker extends Scheduler.Worker implements Disposable {
        final AtomicInteger counter;
        volatile boolean disposed;
        final PriorityBlockingQueue<TimedRunnable> queue;
        private final AtomicInteger wip;

        final class AppendToQueueTask implements Runnable {
            final /* synthetic */ TrampolineWorker this$0;
            final TimedRunnable timedRunnable;

            AppendToQueueTask(TrampolineWorker r1, TimedRunnable r2) {
                this.this$0 = r1;
                this.timedRunnable = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.timedRunnable.disposed = true;
                this.this$0.queue.remove(this.timedRunnable);
            }
        }

        TrampolineWorker() {
            this.queue = new PriorityBlockingQueue();
            this.wip = new AtomicInteger();
            this.counter = new AtomicInteger();
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable r3) {
            return enqueue(r3, now(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable r3, long r4, TimeUnit r6) {
            long r0 = now(TimeUnit.MILLISECONDS) + r6.toMillis(r4);
            return enqueue(new SleepingRunnable(r3, this, r0), r0);
        }

        Disposable enqueue(Runnable r2, long r3) {
            if (this.disposed == true) goto L5;
            TimedRunnable r0 = new TimedRunnable(r2, Long.valueOf(r3), this.counter.incrementAndGet());
            this.queue.add(r0);
            if (this.wip.getAndIncrement() != 0) goto L23;
            int r4 = 1;
        L10:
            if (this.disposed == true) goto L11;
            TimedRunnable r5 = this.queue.poll();
            if (r5 == null) goto L15;
            if (r5.disposed == true) goto L10;
            r5.run.run();
            goto L10
        L15:
            r4 = this.wip.addAndGet(-r4);
            if (r4 != 0) goto L10;
            return EmptyDisposable.INSTANCE;
        L11:
            this.queue.clear();
            return EmptyDisposable.INSTANCE;
        L23:
            return Disposables.fromRunnable(new AppendToQueueTask(this, r0));
        L5:
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    static {
        INSTANCE = new TrampolineScheduler();
    }

    public static TrampolineScheduler instance() {
        return INSTANCE;
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new TrampolineWorker();
    }

    TrampolineScheduler() {
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable r1) {
        RxJavaPlugins.onSchedule(r1).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable r1, long r2, TimeUnit r4) {
        r4.sleep(r2);     // Catch: InterruptedException -> L4
        RxJavaPlugins.onSchedule(r1).run();     // Catch: InterruptedException -> L4
    L7:
        return EmptyDisposable.INSTANCE;
    L4:
        e = move-exception;
        Thread.currentThread().interrupt();
        RxJavaPlugins.onError(e);
        goto L7
    }
}
