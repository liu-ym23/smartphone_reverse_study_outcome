package com.android.server.grammaticalinflection;

import com.android.internal.content.PackageMonitor;

/* JADX INFO: loaded from: classes2.dex */
public class GrammaticalInflectionPackageMonitor extends PackageMonitor {
    private GrammaticalInflectionBackupHelper mBackupHelper;

    GrammaticalInflectionPackageMonitor(GrammaticalInflectionBackupHelper backupHelper) {
        this.mBackupHelper = backupHelper;
    }

    public void onPackageAdded(String packageName, int uid) {
        this.mBackupHelper.onPackageAdded(packageName, uid);
    }

    public void onPackageDataCleared(String packageName, int uid) {
        this.mBackupHelper.onPackageDataCleared();
    }

    public void onPackageRemoved(String packageName, int uid) {
        this.mBackupHelper.onPackageRemoved();
    }
}
