package com.stepos.motionkit.fx.material.capability;

import S7.k;
import com.stepos.motionkit.fx.material.backend.InWindowMaterialBackend;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3878a;
    public final /* synthetic */ BlurParams b;

    public /* synthetic */ i(BlurParams blurParams, int i) {
        this.f3878a = i;
        this.b = blurParams;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f3878a;
        BlurParams blurParams = this.b;
        switch (i) {
            case 0:
                return InWindowBlurBinding.update$lambda$0(blurParams, (InWindowMaterialBackend.Config) obj);
            default:
                return SelfBlurBinding.update$lambda$0(blurParams, obj);
        }
    }
}
