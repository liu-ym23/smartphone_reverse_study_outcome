package com.android.server.wm;

import android.app.ActivityOptions;
import android.app.IApplicationThread;
import android.app.ResultInfo;
import android.app.WindowConfiguration;
import android.app.servertransaction.ActivityResultItem;
import android.app.servertransaction.ClientTransactionItem;
import android.app.servertransaction.NewIntentItem;
import android.app.servertransaction.PauseActivityItem;
import android.app.servertransaction.ResumeActivityItem;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.StabTrace;
import android.os.SystemClock;
import android.os.UserHandle;
import android.pico.utils.ExtImplFactory;
import android.pico.utils.Features;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.view.DisplayInfo;
import android.view.SurfaceControl;
import android.window.ITaskFragmentOrganizer;
import android.window.TaskFragmentAnimationParams;
import android.window.TaskFragmentInfo;
import android.window.TaskFragmentOrganizerToken;
import com.android.internal.app.ActivityTrigger;
import com.android.internal.protolog.ProtoLog;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.ToBooleanFunction;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.am.HostingRecord;
import com.android.server.am.ProcessList;
import com.android.server.common.Constants;
import com.android.server.common.IGameAssistSerivce;
import com.android.server.dispatcher.GameActivityStateEventDispatcher;
import com.android.server.pm.pkg.AndroidPackage;
import com.zte.performance.mindsync.MindSyncManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
class TaskFragment extends WindowContainer<WindowContainer> {
    static final int EMBEDDED_DIM_AREA_PARENT_TASK = 1;
    static final int EMBEDDED_DIM_AREA_TASK_FRAGMENT = 0;
    static final int EMBEDDING_ALLOWED = 0;
    static final int EMBEDDING_DISALLOWED_MIN_DIMENSION_VIOLATION = 2;
    static final int EMBEDDING_DISALLOWED_NEW_TASK = 3;
    static final int EMBEDDING_DISALLOWED_UNTRUSTED_HOST = 1;
    static final int FLAG_FORCE_HIDDEN_FOR_PINNED_TASK = 1;
    static final int FLAG_FORCE_HIDDEN_FOR_TASK_FRAGMENT_ORG = 4;
    static final int FLAG_FORCE_HIDDEN_FOR_TASK_ORG = 2;
    static final int INVALID_MIN_SIZE = -1;
    static final boolean SHOW_APP_STARTING_PREVIEW = true;
    private static final String TAG = "ActivityTaskManager";
    private static final String TAG_RESULTS = "ActivityTaskManager";
    private static final String TAG_SWITCH = "ActivityTaskManager";
    private static final String TAG_TRANSITION = "ActivityTaskManager";
    static final int TASK_FRAGMENT_VISIBILITY_INVISIBLE = 2;
    static final int TASK_FRAGMENT_VISIBILITY_VISIBLE = 0;
    static final int TASK_FRAGMENT_VISIBILITY_VISIBLE_BEHIND_TRANSLUCENT = 1;
    static final ActivityTrigger mActivityTrigger = null;
    private AdjacentSet mAdjacentTaskFragments;
    private boolean mAllowTransitionWhenEmpty;
    private TaskFragmentAnimationParams mAnimationParams;
    final ActivityTaskManagerService mAtmService;
    private boolean mCanAffectSystemUiFlags;
    boolean mClearedForReorderActivityToFront;
    boolean mClearedTaskForReuse;
    boolean mClearedTaskFragmentForPip;
    private TaskFragment mCompanionTaskFragment;
    private int mConfigurationChangeMaskForOrganizer;
    boolean mCreatedByOrganizer;
    private boolean mDelayLastActivityRemoval;
    private boolean mDelayOrganizedTaskFragmentSurfaceUpdate;
    Dimmer mDimmer;
    private int mEmbeddedDimArea;
    private final EnsureActivitiesVisibleHelper mEnsureActivitiesVisibleHelper;
    private final IExtTaskFragment mExt;
    protected int mForceHiddenFlags;
    private boolean mForceTranslucent;
    private final IBinder mFragmentToken;
    private final boolean mIsEmbedded;
    private boolean mIsRemovalRequested;
    private boolean mIsolatedNav;
    ActivityRecord mLastPausedActivity;
    final Point mLastSurfaceSize;
    int mMinHeight;
    int mMinWidth;
    private boolean mMoveToBottomIfClearWhenLaunch;
    private ActivityRecord mPausingActivity;
    public BoostFramework mPerf;
    private boolean mPinned;
    private final Rect mRelativeEmbeddedBounds;
    private ActivityRecord mResumedActivity;
    final RootWindowContainer mRootWindowContainer;
    boolean mTaskFragmentAppearedSent;
    private ITaskFragmentOrganizer mTaskFragmentOrganizer;
    private final TaskFragmentOrganizerController mTaskFragmentOrganizerController;
    String mTaskFragmentOrganizerProcessName;
    int mTaskFragmentOrganizerUid;
    boolean mTaskFragmentVanishedSent;
    final ActivityTaskSupervisor mTaskSupervisor;
    private final Rect mTmpAbsBounds;
    private final Rect mTmpBounds;
    private final Rect mTmpFullBounds;
    private final Rect mTmpNonDecorBounds;
    private final Rect mTmpStableBounds;

    static class AdjacentSet {
        private final ArraySet<TaskFragment> mAdjacentSet;

