package com.android.server.vibrator;

import android.os.SystemClock;
import android.os.VibrationEffect;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractComposedVibratorStep extends AbstractVibratorStep {
    public final VibrationEffect.Composed effect;
    public final int segmentIndex;

    AbstractComposedVibratorStep(VibrationStepConductor conductor, long startTime, VibratorController controller, VibrationEffect.Composed effect, int index, long pendingVibratorOffDeadline) {
        super(conductor, startTime, controller, pendingVibratorOffDeadline);
        this.effect = effect;
        this.segmentIndex = index;
    }

    protected List<Step> nextSteps(int segmentsPlayed) {
        long nextStartTime = SystemClock.uptimeMillis();
        if (this.mVibratorOnResult <= 0) goto L6;
        nextStartTime = nextStartTime + this.mVibratorOnResult;
    L6:
        return nextSteps(nextStartTime, segmentsPlayed);
    }

    protected List<Step> nextSteps(long nextStartTime, int segmentsPlayed) {
        int nextSegmentIndex = this.segmentIndex + segmentsPlayed;
        int effectSize = this.effect.getSegments().size();
        int repeatIndex = this.effect.getRepeatIndex();
        if (nextSegmentIndex < effectSize) goto L6;
        if (repeatIndex < 0) goto L6;
        int loopSize = effectSize - repeatIndex;
        int loopSegmentsPlayed = nextSegmentIndex - repeatIndex;
        getVibration().stats.reportRepetition(loopSegmentsPlayed / loopSize);
        int nextSegmentIndex2 = repeatIndex + ((nextSegmentIndex - effectSize) % loopSize);
    L7:
        Step nextStep = this.conductor.nextVibrateStep(nextStartTime, this.controller, this.effect, nextSegmentIndex2, this.mPendingVibratorOffDeadline);
        return List.of(nextStep);
    L6:
        nextSegmentIndex2 = nextSegmentIndex;
        goto L7
    }
}
