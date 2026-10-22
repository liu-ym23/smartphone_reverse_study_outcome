package com.android.server.vibrator;

import android.os.VibratorInfo;
import android.os.vibrator.RampSegment;
import android.os.vibrator.StepSegment;
import android.os.vibrator.VibrationEffectSegment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class RampDownAdapter implements VibrationSegmentsAdapter {
    private final int mRampDownDuration;
    private final int mStepDuration;

    RampDownAdapter(int rampDownDuration, int stepDuration) {
        this.mRampDownDuration = rampDownDuration;
        this.mStepDuration = stepDuration;
    }

    @Override // com.android.server.vibrator.VibrationSegmentsAdapter
    public int adaptToVibrator(VibratorInfo info, List<VibrationEffectSegment> segments, int repeatIndex) {
        if (this.mRampDownDuration > 0) goto L6;
        return repeatIndex;
    L6:
        return addRampDownToLoop(segments, addRampDownToZeroAmplitudeSegments(segments, repeatIndex));
    }

    private int addRampDownToZeroAmplitudeSegments(List<VibrationEffectSegment> segments, int repeatIndex) {
        int segmentCount = segments.size();
        int i = 1;
    L3:
        if (i >= segmentCount) goto L28;
        StepSegment r2 = (VibrationEffectSegment) segments.get(i - 1);
        if (isOffSegment(segments.get(i)) == false) goto L26;
        if (endsWithNonZeroAmplitude(r2) == false) goto L26;
        List<VibrationEffectSegment> replacementSegments = null;
        long offDuration = segments.get(i).getDuration();
        if ((r2 instanceof StepSegment) == false) goto L14;
        replacementSegments = createStepsDown(r2.getAmplitude(), r2.getFrequencyHz(), offDuration);
    L19:
        if (replacementSegments == null) goto L26;
        int segmentsAdded = replacementSegments.size() - 1;
        VibrationEffectSegment originalOffSegment = segments.remove(i);
        segments.addAll(i, replacementSegments);
        if (repeatIndex < i) goto L25;
        if (repeatIndex != i) goto L24;
        segments.add(originalOffSegment);
        repeatIndex = repeatIndex + 1;
        segmentCount = segmentCount + 1;
    L24:
        repeatIndex = repeatIndex + segmentsAdded;
    L25:
        i = i + segmentsAdded;
        segmentCount = segmentCount + segmentsAdded;
        goto L26
    L14:
        if ((r2 instanceof RampSegment) == false) goto L19;
        float previousAmplitude = ((RampSegment) r2).getEndAmplitude();
        float previousFrequency = ((RampSegment) r2).getEndFrequencyHz();
        if (offDuration > this.mRampDownDuration) goto L18;
        replacementSegments = Arrays.asList(new VibrationEffectSegment[]{createRampDown(previousAmplitude, previousFrequency, offDuration)});
        goto L19
    L18:
        replacementSegments = Arrays.asList(new VibrationEffectSegment[]{createRampDown(previousAmplitude, previousFrequency, this.mRampDownDuration), createRampDown(0.0f, previousFrequency, offDuration - ((long) this.mRampDownDuration))});
    L26:
        i = i + 1;
        goto L3
    L28:
        return repeatIndex;
    }

    private int addRampDownToLoop(List<VibrationEffectSegment> segments, int repeatIndex) {
        if (repeatIndex >= 0) goto L4;
        return repeatIndex;
    L4:
        int segmentCount = segments.size();
        if (endsWithNonZeroAmplitude(segments.get(segmentCount - 1)) == true) goto L7;
    L20:
        return repeatIndex;
    L7:
        if (isOffSegment(segments.get(repeatIndex)) == false) goto L20;
        StepSegment r1 = (VibrationEffectSegment) segments.get(segmentCount - 1);
        VibrationEffectSegment offSegment = segments.get(repeatIndex);
        long offDuration = offSegment.getDuration();
        if (offDuration <= this.mRampDownDuration) goto L12;
        segments.set(repeatIndex, updateDuration(offSegment, offDuration - ((long) this.mRampDownDuration)));
        segments.add(repeatIndex, updateDuration(offSegment, this.mRampDownDuration));
    L12:
        int repeatIndex2 = repeatIndex + 1;
        if ((r1 instanceof StepSegment) == false) goto L17;
        float previousAmplitude = r1.getAmplitude();
        float previousFrequency = r1.getFrequencyHz();
        segments.addAll(createStepsDown(previousAmplitude, previousFrequency, Math.min(offDuration, this.mRampDownDuration)));
    L19:
        return repeatIndex2;
    L17:
        if ((r1 instanceof RampSegment) == false) goto L19;
        float previousAmplitude2 = ((RampSegment) r1).getEndAmplitude();
        float previousFrequency2 = ((RampSegment) r1).getEndFrequencyHz();
        segments.add(createRampDown(previousAmplitude2, previousFrequency2, Math.min(offDuration, this.mRampDownDuration)));
        goto L19
    }

    private List<VibrationEffectSegment> createStepsDown(float amplitude, float frequency, long duration) {
        int stepCount = ((int) Math.min(duration, this.mRampDownDuration)) / this.mStepDuration;
        float amplitudeStep = amplitude / stepCount;
        List<VibrationEffectSegment> steps = new ArrayList();
        int i = 1;
    L3:
        if (i >= stepCount) goto L5;
        steps.add(new StepSegment(amplitude - (i * amplitudeStep), frequency, this.mStepDuration));
        i = i + 1;
        goto L3
    L5:
        int i2 = (int) duration;
        int remainingDuration = i2 - (this.mStepDuration * (stepCount - 1));
        steps.add(new StepSegment(0.0f, frequency, remainingDuration));
        return steps;
    }

    private static RampSegment createRampDown(float amplitude, float frequency, long duration) {
        return new RampSegment(amplitude, 0.0f, frequency, frequency, (int) duration);
    }

    private static VibrationEffectSegment updateDuration(VibrationEffectSegment segment, long newDuration) {
        if ((segment instanceof RampSegment) == false) goto L7;
        RampSegment ramp = (RampSegment) segment;
        return new RampSegment(ramp.getStartAmplitude(), ramp.getEndAmplitude(), ramp.getStartFrequencyHz(), ramp.getEndFrequencyHz(), (int) newDuration);
    L7:
        if ((segment instanceof StepSegment) == false) goto L10;
        StepSegment step = (StepSegment) segment;
        return new StepSegment(step.getAmplitude(), step.getFrequencyHz(), (int) newDuration);
    L10:
        return segment;
    }

    private static boolean isOffSegment(VibrationEffectSegment segment) {
        if ((segment instanceof StepSegment) == false) goto L10;
        if (((StepSegment) segment).getAmplitude() != 0.0f) goto L8;
        return true;
    L8:
        return false;
    L10:
        if ((segment instanceof RampSegment) == false) goto L18;
        RampSegment ramp = (RampSegment) segment;
        if (ramp.getStartAmplitude() != 0.0f) goto L17;
        if (ramp.getEndAmplitude() != 0.0f) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    private static boolean endsWithNonZeroAmplitude(VibrationEffectSegment segment) {
        if ((segment instanceof StepSegment) == false) goto L10;
        if (((StepSegment) segment).getAmplitude() == 0.0f) goto L8;
        return true;
    L8:
        return false;
    L10:
        if ((segment instanceof RampSegment) == true) goto L12;
        return false;
    L12:
        if (((RampSegment) segment).getEndAmplitude() == 0.0f) goto L15;
        return true;
    L15:
        return false;
    }
}
