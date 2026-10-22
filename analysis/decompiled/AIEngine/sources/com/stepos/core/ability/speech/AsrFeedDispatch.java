package com.stepos.core.ability.speech;

import android.os.SystemClock;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrFeedDispatch {
    private static final long IDLE_KEEP_ALIVE_SEC = 60;
    private static final int MAX_SESSIONS = 8;
    private static final int POOL_SIZE = 16;
    private static final int QUEUE_WARN_THRESHOLD = 8;
    private static final String TAG = "AsrFeedDispatch";
    private static final int THREADS_PER_SESSION = 2;
    private static final long WARN_INTERVAL_MS = 10000;
    private static final ExecutorCoroutineDispatcher dispatcher;
    private static final AsrFeedDispatch$executor$1 executor;
    private static final LinkedBlockingQueue<Runnable> queue;
    private static final ThreadFactory threadFactory;
    public static final AsrFeedDispatch INSTANCE = new AsrFeedDispatch();
    private static final AtomicInteger threadIndex = new AtomicInteger(0);
    private static final AtomicLong lastWarnAtMs = new AtomicLong(0);

    static {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        queue = linkedBlockingQueue;
        f fVar = new f(0);
        threadFactory = fVar;
        AsrFeedDispatch$executor$1 asrFeedDispatch$executor$1 = new AsrFeedDispatch$executor$1(TimeUnit.SECONDS, linkedBlockingQueue, fVar);
        asrFeedDispatch$executor$1.allowCoreThreadTimeOut(true);
        executor = asrFeedDispatch$executor$1;
        dispatcher = ExecutorsKt.from((ExecutorService) asrFeedDispatch$executor$1);
    }

    private AsrFeedDispatch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread threadFactory$lambda$1(Runnable runnable) {
        Thread thread = new Thread(runnable, ai.onnxruntime.providers.a.a(threadIndex.incrementAndGet(), "asr-reorder-"));
        thread.setDaemon(true);
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void warnIfBackedUp() {
        int size = queue.size();
        if (size <= 8) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        AtomicLong atomicLong = lastWarnAtMs;
        long j10 = atomicLong.get();
        if (jElapsedRealtime - j10 >= 10000 && atomicLong.compareAndSet(j10, jElapsedRealtime)) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, "reorder dispatch backed up: queued=" + size + " (pool=16, maxSessions=8) — deliver threads blocked downstream, uplink latency will rise");
        }
    }

    public final ExecutorCoroutineDispatcher getDispatcher() {
        return dispatcher;
    }
}
