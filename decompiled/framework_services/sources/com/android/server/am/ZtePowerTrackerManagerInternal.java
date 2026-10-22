package com.android.server.am;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class ZtePowerTrackerManagerInternal {
    public abstract void checkPowerUsageLocked(ArrayList<ProcessRecord> r1);

    public abstract String getAppType(int r1);

    public abstract void init(BatteryStatsService r1, ActivityManagerConstants r2, Context r3, ActivityManagerService r4);

    public abstract boolean isAlarmAlignWhitelistApp(String r1);

    public abstract boolean isAudioRunningOrShortPause(int r1, long r2);

    public abstract boolean isGmsAllowed();

    public abstract boolean isGpsRunningOrShortPause(int r1, long r2);

    public abstract boolean isNavigationApp(String r1);

    public abstract boolean isRecentMoving();

    public abstract boolean isRegisteredGpsReceiverNow(int r1);

    public abstract boolean isRegisteredWakeLockNow(int r1);

    public abstract boolean isRegisteredWakeupGpsNow(int r1);

    public abstract boolean isRegisteredWakeupSensorNow(int r1);

    public abstract void noteProcessStart(ApplicationInfo r1, ApplicationInfo r2, int r3, String r4, boolean r5);

    public abstract void noteUpdateForStrategy();

    public abstract void reportEvent(int r1, int r2, String r3);

    public abstract void reportEvent(UsageEvents.Event r1, long r2, int r4);

    public abstract void reportHighCpuWarning(ProcessRecord r1, long r2, long r4);

    public ZtePowerTrackerManagerInternal() {
    }
}
