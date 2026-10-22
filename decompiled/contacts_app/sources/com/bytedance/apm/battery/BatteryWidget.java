package com.bytedance.apm.battery;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.AppUtils;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryWidget {
    public BatteryWidget() {
    }

    public static void initBatteryEnergy() {
        if (AppUtils.isMainProcess(ApmContext.getContext()) == false) goto L5;
        BatteryEnergyCollector.getInstance().init();
    L5:
        new BatteryEnergyTimerCollector().init();
    }

    public static void initBatteryCollector(boolean r1) {
        BatteryCollector.getInstance().init(r1);
    }

    public static void initPower() {
        if (AppUtils.isMainProcess(ApmContext.getContext()) == false) goto L6;
        ProcessEnergyCollector.getInstance().init();
        return;
    }

    public static void initBatteryTemperature(boolean r1) {
        if (AppUtils.isMainProcess(ApmContext.getContext()) == false) goto L6;
        BatteryTemperatureCollector.getInstance().init(r1);
        return;
    }
}
