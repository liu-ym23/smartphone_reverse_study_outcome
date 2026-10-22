package com.android.server.am;

import android.app.ActivityManager;
import android.app.ActivityThread;
import android.app.SysMonitorFwBridge;
import android.content.ComponentName;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ApplicationInfoSysEx;
import android.net.NetworkPolicyManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.Trace;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.ServiceThread;
import com.android.server.SysOptBridge;
import com.android.server.resmng.IResMngConfig;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.wm.ActivityServiceConnectionsHolder;
import com.android.server.wm.ActivityTaskManagerDebugConfig;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OomAdjuster {
    private static final int CACHING_UI_SERVICE_CLIENT_ADJ_THRESHOLD = 0;
    static final long CAMERA_MICROPHONE_CAPABILITY_CHANGE_ID = 136219221;
    private static final long NO_FOLLOW_UP_TIME = Long.MAX_VALUE;
    static final long PERCEPTIBLE_TASK_TIMEOUT_MILLIS = 300000;
    static final long PROCESS_CAPABILITY_CHANGE_ID = 136274596;
    static final String TAG = "OomAdjuster";
    static final long USE_SHORT_FGS_USAGE_INTERACTION_TIME = 183972877;
    public static int mCurAppPid;
    public static int mCurRenderThreadTid;
    public static int mCurRenderTid;
    public static boolean mIsTopAppRenderThreadBoostEnabled;
    public static BoostFramework mPerf;
    public static BoostFramework mPerfBoost;
    public static int mPerfHandle;
    private static boolean oomadjusterthread_prio_initialized;
    ActiveUids mActiveUids;
    int mAdjSeq;
    private final ServiceThread mAdjusterThread;
    int mBServiceAppThreshold;
    CacheOomRanker mCacheOomRanker;
    CachedAppOptimizer mCachedAppOptimizer;
    ActivityManagerConstants mConstants;
    boolean mEnableBServicePropagation;
    boolean mEnableBgt;
    boolean mEnableProcessGroupCgroupFollow;
    private final ArraySet<ProcessRecord> mFollowUpUpdateSet;
    final GlobalState mGlobalState;
    final Injector mInjector;
    private double mLastFreeSwapPercent;
    protected int mLastReason;
    boolean mLazyLmkKillMainProc;
    private final OomAdjusterDebugLogger mLogger;
    int mMinBServiceAgingTime;
    int mNewNumAServiceProcs;
    int mNewNumServiceProcs;
    private long mNextFollowUpUpdateUptimeMs;
    private long mNextNoKillDebugMessageTime;
    int mNumCachedHiddenProcs;
    int mNumNonCachedProcs;
    int mNumServiceProcs;
    private final int mNumSlots;
    private boolean mOomAdjUpdateOngoing;
    private final IOomAdjusterOptEx mOomAdjusterOptEx;
    private boolean mPendingFullOomAdjUpdate;
    protected final ArraySet<ProcessRecord> mPendingProcessSet;
    final ActivityManagerGlobalLock mProcLock;
    boolean mProcessGroupCgroupFollowDex2oatOnly;
    private final Handler mProcessGroupHandler;
    final ProcessList mProcessList;
    protected int mProcessStateCurTop;
    protected final ArraySet<ProcessRecord> mProcessesInCycle;
    protected final ArrayList<ProcessRecord> mProcsToOomAdj;
    final ActivityManagerService mService;
    protected final ArrayList<UidRecord> mTmpBecameIdle;
    protected final ComputeOomAdjWindowCallback mTmpComputeOomAdjWindowCallback;
    final long[] mTmpLong;
    protected final ArrayList<ProcessRecord> mTmpProcessList;
    protected final ArrayList<ProcessRecord> mTmpProcessList2;
    protected final ArraySet<ProcessRecord> mTmpProcessSet;
    protected final ArrayDeque<ProcessRecord> mTmpQueue;
    protected final int[] mTmpSchedGroup;
    protected final ActiveUids mTmpUidRecords;

    final class ComputeOomAdjWindowCallback {
        int adj;
        ProcessRecord app;
        int appUid;
        boolean foregroundActivities;
        int logUid;
        String mAdjType;
        boolean mHasVisibleActivities;
        ProcessStateRecord mState;
        int procState;
        int processStateCurTop;
        int schedGroup;
        final /* synthetic */ OomAdjuster this$0;

        ComputeOomAdjWindowCallback(OomAdjuster this$0) {
            this.this$0 = this$0;
        }

        void initialize(ProcessRecord app, int adj, boolean foregroundActivities, boolean hasVisibleActivities, int procState, int schedGroup, int appUid, int logUid, int processStateCurTop) {
            this.app = app;
            this.adj = adj;
            this.foregroundActivities = foregroundActivities;
            this.mHasVisibleActivities = hasVisibleActivities;
            this.procState = procState;
            this.schedGroup = schedGroup;
            this.appUid = appUid;
            this.logUid = logUid;
            this.processStateCurTop = processStateCurTop;
            this.mAdjType = app.mState.getAdjType();
            this.mState = app.mState;
        }

        void onVisibleActivity(int flags) {
            if (this.adj <= 100) goto L10;
            this.adj = 100;
            this.mAdjType = "vis-activity";
            if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == false) goto L7;
        L8:
            this.this$0.reportOomAdjMessageLocked("ActivityManager", "Raise adj to vis-activity: " + this.app);
            goto L10
        L7:
            if (this.logUid == this.appUid) goto L8;
        L10:
            if (this.procState <= this.processStateCurTop) goto L17;
            this.procState = this.processStateCurTop;
            this.mAdjType = "vis-activity";
            if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == false) goto L14;
        L15:
            this.this$0.reportOomAdjMessageLocked("ActivityManager", "Raise procstate to vis-activity (top): " + this.app);
            goto L17
        L14:
            if (this.logUid == this.appUid) goto L15;
        L17:
            if (this.schedGroup >= 2) goto L20;
            this.schedGroup = 2;
        L20:
            if ((8388608 & flags) == 0) goto L23;
            this.schedGroup = 3;
            this.mAdjType = "resumed-split-screen-activity";
        L28:
            this.foregroundActivities = true;
            this.mHasVisibleActivities = true;
            return;
        L23:
            if ((16777216 & flags) == 0) goto L26;
            this.schedGroup = 3;
            this.mAdjType = "perceptible-freeform-activity";
            goto L28
        L26:
            if ((33554432 & flags) == 0) goto L28;
            this.schedGroup = 5;
            this.mAdjType = "vis-multi-window-activity";
            goto L28
        }

        void onPausedActivity() {
            if (this.adj <= 200) goto L10;
            this.adj = 200;
            this.mAdjType = "pause-activity";
            if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == false) goto L7;
        L8:
            this.this$0.reportOomAdjMessageLocked("ActivityManager", "Raise adj to pause-activity: " + this.app);
            goto L10
        L7:
            if (this.logUid == this.appUid) goto L8;
        L10:
            if (this.procState <= this.processStateCurTop) goto L17;
            this.procState = this.processStateCurTop;
            this.mAdjType = "pause-activity";
            if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == false) goto L14;
        L15:
            this.this$0.reportOomAdjMessageLocked("ActivityManager", "Raise procstate to pause-activity (top): " + this.app);
            goto L17
        L14:
            if (this.logUid == this.appUid) goto L15;
        L17:
            if (this.schedGroup >= 2) goto L19;
            this.schedGroup = 2;
        L19:
            this.foregroundActivities = true;
            this.mHasVisibleActivities = false;
        }

        void onStoppingActivity(boolean finishing) {
            if (this.adj <= 200) goto L9;
            this.adj = 200;
            this.mAdjType = "stop-activity";
            if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == false) goto L7;
        L8:
            this.this$0.reportOomAdjMessageLocked("ActivityManager", "Raise adj to stop-activity: " + this.app);
            goto L9
        L7:
            if (this.logUid == this.appUid) goto L8;
        L9:
            if (finishing == false) goto L11;
        L17:
            this.foregroundActivities = true;
            this.mHasVisibleActivities = false;
            return;
        L11:
            if (this.procState <= 15) goto L17;
            this.procState = 15;
            this.mAdjType = "stop-activity";
            if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == false) goto L15;
        L16:
            this.this$0.reportOomAdjMessageLocked("ActivityManager", "Raise procstate to stop-activity: " + this.app);
            goto L17
        L15:
            if (this.logUid != this.appUid) goto L17;
            goto L16
        }

        void onOtherActivity(long perceptibleTaskStoppedTimeMillis) {
            if (this.procState <= 16) goto L9;
            this.procState = 16;
            this.mAdjType = "cch-act";
            if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == false) goto L7;
        L8:
            this.this$0.reportOomAdjMessageLocked("ActivityManager", "Raise procstate to cached activity: " + this.app);
            goto L9
        L7:
            if (this.logUid == this.appUid) goto L8;
        L9:
            this.mHasVisibleActivities = false;
        }
    }

    interface GlobalState {
        ProcessRecord getBackupTarget(int r1);

        boolean isAwake();

        boolean isLastMemoryLevelNormal();
    }

    public static class Injector {
        public Injector() {
        }

        boolean isChangeEnabled(int cachedCompatChangeId, ApplicationInfo app, boolean defaultValue) {
            PlatformCompatCache.getInstance();
            return PlatformCompatCache.isChangeEnabled(cachedCompatChangeId, app, defaultValue);
        }

        long getUptimeMillis() {
            return SystemClock.uptimeMillis();
        }

        long getElapsedRealtimeMillis() {
            return SystemClock.elapsedRealtime();
        }

        void batchSetOomAdj(ArrayList<ProcessRecord> procsToOomAdj) {
            ProcessList.batchSetOomAdj(procsToOomAdj);
        }

        void batchSetOomAdjExt(ArrayList<ProcessRecord> procsToOomAdj) {
            ProcessList.batchSetOomAdjExt(procsToOomAdj);
        }

        void setOomAdj(int pid, int uid, int adj) {
            ProcessList.setOomAdj(pid, uid, adj);
        }

        void setOomAdjExt(int pid, int uid, int adj, int isSystemApp, int isMainProc) {
            ProcessList.setOomAdjExt(pid, uid, adj, isSystemApp, isMainProc);
        }

        void setThreadPriority(int tid, int priority) {
            Process.setThreadPriority(tid, priority);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$9F-hNbXzRFxc_BBmKMXasg6rCRI, reason: not valid java name */
    public static /* synthetic */ void m1520$r8$lambda$9FhNbXzRFxc_BBmKMXasg6rCRI(OomAdjuster r0, ProcessRecord r1) {
        r0.updateKeepWarmIfNecessaryForProcessLocked(r1);
    }

    public static /* synthetic */ void $r8$lambda$HE3RR_IDk_ZVk05ZPt838QkiYKw(OomAdjuster r0, ProcessRecord r1) {
        r0.lambda$applyOomAdjLSP$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$uOb2fkEfiodlL-R7ljyXmiY1wCQ, reason: not valid java name */
    public static /* synthetic */ boolean m1521$r8$lambda$uOb2fkEfiodlLR7ljyXmiY1wCQ(OomAdjuster r0, Message r1) {
        return r0.lambda$new$0(r1);
    }

    public static final int oomAdjReasonToProto(int oomReason) {
        switch(oomReason) {
            case 0: goto L53;
            case 1: goto L51;
            case 2: goto L49;
            case 3: goto L47;
            case 4: goto L45;
            case 5: goto L43;
            case 6: goto L41;
            case 7: goto L39;
            case 8: goto L37;
            case 9: goto L35;
            case 10: goto L33;
            case 11: goto L31;
            case 12: goto L29;
            case 13: goto L27;
            case 14: goto L25;
            case 15: goto L23;
            case 16: goto L21;
            case 17: goto L19;
            case 18: goto L17;
            case 19: goto L15;
            case 20: goto L13;
            case 21: goto L11;
            case 22: goto L9;
            case 23: goto L7;
            case 24: goto L5;
            default: goto L3;
        };
    L3:
        return -1;
    L5:
        return 24;
    L7:
        return 23;
    L9:
        return 22;
    L11:
        return 21;
    L13:
        return 20;
    L15:
        return 19;
    L17:
        return 18;
    L19:
        return 17;
    L21:
        return 16;
    L23:
        return 15;
    L25:
        return 14;
    L27:
        return 13;
    L29:
        return 12;
    L31:
        return 11;
    L33:
        return 10;
    L35:
        return 9;
    L37:
        return 8;
    L39:
        return 7;
    L41:
        return 6;
    L43:
        return 5;
    L45:
        return 4;
    L47:
        return 3;
    L49:
        return 2;
    L51:
        return 1;
    L53:
        return 0;
    }

    public static final String oomAdjReasonToString(int oomReason) {
        switch(oomReason) {
            case 0: goto L54;
            case 1: goto L52;
            case 2: goto L50;
            case 3: goto L48;
            case 4: goto L46;
            case 5: goto L44;
            case 6: goto L42;
            case 7: goto L40;
            case 8: goto L38;
            case 9: goto L36;
            case 10: goto L34;
            case 11: goto L32;
            case 12: goto L30;
            case 13: goto L28;
            case 14: goto L26;
            case 15: goto L24;
            case 16: goto L22;
            case 17: goto L20;
            case 18: goto L18;
            case 19: goto L16;
            case 20: goto L14;
            case 21: goto L12;
            case 22: goto L10;
            case 23: goto L8;
            case 24: goto L6;
            default: goto L4;
        };
    L4:
        return "_unknown";
    L6:
        return "updateOomAdj_reconfiguration";
    L8:
        return "updateOomAdj_followUp";
    L10:
        return "updateOomAdj_componentDisabled";
    L12:
        return "updateOomAdj_restrictionChange";
    L14:
        return "updateOomAdj_executingService";
    L16:
        return "updateOomAdj_stopService";
    L18:
        return "updateOomAdj_uidIdle";
    L20:
        return "updateOomAdj_removeTask";
    L22:
        return "updateOomAdj_shell";
    L24:
        return "updateOomAdj_backup";
    L26:
        return "updateOomAdj_systemInit";
    L28:
        return "updateOomAdj_shortFgs";
    L30:
        return "updateOomAdj_processEnd";
    L32:
        return "updateOomAdj_processBegin";
    L34:
        return "updateOomAdj_allowlistChange";
    L36:
        return "updateOomAdj_uiVisibility";
    L38:
        return "updateOomAdj_removeProvider";
    L40:
        return "updateOomAdj_getProvider";
    L42:
        return "updateOomAdj_startService";
    L44:
        return "updateOomAdj_unbindService";
    L46:
        return "updateOomAdj_bindService";
    L48:
        return "updateOomAdj_startReceiver";
    L50:
        return "updateOomAdj_finishReceiver";
    L52:
        return "updateOomAdj_activityChange";
    L54:
        return "updateOomAdj_meh";
    }

    static {
        mPerf = new BoostFramework();
        mPerfBoost = new BoostFramework();
        mPerfHandle = -1;
        mCurAppPid = -1;
        mCurRenderTid = -1;
        mCurRenderThreadTid = -1;
        mIsTopAppRenderThreadBoostEnabled = false;
        oomadjusterthread_prio_initialized = false;
        CACHING_UI_SERVICE_CLIENT_ADJ_THRESHOLD = 500;
    }

    boolean isChangeEnabled(int cachedCompatChangeId, ApplicationInfo app, boolean defaultValue) {
        return this.mInjector.isChangeEnabled(cachedCompatChangeId, app, defaultValue);
    }

    static ServiceThread createAdjusterThread() {
        ServiceThread adjusterThread = new ServiceThread(TAG, -10, false);
        adjusterThread.start();
        return adjusterThread;
    }

    OomAdjuster(ActivityManagerService service, ProcessList processList, ActiveUids activeUids, ServiceThread adjusterThread, GlobalState globalState, CachedAppOptimizer cachedAppOptimizer, Injector injector) {
        this.mTmpLong = new long[3];
        this.mAdjSeq = 0;
        this.mNumServiceProcs = 0;
        this.mNewNumAServiceProcs = 0;
        this.mNewNumServiceProcs = 0;
        this.mNumNonCachedProcs = 0;
        this.mNumCachedHiddenProcs = 0;
        this.mTmpSchedGroup = new int[1];
        this.mMinBServiceAgingTime = 5000;
        this.mBServiceAppThreshold = 5;
        this.mEnableBServicePropagation = false;
        this.mEnableProcessGroupCgroupFollow = false;
        this.mProcessGroupCgroupFollowDex2oatOnly = false;
        this.mEnableBgt = false;
        this.mLazyLmkKillMainProc = false;
        this.mTmpProcessList = new ArrayList();
        this.mTmpProcessList2 = new ArrayList();
        this.mTmpBecameIdle = new ArrayList();
        this.mTmpProcessSet = new ArraySet();
        this.mPendingProcessSet = new ArraySet();
        this.mProcessesInCycle = new ArraySet();
        this.mProcsToOomAdj = new ArrayList();
        this.mOomAdjUpdateOngoing = false;
        this.mPendingFullOomAdjUpdate = false;
        this.mProcessStateCurTop = 2;
        this.mFollowUpUpdateSet = new ArraySet();
        this.mNextFollowUpUpdateUptimeMs = Long.MAX_VALUE;
        this.mLastFreeSwapPercent = 1.0d;
        this.mTmpComputeOomAdjWindowCallback = new ComputeOomAdjWindowCallback(this);
        this.mService = service;
        this.mGlobalState = globalState;
        this.mInjector = injector;
        this.mProcessList = processList;
        this.mProcLock = service.mProcLock;
        this.mActiveUids = activeUids;
        this.mConstants = this.mService.mConstants;
        this.mCachedAppOptimizer = cachedAppOptimizer;
        this.mCacheOomRanker = new CacheOomRanker(service);
        this.mLogger = new OomAdjusterDebugLogger(this, this.mService.mConstants);
        if (mPerf == null) goto L5;
        this.mMinBServiceAgingTime = Integer.valueOf(mPerf.perfGetProp("ro.vendor.qti.sys.fw.bservice_age", "5000")).intValue();
        this.mBServiceAppThreshold = Integer.valueOf(mPerf.perfGetProp("ro.vendor.qti.sys.fw.bservice_limit", "5")).intValue();
        this.mEnableBServicePropagation = Boolean.parseBoolean(mPerf.perfGetProp("ro.vendor.qti.sys.fw.bservice_enable", "false"));
        this.mEnableProcessGroupCgroupFollow = Boolean.parseBoolean(mPerf.perfGetProp("ro.vendor.qti.cgroup_follow.enable", "false"));
        this.mProcessGroupCgroupFollowDex2oatOnly = Boolean.parseBoolean(mPerf.perfGetProp("ro.vendor.qti.cgroup_follow.dex2oat_only", "false"));
        mIsTopAppRenderThreadBoostEnabled = Boolean.parseBoolean(mPerf.perfGetProp("vendor.perf.topAppRenderThreadBoost.enable", "false"));
        this.mEnableBgt = Boolean.parseBoolean(mPerf.perfGetProp("vendor.perf.bgt.enable", "false"));
        this.mLazyLmkKillMainProc = Boolean.parseBoolean(mPerf.perfGetProp("ro.lmk.lazy_killing_3rd_app_main_proc", "false"));
    L5:
        this.mAdjusterThread = adjusterThread;
        this.mProcessGroupHandler = new Handler(adjusterThread.getLooper(), new OomAdjuster$$ExternalSyntheticLambda0(this));
        this.mTmpUidRecords = new ActiveUids(service, false);
        this.mTmpQueue = new ArrayDeque(this.mConstants.CUR_MAX_CACHED_PROCESSES << 1);
        this.mNumSlots = 10;
        this.mOomAdjusterOptEx = SysOptBridge.getFactory().getOomAdjusterOptEx(this, this.mService);
    }

    private /* synthetic */ boolean lambda$new$0(Message msg) {
        int group = msg.what;
        ProcessRecord app = (ProcessRecord) msg.obj;
        ActivityManagerService r3 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        int _pid = app.getSmtEx().getPid();     // Catch: Throwable -> L8
        monitor-exit(r3);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        SysOptBridge.getFactory().getActivityManager(this.mService).asyncSetProcessGroupAll(app, _pid, group);
        this.mService.mPhantomProcessList.setProcessGroupForPhantomProcessOfApp(app, group);
        return true;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void setProcessGroup(int pid, int group, String processName) {
        if (pid != ActivityManagerService.MY_PID) goto L5;
        return;
    L5:
        boolean traceEnabled = Trace.isTagEnabled(64);
        if (traceEnabled == false) goto L19;
        Trace.traceBegin(64, "setProcessGroup " + processName + " to " + group);
    L19:
        Process.setProcessGroup(pid, group);     // Catch: Throwable -> L11 Exception -> L15
        if (traceEnabled == false) goto L18;
    L10:
        Trace.traceEnd(64);
        return;
    L18:
        return;
    L11:
        th = move-exception;
        if (traceEnabled == false) goto L14;
        Trace.traceEnd(64);
    L14:
        throw th;
    L16:
        if (traceEnabled == true) goto L10;
    }

    void setAppAndChildProcessGroup(ProcessRecord app, int group) {
        this.mProcessGroupHandler.sendMessage(this.mProcessGroupHandler.obtainMessage(group, app));
    }

    void initSettings() {
        this.mCachedAppOptimizer.init();
        this.mCacheOomRanker.init(ActivityThread.currentApplication().getMainExecutor());
        if (this.mService.mConstants.KEEP_WARMING_SERVICES.size() <= 0) goto L6;
        IntentFilter filter = new IntentFilter("android.intent.action.USER_SWITCHED");
        this.mService.mContext.registerReceiverForAllUsers(new AnonymousClass1(this), filter, null, this.mService.mHandler);
        return;
    }

    void handleUserSwitchedLocked() {
        this.mProcessList.forEachLruProcessesLOSP(false, new OomAdjuster$$ExternalSyntheticLambda2(this));
    }

    private void updateKeepWarmIfNecessaryForProcessLocked(ProcessRecord app) {
        ArraySet<ComponentName> warmServices = this.mService.mConstants.KEEP_WARMING_SERVICES;
        boolean includeWarmPkg = false;
        PackageList pkgList = app.getPkgList();
        int j = warmServices.size() - 1;
    L3:
        if (j < 0) goto L8;
        if (pkgList.containsKey(warmServices.valueAt(j).getPackageName()) == true) goto L6;
        j = j - 1;
        goto L3
    L6:
        includeWarmPkg = true;
    L8:
        if (includeWarmPkg == true) goto L10;
        return;
    L10:
        ProcessServiceRecord psr = app.mServices;
        int j2 = psr.numberOfRunningServices() - 1;
    L11:
        if (j2 < 0) goto L14;
        psr.getRunningServiceAt(j2).updateKeepWarmLocked();
        j2 = j2 - 1;
        goto L11
    }

    void updateOomAdjLocked(int oomAdjReason) {
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        updateOomAdjLSP(oomAdjReason);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    private void updateOomAdjLSP(int oomAdjReason) {
        if (checkAndEnqueueOomAdjTargetLocked(null) == false) goto L12;
        return;
    L12:
        this.mOomAdjUpdateOngoing = true;     // Catch: Throwable -> L9
        performUpdateOomAdjLSP(oomAdjReason);     // Catch: Throwable -> L9
        this.mOomAdjUpdateOngoing = false;
        updateOomAdjPendingTargetsLocked(oomAdjReason);
        return;
    L9:
        th = move-exception;
        this.mOomAdjUpdateOngoing = false;
        updateOomAdjPendingTargetsLocked(oomAdjReason);
        throw th;
    }

    protected void performUpdateOomAdjLSP(int oomAdjReason) {
        ProcessRecord topApp = this.mService.getTopApp();
        this.mProcessStateCurTop = this.mService.mAtmInternal.getTopProcessState();
        this.mPendingProcessSet.clear();
        AppProfiler r0 = this.mService.mAppProfiler;
        this.mService.mAppProfiler.mHasHomeProcess = false;
        r0.mHasPreviousProcess = false;
        updateOomAdjInnerLSP(oomAdjReason, topApp, null, null, true, true);
    }

    boolean updateOomAdjLocked(ProcessRecord app, int oomAdjReason) {
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        boolean r1 = updateOomAdjLSP(app, oomAdjReason);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return r1;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    private boolean updateOomAdjLSP(ProcessRecord app, int oomAdjReason) {
        if (app != null) goto L5;
    L17:
        updateOomAdjLSP(oomAdjReason);
        return true;
    L5:
        if (this.mConstants.OOMADJ_UPDATE_QUICK == false) goto L17;
        if (checkAndEnqueueOomAdjTargetLocked(app) == false) goto L19;
        return true;
    L19:
        this.mOomAdjUpdateOngoing = true;     // Catch: Throwable -> L14
        boolean r0 = performUpdateOomAdjLSP(app, oomAdjReason);     // Catch: Throwable -> L14
        this.mOomAdjUpdateOngoing = false;
        updateOomAdjPendingTargetsLocked(oomAdjReason);
        return r0;
    L14:
        th = move-exception;
        this.mOomAdjUpdateOngoing = false;
        updateOomAdjPendingTargetsLocked(oomAdjReason);
        throw th;
    }

    protected boolean performUpdateOomAdjLSP(ProcessRecord app, int oomAdjReason) {
        ProcessRecord topApp = this.mService.getTopApp();
        this.mLastReason = oomAdjReason;
        Trace.traceBegin(64, oomAdjReasonToString(oomAdjReason));
        ProcessStateRecord state = app.mState;
        ArrayList<ProcessRecord> processes = this.mTmpProcessList;
        ActiveUids uids = this.mTmpUidRecords;
        this.mPendingProcessSet.add(app);
        this.mProcessStateCurTop = enqueuePendingTopAppIfNecessaryLSP();
        boolean containsCycle = collectReachableProcessesLocked(this.mPendingProcessSet, processes, uids);
        this.mPendingProcessSet.clear();
        int size = processes.size();
        if (size <= 0) goto L6;
        updateOomAdjInnerLSP(oomAdjReason, topApp, processes, uids, containsCycle, false);
    L8:
        this.mTmpProcessList.clear();
        this.mService.clearPendingTopAppLocked();
        Trace.traceEnd(64);
        return true;
    L6:
        if (state.getCurRawAdj() != 1001) goto L8;
        processes.add(app);
        applyLruAdjust(processes);
        applyOomAdjLSP(app, false, this.mInjector.getUptimeMillis(), this.mInjector.getElapsedRealtimeMillis(), oomAdjReason);
        goto L8
    }

    protected int enqueuePendingTopAppIfNecessaryLSP() {
        int prevTopProcessState = this.mService.mAtmInternal.getTopProcessState();
        this.mService.enqueuePendingTopAppIfNecessaryLocked();
        int topProcessState = this.mService.mAtmInternal.getTopProcessState();
        if (prevTopProcessState == topProcessState) goto L5;
        this.mService.enqueuePendingTopAppIfNecessaryLocked();
    L5:
        return topProcessState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    protected boolean collectReachableProcessesLocked(ArraySet<ProcessRecord> r23, ArrayList<ProcessRecord> r24, ActiveUids r25) {
        OomAdjuster r0 = this;
        ArrayDeque<ProcessRecord> r2 = r0.mTmpQueue;
        r2.clear();
        r24.clear();
        int r3 = 0;
        int r4 = r23.size();
    L3:
        boolean r5 = true;
        if (r3 >= r4) goto L6;
        ProcessRecord r7 = r23.valueAt(r3);
        r7.mState.setReachable(true);
        r2.offer(r7);
        r3 = r3 + 1;
        goto L3
    L6:
        r25.clear();
        boolean r6 = false;
        ProcessRecord r8 = r2.poll();
    L7:
        if (r8 == null) goto L89;
        r24.add(r8);
        UidRecord r9 = r8.getUidRecord();
        if (r9 == null) goto L12;
        r25.put(r9.getUid(), r9);
    L12:
        ProcessServiceRecord r10 = r8.mServices;
        int r11 = r10.numberOfConnections() - (r5 ? 1 : 0);
    L14:
        if (r11 < 0) goto L36;
        ConnectionRecord r13 = r10.getConnectionAt(r11);
        if (r13.hasFlag(2) == false) goto L18;
        ProcessRecord r14 = r13.binding.service.isolationHostProc;
    L19:
        if (r14 == null) goto L35;
        if (r14 == r8) goto L35;
        if (r14.mState.getMaxAdj() >= (-900)) goto L24;
    L26:
        r6 = r6 | r14.mState.isReachable();
        if (r14.mState.isReachable() == true) goto L35;
        if (r13.hasFlag(32) == true) goto L32;
    L34:
        r2.offer(r14);
        r14.mState.setReachable(r5);
        goto L35
    L32:
        if (r13.notHasFlag(134217856) == false) goto L34;
    L24:
        if (r14.mState.getMaxAdj() >= 0) goto L26;
    L35:
        r11 = r11 - 1;
        goto L14
    L18:
        r14 = r13.binding.service.app;
        goto L19
    L36:
        ProcessProviderRecord r12 = r8.mProviders;
        int r15 = r12.numberOfProviderConnections() - (r5 ? 1 : 0);
    L37:
        if (r15 < 0) goto L51;
        ProcessRecord r16 = r12.getProviderConnectionAt(r15).provider.proc;
        if (r16 == null) goto L50;
        if (r16 == r8) goto L50;
        if (r16.mState.getMaxAdj() >= (-900)) goto L44;
    L46:
        r6 = r6 | r16.mState.isReachable();
        if (r16.mState.isReachable() == true) goto L50;
        r2.offer(r16);
        r16.mState.setReachable(r5);
        goto L50
    L44:
        if (r16.mState.getMaxAdj() >= 0) goto L46;
    L50:
        r15 = r15 - 1;
        goto L37
    L51:
        List<ProcessRecord> r17 = r0.mProcessList.getSdkSandboxProcessesForAppLocked(r8.uid);
        if (r17 == null) goto L54;
        int r18 = r17.size();
    L55:
        int r19 = r18 - 1;
    L56:
        if (r19 < 0) goto L63;
        ProcessRecord r110 = r17.get(r19);
        r6 = r6 | r110.mState.isReachable();
        if (r110.mState.isReachable() == true) goto L61;
        r2.offer(r110);
        r110.mState.setReachable(r5);
    L61:
        r19 = r19 - 1;
        goto L56
    L63:
        if (r8.isSdkSandbox == false) goto L88;
        int r111 = r10.numberOfRunningServices() - (r5 ? 1 : 0);
    L65:
        if (r111 < 0) goto L88;
        ArrayMap<IBinder, ArrayList<ConnectionRecord>> r112 = r10.getRunningServiceAt(r111).getConnections();
        int r113 = r112.size() - 1;
        boolean r114 = r5 ? 1 : 0;
        int r20 = r113;
    L67:
        if (r20 < 0) goto L85;
        ArrayList<ConnectionRecord> r1 = r112.valueAt(r20);
        boolean r115 = r6;
        int r21 = r1.size() - 1;
    L69:
        if (r21 < 0) goto L84;
        ArrayList<ConnectionRecord> r116 = r1;
        int r117 = r21;
        ProcessRecord r22 = r1.get(r21).binding.attributedClient;
        if (r22 == null) goto L82;
        if (r22 == r8) goto L82;
        ProcessRecord r26 = r8;
        if (r22.mState.getMaxAdj() < (-900)) goto L79;
        if (r22.mState.getMaxAdj() >= 0) goto L79;
        boolean r27 = r114 ? 1 : 0;
    L83:
        r21 = r117 - 1;
        r114 = r27;
        r1 = r116;
        r8 = r26;
    L79:
        if (r22.mState.isReachable() == false) goto L81;
        r27 = r114 ? 1 : 0;
        goto L83
    L81:
        r2.offer(r22);
        ProcessStateRecord r28 = r22.mState;
        r27 = r114 ? 1 : 0;
        r28.setReachable(r27);
    L82:
        r26 = r8;
        r27 = r114 ? 1 : 0;
        goto L83
    L84:
        Object[] r118 = r114 ? 1 : 0;
        r20 = r20 - 1;
        r6 = r115;
        r8 = r8;
        goto L67
    L85:
        r111 = r111 - 1;
        r5 = (r114 ? 1 : 0) == true ? 1 : 0;
        r8 = r8;
    L88:
        ProcessRecord r29 = r2.poll();
        r5 = r5 ? 1 : 0;
        r6 = r6;
        r8 = r29;
        r0 = this;
        goto L7
    L54:
        r18 = 0;
        goto L55
    L89:
        int r30 = r24.size();
        if (r30 <= 0) goto L94;
        int r31 = 0;
        int r32 = r30 - 1;
    L92:
        if (r31 >= r32) goto L94;
        ProcessRecord r33 = r24.get(r31);
        ProcessRecord r34 = r24.get(r32);
        r33.mState.setReachable(false);
        r34.mState.setReachable(false);
        r24.set(r31, r34);
        r24.set(r32, r33);
        r31 = r31 + 1;
        r32 = r32 - 1;
    L94:
        return r6;
    }

    void enqueueOomAdjTargetLocked(ProcessRecord app) {
        if (app != null) goto L4;
        return;
    L4:
        if (app.mState.getMaxAdj() <= 0) goto L8;
        this.mPendingProcessSet.add(app);
        return;
    }

    void removeOomAdjTargetLocked(ProcessRecord app, boolean procDied) {
        if (app == null) goto L7;
        this.mPendingProcessSet.remove(app);
        if (procDied == false) goto L8;
        PlatformCompatCache.getInstance().invalidate(app.info);
        return;
    L8:
        return;
    }

    private boolean checkAndEnqueueOomAdjTargetLocked(ProcessRecord app) {
        if (this.mOomAdjUpdateOngoing == true) goto L7;
        return false;
    L7:
        if (app == null) goto L9;
        this.mPendingProcessSet.add(app);
    L10:
        return true;
    L9:
        this.mPendingFullOomAdjUpdate = true;
        goto L10
    }

    void updateOomAdjPendingTargetsLocked(int oomAdjReason) {
        if (this.mPendingFullOomAdjUpdate == false) goto L7;
        this.mPendingFullOomAdjUpdate = false;
        this.mPendingProcessSet.clear();
        updateOomAdjLocked(oomAdjReason);
        return;
    L7:
        if (this.mPendingProcessSet.isEmpty() == false) goto L10;
        return;
    L10:
        if (this.mOomAdjUpdateOngoing == false) goto L19;
        return;
    L19:
        this.mOomAdjUpdateOngoing = true;     // Catch: Throwable -> L16
        performUpdateOomAdjPendingTargetsLocked(oomAdjReason);     // Catch: Throwable -> L16
        this.mOomAdjUpdateOngoing = false;
        updateOomAdjPendingTargetsLocked(oomAdjReason);
        return;
    L16:
        th = move-exception;
        this.mOomAdjUpdateOngoing = false;
        updateOomAdjPendingTargetsLocked(oomAdjReason);
        throw th;
    }

    void updateOomAdjFollowUpTargetsLocked() {
        long now = this.mInjector.getUptimeMillis();
        long nextFollowUpUptimeMs = Long.MAX_VALUE;
        this.mNextFollowUpUpdateUptimeMs = Long.MAX_VALUE;
        int i = this.mFollowUpUpdateSet.size() - 1;
    L3:
        if (i < 0) goto L18;
        ProcessRecord proc = (ProcessRecord) this.mFollowUpUpdateSet.valueAtUnchecked(i);
        long followUpUptimeMs = proc.mState.getFollowupUpdateUptimeMs();
        if (proc.isKilled() == false) goto L8;
        this.mFollowUpUpdateSet.removeAt(i);
    L16:
        i = i - 1;
        goto L3
    L8:
        if (followUpUptimeMs > now) goto L11;
        this.mPendingProcessSet.add(proc);
        proc.mState.setFollowupUpdateUptimeMs(Long.MAX_VALUE);
        this.mFollowUpUpdateSet.removeAt(i);
        goto L16
    L11:
        if (followUpUptimeMs >= nextFollowUpUptimeMs) goto L14;
        nextFollowUpUptimeMs = followUpUptimeMs;
        goto L16
    L14:
        if (followUpUptimeMs != Long.MAX_VALUE) goto L16;
        this.mFollowUpUpdateSet.removeAt(i);
        goto L16
    L18:
        if (nextFollowUpUptimeMs == Long.MAX_VALUE) goto L20;
        scheduleFollowUpOomAdjusterUpdateLocked(nextFollowUpUptimeMs, now);
    L20:
        updateOomAdjPendingTargetsLocked(23);
    }

    protected void performUpdateOomAdjPendingTargetsLocked(int oomAdjReason) {
        ProcessRecord topApp = this.mService.getTopApp();
        this.mLastReason = oomAdjReason;
        Trace.traceBegin(64, oomAdjReasonToString(oomAdjReason));
        this.mProcessStateCurTop = enqueuePendingTopAppIfNecessaryLSP();
        ArrayList<ProcessRecord> processes = this.mTmpProcessList;
        ActiveUids uids = this.mTmpUidRecords;
        collectReachableProcessesLocked(this.mPendingProcessSet, processes, uids);
        this.mPendingProcessSet.clear();
        ActivityManagerGlobalLock r10 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r10);
        updateOomAdjInnerLSP(oomAdjReason, topApp, processes, uids, true, false);     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        processes.clear();
        this.mService.clearPendingTopAppLocked();
        Trace.traceEnd(64);
        return;
    L9:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    private void updateOomAdjInnerLSP(int oomAdjReason, ProcessRecord topApp, ArrayList<ProcessRecord> processes, ActiveUids uids, boolean potentialCycles, boolean startProfiling) {
        int r9 = oomAdjReason;
        if (processes != null) goto L5;
        boolean fullUpdate = true;
    L6:
        if (fullUpdate == false) goto L8;
        ArrayList<ProcessRecord> r1 = this.mProcessList.getLruProcessesLOSP();
    L9:
        ArrayList<ProcessRecord> activeProcesses = r1;
        if (uids != null) goto L15;
        int numUids = this.mActiveUids.size();
        ActiveUids activeUids = this.mTmpUidRecords;
        activeUids.clear();
        int i = 0;
    L12:
        if (i >= numUids) goto L14;
        UidRecord uidRec = this.mActiveUids.valueAt(i);
        activeUids.put(uidRec.getUid(), uidRec);
        i = i + 1;
        goto L12
    L14:
        ActiveUids activeUids2 = activeUids;
    L16:
        this.mLastReason = r9;
        if (startProfiling == false) goto L19;
        Trace.traceBegin(64, oomAdjReasonToString(r9));
    L19:
        long now = this.mInjector.getUptimeMillis();
        long nowElapsed = this.mInjector.getElapsedRealtimeMillis();
        long oldTime = now - this.mConstants.mMaxEmptyTimeMillis;
        int numProc = activeProcesses.size();
        this.mAdjSeq++;
        if (fullUpdate == false) goto L22;
        this.mNewNumServiceProcs = 0;
        this.mNewNumAServiceProcs = 0;
    L22:
        int countBService = 0;
        this.mOomAdjusterOptEx.setmNumCachedProcs(0);
        resetUidRecordsLsp(activeUids2);
        if (fullUpdate == true) goto L27;
        if (potentialCycles == true) goto L27;
        boolean computeClients = false;
    L28:
        SysOptBridge.getFactory().getFreezeController().clearImportantUids();
        long totalVisibleMem = 0;
        if ((now - SysOptBridge.getFactory().getActivityManager(this.mService).getmLastKillAppSetTime()) <= SysOptBridge.getFactory().getActivityManager(this.mService).getmKillAppSetMinTime()) goto L31;
        boolean r2 = true;
    L32:
        boolean isTimeToKill = r2;
        if (SysOptBridge.getFactory().getActivityManager(this.mService).getmEnableMemAppSetKill() == false) goto L36;
        if (isTimeToKill == false) goto L36;
        boolean r3 = true;
    L37:
        boolean enableMemkill = r3;
        if (enableMemkill == false) goto L40;
        SysOptBridge.getFactory().getActivityManager(this.mService).getmVisebleAppsSet().clear();
    L40:
        if (isTimeToKill == false) goto L42;
        SysOptBridge.getFactory().getActivityManager(this.mService).getmBServiceAppsSet().clear();
    L42:
        int i2 = numProc - 1;
    L43:
        if (i2 < 0) goto L48;
        int i3 = i2;
        ProcessStateRecord state = activeProcesses.get(i2).mState;
        state.setReachable(false);
        int numProc2 = numProc;
        if (state.getAdjSeq() == this.mAdjSeq) goto L47;
        state.setContainsCycle(false);
        state.setCurRawProcState(19);
        state.setCurRawAdj(1001);
        state.setSetCapability(0);
        state.resetCachedInfo();
        state.setCurBoundByNonBgRestrictedApp(false);
    L47:
        i2 = i3 - 1;
        numProc = numProc2;
        goto L43
    L48:
        int numProc3 = numProc;
        this.mProcessesInCycle.clear();
        int i4 = numProc3 - 1;
        int cachedMemSize = 0;
        boolean retryCycles = false;
        int countPersistentService = 0;
        long totalCachedMem = 0;
        int countVisible = 0;
        int countPersistent = 0;
        int countService = 0;
        int countForeground = 0;
        int countPerceptible = 0;
        int countCached = 0;
    L49:
        if (i4 < 0) goto L101;
        ProcessRecord app = activeProcesses.get(i4);
        ProcessStateRecord state2 = app.mState;
        if (app.isKilledByAm() == true) goto L99;
        if (app.getThread() == null) goto L55;
    L58:
        state2.setProcStateChanged(false);
        app.mOptRecord.setLastOomAdjChangeReason(r9);
        int cachedMemSize2 = cachedMemSize;
        isTimeToKill = isTimeToKill;
        enableMemkill = enableMemkill;
        activeUids2 = activeUids2;
        numProc3 = numProc3;
        int countBService2 = countBService;
        boolean computeClients2 = computeClients;
        i4 = i4;
        computeOomAdjLSP(app, 1001, topApp, fullUpdate, now, false, computeClients2, r9, true);
        fullUpdate = fullUpdate;
        computeClients = computeClients2;
        if (app.mState.getCurAdj() < 900) goto L65;
        countCached = countCached + 1;
        cachedMemSize = (int) (((long) cachedMemSize2) + app.mProfile.getLastPss());
        if (enableMemkill == false) goto L63;
        totalCachedMem = totalCachedMem + app.mProfile.getLastPss();
        countBService = countBService2;
    L97:
        boolean retryCycles2 = retryCycles | state2.containsCycle();
        state2.setCompletedAdjSeq(this.mAdjSeq);
        retryCycles = retryCycles2;
    L100:
        i4 = i4 - 1;
        r9 = oomAdjReason;
        numProc3 = numProc3;
        enableMemkill = enableMemkill;
        activeUids2 = activeUids2;
        isTimeToKill = isTimeToKill;
        fullUpdate = fullUpdate;
        computeClients = computeClients;
        goto L49
    L63:
        countBService = countBService2;
        goto L97
    L65:
        if (app.mState.getCurAdj() < 800) goto L73;
        countBService = countBService2 + 1;
        if (isTimeToKill == true) goto L69;
    L71:
        cachedMemSize = cachedMemSize2;
        goto L97
    L69:
        if (app.uid == 1000) goto L71;
        SysOptBridge.getFactory().getActivityManager(this.mService).getmBServiceAppsSet().add(Integer.valueOf(app.uid));
        goto L71
    L73:
        if (app.mState.getCurAdj() < 500) goto L76;
        countService = countService + 1;
        cachedMemSize = cachedMemSize2;
        countBService = countBService2;
        goto L97
    L76:
        if (app.mState.getCurAdj() < 200) goto L79;
        countPerceptible = countPerceptible + 1;
        cachedMemSize = cachedMemSize2;
        countBService = countBService2;
        goto L97
    L79:
        if (app.mState.getCurAdj() < 100) goto L88;
        countVisible = countVisible + 1;
        if (enableMemkill == false) goto L86;
        totalVisibleMem = totalVisibleMem + app.mProfile.getLastPss();
        if (app.uid == 1000) goto L85;
        SysOptBridge.getFactory().getActivityManager(this.mService).getmBServiceAppsSet().add(Integer.valueOf(app.uid));
    L85:
        cachedMemSize = cachedMemSize2;
        countBService = countBService2;
        goto L97
    L86:
        cachedMemSize = cachedMemSize2;
        countBService = countBService2;
        goto L97
    L88:
        if (app.mState.getCurAdj() < 0) goto L91;
        countForeground = countForeground + 1;
        cachedMemSize = cachedMemSize2;
        countBService = countBService2;
        goto L97
    L91:
        if (app.mState.getCurAdj() < (-700)) goto L94;
        countPersistentService = countPersistentService + 1;
        cachedMemSize = cachedMemSize2;
        countBService = countBService2;
        goto L97
    L94:
        if (app.mState.getCurAdj() < (-800)) goto L96;
        countPersistent = countPersistent + 1;
        cachedMemSize = cachedMemSize2;
        countBService = countBService2;
        goto L97
    L96:
        cachedMemSize = cachedMemSize2;
        countBService = countBService2;
        goto L97
    L55:
        if (app.getSmtEx().inFreezeStat() == true) goto L58;
    L99:
        cachedMemSize = cachedMemSize;
        countBService = countBService;
        goto L100
    L101:
        boolean isTimeToKill2 = isTimeToKill;
        boolean enableMemkill2 = enableMemkill;
        ActiveUids activeUids3 = activeUids2;
        boolean computeClients3 = computeClients;
        int numProc4 = numProc3;
        int countBService3 = countBService;
        if (this.mCacheOomRanker.useOomReranking() == false) goto L104;
        this.mCacheOomRanker.reRankLruCachedAppsLSP(this.mProcessList.getLruProcessesLSP(), this.mProcessList.getLruProcessServiceStartLOSP());
    L104:
        if (computeClients3 == false) goto L140;
        int i5 = 0;
    L106:
        if (retryCycles == false) goto L140;
        if (i5 >= 10) goto L140;
        int cycleCount = i5 + 1;
        int i6 = 0;
    L110:
        if (i6 >= numProc4) goto L121;
        ProcessRecord app2 = activeProcesses.get(i6);
        ProcessStateRecord state3 = app2.mState;
        if (app2.isKilledByAm() == true) goto L120;
        if (app2.getThread() != null) goto L118;
        if (app2.getSmtEx().inFreezeStat() == false) goto L120;
    L118:
        if (state3.containsCycle() == false) goto L120;
        state3.decAdjSeq();
        state3.decCompletedAdjSeq();
    L120:
        i6 = i6 + 1;
        goto L110
    L121:
        retryCycles = false;
        int i7 = 0;
    L122:
        if (i7 >= numProc4) goto L139;
        ProcessRecord app3 = activeProcesses.get(i7);
        ProcessStateRecord state4 = app3.mState;
        if (app3.isKilledByAm() == false) goto L126;
        int i8 = i7;
    L138:
        i7 = i8 + 1;
        goto L122
    L126:
        if (app3.getThread() != null) goto L132;
        if (app3.getSmtEx().inFreezeStat() == true) goto L132;
        i8 = i7;
    L132:
        if (state4.containsCycle() == false) goto L136;
        i8 = i7;
        if (computeOomAdjLSP(app3, 1001, topApp, true, now, true, true, oomAdjReason, true) == false) goto L138;
        retryCycles = true;
        goto L138
    L136:
        i8 = i7;
        goto L138
    L139:
        i5 = cycleCount;
    L140:
        this.mProcessesInCycle.clear();
        applyLruAdjust(this.mProcessList.getLruProcessesLOSP());
        postUpdateOomAdjInnerLSP(oomAdjReason, activeUids3, now, nowElapsed, oldTime, true);
        SysOptBridge.getFactory().getFreezeController().updateLastImportantUidsIfNeeded();
        if (enableMemkill2 == false) goto L154;
        long totalVisibleMem2 = totalVisibleMem / DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES;
        long totalCachedMem2 = totalCachedMem / DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES;
        if (totalVisibleMem2 > SysOptBridge.getFactory().getActivityManager(this.mService).getmMaxSizeVisibleMemory()) goto L145;
        String r4 = TAG;
    L155:
        if (isTimeToKill2 == true) goto L157;
    L159:
        SysOptBridge.getFactory().getActivityManager(this.mService).getmUidCpuRunner().cleanBadBgApps(this.mService.mHandler);
        if (startProfiling == false) goto L183;
        Trace.traceEnd(64);
        return;
    L183:
        return;
    L157:
        if (countBService3 <= SysOptBridge.getFactory().getActivityManager(this.mService).getmMaxBServiceCount()) goto L159;
        Slog.i(r4, "clean B Service app, countBService: " + countBService3);
        SysOptBridge.getFactory().getActivityManager(this.mService).setmLastKillAppSetTime(now);
        Message msg = this.mService.mHandler.obtainMessage(2004);
        msg.arg1 = 1;
        msg.arg2 = SysOptBridge.getFactory().getActivityManager(this.mService).getKILL_B_SERVICE_APP_SET();
        this.mService.mHandler.sendMessage(msg);
        goto L159
    L145:
        if (totalCachedMem2 >= SysOptBridge.getFactory().getActivityManager(this.mService).getmMinSizeCachedMemory()) goto L151;
        r4 = TAG;
        Slog.i(r4, "clean visible app, totalVisibleMem =  " + totalVisibleMem2 + " totalCachedMem= " + totalCachedMem2);
        SysOptBridge.getFactory().getActivityManager(this.mService).setmLastKillAppSetTime(now);
        if (totalVisibleMem2 <= (SysOptBridge.getFactory().getActivityManager(this.mService).getmMaxSizeVisibleMemory() * 2)) goto L149;
        int killNum = 2;
    L150:
        Message msg2 = this.mService.mHandler.obtainMessage(2004);
        msg2.arg1 = killNum;
        msg2.arg2 = SysOptBridge.getFactory().getActivityManager(this.mService).getKILL_VISIBLE_APP_SET();
        this.mService.mHandler.sendMessage(msg2);
        goto L155
    L149:
        killNum = 1;
        goto L150
    L151:
        r4 = TAG;
        goto L155
    L154:
        r4 = TAG;
    L36:
        r3 = false;
        goto L37
    L31:
        r2 = false;
    L27:
        computeClients = true;
        goto L28
    L15:
        activeUids2 = uids;
        goto L16
    L8:
        r1 = processes;
        goto L9
    L5:
        fullUpdate = false;
        goto L6
    }

    private void resetUidRecordsLsp(ActiveUids activeUids) {
        int i = activeUids.size() - 1;
    L3:
        if (i < 0) goto L9;
        UidRecord uidRec = activeUids.valueAt(i);
        if (ActivityManagerDebugConfig.DEBUG_UID_OBSERVERS == false) goto L7;
        Slog.i("ActivityManager", "Starting update of " + uidRec);
    L7:
        uidRec.reset();
        i = i - 1;
        goto L3
    }

    protected void postUpdateOomAdjInnerLSP(int oomAdjReason, ActiveUids activeUids, long now, long nowElapsed, long oldTime, boolean doingAll) {
        this.mNumNonCachedProcs = 0;
        this.mNumCachedHiddenProcs = 0;
        updateAndTrimProcessLSP(now, nowElapsed, oldTime, activeUids, oomAdjReason, doingAll);
        this.mNumServiceProcs = this.mNewNumServiceProcs;
        if (this.mService.mAlwaysFinishActivities == false) goto L5;
        this.mService.mAtmInternal.scheduleDestroyAllActivities("always-finish");
    L5:
        updateUidsLSP(activeUids, nowElapsed);
        Object r2 = this.mService.mProcessStats.mLock;
        monitor-enter(r2);
        long nowUptime = this.mInjector.getUptimeMillis();     // Catch: Throwable -> L10
        if (this.mService.mProcessStats.shouldWriteNowLocked(nowUptime) == false) goto L12;
        this.mService.mHandler.post(new ActivityManagerService.ProcStatsRunnable(this.mService, this.mService.mProcessStats));     // Catch: Throwable -> L10
    L12:
        this.mService.mProcessStats.updateTrackingAssociationsLocked(this.mAdjSeq, nowUptime);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == false) goto L22;
        long duration = this.mInjector.getUptimeMillis() - now;
        Slog.d("ActivityManager", "Did OOM ADJ in " + duration + "ms");
        return;
    L22:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    protected void applyLruAdjust(ArrayList<ProcessRecord> lruList) {
        ArrayList<ProcessRecord> r1 = lruList;
        int numLru = r1.size();
        int nextPreviousAppAdj = 700;
        int r5 = 1001;
        int r6 = 700;
        if (this.mConstants.USE_TIERED_CACHED_ADJ == false) goto L43;
        long now = this.mInjector.getUptimeMillis();
        int uiTargetAdj = 10;
        int uiTierMaxAdj = this.mConstants.TIERED_CACHED_ADJ_UI_TIER_SIZE + 10;
        int i = numLru - 1;
    L5:
        if (i < 0) goto L130;
        ProcessRecord app = r1.get(i);
        ProcessStateRecord state = app.mState;
        ProcessCachedOptimizerRecord opt = app.mOptRecord;
        int curAdj = state.getCurAdj();
        if (r6 > curAdj) goto L12;
        if (curAdj > ProcessList.PREVIOUS_APP_MAX_ADJ) goto L12;
        state.setCurAdj(nextPreviousAppAdj);
        nextPreviousAppAdj = Math.min(nextPreviousAppAdj + 1, ProcessList.PREVIOUS_APP_MAX_ADJ);
        numLru = numLru;
    L41:
        i = i - 1;
        numLru = numLru;
        r5 = 1001;
        r6 = 700;
    L12:
        if (app.isKilledByAm() == true) goto L40;
        if (app.getThread() == null) goto L40;
        if (curAdj < r5) goto L18;
    L22:
        ProcessServiceRecord psr = app.mServices;
        if (opt == null) goto L28;
        if (opt.isFreezeExempt() == false) goto L28;
        int targetAdj = 900 + 0;
        numLru = numLru;
        int nextPreviousAppAdj2 = nextPreviousAppAdj;
        int numLru2 = targetAdj;
    L38:
        state.setCurRawAdj(numLru2);
        state.setCurAdj(psr.modifyRawOomAdj(numLru2));
        nextPreviousAppAdj = nextPreviousAppAdj2;
    L28:
        if (state.hasShownUi() == false) goto L32;
        if (uiTargetAdj >= uiTierMaxAdj) goto L32;
        int targetAdj2 = 900 + uiTargetAdj;
        numLru = numLru;
        nextPreviousAppAdj2 = nextPreviousAppAdj;
        uiTargetAdj = uiTargetAdj + 1;
        numLru2 = targetAdj2;
    L32:
        if (state.getSetAdj() < 900) goto L36;
        numLru = numLru;
        nextPreviousAppAdj2 = nextPreviousAppAdj;
        if ((state.getLastStateTime() + this.mConstants.TIERED_CACHED_ADJ_DECAY_TIME) >= now) goto L37;
        int targetAdj3 = 900 + (this.mConstants.TIERED_CACHED_ADJ_UI_TIER_SIZE + 40);
        numLru2 = targetAdj3;
    L37:
        int targetAdj4 = 900 + (this.mConstants.TIERED_CACHED_ADJ_UI_TIER_SIZE + 10);
        numLru2 = targetAdj4;
        goto L38
    L36:
        numLru = numLru;
        nextPreviousAppAdj2 = nextPreviousAppAdj;
        goto L37
    L18:
        if (state.hasShownUi() == false) goto L40;
        if (curAdj >= 900) goto L22;
    L40:
        nextPreviousAppAdj = nextPreviousAppAdj;
        goto L41
    L130:
        return;
    L43:
        int curCachedAdj = 900;
        int nextCachedAdj = 900 + 10;
        int curEmptyAdj = 905;
        int nextEmptyAdj = 905 + 10;
        int emptyProcessLimit = this.mConstants.CUR_MAX_EMPTY_PROCESSES;
        int cachedProcessLimit = this.mConstants.CUR_MAX_CACHED_PROCESSES - emptyProcessLimit;
        int numEmptyProcs = (numLru - this.mNumNonCachedProcs) - this.mNumCachedHiddenProcs;
        if (numEmptyProcs <= cachedProcessLimit) goto L47;
        numEmptyProcs = cachedProcessLimit;
    L47:
        if (this.mNumCachedHiddenProcs <= 0) goto L49;
        int r11 = (this.mNumCachedHiddenProcs + this.mNumSlots) - 1;
    L50:
        int cachedFactor = r11 / this.mNumSlots;
        if (cachedFactor >= 1) goto L53;
        cachedFactor = 1;
    L53:
        int emptyFactor = ((this.mNumSlots + numEmptyProcs) - 1) / this.mNumSlots;
        if (emptyFactor >= 1) goto L56;
        emptyFactor = 1;
    L56:
        int stepCached = -1;
        int stepEmpty = -1;
        int lastCachedGroup = 0;
        int lastCachedGroupImportance = 0;
        int lastCachedGroupImportance2 = 0;
        int curCachedImpAdj = 0;
        int emptyProcessLimit2 = numLru - 1;
    L57:
        if (emptyProcessLimit2 < 0) goto L120;
        ProcessRecord app2 = r1.get(emptyProcessLimit2);
        int cachedProcessLimit2 = cachedProcessLimit;
        ProcessStateRecord state2 = app2.mState;
        int numEmptyProcs2 = numEmptyProcs;
        int curAdj2 = state2.getCurAdj();
        int stepCached2 = stepCached;
        if (700 <= curAdj2) goto L61;
    L63:
        int nextPreviousAppAdj3 = nextPreviousAppAdj;
        if (app2.isKilledByAm() == true) goto L117;
        if (app2.getThread() != null) goto L72;
        if (app2.getSmtEx().inFreezeStat() == false) goto L117;
    L72:
        if (curAdj2 < 1001) goto L117;
        ProcessServiceRecord psr2 = app2.mServices;
        int stepEmpty2 = stepEmpty;
        cachedFactor = cachedFactor;
        switch(state2.getCurProcState()) {
            case 15: goto L88;
            case 16: goto L88;
            case 17: goto L88;
            case 18: goto L88;
            default: goto L75;
        };
    L75:
        if (curEmptyAdj == nextEmptyAdj) goto L82;
        int stepEmpty3 = stepEmpty2 + 1;
        if (stepEmpty3 < emptyFactor) goto L83;
        stepEmpty3 = 0;
        int curEmptyAdj2 = nextEmptyAdj;
        nextEmptyAdj = nextEmptyAdj + 10;
        if (nextEmptyAdj <= 999) goto L81;
        nextEmptyAdj = 999;
        curEmptyAdj = curEmptyAdj2;
        goto L83
    L81:
        curEmptyAdj = curEmptyAdj2;
    L83:
        state2.setCurRawAdj(curEmptyAdj);
        int nextEmptyAdj2 = nextEmptyAdj;
        int nextEmptyAdj3 = psr2.modifyRawOomAdj(curEmptyAdj);
        state2.setCurAdj(nextEmptyAdj3);
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L87;
        Slog.d("ActivityManager", "Assigning empty LRU #" + emptyProcessLimit2 + " adj: " + state2.getCurAdj() + " (curEmptyAdj=" + curEmptyAdj + ")");
    L87:
        nextEmptyAdj = nextEmptyAdj2;
        stepCached = stepCached2;
        nextPreviousAppAdj = nextPreviousAppAdj3;
        stepEmpty = stepEmpty3;
    L118:
        emptyProcessLimit2 = emptyProcessLimit2 - 1;
        r1 = lruList;
        cachedProcessLimit = cachedProcessLimit2;
        numEmptyProcs = numEmptyProcs2;
        cachedFactor = cachedFactor;
        goto L57
    L82:
        stepEmpty3 = stepEmpty2;
        goto L83
    L88:
        boolean inGroup = false;
        int curEmptyAdj3 = curEmptyAdj;
        int connectionGroup = psr2.getConnectionGroup();
        if (connectionGroup == 0) goto L101;
        int nextEmptyAdj4 = nextEmptyAdj;
        int connectionImportance = psr2.getConnectionImportance();
        if (curCachedImpAdj != app2.uid) goto L100;
        if (lastCachedGroup != connectionGroup) goto L100;
        if (connectionImportance <= lastCachedGroupImportance) goto L99;
        lastCachedGroupImportance = connectionImportance;
        if (curCachedAdj >= nextCachedAdj) goto L99;
        if (curCachedAdj >= 999) goto L99;
        lastCachedGroupImportance2 = lastCachedGroupImportance2 + 1;
    L99:
        inGroup = true;
        int connectionImportance2 = curCachedImpAdj;
        int lastCachedGroupUid = lastCachedGroupImportance2;
    L102:
        if (inGroup == true) goto L110;
        if (curCachedAdj == nextCachedAdj) goto L110;
        int lastCachedGroupImportance3 = lastCachedGroupImportance;
        int lastCachedGroupImportance4 = stepCached2 + 1;
        lastCachedGroupUid = 0;
        cachedFactor = cachedFactor;
        if (lastCachedGroupImportance4 < cachedFactor) goto L109;
        curCachedAdj = nextCachedAdj;
        nextCachedAdj = nextCachedAdj + 10;
        stepCached2 = 0;
        if (nextCachedAdj <= 999) goto L111;
        nextCachedAdj = 999;
    L111:
        int lastCachedGroupImportance5 = curCachedAdj + lastCachedGroupUid;
        state2.setCurRawAdj(lastCachedGroupImportance5);
        state2.setCurAdj(psr2.modifyRawOomAdj(curCachedAdj + lastCachedGroupUid));
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L115;
        Slog.d("ActivityManager", "Assigning activity LRU #" + emptyProcessLimit2 + " adj: " + state2.getCurAdj() + " (curCachedAdj=" + curCachedAdj + " curCachedImpAdj=" + lastCachedGroupUid + ")");
    L115:
        lastCachedGroupImportance = lastCachedGroupImportance3;
        stepCached = stepCached2;
        nextPreviousAppAdj = nextPreviousAppAdj3;
        stepEmpty = stepEmpty2;
        curEmptyAdj = curEmptyAdj3;
        lastCachedGroupImportance2 = lastCachedGroupUid;
        curCachedImpAdj = connectionImportance2;
        nextEmptyAdj = nextEmptyAdj4;
        goto L118
    L109:
        stepCached2 = lastCachedGroupImportance4;
    L110:
        lastCachedGroupImportance3 = lastCachedGroupImportance;
        cachedFactor = cachedFactor;
    L100:
        int lastCachedGroupUid2 = app2.uid;
        lastCachedGroup = connectionGroup;
        lastCachedGroupImportance = connectionImportance;
        connectionImportance2 = lastCachedGroupUid2;
        lastCachedGroupUid = lastCachedGroupImportance2;
        inGroup = false;
        goto L102
    L101:
        nextEmptyAdj4 = nextEmptyAdj;
        connectionImportance2 = curCachedImpAdj;
        lastCachedGroupUid = lastCachedGroupImportance2;
    L117:
        stepCached = stepCached2;
        nextPreviousAppAdj = nextPreviousAppAdj3;
        stepEmpty = stepEmpty;
        curEmptyAdj = curEmptyAdj;
        nextEmptyAdj = nextEmptyAdj;
        goto L118
    L61:
        if (curAdj2 > ProcessList.PREVIOUS_APP_MAX_ADJ) goto L63;
        state2.setCurAdj(nextPreviousAppAdj);
        nextPreviousAppAdj = Math.min(nextPreviousAppAdj + 1, ProcessList.PREVIOUS_APP_MAX_ADJ);
        cachedFactor = cachedFactor;
        stepCached = stepCached2;
        goto L118
    L120:
        return;
    L49:
        r11 = 1;
        goto L50
    }

    private static double getFreeSwapPercent() {
        return CachedAppOptimizer.getFreeSwapPercent();
    }

    private void updateAndTrimProcessLSP(long now, long nowElapsed, long oldTime, ActiveUids activeUids, int oomAdjReason, boolean doingAll) {
        ArrayList<ProcessRecord> lruList = this.mProcessList.getLruProcessesLOSP();
        int lastCachedGroup = lruList.size();
        boolean doKillExcessiveProcesses = shouldKillExcessiveProcesses(now);
        String r12 = TAG;
        if (doKillExcessiveProcesses == false) goto L5;
    L7:
        int r1 = Integer.MAX_VALUE;
        if (doKillExcessiveProcesses == false) goto L10;
        int r2 = this.mConstants.CUR_MAX_EMPTY_PROCESSES;
    L11:
        int emptyProcessLimit = r2;
        if (doKillExcessiveProcesses == false) goto L15;
        r1 = this.mConstants.CUR_MAX_CACHED_PROCESSES - emptyProcessLimit;
    L15:
        int cachedProcessLimit = r1;
        int lastCachedGroupUid = 0;
        ProcessRecord selectedAppRecord = null;
        boolean proactiveKillsEnabled = ActivityManagerConstants.PROACTIVE_KILLS_ENABLED;
        ArrayList<ProcessRecord> lruList2 = lruList;
        double lowSwapThresholdPercent = ActivityManagerConstants.LOW_SWAP_THRESHOLD_PERCENT;
        if (proactiveKillsEnabled == false) goto L18;
        double r21 = getFreeSwapPercent();
    L19:
        double freeSwapPercent = r21;
        int numCached = 0;
        int numEmpty = 0;
        int numTrimming = 0;
        int numCached2 = 0;
        int i = lastCachedGroup - 1;
        ProcessRecord lruCachedApp = null;
        int numCachedExtraGroup = 0;
        long serviceLastActivity = 0;
        int numCached3 = 0;
    L20:
        int lastCachedGroup2 = numCached3;
        int numLru = lastCachedGroupUid;
        double lowSwapThresholdPercent2 = lowSwapThresholdPercent;
        if (i < 0) goto L126;
        ArrayList<ProcessRecord> lruList3 = lruList2;
        ProcessRecord app = lruList3.get(i);
        long serviceLastActivity2 = serviceLastActivity;
        if (this.mEnableBServicePropagation == false) goto L50;
        if (app.mState.isServiceB() == false) goto L50;
        if (app.mState.getCurAdj() != 800) goto L50;
        int numBServices = numCached2 + 1;
        int s = app.mServices.numberOfRunningServices() - 1;
    L29:
        if (s < 0) goto L47;
        ServiceRecord sr = app.mServices.getRunningServiceAt(s);
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == false) goto L34;
        Slog.d(r12, "app.processName = " + app.processName + " serviceb = " + app.mState.isServiceB() + " s = " + s + " sr.lastActivity = " + sr.lastActivity + " packageName = " + sr.packageName + " processName = " + sr.processName);
    L34:
        int s2 = s;
        if ((SystemClock.uptimeMillis() - sr.lastActivity) >= this.mMinBServiceAgingTime) goto L40;
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == false) goto L45;
        Slog.d(r12, "Not aged enough!!!");
    L45:
        selectedAppRecord = selectedAppRecord;
    L46:
        s = s2 - 1;
        numBServices = numBServices;
        i = i;
        goto L29
    L40:
        if (serviceLastActivity2 != 0) goto L42;
        long serviceLastActivity3 = sr.lastActivity;
        serviceLastActivity2 = serviceLastActivity3;
        selectedAppRecord = app;
        goto L46
    L42:
        long serviceLastActivity4 = sr.lastActivity;
        if (serviceLastActivity4 >= serviceLastActivity2) goto L45;
        long serviceLastActivity5 = sr.lastActivity;
        serviceLastActivity2 = serviceLastActivity5;
        selectedAppRecord = app;
        goto L46
    L47:
        int numBServices2 = numBServices;
        i = i;
        ProcessRecord selectedAppRecord2 = selectedAppRecord;
        long serviceLastActivity6 = serviceLastActivity2;
    L52:
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == false) goto L55;
        if (selectedAppRecord2 == null) goto L55;
        Slog.d(r12, "Identified app.processName = " + selectedAppRecord2.processName + " app.pid = " + selectedAppRecord2.getPid());
    L55:
        ProcessStateRecord state = app.mState;
        if (app.isKilledByAm() == false) goto L58;
        selectedAppRecord2 = selectedAppRecord2;
        lruList3 = lruList3;
        r12 = r12;
        lastCachedGroup2 = lastCachedGroup2;
        lastCachedGroup = lastCachedGroup;
        numLru = numLru;
        doKillExcessiveProcesses = doKillExcessiveProcesses;
        numEmpty = numEmpty;
        i = i;
    L124:
        numCached3 = lastCachedGroup2;
    L125:
        lastCachedGroupUid = numLru;
        i = i - 1;
        numEmpty = numEmpty;
        lastCachedGroup = lastCachedGroup;
        numCached2 = numBServices2;
        doKillExcessiveProcesses = doKillExcessiveProcesses;
        lowSwapThresholdPercent = lowSwapThresholdPercent2;
        serviceLastActivity = serviceLastActivity6;
        lruList2 = lruList3;
        r12 = r12;
        selectedAppRecord = selectedAppRecord2;
        goto L20
    L58:
        if (app.getThread() != null) goto L64;
        if (app.getSmtEx().inFreezeStat() == true) goto L64;
        selectedAppRecord2 = selectedAppRecord2;
        lruList3 = lruList3;
        r12 = r12;
        lastCachedGroup2 = lastCachedGroup2;
        lastCachedGroup = lastCachedGroup;
        numLru = numLru;
        doKillExcessiveProcesses = doKillExcessiveProcesses;
        numEmpty = numEmpty;
        i = i;
    L64:
        if (state.getCompletedAdjSeq() != this.mAdjSeq) goto L66;
        ProcessRecord app2 = app;
        ProcessStateRecord state2 = state;
        int r13 = 13;
        applyOomAdjLSP(app2, doingAll, now, nowElapsed, oomAdjReason, true);
    L68:
        if (app2.isPendingFinishAttach() == false) goto L70;
        updateAppUidRecLSP(app2);
        goto L124
    L70:
        ProcessServiceRecord psr = app2.mServices;
        switch(state2.getCurProcState()) {
            case 16: goto L88;
            case 17: goto L88;
            case 18: goto L72;
            case 19: goto L74;
            default: goto L72;
        };
    L72:
        this.mNumNonCachedProcs++;
        ProcessRecord app3 = app2;
    L78:
        numCached3 = lastCachedGroup2;
        ProcessRecord app4 = app3;
    L103:
        if (app4.isolated == false) goto L110;
        if (psr.numberOfRunningServices() > 0) goto L110;
        if (app4.getIsolatedEntryPoint() != null) goto L110;
        app4.killLocked("isolated not needed", r13, 17, true);
    L118:
        if (state2.getCurProcState() < 14) goto L125;
        if (app4.isKilledByAm() == true) goto L125;
        numTrimming = numTrimming + 1;
    L110:
        if (app4.isSdkSandbox == true) goto L112;
    L116:
        updateAppUidRecLSP(app4);
        goto L118
    L112:
        if (psr.numberOfRunningServices() > 0) goto L116;
        if (app4.getActiveInstrumentation() != null) goto L116;
        app4.killLocked("sandbox not needed", r13, 28, true);
        goto L118
    L88:
        app4 = app2;
        this.mNumCachedHiddenProcs++;
        int numCached4 = numCached + 1;
        int connectionGroup = psr.getConnectionGroup();
        if (connectionGroup != 0) goto L91;
        int lastCachedGroupUid2 = 0;
        int lastCachedGroup3 = 0;
    L97:
        if ((numCached4 - numCachedExtraGroup) <= cachedProcessLimit) goto L99;
        app4.killLocked("cached #" + numCached4, "too many cached", 13, 2, true);
    L101:
        numCached = numCached4;
        numLru = lastCachedGroupUid2;
        numCached3 = lastCachedGroup3;
        goto L103
    L99:
        if (proactiveKillsEnabled == false) goto L101;
        lruCachedApp = app4;
        numCached = numCached4;
        numLru = lastCachedGroupUid2;
        numCached3 = lastCachedGroup3;
        goto L103
    L91:
        if (numLru != app4.info.uid) goto L94;
        if (lastCachedGroup2 != connectionGroup) goto L94;
        numCachedExtraGroup = numCachedExtraGroup + 1;
        lastCachedGroup3 = lastCachedGroup2;
        lastCachedGroupUid2 = numLru;
    L94:
        lastCachedGroupUid2 = app4.info.uid;
        lastCachedGroup3 = connectionGroup;
        goto L97
    L74:
        if (numEmpty <= this.mConstants.CUR_TRIM_EMPTY_PROCESSES) goto L81;
        if (app2.getLastActivityTime() >= oldTime) goto L81;
        app3 = app2;
        app3.killLocked("empty for " + ((now - app2.getLastActivityTime()) / 1000) + "s", "empty for too long", 13, 4, true);
    L81:
        int numEmpty2 = numEmpty + 1;
        if (numEmpty2 <= emptyProcessLimit) goto L84;
        app2.killLocked("empty #" + numEmpty2, "too many empty", 13, 3, true);
        app4 = app2;
    L87:
        numEmpty = numEmpty2;
        numCached3 = lastCachedGroup2;
        goto L103
    L84:
        app4 = app2;
        if (proactiveKillsEnabled == false) goto L87;
        lruCachedApp = app4;
        numEmpty = numEmpty2;
        numCached3 = lastCachedGroup2;
        goto L103
    L66:
        state2 = state;
        app2 = app;
        r13 = 13;
    L50:
        numBServices2 = numCached2;
        selectedAppRecord2 = selectedAppRecord;
        serviceLastActivity6 = serviceLastActivity2;
        goto L52
    L126:
        String r38 = r12;
        boolean doKillExcessiveProcesses2 = doKillExcessiveProcesses;
        int numEmpty3 = numEmpty;
        if (this.mProcsToOomAdj.isEmpty() == false) goto L129;
    L133:
        if (proactiveKillsEnabled == false) goto L141;
        if (doKillExcessiveProcesses2 == false) goto L141;
        if (freeSwapPercent >= lowSwapThresholdPercent2) goto L141;
        if (lruCachedApp == null) goto L141;
        if (freeSwapPercent >= this.mLastFreeSwapPercent) goto L141;
        lruCachedApp.killLocked("swap low and too many cached", 13, 2, true);
    L141:
        this.mLastFreeSwapPercent = freeSwapPercent;
        if (numCached2 <= this.mBServiceAppThreshold) goto L162;
        if (true != this.mService.mAppProfiler.allowLowerMemLevelLocked()) goto L162;
        if (selectedAppRecord == null) goto L162;
        if (this.mLazyLmkKillMainProc == false) goto L157;
        String packageName = selectedAppRecord.info.packageName;
        String processName = selectedAppRecord.processName;
        if (packageName.equals(processName) == false) goto L151;
        int numBServices3 = 1;
    L153:
        if (selectedAppRecord.info.isSystemApp() == false) goto L155;
        int isSystemApp = 1;
    L156:
        ProcessList.setOomAdjExt(selectedAppRecord.getPid(), selectedAppRecord.info.uid, 999, isSystemApp, numBServices3);
    L158:
        selectedAppRecord.mState.setSetAdj(selectedAppRecord.mState.getCurAdj());
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == false) goto L162;
        Slog.d(r38, "app.processName = " + selectedAppRecord.processName + " app.pid = " + selectedAppRecord.getPid() + " is moved to higher adj");
        goto L162
    L155:
        isSystemApp = 0;
        goto L156
    L151:
        numBServices3 = 0;
        goto L153
    L157:
        int numBServices4 = selectedAppRecord.getPid();
        ProcessList.setOomAdj(numBServices4, selectedAppRecord.info.uid, 999);
    L162:
        this.mService.mAppProfiler.updateLowMemStateLSP(numCached, numEmpty3, numTrimming, now);
        return;
    L129:
        if (this.mLazyLmkKillMainProc == false) goto L131;
        this.mInjector.batchSetOomAdjExt(this.mProcsToOomAdj);
    L132:
        this.mProcsToOomAdj.clear();
        goto L133
    L131:
        this.mInjector.batchSetOomAdj(this.mProcsToOomAdj);
        goto L132
    L18:
        r21 = 1.0d;
        goto L19
    L10:
        r2 = Integer.MAX_VALUE;
        goto L11
    L5:
        if (this.mNextNoKillDebugMessageTime >= now) goto L7;
        Slog.d(TAG, "Not killing cached processes");
        this.mNextNoKillDebugMessageTime = now + 5000;
        goto L7
    }

    protected void updateAppUidRecIfNecessaryLSP(ProcessRecord app) {
        if (app.isKilledByAm() == false) goto L5;
        return;
    L5:
        if (app.getThread() != null) goto L9;
        if (app.getSmtEx().inFreezeStat() == true) goto L9;
        return;
    L9:
        if (app.isolated == true) goto L11;
    L15:
        updateAppUidRecLSP(app);
        return;
    L11:
        if (app.mServices.numberOfRunningServices() > 0) goto L15;
        if (app.getIsolatedEntryPoint() != null) goto L15;
    }

    private void updateAppUidRecLSP(ProcessRecord app) {
        UidRecord uidRec = app.getUidRecord();
        if (uidRec == null) goto L17;
        ProcessStateRecord state = app.mState;
        uidRec.setEphemeral(app.info.isInstantApp());
        if (uidRec.getCurProcState() <= state.getCurProcState()) goto L8;
        uidRec.setCurProcState(state.getCurProcState());
    L8:
        if (SysOptBridge.getFactory().getApplicationFreezer().isEnable() == false) goto L13;
        if (uidRec.getSmtEx().curSchedGroup >= app.mState.getCurrentSchedulingGroup()) goto L13;
        uidRec.getSmtEx().curSchedGroup = app.mState.getCurrentSchedulingGroup();
        uidRec.getSmtEx().not3rdReason = app.processName + "|" + app.getSmtEx().not3rdReasonFlag;
    L13:
        if (app.mServices.hasForegroundServices() == false) goto L15;
        uidRec.setForegroundServices(true);
    L15:
        uidRec.setCurCapability(uidRec.getCurCapability() | state.getCurCapability());
        return;
    }

    protected void updateUidsLSP(ActiveUids activeUids, long nowElapsed) {
        this.mProcessList.incrementProcStateSeqAndNotifyAppsLOSP(activeUids);
        ArrayList<UidRecord> becameIdle = this.mTmpBecameIdle;
        becameIdle.clear();
        if (this.mService.mLocalPowerManager == null) goto L5;
        this.mService.mLocalPowerManager.startUidChanges();
    L5:
        int i = activeUids.size() - 1;
    L6:
        if (i < 0) goto L135;
        UidRecord uidRec = activeUids.valueAt(i);
        if (uidRec.getCurProcState() != 20) goto L10;
        uidRec = uidRec;
    L133:
        this.mService.mInternal.deletePendingTopUid(uidRec.getUid(), nowElapsed);
        i = i - 1;
        goto L6
    L10:
        if (uidRec.getSetProcState() == uidRec.getCurProcState()) goto L12;
    L24:
        int uidChange = 0;
        boolean shouldLog = this.mLogger.shouldLog(uidRec.getUid());
        if (ActivityManagerDebugConfig.DEBUG_UID_OBSERVERS == false) goto L27;
        Slog.i("ActivityManager", "Changes in " + uidRec + ": proc state from " + uidRec.getSetProcState() + " to " + uidRec.getCurProcState() + ", capability from " + uidRec.getSetCapability() + " to " + uidRec.getCurCapability() + ", allowlist from " + uidRec.isSetAllowListed() + " to " + uidRec.isCurAllowListed() + ", procAdjChanged: " + uidRec.getProcAdjChanged());
    L27:
        boolean isCached = false;
        if (ActivityManager.isProcStateBackground(uidRec.getCurProcState()) == false) goto L64;
        if (uidRec.isCurAllowListed() == true) goto L64;
        if (ActivityManager.isProcStateBackground(uidRec.getSetProcState()) == true) goto L34;
    L39:
        uidRec.setLastBackgroundTime(nowElapsed);
        if (shouldLog == false) goto L43;
        this.mLogger.logSetLastBackgroundTime(uidRec.getUid(), nowElapsed);
    L43:
        if (this.mService.mDeterministicUidIdle == false) goto L45;
    L48:
        if (shouldLog == false) goto L51;
        this.mLogger.logScheduleUidIdle1(uidRec.getUid(), this.mConstants.BACKGROUND_SETTLE_TIME);
    L51:
        this.mService.mHandler.sendEmptyMessageDelayed(58, this.mConstants.BACKGROUND_SETTLE_TIME);
    L53:
        if (uidRec.isIdle() == true) goto L55;
    L60:
        uidRec = uidRec;
    L70:
        if (uidRec.getSetProcState() <= 11) goto L72;
        boolean wasCached = true;
    L74:
        if (uidRec.getCurProcState() <= 11) goto L76;
        isCached = true;
    L76:
        if (wasCached == isCached) goto L78;
    L79:
        if (isCached == false) goto L81;
        int r9 = 8;
    L82:
        uidChange = uidChange | r9;
    L84:
        if (uidRec.getSetCapability() == uidRec.getCurCapability()) goto L87;
        uidChange = uidChange | 32;
    L87:
        if (uidRec.getSetProcState() == uidRec.getCurProcState()) goto L90;
        uidChange = uidChange | Integer.MIN_VALUE;
    L90:
        if (uidRec.getProcAdjChanged() == false) goto L93;
        uidChange = uidChange | 64;
    L93:
        if (SysOptBridge.getFactory().getApplicationFreezer().isEnable() == true) goto L95;
    L97:
        int oldProcState = uidRec.getSetProcState();
        int oldCapability = uidRec.getSetCapability();
        uidRec.setSetProcState(uidRec.getCurProcState());
        uidRec.setSetCapability(uidRec.getCurCapability());
        uidRec.setSetAllowListed(uidRec.isCurAllowListed());
        uidRec.setSetIdle(uidRec.isIdle());
        if (SysOptBridge.getFactory().getApplicationFreezer().isEnable() == false) goto L100;
        uidRec.getSmtEx().setSchedGroup = uidRec.getSmtEx().curSchedGroup;
    L100:
        uidRec.clearProcAdjChanged();
        if (shouldLog == false) goto L115;
        if (uidRec.getSetProcState() != oldProcState) goto L109;
        if (uidRec.getSetCapability() == oldCapability) goto L115;
    L109:
        if (uidRec.isSetAllowListed() == false) goto L111;
        int flags = 0 | 1;
        int flags2 = flags;
    L112:
        this.mLogger.logUidStateChanged(uidRec.getUid(), uidRec.getSetProcState(), oldProcState, uidRec.getSetCapability(), oldCapability, flags2);
        goto L115
    L111:
        flags2 = 0;
    L115:
        if ((uidChange & Integer.MIN_VALUE) == 0) goto L117;
    L118:
        this.mService.mAtmInternal.onUidProcStateChanged(uidRec.getUid(), uidRec.getSetProcState());
    L119:
        if (uidChange == 0) goto L122;
        this.mService.enqueueUidChangeLocked(uidRec, -1, uidChange);
    L122:
        if ((uidChange & Integer.MIN_VALUE) == 0) goto L124;
    L125:
        this.mService.noteUidProcessStateAndCapability(uidRec.getUid(), uidRec.getCurProcState(), uidRec.getCurCapability());
    L127:
        if ((uidChange & Integer.MIN_VALUE) == 0) goto L130;
        this.mService.noteUidProcessState(uidRec.getUid(), uidRec.getCurProcState());
    L130:
        if (uidRec.hasForegroundServices() == false) goto L133;
        this.mService.mServices.foregroundServiceProcStateChangedLocked(uidRec);
        goto L133
    L124:
        if ((uidChange & 32) == 0) goto L127;
    L117:
        if ((uidChange & 32) == 0) goto L119;
    L95:
        if (uidRec.getSmtEx().setSchedGroup == uidRec.getSmtEx().curSchedGroup) goto L97;
        uidChange = uidChange | 65536;
        goto L97
    L81:
        r9 = 16;
        goto L82
    L78:
        if (uidRec.getSetProcState() != 20) goto L84;
    L72:
        wasCached = false;
        goto L74
    L55:
        if (uidRec.isSetIdle() == true) goto L60;
        uidChange = 0 | 2;
        if (uidRec.getSetProcState() == 20) goto L59;
        uidRec = uidRec;
        becameIdle.add(uidRec);
        goto L70
    L59:
        uidRec = uidRec;
        goto L70
    L45:
        if (this.mService.mHandler.hasMessages(58) == false) goto L48;
        uidRec = uidRec;
        goto L53
    L34:
        if (uidRec.isSetAllowListed() == true) goto L39;
        if (uidRec.getLastBackgroundTime() == 0) goto L39;
        uidRec = uidRec;
    L64:
        if (uidRec.isIdle() == false) goto L66;
        uidChange = 0 | 4;
        EventLogTags.writeAmUidActive(uidRec.getUid());
        uidRec.setIdle(false);
    L66:
        uidRec.setLastBackgroundTime(0);
        uidRec.setLastIdleTime(0);
        if (shouldLog == false) goto L70;
        this.mLogger.logClearLastBackgroundTime(uidRec.getUid());
        goto L70
    L12:
        if (uidRec.getSetCapability() != uidRec.getCurCapability()) goto L24;
        if (uidRec.isSetAllowListed() != uidRec.isCurAllowListed()) goto L24;
        if (uidRec.getProcAdjChanged() == true) goto L24;
        if (SysOptBridge.getFactory().getApplicationFreezer().isEnable() == true) goto L20;
        uidRec = uidRec;
        goto L133
    L20:
        if (uidRec.getSmtEx().setSchedGroup != uidRec.getSmtEx().curSchedGroup) goto L24;
        uidRec = uidRec;
        goto L133
    L135:
        if (this.mService.mLocalPowerManager == null) goto L137;
        this.mService.mLocalPowerManager.finishUidChanges();
    L137:
        int size = becameIdle.size();
        if (size <= 0) goto L142;
        int i2 = size - 1;
    L140:
        if (i2 < 0) goto L150;
        this.mService.mServices.stopInBackgroundLocked(becameIdle.get(i2).getUid());
        i2 = i2 - 1;
        goto L140
    L150:
        return;
    }

    private boolean shouldKillExcessiveProcesses(long nowUptime) {
        long lastUserUnlockingUptime = this.mService.mUserController.getLastUserUnlockingUptime();
        if (lastUserUnlockingUptime == 0) goto L5;
        long noKillCachedProcessesPostBootCompletedDurationMillis = this.mConstants.mNoKillCachedProcessesPostBootCompletedDurationMillis;
        if ((lastUserUnlockingUptime + noKillCachedProcessesPostBootCompletedDurationMillis) <= nowUptime) goto L10;
        return false;
    L10:
        return true;
    L5:
        return !this.mConstants.mNoKillCachedProcessesUntilBootCompleted;
    }

    private boolean isDeviceFullyAwake() {
        if (this.mService.mWakefulness.get() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isScreenOnOrAnimatingLocked(ProcessStateRecord state) {
        if (isDeviceFullyAwake() == false) goto L5;
    L8:
        return true;
    L5:
        if (state.isRunningRemoteAnimation() == true) goto L8;
        return false;
    }

    private boolean isBackupProcess(ProcessRecord app) {
        BackupRecord backupTarget = this.mService.mBackupTargets.get(app.userId);
        if (backupTarget != null) goto L6;
        return false;
    L6:
        if (app != backupTarget.app) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean isLastMemoryLevelNormal() {
        return this.mService.mAppProfiler.isLastMemoryLevelNormal();
    }

    protected boolean computeOomAdjLSP(ProcessRecord app, int cachedAdj, ProcessRecord topApp, boolean doingAll, long now, boolean cycleReEval, boolean computeClients, int oomAdjReason, boolean couldRecurse) {
        OomAdjuster r0 = this;
        ProcessRecord r1 = app;
        ProcessRecord r6 = topApp;
        ProcessStateRecord state = r1.mState;
        if (couldRecurse == true) goto L5;
    L11:
        int prevAppAdj = getInitialAdj(app);
        int prevProcState = getInitialProcState(app);
        int prevCapability = getInitialCapability(app);
        r1.mState.setFollowupUpdateUptimeMs(Long.MAX_VALUE);
        if (r1.getThread() == null) goto L14;
    L17:
        state.setAdjTypeCode(0);
        state.setAdjSource(null);
        state.setAdjTarget(null);
        if (couldRecurse == false) goto L20;
        if (cycleReEval == false) goto L20;
    L27:
        int appUid = r1.info.uid;
        int logUid = r0.mService.mCurOomAdjUid;
        ProcessServiceRecord psr = r1.mServices;
        if (state.getMaxAdj() <= 0) goto L30;
        state.setSystemNoUi(false);
        int PROCESS_STATE_CUR_TOP = r0.mProcessStateCurTop;
        if (cycleReEval == false) goto L75;
        int capability = getInitialCapability(app);
    L76:
        boolean connectedWithTop = false;
        boolean connectedWithSystemServer = false;
        boolean hasVisibleActivities = false;
        if (r1 == r6) goto L79;
    L120:
        int PROCESS_STATE_CUR_TOP2 = PROCESS_STATE_CUR_TOP;
        prevAppAdj = prevAppAdj;
        prevProcState = prevProcState;
        prevCapability = prevCapability;
        int prevCapability2 = 5;
        if (state.isRunningRemoteAnimation() == false) goto L127;
        int adj = 100;
        int schedGroup = 3;
        state.setAdjType("running-remote-anim");
        int procState = PROCESS_STATE_CUR_TOP2;
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L125;
        if (logUid == appUid) goto L125;
    L119:
        int procState2 = procState;
        int adj2 = adj;
        int schedGroup2 = schedGroup;
        boolean hasVisibleActivities2 = hasVisibleActivities;
        if (r1 != r6) goto L164;
        boolean foregroundActivities = true;
    L165:
        if (foregroundActivities == false) goto L167;
    L169:
        ProcessStateRecord state2 = state;
        int logUid2 = appUid;
        boolean r17 = true;
        boolean foregroundActivities2 = foregroundActivities;
    L171:
        if (procState2 > 18) goto L173;
    L178:
        int capabilityFromFGS = 0;
        boolean hasForegroundServices = r3.hasForegroundServices();
        boolean hasNonShortForegroundServices = r3.hasNonShortForegroundServices();
        if (hasForegroundServices == false) goto L183;
        int schedGroup3 = schedGroup2;
        ProcessServiceRecord psr2 = psr;
        String r10 = TAG;
        if (psr2.areAllShortForegroundServicesProcstateTimedOut(now) == true) goto L184;
        boolean hasShortForegroundServices = r17;
    L185:
        boolean foregroundActivities3 = foregroundActivities2;
        if (adj2 > 200) goto L192;
        if (procState2 > 4) goto L192;
        int capabilityFromFGS2 = 0;
    L211:
        if (psr2.hasForegroundServices() == true) goto L213;
    L230:
        int r8 = 2;
        int r29 = 4;
    L232:
        if (psr2.hasTopStartedAlmostPerceptibleServices() == true) goto L234;
    L244:
        int schedGroup4 = 8;
        if (adj2 > 200) goto L248;
        if (procState2 > 8) goto L248;
    L254:
        if (state2.getCachedIsHeavyWeight() == false) goto L268;
        if (adj2 <= 400) goto L262;
        adj2 = 400;
        schedGroup3 = 0;
        state2.setAdjType("heavy");
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L260;
        if (logUid != logUid2) goto L262;
    L260:
        r0.reportOomAdjMessageLocked(r2, "Raise adj to heavy: " + r1);
    L262:
        if (procState2 <= 13) goto L268;
        procState2 = 13;
        state2.setAdjType("heavy");
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L266;
        if (logUid != logUid2) goto L268;
    L266:
        r0.reportOomAdjMessageLocked(r2, "Raise procstate to heavy: " + r1);
    L268:
        if (state2.getCachedIsHomeProcess() == false) goto L282;
        if (adj2 <= 600) goto L276;
        adj2 = 600;
        schedGroup3 = 0;
        state2.setAdjType("home");
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L274;
        if (logUid != logUid2) goto L276;
    L274:
        r0.reportOomAdjMessageLocked(r2, "Raise adj to home: " + r1);
    L276:
        if (procState2 <= 14) goto L282;
        procState2 = 14;
        state2.setAdjType("home");
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L280;
        if (logUid != logUid2) goto L282;
    L280:
        r0.reportOomAdjMessageLocked(r2, "Raise procstate to home: " + r1);
    L282:
        if (state2.getCachedIsPreviousProcess() == false) goto L296;
        if (state2.getCachedHasActivities() == false) goto L296;
        if (procState2 < 15) goto L298;
        if (state2.getSetProcState() != 15) goto L298;
        if ((state2.getLastStateTime() + ActivityManagerConstants.MAX_PREVIOUS_TIME) > now) goto L298;
        procState2 = 15;
        schedGroup3 = 0;
        state2.setAdjType("previous-expired");
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L294;
        if (logUid != logUid2) goto L296;
    L294:
        r0.reportOomAdjMessageLocked(r2, "Expire prev adj: " + r1);
    L298:
        if (adj2 <= 700) goto L303;
        adj2 = 700;
        schedGroup3 = 0;
        state2.setAdjType("previous");
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L302;
        if (logUid != logUid2) goto L303;
    L302:
        r0.reportOomAdjMessageLocked(r2, "Raise adj to prev: " + r1);
    L303:
        if (procState2 <= 15) goto L309;
        procState2 = 15;
        state2.setAdjType("previous");
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L307;
        if (logUid != logUid2) goto L309;
    L307:
        r0.reportOomAdjMessageLocked(r2, "Raise procstate to prev: " + r1);
    L309:
        if (state2.getSetProcState() != 15) goto L311;
        long lastStateTime = state2.getLastStateTime();
    L312:
        schedGroup4 = 8;
        r0.maybeSetProcessFollowUpUpdateLocked(r1, lastStateTime + ActivityManagerConstants.MAX_PREVIOUS_TIME, now);
        int schedGroup5 = schedGroup3;
    L314:
        if (cycleReEval == false) goto L316;
        procState2 = Math.min(procState2, state2.getCurRawProcState());
        adj2 = Math.min(adj2, state2.getCurRawAdj());
        schedGroup5 = Math.max(schedGroup5, state2.getCurrentSchedulingGroup());
    L316:
        state2.setCurRawAdj(adj2);
        state2.setCurRawProcState(procState2);
        state2.setHasStartedServices(false);
        state2.setAdjSeq(r0.mAdjSeq);
        if (isBackupProcess(app) == true) goto L319;
    L336:
        state2.setCurBoundByNonBgRestrictedApp(getInitialIsCurBoundByNonBgRestrictedApp(app));
        state2.setScheduleLikeTopApp(false);
        int r49 = adj2;
        int adj3 = schedGroup5;
        int adj4 = r49;
        int r410 = procState2;
        int is = psr2.numberOfRunningServices() - 1;
        int procState3 = r410;
    L337:
        if (is < 0) goto L460;
        if (adj4 > 0) goto L344;
        if (adj3 == 0) goto L344;
        if (procState3 > 2) goto L344;
        int is2 = 500;
        int appUid2 = 2;
    L461:
        ProcessProviderRecord ppr = r1.mProviders;
        int procState4 = procState3;
        int provi = ppr.numberOfProviders() - 1;
    L462:
        if (provi < 0) goto L529;
        if (adj4 > 0) goto L468;
        if (adj3 == 0) goto L468;
        if (procState4 <= appUid2) goto L529;
    L468:
        ContentProviderRecord cpr = ppr.getProviderAt(provi);
        if (couldRecurse == false) goto L505;
        state2.setCurRawAdj(adj4);
        state2.setCurRawProcState(procState4);
        state2.setCurrentSchedulingGroup(adj3);
        state2.setCurCapability(capability);
        int adj5 = adj4;
        int adj6 = cpr.connections.size() - 1;
        int procState5 = procState4;
        int capability2 = capability;
        int schedGroup6 = adj3;
    L471:
        if (adj6 < 0) goto L504;
        if (adj5 > 0) goto L477;
        if (schedGroup6 == 0) goto L477;
        if (procState5 <= appUid2) goto L504;
    L477:
        ContentProviderConnection conn = cpr.connections.get(adj6);
        int provi2 = provi;
        ProcessRecord client = conn.client;
        ProcessProviderRecord ppr2 = ppr;
        int i = adj6;
        int r22 = appUid2;
        ProcessRecord r2 = r1;
        ContentProviderRecord cpr2 = cpr;
        computeProviderHostOomAdjLSP(conn, r2, client, now, topApp, doingAll, cycleReEval, computeClients, oomAdjReason, cachedAdj, true, false);
        r1 = r2;
        if (r1.isPendingFinishAttach() == true) goto L501;
        if (client != r1) goto L481;
        String r11 = r10;
    L502:
        adj5 = state2.getCurRawAdj();
        procState5 = state2.getCurRawProcState();
        schedGroup6 = state2.getCurrentSchedulingGroup();
        capability2 = state2.getCurCapability();
        adj6 = i - 1;
        r10 = r11;
        cpr = cpr2;
        ppr = ppr2;
        appUid2 = r22;
        provi = provi2;
        is2 = 500;
        goto L471
    L481:
        if (client != topApp) goto L490;
        UidRecord uidRec = this.mActiveUids.get(r1.uid);
        if (uidRec == null) goto L486;
        uidRec.getSmtEx().SmtFlags |= 2;
    L486:
        if (ActivityManagerDebugConfigSmtEx.DEBUG_3RD_BG_APP == false) goto L488;
        r11 = r10;
        Slog.i(r11, r1 + " connected with top app with cpr" + cpr2);
    L489:
        connectedWithTop = true;
        goto L502
    L488:
        r11 = r10;
        goto L489
    L490:
        r11 = r10;
        if (client == null) goto L502;
        if (client.mPid != ActivityManagerService.MY_PID) goto L502;
        UidRecord uidRec2 = this.mActiveUids.get(r1.uid);
        if (uidRec2 == null) goto L498;
        uidRec2.getSmtEx().SmtFlags |= 1;
    L498:
        if (ActivityManagerDebugConfigSmtEx.DEBUG_3RD_BG_APP == false) goto L500;
        Slog.i(r11, r1 + " connected with system with cpr:" + cpr2 + ", client=" + client);
    L500:
        connectedWithSystemServer = true;
        goto L502
    L501:
        r11 = r10;
    L504:
        adj4 = adj5;
        capability = capability2;
        adj3 = schedGroup6;
        procState4 = procState5;
    L507:
        if (cpr.hasExternalProcessHandles() == false) goto L525;
        if (adj4 <= 0) goto L517;
        adj4 = 0;
        state2.setCurRawAdj(0);
        adj3 = 2;
        state2.setAdjType("ext-provider");
        state2.setAdjTarget(cpr.name);
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L515;
        int appUid3 = logUid2;
        int logUid3 = logUid;
        if (logUid3 == appUid3) goto L516;
        String r13 = r45;
    L519:
        if (procState4 <= 6) goto L526;
        state2.setCurRawProcState(6);
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L523;
        if (logUid3 == appUid3) goto L523;
    L524:
        procState4 = 6;
    L523:
        this.reportOomAdjMessageLocked(r13, "Raise procstate to external provider: " + r1);
    L526:
        provi = provi - 1;
        r10 = r10;
        logUid2 = appUid3;
        logUid = logUid3;
        String r3 = r13;
        ppr = ppr;
        appUid2 = appUid2;
        is2 = 500;
    L516:
        r13 = r3;
        this.reportOomAdjMessageLocked(r13, "Raise adj to external provider: " + r1);
        goto L519
    L515:
        appUid3 = logUid2;
        logUid3 = logUid;
        goto L516
    L517:
        appUid3 = logUid2;
        logUid3 = logUid;
        r13 = r3;
        goto L519
    L525:
        appUid3 = logUid2;
        logUid3 = logUid;
        r13 = r3;
        goto L526
    L505:
        ppr = ppr;
        provi = provi;
        appUid2 = appUid2;
        r10 = r10;
        OomAdjuster this = this;
        cpr = cpr;
    L529:
        if ((this.mConstants.CONTENT_PROVIDER_RETAIN_TIME + ppr.getLastProviderTime()) > now) goto L531;
        long r4 = now;
    L548:
        if (procState4 >= 19) goto L550;
    L555:
        int procState6 = procState4;
    L557:
        if (adj4 != 500) goto L588;
        if (doingAll == false) goto L584;
        if (cycleReEval == true) goto L584;
        if (this.mNewNumAServiceProcs <= (this.mNumServiceProcs / 3)) goto L563;
        boolean r5 = r17;
    L564:
        state2.setServiceB(r5);
        this.mNewNumServiceProcs++;
        if (state2.isServiceB() == false) goto L567;
        capability = capability;
        r17 = r17;
        boolean r7 = false;
        state2.setServiceHighRam(false);
    L586:
        if (state2.isServiceB() == false) goto L589;
        int adj7 = 800;
    L591:
        if (psr2.hasForegroundServices() == false) goto L593;
        capability = capability | capabilityFromFGS2;
    L593:
        int capability3 = getDefaultCapability(r1, procState6) | capability;
        boolean foregroundActivities4 = foregroundActivities3;
        int capability4 = capability3 | getCpuCapability(r1, r4, foregroundActivities4);
        if (procState6 <= 5) goto L597;
        capability4 = capability4 & (-17);
    L597:
        if (r1.isPendingFinishAttach() == false) goto L600;
        setAttachingProcessStatesLSP(app);
        state2.setAdjSeq(this.mAdjSeq);
        state2.setCompletedAdjSeq(state2.getAdjSeq());
        return r7;
    L600:
        state2.setCurCapability(capability4);
        state2.updateLastInvisibleTime(hasVisibleActivities2);
        state2.setHasForegroundActivities(foregroundActivities4);
        state2.setCompletedAdjSeq(this.mAdjSeq);
        int prevAppAdj2 = prevAppAdj;
        int schedGroup7 = setIntermediateAdjLSP(r1, adj7, prevAppAdj2, adj3);
        int prevProcState2 = prevProcState;
        setIntermediateProcStateLSP(r1, procState6, prevProcState2);
        setIntermediateSchedGroupLSP(state2, schedGroup7);
        IOomAdjusterOptEx r9 = this.mOomAdjusterOptEx;
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L605;
        if (logUid == logUid2) goto L605;
        boolean r12 = false;
    L606:
        r9.computeOomAdjLocked(this, app, r12, topApp, connectedWithTop, connectedWithSystemServer);
        this.mOomAdjusterOptEx.computeOomAdjForPrefetch(app, schedGroup7);
        if (state2.getCurAdj() < prevAppAdj2) goto L615;
        if (state2.getCurProcState() < prevProcState2) goto L615;
        if (state2.getCurCapability() != prevCapability) goto L615;
        return false;
    L615:
        return true;
    L605:
        r12 = r17;
    L589:
        adj7 = adj4;
        goto L591
    L567:
        if (this.mService.mAppProfiler.isProfilingPss() == false) goto L569;
        long lastPssOrRss = r1.mProfile.getLastPss();
    L571:
        if (this.mService.mAppProfiler.isProfilingPss() == false) goto L573;
        double thresholdModifier = 1.0d;
    L574:
        double cachedRestoreThreshold = this.mProcessList.getCachedRestoreThresholdKb() * thresholdModifier;
        if (isLastMemoryLevelNormal() == true) goto L581;
        double cachedRestoreThreshold2 = lastPssOrRss;
        if (cachedRestoreThreshold2 < cachedRestoreThreshold) goto L581;
        r17 = r17;
        state2.setServiceHighRam(r17);
        state2.setServiceB(r17);
    L582:
        r7 = false;
    L581:
        this.mNewNumAServiceProcs += r17;
        goto L582
    L573:
        thresholdModifier = this.mConstants.PSS_TO_RSS_THRESHOLD_MODIFIER;
        goto L574
    L569:
        lastPssOrRss = r1.mProfile.getLastRss();
        goto L571
    L563:
        r5 = false;
    L584:
        capability = capability;
        r17 = r17;
        r7 = false;
        goto L586
    L588:
        capability = capability;
        r17 = r17;
        r7 = false;
        goto L589
    L550:
        if (psr2.hasClientActivities() == false) goto L553;
        state2.setAdjType("cch-client-act");
        procState6 = 17;
        goto L557
    L553:
        if (psr2.isTreatedLikeActivity() == false) goto L555;
        state2.setAdjType("cch-as-act");
        procState6 = 16;
        goto L557
    L531:
        if (adj4 <= 700) goto L537;
        int adj8 = 700;
        adj3 = 0;
        state2.setAdjType("recent-provider");
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L535;
        if (logUid == logUid2) goto L535;
    L536:
        maybeSetProcessFollowUpUpdateLocked(r1, ppr.getLastProviderTime() + this.mConstants.CONTENT_PROVIDER_RETAIN_TIME, now);
    L539:
        if (procState4 <= 15) goto L545;
        procState4 = 15;
        state2.setAdjType("recent-provider");
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L543;
        if (logUid == logUid2) goto L543;
    L544:
        maybeSetProcessFollowUpUpdateLocked(r1, ppr.getLastProviderTime() + this.mConstants.CONTENT_PROVIDER_RETAIN_TIME, now);
        r4 = now;
        adj4 = adj8;
    L543:
        reportOomAdjMessageLocked(r3, "Raise procstate to recent provider: " + r1);
        goto L544
    L545:
        r4 = now;
        adj4 = adj8;
    L535:
        reportOomAdjMessageLocked(r3, "Raise adj to recent provider: " + r1);
        goto L536
    L537:
        adj8 = adj4;
    L344:
        ServiceRecord s = psr2.getRunningServiceAt(is);
        if (s.startRequested == false) goto L385;
        state2.setHasStartedServices(r17);
        if (procState3 <= 10) goto L353;
        state2.setAdjType("started-services");
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L351;
        if (logUid == logUid2) goto L351;
    L352:
        int procState7 = 10;
    L355:
        if (s.mKeepWarming == true) goto L365;
        if (state2.hasShownUi() == false) goto L365;
        if (state2.getCachedIsHomeProcess() == true) goto L365;
        if (adj4 <= 500) goto L363;
        state2.setAdjType("cch-started-ui-services");
    L363:
        logUid = logUid;
        procState3 = procState7;
        is = is;
        capability = capability;
        psr2 = psr2;
        s = s;
    L387:
        if (s.isForeground == false) goto L406;
        int fgsType = s.foregroundServiceType;
        if (s.isFgsAllowedWiu_forCapabilities() == false) goto L406;
        if ((fgsType & 8) == 0) goto L393;
        int r14 = 1;
    L394:
        int capabilityFromFGS3 = (capabilityFromFGS2 | r14) | 64;
        boolean enabled = state2.getCachedCompatChange(1);
        if (enabled == true) goto L397;
        capabilityFromFGS2 = capabilityFromFGS3 | 6;
        goto L406
    L397:
        if ((fgsType & 64) == 0) goto L399;
        int r15 = 2;
    L400:
        int capabilityFromFGS4 = capabilityFromFGS3 | r15;
        if ((fgsType & 128) == 0) goto L403;
        int r16 = r29;
    L404:
        capabilityFromFGS2 = capabilityFromFGS4 | r16;
        goto L406
    L403:
        r16 = 0;
        goto L404
    L399:
        r15 = 0;
        goto L400
    L393:
        r14 = 0;
    L406:
        if (couldRecurse == true) goto L408;
        String r45 = r3;
        boolean hasVisibleActivities3 = hasVisibleActivities2;
        int appUid4 = logUid2;
        int is3 = is;
        ProcessServiceRecord psr3 = psr2;
        int logUid4 = logUid;
        boolean foregroundActivities5 = foregroundActivities3;
        String r46 = r10;
        r17 = true;
    L459:
        capability = capability;
        is = is3 - 1;
        r0 = this;
        r6 = topApp;
        psr2 = psr3;
        logUid2 = appUid4;
        logUid = logUid4;
        r3 = r45;
        r10 = r46;
        foregroundActivities3 = foregroundActivities5;
        hasVisibleActivities2 = hasVisibleActivities3;
        goto L337
    L408:
        state2.setCurRawAdj(adj4);
        state2.setCurRawProcState(procState3);
        state2.setCurrentSchedulingGroup(adj3);
        state2.setCurCapability(capability);
        ArrayMap<IBinder, ArrayList<ConnectionRecord>> serviceConnections = s.getConnections();
        int conni = serviceConnections.size() - 1;
    L409:
        if (conni < 0) goto L457;
        if (adj4 > 0) goto L416;
        if (adj3 == 0) goto L416;
        if (procState3 > 2) goto L416;
        r45 = r3;
        hasVisibleActivities3 = hasVisibleActivities2;
        appUid4 = logUid2;
        is3 = is;
        psr3 = psr2;
        logUid4 = logUid;
        foregroundActivities5 = foregroundActivities3;
        r46 = r10;
        r17 = true;
    L416:
        ArrayList<ConnectionRecord> clist = serviceConnections.valueAt(conni);
        int adj9 = adj4;
        int adj10 = procState3;
        int capability5 = capability;
        int procState8 = 0;
        boolean connectedWithTop2 = connectedWithTop;
        int schedGroup8 = adj3;
    L418:
        if (procState8 >= clist.size()) goto L456;
        if (adj9 > 0) goto L425;
        if (schedGroup8 == 0) goto L425;
        if (adj10 <= 2) goto L456;
    L425:
        ConnectionRecord cr = clist.get(procState8);
        if (cr.binding.client != r1) goto L429;
        String r47 = r10;
        ServiceRecord s2 = s;
    L454:
        procState8 = procState8 + 1;
        r0 = this;
        r6 = topApp;
        s = s2;
        serviceConnections = serviceConnections;
        conni = conni;
        clist = clist;
        logUid2 = logUid2;
        logUid = logUid;
        r3 = r3;
        r10 = r47;
        foregroundActivities3 = foregroundActivities3;
        hasVisibleActivities2 = hasVisibleActivities2;
        psr2 = psr2;
        is = is;
        goto L418
    L429:
        if (cr.binding.client != r6) goto L439;
        UidRecord uidRec3 = r0.mActiveUids.get(r1.uid);
        if (uidRec3 == null) goto L433;
        int r34 = 2;
        uidRec3.getSmtEx().SmtFlags |= 2;
    L435:
        if (ActivityManagerDebugConfigSmtEx.DEBUG_3RD_BG_APP == false) goto L437;
        String r18 = r10;
        Slog.i(r18, r1 + " connected with top app with service:" + cr);
    L438:
        boolean connectedWithSystemServer2 = connectedWithSystemServer;
        boolean connectedWithSystemServer3 = true;
    L453:
        ProcessRecord r19 = r1;
        r47 = r18;
        s2 = s;
        computeServiceHostOomAdjLSP(cr, r19, cr.binding.client, now, r6, doingAll, cycleReEval, computeClients, oomAdjReason, cachedAdj, true, false);
        r1 = r19;
        adj9 = state2.getCurRawAdj();
        adj10 = state2.getCurRawProcState();
        schedGroup8 = state2.getCurrentSchedulingGroup();
        capability5 = state2.getCurCapability();
        connectedWithTop2 = connectedWithSystemServer3;
        connectedWithSystemServer = connectedWithSystemServer2;
        goto L454
    L437:
        r18 = r10;
        goto L438
    L433:
        r34 = 2;
        goto L435
    L439:
        r18 = r10;
        r34 = 2;
        int r20 = cr.binding.client.mPid;
        int i2 = ActivityManagerService.MY_PID;
        if (r20 != i2) goto L450;
        if (cr.getSmtEx().connectWithJobService == true) goto L450;
        connectedWithSystemServer = true;
        UidRecord uidRec4 = r0.mActiveUids.get(r1.uid);
        if (uidRec4 == null) goto L448;
        uidRec4.getSmtEx().SmtFlags |= 1;
    L448:
        if (ActivityManagerDebugConfigSmtEx.DEBUG_3RD_BG_APP == false) goto L450;
        Slog.i(r18, r1 + " connected with system with service:" + cr + ", client=" + cr.binding.client);
    L450:
        connectedWithSystemServer2 = connectedWithSystemServer;
        connectedWithSystemServer3 = connectedWithTop2;
    L456:
        int is4 = is;
        boolean foregroundActivities6 = foregroundActivities3;
        int procState9 = adj10;
        conni = conni - 1;
        r0 = this;
        r6 = topApp;
        adj4 = adj9;
        s = s;
        serviceConnections = serviceConnections;
        adj3 = schedGroup8;
        logUid2 = logUid2;
        procState3 = procState9;
        logUid = logUid;
        r3 = r3;
        r10 = r10;
        foregroundActivities3 = foregroundActivities6;
        hasVisibleActivities2 = hasVisibleActivities2;
        connectedWithTop = connectedWithTop2;
        psr2 = psr2;
        capability = capability5;
        is = is4;
        goto L409
    L457:
        r45 = r3;
        hasVisibleActivities3 = hasVisibleActivities2;
        appUid4 = logUid2;
        is3 = is;
        psr3 = psr2;
        logUid4 = logUid;
        foregroundActivities5 = foregroundActivities3;
        r46 = r10;
        r17 = true;
    L365:
        if (s.mKeepWarming == true) goto L371;
        if (now < (s.lastActivity + r0.mConstants.MAX_SERVICE_INACTIVITY)) goto L371;
        logUid = logUid;
        is = is;
        capability = capability;
        int is5 = 500;
    L382:
        if (adj4 <= is5) goto L384;
        state2.setAdjType("cch-started-services");
    L384:
        procState3 = procState7;
    L371:
        if (r1.isSdkSandbox == false) goto L373;
        is5 = 500;
        goto L382
    L373:
        if (adj4 <= 500) goto L379;
        state2.setAdjType("started-services");
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L377;
        if (logUid == logUid2) goto L377;
    L378:
        long r21 = s.lastActivity + r0.mConstants.MAX_SERVICE_INACTIVITY;
        r0 = this;
        r1 = app;
        logUid = logUid;
        is = is;
        capability = capability;
        is5 = 500;
        r0.maybeSetProcessFollowUpUpdateLocked(r1, r21, now);
        adj4 = 500;
    L377:
        r0.reportOomAdjMessageLocked(r3, "Raise adj to started service: " + r1);
        goto L378
    L379:
        is5 = 500;
    L351:
        r0.reportOomAdjMessageLocked(r3, "Raise procstate to started service: " + r1);
        goto L352
    L353:
        procState7 = procState3;
        goto L355
    L385:
        logUid = logUid;
        is = is;
        capability = capability;
        psr2 = psr2;
        s = s;
        goto L387
    L460:
        is2 = 500;
        appUid2 = 2;
        goto L461
    L319:
        if (adj2 <= 300) goto L331;
        if (ActivityManagerDebugConfig.DEBUG_BACKUP == false) goto L323;
        Slog.v(r3, "oom BACKUP_APP_ADJ for " + r1);
    L323:
        adj2 = 300;
        if (procState2 <= schedGroup4) goto L326;
        procState2 = 8;
    L326:
        state2.setAdjType(HostingRecord.HOSTING_TYPE_BACKUP);
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L329;
        if (logUid != logUid2) goto L331;
    L329:
        r0.reportOomAdjMessageLocked(r3, "Raise adj to backup: " + r1);
    L331:
        if (procState2 <= 9) goto L336;
        procState2 = 9;
        state2.setAdjType(HostingRecord.HOSTING_TYPE_BACKUP);
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L335;
        if (logUid != logUid2) goto L336;
    L335:
        r0.reportOomAdjMessageLocked(r3, "Raise procstate to backup: " + r1);
        goto L336
    L311:
        lastStateTime = now;
    L296:
        schedGroup5 = schedGroup3;
    L248:
        if (state2.getForcingToImportant() == null) goto L254;
        adj2 = 200;
        procState2 = 8;
        state2.setAdjType("force-imp");
        state2.setAdjSource(state2.getForcingToImportant());
        schedGroup3 = 2;
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L252;
        if (logUid != logUid2) goto L254;
    L252:
        r0.reportOomAdjMessageLocked(r3, "Raise to force imp: " + r1);
        goto L254
    L234:
        if (adj2 <= 52) goto L244;
        if ((state2.getLastTopTime() + r0.mConstants.TOP_TO_ALMOST_PERCEPTIBLE_GRACE_DURATION) <= now) goto L238;
    L239:
        adj2 = 52;
        state2.setAdjType("top-ej-act");
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L242;
        if (logUid == logUid2) goto L242;
    L243:
        r0.maybeSetProcessFollowUpUpdateLocked(r1, state2.getLastTopTime() + r0.mConstants.TOP_TO_ALMOST_PERCEPTIBLE_GRACE_DURATION, now);
    L242:
        r0.reportOomAdjMessageLocked("ActivityManager", "Raise to recent fg for EJ: " + r1);
        goto L243
    L238:
        if (state2.getSetProcState() > r8) goto L244;
    L213:
        if (adj2 <= 50) goto L230;
        if ((state2.getLastTopTime() + r0.mConstants.TOP_TO_FGS_GRACE_DURATION) > now) goto L222;
        if (state2.getSetProcState() <= 2) goto L222;
        r8 = 2;
        r29 = 4;
    L222:
        if (psr2.hasNonShortForegroundServices() == false) goto L224;
        state2.setAdjType("fg-service-act");
        adj2 = 50;
    L226:
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L228;
        if (logUid == logUid2) goto L228;
    L229:
        r8 = 2;
        r29 = 4;
        r0.maybeSetProcessFollowUpUpdateLocked(r1, state2.getLastTopTime() + r0.mConstants.TOP_TO_FGS_GRACE_DURATION, now);
    L228:
        r0.reportOomAdjMessageLocked("ActivityManager", "Raise to recent fg: " + r1);
        goto L229
    L224:
        state2.setAdjType("fg-service-short-act");
        adj2 = 51;
    L192:
        int newAdj = 0;
        int newProcState = 0;
        if (hasForegroundServices == false) goto L196;
        if (hasNonShortForegroundServices == false) goto L196;
        newAdj = 200;
        newProcState = 4;
        capabilityFromFGS = 0 | 16;
        String adjType = "fg-service";
    L202:
        if (adjType == null) goto L209;
        adj2 = newAdj;
        procState2 = newProcState;
        state2.setAdjType(adjType);
        schedGroup3 = 2;
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L208;
        if (logUid == logUid2) goto L208;
        capabilityFromFGS2 = capabilityFromFGS;
    L208:
        capabilityFromFGS2 = capabilityFromFGS;
        r0.reportOomAdjMessageLocked("ActivityManager", "Raise to " + adjType + ": " + r1 + " ");
        goto L211
    L209:
        capabilityFromFGS2 = capabilityFromFGS;
    L196:
        if (hasShortForegroundServices == false) goto L199;
        newAdj = 226;
        newProcState = 4;
        adjType = "fg-service-short";
        goto L202
    L199:
        if (state2.hasOverlayUi() == false) goto L201;
        newAdj = 200;
        newProcState = 6;
        adjType = "has-overlay-ui";
        goto L202
    L201:
        adjType = null;
    L184:
        hasShortForegroundServices = false;
        goto L185
    L183:
        schedGroup3 = schedGroup2;
        psr2 = r3;
        r10 = TAG;
        goto L184
    L173:
        if (state2.getCachedHasRecentTasks() == false) goto L178;
        procState2 = 18;
        state2.setAdjType("cch-rec");
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L177;
        if (logUid != logUid2) goto L178;
    L177:
        r0.reportOomAdjMessageLocked("ActivityManager", "Raise procstate to cached recent: " + r1);
        goto L178
    L167:
        if (state.getCachedHasActivities() == false) goto L169;
        r17 = true;
        state.computeOomAdjFromActivitiesIfNecessary(r0.mTmpComputeOomAdjWindowCallback, adj2, foregroundActivities, hasVisibleActivities2, procState2, schedGroup2, appUid, logUid, PROCESS_STATE_CUR_TOP2);
        state2 = state;
        logUid2 = appUid;
        adj2 = state2.getCachedAdj();
        foregroundActivities2 = state2.getCachedForegroundActivities();
        hasVisibleActivities2 = state2.getCachedHasVisibleActivities();
        procState2 = state2.getCachedProcState();
        schedGroup2 = state2.getCachedSchedGroup();
        state2.setAdjType(state2.getCachedAdjType());
        goto L171
    L164:
        foregroundActivities = false;
    L125:
        r0.reportOomAdjMessageLocked("ActivityManager", "Making running remote anim: " + r1);
        goto L119
    L127:
        if (r1.getActiveInstrumentation() == null) goto L133;
        adj = 0;
        schedGroup = 2;
        state.setAdjType("instrumentation");
        procState = 4;
        capability = capability | 16;
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L131;
        if (logUid != appUid) goto L119;
    L131:
        r0.reportOomAdjMessageLocked("ActivityManager", "Making instrumentation: " + r1);
        goto L119
    L133:
        if (state.getCachedIsReceivingBroadcast(r0.mTmpSchedGroup) == false) goto L139;
        adj = 0;
        schedGroup = r0.mTmpSchedGroup[0];
        state.setAdjType("broadcast");
        procState = 11;
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L137;
        if (logUid != appUid) goto L119;
    L137:
        r0.reportOomAdjMessageLocked("ActivityManager", "Making broadcast: " + r1);
        goto L119
    L139:
        if (psr.numberOfExecutingServices() <= 0) goto L148;
        adj = 0;
        if (psr.shouldExecServicesFg() == false) goto L143;
        int r23 = 2;
    L144:
        schedGroup = r23;
        state.setAdjType("exec-service");
        procState = 10;
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L147;
        if (logUid != appUid) goto L119;
    L147:
        r0.reportOomAdjMessageLocked("ActivityManager", "Making exec-service: " + r1);
        goto L119
    L143:
        r23 = 0;
        goto L144
    L148:
        if (r1 != r6) goto L153;
        adj = 0;
        schedGroup = 0;
        state.setAdjType("top-sleeping");
        procState = PROCESS_STATE_CUR_TOP2;
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L152;
        if (logUid != appUid) goto L119;
    L152:
        r0.reportOomAdjMessageLocked("ActivityManager", "Making top (sleeping): " + r1);
        goto L119
    L153:
        schedGroup = 0;
        adj = cachedAdj;
        procState = 19;
        if (couldRecurse == true) goto L156;
    L157:
        state.setAdjType("cch-empty");
    L159:
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L161;
        if (logUid != appUid) goto L119;
    L161:
        r0.reportOomAdjMessageLocked("ActivityManager", "Making empty: " + r1);
        goto L119
    L156:
        if (state.containsCycle() == true) goto L159;
    L79:
        if (PROCESS_STATE_CUR_TOP != 2) goto L120;
        adj = 0;
        if (r0.mService.mAtmInternal.useTopSchedGroupForTopProcess() == false) goto L83;
        schedGroup = 3;
        state.setAdjType(HostingRecord.HOSTING_TYPE_TOP_ACTIVITY);
    L84:
        hasVisibleActivities = true;
        procState = 2;
        if (mIsTopAppRenderThreadBoostEnabled == false) goto L98;
        PROCESS_STATE_CUR_TOP2 = PROCESS_STATE_CUR_TOP;
        if (mCurRenderThreadTid == r1.getRenderThreadTid()) goto L100;
        if (r1.getRenderThreadTid() <= 0) goto L100;
        mCurRenderThreadTid = r1.getRenderThreadTid();
        if (mPerfBoost == null) goto L100;
        Slog.d(TAG, "TOP-APP: pid:" + r1.getPid() + ", processName: " + r1.processName + ", renderThreadTid: " + r1.getRenderThreadTid());
        if (mPerfHandle < 0) goto L95;
        mPerfBoost.perfLockReleaseHandler(mPerfHandle);
        mPerfHandle = -1;
    L95:
        mPerfHandle = mPerfBoost.perfHint(4246, r1.processName, r1.getRenderThreadTid(), 1);
        Slog.d(TAG, "VENDOR_HINT_BOOST_RENDERTHREAD perfHint was called. mPerfHandle: " + mPerfHandle);
    L100:
        if (mCurAppPid == r1.getPid()) goto L107;
        if (r1.getPid() <= 0) goto L107;
        mCurAppPid = r1.getPid();
        if (mPerfBoost == null) goto L107;
        mPerfBoost.perfHint(4252, r1.processName, mCurAppPid, 4);
    L107:
        if (mCurRenderTid != r1.getRenderThreadTid()) goto L109;
    L114:
        prevCapability2 = 5;
    L116:
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L118;
        if (logUid != appUid) goto L119;
    L118:
        r0.reportOomAdjMessageLocked("ActivityManager", "Making top: " + r1);
        goto L119
    L109:
        if (r1.getRenderThreadTid() <= 0) goto L114;
        mCurRenderTid = r1.getRenderThreadTid();
        if (mPerfBoost == null) goto L113;
        prevCapability2 = 5;
        mPerfBoost.perfHint(4252, r1.processName, mCurRenderTid, 5);
        goto L116
    L113:
        prevCapability2 = 5;
        goto L116
    L98:
        PROCESS_STATE_CUR_TOP2 = PROCESS_STATE_CUR_TOP;
        goto L100
    L83:
        schedGroup = 2;
        state.setAdjType("intermediate-top-activity");
        goto L84
    L75:
        capability = 0;
        goto L76
    L30:
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L32;
        if (logUid == appUid) goto L32;
    L33:
        state.setAdjType("fixed");
        state.setAdjSeq(r0.mAdjSeq);
        state.setCurRawAdj(state.getMaxAdj());
        state.setHasForegroundActivities(false);
        state.setCurrentSchedulingGroup(2);
        state.setCurCapability(255);
        state.setCurProcState(0);
        state.setSystemNoUi(true);
        if (r1 != r6) goto L37;
        state.setSystemNoUi(false);
        state.setCurrentSchedulingGroup(3);
        state.setAdjType("pers-top-activity");
    L43:
        if (state.isSystemNoUi() == false) goto L45;
    L50:
        state.setCurRawProcState(state.getCurProcState());
        state.setCurAdj(state.getMaxAdj());
        state.setCompletedAdjSeq(state.getAdjSeq());
        if (r1 == r6) goto L65;
        if ((r1.info.getSysEx().peroptFlag & 64) != 0) goto L57;
        if ((r1.info.getSysEx().peroptFlag & 8192) == 0) goto L65;
    L57:
        if (r1.getSmtEx().getPriorityState() == 1) goto L65;
        if ((r1.info.getSysEx().peroptFlag & 64) == 0) goto L62;
        r1.mState.setCurrentSchedulingGroup(13);
        goto L65
    L62:
        if ((r1.info.getSysEx().peroptFlag & 8192) == 0) goto L65;
        r1.mState.setCurrentSchedulingGroup(15);
    L65:
        if (state.getCurAdj() >= prevAppAdj) goto L67;
    L70:
        return true;
    L67:
        if (state.getCurProcState() < prevProcState) goto L70;
        return false;
    L45:
        if (r0.isScreenOnOrAnimatingLocked(state) == false) goto L48;
        state.setCurProcState(1);
        state.setCurrentSchedulingGroup(3);
        goto L50
    L48:
        if (r1.getWindowProcessController().isShowingUiWhileDozing() == true) goto L50;
        state.setCurProcState(5);
        state.setCurrentSchedulingGroup(1);
        goto L50
    L37:
        if (state.hasTopUi() == false) goto L40;
        state.setSystemNoUi(false);
        state.setAdjType("pers-top-ui");
        goto L43
    L40:
        if (state.getCachedHasVisibleActivities() == false) goto L43;
        state.setSystemNoUi(false);
    L32:
        r0.reportOomAdjMessageLocked("ActivityManager", "Making fixed: " + r1);
    L20:
        state.setNoKillOnBgRestrictedAndIdle(false);
        UidRecord uidRec5 = r1.getUidRecord();
        ProcessCachedOptimizerRecord r110 = r1.mOptRecord;
        if (uidRec5 != null) goto L23;
    L25:
        boolean r111 = false;
    L26:
        r110.setShouldNotFreeze(r111, 2, r0.mAdjSeq);
        goto L27
    L23:
        if (uidRec5.isCurAllowListed() == false) goto L25;
        r111 = true;
        goto L26
    L14:
        if (r1.getSmtEx().inFreezeStat() == true) goto L17;
        state.setAdjSeq(r0.mAdjSeq);
        state.setCurrentSchedulingGroup(0);
        state.setCurProcState(19);
        state.setCurRawProcState(19);
        state.setCurAdj(999);
        state.setCurRawAdj(999);
        state.setCompletedAdjSeq(state.getAdjSeq());
        state.setCurCapability(0);
        return false;
    L5:
        if (r0.mAdjSeq != state.getAdjSeq()) goto L11;
        if (state.getAdjSeq() != state.getCompletedAdjSeq()) goto L9;
        return false;
    L9:
        state.setContainsCycle(true);
        r0.mProcessesInCycle.add(r1);
        return false;
    }

    protected int setIntermediateAdjLSP(ProcessRecord app, int adj, int prevRawAppAdj, int schedGroup) {
        ProcessStateRecord state = app.mState;
        state.setCurRawAdj(adj);
        int adj2 = app.mServices.modifyRawOomAdj(adj);
        if (adj2 <= state.getMaxAdj()) goto L7;
        adj2 = state.getMaxAdj();
        if (adj2 > 250) goto L7;
        schedGroup = 2;
    L7:
        state.setCurAdj(adj2);
        return schedGroup;
    }

    protected void setIntermediateProcStateLSP(ProcessRecord app, int procState, int prevProcState) {
        ProcessStateRecord state = app.mState;
        state.setCurProcState(procState);
        state.setCurRawProcState(procState);
    }

    protected void setIntermediateSchedGroupLSP(ProcessStateRecord state, int schedGroup) {
        if (state.getCurProcState() >= 5) goto L5;
    L11:
        state.setCurrentSchedulingGroup(schedGroup);
        return;
    L5:
        if (isDeviceFullyAwake() == true) goto L11;
        if (state.shouldScheduleLikeTopApp() == true) goto L11;
        if (schedGroup <= 1) goto L11;
        schedGroup = 1;
        goto L11
    }

    public boolean computeServiceHostOomAdjLSP(ConnectionRecord cr, ProcessRecord app, ProcessRecord client, long now, ProcessRecord topApp, boolean doingAll, boolean cycleReEval, boolean computeClients, int oomAdjReason, int cachedAdj, boolean couldRecurse, boolean dryRun) {
        if (app.isPendingFinishAttach() == false) goto L5;
        return false;
    L5:
        ProcessStateRecord state = app.mState;
        ProcessStateRecord cstate = client.mState;
        boolean updated = false;
        if (couldRecurse == true) goto L8;
        OomAdjuster r2 = this;
        ProcessRecord client2 = client;
    L18:
        SysOptBridge.getFactory().getFreezeController().updateImportantUids(cr, app);
        int clientAdj = cstate.getCurRawAdj();
        int clientProcState = cstate.getCurRawProcState();
        if (clientProcState >= 2) goto L21;
        boolean r0 = true;
    L22:
        boolean clientIsSystem = r0;
        int adj = state.getCurRawAdj();
        int procState = state.getCurRawProcState();
        int schedGroup = state.getCurrentSchedulingGroup();
        int capability = state.getCurCapability();
        int prevRawAdj = adj;
        int appUid = app.info.uid;
        int logUid = r2.mService.mCurOomAdjUid;
        if (dryRun == true) goto L39;
        if (state.isCurBoundByNonBgRestrictedApp() == false) goto L27;
    L36:
        boolean r10 = true;
    L37:
        state.setCurBoundByNonBgRestrictedApp(r10);
        goto L39
    L27:
        if (cstate.isCurBoundByNonBgRestrictedApp() == true) goto L36;
        if (clientProcState <= 3) goto L36;
        if (clientProcState == 4) goto L33;
    L35:
        r10 = false;
        goto L37
    L33:
        if (cstate.isBackgroundRestricted() == true) goto L35;
    L39:
        if (client2.mOptRecord.shouldNotFreeze() == false) goto L44;
        if (app.mOptRecord.setShouldNotFreeze(true, dryRun, app.mOptRecord.shouldNotFreezeReason() | client2.mOptRecord.shouldNotFreezeReason(), r2.mAdjSeq) == false) goto L44;
        return true;
    L44:
        int capability2 = (capability | r2.getBfslCapabilityFromClient(client2)) | getCpuCapabilityFromClient(cr, client2);
        boolean trackedProcState = false;
        if (cr.notHasFlag(32) == true) goto L47;
        int logUid2 = logUid;
        ProcessRecord r1 = app;
        int prevSchedGroup = schedGroup;
        String r3 = "ActivityManager";
        prevRawAdj = prevRawAdj;
        if (clientAdj >= 900) goto L276;
        if (r1.mOptRecord.setShouldNotFreeze(true, dryRun, r1.mOptRecord.shouldNotFreezeReason() | 8, r2.mAdjSeq) == false) goto L276;
        return true;
    L276:
        int capability3 = capability2;
        int adj2 = procState;
    L278:
        if (cr.hasFlag(134217728) == false) goto L285;
        if (dryRun == true) goto L282;
        r1.mServices.setTreatLikeActivity(true);
    L282:
        if (clientProcState > 16) goto L285;
        if (adj2 <= 16) goto L285;
        adj2 = 16;
        state.setAdjType("cch-as-act");
    L285:
        ActivityServiceConnectionsHolder<ConnectionRecord> r5 = cr.activity;
        if (cr.hasFlag(128) == false) goto L313;
        if (r5 == null) goto L313;
        if (adj <= 0) goto L313;
        if (r5.isActivityVisible() == false) goto L313;
        int adj3 = 0;
        if (state.setCurRawAdj(0, dryRun) == false) goto L295;
        return true;
    L295:
        capability3 = capability3;
        if (cr.notHasFlag(4) == true) goto L298;
    L301:
        if (dryRun == true) goto L309;
        state.setAdjType(HostingRecord.HOSTING_TYPE_SERVICE);
        state.setAdjTypeCode(2);
        state.setAdjSource(r5);
        state.setAdjSourceProcState(adj2);
        state.setAdjTarget(cr.binding.service.instanceName);
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L307;
        if (logUid2 != appUid) goto L309;
    L307:
        r2.reportOomAdjMessageLocked(r3, "Raise to service w/activity: " + r1);
    L309:
        int schedGroup2 = schedGroup;
    L314:
        int capability4 = capability3 | r2.getDefaultCapability(r1, adj2);
        if (adj2 <= 5) goto L317;
        capability4 = capability4 & (-17);
    L317:
        if (0 != 0) goto L331;
        if (adj3 < prevRawAdj) goto L323;
        int prevProcState = procState;
        if (adj2 < prevProcState) goto L324;
        if (schedGroup2 > prevSchedGroup) goto L324;
    L325:
        int clientAdj2 = capability4 & (-129);
        int logUid3 = capability & (-129);
        if (clientAdj2 == logUid3) goto L332;
        int curFiltered = clientAdj2 & logUid3;
        if (curFiltered != logUid3) goto L332;
        updated = true;
    L332:
        if (dryRun == false) goto L334;
        return updated;
    L334:
        if (adj3 >= prevRawAdj) goto L336;
        schedGroup2 = r2.setIntermediateAdjLSP(r1, adj3, prevRawAdj, schedGroup2);
    L336:
        if (adj2 >= prevProcState) goto L338;
        r2.setIntermediateProcStateLSP(r1, adj2, prevProcState);
    L338:
        if (schedGroup2 <= prevSchedGroup) goto L340;
        r2.setIntermediateSchedGroupLSP(state, schedGroup2);
    L340:
        state.setCurCapability(capability4);
        return updated;
    L324:
        updated = true;
        goto L325
    L323:
        prevProcState = procState;
        goto L324
    L331:
        prevProcState = procState;
        goto L332
    L298:
        if (cr.hasFlag(64) == false) goto L300;
        schedGroup = 4;
        goto L301
    L300:
        schedGroup = 2;
    L313:
        adj3 = adj;
        schedGroup2 = schedGroup;
        goto L314
    L47:
        if (cr.hasFlag(4096) == false) goto L50;
        capability2 = capability2 | cstate.getCurCapability();
    L50:
        if ((cstate.getCurCapability() & 8) == 0) goto L59;
        if (clientProcState <= 5) goto L54;
        capability2 = capability2 | 8;
        goto L59
    L54:
        if (cr.hasFlag(131072) == false) goto L59;
        capability2 = capability2 | 8;
    L59:
        if ((cstate.getCurCapability() & 32) != 0) goto L61;
        int adj4 = adj;
    L68:
        if ((cstate.getCurCapability() & 64) != 0) goto L70;
    L72:
        int capability5 = capability2;
    L73:
        if (couldRecurse == false) goto L77;
        int adj5 = adj4;
        OomAdjuster r4 = r2;
        r1 = app;
        ProcessStateRecord cstate2 = cstate;
        int procState2 = procState;
        boolean r27 = r4.shouldSkipDueToCycle(r1, cstate2, procState2, adj5, cycleReEval);
        ProcessStateRecord cstate3 = cstate2;
        r2 = r4;
        if (r27 == false) goto L79;
        return false;
    L79:
        if (clientProcState < 16) goto L81;
        clientProcState = 19;
    L81:
        String adjType = null;
        if (cr.hasFlag(16) == true) goto L84;
        procState2 = procState2;
        clientProcState = clientProcState;
        int logUid4 = logUid;
    L107:
        clientProcState = clientProcState;
    L108:
        if (adj5 <= clientAdj) goto L185;
        if (state.hasShownUi() == true) goto L112;
    L119:
        int lbAdj = 100;
        if (cr.hasFlag(72) == true) goto L122;
        logUid4 = logUid4;
        if (cr.hasFlag(256) == false) goto L136;
        if (clientAdj > 200) goto L136;
        lbAdj = 250;
        if (adj5 < 250) goto L136;
        int newAdj = 250;
        int logUid5 = procState2;
    L171:
        if (cstate3.isCached() == false) goto L173;
    L177:
        if (newAdj == clientAdj) goto L179;
    L181:
        if (adj5 <= newAdj) goto L183;
        adj5 = newAdj;
        state.setCurRawAdj(adj5, dryRun);
        adjType = HostingRecord.HOSTING_TYPE_SERVICE;
        int schedGroup3 = schedGroup;
        boolean trackedProcState2 = trackedProcState;
    L186:
        int clientAdj3 = clientAdj;
        if (cr.notHasFlag(8388612) == false) goto L221;
        int curSchedGroup = cstate3.getCurrentSchedulingGroup();
        if (curSchedGroup <= schedGroup3) goto L197;
        if (curSchedGroup == 10) goto L197;
        if (cr.hasFlag(64) == false) goto L195;
        schedGroup3 = curSchedGroup;
        goto L197
    L195:
        schedGroup3 = 2;
    L197:
        if (clientProcState >= 2) goto L211;
        if (cr.hasFlag(268435456) == false) goto L202;
        clientProcState = 4;
        int schedGroup4 = schedGroup3;
    L219:
        schedGroup3 = schedGroup4;
    L229:
        if (cr.hasFlag(524288) == false) goto L239;
        if (clientIsSystem == false) goto L239;
        schedGroup3 = 3;
        if (dryRun == false) goto L238;
        prevSchedGroup = schedGroup;
        if (prevSchedGroup >= 3) goto L240;
        return true;
    L240:
        if (trackedProcState2 == true) goto L243;
        if (dryRun == true) goto L243;
        cr.trackProcState(clientProcState, r2.mAdjSeq);
    L243:
        if (logUid5 <= clientProcState) goto L251;
        logUid5 = clientProcState;
        if (state.setCurRawProcState(logUid5, dryRun) == false) goto L248;
        return true;
    L248:
        if (adjType != null) goto L250;
        String adjType2 = HostingRecord.HOSTING_TYPE_SERVICE;
    L252:
        int schedGroup5 = schedGroup3;
        if (logUid5 < 7) goto L255;
    L258:
        if (adjType2 == null) goto L268;
        if (dryRun == true) goto L268;
        state.setAdjType(adjType2);
        state.setAdjTypeCode(2);
        state.setAdjSource(client2);
        state.setAdjSourceProcState(clientProcState);
        state.setAdjTarget(cr.binding.service.instanceName);
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L266;
        int logUid6 = logUid4;
        if (logUid6 == appUid) goto L267;
        logUid4 = logUid6;
        int procState3 = logUid5;
        r3 = "ActivityManager";
    L269:
        adj = adj5;
        adj2 = procState3;
        schedGroup = schedGroup5;
        capability3 = capability5;
        logUid2 = logUid4;
        clientAdj = clientAdj3;
    L267:
        logUid4 = logUid6;
        StringBuilder r6 = new StringBuilder();
        procState3 = logUid5;
        r6.append("Raise to ");
        r6.append(adjType2);
        r6.append(": ");
        r6.append(r1);
        r6.append(", due to ");
        r6.append(client2);
        r6.append(" adj=");
        r6.append(adj5);
        r6.append(" procState=");
        r6.append(ProcessList.makeProcStateString(procState3));
        r3 = "ActivityManager";
        r2.reportOomAdjMessageLocked(r3, r6.toString());
        goto L269
    L266:
        logUid6 = logUid4;
    L268:
        procState3 = logUid5;
        r3 = "ActivityManager";
        goto L269
    L255:
        if (cr.hasFlag(536870912) == false) goto L258;
        if (dryRun == true) goto L258;
        r1.setPendingUiClean(true);
        goto L258
    L250:
        adjType2 = adjType;
        goto L252
    L251:
        adjType2 = adjType;
        goto L252
    L238:
        prevSchedGroup = schedGroup;
        state.setScheduleLikeTopApp(true);
    L239:
        prevSchedGroup = schedGroup;
        goto L240
    L202:
        if (cr.hasFlag(67108864) == false) goto L205;
        clientProcState = 5;
        schedGroup4 = schedGroup3;
        goto L219
    L205:
        if (r2.isDeviceFullyAwake() == true) goto L207;
    L209:
        clientProcState = 6;
        schedGroup4 = schedGroup3;
        goto L219
    L207:
        if (cr.hasFlag(33554432) == false) goto L209;
        clientProcState = 5;
        schedGroup4 = schedGroup3;
        goto L219
    L211:
        if (clientProcState != 2) goto L218;
        clientProcState = 3;
        boolean enabled = cstate3.getCachedCompatChange(0);
        if (enabled == false) goto L217;
        schedGroup4 = schedGroup3;
        if (cr.hasFlag(4096) == false) goto L219;
        capability5 = capability5 | cstate3.getCurCapability();
        goto L219
    L217:
        schedGroup4 = schedGroup3;
        capability5 = capability5 | cstate3.getCurCapability();
        goto L219
    L218:
        schedGroup4 = schedGroup3;
        goto L219
    L221:
        if (cr.notHasFlag(8388608) == false) goto L226;
        if (clientProcState >= 8) goto L229;
        clientProcState = 8;
        goto L229
    L226:
        if (clientProcState >= 7) goto L229;
        clientProcState = 7;
        goto L229
    L183:
        schedGroup3 = schedGroup;
        trackedProcState2 = trackedProcState;
        goto L186
    L179:
        if (r1.isolated == false) goto L181;
        newAdj = clientAdj + 1;
        goto L181
    L173:
        if (state.isCached() == false) goto L177;
        if (dryRun == false) goto L177;
        return true;
    L136:
        if (cr.hasFlag(65536) == false) goto L144;
        if (cr.notHasFlag(4) == false) goto L144;
        if (clientAdj >= 200) goto L144;
        lbAdj = 200;
        if (adj5 < 200) goto L144;
        newAdj = 201;
        logUid5 = procState2;
    L144:
        if (cr.hasFlag(65536) == false) goto L152;
        if (cr.hasFlag(4) == false) goto L152;
        if (clientAdj >= 200) goto L152;
        lbAdj = 227;
        if (adj5 < 227) goto L152;
        newAdj = FrameworkStatsLog.CAMERA_ACTION_EVENT;
        logUid5 = procState2;
    L152:
        if (cr.hasFlag(1073741824) == false) goto L158;
        if (clientAdj >= 200) goto L158;
        lbAdj = 200;
        if (adj5 < 200) goto L158;
        newAdj = 200;
        logUid5 = procState2;
    L158:
        if (clientAdj != 901) goto L160;
        newAdj = adj5;
        logUid5 = procState2;
        goto L171
    L160:
        if (clientAdj < 200) goto L163;
        newAdj = clientAdj;
        logUid5 = procState2;
        goto L171
    L163:
        if (cr.hasFlag(268435456) == false) goto L167;
        if (clientAdj > 100) goto L167;
        if (adj5 <= 100) goto L167;
        newAdj = 100;
        logUid5 = procState2;
    L167:
        if (adj5 <= 100) goto L169;
        newAdj = Math.max(clientAdj, lbAdj);
        logUid5 = procState2;
        goto L171
    L169:
        newAdj = adj5;
        logUid5 = procState2;
        goto L171
    L122:
        if (clientAdj < (-700)) goto L124;
        newAdj = clientAdj;
        logUid4 = logUid4;
        logUid5 = procState2;
        goto L171
    L124:
        newAdj = ProcessList.PERSISTENT_SERVICE_ADJ;
        schedGroup = 2;
        if (dryRun == true) goto L128;
        cr.trackProcState(0, r2.mAdjSeq);
    L128:
        trackedProcState = true;
        logUid5 = 0;
        goto L171
    L112:
        if (state.getCachedIsHomeProcess() == true) goto L119;
        if (clientAdj <= CACHING_UI_SERVICE_CLIENT_ADJ_THRESHOLD) goto L119;
        if (adj5 < 900) goto L185;
        adjType = "cch-bound-ui-services";
        logUid4 = logUid4;
        schedGroup3 = schedGroup;
        trackedProcState2 = false;
        logUid5 = procState2;
    L185:
        schedGroup3 = schedGroup;
        trackedProcState2 = false;
        logUid5 = procState2;
        goto L186
    L84:
        if (clientAdj >= 900) goto L90;
        if (r1.mOptRecord.setShouldNotFreeze(true, dryRun, r1.mOptRecord.shouldNotFreezeReason() | 4, r2.mAdjSeq) == false) goto L90;
        return true;
    L90:
        if (state.hasShownUi() == true) goto L92;
    L101:
        logUid4 = logUid;
        if (now < (cr.binding.service.lastActivity + r2.mConstants.MAX_SERVICE_INACTIVITY)) goto L107;
        if (adj5 <= clientAdj) goto L105;
        adjType = "cch-bound-services";
    L105:
        clientAdj = adj5;
        clientProcState = clientProcState;
        goto L108
    L92:
        if (state.getCachedIsHomeProcess() == true) goto L101;
        if (adj5 <= clientAdj) goto L96;
        adjType = "cch-bound-ui-services";
    L96:
        if (state.isCached() == false) goto L100;
        if (dryRun == false) goto L100;
        return true;
    L100:
        clientAdj = adj5;
        clientProcState = procState2;
        logUid4 = logUid;
        goto L108
    L77:
        adj5 = adj4;
        r1 = app;
        procState2 = procState;
        cstate3 = cstate;
        goto L79
    L70:
        if (app.isSdkSandbox == false) goto L72;
        capability5 = capability2 | 64;
        goto L73
    L61:
        if (clientProcState > 6) goto L65;
        adj4 = adj;
        if (cr.hasFlag(4294967296L) == false) goto L68;
        capability2 = capability2 | 32;
        goto L68
    L65:
        adj4 = adj;
        goto L68
    L21:
        r0 = false;
        goto L22
    L8:
        if (app.isSdkSandbox == true) goto L10;
    L12:
        ProcessRecord client3 = client;
        ProcessStateRecord cstate4 = cstate;
    L13:
        if (computeClients == false) goto L15;
        computeOomAdjLSP(client3, cachedAdj, topApp, doingAll, now, cycleReEval, true, oomAdjReason, true);
        r2 = this;
        ProcessStateRecord cstate5 = cstate4;
    L16:
        client2 = client3;
        cstate = cstate5;
        goto L18
    L15:
        r2 = this;
        ProcessStateRecord cstate6 = cstate4;
        cstate5 = cstate6;
        cstate5.setCurRawAdj(cstate6.getCurAdj());
        cstate5.setCurRawProcState(cstate5.getCurProcState());
        goto L16
    L10:
        if (cr.binding.attributedClient == null) goto L12;
        ProcessRecord client4 = cr.binding.attributedClient;
        client3 = client4;
        cstate4 = client4.mState;
        goto L13
    }

    public boolean computeProviderHostOomAdjLSP(ContentProviderConnection conn, ProcessRecord app, ProcessRecord client, long now, ProcessRecord topApp, boolean doingAll, boolean cycleReEval, boolean computeClients, int oomAdjReason, int cachedAdj, boolean couldRecurse, boolean dryRun) {
        if (app.isPendingFinishAttach() == false) goto L5;
        return false;
    L5:
        ProcessStateRecord state = app.mState;
        ProcessStateRecord cstate = client.mState;
        if (client != app) goto L8;
        return false;
    L8:
        if (couldRecurse == false) goto L18;
        if (computeClients == false) goto L11;
        computeOomAdjLSP(client, cachedAdj, topApp, doingAll, now, cycleReEval, true, oomAdjReason, true);
        ProcessRecord r6 = client;
        ProcessStateRecord cstate2 = cstate;
    L15:
        OomAdjuster r0 = this;
        if (r0.shouldSkipDueToCycle(app, cstate2, state.getCurRawProcState(), state.getCurRawAdj(), cycleReEval) == false) goto L19;
        return false;
    L19:
        SysOptBridge.getFactory().getFreezeController().updateImportantUids(r6, app);
        int clientAdj = cstate2.getCurRawAdj();
        int clientProcState = cstate2.getCurRawProcState();
        int adj = state.getCurRawAdj();
        int procState = state.getCurRawProcState();
        int schedGroup = state.getCurrentSchedulingGroup();
        int capability = state.getCurCapability();
        int appUid = app.info.uid;
        ProcessStateRecord cstate3 = cstate2;
        int logUid = r0.mService.mCurOomAdjUid;
        int capability2 = (capability | r0.getBfslCapabilityFromClient(r6)) | getCpuCapabilityFromClient(conn, r6);
        if (clientProcState < 16) goto L23;
        clientProcState = 19;
    L23:
        if (r6.mOptRecord.shouldNotFreeze() == false) goto L29;
        ProcessCachedOptimizerRecord r8 = app.mOptRecord;
        int r10 = app.mOptRecord.shouldNotFreezeReason() | r6.mOptRecord.shouldNotFreezeReason();
        int prevRawAdj = r0.mAdjSeq;
        if (r8.setShouldNotFreeze(true, dryRun, r10, prevRawAdj) == false) goto L29;
        return true;
    L29:
        if (dryRun == false) goto L31;
    L43:
        String adjType = null;
        if (adj > clientAdj) goto L46;
    L64:
        if (clientProcState > 4) goto L71;
        if (adjType != null) goto L68;
        adjType = "provider";
    L68:
        if (clientProcState != 2) goto L70;
        clientProcState = 3;
        goto L71
    L70:
        clientProcState = 5;
    L71:
        if (dryRun == true) goto L73;
        conn.trackProcState(clientProcState, r0.mAdjSeq);
    L73:
        if (procState <= clientProcState) goto L79;
        procState = clientProcState;
        if (state.setCurRawProcState(procState, dryRun) == false) goto L79;
        return true;
    L79:
        if (cstate3.getCurrentSchedulingGroup() > schedGroup) goto L81;
    L83:
        if (adjType == null) goto L91;
        if (dryRun == true) goto L91;
        state.setAdjType(adjType);
        state.setAdjTypeCode(1);
        state.setAdjSource(r6);
        state.setAdjSourceProcState(clientProcState);
        state.setAdjTarget(conn.provider.name);
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ_REASON == true) goto L90;
        if (logUid == appUid) goto L90;
        ProcessRecord r12 = app;
    L93:
        if (procState <= 5) goto L95;
        int capability3 = capability2 & (-17);
    L96:
        if (dryRun == false) goto L114;
        int prevRawAdj2 = adj;
        if (adj < prevRawAdj2) goto L113;
        int clientAdj2 = procState;
        if (procState < clientAdj2) goto L124;
        int logUid2 = schedGroup;
        if (schedGroup > logUid2) goto L123;
        int clientProcState2 = capability3 & (-129);
        int prevFiltered = capability & (-129);
        if (clientProcState2 == prevFiltered) goto L115;
        int curFiltered = clientProcState2 & prevFiltered;
        if (curFiltered != prevFiltered) goto L115;
        return true;
    L115:
        if (adj >= prevRawAdj2) goto L117;
        schedGroup = r0.setIntermediateAdjLSP(r12, adj, prevRawAdj2, schedGroup);
    L117:
        if (procState >= clientAdj2) goto L119;
        r0.setIntermediateProcStateLSP(r12, procState, clientAdj2);
    L119:
        if (schedGroup <= logUid2) goto L121;
        r0.setIntermediateSchedGroupLSP(state, schedGroup);
    L121:
        state.setCurCapability(capability3);
        return false;
    L123:
        return true;
    L124:
        return true;
    L113:
        return true;
    L114:
        clientAdj2 = r10;
        prevRawAdj2 = r9;
        logUid2 = schedGroup;
        goto L115
    L95:
        capability3 = capability2;
    L90:
        StringBuilder r9 = new StringBuilder();
        r9.append("Raise to ");
        r9.append(adjType);
        r9.append(": ");
        r12 = app;
        r9.append(r12);
        r9.append(", due to ");
        r9.append(r6);
        r9.append(" adj=");
        r9.append(adj);
        r9.append(" procState=");
        r9.append(ProcessList.makeProcStateString(procState));
        r0.reportOomAdjMessageLocked("ActivityManager", r9.toString());
    L91:
        r12 = app;
        goto L93
    L81:
        if (cstate3.getCurrentSchedulingGroup() == 10) goto L83;
        schedGroup = 2;
        goto L83
    L46:
        if (state.hasShownUi() == true) goto L48;
    L52:
        adj = Math.max(clientAdj, 0);
        if (state.setCurRawAdj(adj, dryRun) == false) goto L56;
        return true;
    L56:
        adjType = "provider";
    L58:
        if (state.isCached() == false) goto L64;
        if (cstate3.isCached() == true) goto L64;
        if (dryRun == false) goto L64;
        return true;
    L48:
        if (state.getCachedIsHomeProcess() == true) goto L52;
        if (clientAdj <= 200) goto L52;
        adjType = "cch-ui-provider";
        goto L58
    L31:
        if (state.isCurBoundByNonBgRestrictedApp() == false) goto L33;
    L41:
        boolean r11 = true;
    L42:
        state.setCurBoundByNonBgRestrictedApp(r11);
        goto L43
    L33:
        if (cstate3.isCurBoundByNonBgRestrictedApp() == true) goto L41;
        if (clientProcState <= 3) goto L41;
        if (clientProcState == 4) goto L38;
    L40:
        r11 = false;
        goto L42
    L38:
        if (cstate3.isBackgroundRestricted() == true) goto L40;
    L11:
        r6 = client;
        if (couldRecurse == false) goto L14;
        cstate2 = cstate;
        cstate2.setCurRawAdj(cstate.getCurAdj());
        cstate2.setCurRawProcState(cstate2.getCurProcState());
        goto L15
    L14:
        cstate2 = cstate;
        goto L15
    L18:
        cstate2 = cstate;
        r6 = client;
        r0 = this;
        goto L19
    }

    protected int getDefaultCapability(ProcessRecord app, int procState) {
        int networkCapabilities = NetworkPolicyManager.getDefaultProcessNetworkCapabilities(procState);
        switch(procState) {
            case 0: goto L13;
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L10;
            case 4: goto L6;
            default: goto L4;
        };
    L4:
        int baseCapabilities = 0;
    L15:
        return baseCapabilities | networkCapabilities;
    L13:
        baseCapabilities = 255;
        goto L15
    L6:
        if (app.getActiveInstrumentation() == null) goto L8;
        baseCapabilities = 6;
        goto L15
    L8:
        baseCapabilities = 0;
        goto L15
    L10:
        if (app.getActiveInstrumentation() == null) goto L12;
        baseCapabilities = 22;
        goto L15
    L12:
        baseCapabilities = 16;
        goto L15
    }

    private static int getCpuCapability(ProcessRecord app, long nowUptime, boolean hasForegroundActivities) {
        UidRecord uidRec = app.getUidRecord();
        if (uidRec != null) goto L5;
    L7:
        if (hasForegroundActivities == false) goto L10;
        return 128;
    L10:
        if (app.mServices.hasForegroundServices() == false) goto L13;
        return 128;
    L13:
        if (app.mReceivers.numberOfCurReceivers() <= 0) goto L16;
        return 128;
    L16:
        if (app.hasActiveInstrumentation() == false) goto L18;
        return 128;
    L18:
        return 0;
    L5:
        if (uidRec.isCurAllowListed() == false) goto L7;
        return 128;
    }

    protected int getBfslCapabilityFromClient(ProcessRecord client) {
        if (client.mState.getCurProcState() >= 4) goto L6;
        return 16;
    L6:
        return client.mState.getCurCapability() & 16;
    }

    private static int getCpuCapabilityFromClient(OomAdjusterModernImpl.Connection conn, ProcessRecord client) {
        if (conn == null) goto L9;
        if (conn.transmitsCpuTime() == true) goto L9;
        return 0;
    L9:
        return client.mState.getCurCapability() & 128;
    }

    private boolean shouldSkipDueToCycle(ProcessRecord app, ProcessStateRecord client, int procState, int adj, boolean cycleReEval) {
        if (client.containsCycle() == false) goto L15;
        app.mState.setContainsCycle(true);
        this.mProcessesInCycle.add(app);
        if (client.getCompletedAdjSeq() >= this.mAdjSeq) goto L15;
        if (cycleReEval == true) goto L8;
        return false;
    L8:
        if (client.getCurRawProcState() < procState) goto L15;
        if (client.getCurRawAdj() < adj) goto L15;
        if ((client.getCurCapability() & app.mState.getCurCapability()) != client.getCurCapability()) goto L15;
        return true;
    L15:
        return false;
    }

    void reportOomAdjMessageLocked(String tag, String msg) {
        Slog.d(tag, msg);
        Object r0 = this.mService.mOomAdjObserverLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mService.mCurOomAdjObserver == null) goto L9;
        this.mService.mUiHandler.obtainMessage(70, msg).sendToTarget();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    void onWakefulnessChanged(int wakefulness) {
        this.mCachedAppOptimizer.onWakefulnessChanged(wakefulness);
    }

    protected boolean applyOomAdjLSP(ProcessRecord app, boolean doingAll, long now, long nowElapsed, int oomAdjReason) {
        return applyOomAdjLSP(app, doingAll, now, nowElapsed, oomAdjReason, false);
    }

    protected boolean applyOomAdjLSP(final ProcessRecord app, boolean doingAll, long now, long nowElapsed, int oomAdjReson, boolean isBatchingOomAdj) {
        boolean success = true;
        ProcessStateRecord state = app.mState;
        UidRecord uidRec = app.getUidRecord();
        if (state.getCurRawAdj() == state.getSetRawAdj()) goto L6;
        state.setSetRawAdj(state.getCurRawAdj());
    L6:
        if (app.mPid <= 0) goto L8;
        int r0 = app.mPid;
    L9:
        int _pid = r0;
        ProcessFreezerManager freezer = ProcessFreezerManager.getInstance();
        if (freezer == null) goto L28;
        if (freezer.useFreezerManager() == false) goto L28;
        if (state.getSetAdj() < 0) goto L21;
        if (state.getSetAdj() > 100) goto L21;
        if (state.getCurAdj() <= 100) goto L21;
        freezer.startUnfreeze(app.processName, 1);
    L21:
        if (state.getSetAdj() < state.getCurAdj()) goto L28;
        if (state.getCurAdj() > 100) goto L28;
        if (freezer.checkNeedFreezeProcessLocked(app) == false) goto L28;
        freezer.startUnfreezeService(app, 5);
    L28:
        if (state.getCurAdj() == state.getSetAdj()) goto L30;
        this.mCachedAppOptimizer.onOomAdjustChanged(state.getSetAdj(), state.getCurAdj(), app);
    L30:
        int oldOomAdj = state.getSetAdj();
        if (state.getCurAdj() != state.getSetAdj()) goto L33;
        uidRec = uidRec;
        oldOomAdj = oldOomAdj;
    L90:
        if (app.info == null) goto L101;
        ApplicationInfoSysEx sysEx = app.info.getSysEx();
        int uidPrefetchState = SysOptBridge.getFactory().getSysPrefetchService().getPrefetchStateByInfo(app.info.packageName, app.info.uid);
        boolean inPrefetchState = SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(uidPrefetchState);
        if (sysEx != null) goto L94;
    L97:
        boolean isNonTouchDownPrefetch = true;
    L98:
        if (inPrefetchState == false) goto L101;
        if (isNonTouchDownPrefetch == false) goto L101;
        app.mState.setCurrentSchedulingGroup(0);
        goto L101
    L94:
        if (sysEx.prefetchReason != 6) goto L97;
        isNonTouchDownPrefetch = false;
    L101:
        int curSchedGroup = state.getCurrentSchedulingGroup();
        if (app.getWaitingToKill() == null) goto L111;
        if (app.mReceivers.numberOfCurReceivers() != 0) goto L111;
        if (ActivityManager.isProcStateBackground(state.getCurProcState()) == false) goto L111;
        if (state.hasStartedServices() == true) goto L111;
        app.killLocked(app.getWaitingToKill(), 10, 22, true);
        boolean success2 = false;
    L180:
        if (state.hasRepForegroundActivities() == state.hasForegroundActivities()) goto L182;
        state.setRepForegroundActivities(state.hasForegroundActivities());
        int changes = 0 | 1;
        int changes2 = changes;
    L183:
        updateAppFreezeStateLSP(app, oomAdjReson, false, oldOomAdj);
        if (state.getReportedProcState() == state.getCurProcState()) goto L191;
        state.setReportedProcState(state.getCurProcState());
        if (app.getThread() == null) goto L191;
        app.getThread().setProcessState(state.getReportedProcState());     // Catch: RemoteException -> L189
    L191:
        if (state.getSetProcState() != 20) goto L193;
    L196:
        state.setLastStateTime(now);
        if (ActivityManagerDebugConfig.DEBUG_PSS == false) goto L199;
        Slog.d("ActivityManager", "Process state change from " + ProcessList.makeProcStateString(state.getSetProcState()) + " to " + ProcessList.makeProcStateString(state.getCurProcState()) + " next pss in " + (app.mProfile.getNextPssTime() - now) + ": " + app);
    L199:
        boolean forceUpdatePssTime = true;
    L200:
        Object r3 = this.mService.mAppProfiler.mProfilerLock;
        monitor-enter(r3);
        app.mProfile.updateProcState(app.mState);     // Catch: Throwable -> L323
        Object r18 = r3;
        this.mService.mAppProfiler.updateNextPssTimeLPf(state.getCurProcState(), app.mProfile, now, forceUpdatePssTime);     // Catch: Throwable -> L317
        monitor-exit(r18);     // Catch: Throwable -> L317
        int oldProcState = state.getSetProcState();
        if (state.getSetProcState() != state.getCurProcState()) goto L213;
        success2 = success2;
        long r9 = nowElapsed;
        if (state.hasReportedInteraction() == false) goto L264;
        boolean fgsInteractionChangeEnabled = state.getCachedCompatChange(2);
        if (fgsInteractionChangeEnabled == false) goto L259;
        long interactionThreshold = this.mConstants.USAGE_STATS_INTERACTION_INTERVAL_POST_S;
    L261:
        if ((r9 - state.getInteractionEventTime()) <= interactionThreshold) goto L272;
        maybeUpdateUsageStatsLSP(app, r9);
    L272:
        if (state.getCurCapability() == state.getSetCapability()) goto L274;
        state.setSetCapability(state.getCurCapability());
    L274:
        boolean curBoundByNonBgRestrictedApp = state.isCurBoundByNonBgRestrictedApp();
        if (curBoundByNonBgRestrictedApp == state.isSetBoundByNonBgRestrictedApp()) goto L281;
        state.setSetBoundByNonBgRestrictedApp(curBoundByNonBgRestrictedApp);
        if (curBoundByNonBgRestrictedApp == true) goto L281;
        if (state.isBackgroundRestricted() == false) goto L281;
        this.mService.mHandler.post(new OomAdjuster$$ExternalSyntheticLambda1(this, app));
    L281:
        if (changes2 == 0) goto L291;
        if (ActivityManagerDebugConfig.DEBUG_PROCESS_OBSERVERS == false) goto L286;
        Slog.i("ActivityManager", "Changes in " + app + ": " + changes2);
    L286:
        this.mProcessList.enqueueProcessChangeItemLocked(_pid, app.info.uid, changes2, state.hasRepForegroundActivities());
        if (ActivityManagerDebugConfig.DEBUG_PROCESS_OBSERVERS == false) goto L291;
        Slog.i("ActivityManager", "Enqueued process change item for " + app.toShortString() + ": changes=" + changes2 + " foreground=" + state.hasRepForegroundActivities() + " type=" + state.getAdjType() + " source=" + state.getAdjSource() + " target=" + state.getAdjTarget());
    L291:
        if (state.isCached() == true) goto L293;
    L306:
        state.setSetCached(state.isCached());
        state.setSetNoKillOnBgRestrictedAndIdle(state.shouldNotKillOnBgRestrictedAndIdle());
        if (oldProcState != state.getSetProcState()) goto L313;
        if (oldOomAdj != state.getSetAdj()) goto L313;
    L316:
        return success2;
    L313:
        if (this.mLogger.shouldLog(app.uid) == false) goto L316;
        this.mLogger.logProcStateChanged(app.uid, app.getPid(), state.getSetProcState(), oldProcState, state.getSetAdj(), oldOomAdj);
        goto L316
    L293:
        if (state.shouldNotKillOnBgRestrictedAndIdle() == true) goto L306;
        if (state.isSetCached() == true) goto L297;
    L298:
        state.setLastCanKillOnBgRestrictedAndIdleTime(r9);
        if (this.mService.mDeterministicUidIdle == true) goto L303;
        if (this.mService.mHandler.hasMessages(58) == true) goto L306;
    L303:
        if (this.mLogger.shouldLog(app.uid) == false) goto L305;
        this.mLogger.logScheduleUidIdle2(uidRec.getUid(), app.getPid(), this.mConstants.mKillBgRestrictedAndCachedIdleSettleTimeMs);
    L305:
        this.mService.mHandler.sendEmptyMessageDelayed(58, this.mConstants.mKillBgRestrictedAndCachedIdleSettleTimeMs);
        goto L306
    L297:
        if (state.isSetNoKillOnBgRestrictedAndIdle() == false) goto L306;
    L259:
        interactionThreshold = this.mConstants.USAGE_STATS_INTERACTION_INTERVAL_PRE_S;
        goto L261
    L264:
        boolean fgsInteractionChangeEnabled2 = state.getCachedCompatChange(2);
        if (fgsInteractionChangeEnabled2 == false) goto L267;
        long interactionThreshold2 = this.mConstants.SERVICE_USAGE_INTERACTION_TIME_POST_S;
    L269:
        if ((r9 - state.getFgInteractionTime()) <= interactionThreshold2) goto L272;
        maybeUpdateUsageStatsLSP(app, r9);
        goto L272
    L267:
        interactionThreshold2 = this.mConstants.SERVICE_USAGE_INTERACTION_TIME_PRE_S;
        goto L269
    L213:
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L215;
    L218:
        String msg = "Proc state change of " + app.processName + " to " + ProcessList.makeProcStateString(state.getCurProcState()) + " (" + state.getCurProcState() + "): " + state.getAdjType();
        reportOomAdjMessageLocked("ActivityManager", msg);
    L220:
        if (state.getSetProcState() >= 10) goto L222;
        boolean setImportant = true;
    L224:
        if (state.getCurProcState() >= 10) goto L226;
        boolean r1 = true;
    L227:
        boolean curImportant = r1;
        if (setImportant == false) goto L232;
        if (curImportant == true) goto L232;
        state.setWhenUnimportant(now);
        app.mProfile.mLastCpuTime.set(0);
    L232:
        r9 = nowElapsed;
        maybeUpdateUsageStatsLSP(app, r9);
        maybeUpdateLastTopTime(state, now);
        state.setSetProcState(state.getCurProcState());
        this.mOomAdjusterOptEx.setAppProcState(app, state.getSetProcState());
        if (app.uid >= 10000) goto L236;
        SysOptBridge.getFactory().getAppRecordManagerService().setSystemAppProcState(app, state.getSetProcState());
    L236:
        if (state.getSetProcState() < 14) goto L238;
        state.setNotCachedSinceIdle(false);
    L238:
        if (doingAll == true) goto L252;
        Object r4 = this.mService.mProcessStats.mLock;
        monitor-enter(r4);
        this.mService.setProcessTrackerStateLOSP(app, this.mService.mProcessStats.getMemFactorLocked());     // Catch: Throwable -> L246
        monitor-exit(r4);     // Catch: Throwable -> L246
    L246:
        th = th;
    L250:
        monitor-exit(r4);     // Catch: Throwable -> L246
        throw th;
    L248:
        th = th;
        goto L250
    L252:
        state.setProcStateChanged(true);
        goto L272
    L226:
        r1 = false;
        goto L227
    L222:
        setImportant = false;
        goto L224
    L215:
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == true) goto L218;
        if (this.mService.mCurOomAdjUid != app.uid) goto L220;
    L317:
        th = th;
    L341:
        monitor-exit(r18);     // Catch: Throwable -> L327
        throw th;
    L327:
        th = th;
    L319:
        th = th;
        r18 = r3;
    L321:
        th = th;
        r18 = r3;
    L323:
        th = th;
        r18 = r3;
        goto L341
    L193:
        if (ProcessList.procStatesDifferForMem(state.getCurProcState(), state.getSetProcState()) == true) goto L196;
        forceUpdatePssTime = false;
        goto L200
    L182:
        changes2 = 0;
    L111:
        if (state.getSetSchedGroup() == curSchedGroup) goto L177;
        int oldSchedGroup = state.getSetSchedGroup();
        state.setSetSchedGroup(curSchedGroup);
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L115;
    L118:
        String msg2 = "Setting sched group of " + app.processName + " to " + curSchedGroup + ": " + state.getAdjType();
        reportOomAdjMessageLocked("ActivityManager", msg2);
    L119:
        switch(curSchedGroup) {
            case 0: goto L127;
            case 1: goto L126;
            case 3: goto L125;
            case 4: goto L125;
            case 5: goto L124;
            case 10: goto L123;
            case 13: goto L122;
            case 15: goto L121;
            default: goto L120;
        };
    L120:
        int processGroup = -1;
    L128:
        this.mOomAdjusterOptEx.processListGroup2ProcessGroup(curSchedGroup, processGroup);
        if (oomadjusterthread_prio_initialized == false) goto L337;
        boolean r17 = false;
    L140:
        setAppAndChildProcessGroup(app, processGroup);
        int renderThreadTid = app.getRenderThreadTid();     // Catch: Exception -> L149
        int[] commonPoolTids = app.getCommonPoolTids();     // Catch: Exception -> L149
        if (curSchedGroup != 3) goto L163;
        if (oldSchedGroup == 3) goto L178;
        app.getWindowProcessController().onTopProcChanged();     // Catch: Exception -> L159
        if (app.useFifoUiScheduling() == false) goto L151;
        state.setSavedPriority(Process.getThreadPriority(_pid));     // Catch: Exception -> L149
        ActivityManagerService.setFifoPriority(app, true);     // Catch: Exception -> L149
    L156:
        this.mOomAdjusterOptEx.schedOptTopApp(true, app, renderThreadTid, commonPoolTids);     // Catch: Exception -> L149
        goto L178
    L151:
        this.mInjector.setThreadPriority(_pid, -10);     // Catch: Exception -> L159
        if (renderThreadTid == 0) goto L156;
        this.mInjector.setThreadPriority(renderThreadTid, -10);     // Catch: Exception -> L149 IllegalArgumentException -> L155
        goto L156
    L163:
        if (oldSchedGroup != 3) goto L178;
        if (curSchedGroup == 3) goto L178;
        app.getWindowProcessController().onTopProcChanged();     // Catch: Exception -> L149
        if (app.useFifoUiScheduling() == false) goto L168;
        ActivityManagerService.setFifoPriority(app, r17);     // Catch: Exception -> L149
        this.mInjector.setThreadPriority(_pid, state.getSavedPriority());     // Catch: Exception -> L149
    L169:
        if (renderThreadTid == 0) goto L171;
        this.mInjector.setThreadPriority(renderThreadTid, -4);     // Catch: Exception -> L149
    L171:
        this.mOomAdjusterOptEx.schedOptTopApp(false, app, renderThreadTid, commonPoolTids);     // Catch: Exception -> L149
        if (SysOptBridge.getFactory().getResMngConfig().isModuleEnable(IResMngConfig.FEAT_CPU_OPTIMIZE, IResMngConfig.MOD_SVP_SCENARIO_LIMIT_EXEMPT) == false) goto L178;
        SysOptBridge.getFactory().getSvpSenarioHandler().svpEndStarting(app.getPid());     // Catch: Exception -> L149
        goto L178
    L168:
        this.mInjector.setThreadPriority(_pid, 0);     // Catch: Exception -> L149
    L178:
        success2 = success;
        goto L180
    L337:
        Process.setUIFirstSchedEventTrack(Process.myPid(), this.mAdjusterThread.getThreadId(), 2, "system_server", false, 0);     // Catch: IllegalArgumentException -> L136
        oomadjusterthread_prio_initialized = true;     // Catch: IllegalArgumentException -> L136
        r17 = false;
        SysOptBridge.getFactory().getSvpCgroupManager().addSvpBackgroundCgroupThread(Process.myPid(), this.mAdjusterThread.getThreadId());     // Catch: IllegalArgumentException -> L134
    L134:
        e = e;
    L138:
        oomadjusterthread_prio_initialized = r17;
        Slog.i(TAG, "oomadj debug: adjusterThread set rt failed " + e);
    L136:
        e = e;
        r17 = false;
        goto L138
    L121:
        processGroup = 13;
        goto L128
    L122:
        processGroup = 12;
        goto L128
    L123:
        processGroup = 9;
        goto L128
    L124:
        processGroup = 8;
        goto L128
    L125:
        processGroup = 5;
        goto L128
    L126:
        processGroup = 7;
        goto L128
    L127:
        processGroup = 0;
        goto L128
    L115:
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == true) goto L118;
        if (this.mService.mCurOomAdjUid != app.uid) goto L119;
    L177:
        success = true;
        goto L178
    L33:
        if (this.mEnableBgt == true) goto L35;
    L56:
        if (isBatchingOomAdj == false) goto L61;
        if (this.mConstants.ENABLE_BATCHING_OOM_ADJ == false) goto L61;
        this.mProcsToOomAdj.add(app);
    L73:
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L75;
    L78:
        String msg3 = "Set " + _pid + " " + app.processName + " adj " + state.getCurAdj() + ": " + state.getAdjType();
        reportOomAdjMessageLocked("ActivityManager", msg3);
    L80:
        if (app.mSmtEx.adjHasReachedZero == false) goto L82;
    L84:
        state.setSetAdj(state.getCurAdj());
        if (uidRec == 0) goto L87;
        uidRec.noteProcAdjChanged();
    L87:
        state.setVerifiedAdj(ProcessList.INVALID_ADJ);
        goto L90
    L82:
        if (state.getCurAdj() != 0) goto L84;
        app.mSmtEx.adjHasReachedZero = true;
        goto L84
    L75:
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == true) goto L78;
        if (this.mService.mCurOomAdjUid != app.info.uid) goto L80;
    L61:
        if (this.mLazyLmkKillMainProc == false) goto L71;
        String packageName = app.info.packageName;
        String processName = app.processName;
        if (packageName.equals(processName) == false) goto L65;
        int isMainProc = 1;
    L67:
        if (app.info.isSystemApp() == false) goto L69;
        int isSystemApp = 1;
    L70:
        this.mInjector.setOomAdjExt(_pid, app.uid, app.mState.getCurAdj(), isSystemApp, isMainProc);
        goto L73
    L69:
        isSystemApp = 0;
        goto L70
    L65:
        isMainProc = 0;
        goto L67
    L71:
        this.mInjector.setOomAdj(_pid, app.uid, app.mState.getCurAdj());
        goto L73
    L35:
        if (state.getSetAdj() < 900) goto L46;
        if (state.getSetAdj() > 999) goto L46;
        if (state.getCurAdj() != 0) goto L46;
        if (state.hasForegroundActivities() == false) goto L46;
        Slog.d(TAG, "App adj change from cached state to fg state : " + app.getPid() + " " + app.processName);
        if (mPerf == null) goto L46;
        int[] fgAppPerfLockArgs = {1115815936, app.getPid()};
        mPerf.perfLockAcquire(10, fgAppPerfLockArgs);
    L46:
        if (state.getSetAdj() != 700) goto L56;
        if (state.getCurAdj() < 900) goto L56;
        if (state.getCurAdj() > 999) goto L56;
        if (app.hasActivities() == false) goto L56;
        Slog.d(TAG, "App adj change from previous state to cached state : " + app.getPid() + " " + app.processName);
        if (mPerf == null) goto L56;
        int[] bgAppPerfLockArgs = {1115832320, app.getPid()};
        mPerf.perfLockAcquire(10, bgAppPerfLockArgs);
        goto L56
    L8:
        r0 = app.getSmtEx().pid;
        goto L9
    }

    private /* synthetic */ void lambda$applyOomAdjLSP$1(ProcessRecord app) {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mService.mServices.stopAllForegroundServicesLocked(app.uid, app.info.packageName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void setAttachingProcessStatesLSP(ProcessRecord app) {
        int initialSchedGroup = 2;
        int initialProcState = 19;
        int initialCapability = 0;
        ProcessStateRecord state = app.mState;
        int prevProcState = state.getCurProcState();
        int prevAdj = state.getCurRawAdj();
        if (state.hasForegroundActivities() == true) goto L17;
    L15:
        state.setCurrentSchedulingGroup(initialSchedGroup);
        state.setCurProcState(initialProcState);
        state.setCurRawProcState(initialProcState);
        state.setCurCapability(initialCapability);
        state.setCurAdj(0);
        state.setCurRawAdj(0);
        state.setForcingToImportant(null);
        state.setHasShownUi(false);
        onProcessStateChanged(app, prevProcState);
        onProcessOomAdjChanged(app, prevAdj);
        return;
    L17:
        app.getWindowProcessController().onTopProcChanged();     // Catch: Exception -> L7
        if (app.useFifoUiScheduling() == false) goto L9;
        ActivityManagerService.scheduleAsFifoPriority(app.getPid(), true);     // Catch: Exception -> L7
    L10:
        if (isScreenOnOrAnimatingLocked(state) == false) goto L13;
        initialSchedGroup = 3;
        initialProcState = 2;
    L13:
        initialCapability = 255;
        goto L15
    L9:
        this.mInjector.setThreadPriority(app.getPid(), -10);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        Slog.w(TAG, "Failed to pre-set top priority to " + app + " " + e);
        goto L15
    }

    void maybeUpdateUsageStats(ProcessRecord app, long nowElapsed) {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityManagerGlobalLock r1 = this.mProcLock;     // Catch: Throwable -> L12
        ActivityManagerService.boostPriorityForProcLockedSection();     // Catch: Throwable -> L12
        monitor-enter(r1);     // Catch: Throwable -> L12
        maybeUpdateUsageStatsLSP(app, nowElapsed);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L14:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void maybeUpdateUsageStatsLSP(ProcessRecord app, long nowElapsed) {
        ProcessStateRecord state = app.mState;
        if (ActivityManagerDebugConfig.DEBUG_USAGE_STATS == false) goto L6;
        Slog.d(TAG, "Checking proc [" + Arrays.toString(app.getPackageList()) + "] state changes: old = " + state.getSetProcState() + ", new = " + state.getCurProcState());
    L6:
        if (this.mService.mUsageStatsService != null) goto L8;
        return;
    L8:
        boolean fgsInteractionChangeEnabled = state.getCachedCompatChange(2);
        if (ActivityManager.isProcStateConsideredInteraction(state.getCurProcState()) == false) goto L11;
        boolean isInteraction = true;
        state.setFgInteractionTime(0);
    L27:
        if (fgsInteractionChangeEnabled == false) goto L29;
        long interactionThreshold = this.mConstants.USAGE_STATS_INTERACTION_INTERVAL_POST_S;
    L31:
        if (isInteraction == true) goto L33;
    L42:
        state.setReportedInteraction(isInteraction);
        if (isInteraction == true) goto L47;
        state.setInteractionEventTime(0);
        return;
    L47:
        return;
    L33:
        if (state.hasReportedInteraction() == true) goto L35;
    L36:
        state.setInteractionEventTime(nowElapsed);
        String[] packages = app.getPackageList();
        if (packages == null) goto L42;
        int i = 0;
    L40:
        if (i >= packages.length) goto L42;
        this.mService.mUsageStatsService.reportEvent(packages[i], app.userId, 6);
        i = i + 1;
        goto L40
    L35:
        if ((nowElapsed - state.getInteractionEventTime()) <= interactionThreshold) goto L42;
    L29:
        interactionThreshold = this.mConstants.USAGE_STATS_INTERACTION_INTERVAL_PRE_S;
        goto L31
    L11:
        boolean r11 = false;
        if (state.getCurProcState() > 4) goto L24;
        if (state.getFgInteractionTime() != 0) goto L16;
        state.setFgInteractionTime(nowElapsed);
        isInteraction = false;
        goto L27
    L16:
        if (fgsInteractionChangeEnabled == false) goto L18;
        long interactionTime = this.mConstants.SERVICE_USAGE_INTERACTION_TIME_POST_S;
    L20:
        if (nowElapsed <= (state.getFgInteractionTime() + interactionTime)) goto L22;
        r11 = true;
    L22:
        isInteraction = r11;
        goto L27
    L18:
        interactionTime = this.mConstants.SERVICE_USAGE_INTERACTION_TIME_PRE_S;
        goto L20
    L24:
        if (state.getCurProcState() > 6) goto L26;
        r11 = true;
    L26:
        isInteraction = r11;
        state.setFgInteractionTime(0);
        goto L27
    }

    private void maybeUpdateLastTopTime(ProcessStateRecord state, long nowUptime) {
        if (state.getSetProcState() <= 2) goto L5;
        return;
    L5:
        if (state.getCurProcState() <= 2) goto L9;
        state.setLastTopTime(nowUptime);
        return;
    }

    void idleUidsLocked() {
        int N = this.mActiveUids.size();
        this.mService.mHandler.removeMessages(58);
        if (N > 0) goto L5;
        return;
    L5:
        long nowElapsed = this.mInjector.getElapsedRealtimeMillis();
        long maxBgTime = nowElapsed - this.mConstants.BACKGROUND_SETTLE_TIME;
        if (this.mService.mLocalPowerManager == null) goto L8;
        this.mService.mLocalPowerManager.startUidChanges();
    L8:
        int i = N - 1;
        long nextTime = 0;
        boolean shouldLogMisc = false;
    L9:
        long r12 = 0;
        if (i < 0) goto L39;
        UidRecord uidRec = this.mActiveUids.valueAt(i);
        long bgTime = uidRec.getLastBackgroundTime();
        long idleTime = uidRec.getLastIdleTimeIfStillIdle();
        if (bgTime <= 0) goto L37;
        if (uidRec.isIdle() == false) goto L18;
        if (idleTime != 0) goto L37;
    L18:
        if (bgTime > maxBgTime) goto L30;
        EventLogTags.writeAmUidIdle(uidRec.getUid());
        ActivityManagerGlobalLock r13 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r13);
        uidRec.setIdle(true);     // Catch: Throwable -> L25
        uidRec.setSetIdle(true);     // Catch: Throwable -> L25
        uidRec.setLastIdleTime(nowElapsed);     // Catch: Throwable -> L25
        monitor-exit(r13);     // Catch: Throwable -> L25
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        this.mService.doStopUidLocked(uidRec.getUid(), uidRec);
    L25:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L30:
        if (nextTime != 0) goto L32;
    L33:
        nextTime = bgTime;
    L35:
        if (this.mLogger.shouldLog(uidRec.getUid()) == false) goto L37;
        shouldLogMisc = true;
        goto L37
    L32:
        if (nextTime <= bgTime) goto L35;
    L37:
        i = i - 1;
        goto L9
    L39:
        if (this.mService.mLocalPowerManager == null) goto L42;
        this.mService.mLocalPowerManager.finishUidChanges();
    L42:
        if (this.mService.mConstants.mKillBgRestrictedAndCachedIdle == false) goto L54;
        ArraySet<ProcessRecord> apps = this.mProcessList.mAppsInBackgroundRestricted;
        int i2 = 0;
        int size = apps.size();
    L44:
        if (i2 >= size) goto L53;
        long r17 = r12;
        long nowElapsed2 = nowElapsed;
        long bgTime2 = this.mProcessList.killAppIfBgRestrictedAndCachedIdleLocked(apps.valueAt(i2), nowElapsed) - this.mConstants.BACKGROUND_SETTLE_TIME;
        if (bgTime2 <= r17) goto L52;
        if (nextTime != r17) goto L50;
    L51:
        nextTime = bgTime2;
        goto L52
    L50:
        if (nextTime > bgTime2) goto L51;
    L52:
        i2 = i2 + 1;
        r12 = r17;
        nowElapsed = nowElapsed2;
        goto L44
    L53:
        long nowElapsed3 = nowElapsed;
        long r18 = r12;
    L56:
        if (nextTime <= r18) goto L74;
        long delay = (this.mConstants.BACKGROUND_SETTLE_TIME + nextTime) - nowElapsed3;
        if (shouldLogMisc == false) goto L60;
        this.mLogger.logScheduleUidIdle3(delay);
    L60:
        this.mService.mHandler.sendEmptyMessageDelayed(58, delay);
        return;
    L74:
        return;
    L54:
        nowElapsed3 = nowElapsed;
        r18 = 0;
        goto L56
    }

    void setUidTempAllowlistStateLSP(int uid, boolean onAllowlist) {
        UidRecord uidRec = this.mActiveUids.get(uid);
        if (uidRec != null) goto L5;
        return;
    L5:
        if (uidRec.isCurAllowListed() == onAllowlist) goto L13;
        uidRec.setCurAllowListed(onAllowlist);
        int i = uidRec.getNumOfProcs() - 1;
    L7:
        if (i < 0) goto L9;
        enqueueOomAdjTargetLocked(uidRec.getProcessRecordByIndex(i));
        i = i - 1;
        goto L7
    L9:
        updateOomAdjPendingTargetsLocked(10);
        return;
    }

    void dumpProcessListVariablesLocked(ProtoOutputStream proto) {
        proto.write(1120986464305L, this.mAdjSeq);
        proto.write(1120986464306L, this.mProcessList.getLruSeqLOSP());
        proto.write(1120986464307L, this.mNumNonCachedProcs);
        proto.write(1120986464309L, this.mNumServiceProcs);
        proto.write(1120986464310L, this.mNewNumServiceProcs);
    }

    void dumpSequenceNumbersLocked(PrintWriter pw) {
        pw.println("  mAdjSeq=" + this.mAdjSeq + " mLruSeq=" + this.mProcessList.getLruSeqLOSP());
    }

    void dumpProcCountsLocked(PrintWriter pw) {
        pw.println("  mNumNonCachedProcs=" + this.mNumNonCachedProcs + " (" + this.mProcessList.getLruSizeLOSP() + " total) mNumCachedHiddenProcs=" + this.mNumCachedHiddenProcs + " mNumServiceProcs=" + this.mNumServiceProcs + " mNewNumServiceProcs=" + this.mNewNumServiceProcs);
    }

    void dumpCachedAppOptimizerSettings(PrintWriter pw) {
        this.mCachedAppOptimizer.dump(pw);
    }

    void dumpCacheOomRankerSettings(PrintWriter pw) {
        this.mCacheOomRanker.dump(pw);
    }

    boolean getFreezePolicy(ProcessRecord proc) {
        if (proc.mOptRecord.shouldNotFreeze() == false) goto L6;
        return false;
    L6:
        if (proc.mOptRecord.isFreezeExempt() == false) goto L9;
        return false;
    L9:
        if (proc.mState.getCurAdj() < this.mConstants.FREEZER_CUTOFF_ADJ) goto L12;
        return true;
    L12:
        return false;
    }

    void updateAppFreezeStateLSP(ProcessRecord app, int oomAdjReason, boolean immediate, int oldOomAdj) {
        if (this.mCachedAppOptimizer.useFreezer() == true) goto L5;
        return;
    L5:
        boolean freezePolicy = getFreezePolicy(app);
        ProcessCachedOptimizerRecord opt = app.mOptRecord;
        ProcessStateRecord state = app.mState;
        boolean cpuCapabilityChanged = false;
        if (state.getCurAdj() < this.mConstants.FREEZER_CUTOFF_ADJ) goto L8;
        boolean r7 = true;
    L10:
        if (oldOomAdj < this.mConstants.FREEZER_CUTOFF_ADJ) goto L12;
        boolean r8 = true;
    L14:
        if ((r7 ^ r8) == false) goto L16;
    L19:
        boolean oomAdjChanged = true;
    L21:
        if (opt.shouldNotFreezeAdjSeq() != this.mAdjSeq) goto L23;
        boolean shouldNotFreezeChanged = true;
    L25:
        if ((app.mState.getCurCapability() & 128) != 128) goto L27;
        boolean hasCpuCapability = true;
    L29:
        if ((app.mState.getSetCapability() & 128) != 128) goto L31;
        boolean usedToHaveCpuCapability = true;
    L32:
        if (hasCpuCapability == usedToHaveCpuCapability) goto L34;
        cpuCapabilityChanged = true;
    L34:
        if (oomAdjChanged == true) goto L38;
        if (shouldNotFreezeChanged == true) goto L38;
        if (cpuCapabilityChanged == true) goto L38;
    L68:
        if (freezePolicy == false) goto L79;
        if (immediate == false) goto L74;
        if (opt.isFrozen() == true) goto L74;
        this.mCachedAppOptimizer.freezeAppAsyncAtEarliestLSP(app);
        return;
    L74:
        if (opt.isFrozen() == true) goto L76;
    L77:
        this.mCachedAppOptimizer.freezeAppAsyncLSP(app);
        return;
    L76:
        if (opt.isPendingFreeze() == false) goto L77;
        return;
    L79:
        if (opt.isFrozen() == false) goto L81;
    L82:
        this.mCachedAppOptimizer.unfreezeAppLSP(app, CachedAppOptimizer.getUnfreezeReasonCodeFromOomAdjReason(oomAdjReason));
        return;
    L81:
        if (opt.isPendingFreeze() == true) goto L82;
        return;
    L38:
        if (Trace.isTagEnabled(64) == false) goto L68;
        StringBuilder r10 = new StringBuilder();
        if (opt.isFrozen() == false) goto L42;
        String r14 = "F";
    L43:
        r10.append(r14);
        if (opt.isPendingFreeze() == false) goto L46;
        String r15 = "P";
    L47:
        r10.append(r15);
        if (opt.isFreezeExempt() == false) goto L50;
        String r16 = "E";
    L51:
        r10.append(r16);
        if (opt.shouldNotFreeze() == false) goto L54;
        String r17 = "N";
    L55:
        r10.append(r17);
        if (hasCpuCapability == false) goto L58;
        String r18 = "T";
    L59:
        r10.append(r18);
        if (immediate == false) goto L62;
        String r19 = "I";
    L63:
        r10.append(r19);
        if (freezePolicy == false) goto L66;
        String r110 = "Z";
    L67:
        r10.append(r110);
        r10.append("-");
        r10.append("-");
        r10.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        r10.append(app.getPid());
        r10.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        r10.append(state.getCurAdj());
        r10.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        r10.append(oldOomAdj);
        r10.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        r10.append(opt.shouldNotFreezeReason());
        Trace.instantForTrack(64, "FreezeLite", r10.toString());
        Trace.instantForTrack(64, CachedAppOptimizer.ATRACE_FREEZER_TRACK, "updateAppFreezeStateLSP " + app.processName + " pid: " + app.getPid() + " isFreezeExempt: " + opt.isFreezeExempt() + " isFrozen: " + opt.isFrozen() + " shouldNotFreeze: " + opt.shouldNotFreeze() + " shouldNotFreezeReason: " + opt.shouldNotFreezeReason() + " curAdj: " + state.getCurAdj() + " oldOomAdj: " + oldOomAdj + " immediate: " + immediate + " cpuCapability: " + hasCpuCapability);
        goto L68
    L66:
        r110 = "-";
        goto L67
    L62:
        r19 = "-";
        goto L63
    L58:
        r18 = "-";
        goto L59
    L54:
        r17 = "-";
        goto L55
    L50:
        r16 = "-";
        goto L51
    L46:
        r15 = "-";
        goto L47
    L42:
        r14 = "-";
        goto L43
    L31:
        usedToHaveCpuCapability = false;
        goto L32
    L27:
        hasCpuCapability = false;
        goto L29
    L23:
        shouldNotFreezeChanged = false;
        goto L25
    L16:
        if (oldOomAdj == 1001) goto L19;
        oomAdjChanged = false;
        goto L21
    L12:
        r8 = false;
        goto L14
    L8:
        r7 = false;
        goto L10
    }

    void unfreezeTemporarily(ProcessRecord app, int reason) {
        if (this.mCachedAppOptimizer.useFreezer() == true) goto L5;
        return;
    L5:
        ProcessCachedOptimizerRecord opt = app.mOptRecord;
        if (opt.isFrozen() == false) goto L8;
    L10:
        ArrayList<ProcessRecord> processes = this.mTmpProcessList;
        ActiveUids uids = this.mTmpUidRecords;
        this.mTmpProcessSet.add(app);
        collectReachableProcessesLocked(this.mTmpProcessSet, processes, uids);
        this.mTmpProcessSet.clear();
        int size = processes.size();
        int i = 0;
    L11:
        if (i >= size) goto L13;
        ProcessRecord proc = processes.get(i);
        this.mCachedAppOptimizer.unfreezeTemporarily(proc, CachedAppOptimizer.getUnfreezeReasonCodeFromOomAdjReason(reason));
        i = i + 1;
        goto L11
    L13:
        processes.clear();
        return;
    L8:
        if (opt.isPendingFreeze() == true) goto L10;
    }

    void onProcessEndLocked(ProcessRecord app) {
    }

    void onProcessStateChanged(ProcessRecord app, int prevProcState) {
    }

    void onProcessOomAdjChanged(ProcessRecord app, int prevAdj) {
    }

    void resetInternal() {
    }

    protected int getInitialAdj(ProcessRecord app) {
        return app.mState.getCurAdj();
    }

    protected int getInitialProcState(ProcessRecord app) {
        return app.mState.getCurProcState();
    }

    protected int getInitialCapability(ProcessRecord app) {
        return app.mState.getCurCapability();
    }

    protected boolean getInitialIsCurBoundByNonBgRestrictedApp(ProcessRecord app) {
        return app.mState.isCurBoundByNonBgRestrictedApp();
    }

    boolean evaluateServiceConnectionAdd(ProcessRecord client, ProcessRecord app, ConnectionRecord cr) {
        if (evaluateConnectionPrelude(client, app) == false) goto L7;
        return true;
    L7:
        if (app.getSetAdj() <= client.getSetAdj()) goto L10;
        ProcessRecord r3 = client;
        ProcessRecord r4 = app;
        boolean needDryRun = true;
    L27:
        if (needDryRun == true) goto L29;
        return false;
    L29:
        return computeServiceHostOomAdjLSP(cr, r4, r3, this.mInjector.getUptimeMillis(), this.mService.getTopApp(), false, false, false, 0, 900, false, true);
    L10:
        if (app.getSetProcState() <= client.getSetProcState()) goto L13;
        r3 = client;
        r4 = app;
        needDryRun = true;
        goto L27
    L13:
        if (cr.hasFlag(4294971392L) == false) goto L18;
        if ((app.getSetCapability() & client.getSetCapability()) == client.getSetCapability()) goto L18;
        r3 = client;
        r4 = app;
        needDryRun = true;
    L18:
        if (cr.hasFlag(48) == false) goto L20;
        r3 = client;
        r4 = app;
        needDryRun = true;
        goto L27
    L20:
        r3 = client;
        if (r3.mOptRecord.shouldNotFreeze() == false) goto L25;
        r4 = app;
        if (r4.mOptRecord.shouldNotFreeze() == true) goto L26;
        needDryRun = true;
    L26:
        needDryRun = false;
        goto L27
    L25:
        r4 = app;
        goto L26
    }

    boolean evaluateServiceConnectionRemoval(ProcessRecord client, ProcessRecord app, ConnectionRecord cr) {
        if (evaluateConnectionPrelude(client, app) == false) goto L6;
        return true;
    L6:
        if (app.getSetAdj() < client.getSetAdj()) goto L9;
        return true;
    L9:
        if (app.getSetProcState() < client.getSetProcState()) goto L12;
        return true;
    L12:
        if (cr.hasFlag(4294971392L) == false) goto L17;
        if ((app.getSetCapability() & client.getSetCapability()) == 0) goto L17;
        return true;
    L17:
        if (cr.hasFlag(48) == false) goto L20;
        return true;
    L20:
        if (app.mOptRecord.shouldNotFreeze() == true) goto L22;
        return false;
    L22:
        if (client.mOptRecord.shouldNotFreeze() == false) goto L26;
        return true;
    L26:
        return false;
    }

    boolean evaluateProviderConnectionAdd(ProcessRecord client, ProcessRecord app) {
        if (evaluateConnectionPrelude(client, app) == false) goto L6;
        return true;
    L6:
        boolean needDryRun = false;
        if (app.getSetAdj() <= client.getSetAdj()) goto L10;
        needDryRun = true;
        ProcessRecord r4 = client;
        ProcessRecord r3 = app;
    L19:
        if (needDryRun == true) goto L21;
        return false;
    L21:
        return computeProviderHostOomAdjLSP(null, r3, r4, this.mInjector.getUptimeMillis(), this.mService.getTopApp(), false, false, false, 0, 900, false, true);
    L10:
        if (app.getSetProcState() <= client.getSetProcState()) goto L12;
        needDryRun = true;
        r4 = client;
        r3 = app;
        goto L19
    L12:
        r4 = client;
        if (r4.mOptRecord.shouldNotFreeze() == false) goto L17;
        r3 = app;
        if (r3.mOptRecord.shouldNotFreeze() == true) goto L19;
        needDryRun = true;
        goto L19
    L17:
        r3 = app;
        goto L19
    }

    boolean evaluateProviderConnectionRemoval(ProcessRecord client, ProcessRecord app) {
        if (evaluateConnectionPrelude(client, app) == false) goto L6;
        return true;
    L6:
        if (app.getSetAdj() < client.getSetAdj()) goto L9;
        return true;
    L9:
        if (app.getSetProcState() < client.getSetProcState()) goto L12;
        return true;
    L12:
        if (app.mOptRecord.shouldNotFreeze() == true) goto L14;
        return false;
    L14:
        if (client.mOptRecord.shouldNotFreeze() == false) goto L18;
        return true;
    L18:
        return false;
    }

    private boolean evaluateConnectionPrelude(ProcessRecord client, ProcessRecord app) {
        if (client == null) goto L18;
        if (app == null) goto L18;
        if (app.isSdkSandbox == false) goto L9;
    L17:
        return true;
    L9:
        if (app.isolated == true) goto L17;
        if (app.isKilledByAm() == true) goto L17;
        if (app.isKilled() == true) goto L17;
        return false;
    L18:
        return true;
    }

    private void maybeSetProcessFollowUpUpdateLocked(ProcessRecord proc, long updateUptimeMs, long now) {
        if (updateUptimeMs > now) goto L5;
        return;
    L5:
        this.mFollowUpUpdateSet.add(proc);
        proc.mState.setFollowupUpdateUptimeMs(updateUptimeMs);
        scheduleFollowUpOomAdjusterUpdateLocked(updateUptimeMs, now);
    }

    private void scheduleFollowUpOomAdjusterUpdateLocked(long updateUptimeMs, long now) {
        if ((this.mConstants.FOLLOW_UP_OOMADJ_UPDATE_WAIT_DURATION + updateUptimeMs) < this.mNextFollowUpUpdateUptimeMs) goto L6;
        return;
    L6:
        if (updateUptimeMs >= (this.mConstants.FOLLOW_UP_OOMADJ_UPDATE_WAIT_DURATION + now)) goto L8;
        updateUptimeMs = now + this.mConstants.FOLLOW_UP_OOMADJ_UPDATE_WAIT_DURATION;
    L8:
        this.mNextFollowUpUpdateUptimeMs = updateUptimeMs;
        this.mService.mHandler.sendEmptyMessageAtTime(86, this.mNextFollowUpUpdateUptimeMs);
    }
}
