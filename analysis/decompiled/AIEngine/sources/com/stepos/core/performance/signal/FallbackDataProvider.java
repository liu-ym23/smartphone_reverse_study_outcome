package com.stepos.core.performance.signal;

import com.stepos.core.performance.data.CpuTopology;
import com.stepos.core.performance.signal.IPerformanceDataProvider;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FallbackDataProvider implements IPerformanceDataProvider {
    @Override // com.stepos.core.performance.signal.IPerformanceDataProvider
    public boolean bindThreadToCores(int i10, List<Integer> coreIds) {
        g.f(coreIds, "coreIds");
        return false;
    }

    @Override // com.stepos.core.performance.signal.IPerformanceDataProvider
    public boolean bindThreadToSmallCores(int i10) {
        return false;
    }

    @Override // com.stepos.core.performance.signal.IPerformanceDataProvider
    public boolean canUseRealtimeScheduler() {
        return IPerformanceDataProvider.DefaultImpls.canUseRealtimeScheduler(this);
    }

    @Override // com.stepos.core.performance.signal.IPerformanceDataProvider
    public Map<String, Long> getCoreCurrentFrequencies() {
        return IPerformanceDataProvider.DefaultImpls.getCoreCurrentFrequencies(this);
    }

    @Override // com.stepos.core.performance.signal.IPerformanceDataProvider
    public float getCpuLoadRatio() {
        return IPerformanceDataProvider.DefaultImpls.getCpuLoadRatio(this);
    }

    @Override // com.stepos.core.performance.signal.IPerformanceDataProvider
    public CpuTopology getCpuTopology() {
        return CpuTopology.Companion.fallback();
    }

    @Override // com.stepos.core.performance.signal.IPerformanceDataProvider
    public int getSystemMemoryPressureScore() {
        return IPerformanceDataProvider.DefaultImpls.getSystemMemoryPressureScore(this);
    }

    @Override // com.stepos.core.performance.signal.IPerformanceDataProvider
    public void notifyInferenceEnd(int i10) {
        IPerformanceDataProvider.DefaultImpls.notifyInferenceEnd(this, i10);
    }

    @Override // com.stepos.core.performance.signal.IPerformanceDataProvider
    public void notifyInferenceStart(int i10) {
        IPerformanceDataProvider.DefaultImpls.notifyInferenceStart(this, i10);
    }

    @Override // com.stepos.core.performance.signal.IPerformanceDataProvider
    public boolean resetThreadAffinity(int i10) {
        return false;
    }
}
