package D6;

import B9.Q;
import com.stepos.motionkit.fx.material.MaterialBuilder;
import com.stepos.motionkit.fx.material.Materials;
import com.stepos.motionkit.fx.material.capability.BlendParams;
import com.stepos.motionkit.fx.material.capability.BlurParams;
import com.stepos.motionkit.fx.material.capability.InnerShadowParams;
import com.stepos.motionkit.fx.material.capability.RefractionParams;
import com.stepos.motionkit.fx.material.capability.StrokeParams;

/* loaded from: classes3.dex */
public final /* synthetic */ class l implements a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BlurParams f388a;
    public final /* synthetic */ StrokeParams b;
    public final /* synthetic */ InnerShadowParams c;
    public final /* synthetic */ RefractionParams d;
    public final /* synthetic */ BlendParams e;

    public /* synthetic */ l(BlurParams blurParams, StrokeParams strokeParams, InnerShadowParams innerShadowParams, RefractionParams refractionParams, BlendParams blendParams) {
        this.f388a = blurParams;
        this.b = strokeParams;
        this.c = innerShadowParams;
        this.d = refractionParams;
        this.e = blendParams;
    }

    @Override // D6.a
    public final MaterialBuilder a(MaterialBuilder builder) {
        kotlin.jvm.internal.k.f(builder, "builder");
        Materials materials = Materials.INSTANCE;
        return builder.apply(materials.getBlur(), new Q(this.f388a, 2)).apply(materials.getStroke(), new Q(this.b, 3)).apply(materials.getInnerShadow(), new Q(this.c, 4)).apply(materials.getRefraction(), new Q(this.d, 5)).apply(materials.getBlend(), new Q(this.e, 6));
    }
}
