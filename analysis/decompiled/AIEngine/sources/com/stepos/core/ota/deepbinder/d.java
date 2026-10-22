package com.stepos.core.ota.deepbinder;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7551a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7552b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f7553c;

    public /* synthetic */ d(int i10, String str, String str2) {
        this.f7551a = i10;
        this.f7552b = str;
        this.f7553c = str2;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f7551a) {
            case 0:
                return Boolean.valueOf(OtaDeepBinderServiceImpl.isInstalled$lambda$29(this.f7552b, this.f7553c));
            default:
                return OtaInteractiveDownloadFlow.requestStartDownload$lambda$3(this.f7552b, this.f7553c);
        }
    }
}
