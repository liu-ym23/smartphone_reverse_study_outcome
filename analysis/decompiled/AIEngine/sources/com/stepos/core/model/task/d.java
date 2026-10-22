package com.stepos.core.model.task;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7478a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AITaskSupervisor f7479b;

    public /* synthetic */ d(AITaskSupervisor aITaskSupervisor, int i10) {
        this.f7478a = i10;
        this.f7479b = aITaskSupervisor;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f7478a;
        AITaskSupervisor aITaskSupervisor = this.f7479b;
        switch (i10) {
            case 0:
                return Boolean.valueOf(AITaskSupervisor.initialize$lambda$2(aITaskSupervisor));
            default:
                return AITaskSupervisor.orchestrator_delegate$lambda$1(aITaskSupervisor);
        }
    }
}
