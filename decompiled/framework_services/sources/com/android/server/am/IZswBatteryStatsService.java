package com.android.server.am;

import android.os.WorkSource;

/* JADX INFO: loaded from: classes.dex */
public interface IZswBatteryStatsService {
    void noteGpsChanged(WorkSource r1, WorkSource r2);

    void noteStartAudio(int r1);

    void noteStartSensor(int r1, int r2);

    void noteStartVideo(int r1);

    void noteStopAudio(int r1);

    void noteStopSensor(int r1, int r2);

    void noteStopVideo(int r1);
}
