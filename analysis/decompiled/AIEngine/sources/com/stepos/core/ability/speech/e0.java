package com.stepos.core.ability.speech;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e0 implements zb.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7267a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TtsStreamBinderCoordinator f7268b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f7269c;

    public /* synthetic */ e0(TtsStreamBinderCoordinator ttsStreamBinderCoordinator, String str, int i10) {
        this.f7267a = i10;
        this.f7268b = ttsStreamBinderCoordinator;
        this.f7269c = str;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f7267a) {
            case 0:
                return TtsStreamBinderCoordinator.ensureReorderBuffer$lambda$2$lambda$0(this.f7268b, this.f7269c, (String) obj);
            default:
                return TtsStreamBinderCoordinator.ensureReorderBuffer$lambda$2(this.f7268b, this.f7269c, (String) obj);
        }
    }
}
