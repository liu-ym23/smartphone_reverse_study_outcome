package com.bytedance.android.livesdk.revenue.service.performance;

import android.view.Window;
import com.bytedance.android.livesdkapi.performance.IStallCallback;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface c extends dy0.a {
    float F3();

    double getCpuRate();

    int getCurrentMusicVolume();

    float getFps();

    float getFrameIntervalMillis();

    double getGpuUsed();

    int getMaxMusicVolume();

    long getPssTotal();

    float getTemperature();

    void monitorPerformance(String r100);

    void onModuleStart(String r100, Map<String, String> r101);

    void onModuleStop(String r100);

    double ql();

    void releaseFpsMonitor(String r100);

    void startMonitorFps(String r100, Window r101);

    void stopMonitorFps(String r100, IStallCallback r101);
}
