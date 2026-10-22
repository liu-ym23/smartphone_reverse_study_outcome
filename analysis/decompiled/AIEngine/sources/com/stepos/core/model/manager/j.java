package com.stepos.core.model.manager;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import u6.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7460a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zb.l f7461b;

    public /* synthetic */ j(zb.l lVar, int i10) {
        this.f7460a = i10;
        this.f7461b = lVar;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i10 = this.f7460a;
        zb.l lVar = this.f7461b;
        switch (i10) {
            case 0:
                return ModelCacheImpl.acquire$lambda$11((a) lVar, obj);
            case 1:
                return ((com.stepos.core.common.telemetry.b) lVar).invoke(obj);
            case 2:
                return (ConcurrentHashMap) ((com.stepos.core.common.telemetry.b) lVar).invoke(obj);
            default:
                return (c.a) ((n9.d) lVar).invoke(obj);
        }
    }
}
