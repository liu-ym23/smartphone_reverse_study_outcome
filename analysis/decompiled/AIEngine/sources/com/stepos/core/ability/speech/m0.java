package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.VadSessionManager;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class m0 implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7315a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7316b;

    public /* synthetic */ m0(Object obj, int i10) {
        this.f7315a = i10;
        this.f7316b = obj;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f7315a;
        Object obj = this.f7316b;
        switch (i10) {
            case 0:
                return VadSessionManager.ensureReorder$lambda$4$lambda$3((VadSessionManager.Session) obj);
            case 1:
                return AsrRealtimeBinderCoordinator.pcmDumpSink_delegate$lambda$0((AsrRealtimeBinderCoordinator) obj);
            case 2:
                return AsrSseAbility.cloudSseClient_delegate$lambda$0((AsrSseAbility) obj);
            default:
                return Boolean.valueOf(TtsCloudWsSession.awaitSentencePipelineBefore$lambda$23((TtsCloudWsSession) obj));
        }
    }
}
