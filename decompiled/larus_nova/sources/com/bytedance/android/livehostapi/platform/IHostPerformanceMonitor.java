package com.bytedance.android.livehostapi.platform;

import android.view.Window;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.bytedance.android.livehostapi.platform.depend.BlockMonitorCallback;
import com.bytedance.android.livehostapi.platform.depend.FpsMonitorCallback;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostPerformanceMonitor extends IService, IBaseHostPerformanceMonitor {
    Map<String, String> getCacheInfo();

    Map<String, Double> getCpuRate();

    double getGpuUsage();

    Map<String, Double> getInstantCpuRate();

    Map<String, Long> getMemory();

    Map<String, Long> getSceneCpuTime();

    float getShellTemperature();

    float getTemperature();

    void init();

    void initGpuMonitor();

    Boolean isANRDowngrade();

    void removeFpsTracer(String r100);

    void startBlockTracer(String r100);

    void startFpsTracer();

    void startFpsTracer(String r100);

    void startFpsTracer(String r100, Window r101);

    void startGpuMonitor();

    void stopBlockTracer(String r100, BlockMonitorCallback r101);

    void stopFpsTracer(FpsMonitorCallback r100);

    void stopFpsTracer(String r100, FpsMonitorCallback r101, BlockMonitorCallback r102);

    void stopGpuMonitor();
}
