package D6;

import com.stepos.motionkit.fx.material.GlassEffect;
import com.stepos.motionkit.fx.material.capability.BlendParams;
import com.stepos.motionkit.fx.material.capability.BlurParams;
import com.stepos.motionkit.fx.material.capability.InnerShadowParams;
import com.stepos.motionkit.fx.material.capability.RefractionParams;
import com.stepos.motionkit.fx.material.capability.StrokeParams;

/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f391a = new o();

    public static l b(o oVar, GlassEffect glassEffect, float f, int i) {
        Float fValueOf = Float.valueOf(30.0f);
        float f7 = (i & 4) != 0 ? 1.0f : 0.5f;
        BlurParams blurParamsResolveBlur = glassEffect.resolveBlur(f);
        StrokeParams strokeParamsResolveStroke = glassEffect.resolveStroke(f);
        InnerShadowParams innerShadowParamsResolveInnerShadow = glassEffect.resolveInnerShadow(f);
        RefractionParams refractionParamsResolveRefraction = glassEffect.resolveRefraction(f);
        BlendParams blendParamsResolveBlend = glassEffect.resolveBlend(f);
        innerShadowParamsResolveInnerShadow.setIntensity(innerShadowParamsResolveInnerShadow.getIntensity() * f7);
        refractionParamsResolveRefraction.setStrength(fValueOf.floatValue());
        return new l(blurParamsResolveBlur, strokeParamsResolveStroke, innerShadowParamsResolveInnerShadow, refractionParamsResolveRefraction, blendParamsResolveBlend);
    }

    public final l a(float f) {
        return b(this, GlassEffect.INSTANCE.getLIGHT_SMALL(), f, 56);
    }
}
