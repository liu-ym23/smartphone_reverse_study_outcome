package com.android.server.vibrator;

import android.os.SystemClock;
import android.util.Slog;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractVibratorStep extends Step {
    public final VibratorController controller;
    long mPendingVibratorOffDeadline;
    boolean mVibratorCompleteCallbackReceived;
    long mVibratorOnResult;

    AbstractVibratorStep(VibrationStepConductor conductor, long startTime, VibratorController controller, long pendingVibratorOffDeadline) {
        super(conductor, startTime);
        this.controller = controller;
        this.mPendingVibratorOffDeadline = pendingVibratorOffDeadline;
    }

    public int getVibratorId() {
        return this.controller.getVibratorInfo().getId();
    }

    @Override // com.android.server.vibrator.Step
    public long getVibratorOnDuration() {
        return this.mVibratorOnResult;
    }

    @Override // com.android.server.vibrator.Step
    public boolean acceptVibratorCompleteCallback(int vibratorId) {
        boolean shouldAcceptCallback = false;
        if (getVibratorId() == vibratorId) goto L6;
        return false;
    L6:
        if (this.mPendingVibratorOffDeadline <= SystemClock.uptimeMillis()) goto L9;
        shouldAcceptCallback = true;
    L9:
        if (VibrationThread.DEBUG == false) goto L11;
        Slog.d("VibrationThread", "Received completion callback from " + vibratorId + ", accepted = " + shouldAcceptCallback);
    L11:
        this.mPendingVibratorOffDeadline = 0;
        this.mVibratorCompleteCallbackReceived = true;
        return shouldAcceptCallback;
    }

    @Override // com.android.server.vibrator.Step
    public List<Step> cancel() {
        return Arrays.asList(new Step[]{new CompleteEffectVibratorStep(this.conductor, SystemClock.uptimeMillis(), true, this.controller, this.mPendingVibratorOffDeadline)});
    }

    @Override // com.android.server.vibrator.Step
    public void cancelImmediately() {
        if (this.mPendingVibratorOffDeadline <= SystemClock.uptimeMillis()) goto L6;
        stopVibrating();
        return;
    }

    protected long handleVibratorOnResult(long vibratorOnResult) {
        this.mVibratorOnResult = vibratorOnResult;
        if (VibrationThread.DEBUG == false) goto L6;
        Slog.d("VibrationThread", "Turned on vibrator " + getVibratorId() + ", result = " + this.mVibratorOnResult);
    L6:
        if (this.mVibratorOnResult <= 0) goto L8;
        this.mPendingVibratorOffDeadline = (SystemClock.uptimeMillis() + this.mVibratorOnResult) + 1000;
    L10:
        return this.mVibratorOnResult;
    L8:
        this.mPendingVibratorOffDeadline = 0;
        goto L10
    }

    protected void stopVibrating() {
        if (this.conductor.isInSession == false) goto L9;
        if (VibrationThread.DEBUG == false) goto L13;
        Slog.d("VibrationThread", "Vibration in session, skipping request to turn off vibrator " + getVibratorId());
        return;
    L13:
        return;
    L9:
        if (VibrationThread.DEBUG == false) goto L11;
        Slog.d("VibrationThread", "Turning off vibrator " + getVibratorId());
    L11:
        this.conductor.nextVibratorCallbackStepId(getVibratorId());
        this.controller.off();
        getVibration().stats.reportVibratorOff();
        this.mPendingVibratorOffDeadline = 0;
    }

    protected void changeAmplitude(float amplitude) {
        if (VibrationThread.DEBUG == false) goto L5;
        Slog.d("VibrationThread", "Amplitude changed on vibrator " + getVibratorId() + " to " + amplitude);
    L5:
        this.controller.setAmplitude(amplitude);
        getVibration().stats.reportSetAmplitude();
    }
}
