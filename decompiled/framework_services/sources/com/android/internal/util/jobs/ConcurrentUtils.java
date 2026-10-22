package com.android.internal.util.jobs;

import android.util.Slog;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ConcurrentUtils {
    public static final Executor DIRECT_EXECUTOR = null;

    private static class DirectExecutor implements Executor {
        /* synthetic */ DirectExecutor(ConcurrentUtilsIA r1) {
            this();
        }

        private DirectExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            command.run();
        }

        public String toString() {
            return "DIRECT_EXECUTOR";
        }
    }

    private ConcurrentUtils() {
    }

    static {
        DIRECT_EXECUTOR = new DirectExecutor(null);
    }

    public static ExecutorService newFixedThreadPool(int nThreads, final String poolName, final int linuxThreadPriority) {
        return Executors.newFixedThreadPool(nThreads, new AnonymousClass1(poolName, linuxThreadPriority));
    }

    public static <T> T waitForFutureNoInterrupt(Future<T> future, String description) {
        return future.get();
    L4:
        e = move-exception;
        throw new RuntimeException(description + " failed", e);
    L8:
        Thread.currentThread().interrupt();
        throw new IllegalStateException(description + " interrupted");
    }

    public static void waitForCountDownNoInterrupt(CountDownLatch countDownLatch, long timeoutMs, String description) {
        if (countDownLatch.await(timeoutMs, TimeUnit.MILLISECONDS) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(description + " timed out.");     // Catch: InterruptedException -> L7
    L8:
        Thread.currentThread().interrupt();
        throw new IllegalStateException(description + " interrupted.");
    }

    public static void wtfIfLockHeld(String tag, Object lock) {
        if (Thread.holdsLock(lock) == false) goto L6;
        Slog.wtf(tag, "Lock mustn't be held");
        return;
    }

    public static void wtfIfLockNotHeld(String tag, Object lock) {
        if (Thread.holdsLock(lock) == true) goto L6;
        Slog.wtf(tag, "Lock must be held");
        return;
    }
}
