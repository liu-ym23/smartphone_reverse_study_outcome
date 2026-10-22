package com.android.server.wm;

import android.util.Slog;
import com.android.server.am.IApplicationFreezer;

/* JADX INFO: compiled from: FrozenPendingEvent.java */
/* JADX INFO: loaded from: classes3.dex */
class UpdateVisibilityEvent extends FrozenPendingEvent {
    UpdateVisibilityEvent(WindowProcessController app) {
        super(app);
        this.unfreezeReason = IApplicationFreezer.UnfreezeReason.NEED_UPDATE_VISIBILITY;
    }

    @Override // com.android.server.wm.FrozenPendingEvent
    Exception handle() {
        Slog.w("AMS.Freeze", "UpdateVisibilityEvent handle pendingEvent, app " + this.mApp);     // Catch: Exception -> L5
        this.mRootContainer.ensureActivitiesVisible();     // Catch: Exception -> L5
        return null;
    L5:
        e = move-exception;
        return e;
    }

    @Override // com.android.server.wm.FrozenPendingEvent
    int getType() {
        return 3;
    }
}
