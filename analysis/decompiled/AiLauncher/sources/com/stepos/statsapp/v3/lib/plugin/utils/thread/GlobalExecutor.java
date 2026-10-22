package com.stepos.statsapp.v3.lib.plugin.utils.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class GlobalExecutor {
    private static final int CORE_POOL_SIZE = 1;
    private static final long KEEP_ALIVE_TIME = 0;
    private static final int MAXIMUM_POOL_SIZE = 1;
    private final ThreadPoolExecutor mSingleThreadPool;

    public static class InnerSingleton {
        private static final GlobalExecutor sInstance = new GlobalExecutor();

        private InnerSingleton() {
        }
    }

    public static /* synthetic */ Thread a(Runnable runnable) {
        return new Thread(runnable, "GlobalTask");
    }

    public static void execute(Runnable runnable) {
        getInstance().mSingleThreadPool.execute(runnable);
    }

    public static GlobalExecutor getInstance() {
        return InnerSingleton.sInstance;
    }

    private GlobalExecutor() {
        this.mSingleThreadPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.stepos.statsapp.v3.lib.plugin.utils.thread.a
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return GlobalExecutor.a(runnable);
            }
        });
    }
}
