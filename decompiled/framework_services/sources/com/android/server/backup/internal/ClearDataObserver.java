package com.android.server.backup.internal;

import android.content.pm.IPackageDataObserver;
import com.android.server.backup.UserBackupManagerService;

/* JADX INFO: loaded from: classes.dex */
public class ClearDataObserver extends IPackageDataObserver.Stub {
    private UserBackupManagerService backupManagerService;

    public ClearDataObserver(UserBackupManagerService backupManagerService) {
        this.backupManagerService = backupManagerService;
    }

    public void onRemoveCompleted(String packageName, boolean succeeded) {
        Object r0 = this.backupManagerService.getClearDataLock();
        monitor-enter(r0);
        this.backupManagerService.setClearingData(false);     // Catch: Throwable -> L7
        this.backupManagerService.getClearDataLock().notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
