package com.bytedance.android.livehostapi.platform.flavor.xt;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.bytedance.android.livehostapi.platform.depend.BlockMonitorCallback;
import com.bytedance.android.livehostapi.platform.depend.FpsMonitorCallback;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostPerformanceMonitorForXT extends IService, IBaseHostPerformanceMonitor {
    Map<String, String> getCacheInfo();

    Map<String, Double> getCpuRate();

    Map<String, Long> getMemory();

    float getTemperature();

    void init();

    void startFpsTracer();

    void stopBlockTracer(String r100, BlockMonitorCallback r101);

    void stopFpsTracer(FpsMonitorCallback r100);
}
