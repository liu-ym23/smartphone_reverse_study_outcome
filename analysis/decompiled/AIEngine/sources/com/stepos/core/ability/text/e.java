package com.stepos.core.ability.text;

import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.deepbinder.OtaInteractiveDownloadFlow;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7369a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7370b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7371c;

    public /* synthetic */ e(int i10, String str) {
        this.f7371c = i10;
        this.f7370b = str;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f7369a) {
            case 0:
                return SessionStore.getOrCreate$lambda$2(this.f7371c, this.f7370b, (SessionKey) obj);
            default:
                return OtaInteractiveDownloadFlow.passResourceGateOrPrompt$lambda$36(this.f7370b, this.f7371c, (ConfirmDecisionBus.Decision) obj);
        }
    }

    public /* synthetic */ e(String str, int i10) {
        this.f7370b = str;
        this.f7371c = i10;
    }
}
