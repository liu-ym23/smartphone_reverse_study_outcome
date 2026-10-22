package com.stepos.core.ota.process;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7605a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OtaProcessService f7606b;

    public /* synthetic */ b(OtaProcessService otaProcessService, int i10) {
        this.f7605a = i10;
        this.f7606b = otaProcessService;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f7605a;
        OtaProcessService otaProcessService = this.f7606b;
        switch (i10) {
            case 0:
                return OtaProcessService.onCreate$lambda$1$lambda$0(otaProcessService);
            default:
                return OtaProcessService.onCreate$lambda$3(otaProcessService);
        }
    }
}
