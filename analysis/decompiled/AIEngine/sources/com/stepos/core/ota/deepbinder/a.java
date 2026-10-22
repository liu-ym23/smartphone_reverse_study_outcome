package com.stepos.core.ota.deepbinder;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7543a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OtaDeepBinderServiceImpl f7544b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f7545c;

    public /* synthetic */ a(OtaDeepBinderServiceImpl otaDeepBinderServiceImpl, String str) {
        this.f7544b = otaDeepBinderServiceImpl;
        this.f7545c = str;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f7543a) {
            case 0:
                return OtaDeepBinderServiceImpl.executeDownload$lambda$49(this.f7545c, this.f7544b);
            default:
                return OtaDeepBinderServiceImpl.fetchUpdateMeta$lambda$35(this.f7544b, this.f7545c);
        }
    }

    public /* synthetic */ a(String str, OtaDeepBinderServiceImpl otaDeepBinderServiceImpl) {
        this.f7545c = str;
        this.f7544b = otaDeepBinderServiceImpl;
    }
}
