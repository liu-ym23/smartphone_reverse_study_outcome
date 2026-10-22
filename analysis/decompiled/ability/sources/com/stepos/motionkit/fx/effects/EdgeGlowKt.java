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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"EdgeGlow", "Lcom/stepos/motionkit/EffectDefinition;", "getEdgeGlow", "()Lcom/stepos/motionkit/EffectDefinition;", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EdgeGlowKt {
    private static final EffectDefinition EdgeGlow = new EffectDefinition("EdgeGlow", "edge_glow.agsl", null, o.N(new UniformSpec.Float1("glowIntensity", 1.5f, null, null, 12, null), new UniformSpec.Float1("glowWidth", 0.045f, 0 == true ? 1 : 0, null, 12, null), new UniformSpec.Float4("glowColor", 0.3f, 0.7f, 1.0f, 1.0f, null, 32, null)), BackendHint.RUNTIME_SHADER, false, AnimationDslKt.animation(new C2016a(1)), 36, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final r EdgeGlow$lambda$1(AnimationBuilder animation) {
        k.f(animation, "$this$animation");
        AnimationBuilder.track$default(animation, "glowIntensity", 0, new C2016a(0), 2, null);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r EdgeGlow$lambda$1$lambda$0(TrackBuilder track) {
        k.f(track, "$this$track");
        track.oscillate(1.3f, 1.7f, 3500L);
        return r.f317a;
    }

    public static final EffectDefinition getEdgeGlow() {
        return EdgeGlow;
    }
}
