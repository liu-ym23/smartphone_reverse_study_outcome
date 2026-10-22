package com.stepos.core.performance.policies;

import ai.onnxruntime.a;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.base.inference.data.BackendType;
import com.stepos.core.ota.confirm.InteractiveSessionRegistry;
import com.stepos.core.performance.data.GlobalVerdict;
import com.stepos.core.performance.data.ModelMeta;
import com.stepos.core.performance.data.PreInitAction;
import com.stepos.core.performance.data.SignalSnapshot;
import com.stepos.core.performance.orchestrator.VerdictBuilder;
import com.stepos.core.performance.policies.IPerformancePolicy;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.g;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SceneBackendPolicy implements IPerformancePolicy {

    /* renamed from: id, reason: collision with root package name */
    private final String f7614id = "SceneBackendPolicy";
    private final int priority = 50;

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public void evaluate(SignalSnapshot snapshot, VerdictBuilder builder) {
        g.f(snapshot, "snapshot");
        g.f(builder, "builder");
        if (!snapshot.isForeground()) {
            builder.suggest(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.SceneBackendPolicy.evaluate.1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return ((GlobalVerdict) obj).getRecommendedBackend();
                }
            }, BackendType.f6256j, "background: prefer CPU to save power");
            builder.suggest(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.SceneBackendPolicy.evaluate.2
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Integer.valueOf(((GlobalVerdict) obj).getMaxConcurrent());
                }
            }, 2, "background: reduce concurrent to 2");
        }
        if (snapshot.getBackgroundDurationMs() > InteractiveSessionRegistry.DEFAULT_TTL_MS) {
            builder.suggest(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.SceneBackendPolicy.evaluate.3
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Integer.valueOf(((GlobalVerdict) obj).getMaxConcurrent());
                }
            }, 1, a.h(snapshot.getBackgroundDurationMs(), "long-background ", "ms>300s: limit concurrent=1"));
        }
        if (!snapshot.getHasNpu()) {
            builder.suggest(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.SceneBackendPolicy.evaluate.4
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return ((GlobalVerdict) obj).getRecommendedBackend();
                }
            }, BackendType.f6256j, "no NPU available: fallback to CPU");
        }
        List listB0 = (snapshot.getHasNpu() && snapshot.getHasGpuCompute()) ? m.b0(BackendType.f6254d, BackendType.h, BackendType.f6255e, BackendType.f6256j) : snapshot.getHasNpu() ? m.b0(BackendType.f6254d, BackendType.h, BackendType.f6256j) : b1.P(BackendType.f6256j);
        builder.suggest(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.SceneBackendPolicy.evaluate.5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
            public Object get(Object obj) {
                return ((GlobalVerdict) obj).getBackendFallbackChain();
            }
        }, listB0, "fallback chain: hasNpu=" + snapshot.getHasNpu() + ", hasGpu=" + snapshot.getHasGpuCompute());
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public PreInitAction evaluatePreInit(SignalSnapshot signalSnapshot, ModelMeta modelMeta) {
        return IPerformancePolicy.DefaultImpls.evaluatePreInit(this, signalSnapshot, modelMeta);
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public String getId() {
        return this.f7614id;
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public int getPriority() {
        return this.priority;
    }
}
