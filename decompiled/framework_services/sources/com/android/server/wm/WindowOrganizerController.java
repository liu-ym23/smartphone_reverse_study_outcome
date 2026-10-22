package com.android.server.wm;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.IApplicationThread;
import android.app.WindowConfiguration;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.pico.utils.ExtImplFactory;
import android.pico.utils.Features;
import android.util.AndroidRuntimeException;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import android.view.SurfaceControl;
import android.window.IDisplayAreaOrganizerController;
import android.window.ITaskFragmentOrganizer;
import android.window.ITaskFragmentOrganizerController;
import android.window.ITaskOrganizerController;
import android.window.ITransitionMetricsReporter;
import android.window.ITransitionPlayer;
import android.window.IWindowContainerTransactionCallback;
import android.window.IWindowOrganizerController;
import android.window.KeyguardState;
import android.window.RemoteTransition;
import android.window.TaskFragmentAnimationParams;
import android.window.TaskFragmentCreationParams;
import android.window.TaskFragmentOperation;
import android.window.TaskFragmentOrganizerToken;
import android.window.WindowContainerTransaction;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.ArrayUtils;
import com.android.server.LocalServices;
import com.android.server.pm.LauncherAppsService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.IntSupplier;

/* JADX INFO: loaded from: classes3.dex */
class WindowOrganizerController extends IWindowOrganizerController.Stub implements BLASTSyncEngine.TransactionReadyListener {
    static final int CONTROLLABLE_CONFIGS = 536886272;
    static final int CONTROLLABLE_WINDOW_CONFIGS = 3;
    private static final String TAG = "WindowOrganizerController";
    private static final int TRANSACT_EFFECTS_CLIENT_CONFIG = 1;
    private static final int TRANSACT_EFFECTS_LIFECYCLE = 2;
    private static final int TRANSACT_EFFECTS_NONE = 0;
    final DisplayAreaOrganizerController mDisplayAreaOrganizerController;
    private final IExtWindowOrganizerController mExt;
    private final WindowManagerGlobalLock mGlobalLock;
    final ArrayMap<IBinder, TaskFragment> mLaunchTaskFragments;
    private final ActivityTaskManagerService mService;
    final TaskFragmentOrganizerController mTaskFragmentOrganizerController;
    final TaskOrganizerController mTaskOrganizerController;
    private final Rect mTmpBounds0;
    private final Rect mTmpBounds1;
    private final HashMap<Integer, IWindowContainerTransactionCallback> mTransactionCallbacksByPendingSyncId;
    final TransitionController mTransitionController;

    static class CallerInfo {
        final int mPid;
        final int mUid;

        CallerInfo() {
            this.mPid = Binder.getCallingPid();
            this.mUid = Binder.getCallingUid();
        }
    }

    public static /* synthetic */ boolean $r8$lambda$0jPpOpE0KaZXZ2qFWEzMN2yLo98(ActivityRecord r0) {
        return lambda$applyHierarchyOp$12(r0);
    }

