package com.stepos.core.ability.speech;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VadNativeDispatch {
    private static final int THREAD_COUNT = 3;
    private static final ExecutorCoroutineDispatcher dispatcher;
    private static final ExecutorService executor;
    public static final VadNativeDispatch INSTANCE = new VadNativeDispatch();
    private static final AtomicInteger threadIndex = new AtomicInteger(0);

    static {
        ExecutorService executor2 = Executors.newFixedThreadPool(3, new f(3));
        executor = executor2;
        kotlin.jvm.internal.g.e(executor2, "executor");
        dispatcher = ExecutorsKt.from(executor2);
    }

    private VadNativeDispatch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread executor$lambda$1(Runnable runnable) {
        Thread thread = new Thread(runnable, ai.onnxruntime.providers.a.a(threadIndex.incrementAndGet(), "VadNative-"));
        thread.setDaemon(true);
        return thread;
    }

    public final ExecutorCoroutineDispatcher getDispatcher() {
        return dispatcher;
    }
}
