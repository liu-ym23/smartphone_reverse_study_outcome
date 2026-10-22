package com.android.server.vibrator;

import android.os.VibratorInfo;
import android.os.vibrator.PwleSegment;
import android.os.vibrator.VibrationEffectSegment;
import android.util.MathUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class SplitPwleSegmentsAdapter implements VibrationSegmentsAdapter {
    SplitPwleSegmentsAdapter() {
    }

    @Override // com.android.server.vibrator.VibrationSegmentsAdapter
    public int adaptToVibrator(VibratorInfo info, List<VibrationEffectSegment> segments, int repeatIndex) {
        if (info.hasCapability(4096) == true) goto L5;
        return repeatIndex;
    L5:
        int maxPwleDuration = info.getMaxEnvelopeEffectDurationMillis();
        if (maxPwleDuration > 0) goto L8;
        return repeatIndex;
    L8:
        int segmentCount = segments.size();
        int i = 0;
    L9:
        if (i >= segmentCount) goto L21;
        PwleSegment r3 = segments.get(i);
        if ((r3 instanceof PwleSegment) == false) goto L19;
        PwleSegment pwleSegment = r3;
        int splits = ((((int) pwleSegment.getDuration()) + maxPwleDuration) - 1) / maxPwleDuration;
        if (splits <= 1) goto L19;
        segments.remove(i);
        segments.addAll(i, splitPwleSegment(pwleSegment, splits));
        int addedSegments = splits - 1;
        if (repeatIndex <= i) goto L18;
        repeatIndex = repeatIndex + addedSegments;
    L18:
        i = i + addedSegments;
        segmentCount = segmentCount + addedSegments;
    L19:
        i = i + 1;
        goto L9
    L21:
        return repeatIndex;
    }

    private static List<PwleSegment> splitPwleSegment(PwleSegment pwleSegment, int splits) {
        List<PwleSegment> pwleSegments = new ArrayList(splits);
        float startFrequencyHz = pwleSegment.getStartFrequencyHz();
        float endFrequencyHz = pwleSegment.getEndFrequencyHz();
        long splitDuration = pwleSegment.getDuration() / ((long) splits);
        float previousAmplitude = pwleSegment.getStartAmplitude();
        int i = 1;
        float previousFrequencyHz = startFrequencyHz;
        float previousAmplitude2 = previousAmplitude;
        long accumulatedDuration = 0;
    L3:
        if (i >= splits) goto L5;
        long accumulatedDuration2 = accumulatedDuration + splitDuration;
        float durationRatio = accumulatedDuration2 / pwleSegment.getDuration();
        float interpolatedFrequency = MathUtils.lerp(startFrequencyHz, endFrequencyHz, durationRatio);
        float interpolatedAmplitude = MathUtils.lerp(pwleSegment.getStartAmplitude(), pwleSegment.getEndAmplitude(), durationRatio);
        PwleSegment pwleSplit = new PwleSegment(previousAmplitude2, interpolatedAmplitude, previousFrequencyHz, interpolatedFrequency, (int) splitDuration);
        pwleSegments.add(pwleSplit);
        previousAmplitude2 = pwleSplit.getEndAmplitude();
        previousFrequencyHz = pwleSplit.getEndFrequencyHz();
        i = i + 1;
        startFrequencyHz = startFrequencyHz;
        accumulatedDuration = accumulatedDuration2;
        goto L3
    L5:
        pwleSegments.add(new PwleSegment(previousAmplitude2, pwleSegment.getEndAmplitude(), previousFrequencyHz, endFrequencyHz, (int) (pwleSegment.getDuration() - accumulatedDuration)));
        return pwleSegments;
    }
}
