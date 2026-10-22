package com.stepos.core.ota.confirmui;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7495a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ModelConfirmFlow f7496b;

    public /* synthetic */ e(ModelConfirmFlow modelConfirmFlow, int i10) {
        this.f7495a = i10;
        this.f7496b = modelConfirmFlow;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f7495a;
        ModelConfirmFlow modelConfirmFlow = this.f7496b;
        switch (i10) {
            case 0:
                return ModelConfirmFlow.showCellularReminderThenProceed$lambda$69(modelConfirmFlow);
            case 1:
                return ModelConfirmFlow.showConfirm$lambda$35(modelConfirmFlow);
            case 2:
                return ModelConfirmFlow.showUnavailable$lambda$38(modelConfirmFlow);
            case 3:
                return ModelConfirmFlow.showNoNetworkGuide$lambda$53(modelConfirmFlow);
            default:
                return ModelConfirmFlow.showResumeConfirmThenProceed$lambda$65(modelConfirmFlow);
        }
    }
}
