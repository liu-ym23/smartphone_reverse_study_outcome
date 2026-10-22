package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.AsrCloudSseClient;
import com.stepos.core.ability.speech.AsrSseStreamSessionManager;
import kotlin.jvm.internal.Ref$BooleanRef;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7265a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7266b;

    public /* synthetic */ e(Object obj, int i10) {
        this.f7265a = i10;
        this.f7266b = obj;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f7265a;
        Object obj = this.f7266b;
        switch (i10) {
            case 0:
                return AsrCloudSseClient.C03011.C00521.invokeSuspend$lambda$1((Ref$BooleanRef) obj);
            case 1:
                return AsrSseStreamSessionManager.ensureReorder$lambda$19$lambda$18((AsrSseStreamSessionManager.Session) obj);
            case 2:
                return AsrRealtimeBinderCoordinator.reorderScope_delegate$lambda$1((AsrRealtimeBinderCoordinator) obj);
            default:
                return AsrSseAbility.streamSessions_delegate$lambda$1((AsrSseAbility) obj);
        }
    }
}
