package com.byted.cast.common.threadpool;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes39.dex */
public class CastThreadPoolExecutor extends PThreadPoolExecutor {
    private static final String TAG = null;
    private static final RejectedExecutionHandler mDefaultRejectedHandler = null;

    static {
        TAG = "CastThreadPoolExecutor";
        mDefaultRejectedHandler = new CastDiscardOldestPolicy();
    }

    private void init() {
        if (allowsCoreThreadTimeOut() == true) goto L11;
        TimeUnit r100 = TimeUnit.SECONDS;
        setKeepAliveTime(Math.max(30, getKeepAliveTime(r100)), r100);
    L11:
        allowCoreThreadTimeOut(true);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
    }

    public void clearQueue() {
        if (getQueue() == null) goto L6;
        getQueue().clear();
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean r100) {
        super.allowCoreThreadTimeOut(r100);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r100) {
        super.execute(r100);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable r100, Throwable r101) {
        super.afterExecute(r100, r101);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread r100, Runnable r101) {
        super.beforeExecute(r100, r101);
    }

    public CastThreadPoolExecutor(int r100, int r110, long r111, TimeUnit r112, BlockingQueue<Runnable> r113) {
        this(r100, r110, r111, r112, r113, new CastThreadFactory(TAG));
    }

    public CastThreadPoolExecutor(int r110, int r111, long r112, TimeUnit r113, BlockingQueue<Runnable> r114, RejectedExecutionHandler r115) {
        this(r110, r111, r112, r113, r114, new CastThreadFactory(TAG), r115);
    }

    public CastThreadPoolExecutor(int r110, int r111, long r112, TimeUnit r113, BlockingQueue<Runnable> r114, ThreadFactory r115) {
        this(r110, r111, r112, r113, r114, r115, mDefaultRejectedHandler);
    }

    public CastThreadPoolExecutor(int r100, int r101, long r102, TimeUnit r103, BlockingQueue<Runnable> r104, ThreadFactory r105, RejectedExecutionHandler r106) {
        super(r100, r101, r102, r103, r104, r105, r106);
        init();
    }
}
