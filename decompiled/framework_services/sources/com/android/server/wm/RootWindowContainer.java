package com.android.server.wm;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.ActivityTaskManager;
import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.UserProperties;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.Region;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManagerInternal;
import android.net.Uri;
import android.os.Binder;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.service.voice.IVoiceInteractionSession;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.IntArray;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import android.view.Display;
import android.view.DisplayInfo;
import android.view.SurfaceControl;
import android.window.DesktopExperienceFlags;
import android.window.DesktopModeFlags;
import android.window.TaskFragmentAnimationParams;
import android.window.WindowContainerToken;
import com.android.internal.app.ResolverActivity;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.internal.util.function.pooled.PooledPredicate;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.am.AppTimeTracker;
import com.android.server.am.ProcessFreezerManager;
import com.android.server.am.UserState;
import com.android.server.pm.UserManagerInternal;
import com.android.server.policy.PermissionPolicyInternal;
import com.android.server.policy.PhoneWindowManager;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.utils.Slogf;
import com.android.server.wm.utils.RegionUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: loaded from: classes3.dex */
public class RootWindowContainer extends WindowContainer<DisplayContent> implements DisplayManager.DisplayListener {
    private static final String DISPLAY_OFF_SLEEP_TOKEN_TAG = "Display-off";
    static final int MATCH_ATTACHED_TASK_ONLY = 0;
    static final int MATCH_ATTACHED_TASK_OR_RECENT_TASKS = 1;
    static final int MATCH_ATTACHED_TASK_OR_RECENT_TASKS_AND_RESTORE = 2;
    private static final int MSG_SEND_SLEEP_TRANSITION = 3;
    private static final int PINNED_TASK_ABORT_TIMEOUT = 1000;
    private static final int SET_SCREEN_BRIGHTNESS_OVERRIDE = 1;
    private static final int SET_USER_ACTIVITY_TIMEOUT = 2;
    private static final long SLEEP_TRANSITION_WAIT_MILLIS = 1000;
    private static final String TAG = "WindowManager";
    private static final String TAG_RECENTS = "WindowManager";
    static final String TAG_STATES = "WindowManager";
    static final String TAG_TASKS = "WindowManager";
    public static boolean mIsPerfBoostAcquired;
    public static int mPerfHandle;
    public static boolean mPerfSendTapHint;
    private final Consumer<WindowState> mCloseSystemDialogsConsumer;
    private String mCloseSystemDialogsReason;
    int mCurrentUser;
    private DisplayContent mDefaultDisplay;
    private String mDestroyAllActivitiesReason;
    private final Runnable mDestroyAllActivitiesRunnable;
    private final DeviceStateController mDeviceStateController;
    private final SparseArray<IntArray> mDisplayAccessUIDs;
    private final SparseArray<DisplayManagerInternal.DisplayBrightnessOverrideRequest> mDisplayBrightnessOverrides;
    DisplayManager mDisplayManager;
    private DisplayManagerInternal mDisplayManagerInternal;
    final ActivityTaskManagerService.SleepTokenAcquirer mDisplayOffTokenAcquirer;
    private final DisplayRotationCoordinator mDisplayRotationCoordinator;
    private final SparseArray<SurfaceControl.Transaction> mDisplayTransactions;
    FinishDisabledPackageActivitiesHelper mFinishDisabledPackageActivitiesHelper;
    private final Handler mHandler;
    private Object mLastWindowFreezeSource;
    private Runnable mMaybeAbortPipEnterRunnable;
    private boolean mObscureApplicationContentOnSecondaryDisplays;
    public BoostFramework mPerfBoost;
    private final RankTaskLayersRunnable mRankTaskLayersRunnable;
    ActivityTaskManagerService mService;
    final SparseArray<SleepToken> mSleepTokens;
    private boolean mSustainedPerformanceModeCurrent;
    private boolean mSustainedPerformanceModeEnabled;
    private boolean mTaskLayersChanged;
    ActivityTaskSupervisor mTaskSupervisor;
    private final FindTaskResult mTmpFindTaskResult;
    private Region mTmpOccludingRegion;
    private int mTmpTaskLayerRank;
    private Region mTmpTaskRegion;
    final ArrayMap<Integer, ActivityRecord> mTopFocusedAppByProcess;
    private int mTopFocusedDisplayId;
    private boolean mUpdateRotation;
    private long mUserActivityTimeout;
    SparseIntArray mUserRootTaskInFront;
    SparseArray<IntArray> mUserVisibleRootTasks;
    public BoostFramework mUxPerf;
    WindowManagerService mWindowManager;

    /* JADX INFO: renamed from: com.android.server.wm.RootWindowContainer$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ RootWindowContainer this$0;

        /* JADX INFO: renamed from: $r8$lambda$NOynICQY31knf2C-TeykYmOnCtc, reason: not valid java name */
        public static /* synthetic */ void m10128$r8$lambda$NOynICQY31knf2CTeykYmOnCtc(AnonymousClass1 r0, ActivityRecord r1) {
            r0.lambda$run$0(r1);
        }

        AnonymousClass1(RootWindowContainer this$0) {
            this.this$0 = this$0;
        }

        @Override // java.lang.Runnable
        public void run() {
            WindowManagerGlobalLock r0 = this.this$0.mService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mTaskSupervisor.beginDeferResume();     // Catch: Throwable -> L11
            this.this$0.forAllActivities(new RootWindowContainer$1$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L11
            this.this$0.mTaskSupervisor.endDeferResume();     // Catch: Throwable -> L9
            this.this$0.resumeFocusedTasksTopActivities();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L9:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L11:
            th = move-exception;
            this.this$0.mTaskSupervisor.endDeferResume();     // Catch: Throwable -> L9
            this.this$0.resumeFocusedTasksTopActivities();     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        }

        private /* synthetic */ void lambda$run$0(ActivityRecord r) {
            if (r.finishing == false) goto L5;
            return;
        L5:
            if (r.isDestroyable() == true) goto L8;
            return;
        L8:
            if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L10;
            Slog.v("ActivityTaskManager", "Destroying " + r + " in state " + r.getState() + " resumed=" + r.getTask().getTopResumedActivity() + " pausing=" + r.getTask().getTopPausingActivity() + " for reason " + RootWindowContainer.m10122$$Nest$fgetmDestroyAllActivitiesReason(this.this$0));
        L10:
            r.destroyImmediately(RootWindowContainer.m10122$$Nest$fgetmDestroyAllActivitiesReason(this.this$0));
        }
    }

    /* JADX INFO: renamed from: com.android.server.wm.RootWindowContainer$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ RootWindowContainer this$0;
        final /* synthetic */ Throwable val$enterPipThrowable;
        final /* synthetic */ Task val$rootTask;

        /* JADX INFO: renamed from: $r8$lambda$VW-uz22woI0-jAF4lBFxBrbGx_Q, reason: not valid java name */
        public static /* synthetic */ void m10129$r8$lambda$VWuz22woI0jAF4lBFxBrbGx_Q(AnonymousClass2 r0, Runnable r1) {
            r0.lambda$run$0(r1);
        }

        AnonymousClass2(RootWindowContainer this$0, Task r2, Throwable r3) {
            this.this$0 = this$0;
            this.val$rootTask = r2;
            this.val$enterPipThrowable = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            WindowManagerGlobalLock r0 = this.this$0.mService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (this.this$0.mTransitionController.inTransition() == false) goto L12;
            final Runnable expectedMaybeAbortAtTimeout = RootWindowContainer.m10123$$Nest$fgetmMaybeAbortPipEnterRunnable(this.this$0);     // Catch: Throwable -> L10
            this.this$0.mTransitionController.mStateValidators.add(new RootWindowContainer$2$$ExternalSyntheticLambda0(this, expectedMaybeAbortAtTimeout));     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L12:
            RootWindowContainer.m10125$$Nest$fputmMaybeAbortPipEnterRunnable(this.this$0, null);     // Catch: Throwable -> L10
            this.this$0.mService.deferWindowLayout();     // Catch: Throwable -> L10
            ActivityRecord top = this.val$rootTask.getTopMostActivity();     // Catch: Throwable -> L10
            ActivityManager.RunningTaskInfo beforeTaskInfo = this.val$rootTask.getTaskInfo();     // Catch: Throwable -> L10
            if (top != null) goto L15;
        L19:
            this.this$0.mService.continueWindowLayout();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L15:
            if (top.inPinnedWindowingMode() == true) goto L19;
            if (this.val$rootTask.abortPipEnter(top) == false) goto L19;
            Slog.wtf("WindowManager", "Enter PiP was aborted via a scheduled timeouttask_state_before=" + beforeTaskInfo + "task_state_after=" + this.val$rootTask.getTaskInfo(), this.val$enterPipThrowable);     // Catch: Throwable -> L10
            goto L19
        }

        private /* synthetic */ void lambda$run$0(Runnable expectedMaybeAbortAtTimeout) {
            if (expectedMaybeAbortAtTimeout == RootWindowContainer.m10123$$Nest$fgetmMaybeAbortPipEnterRunnable(this.this$0)) goto L5;
            return;
        L5:
            RootWindowContainer.m10125$$Nest$fputmMaybeAbortPipEnterRunnable(this.this$0, null);
            run();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AnyTaskForIdMatchTaskMode {
    }

    static class FindTaskResult implements Predicate<Task> {
        private ComponentName cls;
        private Uri documentData;
        private boolean isDocument;
        private int mActivityType;
        ActivityRecord mCandidateRecord;
        ActivityRecord mIdealRecord;
        private boolean mIncludeLaunchedFromBubble;
        private ActivityInfo mInfo;
        private Intent mIntent;
        private String mTaskAffinity;
        private int userId;

        FindTaskResult() {
            this.mIncludeLaunchedFromBubble = true;
        }

        @Override // java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(Task r1) {
            return test2(r1);
        }

        void init(int activityType, String taskAffinity, Intent intent, ActivityInfo info, boolean includeLaunchedFromBubble) {
            this.mActivityType = activityType;
            this.mTaskAffinity = taskAffinity;
            this.mIntent = intent;
            this.mInfo = info;
            this.mIdealRecord = null;
            this.mCandidateRecord = null;
            this.mIncludeLaunchedFromBubble = includeLaunchedFromBubble;
        }

        void process(WindowContainer parent) {
            this.cls = this.mIntent.getComponent();
            if (this.mInfo.targetActivity == null) goto L5;
            this.cls = new ComponentName(this.mInfo.packageName, this.mInfo.targetActivity);
        L5:
            this.userId = UserHandle.getUserId(this.mInfo.applicationInfo.uid);
            if (this.mIntent == null) goto L8;
            boolean r0 = true;
        L9:
            this.isDocument = r0 & this.mIntent.isDocument();
            if (this.isDocument == false) goto L12;
            Uri r1 = this.mIntent.getData();
        L13:
            this.documentData = r1;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L16;
            String protoLogParam0 = String.valueOf(this.mInfo);
            String protoLogParam1 = String.valueOf(parent);
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, -8961882615747561040L, 0, new Object[]{protoLogParam0, protoLogParam1});
        L16:
            parent.forAllLeafTasks(this);
            return;
        L12:
            r1 = null;
            goto L13
        L8:
            r0 = false;
            goto L9
        }

