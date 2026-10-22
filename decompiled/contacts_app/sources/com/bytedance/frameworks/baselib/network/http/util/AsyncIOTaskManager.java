package com.bytedance.frameworks.baselib.network.http.util;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class AsyncIOTaskManager {
    private static final String TAG = "AsyncIOTaskManager";
    private static AsyncIOTaskManager sInstance;
    private ConcurrentHashMap<AsyncTask, ScheduledFuture> mFutureTasks;
    private ConcurrentHashMap<AsyncTask, Runnable> mRunnableTasks;
    private ScheduledThreadPoolExecutor mTaskExecutor;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.util.AsyncIOTaskManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class InnerRunnable implements Runnable {
        private AsyncTask task;
        final /* synthetic */ AsyncIOTaskManager this$0;

        /* synthetic */ InnerRunnable(AsyncIOTaskManager r1, AsyncTask r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private InnerRunnable(AsyncIOTaskManager r1, AsyncTask r2) {
            this.this$0 = r1;
            this.task = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long r2 = System.currentTimeMillis();     // Catch: Throwable -> L9
            this.task.run();     // Catch: Throwable -> L9
            if (Logger.debug() == false) goto L7;
            Logger.d(AsyncIOTaskManager.access$100(), "Task execute time: " + (System.currentTimeMillis() - r2));     // Catch: Throwable -> L9
        L7:
            if (this.task.isLoop() == true) goto L14;
        L8:
            AsyncIOTaskManager.access$200(this.this$0).remove(this.task);
            AsyncIOTaskManager.access$300(this.this$0).remove(this.task);
            return;
        L14:
            return;
        L9:
            th = move-exception;
            Logger.e(AsyncIOTaskManager.access$100(), "thread " + Thread.currentThread().getName() + " exception", th);     // Catch: Throwable -> L15
            if (this.task.isLoop() == false) goto L8;
            return;
        L15:
            th = move-exception;
            if (this.task.isLoop() == true) goto L19;
            AsyncIOTaskManager.access$200(this.this$0).remove(this.task);
            AsyncIOTaskManager.access$300(this.this$0).remove(this.task);
        L19:
            throw th;
        }
    }

    static {
    }

    static /* synthetic */ String access$100() {
        return TAG;
    }

    static /* synthetic */ ConcurrentHashMap access$200(AsyncIOTaskManager r0) {
        return r0.mFutureTasks;
    }

    static /* synthetic */ ConcurrentHashMap access$300(AsyncIOTaskManager r0) {
        return r0.mRunnableTasks;
    }

    private AsyncIOTaskManager() {
        this.mFutureTasks = new ConcurrentHashMap();
        this.mRunnableTasks = new ConcurrentHashMap();
        ScheduledThreadPoolExecutor r0 = new ScheduledThreadPoolExecutor(1, new ThreadFactory("ttnet-io"));
        this.mTaskExecutor = r0;
        r0.setRemoveOnCancelPolicy(true);
    }

    public static AsyncIOTaskManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(AsyncIOTaskManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new AsyncIOTaskManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AsyncIOTaskManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void postTask(AsyncTask r9) {
        if (r9 != null) goto L13;
        return;
    L13:
        InnerRunnable r7 = new InnerRunnable(this, r9, null);     // Catch: Throwable -> L10
        if (r9.isLoop() == false) goto L7;
        ScheduledFuture<?> r0 = this.mTaskExecutor.scheduleWithFixedDelay(r7, r9.getInitialDelay(), r9.getLoopInterval(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L8:
        this.mRunnableTasks.put(r9, r7);     // Catch: Throwable -> L10
        this.mFutureTasks.put(r9, r0);     // Catch: Throwable -> L10
        return;
    L7:
        r0 = this.mTaskExecutor.schedule(r7, r9.getInitialDelay(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.e(TAG, "sendTask failed.", th);
    }

    public void removeTask(AsyncTask r3) {
        this.mTaskExecutor.remove(this.mRunnableTasks.remove(r3));     // Catch: Throwable -> L6
        ScheduledFuture r2 = this.mFutureTasks.remove(r3);     // Catch: Throwable -> L6
        if (r2 == null) goto L11;
        r2.cancel(true);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        Logger.e(TAG, "removeTask failed", th);
    }

    public void removeTaskById(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L24;
        return;
    L24:
        Iterator<Map.Entry<AsyncTask, Runnable>> r0 = this.mRunnableTasks.entrySet().iterator();     // Catch: Throwable -> L21
    L7:
        if (r0.hasNext() == false) goto L11;
        AsyncTask r1 = r0.next().getKey();     // Catch: Throwable -> L21
        if (r4.equals(r1.getTaskIdentifier()) == false) goto L7;
        r0.remove();     // Catch: Throwable -> L21
        this.mTaskExecutor.remove(r1);     // Catch: Throwable -> L21
        goto L7
    L11:
        Iterator<Map.Entry<AsyncTask, ScheduledFuture>> r3 = this.mFutureTasks.entrySet().iterator();     // Catch: Throwable -> L21
    L12:
        if (r3.hasNext() == false) goto L36;
        Map.Entry<AsyncTask, ScheduledFuture> r2 = r3.next();     // Catch: Throwable -> L21
        if (r4.equals(r2.getKey().getTaskIdentifier()) == false) goto L12;
        ScheduledFuture r5 = r2.getValue();     // Catch: Throwable -> L21
        if (r5 == null) goto L19;
        r5.cancel(true);     // Catch: Throwable -> L21
    L19:
        r3.remove();     // Catch: Throwable -> L21
        goto L12
    L36:
        return;
    L21:
        th = move-exception;
        Logger.e(TAG, "removeTask failed", th);
    }
}
