package D6;

import C7.r;
import com.stepos.motionkit.fx.material.backend.CrossWindowMaterialBackend;
import com.stepos.motionkit.fx.material.backend.InWindowMaterialBackend;
import com.stepos.motionkit.fx.material.capability.InnerShadowParams;

/* loaded from: classes3.dex */
public final /* synthetic */ class m implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f389a;
    public final /* synthetic */ float b;

    public /* synthetic */ m(float f, int i) {
        this.f389a = i;
        this.b = f;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f389a) {
            case 0:
                InnerShadowParams apply = (InnerShadowParams) obj;
                kotlin.jvm.internal.k.f(apply, "$this$apply");
                apply.setColor(855638015);
                apply.setRadius(this.b * 6.0f);
                apply.setIntensity(0.15f);
                return r.f317a;
            case 1:
                InnerShadowParams apply2 = (InnerShadowParams) obj;
                kotlin.jvm.internal.k.f(apply2, "$this$apply");
                apply2.setColor(855638015);
                apply2.setRadius(this.b * 6.0f);
                apply2.setIntensity(0.15f);
                return r.f317a;
            case 2:
                return CrossWindowMaterialBackend.setCornerRadius$lambda$3(this.b, obj);
            case 3:
                return CrossWindowMaterialBackend.setCornerSmoothness$lambda$4(this.b, obj);
            case 4:
                return InWindowMaterialBackend.setCornerRadius$lambda$4(this.b, (InWindowMaterialBackend.Config) obj);
            default:
                return InWindowMaterialBackend.setCornerSmoothness$lambda$5(this.b, (InWindowMaterialBackend.Config) obj);
        }
    }
}
