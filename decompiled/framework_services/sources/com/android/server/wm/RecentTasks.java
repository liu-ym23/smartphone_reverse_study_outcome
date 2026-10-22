package com.android.server.wm;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.app.AppGlobals;
import android.app.SysMonitorFwBridge;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Environment;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.pico.utils.Features;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.InsetsState;
import android.view.MotionEvent;
import android.view.WindowInsets;
import android.view.WindowManagerPolicyConstants;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.slice.SliceClientPermissions;
import com.google.android.collect.Sets;
import com.obric.utils.ObricImplFactory;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
class RecentTasks {
    private static final int DEFAULT_INITIAL_CAPACITY = 5;
    private static final long FREEZE_TASK_LIST_TIMEOUT_MS = 0;
    private static final int MAX_HIDDEN_TASK_SIZE = 10;
    private static final ActivityInfo NO_ACTIVITY_INFO_TOKEN = null;
    private static final ApplicationInfo NO_APPLICATION_INFO_TOKEN = null;
    private static final String TAG = "ActivityTaskManager";
    private static final String TAG_RECENTS = "ActivityTaskManager";
    private static final String TAG_TASKS = "ActivityTaskManager";
    private static final Comparator<Task> TASK_ID_COMPARATOR = null;
    private long mActiveTasksSessionDurationMs;
    private final ArrayList<Callbacks> mCallbacks;
    private boolean mCheckTrimmableTasksOnIdle;
    private String mFeatureId;
    private boolean mFreezeTaskListReordering;
    private long mFreezeTaskListTimeoutMs;
    private int mGlobalMaxNumTasks;
    private boolean mHasVisibleRecentTasks;
    private final ArrayList<Task> mHiddenTasks;
    private final WindowManagerPolicyConstants.PointerEventListener mListener;
    private int mMaxNumVisibleTasks;
    private int mMinNumVisibleTasks;
    private IObricRecentTasks mObricExt;
    private final SparseArray<SparseBooleanArray> mPersistedTaskIds;
    private final RecentTasksSmtEx mRecentTasksSmtEx;
    private ComponentName mRecentsComponent;
    private int mRecentsUid;
    private final Runnable mResetFreezeTaskListOnTimeoutRunnable;
    private final ActivityTaskManagerService mService;
    private final ActivityTaskSupervisor mSupervisor;
    private TaskChangeNotificationController mTaskNotificationController;
    private final TaskPersister mTaskPersister;
    private final ArrayList<Task> mTasks;
    private final HashMap<ComponentName, ActivityInfo> mTmpAvailActCache;
    private final HashMap<String, ApplicationInfo> mTmpAvailAppCache;
    private final SparseBooleanArray mTmpQuietProfileUserIds;
    private final ArrayList<Task> mTmpRecents;
    private final Rect mTmpRect;
    private final SparseArray<AtomicBoolean> mUsersWithRecentsLoaded;
    private final BoostFramework mUxPerf;

    /* JADX INFO: renamed from: com.android.server.wm.RecentTasks$1, reason: invalid class name */
    class AnonymousClass1 implements WindowManagerPolicyConstants.PointerEventListener {
        final /* synthetic */ RecentTasks this$0;

        public static /* synthetic */ void $r8$lambda$kMLZu1da_9gKFD9TDrUKSwr3HJM(AnonymousClass1 r0, int r1, int r2, int r3, Object r4) {
            r0.lambda$onPointerEvent$0(r1, r2, r3, r4);
        }

        AnonymousClass1(RecentTasks this$0) {
            this.this$0 = this$0;
        }

        public void onPointerEvent(MotionEvent ev) {
            if (RecentTasks.m10091$$Nest$fgetmFreezeTaskListReordering(this.this$0) == true) goto L5;
            return;
        L5:
            if (ev.getAction() == 0) goto L7;
            return;
        L7:
            if (ev.getClassification() == 4) goto L13;
            final int displayId = ev.getDisplayId();
            final int x = (int) ev.getX();
            final int y = (int) ev.getY();
            RecentTasks.m10092$$Nest$fgetmService(this.this$0).mH.post(PooledLambda.obtainRunnable(new RecentTasks$1$$ExternalSyntheticLambda0(this, displayId, x, y), null).recycleOnUse());
            return;
        }

