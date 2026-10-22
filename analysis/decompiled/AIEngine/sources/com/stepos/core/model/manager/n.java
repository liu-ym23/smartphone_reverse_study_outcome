package com.stepos.core.model.manager;

import com.stepos.core.model.manager.ModelCacheImpl;
import java.util.function.BiFunction;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7466a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zb.p f7467b;

    public /* synthetic */ n(zb.p pVar, int i10) {
        this.f7466a = i10;
        this.f7467b = pVar;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        int i10 = this.f7466a;
        m mVar = (m) this.f7467b;
        switch (i10) {
            case 0:
                return ModelCacheImpl.VersionRouter.confirmVersionHealthyAsync$lambda$6(mVar, obj, obj2);
            default:
                return ModelCacheImpl.recordAcquireTier$lambda$76(mVar, obj, obj2);
        }
    }
}
