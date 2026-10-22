package com.android.ttcjpaysdk.base.weboffline;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayWebOfflineManager {
    private static CJPayWebOfflineManager instance;
    private Handler mWorkHandler;

    public static CJPayWebOfflineManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(CJPayWebOfflineManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new CJPayWebOfflineManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CJPayWebOfflineManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private CJPayWebOfflineManager() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("CJPayWebOfflineManager");
        ThreadMethodProxy.start(r100);
        this.mWorkHandler = new Handler(r100.getLooper());
    }

    public Handler getWorkHandler() {
        return this.mWorkHandler;
    }
}
