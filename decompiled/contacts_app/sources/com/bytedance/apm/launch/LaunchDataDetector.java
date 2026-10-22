package com.bytedance.apm.launch;

import android.content.Context;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import com.bytedance.apm.internal.FunctionSwitcher;
import com.bytedance.apm.launch.evil.LaunchSleepDetector;
import com.bytedance.apm.trace.LaunchTrace;
import com.bytedance.monitor.collector.LockMonitorManager;
import com.bytedance.monitor.collector.MonitorConfig;
import com.bytedance.monitor.collector.PerfMonitorManager;

/* JADX INFO: loaded from: classes2.dex */
public class LaunchDataDetector {
    private static volatile boolean isInit = false;

    static {
    }

    public LaunchDataDetector() {
    }

    @Deprecated
    public static void startDetect(Context r9, LaunchTrace.LaunchMonitor r10) {
        if (isInit == false) goto L5;
        return;
    L5:
        isInit = true;
        LaunchAnalysisContext.getInstance().setMonitorConfig(r10);
        FunctionSwitcher.init(r9);
        if (r10.isDetectLongSleep() == true) goto L8;
    L10:
        MonitorConfig.Builder r1 = new MonitorConfig.Builder();
        MonitorConfig.Builder r2 = r1.atraceTag(FunctionSwitcher.getAtraceFlags());
        boolean r7 = false;
        if (FunctionSwitcher.getAtraceFlags() != 0) goto L13;
    L15:
        boolean r3 = false;
    L16:
        MonitorConfig.Builder r4 = r2.enableAtrace(r3);
        if (r10.isDetectLock() == true) goto L19;
    L21:
        boolean r5 = false;
    L22:
        MonitorConfig.Builder r6 = r4.enableLock(r5);
        if (r10.isDetectBinder() == true) goto L25;
    L27:
        r6.enableBinder(r7).enableStackSampling(FunctionSwitcher.getSwitch(64)).enableLooperMonitor(true ^ MainThreadMonitor.getMonitor().isEnableLooperOpt()).runMode(FunctionSwitcher.getMonitorRunMode());
        PerfMonitorManager.getInstance().init(r9, r1.build());
        if (r10.isDetectLock() == true) goto L30;
        return;
    L30:
        if (FunctionSwitcher.getAtraceFlags() != 0) goto L32;
        return;
    L32:
        if (FunctionSwitcher.getSwitch(8) == true) goto L34;
        return;
    L34:
        if (FunctionSwitcher.getSwitch(2) == false) goto L40;
        LockMonitorManager.startLockDetect();
        return;
    L40:
        return;
    L25:
        if (FunctionSwitcher.getSwitch(2) == false) goto L27;
        r7 = true;
        goto L27
    L19:
        if (FunctionSwitcher.getSwitch(8) == false) goto L21;
        r5 = true;
        goto L22
    L13:
        if (FunctionSwitcher.getSwitch(2) == false) goto L15;
        r3 = true;
        goto L16
    L8:
        if (FunctionSwitcher.getSwitch(16) == false) goto L10;
        LaunchSleepDetector.startDetect();
        goto L10
    }
}
