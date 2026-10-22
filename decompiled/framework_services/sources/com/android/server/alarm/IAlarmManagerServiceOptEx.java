package com.android.server.alarm;

import android.content.Context;
import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IAlarmManagerServiceOptEx {
    public static final int EVENT_ALARM_DELIVER = 1;
    public static final String FEAT_TAG = "FEAT_POWER_NF";
    public static final String OPT_TAG = "AlarmManagerServiceOptEx";

    default void init(Context context, AlarmManagerService service) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isExemptFromPowerSaver(int uid, String pkgName, boolean allowWhileIdle) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return true;
    }

    default void resetRestrictedAlarm() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onAlarmEvent(Alarm alarm, int event) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