    public static /* synthetic */ void $r8$lambda$8d9_x7_Du45xectPDKleAjMDJeE(WindowOrganizerController r0, Integer[] r1, IntSupplier r2) {
        r0.lambda$waitAsyncStart$16(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$AD2MPA0QXJINMphkkcN5vOFItf0(WindowOrganizerController r0, CallerInfo r1, int r2, SafeActivityOptions r3) {
        r0.lambda$applyHierarchyOp$9(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$CqMF4NAe0iny9zkgVnq-tEX-_ko, reason: not valid java name */
    public static /* synthetic */ boolean m10459$r8$lambda$CqMF4NAe0iny9zkgVnqtEX_ko(WindowOrganizerController r0, WindowContainer r1, boolean r2, TaskDisplayArea r3, WindowContainerTransaction.HierarchyOp r4, WindowContainer r5, boolean r6, ArrayList r7, Task r8) {
        return r0.lambda$reparentChildrenTasksHierarchyOp$17(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ void $r8$lambda$Ktd0mEZGGdp2G6sUrqEz1G5ckL0(WindowOrganizerController r0, BLASTSyncEngine.SyncGroup r1) {
        r0.lambda$applySyncTransaction$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$OxMmVYZeM4xJh7uJ-Y5zE6BDr8Y, reason: not valid java name */
    public static /* synthetic */ void m10460$r8$lambda$OxMmVYZeM4xJh7uJY5zE6BDr8Y(WindowOrganizerController r0, Transition r1, WindowContainerTransaction r2, CallerInfo r3, Transition.ReadyCondition r4) {
        r0.lambda$startTransition$4(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$PHnU0rj5Bcvaq0dL-Wi7kOJt8bo, reason: not valid java name */
    public static /* synthetic */ void m10461$r8$lambda$PHnU0rj5Bcvaq0dLWi7kOJt8bo(WindowOrganizerController r0, Transition r1, WindowContainerTransaction r2, CallerInfo r3, Transition.ReadyCondition r4, boolean r5, boolean r6) {
        r0.lambda$startTransition$3(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ int $r8$lambda$PqaMrwBdr5Z3EFqe72YAi5civRg(WindowOrganizerController r0, WindowContainerTransaction.HierarchyOp r1, String r2, Bundle r3) {
        return r0.lambda$applyHierarchyOp$11(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$Qfk2nr1p-IF57av2LSCrKkQbZA8, reason: not valid java name */
    public static /* synthetic */ int m10462$r8$lambda$Qfk2nr1pIF57av2LSCrKkQbZA8(WindowOrganizerController r0, TaskFragment r1, Intent r2, SafeActivityOptions r3, IBinder r4, CallerInfo r5, IBinder r6) {
        return r0.lambda$applyTaskFragmentOperation$14(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$WpZsgFsQkKfWbC5KpiRgRygDo0M(WindowContainerTransaction.Change r0, int[] r1, Object r2) {
        lambda$applyDisplayAreaChanges$8(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ybmy-E-M1tPXxhrIFOlsOwhYFV8, reason: not valid java name */
    public static /* synthetic */ int m10463$r8$lambda$YbmyEM1tPXxhrIFOlsOwhYFV8(WindowOrganizerController r0, CallerInfo r1, int r2, SafeActivityOptions r3) {
        return r0.lambda$applyHierarchyOp$10(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$_qIY3pHTXmmWFLnir9p_l7-nDe4, reason: not valid java name */
    public static /* synthetic */ boolean m10464$r8$lambda$_qIY3pHTXmmWFLnir9p_l7nDe4(ActivityRecord r0) {
        return lambda$applyTaskFragmentOperation$13(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$b6Ho-cI4nosNJGhhnIqATtTV08w, reason: not valid java name */
    public static /* synthetic */ void m10465$r8$lambda$b6HocI4nosNJGhhnIqATtTV08w(int r0, ActivityRecord r1) {
        lambda$applyTaskChanges$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$bKC_sB5Z_Fv5D0RamlN1JR0Y4R4(WindowOrganizerController r0, WindowContainerTransaction r1, int r2, CallerInfo r3) {
        r0.lambda$applySyncTransaction$2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$hkQsQ6KHYw9RJcI5qgr8IGd-uZ4, reason: not valid java name */
    public static /* synthetic */ void m10466$r8$lambda$hkQsQ6KHYw9RJcI5qgr8IGduZ4(WindowOrganizerController r0, WindowContainerTransaction r1, int r2, CallerInfo r3, Boolean r4) {
        r0.lambda$applySyncTransaction$0(r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean $r8$lambda$kNBUQzEPPniKgvkOjaVZPjw5vXM(TaskFragment r0) {
        return lambda$applyTaskFragmentOperation$15(r0);
    }

    public static /* synthetic */ void $r8$lambda$m9eWnLRjueghfq5g6k4aTionPyM(WindowOrganizerController r0, WindowContainerTransaction r1, Transition r2, CallerInfo r3, RemoteTransition r4, boolean r5) {
        r0.lambda$applyTaskFragmentTransactionLocked$5(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$ypsTPIe3s2bFHjQZlRM_7n4LFuQ(ActivityRecord r0) {
        lambda$applyTransaction$6(r0);
    }

    WindowOrganizerController(ActivityTaskManagerService atm) {
        this.mTransactionCallbacksByPendingSyncId = new HashMap();
        this.mLaunchTaskFragments = new ArrayMap();
        this.mTmpBounds0 = new Rect();
        this.mTmpBounds1 = new Rect();
        this.mExt = (IExtWindowOrganizerController) ExtImplFactory.getImpl(IExtWindowOrganizerController.class, new Object[]{this});
        this.mService = atm;
        this.mGlobalLock = atm.mGlobalLock;
        this.mTaskOrganizerController = new TaskOrganizerController(this.mService);
        this.mDisplayAreaOrganizerController = new DisplayAreaOrganizerController(this.mService);
        this.mTaskFragmentOrganizerController = new TaskFragmentOrganizerController(atm, this);
        this.mTransitionController = new TransitionController(atm);
    }

    TransitionController getTransitionController() {
        return this.mTransitionController;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        return super.onTransact(code, data, reply, flags);
    L4:
        e = move-exception;
        throw ActivityTaskManagerService.logAndRethrowRuntimeExceptionOnTransact(TAG, e);
    }

    public void applyTransaction(WindowContainerTransaction t) {
        if (t == null) goto L20;
        ActivityTaskManagerService.enforceTaskPermission("applyTransaction()");
        CallerInfo caller = new CallerInfo();
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r3 = this.mGlobalLock;     // Catch: Throwable -> L11
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L11
        monitor-enter(r3);     // Catch: Throwable -> L11
        ActionChain chain = this.mService.mChainTracker.startLegacy("applyTransactLegacy");     // Catch: Throwable -> L13
        applyTransaction(t, -1, chain, caller);     // Catch: Throwable -> L13
        monitor-exit(r3);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(ident);
        return;
    L13:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L20:
        throw new IllegalArgumentException("Null transaction passed to applyTransaction");
    }

    public int applySyncTransaction(final WindowContainerTransaction t, IWindowContainerTransactionCallback callback) {
        if (t == null) goto L30;
        ActivityTaskManagerService.enforceTaskPermission("applySyncTransaction()");
        final CallerInfo caller = new CallerInfo();
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r3 = this.mGlobalLock;     // Catch: Throwable -> L26
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L26
        monitor-enter(r3);     // Catch: Throwable -> L26
        if (callback != null) goto L13;
        ActionChain chain = this.mService.mChainTracker.startLegacy("applySyncLegacy");     // Catch: Throwable -> L11
        applyTransaction(t, -1, chain, caller);     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return -1;
    L13:
        final BLASTSyncEngine.SyncGroup syncGroup = prepareSyncWithOrganizer(callback);     // Catch: Throwable -> L11
        final int syncId = syncGroup.mSyncId;     // Catch: Throwable -> L11
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L17;
        this.mTransitionController.startLegacySyncOrQueue(syncGroup, new WindowOrganizerController$$ExternalSyntheticLambda4(this, t, syncId, caller));     // Catch: Throwable -> L11
    L20:
        monitor-exit(r3);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return syncId;
    L17:
        if (this.mService.mWindowManager.mSyncEngine.hasActiveSync() == true) goto L19;
        this.mService.mWindowManager.mSyncEngine.startSyncSet(syncGroup);     // Catch: Throwable -> L11
        applyTransaction(t, syncId, this.mService.mChainTracker.startLegacy("applySyncLegacy"), caller);     // Catch: Throwable -> L11
        setSyncReady(syncId);     // Catch: Throwable -> L11
        goto L20
    L19:
        this.mService.mWindowManager.mSyncEngine.queueSyncSet(new WindowOrganizerController$$ExternalSyntheticLambda5(this, syncGroup), new WindowOrganizerController$$ExternalSyntheticLambda6(this, t, syncId, caller));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L30:
        throw new IllegalArgumentException("Null transaction passed to applySyncTransaction");
    }

    private /* synthetic */ void lambda$applySyncTransaction$0(WindowContainerTransaction t, int syncId, CallerInfo caller, Boolean deferred) {
        applyTransaction(t, syncId, this.mService.mChainTracker.startLegacy("applySyncLegacy"), caller, deferred.booleanValue());
        setSyncReady(syncId);
    }

    private /* synthetic */ void lambda$applySyncTransaction$1(BLASTSyncEngine.SyncGroup syncGroup) {
        this.mService.mWindowManager.mSyncEngine.startSyncSet(syncGroup);
    }

    private /* synthetic */ void lambda$applySyncTransaction$2(WindowContainerTransaction t, int syncId, CallerInfo caller) {
        applyTransaction(t, syncId, this.mService.mChainTracker.startLegacy("applySyncLegacy"), caller);
        setSyncReady(syncId);
    }

    public IBinder startNewTransition(int type, WindowContainerTransaction t) {
        return startTransition(type, null, t);
    }

    public void startTransition(IBinder transitionToken, WindowContainerTransaction t) {
        startTransition(-1, transitionToken, t);
    }

    private IBinder startTransition(int type, IBinder transitionToken, WindowContainerTransaction t) {
        ActivityTaskManagerService.enforceTaskPermission("startTransition()");
        final CallerInfo caller = new CallerInfo();
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r12 = this.mGlobalLock;     // Catch: Throwable -> L57
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L57
        monitor-enter(r12);     // Catch: Throwable -> L57
        final Transition transition = Transition.fromBinder(transitionToken);     // Catch: Throwable -> L14
        if (this.mTransitionController.getTransitionPlayer() != null) goto L18;
        if (transition != null) goto L18;
        Slog.w(TAG, "Using shell transitions API for legacy transitions.");     // Catch: Throwable -> L14
        if (t == null) goto L17;
        applyTransaction(t, -1, this.mService.mChainTracker.startLegacy("wrongLegacyTransit"), caller);     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return null;
    L17:
        throw new IllegalArgumentException("Can't use legacy transitions in compatibility mode with no WCT.");     // Catch: Throwable -> L14
    L18:
        if (t == null) goto L20;
        final WindowContainerTransaction wct = t;
    L21:
        if (transition != null) goto L34;
        if (type < 0) goto L32;
        if (t == null) goto L26;
        final boolean needsSetReady = true;
    L27:
        final Transition nextTransition = new Transition(type, 0, this.mTransitionController, this.mService.mWindowManager.mSyncEngine);     // Catch: Throwable -> L14
        final Transition.ReadyCondition wctApplied = new Transition.ReadyCondition("start WCT applied");     // Catch: Throwable -> L14
        nextTransition.mReadyTracker.add(wctApplied);     // Catch: Throwable -> L14
        nextTransition.calcParallelCollectType(wct);     // Catch: Throwable -> L14
        this.mTransitionController.startCollectOrQueue(nextTransition, new WindowOrganizerController$$ExternalSyntheticLambda17(this, nextTransition, wct, caller, wctApplied, needsSetReady));     // Catch: Throwable -> L14
        IBinder r4 = nextTransition.getToken();     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return r4;
    L26:
        needsSetReady = false;
        goto L27
    L32:
        throw new IllegalArgumentException("Can't create transition with no type");     // Catch: Throwable -> L14
    L34:
        if (transition.isCollecting() == false) goto L36;
    L41:
        if (t == null) goto L43;
        Transition.ReadyCondition wctApplied2 = new Transition.ReadyCondition("start WCT applied");     // Catch: Throwable -> L14
        transition.mReadyTracker.add(wctApplied2);     // Catch: Throwable -> L14
        final Transition.ReadyCondition wctApplied3 = wctApplied2;
    L44:
        transition.mLogger.mStartWCT = wct;     // Catch: Throwable -> L14
        if (transition.shouldApplyOnDisplayThread() == false) goto L47;
        this.mService.mH.post(new WindowOrganizerController$$ExternalSyntheticLambda18(this, transition, wct, caller, wctApplied3));     // Catch: Throwable -> L14
    L50:
        IBinder r3 = transition.getToken();     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return r3;
    L47:
        ActionChain chain = this.mService.mChainTracker.start("startTransit", transition);     // Catch: Throwable -> L14
        transition.start();     // Catch: Throwable -> L14
        applyTransaction(wct, -1, chain, caller);     // Catch: Throwable -> L14
        if (wctApplied3 == null) goto L50;
        wctApplied3.meet();     // Catch: Throwable -> L14
        goto L50
    L43:
        wctApplied3 = null;
        goto L44
    L36:
        if (transition.isForcePlaying() == true) goto L41;
        Slog.e(TAG, "Trying to start a transition that isn't collecting. This probably means Shell took too long to respond to a request. WM State may be incorrect now, please file a bug");     // Catch: Throwable -> L14
        ActionChain chain2 = this.mService.mChainTracker.startFailsafe("startTransit");     // Catch: Throwable -> L14
        chain2.mTransition = null;     // Catch: Throwable -> L14
        applyTransaction(wct, -1, chain2, caller);     // Catch: Throwable -> L14
        IBinder r5 = transition.getToken();     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return r5;
    L20:
        wct = new WindowContainerTransaction();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L57
        throw th;     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private /* synthetic */ void lambda$startTransition$3(Transition nextTransition, WindowContainerTransaction wct, CallerInfo caller, Transition.ReadyCondition wctApplied, boolean needsSetReady, boolean deferred) {
        ActionChain chain = this.mService.mChainTracker.start("startNewTransit", nextTransition);
        nextTransition.start();
        nextTransition.mLogger.mStartWCT = wct;
        applyTransaction(wct, -1, chain, caller, deferred);
        wctApplied.meet();
        if (needsSetReady == false) goto L6;
        setAllReadyIfNeeded(nextTransition, wct);
        return;
    }

    private /* synthetic */ void lambda$startTransition$4(Transition transition, WindowContainerTransaction wct, CallerInfo caller, Transition.ReadyCondition wctApplied) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActionChain chain = this.mService.mChainTracker.start("startTransit", transition);     // Catch: Throwable -> L7
        transition.start();     // Catch: Throwable -> L7
        applyTransaction(wct, -1, chain, caller);     // Catch: Throwable -> L7
        if (wctApplied == null) goto L9;
        wctApplied.meet();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static boolean hasActivityLaunch(WindowContainerTransaction wct) {
        int i = 0;
    L4:
        if (i >= wct.getHierarchyOps().size()) goto L15;
        WindowContainerTransaction.HierarchyOp op = (WindowContainerTransaction.HierarchyOp) wct.getHierarchyOps().get(i);
        if (op.getType() == 5) goto L13;
        if (op.getType() != 7) goto L12;
        if (op.getPendingIntent().isActivity() == false) goto L12;
        return true;
    L12:
        i = i + 1;
        goto L4
    L13:
        return true;
    L15:
        return false;
    }

    private boolean isCreatedTaskFragmentReady(WindowContainerTransaction wct) {
        int i = 0;
    L4:
        if (i >= wct.getHierarchyOps().size()) goto L17;
        WindowContainerTransaction.HierarchyOp op = (WindowContainerTransaction.HierarchyOp) wct.getHierarchyOps().get(i);
        if (op.getType() != 17) goto L16;
        if (op.getTaskFragmentOperation().getOpType() != 0) goto L16;
        IBinder tfToken = op.getTaskFragmentOperation().getTaskFragmentCreationParams().getFragmentToken();
        TaskFragment taskFragment = getTaskFragment(tfToken);
        if (taskFragment == null) goto L16;
        if (taskFragment.isReadyToTransit() == true) goto L16;
        return false;
    L16:
        i = i + 1;
        goto L4
    L17:
        return true;
    }

    private void setAllReadyIfNeeded(Transition transition, WindowContainerTransaction wct) {
        if (hasActivityLaunch(wct) == false) goto L8;
        if (this.mService.mRootWindowContainer.allPausedActivitiesComplete() == true) goto L8;
        return;
    L8:
        if (isCreatedTaskFragmentReady(wct) == true) goto L11;
        return;
    L11:
        if (transition.mType != 14) goto L16;
        if (this.mService.mBackNavigationController.restoreBackNavigationSetTransitionReady(transition) == false) goto L16;
        return;
    L16:
        if (transition.mType != 2000) goto L18;
        return;
    L18:
        transition.setAllReady();
    }

    public void finishTransition(IBinder transitionToken, WindowContainerTransaction t) {
        ActivityTaskManagerService.enforceTaskPermission("finishTransition()");
        CallerInfo caller = new CallerInfo();
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r3 = this.mGlobalLock;     // Catch: Throwable -> L15
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L15
        monitor-enter(r3);     // Catch: Throwable -> L15
        Transition transition = Transition.fromBinder(transitionToken);     // Catch: Throwable -> L8
        ActionChain chain = this.mService.mChainTracker.startFinish("finishTransit", transition);     // Catch: Throwable -> L8
        if (t == null) goto L10;
        this.mTransitionController.mFinishingTransition = transition;     // Catch: Throwable -> L8
        applyTransaction(t, -1, chain, caller);     // Catch: Throwable -> L8
    L10:
        this.mTransitionController.finishTransition(chain);     // Catch: Throwable -> L8
        this.mTransitionController.mFinishingTransition = null;     // Catch: Throwable -> L8
        monitor-exit(r3);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(ident);
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    void applyTaskFragmentTransactionLocked(final WindowContainerTransaction wct, int type, boolean shouldApplyIndependently, final RemoteTransition remoteTransition) {
        ITaskFragmentOrganizer r0 = wct.getTaskFragmentOrganizer();
        r0.getClass();
        wct.getClass();
        enforceTaskFragmentOrganizerPermission("applyTaskFragmentTransaction()", r0, wct);
        if (remoteTransition != null) goto L5;
    L9:
        final CallerInfo caller = new CallerInfo();
        long ident = Binder.clearCallingIdentity();
    L37:
        th = th;
    L39:
        Binder.restoreCallingIdentity(ident);
        throw th;
    L41:
        if (this.mTransitionController.isShellTransitionsEnabled() == true) goto L20;
        applyTransaction(wct, -1, this.mService.mChainTracker.startLegacy("legacyTFTransact"), caller);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(ident);
        return;
    L20:
        if (this.mService.mWindowManager.mSyncEngine.hasActiveSync() == false) goto L30;
        if (shouldApplyIndependently == true) goto L30;
        ActionChain chain = this.mService.mChainTracker.startDefault("tfTransact");     // Catch: Throwable -> L16
        if (chain.mTransition == null) goto L25;
    L27:
        applyTransaction(wct, -1, chain, caller);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(ident);
        return;
    L25:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[3] == false) goto L27;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 6110791601270766802L, 0, null);     // Catch: Throwable -> L16
    L30:
        final Transition transition = new Transition(type, 0, this.mTransitionController, this.mService.mWindowManager.mSyncEngine);     // Catch: Throwable -> L37
        TransitionController.OnStartCollect doApply = new WindowOrganizerController$$ExternalSyntheticLambda12(this, wct, transition, caller, remoteTransition);     // Catch: Throwable -> L35
        this.mTransitionController.startCollectOrQueue(transition, doApply);     // Catch: Throwable -> L35
        Binder.restoreCallingIdentity(ident);
        return;
    L35:
        th = th;
    L16:
        th = th;
        goto L39
    L5:
        if (this.mTaskFragmentOrganizerController.isSystemOrganizer(wct.getTaskFragmentOrganizer().asBinder()) == true) goto L9;
        throw new SecurityException("Only a system organizer is allowed to use remote transition!");
    }

    private /* synthetic */ void lambda$applyTaskFragmentTransactionLocked$5(WindowContainerTransaction wct, Transition transition, CallerInfo caller, RemoteTransition remoteTransition, boolean deferred) {
        if (deferred == true) goto L4;
    L7:
        ActionChain chain = this.mService.mChainTracker.start("tfTransact", transition);
        int effects = applyTransaction(wct, -1, chain, caller, deferred);
        if (effects == 0) goto L10;
    L14:
        this.mTransitionController.requestStartTransition(transition, null, remoteTransition, null);
        setAllReadyIfNeeded(transition, wct);
        return;
    L10:
        if (transition.mParticipants.isEmpty() == false) goto L14;
        if (remoteTransition != null) goto L14;
        transition.abort();
        return;
    L4:
        if (this.mTaskFragmentOrganizerController.isValidTransaction(wct) == true) goto L7;
        transition.abort();
    }

    private int applyTransaction(WindowContainerTransaction t, int syncId, ActionChain chain, CallerInfo caller, boolean deferred) {
        if (deferred == false) goto L9;
        return applyTransaction(t, syncId, chain, caller);
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to execute deferred applyTransaction", e);
        return 0;
    L9:
        return applyTransaction(t, syncId, chain, caller);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 9541. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private int applyTransaction(android.window.WindowContainerTransaction r26, int r27, com.android.server.wm.ActionChain r28, com.android.server.wm.WindowOrganizerController.CallerInfo r29) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONST (r2v0 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (0 ??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) A[DECLARE_VAR] in method: com.android.server.wm.WindowOrganizerController.applyTransaction(android.window.WindowContainerTransaction, int, com.android.server.wm.ActionChain, com.android.server.wm.WindowOrganizerController$CallerInfo):int, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 954
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.wm.WindowOrganizerController.applyTransaction(android.window.WindowContainerTransaction, int, com.android.server.wm.ActionChain, com.android.server.wm.WindowOrganizerController$CallerInfo):int");
    }

    private static /* synthetic */ void lambda$applyTransaction$6(ActivityRecord r) {
        if (r.isVisibleRequested() == false) goto L6;
        r.ensureActivityConfiguration(true);
        return;
    }

    private int applyChanges(WindowContainer<?> container, WindowContainerTransaction.Change change) {
        int configMask = change.getConfigSetMask() & CONTROLLABLE_CONFIGS;
        int windowMask = change.getWindowSetMask() & 3;
        int effects = 0;
        int windowingMode = change.getWindowingMode();
        if (configMask == 0) goto L33;
        if (windowingMode > (-1)) goto L6;
    L8:
        Configuration c = new Configuration(container.getRequestedOverrideConfiguration());
        c.setTo(change.getConfiguration(), configMask, windowMask);
        if (container.getWindowingMode() == 6) goto L11;
    L26:
        container.onRequestedOverrideConfigurationChanged(c);
    L27:
        effects = 0 | 1;
        if (windowMask == 0) goto L33;
        if (container.isEmbedded() == false) goto L33;
        effects = effects | 2;
        goto L33
    L11:
        if ((change.getConfigSetMask() & 1024) == 0) goto L26;
        Task task = container.asTask();
        if (task == null) goto L26;
        if (c.screenWidthDp != 0) goto L17;
    L25:
        task.mOffsetYForInsets = 0;
        task.mOffsetXForInsets = 0;
        goto L26
    L17:
        if (c.screenHeightDp == 0) goto L25;
        Rect oldBounds = container.getRequestedOverrideBounds();
        Rect newBounds = change.getConfiguration().windowConfiguration.getBounds();
        if (oldBounds.width() == newBounds.width()) goto L21;
    L23:
        task.mOffsetYForInsets = 0;
        task.mOffsetXForInsets = 0;
        goto L26
    L21:
        if (oldBounds.height() != newBounds.height()) goto L23;
        task.mOffsetXForInsets = oldBounds.left - newBounds.left;
        task.mOffsetYForInsets = oldBounds.top - newBounds.top;
        goto L26
    L6:
        if (windowingMode == container.getWindowingMode()) goto L8;
        container.getRequestedOverrideConfiguration().setTo(change.getConfiguration(), configMask, windowMask);
    L33:
        if ((change.getChangeMask() & 1) != 0) goto L35;
    L37:
        if (windowingMode > (-1)) goto L39;
        return effects;
    L39:
        if (this.mService.isInLockTaskMode() == false) goto L47;
        if (WindowConfiguration.inMultiWindowMode(windowingMode) == false) goto L47;
        if (container.isEmbedded() == true) goto L47;
        Slog.w(TAG, "Dropping unsupported request to set multi-window windowing mode during locked task mode.");
        return effects;
    L47:
        if (windowingMode != 2) goto L49;
        return effects;
    L49:
        int prevMode = container.getRequestedOverrideWindowingMode();
        if (container.asTask() != null) goto L52;
    L54:
        container.setWindowingMode(windowingMode);
    L56:
        if (prevMode != container.getWindowingMode()) goto L58;
        return effects;
    L58:
        return effects | 2;
    L52:
        if (container.asTask().isRootTask() == false) goto L54;
        container.asTask().setRootTaskWindowingMode(windowingMode);
        goto L56
    L35:
        if (container.setFocusable(change.getFocusable()) == false) goto L37;
        effects = effects | 2;
        goto L37
    }

    private int applyTaskChanges(Task tr, WindowContainerTransaction.Change c) {
        SurfaceControl.Transaction t = c.getBoundsChangeTransaction();
        if (t == null) goto L5;
        tr.setMainWindowSizeChangeTransaction(t);
    L5:
        int effects = applyChanges(tr, c);
        if ((c.getChangeMask() & 8) == 0) goto L11;
        if (tr.setForceHidden(2, c.getHidden()) == false) goto L11;
        effects = effects | 2;
    L11:
        if ((c.getChangeMask() & 64) == 0) goto L16;
        if (tr.setForceTranslucent(c.getForceTranslucent()) == false) goto L16;
        effects = effects | 2;
    L16:
        if ((c.getChangeMask() & 128) == 0) goto L18;
        tr.setDragResizing(c.getDragResizing());
    L18:
        final int childWindowingMode = c.getActivityWindowingMode();
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == true) goto L30;
        if (tr.getWindowingMode() != 2) goto L30;
        if (childWindowingMode == 2) goto L28;
        if (childWindowingMode == 0) goto L28;
        if (shouldApplyLifecycleEffectOnPipChange() == false) goto L30;
        effects = effects | 2;
    L28:
        Slog.d(TAG, "Task and activity windowing modes match, so remove any timeout abort PiP callbacks scheduled if needed; task_win_mode=" + tr.getWindowingMode() + ", activity_win_mode=" + childWindowingMode);
        this.mService.mRootWindowContainer.removeAllMaybeAbortPipEnterRunnable();
    L30:
        if (childWindowingMode <= (-1)) goto L32;
        tr.forAllActivities(new WindowOrganizerController$$ExternalSyntheticLambda1(childWindowingMode));
    L32:
        Rect enterPipBounds = c.getEnterPipBounds();
        if (enterPipBounds == null) goto L36;
        tr.mDisplayContent.mPinnedTaskController.setEnterPipBounds(enterPipBounds);
    L36:
        if (c.getWindowingMode() != 2) goto L51;
        if (tr.inPinnedWindowingMode() == true) goto L51;
        ActivityRecord activity = tr.getTopNonFinishingActivity();
        if (activity == null) goto L51;
        boolean lastSupportsEnterPipOnTaskSwitch = activity.supportsEnterPipOnTaskSwitch;
        activity.supportsEnterPipOnTaskSwitch = true;
        boolean canEnterPip = activity.checkEnterPictureInPictureState("applyTaskChanges", true);
        if (canEnterPip == false) goto L48;
        canEnterPip = this.mService.mActivityClientController.requestPictureInPictureMode(activity);
        if (canEnterPip == false) goto L48;
        if (shouldApplyLifecycleEffectOnPipChange() == false) goto L48;
        effects = effects | 2;
    L48:
        if (canEnterPip == true) goto L51;
        activity.supportsEnterPipOnTaskSwitch = lastSupportsEnterPipOnTaskSwitch;
    L51:
        if (Features.FEAT_QUICK_WIN == false) goto L53;
        tr.getExt().applyTaskChanges(c);
    L53:
        return effects;
    }

    private static /* synthetic */ void lambda$applyTaskChanges$7(int childWindowingMode, ActivityRecord a) {
        a.setWindowingMode(childWindowingMode);
    }

    static boolean shouldApplyLifecycleEffectOnPipChange() {
        if (SystemProperties.getBoolean("persist.wm.debug.apply_lifecycle_on_pip_change", false) == false) goto L7;
        return true;
    L7:
        return false;
    }

    private int applyDisplayAreaChanges(DisplayArea displayArea, final WindowContainerTransaction.Change c) {
        final int[] effects = {applyChanges(displayArea, c)};
        if ((c.getChangeMask() & 16) != 0) goto L5;
    L7:
        displayArea.forAllTasks(new WindowOrganizerController$$ExternalSyntheticLambda3(c, effects));
        return effects[0];
    L5:
        if (displayArea.setIgnoreOrientationRequest(c.getIgnoreOrientationRequest()) == false) goto L7;
        effects[0] = effects[0] | 2;
        goto L7
    }

    private static /* synthetic */ void lambda$applyDisplayAreaChanges$8(WindowContainerTransaction.Change c, int[] effects, Object task) {
        Task tr = (Task) task;
        if ((c.getChangeMask() & 8) != 0) goto L5;
        return;
    L5:
        if (tr.setForceHidden(2, c.getHidden()) == false) goto L9;
        effects[0] = 2 | effects[0];
        return;
    }

    private int applyTaskFragmentChanges(TaskFragment taskFragment, WindowContainerTransaction.Change c, IBinder errorCallbackToken) {
        if (taskFragment.isEmbeddedTaskFragmentInPip() == false) goto L6;
        return 0;
    L6:
        int effects = 0;
        this.mTmpBounds0.set(taskFragment.getBounds());
        this.mTmpBounds1.set(taskFragment.getRelativeEmbeddedBounds());
        taskFragment.deferOrganizedTaskFragmentSurfaceUpdate();
        Rect relBounds = c.getRelativeBounds();
        if (relBounds == null) goto L10;
        adjustTaskFragmentRelativeBoundsForMinDimensionsIfNeeded(taskFragment, relBounds, errorCallbackToken);
        Rect parentBounds = taskFragment.getParent().getBounds();
        Rect absBounds = taskFragment.translateRelativeBoundsToAbsoluteBounds(relBounds, parentBounds);
        c.getConfiguration().windowConfiguration.setBounds(absBounds);
        taskFragment.setRelativeEmbeddedBounds(relBounds);
    L10:
        if ((c.getChangeMask() & 8) == 0) goto L15;
        if (taskFragment.setForceHidden(4, c.getHidden()) == false) goto L15;
        effects = 0 | 2;
    L15:
        if ((c.getChangeMask() & 64) != 0) goto L17;
    L19:
        int effects2 = effects | applyChanges(taskFragment, c);
        if (taskFragment.shouldStartChangeTransition(this.mTmpBounds0, this.mTmpBounds1) == false) goto L22;
        this.mTransitionController.collectVisibleChange(taskFragment);
    L22:
        taskFragment.continueOrganizedTaskFragmentSurfaceUpdate();
        return effects2;
    L17:
        if (taskFragment.setForceTranslucent(c.getForceTranslucent()) == false) goto L19;
        effects = effects | 2;
        goto L19
    }

    private void adjustTaskFragmentRelativeBoundsForMinDimensionsIfNeeded(TaskFragment taskFragment, Rect inOutRelativeBounds, IBinder errorCallbackToken) {
        if (inOutRelativeBounds.isEmpty() == false) goto L5;
        return;
    L5:
        Point minDimensions = taskFragment.calculateMinDimension();
        if (inOutRelativeBounds.width() >= minDimensions.x) goto L8;
    L11:
        Throwable exception = new SecurityException("The requested relative bounds:" + inOutRelativeBounds + " does not satisfy minimum dimensions:" + minDimensions);
        sendTaskFragmentOperationFailure(taskFragment.getTaskFragmentOrganizer(), errorCallbackToken, taskFragment, 9, exception);
        inOutRelativeBounds.setEmpty();
        return;
    L8:
        if (inOutRelativeBounds.height() < minDimensions.y) goto L11;
    }

    private int applyHierarchyOp(final WindowContainerTransaction.HierarchyOp hop, int effects, int syncId, ActionChain chain, boolean isInLockTaskMode, CallerInfo caller, IBinder errorCallbackToken, ITaskFragmentOrganizer organizer) {
        int type = hop.getType();
        Task task = null;
        switch(type) {
            case 0: goto L153;
            case 1: goto L153;
            case 2: goto L152;
            case 3: goto L137;
            case 4: goto L136;
            case 5: goto L131;
            case 6: goto L106;
            case 7: goto L78;
            case 8: goto L4;
            case 9: goto L4;
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L4;
            case 13: goto L58;
            case 14: goto L45;
            case 15: goto L44;
            case 16: goto L4;
            case 17: goto L43;
            case 18: goto L4;
            case 19: goto L4;
            case 20: goto L4;
            case 21: goto L4;
            case 22: goto L42;
            case 23: goto L4;
            case 24: goto L22;
            case 25: goto L8;
            default: goto L4;
        };
    L4:
        if (isInLockTaskMode == false) goto L7;
        Slog.w(TAG, "Skip applying hierarchy operation " + hop + " while in lock task mode");
        return effects;
    L7:
        final CallerInfo r15 = caller;
        int effects2 = 1;
    L188:
        int effects3 = effects;
    L190:
        switch(type) {
            case 8: goto L313;
            case 9: goto L285;
            case 10: goto L280;
            case 11: goto L276;
            case 12: goto L264;
            case 13: goto L191;
            case 14: goto L191;
            case 15: goto L191;
            case 16: goto L247;
            case 17: goto L191;
            case 18: goto L235;
            case 19: goto L226;
            case 20: goto L223;
            case 21: goto L218;
            case 22: goto L191;
            case 23: goto L209;
            case 24: goto L191;
            case 25: goto L191;
            case 26: goto L192;
            case 27: goto L201;
            default: goto L191;
        };
    L191:
        int effects4 = effects3;
    L317:
        return effects4;
    L192:
        WindowContainer container = WindowContainer.fromBinder(hop.getContainer());
        if (container != null) goto L195;
    L208:
        Slog.e(TAG, "Attempt to operate on unknown or detached container: " + container);
        effects4 = effects3;
        goto L317
    L195:
        if (container.isAttached() == false) goto L208;
        if (chain.mTransition == null) goto L200;
        chain.mTransition.collect(container);
    L200:
        container.setSafeRegionBounds(hop.getSafeRegionBounds());
        effects3 = effects3 | 1;
    L201:
        Transition transition = chain.mTransition;
        if (transition != null) goto L204;
        Slog.e(TAG, "No transition to set animation delegate on");
        return effects3;
    L204:
        IBinder appThread = hop.getInsetsFrameOwner();
        if (appThread != null) goto L207;
        Slog.e(TAG, "No appThread provided to SET_ANIMATION_DELEGATE");
        return effects3;
    L207:
        transition.mRemoteDelegate = IApplicationThread.Stub.asInterface(appThread);
        return effects3;
    L209:
        WindowContainer container2 = WindowContainer.fromBinder(hop.getContainer());
        if (container2 == null) goto L212;
        task = container2.asTask();
    L212:
        if (task != null) goto L214;
    L217:
        Slog.e(TAG, "Attempt to operate on unknown or detached container: " + container2);
        effects4 = effects3;
        goto L317
    L214:
        if (task.isAttached() == false) goto L217;
        task.setLaunchAdjacentDisabled(hop.isLaunchAdjacentDisabled());
        effects4 = effects3;
        goto L317
    L218:
        WindowContainer container3 = WindowContainer.fromBinder(hop.getContainer());
        if (container3 != null) goto L221;
        Slog.e(TAG, "Attempt to operate on unknown or detached container: " + container3);
        effects4 = effects3;
        goto L317
    L221:
        container3.setExcludeInsetsTypes(hop.getExcludeInsetsTypes());
        effects4 = effects3;
        goto L317
    L226:
        WindowContainer container4 = WindowContainer.fromBinder(hop.getContainer());
        if (container4 == null) goto L229;
        task = container4.asTask();
    L229:
        if (task != null) goto L231;
    L234:
        Slog.e(TAG, "Attempt to operate on unknown or detached container: " + container4);
        effects4 = effects3;
        goto L317
    L231:
        if (task.isAttached() == false) goto L234;
        task.setTrimmableFromRecents(hop.isTrimmableFromRecents());
        effects4 = effects3;
        goto L317
    L235:
        TaskFragment pipTaskFragment = WindowContainer.fromBinder(hop.getContainer()).asTaskFragment();
        if (pipTaskFragment != null) goto L238;
        effects4 = effects3;
        goto L317
    L238:
        ActivityRecord pipActivity = pipTaskFragment.getActivity(new WindowOrganizerController$$ExternalSyntheticLambda16());
        if (pipActivity.isState(ActivityRecord.State.RESUMED) == false) goto L241;
        pipActivity.mAutoEnteringPip = pipActivity.pictureInPictureArgs.isAutoEnterEnabled();
    L241:
        Rect entryBounds = hop.getBounds();
        this.mService.mRootWindowContainer.moveActivityToPinnedRootTask(pipActivity, null, "moveActivityToPinnedRootTask", entryBounds);
        if (pipActivity.isState(ActivityRecord.State.PAUSING) == true) goto L244;
    L246:
        pipActivity.mAutoEnteringPip = false;
        return effects3 | 2;
    L244:
        if (pipActivity.mPauseSchedulePendingForPip == false) goto L246;
        pipActivity.getTask().schedulePauseActivity(pipActivity, false, false, true, "auto-pip");
        goto L246
    L247:
        WindowContainer container5 = WindowContainer.fromBinder(hop.getContainer());
        if (container5 == null) goto L250;
        task = container5.asTask();
    L250:
        if (task != null) goto L252;
    L263:
        Slog.e(TAG, "Attempt to operate on unknown or detached container: " + container5);
        effects4 = effects3;
        goto L317
    L252:
        if (task.isAttached() == false) goto L263;
        if (task.mCreatedByOrganizer == false) goto L262;
        if (task.isRootTask() == false) goto L260;
        task.setReparentLeafTaskIfRelaunch(hop.isReparentLeafTaskIfRelaunch());
        effects4 = effects3;
        goto L317
    L260:
        throw new UnsupportedOperationException("Cannot set reparent leaf task flag on non-root task : " + task);
    L262:
        throw new UnsupportedOperationException("Cannot set reparent leaf task flag on non-organized task : " + task);
    L264:
        WindowContainer container6 = WindowContainer.fromBinder(hop.getContainer());
        if (container6 != null) goto L267;
    L275:
        Slog.e(TAG, "Attempt to operate on unknown or detached container: " + container6);
        effects4 = effects3;
        goto L317
    L267:
        if (container6.isAttached() == false) goto L275;
        if (container6.asTask() == null) goto L272;
    L274:
        container6.setAlwaysOnTop(hop.isAlwaysOnTop());
        return effects3 | 2;
    L272:
        if (container6.asDisplayArea() != null) goto L274;
        Slog.e(TAG, "Cannot set always-on-top on non-task or non-display area: " + container6);
        effects4 = effects3;
        goto L317
    L276:
        WindowContainer container7 = WindowContainer.fromBinder(hop.getContainer());
        if (container7 != null) goto L279;
        Slog.e(TAG, "Attempt to remove local insets source provider from unknown: " + container7);
        effects4 = effects3;
        goto L317
    L279:
        container7.removeLocalInsetsFrameProvider(hop.getInsetsFrameProvider(), hop.getInsetsFrameOwner());
        effects4 = effects3;
        goto L317
    L280:
        WindowContainer container8 = WindowContainer.fromBinder(hop.getContainer());
        if (container8 != null) goto L283;
        Slog.e(TAG, "Attempt to add local insets source provider on unknown: " + container8);
        effects4 = effects3;
        goto L317
    L283:
        container8.addLocalInsetsFrameProvider(hop.getInsetsFrameProvider(), hop.getInsetsFrameOwner());
        effects4 = effects3;
        goto L317
    L313:
        effects4 = effects3;
        Bundle launchOpts = hop.getLaunchOptions();
        String callingPackage = launchOpts.getString("android:transaction.hop.shortcut_calling_package");
        launchOpts.remove("android:transaction.hop.shortcut_calling_package");
        LauncherAppsService.LauncherAppsServiceInternal launcherApps = (LauncherAppsService.LauncherAppsServiceInternal) LocalServices.getService(LauncherAppsService.LauncherAppsServiceInternal.class);
        boolean success = launcherApps.startShortcut(r15.mUid, r15.mPid, callingPackage, hop.getShortcutInfo().getPackage(), null, hop.getShortcutInfo().getId(), null, launchOpts, hop.getShortcutInfo().getUserId());
        if (success == false) goto L317;
        return effects4 | 2;
    L223:
        if (this.mService.mBackNavigationController.restoreBackNavigation() == true) goto L321;
        effects4 = effects3;
        goto L317
    L321:
        return effects3 | 2;
    L285:
        if (chain.isFinishing() == true) goto L287;
        effects4 = effects3;
        goto L317
    L287:
        WindowContainer container9 = WindowContainer.fromBinder(hop.getContainer());
        if (container9 != null) goto L294;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[effects2] == false) goto L292;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -6797301855266849294L, 0, null);
    L292:
        effects4 = effects3;
        goto L317
    L294:
        if (container9.asActivityRecord() == null) goto L296;
        Task thisTask = container9.asActivityRecord().getTask();
    L297:
        if (thisTask == null) goto L299;
        Pair<Transition, Task> transientRestore = this.mTransitionController.getTransientLaunchTransitionAndTarget(container9);
        if (transientRestore == null) goto L305;
        Transition r9 = (Transition) transientRestore.first;
        Task restoreAt = (Task) transientRestore.second;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[effects2] == false) goto L312;
        long protoLogParam0 = restoreAt.mTaskId;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 7539390576153474848L, effects2, new Object[]{Long.valueOf(protoLogParam0)});
    L312:
        TaskDisplayArea taskDisplayArea = thisTask.getTaskDisplayArea();
        taskDisplayArea.moveRootTaskBehindRootTask(thisTask.getRootTask(), restoreAt);
        return effects3 | 2;
    L305:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[effects2] == false) goto L307;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 2351203318313661627L, 0, null);
    L307:
        effects4 = effects3;
        goto L317
    L299:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[effects2] == false) goto L301;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -8341916605556640326L, 0, null);
    L301:
        effects4 = effects3;
        goto L317
    L296:
        thisTask = container9.asTask();
        goto L297
    L8:
        int doubleTapX = hop.getAppCompatOptions().getInt("android:transaction.reachability_x");
        int doubleTapY = hop.getAppCompatOptions().getInt("android:transaction.reachability_y");
        WindowContainer<?> wc = WindowContainer.fromBinder(hop.getContainer());
        if (wc != null) goto L11;
        r15 = caller;
        effects2 = 1;
        goto L188
    L11:
        Task currentTask = wc.asTask();
        if (chain.mTransition == null) goto L14;
        chain.mTransition.collect(wc);
    L14:
        if (currentTask == null) goto L21;
        ActivityRecord top = currentTask.topRunningActivity();
        if (top == null) goto L21;
        if (chain.mTransition == null) goto L20;
        chain.mTransition.collect(top);
    L20:
        top.mAppCompatController.getReachabilityPolicy().handleDoubleTap(doubleTapX, doubleTapY);
    L21:
        r15 = caller;
        effects2 = 1;
        effects3 = effects | 1;
        goto L190
    L22:
        WindowContainer wc2 = WindowContainer.fromBinder(hop.getContainer());
        if (wc2 != null) goto L25;
    L41:
        Slog.e(TAG, "Attempt to remove invalid task: " + wc2);
        r15 = caller;
        effects2 = 1;
        goto L188
    L25:
        if (wc2.asTask() == null) goto L41;
        if (wc2.isAttached() == false) goto L41;
        if (wc2.asTask().isRootTask() == false) goto L41;
        if (wc2.asTask().mCreatedByOrganizer == false) goto L41;
        Task task2 = wc2.asTask();
        if (task2.isVisibleRequested() == false) goto L36;
    L39:
        int effects5 = effects | 2;
    L40:
        this.mService.mTaskSupervisor.removeRootTask(task2);
        task2.remove(true, "remove-root-task-through-hierarchyOp");
        r15 = caller;
        effects3 = effects5;
        effects2 = 1;
        goto L190
    L36:
        if (task2.isVisible() == true) goto L39;
        effects5 = effects;
        goto L40
    L42:
        effects3 = effects | applyKeyguardState(hop);
        r15 = caller;
        effects2 = 1;
        goto L190
    L43:
        r15 = caller;
        effects3 = effects | applyTaskFragmentOperation(hop, chain, isInLockTaskMode, caller, errorCallbackToken, organizer);
        effects2 = 1;
        goto L190
    L44:
        r15 = caller;
        effects3 = effects | clearAdjacentRootsHierarchyOp(hop);
        effects2 = 1;
        goto L190
    L45:
        r15 = caller;
        ActivityRecord activity = ActivityRecord.forTokenLocked(hop.getContainer());
        if (activity != null) goto L48;
        effects2 = 1;
        goto L188
    L48:
        if (activity.finishing == false) goto L51;
        effects2 = 1;
        goto L188
    L51:
        if (activity.isVisible() == false) goto L53;
    L56:
        activity.finishIfPossible("finish-activity-op", false);
        effects3 = effects | 2;
        effects2 = 1;
        goto L190
    L53:
        if (activity.isVisibleRequested() == true) goto L56;
        activity.destroyIfPossible("finish-activity-op");
        effects2 = 1;
        goto L188
    L58:
        r15 = caller;
        WindowContainer wc3 = WindowContainer.fromBinder(hop.getContainer());
        if (wc3 != null) goto L61;
    L77:
        Slog.e(TAG, "Attempt to remove invalid task: " + wc3);
        effects2 = 1;
        goto L188
    L61:
        if (wc3.asTask() == null) goto L77;
        if (wc3.isAttached() == false) goto L77;
        Task task3 = wc3.asTask();
        if (task3.isVisibleRequested() == false) goto L68;
    L71:
        int effects6 = effects | 2;
    L73:
        if (task3.isLeafTask() == false) goto L75;
        this.mService.mTaskSupervisor.removeTask(task3, true, true, "remove-task-through-hierarchyOp");
    L76:
        effects3 = effects6;
        effects2 = 1;
        goto L190
    L75:
        this.mService.mTaskSupervisor.removeRootTask(task3);
        goto L76
    L68:
        if (task3.isVisible() == true) goto L71;
        effects6 = effects;
        goto L73
    L78:
        r15 = caller;
        Bundle launchOpts2 = hop.getLaunchOptions();
        if (launchOpts2 == null) goto L81;
        ActivityOptions activityOptions = new ActivityOptions(launchOpts2);
    L82:
        if (activityOptions == null) goto L91;
        if (activityOptions.getTransientLaunch() == false) goto L91;
        if (this.mService.isCallerRecents(hop.getPendingIntent().getCreatorUid()) == false) goto L91;
        if (this.mService.getActivityStartController().startExistingRecentsIfPossible(hop.getActivityIntent(), activityOptions) == false) goto L91;
        effects2 = 1;
    L91:
        if (hop.getActivityIntent() == null) goto L93;
        final String resolvedType = hop.getActivityIntent().resolveTypeIfNeeded(this.mService.mContext.getContentResolver());
    L95:
        if (hop.getPendingIntent().isActivity() == false) goto L99;
        if (activityOptions != null) goto L98;
        activityOptions = ActivityOptions.makeBasic();
    L98:
        activityOptions.setCallerDisplayId(0);
    L99:
        if (activityOptions == null) goto L101;
        final Bundle options = activityOptions.toBundle();
    L102:
        int res = waitAsyncStart(new WindowOrganizerController$$ExternalSyntheticLambda15(this, hop, resolvedType, options));
        if (ActivityManager.isStartResultSuccessful(res) == false) goto L105;
        effects3 = effects | 2;
        effects2 = 1;
        goto L190
    L105:
        effects2 = 1;
        goto L188
    L101:
        options = null;
        goto L102
    L93:
        resolvedType = null;
        goto L95
    L81:
        activityOptions = null;
        goto L82
    L106:
        r15 = caller;
        WindowContainer wc4 = WindowContainer.fromBinder(hop.getContainer());
        if (wc4 != null) goto L109;
    L130:
        Slog.e(TAG, "Attempt to set launch adjacent to a detached container: " + wc4);
        effects2 = 1;
        goto L188
    L109:
        if (wc4.isAttached() == false) goto L130;
        Task task4 = wc4.asTask();
        boolean clearRoot = hop.getToTop();
        if (task4 == null) goto L129;
        if (task4.mCreatedByOrganizer == false) goto L127;
        if (task4.hasAdjacentTaskFragment() == true) goto L121;
        if (clearRoot == true) goto L121;
        throw new UnsupportedOperationException("Cannot set non-adjacent task as adjacent flag root: " + wc4);
    L121:
        TaskDisplayArea r3 = task4.getDisplayArea();
        if (clearRoot == false) goto L124;
        Task r13 = null;
    L125:
        r3.setLaunchAdjacentFlagRootTask(r13);
        effects2 = 1;
        goto L188
    L124:
        r13 = task4;
        goto L125
    L127:
        throw new UnsupportedOperationException("Cannot set non-organized task as adjacent flag root: " + wc4);
    L129:
        throw new IllegalArgumentException("Cannot set non-task as launch root: " + wc4);
    L131:
        r15 = caller;
        this.mService.mAmInternal.enforceCallingPermission("android.permission.START_TASKS_FROM_RECENTS", "launchTask HierarchyOp");
        Bundle launchOpts3 = hop.getLaunchOptions();
        final int taskId = launchOpts3.getInt("android:transaction.hop.taskId");
        launchOpts3.remove("android:transaction.hop.taskId");
        final SafeActivityOptions safeOptions = SafeActivityOptions.fromBundle(launchOpts3, r15.mPid, r15.mUid);
        int effects7 = effects | 2;
        effects2 = 1;
        if (this.mExt.startSplitFromRecentsOrLauncherWithoutWaitAsyncStartIfNeeded(launchOpts3, chain.mTransition, new WindowOrganizerController$$ExternalSyntheticLambda13(this, r15, taskId, safeOptions)) == true) goto L135;
        waitAsyncStart(new WindowOrganizerController$$ExternalSyntheticLambda14(this, r15, taskId, safeOptions));
    L135:
        effects3 = effects7;
        goto L190
    L136:
        r15 = caller;
        effects2 = 1;
        effects3 = effects | setAdjacentRootsHierarchyOp(hop);
        goto L190
    L137:
        r15 = caller;
        effects2 = 1;
        WindowContainer wc5 = WindowContainer.fromBinder(hop.getContainer());
        if (wc5 != null) goto L140;
    L151:
        Slog.e(TAG, "Attempt to set launch root to a detached container: " + wc5);
        goto L188
    L140:
        if (wc5.isAttached() == false) goto L151;
        Task task5 = wc5.asTask();
        if (task5 == null) goto L150;
        if (task5.getTaskDisplayArea() == null) goto L148;
        task5.getDisplayArea().setLaunchRootTask(task5, hop.getWindowingModes(), hop.getActivityTypes());
        goto L188
    L148:
        throw new IllegalArgumentException("Cannot set a task without display area as launch root: " + wc5);
    L150:
        throw new IllegalArgumentException("Cannot set non-task as launch root: " + wc5);
    L152:
        r15 = caller;
        effects2 = 1;
        effects3 = effects | reparentChildrenTasksHierarchyOp(hop, chain.mTransition, syncId, isInLockTaskMode);
        goto L190
    L153:
        r15 = caller;
        effects2 = 1;
        WindowContainer wc6 = WindowContainer.fromBinder(hop.getContainer());
        if (wc6 != null) goto L156;
    L187:
        Slog.e(TAG, "Attempt to operate on detached container: " + wc6);
        goto L188
    L156:
        if (wc6.isAttached() == false) goto L187;
        if (isInLockTaskMode == false) goto L162;
        if (type != 0) goto L162;
        Slog.w(TAG, "Skip applying hierarchy operation " + hop + " while in lock task mode");
    L162:
        if (isLockTaskModeViolation(wc6.getParent(), wc6.asTask(), isInLockTaskMode) == true) goto L188;
        if (syncId < 0) goto L167;
        addToSyncSet(syncId, wc6);
    L167:
        if (chain.mTransition == null) goto L180;
        chain.mTransition.collect(wc6);
        if (hop.isReparent() == false) goto L180;
        if (wc6.getParent() == null) goto L174;
        chain.mTransition.collect(wc6.getParent());
    L174:
        if (hop.getNewParent() == null) goto L180;
        WindowContainer parentWc = WindowContainer.fromBinder(hop.getNewParent());
        if (parentWc != null) goto L178;
        Slog.e(TAG, "Can't resolve parent window from token");
        goto L188
    L178:
        chain.mTransition.collect(parentWc);
    L180:
        if (wc6.asTask() == null) goto L183;
        effects3 = effects | sanitizeAndApplyHierarchyOpForTask(wc6.asTask(), hop);
        goto L190
    L183:
        if (wc6.asDisplayArea() == null) goto L186;
        effects3 = effects | sanitizeAndApplyHierarchyOpForDisplayArea(wc6.asDisplayArea(), hop);
        goto L190
    L186:
        throw new IllegalArgumentException("Invalid container in hierarchy op");
    }

    private /* synthetic */ void lambda$applyHierarchyOp$9(CallerInfo caller, int taskId, SafeActivityOptions safeOptions) {
        this.mService.mTaskSupervisor.startActivityFromRecents(caller.mPid, caller.mUid, taskId, safeOptions);
    }

    private /* synthetic */ int lambda$applyHierarchyOp$10(CallerInfo caller, int taskId, SafeActivityOptions safeOptions) {
        return this.mService.mTaskSupervisor.startActivityFromRecents(caller.mPid, caller.mUid, taskId, safeOptions);
    }

    private /* synthetic */ int lambda$applyHierarchyOp$11(WindowContainerTransaction.HierarchyOp hop, String resolvedType, Bundle options) {
        return this.mService.mAmInternal.sendIntentSender(hop.getPendingIntent().getTarget(), hop.getPendingIntent().getWhitelistToken(), 0, hop.getActivityIntent(), resolvedType, null, null, options);
    }

    private static /* synthetic */ boolean lambda$applyHierarchyOp$12(ActivityRecord activity) {
        if (activity.pictureInPictureArgs == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private int applyTaskFragmentOperation(WindowContainerTransaction.HierarchyOp r19, ActionChain r20, boolean r21, final CallerInfo r22, final IBinder r23, ITaskFragmentOrganizer r24) {
        boolean r4 = false;
        int r5 = 0;
        Object[] r6 = 0;
        r6 = 0;
        r4 = false;
        if (validateTaskFragmentOperation(r19, r23, r24) == true) goto L5;
        return 0;
    L5:
        final TaskFragment r3 = this.mLaunchTaskFragments.get(r19.getContainer());
        TaskFragmentOperation r11 = r19.getTaskFragmentOperation();
        int r7 = r11.getOpType();
        int r12 = 0;
        TaskFragment r14 = null;
        switch(r7) {
            case 0: goto L170;
            case 1: goto L160;
            case 2: goto L155;
            case 3: goto L136;
            case 4: goto L113;
            case 5: goto L93;
            case 6: goto L79;
            case 7: goto L74;
            case 8: goto L70;
            case 10: goto L59;
            case 11: goto L58;
            case 12: goto L47;
            case 13: goto L43;
            case 14: goto L39;
            case 15: goto L31;
            case 16: goto L30;
            case 1001: goto L20;
            case 1002: goto L10;
            case 1003: goto L9;
            case 1004: goto L8;
            default: goto L175;
        };
    L8:
        r3.setCanAffectSystemUiFlags(r11.getBooleanValue());
        this.mService.mWindowManager.mWindowPlacerLocked.requestTraversal();
        return 0;
    L9:
        r3.setMoveToBottomIfClearWhenLaunch(r11.getBooleanValue());
        return 0;
    L10:
        Task r8 = r3.getTask();
        if (r8 == null) goto L180;
        if (r8.getTopChild() == r3) goto L179;
        r8.mChildren.remove(r3);
        r8.mChildren.add(r3);
        if (r3.hasChild() == true) goto L178;
        r8.assignChildLayers();
    L178:
        return 0 | 2;
    L179:
        return 0;
    L180:
        return 0;
    L20:
        Task r9 = r3.getTask();
        if (r9 == null) goto L183;
        if (r9.getBottomChild() == r3) goto L182;
        r9.mChildren.remove(r3);
        r9.mChildren.add(0, r3);
        if (r3.hasChild() == true) goto L181;
        r9.assignChildLayers();
    L181:
        return 0 | 2;
    L182:
        return 0;
    L183:
        return 0;
    L30:
        r3.setPinned(r11.getBooleanValue());
        return 0;
    L31:
        final Task r10 = r3.getTask();
        if (r10 == null) goto L185;
        SurfaceControl.Transaction r13 = r11.getSurfaceTransaction();
        if (r13 == null) goto L37;
        r13.sanitize(r22.mPid, r22.mUid);
    L37:
        r10.requestDecorSurfaceBoosted(r3, r11.getBooleanValue(), r13);
        Transition r15 = r20.mTransition;
        r10.getClass();
        runAfterTransition(r15, new WindowOrganizerController$$ExternalSyntheticLambda11(r10));
        return 0;
    L185:
        return 0;
    L43:
        Task r16 = r3.getTask();
        if (r16 == null) goto L188;
        r16.removeDecorSurface();
        return 0;
    L188:
        return 0;
    L47:
        Task r17 = r3.getTask();
        if (r17 != null) goto L51;
        return 0;
    L51:
        if (r20.mTransition == null) goto L55;
        final ArraySet<WindowContainer> r18 = r20.mTransition.mParticipants;
        r18.getClass();
        r14 = r17.getTaskFragment(new WindowOrganizerController$$ExternalSyntheticLambda10(r18));
    L55:
        if (r14 == null) goto L57;
        r17.moveOrCreateDecorSurfaceFor(r3, false);
        r17.setDecorSurfaceVisible(r14.getSyncTransaction());
        return 0;
    L57:
        r17.moveOrCreateDecorSurfaceFor(r3, true);
        return 0;
    L58:
        r3.setIsolatedNav(r11.getBooleanValue());
        return 0;
    L59:
        Task r25 = r3.getTask();
        if (r25 == null) goto L195;
        TaskFragment r26 = r25.getTaskFragment(new WindowOrganizerController$$ExternalSyntheticLambda9());
        if (r26 == null) goto L194;
        if (r26 == r3) goto L194;
        int r110 = r25.mChildren.indexOf(r26);
        r25.mChildren.remove(r3);
        r25.mChildren.add(r110, r3);
        if (r3.hasChild() == true) goto L67;
        r25.assignChildLayers();
    L67:
        r12 = 0 | 2;
    L194:
        return r12;
    L195:
        return 0;
    L70:
        TaskFragmentAnimationParams r27 = r11.getAnimationParams();
        if (r27 != null) goto L73;
        sendTaskFragmentOperationFailure(r24, r23, r3, r7, new IllegalArgumentException("TaskFragmentAnimationParams must be non-null"));
        return 0;
    L73:
        r3.setAnimationParams(r27);
        return 0;
    L74:
        IBinder r2 = r11.getSecondaryFragmentToken();
        if (r2 == null) goto L78;
        r14 = this.mLaunchTaskFragments.get(r2);
    L78:
        r3.setCompanionTaskFragment(r14);
        return 0;
    L79:
        ActivityRecord r28 = r3.getDisplayContent().mFocusedApp;
        if (r28 != null) goto L82;
    L84:
        if (r28 != null) goto L86;
    L88:
        ActivityRecord r29 = r3.getTopResumedActivity();
        if (r29 != null) goto L91;
        Slog.d(TAG, "There is no resumed activity in the requested TaskFragment.");
        return 0;
    L91:
        r3.getDisplayContent().setFocusedApp(r29);
        return 0;
    L86:
        if (r28.getTask() == r3.getTask()) goto L88;
        Slog.d(TAG, "The Task of the requested TaskFragment doesn't have focus.");
        return 0;
    L82:
        if (r28.getTaskFragment() != r3) goto L84;
        Slog.d(TAG, "The requested TaskFragment already has the focus.");
        return 0;
    L113:
        TaskFragment r111 = this.mLaunchTaskFragments.get(r11.getSecondaryFragmentToken());
        if (r111 != null) goto L117;
        sendTaskFragmentOperationFailure(r24, r23, r3, r7, new IllegalArgumentException("SecondaryFragmentToken must be set for setAdjacentTaskFragments."));
        return 0;
    L117:
        if (r3.isAdjacentTo(r111) == true) goto L119;
        r3.setAdjacentTaskFragments(new TaskFragment.AdjacentSet(new TaskFragment[]{r3, r111}));
        r12 = 0 | 2;
    L119:
        Bundle r30 = r19.getLaunchOptions();
        if (r30 == null) goto L124;
        r14 = new WindowContainerTransaction.TaskFragmentAdjacentParams(r30);
    L124:
        if (r14 != null) goto L126;
    L128:
        boolean r112 = false;
    L129:
        r3.setDelayLastActivityRemoval(r112);
        if (r14 != null) goto L132;
    L135:
        r111.setDelayLastActivityRemoval(r4);
        return r12;
    L132:
        if (r14.shouldDelaySecondaryLastActivityRemoval() == false) goto L135;
        r4 = true;
        goto L135
    L126:
        if (r14.shouldDelayPrimaryLastActivityRemoval() == false) goto L128;
        r112 = true;
        goto L129
    L136:
        IBinder r31 = r11.getActivityToken();
        ActivityRecord r32 = ActivityRecord.forTokenLocked(r31);
        if (r32 != null) goto L139;
        ActivityRecord r113 = this.mTaskFragmentOrganizerController.getReparentActivityFromTemporaryToken(r24, r31);
    L140:
        if (r113 != null) goto L143;
        sendTaskFragmentOperationFailure(r24, r23, r3, r7, new IllegalArgumentException("Not allowed to operate with invalid activity."));
        return 0;
    L143:
        if (r3.isAllowedToEmbedActivity(r113) == 0) goto L146;
        sendTaskFragmentOperationFailure(r24, r23, r3, r7, new SecurityException("The task fragment is not allowed to embed the given activity."));
        return 0;
    L146:
        if (r3.getTask() == r113.getTask()) goto L149;
        sendTaskFragmentOperationFailure(r24, r23, r3, r7, new SecurityException("The reparented activity is not in the same Task as the target TaskFragment."));
        return 0;
    L149:
        if (r20.mTransition == null) goto L154;
        r20.collect(r113);
        if (r113.getParent() == null) goto L153;
        r20.collect(r113.getParent());
    L153:
        r20.collect(r3);
    L154:
        r113.reparent(r3, Integer.MAX_VALUE);
        return 0 | 2;
    L139:
        r113 = r32;
        goto L140
    L155:
        final IBinder r33 = r11.getActivityToken();
        final Intent r34 = r11.getActivityIntent();
        final SafeActivityOptions r35 = SafeActivityOptions.fromBundle(r11.getBundle(), r22.mPid, r22.mUid);
        int r1 = waitAsyncStart(new WindowOrganizerController$$ExternalSyntheticLambda8(this, r3, r34, r35, r33, r22, r23));
        if (ActivityManager.isStartResultSuccessful(r1) == true) goto L212;
        sendTaskFragmentOperationFailure(r24, r23, r3, r7, convertStartFailureToThrowable(r1, r34));
        return 0;
    L212:
        return 0 | 2;
    L170:
        TaskFragmentCreationParams r36 = r11.getTaskFragmentCreationParams();
        if (r36 != null) goto L173;
        sendTaskFragmentOperationFailure(r24, r23, r3, r7, new IllegalArgumentException("TaskFragmentCreationParams must be non-null"));
        return 0;
    L173:
        createTaskFragment(r36, r23, r22, r20.mTransition);
        return 0;
    L175:
        return 0;
    L39:
        if (r11.getBooleanValue() == false) goto L42;
        r5 = 1;
    L42:
        r3.setEmbeddedDimArea(r5);
        return 0;
    L93:
        if (r3.hasAdjacentTaskFragment() == false) goto L203;
        ActivityRecord r37 = r3.getDisplayContent().mFocusedApp;
        if (r37 == null) goto L98;
        TaskFragment r38 = r37.getTaskFragment();
    L100:
        if (r38 == r3) goto L106;
        if (r38 != null) goto L103;
    L107:
        r3.removeFromAdjacentTaskFragments();
        int r114 = 0 | 2;
        if (r6 == 0) goto L204;
        if (r38.shouldBeVisible(null) == true) goto L204;
        r38.getDisplayContent().setFocusedApp(null);
    L204:
        return r114;
    L103:
        if (r3.isAdjacentTo(r38) == false) goto L107;
    L106:
        r6 = 1;
        goto L107
    L98:
        r38 = null;
        goto L100
    L203:
        return 0;
    L160:
        if (r21 == false) goto L214;
        ActivityRecord r115 = r3.getActivity(new WindowOrganizerController$$ExternalSyntheticLambda7(), false);
        if (r115 == null) goto L214;
        if (this.mService.getLockTaskController().activityBlockedFromFinish(r115) == false) goto L214;
        Slog.w(TAG, "Skip removing TaskFragment due in lock task mode.");
        sendTaskFragmentOperationFailure(r24, r23, r3, r7, new IllegalStateException("Not allow to delete task fragment in lock task mode."));
        return 0;
    L214:
        return 0 | deleteTaskFragment(r3, r20.mTransition);
    }

    private static /* synthetic */ boolean lambda$applyTaskFragmentOperation$13(ActivityRecord a) {
        return !a.finishing;
    }

    private /* synthetic */ int lambda$applyTaskFragmentOperation$14(TaskFragment taskFragment, Intent activityIntent, SafeActivityOptions safeOptions, IBinder callerActivityToken, CallerInfo caller, IBinder errorCallbackToken) {
        return this.mService.getActivityStartController().startActivityInTaskFragment(taskFragment, activityIntent, safeOptions, callerActivityToken, caller.mUid, caller.mPid, errorCallbackToken);
    }

    private static /* synthetic */ boolean lambda$applyTaskFragmentOperation$15(TaskFragment tf) {
        if (tf.asTask() != null) goto L5;
        return true;
    L5:
        return false;
    }

    private int applyKeyguardState(WindowContainerTransaction.HierarchyOp hop) {
        KeyguardState keyguardState = hop.getKeyguardState();
        if (keyguardState == null) goto L5;
        boolean keyguardShowing = keyguardState.getKeyguardShowing();
        boolean aodShowing = keyguardState.getAodShowing();
        this.mService.setLockScreenShownLocked(keyguardShowing, aodShowing);
    L5:
        return 2;
    }

    private static void runAfterTransition(Transition transition, Runnable runnable) {
        if (transition != null) goto L4;
        runnable.run();
        return;
    L4:
        transition.addTransitionEndedListener(runnable);
    }

    private boolean validateTaskFragmentOperation(WindowContainerTransaction.HierarchyOp hop, IBinder errorCallbackToken, ITaskFragmentOrganizer organizer) {
        TaskFragmentOperation operation = hop.getTaskFragmentOperation();
        IBinder fragmentToken = hop.getContainer();
        TaskFragment taskFragment = this.mLaunchTaskFragments.get(fragmentToken);
        if (operation != null) goto L6;
        Throwable exception = new IllegalArgumentException("TaskFragmentOperation must be non-null");
        sendTaskFragmentOperationFailure(organizer, errorCallbackToken, taskFragment, -1, exception);
        return false;
    L6:
        int opType = operation.getOpType();
        if (opType < 1000) goto L13;
        if (this.mTaskFragmentOrganizerController.isSystemOrganizer(organizer.asBinder()) == true) goto L13;
        Throwable exception2 = new SecurityException("Only a system organizer can perform privileged operations. opType=" + opType);
        sendTaskFragmentOperationFailure(organizer, errorCallbackToken, taskFragment, opType, exception2);
        return false;
    L13:
        if (opType != 0) goto L16;
        return true;
    L16:
        if (validateTaskFragment(taskFragment, opType, errorCallbackToken, organizer) == true) goto L18;
        return false;
    L18:
        IBinder secondaryFragmentToken = operation.getSecondaryFragmentToken();
        if (secondaryFragmentToken == null) goto L23;
        if (validateTaskFragment(this.mLaunchTaskFragments.get(secondaryFragmentToken), opType, errorCallbackToken, organizer) == true) goto L23;
        return false;
    L23:
        return true;
    }

    private boolean validateTaskFragment(TaskFragment taskFragment, int opType, IBinder errorCallbackToken, ITaskFragmentOrganizer organizer) {
        if (taskFragment == null) goto L19;
        if (taskFragment.isAttached() == false) goto L19;
        if (taskFragment.isEmbeddedTaskFragmentInPip() == false) goto L17;
        if (opType == 1) goto L11;
    L14:
        Throwable exception = new IllegalArgumentException("Not allowed to apply operation on PIP TaskFragment");
        sendTaskFragmentOperationFailure(organizer, errorCallbackToken, taskFragment, opType, exception);
        return false;
    L11:
        if (taskFragment.getTopNonFinishingActivity() != null) goto L14;
    L17:
        return true;
    L19:
        Throwable exception2 = new IllegalArgumentException("Not allowed to apply operation on invalid fragment tokens opType=" + opType);
        sendTaskFragmentOperationFailure(organizer, errorCallbackToken, taskFragment, opType, exception2);
        return false;
    }

    private int waitAsyncStart(final IntSupplier startActivity) {
        final Integer[] starterResult = {null};
        if (Looper.myLooper() != this.mService.mH.getLooper()) goto L5;
        Handler handler = this.mService.mWindowManager.mAnimationHandler;
    L6:
        handler.post(new WindowOrganizerController$$ExternalSyntheticLambda19(this, starterResult, startActivity));
    L8:
        if (starterResult[0] != null) goto L14;
        this.mGlobalLock.wait();     // Catch: InterruptedException -> L11
        goto L8
    L14:
        return starterResult[0].intValue();
    L5:
        handler = this.mService.mH;
        goto L6
    }

    private /* synthetic */ void lambda$waitAsyncStart$16(Integer[] starterResult, IntSupplier startActivity) {
        starterResult[0] = Integer.valueOf(startActivity.getAsInt());     // Catch: Throwable -> L5
    L7:
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mGlobalLock.notifyAll();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L13:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        t = move-exception;
        starterResult[0] = -96;
        Slog.w(TAG, t);
        goto L7
    }

    private int sanitizeAndApplyHierarchyOpForDisplayArea(DisplayArea displayArea, WindowContainerTransaction.HierarchyOp hop) {
        if (hop.getType() != 1) goto L15;
        if (displayArea.getParent() != null) goto L8;
        return 0;
    L8:
        WindowContainer r0 = displayArea.getParent();
        if (hop.getToTop() == false) goto L11;
        int r1 = Integer.MAX_VALUE;
    L12:
        r0.positionChildAt(r1, displayArea, hop.includingParents());
        return 2;
    L11:
        r1 = Integer.MIN_VALUE;
        goto L12
    L15:
        throw new UnsupportedOperationException("DisplayArea only supports reordering");
    }

    private int sanitizeAndApplyHierarchyOpForTask(Task task, WindowContainerTransaction.HierarchyOp hop) {
        DisplayContent dc = task.getDisplayContent();
        if (dc != null) goto L6;
        Slog.w(TAG, "Container is no longer attached: " + task);
        return 0;
    L6:
        int r5 = Integer.MIN_VALUE;
        if (hop.isReparent() == true) goto L9;
        boolean isNonOrganizedRootableTask = hop.getToTop();
        if (isNonOrganizedRootableTask == true) goto L63;
    L73:
        WindowContainer r1 = task.getParent();
        if (hop.getToTop() == false) goto L76;
        r5 = Integer.MAX_VALUE;
    L76:
        r1.positionChildAt(r5, task, hop.includingParents());
        return 2;
    L63:
        if (task.isRootTask() == false) goto L73;
        if (Features.FEAT_QUICK_WIN == true) goto L67;
    L72:
        ActivityRecord pipCandidate = Task.findEnterPipOnTaskSwitchCandidate(task.getDisplayArea().getTopRootTask());
        Task.enableEnterPipOnTaskSwitch(pipCandidate, task, null, null);
        goto L73
    L67:
        if (task.inFreeformWindowingMode() == false) goto L72;
        if (task.isAlwaysOnTop() == true) goto L72;
        Slog.w(TAG, "Can't support moving a freeform task to front which isAlwaysOnTop is false.");
        return 0;
    L9:
        if (task.isRootTask() == false) goto L11;
    L14:
        boolean isNonOrganizedRootableTask2 = true;
    L15:
        if (isNonOrganizedRootableTask2 == false) goto L59;
        if (hop.getNewParent() != null) goto L19;
        WindowContainer newParent = dc.getDefaultTaskDisplayArea();
    L21:
        if (newParent != null) goto L25;
        Slog.e(TAG, "Can't resolve parent window from token");
        return 0;
    L25:
        if (task.getParent() == newParent) goto L50;
        if (newParent.asTaskDisplayArea() == null) goto L30;
        task.reparent(newParent.asTaskDisplayArea(), hop.getToTop());
        return 2;
    L30:
        if (newParent.asTask() == null) goto L48;
        if (newParent.inMultiWindowMode() == true) goto L34;
    L43:
        Task r2 = (Task) newParent;
        if (hop.getToTop() == false) goto L46;
        r5 = Integer.MAX_VALUE;
    L46:
        task.reparent(r2, r5, false, "sanitizeAndApplyHierarchyOp");
        return 2;
    L34:
        if (task.isLeafTask() == false) goto L43;
        if (newParent.inPinnedWindowingMode() == false) goto L40;
        Slog.w(TAG, "Can't support moving a task to another PIP window... newParent=" + newParent + " task=" + task);
        return 0;
    L40:
        if (task.supportsMultiWindowInDisplayArea(newParent.asTask().getDisplayArea()) == true) goto L43;
        Slog.w(TAG, "Can't support task that doesn't support multi-window mode in multi-window mode... newParent=" + newParent + " task=" + task);
        return 0;
    L48:
        throw new RuntimeException("Can only reparent task to another task or taskDisplayArea, but not " + newParent);
    L50:
        if ((newParent instanceof TaskDisplayArea) == true) goto L52;
        WindowContainer r3 = newParent;
    L53:
        Task rootTask = (Task) r3;
        TaskDisplayArea r8 = task.getDisplayArea();
        if (hop.getToTop() == false) goto L56;
        r5 = Integer.MAX_VALUE;
    L56:
        r8.positionChildAt(r5, rootTask, false);
        return 2;
    L52:
        r3 = task.getRootTask();
        goto L53
    L19:
        newParent = WindowContainer.fromBinder(hop.getNewParent());
        goto L21
    L59:
        throw new RuntimeException("Reparenting leaf Tasks is not supported now. " + task);
    L11:
        if (task.getParent().asTask().mCreatedByOrganizer == true) goto L14;
        isNonOrganizedRootableTask2 = false;
        goto L15
    }

    private boolean isLockTaskModeViolation(WindowContainer parent, Task task, boolean isInLockTaskMode) {
        if (isInLockTaskMode == false) goto L14;
        if (parent == null) goto L16;
        if (task == null) goto L17;
        LockTaskController lockTaskController = this.mService.getLockTaskController();
        boolean taskViolation = lockTaskController.isLockTaskModeViolation(task);
        if (taskViolation == false) goto L9;
    L11:
        if (taskViolation == false) goto L13;
        Slog.w(TAG, "Can't support the operation since in lock task mode violation.  Task: " + task + " Parent : " + parent);
    L13:
        return taskViolation;
    L9:
        if (parent.asTask() == null) goto L11;
        taskViolation = lockTaskController.isLockTaskModeViolation(parent.asTask());
        goto L11
    L17:
        return false;
    L16:
        return false;
    L14:
        return false;
    }

    private int reparentChildrenTasksHierarchyOp(final WindowContainerTransaction.HierarchyOp hop, Transition transition, int syncId, final boolean isInLockTaskMode) {
        WindowContainer<?> newParent = null;
        if (hop.getContainer() == null) goto L5;
        WindowContainer<?> currentParent = WindowContainer.fromBinder(hop.getContainer());
    L7:
        if (hop.getNewParent() == null) goto L10;
        newParent = WindowContainer.fromBinder(hop.getNewParent());
    L10:
        if (currentParent != null) goto L15;
        if (newParent != null) goto L15;
        throw new IllegalArgumentException("reparentChildrenTasksHierarchyOp: " + hop);
    L15:
        if (currentParent != null) goto L17;
        WindowContainer<?> currentParent2 = newParent.asTask().getDisplayContent().getDefaultTaskDisplayArea();
        WindowContainer<?> currentParent3 = currentParent2;
        WindowContainer<?> r12 = newParent;
    L21:
        if (currentParent3 != r12) goto L25;
        Slog.e(TAG, "reparentChildrenTasksHierarchyOp parent not changing: " + hop);
        return 0;
    L25:
        if (currentParent3.isAttached() == true) goto L29;
        Slog.e(TAG, "reparentChildrenTasksHierarchyOp currentParent detached=" + currentParent3 + " hop=" + hop);
        return 0;
    L29:
        if (r12.isAttached() == true) goto L33;
        Slog.e(TAG, "reparentChildrenTasksHierarchyOp newParent detached=" + r12 + " hop=" + hop);
        return 0;
    L33:
        if (r12.inPinnedWindowingMode() == false) goto L36;
        Slog.e(TAG, "reparentChildrenTasksHierarchyOp newParent in PIP=" + r12 + " hop=" + hop);
        return 0;
    L36:
        final boolean newParentInMultiWindow = r12.inMultiWindowMode();
        if (r12.asTask() == null) goto L39;
        final TaskDisplayArea newParentTda = r12.asTask().getDisplayArea();
    L40:
        final WindowContainer<?> r1 = currentParent3;
        final WindowContainer<?> r6 = r12;
        Slog.i(TAG, "reparentChildrenTasksHierarchyOp currentParent=" + currentParent3 + " newParent=" + r12 + " hop=" + hop);
        final ArrayList<Task> tasksToReparent = new ArrayList();
        currentParent3.forAllTasks(new WindowOrganizerController$$ExternalSyntheticLambda0(this, r1, newParentInMultiWindow, newParentTda, hop, r6, isInLockTaskMode, tasksToReparent));
        int count = tasksToReparent.size();
        int i = 0;
    L41:
        if (i >= count) goto L58;
        Task task = tasksToReparent.get(i);
        if (syncId < 0) goto L46;
        addToSyncSet(syncId, task);
    L46:
        if (transition == null) goto L49;
        transition.collect(task);
    L49:
        if ((r12 instanceof TaskDisplayArea) == false) goto L51;
        task.reparent((TaskDisplayArea) r12, hop.getToTop());
    L56:
        i = i + 1;
        count = count;
        goto L41
    L51:
        Task r14 = (Task) r12;
        if (hop.getToTop() == false) goto L54;
        int r15 = Integer.MAX_VALUE;
    L55:
        task.reparent(r14, r15, false, "processChildrenTaskReparentHierarchyOp");
        goto L56
    L54:
        r15 = Integer.MIN_VALUE;
        goto L55
    L58:
        if (transition == null) goto L65;
        transition.collect(r12);
        return 2;
    L65:
        return 2;
    L39:
        newParentTda = r12.asTaskDisplayArea();
        goto L40
    L17:
        if (newParent != null) goto L19;
        currentParent3 = currentParent;
        r12 = currentParent.asTask().getDisplayContent().getDefaultTaskDisplayArea();
        goto L21
    L19:
        currentParent3 = currentParent;
        r12 = newParent;
        goto L21
    L5:
        currentParent = null;
        goto L7
    }

    private /* synthetic */ boolean lambda$reparentChildrenTasksHierarchyOp$17(WindowContainer finalCurrentParent, boolean newParentInMultiWindow, TaskDisplayArea newParentTda, WindowContainerTransaction.HierarchyOp hop, WindowContainer finalNewParent, boolean isInLockTaskMode, ArrayList tasksToReparent, Task task) {
        Slog.i(TAG, " Processing task=" + task);
        if (task.mCreatedByOrganizer == false) goto L5;
    L35:
        return false;
    L5:
        if (task.getParent() != finalCurrentParent) goto L35;
        if (newParentInMultiWindow == false) goto L13;
        if (task.supportsMultiWindowInDisplayArea(newParentTda) == true) goto L13;
        Slog.e(TAG, "reparentChildrenTasksHierarchyOp non-resizeable task to multi window, task=" + task);
        return false;
    L13:
        if (ArrayUtils.isEmpty(hop.getActivityTypes()) == true) goto L18;
        if (ArrayUtils.contains(hop.getActivityTypes(), task.getActivityType()) == true) goto L18;
        return false;
    L18:
        if (ArrayUtils.isEmpty(hop.getWindowingModes()) == true) goto L23;
        if (ArrayUtils.contains(hop.getWindowingModes(), task.getWindowingMode()) == true) goto L23;
        return false;
    L23:
        if (isLockTaskModeViolation(finalNewParent, task, isInLockTaskMode) == false) goto L26;
        return false;
    L26:
        if (hop.getToTop() == false) goto L28;
        tasksToReparent.add(0, task);
    L30:
        if (hop.getReparentTopOnly() == true) goto L32;
        return false;
    L32:
        if (tasksToReparent.size() == 1) goto L34;
        return false;
    L34:
        return true;
    L28:
        tasksToReparent.add(task);
        goto L30
    }

    private int setAdjacentRootsHierarchyOp(WindowContainerTransaction.HierarchyOp hop) {
        IBinder[] containers = hop.getContainers();
        ArraySet<TaskFragment> adjacentRoots = new ArraySet();
        int r2 = containers.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L24;
        IBinder container = containers[r4];
        WindowContainer wc = WindowContainer.fromBinder(container);
        if (wc == null) goto L22;
        if (wc.isAttached() == false) goto L22;
        Task root = wc.asTask();
        if (root == null) goto L21;
        if (root.mCreatedByOrganizer == false) goto L19;
        if (adjacentRoots.contains(root) == true) goto L17;
        adjacentRoots.add(root);
        r4 = r4 + 1;
        goto L3
    L17:
        throw new IllegalArgumentException("setAdjacentRootsHierarchyOp: called with same root twice=" + root);
    L19:
        throw new IllegalArgumentException("setAdjacentRootsHierarchyOp: Not created by organizer root=" + root);
    L21:
        throw new IllegalArgumentException("setAdjacentRootsHierarchyOp: Not called with Task. wc=" + wc);
    L22:
        Slog.e(TAG, "Attempt to operate on unknown or detached container: " + wc);
        return 0;
    L24:
        TaskFragment root0 = adjacentRoots.valueAt(0);
        TaskFragment.AdjacentSet adjacentSet = new TaskFragment.AdjacentSet(adjacentRoots);
        if (adjacentSet.equals(root0.getAdjacentTaskFragments()) == false) goto L27;
        return 0;
    L27:
        root0.setAdjacentTaskFragments(adjacentSet);
        return 2;
    }

    private int clearAdjacentRootsHierarchyOp(WindowContainerTransaction.HierarchyOp hop) {
        WindowContainer wc = WindowContainer.fromBinder(hop.getContainer());
        if (wc != null) goto L5;
    L16:
        Slog.e(TAG, "Attempt to operate on unknown or detached container: " + wc);
        return 0;
    L5:
        if (wc.isAttached() == false) goto L16;
        TaskFragment root = wc.asTaskFragment();
        if (root.mCreatedByOrganizer == false) goto L15;
        if (root.hasAdjacentTaskFragment() == true) goto L12;
        return 0;
    L12:
        root.removeFromAdjacentTaskFragments();
        return 2;
    L15:
        throw new IllegalArgumentException("clearAdjacentRootsHierarchyOp: Not created by organizer root=" + root);
    }

    private void sanitizeWindowContainer(WindowContainer wc) {
        if ((wc instanceof TaskFragment) == false) goto L5;
        return;
    L5:
        if ((wc instanceof DisplayArea) == false) goto L8;
        return;
    L8:
        throw new RuntimeException("Invalid token in task fragment or displayArea transaction");
    }

    private int applyWindowContainerChange(WindowContainer wc, WindowContainerTransaction.Change c, IBinder errorCallbackToken) {
        sanitizeWindowContainer(wc);
        if (wc.asDisplayArea() == null) goto L7;
        return applyDisplayAreaChanges(wc.asDisplayArea(), c);
    L7:
        if (wc.asTask() == null) goto L11;
        return applyTaskChanges(wc.asTask(), c);
    L11:
        if (wc.asTaskFragment() == null) goto L17;
        if (wc.asTaskFragment().isEmbedded() == false) goto L17;
        return applyTaskFragmentChanges(wc.asTaskFragment(), c, errorCallbackToken);
    L17:
        return applyChanges(wc, c);
    }

    public ITaskOrganizerController getTaskOrganizerController() {
        ActivityTaskManagerService.enforceTaskPermission("getTaskOrganizerController()");
        return this.mTaskOrganizerController;
    }

    public IDisplayAreaOrganizerController getDisplayAreaOrganizerController() {
        ActivityTaskManagerService.enforceTaskPermission("getDisplayAreaOrganizerController()");
        return this.mDisplayAreaOrganizerController;
    }

    public ITaskFragmentOrganizerController getTaskFragmentOrganizerController() {
        return this.mTaskFragmentOrganizerController;
    }

    private BLASTSyncEngine.SyncGroup prepareSyncWithOrganizer(IWindowContainerTransactionCallback callback) {
        BLASTSyncEngine.SyncGroup s = this.mService.mWindowManager.mSyncEngine.prepareSyncSet(this, "Organizer");
        this.mTransactionCallbacksByPendingSyncId.put(Integer.valueOf(s.mSyncId), callback);
        return s;
    }

    int startSyncWithOrganizer(IWindowContainerTransactionCallback callback) {
        BLASTSyncEngine.SyncGroup s = prepareSyncWithOrganizer(callback);
        this.mService.mWindowManager.mSyncEngine.startSyncSet(s);
        return s.mSyncId;
    }

    void setSyncReady(int id) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L5;
        long protoLogParam0 = id;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, 433446585990132440L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L5:
        this.mService.mWindowManager.mSyncEngine.setReady(id);
    }

    void addToSyncSet(int syncId, WindowContainer wc) {
        this.mService.mWindowManager.mSyncEngine.addToSyncSet(syncId, wc);
    }

    @Override // com.android.server.wm.BLASTSyncEngine.TransactionReadyListener
    public void onTransactionReady(int syncId, SurfaceControl.Transaction t) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L5;
        long protoLogParam0 = syncId;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, 6552038620140878489L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L5:
        IWindowContainerTransactionCallback callback = this.mTransactionCallbacksByPendingSyncId.get(Integer.valueOf(syncId));
        callback.onTransactionReady(syncId, t);     // Catch: RemoteException -> L8
    L10:
        this.mTransactionCallbacksByPendingSyncId.remove(Integer.valueOf(syncId));
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Failed to notify transaction (" + syncId + ") ready", e);
        t.apply();
        goto L10
    }

    public void registerTransitionPlayer(ITransitionPlayer player) {
        ActivityTaskManagerService.enforceTaskPermission("registerTransitionPlayer()");
        int callerPid = Binder.getCallingPid();
        int callerUid = Binder.getCallingUid();
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r4 = this.mGlobalLock;     // Catch: Throwable -> L10
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L10
        monitor-enter(r4);     // Catch: Throwable -> L10
        WindowProcessController wpc = this.mService.getProcessController(callerPid, callerUid);     // Catch: Throwable -> L12
        this.mTransitionController.registerTransitionPlayer(player, wpc);     // Catch: Throwable -> L12
        monitor-exit(r4);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void unregisterTransitionPlayer(ITransitionPlayer player) {
        ActivityTaskManagerService.enforceTaskPermission("unregisterTransitionPlayer()");
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L10
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L10
        monitor-enter(r2);     // Catch: Throwable -> L10
        this.mTransitionController.unregisterTransitionPlayer(player);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public ITransitionMetricsReporter getTransitionMetricsReporter() {
        return this.mTransitionController.mTransitionMetricsReporter;
    }

    public IBinder getApplyToken() {
        ActivityTaskManagerService.enforceTaskPermission("getApplyToken()");
        return SurfaceControl.Transaction.getDefaultApplyToken();
    }

    static boolean configurationsAreEqualForOrganizer(Configuration newConfig, Configuration oldConfig) {
        return configurationsAreEqualForOrganizer(newConfig, oldConfig, 0);
    }

    static boolean configurationsAreEqualForOrganizer(Configuration newConfig, Configuration oldConfig, int additionalMask) {
        if (oldConfig != null) goto L5;
        return false;
    L5:
        int cfgChanges = newConfig.diff(oldConfig);
        if ((cfgChanges & additionalMask) == 0) goto L9;
        return false;
    L9:
        if ((536870912 & cfgChanges) == 0) goto L11;
        int winCfgChanges = (int) newConfig.windowConfiguration.diff(oldConfig.windowConfiguration, true);
    L13:
        if ((winCfgChanges & 3) != 0) goto L16;
        cfgChanges = cfgChanges & (-536870913);
    L16:
        if ((CONTROLLABLE_CONFIGS & cfgChanges) == 0) goto L18;
        return false;
    L18:
        return true;
    L11:
        winCfgChanges = 0;
        goto L13
    }

    private void enforceTaskFragmentOrganizerPermission(String func, ITaskFragmentOrganizer organizer, WindowContainerTransaction t) {
        Iterator<Map.Entry<IBinder, WindowContainerTransaction.Change>> entries = t.getChanges().entrySet().iterator();
    L4:
        if (entries.hasNext() == false) goto L6;
        Map.Entry<IBinder, WindowContainerTransaction.Change> entry = entries.next();
        WindowContainer wc = WindowContainer.fromBinder(entry.getKey());
        enforceTaskFragmentConfigChangeAllowed(func, wc, entry.getValue(), organizer);
        goto L4
    L6:
        List<WindowContainerTransaction.HierarchyOp> hops = t.getHierarchyOps();
        int i = hops.size() - 1;
    L7:
        if (i < 0) goto L20;
        WindowContainerTransaction.HierarchyOp hop = hops.get(i);
        int type = hop.getType();
        switch(type) {
            case 14: goto L18;
            case 17: goto L12;
            default: goto L10;
        };
    L12:
        enforceTaskFragmentOrganized(func, hop.getContainer(), organizer);
        if (hop.getTaskFragmentOperation() == null) goto L18;
        if (hop.getTaskFragmentOperation().getSecondaryFragmentToken() == null) goto L18;
        enforceTaskFragmentOrganized(func, hop.getTaskFragmentOperation().getSecondaryFragmentToken(), organizer);
        goto L18
    L10:
        String msg = "Permission Denial: " + func + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " trying to apply a hierarchy change that is not allowed for TaskFragmentOrganizer=" + organizer;
        Slog.w(TAG, msg);
        throw new SecurityException(msg);
    L18:
        i = i - 1;
        goto L7
    }

    private void enforceTaskFragmentOrganized(String func, IBinder fragmentToken, ITaskFragmentOrganizer organizer) {
        fragmentToken.getClass();
        TaskFragment tf = this.mLaunchTaskFragments.get(fragmentToken);
        if (tf != null) goto L5;
        return;
    L5:
        if (tf.hasTaskFragmentOrganizer(organizer) == true) goto L10;
        String msg = "Permission Denial: " + func + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " trying to modify TaskFragment not belonging to the TaskFragmentOrganizer=" + organizer;
        Slog.w(TAG, msg);
        throw new SecurityException(msg);
    }

    private void enforceTaskFragmentConfigChangeAllowed(String func, WindowContainer wc, WindowContainerTransaction.Change change, ITaskFragmentOrganizer organizer) {
        if (wc != null) goto L6;
        Slog.e(TAG, "Attempt to operate on task fragment that no longer exists");
        return;
    L6:
        TaskFragment tf = wc.asTaskFragment();
        if (tf != null) goto L9;
    L26:
        String msg = "Permission Denial: " + func + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " trying to modify window container not belonging to the TaskFragmentOrganizer=" + organizer;
        Slog.w(TAG, msg);
        throw new SecurityException(msg);
    L9:
        if (tf.hasTaskFragmentOrganizer(organizer) == false) goto L26;
        int originalChangeMask = change.getChangeMask();
        int originalConfigSetMask = change.getConfigSetMask();
        int originalWindowSetMask = change.getWindowSetMask();
        int changeMaskToBeChecked = originalChangeMask;
        int configSetMaskToBeChecked = originalConfigSetMask;
        int windowSetMaskToBeChecked = originalWindowSetMask;
        if (this.mTaskFragmentOrganizerController.isSystemOrganizer(organizer.asBinder()) == false) goto L14;
        changeMaskToBeChecked = ((changeMaskToBeChecked & (-9)) & (-2)) & (-65);
    L14:
        if ((changeMaskToBeChecked & 256) != 0) goto L16;
    L20:
        if (changeMaskToBeChecked != 0) goto L24;
        if (configSetMaskToBeChecked != 0) goto L24;
        if (windowSetMaskToBeChecked != 0) goto L24;
        return;
    L24:
        String msg2 = "Permission Denial: " + func + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " trying to apply changes of changeMask=" + originalChangeMask + " configSetMask=" + originalConfigSetMask + " windowSetMask=" + originalWindowSetMask + " to TaskFragment=" + tf + " TaskFragmentOrganizer=" + organizer;
        Slog.w(TAG, msg2);
        throw new SecurityException(msg2);
    L16:
        if ((536870912 & configSetMaskToBeChecked) == 0) goto L20;
        if ((windowSetMaskToBeChecked & 1) == 0) goto L20;
        changeMaskToBeChecked = changeMaskToBeChecked & (-257);
        configSetMaskToBeChecked = configSetMaskToBeChecked & (-536870913);
        windowSetMaskToBeChecked = windowSetMaskToBeChecked & (-2);
        goto L20
    }

    private void createTaskFragment(TaskFragmentCreationParams creationParams, IBinder errorCallbackToken, CallerInfo caller, Transition transition) {
        ActivityRecord ownerActivity = ActivityRecord.forTokenLocked(creationParams.getOwnerToken());
        ITaskFragmentOrganizer organizer = ITaskFragmentOrganizer.Stub.asInterface(creationParams.getOrganizer().asBinder());
        if (this.mLaunchTaskFragments.containsKey(creationParams.getFragmentToken()) == false) goto L7;
        Throwable exception = new IllegalArgumentException("TaskFragment token must be unique");
        sendTaskFragmentOperationFailure(organizer, errorCallbackToken, null, 0, exception);
        return;
    L7:
        if (ownerActivity != null) goto L9;
    L52:
        Throwable exception2 = new IllegalArgumentException("Not allowed to operate with invalid ownerToken");
        sendTaskFragmentOperationFailure(organizer, errorCallbackToken, null, 0, exception2);
        return;
    L9:
        if (ownerActivity.getTask() == null) goto L52;
        if (ownerActivity.isResizeable() == true) goto L15;
        Throwable exception3 = new IllegalArgumentException("Not allowed to operate with non-resizable owner Activity");
        sendTaskFragmentOperationFailure(organizer, errorCallbackToken, null, 0, exception3);
        return;
    L15:
        Task ownerTask = ownerActivity.getTask();
        if (ownerTask.effectiveUid != ownerActivity.getUid()) goto L50;
        if (ownerTask.effectiveUid != caller.mUid) goto L50;
        if (ownerTask.inPinnedWindowingMode() == false) goto L24;
        Throwable exception4 = new IllegalArgumentException("Not allowed to create TaskFragment in PIP Task");
        sendTaskFragmentOperationFailure(organizer, errorCallbackToken, null, 0, exception4);
        return;
    L24:
        TaskFragment taskFragment = new TaskFragment(this.mService, creationParams.getFragmentToken(), true);
        taskFragment.setAllowTransitionWhenEmpty(creationParams.getAllowTransitionWhenEmpty());
        TaskFragmentOrganizerToken organizerToken = creationParams.getOrganizer();
        taskFragment.setTaskFragmentOrganizer(organizerToken, ownerActivity.getUid(), ownerActivity.info.processName);
        if (this.mTaskFragmentOrganizerController.isSystemOrganizer(organizerToken.asBinder()) == false) goto L27;
        taskFragment.setOverrideOrientation(creationParams.getOverrideOrientation());
        taskFragment.setConfigurationChangeMaskForOrganizer(creationParams.getConfigurationChangeMask());
    L27:
        int position = Integer.MAX_VALUE;
        if (creationParams.getPairedPrimaryFragmentToken() == null) goto L34;
        TaskFragment pairedPrimaryTaskFragment = getTaskFragment(creationParams.getPairedPrimaryFragmentToken());
        int pairedPosition = ownerTask.mChildren.indexOf(pairedPrimaryTaskFragment);
        if (pairedPosition == (-1)) goto L40;
        position = pairedPosition + 1;
    L40:
        ownerTask.addChild(taskFragment, position);
        EventLogTags.writeWmTfCreated(System.identityHashCode(taskFragment), ownerTask.mTaskId);
        taskFragment.setWindowingMode(creationParams.getWindowingMode());
        if (creationParams.getInitialRelativeBounds().isEmpty() == true) goto L45;
        if (transition == null) goto L44;
        addToSyncSet(transition.getSyncId(), taskFragment);
    L44:
        taskFragment.setRelativeEmbeddedBounds(creationParams.getInitialRelativeBounds());
        taskFragment.recomputeConfiguration();
    L45:
        this.mLaunchTaskFragments.put(creationParams.getFragmentToken(), taskFragment);
        if (transition == null) goto L54;
        transition.collectExistenceChange(taskFragment);
        return;
    L54:
        return;
    L34:
        if (creationParams.getPairedActivityToken() == null) goto L39;
        ActivityRecord pairedActivity = ActivityRecord.forTokenLocked(creationParams.getPairedActivityToken());
        int pairedPosition2 = ownerTask.mChildren.indexOf(pairedActivity);
        if (pairedPosition2 == (-1)) goto L40;
        position = pairedPosition2 + 1;
        goto L40
    L39:
        position = Integer.MAX_VALUE;
    L50:
        Throwable exception5 = new SecurityException("Not allowed to operate with the ownerToken while the root activity of the target task belong to the different app");
        sendTaskFragmentOperationFailure(organizer, errorCallbackToken, null, 0, exception5);
    }

    private int deleteTaskFragment(TaskFragment taskFragment, Transition transition) {
        if (taskFragment.getNonFinishingActivityCount() != 0) goto L5;
        boolean isEmpty = true;
    L7:
        if (transition != null) goto L9;
    L13:
        this.mLaunchTaskFragments.remove(taskFragment.getFragmentToken());
        taskFragment.remove(true, "deleteTaskFragment");
        if (isEmpty == false) goto L16;
        return 0;
    L16:
        return 2;
    L9:
        if (taskFragment.isVisibleRequested() == false) goto L11;
    L12:
        transition.collectExistenceChange(taskFragment);
        goto L13
    L11:
        if (transition.mChanges.containsKey(taskFragment) == false) goto L13;
    L5:
        isEmpty = false;
        goto L7
    }

    TaskFragment getTaskFragment(IBinder tfToken) {
        return this.mLaunchTaskFragments.get(tfToken);
    }

    void cleanUpEmbeddedTaskFragment(TaskFragment taskFragment) {
        this.mLaunchTaskFragments.remove(taskFragment.getFragmentToken());
    }

    void sendTaskFragmentOperationFailure(ITaskFragmentOrganizer organizer, IBinder errorCallbackToken, TaskFragment taskFragment, int opType, Throwable exception) {
        if (organizer == null) goto L6;
        this.mService.mTaskFragmentOrganizerController.onTaskFragmentError(organizer, errorCallbackToken, taskFragment, opType, exception);
        return;
    L6:
        throw new IllegalArgumentException("Not allowed to operate with invalid organizer");
    }

    private Throwable convertStartFailureToThrowable(int result, Intent intent) {
        switch(result) {
            case -96: goto L10;
            case -95: goto L4;
            case -94: goto L8;
            case -93: goto L4;
            case -92: goto L6;
            case -91: goto L6;
            default: goto L4;
        };
    L4:
        return new AndroidRuntimeException("Start activity failed with error code : " + result + " when starting " + intent);
    L6:
        return new ActivityNotFoundException("No Activity found to handle " + intent);
    L8:
        return new SecurityException("Permission denied and not allowed to start activity " + intent);
    L10:
        return new AndroidRuntimeException("Activity could not be started for " + intent + " with error code : " + result);
    }

    public void setTransitionRecentsFromRemote(IBinder transitionToken, boolean forBackOrHome) {
        this.mExt.setTransitionRecentsFromRemote(this.mService, transitionToken, forBackOrHome);
    }
}
