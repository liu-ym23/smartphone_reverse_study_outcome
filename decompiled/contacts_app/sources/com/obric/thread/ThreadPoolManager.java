package com.obric.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThreadPoolManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u00101\u001a\u0002002\u0006\u00102\u001a\u000203H\u0002J\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u000205R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010*\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\u001a\u0004\b\u0016\u0010\u0010*\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\u001a\u0004\b\u001a\u0010\u0010*\u0004\b\u0019\u0010\u000eR\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8FX\u0086\u0084\u0002¢\u0006\f\u001a\u0004\b#\u0010$*\u0004\b\"\u0010\u000eR\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\u001a\u0004\b)\u0010\u0010*\u0004\b(\u0010\u000eR\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\u001a\u0004\b-\u0010\u0010*\u0004\b,\u0010\u000eR\u001c\u0010.\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\f0\f0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/obric/thread/ThreadPoolManager;", "", "()V", "CORE_POOL_SIZE", "", "CPU_COUNT", "KEEP_ALIVE_TIME", "", "KEEP_ALIVE_TIME_15", "MAX_POOL_SIZE", "WORK_QUEUE_CAPACITY", "backgroundExecutor", "Ljava/util/concurrent/ExecutorService;", "getBackgroundExecutor$delegate", "(Lcom/obric/thread/ThreadPoolManager;)Ljava/lang/Object;", "getBackgroundExecutor", "()Ljava/util/concurrent/ExecutorService;", "backgroundExecutorDelegate", "Lcom/obric/thread/InitSafeLazy;", "Ljava/util/concurrent/ThreadPoolExecutor;", "ioExecutor", "getIoExecutor$delegate", "getIoExecutor", "ioExecutorDelegate", "parallelExecutor", "getParallelExecutor$delegate", "getParallelExecutor", "parallelExecutorDelegate", "Ljava/util/concurrent/ForkJoinPool;", "kotlin.jvm.PlatformType", "rejectedExecutionHandler", "Ljava/util/concurrent/RejectedExecutionHandler;", "scheduledExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "getScheduledExecutor$delegate", "getScheduledExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "scheduledExecutorDelegate", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "serialExecutor", "getSerialExecutor$delegate", "getSerialExecutor", "serialExecutorDelegate", "singleThreadExecutor", "getSingleThreadExecutor$delegate", "getSingleThreadExecutor", "singleThreadExecutorDelegate", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "createNamedThreadFactory", "prefix", "", "shutdownAll", "", "shutdownNowAll", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ThreadPoolManager {
    private static final int CORE_POOL_SIZE = 0;
    private static final int CPU_COUNT = 0;
    public static final ThreadPoolManager INSTANCE = null;
    private static final long KEEP_ALIVE_TIME = 60;
    private static final long KEEP_ALIVE_TIME_15 = 15;
    private static final int MAX_POOL_SIZE = 0;
    private static final int WORK_QUEUE_CAPACITY = 128;
    private static final InitSafeLazy<ThreadPoolExecutor> backgroundExecutorDelegate = null;
    private static final InitSafeLazy<ThreadPoolExecutor> ioExecutorDelegate = null;
    private static final InitSafeLazy<ForkJoinPool> parallelExecutorDelegate = null;
    private static final RejectedExecutionHandler rejectedExecutionHandler = null;
    private static final InitSafeLazy<ScheduledThreadPoolExecutor> scheduledExecutorDelegate = null;
    private static final InitSafeLazy<ThreadPoolExecutor> serialExecutorDelegate = null;
    private static final InitSafeLazy<ExecutorService> singleThreadExecutorDelegate = null;
    private static final ThreadFactory threadFactory = null;

    public static /* synthetic */ void $r8$lambda$Ug_xOJjY5huTBXllFtONnCAnwdc(Runnable r0, ThreadPoolExecutor r1) {
        rejectedExecutionHandler$lambda$4(r0, r1);
    }

    public static /* synthetic */ Thread $r8$lambda$ma0LIuiL4nLoEmVjC8xDpWI3BEQ(String r0, Runnable r1) {
        return createNamedThreadFactory$lambda$3(r0, r1);
    }

    public static /* synthetic */ Thread $r8$lambda$nmYYtbD0y_ooFxilPxjvHbxk2G8(Runnable r0) {
        return threadFactory$lambda$1(r0);
    }

    private ThreadPoolManager() {
    }

    public static final /* synthetic */ ThreadFactory access$createNamedThreadFactory(ThreadPoolManager r0, String r1) {
        return r0.createNamedThreadFactory(r1);
    }

    public static final /* synthetic */ int access$getMAX_POOL_SIZE$p() {
        return MAX_POOL_SIZE;
    }

    public static final /* synthetic */ RejectedExecutionHandler access$getRejectedExecutionHandler$p() {
        return rejectedExecutionHandler;
    }

    public static final /* synthetic */ ThreadFactory access$getThreadFactory$p() {
        return threadFactory;
    }

    static {
        INSTANCE = new ThreadPoolManager();
        int r0 = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = r0;
        CORE_POOL_SIZE = r0 + 1;
        MAX_POOL_SIZE = (r0 * 2) + 1;
        threadFactory = new ThreadPoolManager$$ExternalSyntheticLambda0();
        rejectedExecutionHandler = new ThreadPoolManager$$ExternalSyntheticLambda1();
        ioExecutorDelegate = InitSafeLazyKt.initSafeLazy(ThreadPoolManager$ioExecutorDelegate$1.INSTANCE);
        backgroundExecutorDelegate = InitSafeLazyKt.initSafeLazy(ThreadPoolManager$backgroundExecutorDelegate$1.INSTANCE);
        serialExecutorDelegate = InitSafeLazyKt.initSafeLazy(ThreadPoolManager$serialExecutorDelegate$1.INSTANCE);
        scheduledExecutorDelegate = InitSafeLazyKt.initSafeLazy(ThreadPoolManager$scheduledExecutorDelegate$1.INSTANCE);
        singleThreadExecutorDelegate = InitSafeLazyKt.initSafeLazy(ThreadPoolManager$singleThreadExecutorDelegate$1.INSTANCE);
        parallelExecutorDelegate = InitSafeLazyKt.initSafeLazy(ThreadPoolManager$parallelExecutorDelegate$1.INSTANCE);
    }

    private static final Thread threadFactory$lambda$1(Runnable r3) {
        Thread r0 = new Thread(r3, "Obric-Thread-" + new AtomicInteger().incrementAndGet());
        r0.setPriority(5);
        return r0;
    }

    private final ThreadFactory createNamedThreadFactory(final String r1) {
        return new ThreadPoolManager$$ExternalSyntheticLambda2(r1);
    }

    private static final Thread createNamedThreadFactory$lambda$3(String r2, Runnable r3) {
        Intrinsics.checkNotNullParameter(r2, "$prefix");
        Thread r0 = new Thread(r3, r2 + '-' + new AtomicInteger().incrementAndGet());
        r0.setPriority(5);
        return r0;
    }

    private static final void rejectedExecutionHandler$lambda$4(Runnable r2, ThreadPoolExecutor r3) {
        System.err.println("ThreadPoolManager: Task rejected - " + r2.getClass().getSimpleName());
    }

    private static Object getIoExecutor$delegate(ThreadPoolManager r0) {
        return ioExecutorDelegate;
    }

    public final ExecutorService getIoExecutor() {
        return ioExecutorDelegate.getValue();
    }

    private static Object getBackgroundExecutor$delegate(ThreadPoolManager r0) {
        return backgroundExecutorDelegate;
    }

    public final ExecutorService getBackgroundExecutor() {
        return backgroundExecutorDelegate.getValue();
    }

    private static Object getSerialExecutor$delegate(ThreadPoolManager r0) {
        return serialExecutorDelegate;
    }

    public final ExecutorService getSerialExecutor() {
        return serialExecutorDelegate.getValue();
    }

    private static Object getScheduledExecutor$delegate(ThreadPoolManager r0) {
        return scheduledExecutorDelegate;
    }

    public final ScheduledExecutorService getScheduledExecutor() {
        return scheduledExecutorDelegate.getValue();
    }

    private static Object getSingleThreadExecutor$delegate(ThreadPoolManager r0) {
        return singleThreadExecutorDelegate;
    }

    public final ExecutorService getSingleThreadExecutor() {
        ExecutorService r1 = singleThreadExecutorDelegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-singleThreadExecutor>(...)");
        return r1;
    }

    private static Object getParallelExecutor$delegate(ThreadPoolManager r0) {
        return parallelExecutorDelegate;
    }

    public final ExecutorService getParallelExecutor() {
        ForkJoinPool r1 = parallelExecutorDelegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-parallelExecutor>(...)");
        return r1;
    }

    public final void shutdownAll() {
        if (ioExecutorDelegate.isInitialized() == false) goto L6;
        getIoExecutor().shutdown();
    L6:
        if (backgroundExecutorDelegate.isInitialized() == false) goto L9;
        getBackgroundExecutor().shutdown();
    L9:
        if (scheduledExecutorDelegate.isInitialized() == false) goto L12;
        getScheduledExecutor().shutdown();
    L12:
        if (singleThreadExecutorDelegate.isInitialized() == false) goto L15;
        getSingleThreadExecutor().shutdown();
    L15:
        if (serialExecutorDelegate.isInitialized() == false) goto L18;
        getSerialExecutor().shutdown();
        return;
    }

    public final void shutdownNowAll() {
        if (ioExecutorDelegate.isInitialized() == false) goto L6;
        getIoExecutor().shutdownNow();
    L6:
        if (backgroundExecutorDelegate.isInitialized() == false) goto L9;
        getBackgroundExecutor().shutdownNow();
    L9:
        if (scheduledExecutorDelegate.isInitialized() == false) goto L12;
        getScheduledExecutor().shutdownNow();
    L12:
        if (singleThreadExecutorDelegate.isInitialized() == false) goto L15;
        getSingleThreadExecutor().shutdownNow();
    L15:
        if (serialExecutorDelegate.isInitialized() == false) goto L18;
        getSerialExecutor().shutdownNow();
        return;
    }
}
