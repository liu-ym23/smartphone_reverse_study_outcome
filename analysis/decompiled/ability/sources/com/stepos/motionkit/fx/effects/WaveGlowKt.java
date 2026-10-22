package com.stepos.motionkit.fx.effects;

import C7.r;
import H4.o;
import com.stepos.motionkit.BackendHint;
import com.stepos.motionkit.EffectDefinition;
import com.stepos.motionkit.UniformSpec;
import com.stepos.motionkit.fx.anim.AnimationBuilder;
import com.stepos.motionkit.fx.anim.AnimationDslKt;
import com.stepos.motionkit.fx.anim.TrackBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import t5.C2016a;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"WaveGlow", "Lcom/stepos/motionkit/EffectDefinition;", "getWaveGlow", "()Lcom/stepos/motionkit/EffectDefinition;", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WaveGlowKt {
    private static final EffectDefinition WaveGlow;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        e eVar = null;
        e eVar2 = null;
        WaveGlow = new EffectDefinition("WaveGlow", "sf_wave_glow.agsl", null, o.N(new UniformSpec.Float1("enableWave", 1.0f, null, null, 12, null), new UniformSpec.Float1("enableGlow", 1.0f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("horizontal", 0.0f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("circleCenterLocationRatio", 0.4f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("waveTime", 0.0f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("circleRadius", 0.0f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("percent", 0.0f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float2("circleOffset", 0.0f, 250.0f, null, 8, null), new UniformSpec.Float1("feather", 300.0f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("alpha", 0.0f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("alphaValue", 0.0f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("displacement", 0.0f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float3("colorSet1", 1.0f, 0.306f, 0.0f, 0 == true ? 1 : 0, 16, null), new UniformSpec.Float3("colorSet2", 0.102f, 0.251f, 1.0f, null, 16, null), new UniformSpec.Float3("colorSet3", 0.4f, 0.102f, 1.0f, null, 16, null), new UniformSpec.Float3("colorSet4", 1.0f, 0.549f, 0.102f, null, 16, null), new UniformSpec.Float3("colorSet5", 1.0f, 0.749f, 0.063f, null, 16, eVar), new UniformSpec.Float1("time", 0.0f, null, 0 == true ? 1 : 0, 12, eVar), new UniformSpec.Float1("speed", 0.55f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("glowIntensity", 1.8f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("radiusRatio", 0.1f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("glowRadiusRatio", 1.0f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("innerGlowStrength", 1.0f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("innerGlowSpread", 0.0f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("noiseStrength", 0.5f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("inner", 1.0f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float4("color1", 0.443f, 0.388f, 0.992f, 1.0f, null, 32, null), new UniformSpec.Float4("color2", 0.176f, 0.149f, 0.973f, 1.0f, null, 32, null), new UniformSpec.Float4("color3", 0.486f, 0.169f, 0.98f, 1.0f, null, 32, null), new UniformSpec.Float4("color4", 0.988f, 0.267f, 0.71f, 1.0f, null, 32, null), new UniformSpec.Float4("color5", 1.0f, 0.749f, 0.063f, 1.0f, null, 32, eVar2), new UniformSpec.Float1("maskSizeX", 0.78f, null, null, 12, null), new UniformSpec.Float1("maskSizeY", 0.88f, 0 == true ? 1 : 0, null, 12, eVar2), new UniformSpec.Float1("cornerRadius", 0.1f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("edgeBlur", 110.0f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("visibleHeight", 0.0f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("glowAlpha", 0.0f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float1("fadeAlpha", 1.0f, 0 == true ? 1 : 0, null, 12, null)), BackendHint.SF, true, AnimationDslKt.animation(new C2016a(6)), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r WaveGlow$lambda$11(AnimationBuilder animation) {
        k.f(animation, "$this$animation");
        AnimationBuilder.track$default(animation, "waveTime", 0, new C2016a(4), 2, null);
        AnimationBuilder.track$default(animation, "circleRadius", 0, new C2016a(8), 2, null);
        AnimationBuilder.track$default(animation, "percent", 0, new C2016a(9), 2, null);
        animation.track("circleOffset", 1, new C2016a(10));
        AnimationBuilder.track$default(animation, "alpha", 0, new C2016a(11), 2, null);
        AnimationBuilder.track$default(animation, "alphaValue", 0, new C2016a(12), 2, null);
        AnimationBuilder.track$default(animation, "displacement", 0, new C2016a(13), 2, null);
        AnimationBuilder.track$default(animation, "time", 0, new C2016a(14), 2, null);
        AnimationBuilder.track$default(animation, "glowIntensity", 0, new C2016a(15), 2, null);
        AnimationBuilder.track$default(animation, "glowAlpha", 0, new C2016a(5), 2, null);
        AnimationBuilder.track$default(animation, "visibleHeight", 0, new C2016a(7), 2, null);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r WaveGlow$lambda$11$lambda$0(TrackBuilder track) {
        k.f(track, "$this$track");
        track.linear(2.0f);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r WaveGlow$lambda$11$lambda$1(TrackBuilder track) {
        k.f(track, "$this$track");
        track.sawtooth(0.0f, 3200.0f, 2200L);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r WaveGlow$lambda$11$lambda$10(TrackBuilder track) {
        k.f(track, "$this$track");
        track.duration(track.to(0.0f, 0.35f), 600L);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r WaveGlow$lambda$11$lambda$2(TrackBuilder track) {
        k.f(track, "$this$track");
        track.sawtooth(0.0f, 1.0f, 2200L);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r WaveGlow$lambda$11$lambda$3(TrackBuilder track) {
        k.f(track, "$this$track");
        track.sawtooth(250.0f, -1200.0f, 2200L);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r WaveGlow$lambda$11$lambda$4(TrackBuilder track) {
        k.f(track, "$this$track");
        track.duration(track.to(0.0f, 0.9f), 600L);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r WaveGlow$lambda$11$lambda$5(TrackBuilder track) {
        k.f(track, "$this$track");
        track.duration(track.to(0.0f, 0.65f), 600L);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r WaveGlow$lambda$11$lambda$6(TrackBuilder track) {
        k.f(track, "$this$track");
        track.duration(track.to(0.0f, 18.0f), 600L);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r WaveGlow$lambda$11$lambda$7(TrackBuilder track) {
        k.f(track, "$this$track");
        track.linear(1.0f);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r WaveGlow$lambda$11$lambda$8(TrackBuilder track) {
        k.f(track, "$this$track");
        track.triangleWave(1.8f, 2.2f, 3000L);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r WaveGlow$lambda$11$lambda$9(TrackBuilder track) {
        k.f(track, "$this$track");
        track.delay(track.duration(track.to(0.0f, 1.0f), 600L), 200L);
        return r.f317a;
    }

    public static final EffectDefinition getWaveGlow() {
        return WaveGlow;
    }
}
