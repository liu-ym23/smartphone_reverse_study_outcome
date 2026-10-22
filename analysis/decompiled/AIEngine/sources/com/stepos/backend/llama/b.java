package com.stepos.backend.llama;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5945a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f5946b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5947c;

    public /* synthetic */ b(long j10, int i10, String str) {
        this.f5945a = i10;
        this.f5946b = j10;
        this.f5947c = str;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f5945a) {
            case 0:
                return PrivacyClassifyModel.classifyOnce$lambda$10$lambda$9(this.f5946b, this.f5947c);
            default:
                return ScpRiskModel.classifyOnce$lambda$9$lambda$8(this.f5946b, this.f5947c);
        }
    }
}
