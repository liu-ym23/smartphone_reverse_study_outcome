package com.android.server;

import android.os.Build;
import android.os.Process;
import android.util.Dumpable;
import android.util.Slog;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.Preconditions;
import com.android.server.am.StackTracesDumpHelper;
import com.android.server.utils.TimingsTraceAndSlog;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class SystemServerInitThreadPool implements Dumpable {
    private static final boolean IS_DEBUGGABLE = false;
    private static final Object LOCK = null;
    private static final int SHUTDOWN_TIMEOUT_MILLIS = 20000;
    private static final String TAG = null;
    private static SystemServerInitThreadPool sInstance;
    private final List<String> mPendingTasks;
    private final ExecutorService mService;
    private boolean mShutDown;
    private final int mSize;

    public static /* synthetic */ void $r8$lambda$KBkrFsHiqcxWyjNRg1WxRI4WNHA(SystemServerInitThreadPool r0, String r1, Runnable r2) {
        r0.lambda$submitTask$0(r1, r2);
    }

    static {
        TAG = SystemServerInitThreadPool.class.getSimpleName();
        IS_DEBUGGABLE = Build.IS_DEBUGGABLE;
        LOCK = new Object();
    }

    private SystemServerInitThreadPool() {
        this.mPendingTasks = new ArrayList();
        this.mSize = Runtime.getRuntime().availableProcessors();
        Slog.i(TAG, "Creating instance with " + this.mSize + " threads");
        this.mService = ConcurrentUtils.newFixedThreadPool(this.mSize, "system-server-init-thread", -2);
    }

    public static Future<?> submit(Runnable runnable, String description) {
        description.getClass();
        Object r0 = LOCK;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sInstance == null) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1, "Cannot get " + TAG + " - it has been shut down");     // Catch: Throwable -> L12
        SystemServerInitThreadPool instance = sInstance;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return instance.submitTask(runnable, description);
    L7:
        r1 = false;
        goto L8
    }

    private Future<?> submitTask(final Runnable runnable, final String description) {
        List<String> r0 = this.mPendingTasks;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mShutDown == true) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1, TAG + " already shut down");     // Catch: Throwable -> L12
        this.mPendingTasks.add(description);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return this.mService.submit(new SystemServerInitThreadPool$$ExternalSyntheticLambda1(this, description, runnable));
    L7:
        r1 = false;
        goto L8
    }

    private /* synthetic */ void lambda$submitTask$0(String description, Runnable runnable) {
        TimingsTraceAndSlog traceLog = TimingsTraceAndSlog.newAsyncLog();
        traceLog.traceBegin("InitThreadPoolExec:" + description);
        if (IS_DEBUGGABLE == false) goto L21;
        Slog.d(TAG, "Started executing " + description);
    L21:
        runnable.run();     // Catch: RuntimeException -> L18
        List<String> r1 = this.mPendingTasks;
        monitor-enter(r1);
        this.mPendingTasks.remove(description);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        if (IS_DEBUGGABLE == false) goto L13;
        Slog.d(TAG, "Finished executing " + description);
    L13:
        traceLog.traceEnd();
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        Slog.e(TAG, "Failure in " + description + ": " + e, e);
        traceLog.traceEnd();
        throw e;
    }

    static SystemServerInitThreadPool start() {
        Object r0 = LOCK;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1, TAG + " already started");     // Catch: Throwable -> L11
        SystemServerInitThreadPool instance = new SystemServerInitThreadPool();     // Catch: Throwable -> L11
        sInstance = instance;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return instance;
    L7:
        r1 = false;
        goto L8
    }

    static void shutdown() {
        Slog.d(TAG, "Shutdown requested");
        Object r0 = LOCK;
        monitor-enter(r0);
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();     // Catch: Throwable -> L9
        t.traceBegin("WaitInitThreadPoolShutdown");     // Catch: Throwable -> L9
        if (sInstance != null) goto L11;
        t.traceEnd();     // Catch: Throwable -> L9
        Slog.wtf(TAG, "Already shutdown", new Exception());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        List<String> r2 = sInstance.mPendingTasks;     // Catch: Throwable -> L9
        monitor-enter(r2);     // Catch: Throwable -> L9
        sInstance.mShutDown = true;     // Catch: Throwable -> L36
        monitor-exit(r2);     // Catch: Throwable -> L36
        sInstance.mService.shutdown();     // Catch: Throwable -> L9
        boolean terminated = sInstance.mService.awaitTermination(20000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L9 InterruptedException -> L33
        if (terminated == true) goto L19;
        dumpStackTraces();     // Catch: Throwable -> L9
    L19:
        List<Runnable> unstartedRunnables = sInstance.mService.shutdownNow();     // Catch: Throwable -> L9
        if (terminated == false) goto L24;
        sInstance = null;     // Catch: Throwable -> L9
        Slog.d(TAG, "Shutdown successful");     // Catch: Throwable -> L9
        t.traceEnd();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L24:
        List<String> copy = new ArrayList();     // Catch: Throwable -> L9
        List<String> r5 = sInstance.mPendingTasks;     // Catch: Throwable -> L9
        monitor-enter(r5);     // Catch: Throwable -> L9
        copy.addAll(sInstance.mPendingTasks);     // Catch: Throwable -> L30
        monitor-exit(r5);     // Catch: Throwable -> L30
        t.traceEnd();     // Catch: Throwable -> L9
        throw new IllegalStateException("Cannot shutdown. Unstarted tasks " + unstartedRunnables + " Unfinished tasks " + copy);     // Catch: Throwable -> L9
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L34:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L9
        dumpStackTraces();     // Catch: Throwable -> L9
        t.traceEnd();     // Catch: Throwable -> L9
        throw new IllegalStateException(TAG + " init interrupted");     // Catch: Throwable -> L9
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private static void dumpStackTraces() {
        ArrayList<Integer> pids = new ArrayList();
        pids.add(Integer.valueOf(Process.myPid()));
        StackTracesDumpHelper.dumpStackTraces(pids, null, null, CompletableFuture.completedFuture(Watchdog.getInterestingNativePids()), null, null, null, null, new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), null);
    }

    @Override // android.util.Dumpable
    public String getDumpableName() {
        return SystemServerInitThreadPool.class.getSimpleName();
    }

    @Override // android.util.Dumpable
    public void dump(PrintWriter pw, String[] args) {
        Object r0 = LOCK;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (sInstance == null) goto L7;
        boolean r2 = true;
    L8:
        pw.printf("has instance: %b\n", new Object[]{Boolean.valueOf(r2)});     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        pw.printf("number of threads: %d\n", new Object[]{Integer.valueOf(this.mSize)});
        pw.printf("service: %s\n", new Object[]{this.mService});
        List<String> r1 = this.mPendingTasks;
        monitor-enter(r1);
        pw.printf("is shutdown: %b\n", new Object[]{Boolean.valueOf(this.mShutDown)});     // Catch: Throwable -> L15
        int pendingTasks = this.mPendingTasks.size();     // Catch: Throwable -> L15
        if (pendingTasks != 0) goto L17;
        pw.println("no pending tasks");     // Catch: Throwable -> L15
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L17:
        pw.printf("%d pending tasks: %s\n", new Object[]{Integer.valueOf(pendingTasks), this.mPendingTasks});     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L7:
        r2 = false;
        goto L8
    }
}
