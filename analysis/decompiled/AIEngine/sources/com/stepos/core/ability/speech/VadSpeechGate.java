package com.stepos.core.ability.speech;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VadSpeechGate {
    private static final double FULL_SCALE = 32768.0d;
    public static final VadSpeechGate INSTANCE = new VadSpeechGate();

    private VadSpeechGate() {
    }

    public final float frameRms(short[] frame) {
        kotlin.jvm.internal.g.f(frame, "frame");
        if (frame.length == 0) {
            return 0.0f;
        }
        double d8 = 0.0d;
        for (double d10 : frame) {
            d8 += d10 * d10;
        }
        return (float) (Math.sqrt(d8 / frame.length) / FULL_SCALE);
    }

    public final boolean isSpeech(float f8, float f9, VadRuntimeConfig config) {
        kotlin.jvm.internal.g.f(config, "config");
        return passes(f8, config.getThreshold(), f9, config.getMinSpeechRms());
    }

    public final boolean passes(float f8, float f9, float f10, float f11) {
        return f8 >= f9 && f10 >= f11;
    }
}
