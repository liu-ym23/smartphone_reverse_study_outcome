package com.stepos.core.ability.strategy;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import h7.b;
import h7.d;
import h7.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RoutingOrchestrator implements d {
    private final String TAG = "RoutingOrchestrator";

    @Override // h7.d
    public <T> Object makeDecision(T t8, String str, b bVar, qb.b<? super e> bVar2) {
        AIEngineLogger.d(LogModule.ABILITY, this.TAG, "Local execution (default): abilityId=" + str);
        return new e.c(null, 3);
    }
}
