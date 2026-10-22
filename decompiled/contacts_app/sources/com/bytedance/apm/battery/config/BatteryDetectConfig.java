package com.bytedance.apm.battery.config;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryDetectConfig {
    public static final String KEY_MAX_NORMAL_ALARM_INVOKE_COUNT_10_MINS = "max_normal_alarm_invoke_count";
    public static final String KEY_MAX_SINGLE_LOC_REQUEST_TIME = "max_single_loc_request_time_second";
    public static final String KEY_MAX_SINGLE_WAKE_LOCK_HOLD_TIME = "max_single_wake_lock_hold_time_second";
    public static final String KEY_MAX_TOTAL_LOC_REQUEST_COUNT_10_MINS = "max_total_loc_request_count";
    public static final String KEY_MAX_TOTAL_LOC_REQUEST_TIME_10_MINS = "max_total_loc_request_time_second";
    public static final String KEY_MAX_TOTAL_WAKE_LOCK_ACQUIRE_COUNT_10_MINS = "max_total_wake_lock_acquire_count";
    public static final String KEY_MAX_TOTAL_WAKE_LOCK_HOLD_TIME_10_MINS = "max_total_wake_lock_hold_time_second";
    public static final String KEY_MAX_WAKE_UP_ALARM_INVOKE_COUNT_10_MINS = "max_wake_up_alarm_invoke_count";
    public static final int MAX_NORMAL_ALARM_INVOKE_COUNT_10_MINS = 10;
    public static final long MAX_SINGLE_LOC_REQUEST_TIME_SECONDS = 120;
    public static final long MAX_SINGLE_WAKE_LOCK_HOLD_TIME_SECOND = 120;
    public static final int MAX_TOTAL_LOC_REQUEST_COUNT_10_MINS = 5;
    public static final int MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND = 240;
    public static final int MAX_TOTAL_WAKE_LOCK_ACQUIRE_COUNT_10_MINS = 5;
    public static final long MAX_TOTAL_WAKE_LOCK_HOLD_TIME_10_MINS_SECOND = 240;
    public static final int MAX_WAKE_UP_ALARM_INVOKE_COUNT_10_MINS = 5;
    private static int maxNormalAlarmInvokeCount = 10;
    private static long maxSingleLocRequestTimeMs = 120000;
    private static int maxTotalLocRequestCount = 5;
    private static long maxTotalLocRequestTimeMs = 240000;
    private static long maxTotalWakeLockHoldTimeMs = 240000;
    private static int maxWakeUpAlarmInvokeCount = 5;
    private static long sMaxSingleWakeLockHoldTimeMs = 120000;
    private static long sMaxTotalWakeLockAcquireCount = 5;

    static {
    }

    public BatteryDetectConfig() {
    }

    public static long getMaxSingleWakeLockHoldTimeMs() {
        return sMaxSingleWakeLockHoldTimeMs;
    }

    public static void setMaxSingleWakeLockHoldTimeMs(long r0) {
        sMaxSingleWakeLockHoldTimeMs = r0;
    }

    public static long getMaxTotalWakeLockAcquireCount() {
        return sMaxTotalWakeLockAcquireCount;
    }

    public static void setMaxTotalWakeLockAcquireCount(int r2) {
        sMaxTotalWakeLockAcquireCount = r2;
    }

    public static long getMaxTotalWakeLockHoldTimeMs() {
        return maxTotalWakeLockHoldTimeMs;
    }

    public static void setMaxTotalWakeLockHoldTimeMs(long r0) {
        maxTotalWakeLockHoldTimeMs = r0;
    }

    public static int getMaxWakeUpAlarmInvokeCount() {
        return maxWakeUpAlarmInvokeCount;
    }

    public static void setMaxWakeUpAlarmInvokeCount(int r0) {
        maxWakeUpAlarmInvokeCount = r0;
    }

    public static int getMaxNormalAlarmInvokeCount() {
        return maxNormalAlarmInvokeCount;
    }

    public static void setMaxNormalAlarmInvokeCount(int r0) {
        maxNormalAlarmInvokeCount = r0;
    }

    public static long getMaxSingleLocRequestTimeMs() {
        return maxSingleLocRequestTimeMs;
    }

    public static void setMaxSingleLocRequestTimeMs(long r0) {
        maxSingleLocRequestTimeMs = r0;
    }

    public static int getMaxTotalLocRequestCount() {
        return maxTotalLocRequestCount;
    }

    public static void setMaxTotalLocRequestCount(int r0) {
        maxTotalLocRequestCount = r0;
    }

    public static long getMaxTotalLocRequestTimeMs() {
        return maxTotalLocRequestTimeMs;
    }

    public static void setMaxTotalLocRequestTimeMs(long r0) {
        maxTotalLocRequestTimeMs = r0;
    }
}
