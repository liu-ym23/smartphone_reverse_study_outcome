package com.android.server.backup.internal;

import android.content.pm.PackageInfo;
import android.util.Slog;
import com.android.server.backup.BackupManagerService;
import com.android.server.backup.TransportManager;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.backup.transport.BackupTransportClient;
import com.android.server.backup.transport.TransportConnection;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class PerformClearTask implements Runnable {
    private final UserBackupManagerService mBackupManagerService;
    private final OnTaskFinishedListener mListener;
    private final PackageInfo mPackage;
    private final TransportConnection mTransportConnection;
    private final TransportManager mTransportManager;

    PerformClearTask(UserBackupManagerService backupManagerService, TransportConnection transportConnection, PackageInfo packageInfo, OnTaskFinishedListener listener) {
        this.mBackupManagerService = backupManagerService;
        this.mTransportManager = backupManagerService.getTransportManager();
        this.mTransportConnection = transportConnection;
        this.mPackage = packageInfo;
        this.mListener = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        BackupTransportClient transport = null;
        String transportDirName = this.mTransportManager.getTransportDirName(this.mTransportConnection.getTransportComponent());     // Catch: Throwable -> L10 Exception -> L12
        File stateDir = new File(this.mBackupManagerService.getBaseStateDir(), transportDirName);     // Catch: Throwable -> L10 Exception -> L12
        File stateFile = new File(stateDir, this.mPackage.packageName);     // Catch: Throwable -> L10 Exception -> L12
        stateFile.delete();     // Catch: Throwable -> L10 Exception -> L12
        transport = this.mTransportConnection.connectOrThrow("PerformClearTask.run()");     // Catch: Throwable -> L10 Exception -> L12
        transport.clearBackupData(this.mPackage);     // Catch: Throwable -> L10 Exception -> L12
        transport.finishBackup();     // Catch: Exception -> L6
    L27:
    L9:
        this.mListener.onFinished("PerformClearTask.run()");
        this.mBackupManagerService.getWakeLock().release();
        return;
    L6:
        e = e;
        StringBuilder r5 = new StringBuilder();
    L8:
        r5.append("Unable to mark clear operation finished: ");
        r5.append(e.getMessage());
        Slog.e(BackupManagerService.TAG, r5.toString());
        goto L9
    L10:
        th = move-exception;
        if (transport != null) goto L32;
    L25:
        this.mListener.onFinished("PerformClearTask.run()");
        this.mBackupManagerService.getWakeLock().release();
        throw th;
    L32:
        transport.finishBackup();     // Catch: Exception -> L23
    L23:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "Unable to mark clear operation finished: " + e.getMessage());
    L12:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "Transport threw clearing data for " + this.mPackage + ": " + e.getMessage());     // Catch: Throwable -> L10
        if (transport == null) goto L27;
        transport.finishBackup();     // Catch: Exception -> L17
    L17:
        e = e;
        r5 = new StringBuilder();
        goto L8
    }
}
