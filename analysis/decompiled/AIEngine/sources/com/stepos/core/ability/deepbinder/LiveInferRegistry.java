package com.stepos.core.ability.deepbinder;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LiveInferRegistry implements InferRecycleGate {
    private final ConcurrentHashMap.KeySetView<String, Boolean> live = ConcurrentHashMap.newKeySet();

    public final void clear() {
        this.live.clear();
    }

    public final boolean isEmpty() {
        return this.live.isEmpty();
    }

    @Override // com.stepos.core.ability.deepbinder.InferRecycleGate
    public void onInferStart(String inferId) {
        g.f(inferId, "inferId");
        this.live.add(inferId);
    }

    @Override // com.stepos.core.ability.deepbinder.InferRecycleGate
    public boolean onInferTerminal(String inferId) {
        g.f(inferId, "inferId");
        return this.live.remove(inferId) && this.live.isEmpty();
    }
}
