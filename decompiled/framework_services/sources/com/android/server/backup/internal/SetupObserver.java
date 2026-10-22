package com.android.server.backup.internal;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.android.server.backup.KeyValueBackupJob;
import com.android.server.backup.UserBackupManagerService;

/* JADX INFO: loaded from: classes.dex */
public class SetupObserver extends ContentObserver {
    private final Context mContext;
    private final UserBackupManagerService mUserBackupManagerService;
    private final int mUserId;

    public SetupObserver(UserBackupManagerService userBackupManagerService, Handler handler) {
        super(handler);
        this.mUserBackupManagerService = userBackupManagerService;
        this.mContext = userBackupManagerService.getContext();
        this.mUserId = userBackupManagerService.getUserId();
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange) {
        boolean previousSetupComplete = this.mUserBackupManagerService.isSetupComplete();
        boolean newSetupComplete = UserBackupManagerService.getSetupCompleteSettingForUser(this.mContext, this.mUserId);
        if (previousSetupComplete == true) goto L7;
        if (newSetupComplete == true) goto L7;
        boolean resolvedSetupComplete = false;
    L8:
        this.mUserBackupManagerService.setSetupComplete(resolvedSetupComplete);
        Object r3 = this.mUserBackupManagerService.getQueueLock();
        monitor-enter(r3);
        if (resolvedSetupComplete == false) goto L17;
        if (previousSetupComplete == true) goto L17;
    L15:
        th = move-exception;
        throw th;
    L13:
        if (this.mUserBackupManagerService.isEnabled() == false) goto L17;
        KeyValueBackupJob.schedule(this.mUserBackupManagerService.getUserId(), this.mContext, this.mUserBackupManagerService);     // Catch: Throwable -> L15
        this.mUserBackupManagerService.scheduleNextFullBackupJob(0);     // Catch: Throwable -> L15
    L17:
        monitor-exit(r3);     // Catch: Throwable -> L15
        return;
    L7:
        resolvedSetupComplete = true;
        goto L8
    }
}
