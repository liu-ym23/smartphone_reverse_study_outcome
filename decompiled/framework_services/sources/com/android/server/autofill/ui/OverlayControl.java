package com.android.server.autofill.ui;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
class OverlayControl {
    private final AppOpsManager mAppOpsManager;
    private final IBinder mToken;

    OverlayControl(Context context) {
        this.mToken = new Binder();
        this.mAppOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
    }

    void hideOverlays() {
        setOverlayAllowed(false);
    }

    void showOverlays() {
        setOverlayAllowed(true);
    }

    private void setOverlayAllowed(boolean allowed) {
        if (this.mAppOpsManager == null) goto L6;
        this.mAppOpsManager.setUserRestrictionForUser(24, !allowed, this.mToken, null, -1);
        this.mAppOpsManager.setUserRestrictionForUser(45, !allowed, this.mToken, null, -1);
        return;
    }
}
