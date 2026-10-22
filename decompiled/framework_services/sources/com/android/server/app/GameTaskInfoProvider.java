package com.android.server.app;

import android.app.ActivityManager;
import android.app.IActivityTaskManager;
import android.content.ComponentName;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.LruCache;
import android.util.Slog;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class GameTaskInfoProvider {
    private static final String TAG = "GameTaskInfoProvider";
    private static final int TASK_INFO_CACHE_MAX_SIZE = 50;
    private final IActivityTaskManager mActivityTaskManager;
    private final GameClassifier mGameClassifier;
    private final LruCache<Integer, GameTaskInfo> mGameTaskInfoCache;
    private final Object mLock;
    private final UserHandle mUserHandle;

    GameTaskInfoProvider(UserHandle userHandle, IActivityTaskManager activityTaskManager, GameClassifier gameClassifier) {
        this.mLock = new Object();
        this.mGameTaskInfoCache = new LruCache(50);
        this.mUserHandle = userHandle;
        this.mActivityTaskManager = activityTaskManager;
        this.mGameClassifier = gameClassifier;
    }

    GameTaskInfo get(int taskId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        GameTaskInfo cachedTaskInfo = this.mGameTaskInfoCache.get(Integer.valueOf(taskId));     // Catch: Throwable -> L8
        if (cachedTaskInfo == null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return cachedTaskInfo;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManager.RunningTaskInfo runningTaskInfo = getRunningTaskInfo(taskId);
        if (runningTaskInfo != null) goto L15;
        return null;
    L15:
        if (runningTaskInfo.baseActivity != null) goto L18;
        return null;
    L18:
        return generateGameInfo(taskId, runningTaskInfo.baseActivity);
    L8:
        th = move-exception;
        throw th;
    }

    GameTaskInfo get(int taskId, ComponentName componentName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        GameTaskInfo cachedTaskInfo = this.mGameTaskInfoCache.get(Integer.valueOf(taskId));     // Catch: Throwable -> L9
        if (cachedTaskInfo != null) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return generateGameInfo(taskId, componentName);
    L7:
        if (cachedTaskInfo.mComponentName.equals(componentName) == false) goto L11;
        Slog.w(TAG, "Found cached task info for taskId " + taskId + " but cached component name " + cachedTaskInfo.mComponentName + " does not match " + componentName);     // Catch: Throwable -> L9
        goto L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return cachedTaskInfo;
    L9:
        th = move-exception;
        throw th;
    }

    ActivityManager.RunningTaskInfo getRunningTaskInfo(int taskId) {
        List<ActivityManager.RunningTaskInfo> runningTaskInfos = this.mActivityTaskManager.getTasks(Integer.MAX_VALUE, false, false, -1);     // Catch: RemoteException -> L12
        Iterator<ActivityManager.RunningTaskInfo> r2 = runningTaskInfos.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        ActivityManager.RunningTaskInfo taskInfo = r2.next();
        if (taskInfo.taskId != taskId) goto L6;
        return taskInfo;
    L11:
        return null;
    L13:
        Slog.w(TAG, "Failed to fetch running tasks");
        return null;
    }

    private GameTaskInfo generateGameInfo(int taskId, ComponentName componentName) {
        GameTaskInfo gameTaskInfo = new GameTaskInfo(taskId, this.mGameClassifier.isGame(componentName.getPackageName(), this.mUserHandle), componentName);
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mGameTaskInfoCache.put(Integer.valueOf(taskId), gameTaskInfo);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return gameTaskInfo;
    L7:
        th = move-exception;
        throw th;
    }
}
