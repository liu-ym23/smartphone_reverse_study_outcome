package com.stepos.alphame.utils;

import android.os.Process;
import android.util.Log;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.listener.Future;
import com.stepos.alphame.listener.FutureListener;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ThreadPool {
    private static final int CORE_POOL_SIZE = 4;
    private static final int KEEP_ALIVE_TIME = 12;
    private static final int MAX_POOL_SIZE = 8;
    private final Executor mExecutor;

    public interface Job<T> {
        T run();
    }

    public class PriorityThreadFactory implements ThreadFactory {
        private final String mName;
        private final AtomicInteger mNumber = new AtomicInteger();
        private final int mPriority;

        public PriorityThreadFactory(String str, int i4) {
            this.mName = str;
            this.mPriority = i4;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.mName + CoreConstants.DASH_CHAR + this.mNumber.getAndIncrement()) { // from class: com.stepos.alphame.utils.ThreadPool.PriorityThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws SecurityException, IllegalArgumentException {
                    Process.setThreadPriority(PriorityThreadFactory.this.mPriority);
                    super.run();
                }
            };
        }
    }

    public static class ThreadPoolInstance {
        private static final ThreadPool INSTANCE = new ThreadPool(0);

        private ThreadPoolInstance() {
        }
    }

    public class Worker<T> implements Runnable, Future<T> {
        private static final String TAG = "Worker";
        private boolean mIsDone;
        private Job<T> mJob;
        private FutureListener<T> mListener;
        private T mResult;

        public Worker(Job<T> job, FutureListener<T> futureListener) {
            this.mJob = job;
            this.mListener = futureListener;
        }

        @Override // com.stepos.alphame.listener.Future
        public synchronized T get() {
            while (!this.mIsDone) {
                try {
                    wait();
                } catch (Exception e4) {
                    Log.w(TAG, "ingore exception", e4);
                }
            }
            return this.mResult;
        }

        @Override // com.stepos.alphame.listener.Future
        public synchronized boolean isDone() {
            return this.mIsDone;
        }

        @Override // java.lang.Runnable
        public void run() {
            T tRun;
            try {
                tRun = this.mJob.run();
            } catch (Throwable th) {
                Log.w(TAG, "Exception in running a job", th);
                tRun = null;
            }
            synchronized (this) {
                this.mResult = tRun;
                this.mIsDone = true;
                notifyAll();
            }
            FutureListener<T> futureListener = this.mListener;
            if (futureListener != null) {
                futureListener.onFutureDone(this);
            }
        }

        @Override // com.stepos.alphame.listener.Future
        public void waitDone() {
            get();
        }
    }

    public /* synthetic */ ThreadPool(int i4) {
        this();
    }

    public static ThreadPool getInstance() {
        return ThreadPoolInstance.INSTANCE;
    }

    public <T> Future<T> submit(Job<T> job, FutureListener<T> futureListener, boolean z4) {
        return z4 ? submitSync(job, futureListener) : submit(job, futureListener);
    }

    public <T> Future<T> submitSync(Job<T> job, FutureListener<T> futureListener) {
        Worker worker = new Worker(job, futureListener);
        worker.mResult = job.run();
        worker.mIsDone = true;
        if (futureListener != null) {
            futureListener.onFutureDone(worker);
        }
        return worker;
    }

    private ThreadPool() {
        this.mExecutor = new ThreadPoolExecutor(4, 8, 12L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory("thread-pool", 10));
    }

    public <T> Future<T> submit(Job<T> job, FutureListener<T> futureListener) {
        Worker worker = new Worker(job, futureListener);
        this.mExecutor.execute(worker);
        return worker;
    }

    public <T> Future<T> submit(Job<T> job) {
        return submit(job, null);
    }
}
