package com.android.server.am;

import com.android.server.wm.WindowManagerService;

/* JADX INFO: loaded from: classes.dex */
public abstract class ZteAnrTrackerInternal {
    public abstract void dumpLog(String r1, String r2, int r3);

    public abstract long getAppCpuDelayTime(int r1);

    public abstract long getAppCpuTime(int r1);

    public abstract float getTotalCpuPercent();

    public abstract void init(ActivityManagerService r1);

    public abstract void noteBroadcastTimeoutEnd(BroadcastProcessQueue r1);

    public abstract void noteBroadcastTimeoutStart(BroadcastProcessQueue r1, long r2);

    public abstract void noteFGServiceTimeoutEnd(ServiceRecord r1);

    public abstract void noteFGServiceTimeoutStart(ServiceRecord r1, long r2);

    public abstract void noteServiceTimeoutEnd(ProcessRecord r1);

    public abstract void noteServiceTimeoutStart(ProcessRecord r1, Long r2);

    public abstract void notifyInputManagerTimeout(String r1);

    public abstract void notifyNoFocusWindowAnr(String r1, int r2, long r3);

    public abstract void setWindowManager(WindowManagerService r1);

    public ZteAnrTrackerInternal() {
    }
}
