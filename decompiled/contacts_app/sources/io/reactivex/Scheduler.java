package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Scheduler {
    static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS = 0;

    static final class DisposeTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        final Runnable decoratedRun;
        Thread runner;
        final Worker w;

        DisposeTask(Runnable r1, Worker r2) {
            this.decoratedRun = r1;
            this.w = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runner = Thread.currentThread();
            this.decoratedRun.run();     // Catch: Throwable -> L6
            dispose();
            this.runner = null;
            return;
        L6:
            th = move-exception;
            dispose();
            this.runner = null;
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.runner != Thread.currentThread()) goto L7;
            Worker r0 = this.w;
            if ((r0 instanceof NewThreadWorker) == false) goto L7;
            ((NewThreadWorker) r0).shutdown();
            return;
        L7:
            this.w.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            return this.decoratedRun;
        }
    }

    static final class PeriodicDirectTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        volatile boolean disposed;
        final Runnable run;
        final Worker worker;

        PeriodicDirectTask(Runnable r1, Worker r2) {
            this.run = r1;
            this.worker = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.disposed == false) goto L10;
            return;
        L10:
            this.run.run();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.worker.dispose();
            throw ExceptionHelper.wrapOrThrow(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            return this.run;
        }
    }

    public static abstract class Worker implements Disposable {

        final class PeriodicTask implements Runnable, SchedulerRunnableIntrospection {
            long count;
            final Runnable decoratedRun;
            long lastNowNanoseconds;
            final long periodInNanoseconds;
            final SequentialDisposable sd;
            long startInNanoseconds;
            final /* synthetic */ Worker this$0;

            PeriodicTask(Worker r1, long r2, Runnable r4, long r5, SequentialDisposable r7, long r8) {
                this.this$0 = r1;
                this.decoratedRun = r4;
                this.sd = r7;
                this.periodInNanoseconds = r8;
                this.lastNowNanoseconds = r5;
                this.startInNanoseconds = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.decoratedRun.run();
                if (this.sd.isDisposed() == true) goto L13;
                long r0 = this.this$0.now(TimeUnit.NANOSECONDS);
                long r2 = Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS + r0;
                long r4 = this.lastNowNanoseconds;
                if (r2 >= r4) goto L7;
            L10:
                long r3 = this.periodInNanoseconds;
                long r5 = r0 + r3;
                long r8 = this.count + 1;
                this.count = r8;
                this.startInNanoseconds = r5 - (r3 * r8);
                long r6 = r5;
            L11:
                this.lastNowNanoseconds = r0;
                long r7 = r6 - r0;
                this.sd.replace(this.this$0.schedule(this, r7, TimeUnit.NANOSECONDS));
                return;
            L7:
                if (r0 >= ((r4 + this.periodInNanoseconds) + Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS)) goto L10;
                long r9 = this.startInNanoseconds;
                long r10 = this.count + 1;
                this.count = r10;
                r6 = r9 + (r10 * this.periodInNanoseconds);
                goto L11
            }

            @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
            public Runnable getWrappedRunnable() {
                return this.decoratedRun;
            }
        }

        public abstract Disposable schedule(Runnable r1, long r2, TimeUnit r4);

        public Worker() {
        }

        public Disposable schedule(Runnable r4) {
            return schedule(r4, 0, TimeUnit.NANOSECONDS);
        }

        public Disposable schedulePeriodically(Runnable r18, long r19, long r21, TimeUnit r23) {
            SequentialDisposable r14 = new SequentialDisposable();
            SequentialDisposable r15 = new SequentialDisposable(r14);
            Runnable r4 = RxJavaPlugins.onSchedule(r18);
            long r8 = r23.toNanos(r21);
            long r5 = now(TimeUnit.NANOSECONDS);
            Disposable r0 = schedule(new PeriodicTask(this, r5 + r23.toNanos(r19), r4, r5, r15, r8), r19, r23);
            if (r0 != EmptyDisposable.INSTANCE) goto L5;
            return r0;
        L5:
            r14.replace(r0);
            return r15;
        }

        public long now(TimeUnit r3) {
            return r3.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public abstract Worker createWorker();

    public void shutdown() {
    }

    public void start() {
    }

    public Scheduler() {
    }

    static {
        CLOCK_DRIFT_TOLERANCE_NANOSECONDS = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());
    }

    public static long clockDriftTolerance() {
        return CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
    }

    public long now(TimeUnit r3) {
        return r3.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public Disposable scheduleDirect(Runnable r4) {
        return scheduleDirect(r4, 0, TimeUnit.NANOSECONDS);
    }

    public Disposable scheduleDirect(Runnable r2, long r3, TimeUnit r5) {
        Worker r1 = createWorker();
        DisposeTask r0 = new DisposeTask(RxJavaPlugins.onSchedule(r2), r1);
        r1.schedule(r0, r3, r5);
        return r0;
    }

    public Disposable schedulePeriodicallyDirect(Runnable r8, long r9, long r11, TimeUnit r13) {
        Worker r0 = createWorker();
        PeriodicDirectTask r10 = new PeriodicDirectTask(RxJavaPlugins.onSchedule(r8), r0);
        Disposable r7 = r0.schedulePeriodically(r10, r9, r11, r13);
        if (r7 != EmptyDisposable.INSTANCE) goto L5;
        return r7;
    L5:
        return r10;
    }

    public <S extends Scheduler & Disposable> S when(Function<Flowable<Flowable<Completable>>, Completable> r2) {
        return new SchedulerWhen(r2, this);
    }
}
