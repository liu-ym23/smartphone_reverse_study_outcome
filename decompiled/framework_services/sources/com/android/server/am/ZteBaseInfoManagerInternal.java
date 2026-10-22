package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public abstract class ZteBaseInfoManagerInternal {
    public abstract void addPss(String r1, String r2, long r3);

    public abstract Integer getAppId(String r1);

    public abstract int getAppPowerOptimizeType(String r1);

    public abstract int getAppTypeId(String r1);

    public abstract String[] getForceStopPkgList();

    public abstract long[] getLongArrayWithType(int r1);

    public abstract long[] getNightBoundaries();

    public abstract String getPackageName(int r1);

    public abstract long getScreenOffDuration();

    public abstract boolean getSleepModeStatus();

    public abstract long getUsedMemory(String r1);

    public abstract void init(BatteryStatsService r1, ActivityManagerConstants r2, ActivityManagerService r3);

    public abstract boolean isApp(String r1, Integer r2);

    public abstract boolean isCurrentInputMethod(String r1);

    public abstract boolean isCurrentLiveWallpaper(String r1);

    public abstract boolean isForegroundNow(int r1, int r2);

    public abstract boolean isInNight(long r1, long r3);

    public abstract boolean isLockedApp(String r1);

    public abstract boolean isLongBackground(int r1, long r2);

    public abstract boolean isNotificationEnabled(String r1, int r2);

    public abstract boolean isPowerTestting();

    public abstract boolean isProtectApp(String r1);

    public abstract boolean isSystemApp(String r1);

    public abstract boolean isTopApp(int r1);

    public abstract boolean isTopLaunchApp(String r1, int r2);

    public abstract boolean setLongArrayWithType(long[] r1, int r2);

    public abstract void setPowerTestting(boolean r1);

    public abstract void setSleepModeStatus(boolean r1);

    public ZteBaseInfoManagerInternal() {
    }
}
