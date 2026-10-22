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
import kotlin.jvm.internal.k;
import t5.C2016a;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"SpectrumBorder", "Lcom/stepos/motionkit/EffectDefinition;", "getSpectrumBorder", "()Lcom/stepos/motionkit/EffectDefinition;", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SpectrumBorderKt {
    private static final EffectDefinition SpectrumBorder;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        UniformSpec.Float1 float1 = new UniformSpec.Float1("glowIntensity", 1.8f, null, null, 12, null);
        Object[] objArr = 0 == true ? 1 : 0;
        UniformSpec.Float1 float12 = new UniformSpec.Float1("glowWidth", 0.045f, objArr, null, 12, null);
        Object[] objArr2 = 0 == true ? 1 : 0;
        Object[] objArr3 = 0 == true ? 1 : 0;
        SpectrumBorder = new EffectDefinition("SpectrumBorder", "spectrum_border.agsl", null, o.N(float1, float12, new UniformSpec.Float1("borderRadius", 0.12f, objArr2, null, 12, null), new UniformSpec.Float1("amplitude", 0.5f, objArr3, null, 12, null)), BackendHint.RUNTIME_SHADER, false, AnimationDslKt.animation(new C2016a(2)), 36, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r SpectrumBorder$lambda$1(AnimationBuilder animation) {
        k.f(animation, "$this$animation");
        AnimationBuilder.track$default(animation, "glowIntensity", 0, new C2016a(3), 2, null);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r SpectrumBorder$lambda$1$lambda$0(TrackBuilder track) {
        k.f(track, "$this$track");
        track.oscillate(1.5f, 2.0f, 4000L);
        return r.f317a;
    }

    public static final EffectDefinition getSpectrumBorder() {
        return SpectrumBorder;
    }
}
