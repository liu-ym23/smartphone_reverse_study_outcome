package com.android.server.am;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.SystemProperties;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.util.IndentingPrintWriter;
import android.util.KeyValueListParser;
import android.util.Slog;
import android.util.TimeUtils;
import dalvik.annotation.optimization.NeverCompile;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class BroadcastConstants {
    private static final boolean DEFAULT_CORE_DEFER_UNTIL_ACTIVE = true;
    private static final long DEFAULT_DELAY_CACHED_MILLIS = 120000;
    private static final long DEFAULT_DELAY_FOREGROUND_PROC_MILLIS = -120000;
    private static final long DEFAULT_DELAY_NORMAL_MILLIS = 500;
    private static final long DEFAULT_DELAY_PERSISTENT_PROC_MILLIS = -120000;
    private static final long DEFAULT_DELAY_URGENT_MILLIS = -120000;
    private static final int DEFAULT_EXTRA_RUNNING_URGENT_PROCESS_QUEUES = 1;
    private static final int DEFAULT_MAX_CONSECUTIVE_NORMAL_DISPATCHES = 10;
    private static final int DEFAULT_MAX_CONSECUTIVE_URGENT_DISPATCHES = 3;
    private static final int DEFAULT_MAX_CORE_RUNNING_BLOCKING_BROADCASTS = 0;
    private static final int DEFAULT_MAX_CORE_RUNNING_NON_BLOCKING_BROADCASTS = 0;
    private static final int DEFAULT_MAX_FROZEN_OUTGOING_BROADCASTS = 32;
    private static final int DEFAULT_MAX_HISTORY_COMPLETE_SIZE = 0;
    private static final int DEFAULT_MAX_HISTORY_SUMMARY_SIZE = 0;
    private static final int DEFAULT_MAX_PENDING_BROADCASTS = 0;
    private static final int DEFAULT_MAX_RUNNING_ACTIVE_BROADCASTS = 0;
    private static final int DEFAULT_MAX_RUNNING_PROCESS_QUEUES = 0;
    private static final long DEFAULT_PENDING_COLD_START_ABANDON_TIMEOUT_MILLIS = 0;
    private static final long DEFAULT_PENDING_COLD_START_CHECK_INTERVAL_MILLIS = 30000;
    public static final long DEFAULT_TIMEOUT = 0;
    public static final int DEFER_BOOT_COMPLETED_BROADCAST_ALL = 1;
    public static final int DEFER_BOOT_COMPLETED_BROADCAST_BACKGROUND_RESTRICTED_ONLY = 2;
    static final long DEFER_BOOT_COMPLETED_BROADCAST_CHANGE_ID = 203704822;
    public static final int DEFER_BOOT_COMPLETED_BROADCAST_NONE = 0;
    public static final int DEFER_BOOT_COMPLETED_BROADCAST_TARGET_T_ONLY = 4;
    static final String KEY_ALLOW_BG_ACTIVITY_START_TIMEOUT = "bcast_allow_bg_activity_start_timeout";
    private static final String KEY_CORE_DEFER_UNTIL_ACTIVE = "bcast_core_defer_until_active";
    private static final String KEY_CORE_MAX_RUNNING_BLOCKING_BROADCASTS = "bcast_max_core_running_blocking_broadcasts";
    private static final String KEY_CORE_MAX_RUNNING_NON_BLOCKING_BROADCASTS = "bcast_max_core_running_non_blocking_broadcasts";
    private static final String KEY_DELAY_CACHED_MILLIS = "bcast_delay_cached_millis";
    private static final String KEY_DELAY_FOREGROUND_PROC_MILLIS = "bcast_delay_foreground_proc_millis";
    private static final String KEY_DELAY_NORMAL_MILLIS = "bcast_delay_normal_millis";
    private static final String KEY_DELAY_PERSISTENT_PROC_MILLIS = "bcast_delay_persistent_proc_millis";
    private static final String KEY_DELAY_URGENT_MILLIS = "bcast_delay_urgent_millis";
    private static final String KEY_EXTRA_RUNNING_URGENT_PROCESS_QUEUES = "bcast_extra_running_urgent_process_queues";
    private static final String KEY_MAX_CONSECUTIVE_NORMAL_DISPATCHES = "bcast_max_consecutive_normal_dispatches";
    private static final String KEY_MAX_CONSECUTIVE_URGENT_DISPATCHES = "bcast_max_consecutive_urgent_dispatches";
    private static final String KEY_MAX_FROZEN_OUTGOING_BROADCASTS = "max_frozen_outgoing_broadcasts";
    private static final String KEY_MAX_HISTORY_COMPLETE_SIZE = "bcast_max_history_complete_size";
    private static final String KEY_MAX_HISTORY_SUMMARY_SIZE = "bcast_max_history_summary_size";
    private static final String KEY_MAX_PENDING_BROADCASTS = "bcast_max_pending_broadcasts";
    private static final String KEY_MAX_RUNNING_ACTIVE_BROADCASTS = "bcast_max_running_active_broadcasts";
    private static final String KEY_MAX_RUNNING_PROCESS_QUEUES = "bcast_max_running_process_queues";
    private static final String KEY_PENDING_COLD_START_ABANDON_TIMEOUT_MILLIS = "pending_cold_start_abandon_timeout_millis";
    private static final String KEY_PENDING_COLD_START_CHECK_INTERVAL_MILLIS = "pending_cold_start_check_interval_millis";
    static final String KEY_TIMEOUT = "bcast_timeout";
    private static final String TAG = "BroadcastConstants";
    public long ALLOW_BG_ACTIVITY_START_TIMEOUT;
    public boolean CORE_DEFER_UNTIL_ACTIVE;
    public long DELAY_CACHED_MILLIS;
    public long DELAY_FOREGROUND_PROC_MILLIS;
    public long DELAY_NORMAL_MILLIS;
    public long DELAY_PERSISTENT_PROC_MILLIS;
    public long DELAY_URGENT_MILLIS;
    public int EXTRA_RUNNING_URGENT_PROCESS_QUEUES;
    public int MAX_CONSECUTIVE_NORMAL_DISPATCHES;
    public int MAX_CONSECUTIVE_URGENT_DISPATCHES;
    public int MAX_CORE_RUNNING_BLOCKING_BROADCASTS;
    public int MAX_CORE_RUNNING_NON_BLOCKING_BROADCASTS;
    public int MAX_FROZEN_OUTGOING_BROADCASTS;
    public int MAX_HISTORY_COMPLETE_SIZE;
    public int MAX_HISTORY_SUMMARY_SIZE;
    public int MAX_PENDING_BROADCASTS;
    public int MAX_RUNNING_ACTIVE_BROADCASTS;
    public int MAX_RUNNING_PROCESS_QUEUES;
    public long PENDING_COLD_START_ABANDON_TIMEOUT_MILLIS;
    public long PENDING_COLD_START_CHECK_INTERVAL_MILLIS;
    public long TIMEOUT;
    private final KeyValueListParser mParser;
    private ContentResolver mResolver;
    private String mSettingsKey;
    private SettingsObserver mSettingsObserver;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DeferBootCompletedBroadcastType {
    }

    class SettingsObserver extends ContentObserver {
        final /* synthetic */ BroadcastConstants this$0;

        SettingsObserver(BroadcastConstants this$0, Handler handler) {
            this.this$0 = this$0;
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            BroadcastConstants.m1426$$Nest$mupdateSettingsConstants(this.this$0);
        }
    }

    public static /* synthetic */ void $r8$lambda$8SI0Rl4OUf6zQTk_jAQtH5_1owk(BroadcastConstants r0, DeviceConfig.Properties r1) {
        r0.updateDeviceConfigConstants(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateSettingsConstants, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1426$$Nest$mupdateSettingsConstants(BroadcastConstants r0) {
        r0.updateSettingsConstants();
    }

    static {
        DEFAULT_TIMEOUT = Build.HW_TIMEOUT_MULTIPLIER * 10000;
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L5;
        int r0 = 2;
    L6:
        DEFAULT_MAX_RUNNING_PROCESS_QUEUES = r0;
        int r1 = 16;
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L9;
        int r2 = 8;
    L10:
        DEFAULT_MAX_RUNNING_ACTIVE_BROADCASTS = r2;
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L13;
        r1 = 8;
    L13:
        DEFAULT_MAX_CORE_RUNNING_BLOCKING_BROADCASTS = r1;
        int r3 = 64;
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L16;
        int r4 = 32;
    L17:
        DEFAULT_MAX_CORE_RUNNING_NON_BLOCKING_BROADCASTS = r4;
        int r5 = 256;
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L20;
        int r6 = 128;
    L21:
        DEFAULT_MAX_PENDING_BROADCASTS = r6;
        if (ActivityManager.isLowRamDeviceStatic() == true) goto L25;
        r3 = 256;
    L25:
        DEFAULT_MAX_HISTORY_COMPLETE_SIZE = r3;
        if (ActivityManager.isLowRamDeviceStatic() == true) goto L29;
        r5 = 1024;
    L29:
        DEFAULT_MAX_HISTORY_SUMMARY_SIZE = r5;
        DEFAULT_PENDING_COLD_START_ABANDON_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(5);
        return;
    L20:
        r6 = 256;
        goto L21
    L16:
        r4 = 64;
        goto L17
    L9:
        r2 = 16;
        goto L10
    L5:
        r0 = 4;
        goto L6
    }

    public BroadcastConstants(String settingsKey) {
        this.TIMEOUT = DEFAULT_TIMEOUT;
        this.ALLOW_BG_ACTIVITY_START_TIMEOUT = DEFAULT_TIMEOUT;
        this.MAX_RUNNING_PROCESS_QUEUES = DEFAULT_MAX_RUNNING_PROCESS_QUEUES;
        this.EXTRA_RUNNING_URGENT_PROCESS_QUEUES = 1;
        this.MAX_CONSECUTIVE_URGENT_DISPATCHES = 3;
        this.MAX_CONSECUTIVE_NORMAL_DISPATCHES = 10;
        this.MAX_RUNNING_ACTIVE_BROADCASTS = DEFAULT_MAX_RUNNING_ACTIVE_BROADCASTS;
        this.MAX_CORE_RUNNING_BLOCKING_BROADCASTS = DEFAULT_MAX_CORE_RUNNING_BLOCKING_BROADCASTS;
        this.MAX_CORE_RUNNING_NON_BLOCKING_BROADCASTS = DEFAULT_MAX_CORE_RUNNING_NON_BLOCKING_BROADCASTS;
        this.MAX_PENDING_BROADCASTS = DEFAULT_MAX_PENDING_BROADCASTS;
        this.DELAY_NORMAL_MILLIS = 500;
        this.DELAY_CACHED_MILLIS = 120000;
        this.DELAY_URGENT_MILLIS = -120000;
        this.DELAY_FOREGROUND_PROC_MILLIS = -120000;
        this.DELAY_PERSISTENT_PROC_MILLIS = -120000;
        this.MAX_HISTORY_COMPLETE_SIZE = DEFAULT_MAX_HISTORY_COMPLETE_SIZE;
        this.MAX_HISTORY_SUMMARY_SIZE = DEFAULT_MAX_HISTORY_SUMMARY_SIZE;
        this.CORE_DEFER_UNTIL_ACTIVE = true;
        this.PENDING_COLD_START_CHECK_INTERVAL_MILLIS = 30000;
        this.MAX_FROZEN_OUTGOING_BROADCASTS = 32;
        this.PENDING_COLD_START_ABANDON_TIMEOUT_MILLIS = DEFAULT_PENDING_COLD_START_ABANDON_TIMEOUT_MILLIS * ((long) Build.HW_TIMEOUT_MULTIPLIER);
        this.mParser = new KeyValueListParser(',');
        this.mSettingsKey = settingsKey;
        updateDeviceConfigConstants();
    }

    public void startObserving(Handler handler, ContentResolver resolver) {
        this.mResolver = resolver;
        this.mSettingsObserver = new SettingsObserver(this, handler);
        this.mResolver.registerContentObserver(Settings.Global.getUriFor(this.mSettingsKey), false, this.mSettingsObserver);
        updateSettingsConstants();
        DeviceConfig.addOnPropertiesChangedListener("activity_manager_native_boot", new HandlerExecutor(handler), new BroadcastConstants$$ExternalSyntheticLambda0(this));
        updateDeviceConfigConstants();
    }

    public int getMaxRunningQueues() {
        return this.MAX_RUNNING_PROCESS_QUEUES + this.EXTRA_RUNNING_URGENT_PROCESS_QUEUES;
    }

    private void updateSettingsConstants() {
        monitor-enter(this);
        this.mParser.setString(Settings.Global.getString(this.mResolver, this.mSettingsKey));     // Catch: Throwable -> L7 IllegalArgumentException -> L9
        this.TIMEOUT = this.mParser.getLong(KEY_TIMEOUT, this.TIMEOUT);     // Catch: Throwable -> L7
        this.ALLOW_BG_ACTIVITY_START_TIMEOUT = this.mParser.getLong(KEY_ALLOW_BG_ACTIVITY_START_TIMEOUT, this.ALLOW_BG_ACTIVITY_START_TIMEOUT);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "Bad broadcast settings in key '" + this.mSettingsKey + "'", e);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static String propertyFor(String key) {
        return "persist.device_config.activity_manager_native_boot." + key;
    }

    private static String propertyOverrideFor(String key) {
        return "persist.sys.activity_manager_native_boot." + key;
    }

    static boolean getDeviceConfigBoolean(String key, boolean def) {
        return SystemProperties.getBoolean(propertyOverrideFor(key), SystemProperties.getBoolean(propertyFor(key), def));
    }

    private int getDeviceConfigInt(String key, int def) {
        return SystemProperties.getInt(propertyOverrideFor(key), SystemProperties.getInt(propertyFor(key), def));
    }

    private long getDeviceConfigLong(String key, long def) {
        return SystemProperties.getLong(propertyOverrideFor(key), SystemProperties.getLong(propertyFor(key), def));
    }

    private void updateDeviceConfigConstants(DeviceConfig.Properties properties) {
        updateDeviceConfigConstants();
    }

    private void updateDeviceConfigConstants() {
        monitor-enter(this);
        this.MAX_RUNNING_PROCESS_QUEUES = getDeviceConfigInt(KEY_MAX_RUNNING_PROCESS_QUEUES, DEFAULT_MAX_RUNNING_PROCESS_QUEUES);     // Catch: Throwable -> L7
        this.EXTRA_RUNNING_URGENT_PROCESS_QUEUES = getDeviceConfigInt(KEY_EXTRA_RUNNING_URGENT_PROCESS_QUEUES, 1);     // Catch: Throwable -> L7
        this.MAX_CONSECUTIVE_URGENT_DISPATCHES = getDeviceConfigInt(KEY_MAX_CONSECUTIVE_URGENT_DISPATCHES, 3);     // Catch: Throwable -> L7
        this.MAX_CONSECUTIVE_NORMAL_DISPATCHES = getDeviceConfigInt(KEY_MAX_CONSECUTIVE_NORMAL_DISPATCHES, 10);     // Catch: Throwable -> L7
        this.MAX_RUNNING_ACTIVE_BROADCASTS = getDeviceConfigInt(KEY_MAX_RUNNING_ACTIVE_BROADCASTS, DEFAULT_MAX_RUNNING_ACTIVE_BROADCASTS);     // Catch: Throwable -> L7
        this.MAX_CORE_RUNNING_BLOCKING_BROADCASTS = getDeviceConfigInt(KEY_CORE_MAX_RUNNING_BLOCKING_BROADCASTS, DEFAULT_MAX_CORE_RUNNING_BLOCKING_BROADCASTS);     // Catch: Throwable -> L7
        this.MAX_CORE_RUNNING_NON_BLOCKING_BROADCASTS = getDeviceConfigInt(KEY_CORE_MAX_RUNNING_NON_BLOCKING_BROADCASTS, DEFAULT_MAX_CORE_RUNNING_NON_BLOCKING_BROADCASTS);     // Catch: Throwable -> L7
        this.MAX_PENDING_BROADCASTS = getDeviceConfigInt(KEY_MAX_PENDING_BROADCASTS, DEFAULT_MAX_PENDING_BROADCASTS);     // Catch: Throwable -> L7
        this.DELAY_NORMAL_MILLIS = getDeviceConfigLong(KEY_DELAY_NORMAL_MILLIS, 500);     // Catch: Throwable -> L7
        this.DELAY_CACHED_MILLIS = getDeviceConfigLong(KEY_DELAY_CACHED_MILLIS, 120000);     // Catch: Throwable -> L7
        this.DELAY_URGENT_MILLIS = getDeviceConfigLong(KEY_DELAY_URGENT_MILLIS, -120000);     // Catch: Throwable -> L7
        this.DELAY_FOREGROUND_PROC_MILLIS = getDeviceConfigLong(KEY_DELAY_FOREGROUND_PROC_MILLIS, -120000);     // Catch: Throwable -> L7
        this.DELAY_PERSISTENT_PROC_MILLIS = getDeviceConfigLong(KEY_DELAY_PERSISTENT_PROC_MILLIS, -120000);     // Catch: Throwable -> L7
        this.MAX_HISTORY_COMPLETE_SIZE = getDeviceConfigInt(KEY_MAX_HISTORY_COMPLETE_SIZE, DEFAULT_MAX_HISTORY_COMPLETE_SIZE);     // Catch: Throwable -> L7
        this.MAX_HISTORY_SUMMARY_SIZE = getDeviceConfigInt(KEY_MAX_HISTORY_SUMMARY_SIZE, DEFAULT_MAX_HISTORY_SUMMARY_SIZE);     // Catch: Throwable -> L7
        this.CORE_DEFER_UNTIL_ACTIVE = getDeviceConfigBoolean(KEY_CORE_DEFER_UNTIL_ACTIVE, true);     // Catch: Throwable -> L7
        this.PENDING_COLD_START_CHECK_INTERVAL_MILLIS = getDeviceConfigLong(KEY_PENDING_COLD_START_CHECK_INTERVAL_MILLIS, 30000);     // Catch: Throwable -> L7
        this.MAX_FROZEN_OUTGOING_BROADCASTS = getDeviceConfigInt(KEY_MAX_FROZEN_OUTGOING_BROADCASTS, 32);     // Catch: Throwable -> L7
        this.PENDING_COLD_START_ABANDON_TIMEOUT_MILLIS = getDeviceConfigLong(KEY_PENDING_COLD_START_ABANDON_TIMEOUT_MILLIS, DEFAULT_PENDING_COLD_START_ABANDON_TIMEOUT_MILLIS) * ((long) Build.HW_TIMEOUT_MULTIPLIER);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        BroadcastRecord.CORE_DEFER_UNTIL_ACTIVE = this.CORE_DEFER_UNTIL_ACTIVE;
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @NeverCompile
    public void dump(IndentingPrintWriter pw) {
        monitor-enter(this);
        pw.print("Broadcast parameters (key=");     // Catch: Throwable -> L10
        pw.print(this.mSettingsKey);     // Catch: Throwable -> L10
        pw.print(", observing=");     // Catch: Throwable -> L10
        if (this.mSettingsObserver == null) goto L6;
        boolean r0 = true;
    L7:
        pw.print(r0);     // Catch: Throwable -> L10
        pw.println("):");     // Catch: Throwable -> L10
        pw.increaseIndent();     // Catch: Throwable -> L10
        pw.print(KEY_TIMEOUT, TimeUtils.formatDuration(this.TIMEOUT)).println();     // Catch: Throwable -> L10
        pw.print(KEY_ALLOW_BG_ACTIVITY_START_TIMEOUT, TimeUtils.formatDuration(this.ALLOW_BG_ACTIVITY_START_TIMEOUT)).println();     // Catch: Throwable -> L10
        pw.decreaseIndent();     // Catch: Throwable -> L10
        pw.println();     // Catch: Throwable -> L10
        pw.print("Broadcast parameters (namespace=");     // Catch: Throwable -> L10
        pw.print("activity_manager_native_boot");     // Catch: Throwable -> L10
        pw.println("):");     // Catch: Throwable -> L10
        pw.increaseIndent();     // Catch: Throwable -> L10
        pw.print(KEY_MAX_RUNNING_PROCESS_QUEUES, Integer.valueOf(this.MAX_RUNNING_PROCESS_QUEUES)).println();     // Catch: Throwable -> L10
        pw.print(KEY_MAX_RUNNING_ACTIVE_BROADCASTS, Integer.valueOf(this.MAX_RUNNING_ACTIVE_BROADCASTS)).println();     // Catch: Throwable -> L10
        pw.print(KEY_CORE_MAX_RUNNING_BLOCKING_BROADCASTS, Integer.valueOf(this.MAX_CORE_RUNNING_BLOCKING_BROADCASTS)).println();     // Catch: Throwable -> L10
        pw.print(KEY_CORE_MAX_RUNNING_NON_BLOCKING_BROADCASTS, Integer.valueOf(this.MAX_CORE_RUNNING_NON_BLOCKING_BROADCASTS)).println();     // Catch: Throwable -> L10
        pw.print(KEY_MAX_PENDING_BROADCASTS, Integer.valueOf(this.MAX_PENDING_BROADCASTS)).println();     // Catch: Throwable -> L10
        pw.print(KEY_DELAY_NORMAL_MILLIS, TimeUtils.formatDuration(this.DELAY_NORMAL_MILLIS)).println();     // Catch: Throwable -> L10
        pw.print(KEY_DELAY_CACHED_MILLIS, TimeUtils.formatDuration(this.DELAY_CACHED_MILLIS)).println();     // Catch: Throwable -> L10
        pw.print(KEY_DELAY_URGENT_MILLIS, TimeUtils.formatDuration(this.DELAY_URGENT_MILLIS)).println();     // Catch: Throwable -> L10
        pw.print(KEY_DELAY_FOREGROUND_PROC_MILLIS, TimeUtils.formatDuration(this.DELAY_FOREGROUND_PROC_MILLIS)).println();     // Catch: Throwable -> L10
        pw.print(KEY_DELAY_PERSISTENT_PROC_MILLIS, TimeUtils.formatDuration(this.DELAY_PERSISTENT_PROC_MILLIS)).println();     // Catch: Throwable -> L10
        pw.print(KEY_MAX_HISTORY_COMPLETE_SIZE, Integer.valueOf(this.MAX_HISTORY_COMPLETE_SIZE)).println();     // Catch: Throwable -> L10
        pw.print(KEY_MAX_HISTORY_SUMMARY_SIZE, Integer.valueOf(this.MAX_HISTORY_SUMMARY_SIZE)).println();     // Catch: Throwable -> L10
        pw.print(KEY_MAX_CONSECUTIVE_URGENT_DISPATCHES, Integer.valueOf(this.MAX_CONSECUTIVE_URGENT_DISPATCHES)).println();     // Catch: Throwable -> L10
        pw.print(KEY_MAX_CONSECUTIVE_NORMAL_DISPATCHES, Integer.valueOf(this.MAX_CONSECUTIVE_NORMAL_DISPATCHES)).println();     // Catch: Throwable -> L10
        pw.print(KEY_CORE_DEFER_UNTIL_ACTIVE, Boolean.valueOf(this.CORE_DEFER_UNTIL_ACTIVE)).println();     // Catch: Throwable -> L10
        pw.print(KEY_PENDING_COLD_START_CHECK_INTERVAL_MILLIS, Long.valueOf(this.PENDING_COLD_START_CHECK_INTERVAL_MILLIS)).println();     // Catch: Throwable -> L10
        pw.print(KEY_MAX_FROZEN_OUTGOING_BROADCASTS, Integer.valueOf(this.MAX_FROZEN_OUTGOING_BROADCASTS)).println();     // Catch: Throwable -> L10
        pw.print(KEY_PENDING_COLD_START_ABANDON_TIMEOUT_MILLIS, Long.valueOf(this.PENDING_COLD_START_ABANDON_TIMEOUT_MILLIS)).println();     // Catch: Throwable -> L10
        pw.decreaseIndent();     // Catch: Throwable -> L10
        pw.println();     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L6:
        r0 = false;
    L10:
        th = move-exception;
        throw th;
    }
}