        private /* synthetic */ void lambda$onPointerEvent$0(int displayId, int x, int y, Object nonArg) {
            WindowManagerGlobalLock r4 = RecentTasks.m10092$$Nest$fgetmService(this.this$0).mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r4);
            RootWindowContainer rac = RecentTasks.m10092$$Nest$fgetmService(this.this$0).mRootWindowContainer;     // Catch: Throwable -> L9
            DisplayContent dc = rac.getDisplayContent(displayId).mDisplayContent;     // Catch: Throwable -> L9
            WindowState win = dc.getTouchableWinAtPointLocked(x, y);     // Catch: Throwable -> L9
            if (win != null) goto L11;
            monitor-exit(r4);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L11:
            InsetsState insetsState = dc.getInsetsStateController().getRawInsetsState();     // Catch: Throwable -> L9
            RecentTasks.m10093$$Nest$fgetmTmpRect(this.this$0).set(win.getFrame());     // Catch: Throwable -> L9
            boolean isAppWindowTouch = false;
            RecentTasks.m10093$$Nest$fgetmTmpRect(this.this$0).inset(insetsState.calculateInsets(win.getFrame(), WindowInsets.Type.mandatorySystemGestures(), false));     // Catch: Throwable -> L9
            if (RecentTasks.m10093$$Nest$fgetmTmpRect(this.this$0).contains(x, y) == true) goto L17;
            monitor-exit(r4);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L17:
            if (1 <= win.mAttrs.type) goto L19;
        L22:
            if (isAppWindowTouch == false) goto L33;
            Task stack = RecentTasks.m10092$$Nest$fgetmService(this.this$0).getTopDisplayFocusedRootTask();     // Catch: Throwable -> L9
            if (stack == null) goto L26;
            Task topTask = stack.getTopMostTask();     // Catch: Throwable -> L9
        L28:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[2] == false) goto L31;
            String protoLogParam0 = String.valueOf(win);     // Catch: Throwable -> L9
            long protoLogParam1 = x;
            long protoLogParam2 = y;
            String protoLogParam3 = String.valueOf(RecentTasks.m10093$$Nest$fgetmTmpRect(this.this$0));     // Catch: Throwable -> L9
            ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_TASKS, -1640401313436844534L, 20, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), Long.valueOf(protoLogParam2), protoLogParam3});     // Catch: Throwable -> L9
        L31:
            this.this$0.resetFreezeTaskListReordering(topTask);     // Catch: Throwable -> L9
            goto L33
        L26:
            topTask = null;
        L33:
            monitor-exit(r4);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L19:
            if (win.mAttrs.type > 99) goto L22;
            isAppWindowTouch = true;
        L9:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    interface Callbacks {
        void onRecentTaskAdded(Task r1);

        void onRecentTaskRemoved(Task r1, boolean r2, boolean r3);
    }

    public static /* synthetic */ int $r8$lambda$77Kxk7wXIqud8tL5Lzt0j0ZjKDs(Task r0, Task r1) {
        return lambda$static$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFreezeTaskListReordering, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10091$$Nest$fgetmFreezeTaskListReordering(RecentTasks r0) {
        return r0.mFreezeTaskListReordering;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerService m10092$$Nest$fgetmService(RecentTasks r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTmpRect, reason: not valid java name */
    static /* bridge */ /* synthetic */ Rect m10093$$Nest$fgetmTmpRect(RecentTasks r0) {
        return r0.mTmpRect;
    }

    static {
        FREEZE_TASK_LIST_TIMEOUT_MS = TimeUnit.SECONDS.toMillis(5);
        TASK_ID_COMPARATOR = new RecentTasks$$ExternalSyntheticLambda0();
        NO_ACTIVITY_INFO_TOKEN = new ActivityInfo();
        NO_APPLICATION_INFO_TOKEN = new ApplicationInfo();
    }

    private static /* synthetic */ int lambda$static$0(Task lhs, Task rhs) {
        return rhs.mTaskId - lhs.mTaskId;
    }

    RecentTasks(ActivityTaskManagerService service, TaskPersister taskPersister) {
        this.mRecentsUid = -1;
        this.mRecentsComponent = null;
        this.mUsersWithRecentsLoaded = new SparseArray(5);
        this.mPersistedTaskIds = new SparseArray(5);
        this.mTasks = new ArrayList();
        this.mCallbacks = new ArrayList();
        this.mHiddenTasks = new ArrayList();
        this.mFreezeTaskListTimeoutMs = FREEZE_TASK_LIST_TIMEOUT_MS;
        this.mTmpRecents = new ArrayList();
        this.mTmpAvailActCache = new HashMap();
        this.mTmpAvailAppCache = new HashMap();
        this.mTmpQuietProfileUserIds = new SparseBooleanArray();
        this.mUxPerf = new BoostFramework();
        this.mTmpRect = new Rect();
        this.mListener = new AnonymousClass1(this);
        this.mResetFreezeTaskListOnTimeoutRunnable = new RecentTasks$$ExternalSyntheticLambda1(this);
        this.mObricExt = (IObricRecentTasks) ObricImplFactory.getImpl(IObricRecentTasks.class, new Object[0]);
        this.mService = service;
        this.mSupervisor = this.mService.mTaskSupervisor;
        this.mTaskPersister = taskPersister;
        this.mGlobalMaxNumTasks = ActivityTaskManager.getMaxRecentTasksStatic();
        this.mHasVisibleRecentTasks = true;
        this.mTaskNotificationController = service.getTaskChangeNotificationController();
        this.mRecentTasksSmtEx = new RecentTasksSmtEx(this.mService, this, this.mTasks);
    }

    RecentTasks(ActivityTaskManagerService service, ActivityTaskSupervisor taskSupervisor) {
        this.mRecentsUid = -1;
        this.mRecentsComponent = null;
        this.mUsersWithRecentsLoaded = new SparseArray(5);
        this.mPersistedTaskIds = new SparseArray(5);
        this.mTasks = new ArrayList();
        this.mCallbacks = new ArrayList();
        this.mHiddenTasks = new ArrayList();
        this.mFreezeTaskListTimeoutMs = FREEZE_TASK_LIST_TIMEOUT_MS;
        this.mTmpRecents = new ArrayList();
        this.mTmpAvailActCache = new HashMap();
        this.mTmpAvailAppCache = new HashMap();
        this.mTmpQuietProfileUserIds = new SparseBooleanArray();
        this.mUxPerf = new BoostFramework();
        this.mTmpRect = new Rect();
        this.mListener = new AnonymousClass1(this);
        this.mResetFreezeTaskListOnTimeoutRunnable = new RecentTasks$$ExternalSyntheticLambda1(this);
        this.mObricExt = (IObricRecentTasks) ObricImplFactory.getImpl(IObricRecentTasks.class, new Object[0]);
        File systemDir = Environment.getDataSystemDirectory();
        Resources res = service.mContext.getResources();
        this.mService = service;
        this.mSupervisor = this.mService.mTaskSupervisor;
        this.mTaskPersister = new TaskPersister(systemDir, taskSupervisor, service, this, taskSupervisor.mPersisterQueue);
        this.mGlobalMaxNumTasks = ActivityTaskManager.getMaxRecentTasksStatic();
        this.mTaskNotificationController = service.getTaskChangeNotificationController();
        this.mHasVisibleRecentTasks = res.getBoolean(R.bool.config_ignoreUdfpsVote);
        loadParametersFromResources(res);
        this.mRecentTasksSmtEx = new RecentTasksSmtEx(this.mService, this, this.mTasks);
    }

    void setParameters(int minNumVisibleTasks, int maxNumVisibleTasks, long activeSessionDurationMs) {
        this.mMinNumVisibleTasks = minNumVisibleTasks;
        this.mMaxNumVisibleTasks = maxNumVisibleTasks;
        this.mActiveTasksSessionDurationMs = activeSessionDurationMs;
    }

    void setGlobalMaxNumTasks(int globalMaxNumTasks) {
        this.mGlobalMaxNumTasks = globalMaxNumTasks;
    }

    void setFreezeTaskListTimeout(long timeoutMs) {
        this.mFreezeTaskListTimeoutMs = timeoutMs;
    }

    WindowManagerPolicyConstants.PointerEventListener getInputListener() {
        return this.mListener;
    }

    void setFreezeTaskListReordering() {
        if (this.mFreezeTaskListReordering == true) goto L6;
        this.mTaskNotificationController.notifyTaskListFrozen(true);
        this.mFreezeTaskListReordering = true;
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[2] == false) goto L9;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_TASKS, -8803811426486764449L, 0, null);
    L9:
        if (ActivityManager.isRunningInUserTestHarness() == false) goto L11;
        long timeout = this.mFreezeTaskListTimeoutMs * 10;
    L12:
        this.mService.mH.removeCallbacks(this.mResetFreezeTaskListOnTimeoutRunnable);
        this.mService.mH.postDelayed(this.mResetFreezeTaskListOnTimeoutRunnable, timeout);
        return;
    L11:
        timeout = this.mFreezeTaskListTimeoutMs;
        goto L12
    }

    void resetFreezeTaskListReordering(Task topTask) {
        if (this.mFreezeTaskListReordering == true) goto L5;
        return;
    L5:
        this.mFreezeTaskListReordering = false;
        this.mService.mH.removeCallbacks(this.mResetFreezeTaskListOnTimeoutRunnable);
        if (topTask == null) goto L8;
        this.mTasks.remove(topTask);
        this.mTasks.add(0, topTask);
    L8:
        trimInactiveRecentTasks();
        this.mTaskNotificationController.notifyTaskStackChanged();
        this.mTaskNotificationController.notifyTaskListFrozen(false);
    }

    void resetFreezeTaskListReorderingOnTimeout() {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Task focusedStack = this.mService.getTopDisplayFocusedRootTask();     // Catch: Throwable -> L7
        if (focusedStack == null) goto L9;
        Task topTask = focusedStack.getTopMostTask();     // Catch: Throwable -> L7
    L10:
        if (topTask != null) goto L12;
    L14:
        Task reorderToEndTask = null;
    L16:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[2] == false) goto L18;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_TASKS, 4040735335719974079L, 0, null);     // Catch: Throwable -> L7
    L18:
        resetFreezeTaskListReordering(reorderToEndTask);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        if (topTask.hasChild() == false) goto L14;
        reorderToEndTask = topTask;
        goto L16
    L9:
        topTask = null;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    boolean isFreezeTaskListReorderingSet() {
        return this.mFreezeTaskListReordering;
    }

    void loadParametersFromResources(Resources res) {
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L5;
        this.mMinNumVisibleTasks = res.getInteger(R.integer.config_networkPolicyDefaultWarning);
        this.mMaxNumVisibleTasks = res.getInteger(R.integer.config_minNumVisibleRecentTasks);
    L6:
        int sessionDurationHrs = res.getInteger(R.integer.config_activityDefaultDur);
        if (sessionDurationHrs <= 0) goto L9;
        long r1 = TimeUnit.HOURS.toMillis(sessionDurationHrs);
    L10:
        this.mActiveTasksSessionDurationMs = r1;
        return;
    L9:
        r1 = -1;
        goto L10
    L5:
        this.mMinNumVisibleTasks = res.getInteger(R.integer.config_networkNotifySwitchType);
        this.mMaxNumVisibleTasks = res.getInteger(R.integer.config_minMillisBetweenInputUserActivityEvents);
        goto L6
    }

    void loadRecentsComponent(Resources res) {
        String rawRecentsComponent = res.getString(R.string.config_wimaxManagerClassname);
        if (TextUtils.isEmpty(rawRecentsComponent) == false) goto L5;
        return;
    L5:
        ComponentName cn = ComponentName.unflattenFromString(rawRecentsComponent);
        if (cn == null) goto L18;
        ApplicationInfo appInfo = AppGlobals.getPackageManager().getApplicationInfo(cn.getPackageName(), 8704, this.mService.mContext.getUserId());     // Catch: RemoteException -> L11
        if (appInfo == null) goto L19;
        this.mRecentsUid = appInfo.uid;     // Catch: RemoteException -> L11
        this.mRecentsComponent = cn;     // Catch: RemoteException -> L11
        return;
    L19:
        return;
    L14:
        Slog.w("ActivityTaskManager", "Could not load application info for recents component: " + cn);
        return;
    }

    boolean isCallerRecents(int callingUid) {
        return UserHandle.isSameApp(callingUid, this.mRecentsUid);
    }

    boolean isRecentsComponent(ComponentName cn, int uid) {
        if (cn.equals(this.mRecentsComponent) == true) goto L5;
    L7:
        return false;
    L5:
        if (UserHandle.isSameApp(uid, this.mRecentsUid) == false) goto L7;
        return true;
    }

    boolean isRecentsComponentHomeActivity(int userId) {
        ComponentName defaultHomeActivity = this.mService.getPackageManagerInternalLocked().getDefaultHomeActivity(userId);
        if (defaultHomeActivity != null) goto L5;
    L9:
        return false;
    L5:
        if (this.mRecentsComponent == null) goto L9;
        if (defaultHomeActivity.getPackageName().equals(this.mRecentsComponent.getPackageName()) == false) goto L9;
        return true;
    }

    ComponentName getRecentsComponent() {
        return this.mRecentsComponent;
    }

    String getRecentsComponentFeatureId() {
        return this.mFeatureId;
    }

    int getRecentsComponentUid() {
        return this.mRecentsUid;
    }

    void registerCallback(Callbacks callback) {
        this.mCallbacks.add(callback);
    }

    void unregisterCallback(Callbacks callback) {
        this.mCallbacks.remove(callback);
    }

    private void notifyTaskAdded(Task task) {
        int i = 0;
    L4:
        if (i >= this.mCallbacks.size()) goto L6;
        this.mCallbacks.get(i).onRecentTaskAdded(task);
        i = i + 1;
        goto L4
    L6:
        this.mTaskNotificationController.notifyTaskListUpdated();
    }

    private void notifyTaskRemoved(Task task, boolean wasTrimmed, boolean killProcess, boolean removedForAddTask) {
        int i = 0;
    L4:
        if (i >= this.mCallbacks.size()) goto L6;
        this.mCallbacks.get(i).onRecentTaskRemoved(task, wasTrimmed, killProcess);
        i = i + 1;
        goto L4
    L6:
        this.mTaskNotificationController.notifyTaskListUpdated();
        if (removedForAddTask == false) goto L11;
        this.mTaskNotificationController.notifyRecentTaskRemovedForAddTask(task.mTaskId);
        return;
    }

    private void notifyTaskRemoved(Task task, boolean wasTrimmed, boolean killProcess) {
        notifyTaskRemoved(task, wasTrimmed, killProcess, false);
    }

    void loadRecentTasksIfNeeded(int userId) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        AtomicBoolean userLoaded = this.mUsersWithRecentsLoaded.get(userId);     // Catch: Throwable -> L7
        if (userLoaded != null) goto L9;
        SparseArray<AtomicBoolean> r2 = this.mUsersWithRecentsLoaded;     // Catch: Throwable -> L7
        AtomicBoolean r3 = new AtomicBoolean();     // Catch: Throwable -> L7
        userLoaded = r3;
        r2.append(userId, r3);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        monitor-enter(userLoaded);
    L16:
        th = move-exception;
        throw th;
    L13:
        if (userLoaded.get() == false) goto L18;
        monitor-exit(userLoaded);     // Catch: Throwable -> L16
        return;
    L18:
        SparseBooleanArray persistedTaskIds = this.mTaskPersister.readPersistedTaskIdsFromFileForUser(userId);     // Catch: Throwable -> L16
        TaskPersister.RecentTaskFiles taskFiles = TaskPersister.loadTasksForUser(userId);     // Catch: Throwable -> L16
        WindowManagerGlobalLock r4 = this.mService.mGlobalLock;     // Catch: Throwable -> L16
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L16
        monitor-enter(r4);     // Catch: Throwable -> L16
        restoreRecentTasksLocked(userId, persistedTaskIds, taskFiles);     // Catch: Throwable -> L25
        monitor-exit(r4);     // Catch: Throwable -> L25
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L16
        userLoaded.set(true);     // Catch: Throwable -> L16
        monitor-exit(userLoaded);     // Catch: Throwable -> L16
        return;
    L25:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void restoreRecentTasksLocked(int userId, SparseBooleanArray persistedTaskIds, TaskPersister.RecentTaskFiles taskFiles) {
        this.mTaskPersister.setPersistedTaskIds(userId, persistedTaskIds);
        this.mPersistedTaskIds.put(userId, persistedTaskIds.clone());
        IntArray existedTaskIds = new IntArray();
        int i = this.mTasks.size() - 1;
    L3:
        if (i < 0) goto L10;
        Task task = this.mTasks.get(i);
        if (task.mUserId != userId) goto L9;
        if (shouldPersistTaskLocked(task) == false) goto L9;
        existedTaskIds.add(task.mTaskId);
    L9:
        i = i - 1;
        goto L3
    L10:
        Slog.i("ActivityTaskManager", "Restoring recents for user " + userId);
        ArrayList<Task> tasks = this.mTaskPersister.restoreTasksForUserLocked(userId, taskFiles, existedTaskIds);
        long currentElapsedTime = SystemClock.elapsedRealtime();
        int i2 = 0;
    L12:
        if (i2 >= tasks.size()) goto L18;
        Task task2 = tasks.get(i2);
        if (findRemoveIndexForAddTask(task2) < 0) goto L16;
        tasks.remove(i2);
        i2 = i2 - 1;
    L17:
        i2 = i2 + 1;
        goto L12
    L16:
        task2.lastActiveTime = currentElapsedTime - ((long) i2);
        goto L17
    L18:
        this.mTasks.addAll(tasks);
        cleanupLocked(userId);
        if (existedTaskIds.size() <= 0) goto L21;
        syncPersistentTaskIdsLocked();
    L21:
        this.mTaskNotificationController.notifyTaskListUpdated();
    }

    private boolean isRecentTasksLoaded(int userId) {
        AtomicBoolean userLoaded = this.mUsersWithRecentsLoaded.get(userId);
        if (userLoaded != null) goto L5;
    L7:
        return false;
    L5:
        if (userLoaded.get() == false) goto L7;
        return true;
    }

    boolean containsTaskId(int taskId, int userId) {
        SparseBooleanArray taskIds = this.mPersistedTaskIds.get(userId);
        if (taskIds != null) goto L5;
    L7:
        return false;
    L5:
        if (taskIds.get(taskId) == false) goto L7;
        return true;
    }

    SparseBooleanArray getTaskIdsForLoadedUser(int loadedUserId) {
        SparseBooleanArray taskIds = this.mPersistedTaskIds.get(loadedUserId);
        if (taskIds != null) goto L6;
        Slog.wtf("ActivityTaskManager", "Loaded user without loaded tasks, userId=" + loadedUserId);
        return new SparseBooleanArray();
    L6:
        return taskIds;
    }

    void notifyTaskPersisterLocked(Task task, boolean flush) {
        if (task == null) goto L4;
        Task rootTask = task.getRootTask();
    L5:
        if (rootTask != null) goto L7;
    L9:
        syncPersistentTaskIdsLocked();
        this.mTaskPersister.wakeup(task, flush);
        return;
    L7:
        if (rootTask.isActivityTypeHomeOrRecents() == false) goto L9;
        return;
    L4:
        rootTask = null;
        goto L5
    }

    private void syncPersistentTaskIdsLocked() {
        int i = this.mPersistedTaskIds.size() - 1;
    L3:
        if (i < 0) goto L8;
        int userId = this.mPersistedTaskIds.keyAt(i);
        if (isRecentTasksLoaded(userId) == false) goto L7;
        this.mPersistedTaskIds.valueAt(i).clear();
    L7:
        i = i - 1;
        goto L3
    L8:
        int i2 = this.mTasks.size() - 1;
    L9:
        if (i2 < 0) goto L18;
        Task task = this.mTasks.get(i2);
        if (shouldPersistTaskLocked(task) == false) goto L16;
        if (this.mPersistedTaskIds.get(task.mUserId) != null) goto L15;
        Slog.wtf("ActivityTaskManager", "No task ids found for userId " + task.mUserId + ". task=" + task + " mPersistedTaskIds=" + this.mPersistedTaskIds);
        this.mPersistedTaskIds.put(task.mUserId, new SparseBooleanArray());
    L15:
        this.mPersistedTaskIds.get(task.mUserId).put(task.mTaskId, true);
    L16:
        i2 = i2 - 1;
        goto L9
    }

    private static boolean shouldPersistTaskLocked(Task task) {
        Task rootTask = task.getRootTask();
        if (task.isPersistable == false) goto L8;
        if (rootTask != null) goto L6;
    L7:
        return true;
    L6:
        if (rootTask.isActivityTypeHomeOrRecents() == false) goto L7;
    L8:
        return false;
    }

    void onSystemReadyLocked() {
        loadRecentsComponent(this.mService.mContext.getResources());
        this.mTasks.clear();
    }

    Bitmap getTaskDescriptionIcon(String path) {
        return this.mTaskPersister.getTaskDescriptionIcon(path);
    }

    void saveImage(Bitmap image, String path) {
        this.mTaskPersister.saveImage(image, path);
    }

    void flush() {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        syncPersistentTaskIdsLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        this.mTaskPersister.flush();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    int[] usersWithRecentsLoadedLocked() {
        int[] usersWithRecentsLoaded = new int[this.mUsersWithRecentsLoaded.size()];
        int len = 0;
        int i = 0;
    L4:
        if (i >= usersWithRecentsLoaded.length) goto L9;
        int userId = this.mUsersWithRecentsLoaded.keyAt(i);
        if (this.mUsersWithRecentsLoaded.valueAt(i).get() == false) goto L8;
        usersWithRecentsLoaded[len] = userId;
        len = len + 1;
    L8:
        i = i + 1;
        goto L4
    L9:
        int i2 = usersWithRecentsLoaded.length;
        if (len < i2) goto L12;
        return usersWithRecentsLoaded;
    L12:
        return Arrays.copyOf(usersWithRecentsLoaded, len);
    }

    void unloadUserDataFromMemoryLocked(int userId) {
        if (isRecentTasksLoaded(userId) == false) goto L5;
        Slog.i("ActivityTaskManager", "Unloading recents for user " + userId + " from memory.");
        this.mUsersWithRecentsLoaded.delete(userId);
        removeTasksForUserFromMemoryLocked(userId);
    L5:
        this.mPersistedTaskIds.delete(userId);
        this.mTaskPersister.unloadUserDataFromMemory(userId);
    }

    private void removeTasksForUserFromMemoryLocked(int userId) {
        if (userId > 0) goto L5;
        Slog.i("ActivityTaskManager", "Can't remove recent task on user " + userId);
        return;
    L5:
        boolean notifyTaskUpdated = false;
        int i = this.mTasks.size() - 1;
    L6:
        if (i < 0) goto L15;
        Task task = this.mTasks.get(i);
        if (task.mUserId != userId) goto L13;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[2] == false) goto L12;
        String protoLogParam0 = String.valueOf(task);
        long protoLogParam1 = userId;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_TASKS, 3308140128142966415L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1)});
    L12:
        this.mTasks.remove(task);
        this.mService.mWindowManager.mSnapshotController.mTaskSnapshotController.removeSnapshotCache(task.mTaskId);
        notifyTaskUpdated = true;
    L13:
        i = i - 1;
        goto L6
    L15:
        if (notifyTaskUpdated == false) goto L21;
        this.mTaskNotificationController.notifyTaskListUpdated();
        return;
    }

    void onPackagesSuspendedChanged(String[] packages, boolean suspended, int userId) {
        Set<String> packageNames = Sets.newHashSet(packages);
        int i = this.mTasks.size() - 1;
    L3:
        if (i < 0) goto L18;
        Task task = this.mTasks.get(i);
        if (task.realActivity == null) goto L16;
        if (packageNames.contains(task.realActivity.getPackageName()) == false) goto L16;
        if (task.mUserId != userId) goto L16;
        if (task.realActivitySuspended == suspended) goto L16;
        task.realActivitySuspended = suspended;
        if (suspended == false) goto L15;
        this.mSupervisor.removeTask(task, false, true, "suspended-package");
    L15:
        notifyTaskPersisterLocked(task, false);
    L16:
        i = i - 1;
        goto L3
    }

    void onLockTaskModeStateChanged(int lockTaskModeState, int userId) {
        if (lockTaskModeState == 1) goto L5;
        return;
    L5:
        int i = this.mTasks.size() - 1;
    L6:
        if (i < 0) goto L14;
        Task task = this.mTasks.get(i);
        if (task.mUserId != userId) goto L12;
        this.mService.getLockTaskController();
        if (LockTaskController.isTaskAuthAllowlisted(task.mLockTaskAuth) == true) goto L12;
        remove(task);
    L12:
        i = i - 1;
        goto L6
    }

    void removeTasksByPackageName(String packageName, int userId) {
        int i = this.mTasks.size() - 1;
    L3:
        if (i < 0) goto L24;
        Task task = this.mTasks.get(i);
        if (task.mUserId != userId) goto L22;
        if ("com.android.settings".equals(task.getBasePackageName()) == false) goto L19;
        if (task.intent == null) goto L19;
        if (task.intent.getData() == null) goto L19;
        if (packageName.equals(task.intent.getData().getSchemeSpecificPart()) == false) goto L19;
        if (this.mSupervisor.mService.getPackageManagerInternalLocked().getPackage(packageName) != null) goto L19;
        this.mSupervisor.removeTask(task, true, true, "remove-package-task");
    L19:
        if (task.getBasePackageName().equals(packageName) == false) goto L22;
        this.mSupervisor.removeTask(task, true, true, "remove-package-task");
    L22:
        i = i - 1;
        goto L3
    }

    void removeAllVisibleTasks(int userId) {
        Set<Integer> profileIds = getProfileIds(userId);
        int i = this.mTasks.size() - 1;
    L3:
        if (i < 0) goto L12;
        Task task = this.mTasks.get(i);
        if (profileIds.contains(Integer.valueOf(task.mUserId)) == false) goto L10;
        if (isVisibleRecentTask(task) == false) goto L10;
        this.mTasks.remove(i);
        notifyTaskRemoved(task, true, true);
    L10:
        i = i - 1;
        goto L3
    }

    void cleanupDisabledPackageTasksLocked(String packageName, Set<String> filterByClasses, int userId) {
        int i = this.mTasks.size() - 1;
    L3:
        if (i < 0) goto L27;
        Task task = this.mTasks.get(i);
        if (userId == (-1)) goto L10;
        if (task.mUserId == userId) goto L10;
    L25:
        i = i - 1;
    L10:
        if (task.intent == null) goto L12;
        ComponentName cn = task.intent.getComponent();
    L14:
        if (cn != null) goto L16;
    L21:
        boolean sameComponent = false;
    L23:
        if (sameComponent == false) goto L25;
        this.mSupervisor.removeTask(task, false, true, "disabled-package");
        goto L25
    L16:
        if (cn.getPackageName().equals(packageName) == false) goto L21;
        if (filterByClasses != null) goto L19;
    L20:
        sameComponent = true;
        goto L23
    L19:
        if (filterByClasses.contains(cn.getClassName()) == false) goto L21;
    L12:
        cn = null;
        goto L14
    }

    void cleanupLocked(int userId) {
        int recentsCount = this.mTasks.size();
        if (recentsCount != 0) goto L5;
        return;
    L5:
        this.mTmpAvailActCache.clear();
        this.mTmpAvailAppCache.clear();
        IPackageManager pm = AppGlobals.getPackageManager();
        int i = recentsCount - 1;
    L6:
        if (i < 0) goto L71;
        Task task = this.mTasks.get(i);
        if (userId == (-1)) goto L13;
        if (task.mUserId == userId) goto L13;
    L70:
        i = i - 1;
    L13:
        if (task.autoRemoveRecents == false) goto L18;
        if (task.getTopNonFinishingActivity() != null) goto L18;
        remove(task);
        Slog.w("ActivityTaskManager", "Removing auto-remove without activity: " + task);
    L18:
        if (task.realActivity == null) goto L70;
        ActivityInfo ai = this.mTmpAvailActCache.get(task.realActivity);
        if (ai != null) goto L29;
        ActivityInfo ai2 = pm.getActivityInfo(task.realActivity, 268436480, userId);     // Catch: RemoteException -> L26
        if (ai2 != null) goto L24;
        ai = NO_ACTIVITY_INFO_TOKEN;
    L25:
        this.mTmpAvailActCache.put(task.realActivity, ai);
        goto L29
    L24:
        ai = ai2;
    L29:
        if (ai != NO_ACTIVITY_INFO_TOKEN) goto L52;
        ApplicationInfo app = this.mTmpAvailAppCache.get(task.realActivity.getPackageName());
        if (app != null) goto L40;
        ApplicationInfo app2 = pm.getApplicationInfo(task.realActivity.getPackageName(), 8192, userId);     // Catch: RemoteException -> L37
        if (app2 != null) goto L35;
        app = NO_APPLICATION_INFO_TOKEN;
    L36:
        this.mTmpAvailAppCache.put(task.realActivity.getPackageName(), app);
        goto L40
    L35:
        app = app2;
    L40:
        if (app != NO_APPLICATION_INFO_TOKEN) goto L42;
    L50:
        remove(task);
        Slog.w("ActivityTaskManager", "Removing no longer valid recent: " + task);
        goto L70
    L42:
        if ((8388608 & app.flags) == 0) goto L50;
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == true) goto L47;
    L49:
        task.isAvailable = false;
        goto L70
    L47:
        if (task.isAvailable == false) goto L49;
        Slog.d("ActivityTaskManager", "Making recent unavailable: " + task);
        goto L49
    L52:
        if (ai.enabled == false) goto L65;
        if (ai.applicationInfo.enabled == false) goto L65;
        if ((ai.applicationInfo.flags & 8388608) == 0) goto L65;
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == true) goto L61;
    L63:
        task.isAvailable = true;
        goto L70
    L61:
        if (task.isAvailable == true) goto L63;
        Slog.d("ActivityTaskManager", "Making recent available: " + task);
    L65:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == true) goto L67;
    L69:
        task.isAvailable = false;
        goto L70
    L67:
        if (task.isAvailable == false) goto L69;
        Slog.d("ActivityTaskManager", "Making recent unavailable: " + task + " (enabled=" + ai.enabled + SliceClientPermissions.SliceAuthority.DELIMITER + ai.applicationInfo.enabled + " flags=" + Integer.toHexString(ai.applicationInfo.flags) + ")");
        goto L69
    L71:
        int i2 = 0;
        int recentsCount2 = this.mTasks.size();
    L72:
        if (i2 >= recentsCount2) goto L74;
        i2 = processNextAffiliateChainLocked(i2);
        goto L72
    }

    private boolean canAddTaskWithoutTrim(Task task) {
        if (findRemoveIndexForAddTask(task) != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    ArrayList<IBinder> getAppTasksList(int callingUid, String callingPackage) {
        ArrayList<IBinder> list = new ArrayList();
        int size = this.mTasks.size();
        int i = 0;
    L3:
        if (i >= size) goto L13;
        Task task = this.mTasks.get(i);
        if (task.effectiveUid != callingUid) goto L11;
        if (callingPackage.equals(task.getBasePackageName()) == false) goto L11;
        AppTaskImpl taskImpl = new AppTaskImpl(this.mService, task.mTaskId, callingUid);
        list.add(taskImpl.asBinder());
    L11:
        i = i + 1;
        goto L3
    L13:
        return list;
    }

    Set<Integer> getProfileIds(int userId) {
        Set<Integer> userIds = new ArraySet();
        int[] profileIds = this.mService.getUserManager().getProfileIds(userId, false);
        int i = 0;
    L4:
        if (i >= profileIds.length) goto L7;
        userIds.add(Integer.valueOf(profileIds[i]));
        i = i + 1;
        goto L4
    L7:
        return userIds;
    }

    UserInfo getUserInfo(int userId) {
        return this.mService.getUserManager().getUserInfo(userId);
    }

    int[] getCurrentProfileIds() {
        return this.mService.mAmInternal.getCurrentProfileIds();
    }

    ParceledListSlice<ActivityManager.RecentTaskInfo> getRecentTasks(int maxNum, int flags, boolean getTasksAllowed, int userId, int callingUid) {
        return new ParceledListSlice(getRecentTasksImpl(maxNum, flags, getTasksAllowed, userId, callingUid));
    }

    private ArrayList<ActivityManager.RecentTaskInfo> getRecentTasksImpl(int maxNum, int flags, boolean getTasksAllowed, int userId, int callingUid) {
        if ((flags & 1) == 0) goto L5;
        boolean withExcluded = true;
    L6:
        Set<Integer> includedUsers = getProfileIds(userId);
        includedUsers.add(Integer.valueOf(userId));
        ArrayList<ActivityManager.RecentTaskInfo> res = new ArrayList();
        int size = this.mTasks.size();
        int numVisibleTasks = 0;
        int i = 0;
    L7:
        if (i >= size) goto L61;
        Task task = this.mTasks.get(i);
        if (isVisibleRecentTask(task) == false) goto L59;
        numVisibleTasks = numVisibleTasks + 1;
        if (isInVisibleRange(task, i, numVisibleTasks, withExcluded) == false) goto L59;
        if (res.size() >= maxNum) goto L59;
        if (includedUsers.contains(Integer.valueOf(task.mUserId)) == true) goto L22;
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L59;
        Slog.d("ActivityTaskManager", "Skipping, not user: " + task);
        goto L59
    L22:
        if (task.realActivitySuspended == true) goto L24;
        if (getTasksAllowed == true) goto L38;
        if (task.isActivityTypeHome() == true) goto L38;
        if (task.effectiveUid == callingUid) goto L38;
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L59;
        Slog.d("ActivityTaskManager", "Skipping, not allowed: " + task);
    L38:
        if (task.autoRemoveRecents == false) goto L45;
        if (task.getTopNonFinishingActivity() != null) goto L45;
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L59;
        Slog.d("ActivityTaskManager", "Skipping, auto-remove without activity: " + task);
    L45:
        if ((flags & 2) == 0) goto L52;
        if (task.isAvailable == true) goto L52;
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L59;
        Slog.d("ActivityTaskManager", "Skipping, unavail real act: " + task);
    L52:
        if (task.mUserSetupComplete == false) goto L54;
    L56:
        res.add(createRecentTaskInfo(task, true, getTasksAllowed));
        goto L59
    L54:
        if ((flags & 4) != 0) goto L56;
        Slog.d("ActivityTaskManager", "Skipping, user setup not complete: " + task);
        goto L59
    L24:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L59;
        Slog.d("ActivityTaskManager", "Skipping, activity suspended: " + task);
    L59:
        i = i + 1;
        goto L7
    L61:
        return res;
    L5:
        withExcluded = false;
        goto L6
    }

    void getPersistableTaskIds(ArraySet<Integer> persistentTaskIds) {
        int size = this.mTasks.size();
        int i = 0;
    L3:
        if (i >= size) goto L14;
        Task task = this.mTasks.get(i);
        Task rootTask = task.getRootTask();
        if (task.isPersistable == false) goto L7;
    L8:
        if (rootTask != null) goto L10;
    L11:
        persistentTaskIds.add(Integer.valueOf(task.mTaskId));
    L12:
        i = i + 1;
        goto L3
    L10:
        if (rootTask.isActivityTypeHomeOrRecents() == true) goto L12;
    L7:
        if (task.inRecents == false) goto L12;
    }

    ArrayList<Task> getRawTasks() {
        return this.mTasks;
    }

    SparseBooleanArray getRecentTaskIds() {
        SparseBooleanArray res = new SparseBooleanArray();
        int size = this.mTasks.size();
        int numVisibleTasks = 0;
        int i = 0;
    L3:
        if (i >= size) goto L11;
        Task task = this.mTasks.get(i);
        if (isVisibleRecentTask(task) == false) goto L9;
        numVisibleTasks = numVisibleTasks + 1;
        if (isInVisibleRange(task, i, numVisibleTasks, false) == false) goto L9;
        res.put(task.mTaskId, true);
    L9:
        i = i + 1;
        goto L3
    L11:
        return res;
    }

    Task getTask(int id) {
        int recentsCount = this.mTasks.size();
        int i = 0;
    L3:
        if (i >= recentsCount) goto L8;
        Task task = this.mTasks.get(i);
        if (task.mTaskId == id) goto L6;
        i = i + 1;
        goto L3
    L6:
        return task;
    L8:
        return null;
    }

    void add(Task task) {
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS_TRIM_TASKS == false) goto L6;
        Slog.d("ActivityTaskManager", "add: task=" + task);
    L6:
        if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(task.prefetchState) == false) goto L10;
        Slog.i("ActivityTaskManager", "skip add task when prefetch. task=" + task);
        return;
    L10:
        if (task.mAffiliatedTaskId == task.mTaskId) goto L12;
    L17:
        boolean isAffiliated = true;
    L18:
        int recentsCount = this.mTasks.size();
        if (task.voiceSession != null) goto L21;
        if (isAffiliated == true) goto L32;
        if (recentsCount <= 0) goto L32;
        if (this.mTasks.get(0) != task) goto L32;
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L109;
        Slog.d("ActivityTaskManager", "addRecent: already at top: " + task);
        return;
    L109:
        return;
    L32:
        if (isAffiliated == false) goto L42;
        if (recentsCount <= 0) goto L42;
        if (task.inRecents == false) goto L42;
        if (task.mAffiliatedTaskId != this.mTasks.get(0).mAffiliatedTaskId) goto L42;
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L110;
        Slog.d("ActivityTaskManager", "addRecent: affiliated " + this.mTasks.get(0) + " at top when adding " + task);
        return;
    L110:
        return;
    L42:
        boolean needAffiliationFix = false;
        if (task.inRecents == false) goto L59;
        int taskIndex = this.mTasks.indexOf(task);
        if (taskIndex < 0) goto L57;
        if (isAffiliated == true) goto L59;
        if (this.mFreezeTaskListReordering == true) goto L55;
        int indexToAdd = findIndexToAdd(task);
        this.mTasks.remove(taskIndex);
        this.mTasks.add(indexToAdd, task);
        if (taskIndex == 0) goto L53;
        this.mTaskNotificationController.notifyTaskListUpdated();
    L53:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L55;
        Slog.d("ActivityTaskManager", "addRecent: moving " + task + " to index " + indexToAdd + " from " + taskIndex);
    L55:
        notifyTaskPersisterLocked(task, false);
        return;
    L57:
        Slog.wtf("ActivityTaskManager", "Task with inRecent not in recents: " + task);
        needAffiliationFix = true;
    L59:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L61;
        Slog.d("ActivityTaskManager", "addRecent: trimming tasks for " + task);
    L61:
        int removedIndex = removeForAddTask(task);
        task.inRecents = true;
        if (isAffiliated == false) goto L94;
        if (needAffiliationFix == true) goto L94;
        if (isAffiliated == false) goto L101;
        Task other = task.mNextAffiliate;
        if (other != null) goto L69;
        other = task.mPrevAffiliate;
    L69:
        if (other == null) goto L89;
        int otherIndex = this.mTasks.indexOf(other);
        if (otherIndex < 0) goto L84;
        if (other != task.mNextAffiliate) goto L75;
        int taskIndex2 = otherIndex + 1;
    L77:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L79;
        Slog.d("ActivityTaskManager", "addRecent: new affiliated task added at " + taskIndex2 + ": " + task);
    L79:
        this.mTasks.add(taskIndex2, task);
        notifyTaskAdded(task);
        if (moveAffiliatedTasksToFront(task, taskIndex2) == false) goto L82;
        return;
    L82:
        needAffiliationFix = true;
        goto L101
    L75:
        taskIndex2 = otherIndex;
        goto L77
    L84:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L86;
        Slog.d("ActivityTaskManager", "addRecent: couldn't find other affiliation " + other);
    L86:
        needAffiliationFix = true;
        goto L101
    L89:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L91;
        Slog.d("ActivityTaskManager", "addRecent: adding affiliated task without next/prev:" + task);
    L91:
        needAffiliationFix = true;
    L101:
        if (needAffiliationFix == true) goto L103;
    L106:
        this.mCheckTrimmableTasksOnIdle = true;
        notifyTaskPersisterLocked(task, false);
        return;
    L103:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L105;
        Slog.d("ActivityTaskManager", "addRecent: regrouping affiliations");
    L105:
        cleanupLocked(task.mUserId);
    L94:
        if (this.mFreezeTaskListReordering == false) goto L97;
        if (removedIndex == (-1)) goto L97;
        int indexToAdd2 = removedIndex;
    L98:
        this.mTasks.add(indexToAdd2, task);
        notifyTaskAdded(task);
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L101;
        Slog.d("ActivityTaskManager", "addRecent: adding " + task);
    L97:
        indexToAdd2 = 0;
        goto L98
    L21:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L108;
        Slog.d("ActivityTaskManager", "addRecent: not adding voice interaction " + task);
        return;
    L108:
        return;
    L12:
        if (task.mNextAffiliateTaskId != (-1)) goto L17;
        if (task.mPrevAffiliateTaskId != (-1)) goto L17;
        isAffiliated = false;
        goto L18
    }

    private int findIndexToAdd(Task task) {
        int indexToAdd = 0;
        int i = 0;
    L4:
        if (i >= this.mTasks.size()) goto L22;
        Task otherTask = this.mTasks.get(i);
        if (task == otherTask) goto L22;
        if (otherTask.isAttached() == false) goto L22;
        if (otherTask.inPinnedWindowingMode() == true) goto L21;
        if (otherTask.topRunningActivity() == null) goto L21;
        if (task.compareTo(otherTask) > 0) goto L22;
        indexToAdd = i + 1;
    L21:
        i = i + 1;
    L22:
        return indexToAdd;
    }

    boolean addToBottom(Task task) {
        if (canAddTaskWithoutTrim(task) == true) goto L6;
        return false;
    L6:
        add(task);
        return true;
    }

    void remove(Task task) {
        this.mTasks.remove(task);
        notifyTaskRemoved(task, false, false);
        if (task == null) goto L19;
        Intent intent = task.getBaseIntent();
        if (intent != null) goto L7;
        return;
    L7:
        ComponentName componentName = intent.getComponent();
        if (componentName != null) goto L10;
        return;
    L10:
        String taskPkgName = componentName.getPackageName();
        if (this.mUxPerf != null) goto L13;
        return;
    L13:
        if (this.mUxPerf.board_first_api_lvl < 33) goto L15;
    L17:
        this.mUxPerf.perfEvent(4243, taskPkgName, 2, new int[]{0, 0});
        return;
    L15:
        if (this.mUxPerf.board_api_lvl >= 33) goto L17;
        this.mUxPerf.perfUXEngine_events(4, 0, taskPkgName, 0);
        return;
    }

    void onActivityIdle(ActivityRecord r) {
        if (this.mHiddenTasks.isEmpty() == true) goto L10;
        if (r.isActivityTypeHome() == false) goto L10;
        if (r.isState(ActivityRecord.State.RESUMED) == false) goto L10;
        removeUnreachableHiddenTasks(r.getWindowingMode());
    L10:
        if (this.mCheckTrimmableTasksOnIdle == false) goto L13;
        this.mCheckTrimmableTasksOnIdle = false;
        trimInactiveRecentTasks();
        return;
    }

    private void trimInactiveRecentTasks() {
        if (this.mFreezeTaskListReordering == false) goto L5;
        return;
    L5:
        int recentsCount = this.mTasks.size();
    L7:
        if (recentsCount <= this.mGlobalMaxNumTasks) goto L12;
        Task task = this.mTasks.remove(recentsCount - 1);
        notifyTaskRemoved(task, true, false);
        recentsCount = recentsCount - 1;
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS_TRIM_TASKS == false) goto L7;
        Slog.d("ActivityTaskManager", "Trimming over max-recents task=" + task + " max=" + this.mGlobalMaxNumTasks);
        goto L7
    L12:
        int[] profileUserIds = getCurrentProfileIds();
        this.mTmpQuietProfileUserIds.clear();
        int r5 = profileUserIds.length;
        int r6 = 0;
    L13:
        if (r6 >= r5) goto L25;
        int userId = profileUserIds[r6];
        UserInfo userInfo = getUserInfo(userId);
        if (userInfo == null) goto L22;
        if (userInfo.isManagedProfile() == false) goto L22;
        if (userInfo.isQuietModeEnabled() == false) goto L22;
        this.mTmpQuietProfileUserIds.put(userId, true);
    L22:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS_TRIM_TASKS == false) goto L24;
        Slog.d("ActivityTaskManager", "User: " + userInfo + " quiet=" + this.mTmpQuietProfileUserIds.get(userId));
    L24:
        r6 = r6 + 1;
        goto L13
    L25:
        int numVisibleTasks = 0;
        int i = 0;
    L27:
        if (i >= this.mTasks.size()) goto L50;
        Task task2 = this.mTasks.get(i);
        if (isActiveRecentTask(task2, this.mTmpQuietProfileUserIds) == false) goto L46;
        if (this.mHasVisibleRecentTasks == false) goto L32;
        if (isVisibleRecentTask(task2) == false) goto L35;
        numVisibleTasks = numVisibleTasks + 1;
        if (isInVisibleRange(task2, i, numVisibleTasks, false) == true) goto L44;
        if (isTrimmable(task2) == false) goto L44;
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS_TRIM_TASKS == false) goto L48;
        Slog.d("ActivityTaskManager", "Trimming out-of-range visible task=" + task2);
    L48:
        this.mTasks.remove(task2);
        notifyTaskRemoved(task2, true, false);
        notifyTaskPersisterLocked(task2, false);
    L44:
        i = i + 1;
        goto L27
    L35:
        i = i + 1;
        goto L27
    L32:
        i = i + 1;
        goto L27
    L46:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS_TRIM_TASKS == false) goto L48;
        Slog.d("ActivityTaskManager", "Trimming inactive task=" + task2);
        goto L48
    }

    private boolean isActiveRecentTask(Task task, SparseBooleanArray quietProfileUserIds) {
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS_TRIM_TASKS == false) goto L6;
        Slog.d("ActivityTaskManager", "isActiveRecentTask: task=" + task + " globalMax=" + this.mGlobalMaxNumTasks);
    L6:
        if (quietProfileUserIds.get(task.mUserId) == false) goto L12;
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS_TRIM_TASKS == false) goto L10;
        Slog.d("ActivityTaskManager", "\tisQuietProfileTask=true");
    L10:
        return false;
    L12:
        if (task.mAffiliatedTaskId != (-1)) goto L14;
        return true;
    L14:
        if (task.mAffiliatedTaskId == task.mTaskId) goto L25;
        Task affiliatedTask = getTask(task.mAffiliatedTaskId);
        if (affiliatedTask != null) goto L18;
        return true;
    L18:
        if (isActiveRecentTask(affiliatedTask, quietProfileUserIds) == false) goto L20;
        return true;
    L20:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS_TRIM_TASKS == false) goto L22;
        Slog.d("ActivityTaskManager", "\taffiliatedWithTask=" + affiliatedTask + " is not active");
    L22:
        return false;
    L25:
        return true;
    }

    boolean isVisibleRecentTask(Task task) {
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS_TRIM_TASKS == false) goto L6;
        Slog.d("ActivityTaskManager", "isVisibleRecentTask: task=" + task + " isForceExcludedFromRecents=" + task.isForceExcludedFromRecents() + " minVis=" + this.mMinNumVisibleTasks + " maxVis=" + this.mMaxNumVisibleTasks + " sessionDuration=" + this.mActiveTasksSessionDurationMs + " inactiveDuration=" + task.getInactiveDuration() + " activityType=" + task.getActivityType() + " windowingMode=" + task.getWindowingMode() + " isAlwaysOnTopWhenVisible=" + task.isAlwaysOnTopWhenVisible() + " intentFlags=" + task.getBaseIntent().getFlags());
    L6:
        if (task == null) goto L11;
        if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(task.prefetchState) == false) goto L11;
        return false;
    L11:
        if (this.mService.getObricExt().filterTaskFromRecents(task) == false) goto L15;
        Slog.d("ActivityTaskManager", "the task is in autoaction, not visible in recent");
        return false;
    L15:
        switch(task.getActivityType()) {
            case 2: goto L37;
            case 3: goto L37;
            case 4: goto L18;
            case 5: goto L37;
            default: goto L21;
        };
    L37:
        return false;
    L18:
        if ((task.getBaseIntent().getFlags() & 8388608) != 8388608) goto L21;
        return false;
    L21:
        switch(task.getWindowingMode()) {
            case 2: goto L36;
            case 6: goto L24;
            default: goto L27;
        };
    L36:
        return false;
    L24:
        if (task.isAlwaysOnTopWhenVisible() == false) goto L27;
        return false;
    L27:
        if (task != this.mService.getLockTaskController().getRootTask()) goto L30;
        return false;
    L30:
        if (task.getDisplayContent() != null) goto L32;
        return true;
    L32:
        if (task.getDisplayContent().canShowTasksInHostDeviceRecents() == true) goto L38;
        return false;
    L38:
        return true;
    }

    private boolean isInVisibleRange(Task task, int taskIndex, int numVisibleTasks, boolean skipExcludedCheck) {
        if (skipExcludedCheck == true) goto L31;
        if (task.getBaseIntent() != null) goto L7;
    L9:
        boolean isExcludeFromRecents = false;
    L11:
        if (isExcludeFromRecents == false) goto L31;
        if ((task.getBaseIntent().getSmtEx().getSmFlags() & 2) != 0) goto L31;
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS_TRIM_TASKS == false) goto L18;
        Slog.d("ActivityTaskManager", "\texcludeFromRecents=true, taskIndex: " + taskIndex + " getTopVisibleActivity: " + task.getTopVisibleActivity() + " isOnHomeDisplay: " + task.isOnHomeDisplay());
    L18:
        if (this.mService.getObricExt().shouldBeBlockInVisibleRange(task, taskIndex) == false) goto L22;
        Slog.d("ActivityTaskManager", "the task is in autoaction, not isInVisibleRange");
        return false;
    L22:
        if (task.getTopVisibleActivity() == null) goto L24;
        boolean isMostRecentTask = true;
    L26:
        if (task.isOnHomeDisplay() == false) goto L50;
        if (isMostRecentTask == true) goto L29;
        return false;
    L29:
        return true;
    L50:
        return false;
    L24:
        isMostRecentTask = false;
        goto L26
    L7:
        if ((task.getBaseIntent().getFlags() & 8388608) != 8388608) goto L9;
        isExcludeFromRecents = true;
    L31:
        if (this.mMinNumVisibleTasks < 0) goto L36;
        if (numVisibleTasks > this.mMinNumVisibleTasks) goto L36;
        return true;
    L36:
        if (task.mChildPipActivity == null) goto L39;
        return true;
    L39:
        if (this.mMaxNumVisibleTasks < 0) goto L45;
        if (numVisibleTasks <= this.mMaxNumVisibleTasks) goto L43;
        return false;
    L43:
        return true;
    L45:
        if (this.mActiveTasksSessionDurationMs > 0) goto L47;
    L49:
        return true;
    L47:
        if (task.getInactiveDuration() > this.mActiveTasksSessionDurationMs) goto L49;
        return true;
    }

    protected boolean isTrimmable(Task task) {
        if (task.isAttached() == true) goto L6;
        return true;
    L6:
        if (task.mIsTrimmableFromRecents == true) goto L9;
        return false;
    L9:
        if (this.mObricExt.isTrimmable(task) == true) goto L12;
        return false;
    L12:
        if (this.mRecentTasksSmtEx.isTrimmable(task) == true) goto L15;
        return false;
    L15:
        if (task.isOnHomeDisplay() == true) goto L17;
        return false;
    L17:
        Task rootHomeTask = task.getDisplayArea().getRootHomeTask();
        if (rootHomeTask != null) goto L21;
        return false;
    L21:
        if (task.compareTo(rootHomeTask) >= 0) goto L24;
        return true;
    L24:
        return false;
    }

    private void removeUnreachableHiddenTasks(int windowingMode) {
        int size = this.mHiddenTasks.size();
        if (size > 10) goto L5;
        return;
    L5:
        int i = size - 1;
    L6:
        if (i < 10) goto L21;
        Task hiddenTask = this.mHiddenTasks.get(i);
        if (hiddenTask.hasChild() == true) goto L10;
    L18:
        this.mHiddenTasks.remove(i);
    L19:
        i = i - 1;
        goto L6
    L10:
        if (hiddenTask.inRecents == true) goto L18;
        if (hiddenTask.getWindowingMode() != windowingMode) goto L19;
        if (hiddenTask.getTopVisibleActivity() != null) goto L19;
        this.mHiddenTasks.remove(i);
        this.mSupervisor.removeTask(hiddenTask, false, false, "remove-hidden-task");
        goto L19
    }

    private int removeForAddTask(Task task) {
        this.mHiddenTasks.remove(task);
        int removeIndex = findRemoveIndexForAddTask(task);
        if (removeIndex != (-1)) goto L5;
        return removeIndex;
    L5:
        Task removedTask = this.mTasks.remove(removeIndex);
        if (removedTask != task) goto L8;
    L15:
        notifyTaskPersisterLocked(removedTask, false);
        return removeIndex;
    L8:
        if (removedTask.hasChild() == true) goto L10;
    L12:
        notifyTaskRemoved(removedTask, false, false, true);
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS_TRIM_TASKS == false) goto L15;
        Slog.d("ActivityTaskManager", "Trimming task=" + removedTask + " for addition of task=" + task);
        goto L15
    L10:
        if (removedTask.isActivityTypeHome() == true) goto L12;
        Slog.i("ActivityTaskManager", "Add " + removedTask + " to hidden list because adding " + task);
        this.mHiddenTasks.add(0, removedTask);
        goto L12
    }

    private int findRemoveIndexForAddTask(Task task) {
        int recentsCount = this.mTasks.size();
        Intent intent = task.intent;
        boolean r5 = true;
        if (intent != null) goto L5;
    L7:
        boolean document = false;
    L8:
        int maxRecents = task.maxRecents - 1;
        int i = 0;
    L9:
        if (i >= recentsCount) goto L76;
        Task t = this.mTasks.get(i);
        if (task == t) goto L75;
        if (hasCompatibleActivityTypeAndWindowingMode(task, t) == false) goto L74;
        if (task.mUserId != t.mUserId) goto L74;
        Intent trIntent = t.intent;
        if (task.affinity != null) goto L20;
    L22:
        boolean sameAffinity = false;
    L24:
        if (intent != null) goto L26;
    L28:
        boolean sameIntent = false;
    L29:
        boolean multiTasksAllowed = false;
        if (intent == null) goto L32;
        int flags = intent.getFlags();
    L34:
        if ((268959744 & flags) != 0) goto L36;
    L38:
        if (trIntent != null) goto L40;
    L42:
        boolean trIsDocument = false;
    L43:
        if (document == false) goto L46;
        if (trIsDocument == false) goto L46;
        boolean bothDocuments = r5;
    L47:
        if (sameAffinity == true) goto L51;
        if (sameIntent == true) goto L51;
        if (bothDocuments == false) goto L74;
    L51:
        if (bothDocuments == true) goto L53;
        if (document == true) goto L74;
        if (trIsDocument == true) goto L74;
        if (multiTasksAllowed == false) goto L75;
    L53:
        if (task.realActivity != null) goto L55;
    L59:
        boolean sameActivity = false;
    L61:
        if (sameActivity == false) goto L74;
        if (maxRecents <= 0) goto L75;
        maxRecents = maxRecents - 1;
        if (sameIntent == false) goto L74;
        if (multiTasksAllowed == false) goto L75;
    L55:
        if (t.realActivity == null) goto L59;
        if (task.realActivity.equals(t.realActivity) == false) goto L59;
        sameActivity = true;
    L46:
        bothDocuments = false;
        goto L47
    L40:
        if (trIntent.isDocument() == false) goto L42;
        trIsDocument = r5;
        goto L43
    L36:
        if ((134217728 & flags) == 0) goto L38;
        multiTasksAllowed = true;
        goto L38
    L32:
        flags = 0;
        goto L34
    L26:
        if (intent.filterEquals(trIntent) == false) goto L28;
        sameIntent = r5;
        goto L29
    L20:
        if (task.affinity.equals(t.affinity) == false) goto L22;
        sameAffinity = r5;
    L74:
        i = i + 1;
        r5 = true;
    L75:
        return i;
    L76:
        return -1;
    L5:
        if (intent.isDocument() == false) goto L7;
        document = true;
        goto L8
    }

    private int processNextAffiliateChainLocked(int start) {
        Task startTask = this.mTasks.get(start);
        int affiliateId = startTask.mAffiliatedTaskId;
        if (startTask.mTaskId == affiliateId) goto L5;
    L10:
        this.mTmpRecents.clear();
        int i = this.mTasks.size() - 1;
    L11:
        if (i < start) goto L16;
        Task task = this.mTasks.get(i);
        if (task.mAffiliatedTaskId != affiliateId) goto L15;
        this.mTasks.remove(i);
        this.mTmpRecents.add(task);
    L15:
        i = i - 1;
        goto L11
    L16:
        Collections.sort(this.mTmpRecents, TASK_ID_COMPARATOR);
        Task first = this.mTmpRecents.get(0);
        first.inRecents = true;
        if (first.mNextAffiliate == null) goto L19;
        Slog.w("ActivityTaskManager", "Link error 1 first.next=" + first.mNextAffiliate);
        first.setNextAffiliate(null);
        notifyTaskPersisterLocked(first, false);
    L19:
        int tmpSize = this.mTmpRecents.size();
        int i2 = 0;
    L21:
        if (i2 >= (tmpSize - 1)) goto L29;
        Task next = this.mTmpRecents.get(i2);
        Task prev = this.mTmpRecents.get(i2 + 1);
        if (next.mPrevAffiliate == prev) goto L26;
        Slog.w("ActivityTaskManager", "Link error 2 next=" + next + " prev=" + next.mPrevAffiliate + " setting prev=" + prev);
        next.setPrevAffiliate(prev);
        notifyTaskPersisterLocked(next, false);
    L26:
        if (prev.mNextAffiliate == next) goto L28;
        Slog.w("ActivityTaskManager", "Link error 3 prev=" + prev + " next=" + prev.mNextAffiliate + " setting next=" + next);
        prev.setNextAffiliate(next);
        notifyTaskPersisterLocked(prev, false);
    L28:
        prev.inRecents = true;
        i2 = i2 + 1;
        goto L21
    L29:
        Task last = this.mTmpRecents.get(tmpSize - 1);
        if (last.mPrevAffiliate == null) goto L32;
        Slog.w("ActivityTaskManager", "Link error 4 last.prev=" + last.mPrevAffiliate);
        last.setPrevAffiliate(null);
        notifyTaskPersisterLocked(last, false);
    L32:
        this.mTasks.addAll(start, this.mTmpRecents);
        this.mTmpRecents.clear();
        return start + tmpSize;
    L5:
        if (startTask.mPrevAffiliate != null) goto L10;
        if (startTask.mNextAffiliate != null) goto L10;
        startTask.inRecents = true;
        return start + 1;
    }

    private boolean moveAffiliatedTasksToFront(Task task, int taskIndex) {
        int recentsCount = this.mTasks.size();
        Task top = task;
        int topIndex = taskIndex;
    L4:
        if (top.mNextAffiliate == null) goto L8;
        if (topIndex <= 0) goto L8;
        top = top.mNextAffiliate;
        topIndex = topIndex - 1;
    L8:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L11;
        Slog.d("ActivityTaskManager", "addRecent: adding affiliates starting at " + topIndex + " from initial " + taskIndex);
    L11:
        if (top.mAffiliatedTaskId != task.mAffiliatedTaskId) goto L13;
        boolean isValid = true;
    L14:
        int endIndex = topIndex;
        Task prev = top;
    L16:
        if (endIndex >= recentsCount) goto L55;
        Task cur = this.mTasks.get(endIndex);
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L20;
        StringBuilder r15 = new StringBuilder();
        boolean r16 = false;
        r15.append("addRecent: looking at next chain @");
        r15.append(endIndex);
        r15.append(" ");
        r15.append(cur);
        Slog.d("ActivityTaskManager", r15.toString());
    L22:
        if (cur != top) goto L31;
        if (cur.mNextAffiliate != null) goto L29;
        if (cur.mNextAffiliateTaskId != (-1)) goto L29;
        boolean r17 = true;
    L35:
        Task top2 = top;
        if (cur.mPrevAffiliateTaskId == (-1)) goto L38;
        if (cur.mPrevAffiliate == null) goto L45;
        if (cur.mAffiliatedTaskId != task.mAffiliatedTaskId) goto L48;
        prev = cur;
        endIndex = endIndex + 1;
        if (endIndex >= recentsCount) goto L51;
        top = top2;
        goto L16
    L51:
        Slog.wtf("ActivityTaskManager", "Bad chain ran off index " + endIndex + ": last task " + prev);
        isValid = false;
    L56:
        if (isValid == false) goto L59;
        if (endIndex >= taskIndex) goto L59;
        Slog.wtf("ActivityTaskManager", "Bad chain @" + endIndex + ": did not extend to task " + task + " @" + taskIndex);
        isValid = false;
    L59:
        if (isValid == false) goto L71;
        int i = topIndex;
    L62:
        if (i > endIndex) goto L68;
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L66;
        Slog.d("ActivityTaskManager", "addRecent: moving affiliated " + task + " from " + i + " to " + (i - topIndex));
    L66:
        this.mTasks.add(i - topIndex, this.mTasks.remove(i));
        i = i + 1;
        goto L62
    L68:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L70;
        Slog.d("ActivityTaskManager", "addRecent: done moving tasks  " + topIndex + " to " + endIndex);
    L70:
        return r17;
    L71:
        return r16;
    L48:
        Slog.wtf("ActivityTaskManager", "Bad chain @" + endIndex + ": task " + cur + " has affiliated id " + cur.mAffiliatedTaskId + " but should be " + task.mAffiliatedTaskId);
        isValid = false;
        goto L56
    L45:
        Slog.wtf("ActivityTaskManager", "Bad chain @" + endIndex + ": task " + cur + " has previous affiliate " + cur.mPrevAffiliate + " but should be id " + cur.mPrevAffiliate);
        isValid = false;
        goto L56
    L38:
        if (cur.mPrevAffiliate == null) goto L41;
        Slog.wtf("ActivityTaskManager", "Bad chain @" + endIndex + ": last task " + cur + " has previous affiliate " + cur.mPrevAffiliate);
        isValid = false;
    L41:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L56;
        Slog.d("ActivityTaskManager", "addRecent: end of chain @" + endIndex);
    L29:
        Slog.wtf("ActivityTaskManager", "Bad chain @" + endIndex + ": first task has next affiliate: " + prev);
        isValid = false;
        r17 = true;
        goto L56
    L31:
        if (cur.mNextAffiliate != prev) goto L53;
        r17 = true;
        if (cur.mNextAffiliateTaskId == prev.mTaskId) goto L35;
    L54:
        Slog.wtf("ActivityTaskManager", "Bad chain @" + endIndex + ": middle task " + cur + " @" + endIndex + " has bad next affiliate " + cur.mNextAffiliate + " id " + cur.mNextAffiliateTaskId + ", expected " + prev);
        isValid = false;
        goto L56
    L53:
        r17 = true;
        goto L54
    L20:
        r16 = false;
        goto L22
    L55:
        r16 = false;
        r17 = true;
        goto L56
    L13:
        isValid = false;
        goto L14
    }

    void dump(PrintWriter pw, boolean dumpAll, String dumpPackage) {
        pw.println("ACTIVITY MANAGER RECENT TASKS (dumpsys activity recents)");
        pw.println("mRecentsUid=" + this.mRecentsUid);
        pw.println("mRecentsComponent=" + this.mRecentsComponent);
        pw.println("mFreezeTaskListReordering=" + this.mFreezeTaskListReordering);
        pw.println("mFreezeTaskListReorderingPendingTimeout=" + this.mService.mH.hasCallbacks(this.mResetFreezeTaskListOnTimeoutRunnable));
        if (this.mHiddenTasks.isEmpty() == true) goto L6;
        pw.println("mHiddenTasks=" + this.mHiddenTasks);
    L6:
        if (this.mTasks.isEmpty() == false) goto L8;
        return;
    L8:
        boolean printedHeader = false;
        int size = this.mTasks.size();
        int i = 0;
        boolean printedAnything = false;
    L9:
        boolean r12 = false;
        if (i >= size) goto L59;
        Task task = this.mTasks.get(i);
        if (dumpPackage != null) goto L14;
    L52:
        if (printedHeader == true) goto L54;
        pw.println("  Recent tasks:");
        printedHeader = true;
        printedAnything = true;
    L54:
        pw.print("  * Recent #");
        pw.print(i);
        pw.print(": ");
        pw.println(task);
        if (dumpAll == false) goto L57;
        task.dump(pw, "    ");
    L57:
        i = i + 1;
        goto L9
    L14:
        if (task.intent != null) goto L16;
    L20:
        boolean match = false;
    L22:
        if (match == false) goto L24;
    L32:
        if (match == false) goto L34;
    L40:
        if (match == false) goto L42;
    L48:
        if (match == true) goto L50;
        match = match | dumpPackage.equals(task.mCallingPackage);
    L50:
        if (match == true) goto L52;
    L42:
        if (task.realActivity != null) goto L44;
    L47:
        match = match | r12;
        goto L48
    L44:
        if (dumpPackage.equals(task.realActivity.getPackageName()) == false) goto L47;
        r12 = true;
        goto L47
    L34:
        if (task.origActivity != null) goto L36;
    L38:
        boolean r5 = false;
    L39:
        match = match | r5;
        goto L40
    L36:
        if (dumpPackage.equals(task.origActivity.getPackageName()) == false) goto L38;
        r5 = true;
        goto L39
    L24:
        if (task.affinityIntent != null) goto L26;
    L30:
        boolean r6 = false;
    L31:
        match = match | r6;
        goto L32
    L26:
        if (task.affinityIntent.getComponent() == null) goto L30;
        if (dumpPackage.equals(task.affinityIntent.getComponent().getPackageName()) == false) goto L30;
        r6 = true;
        goto L31
    L16:
        if (task.intent.getComponent() == null) goto L20;
        if (dumpPackage.equals(task.intent.getComponent().getPackageName()) == false) goto L20;
        match = true;
        goto L22
    L59:
        if (this.mHasVisibleRecentTasks == false) goto L114;
        ArrayList<ActivityManager.RecentTaskInfo> tasks = getRecentTasksImpl(Integer.MAX_VALUE, 0, true, this.mService.getCurrentUserId(), 1000);
        int i2 = 0;
        boolean printedHeader2 = false;
    L62:
        if (i2 >= tasks.size()) goto L114;
        ActivityManager.RecentTaskInfo taskInfo = tasks.get(i2);
        if (dumpPackage != null) goto L66;
    L108:
        if (printedHeader2 == true) goto L112;
        if (printedAnything == false) goto L111;
        pw.println();
    L111:
        pw.println("  Visible recent tasks (most recent first):");
        printedHeader2 = true;
        printedAnything = true;
    L112:
        pw.print("  * RecentTaskInfo #");
        pw.print(i2);
        pw.print(": ");
        taskInfo.dump(pw, "    ");
    L113:
        i2 = i2 + 1;
        goto L62
    L66:
        if (taskInfo.baseIntent != null) goto L68;
    L72:
        boolean match2 = false;
    L74:
        if (match2 == false) goto L76;
    L82:
        if (match2 == false) goto L84;
    L90:
        if (match2 == false) goto L92;
    L98:
        if (match2 == false) goto L100;
    L106:
        if (match2 == true) goto L108;
    L100:
        if (taskInfo.realActivity != null) goto L102;
    L104:
        boolean r7 = false;
    L105:
        match2 = match2 | r7;
        goto L106
    L102:
        if (dumpPackage.equals(taskInfo.realActivity.getPackageName()) == false) goto L104;
        r7 = true;
        goto L105
    L92:
        if (taskInfo.origActivity != null) goto L94;
    L96:
        boolean r8 = false;
    L97:
        match2 = match2 | r8;
        goto L98
    L94:
        if (dumpPackage.equals(taskInfo.origActivity.getPackageName()) == false) goto L96;
        r8 = true;
        goto L97
    L84:
        if (taskInfo.topActivity != null) goto L86;
    L88:
        boolean r9 = false;
    L89:
        match2 = match2 | r9;
        goto L90
    L86:
        if (dumpPackage.equals(taskInfo.topActivity.getPackageName()) == false) goto L88;
        r9 = true;
        goto L89
    L76:
        if (taskInfo.baseActivity != null) goto L78;
    L80:
        boolean r10 = false;
    L81:
        match2 = match2 | r10;
        goto L82
    L78:
        if (dumpPackage.equals(taskInfo.baseActivity.getPackageName()) == false) goto L80;
        r10 = true;
        goto L81
    L68:
        if (taskInfo.baseIntent.getComponent() == null) goto L72;
        if (dumpPackage.equals(taskInfo.baseIntent.getComponent().getPackageName()) == false) goto L72;
        match2 = true;
    L114:
        if (printedAnything == true) goto L124;
        pw.println("  (nothing)");
        return;
    }

    ActivityManager.RecentTaskInfo createRecentTaskInfo(Task tr, boolean stripExtras, boolean getTasksAllowed) {
        ActivityManager.RecentTaskInfo rti = new ActivityManager.RecentTaskInfo();
        if (tr.isAttached() == false) goto L5;
        TaskDisplayArea tda = tr.getDisplayArea();
    L6:
        tr.fillTaskInfo(rti, stripExtras, tda);
        if (rti.isRunning == false) goto L9;
        int r2 = rti.taskId;
    L10:
        rti.id = r2;
        rti.persistentId = rti.taskId;
        if (getTasksAllowed == true) goto L13;
        Task.trimIneffectiveInfo(tr, rti);
    L13:
        return rti;
    L9:
        r2 = -1;
        goto L10
    L5:
        tda = this.mService.mRootWindowContainer.getDefaultTaskDisplayArea();
        goto L6
    }

    private boolean hasCompatibleActivityTypeAndWindowingMode(Task t1, Task t2) {
        int activityType = t1.getActivityType();
        int windowingMode = t1.getWindowingMode();
        if (activityType != 0) goto L5;
        boolean isUndefinedType = true;
    L6:
        if (windowingMode != 0) goto L8;
        boolean isUndefinedMode = true;
    L9:
        int otherActivityType = t2.getActivityType();
        int otherWindowingMode = t2.getWindowingMode();
        if (otherActivityType != 0) goto L12;
        boolean isOtherUndefinedType = true;
    L13:
        if (otherWindowingMode != 0) goto L15;
        boolean isOtherUndefinedMode = true;
    L16:
        if (activityType == otherActivityType) goto L21;
        if (isUndefinedType == true) goto L21;
        if (isOtherUndefinedType == true) goto L21;
        boolean isCompatibleType = false;
    L23:
        if (Features.FEAT_QUICK_WIN == false) goto L28;
        if (isCompatibleType == false) goto L26;
        if (otherWindowingMode != 5) goto L26;
    L27:
        return true;
    L26:
        if (windowingMode == 5) goto L27;
    L28:
        if (windowingMode == otherWindowingMode) goto L37;
        if (windowingMode != 5) goto L31;
        if (otherWindowingMode == 1) goto L37;
    L31:
        if (windowingMode != 1) goto L33;
        if (otherWindowingMode == 5) goto L37;
    L33:
        if (isUndefinedMode == true) goto L37;
        if (isOtherUndefinedMode == true) goto L37;
        boolean isCompatibleMode = false;
    L38:
        if (isCompatibleType == false) goto L42;
        if (isCompatibleMode == true) goto L41;
        return false;
    L41:
        return true;
    L42:
        return false;
    L37:
        isCompatibleMode = true;
    L21:
        isCompatibleType = true;
        goto L23
    L15:
        isOtherUndefinedMode = false;
        goto L16
    L12:
        isOtherUndefinedType = false;
        goto L13
    L8:
        isUndefinedMode = false;
        goto L9
    L5:
        isUndefinedType = false;
        goto L6
    }

    public RecentTasksSmtEx getSmtEx() {
        return this.mRecentTasksSmtEx;
    }
}
