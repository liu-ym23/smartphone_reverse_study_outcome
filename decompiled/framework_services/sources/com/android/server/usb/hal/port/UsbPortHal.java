package com.android.server.usb.hal.port;

import android.hardware.usb.IUsbOperationInternal;
import android.os.RemoteException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public interface UsbPortHal {
    public static final int HAL_DATA_ROLE_DEVICE = 2;
    public static final int HAL_DATA_ROLE_HOST = 1;
    public static final int HAL_MODE_DFP = 2;
    public static final int HAL_MODE_UFP = 1;
    public static final int HAL_POWER_ROLE_SINK = 2;
    public static final int HAL_POWER_ROLE_SOURCE = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HalUsbDataRole {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HalUsbPortMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HalUsbPowerRole {
    }

    void enableContaminantPresenceDetection(String r1, boolean r2, long r3);

    void enableLimitPowerTransfer(String r1, boolean r2, long r3, IUsbOperationInternal r5);

    boolean enableUsbData(String r1, boolean r2, long r3, IUsbOperationInternal r5);

    void enableUsbDataWhileDocked(String r1, long r2, IUsbOperationInternal r4);

    int getUsbHalVersion() throws RemoteException;

    void queryPortStatus(long r1);

    void resetUsbPort(String r1, long r2, IUsbOperationInternal r4);

    void switchDataRole(String r1, int r2, long r3);

    void switchMode(String r1, int r2, long r3);

    void switchPowerRole(String r1, int r2, long r3);

    void systemReady();
}
