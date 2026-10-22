package com.android.server.backup;

import android.content.ContentResolver;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.KeyValueListParser;
import android.util.KeyValueSettingObserver;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public class BackupManagerConstants extends KeyValueSettingObserver {
    public static final String BACKUP_FINISHED_NOTIFICATION_RECEIVERS = "backup_finished_notification_receivers";
    public static final String DEFAULT_BACKUP_FINISHED_NOTIFICATION_RECEIVERS = "";
    public static final long DEFAULT_FULL_BACKUP_INTERVAL_MILLISECONDS = 86400000;
    public static final int DEFAULT_FULL_BACKUP_REQUIRED_NETWORK_TYPE = 2;
    public static final boolean DEFAULT_FULL_BACKUP_REQUIRE_CHARGING = true;
    public static final long DEFAULT_KEY_VALUE_BACKUP_FUZZ_MILLISECONDS = 600000;
    public static final long DEFAULT_KEY_VALUE_BACKUP_INTERVAL_MILLISECONDS = 14400000;
    public static final int DEFAULT_KEY_VALUE_BACKUP_REQUIRED_NETWORK_TYPE = 1;
    public static final boolean DEFAULT_KEY_VALUE_BACKUP_REQUIRE_CHARGING = true;
    public static final long DEFAULT_WAKELOCK_TIMEOUT_MILLIS = 1800000;
    public static final String FULL_BACKUP_INTERVAL_MILLISECONDS = "full_backup_interval_milliseconds";
    public static final String FULL_BACKUP_REQUIRED_NETWORK_TYPE = "full_backup_required_network_type";
    public static final String FULL_BACKUP_REQUIRE_CHARGING = "full_backup_require_charging";
    public static final String KEY_VALUE_BACKUP_FUZZ_MILLISECONDS = "key_value_backup_fuzz_milliseconds";
    public static final String KEY_VALUE_BACKUP_INTERVAL_MILLISECONDS = "key_value_backup_interval_milliseconds";
    public static final String KEY_VALUE_BACKUP_REQUIRED_NETWORK_TYPE = "key_value_backup_required_network_type";
    public static final String KEY_VALUE_BACKUP_REQUIRE_CHARGING = "key_value_backup_require_charging";
    private static final String SETTING = "backup_manager_constants";
    private static final String TAG = "BackupManagerConstants";
    public static final String WAKELOCK_TIMEOUT_MILLIS = "wakelock_timeout_millis";
    private String[] mBackupFinishedNotificationReceivers;
    private long mFullBackupIntervalMilliseconds;
    private boolean mFullBackupRequireCharging;
    private int mFullBackupRequiredNetworkType;
    private long mKeyValueBackupFuzzMilliseconds;
    private long mKeyValueBackupIntervalMilliseconds;
    private boolean mKeyValueBackupRequireCharging;
    private int mKeyValueBackupRequiredNetworkType;
    private long mWakelockTimeoutMillis;

    public BackupManagerConstants(Handler handler, ContentResolver resolver) {
        super(handler, resolver, Settings.Secure.getUriFor(SETTING));
    }

    public String getSettingValue(ContentResolver resolver) {
        return Settings.Secure.getStringForUser(resolver, SETTING, resolver.getUserId());
    }

    public synchronized void update(KeyValueListParser parser) {
        monitor-enter(this);
        this.mKeyValueBackupIntervalMilliseconds = parser.getLong(KEY_VALUE_BACKUP_INTERVAL_MILLISECONDS, 14400000);     // Catch: Throwable -> L6
        this.mKeyValueBackupFuzzMilliseconds = parser.getLong(KEY_VALUE_BACKUP_FUZZ_MILLISECONDS, 600000);     // Catch: Throwable -> L6
        this.mKeyValueBackupRequireCharging = parser.getBoolean(KEY_VALUE_BACKUP_REQUIRE_CHARGING, true);     // Catch: Throwable -> L6
        this.mKeyValueBackupRequiredNetworkType = parser.getInt(KEY_VALUE_BACKUP_REQUIRED_NETWORK_TYPE, 1);     // Catch: Throwable -> L6
        this.mFullBackupIntervalMilliseconds = parser.getLong(FULL_BACKUP_INTERVAL_MILLISECONDS, 86400000);     // Catch: Throwable -> L6
        this.mFullBackupRequireCharging = parser.getBoolean(FULL_BACKUP_REQUIRE_CHARGING, true);     // Catch: Throwable -> L6
        this.mFullBackupRequiredNetworkType = parser.getInt(FULL_BACKUP_REQUIRED_NETWORK_TYPE, 2);     // Catch: Throwable -> L6
        String backupFinishedNotificationReceivers = parser.getString(BACKUP_FINISHED_NOTIFICATION_RECEIVERS, "");     // Catch: Throwable -> L6
        if (backupFinishedNotificationReceivers.isEmpty() == false) goto L8;
        this.mBackupFinishedNotificationReceivers = new String[0];     // Catch: Throwable -> L6
    L9:
        this.mWakelockTimeoutMillis = parser.getLong(WAKELOCK_TIMEOUT_MILLIS, 1800000);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L8:
        this.mBackupFinishedNotificationReceivers = backupFinishedNotificationReceivers.split(":");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long getKeyValueBackupIntervalMilliseconds() {
        monitor-enter(this);
        Slog.d(TAG, "getKeyValueBackupIntervalMilliseconds(...) returns " + this.mKeyValueBackupIntervalMilliseconds);     // Catch: Throwable -> L6
        long r0 = this.mKeyValueBackupIntervalMilliseconds;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long getKeyValueBackupFuzzMilliseconds() {
        monitor-enter(this);
        Slog.d(TAG, "getKeyValueBackupFuzzMilliseconds(...) returns " + this.mKeyValueBackupFuzzMilliseconds);     // Catch: Throwable -> L6
        long r0 = this.mKeyValueBackupFuzzMilliseconds;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean getKeyValueBackupRequireCharging() {
        monitor-enter(this);
        Slog.d(TAG, "getKeyValueBackupRequireCharging(...) returns " + this.mKeyValueBackupRequireCharging);     // Catch: Throwable -> L6
        boolean r0 = this.mKeyValueBackupRequireCharging;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getKeyValueBackupRequiredNetworkType() {
        monitor-enter(this);
        Slog.d(TAG, "getKeyValueBackupRequiredNetworkType(...) returns " + this.mKeyValueBackupRequiredNetworkType);     // Catch: Throwable -> L6
        int r0 = this.mKeyValueBackupRequiredNetworkType;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long getFullBackupIntervalMilliseconds() {
        monitor-enter(this);
        Slog.d(TAG, "getFullBackupIntervalMilliseconds(...) returns " + this.mFullBackupIntervalMilliseconds);     // Catch: Throwable -> L6
        long r0 = this.mFullBackupIntervalMilliseconds;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean getFullBackupRequireCharging() {
        monitor-enter(this);
        Slog.d(TAG, "getFullBackupRequireCharging(...) returns " + this.mFullBackupRequireCharging);     // Catch: Throwable -> L6
        boolean r0 = this.mFullBackupRequireCharging;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getFullBackupRequiredNetworkType() {
        monitor-enter(this);
        Slog.d(TAG, "getFullBackupRequiredNetworkType(...) returns " + this.mFullBackupRequiredNetworkType);     // Catch: Throwable -> L6
        int r0 = this.mFullBackupRequiredNetworkType;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String[] getBackupFinishedNotificationReceivers() {
        monitor-enter(this);
        Slog.d(TAG, "getBackupFinishedNotificationReceivers(...) returns " + TextUtils.join(", ", this.mBackupFinishedNotificationReceivers));     // Catch: Throwable -> L6
        String[] r0 = this.mBackupFinishedNotificationReceivers;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long getWakelockTimeoutMillis() {
        monitor-enter(this);
        Slog.d(TAG, "wakelock timeout: " + this.mWakelockTimeoutMillis);     // Catch: Throwable -> L6
        long r0 = this.mWakelockTimeoutMillis;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
