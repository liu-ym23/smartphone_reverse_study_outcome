package com.android.server.content;

import android.content.Context;
import android.database.ContentObserver;
import android.provider.Settings;
import android.util.KeyValueListParser;
import android.util.Slog;
import com.android.internal.os.BackgroundThread;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class SyncManagerConstants extends ContentObserver {
    private static final int DEF_EXEMPTION_TEMP_ALLOWLIST_DURATION_IN_SECONDS = 600;
    private static final int DEF_INITIAL_SYNC_RETRY_TIME_IN_SECONDS = 30;
    private static final int DEF_MAX_RETRIES_WITH_APP_STANDBY_EXEMPTION = 5;
    private static final int DEF_MAX_SYNC_RETRY_TIME_IN_SECONDS = 3600;
    private static final float DEF_RETRY_TIME_INCREASE_FACTOR = 2.0f;
    private static final String KEY_EXEMPTION_TEMP_ALLOWLIST_DURATION_IN_SECONDS = "exemption_temp_whitelist_duration_in_seconds";
    private static final String KEY_INITIAL_SYNC_RETRY_TIME_IN_SECONDS = "initial_sync_retry_time_in_seconds";
    private static final String KEY_MAX_RETRIES_WITH_APP_STANDBY_EXEMPTION = "max_retries_with_app_standby_exemption";
    private static final String KEY_MAX_SYNC_RETRY_TIME_IN_SECONDS = "max_sync_retry_time_in_seconds";
    private static final String KEY_RETRY_TIME_INCREASE_FACTOR = "retry_time_increase_factor";
    private static final String TAG = "SyncManagerConfig";
    private final Context mContext;
    private int mInitialSyncRetryTimeInSeconds;
    private int mKeyExemptionTempWhitelistDurationInSeconds;
    private final Object mLock;
    private int mMaxRetriesWithAppStandbyExemption;
    private int mMaxSyncRetryTimeInSeconds;
    private float mRetryTimeIncreaseFactor;

    public static /* synthetic */ void $r8$lambda$C0hj3KUN5qSzbVr_vPnWooTwtTU(SyncManagerConstants r0) {
        r0.lambda$start$0();
    }

    protected SyncManagerConstants(Context context) {
        super(null);
        this.mLock = new Object();
        this.mInitialSyncRetryTimeInSeconds = 30;
        this.mRetryTimeIncreaseFactor = DEF_RETRY_TIME_INCREASE_FACTOR;
        this.mMaxSyncRetryTimeInSeconds = DEF_MAX_SYNC_RETRY_TIME_IN_SECONDS;
        this.mMaxRetriesWithAppStandbyExemption = 5;
        this.mKeyExemptionTempWhitelistDurationInSeconds = 600;
        this.mContext = context;
    }

    public void start() {
        BackgroundThread.getHandler().post(new SyncManagerConstants$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$start$0() {
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("sync_manager_constants"), false, this);
        refresh();
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange) {
        refresh();
    }

    private void refresh() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String newValue = Settings.Global.getString(this.mContext.getContentResolver(), "sync_manager_constants");     // Catch: Throwable -> L7
        KeyValueListParser parser = new KeyValueListParser(',');     // Catch: Throwable -> L7
        parser.setString(newValue);     // Catch: Throwable -> L7 IllegalArgumentException -> L9
    L11:
        this.mInitialSyncRetryTimeInSeconds = parser.getInt(KEY_INITIAL_SYNC_RETRY_TIME_IN_SECONDS, 30);     // Catch: Throwable -> L7
        this.mMaxSyncRetryTimeInSeconds = parser.getInt(KEY_MAX_SYNC_RETRY_TIME_IN_SECONDS, DEF_MAX_SYNC_RETRY_TIME_IN_SECONDS);     // Catch: Throwable -> L7
        this.mRetryTimeIncreaseFactor = parser.getFloat(KEY_RETRY_TIME_INCREASE_FACTOR, DEF_RETRY_TIME_INCREASE_FACTOR);     // Catch: Throwable -> L7
        this.mMaxRetriesWithAppStandbyExemption = parser.getInt(KEY_MAX_RETRIES_WITH_APP_STANDBY_EXEMPTION, 5);     // Catch: Throwable -> L7
        this.mKeyExemptionTempWhitelistDurationInSeconds = parser.getInt(KEY_EXEMPTION_TEMP_ALLOWLIST_DURATION_IN_SECONDS, 600);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L10:
        Slog.wtf(TAG, "Bad constants: " + newValue);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public int getInitialSyncRetryTimeInSeconds() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mInitialSyncRetryTimeInSeconds;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public float getRetryTimeIncreaseFactor() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        float r1 = this.mRetryTimeIncreaseFactor;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getMaxSyncRetryTimeInSeconds() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mMaxSyncRetryTimeInSeconds;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getMaxRetriesWithAppStandbyExemption() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mMaxRetriesWithAppStandbyExemption;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getKeyExemptionTempWhitelistDurationInSeconds() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mKeyExemptionTempWhitelistDurationInSeconds;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter pw, String prefix) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.println("SyncManager Config:");     // Catch: Throwable -> L7
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("  mInitialSyncRetryTimeInSeconds=");     // Catch: Throwable -> L7
        pw.println(this.mInitialSyncRetryTimeInSeconds);     // Catch: Throwable -> L7
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("  mRetryTimeIncreaseFactor=");     // Catch: Throwable -> L7
        pw.println(this.mRetryTimeIncreaseFactor);     // Catch: Throwable -> L7
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("  mMaxSyncRetryTimeInSeconds=");     // Catch: Throwable -> L7
        pw.println(this.mMaxSyncRetryTimeInSeconds);     // Catch: Throwable -> L7
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("  mMaxRetriesWithAppStandbyExemption=");     // Catch: Throwable -> L7
        pw.println(this.mMaxRetriesWithAppStandbyExemption);     // Catch: Throwable -> L7
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("  mKeyExemptionTempWhitelistDurationInSeconds=");     // Catch: Throwable -> L7
        pw.println(this.mKeyExemptionTempWhitelistDurationInSeconds);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
