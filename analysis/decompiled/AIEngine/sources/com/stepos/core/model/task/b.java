package com.stepos.core.model.task;

import p6.g;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7474a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AITaskRecord f7475b;

    public /* synthetic */ b(AITaskRecord aITaskRecord, int i10) {
        this.f7474a = i10;
        this.f7475b = aITaskRecord;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        int i10 = this.f7474a;
        AITaskRecord aITaskRecord = this.f7475b;
        g gVar = (g) obj;
        switch (i10) {
            case 0:
                return AITaskSupervisor.handleTaskStart$lambda$16(aITaskRecord, gVar);
            case 1:
                return AITaskSupervisor.handleTaskCompletion$lambda$19(aITaskRecord, gVar);
            default:
                return AITaskSupervisor.handleTaskCompletion$lambda$22(aITaskRecord, gVar);
        }
    }
}
