package com.android.server.am;

import android.os.Bundle;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MindSyncManagerInternal {
    public abstract void NotifyPreStartResult(List<PreStartProcInfo> r1);

    public abstract void addAliveApp(String r1);

    public abstract String dumpSimple();

    public abstract String getCurrentLauncherPkgName();

    public abstract int getReportStateForPassiveProvider(String r1);

    public abstract int getRgstGPSControllerState(String r1);

    public abstract int getRgstGPSThredholdInNightMode();

    public abstract int getRgstHighFreqGPSState(String r1);

    public abstract boolean isAllowedInNightMode(String r1);

    public abstract boolean isAllowedPreStartProcess(String r1);

    public abstract boolean isAppProctected(String r1);

    public abstract boolean isMDMAliveApp(String r1);

    public abstract void monitorPrestartProcess(String r1, int r2);

    public abstract void noteIdleCleanup(List<String> r1);

    public abstract void removeAliveApp(String r1);

    public abstract void setCurrentLauncherPkgName(String r1);

    public abstract void setPackagePolicy(String r1, int r2, int r3, int r4, int r5, int r6);

    public abstract void shutdown();

    public abstract void smartStartApp();

    public abstract void smartStartAppTest(String r1);

    public abstract void systemReady(ActivityManagerService r1);

    public abstract void updateCoreSettings(Bundle r1, String r2, int r3, int r4);

    public MindSyncManagerInternal() {
    }
}
