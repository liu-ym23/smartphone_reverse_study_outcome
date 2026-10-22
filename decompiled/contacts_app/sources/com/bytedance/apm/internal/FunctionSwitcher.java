package com.bytedance.apm.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.apm.constant.SlardarConfigConsts;

/* JADX INFO: loaded from: classes2.dex */
public class FunctionSwitcher {
    private static long atraceFlags = 0;
    private static int firstFlags = 0;
    private static volatile boolean isInit = false;
    private static SharedPreferences mSharedPreferences;
    private static int newFirstFlags;

    static {
    }

    public FunctionSwitcher() {
    }

    public static synchronized void init(Context r4) {
        monitor-enter(FunctionSwitcher.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (isInit == false) goto L9;
        monitor-exit(FunctionSwitcher.class);
        return;
    L9:
        isInit = true;     // Catch: Throwable -> L17
        if (mSharedPreferences != null) goto L12;
        mSharedPreferences = r4.getSharedPreferences(SlardarConfigConsts.MONITOR_SWITCH_CONFIG, 0);     // Catch: Throwable -> L17
    L12:
        SharedPreferences r5 = mSharedPreferences;     // Catch: Throwable -> L17
        if (r5 == null) goto L15;
        int r6 = r5.getInt(SlardarConfigConsts.MONITOR_SWITCH_CONFIG_FIRST_FLAG, 0);     // Catch: Throwable -> L17
        firstFlags = r6;     // Catch: Throwable -> L17
        newFirstFlags = r6;     // Catch: Throwable -> L17
        atraceFlags = mSharedPreferences.getLong(SlardarConfigConsts.MONITOR_SWITCH_CONFIG_ATRACE_FLAG, 0);     // Catch: Throwable -> L17
    L15:
        monitor-exit(FunctionSwitcher.class);
    }

    public static void updateSwitch(int r0, boolean r1) {
        if (r1 == false) goto L4;
        newFirstFlags = r0 | newFirstFlags;
        return;
    L4:
        int r2 = newFirstFlags;
        newFirstFlags = (~r0) & r2;
    }

    public static void updateGpu(long r2, long r4) {
        SharedPreferences r0 = mSharedPreferences;
        if (r0 == null) goto L6;
        r0.edit().putLong(SlardarConfigConsts.MONITOR_SWITCH_GPU_LOAD, r2).putLong(SlardarConfigConsts.MONITOR_SWITCH_GPU_WINDOW, r4).apply();
        return;
    }

    public static long getGpuLoadInterval() {
        SharedPreferences r0 = mSharedPreferences;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getLong(SlardarConfigConsts.MONITOR_SWITCH_GPU_LOAD, 0);
    }

    public static long getGpuLoadWindows() {
        SharedPreferences r0 = mSharedPreferences;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getLong(SlardarConfigConsts.MONITOR_SWITCH_GPU_WINDOW, 1000);
    }

    public static void updateSwitch(int r1, int r2) {
        int r0 = newFirstFlags;
        newFirstFlags = (r2 & r1) + ((~r1) & r0);
    }

    public static void updateAtraceFlags(long r0) {
        atraceFlags = r0;
    }

    public static void saveToSp() {
        SharedPreferences r0 = mSharedPreferences;
        if (r0 == null) goto L6;
        r0.edit().putInt(SlardarConfigConsts.MONITOR_SWITCH_CONFIG_FIRST_FLAG, newFirstFlags).putLong(SlardarConfigConsts.MONITOR_SWITCH_CONFIG_ATRACE_FLAG, atraceFlags).apply();
        return;
    }

    public static boolean getSwitch(int r1) {
        if ((r1 & firstFlags) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static long getAtraceFlags() {
        return atraceFlags;
    }

    public static int getMonitorRunMode() {
        return ((-536870912) & firstFlags) >>> 29;
    }
}
