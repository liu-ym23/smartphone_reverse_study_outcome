package com.android.server.vibrator;

import android.os.ExternalVibration;
import android.os.ExternalVibrationScale;
import android.os.IBinder;
import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
final class ExternalVibrationSession extends Vibration implements VibrationSession, IBinder.DeathRecipient {
    private static final String TAG = "ExternalVibrationSession";
    private final ExternalVibration mExternalVibration;
    private final VibratorManagerHooks mManagerHooks;
    private final ExternalVibrationScale mScale;
    private final long mSessionId;

    interface VibratorManagerHooks {
        void onExternalVibrationReleased(long r1);
    }

    ExternalVibrationSession(ExternalVibration externalVibration, VibratorManagerHooks managerHooks) {
        super(new VibrationSession.CallerInfo(externalVibration.getVibrationAttributes(), externalVibration.getUid(), -1, externalVibration.getPackage(), null));
        this.mSessionId = VibrationSession.nextSessionId();
        this.mScale = new ExternalVibrationScale();
        this.mExternalVibration = externalVibration;
        this.mManagerHooks = managerHooks;
    }

    public ExternalVibrationScale getScale() {
        return this.mScale;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public long getSessionId() {
        return this.mSessionId;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public long getCreateUptimeMillis() {
        return this.stats.getCreateUptimeMillis();
    }

    @Override // com.android.server.vibrator.VibrationSession
    public VibrationSession.CallerInfo getCallerInfo() {
        return this.callerInfo;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public IBinder getCallerToken() {
        return this.mExternalVibration.getToken();
    }

    @Override // com.android.server.vibrator.Vibration, com.android.server.vibrator.VibrationSession
    public VibrationSession.DebugInfo getDebugInfo() {
        return new Vibration.DebugInfoImpl(getStatus(), this.callerInfo, 3, this.stats, null, null, this.mScale.scaleLevel, this.mScale.adaptiveHapticsScale);
    }

    @Override // com.android.server.vibrator.VibrationSession
    public boolean isRepeating() {
        int usage = this.mExternalVibration.getVibrationAttributes().getUsage();
        if (usage != 33) goto L5;
    L8:
        return true;
    L5:
        if (usage == 17) goto L8;
        return false;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public boolean wasEndRequested() {
        return hasEnded();
    }

    @Override // com.android.server.vibrator.VibrationSession
    public boolean linkToDeath() {
        this.mExternalVibration.linkToDeath(this);
        return true;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public void unlinkToDeath() {
        this.mExternalVibration.unlinkToDeath(this);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Slog.d(TAG, "Binder died, cancelling external vibration...");
        requestEnd(VibrationSession.Status.CANCELLED_BINDER_DIED);
    }

    @Override // com.android.server.vibrator.Vibration
    void end(Vibration.EndInfo endInfo) {
        super.end(endInfo);
        if (this.stats.hasStarted() == false) goto L6;
        this.mExternalVibration.mute();
        this.stats.reportVibratorOn(this.stats.getEndUptimeMillis() - this.stats.getStartUptimeMillis());
        this.mManagerHooks.onExternalVibrationReleased(this.id);
        return;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public void requestEnd(VibrationSession.Status status, VibrationSession.CallerInfo endedBy, boolean immediate) {
        end(new Vibration.EndInfo(status, endedBy));
    }

    @Override // com.android.server.vibrator.VibrationSession
    public void notifyVibratorCallback(int vibratorId, long vibrationId, long stepId) {
    }

    @Override // com.android.server.vibrator.VibrationSession
    public void notifySyncedVibratorsCallback(long vibrationId) {
    }

    @Override // com.android.server.vibrator.VibrationSession
    public void notifySessionCallback() {
    }

    boolean isHoldingSameVibration(ExternalVibration vib) {
        return this.mExternalVibration.equals(vib);
    }

    void muteScale() {
        this.mScale.scaleLevel = -100;
    }

    void scale(VibrationScaler scaler, int usage) {
        ExternalVibrationScale r0 = this.mScale;
        r0.scaleLevel = scaler.getScaleLevel(usage);
        ExternalVibrationScale r1 = this.mScale;
        r1.adaptiveHapticsScale = scaler.getAdaptiveHapticsScale(usage);
        this.stats.reportAdaptiveScale(this.mScale.adaptiveHapticsScale);
    }

    public String toString() {
        return "ExternalVibrationSession{sessionId=" + this.mSessionId + ", vibrationId=" + this.id + ", callerInfo=" + this.callerInfo + ", externalVibration=" + this.mExternalVibration + ", scale=" + this.mScale + '}';
    }
}
