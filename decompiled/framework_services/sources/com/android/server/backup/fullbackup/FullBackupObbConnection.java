package com.android.server.backup.fullbackup;

import android.app.backup.IBackupManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.UserHandle;
import android.util.Slog;
import com.android.internal.backup.IObbBackupService;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.backup.BackupManagerService;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.backup.utils.FullBackupUtils;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class FullBackupObbConnection implements ServiceConnection {
    private UserBackupManagerService backupManagerService;
    private final BackupAgentTimeoutParameters mAgentTimeoutParameters;
    volatile IObbBackupService mService;

    public FullBackupObbConnection(UserBackupManagerService backupManagerService) {
        this.backupManagerService = backupManagerService;
        this.mService = null;
        BackupAgentTimeoutParameters r0 = backupManagerService.getAgentTimeoutParameters();
        r0.getClass();
        this.mAgentTimeoutParameters = r0;
    }

    public void establish() {
        Intent obbIntent = new Intent().setComponent(new ComponentName(UserBackupManagerService.SHARED_BACKUP_AGENT_PACKAGE, "com.android.sharedstoragebackup.ObbBackupService"));
        this.backupManagerService.getContext().bindServiceAsUser(obbIntent, this, 1, UserHandle.SYSTEM);
    }

    public void tearDown() {
        this.backupManagerService.getContext().unbindService(this);
    }

    public boolean backupObbs(PackageInfo pkg, OutputStream out) {
        boolean success = false;
        waitForConnection();
        ParcelFileDescriptor[] pipes = null;
        pipes = ParcelFileDescriptor.createPipe();     // Catch: Throwable -> L15 Exception -> L17
        int token = this.backupManagerService.generateRandomIntegerToken();     // Catch: Throwable -> L15 Exception -> L17
        long fullBackupAgentTimeoutMillis = this.mAgentTimeoutParameters.getFullBackupAgentTimeoutMillis();     // Catch: Throwable -> L15 Exception -> L17
        this.backupManagerService.prepareOperationTimeout(token, fullBackupAgentTimeoutMillis, null, 0);     // Catch: Throwable -> L15 Exception -> L17
        this.mService.backupObbs(pkg.packageName, pipes[1], token, this.backupManagerService.getBackupManagerBinder());     // Catch: Throwable -> L15 Exception -> L17
        FullBackupUtils.routeSocketDataToOutput(pipes[0], out);     // Catch: Throwable -> L15 Exception -> L17
        success = this.backupManagerService.waitUntilOperationComplete(token);     // Catch: Throwable -> L15 Exception -> L17
        out.flush();     // Catch: IOException -> L8
        if (pipes[0] == null) goto L11;
        pipes[0].close();     // Catch: IOException -> L8
    L11:
        if (pipes[1] == null) goto L28;
        pipes[1].close();     // Catch: IOException -> L8
    L28:
        return success;
    L8:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "I/O error closing down OBB backup", e);
    L17:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "Unable to back up OBBs for " + pkg, e);     // Catch: Throwable -> L15
        out.flush();     // Catch: IOException -> L8
        if (pipes == null) goto L28;
        if (pipes[0] == null) goto L25;
        pipes[0].close();     // Catch: IOException -> L8
    L25:
        if (pipes[1] == null) goto L28;
        pipes[1].close();     // Catch: IOException -> L8
    L15:
        e = move-exception;
        ParcelFileDescriptor[] pipes2 = pipes;
        out.flush();     // Catch: IOException -> L34
        if (pipes2 != null) goto L32;
        throw e;
    L32:
        if (pipes2[0] == null) goto L37;
        pipes2[0].close();     // Catch: IOException -> L34
    L37:
        if (pipes2[1] == null) goto L49;
        pipes2[1].close();     // Catch: IOException -> L34
        throw e;
    L49:
        throw e;
    L34:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "I/O error closing down OBB backup", e);
        throw e;
    }

    public void restoreObbFile(String pkgName, ParcelFileDescriptor data, long fileSize, int type, String path, long mode, long mtime, int token, IBackupManager callbackBinder) {
        waitForConnection();
        this.mService.restoreObbFile(pkgName, data, fileSize, type, path, mode, mtime, token, callbackBinder);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "Unable to restore OBBs for " + pkgName, e);
    }

    private void waitForConnection() {
        monitor-enter(this);
    L15:
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mService != null) goto L11;
        wait();     // Catch: Throwable -> L7 InterruptedException -> L9
        goto L15
    L11:
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        monitor-enter(this);
        this.mService = IObbBackupService.Stub.asInterface(service);     // Catch: Throwable -> L6
        notifyAll();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        monitor-enter(this);
        this.mService = null;     // Catch: Throwable -> L7
        notifyAll();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
