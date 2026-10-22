package com.stepos.core.performance.policies;

import com.stepos.base.inference.data.BackendType;
import com.stepos.core.performance.data.BackendConstraint;
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
public final class BatteryPolicy implements IPerformancePolicy {

    /* renamed from: id, reason: collision with root package name */
    private final String f7609id = "BatteryPolicy";
    private final int priority = 20;

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public void evaluate(SignalSnapshot snapshot, VerdictBuilder builder) {
        g.f(snapshot, "snapshot");
        g.f(builder, "builder");
        if (snapshot.isCharging()) {
            return;
        }
        if (snapshot.getBatteryLevel() < 10) {
            builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.BatteryPolicy.evaluate.1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return ((GlobalVerdict) obj).getRecommendedBackend();
                }
            }, BackendType.f6256j, "battery <10%: force CPU");
            builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.BatteryPolicy.evaluate.2
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return ((GlobalVerdict) obj).getBackendConstraint();
                }
            }, BackendConstraint.CPU_ONLY, "battery <10%: CPU_ONLY");
            builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.BatteryPolicy.evaluate.3
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Integer.valueOf(((GlobalVerdict) obj).getMaxConcurrent());
                }
            }, 1, "battery <10%: single inference only");
        } else if (snapshot.getBatteryLevel() < 15) {
            builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.BatteryPolicy.evaluate.4
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return ((GlobalVerdict) obj).getRecommendedBackend();
                }
            }, BackendType.f6256j, "battery <15%: force CPU");
            builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.BatteryPolicy.evaluate.5
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return ((GlobalVerdict) obj).getBackendConstraint();
                }
            }, BackendConstraint.CPU_ONLY, "battery <15%: CPU_ONLY");
            builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.BatteryPolicy.evaluate.6
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Integer.valueOf(((GlobalVerdict) obj).getMaxConcurrent());
                }
            }, 2, "battery <15%: limit concurrent=2");
        } else if (snapshot.getBatteryLevel() < 20) {
            builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.BatteryPolicy.evaluate.7
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return ((GlobalVerdict) obj).getRecommendedBackend();
                }
            }, BackendType.f6256j, "battery <20%: force CPU");
            builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.BatteryPolicy.evaluate.8
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return ((GlobalVerdict) obj).getBackendConstraint();
                }
            }, BackendConstraint.CPU_ONLY, "battery <20%: CPU_ONLY");
        }
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public PreInitAction evaluatePreInit(SignalSnapshot signalSnapshot, ModelMeta modelMeta) {
        return IPerformancePolicy.DefaultImpls.evaluatePreInit(this, signalSnapshot, modelMeta);
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public String getId() {
        return this.f7609id;
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public int getPriority() {
        return this.priority;
    }
}
