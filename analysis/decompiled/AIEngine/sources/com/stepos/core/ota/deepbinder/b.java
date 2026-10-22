package com.stepos.core.ota.deepbinder;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7546a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OtaDeepBinderServiceImpl f7547b;

    public /* synthetic */ b(OtaDeepBinderServiceImpl otaDeepBinderServiceImpl, int i10) {
        this.f7546a = i10;
        this.f7547b = otaDeepBinderServiceImpl;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f7546a;
        OtaDeepBinderServiceImpl otaDeepBinderServiceImpl = this.f7547b;
        switch (i10) {
            case 0:
                return OtaDeepBinderServiceImpl.getPresetModels$lambda$11(otaDeepBinderServiceImpl);
            default:
                return OtaDeepBinderServiceImpl.getAvailableModels$lambda$6(otaDeepBinderServiceImpl);
        }
    }
}
