package com.stepos.pps.common;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ThreadPool {
    private final ExecutorService mThreadPool;

    private ThreadPool() {
        this.mThreadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory());
    }

    private static class SingletonHolder {
        private static final ThreadPool INSTANCE = new ThreadPool();

        private SingletonHolder() {
        }
    }

    public static ThreadPool getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void execute(Runnable runnable) {
        this.mThreadPool.execute(runnable);
    }

    public Future<?> submit(Runnable runnable) {
        return this.mThreadPool.submit(runnable);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.mThreadPool.submit(callable);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.mThreadPool.submit(runnable, t);
    }

    private static class ThreadFactory implements java.util.concurrent.ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        ThreadFactory() {
            ThreadGroup threadGroup;
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.group = threadGroup;
            this.namePrefix = "pps-pool-" + poolNumber.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }
}
