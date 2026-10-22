package com.android.server.vibrator;

import android.os.CombinedVibration;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
final class SingleVibrationSession implements VibrationSession, IBinder.DeathRecipient {
    private static final String TAG = "SingleVibrationSession";
    private final IBinder mCallerToken;
    private VibrationStepConductor mConductor;
    private final Object mLock;
    private final long mSessionId;
    private final HalVibration mVibration;

    SingleVibrationSession(IBinder callerToken, VibrationSession.CallerInfo callerInfo, CombinedVibration vibration) {
        this.mLock = new Object();
        this.mSessionId = VibrationSession.nextSessionId();
        this.mCallerToken = callerToken;
        this.mVibration = new HalVibration(callerInfo, vibration);
    }

    public void setVibrationConductor(VibrationStepConductor conductor) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mConductor = conductor;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public HalVibration getVibration() {
        return this.mVibration;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public long getSessionId() {
        return this.mSessionId;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public long getCreateUptimeMillis() {
        return this.mVibration.stats.getCreateUptimeMillis();
    }

    @Override // com.android.server.vibrator.VibrationSession
    public boolean isRepeating() {
        if (this.mVibration.getEffectToPlay().getDuration() != Long.MAX_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public VibrationSession.CallerInfo getCallerInfo() {
        return this.mVibration.callerInfo;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public IBinder getCallerToken() {
        return this.mCallerToken;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public VibrationSession.DebugInfo getDebugInfo() {
        return this.mVibration.getDebugInfo();
    }

    @Override // com.android.server.vibrator.VibrationSession
    public boolean wasEndRequested() {
        boolean r1 = true;
        if (this.mVibration.hasEnded() == false) goto L5;
        return true;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mConductor != null) goto L10;
    L14:
        r1 = false;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L10:
        if (this.mConductor.wasNotifiedToCancel() == false) goto L14;
        goto L14
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Slog.d(TAG, "Binder died, cancelling vibration...");
        requestEnd(VibrationSession.Status.CANCELLED_BINDER_DIED, null, false);
    }

    @Override // com.android.server.vibrator.VibrationSession
    public boolean linkToDeath() {
        this.mCallerToken.linkToDeath(this, 0);     // Catch: RemoteException -> L6
        return true;
    L6:
        e = move-exception;
        Slog.e(TAG, "Error linking vibration to token death", e);
        return false;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public void unlinkToDeath() {
        this.mCallerToken.unlinkToDeath(this, 0);     // Catch: NoSuchElementException -> L4
        return;
    L4:
        e = move-exception;
        Slog.wtf(TAG, "Failed to unlink vibration to token death", e);
    }

    @Override // com.android.server.vibrator.VibrationSession
    public void requestEnd(VibrationSession.Status status, VibrationSession.CallerInfo endedBy, boolean immediate) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mConductor == null) goto L9;
        this.mConductor.notifyCancelled(new Vibration.EndInfo(status, endedBy), immediate);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mVibration.end(new Vibration.EndInfo(status, endedBy));     // Catch: Throwable -> L7
        goto L10
    }

    @Override // com.android.server.vibrator.VibrationSession
    public void notifyVibratorCallback(int vibratorId, long vibrationId, long stepId) {
        if (vibrationId == this.mVibration.id) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mConductor == null) goto L12;
        this.mConductor.notifyVibratorComplete(vibratorId, stepId);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    @Override // com.android.server.vibrator.VibrationSession
    public void notifySyncedVibratorsCallback(long vibrationId) {
        if (vibrationId == this.mVibration.id) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mConductor == null) goto L12;
        this.mConductor.notifySyncedVibrationComplete();     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    @Override // com.android.server.vibrator.VibrationSession
    public void notifySessionCallback() {
    }

    public String toString() {
        return "SingleVibrationSession{sessionId= " + this.mSessionId + ", callerToken= " + this.mCallerToken + ", vibration=" + this.mVibration + '}';
    }
}
