package com.android.server.vibrator;

import android.os.Trace;
import android.os.VibrationEffect;
import android.os.vibrator.PrebakedSegment;
import android.os.vibrator.VibrationEffectSegment;
import android.util.Slog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class PerformPrebakedVibratorStep extends AbstractComposedVibratorStep {
    PerformPrebakedVibratorStep(VibrationStepConductor conductor, long startTime, VibratorController controller, VibrationEffect.Composed effect, int index, long pendingVibratorOffDeadline) {
        super(conductor, Math.max(startTime, pendingVibratorOffDeadline), controller, effect, index, pendingVibratorOffDeadline);
    }

    @Override // com.android.server.vibrator.Step
    public List<Step> play() {
        Trace.traceBegin(8388608, "PerformPrebakedVibratorStep");
        PrebakedSegment r0 = (VibrationEffectSegment) this.effect.getSegments().get(this.segmentIndex);     // Catch: Throwable -> L9
        if ((r0 instanceof PrebakedSegment) == true) goto L11;
        Slog.w("VibrationThread", "Ignoring wrong segment for a PerformPrebakedVibratorStep: " + r0);     // Catch: Throwable -> L9
        List<Step> r4 = nextSteps(1);     // Catch: Throwable -> L9
        Trace.traceEnd(8388608);
        return r4;
    L11:
        PrebakedSegment prebaked = r0;     // Catch: Throwable -> L9
        if (VibrationThread.DEBUG == false) goto L14;
        Slog.d("VibrationThread", "Perform " + VibrationEffect.effectIdToString(prebaked.getEffectId()) + " on vibrator " + this.controller.getVibratorInfo().getId());     // Catch: Throwable -> L9
    L14:
        VibrationEffect fallback = getVibration().getFallback(prebaked.getEffectId());     // Catch: Throwable -> L9
        int stepId = this.conductor.nextVibratorCallbackStepId(getVibratorId());     // Catch: Throwable -> L9
        long vibratorOnResult = this.controller.on(prebaked, getVibration().id, stepId);     // Catch: Throwable -> L9
        handleVibratorOnResult(vibratorOnResult);     // Catch: Throwable -> L9
        getVibration().stats.reportPerformEffect(vibratorOnResult, prebaked);     // Catch: Throwable -> L9
        if (vibratorOnResult != 0) goto L31;
        if (prebaked.shouldFallback() == false) goto L31;
        if ((fallback instanceof VibrationEffect.Composed) == false) goto L31;
        if (VibrationThread.DEBUG == false) goto L25;
        Slog.d("VibrationThread", "Playing fallback for effect " + VibrationEffect.effectIdToString(prebaked.getEffectId()));     // Catch: Throwable -> L9
    L25:
        AbstractVibratorStep fallbackStep = this.conductor.nextVibrateStep(this.startTime, this.controller, replaceCurrentSegment((VibrationEffect.Composed) fallback), this.segmentIndex, this.mPendingVibratorOffDeadline);     // Catch: Throwable -> L28
        List<Step> fallbackResult = fallbackStep.play();     // Catch: Throwable -> L28
        handleVibratorOnResult(fallbackStep.getVibratorOnDuration());     // Catch: Throwable -> L28
        Trace.traceEnd(8388608);
        return fallbackResult;
    L31:
        List<Step> r2 = nextSteps(1);     // Catch: Throwable -> L28
        Trace.traceEnd(8388608);
        return r2;
    L28:
        th = th;
    L34:
        Trace.traceEnd(8388608);
        throw th;
    L9:
        th = th;
        goto L34
    }

    private VibrationEffect.Composed replaceCurrentSegment(VibrationEffect.Composed fallback) {
        List<VibrationEffectSegment> newSegments = new ArrayList(this.effect.getSegments());
        int newRepeatIndex = this.effect.getRepeatIndex();
        newSegments.remove(this.segmentIndex);
        newSegments.addAll(this.segmentIndex, fallback.getSegments());
        if (this.segmentIndex >= this.effect.getRepeatIndex()) goto L6;
        newRepeatIndex = newRepeatIndex + (fallback.getSegments().size() - 1);
    L6:
        return new VibrationEffect.Composed(newSegments, newRepeatIndex);
    }
}
