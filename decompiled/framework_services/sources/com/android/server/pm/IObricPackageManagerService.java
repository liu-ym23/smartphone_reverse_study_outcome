package com.android.server.pm;

import android.content.pm.IObricPackageManager;
import android.content.pm.IPackageDeleteObserver2;
import android.content.pm.VersionedPackage;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IObricPackageManagerService extends IObricBase {
    void destroyExternalAppData(String r1, int r2, int r3, Installer r4);

    default void setPendingClearAppData(String pkgName) {
    }

    default void systemReady() {
    }

    default void beforeScan() {
    }

    default boolean isRemovableSysApp(String pkgName) {
        return false;
    }

    default boolean recoveryRemovableSystemApp(String scanPath, String packageName) {
        return false;
    }

    default IObricPackageManager getIObricExt() {
        return null;
    }

    default int deletePackageVersionedBefore(VersionedPackage versionedPackage, int deleteFlags, int userId) {
        return deleteFlags;
    }

    default void deletePackageVersionedAfter(VersionedPackage versionedPackage, int deleteFlags, DeletePackageHelper deletePackageHelper, IPackageDeleteObserver2 observer, int userId, int callingUid) {
    }

    default void deletePackageVersioned(VersionedPackage versionedPackage, int deleteFlags, DeletePackageHelper deletePackageHelper, IPackageDeleteObserver2 observer, int userId, int callingUid) {
    }

    default void clearObricAssistPermission(String packageName, int userId) {
    }
}
