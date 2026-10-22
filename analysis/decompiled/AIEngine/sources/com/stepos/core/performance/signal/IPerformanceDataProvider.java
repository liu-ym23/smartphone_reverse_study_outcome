package com.stepos.core.performance.signal;

import com.stepos.core.performance.data.CpuTopology;
import java.util.List;
import java.util.Map;
import kotlin.collections.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IPerformanceDataProvider {
    boolean bindThreadToCores(int i10, List<Integer> list);

    boolean bindThreadToSmallCores(int i10);

    boolean canUseRealtimeScheduler();

    Map<String, Long> getCoreCurrentFrequencies();

    float getCpuLoadRatio();

    CpuTopology getCpuTopology();

    int getSystemMemoryPressureScore();

    void notifyInferenceEnd(int i10);

    void notifyInferenceStart(int i10);

    boolean resetThreadAffinity(int i10);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static boolean canUseRealtimeScheduler(IPerformanceDataProvider iPerformanceDataProvider) {
            return false;
        }

        public static Map<String, Long> getCoreCurrentFrequencies(IPerformanceDataProvider iPerformanceDataProvider) {
            return b.d0();
        }

        public static float getCpuLoadRatio(IPerformanceDataProvider iPerformanceDataProvider) {
            return -1.0f;
        }

        public static int getSystemMemoryPressureScore(IPerformanceDataProvider iPerformanceDataProvider) {
            return -1;
        }

        public static void notifyInferenceEnd(IPerformanceDataProvider iPerformanceDataProvider, int i10) {
        }

        public static void notifyInferenceStart(IPerformanceDataProvider iPerformanceDataProvider, int i10) {
        }
    }
}
