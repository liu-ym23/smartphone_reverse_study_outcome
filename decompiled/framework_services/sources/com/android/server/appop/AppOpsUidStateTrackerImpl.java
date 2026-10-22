package com.android.server.appop;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppOpsManager;
import android.os.Handler;
import android.util.ArrayMap;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.util.TimeUtils;
import bytedanceos.os.BinderCallCacheAgent;
import com.android.internal.os.Clock;
import com.android.internal.util.function.pooled.PooledLambda;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class AppOpsUidStateTrackerImpl implements AppOpsUidStateTracker {
    private static final String LOG_TAG = null;
    private ActivityManagerInternal mActivityManagerInternal;
    private SparseBooleanArray mAppWidgetVisible;
    private SparseIntArray mCapability;
    private final Clock mClock;
    private AppOpsService.Constants mConstants;
    private final EventLog mEventLog;
    private final DelayableExecutor mExecutor;
    private SparseBooleanArray mPendingAppWidgetVisible;
    private SparseIntArray mPendingCapability;
    private SparseLongArray mPendingCommitTime;
    private SparseIntArray mPendingUidStates;
    private ArrayMap<AppOpsUidStateTracker.UidStateChangedCallback, Executor> mUidStateChangedCallbacks;
    private SparseIntArray mUidStates;

    /* JADX INFO: renamed from: com.android.server.appop.AppOpsUidStateTrackerImpl$1, reason: invalid class name */
    class AnonymousClass1 implements DelayableExecutor {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ Executor val$lockingExecutor;

        public static /* synthetic */ void $r8$lambda$BDK_o82z4D0CLSzizoWclTSuQPc(Executor r0, Runnable r1) {
            lambda$execute$0(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$Xv0rzRrxYVvZ3ael2cDamJtHe_M(Executor r0, Runnable r1) {
            lambda$executeDelayed$1(r0, r1);
        }

        AnonymousClass1(Handler r1, Executor r2) {
            this.val$handler = r1;
            this.val$lockingExecutor = r2;
        }

        private static /* synthetic */ void lambda$execute$0(Executor lockingExecutor, Runnable runnable) {
            lockingExecutor.execute(runnable);
        }

        @Override // com.android.server.appop.AppOpsUidStateTrackerImpl.DelayableExecutor, java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            Handler r0 = this.val$handler;
            final Executor r1 = this.val$lockingExecutor;
            r0.post(new AppOpsUidStateTrackerImpl$1$$ExternalSyntheticLambda1(r1, runnable));
        }

        private static /* synthetic */ void lambda$executeDelayed$1(Executor lockingExecutor, Runnable runnable) {
            lockingExecutor.execute(runnable);
        }

        @Override // com.android.server.appop.AppOpsUidStateTrackerImpl.DelayableExecutor
        public void executeDelayed(final Runnable runnable, long delay) {
            Handler r0 = this.val$handler;
            final Executor r1 = this.val$lockingExecutor;
            r0.postDelayed(new AppOpsUidStateTrackerImpl$1$$ExternalSyntheticLambda0(r1, runnable), delay);
        }
    }

    interface DelayableExecutor extends Executor {
        @Override // java.util.concurrent.Executor
        void execute(Runnable r1);

        void executeDelayed(Runnable r1, long r2);
    }

    private static class EventLog {
        private static final int APP_WIDGET_VISIBLE = 1;
        private static final int APP_WIDGET_VISIBLE_CHANGED = 2;
        private static final int COMMIT_UID_STATE_LOG_MAX_SIZE = 200;
        private static final int EVAL_FOREGROUND_MODE_MAX_SIZE = 200;
        private static final int UPDATE_UID_PROC_STATE_LOG_MAX_SIZE = 200;
        private int[][] mCommitUidStateLog;
        private int mCommitUidStateLogHead;
        private int mCommitUidStateLogSize;
        private long[] mCommitUidStateLogTimestamps;
        private int[][] mEvalForegroundModeLog;
        private int mEvalForegroundModeLogHead;
        private int mEvalForegroundModeLogSize;
        private long[] mEvalForegroundModeLogTimestamps;
        private final DelayableExecutor mExecutor;
        private final Thread mExecutorThread;
        private int[][] mUpdateUidProcStateLog;
        private int mUpdateUidProcStateLogHead;
        private int mUpdateUidProcStateLogSize;
        private long[] mUpdateUidProcStateLogTimestamps;

        EventLog(DelayableExecutor executor, Thread executorThread) {
            this.mUpdateUidProcStateLog = (int[][]) Array.newInstance(Integer.TYPE, new int[]{200, 3});
            this.mUpdateUidProcStateLogTimestamps = new long[200];
            this.mUpdateUidProcStateLogSize = 0;
            this.mUpdateUidProcStateLogHead = 0;
            this.mCommitUidStateLog = (int[][]) Array.newInstance(Integer.TYPE, new int[]{200, 4});
            this.mCommitUidStateLogTimestamps = new long[200];
            this.mCommitUidStateLogSize = 0;
            this.mCommitUidStateLogHead = 0;
            this.mEvalForegroundModeLog = (int[][]) Array.newInstance(Integer.TYPE, new int[]{200, 5});
            this.mEvalForegroundModeLogTimestamps = new long[200];
            this.mEvalForegroundModeLogSize = 0;
            this.mEvalForegroundModeLogHead = 0;
            this.mExecutor = executor;
            this.mExecutorThread = executorThread;
        }

        void logUpdateUidProcState(int uid, int procState, int capability) {
            this.mExecutor.execute(PooledLambda.obtainRunnable(new AppOpsUidStateTrackerImpl$EventLog$$ExternalSyntheticLambda2(), this, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(uid), Integer.valueOf(procState), Integer.valueOf(capability)));
        }

        void logUpdateUidProcStateAsync(long timestamp, int uid, int procState, int capability) {
            int idx = (this.mUpdateUidProcStateLogHead + this.mUpdateUidProcStateLogSize) % 200;
            if (this.mUpdateUidProcStateLogSize != 200) goto L5;
            this.mUpdateUidProcStateLogHead = (this.mUpdateUidProcStateLogHead + 1) % 200;
        L6:
            this.mUpdateUidProcStateLog[idx][0] = uid;
            this.mUpdateUidProcStateLog[idx][1] = procState;
            this.mUpdateUidProcStateLog[idx][2] = capability;
            this.mUpdateUidProcStateLogTimestamps[idx] = timestamp;
            return;
        L5:
            this.mUpdateUidProcStateLogSize++;
            goto L6
        }

        void logCommitUidState(int uid, int uidState, int capability, boolean appWidgetVisible, boolean appWidgetVisibleChanged) {
            this.mExecutor.execute(PooledLambda.obtainRunnable(new AppOpsUidStateTrackerImpl$EventLog$$ExternalSyntheticLambda0(), this, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(uid), Integer.valueOf(uidState), Integer.valueOf(capability), Boolean.valueOf(appWidgetVisible), Boolean.valueOf(appWidgetVisibleChanged)));
        }

        void logCommitUidStateAsync(long timestamp, int uid, int uidState, int capability, boolean appWidgetVisible, boolean appWidgetVisibleChanged) {
            int idx = (this.mCommitUidStateLogHead + this.mCommitUidStateLogSize) % 200;
            if (this.mCommitUidStateLogSize != 200) goto L5;
            this.mCommitUidStateLogHead = (this.mCommitUidStateLogHead + 1) % 200;
        L6:
            this.mCommitUidStateLog[idx][0] = uid;
            this.mCommitUidStateLog[idx][1] = uidState;
            this.mCommitUidStateLog[idx][2] = capability;
            this.mCommitUidStateLog[idx][3] = 0;
            if (appWidgetVisible == false) goto L9;
            int[] r1 = this.mCommitUidStateLog[idx];
            r1[3] = r1[3] + 1;
        L9:
            if (appWidgetVisibleChanged == false) goto L11;
            int[] r2 = this.mCommitUidStateLog[idx];
            r2[3] = r2[3] + 2;
        L11:
            this.mCommitUidStateLogTimestamps[idx] = timestamp;
            return;
        L5:
            this.mCommitUidStateLogSize++;
            goto L6
        }

        void logEvalForegroundMode(int uid, int uidState, int capability, int code, int result) {
            this.mExecutor.execute(PooledLambda.obtainRunnable(new AppOpsUidStateTrackerImpl$EventLog$$ExternalSyntheticLambda1(), this, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(uid), Integer.valueOf(uidState), Integer.valueOf(capability), Integer.valueOf(code), Integer.valueOf(result)));
        }

        void logEvalForegroundModeAsync(long timestamp, int uid, int uidState, int capability, int code, int result) {
            int idx = (this.mEvalForegroundModeLogHead + this.mEvalForegroundModeLogSize) % 200;
            if (this.mEvalForegroundModeLogSize != 200) goto L5;
            this.mEvalForegroundModeLogHead = (this.mEvalForegroundModeLogHead + 1) % 200;
        L6:
            this.mEvalForegroundModeLog[idx][0] = uid;
            this.mEvalForegroundModeLog[idx][1] = uidState;
            this.mEvalForegroundModeLog[idx][2] = capability;
            this.mEvalForegroundModeLog[idx][3] = code;
            this.mEvalForegroundModeLog[idx][4] = result;
            this.mEvalForegroundModeLogTimestamps[idx] = timestamp;
            return;
        L5:
            this.mEvalForegroundModeLogSize++;
            goto L6
        }

        void dumpEvents(PrintWriter pw) {
            int updateIdx = 0;
            int commitIdx = 0;
            int evalIdx = 0;
        L4:
            if (updateIdx >= this.mUpdateUidProcStateLogSize) goto L6;
        L11:
            int updatePtr = (this.mUpdateUidProcStateLogHead + updateIdx) % 200;
            int commitPtr = (this.mCommitUidStateLogHead + commitIdx) % 200;
            int evalPtr = (this.mEvalForegroundModeLogHead + evalIdx) % 200;
            long cTimestamp = Long.MAX_VALUE;
            if (updateIdx >= this.mUpdateUidProcStateLogSize) goto L14;
            long aTimestamp = this.mUpdateUidProcStateLogTimestamps[updatePtr];
        L16:
            if (commitIdx >= this.mCommitUidStateLogSize) goto L18;
            long bTimestamp = this.mCommitUidStateLogTimestamps[commitPtr];
        L20:
            if (evalIdx >= this.mEvalForegroundModeLogSize) goto L24;
            cTimestamp = this.mEvalForegroundModeLogTimestamps[evalPtr];
        L24:
            if (aTimestamp > bTimestamp) goto L29;
            if (aTimestamp > cTimestamp) goto L29;
            dumpUpdateUidProcState(pw, updatePtr);
            updateIdx = updateIdx + 1;
        L29:
            if (bTimestamp <= cTimestamp) goto L30;
            dumpEvalForegroundMode(pw, evalPtr);
            evalIdx = evalIdx + 1;
            goto L4
        L30:
            dumpCommitUidState(pw, commitPtr);
            commitIdx = commitIdx + 1;
            goto L4
        L18:
            bTimestamp = Long.MAX_VALUE;
            goto L20
        L14:
            aTimestamp = Long.MAX_VALUE;
            goto L16
        L6:
            if (commitIdx < this.mCommitUidStateLogSize) goto L11;
            if (evalIdx < this.mEvalForegroundModeLogSize) goto L11;
        }

        void dumpUpdateUidProcState(PrintWriter pw, int idx) {
            long timestamp = this.mUpdateUidProcStateLogTimestamps[idx];
            int uid = this.mUpdateUidProcStateLog[idx][0];
            int procState = this.mUpdateUidProcStateLog[idx][1];
            int capability = this.mUpdateUidProcStateLog[idx][2];
            TimeUtils.dumpTime(pw, timestamp);
            pw.print(" UPDATE_UID_PROC_STATE");
            pw.print(" uid=");
            pw.print(String.format("%-8d", new Object[]{Integer.valueOf(uid)}));
            pw.print(" procState=");
            pw.print(String.format("%-30s", new Object[]{ActivityManager.procStateToString(procState)}));
            pw.print(" capability=");
            pw.print(ActivityManager.getCapabilitiesSummary(capability) + " ");
            pw.println();
        }

        void dumpCommitUidState(PrintWriter pw, int idx) {
            long timestamp = this.mCommitUidStateLogTimestamps[idx];
            boolean appWidgetVisibleChanged = false;
            int uid = this.mCommitUidStateLog[idx][0];
            int uidState = this.mCommitUidStateLog[idx][1];
            int capability = this.mCommitUidStateLog[idx][2];
            if ((this.mCommitUidStateLog[idx][3] & 1) == 0) goto L5;
            boolean appWidgetVisible = true;
        L7:
            if ((2 & this.mCommitUidStateLog[idx][3]) == 0) goto L9;
            appWidgetVisibleChanged = true;
        L9:
            TimeUtils.dumpTime(pw, timestamp);
            pw.print(" COMMIT_UID_STATE     ");
            pw.print(" uid=");
            pw.print(String.format("%-8d", new Object[]{Integer.valueOf(uid)}));
            pw.print(" uidState=");
            pw.print(String.format("%-30s", new Object[]{AppOpsManager.uidStateToString(uidState)}));
            pw.print(" capability=");
            pw.print(ActivityManager.getCapabilitiesSummary(capability) + " ");
            pw.print(" appWidgetVisible=");
            pw.print(appWidgetVisible);
            if (appWidgetVisibleChanged == false) goto L12;
            pw.print(" (changed)");
        L12:
            pw.println();
            return;
        L5:
            appWidgetVisible = false;
            goto L7
        }

        void dumpEvalForegroundMode(PrintWriter pw, int idx) {
            long timestamp = this.mEvalForegroundModeLogTimestamps[idx];
            int uid = this.mEvalForegroundModeLog[idx][0];
            int uidState = this.mEvalForegroundModeLog[idx][1];
            int capability = this.mEvalForegroundModeLog[idx][2];
            int code = this.mEvalForegroundModeLog[idx][3];
            int result = this.mEvalForegroundModeLog[idx][4];
            TimeUtils.dumpTime(pw, timestamp);
            pw.print(" EVAL_FOREGROUND_MODE ");
            pw.print(" uid=");
            pw.print(String.format("%-8d", new Object[]{Integer.valueOf(uid)}));
            pw.print(" uidState=");
            pw.print(String.format("%-30s", new Object[]{AppOpsManager.uidStateToString(uidState)}));
            pw.print(" capability=");
            pw.print(ActivityManager.getCapabilitiesSummary(capability) + " ");
            pw.print(" code=");
            pw.print(String.format("%-20s", new Object[]{AppOpsManager.opToName(code)}));
            pw.print(" result=");
            pw.print(AppOpsManager.modeToName(result));
            pw.println();
        }
    }

    public static /* synthetic */ void $r8$lambda$DDarXSJMLhcQjOvjQGC1suxs48A(AppOpsUidStateTrackerImpl r0, int r1) {
        r0.updateUidPendingStateIfNeeded(r1);
    }

    static {
        LOG_TAG = AppOpsUidStateTrackerImpl.class.getSimpleName();
    }

    AppOpsUidStateTrackerImpl(ActivityManagerInternal activityManagerInternal, Handler handler, Executor lockingExecutor, Clock clock, AppOpsService.Constants constants) {
        this(activityManagerInternal, new AnonymousClass1(handler, lockingExecutor), clock, constants, handler.getLooper().getThread());
    }

    AppOpsUidStateTrackerImpl(ActivityManagerInternal activityManagerInternal, DelayableExecutor executor, Clock clock, AppOpsService.Constants constants, Thread executorThread) {
        this.mUidStates = new SparseIntArray();
        this.mPendingUidStates = new SparseIntArray();
        this.mCapability = new SparseIntArray();
        this.mPendingCapability = new SparseIntArray();
        this.mAppWidgetVisible = new SparseBooleanArray();
        this.mPendingAppWidgetVisible = new SparseBooleanArray();
        this.mPendingCommitTime = new SparseLongArray();
        this.mUidStateChangedCallbacks = new ArrayMap();
        this.mActivityManagerInternal = activityManagerInternal;
        this.mExecutor = executor;
        this.mClock = clock;
        this.mConstants = constants;
        this.mEventLog = new EventLog(executor, executorThread);
    }

    @Override // com.android.server.appop.AppOpsUidStateTracker
    public int getUidState(int uid) {
        return getUidStateLocked(uid);
    }

    private int getUidStateLocked(int uid) {
        updateUidPendingStateIfNeeded(uid);
        return this.mUidStates.get(uid, 700);
    }

    @Override // com.android.server.appop.AppOpsUidStateTracker
    public int evalMode(int uid, int code, int mode) {
        if (mode == 4) goto L5;
        return mode;
    L5:
        int uidState = getUidState(uid);
        int uidCapability = getUidCapability(uid);
        int result = evalModeInternal(uid, code, uidState, uidCapability);
        this.mEventLog.logEvalForegroundMode(uid, uidState, uidCapability, code, result);
        return result;
    }

    private int evalModeInternal(int uid, int code, int uidState, int uidCapability) {
        if (getUidAppWidgetVisible(uid) == false) goto L5;
    L19:
        return 0;
    L5:
        if (this.mActivityManagerInternal.isPendingTopUid(uid) == true) goto L19;
        if (this.mActivityManagerInternal.isTempAllowlistedForFgsWhileInUse(uid) == true) goto L19;
        int opCapability = getOpCapability(code);
        if (opCapability == 0) goto L16;
        if ((uidCapability & opCapability) != 0) goto L14;
        return 1;
    L14:
        return 0;
    L16:
        if (uidState <= AppOpsManager.resolveFirstUnrestrictedUidState(code)) goto L18;
        return 1;
    L18:
        return 0;
    }

    private int getOpCapability(int opCode) {
        switch(opCode) {
            case 0: goto L11;
            case 1: goto L11;
            case 26: goto L9;
            case 27: goto L7;
            case 41: goto L11;
            case 42: goto L11;
            case 121: goto L7;
            case 154: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 64;
    L7:
        return 4;
    L9:
        return 2;
    L11:
        return 1;
    }

    @Override // com.android.server.appop.AppOpsUidStateTracker
    public boolean isUidInForeground(int uid) {
        if (evalMode(uid, -1, 4) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.appop.AppOpsUidStateTracker
    public void addUidStateChangedCallback(Executor executor, AppOpsUidStateTracker.UidStateChangedCallback callback) {
        if (this.mUidStateChangedCallbacks.containsKey(callback) == true) goto L7;
        this.mUidStateChangedCallbacks.put(callback, executor);
        return;
    L7:
        throw new IllegalStateException("Callback is already registered.");
    }

    @Override // com.android.server.appop.AppOpsUidStateTracker
    public void removeUidStateChangedCallback(AppOpsUidStateTracker.UidStateChangedCallback callback) {
        if (this.mUidStateChangedCallbacks.containsKey(callback) == false) goto L7;
        this.mUidStateChangedCallbacks.remove(callback);
        return;
    L7:
        throw new IllegalStateException("Callback is not registered.");
    }

    @Override // com.android.server.appop.AppOpsUidStateTracker
    public void updateAppWidgetVisibility(SparseArray<String> uidPackageNames, boolean visible) {
        int numUids = uidPackageNames.size();
        int i = 0;
    L3:
        if (i >= numUids) goto L6;
        int uid = uidPackageNames.keyAt(i);
        this.mPendingAppWidgetVisible.put(uid, visible);
        commitUidPendingState(uid);
        i = i + 1;
        goto L3
    }

    @Override // com.android.server.appop.AppOpsUidStateTracker
    public void updateUidProcState(int uid, int procState, int capability) {
        int uidState = AppOpsUidStateTracker.processStateToUidState(procState);
        int prevUidState = this.mUidStates.get(uid, Integer.MAX_VALUE);
        boolean hasLostCapability = false;
        int prevCapability = this.mCapability.get(uid, 0);
        int pendingUidState = this.mPendingUidStates.get(uid, Integer.MAX_VALUE);
        int pendingCapability = this.mPendingCapability.get(uid, 0);
        long pendingStateCommitTime = this.mPendingCommitTime.get(uid, 0);
        if (pendingStateCommitTime != 0) goto L7;
        if (uidState != prevUidState) goto L12;
        if (capability == prevCapability) goto L7;
    L12:
        this.mEventLog.logUpdateUidProcState(uid, procState, capability);
        this.mPendingUidStates.put(uid, uidState);
        this.mPendingCapability.put(uid, capability);
        if (((~capability) & prevCapability) == 0) goto L15;
        hasLostCapability = true;
    L15:
        if (uidState != Integer.MAX_VALUE) goto L17;
        commitUidPendingState(uid);
        return;
    L17:
        if (uidState >= prevUidState) goto L19;
        commitUidPendingState(uid);
        return;
    L19:
        if (uidState != prevUidState) goto L23;
        if (hasLostCapability == true) goto L23;
        commitUidPendingState(uid);
        return;
    L23:
        if (uidState > 500) goto L27;
        if (hasLostCapability == true) goto L27;
        commitUidPendingState(uid);
        return;
    L27:
        if (pendingStateCommitTime != 0) goto L45;
        if (prevUidState > 200) goto L32;
        long settleTime = this.mConstants.TOP_STATE_SETTLE_TIME;
    L35:
        long commitTime = this.mClock.elapsedRealtime() + settleTime;
        this.mPendingCommitTime.put(uid, commitTime);
        this.mExecutor.executeDelayed(PooledLambda.obtainRunnable(new AppOpsUidStateTrackerImpl$$ExternalSyntheticLambda0(), this, Integer.valueOf(uid)), 1 + settleTime);
        BinderCallCacheAgent.removeCheckPackageBinderCache(uid);
        return;
    L32:
        if (prevUidState > 400) goto L34;
        settleTime = this.mConstants.FG_SERVICE_STATE_SETTLE_TIME;
        goto L35
    L34:
        settleTime = this.mConstants.BG_STATE_SETTLE_TIME;
        goto L35
    L45:
        return;
    L7:
        if (pendingStateCommitTime == 0) goto L38;
        if (uidState != pendingUidState) goto L12;
        if (capability != pendingCapability) goto L12;
        return;
    }

    @Override // com.android.server.appop.AppOpsUidStateTracker
    public void dumpUidState(PrintWriter pw, int uid, long nowElapsed) {
        int state = this.mUidStates.get(uid, 700);
        int pendingState = this.mPendingUidStates.get(uid, state);
        pw.print("    state=");
        pw.println(AppOpsManager.getUidStateName(state));
        if (state == pendingState) goto L5;
        pw.print("    pendingState=");
        pw.println(AppOpsManager.getUidStateName(pendingState));
    L5:
        int capability = this.mCapability.get(uid, 0);
        int pendingCapability = this.mPendingCapability.get(uid, capability);
        pw.print("    capability=");
        ActivityManager.printCapabilitiesFull(pw, capability);
        pw.println();
        if (capability == pendingCapability) goto L8;
        pw.print("    pendingCapability=");
        ActivityManager.printCapabilitiesFull(pw, pendingCapability);
        pw.println();
    L8:
        boolean appWidgetVisible = this.mAppWidgetVisible.get(uid, false);
        boolean pendingAppWidgetVisible = this.mPendingAppWidgetVisible.get(uid, appWidgetVisible);
        pw.print("    appWidgetVisible=");
        pw.println(appWidgetVisible);
        if (appWidgetVisible == pendingAppWidgetVisible) goto L11;
        pw.print("    pendingAppWidgetVisible=");
        pw.println(pendingAppWidgetVisible);
    L11:
        long pendingStateCommitTime = this.mPendingCommitTime.get(uid, 0);
        if (pendingStateCommitTime == 0) goto L15;
        pw.print("    pendingStateCommitTime=");
        TimeUtils.formatDuration(pendingStateCommitTime, nowElapsed, pw);
        pw.println();
        return;
    }

    @Override // com.android.server.appop.AppOpsUidStateTracker
    public void dumpEvents(PrintWriter pw) {
        this.mEventLog.dumpEvents(pw);
    }

    private void updateUidPendingStateIfNeeded(int uid) {
        updateUidPendingStateIfNeededLocked(uid);
    }

    private void updateUidPendingStateIfNeededLocked(int uid) {
        long pendingCommitTime = this.mPendingCommitTime.get(uid, 0);
        if (pendingCommitTime == 0) goto L9;
        long currentTime = this.mClock.elapsedRealtime();
        if (currentTime >= this.mPendingCommitTime.get(uid)) goto L7;
        return;
    L7:
        commitUidPendingState(uid);
        return;
    }

    private void commitUidPendingState(int uid) {
        int uidState = this.mUidStates.get(uid, Integer.MAX_VALUE);
        int capability = this.mCapability.get(uid, 0);
        boolean appWidgetVisible = this.mAppWidgetVisible.get(uid, false);
        int pendingUidState = this.mPendingUidStates.get(uid, uidState);
        int pendingCapability = this.mPendingCapability.get(uid, capability);
        boolean pendingAppWidgetVisible = this.mPendingAppWidgetVisible.get(uid, appWidgetVisible);
        int externalUidState = Math.min(uidState, 700);
        int externalPendingUidState = Math.min(pendingUidState, 700);
        boolean r6 = true;
        if (externalUidState > 500) goto L5;
        boolean r14 = true;
    L6:
        if (externalPendingUidState > 500) goto L8;
        boolean r13 = true;
    L9:
        if (r14 != r13) goto L14;
        if (capability != pendingCapability) goto L14;
        if (appWidgetVisible != pendingAppWidgetVisible) goto L14;
        boolean foregroundChange = false;
    L15:
        if (externalUidState != externalPendingUidState) goto L20;
        if (capability != pendingCapability) goto L20;
        if (appWidgetVisible != pendingAppWidgetVisible) goto L20;
    L33:
        if (pendingUidState != Integer.MAX_VALUE) goto L40;
        if (uidState == pendingUidState) goto L40;
        this.mUidStates.delete(uid);
        this.mCapability.delete(uid);
        this.mAppWidgetVisible.delete(uid);
        int i = 0;
    L37:
        if (i >= this.mUidStateChangedCallbacks.size()) goto L41;
        AppOpsUidStateTracker.UidStateChangedCallback cb = this.mUidStateChangedCallbacks.keyAt(i);
        Executor executor = this.mUidStateChangedCallbacks.valueAt(i);
        executor.execute(PooledLambda.obtainRunnable(new AppOpsUidStateTrackerImpl$$ExternalSyntheticLambda2(), cb, Integer.valueOf(uid)));
        i = i + 1;
    L41:
        this.mPendingUidStates.delete(uid);
        this.mPendingCapability.delete(uid);
        this.mPendingAppWidgetVisible.delete(uid);
        this.mPendingCommitTime.delete(uid);
        return;
    L40:
        this.mUidStates.put(uid, pendingUidState);
        this.mCapability.put(uid, pendingCapability);
        this.mAppWidgetVisible.put(uid, pendingAppWidgetVisible);
    L20:
        if (foregroundChange == false) goto L26;
        int externalPendingUidState2 = externalPendingUidState;
        EventLog r1 = this.mEventLog;
        if (appWidgetVisible != pendingAppWidgetVisible) goto L25;
        r6 = false;
    L25:
        r1.logCommitUidState(uid, externalPendingUidState2, pendingCapability, pendingAppWidgetVisible, r6);
    L27:
        int i2 = 0;
    L29:
        if (i2 >= this.mUidStateChangedCallbacks.size()) goto L33;
        AppOpsUidStateTracker.UidStateChangedCallback cb2 = this.mUidStateChangedCallbacks.keyAt(i2);
        Executor executor2 = this.mUidStateChangedCallbacks.valueAt(i2);
        executor2.execute(PooledLambda.obtainRunnable(new AppOpsUidStateTrackerImpl$$ExternalSyntheticLambda1(), cb2, Integer.valueOf(uid), Integer.valueOf(externalPendingUidState2), Boolean.valueOf(foregroundChange)));
        i2 = i2 + 1;
        externalPendingUidState2 = externalPendingUidState2;
        goto L29
    L26:
        externalPendingUidState2 = externalPendingUidState;
    L14:
        foregroundChange = true;
        goto L15
    L8:
        r13 = false;
        goto L9
    L5:
        r14 = false;
        goto L6
    }

    private int getUidCapability(int uid) {
        return this.mCapability.get(uid, 0);
    }

    private boolean getUidAppWidgetVisible(int uid) {
        return this.mAppWidgetVisible.get(uid, false);
    }
}
