package com.android.server.power.hint;

import android.adpf.ISessionManager;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.StatsManager;
import android.app.UidObserver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.hardware.power.ChannelConfig;
import android.hardware.power.CpuHeadroomParams;
import android.hardware.power.CpuHeadroomResult;
import android.hardware.power.GpuHeadroomParams;
import android.hardware.power.GpuHeadroomResult;
import android.hardware.power.IPower;
import android.hardware.power.SessionConfig;
import android.hardware.power.SupportInfo;
import android.hardware.power.WorkDuration;
import android.os.Binder;
import android.os.CpuHeadroomParamsInternal;
import android.os.GpuHeadroomParamsInternal;
import android.os.Handler;
import android.os.IBinder;
import android.os.IHintManager;
import android.os.IHintSession;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ServiceSpecificException;
import android.os.SessionCreationConfig;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseIntArray;
import android.util.StatsEvent;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.Preconditions;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.SystemService;
import com.android.server.utils.Slogf;
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class HintManagerService extends SystemService {
    static final int CLEAN_UP_UID_DELAY_MILLIS = 1000;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_CHECK_HEADROOM_PROC_STAT_MIN_MILLIS = 50;
    private static final int DEFAULT_MAX_CPU_HEADROOM_THREADS_COUNT = 5;
    private static final int EVENT_CLEAN_UP_UID = 3;
    static final int MAX_GRAPHICS_PIPELINE_THREADS_COUNT = 5;
    private static final Pattern PROC_STAT_CPU_TIME_TOTAL_PATTERN = null;
    private static final String PROPERTY_CHECK_HEADROOM_AFFINITY = "persist.hms.check_headroom_affinity";
    private static final String PROPERTY_CHECK_HEADROOM_PROC_STAT_MIN_MILLIS = "persist.hms.check_headroom_proc_stat_min_millis";
    private static final String PROPERTY_CHECK_HEADROOM_TID = "persist.hms.check_headroom_tid";
    private static final String PROPERTY_CPU_HEADROOM_TID_MAX_CNT = "persist.hms.cpu_headroom_tid_max_cnt";
    private static final String PROPERTY_HWUI_ENABLE_HINT_MANAGER = "debug.hwui.use_hint_manager";
    private static final String PROPERTY_SF_ENABLE_CPU_HINT = "debug.sf.enable_adpf_cpu_hint";
    private static final String PROPERTY_USE_HAL_HEADROOMS = "persist.hms.use_hal_headrooms";
    private static final String TAG = "HintManagerService";
    private final ArrayMap<Integer, ArrayMap<IBinder, ArraySet<AppHintSession>>> mActiveSessions;
    private final ActivityManagerInternal mAmInternal;
    private ArrayMap<Integer, TreeMap<Integer, ChannelItem>> mChannelMap;
    private final Object mChannelMapLock;
    private final boolean mCheckHeadroomAffinity;
    private final int mCheckHeadroomProcStatMinMillis;
    private final boolean mCheckHeadroomTid;
    private final CleanUpHandler mCleanUpHandler;
    private AtomicBoolean mConfigCreationSupport;
    private final Context mContext;
    private final HeadroomCache<CpuHeadroomParams, CpuHeadroomResult> mCpuHeadroomCache;
    private final Object mCpuHeadroomLock;
    private final int mCpuHeadroomMaxTidCnt;
    private final int mDefaultCpuHeadroomCalculationWindowMillis;
    private final int mDefaultGpuHeadroomCalculationWindowMillis;
    private boolean mEnforceCpuHeadroomUserModeCpuTimeCheck;
    private Boolean mFMQUsesIntegratedEventFlag;
    private final HeadroomCache<GpuHeadroomParams, GpuHeadroomResult> mGpuHeadroomCache;
    private final Object mGpuHeadroomLock;
    final long mHintSessionPreferredRate;
    final float mJiffyMillis;
    private long mLastCpuUserModeJiffies;
    private long mLastCpuUserModeTimeCheckedMillis;
    private final Object mLock;
    private final NativeWrapper mNativeWrapper;
    private final Map<Integer, Set<Long>> mNonIsolatedTids;
    private final Object mNonIsolatedTidsLock;
    private final PackageManager mPackageManager;
    private final IPower mPowerHal;
    private int mPowerHalVersion;
    private String mProcStatFilePathOverride;
    final IHintManager.Stub mService;
    private ISessionManager mSessionManager;
    private ArrayMap<Integer, ArrayMap<Integer, AppHintSessionSnapshot>> mSessionSnapshotMap;
    private final Object mSessionSnapshotMapLock;
    private SupportInfo mSupportInfo;
    private ArrayMap<Integer, ArraySet<ThreadUsageTracker>> mThreadsUsageMap;
    private final Object mThreadsUsageObject;
    final MyUidObserver mUidObserver;
    private final Map<Integer, Long> mUidToLastUserModeJiffies;
    private boolean mUsesFmq;

    final class AppHintSession extends IHintSession.Stub implements IBinder.DeathRecipient {
        protected boolean mGraphicsPipeline;
        protected long mHalSessionPtr;
        protected boolean mHasBeenGraphicsPipeline;
        protected boolean mHasBeenPowerEfficient;
        protected int[] mNewThreadIds;
        protected final int mPid;
        protected boolean mPowerEfficient;
        protected Integer mSessionId;
        protected boolean mShouldForcePause;
        protected final int mTag;
        protected long mTargetDurationNanos;
        protected int[] mThreadIds;
        protected final IBinder mToken;
        protected boolean mTrackedBySF;
        protected final int mUid;
        protected boolean mUpdateAllowedByProcState;
        final /* synthetic */ HintManagerService this$0;

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7685$$Nest$mdump(AppHintSession r0, PrintWriter r1, String r2) {
            r0.dump(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mpause, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7686$$Nest$mpause(AppHintSession r0) {
            r0.pause();
        }

        /* JADX INFO: renamed from: -$$Nest$msetThreadsInternal, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7687$$Nest$msetThreadsInternal(AppHintSession r0, int[] r1, boolean r2) {
            r0.setThreadsInternal(r1, r2);
        }

        protected AppHintSession(HintManagerService this$0, int uid, int pid, int sessionTag, int[] threadIds, IBinder token, long halSessionPtr, long durationNanos, Integer sessionId) {
            this.this$0 = this$0;
            this.mUid = uid;
            this.mPid = pid;
            this.mTag = sessionTag;
            this.mToken = token;
            this.mThreadIds = threadIds;
            this.mHalSessionPtr = halSessionPtr;
            this.mTargetDurationNanos = durationNanos;
            this.mUpdateAllowedByProcState = true;
            this.mPowerEfficient = false;
            this.mGraphicsPipeline = false;
            this.mHasBeenPowerEfficient = false;
            this.mHasBeenGraphicsPipeline = false;
            this.mShouldForcePause = false;
            this.mSessionId = sessionId;
            this.mTrackedBySF = false;
            boolean allowed = this$0.mUidObserver.isUidForeground(this.mUid);
            updateHintAllowedByProcState(allowed);
            token.linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            HintManagerService.m7659$$Nest$fgetmNativeWrapper(this$0).halCloseHintSession(this.mHalSessionPtr);
            throw new IllegalStateException("Client already dead", e);
        }

        boolean updateHintAllowedByProcState(boolean allowed) {
            monitor-enter(this);
            if (allowed == true) goto L20;
        L11:
            if (allowed == false) goto L13;
        L15:
            this.mUpdateAllowedByProcState = allowed;     // Catch: Throwable -> L9
            boolean r0 = this.mUpdateAllowedByProcState;     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return r0;
        L9:
            th = move-exception;
            throw th;
        L13:
            if (this.mUpdateAllowedByProcState == false) goto L15;
            pause();     // Catch: Throwable -> L9
            goto L15
        L20:
            if (this.mUpdateAllowedByProcState == true) goto L11;
            if (this.mShouldForcePause == true) goto L11;
            resume();     // Catch: Throwable -> L9
            goto L11
        }

        boolean isHintAllowed() {
            if (this.mHalSessionPtr != 0) goto L5;
        L9:
            return false;
        L5:
            if (this.mUpdateAllowedByProcState == false) goto L9;
            if (this.mShouldForcePause == true) goto L9;
            return true;
        }

        public void updateTargetWorkDuration(long targetDurationNanos) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (isHintAllowed() == true) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L10:
            if (targetDurationNanos < 0) goto L12;
            boolean r0 = true;
        L13:
            Preconditions.checkArgument(r0, "Expected the target duration to be greater than or equal to 0.");     // Catch: Throwable -> L7
            HintManagerService.m7659$$Nest$fgetmNativeWrapper(this.this$0).halUpdateTargetWorkDuration(this.mHalSessionPtr, targetDurationNanos);     // Catch: Throwable -> L7
            this.mTargetDurationNanos = targetDurationNanos;     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            Object r1 = HintManagerService.m7668$$Nest$fgetmSessionSnapshotMapLock(this.this$0);
            monitor-enter(r1);
            ArrayMap<Integer, AppHintSessionSnapshot> sessionSnapshots = (ArrayMap) HintManagerService.m7667$$Nest$fgetmSessionSnapshotMap(this.this$0).get(Integer.valueOf(this.mUid));     // Catch: Throwable -> L22
            if (sessionSnapshots != null) goto L24;
            Slogf.w(HintManagerService.TAG, "Session snapshot map is null for uid " + this.mUid);     // Catch: Throwable -> L22
            monitor-exit(r1);     // Catch: Throwable -> L22
            return;
        L24:
            AppHintSessionSnapshot sessionSnapshot = sessionSnapshots.get(Integer.valueOf(this.mTag));     // Catch: Throwable -> L22
            if (sessionSnapshot != null) goto L29;
            Slogf.w(HintManagerService.TAG, "Session snapshot is null for uid " + this.mUid + " and tag " + this.mTag);     // Catch: Throwable -> L22
            monitor-exit(r1);     // Catch: Throwable -> L22
            return;
        L29:
            sessionSnapshot.updateTargetDurationNs(this.mTargetDurationNanos);     // Catch: Throwable -> L22
            monitor-exit(r1);     // Catch: Throwable -> L22
            return;
        L22:
            th = move-exception;
            throw th;
        L12:
            r0 = false;
            goto L13
        }

        public void reportActualWorkDuration(long[] actualDurationNanos, long[] timeStampNanos) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (isHintAllowed() == true) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L9:
            boolean r1 = false;
            if (actualDurationNanos.length == 0) goto L12;
            boolean r0 = true;
        L13:
            Preconditions.checkArgument(r0, "the count of hint durations shouldn't be 0.");     // Catch: Throwable -> L7
            if (actualDurationNanos.length != timeStampNanos.length) goto L16;
            r1 = true;
        L16:
            Preconditions.checkArgument(r1, "The length of durations and timestamps should be the same.");     // Catch: Throwable -> L7
            int i = 0;
        L18:
            if (i >= actualDurationNanos.length) goto L24;
            if (actualDurationNanos[i] <= 0) goto L23;
            i = i + 1;     // Catch: Throwable -> L7
            goto L18
        L23:
            throw new IllegalArgumentException(String.format("durations[%d]=%d should be greater than 0", new Object[]{Integer.valueOf(i), Long.valueOf(actualDurationNanos[i])}));     // Catch: Throwable -> L7
        L24:
            HintManagerService.m7659$$Nest$fgetmNativeWrapper(this.this$0).halReportActualWorkDuration(this.mHalSessionPtr, actualDurationNanos, timeStampNanos);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L12:
            r0 = false;
            goto L13
        }

        public void close() {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mHalSessionPtr != 0) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L9:
            HintManagerService.m7659$$Nest$fgetmNativeWrapper(this.this$0).halCloseHintSession(this.mHalSessionPtr);     // Catch: Throwable -> L7
            this.mHalSessionPtr = 0;     // Catch: Throwable -> L7
            int r0 = 0;
            this.mToken.unlinkToDeath(this, 0);     // Catch: Throwable -> L7 NoSuchElementException -> L13
        L16:
            if (this.mTrackedBySF == true) goto L18;
        L25:
            monitor-exit(this);     // Catch: Throwable -> L7
            Object r1 = HintManagerService.m7658$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            ArrayMap<IBinder, ArraySet<AppHintSession>> tokenMap = (ArrayMap) HintManagerService.m7639$$Nest$fgetmActiveSessions(this.this$0).get(Integer.valueOf(this.mUid));     // Catch: Throwable -> L33
            if (tokenMap != null) goto L35;
            Slogf.w(HintManagerService.TAG, "UID %d is not present in active session map", new Object[]{Integer.valueOf(this.mUid)});     // Catch: Throwable -> L33
            monitor-exit(r1);     // Catch: Throwable -> L33
            return;
        L35:
            ArraySet<AppHintSession> sessionSet = tokenMap.get(this.mToken);     // Catch: Throwable -> L33
            if (sessionSet != null) goto L40;
            Slogf.w(HintManagerService.TAG, "Token %s is not present in token map", new Object[]{this.mToken.toString()});     // Catch: Throwable -> L33
            monitor-exit(r1);     // Catch: Throwable -> L33
            return;
        L40:
            sessionSet.remove(this);     // Catch: Throwable -> L33
            if (sessionSet.isEmpty() == false) goto L44;
            tokenMap.remove(this.mToken);     // Catch: Throwable -> L33
        L44:
            if (tokenMap.isEmpty() == false) goto L46;
            HintManagerService.m7639$$Nest$fgetmActiveSessions(this.this$0).remove(Integer.valueOf(this.mUid));     // Catch: Throwable -> L33
        L46:
            monitor-exit(r1);     // Catch: Throwable -> L33
            Object r2 = HintManagerService.m7668$$Nest$fgetmSessionSnapshotMapLock(this.this$0);
            monitor-enter(r2);
            ArrayMap<Integer, AppHintSessionSnapshot> sessionSnapshots = (ArrayMap) HintManagerService.m7667$$Nest$fgetmSessionSnapshotMap(this.this$0).get(Integer.valueOf(this.mUid));     // Catch: Throwable -> L54
            if (sessionSnapshots != null) goto L56;
            Slogf.w(HintManagerService.TAG, "Session snapshot map is null for uid " + this.mUid);     // Catch: Throwable -> L54
            monitor-exit(r2);     // Catch: Throwable -> L54
            return;
        L56:
            AppHintSessionSnapshot sessionSnapshot = sessionSnapshots.get(Integer.valueOf(this.mTag));     // Catch: Throwable -> L54
            if (sessionSnapshot != null) goto L61;
            Slogf.w(HintManagerService.TAG, "Session snapshot is null for uid " + this.mUid + " and tag " + this.mTag);     // Catch: Throwable -> L54
            monitor-exit(r2);     // Catch: Throwable -> L54
            return;
        L61:
            sessionSnapshot.updateUponSessionClose();     // Catch: Throwable -> L54
            monitor-exit(r2);     // Catch: Throwable -> L54
            if (this.mGraphicsPipeline == false) goto L88;
            Object r3 = HintManagerService.m7671$$Nest$fgetmThreadsUsageObject(this.this$0);
            monitor-enter(r3);
            ArraySet<ThreadUsageTracker> threadsSet = (ArraySet) HintManagerService.m7670$$Nest$fgetmThreadsUsageMap(this.this$0).get(Integer.valueOf(this.mUid));     // Catch: Throwable -> L72
            if (threadsSet != null) goto L74;
            Slogf.w(HintManagerService.TAG, "Threads Set is null for uid " + this.mUid);     // Catch: Throwable -> L72
            monitor-exit(r3);     // Catch: Throwable -> L72
            return;
        L74:
            int i = 0;
        L76:
            if (i >= threadsSet.size()) goto L82;
            if (HintManagerService.m7680$$Nest$mcontains(this.this$0, this.mThreadIds, threadsSet.valueAt(i).getTid()) == false) goto L80;
            threadsSet.removeAt(i);     // Catch: Throwable -> L72
        L80:
            i = i + 1;     // Catch: Throwable -> L72
            goto L76
        L82:
            if (threadsSet.isEmpty() == false) goto L84;
            HintManagerService.m7670$$Nest$fgetmThreadsUsageMap(this.this$0).remove(Integer.valueOf(this.mUid));     // Catch: Throwable -> L72
        L84:
            monitor-exit(r3);     // Catch: Throwable -> L72
        L72:
            th = move-exception;
            throw th;
        L88:
            Object r4 = HintManagerService.m7661$$Nest$fgetmNonIsolatedTidsLock(this.this$0);
            monitor-enter(r4);
            int[] tids = getTidsInternal();     // Catch: Throwable -> L98
            int r5 = tids.length;     // Catch: Throwable -> L98
        L92:
            if (r0 >= r5) goto L101;
            int tid = tids[r0];     // Catch: Throwable -> L98
            if (HintManagerService.m7660$$Nest$fgetmNonIsolatedTids(this.this$0).containsKey(Integer.valueOf(tid)) == false) goto L100;
            ((Set) HintManagerService.m7660$$Nest$fgetmNonIsolatedTids(this.this$0).get(Integer.valueOf(tid))).remove(Long.valueOf(this.mHalSessionPtr));     // Catch: Throwable -> L98
            if (((Set) HintManagerService.m7660$$Nest$fgetmNonIsolatedTids(this.this$0).get(Integer.valueOf(tid))).isEmpty() == false) goto L100;
            HintManagerService.m7660$$Nest$fgetmNonIsolatedTids(this.this$0).remove(Integer.valueOf(tid));     // Catch: Throwable -> L98
        L100:
            r0 = r0 + 1;     // Catch: Throwable -> L98
            goto L92
        L101:
            monitor-exit(r4);     // Catch: Throwable -> L98
            return;
        L98:
            th = move-exception;
            throw th;
        L54:
            th = move-exception;
            throw th;
        L33:
            th = move-exception;
            throw th;
        L18:
            if (HintManagerService.m7666$$Nest$fgetmSessionManager(this.this$0) != null) goto L111;
            Slog.e(HintManagerService.TAG, "SessionManager is null but there are tracked sessions");     // Catch: Throwable -> L7
            goto L25
        L111:
            HintManagerService.m7666$$Nest$fgetmSessionManager(this.this$0).trackedSessionsDied(new int[]{this.mSessionId.intValue()});     // Catch: Throwable -> L7 RemoteException -> L21
            this.mTrackedBySF = false;     // Catch: Throwable -> L7
            goto L25
        L21:
            e = move-exception;
            throw new IllegalStateException("Could not communicate with SessionManager", e);     // Catch: Throwable -> L7
        L14:
            Slogf.d(HintManagerService.TAG, "Death link does not exist for session with UID " + this.mUid);     // Catch: Throwable -> L7
            goto L16
        }

        public void sendHint(int hint) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (isHintAllowed() == true) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L9:
            if (hint < 0) goto L11;
            boolean r0 = true;
        L12:
            Preconditions.checkArgument(r0, "the hint ID value should be greater than zero.");     // Catch: Throwable -> L7
            HintManagerService.m7659$$Nest$fgetmNativeWrapper(this.this$0).halSendHint(this.mHalSessionPtr, hint);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L11:
            r0 = false;
            goto L12
        }

        public void associateToLayers(IBinder[] layerTokens) {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (HintManagerService.m7666$$Nest$fgetmSessionManager(this.this$0) != null) goto L6;
        L19:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L6:
            if (this.mSessionId == null) goto L19;
            if (layerTokens == null) goto L19;
            if (layerTokens.length <= 0) goto L24;
            this.mTrackedBySF = true;     // Catch: Throwable -> L12
        L24:
            HintManagerService.m7666$$Nest$fgetmSessionManager(this.this$0).associateSessionToLayers(this.mSessionId.intValue(), this.mUid, layerTokens);     // Catch: Throwable -> L12 RemoteException -> L16
        L16:
            e = move-exception;
            throw new IllegalStateException("Could not communicate with SessionManager", e);     // Catch: Throwable -> L12
        }

        public void setThreads(int[] tids) {
            setThreadsInternal(tids, true);
            if (HintManagerService.m7683$$Nest$mtooManyPipelineThreads(this.this$0, Binder.getCallingUid()) == true) goto L6;
            return;
        L6:
            throw new ServiceSpecificException(5, "Not enough available graphics pipeline threads.");
        }

        private void setThreadsInternal(int[] tids, boolean checkTid) {
            if (tids.length == 0) goto L99;
            int callingUid = Binder.getCallingUid();
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L7:
            if (this.mHalSessionPtr != 0) goto L13;
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L13:
            if (this.mUpdateAllowedByProcState == true) goto L17;
            Slogf.v(HintManagerService.TAG, "update hint not allowed, storing tids.");     // Catch: Throwable -> L10
            this.mNewThreadIds = tids;     // Catch: Throwable -> L10
            this.mShouldForcePause = false;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L17:
            if (checkTid == false) goto L52;
            int callingTgid = Process.getThreadGroupLeader(Binder.getCallingPid());     // Catch: Throwable -> L10
            IntArray nonIsolated = new IntArray();     // Catch: Throwable -> L10
            long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
            Integer invalidTid = HintManagerService.m7679$$Nest$mcheckTidValid(this.this$0, callingUid, callingTgid, tids, nonIsolated);     // Catch: Throwable -> L28
            if (invalidTid == null) goto L104;
            String errMsg = HintManagerService.m7681$$Nest$mformatTidCheckErrMsg(this.this$0, callingUid, tids, invalidTid);     // Catch: Throwable -> L28
            Slogf.w(HintManagerService.TAG, errMsg);     // Catch: Throwable -> L28
            throw new SecurityException(errMsg);     // Catch: Throwable -> L28
        L104:
            int r7 = tids.length;     // Catch: Throwable -> L28 Exception -> L30
            int r8 = 0;
        L22:
            if (r8 >= r7) goto L35;
            int tid = tids[r8];     // Catch: Throwable -> L28 Exception -> L30
            int policy = Process.getThreadScheduler(tid);     // Catch: Throwable -> L28 Exception -> L30
            if (policy != 0) goto L27;
            int prio = Process.getThreadPriority(tid);     // Catch: Throwable -> L28 Exception -> L30
            Process.setThreadScheduler(tid, 1073741824, 0);     // Catch: Throwable -> L28 Exception -> L30
            Process.setThreadPriority(tid, prio);     // Catch: Throwable -> L28 Exception -> L30
        L27:
            r8 = r8 + 1;
        L35:
            Object r9 = HintManagerService.m7661$$Nest$fgetmNonIsolatedTidsLock(this.this$0);     // Catch: Throwable -> L28
            monitor-enter(r9);     // Catch: Throwable -> L28
            int i = nonIsolated.size() - 1;     // Catch: Throwable -> L40
        L38:
            if (i < 0) goto L43;
            HintManagerService.m7660$$Nest$fgetmNonIsolatedTids(this.this$0).putIfAbsent(Integer.valueOf(nonIsolated.get(i)), new ArraySet());     // Catch: Throwable -> L40
            ((Set) HintManagerService.m7660$$Nest$fgetmNonIsolatedTids(this.this$0).get(Integer.valueOf(nonIsolated.get(i)))).add(Long.valueOf(this.mHalSessionPtr));     // Catch: Throwable -> L40
            i = i - 1;     // Catch: Throwable -> L40
            goto L38
        L43:
            monitor-exit(r9);     // Catch: Throwable -> L40
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L10
            goto L52
        L40:
            th = move-exception;
            throw th;     // Catch: Throwable -> L28
        L30:
            e = move-exception;
            Slog.e(HintManagerService.TAG, "Failed to set SCHED_RESET_ON_FORK for tids " + Arrays.toString(tids), e);     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L10
            throw th;     // Catch: Throwable -> L10
        L52:
            HintManagerService.m7659$$Nest$fgetmNativeWrapper(this.this$0).halSetThreads(this.mHalSessionPtr, tids);     // Catch: Throwable -> L10
            Object r1 = HintManagerService.m7671$$Nest$fgetmThreadsUsageObject(this.this$0);     // Catch: Throwable -> L10
            monitor-enter(r1);     // Catch: Throwable -> L10
            ArraySet<ThreadUsageTracker> threadsSet = (ArraySet) HintManagerService.m7670$$Nest$fgetmThreadsUsageMap(this.this$0).get(Integer.valueOf(callingUid));     // Catch: Throwable -> L57
            if (threadsSet != null) goto L59;
            HintManagerService.m7670$$Nest$fgetmThreadsUsageMap(this.this$0).put(Integer.valueOf(callingUid), new ArraySet());     // Catch: Throwable -> L57
            threadsSet = (ArraySet) HintManagerService.m7670$$Nest$fgetmThreadsUsageMap(this.this$0).get(Integer.valueOf(callingUid));     // Catch: Throwable -> L57
        L59:
            int i2 = 0;
        L61:
            if (i2 >= threadsSet.size()) goto L66;
            if (HintManagerService.m7680$$Nest$mcontains(this.this$0, this.mThreadIds, threadsSet.valueAt(i2).getTid()) == false) goto L65;
            threadsSet.removeAt(i2);     // Catch: Throwable -> L57
        L65:
            i2 = i2 + 1;     // Catch: Throwable -> L57
            goto L61
        L66:
            int i3 = tids.length;     // Catch: Throwable -> L57
            int r5 = 0;
        L68:
            if (r5 >= i3) goto L70;
            threadsSet.add(new ThreadUsageTracker(tids[r5], this.mGraphicsPipeline));     // Catch: Throwable -> L57
            r5 = r5 + 1;     // Catch: Throwable -> L57
            goto L68
        L70:
            monitor-exit(r1);     // Catch: Throwable -> L57
            this.mThreadIds = tids;     // Catch: Throwable -> L10
            this.mNewThreadIds = null;     // Catch: Throwable -> L10
            if (this.mShouldForcePause == false) goto L74;
            resume();     // Catch: Throwable -> L10
            this.mShouldForcePause = false;     // Catch: Throwable -> L10
        L74:
            monitor-exit(this);     // Catch: Throwable -> L10
            Object r2 = HintManagerService.m7668$$Nest$fgetmSessionSnapshotMapLock(this.this$0);
            monitor-enter(r2);
            ArrayMap<Integer, AppHintSessionSnapshot> sessionSnapshots = (ArrayMap) HintManagerService.m7667$$Nest$fgetmSessionSnapshotMap(this.this$0).get(Integer.valueOf(this.mUid));     // Catch: Throwable -> L82
            if (sessionSnapshots != null) goto L84;
            Slogf.w(HintManagerService.TAG, "Session snapshot map is null for uid " + this.mUid);     // Catch: Throwable -> L82
            monitor-exit(r2);     // Catch: Throwable -> L82
            return;
        L84:
            AppHintSessionSnapshot sessionSnapshot = sessionSnapshots.get(Integer.valueOf(this.mTag));     // Catch: Throwable -> L82
            if (sessionSnapshot != null) goto L89;
            Slogf.w(HintManagerService.TAG, "Session snapshot is null for uid " + this.mUid + " and tag " + this.mTag);     // Catch: Throwable -> L82
            monitor-exit(r2);     // Catch: Throwable -> L82
            return;
        L89:
            sessionSnapshot.updateThreadCount(tids.length);     // Catch: Throwable -> L82
            monitor-exit(r2);     // Catch: Throwable -> L82
            return;
        L82:
            th = move-exception;
            throw th;
        L57:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L99:
            throw new IllegalArgumentException("Thread id list can't be empty.");
        }

        public int[] getThreadIds() {
            monitor-enter(this);
            int[] r0 = Arrays.copyOf(this.mThreadIds, this.mThreadIds.length);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        int[] getTidsInternal() {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.mNewThreadIds == null) goto L8;
            int[] r0 = Arrays.copyOf(this.mNewThreadIds, this.mNewThreadIds.length);     // Catch: Throwable -> L6
        L9:
            monitor-exit(this);     // Catch: Throwable -> L6
            return r0;
        L8:
            r0 = Arrays.copyOf(this.mThreadIds, this.mThreadIds.length);     // Catch: Throwable -> L6
            goto L9
        }

        boolean isClosed() {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.mHalSessionPtr != 0) goto L6;
            boolean r0 = true;
        L7:
            monitor-exit(this);     // Catch: Throwable -> L9
            return r0;
        L6:
            r0 = false;
            goto L7
        }

        boolean isForcePaused() {
            monitor-enter(this);
            boolean r0 = this.mShouldForcePause;     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public void setMode(int mode, boolean enabled) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (isHintAllowed() == true) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L10:
            if (mode < 0) goto L12;
            boolean r1 = true;
        L13:
            Preconditions.checkArgument(r1, "the mode Id value should be greater than zero.");     // Catch: Throwable -> L7
            if (mode != 0) goto L16;
            this.mPowerEfficient = enabled;     // Catch: Throwable -> L7
        L18:
            HintManagerService.m7659$$Nest$fgetmNativeWrapper(this.this$0).halSetMode(this.mHalSessionPtr, mode, enabled);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            if (enabled == false) goto L65;
            if (mode == 0) goto L23;
            if (mode == 1) goto L45;
            return;
        L45:
            if (this.mHasBeenGraphicsPipeline == true) goto L74;
            this.mHasBeenGraphicsPipeline = true;
            Object r0 = HintManagerService.m7668$$Nest$fgetmSessionSnapshotMapLock(this.this$0);
            monitor-enter(r0);
            ArrayMap<Integer, AppHintSessionSnapshot> sessionSnapshots = (ArrayMap) HintManagerService.m7667$$Nest$fgetmSessionSnapshotMap(this.this$0).get(Integer.valueOf(this.mUid));     // Catch: Throwable -> L53
            if (sessionSnapshots != null) goto L55;
            Slogf.w(HintManagerService.TAG, "Session snapshot map is null for uid " + this.mUid);     // Catch: Throwable -> L53
            monitor-exit(r0);     // Catch: Throwable -> L53
            return;
        L55:
            AppHintSessionSnapshot sessionSnapshot = sessionSnapshots.get(Integer.valueOf(this.mTag));     // Catch: Throwable -> L53
            if (sessionSnapshot != null) goto L60;
            Slogf.w(HintManagerService.TAG, "Session snapshot is null for uid " + this.mUid + " and tag " + this.mTag);     // Catch: Throwable -> L53
            monitor-exit(r0);     // Catch: Throwable -> L53
            return;
        L60:
            sessionSnapshot.logGraphicsPipelineSession();     // Catch: Throwable -> L53
            monitor-exit(r0);     // Catch: Throwable -> L53
            return;
        L53:
            th = move-exception;
            throw th;
        L74:
            return;
        L23:
            if (this.mHasBeenPowerEfficient == true) goto L71;
            this.mHasBeenPowerEfficient = true;
            Object r2 = HintManagerService.m7668$$Nest$fgetmSessionSnapshotMapLock(this.this$0);
            monitor-enter(r2);
            ArrayMap<Integer, AppHintSessionSnapshot> sessionSnapshots2 = (ArrayMap) HintManagerService.m7667$$Nest$fgetmSessionSnapshotMap(this.this$0).get(Integer.valueOf(this.mUid));     // Catch: Throwable -> L31
            if (sessionSnapshots2 != null) goto L33;
            Slogf.w(HintManagerService.TAG, "Session snapshot map is null for uid " + this.mUid);     // Catch: Throwable -> L31
            monitor-exit(r2);     // Catch: Throwable -> L31
            return;
        L33:
            AppHintSessionSnapshot sessionSnapshot2 = sessionSnapshots2.get(Integer.valueOf(this.mTag));     // Catch: Throwable -> L31
            if (sessionSnapshot2 != null) goto L38;
            Slogf.w(HintManagerService.TAG, "Session snapshot is null for uid " + this.mUid + " and tag " + this.mTag);     // Catch: Throwable -> L31
            monitor-exit(r2);     // Catch: Throwable -> L31
            return;
        L38:
            sessionSnapshot2.logPowerEfficientSession();     // Catch: Throwable -> L31
            monitor-exit(r2);     // Catch: Throwable -> L31
            return;
        L31:
            th = move-exception;
            throw th;
        L71:
            return;
        L65:
            return;
        L16:
            if (mode != 1) goto L18;
            this.mGraphicsPipeline = enabled;     // Catch: Throwable -> L7
            goto L18
        L12:
            r1 = false;
            goto L13
        }

        public void reportActualWorkDuration2(WorkDuration[] workDurations) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (isHintAllowed() == true) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L10:
            if (workDurations.length == 0) goto L12;
            boolean r0 = true;
        L13:
            Preconditions.checkArgument(r0, "the count of work durations shouldn't be 0.");     // Catch: Throwable -> L7
            int i = 0;
        L15:
            if (i >= workDurations.length) goto L17;
            validateWorkDuration(workDurations[i]);     // Catch: Throwable -> L7
            i = i + 1;     // Catch: Throwable -> L7
            goto L15
        L17:
            HintManagerService.m7659$$Nest$fgetmNativeWrapper(this.this$0).halReportActualWorkDuration(this.mHalSessionPtr, workDurations);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L12:
            r0 = false;
            goto L13
        }

        public boolean isPowerEfficient() {
            monitor-enter(this);
            boolean r0 = this.mPowerEfficient;     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public boolean isGraphicsPipeline() {
            monitor-enter(this);
            boolean r0 = this.mGraphicsPipeline;     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public int getUid() {
            return this.mUid;
        }

        public boolean isTrackedBySf() {
            monitor-enter(this);
            boolean r0 = this.mTrackedBySF;     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public void setTrackedBySf(boolean tracked) {
            monitor-enter(this);
            this.mTrackedBySF = tracked;     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public int getTag() {
            return this.mTag;
        }

        public Integer getSessionId() {
            return this.mSessionId;
        }

        public long getTargetDurationNs() {
            monitor-enter(this);
            long r0 = this.mTargetDurationNanos;     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        void validateWorkDuration(WorkDuration workDuration) {
            if (workDuration.durationNanos <= 0) goto L22;
            if (workDuration.workPeriodStartTimestampNanos < 0) goto L20;
            if (workDuration.cpuDurationNanos < 0) goto L18;
            if (workDuration.gpuDurationNanos < 0) goto L16;
            if ((workDuration.cpuDurationNanos + workDuration.gpuDurationNanos) <= 0) goto L14;
            return;
        L14:
            throw new IllegalArgumentException(TextUtils.formatSimple("The actual CPU duration (%d) and the actual GPU duration (%d) should not both be 0", new Object[]{Long.valueOf(workDuration.cpuDurationNanos), Long.valueOf(workDuration.gpuDurationNanos)}));
        L16:
            throw new IllegalArgumentException(TextUtils.formatSimple("Actual GPU duration (%d) should greater than or equal to 0", new Object[]{Long.valueOf(workDuration.gpuDurationNanos)}));
        L18:
            throw new IllegalArgumentException(TextUtils.formatSimple("Actual CPU duration (%d) should be greater than or equal to 0", new Object[]{Long.valueOf(workDuration.cpuDurationNanos)}));
        L20:
            throw new IllegalArgumentException(TextUtils.formatSimple("Work period start timestamp (%d) should be greater than 0", new Object[]{Long.valueOf(workDuration.workPeriodStartTimestampNanos)}));
        L22:
            throw new IllegalArgumentException(TextUtils.formatSimple("Actual total duration (%d) should be greater than 0", new Object[]{Long.valueOf(workDuration.durationNanos)}));
        }

        private void pause() {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mHalSessionPtr != 0) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L9:
            HintManagerService.m7659$$Nest$fgetmNativeWrapper(this.this$0).halPauseHintSession(this.mHalSessionPtr);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
        }

        private void resume() {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mHalSessionPtr != 0) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L9:
            HintManagerService.m7659$$Nest$fgetmNativeWrapper(this.this$0).halResumeHintSession(this.mHalSessionPtr);     // Catch: Throwable -> L7
            if (this.mNewThreadIds == null) goto L12;
            HintManagerService.m7659$$Nest$fgetmNativeWrapper(this.this$0).halSetThreads(this.mHalSessionPtr, this.mNewThreadIds);     // Catch: Throwable -> L7
            this.mThreadIds = this.mNewThreadIds;     // Catch: Throwable -> L7
            this.mNewThreadIds = null;     // Catch: Throwable -> L7
        L12:
            monitor-exit(this);     // Catch: Throwable -> L7
        }

        private void dump(PrintWriter pw, String prefix) {
            monitor-enter(this);
            pw.println(prefix + "SessionPID: " + this.mPid);     // Catch: Throwable -> L6
            pw.println(prefix + "SessionUID: " + this.mUid);     // Catch: Throwable -> L6
            pw.println(prefix + "SessionTIDs: " + Arrays.toString(this.mThreadIds));     // Catch: Throwable -> L6
            pw.println(prefix + "SessionTargetDurationNanos: " + this.mTargetDurationNanos);     // Catch: Throwable -> L6
            pw.println(prefix + "SessionAllowedByProcState: " + this.mUpdateAllowedByProcState);     // Catch: Throwable -> L6
            pw.println(prefix + "SessionForcePaused: " + this.mShouldForcePause);     // Catch: Throwable -> L6
            StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L6
            r0.append(prefix);     // Catch: Throwable -> L6
            r0.append("PowerEfficient: ");     // Catch: Throwable -> L6
            if (this.mPowerEfficient == false) goto L8;
            String r1 = "true";
        L9:
            r0.append(r1);     // Catch: Throwable -> L6
            pw.println(r0.toString());     // Catch: Throwable -> L6
            StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L6
            r2.append(prefix);     // Catch: Throwable -> L6
            r2.append("GraphicsPipeline: ");     // Catch: Throwable -> L6
            if (this.mGraphicsPipeline == false) goto L12;
            String r3 = "true";
        L13:
            r2.append(r3);     // Catch: Throwable -> L6
            pw.println(r2.toString());     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L12:
            r3 = "false";
            goto L13
        L8:
            r1 = "false";
        L6:
            th = move-exception;
            throw th;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            close();
        }
    }

    private class AppHintSessionSnapshot {
        int mCurrentSessionCount;
        int mGraphicsPipelineSessionCount;
        int mMaxConcurrentSession;
        int mMaxThreadCount;
        int mPowerEfficientSessionCount;
        PriorityQueue<TargetDurationRecord> mTargetDurationNsCountPQ;
        final int mTargetDurationNsCountPQSize;

        class TargetDurationRecord implements Comparable<TargetDurationRecord> {
            int mCount;
            long mTargetDurationNs;
            long mTimestamp;

            @Override // java.lang.Comparable
            public /* bridge */ /* synthetic */ int compareTo(TargetDurationRecord r1) {
                return compareTo2(r1);
            }

            TargetDurationRecord(AppHintSessionSnapshot this$1, long targetDurationNs) {
                this.mTargetDurationNs = targetDurationNs;
                this.mTimestamp = System.currentTimeMillis();
                this.mCount = 1;
            }

            /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
            public int compareTo2(TargetDurationRecord t) {
                int tCount = t.getCount();
                int thisCount = getCount();
                if (tCount == thisCount) goto L5;
                if (tCount < thisCount) goto L10;
                return -1;
            L10:
                return 1;
            L5:
                if (t.getTimestamp() < getTimestamp()) goto L7;
                return -1;
            L7:
                return 1;
            }

            long getTargetDurationNs() {
                return this.mTargetDurationNs;
            }

            int getCount() {
                return this.mCount;
            }

            long getTimestamp() {
                return this.mTimestamp;
            }

            void setCount(int count) {
                this.mCount = count;
            }

            void setTimestamp() {
                this.mTimestamp = System.currentTimeMillis();
            }

            void setTargetDurationNs(long targetDurationNs) {
                this.mTargetDurationNs = targetDurationNs;
            }
        }

        AppHintSessionSnapshot(HintManagerService r2) {
            this.mTargetDurationNsCountPQSize = 100;
            this.mCurrentSessionCount = 0;
            this.mMaxConcurrentSession = 0;
            this.mMaxThreadCount = 0;
            this.mPowerEfficientSessionCount = 0;
            this.mGraphicsPipelineSessionCount = 0;
            this.mTargetDurationNsCountPQ = new PriorityQueue(1);
        }

        void updateUponSessionCreation(int threadCount, long targetDuration) {
            this.mCurrentSessionCount++;
            this.mMaxConcurrentSession = Math.max(this.mMaxConcurrentSession, this.mCurrentSessionCount);
            this.mMaxThreadCount = Math.max(this.mMaxThreadCount, threadCount);
            updateTargetDurationNs(targetDuration);
        }

        void updateUponSessionClose() {
            this.mCurrentSessionCount--;
        }

        void logPowerEfficientSession() {
            this.mPowerEfficientSessionCount++;
        }

        void logGraphicsPipelineSession() {
            this.mGraphicsPipelineSessionCount++;
        }

        void updateThreadCount(int threadCount) {
            this.mMaxThreadCount = Math.max(this.mMaxThreadCount, threadCount);
        }

        void updateTargetDurationNs(long targetDurationNs) {
            Iterator<TargetDurationRecord> r0 = this.mTargetDurationNsCountPQ.iterator();
        L4:
            if (r0.hasNext() == false) goto L11;
            TargetDurationRecord t = r0.next();
            if (t.getTargetDurationNs() != targetDurationNs) goto L4;
            t.setCount(t.getCount() + 1);
            t.setTimestamp();
            return;
        L11:
            if (this.mTargetDurationNsCountPQ.size() != 100) goto L13;
            this.mTargetDurationNsCountPQ.poll();
        L13:
            this.mTargetDurationNsCountPQ.add(new TargetDurationRecord(this, targetDurationNs));
        }

        int getMaxConcurrentSession() {
            return this.mMaxConcurrentSession;
        }

        int getMaxThreadCount() {
            return this.mMaxThreadCount;
        }

        int getPowerEfficientSessionCount() {
            return this.mPowerEfficientSessionCount;
        }

        int getGraphicsPipelineSessionCount() {
            return this.mGraphicsPipelineSessionCount;
        }

        long[] targetDurationNsList() {
            long[] targetDurations = new long[5];
        L4:
            if (this.mTargetDurationNsCountPQ.size() <= 5) goto L6;
            this.mTargetDurationNsCountPQ.poll();
            goto L4
        L6:
            int i = 0;
        L7:
            if (i >= 5) goto L11;
            if (this.mTargetDurationNsCountPQ.isEmpty() == true) goto L11;
            targetDurations[i] = this.mTargetDurationNsCountPQ.poll().getTargetDurationNs();
            i = i + 1;
        L11:
            return targetDurations;
        }
    }

    final class BinderService extends IHintManager.Stub {
        final /* synthetic */ HintManagerService this$0;

        public static /* synthetic */ ArraySet $r8$lambda$AKdD3UK6LHX3HgXwIyWtFQGJ9hI(Integer r0) {
            return lambda$createHintSessionWithConfig$2(r0);
        }

        public static /* synthetic */ AppHintSessionSnapshot $r8$lambda$eyDdSdezowLMa2_XJTKMNA6O98o(BinderService r0, Integer r1) {
            return r0.lambda$createHintSessionWithConfig$1(r1);
        }

        public static /* synthetic */ ArrayMap $r8$lambda$wW5vMRz9tM1od40u5pT8Q15YZ20(Integer r0) {
            return lambda$createHintSessionWithConfig$0(r0);
        }

        BinderService(HintManagerService this$0) {
            this.this$0 = this$0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v12 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Type inference failed for: r7v9, types: [int] */
        public IHintManager.SessionCreationReturn createHintSessionWithConfig(IBinder r30, int r31, SessionCreationConfig r32, SessionConfig r33) {
            if (HintManagerService.m7682$$Nest$misHintSessionSupported(this.this$0) == false) goto L297;
            r30.getClass();
            r32.tids.getClass();
            int[] r5 = r32.tids;
            int r14 = 1;
            if (r5.length == 0) goto L7;
            boolean r0 = true;
        L8:
            Preconditions.checkArgument(r0, "tids should not be empty.");
            int r2 = Binder.getCallingUid();
            int r3 = Process.getThreadGroupLeader(Binder.getCallingPid());
            long r15 = Binder.clearCallingIdentity();
            long r6 = r32.targetWorkDurationNanos;
            boolean r1 = false;
            boolean r4 = false;
            if (r32.modesToEnable == null) goto L22;
            int[] r8 = r32.modesToEnable;
            int r10 = r8.length;
            int r11 = 0;
        L11:
            if (r11 >= r10) goto L21;
            int r13 = r8[r11];
            if (r13 != r14) goto L15;
            r1 = true;
        L15:
            int r18 = r14;
            if (r13 != 2) goto L18;
        L19:
            r4 = true;
        L20:
            r11 = r11 + 1;
            r14 = r18;
            goto L11
        L18:
            if (r13 != 3) goto L20;
        L21:
            int r19 = r14;
            boolean r16 = r1;
            boolean r17 = r4;
        L23:
            if (r17 == false) goto L319;
            Preconditions.checkArgument(r16, "graphics pipeline mode not enabled for an automatically timed session");
        L319:
            IntArray r7 = new IntArray(r5.length);     // Catch: Throwable -> L292
            Integer r9 = HintManagerService.m7679$$Nest$mcheckTidValid(this.this$0, r2, r3, r5, r7);     // Catch: Throwable -> L292
            if (r9 == null) goto L371;
            long r27 = r15;
            String r12 = HintManagerService.m7681$$Nest$mformatTidCheckErrMsg(this.this$0, r2, r5, r9);     // Catch: Throwable -> L290
            Slogf.w(HintManagerService.TAG, r12);     // Catch: Throwable -> L290
            throw new SecurityException(r12);     // Catch: Throwable -> L290
        L290:
            th = th;
        L294:
            Binder.restoreCallingIdentity(r27);
            throw th;
        L371:
            int r20 = r5.length;     // Catch: Throwable -> L41 Exception -> L43
            int r21 = 0;
        L29:
            if (r21 >= r20) goto L45;
            int r22 = r5[r21];     // Catch: Throwable -> L41 Exception -> L43
            if (Process.getThreadScheduler(r22) == 0) goto L33;
            int r23 = r3;
        L36:
            r21 = r21 + 1;
            r20 = r20;
            r3 = r23;
            goto L29
        L33:
            int r24 = Process.getThreadPriority(r22);     // Catch: Throwable -> L41 Exception -> L43
            r23 = r3;
            Process.setThreadScheduler(r22, 1073741824, 0);     // Catch: Throwable -> L37 Exception -> L39
            Process.setThreadPriority(r22, r24);     // Catch: Throwable -> L37 Exception -> L39
        L39:
            e = e;
        L363:
            Slog.e(HintManagerService.TAG, "Failed to set SCHED_RESET_ON_FORK for tids " + Arrays.toString(r5), e);     // Catch: Throwable -> L285
        L49:
            if (r31 == 4) goto L346;
            int r25 = r31;
        L355:
            r33.id = -1;     // Catch: Throwable -> L283
            Long r110 = null;
            if (HintManagerService.m7646$$Nest$fgetmConfigCreationSupport(this.this$0).get() == true) goto L365;
            long r26 = -1;
            int r28 = r23;
            boolean r29 = false;
            int r210 = r2;
        L348:
            if (r110 == null) goto L369;
            int r34 = r210;
            Long r35 = r110;
        L313:
            Object r36 = HintManagerService.m7661$$Nest$fgetmNonIsolatedTidsLock(this.this$0);     // Catch: Throwable -> L269
            monitor-enter(r36);     // Catch: Throwable -> L269
            int r37 = r7.size() - 1;
        L136:
            if (r37 < 0) goto L150;
            int r211 = r34;
            int[] r38 = r5;
            long r212 = r6;
            HintManagerService.m7660$$Nest$fgetmNonIsolatedTids(this.this$0).putIfAbsent(Integer.valueOf(r7.get(r37)), new ArraySet());     // Catch: Throwable -> L144
            ((Set) HintManagerService.m7660$$Nest$fgetmNonIsolatedTids(this.this$0).get(Integer.valueOf(r7.get(r37)))).add(r35);     // Catch: Throwable -> L144
            r37 = r37 - 1;
            r5 = r38;
            r34 = r211;
            r6 = r212;
        L144:
            th = th;
        L353:
            monitor-exit(r36);     // Catch: Throwable -> L281
            throw th;     // Catch: Throwable -> L216
        L281:
            th = th;
        L146:
            th = th;
        L148:
            th = th;
            goto L353
        L150:
            int r213 = r34;
            int[] r39 = r5;
            long r214 = r6;
            monitor-exit(r36);     // Catch: Throwable -> L275
        L273:
            th = th;
            r27 = r15;
            goto L294
        L154:
            if (r33.id != r26) goto L307;
            long r40 = r35.longValue();     // Catch: Throwable -> L273
        L160:
            Long r111 = r35;
            logPerformanceHintSessionAtom(r213, r40, r214, r39, r25);     // Catch: Throwable -> L271
            r6 = r214;
            Object r41 = HintManagerService.m7668$$Nest$fgetmSessionSnapshotMapLock(this.this$0);     // Catch: Throwable -> L269
            monitor-enter(r41);     // Catch: Throwable -> L269
            ((AppHintSessionSnapshot) ((ArrayMap) HintManagerService.m7667$$Nest$fgetmSessionSnapshotMap(this.this$0).computeIfAbsent(Integer.valueOf(r213), new HintManagerService$BinderService$$ExternalSyntheticLambda0())).computeIfAbsent(Integer.valueOf(r25), new HintManagerService$BinderService$$ExternalSyntheticLambda1(this))).updateUponSessionCreation(r39.length, r6);     // Catch: Throwable -> L261
            monitor-exit(r41);     // Catch: Throwable -> L261
            Object r215 = HintManagerService.m7658$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L259
            monitor-enter(r215);     // Catch: Throwable -> L259
            Integer r42 = null;
            if (r33.id == r26) goto L340;
            r42 = new Integer((int) r33.id);     // Catch: Throwable -> L178
        L178:
            th = th;
        L359:
            monitor-exit(r215);     // Catch: Throwable -> L257
            throw th;     // Catch: Throwable -> L216
        L257:
            th = th;
        L340:
            r27 = r15;
            int r43 = r28;
            AppHintSession r44 = new AppHintSession(this.this$0, r213, r43, r25, r39, r30, r111.longValue(), r6, r42);     // Catch: Throwable -> L244
            int r45 = r43;
            ArrayMap r46 = (ArrayMap) HintManagerService.m7639$$Nest$fgetmActiveSessions(this.this$0).get(Integer.valueOf(r213));     // Catch: Throwable -> L242
            if (r46 == null) goto L351;
        L195:
            ArraySet r47 = (ArraySet) r46.get(r30);     // Catch: Throwable -> L242
            if (r47 != null) goto L200;
            r47 = new ArraySet(1);     // Catch: Throwable -> L193
            r46.put(r30, r47);     // Catch: Throwable -> L193
        L200:
            r47.add(r44);     // Catch: Throwable -> L242
            HintManagerService r48 = this.this$0;     // Catch: Throwable -> L242
            if (HintManagerService.m7673$$Nest$fgetmUsesFmq(this.this$0) == true) goto L206;
            if (this.this$0.hasChannel(r45, r213).booleanValue() == true) goto L206;
            boolean r49 = r29;
        L207:
            HintManagerService.m7678$$Nest$fputmUsesFmq(r48, r49);     // Catch: Throwable -> L242
            monitor-exit(r215);     // Catch: Throwable -> L242
        L218:
            th = th;
            goto L294
        L210:
            if (r32.modesToEnable == null) goto L223;
            int[] r50 = r32.modesToEnable;     // Catch: Throwable -> L218
            int r51 = r50.length;     // Catch: Throwable -> L218
            ?? r52 = r29;
        L212:
            if (r52 >= r51) goto L223;
            int r216 = r45;
            r44.setMode(r50[r52], true);     // Catch: Throwable -> L216
            r45 = r216;
            r52 = r52 + 1;     // Catch: Throwable -> L216
        L223:
            if (r32.layerTokens != null) goto L225;
        L227:
            Object r53 = HintManagerService.m7671$$Nest$fgetmThreadsUsageObject(this.this$0);     // Catch: Throwable -> L216
            monitor-enter(r53);     // Catch: Throwable -> L216
            HintManagerService.m7670$$Nest$fgetmThreadsUsageMap(this.this$0).computeIfAbsent(Integer.valueOf(r213), new HintManagerService$BinderService$$ExternalSyntheticLambda2());     // Catch: Throwable -> L233
            ArraySet r54 = (ArraySet) HintManagerService.m7670$$Nest$fgetmThreadsUsageMap(this.this$0).get(Integer.valueOf(r213));     // Catch: Throwable -> L233
            int r55 = 0;
        L231:
            if (r55 >= r39.length) goto L236;
            r54.add(new ThreadUsageTracker(r39[r55], r16));     // Catch: Throwable -> L233
            r55 = r55 + 1;     // Catch: Throwable -> L233
            goto L231
        L236:
            monitor-exit(r53);     // Catch: Throwable -> L233
            IHintManager.SessionCreationReturn r56 = new IHintManager.SessionCreationReturn();     // Catch: Throwable -> L216
            r56.pipelineThreadLimitExceeded = HintManagerService.m7683$$Nest$mtooManyPipelineThreads(this.this$0, r213);     // Catch: Throwable -> L216
            r56.session = r44;     // Catch: Throwable -> L216
            Binder.restoreCallingIdentity(r27);
            return r56;
        L233:
            th = move-exception;
            throw th;     // Catch: Throwable -> L216
        L225:
            if (r32.layerTokens.length <= 0) goto L227;
            r44.associateToLayers(r32.layerTokens);     // Catch: Throwable -> L216
        L193:
            th = th;
        L206:
            r49 = true;
            goto L207
        L351:
            r46 = new ArrayMap(r19);     // Catch: Throwable -> L193
            HintManagerService.m7639$$Nest$fgetmActiveSessions(this.this$0).put(Integer.valueOf(r213), r46);     // Catch: Throwable -> L193
        L242:
            th = th;
        L244:
            th = th;
        L246:
            th = th;
        L248:
            th = th;
        L251:
            th = th;
        L253:
            th = th;
        L259:
            th = th;
            r27 = r15;
        L261:
            th = th;
        L311:
            monitor-exit(r41);     // Catch: Throwable -> L267
            throw th;     // Catch: Throwable -> L216
        L267:
            th = th;
        L263:
            th = th;
        L271:
            th = th;
            r27 = r15;
            goto L294
        L307:
            r40 = r33.id;     // Catch: Throwable -> L157
        L157:
            th = th;
            r27 = r15;
        L275:
            th = th;
        L277:
            th = th;
        L216:
            th = th;
        L269:
            th = th;
            r27 = r15;
            goto L294
        L369:
            int r57 = r210;
            r34 = r57;
            r35 = Long.valueOf(HintManagerService.m7659$$Nest$fgetmNativeWrapper(this.this$0).halCreateHintSession(r28, r57, r5, r6));     // Catch: Throwable -> L107 IllegalStateException -> L109 UnsupportedOperationException -> L111
            goto L313
        L109:
            e = e;
        L126:
            Slog.e("createHintSession failed: ", e.getMessage());     // Catch: Throwable -> L107
            throw new IllegalStateException("createHintSession failed: " + e.getMessage());     // Catch: Throwable -> L107
        L111:
            e = e;
        L128:
            Slog.w("createHintSession unsupported: ", e.getMessage());     // Catch: Throwable -> L107
            throw new UnsupportedOperationException("createHintSession unsupported: " + e.getMessage());     // Catch: Throwable -> L107
        L115:
            e = e;
        L117:
            e = e;
        L113:
            th = th;
            r27 = r15;
            goto L294
        L121:
            e = e;
        L123:
            e = e;
        L119:
            th = th;
            r27 = r15;
        L107:
            th = th;
            r27 = r15;
            goto L294
        L365:
            r26 = -1;
            r28 = r23;
            long r217 = HintManagerService.m7659$$Nest$fgetmNativeWrapper(this.this$0).halCreateHintSessionWithConfig(r28, r2, r5, r6, r25, r33);     // Catch: Throwable -> L74 IllegalStateException -> L76 UnsupportedOperationException -> L78
            r2 = r2;
            r110 = Long.valueOf(r217);     // Catch: Throwable -> L68 IllegalStateException -> L70 UnsupportedOperationException -> L72
            r210 = r2;
            r29 = false;
            goto L348
        L70:
            e = e;
        L309:
            IllegalStateException r310 = e;
            Slog.e("createHintSessionWithConfig failed: ", r310.getMessage());     // Catch: Throwable -> L93
            StringBuilder r58 = new StringBuilder();     // Catch: Throwable -> L93
            r58.append("createHintSessionWithConfig failed: ");     // Catch: Throwable -> L91
            r58.append(r310.getMessage());     // Catch: Throwable -> L91
            throw new IllegalStateException(r58.toString());     // Catch: Throwable -> L91
        L93:
            th = th;
            r27 = r15;
        L68:
            th = th;
            r27 = r15;
        L73:
            r210 = r2;
        L97:
            r29 = false;
            HintManagerService.m7646$$Nest$fgetmConfigCreationSupport(this.this$0).set(false);     // Catch: Throwable -> L91
            goto L348
        L76:
            e = e;
            r2 = r2;
        L74:
            th = th;
            r27 = r15;
        L79:
            r210 = r2;
            goto L97
        L85:
            r26 = -1;
            r28 = r23;
            r210 = r2;
        L82:
            e = e;
            r28 = r23;
        L80:
            th = th;
            r27 = r15;
        L96:
            r26 = -1;
            r28 = r23;
            r210 = r2;
        L91:
            th = th;
            r27 = r15;
        L283:
            th = th;
            r27 = r15;
            goto L294
        L346:
            switch(getUidApplicationCategory(r2)) {
                case -1: goto L54;
                case 0: goto L53;
                default: goto L52;
            };
        L52:
            r25 = 4;
            goto L355
        L53:
            r25 = 3;
            goto L355
        L54:
            r25 = 4;
        L55:
            th = th;
            r27 = r15;
        L285:
            th = th;
            r27 = r15;
        L37:
            th = th;
            r27 = r15;
            goto L294
        L45:
            r23 = r3;
        L43:
            e = e;
            r23 = r3;
        L41:
            th = th;
            r27 = r15;
        L292:
            th = th;
            r27 = r15;
            goto L294
        L22:
            r19 = 1;
            r16 = false;
            r17 = false;
            goto L23
        L7:
            r0 = false;
            goto L8
        L297:
            throw new UnsupportedOperationException("PowerHintSessions are not supported!");
        }

        private static /* synthetic */ ArrayMap lambda$createHintSessionWithConfig$0(Integer k) {
            return new ArrayMap();
        }

        private /* synthetic */ AppHintSessionSnapshot lambda$createHintSessionWithConfig$1(Integer k) {
            return new AppHintSessionSnapshot(this.this$0);
        }

        private static /* synthetic */ ArraySet lambda$createHintSessionWithConfig$2(Integer k) {
            return new ArraySet();
        }

        public ChannelConfig getSessionChannel(IBinder token) {
            if (HintManagerService.m7664$$Nest$fgetmPowerHalVersion(this.this$0) >= 5) goto L5;
        L13:
            return null;
        L5:
            if (HintManagerService.m7653$$Nest$fgetmFMQUsesIntegratedEventFlag(this.this$0).booleanValue() == true) goto L13;
            token.getClass();
            int callingTgid = Process.getThreadGroupLeader(Binder.getCallingPid());
            int callingUid = Binder.getCallingUid();
            ChannelItem item = this.this$0.getOrCreateMappedChannelItem(callingTgid, callingUid, token);
            if (item.getConfig().eventFlagDescriptor != null) goto L12;
            HintManagerService.m7674$$Nest$fputmFMQUsesIntegratedEventFlag(this.this$0, true);
            closeSessionChannel();
            return null;
        L12:
            return item.getConfig();
        }

        public void closeSessionChannel() {
            if (HintManagerService.m7664$$Nest$fgetmPowerHalVersion(this.this$0) < 5) goto L6;
            int callingTgid = Process.getThreadGroupLeader(Binder.getCallingPid());
            int callingUid = Binder.getCallingUid();
            this.this$0.removeChannelItem(Integer.valueOf(callingTgid), Integer.valueOf(callingUid));
            return;
        }

        public int getMaxGraphicsPipelineThreadsCount() {
            return 5;
        }

        public void setHintSessionThreads(IHintSession hintSession, int[] tids) {
            AppHintSession appHintSession = (AppHintSession) hintSession;
            appHintSession.setThreads(tids);
        }

        public int[] getHintSessionThreadIds(IHintSession hintSession) {
            AppHintSession appHintSession = (AppHintSession) hintSession;
            return appHintSession.getThreadIds();
        }

        public CpuHeadroomResult getCpuHeadroom(CpuHeadroomParamsInternal params) {
            if (HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.isCpuSupported == false) goto L89;
            checkCpuHeadroomParams(params);
            int uid = Binder.getCallingUid();
            int pid = Binder.getCallingPid();
            CpuHeadroomParams halParams = new CpuHeadroomParams();
            halParams.tids = new int[]{pid};
            halParams.calculationType = params.calculationType;
            halParams.calculationWindowMillis = params.calculationWindowMillis;
            boolean shouldCheckUserModeCpuTime = true;
            if (params.usesDeviceHeadroom == false) goto L8;
            halParams.tids = new int[0];
        L29:
            Object r3 = HintManagerService.m7649$$Nest$fgetmCpuHeadroomLock(this.this$0);
            monitor-enter(r3);
            CpuHeadroomResult res = (CpuHeadroomResult) HintManagerService.m7648$$Nest$fgetmCpuHeadroomCache(this.this$0).get(halParams);     // Catch: Throwable -> L35
            if (res == null) goto L37;
            monitor-exit(r3);     // Catch: Throwable -> L35
            return res;
        L37:
            monitor-exit(r3);     // Catch: Throwable -> L35
            if (HintManagerService.m7652$$Nest$fgetmEnforceCpuHeadroomUserModeCpuTimeCheck(this.this$0) == true) goto L48;
            if (UserHandle.getAppId(uid) != 1000) goto L43;
        L45:
            shouldCheckUserModeCpuTime = false;
            goto L48
        L43:
            if (HintManagerService.m7647$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.DEVICE_POWER") != (-1)) goto L45;
        L48:
            if (shouldCheckUserModeCpuTime == false) goto L93;
            Object r4 = HintManagerService.m7649$$Nest$fgetmCpuHeadroomLock(this.this$0);
            monitor-enter(r4);
        L55:
            th = move-exception;
            throw th;
        L52:
            if (checkPerUidUserModeCpuTimeElapsedLocked(uid) == true) goto L57;
            monitor-exit(r4);     // Catch: Throwable -> L55
            return null;
        L57:
            monitor-exit(r4);     // Catch: Throwable -> L55
        L93:
            CpuHeadroomResult result = HintManagerService.m7663$$Nest$fgetmPowerHal(this.this$0).getCpuHeadroom(halParams);     // Catch: RemoteException -> L65
            if (result != null) goto L67;
            Slog.wtf(HintManagerService.TAG, "CPU headroom from Power HAL is invalid");     // Catch: RemoteException -> L65
            return null;
        L67:
            Object r6 = HintManagerService.m7649$$Nest$fgetmCpuHeadroomLock(this.this$0);     // Catch: RemoteException -> L65
            monitor-enter(r6);     // Catch: RemoteException -> L65
            HintManagerService.m7648$$Nest$fgetmCpuHeadroomCache(this.this$0).add(halParams, result);     // Catch: Throwable -> L81
            monitor-exit(r6);     // Catch: Throwable -> L81
            if (shouldCheckUserModeCpuTime == false) goto L80;
            Object r7 = HintManagerService.m7649$$Nest$fgetmCpuHeadroomLock(this.this$0);     // Catch: RemoteException -> L65
            monitor-enter(r7);     // Catch: RemoteException -> L65
            HintManagerService.m7672$$Nest$fgetmUidToLastUserModeJiffies(this.this$0).put(Integer.valueOf(uid), Long.valueOf(HintManagerService.m7656$$Nest$fgetmLastCpuUserModeJiffies(this.this$0)));     // Catch: Throwable -> L77
            monitor-exit(r7);     // Catch: Throwable -> L77
        L77:
            th = move-exception;
            throw th;     // Catch: RemoteException -> L65
        L80:
            return result;
        L81:
            th = move-exception;
            throw th;     // Catch: RemoteException -> L65
        L65:
            e = move-exception;
            Slog.e(HintManagerService.TAG, "Failed to get CPU headroom from Power HAL", e);
            return null;
        L35:
            th = move-exception;
            throw th;
        L8:
            if (params.tids == null) goto L29;
            if (params.tids.length <= 0) goto L29;
            if (UserHandle.getAppId(uid) == 1000) goto L24;
            if (HintManagerService.m7644$$Nest$fgetmCheckHeadroomTid(this.this$0) == false) goto L24;
            int tgid = Process.getThreadGroupLeader(Binder.getCallingPid());
            int[] r8 = params.tids;
            int r9 = r8.length;
            int r10 = 0;
        L17:
            if (r10 >= r9) goto L24;
            int tid = r8[r10];
            if (Process.getThreadGroupLeader(tid) != tgid) goto L22;
            r10 = r10 + 1;
            goto L17
        L22:
            throw new SecurityException("TID " + tid + " doesn't belong to the calling process with pid " + tgid);
        L24:
            if (HintManagerService.m7642$$Nest$fgetmCheckHeadroomAffinity(this.this$0) == true) goto L26;
        L28:
            halParams.tids = params.tids;
            goto L29
        L26:
            if (params.tids.length <= 1) goto L28;
            checkThreadAffinityForTids(params.tids);
            goto L28
        L89:
            throw new UnsupportedOperationException();
        }

        private void checkThreadAffinityForTids(int[] tids) {
            long[] reference = null;
            int r2 = tids.length;
            int r4 = 0;
        L3:
            if (r4 >= r2) goto L16;
            int tid = tids[r4];
            long[] affinity = Process.getSchedAffinity(tid);     // Catch: Exception -> L13
            if (reference != null) goto L9;
            reference = affinity;
        L10:
            r4 = r4 + 1;
            goto L3
        L9:
            if (Arrays.equals(reference, affinity) == true) goto L10;
            Slog.d(HintManagerService.TAG, "Thread affinity is different: tid " + tids[0] + "->" + Arrays.toString(reference) + ", tid " + tid + "->" + Arrays.toString(affinity));
            throw new IllegalStateException("Thread affinity is not the same for tids " + Arrays.toString(tids));
        L13:
            e = move-exception;
            Slog.e(HintManagerService.TAG, "Failed to get affinity " + tid, e);
            throw new IllegalStateException("Could not check affinity for tid " + tid);
        }

        private boolean checkPerUidUserModeCpuTimeElapsedLocked(int uid) {
            if ((System.currentTimeMillis() - HintManagerService.m7657$$Nest$fgetmLastCpuUserModeTimeCheckedMillis(this.this$0)) <= HintManagerService.m7643$$Nest$fgetmCheckHeadroomProcStatMinMillis(this.this$0)) goto L10;
            HintManagerService.m7675$$Nest$fputmLastCpuUserModeJiffies(this.this$0, getUserModeJiffies());     // Catch: Exception -> L6
            HintManagerService.m7676$$Nest$fputmLastCpuUserModeTimeCheckedMillis(this.this$0, System.currentTimeMillis());
        L6:
            e = move-exception;
            Slog.e(HintManagerService.TAG, "Failed to get user mode CPU time", e);
            return false;
        L10:
            if (HintManagerService.m7672$$Nest$fgetmUidToLastUserModeJiffies(this.this$0).containsKey(Integer.valueOf(uid)) == false) goto L15;
            long uidLastUserModeJiffies = ((Long) HintManagerService.m7672$$Nest$fgetmUidToLastUserModeJiffies(this.this$0).get(Integer.valueOf(uid))).longValue();
            if (((HintManagerService.m7656$$Nest$fgetmLastCpuUserModeJiffies(this.this$0) - uidLastUserModeJiffies) * this.this$0.mJiffyMillis) >= HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.cpuMinIntervalMillis) goto L19;
            Slog.w(HintManagerService.TAG, "UID " + uid + " is requesting CPU headroom too soon");
            Slog.d(HintManagerService.TAG, "UID " + uid + " last request at " + (uidLastUserModeJiffies * this.this$0.mJiffyMillis) + "ms with device currently at " + (HintManagerService.m7656$$Nest$fgetmLastCpuUserModeJiffies(this.this$0) * this.this$0.mJiffyMillis) + "ms, the interval: " + ((HintManagerService.m7656$$Nest$fgetmLastCpuUserModeJiffies(this.this$0) - uidLastUserModeJiffies) * this.this$0.mJiffyMillis) + "ms is less than require minimum interval " + HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.cpuMinIntervalMillis + "ms");
            return false;
        L19:
            return true;
        L15:
            return true;
        }

        private void checkCpuHeadroomParams(CpuHeadroomParamsInternal params) {
            boolean calculationTypeMatched = false;
            Field[] r1 = CpuHeadroomParams.CalculationType.class.getDeclaredFields();     // Catch: IllegalAccessException -> L10
            int r2 = r1.length;     // Catch: IllegalAccessException -> L10
            int r3 = 0;
        L4:
            if (r3 >= r2) goto L15;
            Field field = r1[r3];     // Catch: IllegalAccessException -> L10
            if (field.getType() != Byte.TYPE) goto L12;
            byte value = field.getByte(null);     // Catch: IllegalAccessException -> L10
            if (value != params.calculationType) goto L12;
            calculationTypeMatched = true;
        L12:
            r3 = r3 + 1;
        L15:
            if (calculationTypeMatched == false) goto L33;
            if (params.calculationWindowMillis < HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.cpuMinCalculationWindowMillis) goto L31;
            if (params.calculationWindowMillis > HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.cpuMaxCalculationWindowMillis) goto L31;
            if (params.usesDeviceHeadroom == false) goto L23;
            return;
        L23:
            if (params.tids != null) goto L25;
            return;
        L25:
            if (params.tids.length > HintManagerService.m7650$$Nest$fgetmCpuHeadroomMaxTidCnt(this.this$0)) goto L28;
            return;
        L28:
            throw new IllegalArgumentException("More than " + HintManagerService.m7650$$Nest$fgetmCpuHeadroomMaxTidCnt(this.this$0) + " TIDs requested: " + params.tids.length);
        L31:
            throw new IllegalArgumentException("Invalid CPU headroom calculation window, expected [" + HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.cpuMinCalculationWindowMillis + ", " + HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.cpuMaxCalculationWindowMillis + "] but got " + params.calculationWindowMillis);
        L33:
            throw new IllegalArgumentException("Unknown CPU headroom calculation type " + params.calculationType);
        L14:
            Slog.wtf(HintManagerService.TAG, "Checking the calculation type was unexpectedly not allowed");
            goto L15
        }

        public GpuHeadroomResult getGpuHeadroom(GpuHeadroomParamsInternal params) {
            if (HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.isGpuSupported == false) goto L33;
            checkGpuHeadroomParams(params);
            GpuHeadroomParams halParams = new GpuHeadroomParams();
            halParams.calculationType = params.calculationType;
            halParams.calculationWindowMillis = params.calculationWindowMillis;
            Object r1 = HintManagerService.m7655$$Nest$fgetmGpuHeadroomLock(this.this$0);
            monitor-enter(r1);
            GpuHeadroomResult res = (GpuHeadroomResult) HintManagerService.m7654$$Nest$fgetmGpuHeadroomCache(this.this$0).get(halParams);     // Catch: Throwable -> L10
            if (res == null) goto L12;
            monitor-exit(r1);     // Catch: Throwable -> L10
            return res;
        L12:
            monitor-exit(r1);     // Catch: Throwable -> L10
            GpuHeadroomResult headroom = HintManagerService.m7663$$Nest$fgetmPowerHal(this.this$0).getGpuHeadroom(halParams);     // Catch: RemoteException -> L18
            if (headroom != null) goto L20;
            Slog.wtf(HintManagerService.TAG, "GPU headroom from Power HAL is invalid");     // Catch: RemoteException -> L18
            return null;
        L20:
            Object r3 = HintManagerService.m7655$$Nest$fgetmGpuHeadroomLock(this.this$0);     // Catch: RemoteException -> L18
            monitor-enter(r3);     // Catch: RemoteException -> L18
            HintManagerService.m7654$$Nest$fgetmGpuHeadroomCache(this.this$0).add(halParams, headroom);     // Catch: Throwable -> L25
            monitor-exit(r3);     // Catch: Throwable -> L25
            return headroom;
        L25:
            th = move-exception;
            throw th;     // Catch: RemoteException -> L18
        L18:
            e = move-exception;
            Slog.e(HintManagerService.TAG, "Failed to get GPU headroom from Power HAL", e);
            return null;
        L10:
            th = move-exception;
            throw th;
        L33:
            throw new UnsupportedOperationException();
        }

        private void checkGpuHeadroomParams(GpuHeadroomParamsInternal params) {
            boolean calculationTypeMatched = false;
            Field[] r1 = GpuHeadroomParams.CalculationType.class.getDeclaredFields();     // Catch: IllegalAccessException -> L10
            int r2 = r1.length;     // Catch: IllegalAccessException -> L10
            int r3 = 0;
        L4:
            if (r3 >= r2) goto L15;
            Field field = r1[r3];     // Catch: IllegalAccessException -> L10
            if (field.getType() != Byte.TYPE) goto L12;
            byte value = field.getByte(null);     // Catch: IllegalAccessException -> L10
            if (value != params.calculationType) goto L12;
            calculationTypeMatched = true;
        L12:
            r3 = r3 + 1;
        L15:
            if (calculationTypeMatched == false) goto L24;
            if (params.calculationWindowMillis < HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.gpuMinCalculationWindowMillis) goto L22;
            if (params.calculationWindowMillis > HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.gpuMaxCalculationWindowMillis) goto L22;
            return;
        L22:
            throw new IllegalArgumentException("Invalid GPU headroom calculation window, expected [" + HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.gpuMinCalculationWindowMillis + ", " + HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.gpuMaxCalculationWindowMillis + "] but got " + params.calculationWindowMillis);
        L24:
            throw new IllegalArgumentException("Unknown GPU headroom calculation type " + params.calculationType);
        L14:
            Slog.wtf(HintManagerService.TAG, "Checking the calculation type was unexpectedly not allowed");
            goto L15
        }

        public long getCpuHeadroomMinIntervalMillis() {
            if (HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.isCpuSupported == false) goto L7;
            return HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.cpuMinIntervalMillis;
        L7:
            throw new UnsupportedOperationException();
        }

        public long getGpuHeadroomMinIntervalMillis() {
            if (HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.isGpuSupported == false) goto L7;
            return HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.gpuMinIntervalMillis;
        L7:
            throw new UnsupportedOperationException();
        }

        public void passSessionManagerBinder(IBinder sessionManager) {
            if (Process.myUid() == Binder.getCallingUid()) goto L5;
            return;
        L5:
            HintManagerService.m7677$$Nest$fputmSessionManager(this.this$0, ISessionManager.Stub.asInterface(sessionManager));
        }

        public IHintManager.HintManagerClientData registerClient(IHintManager.IHintManagerClient clientBinder) {
            return getClientData();
        }

        public IHintManager.HintManagerClientData getClientData() {
            IHintManager.HintManagerClientData out = new IHintManager.HintManagerClientData();
            out.preferredRateNanos = this.this$0.mHintSessionPreferredRate;
            out.maxGraphicsPipelineThreads = getMaxGraphicsPipelineThreadsCount();
            out.maxCpuHeadroomThreads = 5;
            out.powerHalVersion = HintManagerService.m7664$$Nest$fgetmPowerHalVersion(this.this$0);
            out.supportInfo = HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0);
            return out;
        }

        public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.getContext(), HintManagerService.TAG, pw) == true) goto L5;
            return;
        L5:
            pw.println("HintSessionPreferredRate: " + this.this$0.mHintSessionPreferredRate);
            pw.println("MaxGraphicsPipelineThreadsCount: 5");
            pw.println("Hint Session Support: " + HintManagerService.m7682$$Nest$misHintSessionSupported(this.this$0));
            pw.println("Active Sessions:");
            Object r0 = HintManagerService.m7658$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int i = 0;
        L54:
        L17:
            th = move-exception;
            throw th;
        L9:
            if (i >= HintManagerService.m7639$$Nest$fgetmActiveSessions(this.this$0).size()) goto L22;
            pw.println("Uid " + ((Integer) HintManagerService.m7639$$Nest$fgetmActiveSessions(this.this$0).keyAt(i)).toString() + ":");     // Catch: Throwable -> L17
            ArrayMap<IBinder, ArraySet<AppHintSession>> tokenMap = (ArrayMap) HintManagerService.m7639$$Nest$fgetmActiveSessions(this.this$0).valueAt(i);     // Catch: Throwable -> L17
            int j = 0;
        L12:
            if (j >= tokenMap.size()) goto L20;
            ArraySet<AppHintSession> sessionSet = tokenMap.valueAt(j);     // Catch: Throwable -> L17
            int k = 0;
        L15:
            if (k >= sessionSet.size()) goto L19;
            pw.println("  Session:");     // Catch: Throwable -> L17
            AppHintSession.m7685$$Nest$mdump(sessionSet.valueAt(k), pw, "    ");     // Catch: Throwable -> L17
            k = k + 1;     // Catch: Throwable -> L17
            goto L15
        L19:
            j = j + 1;     // Catch: Throwable -> L17
            goto L12
        L20:
            i = i + 1;     // Catch: Throwable -> L17
            goto L54
        L22:
            monitor-exit(r0);     // Catch: Throwable -> L17
            pw.println("CPU Headroom Supported: " + HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.isCpuSupported);
            if (HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.isCpuSupported == false) goto L35;
            pw.println("CPU Headroom Interval: " + HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.cpuMinIntervalMillis);
            pw.println("CPU Headroom TID Max Count: " + HintManagerService.m7650$$Nest$fgetmCpuHeadroomMaxTidCnt(this.this$0));
            pw.println("CPU Headroom TID Max Count From HAL: " + HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.cpuMaxTidCount);
            pw.println("CPU Headroom Calculation Window Range: [" + HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.cpuMinCalculationWindowMillis + ", " + HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.cpuMaxCalculationWindowMillis + "]");
            CpuHeadroomParamsInternal params = new CpuHeadroomParamsInternal();     // Catch: Exception -> L29
            params.usesDeviceHeadroom = true;     // Catch: Exception -> L29
            CpuHeadroomResult ret = getCpuHeadroom(params);     // Catch: Exception -> L29
            StringBuilder r2 = new StringBuilder();     // Catch: Exception -> L29
            r2.append("CPU headroom: ");     // Catch: Exception -> L29
            if (ret != null) goto L31;
            Object r3 = "N/A";
        L32:
            r2.append(r3);     // Catch: Exception -> L29
            pw.println(r2.toString());     // Catch: Exception -> L29
            goto L35
        L31:
            r3 = Float.valueOf(ret.getGlobalHeadroom());     // Catch: Exception -> L29
        L29:
            e = move-exception;
            Slog.d(HintManagerService.TAG, "Failed to dump CPU headroom", e);
            pw.println("CPU headroom: N/A");
        L35:
            pw.println("GPU Headroom Supported: " + HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.isGpuSupported);
            if (HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.isGpuSupported == false) goto L59;
            pw.println("GPU Headroom Interval: " + HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.gpuMinIntervalMillis);
            pw.println("GPU Headroom Calculation Window Range: [" + HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.gpuMinCalculationWindowMillis + ", " + HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.gpuMaxCalculationWindowMillis + "]");
            GpuHeadroomParamsInternal params2 = new GpuHeadroomParamsInternal();     // Catch: Exception -> L41
            params2.calculationWindowMillis = HintManagerService.m7651$$Nest$fgetmDefaultGpuHeadroomCalculationWindowMillis(this.this$0);     // Catch: Exception -> L41
            GpuHeadroomResult ret2 = getGpuHeadroom(params2);     // Catch: Exception -> L41
            StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L41
            r4.append("GPU headroom: ");     // Catch: Exception -> L41
            if (ret2 != null) goto L43;
            Object r5 = "N/A";
        L44:
            r4.append(r5);     // Catch: Exception -> L41
            pw.println(r4.toString());     // Catch: Exception -> L41
            return;
        L43:
            r5 = Float.valueOf(ret2.getGlobalHeadroom());     // Catch: Exception -> L41
        L41:
            e = move-exception;
            Slog.d(HintManagerService.TAG, "Failed to dump GPU headroom", e);
            pw.println("GPU headroom: N/A");
            return;
        }

        private long getUserModeJiffies() throws IOException {
            if (HintManagerService.m7665$$Nest$fgetmProcStatFilePathOverride(this.this$0) != null) goto L5;
            String filePath = "/proc/stat";
        L6:
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
        L24:
            String line = reader.readLine();     // Catch: Throwable -> L14
            if (line == null) goto L17;
            Matcher matcher = HintManagerService.m7684$$Nest$sfgetPROC_STAT_CPU_TIME_TOTAL_PATTERN().matcher(line.trim());     // Catch: Throwable -> L14
            if (matcher.find() == false) goto L24;
            long userJiffies = Long.parseLong(matcher.group("user"));     // Catch: Throwable -> L14
            long niceJiffies = Long.parseLong(matcher.group("nice"));     // Catch: Throwable -> L14
            Slog.d(HintManagerService.TAG, "user: " + userJiffies + " nice: " + niceJiffies + " total " + (userJiffies + niceJiffies));     // Catch: Throwable -> L14
            reader.close();     // Catch: Throwable -> L14
            long r8 = userJiffies + niceJiffies;
            reader.close();
            return r8;
        L17:
            reader.close();
            throw new IllegalStateException("Can't find cpu line in " + filePath);
        L14:
            th = move-exception;
            reader.close();     // Catch: Throwable -> L21
        L23:
            throw th;
        L21:
            th = move-exception;
            th.addSuppressed(th);
            goto L23
        L5:
            filePath = HintManagerService.m7665$$Nest$fgetmProcStatFilePathOverride(this.this$0);
            goto L6
        }

        private void logPerformanceHintSessionAtom(int uid, long sessionId, long targetDuration, int[] tids, int sessionTag) {
            FrameworkStatsLog.write(FrameworkStatsLog.PERFORMANCE_HINT_SESSION_REPORTED, uid, sessionId, targetDuration, tids.length, sessionTag);
        }

        private int getUidApplicationCategory(int uid) {
            String packageName = HintManagerService.m7662$$Nest$fgetmPackageManager(this.this$0).getNameForUid(uid);     // Catch: PackageManager.NameNotFoundException -> L4
            ApplicationInfo applicationInfo = HintManagerService.m7662$$Nest$fgetmPackageManager(this.this$0).getApplicationInfo(packageName, 131072);     // Catch: PackageManager.NameNotFoundException -> L4
            return applicationInfo.category;
        L5:
            return -1;
        }
    }

    private class ChannelItem implements IBinder.DeathRecipient {
        ChannelConfig mConfig;
        boolean mLinked;
        final int mTgid;
        final IBinder mToken;
        final int mUid;
        final /* synthetic */ HintManagerService this$0;

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.removeChannelItem(Integer.valueOf(this.mTgid), Integer.valueOf(this.mUid));
        }

        ChannelItem(HintManagerService r1, int tgid, int uid, IBinder token) {
            this.this$0 = r1;
            this.mTgid = tgid;
            this.mUid = uid;
            this.mToken = token;
            this.mLinked = false;
            this.mConfig = null;
        }

        public void closeChannel() {
            if (this.mLinked == false) goto L6;
            this.mToken.unlinkToDeath(this, 0);
            this.mLinked = false;
        L6:
            if (this.mConfig != null) goto L13;
            return;
        L13:
            HintManagerService.m7663$$Nest$fgetmPowerHal(this.this$0).closeSessionChannel(this.mTgid, this.mUid);     // Catch: RemoteException -> L9
            this.mConfig = null;
            return;
        L9:
            e = move-exception;
            throw new IllegalStateException("Failed to close session channel!", e);
        }

        public void openChannel() {
            if (this.mLinked == true) goto L10;
            this.mToken.linkToDeath(this, 0);     // Catch: RemoteException -> L6
            this.mLinked = true;
        L6:
            e = move-exception;
            throw new IllegalStateException("Client already dead", e);
        L10:
            if (this.mConfig == null) goto L17;
            return;
        L17:
            this.mConfig = HintManagerService.m7663$$Nest$fgetmPowerHal(this.this$0).getSessionChannel(this.mTgid, this.mUid);     // Catch: RemoteException -> L13
            return;
        L13:
            e = move-exception;
            this.this$0.removeChannelItem(Integer.valueOf(this.mTgid), Integer.valueOf(this.mUid));
            throw new IllegalStateException("Failed to create session channel!", e);
        }

        ChannelConfig getConfig() {
            return this.mConfig;
        }
    }

    final class CleanUpHandler extends Handler {
        private static final int TID_EXITED = 2;
        private static final int TID_NOT_CHECKED = 0;
        private static final int TID_PASSED_CHECK = 1;
        final /* synthetic */ HintManagerService this$0;

        CleanUpHandler(HintManagerService this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            CleanUpHandler r1 = this;
            if (msg.what == 3) goto L5;
            return;
        L5:
            if (r1.hasEqualMessages(msg.what, msg.obj) == false) goto L8;
            r1.removeEqualMessages(msg.what, msg.obj);
            Message newMsg = r1.obtainMessage(msg.what, msg.obj);
            r1.sendMessageDelayed(newMsg, 1000);
            Slog.d(HintManagerService.TAG, "Duplicate messages for " + msg.obj);
            return;
        L8:
            Slog.d(HintManagerService.TAG, "Starts cleaning for " + msg.obj);
            int uid = ((Integer) msg.obj).intValue();
            boolean isForeground = r1.this$0.mUidObserver.isUidForeground(uid);
            Object r3 = HintManagerService.m7658$$Nest$fgetmLock(r1.this$0);
            monitor-enter(r3);
            ArrayMap<IBinder, ArraySet<AppHintSession>> tokenMap = (ArrayMap) HintManagerService.m7639$$Nest$fgetmActiveSessions(r1.this$0).get(Integer.valueOf(uid));     // Catch: Throwable -> L20
            if (tokenMap == null) goto L34;
            if (tokenMap.isEmpty() == true) goto L34;
            List<AppHintSession> sessions = new ArrayList(tokenMap.size());     // Catch: Throwable -> L20
            int i = tokenMap.size() - 1;     // Catch: Throwable -> L20
        L16:
            if (i < 0) goto L24;
            ArraySet<AppHintSession> set = tokenMap.valueAt(i);     // Catch: Throwable -> L20
            int j = set.size() - 1;     // Catch: Throwable -> L20
        L18:
            if (j < 0) goto L22;
            sessions.add(set.valueAt(j));     // Catch: Throwable -> L20
            j = j - 1;     // Catch: Throwable -> L20
            goto L18
        L22:
            i = i - 1;     // Catch: Throwable -> L20
            goto L16
        L24:
            monitor-exit(r3);     // Catch: Throwable -> L20
            long[] durationList = new long[sessions.size()];
            int[] invalidTidCntList = new int[sessions.size()];
            SparseIntArray checkedTids = new SparseIntArray();
            int[] totalTidCnt = new int[1];
            int i2 = sessions.size() - 1;
        L26:
            if (i2 < 0) goto L33;
            AppHintSession session = sessions.get(i2);
            long start = System.nanoTime();
            int invalidCnt = r1.cleanUpSession(session, checkedTids, totalTidCnt);     // Catch: Exception -> L30
            long elapsed = System.nanoTime() - start;     // Catch: Exception -> L30
            invalidTidCntList[i2] = invalidCnt;     // Catch: Exception -> L30
            durationList[i2] = elapsed;     // Catch: Exception -> L30
        L32:
            i2 = i2 - 1;
            r1 = this;
        L31:
            Slog.e(HintManagerService.TAG, "Failed to clean up session " + session.mHalSessionPtr + " for UID " + session.mUid);
            goto L32
        L33:
            int i3 = sessions.size();
            logCleanUpMetrics(uid, invalidTidCntList, durationList, i3, totalTidCnt[0], isForeground);
            return;
        L34:
            monitor-exit(r3);     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            throw th;
        }

        private void logCleanUpMetrics(int uid, int[] count, long[] durationNsList, int sessionCnt, int totalTidCnt, boolean isForeground) {
            int i = 0;
            int maxInvalidTidCnt = Integer.MIN_VALUE;
            int totalInvalidTidCnt = 0;
        L3:
            int maxInvalidTidCnt2 = count.length;
            if (i >= maxInvalidTidCnt2) goto L7;
            totalInvalidTidCnt = totalInvalidTidCnt + count[i];
            maxInvalidTidCnt = Math.max(maxInvalidTidCnt, count[i]);
            i = i + 1;
            goto L3
        L7:
            if (totalInvalidTidCnt <= 0) goto L14;
            Arrays.sort(durationNsList);
            long totalDurationNs = 0;
            int i2 = 0;
        L10:
            if (i2 >= durationNsList.length) goto L12;
            totalDurationNs = totalDurationNs + durationNsList[i2];
            i2 = i2 + 1;
            goto L10
        L12:
            int totalDurationUs = (int) TimeUnit.NANOSECONDS.toMicros(totalDurationNs);
            int maxDurationUs = (int) TimeUnit.NANOSECONDS.toMicros(durationNsList[durationNsList.length - 1]);
            int minDurationUs = (int) TimeUnit.NANOSECONDS.toMicros(durationNsList[0]);
            int avgDurationUs = (int) TimeUnit.NANOSECONDS.toMicros(totalDurationNs / ((long) durationNsList.length));
            int th90DurationUs = (int) TimeUnit.NANOSECONDS.toMicros(durationNsList[(int) (((double) durationNsList.length) * 0.9d)]);
            FrameworkStatsLog.write(FrameworkStatsLog.ADPF_HINT_SESSION_TID_CLEANUP, uid, totalDurationUs, maxDurationUs, totalTidCnt, totalInvalidTidCnt, maxInvalidTidCnt, sessionCnt, isForeground);
            Slog.w(HintManagerService.TAG, "Invalid tid found for UID" + uid + " in " + totalDurationUs + "us:\n\tcount( session: " + sessionCnt + " totalTid: " + totalTidCnt + " maxInvalidTid: " + maxInvalidTidCnt + " totalInvalidTid: " + totalInvalidTidCnt + ")\n\ttime per session( min: " + minDurationUs + "us max: " + maxDurationUs + "us avg: " + avgDurationUs + "us 90%: " + th90DurationUs + "us)\n\tisForeground: " + isForeground);
            return;
        }

        public int cleanUpSession(AppHintSession session, SparseIntArray checkedTids, int[] total) {
            if (session.isClosed() == false) goto L5;
        L69:
            return 0;
        L5:
            if (session.isForcePaused() == true) goto L69;
            int pid = session.mPid;
            int[] tids = session.getTidsInternal();
            if (total != null) goto L10;
        L12:
            IntArray filtered = new IntArray(tids.length);
            int i = 0;
        L14:
            if (i >= tids.length) goto L43;
            int tid = tids[i];
            if (checkedTids.get(tid, 0) != 0) goto L18;
            Object r7 = HintManagerService.m7661$$Nest$fgetmNonIsolatedTidsLock(this.this$0);
            monitor-enter(r7);
            boolean isNotIsolated = HintManagerService.m7660$$Nest$fgetmNonIsolatedTids(this.this$0).containsKey(Integer.valueOf(tid));     // Catch: Throwable -> L40
            monitor-exit(r7);     // Catch: Throwable -> L40
            if (isNotIsolated == true) goto L73;
            Process.checkPid(tid);     // Catch: Exception -> L26 NoSuchElementException -> L28
        L31:
            checkedTids.put(tid, 1);     // Catch: Exception -> L26 NoSuchElementException -> L28
            filtered.add(tid);     // Catch: Exception -> L26 NoSuchElementException -> L28
        L39:
            i = i + 1;
            goto L14
        L73:
            Process.checkTid(pid, tid);     // Catch: Exception -> L26 NoSuchElementException -> L28
        L26:
            e = move-exception;
            StringBuilder r10 = new StringBuilder();
            r10.append("Unexpected exception when checking TID ");
            r10.append(tid);
            r10.append(" under PID ");
            r10.append(pid);
            r10.append("(isolated: ");
            if (isNotIsolated == true) goto L36;
            boolean r11 = true;
        L37:
            r10.append(r11);
            r10.append(")");
            Slog.w(HintManagerService.TAG, r10.toString(), e);
            filtered.add(tid);
            goto L39
        L36:
            r11 = false;
        L38:
            checkedTids.put(tid, 2);
        L40:
            th = move-exception;
            throw th;
        L18:
            if (checkedTids.get(tid) != 1) goto L39;
            filtered.add(tid);
            goto L39
        L43:
            int i2 = tids.length;
            int diff = i2 - filtered.size();
            if (diff <= 0) goto L68;
            monitor-enter(session);
            int[] newTids = session.getTidsInternal();     // Catch: Throwable -> L51
            if (newTids.length == tids.length) goto L53;
            Slog.d(HintManagerService.TAG, "Skipped cleaning up the session as new tids are added");     // Catch: Throwable -> L51
            monitor-exit(session);     // Catch: Throwable -> L51
            return diff;
        L53:
            Arrays.sort(newTids);     // Catch: Throwable -> L51
            Arrays.sort(tids);     // Catch: Throwable -> L51
            if (Arrays.equals(newTids, tids) == true) goto L58;
            Slog.d(HintManagerService.TAG, "Skipped cleaning up the session as new tids are updated");     // Catch: Throwable -> L51
            monitor-exit(session);     // Catch: Throwable -> L51
            return diff;
        L58:
            Slog.d(HintManagerService.TAG, "Cleaned up " + diff + " invalid tids for session " + session.mHalSessionPtr + " with UID " + session.mUid + "\n\tbefore: " + Arrays.toString(tids) + "\n\tafter: " + filtered);     // Catch: Throwable -> L51
            int[] filteredTids = filtered.toArray();     // Catch: Throwable -> L51
            if (filteredTids.length != 0) goto L63;
            session.mShouldForcePause = true;     // Catch: Throwable -> L51
            if (session.mUpdateAllowedByProcState == false) goto L64;
            AppHintSession.m7686$$Nest$mpause(session);     // Catch: Throwable -> L51
        L64:
            monitor-exit(session);     // Catch: Throwable -> L51
            goto L68
        L63:
            AppHintSession.m7687$$Nest$msetThreadsInternal(session, filteredTids, false);     // Catch: Throwable -> L51
        L51:
            th = move-exception;
            throw th;
        L68:
            return diff;
        L10:
            if (total.length != 1) goto L12;
            total[0] = total[0] + tids.length;
            goto L12
        }
    }

    private static class HeadroomCache<K, V> {
        final long mItemExpDurationMillis;
        final List<HeadroomCache<K, V>.HeadroomCacheItem> mItemList;
        final Map<K, HeadroomCache<K, V>.HeadroomCacheItem> mKeyItemMap;

        class HeadroomCacheItem {
            long mExpTime;
            K mKey;
            V mValue;

            HeadroomCacheItem(HeadroomCache this$0, K k, V v) {
                this.mExpTime = System.currentTimeMillis() + this$0.mItemExpDurationMillis;
                this.mKey = k;
                this.mValue = v;
            }

            boolean isExpired() {
                if (this.mExpTime > System.currentTimeMillis()) goto L5;
                return true;
            L5:
                return false;
            }
        }

        void add(K key, V value) {
            if (this.mKeyItemMap.containsKey(key) == false) goto L5;
            HeadroomCache<K, V>.HeadroomCacheItem item = this.mKeyItemMap.get(key);
            this.mItemList.remove(item);
        L5:
            HeadroomCache<K, V>.HeadroomCacheItem item2 = new HeadroomCacheItem(this, key, value);
            this.mItemList.add(item2);
            this.mKeyItemMap.put(key, item2);
        }

        V get(K key) {
        L3:
            if (this.mItemList.isEmpty() == true) goto L7;
            if (((HeadroomCacheItem) this.mItemList.getFirst()).isExpired() == false) goto L7;
            this.mKeyItemMap.remove(((HeadroomCacheItem) this.mItemList.removeFirst()).mKey);
        L7:
            HeadroomCache<K, V>.HeadroomCacheItem item = this.mKeyItemMap.get(key);
            if (item != null) goto L12;
            return null;
        L12:
            return item.mValue;
        }

        HeadroomCache(int size, long expDurationMillis) {
            this.mItemList = new LinkedList();
            this.mKeyItemMap = new ArrayMap(size);
            this.mItemExpDurationMillis = expDurationMillis;
        }
    }

    static class Injector {
        Injector() {
        }

        NativeWrapper createNativeWrapper() {
            return new NativeWrapper();
        }

        IPower createIPower() {
            return IPower.Stub.asInterface(ServiceManager.waitForDeclaredService(IPower.DESCRIPTOR + "/default"));
        }
    }

    final class MyUidObserver extends UidObserver {
        private final SparseIntArray mProcStatesCache;
        final /* synthetic */ HintManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$8-3q2FSoHxKJS5M75tlJXQ5W92M, reason: not valid java name */
        public static /* synthetic */ void m7688$r8$lambda$83q2FSoHxKJS5M75tlJXQ5W92M(MyUidObserver r0, int r1) {
            r0.lambda$onUidGone$0(r1);
        }

        public static /* synthetic */ void $r8$lambda$G5ujTcrPvq25wCnbVcETC3ZVxqA(MyUidObserver r0, int r1, int r2) {
            r0.lambda$onUidStateChanged$1(r1, r2);
        }

        MyUidObserver(HintManagerService this$0) {
            this.this$0 = this$0;
            this.mProcStatesCache = new SparseIntArray();
        }

        public boolean isUidForeground(int uid) {
            Object r0 = HintManagerService.m7658$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mProcStatesCache.get(uid, 6) > 6) goto L7;
            boolean r1 = true;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = false;
            goto L8
        }

        public void onUidGone(final int uid, boolean disabled) {
            FgThread.getHandler().post(new HintManagerService$MyUidObserver$$ExternalSyntheticLambda1(this, uid));
        }

        private /* synthetic */ void lambda$onUidGone$0(int uid) {
            Object r0 = HintManagerService.m7658$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.mProcStatesCache.delete(uid);     // Catch: Throwable -> L8
            ArrayMap<IBinder, ArraySet<AppHintSession>> tokenMap = (ArrayMap) HintManagerService.m7639$$Nest$fgetmActiveSessions(this.this$0).get(Integer.valueOf(uid));     // Catch: Throwable -> L8
            if (tokenMap != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            Slog.d(HintManagerService.TAG, "Uid gone for " + uid);     // Catch: Throwable -> L8
            int i = tokenMap.size() + (-1);     // Catch: Throwable -> L8
        L11:
            if (i < 0) goto L29;
            ArraySet<AppHintSession> sessionSet = tokenMap.valueAt(i);     // Catch: Throwable -> L8
            IntArray closedSessionsForSf = new IntArray();     // Catch: Throwable -> L8
            int j = sessionSet.size() - 1;     // Catch: Throwable -> L8
        L13:
            if (j < 0) goto L19;
            AppHintSession session = sessionSet.valueAt(j);     // Catch: Throwable -> L8
            if (session.isTrackedBySf() == false) goto L17;
            session.setTrackedBySf(false);     // Catch: Throwable -> L8
            closedSessionsForSf.add(session.getSessionId().intValue());     // Catch: Throwable -> L8
        L17:
            j = j - 1;     // Catch: Throwable -> L8
            goto L13
        L19:
            if (HintManagerService.m7666$$Nest$fgetmSessionManager(this.this$0) != null) goto L62;
        L24:
            int j2 = sessionSet.size() - 1;     // Catch: Throwable -> L8
        L25:
            if (j2 < 0) goto L27;
            sessionSet.valueAt(j2).close();     // Catch: Throwable -> L8
            j2 = j2 - 1;     // Catch: Throwable -> L8
            goto L25
        L27:
            i = i - 1;     // Catch: Throwable -> L8
            goto L11
        L62:
            HintManagerService.m7666$$Nest$fgetmSessionManager(this.this$0).trackedSessionsDied(closedSessionsForSf.toArray());     // Catch: Throwable -> L8 RemoteException -> L22
        L23:
            Slog.e(HintManagerService.TAG, "Failed to communicate with SessionManager");     // Catch: Throwable -> L8
            goto L24
        L29:
            monitor-exit(r0);     // Catch: Throwable -> L8
            Object r1 = HintManagerService.m7641$$Nest$fgetmChannelMapLock(this.this$0);
            monitor-enter(r1);
            TreeMap<Integer, ChannelItem> uidMap = (TreeMap) HintManagerService.m7640$$Nest$fgetmChannelMap(this.this$0).get(Integer.valueOf(uid));     // Catch: Throwable -> L38
            if (uidMap == null) goto L41;
            Iterator<Map.Entry<Integer, ChannelItem>> r2 = uidMap.entrySet().iterator();     // Catch: Throwable -> L38
        L36:
            if (r2.hasNext() == false) goto L40;
            Map.Entry<Integer, ChannelItem> entry = r2.next();     // Catch: Throwable -> L38
            entry.getValue().closeChannel();     // Catch: Throwable -> L38
            goto L36
        L40:
            HintManagerService.m7640$$Nest$fgetmChannelMap(this.this$0).remove(Integer.valueOf(uid));     // Catch: Throwable -> L38
        L41:
            monitor-exit(r1);     // Catch: Throwable -> L38
            Object r3 = HintManagerService.m7649$$Nest$fgetmCpuHeadroomLock(this.this$0);
            monitor-enter(r3);
        L49:
            th = move-exception;
            throw th;
        L45:
            if (HintManagerService.m7669$$Nest$fgetmSupportInfo(this.this$0).headroom.isCpuSupported == true) goto L47;
        L51:
            monitor-exit(r3);     // Catch: Throwable -> L49
            return;
        L47:
            if (HintManagerService.m7672$$Nest$fgetmUidToLastUserModeJiffies(this.this$0) == null) goto L51;
            HintManagerService.m7672$$Nest$fgetmUidToLastUserModeJiffies(this.this$0).remove(Integer.valueOf(uid));     // Catch: Throwable -> L49
        L38:
            th = move-exception;
            throw th;
        L8:
            th = move-exception;
            throw th;
        }

        public void onUidStateChanged(final int uid, final int procState, long procStateSeq, int capability) {
            FgThread.getHandler().post(new HintManagerService$MyUidObserver$$ExternalSyntheticLambda0(this, uid, procState));
        }

        private /* synthetic */ void lambda$onUidStateChanged$1(int uid, int procState) {
            Object r0 = HintManagerService.m7658$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean shouldCleanup = false;
        L13:
            th = move-exception;
            throw th;
        L6:
            if (HintManagerService.m7664$$Nest$fgetmPowerHalVersion(this.this$0) < 4) goto L15;
            int prevProcState = this.mProcStatesCache.get(uid, Integer.MAX_VALUE);     // Catch: Throwable -> L13
            if (prevProcState > 6) goto L11;
            if (procState <= 6) goto L11;
            boolean r3 = true;
        L12:
            shouldCleanup = r3;
        L11:
            r3 = false;
        L15:
            this.mProcStatesCache.put(uid, procState);     // Catch: Throwable -> L13
            ArrayMap<IBinder, ArraySet<AppHintSession>> tokenMap = (ArrayMap) HintManagerService.m7639$$Nest$fgetmActiveSessions(this.this$0).get(Integer.valueOf(uid));     // Catch: Throwable -> L13
            if (tokenMap != null) goto L20;
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L20:
            if (shouldCleanup == false) goto L22;
            Message msg = HintManagerService.m7645$$Nest$fgetmCleanUpHandler(this.this$0).obtainMessage(3, Integer.valueOf(uid));     // Catch: Throwable -> L13
            HintManagerService.m7645$$Nest$fgetmCleanUpHandler(this.this$0).sendMessageDelayed(msg, 1000);     // Catch: Throwable -> L13
            Slog.d(HintManagerService.TAG, "Sent cleanup message for uid " + uid);     // Catch: Throwable -> L13
        L22:
            boolean shouldAllowUpdate = isUidForeground(uid);     // Catch: Throwable -> L13
            int i = tokenMap.size() - 1;     // Catch: Throwable -> L13
        L23:
            if (i < 0) goto L29;
            ArraySet<AppHintSession> sessionSet = tokenMap.valueAt(i);     // Catch: Throwable -> L13
            int j = sessionSet.size() - 1;     // Catch: Throwable -> L13
        L25:
            if (j < 0) goto L27;
            sessionSet.valueAt(j).updateHintAllowedByProcState(shouldAllowUpdate);     // Catch: Throwable -> L13
            j = j - 1;     // Catch: Throwable -> L13
            goto L25
        L27:
            i = i - 1;     // Catch: Throwable -> L13
            goto L23
        L29:
            monitor-exit(r0);     // Catch: Throwable -> L13
        }
    }

    public static class NativeWrapper {
        private static native void nativeCloseHintSession(long r0);

        private static native long nativeCreateHintSession(int r0, int r1, int[] r2, long r3);

        private static native long nativeCreateHintSessionWithConfig(int r0, int r1, int[] r2, long r3, int r5, SessionConfig r6);

        private static native long nativeGetHintSessionPreferredRate();

        private native void nativeInit();

        private static native void nativePauseHintSession(long r0);

        private static native void nativeReportActualWorkDuration(long r0, long[] r2, long[] r3);

        private static native void nativeReportActualWorkDuration(long r0, WorkDuration[] r2);

        private static native void nativeResumeHintSession(long r0);

        private static native void nativeSendHint(long r0, int r2);

        private static native void nativeSetMode(long r0, int r2, boolean r3);

        private static native void nativeSetThreads(long r0, int[] r2);

        private static native void nativeUpdateTargetWorkDuration(long r0, long r2);

        public NativeWrapper() {
        }

        public void halInit() {
            nativeInit();
        }

        public long halGetHintSessionPreferredRate() {
            return nativeGetHintSessionPreferredRate();
        }

        public long halCreateHintSession(int tgid, int uid, int[] tids, long durationNanos) {
            return nativeCreateHintSession(tgid, uid, tids, durationNanos);
        }

        public long halCreateHintSessionWithConfig(int tgid, int uid, int[] tids, long durationNanos, int tag, SessionConfig config) {
            return nativeCreateHintSessionWithConfig(tgid, uid, tids, durationNanos, tag, config);
        }

        public void halPauseHintSession(long halPtr) {
            nativePauseHintSession(halPtr);
        }

        public void halResumeHintSession(long halPtr) {
            nativeResumeHintSession(halPtr);
        }

        public void halCloseHintSession(long halPtr) {
            nativeCloseHintSession(halPtr);
        }

        public void halUpdateTargetWorkDuration(long halPtr, long targetDurationNanos) {
            nativeUpdateTargetWorkDuration(halPtr, targetDurationNanos);
        }

        public void halReportActualWorkDuration(long halPtr, long[] actualDurationNanos, long[] timeStampNanos) {
            nativeReportActualWorkDuration(halPtr, actualDurationNanos, timeStampNanos);
        }

        public void halSendHint(long halPtr, int hint) {
            nativeSendHint(halPtr, hint);
        }

        public void halSetThreads(long halPtr, int[] tids) {
            nativeSetThreads(halPtr, tids);
        }

        public void halSetMode(long halPtr, int mode, boolean enabled) {
            nativeSetMode(halPtr, mode, enabled);
        }

        public void halReportActualWorkDuration(long halPtr, WorkDuration[] workDurations) {
            nativeReportActualWorkDuration(halPtr, workDurations);
        }
    }

    private static class ThreadUsageTracker {
        boolean mIsGraphicsPipeline;
        int mTid;

        ThreadUsageTracker(int tid) {
            this.mTid = tid;
            this.mIsGraphicsPipeline = false;
        }

        ThreadUsageTracker(int tid, boolean isGraphicsPipeline) {
            this.mTid = tid;
            this.mIsGraphicsPipeline = isGraphicsPipeline;
        }

        public int getTid() {
            return this.mTid;
        }

        public boolean isGraphicsPipeline() {
            return this.mIsGraphicsPipeline;
        }

        public void setGraphicsPipeline(boolean isGraphicsPipeline) {
            this.mIsGraphicsPipeline = isGraphicsPipeline;
        }
    }

    public static /* synthetic */ int $r8$lambda$ekPydgvI2SqQJb7XQ9M2EthMnAQ(HintManagerService r0, int r1, List r2) {
        return r0.onPullAtom(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveSessions, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m7639$$Nest$fgetmActiveSessions(HintManagerService r0) {
        return r0.mActiveSessions;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmChannelMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m7640$$Nest$fgetmChannelMap(HintManagerService r0) {
        return r0.mChannelMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmChannelMapLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7641$$Nest$fgetmChannelMapLock(HintManagerService r0) {
        return r0.mChannelMapLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCheckHeadroomAffinity, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7642$$Nest$fgetmCheckHeadroomAffinity(HintManagerService r0) {
        return r0.mCheckHeadroomAffinity;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCheckHeadroomProcStatMinMillis, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7643$$Nest$fgetmCheckHeadroomProcStatMinMillis(HintManagerService r0) {
        return r0.mCheckHeadroomProcStatMinMillis;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCheckHeadroomTid, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7644$$Nest$fgetmCheckHeadroomTid(HintManagerService r0) {
        return r0.mCheckHeadroomTid;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCleanUpHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ CleanUpHandler m7645$$Nest$fgetmCleanUpHandler(HintManagerService r0) {
        return r0.mCleanUpHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConfigCreationSupport, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m7646$$Nest$fgetmConfigCreationSupport(HintManagerService r0) {
        return r0.mConfigCreationSupport;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7647$$Nest$fgetmContext(HintManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCpuHeadroomCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ HeadroomCache m7648$$Nest$fgetmCpuHeadroomCache(HintManagerService r0) {
        return r0.mCpuHeadroomCache;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCpuHeadroomLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7649$$Nest$fgetmCpuHeadroomLock(HintManagerService r0) {
        return r0.mCpuHeadroomLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCpuHeadroomMaxTidCnt, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7650$$Nest$fgetmCpuHeadroomMaxTidCnt(HintManagerService r0) {
        return r0.mCpuHeadroomMaxTidCnt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDefaultGpuHeadroomCalculationWindowMillis, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7651$$Nest$fgetmDefaultGpuHeadroomCalculationWindowMillis(HintManagerService r0) {
        return r0.mDefaultGpuHeadroomCalculationWindowMillis;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEnforceCpuHeadroomUserModeCpuTimeCheck, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7652$$Nest$fgetmEnforceCpuHeadroomUserModeCpuTimeCheck(HintManagerService r0) {
        return r0.mEnforceCpuHeadroomUserModeCpuTimeCheck;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFMQUsesIntegratedEventFlag, reason: not valid java name */
    static /* bridge */ /* synthetic */ Boolean m7653$$Nest$fgetmFMQUsesIntegratedEventFlag(HintManagerService r0) {
        return r0.mFMQUsesIntegratedEventFlag;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGpuHeadroomCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ HeadroomCache m7654$$Nest$fgetmGpuHeadroomCache(HintManagerService r0) {
        return r0.mGpuHeadroomCache;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGpuHeadroomLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7655$$Nest$fgetmGpuHeadroomLock(HintManagerService r0) {
        return r0.mGpuHeadroomLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastCpuUserModeJiffies, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m7656$$Nest$fgetmLastCpuUserModeJiffies(HintManagerService r2) {
        return r2.mLastCpuUserModeJiffies;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastCpuUserModeTimeCheckedMillis, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m7657$$Nest$fgetmLastCpuUserModeTimeCheckedMillis(HintManagerService r2) {
        return r2.mLastCpuUserModeTimeCheckedMillis;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7658$$Nest$fgetmLock(HintManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNativeWrapper, reason: not valid java name */
    static /* bridge */ /* synthetic */ NativeWrapper m7659$$Nest$fgetmNativeWrapper(HintManagerService r0) {
        return r0.mNativeWrapper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNonIsolatedTids, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m7660$$Nest$fgetmNonIsolatedTids(HintManagerService r0) {
        return r0.mNonIsolatedTids;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNonIsolatedTidsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7661$$Nest$fgetmNonIsolatedTidsLock(HintManagerService r0) {
        return r0.mNonIsolatedTidsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManager m7662$$Nest$fgetmPackageManager(HintManagerService r0) {
        return r0.mPackageManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerHal, reason: not valid java name */
    static /* bridge */ /* synthetic */ IPower m7663$$Nest$fgetmPowerHal(HintManagerService r0) {
        return r0.mPowerHal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerHalVersion, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7664$$Nest$fgetmPowerHalVersion(HintManagerService r0) {
        return r0.mPowerHalVersion;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProcStatFilePathOverride, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7665$$Nest$fgetmProcStatFilePathOverride(HintManagerService r0) {
        return r0.mProcStatFilePathOverride;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ISessionManager m7666$$Nest$fgetmSessionManager(HintManagerService r0) {
        return r0.mSessionManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionSnapshotMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m7667$$Nest$fgetmSessionSnapshotMap(HintManagerService r0) {
        return r0.mSessionSnapshotMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionSnapshotMapLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7668$$Nest$fgetmSessionSnapshotMapLock(HintManagerService r0) {
        return r0.mSessionSnapshotMapLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSupportInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ SupportInfo m7669$$Nest$fgetmSupportInfo(HintManagerService r0) {
        return r0.mSupportInfo;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmThreadsUsageMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m7670$$Nest$fgetmThreadsUsageMap(HintManagerService r0) {
        return r0.mThreadsUsageMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmThreadsUsageObject, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7671$$Nest$fgetmThreadsUsageObject(HintManagerService r0) {
        return r0.mThreadsUsageObject;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUidToLastUserModeJiffies, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m7672$$Nest$fgetmUidToLastUserModeJiffies(HintManagerService r0) {
        return r0.mUidToLastUserModeJiffies;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUsesFmq, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7673$$Nest$fgetmUsesFmq(HintManagerService r0) {
        return r0.mUsesFmq;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFMQUsesIntegratedEventFlag, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7674$$Nest$fputmFMQUsesIntegratedEventFlag(HintManagerService r0, Boolean r1) {
        r0.mFMQUsesIntegratedEventFlag = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastCpuUserModeJiffies, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7675$$Nest$fputmLastCpuUserModeJiffies(HintManagerService r0, long r1) {
        r0.mLastCpuUserModeJiffies = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastCpuUserModeTimeCheckedMillis, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7676$$Nest$fputmLastCpuUserModeTimeCheckedMillis(HintManagerService r0, long r1) {
        r0.mLastCpuUserModeTimeCheckedMillis = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSessionManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7677$$Nest$fputmSessionManager(HintManagerService r0, ISessionManager r1) {
        r0.mSessionManager = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUsesFmq, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7678$$Nest$fputmUsesFmq(HintManagerService r0, boolean r1) {
        r0.mUsesFmq = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckTidValid, reason: not valid java name */
    static /* bridge */ /* synthetic */ Integer m7679$$Nest$mcheckTidValid(HintManagerService r0, int r1, int r2, int[] r3, IntArray r4) {
        return r0.checkTidValid(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mcontains, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7680$$Nest$mcontains(HintManagerService r0, int[] r1, int r2) {
        return r0.contains(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mformatTidCheckErrMsg, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7681$$Nest$mformatTidCheckErrMsg(HintManagerService r0, int r1, int[] r2, Integer r3) {
        return r0.formatTidCheckErrMsg(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$misHintSessionSupported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7682$$Nest$misHintSessionSupported(HintManagerService r0) {
        return r0.isHintSessionSupported();
    }

    /* JADX INFO: renamed from: -$$Nest$mtooManyPipelineThreads, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7683$$Nest$mtooManyPipelineThreads(HintManagerService r0, int r1) {
        return r0.tooManyPipelineThreads(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPROC_STAT_CPU_TIME_TOTAL_PATTERN, reason: not valid java name */
    static /* bridge */ /* synthetic */ Pattern m7684$$Nest$sfgetPROC_STAT_CPU_TIME_TOTAL_PATTERN() {
        return PROC_STAT_CPU_TIME_TOTAL_PATTERN;
    }

    static {
        PROC_STAT_CPU_TIME_TOTAL_PATTERN = Pattern.compile("cpu\\s+(?<user>[0-9]+)\\s(?<nice>[0-9]+).+");
    }

    public HintManagerService(Context context) {
        this(context, new Injector());
    }

    HintManagerService(Context context, Injector injector) {
        super(context);
        this.mLock = new Object();
        this.mChannelMapLock = new Object();
        this.mSessionSnapshotMapLock = new Object();
        this.mThreadsUsageObject = new Object();
        this.mNonIsolatedTidsLock = new Object();
        this.mConfigCreationSupport = new AtomicBoolean(true);
        this.mSupportInfo = null;
        this.mFMQUsesIntegratedEventFlag = false;
        this.mCpuHeadroomLock = new Object();
        this.mLastCpuUserModeTimeCheckedMillis = 0;
        this.mLastCpuUserModeJiffies = 0;
        this.mProcStatFilePathOverride = null;
        this.mEnforceCpuHeadroomUserModeCpuTimeCheck = false;
        this.mGpuHeadroomLock = new Object();
        this.mService = new BinderService(this);
        this.mContext = context;
        this.mCleanUpHandler = new CleanUpHandler(this, createCleanUpThread().getLooper());
        this.mNonIsolatedTids = new HashMap();
        this.mPackageManager = this.mContext.getPackageManager();
        this.mActiveSessions = new ArrayMap();
        this.mChannelMap = new ArrayMap();
        this.mSessionSnapshotMap = new ArrayMap();
        this.mThreadsUsageMap = new ArrayMap();
        this.mNativeWrapper = injector.createNativeWrapper();
        this.mNativeWrapper.halInit();
        this.mHintSessionPreferredRate = this.mNativeWrapper.halGetHintSessionPreferredRate();
        this.mUidObserver = new MyUidObserver(this);
        ActivityManagerInternal r3 = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        r3.getClass();
        this.mAmInternal = r3;
        this.mPowerHal = injector.createIPower();
        this.mPowerHalVersion = 0;
        this.mUsesFmq = false;
        if (this.mPowerHal != null) goto L18;
    L9:
        this.mDefaultCpuHeadroomCalculationWindowMillis = new CpuHeadroomParamsInternal().calculationWindowMillis;
        this.mDefaultGpuHeadroomCalculationWindowMillis = new GpuHeadroomParamsInternal().calculationWindowMillis;
        if (this.mSupportInfo.headroom.isCpuSupported == false) goto L12;
        this.mCpuHeadroomCache = new HeadroomCache(2, this.mSupportInfo.headroom.cpuMinIntervalMillis);
        this.mUidToLastUserModeJiffies = new ArrayMap();
        long jiffyHz = Os.sysconf(OsConstants._SC_CLK_TCK);
        this.mJiffyMillis = 1000.0f / jiffyHz;
        this.mCheckHeadroomTid = SystemProperties.getBoolean(PROPERTY_CHECK_HEADROOM_TID, true);
        this.mCheckHeadroomAffinity = SystemProperties.getBoolean(PROPERTY_CHECK_HEADROOM_AFFINITY, true);
        this.mCheckHeadroomProcStatMinMillis = SystemProperties.getInt(PROPERTY_CHECK_HEADROOM_PROC_STAT_MIN_MILLIS, 50);
        this.mCpuHeadroomMaxTidCnt = Math.min(SystemProperties.getInt(PROPERTY_CPU_HEADROOM_TID_MAX_CNT, 5), this.mSupportInfo.headroom.cpuMaxTidCount);
    L14:
        if (this.mSupportInfo.headroom.isGpuSupported == false) goto L16;
        this.mGpuHeadroomCache = new HeadroomCache(2, this.mSupportInfo.headroom.gpuMinIntervalMillis);
        return;
    L16:
        this.mGpuHeadroomCache = null;
        return;
    L12:
        this.mCpuHeadroomCache = null;
        this.mUidToLastUserModeJiffies = null;
        this.mJiffyMillis = 0.0f;
        this.mCheckHeadroomTid = true;
        this.mCheckHeadroomAffinity = true;
        this.mCheckHeadroomProcStatMinMillis = 0;
        this.mCpuHeadroomMaxTidCnt = 0;
        goto L14
    L18:
        this.mSupportInfo = getSupportInfo();     // Catch: RemoteException -> L6
    L6:
        e = move-exception;
        throw new IllegalStateException("Could not contact PowerHAL!", e);
    }

    SupportInfo getSupportInfo() throws RemoteException {
        this.mPowerHalVersion = this.mPowerHal.getInterfaceVersion();     // Catch: RemoteException -> L6
        if (this.mPowerHalVersion < 6) goto L8;
        return this.mPowerHal.getSupportInfo();
    L8:
        SupportInfo supportInfo = new SupportInfo();
        supportInfo.usesSessions = isHintSessionSupported();
        supportInfo.boosts = 0;
        supportInfo.modes = 0;
        supportInfo.sessionHints = 0;
        supportInfo.sessionModes = 0;
        supportInfo.sessionTags = 0;
        supportInfo.headroom = new SupportInfo.HeadroomSupportInfo();
        supportInfo.headroom.isCpuSupported = false;
        supportInfo.headroom.isGpuSupported = false;
        supportInfo.compositionData = new SupportInfo.CompositionDataSupportInfo();
        if (isHintSessionSupported() == true) goto L11;
    L16:
        return supportInfo;
    L11:
        if (this.mPowerHalVersion != 4) goto L14;
        supportInfo.sessionHints = 31;
    L14:
        if (this.mPowerHalVersion != 5) goto L16;
        supportInfo.sessionHints = 255;
        supportInfo.sessionModes = 1;
        supportInfo.sessionTags = 31;
    L6:
        e = move-exception;
        throw new IllegalStateException("Could not contact PowerHAL!", e);
    }

    void setProcStatPathOverride(String override) {
        this.mProcStatFilePathOverride = override;
        this.mEnforceCpuHeadroomUserModeCpuTimeCheck = true;
    }

    private boolean tooManyPipelineThreads(int uid) {
        Object r0 = this.mThreadsUsageObject;
        monitor-enter(r0);
        ArraySet<ThreadUsageTracker> threadsSet = this.mThreadsUsageMap.get(Integer.valueOf(uid));     // Catch: Throwable -> L13
        int graphicsPipelineThreadCount = 0;
        if (threadsSet == null) goto L20;
        Iterator<ThreadUsageTracker> r3 = threadsSet.iterator();     // Catch: Throwable -> L13
    L8:
        if (r3.hasNext() == false) goto L16;
        ThreadUsageTracker t = r3.next();     // Catch: Throwable -> L13
        if (t.isGraphicsPipeline() == false) goto L8;
        graphicsPipelineThreadCount = graphicsPipelineThreadCount + 1;     // Catch: Throwable -> L13
        goto L8
    L16:
        if (graphicsPipelineThreadCount <= 5) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return false;
    L13:
        th = move-exception;
        throw th;
    }

    private ServiceThread createCleanUpThread() {
        ServiceThread handlerThread = new ServiceThread(TAG, 19, true);
        handlerThread.start();
        return handlerThread;
    }

    private boolean isHintSessionSupported() {
        if (this.mHintSessionPreferredRate == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("performance_hint", this.mService);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L6;
        systemReady();
    L6:
        if (phase != 1000) goto L9;
        registerStatsCallbacks();
        return;
    }

    private void systemReady() {
        Slogf.v(TAG, "Initializing HintManager service...");
        ActivityManager.getService().registerUidObserver(this.mUidObserver, 3, -1, null);     // Catch: RemoteException -> L5
        return;
    }

    private void registerStatsCallbacks() {
        StatsManager statsManager = (StatsManager) this.mContext.getSystemService(StatsManager.class);
        statsManager.setPullAtomCallback(FrameworkStatsLog.ADPF_SYSTEM_COMPONENT_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, new HintManagerService$$ExternalSyntheticLambda0(this));
        statsManager.setPullAtomCallback(FrameworkStatsLog.ADPF_SESSION_SNAPSHOT, null, ConcurrentUtils.DIRECT_EXECUTOR, new HintManagerService$$ExternalSyntheticLambda0(this));
    }

    private int onPullAtom(int atomTag, List<StatsEvent> data) {
        if (atomTag != 10173) goto L6;
        boolean isSurfaceFlingerUsingCpuHint = SystemProperties.getBoolean(PROPERTY_SF_ENABLE_CPU_HINT, false);
        boolean isHwuiHintManagerEnabled = SystemProperties.getBoolean(PROPERTY_HWUI_ENABLE_HINT_MANAGER, false);
        data.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.ADPF_SYSTEM_COMPONENT_INFO, isSurfaceFlingerUsingCpuHint, isHwuiHintManagerEnabled, getFmqUsage()));
    L6:
        if (atomTag != 10218) goto L24;
        Object r1 = this.mSessionSnapshotMapLock;
        monitor-enter(r1);
        int i = 0;
    L25:
    L16:
        th = move-exception;
        throw th;
    L11:
        if (i >= this.mSessionSnapshotMap.size()) goto L20;
        int uid = this.mSessionSnapshotMap.keyAt(i).intValue();     // Catch: Throwable -> L16
        ArrayMap<Integer, AppHintSessionSnapshot> sessionSnapshots = this.mSessionSnapshotMap.valueAt(i);     // Catch: Throwable -> L16
        int j = 0;
    L14:
        if (j >= sessionSnapshots.size()) goto L18;
        int sessionTag = sessionSnapshots.keyAt(j).intValue();     // Catch: Throwable -> L16
        AppHintSessionSnapshot sessionSnapshot = sessionSnapshots.valueAt(j);     // Catch: Throwable -> L16
        data.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.ADPF_SESSION_SNAPSHOT, uid, sessionTag, sessionSnapshot.getMaxConcurrentSession(), sessionSnapshot.getMaxThreadCount(), sessionSnapshot.getPowerEfficientSessionCount(), sessionSnapshot.targetDurationNsList()));     // Catch: Throwable -> L16
        j = j + 1;     // Catch: Throwable -> L16
        goto L14
    L18:
        i = i + 1;     // Catch: Throwable -> L16
        goto L25
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L16
        restoreSessionSnapshot();
    L24:
        return 0;
    }

    private int getFmqUsage() {
        if (this.mUsesFmq == false) goto L7;
        return 1;
    L7:
        if (this.mPowerHalVersion >= 5) goto L10;
        return 3;
    L10:
        return 2;
    }

    private void restoreSessionSnapshot() {
        Object r2 = this.mSessionSnapshotMapLock;
        monitor-enter(r2);
        this.mSessionSnapshotMap.clear();     // Catch: Throwable -> L31
        Object r3 = this.mLock;     // Catch: Throwable -> L31
        monitor-enter(r3);     // Catch: Throwable -> L31
        int i = 0;
    L37:
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L8:
        if (i >= this.mActiveSessions.size()) goto L28;
        ArrayMap<IBinder, ArraySet<AppHintSession>> tokenMap = this.mActiveSessions.valueAt(i);     // Catch: Throwable -> L18
        int j = 0;
    L11:
        if (j >= tokenMap.size()) goto L26;
        ArraySet<AppHintSession> sessionSet = tokenMap.valueAt(j);     // Catch: Throwable -> L18
        int k = 0;
    L14:
        if (k >= sessionSet.size()) goto L25;
        AppHintSession appHintSession = sessionSet.valueAt(k);     // Catch: Throwable -> L18
        int tag = appHintSession.getTag();     // Catch: Throwable -> L18
        int uid = appHintSession.getUid();     // Catch: Throwable -> L18
        long targetDuationNs = appHintSession.getTargetDurationNs();     // Catch: Throwable -> L18
        int threadCount = appHintSession.getThreadIds().length;     // Catch: Throwable -> L18
        ArrayMap<Integer, AppHintSessionSnapshot> snapshots = this.mSessionSnapshotMap.get(Integer.valueOf(uid));     // Catch: Throwable -> L18
        if (snapshots != null) goto L21;
        snapshots = new ArrayMap();     // Catch: Throwable -> L18
        this.mSessionSnapshotMap.put(Integer.valueOf(uid), snapshots);     // Catch: Throwable -> L18
    L21:
        AppHintSessionSnapshot snapshot = snapshots.get(Integer.valueOf(tag));     // Catch: Throwable -> L18
        if (snapshot != null) goto L24;
        snapshot = new AppHintSessionSnapshot(this);     // Catch: Throwable -> L18
        snapshots.put(Integer.valueOf(tag), snapshot);     // Catch: Throwable -> L18
    L24:
        snapshot.updateUponSessionCreation(threadCount, targetDuationNs);     // Catch: Throwable -> L18
        k = k + 1;     // Catch: Throwable -> L18
        i = i;
        goto L14
    L25:
        j = j + 1;     // Catch: Throwable -> L18
        goto L11
    L26:
        i = i + 1;     // Catch: Throwable -> L18
        goto L37
    L28:
        monitor-exit(r3);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        throw th;
    }

    public ChannelItem getOrCreateMappedChannelItem(int tgid, int uid, IBinder token) {
        Object r0 = this.mChannelMapLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mChannelMap.containsKey(Integer.valueOf(uid)) == true) goto L9;
        this.mChannelMap.put(Integer.valueOf(uid), new TreeMap());     // Catch: Throwable -> L7
    L9:
        TreeMap<Integer, ChannelItem> map = this.mChannelMap.get(Integer.valueOf(uid));     // Catch: Throwable -> L7
        if (map.containsKey(Integer.valueOf(tgid)) == true) goto L12;
        ChannelItem item = new ChannelItem(this, tgid, uid, token);     // Catch: Throwable -> L7
        item.openChannel();     // Catch: Throwable -> L7
        map.put(Integer.valueOf(tgid), item);     // Catch: Throwable -> L7
    L12:
        ChannelItem r2 = map.get(Integer.valueOf(tgid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    }

    public void removeChannelItem(Integer tgid, Integer uid) {
        Object r0 = this.mChannelMapLock;
        monitor-enter(r0);
        TreeMap<Integer, ChannelItem> map = this.mChannelMap.get(uid);     // Catch: Throwable -> L9
        if (map == null) goto L14;
        ChannelItem item = map.get(tgid);     // Catch: Throwable -> L9
        if (item == null) goto L12;
        item.closeChannel();     // Catch: Throwable -> L9
        map.remove(tgid);     // Catch: Throwable -> L9
    L12:
        if (map.isEmpty() == false) goto L14;
        this.mChannelMap.remove(uid);     // Catch: Throwable -> L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    IHintManager.Stub getBinderServiceInstance() {
        return this.mService;
    }

    Boolean hasChannel(int tgid, int uid) {
        Object r0 = this.mChannelMapLock;
        monitor-enter(r0);
        TreeMap<Integer, ChannelItem> uidMap = this.mChannelMap.get(Integer.valueOf(uid));     // Catch: Throwable -> L12
        boolean r2 = false;
        if (uidMap == null) goto L15;
        ChannelItem item = uidMap.get(Integer.valueOf(tgid));     // Catch: Throwable -> L12
        if (item == null) goto L9;
        r2 = true;
    L9:
        Boolean r3 = Boolean.valueOf(r2);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    private Integer checkTidValid(int uid, int tgid, int[] tids, IntArray nonIsolated) {
        List<Integer> isolatedPids = null;
        int i = 0;
    L4:
        if (i >= tids.length) goto L25;
        int tid = tids[i];
        String[] procStatusKeys = {"Uid:", "Tgid:"};
        long[] output = new long[procStatusKeys.length];
        Process.readProcLines("/proc/" + tid + "/status", procStatusKeys, output);
        int uidOfThreadId = (int) output[0];
        int pidOfThreadId = (int) output[1];
        if (nonIsolated == null) goto L9;
        if (pidOfThreadId != tgid) goto L9;
        nonIsolated.add(tid);
    L22:
        i = i + 1;
    L9:
        if (uidOfThreadId == uid) goto L22;
        if (isolatedPids != null) goto L21;
        if (UserHandle.getAppId(uid) == 1000) goto L15;
        isolatedPids = this.mAmInternal.getIsolatedProcesses(uid);
        if (isolatedPids != null) goto L21;
        return Integer.valueOf(tid);
    L15:
        return Integer.valueOf(tid);
    L21:
        if (isolatedPids.contains(Integer.valueOf(pidOfThreadId)) == true) goto L22;
        return Integer.valueOf(tid);
    L25:
        return null;
    }

    private String formatTidCheckErrMsg(int callingUid, int[] tids, Integer invalidTid) {
        return "Tid" + invalidTid + " from list " + Arrays.toString(tids) + " doesn't belong to the calling application " + callingUid;
    }

    private boolean contains(int[] array, int target) {
        int r0 = array.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        int element = array[r2];
        if (element == target) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
