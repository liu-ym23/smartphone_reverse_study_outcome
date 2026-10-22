package com.android.server.am;

import android.app.PendingIntent;

/* JADX INFO: loaded from: classes.dex */
public abstract class ZteAlarmControllerManagerInternal {
    public abstract boolean inTriggerMapForUnFreezerOperation(PendingIntent r1);

    public abstract boolean isAlarmNeedControl(String r1, int r2, PendingIntent r3);

    public abstract boolean isForbidSetRepeatAlarm(String r1, PendingIntent r2);

    public abstract boolean isNoNeedEqualsAlarm(String r1, PendingIntent r2);

    public abstract boolean isUnremoveAlarm(int r1);

    public abstract void notifyAlarmSpecialAlign(boolean r1);

    public abstract void removeUnFreezerOperationFromMap(PendingIntent r1);

    public abstract long[] setAlign(int r1, long r2, long r4, PendingIntent r6, int r7, String r8, int r9, boolean r10);

    public ZteAlarmControllerManagerInternal() {
    }
}
