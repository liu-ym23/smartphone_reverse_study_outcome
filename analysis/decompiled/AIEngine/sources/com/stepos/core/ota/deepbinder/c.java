package com.stepos.core.ota.deepbinder;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7548a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OtaDeepBinderServiceImpl f7549b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f7550c;

    public /* synthetic */ c(OtaDeepBinderServiceImpl otaDeepBinderServiceImpl, String str, int i10) {
        this.f7548a = i10;
        this.f7549b = otaDeepBinderServiceImpl;
        this.f7550c = str;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f7548a) {
            case 0:
                return this.f7549b.getUpdateInfoAfterCta(this.f7550c);
            default:
                return OtaDeepBinderServiceImpl.fetchDownloadMeta$lambda$34(this.f7549b, this.f7550c);
        }
    }
}
