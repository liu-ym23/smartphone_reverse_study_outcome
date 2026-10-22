package com.android.server.rollback;

import android.content.rollback.PackageRollbackInfo;
import android.os.storage.StorageManager;
import android.util.Slog;
import com.android.server.pm.ApexManager;
import com.android.server.pm.Installer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AppDataRollbackHelper {
    private static final String TAG = "RollbackManager";
    private final ApexManager mApexManager;
    private final Installer mInstaller;

    AppDataRollbackHelper(Installer installer) {
        this.mInstaller = installer;
        this.mApexManager = ApexManager.getInstance();
    }

    AppDataRollbackHelper(Installer installer, ApexManager apexManager) {
        this.mInstaller = installer;
        this.mApexManager = apexManager;
    }

    public void snapshotAppData(int rollbackId, PackageRollbackInfo packageRollbackInfo, int[] userIds) {
        int r0 = userIds.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        int user = userIds[r1];
        if (isUserCredentialLocked(user) == false) goto L7;
        Slog.v(TAG, "User: " + user + " isn't unlocked, skipping CE userdata backup.");
        int storageFlags = 1;
        packageRollbackInfo.addPendingBackup(user);
    L8:
        doSnapshot(packageRollbackInfo, user, rollbackId, storageFlags);
        r1 = r1 + 1;
        goto L3
    L7:
        storageFlags = 3;
        goto L8
    }

    public boolean restoreAppData(int rollbackId, PackageRollbackInfo packageRollbackInfo, int userId, int appId, String seInfo) {
        int storageFlags = 1;
        List<Integer> pendingBackups = packageRollbackInfo.getPendingBackups();
        List<PackageRollbackInfo.RestoreInfo> pendingRestores = packageRollbackInfo.getPendingRestores();
        if (pendingBackups == null) goto L8;
        if (pendingBackups.indexOf(Integer.valueOf(userId)) == (-1)) goto L8;
        pendingBackups.remove(pendingBackups.indexOf(Integer.valueOf(userId)));
        boolean changedRollback = true;
    L11:
        doRestoreOrWipe(packageRollbackInfo, userId, rollbackId, appId, seInfo, storageFlags);
        return changedRollback;
    L8:
        if (isUserCredentialLocked(userId) == false) goto L10;
        pendingRestores.add(new PackageRollbackInfo.RestoreInfo(userId, appId, seInfo));
        changedRollback = true;
        goto L11
    L10:
        storageFlags = 1 | 2;
        changedRollback = false;
        goto L11
    }

    private boolean doSnapshot(PackageRollbackInfo packageRollbackInfo, int userId, int rollbackId, int flags) {
        if (packageRollbackInfo.isApex() == true) goto L5;
        return this.mInstaller.snapshotAppData(packageRollbackInfo.getPackageName(), userId, rollbackId, flags);
    L12:
        ie = move-exception;
        Slog.e(TAG, "Unable to create app data snapshot for: " + packageRollbackInfo.getPackageName() + ", userId: " + userId, ie);
        return false;
    L5:
        if ((flags & 2) != 0) goto L7;
        return true;
    L7:
        return this.mApexManager.snapshotCeData(userId, rollbackId, packageRollbackInfo.getPackageName());
    }

    private boolean doRestoreOrWipe(PackageRollbackInfo packageRollbackInfo, int userId, int rollbackId, int appId, String seInfo, int flags) {
        if (packageRollbackInfo.isApex() == true) goto L5;
    L15:
        ie = move-exception;
        Slog.e(TAG, "Unable to restore/wipe app data: " + packageRollbackInfo.getPackageName() + " policy=" + packageRollbackInfo.getRollbackDataPolicy(), ie);
        return false;
    L12:
        switch(packageRollbackInfo.getRollbackDataPolicy()) {
            case 0: goto L17;
            case 1: goto L14;
            default: goto L23;
        };     // Catch: Installer.InstallerException -> L15
    L14:
        this.mInstaller.clearAppData(null, packageRollbackInfo.getPackageName(), userId, flags, 0);     // Catch: Installer.InstallerException -> L15
        goto L23
    L17:
        this.mInstaller.restoreAppDataSnapshot(packageRollbackInfo.getPackageName(), appId, seInfo, userId, rollbackId, flags);     // Catch: Installer.InstallerException -> L15
    L23:
        return true;
    L5:
        switch(packageRollbackInfo.getRollbackDataPolicy()) {
            case 0: goto L9;
            case 1: goto L28;
            default: goto L28;
        };
    L28:
        return true;
    L9:
        if ((flags & 2) == 0) goto L26;
        this.mApexManager.restoreCeData(userId, rollbackId, packageRollbackInfo.getPackageName());
        return true;
    L26:
        return true;
    }

    public void destroyAppDataSnapshot(int rollbackId, PackageRollbackInfo packageRollbackInfo, int user) {
        this.mInstaller.destroyAppDataSnapshot(packageRollbackInfo.getPackageName(), user, rollbackId, 3);     // Catch: Installer.InstallerException -> L4
        return;
    L4:
        ie = move-exception;
        Slog.e(TAG, "Unable to delete app data snapshot for " + packageRollbackInfo.getPackageName(), ie);
    }

    public void destroyApexDeSnapshots(int rollbackId) {
        this.mApexManager.destroyDeSnapshots(rollbackId);
    }

    public void destroyApexCeSnapshots(int userId, int rollbackId) {
        if (isUserCredentialLocked(userId) == true) goto L6;
        this.mApexManager.destroyCeSnapshots(userId, rollbackId);
        return;
    }

    boolean commitPendingBackupAndRestoreForUser(int userId, Rollback rollback) {
        boolean foundBackupOrRestore = false;
        Iterator r1 = rollback.info.getPackages().iterator();
    L4:
        if (r1.hasNext() == false) goto L28;
        PackageRollbackInfo info = (PackageRollbackInfo) r1.next();
        boolean hasPendingBackup = false;
        List<Integer> pendingBackupUsers = info.getPendingBackups();
        if (pendingBackupUsers != null) goto L8;
    L10:
        PackageRollbackInfo.RestoreInfo ri = info.getRestoreInfo(userId);
        if (ri == null) goto L13;
        foundBackupOrRestore = true;
        boolean hasPendingRestore = true;
    L14:
        if (hasPendingBackup == false) goto L17;
        if (hasPendingRestore == false) goto L17;
        info.removePendingBackup(userId);
        info.removePendingRestoreInfo(userId);
        int userId2 = userId;
    L27:
        userId = userId2;
    L17:
        if (hasPendingBackup == false) goto L21;
        int idx = pendingBackupUsers.indexOf(Integer.valueOf(userId));
        if (doSnapshot(info, userId, rollback.info.getRollbackId(), 2) == false) goto L21;
        pendingBackupUsers.remove(idx);
    L21:
        if (hasPendingRestore == false) goto L25;
        userId2 = userId;
        if (doRestoreOrWipe(info, userId2, rollback.info.getRollbackId(), ri.appId, ri.seInfo, 2) == false) goto L27;
        info.removeRestoreInfo(ri);
        goto L27
    L25:
        userId2 = userId;
        goto L27
    L13:
        hasPendingRestore = false;
        goto L14
    L8:
        if (pendingBackupUsers.indexOf(Integer.valueOf(userId)) == (-1)) goto L10;
        hasPendingBackup = true;
        foundBackupOrRestore = true;
        goto L10
    L28:
        return foundBackupOrRestore;
    }

    public boolean isUserCredentialLocked(int userId) {
        if (StorageManager.isFileEncrypted() == true) goto L5;
    L7:
        return false;
    L5:
        if (StorageManager.isCeStorageUnlocked(userId) == true) goto L7;
        return true;
    }
}
