package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public interface IZswActivityMetricsLogger {
    void notifyActivityLaunched(TransitionInfo r1, WindowProcessController r2, ActivityTaskSupervisor r3);

    void notifyActivityLaunching(TransitionInfo r1, ActivityTaskSupervisor r2);

    void stopLaunchTrace(TransitionInfo r1);
}
