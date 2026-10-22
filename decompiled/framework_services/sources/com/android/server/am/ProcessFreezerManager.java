package com.android.server.am;

import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Trace;
import android.util.ArrayMap;
import android.util.BoostFramework;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.cpu.CpuAvailabilityInfo;
import com.android.server.cpu.CpuAvailabilityMonitoringConfig;
import com.android.server.cpu.CpuMonitorInternal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ProcessFreezerManager {
    private static boolean ALREADY_READ_PROPERTIES = false;
    public static final int COLD_LAUNCH_FREEZE = 2;
    public static final int COMPLETE_LAUNCH_UNFREEZE = 0;
    public static final int CROSS_LAUNCH_UNFREEZE = 4;
    private static final int DEFAULT_CPU_USAGE_THRESHOLD = 60;
    private static final long DEFAULT_DELAY_UNFREEZER_TIMEOUT = 1000;
    private static final int DEFAULT_FREEZE_ADJ_THRESHOLD = 201;
    private static final long DEFAULT_LAUNCH_TIMEOUT = 2000;
    public static final int DEPEND_LAUNCH_UNFREEZE = 5;
    public static final int FIRST_LAUNCH_FREEZE = 0;
    private static final int FROZEN_AND_UPDATE_PROCESS_MSG = 1;
    public static final int INTERRUPT_LAUNCH_UNFREEZE = 1;
    public static final int REMOVE_PROCESS_UNFREEZE = 3;
    private static final int REPORT_UNFREEZE_PROCESS_MSG = 2;
    private static final int REPORT_UNFREEZE_SERVICE_MSG = 0;
    private static String TAG = null;
    public static final int TIMEOUT_LAUNCH_UNFREEZE = 2;
    public static final int WARM_LAUNCH_FREEZE = 1;
    private static volatile boolean mCpuLoadMonitorBG;
    private static volatile int mCpuUsageThreshold;
    private static volatile long mDelayUnfreezeTimeout;
    private static volatile int mFreezeAdjThreshold;
    private static ProcessFreezerManager mInstance;
    private static volatile long mLaunchTimeout;
    private static BoostFramework mPerf;
    private static volatile boolean mUseCpuLoadMonitor;
    private static volatile boolean mUseDebug;
    private static volatile boolean mUseFreezerManager;
    private volatile boolean mCpuHighLoadFlag;
    private Object mCpuHighLoadLock;
    private final CpuLoadMonitor mCpuLoadMonitor;
    private Object mFreezeFlagLock;
    private final Freezer mFreezer;
    private final Handler mFreezerManagerHandler;
    final PackageMap mPackagesSelfLocked;
    private Object mPhenotypeFlagLock;
    final PidMap mPidsSelfLocked;
    private final Map<String, Integer> mProcessFreezeRecordLocked;

    public class CpuLoadMonitor {
        private int mCpuAvalabilityPercentThreshold;
        private CpuMonitorInternal mCpuMonitorService;
        private int mCpuSet;
        final /* synthetic */ ProcessFreezerManager this$0;

        public class CpuAvailabilityCallback implements CpuMonitorInternal.CpuAvailabilityCallback {
            final /* synthetic */ CpuLoadMonitor this$1;

            public CpuAvailabilityCallback(CpuLoadMonitor this$1) {
                this.this$1 = this$1;
            }

            @Override // com.android.server.cpu.CpuMonitorInternal.CpuAvailabilityCallback
            public void onAvailabilityChanged(CpuAvailabilityInfo info) {
                int currentCpuAvalabilityPercent = info.latestAvgAvailabilityPercent;
                if (currentCpuAvalabilityPercent >= CpuLoadMonitor.m1560$$Nest$fgetmCpuAvalabilityPercentThreshold(this.this$1)) goto L5;
                boolean isHighLoad = true;
            L7:
                if (ProcessFreezerManager.m1559$$Nest$sfgetmUseDebug() == true) goto L9;
            L12:
                ProcessFreezerManager.m1557$$Nest$msetCpuHighLoadFlagLocked(this.this$1.this$0, isHighLoad);
                return;
            L9:
                if (isHighLoad == false) goto L11;
                Slog.d(ProcessFreezerManager.m1558$$Nest$sfgetTAG(), "Current CPU usage is " + (100 - currentCpuAvalabilityPercent) + " % and convert to high load");
                goto L12
            L11:
                Slog.d(ProcessFreezerManager.m1558$$Nest$sfgetTAG(), "Current CPU usage is " + (100 - currentCpuAvalabilityPercent) + " % and convert to low load");
                goto L12
            L5:
                isHighLoad = false;
                goto L7
            }

            @Override // com.android.server.cpu.CpuMonitorInternal.CpuAvailabilityCallback
            public void onMonitoringIntervalChanged(long intervalMilliseconds) {
                if (ProcessFreezerManager.m1559$$Nest$sfgetmUseDebug() == false) goto L6;
                Slog.d(ProcessFreezerManager.m1558$$Nest$sfgetTAG(), "CPU load monitor interval convert to " + intervalMilliseconds);
                return;
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCpuAvalabilityPercentThreshold, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m1560$$Nest$fgetmCpuAvalabilityPercentThreshold(CpuLoadMonitor r0) {
            return r0.mCpuAvalabilityPercentThreshold;
        }

        public CpuLoadMonitor(ProcessFreezerManager this$0) {
            this.this$0 = this$0;
            this.mCpuMonitorService = null;
            this.mCpuAvalabilityPercentThreshold = 40;
            this.mCpuSet = 2;
        }

        public void setCpuUsageThreshold(int cpuUsageThreshold) {
            int cpuAvalabilityPercentThreshold = 100 - cpuUsageThreshold;
            if (cpuAvalabilityPercentThreshold >= 0) goto L5;
        L7:
            Slog.d(ProcessFreezerManager.m1558$$Nest$sfgetTAG(), cpuUsageThreshold + " is an invalid CPU usage threshold. The default 60 will be used");
            return;
        L5:
            if (cpuAvalabilityPercentThreshold > 100) goto L7;
            this.mCpuAvalabilityPercentThreshold = cpuAvalabilityPercentThreshold;
        }

        public void setCpuSet(boolean useBgCPU) {
            if (useBgCPU == false) goto L4;
            this.mCpuSet = 2;
            Slog.d(ProcessFreezerManager.m1558$$Nest$sfgetTAG(), "Monitor the BG CPU load");
            return;
        L4:
            this.mCpuSet = 1;
            Slog.d(ProcessFreezerManager.m1558$$Nest$sfgetTAG(), "Monitor the all CPU load");
        }

        public void startCpuLoadMonitorOnce() {
            if (this.mCpuMonitorService == null) goto L5;
            return;
        L5:
            CpuAvailabilityCallback callback = new CpuAvailabilityCallback(this);
            CpuAvailabilityMonitoringConfig config = new CpuAvailabilityMonitoringConfig.Builder(this.mCpuSet, new int[0]).addThreshold(this.mCpuAvalabilityPercentThreshold).build();
            this.mCpuMonitorService = (CpuMonitorInternal) LocalServices.getService(CpuMonitorInternal.class);
            if (this.mCpuMonitorService == null) goto L9;
            this.mCpuMonitorService.addCpuAvailabilityCallback(null, config, callback);
            Slog.d(ProcessFreezerManager.m1558$$Nest$sfgetTAG(), "Already get CPU monitor service and add callback");
            return;
        }
    }

    static final class PackageMap {
        private final Map<String, SparseArray<ProcessRecord>> mPackageMap;

        /* JADX INFO: renamed from: -$$Nest$fgetmPackageMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m1561$$Nest$fgetmPackageMap(PackageMap r0) {
            return r0.mPackageMap;
        }

        PackageMap() {
            this.mPackageMap = new HashMap();
        }

        SparseArray<ProcessRecord> get(String processName) {
            return this.mPackageMap.get(processName);
        }

        boolean contains(String processName) {
            return this.mPackageMap.containsKey(processName);
        }

        int size() {
            return this.mPackageMap.size();
        }

        ArrayList<String> getAllKeys() {
            ArrayList<String> packageNameList = new ArrayList();
            Iterator<String> r1 = this.mPackageMap.keySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            String packageName = r1.next();
            packageNameList.add(packageName);
            goto L4
        L6:
            return packageNameList;
        }

        void put(String processName, SparseArray<ProcessRecord> pidList) {
            this.mPackageMap.put(processName, pidList);
        }

        boolean remove(String processName) {
            if (this.mPackageMap.containsKey(processName) == false) goto L6;
            this.mPackageMap.remove(processName);
            return true;
        L6:
            return false;
        }

        void clear() {
            this.mPackageMap.clear();
        }
    }

    static final class PidMap {
        private final SparseArray<ProcessRecord> mPidMap;

        PidMap() {
            this.mPidMap = new SparseArray();
        }

        ProcessRecord get(int pid) {
            return this.mPidMap.get(pid);
        }

        int size() {
            return this.mPidMap.size();
        }

        ProcessRecord valueAt(int index) {
            return this.mPidMap.valueAt(index);
        }

        int keyAt(int index) {
            return this.mPidMap.keyAt(index);
        }

        int indexOfKey(int key) {
            return this.mPidMap.indexOfKey(key);
        }

        void doAddInternal(int pid, ProcessRecord app) {
            this.mPidMap.put(pid, app);
        }

        boolean doRemoveInternal(int pid, ProcessRecord app) {
            ProcessRecord existingApp = this.mPidMap.get(pid);
            if (existingApp != null) goto L5;
            return false;
        L5:
            if (existingApp.getStartSeq() != app.getStartSeq()) goto L10;
            this.mPidMap.remove(pid);
            return true;
        L10:
            return false;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$kfVzHzuRG2hDNim4gvKvpe-VW60, reason: not valid java name */
    public static /* synthetic */ boolean m1556$r8$lambda$kfVzHzuRG2hDNim4gvKvpeVW60(ProcessFreezerManager r0, Message r1) {
        return r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetCpuHighLoadFlagLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1557$$Nest$msetCpuHighLoadFlagLocked(ProcessFreezerManager r0, boolean r1) {
        r0.setCpuHighLoadFlagLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m1558$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetmUseDebug, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1559$$Nest$sfgetmUseDebug() {
        return mUseDebug;
    }

    static {
        TAG = "ProcessFreezerManager";
        mPerf = new BoostFramework();
        ALREADY_READ_PROPERTIES = false;
        mFreezeAdjThreshold = 201;
        mLaunchTimeout = 2000;
        mCpuUsageThreshold = 60;
        mCpuLoadMonitorBG = true;
        mDelayUnfreezeTimeout = 1000;
        mUseDebug = false;
        mUseFreezerManager = false;
        mUseCpuLoadMonitor = false;
    }

    private void setCpuHighLoadFlagLocked(boolean isHighLoad) {
        Object r0 = this.mCpuHighLoadLock;
        monitor-enter(r0);
        this.mCpuHighLoadFlag = isHighLoad;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean getCpuHighLoadFlagLocked() {
        Object r0 = this.mCpuHighLoadLock;
        monitor-enter(r0);
        boolean r1 = this.mCpuHighLoadFlag;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static ProcessFreezerManager getInstance() {
        if (ALREADY_READ_PROPERTIES == true) goto L6;
        ALREADY_READ_PROPERTIES = true;
        mUseFreezerManager = Boolean.valueOf(mPerf.perfGetProp("ro.vendor.perf.freezer_manager.enable", "false")).booleanValue();
        mUseCpuLoadMonitor = Boolean.valueOf(mPerf.perfGetProp("ro.vendor.perf.freezer_manager.enable_cpu_load_monitor", "false")).booleanValue();
        mCpuUsageThreshold = Integer.valueOf(mPerf.perfGetProp("ro.vendor.perf.freezer_manager.cpu_load_monitor_usage_threshold", String.valueOf(60))).intValue();
        mCpuLoadMonitorBG = Boolean.valueOf(mPerf.perfGetProp("ro.vendor.perf.freezer_manager.cpu_load_monitor_cpuset_bg", "true")).booleanValue();
        mFreezeAdjThreshold = Integer.valueOf(mPerf.perfGetProp("ro.vendor.perf.freezer_manager.freeze_adj_threshold", String.valueOf(201))).intValue();
        mLaunchTimeout = Integer.valueOf(mPerf.perfGetProp("ro.vendor.perf.freezer_manager.launch_timeout_threshold", String.valueOf(2000))).intValue();
        mDelayUnfreezeTimeout = Integer.valueOf(mPerf.perfGetProp("ro.vendor.perf.freezer_manager.delay_unfreeze_threshold", String.valueOf(1000))).intValue();
        mUseDebug = Boolean.valueOf(mPerf.perfGetProp("ro.vendor.perf.freezer_manager.enable_debug", "false")).booleanValue();
        Slog.d(TAG, "---- freezer manager settings ----");
        Slog.d(TAG, "use_freezer_manager=" + mUseFreezerManager);
        Slog.d(TAG, "enable_cpu_load_monitor=" + mUseCpuLoadMonitor);
        Slog.d(TAG, "cpu_load_monitor_usage_threshold=" + mCpuUsageThreshold);
        Slog.d(TAG, "cpu_load_monitor_cpuset_bg=" + mCpuLoadMonitorBG);
        Slog.d(TAG, "freeze_adj_threshold=" + mFreezeAdjThreshold);
        Slog.d(TAG, "launch_timeout_threshold=" + mLaunchTimeout);
        Slog.d(TAG, "delay_unfreeze_threshold=" + mDelayUnfreezeTimeout);
        Slog.d(TAG, "enable_debug=" + mUseDebug);
    L6:
        if (mUseFreezerManager == true) goto L10;
        return null;
    L10:
        if (mInstance != null) goto L23;
        monitor-enter(ProcessFreezerManager.class);
    L16:
        th = move-exception;
        throw th;
    L14:
        if (mInstance != null) goto L18;
        mInstance = new ProcessFreezerManager();     // Catch: Throwable -> L16
    L18:
        monitor-exit(ProcessFreezerManager.class);     // Catch: Throwable -> L16
    L23:
        return mInstance;
    }

    private static final String getFreezeReason(int freezeReason) {
        switch(freezeReason) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return "Unknown";
    L5:
        return "Cold launch";
    L7:
        return "Warm launch";
    L9:
        return "First launch";
    }

    private static final String getUnfreezeReason(int unfreezeReason) {
        switch(unfreezeReason) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L3;
        };
    L3:
        return "Unknown";
    L5:
        return "Dependent launch";
    L7:
        return "Cross launch process";
    L9:
        return "Remove main process";
    L11:
        return "Launch timeout";
    L13:
        return "Interrupt launch";
    L15:
        return "Complete launch";
    }

    private static ServiceThread createAndStartFreezeThread() {
        ServiceThread freezerManagerThread = new ServiceThread("FreezerManagerThread", -10, true);
        freezerManagerThread.start();
        return freezerManagerThread;
    }

    private ProcessFreezerManager() {
        this.mPhenotypeFlagLock = new Object();
        this.mFreezeFlagLock = new Object();
        this.mCpuHighLoadLock = new Object();
        this.mCpuLoadMonitor = new CpuLoadMonitor(this);
        this.mCpuHighLoadFlag = false;
        this.mPidsSelfLocked = new PidMap();
        this.mPackagesSelfLocked = new PackageMap();
        this.mProcessFreezeRecordLocked = new HashMap();
        if (mUseCpuLoadMonitor == false) goto L5;
        this.mCpuLoadMonitor.setCpuUsageThreshold(mCpuUsageThreshold);
        this.mCpuLoadMonitor.setCpuSet(mCpuLoadMonitorBG);
    L5:
        this.mFreezer = new Freezer();
        this.mFreezerManagerHandler = new Handler(createAndStartFreezeThread().getLooper(), new ProcessFreezerManager$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ boolean lambda$new$0(Message msg) {
        switch(msg.what) {
            case 0: goto L61;
            case 1: goto L33;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        return true;
    L5:
        int unfreezeReason = msg.arg1;
        String packageName = (String) msg.obj;
        if (packageContainKey(packageName) == true) goto L9;
        Slog.e(TAG, "Alread triggered unfreeze for " + packageName);
    L71:
        return true;
    L9:
        if (mUseDebug == false) goto L11;
        String unfreezeReasonStr = getUnfreezeReason(unfreezeReason);
        Slog.d(TAG, "= start unfreeze processes for " + packageName + ", reason: " + unfreezeReasonStr);
        Trace.traceBegin(64, "start unfreeze processes for " + packageName + ", reason: " + unfreezeReasonStr);
    L11:
        Object r5 = this.mFreezeFlagLock;
        monitor-enter(r5);
        SparseArray<ProcessRecord> needUnfreezeProcesses = getUnfreezeProcessesLocked(packageName);     // Catch: Throwable -> L19
        if (needUnfreezeProcesses == null) goto L25;
        int i = 0;
    L17:
        if (i >= needUnfreezeProcesses.size()) goto L22;
        needUnfreezeProcesses.keyAt(i);     // Catch: Throwable -> L19
        unFreezeProcess(needUnfreezeProcesses.valueAt(i));     // Catch: Throwable -> L19
        i = i + 1;     // Catch: Throwable -> L19
        goto L17
    L22:
        if (mUseDebug == false) goto L24;
        Slog.d(TAG, "= number of processes to unfreeze is " + needUnfreezeProcesses.size() + " for " + packageName);     // Catch: Throwable -> L19
    L24:
        removePackageLocked(packageName);     // Catch: Throwable -> L19
        removeFreezeRecordLocked(packageName);     // Catch: Throwable -> L19
    L26:
        monitor-exit(r5);     // Catch: Throwable -> L19
        if (mUseDebug == false) goto L71;
        Trace.traceEnd(64);
        goto L71
    L25:
        Slog.d(TAG, "unfreeze object is null for " + packageName);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L33:
        int unfreezeReason2 = msg.arg1;
        String packageName2 = (String) msg.obj;
        if (mUseDebug == false) goto L36;
        String freezeReasonStr = getFreezeReason(unfreezeReason2);
        Slog.d(TAG, "# start freeze processes which adj >= " + mFreezeAdjThreshold + " for " + packageName2 + ", reason: " + freezeReasonStr);
        Trace.traceBegin(64, "start freeze processes which adj >= " + mFreezeAdjThreshold + " for " + packageName2 + ", reason: " + freezeReasonStr);
    L36:
        Object r6 = this.mFreezeFlagLock;
        monitor-enter(r6);
        SparseArray<ProcessRecord> needFreezeProcesses = getFreezeProcessesLocked(packageName2);     // Catch: Throwable -> L46
        if (needFreezeProcesses == null) goto L53;
        List<ProcessRecord> pidsToRemove = new ArrayList();     // Catch: Throwable -> L46
        int i2 = 0;
    L42:
        if (i2 >= needFreezeProcesses.size()) goto L49;
        needFreezeProcesses.keyAt(i2);     // Catch: Throwable -> L46
        ProcessRecord app = needFreezeProcesses.valueAt(i2);     // Catch: Throwable -> L46
        if (freezeProcess(app) == true) goto L48;
        pidsToRemove.add(app);     // Catch: Throwable -> L46
    L48:
        i2 = i2 + 1;     // Catch: Throwable -> L46
        goto L42
    L49:
        removeProcessFromListLocked(packageName2, pidsToRemove);     // Catch: Throwable -> L46
        if (mUseDebug == false) goto L54;
        Slog.d(TAG, "# number of processes to freeze is " + needFreezeProcesses.size() + " for " + packageName2);     // Catch: Throwable -> L46
    L54:
        monitor-exit(r6);     // Catch: Throwable -> L46
        if (mUseDebug == false) goto L71;
        Trace.traceEnd(64);
        goto L71
    L53:
        Slog.d(TAG, "freeze object is null for " + packageName2);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    L61:
        int freezeReason = msg.arg1;
        ProcessRecord app2 = (ProcessRecord) msg.obj;
        if (checkInFreezeProcessLocked(app2) == true) goto L65;
        Slog.d(TAG, "skip unfreeze service: skip reason: " + app2.processName + " has been removed from freeze list");
        goto L71
    L65:
        if (mUseDebug == false) goto L67;
        String unfreezeReasonStr2 = getUnfreezeReason(freezeReason);
        Slog.d(TAG, "= start unfreeze service: " + app2.processName + ", reason: " + unfreezeReasonStr2);
        Trace.traceBegin(64, "start unfreeze service: " + app2.processName + ", reason: " + unfreezeReasonStr2);
    L67:
        unFreezeProcess(app2);
        removeProcessFromListLocked(app2);
        if (mUseDebug == false) goto L71;
        Trace.traceEnd(64);
        goto L71
    }

    void addPidLocked(ProcessRecord app) {
        PidMap r0 = this.mPidsSelfLocked;
        monitor-enter(r0);
        this.mPidsSelfLocked.doAddInternal(app.getPid(), app);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean removePidLocked(int pid, ProcessRecord app) {
        PidMap r0 = this.mPidsSelfLocked;
        monitor-enter(r0);
        boolean r1 = this.mPidsSelfLocked.doRemoveInternal(pid, app);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    ProcessRecord findProcessByNameLocked(String processName) {
        PidMap r0 = this.mPidsSelfLocked;
        monitor-enter(r0);
        int i = 0;
    L20:
    L11:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mPidsSelfLocked.size()) goto L15;
        ProcessRecord foundProcess = this.mPidsSelfLocked.valueAt(i);     // Catch: Throwable -> L11
        if (foundProcess.processName.equals(processName) == true) goto L9;
        i = i + 1;     // Catch: Throwable -> L11
        goto L20
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return foundProcess;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return null;
    }

    private SparseArray<ProcessRecord> findNeedFreezeProcessesLocked(String processName) {
        SparseArray<ProcessRecord> needFreezeProcesses = new SparseArray();
        PidMap r1 = this.mPidsSelfLocked;
        monitor-enter(r1);
        int i = 0;
    L21:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mPidsSelfLocked.size()) goto L17;
        ProcessRecord app = this.mPidsSelfLocked.valueAt(i);     // Catch: Throwable -> L13
        ProcessStateRecord state = app.mState;     // Catch: Throwable -> L13
        if (state.getCurAdj() < 0) goto L15;
        String appPackageName = app.info.packageName;     // Catch: Throwable -> L13
        if (processName.equals(appPackageName) == true) goto L15;
        needFreezeProcesses.put(app.getPid(), app);     // Catch: Throwable -> L13
    L15:
        i = i + 1;     // Catch: Throwable -> L13
        goto L21
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return needFreezeProcesses;
    }

    private boolean checkInFreezeProcessLocked(ProcessRecord app) {
        int pid = app.getPid();
        PackageMap r1 = this.mPackagesSelfLocked;
        monitor-enter(r1);
        Iterator r2 = PackageMap.m1561$$Nest$fgetmPackageMap(this.mPackagesSelfLocked).keySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r2.hasNext() == false) goto L15;
        String packageName = (String) r2.next();     // Catch: Throwable -> L12
        SparseArray<ProcessRecord> freezeList = this.mPackagesSelfLocked.get(packageName);     // Catch: Throwable -> L12
        if (freezeList.get(pid) == null) goto L6;
        monitor-exit(r1);     // Catch: Throwable -> L12
        return true;
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    private boolean isBoundClient(ProcessRecord app, String processName, boolean equal) {
        ProcessServiceRecord psr = app.mServices;
        int sevicesNum = psr.numberOfRunningServices();
        boolean isBound = false;
        int i = sevicesNum - 1;
    L3:
        if (i < 0) goto L28;
        ServiceRecord sr = psr.getRunningServiceAt(i);
        if (sr == null) goto L26;
        ArrayMap<IBinder, ArrayList<ConnectionRecord>> conns = sr.getConnections();
        int conni = conns.size() - 1;
    L8:
        if (conni < 0) goto L26;
        ArrayList<ConnectionRecord> c = conns.valueAt(conni);
        int con = 0;
    L11:
        if (con >= c.size()) goto L25;
        ConnectionRecord cr = c.get(con);
        if (equal == true) goto L15;
        isBound = true;
        if (mUseDebug == false) goto L24;
        Slog.d(TAG, "  " + app.processName + " has been bound client (" + cr.clientPackageName + ").");
    L23:
        con = con + 1;
        goto L11
    L24:
        return true;
    L15:
        if (cr.clientPackageName.equals(processName) == false) goto L23;
        if (mUseDebug == false) goto L19;
        Slog.d(TAG, "Immediately unfreeze service " + app.processName + ". Reason: depend on service(" + sr.processName + ") when launch " + processName);
    L19:
        return true;
    L25:
        conni = conni - 1;
    L26:
        i = i - 1;
        goto L3
    L28:
        return isBound;
    }

    public boolean checkNeedFreezeProcessLocked(ProcessRecord app) {
        int pid = app.getPid();
        boolean isInList = false;
        PackageMap r2 = this.mPackagesSelfLocked;
        monitor-enter(r2);
        Iterator r3 = PackageMap.m1561$$Nest$fgetmPackageMap(this.mPackagesSelfLocked).keySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r3.hasNext() == false) goto L16;
        String packageName = (String) r3.next();     // Catch: Throwable -> L14
        SparseArray<ProcessRecord> freezeList = this.mPackagesSelfLocked.get(packageName);     // Catch: Throwable -> L14
        if (freezeList.get(pid) == null) goto L6;
        if (isBoundClient(app, packageName, true) == false) goto L6;
        isInList = true;
        goto L6
    L16:
        monitor-exit(r2);     // Catch: Throwable -> L14
        return isInList;
    L14:
        th = move-exception;
        throw th;
    }

    private void removeProcessFromListLocked(ProcessRecord app) {
        int pid = app.getPid();
        PackageMap r1 = this.mPackagesSelfLocked;
        monitor-enter(r1);
        Iterator r2 = PackageMap.m1561$$Nest$fgetmPackageMap(this.mPackagesSelfLocked).keySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        String packageName = (String) r2.next();     // Catch: Throwable -> L10
        SparseArray<ProcessRecord> freezeList = this.mPackagesSelfLocked.get(packageName);     // Catch: Throwable -> L10
        if (freezeList.get(pid) == null) goto L6;
        freezeList.remove(pid);     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void removeProcessFromListLocked(String processName, List<ProcessRecord> pidsToRemove) {
        PackageMap r0 = this.mPackagesSelfLocked;
        monitor-enter(r0);
        SparseArray<ProcessRecord> freezeList = this.mPackagesSelfLocked.get(processName);     // Catch: Throwable -> L8
        Iterator<ProcessRecord> r2 = pidsToRemove.iterator();     // Catch: Throwable -> L8
    L6:
        if (r2.hasNext() == false) goto L10;
        ProcessRecord process = r2.next();     // Catch: Throwable -> L8
        freezeList.remove(process.getPid());     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean packageContainKey(String processName) {
        PackageMap r0 = this.mPackagesSelfLocked;
        monitor-enter(r0);
        boolean r1 = this.mPackagesSelfLocked.contains(processName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private SparseArray<ProcessRecord> getFreezeProcessesLocked(String processName) {
        PackageMap r0 = this.mPackagesSelfLocked;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mPackagesSelfLocked.contains(processName) == false) goto L11;
        SparseArray<ProcessRecord> r1 = this.mPackagesSelfLocked.get(processName);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    }

    private SparseArray<ProcessRecord> getUnfreezeProcessesLocked(String processName) {
        PackageMap r0 = this.mPackagesSelfLocked;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mPackagesSelfLocked.contains(processName) == false) goto L11;
        SparseArray<ProcessRecord> r1 = this.mPackagesSelfLocked.get(processName);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    }

    private int getPackageSizeLocked() {
        PackageMap r0 = this.mPackagesSelfLocked;
        monitor-enter(r0);
        int r1 = this.mPackagesSelfLocked.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void addPackageLocked(String processName, SparseArray<ProcessRecord> pidList) {
        PackageMap r0 = this.mPackagesSelfLocked;
        monitor-enter(r0);
        this.mPackagesSelfLocked.put(processName, pidList);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean removePackageLocked(String processName) {
        PackageMap r0 = this.mPackagesSelfLocked;
        monitor-enter(r0);
        SparseArray<ProcessRecord> freezeList = this.mPackagesSelfLocked.get(processName);     // Catch: Throwable -> L7
        freezeList.clear();     // Catch: Throwable -> L7
        boolean r2 = this.mPackagesSelfLocked.remove(processName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    private ArrayList<String> getPackageNameListLocked() {
        PackageMap r0 = this.mPackagesSelfLocked;
        monitor-enter(r0);
        ArrayList<String> r1 = this.mPackagesSelfLocked.getAllKeys();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void clearPackageLocked() {
        PackageMap r0 = this.mPackagesSelfLocked;
        monitor-enter(r0);
        this.mPackagesSelfLocked.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private int getFreezeRecordLocked(String processName) {
        Map<String, Integer> r0 = this.mProcessFreezeRecordLocked;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mProcessFreezeRecordLocked.containsKey(processName) == false) goto L11;
        int r1 = this.mProcessFreezeRecordLocked.get(processName).intValue();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return -1;
    }

    private void addFreezeRecordLocked(String processName, int freezeReason) {
        Map<String, Integer> r0 = this.mProcessFreezeRecordLocked;
        monitor-enter(r0);
        this.mProcessFreezeRecordLocked.put(processName, Integer.valueOf(freezeReason));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeFreezeRecordLocked(String processName) {
        Map<String, Integer> r0 = this.mProcessFreezeRecordLocked;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mProcessFreezeRecordLocked.containsKey(processName) == false) goto L9;
        this.mProcessFreezeRecordLocked.remove(processName);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void unFreezeProcess(ProcessRecord app) {
        ProcessCachedOptimizerRecord opt = app.mOptRecord;
        ProcessStateRecord state = app.mState;
        int pid = app.getPid();
        int uid = app.uid;
        String processName = app.processName;
        String logInfo = String.format("app info: uid=%d, pid=%d, adj=%d, frozen=%b, proc name=%s", new Object[]{Integer.valueOf(uid), Integer.valueOf(pid), Integer.valueOf(state.getCurAdj()), Boolean.valueOf(opt.isFrozen()), processName});
        if (opt.isFrozen() == true) goto L36;
        if (pid == 0) goto L36;
        if (mUseDebug == false) goto L46;
        Trace.traceBegin(64, logInfo);
        Trace.traceBegin(64, "unfreeze binder: " + logInfo);
    L46:
        int rc = this.mFreezer.freezeBinder(pid, false, 2);     // Catch: RuntimeException -> L13
        if (rc == 0) goto L16;
        Slog.w(TAG, " *unable to unfreeze binder: " + logInfo + " " + rc);     // Catch: RuntimeException -> L13
    L45:
    L21:
        if (mUseDebug == false) goto L43;
        Trace.traceEnd(64);
        Trace.traceBegin(64, "unfreeze process: " + logInfo);
    L43:
        this.mFreezer.setProcessFrozen(pid, uid, false);     // Catch: Exception -> L27
        if (mUseDebug == false) goto L32;
        Slog.d(TAG, "  unfreeze process: " + logInfo);     // Catch: Exception -> L27
    L32:
        if (mUseDebug == false) goto L48;
        Trace.traceEnd(64);
        Trace.traceEnd(64);
        return;
    L48:
        return;
    L27:
        e = move-exception;
        Slog.w(TAG, " *unable to unfreeze process: " + logInfo + " " + e);
        StringBuilder r0 = new StringBuilder();
        r0.append("unable to unfreeze process: ");
        r0.append(logInfo);
        Trace.traceBegin(64, r0.toString());
        Trace.traceEnd(64);
        goto L32
    L16:
        if (mUseDebug == false) goto L45;
        Slog.d(TAG, "  unfreeze binder:  " + logInfo);     // Catch: RuntimeException -> L13
    L13:
        e = move-exception;
        Slog.w(TAG, " *unable to unfreeze binder for " + pid + ": " + e);
        StringBuilder r11 = new StringBuilder();
        r11.append("unable to unfreeze binder: ");
        r11.append(logInfo);
        Trace.traceBegin(64, r11.toString());
        Trace.traceEnd(64);
    L36:
        if (mUseDebug == false) goto L49;
        Trace.traceBegin(64, "skip unfreeze: " + logInfo);
        Trace.traceEnd(64);
        if (opt.isFrozen() == false) goto L40;
        Slog.d(TAG, " *skip unfreeze: skip reason: process is frozen by default freezer. " + logInfo);
    L40:
        if (pid != 0) goto L50;
        Slog.d(TAG, " *skip unfreeze: skip reason: process is dead. " + logInfo);
        return;
    L50:
        return;
    }

    private boolean freezeProcess(ProcessRecord app) {
        ProcessCachedOptimizerRecord opt = app.mOptRecord;
        ProcessStateRecord state = app.mState;
        ProcessServiceRecord psr = app.mServices;
        int pid = app.getPid();
        int uid = app.uid;
        int sevicesNum = psr.numberOfRunningServices();
        String processName = app.processName;
        String logInfo = String.format("app info: uid=%d, pid=%d, adj=%d, frozen=%b, services=%d, proc name=%s", new Object[]{Integer.valueOf(uid), Integer.valueOf(pid), Integer.valueOf(state.getCurAdj()), Boolean.valueOf(opt.isFrozen()), Integer.valueOf(sevicesNum), processName});
        boolean freezeBinderSuccess = false;
        boolean freezeProcessSuccess = false;
        if (opt.isFrozen() == true) goto L57;
        if (pid == 0) goto L57;
        if (state.getCurAdj() >= mFreezeAdjThreshold) goto L13;
        if (mUseDebug == false) goto L11;
        Slog.d(TAG, " *skip freeze: skip reason: process's adj < " + mFreezeAdjThreshold + ". " + logInfo);
    L11:
        return false;
    L13:
        if (state.getCurAdj() > 200) goto L25;
        boolean hasBoundClient = isBoundClient(app, app.processName, false);
        if (hasBoundClient == false) goto L25;
        if (mUseDebug == false) goto L20;
        Slog.d(TAG, " *skip freeze: skip reason: process's service has bound client. " + logInfo);
        Trace.traceBegin(64, "skip freeze: skip reason: process's service has bound client. " + logInfo);
        Trace.traceEnd(64);
        return false;
    L20:
        return false;
    L25:
        if (mUseDebug == false) goto L66;
        Trace.traceBegin(64, logInfo);
        Trace.traceBegin(64, "freeze binder: " + logInfo);
    L66:
        int rc = this.mFreezer.freezeBinder(pid, true, 2);     // Catch: RuntimeException -> L31
        if (rc == 0) goto L33;
        Slog.w(TAG, " *unable to freeze binder for " + pid + ": " + rc);     // Catch: RuntimeException -> L31
    L39:
        if (mUseDebug == false) goto L65;
        Trace.traceEnd(64);
        Trace.traceBegin(64, "freeze process: " + logInfo);
    L65:
        if (freezeBinderSuccess == false) goto L48;
        this.mFreezer.setProcessFrozen(pid, uid, true);     // Catch: RuntimeException -> L45
        if (mUseDebug == false) goto L47;
        Slog.d(TAG, "  freeze process: " + logInfo);     // Catch: RuntimeException -> L45
    L47:
        freezeProcessSuccess = true;
    L52:
        if (mUseDebug == false) goto L54;
        Trace.traceEnd(64);
        Trace.traceEnd(64);
    L54:
        return freezeProcessSuccess;
    L48:
        Slog.d(TAG, " *skip freeze process: skip reason: unable to freeze process's binder. " + logInfo);     // Catch: RuntimeException -> L45
        goto L52
    L50:
        Trace.traceBegin(64, "unable to freeze process: " + logInfo);
        Trace.traceEnd(64);
        Slog.w(TAG, "  unbale to freeze process: " + logInfo);
        goto L52
    L33:
        freezeBinderSuccess = true;
        if (mUseDebug == false) goto L39;
        Slog.d(TAG, "  freeze binder : " + logInfo);     // Catch: RuntimeException -> L31
        goto L39
    L37:
        Trace.traceBegin(64, "unable to freeze binder: " + logInfo);
        Trace.traceEnd(64);
        Slog.w(TAG, "  unbale to freeze binder: " + logInfo);
    L57:
        if (mUseDebug == false) goto L68;
        Trace.traceBegin(64, "skip frozen process: " + logInfo);
        Trace.traceEnd(64);
        if (opt.isFrozen() == false) goto L61;
        Slog.d(TAG, " *skip freeze: skip reason: process is frozen by default freezer. " + logInfo);
    L61:
        if (pid != 0) goto L69;
        Slog.d(TAG, " *skip freeze: skip reason: process is dead. " + logInfo);
        return false;
    L69:
        return false;
    L68:
        return false;
    }

    public boolean isMainProcess(String packageName) {
        return !packageName.contains(":");
    }

    public void startFreeze(String packageName, int freezeReason) {
        if (mUseCpuLoadMonitor == false) goto L5;
        this.mCpuLoadMonitor.startCpuLoadMonitorOnce();
    L5:
        startFreezeInternal(packageName, freezeReason);
    }

    private void startFreezeInternal(String packageName, int freezeReason) {
        if (isMainProcess(packageName) == true) goto L6;
        return;
    L6:
        if (packageContainKey(packageName) == false) goto L10;
        Slog.d(TAG, "Already triggered freeze for " + packageName);
        return;
    L10:
        if (mUseCpuLoadMonitor == true) goto L12;
    L17:
        startUnfreezeAll();
        SparseArray<ProcessRecord> needFreezeProcesses = findNeedFreezeProcessesLocked(packageName);
        if (needFreezeProcesses.size() == 0) goto L20;
        addFreezeRecordLocked(packageName, freezeReason);
        addPackageLocked(packageName, needFreezeProcesses);
        this.mFreezerManagerHandler.sendMessage(this.mFreezerManagerHandler.obtainMessage(1, freezeReason, 0, packageName));
        startTimeoutUnfreeze(packageName);
        return;
    L20:
        if (mUseDebug == false) goto L26;
        Slog.d(TAG, "skip freeze: skip reason: No proper processes to freeze for " + packageName);
        return;
    L26:
        return;
    L12:
        if (getCpuHighLoadFlagLocked() == true) goto L17;
        if (mUseDebug == false) goto L25;
        Slog.d(TAG, "Skip freeze: skip reason: CPU load is low when launching " + packageName);
        return;
    }

    private void startTimeoutUnfreeze(String packageName) {
        this.mFreezerManagerHandler.sendMessageDelayed(this.mFreezerManagerHandler.obtainMessage(2, 2, 0, packageName), mLaunchTimeout);
    }

    private void removeTimeoutUnfreeze(String packageName) {
        this.mFreezerManagerHandler.removeMessages(2, packageName);
    }

    private void startUnfreezeAll() {
        ArrayList<String> packageNameList = getPackageNameListLocked();
        Iterator<String> r1 = packageNameList.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String packageName = r1.next();
        startUnfreezeInternal(packageName, 4);
        goto L4
    }

    public void startUnfreezeService(ProcessRecord app, int unfreezeReason) {
        this.mFreezerManagerHandler.sendMessage(this.mFreezerManagerHandler.obtainMessage(0, unfreezeReason, 0, app));
    }

    public void startUnfreeze(String packageName, int unfreezeReason) {
        startUnfreezeInternal(packageName, unfreezeReason);
    }

    private void startUnfreezeInternal(String packageName, int unfreezeReason) {
        if (packageContainKey(packageName) == true) goto L5;
        return;
    L5:
        removeTimeoutUnfreeze(packageName);
        if (unfreezeReason != 0) goto L12;
        int freezeReason = getFreezeRecordLocked(packageName);
        if (freezeReason != 1) goto L10;
        this.mFreezerManagerHandler.sendMessage(this.mFreezerManagerHandler.obtainMessage(2, unfreezeReason, 0, packageName));
        return;
    L10:
        this.mFreezerManagerHandler.sendMessageDelayed(this.mFreezerManagerHandler.obtainMessage(2, unfreezeReason, 0, packageName), mDelayUnfreezeTimeout);
        return;
    L12:
        this.mFreezerManagerHandler.sendMessage(this.mFreezerManagerHandler.obtainMessage(2, unfreezeReason, 0, packageName));
    }

    public boolean useFreezerManager() {
        Object r0 = this.mPhenotypeFlagLock;
        monitor-enter(r0);
        boolean r1 = mUseFreezerManager;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
