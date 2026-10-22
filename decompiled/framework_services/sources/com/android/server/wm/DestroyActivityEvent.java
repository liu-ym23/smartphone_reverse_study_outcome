package com.android.server.wm;

import android.app.IApplicationThread;
import android.app.servertransaction.DestroyActivityItem;
import android.os.IBinder;
import android.util.Slog;
import com.android.server.am.IApplicationFreezer;

/* JADX INFO: compiled from: FrozenPendingEvent.java */
/* JADX INFO: loaded from: classes3.dex */
class DestroyActivityEvent extends FrozenPendingEvent {
    private DestroyActivityItem activityLifecycleItem;
    private IBinder appToken;
    private IApplicationThread thread;

    DestroyActivityEvent(WindowProcessController app, IApplicationThread _thread, IBinder _appToken, DestroyActivityItem _activityLifecycleItem) {
        super(app);
        this.unfreezeReason = IApplicationFreezer.UnfreezeReason.NEED_DESTROY_ACTIVITY;
        this.thread = _thread;
        this.appToken = _appToken;
        this.activityLifecycleItem = _activityLifecycleItem;
    }

    @Override // com.android.server.wm.FrozenPendingEvent
    public boolean equals(FrozenPendingEvent event) {
        if (super.equals(event) == true) goto L6;
        return false;
    L6:
        if ((event instanceof DestroyActivityEvent) == true) goto L9;
        return true;
    L9:
        if (this.appToken == ((DestroyActivityEvent) event).appToken) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.android.server.wm.FrozenPendingEvent
    Exception handle() {
        Slog.w("AMS.Freeze", "DestroyActivityEvent handle pendingEvent, app " + this.mApp + " token:" + this.appToken);     // Catch: Exception -> L6
        this.mApp.mAtm.getLifecycleManager().scheduleTransactionItem(this.thread, this.activityLifecycleItem);     // Catch: Exception -> L6
        return null;
    L6:
        e = move-exception;
        Slog.w("AMS.Freeze", "scheduleTransaction failed" + this.mApp);
        return e;
    }

    @Override // com.android.server.wm.FrozenPendingEvent
    int getType() {
        return 4;
    }
}
