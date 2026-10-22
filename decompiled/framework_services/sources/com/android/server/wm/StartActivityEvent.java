package com.android.server.wm;

import android.util.Slog;
import com.android.server.am.IApplicationFreezer;

/* JADX INFO: compiled from: FrozenPendingEvent.java */
/* JADX INFO: loaded from: classes3.dex */
class StartActivityEvent extends FrozenPendingEvent {
    private final Runnable runnable;

    StartActivityEvent(WindowProcessController app, Runnable runnable) {
        super(app);
        this.runnable = runnable;
        this.unfreezeReason = IApplicationFreezer.UnfreezeReason.NEED_START_ACTIVITY;
    }

    @Override // com.android.server.wm.FrozenPendingEvent
    Exception handle() {
        Slog.w("AMS.Freeze", "StartActivityEvent handle pendingEvent, app " + this.mApp);     // Catch: Exception -> L5
        this.runnable.run();     // Catch: Exception -> L5
        return null;
    L5:
        e = move-exception;
        Slog.w("ActivityTaskManagerService", "attachApplication failed, proc=" + this.mApp);
        return e;
    }

    @Override // com.android.server.wm.FrozenPendingEvent
    int getType() {
        return 1;
    }
}
