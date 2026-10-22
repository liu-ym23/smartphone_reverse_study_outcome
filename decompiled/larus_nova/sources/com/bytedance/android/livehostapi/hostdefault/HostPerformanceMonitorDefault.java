package com.bytedance.android.livehostapi.hostdefault;

import android.view.Window;
import androidx.camera.video.AudioStats;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import com.bytedance.android.livehostapi.platform.depend.BlockMonitorCallback;
import com.bytedance.android.livehostapi.platform.depend.FpsMonitorCallback;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class HostPerformanceMonitorDefault implements IHostPerformanceMonitor {
    public HostPerformanceMonitorDefault() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public Map<String, String> getCacheInfo() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public Map<String, Double> getCpuRate() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public double getGpuUsage() {
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public Map<String, Double> getInstantCpuRate() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public Map<String, Long> getMemory() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public float getShellTemperature() {
        return -1.0f;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public float getTemperature() {
        return 0.0f;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public void init() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public void initGpuMonitor() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public void removeFpsTracer(String r100) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public void startBlockTracer(String r100) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public void startFpsTracer() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public void startFpsTracer(String r100) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public void startFpsTracer(String r100, Window r101) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public void startGpuMonitor() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public void stopBlockTracer(String r100, BlockMonitorCallback r101) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public void stopFpsTracer(FpsMonitorCallback r100) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public void stopFpsTracer(String r100, FpsMonitorCallback r101, BlockMonitorCallback r102) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public void stopGpuMonitor() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public Map<String, Long> getSceneCpuTime() {
        return new HashMap();
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor
    public Boolean isANRDowngrade() {
        return Boolean.FALSE;
    }
}
