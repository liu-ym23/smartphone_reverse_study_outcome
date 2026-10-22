package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractScheduledService implements Service {
    private static final Logger logger = null;
    private final AbstractService delegate;

    public static abstract class CustomScheduler extends Scheduler {

        private class ReschedulableCallable extends ForwardingFuture<Void> implements Callable<Void> {
            private Future<Void> currentFuture;
            private final ScheduledExecutorService executor;
            private final ReentrantLock lock;
            private final AbstractService service;
            final /* synthetic */ CustomScheduler this$0;
            private final Runnable wrappedRunnable;

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Void call() throws Exception {
                return call2();
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
            protected /* bridge */ /* synthetic */ Object delegate() {
                return delegate();
            }

            ReschedulableCallable(CustomScheduler r1, AbstractService r2, ScheduledExecutorService r3, Runnable r4) {
                this.this$0 = r1;
                this.lock = new ReentrantLock();
                this.wrappedRunnable = r4;
                this.executor = r3;
                this.service = r2;
            }

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public Void call2() throws Exception {
                this.wrappedRunnable.run();
                reschedule();
                return null;
            }

            public void reschedule() {
                this.lock.lock();
                Future<Void> r0 = this.currentFuture;     // Catch: Throwable -> L9
                if (r0 != null) goto L6;
            L7:
                Schedule r1 = this.this$0.getNextSchedule();     // Catch: Throwable -> L9
                this.currentFuture = this.executor.schedule(this, Schedule.access$700(r1), Schedule.access$800(r1));     // Catch: Throwable -> L9
            L11:
                this.lock.unlock();
                return;
            L6:
                if (r0.isCancelled() == true) goto L11;
            L9:
                th = move-exception;
                this.service.notifyFailed(th);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                this.lock.unlock();
                throw th;
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean r2) {
                this.lock.lock();
                boolean r3 = this.currentFuture.cancel(r2);     // Catch: Throwable -> L6
                this.lock.unlock();
                return r3;
            L6:
                th = move-exception;
                this.lock.unlock();
                throw th;
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
            protected Future<Void> delegate() {
                throw new UnsupportedOperationException("Only cancel is supported by this future");
            }
        }

        protected static final class Schedule {
            private final long delay;
            private final TimeUnit unit;

            static /* synthetic */ long access$700(Schedule r2) {
                return r2.delay;
            }

            static /* synthetic */ TimeUnit access$800(Schedule r0) {
                return r0.unit;
            }

            public Schedule(long r1, TimeUnit r3) {
                this.delay = r1;
                this.unit = (TimeUnit) Preconditions.checkNotNull(r3);
            }
        }

        protected abstract Schedule getNextSchedule() throws Exception;

        public CustomScheduler() {
            super(null);
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
        final Future<?> schedule(AbstractService r2, ScheduledExecutorService r3, Runnable r4) {
            ReschedulableCallable r0 = new ReschedulableCallable(this, r2, r3, r4);
            r0.reschedule();
            return r0;
        }
    }

    public static abstract class Scheduler {
        abstract Future<?> schedule(AbstractService r1, ScheduledExecutorService r2, Runnable r3);

        /* synthetic */ Scheduler(AnonymousClass1 r1) {
            this();
        }

        public static Scheduler newFixedDelaySchedule(final long r7, final long r9, final TimeUnit r11) {
            return new AnonymousClass1(r7, r9, r11);
        }

        public static Scheduler newFixedRateSchedule(final long r7, final long r9, final TimeUnit r11) {
            return new AnonymousClass2(r7, r9, r11);
        }

        private Scheduler() {
        }
    }

    protected abstract void runOneIteration() throws Exception;

    protected abstract Scheduler scheduler();

    protected void shutDown() throws Exception {
    }

    protected void startUp() throws Exception {
    }

    static /* synthetic */ Logger access$200() {
        return logger;
    }

    static /* synthetic */ AbstractService access$400(AbstractScheduledService r0) {
        return r0.delegate;
    }

    static {
        logger = Logger.getLogger(AbstractScheduledService.class.getName());
    }

    protected AbstractScheduledService() {
        this.delegate = new AnonymousClass1(this);
    }

    protected ScheduledExecutorService executor() {
        final ScheduledExecutorService r0 = Executors.newSingleThreadScheduledExecutor(new AnonymousClass2(this));
        addListener(new AnonymousClass3(this, r0), MoreExecutors.directExecutor());
        return r0;
    }

    protected String serviceName() {
        return getClass().getSimpleName();
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener r1, Executor r2) {
        this.delegate.addListener(r1, r2);
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long r1, TimeUnit r3) throws TimeoutException {
        this.delegate.awaitRunning(r1, r3);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long r1, TimeUnit r3) throws TimeoutException {
        this.delegate.awaitTerminated(r1, r3);
    }
}
