package com.stepos.core.ability.speech;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsStreamCallbackExecutor {
    private static final int POOL_SIZE = 4;
    private static final String TAG = "TtsStreamCallbackExec";
    public static final TtsStreamCallbackExecutor INSTANCE = new TtsStreamCallbackExecutor();
    private static final AtomicInteger threadIdx = new AtomicInteger();
    private static final ExecutorService executor = Executors.newFixedThreadPool(4, new b0(1));

    private TtsStreamCallbackExecutor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$3(zb.a aVar) {
        Object objA;
        try {
            objA = aVar.invoke();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.ABILITY, TAG, "callback task failed: " + thB.getMessage(), thB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread executor$lambda$1(Runnable runnable) {
        Thread thread = new Thread(runnable, ai.onnxruntime.providers.a.a(threadIdx.incrementAndGet(), "aiengine-tts-callback-"));
        thread.setDaemon(true);
        return thread;
    }

    public final void execute(zb.a<lb.n> block) {
        kotlin.jvm.internal.g.f(block, "block");
        executor.execute(new n(2, block));
    }
}
