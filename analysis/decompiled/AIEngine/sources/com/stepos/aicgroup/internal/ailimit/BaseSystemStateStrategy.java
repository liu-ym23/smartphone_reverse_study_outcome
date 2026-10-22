package com.stepos.aicgroup.internal.ailimit;

import com.stepos.aicgroup.AiDispatchers;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class BaseSystemStateStrategy implements SystemStateStrategy {
    public static DimensionConstraint a(AiDispatchers.DispatcherPriority... dispatcherPriorityArr) {
        return new DimensionConstraint(l.s0(dispatcherPriorityArr), StopAction.PAUSE);
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public boolean isAvailable() {
        return true;
    }
}
