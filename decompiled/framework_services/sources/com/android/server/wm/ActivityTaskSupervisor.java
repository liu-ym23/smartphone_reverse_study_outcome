package com.android.server.wm;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.AppOpsManager;
import android.app.AppOpsManagerInternal;
import android.app.IActivityClientController;
import android.app.IApplicationThread;
import android.app.ProfilerInfo;
import android.app.SysMonitorFwBridge;
import android.app.TaskInfo;
import android.app.WaitResult;
import android.app.servertransaction.ClientTransactionItem;
import android.app.servertransaction.LaunchActivityItem;
import android.app.servertransaction.PauseActivityItem;
import android.app.servertransaction.ResumeActivityItem;
import android.app.servertransaction.StopActivityItem;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.hardware.SensorPrivacyManagerInternal;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.WorkSource;
import android.pico.utils.ExtImplFactory;
import android.pico.utils.Features;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.BoostFramework;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.webkit.URLUtil;
import android.window.ActivityWindowInfo;
import android.window.DesktopExperienceFlags;
import android.window.DesktopModeFlags;
import android.window.RemoteTransition;
import bytedanceos.util.FeatLog;
import com.android.internal.content.ReferrerIntent;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.BaseZswSystemServiceFactory;
import com.android.server.ISmtResourceControl;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.am.AppTimeTracker;
import com.android.server.am.HostingRecord;
import com.android.server.am.ProcessFreezerManager;
import com.android.server.am.UserState;
import com.android.server.companion.virtual.VirtualDeviceManagerInternal;
import com.android.server.pm.SaferIntentUtils;
import com.android.server.resmng.IResMngConfig;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.Slogf;
import com.zte.performance.mindsync.MindSyncManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Predicate;
import vendor.qti.hardware.servicetracker.V1_2.IServicetracker;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityTaskSupervisor implements RecentTasks.Callbacks {
    private static final ArrayMap<String, String> ACTION_TO_RUNTIME_PERMISSION = null;
    private static final int ACTIVITY_RESTRICTION_APPOP = 2;
    private static final int ACTIVITY_RESTRICTION_NONE = 0;
    private static final int ACTIVITY_RESTRICTION_PERMISSION = 1;
    static final boolean DEFER_RESUME = true;
    private static final int IDLE_NOW_DELAY_WHILE_SLEEPING_MS = 100;
    private static final int IDLE_NOW_MSG = 201;
    private static final int IDLE_TIMEOUT = 0;
    private static final int IDLE_TIMEOUT_MSG = 200;
    private static final int KILL_TASK_PROCESSES_TIMEOUT_MS = 1000;
    private static final int KILL_TASK_PROCESSES_TIMEOUT_MSG = 206;
    private static final int LAUNCH_TASK_BEHIND_COMPLETE = 212;
    private static final int LAUNCH_TIMEOUT = 0;
    private static final int LAUNCH_TIMEOUT_MSG = 204;
    private static final int MAX_TASK_IDS_PER_USER = 100000;
    static final boolean ON_TOP = true;
    static final boolean PRESERVE_WINDOWS = true;
    private static final int PROCESS_STOPPING_AND_FINISHING_MSG = 205;
    static final boolean REMOVE_FROM_RECENTS = true;
    private static final int REPORT_MULTI_WINDOW_MODE_CHANGED_MSG = 214;
    private static final int REPORT_PIP_MODE_CHANGED_MSG = 215;
    private static final int RESTART_ACTIVITY_PROCESS_TIMEOUT_MSG = 213;
    private static final int RESUME_TOP_ACTIVITY_MSG = 202;
    private static final int SLEEP_TIMEOUT = 0;
    private static final int SLEEP_TIMEOUT_MSG = 203;
    private static final int START_HOME_MSG = 216;
    private static final String TAG = "ActivityTaskManager";
    private static final String TAG_IDLE = "ActivityTaskManager";
    private static final String TAG_PAUSE = "ActivityTaskManager";
    private static final String TAG_RECENTS = "ActivityTaskManager";
    private static final String TAG_ROOT_TASK = "ActivityTaskManager";
    private static final String TAG_SWITCH = "ActivityTaskManager";
    static final String TAG_TASKS = "ActivityTaskManager";
    private static final int TOP_RESUMED_STATE_LOSS_TIMEOUT = 500;
    private static final int TOP_RESUMED_STATE_LOSS_TIMEOUT_MSG = 217;
    private static final boolean VALIDATE_WAKE_LOCK_CALLER = false;
    public static boolean mIsPerfBoostAcquired;
    public static int mPerfHandle;
    public static boolean mPerfSendTapHint;
    private ActivityMetricsLogger mActivityMetricsLogger;
    private final ArrayList<WindowProcessController> mActivityStateChangedProcs;
    ActivityTaskSupervisorZteHook mActivityTaskSupervisorZteHook;
    private AppOpsManager mAppOpsManager;
    boolean mAppVisibilitiesChangedSinceLastPause;
    BackgroundActivityStartController mBalController;
    private final SparseIntArray mCurTaskIdForUser;
    private int mDeferResumeCount;
    private boolean mDeferRootVisibilityUpdate;
    private IExtActivityTaskSupervisor mExt;
    final ArrayList<ActivityRecord> mFinishingActivities;
    PowerManager.WakeLock mGoingToSleepWakeLock;
    private final ActivityTaskSupervisorHandler mHandler;
    private boolean mInitialized;
    public boolean mIsRecents;
    private KeyguardController mKeyguardController;
    private ActivityRecord mLastReportedTopResumedActivity;
    private LaunchParamsController mLaunchParamsController;
    LaunchParamsPersister mLaunchParamsPersister;
    PowerManager.WakeLock mLaunchingActivityWakeLock;
    final Looper mLooper;
    private final ArrayList<ActivityRecord> mMultiWindowModeChangedActivities;
    final ArrayList<ActivityRecord> mNoAnimActivities;
    final ArrayList<ActivityRecord> mNoHistoryActivities;
    final OpaqueContainerHelper mOpaqueContainerHelper;
    public BoostFramework mPerfBoost;
    PersisterQueue mPersisterQueue;
    private final ArrayList<ActivityRecord> mPipModeChangedActivities;
    private Rect mPipModeChangedTargetRootTaskBounds;
    private PowerManager mPowerManager;
    private ActivityRecord mPrimaryDisplayLastRecord;
    RecentTasks mRecentTasks;
    public RootWindowContainer mRootWindowContainer;
    private RunningTasks mRunningTasks;
    final ActivityTaskManagerService mService;
    private IServicetracker mServicetracker;
    final ArrayList<UserState> mStartingUsers;
    final ArrayList<ActivityRecord> mStoppingActivities;
    private ComponentName mSystemChooserActivity;
    final TaskInfoHelper mTaskInfoHelper;
    private ActivityRecord mTopResumedActivity;
    private boolean mTopResumedActivityWaitingForPrev;
    boolean mUserLeaving;
    public BoostFramework mUxPerf;
    private VirtualDeviceManagerInternal mVirtualDeviceManagerInternal;
    private int mVisibilityTransactionDepth;
    private final ArrayList<WaitInfo> mWaitingActivityLaunched;
    private WindowManagerService mWindowManager;
    IZswActivityTaskSupervisor mZswExt;

    private final class ActivityTaskSupervisorHandler extends Handler {
        final /* synthetic */ ActivityTaskSupervisor this$0;

        ActivityTaskSupervisorHandler(ActivityTaskSupervisor r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            WindowManagerGlobalLock r0 = this.this$0.mService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L9:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (handleMessageInner(msg) == false) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            switch(msg.what) {
                case 213: goto L15;
                default: goto L39;
            };
        L15:
            ActivityRecord r = (ActivityRecord) msg.obj;
            String processName = null;
            int uid = 0;
            WindowManagerGlobalLock r3 = this.this$0.mService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r3);
        L22:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L18:
            if (r.attachedToProcess() == true) goto L20;
        L24:
            monitor-exit(r3);     // Catch: Throwable -> L22
            WindowManagerService.resetPriorityAfterLockedSection();
            if (processName == null) goto L38;
            this.this$0.mService.mAmInternal.killProcess(processName, uid, "restartActivityProcessTimeout");
            return;
        L38:
            return;
        L20:
            if (r.isState(ActivityRecord.State.RESTARTING_PROCESS) == false) goto L24;
            processName = r.app.mName;     // Catch: Throwable -> L22
            uid = r.app.mUid;     // Catch: Throwable -> L22
            goto L24
        }

        private void activityIdleFromMessage(ActivityRecord idleActivity, boolean fromTimeout) {
            this.this$0.activityIdleInternal(idleActivity, fromTimeout, fromTimeout, null);
        }

        private boolean handleMessageInner(Message msg) {
            switch(msg.what) {
                case 200: goto L38;
                case 201: goto L34;
                case 202: goto L32;
                case 203: goto L30;
                case 204: goto L27;
                case 205: goto L25;
                case 206: goto L19;
                case 207: goto L4;
                case 208: goto L4;
                case 209: goto L4;
                case 210: goto L4;
                case 211: goto L4;
                case 212: goto L15;
                case 213: goto L4;
                case 214: goto L11;
                case 215: goto L7;
                case 216: goto L6;
                case 217: goto L5;
                default: goto L4;
            };
        L4:
            return false;
        L5:
            Slog.w("ActivityTaskManager", "Activity top resumed state loss timeout for " + ((ActivityRecord) msg.obj));
            this.this$0.handleTopResumedStateReleased(true);
        L41:
            return true;
        L6:
            ActivityTaskSupervisor.m9695$$Nest$fgetmHandler(this.this$0).removeMessages(216);
            this.this$0.mRootWindowContainer.startHomeOnEmptyDisplays((String) msg.obj);
            goto L41
        L7:
            int i = ActivityTaskSupervisor.m9697$$Nest$fgetmPipModeChangedActivities(this.this$0).size() - 1;
        L8:
            if (i < 0) goto L41;
            ((ActivityRecord) ActivityTaskSupervisor.m9697$$Nest$fgetmPipModeChangedActivities(this.this$0).remove(i)).updatePictureInPictureMode(ActivityTaskSupervisor.m9698$$Nest$fgetmPipModeChangedTargetRootTaskBounds(this.this$0), false);
            i = i - 1;
            goto L8
        L11:
            int i2 = ActivityTaskSupervisor.m9696$$Nest$fgetmMultiWindowModeChangedActivities(this.this$0).size() - 1;
        L12:
            if (i2 < 0) goto L41;
            ((ActivityRecord) ActivityTaskSupervisor.m9696$$Nest$fgetmMultiWindowModeChangedActivities(this.this$0).remove(i2)).updateMultiWindowMode();
            i2 = i2 - 1;
            goto L12
        L15:
            ActivityRecord r = ActivityRecord.forTokenLocked((IBinder) msg.obj);
            if (r == null) goto L41;
            ActivityTaskSupervisor.m9699$$Nest$mhandleLaunchTaskBehindCompleteLocked(this.this$0, r);
            goto L41
        L19:
            Task task = (Task) msg.obj;
            if (task.mKillProcessesOnDestroyed == false) goto L41;
            if (task.hasActivity() == false) goto L41;
            Slog.i("ActivityTaskManager", "Destroy timeout of remove-task, attempt to kill " + task);
            ActivityTaskSupervisor.m9700$$Nest$mkillTaskProcessesIfPossible(this.this$0, task);
            goto L41
        L25:
            this.this$0.processStoppingAndFinishingActivities(null, false, "transit");
            goto L41
        L32:
            this.this$0.mRootWindowContainer.resumeFocusedTasksTopActivities();
            goto L41
        L27:
            if (this.this$0.mLaunchingActivityWakeLock.isHeld() == false) goto L41;
            Slog.w("ActivityTaskManager", "Launch timeout has expired, giving up wake lock!");
            this.this$0.mLaunchingActivityWakeLock.release();
            goto L41
        L30:
            if (this.this$0.mService.isSleepingOrShuttingDownLocked() == false) goto L41;
            Slog.w("ActivityTaskManager", "Sleep timeout!  Sleeping now.");
            this.this$0.checkReadyForSleepLocked(false);
            goto L41
        L34:
            if (ActivityTaskManagerDebugConfig.DEBUG_IDLE == false) goto L36;
            Slog.d("ActivityTaskManager", "handleMessage: IDLE_NOW_MSG: r=" + msg.obj);
        L36:
            activityIdleFromMessage((ActivityRecord) msg.obj, false);
            goto L41
        L38:
            if (ActivityTaskManagerDebugConfig.DEBUG_IDLE == false) goto L40;
            Slog.d("ActivityTaskManager", "handleMessage: IDLE_TIMEOUT_MSG: r=" + msg.obj);
        L40:
            activityIdleFromMessage((ActivityRecord) msg.obj, true);
            goto L41
        }
    }

    static class OpaqueContainerHelper implements Predicate<ActivityRecord> {
        private final boolean mEnableMultipleDesktopsBackend;
        private boolean mIgnoringInvisibleActivity;
        private boolean mIgnoringKeyguard;
        private ActivityRecord mStarting;

        public static /* synthetic */ boolean $r8$lambda$6f0G5pcQtnjw__iU8ofU_Zna2Gs(OpaqueContainerHelper r0, TaskFragment r1) {
            return r0.lambda$isOpaqueInner$0(r1);
        }

        OpaqueContainerHelper() {
            this.mEnableMultipleDesktopsBackend = DesktopExperienceFlags.ENABLE_MULTIPLE_DESKTOPS_BACKEND.isTrue();
        }

        @Override // java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(ActivityRecord r1) {
            return test2(r1);
        }

        boolean isOpaque(WindowContainer<?> container) {
            return isOpaque(container, null, true, false);
        }

        boolean isOpaque(WindowContainer<?> container, ActivityRecord starting, boolean ignoringKeyguard, boolean ignoringInvisibleActivity) {
            this.mStarting = starting;
            this.mIgnoringInvisibleActivity = ignoringInvisibleActivity;
            this.mIgnoringKeyguard = ignoringKeyguard;
            if (this.mEnableMultipleDesktopsBackend == true) goto L9;
            boolean isOpaque = true;
            if (container.getActivity(this, true, null) != null) goto L10;
            isOpaque = false;
        L10:
            this.mStarting = null;
            return isOpaque;
        L9:
            isOpaque = isOpaqueInner(container);
            goto L10
        }

        private boolean isOpaqueInner(WindowContainer<?> container) {
            if (container.asActivityRecord() == null) goto L5;
            boolean isActivity = true;
        L7:
            if (container.asTaskFragment() != null) goto L9;
        L11:
            boolean isLeafTaskFragment = false;
        L13:
            if (isActivity == true) goto L42;
            if (isLeafTaskFragment == true) goto L42;
            int i = 0;
        L18:
            if (i >= container.getChildCount()) goto L40;
            WindowContainer<?> child = container.getChildAt(i);
            if (child.fillsParent() == false) goto L25;
            if (isOpaque(child) == false) goto L25;
            return true;
        L25:
            if (child.asTaskFragment() == null) goto L38;
            if (child.asTaskFragment().hasAdjacentTaskFragment() == false) goto L38;
            if (isOpaque(child) == true) goto L31;
        L34:
            boolean isAnyTranslucent = true;
        L36:
            if (isAnyTranslucent == true) goto L38;
            return true;
        L31:
            if (child.asTaskFragment().forOtherAdjacentTaskFragments(new ActivityTaskSupervisor$OpaqueContainerHelper$$ExternalSyntheticLambda0(this)) == true) goto L34;
            isAnyTranslucent = false;
        L38:
            i = i + 1;
            goto L18
        L40:
            return false;
        L42:
            if (container.getActivity(this, true, null) != null) goto L44;
            return false;
        L44:
            return true;
        L9:
            if (((TaskFragment) container).isLeafTaskFragment() == false) goto L11;
            isLeafTaskFragment = true;
            goto L13
        L5:
            isActivity = false;
            goto L7
        }

        private /* synthetic */ boolean lambda$isOpaqueInner$0(TaskFragment tf) {
            return !isOpaque(tf);
        }

        /* JADX INFO: renamed from: test, reason: avoid collision after fix types in other method */
        public boolean test2(ActivityRecord r) {
            if (this.mIgnoringInvisibleActivity == false) goto L17;
            if (r == this.mStarting) goto L17;
            if (this.mIgnoringKeyguard == false) goto L11;
            if (r.visibleIgnoringKeyguard == true) goto L11;
            return false;
        L11:
            if (this.mIgnoringKeyguard == true) goto L17;
            if (r.isVisible() == true) goto L17;
            return false;
        L17:
            return r.occludesParent(!this.mIgnoringInvisibleActivity);
        }
    }

    class PreferredAppsTask extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ ActivityTaskSupervisor this$0;

        PreferredAppsTask(ActivityTaskSupervisor this$0) {
            this.this$0 = this$0;
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Void... params) {
            new Intent("android.intent.action.MAIN");
            int trimLevel = ActivityManager.getService().getMemoryTrimLevel();     // Catch: RemoteException -> L20
            if (this.this$0.mUxPerf != null) goto L7;
        L19:
            return null;
        L7:
            if (trimLevel >= 3) goto L19;
            if (this.this$0.mUxPerf.board_first_api_lvl < 33) goto L11;
        L13:
            String res = this.this$0.mUxPerf.perfSyncRequest(5636);
        L14:
            if (res != null) goto L16;
            return null;
        L16:
            String[] p_apps = res.trim().split(SliceClientPermissions.SliceAuthority.DELIMITER);
            if (p_apps.length == 0) goto L19;
            ArrayList<String> apps_l = new ArrayList(Arrays.asList(p_apps));
            Bundle bParams = new Bundle();
            bParams.putStringArrayList("start_empty_apps", apps_l);
            Slog.i("ActivityTaskManager", "start preferred apps:" + Arrays.toString(p_apps));
            Message msg = PooledLambda.obtainMessage(new ActivityTaskSupervisor$PreferredAppsTask$$ExternalSyntheticLambda0(), this.this$0.mService.mAmInternal, bParams);
            this.this$0.mService.mH.sendMessage(msg);
            goto L19
        L11:
            if (this.this$0.mUxPerf.board_api_lvl >= 33) goto L13;
            res = this.this$0.mUxPerf.perfUXEngine_trigger(1);
        L21:
            return null;
        }
    }

    static class TaskInfoHelper implements Consumer<ActivityRecord> {
        private TaskInfo mInfo;
        private ActivityRecord mTopRunning;

        TaskInfoHelper() {
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(ActivityRecord r1) {
            accept2(r1);
        }

        ActivityRecord fillAndReturnTop(Task task, TaskInfo info) {
            info.numActivities = 0;
            info.baseActivity = null;
            info.capturedLink = null;
            info.capturedLinkTimestamp = 0;
            this.mInfo = info;
            task.forAllActivities(this);
            ActivityRecord top = this.mTopRunning;
            this.mTopRunning = null;
            this.mInfo = null;
            return top;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(ActivityRecord r) {
            if (DesktopModeFlags.ENABLE_DESKTOP_WINDOWING_APP_TO_WEB.isTrue() == false) goto L8;
            if (this.mInfo.capturedLink != null) goto L8;
            setCapturedLink(r);
        L8:
            if (r.mLaunchCookie == null) goto L11;
            this.mInfo.addLaunchCookie(r.mLaunchCookie);
        L11:
            if (r.finishing == false) goto L13;
            return;
        L13:
            this.mInfo.numActivities++;
            this.mInfo.baseActivity = r.mActivityComponent;
            if (this.mTopRunning != null) goto L17;
            this.mTopRunning = r;
            return;
        }

        private void setCapturedLink(ActivityRecord r) {
            Uri uri = r.intent.getData();
            if (uri != null) goto L5;
            return;
        L5:
            if ("android.intent.action.VIEW".equals(r.intent.getAction()) == true) goto L7;
            return;
        L7:
            if (URLUtil.isNetworkUrl(uri.toString()) == false) goto L13;
            this.mInfo.capturedLink = uri;
            TaskInfo r1 = this.mInfo;
            r1.capturedLinkTimestamp = r.lastLaunchTime;
            return;
        }
    }

    private static class WaitInfo {
        final ActivityMetricsLogger.LaunchingState mLaunchingState;
        final WaitResult mResult;
        final ComponentName mTargetComponent;

        WaitInfo(WaitResult result, ComponentName component, ActivityMetricsLogger.LaunchingState launchingState) {
            this.mResult = result;
            this.mTargetComponent = component;
            this.mLaunchingState = launchingState;
        }

        boolean matches(ActivityRecord r) {
            if (this.mLaunchingState.hasActiveTransitionInfo() == true) goto L7;
            return this.mTargetComponent.equals(r.mActivityComponent);
        L7:
            return this.mLaunchingState.contains(r);
        }

        void dump(PrintWriter pw, String prefix) {
            pw.println(prefix + "WaitInfo:");
            pw.println(prefix + "  mTargetComponent=" + this.mTargetComponent);
            StringBuilder r0 = new StringBuilder();
            r0.append(prefix);
            r0.append("  mResult=");
            pw.println(r0.toString());
            this.mResult.dump(pw, prefix + "    ");
        }
    }

    public static /* synthetic */ void $r8$lambda$0nwYAIgJGpXsSurCrDJamKnBSvM(ActivityTaskSupervisor r0, ActivityRecord r1) {
        r0.lambda$scheduleUpdateMultiWindowMode$6(r1);
    }

    public static /* synthetic */ void $r8$lambda$8JNEn2HsyBxbswUg69qDznD0MnI(ArrayList r0, ActivityRecord r1) {
        lambda$canPlaceEntityOnDisplay$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$FuSpadUBwhEPuGrZyJFsb6EBdhs(ActivityTaskSupervisor r0, ActivityInfo r1, int r2, ProfilerInfo r3) {
        r0.lambda$resolveActivity$1(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$GJVflDWRsmuCmEYdBDxnsjMRK48(ActivityTaskSupervisor r0, Task r1) {
        r0.lambda$removeRootTask$4(r1);
    }

    public static /* synthetic */ void $r8$lambda$JQMz1DL_AdwROWfyaZwHgBCDtrA(ActivityTaskSupervisor r0, ActivityRecord r1) {
        r0.lambda$scheduleUpdatePictureInPictureModeIfNeeded$7(r1);
    }

    public static /* synthetic */ void $r8$lambda$MNDKuj5jNebDBzFF6mxBNFmhpRQ(int[] r0, ActivityRecord r1) {
        lambda$killTaskProcessesOnDestroyedIfNeeded$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$XoUVppjLXzbYGJ_0Vm-FjpgSIoQ, reason: not valid java name */
    public static /* synthetic */ void m9693$r8$lambda$XoUVppjLXzbYGJ_0VmFjpgSIoQ(ActivityTaskSupervisor r0, ActivityRecord r1, boolean r2, boolean r3) {
        r0.lambda$startSpecificActivity$2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$rRK-INBLD7iinr4rzHOKtMW39BA, reason: not valid java name */
    public static /* synthetic */ void m9694$r8$lambda$rRKINBLD7iinr4rzHOKtMW39BA(ActivityTaskSupervisor r0) {
        r0.lambda$activityIdleInternal$3();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskSupervisorHandler m9695$$Nest$fgetmHandler(ActivityTaskSupervisor r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMultiWindowModeChangedActivities, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m9696$$Nest$fgetmMultiWindowModeChangedActivities(ActivityTaskSupervisor r0) {
        return r0.mMultiWindowModeChangedActivities;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPipModeChangedActivities, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m9697$$Nest$fgetmPipModeChangedActivities(ActivityTaskSupervisor r0) {
        return r0.mPipModeChangedActivities;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPipModeChangedTargetRootTaskBounds, reason: not valid java name */
    static /* bridge */ /* synthetic */ Rect m9698$$Nest$fgetmPipModeChangedTargetRootTaskBounds(ActivityTaskSupervisor r0) {
        return r0.mPipModeChangedTargetRootTaskBounds;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleLaunchTaskBehindCompleteLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9699$$Nest$mhandleLaunchTaskBehindCompleteLocked(ActivityTaskSupervisor r0, ActivityRecord r1) {
        r0.handleLaunchTaskBehindCompleteLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mkillTaskProcessesIfPossible, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9700$$Nest$mkillTaskProcessesIfPossible(ActivityTaskSupervisor r0, Task r1) {
        r0.killTaskProcessesIfPossible(r1);
    }

    static {
        IDLE_TIMEOUT = Build.HW_TIMEOUT_MULTIPLIER * 10000;
        SLEEP_TIMEOUT = Build.HW_TIMEOUT_MULTIPLIER * 5000;
        LAUNCH_TIMEOUT = Build.HW_TIMEOUT_MULTIPLIER * 10000;
        mPerfSendTapHint = false;
        mIsPerfBoostAcquired = false;
        mPerfHandle = -1;
        ACTION_TO_RUNTIME_PERMISSION = new ArrayMap();
        ACTION_TO_RUNTIME_PERMISSION.put("android.media.action.IMAGE_CAPTURE", "android.permission.CAMERA");
        ACTION_TO_RUNTIME_PERMISSION.put("android.provider.action.MOTION_PHOTO_CAPTURE", "android.permission.CAMERA");
        ACTION_TO_RUNTIME_PERMISSION.put("android.media.action.VIDEO_CAPTURE", "android.permission.CAMERA");
        ACTION_TO_RUNTIME_PERMISSION.put("android.intent.action.CALL", "android.permission.CALL_PHONE");
    }

    boolean canPlaceEntityOnDisplay(int displayId, int callingPid, int callingUid, ActivityInfo activityInfo) {
        return canPlaceEntityOnDisplay(displayId, callingPid, callingUid, null, activityInfo);
    }

    boolean canPlaceEntityOnDisplay(int displayId, int callingPid, int callingUid, Task task) {
        return canPlaceEntityOnDisplay(displayId, callingPid, callingUid, task, null);
    }

    private boolean canPlaceEntityOnDisplay(int displayId, int callingPid, int callingUid, Task task, ActivityInfo activityInfo) {
        if (displayId != 0) goto L6;
        return true;
    L6:
        if (this.mService.mSupportsMultiDisplay == true) goto L9;
        return false;
    L9:
        if (isCallerAllowedToLaunchOnDisplay(callingPid, callingUid, displayId, activityInfo) == true) goto L11;
        return false;
    L11:
        DisplayContent displayContent = this.mRootWindowContainer.getDisplayContentOrCreate(displayId);
        if (displayContent == null) goto L20;
        final ArrayList<ActivityInfo> activities = new ArrayList();
        if (activityInfo == null) goto L16;
        activities.add(activityInfo);
    L16:
        if (task == null) goto L19;
        task.forAllActivities(new ActivityTaskSupervisor$$ExternalSyntheticLambda4(activities));
    L19:
        return displayContent.mDwpcHelper.canContainActivities(activities, displayContent.getWindowingMode());
    L20:
        return true;
    }

    private static /* synthetic */ void lambda$canPlaceEntityOnDisplay$0(ArrayList activities, ActivityRecord r) {
        activities.add(r.info);
    }

    public ActivityTaskSupervisor(ActivityTaskManagerService service, Looper looper) {
        this.mPerfBoost = new BoostFramework();
        this.mUxPerf = new BoostFramework();
        this.mTaskInfoHelper = new TaskInfoHelper();
        this.mOpaqueContainerHelper = new OpaqueContainerHelper();
        this.mActivityStateChangedProcs = new ArrayList();
        this.mCurTaskIdForUser = new SparseIntArray(20);
        this.mWaitingActivityLaunched = new ArrayList();
        this.mStoppingActivities = new ArrayList();
        this.mFinishingActivities = new ArrayList();
        this.mNoHistoryActivities = new ArrayList();
        this.mMultiWindowModeChangedActivities = new ArrayList();
        this.mPipModeChangedActivities = new ArrayList();
        this.mNoAnimActivities = new ArrayList();
        this.mStartingUsers = new ArrayList();
        this.mUserLeaving = false;
        this.mPrimaryDisplayLastRecord = null;
        this.mExt = (IExtActivityTaskSupervisor) ExtImplFactory.getImpl(IExtActivityTaskSupervisor.class, new Object[]{this});
        this.mService = service;
        this.mLooper = looper;
        this.mHandler = new ActivityTaskSupervisorHandler(this, looper);
        this.mActivityTaskSupervisorZteHook = new ActivityTaskSupervisorZteHook(this, this.mHandler);
        this.mZswExt = BaseZswSystemServiceFactory.getZswSystemServiceFactoryImpl().createZswActivityTaskSupervisor();
    }

    public void initialize() {
        if (this.mInitialized == false) goto L5;
        return;
    L5:
        this.mInitialized = true;
        setRunningTasks(new RunningTasks());
        this.mActivityMetricsLogger = new ActivityMetricsLogger(this, this.mHandler.getLooper());
        this.mKeyguardController = new KeyguardController(this.mService, this);
        this.mPersisterQueue = new PersisterQueue();
        this.mLaunchParamsPersister = new LaunchParamsPersister(this.mPersisterQueue, this);
        this.mLaunchParamsController = new LaunchParamsController(this.mService, this.mLaunchParamsPersister);
        this.mLaunchParamsController.registerDefaultModifiers(this);
        this.mBalController = new BackgroundActivityStartController(this.mService, this);
    }

    void onSystemReady() {
        this.mLaunchParamsPersister.onSystemReady();
    }

    public IServicetracker getServicetrackerInstance() {
        if (this.mServicetracker != null) goto L18;
        this.mServicetracker = IServicetracker.getService(false);     // Catch: RemoteException -> L7 NoSuchElementException -> L9
    L7:
        e = move-exception;
        Slog.e("ActivityTaskManager", "Failed to get servicetracker interface", e);
        return null;
    L14:
        if (this.mServicetracker != null) goto L18;
        Slog.w("ActivityTaskManager", "servicetracker HIDL not available");
        return null;
    L18:
        return this.mServicetracker;
    }

    public void destroyServicetrackerInstance() {
        this.mServicetracker = null;
    }

    void onUserUnlocked(int userId) {
        this.mPersisterQueue.startPersisting();
        this.mLaunchParamsPersister.onUnlockUser(userId);
        scheduleStartHome("userUnlocked");
    }

    public ActivityMetricsLogger getActivityMetricsLogger() {
        return this.mActivityMetricsLogger;
    }

    public KeyguardController getKeyguardController() {
        return this.mKeyguardController;
    }

    ComponentName getSystemChooserActivity() {
        if (this.mSystemChooserActivity != null) goto L6;
        this.mSystemChooserActivity = ComponentName.unflattenFromString(this.mService.mContext.getResources().getString(R.string.config_defaultProfcollectReportUploaderAction));
    L6:
        return this.mSystemChooserActivity;
    }

    void setRecentTasks(RecentTasks recentTasks) {
        if (this.mRecentTasks == null) goto L5;
        this.mRecentTasks.unregisterCallback(this);
    L5:
        this.mRecentTasks = recentTasks;
        this.mRecentTasks.registerCallback(this);
    }

    void setRunningTasks(RunningTasks runningTasks) {
        this.mRunningTasks = runningTasks;
    }

    RunningTasks getRunningTasks() {
        return this.mRunningTasks;
    }

    void initPowerManagement() {
        this.mPowerManager = (PowerManager) this.mService.mContext.getSystemService(PowerManager.class);
        this.mGoingToSleepWakeLock = this.mPowerManager.newWakeLock(1, "ActivityManager-Sleep");
        this.mLaunchingActivityWakeLock = this.mPowerManager.newWakeLock(1, "*launch*");
        this.mLaunchingActivityWakeLock.setReferenceCounted(false);
    }

    void setWindowManager(WindowManagerService wm) {
        this.mWindowManager = wm;
        getKeyguardController().setWindowManager(wm);
    }

    void moveRecentsRootTaskToFront(String reason) {
        Task recentsRootTask = this.mRootWindowContainer.getDefaultTaskDisplayArea().getRootTask(0, 3);
        if (recentsRootTask == null) goto L6;
        recentsRootTask.moveToFront(reason);
        return;
    }

    void setNextTaskIdForUser(int taskId, int userId) {
        int currentTaskId = this.mCurTaskIdForUser.get(userId, -1);
        if (taskId <= currentTaskId) goto L6;
        this.mCurTaskIdForUser.put(userId, taskId);
        return;
    }

    void finishNoHistoryActivitiesIfNeeded(ActivityRecord next) {
        int i = this.mNoHistoryActivities.size() - 1;
    L3:
        if (i < 0) goto L17;
        ActivityRecord noHistoryActivity = this.mNoHistoryActivities.get(i);
        if (noHistoryActivity.finishing == true) goto L15;
        if (noHistoryActivity == next) goto L15;
        if (next.occludesParent() == false) goto L15;
        if (noHistoryActivity.getDisplayId() != next.getDisplayId()) goto L15;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[0] == false) goto L14;
        String protoLogParam0 = String.valueOf(noHistoryActivity);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_STATES, 7803197981786977817L, 0, new Object[]{protoLogParam0});
    L14:
        noHistoryActivity.finishIfPossible("resume-no-history", false);
        this.mNoHistoryActivities.remove(noHistoryActivity);
    L15:
        i = i - 1;
        goto L3
    }

    private static int nextTaskIdForUser(int taskId, int userId) {
        int nextTaskId = taskId + 1;
        if (nextTaskId == ((userId + 1) * 100000)) goto L5;
        return nextTaskId;
    L5:
        return nextTaskId - 100000;
    }

    int getNextTaskIdForUser() {
        return getNextTaskIdForUser(this.mRootWindowContainer.mCurrentUser);
    }

    int getNextTaskIdForUser(int userId) {
        int currentTaskId = this.mCurTaskIdForUser.get(userId, 100000 * userId);
        int candidateTaskId = nextTaskIdForUser(currentTaskId, userId);
    L4:
        if (this.mRecentTasks.containsTaskId(candidateTaskId, userId) == false) goto L6;
    L10:
        candidateTaskId = nextTaskIdForUser(candidateTaskId, userId);
        if (candidateTaskId != currentTaskId) goto L4;
        throw new IllegalStateException("Cannot get an available task id. Reached limit of 100000 running tasks per user.");
    L6:
        if (this.mRootWindowContainer.anyTaskForId(candidateTaskId, 1) != null) goto L10;
        this.mCurTaskIdForUser.put(userId, candidateTaskId);
        return candidateTaskId;
    }

    void waitActivityVisibleOrLaunched(WaitResult w, ActivityRecord r, ActivityMetricsLogger.LaunchingState launchingState) {
        if (w.result != 2) goto L5;
    L7:
        WaitInfo waitInfo = new WaitInfo(w, r.mActivityComponent, launchingState);
        this.mWaitingActivityLaunched.add(waitInfo);
    L14:
        this.mService.mGlobalLock.wait();     // Catch: InterruptedException -> L10
    L12:
        if (this.mWaitingActivityLaunched.contains(waitInfo) == true) goto L14;
        return;
    L5:
        if (w.result == 0) goto L7;
    }

    void cleanupActivity(ActivityRecord r) {
        this.mFinishingActivities.remove(r);
        stopWaitingForActivityVisible(r);
    }

    void stopWaitingForActivityVisible(ActivityRecord r) {
        reportActivityLaunched(false, r, -1, 0);
    }

    void reportActivityLaunched(boolean timeout, ActivityRecord r, long totalTime, int launchState) {
        boolean changed = false;
        int i = this.mWaitingActivityLaunched.size() - 1;
    L3:
        if (i < 0) goto L10;
        WaitInfo info = this.mWaitingActivityLaunched.get(i);
        if (info.matches(r) == false) goto L8;
        WaitResult w = info.mResult;
        w.timeout = timeout;
        w.who = r.mActivityComponent;
        w.totalTime = totalTime;
        w.launchState = launchState;
        this.mWaitingActivityLaunched.remove(i);
        changed = true;
    L8:
        i = i - 1;
        goto L3
    L10:
        if (changed == false) goto L16;
        this.mService.mGlobalLock.notifyAll();
        return;
    }

    void reportWaitingActivityLaunchedIfNeeded(ActivityRecord r, int result) {
        if (this.mWaitingActivityLaunched.isEmpty() == false) goto L6;
        return;
    L6:
        if (result != 3) goto L8;
    L10:
        boolean changed = false;
        int i = this.mWaitingActivityLaunched.size() - 1;
    L11:
        if (i < 0) goto L20;
        WaitInfo info = this.mWaitingActivityLaunched.get(i);
        if (info.matches(r) == false) goto L18;
        WaitResult w = info.mResult;
        w.result = result;
        if (result != 3) goto L18;
        w.who = r.mActivityComponent;
        this.mWaitingActivityLaunched.remove(i);
        changed = true;
    L18:
        i = i - 1;
        goto L11
    L20:
        if (changed == false) goto L27;
        this.mService.mGlobalLock.notifyAll();
        return;
    L27:
        return;
    L8:
        if (result == 2) goto L10;
    }

    ActivityInfo resolveActivity(Intent intent, ResolveInfo rInfo, final int startFlags, final ProfilerInfo profilerInfo) {
        if (rInfo == null) goto L4;
        final ActivityInfo aInfo = rInfo.activityInfo;
    L5:
        if (aInfo == null) goto L47;
        intent.setComponent(new ComponentName(aInfo.applicationInfo.packageName, aInfo.name));
        boolean debuggable = false;
        if ((startFlags & 14) == 0) goto L9;
        boolean requestDebug = true;
    L10:
        if (profilerInfo == null) goto L12;
        boolean requestProfile = true;
    L13:
        if (requestDebug == true) goto L16;
        if (requestProfile == true) goto L16;
    L40:
        String intentLaunchToken = intent.getLaunchToken();
        if (aInfo.launchToken != null) goto L47;
        if (intentLaunchToken == null) goto L47;
        aInfo.launchToken = intentLaunchToken;
    L16:
        if (Build.IS_DEBUGGABLE == true) goto L20;
        if ((aInfo.applicationInfo.flags & 2) != 0) goto L20;
    L23:
        if (requestDebug == false) goto L25;
        if (debuggable == true) goto L25;
    L29:
        Slog.w("ActivityTaskManager", "Ignore debugging for non-debuggable app: " + aInfo.packageName);
    L25:
        if (requestProfile == false) goto L30;
        if (debuggable == true) goto L30;
        if (aInfo.applicationInfo.isProfileableByShell() == false) goto L29;
    L30:
        WindowManagerGlobalLock r3 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        this.mService.mH.post(new ActivityTaskSupervisor$$ExternalSyntheticLambda9(this, aInfo, startFlags, profilerInfo));     // Catch: Throwable -> L35
        this.mService.mGlobalLock.wait();     // Catch: Throwable -> L35 InterruptedException -> L37
    L38:
        monitor-exit(r3);     // Catch: Throwable -> L35
        WindowManagerService.resetPriorityAfterLockedSection();
    L35:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L20:
        if (aInfo.processName.equals("system") == true) goto L23;
        debuggable = true;
        goto L23
    L12:
        requestProfile = false;
        goto L13
    L9:
        requestDebug = false;
    L47:
        return aInfo;
    L4:
        aInfo = null;
        goto L5
    }

    private /* synthetic */ void lambda$resolveActivity$1(ActivityInfo aInfo, int startFlags, ProfilerInfo profilerInfo) {
        this.mService.mAmInternal.setDebugFlagsForStartingActivity(aInfo, startFlags, profilerInfo, this.mService.mGlobalLock);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        Slog.w("ActivityTaskManager", e);
        monitor-enter(this.mService.mGlobalLockWithoutBoost);
        this.mService.mGlobalLockWithoutBoost.notifyAll();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    ResolveInfo resolveIntent(Intent intent, String resolvedType, int userId, int flags, int filterCallingUid, int callingPid) {
        Trace.traceBegin(32, "resolveIntent");     // Catch: Throwable -> L9
        int modifiedFlags = (flags | 65536) | 1024;     // Catch: Throwable -> L9
        if (intent.isWebIntent() == false) goto L6;
    L11:
        int modifiedFlags2 = modifiedFlags | 8388608;     // Catch: Throwable -> L9
    L12:
        int privateResolveFlags = 0;
        if (intent.isWebIntent() == false) goto L18;
        if ((intent.getFlags() & 1024) == 0) goto L18;
        privateResolveFlags = 0 | 1;     // Catch: Throwable -> L9
    L18:
        if ((intent.getFlags() & 512) == 0) goto L20;
        int privateResolveFlags2 = privateResolveFlags | 2;     // Catch: Throwable -> L9
    L21:
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
        ResolveInfo r0 = this.mService.getPackageManagerInternalLocked().resolveIntent(intent, resolvedType, modifiedFlags2, privateResolveFlags2, userId, true, filterCallingUid, callingPid);     // Catch: Throwable -> L29
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L27
        Trace.traceEnd(32);
        return r0;
    L27:
        th = th;
    L32:
        Trace.traceEnd(32);
        throw th;
    L29:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L20:
        privateResolveFlags2 = privateResolveFlags;
        goto L21
    L6:
        if ((intent.getFlags() & 2048) != 0) goto L11;
        modifiedFlags2 = modifiedFlags;
    L9:
        th = th;
        goto L32
    }

    public ActivityInfo resolveActivity(Intent intent, String resolvedType, int startFlags, ProfilerInfo profilerInfo, int userId, int filterCallingUid, int callingPid) {
        ResolveInfo rInfo = resolveIntent(intent, resolvedType, userId, 0, filterCallingUid, callingPid);
        return resolveActivity(intent, rInfo, startFlags, profilerInfo);
    }

    boolean realStartActivityLocked(ActivityRecord r, WindowProcessController proc, boolean andResume, boolean checkConfig) throws RemoteException {
        if (this.mRootWindowContainer.allPausedActivitiesComplete() == false) goto L5;
        Task task = r.getTask();
        if (andResume == true) goto L11;
    L20:
        proc.getWPCSmtEx().bringProcessToDefaultLocked();
        Task rootTask = task.getRootTask();
        beginDeferResume();
        proc.pauseConfigurationDispatch();
        r.lastLaunchTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L26
        r.setProcess(proc);     // Catch: Throwable -> L26
        if (andResume == false) goto L28;
        if (r.canResumeByCompat() == true) goto L28;
        boolean andResume2 = false;
    L98:
        r.notifyUnknownVisibilityLaunchedForKeyguardTransition();     // Catch: Throwable -> L32
        if (checkConfig == false) goto L35;
        this.mRootWindowContainer.ensureVisibilityAndConfig(r, r.mDisplayContent, true);     // Catch: Throwable -> L32
    L35:
        if (this.mKeyguardController.checkKeyguardVisibility(r) == false) goto L40;
        if (r.allowMoveToFront() == false) goto L40;
        r.setVisibility(true);     // Catch: Throwable -> L32
    L40:
        if (r.info.applicationInfo == null) goto L42;
        int r1 = r.info.applicationInfo.uid;     // Catch: Throwable -> L32
    L43:
        int applicationInfoUid = r1;
        if (r.mUserId == proc.mUserId) goto L47;
    L48:
        Slog.wtf("ActivityTaskManager", "User ID for activity changing for " + r + " appInfo.uid=" + r.info.applicationInfo.uid + " info.ai.uid=" + applicationInfoUid + " old=" + r.app + " new=" + proc);     // Catch: Throwable -> L32
    L50:
        if (proc.hasEverLaunchedActivity() == false) goto L53;
        ActivityClientController r2 = null;
    L52:
        ActivityClientController r5 = r2;
        r.launchCount++;     // Catch: Throwable -> L32
        if (ActivityTaskManagerDebugConfig.DEBUG_ALL == false) goto L57;
        Slog.v("ActivityTaskManager", "Launching: " + r);     // Catch: Throwable -> L32
    L57:
        LockTaskController lockTaskController = this.mService.getLockTaskController();     // Catch: Throwable -> L32
        if (task.mLockTaskAuth != 2) goto L60;
    L65:
        lockTaskController.startLockTaskMode(task, false, 0);     // Catch: Throwable -> L32
    L66:
        RemoteException e = tryRealStartActivityInner(task, r, proc, r5, andResume2);     // Catch: Throwable -> L32
        if (e != null) goto L69;
        endDeferResume();
        proc.resumeConfigurationDispatch();
        r.launchFailed = false;
        if (andResume2 == false) goto L81;
        if (readyToResume() == false) goto L81;
        r.setState(ActivityRecord.State.RESUMED, "realStartActivityLocked");
        r.completeResumeLocked();
    L87:
        proc.onStartActivity(this.mService.mTopProcessState, r.info);
        if (this.mRootWindowContainer.isTopDisplayFocusedRootTask(rootTask) == false) goto L91;
        this.mService.getActivityStartController().startSetupActivity();
    L91:
        if (r.app == null) goto L93;
        r.app.updateServiceConnectionActivities();
    L93:
        return true;
    L81:
        if (r.isVisibleRequested() == true) goto L83;
        r.setState(ActivityRecord.State.STOPPING, "realStartActivityLocked");
        goto L87
    L83:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L85;
        String protoLogParam0 = String.valueOf(r);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 1045761390992110034L, 0, new Object[]{protoLogParam0});
    L85:
        r.setState(ActivityRecord.State.PAUSED, "realStartActivityLocked");
        this.mRootWindowContainer.executeAppTransitionForAllDisplay();
        goto L87
    L69:
        if (r.launchFailed == false) goto L73;
        Slog.e("ActivityTaskManager", "Second failure launching " + r.intent.getComponent().flattenToShortString() + ", giving up", e);     // Catch: Throwable -> L32
        proc.appDied("2nd-crash");     // Catch: Throwable -> L32
        r.finishIfPossible("2nd-crash", false);     // Catch: Throwable -> L32
        endDeferResume();
        proc.resumeConfigurationDispatch();
        return false;
    L73:
        r.launchFailed = true;     // Catch: Throwable -> L32
        r.detachFromProcess();     // Catch: Throwable -> L32
        throw e;     // Catch: Throwable -> L32
    L60:
        if (task.mLockTaskAuth == 4) goto L65;
        if (task.mLockTaskAuth != 3) goto L66;
        if (lockTaskController.getLockTaskModeState() != 1) goto L66;
    L53:
        r2 = this.mService.mActivityClientController;     // Catch: Throwable -> L32
        goto L52
    L47:
        if (r.info.applicationInfo.uid == applicationInfoUid) goto L50;
    L42:
        r1 = -1;
    L32:
        th = th;
    L94:
        endDeferResume();
        proc.resumeConfigurationDispatch();
        throw th;
    L28:
        andResume2 = andResume;
    L26:
        th = th;
        goto L94
    L11:
        if (task.pauseActivityIfNeeded(r, "realStart") == false) goto L13;
        return false;
    L13:
        TaskFragment taskFragment = r.getTaskFragment();
        if (taskFragment == null) goto L20;
        if (taskFragment.getResumedActivity() == null) goto L20;
        if (taskFragment.startPausing(this.mUserLeaving, false, r, "realStart") == false) goto L20;
        return false;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L7;
        String protoLogParam1 = String.valueOf(r);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 4094852138446437211L, 0, new Object[]{protoLogParam1});
    L7:
        return false;
    }

    private RemoteException tryRealStartActivityInner(Task task, ActivityRecord r, WindowProcessController proc, IActivityClientController activityClientController, boolean andResume) {
        if (proc.hasThread() == true) goto L7;
        return new RemoteException();
    L7:
        if (andResume == false) goto L9;
        List<ReferrerIntent> r0 = r.results;
        List<ReferrerIntent> newIntents = r.newIntents;
        List<ReferrerIntent> newIntents2 = newIntents;
        List<ReferrerIntent> newIntents3 = r0;
    L11:
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L13;
        Slog.v("ActivityTaskManager", "Launching: " + r + " savedState=" + r.getSavedState() + " with results=" + newIntents3 + " newIntents=" + newIntents2 + " andResume=" + andResume);
    L13:
        EventLogTags.writeWmRestartActivity(r.mUserId, System.identityHashCode(r), task.mTaskId, r.shortComponentName);
        updateHomeProcessIfNeeded(r);
        this.mService.getPackageManagerInternalLocked().notifyPackageUse(r.intent.getComponent().getPackageName(), 0);
        this.mService.getAppWarningsLocked().onStartActivity(r);
        Configuration procConfig = proc.prepareConfigurationForLaunchingActivity();
        Configuration overrideConfig = r.getMergedOverrideConfiguration();
        r.setLastReportedConfiguration(procConfig, overrideConfig);
        ActivityWindowInfo activityWindowInfo = r.getActivityWindowInfo();
        r.setLastReportedActivityWindowInfo(activityWindowInfo);
        logIfTransactionTooLarge(r.intent, r.getSavedState());
        TaskFragment organizedTaskFragment = r.getOrganizedTaskFragment();
        if (organizedTaskFragment == null) goto L16;
        this.mService.mTaskFragmentOrganizerController.dispatchPendingInfoChangedEvent(organizedTaskFragment);
    L16:
        boolean isTransitionForward = r.isTransitionForward();
        IBinder fragmentToken = r.getTaskFragment().getFragmentToken();
        int deviceId = getDeviceIdForDisplayId(r.getDisplayId());
        ClientTransactionItem r7 = new LaunchActivityItem(r.token, r.intent, System.identityHashCode(r), r.info, procConfig, overrideConfig, deviceId, r.getFilteredReferrer(r.launchedFromPackage), task.voiceInteractor, proc.getReportedProcState(), r.getSavedState(), r.getPersistentSavedState(), newIntents3, newIntents2, r.takeSceneTransitionInfo(), isTransitionForward, proc.createProfilerInfoIfNeeded(), r.assistToken, activityClientController, r.shareableActivityToken, r.getLaunchedFromBubble(), fragmentToken, r.initialCallerInfoAccessToken, activityWindowInfo);
        if (andResume == false) goto L20;
        ResumeActivityItem r9 = new ResumeActivityItem(r.token, isTransitionForward, r.shouldSendCompatFakeFocus());
    L24:
        if (ClientLifecycleManager.shouldDispatchLaunchActivityItemIndependently(r.info.packageName, r.getUid()) == false) goto L108;
        this.mService.getLifecycleManager().dispatchPendingTransaction(proc.getThread());
    L108:
        boolean r1 = this.mService.getLifecycleManager().scheduleTransactionItems(proc.getThread(), true, new ClientTransactionItem[]{r7, r9});     // Catch: RemoteException -> L106
        if (procConfig.seq <= this.mRootWindowContainer.getConfiguration().seq) goto L31;
        proc.setLastReportedConfiguration(procConfig);
    L31:
        if ((proc.mInfo.privateFlags & 2) == 0) goto L43;
        if (this.mService.mHasHeavyWeightFeature == false) goto L43;
        if (proc.mName.equals(proc.mInfo.packageName) == false) goto L43;
        if (this.mService.mHeavyWeightProcess != null) goto L39;
    L41:
        this.mService.setHeavyWeightProcess(r);
        goto L43
    L39:
        if (this.mService.mHeavyWeightProcess == proc) goto L41;
        Slog.w("ActivityTaskManager", "Starting new heavy weight process " + proc + " when already running " + this.mService.mHeavyWeightProcess);
    L43:
        if (MindSyncManager.ZTE_FEATURE_MINDSYNC == false) goto L114;
        if (andResume == false) goto L115;
        Task rootTaskTepm = task.getRootTask();
        if (rootTaskTepm != null) goto L48;
        return null;
    L48:
        if (r.info != null) goto L50;
    L52:
        int uid = -1;
    L54:
        if (TextUtils.isEmpty(r.packageName) == true) goto L56;
        String pkgName = r.packageName;
        String pkgName2 = pkgName;
    L58:
        if (r.mActivityComponent == null) goto L60;
        String nextClass = r.mActivityComponent.getClassName();
        String nextClass2 = nextClass;
    L62:
        if (r.app == null) goto L64;
        int pid = r.app.getPid();
        int pid2 = pid;
    L66:
        if (TextUtils.isEmpty(r.processName) == true) goto L68;
        String processName = r.processName;
    L69:
        int windowingMode = r.getWindowingMode();
        ActivityRecord prev = rootTaskTepm.mLastPausedActivity;
        if (prev != null) goto L72;
    L78:
        String prevPkg = "";
        String prevClass = "";
    L80:
        if (this.mIsRecents == false) goto L82;
        this.mIsRecents = false;
        boolean isRecents = true;
    L84:
        if (uid != (-1)) goto L86;
    L103:
        int uid2 = uid;
        int uid3 = pid2;
        Slog.w("ActivityTaskManager", "Skip noteAppForeground: core params invalid, uid=" + uid2 + ", pkg=" + pkgName2 + ", pid=" + uid3);
        return null;
    L86:
        if (TextUtils.isEmpty(pkgName2) == true) goto L103;
        if (pid2 == (-1)) goto L103;
        Slog.i("ActivityTaskManager", "call MindSyncManager.Trigger.noteAppForeground(), r=" + r);     // Catch: Exception -> L97 NullPointerException -> L99
    L110:
        MindSyncManager.Trigger.noteAppForeground(uid, pkgName2, nextClass2, pid2, processName, windowingMode, prevPkg, SystemClock.elapsedRealtime(), true, r.intent, prevClass, nextClass2, isRecents);     // Catch: Exception -> L93 NullPointerException -> L95
    L117:
        return null;
    L95:
        e = e;
    L102:
        Slog.e("ActivityTaskManager", "noteAppForeground NPE caught: ", e);
        return null;
    L93:
        e = e;
    L101:
        Slog.e("ActivityTaskManager", "noteAppForeground exception caught: ", e);
        return null;
    L99:
        e = e;
    L97:
        e = e;
        goto L101
    L82:
        isRecents = false;
        goto L84
    L72:
        if (TextUtils.isEmpty(prev.packageName) == true) goto L78;
        String prevPkg2 = prev.packageName;
        if (prev.mActivityComponent == null) goto L76;
        String r2 = prev.mActivityComponent.getClassName();
    L77:
        String prevClass2 = r2;
        prevPkg = prevPkg2;
        prevClass = prevClass2;
        goto L80
    L76:
        r2 = "";
        goto L77
    L68:
        processName = "";
        goto L69
    L64:
        pid2 = -1;
        goto L66
    L60:
        nextClass2 = "";
        goto L62
    L56:
        pkgName2 = "";
        goto L58
    L50:
        if (r.info.applicationInfo == null) goto L52;
        uid = r.info.applicationInfo.uid;
        goto L54
    L115:
        return null;
    L114:
        return null;
    L106:
        e = move-exception;
        return e;
    L20:
        if (r.isVisibleRequested() == false) goto L22;
        r9 = new PauseActivityItem(r.token);
        goto L24
    L22:
        r9 = new StopActivityItem(r.token);
        goto L24
    L9:
        newIntents2 = null;
        newIntents3 = null;
        goto L11
    }

    void updateHomeProcessIfNeeded(ActivityRecord r) {
        if (r.isActivityTypeHome() == true) goto L5;
        return;
    L5:
        ActivityRecord bottom = r.getTask().getBottomMostActivityInSamePackage();
        if (bottom == null) goto L9;
        updateHomeProcess(bottom.app);
        return;
    }

    void updateHomeProcess(WindowProcessController app) {
        if (app != null) goto L4;
        return;
    L4:
        if (this.mService.mHomeProcess == app) goto L8;
        scheduleStartHome("homeChanged");
        this.mService.mHomeProcess = app;
        Process.setUIFirstSchedEventTrack(app.mPid, this.mService.getSmtEx().getLauncherLoaderTid(app.mPid), 2, app.mInfo.packageName, true, 0);
        return;
    }

    private void scheduleStartHome(String reason) {
        if (this.mHandler.hasMessages(216) == true) goto L6;
        this.mHandler.obtainMessage(216, reason).sendToTarget();
        return;
    }

    private void logIfTransactionTooLarge(Intent intent, Bundle icicle) {
        int extrasSize = 0;
        if (intent == null) goto L7;
        Bundle extras = intent.getExtras();
        if (extras == null) goto L7;
        extrasSize = extras.getSize();
    L7:
        if (icicle != null) goto L9;
        int icicleSize = 0;
    L11:
        if ((extrasSize + icicleSize) <= 200000) goto L14;
        Slog.e("ActivityTaskManager", "Transaction too large, intent: " + intent + ", extras size: " + extrasSize + ", icicle size: " + icicleSize);
        return;
    L14:
        return;
    L9:
        icicleSize = icicle.getSize();
        goto L11
    }

    void startSpecificActivity(final ActivityRecord r, final boolean andResume, final boolean checkConfig) {
        WindowProcessController wpc = this.mService.getProcessController(r.processName, r.info.applicationInfo.uid);
        if (wpc != null) goto L8;
        wpc = this.mService.getSmtEx().getFrozenProcessController(r.processName, r.info.applicationInfo.uid);
        if (wpc == null) goto L8;
        wpc.getWPCSmtEx().unFreezeProcIfNeedLocked(new StartActivityEvent(wpc, new ActivityTaskSupervisor$$ExternalSyntheticLambda3(this, r, andResume, checkConfig)));
        Slog.i("AMS.Freeze", "unFreezeProcIfNeedLocked wpc:" + wpc + " procName:" + r.processName + " for StartActivityEvent, at startSpecificActivity");
        return;
    L8:
        boolean isTop = true;
        if (ActivityTaskManagerDebugConfig.DEBUG_PREFETCH == false) goto L32;
        StringBuilder r1 = new StringBuilder();
        r1.append("startSpecificActivity wpc=");
        r1.append(wpc);
        r1.append(" prefetchState=");
        int r4 = -1;
        if (wpc == null) goto L13;
        int r5 = wpc.mInfo.getSysEx().prefetchState;
    L14:
        r1.append(r5);
        r1.append(" doPrefetch=");
        if (wpc == null) goto L17;
        r4 = wpc.mInfo.getSysEx().doPrefetch;
    L17:
        r1.append(r4);
        r1.append(" hasThread=");
        if (wpc != null) goto L20;
    L22:
        IApplicationThread r6 = "false";
    L23:
        r1.append(r6);
        r1.append(" realStartActivityLocked=");
        if (wpc != null) goto L26;
    L30:
        boolean r7 = false;
    L31:
        r1.append(r7);
        Slog.i("SmartPrefetch", r1.toString());
        goto L32
    L26:
        if (wpc.hasThread() == false) goto L30;
        if (wpc.mInfo.getSysEx().doPrefetch != 0) goto L30;
        r7 = true;
        goto L31
    L20:
        if (wpc.hasThread() == false) goto L22;
        r6 = wpc.getThread();
        goto L23
    L13:
        r5 = -1;
    L32:
        boolean knownToBeDead = false;
        if (wpc == null) goto L50;
        if (wpc.hasThread() == false) goto L50;
        if (wpc.mInfo.getSysEx().doPrefetch != 0) goto L50;
    L41:
        e = move-exception;
        Slog.w("ActivityTaskManager", "Exception when starting activity " + r.intent.getComponent().flattenToShortString(), e);
        knownToBeDead = true;
        this.mService.mProcessNames.remove(wpc.mName, wpc.mUid);
        this.mService.mProcessMap.remove(wpc.getPid());
    L53:
        r.notifyUnknownVisibilityLaunchedForKeyguardTransition();
        if (andResume == true) goto L56;
    L58:
        isTop = false;
    L59:
        if (isTop == false) goto L65;
        ProcessFreezerManager freezer = ProcessFreezerManager.getInstance();
        if (freezer == null) goto L65;
        if (freezer.useFreezerManager() == false) goto L65;
        freezer.startFreeze(r.processName, 2);
    L65:
        ActivityTaskManagerService r8 = this.mService;
        if (isTop == false) goto L68;
        String r9 = HostingRecord.HOSTING_TYPE_TOP_ACTIVITY;
    L69:
        r8.startProcessAsync(r, knownToBeDead, isTop, r9);
        if (SysOptBridge.getFactory().getResMngConfig().isModuleEnable(IResMngConfig.FEAT_FREEZE, IResMngConfig.MOD_QUICK_FREEZE) == true) goto L72;
        return;
    L72:
        if (r.callerApp != null) goto L74;
        return;
    L74:
        if (r.callerApp.isHomeProcess() == false) goto L81;
        SysOptBridge.getFactory().getSmartService().freezeAppsByStartProcess(r.getUid());
        FeatLog.d("ActivityTaskManager", "FEAT_FREEZE_WHEN_LAUNCH_APP", 0, "ASS freezeAppsByStartProcess r=" + r);
        return;
    L81:
        return;
    L68:
        r9 = HostingRecord.HOSTING_TYPE_ACTIVITY;
        goto L69
    L56:
        if (r.isTopRunningActivity() == false) goto L58;
    L39:
        if (this.mPerfBoost == null) goto L44;
        Slog.i("ActivityTaskManager", "The Process " + r.processName + " Already Exists in BG. So sending its PID: " + wpc.getPid());     // Catch: RemoteException -> L41
        this.mPerfBoost.perfHint(4225, r.processName, wpc.getPid(), 102);     // Catch: RemoteException -> L41
    L44:
        if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(wpc.mInfo.getSysEx().prefetchState) == true) goto L46;
        SysOptBridge.getFactory().getSysPrefetchService().removePrefetchApp(wpc.getPid(), 1);     // Catch: RemoteException -> L41
    L46:
        realStartActivityLocked(r, wpc, andResume, checkConfig);     // Catch: RemoteException -> L41
        return;
    L50:
        if (ActivityTaskManagerService.isSdkSandboxActivityIntent(this.mService.mContext, r.intent) == false) goto L53;
        Slog.e("ActivityTaskManager", "Abort sandbox activity launching as no sandbox process to host it.");
        r.finishIfPossible("No sandbox process for the activity", false);
        r.launchFailed = true;
        r.detachFromProcess();
    }

    private /* synthetic */ void lambda$startSpecificActivity$2(ActivityRecord r, boolean andResume, boolean checkConfig) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Slog.i("AMS.Freeze", "unfreeze async startSpecificActivity " + r + " " + andResume + " " + checkConfig);     // Catch: Throwable -> L8
        startSpecificActivity(r, andResume, checkConfig);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    boolean checkStartAnyActivityPermission(Intent intent, ActivityInfo aInfo, String resultWho, int requestCode, int callingPid, int callingUid, String callingPackage, String callingFeatureId, boolean ignoreTargetSecurity, boolean launchingInTask, WindowProcessController callerApp, ActivityRecord resultRecord, Task resultRootTask) {
        if (this.mService.getRecentTasks() != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        boolean isCallerRecents = r1;
        int startAnyPerm = ActivityTaskManagerService.checkPermission("android.permission.START_ANY_ACTIVITY", callingPid, callingUid);
        if (startAnyPerm == 0) goto L46;
        if (isCallerRecents == false) goto L13;
        if (launchingInTask == false) goto L13;
        return true;
    L13:
        int componentRestriction = getComponentRestrictionForCallingPackage(aInfo, callingPackage, callingFeatureId, callingPid, callingUid, ignoreTargetSecurity);
        int actionRestriction = getActionRestrictionForCallingPackage(intent.getAction(), callingPackage, callingFeatureId, callingPid, callingUid);
        if (componentRestriction == 1) goto L26;
        if (actionRestriction == 1) goto L26;
        if (actionRestriction != 2) goto L21;
        String message = "Appop Denial: starting " + intent.toString() + " from " + callerApp + " (pid=" + callingPid + ", uid=" + callingUid + ") requires " + AppOpsManager.permissionToOp(ACTION_TO_RUNTIME_PERMISSION.get(intent.getAction()));
        Slog.w("ActivityTaskManager", message);
        return false;
    L21:
        if (componentRestriction != 2) goto L24;
        String message2 = "Appop Denial: starting " + intent.toString() + " from " + callerApp + " (pid=" + callingPid + ", uid=" + callingUid + ") requires appop " + AppOpsManager.permissionToOp(aInfo.permission);
        Slog.w("ActivityTaskManager", message2);
        return false;
    L24:
        return true;
    L26:
        if (resultRecord == null) goto L29;
        resultRecord.sendResult(-1, resultWho, requestCode, 0, null, null, null);
    L29:
        if (actionRestriction != 1) goto L32;
        String msg = "Permission Denial: starting " + intent.toString() + " from " + callerApp + " (pid=" + callingPid + ", uid=" + callingUid + ") with revoked permission " + ACTION_TO_RUNTIME_PERMISSION.get(intent.getAction());
    L36:
        if ("android.permission.GRANT_RUNTIME_PERMISSIONS".equals(aInfo.permission) == true) goto L38;
    L43:
        Slog.w("ActivityTaskManager", msg);
        throw new SecurityException(msg);
    L38:
        if (this.mZswExt == null) goto L43;
        if (this.mZswExt.isHSCallingUid(this.mService.mContext, callingUid) == false) goto L43;
        return true;
    L32:
        if (aInfo.exported == true) goto L34;
        msg = "Permission Denial: starting " + intent.toString() + " from " + callerApp + " (pid=" + callingPid + ", uid=" + callingUid + ") not exported from uid " + aInfo.applicationInfo.uid;
        goto L36
    L34:
        msg = "Permission Denial: starting " + intent.toString() + " from " + callerApp + " (pid=" + callingPid + ", uid=" + callingUid + ") requires " + aInfo.permission;
        goto L36
    L46:
        return true;
    L5:
        if (this.mService.getRecentTasks().isCallerRecents(callingUid) == false) goto L7;
        r1 = true;
        goto L8
    }

    boolean isCallerAllowedToLaunchOnTaskDisplayArea(int callingPid, int callingUid, TaskDisplayArea taskDisplayArea, ActivityInfo aInfo) {
        if (taskDisplayArea == null) goto L4;
        int r0 = taskDisplayArea.getDisplayId();
    L6:
        return isCallerAllowedToLaunchOnDisplay(callingPid, callingUid, r0, aInfo);
    L4:
        r0 = 0;
        goto L6
    }

    boolean isCallerAllowedToLaunchOnDisplay(int callingPid, int callingUid, int launchDisplayId, ActivityInfo aInfo) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L5;
        long protoLogParam0 = launchDisplayId;
        long protoLogParam1 = callingPid;
        long protoLogParam2 = callingUid;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, -8529426827020190143L, 21, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1), Long.valueOf(protoLogParam2)});
    L5:
        boolean allowed = true;
        if (callingPid != (-1)) goto L12;
        if (callingUid != (-1)) goto L12;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L11;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, 9147909968067116569L, 0, null);
    L11:
        return true;
    L12:
        DisplayContent displayContent = this.mRootWindowContainer.getDisplayContentOrCreate(launchDisplayId);
        if (displayContent == null) goto L74;
        if (displayContent.isRemoved() == true) goto L74;
        if ((displayContent.mDisplay.getFlags() & 8192) == 0) goto L21;
        Slog.w("ActivityTaskManager", "Launch on display check: activity launch is not allowed on rear display");
        return false;
    L21:
        int startAnyPerm = ActivityTaskManagerService.checkPermission("android.permission.INTERNAL_SYSTEM_WINDOW", callingPid, callingUid);
        if (startAnyPerm == 0) goto L24;
        boolean uidPresentOnDisplay = displayContent.isUidPresent(callingUid);
        Display display = displayContent.mDisplay;
        if (display.isTrusted() == true) goto L44;
        if ((aInfo.flags & Integer.MIN_VALUE) != 0) goto L36;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L34;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, 7828411869729995271L, 0, null);
    L34:
        return false;
    L36:
        if (ActivityTaskManagerService.checkPermission("android.permission.ACTIVITY_EMBEDDING", callingPid, callingUid) != (-1)) goto L44;
        if (uidPresentOnDisplay == true) goto L44;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L41;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, -2215878620906309682L, 0, null);
    L41:
        return false;
    L44:
        if (displayContent.isPrivate() == true) goto L61;
        int userId = UserHandle.getUserId(callingUid);
        int displayId = display.getDisplayId();
        if (userId == 0) goto L53;
        if (this.mWindowManager.mUmInternal.isUserVisible(userId, displayId) == true) goto L53;
        allowed = false;
    L53:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L59;
        if (allowed == false) goto L56;
        String r5 = "allow";
    L57:
        String protoLogParam3 = String.valueOf(r5);
        long protoLogParam4 = userId;
        long protoLogParam5 = displayId;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, 986565579776405555L, 20, new Object[]{protoLogParam3, Long.valueOf(protoLogParam4), Long.valueOf(protoLogParam5)});
        goto L59
    L56:
        r5 = "disallow";
    L59:
        return allowed;
    L61:
        if (display.getOwnerUid() == callingUid) goto L63;
        if (uidPresentOnDisplay == true) goto L68;
        Slog.w("ActivityTaskManager", "Launch on display check: denied");
        return false;
    L68:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L70;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, -4258279435559028377L, 0, null);
    L70:
        return true;
    L63:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L65;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, -2201418325681949201L, 0, null);
    L65:
        return true;
    L24:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L26;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, 4781135167649953680L, 0, null);
    L26:
        return true;
    L74:
        Slog.w("ActivityTaskManager", "Launch on display check: display not found");
        return false;
    }

    UserInfo getUserInfo(int userId) {
        long identity = Binder.clearCallingIdentity();
        UserInfo r2 = UserManager.get(this.mService.mContext).getUserInfo(userId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    int getDeviceIdForDisplayId(int displayId) {
        if (displayId != 0) goto L5;
    L17:
        return 0;
    L5:
        if (displayId == (-1)) goto L17;
        if (this.mVirtualDeviceManagerInternal != null) goto L16;
        if (this.mService.mHasCompanionDeviceSetupFeature == false) goto L13;
        this.mVirtualDeviceManagerInternal = (VirtualDeviceManagerInternal) LocalServices.getService(VirtualDeviceManagerInternal.class);
    L13:
        if (this.mVirtualDeviceManagerInternal != null) goto L16;
        return 0;
    L16:
        return this.mVirtualDeviceManagerInternal.getDeviceIdForDisplayId(displayId);
    }

    boolean isDeviceOwnerUid(int displayId, int callingUid) {
        int deviceId = getDeviceIdForDisplayId(displayId);
        if (deviceId != 0) goto L5;
    L11:
        return false;
    L5:
        if (deviceId == (-1)) goto L11;
        if (this.mVirtualDeviceManagerInternal.getDeviceOwnerUid(deviceId) != callingUid) goto L12;
        return true;
    L12:
        return false;
    }

    private AppOpsManager getAppOpsManager() {
        if (this.mAppOpsManager != null) goto L6;
        this.mAppOpsManager = (AppOpsManager) this.mService.mContext.getSystemService(AppOpsManager.class);
    L6:
        return this.mAppOpsManager;
    }

    BackgroundActivityStartController getBackgroundActivityLaunchController() {
        return this.mBalController;
    }

    private int getComponentRestrictionForCallingPackage(ActivityInfo activityInfo, String callingPackage, String callingFeatureId, int callingPid, int callingUid, boolean ignoreTargetSecurity) {
        if (ignoreTargetSecurity == true) goto L9;
        if (ActivityTaskManagerService.checkComponentPermission(activityInfo.permission, callingPid, callingUid, activityInfo.applicationInfo.uid, activityInfo.exported) != (-1)) goto L9;
        return 1;
    L9:
        if (activityInfo.permission != null) goto L11;
        return 0;
    L11:
        int opCode = AppOpsManager.permissionToOpCode(activityInfo.permission);
        if (opCode != (-1)) goto L15;
        return 0;
    L15:
        if (getAppOpsManager().noteOpNoThrow(opCode, callingUid, callingPackage, callingFeatureId, "") == 0) goto L19;
        if (ignoreTargetSecurity == true) goto L19;
        return 2;
    L19:
        return 0;
    }

    private int getActionRestrictionForCallingPackage(String action, String callingPackage, String callingFeatureId, int callingPid, int callingUid) {
        if (action != null) goto L5;
        return 0;
    L5:
        String permission = ACTION_TO_RUNTIME_PERMISSION.get(action);
        if (permission != null) goto L33;
        return 0;
    L33:
        PackageInfo packageInfo = this.mService.mContext.getPackageManager().getPackageInfoAsUser(callingPackage, 4096, UserHandle.getUserId(callingUid));     // Catch: PackageManager.NameNotFoundException -> L30
        if (ArrayUtils.contains(packageInfo.requestedPermissions, permission) == true) goto L14;
        return 0;
    L14:
        if (ActivityTaskManagerService.checkPermission(permission, callingPid, callingUid) != (-1)) goto L16;
        return 1;
    L16:
        int opCode = AppOpsManager.permissionToOpCode(permission);
        if (opCode != (-1)) goto L20;
        return 0;
    L20:
        if (getAppOpsManager().noteOpNoThrow(opCode, callingUid, callingPackage, callingFeatureId, "") != 0) goto L22;
        return 0;
    L22:
        if ("android.permission.CAMERA".equals(permission) == false) goto L28;
        SensorPrivacyManagerInternal spmi = (SensorPrivacyManagerInternal) LocalServices.getService(SensorPrivacyManagerInternal.class);
        UserHandle user = UserHandle.getUserHandleForUid(callingUid);
        boolean cameraPrivacyEnabled = spmi.isSensorPrivacyEnabled(user.getIdentifier(), 2);
        if (cameraPrivacyEnabled == false) goto L28;
        AppOpsManagerInternal aomi = (AppOpsManagerInternal) LocalServices.getService(AppOpsManagerInternal.class);
        int numCameraRestrictions = aomi.getOpRestrictionCount(26, user, callingPackage, null);
        if (numCameraRestrictions != 1) goto L28;
        return 0;
    L28:
        return 2;
    L31:
        Slog.i("ActivityTaskManager", "Cannot find package info for " + callingPackage);
        return 0;
    }

    void setLaunchSource(int uid) {
        this.mLaunchingActivityWakeLock.setWorkSource(new WorkSource(uid));
    }

    void acquireLaunchWakelock() {
        this.mLaunchingActivityWakeLock.acquire();
        if (this.mHandler.hasMessages(204) == true) goto L6;
        this.mHandler.sendEmptyMessageDelayed(204, LAUNCH_TIMEOUT);
        return;
    }

    private void checkFinishBootingLocked() {
        boolean booting = this.mService.isBooting();
        boolean enableScreen = false;
        this.mService.setBooting(false);
        if (this.mService.isBooted() == true) goto L5;
        this.mService.setBooted(true);
        enableScreen = true;
    L5:
        if (booting == true) goto L7;
        if (enableScreen == true) goto L7;
        return;
    L7:
        this.mService.postFinishBooting(booting, enableScreen);
    }

    void activityIdleInternal(ActivityRecord r, boolean fromTimeout, boolean processPausingActivities, Configuration config) {
        if (ActivityTaskManagerDebugConfig.DEBUG_ALL == false) goto L5;
        Slog.v("ActivityTaskManager", "Activity idle: " + r);
    L5:
        if (r != null) goto L7;
        ActivityTaskSupervisor r3 = this;
        ActivityRecord r2 = r;
    L24:
        if (r3.mRootWindowContainer.allResumedActivitiesIdle() == false) goto L30;
        if (r2 == null) goto L28;
        r3.mService.scheduleAppGcsLocked();
        r3.mRecentTasks.onActivityIdle(r2);
    L28:
        if (r3.mLaunchingActivityWakeLock.isHeld() == false) goto L30;
        r3.mHandler.removeMessages(204);
        r3.mLaunchingActivityWakeLock.release();
    L30:
        processStoppingAndFinishingActivities(r2, processPausingActivities, "idle");
        if (ActivityTaskManagerDebugConfig.DEBUG_IDLE == false) goto L34;
        Slogf.i("ActivityTaskManager", "activityIdleInternal(): r=%s, mStartingUsers=%s", new Object[]{r2, r3.mStartingUsers});
    L34:
        if (r3.mStartingUsers.isEmpty() == true) goto L39;
        ArrayList<UserState> startingUsers = new ArrayList(r3.mStartingUsers);
        r3.mStartingUsers.clear();
        int i = 0;
    L37:
        if (i >= startingUsers.size()) goto L39;
        UserState userState = startingUsers.get(i);
        Slogf.i("ActivityTaskManager", "finishing switch of user %d", new Object[]{Integer.valueOf(userState.mHandle.getIdentifier())});
        r3.mService.mAmInternal.finishUserSwitch(userState);
        i = i + 1;
    L39:
        r3.mService.mH.post(new ActivityTaskSupervisor$$ExternalSyntheticLambda1(this));
        if (r2 == null) goto L44;
        SysOptBridge.getFactory().getOAutoHelper().onActivityIdle(r2.mActivityComponent);
        return;
    L44:
        return;
    L7:
        if (ActivityTaskManagerDebugConfig.DEBUG_IDLE == false) goto L9;
        Slog.d("ActivityTaskManager", "activityIdleInternal: Callers=" + Debug.getCallers(4));
    L9:
        this.mHandler.removeMessages(200, r);
        if (fromTimeout == false) goto L12;
        r3 = this;
        r2 = r;
        boolean fromTimeout2 = fromTimeout;
        r3.reportActivityLaunched(fromTimeout2, r2, -1, -1);
    L13:
        if (config == null) goto L15;
        r2.setLastReportedGlobalConfiguration(config);
    L15:
        r2.idle = true;
        if (r3.mService.isBooting() == true) goto L18;
    L19:
        if (fromTimeout2 == false) goto L21;
    L20:
        checkFinishBootingLocked();
    L21:
        r2.mRelaunchReason = 0;
        goto L24
    L18:
        if (r3.mRootWindowContainer.allResumedActivitiesIdle() == true) goto L20;
    L12:
        r3 = this;
        r2 = r;
        fromTimeout2 = fromTimeout;
        goto L13
    }

    private /* synthetic */ void lambda$activityIdleInternal$3() {
        this.mService.mAmInternal.trimApplications();
    }

    void findTaskToMoveToFront(Task task, int flags, ActivityOptions options, String reason, boolean forceNonResizeable) {
        Task currentRootTask = task;
        Task currentRootTask2 = currentRootTask.getRootTask();
        Task focusedStack = this.mRootWindowContainer.getTopDisplayFocusedRootTask();
        if (focusedStack == null) goto L5;
        ActivityRecord r3 = focusedStack.getTopNonFinishingActivity();
    L6:
        ActivityRecord top_activity = r3;
        if (top_activity == null) goto L12;
        if (top_activity.getState() != ActivityRecord.State.DESTROYED) goto L12;
        acquireAppLaunchPerfLock(top_activity);
    L12:
        if (currentRootTask2 != null) goto L16;
        Slog.e("ActivityTaskManager", "findTaskToMoveToFront: can't move task=" + currentRootTask + " to front. Root task is null");
        return;
    L16:
        if (options != null) goto L114;
    L23:
        boolean r4 = true;
    L24:
        boolean shouldCauseEnterPip = r4;
        if ((flags & 2) != 0) goto L130;
        if (shouldCauseEnterPip == false) goto L130;
        this.mUserLeaving = true;     // Catch: Throwable -> L21
    L130:
        this.mService.deferWindowLayout();     // Catch: Throwable -> L106
        Transition transition = currentRootTask.mTransitionController.getCollectingTransition();     // Catch: Throwable -> L106
        if (transition == null) goto L31;
    L34:
        boolean newTransition = false;
    L35:
        currentRootTask.mTransitionController.collect(currentRootTask);     // Catch: Throwable -> L106
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L106
        String r6 = reason;
        r5.append(r6);     // Catch: Throwable -> L104
        r5.append(" findTaskToMoveToFront");     // Catch: Throwable -> L104
        String reason2 = r5.toString();     // Catch: Throwable -> L104
        boolean reparented = false;
        if (currentRootTask.isResizeable() == true) goto L120;
    L55:
        boolean r15 = true;
        Transition transition2 = transition;
        String reason3 = reason2;
        Task currentRootTask3 = currentRootTask2;
    L128:
    L98:
        th = th;
    L108:
        this.mUserLeaving = false;
        this.mService.continueWindowLayout();
        throw th;
    L57:
        if (Features.FEAT_QUICK_WIN == true) goto L126;
    L61:
        if (reparented == true) goto L63;
        moveHomeRootTaskToFrontIfNeeded(flags, currentRootTask3.getDisplayArea(), reason3);     // Catch: Throwable -> L59
    L59:
        th = th;
    L63:
        ActivityRecord r = currentRootTask.getTopNonFinishingActivity();     // Catch: Throwable -> L98
        if (r != null) goto L67;
        AppTimeTracker r7 = null;
    L68:
        Task currentRootTask4 = currentRootTask3;
        currentRootTask4.moveTaskToFront(currentRootTask, false, options, r7, reason3);     // Catch: Throwable -> L100
    L73:
        th = th;
        goto L108
    L71:
        if (ActivityTaskManagerDebugConfig.DEBUG_ROOT_TASK == false) goto L76;
        Slog.d("ActivityTaskManager", "findTaskToMoveToFront: moved to front of root task=" + currentRootTask4);     // Catch: Throwable -> L73
    L76:
        currentRootTask3 = currentRootTask4;
        currentRootTask = task;
        handleNonResizableTaskIfNeeded(currentRootTask, 0, this.mRootWindowContainer.getDefaultTaskDisplayArea(), currentRootTask3, forceNonResizeable);     // Catch: Throwable -> L98
        currentRootTask4 = currentRootTask3;
        if (r == null) goto L88;
        if (options == null) goto L87;
    L85:
        th = th;
        goto L108
    L83:
        if (options.getDisableStartingWindow() == true) goto L88;
    L87:
        r.showStartingWindow(r15);     // Catch: Throwable -> L85
    L88:
        if (newTransition == false) goto L96;
        TransitionController r8 = currentRootTask.mTransitionController;     // Catch: Throwable -> L85
        if (options == null) goto L92;
        RemoteTransition r9 = options.getRemoteTransition();     // Catch: Throwable -> L85
    L93:
        r8.requestStartTransition(transition2, currentRootTask, r9, null);     // Catch: Throwable -> L85
        goto L96
    L92:
        r9 = null;
    L96:
        this.mUserLeaving = false;
        this.mService.continueWindowLayout();
        return;
    L100:
        th = th;
        goto L108
    L67:
        r7 = r.appTimeTracker;     // Catch: Throwable -> L98
        goto L68
    L126:
        getExt().findTaskToMoveToFront(currentRootTask, options);     // Catch: Throwable -> L59
        goto L61
    L120:
    L50:
        th = th;
        goto L108
    L42:
        if (canUseActivityOptionsLaunchBounds(options) == false) goto L55;
        Task targetRootTask = this.mRootWindowContainer.getOrCreateRootTask(null, options, currentRootTask, true);     // Catch: Throwable -> L50
        if (targetRootTask == currentRootTask2) goto L52;
        moveHomeRootTaskToFrontIfNeeded(flags, targetRootTask.getDisplayArea(), reason2);     // Catch: Throwable -> L50
        reason3 = reason2;
        r15 = true;
        transition2 = transition;
        currentRootTask.reparent(targetRootTask, true, 1, false, true, reason3);     // Catch: Throwable -> L48
        currentRootTask2 = targetRootTask;
        reparented = true;
    L53:
        Rect bounds = options.getLaunchBounds();     // Catch: Throwable -> L48
        currentRootTask.setBounds(bounds);     // Catch: Throwable -> L48
        currentRootTask3 = currentRootTask2;
    L48:
        th = th;
        goto L108
    L52:
        r15 = true;
        transition2 = transition;
        reason3 = reason2;
    L102:
        th = th;
    L104:
        th = th;
        goto L108
    L31:
        if (currentRootTask.mTransitionController.isShellTransitionsEnabled() == false) goto L34;
        transition = currentRootTask.mTransitionController.createTransition(3);     // Catch: Throwable -> L21
        newTransition = true;
    L21:
        th = th;
    L106:
        th = th;
        r6 = reason;
        goto L108
    L114:
        if (options.disallowEnterPictureInPictureWhileLaunching() == false) goto L23;
        r4 = false;
        goto L24
    L5:
        r3 = null;
        goto L6
    }

    void moveHomeRootTaskToFrontIfNeeded(int flags, TaskDisplayArea taskDisplayArea, String reason) {
        Task focusedRootTask = taskDisplayArea.getFocusedRootTask();
        if (taskDisplayArea.getWindowingMode() == 1) goto L5;
    L6:
        if (focusedRootTask != null) goto L8;
        return;
    L8:
        if (focusedRootTask.isActivityTypeRecents() == true) goto L10;
        return;
    L10:
        if (focusedRootTask.getWindowingMode() == 6) goto L15;
    L11:
        taskDisplayArea.moveHomeRootTaskToFront(reason);
        return;
    L15:
        return;
    L5:
        if ((flags & 1) != 0) goto L11;
        goto L6
    }

    boolean canUseActivityOptionsLaunchBounds(ActivityOptions options) {
        if (Features.FEAT_QUICK_WIN == false) goto L5;
        return false;
    L5:
        if (options != null) goto L7;
    L17:
        return false;
    L7:
        if (options.getLaunchBounds() == null) goto L17;
        if (this.mService.mSupportsPictureInPicture == false) goto L14;
        if (options.getLaunchWindowingMode() != 2) goto L14;
    L15:
        return true;
    L14:
        if (this.mService.mSupportsFreeformWindowManagement == true) goto L15;
        return false;
    }

    LaunchParamsController getLaunchParamsController() {
        return this.mLaunchParamsController;
    }

    private void removePinnedRootTaskInSurfaceTransaction(Task rootTask) {
        Transition transition = rootTask.mTransitionController.requestTransitionIfNeeded(4, 0, rootTask, rootTask.mDisplayContent);
        if (transition != null) goto L5;
        rootTask.mTransitionController.collect(rootTask);
    L6:
        rootTask.cancelAnimation();
        rootTask.setForceHidden(1, true);
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == true) goto L10;
        rootTask.ensureActivitiesVisible(null);
        activityIdleInternal(null, false, true, null);
    L10:
        if (rootTask.getParent() != null) goto L12;
        return;
    L12:
        DisplayContent toDisplay = this.mRootWindowContainer.getDisplayContent(0);
        this.mService.deferWindowLayout();
        rootTask.setRootTaskWindowingMode(0);     // Catch: Throwable -> L16
        if (rootTask.getWindowingMode() == 5) goto L18;
        rootTask.setBounds(null);     // Catch: Throwable -> L16
    L18:
        toDisplay.getDefaultTaskDisplayArea().positionTaskBehindHome(rootTask);     // Catch: Throwable -> L16
        rootTask.setForceHidden(1, false);     // Catch: Throwable -> L16
        this.mRootWindowContainer.ensureActivitiesVisible();     // Catch: Throwable -> L16
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();     // Catch: Throwable -> L16
        this.mService.continueWindowLayout();
        return;
    L16:
        th = move-exception;
        this.mService.continueWindowLayout();
        throw th;
    L5:
        transition.collect(rootTask);
        goto L6
    }

    void removeRootTask(Task rootTask) {
        if (rootTask.getWindowingMode() != 2) goto L5;
        removePinnedRootTaskInSurfaceTransaction(rootTask);
        return;
    L5:
        rootTask.forAllLeafTasks(new ActivityTaskSupervisor$$ExternalSyntheticLambda7(this), true);
    }

    private /* synthetic */ void lambda$removeRootTask$4(Task task) {
        removeTask(task, true, true, "remove-root-task");
    }

    boolean removeTaskById(int taskId, boolean killProcess, boolean removeFromRecents, String reason, int callingUid, int callingPid) {
        Task task = this.mRootWindowContainer.anyTaskForId(taskId, 1);
        if (task == null) goto L6;
        removeTask(task, killProcess, removeFromRecents, reason, callingUid, callingPid, null);
        return true;
    L6:
        Slog.w("ActivityTaskManager", "Request to remove task ignored for non-existent task " + taskId);
        return false;
    }

    void removeTask(Task task, boolean killProcess, boolean removeFromRecents, String reason) {
        removeTask(task, killProcess, removeFromRecents, reason, 1000, -1, null);
    }

    void removeTask(Task task, boolean killProcess, boolean removeFromRecents, String reason, int callingUid, int callingPid, String callerActivityClassName) {
        if (task.mInRemoveTask == false) goto L5;
        return;
    L5:
        this.mWindowManager.getObricExt().onTaskRemovedBeforeFocusChanged(task.getTaskInfo());
        getExt().onTaskRemoved(task, reason);
        Transition transit = task.mTransitionController.requestCloseTransitionIfNeeded(task);
        if (transit == null) goto L10;
        transit.collectClose(task);
        if (task.mTransitionController.useFullReadyTracking() == true) goto L13;
        transit.setReady(task, true);
    L13:
        if (killProcess == false) goto L31;
        ArrayList<ActivityRecord> activities = null;
        int i = this.mStoppingActivities.size() - 1;
    L15:
        if (i < 0) goto L27;
        ActivityRecord r = this.mStoppingActivities.get(i);
        if (r.finishing == true) goto L25;
        if (r.isState(ActivityRecord.State.RESUMED) == false) goto L25;
        if (r.getTask() != task) goto L25;
        if (activities != null) goto L24;
        activities = new ArrayList();
    L24:
        activities.add(r);
        this.mStoppingActivities.remove(i);
    L25:
        i = i - 1;
        goto L15
    L27:
        if (activities == null) goto L31;
        int i2 = activities.size() - 1;
    L29:
        if (i2 < 0) goto L31;
        activities.get(i2).stopIfPossible();
        i2 = i2 - 1;
    L31:
        task.mInRemoveTask = true;
        task.getExt().handleRemoveTask(reason);     // Catch: Throwable -> L35
        task.removeActivities(reason, false);     // Catch: Throwable -> L35
        cleanUpRemovedTask(task, killProcess, removeFromRecents, callingUid);     // Catch: Throwable -> L35
        this.mService.getLockTaskController().clearLockedTask(task);     // Catch: Throwable -> L35
        this.mService.getTaskChangeNotificationController().notifyTaskStackChanged();     // Catch: Throwable -> L35
        if (task.isPersistable == false) goto L37;
        this.mService.notifyTaskPersisterLocked(null, true);     // Catch: Throwable -> L35
    L37:
        this.mBalController.checkActivityAllowedToClearTask(task, callingUid, callingPid, callerActivityClassName);     // Catch: Throwable -> L35
        task.mInRemoveTask = false;
        return;
    L35:
        th = move-exception;
        task.mInRemoveTask = false;
        throw th;
    L10:
        Transition transit2 = task.mTransitionController.getCollectingTransition();
        if (transit2 == null) goto L13;
        transit2.collectClose(task);
        goto L13
    }

    static CharSequence getApplicationLabel(PackageManager pm, String packageName) {
        ApplicationInfo launchedFromPackageInfo = pm.getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(0));     // Catch: PackageManager.NameNotFoundException -> L5
        return pm.getApplicationLabel(launchedFromPackageInfo);
    L6:
        return packageName;
    }

    private void cleanUpRemovedTask(Task task, boolean killProcess, boolean removeFromRecents) {
        cleanUpRemovedTask(task, killProcess, removeFromRecents, 0);
    }

    private void cleanUpRemovedTask(Task task, boolean killProcess, boolean removeFromRecents, int callingUid) {
        if (removeFromRecents == false) goto L4;
        this.mRecentTasks.remove(task);
    L4:
        Intent baseIntent = task.getBaseIntent();
        if (baseIntent == null) goto L7;
        ComponentName component = baseIntent.getComponent();
    L8:
        if (component != null) goto L11;
        Slog.w("ActivityTaskManager", "No component for base intent of task: " + task);
        return;
    L11:
        Message msg = PooledLambda.obtainMessage(new ActivityTaskSupervisor$$ExternalSyntheticLambda0(), this.mService.mAmInternal, Integer.valueOf(task.mUserId), component, new Intent(baseIntent));
        this.mService.mH.sendMessage(msg);
        if (killProcess == true) goto L14;
        return;
    L14:
        ActivityRecord top = task.getTopMostActivity();
        if (top != null) goto L17;
    L28:
        killTaskProcessesIfPossible(task, callingUid);
        if (removeFromRecents == false) goto L32;
        SysOptBridge.getFactory().getSysPrefetchService().addRecentPrefetch(task.getBasePackageName());
        return;
    L32:
        return;
    L17:
        if (top.finishing == false) goto L28;
        if (top.mAppStopped == true) goto L28;
        if (top.lastVisibleTime <= 0) goto L28;
        if (task.mKillProcessesOnDestroyed == true) goto L28;
        if (top.hasProcess() == false) goto L28;
        task.mKillProcessesOnDestroyed = true;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(206, task), 1000);
        return;
    L7:
        component = null;
        goto L8
    }

    void removeTimeoutOfKillProcessesOnProcessDied(ActivityRecord r, Task task) {
        if (r.packageName.equals(task.getBasePackageName()) == false) goto L6;
        task.mKillProcessesOnDestroyed = false;
        this.mHandler.removeMessages(206, task);
        return;
    }

    void killTaskProcessesOnDestroyedIfNeeded(Task task) {
        if (task != null) goto L4;
        return;
    L4:
        if (task.mKillProcessesOnDestroyed == false) goto L12;
        final int[] numDestroyingActivities = new int[1];
        task.forAllActivities(new ActivityTaskSupervisor$$ExternalSyntheticLambda8(numDestroyingActivities));
        if (numDestroyingActivities[0] <= 1) goto L9;
        return;
    L9:
        this.mHandler.removeMessages(206, task);
        killTaskProcessesIfPossible(task);
        return;
    }

    private static /* synthetic */ void lambda$killTaskProcessesOnDestroyedIfNeeded$5(int[] numDestroyingActivities, ActivityRecord r) {
        if (r.finishing == true) goto L5;
        return;
    L5:
        if (r.lastVisibleTime > 0) goto L7;
        return;
    L7:
        if (r.attachedToProcess() == false) goto L12;
        numDestroyingActivities[0] = numDestroyingActivities[0] + 1;
        return;
    }

    private void killTaskProcessesIfPossible(Task task) {
        killTaskProcessesIfPossible(task, 0);
    }

    private void killTaskProcessesIfPossible(Task task, int callingUid) {
        task.mKillProcessesOnDestroyed = false;
        String pkg = task.getBasePackageName();
        ArrayList<Object> procsToKill = null;
        ArrayMap<String, SparseArray<WindowProcessController>> pmap = this.mService.mProcessNames.getMap();
        int i = 0;
    L4:
        if (i >= pmap.size()) goto L29;
        SparseArray<WindowProcessController> uids = pmap.valueAt(i);
        int j = 0;
    L7:
        if (j >= uids.size()) goto L27;
        WindowProcessController proc = uids.valueAt(j);
        if (proc.mUserId != task.mUserId) goto L26;
        if (proc == this.mService.mHomeProcess) goto L26;
        if (proc.containsPackage(pkg) == false) goto L26;
        if (proc.shouldKillProcessForRemovedTask(task) == false) goto L19;
        if (proc.hasForegroundServices() == true) goto L22;
        if (procsToKill != null) goto L25;
        procsToKill = new ArrayList();
    L25:
        procsToKill.add(proc);
        goto L26
    L22:
        return;
    L19:
        return;
    L26:
        j = j + 1;
        goto L7
    L27:
        i = i + 1;
        goto L4
    L29:
        if (procsToKill != null) goto L31;
        return;
    L31:
        if (pkg == null) goto L33;
        SysOptBridge.getFactory().getProcessIntercept().updatePackagesKilledTimeIfNeeded(pkg, callingUid);
    L33:
        Message m = PooledLambda.obtainMessage(new ActivityTaskSupervisor$$ExternalSyntheticLambda5(), this.mService.mAmInternal, procsToKill);
        this.mService.mH.sendMessage(m);
    }

    public void startPreferredApps() {
        new PreferredAppsTask(this).execute(new Void[0]);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.v("ActivityTaskManager", "Exception while calling PreferredAppsTask: " + e);
    }

    boolean restoreRecentTaskLocked(Task task, ActivityOptions aOptions, boolean onTop) {
        Task rootTask = this.mRootWindowContainer.getOrCreateRootTask(null, aOptions, task, onTop);
        WindowContainer parent = task.getParent();
        if (parent == rootTask) goto L13;
        if (task == rootTask) goto L13;
        if (parent == null) goto L9;
        task.reparent(rootTask, Integer.MAX_VALUE, true, "restoreRecentTaskLocked");
        return true;
    L9:
        rootTask.addChild(task, onTop, true);
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L12;
        Slog.v("ActivityTaskManager", "Added restored task=" + task + " to root task=" + rootTask);
    L12:
        return true;
    L13:
        return true;
    }

    @Override // com.android.server.wm.RecentTasks.Callbacks
    public void onRecentTaskAdded(Task task) {
        task.touchActiveTime();
    }

    @Override // com.android.server.wm.RecentTasks.Callbacks
    public void onRecentTaskRemoved(Task task, boolean wasTrimmed, boolean killProcess) {
        if (wasTrimmed == false) goto L5;
        removeTaskById(task.mTaskId, killProcess, false, "recent-task-trimmed", 1000, -1);
    L5:
        task.removedFromRecents();
    }

    Task getReparentTargetRootTask(Task task, Task rootTask, boolean toTop) {
        Task prevRootTask = task.getRootTask();
        int rootTaskId = rootTask.mTaskId;
        boolean inMultiWindowMode = rootTask.inMultiWindowMode();
        if (prevRootTask != null) goto L5;
    L8:
        if (inMultiWindowMode == false) goto L15;
        if (this.mService.mSupportsMultiWindow == true) goto L15;
        throw new IllegalArgumentException("Device doesn't support multi-window, can not reparent task=" + task + " to root-task=" + rootTask);
    L15:
        if (rootTask.getDisplayId() == 0) goto L22;
        if (this.mService.mSupportsMultiDisplay == true) goto L22;
        throw new IllegalArgumentException("Device doesn't support multi-display, can not reparent task=" + task + " to rootTaskId=" + rootTaskId);
    L22:
        if (rootTask.getWindowingMode() != 5) goto L29;
        if (this.mService.mSupportsFreeformWindowManagement == true) goto L29;
        throw new IllegalArgumentException("Device doesn't support freeform, can not reparent task=" + task);
    L29:
        if (rootTask.inPinnedWindowingMode() == true) goto L39;
        if (inMultiWindowMode == true) goto L32;
        return rootTask;
    L32:
        if (task.supportsMultiWindowInDisplayArea(rootTask.getDisplayArea()) == true) goto L41;
        Slog.w("ActivityTaskManager", "Can not move unresizeable task=" + task + " to multi-window root task=" + rootTask + " Moving to a fullscreen root task instead.");
        if (prevRootTask == null) goto L37;
        return prevRootTask;
    L37:
        return rootTask.getDisplayArea().createRootTask(1, rootTask.getActivityType(), toTop);
    L41:
        return rootTask;
    L39:
        throw new IllegalArgumentException("No support to reparent to PIP, task=" + task);
    L5:
        if (prevRootTask.mTaskId != rootTaskId) goto L8;
        Slog.w("ActivityTaskManager", "Can not reparent to same root task, task=" + task + " already in rootTaskId=" + rootTaskId + " by " + Debug.getCallers(8));
        return prevRootTask;
    }

    void goingToSleepLocked() {
        scheduleSleepTimeout();
        if (this.mGoingToSleepWakeLock.isHeld() == true) goto L7;
        this.mGoingToSleepWakeLock.acquire();
        if (this.mLaunchingActivityWakeLock.isHeld() == false) goto L7;
        this.mLaunchingActivityWakeLock.release();
        this.mHandler.removeMessages(204);
    L7:
        this.mRootWindowContainer.applySleepTokens(false);
        checkReadyForSleepLocked(true);
    }

    boolean shutdownLocked(int timeout) {
        goingToSleepLocked();
        boolean timedout = false;
        long endTime = System.currentTimeMillis() + ((long) timeout);
    L4:
        if (this.mRootWindowContainer.putTasksToSleep(true, true) == true) goto L13;
        long timeRemaining = endTime - System.currentTimeMillis();
        if (timeRemaining <= 0) goto L12;
        this.mService.mGlobalLock.wait(timeRemaining);     // Catch: InterruptedException -> L9
        goto L4
    L12:
        Slog.w("ActivityTaskManager", "Activity manager shutdown timed out");
        timedout = true;
    L13:
        long timeRemaining2 = System.currentTimeMillis();
        TaskSnapshotController r5 = this.mWindowManager.mSnapshotController.mTaskSnapshotController;
        r5.waitFlush(endTime - timeRemaining2);
        checkReadyForSleepLocked(false);
        return timedout;
    }

    void acquireAppLaunchPerfLock(ActivityRecord r) {
        if (this.mPerfBoost == null) goto L51;
        int pkgType = this.mPerfBoost.perfGetFeedback(5633, r.packageName);
        if (this.mService != null) goto L7;
    L15:
        int wpcPid = -1;
    L17:
        if (this.mPerfBoost.board_first_api_lvl > 202404) goto L35;
        if (this.mPerfBoost.board_api_lvl > 202404) goto L35;
        if (this.mPerfBoost.getPerfHalVersion() < 2.299999952316284d) goto L28;
        this.mPerfBoost.perfHintAcqRel(-1, 4225, r.packageName, -1, 1, 2, new int[]{pkgType, wpcPid});
        mPerfSendTapHint = true;
        this.mPerfBoost.perfHintAcqRel(-1, 4225, r.packageName, -1, 2, 2, new int[]{pkgType, wpcPid});
        if (wpcPid == (-1)) goto L25;
        this.mPerfBoost.perfHintAcqRel(-1, 4225, r.packageName, wpcPid, 103, 2, new int[]{pkgType, wpcPid});
    L25:
        if (pkgType != 2) goto L27;
        mPerfHandle = this.mPerfBoost.perfHintAcqRel(-1, 4225, r.packageName, -1, 4, 2, new int[]{pkgType, wpcPid});
    L39:
        if (mPerfHandle <= 0) goto L42;
        mIsPerfBoostAcquired = true;
    L42:
        if (r.info.applicationInfo != null) goto L44;
        return;
    L44:
        if (r.info.applicationInfo.sourceDir != null) goto L46;
        return;
    L46:
        if (this.mPerfBoost.board_first_api_lvl < 33) goto L48;
        return;
    L48:
        if (this.mPerfBoost.board_api_lvl >= 33) goto L55;
        this.mPerfBoost.perfIOPrefetchStart(-1, r.packageName, r.info.applicationInfo.sourceDir.substring(0, r.info.applicationInfo.sourceDir.lastIndexOf(47)));
        return;
    L55:
        return;
    L27:
        mPerfHandle = this.mPerfBoost.perfHintAcqRel(-1, 4225, r.packageName, -1, 3, 2, new int[]{pkgType, wpcPid});
        goto L39
    L28:
        this.mPerfBoost.perfHint(4225, r.packageName, -1, 1);
        mPerfSendTapHint = true;
        this.mPerfBoost.perfHint(4225, r.packageName, -1, 2);
        if (wpcPid == (-1)) goto L31;
        this.mPerfBoost.perfHint(4225, r.packageName, wpcPid, 103);
    L31:
        if (pkgType != 2) goto L33;
        mPerfHandle = this.mPerfBoost.perfHint(4225, r.packageName, -1, 4);
        goto L39
    L33:
        mPerfHandle = this.mPerfBoost.perfHint(4225, r.packageName, -1, 3);
    L35:
        if (this.mPerfBoost.getPerfHalVersion() < 2.299999952316284d) goto L37;
        this.mPerfBoost.perfHintAcqRel(-1, 4225, r.packageName, wpcPid, 1, 2, new int[]{pkgType, wpcPid});
        goto L39
    L37:
        this.mPerfBoost.perfHint(4225, r.packageName, wpcPid, 1);
        goto L39
    L7:
        if (r.info == null) goto L15;
        if (r.info.applicationInfo == null) goto L15;
        WindowProcessController wpc = this.mService.getProcessController(r.processName, r.info.applicationInfo.uid);
        if (wpc == null) goto L15;
        if (wpc.hasThread() == false) goto L15;
        int wpcPid2 = wpc.getPid();
        wpcPid = wpcPid2;
        goto L17
    }

    public ActivityRecord getTopResumedActivity() {
        return this.mTopResumedActivity;
    }

    void comeOutOfSleepIfNeededLocked() {
        removeSleepTimeouts();
        if (this.mGoingToSleepWakeLock.isHeld() == false) goto L6;
        this.mGoingToSleepWakeLock.release();
        return;
    }

    void checkReadyForSleepLocked(boolean allowDelay) {
        if (this.mService.isSleepingOrShuttingDownLocked() == true) goto L6;
        return;
    L6:
        if (this.mRootWindowContainer.putTasksToSleep(allowDelay, false) == true) goto L8;
        return;
    L8:
        this.mService.endPowerMode(3);
        this.mRootWindowContainer.rankTaskLayers();
        removeSleepTimeouts();
        if (this.mGoingToSleepWakeLock.isHeld() == false) goto L12;
        this.mGoingToSleepWakeLock.release();
    L12:
        if (this.mService.mShuttingDown == false) goto L15;
        this.mService.mGlobalLock.notifyAll();
        return;
    }

    private void handleLaunchTaskBehindCompleteLocked(ActivityRecord r) {
        Task task = r.getTask();
        Task rootTask = task.getRootTask();
        this.mRecentTasks.add(task);
        this.mService.getTaskChangeNotificationController().notifyTaskStackChanged();
        rootTask.ensureActivitiesVisible(null);
        ActivityRecord top = rootTask.getTopNonFinishingActivity();
        if (top == null) goto L6;
        top.getTask().touchActiveTime();
        return;
    }

    void scheduleLaunchTaskBehindComplete(IBinder token) {
        this.mHandler.obtainMessage(212, token).sendToTarget();
    }

    void processStoppingAndFinishingActivities(ActivityRecord launchedActivity, boolean processPausingActivities, String reason) {
        ArrayList<ActivityRecord> readyToStopActivities = null;
        int i = 0;
    L3:
        int numReadyStops = 0;
        if (i >= this.mStoppingActivities.size()) goto L34;
        ActivityRecord s = this.mStoppingActivities.get(i);
        if (s.isInTransition() == true) goto L8;
    L12:
        boolean animating = false;
    L14:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L17;
        String protoLogParam0 = String.valueOf(s);
        boolean protoLogParam1 = s.nowVisible;
        boolean protoLogParam2 = animating;
        String protoLogParam3 = String.valueOf(s.finishing);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 1496536241884839051L, 60, new Object[]{protoLogParam0, Boolean.valueOf(protoLogParam1), Boolean.valueOf(protoLogParam2), protoLogParam3});
    L17:
        if (animating == true) goto L19;
    L22:
        if (processPausingActivities == true) goto L27;
        if (s.isState(ActivityRecord.State.PAUSING) == false) goto L27;
        removeIdleTimeoutForActivity(launchedActivity);
        scheduleIdleTimeout(launchedActivity);
    L32:
        i = i + 1;
    L27:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L29;
        String protoLogParam4 = String.valueOf(s);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 5677125188685281770L, 0, new Object[]{protoLogParam4});
    L29:
        if (readyToStopActivities != null) goto L31;
        readyToStopActivities = new ArrayList();
    L31:
        readyToStopActivities.add(s);
        this.mStoppingActivities.remove(i);
        i = i - 1;
        goto L32
    L19:
        if (this.mService.mShuttingDown == true) goto L22;
        if (s.getRootTask().isForceHiddenForPinnedTask() == false) goto L32;
    L8:
        if (s.getTask() == null) goto L12;
        if (s.getTask().isForceHidden() == true) goto L12;
        animating = true;
        goto L14
    L34:
        if (readyToStopActivities == null) goto L37;
        numReadyStops = readyToStopActivities.size();
    L37:
        int i2 = 0;
    L38:
        if (i2 >= numReadyStops) goto L46;
        ActivityRecord r = readyToStopActivities.get(i2);
        if (r.isInHistory() == false) goto L45;
        if (r.finishing == false) goto L44;
        r.destroyIfPossible(reason);
        goto L45
    L44:
        r.stopIfPossible();
    L45:
        i2 = i2 + 1;
        goto L38
    L46:
        int numFinishingActivities = this.mFinishingActivities.size();
        if (numFinishingActivities != 0) goto L49;
        return;
    L49:
        ArrayList<ActivityRecord> finishingActivities = new ArrayList(this.mFinishingActivities);
        this.mFinishingActivities.clear();
        int i3 = 0;
    L50:
        if (i3 >= numFinishingActivities) goto L56;
        ActivityRecord r2 = finishingActivities.get(i3);
        if (r2.isInHistory() == false) goto L54;
        r2.destroyImmediately("finish-" + reason);
    L54:
        i3 = i3 + 1;
        goto L50
    }

    void removeHistoryRecords(WindowProcessController app) {
        removeHistoryRecords(this.mStoppingActivities, app, "mStoppingActivities");
        removeHistoryRecords(this.mFinishingActivities, app, "mFinishingActivities");
        removeHistoryRecords(this.mNoHistoryActivities, app, "mNoHistoryActivities");
    }

    private void removeHistoryRecords(ArrayList<ActivityRecord> list, WindowProcessController app, String listName) {
        int i = list.size();
        if (ActivityTaskManagerDebugConfig.DEBUG_CLEANUP == false) goto L5;
        Slog.v("ActivityTaskManager", "Removing app " + this + " from list " + listName + " with " + i + " entries");
    L5:
        if (i <= 0) goto L16;
        i = i - 1;
        ActivityRecord r = list.get(i);
        if (ActivityTaskManagerDebugConfig.DEBUG_CLEANUP == false) goto L10;
        Slog.v("ActivityTaskManager", "Record #" + i + " " + r);
    L10:
        if (r.app != app) goto L5;
        if (ActivityTaskManagerDebugConfig.DEBUG_CLEANUP == false) goto L14;
        Slog.v("ActivityTaskManager", "---> REMOVING this entry!");
    L14:
        list.remove(i);
        r.removeTimeouts();
        goto L5
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.println();
        pw.println("ActivityTaskSupervisor state:");
        this.mRootWindowContainer.dump(pw, prefix, true);
        getKeyguardController().dump(pw, prefix);
        this.mService.getLockTaskController().dump(pw, prefix);
        pw.print(prefix);
        pw.println("mCurTaskIdForUser=" + this.mCurTaskIdForUser);
        pw.println(prefix + "mUserRootTaskInFront=" + this.mRootWindowContainer.mUserRootTaskInFront);
        pw.println(prefix + "mVisibilityTransactionDepth=" + this.mVisibilityTransactionDepth);
        pw.print(prefix);
        pw.print("isHomeRecentsComponent=");
        pw.println(this.mRecentTasks.isRecentsComponentHomeActivity(this.mRootWindowContainer.mCurrentUser));
        if (this.mWaitingActivityLaunched.isEmpty() == true) goto L7;
        pw.println(prefix + "mWaitingActivityLaunched=");
        int i = this.mWaitingActivityLaunched.size() - 1;
    L5:
        if (i < 0) goto L7;
        this.mWaitingActivityLaunched.get(i).dump(pw, prefix + "  ");
        i = i + (-1);
    L7:
        pw.println(prefix + "mNoHistoryActivities=" + this.mNoHistoryActivities);
        pw.println();
    }

    static boolean printThisActivity(PrintWriter pw, ActivityRecord activity, String dumpPackage, boolean needSep, String prefix, Runnable header) {
        return printThisActivity(pw, activity, dumpPackage, -1, needSep, prefix, header);
    }

    static boolean printThisActivity(PrintWriter pw, ActivityRecord activity, String dumpPackage, int displayIdFilter, boolean needSep, String prefix, Runnable header) {
        if (activity != null) goto L4;
        return false;
    L4:
        if (displayIdFilter != (-1)) goto L6;
    L7:
        if (dumpPackage != null) goto L9;
    L10:
        if (needSep == false) goto L12;
        pw.println();
    L12:
        if (header == null) goto L14;
        header.run();
    L14:
        pw.print(prefix);
        pw.println(activity);
        return true;
    L9:
        if (dumpPackage.equals(activity.packageName) == true) goto L10;
        return false;
    L6:
        if (displayIdFilter == activity.getDisplayId()) goto L7;
        return false;
    }

    static boolean dumpHistoryList(FileDescriptor fd, PrintWriter pw, List<ActivityRecord> list, String prefix, String label, boolean complete, boolean brief, boolean client, String dumpPackage, boolean needNL, Runnable header, Task lastTask) {
        boolean needNL2 = needNL;
        Runnable header2 = header;
        Task lastTask2 = lastTask;
        int i = list.size() - 1;
    L3:
        if (i < 0) goto L12;
        ActivityRecord r = list.get(i);
        ActivityRecord.dumpActivity(fd, pw, i, r, prefix, label, complete, brief, client, dumpPackage, needNL2, header2, lastTask2);
        lastTask2 = r.getTask();
        header2 = null;
        if (client == true) goto L7;
    L9:
        boolean r3 = false;
    L10:
        needNL2 = r3;
        i = i - 1;
        goto L3
    L7:
        if (r.attachedToProcess() == false) goto L9;
        r3 = true;
        goto L10
    L12:
        return false;
    }

    void scheduleIdleTimeout(ActivityRecord next) {
        if (ActivityTaskManagerDebugConfig.DEBUG_IDLE == false) goto L5;
        Slog.d("ActivityTaskManager", "scheduleIdleTimeout: Callers=" + Debug.getCallers(4));
    L5:
        Message msg = this.mHandler.obtainMessage(200, next);
        this.mHandler.sendMessageDelayed(msg, IDLE_TIMEOUT);
    }

    final void scheduleIdle() {
        if (this.mHandler.hasMessages(201) == false) goto L5;
        return;
    L5:
        if (ActivityTaskManagerDebugConfig.DEBUG_IDLE == false) goto L8;
        Slog.d("ActivityTaskManager", "scheduleIdle: Callers=" + Debug.getCallers(4));
    L8:
        if (this.mService.isSleepingLocked() == true) goto L10;
    L12:
        long delayMs = 0;
    L13:
        this.mHandler.sendEmptyMessageDelayed(201, delayMs);
        return;
    L10:
        if (this.mService.mayBeLaunchingApp() == false) goto L12;
        delayMs = 100;
        goto L13
    }

    ActivityRecord updateTopResumedActivityIfNeeded(String reason) {
        ActivityRecord prevTopActivity = this.mTopResumedActivity;
        Task topRootTask = this.mRootWindowContainer.getTopDisplayFocusedRootTask();
        if (topRootTask == null) goto L56;
        if (topRootTask.getTopResumedActivity() == prevTopActivity) goto L56;
        if ("PREFETCH_APP".equals(topRootTask.getDisplayContent().mDisplay.getName()) == false) goto L12;
        Slog.i("ActivityTaskManager", "just resume vd and return when prefetch");     // Catch: Exception -> L11
        return this.mTopResumedActivity;
    L12:
        scheduleTopResumedActivityStateLossIfNeeded();
        this.mTopResumedActivity = topRootTask.getTopResumedActivity();
        if (topRootTask.getDisplayId() != 0) goto L16;
        this.mPrimaryDisplayLastRecord = this.mTopResumedActivity;
    L16:
        if (this.mTopResumedActivity == null) goto L21;
        if (topRootTask.getDisplayId() != 0) goto L21;
        SysOptBridge.getFactory().getSysPrefetchService().updateTopResumedApp(this.mTopResumedActivity.packageName);
    L21:
        if (this.mTopResumedActivity == null) goto L26;
        if ("PREFETCH_APP".equals(topRootTask.getDisplayContent().mDisplay.getName()) == true) goto L26;
        SysOptBridge.getFactory().getAppOpsServiceSysEx().updateMutedApp(this.mTopResumedActivity.getUid(), this.mTopResumedActivity.packageName, false);
    L26:
        if (this.mTopResumedActivity == null) goto L33;
        if (prevTopActivity == null) goto L33;
        if (this.mTopResumedActivity.app == null) goto L31;
        this.mTopResumedActivity.app.addToPendingTop();
    L31:
        this.mService.updateOomAdj();
    L33:
        if (this.mTopResumedActivity == null) goto L36;
        SysOptBridge.getFactory().getAppRecordManagerService().updateTopResumedComponent(this.mTopResumedActivity.shortComponentName);
    L36:
        if (this.mTopResumedActivity == null) goto L45;
        this.mService.setLastResumedActivityUncheckLocked(this.mTopResumedActivity, reason);
        Object o = null;
        if (this.mTopResumedActivity != null) goto L40;
    L42:
        SysOptBridge.getFactory().getXBTest().onTopResumedEvent(this.mTopResumedActivity, o);
        if (this.mTopResumedActivity == null) goto L45;
        SysOptBridge.getFactory().getDynamicRefreshRateService().onTopResumedActivityChangedLocked(this.mTopResumedActivity);
        goto L45
    L40:
        if (this.mTopResumedActivity.app == null) goto L42;
        o = this.mTopResumedActivity.app.mOwner;
    L45:
        scheduleTopResumedActivityStateIfNeeded();
        if (this.mTopResumedActivity == null) goto L48;
    L49:
        this.mService.updateTopApp(this.mTopResumedActivity);
    L51:
        if ("PREFETCH_APP".equals(topRootTask.getDisplayContent().mDisplay.getName()) == false) goto L54;
        this.mTopResumedActivity = this.mPrimaryDisplayLastRecord;
    L54:
        return this.mTopResumedActivity;
    L48:
        if (this.mService.isSleepingLocked() == false) goto L51;
    L56:
        if (topRootTask != null) goto L59;
        scheduleTopResumedActivityStateLossIfNeeded();
        this.mTopResumedActivity = null;
    L59:
        if (this.mService.isSleepingLocked() == false) goto L62;
        this.mService.updateTopApp(null);
    L62:
        return this.mTopResumedActivity;
    }

    private void scheduleTopResumedActivityStateLossIfNeeded() {
        if (this.mLastReportedTopResumedActivity != null) goto L6;
        return;
    L6:
        if (this.mTopResumedActivityWaitingForPrev == false) goto L8;
        return;
    L8:
        if (readyToResume() == true) goto L10;
        return;
    L10:
        if (this.mLastReportedTopResumedActivity.scheduleTopResumedActivityChanged(false) == false) goto L15;
        scheduleTopResumedStateLossTimeout(this.mLastReportedTopResumedActivity);
        this.mTopResumedActivityWaitingForPrev = true;
        this.mLastReportedTopResumedActivity = null;
        return;
    }

    private void scheduleTopResumedActivityStateIfNeeded() {
        if (this.mTopResumedActivity != null) goto L5;
        return;
    L5:
        if (this.mTopResumedActivityWaitingForPrev == false) goto L7;
        return;
    L7:
        if (readyToResume() == false) goto L12;
        this.mTopResumedActivity.scheduleTopResumedActivityChanged(true);
        this.mLastReportedTopResumedActivity = this.mTopResumedActivity;
        return;
    }

    private void scheduleTopResumedStateLossTimeout(ActivityRecord r) {
        Message msg = this.mHandler.obtainMessage(217);
        msg.obj = r;
        r.topResumedStateLossTime = SystemClock.uptimeMillis();
        this.mHandler.sendMessageDelayed(msg, 500);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L6;
        String protoLogParam0 = String.valueOf(r);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 3604633008357193496L, 0, new Object[]{protoLogParam0});
        return;
    }

    void handleTopResumedStateReleased(boolean timeout) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L8;
        if (timeout == false) goto L6;
        String r0 = "(due to timeout)";
    L7:
        String protoLogParam0 = String.valueOf(r0);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 3997062844427155487L, 0, new Object[]{protoLogParam0});
        goto L8
    L6:
        r0 = "(transition complete)";
    L8:
        this.mHandler.removeMessages(217);
        if (this.mTopResumedActivityWaitingForPrev == true) goto L11;
        return;
    L11:
        this.mTopResumedActivityWaitingForPrev = false;
        scheduleTopResumedActivityStateIfNeeded();
    }

    void removeIdleTimeoutForActivity(ActivityRecord r) {
        if (ActivityTaskManagerDebugConfig.DEBUG_IDLE == false) goto L5;
        Slog.d("ActivityTaskManager", "removeTimeoutsForActivity: Callers=" + Debug.getCallers(4));
    L5:
        this.mHandler.removeMessages(200, r);
    }

    final void scheduleResumeTopActivities() {
        if (this.mHandler.hasMessages(202) == true) goto L6;
        this.mHandler.sendEmptyMessage(202);
        return;
    }

    void scheduleProcessStoppingAndFinishingActivitiesIfNeeded() {
        if (this.mStoppingActivities.isEmpty() == false) goto L8;
        if (this.mFinishingActivities.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.mRootWindowContainer.allResumedActivitiesIdle() == false) goto L12;
        scheduleIdle();
        return;
    L12:
        if (this.mHandler.hasMessages(205) == false) goto L14;
        return;
    L14:
        if (this.mRootWindowContainer.allResumedActivitiesVisible() == false) goto L18;
        this.mHandler.sendEmptyMessage(205);
        return;
    }

    void removeSleepTimeouts() {
        this.mHandler.removeMessages(203);
    }

    final void scheduleSleepTimeout() {
        removeSleepTimeouts();
        this.mHandler.sendEmptyMessageDelayed(203, SLEEP_TIMEOUT);
    }

    boolean hasScheduledRestartTimeouts(ActivityRecord r) {
        return this.mHandler.hasMessages(213, r);
    }

    void removeRestartTimeouts(ActivityRecord r) {
        this.mHandler.removeMessages(213, r);
    }

    final void scheduleRestartTimeout(ActivityRecord r) {
        removeRestartTimeouts(r);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(213, r), ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);
    }

    void handleNonResizableTaskIfNeeded(Task task, int preferredWindowingMode, TaskDisplayArea preferredTaskDisplayArea, Task actualRootTask) {
        handleNonResizableTaskIfNeeded(task, preferredWindowingMode, preferredTaskDisplayArea, actualRootTask, false);
    }

    void handleNonResizableTaskIfNeeded(Task task, int preferredWindowingMode, TaskDisplayArea preferredTaskDisplayArea, Task actualRootTask, boolean forceNonResizable) {
        if (preferredTaskDisplayArea != null) goto L5;
    L7:
        boolean isSecondaryDisplayPreferred = false;
    L9:
        if (task.isActivityTypeStandardOrUndefined() == true) goto L11;
        return;
    L11:
        if (isSecondaryDisplayPreferred == true) goto L13;
        if (forceNonResizable == true) goto L27;
        handleForcedResizableTaskIfNeeded(task, 1);
        return;
    L27:
        return;
    L13:
        if (task.canBeLaunchedOnDisplay(task.getDisplayId()) == false) goto L21;
        DisplayContent preferredDisplay = preferredTaskDisplayArea.mDisplayContent;
        if (preferredDisplay == task.getDisplayContent()) goto L17;
        Slog.w("ActivityTaskManager", "Failed to put " + task + " on display " + preferredDisplay.mDisplayId);
        this.mService.getTaskChangeNotificationController().notifyActivityLaunchOnSecondaryDisplayFailed(task.getTaskInfo(), preferredDisplay.mDisplayId);
        return;
    L17:
        if (forceNonResizable == true) goto L26;
        handleForcedResizableTaskIfNeeded(task, 2);
        return;
    L26:
        return;
    L21:
        throw new IllegalStateException("Task resolved to incompatible display");
    L5:
        if (preferredTaskDisplayArea.getDisplayId() == 0) goto L7;
        isSecondaryDisplayPreferred = true;
        goto L9
    }

    private void handleForcedResizableTaskIfNeeded(Task task, int reason) {
        ActivityRecord topActivity = task.getTopNonFinishingActivity();
        if (topActivity != null) goto L5;
        return;
    L5:
        if (topActivity.isNoDisplay() == false) goto L7;
        return;
    L7:
        if (topActivity.canForceResizeNonResizable(task.getWindowingMode()) == false) goto L13;
        this.mService.getTaskChangeNotificationController().notifyActivityForcedResizable(task.mTaskId, reason, topActivity.info.applicationInfo.packageName);
        return;
    }

    void scheduleUpdateMultiWindowMode(Task task) {
        task.forAllActivities(new ActivityTaskSupervisor$$ExternalSyntheticLambda2(this));
        if (this.mHandler.hasMessages(214) == true) goto L6;
        this.mHandler.sendEmptyMessage(214);
        return;
    }

    private /* synthetic */ void lambda$scheduleUpdateMultiWindowMode$6(ActivityRecord r) {
        if (r.attachedToProcess() == false) goto L6;
        this.mMultiWindowModeChangedActivities.add(r);
        return;
    }

    void scheduleUpdatePictureInPictureModeIfNeeded(Task task, Task prevRootTask) {
        Task rootTask = task.getRootTask();
        if (prevRootTask == null) goto L12;
        if (prevRootTask != rootTask) goto L6;
    L10:
        scheduleUpdatePictureInPictureModeIfNeeded(task, rootTask.getRequestedOverrideBounds());
        return;
    L6:
        if (prevRootTask.inPinnedWindowingMode() == true) goto L10;
        if (rootTask.inPinnedWindowingMode() == true) goto L10;
        return;
    }

    void scheduleUpdatePictureInPictureModeIfNeeded(Task task, Rect targetRootTaskBounds) {
        task.forAllActivities(new ActivityTaskSupervisor$$ExternalSyntheticLambda6(this));
        this.mPipModeChangedTargetRootTaskBounds = targetRootTaskBounds;
        if (this.mHandler.hasMessages(215) == true) goto L6;
        this.mHandler.sendEmptyMessage(215);
        return;
    }

    private /* synthetic */ void lambda$scheduleUpdatePictureInPictureModeIfNeeded$7(ActivityRecord r) {
        if (r.attachedToProcess() == true) goto L5;
        return;
    L5:
        this.mPipModeChangedActivities.add(r);
        this.mMultiWindowModeChangedActivities.remove(r);
    }

    void wakeUp(int displayId, String reason) {
        this.mPowerManager.wakeUp(SystemClock.uptimeMillis(), 2, "android.server.wm:TURN_ON:" + reason, displayId);
    }

    void beginActivityVisibilityUpdate() {
        if (this.mVisibilityTransactionDepth != 0) goto L5;
        getKeyguardController().updateVisibility();
    L5:
        this.mVisibilityTransactionDepth++;
    }

    void endActivityVisibilityUpdate() {
        this.mVisibilityTransactionDepth--;
        if (this.mVisibilityTransactionDepth != 0) goto L6;
        computeProcessActivityStateBatch();
        return;
    }

    boolean inActivityVisibilityUpdate() {
        if (this.mVisibilityTransactionDepth <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    void setDeferRootVisibilityUpdate(boolean deferUpdate) {
        this.mDeferRootVisibilityUpdate = deferUpdate;
    }

    boolean isRootVisibilityUpdateDeferred() {
        return this.mDeferRootVisibilityUpdate;
    }

    void onProcessActivityStateChanged(WindowProcessController wpc, boolean forceBatch) {
        if (forceBatch == true) goto L9;
        if (inActivityVisibilityUpdate() == true) goto L9;
        wpc.computeProcessActivityState();
        return;
    L9:
        if (this.mActivityStateChangedProcs.contains(wpc) == true) goto L12;
        this.mActivityStateChangedProcs.add(wpc);
        return;
    }

    boolean computeProcessActivityStateBatch() {
        if (this.mActivityStateChangedProcs.isEmpty() == false) goto L6;
        return false;
    L6:
        boolean changed = false;
        int i = this.mActivityStateChangedProcs.size() - 1;
    L7:
        if (i < 0) goto L14;
        WindowProcessController wpc = this.mActivityStateChangedProcs.get(i);
        int prevState = wpc.getActivityStateFlags();
        wpc.computeProcessActivityState();
        if (changed == true) goto L13;
        if (prevState == wpc.getActivityStateFlags()) goto L13;
        changed = true;
    L13:
        i = i - 1;
        goto L7
    L14:
        this.mActivityStateChangedProcs.clear();
        return changed;
    }

    void beginDeferResume() {
        this.mDeferResumeCount++;
    }

    void endDeferResume() {
        this.mDeferResumeCount--;
        if (readyToResume() == true) goto L5;
        return;
    L5:
        if (this.mLastReportedTopResumedActivity == null) goto L10;
        if (this.mTopResumedActivity == this.mLastReportedTopResumedActivity) goto L10;
        scheduleTopResumedActivityStateLossIfNeeded();
        return;
    L10:
        if (this.mLastReportedTopResumedActivity != null) goto L15;
        scheduleTopResumedActivityStateIfNeeded();
        return;
    }

    boolean readyToResume() {
        if (this.mDeferResumeCount != 0) goto L5;
        return true;
    L5:
        return false;
    }

    int startActivityFromRecents(int callingPid, int callingUid, int taskId, SafeActivityOptions options) {
        ActivityTaskSupervisor r1 = this;
        if (options == null) goto L5;
        ActivityOptions activityOptions = options.getOptions(r1);
    L6:
        WindowManagerGlobalLock r12 = r1.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r12);
        boolean moveHomeTaskForward = r1.mRecentTasks.isCallerRecents(callingUid);     // Catch: Throwable -> L193
        if (activityOptions != null) goto L245;
        int activityType = 0;
    L26:
        if (activityType == 2) goto L196;
        if (activityType == 3) goto L196;
        r1.mService.deferWindowLayout();     // Catch: Throwable -> L193
        if (Features.FEAT_QUICK_WIN == false) goto L220;
        r1.getExt().beforeStartActivityFromRecents();     // Catch: Throwable -> L17
    L17:
        th = th;
    L197:
        monitor-exit(r12);     // Catch: Throwable -> L187
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L220:
        Task task = r1.mRootWindowContainer.anyTaskForId(taskId, 2, activityOptions, true);     // Catch: Throwable -> L182
        if (task == null) goto L210;
        r1.getExt().prepareTaskForStartActivityFromRecents(task, activityOptions);     // Catch: Throwable -> L171
        if (task.getRootTask() != null) goto L232;
    L43:
        boolean moveHomeTaskForward2 = moveHomeTaskForward;
    L44:
        if (moveHomeTaskForward2 == false) goto L236;
        r1.mRootWindowContainer.getDefaultTaskDisplayArea().moveHomeRootTaskToFront("startActivityFromRecents");     // Catch: Throwable -> L47
    L47:
        th = th;
    L185:
        if (Features.FEAT_QUICK_WIN == false) goto L189;
        r1.getExt().afterStartActivityFromRecents();     // Catch: Throwable -> L187
    L189:
        if (0 != 0) goto L192;
        r1.mService.continueWindowLayout();     // Catch: Throwable -> L187
    L192:
        throw th;     // Catch: Throwable -> L187
    L236:
    L118:
        th = th;
        goto L185
    L50:
        if (r1.mService.mAmInternal.shouldConfirmCredentials(task.mUserId) == true) goto L241;
        if (task.getRootActivity() == null) goto L241;
        ActivityRecord targetActivity = task.getTopNonFinishingActivity();     // Catch: Throwable -> L118
        r1.mRootWindowContainer.startPowerModeLaunchIfNeeded(true, targetActivity);     // Catch: Throwable -> L118
        ActivityMetricsLogger r9 = r1.mActivityMetricsLogger;     // Catch: Throwable -> L118
        Intent r10 = task.intent;     // Catch: Throwable -> L118
        if (moveHomeTaskForward == false) goto L56;
        int r8 = -1;
    L57:
        ActivityMetricsLogger.LaunchingState launchingState = r9.notifyActivityLaunching(r10, null, r8);     // Catch: Throwable -> L118
        boolean prefetchAffected = false;
        if (targetActivity == null) goto L62;
        int prefetchState = SysOptBridge.getFactory().getSysPrefetchService().getPrefetchStateByInfo(targetActivity.packageName, targetActivity.getUid());     // Catch: Throwable -> L47
        prefetchAffected = SysMonitorFwBridge.getFactory().getPrefetchState().prefetchActivityNotShown(prefetchState);     // Catch: Throwable -> L47
    L62:
        int startType = SysOptBridge.getFactory().getAppRecordManagerService().getActivityStartType(targetActivity, prefetchAffected);     // Catch: Throwable -> L118
        SysOptBridge.getFactory().getIntelliScene().onActivityStartEventSync(targetActivity, startType, prefetchAffected);     // Catch: Throwable -> L118
        ActivityRecord targetActivity2 = targetActivity;
        r1.mService.moveTaskToFrontLocked(null, null, task.mTaskId, 0, options);     // Catch: Throwable -> L107
        if (activityOptions != null) goto L200;
    L74:
        targetActivity2.applyOptionsAnimation();     // Catch: Throwable -> L107
        if (activityOptions != null) goto L206;
    L84:
        r1 = this;
        r1.mActivityMetricsLogger.notifyActivityLaunched(launchingState, 2, false, targetActivity2, activityOptions);     // Catch: Throwable -> L92
        if (callingPid <= 0) goto L94;
        WindowProcessController wpc = r1.mService.mProcessMap.getProcess(callingPid);     // Catch: Throwable -> L92
        if (wpc == null) goto L94;
        targetActivity2.updateLaunchSourceType(callingUid, wpc);     // Catch: Throwable -> L92
    L94:
        r1.mService.getActivityStartController().postStartActivityProcessingForLastStarter(task.getTopNonFinishingActivity(), 2, task.getRootTask());     // Catch: Throwable -> L92
        r1.mService.resumeAppSwitches();     // Catch: Throwable -> L92
    L98:
        th = th;
        goto L197
    L96:
        if (Features.FEAT_QUICK_WIN == false) goto L100;
        r1.getExt().afterStartActivityFromRecents();     // Catch: Throwable -> L98
    L100:
        if (0 != 0) goto L102;
        r1.mService.continueWindowLayout();     // Catch: Throwable -> L98
    L102:
        monitor-exit(r12);     // Catch: Throwable -> L98
        WindowManagerService.resetPriorityAfterLockedSection();
        return 2;
    L92:
        th = th;
    L105:
        th = th;
        goto L185
    L206:
    L82:
        th = th;
        r1 = this;
    L73:
        targetActivity2 = targetActivity2;
    L226:
        r1.mActivityMetricsLogger.notifyActivityLaunched(launchingState, 2, false, targetActivity2, activityOptions);     // Catch: Throwable -> L116
        throw th;     // Catch: Throwable -> L114
    L114:
        th = th;
    L116:
        th = th;
        goto L185
    L77:
        if (activityOptions.getLaunchCookie() == null) goto L84;
        targetActivity2.mLaunchCookie = activityOptions.getLaunchCookie();     // Catch: Throwable -> L82
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L84;
        String protoLogParam0 = String.valueOf(targetActivity2.mLaunchCookie);     // Catch: Throwable -> L82
        String protoLogParam1 = String.valueOf(targetActivity2.packageName);     // Catch: Throwable -> L82
        long protoLogParam2 = System.identityHashCode(targetActivity2);     // Catch: Throwable -> L82
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 1483513556250210419L, 16, new Object[]{protoLogParam0, protoLogParam1, Long.valueOf(protoLogParam2)});     // Catch: Throwable -> L82
        goto L84
    L200:
    L72:
        th = th;
        goto L73
    L69:
        if (activityOptions.getAnimationType() != 13) goto L74;
        targetActivity2.mPendingRemoteAnimation = activityOptions.getRemoteAnimationAdapter();     // Catch: Throwable -> L72
    L107:
        th = th;
        targetActivity2 = targetActivity2;
    L109:
        th = th;
        goto L226
    L56:
        r8 = callingUid;
    L241:
    L126:
        th = th;
        goto L197
    L124:
        if (Features.FEAT_QUICK_WIN == false) goto L128;
        r1.getExt().afterStartActivityFromRecents();     // Catch: Throwable -> L126
    L128:
        if (1 != 0) goto L130;
        r1.mService.continueWindowLayout();     // Catch: Throwable -> L126
    L130:
        Task task2 = task;
        int taskCallingUid = task2.mCallingUid;     // Catch: Throwable -> L126
        String callingPackage = task2.mCallingPackage;     // Catch: Throwable -> L126
        String callingFeatureId = task2.mCallingFeatureId;     // Catch: Throwable -> L126
        Intent intent = task2.intent;     // Catch: Throwable -> L126
        intent.addFlags(1048576);     // Catch: Throwable -> L126
        int userId = task2.mUserId;     // Catch: Throwable -> L126
        monitor-exit(r12);     // Catch: Throwable -> L126
        WindowManagerService.resetPriorityAfterLockedSection();
        SaferIntentUtils.DISABLE_ENFORCE_INTENTS_TO_MATCH_INTENT_FILTERS.set(true);     // Catch: Throwable -> L154
        int r0 = r1.mService.getActivityStartController().startActivityInPackage(taskCallingUid, callingPid, callingUid, callingPackage, callingFeatureId, intent, null, null, null, 0, 0, options, userId, task2, "startActivityFromRecents", false, null, false);     // Catch: Throwable -> L152
        SaferIntentUtils.DISABLE_ENFORCE_INTENTS_TO_MATCH_INTENT_FILTERS.set(false);
        WindowManagerGlobalLock r4 = r1.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r4);
    L143:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L139:
        if (task2.hasChild() == false) goto L141;
    L145:
        r1.mService.continueWindowLayout();     // Catch: Throwable -> L143
        monitor-exit(r4);     // Catch: Throwable -> L143
        WindowManagerService.resetPriorityAfterLockedSection();
        return r0;
    L141:
        if (task2.shouldRemoveSelfOnLastChildRemoval() == false) goto L145;
        task2.removeIfPossible("start-from-recents");     // Catch: Throwable -> L143
    L152:
        th = th;
        task2 = task2;
    L155:
        SaferIntentUtils.DISABLE_ENFORCE_INTENTS_TO_MATCH_INTENT_FILTERS.set(false);
        WindowManagerGlobalLock r5 = r1.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r5);
    L162:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L158:
        if (task2.hasChild() == false) goto L160;
    L164:
        r1.mService.continueWindowLayout();     // Catch: Throwable -> L162
        monitor-exit(r5);     // Catch: Throwable -> L162
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L160:
        if (task2.shouldRemoveSelfOnLastChildRemoval() == false) goto L164;
        task2.removeIfPossible("start-from-recents");     // Catch: Throwable -> L162
    L154:
        th = th;
        goto L155
    L232:
        if (task.getRootTask().getWindowingMode() != 6) goto L43;
        moveHomeTaskForward2 = false;
    L41:
        th = th;
    L171:
        th = th;
        goto L185
    L210:
        r1.mWindowManager.executeAppTransition();     // Catch: Throwable -> L180
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L180
        r2.append("startActivityFromRecents: Task ");     // Catch: Throwable -> L180
        r2.append(taskId);     // Catch: Throwable -> L178
        r2.append(" not found.");     // Catch: Throwable -> L178
        throw new IllegalArgumentException(r2.toString());     // Catch: Throwable -> L178
    L178:
        th = th;
    L180:
        th = th;
    L182:
        th = th;
    L196:
        throw new IllegalArgumentException("startActivityFromRecents: Task " + taskId + " can't be launch in the home/recents root task.");     // Catch: Throwable -> L187
    L245:
        int activityType2 = activityOptions.getLaunchActivityType();     // Catch: Throwable -> L17
        if (activityOptions.freezeRecentTasksReordering() == false) goto L21;
        if (moveHomeTaskForward == false) goto L15;
    L19:
        r1.mRecentTasks.setFreezeTaskListReordering();     // Catch: Throwable -> L17
        goto L21
    L15:
        if (ActivityTaskManagerService.checkPermission("android.permission.MANAGE_ACTIVITY_TASKS", callingPid, callingUid) == 0) goto L19;
    L21:
        if (activityOptions.getLaunchRootTask() == null) goto L23;
        moveHomeTaskForward = false;
        activityType = activityType2;
        goto L26
    L23:
        activityType = activityType2;
    L193:
        th = th;
    L187:
        th = th;
        goto L197
    L5:
        activityOptions = null;
        goto L6
    }

    public IExtActivityTaskSupervisor getExt() {
        return this.mExt;
    }
}
