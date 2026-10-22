package com.android.server.backup;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.KeyValueListParser;
import android.util.KeyValueSettingObserver;

/* JADX INFO: loaded from: classes.dex */
public class BackupAgentTimeoutParameters extends KeyValueSettingObserver {
    public static final long DEFAULT_FULL_BACKUP_AGENT_TIMEOUT_MILLIS = 300000;
    public static final long DEFAULT_KV_BACKUP_AGENT_TIMEOUT_MILLIS = 30000;
    public static final long DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS = 3000;
    public static final long DEFAULT_RESTORE_AGENT_FINISHED_TIMEOUT_MILLIS = 30000;
    public static final long DEFAULT_RESTORE_AGENT_TIMEOUT_MILLIS = 60000;
    public static final long DEFAULT_RESTORE_SESSION_TIMEOUT_MILLIS = 60000;
    public static final long DEFAULT_RESTORE_SYSTEM_AGENT_TIMEOUT_MILLIS = 180000;
    public static final long DEFAULT_SHARED_BACKUP_AGENT_TIMEOUT_MILLIS = 1800000;
    public static final String SETTING = "backup_agent_timeout_parameters";
    public static final String SETTING_FULL_BACKUP_AGENT_TIMEOUT_MILLIS = "full_backup_agent_timeout_millis";
    public static final String SETTING_KV_BACKUP_AGENT_TIMEOUT_MILLIS = "kv_backup_agent_timeout_millis";
    public static final String SETTING_QUOTA_EXCEEDED_TIMEOUT_MILLIS = "quota_exceeded_timeout_millis";
    public static final String SETTING_RESTORE_AGENT_FINISHED_TIMEOUT_MILLIS = "restore_agent_finished_timeout_millis";
    public static final String SETTING_RESTORE_AGENT_TIMEOUT_MILLIS = "restore_agent_timeout_millis";
    public static final String SETTING_RESTORE_SESSION_TIMEOUT_MILLIS = "restore_session_timeout_millis";
    public static final String SETTING_RESTORE_SYSTEM_AGENT_TIMEOUT_MILLIS = "restore_system_agent_timeout_millis";
    public static final String SETTING_SHARED_BACKUP_AGENT_TIMEOUT_MILLIS = "shared_backup_agent_timeout_millis";
    private long mFullBackupAgentTimeoutMillis;
    private long mKvBackupAgentTimeoutMillis;
    private final Object mLock;
    private long mQuotaExceededTimeoutMillis;
    private long mRestoreAgentFinishedTimeoutMillis;
    private long mRestoreAgentTimeoutMillis;
    private long mRestoreSessionTimeoutMillis;
    private long mRestoreSystemAgentTimeoutMillis;
    private long mSharedBackupAgentTimeoutMillis;

    public BackupAgentTimeoutParameters(Handler handler, ContentResolver resolver) {
        super(handler, resolver, Settings.Global.getUriFor(SETTING));
        this.mLock = new Object();
    }

    public String getSettingValue(ContentResolver resolver) {
        return Settings.Global.getString(resolver, SETTING);
    }

    public void update(KeyValueListParser parser) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mKvBackupAgentTimeoutMillis = parser.getLong(SETTING_KV_BACKUP_AGENT_TIMEOUT_MILLIS, 30000);     // Catch: Throwable -> L7
        this.mFullBackupAgentTimeoutMillis = parser.getLong(SETTING_FULL_BACKUP_AGENT_TIMEOUT_MILLIS, 300000);     // Catch: Throwable -> L7
        this.mSharedBackupAgentTimeoutMillis = parser.getLong(SETTING_SHARED_BACKUP_AGENT_TIMEOUT_MILLIS, 1800000);     // Catch: Throwable -> L7
        this.mRestoreAgentTimeoutMillis = parser.getLong(SETTING_RESTORE_AGENT_TIMEOUT_MILLIS, 60000);     // Catch: Throwable -> L7
        this.mRestoreSystemAgentTimeoutMillis = parser.getLong(SETTING_RESTORE_SYSTEM_AGENT_TIMEOUT_MILLIS, 180000);     // Catch: Throwable -> L7
        this.mRestoreAgentFinishedTimeoutMillis = parser.getLong(SETTING_RESTORE_AGENT_FINISHED_TIMEOUT_MILLIS, 30000);     // Catch: Throwable -> L7
        this.mRestoreSessionTimeoutMillis = parser.getLong(SETTING_RESTORE_SESSION_TIMEOUT_MILLIS, 60000);     // Catch: Throwable -> L7
        this.mQuotaExceededTimeoutMillis = parser.getLong(SETTING_QUOTA_EXCEEDED_TIMEOUT_MILLIS, DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public long getKvBackupAgentTimeoutMillis() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = this.mKvBackupAgentTimeoutMillis;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public long getFullBackupAgentTimeoutMillis() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = this.mFullBackupAgentTimeoutMillis;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public long getSharedBackupAgentTimeoutMillis() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = this.mSharedBackupAgentTimeoutMillis;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public long getRestoreAgentTimeoutMillis(int applicationUid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (UserHandle.isCore(applicationUid) == false) goto L9;
        long r1 = this.mRestoreSystemAgentTimeoutMillis;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L9:
        r1 = this.mRestoreAgentTimeoutMillis;     // Catch: Throwable -> L7
        goto L10
    }

    public long getRestoreSessionTimeoutMillis() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = this.mRestoreSessionTimeoutMillis;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public long getRestoreAgentFinishedTimeoutMillis() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = this.mRestoreAgentFinishedTimeoutMillis;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public long getQuotaExceededTimeoutMillis() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = this.mQuotaExceededTimeoutMillis;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
