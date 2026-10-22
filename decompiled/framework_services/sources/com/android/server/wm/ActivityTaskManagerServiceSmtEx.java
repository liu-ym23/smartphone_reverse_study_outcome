package com.android.server.wm;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IRemoteCallback;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Pair;
import android.util.Slog;
import com.android.server.appop.AppOpsService;
import com.android.server.voiceinteraction.DatabaseHelper;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityTaskManagerServiceSmtEx extends ActivityTaskManagerServiceSmtBase {
    private AppOpsService mAppOpsService;
    private RemoteCallbackList<IRemoteCallback> mBytedanceActivityListeners;
    private final HashSet<Pair<Integer, String>> mMutedApps;

    /* JADX INFO: renamed from: $r8$lambda$4RNHc7VBYczN5ASNbWgh0MnSG-s, reason: not valid java name */
    public static /* synthetic */ void m9692$r8$lambda$4RNHc7VBYczN5ASNbWgh0MnSGs(ActivityTaskManagerServiceSmtEx r0, String r1, int r2, int r3, int r4) {
        r0.lambda$notifyBytedanceActivityPaused$4(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$A0Gou2SwavkPATT4HENsbOogYKg(ActivityTaskManagerServiceSmtEx r0, String r1, int r2, int r3, int r4) {
        r0.lambda$notifyBytedanceActivityResumed$3(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$IHC9Hl2CIVPR4rePJPwZbZjh7ZQ(ActivityTaskManagerServiceSmtEx r0, IRemoteCallback r1) {
        r0.lambda$unregisterActivityObserver$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$KciBVrExYuQ_Nu8fcEVyvVxfZig(ActivityTaskManagerServiceSmtEx r0, String r1, int r2, int r3, int r4) {
        r0.lambda$notifyBytedanceActivityStopped$5(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$PXiXBxUItjSrhnBcOiPFPY1Gi6U(ActivityTaskManagerServiceSmtEx r0, IRemoteCallback r1) {
        r0.lambda$registerActivityObserver$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$pNWCebjJZrXUsqRi85okOUoTU6g(ActivityTaskManagerServiceSmtEx r0, String r1, int r2, int r3, int r4) {
        r0.lambda$notifyBytedanceActivityStarted$2(r1, r2, r3, r4);
    }

    public ActivityTaskManagerServiceSmtEx(ActivityTaskManagerService atmServices) {
        super(atmServices);
        this.mMutedApps = new HashSet();
        this.mBytedanceActivityListeners = new RemoteCallbackList();
    }

    public boolean isTaskIdValid(int taskId) {
        WindowManagerGlobalLock r0 = this.mAtmServices.getGlobalLock();
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mAtmServices.mRootWindowContainer.anyTaskForId(taskId) == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.android.server.wm.ActivityTaskManagerServiceSmtBase
    public ApplicationInfo getTopApplication() {
        Task task = this.mAtmServices.mRootWindowContainer.getTopDisplayFullScreenTask();
        if (task == null) goto L8;
        ActivityRecord ar = task.getResumedActivity();
        if (ar != null) goto L7;
        return null;
    L7:
        return ar.info.applicationInfo;
    L8:
        return null;
    }

    public ComponentName getTopActivity() {
        Task task = this.mAtmServices.mRootWindowContainer.getTopDisplayFullScreenTask();
        if (task == null) goto L8;
        ActivityRecord ar = task.getResumedActivity();
        if (ar == null) goto L8;
        return ar.mActivityComponent;
    L8:
        if (task == null) goto L13;
        ActivityRecord ar2 = task.getTopResumedActivity();
        if (ar2 != null) goto L12;
        return null;
    L12:
        return ar2.mActivityComponent;
    L13:
        return null;
    }

    public void registerActivityObserver(final IRemoteCallback listener) {
        this.mAtmServices.mH.post(new ActivityTaskManagerServiceSmtEx$$ExternalSyntheticLambda2(this, listener));
    }

    private /* synthetic */ void lambda$registerActivityObserver$0(IRemoteCallback listener) {
        if (listener == null) goto L5;
        this.mBytedanceActivityListeners.register(listener);
        return;
    }

    public void unregisterActivityObserver(final IRemoteCallback listener) {
        this.mAtmServices.mH.post(new ActivityTaskManagerServiceSmtEx$$ExternalSyntheticLambda3(this, listener));
    }

    private /* synthetic */ void lambda$unregisterActivityObserver$1(IRemoteCallback listener) {
        if (listener == null) goto L5;
        this.mBytedanceActivityListeners.unregister(listener);
        return;
    }

    protected void notifyBytedanceActivityStarted(final String componentName, final int userId, final int uid, final int smtAppFlag) {
        this.mAtmServices.mH.post(new ActivityTaskManagerServiceSmtEx$$ExternalSyntheticLambda5(this, componentName, userId, uid, smtAppFlag));
    }

    private /* synthetic */ void lambda$notifyBytedanceActivityStarted$2(String componentName, int userId, int uid, int smtAppFlag) {
        notifyActivityLifeCycleChanged(0, componentName, userId, uid, smtAppFlag);
    }

    public boolean removeTaskWithFlag(int taskId, int flags) {
        enforceCallerIsRecentsOrHasPermission("android.permission.REMOVE_TASKS", "removeTaskWithFlag()");
        if ((flags & 1) == 0) goto L5;
        boolean r0 = true;
    L6:
        boolean killProcesses = r0;
        WindowManagerGlobalLock r8 = this.mAtmServices.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r8);
        int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L25
        int callingPid = Binder.getCallingPid();     // Catch: Throwable -> L25
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L25
        Slog.d("ActivityTaskManagerService", "removeTaskWithFlag: " + taskId + ", killProcesses: " + killProcesses);     // Catch: Throwable -> L21
        boolean r12 = this.mAtmServices.mTaskSupervisor.removeTaskById(taskId, killProcesses, true, "remove-task", callingUid, callingPid);     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L17
        monitor-exit(r8);     // Catch: Throwable -> L17
        WindowManagerService.resetPriorityAfterLockedSection();
        return r12;
    L19:
        th = move-exception;
        Throwable r13 = th;
    L23:
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L17
        throw r13;     // Catch: Throwable -> L17
    L21:
        th = move-exception;
        r13 = th;
    L25:
        th = move-exception;
        Throwable r14 = th;
    L27:
        monitor-exit(r8);     // Catch: Throwable -> L17
        WindowManagerService.resetPriorityAfterLockedSection();
        throw r14;
    L17:
        th = move-exception;
        r14 = th;
        goto L27
    L5:
        r0 = false;
        goto L6
    }

    private void enforceCallerIsRecentsOrHasPermission(String permission, String func) {
        if (this.mAtmServices.getRecentTasks().isCallerRecents(Binder.getCallingUid()) == true) goto L6;
        this.mAtmServices.mAmInternal.enforceCallingPermission(permission, func);
        return;
    }

    protected void notifyBytedanceActivityResumed(final String componentName, final int userId, final int uid, final int smtAppFlag) {
        this.mAtmServices.mH.post(new ActivityTaskManagerServiceSmtEx$$ExternalSyntheticLambda0(this, componentName, userId, uid, smtAppFlag));
    }

    private /* synthetic */ void lambda$notifyBytedanceActivityResumed$3(String componentName, int userId, int uid, int smtAppFlag) {
        notifyActivityLifeCycleChanged(1, componentName, userId, uid, smtAppFlag);
    }

    protected void notifyBytedanceActivityPaused(final String componentName, final int userId, final int uid, final int smtAppFlag) {
        this.mAtmServices.mH.post(new ActivityTaskManagerServiceSmtEx$$ExternalSyntheticLambda4(this, componentName, userId, uid, smtAppFlag));
    }

    private /* synthetic */ void lambda$notifyBytedanceActivityPaused$4(String componentName, int userId, int uid, int smtAppFlag) {
        notifyActivityLifeCycleChanged(2, componentName, userId, uid, smtAppFlag);
    }

    protected void notifyBytedanceActivityStopped(final String componentName, final int userId, final int uid, final int smtAppFlag) {
        this.mAtmServices.mH.post(new ActivityTaskManagerServiceSmtEx$$ExternalSyntheticLambda1(this, componentName, userId, uid, smtAppFlag));
    }

    private /* synthetic */ void lambda$notifyBytedanceActivityStopped$5(String componentName, int userId, int uid, int smtAppFlag) {
        notifyActivityLifeCycleChanged(3, componentName, userId, uid, smtAppFlag);
    }

    private void notifyActivityLifeCycleChanged(int type, String componentName, int userId, int uid, int smtAppFlag) {
        int i = this.mBytedanceActivityListeners.beginBroadcast() - 1;
    L3:
        if (i < 0) goto L8;
        Bundle date = new Bundle();     // Catch: RemoteException -> L6
        date.putInt(DatabaseHelper.SoundModelContract.KEY_TYPE, type);     // Catch: RemoteException -> L6
        date.putString("component_name", componentName);     // Catch: RemoteException -> L6
        date.putInt("user_id", userId);     // Catch: RemoteException -> L6
        date.putInt("uid", uid);     // Catch: RemoteException -> L6
        date.putInt("app_flag", smtAppFlag);     // Catch: RemoteException -> L6
        this.mBytedanceActivityListeners.getBroadcastItem(i).sendResult(date);     // Catch: RemoteException -> L6
    L7:
        i = i - 1;
        goto L3
    L8:
        this.mBytedanceActivityListeners.finishBroadcast();
    }

    public ActivityManager.RecentTaskInfo getFocusedTaskInfoExt(int displayId) {
        int callingUid = Binder.getCallingUid();
        WindowManagerGlobalLock r1 = this.mAtmServices.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        boolean allowed = this.mAtmServices.isGetTasksAllowed("getTasks", Binder.getCallingPid(), callingUid);     // Catch: Throwable -> L9
        if (allowed == true) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L11:
        DisplayContent displayContent = this.mAtmServices.mRootWindowContainer.getDisplayContent(displayId);     // Catch: Throwable -> L9
        if (displayContent == null) goto L19;
        Task focusedTask = displayContent.getFocusedRootTask();     // Catch: Throwable -> L9
        if (focusedTask == null) goto L19;
        ActivityManager.RecentTaskInfo taskInfo = this.mAtmServices.getRecentTasks().createRecentTaskInfo(focusedTask.getTopMostTask(), false, true);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return taskInfo;
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.android.server.wm.WindowContainer] */
    public boolean isBytedanceLauncherBelowKeyguard() {
        WindowManagerGlobalLock r0 = this.mAtmServices.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mAtmServices.mRootWindowContainer.getDefaultDisplay();     // Catch: Throwable -> L15
        int index = displayContent.getDefaultTaskDisplayArea().getChildCount() - 1;     // Catch: Throwable -> L15
        Task topTask = displayContent.getDefaultTaskDisplayArea().getChildAt(index).asTask();     // Catch: Throwable -> L15
        if (topTask != null) goto L7;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L15
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L7:
        if (topTask.isActivityTypeHome() == false) goto L17;
        ActivityRecord topActivity = topTask.getTopNonFinishingActivity();     // Catch: Throwable -> L15
        if (topActivity == null) goto L17;
        if ("com.bytedanceos.launcher.Launcher".equals(topActivity.info.name) == false) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L15
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    L15:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }
}
