package com.android.server.power;

import android.os.Handler;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.android.internal.statusbar.IStatusBarService;

/* JADX INFO: loaded from: classes3.dex */
public class InattentiveSleepWarningController {
    private static final String TAG = "InattentiveSleepWarning";
    private final Handler mHandler;
    private boolean mIsShown;
    private IStatusBarService mStatusBarService;

    public static /* synthetic */ void $r8$lambda$QGCfNRTJoLqzdLYvRTFucA7L5C0(InattentiveSleepWarningController r0, boolean r1) {
        r0.lambda$dismiss$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$QpOiu52HMHx6-A07G91O92m9dsg, reason: not valid java name */
    public static /* synthetic */ void m7394$r8$lambda$QpOiu52HMHx6A07G91O92m9dsg(InattentiveSleepWarningController r0) {
        r0.showInternal();
    }

    InattentiveSleepWarningController() {
        this.mHandler = new Handler();
    }

    public boolean isShown() {
        return this.mIsShown;
    }

    public void show() {
        if (isShown() == false) goto L5;
        return;
    L5:
        this.mHandler.post(new InattentiveSleepWarningController$$ExternalSyntheticLambda1(this));
        this.mIsShown = true;
    }

    private void showInternal() {
        getStatusBar().showInattentiveSleepWarning();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Failed to show inattentive sleep warning", e);
        this.mIsShown = false;
    }

    public void dismiss(final boolean animated) {
        if (isShown() == true) goto L5;
        return;
    L5:
        this.mHandler.post(new InattentiveSleepWarningController$$ExternalSyntheticLambda0(this, animated));
        this.mIsShown = false;
    }

    private /* synthetic */ void lambda$dismiss$0(boolean animated) {
        dismissInternal(animated);
    }

    private void dismissInternal(boolean animated) {
        getStatusBar().dismissInattentiveSleepWarning(animated);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Failed to dismiss inattentive sleep warning", e);
    }

    private IStatusBarService getStatusBar() {
        if (this.mStatusBarService != null) goto L6;
        this.mStatusBarService = IStatusBarService.Stub.asInterface(ServiceManager.getService("statusbar"));
    L6:
        return this.mStatusBarService;
    }
}
