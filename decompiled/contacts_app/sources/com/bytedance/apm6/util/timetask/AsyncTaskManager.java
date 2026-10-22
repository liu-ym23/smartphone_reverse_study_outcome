package com.bytedance.apm6.util.timetask;

import com.bytedance.apm6.util.TraceUtils;
import com.bytedance.apm6.util.log.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class AsyncTaskManager {
    private static Map<AsyncTaskManagerType, AsyncTaskManager> map;
    private ConcurrentHashMap<AsyncTask, ScheduledFuture> futureTasks;
    private ConcurrentHashMap<AsyncTask, Runnable> runnableTasks;
    private ScheduledThreadPoolExecutor taskExecutor;

    /* JADX INFO: renamed from: com.bytedance.apm6.util.timetask.AsyncTaskManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class InnerRunnable implements Runnable {
        private AsyncTask task;
        final /* synthetic */ AsyncTaskManager this$0;

        /* synthetic */ InnerRunnable(AsyncTaskManager r1, AsyncTask r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private InnerRunnable(AsyncTaskManager r1, AsyncTask r2) {
            this.this$0 = r1;
            this.task = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            TraceUtils.beginSection("APM-Task");
            this.task.run();     // Catch: Throwable -> L5
        L7:
            TraceUtils.endSection();
            return;
        L5:
            th = move-exception;
            Logger.e(Constant.TAG, "thread " + Thread.currentThread().getName() + " exception", th);
            goto L7
        }
    }

    static {
        map = new HashMap();
    }

    private AsyncTaskManager(String r3) {
        this.futureTasks = new ConcurrentHashMap();
        this.runnableTasks = new ConcurrentHashMap();
        this.taskExecutor = new ScheduledThreadPoolExecutor(1, new SingleThreadFactory(r3));
    }

    public static synchronized AsyncTaskManager getInstance(AsyncTaskManagerType r3) {
        monitor-enter(AsyncTaskManager.class);
        if (r3 == null) goto L13;
        AsyncTaskManager r1 = map.get(r3);     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        r1 = new AsyncTaskManager(r3.name());     // Catch: Throwable -> L10
        map.put(r3, r1);     // Catch: Throwable -> L10
    L8:
        monitor-exit(AsyncTaskManager.class);
        return r1;
    L13:
        throw new IllegalArgumentException("AsyncTaskManagerType must be not null!");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void sendTask(AsyncTask r9) {
        if (r9 != null) goto L13;
        return;
    L13:
        InnerRunnable r7 = new InnerRunnable(this, r9, null);     // Catch: Throwable -> L10
        if (r9.isLoop() == false) goto L7;
        ScheduledFuture<?> r0 = this.taskExecutor.scheduleWithFixedDelay(r7, r9.getInitialDelay(), r9.getLoopInterval(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L8:
        this.runnableTasks.put(r9, r7);     // Catch: Throwable -> L10
        this.futureTasks.put(r9, r0);     // Catch: Throwable -> L10
        return;
    L7:
        r0 = this.taskExecutor.schedule(r7, r9.getInitialDelay(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.e(Constant.TAG, "sendTask failed.", th);
    }

    public void removeTask(AsyncTask r3) {
        Runnable r0 = this.runnableTasks.remove(r3);     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        this.taskExecutor.remove(r0);     // Catch: Throwable -> L9
    L5:
        ScheduledFuture r2 = this.futureTasks.remove(r3);     // Catch: Throwable -> L9
        if (r2 == null) goto L14;
        r2.cancel(true);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        Logger.e(Constant.TAG, "removeTask failed", th);
    }
}
