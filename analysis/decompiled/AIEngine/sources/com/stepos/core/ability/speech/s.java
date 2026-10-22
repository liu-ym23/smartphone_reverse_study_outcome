package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.AsrSseAbility;
import com.stepos.core.ability.speech.SpeechAbility;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class s implements zb.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7337a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7338b;

    public /* synthetic */ s(Object obj, int i10) {
        this.f7337a = i10;
        this.f7338b = obj;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        int i10 = this.f7337a;
        Object obj2 = this.f7338b;
        switch (i10) {
            case 0:
                return AsrSseAbility.AnonymousClass6.invokeSuspend$lambda$6((String) obj2, (CloudSessionCorrelationState) obj);
            case 1:
                return SpeechAbility.AnonymousClass3.invokeSuspend$lambda$0((String) obj2, (CloudSessionCorrelationState) obj);
            case 2:
                return AsrAbility.doCloudInfer_0E7RQCE$lambda$16((String) obj2, (CloudSessionCorrelationState) obj);
            case 3:
                return AsrFileAbility.doCloudInfer_0E7RQCE$lambda$14((String) obj2, (CloudSessionCorrelationState) obj);
            case 4:
                return TtsStreamBinderCoordinator.startTtsCloudSession$lambda$12((String) obj2, (CloudSessionCorrelationState) obj);
            default:
                return VadRuntimeConfig.rejectionLog$lambda$2((VadRuntimeConfig) obj2, (Map.Entry) obj);
        }
    }
}
