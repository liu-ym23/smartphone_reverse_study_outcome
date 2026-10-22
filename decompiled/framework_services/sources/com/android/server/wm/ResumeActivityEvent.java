package com.android.server.wm;

import android.util.Slog;
import com.android.server.am.IApplicationFreezer;

/* JADX INFO: compiled from: FrozenPendingEvent.java */
/* JADX INFO: loaded from: classes3.dex */
class ResumeActivityEvent extends FrozenPendingEvent {
    ResumeActivityEvent(WindowProcessController app) {
        super(app);
        this.unfreezeReason = IApplicationFreezer.UnfreezeReason.NEED_RESUME_ACTIVITY;
    }

    @Override // com.android.server.wm.FrozenPendingEvent
    Exception handle() {
        Slog.w("AMS.Freeze", "ResumeActivityEvent handle pendingEvent, app " + this.mApp);     // Catch: Exception -> L5
        this.mRootContainer.resumeFocusedTasksTopActivities();     // Catch: Exception -> L5
        return null;
    L5:
        e = move-exception;
        return e;
    }

    @Override // com.android.server.wm.FrozenPendingEvent
    int getType() {
        return 2;
    }
}
