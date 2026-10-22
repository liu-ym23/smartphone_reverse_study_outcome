package com.android.server.vibrator;

import android.os.SystemClock;
import android.os.Trace;
import android.util.Slog;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class RampOffVibratorStep extends AbstractVibratorStep {
    private final float mAmplitudeDelta;
    private final float mAmplitudeTarget;

    RampOffVibratorStep(VibrationStepConductor conductor, long startTime, float amplitudeTarget, float amplitudeDelta, VibratorController controller, long pendingVibratorOffDeadline) {
        super(conductor, startTime, controller, pendingVibratorOffDeadline);
        this.mAmplitudeTarget = amplitudeTarget;
        this.mAmplitudeDelta = amplitudeDelta;
    }

    @Override // com.android.server.vibrator.Step
    public boolean isCleanUp() {
        return true;
    }

    @Override // com.android.server.vibrator.AbstractVibratorStep, com.android.server.vibrator.Step
    public List<Step> cancel() {
        return Arrays.asList(new Step[]{new TurnOffVibratorStep(this.conductor, SystemClock.uptimeMillis(), this.controller, true)});
    }

    @Override // com.android.server.vibrator.Step
    public List<Step> play() {
        Trace.traceBegin(8388608, "RampOffVibratorStep");
    L6:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    L4:
        if (VibrationThread.DEBUG == false) goto L9;
        long latency = SystemClock.uptimeMillis() - this.startTime;     // Catch: Throwable -> L6
        Slog.d("VibrationThread", "Ramp down the vibrator amplitude, step with " + latency + "ms latency.");     // Catch: Throwable -> L6
    L9:
        if (this.mVibratorCompleteCallbackReceived == false) goto L13;
        stopVibrating();     // Catch: Throwable -> L6
        List<Step> r0 = VibrationStepConductor.EMPTY_STEP_LIST;     // Catch: Throwable -> L6
        Trace.traceEnd(8388608);
        return r0;
    L13:
        changeAmplitude(this.mAmplitudeTarget);     // Catch: Throwable -> L6
        float newAmplitudeTarget = this.mAmplitudeTarget - this.mAmplitudeDelta;     // Catch: Throwable -> L6
        if (newAmplitudeTarget >= 0.001f) goto L18;
        List<Step> r1 = Arrays.asList(new Step[]{new TurnOffVibratorStep(this.conductor, this.mPendingVibratorOffDeadline, this.controller, true)});     // Catch: Throwable -> L6
        Trace.traceEnd(8388608);
        return r1;
    L18:
        List<Step> r2 = Arrays.asList(new Step[]{new RampOffVibratorStep(this.conductor, this.startTime + ((long) this.conductor.vibrationSettings.getRampStepDuration()), newAmplitudeTarget, this.mAmplitudeDelta, this.controller, this.mPendingVibratorOffDeadline)});     // Catch: Throwable -> L6
        Trace.traceEnd(8388608);
        return r2;
    }
}
