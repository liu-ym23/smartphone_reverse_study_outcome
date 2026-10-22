package com.stepos.motionkit.fx.effects;

import C7.r;
import H4.o;
import Y7.a;
import com.stepos.motionkit.BackendHint;
import com.stepos.motionkit.EasingType;
import com.stepos.motionkit.EffectDefinition;
import com.stepos.motionkit.UniformSpec;
import com.stepos.motionkit.fx.anim.AnimationBuilder;
import com.stepos.motionkit.fx.anim.AnimationDslKt;
import com.stepos.motionkit.fx.anim.SequenceBuilder;
import com.stepos.motionkit.fx.anim.TrackBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"EdgeBlurDispersion", "Lcom/stepos/motionkit/EffectDefinition;", "getEdgeBlurDispersion", "()Lcom/stepos/motionkit/EffectDefinition;", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EdgeBlurDispersionKt {
    private static final EffectDefinition EdgeBlurDispersion = new EffectDefinition("EdgeBlurDispersion", "edge_blur_dispersion.agsl", null, o.N(new UniformSpec.Float1("blurStrength", 18.0f, new a(0.0f, 40.0f), "模糊强度(px)"), new UniformSpec.Float1("dispersion", 3.0f, new a(0.0f, 30.0f), "色散强度(px)"), new UniformSpec.Float1("edgeStart", 0.7f, new a(0.0f, 1.0f), "边缘起始"), new UniformSpec.Float1("vignetteStrength", 0.06f, new a(0.0f, 0.5f), "暗角强度"), new UniformSpec.Float1("progress", 0.0f, new a(0.0f, 1.0f), "动画进度"), new UniformSpec.Float1("scale", 1.0f, new a(0.9f, 1.1f), "缩放")), BackendHint.SF, true, AnimationDslKt.animation(new m5.a(26)), 4, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final r EdgeBlurDispersion$lambda$4(AnimationBuilder animation) {
        k.f(animation, "$this$animation");
        AnimationBuilder.track$default(animation, "progress", 0, new m5.a(27), 2, null);
        AnimationBuilder.track$default(animation, "scale", 0, new m5.a(28), 2, null);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r EdgeBlurDispersion$lambda$4$lambda$1(TrackBuilder track) {
        k.f(track, "$this$track");
        track.sequence(new m5.a(25));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r EdgeBlurDispersion$lambda$4$lambda$1$lambda$0(SequenceBuilder sequence) {
        k.f(sequence, "$this$sequence");
        SequenceBuilder sequenceBuilderDuration = sequence.duration(sequence.to(0.0f, 1.0f), 300L);
        EasingType easingType = EasingType.EASE_IN_OUT;
        sequence.ease(sequenceBuilderDuration, easingType);
        sequence.ease(sequence.duration(sequence.to(1.0f, 0.0f), 400L), easingType);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r EdgeBlurDispersion$lambda$4$lambda$3(TrackBuilder track) {
        k.f(track, "$this$track");
        track.sequence(new m5.a(29));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r EdgeBlurDispersion$lambda$4$lambda$3$lambda$2(SequenceBuilder sequence) {
        k.f(sequence, "$this$sequence");
        SequenceBuilder sequenceBuilderDuration = sequence.duration(sequence.to(1.0f, 1.025f), 300L);
        EasingType easingType = EasingType.EASE_IN_OUT;
        sequence.ease(sequenceBuilderDuration, easingType);
        sequence.ease(sequence.duration(sequence.to(1.025f, 1.0f), 400L), easingType);
        return r.f317a;
    }

    public static final EffectDefinition getEdgeBlurDispersion() {
        return EdgeBlurDispersion;
    }
}
