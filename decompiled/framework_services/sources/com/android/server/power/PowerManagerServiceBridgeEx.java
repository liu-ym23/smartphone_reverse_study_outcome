package com.android.server.power;

/* JADX INFO: loaded from: classes3.dex */
public class PowerManagerServiceBridgeEx extends android.os.IPowerManagerMonitorEx.Stub {
    private PowerManagerService mPowerManagerService;

    public PowerManagerServiceBridgeEx(PowerManagerService powerManagerService) {
        this.mPowerManagerService = powerManagerService;
    }
}
