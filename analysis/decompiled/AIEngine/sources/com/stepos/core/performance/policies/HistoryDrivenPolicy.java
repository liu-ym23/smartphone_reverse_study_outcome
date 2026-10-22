package com.stepos.core.performance.policies;

import ai.onnxruntime.a;
import com.stepos.core.ability.speech.TtsCloudWsSession;
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
public final class HistoryDrivenPolicy implements IPerformancePolicy {

    /* renamed from: id, reason: collision with root package name */
    private final String f7612id = "HistoryDrivenPolicy";
    private final int priority = 100;

    private final long computeFallbackIdleTimeoutMs(SignalSnapshot signalSnapshot) {
        long selfProcessMemMb = (signalSnapshot.getTotalRamMb() < 8192 ? 15L : 30L) - ((signalSnapshot.getSelfProcessMemMb() / 500) * 5);
        if (selfProcessMemMb < 5) {
            selfProcessMemMb = 5;
        }
        return selfProcessMemMb * 1000;
    }

    private final long computeHotBufferDelay(SignalSnapshot signalSnapshot) {
        long avgInitTimeMs = signalSnapshot.getAvgInitTimeMs();
        long avgInitMemoryMb = signalSnapshot.getAvgInitMemoryMb();
        long selfProcessMemMb = signalSnapshot.getSelfProcessMemMb();
        if (signalSnapshot.getTotalRamMb() < 8192 || selfProcessMemMb > 2048) {
            return 0L;
        }
        if (avgInitMemoryMb * 4 > selfProcessMemMb && selfProcessMemMb > 1024) {
            return 0L;
        }
        if (0 <= avgInitTimeMs && avgInitTimeMs < 500) {
            return 0L;
        }
        long j10 = (signalSnapshot.getTotalRamMb() >= TtsCloudWsSession.UPLINK_QUEUE_WARN_BYTES ? 120L : signalSnapshot.getTotalRamMb() >= 12288 ? 90L : 60L) - ((selfProcessMemMb / 500) * 5);
        if (j10 < 5) {
            j10 = 5;
        }
        return Math.min(avgInitTimeMs * 4, j10 * 1000);
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public void evaluate(SignalSnapshot snapshot, VerdictBuilder builder) {
        g.f(snapshot, "snapshot");
        g.f(builder, "builder");
        long jComputeHotBufferDelay = computeHotBufferDelay(snapshot);
        builder.suggestIfAbsent(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.HistoryDrivenPolicy.evaluate.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
            public Object get(Object obj) {
                return Long.valueOf(((GlobalVerdict) obj).getDeferredReleaseDelayMs());
            }
        }, Long.valueOf(jComputeHotBufferDelay), a.m(a.q(snapshot.getAvgInitTimeMs(), "history-driven hot-buffer: avgInitTimeMs=", "ms * 4 → "), jComputeHotBufferDelay, "ms"));
        long jComputeFallbackIdleTimeoutMs = computeFallbackIdleTimeoutMs(snapshot);
        builder.suggestIfAbsent(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.HistoryDrivenPolicy.evaluate.2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
            public Object get(Object obj) {
                return Long.valueOf(((GlobalVerdict) obj).getIdleTimeoutMs());
            }
        }, Long.valueOf(jComputeFallbackIdleTimeoutMs), a.h(jComputeFallbackIdleTimeoutMs, "history-driven idle timeout fallback: ", "ms"));
        if (snapshot.getAvgTtftMs() > 3000) {
            builder.suggest(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.HistoryDrivenPolicy.evaluate.3
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Boolean.valueOf(((GlobalVerdict) obj).getSuggestCloudRouting());
                }
            }, Boolean.TRUE, a.h(snapshot.getAvgTtftMs(), "avgTtftMs=", "ms > 3000ms: suggest cloud routing"));
        }
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public PreInitAction evaluatePreInit(SignalSnapshot signalSnapshot, ModelMeta modelMeta) {
        return IPerformancePolicy.DefaultImpls.evaluatePreInit(this, signalSnapshot, modelMeta);
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public String getId() {
        return this.f7612id;
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public int getPriority() {
        return this.priority;
    }
}
