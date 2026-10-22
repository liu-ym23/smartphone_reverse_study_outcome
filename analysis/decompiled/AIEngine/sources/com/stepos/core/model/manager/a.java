package com.stepos.core.model.manager;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements zb.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7433a;

    public /* synthetic */ a(int i10) {
        this.f7433a = i10;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        String str = (String) obj;
        switch (this.f7433a) {
            case 0:
                return ModelCacheImpl.closeUnderCreateLock$lambda$71(str);
            default:
                return ModelCacheImpl.acquire$lambda$10(str);
        }
    }
}
