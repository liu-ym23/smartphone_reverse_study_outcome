package com.bytedance.android.livesdkapi.player;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes12.dex */
public class PlayerSingleHandler {
    private static volatile PlayerSingleHandler instance;
    private Handler mHandler;
    private HandlerThread mHandlerThread;

    public static class PlayerSingleHandlerThread extends PthreadHandlerThreadV2 {
        private static final String THREAD_NAME = "player-single-handler-thread";

        public PlayerSingleHandlerThread() {
            super(THREAD_NAME);
        }
    }

    private PlayerSingleHandler() {
    }

    private void init() {
        PlayerSingleHandlerThread r100 = new PlayerSingleHandlerThread();
        this.mHandlerThread = r100;
        ThreadMethodProxy.start(r100);
        Looper r101 = this.mHandlerThread.getLooper();
        if (r101 == null) goto L6;
        this.mHandler = new Handler(r101);
        return;
    }

    public static synchronized PlayerSingleHandler inst() {
        monitor-enter(PlayerSingleHandler.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (instance != null) goto L9;
        instance = new PlayerSingleHandler();     // Catch: Throwable -> L12
        instance.init();     // Catch: Throwable -> L12
        PlayerSingleHandler r100 = instance;     // Catch: Throwable -> L12
        monitor-exit(PlayerSingleHandler.class);
        return r100;
    L9:
        PlayerSingleHandler r101 = instance;     // Catch: Throwable -> L12
        monitor-exit(PlayerSingleHandler.class);
        return r101;
    }

    public void doSingle(Runnable r100, long r101) {
        Handler r102 = this.mHandler;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.postDelayed(r100, r101);
    }
}
