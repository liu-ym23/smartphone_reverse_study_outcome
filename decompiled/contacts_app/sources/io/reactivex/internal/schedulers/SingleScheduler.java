package io.reactivex.internal.schedulers;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleScheduler extends Scheduler {
    private static final String KEY_SINGLE_PRIORITY = "rx2.single-priority";
    static final ScheduledExecutorService SHUTDOWN = null;
    static final RxThreadFactory SINGLE_THREAD_FACTORY = null;
    private static final String THREAD_NAME_PREFIX = "RxSingleScheduler";
    final AtomicReference<ScheduledExecutorService> executor;
    final ThreadFactory threadFactory;

    static final class ScheduledWorker extends Scheduler.Worker {
        volatile boolean disposed;
        final ScheduledExecutorService executor;
        final CompositeDisposable tasks;

        ScheduledWorker(ScheduledExecutorService r1) {
            this.executor = r1;
            this.tasks = new CompositeDisposable();
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable r4, long r5, TimeUnit r7) {
            if (this.disposed == true) goto L5;
            ScheduledRunnable r0 = new ScheduledRunnable(RxJavaPlugins.onSchedule(r4), this.tasks);
            this.tasks.add(r0);
            if (r5 > 0) goto L9;
            Future<?> r6 = this.executor.submit(r0);     // Catch: RejectedExecutionException -> L12
        L10:
            r0.setFuture(r6);     // Catch: RejectedExecutionException -> L12
            return r0;
        L9:
            r6 = this.executor.schedule(r0, r5, r7);     // Catch: RejectedExecutionException -> L12
        L12:
            e = move-exception;
            dispose();
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        L5:
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.disposed == true) goto L6;
            this.disposed = true;
            this.tasks.dispose();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    static {
        ScheduledExecutorService r0 = Executors.newScheduledThreadPool(0);
        SHUTDOWN = r0;
        r0.shutdown();
        SINGLE_THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_SINGLE_PRIORITY, 5).intValue())), true);
    }

    public SingleScheduler() {
        this(SINGLE_THREAD_FACTORY);
    }

    public SingleScheduler(ThreadFactory r2) {
        AtomicReference<ScheduledExecutorService> r0 = new AtomicReference();
        this.executor = r0;
        this.threadFactory = r2;
        r0.lazySet(createExecutor(r2));
    }

    static ScheduledExecutorService createExecutor(ThreadFactory r0) {
        return SchedulerPoolFactory.create(r0);
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        ScheduledExecutorService r0 = null;
    L3:
        ScheduledExecutorService r1 = this.executor.get();
        if (r1 != SHUTDOWN) goto L5;
        if (r0 != null) goto L11;
        r0 = createExecutor(this.threadFactory);
    L11:
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.executor, r1, r0) == false) goto L3;
        return;
    L5:
        if (r0 == null) goto L16;
        r0.shutdown();
        return;
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        ScheduledExecutorService r0 = this.executor.get();
        ScheduledExecutorService r1 = SHUTDOWN;
        if (r0 == r1) goto L8;
        ScheduledExecutorService r2 = this.executor.getAndSet(r1);
        if (r2 == r1) goto L9;
        r2.shutdownNow();
        return;
    L9:
        return;
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new ScheduledWorker(this.executor.get());
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable r4, long r5, TimeUnit r7) {
        ScheduledDirectTask r0 = new ScheduledDirectTask(RxJavaPlugins.onSchedule(r4));
        if (r5 > 0) goto L5;
        Future<?> r3 = this.executor.get().submit(r0);     // Catch: RejectedExecutionException -> L8
    L6:
        r0.setFuture(r3);     // Catch: RejectedExecutionException -> L8
        return r0;
    L5:
        r3 = this.executor.get().schedule(r0, r5, r7);     // Catch: RejectedExecutionException -> L8
    L8:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.Scheduler
    public Disposable schedulePeriodicallyDirect(Runnable r9, long r10, long r12, TimeUnit r14) {
        Runnable r11 = RxJavaPlugins.onSchedule(r9);
        if (r12 > 0) goto L13;
        ScheduledExecutorService r8 = this.executor.get();
        InstantPeriodicTask r13 = new InstantPeriodicTask(r11, r8);
        if (r10 > 0) goto L7;
        Future<?> r15 = r8.submit(r13);     // Catch: RejectedExecutionException -> L10
    L8:
        r13.setFirst(r15);     // Catch: RejectedExecutionException -> L10
        return r13;
    L7:
        r15 = r8.schedule(r13, r10, r14);     // Catch: RejectedExecutionException -> L10
    L10:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    L13:
        ScheduledDirectPeriodicTask r7 = new ScheduledDirectPeriodicTask(r11);
        r7.setFuture(this.executor.get().scheduleAtFixedRate(r7, r10, r12, r14));     // Catch: RejectedExecutionException -> L16
        return r7;
    L16:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    }
}
