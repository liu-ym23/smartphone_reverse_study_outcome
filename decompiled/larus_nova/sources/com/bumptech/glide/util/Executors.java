package com.bumptech.glide.util;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes39.dex */
public final class Executors {
    private static final Executor DIRECT_EXECUTOR = null;
    private static final Executor MAIN_THREAD_EXECUTOR = null;

    static {
        MAIN_THREAD_EXECUTOR = new AnonymousClass1();
        DIRECT_EXECUTOR = new AnonymousClass2();
    }

    private Executors() {
    }

    public static Executor directExecutor() {
        return DIRECT_EXECUTOR;
    }

    public static Executor mainThreadExecutor() {
        return MAIN_THREAD_EXECUTOR;
    }

    public static void shutdownAndAwaitTermination(ExecutorService r100) {
        r100.shutdownNow();
        TimeUnit r101 = TimeUnit.SECONDS;     // Catch: InterruptedException -> L11
        if (r100.awaitTermination(5, r101) == true) goto L10;
        r100.shutdownNow();     // Catch: InterruptedException -> L11
        if (r100.awaitTermination(5, r101) == false) goto L9;
        return;
    L9:
        throw new RuntimeException("Failed to shutdown");     // Catch: InterruptedException -> L11
    L10:
        return;
    L11:
        e = move-exception;
        r100.shutdownNow();
        ThreadMethodProxy.currentThread().interrupt();
        throw new RuntimeException(e);
    }
}
