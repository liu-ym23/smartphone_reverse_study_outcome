package com.stepos.core.common.telemetry;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PowerPerfTrackerKt {
    public static final <R> R inStage(PowerPerfTracker powerPerfTracker, String stage, zb.a<? extends R> block) {
        AtomicReference<String> currentStage;
        kotlin.jvm.internal.g.f(stage, "stage");
        kotlin.jvm.internal.g.f(block, "block");
        if (powerPerfTracker == null || (currentStage = powerPerfTracker.getCurrentStage()) == null) {
            return block.invoke();
        }
        String andSet = currentStage.getAndSet(stage);
        try {
            R rInvoke = block.invoke();
            while (!currentStage.compareAndSet(stage, andSet) && currentStage.get() == stage) {
            }
            return rInvoke;
        } catch (Throwable th) {
            while (!currentStage.compareAndSet(stage, andSet) && currentStage.get() == stage) {
            }
            throw th;
        }
    }
}
