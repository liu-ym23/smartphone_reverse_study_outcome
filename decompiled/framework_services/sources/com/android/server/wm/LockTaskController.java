package com.android.server.wm;

import android.app.admin.IDevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.provider.Settings;
import android.telecom.TelecomManager;
import android.util.EventLog;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.android.internal.policy.IKeyguardDismissCallback;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.statusbar.IStatusBarService;
import com.android.internal.telephony.CellBroadcastUtils;
import com.android.internal.widget.LockPatternUtils;
import com.android.server.LocalServices;
import com.android.server.am.ProcessList;
import com.android.server.statusbar.StatusBarManagerInternal;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class LockTaskController {
    private static final String ACTION_EMERGENCY_DIAL = "com.android.phone.EmergencyDialer.DIAL";
    private static final String DIALER_PACKAGE = "com.android.phone";
    static final int LOCK_TASK_AUTH_ALLOWLISTED = 3;
    static final int LOCK_TASK_AUTH_DONT_LOCK = 0;
    static final int LOCK_TASK_AUTH_LAUNCHABLE = 2;
    static final int LOCK_TASK_AUTH_LAUNCHABLE_PRIV = 4;
    static final int LOCK_TASK_AUTH_PINNABLE = 1;
    private static final String LOCK_TASK_TAG = "Lock-to-App";
    private static final SparseArray<Pair<Integer, Integer>> STATUS_BAR_FLAG_MAP_LOCKED = null;
    static final int STATUS_BAR_MASK_LOCKED = 128319488;
    static final int STATUS_BAR_MASK_PINNED = 111083520;
    private static final String TAG = "ActivityTaskManager";
    private static final String TAG_LOCKTASK = "ActivityTaskManager";
    private final Context mContext;
    IDevicePolicyManager mDevicePolicyManager;
    private final Handler mHandler;
    LockPatternUtils mLockPatternUtils;
    private final SparseIntArray mLockTaskFeatures;
    private volatile int mLockTaskModeState;
    private final ArrayList<Task> mLockTaskModeTasks;
    private final SparseArray<String[]> mLockTaskPackages;
    private int mPendingDisableFromDismiss;
    IStatusBarService mStatusBarService;
    private final ActivityTaskSupervisor mSupervisor;
    private final TaskChangeNotificationController mTaskChangeNotificationController;
    TelecomManager mTelecomManager;
    private final IBinder mToken;
    WindowManagerService mWindowManager;

    /* JADX INFO: renamed from: com.android.server.wm.LockTaskController$1, reason: invalid class name */
    class AnonymousClass1 extends IKeyguardDismissCallback.Stub {
        final /* synthetic */ LockTaskController this$0;
        final /* synthetic */ int val$userId;

        /* JADX INFO: renamed from: $r8$lambda$HCt4vYDgGJgQ-hkyEnwwxzLVtRc, reason: not valid java name */
        public static /* synthetic */ void m10066$r8$lambda$HCt4vYDgGJgQhkyEnwwxzLVtRc(AnonymousClass1 r0, int r1) {
            r0.lambda$onDismissSucceeded$0(r1);
        }

        AnonymousClass1(LockTaskController this$0, int r2) {
            this.this$0 = this$0;
            this.val$userId = r2;
        }

        public void onDismissError() throws RemoteException {
            Slog.i("ActivityTaskManager", "setKeyguardState: failed to dismiss keyguard");
        }

        public void onDismissSucceeded() throws RemoteException {
            Handler r0 = LockTaskController.m10062$$Nest$fgetmHandler(this.this$0);
            final int r1 = this.val$userId;
            r0.post(new LockTaskController$1$$ExternalSyntheticLambda0(this, r1));
        }

        private /* synthetic */ void lambda$onDismissSucceeded$0(int userId) {
            if (LockTaskController.m10063$$Nest$fgetmPendingDisableFromDismiss(this.this$0) != userId) goto L6;
            this.this$0.mWindowManager.disableKeyguard(LockTaskController.m10064$$Nest$fgetmToken(this.this$0), LockTaskController.LOCK_TASK_TAG, userId);
            LockTaskController.m10065$$Nest$fputmPendingDisableFromDismiss(this.this$0, ProcessList.INVALID_ADJ);
            return;
        }

        public void onDismissCancelled() throws RemoteException {
            Slog.i("ActivityTaskManager", "setKeyguardState: dismiss cancelled");
        }
    }

    static class LockTaskToken extends Binder {
        /* synthetic */ LockTaskToken(LockTaskControllerIA r1) {
            this();
        }

        private LockTaskToken() {
        }
    }

    public static /* synthetic */ boolean $r8$lambda$0EwYtau8CJ5JfMLKyhM63yE65X0(ActivityRecord r0, ActivityRecord r1) {
        return lambda$activityBlockedFromFinish$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$GXER2ih7y4L6_g7O3sR1W5NP7aM(LockTaskController r0, Intent r1, Task r2, int r3) {
        r0.lambda$setLockTaskMode$4(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$K0vRhNVqbns9lulMtyZvSAuD6rc(LockTaskController r0, Task r1) {
        r0.lambda$removeLockedTask$2(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$iC0g0KPAlyNN3uLeUs7bOW4HXiw(ActivityRecord r0, TaskFragment r1, ActivityRecord r2) {
        return lambda$activityBlockedFromFinish$1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$rygRzJglPDanflZTwIAhBr1Okb4(LockTaskController r0, int r1) {
        r0.lambda$updateLockTaskFeatures$5(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$z0Ljoht1WDN_LMU-StLjxnswYtQ, reason: not valid java name */
    public static /* synthetic */ void m10061$r8$lambda$z0Ljoht1WDN_LMUStLjxnswYtQ(LockTaskController r0, int r1, Task r2) {
        r0.lambda$rebuildSystemLockTaskPinnedMode$3(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m10062$$Nest$fgetmHandler(LockTaskController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingDisableFromDismiss, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m10063$$Nest$fgetmPendingDisableFromDismiss(LockTaskController r0) {
        return r0.mPendingDisableFromDismiss;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m10064$$Nest$fgetmToken(LockTaskController r0) {
        return r0.mToken;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPendingDisableFromDismiss, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10065$$Nest$fputmPendingDisableFromDismiss(LockTaskController r0, int r1) {
        r0.mPendingDisableFromDismiss = r1;
    }

    static {
        STATUS_BAR_FLAG_MAP_LOCKED = new SparseArray();
        STATUS_BAR_FLAG_MAP_LOCKED.append(1, new Pair(8388608, 2));
        STATUS_BAR_FLAG_MAP_LOCKED.append(2, new Pair(393216, 4));
        STATUS_BAR_FLAG_MAP_LOCKED.append(4, new Pair(2097152, 0));
        STATUS_BAR_FLAG_MAP_LOCKED.append(8, new Pair(16777216, 0));
        STATUS_BAR_FLAG_MAP_LOCKED.append(16, new Pair(0, 8));
    }

    LockTaskController(Context context, ActivityTaskSupervisor supervisor, Handler handler, TaskChangeNotificationController taskChangeNotificationController) {
        this.mToken = new LockTaskToken(null);
        this.mLockTaskModeTasks = new ArrayList();
        this.mLockTaskPackages = new SparseArray();
        this.mLockTaskFeatures = new SparseIntArray();
        this.mLockTaskModeState = 0;
        this.mPendingDisableFromDismiss = ProcessList.INVALID_ADJ;
        this.mContext = context;
        this.mSupervisor = supervisor;
        this.mHandler = handler;
        this.mTaskChangeNotificationController = taskChangeNotificationController;
    }

    void setWindowManager(WindowManagerService windowManager) {
        this.mWindowManager = windowManager;
    }

    int getLockTaskModeState() {
        return this.mLockTaskModeState;
    }

    boolean isTaskLocked(Task task) {
        return this.mLockTaskModeTasks.contains(task);
    }

    private boolean isRootTask(Task task) {
        if (this.mLockTaskModeTasks.indexOf(task) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean activityBlockedFromFinish(final ActivityRecord activity) {
        Task task = activity.getTask();
        if (task.mLockTaskAuth != 4) goto L5;
    L32:
        return false;
    L5:
        if (isRootTask(task) == false) goto L32;
        ActivityRecord taskTop = task.getTopNonFinishingActivity();
        ActivityRecord taskRoot = task.getRootActivity();
        if (activity != taskRoot) goto L10;
        if (activity != taskTop) goto L10;
    L29:
        Slog.i("ActivityTaskManager", "Not finishing task in lock task mode");
        showLockTaskToast();
        return true;
    L10:
        final TaskFragment taskFragment = activity.getTaskFragment();
        if (taskFragment.asTask() == null) goto L13;
    L31:
        return false;
    L13:
        if (taskFragment.isDelayLastActivityRemoval() == false) goto L31;
        if (taskFragment.hasAdjacentTaskFragment() == false) goto L31;
        if (taskFragment.getActivity(new LockTaskController$$ExternalSyntheticLambda4(activity)) == null) goto L20;
        boolean hasOtherActivityInTaskFragment = true;
    L21:
        if (hasOtherActivityInTaskFragment == false) goto L24;
        return false;
    L24:
        if (task.getActivity(new LockTaskController$$ExternalSyntheticLambda5(activity, taskFragment)) == null) goto L26;
        boolean hasOtherActivityInTask = true;
    L27:
        if (hasOtherActivityInTask == false) goto L29;
        return false;
    L26:
        hasOtherActivityInTask = false;
        goto L27
    L20:
        hasOtherActivityInTaskFragment = false;
        goto L21
    }

    private static /* synthetic */ boolean lambda$activityBlockedFromFinish$0(ActivityRecord activity, ActivityRecord a) {
        if (a.finishing == true) goto L6;
        if (a == activity) goto L6;
        return true;
    L6:
        return false;
    }

    private static /* synthetic */ boolean lambda$activityBlockedFromFinish$1(ActivityRecord activity, TaskFragment taskFragment, ActivityRecord a) {
        if (a.finishing == true) goto L8;
        if (a == activity) goto L8;
        if (taskFragment.isAdjacentTo(a.getTaskFragment()) == true) goto L8;
        return true;
    L8:
        return false;
    }

    boolean canMoveTaskToBack(Task task) {
        if (isRootTask(task) == false) goto L6;
        showLockTaskToast();
        return false;
    L6:
        return true;
    }

    static boolean isTaskAuthAllowlisted(int lockTaskAuth) {
        switch(lockTaskAuth) {
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    boolean isLockTaskModeViolation(Task task) {
        return isLockTaskModeViolation(task, false);
    }

    boolean isLockTaskModeViolation(Task task, boolean isNewClearTask) {
        if (isTaskLocked(task) == false) goto L7;
        if (isNewClearTask == true) goto L7;
        return false;
    L7:
        if (isLockTaskModeViolationInternal(task, task.mUserId, task.intent, task.mLockTaskAuth) == false) goto L10;
        showLockTaskToast();
        return true;
    L10:
        return false;
    }

    boolean isNewTaskLockTaskModeViolation(ActivityRecord activity) {
        if (activity.getTask() != null) goto L5;
        int auth = getLockTaskAuth(activity, null);
        if (isLockTaskModeViolationInternal(activity, activity.mUserId, activity.intent, auth) == false) goto L10;
        showLockTaskToast();
        return true;
    L10:
        return false;
    L5:
        return isLockTaskModeViolation(activity.getTask());
    }

    Task getRootTask() {
        if (this.mLockTaskModeTasks.isEmpty() == false) goto L7;
        return null;
    L7:
        return this.mLockTaskModeTasks.get(0);
    }

    private boolean isLockTaskModeViolationInternal(WindowContainer wc, int userId, Intent intent, int taskAuth) {
        if (wc.isActivityTypeRecents() == false) goto L8;
        if (isRecentsAllowed(userId) == false) goto L8;
        return false;
    L8:
        if (isKeyguardAllowed(userId) == false) goto L13;
        if (isEmergencyCallIntent(intent) == false) goto L13;
        return false;
    L13:
        if (wc.isActivityTypeDream() == false) goto L16;
        return false;
    L16:
        if (isWirelessEmergencyAlert(intent) == false) goto L19;
        return false;
    L19:
        if (isTaskAuthAllowlisted(taskAuth) == false) goto L21;
        return false;
    L21:
        if (this.mLockTaskModeTasks.isEmpty() == true) goto L25;
        return true;
    L25:
        return false;
    }

    private boolean isRecentsAllowed(int userId) {
        if ((getLockTaskFeaturesForUser(userId) & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isKeyguardAllowed(int userId) {
        if ((getLockTaskFeaturesForUser(userId) & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isBlockingInTaskEnabled(int userId) {
        if ((getLockTaskFeaturesForUser(userId) & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isActivityAllowed(int userId, String packageName, int lockTaskLaunchMode) {
        if (this.mLockTaskModeState == 1) goto L5;
    L13:
        return true;
    L5:
        if (isBlockingInTaskEnabled(userId) == false) goto L13;
        switch(lockTaskLaunchMode) {
            case 1: goto L11;
            case 2: goto L10;
            default: goto L9;
        };
    L10:
        return true;
    L11:
        return false;
    L9:
        return isPackageAllowlisted(userId, packageName);
    }

    private boolean isWirelessEmergencyAlert(Intent intent) {
        if (intent != null) goto L5;
        return false;
    L5:
        ComponentName cellBroadcastAlertDialogComponentName = CellBroadcastUtils.getDefaultCellBroadcastAlertDialogComponent(this.mContext);
        if (cellBroadcastAlertDialogComponentName != null) goto L9;
        return false;
    L9:
        if (cellBroadcastAlertDialogComponentName.equals(intent.getComponent()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private boolean isEmergencyCallIntent(Intent intent) {
        if (intent != null) goto L6;
        return false;
    L6:
        if (TelecomManager.EMERGENCY_DIALER_COMPONENT.equals(intent.getComponent()) == false) goto L9;
        return true;
    L9:
        if ("android.intent.action.CALL_EMERGENCY".equals(intent.getAction()) == false) goto L11;
        return true;
    L11:
        TelecomManager tm = getTelecomManager();
        if (tm == null) goto L14;
        String dialerPackage = tm.getSystemDialerPackage();
    L15:
        if (dialerPackage == null) goto L20;
        if (dialerPackage.equals(intent.getComponent().getPackageName()) == false) goto L20;
        return true;
    L20:
        if (ACTION_EMERGENCY_DIAL.equals(intent.getAction()) == true) goto L22;
    L24:
        return false;
    L22:
        if (DIALER_PACKAGE.equals(intent.getComponent().getPackageName()) == false) goto L24;
        return true;
    L14:
        dialerPackage = null;
        goto L15
    }

    void stopLockTaskMode(Task task, boolean stopAppPinning, int callingUid) {
        if (this.mLockTaskModeState != 0) goto L5;
        return;
    L5:
        if (stopAppPinning == true) goto L7;
        if (task == null) goto L23;
        if (callingUid != task.mLockTaskUid) goto L14;
    L20:
        clearLockedTask(task);
        return;
    L14:
        if (task.mLockTaskUid != 0) goto L19;
        if (callingUid == task.effectiveUid) goto L20;
    L19:
        throw new SecurityException("Invalid uid, expected " + task.mLockTaskUid + " callingUid=" + callingUid + " effectiveUid=" + task.effectiveUid);
    L23:
        throw new IllegalArgumentException("can't stop LockTask for null task");
    L7:
        if (this.mLockTaskModeState != 2) goto L9;
        clearLockedTasks("stopAppPinning");
        return;
    L9:
        Slog.e("ActivityTaskManager", "Attempted to stop app pinning while fully locked");
        showLockTaskToast();
    }

    void clearLockedTasks(String reason) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_LOCKTASK_enabled[2] == false) goto L6;
        String protoLogParam0 = String.valueOf(reason);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_LOCKTASK, 8891808212671675155L, 0, new Object[]{protoLogParam0});
    L6:
        if (this.mLockTaskModeTasks.isEmpty() == true) goto L9;
        clearLockedTask(this.mLockTaskModeTasks.get(0));
        return;
    }

    void clearLockedTask(Task task) {
        if (task != null) goto L4;
        return;
    L4:
        if (this.mLockTaskModeTasks.isEmpty() == false) goto L7;
        return;
    L7:
        if (task != this.mLockTaskModeTasks.get(0)) goto L11;
        int taskNdx = this.mLockTaskModeTasks.size() - 1;
    L9:
        if (taskNdx <= 0) goto L11;
        clearLockedTask(this.mLockTaskModeTasks.get(taskNdx));
        taskNdx = taskNdx - 1;
    L11:
        removeLockedTask(task);
        if (this.mLockTaskModeTasks.isEmpty() == false) goto L14;
        return;
    L14:
        task.performClearTaskForReuse(false);
        this.mSupervisor.mRootWindowContainer.resumeFocusedTasksTopActivities();
    }

    private void removeLockedTask(final Task task) {
        if (this.mLockTaskModeTasks.remove(task) == true) goto L6;
        return;
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_LOCKTASK_enabled[0] == false) goto L9;
        String protoLogParam0 = String.valueOf(task);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_LOCKTASK, 8970634498594714645L, 0, new Object[]{protoLogParam0});
    L9:
        if (this.mLockTaskModeTasks.isEmpty() == true) goto L11;
        return;
    L11:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_LOCKTASK_enabled[0] == false) goto L13;
        String protoLogParam1 = String.valueOf(task);
        String protoLogParam2 = String.valueOf(Debug.getCallers(3));
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_LOCKTASK, 8735562128135241598L, 0, new Object[]{protoLogParam1, protoLogParam2});
    L13:
        this.mHandler.post(new LockTaskController$$ExternalSyntheticLambda3(this, task));
    }

    private /* synthetic */ void lambda$removeLockedTask$2(Task task) {
        performStopLockTask(task.mUserId);
    }

    private void performStopLockTask(int userId) {
        int oldLockTaskModeState = this.mLockTaskModeState;
        this.mLockTaskModeState = 0;
        this.mTaskChangeNotificationController.notifyLockTaskModeChanged(this.mLockTaskModeState);
        setStatusBarState(this.mLockTaskModeState, userId);     // Catch: RemoteException -> L6
        setKeyguardState(this.mLockTaskModeState, userId);     // Catch: RemoteException -> L6
        if (oldLockTaskModeState != 2) goto L9;
        lockKeyguardIfNeeded(userId);     // Catch: RemoteException -> L6
    L9:
        if (getDevicePolicyManager() == null) goto L11;
        getDevicePolicyManager().notifyLockTaskModeChanged(false, null, userId);     // Catch: RemoteException -> L6
    L11:
        if (oldLockTaskModeState != 2) goto L21;
        IStatusBarService statusBarService = getStatusBarService();     // Catch: RemoteException -> L6
        if (statusBarService == null) goto L22;
        statusBarService.showPinningEnterExitToast(false);     // Catch: RemoteException -> L6
        return;
    L22:
        return;
    L21:
        return;
    L6:
        ex = move-exception;
        throw new RuntimeException(ex);
    }

    void showLockTaskToast() {
        if (this.mLockTaskModeState != 2) goto L15;
        IStatusBarService statusBarService = getStatusBarService();     // Catch: RemoteException -> L8
        if (statusBarService == null) goto L16;
        statusBarService.showPinningEscapeToast();     // Catch: RemoteException -> L8
        return;
    L16:
        return;
    L8:
        e = move-exception;
        Slog.e("ActivityTaskManager", "Failed to send pinning escape toast", e);
        return;
    }

    void startLockTaskMode(Task task, boolean isSystemCaller, int callingUid) {
        if (task.mLockTaskAuth == 0) goto L5;
        int r0 = 2;
        if (isSystemCaller == true) goto L28;
        task.mLockTaskUid = callingUid;
        if (task.mLockTaskAuth != 1) goto L26;
        if (this.mLockTaskModeTasks.contains(task) == false) goto L19;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_LOCKTASK_enabled[3] == false) goto L40;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_LOCKTASK, -526479064605838760L, 0, null);
        return;
    L40:
        return;
    L19:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_LOCKTASK_enabled[3] == false) goto L21;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_LOCKTASK, -7119521978513736788L, 0, null);
    L21:
        StatusBarManagerInternal statusBarManager = (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);
        if (statusBarManager == null) goto L41;
        statusBarManager.showScreenPinningRequest(task.mTaskId, task.mUserId);
        return;
    L41:
        return;
    L26:
        if (this.mLockTaskModeState != 2) goto L28;
        Slog.i("ActivityTaskManager", "Stop app pinning before entering full lock task mode");
        stopLockTaskMode(null, true, callingUid);
    L28:
        this.mSupervisor.mRootWindowContainer.removeRootTasksInWindowingModes(new int[]{2});
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_LOCKTASK_enabled[3] == false) goto L34;
        if (isSystemCaller == false) goto L32;
        String r1 = "Locking pinned";
    L33:
        String protoLogParam0 = String.valueOf(r1);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_LOCKTASK, -1557441750657584614L, 0, new Object[]{protoLogParam0});
        goto L34
    L32:
        r1 = "Locking fully";
    L34:
        if (isSystemCaller == true) goto L37;
        r0 = 1;
    L37:
        setLockTaskMode(task, r0, "startLockTask", true);
        return;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_LOCKTASK_enabled[3] == false) goto L39;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_LOCKTASK, 737192738184050156L, 0, null);
        return;
    }

    void rebuildSystemLockTaskPinnedMode() {
        final int lockTaskModeState = this.mLockTaskModeState;
        if (lockTaskModeState == 2) goto L7;
        Slog.e("ActivityTaskManager", "rebuildSystemLockTaskPinnedMode: Attempt to rebuild pinned mode but not in pinned mode.");
        return;
    L7:
        if (this.mLockTaskModeTasks.isEmpty() == false) goto L10;
        Slog.i("ActivityTaskManager", "rebuildSystemLockTaskPinnedMode: mLockTaskModeTasks empty, nothing to rebuild.");
        return;
    L10:
        final Task task = (Task) this.mLockTaskModeTasks.getFirst();
        this.mSupervisor.mRecentTasks.onLockTaskModeStateChanged(2, task.mUserId);
        this.mHandler.post(new LockTaskController$$ExternalSyntheticLambda2(this, lockTaskModeState, task));
    }

    private /* synthetic */ void lambda$rebuildSystemLockTaskPinnedMode$3(int lockTaskModeState, Task task) {
        IStatusBarService statusBarService = getStatusBarService();     // Catch: RemoteException -> L5
        if (statusBarService == null) goto L7;
        statusBarService.showPinningEnterExitToast(true);     // Catch: RemoteException -> L5
    L7:
        this.mTaskChangeNotificationController.notifyLockTaskModeChanged(lockTaskModeState);     // Catch: RemoteException -> L5
        setStatusBarState(lockTaskModeState, task.mUserId);     // Catch: RemoteException -> L5
        setKeyguardState(lockTaskModeState, task.mUserId);     // Catch: RemoteException -> L5
        return;
    L5:
        ex = move-exception;
        throw new RuntimeException(ex);
    }

    private void setLockTaskMode(final Task task, final int lockTaskModeState, String reason, boolean andResume) {
        boolean r3 = false;
        if (task.mLockTaskAuth != 0) goto L9;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_LOCKTASK_enabled[3] == false) goto L36;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_LOCKTASK, -4314079913933391851L, 0, null);
        return;
    L36:
        return;
    L9:
        if (isLockTaskModeViolation(task) == false) goto L12;
        Slog.e("ActivityTaskManager", "setLockTaskMode: Attempt to start an unauthorized lock task.");
        return;
    L12:
        final Intent taskIntent = task.intent;
        if (this.mLockTaskModeTasks.isEmpty() == false) goto L17;
        if (taskIntent == null) goto L17;
        this.mSupervisor.mRecentTasks.onLockTaskModeStateChanged(lockTaskModeState, task.mUserId);
        this.mHandler.post(new LockTaskController$$ExternalSyntheticLambda0(this, taskIntent, task, lockTaskModeState));
    L17:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_LOCKTASK_enabled[3] == false) goto L20;
        String protoLogParam0 = String.valueOf(task);
        String protoLogParam1 = String.valueOf(Debug.getCallers(4));
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_LOCKTASK, 3321878763832425380L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L20:
        if (this.mLockTaskModeTasks.contains(task) == true) goto L23;
        this.mLockTaskModeTasks.add(task);
    L23:
        if (task.mLockTaskUid != (-1)) goto L25;
        task.mLockTaskUid = task.effectiveUid;
    L25:
        if (andResume == false) goto L33;
        ActivityTaskSupervisor r0 = this.mSupervisor;
        if (lockTaskModeState == 0) goto L29;
        r3 = true;
    L29:
        r0.findTaskToMoveToFront(task, 0, null, reason, r3);
        this.mSupervisor.mRootWindowContainer.resumeFocusedTasksTopActivities();
        Task rootTask = task.getRootTask();
        if (rootTask == null) goto L38;
        rootTask.mDisplayContent.executeAppTransition();
        return;
    L38:
        return;
    L33:
        if (lockTaskModeState == 0) goto L39;
        this.mSupervisor.handleNonResizableTaskIfNeeded(task, 0, this.mSupervisor.mRootWindowContainer.getDefaultTaskDisplayArea(), task.getRootTask(), true);
        return;
    }

    private /* synthetic */ void lambda$setLockTaskMode$4(Intent taskIntent, Task task, int lockTaskModeState) {
        performStartLockTask(taskIntent.getComponent().getPackageName(), task.mUserId, lockTaskModeState);
    }

    private void performStartLockTask(String packageName, int userId, int lockTaskModeState) {
        if (lockTaskModeState == 2) goto L16;
    L9:
        this.mLockTaskModeState = lockTaskModeState;     // Catch: RemoteException -> L7
        this.mTaskChangeNotificationController.notifyLockTaskModeChanged(this.mLockTaskModeState);     // Catch: RemoteException -> L7
        setStatusBarState(lockTaskModeState, userId);     // Catch: RemoteException -> L7
        setKeyguardState(lockTaskModeState, userId);     // Catch: RemoteException -> L7
        if (getDevicePolicyManager() == null) goto L18;
        getDevicePolicyManager().notifyLockTaskModeChanged(true, packageName, userId);     // Catch: RemoteException -> L7
        return;
    L7:
        ex = move-exception;
        throw new RuntimeException(ex);
    L18:
        return;
    L16:
        IStatusBarService statusBarService = getStatusBarService();     // Catch: RemoteException -> L7
        if (statusBarService == null) goto L9;
        statusBarService.showPinningEnterExitToast(true);     // Catch: RemoteException -> L7
        goto L9
    }

    void updateLockTaskPackages(int userId, String[] packages) {
        this.mLockTaskPackages.put(userId, packages);
        boolean taskChanged = false;
        int taskNdx = this.mLockTaskModeTasks.size() - 1;
    L4:
        if (taskNdx < 0) goto L31;
        Task lockedTask = this.mLockTaskModeTasks.get(taskNdx);
        if (lockedTask.mLockTaskAuth != 2) goto L8;
    L11:
        boolean wasAllowlisted = true;
    L12:
        lockedTask.setLockTaskAuth();
        if (lockedTask.mLockTaskAuth != 2) goto L15;
    L18:
        boolean isAllowlisted = true;
    L20:
        if (this.mLockTaskModeState != 1) goto L30;
        if (lockedTask.mUserId != userId) goto L30;
        if (wasAllowlisted == false) goto L30;
        if (isAllowlisted == true) goto L30;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_LOCKTASK_enabled[0] == false) goto L29;
        String protoLogParam0 = String.valueOf(lockedTask);
        String protoLogParam1 = String.valueOf(lockedTask.lockTaskAuthToString());
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_LOCKTASK, -4819015209006579825L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L29:
        removeLockedTask(lockedTask);
        lockedTask.performClearTaskForReuse(false);
        taskChanged = true;
    L30:
        taskNdx = taskNdx - 1;
        goto L4
    L15:
        if (lockedTask.mLockTaskAuth == 3) goto L18;
        isAllowlisted = false;
        goto L20
    L8:
        if (lockedTask.mLockTaskAuth == 3) goto L11;
        wasAllowlisted = false;
        goto L12
    L31:
        this.mSupervisor.mRootWindowContainer.forAllTasks(new LockTaskController$$ExternalSyntheticLambda1());
        ActivityRecord r = this.mSupervisor.mRootWindowContainer.topRunningActivity();
        if (r == null) goto L34;
        Task task = r.getTask();
    L36:
        if (this.mLockTaskModeTasks.isEmpty() == false) goto L44;
        if (task == null) goto L44;
        if (task.mLockTaskAuth != 2) goto L44;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_LOCKTASK_enabled[0] == false) goto L43;
        String protoLogParam2 = String.valueOf(task);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_LOCKTASK, 2119751067469297845L, 0, new Object[]{protoLogParam2});
    L43:
        setLockTaskMode(task, 1, "package updated", false);
        taskChanged = true;
    L44:
        if (taskChanged == false) goto L53;
        this.mSupervisor.mRootWindowContainer.resumeFocusedTasksTopActivities();
        return;
    L53:
        return;
    L34:
        task = null;
        goto L36
    }

    int getLockTaskAuth(ActivityRecord rootActivity, Task task) {
        if (rootActivity != null) goto L6;
        if (task != null) goto L6;
        return 0;
    L6:
        int r0 = 1;
        if (rootActivity != null) goto L9;
        return 1;
    L9:
        if (task != null) goto L11;
    L14:
        String pkg = rootActivity.packageName;
    L16:
        if (task == null) goto L18;
        int userId = task.mUserId;
    L20:
        switch(rootActivity.lockTaskLaunchMode) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L23;
            default: goto L38;
        };
    L27:
        return 4;
    L28:
        return 0;
    L38:
        return 0;
    L23:
        if (isPackageAllowlisted(userId, pkg) == false) goto L26;
        r0 = 2;
    L26:
        int lockTaskAuth = r0;
        return lockTaskAuth;
    L30:
        if (isPackageAllowlisted(userId, pkg) == false) goto L33;
        r0 = 3;
    L33:
        int lockTaskAuth2 = r0;
        return lockTaskAuth2;
    L18:
        userId = rootActivity.mUserId;
        goto L20
    L11:
        if (task.realActivity == null) goto L14;
        pkg = task.realActivity.getPackageName();
        goto L16
    }

    boolean isPackageAllowlisted(int userId, String pkg) {
        if (pkg != null) goto L5;
        return false;
    L5:
        String[] allowlist = this.mLockTaskPackages.get(userId);
        if (allowlist != null) goto L8;
        return false;
    L8:
        int r2 = allowlist.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L15;
        String allowlistedPkg = allowlist[r3];
        if (pkg.equals(allowlistedPkg) == true) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        return true;
    L15:
        return false;
    }

    void updateLockTaskFeatures(final int userId, int flags) {
        int oldFlags = getLockTaskFeaturesForUser(userId);
        if (flags != oldFlags) goto L5;
        return;
    L5:
        this.mLockTaskFeatures.put(userId, flags);
        if (this.mLockTaskModeTasks.isEmpty() == false) goto L8;
        return;
    L8:
        if (userId != this.mLockTaskModeTasks.get(0).mUserId) goto L12;
        this.mHandler.post(new LockTaskController$$ExternalSyntheticLambda6(this, userId));
        return;
    }

    private /* synthetic */ void lambda$updateLockTaskFeatures$5(int userId) {
        if (this.mLockTaskModeState != 1) goto L6;
        setStatusBarState(this.mLockTaskModeState, userId);
        setKeyguardState(this.mLockTaskModeState, userId);
        return;
    }

    private void setStatusBarState(int lockTaskModeState, int userId) {
        IStatusBarService statusBar = getStatusBarService();
        if (statusBar != null) goto L6;
        Slog.e("ActivityTaskManager", "Can't find StatusBarService");
        return;
    L6:
        int flags1 = 0;
        int flags2 = 0;
        if (lockTaskModeState != 2) goto L10;
        flags1 = STATUS_BAR_MASK_PINNED;
    L17:
        statusBar.disable(flags1, this.mToken, this.mContext.getPackageName());     // Catch: RemoteException -> L14
        statusBar.disable2(flags2, this.mToken, this.mContext.getPackageName());     // Catch: RemoteException -> L14
        return;
    L14:
        e = move-exception;
        Slog.e("ActivityTaskManager", "Failed to set status bar flags", e);
        return;
    L10:
        if (lockTaskModeState != 1) goto L17;
        int lockTaskFeatures = getLockTaskFeaturesForUser(userId);
        Pair<Integer, Integer> statusBarFlags = getStatusBarDisableFlags(lockTaskFeatures);
        flags1 = ((Integer) statusBarFlags.first).intValue();
        flags2 = ((Integer) statusBarFlags.second).intValue();
        goto L17
    }

    private void setKeyguardState(int lockTaskModeState, int userId) {
        this.mPendingDisableFromDismiss = ProcessList.INVALID_ADJ;
        if (lockTaskModeState != 0) goto L6;
        this.mWindowManager.reenableKeyguard(this.mToken, userId);
        return;
    L6:
        if (lockTaskModeState == 1) goto L8;
        this.mWindowManager.disableKeyguard(this.mToken, LOCK_TASK_TAG, userId);
        return;
    L8:
        if (isKeyguardAllowed(userId) == false) goto L11;
        this.mWindowManager.reenableKeyguard(this.mToken, userId);
        return;
    L11:
        if (this.mWindowManager.isKeyguardLocked() == true) goto L13;
    L15:
        this.mWindowManager.disableKeyguard(this.mToken, LOCK_TASK_TAG, userId);
        return;
    L13:
        if (this.mWindowManager.isKeyguardSecure(userId) == true) goto L15;
        this.mPendingDisableFromDismiss = userId;
        this.mWindowManager.dismissKeyguard(new AnonymousClass1(this, userId), null);
    }

    private void lockKeyguardIfNeeded(int userId) {
        if (shouldLockKeyguard(userId) == false) goto L6;
        this.mWindowManager.lockNow(null);
        this.mWindowManager.dismissKeyguard(null, null);
        getLockPatternUtils().requireCredentialEntry(-1);
        return;
    }

    private boolean shouldLockKeyguard(int userId) {
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "lock_to_app_exit_locked", -2) == 0) goto L5;
        return true;
    L5:
        return false;
    L8:
        EventLog.writeEvent(1397638484, new Object[]{"127605586", -1, ""});
        return getLockPatternUtils().isSecure(userId);
    }

    Pair<Integer, Integer> getStatusBarDisableFlags(int lockTaskFlags) {
        int flags1 = 134152192;
        int flags2 = 31;
        int i = STATUS_BAR_FLAG_MAP_LOCKED.size() - 1;
    L3:
        if (i < 0) goto L9;
        Pair<Integer, Integer> statusBarFlags = STATUS_BAR_FLAG_MAP_LOCKED.valueAt(i);
        if ((STATUS_BAR_FLAG_MAP_LOCKED.keyAt(i) & lockTaskFlags) == 0) goto L7;
        flags1 = flags1 & (~((Integer) statusBarFlags.first).intValue());
        flags2 = flags2 & (~((Integer) statusBarFlags.second).intValue());
    L7:
        i = i - 1;
        goto L3
    L9:
        return new Pair(Integer.valueOf(flags1 & STATUS_BAR_MASK_LOCKED), Integer.valueOf(flags2));
    }

    boolean isBaseOfLockedTask(String packageName) {
        int i = 0;
    L4:
        if (i >= this.mLockTaskModeTasks.size()) goto L10;
        if (packageName.equals(this.mLockTaskModeTasks.get(i).getBasePackageName()) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private int getLockTaskFeaturesForUser(int userId) {
        return this.mLockTaskFeatures.get(userId, 0);
    }

    private IStatusBarService getStatusBarService() {
        if (this.mStatusBarService != null) goto L8;
        this.mStatusBarService = IStatusBarService.Stub.asInterface(ServiceManager.checkService("statusbar"));
        if (this.mStatusBarService != null) goto L8;
        Slog.w("StatusBarManager", "warning: no STATUS_BAR_SERVICE");
    L8:
        return this.mStatusBarService;
    }

    private IDevicePolicyManager getDevicePolicyManager() {
        if (this.mDevicePolicyManager != null) goto L8;
        this.mDevicePolicyManager = IDevicePolicyManager.Stub.asInterface(ServiceManager.checkService("device_policy"));
        if (this.mDevicePolicyManager != null) goto L8;
        Slog.w("ActivityTaskManager", "warning: no DEVICE_POLICY_SERVICE");
    L8:
        return this.mDevicePolicyManager;
    }

    private LockPatternUtils getLockPatternUtils() {
        if (this.mLockPatternUtils != null) goto L7;
        return new LockPatternUtils(this.mContext);
    L7:
        return this.mLockPatternUtils;
    }

    private TelecomManager getTelecomManager() {
        if (this.mTelecomManager != null) goto L7;
        return (TelecomManager) this.mContext.getSystemService(TelecomManager.class);
    L7:
        return this.mTelecomManager;
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "LockTaskController:");
        String prefix2 = prefix + "  ";
        pw.println(prefix2 + "mLockTaskModeState=" + lockTaskModeToString());
        StringBuilder r0 = new StringBuilder();
        r0.append(prefix2);
        r0.append("mLockTaskModeTasks=");
        pw.println(r0.toString());
        int i = 0;
    L4:
        if (i >= this.mLockTaskModeTasks.size()) goto L6;
        pw.println(prefix2 + "  #" + i + " " + this.mLockTaskModeTasks.get(i));
        i = i + 1;
        goto L4
    L6:
        pw.println(prefix2 + "mLockTaskPackages (userId:packages)=");
        int i2 = 0;
    L8:
        if (i2 >= this.mLockTaskPackages.size()) goto L10;
        pw.println(prefix2 + "  u" + this.mLockTaskPackages.keyAt(i2) + ":" + Arrays.toString(this.mLockTaskPackages.valueAt(i2)));
        i2 = i2 + 1;
        goto L8
    L10:
        pw.println();
    }

    private String lockTaskModeToString() {
        switch(this.mLockTaskModeState) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        return "PINNED";
    L8:
        return "LOCKED";
    L10:
        return "NONE";
    L5:
        return "unknown=" + this.mLockTaskModeState;
    }
}
