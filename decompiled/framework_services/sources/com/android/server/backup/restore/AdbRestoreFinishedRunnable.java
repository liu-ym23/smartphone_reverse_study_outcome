package com.android.server.backup.restore;

import android.app.IBackupAgent;
import android.os.RemoteException;
import com.android.server.backup.UserBackupManagerService;

/* JADX INFO: loaded from: classes.dex */
public class AdbRestoreFinishedRunnable implements Runnable {
    private final IBackupAgent mAgent;
    private final UserBackupManagerService mBackupManagerService;
    private final int mToken;

    AdbRestoreFinishedRunnable(IBackupAgent agent, int token, UserBackupManagerService backupManagerService) {
        this.mAgent = agent;
        this.mToken = token;
        this.mBackupManagerService = backupManagerService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mAgent.doRestoreFinished(this.mToken, this.mBackupManagerService.getBackupManagerBinder());     // Catch: RemoteException -> L4
        return;
    }
}