        /* JADX INFO: renamed from: test, reason: avoid collision after fix types in other method */
        public boolean test2(Task task) {
            if (ConfigurationContainer.isCompatibleActivityType(this.mActivityType, task.getActivityType()) == true) goto L9;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L7;
            String protoLogParam0 = String.valueOf(task);
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, 8899721161806265460L, 0, new Object[]{protoLogParam0});
        L7:
            return false;
        L9:
            if (task.voiceSession == null) goto L15;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L13;
            String protoLogParam1 = String.valueOf(task);
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, 6841550641928224256L, 0, new Object[]{protoLogParam1});
        L13:
            return false;
        L15:
            if (task.mUserId != this.userId) goto L17;
            ActivityRecord r = task.getTopNonFinishingActivity(false, this.mIncludeLaunchedFromBubble);
            if (r == null) goto L103;
            if (r.finishing == true) goto L103;
            if (r.mUserId != this.userId) goto L103;
            if (r.launchMode == 3) goto L103;
            if (ConfigurationContainer.isCompatibleActivityType(r.getActivityType(), this.mActivityType) == false) goto L32;
            Intent taskIntent = task.intent;
            Intent affinityIntent = task.affinityIntent;
            if (taskIntent != null) goto L38;
        L40:
            if (affinityIntent != null) goto L42;
        L44:
            boolean taskIsDocument = false;
            Uri taskDocumentData = null;
        L46:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L53;
            if (task.realActivity == null) goto L50;
            String r6 = task.realActivity.flattenToShortString();
        L51:
            String protoLogParam2 = String.valueOf(r6);
            String protoLogParam3 = String.valueOf(task.rootAffinity);
            String protoLogParam4 = String.valueOf(this.mIntent.getComponent().flattenToShortString());
            String protoLogParam5 = String.valueOf(this.mTaskAffinity);
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, 6022828946761399284L, 0, new Object[]{protoLogParam2, protoLogParam3, protoLogParam4, protoLogParam5});
            goto L53
        L50:
            r6 = "";
        L53:
            if (task.realActivity != null) goto L55;
        L66:
            if (affinityIntent == null) goto L82;
            if (affinityIntent.getComponent() == null) goto L82;
            if (affinityIntent.getComponent().compareTo(this.cls) != 0) goto L82;
            if (Objects.equals(this.documentData, taskDocumentData) == false) goto L82;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L77;
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, -3413620974545388702L, 0, null);
        L77:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L79;
            String protoLogParam6 = String.valueOf(this.mIntent);
            String protoLogParam7 = String.valueOf(r.intent);
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, -2649361982747625232L, 0, new Object[]{protoLogParam6, protoLogParam7});
        L79:
            this.mIdealRecord = r;
            return true;
        L82:
            if (this.isDocument == true) goto L99;
            if (taskIsDocument == true) goto L99;
            if (this.mIdealRecord != null) goto L99;
            if (this.mCandidateRecord != null) goto L99;
            if (task.rootAffinity == null) goto L99;
            if (task.rootAffinity.equals(this.mTaskAffinity) == true) goto L93;
        L101:
            return false;
        L93:
            if (task.isSameRequiredDisplayCategory(this.mInfo) == false) goto L101;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L97;
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, 7046266138098744790L, 0, null);
        L97:
            this.mCandidateRecord = r;
        L99:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L101;
            String protoLogParam8 = String.valueOf(task);
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, 6481733556290926693L, 0, new Object[]{protoLogParam8});
            goto L101
        L55:
            if (task.realActivity.compareTo(this.cls) != 0) goto L66;
            if (Objects.equals(this.documentData, taskDocumentData) == false) goto L66;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L62;
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, -3413620974545388702L, 0, null);
        L62:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L64;
            String protoLogParam9 = String.valueOf(this.mIntent);
            String protoLogParam10 = String.valueOf(r.intent);
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, -2649361982747625232L, 0, new Object[]{protoLogParam9, protoLogParam10});
        L64:
            this.mIdealRecord = r;
            return true;
        L42:
            if (affinityIntent.isDocument() == false) goto L44;
            taskIsDocument = true;
            taskDocumentData = affinityIntent.getData();
            goto L46
        L38:
            if (taskIntent.isDocument() == false) goto L40;
            taskIsDocument = true;
            taskDocumentData = taskIntent.getData();
            goto L46
        L32:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L34;
            String protoLogParam11 = String.valueOf(task);
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, 9031436623838917667L, 0, new Object[]{protoLogParam11});
        L34:
            return false;
        L103:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L105;
            String protoLogParam12 = String.valueOf(task);
            String protoLogParam13 = String.valueOf(r);
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, -4764624740388751268L, 0, new Object[]{protoLogParam12, protoLogParam13});
        L105:
            return false;
        L17:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L19;
            String protoLogParam14 = String.valueOf(task);
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, 4468520936943270392L, 0, new Object[]{protoLogParam14});
        L19:
            return false;
        }
    }

    class FinishDisabledPackageActivitiesHelper implements Predicate<ActivityRecord> {
        private final ArrayList<ActivityRecord> mCollectedActivities;
        private boolean mDoit;
        private boolean mEvenPersistent;
        private Set<String> mFilterByClasses;
        private Task mLastTask;
        private boolean mOnlyRemoveNoProcess;
        private String mPackageName;
        private int mUserId;
        final /* synthetic */ RootWindowContainer this$0;

        FinishDisabledPackageActivitiesHelper(RootWindowContainer this$0) {
            this.this$0 = this$0;
            this.mCollectedActivities = new ArrayList();
        }

        @Override // java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(ActivityRecord r1) {
            return test2(r1);
        }

        private void reset(String packageName, Set<String> filterByClasses, boolean doit, boolean evenPersistent, int userId, boolean onlyRemoveNoProcess) {
            this.mPackageName = packageName;
            this.mFilterByClasses = filterByClasses;
            this.mDoit = doit;
            this.mEvenPersistent = evenPersistent;
            this.mUserId = userId;
            this.mOnlyRemoveNoProcess = onlyRemoveNoProcess;
            this.mLastTask = null;
        }

        boolean process(String packageName, Set<String> filterByClasses, boolean doit, boolean evenPersistent, int userId, boolean onlyRemoveNoProcess) {
            reset(packageName, filterByClasses, doit, evenPersistent, userId, onlyRemoveNoProcess);
            this.this$0.forAllActivities(this);
            boolean didSomething = false;
            int size = this.mCollectedActivities.size();
            int i = 0;
        L3:
            if (i >= size) goto L11;
            ActivityRecord r = this.mCollectedActivities.get(i);
            if (this.mOnlyRemoveNoProcess == true) goto L7;
            didSomething = true;
            Slog.i("WindowManager", "  Force finishing " + r);
            r.finishIfPossible("force-stop", true);
        L10:
            i = i + 1;
            goto L3
        L7:
            if (r.hasProcess() == true) goto L10;
            didSomething = true;
            Slog.i("WindowManager", "  Force removing " + r);
            r.cleanUp(false, false);
            r.removeFromHistory("force-stop");
            goto L10
        L11:
            this.mCollectedActivities.clear();
            return didSomething;
        }

        /* JADX INFO: renamed from: test, reason: avoid collision after fix types in other method */
        public boolean test2(ActivityRecord r) {
            if (r.packageName.equals(this.mPackageName) == false) goto L9;
            if (this.mFilterByClasses != null) goto L7;
        L12:
            boolean sameComponent = true;
        L14:
            boolean noProcess = !r.hasProcess();
            if (this.mUserId != (-1)) goto L17;
        L18:
            if (sameComponent == false) goto L20;
        L21:
            if (noProcess == true) goto L27;
            if (this.mEvenPersistent == true) goto L27;
            if (r.app.isPersistent() == false) goto L27;
        L33:
            return false;
        L27:
            if (this.mDoit == false) goto L29;
            this.mCollectedActivities.add(r);
            this.mLastTask = r.getTask();
            goto L33
        L29:
            if (r.finishing == false) goto L31;
            return false;
        L31:
            return true;
        L20:
            if (r.getTask() != this.mLastTask) goto L33;
        L17:
            if (r.mUserId != this.mUserId) goto L33;
        L7:
            if (this.mFilterByClasses.contains(r.mActivityComponent.getClassName()) == true) goto L12;
        L9:
            if (this.mPackageName == null) goto L11;
        L13:
            sameComponent = false;
            goto L14
        L11:
            if (r.mUserId != this.mUserId) goto L13;
            goto L12
        }
    }

    private final class MyHandler extends Handler {
        final /* synthetic */ RootWindowContainer this$0;

        public MyHandler(RootWindowContainer r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L5;
                default: goto L21;
            };
        L5:
            WindowManagerGlobalLock r0 = this.this$0.mService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.sendSleepTransition((DisplayContent) msg.obj);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L14:
            this.this$0.mWmService.mPowerManagerInternal.setUserActivityTimeoutOverrideFromWindowManager(((Long) msg.obj).longValue());
            return;
        L15:
            SparseArray<DisplayManagerInternal.DisplayBrightnessOverrideRequest> brightnessOverrides = (SparseArray) msg.obj;
            this.this$0.mWmService.mDisplayManagerInternal.setScreenBrightnessOverrideFromWindowManager(brightnessOverrides);
            return;
        }
    }

    private class RankTaskLayersRunnable implements Runnable {
        boolean mCheckUpdateOomAdj;
        final /* synthetic */ RootWindowContainer this$0;

        /* synthetic */ RankTaskLayersRunnable(RootWindowContainer r1, RootWindowContainerIA r2) {
            this(r1);
        }

        private RankTaskLayersRunnable(RootWindowContainer r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            WindowManagerGlobalLock r0 = this.this$0.mService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (RootWindowContainer.m10124$$Nest$fgetmTaskLayersChanged(this.this$0) == false) goto L9;
            RootWindowContainer.m10126$$Nest$fputmTaskLayersChanged(this.this$0, false);     // Catch: Throwable -> L7
            this.this$0.rankTaskLayers();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
        }
    }

    static final class SleepToken {
        private final long mAcquireTime;
        private final int mDisplayId;
        final int mHashKey;
        private final String mTag;

        /* JADX INFO: renamed from: -$$Nest$fgetmDisplayId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m10130$$Nest$fgetmDisplayId(SleepToken r0) {
            return r0.mDisplayId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTag, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m10131$$Nest$fgetmTag(SleepToken r0) {
            return r0.mTag;
        }

        SleepToken(String tag, int displayId) {
            this.mTag = tag;
            this.mDisplayId = displayId;
            this.mAcquireTime = SystemClock.uptimeMillis();
            this.mHashKey = RootWindowContainer.m10127$$Nest$smmakeSleepTokenKey(this.mTag, this.mDisplayId);
        }

        public String toString() {
            return "{\"" + this.mTag + "\", display " + this.mDisplayId + ", acquire at " + TimeUtils.formatUptime(this.mAcquireTime) + "}";
        }

        void writeTagToProto(ProtoOutputStream proto, long fieldId) {
            proto.write(fieldId, this.mTag);
        }
    }

    public static /* synthetic */ void $r8$lambda$0OwMdXApjulRMeUxtEZMUz1bNeI(RootWindowContainer r0, ArrayList r1, Task r2) {
        r0.lambda$getAllRootTaskInfos$25(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$2EdcgYUULjPYt-heCLBOC22Hl60, reason: not valid java name */
    public static /* synthetic */ void m10099$r8$lambda$2EdcgYUULjPYtheCLBOC22Hl60(RootWindowContainer r0, int r1, Task r2) {
        r0.lambda$lockAllProfileTasks$44(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$3xD2DunT7hflGQOU09Qi8edracA(PermissionPolicyInternal r0, ActivityRecord r1) {
        return lambda$getTaskToShowPermissionDialogOn$46(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$4-fSb2VpiTcBPqNnzCdDEtdDy2k, reason: not valid java name */
    public static /* synthetic */ void m10100$r8$lambda$4fSb2VpiTcBPqNnzCdDEtdDy2k(String r0, ArrayList r1, int r2, WindowState r3) {
        lambda$getWindowsByName$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$4QkbQCJir5Zs2q1L6_FQYadzvyI(boolean[] r0, Task r1) {
        return lambda$allResumedActivitiesVisible$41(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$5py2I9WAsKoIu0tIUi6jW8rWFfI(RootWindowContainer r0, String r1, ActivityRecord r2) {
        r0.lambda$closeSystemDialogActivities$34(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$AU_bT3OST-rAZuYPxS613oLTK6U, reason: not valid java name */
    public static /* synthetic */ void m10101$r8$lambda$AU_bT3OSTrAZuYPxS613oLTK6U(RootWindowContainer r0, boolean r1, DisplayContent r2, Task r3) {
        r0.lambda$applySleepTokens$22(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$Ck2QgPI8GIvrQVro7gf82lHp_no(int r0, Task r1) {
        lambda$switchUser$15(r0, r1);
    }

    public static /* synthetic */ Boolean $r8$lambda$DFaa7QLApF8rlf4uiy_4K0Hxf2Y(RootWindowContainer r0, int r1, String r2, boolean r3, boolean r4, TaskDisplayArea r5, Boolean r6) {
        return r0.lambda$startHomeOnDisplay$11(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: $r8$lambda$DvZbeqHsclgkz_1kFUh9112b6-Q, reason: not valid java name */
    public static /* synthetic */ void m10102$r8$lambda$DvZbeqHsclgkz_1kFUh9112b6Q(ArrayList r0, PrintWriter r1, int[] r2, boolean r3, WindowState r4) {
        lambda$dumpWindowsNoHeader$8(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$E34_D71e3pCi6NAdjh-Bki214Bg, reason: not valid java name */
    public static /* synthetic */ boolean m10103$r8$lambda$E34_D71e3pCi6NAdjhBki214Bg(boolean[] r0, Task r1) {
        return lambda$allPausedActivitiesComplete$42(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$FxxhUOF6EKNbQiofOgqN_1CjbN0(RootWindowContainer r0, WindowState r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$GdhT9w3Q3KM_wM1JIf_ICTUl1tc(int r0, ArrayMap r1, ActivityRecord r2) {
        lambda$updateActivityApplicationInfo$37(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$GmfuRilNn8502fLTgH3gQvsGVKE(RootWindowContainer r0, int r1, DisplayContent r2) {
        r0.lambda$onDisplayChanged$27(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$IqAfKrfmxlerj-LoAZfSeXQ3YNo, reason: not valid java name */
    public static /* synthetic */ void m10104$r8$lambda$IqAfKrfmxlerjLoAZfSeXQ3YNo(RootWindowContainer r0, ActivityRecord r1) {
        r0.lambda$rankTaskLayers$30(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Lfbne4qhwzq6Oh5NesL-KiS-CXo, reason: not valid java name */
    public static /* synthetic */ boolean m10105$r8$lambda$Lfbne4qhwzq6Oh5NesLKiSCXo(int r0, boolean r1, ArrayList r2, String r3, int r4, Task r5) {
        return lambda$getDumpActivities$48(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ boolean $r8$lambda$M97Wb24zcvcEil1V5A5uac9wluE(Task r0) {
        return lambda$allResumedActivitiesIdle$40(r0);
    }

    public static /* synthetic */ void $r8$lambda$NItAY7dnbFHLTNCf3RG3d2djgss(int[] r0, ActivityTaskManager.RootTaskInfo r1, Task r2) {
        lambda$getRootTaskInfo$24(r0, r1, r2);
    }

    public static /* synthetic */ ActivityRecord $r8$lambda$Nv7RtjJIz0UD98qXFg17OvyDAMg(RootWindowContainer r0, TaskDisplayArea r1, TaskDisplayArea r2) {
        return r0.lambda$findTask$17(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$P2DPWTF7DKQir9BmP6Sbsp1SGCk(boolean r0, boolean[] r1, boolean r2, Task r3) {
        lambda$putTasksToSleep$33(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$PL5tOszRyPt5jXv9xUs5KazJt7g(DisplayContent r0, Transition r1, boolean r2) {
        lambda$sendSleepTransition$20(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$R79sBJymzrWJ0ntJ8XhLsNaaEiM(RootWindowContainer r0, String r1, TaskDisplayArea r2) {
        r0.lambda$startHomeOnEmptyDisplays$10(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$SMy6Px685nbSaCfDf3jqojv87Ic(ArrayList r0, Task r1) {
        lambda$getTopVisibleActivities$12(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$TB7tp6FYarkIMP-huY12L0J6T1Y, reason: not valid java name */
    public static /* synthetic */ void m10106$r8$lambda$TB7tp6FYarkIMPhuY12L0J6T1Y(PrintWriter r0) {
        lambda$dumpActivities$50(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$VBntQ0px_81YfwISmC4-6CB1tKw, reason: not valid java name */
    public static /* synthetic */ void m10107$r8$lambda$VBntQ0px_81YfwISmC46CB1tKw(ArraySet r0, boolean r1, WindowState r2) {
        lambda$updateHiddenWhileSuspendedState$3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$VJolOm3Y-L3j-kMtlLJM6EiXQ2o, reason: not valid java name */
    public static /* synthetic */ boolean m10108$r8$lambda$VJolOm3YL3jkMtlLJM6EiXQ2o(ActivityRecord r0, int r1, boolean r2, Intent r3, ComponentName r4) {
        return matchesActivity(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$Wd_7PgQ0-8o3qzDIwOqtHAv--F0, reason: not valid java name */
    public static /* synthetic */ void m10109$r8$lambda$Wd_7PgQ08o3qzDIwOqtHAvF0(Task[] r0, Task r1, WindowProcessController r2, String r3, Task r4) {
        lambda$finishTopCrashedActivities$18(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$XVZ5G-X4VEdE3_fYgv-kwRLpr9c, reason: not valid java name */
    public static /* synthetic */ void m10110$r8$lambda$XVZ5GX4VEdE3_fYgvkwRLpr9c(ArrayList r0, ActivityRecord r1) {
        lambda$addStartingWindowsForVisibleActivities$29(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$XWfhVRqR7aHEEhEdmrEOmP9Rbjc(PrintWriter r0) {
        lambda$dumpActivities$53(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Y2lYcXSy0WSj-i7Rfh5k6JOptVo, reason: not valid java name */
    public static /* synthetic */ void m10111$r8$lambda$Y2lYcXSy0WSji7Rfh5k6JOptVo(int r0, String r1, ApplicationInfo r2, ActivityRecord r3) {
        lambda$updateActivityApplicationInfo$36(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$YYzYy2p7xqwtMSUlpDw6rnD-xok, reason: not valid java name */
    public static /* synthetic */ boolean m10112$r8$lambda$YYzYy2p7xqwtMSUlpDw6rnDxok(int r0, WindowState r1) {
        return lambda$getDisplayContextsWithNonToastVisibleWindows$9(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$b-NPEHrIeusrYf7sC7NyNDcwmJE, reason: not valid java name */
    public static /* synthetic */ void m10113$r8$lambda$bNPEHrIeusrYf7sC7NyNDcwmJE(ArrayList r0, Task r1, ArrayList r2, Task r3) {
        lambda$getTopVisibleActivities$13(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$bv21fjFDVu03y2VxKYn31Sdf1HM(RootWindowContainer r0, IntArray r1, Task r2) {
        r0.lambda$switchUser$14(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$cnDv250HlSET-GBlf9zK0KW0JGk, reason: not valid java name */
    public static /* synthetic */ void m10114$r8$lambda$cnDv250HlSETGBlf9zK0KW0JGk(DisplayContent r0) {
        lambda$performSurfacePlacementNoTrace$7(r0);
    }

    public static /* synthetic */ void $r8$lambda$cqZXD819cKhPDFunVLJyG6K5ylk(TaskFragment r0) {
        lambda$moveActivityToPinnedRootTaskInner$16(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$dsC40hGhsq-SqHbqr-JCk2olraY, reason: not valid java name */
    public static /* synthetic */ void m10115$r8$lambda$dsC40hGhsqSqHbqrJCk2olraY(boolean[] r0, PrintWriter r1, FileDescriptor r2, boolean r3, boolean r4, String r5, boolean[] r6, Task r7) {
        lambda$dumpActivities$49(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ boolean $r8$lambda$eVyGytci0yElT2x8dp5CjZDiybg(int r0, ActivityRecord r1) {
        return lambda$lockAllProfileTasks$43(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$elrrG8hTTMEid8AQKVwk7hhjUaI(int r0, boolean[] r1, WindowState r2) {
        return lambda$hasVisibleWindowAboveButDoesNotOwnNotificationShade$35(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$jWG2Rkw7bzp1hJE3Qt75_prcJ-g, reason: not valid java name */
    public static /* synthetic */ void m10116$r8$lambda$jWG2Rkw7bzp1hJE3Qt75_prcJg(WindowState r0) {
        lambda$updateAppOpsState$4(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$kD4J8x-_gp9R4uR3B6s9ZrwYkV4, reason: not valid java name */
    public static /* synthetic */ void m10117$r8$lambda$kD4J8x_gp9R4uR3B6s9ZrwYkV4(boolean[] r0, boolean[] r1, ActivityRecord r2, TaskDisplayArea r3) {
        lambda$startPowerModeLaunchIfNeeded$45(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$kgdzIz9O2AfTPG_ShxzDULDaJf8(PermissionPolicyInternal r0, int r1, String r2, int[] r3, TaskFragment r4) {
        return lambda$getTaskToShowPermissionDialogOn$47(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$l4Z33QZ45Uh2ykgw_6a9fO3hfNI(boolean[] r0, PrintWriter r1, String r2, boolean[] r3, TaskDisplayArea r4) {
        lambda$dumpActivities$51(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean $r8$lambda$ml0fQgwbFqzWl_iyTB5cfc_8o4s(TaskFragment r0) {
        return lambda$allResumedActivitiesIdle$39(r0);
    }

    public static /* synthetic */ void $r8$lambda$n2j6_sI4yp8lnUUb6GWvBunvHZE(RootWindowContainer r0, Task r1) {
        r0.lambda$rankTaskLayers$31(r1);
    }

    public static /* synthetic */ void $r8$lambda$og8noWAxSxnuOrACMtDZ4i6WgVI(TaskFragment r0) {
        lambda$applySleepTokens$21(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$rRQPNRr20Cu-bss2yeuBZn2OpXE, reason: not valid java name */
    public static /* synthetic */ void m10118$r8$lambda$rRQPNRr20Cubss2yeuBZn2OpXE(ArrayMap r0, DisplayContent r1) {
        lambda$updateDisplayImePolicyCache$28(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$sPWmwy22PAXG-tZYyiamjBTvmlU, reason: not valid java name */
    public static /* synthetic */ void m10119$r8$lambda$sPWmwy22PAXGtZYyiamjBTvmlU(Task r0, boolean[] r1, boolean r2, ActivityRecord r3, ActivityOptions r4, ActivityRecord r5, Task r6) {
        lambda$resumeFocusedTasksTopActivities$19(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$sct6Je9RAkQzTklmPK4OMkBPJkU(WindowState r0) {
        lambda$refreshSecureSurfaceState$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$sdlcnHtSgKFDtpUSNY7Q5uHBcjA(PrintWriter r0) {
        lambda$dumpActivities$52(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$tNk9fMnxyNtXC1nO-Z3PNML98xE, reason: not valid java name */
    public static /* synthetic */ void m10120$r8$lambda$tNk9fMnxyNtXC1nOZ3PNML98xE(RootWindowContainer r0, ArrayList r1, Task r2) {
        r0.lambda$getAllRootTaskInfos$26(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$uhCWnnJ8bevDVE9QmxrLIXPQ8PE(Task r0, boolean[] r1, int[] r2, Task r3) {
        return lambda$getRootTaskInfo$23(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$wmytb1Uixitw5Xxf-AQXEILnq_8, reason: not valid java name */
    public static /* synthetic */ boolean m10121$r8$lambda$wmytb1Uixitw5XxfAQXEILnq_8(int r0, WindowState r1) {
        return lambda$canShowStrictModeViolation$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$xYOqBrEt62_urSJRvGOQlwtaQtg(IBinder r0, Task r1) {
        lambda$finishVoiceTask$38(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$yIqevDqPknDgR1CuEHx3DycY9Y8(AppTimeTracker r0, ActivityRecord r1) {
        lambda$clearOtherAppTimeTrackers$32(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$zcHCT_Op9oonaYqmUPS6OLp22oc(RootWindowContainer r0, SparseIntArray r1, WindowState r2) {
        r0.lambda$reclaimSomeSurfaceMemory$6(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDestroyAllActivitiesReason, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m10122$$Nest$fgetmDestroyAllActivitiesReason(RootWindowContainer r0) {
        return r0.mDestroyAllActivitiesReason;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMaybeAbortPipEnterRunnable, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m10123$$Nest$fgetmMaybeAbortPipEnterRunnable(RootWindowContainer r0) {
        return r0.mMaybeAbortPipEnterRunnable;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTaskLayersChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10124$$Nest$fgetmTaskLayersChanged(RootWindowContainer r0) {
        return r0.mTaskLayersChanged;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMaybeAbortPipEnterRunnable, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10125$$Nest$fputmMaybeAbortPipEnterRunnable(RootWindowContainer r0, Runnable r1) {
        r0.mMaybeAbortPipEnterRunnable = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTaskLayersChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10126$$Nest$fputmTaskLayersChanged(RootWindowContainer r0, boolean r1) {
        r0.mTaskLayersChanged = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$smmakeSleepTokenKey, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m10127$$Nest$smmakeSleepTokenKey(String r0, int r1) {
        return makeSleepTokenKey(r0, r1);
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ void commitPendingTransaction() {
        super.commitPendingTransaction();
    }

    @Override // com.android.server.wm.WindowContainer
    public /* bridge */ /* synthetic */ int compareTo(WindowContainer r1) {
        return super.compareTo(r1);
    }

    @Override // com.android.server.wm.ConfigurationContainer
    /* bridge */ /* synthetic */ void dispatchConfigurationToChild(ConfigurationContainer r1, Configuration r2) {
        dispatchConfigurationToChild((DisplayContent) r1, r2);
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ SurfaceControl getAnimationLeash() {
        return super.getAnimationLeash();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ SurfaceControl getAnimationLeashParent() {
        return super.getAnimationLeashParent();
    }

    @Override // com.android.server.wm.WindowContainer
    public /* bridge */ /* synthetic */ IExtWindowContainer getExtWindowContainer() {
        return super.getExtWindowContainer();
    }

    @Override // com.android.server.wm.WindowContainer
    public /* bridge */ /* synthetic */ SparseArray getInsetsSourceProviders() {
        return super.getInsetsSourceProviders();
    }

    @Override // com.android.server.wm.WindowContainer
    public /* bridge */ /* synthetic */ IObricWindowContainer getObricExtWindowContainer() {
        return super.getObricExtWindowContainer();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ SurfaceControl getParentSurfaceControl() {
        return super.getParentSurfaceControl();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ SurfaceControl.Transaction getPendingTransaction() {
        return super.getPendingTransaction();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ SurfaceControl getSurfaceControl() {
        return super.getSurfaceControl();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ int getSurfaceHeight() {
        return super.getSurfaceHeight();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ int getSurfaceWidth() {
        return super.getSurfaceWidth();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ SurfaceControl.Transaction getSyncTransaction() {
        return super.getSyncTransaction();
    }

    @Override // com.android.server.wm.WindowContainer
    public /* bridge */ /* synthetic */ WindowContainerSysEx getWindowContainerSysEx() {
        return super.getWindowContainerSysEx();
    }

    @Override // com.android.server.wm.WindowContainer
    public /* bridge */ /* synthetic */ boolean hasInsetsSourceProvider() {
        return super.hasInsetsSourceProvider();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ SurfaceControl.Builder makeAnimationLeash() {
        return super.makeAnimationLeash();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ void onAnimationLeashCreated(SurfaceControl.Transaction r1, SurfaceControl r2) {
        super.onAnimationLeashCreated(r1, r2);
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ void onAnimationLeashLost(SurfaceControl.Transaction r1) {
        super.onAnimationLeashLost(r1);
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public /* bridge */ /* synthetic */ void onRequestedOverrideConfigurationChanged(Configuration r1) {
        super.onRequestedOverrideConfigurationChanged(r1);
    }

    @Override // com.android.server.wm.WindowContainer
    protected /* bridge */ /* synthetic */ void removeChild(WindowContainer r1) {
        removeChild((DisplayContent) r1);
    }

    static {
        mPerfSendTapHint = false;
        mIsPerfBoostAcquired = false;
        mPerfHandle = -1;
    }

    private /* synthetic */ void lambda$new$0(WindowState w) {
        if (w.mHasSurface == false) goto L10;
        w.mClient.closeSystemDialogs(this.mCloseSystemDialogsReason);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    RootWindowContainer(WindowManagerService service) {
        super(service);
        this.mLastWindowFreezeSource = null;
        this.mDisplayBrightnessOverrides = new SparseArray();
        this.mUserActivityTimeout = -1;
        this.mUpdateRotation = false;
        this.mObscureApplicationContentOnSecondaryDisplays = false;
        this.mSustainedPerformanceModeEnabled = false;
        this.mSustainedPerformanceModeCurrent = false;
        this.mTopFocusedDisplayId = -1;
        this.mTopFocusedAppByProcess = new ArrayMap();
        this.mPerfBoost = null;
        this.mUxPerf = null;
        this.mDisplayAccessUIDs = new SparseArray();
        this.mDisplayTransactions = new SparseArray();
        this.mUserRootTaskInFront = new SparseIntArray(2);
        this.mUserVisibleRootTasks = new SparseArray();
        this.mSleepTokens = new SparseArray();
        this.mTaskLayersChanged = true;
        this.mRankTaskLayersRunnable = new RankTaskLayersRunnable(this, null);
        this.mDestroyAllActivitiesRunnable = new AnonymousClass1(this);
        this.mMaybeAbortPipEnterRunnable = null;
        this.mTmpFindTaskResult = new FindTaskResult();
        this.mCloseSystemDialogsConsumer = new RootWindowContainer$$ExternalSyntheticLambda51(this);
        this.mFinishDisabledPackageActivitiesHelper = new FinishDisabledPackageActivitiesHelper(this);
        this.mHandler = new MyHandler(this, service.mH.getLooper());
        this.mService = service.mAtmService;
        this.mTaskSupervisor = this.mService.mTaskSupervisor;
        this.mTaskSupervisor.mRootWindowContainer = this;
        ActivityTaskManagerService r1 = this.mService;
        r1.getClass();
        this.mDisplayOffTokenAcquirer = new ActivityTaskManagerService.SleepTokenAcquirer(r1, DISPLAY_OFF_SLEEP_TOKEN_TAG);
        this.mDeviceStateController = new DeviceStateController(service.mContext, service.mGlobalLock);
        this.mDisplayRotationCoordinator = new DisplayRotationCoordinator();
    }

    boolean updateFocusedWindowLocked(int mode, boolean updateInputWindows) {
        this.mTopFocusedAppByProcess.clear();
        boolean changed = false;
        int topFocusedDisplayId = -1;
        int i = this.mChildren.size() - 1;
    L4:
        if (i < 0) goto L22;
        DisplayContent dc = (DisplayContent) this.mChildren.get(i);
        if ("PREFETCH_APP".equals(dc.mDisplay.getName()) == false) goto L8;
        Slog.d("WindowManager", "skip updateFocusedWindowLocked for display " + dc.getDisplayId());
    L20:
        i = i - 1;
        goto L4
    L8:
        changed = changed | dc.updateFocusedWindowLocked(mode, updateInputWindows, topFocusedDisplayId);
        WindowState newFocus = dc.mCurrentFocus;
        if (newFocus == null) goto L16;
        int pidOfNewFocus = newFocus.mSession.mPid;
        if (this.mTopFocusedAppByProcess.get(Integer.valueOf(pidOfNewFocus)) != null) goto L13;
        this.mTopFocusedAppByProcess.put(Integer.valueOf(pidOfNewFocus), newFocus.mActivityRecord);
    L13:
        if (topFocusedDisplayId != (-1)) goto L20;
        topFocusedDisplayId = dc.getDisplayId();
        goto L20
    L16:
        if (topFocusedDisplayId != (-1)) goto L20;
        if (dc.mFocusedApp == null) goto L20;
        topFocusedDisplayId = dc.getDisplayId();
        goto L20
    L22:
        if (topFocusedDisplayId != (-1)) goto L25;
        topFocusedDisplayId = 0;
    L25:
        if (this.mTopFocusedDisplayId == topFocusedDisplayId) goto L29;
        this.mTopFocusedDisplayId = topFocusedDisplayId;
        this.mWmService.mInputManager.setFocusedDisplay(topFocusedDisplayId);
        this.mWmService.mPolicy.setTopFocusedDisplay(topFocusedDisplayId);
        this.mWmService.mAccessibilityController.setFocusedDisplay(topFocusedDisplayId);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[0] == false) goto L29;
        long protoLogParam0 = topFocusedDisplayId;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, 3331249072840061049L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L29:
        return changed;
    }

    DisplayContent getTopFocusedDisplayContent() {
        DisplayContent autoActionDc = getObricExtWindowContainer().getTopFocusedDisplayContent(this.mTopFocusedDisplayId);
        if (autoActionDc == null) goto L5;
        return autoActionDc;
    L5:
        DisplayContent dc = getDisplayContent(this.mTopFocusedDisplayId);
        if (dc == null) goto L9;
        return dc;
    L9:
        return getDisplayContent(0);
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isOnTop() {
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    void onChildPositionChanged(WindowContainer child) {
        this.mWmService.updateFocusedWindowLocked(0, !this.mWmService.mPerDisplayFocusEnabled);
        this.mTaskSupervisor.updateTopResumedActivityIfNeeded("onChildPositionChanged");
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isAttached() {
        return true;
    }

    void onSettingsRetrieved() {
        int numDisplays = this.mChildren.size();
        int displayNdx = 0;
    L3:
        if (displayNdx >= numDisplays) goto L12;
        DisplayContent displayContent = (DisplayContent) this.mChildren.get(displayNdx);
        boolean changed = this.mWmService.mDisplayWindowSettings.updateSettingsForDisplay(displayContent);
        if (changed == false) goto L10;
        displayContent.reconfigureDisplayLocked();
        if (displayContent.isDefaultDisplay == false) goto L10;
        Configuration newConfig = this.mWmService.computeNewConfiguration(displayContent.getDisplayId());
        this.mWmService.mAtmService.updateConfigurationLocked(newConfig, null, false);
    L10:
        displayNdx = displayNdx + 1;
        goto L3
    }

    boolean isLayoutNeeded() {
        int numDisplays = this.mChildren.size();
        int displayNdx = 0;
    L3:
        if (displayNdx >= numDisplays) goto L9;
        DisplayContent displayContent = (DisplayContent) this.mChildren.get(displayNdx);
        if (displayContent.isLayoutNeeded() == true) goto L6;
        displayNdx = displayNdx + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    void getWindowsByName(ArrayList<WindowState> output, String name) {
        int objectId = 0;
        objectId = Integer.parseInt(name, 16);     // Catch: RuntimeException -> L5
        name = null;
    L6:
        getWindowsByName(output, name, objectId);
    }

    private void getWindowsByName(final ArrayList<WindowState> output, final String name, final int objectId) {
        forAllWindows(new RootWindowContainer$$ExternalSyntheticLambda38(name, output, objectId), true);
    }

    private static /* synthetic */ void lambda$getWindowsByName$1(String name, ArrayList output, int objectId, WindowState w) {
        if (name == null) goto L7;
        if (w.mAttrs.getTitle().toString().contains(name) == false) goto L10;
        output.add(w);
        return;
    L10:
        return;
    L7:
        if (System.identityHashCode(w) != objectId) goto L12;
        output.add(w);
        return;
    }

    WindowToken getWindowToken(IBinder binder) {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L8;
        DisplayContent dc = (DisplayContent) this.mChildren.get(i);
        WindowToken wtoken = dc.getWindowToken(binder);
        if (wtoken != null) goto L6;
        i = i - 1;
        goto L3
    L6:
        return wtoken;
    L8:
        return null;
    }

    DisplayContent getWindowTokenDisplay(WindowToken token) {
        if (token != null) goto L5;
        return null;
    L5:
        int i = this.mChildren.size() - 1;
    L6:
        if (i < 0) goto L12;
        DisplayContent dc = (DisplayContent) this.mChildren.get(i);
        WindowToken current = dc.getWindowToken(token.token);
        if (current == token) goto L9;
        i = i - 1;
        goto L6
    L9:
        return dc;
    L12:
        return null;
    }

    void dispatchConfigurationToChild(DisplayContent child, Configuration config) {
        if (child.isDefaultDisplay == false) goto L5;
        child.performDisplayOverrideConfigUpdate(config);
        return;
    L5:
        child.onConfigurationChanged(config);
    }

    void refreshSecureSurfaceState() {
        forAllWindows(new RootWindowContainer$$ExternalSyntheticLambda44(), true);
    }

    private static /* synthetic */ void lambda$refreshSecureSurfaceState$2(WindowState w) {
        w.setSecureLocked(w.isSecureLocked());
    }

    void updateHiddenWhileSuspendedState(final ArraySet<String> packages, final boolean suspended) {
        forAllWindows(new RootWindowContainer$$ExternalSyntheticLambda27(packages, suspended), false);
    }

    private static /* synthetic */ void lambda$updateHiddenWhileSuspendedState$3(ArraySet packages, boolean suspended, WindowState w) {
        if (packages.contains(w.getOwningPackage()) == false) goto L6;
        w.setHiddenWhileSuspended(suspended);
        return;
    }

    void updateAppOpsState() {
        forAllWindows(new RootWindowContainer$$ExternalSyntheticLambda11(), false);
    }

    private static /* synthetic */ void lambda$updateAppOpsState$4(WindowState w) {
        w.updateAppOpsState();
    }

    private static /* synthetic */ boolean lambda$canShowStrictModeViolation$5(int pid, WindowState w) {
        if (w.mSession.mPid == pid) goto L5;
    L7:
        return false;
    L5:
        if (w.isVisible() == false) goto L7;
        return true;
    }

    boolean canShowStrictModeViolation(final int pid) {
        WindowState win = getWindow(new RootWindowContainer$$ExternalSyntheticLambda52(pid));
        if (win == null) goto L5;
        return true;
    L5:
        return false;
    }

    void closeSystemDialogs(String reason) {
        this.mCloseSystemDialogsReason = reason;
        forAllWindows(this.mCloseSystemDialogsConsumer, false);
    }

    boolean hasPendingLayoutChanges(WindowAnimator animator) {
        boolean hasChanges = false;
        int count = this.mChildren.size();
        int i = 0;
    L3:
        if (i >= count) goto L9;
        int pendingChanges = ((DisplayContent) this.mChildren.get(i)).pendingLayoutChanges;
        if (pendingChanges == 0) goto L7;
        hasChanges = true;
    L7:
        i = i + 1;
        goto L3
    L9:
        return hasChanges;
    }

    boolean reclaimSomeSurfaceMemory(WindowStateAnimator winAnimator, String operation, boolean secure) {
        SurfaceControl surfaceControl = winAnimator.mSurfaceControl;
        boolean leakedSurface = false;
        boolean killedApps = false;
        EventLogTags.writeWmNoSurfaceMemory(winAnimator.mWin.toString(), winAnimator.mSession.mPid, operation);
        long callingIdentity = Binder.clearCallingIdentity();
        Slog.i("WindowManager", "Out of memory for surface!  Looking for leaks...");     // Catch: Throwable -> L6
        int numDisplays = this.mChildren.size();     // Catch: Throwable -> L6
        int displayNdx = 0;
    L4:
        if (displayNdx >= numDisplays) goto L8;
        leakedSurface = leakedSurface | ((DisplayContent) this.mChildren.get(displayNdx)).destroyLeakedSurfaces();     // Catch: Throwable -> L6
        displayNdx = displayNdx + 1;     // Catch: Throwable -> L6
        goto L4
    L8:
        boolean r11 = false;
        if (leakedSurface == true) goto L40;
        Slog.w("WindowManager", "No leaked surfaces; killing applications!");     // Catch: Throwable -> L6
        final SparseIntArray pidCandidates = new SparseIntArray();     // Catch: Throwable -> L6
        boolean killedApps2 = false;
        int displayNdx2 = 0;
    L12:
        if (displayNdx2 >= numDisplays) goto L38;
        ((DisplayContent) this.mChildren.get(displayNdx2)).forAllWindows(new RootWindowContainer$$ExternalSyntheticLambda43(this, pidCandidates), r11);     // Catch: Throwable -> L20
        if (pidCandidates.size() <= 0) goto L37;
        int[] pids = new int[pidCandidates.size()];     // Catch: Throwable -> L20
        int i = 0;
    L17:
        if (i >= pids.length) goto L70;
        pids[i] = pidCandidates.keyAt(i);     // Catch: Throwable -> L20
        i = i + 1;
        goto L17
    L70:
        if (this.mWmService.mActivityManager.killPids(pids, "Free memory", secure) == false) goto L37;
        killedApps2 = true;
        goto L37
    L30:
        th = th;
    L65:
        Binder.restoreCallingIdentity(callingIdentity);
        throw th;
    L37:
        displayNdx2 = displayNdx2 + 1;
        r11 = false;
    L20:
        th = th;
        goto L65
    L38:
        killedApps = killedApps2;
    L40:
        if (leakedSurface == true) goto L67;
        if (killedApps == true) goto L67;
        boolean r15 = false;
    L60:
        Binder.restoreCallingIdentity(callingIdentity);
        if (leakedSurface == true) goto L64;
        if (killedApps == true) goto L64;
        return r15;
    L64:
        return true;
    L67:
        Slog.w("WindowManager", "Looks like we have reclaimed some memory, clearing surface for retry.");     // Catch: Throwable -> L49
        if (surfaceControl != null) goto L47;
        r15 = false;
    L69:
        winAnimator.mWin.mClient.dispatchGetNewSurface();     // Catch: Throwable -> L49 RemoteException -> L59
        goto L60
    L47:
        if (ProtoLogImpl_798997914.Cache.WM_SHOW_SURFACE_ALLOC_enabled[2] == false) goto L51;
        String protoLogParam0 = String.valueOf(winAnimator.mWin);     // Catch: Throwable -> L49
        r15 = false;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_SURFACE_ALLOC, 865845626039449679L, 0, new Object[]{protoLogParam0});     // Catch: Throwable -> L49
    L52:
        SurfaceControl.Transaction t = this.mWmService.mTransactionFactory.get();     // Catch: Throwable -> L49
        winAnimator.destroySurface(t);     // Catch: Throwable -> L49
        t.apply();     // Catch: Throwable -> L49
        if (winAnimator.mWin.mActivityRecord == null) goto L69;
        winAnimator.mWin.mActivityRecord.removeStartingWindow();     // Catch: Throwable -> L49
        goto L69
    L51:
        r15 = false;
    L49:
        th = th;
    L6:
        th = th;
        goto L65
    }

    private /* synthetic */ void lambda$reclaimSomeSurfaceMemory$6(SparseIntArray pidCandidates, WindowState w) {
        if (this.mWmService.mForceRemoves.contains(w) == false) goto L5;
        return;
    L5:
        WindowStateAnimator wsa = w.mWinAnimator;
        if (wsa.mSurfaceControl == null) goto L9;
        pidCandidates.append(wsa.mSession.mPid, wsa.mSession.mPid);
        return;
    }

    void performSurfacePlacement() {
        Trace.traceBegin(32, "performSurfacePlacement");
        performSurfacePlacementNoTrace();     // Catch: Throwable -> L6
        Trace.traceEnd(32);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }

    void performSurfacePlacementNoTrace() {
        if (WindowManagerDebugConfig.DEBUG_WINDOW_TRACE == false) goto L6;
        Slog.v("WindowManager", "performSurfacePlacementInner: entry. Called by " + Debug.getCallers(3));
    L6:
        if (this.mWmService.mFocusMayChange == false) goto L8;
        this.mWmService.mFocusMayChange = false;
        this.mWmService.updateFocusedWindowLocked(3, false);
    L8:
        this.mDisplayBrightnessOverrides.clear();
        this.mUserActivityTimeout = -1;
        this.mObscureApplicationContentOnSecondaryDisplays = false;
        this.mSustainedPerformanceModeCurrent = false;
        this.mWmService.mTransactionSequence++;
        DisplayContent defaultDisplay = this.mWmService.getDefaultDisplayContentLocked();
        WindowSurfacePlacer surfacePlacer = this.mWmService.mWindowPlacerLocked;
        Trace.traceBegin(32, "applySurfaceChanges");
        applySurfaceChangesTransaction();     // Catch: Throwable -> L11 RuntimeException -> L13
    L10:
        Trace.traceEnd(32);
        handleResizingWindows();
        clearFrameChangingWindows();
        this.mWmService.mAtmService.getLifecycleManager().dispatchPendingTransactions();
        this.mWmService.mAtmService.mTaskOrganizerController.dispatchPendingEvents();
        this.mWmService.mAtmService.mTaskFragmentOrganizerController.dispatchPendingEvents();
        this.mWmService.mSyncEngine.onSurfacePlacement();
        this.mWmService.getExt().tryFinishSwitchResolution();
        this.mWmService.mAtmService.mBackNavigationController.checkAnimationReady(defaultDisplay.mWallpaperController);
        int displayNdx = 0;
    L18:
        if (displayNdx >= this.mChildren.size()) goto L29;
        DisplayContent displayContent = (DisplayContent) this.mChildren.get(displayNdx);
        if (displayContent.mWallpaperMayChange == false) goto L27;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[1] == false) goto L24;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WALLPAPER, -4150611780753674023L, 0, null);
    L24:
        displayContent.pendingLayoutChanges |= 4;
        if (WindowManagerDebugConfig.DEBUG_LAYOUT_REPEATS == false) goto L27;
        surfacePlacer.debugLayoutRepeats("WallpaperMayChange", displayContent.pendingLayoutChanges);
    L27:
        displayNdx = displayNdx + 1;
        goto L18
    L29:
        if (this.mWmService.mFocusMayChange == false) goto L32;
        this.mWmService.mFocusMayChange = false;
        this.mWmService.updateFocusedWindowLocked(2, false);
    L32:
        if (isLayoutNeeded() == false) goto L36;
        defaultDisplay.pendingLayoutChanges |= 1;
        if (WindowManagerDebugConfig.DEBUG_LAYOUT_REPEATS == false) goto L36;
        surfacePlacer.debugLayoutRepeats("mLayoutNeeded", defaultDisplay.pendingLayoutChanges);
    L36:
        int i = this.mWmService.mDestroySurface.size();
        if (i <= 0) goto L47;
    L38:
        i = i - 1;
        WindowState win = this.mWmService.mDestroySurface.get(i);
        win.mDestroying = false;
        DisplayContent displayContent2 = win.getDisplayContent();
        if (displayContent2.mInputMethodWindow != win) goto L42;
        displayContent2.setInputMethodWindowLocked(null);
    L42:
        if (displayContent2.mWallpaperController.isWallpaperTarget(win) == false) goto L44;
        displayContent2.pendingLayoutChanges |= 4;
    L44:
        win.destroySurfaceUnchecked();
        if (i > 0) goto L38;
        this.mWmService.mDestroySurface.clear();
    L47:
        int displayNdx2 = 0;
    L49:
        if (displayNdx2 >= this.mChildren.size()) goto L54;
        DisplayContent displayContent3 = (DisplayContent) this.mChildren.get(displayNdx2);
        if (displayContent3.pendingLayoutChanges == 0) goto L53;
        displayContent3.setLayoutNeeded();
    L53:
        displayNdx2 = displayNdx2 + 1;
        goto L49
    L54:
        this.mHandler.obtainMessage(1, this.mDisplayBrightnessOverrides.clone()).sendToTarget();
        this.mHandler.obtainMessage(2, Long.valueOf(this.mUserActivityTimeout)).sendToTarget();
        if (this.mSustainedPerformanceModeCurrent == this.mSustainedPerformanceModeEnabled) goto L58;
        this.mSustainedPerformanceModeEnabled = this.mSustainedPerformanceModeCurrent;
        this.mWmService.mPowerManagerInternal.setPowerMode(2, this.mSustainedPerformanceModeEnabled);
    L58:
        if (this.mUpdateRotation == false) goto L64;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[0] == false) goto L62;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -5513616928833586179L, 0, null);
    L62:
        this.mUpdateRotation = updateRotationUnchecked();
    L64:
        if (this.mWmService.mWaitingForDrawnCallbacks.isEmpty() == true) goto L66;
    L69:
        this.mWmService.checkDrawnWindowsLocked();
    L70:
        forAllDisplays(new RootWindowContainer$$ExternalSyntheticLambda40());
        this.mWmService.enableScreenIfNeededLocked();
        this.mWmService.scheduleAnimationLocked();
        if (WindowManagerDebugConfig.DEBUG_WINDOW_TRACE == false) goto L88;
        Slog.e("WindowManager", "performSurfacePlacementInner exit");
        return;
    L88:
        return;
    L66:
        if (isLayoutNeeded() == true) goto L70;
        if (this.mUpdateRotation == true) goto L70;
    L13:
        e = move-exception;
        Slog.wtf("WindowManager", "Unhandled exception in Window Manager", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }

    private static /* synthetic */ void lambda$performSurfacePlacementNoTrace$7(DisplayContent dc) {
        dc.getInputMonitor().updateInputWindowsLw(true);
        dc.updateSystemGestureExclusion();
        dc.updateKeepClearAreas();
    }

    private void applySurfaceChangesTransaction() {
        DisplayContent defaultDc = this.mDefaultDisplay;
        DisplayInfo defaultInfo = defaultDc.getDisplayInfo();
        int defaultDw = defaultInfo.logicalWidth;
        int defaultDh = defaultInfo.logicalHeight;
        SurfaceControl.Transaction t = defaultDc.getSyncTransaction();
        if (this.mWmService.mWatermark == null) goto L6;
        this.mWmService.mWatermark.positionSurface(defaultDw, defaultDh, t);
    L6:
        if (this.mWmService.mStrictModeFlash == null) goto L9;
        this.mWmService.mStrictModeFlash.positionSurface(defaultDw, defaultDh, t);
    L9:
        if (this.mWmService.mEmulatorDisplayOverlay == null) goto L11;
        this.mWmService.mEmulatorDisplayOverlay.positionSurface(defaultDw, defaultDh, defaultDc.getRotation(), t);
    L11:
        this.mWmService.getSmtEx().clearVisibleUidsBk();
        getRWCSmtEx().dispatchVisibleWindowCleared();
        int count = this.mChildren.size();
        int j = 0;
    L12:
        if (j >= count) goto L14;
        DisplayContent dc = (DisplayContent) this.mChildren.get(j);
        dc.applySurfaceChangesTransaction();
        this.mDisplayTransactions.append(dc.mDisplayId, dc.getSyncTransaction());
        j = j + 1;
        goto L12
    L14:
        this.mWmService.getSmtEx().saveVisibleUids();
        this.mWmService.getSmtEx().saveFloatingWindowUids();
        this.mWmService.mDisplayManagerInternal.performTraversal(t, this.mDisplayTransactions);
        this.mDisplayTransactions.clear();
    }

    private void handleResizingWindows() {
        int i = this.mWmService.mResizingWindows.size() - 1;
    L3:
        if (i < 0) goto L10;
        WindowState win = this.mWmService.mResizingWindows.get(i);
        if (win.getDisplayContent().mWaitingForConfig == true) goto L8;
        win.updateSurfacePositionIfNeeded();
        win.reportResized();
        this.mWmService.mResizingWindows.remove(i);
    L8:
        i = i - 1;
        goto L3
    }

    private void clearFrameChangingWindows() {
        ArrayList<WindowState> frameChangingWindows = this.mWmService.mFrameChangingWindows;
        int i = frameChangingWindows.size() - 1;
    L3:
        if (i < 0) goto L5;
        frameChangingWindows.get(i).updateLastFrames();
        i = i - 1;
        goto L3
    L5:
        frameChangingWindows.clear();
    }

    boolean handleNotObscuredLocked(WindowState w, boolean obscured, boolean syswin) {
        boolean onScreen = w.isOnScreen();
        boolean displayHasContent = false;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_KEEP_SCREEN_ON_enabled[0] == false) goto L5;
        String protoLogParam0 = String.valueOf(w);
        boolean protoLogParam1 = w.mHasSurface;
        boolean protoLogParam3 = w.isDisplayed();
        long protoLogParam4 = w.mAttrs.userActivityTimeout;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_KEEP_SCREEN_ON, -7698723716637247994L, TarConstants.XSTAR_MAGIC_OFFSET, new Object[]{protoLogParam0, Boolean.valueOf(protoLogParam1), Boolean.valueOf(onScreen), Boolean.valueOf(protoLogParam3), Long.valueOf(protoLogParam4)});
    L5:
        w.getWindowStateSysEx().saveLastVisibleState();
        w.getWindowStateSysEx().updateCurrentVisibleState(false);
        if (w.getTask() != null) goto L8;
    L10:
        if (onScreen == true) goto L13;
        return false;
    L13:
        if (syswin == true) goto L22;
        if (w.mAttrs.userActivityTimeout < 0) goto L22;
        if (this.mUserActivityTimeout >= 0) goto L22;
        this.mUserActivityTimeout = w.mAttrs.userActivityTimeout;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_KEEP_SCREEN_ON_enabled[0] == false) goto L22;
        long protoLogParam2 = this.mUserActivityTimeout;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_KEEP_SCREEN_ON, 8621291657500572364L, 1, new Object[]{Long.valueOf(protoLogParam2)});
    L22:
        if (w.isDrawn() == false) goto L24;
    L29:
        if (syswin == false) goto L31;
    L37:
        DisplayContent displayContent = w.getDisplayContent();
        if (displayContent != null) goto L40;
    L48:
        if (displayContent != null) goto L50;
    L58:
        if ((w.mAttrs.privateFlags & 65536) == 0) goto L61;
        this.mSustainedPerformanceModeCurrent = true;
    L61:
        if (WindowManagerServiceSmtBase.isOperatible(w) == false) goto L68;
        this.mWmService.getSmtEx().addVisibleUidBk(w.mOwnerUid);
        w.getWindowStateSysEx().updateCurrentVisibleState(true);
        if (w.getWindowStateSysEx().firstVisible() == false) goto L68;
        boolean uidFreezing = SysOptBridge.getFactory().getApplicationFreezer().isUidFrozen(w.mOwnerUid);
        Slog.i("WindowManager", "window first visible. w=" + w + " uid=" + w.mOwnerUid + " freeze=" + uidFreezing);
        if (uidFreezing == false) goto L68;
        w.getProcess().getWPCSmtEx().unFreezeProcIfNeedLocked(new UpdateVisibilityEvent(w.getProcess()));
    L68:
        if (w.mAttrs.type != 2038) goto L70;
    L77:
        this.mWmService.getSmtEx().addFloatingWindowUid(w.mOwnerUid);
    L78:
        return displayHasContent;
    L70:
        if (w.mAttrs.type == 2003) goto L77;
        if (w.mAttrs.type == 2005) goto L77;
        if (w.mAttrs.type == 2002) goto L77;
        if (w.getWindowingMode() != 5) goto L78;
    L50:
        if (this.mObscureApplicationContentOnSecondaryDisplays == true) goto L52;
    L56:
        displayHasContent = true;
        goto L58
    L52:
        if (displayContent.isKeyguardAlwaysUnlocked() == true) goto L56;
        if (obscured == false) goto L58;
        if (w.mAttrs.type != 2009) goto L58;
    L40:
        if (displayContent.isDefaultDisplay == false) goto L48;
        if (w.isDreamWindow() == false) goto L44;
    L45:
        this.mObscureApplicationContentOnSecondaryDisplays = true;
    L46:
        displayHasContent = true;
        goto L58
    L44:
        if (this.mWmService.mPolicy.isKeyguardShowing() == false) goto L46;
    L31:
        if (w.mAttrs.screenBrightness < 0.0f) goto L37;
        if (w.mAttrs.screenBrightness > 1.0f) goto L37;
        if (this.mDisplayBrightnessOverrides.contains(w.getDisplayId()) == true) goto L37;
        DisplayManagerInternal.DisplayBrightnessOverrideRequest brightnessOverride = new DisplayManagerInternal.DisplayBrightnessOverrideRequest();
        brightnessOverride.brightness = w.mAttrs.screenBrightness;
        brightnessOverride.tag = w.getWindowTag();
        this.mDisplayBrightnessOverrides.put(w.getDisplayId(), brightnessOverride);
        goto L37
    L24:
        if (w.mActivityRecord == null) goto L78;
        if (w.mActivityRecord.firstWindowDrawn == false) goto L78;
        if (w.mActivityRecord.isVisibleRequested() == false) goto L78;
    L8:
        if (w.getTask().getExt().isSuspended() == false) goto L10;
        this.mWmService.getSmtEx().addFloatingWindowUid(w.mOwnerUid);
        goto L10
    }

    boolean updateRotationUnchecked() {
        boolean changed = false;
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L9;
        if (((DisplayContent) this.mChildren.get(i)).getDisplayRotation().updateRotationAndSendNewConfigIfChanged() == false) goto L7;
        changed = true;
    L7:
        i = i - 1;
        goto L3
    L9:
        return changed;
    }

    void dumpDisplayContents(PrintWriter pw) {
        pw.println("WINDOW MANAGER DISPLAY CONTENTS (dumpsys window displays)");
        if (this.mWmService.mDisplayReady == false) goto L8;
        int count = this.mChildren.size();
        int i = 0;
    L5:
        if (i >= count) goto L11;
        DisplayContent displayContent = (DisplayContent) this.mChildren.get(i);
        displayContent.dump(pw, "  ", true);
        i = i + 1;
        goto L5
    L11:
        return;
    L8:
        pw.println("  NO DISPLAY");
    }

    void dumpTopFocusedDisplayId(PrintWriter pw) {
        pw.print("  mTopFocusedDisplayId=");
        pw.println(this.mTopFocusedDisplayId);
    }

    void dumpLayoutNeededDisplayIds(PrintWriter pw) {
        if (isLayoutNeeded() == true) goto L5;
        return;
    L5:
        pw.print("  mLayoutNeeded on displays=");
        int count = this.mChildren.size();
        int displayNdx = 0;
    L6:
        if (displayNdx >= count) goto L11;
        DisplayContent displayContent = (DisplayContent) this.mChildren.get(displayNdx);
        if (displayContent.isLayoutNeeded() == false) goto L10;
        pw.print(displayContent.getDisplayId());
    L10:
        displayNdx = displayNdx + 1;
        goto L6
    L11:
        pw.println();
    }

    void dumpWindowsNoHeader(final PrintWriter pw, final boolean dumpAll, final ArrayList<WindowState> windows) {
        final int[] index = new int[1];
        forAllWindows(new RootWindowContainer$$ExternalSyntheticLambda33(windows, pw, index, dumpAll), true);
    }

    private static /* synthetic */ void lambda$dumpWindowsNoHeader$8(ArrayList windows, PrintWriter pw, int[] index, boolean dumpAll, WindowState w) {
        if (windows != null) goto L4;
    L5:
        pw.println("  Window #" + index[0] + " " + w + ":");
        if (dumpAll == true) goto L10;
        if (windows != null) goto L10;
        boolean r2 = false;
    L11:
        w.dump(pw, "    ", r2);
        index[0] = index[0] + 1;
        return;
    L10:
        r2 = true;
        goto L11
    L4:
        if (windows.contains(w) == true) goto L5;
    }

    void dumpTokens(PrintWriter pw, boolean dumpAll) {
        pw.println("  All tokens:");
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L6;
        ((DisplayContent) this.mChildren.get(i)).dumpTokens(pw, dumpAll);
        i = i - 1;
        goto L3
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public void dumpDebug(ProtoOutputStream proto, long fieldId, int logLevel) {
        if (logLevel == 2) goto L5;
    L7:
        long token = proto.start(fieldId);
        super.dumpDebug(proto, 1146756268033L, logLevel);
        this.mTaskSupervisor.getKeyguardController().dumpDebug(proto, 1146756268037L);
        proto.write(1133871366150L, this.mTaskSupervisor.mRecentTasks.isRecentsComponentHomeActivity(this.mCurrentUser));
        proto.end(token);
        return;
    L5:
        if (isVisible() == true) goto L7;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    String getName() {
        return "ROOT";
    }

    protected void removeChild(DisplayContent dc) {
        super.removeChild(dc);
        if (this.mTopFocusedDisplayId != dc.getDisplayId()) goto L6;
        this.mWmService.updateFocusedWindowLocked(0, true);
        return;
    }

    void forAllDisplays(Consumer<DisplayContent> callback) {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L6;
        callback.accept((DisplayContent) this.mChildren.get(i));
        i = i - 1;
        goto L3
    }

    void forAllDisplayPolicies(Consumer<DisplayPolicy> callback) {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L6;
        callback.accept(((DisplayContent) this.mChildren.get(i)).getDisplayPolicy());
        i = i - 1;
        goto L3
    }

    WindowState getCurrentInputMethodWindow() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L9;
        DisplayContent displayContent = (DisplayContent) this.mChildren.get(i);
        if (displayContent.mInputMethodWindow != null) goto L7;
        i = i - 1;
        goto L3
    L7:
        return displayContent.mInputMethodWindow;
    L9:
        return null;
    }

    void getDisplayContextsWithNonToastVisibleWindows(final int pid, List<Context> outContexts) {
        if (outContexts != null) goto L4;
        return;
    L4:
        int i = this.mChildren.size() - 1;
    L5:
        if (i < 0) goto L11;
        DisplayContent dc = (DisplayContent) this.mChildren.get(i);
        if (dc.getWindow(new RootWindowContainer$$ExternalSyntheticLambda26(pid)) == null) goto L9;
        outContexts.add(dc.getDisplayUiContext());
    L9:
        i = i - 1;
        goto L5
    }

    private static /* synthetic */ boolean lambda$getDisplayContextsWithNonToastVisibleWindows$9(int pid, WindowState w) {
        if (pid == w.mSession.mPid) goto L5;
    L9:
        return false;
    L5:
        if (w.isVisibleNow() == false) goto L9;
        if (w.mAttrs.type == 2005) goto L9;
        return true;
    }

    Context getDisplayUiContext(int displayId) {
        if (getDisplayContent(displayId) != null) goto L7;
        return null;
    L7:
        return getDisplayContent(displayId).getDisplayUiContext();
    }

    void setWindowManager(WindowManagerService wm) {
        this.mWindowManager = wm;
        this.mDisplayManager = (DisplayManager) this.mService.mContext.getSystemService(DisplayManager.class);
        this.mDisplayManager.registerDisplayListener(this, this.mService.mUiHandler);
        this.mDisplayManagerInternal = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
        Display[] displays = this.mDisplayManager.getDisplays();
        int displayNdx = 0;
    L4:
        if (displayNdx >= displays.length) goto L9;
        Display display = displays[displayNdx];
        DisplayContent displayContent = new DisplayContent(display, this, this.mDeviceStateController);
        addChild(displayContent, Integer.MIN_VALUE);
        if (displayContent.mDisplayId != 0) goto L8;
        this.mDefaultDisplay = displayContent;
    L8:
        displayNdx = displayNdx + 1;
        goto L4
    L9:
        TaskDisplayArea defaultTaskDisplayArea = getDefaultTaskDisplayArea();
        defaultTaskDisplayArea.getOrCreateRootHomeTask(true);
        positionChildAt(Integer.MAX_VALUE, defaultTaskDisplayArea.mDisplayContent, false);
    }

    void onDisplayManagerReceivedDeviceState(int deviceState) {
        this.mDeviceStateController.onDeviceStateReceivedByDisplayManager(deviceState);
    }

    DisplayContent getDefaultDisplay() {
        return this.mDefaultDisplay;
    }

    DisplayRotationCoordinator getDisplayRotationCoordinator() {
        return this.mDisplayRotationCoordinator;
    }

    TaskDisplayArea getDefaultTaskDisplayArea() {
        return this.mDefaultDisplay.getDefaultTaskDisplayArea();
    }

    DisplayContent getDisplayContent(String uniqueId) {
        int i = getChildCount() - 1;
    L3:
        if (i < 0) goto L10;
        DisplayContent display = getChildAt(i);
        boolean isValid = display.mDisplay.isValid();
        if (isValid == false) goto L9;
        if (display.mDisplay.getUniqueId().equals(uniqueId) == false) goto L9;
        return display;
    L9:
        i = i - 1;
        goto L3
    L10:
        return null;
    }

    DisplayContent getDisplayContent(int displayId) {
        int i = getChildCount() - 1;
    L3:
        if (i < 0) goto L8;
        DisplayContent displayContent = getChildAt(i);
        if (displayContent.mDisplayId == displayId) goto L6;
        i = i - 1;
        goto L3
    L6:
        return displayContent;
    L8:
        return null;
    }

    DisplayContent getDisplayContentOrCreate(int displayId) {
        DisplayContent displayContent = getDisplayContent(displayId);
        if (displayContent == null) goto L6;
        return displayContent;
    L6:
        if (this.mDisplayManager != null) goto L8;
        return null;
    L8:
        Display display = this.mDisplayManager.getDisplay(displayId);
        if (display != null) goto L11;
        return null;
    L11:
        DisplayContent displayContent2 = new DisplayContent(display, this, this.mDeviceStateController);
        addChild(displayContent2, Integer.MIN_VALUE);
        return displayContent2;
    }

    ActivityRecord getDefaultDisplayHomeActivityForUser(int userId) {
        return getDefaultTaskDisplayArea().getHomeActivityForUser(userId);
    }

    boolean startHomeOnAllDisplays(int userId, String reason) {
        boolean homeStarted = false;
        int i = getChildCount() - 1;
    L3:
        if (i < 0) goto L6;
        int displayId = getChildAt(i).mDisplayId;
        homeStarted = homeStarted | startHomeOnDisplay(userId, reason, displayId);
        i = i - 1;
        goto L3
    L6:
        return homeStarted;
    }

    void startHomeOnEmptyDisplays(final String reason) {
        forAllTaskDisplayAreas(new RootWindowContainer$$ExternalSyntheticLambda32(this, reason));
    }

    private /* synthetic */ void lambda$startHomeOnEmptyDisplays$10(String reason, TaskDisplayArea taskDisplayArea) {
        if (taskDisplayArea.topRunningActivity() != null) goto L6;
        int userId = this.mWmService.getUserAssignedToDisplay(taskDisplayArea.getDisplayId());
        startHomeOnTaskDisplayArea(userId, reason, taskDisplayArea, false, false);
        return;
    }

    boolean startHomeOnDisplay(int userId, String reason, int displayId) {
        return startHomeOnDisplay(userId, reason, displayId, false, false);
    }

    boolean startHomeOnDisplay(final int userId, final String reason, int displayId, final boolean allowInstrumenting, final boolean fromHomeKey) {
        if (displayId != (-1)) goto L9;
        Task rootTask = getTopDisplayFocusedRootTask();
        if (rootTask == null) goto L7;
        int r2 = rootTask.getDisplayId();
    L8:
        displayId = r2;
        goto L9
    L7:
        r2 = 0;
    L9:
        DisplayContent display = getDisplayContentOrCreate(displayId);
        return ((Boolean) display.reduceOnAllTaskDisplayAreas(new RootWindowContainer$$ExternalSyntheticLambda53(this, userId, reason, allowInstrumenting, fromHomeKey), false)).booleanValue();
    }

    private /* synthetic */ Boolean lambda$startHomeOnDisplay$11(int userId, String reason, boolean allowInstrumenting, boolean fromHomeKey, TaskDisplayArea taskDisplayArea, Boolean result) {
        boolean r0 = result.booleanValue();
        return Boolean.valueOf(startHomeOnTaskDisplayArea(userId, reason, taskDisplayArea, allowInstrumenting, fromHomeKey) | r0);
    }

    boolean startHomeOnTaskDisplayArea(int userId, String reason, TaskDisplayArea taskDisplayArea, boolean allowInstrumenting, boolean fromHomeKey) {
        if (taskDisplayArea != null) goto L9;
        Task rootTask = getTopDisplayFocusedRootTask();
        if (rootTask == null) goto L6;
        TaskDisplayArea r1 = rootTask.getDisplayArea();
    L7:
        taskDisplayArea = r1;
        goto L9
    L6:
        r1 = getDefaultTaskDisplayArea();
    L9:
        if (DesktopExperienceFlags.ENABLE_DISPLAY_CONTENT_MODE_MANAGEMENT.isTrue() == true) goto L11;
    L13:
        Intent homeIntent = null;
        ActivityInfo aInfo = null;
        if (taskDisplayArea != getDefaultTaskDisplayArea()) goto L16;
    L21:
        homeIntent = this.mService.getHomeIntent();
        aInfo = resolveHomeActivity(userId, homeIntent);
    L22:
        if (aInfo == null) goto L37;
        if (homeIntent == null) goto L37;
        if (canStartHomeOnDisplayArea(aInfo, taskDisplayArea, allowInstrumenting) == true) goto L29;
        return false;
    L29:
        if (this.mService.mAmInternal.shouldDelayHomeLaunch(userId) == false) goto L32;
        Slog.d("WindowManager", "ThemeHomeDelay: Home launch was deferred with user " + userId);
        return false;
    L32:
        homeIntent.setComponent(new ComponentName(aInfo.applicationInfo.packageName, aInfo.name));
        homeIntent.setFlags(homeIntent.getFlags() | 268435456);
        if (fromHomeKey == false) goto L35;
        homeIntent.putExtra("android.intent.extra.FROM_HOME_KEY", true);
    L35:
        homeIntent.putExtra("android.intent.extra.EXTRA_START_REASON", reason);
        String myReason = reason + ":" + userId + ":" + UserHandle.getUserId(aInfo.applicationInfo.uid) + ":" + taskDisplayArea.getDisplayId();
        this.mService.getActivityStartController().startHomeActivity(homeIntent, aInfo, myReason, taskDisplayArea);
        return true;
    L37:
        return false;
    L16:
        if (this.mWmService.shouldPlacePrimaryHomeOnDisplay(taskDisplayArea.getDisplayId(), userId) == true) goto L21;
        if (shouldPlaceSecondaryHomeOnDisplayArea(taskDisplayArea) == false) goto L22;
        Pair<ActivityInfo, Intent> info = resolveSecondaryHomeActivity(userId, taskDisplayArea);
        aInfo = (ActivityInfo) info.first;
        homeIntent = (Intent) info.second;
        goto L22
    L11:
        if (taskDisplayArea.shouldKeepNoTask() == false) goto L13;
        taskDisplayArea.setShouldKeepNoTask(false);
        goto L13
    }

    ActivityInfo resolveHomeActivity(int userId, Intent homeIntent) {
        ComponentName comp = homeIntent.getComponent();
        ActivityInfo aInfo = null;
        if (comp != null) goto L28;
        String resolvedType = homeIntent.resolveTypeIfNeeded(this.mService.mContext.getContentResolver());     // Catch: RemoteException -> L17
        int userId2 = userId;
        Intent homeIntent2 = homeIntent;
        ResolveInfo info = this.mTaskSupervisor.resolveIntent(homeIntent2, resolvedType, userId2, 1024, Binder.getCallingUid(), Binder.getCallingPid());     // Catch: RemoteException -> L14
        if (info == null) goto L19;
        aInfo = info.activityInfo;     // Catch: RemoteException -> L14
    L19:
        if (aInfo != null) goto L22;
        Slogf.wtf("WindowManager", new Exception(), "No home screen found for %s and user %d", new Object[]{homeIntent2, Integer.valueOf(userId2)});
        return null;
    L22:
        ActivityInfo aInfo2 = new ActivityInfo(aInfo);
        aInfo2.applicationInfo = this.mService.getAppInfoForUser(aInfo2.applicationInfo, userId2);
        return aInfo2;
    L18:
        userId2 = userId;
        homeIntent2 = homeIntent;
        goto L19
    L28:
        aInfo = AppGlobals.getPackageManager().getActivityInfo(comp, DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, userId);     // Catch: RemoteException -> L6
        userId2 = userId;
        homeIntent2 = homeIntent;
    L7:
        userId2 = userId;
        homeIntent2 = homeIntent;
        goto L19
    }

    Pair<ActivityInfo, Intent> resolveSecondaryHomeActivity(int userId, TaskDisplayArea taskDisplayArea) {
        if (taskDisplayArea == getDefaultTaskDisplayArea()) goto L39;
        Intent homeIntent = this.mService.getHomeIntent();
        ActivityInfo aInfo = resolveHomeActivity(userId, homeIntent);
        if (aInfo == null) goto L7;
        boolean lookForSecondaryHomeActivityInPrimaryHomePackage = true;
    L9:
        if (taskDisplayArea.getDisplayContent() == null) goto L11;
        ComponentName customHomeComponent = taskDisplayArea.getDisplayContent().getCustomHomeComponent();
    L13:
        if (customHomeComponent == null) goto L17;
        homeIntent.setComponent(customHomeComponent);
        ActivityInfo customHomeActivityInfo = resolveHomeActivity(userId, homeIntent);
        if (customHomeActivityInfo == null) goto L17;
        aInfo = customHomeActivityInfo;
        lookForSecondaryHomeActivityInPrimaryHomePackage = false;
    L17:
        if (lookForSecondaryHomeActivityInPrimaryHomePackage == true) goto L19;
    L30:
        if (aInfo != null) goto L32;
    L34:
        if (aInfo != null) goto L37;
        homeIntent = this.mService.getSecondaryHomeIntent(null);
        aInfo = resolveHomeActivity(userId, homeIntent);
    L37:
        return Pair.create(aInfo, homeIntent);
    L32:
        if (canStartHomeOnDisplayArea(aInfo, taskDisplayArea, false) == true) goto L34;
        aInfo = null;
        goto L34
    L19:
        if (ResolverActivity.class.getName().equals(aInfo.name) == false) goto L21;
        aInfo = null;
        goto L30
    L21:
        homeIntent = this.mService.getSecondaryHomeIntent(aInfo.applicationInfo.packageName);
        List<ResolveInfo> resolutions = resolveActivities(userId, homeIntent);
        int size = resolutions.size();
        String targetName = aInfo.name;
        aInfo = null;
        int i = 0;
    L22:
        if (i >= size) goto L27;
        ResolveInfo resolveInfo = resolutions.get(i);
        if (resolveInfo.activityInfo.name.equals(targetName) == true) goto L25;
        i = i + 1;
        goto L22
    L25:
        aInfo = resolveInfo.activityInfo;
    L27:
        if (aInfo != null) goto L30;
        if (size <= 0) goto L30;
        aInfo = resolutions.get(0).activityInfo;
        goto L30
    L11:
        customHomeComponent = null;
        goto L13
    L7:
        lookForSecondaryHomeActivityInPrimaryHomePackage = false;
        goto L9
    L39:
        throw new IllegalArgumentException("resolveSecondaryHomeActivity: Should not be default task container");
    }

    List<ResolveInfo> resolveActivities(int userId, Intent homeIntent) {
        String resolvedType = homeIntent.resolveTypeIfNeeded(this.mService.mContext.getContentResolver());     // Catch: RemoteException -> L8
        List<ResolveInfo> resolutions = AppGlobals.getPackageManager().queryIntentActivities(homeIntent, resolvedType, DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, userId).getList();     // Catch: RemoteException -> L6
        return resolutions;
    L10:
        List<ResolveInfo> resolutions2 = new ArrayList();
        return resolutions2;
    }

    boolean resumeHomeActivity(ActivityRecord prev, String reason, TaskDisplayArea taskDisplayArea) {
        if (this.mService.isBooting() == false) goto L5;
    L8:
        if (taskDisplayArea != null) goto L10;
        TaskDisplayArea taskDisplayArea2 = getDefaultTaskDisplayArea();
    L11:
        ActivityRecord r = taskDisplayArea2.getHomeActivity();
        String myReason = reason + " resumeHomeActivity";
        if (r != null) goto L14;
    L17:
        int userId = this.mWmService.getUserAssignedToDisplay(taskDisplayArea2.getDisplayId());
        return startHomeOnTaskDisplayArea(userId, myReason, taskDisplayArea2, false, false);
    L14:
        if (r.finishing == true) goto L17;
        r.moveFocusableActivityToTop(myReason);
        return resumeFocusedTasksTopActivities(r.getRootTask(), prev);
    L10:
        taskDisplayArea2 = taskDisplayArea;
        goto L11
    L5:
        if (this.mService.isBooted() == true) goto L8;
        return false;
    }

    boolean shouldPlacePrimaryHomeOnDisplay(int displayId) {
        if (displayId != 0) goto L4;
    L11:
        return true;
    L4:
        if (displayId != (-1)) goto L6;
    L10:
        return false;
    L6:
        if (displayId == this.mService.mVr2dDisplayId) goto L11;
        if (this.mWmService.shouldPlacePrimaryHomeOnDisplay(displayId) == false) goto L10;
        goto L10
    }

    boolean shouldPlaceSecondaryHomeOnDisplayArea(TaskDisplayArea taskDisplayArea) {
        if (getDefaultTaskDisplayArea() == taskDisplayArea) goto L34;
        if (taskDisplayArea != null) goto L8;
        return false;
    L8:
        if (taskDisplayArea.canHostHomeTask() == true) goto L11;
        return false;
    L11:
        if (taskDisplayArea.getDisplayId() == 0) goto L16;
        if (this.mService.mSupportsMultiDisplay == true) goto L16;
        return false;
    L16:
        if (Settings.Global.getInt(this.mService.mContext.getContentResolver(), "device_provisioned", 0) == 0) goto L18;
        boolean deviceProvisioned = true;
    L19:
        if (deviceProvisioned == true) goto L22;
        return false;
    L22:
        if (StorageManager.isCeStorageUnlocked(this.mCurrentUser) == true) goto L24;
        return false;
    L24:
        DisplayContent display = taskDisplayArea.getDisplayContent();
        if (display != null) goto L27;
    L32:
        return false;
    L27:
        if (display.isRemoved() == true) goto L32;
        if (display.isHomeSupported() == false) goto L32;
        return true;
    L18:
        deviceProvisioned = false;
        goto L19
    L34:
        throw new IllegalArgumentException("shouldPlaceSecondaryHomeOnDisplay: Should not be on default task container");
    }

    boolean canStartHomeOnDisplayArea(ActivityInfo homeInfo, TaskDisplayArea taskDisplayArea, boolean allowInstrumenting) {
        if (this.mService.mFactoryTest == 1) goto L5;
    L7:
        WindowProcessController app = this.mService.getProcessController(homeInfo.processName, homeInfo.applicationInfo.uid);
        if (allowInstrumenting == true) goto L13;
        if (app == null) goto L13;
        if (app.isInstrumenting() == false) goto L13;
        return false;
    L13:
        if (taskDisplayArea != null) goto L15;
    L17:
        if (taskDisplayArea == null) goto L19;
        int displayId = taskDisplayArea.getDisplayId();
    L21:
        if (shouldPlacePrimaryHomeOnDisplay(displayId) == false) goto L24;
        return true;
    L24:
        if (shouldPlaceSecondaryHomeOnDisplayArea(taskDisplayArea) == true) goto L27;
        return false;
    L27:
        if (homeInfo.launchMode != 2) goto L29;
    L31:
        boolean supportMultipleInstance = false;
    L32:
        if (supportMultipleInstance == true) goto L34;
        return false;
    L34:
        return true;
    L29:
        if (homeInfo.launchMode == 3) goto L31;
        supportMultipleInstance = true;
        goto L32
    L19:
        displayId = -1;
        goto L21
    L15:
        if (taskDisplayArea.canHostHomeTask() == true) goto L17;
        return false;
    L5:
        if (this.mService.mTopAction != null) goto L7;
        return false;
    }

    void ensureVisibilityAndConfig(ActivityRecord starting, DisplayContent displayContent, boolean deferResume) {
        ensureActivitiesVisible(null, false);
        Configuration config = displayContent.updateOrientationAndComputeConfig(true);
        if (starting == null) goto L5;
        starting.reportDescendantOrientationChangeIfNeeded();
    L5:
        displayContent.updateDisplayOverrideConfigurationLocked(config, starting, deferResume);
    }

    List<ActivityAssistInfo> getTopVisibleActivities() {
        final ArrayList<ActivityAssistInfo> topVisibleActivities = new ArrayList();
        final ArrayList<ActivityAssistInfo> activityAssistInfos = new ArrayList();
        final Task topFocusedRootTask = getTopDisplayFocusedRootTask();
        forAllRootTasks(new RootWindowContainer$$ExternalSyntheticLambda7(activityAssistInfos, topFocusedRootTask, topVisibleActivities));
        return topVisibleActivities;
    }

    private static /* synthetic */ void lambda$getTopVisibleActivities$13(final ArrayList activityAssistInfos, Task topFocusedRootTask, ArrayList topVisibleActivities, Task rootTask) {
        if (rootTask.shouldBeVisible(null) == false) goto L11;
        ActivityRecord top = rootTask.getTopNonFinishingActivity();
        if (top == null) goto L12;
        activityAssistInfos.clear();
        activityAssistInfos.add(new ActivityAssistInfo(top));
        top.getTask().forOtherAdjacentTasks(new RootWindowContainer$$ExternalSyntheticLambda6(activityAssistInfos));
        if (rootTask != topFocusedRootTask) goto L9;
        topVisibleActivities.addAll(0, activityAssistInfos);
        return;
    L9:
        topVisibleActivities.addAll(activityAssistInfos);
        return;
    L12:
        return;
    }

    private static /* synthetic */ void lambda$getTopVisibleActivities$12(ArrayList activityAssistInfos, Task task) {
        ActivityRecord adjacentActivityRecord = task.getTopNonFinishingActivity();
        if (adjacentActivityRecord == null) goto L6;
        activityAssistInfos.add(new ActivityAssistInfo(adjacentActivityRecord));
        return;
    }

    public Task getTopDisplayFocusedRootTask() {
        int i = getChildCount() - 1;
    L3:
        if (i < 0) goto L8;
        Task focusedRootTask = getChildAt(i).getFocusedRootTask();
        if (focusedRootTask != null) goto L6;
        i = i - 1;
        goto L3
    L6:
        return focusedRootTask;
    L8:
        return null;
    }

    ActivityRecord getTopResumedActivity() {
        Task focusedRootTask = getTopDisplayFocusedRootTask();
        if (focusedRootTask != null) goto L6;
        return null;
    L6:
        ActivityRecord resumedActivity = focusedRootTask.getTopResumedActivity();
        if (resumedActivity == null) goto L12;
        if (resumedActivity.app == null) goto L12;
        return resumedActivity;
    L12:
        return (ActivityRecord) getItemFromTaskDisplayAreas(new RootWindowContainer$$ExternalSyntheticLambda28());
    }

    boolean isTopDisplayFocusedRootTask(Task task) {
        if (task != null) goto L4;
    L6:
        return false;
    L4:
        if (task != getTopDisplayFocusedRootTask()) goto L6;
        return true;
    }

    boolean attachApplication(WindowProcessController app) throws RemoteException {
        app.mHasEverAttached = true;
        ArrayList<ActivityRecord> activities = this.mService.mStartingProcessActivities;
        RemoteException remoteException = null;
        boolean hasActivityStarted = false;
        int i = activities.size() - 1;
    L3:
        if (i < 0) goto L35;
        ActivityRecord r = activities.get(i);
        if (app.mUid != r.info.applicationInfo.uid) goto L33;
        if (app.mName.equals(r.processName) == false) goto L33;
        activities.remove(i);
        TaskFragment tf = r.getTaskFragment();
        if (tf == null) goto L33;
        if (r.finishing == true) goto L33;
        if (r.app != null) goto L33;
        if (r.shouldBeVisible(true) == false) goto L33;
        if (r.showToCurrentUser() == false) goto L33;
        if (r.isFocusable() == true) goto L23;
    L27:
        boolean canResume = false;
    L29:
        if (this.mTaskSupervisor.realStartActivityLocked(r, app, canResume, true) == false) goto L33;
        hasActivityStarted = true;
        goto L33
    L23:
        if (r != tf.topRunningActivity()) goto L27;
        canResume = true;
    L25:
        e = move-exception;
        Slog.w("WindowManager", "Exception in new process when starting " + r, e);
        remoteException = e;
    L33:
        i = i - 1;
        goto L3
    L35:
        if (remoteException != null) goto L37;
        return hasActivityStarted;
    L37:
        throw remoteException;
    }

    void ensureActivitiesVisible() {
        ensureActivitiesVisible(null);
    }

    void ensureActivitiesVisible(ActivityRecord starting) {
        ensureActivitiesVisible(starting, true);
    }

    void ensureActivitiesVisible(ActivityRecord starting, boolean notifyClients) {
        if (this.mTaskSupervisor.inActivityVisibilityUpdate() == false) goto L5;
        return;
    L5:
        if (this.mTaskSupervisor.isRootVisibilityUpdateDeferred() == true) goto L22;
        Trace.traceBegin(32, "RWC_ensureActivitiesVisible");
        this.mTaskSupervisor.beginActivityVisibilityUpdate();
        int displayNdx = getChildCount() - 1;     // Catch: Throwable -> L12
    L9:
        if (displayNdx < 0) goto L14;
        DisplayContent display = getChildAt(displayNdx);     // Catch: Throwable -> L12
        display.ensureActivitiesVisible(starting, notifyClients);     // Catch: Throwable -> L12
        displayNdx = displayNdx - 1;
        goto L9
    L14:
        this.mTaskSupervisor.endActivityVisibilityUpdate();
        Trace.traceEnd(32);
        return;
    L12:
        th = move-exception;
        this.mTaskSupervisor.endActivityVisibilityUpdate();
        Trace.traceEnd(32);
        throw th;
    }

    boolean switchUser(final int userId, UserState uss) {
        Task topFocusedRootTask = getTopDisplayFocusedRootTask();
        if (topFocusedRootTask == null) goto L5;
        int focusRootTaskId = topFocusedRootTask.getRootTaskId();
    L6:
        removeRootTasksInWindowingModes(new int[]{2});
        if (DesktopModeFlags.ENABLE_TOP_VISIBLE_ROOT_TASK_PER_USER_TRACKING.isTrue() == false) goto L9;
        final IntArray visibleRootTasks = new IntArray();
        forAllRootTasks(new RootWindowContainer$$ExternalSyntheticLambda20(this, visibleRootTasks), false);
        this.mUserVisibleRootTasks.put(this.mCurrentUser, visibleRootTasks);
    L10:
        this.mCurrentUser = userId;
        this.mTaskSupervisor.mStartingUsers.add(uss);
        forAllRootTasks(new RootWindowContainer$$ExternalSyntheticLambda21(userId));
        if (topFocusedRootTask != null) goto L13;
    L15:
        this.mUserRootTaskInFront.get(userId);
        IntArray rootTaskIdsToRestore = this.mUserVisibleRootTasks.get(userId);
        if (rootTaskIdsToRestore != null) goto L18;
    L25:
        handleRootTaskLaunchOnUserSwitch(-1);
        return true;
    L18:
        if (rootTaskIdsToRestore.size() == 0) goto L25;
        int i = 0;
    L22:
        if (i >= rootTaskIdsToRestore.size()) goto L24;
        handleRootTaskLaunchOnUserSwitch(rootTaskIdsToRestore.get(i));
        i = i + 1;
        goto L22
    L24:
        int i2 = rootTaskIdsToRestore.size();
        int topRootTaskId = rootTaskIdsToRestore.get(i2 - 1);
        boolean homeInFront = isHomeTask(topRootTaskId);
        return homeInFront;
    L13:
        if (isAlwaysVisibleUser(topFocusedRootTask.mUserId) == false) goto L15;
        Slog.i("WindowManager", "Persisting top task because it belongs to an always-visible user");
        IntArray rootTasks = this.mUserVisibleRootTasks.get(this.mCurrentUser);
        rootTasks.add(focusRootTaskId);
        this.mUserVisibleRootTasks.put(this.mCurrentUser, rootTasks);
        goto L15
    L9:
        this.mUserRootTaskInFront.put(this.mCurrentUser, focusRootTaskId);
        goto L10
    L5:
        focusRootTaskId = -1;
        goto L6
    }

    private /* synthetic */ void lambda$switchUser$14(IntArray visibleRootTasks, Task rootTask) {
        if (this.mCurrentUser == rootTask.mUserId) goto L7;
        if (rootTask.showForAllUsers() == true) goto L7;
        return;
    L7:
        if (rootTask.isVisible() == false) goto L11;
        visibleRootTasks.add(rootTask.getRootTaskId());
        return;
    }

    private static /* synthetic */ void lambda$switchUser$15(int userId, Task rootTask) {
        rootTask.switchUser(userId);
    }

    private boolean isHomeTask(int taskId) {
        Task rootTask = getRootTask(taskId);
        if (rootTask != null) goto L5;
    L7:
        return false;
    L5:
        if (rootTask.isActivityTypeHome() == false) goto L7;
        return true;
    }

    private void handleRootTaskLaunchOnUserSwitch(int restoreRootTaskId) {
        Task rootTask = getRootTask(restoreRootTaskId);
        if (rootTask != null) goto L6;
        rootTask = getDefaultTaskDisplayArea().getOrCreateRootHomeTask();
    L6:
        if (rootTask.isOnHomeDisplay() == false) goto L8;
        rootTask.moveToFront("switchUserOnHomeDisplay");
        return;
    L8:
        resumeHomeActivity(null, "switchUserOnOtherDisplay", getDefaultTaskDisplayArea());
    }

    private boolean isAlwaysVisibleUser(int userId) {
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        UserProperties properties = umi.getUserProperties(userId);
        if (properties != null) goto L5;
    L7:
        return false;
    L5:
        if (properties.getAlwaysVisible() == false) goto L7;
        return true;
    }

    void removeUser(int userId) {
        this.mUserVisibleRootTasks.delete(userId);
    }

    void updateUserRootTask(int userId, Task rootTask) {
        if (userId == this.mCurrentUser) goto L11;
        if (rootTask != null) goto L6;
        rootTask = getDefaultTaskDisplayArea().getOrCreateRootHomeTask();
    L6:
        IntArray rootTasks = this.mUserVisibleRootTasks.get(userId, new IntArray());
        int rootTaskIndex = rootTasks.indexOf(rootTask.getRootTaskId());
        if (rootTaskIndex == (-1)) goto L9;
        rootTasks.remove(rootTaskIndex);
    L9:
        rootTasks.add(rootTask.getRootTaskId());
        this.mUserVisibleRootTasks.put(userId, rootTasks);
        return;
    }

    void moveRootTaskToTaskDisplayArea(int rootTaskId, TaskDisplayArea taskDisplayArea, boolean onTop) {
        Task rootTask = getRootTask(rootTaskId);
        if (rootTask == null) goto L17;
        TaskDisplayArea currentTaskDisplayArea = rootTask.getDisplayArea();
        if (currentTaskDisplayArea == null) goto L15;
        if (taskDisplayArea == null) goto L13;
        if (currentTaskDisplayArea == taskDisplayArea) goto L11;
        rootTask.reparent(taskDisplayArea, onTop);
        rootTask.resumeNextFocusAfterReparent();
        return;
    L11:
        throw new IllegalArgumentException("Trying to move rootTask=" + rootTask + " to its current taskDisplayArea=" + taskDisplayArea);
    L13:
        throw new IllegalArgumentException("moveRootTaskToTaskDisplayArea: Unknown taskDisplayArea=" + taskDisplayArea);
    L15:
        throw new IllegalStateException("moveRootTaskToTaskDisplayArea: rootTask=" + rootTask + " is not attached to any task display area.");
    L17:
        throw new IllegalArgumentException("moveRootTaskToTaskDisplayArea: Unknown rootTaskId=" + rootTaskId);
    }

    void moveRootTaskToDisplay(int rootTaskId, int displayId, boolean onTop) {
        DisplayContent displayContent = getDisplayContentOrCreate(displayId);
        if (displayContent == null) goto L7;
        moveRootTaskToTaskDisplayArea(rootTaskId, displayContent.getDefaultTaskDisplayArea(), onTop);
        return;
    L7:
        throw new IllegalArgumentException("moveRootTaskToDisplay: Unknown displayId=" + displayId);
    }

    void moveActivityToPinnedRootTask(ActivityRecord r, String reason) {
        if (r.mTransitionController.isCollecting() == false) goto L5;
    L8:
        Transition newTransit = null;
    L10:
        if (newTransit == null) goto L13;
        boolean r1 = true;
    L14:
        moveActivityToPinnedRootTaskInner(r, null, reason, null, r1);
        return;
    L13:
        r1 = false;
        goto L14
    L5:
        if (r.mTransitionController.isShellTransitionsEnabled() == false) goto L8;
        newTransit = r.mTransitionController.createTransition(10);
        goto L10
    }

    void moveActivityToPinnedRootTask(ActivityRecord r, ActivityRecord launchIntoPipHostActivity, String reason, Rect bounds) {
        moveActivityToPinnedRootTaskInner(r, launchIntoPipHostActivity, reason, bounds, false);
    }

    void moveActivityToPinnedRootTaskAndRequestStart(ActivityRecord r, String reason) {
        moveActivityToPinnedRootTaskInner(r, null, reason, null, true);
    }

    private void moveActivityToPinnedRootTaskInner(ActivityRecord r, ActivityRecord launchIntoPipHostActivity, String reason, Rect bounds, boolean requestStart) {
        TaskDisplayArea taskDisplayArea = r.getDisplayArea();
        Task task = r.getTask();
        TransitionController transitionController = task.mTransitionController;
        transitionController.deferTransitionReady();
        Transition.ReadyCondition pipChangesApplied = new Transition.ReadyCondition("movedToPip");
        transitionController.waitFor(pipChangesApplied);
        this.mService.deferWindowLayout();
        if (this.mTaskSupervisor.isRootVisibilityUpdateDeferred() == true) goto L5;
        this.mTaskSupervisor.setDeferRootVisibilityUpdate(true);
        boolean localVisibilityDeferred = true;
    L95:
        Task rootPinnedTask = taskDisplayArea.getRootPinnedTask();     // Catch: Throwable -> L10
        if (rootPinnedTask == null) goto L12;
        transitionController.collect(rootPinnedTask);     // Catch: Throwable -> L10
        removeRootTasksInWindowingModes(new int[]{2});     // Catch: Throwable -> L10
    L12:
        transitionController.collect(task);     // Catch: Throwable -> L10
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == true) goto L15;
        r.setWindowingMode(r.getWindowingMode());     // Catch: Throwable -> L10
    L15:
        TaskFragment organizedTf = r.getOrganizedTaskFragment();     // Catch: Throwable -> L10
        TaskFragment taskFragment = r.getTaskFragment();     // Catch: Throwable -> L10
        if (task.getNonFinishingActivityCount() != 1) goto L18;
        boolean singleActivity = true;
    L19:
        if (singleActivity == false) goto L24;
        Task rootTask = task;
        rootTask.maybeApplyLastRecentsAnimationTransaction();     // Catch: Throwable -> L10
        if (rootTask.getParent() == taskDisplayArea) goto L23;
        rootTask.reparent(taskDisplayArea, true);     // Catch: Throwable -> L10
    L23:
        rootTask.forAllTaskFragments(new RootWindowContainer$$ExternalSyntheticLambda0());     // Catch: Throwable -> L10
    L44:
        rootTask.setRootTaskWindowingMode(2);     // Catch: Throwable -> L48
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == false) goto L51;
        if (bounds == null) goto L51;
        rootTask.setBounds(bounds);     // Catch: Throwable -> L48
    L51:
        if (r.getOptions() != null) goto L53;
    L55:
        rootTask.setDeferTaskAppear(false);     // Catch: Throwable -> L48
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == true) goto L58;
        r.mWaitForEnteringPinnedMode = true;     // Catch: Throwable -> L48
    L58:
        r.supportsEnterPipOnTaskSwitch = false;     // Catch: Throwable -> L48
        if (organizedTf != null) goto L61;
    L65:
        this.mService.continueWindowLayout();
        if (localVisibilityDeferred == true) goto L91;
    L72:
        transitionController.continueTransitionReady();
        pipChangesApplied.meet();
        Transition transit = transitionController.getCollectingTransition();
        if (requestStart == false) goto L76;
        if (transit == null) goto L76;
        transitionController.requestStartTransition(transit, rootTask, null, null);
        transit.setReady(rootTask, true);
    L76:
        resumeFocusedTasksTopActivities();
        notifyActivityPipModeChanged(r.getTask(), r);
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == true) goto L96;
        scheduleTimeoutAbortPipEnter(rootTask);
        return;
    L96:
        return;
    L91:
        this.mTaskSupervisor.setDeferRootVisibilityUpdate(false);     // Catch: Throwable -> L69
        ensureActivitiesVisible();     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        transitionController.continueTransitionReady();
        pipChangesApplied.meet();
        throw th;
    L61:
        if (organizedTf.mClearedTaskFragmentForPip == false) goto L65;
        if (organizedTf.isTaskVisibleRequested() == false) goto L65;
        this.mService.mTaskFragmentOrganizerController.dispatchPendingInfoChangedEvent(organizedTf);     // Catch: Throwable -> L48
    L48:
        th = th;
    L80:
        this.mService.continueWindowLayout();
        if (localVisibilityDeferred == true) goto L93;
    L87:
        transitionController.continueTransitionReady();
        pipChangesApplied.meet();
        throw th;
    L93:
        this.mTaskSupervisor.setDeferRootVisibilityUpdate(false);     // Catch: Throwable -> L84
        ensureActivitiesVisible();     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        transitionController.continueTransitionReady();
        pipChangesApplied.meet();
        throw th;
    L53:
        if (r.getOptions().isLaunchIntoPip() == false) goto L55;
        this.mWindowManager.mTaskSnapshotController.recordSnapshot(task);     // Catch: Throwable -> L48
        rootTask.setBounds(r.pictureInPictureArgs.getSourceRectHint());     // Catch: Throwable -> L48
        goto L55
    L24:
        rootTask = new Task.Builder(this.mService).setActivityType(r.getActivityType()).setOnTop(true).setActivityInfo(r.info).setParent(taskDisplayArea).setIntent(r.intent).setDeferTaskAppear(true).setHasBeenVisible(true).setWindowingMode(taskFragment.getWindowingMode()).build();     // Catch: Throwable -> L10
        r.setLastParentBeforePip(launchIntoPipHostActivity);     // Catch: Throwable -> L10
        rootTask.setLastNonFullscreenBounds(task.mLastNonFullscreenBounds);     // Catch: Throwable -> L10
        rootTask.setBoundsUnchecked(taskFragment.getBounds());     // Catch: Throwable -> L10
        rootTask.autoRemoveRecents = true;     // Catch: Throwable -> L10
        if (task.mLastRecentsAnimationTransaction == null) goto L27;
        rootTask.setLastRecentsAnimationTransaction(task.mLastRecentsAnimationTransaction, task.mLastRecentsAnimationOverlay);     // Catch: Throwable -> L10
        task.clearLastRecentsAnimationTransaction(false);     // Catch: Throwable -> L10
    L28:
        if (organizedTf == null) goto L35;
        if (organizedTf.getNonFinishingActivityCount() != 1) goto L35;
        if (organizedTf.getTopNonFinishingActivity() != r) goto L35;
        organizedTf.mClearedTaskFragmentForPip = true;     // Catch: Throwable -> L10
    L35:
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == false) goto L37;
        transitionController.collectExistenceChange(rootTask);     // Catch: Throwable -> L10
    L39:
        if (transitionController.isShellTransitionsEnabled() == false) goto L41;
        rootTask.setRootTaskWindowingMode(2);     // Catch: Throwable -> L10
    L41:
        rootTask.setFocusable(false);     // Catch: Throwable -> L10
        r.reparent(rootTask, Integer.MAX_VALUE, reason);     // Catch: Throwable -> L48
        rootTask.setFocusable(true);     // Catch: Throwable -> L48
        rootTask.maybeApplyLastRecentsAnimationTransaction();     // Catch: Throwable -> L48
        goto L44
    L37:
        transitionController.collect(rootTask);     // Catch: Throwable -> L10
        goto L39
    L27:
        task.resetSurfaceControlTransforms();     // Catch: Throwable -> L10
        goto L28
    L18:
        singleActivity = false;
    L10:
        th = th;
        goto L80
    L5:
        localVisibilityDeferred = false;
        goto L95
    }

    private static /* synthetic */ void lambda$moveActivityToPinnedRootTaskInner$16(TaskFragment tf) {
        if (tf.isOrganizedTaskFragment() == true) goto L5;
        return;
    L5:
        tf.clearAdjacentTaskFragments();
        tf.setCompanionTaskFragment(null);
        tf.setAnimationParams(TaskFragmentAnimationParams.DEFAULT);
        if (tf.getTopNonFinishingActivity() == null) goto L9;
        tf.setRelativeEmbeddedBounds(new Rect());
        tf.updateRequestedOverrideConfiguration(Configuration.EMPTY);
        return;
    }

    private void scheduleTimeoutAbortPipEnter(Task rootTask) {
        if (this.mMaybeAbortPipEnterRunnable == null) goto L5;
        this.mHandler.removeCallbacks(this.mMaybeAbortPipEnterRunnable);
        this.mMaybeAbortPipEnterRunnable.run();
    L5:
        Throwable enterPipThrowable = new Throwable();
        this.mMaybeAbortPipEnterRunnable = new AnonymousClass2(this, rootTask, enterPipThrowable);
        this.mHandler.postDelayed(this.mMaybeAbortPipEnterRunnable, 1000);
        Slog.d("WindowManager", "a delayed check for potentially aborting PiP if in a wrong state is scheduled.");
    }

    void notifyActivityPipModeChanged(Task task, ActivityRecord r) {
        if (r == null) goto L5;
        boolean inPip = true;
    L6:
        if (inPip == false) goto L8;
        this.mService.getTaskChangeNotificationController().notifyActivityPinned(r);
    L11:
        this.mWindowManager.mPolicy.setPipVisibilityLw(inPip);
        return;
    L8:
        this.mService.getTaskChangeNotificationController().notifyActivityUnpinned();
        if (task.getSurfaceControl() == null) goto L11;
        this.mWmService.mTransactionFactory.get().setTrustedOverlay(task.getSurfaceControl(), false).apply();
        goto L11
    L5:
        inPip = false;
        goto L6
    }

    void executeAppTransitionForAllDisplay() {
        int displayNdx = getChildCount() - 1;
    L3:
        if (displayNdx < 0) goto L6;
        DisplayContent display = getChildAt(displayNdx);
        display.mDisplayContent.executeAppTransition();
        displayNdx = displayNdx - 1;
        goto L3
    }

    void acquireAppLaunchPerfLock(ActivityRecord r) {
        if (this.mPerfBoost != null) goto L6;
        this.mPerfBoost = new BoostFramework();
    L6:
        if (this.mPerfBoost == null) goto L54;
        int pkgType = this.mPerfBoost.perfGetFeedback(5633, r.packageName);
        if (this.mService != null) goto L10;
    L18:
        int wpcPid = -1;
    L20:
        if (this.mPerfBoost.board_first_api_lvl > 202404) goto L38;
        if (this.mPerfBoost.board_api_lvl > 202404) goto L38;
        if (this.mPerfBoost.getPerfHalVersion() < 2.299999952316284d) goto L31;
        this.mPerfBoost.perfHintAcqRel(-1, 4225, r.packageName, -1, 1, 2, new int[]{pkgType, wpcPid});
        mPerfSendTapHint = true;
        this.mPerfBoost.perfHintAcqRel(-1, 4225, r.packageName, -1, 2, 2, new int[]{pkgType, wpcPid});
        if (wpcPid == (-1)) goto L28;
        this.mPerfBoost.perfHintAcqRel(-1, 4225, r.packageName, wpcPid, 103, 2, new int[]{pkgType, wpcPid});
    L28:
        if (pkgType != 2) goto L30;
        mPerfHandle = this.mPerfBoost.perfHintAcqRel(-1, 4225, r.packageName, -1, 4, 2, new int[]{pkgType, wpcPid});
    L42:
        if (mPerfHandle <= 0) goto L45;
        mIsPerfBoostAcquired = true;
    L45:
        if (r.info.applicationInfo != null) goto L47;
        return;
    L47:
        if (r.info.applicationInfo.sourceDir != null) goto L49;
        return;
    L49:
        if (this.mPerfBoost.board_first_api_lvl < 33) goto L51;
        return;
    L51:
        if (this.mPerfBoost.board_api_lvl >= 33) goto L58;
        this.mPerfBoost.perfIOPrefetchStart(-1, r.packageName, r.info.applicationInfo.sourceDir.substring(0, r.info.applicationInfo.sourceDir.lastIndexOf(47)));
        return;
    L58:
        return;
    L30:
        mPerfHandle = this.mPerfBoost.perfHintAcqRel(-1, 4225, r.packageName, -1, 3, 2, new int[]{pkgType, wpcPid});
        goto L42
    L31:
        this.mPerfBoost.perfHint(4225, r.packageName, -1, 1);
        mPerfSendTapHint = true;
        this.mPerfBoost.perfHint(4225, r.packageName, -1, 2);
        if (wpcPid == (-1)) goto L34;
        this.mPerfBoost.perfHint(4225, r.packageName, wpcPid, 103);
    L34:
        if (pkgType != 2) goto L36;
        mPerfHandle = this.mPerfBoost.perfHint(4225, r.packageName, -1, 4);
        goto L42
    L36:
        mPerfHandle = this.mPerfBoost.perfHint(4225, r.packageName, -1, 3);
    L38:
        if (this.mPerfBoost.getPerfHalVersion() < 2.299999952316284d) goto L40;
        this.mPerfBoost.perfHintAcqRel(-1, 4225, r.packageName, wpcPid, 1, 2, new int[]{pkgType, wpcPid});
        goto L42
    L40:
        this.mPerfBoost.perfHint(4225, r.packageName, wpcPid, 1);
        goto L42
    L10:
        if (r.info == null) goto L18;
        if (r.info.applicationInfo == null) goto L18;
        WindowProcessController wpc = this.mService.getProcessController(r.processName, r.info.applicationInfo.uid);
        if (wpc == null) goto L18;
        if (wpc.hasThread() == false) goto L18;
        int wpcPid2 = wpc.getPid();
        wpcPid = wpcPid2;
        goto L20
    }

    ActivityRecord findTask(ActivityRecord r, TaskDisplayArea preferredTaskDisplayArea, boolean includeLaunchedFromBubble) {
        return findTask(r.getActivityType(), r.taskAffinity, r.intent, r.info, preferredTaskDisplayArea, includeLaunchedFromBubble, r);
    }

    ActivityRecord findTask(int activityType, String taskAffinity, Intent intent, ActivityInfo info, final TaskDisplayArea preferredTaskDisplayArea, boolean includeLaunchedFromBubble, ActivityRecord r) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L5;
        String protoLogParam0 = String.valueOf(activityType);
        String protoLogParam1 = String.valueOf(taskAffinity);
        String protoLogParam2 = String.valueOf(intent);
        String protoLogParam3 = String.valueOf(info);
        String protoLogParam4 = String.valueOf(preferredTaskDisplayArea);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, 3955186263169120253L, 3072, new Object[]{protoLogParam0, protoLogParam1, protoLogParam2, protoLogParam3, protoLogParam4, Boolean.valueOf(includeLaunchedFromBubble)});
    L5:
        this.mTmpFindTaskResult.init(activityType, taskAffinity, intent, info, includeLaunchedFromBubble);
        ActivityRecord candidateActivity = null;
        if (preferredTaskDisplayArea == null) goto L33;
        this.mTmpFindTaskResult.process(preferredTaskDisplayArea);
        if (this.mTmpFindTaskResult.mIdealRecord == null) goto L30;
        if (this.mTmpFindTaskResult.mIdealRecord.getState() != ActivityRecord.State.DESTROYED) goto L13;
        acquireAppLaunchPerfLock(r);
    L13:
        if (this.mTmpFindTaskResult.mIdealRecord.getState() != ActivityRecord.State.STOPPED) goto L28;
        this.mUxPerf = new BoostFramework();
        if (this.mUxPerf != null) goto L17;
    L22:
        ProcessFreezerManager freezer = ProcessFreezerManager.getInstance();
        if (freezer == null) goto L28;
        if (freezer.useFreezerManager() == false) goto L28;
        freezer.startFreeze(r.packageName, 1);
        goto L28
    L17:
        if (this.mUxPerf.board_first_api_lvl < 33) goto L19;
    L21:
        this.mUxPerf.perfEvent(4257, r.packageName, 2, new int[]{0, 0});
        goto L22
    L19:
        if (this.mUxPerf.board_api_lvl >= 33) goto L21;
        this.mUxPerf.perfUXEngine_events(6, 0, r.packageName, 0);
    L28:
        return this.mTmpFindTaskResult.mIdealRecord;
    L30:
        if (this.mTmpFindTaskResult.mCandidateRecord == null) goto L33;
        candidateActivity = this.mTmpFindTaskResult.mCandidateRecord;
    L33:
        if (this.mTmpFindTaskResult.mIdealRecord != null) goto L35;
    L36:
        if (r != null) goto L38;
    L45:
        if (r != null) goto L47;
        Slog.w("WindowManager", "Should not happen! Didn't apply launch boost");
    L47:
        ActivityRecord idealMatchActivity = (ActivityRecord) getItemFromTaskDisplayAreas(new RootWindowContainer$$ExternalSyntheticLambda31(this, preferredTaskDisplayArea));
        if (idealMatchActivity == null) goto L51;
        return idealMatchActivity;
    L51:
        if (WmProtoLogGroups.WM_DEBUG_TASKS.isEnabled() == false) goto L56;
        if (candidateActivity != null) goto L56;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L56;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, 2828976699481734755L, 0, null);
    L56:
        return candidateActivity;
    L38:
        if (ActivityRecord.isMainIntent(r.intent) == false) goto L45;
        acquireAppLaunchPerfLock(r);
        ProcessFreezerManager freezer2 = ProcessFreezerManager.getInstance();
        if (freezer2 == null) goto L47;
        if (freezer2.useFreezerManager() == false) goto L47;
        freezer2.startFreeze(r.packageName, 0);
        goto L47
    L35:
        if (this.mTmpFindTaskResult.mIdealRecord.getState() != ActivityRecord.State.DESTROYED) goto L47;
        goto L36
    }

    private /* synthetic */ ActivityRecord lambda$findTask$17(TaskDisplayArea preferredTaskDisplayArea, TaskDisplayArea taskDisplayArea) {
        if (taskDisplayArea != preferredTaskDisplayArea) goto L5;
        return null;
    L5:
        this.mTmpFindTaskResult.process(taskDisplayArea);
        if (this.mTmpFindTaskResult.mIdealRecord != null) goto L8;
        return null;
    L8:
        return this.mTmpFindTaskResult.mIdealRecord;
    }

    Task finishTopCrashedActivities(final WindowProcessController app, final String reason) {
        final Task focusedRootTask = getTopDisplayFocusedRootTask();
        final Task[] finishedTask = new Task[1];
        forAllLeafTasks(new RootWindowContainer$$ExternalSyntheticLambda1(finishedTask, focusedRootTask, app, reason), true);
        return finishedTask[0];
    }

    private static /* synthetic */ void lambda$finishTopCrashedActivities$18(Task[] finishedTask, Task focusedRootTask, WindowProcessController app, String reason, Task leafTask) {
        if (finishedTask[0] == null) goto L5;
    L9:
        boolean recordTopOrVisible = false;
    L10:
        Task t = leafTask.finishTopCrashedActivityLocked(app, reason);
        if (recordTopOrVisible == false) goto L14;
        finishedTask[0] = t;
        return;
    L14:
        return;
    L5:
        if (focusedRootTask != leafTask.getRootTask()) goto L7;
    L8:
        recordTopOrVisible = true;
        goto L10
    L7:
        if (leafTask.isVisibleRequested() == false) goto L9;
        goto L8
    }

    void ensureVisibilityOnVisibleActivityDiedOrCrashed(String reason) {
        Task topTask = getTopDisplayFocusedRootTask();
        boolean shouldEnsureVisible = true;
        if (topTask != null) goto L5;
    L7:
        if (topTask == null) goto L9;
        ActivityRecord top = topTask.topRunningActivity(true);
    L10:
        if (top != null) goto L12;
    L16:
        shouldEnsureVisible = false;
    L17:
        if (shouldEnsureVisible == false) goto L19;
    L20:
        ensureActivitiesVisible();
        return;
    L19:
        if (resumeFocusedTasksTopActivities() == false) goto L20;
        return;
    L12:
        if (top.finishing == true) goto L16;
        if (top.occludesParent() == true) goto L16;
    L9:
        top = null;
        goto L10
    L5:
        if (topTask.topRunningActivity(true) != null) goto L7;
        topTask.adjustFocusToNextFocusableTask(reason);
        goto L7
    }

    boolean resumeFocusedTasksTopActivities() {
        return resumeFocusedTasksTopActivities(null, null, null, false);
    }

    boolean resumeFocusedTasksTopActivities(Task targetRootTask, ActivityRecord target) {
        return resumeFocusedTasksTopActivities(targetRootTask, target, null, false);
    }

    boolean resumeFocusedTasksTopActivities(final Task targetRootTask, final ActivityRecord target, final ActivityOptions targetOptions, boolean deferPause) {
        if (this.mTaskSupervisor.readyToResume() == true) goto L5;
        return false;
    L5:
        boolean result = false;
        if (targetRootTask != null) goto L8;
    L12:
        int displayNdx = getChildCount() - 1;
    L13:
        if (displayNdx < 0) goto L25;
        DisplayContent display = getChildAt(displayNdx);
        final boolean curResult = result;
        final boolean[] resumedOnDisplay = new boolean[1];
        final ActivityRecord topOfDisplay = display.topRunningActivity();
        display.forAllRootTasks(new RootWindowContainer$$ExternalSyntheticLambda41(targetRootTask, resumedOnDisplay, curResult, topOfDisplay, targetOptions, target));
        result = result | resumedOnDisplay[0];
        if (resumedOnDisplay[0] == true) goto L23;
        Task focusedRoot = display.getFocusedRootTask();
        if (focusedRoot == null) goto L20;
        result = result | focusedRoot.resumeTopActivityUncheckedLocked(target, targetOptions, false);
        goto L23
    L20:
        if (targetRootTask != null) goto L23;
        result = result | resumeHomeActivity(null, "no-focusable-task", display.getDefaultTaskDisplayArea());
    L23:
        displayNdx = displayNdx - 1;
        goto L13
    L25:
        return result;
    L8:
        if (targetRootTask.isTopRootTaskInDisplayArea() == false) goto L10;
    L11:
        result = targetRootTask.resumeTopActivityUncheckedLocked(target, targetOptions, deferPause);
        goto L12
    L10:
        if (getTopDisplayFocusedRootTask() != targetRootTask) goto L12;
        goto L11
    }

    private static /* synthetic */ void lambda$resumeFocusedTasksTopActivities$19(Task targetRootTask, boolean[] resumedOnDisplay, boolean curResult, ActivityRecord topOfDisplay, ActivityOptions targetOptions, ActivityRecord target, Task rootTask) {
        ActivityRecord topRunningActivity = rootTask.topRunningActivity();
        if (rootTask.isFocusableAndVisible() == false) goto L16;
        if (topRunningActivity != null) goto L7;
        return;
    L7:
        if (rootTask != targetRootTask) goto L11;
        resumedOnDisplay[0] = resumedOnDisplay[0] | curResult;
        return;
    L11:
        if (topRunningActivity.isState(ActivityRecord.State.RESUMED) == false) goto L14;
        if (topRunningActivity != topOfDisplay) goto L14;
        rootTask.executeAppTransition(targetOptions);
        return;
    L14:
        resumedOnDisplay[0] = resumedOnDisplay[0] | topRunningActivity.makeActiveIfNeeded(target);
        return;
    }

    void sendSleepTransition(final DisplayContent display) {
        final Transition transition = new Transition(12, 0, display.mTransitionController, this.mWmService.mSyncEngine);
        TransitionController.OnStartCollect sendSleepTransition = new RootWindowContainer$$ExternalSyntheticLambda29(display, transition);
        if (display.mTransitionController.isCollecting() == false) goto L5;
        display.mTransitionController.startCollectOrQueue(transition, sendSleepTransition);
        return;
    L5:
        if (this.mWindowManager.mSyncEngine.hasActiveSync() == false) goto L7;
        Slog.w("WindowManager", "Ongoing sync outside of a transition.");
    L7:
        display.mTransitionController.moveToCollecting(transition);
        sendSleepTransition.onCollectStarted(false);
    }

    private static /* synthetic */ void lambda$sendSleepTransition$20(DisplayContent display, Transition transition, boolean deferred) {
        if (deferred == true) goto L4;
    L6:
        display.mTransitionController.requestStartTransition(transition, null, null, null);
        transition.playNow();
        return;
    L4:
        if (display.shouldSleep() == true) goto L6;
        transition.abort();
    }

    void applySleepTokens(boolean applyToRootTasks) {
        boolean scheduledSleepTransition = false;
        int displayNdx = getChildCount();
    L3:
        displayNdx = displayNdx - 1;
        if (displayNdx < 0) goto L33;
        final DisplayContent display = getChildAt(displayNdx);
        final boolean displayShouldSleep = display.shouldSleep();
        if (displayShouldSleep == display.isSleeping()) goto L3;
        boolean wasSleeping = display.isSleeping();
        display.setIsSleeping(displayShouldSleep);
        if (display.mTransitionController.isShellTransitionsEnabled() == false) goto L17;
        if (scheduledSleepTransition == true) goto L17;
        if (displayShouldSleep == false) goto L17;
        if (display.mAllSleepTokens.isEmpty() == true) goto L17;
        scheduledSleepTransition = true;
        if (this.mHandler.hasMessages(3) == true) goto L17;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, display), 1000);
    L17:
        if (applyToRootTasks == false) goto L3;
        if (displayShouldSleep == false) goto L21;
    L30:
        display.forAllRootTasks(new RootWindowContainer$$ExternalSyntheticLambda14(this, displayShouldSleep, display));
        goto L3
    L21:
        if (display.mTransitionController.isShellTransitionsEnabled() == false) goto L30;
        if (display.mTransitionController.isCollecting() == true) goto L30;
        int transit = 0;
        Task startTask = null;
        int flags = 0;
        if (display.isKeyguardOccluded() == false) goto L27;
        startTask = display.getTaskOccludingKeyguard();
        flags = 4096;
        transit = 8;
    L27:
        if (wasSleeping == false) goto L29;
        transit = 11;
    L29:
        display.mTransitionController.requestStartTransition(display.mTransitionController.createTransition(transit, flags), startTask, null, null);
        goto L30
    L33:
        if (scheduledSleepTransition == true) goto L40;
        this.mHandler.removeMessages(3);
        return;
    }

    private /* synthetic */ void lambda$applySleepTokens$22(boolean displayShouldSleep, DisplayContent display, Task rootTask) {
        if (displayShouldSleep == false) goto L4;
        rootTask.goToSleepIfPossible(false);
        return;
    L4:
        rootTask.forAllLeafTasksAndLeafTaskFragments(new RootWindowContainer$$ExternalSyntheticLambda47(), true);
        if (rootTask.isFocusedRootTaskOnDisplay() == true) goto L7;
    L9:
        rootTask.ensureActivitiesVisible(null);
        return;
    L7:
        if (this.mTaskSupervisor.getKeyguardController().isKeyguardOrAodShowing(display.mDisplayId) == true) goto L9;
        rootTask.resumeTopActivityUncheckedLocked();
        goto L9
    }

    private static /* synthetic */ void lambda$applySleepTokens$21(TaskFragment taskFragment) {
        taskFragment.awakeFromSleeping();
    }

    protected Task getRootTask(int rooTaskId) {
        int i = getChildCount() - 1;
    L3:
        if (i < 0) goto L8;
        Task rootTask = getChildAt(i).getRootTask(rooTaskId);
        if (rootTask != null) goto L6;
        i = i - 1;
        goto L3
    L6:
        return rootTask;
    L8:
        return null;
    }

    Task getRootTask(int windowingMode, int activityType) {
        int i = getChildCount() - 1;
    L3:
        if (i < 0) goto L8;
        Task rootTask = getChildAt(i).getRootTask(windowingMode, activityType);
        if (rootTask != null) goto L6;
        i = i - 1;
        goto L3
    L6:
        return rootTask;
    L8:
        return null;
    }

    private Task getRootTask(int windowingMode, int activityType, int displayId) {
        DisplayContent display = getDisplayContent(displayId);
        if (display != null) goto L7;
        return null;
    L7:
        return display.getRootTask(windowingMode, activityType);
    }

    private ActivityTaskManager.RootTaskInfo getRootTaskInfo(final Task task) {
        final ActivityTaskManager.RootTaskInfo info = new ActivityTaskManager.RootTaskInfo();
        task.fillTaskInfo(info);
        DisplayContent displayContent = task.getDisplayContent();
        int r2 = -1;
        if (displayContent != null) goto L5;
        info.position = -1;
    L9:
        ComponentName r3 = null;
        info.visible = task.shouldBeVisible(null);
        task.getBounds(info.bounds);
        int numTasks = task.getDescendantTaskCount();
        info.childTaskIds = new int[numTasks];
        info.childTaskNames = new String[numTasks];
        info.childTaskBounds = new Rect[numTasks];
        info.childTaskUserIds = new int[numTasks];
        final int[] currentIndex = {0};
        task.forAllLeafTasks(new RootWindowContainer$$ExternalSyntheticLambda23(currentIndex, info), false);
        ActivityRecord top = task.topRunningActivity();
        if (top == null) goto L12;
        r3 = top.intent.getComponent();
    L12:
        info.topActivity = r3;
        return info;
    L5:
        final int[] taskIndex = new int[1];
        final boolean[] hasFound = new boolean[1];
        displayContent.forAllRootTasks(new RootWindowContainer$$ExternalSyntheticLambda22(task, hasFound, taskIndex), false);
        if (hasFound[0] == false) goto L8;
        r2 = taskIndex[0];
    L8:
        info.position = r2;
        goto L9
    }

    private static /* synthetic */ boolean lambda$getRootTaskInfo$23(Task task, boolean[] hasFound, int[] taskIndex, Task rootTask) {
        if (task != rootTask) goto L6;
        hasFound[0] = true;
        return true;
    L6:
        taskIndex[0] = taskIndex[0] + 1;
        return false;
    }

    private static /* synthetic */ void lambda$getRootTaskInfo$24(int[] currentIndex, ActivityTaskManager.RootTaskInfo info, Task t) {
        int i = currentIndex[0];
        info.childTaskIds[i] = t.mTaskId;
        String[] r2 = info.childTaskNames;
        if (t.origActivity == null) goto L6;
        String r3 = t.origActivity.flattenToString();
    L12:
        r2[i] = r3;
        info.childTaskBounds[i] = t.mAtmService.getTaskBounds(t.mTaskId);
        info.childTaskUserIds[i] = t.mUserId;
        currentIndex[0] = i + 1;
        return;
    L6:
        if (t.realActivity == null) goto L9;
        r3 = t.realActivity.flattenToString();
        goto L12
    L9:
        if (t.getTopNonFinishingActivity() == null) goto L11;
        r3 = t.getTopNonFinishingActivity().packageName;
        goto L12
    L11:
        r3 = "unknown";
        goto L12
    }

    ActivityTaskManager.RootTaskInfo getRootTaskInfo(int taskId) {
        Task task = getRootTask(taskId);
        if (task != null) goto L5;
        return null;
    L5:
        return getRootTaskInfo(task);
    }

    ActivityTaskManager.RootTaskInfo getRootTaskInfo(int windowingMode, int activityType) {
        Task rootTask = getRootTask(windowingMode, activityType);
        if (rootTask != null) goto L7;
        return null;
    L7:
        return getRootTaskInfo(rootTask);
    }

    ActivityTaskManager.RootTaskInfo getRootTaskInfo(int windowingMode, int activityType, int displayId) {
        Task rootTask = getRootTask(windowingMode, activityType, displayId);
        if (rootTask != null) goto L7;
        return null;
    L7:
        return getRootTaskInfo(rootTask);
    }

    ArrayList<ActivityTaskManager.RootTaskInfo> getAllRootTaskInfos(int displayId) {
        final ArrayList<ActivityTaskManager.RootTaskInfo> list = new ArrayList();
        if (displayId != (-1)) goto L6;
        forAllRootTasks(new RootWindowContainer$$ExternalSyntheticLambda9(this, list));
        return list;
    L6:
        DisplayContent display = getDisplayContent(displayId);
        if (display != null) goto L9;
        return list;
    L9:
        display.forAllRootTasks(new RootWindowContainer$$ExternalSyntheticLambda10(this, list));
        return list;
    }

    private /* synthetic */ void lambda$getAllRootTaskInfos$25(ArrayList list, Task rootTask) {
        list.add(getRootTaskInfo(rootTask));
    }

    private /* synthetic */ void lambda$getAllRootTaskInfos$26(ArrayList list, Task rootTask) {
        list.add(getRootTaskInfo(rootTask));
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int displayId) {
        if (ActivityTaskManagerDebugConfig.DEBUG_ROOT_TASK == false) goto L5;
        Slog.v("WindowManager", "Display added displayId=" + displayId);
    L5:
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent display = getDisplayContentOrCreate(displayId);     // Catch: Throwable -> L12
        if (display != null) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L15:
        if (DesktopExperienceFlags.ENABLE_DISPLAY_CONTENT_MODE_MANAGEMENT.isTrue() == true) goto L17;
    L20:
        startSystemDecorations(display, "displayAdded");     // Catch: Throwable -> L12
        this.mWmService.mPossibleDisplayInfoMapper.removePossibleDisplayInfos(displayId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L17:
        if (display.allowContentModeSwitch() == false) goto L19;
        this.mWindowManager.mDisplayWindowSettings.setShouldShowSystemDecorsInternalLocked(display, display.mDisplay.canHostTasks());     // Catch: Throwable -> L12
    L19:
        boolean inTopology = this.mWindowManager.mDisplayWindowSettings.shouldShowSystemDecorsLocked(display);     // Catch: Throwable -> L12
        this.mWmService.mDisplayManagerInternal.onDisplayBelongToTopologyChanged(displayId, inTopology);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void startSystemDecorations(DisplayContent displayContent, String reason) {
        if (this.mService.isBooted() == false) goto L5;
    L7:
        startHomeOnDisplay(this.mCurrentUser, reason, displayContent.getDisplayId());
        displayContent.getDisplayPolicy().notifyDisplayAddSystemDecorations();
        return;
    L5:
        if (this.mService.isBooting() == true) goto L7;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int displayId) {
        if (ActivityTaskManagerDebugConfig.DEBUG_ROOT_TASK == false) goto L5;
        Slog.v("WindowManager", "Display removed displayId=" + displayId);
    L5:
        if (displayId == 0) goto L23;
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = getDisplayContent(displayId);     // Catch: Throwable -> L13
        if (displayContent != null) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L15:
        displayContent.remove();     // Catch: Throwable -> L13
        this.mWmService.mPossibleDisplayInfoMapper.removePossibleDisplayInfos(displayId);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L13:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L23:
        throw new IllegalArgumentException("Can't remove the primary display.");
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(final int displayId) {
        if (ActivityTaskManagerDebugConfig.DEBUG_ROOT_TASK == false) goto L5;
        Slog.v("WindowManager", "Display changed displayId=" + displayId);
    L5:
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        final DisplayContent displayContent = getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (displayContent == null) goto L12;
        displayContent.requestDisplayUpdate(new RootWindowContainer$$ExternalSyntheticLambda45(this, displayId, displayContent));     // Catch: Throwable -> L10
        this.mWmService.getExt().onDisplayChanged(displayId, displayContent.mAtmService.mTmpUpdateConfigurationResult.changes);     // Catch: Throwable -> L10
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        clearDisplayInfoCaches(displayId);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$onDisplayChanged$27(int displayId, DisplayContent displayContent) {
        clearDisplayInfoCaches(displayId);
        if (DesktopExperienceFlags.ENABLE_DISPLAY_CONTENT_MODE_MANAGEMENT.isTrue() == false) goto L6;
        displayContent.onDisplayInfoChangeApplied();
        return;
    }

    private void clearDisplayInfoCaches(int displayId) {
        this.mWmService.mPossibleDisplayInfoMapper.removePossibleDisplayInfos(displayId);
        updateDisplayImePolicyCache();
    }

    void updateDisplayImePolicyCache() {
        final ArrayMap<Integer, Integer> displayImePolicyMap = new ArrayMap();
        forAllDisplays(new RootWindowContainer$$ExternalSyntheticLambda8(displayImePolicyMap));
        WindowManagerService r1 = this.mWmService;
        r1.mDisplayImePolicyCache = Collections.unmodifiableMap(displayImePolicyMap);
    }

    private static /* synthetic */ void lambda$updateDisplayImePolicyCache$28(ArrayMap displayImePolicyMap, DisplayContent dc) {
        displayImePolicyMap.put(Integer.valueOf(dc.getDisplayId()), Integer.valueOf(dc.getImePolicy()));
    }

    void updateUIDsPresentOnDisplay() {
        this.mDisplayAccessUIDs.clear();
        int displayNdx = getChildCount() - 1;
    L3:
        if (displayNdx < 0) goto L8;
        DisplayContent displayContent = getChildAt(displayNdx);
        if (displayContent.isPrivate() == false) goto L7;
        this.mDisplayAccessUIDs.append(displayContent.mDisplayId, displayContent.getPresentUIDs());
    L7:
        displayNdx = displayNdx - 1;
        goto L3
    L8:
        this.mDisplayManagerInternal.setDisplayAccessUIDs(this.mDisplayAccessUIDs);
    }

    void prepareForShutdown() {
        int i = 0;
    L4:
        if (i >= getChildCount()) goto L7;
        createSleepToken("shutdown", getChildAt(i).mDisplayId);
        i = i + 1;
        goto L4
    }

    SleepToken createSleepToken(String tag, int displayId) {
        DisplayContent display = getDisplayContent(displayId);
        if (display == null) goto L13;
        int tokenKey = makeSleepTokenKey(tag, displayId);
        SleepToken token = this.mSleepTokens.get(tokenKey);
        if (token != null) goto L11;
        SleepToken token2 = new SleepToken(tag, displayId);
        this.mSleepTokens.put(tokenKey, token2);
        display.mAllSleepTokens.add(token2);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SLEEP_TOKEN_enabled[0] == false) goto L9;
        String protoLogParam0 = String.valueOf(tag);
        long protoLogParam1 = displayId;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_SLEEP_TOKEN, -5398223207621315063L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1)});
    L9:
        return token2;
    L11:
        throw new RuntimeException("Create the same sleep token twice: " + token);
    L13:
        throw new IllegalArgumentException("Invalid display: " + displayId);
    }

    void removeSleepToken(SleepToken token) {
        if (this.mSleepTokens.contains(token.mHashKey) == true) goto L5;
        Slog.d("WindowManager", "Remove non-exist sleep token: " + token + " from " + Debug.getCallers(6));
    L5:
        this.mSleepTokens.remove(token.mHashKey);
        DisplayContent display = getDisplayContent(SleepToken.m10130$$Nest$fgetmDisplayId(token));
        if (display != null) goto L10;
        Slog.d("WindowManager", "Remove sleep token for non-existing display: " + token + " from " + Debug.getCallers(6));
        return;
    L10:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SLEEP_TOKEN_enabled[0] == false) goto L12;
        String protoLogParam0 = String.valueOf(SleepToken.m10131$$Nest$fgetmTag(token));
        long protoLogParam1 = SleepToken.m10130$$Nest$fgetmDisplayId(token);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_SLEEP_TOKEN, -6728499544334912802L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1)});
    L12:
        display.mAllSleepTokens.remove(token);
        if (display.mAllSleepTokens.isEmpty() == false) goto L16;
        this.mService.updateSleepIfNeededLocked();
        return;
    }

    void addStartingWindowsForVisibleActivities() {
        final ArrayList<Task> addedTasks = new ArrayList();
        forAllActivities(new RootWindowContainer$$ExternalSyntheticLambda25(addedTasks));
    }

    private static /* synthetic */ void lambda$addStartingWindowsForVisibleActivities$29(ArrayList addedTasks, ActivityRecord r) {
        Task task = r.getTask();
        if (r.isVisibleRequested() == true) goto L5;
        return;
    L5:
        if (r.mStartingData == null) goto L7;
        return;
    L7:
        if (addedTasks.contains(task) == true) goto L12;
        r.showStartingWindow(true);
        addedTasks.add(task);
        return;
    }

    void invalidateTaskLayersAndUpdateOomAdjIfNeeded() {
        this.mRankTaskLayersRunnable.mCheckUpdateOomAdj = true;
        invalidateTaskLayers();
    }

    void invalidateTaskLayers() {
        if (this.mTaskLayersChanged == true) goto L6;
        this.mTaskLayersChanged = true;
        this.mService.mH.post(this.mRankTaskLayersRunnable);
        return;
    }

    void rankTaskLayers() {
        if (this.mTaskLayersChanged == false) goto L5;
        this.mTaskLayersChanged = false;
        this.mService.mH.removeCallbacks(this.mRankTaskLayersRunnable);
    L5:
        this.mTmpTaskLayerRank = 0;
        forAllLeafTasks(new RootWindowContainer$$ExternalSyntheticLambda17(this), true);
        if (this.mTmpOccludingRegion == null) goto L8;
        this.mTmpOccludingRegion.setEmpty();
    L8:
        boolean changed = false;
        if (this.mTaskSupervisor.inActivityVisibilityUpdate() == true) goto L12;
        changed = this.mTaskSupervisor.computeProcessActivityStateBatch();
    L12:
        if (this.mRankTaskLayersRunnable.mCheckUpdateOomAdj == false) goto L17;
        this.mRankTaskLayersRunnable.mCheckUpdateOomAdj = false;
        if (changed == false) goto L18;
        this.mService.updateOomAdj();
        return;
    L18:
        return;
    }

    private /* synthetic */ void lambda$rankTaskLayers$31(Task task) {
        int oldRank = task.mLayerRank;
        int oldRatio = task.mNonOccludedFreeformAreaRatio;
        task.mNonOccludedFreeformAreaRatio = 0;
        if (task.isVisibleRequested() == false) goto L7;
        int r2 = this.mTmpTaskLayerRank + 1;
        this.mTmpTaskLayerRank = r2;
        task.mLayerRank = r2;
        if (task.inFreeformWindowingMode() == false) goto L9;
        computeNonOccludedFreeformAreaRatio(task);
    L9:
        if (task.mLayerRank == oldRank) goto L11;
    L12:
        task.forAllActivities(new RootWindowContainer$$ExternalSyntheticLambda36(this));
        return;
    L11:
        if (task.mNonOccludedFreeformAreaRatio != oldRatio) goto L12;
        return;
    L7:
        task.mLayerRank = -1;
        goto L9
    }

    private /* synthetic */ void lambda$rankTaskLayers$30(ActivityRecord activity) {
        if (activity.hasProcess() == false) goto L6;
        this.mTaskSupervisor.onProcessActivityStateChanged(activity.app, true);
        return;
    }

    private void computeNonOccludedFreeformAreaRatio(Task task) {
        if (this.mTmpOccludingRegion != null) goto L5;
        this.mTmpOccludingRegion = new Region();
        this.mTmpTaskRegion = new Region();
    L5:
        Rect taskBounds = task.getBounds();
        this.mTmpTaskRegion.set(taskBounds);
        this.mTmpTaskRegion.op(task.mDisplayContent.getBounds(), Region.Op.INTERSECT);
        this.mTmpTaskRegion.op(this.mTmpOccludingRegion, Region.Op.DIFFERENCE);
        task.mNonOccludedFreeformAreaRatio = (RegionUtils.getAreaSize(this.mTmpTaskRegion) * 100) / (taskBounds.width() * taskBounds.height());
        this.mTmpOccludingRegion.op(taskBounds, Region.Op.UNION);
    }

    void clearOtherAppTimeTrackers(final AppTimeTracker except) {
        forAllActivities(new RootWindowContainer$$ExternalSyntheticLambda15(except));
    }

    private static /* synthetic */ void lambda$clearOtherAppTimeTrackers$32(AppTimeTracker except, ActivityRecord r) {
        if (r.appTimeTracker == except) goto L6;
        r.appTimeTracker = null;
        return;
    }

    void scheduleDestroyAllActivities(String reason) {
        this.mDestroyAllActivitiesReason = reason;
        this.mService.mH.post(this.mDestroyAllActivitiesRunnable);
    }

    void removeAllMaybeAbortPipEnterRunnable() {
        if (this.mMaybeAbortPipEnterRunnable != null) goto L5;
        return;
    L5:
        this.mHandler.removeCallbacks(this.mMaybeAbortPipEnterRunnable);
        this.mMaybeAbortPipEnterRunnable = null;
    }

    boolean putTasksToSleep(final boolean allowDelay, final boolean shuttingDown) {
        final boolean[] result = {true};
        forAllRootTasks(new RootWindowContainer$$ExternalSyntheticLambda42(allowDelay, result, shuttingDown));
        return result[0];
    }

    private static /* synthetic */ void lambda$putTasksToSleep$33(boolean allowDelay, boolean[] result, boolean shuttingDown, Task task) {
        if (allowDelay == false) goto L4;
        result[0] = result[0] & task.goToSleepIfPossible(shuttingDown);
        return;
    L4:
        task.ensureActivitiesVisible(null);
    }

    ActivityRecord findActivity(Intent intent, ActivityInfo info, boolean compareIntentFilters) {
        ComponentName cls = intent.getComponent();
        if (info.targetActivity == null) goto L5;
        ComponentName cls2 = new ComponentName(info.packageName, info.targetActivity);
        ComponentName cls3 = cls2;
    L6:
        int userId = UserHandle.getUserId(info.applicationInfo.uid);
        PooledPredicate p = PooledLambda.obtainPredicate(new RootWindowContainer$$ExternalSyntheticLambda13(), PooledLambda.__(ActivityRecord.class), Integer.valueOf(userId), Boolean.valueOf(compareIntentFilters), intent, cls3);
        ActivityRecord r = getActivity(p);
        p.recycle();
        return r;
    L5:
        cls3 = cls;
        goto L6
    }

    private static boolean matchesActivity(ActivityRecord r, int userId, boolean compareIntentFilters, Intent intent, ComponentName cls) {
        if (r.canBeTopRunning() == true) goto L5;
    L16:
        return false;
    L5:
        if (r.mUserId != userId) goto L16;
        if (compareIntentFilters == false) goto L13;
        if (r.intent.filterEquals(intent) == false) goto L15;
        return true;
    L15:
        return false;
    L13:
        if (r.mActivityComponent.equals(cls) == false) goto L15;
        return true;
    }

    boolean hasAwakeDisplay() {
        int displayNdx = getChildCount() - 1;
    L3:
        if (displayNdx < 0) goto L8;
        DisplayContent display = getChildAt(displayNdx);
        if (display.shouldSleep() == false) goto L6;
        displayNdx = displayNdx - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    Task getOrCreateRootTask(ActivityRecord r, ActivityOptions options, Task candidateTask, boolean onTop) {
        return getOrCreateRootTask(r, options, candidateTask, null, onTop, null, 0);
    }

    Task getOrCreateRootTask(ActivityRecord r, ActivityOptions options, Task candidateTask, Task sourceTask, boolean onTop, LaunchParamsController.LaunchParams launchParams, int launchFlags) {
        if (options == null) goto L10;
        Task candidateRoot = Task.fromWindowContainerToken(options.getLaunchRootTask());
        if (candidateRoot == null) goto L10;
        if (canLaunchOnDisplay(r, candidateRoot) == false) goto L10;
        return candidateRoot;
    L10:
        if (options == null) goto L18;
        int candidateTaskId = options.getLaunchTaskId();
        if (candidateTaskId == (-1)) goto L17;
        options.setLaunchTaskId(-1);
        boolean r8 = onTop;
        Task task = anyTaskForId(candidateTaskId, 2, options, r8);
        options.setLaunchTaskId(candidateTaskId);
        if (canLaunchOnDisplay(r, task) == false) goto L20;
        return task.getRootTask();
    L20:
        if (launchParams != null) goto L22;
    L24:
        if (options == null) goto L37;
        WindowContainerToken daToken = options.getLaunchTaskDisplayArea();
        if (daToken == null) goto L28;
        TaskDisplayArea r3 = (TaskDisplayArea) WindowContainer.fromBinder(daToken.asBinder());
    L29:
        TaskDisplayArea taskDisplayArea = r3;
        if (taskDisplayArea != null) goto L36;
        int launchDisplayId = options.getLaunchDisplayId();
        if (launchDisplayId == (-1)) goto L36;
        DisplayContent displayContent = getDisplayContent(launchDisplayId);
        if (displayContent == null) goto L36;
        TaskDisplayArea taskDisplayArea2 = displayContent.getDefaultTaskDisplayArea();
        TaskDisplayArea taskDisplayArea3 = taskDisplayArea2;
    L38:
        int activityType = resolveActivityType(r, options, candidateTask);
        if (taskDisplayArea3 != null) goto L41;
    L45:
        Task rootTask = null;
        if (candidateTask == null) goto L48;
        rootTask = candidateTask.getRootTask();
    L48:
        if (rootTask != null) goto L51;
        if (r == null) goto L51;
        Task rootTask2 = r.getRootTask();
        Task rootTask3 = rootTask2;
    L52:
        if (launchParams == null) goto L54;
        int windowingMode = launchParams.mWindowingMode;
    L56:
        if (rootTask3 == null) goto L72;
        taskDisplayArea3 = rootTask3.getDisplayArea();
        if (taskDisplayArea3 != null) goto L60;
    L70:
        taskDisplayArea3 = null;
        goto L72
    L60:
        if (canLaunchOnDisplay(r, taskDisplayArea3.mDisplayContent.mDisplayId) == false) goto L70;
        if (windowingMode != 0) goto L64;
        windowingMode = taskDisplayArea3.resolveWindowingMode(r, options, candidateTask);
    L64:
        if (rootTask3.isCompatible(windowingMode, activityType) == false) goto L66;
    L69:
        return rootTask3;
    L66:
        if (rootTask3.mCreatedByOrganizer == true) goto L69;
    L72:
        if (taskDisplayArea3 != null) goto L75;
        taskDisplayArea3 = getDefaultTaskDisplayArea();
    L75:
        return taskDisplayArea3.getOrCreateRootTask(r, options, candidateTask, sourceTask, launchParams, launchFlags, activityType, onTop);
    L54:
        windowingMode = 0;
    L51:
        rootTask3 = rootTask;
        goto L52
    L41:
        if (canLaunchOnDisplay(r, taskDisplayArea3.getDisplayId()) == true) goto L43;
        taskDisplayArea3 = null;
        goto L45
    L43:
        return taskDisplayArea3.getOrCreateRootTask(r, options, candidateTask, sourceTask, launchParams, launchFlags, activityType, r8);
    L36:
        taskDisplayArea3 = taskDisplayArea;
        goto L38
    L28:
        r3 = null;
        goto L29
    L37:
        taskDisplayArea3 = null;
        goto L38
    L22:
        if (launchParams.mPreferredTaskDisplayArea == null) goto L24;
        TaskDisplayArea taskDisplayArea4 = launchParams.mPreferredTaskDisplayArea;
        taskDisplayArea3 = taskDisplayArea4;
        goto L38
    L17:
        r8 = onTop;
        goto L20
    L18:
        r8 = onTop;
        goto L20
    }

    private boolean canLaunchOnDisplay(ActivityRecord r, Task task) {
        if (task != null) goto L7;
        Slog.w("WindowManager", "canLaunchOnDisplay(), invalid task: " + task);
        return false;
    L7:
        if (task.isAttached() == true) goto L11;
        Slog.w("WindowManager", "canLaunchOnDisplay(), Task is not attached: " + task);
        return false;
    L11:
        return canLaunchOnDisplay(r, task.getTaskDisplayArea().getDisplayId());
    }

    private boolean canLaunchOnDisplay(ActivityRecord r, int displayId) {
        if (r != null) goto L6;
        return true;
    L6:
        if (r.canBeLaunchedOnDisplay(displayId) == true) goto L9;
        Slog.w("WindowManager", "Not allow to launch " + r + " on display " + displayId);
        return false;
    L9:
        return true;
    }

    int resolveActivityType(ActivityRecord r, ActivityOptions options, Task task) {
        if (r == null) goto L4;
        int activityType = r.getActivityType();
    L5:
        if (activityType != 0) goto L8;
        if (task == null) goto L8;
        activityType = task.getActivityType();
    L8:
        if (activityType == 0) goto L10;
        return activityType;
    L10:
        if (options == null) goto L12;
        activityType = options.getLaunchActivityType();
    L12:
        if (activityType != 0) goto L16;
        return 1;
    L16:
        return activityType;
    L4:
        activityType = 0;
        goto L5
    }

    Task getNextFocusableRootTask(Task currentFocus, boolean ignoreCurrent) {
        TaskDisplayArea preferredDisplayArea = currentFocus.getDisplayArea();
        if (preferredDisplayArea != null) goto L5;
        preferredDisplayArea = getDisplayContent(currentFocus.mPrevDisplayId).getDefaultTaskDisplayArea();
    L5:
        Task preferredFocusableRootTask = preferredDisplayArea.getNextFocusableRootTask(currentFocus, ignoreCurrent);
        if (preferredFocusableRootTask == null) goto L9;
        return preferredFocusableRootTask;
    L9:
        if (preferredDisplayArea.mDisplayContent.isHomeSupported() == false) goto L11;
        return null;
    L11:
        int i = getChildCount() - 1;
    L12:
        if (i < 0) goto L21;
        DisplayContent display = getChildAt(i);
        if (display == preferredDisplayArea.mDisplayContent) goto L19;
        Task nextFocusableRootTask = display.getDefaultTaskDisplayArea().getNextFocusableRootTask(currentFocus, ignoreCurrent);
        if (nextFocusableRootTask == null) goto L19;
        return nextFocusableRootTask;
    L19:
        i = i - 1;
        goto L12
    L21:
        return null;
    }

    void closeSystemDialogActivities(final String reason) {
        forAllActivities(new RootWindowContainer$$ExternalSyntheticLambda37(this, reason));
    }

    private /* synthetic */ void lambda$closeSystemDialogActivities$34(String reason, ActivityRecord r) {
        if ((r.info.flags & 256) == 0) goto L5;
    L6:
        r.finishIfPossible(reason, true);
        return;
    L5:
        if (shouldCloseAssistant(r, reason) == true) goto L6;
    }

    boolean hasVisibleWindowAboveButDoesNotOwnNotificationShade(final int uid) {
        final boolean[] visibleWindowFound = {false};
        return forAllWindows(new RootWindowContainer$$ExternalSyntheticLambda46(uid, visibleWindowFound), true);
    }

    private static /* synthetic */ boolean lambda$hasVisibleWindowAboveButDoesNotOwnNotificationShade$35(int uid, boolean[] visibleWindowFound, WindowState w) {
        if (w.mOwnerUid != uid) goto L8;
        if (w.isVisible() == false) goto L8;
        visibleWindowFound[0] = true;
    L8:
        if (w.mAttrs.type == 2040) goto L10;
        return false;
    L10:
        if (visibleWindowFound[0] == false) goto L15;
        if (w.mOwnerUid == uid) goto L15;
        return true;
    L15:
        return false;
    }

    private boolean shouldCloseAssistant(ActivityRecord r, String reason) {
        if (r.isActivityTypeAssistant() == true) goto L6;
        return false;
    L6:
        if (reason != PhoneWindowManager.SYSTEM_DIALOG_REASON_ASSIST) goto L9;
        return false;
    L9:
        return this.mWmService.mAssistantOnTopOfDream;
    }

    boolean finishDisabledPackageActivities(String packageName, Set<String> filterByClasses, boolean doit, boolean evenPersistent, int userId, boolean onlyRemoveNoProcess) {
        return this.mFinishDisabledPackageActivitiesHelper.process(packageName, filterByClasses, doit, evenPersistent, userId, onlyRemoveNoProcess);
    }

    void updateActivityApplicationInfo(final ApplicationInfo aInfo) {
        final String packageName = aInfo.packageName;
        final int userId = UserHandle.getUserId(aInfo.uid);
        forAllActivities(new RootWindowContainer$$ExternalSyntheticLambda18(userId, packageName, aInfo));
    }

    private static /* synthetic */ void lambda$updateActivityApplicationInfo$36(int userId, String packageName, ApplicationInfo aInfo, ActivityRecord r) {
        if (r.mUserId == userId) goto L5;
        return;
    L5:
        if (packageName.equals(r.packageName) == false) goto L9;
        r.updateApplicationInfo(aInfo);
        return;
    }

    void updateActivityApplicationInfo(final int userId, final ArrayMap<String, ApplicationInfo> applicationInfoByPackage) {
        forAllActivities(new RootWindowContainer$$ExternalSyntheticLambda56(userId, applicationInfoByPackage));
    }

    private static /* synthetic */ void lambda$updateActivityApplicationInfo$37(int userId, ArrayMap applicationInfoByPackage, ActivityRecord r) {
        if (r.mUserId == userId) goto L5;
        return;
    L5:
        ApplicationInfo aInfo = (ApplicationInfo) applicationInfoByPackage.get(r.packageName);
        if (aInfo == null) goto L9;
        r.updateApplicationInfo(aInfo);
        return;
    }

    void finishVoiceTask(IVoiceInteractionSession session) {
        final IBinder binder = session.asBinder();
        forAllLeafTasks(new RootWindowContainer$$ExternalSyntheticLambda34(binder), true);
    }

    private static /* synthetic */ void lambda$finishVoiceTask$38(IBinder binder, Task t) {
        t.finishIfVoiceTask(binder);
    }

    void removeRootTasksInWindowingModes(int... windowingModes) {
        int i = getChildCount() - 1;
    L3:
        if (i < 0) goto L6;
        getChildAt(i).removeRootTasksInWindowingModes(windowingModes);
        i = i - 1;
        goto L3
    }

    void removeRootTasksWithActivityTypes(int... activityTypes) {
        int i = getChildCount() - 1;
    L3:
        if (i < 0) goto L6;
        getChildAt(i).removeRootTasksWithActivityTypes(activityTypes);
        i = i - 1;
        goto L3
    }

    ActivityRecord topRunningActivity() {
        int i = getChildCount() - 1;
    L3:
        if (i < 0) goto L8;
        ActivityRecord topActivity = getChildAt(i).topRunningActivity();
        if (topActivity != null) goto L6;
        i = i - 1;
        goto L3
    L6:
        return topActivity;
    L8:
        return null;
    }

    private static ActivityRecord getNotYetIdleActivity(TaskFragment visibleTf) {
        int i = visibleTf.getChildCount() - 1;
    L3:
        if (i < 0) goto L27;
        ActivityRecord r = visibleTf.getChildAt(i).asActivityRecord();
        if (r == null) goto L18;
        if (r.finishing == true) goto L18;
        if (r.idle == false) goto L12;
        return null;
    L12:
        if (r.isState(ActivityRecord.State.RESUMED) == false) goto L14;
    L17:
        return r;
    L14:
        if (r.app == null) goto L16;
        return null;
    L16:
        if (r.isFocusable() == true) goto L17;
        return null;
    L18:
        i = i - 1;
        goto L3
    L27:
        return null;
    }

    boolean allResumedActivitiesIdle() {
        int displayNdx = getChildCount() - 1;
    L3:
        if (displayNdx < 0) goto L14;
        DisplayContent display = getChildAt(displayNdx);
        if (display.isSleeping() == true) goto L13;
        boolean foundNotIdle = display.forAllLeafTasks(new RootWindowContainer$$ExternalSyntheticLambda12());
        if (foundNotIdle == true) goto L9;
        if (this.mTransitionController.hasTransientLaunch(display) == false) goto L13;
        return false;
    L9:
        return false;
    L13:
        displayNdx = displayNdx - 1;
        goto L3
    L14:
        this.mService.endPowerMode(1);
        return true;
    }

    private static /* synthetic */ boolean lambda$allResumedActivitiesIdle$40(Task task) {
        if (task.isVisibleRequested() == true) goto L5;
        return false;
    L5:
        ActivityRecord notIdle = getNotYetIdleActivity(task);
        if (notIdle == null) goto L13;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[0] == false) goto L17;
        String protoLogParam0 = String.valueOf(notIdle);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_STATES, 8853611605390408797L, 0, new Object[]{protoLogParam0});
        return true;
    L17:
        return true;
    L13:
        if (task.isLeafTaskFragment() == false) goto L16;
        return false;
    L16:
        return task.forAllLeafTaskFragments(new RootWindowContainer$$ExternalSyntheticLambda54());
    }

    private static /* synthetic */ boolean lambda$allResumedActivitiesIdle$39(TaskFragment tf) {
        if (tf.isVisibleRequested() == true) goto L5;
        return false;
    L5:
        ActivityRecord tfNotIdle = getNotYetIdleActivity(tf);
        if (tfNotIdle != null) goto L8;
        return false;
    L8:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[0] == false) goto L13;
        String protoLogParam0 = String.valueOf(tfNotIdle);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_STATES, 8853611605390408797L, 0, new Object[]{protoLogParam0});
        return true;
    L13:
        return true;
    }

    boolean allResumedActivitiesVisible() {
        final boolean[] foundResumed = {false};
        boolean foundInvisibleResumedActivity = forAllRootTasks(new RootWindowContainer$$ExternalSyntheticLambda30(foundResumed));
        if (foundInvisibleResumedActivity == false) goto L6;
        return false;
    L6:
        return foundResumed[0];
    }

    private static /* synthetic */ boolean lambda$allResumedActivitiesVisible$41(boolean[] foundResumed, Task rootTask) {
        ActivityRecord r = rootTask.getTopResumedActivity();
        if (r != null) goto L5;
    L8:
        return false;
    L5:
        if (r.nowVisible == true) goto L7;
        return true;
    L7:
        foundResumed[0] = true;
        goto L8
    }

    boolean allPausedActivitiesComplete() {
        final boolean[] pausing = {true};
        boolean hasActivityNotCompleted = forAllLeafTasks(new RootWindowContainer$$ExternalSyntheticLambda24(pausing));
        if (hasActivityNotCompleted == false) goto L6;
        return false;
    L6:
        return pausing[0];
    }

    private static /* synthetic */ boolean lambda$allPausedActivitiesComplete$42(boolean[] pausing, Task task) {
        ActivityRecord r = task.getTopPausingActivity();
        if (r != null) goto L5;
    L14:
        return false;
    L5:
        if (r.isState(ActivityRecord.State.PAUSED, ActivityRecord.State.STOPPED, ActivityRecord.State.STOPPING, ActivityRecord.State.FINISHING) == true) goto L14;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[0] == false) goto L10;
        String protoLogParam0 = String.valueOf(r);
        String protoLogParam1 = String.valueOf(r.getState());
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_STATES, 3785779399471740019L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L10:
        if (WmProtoLogGroups.WM_DEBUG_STATES.isEnabled() == false) goto L12;
        pausing[0] = false;
        goto L14
    L12:
        return true;
    }

    void lockAllProfileTasks(final int userId) {
        forAllLeafTasks(new RootWindowContainer$$ExternalSyntheticLambda50(this, userId), true);
    }

    private /* synthetic */ void lambda$lockAllProfileTasks$44(final int userId, Task task) {
        ActivityRecord top = task.topRunningActivity();
        if (top == null) goto L12;
        if (top.finishing == true) goto L12;
        if ("android.app.action.CONFIRM_DEVICE_CREDENTIAL_WITH_USER".equals(top.intent.getAction()) == false) goto L12;
        if (top.packageName.equals(this.mService.getSysUiServiceComponentLocked().getPackageName()) == false) goto L12;
        return;
    L12:
        if (task.getActivity(new RootWindowContainer$$ExternalSyntheticLambda39(userId)) == null) goto L15;
        this.mService.getTaskChangeNotificationController().notifyTaskProfileLocked(task.getTaskInfo(), userId);
        return;
    }

    private static /* synthetic */ boolean lambda$lockAllProfileTasks$43(int userId, ActivityRecord activity) {
        if (activity.finishing == false) goto L5;
    L7:
        return false;
    L5:
        if (activity.mUserId != userId) goto L7;
        return true;
    }

    Task anyTaskForId(int id) {
        return anyTaskForId(id, 2);
    }

    Task anyTaskForId(int id, int matchMode) {
        return anyTaskForId(id, matchMode, null, false);
    }

    Task anyTaskForId(int id, int matchMode, ActivityOptions aOptions, boolean onTop) {
        int r0 = 2;
        if (matchMode == 2) goto L8;
        if (aOptions == null) goto L8;
        throw new IllegalArgumentException("Should not specify activity options for non-restore lookup");
    L8:
        PooledPredicate p = PooledLambda.obtainPredicate(new RootWindowContainer$$ExternalSyntheticLambda19(), PooledLambda.__(Task.class), Integer.valueOf(id));
        Task task = getTask(p);
        p.recycle();
        if (task == null) goto L27;
        if (aOptions == null) goto L25;
        Task targetRootTask = getOrCreateRootTask(null, aOptions, task, onTop);
        if (targetRootTask == null) goto L25;
        if (task.getRootTask() == targetRootTask) goto L25;
        if (task.getParent() == targetRootTask) goto L25;
        if (onTop == false) goto L19;
        r0 = 0;
    L19:
        int reparentMode = r0;
        task.reparent(targetRootTask, onTop, reparentMode, true, true, "anyTaskForId");
    L25:
        return task;
    L27:
        if (matchMode != 0) goto L30;
        return null;
    L30:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L32;
        Slog.v("WindowManager", "Looking for task id=" + id + " in recents");
    L32:
        Task task2 = this.mTaskSupervisor.mRecentTasks.getTask(id);
        if (task2 != null) goto L39;
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L37;
        Slog.d("WindowManager", "\tDidn't find task id=" + id + " in recents");
    L37:
        return null;
    L39:
        if (matchMode != 1) goto L42;
        return task2;
    L42:
        if (this.mTaskSupervisor.restoreRecentTaskLocked(task2, aOptions, onTop) == true) goto L48;
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L46;
        Slog.w("WindowManager", "Couldn't restore task id=" + id + " found in recents");
    L46:
        return null;
    L48:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L50;
        Slog.w("WindowManager", "Restored task id=" + id + " from in recents");
    L50:
        return task2;
    }

    void getRunningTasks(int maxNum, List<ActivityManager.RunningTaskInfo> list, int flags, int callingUid, ArraySet<Integer> profileIds, int displayId) {
        if (displayId == (-1)) goto L8;
        WindowContainer root = getDisplayContent(displayId);
        if (root != null) goto L7;
        return;
    L7:
        WindowContainer root2 = root;
    L9:
        this.mTaskSupervisor.getRunningTasks().getTasks(maxNum, list, flags, this.mService.getRecentTasks(), root2, callingUid, profileIds);
        return;
    L8:
        root2 = this;
        goto L9
    }

    void startPowerModeLaunchIfNeeded(boolean forceSend, final ActivityRecord targetActivity) {
        if (forceSend == true) goto L12;
        if (targetActivity == null) goto L12;
        if (targetActivity.app == null) goto L12;
        final boolean[] noResumedActivities = {true};
        final boolean[] allFocusedProcessesDiffer = {true};
        forAllTaskDisplayAreas(new RootWindowContainer$$ExternalSyntheticLambda16(noResumedActivities, allFocusedProcessesDiffer, targetActivity));
        if (noResumedActivities[0] == true) goto L12;
        if (allFocusedProcessesDiffer[0] == true) goto L12;
        return;
    L12:
        int reason = 1;
        if (targetActivity == null) goto L15;
        boolean isKeyguardLocked = targetActivity.isKeyguardLocked();
    L16:
        if (isKeyguardLocked == false) goto L27;
        if (targetActivity == null) goto L27;
        if (targetActivity.isLaunchSourceType(3) == true) goto L27;
        ActivityOptions opts = targetActivity.getOptions();
        if (opts != null) goto L23;
    L26:
        reason = 1 | 4;
        goto L27
    L23:
        if (opts.getSourceInfo() == null) goto L26;
        if (opts.getSourceInfo().type != 3) goto L26;
    L27:
        this.mService.startPowerMode(reason);
        return;
    L15:
        isKeyguardLocked = this.mDefaultDisplay.isKeyguardLocked();
        goto L16
    }

    private static /* synthetic */ void lambda$startPowerModeLaunchIfNeeded$45(boolean[] noResumedActivities, boolean[] allFocusedProcessesDiffer, ActivityRecord targetActivity, TaskDisplayArea taskDisplayArea) {
        ActivityRecord resumedActivity = taskDisplayArea.getFocusedActivity();
        if (resumedActivity != null) goto L5;
        WindowProcessController resumedActivityProcess = null;
    L6:
        boolean r3 = noResumedActivities[0];
        if (resumedActivityProcess != null) goto L9;
        boolean r5 = true;
    L10:
        noResumedActivities[0] = r3 & r5;
        if (resumedActivityProcess == null) goto L14;
        allFocusedProcessesDiffer[0] = allFocusedProcessesDiffer[0] & (true ^ resumedActivityProcess.equals(targetActivity.app));
        return;
    L14:
        return;
    L9:
        r5 = false;
        goto L10
    L5:
        resumedActivityProcess = resumedActivity.app;
        goto L6
    }

    public int getTaskToShowPermissionDialogOn(final String pkgName, final int uid) {
        final PermissionPolicyInternal pPi = this.mService.getPermissionPolicyInternal();
        if (pPi != null) goto L5;
        return -1;
    L5:
        final int[] validTaskId = {-1};
        forAllLeafTaskFragments(new RootWindowContainer$$ExternalSyntheticLambda35(pPi, uid, pkgName, validTaskId));
        return validTaskId[0];
    }

    private static /* synthetic */ boolean lambda$getTaskToShowPermissionDialogOn$47(final PermissionPolicyInternal pPi, int uid, String pkgName, int[] validTaskId, TaskFragment fragment) {
        ActivityRecord record = fragment.getActivity(new RootWindowContainer$$ExternalSyntheticLambda49(pPi));
        if (record == null) goto L14;
        if (record.isUid(uid) == false) goto L14;
        if (Objects.equals(pkgName, record.packageName) == false) goto L14;
        if (pPi.shouldShowNotificationDialogForTask(record.getTask().getTaskInfo(), pkgName, record.launchedFromPackage, record.intent, record.getName()) == false) goto L14;
        validTaskId[0] = record.getTask().mTaskId;
        return true;
    L14:
        return false;
    }

    private static /* synthetic */ boolean lambda$getTaskToShowPermissionDialogOn$46(PermissionPolicyInternal pPi, ActivityRecord r) {
        if (r.canBeTopRunning() == true) goto L5;
    L9:
        return false;
    L5:
        if (r.isVisibleRequested() == false) goto L9;
        if (pPi.isIntentToPermissionDialog(r.intent) == true) goto L9;
        return true;
    }

    ArrayList<ActivityRecord> getDumpActivities(final String name, final boolean dumpVisibleRootTasksOnly, boolean dumpFocusedRootTaskOnly, final int userId) {
        if (dumpFocusedRootTaskOnly == false) goto L9;
        Task topFocusedRootTask = getTopDisplayFocusedRootTask();
        if (topFocusedRootTask == null) goto L8;
        return topFocusedRootTask.getDumpActivitiesLocked(name, userId);
    L8:
        return new ArrayList();
    L9:
        RecentTasks recentTasks = this.mWindowManager.mAtmService.getRecentTasks();
        if (recentTasks == null) goto L12;
        int r1 = recentTasks.getRecentsComponentUid();
    L13:
        final int recentsComponentUid = r1;
        final ArrayList<ActivityRecord> activities = new ArrayList();
        forAllLeafTasks(new RootWindowContainer$$ExternalSyntheticLambda55(recentsComponentUid, dumpVisibleRootTasksOnly, activities, name, userId));
        return activities;
    L12:
        r1 = -1;
        goto L13
    }

    private static /* synthetic */ boolean lambda$getDumpActivities$48(int recentsComponentUid, boolean dumpVisibleRootTasksOnly, ArrayList activities, String name, int userId, Task task) {
        if (task.effectiveUid != recentsComponentUid) goto L5;
        boolean isRecents = true;
    L6:
        if (dumpVisibleRootTasksOnly == true) goto L8;
    L10:
        activities.addAll(task.getDumpActivitiesLocked(name, userId));
    L11:
        return false;
    L8:
        if (task.shouldBeVisible(null) == true) goto L10;
        if (isRecents == false) goto L11;
    L5:
        isRecents = false;
        goto L6
    }

    @Override // com.android.server.wm.WindowContainer
    public void dump(PrintWriter pw, String prefix, boolean dumpAll) {
        super.dump(pw, prefix, dumpAll);
        pw.print(prefix);
        pw.println("topDisplayFocusedRootTask=" + getTopDisplayFocusedRootTask());
        int i = getChildCount() + (-1);
    L3:
        if (i < 0) goto L6;
        DisplayContent display = getChildAt(i);
        display.dump(pw, prefix, dumpAll);
        i = i - 1;
        goto L3
    }

    void dumpDisplayConfigs(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.println("Display override configurations:");
        int displayCount = getChildCount();
        int i = 0;
    L3:
        if (i >= displayCount) goto L6;
        DisplayContent displayContent = getChildAt(i);
        pw.print(prefix);
        pw.print("  ");
        pw.print(displayContent.mDisplayId);
        pw.print(": ");
        pw.println(displayContent.getRequestedOverrideConfiguration());
        i = i + 1;
        goto L3
    }

    boolean dumpActivities(final FileDescriptor fd, final PrintWriter pw, final boolean dumpAll, final boolean dumpClient, final String dumpPackage, int displayIdFilter) {
        final PrintWriter r2 = pw;
        final boolean[] printed = {false};
        boolean[] printed2 = {false};
        int displayNdx = getChildCount() - 1;
    L3:
        if (displayNdx < 0) goto L13;
        DisplayContent displayContent = getChildAt(displayNdx);
        if (printed[0] == false) goto L7;
        r2.println();
    L7:
        if (displayIdFilter != (-1)) goto L9;
    L11:
        r2.print("Display #");
        r2.print(displayContent.mDisplayId);
        r2.println(" (activities from top to bottom):");
        final boolean[] needSep = printed2;
        Consumer<Task> r1 = new RootWindowContainer$$ExternalSyntheticLambda2(needSep, pw, fd, dumpAll, dumpClient, dumpPackage, printed);
        final boolean[] needSep2 = needSep;
        r2 = pw;
        final boolean[] needSep3 = printed;
        displayContent.forAllRootTasks(r1);
        displayContent.forAllTaskDisplayAreas(new RootWindowContainer$$ExternalSyntheticLambda3(needSep3, r2, dumpPackage, needSep2));
    L12:
        displayNdx = displayNdx - 1;
        printed = needSep3;
        printed2 = needSep2;
        goto L3
    L9:
        if (displayContent.mDisplayId == displayIdFilter) goto L11;
        needSep2 = printed2;
        needSep3 = printed;
        goto L12
    L13:
        boolean[] needSep4 = printed;
        needSep4[0] = needSep4[0] | ActivityTaskSupervisor.dumpHistoryList(fd, r2, this.mTaskSupervisor.mFinishingActivities, "  ", "Fin", false, !dumpAll, false, dumpPackage, true, new RootWindowContainer$$ExternalSyntheticLambda4(r2), null);
        needSep4[0] = needSep4[0] | ActivityTaskSupervisor.dumpHistoryList(fd, r2, this.mTaskSupervisor.mStoppingActivities, "  ", "Stop", false, !dumpAll, false, dumpPackage, true, new RootWindowContainer$$ExternalSyntheticLambda5(r2), null);
        return needSep4[0];
    }

    private static /* synthetic */ void lambda$dumpActivities$49(boolean[] needSep, PrintWriter pw, FileDescriptor fd, boolean dumpAll, boolean dumpClient, String dumpPackage, boolean[] printed, Task rootTask) {
        if (needSep[0] == false) goto L5;
        pw.println();
    L5:
        needSep[0] = rootTask.dump(fd, pw, dumpAll, dumpClient, dumpPackage, false);
        printed[0] = printed[0] | needSep[0];
    }

    private static /* synthetic */ void lambda$dumpActivities$51(boolean[] printed, final PrintWriter pw, String dumpPackage, boolean[] needSep, TaskDisplayArea taskDisplayArea) {
        boolean r1 = printed[0];
        printed[0] = ActivityTaskSupervisor.printThisActivity(pw, taskDisplayArea.getFocusedActivity(), dumpPackage, needSep[0], "    Resumed: ", new RootWindowContainer$$ExternalSyntheticLambda48(pw)) | r1;
    }

    private static /* synthetic */ void lambda$dumpActivities$50(PrintWriter pw) {
        pw.println("  Resumed activities in task display areas (from top to bottom):");
    }

    private static /* synthetic */ void lambda$dumpActivities$52(PrintWriter pw) {
        pw.println("  Activities waiting to finish:");
    }

    private static /* synthetic */ void lambda$dumpActivities$53(PrintWriter pw) {
        pw.println("  Activities waiting to stop:");
    }

    private static int makeSleepTokenKey(String tag, int displayId) {
        String tokenKey = tag + displayId;
        return tokenKey.hashCode();
    }

    public Task getTopDisplayFullScreenTask() {
        TaskDisplayArea taskDisplayArea = getDefaultTaskDisplayArea();
        return taskDisplayArea.getRootTask(1, 0);
    }

    int getTopFocusedDisplayId() {
        return this.mTopFocusedDisplayId;
    }

    public RootWindowContainerSmtBase getRWCSmtEx() {
        return (RootWindowContainerSmtBase) getSmtEx();
    }
}
