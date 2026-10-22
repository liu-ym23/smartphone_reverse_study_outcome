package com.stepos.core.ota.deepbinder;

import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7556a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7557b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f7558c;

    public /* synthetic */ f(int i10, String str, String str2) {
        this.f7556a = i10;
        this.f7557b = str;
        this.f7558c = str2;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f7556a) {
            case 0:
                return OtaInteractiveDownloadFlow.showDownloadConfirm$lambda$18(this.f7557b, this.f7558c, (ConfirmDecisionBus.Decision) obj);
            default:
                return ActiveDownloadConditionMonitor.pauseAndBlock$lambda$17(this.f7557b, this.f7558c, (ConfirmDecisionBus.Decision) obj);
        }
    }
}
