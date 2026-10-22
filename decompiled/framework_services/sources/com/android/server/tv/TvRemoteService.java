package com.android.server.tv;

import android.content.Context;
import com.android.server.SystemService;
import com.android.server.Watchdog;

/* JADX INFO: loaded from: classes3.dex */
public class TvRemoteService extends SystemService implements Watchdog.Monitor {
    private static final boolean DEBUG = false;
    private static final String TAG = "TvRemoteService";
    private final Object mLock;
    private final TvRemoteProviderWatcher mWatcher;

    public TvRemoteService(Context context) {
        super(context);
        this.mLock = new Object();
        this.mWatcher = new TvRemoteProviderWatcher(context, this.mLock);
        Watchdog.getInstance().addMonitor(this);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
    }

    @Override // com.android.server.Watchdog.Monitor
    public void monitor() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 600) goto L6;
        this.mWatcher.start();
        return;
    }
}
