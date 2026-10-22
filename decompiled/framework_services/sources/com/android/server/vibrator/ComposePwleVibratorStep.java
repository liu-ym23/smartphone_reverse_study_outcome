package com.android.server.vibrator;

import android.os.Trace;
import android.os.VibrationEffect;
import android.os.vibrator.RampSegment;
import android.os.vibrator.VibrationEffectSegment;
import android.util.Slog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class ComposePwleVibratorStep extends AbstractComposedVibratorStep {
    private static final int DEFAULT_PWLE_SIZE_LIMIT = 100;

    ComposePwleVibratorStep(VibrationStepConductor conductor, long startTime, VibratorController controller, VibrationEffect.Composed effect, int index, long pendingVibratorOffDeadline) {
        super(conductor, Math.max(startTime, pendingVibratorOffDeadline), controller, effect, index, pendingVibratorOffDeadline);
    }

    @Override // com.android.server.vibrator.Step
    public List<Step> play() {
        Trace.traceBegin(8388608, "ComposePwleStep");
        int limit = this.controller.getVibratorInfo().getPwleSizeMax();     // Catch: Throwable -> L13
        VibrationEffect.Composed r3 = this.effect;     // Catch: Throwable -> L13
        int r4 = this.segmentIndex;     // Catch: Throwable -> L13
        if (limit <= 0) goto L6;
        int r5 = limit;
    L7:
        List<RampSegment> pwles = unrollRampSegments(r3, r4, r5);     // Catch: Throwable -> L13
        if (pwles.isEmpty() == false) goto L16;
        Slog.w("VibrationThread", "Ignoring wrong segment for a ComposePwleStep: " + this.effect.getSegments().get(this.segmentIndex));     // Catch: Throwable -> L13
        List<Step> r6 = nextSteps(1);     // Catch: Throwable -> L13
        Trace.traceEnd(8388608);
        return r6;
    L16:
        if (VibrationThread.DEBUG == false) goto L18;
        Slog.d("VibrationThread", "Compose " + pwles + " PWLEs on vibrator " + this.controller.getVibratorInfo().getId());     // Catch: Throwable -> L13
    L18:
        RampSegment[] pwlesArray = (RampSegment[]) pwles.toArray(new RampSegment[pwles.size()]);     // Catch: Throwable -> L13
        int stepId = this.conductor.nextVibratorCallbackStepId(getVibratorId());     // Catch: Throwable -> L13
        long vibratorOnResult = this.controller.on(pwlesArray, getVibration().id, stepId);     // Catch: Throwable -> L13
        handleVibratorOnResult(vibratorOnResult);     // Catch: Throwable -> L13
        getVibration().stats.reportComposePwle(vibratorOnResult, pwlesArray);     // Catch: Throwable -> L13
        List<Step> r7 = nextSteps(pwles.size());     // Catch: Throwable -> L13
        Trace.traceEnd(8388608);
        return r7;
    L6:
        r5 = 100;
    L13:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    private List<RampSegment> unrollRampSegments(VibrationEffect.Composed effect, int startIndex, int limit) {
        List<RampSegment> segments = new ArrayList(limit);
        float bestBreakAmplitude = 1.0f;
        int bestBreakPosition = limit;
        int segmentCount = effect.getSegments().size();
        int repeatIndex = effect.getRepeatIndex();
        int i = startIndex;
    L4:
        if (segments.size() > limit) goto L14;
        if (i != segmentCount) goto L8;
        if (repeatIndex < 0) goto L14;
        i = repeatIndex;
    L8:
        VibrationEffectSegment segment = (VibrationEffectSegment) effect.getSegments().get(i);
        if ((segment instanceof RampSegment) == false) goto L14;
        RampSegment rampSegment = (RampSegment) segment;
        segments.add(rampSegment);
        if (isBetterBreakPosition(segments, bestBreakAmplitude, limit) == false) goto L13;
        bestBreakAmplitude = rampSegment.getEndAmplitude();
        bestBreakPosition = segments.size();
    L13:
        i = i + 1;
    L14:
        int i2 = segments.size();
        if (i2 <= limit) goto L18;
        return segments.subList(0, bestBreakPosition);
    L18:
        return segments;
    }

    private boolean isBetterBreakPosition(List<RampSegment> segments, float currentBestBreakAmplitude, int limit) {
        RampSegment lastSegment = segments.get(segments.size() - 1);
        float breakAmplitudeCandidate = lastSegment.getEndAmplitude();
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
