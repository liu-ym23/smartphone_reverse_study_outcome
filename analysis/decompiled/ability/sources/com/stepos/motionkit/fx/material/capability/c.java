package com.stepos.motionkit.fx.material.capability;

import S7.k;
import com.stepos.motionkit.fx.material.backend.InWindowMaterialBackend;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3872a;
    public final /* synthetic */ RefractionParams b;

    public /* synthetic */ c(RefractionParams refractionParams, int i) {
        this.f3872a = i;
        this.b = refractionParams;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f3872a;
        RefractionParams refractionParams = this.b;
        switch (i) {
            case 0:
                return BackdropRefractionBinding.update$lambda$0(refractionParams, (InWindowMaterialBackend.Config) obj);
            default:
                return RefractionBinding.update$lambda$0(refractionParams, obj);
        }
    }
}
