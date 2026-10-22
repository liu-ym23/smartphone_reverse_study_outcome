package com.bytedance.android.openlive;

import android.os.SystemClock;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0012\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/openlive/AsyncInitHelper;", "", "()V", "MAX_TASK", "", "POOL_NUMBER", "Ljava/util/concurrent/atomic/AtomicInteger;", "TAG", "", "duringInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "semaphore", "Ljava/util/concurrent/Semaphore;", "initStart", "", "postNormalTask", "name", "runnable", "Ljava/lang/Runnable;", "postWaitTask", "waitInitEnd", "timeoutInMs", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AsyncInitHelper {
    public static final AsyncInitHelper INSTANCE = null;
    public static final int MAX_TASK = 1000;
    private static final AtomicInteger POOL_NUMBER = null;
    private static final String TAG = "AsyncInit";
    private static final AtomicBoolean duringInit = null;
    private static final ThreadPoolExecutor executor = null;
    private static final Semaphore semaphore = null;

    private AsyncInitHelper() {
    }

    @JvmStatic
    public static final void waitInitEnd() {
        waitInitEnd$default(0, 1, null);
    }

    static {
        INSTANCE = new AsyncInitHelper();
        semaphore = new Semaphore(1000);
        POOL_NUMBER = new AtomicInteger(1);
        PThreadPoolExecutor r100 = new PThreadPoolExecutor(6, 6, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), AsyncInitHelper$executor$1.INSTANCE);
        r100.allowCoreThreadTimeOut(true);
        executor = r100;
        duringInit = new AtomicBoolean(false);
    }

    @JvmStatic
    public static final void initStart() {
        duringInit.compareAndSet(false, true);
    }

    public static final /* synthetic */ AtomicInteger access$getPOOL_NUMBER$p(AsyncInitHelper r100) {
        return POOL_NUMBER;
    }

    public static final /* synthetic */ Semaphore access$getSemaphore$p(AsyncInitHelper r100) {
        return semaphore;
    }

    @JvmStatic
    public static final void waitInitEnd(long r100) {
        if (duringInit.compareAndSet(true, false) == true) goto L5;
        return;
    L5:
        SystemClock.elapsedRealtime();
        semaphore.tryAcquire(1000, r100, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L9
    L7:
        SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final void postNormalTask(final String r100, final Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "runnable");
        final long r102 = SystemClock.elapsedRealtime();
        executor.submit(new AnonymousClass1(r101, r100, r102));
    }

    @JvmStatic
    public static final void postWaitTask(final String r100, final Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "runnable");
        if (duringInit.get() == true) goto L6;
        r101.run();
        return;
    L6:
        final long r102 = SystemClock.elapsedRealtime();
        semaphore.acquire();     // Catch: InterruptedException -> L10
    L8:
        executor.submit(new RunnableC102531(r101, r100, r102));
    }

    public static /* synthetic */ void waitInitEnd$default(long r100, int r101, Object r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 10000;
    L5:
        waitInitEnd(r100);
    }
}
