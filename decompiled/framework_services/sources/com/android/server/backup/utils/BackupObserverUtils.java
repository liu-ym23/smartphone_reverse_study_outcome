package com.android.server.backup.utils;

import android.app.backup.BackupProgress;
import android.app.backup.IBackupObserver;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.backup.BackupManagerService;

/* JADX INFO: loaded from: classes.dex */
public class BackupObserverUtils {
    public BackupObserverUtils() {
    }

    public static void sendBackupOnUpdate(IBackupObserver observer, String packageName, BackupProgress progress) {
        if (observer == null) goto L10;
        observer.onUpdate(packageName, progress);     // Catch: RemoteException -> L5
        return;
    L6:
        Slog.w(BackupManagerService.TAG, "Backup observer went away: onUpdate");
        return;
    }

    public static void sendBackupOnPackageResult(IBackupObserver observer, String packageName, int status) {
        if (observer == null) goto L10;
        observer.onResult(packageName, status);     // Catch: RemoteException -> L5
        return;
    L6:
        Slog.w(BackupManagerService.TAG, "Backup observer went away: onResult");
        return;
    }

    public static void sendBackupFinished(IBackupObserver observer, int status) {
        if (observer == null) goto L10;
        observer.backupFinished(status);     // Catch: RemoteException -> L5
        return;
    L6:
        Slog.w(BackupManagerService.TAG, "Backup observer went away: backupFinished");
        return;
    }
}
