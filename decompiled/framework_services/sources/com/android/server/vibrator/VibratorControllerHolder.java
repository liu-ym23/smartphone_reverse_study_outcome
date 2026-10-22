package com.android.server.vibrator;

import android.frameworks.vibrator.IVibratorController;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
public final class VibratorControllerHolder implements IBinder.DeathRecipient {
    private static final String TAG = "VibratorControllerHolder";
    private IVibratorController mVibratorController;

    public VibratorControllerHolder() {
    }

    public IVibratorController getVibratorController() {
        return this.mVibratorController;
    }

    public void setVibratorController(IVibratorController controller) {
    L5:
        e = move-exception;
        Slog.wtf(TAG, "Failed to set IVibratorController: " + this, e);
        return;
    L3:
        if (this.mVibratorController == null) goto L7;
        this.mVibratorController.asBinder().unlinkToDeath(this, 0);     // Catch: RemoteException -> L5
    L7:
        this.mVibratorController = controller;     // Catch: RemoteException -> L5
        if (this.mVibratorController == null) goto L16;
        this.mVibratorController.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L5
        return;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied(IBinder deadBinder) {
        if (this.mVibratorController != null) goto L5;
        return;
    L5:
        if (deadBinder != this.mVibratorController.asBinder()) goto L9;
        setVibratorController(null);
        return;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Slog.wtf(TAG, "binderDied() called unexpectedly.");
    }
}
