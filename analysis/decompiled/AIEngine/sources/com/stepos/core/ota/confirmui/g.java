package com.stepos.core.ota.confirmui;

import com.stepos.core.ota.confirmui.ConfirmDecisionBus;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements ConfirmDecisionBus.StageListener, ConfirmDecisionBus.DecisionListener {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ModelConfirmFlow f7501g;

    public /* synthetic */ g(ModelConfirmFlow modelConfirmFlow) {
        this.f7501g = modelConfirmFlow;
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.DecisionListener
    public void onDecision(ConfirmDecisionBus.Decision decision) {
        ModelConfirmFlow.showUnavailable$lambda$36(this.f7501g, decision);
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.StageListener
    public void onStage(ConfirmDecisionBus.SubStage subStage) {
        ModelConfirmFlow.showConfirm$lambda$34(this.f7501g, subStage);
    }
}
