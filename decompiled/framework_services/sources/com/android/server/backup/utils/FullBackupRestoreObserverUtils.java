package com.android.server.backup.utils;

import android.app.backup.IFullBackupRestoreObserver;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.backup.BackupManagerService;

/* JADX INFO: loaded from: classes.dex */
public class FullBackupRestoreObserverUtils {
    public FullBackupRestoreObserverUtils() {
    }

    public static IFullBackupRestoreObserver sendStartRestore(IFullBackupRestoreObserver observer) {
        if (observer == null) goto L10;
        observer.onStartRestore();     // Catch: RemoteException -> L5
        return observer;
    L6:
        Slog.w(BackupManagerService.TAG, "full restore observer went away: startRestore");
        return null;
    L10:
        return observer;
    }

    public static IFullBackupRestoreObserver sendOnRestorePackage(IFullBackupRestoreObserver observer, String name) {
        if (observer == null) goto L10;
        observer.onRestorePackage(name);     // Catch: RemoteException -> L5
        return observer;
    L6:
        Slog.w(BackupManagerService.TAG, "full restore observer went away: restorePackage");
        return null;
    L10:
        return observer;
    }

    public static IFullBackupRestoreObserver sendEndRestore(IFullBackupRestoreObserver observer) {
        if (observer == null) goto L10;
        observer.onEndRestore();     // Catch: RemoteException -> L5
        return observer;
    L6:
        Slog.w(BackupManagerService.TAG, "full restore observer went away: endRestore");
        return null;
    L10:
        return observer;
    }
}
