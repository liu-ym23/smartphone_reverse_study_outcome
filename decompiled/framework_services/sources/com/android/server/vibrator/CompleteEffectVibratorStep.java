package com.android.server.vibrator;

import android.os.SystemClock;
import android.os.Trace;
import android.util.Slog;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class CompleteEffectVibratorStep extends AbstractVibratorStep {
    private final boolean mCancelled;

    CompleteEffectVibratorStep(VibrationStepConductor conductor, long startTime, boolean cancelled, VibratorController controller, long pendingVibratorOffDeadline) {
        super(conductor, startTime, controller, pendingVibratorOffDeadline);
        this.mCancelled = cancelled;
    }

    @Override // com.android.server.vibrator.Step
    public boolean isCleanUp() {
        return this.mCancelled;
    }

    @Override // com.android.server.vibrator.AbstractVibratorStep, com.android.server.vibrator.Step
    public List<Step> cancel() {
        if (this.mCancelled == false) goto L7;
        return Arrays.asList(new Step[]{new TurnOffVibratorStep(this.conductor, SystemClock.uptimeMillis(), this.controller, true)});
    L7:
        return super.cancel();
    }

    @Override // com.android.server.vibrator.Step
    public List<Step> play() {
        Trace.traceBegin(8388608, "CompleteEffectVibratorStep");
    L9:
        th = th;
    L46:
        Trace.traceEnd(8388608);
        throw th;
    L5:
        if (VibrationThread.DEBUG == false) goto L14;
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L9
        r0.append("Running ");     // Catch: Throwable -> L9
        if (this.mCancelled == false) goto L11;
        String r5 = "cancel";
    L12:
        r0.append(r5);     // Catch: Throwable -> L9
        r0.append(" vibration step on vibrator ");     // Catch: Throwable -> L9
        r0.append(this.controller.getVibratorInfo().getId());     // Catch: Throwable -> L9
        Slog.d("VibrationThread", r0.toString());     // Catch: Throwable -> L9
        goto L14
    L11:
        r5 = "complete";
    L14:
        if (this.mVibratorCompleteCallbackReceived == false) goto L18;
        stopVibrating();     // Catch: Throwable -> L9
        List<Step> r1 = VibrationStepConductor.EMPTY_STEP_LIST;     // Catch: Throwable -> L9
        Trace.traceEnd(8388608);
        return r1;
    L18:
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        float currentAmplitude = this.controller.getCurrentAmplitude();     // Catch: Throwable -> L9
        long remainingOnDuration = (this.mPendingVibratorOffDeadline - now) - 1000;     // Catch: Throwable -> L9
        long rampDownDuration = Math.min(remainingOnDuration, this.conductor.vibrationSettings.getRampDownDuration());     // Catch: Throwable -> L9
        long stepDownDuration = this.conductor.vibrationSettings.getRampStepDuration();     // Catch: Throwable -> L9
        if (currentAmplitude < 0.001f) goto L39;
        if (rampDownDuration <= stepDownDuration) goto L39;
        if (VibrationThread.DEBUG == false) goto L27;
        Slog.d("VibrationThread", "Ramping down vibrator " + this.controller.getVibratorInfo().getId() + " from amplitude " + currentAmplitude + " for " + rampDownDuration + "ms");     // Catch: Throwable -> L9
    L27:
        if (this.mCancelled == false) goto L29;
        long r13 = now + rampDownDuration;     // Catch: Throwable -> L9
    L30:
        long rampOffVibratorOffDeadline = r13;
        float amplitudeDelta = currentAmplitude / (rampDownDuration / stepDownDuration);     // Catch: Throwable -> L9
        float amplitudeTarget = currentAmplitude - amplitudeDelta;     // Catch: Throwable -> L9
        List<Step> r2 = Arrays.asList(new Step[]{new RampOffVibratorStep(this.conductor, this.startTime, amplitudeTarget, amplitudeDelta, this.controller, rampOffVibratorOffDeadline)});     // Catch: Throwable -> L35
        Trace.traceEnd(8388608);
        return r2;
    L29:
        r13 = this.mPendingVibratorOffDeadline;     // Catch: Throwable -> L9
    L39:
        if (this.mCancelled == false) goto L43;
        stopVibrating();     // Catch: Throwable -> L35
        List<Step> r3 = VibrationStepConductor.EMPTY_STEP_LIST;     // Catch: Throwable -> L35
        Trace.traceEnd(8388608);
        return r3;
    L43:
        List<Step> r4 = Arrays.asList(new Step[]{new TurnOffVibratorStep(this.conductor, this.mPendingVibratorOffDeadline, this.controller, false)});     // Catch: Throwable -> L35
        Trace.traceEnd(r2);
        return r4;
    L35:
        th = th;
        goto L46
    }
}
