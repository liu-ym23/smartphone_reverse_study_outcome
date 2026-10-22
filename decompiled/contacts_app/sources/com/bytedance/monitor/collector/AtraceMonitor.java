package com.bytedance.monitor.collector;

import android.util.Pair;

/* JADX INFO: loaded from: classes2.dex */
public class AtraceMonitor extends AbsMonitor {
    @Override // com.bytedance.monitor.collector.AbsMonitor
    protected void updateConfig(int r1) {
    }

    public AtraceMonitor(int r2) {
        super(r2, MonitorType.ATRACE_MONITOR);
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    Pair<String, ?> dumpInfo() {
    L8:
        return null;
    L4:
        if (PerfMonitorManager.soLoaded == true) goto L6;
        return null;
    L6:
        return new Pair(this.mCollectorType, dumpAtrace());
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    Pair<String, ?> dumpInfosRange(long r4, long r6) {
    L8:
        return null;
    L4:
        if (PerfMonitorManager.soLoaded == true) goto L6;
        return null;
    L6:
        return new Pair(this.mCollectorType, dumpAtraceRange(r4, r6));
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    void dumpInfosToALog(long r3, long r5, long r7) {
        if (PerfMonitorManager.soLoaded == true) goto L6;
        return;
    L6:
        if ((r5 - r3) <= 250) goto L8;
        r5 = r3 + 250;     // Catch: Throwable -> L10
    L8:
        MonitorJni.doDumpAtraceRangeToALog(r3, r5);     // Catch: Throwable -> L10
        return;
    }

    public void enableAtrace(long r2) {
        if (PerfMonitorManager.soLoaded == true) goto L5;
        return;
    L5:
        MonitorJni.doEnableAtrace(this.mRunMode, r2);     // Catch: Throwable -> L7
        return;
    }

    public void disableAtrace() {
        if (PerfMonitorManager.soLoaded == true) goto L5;
        return;
    L5:
        MonitorJni.doDisableAtrace();     // Catch: Throwable -> L7
        return;
    }

    private String dumpAtrace() {
        if (PerfMonitorManager.soLoaded == true) goto L7;
        return null;
    L7:
        return MonitorJni.doDumpAtrace();
    }

    private String dumpAtraceRange(long r1, long r3) {
        if (PerfMonitorManager.soLoaded == true) goto L7;
        return null;
    L7:
        return MonitorJni.doDumpAtraceRange(r1, r3);
    }
}
