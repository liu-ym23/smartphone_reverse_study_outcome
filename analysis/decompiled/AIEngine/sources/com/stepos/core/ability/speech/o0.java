package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.VadSessionManager;
import java.util.function.Function;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class o0 implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7325a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zb.l f7326b;

    public /* synthetic */ o0(zb.l lVar, int i10) {
        this.f7325a = i10;
        this.f7326b = lVar;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i10 = this.f7325a;
        zb.l lVar = this.f7326b;
        switch (i10) {
            case 0:
                return VadSessionManager.C03661.invokeSuspend$lambda$1((n0) lVar, obj);
            case 1:
                return AsrRealtimeBinderCoordinator.ensureReorderBuffer$lambda$5((com.stepos.aicgroup.f) lVar, obj);
            case 2:
                return VadSessionManager.completeInput$lambda$10((n0) lVar, obj);
            default:
                return VadSessionManager.onFeedInput$lambda$7((n0) lVar, obj);
        }
    }
}