        /* JADX INFO: renamed from: -$$Nest$mclear, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10266$$Nest$mclear(AdjacentSet r0) {
            r0.clear();
        }

        /* JADX INFO: renamed from: -$$Nest$mremove, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10267$$Nest$mremove(AdjacentSet r0, TaskFragment r1) {
            r0.remove(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetAsAdjacent, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10268$$Nest$msetAsAdjacent(AdjacentSet r0) {
            r0.setAsAdjacent();
        }

        AdjacentSet(TaskFragment... taskFragments) {
            this(new ArraySet(taskFragments));
        }

        AdjacentSet(ArraySet<TaskFragment> taskFragments) {
            int size = taskFragments.size();
            if (size < 2) goto L15;
            if (size <= 2) goto L12;
            int i = 0;
        L6:
            if (i >= size) goto L12;
            if (taskFragments.valueAt(i).asTask() == null) goto L11;
            i = i + 1;
            goto L6
        L11:
            throw new IllegalArgumentException("Not yet support 3+ adjacent for non-Task TFs");
        L12:
            this.mAdjacentSet = taskFragments;
            return;
        L15:
            throw new IllegalArgumentException("Adjacent TaskFragments must contain at least two TaskFragments, but only " + size + " were provided.");
        }

        private void setAsAdjacent() {
            if (this.mAdjacentSet.isEmpty() == false) goto L5;
            return;
        L5:
            if (equals(TaskFragment.m10263$$Nest$fgetmAdjacentTaskFragments(this.mAdjacentSet.valueAt(0))) == true) goto L14;
            int i = this.mAdjacentSet.size() - 1;
        L8:
            if (i < 0) goto L11;
            TaskFragment taskFragment = this.mAdjacentSet.valueAt(i);
            taskFragment.removeFromAdjacentTaskFragments();
            TaskFragment.m10264$$Nest$fputmAdjacentTaskFragments(taskFragment, this);
            i = i - 1;
            goto L8
        L11:
            return;
        }

        private void remove(TaskFragment taskFragment) {
            TaskFragment.m10264$$Nest$fputmAdjacentTaskFragments(taskFragment, null);
            TaskFragment.m10265$$Nest$fputmDelayLastActivityRemoval(taskFragment, false);
            this.mAdjacentSet.remove(taskFragment);
            if (this.mAdjacentSet.size() >= 2) goto L6;
            clear();
            return;
        }

        private void clear() {
            int i = this.mAdjacentSet.size() - 1;
        L3:
            if (i < 0) goto L5;
            TaskFragment taskFragment = this.mAdjacentSet.valueAt(i);
            TaskFragment.m10264$$Nest$fputmAdjacentTaskFragments(taskFragment, null);
            TaskFragment.m10265$$Nest$fputmDelayLastActivityRemoval(taskFragment, false);
            i = i - 1;
            goto L3
        L5:
            this.mAdjacentSet.clear();
        }

        boolean contains(TaskFragment taskFragment) {
            return this.mAdjacentSet.contains(taskFragment);
        }

        void forAllTaskFragments(Consumer<TaskFragment> callback, TaskFragment exclude) {
            int i = this.mAdjacentSet.size() - 1;
        L3:
            if (i < 0) goto L9;
            TaskFragment taskFragment = this.mAdjacentSet.valueAt(i);
            if (taskFragment == exclude) goto L7;
            callback.accept(taskFragment);
        L7:
            i = i - 1;
            goto L3
        }

        boolean forAllTaskFragments(Predicate<TaskFragment> callback, TaskFragment exclude) {
            int i = this.mAdjacentSet.size() - 1;
        L3:
            if (i < 0) goto L11;
            TaskFragment taskFragment = this.mAdjacentSet.valueAt(i);
            if (taskFragment == exclude) goto L10;
            if (callback.test(taskFragment) == false) goto L10;
            return true;
        L10:
            i = i - 1;
            goto L3
        L11:
            return false;
        }

        int size() {
            return this.mAdjacentSet.size();
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof AdjacentSet) == false) goto L9;
            AdjacentSet other = (AdjacentSet) o;
            return this.mAdjacentSet.equals(other.mAdjacentSet);
        L9:
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AdjacentSet{");
            int size = this.mAdjacentSet.size();
            int i = 0;
        L3:
            if (i >= size) goto L7;
            if (i == 0) goto L6;
            sb.append(", ");
        L6:
            sb.append(this.mAdjacentSet.valueAt(i));
            i = i + 1;
            goto L3
        L7:
            sb.append("}");
            return sb.toString();
        }
    }

    static class ConfigOverrideHint {
        Rect mParentAppBoundsOverride;
        Rect mParentBoundsOverride;
        AppCompatDisplayInsets mTmpCompatInsets;
        int mTmpOverrideConfigOrientation;
        DisplayInfo mTmpOverrideDisplayInfo;
        boolean mUseOverrideInsetsForConfig;

        ConfigOverrideHint() {
        }

        void resolveTmpOverrides(DisplayContent dc, Configuration parentConfig, boolean isFixedRotationTransforming, Rect safeRegionBounds) {
            if (safeRegionBounds == null) goto L4;
            Rect r0 = safeRegionBounds;
        L5:
            this.mParentAppBoundsOverride = r0;
            if (safeRegionBounds == null) goto L8;
            Rect r1 = safeRegionBounds;
        L9:
            this.mParentBoundsOverride = r1;
            this.mTmpOverrideConfigOrientation = parentConfig.orientation;
            Insets insets = Insets.NONE;
            int r2 = 2;
            if (safeRegionBounds == null) goto L17;
            if (this.mParentAppBoundsOverride.height() < this.mParentAppBoundsOverride.width()) goto L15;
            r2 = 1;
        L15:
            this.mTmpOverrideConfigOrientation = r2;
        L42:
            this.mParentAppBoundsOverride.inset(insets);
            return;
        L17:
            if (this.mUseOverrideInsetsForConfig == false) goto L42;
            if (dc == null) goto L42;
            if (WindowConfiguration.isFloating(parentConfig.windowConfiguration.getWindowingMode()) == true) goto L42;
            int rotation = parentConfig.windowConfiguration.getRotation();
            if (rotation != (-1)) goto L25;
            if (isFixedRotationTransforming == true) goto L25;
            rotation = dc.getRotation();
        L25:
            if (rotation != 1) goto L27;
        L30:
            boolean rotated = true;
        L31:
            if (rotated == false) goto L33;
            int dw = dc.mBaseDisplayHeight;
        L34:
            if (rotated == false) goto L36;
            int dh = dc.mBaseDisplayWidth;
        L37:
            DisplayPolicy.DecorInsets.Info decorInsets = dc.getDisplayPolicy().getDecorInsetsInfo(rotation, dw, dh);
            Rect stableBounds = decorInsets.mOverrideConfigFrame;
            if (stableBounds.width() > stableBounds.height()) goto L41;
            r2 = 1;
        L41:
            this.mTmpOverrideConfigOrientation = r2;
            insets = Insets.of(decorInsets.mOverrideNonDecorInsets);
            goto L42
        L36:
            dh = dc.mBaseDisplayHeight;
            goto L37
        L33:
            dw = dc.mBaseDisplayWidth;
            goto L34
        L27:
            if (rotation == 3) goto L30;
            rotated = false;
            goto L31
        L8:
            r1 = new Rect(parentConfig.windowConfiguration.getBounds());
            goto L9
        L4:
            r0 = new Rect(parentConfig.windowConfiguration.getAppBounds());
            goto L5
        }

        void resetTmpOverrides() {
            this.mTmpOverrideDisplayInfo = null;
            this.mTmpCompatInsets = null;
            this.mTmpOverrideConfigOrientation = 0;
        }
    }

    @interface EmbeddedDimArea {
    }

    @interface EmbeddingCheckResult {
    }

    @interface FlagForceHidden {
    }

    @interface TaskFragmentVisibility {
    }

    /* JADX INFO: renamed from: $r8$lambda$4cG6-OZL1pMHzsHQ8Bpa0SXc7vc, reason: not valid java name */
    public static /* synthetic */ boolean m10257$r8$lambda$4cG6OZL1pMHzsHQ8Bpa0SXc7vc(TaskFragment r0, ActivityRecord r1, TaskFragment r2) {
        return r0.lambda$getVisibility$9(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$LhMHdMMDc7WEqTPsP2awRhAcrmw(TaskFragment r0, boolean r1, PrintWriter r2, Runnable r3, String r4, boolean r5, String r6) {
        r0.lambda$dump$18(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$NjYGISsKhYlQu_oahd7dx03YQ00(TaskFragment r0, TaskFragment r1) {
        r0.lambda$cleanUpEmbeddedTaskFragment$14(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$OFppwJLKJYBwrXG7-ke2Qk0CiL4, reason: not valid java name */
    public static /* synthetic */ boolean m10258$r8$lambda$OFppwJLKJYBwrXG7ke2Qk0CiL4(ActivityRecord r0) {
        return lambda$getTopNonFinishingActivity$4(r0);
    }

    public static /* synthetic */ void $r8$lambda$PjDnhAcAYKOjz8CFh_HllpINj1g(int[] r0, ActivityRecord r1) {
        lambda$getNonFinishingActivityCount$7(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$QeeKK6OE5m92hyEIJf7vfer3PW8(ToBooleanFunction r0, TaskFragment r1) {
        return lambda$shouldBoostDimmer$17(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$R14gyHrMJPKwzmdxMKdxdLZiLTM(int[] r0, int[] r1, ActivityRecord r2) {
        lambda$calculateMinDimension$11(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$UGMxRu-xvsFPCFdAb-L2NRSBgYs, reason: not valid java name */
    public static /* synthetic */ boolean m10259$r8$lambda$UGMxRuxvsFPCFdAbL2NRSBgYs(ArrayList r0, int r1, TaskFragment r2) {
        return lambda$shouldBoostDimmer$15(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Xl-7Zu3nm08X79fdmew3vmGKj1o, reason: not valid java name */
    public static /* synthetic */ boolean m10260$r8$lambda$Xl7Zu3nm08X79fdmew3vmGKj1o(TaskFragment r0, TaskFragment r1) {
        return r0.lambda$getVisibility$8(r1);
    }

    public static /* synthetic */ void $r8$lambda$atyb4SeuUz2tVmx52jpy6mRzABQ(TaskFragment r0) {
        lambda$clearLastPausedActivity$12(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$cCOreq8AkspWCLOBq9Dd3lEozFQ(ActivityRecord r0) {
        return lambda$getTopNonFinishingActivity$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$ch0VBJldkIc8H446q_rIcRTaME0(ArrayList r0, ActivityRecord r1) {
        lambda$remove$13(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$eL7StY30NtrZuHKi3Zi5XR_pBxI(WindowState r0) {
        return lambda$shouldBoostDimmer$16(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$hHSa-oQqohaudc6TPcfuvcPqkZw, reason: not valid java name */
    public static /* synthetic */ boolean m10261$r8$lambda$hHSaoQqohaudc6TPcfuvcPqkZw(TaskFragment r0, ActivityRecord r1) {
        return r0.lambda$isAllowedToBeEmbeddedInTrustedMode$1(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$mt0M0gTd134V0Uwim3x23RD70ls(ActivityRecord r0) {
        return lambda$getTopNonFinishingActivity$5(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$um2HAmqSIS709S6Ch2gyOMoXFPA(ActivityRecord r0) {
        return lambda$getTopNonFinishingActivity$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$wC6-HKxrbth3XlEQSv7aSQF3g8c, reason: not valid java name */
    public static /* synthetic */ boolean m10262$r8$lambda$wC6HKxrbth3XlEQSv7aSQF3g8c(int r0, ActivityRecord r1) {
        return lambda$isFullyTrustedEmbedding$0(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$wlVkRW122N8JS_6yHTx7YyWD4Q8(ActivityRecord r0) {
        return lambda$topRunningActivity$6(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$woViOSzZHY2xARDvXanvn3UqeMs(ActivityRecord r0) {
        return lambda$isTopNonFinishingChild$10(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAdjacentTaskFragments, reason: not valid java name */
    static /* bridge */ /* synthetic */ AdjacentSet m10263$$Nest$fgetmAdjacentTaskFragments(TaskFragment r0) {
        return r0.mAdjacentTaskFragments;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAdjacentTaskFragments, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10264$$Nest$fputmAdjacentTaskFragments(TaskFragment r0, AdjacentSet r1) {
        r0.mAdjacentTaskFragments = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDelayLastActivityRemoval, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10265$$Nest$fputmDelayLastActivityRemoval(TaskFragment r0, boolean r1) {
        r0.mDelayLastActivityRemoval = r1;
    }

    @Override // com.android.server.wm.WindowContainer
    /* bridge */ /* synthetic */ DisplayArea getDisplayArea() {
        return getDisplayArea();
    }

    static {
        mActivityTrigger = new ActivityTrigger();
    }

    TaskFragment(ActivityTaskManagerService atmService, IBinder fragmentToken, boolean createdByOrganizer) {
        this(atmService, fragmentToken, createdByOrganizer, true);
    }

    TaskFragment(ActivityTaskManagerService atmService, IBinder fragmentToken, boolean createdByOrganizer, boolean isEmbedded) {
        super(atmService.mWindowManager);
        Rect r0 = null;
        this.mPerf = null;
        this.mDimmer = new Dimmer(this);
        this.mEmbeddedDimArea = 0;
        this.mPausingActivity = null;
        this.mLastPausedActivity = null;
        this.mResumedActivity = null;
        this.mTaskFragmentOrganizerUid = -1;
        this.mAnimationParams = TaskFragmentAnimationParams.DEFAULT;
        this.mForceHiddenFlags = 0;
        this.mForceTranslucent = false;
        this.mCanAffectSystemUiFlags = true;
        this.mLastSurfaceSize = new Point();
        this.mTmpBounds = new Rect();
        this.mTmpAbsBounds = new Rect();
        this.mTmpFullBounds = new Rect();
        this.mTmpStableBounds = new Rect();
        this.mTmpNonDecorBounds = new Rect();
        this.mEnsureActivitiesVisibleHelper = new EnsureActivitiesVisibleHelper(this);
        this.mExt = (IExtTaskFragment) ExtImplFactory.getImpl(IExtTaskFragment.class, new Object[]{this});
        this.mAtmService = atmService;
        this.mTaskSupervisor = this.mAtmService.mTaskSupervisor;
        this.mRootWindowContainer = this.mAtmService.mRootWindowContainer;
        this.mCreatedByOrganizer = createdByOrganizer;
        this.mIsEmbedded = isEmbedded;
        if (isEmbedded == false) goto L5;
        r0 = new Rect();
    L5:
        this.mRelativeEmbeddedBounds = r0;
        this.mTaskFragmentOrganizerController = this.mAtmService.mWindowOrganizerController.mTaskFragmentOrganizerController;
        this.mFragmentToken = fragmentToken;
        this.mRemoteToken = new WindowContainer.RemoteToken(this);
    }

    static TaskFragment fromTaskFragmentToken(IBinder token, ActivityTaskManagerService service) {
        if (token != null) goto L6;
        return null;
    L6:
        return service.mWindowOrganizerController.getTaskFragment(token);
    }

    void setAdjacentTaskFragments(AdjacentSet adjacentTaskFragments) {
        AdjacentSet.m10268$$Nest$msetAsAdjacent(adjacentTaskFragments);
    }

    void setCompanionTaskFragment(TaskFragment companionTaskFragment) {
        this.mCompanionTaskFragment = companionTaskFragment;
    }

    TaskFragment getCompanionTaskFragment() {
        return this.mCompanionTaskFragment;
    }

    void clearAdjacentTaskFragments() {
        if (this.mAdjacentTaskFragments == null) goto L6;
        AdjacentSet.m10266$$Nest$mclear(this.mAdjacentTaskFragments);
        return;
    }

    void removeFromAdjacentTaskFragments() {
        if (this.mAdjacentTaskFragments == null) goto L6;
        AdjacentSet.m10267$$Nest$mremove(this.mAdjacentTaskFragments, this);
        return;
    }

    AdjacentSet getAdjacentTaskFragments() {
        return this.mAdjacentTaskFragments;
    }

    void forOtherAdjacentTaskFragments(Consumer<TaskFragment> callback) {
        if (this.mAdjacentTaskFragments != null) goto L5;
        return;
    L5:
        this.mAdjacentTaskFragments.forAllTaskFragments(callback, this);
    }

    boolean forOtherAdjacentTaskFragments(Predicate<TaskFragment> callback) {
        if (this.mAdjacentTaskFragments != null) goto L7;
        return false;
    L7:
        return this.mAdjacentTaskFragments.forAllTaskFragments(callback, this);
    }

    boolean hasAdjacentTaskFragment() {
        if (this.mAdjacentTaskFragments == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isAdjacentTo(TaskFragment other) {
        if (other != this) goto L4;
    L8:
        return false;
    L4:
        if (this.mAdjacentTaskFragments == null) goto L8;
        if (this.mAdjacentTaskFragments.contains(other) == false) goto L8;
        return true;
    }

    void setTaskFragmentOrganizer(TaskFragmentOrganizerToken organizer, int uid, String processName) {
        this.mTaskFragmentOrganizer = ITaskFragmentOrganizer.Stub.asInterface(organizer.asBinder());
        this.mTaskFragmentOrganizerUid = uid;
        this.mTaskFragmentOrganizerProcessName = processName;
    }

    void onTaskFragmentOrganizerRestarted(ITaskFragmentOrganizer organizer) {
        this.mTaskFragmentOrganizer = organizer;
    }

    void onTaskFragmentOrganizerRemoved() {
        this.mTaskFragmentOrganizer = null;
    }

    boolean hasTaskFragmentOrganizer(ITaskFragmentOrganizer organizer) {
        if (organizer != null) goto L4;
    L8:
        return false;
    L4:
        if (this.mTaskFragmentOrganizer == null) goto L8;
        if (organizer.asBinder().equals(this.mTaskFragmentOrganizer.asBinder()) == false) goto L8;
        return true;
    }

    private WindowProcessController getOrganizerProcessIfDifferent(ActivityRecord r) {
        Task task = getTask();
        if (r == null) goto L15;
        if (task == null) goto L15;
        if (task.mTaskFragmentHostProcessName == null) goto L15;
        if (task.mTaskFragmentHostProcessName.equals(r.processName) == false) goto L14;
        if (task.mTaskFragmentHostUid != r.getUid()) goto L14;
        return null;
    L14:
        return this.mAtmService.getProcessController(task.mTaskFragmentHostProcessName, task.mTaskFragmentHostUid);
    L15:
        return null;
    }

    void setAnimationParams(TaskFragmentAnimationParams animationParams) {
        this.mAnimationParams = animationParams;
    }

    TaskFragmentAnimationParams getAnimationParams() {
        return this.mAnimationParams;
    }

    void setIsolatedNav(boolean isolatedNav) {
        if (isEmbedded() == true) goto L5;
        return;
    L5:
        this.mIsolatedNav = isolatedNav;
    }

    void setPinned(boolean pinned) {
        if (isEmbedded() == true) goto L5;
        return;
    L5:
        this.mPinned = pinned;
    }

    void setAllowTransitionWhenEmpty(boolean allowTransitionWhenEmpty) {
        if (isEmbedded() == true) goto L5;
        return;
    L5:
        this.mAllowTransitionWhenEmpty = allowTransitionWhenEmpty;
    }

    void setConfigurationChangeMaskForOrganizer(int mask) {
        if (this.mTaskFragmentOrganizerController.isSystemOrganizer(this.mTaskFragmentOrganizer.asBinder()) == false) goto L6;
        this.mConfigurationChangeMaskForOrganizer = mask;
        return;
    }

    int getConfigurationChangeMaskForOrganizer() {
        return this.mConfigurationChangeMaskForOrganizer;
    }

    boolean isIsolatedNav() {
        if (isEmbedded() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mIsolatedNav == false) goto L7;
        return true;
    }

    boolean isPinned() {
        if (isEmbedded() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mPinned == false) goto L7;
        return true;
    }

    ActivityRecord getTopResumedActivity() {
        WindowContainer<?> taskFragResumedActivity = getResumedActivity();
        int i = getChildCount() - 1;
    L3:
        if (i < 0) goto L14;
        WindowContainer<?> child = getChildAt(i);
        ActivityRecord topResumedActivity = null;
        if (taskFragResumedActivity == null) goto L9;
        if (child != taskFragResumedActivity) goto L9;
        topResumedActivity = child.asActivityRecord();
    L11:
        if (topResumedActivity != null) goto L12;
        i = i - 1;
        goto L3
    L12:
        return topResumedActivity;
    L9:
        if (child.asTaskFragment() == null) goto L11;
        topResumedActivity = child.asTaskFragment().getTopResumedActivity();
        goto L11
    L14:
        return null;
    }

    ActivityRecord getResumedActivity() {
        return this.mResumedActivity;
    }

    void setResumedActivity(ActivityRecord r, String reason) {
        if (this.mResumedActivity != r) goto L6;
        return;
    L6:
        if (Constants.ENABLE_GAME_ASSIST == false) goto L18;
        if (r == null) goto L18;
        if (r.hasProcess() == true) goto L11;
        ActivityRecord r2 = r;
    L20:
        if (ActivityTaskManagerDebugConfig.DEBUG_ROOT_TASK == false) goto L22;
        Slog.d("ActivityTaskManager", "setResumedActivity taskFrag:" + this + " + from: " + this.mResumedActivity + " to:" + r2 + " reason:" + reason);
    L22:
        Task extTask = getTask();
        if (extTask == null) goto L25;
        extTask.getExt().onTopResumedActivityChanged(r2, reason);
    L25:
        if (r2 == null) goto L30;
        if (this.mResumedActivity != null) goto L30;
        getTask().touchActiveTime();
    L30:
        if (this.mResumedActivity != null) goto L32;
    L36:
        if (r2 != null) goto L38;
    L42:
        ActivityRecord prevR = this.mResumedActivity;
        this.mResumedActivity = r2;
        ActivityRecord topResumed = this.mTaskSupervisor.updateTopResumedActivityIfNeeded(reason);
        if (this.mResumedActivity == null) goto L50;
        if (topResumed == null) goto L50;
        if (topResumed.isEmbedded() == false) goto L50;
        if (topResumed.getTaskFragment().isAdjacentTo(this) == false) goto L50;
        this.mAtmService.setLastResumedActivityUncheckLocked(this.mResumedActivity, reason);
    L50:
        if (r2 == null) goto L52;
    L56:
        if (r2 == null) goto L60;
        r2.mDisplayContent.onRunningActivityChanged();
        return;
    L60:
        return;
    L52:
        if (prevR.mDisplayContent == null) goto L56;
        if (prevR.mDisplayContent.getFocusedRootTask() != null) goto L56;
        prevR.mDisplayContent.onRunningActivityChanged();
        return;
    L38:
        if (this.mAtmService == null) goto L42;
        if (this.mAtmService.getSmtEx() == null) goto L42;
        this.mAtmService.getSmtEx().updateResumedUid(r2.getUid(), true);
        goto L42
    L32:
        if (this.mAtmService == null) goto L36;
        if (this.mAtmService.getSmtEx() == null) goto L36;
        this.mAtmService.getSmtEx().updateResumedUid(this.mResumedActivity.getUid(), false);
        this.mAtmService.getSmtEx().updateSetResumedUid(this.mResumedActivity.getUid(), false);
        goto L36
    L11:
        if (r.occludesParent() == false) goto L13;
    L16:
        r2 = r;
        GameActivityStateEventDispatcher.getInstance().notifyGameActivityResumed(r.getDisplayId(), r.info, r.getRootTaskId(), r.app.getPid(), r.getWindowingMode(), r.getActivityType(), r2, r.mActivityComponent, r.mUserId, r.getTask().getTaskLabelHashcode());
        goto L20
    L13:
        if (((IGameAssistSerivce) LocalServices.getService(IGameAssistSerivce.class)).isGameSpaceListApp(r.packageName) == true) goto L16;
        Slog.d("ActivityTaskManager", "setResumedActivity transparent acitivity:" + r);
        r2 = r;
    L18:
        r2 = r;
        goto L20
    }

    void setPausingActivity(ActivityRecord pausing) {
        this.mPausingActivity = pausing;
    }

    ActivityRecord getTopPausingActivity() {
        WindowContainer<?> taskFragPausingActivity = getPausingActivity();
        int i = getChildCount() - 1;
    L3:
        if (i < 0) goto L14;
        WindowContainer<?> child = getChildAt(i);
        ActivityRecord topPausingActivity = null;
        if (taskFragPausingActivity == null) goto L9;
        if (child != taskFragPausingActivity) goto L9;
        topPausingActivity = child.asActivityRecord();
    L11:
        if (topPausingActivity != null) goto L12;
        i = i - 1;
        goto L3
    L12:
        return topPausingActivity;
    L9:
        if (child.asTaskFragment() == null) goto L11;
        topPausingActivity = child.asTaskFragment().getTopPausingActivity();
        goto L11
    L14:
        return null;
    }

    ActivityRecord getPausingActivity() {
        return this.mPausingActivity;
    }

    int getDisplayId() {
        DisplayContent dc = getDisplayContent();
        if (dc != null) goto L7;
        return -1;
    L7:
        return dc.mDisplayId;
    }

    Task getTask() {
        if (asTask() == null) goto L7;
        return asTask();
    L7:
        if (getParent() == null) goto L9;
        TaskFragment parent = getParent().asTaskFragment();
    L10:
        if (parent != null) goto L12;
        return null;
    L12:
        return parent.getTask();
    L9:
        parent = null;
        goto L10
    }

    @Override // com.android.server.wm.WindowContainer
    TaskDisplayArea getDisplayArea() {
        return (TaskDisplayArea) super.getDisplayArea();
    }

    @Override // com.android.server.wm.WindowContainer
    public boolean isAttached() {
        TaskDisplayArea taskDisplayArea = getDisplayArea();
        if (taskDisplayArea != null) goto L5;
    L7:
        return false;
    L5:
        if (taskDisplayArea.isRemoved() == true) goto L7;
        return true;
    }

    TaskFragment getRootTaskFragment() {
        WindowContainer parent = getParent();
        if (parent != null) goto L5;
        return this;
    L5:
        TaskFragment parentTaskFragment = parent.asTaskFragment();
        if (parentTaskFragment != null) goto L9;
        return this;
    L9:
        return parentTaskFragment.getRootTaskFragment();
    }

    Task getRootTask() {
        return getRootTaskFragment().asTask();
    }

    @Override // com.android.server.wm.WindowContainer
    TaskFragment asTaskFragment() {
        return this;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isEmbedded() {
        return this.mIsEmbedded;
    }

    int isAllowedToEmbedActivity(ActivityRecord a) {
        return isAllowedToEmbedActivity(a, this.mTaskFragmentOrganizerUid);
    }

    int isAllowedToEmbedActivity(ActivityRecord a, int uid) {
        if (isAllowedToEmbedActivityInUntrustedMode(a) == true) goto L9;
        if (isAllowedToEmbedActivityInTrustedMode(a, uid) == true) goto L9;
        return 1;
    L9:
        if (smallerThanMinDimension(a) == false) goto L12;
        return 2;
    L12:
        return 0;
    }

    boolean smallerThanMinDimension(ActivityRecord activity) {
        Rect taskFragBounds = getBounds();
        Task task = getTask();
        if (task != null) goto L5;
    L16:
        return false;
    L5:
        if (taskFragBounds.equals(task.getBounds()) == true) goto L16;
        Point minDimensions = activity.getMinDimensions();
        if (minDimensions != null) goto L10;
        return false;
    L10:
        int minWidth = minDimensions.x;
        int minHeight = minDimensions.y;
        if (taskFragBounds.width() >= minWidth) goto L13;
    L14:
        return true;
    L13:
        if (taskFragBounds.height() < minHeight) goto L14;
        return false;
    }

    boolean isAllowedToEmbedActivityInUntrustedMode(ActivityRecord a) {
        WindowContainer parent = getParent();
        if (parent != null) goto L5;
    L14:
        return false;
    L5:
        if (parent.getBounds().contains(getBounds()) == false) goto L14;
        if (hasEmbedAnyAppInUntrustedModePermission(this.mTaskFragmentOrganizerUid) == false) goto L11;
        return true;
    L11:
        if ((a.info.flags & 268435456) == 268435456) goto L13;
        return false;
    L13:
        return true;
    }

    boolean isAllowedToEmbedActivityInTrustedMode(ActivityRecord a) {
        return isAllowedToEmbedActivityInTrustedMode(a, this.mTaskFragmentOrganizerUid);
    }

    boolean isAllowedToEmbedActivityInTrustedMode(ActivityRecord a, int uid) {
        if (isFullyTrustedEmbedding(a, uid) == false) goto L5;
        return true;
    L5:
        AndroidPackage hostPackage = this.mAtmService.getPackageManagerInternalLocked().getPackage(uid);
        if (hostPackage != null) goto L8;
    L10:
        return false;
    L8:
        if (isAllowedToEmbedActivityInTrustedModeByHostPackage(a, hostPackage) == false) goto L10;
        return true;
    }

    boolean isAllowedToEmbedActivityInTrustedModeByHostPackage(ActivityRecord a, AndroidPackage hostPackage) {
        Set<String> knownActivityEmbeddingCerts = a.info.getKnownActivityEmbeddingCerts();
        if (knownActivityEmbeddingCerts.isEmpty() == false) goto L6;
        knownActivityEmbeddingCerts = a.info.applicationInfo.getKnownActivityEmbeddingCerts();
    L6:
        return hostPackage.getSigningDetails().hasAncestorOrSelfWithDigest(knownActivityEmbeddingCerts);
    }

    private static boolean isFullyTrustedEmbedding(ActivityRecord a, int uid) {
        if (UserHandle.getAppId(uid) != 1000) goto L5;
    L10:
        return true;
    L5:
        if (a.isUid(uid) == true) goto L10;
        if (hasManageTaskPermission(uid) == true) goto L10;
        return false;
    }

    private static boolean hasManageTaskPermission(int uid) {
        if (ActivityTaskManagerService.checkPermission("android.permission.MANAGE_ACTIVITY_TASKS", -1, uid) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean hasEmbedAnyAppInUntrustedModePermission(int uid) {
        return false;
    }

    private static /* synthetic */ boolean lambda$isFullyTrustedEmbedding$0(int uid, ActivityRecord r) {
        return !isFullyTrustedEmbedding(r, uid);
    }

    boolean isFullyTrustedEmbedding(final int uid) {
        return !forAllActivities(new TaskFragment$$ExternalSyntheticLambda12(uid));
    }

    private /* synthetic */ boolean lambda$isAllowedToBeEmbeddedInTrustedMode$1(ActivityRecord r) {
        return !isAllowedToEmbedActivityInTrustedMode(r);
    }

    boolean isAllowedToBeEmbeddedInTrustedMode() {
        return !forAllActivities(new TaskFragment$$ExternalSyntheticLambda10(this));
    }

    void setCanAffectSystemUiFlags(boolean canAffectSystemUiFlags) {
        this.mCanAffectSystemUiFlags = canAffectSystemUiFlags;
    }

    boolean canAffectSystemUiFlags() {
        if (Features.FEAT_QUICK_WIN == false) goto L8;
        if (inFreeformWindowingMode() == false) goto L8;
        return false;
    L8:
        if (this.mCanAffectSystemUiFlags == true) goto L11;
        return false;
    L11:
        if (getParent() == null) goto L13;
        TaskFragment parentTaskFragment = getParent().asTaskFragment();
    L14:
        if (parentTaskFragment != null) goto L16;
    L17:
        return true;
    L16:
        if (parentTaskFragment.canAffectSystemUiFlags() == true) goto L17;
        return false;
    L13:
        parentTaskFragment = null;
        goto L14
    }

    TaskFragment getOrganizedTaskFragment() {
        if (this.mTaskFragmentOrganizer == null) goto L6;
        return this;
    L6:
        if (getParent() == null) goto L8;
        TaskFragment parentTaskFragment = getParent().asTaskFragment();
    L9:
        if (parentTaskFragment != null) goto L11;
        return null;
    L11:
        return parentTaskFragment.getOrganizedTaskFragment();
    L8:
        parentTaskFragment = null;
        goto L9
    }

    boolean hasDirectChildActivities() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (((WindowContainer) this.mChildren.get(i)).asActivityRecord() != null) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    void cleanUpActivityReferences(ActivityRecord r) {
        if (this.mPausingActivity == null) goto L8;
        if (this.mPausingActivity != r) goto L8;
        this.mPausingActivity = null;
    L8:
        if (this.mResumedActivity != null) goto L10;
    L12:
        r.removeTimeouts();
        return;
    L10:
        if (this.mResumedActivity != r) goto L12;
        setResumedActivity(null, "cleanUpActivityReferences");
        goto L12
    }

    protected boolean isForceHidden() {
        if (this.mForceHiddenFlags == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean setForceHidden(int flags, boolean set) {
        int newFlags = this.mForceHiddenFlags;
        if (set == false) goto L5;
        int newFlags2 = newFlags | flags;
    L7:
        if (this.mForceHiddenFlags != newFlags2) goto L10;
        return false;
    L10:
        this.mForceHiddenFlags = newFlags2;
        return true;
    L5:
        newFlags2 = newFlags & (~flags);
        goto L7
    }

    boolean isForceTranslucent() {
        return this.mForceTranslucent;
    }

    boolean setForceTranslucent(boolean set) {
        if (this.mForceTranslucent != set) goto L6;
        return false;
    L6:
        this.mForceTranslucent = set;
        return true;
    }

    boolean isLeafTaskFragment() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L10;
        if (((WindowContainer) this.mChildren.get(i)).asTaskFragment() != null) goto L6;
        i = i - 1;
        goto L3
    L6:
        return false;
    L10:
        return true;
    }

    void onActivityStateChanged(ActivityRecord record, ActivityRecord.State state, String reason) {
        if (record != this.mResumedActivity) goto L8;
        if (state == ActivityRecord.State.RESUMED) goto L8;
        setResumedActivity(null, reason + " - onActivityStateChanged");
    L8:
        if (state == ActivityRecord.State.RESUMED) goto L10;
    L13:
        WindowProcessController hostProcess = getOrganizerProcessIfDifferent(record);
        if (hostProcess == null) goto L17;
        this.mTaskSupervisor.onProcessActivityStateChanged(hostProcess, false);
        hostProcess.updateProcessInfo(false, true, true, false);
        return;
    L17:
        return;
    L10:
        if (ActivityTaskManagerDebugConfig.DEBUG_ROOT_TASK == false) goto L12;
        Slog.v("ActivityTaskManager", "set resumed activity to:" + record + " reason:" + reason);
    L12:
        setResumedActivity(record, reason + " - onActivityStateChanged");
        this.mTaskSupervisor.mRecentTasks.add(record.getTask());
        goto L13
    }

    boolean handleAppDied(WindowProcessController app) {
        boolean isPausingDied = false;
        if (this.mPausingActivity == null) goto L8;
        if (this.mPausingActivity.app != app) goto L8;
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "App died while pausing: %s", new Object[]{this.mPausingActivity});
        this.mPausingActivity = null;
        isPausingDied = true;
    L8:
        if (this.mLastPausedActivity != null) goto L10;
    L12:
        return isPausingDied;
    L10:
        if (this.mLastPausedActivity.app != app) goto L12;
        this.mLastPausedActivity = null;
        goto L12
    }

    void awakeFromSleeping() {
        if (this.mPausingActivity == null) goto L6;
        Slog.d("ActivityTaskManager", "awakeFromSleeping: previously pausing activity didn't pause");
        this.mPausingActivity.activityPaused(true);
        return;
    }

    boolean sleepIfPossible(boolean shuttingDown) {
        boolean shouldSleep = true;
        if (this.mResumedActivity == null) goto L11;
        if (shuttingDown == false) goto L6;
    L8:
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "Sleep needs to pause %s", new Object[]{this.mResumedActivity});
        startPausing(true, null, "sleep");
    L9:
        shouldSleep = false;
    L13:
        if (shuttingDown == false) goto L15;
    L17:
        if (shouldSleep == false) goto L19;
        updateActivityVisibilities(null, true);
    L19:
        return shouldSleep;
    L15:
        if (containsStoppingActivity() == false) goto L17;
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "Sleep still need to stop %d activities", new Object[]{Integer.valueOf(this.mTaskSupervisor.mStoppingActivities.size())});
        this.mTaskSupervisor.scheduleIdle();
        shouldSleep = false;
        goto L17
    L6:
        if (this.mResumedActivity.canTurnScreenOn() == false) goto L8;
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "Waiting for screen on due to %s", new Object[]{this.mResumedActivity});
        goto L9
    L11:
        if (this.mPausingActivity == null) goto L13;
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "Sleep still waiting to pause %s", new Object[]{this.mPausingActivity});
        shouldSleep = false;
        goto L13
    }

    private boolean containsStoppingActivity() {
        int i = this.mTaskSupervisor.mStoppingActivities.size() - 1;
    L3:
        if (i < 0) goto L8;
        ActivityRecord r = this.mTaskSupervisor.mStoppingActivities.get(i);
        if (r.getTaskFragment() == this) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    boolean isTranslucent(ActivityRecord starting) {
        if (isAttached() == true) goto L5;
    L11:
        return true;
    L5:
        if (isForceHidden() == true) goto L11;
        if (isForceTranslucent() == true) goto L11;
        return !this.mTaskSupervisor.mOpaqueContainerHelper.isOpaque(this, starting, true, true);
    }

    boolean isTranslucentForTransition() {
        if (isAttached() == true) goto L5;
    L11:
        return true;
    L5:
        if (isForceHidden() == true) goto L11;
        if (isForceTranslucent() == true) goto L11;
        return !this.mTaskSupervisor.mOpaqueContainerHelper.isOpaque(this);
    }

    boolean isTranslucentAndVisible() {
        if (isAttached() == true) goto L5;
    L11:
        return true;
    L5:
        if (isForceHidden() == true) goto L11;
        if (isForceTranslucent() == true) goto L11;
        return !this.mTaskSupervisor.mOpaqueContainerHelper.isOpaque(this, null, false, true);
    }

    @Override // com.android.server.wm.WindowContainer
    ActivityRecord getTopNonFinishingActivity() {
        return getTopNonFinishingActivity(true, true);
    }

    ActivityRecord getTopNonFinishingActivity(boolean includeOverlays, boolean includeLaunchedFromBubble) {
        if (includeOverlays == false) goto L8;
        if (includeLaunchedFromBubble == false) goto L7;
        return getActivity(new TaskFragment$$ExternalSyntheticLambda5());
    L7:
        return getActivity(new TaskFragment$$ExternalSyntheticLambda6());
    L8:
        if (includeLaunchedFromBubble == false) goto L12;
        return getActivity(new TaskFragment$$ExternalSyntheticLambda7());
    L12:
        return getActivity(new TaskFragment$$ExternalSyntheticLambda8());
    }

    private static /* synthetic */ boolean lambda$getTopNonFinishingActivity$2(ActivityRecord r) {
        return !r.finishing;
    }

    private static /* synthetic */ boolean lambda$getTopNonFinishingActivity$3(ActivityRecord r) {
        if (r.finishing == false) goto L5;
    L7:
        return false;
    L5:
        if (r.getLaunchedFromBubble() == true) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$getTopNonFinishingActivity$4(ActivityRecord r) {
        if (r.finishing == false) goto L5;
    L7:
        return false;
    L5:
        if (r.isTaskOverlay() == true) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$getTopNonFinishingActivity$5(ActivityRecord r) {
        if (r.finishing == false) goto L5;
    L9:
        return false;
    L5:
        if (r.isTaskOverlay() == true) goto L9;
        if (r.getLaunchedFromBubble() == true) goto L9;
        return true;
    }

    ActivityRecord topRunningActivity() {
        return topRunningActivity(false);
    }

    ActivityRecord topRunningActivity(boolean focusableOnly) {
        if (focusableOnly == false) goto L6;
        return getActivity(new TaskFragment$$ExternalSyntheticLambda13());
    L6:
        return getActivity(new ActivityStarter$$ExternalSyntheticLambda0());
    }

    private static /* synthetic */ boolean lambda$topRunningActivity$6(ActivityRecord r) {
        if (r.canBeTopRunning() == true) goto L5;
    L7:
        return false;
    L5:
        if (r.isFocusable() == false) goto L7;
        return true;
    }

    int getNonFinishingActivityCount() {
        final int[] runningActivityCount = new int[1];
        forAllActivities(new TaskFragment$$ExternalSyntheticLambda15(runningActivityCount));
        return runningActivityCount[0];
    }

    private static /* synthetic */ void lambda$getNonFinishingActivityCount$7(int[] runningActivityCount, ActivityRecord a) {
        if (a.finishing == true) goto L6;
        runningActivityCount[0] = runningActivityCount[0] + 1;
        return;
    }

    boolean hasNonFinishingDirectActivity() {
        int i = getChildCount() - 1;
    L3:
        if (i < 0) goto L10;
        ActivityRecord activity = getChildAt(i).asActivityRecord();
        if (activity == null) goto L9;
        if (activity.finishing == true) goto L9;
        return true;
    L9:
        i = i - 1;
        goto L3
    L10:
        return false;
    }

    boolean isTopActivityFocusable() {
        ActivityRecord r = topRunningActivity();
        if (r == null) goto L6;
        return r.isFocusable();
    L6:
        if (isFocusable() == true) goto L8;
    L10:
        return false;
    L8:
        if (getWindowConfiguration().canReceiveKeys() == false) goto L10;
        return true;
    }

    int getVisibility(final ActivityRecord starting) {
        int otherWindowingMode = 2;
        if (isAttached() == true) goto L5;
        return 2;
    L5:
        if (isForceHidden() == false) goto L8;
        return 2;
    L8:
        if (isTopActivityLaunchedBehind() == false) goto L10;
        return 0;
    L10:
        WindowContainer<?> parent = getParent();
        Task thisTask = asTask();
        if (thisTask != null) goto L13;
    L17:
        int splitReplaceVisibility = this.mExt.getSplitReplaceTaskFragmentVisibility(thisTask, parent);
        if (splitReplaceVisibility == (-1)) goto L20;
        return splitReplaceVisibility;
    L20:
        boolean gotTranslucentFullscreen = false;
        boolean gotTranslucentAdjacent = false;
        boolean shouldBeVisible = true;
        int r11 = 1;
        if (parent.asTaskFragment() == null) goto L27;
        int parentVisibility = parent.asTaskFragment().getVisibility(starting);
        if (parentVisibility != 2) goto L25;
        return 2;
    L25:
        if (parentVisibility != 1) goto L27;
        gotTranslucentFullscreen = true;
    L27:
        final List<TaskFragment> adjacentTaskFragments = new ArrayList();
        int i = parent.getChildCount() - 1;
    L28:
        if (i < 0) goto L103;
        WindowContainer other = parent.getChildAt(i);
        if (other == null) goto L100;
        boolean hasRunningActivities = hasRunningActivity(other);
        if (other == this) goto L35;
        int r16 = otherWindowingMode;
        if (hasRunningActivities == false) goto L100;
        int otherWindowingMode2 = other.getWindowingMode();
        if (otherWindowingMode2 == 1) goto L98;
        if (otherWindowingMode2 != r16) goto L76;
    L78:
        TaskFragment otherTaskFrag = other.asTaskFragment();
        if (otherTaskFrag == null) goto L100;
        if (otherTaskFrag.hasAdjacentTaskFragment() == false) goto L100;
        boolean hasTraversedAdj = otherTaskFrag.forOtherAdjacentTaskFragments(new TaskFragment$$ExternalSyntheticLambda1(adjacentTaskFragments));
        if (hasTraversedAdj == true) goto L85;
        adjacentTaskFragments.add(otherTaskFrag);
        goto L100
    L85:
        if (isBehindTransparentTaskFragment(otherTaskFrag, starting) == false) goto L87;
    L90:
        boolean isTranslucent = true;
    L92:
        if (isTranslucent == false) goto L94;
        gotTranslucentFullscreen = true;
        gotTranslucentAdjacent = true;
        goto L100
    L94:
        return 2;
    L87:
        if (otherTaskFrag.forOtherAdjacentTaskFragments(new TaskFragment$$ExternalSyntheticLambda2(this, starting)) == true) goto L90;
        isTranslucent = false;
        goto L92
    L76:
        if (other.matchParentBounds() == false) goto L78;
    L98:
        if (isTranslucent(other, starting) == false) goto L101;
        gotTranslucentFullscreen = true;
        goto L100
    L101:
        return 2;
    L35:
        if (adjacentTaskFragments.isEmpty() == true) goto L54;
        if (gotTranslucentAdjacent == true) goto L54;
        this.mTmpRect.set(getBounds());
        int j = adjacentTaskFragments.size() - r11;
    L38:
        if (j < 0) goto L53;
        TaskFragment taskFragment = adjacentTaskFragments.get(j);
        if (taskFragment.isAdjacentTo(this) == false) goto L42;
        int r17 = otherWindowingMode;
    L52:
        j = j - 1;
        otherWindowingMode = r17;
        goto L38
    L42:
        r17 = otherWindowingMode;
        if (this.mTmpRect.intersect(taskFragment.getBounds()) == false) goto L45;
    L48:
        boolean isOccluding = true;
    L50:
        if (isOccluding == false) goto L52;
        return r17;
    L45:
        if (taskFragment.forOtherAdjacentTaskFragments(new TaskFragment$$ExternalSyntheticLambda0(this)) == true) goto L48;
        isOccluding = false;
        goto L50
    L53:
        int r18 = otherWindowingMode;
    L56:
        if (hasRunningActivities == true) goto L66;
        if (starting == null) goto L61;
        if (starting.isDescendantOf(this) == true) goto L66;
    L61:
        if (isActivityTypeHome() == true) goto L63;
    L65:
        boolean r3 = false;
    L67:
        shouldBeVisible = r3;
    L104:
        if (shouldBeVisible == true) goto L106;
        return r18;
    L106:
        if (gotTranslucentFullscreen == false) goto L108;
        return 1;
    L108:
        return 0;
    L63:
        if (isEmbedded() == true) goto L65;
    L66:
        r3 = true;
    L54:
        r18 = otherWindowingMode;
    L100:
        i = i - 1;
        otherWindowingMode = 2;
        r11 = 1;
        goto L28
    L103:
        r18 = otherWindowingMode;
        goto L104
    L13:
        if (parent.asTask() != null) goto L17;
        if (this.mTransitionController.isTransientVisible(thisTask) == false) goto L17;
        return 0;
    }

    private /* synthetic */ boolean lambda$getVisibility$8(TaskFragment adjacentTf) {
        return this.mTmpRect.intersect(adjacentTf.getBounds());
    }

    private /* synthetic */ boolean lambda$getVisibility$9(ActivityRecord starting, TaskFragment tf) {
        return isBehindTransparentTaskFragment(tf, starting);
    }

    private boolean isBehindTransparentTaskFragment(TaskFragment otherTf, ActivityRecord starting) {
        if (otherTf.isTranslucent(starting) == true) goto L5;
    L7:
        return false;
    L5:
        if (getBounds().intersect(otherTf.getBounds()) == false) goto L7;
        return true;
    }

    private static boolean hasRunningActivity(WindowContainer wc) {
        if (wc.asTaskFragment() == null) goto L9;
        if (wc.asTaskFragment().topRunningActivity() != null) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (wc.asActivityRecord() != null) goto L11;
        return false;
    L11:
        if (wc.asActivityRecord().finishing == false) goto L13;
        return false;
    L13:
        return true;
    }

    private static boolean isTranslucent(WindowContainer wc, ActivityRecord starting) {
        if (wc.asTaskFragment() == null) goto L7;
        return wc.asTaskFragment().isTranslucent(starting);
    L7:
        if (wc.asActivityRecord() != null) goto L9;
        return false;
    L9:
        return !wc.asActivityRecord().occludesParent();
    }

    private boolean isTopActivityLaunchedBehind() {
        ActivityRecord top = topRunningActivity();
        if (top != null) goto L5;
    L7:
        return false;
    L5:
        if (top.mLaunchTaskBehind == false) goto L7;
        return true;
    }

    final void updateActivityVisibilities(ActivityRecord starting, boolean notifyClients) {
        this.mTaskSupervisor.beginActivityVisibilityUpdate();
        this.mEnsureActivitiesVisibleHelper.process(starting, notifyClients);     // Catch: Throwable -> L6
        this.mTaskSupervisor.endActivityVisibilityUpdate();
        return;
    L6:
        th = move-exception;
        this.mTaskSupervisor.endActivityVisibilityUpdate();
        throw th;
    }

    final boolean resumeTopActivity(ActivityRecord prev, ActivityOptions options, boolean skipPause) {
        if (getTask().getExt().deferResumeTopActivity() == false) goto L6;
        Slog.i("ActivityTaskManager", "Skipping resume of top activity, prev " + prev + ", taskId: " + getTaskId());
        return false;
    L6:
        ActivityRecord next = topRunningActivity(true);
        if (next != null) goto L9;
        return false;
    L9:
        if (next.canResumeByCompat() == true) goto L12;
        return false;
    L12:
        if (getTask().getExt().deferKeyguardLockedResumeTopActivity(prev, next, options) == false) goto L14;
        return false;
    L14:
        next.delayedResume = false;
        if (skipPause == false) goto L17;
    L20:
        TaskDisplayArea taskDisplayArea = getDisplayArea();
        if (this.mResumedActivity != next) goto L51;
        if (next.isState(ActivityRecord.State.RESUMED) == false) goto L51;
        if (taskDisplayArea.allResumedActivitiesComplete() == false) goto L51;
        taskDisplayArea.ensureActivitiesVisible(null, true);
        executeAppTransition(options);
        if (taskDisplayArea.inMultiWindowMode() == true) goto L29;
    L35:
        ProtoLog.d(WmProtoLogGroups.WM_DEBUG_STATES, "resumeTopActivity: Top activity resumed %s", new Object[]{next});
        if (Constants.ENABLE_GAME_ASSIST == false) goto L49;
        ActivityRecord r = this.mResumedActivity;
        if (r == null) goto L49;
        if (r.hasProcess() == false) goto L49;
        if (r.occludesParent() == false) goto L44;
    L47:
        GameActivityStateEventDispatcher.getInstance().notifyGameActivityResumed(r.getDisplayId(), r.info, r.getRootTaskId(), r.app.getPid(), this.mResumedActivity.getTask().getWindowingMode(), r.getActivityType(), r, r.mActivityComponent, r.mUserId, r.getTask().getTaskLabelHashcode());
        goto L49
    L44:
        if (((IGameAssistSerivce) LocalServices.getService(IGameAssistSerivce.class)).isGameSpaceListApp(r.packageName) == true) goto L47;
        Slog.d("ActivityTaskManager", "resumeTopActivity transparent acitivity=" + r);
    L49:
        return false;
    L29:
        if (taskDisplayArea.mDisplayContent == null) goto L35;
        ActivityRecord focusedApp = taskDisplayArea.mDisplayContent.mFocusedApp;
        if (focusedApp != null) goto L33;
    L34:
        taskDisplayArea.mDisplayContent.setFocusedApp(next);
        goto L35
    L33:
        if (focusedApp.getTask() == next.getTask()) goto L35;
    L51:
        if (this.mLastPausedActivity != next) goto L63;
        if (shouldSleepOrShutDownActivities() == false) goto L63;
        if (next.hasProcess() == true) goto L57;
    L60:
        executeAppTransition(options);
        ProtoLog.d(WmProtoLogGroups.WM_DEBUG_STATES, "resumeTopActivity: Going to sleep and all paused", new Object[0]);
        return false;
    L57:
        if (next.app.hasThread() == true) goto L60;
        next.app.getWPCSmtEx().unFreezeProcIfNeedLocked(new ResumeActivityEvent(next.app));
        Slog.i("AMS.Freeze", "unFreezeProcIfNeedLocked proc:" + next.app + " for ResumeActivityEvent, at resumeTopActivity A");
        return false;
    L63:
        if (this.mAtmService.mAmInternal.hasStartedUserState(next.mUserId) == true) goto L67;
        Slog.w("ActivityTaskManager", "Skipping resume of top activity " + next + ": user " + next.mUserId + " is stopped");
        return false;
    L67:
        if (Constants.ENABLE_GAME_ASSIST == false) goto L80;
        ActivityRecord r2 = this.mResumedActivity;
        if (r2 == null) goto L80;
        if (r2.hasProcess() == false) goto L80;
        if (r2.occludesParent() == false) goto L75;
    L78:
        GameActivityStateEventDispatcher.getInstance().notifyGameActivityResumed(r2.getDisplayId(), r2.info, r2.getRootTaskId(), r2.app.getPid(), this.mResumedActivity.getTask().getWindowingMode(), r2.getActivityType(), r2, r2.mActivityComponent, r2.mUserId, r2.getTask().getTaskLabelHashcode());
        goto L80
    L75:
        if (((IGameAssistSerivce) LocalServices.getService(IGameAssistSerivce.class)).isGameSpaceListApp(r2.packageName) == true) goto L78;
        Slog.d("ActivityTaskManager", "resumeTopActivity mForcePaused transparent acitivity=" + r2);
    L80:
        this.mTaskSupervisor.mStoppingActivities.remove(next);
        if (next.translucentWindowLaunch == true) goto L84;
        next.launching = true;
    L84:
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L87;
        Slog.v("ActivityTaskManager", "Resuming " + next);
    L87:
        if (mActivityTrigger == null) goto L89;
        mActivityTrigger.activityResumeTrigger(next.intent, next.info, next.info.applicationInfo, next.occludesParent());
    L89:
        this.mTaskSupervisor.setLaunchSource(next.info.applicationInfo.uid);
        Task lastFocusedRootTask = taskDisplayArea.getLastFocusedRootTask();
        if (lastFocusedRootTask != null) goto L92;
    L94:
        ActivityRecord lastResumed = null;
    L95:
        if (skipPause == false) goto L97;
    L99:
        boolean pausing = false;
    L101:
        if (this.mResumedActivity == null) goto L103;
        ProtoLog.d(WmProtoLogGroups.WM_DEBUG_STATES, "resumeTopActivity: Pausing %s", new Object[]{this.mResumedActivity});
        int r7 = 0;
        boolean pausing2 = pausing | startPausing(this.mTaskSupervisor.mUserLeaving, false, next, "resumeTopActivity");
    L104:
        if (pausing2 == false) goto L130;
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "resumeTopActivity: Skip resume: need to start pausing", new Object[r7]);
        if (next.getActivityRecordSmtEx().optEx.unFreezeProcForResumeIfNeed() == false) goto L110;
        Slog.i("AMS.Freeze", "unFreezeProcForResumeIfNeed proc:" + next + ", at resumeTopActivity B");
        return r7;
    L110:
        if (next.attachedToProcess() == false) goto L113;
        next.app.updateProcessInfo(false, true, false, false);
    L125:
        if (lastResumed == null) goto L127;
        lastResumed.setWillCloseOrEnterPip(true);
        return true;
    L127:
        return true;
    L113:
        if (next.isProcessRunning() == true) goto L125;
        if (this.mAtmService.getSmtEx().isPrefetchProcess(next.processName, next.getUid()) == true) goto L125;
        if (this != taskDisplayArea.getFocusedRootTask()) goto L119;
        boolean isTop = true;
    L120:
        ActivityTaskManagerService r4 = this.mAtmService;
        if (isTop == false) goto L123;
        String r5 = HostingRecord.HOSTING_TYPE_NEXT_TOP_ACTIVITY;
    L124:
        r4.startProcessAsync(next, false, isTop, r5);
        goto L125
    L123:
        r5 = HostingRecord.HOSTING_TYPE_NEXT_ACTIVITY;
        goto L124
    L119:
        isTop = false;
        goto L120
    L130:
        if (this.mResumedActivity != next) goto L138;
        if (next.isState(ActivityRecord.State.RESUMED) == false) goto L138;
        if (taskDisplayArea.allResumedActivitiesComplete() == false) goto L138;
        executeAppTransition(options);
        ProtoLog.d(WmProtoLogGroups.WM_DEBUG_STATES, "resumeTopActivity: Top activity resumed (dontWaitForPause) %s", new Object[]{next});
        return true;
    L138:
        if (shouldSleepActivities() == false) goto L140;
        this.mTaskSupervisor.finishNoHistoryActivitiesIfNeeded(next);
    L140:
        if (prev == null) goto L363;
        if (prev == next) goto L363;
        if (next.nowVisible == false) goto L363;
        if (prev.finishing == false) goto L150;
        prev.setVisibility(false);
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L363;
        Slog.v("ActivityTaskManager", "Not waiting for visible to hide: " + prev + ", nowVisible=" + next.nowVisible);
        goto L363
    L150:
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L363;
        Slog.v("ActivityTaskManager", "Previous already visible but still waiting to hide: " + prev + ", nowVisible=" + next.nowVisible);
    L363:
        this.mTaskSupervisor.getActivityMetricsLogger().notifyBeforePackageUnstopped(next.packageName);     // Catch: IllegalArgumentException -> L158
        this.mAtmService.getPackageManagerInternalLocked().notifyComponentUsed(next.packageName, next.mUserId, next.packageName, next.toString());     // Catch: IllegalArgumentException -> L156
    L161:
        boolean anim = true;
        DisplayContent dc = taskDisplayArea.mDisplayContent;
        if (this.mPerf != null) goto L164;
        this.mPerf = new BoostFramework();
    L164:
        boolean isBoostLimit = false;
        if (dc != null) goto L167;
    L171:
        if (prev != null) goto L173;
        boolean anim2 = true;
        dc = dc;
        if (this.mTaskSupervisor.mNoAnimActivities.contains(next) == true) goto L199;
    L202:
        if (anim2 == false) goto L204;
        next.applyOptionsAnimation();
    L205:
        this.mTaskSupervisor.mNoAnimActivities.clear();
        if (next.hasProcess() == false) goto L212;
        if (next.app.hasThread() == true) goto L212;
        next.app.getWPCSmtEx().unFreezeProcIfNeedLocked(new ResumeActivityEvent(next.app));
        Slog.i("AMS.Freeze", "unFreezeProcIfNeedLocked proc:" + next.app + " for ResumeActivityEvent, at resumeTopActivity C");
        return true;
    L212:
        if (next.attachedToProcess() == false) goto L346;
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L217;
        Slog.v("ActivityTaskManager", "Resume running: " + next + " stopped=" + next.mAppStopped + " visibleRequested=" + next.isVisibleRequested());
    L217:
        if (inMultiWindowMode() == false) goto L219;
    L224:
        boolean r0 = true;
    L225:
        boolean lastActivityTranslucent = r0;
        if (next.isVisibleRequested() == true) goto L228;
    L230:
        next.app.addToPendingTop();
        next.setVisibility(true);
    L231:
        if (lastFocusedRootTask != null) goto L233;
        ActivityRecord r9 = null;
    L234:
        ActivityRecord lastResumedActivity = r9;
        ActivityRecord.State lastState = next.getState();
        this.mAtmService.updateCpuStats();
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "Moving to RESUMED: %s (in existing)", new Object[]{next});
        next.setState(ActivityRecord.State.RESUMED, "resumeTopActivity");
        if (shouldBeVisible(next) == false) goto L240;
        int originalRelaunchingCount = next.mPendingRelaunchCount;
        this.mRootWindowContainer.ensureVisibilityAndConfig(next, this.mDisplayContent, false);
        if (next.mPendingRelaunchCount <= originalRelaunchingCount) goto L240;
        next.completeResumeLocked();
        return true;
    L240:
        IApplicationThread appThread = next.app.getThread();
        ArrayList<ResultInfo> a = next.results;
        if (a == null) goto L257;
        int size = a.size();
        if (next.finishing == true) goto L257;
        if (size <= 0) goto L257;
        if (ActivityTaskManagerDebugConfig.DEBUG_RESULTS == false) goto L365;
        Slog.v("ActivityTaskManager", "Delivering results to " + next + ": " + a);
    L365:
        boolean isSuccessful = this.mAtmService.getLifecycleManager().scheduleTransactionItem(appThread, new ActivityResultItem(next.token, a));     // Catch: RemoteException -> L251
    L253:
        if (isSuccessful == true) goto L257;
        onResumeTopActivityRemoteFailure(lastState, next, lastResumedActivity, lastFocusedRootTask);
        return true;
    L252:
        isSuccessful = false;
    L257:
        if (next.newIntents != null) goto L359;
    L266:
        next.notifyAppResumed();
        if (this.mAtmService != null) goto L269;
    L271:
        EventLogTags.writeWmResumeActivity(next.mUserId, System.identityHashCode(next), next.getTask().mTaskId, next.shortComponentName);
        ZTEActivityEventsInternal zteActivityEventsInternal = (ZTEActivityEventsInternal) LocalServices.getService(ZTEActivityEventsInternal.class);
        if (zteActivityEventsInternal == null) goto L274;
        ActivityRecord.State lastState2 = lastState;
        zteActivityEventsInternal.notifyActivityEvent(1, next.getDisplayId(), next.mUserId, next, next.getRootTaskId());
    L275:
        this.mAtmService.getAppWarningsLocked().onResumeActivity(next);
        int topProcessState = this.mAtmService.mTopProcessState;
        next.app.setPendingUiCleanAndForceProcessStateUpTo(topProcessState);
        next.abortAndClearOptionsAnimation();
        ClientTransactionItem r1 = new ResumeActivityItem(next.token, topProcessState, dc.isNextTransitionForward(), next.shouldSendCompatFakeFocus());
        next.app.getWPCSmtEx().bringProcessToDefaultLocked();
        if (StabTrace.isEnable() == false) goto L278;
        long beginTime = Process.getCpuClocks();
        long beginTime2 = beginTime;
    L357:
        boolean isSuccessful2 = this.mAtmService.getLifecycleManager().scheduleTransactionItem(appThread, r1);     // Catch: RemoteException -> L283
        if (StabTrace.isEnable() == false) goto L285;
        StabTrace.traceInfo(16384, "resumeActivityItem:", beginTime2, Process.getCpuClocks());     // Catch: RemoteException -> L283
    L285:
        boolean isSuccessful3 = isSuccessful2;
    L288:
        if (MindSyncManager.ZTE_FEATURE_MINDSYNC == false) goto L336;
        if (next.info != null) goto L292;
    L294:
        int uid = -1;
    L296:
        if (TextUtils.isEmpty(next.packageName) == true) goto L298;
        String pkgName = next.packageName;
        String pkgName2 = pkgName;
    L300:
        if (next.mActivityComponent == null) goto L302;
        String nextClass = next.mActivityComponent.getClassName();
        String nextClass2 = nextClass;
    L304:
        if (next.app == null) goto L306;
        int pid = next.app.getPid();
        int pid2 = pid;
    L308:
        if (TextUtils.isEmpty(next.processName) == true) goto L310;
        String processName = next.processName;
    L311:
        int windowingMode = next.getWindowingMode();
        if (uid != (-1)) goto L314;
    L334:
        Slog.w("ActivityTaskManager", "Skip noteAppForeground in TaskFragment: core params invalid, uid=" + uid + ", pkg=" + pkgName2 + ", pid=" + pid2);
        goto L336
    L314:
        if (TextUtils.isEmpty(pkgName2) == true) goto L334;
        if (pid2 == (-1)) goto L334;
        Slog.i("ActivityTaskManager", "call MindSyncManager.Trigger.noteAppForeground() from TaskFragment, next=" + next);     // Catch: Exception -> L325 NullPointerException -> L327
    L369:
        MindSyncManager.Trigger.noteAppForeground(uid, pkgName2, nextClass2, pid2, processName, windowingMode, "", SystemClock.elapsedRealtime(), false, next.intent, "", nextClass2, false);     // Catch: Exception -> L321 NullPointerException -> L323
    L323:
        e = e;
    L333:
        Slog.e("ActivityTaskManager", "noteAppForeground NPE caught in TaskFragment: ", e);
    L321:
        e = e;
    L329:
        Slog.e("ActivityTaskManager", "noteAppForeground exception caught in TaskFragment: ", e);
    L327:
        e = e;
    L325:
        e = e;
    L331:
        e = e;
        goto L333
    L310:
        processName = "";
        goto L311
    L306:
        pid2 = -1;
        goto L308
    L302:
        nextClass2 = "";
        goto L304
    L298:
        pkgName2 = "";
        goto L300
    L292:
        if (next.info.applicationInfo == null) goto L294;
        uid = next.info.applicationInfo.uid;
    L336:
        if (isSuccessful3 == false) goto L338;
        ProtoLog.d(WmProtoLogGroups.WM_DEBUG_STATES, "resumeTopActivity: Resumed %s", new Object[]{next});
        next.completeResumeLocked();
        return true;
    L338:
        if (this.mAtmService != null) goto L340;
    L342:
        onResumeTopActivityRemoteFailure(lastState2, next, lastResumedActivity, lastFocusedRootTask);
        return true;
    L340:
        if (this.mAtmService.getSmtEx() == null) goto L342;
        this.mAtmService.getSmtEx().updateSetResumedUid(next.getUid(), false);
    L286:
        isSuccessful3 = false;
        goto L288
    L278:
        beginTime2 = 0;
        goto L357
    L274:
        lastState2 = lastState;
        goto L275
    L269:
        if (this.mAtmService.getSmtEx() == null) goto L271;
        this.mAtmService.getSmtEx().updateSetResumedUid(next.getUid(), true);
        goto L271
    L359:
        boolean isSuccessful4 = this.mAtmService.getLifecycleManager().scheduleTransactionItem(appThread, new NewIntentItem(next.token, next.newIntents, true));     // Catch: RemoteException -> L261
    L263:
        if (isSuccessful4 == true) goto L266;
        onResumeTopActivityRemoteFailure(lastState, next, lastResumedActivity, lastFocusedRootTask);
        return true;
    L262:
        isSuccessful4 = false;
        goto L263
    L233:
        r9 = lastFocusedRootTask.getTopResumedActivity();
        goto L234
    L228:
        if (next.mAppStopped == true) goto L230;
        if (lastActivityTranslucent == false) goto L231;
    L219:
        if (this.mLastPausedActivity != null) goto L221;
    L223:
        r0 = false;
        goto L225
    L221:
        if (this.mLastPausedActivity.occludesParent() == true) goto L223;
    L346:
        if (next.hasBeenLaunched == true) goto L348;
        next.hasBeenLaunched = true;
    L351:
        ProtoLog.d(WmProtoLogGroups.WM_DEBUG_STATES, "resumeTopActivity: Restarting %s", new Object[]{next});
        this.mTaskSupervisor.startSpecificActivity(next, true, true);
        return true;
    L348:
        next.showStartingWindow(false);
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L351;
        Slog.v("ActivityTaskManager", "Restarting: " + next);
        goto L351
    L204:
        next.abortAndClearOptionsAnimation();
        goto L205
    L199:
        if (this.mPerf == null) goto L201;
        this.mPerf.perfHint(4265, next.packageName);
    L201:
        anim2 = false;
        goto L202
    L173:
        if (prev.finishing == true) goto L175;
        dc = dc;
        if (this.mTaskSupervisor.mNoAnimActivities.contains(next) == false) goto L190;
        anim2 = false;
        goto L202
    L190:
        if (prev.getTask() != next.getTask()) goto L192;
    L195:
        anim2 = true;
        goto L202
    L192:
        if (this.mPerf == null) goto L195;
        if (isBoostLimit == true) goto L195;
        anim2 = true;
        SysOptBridge.getFactory().getBoostFrameworkService().perfLockAcquireType(4227, 0, 0, next.getPid());
        goto L202
    L175:
        if (this.mTaskSupervisor.mNoAnimActivities.contains(prev) == true) goto L177;
        dc = dc;
    L185:
        prev.setVisibility(false);
        anim2 = anim;
        goto L202
    L177:
        if (prev.getTask() == next.getTask()) goto L183;
        if (this.mPerf == null) goto L183;
        if (isBoostLimit == true) goto L183;
        SysOptBridge.getFactory().getBoostFrameworkService().perfLockAcquireType(4227, 0, 0, next.getPid());
    L183:
        anim = false;
        goto L185
    L167:
        if (dc.getExt().isObricVirtualDisplay() == false) goto L171;
        if (SysOptBridge.getFactory().getBytedancePowerAdvisorInstance().isBoostLimitForOAutoPkg(next.packageName) == false) goto L171;
        isBoostLimit = true;
        Slog.i("ActivityTaskManager", "FEAT_OAUTO_POWER_CTRL, ignore animation boost, pkg:" + next.packageName);
    L156:
        e = e;
    L160:
        Slog.w("ActivityTaskManager", "Failed trying to unstop package " + next.packageName + ": " + e);
    L158:
        e = e;
        goto L160
    L103:
        r7 = 0;
        pausing2 = pausing;
        goto L104
    L97:
        if (taskDisplayArea.pauseBackTasks(next) == false) goto L99;
        pausing = true;
        goto L101
    L92:
        if (lastFocusedRootTask == getRootTaskFragment().asTask()) goto L94;
        ActivityRecord lastResumed2 = lastFocusedRootTask.getTopResumedActivity();
        lastResumed = lastResumed2;
        goto L95
    L17:
        if (this.mRootWindowContainer.allPausedActivitiesComplete() == true) goto L20;
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "resumeTopActivity: Skip resume: some activity pausing.", new Object[0]);
        return false;
    }

    private void onResumeTopActivityRemoteFailure(ActivityRecord.State lastState, ActivityRecord next, ActivityRecord lastResumedActivity, Task lastFocusedRootTask) {
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "Resume failed; resetting state to %s: %s", new Object[]{lastState, next});
        next.setState(lastState, "resumeTopActivityInnerLocked");
        if (lastResumedActivity == null) goto L5;
        lastResumedActivity.setState(ActivityRecord.State.RESUMED, "resumeTopActivityInnerLocked");
    L5:
        Slog.i("ActivityTaskManager", "Restarting because process died: " + next);
        if (next.hasBeenLaunched == true) goto L8;
        next.hasBeenLaunched = true;
    L12:
        this.mTaskSupervisor.startSpecificActivity(next, true, false);
        return;
    L8:
        if (lastFocusedRootTask == null) goto L12;
        if (lastFocusedRootTask.isTopRootTaskInDisplayArea() == false) goto L12;
        next.showStartingWindow(false);
        goto L12
    }

    boolean shouldSleepOrShutDownActivities() {
        if (shouldSleepActivities() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mAtmService.mShuttingDown == true) goto L8;
        return false;
    }

    boolean shouldBeVisible(ActivityRecord starting) {
        if (getVisibility(starting) == 2) goto L5;
        return true;
    L5:
        return false;
    }

    boolean canBeResumed(ActivityRecord starting) {
        if (isTopActivityFocusable() == true) goto L5;
    L7:
        return false;
    L5:
        if (getVisibility(starting) != 0) goto L7;
        return true;
    }

    boolean isFocusableAndVisible() {
        if (isTopActivityFocusable() == true) goto L5;
    L7:
        return false;
    L5:
        if (shouldBeVisible(null) == false) goto L7;
        return true;
    }

    final boolean startPausing(boolean uiSleeping, ActivityRecord resuming, String reason) {
        return startPausing(this.mTaskSupervisor.mUserLeaving, uiSleeping, resuming, reason);
    }

    boolean startPausing(boolean userLeaving, boolean uiSleeping, ActivityRecord resuming, String reason) {
        if (hasDirectChildActivities() == true) goto L6;
        return false;
    L6:
        if (this.mResumedActivity != null) goto L8;
    L13:
        ProtoLog.d(WmProtoLogGroups.WM_DEBUG_STATES, "startPausing: taskFrag=%s mResumedActivity=%s", new Object[]{this, this.mResumedActivity});
        if (this.mPausingActivity == null) goto L18;
        Slog.wtf("ActivityTaskManager", "Going to pause when pause is already pending for " + this.mPausingActivity + " state=" + this.mPausingActivity.getState());
        if (shouldSleepActivities() == true) goto L18;
        completePause(false, resuming);
    L18:
        ActivityRecord prev = this.mResumedActivity;
        if (prev != null) goto L23;
        if (resuming != null) goto L22;
        Slog.wtf("ActivityTaskManager", "Trying to pause when nothing is resumed");
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();
    L22:
        return false;
    L23:
        if (prev != resuming) goto L27;
        Slog.wtf("ActivityTaskManager", "Trying to pause activity that is in process of being resumed");
        return false;
    L27:
        if (mActivityTrigger == null) goto L30;
        mActivityTrigger.activityPauseTrigger(prev.intent, prev.info, prev.info.applicationInfo);
    L30:
        if (this.mAtmService.getToastWindow() != true) goto L32;
        prev.translucentWindowLaunch = true;
        this.mAtmService.resetToastWindow();
    L32:
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "Moving to PAUSING: %s", new Object[]{prev});
        this.mPausingActivity = prev;
        this.mLastPausedActivity = prev;
        if (prev.finishing == false) goto L35;
    L39:
        prev.setState(ActivityRecord.State.PAUSING, "startPausingLocked");
        prev.getTask().touchActiveTime();
        this.mAtmService.updateCpuStats();
        boolean pauseImmediately = false;
        if (resuming == null) goto L58;
        boolean resumingOccludesParent = resuming.occludesParent();
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == false) goto L44;
        Task.enableEnterPipOnTaskSwitch(prev, resuming.getTask(), resuming, resuming.getOptions());
    L44:
        boolean lastResumedCanPip = prev.checkEnterPictureInPictureState("shouldAutoPipWhilePausing", userLeaving);
        if (prev.supportsEnterPipOnTaskSwitch == false) goto L52;
        if (userLeaving == false) goto L52;
        if (resumingOccludesParent == false) goto L52;
        if (lastResumedCanPip == false) goto L52;
        if (prev.pictureInPictureArgs.isAutoEnterEnabled() == false) goto L52;
        boolean lastResumedCanPip2 = true;
    L59:
        boolean shouldAutoPip = prev.attachedToProcess();
        if (shouldAutoPip == false) goto L86;
        if (lastResumedCanPip2 == true) goto L63;
    L65:
        if (lastResumedCanPip2 == false) goto L67;
        prev.mPauseSchedulePendingForPip = true;
        boolean didAutoPip = this.mAtmService.enterPictureInPictureMode(prev, prev.pictureInPictureArgs, false);
        ProtoLog.d(WmProtoLogGroups.WM_DEBUG_STATES, "Auto-PIP allowed, entering PIP mode directly: %s, didAutoPip: %b", new Object[]{prev, Boolean.valueOf(didAutoPip)});
    L87:
        if (uiSleeping == true) goto L92;
        if (this.mAtmService.isSleepingOrShuttingDownLocked() == true) goto L92;
        this.mTaskSupervisor.acquireLaunchWakelock();
    L92:
        if (this.mPausingActivity == null) goto L103;
        if (uiSleeping == true) goto L95;
        prev.pauseKeyDispatchingLocked();
    L96:
        if (pauseImmediately == false) goto L99;
        completePause(false, resuming);
        return false;
    L99:
        prev.schedulePauseTimeout();
        if (uiSleeping == true) goto L102;
        this.mTransitionController.setReady(this, false);
    L102:
        return true;
    L95:
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "Key dispatch not paused for screen off", new Object[0]);
        goto L96
    L103:
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "Activity not running or entered PiP, resuming next.", new Object[0]);
        if (resuming != null) goto L106;
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();
    L106:
        return false;
    L67:
        schedulePauseActivity(prev, userLeaving, pauseImmediately, false, reason);
        if (MindSyncManager.ZTE_FEATURE_MINDSYNC == false) goto L87;
        boolean isAllParamsValid = true;
        if (prev.info != null) goto L72;
    L73:
        isAllParamsValid = false;
    L75:
        if (TextUtils.isEmpty(prev.packageName) == false) goto L77;
    L78:
        isAllParamsValid = false;
    L80:
        if (prev.app != null) goto L82;
        isAllParamsValid = false;
    L82:
        if (isAllParamsValid == false) goto L84;
        MindSyncManager.Trigger.noteAppBackground(prev.info.applicationInfo.uid, prev.packageName, prev.app.getPid(), prev.processName, SystemClock.elapsedRealtime(), prev.getWindowingMode());
        goto L87
    L84:
        Slog.w("ActivityTaskManager", "Skip noteAppBackground: some critical params are null, prev=" + prev);
        goto L87
    L77:
        if (TextUtils.isEmpty(prev.processName) == false) goto L80;
    L72:
        if (prev.info.applicationInfo != null) goto L75;
    L63:
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == false) goto L65;
        prev.mPauseSchedulePendingForPip = true;
        boolean willAutoPip = this.mAtmService.prepareAutoEnterPictureAndPictureMode(prev);
        ProtoLog.d(WmProtoLogGroups.WM_DEBUG_STATES, "Auto-PIP allowed, requesting PIP mode via requestStartTransition(): %s, willAutoPip: %b", new Object[]{prev, Boolean.valueOf(willAutoPip)});
        goto L87
    L86:
        this.mPausingActivity = null;
        this.mLastPausedActivity = null;
        this.mTaskSupervisor.mNoHistoryActivities.remove(prev);
    L52:
        if (lastResumedCanPip == true) goto L58;
        if ((resuming.info.flags & 16384) == 0) goto L56;
        boolean r11 = true;
    L57:
        pauseImmediately = r11;
        lastResumedCanPip2 = false;
        goto L59
    L56:
        r11 = false;
    L58:
        lastResumedCanPip2 = false;
        goto L59
    L35:
        if (prev.isNoHistory() == false) goto L39;
        if (this.mTaskSupervisor.mNoHistoryActivities.contains(prev) == true) goto L39;
        this.mTaskSupervisor.mNoHistoryActivities.add(prev);
        goto L39
    L8:
        if (this.mResumedActivity.finishing == true) goto L13;
        if (this.mTransitionController.getExt().isTransientLaunchNotFromRemote(this.mResumedActivity) == false) goto L13;
        ProtoLog.d(WmProtoLogGroups.WM_DEBUG_STATES, "startPausing: Skipping pause for transient resumed activity=%s", new Object[]{this.mResumedActivity});
        return false;
    }

    void schedulePauseActivity(ActivityRecord prev, boolean userLeaving, boolean pauseImmediately, boolean autoEnteringPip, String reason) {
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "Enqueueing pending pause: %s", new Object[]{prev});
        prev.mPauseSchedulePendingForPip = false;
        EventLogTags.writeWmPauseActivity(prev.mUserId, System.identityHashCode(prev), prev.shortComponentName, "userLeaving=" + userLeaving, reason);
        ZTEActivityEventsInternal zteActivityEventsInternal = (ZTEActivityEventsInternal) LocalServices.getService(ZTEActivityEventsInternal.class);
        if (zteActivityEventsInternal == null) goto L14;
        zteActivityEventsInternal.notifyActivityEvent(64, prev.getDisplayId(), prev.mUserId, prev, prev.getRootTaskId());
    L14:
        boolean isSuccessful = this.mAtmService.getLifecycleManager().scheduleTransactionItem(prev.app.getThread(), new PauseActivityItem(prev.token, prev.finishing, userLeaving, pauseImmediately, autoEnteringPip));     // Catch: RemoteException -> L9
    L11:
        if (isSuccessful == true) goto L16;
        this.mPausingActivity = null;
        this.mLastPausedActivity = null;
        this.mTaskSupervisor.mNoHistoryActivities.remove(prev);
        return;
    L16:
        return;
    L9:
        e = move-exception;
        Slog.w("ActivityTaskManager", "Exception thrown during pause", e);
        isSuccessful = false;
        goto L11
    }

    void completePause(boolean resumeNext, ActivityRecord resuming) {
        ActivityRecord prev = this.mPausingActivity;
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "Complete pause: %s", new Object[]{prev});
        ActivityRecord top = null;
        if (prev == null) goto L18;
        prev.setWillCloseOrEnterPip(false);
        prev.supportsEnterPipOnTaskSwitch = false;
        boolean wasStopping = prev.isState(ActivityRecord.State.STOPPING);
        prev.setState(ActivityRecord.State.PAUSED, "completePausedLocked");
        this.mPausingActivity = null;
        if (prev.finishing == false) goto L8;
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "Executing finish of activity: %s", new Object[]{prev});
        prev = prev.completeFinishing(false, "completePausedLocked");
        goto L18
    L8:
        if (prev.attachedToProcess() == false) goto L17;
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "Enqueue pending stop if needed: %s wasStopping=%b visibleRequested=%b", new Object[]{prev, Boolean.valueOf(wasStopping), Boolean.valueOf(prev.isVisibleRequested())});
        if (wasStopping == false) goto L13;
        prev.setState(ActivityRecord.State.STOPPING, "completePausedLocked");
        goto L18
    L13:
        if (prev.isVisibleRequested() == true) goto L15;
    L16:
        prev.clearDeferHidingClient();
        prev.addToStopping(true, false, "completePauseLocked");
        goto L18
    L15:
        if (shouldSleepOrShutDownActivities() == false) goto L18;
    L17:
        ProtoLog.v(WmProtoLogGroups.WM_DEBUG_STATES, "App died during pause, not stopping: %s", new Object[]{prev});
        prev = null;
    L18:
        if (resumeNext == false) goto L30;
        Task topRootTask = this.mRootWindowContainer.getTopDisplayFocusedRootTask();
        if (topRootTask != null) goto L22;
    L24:
        if (topRootTask == null) goto L26;
        top = topRootTask.topRunningActivity();
    L26:
        if (top == null) goto L29;
        if (prev == null) goto L30;
        if (top == prev) goto L30;
    L29:
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();
        goto L30
    L22:
        if (topRootTask.shouldSleepOrShutDownActivities() == true) goto L24;
        this.mRootWindowContainer.resumeFocusedTasksTopActivities(topRootTask, prev);
    L30:
        if (prev == null) goto L32;
        prev.resumeKeyDispatchingLocked();
    L32:
        this.mRootWindowContainer.ensureActivitiesVisible(resuming);
        if (this.mTaskSupervisor.mAppVisibilitiesChangedSinceLastPause == false) goto L35;
    L38:
        this.mAtmService.getTaskChangeNotificationController().notifyTaskStackChanged();
        this.mTaskSupervisor.mAppVisibilitiesChangedSinceLastPause = false;
        return;
    L35:
        if (getDisplayArea() != null) goto L37;
        return;
    L37:
        if (getDisplayArea().hasPinnedTask() == true) goto L38;
    }

    @Override // com.android.server.wm.WindowContainer
    int getOrientation(int candidate) {
        if (shouldReportOrientationUnspecified() == false) goto L7;
        return -1;
    L7:
        if (canSpecifyOrientation() == true) goto L9;
        return -2;
    L9:
        return super.getOrientation(candidate);
    }

    @Override // com.android.server.wm.WindowContainer
    protected int getOverrideOrientation() {
        if (isEmbedded() == false) goto L9;
        if (isVisibleRequested() == true) goto L9;
        return -1;
    L9:
        return super.getOverrideOrientation();
    }

    boolean canSpecifyOrientation() {
        int windowingMode = getWindowingMode();
        int activityType = getActivityType();
        if (windowingMode != 1) goto L5;
        return true;
    L5:
        if (activityType != 2) goto L7;
        return true;
    L7:
        if (activityType != 3) goto L9;
        return true;
    L9:
        if (activityType == 4) goto L16;
        return false;
    L16:
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean providesOrientation() {
        if (this.mExt.shouldSkipProvidesOrientation(this) == false) goto L6;
        return false;
    L6:
        if (super.providesOrientation() == false) goto L8;
    L9:
        return true;
    L8:
        if (shouldReportOrientationUnspecified() == true) goto L9;
        return false;
    }

    private boolean shouldReportOrientationUnspecified() {
        if (hasAdjacentTaskFragment() == true) goto L5;
    L7:
        return false;
    L5:
        if (isVisibleRequested() == false) goto L7;
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    void forAllTaskFragments(Consumer<TaskFragment> callback, boolean traverseTopToBottom) {
        super.forAllTaskFragments(callback, traverseTopToBottom);
        callback.accept(this);
    }

    @Override // com.android.server.wm.WindowContainer
    void forAllLeafTaskFragments(Consumer<TaskFragment> callback, boolean traverseTopToBottom) {
        int count = this.mChildren.size();
        boolean isLeafTaskFrag = true;
        if (traverseTopToBottom == false) goto L11;
        int i = count - 1;
    L5:
        if (i < 0) goto L17;
        TaskFragment child = ((WindowContainer) this.mChildren.get(i)).asTaskFragment();
        if (child == null) goto L9;
        isLeafTaskFrag = false;
        child.forAllLeafTaskFragments(callback, traverseTopToBottom);
    L9:
        i = i - 1;
    L17:
        if (isLeafTaskFrag == false) goto L26;
        callback.accept(this);
        return;
    L26:
        return;
    L11:
        int i2 = 0;
    L12:
        if (i2 >= count) goto L17;
        TaskFragment child2 = ((WindowContainer) this.mChildren.get(i2)).asTaskFragment();
        if (child2 == null) goto L16;
        isLeafTaskFrag = false;
        child2.forAllLeafTaskFragments(callback, traverseTopToBottom);
    L16:
        i2 = i2 + 1;
        goto L12
    }

    @Override // com.android.server.wm.WindowContainer
    boolean forAllLeafTaskFragments(Predicate<TaskFragment> callback) {
        boolean isLeafTaskFrag = true;
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L11;
        TaskFragment child = ((WindowContainer) this.mChildren.get(i)).asTaskFragment();
        if (child == null) goto L9;
        isLeafTaskFrag = false;
        if (child.forAllLeafTaskFragments(callback) == false) goto L9;
        return true;
    L9:
        i = i - 1;
        goto L3
    L11:
        if (isLeafTaskFrag == true) goto L13;
        return false;
    L13:
        return callback.test(this);
    }

    void addChild(ActivityRecord r) {
        addChild(r, Integer.MAX_VALUE);
    }

    @Override // com.android.server.wm.WindowContainer
    void addChild(WindowContainer child, int index) {
        topRunningActivity();
        int activityType = 0;
        this.mClearedTaskForReuse = false;
        this.mClearedTaskFragmentForPip = false;
        this.mClearedForReorderActivityToFront = false;
        ActivityRecord addingActivity = child.asActivityRecord();
        if (addingActivity == null) goto L5;
        boolean isAddingActivity = true;
    L6:
        if (isAddingActivity == false) goto L8;
        Task task = getTask();
    L9:
        if (task != null) goto L11;
    L13:
        boolean taskHadActivity = false;
    L14:
        if (task == null) goto L16;
        activityType = task.getActivityType();
    L16:
        super.addChild(child, index);
        if (isAddingActivity == false) goto L20;
        if (task == null) goto L20;
        addingActivity.inHistory = true;
        task.onDescendantActivityAdded(taskHadActivity, activityType, addingActivity);
    L20:
        WindowProcessController hostProcess = getOrganizerProcessIfDifferent(addingActivity);
        if (hostProcess == null) goto L24;
        hostProcess.addEmbeddedActivity(addingActivity);
        return;
    L24:
        return;
    L11:
        if (task.getTopMostActivity() == null) goto L13;
        taskHadActivity = true;
        goto L14
    L8:
        task = null;
        goto L9
    L5:
        isAddingActivity = false;
        goto L6
    }

    @Override // com.android.server.wm.WindowContainer
    void onChildPositionChanged(WindowContainer child) {
        super.onChildPositionChanged(child);
        sendTaskFragmentInfoChanged();
    }

    void executeAppTransition(ActivityOptions options) {
        this.mDisplayContent.executeAppTransition();
        ActivityOptions.abort(options);
    }

    @Override // com.android.server.wm.WindowContainer
    boolean canCreateRemoteAnimationTarget() {
        return true;
    }

    boolean shouldSleepActivities() {
        DisplayContent dc = this.mDisplayContent;
        if (dc != null) goto L7;
        return this.mAtmService.isSleepingLocked();
    L7:
        if (dc.isSleeping() == true) goto L11;
        return false;
    L11:
        if (dc.isDefaultDisplay == true) goto L13;
    L17:
        return true;
    L13:
        if (dc.isKeyguardGoingAway() == false) goto L17;
        return !shouldBeVisible(null);
    }

    @Override // com.android.server.wm.ConfigurationContainer
    void resolveOverrideConfiguration(Configuration newParentConfig) {
        this.mTmpBounds.set(getResolvedOverrideConfiguration().windowConfiguration.getBounds());
        super.resolveOverrideConfiguration(newParentConfig);
        Configuration resolvedConfig = getResolvedOverrideConfiguration();
        if (this.mRelativeEmbeddedBounds != null) goto L5;
    L7:
        int windowingMode = resolvedConfig.windowConfiguration.getWindowingMode();
        int parentWindowingMode = newParentConfig.windowConfiguration.getWindowingMode();
        if (getActivityType() != 2) goto L12;
        if (windowingMode != 0) goto L12;
        windowingMode = 1;
        resolvedConfig.windowConfiguration.setWindowingMode(1);
    L12:
        if (supportsMultiWindow() == true) goto L20;
        if (windowingMode == 0) goto L15;
        int candidateWindowingMode = windowingMode;
    L17:
        if (WindowConfiguration.inMultiWindowMode(candidateWindowingMode) == false) goto L20;
        if (candidateWindowingMode == 2) goto L20;
        resolvedConfig.windowConfiguration.setWindowingMode(1);
        goto L20
    L15:
        candidateWindowingMode = parentWindowingMode;
    L20:
        Task thisTask = asTask();
        if (thisTask == null) goto L23;
        thisTask.resolveLeafTaskOnlyOverrideConfigs(newParentConfig, this.mTmpBounds);
    L23:
        computeConfigResourceOverrides(resolvedConfig, newParentConfig);
        return;
    L5:
        if (this.mRelativeEmbeddedBounds.isEmpty() == true) goto L7;
        resolvedConfig.windowConfiguration.setBounds(translateRelativeBoundsToAbsoluteBounds(this.mRelativeEmbeddedBounds, newParentConfig.windowConfiguration.getBounds()));
        goto L7
    }

    boolean supportsMultiWindow() {
        return supportsMultiWindowInDisplayArea(getDisplayArea());
    }

    boolean supportsMultiWindowInDisplayArea(TaskDisplayArea tda) {
        if (this.mAtmService.mSupportsMultiWindow == true) goto L5;
        return false;
    L5:
        if (tda != null) goto L7;
        return false;
    L7:
        Task task = getTask();
        if (task != null) goto L11;
        return false;
    L11:
        if (task.isResizeable() == false) goto L13;
    L15:
        ActivityRecord rootActivity = task.getRootActivity();
        int r2 = this.mMinWidth;
        int r3 = this.mMinHeight;
        if (rootActivity == null) goto L18;
        ActivityInfo r4 = rootActivity.info;
    L20:
        return tda.supportsActivityMinWidthHeightMultiWindow(r2, r3, r4);
    L18:
        r4 = null;
        goto L20
    L13:
        if (tda.supportsNonResizableMultiWindow() == true) goto L15;
        return false;
    }

    private int getTaskId() {
        if (getTask() != null) goto L7;
        return -1;
    L7:
        return getTask().mTaskId;
    }

    void computeConfigResourceOverrides(Configuration inOutConfig, Configuration parentConfig) {
        computeConfigResourceOverrides(inOutConfig, parentConfig, null);
    }

    private static void invalidateAppBoundsConfig(Configuration inOutConfig) {
        Rect appBounds = inOutConfig.windowConfiguration.getAppBounds();
        if (appBounds == null) goto L5;
        appBounds.setEmpty();
    L5:
        inOutConfig.screenWidthDp = 0;
        inOutConfig.screenHeightDp = 0;
    }

    void computeConfigResourceOverrides(Configuration inOutConfig, Configuration parentConfig, ConfigOverrideHint overrideHint) {
        if (overrideHint == null) goto L11;
        DisplayInfo overrideDisplayInfo = overrideHint.mTmpOverrideDisplayInfo;
        AppCompatDisplayInsets compatInsets = overrideHint.mTmpCompatInsets;
        boolean useOverrideInsetsForConfig = overrideHint.mUseOverrideInsetsForConfig;
        if (overrideDisplayInfo == null) goto L7;
        inOutConfig.screenLayout = 0;
    L7:
        if (overrideDisplayInfo != null) goto L9;
        if (compatInsets != null) goto L9;
    L10:
        DisplayInfo overrideDisplayInfo2 = overrideDisplayInfo;
        AppCompatDisplayInsets compatInsets2 = compatInsets;
        boolean useOverrideInsetsForConfig2 = useOverrideInsetsForConfig;
    L12:
        int windowingMode = inOutConfig.windowConfiguration.getWindowingMode();
        if (windowingMode != 0) goto L15;
        int windowingMode2 = parentConfig.windowConfiguration.getWindowingMode();
    L16:
        float density = inOutConfig.densityDpi;
        if (density != 0.0f) goto L19;
        density = parentConfig.densityDpi;
    L19:
        float density2 = density * 0.00625f;
        Rect r14 = parentConfig.windowConfiguration.getBounds();
        Rect r15 = inOutConfig.windowConfiguration.getBounds();
        if (r15.isEmpty() == false) goto L22;
        this.mTmpFullBounds.set(r14);
        boolean insideParentBounds = true;
    L24:
        if (compatInsets2 == null) goto L26;
        boolean r1 = true;
    L27:
        boolean customContainerPolicy = r1;
        Rect outAppBounds = inOutConfig.windowConfiguration.getAppBounds();
        if (outAppBounds != null) goto L30;
    L31:
        inOutConfig.windowConfiguration.setAppBounds(this.mTmpFullBounds);
        outAppBounds = inOutConfig.windowConfiguration.getAppBounds();
        if (customContainerPolicy == false) goto L34;
    L49:
        int r3 = 2;
        if (inOutConfig.screenWidthDp != 0) goto L52;
    L55:
        if (customContainerPolicy == false) goto L57;
    L59:
        if (customContainerPolicy == true) goto L70;
        if (overrideDisplayInfo2 == null) goto L62;
    L65:
        if (overrideDisplayInfo2 == null) goto L67;
        DisplayInfo di = overrideDisplayInfo2;
    L68:
        r3 = 2;
        calculateInsetFrames(this.mTmpNonDecorBounds, this.mTmpStableBounds, this.mTmpFullBounds, di, useOverrideInsetsForConfig2);
    L78:
        if (inOutConfig.screenWidthDp != 0) goto L86;
        int overrideScreenWidthDp = (int) ((this.mTmpStableBounds.width() / density2) + 0.5f);
        if (insideParentBounds == false) goto L83;
        if (customContainerPolicy == true) goto L83;
        int r2 = Math.min(overrideScreenWidthDp, parentConfig.screenWidthDp);
    L84:
        inOutConfig.screenWidthDp = r2;
    L83:
        r2 = overrideScreenWidthDp;
    L86:
        if (inOutConfig.screenHeightDp != 0) goto L94;
        int overrideScreenHeightDp = (int) ((this.mTmpStableBounds.height() / density2) + 0.5f);
        if (insideParentBounds == false) goto L91;
        if (customContainerPolicy == true) goto L91;
        int r4 = Math.min(overrideScreenHeightDp, parentConfig.screenHeightDp);
    L92:
        inOutConfig.screenHeightDp = r4;
    L91:
        r4 = overrideScreenHeightDp;
    L94:
        if (inOutConfig.smallestScreenWidthDp != 0) goto L114;
        if (windowingMode2 == r3) goto L97;
    L101:
        boolean inPipTransition = false;
    L103:
        if (WindowConfiguration.isFloating(windowingMode2) == false) goto L107;
        if (inPipTransition == true) goto L107;
        inOutConfig.smallestScreenWidthDp = (int) ((Math.min(this.mTmpFullBounds.width(), this.mTmpFullBounds.height()) / density2) + 0.5f);
    L107:
        if (windowingMode2 != 6) goto L114;
        if (this.mIsEmbedded == false) goto L114;
        if (r15.equals(r14) == true) goto L114;
        inOutConfig.smallestScreenWidthDp = Math.min(inOutConfig.screenWidthDp, inOutConfig.screenHeightDp);
        goto L114
    L97:
        if (this.mTmpFullBounds.isEmpty() == true) goto L101;
        if (this.mTmpFullBounds.equals(r14) == false) goto L101;
        inPipTransition = true;
    L114:
        if (inOutConfig.orientation != 0) goto L121;
        if (inOutConfig.screenWidthDp > inOutConfig.screenHeightDp) goto L119;
        r3 = 1;
    L119:
        inOutConfig.orientation = r3;
    L121:
        if (inOutConfig.screenLayout != 0) goto L130;
        int compatScreenWidthDp = (int) ((this.mTmpNonDecorBounds.width() / density2) + 0.5f);
        int compatScreenHeightDp = (int) ((this.mTmpNonDecorBounds.height() / density2) + 0.5f);
        if (inOutConfig.screenWidthDp == 0) goto L126;
        compatScreenWidthDp = inOutConfig.screenWidthDp;
    L126:
        if (inOutConfig.screenHeightDp == 0) goto L128;
        compatScreenHeightDp = inOutConfig.screenHeightDp;
    L128:
        inOutConfig.screenLayout = WindowContainer.computeScreenLayout(parentConfig.screenLayout, compatScreenWidthDp, compatScreenHeightDp);
        return;
    L130:
        return;
    L67:
        di = getDisplayContent().getDisplayInfo();
        goto L68
    L62:
        if (getDisplayContent() != null) goto L65;
    L70:
        int rotation = inOutConfig.windowConfiguration.getRotation();
        if (rotation != (-1)) goto L73;
        rotation = parentConfig.windowConfiguration.getRotation();
    L73:
        if (rotation == (-1)) goto L76;
        if (customContainerPolicy == false) goto L76;
        this.mTmpNonDecorBounds.set(this.mTmpFullBounds);
        this.mTmpStableBounds.set(this.mTmpFullBounds);
        compatInsets2.getBoundsByRotation(this.mTmpBounds, rotation);
        intersectWithInsetsIfFits(this.mTmpNonDecorBounds, this.mTmpBounds, compatInsets2.mNonDecorInsets[rotation]);
        intersectWithInsetsIfFits(this.mTmpStableBounds, this.mTmpBounds, compatInsets2.mStableInsets[rotation]);
        outAppBounds.set(this.mTmpNonDecorBounds);
    L76:
        this.mTmpNonDecorBounds.set(outAppBounds);
        this.mTmpStableBounds.set(outAppBounds);
        goto L78
    L57:
        if (WindowConfiguration.isFloating(windowingMode2) == false) goto L59;
        this.mTmpNonDecorBounds.set(this.mTmpFullBounds);
        this.mTmpStableBounds.set(this.mTmpFullBounds);
        r3 = 2;
        goto L78
    L52:
        if (inOutConfig.screenHeightDp == 0) goto L55;
        r3 = 2;
        goto L114
    L34:
        if (WindowConfiguration.isFloating(windowingMode2) == true) goto L49;
        if (insideParentBounds == false) goto L40;
        if (useOverrideInsetsForConfig2 == false) goto L38;
        Rect containingAppBounds = overrideHint.mParentAppBoundsOverride;
    L45:
        if (containingAppBounds == null) goto L49;
        if (containingAppBounds.isEmpty() == true) goto L49;
        outAppBounds.intersect(containingAppBounds);
        goto L49
    L38:
        containingAppBounds = parentConfig.windowConfiguration.getAppBounds();
        goto L45
    L40:
        TaskDisplayArea displayArea = getDisplayArea();
        if (displayArea == null) goto L43;
        Rect r5 = displayArea.getWindowConfiguration().getAppBounds();
    L44:
        containingAppBounds = r5;
        goto L45
    L43:
        r5 = null;
        goto L44
    L30:
        if (outAppBounds.isEmpty() == false) goto L49;
    L26:
        r1 = false;
        goto L27
    L22:
        this.mTmpFullBounds.set(r15);
        insideParentBounds = r14.contains(r15);
        goto L24
    L15:
        windowingMode2 = windowingMode;
    L9:
        invalidateAppBoundsConfig(inOutConfig);
        goto L10
    L11:
        overrideDisplayInfo2 = null;
        compatInsets2 = null;
        useOverrideInsetsForConfig2 = false;
        goto L12
    }

    void calculateInsetFrames(Rect outNonDecorBounds, Rect outStableBounds, Rect bounds, DisplayInfo displayInfo, boolean useLegacyInsetsForStableBounds) {
        outNonDecorBounds.set(bounds);
        outStableBounds.set(bounds);
        if (this.mDisplayContent != null) goto L5;
        return;
    L5:
        this.mTmpBounds.set(0, 0, displayInfo.logicalWidth, displayInfo.logicalHeight);
        DisplayPolicy policy = this.mDisplayContent.getDisplayPolicy();
        DisplayPolicy.DecorInsets.Info info = policy.getDecorInsetsInfo(displayInfo.rotation, displayInfo.logicalWidth, displayInfo.logicalHeight);
        if (useLegacyInsetsForStableBounds == true) goto L8;
        intersectWithInsetsIfFits(outStableBounds, this.mTmpBounds, info.mConfigInsets);
        intersectWithInsetsIfFits(outNonDecorBounds, this.mTmpBounds, info.mNonDecorInsets);
        return;
    L8:
        intersectWithInsetsIfFits(outStableBounds, this.mTmpBounds, info.mOverrideConfigInsets);
        intersectWithInsetsIfFits(outNonDecorBounds, this.mTmpBounds, info.mOverrideNonDecorInsets);
    }

    static void intersectWithInsetsIfFits(Rect inOutBounds, Rect intersectBounds, Rect intersectInsets) {
        if (inOutBounds.right > intersectBounds.right) goto L6;
        inOutBounds.right = Math.min(intersectBounds.right - intersectInsets.right, inOutBounds.right);
    L6:
        if (inOutBounds.bottom > intersectBounds.bottom) goto L9;
        inOutBounds.bottom = Math.min(intersectBounds.bottom - intersectInsets.bottom, inOutBounds.bottom);
    L9:
        if (inOutBounds.left < intersectBounds.left) goto L12;
        inOutBounds.left = Math.max(intersectBounds.left + intersectInsets.left, inOutBounds.left);
    L12:
        if (inOutBounds.top < intersectBounds.top) goto L15;
        inOutBounds.top = Math.max(intersectBounds.top + intersectInsets.top, inOutBounds.top);
        return;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public int getActivityType() {
        int applicationType = super.getActivityType();
        if (applicationType == 0) goto L5;
    L12:
        return applicationType;
    L5:
        if (hasChild() == false) goto L12;
        ActivityRecord activity = getTopMostActivity();
        if (activity == null) goto L11;
        return activity.getActivityType();
    L11:
        return getTopChild().getActivityType();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public void onConfigurationChanged(Configuration newParentConfig) {
        super.onConfigurationChanged(newParentConfig);
        updateOrganizedTaskFragmentSurface();
        sendTaskFragmentInfoChanged();
    }

    void deferOrganizedTaskFragmentSurfaceUpdate() {
        this.mDelayOrganizedTaskFragmentSurfaceUpdate = true;
    }

    void continueOrganizedTaskFragmentSurfaceUpdate() {
        this.mDelayOrganizedTaskFragmentSurfaceUpdate = false;
        updateOrganizedTaskFragmentSurface();
    }

    void updateOrganizedTaskFragmentSurface() {
        if (this.mDelayOrganizedTaskFragmentSurfaceUpdate == false) goto L5;
        return;
    L5:
        if (this.mTaskFragmentOrganizer != null) goto L8;
        return;
    L8:
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L13;
        if (this.mTransitionController.isCollecting(this) == true) goto L13;
        updateOrganizedTaskFragmentSurfaceUnchecked();
        return;
    L13:
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L15;
        return;
    L15:
        if (isAnimating() == true) goto L21;
        updateOrganizedTaskFragmentSurfaceUnchecked();
        return;
    }

    private void updateOrganizedTaskFragmentSurfaceUnchecked() {
        SurfaceControl.Transaction t = getSyncTransaction();
        updateSurfacePosition(t);
        updateOrganizedTaskFragmentSurfaceSize(t, false);
    }

    private void updateOrganizedTaskFragmentSurfaceSize(SurfaceControl.Transaction t, boolean forceUpdate) {
        if (this.mTaskFragmentOrganizer != null) goto L6;
        return;
    L6:
        if (this.mSurfaceControl != null) goto L8;
        return;
    L8:
        if (this.mSurfaceAnimator.hasLeash() == true) goto L24;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (forceUpdate == true) goto L18;
        if (width != this.mLastSurfaceSize.x) goto L18;
        if (height != this.mLastSurfaceSize.y) goto L18;
        return;
    L18:
        if (fillsParent() == false) goto L20;
        t.setCrop(this.mSurfaceControl, null);
    L21:
        this.mLastSurfaceSize.set(width, height);
        return;
    L20:
        t.setWindowCrop(this.mSurfaceControl, width, height);
        goto L21
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public void onAnimationLeashCreated(SurfaceControl.Transaction t, SurfaceControl leash) {
        super.onAnimationLeashCreated(t, leash);
        if (this.mTaskFragmentOrganizer != null) goto L5;
        return;
    L5:
        if (this.mLastSurfaceSize.x == 0) goto L7;
    L8:
        t.setWindowCrop(this.mSurfaceControl, 0, 0);
        SurfaceControl.Transaction syncTransaction = getSyncTransaction();
        if (t == syncTransaction) goto L11;
        syncTransaction.setWindowCrop(this.mSurfaceControl, 0, 0);
    L11:
        this.mLastSurfaceSize.set(0, 0);
        return;
    L7:
        if (this.mLastSurfaceSize.y != 0) goto L8;
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public void onAnimationLeashLost(SurfaceControl.Transaction t) {
        super.onAnimationLeashLost(t);
        if (this.mTaskFragmentOrganizer == null) goto L6;
        updateOrganizedTaskFragmentSurfaceSize(t, true);
        return;
    }

    Rect getRelativeEmbeddedBounds() {
        if (this.mRelativeEmbeddedBounds == null) goto L7;
        return this.mRelativeEmbeddedBounds;
    L7:
        throw new IllegalStateException("The TaskFragment is not embedded");
    }

    Rect translateRelativeBoundsToAbsoluteBounds(Rect relativeBounds, Rect parentBounds) {
        if (relativeBounds.isEmpty() == false) goto L6;
        this.mTmpAbsBounds.setEmpty();
        return this.mTmpAbsBounds;
    L6:
        this.mTmpAbsBounds.set(relativeBounds);
        this.mTmpAbsBounds.offset(parentBounds.left, parentBounds.top);
        if (isAllowedToBeEmbeddedInTrustedMode() == true) goto L14;
        if (parentBounds.contains(this.mTmpAbsBounds) == true) goto L14;
        if (this.mTmpAbsBounds.intersect(parentBounds) == true) goto L14;
        this.mTmpAbsBounds.setEmpty();
    L14:
        return this.mTmpAbsBounds;
    }

    void recomputeConfiguration() {
        onRequestedOverrideConfigurationChanged(getRequestedOverrideConfiguration());
    }

    void setRelativeEmbeddedBounds(Rect relativeEmbeddedBounds) {
        if (this.mRelativeEmbeddedBounds == null) goto L10;
        if (this.mRelativeEmbeddedBounds.equals(relativeEmbeddedBounds) == false) goto L7;
        return;
    L7:
        this.mRelativeEmbeddedBounds.set(relativeEmbeddedBounds);
        return;
    L10:
        throw new IllegalStateException("The TaskFragment is not embedded");
    }

    boolean shouldStartChangeTransition(Rect absStartBounds, Rect relStartBounds) {
        if (this.mTaskFragmentOrganizer != null) goto L5;
    L17:
        return false;
    L5:
        if (canStartChangeTransition() == false) goto L17;
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L16;
        Rect endBounds = getConfiguration().windowConfiguration.getBounds();
        if (endBounds.width() != absStartBounds.width()) goto L14;
        if (endBounds.height() != absStartBounds.height()) goto L14;
        return false;
    L14:
        return true;
    L16:
        return !relStartBounds.equals(this.mRelativeEmbeddedBounds);
    }

    @Override // com.android.server.wm.WindowContainer
    boolean canStartChangeTransition() {
        Task task = getTask();
        if (task != null) goto L5;
    L9:
        return false;
    L5:
        if (task.isDragResizing() == true) goto L9;
        if (super.canStartChangeTransition() == false) goto L9;
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isSyncFinished(BLASTSyncEngine.SyncGroup group) {
        if (super.isSyncFinished(group) == true) goto L5;
    L7:
        return false;
    L5:
        if (isReadyToTransit() == false) goto L7;
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    void setSurfaceControl(SurfaceControl sc) {
        super.setSurfaceControl(sc);
        if (this.mTaskFragmentOrganizer == null) goto L6;
        updateOrganizedTaskFragmentSurfaceUnchecked();
        sendTaskFragmentAppeared();
        return;
    }

    void sendTaskFragmentInfoChanged() {
        if (this.mTaskFragmentOrganizer == null) goto L6;
        this.mTaskFragmentOrganizerController.onTaskFragmentInfoChanged(this.mTaskFragmentOrganizer, this);
        return;
    }

    void sendTaskFragmentParentInfoChanged() {
        Task parentTask = getParent().asTask();
        if (this.mTaskFragmentOrganizer == null) goto L7;
        if (parentTask == null) goto L8;
        this.mTaskFragmentOrganizerController.onTaskFragmentParentInfoChanged(this.mTaskFragmentOrganizer, parentTask);
        return;
    L8:
        return;
    }

    private void sendTaskFragmentAppeared() {
        if (this.mTaskFragmentOrganizer == null) goto L6;
        this.mTaskFragmentOrganizerController.onTaskFragmentAppeared(this.mTaskFragmentOrganizer, this);
        return;
    }

    private void sendTaskFragmentVanished() {
        if (this.mTaskFragmentOrganizer == null) goto L6;
        this.mTaskFragmentOrganizerController.onTaskFragmentVanished(this.mTaskFragmentOrganizer, this);
        return;
    }

    TaskFragmentInfo getTaskFragmentInfo() {
        List<IBinder> childActivities = new ArrayList();
        List<IBinder> inRequestedTaskFragmentActivities = new ArrayList();
        int i = 0;
    L4:
        if (i >= getChildCount()) goto L18;
        WindowContainer<?> wc = getChildAt(i);
        ActivityRecord ar = wc.asActivityRecord();
        if (this.mTaskFragmentOrganizerUid == (-1)) goto L17;
        if (ar == null) goto L17;
        if (ar.info.processName.equals(this.mTaskFragmentOrganizerProcessName) == false) goto L17;
        if (ar.getUid() != this.mTaskFragmentOrganizerUid) goto L17;
        if (ar.finishing == true) goto L17;
        childActivities.add(ar.token);
        if (ar.mRequestedLaunchingTaskFragmentToken != this.mFragmentToken) goto L17;
        inRequestedTaskFragmentActivities.add(ar.token);
    L17:
        i = i + 1;
        goto L4
    L18:
        Point positionInParent = new Point();
        getRelativePosition(positionInParent);
        return new TaskFragmentInfo(this.mFragmentToken, this.mRemoteToken.toWindowContainerToken(), getConfiguration(), getNonFinishingActivityCount(), shouldBeVisible(null), childActivities, inRequestedTaskFragmentActivities, positionInParent, this.mClearedTaskForReuse, this.mClearedTaskFragmentForPip, this.mClearedForReorderActivityToFront, calculateMinDimension(), isTopNonFinishingChild());
    }

    private boolean isTopNonFinishingChild() {
        WindowContainer<?> parent = getParent();
        if (parent != null) goto L5;
        return false;
    L5:
        ActivityRecord topNonFishingActivity = parent.getActivity(new TaskFragment$$ExternalSyntheticLambda9());
        if (topNonFishingActivity != null) goto L8;
        return false;
    L8:
        if (topNonFishingActivity.equals(getTopNonFinishingActivity()) == false) goto L13;
        return true;
    L13:
        return false;
    }

    private static /* synthetic */ boolean lambda$isTopNonFinishingChild$10(ActivityRecord ar) {
        return !ar.finishing;
    }

    Point calculateMinDimension() {
        final int[] maxMinWidth = new int[1];
        final int[] maxMinHeight = new int[1];
        forAllActivities(new TaskFragment$$ExternalSyntheticLambda16(maxMinWidth, maxMinHeight));
        return new Point(maxMinWidth[0], maxMinHeight[0]);
    }

    private static /* synthetic */ void lambda$calculateMinDimension$11(int[] maxMinWidth, int[] maxMinHeight, ActivityRecord a) {
        if (a.finishing == false) goto L5;
        return;
    L5:
        Point minDimensions = a.getMinDimensions();
        if (minDimensions != null) goto L8;
        return;
    L8:
        maxMinWidth[0] = Math.max(maxMinWidth[0], minDimensions.x);
        maxMinHeight[0] = Math.max(maxMinHeight[0], minDimensions.y);
    }

    IBinder getFragmentToken() {
        return this.mFragmentToken;
    }

    ITaskFragmentOrganizer getTaskFragmentOrganizer() {
        return this.mTaskFragmentOrganizer;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isOrganized() {
        if (this.mTaskFragmentOrganizer == null) goto L5;
        return true;
    L5:
        return false;
    }

    final boolean isOrganizedTaskFragment() {
        if (this.mTaskFragmentOrganizer == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isEmbeddedWithBoundsOverride() {
        if (this.mIsEmbedded == true) goto L5;
        return false;
    L5:
        Task task = getTask();
        if (task != null) goto L8;
        return false;
    L8:
        Rect taskBounds = task.getBounds();
        Rect taskFragBounds = getBounds();
        if (taskBounds.equals(taskFragBounds) == false) goto L11;
        return false;
    L11:
        if (taskBounds.contains(taskFragBounds) == false) goto L15;
        return true;
    L15:
        return false;
    }

    boolean isTaskVisibleRequested() {
        Task task = getTask();
        if (task != null) goto L5;
    L7:
        return false;
    L5:
        if (task.isVisibleRequested() == false) goto L7;
        return true;
    }

    boolean isReadyToTransit() {
        if (isOrganizedTaskFragment() == true) goto L6;
        return true;
    L6:
        if (getTopNonFinishingActivity() == null) goto L8;
    L22:
        return true;
    L8:
        if (this.mIsRemovalRequested == true) goto L22;
        if (this.mAllowTransitionWhenEmpty == true) goto L22;
        if (isEmbeddedTaskFragmentInPip() == false) goto L16;
        return true;
    L16:
        if (this.mClearedTaskFragmentForPip == true) goto L18;
        return false;
    L18:
        if (isTaskVisibleRequested() == true) goto L23;
        return true;
    L23:
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean canCustomizeAppTransition() {
        if (isEmbedded() == true) goto L5;
    L7:
        return false;
    L5:
        if (matchParentBounds() == false) goto L7;
        return true;
    }

    private static /* synthetic */ void lambda$clearLastPausedActivity$12(TaskFragment taskFragment) {
        taskFragment.mLastPausedActivity = null;
    }

    void clearLastPausedActivity() {
        forAllTaskFragments(new TaskFragment$$ExternalSyntheticLambda14());
    }

    void setMinDimensions(int minWidth, int minHeight) {
        if (asTask() != null) goto L7;
        this.mMinWidth = minWidth;
        this.mMinHeight = minHeight;
        return;
    L7:
        throw new UnsupportedOperationException("This method must not be used to Task. The  minimum dimension of Task should be passed from Task constructor.");
    }

    boolean isEmbeddedTaskFragmentInPip() {
        if (isOrganizedTaskFragment() == true) goto L5;
    L9:
        return false;
    L5:
        if (getTask() == null) goto L9;
        if (getTask().inPinnedWindowingMode() == false) goto L9;
        return true;
    }

    boolean shouldRemoveSelfOnLastChildRemoval() {
        if (this.mCreatedByOrganizer == true) goto L5;
    L14:
        return true;
    L5:
        if (this.mIsRemovalRequested == true) goto L14;
        if (this.mIsEmbedded == true) goto L10;
    L12:
        return false;
    L10:
        if (this.mTaskFragmentOrganizer != null) goto L12;
        return true;
    }

    boolean isRemovalRequested() {
        return this.mIsRemovalRequested;
    }

    @Override // com.android.server.wm.WindowContainer
    void removeChild(WindowContainer child) {
        removeChild(child, true);
    }

    void removeChild(WindowContainer child, boolean removeSelfIfPossible) {
        super.removeChild(child);
        ActivityRecord r = child.asActivityRecord();
        WindowProcessController hostProcess = getOrganizerProcessIfDifferent(r);
        if (hostProcess == null) goto L5;
        hostProcess.removeEmbeddedActivity(r);
    L5:
        if (removeSelfIfPossible == true) goto L7;
        return;
    L7:
        if (shouldRemoveSelfOnLastChildRemoval() == true) goto L9;
        return;
    L9:
        if (hasChild() == true) goto L14;
        removeImmediately("removeLastChild " + child);
        return;
    }

    void remove(boolean withTransition, String reason) {
        if (hasChild() == true) goto L6;
        removeImmediately(reason);
        return;
    L6:
        this.mIsRemovalRequested = true;
        final ArrayList<ActivityRecord> removingActivities = new ArrayList();
        forAllActivities(new TaskFragment$$ExternalSyntheticLambda11(removingActivities));
        int i = removingActivities.size() - 1;
    L7:
        if (i < 0) goto L16;
        ActivityRecord r = removingActivities.get(i);
        if (withTransition == true) goto L11;
    L13:
        r.destroyIfPossible(reason);
    L14:
        i = i - 1;
        goto L7
    L11:
        if (r.isVisible() == false) goto L13;
        r.finishIfPossible(reason, false);
        goto L14
    }

    private static /* synthetic */ void lambda$remove$13(ArrayList removingActivities, ActivityRecord r) {
        if (r.finishing == true) goto L6;
        removingActivities.add(r);
        return;
    }

    void setDelayLastActivityRemoval(boolean delay) {
        if (this.mIsEmbedded == true) goto L5;
        Slog.w("ActivityTaskManager", "Set delaying last activity removal on a non-embedded TF.");
    L5:
        this.mDelayLastActivityRemoval = delay;
    }

    boolean isDelayLastActivityRemoval() {
        return this.mDelayLastActivityRemoval;
    }

    boolean shouldDeferRemoval() {
        if (hasChild() == true) goto L7;
        return false;
    L7:
        return isExitAnimationRunningSelfOrChild();
    }

    @Override // com.android.server.wm.WindowContainer
    boolean handleCompleteDeferredRemoval() {
        if (shouldDeferRemoval() == false) goto L7;
        return true;
    L7:
        return super.handleCompleteDeferredRemoval();
    }

    void removeImmediately(String reason) {
        Slog.d("ActivityTaskManager", "Remove task fragment: " + reason);
        removeImmediately();
    }

    @Override // com.android.server.wm.WindowContainer
    void removeImmediately() {
        if (asTask() != null) goto L5;
        EventLogTags.writeWmTfRemoved(System.identityHashCode(this), getTaskId());
    L5:
        boolean shouldExecuteAppTransition = false;
        this.mIsRemovalRequested = false;
        removeFromAdjacentTaskFragments();
        cleanUpEmbeddedTaskFragment();
        if (this.mClearedTaskFragmentForPip == true) goto L8;
    L11:
        super.removeImmediately();
        sendTaskFragmentVanished();
        if (shouldExecuteAppTransition == true) goto L14;
        return;
    L14:
        if (this.mDisplayContent == null) goto L18;
        this.mAtmService.addWindowLayoutReasons(2);
        this.mDisplayContent.executeAppTransition();
        return;
    L18:
        return;
    L8:
        if (isTaskVisibleRequested() == false) goto L11;
        shouldExecuteAppTransition = true;
        goto L11
    }

    private void cleanUpEmbeddedTaskFragment() {
        if (this.mIsEmbedded == true) goto L5;
        return;
    L5:
        this.mAtmService.mWindowOrganizerController.cleanUpEmbeddedTaskFragment(this);
        Task task = getTask();
        if (task != null) goto L8;
        return;
    L8:
        task.forAllLeafTaskFragments(new TaskFragment$$ExternalSyntheticLambda4(this), false);
    }

    private /* synthetic */ void lambda$cleanUpEmbeddedTaskFragment$14(TaskFragment taskFragment) {
        if (taskFragment.getCompanionTaskFragment() != this) goto L6;
        taskFragment.setCompanionTaskFragment(null);
        return;
    }

    boolean shouldBoostDimmer() {
        if (asTask() == null) goto L5;
    L18:
        return false;
    L5:
        if (isDimmingOnParentTask() == false) goto L18;
        if (hasAdjacentTaskFragment() == true) goto L10;
        return false;
    L10:
        final ArrayList<WindowContainer> siblings = getParent().mChildren;
        final int zOrder = siblings.indexOf(this);
        boolean hasAdjacentOnTop = forOtherAdjacentTaskFragments(new TaskFragment$$ExternalSyntheticLambda17(siblings, zOrder));
        if (hasAdjacentOnTop == true) goto L13;
        return false;
    L13:
        final ToBooleanFunction<WindowState> getDimBehindWindow = new TaskFragment$$ExternalSyntheticLambda18();
        boolean adjacentHasDimmingWindow = forOtherAdjacentTaskFragments(new TaskFragment$$ExternalSyntheticLambda19(getDimBehindWindow));
        if (adjacentHasDimmingWindow == false) goto L17;
        return false;
    L17:
        return forAllWindows(getDimBehindWindow, true);
    }

    private static /* synthetic */ boolean lambda$shouldBoostDimmer$15(ArrayList siblings, int zOrder, TaskFragment tf) {
        if (siblings.indexOf(tf) <= zOrder) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$shouldBoostDimmer$16(WindowState w) {
        if ((w.mAttrs.flags & 2) != 0) goto L5;
    L13:
        return false;
    L5:
        if (w.mActivityRecord == null) goto L13;
        if (w.mActivityRecord.isEmbedded() == false) goto L13;
        if (w.mActivityRecord.isVisibleRequested() == false) goto L11;
    L12:
        return true;
    L11:
        if (w.mActivityRecord.isVisible() == false) goto L13;
        goto L12
    }

    private static /* synthetic */ boolean lambda$shouldBoostDimmer$17(ToBooleanFunction getDimBehindWindow, TaskFragment tf) {
        return tf.forAllWindows(getDimBehindWindow, true);
    }

    @Override // com.android.server.wm.WindowContainer
    @Deprecated
    Dimmer getDimmer() {
        if (this.mIsEmbedded == false) goto L9;
        if (isDimmingOnParentTask() == true) goto L9;
        return this.mDimmer;
    L9:
        return super.getDimmer();
    }

    void getDimBounds(Rect out) {
        if (this.mDimmer.hasDimState() == false) goto L6;
        out.set(this.mDimmer.getDimBounds());
        return;
    L6:
        if (this.mIsEmbedded == true) goto L8;
    L12:
        out.set(getBounds());
        return;
    L8:
        if (isDimmingOnParentTask() == false) goto L12;
        if (getDimmer().getDimBounds() == null) goto L12;
        out.set(getTask().getBounds());
    }

    void setEmbeddedDimArea(int embeddedDimArea) {
        this.mEmbeddedDimArea = embeddedDimArea;
    }

    void setMoveToBottomIfClearWhenLaunch(boolean moveToBottomIfClearWhenLaunch) {
        this.mMoveToBottomIfClearWhenLaunch = moveToBottomIfClearWhenLaunch;
    }

    boolean isMoveToBottomIfClearWhenLaunch() {
        return this.mMoveToBottomIfClearWhenLaunch;
    }

    boolean isDimmingOnParentTask() {
        if (this.mEmbeddedDimArea == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    void prepareSurfaces() {
        if (asTask() == null) goto L6;
        super.prepareSurfaces();
        return;
    L6:
        this.mDimmer.resetDimStates();
        super.prepareSurfaces();
        if (this.mDimmer.updateDims(getSyncTransaction()) == false) goto L10;
        scheduleAnimation();
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean fillsParent() {
        if (getWindowingMode() != 1) goto L5;
        return true;
    L5:
        if (matchParentBounds() == true) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    protected boolean onChildVisibleRequestedChanged(WindowContainer child) {
        if (super.onChildVisibleRequestedChanged(child) == true) goto L6;
        return false;
    L6:
        sendTaskFragmentInfoChanged();
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    TaskFragment getTaskFragment(Predicate<TaskFragment> callback) {
        TaskFragment taskFragment = super.getTaskFragment(callback);
        if (taskFragment == null) goto L6;
        return taskFragment;
    L6:
        if (callback.test(this) == true) goto L10;
        return null;
    L10:
        return this;
    }

    boolean moveChildToFront(WindowContainer newTop) {
        int origDist = getDistanceFromTop(newTop);
        positionChildAt(Integer.MAX_VALUE, newTop, false);
        if (getDistanceFromTop(newTop) == origDist) goto L6;
        return true;
    L6:
        return false;
    }

    String toFullString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.setLength(sb.length() - 1);
        if (this.mTaskFragmentOrganizerUid == (-1)) goto L6;
        sb.append(" organizerUid=");
        sb.append(this.mTaskFragmentOrganizerUid);
    L6:
        if (this.mTaskFragmentOrganizerProcessName == null) goto L9;
        sb.append(" organizerProc=");
        sb.append(this.mTaskFragmentOrganizerProcessName);
    L9:
        if (this.mAdjacentTaskFragments == null) goto L11;
        sb.append(" adjacent=");
        sb.append(this.mAdjacentTaskFragments);
    L11:
        sb.append('}');
        return sb.toString();
    }

    public String toString() {
        return "TaskFragment{" + Integer.toHexString(System.identityHashCode(this)) + " mode=" + WindowConfiguration.windowingModeToString(getWindowingMode()) + "}";
    }

    boolean dump(final String prefix, FileDescriptor fd, final PrintWriter pw, final boolean dumpAll, boolean dumpClient, final String dumpPackage, final boolean needSep, final Runnable header) {
        boolean printed = false;
        Runnable headerPrinter = new TaskFragment$$ExternalSyntheticLambda3(this, needSep, pw, header, prefix, dumpAll, dumpPackage);
        if (dumpPackage != null) goto L5;
        headerPrinter.run();
        printed = true;
        Runnable headerPrinter2 = null;
    L6:
        int i = this.mChildren.size() - 1;
    L7:
        if (i < 0) goto L17;
        WindowContainer child = (WindowContainer) this.mChildren.get(i);
        if (child.asTaskFragment() == null) goto L12;
        int i2 = i;
        printed = child.asTaskFragment().dump(prefix + "  ", fd, pw, dumpAll, dumpClient, dumpPackage, needSep, headerPrinter2) | printed;
    L15:
        i = i2 - 1;
        goto L7
    L12:
        if (child.asActivityRecord() == null) goto L14;
        i2 = i;
        Runnable headerPrinter3 = headerPrinter2;
        ActivityRecord.dumpActivity(fd, pw, i2, child.asActivityRecord(), prefix + "  ", "Hist ", true, !dumpAll, dumpClient, dumpPackage, false, headerPrinter3, getTask());
        headerPrinter2 = headerPrinter3;
        goto L15
    L14:
        i2 = i;
        goto L15
    L17:
        return printed;
    L5:
        headerPrinter2 = headerPrinter;
        goto L6
    }

    private /* synthetic */ void lambda$dump$18(boolean needSep, PrintWriter pw, Runnable header, String prefix, boolean dumpAll, String dumpPackage) {
        if (needSep == false) goto L4;
        pw.println();
    L4:
        if (header == null) goto L6;
        header.run();
    L6:
        dumpInner(prefix, pw, dumpAll, dumpPackage);
    }

    void dumpInner(String prefix, PrintWriter pw, boolean dumpAll, String dumpPackage) {
        pw.print(prefix);
        pw.print("* ");
        pw.println(toFullString());
        Rect bounds = getRequestedOverrideBounds();
        if (bounds.isEmpty() == true) goto L6;
        pw.println(prefix + "  mBounds=" + bounds);
    L6:
        if (this.mIsRemovalRequested == false) goto L8;
        pw.println(prefix + "  mIsRemovalRequested=true");
    L8:
        if (dumpAll == false) goto L11;
        ActivityTaskSupervisor.printThisActivity(pw, this.mLastPausedActivity, dumpPackage, false, prefix + "  mLastPausedActivity: ", null);
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    void dump(PrintWriter pw, String prefix, boolean dumpAll) {
        super.dump(pw, prefix, dumpAll);
        StringBuilder r0 = new StringBuilder();
        r0.append(prefix);
        r0.append("bounds=");
        r0.append(getBounds().toShortString());
        if (this.mIsolatedNav == false) goto L5;
        String r1 = ", isolatedNav";
    L6:
        r0.append(r1);
        pw.println(r0.toString());
        String doublePrefix = prefix + "  ";
        int i = this.mChildren.size() - 1;
    L7:
        if (i < 0) goto L17;
        WindowContainer<?> child = (WindowContainer) this.mChildren.get(i);
        TaskFragment tf = child.asTaskFragment();
        StringBuilder r4 = new StringBuilder();
        r4.append(prefix);
        r4.append("* ");
        if (tf == null) goto L11;
        Object r5 = tf.toFullString();
    L12:
        r4.append(r5);
        pw.println(r4.toString());
        if (tf == null) goto L15;
        child.dump(pw, doublePrefix, dumpAll);
    L15:
        i = i - 1;
        goto L7
    L11:
        r5 = child;
        goto L12
    L17:
        return;
    L5:
        r1 = "";
        goto L6
    }

    @Override // com.android.server.wm.WindowContainer
    void writeIdentifierToProto(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, System.identityHashCode(this));
        ActivityRecord topActivity = topRunningActivity();
        if (topActivity == null) goto L5;
        int r3 = topActivity.mUserId;
    L6:
        proto.write(1120986464258L, r3);
        if (topActivity == null) goto L9;
        String r4 = topActivity.intent.getComponent().flattenToShortString();
    L10:
        proto.write(1138166333443L, r4);
        proto.end(token);
        return;
    L9:
        r4 = "TaskFragment";
        goto L10
    L5:
        r3 = ProcessList.INVALID_ADJ;
        goto L6
    }

    @Override // com.android.server.wm.WindowContainer
    long getProtoFieldId() {
        return 1146756268041L;
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public void dumpDebug(ProtoOutputStream proto, long fieldId, int logLevel) {
        if (logLevel == 2) goto L5;
    L7:
        long token = proto.start(fieldId);
        super.dumpDebug(proto, 1146756268033L, logLevel);
        proto.write(1120986464258L, getDisplayId());
        proto.write(1120986464259L, getActivityType());
        proto.write(1120986464260L, this.mMinWidth);
        proto.write(1120986464261L, this.mMinHeight);
        proto.end(token);
        return;
    L5:
        if (isVisible() == true) goto L7;
    }
}
