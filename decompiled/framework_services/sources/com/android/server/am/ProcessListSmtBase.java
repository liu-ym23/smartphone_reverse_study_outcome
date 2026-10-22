package com.android.server.am;

import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.os.SystemProperties;
import android.os.Trace;
import android.util.Slog;
import bytedanceos.os.PeroptWhiteListParser;
import bytedanceos.util.FeatLog;
import com.android.internal.app.ProcessMap;
import com.android.server.SysOptBridge;
import com.android.server.resmng.IResMngConfig;

/* JADX INFO: loaded from: classes.dex */
public class ProcessListSmtBase {
    static final int SCHED_GROUP_BG_3RD_APP = 10;
    static final int SCHED_GROUP_COMPOSITOR = 12;
    static final int SCHED_GROUP_PREFETCH_VR_APP = -15;
    static final int SCHED_GROUP_SLARDAR_IDLE = 14;
    static final int SCHED_GROUP_SYS_BG_APP = 13;
    static final int SCHED_GROUP_SYS_BG_FREQ_CLAMP_APP = 15;
    private static final String TAG = "ProcessListSmtBase";
    PeroptWhiteListParser mPeroptWhiteListParser;
    final MyPrefetchProcessMap mPrefetchProcess;
    protected ProcessList mProcessList;

    final class MyPrefetchProcessMap extends ProcessMap<ProcessRecord> {
        final /* synthetic */ ProcessListSmtBase this$0;

        MyPrefetchProcessMap(ProcessListSmtBase this$0) {
            this.this$0 = this$0;
        }

        public /* bridge */ /* synthetic */ Object put(String r1, int r2, Object r3) {
            return put(r1, r2, (ProcessRecord) r3);
        }

