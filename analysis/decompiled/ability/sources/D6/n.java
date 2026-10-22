package D6;

import com.stepos.motionkit.fx.material.MaterialBuilder;
import com.stepos.motionkit.fx.material.Materials;

/* loaded from: classes3.dex */
public final /* synthetic */ class n implements a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f390a;
    public final /* synthetic */ float b;

    public /* synthetic */ n(float f, int i) {
        this.f390a = i;
        this.b = f;
    }

    @Override // D6.a
    public final MaterialBuilder a(MaterialBuilder builder) {
        switch (this.f390a) {
            case 0:
                kotlin.jvm.internal.k.f(builder, "builder");
                Materials materials = Materials.INSTANCE;
                return builder.apply(materials.getBlur(), new Ba.f(9)).apply(materials.getStroke(), new Ba.f(10)).apply(materials.getInnerShadow(), new m(this.b, 0)).apply(materials.getRefraction(), new Ba.f(3)).apply(materials.getBlend(), new Ba.f(4));
            default:
                kotlin.jvm.internal.k.f(builder, "builder");
                Materials materials2 = Materials.INSTANCE;
                return builder.apply(materials2.getBlur(), new Ba.f(5)).apply(materials2.getStroke(), new Ba.f(6)).apply(materials2.getInnerShadow(), new m(this.b, 1)).apply(materials2.getRefraction(), new Ba.f(7)).apply(materials2.getBlend(), new Ba.f(8));
        }
    }
}
