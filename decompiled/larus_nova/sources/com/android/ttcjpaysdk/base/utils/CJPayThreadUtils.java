package com.android.ttcjpaysdk.base.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes3.dex */
public class CJPayThreadUtils {
    private static volatile CJPayThreadUtils instance;
    private volatile HandlerThread mHandlerThread;
    private volatile Handler mainHandler;
    private volatile Handler workerHandler;

    /* JADX INFO: loaded from: classes28.dex */
    public interface SyncCallBack<T> {
        void onUIExecute(T r100);

        T onWorkerExecute();
    }

    public static CJPayThreadUtils getInstance() {
        if (instance != null) goto L15;
        monitor-enter(CJPayThreadUtils.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new CJPayThreadUtils();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CJPayThreadUtils.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private CJPayThreadUtils() {
        this.mHandlerThread = new PthreadHandlerThreadV2("CJPayThreadUtils");
        ThreadMethodProxy.start(this.mHandlerThread);
        this.workerHandler = new Handler(this.mHandlerThread.getLooper());
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ Handler access$000(CJPayThreadUtils r100) {
        return r100.mainHandler;
    }

    public synchronized <T> void runOnWorkSyncUI(final SyncCallBack<T> r100) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.workerHandler == null) goto L6;
        this.workerHandler.post(new AnonymousClass1(this, r100));     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public synchronized void runOnWorkThread(Runnable r100) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.workerHandler == null) goto L6;
        this.workerHandler.post(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public synchronized void runOnWorkThreadDelay(Runnable r100, int r101) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.workerHandler == null) goto L6;
        this.workerHandler.postDelayed(r100, r101);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }
}
