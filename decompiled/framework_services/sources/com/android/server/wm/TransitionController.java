package com.android.server.wm;

import android.app.ActivityManager;
import android.app.IApplicationThread;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.IBinder;
import android.os.IRemoteCallback;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.pico.utils.ExtImplFactory;
import android.util.ArrayMap;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import android.window.ITransitionMetricsReporter;
import android.window.ITransitionPlayer;
import android.window.RemoteTransition;
import android.window.TransitionRequestInfo;
import android.window.WindowContainerTransaction;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.FgThread;
import com.android.server.ISmtResourceControl;
import com.android.server.SysOptBridge;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: loaded from: classes3.dex */
class TransitionController {
    private static final int CHANGE_TIMEOUT_MS = 2000;
    private static final int DEFAULT_TIMEOUT_MS = 5000;
    private static final int LEGACY_STATE_IDLE = 0;
    private static final int LEGACY_STATE_READY = 1;
    private static final int LEGACY_STATE_RUNNING = 2;
    private static final boolean SHELL_TRANSITIONS_ROTATION = false;
    static final int SYNC_METHOD = 0;
    private static final String TAG = "TransitionController";
    final ArrayList<WindowState> mAnimatingExitWindows;
    private boolean mAnimatingState;
    final ActivityTaskManagerService mAtm;
    boolean mBuildingFinishLayers;
    Transition mCollectingTransition;
    private IExtTransitionController mExt;
    Transition mFinishingTransition;
    private boolean mFullReadyTracking;
    boolean mIsWaitingForDisplayEnabled;
    final SparseArray<ArrayList<Task>> mLatestOnTopTasksReported;
    private final ArrayList<WindowManagerInternal.AppTransitionListener> mLegacyListeners;
    final Handler mLoggerHandler;
    boolean mNavigationBarAttachedToApp;
    final ArrayList<Transition> mPlayingTransitions;
    private final ArrayList<QueuedTransition> mQueuedTransitions;
    final RemotePlayer mRemotePlayer;
    final Lock mRunningLock;
    SnapshotController mSnapshotController;
    final ArrayList<Runnable> mStateValidators;
    BLASTSyncEngine mSyncEngine;
    int mTrackCount;
    final TransitionMetricsReporter mTransitionMetricsReporter;
    private final ArrayList<TransitionPlayerRecord> mTransitionPlayers;
    TransitionTracer mTransitionTracer;
    final ArrayList<ActivityRecord> mValidateActivityCompat;
    final ArrayList<ActivityRecord> mValidateCommitVis;
    final ArrayList<DisplayArea> mValidateDisplayVis;
    final ArrayList<Transition> mWaitingTransitions;

    class Lock {
        private int mTransitionWaiters;
        final /* synthetic */ TransitionController this$0;

        Lock(TransitionController this$0) {
            this.this$0 = this$0;
            this.mTransitionWaiters = 0;
        }

        void runWhenIdle(long timeout, Runnable r) {
            WindowManagerGlobalLock r0 = this.this$0.mAtm.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (this.this$0.inTransition() == true) goto L12;
            r.run();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L12:
            this.mTransitionWaiters++;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            long startTime = SystemClock.uptimeMillis();
            long endTime = startTime + timeout;
        L15:
            WindowManagerGlobalLock r5 = this.this$0.mAtm.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r5);
        L35:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L18:
            if (this.this$0.inTransition() == false) goto L37;
            if (SystemClock.uptimeMillis() > endTime) goto L37;
            monitor-exit(r5);     // Catch: Throwable -> L35
            WindowManagerService.resetPriorityAfterLockedSection();
            monitor-enter(this);
            wait(timeout);     // Catch: Throwable -> L28 InterruptedException -> L30
            monitor-exit(this);     // Catch: Throwable -> L28
            goto L15
        L28:
            th = move-exception;
            throw th;
        L31:
            return;
        L37:
            this.mTransitionWaiters--;     // Catch: Throwable -> L35
            r.run();     // Catch: Throwable -> L35
            monitor-exit(r5);     // Catch: Throwable -> L35
            WindowManagerService.resetPriorityAfterLockedSection();
        }

