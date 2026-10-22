package com.android.internal.chooser.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class Executor {
    private static Executor sInstance;
    private ThreadPoolExecutor mExecutor = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory(this) { // from class: com.android.internal.chooser.utils.Executor.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "share-executor-thread");
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != 5) {
                t.setPriority(5);
            }
            return t;
        }
    });

    public static Executor getInstance() {
        synchronized (Executor.class) {
            if (sInstance == null) {
                sInstance = new Executor();
            }
        }
        return sInstance;
    }

    private Executor() {
        this.mExecutor.allowCoreThreadTimeOut(true);
    }

    Future<?> submit(Runnable task) {
        return this.mExecutor.submit(task);
    }

    public <T> Future<T> submit(Runnable task, T result) {
        return this.mExecutor.submit(task, result);
    }

    public <T> Future<T> submit(Callable<T> task) {
        return this.mExecutor.submit(task);
    }

    public void execute(Runnable command) {
        this.mExecutor.execute(command);
    }
}
