package com.android.server.pm.permission;

import android.content.Context;
import android.provider.DeviceConfig;
import com.android.server.appop.AppOpsCheckingServiceInterface;
import com.android.server.appop.AppOpsServiceTestingShim;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class AccessTestingShimFactory {
    public static final String DEVICE_CONFIG_SETTING = "selected_access_subsystem";
    private static final int RUN_BOTH_SUBSYSTEMS = 2;
    private static final int RUN_NEW_SUBSYSTEM = 1;
    private static final int RUN_OLD_SUBSYSTEM = 0;

    public AccessTestingShimFactory() {
    }

    public static PermissionManagerServiceInterface getPms(Context context, Supplier<PermissionManagerServiceInterface> oldImpl, Supplier<PermissionManagerServiceInterface> newImpl) {
        int selectedSystem = DeviceConfig.getInt("privacy", DEVICE_CONFIG_SETTING, 0);
        switch(selectedSystem) {
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return oldImpl.get();
    L7:
        return new PermissionManagerServiceTestingShim(oldImpl.get(), newImpl.get());
    L9:
        return newImpl.get();
    }

    public static AppOpsCheckingServiceInterface getAos(Context context, Supplier<AppOpsCheckingServiceInterface> oldImpl, Supplier<AppOpsCheckingServiceInterface> newImpl) {
        int selectedSystem = DeviceConfig.getInt("privacy", DEVICE_CONFIG_SETTING, 0);
        switch(selectedSystem) {
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return oldImpl.get();
    L7:
        return new AppOpsServiceTestingShim(oldImpl.get(), newImpl.get());
    L9:
        return newImpl.get();
    }
}
