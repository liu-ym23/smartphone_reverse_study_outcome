package com.bytedance.android.livesdkapi.performance;

import android.os.Bundle;

/* JADX INFO: loaded from: classes12.dex */
public interface ILoadStallMonitor extends IMonitor {
    public static final String EXTRA_PLAYER_TYPE = "player_type";
    public static final String MONITOR_DURATION = "monitor_duration";
    public static final String START_TIME = "start_time";
    public static final String STOP_TIME = "stop_time";

    boolean startMonitor(long r100, long r101, Bundle r102);

    boolean startMonitor(long r100, long r101, Bundle r102, long r103);

    boolean stopMonitor(long r100, long r101, Bundle r102);
}
