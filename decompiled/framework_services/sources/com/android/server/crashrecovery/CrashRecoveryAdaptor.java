package com.android.server.crashrecovery;

import android.content.Context;
import com.android.server.PackageWatchdog;
import com.android.server.SystemServiceManager;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CrashRecoveryAdaptor {
    private static final String CRASHRECOVERY_MODULE_LIFECYCLE_CLASS = "com.android.server.crashrecovery.CrashRecoveryModule$Lifecycle";
    private static final String TAG = "CrashRecoveryAdaptor";

    public CrashRecoveryAdaptor() {
    }

    public static void initializeCrashrecoveryModuleService(SystemServiceManager mSystemServiceManager) {
        mSystemServiceManager.startService(CRASHRECOVERY_MODULE_LIFECYCLE_CLASS);
    }

    public static void packageWatchdogNoteBoot(Context mSystemContext) {
    }

    public static void packageWatchdogWriteNow(Context mContext) {
    }

    public static void packageWatchdogOnPackagesReady(PackageWatchdog mPackageWatchdog) {
    }

    public static void rescuePartyRegisterHealthObserver(Context mSystemContext) {
    }

    public static void rescuePartyOnSettingsProviderPublished(Context mContext) {
    }

    public static void rescuePartyResetDeviceConfigForPackages(List<String> packageNames) {
    }
}
