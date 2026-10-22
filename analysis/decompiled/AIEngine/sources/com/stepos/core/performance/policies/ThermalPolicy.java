package com.stepos.core.performance.policies;

import com.stepos.base.awareness.data.ThermalState;
import com.stepos.base.inference.data.BackendType;
import com.stepos.core.performance.data.BackendConstraint;
import com.stepos.core.performance.data.GlobalVerdict;
import com.stepos.core.performance.data.ModelMeta;
import com.stepos.core.performance.data.PreInitAction;
import com.stepos.core.performance.data.SignalSnapshot;
import com.stepos.core.performance.orchestrator.VerdictBuilder;
import com.stepos.core.performance.policies.IPerformancePolicy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ThermalPolicy implements IPerformancePolicy {

    /* renamed from: id, reason: collision with root package name */
    private final String f7615id = "ThermalPolicy";
    private final int priority = 10;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ThermalState.values().length];
            try {
                ThermalState.a aVar = ThermalState.f6199a;
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ThermalState.a aVar2 = ThermalState.f6199a;
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ThermalState.a aVar3 = ThermalState.f6199a;
                iArr[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                ThermalState.a aVar4 = ThermalState.f6199a;
                iArr[0] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public void evaluate(SignalSnapshot snapshot, VerdictBuilder builder) {
        g.f(snapshot, "snapshot");
        g.f(builder, "builder");
        int iOrdinal = snapshot.getThermalState().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                builder.suggest(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.ThermalPolicy.evaluate.6
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                    public Object get(Object obj) {
                        return Integer.valueOf(((GlobalVerdict) obj).getCbFailureThreshold());
                    }
                }, 4, "MODERATE ≥40℃: lower circuit-breaker threshold");
                return;
            }
            if (iOrdinal == 2) {
                builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.ThermalPolicy.evaluate.4
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                    public Object get(Object obj) {
                        return ((GlobalVerdict) obj).getRecommendedBackend();
                    }
                }, BackendType.f6256j, "SEVERE ≥45℃ must use CPU");
                builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.ThermalPolicy.evaluate.5
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                    public Object get(Object obj) {
                        return ((GlobalVerdict) obj).getBackendConstraint();
                    }
                }, BackendConstraint.CPU_ONLY, "SEVERE: seal CPU_ONLY");
            } else {
                if (iOrdinal != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.ThermalPolicy.evaluate.1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                    public Object get(Object obj) {
                        return ((GlobalVerdict) obj).getRecommendedBackend();
                    }
                }, BackendType.f6256j, "CRITICAL >50℃ must use CPU");
                builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.ThermalPolicy.evaluate.2
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                    public Object get(Object obj) {
                        return ((GlobalVerdict) obj).getBackendConstraint();
                    }
                }, BackendConstraint.CPU_ONLY, "CRITICAL: seal CPU_ONLY");
                builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.ThermalPolicy.evaluate.3
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                    public Object get(Object obj) {
                        return Integer.valueOf(((GlobalVerdict) obj).getDspMaxConcurrent());
                    }
                }, 0, "CRITICAL: disable DSP to prevent thermal runaway");
            }
        }
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public PreInitAction evaluatePreInit(SignalSnapshot signalSnapshot, ModelMeta modelMeta) {
        return IPerformancePolicy.DefaultImpls.evaluatePreInit(this, signalSnapshot, modelMeta);
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public String getId() {
        return this.f7615id;
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public int getPriority() {
        return this.priority;
    }
}
