package com.stepos.core.ability.speech;

import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VadAdaptiveSpeechGate {
    public static final int CALIBRATION_FRAMES = 32;
    public static final Companion Companion = new Companion(null);
    public static final float MAX_GATE_RMS = 0.2f;
    public static final int MIN_NOISE_SAMPLES = 8;
    public static final float RMS_MARGIN = 1.8f;
    private float adaptiveGateRms;
    private int calibrationFramesSeen;
    private VadRuntimeConfig config;
    private float effectiveMinRms;
    private int noiseSampleCount;
    private final float[] noiseSamples;
    private String pendingCalibrationLog;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public VadAdaptiveSpeechGate(VadRuntimeConfig config) {
        kotlin.jvm.internal.g.f(config, "config");
        this.config = config;
        this.noiseSamples = new float[32];
        this.effectiveMinRms = config.getMinSpeechRms();
    }

    private final void calibrate(float f8, float f9) {
        int i10 = this.calibrationFramesSeen;
        if (i10 >= 32) {
            return;
        }
        this.calibrationFramesSeen = i10 + 1;
        if (f8 < this.config.getThreshold() && !Float.isInfinite(f9) && !Float.isNaN(f9)) {
            float[] fArr = this.noiseSamples;
            int i11 = this.noiseSampleCount;
            this.noiseSampleCount = i11 + 1;
            fArr[i11] = f9;
        }
        if (this.calibrationFramesSeen < 32) {
            return;
        }
        String strG = ai.onnxruntime.a.g(this.noiseSampleCount, "noiseSamples=", "/32");
        int i12 = this.noiseSampleCount;
        if (i12 < 8) {
            this.pendingCalibrationLog = com.stepos.core.ota.d.i(strG, " adaptive=off(need 8) effectiveMin=", f(this.config.getMinSpeechRms()));
            return;
        }
        float fMedianOf = medianOf(this.noiseSamples, i12);
        float f10 = 1.8f * fMedianOf;
        if (f10 > 0.2f) {
            f10 = 0.2f;
        }
        this.adaptiveGateRms = f10;
        String str = f10 >= 0.2f ? "(capped)" : "";
        String str2 = f10 > this.config.getMinSpeechRms() ? "adaptive" : "config";
        String strF = f(fMedianOf);
        String strF2 = f(this.adaptiveGateRms);
        String strF3 = f(Math.max(this.config.getMinSpeechRms(), this.adaptiveGateRms));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strG);
        sb2.append(" noiseFloor=");
        sb2.append(strF);
        sb2.append(" adaptive=");
        sb2.append(strF2);
        ai.onnxruntime.a.z(sb2, str, " effectiveMin=", strF3, "(");
        this.pendingCalibrationLog = ai.onnxruntime.a.o(sb2, str2, " wins)");
    }

    private final String f(float f8) {
        return String.format("%.4f", Arrays.copyOf(new Object[]{Float.valueOf(f8)}, 1));
    }

    private final float medianOf(float[] fArr, int i10) {
        float[] fArrCopyOf = Arrays.copyOf(fArr, i10);
        kotlin.jvm.internal.g.e(fArrCopyOf, "copyOf(...)");
        if (fArrCopyOf.length > 1) {
            Arrays.sort(fArrCopyOf);
        }
        int i11 = i10 / 2;
        return i10 % 2 == 1 ? fArrCopyOf[i11] : (fArrCopyOf[i11 - 1] + fArrCopyOf[i11]) / 2.0f;
    }

    public final void applyConfig(VadRuntimeConfig newConfig) {
        kotlin.jvm.internal.g.f(newConfig, "newConfig");
        this.config = newConfig;
        this.noiseSampleCount = 0;
        this.calibrationFramesSeen = 0;
        this.adaptiveGateRms = 0.0f;
        this.effectiveMinRms = newConfig.getMinSpeechRms();
        this.pendingCalibrationLog = null;
    }

    public final float getEffectiveMinRms() {
        return this.effectiveMinRms;
    }

    public final boolean isSpeech(float f8, float f9) {
        calibrate(f8, f9);
        this.effectiveMinRms = Math.max(this.config.getMinSpeechRms(), this.adaptiveGateRms);
        return VadSpeechGate.INSTANCE.passes(f8, this.config.getThreshold(), f9, this.effectiveMinRms);
    }

    public final String takeCalibrationLog() {
        String str = this.pendingCalibrationLog;
        if (str == null) {
            return null;
        }
        this.pendingCalibrationLog = null;
        return str;
    }
}
