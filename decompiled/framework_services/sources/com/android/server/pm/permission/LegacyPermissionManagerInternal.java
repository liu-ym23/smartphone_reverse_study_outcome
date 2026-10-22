package com.android.server.pm.permission;

import com.android.server.pm.PackageSetting;

/* JADX INFO: loaded from: classes2.dex */
public interface LegacyPermissionManagerInternal {

    public interface PackagesProvider {
        String[] getPackages(int r1);
    }

    public interface SyncAdapterPackagesProvider {
        String[] getPackages(String r1, int r2);
    }

    int checkSoundTriggerRecordAudioPermissionForDataDelivery(int r1, String r2, String r3, String r4);

    void grantDefaultPermissions(int r1);

    void grantDefaultPermissionsToDefaultSimCallManager(String r1, int r2);

    void grantDefaultPermissionsToDefaultUseOpenWifiApp(String r1, int r2);

    void onPackageAdded(PackageSetting r1);

    void resetRuntimePermissions();

    void scheduleReadDefaultPermissionExceptions();

    void setDialerAppPackagesProvider(PackagesProvider r1);

    void setLocationExtraPackagesProvider(PackagesProvider r1);

    void setLocationPackagesProvider(PackagesProvider r1);

    void setSimCallManagerPackagesProvider(PackagesProvider r1);

    void setSmsAppPackagesProvider(PackagesProvider r1);

    void setSyncAdapterPackagesProvider(SyncAdapterPackagesProvider r1);

    void setUseOpenWifiAppPackagesProvider(PackagesProvider r1);

    void setVoiceInteractionPackagesProvider(PackagesProvider r1);
}
