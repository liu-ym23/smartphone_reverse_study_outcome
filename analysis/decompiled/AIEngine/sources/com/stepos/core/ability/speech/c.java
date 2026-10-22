package com.stepos.core.ability.speech;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7247a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7248b;

    public /* synthetic */ c(String str, int i10) {
        this.f7247a = i10;
        this.f7248b = str;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f7247a;
        String str = this.f7248b;
        switch (i10) {
            case 0:
                return AsrAbility.doCloudInfer_0E7RQCE$lambda$17(str);
            default:
                return AsrFileAbility.doCloudInfer_0E7RQCE$lambda$15(str);
        }
    }
}