        void doNotifyLocked() {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.mTransitionWaiters <= 0) goto L8;
            notifyAll();     // Catch: Throwable -> L6
        L8:
            monitor-exit(this);     // Catch: Throwable -> L6
        }
    }

    static class Logger implements Runnable {
        long mAbortTimeNs;
        long mCollectTimeNs;
        long mCreateTimeNs;
        long mCreateWallTimeMs;
        long mFinishTimeNs;
        android.window.TransitionInfo mInfo;
        long mReadyTimeNs;
        TransitionRequestInfo mRequest;
        long mRequestTimeNs;
        long mSendTimeNs;
        long mStartTimeNs;
        WindowContainerTransaction mStartWCT;
        int mSyncId;
        long mTransactionCommitTimeNs;

        Logger() {
        }

        private String buildOnSendLog() {
            StringBuilder r0 = new StringBuilder("Sent Transition (#");
            r0.append(this.mSyncId);
            r0.append(") createdAt=");
            StringBuilder sb = r0.append(TimeUtils.logTimeOfDay(this.mCreateWallTimeMs));
            if (this.mRequest == null) goto L6;
            sb.append(" via request=");
            sb.append(this.mRequest);
        L6:
            return sb.toString();
        }

        void logOnSendAsync(Handler handler) {
            handler.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            logOnSend();     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            Slog.w(TransitionController.TAG, "Failed to log transition", e);
        }

        void logOnSend() {
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[1] == false) goto L6;
            String protoLogParam0 = String.valueOf(buildOnSendLog());
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, -5051723169912572741L, 0, new Object[]{protoLogParam0});
        L6:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[1] == false) goto L9;
            String protoLogParam1 = String.valueOf(this.mStartWCT);
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, 4281568181321808508L, 0, new Object[]{protoLogParam1});
        L9:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[1] == false) goto L12;
            String protoLogParam2 = String.valueOf(this.mInfo.toString("    "));
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, 5141999957143860655L, 0, new Object[]{protoLogParam2});
            return;
        }

        private static String toMsString(long nanos) {
            return (Math.round(nanos / 1000.0d) / 1000.0d) + "ms";
        }

        String buildOnFinishLog() {
            StringBuilder r0 = new StringBuilder("Finish Transition (#");
            r0.append(this.mSyncId);
            r0.append("): created at ");
            StringBuilder sb = r0.append(TimeUtils.logTimeOfDay(this.mCreateWallTimeMs));
            sb.append(" collect-started=");
            sb.append(toMsString(this.mCollectTimeNs - this.mCreateTimeNs));
            if (this.mRequestTimeNs == 0) goto L5;
            sb.append(" request-sent=");
            sb.append(toMsString(this.mRequestTimeNs - this.mCreateTimeNs));
        L5:
            sb.append(" started=");
            sb.append(toMsString(this.mStartTimeNs - this.mCreateTimeNs));
            sb.append(" ready=");
            sb.append(toMsString(this.mReadyTimeNs - this.mCreateTimeNs));
            sb.append(" sent=");
            sb.append(toMsString(this.mSendTimeNs - this.mCreateTimeNs));
            if (this.mTransactionCommitTimeNs == 0) goto L8;
            sb.append(" commit=");
            sb.append(toMsString(this.mTransactionCommitTimeNs - this.mSendTimeNs));
        L8:
            sb.append(" finished=");
            sb.append(toMsString(this.mFinishTimeNs - this.mCreateTimeNs));
            return sb.toString();
        }

        void logOnFinish() {
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[1] == false) goto L6;
            String protoLogParam0 = String.valueOf(buildOnFinishLog());
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, -5051723169912572741L, 0, new Object[]{protoLogParam0});
            return;
        }
    }

    interface OnStartCollect {
        void onCollectStarted(boolean r1);
    }

    static class QueuedTransition {
        final BLASTSyncEngine.SyncGroup mLegacySync;
        final OnStartCollect mOnStartCollect;
        final Transition mTransition;

        QueuedTransition(Transition transition, OnStartCollect onStartCollect) {
            this.mTransition = transition;
            this.mOnStartCollect = onStartCollect;
            this.mLegacySync = null;
        }

        QueuedTransition(BLASTSyncEngine.SyncGroup legacySync, OnStartCollect onStartCollect) {
            this.mTransition = null;
            this.mOnStartCollect = onStartCollect;
            this.mLegacySync = legacySync;
        }
    }

    static class RemotePlayer {
        private static final long REPORT_RUNNING_GRACE_PERIOD_MS = 200;
        private final ActivityTaskManagerService mAtm;
        private final ArrayMap<IBinder, DelegateProcess> mDelegateProcesses;

        private class DelegateProcess implements Runnable {
            boolean mNeedReport;
            final WindowProcessController mProc;
            final /* synthetic */ RemotePlayer this$0;

            DelegateProcess(RemotePlayer r1, WindowProcessController proc) {
                this.this$0 = r1;
                this.mProc = proc;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object r0 = RemotePlayer.m10344$$Nest$fgetmAtm(this.this$0).mGlobalLockWithoutBoost;
                monitor-enter(r0);
                this.this$0.update(this.mProc, false, false);     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAtm, reason: not valid java name */
        static /* bridge */ /* synthetic */ ActivityTaskManagerService m10344$$Nest$fgetmAtm(RemotePlayer r0) {
            return r0.mAtm;
        }

        RemotePlayer(ActivityTaskManagerService atm) {
            this.mDelegateProcesses = new ArrayMap();
            this.mAtm = atm;
        }

        void update(WindowProcessController delegate, boolean running, boolean predict) {
            if (running == true) goto L25;
            ArrayMap<IBinder, DelegateProcess> r1 = this.mDelegateProcesses;
            monitor-enter(r1);
            boolean removed = false;
            int i = this.mDelegateProcesses.size() - 1;     // Catch: Throwable -> L12
        L8:
            if (i < 0) goto L16;
            if (this.mDelegateProcesses.valueAt(i).mProc == delegate) goto L11;
            i = i - 1;     // Catch: Throwable -> L12
            goto L8
        L11:
            this.mDelegateProcesses.removeAt(i);     // Catch: Throwable -> L12
            removed = true;
        L16:
            if (removed == true) goto L19;
            monitor-exit(r1);     // Catch: Throwable -> L12
            return;
        L19:
            monitor-exit(r1);     // Catch: Throwable -> L12
            delegate.setRunningRemoteAnimation(false);
            return;
        L12:
            th = move-exception;
            throw th;
        L25:
            if (delegate.isRunningRemoteTransition() == false) goto L27;
            return;
        L27:
            if (delegate.hasThread() == false) goto L46;
            delegate.setRunningRemoteAnimation(true);
            DelegateProcess delegateProc = new DelegateProcess(this, delegate);
            if (predict == false) goto L32;
            delegateProc.mNeedReport = true;
            this.mAtm.mH.postDelayed(delegateProc, REPORT_RUNNING_GRACE_PERIOD_MS);
        L32:
            ArrayMap<IBinder, DelegateProcess> r0 = this.mDelegateProcesses;
            monitor-enter(r0);
            this.mDelegateProcesses.put(delegate.getThread().asBinder(), delegateProc);     // Catch: Throwable -> L37
            monitor-exit(r0);     // Catch: Throwable -> L37
            return;
        L37:
            th = move-exception;
            throw th;
        }

        void clear() {
            ArrayMap<IBinder, DelegateProcess> r0 = this.mDelegateProcesses;
            monitor-enter(r0);
            int i = this.mDelegateProcesses.size() - 1;     // Catch: Throwable -> L7
        L5:
            if (i < 0) goto L9;
            this.mDelegateProcesses.valueAt(i).mProc.setRunningRemoteAnimation(false);     // Catch: Throwable -> L7
            i = i - 1;     // Catch: Throwable -> L7
            goto L5
        L9:
            this.mDelegateProcesses.clear();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        boolean reportRunning(IApplicationThread appThread) {
            ArrayMap<IBinder, DelegateProcess> r0 = this.mDelegateProcesses;
            monitor-enter(r0);
            DelegateProcess delegate = this.mDelegateProcesses.get(appThread.asBinder());     // Catch: Throwable -> L9
            if (delegate != null) goto L7;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            if (delegate == null) goto L19;
            return true;
        L19:
            return false;
        L7:
            if (delegate.mNeedReport == false) goto L11;
            delegate.mNeedReport = false;     // Catch: Throwable -> L9
            this.mAtm.mH.removeCallbacks(delegate);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }
    }

    static class TransitionMetricsReporter extends ITransitionMetricsReporter.Stub {
        private final ArrayMap<IBinder, LongConsumer> mMetricConsumers;

        TransitionMetricsReporter() {
            this.mMetricConsumers = new ArrayMap();
        }

        void associate(IBinder transitionToken, LongConsumer consumer) {
            ArrayMap<IBinder, LongConsumer> r0 = this.mMetricConsumers;
            monitor-enter(r0);
            this.mMetricConsumers.put(transitionToken, consumer);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void reportAnimationStart(IBinder transitionToken, long startTime) {
            ArrayMap<IBinder, LongConsumer> r0 = this.mMetricConsumers;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mMetricConsumers.isEmpty() == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            LongConsumer c = this.mMetricConsumers.remove(transitionToken);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            if (c == null) goto L18;
            c.accept(startTime);
            return;
        }
    }

    private class TransitionPlayerRecord {
        IBinder.DeathRecipient mDeath;
        final ITransitionPlayer mPlayer;
        private WindowProcessController mPlayerProc;
        final /* synthetic */ TransitionController this$0;

        public static /* synthetic */ void $r8$lambda$gEZq8uiWirzpzHv9nqGklSU4lNU(TransitionPlayerRecord r0) {
            r0.lambda$linkToDeath$0();
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPlayerProc, reason: not valid java name */
        static /* bridge */ /* synthetic */ WindowProcessController m10345$$Nest$fgetmPlayerProc(TransitionPlayerRecord r0) {
            return r0.mPlayerProc;
        }

        TransitionPlayerRecord(TransitionController r3, ITransitionPlayer player, WindowProcessController playerProc) {
            this.this$0 = r3;
            this.mDeath = null;
            this.mPlayer = player;
            this.mPlayerProc = playerProc;
            linkToDeath();     // Catch: RemoteException -> L5
            return;
        L7:
            throw new RuntimeException("Unable to set transition player");
        }

        private void linkToDeath() throws RemoteException {
            if (this.mPlayer.asBinder() != null) goto L5;
            return;
        L5:
            this.mDeath = new TransitionController$TransitionPlayerRecord$$ExternalSyntheticLambda0(this);
            this.mPlayer.asBinder().linkToDeath(this.mDeath, 0);
        }

        private /* synthetic */ void lambda$linkToDeath$0() {
            WindowManagerGlobalLock r0 = this.this$0.mAtm.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.unregisterTransitionPlayer(this.mPlayer);     // Catch: Throwable -> L8
            this.this$0.getExt().onActiveTransitionPlayerDiedForSplitDragImeSuppression();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        void unlinkToDeath() {
            if (this.mPlayer.asBinder() != null) goto L5;
            return;
        L5:
            if (this.mDeath == null) goto L10;
            this.mPlayer.asBinder().unlinkToDeath(this.mDeath, 0);
            this.mDeath = null;
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-c8e6vpLdw5eXlQkeqkL3sXTZgw, reason: not valid java name */
    public static /* synthetic */ void m10342$r8$lambda$c8e6vpLdw5eXlQkeqkL3sXTZgw(Consumer r0, boolean r1) {
        lambda$startLegacySyncOrQueue$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$TerymLUGAYTwMRaNmsjSQz8dpTM(TransitionController r0, Transition r1) {
        r0.lambda$requestStartTransition$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$ZGyX8J_xlg5yzX_FWtxgtrHJgsg(TransitionController r0, boolean r1, Transition r2, WindowState r3) {
        r0.lambda$collectForDisplayAreaChange$3(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$hdU7GOPCaI6x9zEuADVHZmrRCfs(Transition r0, Task r1) {
        lambda$collectForDisplayAreaChange$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$pItjJhTTnT36e1pS1vrlfsLr7V8(WindowContainer r0) {
        lambda$onVisibleWithoutCollectingTransition$4(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$sCMOYGin9upaf7N-sUNEpTJDs1w, reason: not valid java name */
    public static /* synthetic */ void m10343$r8$lambda$sCMOYGin9upaf7NsUNEpTJDs1w(TransitionController r0, QueuedTransition r1) {
        r0.lambda$tryStartCollectFromQueue$5(r1);
    }

    public static /* synthetic */ void $r8$lambda$sp5jLXZnTtjq9H_2FnHYm0f8wvE(WindowState r0) {
        lambda$setDisplaySyncMethod$0(r0);
    }

    static {
        int r1 = 0;
        SHELL_TRANSITIONS_ROTATION = SystemProperties.getBoolean("persist.wm.debug.shell_transit_rotate", false);
        if (SystemProperties.getBoolean("persist.wm.debug.shell_transit_blast", false) == false) goto L6;
        r1 = 1;
    L6:
        SYNC_METHOD = r1;
    }

    TransitionController(ActivityTaskManagerService atm) {
        this.mTransitionPlayers = new ArrayList();
        this.mTransitionMetricsReporter = new TransitionMetricsReporter();
        this.mFullReadyTracking = false;
        this.mLegacyListeners = new ArrayList();
        this.mStateValidators = new ArrayList();
        this.mValidateCommitVis = new ArrayList();
        this.mValidateActivityCompat = new ArrayList();
        this.mValidateDisplayVis = new ArrayList();
        this.mPlayingTransitions = new ArrayList();
        this.mTrackCount = 0;
        this.mAnimatingExitWindows = new ArrayList();
        this.mRunningLock = new Lock(this);
        this.mQueuedTransitions = new ArrayList();
        this.mCollectingTransition = null;
        this.mWaitingTransitions = new ArrayList();
        this.mLatestOnTopTasksReported = new SparseArray();
        this.mBuildingFinishLayers = false;
        this.mNavigationBarAttachedToApp = false;
        this.mAnimatingState = false;
        this.mLoggerHandler = FgThread.getHandler();
        this.mIsWaitingForDisplayEnabled = false;
        this.mExt = (IExtTransitionController) ExtImplFactory.getImpl(IExtTransitionController.class, new Object[]{this});
        this.mAtm = atm;
        this.mRemotePlayer = new RemotePlayer(atm);
    }

    void setWindowManager(WindowManagerService wms) {
        this.mSnapshotController = wms.mSnapshotController;
        this.mTransitionTracer = wms.mTransitionTracer;
        this.mIsWaitingForDisplayEnabled = !wms.mDisplayEnabled;
        registerLegacyListener(wms.mActivityManagerAppTransitionNotifier);
        setSyncEngine(wms.mSyncEngine);
        this.mFullReadyTracking = false;
    }

    void setSyncEngine(BLASTSyncEngine syncEngine) {
        this.mSyncEngine = syncEngine;
        this.mSyncEngine.addOnIdleListener(new TransitionController$$ExternalSyntheticLambda4(this));
    }

    void flushRunningTransitions() {
        ArrayList<TransitionPlayerRecord> temp = new ArrayList(this.mTransitionPlayers);
        this.mTransitionPlayers.clear();
        int i = this.mPlayingTransitions.size() - 1;
    L3:
        if (i < 0) goto L5;
        this.mPlayingTransitions.get(i).cleanUpOnFailure();
        i = i - 1;
        goto L3
    L5:
        this.mPlayingTransitions.clear();
        int i2 = this.mWaitingTransitions.size() - 1;
    L6:
        if (i2 < 0) goto L8;
        this.mWaitingTransitions.get(i2).abort();
        i2 = i2 - 1;
        goto L6
    L8:
        this.mWaitingTransitions.clear();
        if (this.mCollectingTransition == null) goto L11;
        this.mCollectingTransition.abort();
    L11:
        this.mRemotePlayer.clear();
        this.mRunningLock.doNotifyLocked();
        this.mTransitionPlayers.addAll(temp);
    }

    Transition createTransition(int type) {
        return createTransition(type, 0);
    }

    Transition createTransition(int type, int flags) {
        if (this.mTransitionPlayers.isEmpty() == true) goto L14;
        if (this.mCollectingTransition != null) goto L12;
        Transition transit = new Transition(type, flags, this, this.mSyncEngine);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L9;
        String protoLogParam0 = String.valueOf(transit);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -233096875591058130L, 0, new Object[]{protoLogParam0});
    L9:
        moveToCollecting(transit);
        return transit;
    L12:
        throw new IllegalStateException("Trying to directly start transition collection while  collection is already ongoing. Use {@link #startCollectOrQueue} if possible.");
    L14:
        throw new IllegalStateException("Shell Transitions not enabled");
    }

    void moveToCollecting(Transition transition) {
        if (this.mCollectingTransition != null) goto L18;
        if (this.mTransitionPlayers.isEmpty() == false) goto L8;
        transition.abort();
        return;
    L8:
        this.mCollectingTransition = transition;
        if (transition.mType != 6) goto L11;
        long timeoutMs = ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME;
    L12:
        this.mCollectingTransition.startCollecting(timeoutMs);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L15;
        String protoLogParam0 = String.valueOf(this.mCollectingTransition);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 2154694726162725342L, 0, new Object[]{protoLogParam0});
    L15:
        getExt().traceStartCollecting(transition.getSyncId());
        return;
    L11:
        timeoutMs = 5000;
        goto L12
    L18:
        throw new IllegalStateException("Simultaneous transition collection not supported.");
    }

    void registerTransitionPlayer(ITransitionPlayer player, WindowProcessController playerProc) {
        if (this.mTransitionPlayers.isEmpty() == true) goto L9;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[1] == false) goto L7;
        String protoLogParam0 = String.valueOf(player.asBinder());
        long protoLogParam1 = this.mTransitionPlayers.size();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, -4546322749928357965L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1)});
    L7:
        flushRunningTransitions();
    L11:
        this.mTransitionPlayers.add(new TransitionPlayerRecord(this, player, playerProc));
        return;
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[1] == false) goto L11;
        String protoLogParam2 = String.valueOf(player.asBinder());
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, -4250307779892136611L, 0, new Object[]{protoLogParam2});
        goto L11
    }

    void unregisterTransitionPlayer(ITransitionPlayer player) {
        int idx = this.mTransitionPlayers.size() - 1;
    L3:
        if (idx < 0) goto L8;
        if (this.mTransitionPlayers.get(idx).mPlayer.asBinder() == player.asBinder()) goto L8;
        idx = idx - 1;
    L8:
        boolean needsFlush = false;
        if (idx >= 0) goto L15;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[3] == false) goto L32;
        String protoLogParam0 = String.valueOf(player.asBinder());
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, 3242771541905259983L, 0, new Object[]{protoLogParam0});
        return;
    L32:
        return;
    L15:
        if (idx != (this.mTransitionPlayers.size() - 1)) goto L17;
        needsFlush = true;
    L17:
        TransitionPlayerRecord record = this.mTransitionPlayers.remove(idx);
        if (needsFlush == false) goto L23;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[1] == false) goto L25;
        String protoLogParam1 = String.valueOf(player.asBinder());
        long protoLogParam2 = idx;
        long protoLogParam3 = this.mTransitionPlayers.size();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, 3691912781236221027L, 20, new Object[]{protoLogParam1, Long.valueOf(protoLogParam2), Long.valueOf(protoLogParam3)});
    L25:
        record.unlinkToDeath();
        if (needsFlush == true) goto L28;
        return;
    L28:
        flushRunningTransitions();
        return;
    L23:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[1] == false) goto L25;
        String protoLogParam4 = String.valueOf(player.asBinder());
        long protoLogParam5 = idx;
        long protoLogParam6 = this.mTransitionPlayers.size();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, -2879980134100946679L, 20, new Object[]{protoLogParam4, Long.valueOf(protoLogParam5), Long.valueOf(protoLogParam6)});
        goto L25
    }

    ITransitionPlayer getTransitionPlayer() {
        if (this.mTransitionPlayers.isEmpty() == false) goto L6;
        return null;
    L6:
        return ((TransitionPlayerRecord) this.mTransitionPlayers.getLast()).mPlayer;
    }

    boolean isShellTransitionsEnabled() {
        return !this.mTransitionPlayers.isEmpty();
    }

    boolean useShellTransitionsRotation() {
        if (isShellTransitionsEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (SHELL_TRANSITIONS_ROTATION == false) goto L7;
        return true;
    }

    boolean useFullReadyTracking() {
        return this.mFullReadyTracking;
    }

    void setFullReadyTrackingForTest(boolean enabled) {
        this.mFullReadyTracking = enabled;
    }

    boolean isCollecting() {
        if (this.mCollectingTransition == null) goto L5;
        return true;
    L5:
        return false;
    }

    Transition getCollectingTransition() {
        if (this.mCollectingTransition == null) goto L8;
        if (this.mCollectingTransition.isCollecting() == true) goto L8;
        Slog.wtfStack(TAG, "Collecting Transition (#" + this.mCollectingTransition.getSyncId() + ") is not collecting. state=" + this.mCollectingTransition.getState());
    L8:
        return this.mCollectingTransition;
    }

    int getCollectingTransitionId() {
        if (this.mCollectingTransition == null) goto L7;
        return this.mCollectingTransition.getSyncId();
    L7:
        throw new IllegalStateException("There is no collecting transition");
    }

    boolean isCollecting(WindowContainer wc) {
        if (this.mCollectingTransition != null) goto L6;
        return false;
    L6:
        if (this.mCollectingTransition.mParticipants.contains(wc) == false) goto L8;
        return true;
    L8:
        int i = 0;
    L10:
        if (i >= this.mWaitingTransitions.size()) goto L16;
        if (this.mWaitingTransitions.get(i).mParticipants.contains(wc) == true) goto L13;
        i = i + 1;
        goto L10
    L13:
        return true;
    L16:
        return false;
    }

    boolean inCollectingTransition(WindowContainer wc) {
        if (isCollecting() == true) goto L6;
        return false;
    L6:
        if (this.mCollectingTransition.isInTransition(wc) == false) goto L8;
        return true;
    L8:
        int i = 0;
    L10:
        if (i >= this.mWaitingTransitions.size()) goto L16;
        if (this.mWaitingTransitions.get(i).isInTransition(wc) == true) goto L13;
        i = i + 1;
        goto L10
    L13:
        return true;
    L16:
        return false;
    }

    boolean isPlaying() {
        return !this.mPlayingTransitions.isEmpty();
    }

    boolean inPlayingTransition(WindowContainer wc) {
        int i = this.mPlayingTransitions.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (this.mPlayingTransitions.get(i).isInTransition(wc) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    boolean isPlayingTarget(WindowContainer<?> wc) {
        int i = this.mPlayingTransitions.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (Transition.containsChangeFor(wc, this.mPlayingTransitions.get(i).mTargets) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    boolean inFinishingTransition(WindowContainer<?> wc) {
        if (this.mFinishingTransition != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mFinishingTransition.isInTransition(wc) == false) goto L7;
        return true;
    }

    boolean inTransition() {
        if (isCollecting() == false) goto L5;
    L10:
        return true;
    L5:
        if (isPlaying() == true) goto L10;
        if (this.mQueuedTransitions.isEmpty() == false) goto L10;
        return false;
    }

    boolean inTransition(WindowContainer wc) {
        if (inCollectingTransition(wc) == false) goto L5;
    L8:
        return true;
    L5:
        if (inPlayingTransition(wc) == true) goto L8;
        return false;
    }

    boolean inTransition(int syncId) {
        if (this.mCollectingTransition != null) goto L5;
    L7:
        int i = this.mPlayingTransitions.size() - 1;
    L8:
        if (i < 0) goto L13;
        if (this.mPlayingTransitions.get(i).getSyncId() == syncId) goto L11;
        i = i - 1;
        goto L8
    L11:
        return true;
    L13:
        return false;
    L5:
        if (this.mCollectingTransition.getSyncId() != syncId) goto L7;
        return true;
    }

    boolean isCollectingTransitionOnDisplay(DisplayContent dc) {
        if (this.mCollectingTransition != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mCollectingTransition.isOnDisplay(dc) == false) goto L7;
        return true;
    }

    boolean isTransitionOnDisplay(DisplayContent dc) {
        if (isCollectingTransitionOnDisplay(dc) == false) goto L5;
        return true;
    L5:
        int i = this.mWaitingTransitions.size() - 1;
    L6:
        if (i < 0) goto L11;
        if (this.mWaitingTransitions.get(i).isOnDisplay(dc) == true) goto L9;
        i = i - 1;
        goto L6
    L9:
        return true;
    L11:
        int i2 = this.mPlayingTransitions.size() - 1;
    L12:
        if (i2 < 0) goto L17;
        if (this.mPlayingTransitions.get(i2).isOnDisplay(dc) == true) goto L15;
        i2 = i2 - 1;
        goto L12
    L15:
        return true;
    L17:
        return false;
    }

    boolean isInAodAppearTransition() {
        if (this.mCollectingTransition != null) goto L5;
    L7:
        int i = this.mWaitingTransitions.size() - 1;
    L8:
        if (i < 0) goto L13;
        if (this.mWaitingTransitions.get(i).isInAodAppearTransition() == true) goto L11;
        i = i - 1;
        goto L8
    L11:
        return true;
    L13:
        int i2 = this.mPlayingTransitions.size() - 1;
    L14:
        if (i2 < 0) goto L19;
        if (this.mPlayingTransitions.get(i2).isInAodAppearTransition() == true) goto L17;
        i2 = i2 - 1;
        goto L14
    L17:
        return true;
    L19:
        return false;
    L5:
        if (this.mCollectingTransition.isInAodAppearTransition() == false) goto L7;
        return true;
    }

    Pair<Transition, Task> getTransientLaunchTransitionAndTarget(WindowContainer container) {
        int i = this.mPlayingTransitions.size() - 1;
    L3:
        if (i < 0) goto L9;
        Transition transition = this.mPlayingTransitions.get(i);
        Task restoreBehindTask = transition.getTransientLaunchRestoreTarget(container);
        if (restoreBehindTask != null) goto L7;
        i = i - 1;
        goto L3
    L7:
        return new Pair(transition, restoreBehindTask);
    L9:
        return null;
    }

    Transition getTransientHideTransitionForContainer(WindowContainer container) {
        int i = this.mPlayingTransitions.size() - 1;
    L3:
        if (i < 0) goto L8;
        Transition transition = this.mPlayingTransitions.get(i);
        if (transition.isInTransientHide(container) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return transition;
    L8:
        return null;
    }

    boolean hasTransientLaunch(DisplayContent dc) {
        if (this.mCollectingTransition != null) goto L5;
    L9:
        int i = this.mWaitingTransitions.size() - 1;
    L10:
        if (i < 0) goto L17;
        Transition transition = this.mWaitingTransitions.get(i);
        if (transition.hasTransientLaunch() == false) goto L16;
        if (transition.isOnDisplay(dc) == false) goto L16;
        return true;
    L16:
        i = i - 1;
        goto L10
    L17:
        int i2 = this.mPlayingTransitions.size() - 1;
    L18:
        if (i2 < 0) goto L25;
        Transition transition2 = this.mPlayingTransitions.get(i2);
        if (transition2.hasTransientLaunch() == false) goto L24;
        if (transition2.isOnDisplay(dc) == false) goto L24;
        return true;
    L24:
        i2 = i2 - 1;
        goto L18
    L25:
        return false;
    L5:
        if (this.mCollectingTransition.hasTransientLaunch() == false) goto L9;
        if (this.mCollectingTransition.isOnDisplay(dc) == false) goto L9;
        return true;
    }

    boolean isTransientHide(Task task) {
        if (this.mCollectingTransition != null) goto L5;
    L7:
        int i = this.mWaitingTransitions.size() - 1;
    L8:
        if (i < 0) goto L13;
        if (this.mWaitingTransitions.get(i).isInTransientHide(task) == true) goto L11;
        i = i - 1;
        goto L8
    L11:
        return true;
    L13:
        int i2 = this.mPlayingTransitions.size() - 1;
    L14:
        if (i2 < 0) goto L19;
        if (this.mPlayingTransitions.get(i2).isInTransientHide(task) == true) goto L17;
        i2 = i2 - 1;
        goto L14
    L17:
        return true;
    L19:
        return false;
    L5:
        if (this.mCollectingTransition.isInTransientHide(task) == false) goto L7;
        return true;
    }

    boolean isTransientVisible(Task task) {
        if (this.mCollectingTransition != null) goto L5;
    L7:
        int i = this.mWaitingTransitions.size() - 1;
    L8:
        if (i < 0) goto L13;
        if (this.mWaitingTransitions.get(i).isTransientVisible(task) == true) goto L11;
        i = i - 1;
        goto L8
    L11:
        return true;
    L13:
        int i2 = this.mPlayingTransitions.size() - 1;
    L14:
        if (i2 < 0) goto L19;
        if (this.mPlayingTransitions.get(i2).isTransientVisible(task) == true) goto L17;
        i2 = i2 - 1;
        goto L14
    L17:
        return true;
    L19:
        return false;
    L5:
        if (this.mCollectingTransition.isTransientVisible(task) == false) goto L7;
        return true;
    }

    boolean canApplyDim(Task task) {
        if (task != null) goto L5;
        return true;
    L5:
        int i = this.mPlayingTransitions.size() - 1;
    L6:
        if (i < 0) goto L13;
        if (this.mPlayingTransitions.get(i).canApplyDim(task) == false) goto L9;
        i = i - 1;
        goto L6
    L9:
        return false;
    L13:
        return true;
    }

    boolean shouldKeepFocus(WindowContainer wc) {
        if (this.mCollectingTransition == null) goto L10;
        if (this.mPlayingTransitions.isEmpty() == true) goto L8;
        return false;
    L8:
        return this.mCollectingTransition.isInTransientHide(wc);
    L10:
        if (this.mPlayingTransitions.size() == 1) goto L12;
        return false;
    L12:
        return this.mPlayingTransitions.get(0).isInTransientHide(wc);
    }

    boolean isTransientCollect(ActivityRecord ar) {
        if (this.mCollectingTransition != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mCollectingTransition.isTransientLaunch(ar) == false) goto L7;
        return true;
    }

    boolean isTransientLaunch(ActivityRecord ar) {
        if (isTransientCollect(ar) == false) goto L5;
        return true;
    L5:
        int i = this.mWaitingTransitions.size() - 1;
    L6:
        if (i < 0) goto L11;
        if (this.mWaitingTransitions.get(i).isTransientLaunch(ar) == true) goto L9;
        i = i - 1;
        goto L6
    L9:
        return true;
    L11:
        int i2 = this.mPlayingTransitions.size() - 1;
    L12:
        if (i2 < 0) goto L17;
        if (this.mPlayingTransitions.get(i2).isTransientLaunch(ar) == true) goto L15;
        i2 = i2 - 1;
        goto L12
    L15:
        return true;
    L17:
        return false;
    }

    boolean canAssignLayers(WindowContainer wc) {
        if (this.mBuildingFinishLayers == false) goto L22;
        if (this.mPlayingTransitions.isEmpty() == true) goto L17;
        if (wc.asActivityRecord() == null) goto L17;
        if (isPlayingTarget(wc) == false) goto L17;
        if (wc.getDisplayContent() == null) goto L17;
        if (hasTransientLaunch(wc.getDisplayContent()) == false) goto L17;
        Slog.d(TAG, "canAssignLayers false when TransientLaunch wc " + wc);
        return false;
    L17:
        if (wc.asWindowState() != null) goto L20;
        return true;
    L20:
        return false;
    L22:
        if (wc.asWindowState() == null) goto L24;
        return true;
    L24:
        if (isPlaying() == true) goto L34;
        if (wc.asTask() != null) goto L30;
        if (wc.asDisplayArea() != null) goto L30;
        return true;
    L30:
        if (isCollecting() == true) goto L34;
        return true;
    L34:
        return false;
    }

    int getWindowingModeAtStart(WindowContainer wc) {
        if (this.mCollectingTransition == null) goto L5;
        Transition.ChangeInfo ci = this.mCollectingTransition.mChanges.get(wc);
        if (ci != null) goto L11;
        return wc.getWindowingMode();
    L11:
        return ci.mWindowingMode;
    L5:
        return wc.getWindowingMode();
    }

    int getCollectingTransitionType() {
        if (this.mCollectingTransition != null) goto L7;
        return 0;
    L7:
        return this.mCollectingTransition.mType;
    }

    boolean hasCollectingRotationChange(WindowContainer<?> wc, int targetRotation) {
        Transition transition = this.mCollectingTransition;
        if (transition != null) goto L5;
    L13:
        return false;
    L5:
        if (transition.mParticipants.contains(wc) == false) goto L13;
        Transition.ChangeInfo changeInfo = transition.mChanges.get(wc);
        if (changeInfo != null) goto L10;
        return false;
    L10:
        if (changeInfo.mRotation == targetRotation) goto L15;
        return true;
    L15:
        return false;
    }

    private void setDisplaySyncMethod(TransitionRequestInfo.DisplayChange displayChange, DisplayContent displayContent) {
        Rect startBounds = displayChange.getStartAbsBounds();
        Rect endBounds = displayChange.getEndAbsBounds();
        if (startBounds == null) goto L8;
        if (endBounds == null) goto L9;
        setDisplaySyncMethod(startBounds, endBounds, displayContent);
        return;
    L9:
        return;
    }

    void setDisplaySyncMethod(Rect startBounds, Rect endBounds, DisplayContent displayContent) {
        int startWidth = startBounds.width();
        int startHeight = startBounds.height();
        int endWidth = endBounds.width();
        int endHeight = endBounds.height();
        boolean r4 = false;
        if (endWidth <= startWidth) goto L5;
        boolean r6 = true;
    L6:
        if (endHeight <= startHeight) goto L8;
        r4 = true;
    L8:
        if (r6 != r4) goto L13;
        if (endWidth != startWidth) goto L11;
        if (endHeight != startHeight) goto L11;
        return;
    L11:
        displayContent.forAllWindows(new TransitionController$$ExternalSyntheticLambda6(), true);
        return;
    L13:
        return;
    L5:
        r6 = false;
        goto L6
    }

    private static /* synthetic */ void lambda$setDisplaySyncMethod$0(WindowState w) {
        if (w.mToken.mRoundedCornerOverlay == true) goto L5;
        return;
    L5:
        if (w.mHasSurface == false) goto L9;
        w.mSyncMethodOverride = 1;
        return;
    }

    Transition requestTransitionIfNeeded(int type, int flags, WindowContainer trigger, WindowContainer readyGroupRef) {
        if (this.mTransitionPlayers.isEmpty() == false) goto L6;
        return null;
    L6:
        if (isCollecting() == true) goto L8;
        Transition r2 = createTransition(type, flags);
        if (trigger == null) goto L21;
        Task r3 = trigger.asTask();
    L22:
        Transition newTransition = requestStartTransition(r2, r3, null, null);
        return newTransition;
    L21:
        r3 = null;
        goto L22
    L8:
        if (type == 8) goto L12;
        if (type == 9) goto L12;
    L14:
        this.mCollectingTransition.setReady(readyGroupRef, false);
    L16:
        if ((flags & 47360) == 0) goto L24;
        this.mCollectingTransition.addFlag(47360 & flags);
        return null;
    L24:
        return null;
    L12:
        if (this.mCollectingTransition.allReady() == false) goto L14;
        this.mCollectingTransition.setReady(readyGroupRef, true);
        goto L16
    }

    Transition requestStartDisplayTransition(int type, int flags, DisplayContent trigger, RemoteTransition remoteTransition, TransitionRequestInfo.DisplayChange displayChange) {
        Transition newTransition = createTransition(type, flags);
        requestStartTransition(newTransition, null, remoteTransition, displayChange);
        if (displayChange == null) goto L5;
        setDisplaySyncMethod(displayChange, trigger);
    L5:
        return newTransition;
    }

    Transition requestStartTransition(final Transition transition, Task startTask, RemoteTransition remoteTransition, TransitionRequestInfo.DisplayChange displayChange) {
        if (this.mIsWaitingForDisplayEnabled == false) goto L10;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L7;
        long protoLogParam0 = transition.getSyncId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -4235778637051052061L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L7:
        transition.mIsPlayerEnabled = false;
        transition.mLogger.mRequestTimeNs = SystemClock.elapsedRealtimeNanos();
        this.mAtm.mH.post(new TransitionController$$ExternalSyntheticLambda0(this, transition));
        return transition;
    L10:
        if (this.mTransitionPlayers.isEmpty() == true) goto L55;
        if (transition.isAborted() == true) goto L55;
    L49:
        e = e;
    L51:
        Slog.e(TAG, "Error requesting transition", e);
        transition.start();
    L52:
        return transition;
    L15:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == true) goto L62;
    L20:
        getExt().traceRequestingStartTransition(transition.getSyncId());     // Catch: RemoteException -> L49
        if (startTask == null) goto L25;
        ActivityManager.RunningTaskInfo startTaskInfo = startTask.getTaskInfo();     // Catch: RemoteException -> L18
        ActivityManager.RunningTaskInfo startTaskInfo2 = startTaskInfo;
    L27:
        if (transition.getPipActivity() == null) goto L35;
        ActivityManager.RunningTaskInfo pipTaskInfo = transition.getPipActivity().getTask().getTaskInfo();     // Catch: RemoteException -> L18
        ActivityRecord pipActivity = transition.getPipActivity();     // Catch: RemoteException -> L18
        if (pipActivity.getTaskFragment() != null) goto L31;
    L33:
        TransitionRequestInfo.PipChange pipChange = new TransitionRequestInfo.PipChange(pipTaskInfo);     // Catch: RemoteException -> L18
        TransitionRequestInfo.PipChange pipChange2 = pipChange;
    L34:
        transition.setPipActivity(null);     // Catch: RemoteException -> L18
        TransitionRequestInfo.PipChange pipChange3 = pipChange2;
    L36:
        if (remoteTransition == null) goto L39;
        transition.mRemoteDelegate = remoteTransition.getAppThread();     // Catch: RemoteException -> L18
        RemoteTransition remoteInfo = new RemoteTransition(remoteTransition.getRemoteTransition(), remoteTransition.getDebugName());     // Catch: RemoteException -> L18
        remoteInfo.setRecentsAnimationRunner(remoteTransition.getRecentsAnimationRunner());     // Catch: RemoteException -> L18
        remoteInfo.setExtras(remoteTransition.getExtras());     // Catch: RemoteException -> L18
        RemoteTransition remoteInfo2 = remoteInfo;
    L40:
        TransitionRequestInfo request = new TransitionRequestInfo(transition.mType, startTaskInfo2, pipChange3, remoteInfo2, displayChange, transition.getFlags(), transition.getSyncId());     // Catch: RemoteException -> L46
        transition.mLogger.mRequestTimeNs = SystemClock.elapsedRealtimeNanos();     // Catch: RemoteException -> L46
        transition.mLogger.mRequest = request;     // Catch: RemoteException -> L46
        ((TransitionPlayerRecord) this.mTransitionPlayers.getLast()).mPlayer.requestStartTransition(transition.getToken(), request);     // Catch: RemoteException -> L46
        if (remoteTransition == null) goto L52;
        transition.setRemoteAnimationApp(remoteTransition.getAppThread());     // Catch: RemoteException -> L46
    L46:
        e = e;
    L18:
        e = e;
        goto L51
    L39:
        remoteInfo2 = null;
        goto L40
    L31:
        if (pipActivity.getTaskFragment() == pipActivity.getTask()) goto L33;
        pipChange2 = new TransitionRequestInfo.PipChange(pipActivity.getTaskFragment().mRemoteToken.toWindowContainerToken(), pipTaskInfo);     // Catch: RemoteException -> L18
        goto L34
    L35:
        pipChange3 = null;
        goto L36
    L25:
        startTaskInfo2 = null;
        goto L27
    L62:
        String protoLogParam1 = String.valueOf(transition);     // Catch: RemoteException -> L18
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 4005704720444963797L, 0, new Object[]{protoLogParam1});     // Catch: RemoteException -> L18
    L55:
        if (transition.isCollecting() == false) goto L57;
        transition.abort();
    L57:
        return transition;
    }

    private /* synthetic */ void lambda$requestStartTransition$1(Transition transition) {
        this.mAtm.mWindowOrganizerController.startTransition(transition.getToken(), null);
    }

    Transition requestCloseTransitionIfNeeded(WindowContainer<?> wc) {
        if (this.mTransitionPlayers.isEmpty() == false) goto L5;
    L12:
        return null;
    L5:
        if (isCollecting() == true) goto L12;
        if (wc.isVisibleRequested() == true) goto L11;
        return null;
    L11:
        return requestStartTransition(createTransition(2, 0), wc.asTask(), null, null);
    }

    void collect(WindowContainer wc) {
        if (this.mCollectingTransition != null) goto L5;
        return;
    L5:
        this.mCollectingTransition.collect(wc);
    }

    void collectExistenceChange(WindowContainer wc) {
        if (this.mCollectingTransition != null) goto L5;
        return;
    L5:
        this.mCollectingTransition.collectExistenceChange(wc);
    }

    void recordTaskOrder(WindowContainer wc) {
        if (this.mCollectingTransition != null) goto L5;
        return;
    L5:
        this.mCollectingTransition.recordTaskOrder(wc);
    }

    boolean hasOrderChanges() {
        if (this.mCollectingTransition != null) goto L7;
        return false;
    L7:
        return this.mCollectingTransition.hasOrderChanges();
    }

    void collectForDisplayAreaChange(DisplayArea<?> wc) {
        final Transition transition = this.mCollectingTransition;
        if (transition != null) goto L5;
        return;
    L5:
        if (transition.mParticipants.contains(wc) == false) goto L17;
        transition.collectVisibleChange(wc);
        wc.forAllLeafTasks(new TransitionController$$ExternalSyntheticLambda2(transition), true);
        DisplayContent dc = wc.asDisplayContent();
        if (dc != null) goto L10;
        return;
    L10:
        if (dc.getAsyncRotationController() != null) goto L12;
        final boolean noAsyncRotation = true;
    L13:
        wc.forAllWindows(new TransitionController$$ExternalSyntheticLambda3(this, noAsyncRotation, transition), true);
        return;
    L12:
        noAsyncRotation = false;
        goto L13
    }

    private static /* synthetic */ void lambda$collectForDisplayAreaChange$2(Transition transition, Task task) {
        if (task.isVisible() == false) goto L6;
        transition.collect(task);
        return;
    }

    private /* synthetic */ void lambda$collectForDisplayAreaChange$3(boolean noAsyncRotation, Transition transition, WindowState w) {
        if (w.mActivityRecord == null) goto L5;
        return;
    L5:
        if (w.isVisible() == true) goto L7;
        return;
    L7:
        if (isCollecting(w.mToken) == true) goto L15;
        if (noAsyncRotation == false) goto L10;
    L11:
        transition.collect(w.mToken);
        return;
    L10:
        if (AsyncRotationController.canBeAsync(w.mToken) == false) goto L11;
        return;
    }

    void collectVisibleChange(WindowContainer wc) {
        if (isCollecting() == true) goto L5;
        return;
    L5:
        this.mCollectingTransition.collectVisibleChange(wc);
    }

    void collectReparentChange(WindowContainer wc, WindowContainer newParent) {
        if (isCollecting() == true) goto L5;
        return;
    L5:
        this.mCollectingTransition.collectReparentChange(wc, newParent);
    }

    void setStatusBarTransitionDelay(long delay) {
        if (this.mCollectingTransition != null) goto L5;
        return;
    L5:
        this.mCollectingTransition.mStatusBarTransitionDelay = delay;
    }

    void setOverrideAnimation(android.window.TransitionInfo.AnimationOptions options, ActivityRecord r, IRemoteCallback startCallback, IRemoteCallback finishCallback) {
        if (this.mCollectingTransition != null) goto L5;
        return;
    L5:
        this.mCollectingTransition.setOverrideAnimation(options, r, startCallback, finishCallback);
    }

    void setOverrideBackgroundColor(int backgroundColor) {
        if (this.mCollectingTransition != null) goto L5;
        return;
    L5:
        this.mCollectingTransition.setOverrideBackgroundColor(backgroundColor);
    }

    void setNoAnimation(WindowContainer wc) {
        if (this.mCollectingTransition != null) goto L5;
        return;
    L5:
        this.mCollectingTransition.setNoAnimation(wc);
    }

    void setReady(WindowContainer wc, boolean ready) {
        if (this.mCollectingTransition != null) goto L5;
        return;
    L5:
        this.mCollectingTransition.setReady(wc, ready);
    }

    void setReady(WindowContainer wc) {
        setReady(wc, true);
    }

    void deferTransitionReady() {
        if (isShellTransitionsEnabled() == true) goto L6;
        return;
    L6:
        if (this.mCollectingTransition == null) goto L10;
        this.mCollectingTransition.deferTransitionReady();
        return;
    L10:
        throw new IllegalStateException("No collecting transition to defer readiness for.");
    }

    void continueTransitionReady() {
        if (isShellTransitionsEnabled() == true) goto L6;
        return;
    L6:
        if (this.mCollectingTransition == null) goto L10;
        this.mCollectingTransition.continueTransitionReady();
        return;
    L10:
        throw new IllegalStateException("No collecting transition to defer readiness for.");
    }

    void finishTransition(ActionChain chain) {
        if (chain.isFinishing() == false) goto L42;
        Transition record = chain.mTransition;
        this.mTransitionMetricsReporter.reportAnimationStart(record.getToken(), 0);
        this.mAtm.endPowerMode(2);
        if (this.mPlayingTransitions.contains(record) == true) goto L9;
        Slog.e(TAG, "Trying to finish a non-playing transition " + record);
        return;
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L11;
        String protoLogParam0 = String.valueOf(record);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -6030030735787868329L, 0, new Object[]{protoLogParam0});
    L11:
        this.mPlayingTransitions.remove(record);
        if (inTransition() == true) goto L14;
        this.mTrackCount = 0;
    L14:
        updateRunningRemoteAnimation(record, false);
        record.finishTransition(chain);
        if ((record.getFlags() & 256) == 0) goto L19;
        DisplayContent defaultDisplay = this.mAtm.mRootWindowContainer.getDefaultDisplay();
        if (defaultDisplay == null) goto L19;
        defaultDisplay.getExt().finishDeferUpdateOrientationForSplit();
    L19:
        int i = this.mAnimatingExitWindows.size() - 1;
    L20:
        if (i < 0) goto L34;
        WindowState w = this.mAnimatingExitWindows.get(i);
        if (w.mAnimatingExit == false) goto L29;
        if (w.mHasSurface == false) goto L29;
        if (w.inTransition() == true) goto L29;
        w.onExitAnimationDone();
    L29:
        if (w.mAnimatingExit == true) goto L31;
    L32:
        this.mAnimatingExitWindows.remove(i);
    L33:
        i = i - 1;
        goto L20
    L31:
        if (w.mHasSurface == true) goto L33;
    L34:
        this.mRunningLock.doNotifyLocked();
        if (inTransition() == true) goto L39;
        validateStates();
        this.mAtm.mWindowManager.onAnimationFinished();
        IExtActivityClientController ext = this.mAtm.mActivityClientController.getExt();
        if (ext == null) goto L39;
        ext.scheduleExecutePendingToggleSwitchFromFullScreenToFreeform("transitionFinished");
    L39:
        this.mExt.onFinishTransition();
        return;
    L42:
        throw new IllegalStateException("Can't finish on a non-finishing transition " + chain.mTransition);
    }

    void onCommittedInvisibles() {
        if (this.mCollectingTransition == null) goto L5;
        this.mCollectingTransition.mPriorVisibilityMightBeDirty = true;
    L5:
        int i = this.mWaitingTransitions.size() - 1;
    L6:
        if (i < 0) goto L9;
        this.mWaitingTransitions.get(i).mPriorVisibilityMightBeDirty = true;
        i = i - 1;
        goto L6
    }

    private void validateStates() {
        int i = 0;
    L4:
        if (i >= this.mStateValidators.size()) goto L10;
        this.mStateValidators.get(i).run();
        if (inTransition() == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        this.mStateValidators.subList(0, i + 1).clear();
        return;
    L10:
        this.mStateValidators.clear();
        int i2 = 0;
    L12:
        if (i2 >= this.mValidateCommitVis.size()) goto L23;
        ActivityRecord ar = this.mValidateCommitVis.get(i2);
        if (ar.isVisibleRequested() == true) goto L18;
        if (ar.isVisible() == false) goto L18;
    L21:
        Slog.e(TAG, "Uncommitted visibility change: " + ar);
        ar.commitVisibility(ar.isVisibleRequested(), false, false);
    L22:
        i2 = i2 + 1;
    L18:
        if (ar.isVisibleRequested() == false) goto L22;
        if (ar.isVisible() == true) goto L22;
    L23:
        this.mValidateCommitVis.clear();
        int i3 = 0;
    L25:
        if (i3 >= this.mValidateActivityCompat.size()) goto L31;
        ActivityRecord ar2 = this.mValidateActivityCompat.get(i3);
        if (ar2.getSurfaceControl() == null) goto L30;
        Point tmpPos = new Point();
        ar2.getRelativePosition(tmpPos);
        ar2.getSyncTransaction().setPosition(ar2.getSurfaceControl(), tmpPos.x, tmpPos.y);
    L30:
        i3 = i3 + 1;
        goto L25
    L31:
        this.mValidateActivityCompat.clear();
        int i4 = 0;
    L33:
        if (i4 >= this.mValidateDisplayVis.size()) goto L43;
        DisplayArea da = this.mValidateDisplayVis.get(i4);
        if (da.isAttached() == false) goto L42;
        if (da.getSurfaceControl() == null) goto L42;
        if (da.isVisibleRequested() == false) goto L42;
        Slog.e(TAG, "DisplayArea became visible outside of a transition: " + da);
        da.getSyncTransaction().show(da.getSurfaceControl());
    L42:
        i4 = i4 + 1;
        goto L33
    L43:
        this.mValidateDisplayVis.clear();
        getExt().processValidateWC();
    }

    void onVisibleWithoutCollectingTransition(final WindowContainer<?> wc, String caller) {
        boolean isPlaying = !this.mPlayingTransitions.isEmpty();
        Slog.e(TAG, "Set visible without transition " + wc + " playing=" + isPlaying + " caller=" + caller);
        if (isPlaying == true) goto L6;
        WindowContainer.enforceSurfaceVisible(wc);
        return;
    L6:
        this.mStateValidators.add(new TransitionController$$ExternalSyntheticLambda5(wc));
    }

    private static /* synthetic */ void lambda$onVisibleWithoutCollectingTransition$4(WindowContainer wc) {
        if (wc.isVisibleRequested() == false) goto L6;
        WindowContainer.enforceSurfaceVisible(wc);
        return;
    }

    void onTransitionPopulated(Transition transition) {
        tryStartCollectFromQueue();
    }

    private boolean canStartCollectingNow(Transition queued) {
        if (this.mCollectingTransition != null) goto L6;
        return true;
    L6:
        if (this.mCollectingTransition.isPopulated() == true) goto L9;
        return false;
    L9:
        if (getCanBeIndependent(this.mCollectingTransition, queued) == true) goto L11;
        return false;
    L11:
        int i = 0;
    L13:
        if (i >= this.mWaitingTransitions.size()) goto L19;
        if (getCanBeIndependent(this.mWaitingTransitions.get(i), queued) == false) goto L16;
        i = i + 1;
        goto L13
    L16:
        return false;
    L19:
        return true;
    }

    void tryStartCollectFromQueue() {
        if (this.mQueuedTransitions.isEmpty() == false) goto L5;
        return;
    L5:
        final QueuedTransition queued = this.mQueuedTransitions.get(0);
        if (this.mCollectingTransition == null) goto L18;
        if (queued.mTransition != null) goto L11;
        return;
    L11:
        if (canStartCollectingNow(queued.mTransition) == true) goto L14;
        return;
    L14:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[1] == false) goto L16;
        long protoLogParam0 = this.mCollectingTransition.getSyncId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, -1611886029896664304L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L16:
        this.mWaitingTransitions.add(this.mCollectingTransition);
        this.mCollectingTransition = null;
    L20:
        this.mQueuedTransitions.remove(0);
        if (queued.mTransition == null) goto L23;
        moveToCollecting(queued.mTransition);
    L25:
        if (queued.mTransition != null) goto L27;
    L29:
        this.mAtm.mH.post(new TransitionController$$ExternalSyntheticLambda7(this, queued));
        return;
    L27:
        if (queued.mTransition.mType != 12) goto L29;
        queued.mOnStartCollect.onCollectStarted(true);
        return;
    L23:
        this.mSyncEngine.startSyncSet(queued.mLegacySync);
        goto L25
    L18:
        if (this.mSyncEngine.hasActiveSync() == false) goto L20;
    }

    private /* synthetic */ void lambda$tryStartCollectFromQueue$5(QueuedTransition queued) {
        WindowManagerGlobalLock r0 = this.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        queued.mOnStartCollect.onCollectStarted(true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void moveToPlaying(Transition transition) {
        if (transition != this.mCollectingTransition) goto L11;
        this.mCollectingTransition = null;
        if (this.mWaitingTransitions.isEmpty() == true) goto L8;
        this.mCollectingTransition = this.mWaitingTransitions.remove(0);
    L8:
        if (this.mCollectingTransition != null) goto L12;
        this.mLatestOnTopTasksReported.clear();
    L12:
        this.mPlayingTransitions.add(transition);
        updateRunningRemoteAnimation(transition, true);
        return;
    L11:
        if (this.mWaitingTransitions.remove(transition) == true) goto L12;
        throw new IllegalStateException("Trying to move non-collecting transition toplaying " + transition.getSyncId());
    }

    boolean getCanBeIndependent(Transition collecting, Transition queued) {
        if (queued == null) goto L10;
        if (queued.mParallelCollectType != 1) goto L10;
        if (collecting.mParallelCollectType != 1) goto L10;
        return true;
    L10:
        if (queued == null) goto L34;
        if (queued.mParallelCollectType != 2) goto L34;
        if (collecting.mParallelCollectType != 2) goto L16;
        return false;
    L16:
        int i = 0;
    L18:
        if (i >= collecting.mParticipants.size()) goto L32;
        WindowContainer wc = collecting.mParticipants.valueAt(i);
        ActivityRecord ar = wc.asActivityRecord();
        if (ar == null) goto L22;
    L26:
        if (ar == null) goto L30;
        if (ar.isActivityTypeHomeOrRecents() == false) goto L30;
        return false;
    L30:
        i = i + 1;
        goto L18
    L22:
        if (wc.asWindowState() != null) goto L26;
        if (wc.asWindowToken() != null) goto L26;
        return false;
    L32:
        return true;
    L34:
        if (collecting.mParallelCollectType != 2) goto L36;
        return false;
    L36:
        return false;
    }

    static boolean getIsIndependent(Transition running, Transition incoming) {
        if (running.mParallelCollectType != 1) goto L8;
        if (incoming.mParallelCollectType != 1) goto L8;
        return true;
    L8:
        if (running.mParallelCollectType != 2) goto L16;
        if (running.hasTransientLaunch() == false) goto L16;
        if (incoming.mParallelCollectType != 2) goto L14;
        return false;
    L14:
        Transition recents = running;
        Transition other = incoming;
    L20:
        int i = 0;
    L22:
        if (i >= other.mTargets.size()) goto L36;
        WindowContainer wc = other.mTargets.get(i).mContainer;
        ActivityRecord ar = wc.asActivityRecord();
        if (ar == null) goto L26;
    L30:
        if (ar == null) goto L34;
        if (recents.isTransientLaunch(ar) == false) goto L34;
        return false;
    L34:
        i = i + 1;
        goto L22
    L26:
        if (wc.asWindowState() != null) goto L30;
        if (wc.asWindowToken() != null) goto L30;
        return false;
    L36:
        return true;
    L16:
        if (incoming.mParallelCollectType == 2) goto L18;
    L37:
        return false;
    L18:
        if (incoming.hasTransientLaunch() == false) goto L37;
        recents = incoming;
        other = running;
        goto L20
    }

    void assignTrack(Transition transition, android.window.TransitionInfo info) {
        int track = -1;
        boolean sync = false;
        int i = 0;
    L4:
        if (i >= this.mPlayingTransitions.size()) goto L20;
        if (this.mPlayingTransitions.get(i) == transition) goto L19;
        if (this.mExt.makeIndependentTrackIfNeed(this.mPlayingTransitions.get(i), transition, info, track) == true) goto L19;
        if (getIsIndependent(this.mPlayingTransitions.get(i), transition) == true) goto L19;
        if (track >= 0) goto L17;
        track = this.mPlayingTransitions.get(i).mAnimationTrack;
        goto L19
    L17:
        if (track == this.mPlayingTransitions.get(i).mAnimationTrack) goto L19;
        sync = true;
    L19:
        i = i + 1;
    L20:
        if (sync == false) goto L23;
        track = 0;
    L23:
        if (track >= 0) goto L29;
        track = this.mTrackCount;
        if (track <= 0) goto L29;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L29;
        long protoLogParam0 = transition.getSyncId();
        long protoLogParam1 = track;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -7097461682459496366L, 5, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1)});
    L29:
        transition.mAnimationTrack = track;
        info.setTrack(track);
        this.mTrackCount = Math.max(this.mTrackCount, track + 1);
        if (sync == true) goto L32;
        return;
    L32:
        if (this.mTrackCount <= 1) goto L45;
        info.setFlags(info.getFlags() | 2097152);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L46;
        long protoLogParam2 = transition.getSyncId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -7364464699035275052L, 1, new Object[]{Long.valueOf(protoLogParam2)});
        return;
    L46:
        return;
    }

    boolean isAnimating() {
        return this.mAnimatingState;
    }

    void updateAnimatingState() {
        if (this.mPlayingTransitions.isEmpty() == true) goto L5;
    L10:
        boolean animatingState = true;
    L12:
        if (animatingState == true) goto L14;
    L30:
        if (animatingState == false) goto L32;
        return;
    L32:
        if (this.mAnimatingState == false) goto L46;
        int i = this.mAtm.mRootWindowContainer.getChildCount() - 1;
    L34:
        if (i < 0) goto L36;
        this.mAtm.mRootWindowContainer.getChildAt(i).enableHighPerfTransition(false);
        i = i - 1;
        goto L34
    L36:
        this.mAtm.mWindowManager.scheduleAnimationLocked();
        this.mSnapshotController.setPause(false);
        this.mAnimatingState = false;
        Transition.asyncTraceEnd(68942577);
        return;
    L46:
        return;
    L14:
        if (this.mAnimatingState == true) goto L30;
        int i2 = this.mAtm.mRootWindowContainer.getChildCount() - 1;
    L16:
        if (i2 < 0) goto L29;
        DisplayContent dc = this.mAtm.mRootWindowContainer.getChildAt(i2);
        if (this.mCollectingTransition != null) goto L20;
    L22:
        int j = this.mPlayingTransitions.size() - 1;
    L23:
        if (j < 0) goto L28;
        if (this.mPlayingTransitions.get(j).shouldUsePerfHint(dc) == true) goto L26;
        j = j - 1;
        goto L23
    L26:
        dc.enableHighPerfTransition(true);
    L28:
        i2 = i2 - 1;
        goto L16
    L20:
        if (this.mCollectingTransition.shouldUsePerfHint(dc) == false) goto L22;
        dc.enableHighPerfTransition(true);
        goto L28
    L29:
        this.mSnapshotController.setPause(true);
        this.mAnimatingState = true;
        Transition.asyncTraceBegin("animating", 68942577);
        return;
    L5:
        if (this.mCollectingTransition != null) goto L7;
    L9:
        animatingState = false;
        goto L12
    L7:
        if (this.mCollectingTransition.isStarted() == false) goto L9;
        goto L9
    }

    private void updateRunningRemoteAnimation(Transition transition, boolean isPlaying) {
        if (this.mTransitionPlayers.isEmpty() == false) goto L5;
        return;
    L5:
        TransitionPlayerRecord record = (TransitionPlayerRecord) this.mTransitionPlayers.getLast();
        if (TransitionPlayerRecord.m10345$$Nest$fgetmPlayerProc(record) != null) goto L8;
        return;
    L8:
        if (isPlaying == false) goto L11;
        TransitionPlayerRecord.m10345$$Nest$fgetmPlayerProc(record).setRunningRemoteAnimation(true);
        return;
    L11:
        if (this.mPlayingTransitions.isEmpty() == false) goto L15;
        TransitionPlayerRecord.m10345$$Nest$fgetmPlayerProc(record).setRunningRemoteAnimation(false);
        this.mRemotePlayer.clear();
        return;
    }

    void onAbort(Transition transition) {
        if (transition == this.mCollectingTransition) goto L9;
        int waitingIdx = this.mWaitingTransitions.indexOf(transition);
        if (waitingIdx < 0) goto L8;
        this.mWaitingTransitions.remove(waitingIdx);
    L15:
        this.mExt.onAbortTransition();
        return;
    L8:
        throw new IllegalStateException("Too late for abort.");
    L9:
        this.mCollectingTransition = null;
        if (this.mWaitingTransitions.isEmpty() == true) goto L13;
        this.mCollectingTransition = this.mWaitingTransitions.remove(0);
    L13:
        if (this.mCollectingTransition != null) goto L15;
        this.mLatestOnTopTasksReported.clear();
        goto L15
    }

    void setTransientLaunch(ActivityRecord activity, Task restoreBelowTask) {
        if (this.mCollectingTransition != null) goto L5;
        return;
    L5:
        this.mCollectingTransition.setTransientLaunch(activity, restoreBelowTask);
    }

    void legacyDetachNavigationBarFromApp(IBinder token) {
        Transition transition = Transition.fromBinder(token);
        if (transition != null) goto L5;
    L9:
        Slog.e(TAG, "Transition isn't playing: " + token);
        return;
    L5:
        if (this.mPlayingTransitions.contains(transition) == false) goto L9;
        transition.legacyRestoreNavigationBarFromApp();
    }

    void registerLegacyListener(WindowManagerInternal.AppTransitionListener listener) {
        this.mLegacyListeners.add(listener);
    }

    void unregisterLegacyListener(WindowManagerInternal.AppTransitionListener listener) {
        this.mLegacyListeners.remove(listener);
    }

    private static boolean shouldDispatchLegacyListener(WindowManagerInternal.AppTransitionListener listener, int displayId) {
        if (listener.mTargetDisplayId != (-1)) goto L5;
    L8:
        return true;
    L5:
        if (listener.mTargetDisplayId == displayId) goto L8;
        return false;
    }

    void dispatchLegacyAppTransitionPending(int displayId) {
        int i = 0;
    L4:
        if (i >= this.mLegacyListeners.size()) goto L10;
        WindowManagerInternal.AppTransitionListener listener = this.mLegacyListeners.get(i);
        if (shouldDispatchLegacyListener(listener, displayId) == false) goto L8;
        listener.onAppTransitionPendingLocked();
    L8:
        i = i + 1;
        goto L4
    }

    void dispatchLegacyAppTransitionStarting(DisplayContent[] participantDisplays, long statusBarTransitionDelay) {
        long now = SystemClock.uptimeMillis();
        int i = 0;
    L4:
        if (i >= this.mLegacyListeners.size()) goto L14;
        WindowManagerInternal.AppTransitionListener listener = this.mLegacyListeners.get(i);
        int j = 0;
    L7:
        if (j >= participantDisplays.length) goto L12;
        int displayId = participantDisplays[j].mDisplayId;
        if (shouldDispatchLegacyListener(listener, displayId) == false) goto L11;
        listener.onAppTransitionStartingLocked(now + statusBarTransitionDelay, 120);
    L11:
        j = j + 1;
        goto L7
    L12:
        i = i + 1;
        goto L4
    }

    void dispatchLegacyAppTransitionFinished(ActivityRecord ar) {
        int i = 0;
    L4:
        if (i >= this.mLegacyListeners.size()) goto L10;
        WindowManagerInternal.AppTransitionListener listener = this.mLegacyListeners.get(i);
        if (shouldDispatchLegacyListener(listener, ar.getDisplayId()) == false) goto L8;
        listener.onAppTransitionFinishedLocked(ar.token);
    L8:
        i = i + 1;
        goto L4
    L10:
        if (ar == null) goto L16;
        SysOptBridge.getFactory().getOAutoHelper().onAppTransitionFinished(ar.mActivityComponent);
        return;
    }

    void dispatchLegacyAppTransitionCancelled(ArrayList<DisplayContent> targetDisplays) {
        int i = 0;
    L4:
        if (i >= targetDisplays.size()) goto L14;
        int displayId = targetDisplays.get(i).mDisplayId;
        int j = 0;
    L7:
        if (j >= this.mLegacyListeners.size()) goto L12;
        WindowManagerInternal.AppTransitionListener listener = this.mLegacyListeners.get(j);
        if (shouldDispatchLegacyListener(listener, displayId) == false) goto L11;
        listener.onAppTransitionCancelledLocked(false);
    L11:
        j = j + 1;
        goto L7
    L12:
        i = i + 1;
        goto L4
    }

    void dumpDebugLegacy(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        int state = 0;
        if (this.mPlayingTransitions.isEmpty() == true) goto L6;
        state = 2;
    L12:
        proto.write(1159641169921L, state);
        proto.end(token);
        return;
    L6:
        if (this.mCollectingTransition == null) goto L10;
        if (this.mCollectingTransition.getLegacyIsReady() == false) goto L10;
    L11:
        state = 1;
    L10:
        if (this.mSyncEngine.hasPendingSyncSets() == false) goto L12;
        goto L11
    }

    private void queueTransition(Transition transit, OnStartCollect onStartCollect) {
        this.mQueuedTransitions.add(new QueuedTransition(transit, onStartCollect));
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[1] == false) goto L6;
        String protoLogParam0 = String.valueOf(transit);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, -5509640937151643757L, 0, new Object[]{protoLogParam0});
        return;
    }

    boolean startCollectOrQueue(Transition transit, OnStartCollect onStartCollect) {
        if (this.mQueuedTransitions.isEmpty() == true) goto L7;
        queueTransition(transit, onStartCollect);
        return false;
    L7:
        if (this.mSyncEngine.hasActiveSync() == true) goto L9;
        moveToCollecting(transit);
        onStartCollect.onCollectStarted(false);
        return true;
    L9:
        if (isCollecting() == true) goto L11;
        Slog.w(TAG, "Ongoing Sync outside of transition.");
    L18:
        queueTransition(transit, onStartCollect);
        return false;
    L11:
        if (canStartCollectingNow(transit) == false) goto L18;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[1] == false) goto L15;
        long protoLogParam0 = this.mCollectingTransition.getSyncId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, -1611886029896664304L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L15:
        this.mWaitingTransitions.add(this.mCollectingTransition);
        this.mCollectingTransition = null;
        moveToCollecting(transit);
        onStartCollect.onCollectStarted(false);
        return true;
    }

    Transition createAndStartCollecting(int type) {
        if (this.mTransitionPlayers.isEmpty() == false) goto L6;
        return null;
    L6:
        if (this.mQueuedTransitions.isEmpty() == true) goto L9;
        return null;
    L9:
        if (this.mSyncEngine.hasActiveSync() == true) goto L11;
        Transition transit = new Transition(type, 0, this, this.mSyncEngine);
        moveToCollecting(transit);
        return transit;
    L11:
        if (isCollecting() == true) goto L13;
        Slog.w(TAG, "Ongoing Sync outside of transition.");
    L20:
        return null;
    L13:
        if (canStartCollectingNow(null) == false) goto L20;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[1] == false) goto L17;
        long protoLogParam0 = this.mCollectingTransition.getSyncId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, -1611886029896664304L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L17:
        this.mWaitingTransitions.add(this.mCollectingTransition);
        this.mCollectingTransition = null;
        Transition transit2 = new Transition(type, 0, this, this.mSyncEngine);
        moveToCollecting(transit2);
        return transit2;
    }

    void startLegacySyncOrQueue(BLASTSyncEngine.SyncGroup syncGroup, final Consumer<Boolean> applySync) {
        if (this.mQueuedTransitions.isEmpty() == true) goto L5;
    L9:
        this.mQueuedTransitions.add(new QueuedTransition(syncGroup, new TransitionController$$ExternalSyntheticLambda1(applySync)));
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[1] == false) goto L13;
        String protoLogParam0 = String.valueOf(syncGroup.mSyncId);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, -2741593375634604522L, 0, new Object[]{protoLogParam0});
        return;
    L13:
        return;
    L5:
        if (this.mSyncEngine.hasActiveSync() == true) goto L9;
        this.mSyncEngine.startSyncSet(syncGroup);
        applySync.accept(false);
    }

    private static /* synthetic */ void lambda$startLegacySyncOrQueue$6(Consumer applySync, boolean deferred) {
        applySync.accept(true);
    }

    void waitFor(Transition.ReadyCondition condition) {
        if (this.mCollectingTransition != null) goto L6;
        Slog.e(TAG, "No collecting transition available to wait for " + condition);
        condition.mTracker = Transition.ReadyTracker.NULL_TRACKER;
        return;
    L6:
        this.mCollectingTransition.mReadyTracker.add(condition);
    }

    public IExtTransitionController getExt() {
        return this.mExt;
    }
}
