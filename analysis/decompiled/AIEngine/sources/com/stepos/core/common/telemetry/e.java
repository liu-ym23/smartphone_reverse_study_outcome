package com.stepos.core.common.telemetry;

import com.stepos.core.model.task.AITaskStack;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import java.util.function.Predicate;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7391a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f7392b;

    public /* synthetic */ e(l lVar, int i10) {
        this.f7391a = i10;
        this.f7392b = lVar;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i10 = this.f7391a;
        l lVar = this.f7392b;
        switch (i10) {
            case 0:
                return ModelCallSessionTracker.reportTerminalOnce$lambda$5((d) lVar, obj);
            case 1:
                return AITaskStack.remove$lambda$14((d) lVar, obj);
            case 2:
                return AITaskStack.markCancelled$lambda$10((d) lVar, obj);
            case 3:
                return AITaskStack.removeSession$lambda$5((d) lVar, obj);
            case 4:
                return AITaskStack.markSessionCancelled$lambda$3((d) lVar, obj);
            default:
                return ConfirmDecisionBus.sweepExpired$lambda$1((com.stepos.core.ota.confirmui.a) lVar, obj);
        }
    }
}
