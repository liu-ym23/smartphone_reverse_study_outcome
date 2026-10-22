package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.base.IService;

/* JADX INFO: loaded from: classes12.dex */
public interface IMiddleWarePerformanceManager extends IService {
    int getBatteryChange();

    double getBatteryCurrent();

    int getBatteryLevel();

    double getCpuRate();

    double getGpuUsed();

    long getJavaHeapLeave();

    long getJavaHeapSum();

    long getNativeHeapLeave();

    long getNativeHeapSum();

    int getNetQuality();

    float getTemperature();

    float getUIStallRate();

    boolean hasDegrade();
}
