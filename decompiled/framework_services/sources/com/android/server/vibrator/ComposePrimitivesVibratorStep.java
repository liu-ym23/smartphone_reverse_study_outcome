package com.android.server.vibrator;

import android.os.Trace;
import android.os.VibrationEffect;
import android.os.vibrator.PrimitiveSegment;
import android.os.vibrator.VibrationEffectSegment;
import android.util.Slog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class ComposePrimitivesVibratorStep extends AbstractComposedVibratorStep {
    private static final int DEFAULT_COMPOSITION_SIZE_LIMIT = 100;

    ComposePrimitivesVibratorStep(VibrationStepConductor conductor, long startTime, VibratorController controller, VibrationEffect.Composed effect, int index, long pendingVibratorOffDeadline) {
        super(conductor, Math.max(startTime, pendingVibratorOffDeadline), controller, effect, index, pendingVibratorOffDeadline);
    }

    @Override // com.android.server.vibrator.Step
    public List<Step> play() {
        Trace.traceBegin(8388608, "ComposePrimitivesStep");
        int limit = this.controller.getVibratorInfo().getCompositionSizeMax();     // Catch: Throwable -> L13
        VibrationEffect.Composed r3 = this.effect;     // Catch: Throwable -> L13
        int r4 = this.segmentIndex;     // Catch: Throwable -> L13
        if (limit <= 0) goto L6;
        int r5 = limit;
    L7:
        List<PrimitiveSegment> primitives = unrollPrimitiveSegments(r3, r4, r5);     // Catch: Throwable -> L13
        if (primitives.isEmpty() == false) goto L16;
        Slog.w("VibrationThread", "Ignoring wrong segment for a ComposePrimitivesStep: " + this.effect.getSegments().get(this.segmentIndex));     // Catch: Throwable -> L13
        List<Step> r6 = nextSteps(1);     // Catch: Throwable -> L13
        Trace.traceEnd(8388608);
        return r6;
    L16:
        if (VibrationThread.DEBUG == false) goto L18;
        Slog.d("VibrationThread", "Compose " + primitives + " primitives on vibrator " + getVibratorId());     // Catch: Throwable -> L13
    L18:
        PrimitiveSegment[] primitivesArray = (PrimitiveSegment[]) primitives.toArray(new PrimitiveSegment[primitives.size()]);     // Catch: Throwable -> L13
        int stepId = this.conductor.nextVibratorCallbackStepId(getVibratorId());     // Catch: Throwable -> L13
        long vibratorOnResult = this.controller.on(primitivesArray, getVibration().id, stepId);     // Catch: Throwable -> L13
        handleVibratorOnResult(vibratorOnResult);     // Catch: Throwable -> L13
        getVibration().stats.reportComposePrimitives(vibratorOnResult, primitivesArray);     // Catch: Throwable -> L13
        List<Step> r7 = nextSteps(primitives.size());     // Catch: Throwable -> L13
        Trace.traceEnd(8388608);
        return r7;
    L6:
        r5 = 100;
    L13:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    private List<PrimitiveSegment> unrollPrimitiveSegments(VibrationEffect.Composed effect, int startIndex, int limit) {
        List<PrimitiveSegment> segments = new ArrayList(limit);
        int segmentCount = effect.getSegments().size();
        int repeatIndex = effect.getRepeatIndex();
        int i = startIndex;
    L4:
        if (segments.size() >= limit) goto L11;
        if (i != segmentCount) goto L8;
        if (repeatIndex < 0) goto L11;
        i = repeatIndex;
    L8:
        PrimitiveSegment r4 = (VibrationEffectSegment) effect.getSegments().get(i);
        if ((r4 instanceof PrimitiveSegment) == false) goto L11;
        segments.add(r4);
        i = i + 1;
    L11:
        return segments;
    }
}