        /* JADX INFO: renamed from: remove, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1571remove(String r1, int r2) {
            return remove(r1, r2);
        }

        public ProcessRecord put(String name, int uid, ProcessRecord value) {
            ProcessRecord r = (ProcessRecord) super.put(name, uid, value);
            this.this$0.mProcessList.mService.mAtmInternal.getSmtEx().onPrefetchProcessAdded(r.getWindowProcessController());
            return r;
        }

        public ProcessRecord remove(String name, int uid) {
            ProcessRecord r = (ProcessRecord) super.remove(name, uid);
            this.this$0.mProcessList.mService.mAtmInternal.getSmtEx().onPrefetchProcessRemoved(name, uid);
            return r;
        }
    }

    public ProcessListSmtBase(ProcessList processList) {
        this.mPrefetchProcess = new MyPrefetchProcessMap(this);
        this.mProcessList = processList;
    }

    public int getPrefetchSize() {
        return this.mPrefetchProcess.size();
    }

    void registerPeroptWhiteListReceiver() {
        this.mPeroptWhiteListParser = PeroptWhiteListParser.getInstance();
        this.mPeroptWhiteListParser.setContext(this.mProcessList.mService.mContext);
        this.mPeroptWhiteListParser.registerPackageBroadCast();
    }

    void updateAppTypesMapFromCallback(String packageName, String appType) {
        this.mPeroptWhiteListParser.updateAppTypesMapFromCallback(packageName, appType);
    }

    void updateAppTypeMayFromExpandService(ProcessRecord app) {
        if (app.info.getSysEx().appTypeFlag == 0) goto L7;
        if (app.getMonitorEx().isolatedOf3rdPartApp == true) goto L7;
        return;
    L7:
        if (this.mPeroptWhiteListParser == null) goto L11;
        this.mPeroptWhiteListParser.updateAppTypeMayFromExpandService(app.info);
        return;
    }

    ProcessRecord findPrefetchProcessLocked(String processName, ApplicationInfo info) {
        ProcessRecord prefetchProcess = (ProcessRecord) this.mPrefetchProcess.get(processName, info.uid);
        if (prefetchProcess != null) goto L5;
        return null;
    L5:
        if (info.getSysEx().doPrefetch != 1) goto L7;
        return prefetchProcess;
    L7:
        boolean goodPrefetch = false;
        if (prefetchProcess.getThread() == null) goto L40;
        if (prefetchProcess.isKilled() == true) goto L40;
        if (ActivityManagerDebugConfig.DEBUG_PREFETCH == false) goto L14;
        Slog.i("SmartPrefetch", "findPrefetch doPrefetch=" + prefetchProcess.info.getSysEx().doPrefetch + " app=" + prefetchProcess + " set to DONE");
    L14:
        prefetchProcess.info.getSysEx().doPrefetch = 3;
        prefetchProcess.mState.setSetAdj(ProcessList.INVALID_ADJ);
        prefetchProcess.mState.setCurAdj(ProcessList.INVALID_ADJ);
        prefetchProcess.mState.setVerifiedAdj(ProcessList.INVALID_ADJ);
        ProcessList.setOomAdj(prefetchProcess.getPid(), prefetchProcess.getUidRecord().getUid(), prefetchProcess.mState.getSetAdj());
        this.mProcessList.getProcessNamesLOSP().put(processName, info.uid, prefetchProcess);
        this.mPrefetchProcess.remove(processName, info.uid);
        this.mProcessList.mService.addPidLocked(prefetchProcess, false);
        ActivityManagerService.PidMap r3 = this.mProcessList.mService.mPidsSelfLocked;
        monitor-enter(r3);
        this.mProcessList.mService.getSmtEx().mPrefetchPidsSelf.doRemoveInternal(prefetchProcess.getPid(), prefetchProcess);     // Catch: Throwable -> L36
        SysOptBridge.getFactory().getSysPrefetchService().removePrefetchApp(prefetchProcess.getPid(), 1);     // Catch: Throwable -> L36
        monitor-exit(r3);     // Catch: Throwable -> L36
    L22:
        e = move-exception;
        FeatLog.e(TAG, "FEAT_PERF_PREFETCH", 50, "system_server: complete prefetch bind application error!", e);
        this.mProcessList.getProcessNamesLOSP().remove(processName, info.uid);
        monitor-enter(this.mProcessList.mService.mPidsSelfLocked);
        this.mProcessList.mService.removePidLocked(prefetchProcess.getPid(), prefetchProcess);     // Catch: Throwable -> L33
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().removePid(prefetchProcess.getPid());     // Catch: Throwable -> L33
        SysOptBridge.getFactory().getSysPrefetchService().removeAlivePrefetch(processName);
        prefetchProcess = null;
    L31:
        if (prefetchProcess == null) goto L52;
        FeatLog.d(TAG, "FEAT_PERF_PREFETCH", 50, "system_server: prefetch real start process = " + prefetchProcess.processName + ", move to real process map");
        goodPrefetch = true;
    L52:
        if (goodPrefetch == false) goto L65;
        prefetchProcess.addPackage(info.packageName, info.versionCode, this.mProcessList.mService.mProcessStats);
        return prefetchProcess;
    L65:
        return null;
    L33:
        th = move-exception;
        throw th;
    L20:
        if (ActivityManagerDebugConfig.DEBUG_PREFETCH == false) goto L24;
        Slog.i("SmartPrefetch", "findPrefetch process=" + prefetchProcess + " thread=" + prefetchProcess.getThread() + " call completed");     // Catch: Exception -> L22
    L24:
        prefetchProcess.getThread().completePrefetchBindApplication(prefetchProcess.getStartSeq());     // Catch: Exception -> L22
    L36:
        th = move-exception;
        throw th;
    L40:
        if (prefetchProcess.getThread() != null) goto L52;
        this.mProcessList.getProcessNamesLOSP().put(processName, info.uid, prefetchProcess);
        this.mPrefetchProcess.remove(processName, info.uid);
        this.mProcessList.mService.addPidLocked(prefetchProcess, false);
        ActivityManagerService.PidMap r4 = this.mProcessList.mService.mPidsSelfLocked;
        monitor-enter(r4);
        this.mProcessList.mService.mPidsSelfLocked.doAddInternal(prefetchProcess.getPid(), prefetchProcess);     // Catch: Throwable -> L49
        this.mProcessList.mService.getSmtEx().mPrefetchPidsSelf.doRemoveInternal(prefetchProcess.getPid(), prefetchProcess);     // Catch: Throwable -> L49
        SysOptBridge.getFactory().getSysPrefetchService().removePrefetchApp(prefetchProcess.getPid(), 1);     // Catch: Throwable -> L49
        monitor-exit(r4);     // Catch: Throwable -> L49
        if (ActivityManagerDebugConfig.DEBUG_PREFETCH == false) goto L48;
        Slog.i("SmartPrefetch", "findPrefetch doPrefetch=" + prefetchProcess.info.getSysEx().doPrefetch + " app=" + prefetchProcess + " set to NONE prefetchState=" + prefetchProcess.info.getSysEx().prefetchState);
    L48:
        prefetchProcess.info.getSysEx().doPrefetch = 0;
        prefetchProcess.info.getSysEx().prefetchState |= 65536;
        SysOptBridge.getFactory().getAppOpsServiceSysEx().updateMutedApp(info.uid, info.packageName, false);
        goodPrefetch = true;
    L49:
        th = move-exception;
        throw th;
    }

    void prefetchProcPostProcessing(ProcessRecord prefetchProcess, ApplicationInfo info, HostingRecord hostingRecord) {
        Trace.traceBegin(64, "prefetchProcPostProcessing " + prefetchProcess.getPid() + " " + info.packageName + " " + hostingRecord.getType());
        if (prefetchProcess.getPid() <= 0) goto L10;
        ActivityManagerService r0 = this.mProcessList.mService;
        if (ActivityManagerService.mUxPerf == null) goto L9;
        ActivityManagerService r1 = this.mProcessList.mService;
        if (ActivityManagerService.mUxPerf.getPerfHalVersion() < 2.299999952316284d) goto L9;
        ActivityManagerService r2 = this.mProcessList.mService;
        int pkgType2 = ActivityManagerService.mUxPerf.perfGetFeedback(5633, prefetchProcess.processName);
        ActivityManagerService r3 = this.mProcessList.mService;
        ActivityManagerService.mUxPerf.perfHintAcqRel(-1, 4225, prefetchProcess.processName, prefetchProcess.getPid(), 103, 1, new int[]{pkgType2});
    L11:
        Trace.traceEnd(64);
        return;
    L9:
        ActivityManagerService r4 = this.mProcessList.mService;
        ActivityManagerService.mUxPerf.perfHint(4225, prefetchProcess.processName, prefetchProcess.getPid(), 103);
        goto L11
    L10:
        Slog.w(TAG, "prefetchProcess PostProcessing. pid=" + prefetchProcess.getPid() + " app=" + prefetchProcess + " info=" + info + " hostingRecord=" + hostingRecord);
        goto L11
    }

    boolean canUsePtePreload(boolean topApp, int uid, String packageName, String processName) {
        if (processName == null) goto L18;
        if (packageName == null) goto L18;
        if (topApp == false) goto L18;
        if (SysOptBridge.getFactory().getResMngConfig().isModuleEnable(IResMngConfig.FEAT_IO, IResMngConfig.PTE_PRELOAD) == true) goto L11;
        return false;
    L11:
        if (uid >= 10000) goto L14;
        return false;
    L14:
        if (processName.equals(packageName) == true) goto L17;
        return false;
    L17:
        return SysOptBridge.getFactory().getIOFeatureConfig().isPtePreloadPkg(packageName);
    L18:
        return false;
    }

    void processAppColdLaunch(int pid, ApplicationInfo info, boolean topApp) {
        boolean r6 = true;
        if (topApp == false) goto L22;
        Process.setProcessGroup(pid, 5);
        if (SystemProperties.getBoolean("persist.device_config.runtime_native.usap_pool_enabled", false) == true) goto L15;
        if (SysOptBridge.getFactory().getResMngConfig().isModuleEnable(IResMngConfig.FEAT_CPU_OPTIMIZE, IResMngConfig.MOD_SVP_SCENARIO_LIMIT_EXEMPT) == false) goto L13;
        Process.setUIFirstSchedEventTrack(pid, pid, 2, info.packageName, true, 1);
        ISvpSenarioHandler r1 = SysOptBridge.getFactory().getSvpSenarioHandler();
        if (info.getSysEx().consistantsvp != 1) goto L12;
        r6 = false;
    L12:
        r1.svpColdStarting(pid, r6);
        return;
    L13:
        Process.setUIFirstSchedEventTrack(pid, pid, 2, info.packageName, true, 0);
        return;
    L15:
        if (SysOptBridge.getFactory().getResMngConfig().isModuleEnable(IResMngConfig.FEAT_CPU_OPTIMIZE, IResMngConfig.MOD_SVP_SCENARIO_LIMIT_EXEMPT) == false) goto L27;
        ISvpSenarioHandler r2 = SysOptBridge.getFactory().getSvpSenarioHandler();
        if (info.getSysEx().consistantsvp != 1) goto L20;
        r6 = false;
    L20:
        r2.svpColdStarting(pid, r6);
        return;
    L27:
        return;
    L22:
        if (info.getSysEx().consistantsvp != 1) goto L29;
        Slog.d(TAG, "setSvpTask processAppColdLaunch");
        Process.setUIFirstSchedEventTrack(pid, pid, 8, info.packageName, false, 0);
        return;
    }
}
