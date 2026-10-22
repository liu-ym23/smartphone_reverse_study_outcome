package com.android.server;

import android.hardware.health.HealthInfo;

/* JADX INFO: loaded from: classes.dex */
public interface IZswBatteryService {
    void controlLevelChange(boolean r1);

    boolean getBatteryLevelLowFlag();

    void initZswBatteryServiceImpl();

    boolean isBatteryLevelControllEnabled();

    boolean isBatteryLow();

    boolean isLevelCached();

    void processValuesLocked(HealthInfo r1);
}
