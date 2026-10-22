package com.bytedance.apm.battery.stats;

import d1.b;
import p1.a;

/* JADX INFO: loaded from: classes.dex */
public interface IBatteryStats {
    void onBack(boolean r10);

    void onChargeStatusChange(boolean r10, boolean r11);

    void onFront(boolean r10);

    void onTimer(boolean r10);

    void startSceneMonitor(String r10, boolean r11);

    void stopSceneMonitor(String r10, boolean r11);

    void updateStatsRet(b r10, a r11);
}
