package com.android.server.wm;

import android.app.ActivityManager;
import android.app.IAppTask;
import android.app.IApplicationThread;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
class AppTaskImpl extends IAppTask.Stub {
    private static final String TAG = "AppTaskImpl";
    private final int mCallingUid;
    private final ActivityTaskManagerService mService;
    private final int mTaskId;

    public AppTaskImpl(ActivityTaskManagerService service, int taskId, int callingUid) {
        this.mService = service;
        this.mTaskId = taskId;
        this.mCallingUid = callingUid;
    }

    private void checkCallerOrSystemOrRoot() {
        if (this.mCallingUid != Binder.getCallingUid()) goto L5;
        return;
    L5:
        if (1000 != Binder.getCallingUid()) goto L7;
        return;
    L7:
        if (Binder.getCallingUid() != 0) goto L10;
        return;
    L10:
        throw new SecurityException("Caller " + this.mCallingUid + " does not match caller of getAppTasks(): " + Binder.getCallingUid());
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        return super.onTransact(code, data, reply, flags);
    L4:
        e = move-exception;
        throw ActivityTaskManagerService.logAndRethrowRuntimeExceptionOnTransact(TAG, e);
    }

    public void finishAndRemoveTask() {
        checkCallerOrSystemOrRoot();
        WindowManagerGlobalLock r1 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        int origCallingUid = Binder.getCallingUid();     // Catch: Throwable -> L12
        int origCallingPid = Binder.getCallingPid();     // Catch: Throwable -> L12
        long callingIdentity = Binder.clearCallingIdentity();     // Catch: Throwable -> L12
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(callingIdentity);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L7:
        if (this.mService.mTaskSupervisor.removeTaskById(this.mTaskId, false, true, "finish-and-remove-task", origCallingUid, origCallingPid) == false) goto L15;
        Binder.restoreCallingIdentity(callingIdentity);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L15:
        throw new IllegalArgumentException("Unable to find task ID " + this.mTaskId);     // Catch: Throwable -> L16
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public ActivityManager.RecentTaskInfo getTaskInfo() {
        checkCallerOrSystemOrRoot();
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long origId = Binder.clearCallingIdentity();     // Catch: Throwable -> L12
        Task task = this.mService.mRootWindowContainer.anyTaskForId(this.mTaskId, 1);     // Catch: Throwable -> L14
        if (task == null) goto L17;
        ActivityManager.RecentTaskInfo r4 = this.mService.getRecentTasks().createRecentTaskInfo(task, false, true);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return r4;
    L17:
        throw new IllegalArgumentException("Unable to find task ID " + this.mTaskId);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void moveToFront(IApplicationThread appThread, String callingPackage) {
        checkCallerOrSystemOrRoot();
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        this.mService.assertPackageMatchesCallingUid(callingPackage);
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r3 = this.mService.mGlobalLock;     // Catch: Throwable -> L30
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L30
        monitor-enter(r3);     // Catch: Throwable -> L30
        if (appThread != null) goto L39;
        WindowProcessController callerApp = null;
    L11:
        BackgroundActivityStartController balController = this.mService.mTaskSupervisor.getBackgroundActivityLaunchController();     // Catch: Throwable -> L8
        BackgroundActivityStartController.BalVerdict balVerdict = balController.checkBackgroundActivityStart(callingUid, callingPid, callingPackage, -1, -1, callerApp, null, false, null, null, null);     // Catch: Throwable -> L21
        if (balVerdict.blocks() == false) goto L24;
        if (this.mService.isBackgroundActivityStartsEnabled() == true) goto L24;
        Slog.w(TAG, "moveTaskToFront blocked: : " + balVerdict);     // Catch: Throwable -> L21
        monitor-exit(r3);     // Catch: Throwable -> L21
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L24:
        if (ActivityTaskManagerDebugConfig.DEBUG_ACTIVITY_STARTS == false) goto L26;
        Slog.d(TAG, "moveTaskToFront allowed: " + balVerdict);     // Catch: Throwable -> L21
    L26:
        monitor-exit(r3);     // Catch: Throwable -> L21
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L30
        this.mService.mTaskSupervisor.startActivityFromRecents(callingPid, callingUid, this.mTaskId, null);     // Catch: Throwable -> L30
        Binder.restoreCallingIdentity(origId);
        return;
    L8:
        th = th;
    L32:
        monitor-exit(r3);     // Catch: Throwable -> L21
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L39:
        WindowProcessController callerApp2 = this.mService.getProcessController(appThread);     // Catch: Throwable -> L8
        callerApp = callerApp2;
    L21:
        th = th;
    L30:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public int startActivity(IBinder whoThread, String callingPackage, String callingFeatureId, Intent intent, String resolvedType, Bundle bOptions) {
        checkCallerOrSystemOrRoot();
        this.mService.assertPackageMatchesCallingUid(callingPackage);
        this.mService.mAmInternal.addCreatorToken(intent, callingPackage);
        int callingUser = UserHandle.getCallingUserId();
        WindowManagerGlobalLock r1 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        Task task = this.mService.mRootWindowContainer.anyTaskForId(this.mTaskId, 1);     // Catch: Throwable -> L11
        if (task == null) goto L16;
        IApplicationThread appThread = IApplicationThread.Stub.asInterface(whoThread);     // Catch: Throwable -> L11
        if (appThread == null) goto L14;
        monitor-exit(r1);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        return this.mService.getActivityStartController().obtainStarter(intent, TAG).setCaller(appThread).setCallingPackage(callingPackage).setCallingFeatureId(callingFeatureId).setResolvedType(resolvedType).setActivityOptions(bOptions, callingPid, callingUid).setUserId(callingUser).setInTask(task).execute();
    L14:
        throw new IllegalArgumentException("Bad app thread " + appThread);     // Catch: Throwable -> L11
    L16:
        throw new IllegalArgumentException("Unable to find task ID " + this.mTaskId);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void setExcludeFromRecents(boolean exclude) {
        checkCallerOrSystemOrRoot();
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long origId = Binder.clearCallingIdentity();     // Catch: Throwable -> L17
        Task task = this.mService.mRootWindowContainer.anyTaskForId(this.mTaskId, 1);     // Catch: Throwable -> L10
        if (task == null) goto L20;
        Intent intent = task.getBaseIntent();     // Catch: Throwable -> L10
        if (exclude == false) goto L12;
        intent.addFlags(8388608);     // Catch: Throwable -> L10
    L13:
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        intent.setFlags(intent.getFlags() & (-8388609));     // Catch: Throwable -> L10
        goto L13
    L20:
        throw new IllegalArgumentException("Unable to find task ID " + this.mTaskId);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }
}
