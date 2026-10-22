package com.android.server.vibrator;

import android.os.SystemClock;
import android.os.Trace;
import android.os.VibrationEffect;
import android.os.vibrator.StepSegment;
import android.os.vibrator.VibrationEffectSegment;
import android.util.Slog;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class SetAmplitudeVibratorStep extends AbstractComposedVibratorStep {
    static final int REPEATING_EFFECT_ON_DURATION = 5000;

    SetAmplitudeVibratorStep(VibrationStepConductor conductor, long startTime, VibratorController controller, VibrationEffect.Composed effect, int index, long pendingVibratorOffDeadline) {
        super(conductor, startTime, controller, effect, index, pendingVibratorOffDeadline);
    }

    @Override // com.android.server.vibrator.AbstractVibratorStep, com.android.server.vibrator.Step
    public boolean acceptVibratorCompleteCallback(int vibratorId) {
        boolean shouldAcceptCallback = false;
        if (super.acceptVibratorCompleteCallback(vibratorId) == true) goto L6;
        return false;
    L6:
        if (SystemClock.uptimeMillis() >= this.startTime) goto L11;
        if (this.controller.getCurrentAmplitude() <= 0.0f) goto L11;
        shouldAcceptCallback = true;
    L11:
        if (VibrationThread.DEBUG == false) goto L13;
        Slog.d("VibrationThread", "Amplitude step received completion callback from " + vibratorId + ", accepted = " + shouldAcceptCallback);
    L13:
        return shouldAcceptCallback;
    }

    @Override // com.android.server.vibrator.Step
    public List<Step> play() {
        Trace.traceBegin(8388608, "SetAmplitudeVibratorStep");
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        long latency = now - this.startTime;     // Catch: Throwable -> L7
        if (VibrationThread.DEBUG == false) goto L10;
        Slog.d("VibrationThread", "Running amplitude step with " + latency + "ms latency.");     // Catch: Throwable -> L7
    L10:
        if (this.mVibratorCompleteCallbackReceived == true) goto L12;
    L16:
        StepSegment r0 = (VibrationEffectSegment) this.effect.getSegments().get(this.segmentIndex);     // Catch: Throwable -> L7
        if ((r0 instanceof StepSegment) == true) goto L21;
        Slog.w("VibrationThread", "Ignoring wrong segment for a SetAmplitudeVibratorStep: " + r0);     // Catch: Throwable -> L7
        List<Step> r8 = nextSteps(this.startTime, 1);     // Catch: Throwable -> L7
        Trace.traceEnd(8388608);
        return r8;
    L21:
        StepSegment stepSegment = r0;     // Catch: Throwable -> L7
        if (stepSegment.getDuration() != 0) goto L26;
        List<Step> r9 = nextSteps(this.startTime, 1);     // Catch: Throwable -> L7
        Trace.traceEnd(8388608);
        return r9;
    L26:
        float amplitude = stepSegment.getAmplitude();     // Catch: Throwable -> L7
        if (amplitude != 0.0f) goto L33;
        if (this.mPendingVibratorOffDeadline <= now) goto L31;
        stopVibrating();     // Catch: Throwable -> L7
        long r15 = 8388608;
    L42:
        long nextStartTime = this.startTime + r0.getDuration();     // Catch: Throwable -> L39
        List<Step> r10 = nextSteps(nextStartTime, 1);     // Catch: Throwable -> L39
        Trace.traceEnd(r15);
        return r10;
    L39:
        th = th;
    L45:
        Trace.traceEnd(r15);
        throw th;
    L31:
        r15 = 8388608;
        goto L42
    L33:
        r15 = 8388608;
        if (this.startTime < this.mPendingVibratorOffDeadline) goto L41;
        long onDuration = getVibratorOnDuration(this.effect, this.segmentIndex);     // Catch: Throwable -> L39
        if (onDuration <= 0) goto L41;
        startVibrating(onDuration);     // Catch: Throwable -> L39
    L41:
        changeAmplitude(amplitude);     // Catch: Throwable -> L39
        goto L42
    L12:
        if (latency >= 0) goto L16;
        turnVibratorBackOn(-latency);     // Catch: Throwable -> L7
        List<Step> r1 = Arrays.asList(new Step[]{new SetAmplitudeVibratorStep(this.conductor, this.startTime, this.controller, this.effect, this.segmentIndex, this.mPendingVibratorOffDeadline)});     // Catch: Throwable -> L7
        Trace.traceEnd(8388608);
        return r1;
    L7:
        th = th;
        r15 = 8388608;
        goto L45
    }

    private void turnVibratorBackOn(long remainingDuration) {
        long onDuration = getVibratorOnDuration(this.effect, this.segmentIndex);
        if (onDuration > 0) goto L5;
        return;
    L5:
        long onDuration2 = onDuration + remainingDuration;
        if (VibrationThread.DEBUG == false) goto L8;
        Slog.d("VibrationThread", "Turning the vibrator back ON using the remaining duration of " + remainingDuration + "ms, for a total of " + onDuration2 + "ms");
    L8:
        float expectedAmplitude = this.controller.getCurrentAmplitude();
        long vibratorOnResult = startVibrating(onDuration2);
        if (vibratorOnResult <= 0) goto L12;
        changeAmplitude(expectedAmplitude);
        return;
    }

    private long startVibrating(long duration) {
        if (VibrationThread.DEBUG == false) goto L5;
        Slog.d("VibrationThread", "Turning on vibrator " + this.controller.getVibratorInfo().getId() + " for " + duration + "ms");
    L5:
        int stepId = this.conductor.nextVibratorCallbackStepId(getVibratorId());
        long vibratorOnResult = this.controller.on(duration, getVibration().id, stepId);
        handleVibratorOnResult(vibratorOnResult);
        getVibration().stats.reportVibratorOn(vibratorOnResult);
        return vibratorOnResult;
    }

    private long getVibratorOnDuration(VibrationEffect.Composed effect, int startIndex) {
        List<VibrationEffectSegment> segments = effect.getSegments();
        int segmentCount = segments.size();
        int repeatIndex = effect.getRepeatIndex();
        int i = startIndex;
        long timing = 0;
    L3:
        if (i >= segmentCount) goto L19;
        VibrationEffectSegment r6 = segments.get(i);
        if ((r6 instanceof StepSegment) == false) goto L19;
        if (r6.getDuration() > 0) goto L9;
    L11:
        timing = timing + r6.getDuration();
        i = i + 1;
        if (i != segmentCount) goto L15;
        if (repeatIndex < 0) goto L15;
        i = repeatIndex;
        repeatIndex = -1;
    L15:
        if (i != startIndex) goto L3;
        return Math.max(timing, 5000);
    L9:
        if (((StepSegment) r6).getAmplitude() != 0.0f) goto L11;
    L19:
        if (i == segmentCount) goto L21;
        return timing;
    L21:
        if (effect.getRepeatIndex() < 0) goto L23;
        return timing;
    L23:
        return timing + ((long) this.conductor.vibrationSettings.getRampDownDuration());
    }
}
