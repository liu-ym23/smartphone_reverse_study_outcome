package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.AsrSseStreamSessionManager;
import java.util.function.Function;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class w implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7345a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zb.l f7346b;

    public /* synthetic */ w(zb.l lVar, int i10) {
        this.f7345a = i10;
        this.f7346b = lVar;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i10 = this.f7345a;
        zb.l lVar = this.f7346b;
        switch (i10) {
            case 0:
                return AsrSseStreamSessionManager.C03341.invokeSuspend$lambda$1((v) lVar, obj);
            case 1:
                return AsrSseStreamSessionManager.onFeedInput$lambda$6((v) lVar, obj);
            case 2:
                return AsrSseStreamSessionManager.completeInput$lambda$9((v) lVar, obj);
            default:
                return TtsStreamBinderCoordinator.ensureReorderBuffer$lambda$3((e0) lVar, obj);
        }
    }
}
