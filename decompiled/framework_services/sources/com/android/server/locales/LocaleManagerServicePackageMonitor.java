package com.android.server.locales;

import android.os.Bundle;
import android.os.UserHandle;
import com.android.internal.content.PackageMonitor;

/* JADX INFO: loaded from: classes2.dex */
final class LocaleManagerServicePackageMonitor extends PackageMonitor {
    private LocaleManagerBackupHelper mBackupHelper;
    private LocaleManagerService mLocaleManagerService;
    private SystemAppUpdateTracker mSystemAppUpdateTracker;

    LocaleManagerServicePackageMonitor(LocaleManagerBackupHelper localeManagerBackupHelper, SystemAppUpdateTracker systemAppUpdateTracker, LocaleManagerService localeManagerService) {
        this.mBackupHelper = localeManagerBackupHelper;
        this.mSystemAppUpdateTracker = systemAppUpdateTracker;
        this.mLocaleManagerService = localeManagerService;
    }

    public void onPackageAddedWithExtras(String packageName, int uid, Bundle extras) {
        this.mBackupHelper.onPackageAddedWithExtras(packageName, uid, extras);
    }

    public void onPackageDataCleared(String packageName, int uid) {
        this.mBackupHelper.onPackageDataCleared(packageName, uid);
    }

    public void onPackageRemoved(String packageName, int uid) {
        this.mBackupHelper.onPackageRemoved(packageName, uid);
        this.mLocaleManagerService.deleteOverrideLocaleConfig(packageName, UserHandle.getUserId(uid));
    }

    public void onPackageUpdateFinished(String packageName, int uid) {
        this.mBackupHelper.onPackageUpdateFinished(packageName, uid);
        this.mSystemAppUpdateTracker.onPackageUpdateFinished(packageName, uid);
    }
}
