package com.bytedance.android.livesdkapi.performance;

import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public abstract class BasePerformanceStrategyTask {
    public BasePerformanceStrategyTask() {
    }

    public abstract boolean onTriggerDegrade(int r100, Map<String, String> r101, IPerformanceStrategyMonitor r102);

    public abstract boolean onTriggerEnhance(int r100, Map<String, String> r101, IPerformanceStrategyMonitor r102);

    public abstract void onTriggerOrigin(Map<String, String> r100, IPerformanceStrategyMonitor r101);
}
