package com.stepos.launcher.assistant.utils;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class Executors {
    public static final LooperExecutor BACKGROUND_ABERRANT_EXECUTOR;
    private static final int KEEP_ALIVE = 1;
    public static final LooperExecutor MAIN_EXECUTOR;
    private static final int POOL_SIZE;
    public static final ThreadPoolExecutor THREAD_POOL_EXECUTOR;
    public static final LooperExecutor UI_HELPER_EXECUTOR;

    public static class SimpleThreadFactory implements ThreadFactory {
        private final AtomicInteger mCount = new AtomicInteger(0);
        private final String mNamePrefix;
        private final int mPriority;

        public SimpleThreadFactory(String str, int i10) {
            this.mNamePrefix = str;
            this.mPriority = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$newThread$0(Runnable runnable) throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(this.mPriority);
            runnable.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable runnable) {
            return new Thread(new Runnable() { // from class: com.stepos.launcher.assistant.utils.a
                @Override // java.lang.Runnable
                public final void run() throws SecurityException, IllegalArgumentException {
                    this.f30168a.lambda$newThread$0(runnable);
                }
            }, this.mNamePrefix + this.mCount.incrementAndGet());
        }
    }

    static {
        int iMax = Math.max(Runtime.getRuntime().availableProcessors(), 2);
        POOL_SIZE = iMax;
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(iMax, iMax, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        MAIN_EXECUTOR = new LooperExecutor(Looper.getMainLooper());
        UI_HELPER_EXECUTOR = new LooperExecutor(createAndStartNewLooper("UiThreadHelper", -2));
        BACKGROUND_ABERRANT_EXECUTOR = new LooperExecutor(createAndStartNewLooper("launcherClient-aberrant-background"));
    }

    public static Looper createAndStartNewLooper(String str) {
        return createAndStartNewLooper(str, 0);
    }

    public static Looper createAndStartNewLooper(String str, int i10) {
        HandlerThread handlerThread = new HandlerThread(str, i10);
        handlerThread.start();
        return handlerThread.getLooper();
    }
}
