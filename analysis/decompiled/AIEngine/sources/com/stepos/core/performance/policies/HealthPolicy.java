package com.stepos.core.performance.policies;

import ai.onnxruntime.a;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import com.stepos.core.performance.data.GlobalVerdict;
import com.stepos.core.performance.data.ModelMeta;
import com.stepos.core.performance.data.PreInitAction;
import com.stepos.core.performance.data.SignalSnapshot;
import com.stepos.core.performance.orchestrator.VerdictBuilder;
import com.stepos.core.performance.policies.IPerformancePolicy;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class HealthPolicy implements IPerformancePolicy {

    /* renamed from: id, reason: collision with root package name */
    private final String f7611id = "HealthPolicy";
    private final int priority = 90;

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public void evaluate(SignalSnapshot snapshot, VerdictBuilder builder) {
        g.f(snapshot, "snapshot");
        g.f(builder, "builder");
        if (snapshot.getHealthScore() < 30) {
            builder.suggest(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.HealthPolicy.evaluate.1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Integer.valueOf(((GlobalVerdict) obj).getCbFailureThreshold());
                }
            }, 3, a.g(snapshot.getHealthScore(), "healthScore=", " CRITICAL: aggressive circuit-breaker"));
            builder.suggest(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.HealthPolicy.evaluate.2
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Long.valueOf(((GlobalVerdict) obj).getCbResetTimeoutMs());
                }
            }, Long.valueOf(HysteresisStrategy.DEFAULT_DWELL_MS), "healthScore CRITICAL: slow recovery 60s");
            builder.suggest(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.HealthPolicy.evaluate.3
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Integer.valueOf(((GlobalVerdict) obj).getMaxConcurrent());
                }
            }, 1, "healthScore CRITICAL: single inference to stabilize");
        } else if (snapshot.getHealthScore() < 60) {
            builder.suggest(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.HealthPolicy.evaluate.4
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Integer.valueOf(((GlobalVerdict) obj).getCbFailureThreshold());
                }
            }, 4, a.g(snapshot.getHealthScore(), "healthScore=", " DEGRADED: tighter circuit-breaker"));
            builder.suggest(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.HealthPolicy.evaluate.5
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Long.valueOf(((GlobalVerdict) obj).getCbResetTimeoutMs());
                }
            }, 45000L, "healthScore DEGRADED: moderate recovery 45s");
            builder.suggest(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.HealthPolicy.evaluate.6
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Integer.valueOf(((GlobalVerdict) obj).getMaxConcurrent());
                }
            }, 2, "healthScore DEGRADED: limit concurrent=2");
        }
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public PreInitAction evaluatePreInit(SignalSnapshot signalSnapshot, ModelMeta modelMeta) {
        return IPerformancePolicy.DefaultImpls.evaluatePreInit(this, signalSnapshot, modelMeta);
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public String getId() {
        return this.f7611id;
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public int getPriority() {
        return this.priority;
    }
}
