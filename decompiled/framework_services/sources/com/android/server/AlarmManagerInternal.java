package com.android.server;

import android.app.PendingIntent;

/* JADX INFO: loaded from: classes.dex */
public interface AlarmManagerInternal {

    public interface InFlightListener {
        void broadcastAlarmComplete(int r1);

        void broadcastAlarmPending(int r1);
    }

    long getNextAlarmTriggerTimeForUser(int r1);

    boolean isIdling();

    void registerInFlightListener(InFlightListener r1);

    void remove(PendingIntent r1);

    void removeAlarmsForUid(int r1);

    void setTime(long r1, int r3, String r4);

    void setTimeZone(String r1, int r2, String r3);

    boolean shouldGetBucketElevation(String r1, int r2);
}
