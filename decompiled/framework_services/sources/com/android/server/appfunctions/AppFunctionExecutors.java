package com.android.server.appfunctions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class AppFunctionExecutors {
    public static final ExecutorService LOGGING_THREAD_EXECUTOR = null;
    public static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = null;
    static final int sConcurrency = 0;

    static {
        sConcurrency = Runtime.getRuntime().availableProcessors();
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(sConcurrency, sConcurrency, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("AppFunctionExecutors"));
        LOGGING_THREAD_EXECUTOR = Executors.newSingleThreadExecutor(new NamedThreadFactory("AppFunctionsLoggingExecutors"));
        THREAD_POOL_EXECUTOR.allowCoreThreadTimeOut(true);
    }

    private AppFunctionExecutors() {
    }
}
