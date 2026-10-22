package com.stepos.motionkit.fx.material.capability;

import S7.k;
import com.stepos.motionkit.fx.material.backend.InWindowMaterialBackend;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3870a;

    public /* synthetic */ a(int i) {
        this.f3870a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f3870a) {
            case 0:
                return BackdropInnerShadowBinding.release$lambda$1((InWindowMaterialBackend.Config) obj);
            case 1:
                return BackdropRefractionBinding.release$lambda$1((InWindowMaterialBackend.Config) obj);
            case 2:
                return BackdropStrokeBinding.release$lambda$1((InWindowMaterialBackend.Config) obj);
            case 3:
                return CrossBlendBinding.release$lambda$1(obj);
            case 4:
                return InWindowBlendBinding.release$lambda$1((InWindowMaterialBackend.Config) obj);
            case 5:
                return InnerShadowBinding.release$lambda$1(obj);
            case 6:
                return RefractionBinding.release$lambda$1(obj);
            default:
                return StrokeBinding.release$lambda$1(obj);
        }
    }
}
