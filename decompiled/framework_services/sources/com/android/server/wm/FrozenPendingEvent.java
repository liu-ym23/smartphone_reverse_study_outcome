package com.android.server.wm;

import com.android.server.am.IApplicationFreezer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FrozenPendingEvent {
    public static final int DESTROY_ACTIVITY = 4;
    public static final int RESUME_ACTIVITY = 2;
    public static final int START_ACTIVITY = 1;
    public static final int UPDATE_VISIBILITY = 3;
    protected WindowProcessController mApp;
    protected RootWindowContainer mRootContainer;
    public IApplicationFreezer.UnfreezeReason unfreezeReason;

    abstract int getType();

    abstract Exception handle();

    FrozenPendingEvent(WindowProcessController app) {
        this.mApp = app;
        this.mRootContainer = app.mAtm.mRootWindowContainer;
    }

    public boolean equals(FrozenPendingEvent event) {
        if (event != null) goto L6;
        return false;
    L6:
        if (this.mApp == event.mApp) goto L8;
    L11:
        return false;
    L8:
        if (this.unfreezeReason != event.unfreezeReason) goto L11;
        return true;
    }
}
