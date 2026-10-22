package com.android.server.backup.fullbackup;

import android.app.backup.IFullBackupRestoreObserver;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.backup.BackupManagerService;

/* JADX INFO: loaded from: classes.dex */
public abstract class FullBackupTask implements Runnable {
    IFullBackupRestoreObserver mObserver;

    FullBackupTask(IFullBackupRestoreObserver observer) {
        this.mObserver = observer;
    }

    final void sendStartBackup() {
        if (this.mObserver == null) goto L11;
        this.mObserver.onStartBackup();     // Catch: RemoteException -> L6
        return;
    L7:
        Slog.w(BackupManagerService.TAG, "full backup observer went away: startBackup");
        this.mObserver = null;
        return;
    }

    final void sendOnBackupPackage(String name) {
        if (this.mObserver == null) goto L11;
        this.mObserver.onBackupPackage(name);     // Catch: RemoteException -> L6
        return;
    L7:
        Slog.w(BackupManagerService.TAG, "full backup observer went away: backupPackage");
        this.mObserver = null;
        return;
    }

    final void sendEndBackup() {
        if (this.mObserver == null) goto L11;
        this.mObserver.onEndBackup();     // Catch: RemoteException -> L6
        return;
    L7:
        Slog.w(BackupManagerService.TAG, "full backup observer went away: endBackup");
        this.mObserver = null;
        return;
    }
}
