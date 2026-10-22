package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class MoreExecutors {

    /* JADX INFO: renamed from: com.google.common.util.concurrent.MoreExecutors$5, reason: invalid class name */
    public static class AnonymousClass5 implements Executor {
        boolean thrownFromDelegate;
        final /* synthetic */ Executor val$delegate;
        final /* synthetic */ AbstractFuture val$future;

        public AnonymousClass5(Executor r10, AbstractFuture r11) {
            this.val$delegate = r10;
            this.val$future = r11;
            this.thrownFromDelegate = true;
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable r10) {
            this.val$delegate.execute(new AnonymousClass1(this, r10));     // Catch: RejectedExecutionException -> L4
            return;
        L4:
            e = move-exception;
            if (this.thrownFromDelegate == false) goto L11;
            this.val$future.setException(e);
            return;
        }
    }

    @VisibleForTesting
    @GwtIncompatible
    public static class Application {
        public Application() {
        }

        public final void addDelayedShutdownHook(final ExecutorService r10, final long r11, final TimeUnit r12) {
            Preconditions.checkNotNull(r10);
            Preconditions.checkNotNull(r12);
            addShutdownHook(MoreExecutors.newThread("DelayedShutdownHook-for-" + r10, new AnonymousClass1(this, r10, r11, r12)));
        }

        @VisibleForTesting
        public void addShutdownHook(Thread r10) {
            Runtime.getRuntime().addShutdownHook(r10);
        }

        public final ExecutorService getExitingExecutorService(ThreadPoolExecutor r10, long r11, TimeUnit r12) {
            MoreExecutors.access$000(r10);
            ExecutorService r13 = Executors.unconfigurableExecutorService(r10);
            addDelayedShutdownHook(r10, r11, r12);
            return r13;
        }

        public final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor r10, long r11, TimeUnit r12) {
            MoreExecutors.access$000(r10);
            ScheduledExecutorService r13 = Executors.unconfigurableScheduledExecutorService(r10);
            addDelayedShutdownHook(r10, r11, r12);
            return r13;
        }

        public final ExecutorService getExitingExecutorService(ThreadPoolExecutor r10) {
            return getExitingExecutorService(r10, 120, TimeUnit.SECONDS);
        }

        public final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor r10) {
            return getExitingScheduledExecutorService(r10, 120, TimeUnit.SECONDS);
        }
    }

    @GwtIncompatible
    public static final class DirectExecutorService extends AbstractListeningExecutorService {
        private final Object lock;

        @GuardedBy("lock")
        private int runningTasks;

        @GuardedBy("lock")
        private boolean shutdown;

        private DirectExecutorService() {
            this.lock = new Object();
            this.runningTasks = 0;
            this.shutdown = false;
        }

        private void endTask() {
            Object r10 = this.lock;
            monitor-enter(r10);
            int r11 = this.runningTasks - 1;     // Catch: Throwable -> L7
            this.runningTasks = r11;     // Catch: Throwable -> L7
            if (r11 != 0) goto L9;
            this.lock.notifyAll();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void startTask() {
            Object r10 = this.lock;
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.shutdown == true) goto L12;
            this.runningTasks++;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return;
        L12:
            throw new RejectedExecutionException("Executor already shutdown");     // Catch: Throwable -> L9
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long r10, TimeUnit r11) throws InterruptedException {
            long r12 = r11.toNanos(r10);
            Object r13 = this.lock;
            monitor-enter(r13);
        L21:
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.shutdown == false) goto L14;
            if (this.runningTasks != 0) goto L14;
            monitor-exit(r13);     // Catch: Throwable -> L11
            return true;
        L14:
            if (r12 <= 0) goto L15;
            long r14 = System.nanoTime();     // Catch: Throwable -> L11
            TimeUnit.NANOSECONDS.timedWait(this.lock, r12);     // Catch: Throwable -> L11
            r12 = r12 - (System.nanoTime() - r14);     // Catch: Throwable -> L11
            goto L21
        L15:
            monitor-exit(r13);     // Catch: Throwable -> L11
            return false;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r10) {
            startTask();
            r10.run();     // Catch: Throwable -> L6
            endTask();
            return;
        L6:
            th = move-exception;
            endTask();
            throw th;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            Object r10 = this.lock;
            monitor-enter(r10);
            boolean r11 = this.shutdown;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            Object r10 = this.lock;
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.shutdown == true) goto L7;
        L11:
            boolean r11 = false;
        L12:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return r11;
        L7:
            if (this.runningTasks != 0) goto L11;
            r11 = true;
            goto L12
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            Object r10 = this.lock;
            monitor-enter(r10);
            this.shutdown = true;     // Catch: Throwable -> L8
            if (this.runningTasks != 0) goto L10;
            this.lock.notifyAll();     // Catch: Throwable -> L8
        L10:
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            shutdown();
            return Collections.emptyList();
        }

        public /* synthetic */ DirectExecutorService(AnonymousClass1 r10) {
            this();
        }
    }

    @GwtIncompatible
    public static class ListeningDecorator extends AbstractListeningExecutorService {
        private final ExecutorService delegate;

        public ListeningDecorator(ExecutorService r10) {
            this.delegate = (ExecutorService) Preconditions.checkNotNull(r10);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long r10, TimeUnit r11) throws InterruptedException {
            return this.delegate.awaitTermination(r10, r11);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r10) {
            this.delegate.execute(r10);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.delegate.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.delegate.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.delegate.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            return this.delegate.shutdownNow();
        }
    }

    @GwtIncompatible
    public static final class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {
        final ScheduledExecutorService delegate;

        public static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {
            private final ScheduledFuture<?> scheduledDelegate;

            public ListenableScheduledTask(ListenableFuture<V> r10, ScheduledFuture<?> r11) {
                super(r10);
                this.scheduledDelegate = r11;
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean r10) {
                boolean r11 = super.cancel(r10);
                if (r11 == false) goto L5;
                this.scheduledDelegate.cancel(r10);
            L5:
                return r11;
            }

            @Override // java.lang.Comparable
            public /* bridge */ /* synthetic */ int compareTo(Delayed r10) {
                return compareTo2(r10);
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit r10) {
                return this.scheduledDelegate.getDelay(r10);
            }

            /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
            public int compareTo2(Delayed r10) {
                return this.scheduledDelegate.compareTo(r10);
            }
        }

        @GwtIncompatible
        public static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.TrustedFuture<Void> implements Runnable {
            private final Runnable delegate;

            public NeverSuccessfulListenableFutureTask(Runnable r10) {
                this.delegate = (Runnable) Preconditions.checkNotNull(r10);
            }

            @Override // java.lang.Runnable
            public void run() {
                this.delegate.run();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                setException(th);
                throw Throwables.propagate(th);
            }
        }

        public ScheduledListeningDecorator(ScheduledExecutorService r10) {
            super(r10);
            this.delegate = (ScheduledExecutorService) Preconditions.checkNotNull(r10);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable r10, long r11, TimeUnit r12) {
            return schedule(r10, r11, r12);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable r10, long r11, long r12, TimeUnit r13) {
            return scheduleAtFixedRate(r10, r11, r12, r13);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable r10, long r11, long r12, TimeUnit r13) {
            return scheduleWithFixedDelay(r10, r11, r12, r13);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable r10, long r11, TimeUnit r12) {
            return schedule(r10, r11, r12);
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable r10, long r11, long r12, TimeUnit r14) {
            NeverSuccessfulListenableFutureTask r13 = new NeverSuccessfulListenableFutureTask(r10);
            return new ListenableScheduledTask(r13, this.delegate.scheduleAtFixedRate(r13, r11, r12, r14));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable r10, long r11, long r12, TimeUnit r14) {
            NeverSuccessfulListenableFutureTask r13 = new NeverSuccessfulListenableFutureTask(r10);
            return new ListenableScheduledTask(r13, this.delegate.scheduleWithFixedDelay(r13, r11, r12, r14));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> schedule(Runnable r10, long r11, TimeUnit r12) {
            TrustedListenableFutureTask r13 = TrustedListenableFutureTask.create(r10, null);
            return new ListenableScheduledTask(r13, this.delegate.schedule(r13, r11, r12));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public <V> ListenableScheduledFuture<V> schedule(Callable<V> r10, long r11, TimeUnit r12) {
            TrustedListenableFutureTask r13 = TrustedListenableFutureTask.create(r10);
            return new ListenableScheduledTask(r13, this.delegate.schedule(r13, r11, r12));
        }
    }

    private MoreExecutors() {
    }

    public static /* synthetic */ void access$000(ThreadPoolExecutor r10) {
        useDaemonThreadFactory(r10);
    }

    @Beta
    @GwtIncompatible
    public static void addDelayedShutdownHook(ExecutorService r10, long r11, TimeUnit r12) {
        new Application().addDelayedShutdownHook(r10, r11, r12);
    }

    public static Executor directExecutor() {
        return DirectExecutor.INSTANCE;
    }

    @Beta
    @GwtIncompatible
    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor r10, long r11, TimeUnit r12) {
        return new Application().getExitingExecutorService(r10, r11, r12);
    }

    @Beta
    @GwtIncompatible
    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor r10, long r11, TimeUnit r12) {
        return new Application().getExitingScheduledExecutorService(r10, r11, r12);
    }

    @GwtIncompatible
    public static <T> T invokeAnyImpl(ListeningExecutorService r16, Collection<? extends Callable<T>> r17, boolean r18, long r19, TimeUnit r21) throws InterruptedException, ExecutionException, TimeoutException {
        Preconditions.checkNotNull(r16);
        Preconditions.checkNotNull(r21);
        int r10 = r17.size();
        if (r10 <= 0) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11);
        ArrayList r12 = Lists.newArrayListWithCapacity(r10);
        LinkedBlockingQueue r13 = Queues.newLinkedBlockingQueue();
        long r14 = r21.toNanos(r19);
        if (r18 == true) goto L51;
        long r15 = 0;
    L12:
        Iterator<? extends Callable<T>> r20 = r17.iterator();     // Catch: Throwable -> L9
        r12.add(submitAndAddQueueListener(r16, r20.next(), r13));     // Catch: Throwable -> L9
        int r22 = r10 - 1;     // Catch: Throwable -> L9
        int r110 = 1;
        ExecutionException r111 = null;
    L13:
        Future r112 = (Future) r13.poll();     // Catch: Throwable -> L9
        if (r112 != null) goto L17;
        if (r22 <= 0) goto L19;
        r22 = r22 - 1;     // Catch: Throwable -> L9
        r12.add(submitAndAddQueueListener(r16, r20.next(), r13));     // Catch: Throwable -> L9
        r110 = r110 + 1;     // Catch: Throwable -> L9
        goto L17
    L19:
        if (r110 == 0) goto L20;
        if (r18 == false) goto L29;
        r112 = (Future) r13.poll(r14, TimeUnit.NANOSECONDS);     // Catch: Throwable -> L9
        if (r112 == null) goto L28;
        long r113 = System.nanoTime();     // Catch: Throwable -> L9
        r14 = r14 - (r113 - r15);     // Catch: Throwable -> L9
    L18:
        long r23 = r14;
        int r24 = r22;
        if (r112 == null) goto L45;
        r110 = r110 - 1;
        T r25 = (T) r112.get();
    L34:
        Iterator r26 = r12.iterator();
    L36:
        if (r26.hasNext() == false) goto L38;
        ((Future) r26.next()).cancel(true);
        goto L36
    L38:
        return r25;
    L39:
        e = move-exception;
        r111 = new ExecutionException(e);     // Catch: Throwable -> L9
    L43:
        e = move-exception;
        r111 = e;
    L9:
        th = move-exception;
        Iterator r27 = r12.iterator();
    L48:
        if (r27.hasNext() == false) goto L50;
        ((Future) r27.next()).cancel(true);
        goto L48
    L50:
        throw th;
    L45:
        r22 = r24;
        r14 = r23;
        r15 = r113;
        goto L13
    L28:
        throw new TimeoutException();     // Catch: Throwable -> L9
    L29:
        r112 = (Future) r13.take();     // Catch: Throwable -> L9
        goto L17
    L20:
        if (r111 == null) goto L22;
        throw r111;     // Catch: Throwable -> L9
    L22:
        throw new ExecutionException(null);     // Catch: Throwable -> L9
    L17:
        r113 = r15;
        goto L18
    L51:
        r15 = System.nanoTime();     // Catch: Throwable -> L9
        goto L12
    L5:
        r11 = false;
        goto L6
    }

    @GwtIncompatible
    private static boolean isAppEngine() {
        if (System.getProperty("com.google.appengine.runtime.environment") != null) goto L10;
        return false;
    L10:
        if (Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", null).invoke(null, null) == null) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    }

    @GwtIncompatible
    public static ListeningExecutorService listeningDecorator(ExecutorService r10) {
        if ((r10 instanceof ListeningExecutorService) == false) goto L6;
        return (ListeningExecutorService) r10;
    L6:
        if ((r10 instanceof ScheduledExecutorService) == false) goto L9;
        ListeningExecutorService r11 = new ScheduledListeningDecorator((ScheduledExecutorService) r10);
    L11:
        return r11;
    L9:
        r11 = new ListeningDecorator(r10);
        goto L11
    }

    @GwtIncompatible
    public static ListeningExecutorService newDirectExecutorService() {
        return new DirectExecutorService(null);
    }

    @Beta
    @GwtIncompatible
    public static Executor newSequentialExecutor(Executor r10) {
        return new SequentialExecutor(r10);
    }

    @GwtIncompatible
    public static Thread newThread(String r10, Runnable r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Thread r12 = platformThreadFactory().newThread(r11);
        r12.setName(r10);     // Catch: SecurityException -> L5
    L4:
        return r12;
    }

    @Beta
    @GwtIncompatible
    public static ThreadFactory platformThreadFactory() {
        if (isAppEngine() == false) goto L5;
        return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", null).invoke(null, null);
    L10:
        e = move-exception;
        throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
    L8:
        e = move-exception;
        throw Throwables.propagate(e.getCause());
    L5:
        return Executors.defaultThreadFactory();
    }

    public static Executor rejectionPropagatingExecutor(Executor r10, AbstractFuture<?> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        if (r10 != directExecutor()) goto L6;
        return r10;
    L6:
        return new AnonymousClass5(r10, r11);
    }

    @GwtIncompatible
    public static Executor renamingDecorator(final Executor r10, final Supplier<String> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        if (isAppEngine() == false) goto L6;
        return r10;
    L6:
        return new AnonymousClass2(r10, r11);
    }

    @CanIgnoreReturnValue
    @Beta
    @GwtIncompatible
    public static boolean shutdownAndAwaitTermination(ExecutorService r10, long r11, TimeUnit r12) {
        long r13 = r12.toNanos(r11) / 2;
        r10.shutdown();
        TimeUnit r14 = TimeUnit.NANOSECONDS;     // Catch: InterruptedException -> L7
        if (r10.awaitTermination(r13, r14) == true) goto L9;
        r10.shutdownNow();     // Catch: InterruptedException -> L7
        r10.awaitTermination(r13, r14);     // Catch: InterruptedException -> L7
    L9:
        return r10.isTerminated();
    L7:
        Thread.currentThread().interrupt();
        r10.shutdownNow();
        goto L9
    }

    @GwtIncompatible
    private static <T> ListenableFuture<T> submitAndAddQueueListener(ListeningExecutorService r10, Callable<T> r11, final BlockingQueue<Future<T>> r12) {
        final ListenableFuture<T> r13 = r10.submit(r11);
        r13.addListener(new AnonymousClass1(r12, r13), directExecutor());
        return r13;
    }

    @GwtIncompatible
    private static void useDaemonThreadFactory(ThreadPoolExecutor r10) {
        r10.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(r10.getThreadFactory()).build());
    }

    @Beta
    @GwtIncompatible
    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor r10) {
        return new Application().getExitingExecutorService(r10);
    }

    @GwtIncompatible
    public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService r10) {
        if ((r10 instanceof ListeningScheduledExecutorService) == false) goto L6;
        return (ListeningScheduledExecutorService) r10;
    L6:
        return new ScheduledListeningDecorator(r10);
    }

    @Beta
    @GwtIncompatible
    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor r10) {
        return new Application().getExitingScheduledExecutorService(r10);
    }

    @GwtIncompatible
    public static ExecutorService renamingDecorator(final ExecutorService r10, final Supplier<String> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        if (isAppEngine() == false) goto L6;
        return r10;
    L6:
        return new AnonymousClass3(r10, r11);
    }

    @GwtIncompatible
    public static ScheduledExecutorService renamingDecorator(final ScheduledExecutorService r10, final Supplier<String> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        if (isAppEngine() == false) goto L6;
        return r10;
    L6:
        return new AnonymousClass4(r10, r11);
    }
}
