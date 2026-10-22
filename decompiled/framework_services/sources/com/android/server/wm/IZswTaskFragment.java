package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public interface IZswTaskFragment {
    void handleAppDied(WindowProcessController r1, ActivityRecord r2);

    void noteAppForeground(ActivityRecord r1, ActivityRecord r2, ActivityTaskSupervisor r3);

    void noteResumingActivityEvent(int r1, ActivityRecord r2);

    boolean resumeTopActivityPerfCube(ActivityRecord r1, ActivityRecord r2);

    void setResumedActivity(ActivityRecord r1, int r2);

    void startPausing(ActivityRecord r1, ActivityRecord r2, ActivityRecord r3, int r4, boolean r5);
}
