package com.android.server.am;

import android.app.ApplicationErrorReport;
import android.app.IInstrumentationWatcher;
import android.app.IUiAutomationConnection;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.android.server.power.stats.BatteryStatsImpl;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public interface IZswActivityManagerService {
    void appDiedLocked(ProcessRecord r1);

    void checkExcessivePowerUsage();

    void checkExcessivePowerUsage(long r1, long r3, ProcessRecord r5, BatteryStatsImpl r6);

    void createInstanceAndInit(int r1);

    void dump(String r1, FileDescriptor r2, PrintWriter r3, String[] r4);

    void finishBooting();

    void forceStopPackageForCustomFont(int r1, int r2);

    void forceStopPackageInternalLocked(String r1, int r2);

    void getCommonServicesLocked();

    ProcessRecord getProcessRecordFromPidLocked(int r1);

    long getUsedMemoryInfo(ProcessList r1);

    void handleAppDiedLocked(ProcessRecord r1, int r2);

    void handleApplicationCrash(ProcessRecord r1, ApplicationErrorReport.CrashInfo r2);

    boolean hasStableProviderConnectionWithOtherPkg(String r1, int r2);

    void initAppLockHelper(Context r1, ActivityManagerService r2);

    boolean isAppLocked(String r1);

    boolean isAppStartModeLockedSkip(String r1, Intent r2, int r3);

    boolean isHeartyServicePackage(String r1);

    boolean maybeSendBootCompletedLocked(String r1);

    void notePkgForceStopped(String r1);

    void preBindApplication(Bundle r1, ApplicationInfo r2, int r3);

    void preStartAddStartResult(ProcessRecord r1, String r2, int r3);

    void preStartCheckProcExist(String r1, int r2);

    void preStartNotifyStartResult();

    void preStartProcess(String r1, Intent r2, int r3);

    void printMessageInfo(int r1);

    void removeProcAfterDied(String r1);

    void setMonkeyProperties(boolean r1);

    void setZteMonkeyProperties(boolean r1);

    boolean shouldKeepLive(String r1);

    boolean shouldSkipClearPendingIntents(boolean r1, String r2);

    void shutdown();

    boolean startInstrumentation(ComponentName r1, String r2, int r3, Bundle r4, IInstrumentationWatcher r5, IUiAutomationConnection r6, int r7, String r8);

    void systemReady();

    void zteEx_forceStopPackage(String r1, int r2, String r3);
}
