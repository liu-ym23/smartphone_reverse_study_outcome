package com.android.server.backup.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Slog;
import com.android.server.backup.BackupManagerService;
import com.android.server.backup.UserBackupManagerService;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class RunInitializeReceiver extends BroadcastReceiver {
    private final UserBackupManagerService mUserBackupManagerService;

    public RunInitializeReceiver(UserBackupManagerService userBackupManagerService) {
        this.mUserBackupManagerService = userBackupManagerService;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (UserBackupManagerService.RUN_INITIALIZE_ACTION.equals(intent.getAction()) == true) goto L5;
        return;
    L5:
        Object r0 = this.mUserBackupManagerService.getQueueLock();
        monitor-enter(r0);
        Set<String> pendingInits = this.mUserBackupManagerService.getPendingInits();     // Catch: Throwable -> L10
        Slog.d(BackupManagerService.TAG, "Running a device init; " + pendingInits.size() + " pending");     // Catch: Throwable -> L10
        if (pendingInits.size() <= 0) goto L12;
        String[] transports = (String[]) pendingInits.toArray(new String[pendingInits.size()]);     // Catch: Throwable -> L10
        this.mUserBackupManagerService.clearPendingInits();     // Catch: Throwable -> L10
        this.mUserBackupManagerService.initializeTransports(transports, null);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
