package com.android.server.wm;

import android.app.ActivityManager;
import android.app.ActivityMetricsData;
import android.app.ActivityOptions;
import android.app.SysFwBridge;
import android.app.SysMonitorFwBridge;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.IncrementalStatesInfo;
import android.content.pm.dex.ArtManagerInternal;
import android.content.pm.dex.PackageOptimizationInfo;
import android.metrics.LogMaker;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import android.os.incremental.IncrementalManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.BoostFramework;
import android.util.EventLog;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimeUtils;
import bytedanceos.util.FeatLog;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.FgThread;
import com.android.server.ITransferController;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.am.IIoLimiter;
import com.android.server.am.ISysPrefetchService;
import com.android.server.am.MemoryStatUtil;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.apphibernation.AppHibernationManagerInternal;
import com.android.server.apphibernation.AppHibernationService;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import com.android.server.resmng.IResMngConfig;
import com.android.server.usb.descriptors.UsbTerminalTypes;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class ActivityMetricsLogger {
    private static final int IGNORE_CALLER = -1;
    private static final long LATENCY_TRACKER_RECENTS_DELAY_MS = 300;
    private static final int MULTI_WINDOW_LAUNCH_TYPE_APP_PAIR = 1;
    private static final int MULTI_WINDOW_LAUNCH_TYPE_UNSPECIFIED = 0;
    private static final String TAG = "ActivityTaskManager";
    private static final String[] TRON_WINDOW_STATE_VARZ_STRINGS = null;
    private static final long UNKNOWN_VISIBILITY_CHECK_DELAY_MS = 3000;
    private static final int WINDOW_STATE_ASSISTANT = 3;
    private static final int WINDOW_STATE_FREEFORM = 2;
    private static final int WINDOW_STATE_INVALID = -1;
    private static final int WINDOW_STATE_MULTI_WINDOW = 4;
    private static final int WINDOW_STATE_SIDE_BY_SIDE = 1;
    private static final int WINDOW_STATE_STANDARD = 0;
    private static ActivityRecord mLaunchedActivity;
    public static BoostFramework mPerfBoost;
    public static BoostFramework mUxPerf;
    private final ArrayList<ActivityMetricsData> mActivityMetricsData;
    private final long mActivityMetricsDataExpiredTimeMs;
    private AppHibernationManagerInternal mAppHibernationManagerInternal;
    private ArtManagerInternal mArtManagerInternal;
    private final Object mDataLock;
    private final ArrayMap<String, Boolean> mLastHibernationStates;
    private long mLastLogTimeSecs;
    private final ArrayMap<ActivityRecord, TransitionInfo> mLastTransitionInfo;
    private final LaunchObserverRegistryImpl mLaunchObserver;
    private final Handler mLoggerHandler;
    private final MetricsLogger mMetricsLogger;
    private final SparseArray<PackageCompatStateInfo> mPackageUidToCompatStateInfo;
    private final ActivityMetricsLoggerSmtBase mSmtEx;
    private final StringBuilder mStringBuilder;
    private final ActivityTaskSupervisor mSupervisor;
    private final ArrayList<TransitionInfo> mTransitionInfoList;
    private int mWindowState;

    static final class LaunchingState {
        private static int sTraceSeqId;
        private TransitionInfo mAssociatedTransitionInfo;
        private long mCurrentTransitionStartRefRealTimeMs;
        final long mStartRealtimeNs;
        final long mStartUptimeNs;
        String mTraceName;

        /* JADX INFO: renamed from: -$$Nest$fgetmAssociatedTransitionInfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ TransitionInfo m9622$$Nest$fgetmAssociatedTransitionInfo(LaunchingState r0) {
            return r0.mAssociatedTransitionInfo;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCurrentTransitionStartRefRealTimeMs, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m9623$$Nest$fgetmCurrentTransitionStartRefRealTimeMs(LaunchingState r2) {
            return r2.mCurrentTransitionStartRefRealTimeMs;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmAssociatedTransitionInfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9624$$Nest$fputmAssociatedTransitionInfo(LaunchingState r0, TransitionInfo r1) {
            r0.mAssociatedTransitionInfo = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmCurrentTransitionStartRefRealTimeMs, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9625$$Nest$fputmCurrentTransitionStartRefRealTimeMs(LaunchingState r0, long r1) {
            r0.mCurrentTransitionStartRefRealTimeMs = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$sfgetsTraceSeqId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9626$$Nest$sfgetsTraceSeqId() {
            return sTraceSeqId;
        }

        LaunchingState() {
            this.mStartUptimeNs = SystemClock.uptimeNanos();
            this.mStartRealtimeNs = SystemClock.elapsedRealtimeNanos();
            if (Trace.isTagEnabled(64) == true) goto L5;
            return;
        L5:
            sTraceSeqId++;
            this.mTraceName = "launchingActivity#" + sTraceSeqId;
            Trace.asyncTraceBegin(64, this.mTraceName, 0);
        }

        void stopTrace(boolean abort, TransitionInfo endInfo) {
            if (this.mTraceName != null) goto L5;
            return;
        L5:
            if (abort == false) goto L7;
        L9:
            Trace.asyncTraceEnd(64, this.mTraceName, 0);
            if (this.mAssociatedTransitionInfo != null) goto L12;
            String status = ":failed";
        L29:
            Trace.instant(64, this.mTraceName + status);
            this.mTraceName = null;
            return;
        L12:
            if (abort == false) goto L15;
            String status2 = ":canceled:";
        L28:
            status = status2 + this.mAssociatedTransitionInfo.mLastLaunchedActivity.packageName;
            goto L29
        L15:
            if (this.mAssociatedTransitionInfo.mProcessSwitch == true) goto L18;
            status2 = ":completed-same-process:";
            goto L28
        L18:
            if (endInfo.mTransitionType != 9) goto L25;
            if (endInfo.mRelaunched == true) goto L22;
            status2 = ":completed-hot:";
            goto L28
        L22:
            status2 = ":completed-relaunch:";
            goto L28
        L25:
            if (endInfo.mTransitionType != 8) goto L27;
            status2 = ":completed-warm:";
            goto L28
        L27:
            status2 = ":completed-cold:";
            goto L28
        L7:
            if (endInfo == this.mAssociatedTransitionInfo) goto L9;
        }

        boolean allDrawn() {
            if (this.mAssociatedTransitionInfo != null) goto L5;
        L7:
            return false;
        L5:
            if (this.mAssociatedTransitionInfo.mIsDrawn == false) goto L7;
            return true;
        }

        boolean hasActiveTransitionInfo() {
            if (this.mAssociatedTransitionInfo == null) goto L5;
            return true;
        L5:
            return false;
        }

        boolean contains(ActivityRecord r) {
            if (this.mAssociatedTransitionInfo != null) goto L5;
        L7:
            return false;
        L5:
            if (this.mAssociatedTransitionInfo.contains(r) == false) goto L7;
            return true;
        }
    }

    private static final class PackageCompatStateInfo {
        ActivityRecord mLastLoggedActivity;
        int mLastLoggedState;
        final ArrayList<ActivityRecord> mVisibleActivities;

        /* synthetic */ PackageCompatStateInfo(ActivityMetricsLoggerIA r1) {
            this();
        }

        private PackageCompatStateInfo() {
            this.mVisibleActivities = new ArrayList();
            this.mLastLoggedState = 1;
        }
    }

    private static final class TransitionInfo {
        final ActivityOptions mActivityOptions;
        int mBindApplicationDelayMs;
        int mCurrentTransitionDelayMs;
        boolean mIsDrawn;
        final boolean mIsInTaskActivityStart;
        ActivityRecord mLastLaunchedActivity;
        String mLaunchTraceName;
        final LaunchingState mLaunchingState;
        boolean mLoggedStartingWindowDrawn;
        boolean mLoggedTransitionStarting;
        int mMultiWindowLaunchType;
        int mNetqFinish;
        int mNetqStart;
        Runnable mPendingFullyDrawn;
        final int mProcessOomAdj;
        boolean mProcessRunning;
        final int mProcessState;
        final boolean mProcessSwitch;
        int mReason;
        boolean mRelaunched;
        String mResprobeJson;
        int mSourceEventDelayMs;
        int mSourceType;
        int mStartingWindowDelayMs;
        long mTransitionStartTime;
        final long mTransitionStartTimeRefRealTimeMs;
        int mTransitionType;
        int mWindowsDrawnDelayMs;
        long mWindowsDrawnTime;
        boolean prefetchEffect;

        static TransitionInfo create(ActivityRecord r, LaunchingState launchingState, ActivityOptions options, boolean processRunning, boolean processSwitch, int processState, int processOomAdj, boolean newActivityCreated, boolean isInTaskActivityStart, int startResult) {
            if (startResult != 0) goto L5;
        L8:
            if (processRunning == false) goto L15;
            if (newActivityCreated == false) goto L11;
        L13:
            int r1 = 8;
        L14:
            int transitionType = r1;
        L17:
            return new TransitionInfo(r, launchingState, options, transitionType, processRunning, processSwitch, processState, processOomAdj, isInTaskActivityStart);
        L11:
            if (r.attachedToProcessOrFrozen() == false) goto L13;
            r1 = 9;
            goto L14
        L15:
            transitionType = 7;
            goto L17
        L5:
            if (startResult == 2) goto L8;
            return null;
        }

        private TransitionInfo(ActivityRecord r, LaunchingState launchingState, ActivityOptions options, int transitionType, boolean processRunning, boolean processSwitch, int processState, int processOomAdj, boolean isInTaskActivityStart) {
            this.mNetqStart = 2;
            this.mNetqFinish = 2;
            this.mSourceEventDelayMs = -1;
            this.mStartingWindowDelayMs = -1;
            this.mBindApplicationDelayMs = -1;
            this.mReason = 3;
            this.mMultiWindowLaunchType = 0;
            this.mLaunchingState = launchingState;
            this.mTransitionStartTimeRefRealTimeMs = LaunchingState.m9623$$Nest$fgetmCurrentTransitionStartRefRealTimeMs(launchingState);
            this.mTransitionType = transitionType;
            this.mProcessRunning = processRunning;
            this.mProcessSwitch = processSwitch;
            this.mProcessState = processState;
            this.mProcessOomAdj = processOomAdj;
            this.mIsInTaskActivityStart = isInTaskActivityStart;
            this.prefetchEffect = false;
            this.mActivityOptions = options;
            this.mResprobeJson = null;
            this.mNetqStart = 2;
            this.mNetqFinish = 2;
            setLatestLaunchedActivity(r);
            if (LaunchingState.m9622$$Nest$fgetmAssociatedTransitionInfo(launchingState) != null) goto L5;
            LaunchingState.m9624$$Nest$fputmAssociatedTransitionInfo(launchingState, this);
        L5:
            if (options == null) goto L10;
            ActivityOptions.SourceInfo sourceInfo = options.getSourceInfo();
            if (sourceInfo == null) goto L11;
            this.mSourceType = sourceInfo.type;
            this.mSourceEventDelayMs = (int) (TimeUnit.NANOSECONDS.toMillis(launchingState.mStartUptimeNs) - sourceInfo.eventTimeMs);
            return;
        L11:
            return;
        }

        void setLatestLaunchedActivity(ActivityRecord r) {
            if (this.mLastLaunchedActivity != r) goto L6;
            return;
        L6:
            if (this.mLastLaunchedActivity != null) goto L8;
        L13:
            this.mLastLaunchedActivity = r;
            this.mIsDrawn = r.isReportedDrawn();
            return;
        L8:
            if (this.mLastLaunchedActivity.mLaunchCookie != null) goto L10;
        L12:
            r.mLaunchCookie = this.mLastLaunchedActivity.mLaunchCookie;
            this.mLastLaunchedActivity.mLaunchCookie = null;
            r.mLaunchRootTask = this.mLastLaunchedActivity.mLaunchRootTask;
            this.mLastLaunchedActivity.mLaunchRootTask = null;
            goto L13
        L10:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L12;
            String protoLogParam0 = String.valueOf(this.mLastLaunchedActivity.mLaunchCookie);
            String protoLogParam1 = String.valueOf(this.mLastLaunchedActivity.packageName);
            long protoLogParam2 = System.identityHashCode(this.mLastLaunchedActivity);
            String protoLogParam3 = String.valueOf(r.packageName);
            long protoLogParam4 = System.identityHashCode(r);
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 5168346716727360351L, 272, new Object[]{protoLogParam0, protoLogParam1, Long.valueOf(protoLogParam2), protoLogParam3, Long.valueOf(protoLogParam4)});
            goto L12
        }

        boolean canCoalesce(ActivityRecord r) {
            if (this.mLastLaunchedActivity.mDisplayContent == r.mDisplayContent) goto L5;
            return false;
        L5:
            if (this.mLastLaunchedActivity.getWindowingMode() != r.getWindowingMode()) goto L19;
            Task lastTask = this.mLastLaunchedActivity.getTask();
            Task currentTask = r.getTask();
            if (lastTask == null) goto L16;
            if (currentTask == null) goto L16;
            if (lastTask != currentTask) goto L14;
            return true;
        L14:
            return lastTask.getBounds().equals(currentTask.getBounds());
        L16:
            return this.mLastLaunchedActivity.isUid(r.launchedFromUid);
        L19:
            return false;
        }

        boolean contains(ActivityRecord r) {
            if (r != this.mLastLaunchedActivity) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isInterestingToLoggerAndObserver() {
            return this.mProcessSwitch;
        }

        int calculateCurrentDelay() {
            return calculateDelay(SystemClock.uptimeNanos());
        }

        int calculateDelay(long timestampNs) {
            return (int) TimeUnit.NANOSECONDS.toMillis(timestampNs - this.mLaunchingState.mStartUptimeNs);
        }

        public String toString() {
            return "TransitionInfo{" + Integer.toHexString(System.identityHashCode(this)) + " a=" + this.mLastLaunchedActivity + " d=" + this.mIsDrawn + "}";
        }
    }

    static final class TransitionInfoSnapshot {
        final int activityRecordIdHashCode;
        private final ApplicationInfo applicationInfo;
        private final int bindApplicationDelayMs;
        final long launchStartTime;
        private final String launchedActivityAppRecordRequiredAbi;
        private final String launchedActivityLaunchToken;
        private final String launchedActivityLaunchedFromPackage;
        final String launchedActivityName;
        final String launchedActivityShortComponentName;
        final int multiWindowLaunchType;
        final String packageName;
        boolean prefetchEffect;
        private final String processName;
        final WindowProcessController processRecord;
        private final int reason;
        final boolean relaunched;
        String resprobeJson;
        final int sourceEventDelayMs;
        final int sourceType;
        private final int startingWindowDelayMs;
        final int sysType;
        final long timestampNs;
        final int type;
        final int userId;
        final int windowsDrawnDelayMs;
        final int windowsFullyDrawnDelayMs;

        /* JADX INFO: renamed from: -$$Nest$fgetapplicationInfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ ApplicationInfo m9627$$Nest$fgetapplicationInfo(TransitionInfoSnapshot r0) {
            return r0.applicationInfo;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetbindApplicationDelayMs, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9628$$Nest$fgetbindApplicationDelayMs(TransitionInfoSnapshot r0) {
            return r0.bindApplicationDelayMs;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetlaunchedActivityLaunchToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m9629$$Nest$fgetlaunchedActivityLaunchToken(TransitionInfoSnapshot r0) {
            return r0.launchedActivityLaunchToken;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetlaunchedActivityLaunchedFromPackage, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m9630$$Nest$fgetlaunchedActivityLaunchedFromPackage(TransitionInfoSnapshot r0) {
            return r0.launchedActivityLaunchedFromPackage;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetprocessName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m9631$$Nest$fgetprocessName(TransitionInfoSnapshot r0) {
            return r0.processName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetreason, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9632$$Nest$fgetreason(TransitionInfoSnapshot r0) {
            return r0.reason;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetstartingWindowDelayMs, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9633$$Nest$fgetstartingWindowDelayMs(TransitionInfoSnapshot r0) {
            return r0.startingWindowDelayMs;
        }

        /* synthetic */ TransitionInfoSnapshot(TransitionInfo r1, ActivityMetricsLoggerIA r2) {
            this(r1);
        }

        /* synthetic */ TransitionInfoSnapshot(TransitionInfo r1, ActivityRecord r2, int r3, ActivityMetricsLoggerIA r4) {
            this(r1, r2, r3);
        }

        private TransitionInfoSnapshot(TransitionInfo info) {
            this(info, info.mLastLaunchedActivity, -1);
        }

        private TransitionInfoSnapshot(TransitionInfo info, ActivityRecord launchedActivity, int windowsFullyDrawnDelayMs) {
            this.applicationInfo = launchedActivity.info.applicationInfo;
            this.packageName = launchedActivity.packageName;
            this.launchedActivityName = launchedActivity.info.name;
            this.launchedActivityLaunchedFromPackage = launchedActivity.launchedFromPackage;
            this.launchedActivityLaunchToken = launchedActivity.info.launchToken;
            if (launchedActivity.app != null) goto L5;
            String r0 = null;
        L6:
            this.launchedActivityAppRecordRequiredAbi = r0;
            this.reason = info.mReason;
            this.sourceEventDelayMs = info.mSourceEventDelayMs;
            this.startingWindowDelayMs = info.mStartingWindowDelayMs;
            this.bindApplicationDelayMs = info.mBindApplicationDelayMs;
            this.windowsDrawnDelayMs = info.mWindowsDrawnDelayMs;
            this.type = info.mTransitionType;
            this.processRecord = launchedActivity.app;
            this.processName = launchedActivity.processName;
            this.sourceType = info.mSourceType;
            this.userId = launchedActivity.mUserId;
            this.launchedActivityShortComponentName = launchedActivity.shortComponentName;
            this.activityRecordIdHashCode = System.identityHashCode(launchedActivity);
            this.windowsFullyDrawnDelayMs = windowsFullyDrawnDelayMs;
            this.relaunched = info.mRelaunched;
            this.sysType = getSysType(this.type);
            this.timestampNs = info.mLaunchingState.mStartRealtimeNs;
            this.multiWindowLaunchType = info.mMultiWindowLaunchType;
            this.launchStartTime = info.mTransitionStartTimeRefRealTimeMs;
            this.prefetchEffect = info.prefetchEffect;
            this.resprobeJson = info.mResprobeJson;
            return;
        L5:
            r0 = launchedActivity.app.getRequiredAbi();
            goto L6
        }

        int getLaunchState() {
            switch(this.type) {
                case 7: goto L13;
                case 8: goto L11;
                case 9: goto L7;
                default: goto L4;
            };
        L4:
            return -1;
        L11:
            return 2;
        L13:
            return 1;
        L7:
            if (this.relaunched == false) goto L9;
            return 4;
        L9:
            return 3;
        }

        boolean isInterestedToEventLog() {
            if (this.type != 8) goto L5;
        L10:
            return true;
        L5:
            if (this.type == 7) goto L10;
            if (this.type == 9) goto L10;
            return false;
        }

        static int getSysType(int transitionType) {
            if (0 == 0) goto L5;
            return 0;
        L5:
            if (transitionType != 7) goto L8;
            return 10;
        L8:
            if (transitionType != 8) goto L11;
            return 20;
        L11:
            if (transitionType != 9) goto L17;
            return 40;
        L17:
            return 0;
        }

        PackageOptimizationInfo getPackageOptimizationInfo(ArtManagerInternal artManagerInternal) {
            if (artManagerInternal == null) goto L8;
            if (this.launchedActivityAppRecordRequiredAbi == null) goto L8;
            return artManagerInternal.getPackageOptimizationInfo(this.applicationInfo, this.launchedActivityAppRecordRequiredAbi, this.launchedActivityName);
        L8:
            return PackageOptimizationInfo.createWithNoInfo();
        }
    }

    public static /* synthetic */ void $r8$lambda$3RGlU1M3uP_iCCCYjYhunixnUpw(ActivityMetricsLogger r0, TransitionInfo r1, long r2, int r4, TransitionInfoSnapshot r5, boolean r6, int r7, int r8, boolean r9) {
        r0.lambda$logAppTransitionFinished$2(r1, r2, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: $r8$lambda$5ki7q7mPhYIecj4-hBYOZDmsAik, reason: not valid java name */
    public static /* synthetic */ void m9620$r8$lambda$5ki7q7mPhYIecj4hBYOZDmsAik(ActivityMetricsLogger r0, TransitionInfoSnapshot r1, boolean r2, TransitionInfo r3) {
        r0.lambda$notifyFullyDrawn$6(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$9hr_GK0GAsfQJMY3gnuWhWcVa94(ActivityRecord r0) {
        return lambda$checkActivityToBeDrawn$1(r0);
    }

    public static /* synthetic */ void $r8$lambda$FGN_QvgZ9ig3PZArPbmcE7o8Di8(ActivityMetricsLogger r0, long r1, TransitionInfoSnapshot r3, int r4) {
        r0.lambda$notifyWindowsDrawn$0(r1, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$MDDCoWK980XoH_6bZLWfXzhTwEY(ActivityMetricsLogger r0, String r1, int r2) {
        r0.logWindowState(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$OUNyB_bwgLMY8TVVdFfVT61UkxQ(ActivityMetricsLogger r0, ActivityRecord r1, boolean r2, TransitionInfo r3) {
        r0.lambda$notifyFullyDrawn$4(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$PB0dUMSgkSLbNfMfRBQ_zSD5XVk(long r0, ActivityRecord r2, WindowManagerService r3, int r4) {
        lambda$logRecentsAnimationLatency$3(r0, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$S-wqbHVH_zpEtI4RMGxzu0oWXbo, reason: not valid java name */
    public static /* synthetic */ void m9621$r8$lambda$SwqbHVH_zpEtI4RMGxzu0oWXbo(ActivityMetricsLogger r0, Task r1, ActivityRecord r2) {
        r0.checkActivityToBeDrawn(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$SLhgClhCxMNiyG0X8ws4k9l4gJc(ActivityMetricsLogger r0, TransitionInfoSnapshot r1) {
        r0.lambda$notifyFullyDrawn$5(r1);
    }

    static {
        TRON_WINDOW_STATE_VARZ_STRINGS = new String[]{"window_time_0", "window_time_1", "window_time_2", "window_time_3", "window_time_4"};
        mUxPerf = new BoostFramework();
        mPerfBoost = new BoostFramework();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0020 -> B:21:0x0021). Please report as a decompilation issue!!! */
    private static String appendLaunchNetqInfo(String resprobeJson, int netqStart, int netqFinish) {
        if (TextUtils.isEmpty(resprobeJson) == false) goto L7;
        JSONObject root = new JSONObject();     // Catch: JSONException -> L5
    L21:
        JSONObject launchNetqInfo = new JSONObject();     // Catch: JSONException -> L14
        launchNetqInfo.put(IMediaProjectionManagerServiceExt.NODE_START, netqStart);     // Catch: JSONException -> L14
        launchNetqInfo.put("finish", netqFinish);     // Catch: JSONException -> L14
        root.put("launch_netq_info", launchNetqInfo);     // Catch: JSONException -> L14
        return root.toString();
    L16:
        return root.toString();
    L7:
        root = new JSONObject(resprobeJson);     // Catch: JSONException -> L5
    L19:
        JSONObject root2 = new JSONObject();     // Catch: JSONException -> L17
        root2.put("resprobe_raw_invalid", resprobeJson);     // Catch: JSONException -> L17
        root = root2;
    L18:
        return resprobeJson;
    }

    ActivityMetricsLogger(ActivityTaskSupervisor supervisor, Looper looper) {
        this.mWindowState = 0;
        this.mMetricsLogger = new MetricsLogger();
        this.mLoggerHandler = FgThread.getHandler();
        this.mTransitionInfoList = new ArrayList();
        this.mLastTransitionInfo = new ArrayMap();
        this.mPackageUidToCompatStateInfo = new SparseArray(0);
        this.mStringBuilder = new StringBuilder();
        this.mLastHibernationStates = new ArrayMap();
        this.mDataLock = new Object();
        this.mActivityMetricsData = new ArrayList();
        this.mActivityMetricsDataExpiredTimeMs = 600000;
        this.mLastLogTimeSecs = SystemClock.elapsedRealtime() / 1000;
        this.mSupervisor = supervisor;
        this.mLaunchObserver = new LaunchObserverRegistryImpl(looper);
        this.mSmtEx = new ActivityMetricsLoggerSmtBase(this);
        SysFwBridge.getFactory().getNetQualityParserOpt().initEx();
    }

    private void logWindowState(String state, int durationSecs) {
        this.mMetricsLogger.count(state, durationSecs);
    }

    void logWindowState() {
        long now = SystemClock.elapsedRealtime() / 1000;
        if (this.mWindowState == (-1)) goto L5;
        this.mLoggerHandler.sendMessage(PooledLambda.obtainMessage(new ActivityMetricsLogger$$ExternalSyntheticLambda6(), this, TRON_WINDOW_STATE_VARZ_STRINGS[this.mWindowState], Integer.valueOf((int) (now - this.mLastLogTimeSecs))));
    L5:
        this.mLastLogTimeSecs = now;
        this.mWindowState = -1;
        Task focusedTask = this.mSupervisor.mRootWindowContainer.getTopDisplayFocusedRootTask();
        if (focusedTask != null) goto L9;
        return;
    L9:
        if (focusedTask.isActivityTypeAssistant() == false) goto L12;
        this.mWindowState = 3;
        return;
    L12:
        int windowingMode = focusedTask.getWindowingMode();
        switch(windowingMode) {
            case 1: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            default: goto L14;
        };
    L14:
        if (windowingMode == 0) goto L20;
        Slog.wtf(TAG, "Unknown windowing mode for task=" + focusedTask + " windowingMode=" + windowingMode);
        return;
    L20:
        return;
    L16:
        this.mWindowState = 4;
        return;
    L17:
        this.mWindowState = 2;
        return;
    L18:
        this.mWindowState = 0;
    }

    private TransitionInfo getActiveTransitionInfo(ActivityRecord r) {
        int i = this.mTransitionInfoList.size() - 1;
    L3:
        if (i < 0) goto L8;
        TransitionInfo info = this.mTransitionInfoList.get(i);
        if (info.contains(r) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return info;
    L8:
        return null;
    }

    LaunchingState notifyActivityLaunching(Intent intent) {
        return notifyActivityLaunching(intent, null, -1);
    }

    LaunchingState notifyActivityLaunching(Intent intent, ActivityRecord caller, int callingUid) {
        long refRealTimeMs = System.currentTimeMillis();
        TransitionInfo existingInfo = null;
        if (callingUid == (-1)) goto L17;
        int i = this.mTransitionInfoList.size() - 1;
    L5:
        if (i < 0) goto L17;
        TransitionInfo info = this.mTransitionInfoList.get(i);
        if (caller != null) goto L9;
    L11:
        if (existingInfo != null) goto L15;
        if (callingUid != info.mLastLaunchedActivity.getUid()) goto L15;
        existingInfo = info;
    L15:
        i = i - 1;
        goto L5
    L9:
        if (info.contains(caller) == false) goto L11;
        existingInfo = info;
    L17:
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L19;
        Slog.i(TAG, "notifyActivityLaunching intent=" + intent + " existingInfo=" + existingInfo);
    L19:
        if (existingInfo != null) goto L22;
        LaunchingState launchingState = new LaunchingState();
        LaunchingState.m9625$$Nest$fputmCurrentTransitionStartRefRealTimeMs(launchingState, refRealTimeMs);
        launchObserverNotifyIntentStarted(intent, launchingState.mStartUptimeNs);
        return launchingState;
    L22:
        LaunchingState.m9625$$Nest$fputmCurrentTransitionStartRefRealTimeMs(existingInfo.mLaunchingState, existingInfo.mLaunchingState.mStartUptimeNs);
        return existingInfo.mLaunchingState;
    }

    void notifyActivityLaunched(LaunchingState launchingState, int resultCode, boolean newActivityCreated, ActivityRecord launchedActivity, ActivityOptions options) {
        if (launchedActivity != null) goto L5;
    L100:
        abort(launchingState, "nothing launched");
        return;
    L5:
        if (launchedActivity.getTask() == null) goto L100;
        if (launchedActivity.app == null) goto L10;
        WindowProcessController processRecord = launchedActivity.app;
    L12:
        if (processRecord != null) goto L17;
        WindowProcessController processRecord2 = this.mSupervisor.mService.getSmtEx().getFrozenProcessController(launchedActivity.processName, launchedActivity.info.applicationInfo.uid);
        if (processRecord2 == null) goto L16;
        WindowProcessController processRecord3 = processRecord2;
        boolean frozen = true;
    L18:
        if (processRecord3 == null) goto L20;
        boolean processRunning = true;
    L21:
        if (processRunning == true) goto L23;
    L26:
        boolean processSwitch = true;
    L28:
        if (processRunning == false) goto L30;
        int processState = processRecord3.getCurrentProcState();
        int processOomAdj = processRecord3.getCurrentAdj();
        int processState2 = processState;
    L31:
        TransitionInfo info = LaunchingState.m9622$$Nest$fgetmAssociatedTransitionInfo(launchingState);
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L34;
        StringBuilder r3 = new StringBuilder();
        r3.append("notifyActivityLaunched resultCode=");
        int r10 = resultCode;
        r3.append(r10);
        r3.append(" launchedActivity=");
        r3.append(launchedActivity);
        r3.append(" processRunning=");
        r3.append(processRunning);
        r3.append(" processSwitch=");
        r3.append(processSwitch);
        r3.append(" processState=");
        r3.append(processState2);
        r3.append(" processOomAdj=");
        r3.append(processOomAdj);
        r3.append(" newActivityCreated=");
        boolean r9 = newActivityCreated;
        r3.append(r9);
        boolean r16 = true;
        r3.append(" info=");
        r3.append(info);
        r3.append(" frozen=");
        r3.append(frozen);
        Slog.i(TAG, r3.toString());
    L36:
        if (launchedActivity.isReportedDrawn() == true) goto L38;
    L41:
        if (info != null) goto L43;
    L55:
        boolean isInTaskActivityStart = launchedActivity.getTask().isVisible();
        TransitionInfo newInfo = TransitionInfo.create(launchedActivity, launchingState, options, processRunning, processSwitch, processState2, processOomAdj, r9, isInTaskActivityStart, r10);
        if (newInfo != null) goto L59;
        abort(launchingState, "unrecognized launch");
        return;
    L59:
        updateSplitPairLaunches(newInfo);
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L62;
        Slog.i(TAG, "notifyActivityLaunched successful");
    L62:
        this.mTransitionInfoList.add(newInfo);
        this.mLastTransitionInfo.put(launchedActivity, newInfo);
        startLaunchTrace(newInfo);
        if (newInfo.isInterestingToLoggerAndObserver() == false) goto L84;
        launchObserverNotifyActivityLaunched(newInfo);
        if (processRecord3 == null) goto L67;
        int pid = processRecord3.getPid();
    L69:
        if (pid > 0) goto L71;
        long r18 = 64;
        boolean r6 = r16;
        StringBuilder r4 = new StringBuilder();
        r4.append("Resprobe pid not ready yet, cold start, skip slot0 this time: ");
        r4.append(launchedActivity.packageName);
        r4.append(" app != null: ");
        if (launchedActivity.app != null) goto L82;
        r6 = false;
    L82:
        r4.append(r6);
        Slog.e(TAG, r4.toString());
    L83:
        newInfo.mNetqStart = SysFwBridge.getFactory().getNetQualityParserOpt().readQualityEx();
        long r5 = r18;
        Trace.traceBegin(r5, "netq_start:" + newInfo.mNetqStart);
        Trace.traceEnd(r5);
    L86:
        if ("android.intent.action.PROCESS_TEXT".equals(newInfo.mLastLaunchedActivity.intent.getAction()) == false) goto L88;
        this.mLoggerHandler.post(PooledLambda.obtainRunnable(new ActivityMetricsLogger$$ExternalSyntheticLambda7(), 1016, Integer.valueOf(launchedActivity.launchedFromUid), Integer.valueOf(launchedActivity.getUid())));
    L88:
        scheduleCheckActivityToBeDrawnIfSleeping(launchedActivity);
        int i = this.mTransitionInfoList.size() - 2;
    L89:
        if (i < 0) goto L99;
        TransitionInfo prevInfo = this.mTransitionInfoList.get(i);
        if (prevInfo.mIsDrawn == false) goto L93;
    L96:
        scheduleCheckActivityToBeDrawn(prevInfo.mLastLaunchedActivity, 0);
    L97:
        i = i - 1;
        goto L89
    L93:
        if (prevInfo.mLastLaunchedActivity.isVisibleRequested() == true) goto L97;
    L99:
        return;
    L71:
        if (SysMonitorFwBridge.getFactory().getResprobe().isFeatureEnabled() == false) goto L77;
        Trace.traceBegin(64, "Resprobe snapshot 0");
        r18 = 64;
        boolean ok = SysMonitorFwBridge.getFactory().getResprobe().snapshot(pid, pid, 132, 0);
        Trace.traceEnd(64);
        if (ok != r16) goto L75;
        Slog.d(TAG, "Resprobe snapshot 0 success, pid=" + pid + ", packageName=" + launchedActivity.packageName);
        goto L83
    L75:
        Slog.e(TAG, "Resprobe snapshot 0 failed, pid=" + pid + ", packageName=" + launchedActivity.packageName);
        goto L83
    L77:
        r18 = 64;
        goto L83
    L67:
        pid = -1;
        goto L69
    L84:
        launchObserverNotifyIntentFailed(newInfo.mLaunchingState.mStartUptimeNs);
        goto L86
    L43:
        if (info.canCoalesce(launchedActivity) == false) goto L55;
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L47;
        Slog.i(TAG, "notifyActivityLaunched consecutive launch");
    L47:
        boolean crossPackage = !info.mLastLaunchedActivity.packageName.equals(launchedActivity.packageName);
        if (crossPackage == false) goto L50;
        stopLaunchTrace(info);
    L50:
        this.mLastTransitionInfo.remove(info.mLastLaunchedActivity);
        info.setLatestLaunchedActivity(launchedActivity);
        this.mLastTransitionInfo.put(launchedActivity, info);
        if (crossPackage == false) goto L53;
        startLaunchTrace(info);
    L53:
        scheduleCheckActivityToBeDrawnIfSleeping(launchedActivity);
        return;
    L38:
        if (launchedActivity.isVisible() == false) goto L41;
        abort(launchingState, "launched activity already visible");
        return;
    L34:
        r10 = resultCode;
        r9 = newActivityCreated;
        r16 = true;
        goto L36
    L30:
        processOomAdj = -10000;
        processState2 = 20;
        goto L31
    L23:
        if (processRecord3.hasStartedActivity(launchedActivity) == false) goto L26;
        processSwitch = false;
        goto L28
    L20:
        processRunning = false;
        goto L21
    L16:
        processRecord3 = processRecord2;
        frozen = false;
        goto L18
    L17:
        processRecord3 = processRecord;
        frozen = false;
        goto L18
    L10:
        processRecord = this.mSupervisor.mService.getProcessController(launchedActivity.processName, launchedActivity.info.applicationInfo.uid);
        goto L12
    }

    private void updateSplitPairLaunches(TransitionInfo info) {
        Task launchedActivityTask = info.mLastLaunchedActivity.getTask();
        Task launchedSplitRootTask = launchedActivityTask.getTaskWithAdjacent();
        if (launchedSplitRootTask != null) goto L5;
        return;
    L5:
        int i = this.mTransitionInfoList.size() - 1;
    L6:
        if (i < 0) goto L18;
        TransitionInfo otherInfo = this.mTransitionInfoList.get(i);
        if (otherInfo == info) goto L16;
        final Task otherTask = otherInfo.mLastLaunchedActivity.getTask();
        otherTask.getClass();
        boolean isDescendantOfAdjacent = launchedSplitRootTask.forOtherAdjacentTasks(new ActivityMetricsLogger$$ExternalSyntheticLambda2(otherTask));
        if (isDescendantOfAdjacent == false) goto L16;
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L15;
        Slog.i(TAG, "Found adjacent tasks t1=" + launchedActivityTask.mTaskId + " t2=" + otherTask.mTaskId);
    L15:
        info.mMultiWindowLaunchType = 1;
        otherInfo.mMultiWindowLaunchType = 1;
    L16:
        i = i - 1;
        goto L6
    }

    private void scheduleCheckActivityToBeDrawnIfSleeping(ActivityRecord r) {
        if (r.mDisplayContent.isSleeping() == false) goto L6;
        scheduleCheckActivityToBeDrawn(r, 3000);
        return;
    }

    TransitionInfoSnapshot notifyWindowsDrawn(ActivityRecord r) {
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L5;
        Slog.i(TAG, "notifyWindowsDrawn " + r);
    L5:
        long timestampNs = SystemClock.uptimeNanos();
        int prefetchState = 0;
        prefetchState = SysOptBridge.getFactory().getSysPrefetchService().getPrefetchStateByInfo(r.info.applicationInfo.packageName, r.info.applicationInfo.uid);     // Catch: Exception -> L9
    L8:
        int prefetchState2 = prefetchState;
        boolean notRealUserAction = SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(prefetchState2);
        boolean prefetchEffect = SysMonitorFwBridge.getFactory().getPrefetchState().prefetchActivityNotShown(prefetchState2);
        TransitionInfo info = getActiveTransitionInfo(r);
        ActivityMetricsLoggerIA r0 = null;
        if (info == null) goto L30;
        if (info.mIsDrawn == true) goto L30;
        info.mWindowsDrawnDelayMs = info.calculateDelay(timestampNs);
        info.mIsDrawn = true;
        info.prefetchEffect = prefetchEffect;
        info.mWindowsDrawnTime = timestampNs;
        final TransitionInfoSnapshot infoSnapshot = new TransitionInfoSnapshot(info, r0);
        if (info.mLoggedTransitionStarting == false) goto L19;
    L22:
        if (notRealUserAction == true) goto L25;
        if (prefetchEffect == false) goto L25;
        SysOptBridge.getFactory().getSysPrefetchService().setPrefetchState(r.info.applicationInfo.uid, r.info.applicationInfo.packageName, 262144);
    L25:
        this.mSmtEx.reportWindowsDrawn(TransitionInfoSnapshot.getSysType(info.mTransitionType), info.mActivityOptions, info.prefetchEffect, info.mLastLaunchedActivity, info.mTransitionStartTime, info.mWindowsDrawnTime);
        this.mSmtEx.notifyWindowsDrawn(r.info.applicationInfo, infoSnapshot.processRecord, info.mTransitionType, info.prefetchEffect);
        done(false, info, "notifyWindowsDrawn", timestampNs);
        final long timestampNs2 = timestampNs;
    L26:
        final int pid = r.getPid();
        this.mLoggerHandler.post(new ActivityMetricsLogger$$ExternalSyntheticLambda10(this, timestampNs2, infoSnapshot, pid));
        return infoSnapshot;
    L19:
        if (r.mTransitionController.isCollecting(r) == false) goto L22;
        timestampNs2 = timestampNs;
    L30:
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L32;
        Slog.i(TAG, "notifyWindowsDrawn not pending drawn " + info);
    L32:
        return null;
    }

    private /* synthetic */ void lambda$notifyWindowsDrawn$0(long timestampNs, TransitionInfoSnapshot infoSnapshot, int pid) {
        this.mSupervisor.mService.mWindowManager.mAmInternal.addStartInfoTimestamp(4, timestampNs, TransitionInfoSnapshot.m9627$$Nest$fgetapplicationInfo(infoSnapshot).uid, pid, infoSnapshot.userId);
    }

    void notifyStartingWindowDrawn(ActivityRecord r) {
        TransitionInfo info = getActiveTransitionInfo(r);
        if (info != null) goto L5;
        return;
    L5:
        if (info.mLoggedStartingWindowDrawn == false) goto L8;
        return;
    L8:
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L10;
        Slog.i(TAG, "notifyStartingWindowDrawn " + r);
    L10:
        info.mLoggedStartingWindowDrawn = true;
        info.mStartingWindowDelayMs = info.calculateCurrentDelay();
    }

    void notifyTransitionStarting(ArrayMap<WindowContainer, Integer> activityToReason) {
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L5;
        Slog.i(TAG, "notifyTransitionStarting " + activityToReason);
    L5:
        long timestampNs = SystemClock.uptimeNanos();
        boolean r9 = true;
        int index = activityToReason.size() - 1;
    L6:
        if (index < 0) goto L34;
        WindowContainer<?> wc = activityToReason.keyAt(index);
        ActivityRecord activity = wc.asActivityRecord();
        if (activity == null) goto L10;
        ActivityRecord r0 = activity;
    L11:
        ActivityRecord r = r0;
        TransitionInfo info = getActiveTransitionInfo(r);
        if (info == null) goto L32;
        if (info.mLoggedTransitionStarting == true) goto L32;
        int prefetchState = SysOptBridge.getFactory().getSysPrefetchService().getPrefetchStateByInfo(r.info.applicationInfo.packageName, r.info.applicationInfo.uid);     // Catch: Exception -> L19
    L21:
        boolean notRealUserAction = SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(prefetchState);
        boolean prefetchEffect = SysMonitorFwBridge.getFactory().getPrefetchState().prefetchActivityNotShown(prefetchState);
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L24;
        Slog.i(TAG, "notifyTransitionStarting activity=" + wc + " info=" + info);
    L24:
        info.mCurrentTransitionDelayMs = info.calculateDelay(timestampNs);
        info.mReason = activityToReason.valueAt(index).intValue();
        info.mLoggedTransitionStarting = r9;
        info.prefetchEffect = prefetchEffect;
        info.mTransitionStartTime = timestampNs;
        if (info.mIsDrawn == false) goto L32;
        if (notRealUserAction == true) goto L30;
        if (prefetchEffect == false) goto L30;
        SysOptBridge.getFactory().getSysPrefetchService().setPrefetchState(r.info.applicationInfo.uid, r.info.applicationInfo.packageName, 262144);
    L30:
        done(notRealUserAction, info, "notifyTransitionStarting drawn", timestampNs);
    L20:
        prefetchState = 0;
    L32:
        index = index - 1;
        r9 = true;
        goto L6
    L10:
        r0 = wc.getTopActivity(false, r9);
        goto L11
    }

    void notifyActivityRelaunched(ActivityRecord r) {
        TransitionInfo info = getActiveTransitionInfo(r);
        if (info == null) goto L6;
        info.mRelaunched = true;
        return;
    }

    void notifyActivityRemoved(ActivityRecord r) {
        this.mLastTransitionInfo.remove(r);
        TransitionInfo info = getActiveTransitionInfo(r);
        if (info == null) goto L5;
        abort(info, "removed");
    L5:
        int packageUid = r.info.applicationInfo.uid;
        PackageCompatStateInfo compatStateInfo = this.mPackageUidToCompatStateInfo.get(packageUid);
        if (compatStateInfo != null) goto L8;
        return;
    L8:
        compatStateInfo.mVisibleActivities.remove(r);
        if (compatStateInfo.mLastLoggedActivity != r) goto L12;
        compatStateInfo.mLastLoggedActivity = null;
        return;
    }

    void notifyVisibilityChanged(ActivityRecord r) {
        TransitionInfo info = getActiveTransitionInfo(r);
        if (info != null) goto L6;
        return;
    L6:
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L9;
        Slog.i(TAG, "notifyVisibilityChanged " + r + " visible=" + r.isVisibleRequested() + " state=" + r.getState() + " finishing=" + r.finishing);
    L9:
        if (r.isState(ActivityRecord.State.RESUMED) == false) goto L14;
        if (r.mDisplayContent.isSleeping() == false) goto L14;
        return;
    L14:
        if (r.isVisibleRequested() == true) goto L16;
    L17:
        scheduleCheckActivityToBeDrawn(r, 0);
        return;
    L16:
        if (r.finishing == true) goto L17;
    }

    private void scheduleCheckActivityToBeDrawn(ActivityRecord r, long delay) {
        r.mAtmService.mH.sendMessageDelayed(PooledLambda.obtainMessage(new ActivityMetricsLogger$$ExternalSyntheticLambda9(), this, r.getTask(), r), delay);
    }

    private void checkActivityToBeDrawn(Task t, ActivityRecord r) {
        WindowManagerGlobalLock r0 = this.mSupervisor.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        TransitionInfo info = getActiveTransitionInfo(r);     // Catch: Throwable -> L9
        if (info != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L11:
        if (t == null) goto L18;
        if (t.forAllActivities(new ActivityMetricsLogger$$ExternalSyntheticLambda1()) == false) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L18:
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L20;
        Slog.i(TAG, "checkActivityToBeDrawn cancels activity=" + r);     // Catch: Throwable -> L9
    L20:
        logAppTransitionCancel(info);     // Catch: Throwable -> L9
        abort(info, "checkActivityToBeDrawn (invisible or drawn already)");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ boolean lambda$checkActivityToBeDrawn$1(ActivityRecord a) {
        if (a.isVisibleRequested() == true) goto L5;
    L9:
        return false;
    L5:
        if (a.isReportedDrawn() == true) goto L9;
        if (a.finishing == true) goto L9;
        return true;
    }

    private AppHibernationManagerInternal getAppHibernationManagerInternal() {
        if (AppHibernationService.isAppHibernationEnabled() == true) goto L7;
        return null;
    L7:
        if (this.mAppHibernationManagerInternal != null) goto L10;
        this.mAppHibernationManagerInternal = (AppHibernationManagerInternal) LocalServices.getService(AppHibernationManagerInternal.class);
    L10:
        return this.mAppHibernationManagerInternal;
    }

    void notifyBeforePackageUnstopped(String packageName) {
        AppHibernationManagerInternal ahmInternal = getAppHibernationManagerInternal();
        if (ahmInternal == null) goto L6;
        this.mLastHibernationStates.put(packageName, Boolean.valueOf(ahmInternal.isHibernatingGlobally(packageName)));
        return;
    }

    void notifyBindApplication(ApplicationInfo appInfo) {
        int i = this.mTransitionInfoList.size() - 1;
    L3:
        if (i < 0) goto L13;
        TransitionInfo info = this.mTransitionInfoList.get(i);
        if (info.mLastLaunchedActivity.info.applicationInfo != appInfo) goto L11;
        info.mBindApplicationDelayMs = info.calculateCurrentDelay();
        if (info.mProcessRunning == false) goto L11;
        info.mProcessRunning = false;
        info.mTransitionType = 7;
        String msg = "Process " + info.mLastLaunchedActivity.info.processName + " restarted";
        Slog.i(TAG, msg);
        if (info.mLaunchingState.mTraceName == null) goto L11;
        Trace.instant(64, msg + "#" + LaunchingState.m9626$$Nest$sfgetsTraceSeqId());
    L11:
        i = i - 1;
        goto L3
    }

    private void abort(LaunchingState state, String cause) {
        if (LaunchingState.m9622$$Nest$fgetmAssociatedTransitionInfo(state) == null) goto L7;
        abort(LaunchingState.m9622$$Nest$fgetmAssociatedTransitionInfo(state), cause);
        return;
    L7:
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L9;
        Slog.i(TAG, "abort launch cause=" + cause);
    L9:
        state.stopTrace(true, null);
        launchObserverNotifyIntentFailed(state.mStartUptimeNs);
    }

    private void abort(TransitionInfo info, String cause) {
        done(true, info, cause, 0);
    }

    private void done(boolean abort, TransitionInfo info, String cause, long timestampNs) {
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L6;
        Slog.i(TAG, "done abort=" + abort + " cause=" + cause + " timestamp=" + timestampNs + " info=" + info);
    L6:
        info.mLaunchingState.stopTrace(abort, info);
        stopLaunchTrace(info);
        Boolean isHibernating = this.mLastHibernationStates.remove(info.mLastLaunchedActivity.packageName);
        if (abort == false) goto L9;
        this.mLastTransitionInfo.remove(info.mLastLaunchedActivity);
        this.mSupervisor.stopWaitingForActivityVisible(info.mLastLaunchedActivity);
        launchObserverNotifyActivityLaunchCancelled(info);
    L34:
        this.mTransitionInfoList.remove(info);
        return;
    L9:
        boolean r9 = false;
        if (info.isInterestingToLoggerAndObserver() == false) goto L29;
        launchObserverNotifyActivityLaunchFinished(info, timestampNs);
        if (info.mWindowsDrawnDelayMs > 1100) goto L14;
    L18:
        boolean shouldSnapshot = false;
    L20:
        if (SysMonitorFwBridge.getFactory().getResprobe().isFeatureEnabled() == false) goto L28;
        if (shouldSnapshot == false) goto L28;
        int pid = info.mLastLaunchedActivity.app.getPid();
        Trace.traceBegin(64, "Resprobe snapshot 1");
        boolean ok = SysMonitorFwBridge.getFactory().getResprobe().snapshot(pid, pid, 132, 1);
        Trace.traceEnd(64);
        if (ok != true) goto L27;
        Slog.d(TAG, "Resprobe snapshot 1 success, pid=" + pid + " startdur " + info.mWindowsDrawnDelayMs);
        boolean ok2 = SysMonitorFwBridge.getFactory().getResprobe().diff(pid, 0, 1);
        if (ok2 != true) goto L28;
        info.mResprobeJson = SysMonitorFwBridge.getFactory().getResprobe().toJson();
        Slog.d(TAG, "Resprobe diff json, pid=" + pid + ", json=" + SysMonitorFwBridge.getFactory().getResprobe().toJson());
        goto L28
    L27:
        Slog.e(TAG, "Resprobe snapshot 1 failed, pid=" + pid);
    L28:
        info.mNetqFinish = SysFwBridge.getFactory().getNetQualityParserOpt().readQualityEx();
        info.mResprobeJson = appendLaunchNetqInfo(info.mResprobeJson, info.mNetqStart, info.mNetqFinish);
        Trace.traceBegin(64, "netq_finish:" + info.mNetqFinish);
        Trace.traceEnd(64);
        Slog.d(TAG, "Resprobe with netq info, json=" + info.mResprobeJson);
        goto L29
    L14:
        if (info.mLastLaunchedActivity == null) goto L18;
        if (info.mLastLaunchedActivity.app == null) goto L18;
        shouldSnapshot = true;
    L29:
        if (isHibernating == null) goto L31;
        r9 = isHibernating.booleanValue();
    L31:
        logAppTransitionFinished(info, r9);
        if (info.mReason != 5) goto L34;
        logRecentsAnimationLatency(info);
        goto L34
    }

    private void logAppTransitionCancel(TransitionInfo info) {
        int type = info.mTransitionType;
        ActivityRecord activity = info.mLastLaunchedActivity;
        LogMaker builder = new LogMaker(1144);
        builder.setPackageName(activity.packageName);
        builder.setType(type);
        builder.addTaggedData(871, activity.info.name);
        this.mMetricsLogger.write(builder);
        FrameworkStatsLog.write(49, activity.info.applicationInfo.uid, activity.packageName, getAppStartTransitionType(type, info.mRelaunched), activity.info.name);
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L6;
        Slog.i(TAG, String.format("APP_START_CANCELED(%s, %s, %s, %s)", new Object[]{Integer.valueOf(activity.info.applicationInfo.uid), activity.packageName, Integer.valueOf(getAppStartTransitionType(type, info.mRelaunched)), activity.info.name}));
        return;
    }

    private void logAppTransitionFinished(final TransitionInfo info, final boolean isHibernating) {
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L5;
        Slog.i(TAG, "logging finished transition " + info);
    L5:
        mLaunchedActivity = info.mLastLaunchedActivity;
        final TransitionInfoSnapshot infoSnapshot = new TransitionInfoSnapshot(info, null);
        final boolean isOpaque = info.mLastLaunchedActivity.mStyleFillsParent;
        final long uptimeNs = info.mLaunchingState.mStartUptimeNs;
        final int transitionDelay = info.mCurrentTransitionDelayMs;
        final int processState = info.mProcessState;
        final int processOomAdj = info.mProcessOomAdj;
        this.mLoggerHandler.post(new ActivityMetricsLogger$$ExternalSyntheticLambda0(this, info, uptimeNs, transitionDelay, infoSnapshot, isHibernating, processState, processOomAdj, isOpaque));
        if (SysOptBridge.getFactory().getResMngConfig().isModuleEnable(IResMngConfig.FEAT_FREEZE, IResMngConfig.MOD_QUICK_FREEZE) == false) goto L9;
        FeatLog.d(TAG, "FEAT_FREEZE_WHEN_LAUNCH_APP", 40, "AML logAppTransitionFinished unFreezeAppsAfterStartProcess");
        SysOptBridge.getFactory().getSmartService().unFreezeAppsByStartProcess();
    L9:
        if (info.mPendingFullyDrawn == null) goto L11;
        info.mPendingFullyDrawn.run();
    L11:
        info.mLastLaunchedActivity.info.launchToken = null;
    }

    private /* synthetic */ void lambda$logAppTransitionFinished$2(TransitionInfo info, long uptimeNs, int transitionDelay, TransitionInfoSnapshot infoSnapshot, boolean isHibernating, int processState, int processOomAdj, boolean isOpaque) {
        if (info.isInterestingToLoggerAndObserver() == false) goto L6;
        logAppTransition(uptimeNs, transitionDelay, infoSnapshot, isHibernating, processState, processOomAdj);
    L6:
        if (info.mIsInTaskActivityStart == false) goto L10;
        logInTaskActivityStart(infoSnapshot, isOpaque, transitionDelay);
    L10:
        if (infoSnapshot.isInterestedToEventLog() == false) goto L13;
        logAppDisplayed(infoSnapshot);
        return;
    }

    private void logAppTransition(long r42, int r44, TransitionInfoSnapshot r45, boolean r46, int r47, int r48) {
        LogMaker r2 = new LogMaker(FrameworkStatsLog.HOTWORD_EGRESS_SIZE_ATOM_REPORTED);
        r2.setPackageName(r45.packageName);
        r2.setType(r45.type);
        r2.addTaggedData(871, r45.launchedActivityName);
        boolean r10 = TransitionInfoSnapshot.m9627$$Nest$fgetapplicationInfo(r45).isInstantApp();
        if (TransitionInfoSnapshot.m9630$$Nest$fgetlaunchedActivityLaunchedFromPackage(r45) == null) goto L5;
        r2.addTaggedData(904, TransitionInfoSnapshot.m9630$$Nest$fgetlaunchedActivityLaunchedFromPackage(r45));
    L5:
        String r3 = TransitionInfoSnapshot.m9629$$Nest$fgetlaunchedActivityLaunchToken(r45);
        if (r3 == null) goto L8;
        r2.addTaggedData(903, r3);
    L8:
        r2.addTaggedData(905, Integer.valueOf(r10 ? 1 : 0));
        r2.addTaggedData(325, Long.valueOf(TimeUnit.NANOSECONDS.toSeconds(r42)));
        r2.addTaggedData(319, Integer.valueOf(r44));
        r2.setSubtype(TransitionInfoSnapshot.m9632$$Nest$fgetreason(r45));
        if (TransitionInfoSnapshot.m9633$$Nest$fgetstartingWindowDelayMs(r45) == (-1)) goto L12;
        r2.addTaggedData(321, Integer.valueOf(TransitionInfoSnapshot.m9633$$Nest$fgetstartingWindowDelayMs(r45)));
    L12:
        if (TransitionInfoSnapshot.m9628$$Nest$fgetbindApplicationDelayMs(r45) == (-1)) goto L14;
        r2.addTaggedData(FrameworkStatsLog.BIOMETRIC_ENUMERATED, Integer.valueOf(TransitionInfoSnapshot.m9628$$Nest$fgetbindApplicationDelayMs(r45)));
    L14:
        r2.addTaggedData(322, Integer.valueOf(r45.windowsDrawnDelayMs));
        PackageOptimizationInfo r37 = r45.getPackageOptimizationInfo(getArtManagerInternal());
        r2.addTaggedData(1321, Integer.valueOf(r37.getCompilationReason()));
        r2.addTaggedData(1320, Integer.valueOf(r37.getCompilationFilter()));
        this.mMetricsLogger.write(r2);
        String r38 = TransitionInfoSnapshot.m9627$$Nest$fgetapplicationInfo(r45).getCodePath();
        if (r38 != null) goto L17;
    L19:
        boolean r24 = false;
        boolean r25 = false;
    L20:
        boolean r39 = wasStoppedNeedsLogging(r45);
        if (r39 == false) goto L23;
        int r31 = 2;
    L24:
        boolean r33 = wasFirstLaunch(r45);
        FrameworkStatsLog.write(48, TransitionInfoSnapshot.m9627$$Nest$fgetapplicationInfo(r45).uid, r45.packageName, getAppStartTransitionType(r45.type, r45.relaunched), r45.launchedActivityName, TransitionInfoSnapshot.m9630$$Nest$fgetlaunchedActivityLaunchedFromPackage(r45), r10, 0, TransitionInfoSnapshot.m9632$$Nest$fgetreason(r45), r44, TransitionInfoSnapshot.m9633$$Nest$fgetstartingWindowDelayMs(r45), TransitionInfoSnapshot.m9628$$Nest$fgetbindApplicationDelayMs(r45), r45.windowsDrawnDelayMs, r3, r37.getCompilationReason(), r37.getCompilationFilter(), r45.sourceType, r45.sourceEventDelayMs, r46, r24, r25, r45.launchedActivityName.hashCode(), TimeUnit.NANOSECONDS.toMillis(r45.timestampNs), r47, r48, r31, false, r33, 0, r45.multiWindowLaunchType);
        if (r45.processRecord == null) goto L28;
        r45.processRecord.setWasStoppedLogged(true);
    L28:
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L30;
        Slog.i(TAG, String.format("APP_START_OCCURRED(%s, %s, %s, %s, %s, wasStopped=%b, firstLaunch=%b)", new Object[]{Integer.valueOf(TransitionInfoSnapshot.m9627$$Nest$fgetapplicationInfo(r45).uid), r45.packageName, Integer.valueOf(getAppStartTransitionType(r45.type, r45.relaunched)), r45.launchedActivityName, TransitionInfoSnapshot.m9630$$Nest$fgetlaunchedActivityLaunchedFromPackage(r45), Boolean.valueOf(r39), Boolean.valueOf(r33)}));
    L30:
        logAppStartMemoryStateCapture(r45);
        return;
    L23:
        r31 = 1;
        goto L24
    L17:
        if (IncrementalManager.isIncrementalPath(r38) == false) goto L19;
        r24 = true;
        r25 = isIncrementalLoading(r45.packageName, r45.userId);
        goto L20
    }

    private boolean isIncrementalLoading(String packageName, int userId) {
        IncrementalStatesInfo info = this.mSupervisor.mService.getPackageManagerInternalLocked().getIncrementalStatesInfo(packageName, 0, userId);
        if (info != null) goto L5;
        return false;
    L5:
        if (info.isLoading() == false) goto L9;
        return true;
    L9:
        return false;
    }

    void logInTaskActivityStart(TransitionInfoSnapshot info, boolean isOpaque, int transitionDelayMs) {
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L5;
        Slog.i(TAG, "IN_TASK_ACTIVITY_STARTED " + info.launchedActivityName + " transitionDelayMs=" + transitionDelayMs + "ms");
    L5:
        FrameworkStatsLog.write(FrameworkStatsLog.IN_TASK_ACTIVITY_STARTED, TransitionInfoSnapshot.m9627$$Nest$fgetapplicationInfo(info).uid, getAppStartTransitionType(info.type, info.relaunched), isOpaque, transitionDelayMs, info.windowsDrawnDelayMs, TimeUnit.NANOSECONDS.toMillis(info.timestampNs));
    }

    private void logAppDisplayed(TransitionInfoSnapshot r17) {
        IIoLimiter r1 = SysOptBridge.getFactory().getIoLimiter();
        int r2 = TransitionInfoSnapshot.m9627$$Nest$fgetapplicationInfo(r17).uid;
        int r4 = 0;
        if (r17.processRecord == null) goto L5;
        int r3 = r17.processRecord.getPid();
    L6:
        r1.notifyStopIoLimit(r2, r3);
        ActivityMetricsData r15 = getMatchedMetricsData(r17);
        if (r15 == null) goto L9;
        r15.reportedResprobeJson = r17.resprobeJson;
    L9:
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().updateActivityLaunchTime(TransitionInfoSnapshot.m9627$$Nest$fgetapplicationInfo(r17).getSmtUid(), r17.packageName, r17.launchedActivityShortComponentName, r17.windowsDrawnDelayMs, r17.sysType, r17.launchStartTime, r17.prefetchEffect ? 1 : 0, r15);
        ISysPrefetchService r5 = SysOptBridge.getFactory().getSysPrefetchService();
        String r6 = r17.packageName;
        if (r17.processRecord == null) goto L12;
        int r7 = r17.processRecord.getPid();
    L13:
        r5.notifyBindFinishedOrLaunched(r6, r7, r17.launchStartTime + ((long) r17.windowsDrawnDelayMs));
        EventLog.writeEvent(EventLogTags.WM_ACTIVITY_LAUNCH_TIME, new Object[]{Integer.valueOf(r17.userId), Integer.valueOf(r17.activityRecordIdHashCode), r17.launchedActivityShortComponentName, Integer.valueOf(r17.windowsDrawnDelayMs)});
        StringBuilder r8 = this.mStringBuilder;
        r8.setLength(0);
        r8.append("Displayed ");
        r8.append(r17.launchedActivityShortComponentName);
        r8.append(" for user ");
        r8.append(r17.userId);
        r8.append(": ");
        TimeUtils.formatDuration(r17.windowsDrawnDelayMs, r8);
        r8.append("   systype : ");
        r8.append(r17.sysType);
        r8.append(" startTime: ");
        r8.append(r17.launchStartTime);
        if (r17.prefetchEffect == false) goto L17;
        r8.append(" prefetchEffect: ");
        r8.append(r17.prefetchEffect);
    L17:
        if (mPerfBoost == null) goto L22;
        if (r17.processRecord == null) goto L22;
        mPerfBoost.perfHint(4162, r17.packageName, r17.processRecord.getPid(), r17.windowsDrawnDelayMs);
    L22:
        if (mUxPerf != null) goto L24;
    L28:
        Log.i(TAG, r8.toString());
        if (mUxPerf == null) goto L48;
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L34;
        int r9 = mLaunchedActivity.isAppInfoGame();
    L38:
        if (mLaunchedActivity.processName == null) goto L43;
        if (mLaunchedActivity.processName.equals(r17.packageName) == true) goto L43;
        r9 = 1;
    L43:
        if (mUxPerf.board_first_api_lvl >= 33) goto L48;
        if (mUxPerf.board_api_lvl >= 33) goto L48;
        mUxPerf.perfUXEngine_events(5, 0, r17.packageName, r9);
        goto L48
    L34:
        if (mUxPerf.perfGetFeedback(5633, mLaunchedActivity.packageName) != 2) goto L36;
        r9 = 1;
        goto L38
    L36:
        r9 = 0;
    L48:
        if (mLaunchedActivity.mPerf != null) goto L50;
    L52:
        SysOptBridge.getFactory().getOAutoHelper().onLogAppDisplayed(r17.packageName, r17.launchedActivityShortComponentName, r17.sysType);
        ITransferController r10 = SysMonitorSvcBridge.getFactory().getTransferController();
        String r11 = r17.packageName;
        String r12 = r17.launchedActivityShortComponentName;
        int r13 = r17.sysType;
        long r14 = r17.windowsDrawnDelayMs;
        if (r17.processRecord == null) goto L55;
        r4 = r17.processRecord.getPid();
    L55:
        r10.reportAppDisplayed(r11, r12, r13, r14, r4);
        return;
    L50:
        if (mLaunchedActivity.perfActivityBoostHandler <= 0) goto L52;
        mLaunchedActivity.mPerf.perfLockReleaseHandler(mLaunchedActivity.perfActivityBoostHandler);
        mLaunchedActivity.perfActivityBoostHandler = -1;
        goto L52
    L24:
        if (mUxPerf.board_first_api_lvl >= 33) goto L28;
        if (mUxPerf.board_api_lvl >= 33) goto L28;
        mUxPerf.perfUXEngine_events(3, 0, r17.packageName, r17.windowsDrawnDelayMs);
        goto L28
    L12:
        r7 = 0;
        goto L13
    L5:
        r3 = 0;
        goto L6
    }

    private void logRecentsAnimationLatency(TransitionInfo info) {
        final int duration = info.mSourceEventDelayMs + info.mWindowsDrawnDelayMs;
        final ActivityRecord r = info.mLastLaunchedActivity;
        final long lastTopLossTime = r.topResumedStateLossTime;
        final WindowManagerService wm = this.mSupervisor.mService.mWindowManager;
        this.mLoggerHandler.postDelayed(new ActivityMetricsLogger$$ExternalSyntheticLambda8(lastTopLossTime, r, wm, duration), LATENCY_TRACKER_RECENTS_DELAY_MS);
    }

    private static /* synthetic */ void lambda$logRecentsAnimationLatency$3(long lastTopLossTime, ActivityRecord r, WindowManagerService wm, int duration) {
        if (lastTopLossTime == r.topResumedStateLossTime) goto L5;
        return;
    L5:
        wm.mLatencyTracker.logAction(8, duration);
    }

    private static int getAppStartTransitionType(int tronType, boolean relaunched) {
        if (tronType != 7) goto L7;
        return 3;
    L7:
        if (tronType != 8) goto L11;
        return 1;
    L11:
        if (tronType != 9) goto L16;
        if (relaunched == false) goto L14;
        return 4;
    L14:
        return 2;
    L16:
        return 0;
    }

    TransitionInfoSnapshot notifyFullyDrawn(final ActivityRecord r, final boolean restoredFromBundle) {
        final TransitionInfo info = this.mLastTransitionInfo.get(r);
        ActivityMetricsLoggerIA r1 = null;
        if (info != null) goto L6;
        return null;
    L6:
        if (info.mIsDrawn == false) goto L8;
    L11:
        long currentTimestampNs = SystemClock.uptimeNanos();
        if (info.mPendingFullyDrawn == null) goto L14;
        long startupTimeMs = info.mWindowsDrawnDelayMs;
    L15:
        final TransitionInfoSnapshot infoSnapshot = new TransitionInfoSnapshot(info, r, (int) startupTimeMs, r1);
        if (infoSnapshot.isInterestedToEventLog() == false) goto L18;
        this.mLoggerHandler.post(new ActivityMetricsLogger$$ExternalSyntheticLambda4(this, infoSnapshot));
    L18:
        this.mLastTransitionInfo.remove(r);
        if (info.isInterestingToLoggerAndObserver() == true) goto L21;
        return infoSnapshot;
    L21:
        Trace.traceBegin(64, "ActivityManager:ReportingFullyDrawn " + info.mLastLaunchedActivity.packageName);
        this.mLoggerHandler.post(new ActivityMetricsLogger$$ExternalSyntheticLambda5(this, infoSnapshot, restoredFromBundle, info));
        Trace.traceEnd(64);
        launchObserverNotifyReportFullyDrawn(info, currentTimestampNs);
        return infoSnapshot;
    L14:
        startupTimeMs = TimeUnit.NANOSECONDS.toMillis(currentTimestampNs - info.mLaunchingState.mStartUptimeNs);
        goto L15
    L8:
        if (info.mPendingFullyDrawn != null) goto L11;
        info.mPendingFullyDrawn = new ActivityMetricsLogger$$ExternalSyntheticLambda3(this, r, restoredFromBundle, info);
        return null;
    }

    private /* synthetic */ void lambda$notifyFullyDrawn$4(ActivityRecord r, boolean restoredFromBundle, TransitionInfo info) {
        notifyFullyDrawn(r, restoredFromBundle);
        info.mPendingFullyDrawn = null;
    }

    private /* synthetic */ void lambda$notifyFullyDrawn$5(TransitionInfoSnapshot infoSnapshot) {
        logAppFullyDrawn(infoSnapshot);
    }

    private /* synthetic */ void lambda$notifyFullyDrawn$6(TransitionInfoSnapshot infoSnapshot, boolean restoredFromBundle, TransitionInfo info) {
        logAppFullyDrawnMetrics(infoSnapshot, restoredFromBundle, info.mProcessRunning);
    }

    private void logAppFullyDrawnMetrics(TransitionInfoSnapshot r27, boolean r28, boolean r29) {
        LogMaker r2 = new LogMaker(1090);
        r2.setPackageName(r27.packageName);
        r2.addTaggedData(871, r27.launchedActivityName);
        r2.addTaggedData(1091, Long.valueOf(r27.windowsFullyDrawnDelayMs));
        if (r28 == false) goto L5;
        int r3 = 13;
    L6:
        r2.setType(r3);
        r2.addTaggedData(FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_ACTIVE_DEVICE_ADMIN, Integer.valueOf(r29 ? 1 : 0));
        this.mMetricsLogger.write(r2);
        PackageOptimizationInfo r4 = r27.getPackageOptimizationInfo(getArtManagerInternal());
        String r6 = TransitionInfoSnapshot.m9627$$Nest$fgetapplicationInfo(r27).getCodePath();
        if (r6 != null) goto L9;
    L11:
        boolean r19 = false;
        boolean r20 = false;
    L12:
        int r8 = TransitionInfoSnapshot.m9627$$Nest$fgetapplicationInfo(r27).uid;
        String r9 = r27.packageName;
        if (r28 == false) goto L15;
        int r10 = 1;
    L16:
        FrameworkStatsLog.write(50, r8, r9, r10, r27.launchedActivityName, r29, r27.windowsFullyDrawnDelayMs, r4.getCompilationReason(), r4.getCompilationFilter(), r27.sourceType, r27.sourceEventDelayMs, r19, r20, r27.launchedActivityName.hashCode(), TimeUnit.NANOSECONDS.toMillis(r27.timestampNs));
        return;
    L15:
        r10 = 2;
        goto L16
    L9:
        if (IncrementalManager.isIncrementalPath(r6) == false) goto L11;
        r19 = true;
        r20 = isIncrementalLoading(r27.packageName, r27.userId);
        goto L12
    L5:
        r3 = 12;
        goto L6
    }

    private void logAppFullyDrawn(TransitionInfoSnapshot info) {
        StringBuilder sb = this.mStringBuilder;
        sb.setLength(0);
        sb.append("Fully drawn ");
        sb.append(info.launchedActivityShortComponentName);
        sb.append(": ");
        TimeUtils.formatDuration(info.windowsFullyDrawnDelayMs, sb);
        Log.i(TAG, sb.toString());
    }

    void logAbortedBgActivityStart(Intent r10, WindowProcessController r11, int r12, String r13, int r14, boolean r15, int r16, int r17, boolean r18, boolean r19) {
        long r0 = SystemClock.elapsedRealtime();
        long r2 = SystemClock.uptimeMillis();
        LogMaker r4 = new LogMaker(1513);
        r4.setTimestamp(System.currentTimeMillis());
        r4.addTaggedData(1514, Integer.valueOf(r12));
        r4.addTaggedData(1515, r13);
        r4.addTaggedData(1516, Integer.valueOf(ActivityManager.processStateAmToProto(r14)));
        r4.addTaggedData(1517, Integer.valueOf(r15 ? 1 : 0));
        r4.addTaggedData(1518, Integer.valueOf(r16));
        r4.addTaggedData(1519, Integer.valueOf(ActivityManager.processStateAmToProto(r17)));
        r4.addTaggedData(1520, Integer.valueOf(r18 ? 1 : 0));
        r4.addTaggedData(1527, Integer.valueOf(r19 ? 1 : 0));
        if (r10 == null) goto L7;
        r4.addTaggedData(1528, r10.getAction());
        ComponentName r5 = r10.getComponent();
        if (r5 == null) goto L7;
        r4.addTaggedData(1526, r5.flattenToShortString());
    L7:
        if (r11 == null) goto L17;
        r4.addTaggedData(1529, r11.mName);
        r4.addTaggedData(1530, Integer.valueOf(ActivityManager.processStateAmToProto(r11.getCurrentProcState())));
        r4.addTaggedData(1531, Integer.valueOf(r11.hasClientActivities() ? 1 : 0));
        r4.addTaggedData(1532, Integer.valueOf(r11.hasForegroundServices() ? 1 : 0));
        r4.addTaggedData(1533, Integer.valueOf(r11.hasForegroundActivities() ? 1 : 0));
        r4.addTaggedData(1534, Integer.valueOf(r11.hasTopUi() ? 1 : 0));
        r4.addTaggedData(1535, Integer.valueOf(r11.hasOverlayUi() ? 1 : 0));
        r4.addTaggedData(1536, Integer.valueOf(r11.hasPendingUiClean() ? 1 : 0));
        if (r11.getInteractionEventTime() == 0) goto L12;
        r4.addTaggedData(UsbTerminalTypes.TERMINAL_EXTERN_ANALOG, Long.valueOf(r0 - r11.getInteractionEventTime()));
    L12:
        if (r11.getFgInteractionTime() == 0) goto L15;
        r4.addTaggedData(UsbTerminalTypes.TERMINAL_EXTERN_DIGITAL, Long.valueOf(r0 - r11.getFgInteractionTime()));
    L15:
        if (r11.getWhenUnimportant() == 0) goto L17;
        r4.addTaggedData(1539, Long.valueOf(r2 - r11.getWhenUnimportant()));
    L17:
        this.mMetricsLogger.write(r4);
    }

    private void logAppStartMemoryStateCapture(TransitionInfoSnapshot info) {
        if (info.processRecord == null) goto L5;
        int pid = info.processRecord.getPid();
        int uid = TransitionInfoSnapshot.m9627$$Nest$fgetapplicationInfo(info).uid;
        MemoryStatUtil.MemoryStat memoryStat = MemoryStatUtil.readMemoryStatFromFilesystem(uid, pid);
        if (memoryStat == null) goto L11;
        FrameworkStatsLog.write(55, uid, TransitionInfoSnapshot.m9631$$Nest$fgetprocessName(info), info.launchedActivityName, memoryStat.pgfault, memoryStat.pgmajfault, memoryStat.rssInBytes, memoryStat.cacheInBytes, memoryStat.swapInBytes);
        return;
    L11:
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L17;
        Slog.i(TAG, "logAppStartMemoryStateCapture memoryStat null");
        return;
    L17:
        return;
    L5:
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L16;
        Slog.i(TAG, "logAppStartMemoryStateCapture processRecord null");
        return;
    }

    void logAppCompatState(ActivityRecord activity) {
        int packageUid = activity.info.applicationInfo.uid;
        int state = activity.getAppCompatState();
        if (this.mPackageUidToCompatStateInfo.contains(packageUid) == true) goto L5;
        this.mPackageUidToCompatStateInfo.put(packageUid, new PackageCompatStateInfo(null));
    L5:
        PackageCompatStateInfo compatStateInfo = this.mPackageUidToCompatStateInfo.get(packageUid);
        int lastLoggedState = compatStateInfo.mLastLoggedState;
        ActivityRecord lastLoggedActivity = compatStateInfo.mLastLoggedActivity;
        if (state == 1) goto L8;
        boolean isVisible = true;
    L9:
        ArrayList<ActivityRecord> visibleActivities = compatStateInfo.mVisibleActivities;
        if (isVisible == true) goto L12;
    L14:
        if (isVisible == true) goto L18;
        visibleActivities.remove(activity);
        if (visibleActivities.isEmpty() == false) goto L18;
        this.mPackageUidToCompatStateInfo.remove(packageUid);
    L18:
        if (state != lastLoggedState) goto L20;
        return;
    L20:
        if (isVisible == false) goto L22;
    L27:
        if (lastLoggedActivity == null) goto L33;
        if (activity == lastLoggedActivity) goto L33;
        if (lastLoggedState == 1) goto L33;
        if (lastLoggedState == 2) goto L33;
        return;
    L33:
        logAppCompatStateInternal(activity, state, compatStateInfo);
        return;
    L22:
        if (visibleActivities.isEmpty() == true) goto L27;
        if (lastLoggedActivity == null) goto L25;
        if (activity == lastLoggedActivity) goto L25;
        return;
    L25:
        findAppCompatStateToLog(compatStateInfo, packageUid);
        return;
    L12:
        if (visibleActivities.contains(activity) == true) goto L14;
        visibleActivities.add(activity);
        goto L18
    L8:
        isVisible = false;
        goto L9
    }

    private void findAppCompatStateToLog(PackageCompatStateInfo compatStateInfo, int packageUid) {
        ArrayList<ActivityRecord> visibleActivities = compatStateInfo.mVisibleActivities;
        int lastLoggedState = compatStateInfo.mLastLoggedState;
        ActivityRecord activityToLog = null;
        int stateToLog = 1;
        int i = 0;
    L4:
        if (i >= visibleActivities.size()) goto L18;
        ActivityRecord activity = visibleActivities.get(i);
        int state = activity.getAppCompatState();
        if (state == lastLoggedState) goto L7;
        if (state != 1) goto L11;
        Slog.w(TAG, "Visible activity with NOT_VISIBLE App Compat state for package UID: " + packageUid);
    L16:
        i = i + 1;
        goto L4
    L11:
        if (stateToLog != 1) goto L13;
    L15:
        activityToLog = activity;
        stateToLog = state;
        goto L16
    L13:
        if (stateToLog != 2) goto L16;
        if (state == 2) goto L16;
    L7:
        compatStateInfo.mLastLoggedActivity = activity;
        return;
    L18:
        if (activityToLog == null) goto L28;
        if (stateToLog == 1) goto L29;
        logAppCompatStateInternal(activityToLog, stateToLog, compatStateInfo);
        return;
    L29:
        return;
    }

    private static boolean isAppCompateStateChangedToLetterboxed(int state) {
        if (state != 5) goto L5;
    L10:
        return true;
    L5:
        if (state == 4) goto L10;
        if (state == 3) goto L10;
        return false;
    }

    private void logAppCompatStateInternal(ActivityRecord activity, int state, PackageCompatStateInfo compatStateInfo) {
        compatStateInfo.mLastLoggedState = state;
        compatStateInfo.mLastLoggedActivity = activity;
        int packageUid = activity.info.applicationInfo.uid;
        int positionToLog = 1;
        if (isAppCompateStateChangedToLetterboxed(state) == false) goto L5;
        positionToLog = activity.mAppCompatController.getReachabilityOverrides().getLetterboxPositionForLogging();
    L5:
        FrameworkStatsLog.write(FrameworkStatsLog.APP_COMPAT_STATE_CHANGED, packageUid, state, positionToLog);
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L9;
        Slog.i(TAG, String.format("APP_COMPAT_STATE_CHANGED(%s, %s, %s)", new Object[]{Integer.valueOf(packageUid), Integer.valueOf(state), Integer.valueOf(positionToLog)}));
        return;
    }

    void logLetterboxPositionChange(ActivityRecord activity, int position) {
        int packageUid = activity.info.applicationInfo.uid;
        FrameworkStatsLog.write(FrameworkStatsLog.LETTERBOX_POSITION_CHANGED, packageUid, position);
        if (this.mPackageUidToCompatStateInfo.contains(packageUid) == true) goto L5;
        return;
    L5:
        PackageCompatStateInfo compatStateInfo = this.mPackageUidToCompatStateInfo.get(packageUid);
        ActivityRecord lastLoggedActivity = compatStateInfo.mLastLoggedActivity;
        if (activity == lastLoggedActivity) goto L8;
        return;
    L8:
        int state = activity.getAppCompatState();
        logAppCompatStateInternal(activity, state, compatStateInfo);
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L12;
        Slog.i(TAG, String.format("LETTERBOX_POSITION_CHANGED(%s, %s)", new Object[]{Integer.valueOf(packageUid), Integer.valueOf(position)}));
        return;
    }

    private ArtManagerInternal getArtManagerInternal() {
        if (this.mArtManagerInternal != null) goto L6;
        this.mArtManagerInternal = (ArtManagerInternal) LocalServices.getService(ArtManagerInternal.class);
    L6:
        return this.mArtManagerInternal;
    }

    private void startLaunchTrace(TransitionInfo info) {
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L6;
        Slog.i(TAG, "startLaunchTrace " + info);
    L6:
        if (info.mLaunchingState.mTraceName != null) goto L8;
        return;
    L8:
        info.mLaunchTraceName = "launching: " + info.mLastLaunchedActivity.packageName;
        Trace.asyncTraceBegin(64, info.mLaunchTraceName, (int) info.mLaunchingState.mStartRealtimeNs);
    }

    private void stopLaunchTrace(TransitionInfo info) {
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L6;
        Slog.i(TAG, "stopLaunchTrace " + info);
    L6:
        if (info.mLaunchTraceName != null) goto L8;
        return;
    L8:
        Trace.asyncTraceEnd(64, info.mLaunchTraceName, (int) info.mLaunchingState.mStartRealtimeNs);
        info.mLaunchTraceName = null;
    }

    public ActivityMetricsLaunchObserverRegistry getLaunchObserverRegistry() {
        return this.mLaunchObserver;
    }

    private void launchObserverNotifyIntentStarted(Intent intent, long timestampNs) {
        Trace.traceBegin(64, "MetricsLogger:launchObserverNotifyIntentStarted");
        getSmtEx().tryDoUfsBoost("500");
        this.mLaunchObserver.onIntentStarted(intent, timestampNs);
        Trace.traceEnd(64);
    }

    private void launchObserverNotifyIntentFailed(long id) {
        Trace.traceBegin(64, "MetricsLogger:launchObserverNotifyIntentFailed");
        this.mLaunchObserver.onIntentFailed(id);
        Trace.traceEnd(64);
    }

    private void launchObserverNotifyActivityLaunched(TransitionInfo info) {
        Trace.traceBegin(64, "MetricsLogger:launchObserverNotifyActivityLaunched");
        int temperature = convertTransitionTypeToLaunchObserverTemperature(info.mTransitionType);
        this.mLaunchObserver.onActivityLaunched(info.mLaunchingState.mStartUptimeNs, info.mLastLaunchedActivity.mActivityComponent, temperature, info.mLastLaunchedActivity.mUserId);
        Trace.traceEnd(64);
    }

    private void launchObserverNotifyReportFullyDrawn(TransitionInfo info, long timestampNs) {
        Trace.traceBegin(64, "MetricsLogger:launchObserverNotifyReportFullyDrawn");
        this.mLaunchObserver.onReportFullyDrawn(info.mLaunchingState.mStartUptimeNs, timestampNs);
        Trace.traceEnd(64);
    }

    private void launchObserverNotifyActivityLaunchCancelled(TransitionInfo info) {
        Trace.traceBegin(64, "MetricsLogger:launchObserverNotifyActivityLaunchCancelled");
        this.mLaunchObserver.onActivityLaunchCancelled(info.mLaunchingState.mStartUptimeNs);
        Trace.traceEnd(64);
    }

    private void launchObserverNotifyActivityLaunchFinished(TransitionInfo info, long timestampNs) {
        Trace.traceBegin(64, "MetricsLogger:launchObserverNotifyActivityLaunchFinished");
        this.mLaunchObserver.onActivityLaunchFinished(info.mLaunchingState.mStartUptimeNs, info.mLastLaunchedActivity.mActivityComponent, timestampNs, info.mLastLaunchedActivity.launchMode);
        Trace.traceEnd(64);
    }

    private static int convertTransitionTypeToLaunchObserverTemperature(int transitionType) {
        switch(transitionType) {
            case 7: goto L9;
            case 8: goto L7;
            case 9: goto L5;
            default: goto L3;
        };
    L3:
        return -1;
    L5:
        return 3;
    L7:
        return 2;
    L9:
        return 1;
    }

    private boolean wasStoppedNeedsLogging(TransitionInfoSnapshot info) {
        if (info.processRecord == null) goto L14;
        if (info.processRecord.wasForceStopped() == true) goto L9;
        if (info.processRecord.wasFirstLaunch() == true) goto L9;
        return false;
    L9:
        if (info.processRecord.getWasStoppedLogged() == false) goto L12;
        return false;
    L12:
        return true;
    L14:
        if ((TransitionInfoSnapshot.m9627$$Nest$fgetapplicationInfo(info).flags & 2097152) != 0) goto L16;
        return false;
    L16:
        return true;
    }

    private boolean wasFirstLaunch(TransitionInfoSnapshot info) {
        if (info.processRecord != null) goto L5;
        return !this.mSupervisor.mService.getPackageManagerInternalLocked().wasPackageEverLaunched(info.packageName, info.userId);
    L15:
        return true;
    L5:
        if (info.processRecord.wasFirstLaunch() == true) goto L7;
    L9:
        return false;
    L7:
        if (info.processRecord.getWasStoppedLogged() == true) goto L9;
        return true;
    }

    public void notifyActivityMetrics(ActivityRecord record, ActivityMetricsData data) {
        Object r0 = this.mDataLock;
        monitor-enter(r0);
        data.reportedTime = System.currentTimeMillis();     // Catch: Throwable -> L7
        data.reportedActivityName = record.info.name;     // Catch: Throwable -> L7
        data.reportedRecordHashCode = System.identityHashCode(record);     // Catch: Throwable -> L7
        this.mActivityMetricsData.add(data);     // Catch: Throwable -> L7
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L9;
        Slog.i(TAG, "notifyActivityMetrics. record=" + record + " data=" + data);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public ActivityMetricsData getMatchedMetricsData(TransitionInfoSnapshot snapShot) {
        ActivityMetricsData result = null;
        Object r1 = this.mDataLock;
        monitor-enter(r1);
        long currentTime = System.currentTimeMillis();     // Catch: Throwable -> L19
        int i = this.mActivityMetricsData.size() - 1;     // Catch: Throwable -> L19
    L5:
        if (i < 0) goto L27;
        if (TransitionInfoSnapshot.m9631$$Nest$fgetprocessName(snapShot) == null) goto L23;
        if (TransitionInfoSnapshot.m9631$$Nest$fgetprocessName(snapShot).equals(this.mActivityMetricsData.get(i).processName) == false) goto L23;
        if (snapShot.packageName == null) goto L23;
        if (snapShot.packageName.equals(this.mActivityMetricsData.get(i).packageName) == false) goto L23;
        if (snapShot.activityRecordIdHashCode != this.mActivityMetricsData.get(i).reportedRecordHashCode) goto L23;
        result = this.mActivityMetricsData.get(i);     // Catch: Throwable -> L19
        if (ActivityTaskManagerDebugConfig.DEBUG_METRICS == false) goto L21;
        Slog.i(TAG, "  --- hint!!!");     // Catch: Throwable -> L19
        SysMonitorFwBridge.getFactory().getActivityMetrics().printKeyData(this.mActivityMetricsData.get(i));     // Catch: Throwable -> L19
    L21:
        this.mActivityMetricsData.remove(i);     // Catch: Throwable -> L19
    L25:
        i = i - 1;     // Catch: Throwable -> L19
    L23:
        if ((this.mActivityMetricsData.get(i).reportedTime - currentTime) <= 600000) goto L25;
        this.mActivityMetricsData.remove(i);     // Catch: Throwable -> L19
        goto L25
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L19
        return result;
    L19:
        th = move-exception;
        throw th;
    }

    public ActivityMetricsLoggerSmtBase getSmtEx() {
        return this.mSmtEx;
    }
}
