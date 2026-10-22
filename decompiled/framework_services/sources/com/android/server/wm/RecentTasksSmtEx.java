package com.android.server.wm;

import android.os.Bundle;
import android.os.IRemoteCallback;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Slog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class RecentTasksSmtEx {
    private static final String TAG = "ActivityTaskManager";
    private int mDefaultFreeFromInsertIndex;
    private RecentTasks mRecentTasks;
    private ActivityTaskManagerService mService;
    private final RemoteCallbackList<IRemoteCallback> mStatesObservers;
    private final ArrayList<Task> mTasks;

    public RecentTasksSmtEx(ActivityTaskManagerService service, RecentTasks recentTasks, ArrayList<Task> tasks) {
        this.mStatesObservers = new RemoteCallbackList();
        this.mDefaultFreeFromInsertIndex = 20;
        this.mService = service;
        this.mRecentTasks = recentTasks;
        this.mTasks = tasks;
    }

    protected void removeUnwantedTask(Task task, int globalMaxNumTasks) {
    }

    protected void notifyTaskIdChangeExt(int oldTaskId, int newTaskId) {
        onTaskIdChange(oldTaskId, newTaskId);
    }

    protected void registerTaskIdChangeListener(IRemoteCallback callback) {
        ArrayList<Task> r0 = this.mTasks;
        monitor-enter(r0);
        if (callback != null) goto L12;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    L12:
        this.mStatesObservers.register(callback);     // Catch: Throwable -> L6
        goto L8
    }

    protected void unregisterTaskIdChangeListener(IRemoteCallback callback) {
        ArrayList<Task> r0 = this.mTasks;
        monitor-enter(r0);
        if (callback != null) goto L12;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    L12:
        this.mStatesObservers.unregister(callback);     // Catch: Throwable -> L6
        goto L8
    }

    private void onTaskIdChange(int oldTaskId, int newTaskId) {
        ArrayList<Task> r0 = this.mTasks;
        monitor-enter(r0);
        Bundle data = new Bundle();     // Catch: Throwable -> L9
        data.putInt("old_task_id", oldTaskId);     // Catch: Throwable -> L9
        data.putInt("new_task_id", newTaskId);     // Catch: Throwable -> L9
        int i = this.mStatesObservers.beginBroadcast() - 1;
    L6:
        if (i < 0) goto L14;
        this.mStatesObservers.getBroadcastItem(i).sendResult(data);     // Catch: Throwable -> L9 RemoteException -> L11
    L12:
        i = i - 1;
        goto L6
    L14:
        this.mStatesObservers.finishBroadcast();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    protected boolean isTaskInSidebar(Task tr) {
        return false;
    }

    private int sizeWithCondition() {
        int count = this.mTasks.size();
        int excluderecents = 0;
        int samepackage = 0;
        int i = 0;
    L3:
        if (i >= count) goto L22;
        Task srcTr = this.mTasks.get(i);
        if (isExcludedRecentTask(srcTr) == false) goto L7;
        excluderecents = excluderecents + 1;
    L20:
        i = i + 1;
        goto L3
    L7:
        String srcPackage = getTaskRecordPackageName(srcTr);
        int j = i + 1;
    L8:
        if (j >= count) goto L20;
        Task destTr = this.mTasks.get(j);
        if (isExcludedRecentTask(destTr) == true) goto L19;
        String destPackage = getTaskRecordPackageName(destTr);
        if (srcTr.mUserId != destTr.mUserId) goto L19;
        if (srcPackage == null) goto L19;
        if (destPackage == null) goto L19;
        if (srcPackage.equals(destPackage) == false) goto L19;
        samepackage = samepackage + 1;
    L19:
        j = j + 1;
        goto L8
    L22:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L25;
        Slog.d(TAG, "sizeWithCondition total count:" + count + " excluderecents:" + excluderecents + " samepackage:" + samepackage);
    L25:
        return (count - excluderecents) - samepackage;
    }

    private boolean isExcludedRecentTask(Task tr) {
        if (tr != null) goto L6;
        return false;
    L6:
        if (tr.isActivityTypeHome() == false) goto L8;
        return true;
    L8:
        if (tr.intent != null) goto L10;
    L12:
        return false;
    L10:
        if ((tr.intent.getFlags() & 8388608) == 0) goto L12;
        return true;
    }

    protected boolean isTrimmable(Task task) {
        if ((task.getBaseIntent().getSmtEx().getSmFlags() & 16) == 0) goto L6;
        return false;
    L6:
        return true;
    }

    private boolean isDuplicatedPackage(Task tr) {
        if (tr != null) goto L5;
        return false;
    L5:
        String srcPackage = getTaskRecordPackageName(tr);
        int i = 0;
    L7:
        if (i >= this.mTasks.size()) goto L18;
        Task destTr = this.mTasks.get(i);
        String destPackage = getTaskRecordPackageName(destTr);
        if (tr.mUserId != destTr.mUserId) goto L16;
        if (srcPackage == null) goto L16;
        if (destPackage == null) goto L16;
        if (srcPackage.equals(destPackage) == false) goto L16;
        return true;
    L16:
        i = i + 1;
        goto L7
    L18:
        return false;
    }

    private String getTaskRecordPackageName(Task tr) {
        if (tr != null) goto L6;
        return null;
    L6:
        if (tr.affinity == null) goto L10;
        return tr.affinity;
    L10:
        if (tr.intent != null) goto L12;
    L15:
        return null;
    L12:
        if (tr.intent.getComponent() == null) goto L15;
        return tr.intent.getComponent().getPackageName();
    }
}
