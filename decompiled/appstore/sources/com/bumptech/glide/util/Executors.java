package com.bumptech.glide.util;

import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
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

    @VisibleForTesting
    public static void shutdownAndAwaitTermination(ExecutorService r10) {
        r10.shutdownNow();
        TimeUnit r11 = TimeUnit.SECONDS;     // Catch: InterruptedException -> L10
        if (r10.awaitTermination(5, r11) == true) goto L12;
        r10.shutdownNow();     // Catch: InterruptedException -> L10
        if (r10.awaitTermination(5, r11) == false) goto L9;
        return;
    L9:
        throw new RuntimeException("Failed to shutdown");     // Catch: InterruptedException -> L10
    L12:
        return;
    L10:
        e = move-exception;
        r10.shutdownNow();
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
    }
}
