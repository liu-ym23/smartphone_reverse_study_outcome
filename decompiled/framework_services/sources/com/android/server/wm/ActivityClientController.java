package com.android.server.wm;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.ActivityTaskManager;
import android.app.IActivityClientController;
import android.app.IRequestFinishCallback;
import android.app.PictureInPictureParams;
import android.app.PictureInPictureUiState;
import android.app.compat.CompatChanges;
import android.app.servertransaction.EnterPipRequestedItem;
import android.app.servertransaction.PipStateTransactionItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManagerInternal;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IRemoteCallback;
import android.os.Parcel;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.pico.utils.ExtImplFactory;
import android.service.voice.VoiceInteractionManagerInternal;
import android.util.Slog;
import android.view.RemoteAnimationDefinition;
import android.window.DesktopModeFlags;
import android.window.SizeConfigurationBuckets;
import com.android.internal.app.AssistUtils;
import com.android.internal.policy.IKeyguardDismissCallback;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.Watchdog;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.redmagic.GameKeysPatch;
import com.android.server.uri.GrantUri;
import com.android.server.uri.NeededUriGrants;
import com.android.server.utils.quota.Categorizer;
import com.android.server.utils.quota.Category;
import com.android.server.utils.quota.CountQuotaTracker;
import com.android.server.vr.VrManagerInternal;
import com.obric.server.memorydata.MemoryManagerService;

/* JADX INFO: loaded from: classes3.dex */
class ActivityClientController extends IActivityClientController.Stub {
    public static final long ACCESS_SHARED_IDENTITY = 259743961;
    private static final int SET_PIP_ASPECT_RATIO_LIMIT = 60;
    private static final long SET_PIP_ASPECT_RATIO_TIME_WINDOW_MS = 60000;
    private static final String TAG = "ActivityTaskManager";
    private AssistUtils mAssistUtils;
    private final Context mContext;
    private final IExtActivityClientController mExt;
    private final WindowManagerGlobalLock mGlobalLock;
    private final ActivityTaskManagerService mService;
    CountQuotaTracker mSetPipAspectRatioQuotaTracker;
    private final ActivityTaskSupervisor mTaskSupervisor;

