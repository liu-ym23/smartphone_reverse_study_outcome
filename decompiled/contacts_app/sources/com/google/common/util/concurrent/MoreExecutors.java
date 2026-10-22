package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class MoreExecutors {

    static class Application {
        Application() {
        }

        final ExecutorService getExitingExecutorService(ThreadPoolExecutor r1, long r2, TimeUnit r4) {
            MoreExecutors.access$000(r1);
            ExecutorService r3 = Executors.unconfigurableExecutorService(r1);
            addDelayedShutdownHook(r3, r2, r4);
            return r3;
        }

        final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor r1, long r2, TimeUnit r4) {
            MoreExecutors.access$000(r1);
            ScheduledExecutorService r3 = Executors.unconfigurableScheduledExecutorService(r1);
            addDelayedShutdownHook(r3, r2, r4);
            return r3;
        }

        final void addDelayedShutdownHook(final ExecutorService r9, final long r10, final TimeUnit r12) {
            Preconditions.checkNotNull(r9);
            Preconditions.checkNotNull(r12);
            addShutdownHook(MoreExecutors.newThread("DelayedShutdownHook-for-" + r9, new AnonymousClass1(this, r9, r10, r12)));
        }

        final ExecutorService getExitingExecutorService(ThreadPoolExecutor r4) {
            return getExitingExecutorService(r4, 120, TimeUnit.SECONDS);
        }

        final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor r4) {
            return getExitingScheduledExecutorService(r4, 120, TimeUnit.SECONDS);
        }

        void addShutdownHook(Thread r1) {
            Runtime.getRuntime().addShutdownHook(r1);
        }
    }

    private static final enum DirectExecutor extends Enum<DirectExecutor> implements Executor {
        private static final /* synthetic */ DirectExecutor[] $VALUES = null;
        public static final DirectExecutor INSTANCE = null;

        private DirectExecutor(String r1, int r2) {
            super(r1, r2);
        }

        public static DirectExecutor valueOf(String r1) {
            return (DirectExecutor) Enum.valueOf(DirectExecutor.class, r1);
        }

        public static DirectExecutor[] values() {
            return (DirectExecutor[]) $VALUES.clone();
        }

        static {
            DirectExecutor r0 = new DirectExecutor("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new DirectExecutor[]{r0};
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r1) {
            r1.run();
        }
    }

    private static class DirectExecutorService extends AbstractListeningExecutorService {
        private final Lock lock;
        private int runningTasks;
        private boolean shutdown;
        private final Condition termination;

        private DirectExecutorService() {
            ReentrantLock r0 = new ReentrantLock();
            this.lock = r0;
            this.termination = r0.newCondition();
            this.runningTasks = 0;
            this.shutdown = false;
        }

        /* synthetic */ DirectExecutorService(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r1) {
            startTask();
            r1.run();     // Catch: Throwable -> L6
            endTask();
            return;
        L6:
            th = move-exception;
            endTask();
            throw th;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            this.lock.lock();
            boolean r0 = this.shutdown;     // Catch: Throwable -> L6
            this.lock.unlock();
            return r0;
        L6:
            th = move-exception;
            this.lock.unlock();
            throw th;
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.lock.lock();
            this.shutdown = true;     // Catch: Throwable -> L6
            this.lock.unlock();
            return;
        L6:
            th = move-exception;
            this.lock.unlock();
            throw th;
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            shutdown();
            return Collections.emptyList();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            this.lock.lock();
        L11:
            th = move-exception;
            this.lock.unlock();
            throw th;
        L4:
            if (this.shutdown == false) goto L8;
            if (this.runningTasks != 0) goto L8;
            boolean r0 = true;
        L9:
            this.lock.unlock();
            return r0;
        L8:
            r0 = false;
            goto L9
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long r3, TimeUnit r5) throws InterruptedException {
            long r4 = r5.toNanos(r3);
            this.lock.lock();
        L16:
        L13:
            th = move-exception;
            this.lock.unlock();
            throw th;
        L4:
            if (isTerminated() == true) goto L5;
            if (r4 <= 0) goto L9;
            r4 = this.termination.awaitNanos(r4);     // Catch: Throwable -> L13
            goto L16
        L9:
            this.lock.unlock();
            return false;
        L5:
            this.lock.unlock();
            return true;
        }

        private void startTask() {
            this.lock.lock();
        L10:
            th = move-exception;
            this.lock.unlock();
            throw th;
        L4:
            if (isShutdown() == true) goto L9;
            this.runningTasks++;     // Catch: Throwable -> L10
            this.lock.unlock();
            return;
        L9:
            throw new RejectedExecutionException("Executor already shutdown");     // Catch: Throwable -> L10
        }

        private void endTask() {
            this.lock.lock();
            this.runningTasks--;     // Catch: Throwable -> L8
            if (isTerminated() == false) goto L6;
            this.termination.signalAll();     // Catch: Throwable -> L8
        L6:
            this.lock.unlock();
            return;
        L8:
            th = move-exception;
            this.lock.unlock();
            throw th;
        }
    }

    private static class ListeningDecorator extends AbstractListeningExecutorService {
        private final ExecutorService delegate;

        ListeningDecorator(ExecutorService r1) {
            this.delegate = (ExecutorService) Preconditions.checkNotNull(r1);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long r1, TimeUnit r3) throws InterruptedException {
            return this.delegate.awaitTermination(r1, r3);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.delegate.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.delegate.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.delegate.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            return this.delegate.shutdownNow();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r1) {
            this.delegate.execute(r1);
        }
    }

    private static class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {
        final ScheduledExecutorService delegate;

        private static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {
            private final ScheduledFuture<?> scheduledDelegate;

            @Override // java.lang.Comparable
            public /* bridge */ /* synthetic */ int compareTo(Delayed r1) {
                return compareTo2(r1);
            }

            public ListenableScheduledTask(ListenableFuture<V> r1, ScheduledFuture<?> r2) {
                super(r1);
                this.scheduledDelegate = r2;
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean r2) {
                boolean r0 = super.cancel(r2);
                if (r0 == false) goto L5;
                this.scheduledDelegate.cancel(r2);
            L5:
                return r0;
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit r1) {
                return this.scheduledDelegate.getDelay(r1);
            }

            /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
            public int compareTo2(Delayed r1) {
                return this.scheduledDelegate.compareTo(r1);
            }
        }

        private static final class NeverSuccessfulListenableFutureTask extends AbstractFuture<Void> implements Runnable {
            private final Runnable delegate;

            public NeverSuccessfulListenableFutureTask(Runnable r1) {
                this.delegate = (Runnable) Preconditions.checkNotNull(r1);
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

        @Override // java.util.concurrent.ScheduledExecutorService
        public /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable r1, long r2, TimeUnit r4) {
            return schedule(r1, r2, r4);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable r1, long r2, TimeUnit r4) {
            return schedule(r1, r2, r4);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable r1, long r2, long r4, TimeUnit r6) {
            return scheduleAtFixedRate(r1, r2, r4, r6);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable r1, long r2, long r4, TimeUnit r6) {
            return scheduleWithFixedDelay(r1, r2, r4, r6);
        }

        ScheduledListeningDecorator(ScheduledExecutorService r1) {
            super(r1);
            this.delegate = (ScheduledExecutorService) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> schedule(Runnable r2, long r3, TimeUnit r5) {
            ListenableFutureTask r4 = ListenableFutureTask.create(r2, null);
            return new ListenableScheduledTask(r4, this.delegate.schedule(r4, r3, r5));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public <V> ListenableScheduledFuture<V> schedule(Callable<V> r1, long r2, TimeUnit r4) {
            ListenableFutureTask r3 = ListenableFutureTask.create(r1);
            return new ListenableScheduledTask(r3, this.delegate.schedule(r3, r2, r4));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable r9, long r10, long r12, TimeUnit r14) {
            NeverSuccessfulListenableFutureTask r7 = new NeverSuccessfulListenableFutureTask(r9);
            return new ListenableScheduledTask(r7, this.delegate.scheduleAtFixedRate(r7, r10, r12, r14));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable r9, long r10, long r12, TimeUnit r14) {
            NeverSuccessfulListenableFutureTask r7 = new NeverSuccessfulListenableFutureTask(r9);
            return new ListenableScheduledTask(r7, this.delegate.scheduleWithFixedDelay(r7, r10, r12, r14));
        }
    }

    static /* synthetic */ void access$000(ThreadPoolExecutor r0) {
        useDaemonThreadFactory(r0);
    }

    private MoreExecutors() {
    }

    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor r1, long r2, TimeUnit r4) {
        return new Application().getExitingExecutorService(r1, r2, r4);
    }

    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor r1, long r2, TimeUnit r4) {
        return new Application().getExitingScheduledExecutorService(r1, r2, r4);
    }

    public static void addDelayedShutdownHook(ExecutorService r1, long r2, TimeUnit r4) {
        new Application().addDelayedShutdownHook(r1, r2, r4);
    }

    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor r1) {
        return new Application().getExitingExecutorService(r1);
    }

    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor r1) {
        return new Application().getExitingScheduledExecutorService(r1);
    }

    private static void useDaemonThreadFactory(ThreadPoolExecutor r2) {
        r2.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(r2.getThreadFactory()).build());
    }

    @Deprecated
    public static ListeningExecutorService sameThreadExecutor() {
        return new DirectExecutorService(null);
    }

    public static ListeningExecutorService newDirectExecutorService() {
        return new DirectExecutorService(null);
    }

    public static Executor directExecutor() {
        return DirectExecutor.INSTANCE;
    }

    public static ListeningExecutorService listeningDecorator(ExecutorService r1) {
        if ((r1 instanceof ListeningExecutorService) == false) goto L6;
        return (ListeningExecutorService) r1;
    L6:
        if ((r1 instanceof ScheduledExecutorService) == false) goto L8;
        ListeningExecutorService r0 = new ScheduledListeningDecorator((ScheduledExecutorService) r1);
    L10:
        return r0;
    L8:
        r0 = new ListeningDecorator(r1);
        goto L10
    }

    public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService r1) {
        if ((r1 instanceof ListeningScheduledExecutorService) == false) goto L6;
        return (ListeningScheduledExecutorService) r1;
    L6:
        return new ScheduledListeningDecorator(r1);
    }

    static <T> T invokeAnyImpl(ListeningExecutorService r16, Collection<? extends Callable<T>> r17, boolean r18, long r19) throws InterruptedException, ExecutionException, TimeoutException {
        Preconditions.checkNotNull(r16);
        int r0 = r17.size();
        if (r0 <= 0) goto L5;
        boolean r3 = true;
    L6:
        Preconditions.checkArgument(r3);
        ArrayList r4 = Lists.newArrayListWithCapacity(r0);
        LinkedBlockingQueue r5 = Queues.newLinkedBlockingQueue();
        if (r18 == true) goto L50;
        long r6 = 0;
    L12:
        Iterator<? extends Callable<T>> r7 = r17.iterator();     // Catch: Throwable -> L9
        r4.add(submitAndAddQueueListener(r16, r7.next(), r5));     // Catch: Throwable -> L9
        int r1 = r0 - 1;     // Catch: Throwable -> L9
        int r11 = 1;
        long r9 = r6;
        ExecutionException r12 = null;
        long r8 = r19;
    L13:
        Future r13 = (Future) r5.poll();     // Catch: Throwable -> L9
        if (r13 != null) goto L28;
        if (r1 <= 0) goto L17;
        r1 = r1 - 1;     // Catch: Throwable -> L9
        r4.add(submitAndAddQueueListener(r16, r7.next(), r5));     // Catch: Throwable -> L9
        r11 = r11 + 1;     // Catch: Throwable -> L9
        goto L28
    L17:
        if (r11 == 0) goto L18;
        if (r18 == false) goto L27;
        r13 = (Future) r5.poll(r8, TimeUnit.NANOSECONDS);     // Catch: Throwable -> L9
        if (r13 == null) goto L26;
        long r14 = System.nanoTime();     // Catch: Throwable -> L9
        r8 = r8 - (r14 - r9);     // Catch: Throwable -> L9
    L29:
        long r10 = r8;
        int r15 = r1;
        if (r13 == null) goto L44;
        r11 = r11 - 1;
        T r2 = (T) r13.get();
    L33:
        Iterator r20 = r4.iterator();
    L35:
        if (r20.hasNext() == false) goto L37;
        ((Future) r20.next()).cancel(true);
        goto L35
    L37:
        return r2;
    L38:
        e = move-exception;
        r12 = new ExecutionException(e);     // Catch: Throwable -> L9
    L42:
        e = move-exception;
        r12 = e;
    L9:
        th = move-exception;
        Iterator r21 = r4.iterator();
    L47:
        if (r21.hasNext() == false) goto L49;
        ((Future) r21.next()).cancel(true);
        goto L47
    L49:
        throw th;
    L44:
        r1 = r15;
        r8 = r10;
        r9 = r14;
        goto L13
    L26:
        throw new TimeoutException();     // Catch: Throwable -> L9
    L27:
        r13 = (Future) r5.take();     // Catch: Throwable -> L9
        goto L28
    L18:
        if (r12 == null) goto L20;
        throw r12;     // Catch: Throwable -> L9
    L20:
        throw new ExecutionException(null);     // Catch: Throwable -> L9
    L28:
        r14 = r9;
        goto L29
    L50:
        r6 = System.nanoTime();     // Catch: Throwable -> L9
        goto L12
    L5:
        r3 = false;
        goto L6
    }

    private static <T> ListenableFuture<T> submitAndAddQueueListener(ListeningExecutorService r0, Callable<T> r1, final BlockingQueue<Future<T>> r2) {
        final ListenableFuture<T> r3 = r0.submit(r1);
        r3.addListener(new AnonymousClass1(r2, r3), directExecutor());
        return r3;
    }

    public static ThreadFactory platformThreadFactory() {
        if (isAppEngine() == false) goto L5;
        return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
    L14:
        e = move-exception;
        throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
    L17:
        e = move-exception;
        throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
    L11:
        e = move-exception;
        throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
    L8:
        e = move-exception;
        throw Throwables.propagate(e.getCause());
    L5:
        return Executors.defaultThreadFactory();
    }

    private static boolean isAppEngine() {
        if (System.getProperty("com.google.appengine.runtime.environment") != null) goto L10;
        return false;
    L10:
        if (Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]) == null) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    }

    static Thread newThread(String r1, Runnable r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        Thread r3 = platformThreadFactory().newThread(r2);
        r3.setName(r1);     // Catch: SecurityException -> L5
    L4:
        return r3;
    }

    static Executor renamingDecorator(final Executor r1, final Supplier<String> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        if (isAppEngine() == false) goto L6;
        return r1;
    L6:
        return new AnonymousClass2(r1, r2);
    }

    static ExecutorService renamingDecorator(final ExecutorService r1, final Supplier<String> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        if (isAppEngine() == false) goto L6;
        return r1;
    L6:
        return new AnonymousClass3(r1, r2);
    }

    static ScheduledExecutorService renamingDecorator(final ScheduledExecutorService r1, final Supplier<String> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        if (isAppEngine() == false) goto L6;
        return r1;
    L6:
        return new AnonymousClass4(r1, r2);
    }

    public static boolean shutdownAndAwaitTermination(ExecutorService r2, long r3, TimeUnit r5) {
        Preconditions.checkNotNull(r5);
        r2.shutdown();
        long r4 = TimeUnit.NANOSECONDS.convert(r3, r5) / 2;     // Catch: InterruptedException -> L7
        if (r2.awaitTermination(r4, TimeUnit.NANOSECONDS) == true) goto L9;
        r2.shutdownNow();     // Catch: InterruptedException -> L7
        r2.awaitTermination(r4, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L7
    L9:
        return r2.isTerminated();
    L7:
        Thread.currentThread().interrupt();
        r2.shutdownNow();
        goto L9
    }
}
