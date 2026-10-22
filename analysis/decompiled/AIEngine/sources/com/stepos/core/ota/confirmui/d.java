package com.stepos.core.ota.confirmui;

import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements ConfirmDecisionBus.DecisionListener {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f7492g;
    public final /* synthetic */ ModelConfirmFlow h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ IOtaDeepBinderService f7493i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ boolean f7494j;

    public /* synthetic */ d(ModelConfirmFlow modelConfirmFlow, IOtaDeepBinderService iOtaDeepBinderService, boolean z, int i10) {
        this.f7492g = i10;
        this.h = modelConfirmFlow;
        this.f7493i = iOtaDeepBinderService;
        this.f7494j = z;
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.DecisionListener
    public final void onDecision(ConfirmDecisionBus.Decision decision) {
        switch (this.f7492g) {
            case 0:
                ModelConfirmFlow.showCellularReminderThenProceed$lambda$67(this.h, this.f7493i, this.f7494j, decision);
                break;
            default:
                ModelConfirmFlow.showResumeConfirmThenProceed$lambda$63(this.h, this.f7493i, this.f7494j, decision);
                break;
        }
    }
}
