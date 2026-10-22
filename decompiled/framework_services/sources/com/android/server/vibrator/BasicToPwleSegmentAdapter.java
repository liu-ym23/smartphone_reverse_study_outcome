package com.android.server.vibrator;

import android.os.VibratorInfo;
import android.os.vibrator.BasicPwleSegment;
import android.os.vibrator.PwleSegment;
import android.os.vibrator.VibrationEffectSegment;
import android.util.MathUtils;
import android.util.Pair;
import android.util.Slog;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class BasicToPwleSegmentAdapter implements VibrationSegmentsAdapter {
    private static final Pair<Float, Float>[] MIN_PERCEPTIBLE_CURVE = null;
    private static final int MIN_REQUIRED_SENSITIVITY_DB_SL = 10;
    private static final String TAG = "BasicToPwleSegmentAdapter";
    private static final float[] sMinPerceptibleAccelerationsDb = null;
    private static final float[] sMinPerceptibleFrequenciesHz = null;

    public static /* synthetic */ Float $r8$lambda$GQiBKIxHj6463EfUdNjK_QeP7io(Pair r0) {
        return lambda$new$0(r0);
    }

    static {
        Float r1 = Float.valueOf(50.0f);
        Float r2 = Float.valueOf(-31.94f);
        Float r3 = Float.valueOf(60.0f);
        Float r4 = Float.valueOf(-31.77f);
        MIN_PERCEPTIBLE_CURVE = new Pair[]{Pair.create(Float.valueOf(0.4f), Float.valueOf(-97.81f)), Pair.create(Float.valueOf(2.0f), Float.valueOf(-69.86f)), Pair.create(Float.valueOf(3.0f), Float.valueOf(-62.81f)), Pair.create(Float.valueOf(4.0f), Float.valueOf(-58.81f)), Pair.create(Float.valueOf(5.0f), Float.valueOf(-56.69f)), Pair.create(Float.valueOf(6.0f), Float.valueOf(-54.77f)), Pair.create(Float.valueOf(7.2f), Float.valueOf(-52.85f)), Pair.create(Float.valueOf(8.0f), Float.valueOf(-51.77f)), Pair.create(Float.valueOf(8.64f), Float.valueOf(-50.84f)), Pair.create(Float.valueOf(10.0f), Float.valueOf(-48.9f)), Pair.create(Float.valueOf(10.37f), Float.valueOf(-48.52f)), Pair.create(Float.valueOf(12.44f), Float.valueOf(-46.5f)), Pair.create(Float.valueOf(14.93f), Float.valueOf(-44.43f)), Pair.create(Float.valueOf(15.0f), Float.valueOf(-44.35f)), Pair.create(Float.valueOf(17.92f), Float.valueOf(-41.96f)), Pair.create(Float.valueOf(20.0f), Float.valueOf(-40.36f)), Pair.create(Float.valueOf(21.5f), Float.valueOf(-39.6f)), Pair.create(Float.valueOf(25.0f), Float.valueOf(-37.48f)), Pair.create(Float.valueOf(25.8f), Float.valueOf(-36.93f)), Pair.create(Float.valueOf(30.0f), Float.valueOf(-34.31f)), Pair.create(Float.valueOf(35.0f), Float.valueOf(-33.13f)), Pair.create(Float.valueOf(40.0f), Float.valueOf(-32.81f)), Pair.create(r1, r2), Pair.create(r3, r4), Pair.create(Float.valueOf(70.0f), Float.valueOf(-31.59f)), Pair.create(Float.valueOf(72.0f), Float.valueOf(-31.55f)), Pair.create(Float.valueOf(80.0f), r4), Pair.create(Float.valueOf(86.4f), r2), Pair.create(Float.valueOf(90.0f), Float.valueOf(-31.73f)), Pair.create(Float.valueOf(100.0f), Float.valueOf(-31.9f)), Pair.create(Float.valueOf(103.68f), r4), Pair.create(Float.valueOf(124.42f), Float.valueOf(-31.7f)), Pair.create(Float.valueOf(149.3f), Float.valueOf(-31.38f)), Pair.create(Float.valueOf(150.0f), Float.valueOf(-31.35f)), Pair.create(Float.valueOf(179.16f), Float.valueOf(-31.02f)), Pair.create(Float.valueOf(200.0f), Float.valueOf(-30.86f)), Pair.create(Float.valueOf(215.0f), Float.valueOf(-30.35f)), Pair.create(Float.valueOf(250.0f), Float.valueOf(-28.98f)), Pair.create(Float.valueOf(258.0f), Float.valueOf(-28.68f)), Pair.create(Float.valueOf(300.0f), Float.valueOf(-26.81f)), Pair.create(Float.valueOf(400.0f), Float.valueOf(-19.81f))};
        sMinPerceptibleFrequenciesHz = new float[MIN_PERCEPTIBLE_CURVE.length];
        sMinPerceptibleAccelerationsDb = new float[MIN_PERCEPTIBLE_CURVE.length];
    }

    BasicToPwleSegmentAdapter() {
        Arrays.sort(MIN_PERCEPTIBLE_CURVE, Comparator.comparing(new BasicToPwleSegmentAdapter$$ExternalSyntheticLambda0()));
        int i = 0;
    L4:
        if (i >= MIN_PERCEPTIBLE_CURVE.length) goto L7;
        sMinPerceptibleFrequenciesHz[i] = ((Float) MIN_PERCEPTIBLE_CURVE[i].first).floatValue();
        sMinPerceptibleAccelerationsDb[i] = ((Float) MIN_PERCEPTIBLE_CURVE[i].second).floatValue();
        i = i + 1;
        goto L4
    }

    private static /* synthetic */ Float lambda$new$0(Pair pair) {
        return (Float) pair.first;
    }

    @Override // com.android.server.vibrator.VibrationSegmentsAdapter
    public int adaptToVibrator(VibratorInfo info, List<VibrationEffectSegment> segments, int repeatIndex) {
        if (info.hasCapability(4096) == true) goto L5;
        return repeatIndex;
    L5:
        VibratorInfo.FrequencyProfile frequencyProfile = info.getFrequencyProfile();
        if (frequencyProfile.isEmpty() == false) goto L8;
        return repeatIndex;
    L8:
        float[] frequenciesHz = frequencyProfile.getFrequenciesHz();
        float[] accelerationsGs = frequencyProfile.getOutputAccelerationsGs();
        frequenciesHz.getClass();
        accelerationsGs.getClass();
        Pair<Float, Float> frequencyRangeHz = calculateFrequencyRangeHz(frequenciesHz, accelerationsGs);
        if (frequencyRangeHz != null) goto L11;
        return repeatIndex;
    L11:
        float minFrequencyHz = ((Float) frequencyRangeHz.first).floatValue();
        float maxFrequencyHz = ((Float) frequencyRangeHz.second).floatValue();
        float maxSensitivityLevel = getMaxSensitivityLevel(frequenciesHz, accelerationsGs, minFrequencyHz, maxFrequencyHz);
        int i = 0;
    L13:
        if (i >= segments.size()) goto L19;
        BasicPwleSegment r8 = (VibrationEffectSegment) segments.get(i);
        if ((r8 instanceof BasicPwleSegment) == false) goto L17;
        BasicPwleSegment basicPwleSegment = r8;
        PwleSegment pwleSegment = convertBasicToPwleSegment(frequencyProfile, basicPwleSegment, minFrequencyHz, maxFrequencyHz, maxSensitivityLevel);
        segments.set(i, pwleSegment);
    L17:
        i = i + 1;
        goto L13
    L19:
        return repeatIndex;
    }

    private static Pair<Float, Float> calculateFrequencyRangeHz(float[] frequenciesHz, float[] accelerationsGs) {
        float minFrequencyHz = Float.NaN;
        int i = 0;
    L4:
        if (i >= frequenciesHz.length) goto L20;
        float minAcceptableOutputAcceleration = convertSensitivityLevelToAccelerationGs(10.0f, frequenciesHz[i]);
        if (Float.isNaN(minFrequencyHz) == false) goto L13;
        if (minAcceptableOutputAcceleration > accelerationsGs[i]) goto L13;
        if (i != 0) goto L11;
        minFrequencyHz = frequenciesHz[0];
    L18:
        i = i + 1;
        goto L4
    L11:
        minFrequencyHz = MathUtils.constrainedMap(frequenciesHz[i - 1], frequenciesHz[i], accelerationsGs[i - 1], accelerationsGs[i], minAcceptableOutputAcceleration);
    L13:
        if (Float.isNaN(minFrequencyHz) == true) goto L18;
        if (minAcceptableOutputAcceleration < accelerationsGs[i]) goto L18;
        float maxFrequencyHz = MathUtils.constrainedMap(frequenciesHz[i - 1], frequenciesHz[i], accelerationsGs[i - 1], accelerationsGs[i], minAcceptableOutputAcceleration);
        return new Pair(Float.valueOf(minFrequencyHz), Float.valueOf(maxFrequencyHz));
    L20:
        if (Float.isNaN(minFrequencyHz) == false) goto L23;
        Slog.e(TAG, "Failed to retrieve frequency range. A valid frequency range must be available to create envelope vibration effects.");
        return null;
    L23:
        float maxFrequencyHz2 = frequenciesHz[frequenciesHz.length - 1];
        return new Pair(Float.valueOf(minFrequencyHz), Float.valueOf(maxFrequencyHz2));
    }

    private static PwleSegment convertBasicToPwleSegment(VibratorInfo.FrequencyProfile frequencyProfile, BasicPwleSegment basicPwleSegment, float minFrequencyHz, float maxFrequencyHz, float maxSensitivityLevel) {
        float startFrequency = convertSharpnessToFrequencyHz(basicPwleSegment.getStartSharpness(), minFrequencyHz, maxFrequencyHz);
        float endFrequency = convertSharpnessToFrequencyHz(basicPwleSegment.getEndSharpness(), minFrequencyHz, maxFrequencyHz);
        float startAmplitude = convertIntensityToAmplitude(frequencyProfile, basicPwleSegment.getStartIntensity(), startFrequency, maxSensitivityLevel);
        float endAmplitude = convertIntensityToAmplitude(frequencyProfile, basicPwleSegment.getEndIntensity(), endFrequency, maxSensitivityLevel);
        return new PwleSegment(startAmplitude, endAmplitude, startFrequency, endFrequency, basicPwleSegment.getDuration());
    }

    private static float convertIntensityToAmplitude(VibratorInfo.FrequencyProfile frequencyProfile, float intensity, float frequencyHz, float maxSensitivityLevel) {
        if (intensity != 0.0f) goto L5;
        return 0.0f;
    L5:
        float desiredAcceleration = convertIntensityToAccelerationGs(intensity, frequencyHz, maxSensitivityLevel);
        float availableAcceleration = frequencyProfile.getOutputAccelerationGs(frequencyHz);
        if (desiredAcceleration < availableAcceleration) goto L9;
        return 1.0f;
    L9:
        return desiredAcceleration / availableAcceleration;
    }

    private static float getMaxSensitivityLevel(float[] frequenciesHz, float[] accelerationsGs, float minFrequencyHz, float maxFrequencyHz) {
        float maxAccelerationGs = Float.MIN_VALUE;
        int maxAccelerationIndex = -1;
        int i = 0;
    L4:
        if (i >= frequenciesHz.length) goto L16;
        float frequency = frequenciesHz[i];
        if (frequency < minFrequencyHz) goto L14;
        if (frequency > maxFrequencyHz) goto L16;
        if (accelerationsGs[i] <= maxAccelerationGs) goto L14;
        maxAccelerationGs = accelerationsGs[i];
        maxAccelerationIndex = i;
    L14:
        i = i + 1;
    L16:
        return convertDecibelToSensitivityLevel(convertAccelerationToDecibel(maxAccelerationGs), frequenciesHz[maxAccelerationIndex]);
    }

    private static float convertSharpnessToFrequencyHz(float sharpness, float minFrequencyHz, float maxFrequencyHz) {
        return ((maxFrequencyHz - minFrequencyHz) * sharpness) + minFrequencyHz;
    }

    private static float convertIntensityToAccelerationGs(float intensity, float frequencyHz, float maxSensitivityLevel) {
        return convertSensitivityLevelToAccelerationGs(intensity * maxSensitivityLevel, frequencyHz);
    }

    private static float convertSensitivityLevelToAccelerationGs(float sensitivityLevel, float frequencyHz) {
        return convertDecibelToAccelerationGs(convertSensitivityLevelToDecibel(sensitivityLevel, frequencyHz));
    }

    private static float convertDecibelToAccelerationGs(float db) {
        return (float) Math.pow(10.0d, db / 20.0f);
    }

    private static float convertSensitivityLevelToDecibel(float sensitivityLevel, float frequencyHz) {
        float minPerceptibleDbAtFrequency = getMinPerceptibleAccelerationDb(frequencyHz);
        return sensitivityLevel + minPerceptibleDbAtFrequency;
    }

    private static float convertAccelerationToDecibel(float accelerationGs) {
        return (float) (Math.log10(accelerationGs) * 20.0d);
    }

    private static float convertDecibelToSensitivityLevel(float db, float frequencyHz) {
        float minPerceptibleDbAtFrequency = getMinPerceptibleAccelerationDb(frequencyHz);
        return db - minPerceptibleDbAtFrequency;
    }

    private static float getMinPerceptibleAccelerationDb(float frequencyHz) {
        if (frequencyHz > sMinPerceptibleFrequenciesHz[0]) goto L7;
        return sMinPerceptibleAccelerationsDb[0];
    L7:
        if (frequencyHz >= sMinPerceptibleFrequenciesHz[sMinPerceptibleFrequenciesHz.length - 1]) goto L9;
        int idx = Arrays.binarySearch(sMinPerceptibleFrequenciesHz, frequencyHz);
        if (idx >= 0) goto L13;
        int idx2 = (-idx) - 2;
        return MathUtils.constrainedMap(sMinPerceptibleAccelerationsDb[idx2], sMinPerceptibleAccelerationsDb[idx2 + 1], sMinPerceptibleFrequenciesHz[idx2], sMinPerceptibleFrequenciesHz[idx2 + 1], frequencyHz);
    L13:
        return sMinPerceptibleAccelerationsDb[idx];
    L9:
        return sMinPerceptibleAccelerationsDb[sMinPerceptibleAccelerationsDb.length - 1];
    }
}
