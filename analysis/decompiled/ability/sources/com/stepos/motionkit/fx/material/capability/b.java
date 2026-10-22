package com.stepos.motionkit.fx.material.capability;

import S7.k;
import com.stepos.motionkit.fx.material.MaterialParams;
import com.stepos.motionkit.fx.material.backend.InWindowMaterialBackend;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3871a;
    public final /* synthetic */ MaterialParams b;

    public /* synthetic */ b(MaterialParams materialParams, int i) {
        this.f3871a = i;
        this.b = materialParams;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f3871a;
        MaterialParams materialParams = this.b;
        switch (i) {
            case 0:
                return BackdropInnerShadowBinding.update$lambda$0((InnerShadowParams) materialParams, (InWindowMaterialBackend.Config) obj);
            case 1:
                return InnerShadowBinding.update$lambda$0((InnerShadowParams) materialParams, obj);
            default:
                return InWindowBlendBinding.update$lambda$0((BlendParams) materialParams, (InWindowMaterialBackend.Config) obj);
        }
    }
}