    public static /* synthetic */ boolean $r8$lambda$1K74oNoLM00IYeFPYBFWMo7jaJA(ActivityRecord r0) {
        return lambda$getActivityTokenBelow$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$XDVPmSdO0TMqES0GwXvvEaWnMbQ(ActivityRecord r0, String r1, int r2, ActivityRecord r3) {
        lambda$finishSubActivity$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$ZeND8mzkQh_40uyO6jAvnWund7s(ActivityClientController r0, int r1, IRemoteCallback r2, ActivityRecord r3, Transition r4, boolean r5) {
        r0.lambda$requestMultiwindowFullscreenLocked$3(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ boolean $r8$lambda$_yDUpQL7bkortdMmLrMuunWf26Q(ActivityRecord r0, ActivityRecord r1) {
        return lambda$finishActivityAffinity$0(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$qNqLz69Nnzxwo0uHEnCtzeO7idI(ActivityRecord r0, ActivityRecord r1) {
        return lambda$isRelativeTaskRootActivity$4(r0, r1);
    }

    ActivityClientController(ActivityTaskManagerService service) {
        this.mService = service;
        this.mGlobalLock = service.mGlobalLock;
        this.mTaskSupervisor = service.mTaskSupervisor;
        this.mContext = service.mContext;
        this.mExt = (IExtActivityClientController) ExtImplFactory.getImpl(IExtActivityClientController.class, new Object[]{this, this.mService});
    }

    void onSystemReady() {
        this.mAssistUtils = new AssistUtils(this.mContext);
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        return super.onTransact(code, data, reply, flags);
    L4:
        e = move-exception;
        throw ActivityTaskManagerService.logAndRethrowRuntimeExceptionOnTransact("ActivityClientController", e);
    }

    public void activityIdle(IBinder token, Configuration config, boolean stopProfiling) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r4 = this.mGlobalLock;     // Catch: Throwable -> L21
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L21
        monitor-enter(r4);     // Catch: Throwable -> L21
        Trace.traceBegin(32, "activityIdle");     // Catch: Throwable -> L10
        ActivityRecord r = ActivityRecord.forTokenLocked(token);     // Catch: Throwable -> L10
        if (r != null) goto L12;
        monitor-exit(r4);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Trace.traceEnd(32);
        Binder.restoreCallingIdentity(origId);
        return;
    L12:
        this.mTaskSupervisor.activityIdleInternal(r, false, false, config);     // Catch: Throwable -> L10
        if (stopProfiling == true) goto L15;
    L17:
        monitor-exit(r4);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L21
        Trace.traceEnd(32);
        Binder.restoreCallingIdentity(origId);
        return;
    L15:
        if (r.hasProcess() == false) goto L17;
        r.app.clearProfilerIfNeeded();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Trace.traceEnd(32);
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void activityResumed(IBinder token, boolean handleSplashScreenExit) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        ActivityRecord.activityResumedLocked(token, handleSplashScreenExit);     // Catch: Throwable -> L9
        ActivityRecord r = ActivityRecord.forTokenLocked(token);     // Catch: Throwable -> L9
        if (r != null) goto L7;
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L7:
        if (r.getRootTask() == null) goto L11;
        r.getRootTask().getExt().notifyAppRequestOrientation(r);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void activityRefreshed(IBinder token) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        ActivityRecord.activityRefreshedLocked(token);     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void activityTopResumedStateLost() {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        this.mTaskSupervisor.handleTopResumedStateReleased(false);     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void activityPaused(IBinder token) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        Trace.traceBegin(32, "activityPaused");     // Catch: Throwable -> L7
        ActivityRecord r = ActivityRecord.forTokenLocked(token);     // Catch: Throwable -> L7
        if (r == null) goto L9;
        r.activityPaused(false);     // Catch: Throwable -> L7
        SysOptBridge.getFactory().notifyActivityPausedForTopSvp(r.getPid());     // Catch: Throwable -> L7
    L9:
        Trace.traceEnd(32);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void activityOnPauseFinished(IBinder token) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        ActivityRecord r = ActivityRecord.forTokenLocked(token);     // Catch: Throwable -> L7
        if (r == null) goto L9;
        SysOptBridge.getFactory().notifyActivityPausedForTopSvp(r.getPid());     // Catch: Throwable -> L7
    L9:
        monitor-exit(r2);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void activityStopped(IBinder token, Bundle icicle, PersistableBundle persistentState, CharSequence description) {
        if (ActivityTaskManagerDebugConfig.DEBUG_ALL == false) goto L5;
        Slog.v(TAG, "Activity stopped: token=" + token);
    L5:
        if (icicle != null) goto L7;
    L11:
        long origId = Binder.clearCallingIdentity();
        String restartingName = null;
        int restartingUid = 0;
        WindowManagerGlobalLock r4 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r4);
        Trace.traceBegin(32, "activityStopped");     // Catch: Throwable -> L20
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L20
        if (r != null) goto L16;
    L30:
        Trace.traceEnd(32);     // Catch: Throwable -> L20
        monitor-exit(r4);     // Catch: Throwable -> L20
        WindowManagerService.resetPriorityAfterLockedSection();
        if (restartingName == null) goto L35;
        this.mTaskSupervisor.removeRestartTimeouts(r);
        this.mService.mAmInternal.killProcess(restartingName, restartingUid, "restartActivityProcess");
    L35:
        this.mService.mAmInternal.trimApplications();
        Binder.restoreCallingIdentity(origId);
        return;
    L16:
        if (r.isState(ActivityRecord.State.STOPPING, ActivityRecord.State.RESTARTING_PROCESS) == true) goto L23;
        if (this.mTaskSupervisor.hasScheduledRestartTimeouts(r) == false) goto L23;
        r.setState(ActivityRecord.State.RESTARTING_PROCESS, "continue-restart");     // Catch: Throwable -> L20
    L23:
        if (r.attachedToProcess() == true) goto L25;
    L27:
        r.activityStopped(icicle, persistentState, description);     // Catch: Throwable -> L20
        IExtActivityClientController ext = getExt();     // Catch: Throwable -> L20
        if (ext == null) goto L30;
        ext.scheduleExecutePendingToggleSwitchFromFullScreenToFreeform("activityStopped");     // Catch: Throwable -> L20
        goto L30
    L25:
        if (r.isState(ActivityRecord.State.RESTARTING_PROCESS) == false) goto L27;
        restartingName = r.app.mName;     // Catch: Throwable -> L20
        restartingUid = r.app.mUid;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L7:
        if (icicle.hasFileDescriptors() == false) goto L11;
        throw new IllegalArgumentException("File descriptors passed in Bundle");
    }

    public void activityDestroyed(IBinder token) {
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L5;
        Slog.v(TAG, "ACTIVITY DESTROYED: " + token);
    L5:
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        Trace.traceBegin(32, "activityDestroyed");     // Catch: Throwable -> L18
        ActivityRecord r = ActivityRecord.forTokenLocked(token);     // Catch: Throwable -> L12
        if (r == null) goto L14;
        r.destroyed("activityDestroyed");     // Catch: Throwable -> L12
    L14:
        Trace.traceEnd(32);     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        Trace.traceEnd(32);     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void activityLocalRelaunch(IBinder token) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        ActivityRecord r = ActivityRecord.forTokenLocked(token);     // Catch: Throwable -> L7
        if (r == null) goto L9;
        r.startRelaunching();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r2);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void activityRelaunched(IBinder token) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        ActivityRecord r = ActivityRecord.forTokenLocked(token);     // Catch: Throwable -> L7
        if (r == null) goto L9;
        r.finishRelaunching();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r2);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void reportSizeConfigurations(IBinder token, SizeConfigurationBuckets sizeConfigurations) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L5;
        String protoLogParam0 = String.valueOf(token);
        String protoLogParam1 = String.valueOf(sizeConfigurations);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, -4921282642721622589L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L5:
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L10
        if (r == null) goto L12;
        r.setSizeConfigurations(sizeConfigurations);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean moveActivityTaskToBack(IBinder token, boolean nonRoot) {
        ActivityTaskManagerService.enforceNotIsolatedCaller("moveActivityTaskToBack");
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L22
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L22
        monitor-enter(r2);     // Catch: Throwable -> L22
        if (nonRoot == true) goto L8;
        boolean r4 = true;
    L30:
        int taskId = ActivityRecord.getTaskForActivityLocked(token, r4);     // Catch: Throwable -> L15
        Task task = this.mService.mRootWindowContainer.anyTaskForId(taskId);     // Catch: Throwable -> L15
        if (task == null) goto L18;
        boolean r3 = ActivityRecord.getRootTask(token).moveTaskToBack(task);     // Catch: Throwable -> L15
        monitor-exit(r2);     // Catch: Throwable -> L15
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r3;
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L15
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L22
        Binder.restoreCallingIdentity(origId);
        return false;
    L15:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L8:
        r4 = false;
    L22:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public boolean shouldUpRecreateTask(IBinder token, String destAffinity) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord srec = ActivityRecord.forTokenLocked(token);     // Catch: Throwable -> L10
        if (srec == null) goto L13;
        boolean r2 = srec.getRootTask().shouldUpRecreateTaskLocked(srec, destAffinity);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean navigateUpTo(IBinder token, Intent destIntent, String resolvedType, int resultCode, Intent resultData) {
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L9
        if (r != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        NeededUriGrants destGrants = this.mService.collectGrants(destIntent, r);
        NeededUriGrants resultGrants = this.mService.collectGrants(resultData, r.resultTo);
        WindowManagerGlobalLock r10 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r10);
        boolean r0 = r.getRootTask().navigateUpTo(r, destIntent, resolvedType, destGrants, resultCode, resultData, resultGrants);     // Catch: Throwable -> L18
        monitor-exit(r10);     // Catch: Throwable -> L18
        WindowManagerService.resetPriorityAfterLockedSection();
        return r0;
    L18:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean releaseActivityInstance(IBinder token) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L22
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L22
        monitor-enter(r2);     // Catch: Throwable -> L22
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L14
        if (r == null) goto L16;
        if (r.isDestroyable() == false) goto L16;
        r.destroyImmediately("app-req");     // Catch: Throwable -> L14
        boolean r4 = r.isState(ActivityRecord.State.DESTROYING, ActivityRecord.State.DESTROYED);     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r4;
    L16:
        monitor-exit(r2);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return false;
    L14:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public boolean finishActivity(IBinder token, int resultCode, Intent resultData, int finishTask) {
        if (resultData != null) goto L5;
    L9:
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L16
        boolean r5 = true;
        if (r != null) goto L18;
        monitor-exit(r2);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();
        NeededUriGrants resultGrants = this.mService.collectGrants(resultData, r.resultTo);
        WindowManagerGlobalLock r9 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r9);
    L115:
        th = th;
    L117:
        monitor-exit(r9);     // Catch: Throwable -> L101
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L133:
        if (r.isInHistory() == true) goto L28;
        monitor-exit(r9);     // Catch: Throwable -> L26
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    L28:
        Task tr = r.getTask();     // Catch: Throwable -> L115
        ActivityRecord rootR = tr.getRootActivity();     // Catch: Throwable -> L115
        if (rootR != null) goto L34;
        Slog.w(TAG, "Finishing task with all activities already finished");     // Catch: Throwable -> L26
    L34:
        if (this.mService.getLockTaskController().activityBlockedFromFinish(r) == false) goto L39;
        monitor-exit(r9);     // Catch: Throwable -> L26
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L39:
        if (this.mService.mController == null) goto L59;
        ActivityRecord next = r.getRootTask().topRunningActivity(token, -1);     // Catch: Throwable -> L26
        if (next == null) goto L59;
        boolean resumeOK = true;
        resumeOK = this.mService.mController.activityResuming(next.packageName);     // Catch: Throwable -> L26 RemoteException -> L48
    L50:
        if (resumeOK == true) goto L59;
        Slog.i(TAG, "Not finishing activity because controller resumed");     // Catch: Throwable -> L26
        monitor-exit(r9);     // Catch: Throwable -> L26
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L49:
        this.mService.mController = null;     // Catch: Throwable -> L26
        Watchdog.getInstance().setActivityController(null);     // Catch: Throwable -> L26
    L55:
        th = th;
    L59:
        if (r.app == null) goto L61;
        r.app.setLastActivityFinishTimeIfNeeded(SystemClock.uptimeMillis());     // Catch: Throwable -> L26
    L61:
        this.mService.mAmInternal.addCreatorToken(resultData, r.packageName);     // Catch: Throwable -> L115
        long origId = Binder.clearCallingIdentity();     // Catch: Throwable -> L115
        Trace.traceBegin(32, "finishActivity");     // Catch: Throwable -> L115
        r.releaseActivityBoost();     // Catch: Throwable -> L111
        if (finishTask == 1) goto L66;
        r5 = false;
    L66:
        boolean finishWithRootActivity = r5;
        this.mTaskSupervisor.getBackgroundActivityLaunchController().onActivityRequestedFinishing(r);     // Catch: Throwable -> L111
        if (finishTask == 2) goto L131;
        if (finishWithRootActivity == false) goto L127;
        if (r == rootR) goto L131;
    L127:
        r.finishIfPossible(resultCode, resultData, resultGrants, "app-request", true);     // Catch: Throwable -> L83
        r = r;
        boolean res = r.finishing;     // Catch: Throwable -> L80
        if (res == true) goto L82;
        Slog.i(TAG, "Failed to finish by app-request");     // Catch: Throwable -> L80
    L82:
        long r20 = 32;
        boolean finishWithRootActivity2 = res;
    L97:
        SysOptBridge.getFactory().getProcessIntercept().activityFinished(r.info);     // Catch: Throwable -> L101
        Trace.traceEnd(r20);     // Catch: Throwable -> L101
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L101
        monitor-exit(r9);     // Catch: Throwable -> L101
        WindowManagerService.resetPriorityAfterLockedSection();
        return finishWithRootActivity2;
    L80:
        th = th;
        r20 = 32;
    L113:
        SysOptBridge.getFactory().getProcessIntercept().activityFinished(r.info);     // Catch: Throwable -> L101
        Trace.traceEnd(r20);     // Catch: Throwable -> L101
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L101
        throw th;     // Catch: Throwable -> L101
    L83:
        th = th;
        r = r;
        r20 = 32;
    L131:
        r20 = 32;
        this.mTaskSupervisor.removeTask(tr, false, finishWithRootActivity, "finish-activity", r.getUid(), r.getPid(), r.info.name);     // Catch: Throwable -> L103
        finishWithRootActivity2 = true;
        r.mRelaunchReason = 0;     // Catch: Throwable -> L103
    L103:
        th = th;
    L105:
        th = th;
        r20 = 32;
    L109:
        th = th;
        r20 = 32;
    L111:
        th = th;
        r20 = 32;
    L26:
        th = th;
    L101:
        th = th;
    L16:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (resultData.hasFileDescriptors() == false) goto L9;
        throw new IllegalArgumentException("File descriptors passed in Intent");
    }

    public boolean finishActivityAffinity(IBinder token) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L24
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L24
        monitor-enter(r2);     // Catch: Throwable -> L24
        final ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L10
        if (r != null) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return false;
    L13:
        if (this.mService.getLockTaskController().activityBlockedFromFinish(r) == false) goto L17;
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return false;
    L17:
        r.getTask().forAllActivities(new ActivityClientController$$ExternalSyntheticLambda0(r), r, true, true);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return true;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    private static /* synthetic */ boolean lambda$finishActivityAffinity$0(ActivityRecord r, ActivityRecord activity) {
        return r.finishIfSameAffinity(activity);
    }

    public void finishSubActivity(IBinder token, final String resultWho, final int requestCode) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L17
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L17
        monitor-enter(r2);     // Catch: Throwable -> L17
        final ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L10
        if (r != null) goto L12;
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L12:
        r.getRootTask().forAllActivities(new ActivityClientController$$ExternalSyntheticLambda3(r, resultWho, requestCode), true);     // Catch: Throwable -> L10
        this.mService.updateOomAdj();     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(origId);
        return;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    private static /* synthetic */ void lambda$finishSubActivity$1(ActivityRecord r, String resultWho, int requestCode, ActivityRecord activity) {
        activity.finishIfSubActivity(r, resultWho, requestCode);
    }

    public void setForceSendResultForMediaProjection(IBinder token) {
        this.mService.mAmInternal.enforceCallingPermission("android.permission.MANAGE_MEDIA_PROJECTION", "setForceSendResultForMediaProjection");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L13
        if (r == null) goto L15;
        if (r.isInHistory() == false) goto L15;
        r.setForceSendResultForMediaProjection();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L13:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean isTopOfTask(IBinder token) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L9
        if (r != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L7:
        if (r.getTask().getTopNonFinishingActivity() != r) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean willActivityBeVisible(IBinder token) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Task rootTask = ActivityRecord.getRootTask(token);     // Catch: Throwable -> L9
        if (rootTask != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L7:
        if (rootTask.willActivityBeVisible(token) == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public int getDisplayId(IBinder activityToken) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Task rootTask = ActivityRecord.getRootTask(activityToken);     // Catch: Throwable -> L12
        int r2 = 0;
        if (rootTask == null) goto L14;
        int displayId = rootTask.getDisplayId();     // Catch: Throwable -> L12
        if (displayId == (-1)) goto L9;
        r2 = displayId;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public int getTaskForActivity(IBinder token, boolean onlyRoot) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = ActivityRecord.forTokenLocked(token);     // Catch: Throwable -> L9
        int r2 = -1;
        if (r != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return -1;
    L11:
        Task task = r.getTask();     // Catch: Throwable -> L9
        if (onlyRoot == true) goto L14;
        int r3 = task.mTaskId;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return r3;
    L14:
        if (task.getRootActivity() != r) goto L16;
        r2 = task.mTaskId;     // Catch: Throwable -> L9
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public Configuration getTaskConfiguration(IBinder activityToken) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord ar = ActivityRecord.isInAnyTask(activityToken);     // Catch: Throwable -> L9
        if (ar != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L11:
        Configuration r2 = ar.getTask().getConfiguration();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public IBinder getActivityTokenBelow(IBinder activityToken) {
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L24
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L24
        monitor-enter(r2);     // Catch: Throwable -> L24
        ActivityRecord ar = ActivityRecord.isInAnyTask(activityToken);     // Catch: Throwable -> L10
        if (ar != null) goto L12;
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return null;
    L12:
        ActivityRecord below = ar.getTask().getActivity(new ActivityClientController$$ExternalSyntheticLambda1(), ar, false, true);     // Catch: Throwable -> L10
        if (below != null) goto L15;
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L24
        Binder.restoreCallingIdentity(ident);
        return null;
    L15:
        if (below.getUid() != ar.getUid()) goto L20;
        IBinder r4 = below.token;     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return r4;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private static /* synthetic */ boolean lambda$getActivityTokenBelow$2(ActivityRecord r) {
        return !r.finishing;
    }

    public ComponentName getCallingActivity(IBinder token) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = getCallingRecord(token);     // Catch: Throwable -> L7
        if (r == null) goto L9;
        ComponentName r2 = r.intent.getComponent();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L9:
        r2 = null;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public String getCallingPackage(IBinder token) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = getCallingRecord(token);     // Catch: Throwable -> L7
        if (r == null) goto L9;
        String r2 = r.info.packageName;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L9:
        r2 = null;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static ActivityRecord getCallingRecord(IBinder token) {
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);
        if (r != null) goto L7;
        return null;
    L7:
        return r.resultTo;
    }

    public int getLaunchedFromUid(IBinder token) {
        return getUid(token, null, false);
    }

    public String getLaunchedFromPackage(IBinder token) {
        return getPackage(token, null, false);
    }

    public int getActivityCallerUid(IBinder activityToken, IBinder callerToken) {
        return getUid(activityToken, callerToken, true);
    }

    public String getActivityCallerPackage(IBinder activityToken, IBinder callerToken) {
        return getPackage(activityToken, callerToken, true);
    }

    private int getUid(IBinder activityToken, IBinder callerToken, boolean isActivityCallerCall) {
        int uid = Binder.getCallingUid();
        boolean isInternalCaller = isInternalCallerGetLaunchedFrom(uid);
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        ActivityRecord r = ActivityRecord.forTokenLocked(activityToken);     // Catch: Throwable -> L10
        if (r == null) goto L20;
        if (isInternalCaller == true) goto L13;
        if (canGetLaunchedFromLocked(uid, r, callerToken, isActivityCallerCall) == false) goto L20;
    L13:
        if (isValidCaller(r, callerToken, isActivityCallerCall) == false) goto L20;
        if (isActivityCallerCall == false) goto L16;
        int r4 = r.getCallerUid(callerToken);     // Catch: Throwable -> L10
    L17:
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return r4;
    L16:
        r4 = r.launchedFromUid;     // Catch: Throwable -> L10
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return -1;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private String getPackage(IBinder activityToken, IBinder callerToken, boolean isActivityCallerCall) {
        int uid = Binder.getCallingUid();
        boolean isInternalCaller = isInternalCallerGetLaunchedFrom(uid);
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        ActivityRecord r = ActivityRecord.forTokenLocked(activityToken);     // Catch: Throwable -> L10
        if (r == null) goto L20;
        if (isInternalCaller == true) goto L13;
        if (canGetLaunchedFromLocked(uid, r, callerToken, isActivityCallerCall) == false) goto L20;
    L13:
        if (isValidCaller(r, callerToken, isActivityCallerCall) == false) goto L20;
        if (isActivityCallerCall == false) goto L16;
        String r4 = r.getCallerPackage(callerToken);     // Catch: Throwable -> L10
    L17:
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return r4;
    L16:
        r4 = r.launchedFromPackage;     // Catch: Throwable -> L10
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private boolean isValidCaller(ActivityRecord r, IBinder callerToken, boolean isActivityCallerCall) {
        if (isActivityCallerCall == true) goto L8;
        if (callerToken != null) goto L6;
        return true;
    L6:
        return false;
    L8:
        return r.hasCaller(callerToken);
    }

    public int checkActivityCallerContentUriPermission(IBinder activityToken, IBinder callerToken, Uri uri, int modeFlags, int userId) {
        GrantUri grantUri = new GrantUri(userId, uri, modeFlags);
        if (this.mService.mUgmInternal.checkUriPermission(grantUri, Binder.getCallingUid(), modeFlags, true) == false) goto L24;
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        ActivityRecord r = ActivityRecord.forTokenLocked(activityToken);     // Catch: Throwable -> L14
        int r3 = -1;
        if (r == null) goto L17;
        boolean granted = r.checkContentUriPermission(callerToken, grantUri, modeFlags);     // Catch: Throwable -> L14
        if (granted == false) goto L11;
        r3 = 0;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        return r3;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        return -1;
    L14:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L24:
        throw new SecurityException("You don't have access to the content URI, hence can't check if the caller has access to it: " + uri);
    }

    private boolean isInternalCallerGetLaunchedFrom(int uid) {
        if (UserHandle.getAppId(uid) != 1000) goto L5;
        return true;
    L5:
        PackageManagerInternal pm = this.mService.mWindowManager.mPmInternal;
        AndroidPackage callingPkg = pm.getPackage(uid);
        if (callingPkg != null) goto L9;
        return false;
    L9:
        if (callingPkg.isSignedWithPlatformKey() == false) goto L11;
        return true;
    L11:
        String[] installerNames = pm.getKnownPackageNames(2, UserHandle.getUserId(uid));
        if (installerNames.length <= 0) goto L17;
        if (callingPkg.getPackageName().equals(installerNames[0]) == false) goto L17;
        return true;
    L17:
        return false;
    }

    private static boolean canGetLaunchedFromLocked(int uid, ActivityRecord r, IBinder callerToken, boolean isActivityCallerCall) {
        if (CompatChanges.isChangeEnabled(ACCESS_SHARED_IDENTITY, uid) == false) goto L14;
        if (isActivityCallerCall == false) goto L6;
        boolean isShareIdentityEnabled = r.isCallerShareIdentityEnabled(callerToken);
    L7:
        if (isActivityCallerCall == false) goto L9;
        int callerUid = r.getCallerUid(callerToken);
    L10:
        if (isShareIdentityEnabled == true) goto L12;
        if (callerUid == uid) goto L12;
        return false;
    L12:
        return true;
    L9:
        callerUid = r.launchedFromUid;
        goto L10
    L6:
        isShareIdentityEnabled = r.mShareIdentity;
        goto L7
    L14:
        return false;
    }

    public void setRequestedOrientation(IBinder token, int requestedOrientation) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L16
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L16
        monitor-enter(r2);     // Catch: Throwable -> L16
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L10
        if (r == null) goto L12;
        EventLogTags.writeWmSetRequestedOrientation(requestedOrientation, r.shortComponentName);     // Catch: Throwable -> L10
        r.setRequestedOrientation(requestedOrientation);     // Catch: Throwable -> L10
        if (r.getRootTask() == null) goto L12;
        r.getRootTask().getExt().notifyAppRequestOrientation(r);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(origId);
        return;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public int getRequestedOrientation(IBinder token) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L7
        if (r == null) goto L9;
        int r2 = r.getOverrideOrientation();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L9:
        r2 = -1;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean convertFromTranslucent(IBinder token) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L29
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L29
        monitor-enter(r2);     // Catch: Throwable -> L29
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L10
        if (r != null) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return false;
    L13:
        if (r.mTransitionController.isShellTransitionsEnabled() == true) goto L15;
    L17:
        Transition transition = null;
    L18:
        boolean changed = r.setOccludesParent(true);     // Catch: Throwable -> L10
        if (transition == null) goto L23;
        if (changed == false) goto L22;
        transition.setOverrideAnimation(android.window.TransitionInfo.AnimationOptions.makeSceneTransitionAnimOptions(), r, null, null);     // Catch: Throwable -> L10
        r.mTransitionController.requestStartTransition(transition, null, null, null);     // Catch: Throwable -> L10
        r.mTransitionController.setReady(r.getDisplayContent());     // Catch: Throwable -> L10
        goto L23
    L22:
        transition.abort();     // Catch: Throwable -> L10
    L23:
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return changed;
    L15:
        if (r.mTransitionController.isCollecting() == true) goto L17;
        transition = r.mTransitionController.createTransition(4);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public boolean convertToTranslucent(IBinder token, Bundle options) {
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        SafeActivityOptions safeOptions = SafeActivityOptions.fromBundle(options, callingPid, callingUid);
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r5 = this.mGlobalLock;     // Catch: Throwable -> L43
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L43
        monitor-enter(r5);     // Catch: Throwable -> L43
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L10
        if (r != null) goto L12;
        monitor-exit(r5);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return false;
    L12:
        ActivityRecord under = r.getTask().getActivityBelow(r);     // Catch: Throwable -> L10
        if (under == null) goto L21;
        if (safeOptions == null) goto L16;
        ActivityOptions r10 = safeOptions.getOptions(r);     // Catch: Throwable -> L10
    L17:
        under.returningOptions = r10;     // Catch: Throwable -> L10
        if (under.returningOptions != null) goto L21;
        under.returningOptions = ActivityOptions.makeSceneTransitionOptions();     // Catch: Throwable -> L10
        goto L21
    L16:
        r10 = null;
    L21:
        if (r.mTransitionController.isShellTransitionsEnabled() == true) goto L23;
    L25:
        Transition transition = null;
    L26:
        boolean changed = r.setOccludesParent(false);     // Catch: Throwable -> L10
        if (transition == null) goto L37;
        if (changed == false) goto L36;
        r.mTransitionController.requestStartTransition(transition, null, null, null);     // Catch: Throwable -> L10
        r.mTransitionController.setReady(r.getDisplayContent());     // Catch: Throwable -> L10
        if (under == null) goto L37;
        if (under.returningOptions == null) goto L37;
        if (under.returningOptions.getAnimationType() != 5) goto L37;
        transition.setOverrideAnimation(android.window.TransitionInfo.AnimationOptions.makeSceneTransitionAnimOptions(), r, null, null);     // Catch: Throwable -> L10
        goto L37
    L36:
        transition.abort();     // Catch: Throwable -> L10
    L37:
        monitor-exit(r5);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return changed;
    L23:
        if (r.mTransitionController.isCollecting() == true) goto L25;
        transition = r.mTransitionController.createTransition(3);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public boolean isImmersive(IBinder token) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L10
        if (r == null) goto L13;
        boolean r2 = r.immersive;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L13:
        throw new IllegalArgumentException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void setImmersive(IBinder token, boolean immersive) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L11
        if (r == null) goto L18;
        r.immersive = immersive;     // Catch: Throwable -> L11
        if (r.isFocusedActivityOnDisplay() == true) goto L9;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IMMERSIVE_enabled[0] == false) goto L13;
        String protoLogParam0 = String.valueOf(r);     // Catch: Throwable -> L11
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_IMMERSIVE, -1597980207704427048L, 0, new Object[]{protoLogParam0});     // Catch: Throwable -> L11
    L13:
        this.mService.applyUpdateLockStateLocked(r);     // Catch: Throwable -> L11
        goto L14
    L18:
        throw new IllegalArgumentException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean enterPictureInPictureMode(IBinder token, PictureInPictureParams params) {
        long origId = Binder.clearCallingIdentity();
        ensureSetPipAspectRatioQuotaTracker();     // Catch: Throwable -> L13
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L13
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L13
        monitor-enter(r2);     // Catch: Throwable -> L13
        ActivityRecord r = ensureValidPictureInPictureActivityParams("enterPictureInPictureMode", token, params);     // Catch: Throwable -> L9
        boolean r4 = this.mService.enterPictureInPictureMode(r, params, true);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r4;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void setPictureInPictureParams(IBinder token, PictureInPictureParams params) {
        long origId = Binder.clearCallingIdentity();
        ensureSetPipAspectRatioQuotaTracker();     // Catch: Throwable -> L10
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L10
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L10
        monitor-enter(r2);     // Catch: Throwable -> L10
        ActivityRecord r = ensureValidPictureInPictureActivityParams("setPictureInPictureParams", token, params);     // Catch: Throwable -> L12
        r.setPictureInPictureParams(params);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(origId);
        return;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void setShouldDockBigOverlays(IBinder token, boolean shouldDockBigOverlays) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L10
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L10
        monitor-enter(r2);     // Catch: Throwable -> L10
        ActivityRecord r = ActivityRecord.forTokenLocked(token);     // Catch: Throwable -> L12
        r.setShouldDockBigOverlays(shouldDockBigOverlays);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(origId);
        return;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void splashScreenAttached(IBinder token) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        ActivityRecord.splashScreenAttachedLocked(token);     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void ensureSetPipAspectRatioQuotaTracker() {
        if (this.mSetPipAspectRatioQuotaTracker != null) goto L6;
        this.mSetPipAspectRatioQuotaTracker = new CountQuotaTracker(this.mContext, Categorizer.SINGLE_CATEGORIZER);
        this.mSetPipAspectRatioQuotaTracker.setCountLimit(Category.SINGLE_CATEGORY, 60, 60000);
        return;
    }

    private ActivityRecord ensureValidPictureInPictureActivityParams(String caller, IBinder token, PictureInPictureParams params) {
        if (this.mService.mSupportsPictureInPicture == false) goto L42;
        ActivityRecord r = ActivityRecord.forTokenLocked(token);
        if (r == null) goto L40;
        if (r.supportsPictureInPicture() == false) goto L38;
        int userId = UserHandle.getCallingUserId();
        if (r.pictureInPictureArgs.hasSetAspectRatio() == true) goto L11;
    L19:
        float minAspectRatio = this.mContext.getResources().getFloat(R.dimen.disabled_alpha_material_dark);
        float maxAspectRatio = this.mContext.getResources().getFloat(R.dimen.disabled_alpha_leanback_formwizard);
        if (params.hasSetAspectRatio() == false) goto L27;
        if (this.mService.mWindowManager.isValidPictureInPictureAspectRatio(r.mDisplayContent, params.getAspectRatioFloat()) == true) goto L27;
        throw new IllegalArgumentException(String.format(caller + ": Aspect ratio is too extreme (must be between %f and %f).", new Object[]{Float.valueOf(minAspectRatio), Float.valueOf(maxAspectRatio)}));
    L27:
        if (this.mService.mSupportsExpandedPictureInPicture == true) goto L29;
    L35:
        params.truncateActions(ActivityTaskManager.getMaxNumPictureInPictureActions(this.mContext));
        return r;
    L29:
        if (params.hasSetExpandedAspectRatio() == false) goto L35;
        if (this.mService.mWindowManager.isValidExpandedPictureInPictureAspectRatio(r.mDisplayContent, params.getExpandedAspectRatioFloat()) == true) goto L35;
        throw new IllegalArgumentException(String.format(caller + ": Expanded aspect ratio is not extreme enough (must not be between %f and %f).", new Object[]{Float.valueOf(minAspectRatio), Float.valueOf(maxAspectRatio)}));
    L11:
        if (params.hasSetAspectRatio() == false) goto L19;
        if (r.pictureInPictureArgs.getAspectRatio().equals(params.getAspectRatio()) == true) goto L19;
        if (this.mSetPipAspectRatioQuotaTracker.noteEvent(userId, r.packageName, "setPipAspectRatio") == true) goto L19;
        throw new IllegalStateException(caller + ": Too many PiP aspect ratio change requests from " + r.packageName);
    L38:
        throw new IllegalStateException(caller + ": Current activity does not support picture-in-picture.");
    L40:
        throw new IllegalStateException(caller + ": Can't find activity for token=" + token);
    L42:
        throw new IllegalStateException(caller + ": Device doesn't support picture-in-picture mode.");
    }

    boolean requestPictureInPictureMode(ActivityRecord r) {
        if (r.inPinnedWindowingMode() == false) goto L5;
        return false;
    L5:
        boolean canEnterPictureInPicture = r.checkEnterPictureInPictureState("requestPictureInPictureMode", false);
        if (canEnterPictureInPicture == true) goto L9;
        return false;
    L9:
        if (r.pictureInPictureArgs.isAutoEnterEnabled() == false) goto L18;
        return this.mService.enterPictureInPictureMode(r, r.pictureInPictureArgs, false);
    L18:
        return this.mService.getLifecycleManager().scheduleTransactionItem(r.app.getThread(), new EnterPipRequestedItem(r.token));
    L15:
        e = move-exception;
        Slog.w(TAG, "Failed to send enter pip requested item: " + r.intent.getComponent(), e);
        return false;
    }

    void onPictureInPictureUiStateChanged(ActivityRecord r, PictureInPictureUiState pipState) {
        if (r.attachedToProcess() == true) goto L12;
        Slog.w(TAG, "Skip sending pip state transaction item to detached activity: " + r.intent.getComponent() + " state=" + r.getState());
        return;
    L12:
        this.mService.getLifecycleManager().scheduleTransactionItem(r.app.getThread(), new PipStateTransactionItem(r.token, pipState));     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        Slog.w(TAG, "Failed to send pip state transaction item: " + r.intent.getComponent(), e);
    }

    public void toggleFreeformWindowingMode(IBinder token) {
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L31
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L31
        monitor-enter(r2);     // Catch: Throwable -> L31
        ActivityRecord r = ActivityRecord.forTokenLocked(token);     // Catch: Throwable -> L16
        if (r == null) goto L38;
        Task rootTask = r.getRootTask();     // Catch: Throwable -> L16
        if (rootTask == null) goto L36;
        if (rootTask.inFreeformWindowingMode() == true) goto L19;
        if (rootTask.getWindowingMode() == 1) goto L19;
        throw new IllegalStateException("toggleFreeformWindowingMode: You can only toggle between fullscreen and freeform.");     // Catch: Throwable -> L16
    L19:
        if (rootTask.inFreeformWindowingMode() == false) goto L22;
        rootTask.setRootTaskWindowingMode(1);     // Catch: Throwable -> L16
        rootTask.setBounds(null);     // Catch: Throwable -> L16
    L27:
        monitor-exit(r2);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L31
        Binder.restoreCallingIdentity(ident);
        return;
    L22:
        if (r.supportsFreeform() == false) goto L34;
        if (rootTask.getParent().inFreeformWindowingMode() == false) goto L26;
        rootTask.setRootTaskWindowingMode(0);     // Catch: Throwable -> L16
        goto L27
    L26:
        rootTask.setRootTaskWindowingMode(5);     // Catch: Throwable -> L16
        goto L27
    L34:
        throw new IllegalStateException("This activity is currently not freeform-enabled");     // Catch: Throwable -> L16
    L36:
        throw new IllegalStateException("toggleFreeformWindowingMode: the activity doesn't have a root task");     // Catch: Throwable -> L16
    L38:
        throw new IllegalArgumentException("toggleFreeformWindowingMode: No activity record matching token=" + token);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private int validateMultiwindowFullscreenRequestLocked(Task topFocusedRootTask, int fullscreenRequest, ActivityRecord requesterActivity) {
        if (requesterActivity.getWindowingMode() != 2) goto L5;
        return 0;
    L5:
        int taskWindowingMode = topFocusedRootTask.getWindowingMode();
        if (requesterActivity == topFocusedRootTask.getTopMostActivity()) goto L9;
        return 2;
    L9:
        if (fullscreenRequest != 0) goto L17;
        if (taskWindowingMode == 1) goto L13;
        return 1;
    L13:
        if (topFocusedRootTask.mMultiWindowRestoreWindowingMode != (-1)) goto L15;
        return 1;
    L15:
        return 0;
    L17:
        if (DesktopModeFlags.ENABLE_REQUEST_FULLSCREEN_BUGFIX.isTrue() == false) goto L23;
        if (taskWindowingMode != 1) goto L20;
        return 3;
    L20:
        if (taskWindowingMode != 6) goto L23;
        return 3;
    L23:
        return 0;
    }

    public void requestMultiwindowFullscreen(IBinder callingActivity, int fullscreenRequest, IRemoteCallback callback) {
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L10
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L10
        monitor-enter(r2);     // Catch: Throwable -> L10
        requestMultiwindowFullscreenLocked(callingActivity, fullscreenRequest, callback);     // Catch: Throwable -> L12
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

    private void requestMultiwindowFullscreenLocked(IBinder callingActivity, final int fullscreenRequest, final IRemoteCallback callback) {
        final ActivityRecord r = ActivityRecord.forTokenLocked(callingActivity);
        if (r != null) goto L5;
        return;
    L5:
        TransitionController controller = r.mTransitionController;
        if (controller.isShellTransitionsEnabled() == true) goto L11;
        Task topFocusedRootTask = this.mService.getTopDisplayFocusedRootTask();
        int validateResult = validateMultiwindowFullscreenRequestLocked(topFocusedRootTask, fullscreenRequest, r);
        reportMultiwindowFullscreenRequestValidatingResult(callback, validateResult);
        if (validateResult != 0) goto L13;
        executeMultiWindowFullscreenRequest(fullscreenRequest, topFocusedRootTask);
        return;
    L13:
        return;
    L11:
        final Transition transition = new Transition(6, 0, controller, this.mService.mWindowManager.mSyncEngine);
        r.mTransitionController.startCollectOrQueue(transition, new ActivityClientController$$ExternalSyntheticLambda4(this, fullscreenRequest, callback, r, transition));
    }

    private /* synthetic */ void lambda$requestMultiwindowFullscreenLocked$3(int fullscreenRequest, IRemoteCallback callback, ActivityRecord r, Transition transition, boolean deferred) {
        executeFullscreenRequestTransition(fullscreenRequest, callback, r, transition, deferred);
    }

    private void executeFullscreenRequestTransition(int fullscreenRequest, IRemoteCallback callback, ActivityRecord r, Transition transition, boolean queued) {
        Task topFocusedRootTask = this.mService.getTopDisplayFocusedRootTask();
        int validateResult = validateMultiwindowFullscreenRequestLocked(topFocusedRootTask, fullscreenRequest, r);
        reportMultiwindowFullscreenRequestValidatingResult(callback, validateResult);
        if (validateResult == 0) goto L6;
        transition.abort();
        return;
    L6:
        Task requestingTask = r.getTask();
        transition.collect(requestingTask);
        executeMultiWindowFullscreenRequest(fullscreenRequest, requestingTask);
        r.mTransitionController.requestStartTransition(transition, requestingTask, null, null);
        transition.setReady(requestingTask, true);
    }

    private static void reportMultiwindowFullscreenRequestValidatingResult(IRemoteCallback callback, int result) {
        if (callback != null) goto L4;
        return;
    L4:
        Bundle res = new Bundle();
        res.putInt(MemoryManagerService.RESULT_KEY, result);
        callback.sendResult(res);     // Catch: RemoteException -> L7
        return;
    L8:
        Slog.w(TAG, "client throws an exception back to the server, ignore it");
    }

    private void executeMultiWindowFullscreenRequest(int fullscreenRequest, Task requester) {
        if (fullscreenRequest != 1) goto L5;
        int restoreWindowingMode = requester.getRequestedOverrideWindowingMode();
        int targetWindowingMode = 1;
        requester.setRootTaskWindowingMode(1);
        requester.mMultiWindowRestoreWindowingMode = restoreWindowingMode;
        requester.mMultiWindowRestoreParent = requester.getParent().mRemoteToken.toWindowContainerToken();
    L11:
        if (targetWindowingMode != 1) goto L14;
        requester.setBounds(null);
        return;
    L14:
        return;
    L5:
        targetWindowingMode = requester.mMultiWindowRestoreWindowingMode;
        if (DesktopModeFlags.ENABLE_REQUEST_FULLSCREEN_BUGFIX.isTrue() == true) goto L8;
    L10:
        requester.restoreWindowingMode();
        goto L11
    L8:
        if (targetWindowingMode != 2) goto L10;
        ActivityRecord r = requester.topRunningActivity();
        enterPictureInPictureMode(r.token, r.pictureInPictureArgs);
        goto L11
    }

    public void startLockTaskModeByToken(IBinder token) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = ActivityRecord.forTokenLocked(token);     // Catch: Throwable -> L9
        if (r != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L11:
        this.mService.startLockTaskMode(r.getTask(), false);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void stopLockTaskModeByToken(IBinder token) {
        this.mService.stopLockTaskModeInternal(token, false);
    }

    public void showLockTaskEscapeMessage(IBinder token) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (ActivityRecord.forTokenLocked(token) == null) goto L9;
        this.mService.getLockTaskController().showLockTaskToast();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    public void setTaskDescription(IBinder token, ActivityManager.TaskDescription td) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L9
        if (r == null) goto L11;
        r.setTaskDescription(td);     // Catch: Throwable -> L9
        GameKeysPatch gameKeysPatch = GameKeysPatch.getInstance();     // Catch: Throwable -> L9
        if (gameKeysPatch == null) goto L11;
        gameKeysPatch.monitorWxMiniPrograme(this.mContext, r, td);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean showAssistFromActivity(IBinder token, Bundle args) {
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r3 = this.mGlobalLock;     // Catch: Throwable -> L32
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L32
        monitor-enter(r3);     // Catch: Throwable -> L32
        ActivityRecord caller = ActivityRecord.forTokenLocked(token);     // Catch: Throwable -> L34
        Task topRootTask = this.mService.getTopDisplayFocusedRootTask();     // Catch: Throwable -> L34
        if (topRootTask != null) goto L48;
        ActivityRecord top = null;
    L12:
        if (top == caller) goto L18;
        Slog.w(TAG, "showAssistFromActivity failed: caller " + caller + " is not current top " + top);     // Catch: Throwable -> L8
        monitor-exit(r3);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return false;
    L18:
        if (top.nowVisible == true) goto L23;
        Slog.w(TAG, "showAssistFromActivity failed: caller " + caller + " is not visible");     // Catch: Throwable -> L8
        monitor-exit(r3);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return false;
    L23:
        String callingAttributionTag = top.launchedFromFeatureId;     // Catch: Throwable -> L34
        monitor-exit(r3);     // Catch: Throwable -> L34
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L32
        boolean r14 = this.mAssistUtils.showSessionForActiveService(args, 8, callingAttributionTag, null, token);     // Catch: Throwable -> L30
        Binder.restoreCallingIdentity(ident);
        return r14;
    L48:
        top = topRootTask.getTopNonFinishingActivity();     // Catch: Throwable -> L8
    L8:
        th = th;
    L45:
        monitor-exit(r3);     // Catch: Throwable -> L39
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L39:
        th = th;
    L34:
        th = th;
    L30:
        th = move-exception;
        Throwable r15 = th;
    L41:
        Binder.restoreCallingIdentity(ident);
        throw r15;
    L32:
        th = move-exception;
        r15 = th;
        goto L41
    }

    public boolean isRootVoiceInteraction(IBinder token) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L9
        if (r != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L7:
        if (r.rootVoiceInteraction == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void startLocalVoiceInteraction(IBinder callingActivity, Bundle options) {
        Slog.i(TAG, "Activity tried to startLocalVoiceInteraction");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Task topRootTask = this.mService.getTopDisplayFocusedRootTask();     // Catch: Throwable -> L7
        if (topRootTask == null) goto L9;
        ActivityRecord activity = topRootTask.getTopNonFinishingActivity();     // Catch: Throwable -> L7
    L11:
        if (ActivityRecord.forTokenLocked(callingActivity) != activity) goto L35;
        if (this.mService.mRunningVoice != null) goto L30;
        if (activity.getTask().voiceSession != null) goto L30;
        if (activity.voiceSession != null) goto L30;
        if (activity.pendingVoiceInteractionStart == false) goto L26;
        Slog.w(TAG, "Pending start of voice interaction already.");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L26:
        activity.pendingVoiceInteractionStart = true;     // Catch: Throwable -> L7
        String callingAttributionTag = activity.launchedFromFeatureId;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        ((VoiceInteractionManagerInternal) LocalServices.getService(VoiceInteractionManagerInternal.class)).startLocalVoiceInteraction(callingActivity, callingAttributionTag, options);
        return;
    L30:
        Slog.w(TAG, "Already in a voice interaction, cannot start new voice interaction");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L35:
        throw new SecurityException("Only focused activity can call startVoiceInteraction");     // Catch: Throwable -> L7
    L9:
        activity = null;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void stopLocalVoiceInteraction(IBinder callingActivity) {
        ((VoiceInteractionManagerInternal) LocalServices.getService(VoiceInteractionManagerInternal.class)).stopLocalVoiceInteraction(callingActivity);
    }

    public void setShowWhenLocked(IBinder token, boolean showWhenLocked) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L14
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L8
        Slog.d(TAG, "setShowWhenLocked(" + showWhenLocked + ") r=" + r);     // Catch: Throwable -> L8
        if (r == null) goto L10;
        r.setShowWhenLocked(showWhenLocked);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(origId);
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void setInheritShowWhenLocked(IBinder token, boolean inheritShowWhenLocked) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L14
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L8
        if (r == null) goto L10;
        r.setInheritShowWhenLocked(inheritShowWhenLocked);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(origId);
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void setTurnScreenOn(IBinder token, boolean turnScreenOn) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L14
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L8
        if (r == null) goto L10;
        r.setTurnScreenOn(turnScreenOn);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(origId);
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void setAllowCrossUidActivitySwitchFromBelow(IBinder token, boolean allowed) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L14
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L8
        if (r == null) goto L10;
        r.setAllowCrossUidActivitySwitchFromBelow(allowed);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(origId);
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void reportActivityFullyDrawn(IBinder token, boolean restoredFromBundle) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L14
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L8
        if (r == null) goto L10;
        this.mTaskSupervisor.getActivityMetricsLogger().notifyFullyDrawn(r, restoredFromBundle);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(origId);
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void overrideActivityTransition(IBinder token, boolean open, int enterAnim, int exitAnim, int backgroundColor) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L7
        if (r == null) goto L9;
        r.overrideCustomTransition(open, enterAnim, exitAnim, backgroundColor);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r2);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void clearOverrideActivityTransition(IBinder token, boolean open) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L7
        if (r == null) goto L9;
        r.clearCustomTransition(open);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r2);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void overridePendingTransition(IBinder token, String packageName, int enterAnim, int exitAnim, int backgroundColor) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L11
        if (r != null) goto L7;
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L7:
        if (r.isState(ActivityRecord.State.RESUMED, ActivityRecord.State.PAUSING) == false) goto L14;
        if (r.getExt().shouldEnableTaskAnimation(r.info) == false) goto L13;
        r.mOverrideTaskTransition = true;     // Catch: Throwable -> L11
    L13:
        r.mTransitionController.setOverrideAnimation(android.window.TransitionInfo.AnimationOptions.makeCustomAnimOptions(packageName, enterAnim, 0, exitAnim, r.mOverrideTaskTransition), r, null, null);     // Catch: Throwable -> L11
        r.mTransitionController.setOverrideBackgroundColor(backgroundColor);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public int setVrMode(IBinder token, boolean enabled, ComponentName packageName) {
        this.mService.enforceSystemHasVrFeature();
        VrManagerInternal vrService = (VrManagerInternal) LocalServices.getService(VrManagerInternal.class);
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L33
        monitor-exit(r1);     // Catch: Throwable -> L33
        WindowManagerService.resetPriorityAfterLockedSection();
        if (r == null) goto L32;
        int err = vrService.hasVrPackage(packageName, r.mUserId);
        if (err == 0) goto L11;
        return err;
    L11:
        long callingId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L28
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L28
        monitor-enter(r2);     // Catch: Throwable -> L28
        if (enabled == false) goto L16;
        ComponentName r6 = packageName;
    L37:
        r.requestedVrComponent = r6;     // Catch: Throwable -> L20
        if (r.isFocusedActivityOnDisplay() == false) goto L22;
        this.mService.applyUpdateVrModeLocked(r);     // Catch: Throwable -> L20
    L22:
        monitor-exit(r2);     // Catch: Throwable -> L20
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(callingId);
        return 0;
    L20:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L16:
        r6 = null;
    L28:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    L32:
        throw new IllegalArgumentException();
    L33:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void setRecentsScreenshotEnabled(IBinder token, boolean enabled) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L14
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L8
        if (r == null) goto L10;
        r.setRecentsScreenshotEnabled(enabled);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(origId);
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    void restartActivityProcessIfVisible(IBinder token) {
        ActivityTaskManagerService.enforceTaskPermission("restartActivityProcess");
        long callingId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L14
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L8
        if (r == null) goto L10;
        r.restartProcessIfVisible();     // Catch: Throwable -> L8
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(callingId);
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    }

    public void invalidateHomeTaskSnapshot(IBinder token) {
        if (token != null) goto L4;
        ActivityTaskManagerService.enforceTaskPermission("invalidateHomeTaskSnapshot");
    L4:
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        if (token != null) goto L14;
        Task rootTask = this.mService.mRootWindowContainer.getDefaultTaskDisplayArea().getRootHomeTask();     // Catch: Throwable -> L10
        if (rootTask == null) goto L12;
        ActivityRecord r = rootTask.topRunningActivity();     // Catch: Throwable -> L10
    L15:
        if (r != null) goto L17;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L17:
        if (r.isActivityTypeHome() == false) goto L19;
        this.mService.mWindowManager.mTaskSnapshotController.removeSnapshotCache(r.getTask().mTaskId);     // Catch: Throwable -> L10
        goto L19
    L12:
        r = null;
        goto L15
    L14:
        r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void dismissKeyguard(IBinder token, IKeyguardDismissCallback callback, CharSequence message) {
        if (message == null) goto L4;
        this.mService.mAmInternal.enforceCallingPermission("android.permission.SHOW_KEYGUARD_MESSAGE", "dismissKeyguard");
    L4:
        long callingId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L12
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        this.mService.mKeyguardController.dismissKeyguard(token, callback, message);     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(callingId);
        return;
    L14:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    }

    public void registerRemoteAnimations(IBinder token, RemoteAnimationDefinition definition) {
        this.mService.mAmInternal.enforceCallingPermission("android.permission.CONTROL_REMOTE_APP_TRANSITION_ANIMATIONS", "registerRemoteAnimations");
        definition.setCallingPidUid(Binder.getCallingPid(), Binder.getCallingUid());
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L14
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L8
        if (r == null) goto L10;
        r.registerRemoteAnimations(definition);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(origId);
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void unregisterRemoteAnimations(IBinder token) {
        this.mService.mAmInternal.enforceCallingPermission("android.permission.CONTROL_REMOTE_APP_TRANSITION_ANIMATIONS", "unregisterRemoteAnimations");
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L14
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L8
        if (r == null) goto L10;
        r.unregisterRemoteAnimations();     // Catch: Throwable -> L8
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(origId);
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    private static boolean isRelativeTaskRootActivity(final ActivityRecord r, ActivityRecord taskRoot) {
        TaskFragment taskFragment = r.getTaskFragment();
        if (r == taskFragment.getActivity(new ActivityClientController$$ExternalSyntheticLambda2(r), false)) goto L6;
        return false;
    L6:
        if (taskRoot.getTaskFragment().getCompanionTaskFragment() != taskFragment) goto L9;
        return true;
    L9:
        return false;
    }

    private static /* synthetic */ boolean lambda$isRelativeTaskRootActivity$4(ActivityRecord r, ActivityRecord ar) {
        if (ar.finishing == false) goto L7;
        if (ar == r) goto L7;
        return false;
    L7:
        return true;
    }

    private static boolean isTopActivityInTaskFragment(ActivityRecord activity) {
        if (activity.getTaskFragment().topRunningActivity() != activity) goto L5;
        return true;
    L5:
        return false;
    }

    private void requestCallbackFinish(IRequestFinishCallback callback) {
        callback.requestFinish();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to invoke request finish callback", e);
    }

    public void onBackPressed(IBinder token, IRequestFinishCallback callback) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L30
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L30
        monitor-enter(r2);     // Catch: Throwable -> L30
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(token);     // Catch: Throwable -> L10
        if (r != null) goto L12;
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L12:
        Task task = r.getTask();     // Catch: Throwable -> L10
        ActivityRecord root = task.getRootActivity(false, true);     // Catch: Throwable -> L10
        if (r != root) goto L20;
        if (this.mService.mWindowOrganizerController.mTaskOrganizerController.handleInterceptBackPressedOnTaskRoot(r.getRootTask()) == false) goto L20;
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L20:
        if (shouldMoveTaskToBack(r, root) == false) goto L26;
        moveActivityTaskToBack(token, true);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L26:
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L30
        requestCallbackFinish(callback);     // Catch: Throwable -> L30
        Binder.restoreCallingIdentity(origId);
        return;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    static boolean shouldMoveTaskToBack(ActivityRecord r, ActivityRecord rootActivity) {
        if (r != rootActivity) goto L5;
    L7:
        boolean isBaseActivity = rootActivity.mActivityComponent.equals(r.getTask().realActivity);
        if (isBaseActivity == false) goto L10;
        Intent baseActivityIntent = rootActivity.intent;
    L11:
        if (baseActivityIntent != null) goto L13;
        return false;
    L13:
        if (isTopActivityInTaskFragment(r) == true) goto L15;
        return false;
    L15:
        if (rootActivity.isLaunchSourceType(2) == true) goto L17;
        return false;
    L17:
        if (ActivityRecord.isMainIntent(baseActivityIntent) == false) goto L24;
        return true;
    L24:
        return false;
    L10:
        baseActivityIntent = null;
        goto L11
    L5:
        if (isRelativeTaskRootActivity(r, rootActivity) == true) goto L7;
        return false;
    }

    public void enableTaskLocaleOverride(IBinder token) {
        if (UserHandle.getAppId(Binder.getCallingUid()) == 1000) goto L5;
        return;
    L5:
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = ActivityRecord.forTokenLocked(token);     // Catch: Throwable -> L10
        if (r == null) goto L12;
        r.getTask().mAlignActivityLocaleWithTask = true;     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean isRequestedToLaunchInTaskFragment(IBinder activityToken, IBinder taskFragmentToken) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(activityToken);     // Catch: Throwable -> L9
        boolean r2 = false;
        if (r != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L12:
        if (r.mRequestedLaunchingTaskFragmentToken != taskFragmentToken) goto L14;
        r2 = true;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void setActivityRecordInputSinkEnabled(IBinder activityToken, boolean enabled) {
        this.mService.mAmInternal.enforceCallingPermission("android.permission.INTERNAL_SYSTEM_WINDOW", "setActivityRecordInputSinkEnabled");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = ActivityRecord.forTokenLocked(activityToken);     // Catch: Throwable -> L7
        if (r == null) goto L9;
        r.mActivityRecordInputSinkEnabled = enabled;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean supportFreefrom(int taskId) {
        return this.mExt.supportFreefrom(taskId);
    }

    public boolean toggleSwitchFromFullScreenToFreeform(int taskId, int startMode) {
        return this.mExt.toggleSwitchFromFullScreenToFreeform(taskId, startMode);
    }

    IExtActivityClientController getExt() {
        return this.mExt;
    }
}
