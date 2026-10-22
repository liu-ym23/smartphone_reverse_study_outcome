package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public abstract class AbstractScheduledService implements Service {
    private static final Logger logger = null;
    private final AbstractService delegate;

    @Beta
    public static abstract class CustomScheduler extends Scheduler {

        public class ReschedulableCallable extends ForwardingFuture<Void> implements Callable<Void> {

            @NullableDecl
            @GuardedBy("lock")
            private Future<Void> currentFuture;
            private final ScheduledExecutorService executor;
            private final ReentrantLock lock;
            private final AbstractService service;
            final /* synthetic */ CustomScheduler this$0;
            private final Runnable wrappedRunnable;

            public ReschedulableCallable(CustomScheduler r10, AbstractService r11, ScheduledExecutorService r12, Runnable r13) {
                this.this$0 = r10;
                this.lock = new ReentrantLock();
                this.wrappedRunnable = r13;
                this.executor = r12;
                this.service = r11;
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Void call() throws Exception {
                return call2();
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean r10) {
                this.lock.lock();
                boolean r11 = this.currentFuture.cancel(r10);     // Catch: Throwable -> L6
                this.lock.unlock();
                return r11;
            L6:
                th = move-exception;
                this.lock.unlock();
                throw th;
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
            public /* bridge */ /* synthetic */ Object delegate() {
                return delegate();
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean isCancelled() {
                this.lock.lock();
                boolean r10 = this.currentFuture.isCancelled();     // Catch: Throwable -> L6
                this.lock.unlock();
                return r10;
            L6:
                th = move-exception;
                this.lock.unlock();
                throw th;
            }

            public void reschedule() {
                Schedule r10 = this.this$0.getNextSchedule();     // Catch: Throwable -> L17
                this.lock.lock();
                Future<Void> r11 = this.currentFuture;     // Catch: Throwable -> L9
                if (r11 != null) goto L7;
            L11:
                this.currentFuture = this.executor.schedule(this, Schedule.access$800(r10), Schedule.access$900(r10));     // Catch: Throwable -> L9
            L12:
                this.lock.unlock();
                th = null;
            L14:
                if (th == null) goto L24;
                this.service.notifyFailed(th);
                return;
            L24:
                return;
            L7:
                if (r11.isCancelled() == true) goto L12;
            L9:
                th = th;
                this.lock.unlock();
            L17:
                th = move-exception;
                this.service.notifyFailed(th);
            }

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public Void call2() throws Exception {
                this.wrappedRunnable.run();
                reschedule();
                return null;
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
            public Future<Void> delegate() {
                throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
            }
        }

        @Beta
        public static final class Schedule {
            private final long delay;
            private final TimeUnit unit;

            public Schedule(long r10, TimeUnit r11) {
                this.delay = r10;
                this.unit = (TimeUnit) Preconditions.checkNotNull(r11);
            }

            public static /* synthetic */ long access$800(Schedule r10) {
                return r10.delay;
            }

            public static /* synthetic */ TimeUnit access$900(Schedule r10) {
                return r10.unit;
            }
        }

        public CustomScheduler() {
            super(null);
        }

        public abstract Schedule getNextSchedule() throws Exception;

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
        public final Future<?> schedule(AbstractService r10, ScheduledExecutorService r11, Runnable r12) {
            ReschedulableCallable r13 = new ReschedulableCallable(this, r10, r11, r12);
            r13.reschedule();
            return r13;
        }
    }

    public static abstract class Scheduler {
        public /* synthetic */ Scheduler(AnonymousClass1 r10) {
            this();
        }

        public static Scheduler newFixedDelaySchedule(final long r10, final long r11, final TimeUnit r12) {
            Preconditions.checkNotNull(r12);
            if (r11 <= 0) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13, "delay must be > 0, found %s", r11);
            return new AnonymousClass1(r10, r11, r12);
        L5:
            r13 = false;
            goto L6
        }

        public static Scheduler newFixedRateSchedule(final long r10, final long r11, final TimeUnit r12) {
            Preconditions.checkNotNull(r12);
            if (r11 <= 0) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13, "period must be > 0, found %s", r11);
            return new AnonymousClass2(r10, r11, r12);
        L5:
            r13 = false;
            goto L6
        }

        public abstract Future<?> schedule(AbstractService r10, ScheduledExecutorService r11, Runnable r12);

        private Scheduler() {
        }
    }

    public final class ServiceDelegate extends AbstractService {

        @MonotonicNonNullDecl
        private volatile ScheduledExecutorService executorService;
        private final ReentrantLock lock;

        @MonotonicNonNullDecl
        private volatile Future<?> runningTask;
        private final Runnable task;
        final /* synthetic */ AbstractScheduledService this$0;

        public class Task implements Runnable {
            final /* synthetic */ ServiceDelegate this$1;

            public Task(ServiceDelegate r10) {
                this.this$1 = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                ServiceDelegate.access$200(this.this$1).lock();
            L9:
                th = move-exception;
                this.this$1.this$0.shutDown();     // Catch: Throwable -> L12 Exception -> L14
            L16:
                this.this$1.notifyFailed(th);     // Catch: Throwable -> L12
                ServiceDelegate.access$300(this.this$1).cancel(false);     // Catch: Throwable -> L12
            L8:
                ServiceDelegate.access$200(this.this$1).unlock();
                return;
            L14:
                e = move-exception;
                AbstractScheduledService.access$400().log(Level.WARNING, "Error while attempting to shut down the service after failure.", e);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                ServiceDelegate.access$200(this.this$1).unlock();
                throw th;
            L4:
                if (ServiceDelegate.access$300(this.this$1).isCancelled() == false) goto L7;
                ServiceDelegate.access$200(this.this$1).unlock();
                return;
            L7:
                this.this$1.this$0.runOneIteration();     // Catch: Throwable -> L9
                goto L8
            }
        }

        private ServiceDelegate(AbstractScheduledService r10) {
            this.this$0 = r10;
            this.lock = new ReentrantLock();
            this.task = new Task(this);
        }

        public static /* synthetic */ ReentrantLock access$200(ServiceDelegate r10) {
            return r10.lock;
        }

        public static /* synthetic */ Future access$300(ServiceDelegate r10) {
            return r10.runningTask;
        }

        public static /* synthetic */ Future access$302(ServiceDelegate r10, Future r11) {
            r10.runningTask = r11;
            return r11;
        }

        public static /* synthetic */ ScheduledExecutorService access$600(ServiceDelegate r10) {
            return r10.executorService;
        }

        public static /* synthetic */ Runnable access$700(ServiceDelegate r10) {
            return r10.task;
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStart() {
            this.executorService = MoreExecutors.renamingDecorator(this.this$0.executor(), new AnonymousClass1(this));
            this.executorService.execute(new AnonymousClass2(this));
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStop() {
            this.runningTask.cancel(false);
            this.executorService.execute(new AnonymousClass3(this));
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return this.this$0.toString();
        }

        public /* synthetic */ ServiceDelegate(AbstractScheduledService r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    static {
        logger = Logger.getLogger(AbstractScheduledService.class.getName());
    }

    public AbstractScheduledService() {
        this.delegate = new ServiceDelegate(this, null);
    }

    public static /* synthetic */ Logger access$400() {
        return logger;
    }

    public static /* synthetic */ AbstractService access$500(AbstractScheduledService r10) {
        return r10.delegate;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener r10, Executor r11) {
        this.delegate.addListener(r10, r11);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    public ScheduledExecutorService executor() {
        final ScheduledExecutorService r10 = Executors.newSingleThreadScheduledExecutor(new C1ThreadFactoryImpl(this));
        addListener(new AnonymousClass1(this, r10), MoreExecutors.directExecutor());
        return r10;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public abstract void runOneIteration() throws Exception;

    public abstract Scheduler scheduler();

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public void shutDown() throws Exception {
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    public void startUp() throws Exception {
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long r10, TimeUnit r11) throws TimeoutException {
        this.delegate.awaitRunning(r10, r11);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long r10, TimeUnit r11) throws TimeoutException {
        this.delegate.awaitTerminated(r10, r11);
    }
}
