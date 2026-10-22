package com.android.server.backup;

import android.os.PowerManager;
import android.os.WorkSource;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public class BackupWakeLock {
    private final BackupManagerConstants mBackupManagerConstants;
    private boolean mHasQuit;
    private final PowerManager.WakeLock mPowerManagerWakeLock;
    private final String mUserIdMessage;

    public BackupWakeLock(PowerManager.WakeLock powerManagerWakeLock, int userId, BackupManagerConstants backupManagerConstants) {
        this.mHasQuit = false;
        this.mPowerManagerWakeLock = powerManagerWakeLock;
        this.mUserIdMessage = "[UserID:" + userId + "] ";
        this.mBackupManagerConstants = backupManagerConstants;
    }

    public synchronized void acquire() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mHasQuit == false) goto L10;
        Slog.d(BackupManagerService.TAG, this.mUserIdMessage + "Ignore wakelock acquire after quit: " + this.mPowerManagerWakeLock.getTag());     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        this.mPowerManagerWakeLock.acquire(this.mBackupManagerConstants.getWakelockTimeoutMillis());     // Catch: Throwable -> L8
        Slog.d(BackupManagerService.TAG, this.mUserIdMessage + "Acquired wakelock:" + this.mPowerManagerWakeLock.getTag());     // Catch: Throwable -> L8
        monitor-exit(this);
    }

    public synchronized void release() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mHasQuit == false) goto L11;
        Slog.d(BackupManagerService.TAG, this.mUserIdMessage + "Ignore wakelock release after quit: " + this.mPowerManagerWakeLock.getTag());     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        if (this.mPowerManagerWakeLock.isHeld() == true) goto L15;
        Slog.w(BackupManagerService.TAG, this.mUserIdMessage + "Wakelock not held: " + this.mPowerManagerWakeLock.getTag());     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L15:
        this.mPowerManagerWakeLock.release();     // Catch: Throwable -> L8
        Slog.d(BackupManagerService.TAG, this.mUserIdMessage + "Released wakelock:" + this.mPowerManagerWakeLock.getTag());     // Catch: Throwable -> L8
        monitor-exit(this);
    }

    public synchronized boolean isHeld() {
        monitor-enter(this);
        boolean r0 = this.mPowerManagerWakeLock.isHeld();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void quit() {
        monitor-enter(this);
    L13:
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mPowerManagerWakeLock.isHeld() == false) goto L8;
        Slog.d(BackupManagerService.TAG, this.mUserIdMessage + "Releasing wakelock: " + this.mPowerManagerWakeLock.getTag());     // Catch: Throwable -> L6
        this.mPowerManagerWakeLock.release();     // Catch: Throwable -> L6
        goto L13
    L8:
        this.mHasQuit = true;     // Catch: Throwable -> L6
        monitor-exit(this);
    }

    public void setWorkSource(WorkSource workSource) {
        this.mPowerManagerWakeLock.setWorkSource(workSource);
    }
}
