package com.stepos.motionkit.fx.material.capability;

import S7.k;
import com.stepos.motionkit.fx.material.backend.InWindowMaterialBackend;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3873a;
    public final /* synthetic */ StrokeParams b;

    public /* synthetic */ d(StrokeParams strokeParams, int i) {
        this.f3873a = i;
        this.b = strokeParams;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f3873a;
        StrokeParams strokeParams = this.b;
        switch (i) {
            case 0:
                return BackdropStrokeBinding.update$lambda$0(strokeParams, (InWindowMaterialBackend.Config) obj);
            default:
                return StrokeBinding.update$lambda$0(strokeParams, obj);
        }
    }
}
