package com.android.server.vibrator;

import android.os.Trace;
import android.os.VibrationEffect;
import android.os.vibrator.PwlePoint;
import android.os.vibrator.PwleSegment;
import android.os.vibrator.VibrationEffectSegment;
import android.util.Slog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class ComposePwleV2VibratorStep extends AbstractComposedVibratorStep {
    ComposePwleV2VibratorStep(VibrationStepConductor conductor, long startTime, VibratorController controller, VibrationEffect.Composed effect, int index, long pendingVibratorOffDeadline) {
        super(conductor, Math.max(startTime, pendingVibratorOffDeadline), controller, effect, index, pendingVibratorOffDeadline);
    }

    @Override // com.android.server.vibrator.Step
    public List<Step> play() {
        Trace.traceBegin(8388608, "ComposePwleV2Step");
        int limit = this.controller.getVibratorInfo().getMaxEnvelopeEffectSize();     // Catch: Throwable -> L9
        List<PwlePoint> pwles = unrollPwleSegments(this.effect, this.segmentIndex, limit);     // Catch: Throwable -> L9
        if (pwles.isEmpty() == false) goto L12;
        Slog.w("VibrationThread", "Ignoring wrong segment for a ComposeEnvelopeStep: " + this.effect.getSegments().get(this.segmentIndex));     // Catch: Throwable -> L9
        List<Step> r4 = nextSteps(1);     // Catch: Throwable -> L9
        Trace.traceEnd(8388608);
        return r4;
    L12:
        if (VibrationThread.DEBUG == false) goto L14;
        Slog.d("VibrationThread", "Compose " + pwles + " PWLEs on vibrator " + this.controller.getVibratorInfo().getId());     // Catch: Throwable -> L9
    L14:
        PwlePoint[] pwlesArray = (PwlePoint[]) pwles.toArray(new PwlePoint[pwles.size()]);     // Catch: Throwable -> L9
        int stepId = this.conductor.nextVibratorCallbackStepId(getVibratorId());     // Catch: Throwable -> L9
        long vibratorOnResult = this.controller.on(pwlesArray, getVibration().id, stepId);     // Catch: Throwable -> L9
        handleVibratorOnResult(vibratorOnResult);     // Catch: Throwable -> L9
        getVibration().stats.reportComposePwle(vibratorOnResult, pwlesArray);     // Catch: Throwable -> L9
        List<Step> r5 = nextSteps(pwles.size());     // Catch: Throwable -> L9
        Trace.traceEnd(8388608);
        return r5;
    L9:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    private List<PwlePoint> unrollPwleSegments(VibrationEffect.Composed effect, int startIndex, int limit) {
        List<PwlePoint> pwlePoints = new ArrayList(limit);
        float bestBreakAmplitude = 1.0f;
        int bestBreakPosition = limit;
        int segmentCount = effect.getSegments().size();
        int repeatIndex = effect.getRepeatIndex();
        int i = startIndex;
    L4:
        if (pwlePoints.size() > limit) goto L17;
        if (i != segmentCount) goto L8;
        if (repeatIndex < 0) goto L17;
        i = repeatIndex;
    L8:
        PwleSegment r7 = (VibrationEffectSegment) effect.getSegments().get(i);
        if ((r7 instanceof PwleSegment) == false) goto L17;
        PwleSegment pwleSegment = r7;
        if (pwlePoints.isEmpty() == false) goto L13;
        pwlePoints.add(new PwlePoint(pwleSegment.getStartAmplitude(), pwleSegment.getStartFrequencyHz(), 0));
    L13:
        pwlePoints.add(new PwlePoint(pwleSegment.getEndAmplitude(), pwleSegment.getEndFrequencyHz(), (int) pwleSegment.getDuration()));
        if (isBetterBreakPosition(pwlePoints, bestBreakAmplitude, limit) == false) goto L16;
        bestBreakAmplitude = pwleSegment.getEndAmplitude();
        bestBreakPosition = pwlePoints.size();
    L16:
        i = i + 1;
    L17:
        int i2 = pwlePoints.size();
        if (i2 <= limit) goto L21;
        return pwlePoints.subList(0, bestBreakPosition);
    L21:
        return pwlePoints;
    }

    private boolean isBetterBreakPosition(List<PwlePoint> segments, float currentBestBreakAmplitude, int limit) {
        PwlePoint lastSegment = segments.get(segments.size() - 1);
        float breakAmplitudeCandidate = lastSegment.getAmplitude();
        int breakPositionCandidate = segments.size();
        if (breakPositionCandidate <= limit) goto L6;
        return false;
    L6:
        if (breakAmplitudeCandidate != 0.0f) goto L9;
        return true;
    L9:
        if (breakPositionCandidate >= (limit / 2)) goto L12;
        return false;
    L12:
        if (breakAmplitudeCandidate > currentBestBreakAmplitude) goto L15;
        return true;
    L15:
        return false;
    }
}
