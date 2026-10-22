package com.android.server.policy.keyguard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.internal.policy.IKeyguardDismissCallback;
import com.android.internal.policy.IKeyguardDrawnCallback;
import com.android.internal.policy.IKeyguardExitCallback;
import com.android.internal.policy.IKeyguardService;
import com.android.internal.policy.IKeyguardStateCallback;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class KeyguardServiceWrapper implements IKeyguardService {
    private String TAG;
    private KeyguardStateMonitor mKeyguardStateMonitor;
    private IKeyguardService mService;

    public KeyguardServiceWrapper(Context context, IKeyguardService service, KeyguardStateMonitor.StateCallback callback) {
        this.TAG = "KeyguardServiceWrapper";
        this.mService = service;
        this.mKeyguardStateMonitor = new KeyguardStateMonitor(context, service, callback);
    }

    public void verifyUnlock(IKeyguardExitCallback callback) {
        this.mService.verifyUnlock(callback);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void setOccluded(boolean isOccluded, boolean animate) {
        this.mService.setOccluded(isOccluded, animate);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void addStateMonitorCallback(IKeyguardStateCallback callback) {
        this.mService.addStateMonitorCallback(callback);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void dismiss(IKeyguardDismissCallback callback, CharSequence message) {
        this.mService.dismiss(callback, message);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void onDreamingStarted() {
        this.mService.onDreamingStarted();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void onDreamingStopped() {
        this.mService.onDreamingStopped();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void onStartedGoingToSleep(int pmSleepReason) {
        this.mService.onStartedGoingToSleep(pmSleepReason);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void onFinishedGoingToSleep(int pmSleepReason, boolean powerButtonLaunchGestureTriggered) {
        this.mService.onFinishedGoingToSleep(pmSleepReason, powerButtonLaunchGestureTriggered);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void onStartedWakingUp(int pmWakeReason, boolean powerButtonLaunchGestureTriggered) {
        this.mService.onStartedWakingUp(pmWakeReason, powerButtonLaunchGestureTriggered);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void onFinishedWakingUp() {
        this.mService.onFinishedWakingUp();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void onScreenTurningOn(IKeyguardDrawnCallback callback) {
        this.mService.onScreenTurningOn(callback);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void onScreenTurnedOn() {
        this.mService.onScreenTurnedOn();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void onScreenTurningOff() {
        this.mService.onScreenTurningOff();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void onScreenTurnedOff() {
        this.mService.onScreenTurnedOff();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void setKeyguardEnabled(boolean enabled) {
        this.mService.setKeyguardEnabled(enabled);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void onSystemReady() {
        this.mService.onSystemReady();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void doKeyguardTimeout(Bundle options) {
        int userId = this.mKeyguardStateMonitor.getCurrentUser();
        if (this.mKeyguardStateMonitor.isSecure(userId) == false) goto L10;
        this.mKeyguardStateMonitor.onShowingStateChanged(true, userId);
    L10:
        this.mService.doKeyguardTimeout(options);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void showDismissibleKeyguard() {
        this.mService.showDismissibleKeyguard();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void setSwitchingUser(boolean switching) {
        this.mService.setSwitchingUser(switching);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void setCurrentUser(int userId) {
        this.mKeyguardStateMonitor.setCurrentUser(userId);
        this.mService.setCurrentUser(userId);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void onBootCompleted() {
        this.mService.onBootCompleted();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void startKeyguardExitAnimation(long startTime, long fadeoutDuration) {
        this.mService.startKeyguardExitAnimation(startTime, fadeoutDuration);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void onShortPowerPressedGoHome() {
        this.mService.onShortPowerPressedGoHome();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void dismissKeyguardToLaunch(Intent intentToLaunch) {
        this.mService.dismissKeyguardToLaunch(intentToLaunch);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void onSystemKeyPressed(int keycode) {
        this.mService.onSystemKeyPressed(keycode);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public void handleWindowVisibleChanged(String packageName, boolean winVisible) {
        this.mService.handleWindowVisibleChanged(packageName, winVisible);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(this.TAG, "Remote Exception", e);
    }

    public IBinder asBinder() {
        return this.mService.asBinder();
    }

    public boolean isShowing() {
        return this.mKeyguardStateMonitor.isShowing();
    }

    public boolean isTrusted() {
        return this.mKeyguardStateMonitor.isTrusted();
    }

    public boolean isSecure(int userId) {
        return this.mKeyguardStateMonitor.isSecure(userId);
    }

    public boolean isInputRestricted() {
        return this.mKeyguardStateMonitor.isInputRestricted();
    }

    public void dump(String prefix, PrintWriter pw) {
        this.mKeyguardStateMonitor.dump(prefix, pw);
    }
}
