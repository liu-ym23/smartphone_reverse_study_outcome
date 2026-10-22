package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.AsrSseAbility;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class t implements zb.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7339a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7340b;

    public /* synthetic */ t(String str, int i10) {
        this.f7339a = i10;
        this.f7340b = str;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        int i10 = this.f7339a;
        String str = this.f7340b;
        CloudSessionCorrelationState cloudSessionCorrelationState = (CloudSessionCorrelationState) obj;
        switch (i10) {
            case 0:
                return AsrSseAbility.C03332.invokeSuspend$lambda$0(str, cloudSessionCorrelationState);
            case 1:
                return AsrMultiFilesPipeline.drainCloudPending$lambda$1(str, cloudSessionCorrelationState);
            default:
                return AsrRealtimeBinderCoordinator.startCloudSessionNow$lambda$20(str, cloudSessionCorrelationState);
        }
    }
}
