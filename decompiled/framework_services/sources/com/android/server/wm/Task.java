package com.android.server.wm;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.ActivityTaskManager;
import android.app.AppGlobals;
import android.app.IActivityController;
import android.app.IApplicationThread;
import android.app.PictureInPictureParams;
import android.app.SysMonitorFwBridge;
import android.app.TaskInfo;
import android.app.WindowConfiguration;
import android.content.ComponentName;
import android.content.Intent;
import android.content.LocusId;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.res.Configuration;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.tv.mediaquality.ParameterName;
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
import android.pico.utils.ExtImplFactory;
import android.pico.utils.Features;
import android.provider.Settings;
import android.service.voice.IVoiceInteractionSession;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.view.DisplayInfo;
import android.view.InsetsState;
import android.view.SurfaceControl;
import android.view.WindowInsets;
import android.window.DesktopExperienceFlags;
import android.window.DesktopModeFlags;
import android.window.ITaskOrganizer;
import android.window.PictureInPictureSurfaceTransaction;
import android.window.StartingWindowInfo;
import android.window.TaskFragmentParentInfo;
import android.window.TaskSnapshot;
import android.window.WindowContainerToken;
import com.android.internal.app.IVoiceInteractor;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.XmlUtils;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.internal.util.function.pooled.PooledPredicate;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.Watchdog;
import com.android.server.am.ActivityManagerService;
import com.android.server.am.AppTimeTracker;
import com.android.server.am.IZswContentProviderHelper;
import com.android.server.common.Constants;
import com.android.server.uri.NeededUriGrants;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
class Task extends TaskFragment {
    private static final String ATTR_AFFINITY = "affinity";
    private static final String ATTR_AUTOREMOVERECENTS = "auto_remove_recents";
    private static final String ATTR_CALLING_FEATURE_ID = "calling_feature_id";
    private static final String ATTR_CALLING_PACKAGE = "calling_package";
    private static final String ATTR_CALLING_UID = "calling_uid";
    private static final String ATTR_EFFECTIVE_UID = "effective_uid";
    private static final String ATTR_LASTDESCRIPTION = "last_description";
    private static final String ATTR_LASTTIMEMOVED = "last_time_moved";
    private static final String ATTR_MIN_HEIGHT = "min_height";
    private static final String ATTR_MIN_WIDTH = "min_width";
    private static final String ATTR_NEVERRELINQUISH = "never_relinquish_identity";
    private static final String ATTR_NEXT_AFFILIATION = "next_affiliation";
    private static final String ATTR_NON_FULLSCREEN_BOUNDS = "non_fullscreen_bounds";
    private static final String ATTR_ORIGACTIVITY = "orig_activity";
    private static final String ATTR_PERSIST_TASK_VERSION = "persist_task_version";
    private static final String ATTR_PREV_AFFILIATION = "prev_affiliation";
    private static final String ATTR_REALACTIVITY = "real_activity";
    private static final String ATTR_REALACTIVITY_SUSPENDED = "real_activity_suspended";
    private static final String ATTR_RESIZE_MODE = "resize_mode";
    private static final String ATTR_ROOTHASRESET = "root_has_reset";
    private static final String ATTR_ROOT_AFFINITY = "root_affinity";
    private static final String ATTR_SUPPORTS_PICTURE_IN_PICTURE = "supports_picture_in_picture";
    private static final String ATTR_TASKID = "task_id";

    @Deprecated
    private static final String ATTR_TASKTYPE = "task_type";
    private static final String ATTR_TASK_AFFILIATION = "task_affiliation";
    private static final String ATTR_USERID = "user_id";
    private static final String ATTR_USER_SETUP_COMPLETE = "user_setup_complete";
    private static final String ATTR_WINDOW_LAYOUT_AFFINITY = "window_layout_affinity";
    private static final int DEFAULT_MIN_TASK_SIZE_DP = 220;
    static final int LAYER_RANK_INVISIBLE = -1;
    static final int PERSIST_TASK_VERSION = 1;
    static final int REPARENT_KEEP_ROOT_TASK_AT_FRONT = 1;
    static final int REPARENT_LEAVE_ROOT_TASK_IN_PLACE = 2;
    static final int REPARENT_MOVE_ROOT_TASK_TO_FRONT = 0;
    private static final String TAG = "ActivityTaskManager";
    private static final String TAG_ACTIVITY = "activity";
    private static final String TAG_AFFINITYINTENT = "affinity_intent";
    static final String TAG_CLEANUP = "ActivityTaskManager";
    private static final String TAG_INTENT = "intent";
    private static final String TAG_RECENTS = "ActivityTaskManager";
    private static final String TAG_SWITCH = "ActivityTaskManager";
    static final String TAG_TASKS = "ActivityTaskManager";
    private static final String TAG_TRANSITION = "ActivityTaskManager";
    private static final String TAG_USER_LEAVING = "ActivityTaskManager";
    static final String TAG_VISIBILITY = "ActivityTaskManager";
    private static final long TRANSLUCENT_CONVERSION_TIMEOUT = 2000;
    private static final int TRANSLUCENT_TIMEOUT_MSG = 101;
    private static final ActivityPluginDelegate mQtiActivityPluginDelegate = null;
    private static final ResetTargetTaskHelper sResetTargetTaskHelper = null;
    private static Exception sTmpException;
    String affinity;
    Intent affinityIntent;
    boolean autoRemoveRecents;
    int effectiveUid;
    boolean inRecents;
    Intent intent;
    boolean isAvailable;
    boolean isPersistable;
    long lastActiveTime;
    CharSequence lastDescription;
    int mAffiliatedTaskId;
    boolean mAlignActivityLocaleWithTask;
    String mCallingFeatureId;
    String mCallingPackage;
    int mCallingUid;
    ActivityRecord mChildPipActivity;
    boolean mConfigWillChange;
    int mCurrentUser;
    DecorSurfaceContainer mDecorSurfaceContainer;
    private boolean mDeferTaskAppear;
    private boolean mDragResizing;
    private IExtTask mExt;
    private final FindRootHelper mFindRootHelper;
    private boolean mForceExcludedFromRecents;
    private boolean mForceNonResizeOverride;
    private boolean mForceResizeOverride;
    private boolean mForceShowForAllUsers;
    private final Handler mHandler;
    private boolean mHasBeenVisible;
    boolean mInRemoveTask;
    boolean mInResumeTopActivity;
    boolean mIsEffectivelySystemApp;
    boolean mIsPerceptible;
    boolean mIsTrimmableFromRecents;
    boolean mKillProcessesOnDestroyed;
    Rect mLastNonFullscreenBounds;
    SurfaceControl mLastRecentsAnimationOverlay;
    PictureInPictureSurfaceTransaction mLastRecentsAnimationTransaction;
    int mLastReportedRequestedOrientation;
    boolean mLastSurfaceShowing;
    long mLastTimeMoved;
    private boolean mLaunchAdjacentDisabled;
    IBinder mLaunchCookie;
    int mLayerRank;
    int mLockTaskAuth;
    int mLockTaskUid;
    WindowContainerToken mMultiWindowRestoreParent;
    int mMultiWindowRestoreWindowingMode;
    private boolean mNeverRelinquishIdentity;
    Task mNextAffiliate;
    int mNextAffiliateTaskId;
    int mNonOccludedFreeformAreaRatio;
    int mOffsetXForInsets;
    int mOffsetYForInsets;
    private ActivityRecord mPendingConvertFromTranslucentActivity;
    Task mPrevAffiliate;
    int mPrevAffiliateTaskId;
    int mPrevDisplayId;
    boolean mRemoveWithTaskOrganizer;
    private boolean mRemoving;
    boolean mReparentLeafTaskIfRelaunch;
    String mRequiredDisplayCategory;
    int mResizeMode;
    private boolean mReuseTask;
    private WindowProcessController mRootProcess;
    StartingData mSharedStartingData;
    boolean mSupportsPictureInPicture;
    boolean mTaskAppearedSent;
    private ActivityManager.TaskDescription mTaskDescription;
    String mTaskFragmentHostProcessName;
    int mTaskFragmentHostUid;
    final int mTaskId;
    ITaskOrganizer mTaskOrganizer;
    private final TaskSmtBase mTaskSmtBase;
    private final Rect mTmpRect;
    ActivityRecord mTranslucentActivityWaiting;
    ArrayList<ActivityRecord> mUndrawnActivitiesBelowTopTranslucent;
    int mUserId;
    boolean mUserSetupComplete;
    String mWindowLayoutAffinity;
    int maxRecents;
    ComponentName origActivity;
    public int prefetchState;
    ComponentName realActivity;
    boolean realActivitySuspended;
    String rootAffinity;
    boolean rootWasReset;
    String stringName;
    IVoiceInteractor voiceInteractor;
    IVoiceInteractionSession voiceSession;

    private class ActivityTaskHandler extends Handler {
        final /* synthetic */ Task this$0;

        ActivityTaskHandler(Task r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 101: goto L5;
                default: goto L17;
            };
        L5:
            WindowManagerGlobalLock r0 = this.this$0.mAtmService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.notifyActivityDrawnLocked(null);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L11:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    static class Builder {
        private ActivityInfo mActivityInfo;
        private ActivityOptions mActivityOptions;
        private int mActivityType;
        private String mAffinity;
        private Intent mAffinityIntent;
        private final ActivityTaskManagerService mAtmService;
        private boolean mAutoRemoveRecents;
        private String mCallingFeatureId;
        private String mCallingPackage;
        private int mCallingUid;
        private boolean mCreatedByOrganizer;
        private boolean mDeferTaskAppear;
        private int mEffectiveUid;
        private boolean mHasBeenVisible;
        private Intent mIntent;
        private String mLastDescription;
        private ActivityManager.TaskDescription mLastTaskDescription;
        private long mLastTimeMoved;
        private IBinder mLaunchCookie;
        private int mLaunchFlags;
        private int mMinHeight;
        private int mMinWidth;
        private boolean mNeverRelinquishIdentity;
        private int mNextAffiliateTaskId;
        private boolean mOnTop;
        private ComponentName mOrigActivity;
        private WindowContainer mParent;
        private int mPrevAffiliateTaskId;
        private ComponentName mRealActivity;
        private boolean mRealActivitySuspended;
        private boolean mRemoveWithTaskOrganizer;
        private int mResizeMode;
        private String mRootAffinity;
        private boolean mRootWasReset;
        private Task mSourceTask;
        private boolean mSupportsPictureInPicture;
        private int mTaskAffiliation;
        private int mTaskId;
        private int mUserId;
        private boolean mUserSetupComplete;
        private IVoiceInteractor mVoiceInteractor;
        private IVoiceInteractionSession mVoiceSession;
        private int mWindowingMode;

        /* JADX INFO: renamed from: -$$Nest$msetAffinity, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10191$$Nest$msetAffinity(Builder r0, String r1) {
            return r0.setAffinity(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetAffinityIntent, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10192$$Nest$msetAffinityIntent(Builder r0, Intent r1) {
            return r0.setAffinityIntent(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetAutoRemoveRecents, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10193$$Nest$msetAutoRemoveRecents(Builder r0, boolean r1) {
            return r0.setAutoRemoveRecents(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetCallingFeatureId, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10194$$Nest$msetCallingFeatureId(Builder r0, String r1) {
            return r0.setCallingFeatureId(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetCallingPackage, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10195$$Nest$msetCallingPackage(Builder r0, String r1) {
            return r0.setCallingPackage(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetCallingUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10196$$Nest$msetCallingUid(Builder r0, int r1) {
            return r0.setCallingUid(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetLastDescription, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10197$$Nest$msetLastDescription(Builder r0, String r1) {
            return r0.setLastDescription(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetLastTaskDescription, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10198$$Nest$msetLastTaskDescription(Builder r0, ActivityManager.TaskDescription r1) {
            return r0.setLastTaskDescription(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetLastTimeMoved, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10199$$Nest$msetLastTimeMoved(Builder r0, long r1) {
            return r0.setLastTimeMoved(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetNeverRelinquishIdentity, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10200$$Nest$msetNeverRelinquishIdentity(Builder r0, boolean r1) {
            return r0.setNeverRelinquishIdentity(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetNextAffiliateTaskId, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10201$$Nest$msetNextAffiliateTaskId(Builder r0, int r1) {
            return r0.setNextAffiliateTaskId(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetOrigActivity, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10202$$Nest$msetOrigActivity(Builder r0, ComponentName r1) {
            return r0.setOrigActivity(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetPrevAffiliateTaskId, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10203$$Nest$msetPrevAffiliateTaskId(Builder r0, int r1) {
            return r0.setPrevAffiliateTaskId(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetRealActivitySuspended, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10204$$Nest$msetRealActivitySuspended(Builder r0, boolean r1) {
            return r0.setRealActivitySuspended(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetResizeMode, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10205$$Nest$msetResizeMode(Builder r0, int r1) {
            return r0.setResizeMode(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetRootAffinity, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10206$$Nest$msetRootAffinity(Builder r0, String r1) {
            return r0.setRootAffinity(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetRootWasReset, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10207$$Nest$msetRootWasReset(Builder r0, boolean r1) {
            return r0.setRootWasReset(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetSupportsPictureInPicture, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10208$$Nest$msetSupportsPictureInPicture(Builder r0, boolean r1) {
            return r0.setSupportsPictureInPicture(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetTaskAffiliation, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10209$$Nest$msetTaskAffiliation(Builder r0, int r1) {
            return r0.setTaskAffiliation(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetUserId, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10210$$Nest$msetUserId(Builder r0, int r1) {
            return r0.setUserId(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetUserSetupComplete, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10211$$Nest$msetUserSetupComplete(Builder r0, boolean r1) {
            return r0.setUserSetupComplete(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetVoiceInteractor, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m10212$$Nest$msetVoiceInteractor(Builder r0, IVoiceInteractor r1) {
            return r0.setVoiceInteractor(r1);
        }

        Builder(ActivityTaskManagerService atm) {
            this.mPrevAffiliateTaskId = -1;
            this.mNextAffiliateTaskId = -1;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mWindowingMode = 0;
            this.mAtmService = atm;
        }

        Builder setParent(WindowContainer parent) {
            this.mParent = parent;
            return this;
        }

        Builder setSourceTask(Task sourceTask) {
            this.mSourceTask = sourceTask;
            return this;
        }

        Builder setLaunchFlags(int launchFlags) {
            this.mLaunchFlags = launchFlags;
            return this;
        }

        Builder setTaskId(int taskId) {
            this.mTaskId = taskId;
            return this;
        }

        Builder setIntent(Intent intent) {
            this.mIntent = intent;
            return this;
        }

        Builder setRealActivity(ComponentName realActivity) {
            this.mRealActivity = realActivity;
            return this;
        }

        Builder setEffectiveUid(int effectiveUid) {
            this.mEffectiveUid = effectiveUid;
            return this;
        }

        Builder setMinWidth(int minWidth) {
            this.mMinWidth = minWidth;
            return this;
        }

        Builder setMinHeight(int minHeight) {
            this.mMinHeight = minHeight;
            return this;
        }

        Builder setActivityInfo(ActivityInfo info) {
            this.mActivityInfo = info;
            return this;
        }

        Builder setActivityOptions(ActivityOptions opts) {
            this.mActivityOptions = opts;
            return this;
        }

        Builder setVoiceSession(IVoiceInteractionSession voiceSession) {
            this.mVoiceSession = voiceSession;
            return this;
        }

        Builder setActivityType(int activityType) {
            this.mActivityType = activityType;
            return this;
        }

        int getActivityType() {
            return this.mActivityType;
        }

        Builder setWindowingMode(int windowingMode) {
            this.mWindowingMode = windowingMode;
            return this;
        }

        int getWindowingMode() {
            return this.mWindowingMode;
        }

        Builder setCreatedByOrganizer(boolean createdByOrganizer) {
            this.mCreatedByOrganizer = createdByOrganizer;
            return this;
        }

        boolean getCreatedByOrganizer() {
            return this.mCreatedByOrganizer;
        }

        Builder setDeferTaskAppear(boolean defer) {
            this.mDeferTaskAppear = defer;
            return this;
        }

        Builder setLaunchCookie(IBinder launchCookie) {
            this.mLaunchCookie = launchCookie;
            return this;
        }

        Builder setOnTop(boolean onTop) {
            this.mOnTop = onTop;
            return this;
        }

        Builder setHasBeenVisible(boolean hasBeenVisible) {
            this.mHasBeenVisible = hasBeenVisible;
            return this;
        }

        Builder setRemoveWithTaskOrganizer(boolean removeWithTaskOrganizer) {
            this.mRemoveWithTaskOrganizer = removeWithTaskOrganizer;
            return this;
        }

        private Builder setUserId(int userId) {
            this.mUserId = userId;
            return this;
        }

        private Builder setLastTimeMoved(long lastTimeMoved) {
            this.mLastTimeMoved = lastTimeMoved;
            return this;
        }

        private Builder setNeverRelinquishIdentity(boolean neverRelinquishIdentity) {
            this.mNeverRelinquishIdentity = neverRelinquishIdentity;
            return this;
        }

        private Builder setCallingUid(int callingUid) {
            this.mCallingUid = callingUid;
            return this;
        }

        private Builder setCallingPackage(String callingPackage) {
            this.mCallingPackage = callingPackage;
            return this;
        }

        private Builder setResizeMode(int resizeMode) {
            this.mResizeMode = resizeMode;
            return this;
        }

        private Builder setSupportsPictureInPicture(boolean supportsPictureInPicture) {
            this.mSupportsPictureInPicture = supportsPictureInPicture;
            return this;
        }

        private Builder setUserSetupComplete(boolean userSetupComplete) {
            this.mUserSetupComplete = userSetupComplete;
            return this;
        }

        private Builder setTaskAffiliation(int taskAffiliation) {
            this.mTaskAffiliation = taskAffiliation;
            return this;
        }

        private Builder setPrevAffiliateTaskId(int prevAffiliateTaskId) {
            this.mPrevAffiliateTaskId = prevAffiliateTaskId;
            return this;
        }

        private Builder setNextAffiliateTaskId(int nextAffiliateTaskId) {
            this.mNextAffiliateTaskId = nextAffiliateTaskId;
            return this;
        }

        private Builder setCallingFeatureId(String callingFeatureId) {
            this.mCallingFeatureId = callingFeatureId;
            return this;
        }

        private Builder setRealActivitySuspended(boolean realActivitySuspended) {
            this.mRealActivitySuspended = realActivitySuspended;
            return this;
        }

        private Builder setLastDescription(String lastDescription) {
            this.mLastDescription = lastDescription;
            return this;
        }

        private Builder setLastTaskDescription(ActivityManager.TaskDescription lastTaskDescription) {
            this.mLastTaskDescription = lastTaskDescription;
            return this;
        }

        private Builder setOrigActivity(ComponentName origActivity) {
            this.mOrigActivity = origActivity;
            return this;
        }

        private Builder setRootWasReset(boolean rootWasReset) {
            this.mRootWasReset = rootWasReset;
            return this;
        }

        private Builder setAutoRemoveRecents(boolean autoRemoveRecents) {
            this.mAutoRemoveRecents = autoRemoveRecents;
            return this;
        }

        private Builder setAffinityIntent(Intent affinityIntent) {
            this.mAffinityIntent = affinityIntent;
            return this;
        }

        private Builder setAffinity(String affinity) {
            this.mAffinity = affinity;
            return this;
        }

        private Builder setRootAffinity(String rootAffinity) {
            this.mRootAffinity = rootAffinity;
            return this;
        }

        private Builder setVoiceInteractor(IVoiceInteractor voiceInteractor) {
            this.mVoiceInteractor = voiceInteractor;
            return this;
        }

        private void validateRootTask(TaskDisplayArea tda) {
            if (this.mActivityType != 0) goto L8;
            if (this.mCreatedByOrganizer == true) goto L8;
            this.mActivityType = 1;
        L8:
            if (DisplayContent.alwaysCreateRootTask(tda.getWindowingMode(), this.mActivityType) == true) goto L17;
            if (this.mActivityType == 0) goto L17;
            Task rootTask = tda.getRootTask(0, this.mActivityType);
            if (rootTask == null) goto L17;
            throw new IllegalArgumentException("Root task=" + rootTask + " of activityType=" + this.mActivityType + " already on display=" + tda + ". Can't have multiple.");
        L17:
            if (TaskDisplayArea.isWindowingModeSupported(this.mWindowingMode, this.mAtmService.mSupportsMultiWindow, this.mAtmService.mSupportsFreeformWindowManagement, this.mAtmService.mSupportsPictureInPicture) == false) goto L42;
            if (this.mWindowingMode != 2) goto L26;
            if (this.mActivityType == 1) goto L26;
            throw new IllegalArgumentException("Root task with pinned windowing mode cannot with non-standard activity type.");
        L26:
            if (this.mWindowingMode != 2) goto L31;
            if (tda.getRootPinnedTask() == null) goto L31;
            tda.getRootPinnedTask().dismissPip();
        L31:
            if (this.mIntent == null) goto L34;
            this.mLaunchFlags |= this.mIntent.getFlags();
        L34:
            if (this.mCreatedByOrganizer == false) goto L36;
            Task launchRootTask = null;
            TaskDisplayArea tda2 = tda;
        L37:
            if (launchRootTask == null) goto L39;
            this.mWindowingMode = 0;
            this.mParent = launchRootTask;
        L39:
            this.mTaskId = tda2.getNextRootTaskId();
            return;
        L36:
            tda2 = tda;
            launchRootTask = tda2.getLaunchRootTask(this.mWindowingMode, this.mActivityType, this.mActivityOptions, this.mSourceTask, this.mLaunchFlags);
            goto L37
        L42:
            throw new IllegalArgumentException("Can't create root task for unsupported windowingMode=" + this.mWindowingMode);
        }

        Task build() {
            if (this.mParent == null) goto L8;
            if ((this.mParent instanceof TaskDisplayArea) == false) goto L8;
            validateRootTask((TaskDisplayArea) this.mParent);
        L8:
            if (this.mActivityInfo != null) goto L10;
            this.mActivityInfo = new ActivityInfo();
            this.mActivityInfo.applicationInfo = new ApplicationInfo();
        L10:
            this.mUserId = UserHandle.getUserId(this.mActivityInfo.applicationInfo.uid);
            this.mTaskAffiliation = this.mTaskId;
            this.mLastTimeMoved = System.currentTimeMillis();
            this.mNeverRelinquishIdentity = true;
            this.mCallingUid = this.mActivityInfo.applicationInfo.uid;
            this.mCallingPackage = this.mActivityInfo.packageName;
            this.mResizeMode = this.mActivityInfo.resizeMode;
            this.mSupportsPictureInPicture = this.mActivityInfo.supportsPictureInPicture();
            if (this.mRemoveWithTaskOrganizer == false) goto L13;
        L15:
            Task task = buildInner();
            Task.m10188$$Nest$fputmHasBeenVisible(task, this.mHasBeenVisible);
            if (this.mActivityType == 0) goto L19;
            task.setActivityType(this.mActivityType);
        L19:
            if (this.mParent == null) goto L35;
            int r3 = Integer.MIN_VALUE;
            if ((this.mParent instanceof Task) == false) goto L30;
            Task parentTask = (Task) this.mParent;
            if (this.mOnTop == false) goto L26;
            r3 = Integer.MAX_VALUE;
        L26:
            if ((this.mActivityInfo.flags & 1024) == 0) goto L28;
            boolean r4 = true;
        L29:
            Task.m10189$$Nest$maddChild(parentTask, task, r3, r4);
            goto L35
        L28:
            r4 = false;
            goto L29
        L30:
            WindowContainer r2 = this.mParent;
            if (this.mOnTop == false) goto L33;
            r3 = Integer.MAX_VALUE;
        L33:
            r2.addChild(task, r3);
        L35:
            if (this.mWindowingMode == 0) goto L37;
            Task.m10190$$Nest$msetWindowingModeInner(task, this.mWindowingMode, true);
        L37:
            return task;
        L13:
            if (this.mActivityOptions == null) goto L15;
            this.mRemoveWithTaskOrganizer = this.mActivityOptions.getRemoveWithTaskOranizer();
            goto L15
        }

        Task buildInner() {
            return new Task(this.mAtmService, this.mTaskId, this.mIntent, this.mAffinityIntent, this.mAffinity, this.mRootAffinity, this.mRealActivity, this.mOrigActivity, this.mRootWasReset, this.mAutoRemoveRecents, this.mUserId, this.mEffectiveUid, this.mLastDescription, this.mLastTimeMoved, this.mNeverRelinquishIdentity, this.mLastTaskDescription, this.mTaskAffiliation, this.mPrevAffiliateTaskId, this.mNextAffiliateTaskId, this.mCallingUid, this.mCallingPackage, this.mCallingFeatureId, this.mResizeMode, this.mSupportsPictureInPicture, this.mRealActivitySuspended, this.mUserSetupComplete, this.mMinWidth, this.mMinHeight, this.mActivityInfo, this.mVoiceSession, this.mVoiceInteractor, this.mCreatedByOrganizer, this.mLaunchCookie, this.mDeferTaskAppear, this.mRemoveWithTaskOrganizer, null);
        }
    }

    class DecorSurfaceContainer {
        final SurfaceControl mContainerSurface;
        final SurfaceControl mDecorSurface;
        private boolean mIsBoosted;
        private boolean mIsBoostedRequested;
        TaskFragment mOwnerTaskFragment;
        private final List<SurfaceControl.Transaction> mPendingClientTransactions;
        final /* synthetic */ Task this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmIsBoosted, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10213$$Nest$fgetmIsBoosted(DecorSurfaceContainer r0) {
            return r0.mIsBoosted;
        }

        /* JADX INFO: renamed from: -$$Nest$massignLayer, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10214$$Nest$massignLayer(DecorSurfaceContainer r0, SurfaceControl.Transaction r1, int r2) {
            r0.assignLayer(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mcommitBoostedState, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10215$$Nest$mcommitBoostedState(DecorSurfaceContainer r0) {
            r0.commitBoostedState();
        }

        /* JADX INFO: renamed from: -$$Nest$mrelease, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10216$$Nest$mrelease(DecorSurfaceContainer r0) {
            r0.release();
        }

        /* JADX INFO: renamed from: -$$Nest$mrequestBoosted, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10217$$Nest$mrequestBoosted(DecorSurfaceContainer r0, boolean r1, SurfaceControl.Transaction r2) {
            r0.requestBoosted(r1, r2);
        }

        /* synthetic */ DecorSurfaceContainer(Task r1, TaskFragment r2, boolean r3, TaskIA r4) {
            this(r1, r2, r3);
        }

        private DecorSurfaceContainer(Task this$0, TaskFragment initialOwner, boolean visible) {
            this.this$0 = this$0;
            this.mPendingClientTransactions = new ArrayList();
            this.mOwnerTaskFragment = initialOwner;
            this.mContainerSurface = this$0.makeSurface().setContainerLayer().setParent(this$0.mSurfaceControl).setName(this$0.mSurfaceControl + " - decor surface container").setContainerLayer().setHidden(false).setCallsite("Task.DecorSurfaceContainer").build();
            this.mDecorSurface = this$0.makeSurface().setParent(this.mContainerSurface).setName(this$0.mSurfaceControl + " - decor surface").setHidden(!visible).setCallsite("Task.DecorSurfaceContainer").build();
        }

        private void requestBoosted(boolean isBoosted, SurfaceControl.Transaction clientTransaction) {
            this.mIsBoostedRequested = isBoosted;
            if (clientTransaction == null) goto L6;
            this.mPendingClientTransactions.add(clientTransaction);
            return;
        }

        private void commitBoostedState() {
            this.mIsBoosted = this.mIsBoostedRequested;
            applyPendingClientTransactions(this.this$0.getSyncTransaction());
        }

        private void assignLayer(SurfaceControl.Transaction t, int layer) {
            t.setLayer(this.mContainerSurface, layer);
            SurfaceControl r0 = this.mContainerSurface;
            if (this.mOwnerTaskFragment.isVisible() == false) goto L5;
        L8:
            boolean r1 = true;
        L9:
            t.setVisibility(r0, r1);
            return;
        L5:
            if (this.mIsBoosted == true) goto L8;
            r1 = false;
            goto L9
        }

        private void applyPendingClientTransactions(SurfaceControl.Transaction t) {
            int i = 0;
        L4:
            if (i >= this.mPendingClientTransactions.size()) goto L6;
            t.merge(this.mPendingClientTransactions.get(i));
            i = i + 1;
            goto L4
        L6:
            this.mPendingClientTransactions.clear();
        }

        private void release() {
            this.this$0.getSyncTransaction().remove(this.mDecorSurface).remove(this.mContainerSurface);
        }
    }

    private class FindRootHelper implements Predicate<ActivityRecord> {
        private boolean mIgnoreRelinquishIdentity;
        private ActivityRecord mRoot;
        private boolean mSetToBottomIfNone;
        final /* synthetic */ Task this$0;

        /* synthetic */ FindRootHelper(Task r1, TaskIA r2) {
            this(r1);
        }

        private FindRootHelper(Task r1) {
            this.this$0 = r1;
        }

        @Override // java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(ActivityRecord r1) {
            return test2(r1);
        }

        ActivityRecord findRoot(boolean ignoreRelinquishIdentity, boolean setToBottomIfNone) {
            this.mIgnoreRelinquishIdentity = ignoreRelinquishIdentity;
            this.mSetToBottomIfNone = setToBottomIfNone;
            this.this$0.forAllActivities(this, false);
            ActivityRecord root = this.mRoot;
            this.mRoot = null;
            return root;
        }

        /* JADX INFO: renamed from: test, reason: avoid collision after fix types in other method */
        public boolean test2(ActivityRecord r) {
            if (this.mRoot != null) goto L8;
            if (this.mSetToBottomIfNone == false) goto L8;
            this.mRoot = r;
        L8:
            if (r.finishing == false) goto L11;
            return false;
        L11:
            if (this.mRoot != null) goto L13;
        L14:
            this.mRoot = r;
        L16:
            if (this.mRoot != r) goto L18;
            int uid = this.this$0.effectiveUid;
        L20:
            if (this.mIgnoreRelinquishIdentity == false) goto L22;
            return true;
        L22:
            if ((this.mRoot.info.flags & 4096) != 0) goto L24;
            return true;
        L24:
            if (this.mRoot.info.applicationInfo.uid != 1000) goto L26;
        L30:
            this.mRoot = r;
            return false;
        L26:
            if (this.mRoot.info.applicationInfo.isSystemApp() == true) goto L30;
            if (this.mRoot.info.applicationInfo.uid == uid) goto L30;
            return true;
        L18:
            uid = r.info.applicationInfo.uid;
            goto L20
        L13:
            if (this.mRoot.finishing == false) goto L16;
            goto L14
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface ReparentMoveRootTaskMode {
    }

    /* JADX INFO: renamed from: $r8$lambda$3Ewe-KAmC2DF3EixVQwwO30CZOI, reason: not valid java name */
    public static /* synthetic */ boolean m10172$r8$lambda$3EweKAmC2DF3EixVQwwO30CZOI(ActivityRecord r0, ComponentName r1, int r2) {
        return matchesActivityInHistory(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$3UtuDCvfh_nBrjxsWOuNK04PRxQ(ActivityRecord r0) {
        return lambda$removedFromRecents$1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$572Co_hDEU4Y1gD6y-M0zqGzwLo, reason: not valid java name */
    public static /* synthetic */ boolean m10173$r8$lambda$572Co_hDEU4Y1gD6yM0zqGzwLo(ActivityRecord r0, int[] r1, Intent[] r2, NeededUriGrants[] r3, ActivityRecord r4) {
        return lambda$navigateUpTo$28(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$5TiwEo-YMpMik2pDaOLatEjRPl8, reason: not valid java name */
    public static /* synthetic */ boolean m10174$r8$lambda$5TiwEoYMpMik2pDaOLatEjRPl8(ActivityRecord r0, ActivityRecord r1) {
        return isTopRunningNonDelayed(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$71YccE_AQP42Bwnq_wvEDeaMask(ActivityRecord r0, ActivityRecord r1, ActivityManager.TaskDescription r2) {
        return setTaskDescriptionFromActivityAboveRoot(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$AdtjBiCSBrf-4ry6DpupAgK2ANk, reason: not valid java name */
    public static /* synthetic */ boolean m10175$r8$lambda$AdtjBiCSBrf4ry6DpupAgK2ANk(int[] r0, ActivityRecord r1, ActivityRecord r2) {
        return lambda$clearTopActivities$5(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$CV83Ao6cbudMZRxQq-huMwE4hyk, reason: not valid java name */
    public static /* synthetic */ boolean m10176$r8$lambda$CV83Ao6cbudMZRxQqhuMwE4hyk(ActivityRecord r0) {
        return lambda$getTopRealVisibleActivity$13(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$Cnwo1lO7kD1e5JRQyxuB8_db3lc(ComponentName r0, ActivityRecord r1) {
        return lambda$navigateUpTo$27(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$FnQcGOdl1SuBxBQxm52kMu3vpxg(ActivityRecord r0) {
        return lambda$getTopWaitSplashScreenActivity$14(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$HCI_GJCWwOWXFth3ZcenvFTWCdE(Task r0, boolean[] r1, Task r2) {
        return r0.lambda$inFrontOfStandardRootTask$26(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$HJVFVgad06xInlJNTEthvxuNujI(Task r0, ActivityRecord r1) {
        r0.lambda$finishIfVoiceTask$25(r1);
    }

    public static /* synthetic */ void $r8$lambda$JbhfpIQLHIlymaaN4Ed4hNlhymU(int[] r0, Task r1) {
        lambda$getDescendantTaskCount$8(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$KvOJgtu1uc0AknxrGvgJ7Oj-j3k, reason: not valid java name */
    public static /* synthetic */ void m10177$r8$lambda$KvOJgtu1uc0AknxrGvgJ7Ojj3k(AppTimeTracker r0, ActivityRecord r1) {
        lambda$moveTaskToFront$29(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$M_uk4BXRixuNhvslRwNb9-a9Foc, reason: not valid java name */
    public static /* synthetic */ void m10178$r8$lambda$M_uk4BXRixuNhvslRwNb9a9Foc(Consumer r0, TaskFragment r1) {
        lambda$forOtherAdjacentTasks$6(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$MlvVaQXQozfQPRy0fDK6wU20wNA(ActivityRecord r0, int r1, IBinder r2) {
        return isTopRunning(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$Mzmw2X5TsXYIGuCMwwtr9i8KJ6M(ActivityRecord[] r0, TaskFragment r1) {
        return lambda$findEnterPipOnTaskSwitchCandidate$24(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$NuE2liWBYnSnL7ajlon-hbA5NWQ, reason: not valid java name */
    public static /* synthetic */ void m10179$r8$lambda$NuE2liWBYnSnL7ajlonhbA5NWQ(Consumer r0, boolean r1, Task r2) {
        lambda$forAllLeafTasksAndLeafTaskFragments$15(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$OF1uvXOUYU92SJq4X34ngGgUiqg(Task r0, ActivityRecord r1) {
        return r0.lambda$getBottomMostActivityInSamePackage$33(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Oxin8TaANc-he4LsQC1zEDVax1g, reason: not valid java name */
    public static /* synthetic */ boolean m10180$r8$lambda$Oxin8TaANche4LsQC1zEDVax1g(ActivityRecord r0) {
        return lambda$startActivityLocked$23(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Q4j1Zo5XMr3wcGmI579N3-4Ksu8, reason: not valid java name */
    public static /* synthetic */ boolean m10181$r8$lambda$Q4j1Zo5XMr3wcGmI579N34Ksu8(WindowState r0) {
        return lambda$topStartingWindow$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Vd_JubkSpa7BqHZrBAqyo-9yHEA, reason: not valid java name */
    public static /* synthetic */ void m10182$r8$lambda$Vd_JubkSpa7BqHZrBAqyo9yHEA(Task r0, boolean r1, String r2, ActivityRecord r3) {
        r0.lambda$removeActivities$3(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$WSueFAeaF-EuTXmGmzFYg9jVyOU, reason: not valid java name */
    public static /* synthetic */ void m10183$r8$lambda$WSueFAeaFEuTXmGmzFYg9jVyOU(Task r0, Task r1, Transition r2, boolean r3) {
        r0.lambda$moveTaskToBack$31(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$XLL0LF_ACGrhl5CTZxYp-M4hRgQ, reason: not valid java name */
    public static /* synthetic */ boolean m10184$r8$lambda$XLL0LF_ACGrhl5CTZxYpM4hRgQ(ActivityRecord r0) {
        return lambda$fillTaskInfo$16(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$ZJgPwmMLMLwi1TE_yFHlF8IlrcA(ActivityRecord r0) {
        return lambda$trimIneffectiveInfo$17(r0);
    }

    public static /* synthetic */ void $r8$lambda$_e8x82Mg2FnWHbIlTZdeZiMVZwM(TaskFragment r0, boolean[] r1, ActivityRecord r2, ActivityOptions r3, boolean r4, TaskFragment r5) {
        lambda$resumeTopActivityInnerLocked$22(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$bnf7J1CAePU4DA3lrZHJ-mxpAws, reason: not valid java name */
    public static /* synthetic */ void m10185$r8$lambda$bnf7J1CAePU4DA3lrZHJmxpAws(Task r0, ActivityRecord r1, String r2, int[] r3, TaskFragment r4) {
        r0.lambda$pauseActivityIfNeeded$0(r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean $r8$lambda$cysn04rFHbtUQ4MzxliIEMFuvUQ(ActivityRecord r0) {
        return lambda$getTopVisibleActivity$12(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$dOsd4Lo5lEwJC4pN8PO8qVfOV1Y(Task r0, boolean r1, Object r2) {
        return r0.lambda$getNextFocusableTask$9(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$dxwU1cM-XlGUhSWLfISfyN-jgw0, reason: not valid java name */
    public static /* synthetic */ boolean m10186$r8$lambda$dxwU1cMXlGUhSWLfISfyNjgw0(ActivityRecord r0, IBinder r1) {
        return finishIfVoiceActivity(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$iK08zrNtWbENDs778nSKw_nSqQs(Predicate r0, TaskFragment r1) {
        return lambda$forOtherAdjacentTasks$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$iMJrYEm6vTeEOnxT3s5bPwkUswY(ActivityManagerService.ItemMatcher r0, ArrayList r1, ActivityRecord r2) {
        lambda$getDumpActivitiesLocked$32(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$ifbgskeG0GV5E5wiQdHIfJ0UHQg(ActivityRecord r0, ActivityRecord r1) {
        return lambda$getOccludingActivityAbove$10(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$lGgFUJIASda8hIgpyFcrlLuq9lc(SurfaceControl.Transaction r0, int[] r1, TaskFragment r2) {
        lambda$assignChildLayers$18(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$oESpABTe6udMaDKxMx6BJayffmc(WindowState r0) {
        return lambda$getTopFullscreenMainWindow$11(r0);
    }

    public static /* synthetic */ void $r8$lambda$oOKbdwx4puIe6IU8_ruEL582v7c(boolean r0, ArrayList r1, ActivityRecord r2) {
        lambda$removeActivities$4(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ryYsM4ueRZDrZyAmErSJrLNMex4(ActivityRecord r0, boolean r1, Task r2) {
        lambda$ensureActivitiesVisible$21(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$t2ZxwbquYmM4HGVhF2HKyhRcxVI(Task r0, ActivityRecord r1) {
        return lambda$canMoveTaskToBack$30(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$tVpkFMG2_bx-FznGmNjbpYswPyE, reason: not valid java name */
    public static /* synthetic */ boolean m10187$r8$lambda$tVpkFMG2_bxFznGmNjbpYswPyE(ActivityRecord r0, ActivityRecord r1, TypedXmlSerializer r2) {
        return saveActivityToXml(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$xlO7qs2aju7TRqHdfrx1pYaMGpU(WindowState r0, SurfaceControl.Transaction r1, SurfaceControl.Transaction r2) {
        lambda$setMainWindowSizeChangeTransaction$19(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ynvimRt1IdsTTvjMCxO8yyaDHqE(boolean r0, int[] r1, TaskFragment r2) {
        lambda$goToSleepIfPossible$20(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fputmHasBeenVisible, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10188$$Nest$fputmHasBeenVisible(Task r0, boolean r1) {
        r0.mHasBeenVisible = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddChild, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10189$$Nest$maddChild(Task r0, WindowContainer r1, int r2, boolean r3) {
        r0.addChild(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msetWindowingModeInner, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10190$$Nest$msetWindowingModeInner(Task r0, int r1, boolean r2) {
        r0.setWindowingModeInner(r1, r2);
    }

    /* synthetic */ Task(ActivityTaskManagerService r1, int r2, Intent r3, Intent r4, String r5, String r6, ComponentName r7, ComponentName r8, boolean r9, boolean r10, int r11, int r12, String r13, long r14, boolean r16, ActivityManager.TaskDescription r17, int r18, int r19, int r20, int r21, String r22, String r23, int r24, boolean r25, boolean r26, boolean r27, int r28, int r29, ActivityInfo r30, IVoiceInteractionSession r31, IVoiceInteractor r32, boolean r33, IBinder r34, boolean r35, boolean r36, TaskIA r37) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36);
    }

    static {
        mQtiActivityPluginDelegate = new ActivityPluginDelegate();
        sResetTargetTaskHelper = new ResetTargetTaskHelper();
    }

    private Task(ActivityTaskManagerService atmService, int _taskId, Intent _intent, Intent _affinityIntent, String _affinity, String _rootAffinity, ComponentName _realActivity, ComponentName _origActivity, boolean _rootWasReset, boolean _autoRemoveRecents, int _userId, int _effectiveUid, String _lastDescription, long lastTimeMoved, boolean neverRelinquishIdentity, ActivityManager.TaskDescription _lastTaskDescription, int taskAffiliation, int prevTaskId, int nextTaskId, int callingUid, String callingPackage, String callingFeatureId, int resizeMode, boolean supportsPictureInPicture, boolean _realActivitySuspended, boolean userSetupComplete, int minWidth, int minHeight, ActivityInfo info, IVoiceInteractionSession _voiceSession, IVoiceInteractor _voiceInteractor, boolean _createdByOrganizer, IBinder _launchCookie, boolean _deferTaskAppear, boolean _removeWithTaskOrganizer) {
        super(atmService, null, _createdByOrganizer, false);
        this.mTranslucentActivityWaiting = null;
        this.mUndrawnActivitiesBelowTopTranslucent = new ArrayList();
        this.mPendingConvertFromTranslucentActivity = null;
        this.mInResumeTopActivity = false;
        this.mLockTaskAuth = 1;
        this.mLockTaskUid = -1;
        this.isPersistable = false;
        this.mNeverRelinquishIdentity = true;
        this.mReuseTask = false;
        this.mPrevAffiliateTaskId = -1;
        this.mNextAffiliateTaskId = -1;
        this.mLastNonFullscreenBounds = null;
        this.mLayerRank = -1;
        this.mPrevDisplayId = -1;
        this.mMultiWindowRestoreWindowingMode = -1;
        this.mLastReportedRequestedOrientation = -1;
        this.mTmpRect = new Rect();
        this.mIsPerceptible = false;
        this.mFindRootHelper = new FindRootHelper(this, null);
        this.mAlignActivityLocaleWithTask = false;
        this.mTaskSmtBase = new TaskSmtBase(this);
        this.prefetchState = 0;
        this.mExt = (IExtTask) ExtImplFactory.getImpl(IExtTask.class, new Object[]{this});
        this.mTaskId = _taskId;
        this.mUserId = _userId;
        this.mResizeMode = resizeMode;
        this.mSupportsPictureInPicture = supportsPictureInPicture;
        if (_lastTaskDescription == null) goto L5;
        ActivityManager.TaskDescription r10 = _lastTaskDescription;
    L6:
        this.mTaskDescription = r10;
        this.affinityIntent = _affinityIntent;
        this.affinity = _affinity;
        this.rootAffinity = _rootAffinity;
        this.voiceSession = _voiceSession;
        this.voiceInteractor = _voiceInteractor;
        this.realActivity = _realActivity;
        this.realActivitySuspended = _realActivitySuspended;
        this.origActivity = _origActivity;
        this.rootWasReset = _rootWasReset;
        this.isAvailable = true;
        this.autoRemoveRecents = _autoRemoveRecents;
        this.mUserSetupComplete = userSetupComplete;
        this.effectiveUid = _effectiveUid;
        touchActiveTime();
        this.lastDescription = _lastDescription;
        this.mLastTimeMoved = lastTimeMoved;
        this.mNeverRelinquishIdentity = neverRelinquishIdentity;
        this.mAffiliatedTaskId = taskAffiliation;
        this.mPrevAffiliateTaskId = prevTaskId;
        this.mNextAffiliateTaskId = nextTaskId;
        this.mCallingUid = callingUid;
        this.mCallingPackage = callingPackage;
        this.mCallingFeatureId = callingFeatureId;
        this.mResizeMode = resizeMode;
        if (info == null) goto L9;
        setIntent(_intent, info);
        setMinDimensions(info);
    L10:
        this.mAtmService.getTaskChangeNotificationController().notifyTaskCreated(_taskId, this.realActivity);
        this.mHandler = new ActivityTaskHandler(this, this.mTaskSupervisor.mLooper);
        this.mCurrentUser = this.mAtmService.mAmInternal.getCurrentUserId();
        this.mLaunchCookie = _launchCookie;
        this.mDeferTaskAppear = _deferTaskAppear;
        this.mRemoveWithTaskOrganizer = _removeWithTaskOrganizer;
        this.mIsTrimmableFromRecents = true;
        EventLogTags.writeWmTaskCreated(this.mTaskId);
        return;
    L9:
        this.intent = _intent;
        this.mMinWidth = minWidth;
        this.mMinHeight = minHeight;
        goto L10
    L5:
        r10 = new ActivityManager.TaskDescription();
        goto L6
    }

    static Task fromWindowContainerToken(WindowContainerToken token) {
        if (token != null) goto L6;
        return null;
    L6:
        return WindowContainer.fromBinder(token.asBinder()).asTask();
    }

    Task reuseAsLeafTask(IVoiceInteractionSession _voiceSession, IVoiceInteractor _voiceInteractor, Intent intent, ActivityInfo info, ActivityRecord activity) {
        this.voiceSession = _voiceSession;
        this.voiceInteractor = _voiceInteractor;
        setIntent(activity, intent, info);
        setMinDimensions(info);
        this.mAtmService.getTaskChangeNotificationController().notifyTaskCreated(this.mTaskId, this.realActivity);
        return this;
    }

    private void cleanUpResourcesForDestroy(WindowContainer<?> oldParent) {
        if (hasChild() == false) goto L5;
        return;
    L5:
        saveLaunchingStateIfNeeded(oldParent.getDisplayContent());
        if (this.voiceSession == null) goto L8;
        boolean isVoiceSession = true;
    L9:
        if (isVoiceSession == false) goto L14;
        this.voiceSession.taskFinished(this.intent, this.mTaskId);     // Catch: RemoteException -> L12
    L14:
        if (shouldAutoRemoveFromRecents(oldParent.asTaskFragment()) == true) goto L16;
        if (isVoiceSession == true) goto L16;
    L17:
        removeIfPossible("cleanUpResourcesForDestroy");
        return;
    L16:
        this.mTaskSupervisor.mRecentTasks.remove(this);
        goto L17
    L8:
        isVoiceSession = false;
        goto L9
    }

    @Override // com.android.server.wm.WindowContainer
    void removeIfPossible() {
        removeIfPossible("removeTaskIfPossible");
    }

    void removeIfPossible(String reason) {
        this.mAtmService.getLockTaskController().clearLockedTask(this);
        if (shouldDeferRemoval() == true) goto L5;
        boolean isLeafTask = isLeafTask();
        removeImmediately(reason);
        if (isLeafTask == false) goto L15;
        this.mAtmService.getTaskChangeNotificationController().notifyTaskRemoved(this.mTaskId);
        TaskDisplayArea taskDisplayArea = getDisplayArea();
        if (taskDisplayArea == null) goto L16;
        taskDisplayArea.onLeafTaskRemoved(this.mTaskId);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (WindowManagerDebugConfig.DEBUG_ROOT_TASK == false) goto L14;
        Slog.i("ActivityTaskManager", "removeTask:" + reason + " deferring removing taskId=" + this.mTaskId);
        return;
    }

    void setResizeMode(int resizeMode) {
        if (this.mResizeMode != resizeMode) goto L5;
        return;
    L5:
        this.mResizeMode = resizeMode;
        this.mRootWindowContainer.ensureActivitiesVisible();
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();
        updateTaskDescription();
    }

    boolean resize(Rect bounds, int resizeMode, boolean preserveWindow) {
        this.mAtmService.deferWindowLayout();
        if ((resizeMode & 2) == 0) goto L5;
        boolean forced = true;
    L32:
    L12:
        th = move-exception;
        this.mAtmService.continueWindowLayout();
        throw th;
    L7:
        if (getParent() != null) goto L17;
        setBounds(bounds);     // Catch: Throwable -> L12
        if (inFreeformWindowingMode() == true) goto L14;
        this.mTaskSupervisor.restoreRecentTaskLocked(this, null, false);     // Catch: Throwable -> L12
    L14:
        this.mAtmService.continueWindowLayout();
        return true;
    L17:
        if (canResizeToBounds(bounds) == false) goto L29;
        Trace.traceBegin(32, "resizeTask_" + this.mTaskId);     // Catch: Throwable -> L12
        boolean kept = true;
        if (setBounds(bounds, forced) == 0) goto L25;
        ActivityRecord r = topRunningActivityLocked();     // Catch: Throwable -> L12
        if (r == null) goto L25;
        kept = r.ensureActivityConfiguration();     // Catch: Throwable -> L12
        this.mRootWindowContainer.ensureActivitiesVisible(r);     // Catch: Throwable -> L12
        if (kept == true) goto L25;
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();     // Catch: Throwable -> L12
    L25:
        saveLaunchingStateIfNeeded();     // Catch: Throwable -> L12
        Trace.traceEnd(32);     // Catch: Throwable -> L12
        this.mAtmService.continueWindowLayout();
        return kept;
    L29:
        throw new IllegalArgumentException("resizeTask: Can not resize task=" + this + " to bounds=" + bounds + " resizeMode=" + this.mResizeMode);     // Catch: Throwable -> L12
    L5:
        forced = false;
        goto L32
    }

    boolean reparent(Task preferredRootTask, boolean toTop, int moveRootTaskMode, boolean animate, boolean deferResume, String reason) {
        ActivityTaskSupervisor supervisor = this.mTaskSupervisor;
        RootWindowContainer root = this.mRootWindowContainer;
        Task sourceRootTask = getRootTask();
        Task toRootTask = supervisor.getReparentTargetRootTask(this, preferredRootTask, toTop);
        int r0 = 0;
        if (toRootTask != sourceRootTask) goto L6;
        return false;
    L6:
        if (canBeLaunchedOnDisplay(toRootTask.getDisplayId()) == true) goto L8;
        return false;
    L8:
        ActivityRecord topActivity = getTopNonFinishingActivity();
        this.mAtmService.deferWindowLayout();
        ActivityRecord r = topRunningActivityLocked();     // Catch: Throwable -> L16
        if (r != null) goto L12;
    L18:
        boolean wasFocused = false;
    L20:
        if (r != null) goto L22;
    L26:
        boolean wasFront = false;
    L28:
        if (moveRootTaskMode == 0) goto L34;
        if (moveRootTaskMode != 1) goto L33;
        if (wasFocused == true) goto L34;
        if (wasFront == true) goto L34;
    L33:
        boolean moveRootTaskToFront = false;
    L35:
        if (toTop == false) goto L37;
        r0 = Integer.MAX_VALUE;
    L37:
        reparent(toRootTask, r0, moveRootTaskToFront, reason);     // Catch: Throwable -> L16
        if (r == null) goto L45;
        if (moveRootTaskToFront == false) goto L45;
        toRootTask.moveToFront(reason);     // Catch: Throwable -> L16
        if (r.isState(ActivityRecord.State.RESUMED) == false) goto L45;
        if (r != this.mRootWindowContainer.getTopResumedActivity()) goto L45;
        this.mAtmService.setLastResumedActivityUncheckLocked(r, reason);     // Catch: Throwable -> L16
    L45:
        if (animate == true) goto L47;
        this.mTaskSupervisor.mNoAnimActivities.add(topActivity);     // Catch: Throwable -> L16
    L47:
        this.mAtmService.continueWindowLayout();
        if (deferResume == true) goto L50;
        root.ensureActivitiesVisible();
        root.resumeFocusedTasksTopActivities();
    L50:
        supervisor.handleNonResizableTaskIfNeeded(this, preferredRootTask.getWindowingMode(), this.mRootWindowContainer.getDefaultTaskDisplayArea(), toRootTask);
        if (preferredRootTask == toRootTask) goto L59;
        return false;
    L59:
        return true;
    L34:
        moveRootTaskToFront = true;
        goto L35
    L22:
        if (sourceRootTask.isTopRootTaskInDisplayArea() == false) goto L26;
        if (sourceRootTask.topRunningActivity() != r) goto L26;
        wasFront = true;
        goto L28
    L12:
        if (root.isTopDisplayFocusedRootTask(sourceRootTask) == false) goto L18;
        if (topRunningActivityLocked() != r) goto L18;
        wasFocused = true;
    L16:
        th = move-exception;
        this.mAtmService.continueWindowLayout();
        throw th;
    }

    void touchActiveTime() {
        this.lastActiveTime = SystemClock.elapsedRealtime();
    }

    long getInactiveDuration() {
        return SystemClock.elapsedRealtime() - this.lastActiveTime;
    }

    void setIntent(ActivityRecord r) {
        setIntent(r, null, null);
    }

    void setIntent(ActivityRecord r, Intent intent, ActivityInfo info) {
        boolean updateIdentity = false;
        if (this.intent != null) goto L6;
        updateIdentity = true;
    L20:
        if (updateIdentity == false) goto L29;
        this.mCallingUid = r.launchedFromUid;
        this.mCallingPackage = r.launchedFromPackage;
        this.mCallingFeatureId = r.launchedFromFeatureId;
        if (intent == null) goto L24;
        Intent r1 = intent;
    L25:
        if (info == null) goto L27;
        ActivityInfo r2 = info;
    L28:
        setIntent(r1, r2);
        updateForceResizeOverrides(r);
        goto L29
    L27:
        r2 = r.info;
        goto L28
    L24:
        r1 = r.intent;
    L29:
        setLockTaskAuth(r);
        return;
    L6:
        if (this.mNeverRelinquishIdentity == true) goto L20;
        if (info == null) goto L9;
        ActivityInfo activityInfo = info;
    L11:
        if (this.effectiveUid != 1000) goto L13;
    L18:
        boolean r3 = true;
    L19:
        updateIdentity = r3;
        goto L20
    L13:
        if (this.mIsEffectivelySystemApp == true) goto L18;
        if (this.effectiveUid == activityInfo.applicationInfo.uid) goto L18;
        r3 = false;
        goto L19
    L9:
        activityInfo = r.info;
        goto L11
    }

    private void setIntent(Intent _intent, ActivityInfo info) {
        if (isLeafTask() == true) goto L6;
        return;
    L6:
        if ((info.flags & 4096) != 0) goto L8;
        boolean r0 = true;
    L9:
        this.mNeverRelinquishIdentity = r0;
        this.affinity = info.taskAffinity;
        if (this.intent != null) goto L12;
        this.rootAffinity = this.affinity;
        this.mRequiredDisplayCategory = info.requiredDisplayCategory;
    L12:
        this.effectiveUid = info.applicationInfo.uid;
        this.mIsEffectivelySystemApp = info.applicationInfo.isSystemApp();
        if (info.targetActivity != null) goto L28;
        if (_intent == null) goto L21;
        if (_intent.getSelector() == null) goto L18;
    L19:
        _intent = new Intent(_intent);
        _intent.setSelector(null);
        _intent.setSourceBounds(null);
        goto L21
    L18:
        if (_intent.getSourceBounds() != null) goto L19;
    L21:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[1] == false) goto L23;
        String protoLogParam0 = String.valueOf(this);
        String protoLogParam1 = String.valueOf(_intent);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_TASKS, -8609432747982701423L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L23:
        this.intent = _intent;
        if (_intent == null) goto L26;
        ComponentName r1 = _intent.getComponent();
    L27:
        this.realActivity = r1;
        this.origActivity = null;
    L36:
        if (info.windowLayout != null) goto L38;
        String r2 = null;
    L39:
        this.mWindowLayoutAffinity = r2;
        if (this.intent != null) goto L42;
        int intentFlags = 0;
    L44:
        if ((2097152 & intentFlags) == 0) goto L46;
        this.rootWasReset = true;
    L46:
        this.mUserId = UserHandle.getUserId(info.applicationInfo.uid);
        if (Settings.Secure.getIntForUser(this.mAtmService.mContext.getContentResolver(), ATTR_USER_SETUP_COMPLETE, 0, this.mUserId) == 0) goto L49;
        boolean r4 = true;
    L50:
        this.mUserSetupComplete = r4;
        if ((info.flags & 8192) == 0) goto L54;
        this.autoRemoveRecents = true;
    L61:
        if (this.mResizeMode == info.resizeMode) goto L63;
        this.mResizeMode = info.resizeMode;
        updateTaskDescription();
    L63:
        this.mSupportsPictureInPicture = info.supportsPictureInPicture();
        this.stringName = null;
        if (this.inRecents == false) goto L67;
        this.mTaskSupervisor.mRecentTasks.remove(this);
        this.mTaskSupervisor.mRecentTasks.add(this);
        return;
    L67:
        return;
    L54:
        if ((532480 & intentFlags) == 524288) goto L56;
        this.autoRemoveRecents = false;
        goto L61
    L56:
        if (info.documentLaunchMode == 0) goto L58;
        this.autoRemoveRecents = false;
        goto L61
    L58:
        this.autoRemoveRecents = true;
        goto L61
    L49:
        r4 = false;
        goto L50
    L42:
        intentFlags = this.intent.getFlags();
        goto L44
    L38:
        r2 = info.windowLayout.windowLayoutAffinity;
        goto L39
    L26:
        r1 = null;
        goto L27
    L28:
        ComponentName targetComponent = new ComponentName(info.packageName, info.targetActivity);
        if (_intent == null) goto L34;
        Intent targetIntent = new Intent(_intent);
        targetIntent.setSelector(null);
        targetIntent.setSourceBounds(null);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[1] == false) goto L33;
        String protoLogParam2 = String.valueOf(this);
        String protoLogParam3 = String.valueOf(targetIntent);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_TASKS, -9155008290180285590L, 0, new Object[]{protoLogParam2, protoLogParam3});
    L33:
        this.intent = targetIntent;
        this.realActivity = targetComponent;
        this.origActivity = _intent.getComponent();
        goto L36
    L34:
        this.intent = null;
        this.realActivity = targetComponent;
        this.origActivity = new ComponentName(info.packageName, info.name);
        goto L36
    L8:
        r0 = false;
        goto L9
    }

    void setMinDimensions(ActivityInfo info) {
        if (info != null) goto L4;
    L6:
        this.mMinWidth = -1;
        this.mMinHeight = -1;
        return;
    L4:
        if (info.windowLayout == null) goto L6;
        this.mMinWidth = info.windowLayout.minWidth;
        this.mMinHeight = info.windowLayout.minHeight;
    }

    boolean isSameIntentFilter(ActivityRecord r) {
        Intent intent = new Intent(r.intent);
        if (Objects.equals(this.realActivity, r.mActivityComponent) == false) goto L10;
        if (this.intent == null) goto L10;
        intent.setComponent(this.intent.getComponent());
        if (intent.getSelector() != null) goto L10;
        intent.setPackage(this.intent.getPackage());
    L10:
        return intent.filterEquals(this.intent);
    }

    boolean returnsToHomeRootTask() {
        if (Features.FEAT_QUICK_WIN == false) goto L8;
        if (inFreeformWindowingMode() == false) goto L8;
        return false;
    L8:
        if (inMultiWindowMode() == false) goto L10;
    L33:
        return false;
    L10:
        if (hasChild() == false) goto L33;
        if (this.intent != null) goto L15;
        Task bottomTask = getBottomMostTask();
        if (bottomTask != this) goto L30;
        return false;
    L30:
        if (bottomTask.returnsToHomeRootTask() == true) goto L32;
        return false;
    L32:
        return true;
    L15:
        if ((this.intent.getFlags() & 268451840) == 268451840) goto L18;
        return false;
    L18:
        if (getDisplayArea() == null) goto L20;
        Task task = getDisplayArea().getRootHomeTask();
    L22:
        if (task == null) goto L26;
        if (this.mAtmService.getLockTaskController().isLockTaskModeViolation(task) == false) goto L26;
        return false;
    L26:
        return true;
    L20:
        task = null;
        goto L22
    }

    void setPrevAffiliate(Task prevAffiliate) {
        this.mPrevAffiliate = prevAffiliate;
        if (prevAffiliate != null) goto L5;
        int r0 = -1;
    L6:
        this.mPrevAffiliateTaskId = r0;
        return;
    L5:
        r0 = prevAffiliate.mTaskId;
        goto L6
    }

    void setNextAffiliate(Task nextAffiliate) {
        this.mNextAffiliate = nextAffiliate;
        if (nextAffiliate != null) goto L5;
        int r0 = -1;
    L6:
        this.mNextAffiliateTaskId = r0;
        return;
    L5:
        r0 = nextAffiliate.mTaskId;
        goto L6
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    void onParentChanged(ConfigurationContainer rawNewParent, ConfigurationContainer rawOldParent) {
        WindowContainer<?> newParent = (WindowContainer) rawNewParent;
        WindowContainer<?> oldParent = (WindowContainer) rawOldParent;
        if (newParent == null) goto L5;
        DisplayContent display = newParent.getDisplayContent();
    L6:
        if (oldParent == null) goto L8;
        DisplayContent oldDisplay = oldParent.getDisplayContent();
    L9:
        if (oldDisplay == null) goto L11;
        int r5 = oldDisplay.mDisplayId;
    L12:
        this.mPrevDisplayId = r5;
        if (oldParent == null) goto L16;
        if (newParent != null) goto L16;
        cleanUpResourcesForDestroy(oldParent);
    L16:
        if (display == null) goto L18;
        getConfiguration().windowConfiguration.setRotation(display.getWindowConfiguration().getRotation());
    L18:
        super.onParentChanged(newParent, oldParent);
        updateTaskOrganizerState();
        if (oldParent == null) goto L32;
        final Task oldParentTask = oldParent.asTask();
        if (oldParentTask == null) goto L23;
        oldParentTask.getClass();
        forAllActivities(new Task$$ExternalSyntheticLambda42(oldParentTask));
        oldParentTask.updateTaskDescription();
    L23:
        if (newParent == null) goto L27;
        if (newParent.inPinnedWindowingMode() == true) goto L32;
    L27:
        if (oldParent.inPinnedWindowingMode() == false) goto L30;
        this.mRootWindowContainer.notifyActivityPipModeChanged(this, null);
        goto L32
    L30:
        if (inPinnedWindowingMode() == false) goto L32;
        Slog.e("ActivityTaskManager", "Pinned task is removed t=" + this);
        this.mRootWindowContainer.notifyActivityPipModeChanged(this, null);
    L32:
        if (newParent != null) goto L34;
    L44:
        if (oldParent != null) goto L47;
        if (newParent == null) goto L47;
        updateOverrideConfigurationFromLaunchBounds();
    L47:
        this.mRootWindowContainer.updateUIDsPresentOnDisplay();
        return;
    L34:
        if (this.mCreatedByOrganizer == true) goto L39;
        if (canBeOrganized() == true) goto L39;
        getSyncTransaction().show(this.mSurfaceControl);
    L39:
        if (this.voiceSession != null) goto L49;
    L43:
        updateTaskDescription();
        goto L44
    L49:
        this.voiceSession.taskStarted(this.intent, this.mTaskId);     // Catch: RemoteException -> L42
        goto L43
    L11:
        r5 = -1;
        goto L12
    L8:
        oldDisplay = null;
        goto L9
    L5:
        display = null;
        goto L6
    }

    @Override // com.android.server.wm.WindowContainer
    void onResize() {
        super.onResize();
        onTaskBoundsChangedForFreeform();
    }

    @Override // com.android.server.wm.WindowContainer
    void onMovedByResize() {
        super.onMovedByResize();
        onTaskBoundsChangedForFreeform();
    }

    private void onTaskBoundsChangedForFreeform() {
        if (isVisibleRequested() == true) goto L5;
        return;
    L5:
        if (inFreeformWindowingMode() == false) goto L10;
        this.mAtmService.notifyTaskPersisterLocked(this, false);
        this.mRootWindowContainer.invalidateTaskLayersAndUpdateOomAdjIfNeeded();
        return;
    }

    @Override // com.android.server.wm.TaskFragment
    ActivityRecord getTopResumedActivity() {
        if (isLeafTask() == true) goto L10;
        int i = this.mChildren.size() - 1;
    L5:
        if (i < 0) goto L10;
        ActivityRecord resumedActivity = ((WindowContainer) this.mChildren.get(i)).asTask().getTopResumedActivity();
        if (resumedActivity != null) goto L8;
        i = i - 1;
        goto L5
    L8:
        return resumedActivity;
    L10:
        ActivityRecord taskResumedActivity = getResumedActivity();
        ActivityRecord topResumedActivity = null;
        int i2 = this.mChildren.size() - 1;
    L11:
        if (i2 < 0) goto L22;
        WindowContainer child = (WindowContainer) this.mChildren.get(i2);
        if (child.asTaskFragment() == null) goto L15;
        topResumedActivity = child.asTaskFragment().getTopResumedActivity();
    L19:
        if (topResumedActivity != null) goto L20;
        i2 = i2 - 1;
        goto L11
    L20:
        return topResumedActivity;
    L15:
        if (taskResumedActivity == null) goto L19;
        if (child.asActivityRecord() != taskResumedActivity) goto L19;
        topResumedActivity = taskResumedActivity;
        goto L19
    L22:
        return null;
    }

    @Override // com.android.server.wm.TaskFragment
    ActivityRecord getTopPausingActivity() {
        if (isLeafTask() == true) goto L10;
        int i = this.mChildren.size() - 1;
    L5:
        if (i < 0) goto L10;
        ActivityRecord pausingActivity = ((WindowContainer) this.mChildren.get(i)).asTask().getTopPausingActivity();
        if (pausingActivity != null) goto L8;
        i = i - 1;
        goto L5
    L8:
        return pausingActivity;
    L10:
        ActivityRecord taskPausingActivity = getPausingActivity();
        ActivityRecord topPausingActivity = null;
        int i2 = this.mChildren.size() - 1;
    L11:
        if (i2 < 0) goto L22;
        WindowContainer child = (WindowContainer) this.mChildren.get(i2);
        if (child.asTaskFragment() == null) goto L15;
        topPausingActivity = child.asTaskFragment().getTopPausingActivity();
    L19:
        if (topPausingActivity != null) goto L20;
        i2 = i2 - 1;
        goto L11
    L20:
        return topPausingActivity;
    L15:
        if (taskPausingActivity == null) goto L19;
        if (child.asActivityRecord() != taskPausingActivity) goto L19;
        topPausingActivity = taskPausingActivity;
        goto L19
    L22:
        return null;
    }

    boolean pauseActivityIfNeeded(final ActivityRecord resuming, final String reason) {
        if (isLeafTask() == true) goto L5;
        return false;
    L5:
        final int[] someActivityPaused = {0};
        if (isLeafTaskFragment() == true) goto L37;
        ActivityRecord top = topRunningActivity();
        ActivityRecord resumedActivity = getResumedActivity();
        if (resumedActivity == null) goto L13;
        if (resuming == null) goto L13;
        if (getExt().shouldSkipPausingForSplitReplace(resumedActivity, resuming) == false) goto L13;
        boolean skipPausingForSplitReplace = true;
    L15:
        if (resumedActivity == null) goto L37;
        if (skipPausingForSplitReplace == true) goto L37;
        if (top == null) goto L23;
        if (top.getTaskFragment() != this) goto L23;
        if (canBeResumed(resuming) == true) goto L37;
    L23:
        if (startPausing(false, resuming, reason) == false) goto L37;
        if (mQtiActivityPluginDelegate == null) goto L36;
        if (top == null) goto L36;
        if (top.info == null) goto L36;
        if (getWindowingMode() == 0) goto L36;
        String r6 = top.info.packageName;
        if (getWindowingMode() != 1) goto L34;
        boolean r7 = true;
    L35:
        ActivityPluginDelegate.activitySuspendNotification(r6, r7, true);
        goto L36
    L34:
        r7 = false;
    L36:
        someActivityPaused[0] = someActivityPaused[0] + 1;
    L13:
        skipPausingForSplitReplace = false;
    L37:
        forAllLeafTaskFragments(new Task$$ExternalSyntheticLambda15(this, resuming, reason, someActivityPaused), true);
        if (someActivityPaused[0] > 0) goto L40;
        return false;
    L40:
        return true;
    }

    private /* synthetic */ void lambda$pauseActivityIfNeeded$0(ActivityRecord resuming, String reason, int[] someActivityPaused, TaskFragment taskFrag) {
        ActivityRecord resumedActivity = taskFrag.getResumedActivity();
        ActivityRecord top = topRunningActivity();
        if (resumedActivity == null) goto L8;
        if (resuming == null) goto L8;
        if (getExt().shouldSkipPausingForSplitReplace(resumedActivity, resuming) == false) goto L8;
        boolean skipPausingForSplitReplace = true;
    L10:
        if (resumedActivity == null) goto L30;
        if (skipPausingForSplitReplace == false) goto L13;
        return;
    L13:
        if (taskFrag.canBeResumed(resuming) == false) goto L15;
        return;
    L15:
        if (taskFrag.startPausing(false, resuming, reason) == true) goto L17;
        return;
    L17:
        if (mQtiActivityPluginDelegate == null) goto L28;
        if (top == null) goto L28;
        if (top.info == null) goto L28;
        if (getWindowingMode() == 0) goto L28;
        String r5 = top.info.packageName;
        if (getWindowingMode() != 1) goto L26;
        boolean r6 = true;
    L27:
        ActivityPluginDelegate.activitySuspendNotification(r5, r6, true);
        goto L28
    L26:
        r6 = false;
    L28:
        someActivityPaused[0] = someActivityPaused[0] + 1;
        return;
    L30:
        return;
    L8:
        skipPausingForSplitReplace = false;
        goto L10
    }

    void updateTaskMovement(boolean r4, boolean r5, int r6) {
        EventLogTags.writeWmTaskMoved(this.mTaskId, getRootTaskId(), getDisplayId(), r4 ? 1 : 0, r6);
        TaskDisplayArea r0 = getDisplayArea();
        if (r0 == null) goto L6;
        r0.onTaskMoved(this, r4, r5);
    L6:
        if (this.isPersistable == false) goto L8;
        this.mLastTimeMoved = System.currentTimeMillis();
    L8:
        if (r4 == true) goto L10;
        return;
    L10:
        if (this.inRecents == false) goto L14;
        this.mTaskSupervisor.mRecentTasks.add(this);
        return;
    }

    private void closeRecentsChain() {
        if (this.mPrevAffiliate == null) goto L6;
        this.mPrevAffiliate.setNextAffiliate(this.mNextAffiliate);
    L6:
        if (this.mNextAffiliate == null) goto L8;
        this.mNextAffiliate.setPrevAffiliate(this.mPrevAffiliate);
    L8:
        setPrevAffiliate(null);
        setNextAffiliate(null);
    }

    void removedFromRecents() {
        closeRecentsChain();
        if (this.inRecents == false) goto L5;
        this.inRecents = false;
        this.mAtmService.notifyTaskPersisterLocked(this, false);
    L5:
        clearRootProcess();
        ActivityRecord baseActivity = getActivity(new Task$$ExternalSyntheticLambda32(), false);
        if (baseActivity == null) goto L8;
        int baseActivityUid = baseActivity.getUid();
    L9:
        this.mAtmService.mWindowManager.mTaskSnapshotController.removeAndDeleteSnapshot(this.mTaskId, this.mUserId, baseActivityUid);
        return;
    L8:
        baseActivityUid = this.effectiveUid;
        goto L9
    }

    private static /* synthetic */ boolean lambda$removedFromRecents$1(ActivityRecord r) {
        return !r.finishing;
    }

    void setTaskToAffiliateWith(Task taskToAffiliateWith) {
        closeRecentsChain();
        this.mAffiliatedTaskId = taskToAffiliateWith.mAffiliatedTaskId;
    L4:
        if (taskToAffiliateWith.mNextAffiliate == null) goto L12;
        Task nextRecents = taskToAffiliateWith.mNextAffiliate;
        if (nextRecents.mAffiliatedTaskId != this.mAffiliatedTaskId) goto L7;
        taskToAffiliateWith = nextRecents;
        goto L4
    L7:
        Slog.e("ActivityTaskManager", "setTaskToAffiliateWith: nextRecents=" + nextRecents + " affilTaskId=" + nextRecents.mAffiliatedTaskId + " should be " + this.mAffiliatedTaskId);
        if (nextRecents.mPrevAffiliate != taskToAffiliateWith) goto L10;
        nextRecents.setPrevAffiliate(null);
    L10:
        taskToAffiliateWith.setNextAffiliate(null);
    L12:
        taskToAffiliateWith.setNextAffiliate(this);
        setPrevAffiliate(taskToAffiliateWith);
        setNextAffiliate(null);
    }

    Intent getBaseIntent() {
        if (this.intent == null) goto L7;
        return this.intent;
    L7:
        if (this.affinityIntent != null) goto L9;
        Task topTask = getTopMostTask();
        if (topTask == this) goto L14;
        if (topTask == null) goto L14;
        return topTask.getBaseIntent();
    L14:
        return null;
    L9:
        return this.affinityIntent;
    }

    String getBasePackageName() {
        Intent intent = getBaseIntent();
        if (intent != null) goto L5;
        return "";
    L5:
        ComponentName componentName = intent.getComponent();
        if (componentName != null) goto L8;
        return "";
    L8:
        return componentName.getPackageName();
    }

    ActivityRecord getRootActivity() {
        return getRootActivity(true, false);
    }

    ActivityRecord getRootActivity(boolean setToBottomIfNone) {
        return getRootActivity(false, setToBottomIfNone);
    }

    ActivityRecord getRootActivity(boolean ignoreRelinquishIdentity, boolean setToBottomIfNone) {
        return this.mFindRootHelper.findRoot(ignoreRelinquishIdentity, setToBottomIfNone);
    }

    ActivityRecord topRunningActivityLocked() {
        if (getParent() != null) goto L7;
        return null;
    L7:
        return getActivity(new ActivityStarter$$ExternalSyntheticLambda0());
    }

    boolean isUidPresent(int uid) {
        PooledPredicate p = PooledLambda.obtainPredicate(new DisplayContent$$ExternalSyntheticLambda8(), PooledLambda.__(ActivityRecord.class), Integer.valueOf(uid));
        if (getActivity(p) == null) goto L5;
        boolean isUidPresent = true;
    L6:
        p.recycle();
        return isUidPresent;
    L5:
        isUidPresent = false;
        goto L6
    }

    private static /* synthetic */ boolean lambda$topStartingWindow$2(WindowState w) {
        if (w.mAttrs.type != 3) goto L5;
        return true;
    L5:
        return false;
    }

    WindowState topStartingWindow() {
        return getWindow(new Task$$ExternalSyntheticLambda30());
    }

    ActivityRecord topActivityContainsStartingWindow() {
        WindowState startingWindow = topStartingWindow();
        if (startingWindow != null) goto L7;
        return null;
    L7:
        return startingWindow.mActivityRecord;
    }

    final boolean moveActivityToFront(ActivityRecord newTop) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[2] == false) goto L5;
        String protoLogParam0 = String.valueOf(newTop);
        String protoLogParam1 = String.valueOf(Debug.getCallers(4));
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 6424220442758232673L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L5:
        TaskFragment taskFragment = newTop.getTaskFragment();
        if (taskFragment != this) goto L8;
        boolean moved = moveChildToFront(newTop);
    L16:
        updateEffectiveIntent();
        return moved;
    L8:
        if (taskFragment.isEmbedded() == true) goto L10;
    L12:
        newTop.reparent(this, Integer.MAX_VALUE);
        moved = true;
        if (taskFragment.isEmbedded() == false) goto L16;
        this.mAtmService.mWindowOrganizerController.mTaskFragmentOrganizerController.onActivityReparentedToTask(newTop);
        goto L16
    L10:
        if (taskFragment.getNonFinishingActivityCount() != 1) goto L12;
        taskFragment.mClearedForReorderActivityToFront = true;
        goto L12
    }

    @Override // com.android.server.wm.TaskFragment, com.android.server.wm.WindowContainer
    void addChild(WindowContainer child, int index) {
        super.addChild(child, getAdjustedChildPosition(child, index));
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[1] == false) goto L6;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, -1028890010429408946L, 0, new Object[]{protoLogParam0});
    L6:
        if (this.mTaskOrganizer != null) goto L8;
    L12:
        this.mRootWindowContainer.updateUIDsPresentOnDisplay();
        TaskFragment childTaskFrag = child.asTaskFragment();
        if (childTaskFrag != null) goto L15;
        return;
    L15:
        if (childTaskFrag.asTask() == null) goto L17;
        return;
    L17:
        if (childTaskFrag.mTaskFragmentOrganizerProcessName != null) goto L19;
    L21:
        childTaskFrag.setMinDimensions(this.mMinWidth, this.mMinHeight);
        ActivityRecord top = getTopMostActivity();
        if (top != null) goto L24;
        return;
    L24:
        if (top.hasFixedRotationTransform() == true) goto L30;
        top.associateStartingWindowWithTaskIfNeeded();
        return;
    L30:
        return;
    L19:
        if (this.mTaskFragmentHostProcessName != null) goto L21;
        this.mTaskFragmentHostUid = childTaskFrag.mTaskFragmentOrganizerUid;
        this.mTaskFragmentHostProcessName = childTaskFrag.mTaskFragmentOrganizerProcessName;
        goto L21
    L8:
        if (this.mCreatedByOrganizer == false) goto L12;
        if (child.asTask() == null) goto L12;
        getDisplayArea().addRootTaskReferenceIfNeeded((Task) child);
        goto L12
    }

    void onDescendantActivityAdded(boolean hadActivity, int activityType, ActivityRecord r) {
        warnForNonLeafTask("onDescendantActivityAdded");
        if (hadActivity == true) goto L11;
        int activityOverrideType = r.getRequestedOverrideConfiguration().windowConfiguration.getActivityType();
        if (activityOverrideType != 0) goto L10;
        if (activityType == 0) goto L8;
        int r2 = activityType;
    L9:
        activityOverrideType = r2;
        r.getRequestedOverrideConfiguration().windowConfiguration.setActivityType(activityOverrideType);
        goto L10
    L8:
        r2 = 1;
    L10:
        setActivityType(activityOverrideType);
        this.isPersistable = r.isPersistable();
        this.mCallingUid = r.launchedFromUid;
        this.mCallingPackage = r.launchedFromPackage;
        this.mCallingFeatureId = r.launchedFromFeatureId;
        this.maxRecents = Math.min(Math.max(r.info.maxRecents, 1), ActivityTaskManager.getMaxAppRecentsLimitStatic());
    L12:
        updateEffectiveIntent();
        return;
    L11:
        r.setActivityType(activityType);
        goto L12
    }

    @Override // com.android.server.wm.TaskFragment, com.android.server.wm.WindowContainer
    void removeChild(WindowContainer child) {
        removeChild(child, "removeChild");
    }

    void removeChild(WindowContainer r, String reason) {
        if (this.mCreatedByOrganizer == false) goto L8;
        if (r.asTask() == null) goto L8;
        getDisplayArea().removeRootTaskReferenceIfNeeded((Task) r);
    L8:
        if (this.mChildren.contains(r) == true) goto L12;
        Slog.e("ActivityTaskManager", "removeChild: r=" + r + " not found in t=" + this);
        return;
    L12:
        if (WindowManagerDebugConfig.DEBUG_TASK_MOVEMENT == false) goto L14;
        Slog.d("WindowManager", "removeChild: child=" + r + " reason=" + reason);
    L14:
        super.removeChild(r, false);
        if (inPinnedWindowingMode() == false) goto L18;
        this.mAtmService.getTaskChangeNotificationController().notifyTaskStackChanged();
    L18:
        if (this.mDecorSurfaceContainer == null) goto L23;
        if (r != this.mDecorSurfaceContainer.mOwnerTaskFragment) goto L23;
        removeDecorSurface();
    L23:
        if (hasChild() == false) goto L28;
        updateEffectiveIntent();
        if (onlyHasTaskOverlayActivities(true) == false) goto L33;
        this.mTaskSupervisor.removeTask(this, false, false, reason);
        return;
    L33:
        return;
    L28:
        if (this.mReuseTask == false) goto L30;
        return;
    L30:
        if (shouldRemoveSelfOnLastChildRemoval() == false) goto L36;
        removeIfPossible(reason + ", last child = " + r + " in " + this);
        return;
    }

    boolean onlyHasTaskOverlayActivities(boolean includeFinishing) {
        int count = 0;
        int i = getChildCount() - 1;
    L4:
        if (i < 0) goto L18;
        ActivityRecord r = getChildAt(i).asActivityRecord();
        if (r == null) goto L7;
        if (includeFinishing == true) goto L13;
        if (r.finishing == false) goto L13;
    L16:
        i = i - 1;
    L13:
        if (r.isTaskOverlay() == false) goto L14;
        count = count + 1;
        goto L16
    L14:
        return false;
    L7:
        return false;
    L18:
        if (count <= 0) goto L21;
        return true;
    L21:
        return false;
    }

    private boolean shouldAutoRemoveFromRecents(TaskFragment oldParentFragment) {
        if (this.autoRemoveRecents == false) goto L5;
    L17:
        return true;
    L5:
        if (hasChild() == false) goto L7;
    L8:
        if (oldParentFragment == null) goto L12;
        if (oldParentFragment.isEmbedded() == true) goto L17;
    L12:
        if (this.mDisplayContent != null) goto L14;
    L16:
        return false;
    L14:
        if (this.mDisplayContent.canShowTasksInHostDeviceRecents() == true) goto L16;
    L7:
        if (getHasBeenVisible() == false) goto L17;
        goto L8
    }

    private void clearPinnedTaskIfNeed() {
        if (this.mChildPipActivity != null) goto L5;
        return;
    L5:
        if (this.mChildPipActivity.getTask() == null) goto L9;
        this.mTaskSupervisor.removeRootTask(this.mChildPipActivity.getTask());
        return;
    }

    void removeActivities(final String reason, final boolean excludingTaskOverlay) {
        clearPinnedTaskIfNeed();
        if (getRootTask() != null) goto L5;
        forAllActivities(new Task$$ExternalSyntheticLambda19(this, excludingTaskOverlay, reason));
        return;
    L5:
        final ArrayList<ActivityRecord> finishingActivities = new ArrayList();
        forAllActivities(new Task$$ExternalSyntheticLambda20(excludingTaskOverlay, finishingActivities));
        int i = finishingActivities.size() - 1;
    L6:
        if (i < 0) goto L19;
        ActivityRecord r = finishingActivities.get(i);
        if (r.isState(ActivityRecord.State.RESUMED) == false) goto L10;
    L13:
        r.finishIfPossible(reason, false);
    L14:
        i = i - 1;
        goto L6
    L10:
        if (r.isVisible() == true) goto L13;
        r.destroyIfPossible(reason);
        goto L14
    }

    private /* synthetic */ void lambda$removeActivities$3(boolean excludingTaskOverlay, String reason, ActivityRecord r) {
        if (r.finishing == true) goto L10;
        if (excludingTaskOverlay == true) goto L6;
    L8:
        r.takeFromHistory();
        removeChild(r, reason);
        return;
    L6:
        if (r.isTaskOverlay() == false) goto L8;
        return;
    }

    private static /* synthetic */ void lambda$removeActivities$4(boolean excludingTaskOverlay, ArrayList finishingActivities, ActivityRecord r) {
        if (r.finishing == true) goto L10;
        if (excludingTaskOverlay == true) goto L6;
    L8:
        finishingActivities.add(r);
        return;
    L6:
        if (r.isTaskOverlay() == false) goto L8;
        return;
    }

    void performClearTaskForReuse(boolean excludingTaskOverlay) {
        this.mReuseTask = true;
        this.mTaskSupervisor.beginDeferResume();
        removeActivities("clear-task-all", excludingTaskOverlay);     // Catch: Throwable -> L6
        this.mTaskSupervisor.endDeferResume();
        this.mReuseTask = false;
        return;
    L6:
        th = move-exception;
        this.mTaskSupervisor.endDeferResume();
        this.mReuseTask = false;
        throw th;
    }

    ActivityRecord performClearTop(ActivityRecord newR, int launchFlags, int[] finishCount) {
        this.mReuseTask = true;
        this.mTaskSupervisor.beginDeferResume();
        ActivityRecord result = clearTopActivities(newR, launchFlags, finishCount);     // Catch: Throwable -> L6
        this.mTaskSupervisor.endDeferResume();
        this.mReuseTask = false;
        return result;
    L6:
        th = move-exception;
        this.mTaskSupervisor.endDeferResume();
        this.mReuseTask = false;
        throw th;
    }

    private ActivityRecord clearTopActivities(ActivityRecord newR, int launchFlags, final int[] finishCount) {
        ActivityRecord r = findActivityInHistory(newR.mActivityComponent, newR.mUserId);
        if (r != null) goto L6;
        return null;
    L6:
        moveTaskFragmentsToBottomIfNeeded(r, finishCount);
        PooledPredicate f = PooledLambda.obtainPredicate(new Task$$ExternalSyntheticLambda11(finishCount), PooledLambda.__(ActivityRecord.class), r);
        forAllActivities(f);
        f.recycle();
        if (r.launchMode == 0) goto L9;
    L15:
        return r;
    L9:
        if ((536870912 & launchFlags) != 0) goto L15;
        if (ActivityStarter.isDocumentLaunchesIntoExisting(launchFlags) == true) goto L15;
        if (r.finishing == true) goto L15;
        r.finishIfPossible("clear-task-top", false);
        goto L15
    }

    private static /* synthetic */ boolean lambda$clearTopActivities$5(int[] finishCount, ActivityRecord ar, ActivityRecord boundaryActivity) {
        return finishActivityAbove(ar, boundaryActivity, finishCount);
    }

    void moveTaskFragmentsToBottomIfNeeded(ActivityRecord r, int[] finishCount) {
        int activityIndex = this.mChildren.indexOf(r);
        if (activityIndex >= 0) goto L5;
        return;
    L5:
        List<TaskFragment> taskFragmentsToMove = null;
        int i = this.mChildren.size() - 1;
    L6:
        if (i <= activityIndex) goto L16;
        TaskFragment taskFragment = ((WindowContainer) this.mChildren.get(i)).asTaskFragment();
        if (taskFragment == null) goto L14;
        if (taskFragment.isMoveToBottomIfClearWhenLaunch() == false) goto L14;
        if (taskFragmentsToMove != null) goto L13;
        taskFragmentsToMove = new ArrayList();
    L13:
        taskFragmentsToMove.add(taskFragment);
    L14:
        i = i - 1;
        goto L6
    L16:
        if (taskFragmentsToMove != null) goto L18;
        return;
    L18:
        int size = taskFragmentsToMove.size();
        int i2 = 0;
    L20:
        if (i2 >= size) goto L22;
        TaskFragment taskFragment2 = taskFragmentsToMove.get(i2);
        this.mTransitionController.collect(taskFragment2);
        positionChildAt(Integer.MIN_VALUE, taskFragment2, false);
        i2 = i2 + 1;
        goto L20
    L22:
        int i3 = finishCount[0];
        finishCount[0] = i3 + size;
    }

    private static boolean finishActivityAbove(ActivityRecord r, ActivityRecord boundaryActivity, int[] finishCount) {
        if (r != boundaryActivity) goto L6;
        return true;
    L6:
        if (r.finishing == false) goto L8;
    L13:
        return false;
    L8:
        if (r.isTaskOverlay() == true) goto L13;
        ActivityOptions opts = r.getOptions();
        if (opts == null) goto L12;
        r.clearOptionsAnimation();
        boundaryActivity.updateOptionsLocked(opts);
    L12:
        finishCount[0] = finishCount[0] + 1;
        r.finishIfPossible("clear-task-stack", false);
        goto L13
    }

    String lockTaskAuthToString() {
        switch(this.mLockTaskAuth) {
            case 0: goto L14;
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L8;
            case 4: goto L6;
            default: goto L5;
        };
    L6:
        return "LOCK_TASK_AUTH_LAUNCHABLE_PRIV";
    L8:
        return "LOCK_TASK_AUTH_ALLOWLISTED";
    L10:
        return "LOCK_TASK_AUTH_LAUNCHABLE";
    L12:
        return "LOCK_TASK_AUTH_PINNABLE";
    L14:
        return "LOCK_TASK_AUTH_DONT_LOCK";
    L5:
        return "unknown=" + this.mLockTaskAuth;
    }

    void setLockTaskAuth() {
        setLockTaskAuth(getRootActivity());
    }

    private void setLockTaskAuth(ActivityRecord r) {
        this.mLockTaskAuth = this.mAtmService.getLockTaskController().getLockTaskAuth(r, this);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_LOCKTASK_enabled[0] == false) goto L6;
        String protoLogParam0 = String.valueOf(this);
        String protoLogParam1 = String.valueOf(lockTaskAuthToString());
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_LOCKTASK, 38991867929900764L, 0, new Object[]{protoLogParam0, protoLogParam1});
        return;
    }

    boolean supportsFreeform() {
        return supportsFreeformInDisplayArea(getDisplayArea());
    }

    boolean supportsFreeformInDisplayArea(TaskDisplayArea tda) {
        if (this.mAtmService.mSupportsFreeformWindowManagement == true) goto L5;
    L7:
        return false;
    L5:
        if (supportsMultiWindowInDisplayArea(tda) == false) goto L7;
        return true;
    }

    private static boolean persistTaskBounds(WindowConfiguration configuration) {
        if (Features.FEAT_QUICK_WIN == false) goto L8;
        if (configuration.getWindowingMode() != 5) goto L8;
        return false;
    L8:
        if (configuration.getWindowingMode() != 5) goto L11;
        return true;
    L11:
        return false;
    }

    private static boolean allowIndependentBoundsFromParent(WindowConfiguration configuration) {
        if (configuration.getWindowingMode() != 5) goto L5;
        return true;
    L5:
        return false;
    }

    boolean canBeLaunchedOnDisplay(int displayId) {
        return this.mTaskSupervisor.canPlaceEntityOnDisplay(displayId, -1, -1, this);
    }

    private void updateForceResizeOverrides(ActivityRecord r) {
        AppCompatResizeOverrides resizeOverrides = r.mAppCompatController.getResizeOverrides();
        if (resizeOverrides.shouldOverrideForceResizeApp() == false) goto L5;
    L10:
        boolean r1 = true;
    L11:
        this.mForceResizeOverride = r1;
        this.mForceNonResizeOverride = resizeOverrides.shouldOverrideForceNonResizeApp();
        return;
    L5:
        if (r.isUniversalResizeable() == true) goto L10;
        if (r.mAppCompatController.getAspectRatioOverrides().hasFullscreenOverride() == true) goto L10;
        r1 = false;
        goto L11
    }

    private boolean canResizeToBounds(Rect bounds) {
        if (bounds != null) goto L5;
    L33:
        return true;
    L5:
        if (inFreeformWindowingMode() == false) goto L33;
        if (bounds.width() <= bounds.height()) goto L10;
        boolean landscape = true;
    L11:
        Rect configBounds = getRequestedOverrideBounds();
        if (this.mResizeMode != 7) goto L25;
        if (configBounds.isEmpty() == false) goto L16;
        return true;
    L16:
        if (configBounds.width() <= configBounds.height()) goto L18;
        boolean r4 = true;
    L19:
        if (landscape != r4) goto L23;
        return true;
    L23:
        return false;
    L18:
        r4 = false;
        goto L19
    L25:
        if (this.mResizeMode != 6) goto L28;
        if (landscape == false) goto L28;
    L32:
        return false;
    L28:
        if (this.mResizeMode != 5) goto L36;
        if (landscape == false) goto L32;
        return true;
    L36:
        return true;
    L10:
        landscape = false;
        goto L11
    }

    boolean isClearingToReuseTask() {
        return this.mReuseTask;
    }

    ActivityRecord findActivityInHistory(ComponentName component, int userId) {
        PooledPredicate p = PooledLambda.obtainPredicate(new Task$$ExternalSyntheticLambda37(), PooledLambda.__(ActivityRecord.class), component, Integer.valueOf(userId));
        ActivityRecord r = getActivity(p);
        p.recycle();
        return r;
    }

    private static boolean matchesActivityInHistory(ActivityRecord r, ComponentName activityComponent, int userId) {
        if (r.finishing == false) goto L5;
    L9:
        return false;
    L5:
        if (r.mActivityComponent.equals(activityComponent) == false) goto L9;
        if (r.mUserId != userId) goto L9;
        return true;
    }

    void updateTaskDescription() {
        ActivityRecord root = getRootActivity(true);
        if (root != null) goto L5;
        return;
    L5:
        ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription();
        PooledPredicate f = PooledLambda.obtainPredicate(new Task$$ExternalSyntheticLambda18(), PooledLambda.__(ActivityRecord.class), root, taskDescription);
        forAllActivities(f);
        f.recycle();
        taskDescription.setResizeMode(this.mResizeMode);
        taskDescription.setMinWidth(this.mMinWidth);
        taskDescription.setMinHeight(this.mMinHeight);
        setTaskDescription(taskDescription);
        this.mAtmService.getTaskChangeNotificationController().notifyTaskDescriptionChanged(getTaskInfo());
        WindowContainer parent = getParent();
        if (parent == null) goto L10;
        Task t = parent.asTask();
        if (t == null) goto L10;
        t.updateTaskDescription();
    L10:
        dispatchTaskInfoChangedIfNeeded(false);
    }

    private static boolean setTaskDescriptionFromActivityAboveRoot(ActivityRecord r, ActivityRecord root, ActivityManager.TaskDescription td) {
        if (r.isTaskOverlay() == false) goto L5;
    L38:
        if (r != root) goto L40;
        return true;
    L40:
        return false;
    L5:
        if (r.taskDescription == null) goto L38;
        ActivityManager.TaskDescription atd = r.taskDescription;
        if (td.getLabel() != null) goto L10;
        td.setLabel(atd.getLabel());
    L10:
        if (td.getRawIcon() != null) goto L13;
        td.setIcon(atd.getRawIcon());
    L13:
        if (td.getIconFilename() != null) goto L16;
        td.setIconFilename(atd.getIconFilename());
    L16:
        if (td.getPrimaryColor() != 0) goto L19;
        td.setPrimaryColor(atd.getPrimaryColor());
    L19:
        if (td.getBackgroundColor() != 0) goto L22;
        td.setBackgroundColor(atd.getBackgroundColor());
    L22:
        if (td.getStatusBarColor() != 0) goto L25;
        td.setStatusBarColor(atd.getStatusBarColor());
        td.setEnsureStatusBarContrastWhenTransparent(atd.getEnsureStatusBarContrastWhenTransparent());
    L25:
        if (td.getSystemBarsAppearance() != 0) goto L28;
        td.setSystemBarsAppearance(atd.getSystemBarsAppearance());
    L28:
        if (td.getTopOpaqueSystemBarsAppearance() != 0) goto L33;
        if (r.fillsParent() == false) goto L33;
        td.setTopOpaqueSystemBarsAppearance(atd.getSystemBarsAppearance());
    L33:
        if (td.getNavigationBarColor() != 0) goto L36;
        td.setNavigationBarColor(atd.getNavigationBarColor());
        td.setEnsureNavigationBarContrastWhenTransparent(atd.getEnsureNavigationBarContrastWhenTransparent());
    L36:
        if (td.getBackgroundColorFloating() != 0) goto L38;
        td.setBackgroundColorFloating(atd.getBackgroundColorFloating());
        goto L38
    }

    void updateEffectiveIntent() {
        ActivityRecord root = getRootActivity(true);
        if (root == null) goto L6;
        setIntent(root);
        updateTaskDescription();
        return;
    }

    void setLastNonFullscreenBounds(Rect bounds) {
        if (this.mLastNonFullscreenBounds != null) goto L5;
        this.mLastNonFullscreenBounds = new Rect(bounds);
        return;
    L5:
        this.mLastNonFullscreenBounds.set(bounds);
    }

    private void onConfigurationChangedInner(Configuration newParentConfig) {
        boolean prevPersistTaskBounds = persistTaskBounds(getWindowConfiguration());
        boolean nextPersistTaskBounds = persistTaskBounds(getRequestedOverrideConfiguration().windowConfiguration);
        if (getRequestedOverrideWindowingMode() != 0) goto L5;
        nextPersistTaskBounds = persistTaskBounds(newParentConfig.windowConfiguration);
    L5:
        boolean pipChanging = true;
        if (getRequestedOverrideConfiguration().windowConfiguration.getBounds() != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        boolean nextPersistTaskBounds2 = nextPersistTaskBounds & r2;
        if (prevPersistTaskBounds == true) goto L20;
        if (nextPersistTaskBounds2 == false) goto L20;
        if (this.mLastNonFullscreenBounds == null) goto L20;
        if (this.mLastNonFullscreenBounds.isEmpty() == true) goto L20;
        getRequestedOverrideConfiguration().windowConfiguration.setBounds(this.mLastNonFullscreenBounds);
    L20:
        int prevWinMode = getWindowingMode();
        this.mTmpPrevBounds.set(getBounds());
        boolean wasInMultiWindowMode = inMultiWindowMode();
        boolean wasInPictureInPicture = inPinnedWindowingMode();
        super.onConfigurationChanged(newParentConfig);
        if (this.mDisplayContent != null) goto L23;
        return;
    L23:
        updateSurfaceSize(getSyncTransaction());
        if (wasInPictureInPicture != inPinnedWindowingMode()) goto L27;
        pipChanging = false;
    L27:
        if (pipChanging == false) goto L30;
        this.mTaskSupervisor.scheduleUpdatePictureInPictureModeIfNeeded(this, getRootTask());
    L33:
        if (shouldStartChangeTransition(prevWinMode, this.mTmpPrevBounds) == false) goto L36;
        this.mTransitionController.collectVisibleChange(this);
    L36:
        if (persistTaskBounds(getWindowConfiguration()) == false) goto L40;
        Rect currentBounds = getRequestedOverrideBounds();
        if (currentBounds.isEmpty() == true) goto L40;
        setLastNonFullscreenBounds(currentBounds);
    L40:
        if (pipChanging == false) goto L49;
        if (wasInPictureInPicture == false) goto L49;
        if (this.mTransitionController.isShellTransitionsEnabled() == true) goto L49;
        ActivityRecord r = topRunningActivity();
        if (r == null) goto L49;
        if (this.mDisplayContent.isFixedRotationLaunchingApp(r) == false) goto L49;
        resetSurfaceControlTransforms();
    L49:
        saveLaunchingStateIfNeeded();
        boolean taskOrgChanged = updateTaskOrganizerState();
        if (taskOrgChanged == false) goto L54;
        updateSurfacePosition(getSyncTransaction());
        if (isOrganized() == true) goto L54;
        updateSurfaceSize(getSyncTransaction());
    L54:
        if (taskOrgChanged == true) goto L57;
        dispatchTaskInfoChangedIfNeeded(false);
        return;
    L57:
        return;
    L30:
        if (wasInMultiWindowMode == inMultiWindowMode()) goto L33;
        this.mTaskSupervisor.scheduleUpdateMultiWindowMode(this);
        goto L33
    L8:
        if (getRequestedOverrideConfiguration().windowConfiguration.getBounds().isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    @Override // com.android.server.wm.TaskFragment, com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public void onConfigurationChanged(Configuration newParentConfig) {
        if (this.mDisplayContent == null) goto L8;
        if (this.mDisplayContent.mPinnedTaskController.isFreezingTaskConfig(this) == false) goto L8;
        return;
    L8:
        if (isRootTask() == true) goto L11;
        onConfigurationChangedInner(newParentConfig);
        return;
    L11:
        int prevWindowingMode = getWindowingMode();
        boolean prevIsAlwaysOnTop = isAlwaysOnTop();
        int prevRotation = getWindowConfiguration().getRotation();
        Rect newBounds = this.mTmpRect;
        getBounds(newBounds);
        if (newParentConfig.orientation != 2) goto L15;
        this.mExt.setLandFreeformToFull(false);
    L15:
        if (this.mExt.isFreeformToFullChangeOrientation() == false) goto L17;
        this.mExt.setFreeformToFullChangeOrientation(newParentConfig.orientation);
    L17:
        onConfigurationChangedInner(newParentConfig);
        TaskDisplayArea taskDisplayArea = getDisplayArea();
        if (taskDisplayArea != null) goto L20;
        return;
    L20:
        boolean rotationChanged = true;
        if (prevWindowingMode == getWindowingMode()) goto L31;
        getExt().onRootTaskWindowingModeChanged(prevWindowingMode);
        if (prevWindowingMode == 5) goto L25;
    L29:
        SysOptBridge.getFactory().getDynamicRefreshRateService().onRootTaskWindowingModeChanged(getBasePackageName(), topRunningActivity(), prevWindowingMode, getWindowingMode());
        taskDisplayArea.onRootTaskWindowingModeChanged(this);
        goto L31
    L25:
        if (getWindowingMode() != 1) goto L29;
        ZTEActivityEventsInternal zteActivityEventsInternal = (ZTEActivityEventsInternal) LocalServices.getService(ZTEActivityEventsInternal.class);
        if (zteActivityEventsInternal == null) goto L29;
        zteActivityEventsInternal.notifyActivityEvent(2048, getDisplayId(), this.mUserId, topRunningActivity(), getRootTaskId());
    L31:
        if (isOrganized() == true) goto L43;
        if (getRequestedOverrideBounds().isEmpty() == true) goto L43;
        if (this.mDisplayContent == null) goto L43;
        int newRotation = getWindowConfiguration().getRotation();
        if (prevRotation != newRotation) goto L40;
        rotationChanged = false;
    L40:
        if (rotationChanged == false) goto L43;
        this.mDisplayContent.rotateBounds(prevRotation, newRotation, newBounds);
        setBounds(newBounds);
    L43:
        if (prevIsAlwaysOnTop == isAlwaysOnTop()) goto L46;
        taskDisplayArea.positionChildAt(Integer.MAX_VALUE, this, false);
        return;
    }

    void resolveLeafTaskOnlyOverrideConfigs(Configuration newParentConfig, Rect previousBounds) {
        if (isLeafTask() == true) goto L5;
        return;
    L5:
        int windowingMode = getResolvedOverrideConfiguration().windowConfiguration.getWindowingMode();
        if (windowingMode != 0) goto L8;
        windowingMode = newParentConfig.windowConfiguration.getWindowingMode();
    L8:
        getConfiguration().windowConfiguration.setWindowingMode(windowingMode);
        Rect outOverrideBounds = getResolvedOverrideConfiguration().windowConfiguration.getBounds();
        if (windowingMode == 1) goto L11;
        adjustForMinimalTaskDimensions(outOverrideBounds, previousBounds, newParentConfig);
        if (windowingMode != 5) goto L18;
        computeFreeformBounds(outOverrideBounds, newParentConfig);
        return;
    L18:
        return;
    L11:
        if (this.mCreatedByOrganizer == true) goto L19;
        outOverrideBounds.setEmpty();
        return;
    }

    void adjustForMinimalTaskDimensions(Rect bounds, Rect previousBounds, Configuration parentConfig) {
        if (Features.FEAT_QUICK_WIN == false) goto L7;
        if (inFreeformWindowingMode() == false) goto L7;
        return;
    L7:
        if (this.mFullConfiguration.windowConfiguration.getWindowingMode() != 6) goto L10;
        return;
    L10:
        if (inPinnedWindowingMode() == false) goto L13;
        Slog.i("ActivityTaskManager", "Skip adjustForMinimalTaskDimensions for pip task");
        return;
    L13:
        int minWidth = this.mMinWidth;
        int minHeight = this.mMinHeight;
        if (this.mDisplayContent != null) goto L16;
        int defaultMinSizeDp = 220;
    L17:
        float density = parentConfig.densityDpi / 160.0f;
        int defaultMinSize = (int) (defaultMinSizeDp * density);
        if (minWidth != (-1)) goto L20;
        minWidth = defaultMinSize;
    L20:
        if (minHeight != (-1)) goto L23;
        minHeight = defaultMinSize;
    L23:
        if (bounds.isEmpty() == false) goto L30;
        Rect parentBounds = parentConfig.windowConfiguration.getBounds();
        if (parentBounds.width() >= minWidth) goto L27;
    L29:
        bounds.set(parentBounds);
        goto L30
    L27:
        if (parentBounds.height() < minHeight) goto L29;
        return;
    L30:
        boolean adjustHeight = false;
        if (minWidth <= bounds.width()) goto L33;
        boolean adjustWidth = true;
    L35:
        if (minHeight <= bounds.height()) goto L37;
        adjustHeight = true;
    L37:
        if (adjustWidth == true) goto L40;
        if (adjustHeight == true) goto L40;
        return;
    L40:
        if (adjustWidth == true) goto L42;
    L47:
        if (adjustHeight == true) goto L49;
        return;
    L49:
        if (previousBounds.isEmpty() == false) goto L51;
    L53:
        bounds.bottom = bounds.top + minHeight;
        return;
    L51:
        if (bounds.bottom != previousBounds.bottom) goto L53;
        bounds.top = bounds.bottom - minHeight;
        return;
    L42:
        if (previousBounds.isEmpty() == false) goto L44;
    L46:
        bounds.right = bounds.left + minWidth;
        goto L47
    L44:
        if (bounds.right != previousBounds.right) goto L46;
        bounds.left = bounds.right - minWidth;
        goto L47
    L33:
        adjustWidth = false;
        goto L35
    L16:
        defaultMinSizeDp = this.mDisplayContent.mMinSizeOfResizeableTaskDp;
        goto L17
    }

    private void computeFreeformBounds(Rect outBounds, Configuration newParentConfig) {
        if (Features.FEAT_QUICK_WIN == false) goto L5;
        return;
    L5:
        float density = newParentConfig.densityDpi / 160.0f;
        Rect parentBounds = new Rect(newParentConfig.windowConfiguration.getBounds());
        DisplayContent display = getDisplayContent();
        if (display == null) goto L8;
        Rect stableBounds = new Rect();
        display.getStableRect(stableBounds);
        parentBounds.intersect(stableBounds);
    L8:
        fitWithinBounds(outBounds, parentBounds, (int) (48.0f * density), (int) (32.0f * density));
        int offsetTop = parentBounds.top - outBounds.top;
        if (offsetTop <= 0) goto L12;
        outBounds.offset(0, offsetTop);
        return;
    }

    private static void fitWithinBounds(Rect bounds, Rect rootTaskBounds, int overlapPxX, int overlapPxY) {
        if (rootTaskBounds != null) goto L4;
        return;
    L4:
        if (rootTaskBounds.isEmpty() == false) goto L6;
        return;
    L6:
        if (rootTaskBounds.contains(bounds) == true) goto L24;
        int horizontalDiff = 0;
        int overlapLR = Math.min(overlapPxX, bounds.width());
        if (bounds.right >= (rootTaskBounds.left + overlapLR)) goto L12;
        horizontalDiff = overlapLR - (bounds.right - rootTaskBounds.left);
    L14:
        int verticalDiff = 0;
        int overlapTB = Math.min(overlapPxY, bounds.width());
        if (bounds.bottom >= (rootTaskBounds.top + overlapTB)) goto L18;
        verticalDiff = overlapTB - (bounds.bottom - rootTaskBounds.top);
    L20:
        bounds.offset(horizontalDiff, verticalDiff);
        return;
    L18:
        if (bounds.top <= (rootTaskBounds.bottom - overlapTB)) goto L20;
        verticalDiff = -(overlapTB - (rootTaskBounds.bottom - bounds.top));
        goto L20
    L12:
        if (bounds.left <= (rootTaskBounds.right - overlapLR)) goto L14;
        horizontalDiff = -(overlapLR - (rootTaskBounds.right - bounds.left));
        goto L14
    }

    private boolean shouldStartChangeTransition(int prevWinMode, Rect prevBounds) {
        if (isLeafTask() == true) goto L7;
        if (this.mCreatedByOrganizer == true) goto L7;
    L8:
        return false;
    L7:
        if (canStartChangeTransition() == false) goto L8;
        int newWinMode = getWindowingMode();
        if (this.mTransitionController.inTransition(this) == false) goto L20;
        Rect newBounds = getConfiguration().windowConfiguration.getBounds();
        if (prevWinMode != newWinMode) goto L18;
        if (prevBounds.width() != newBounds.width()) goto L18;
        if (prevBounds.height() != newBounds.height()) goto L18;
        return false;
    L18:
        return true;
    L20:
        if (prevWinMode != 5) goto L22;
        boolean r4 = true;
    L23:
        if (newWinMode != 5) goto L25;
        boolean r2 = true;
    L26:
        if (r4 != r2) goto L28;
        return false;
    L28:
        return true;
    L25:
        r2 = false;
        goto L26
    L22:
        r4 = false;
        goto L23
    }

    @Override // com.android.server.wm.WindowContainer
    void migrateToNewSurfaceControl(SurfaceControl.Transaction t) {
        super.migrateToNewSurfaceControl(t);
        this.mLastSurfaceSize.x = 0;
        this.mLastSurfaceSize.y = 0;
        updateSurfaceSize(t);
    }

    void updateSurfaceSize(SurfaceControl.Transaction transaction) {
        if (this.mSurfaceControl != null) goto L5;
        return;
    L5:
        if (isOrganized() == true) goto L20;
        int width = 0;
        int height = 0;
        if (isRootTask() == false) goto L13;
        if (this.mTransitionController.mIsWaitingForDisplayEnabled == true) goto L13;
        Rect taskBounds = getBounds();
        width = taskBounds.width();
        height = taskBounds.height();
    L13:
        if (width == this.mLastSurfaceSize.x) goto L15;
    L17:
        transaction.setWindowCrop(this.mSurfaceControl, width, height);
        this.mLastSurfaceSize.set(width, height);
        return;
    L15:
        if (height != this.mLastSurfaceSize.y) goto L17;
        return;
    }

    @Override // com.android.server.wm.TaskFragment, com.android.server.wm.WindowContainer
    void writeIdentifierToProto(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, System.identityHashCode(this));
        proto.write(1120986464258L, this.mUserId);
        if (this.intent != null) goto L5;
    L7:
        String r2 = "Task";
    L8:
        proto.write(1138166333443L, r2);
        proto.end(token);
        return;
    L5:
        if (this.intent.getComponent() == null) goto L7;
        r2 = this.intent.getComponent().flattenToShortString();
        goto L8
    }

    private void saveLaunchingStateIfNeeded() {
        saveLaunchingStateIfNeeded(getDisplayContent());
    }

    private void saveLaunchingStateIfNeeded(DisplayContent display) {
        if (isLeafTask() == true) goto L6;
        return;
    L6:
        if (getHasBeenVisible() == true) goto L8;
        return;
    L8:
        int windowingMode = getWindowingMode();
        if (windowingMode == 1) goto L13;
        if (windowingMode == 5) goto L13;
        return;
    L13:
        if (getTaskDisplayArea() != null) goto L15;
        return;
    L15:
        if (getTaskDisplayArea().getWindowingMode() != 5) goto L20;
        this.mTaskSupervisor.mLaunchParamsPersister.saveTask(this, display);
        return;
    }

    void updateOverrideConfigurationFromLaunchBounds() {
        Task rootTask = getRootTask();
        boolean r1 = false;
        if (rootTask == this) goto L5;
        boolean hasParentTask = true;
    L6:
        int windowingMode = getWindowingMode();
        if (isActivityTypeStandardOrUndefined() == false) goto L11;
        if (windowingMode == 1) goto L11;
        boolean isNonStandardOrFullscreen = false;
    L12:
        Rect r7 = null;
        if (DesktopExperienceFlags.ENABLE_MULTIPLE_DESKTOPS_BACKEND.isTrue() == true) goto L29;
        if (hasParentTask == true) goto L16;
    L18:
        if (isNonStandardOrFullscreen == false) goto L24;
        if (isResizeable() == false) goto L22;
        r7 = rootTask.getRequestedOverrideBounds();
    L22:
        Rect bounds = r7;
    L27:
        setBounds(bounds);
        return;
    L24:
        if (persistTaskBounds(getWindowConfiguration()) == true) goto L26;
        bounds = rootTask.getRequestedOverrideBounds();
        goto L27
    L26:
        bounds = this.mLastNonFullscreenBounds;
        goto L27
    L16:
        if (rootTask.isOrganized() == false) goto L18;
        bounds = null;
        goto L27
    L29:
        if (isNonStandardOrFullscreen == true) goto L31;
    L33:
        boolean shouldInheritBounds = false;
    L34:
        if (hasParentTask == true) goto L36;
    L40:
        boolean r8 = false;
    L41:
        boolean shouldInheritBounds2 = shouldInheritBounds | r8;
        if (hasParentTask == false) goto L50;
        if (allowIndependentBoundsFromParent(getWindowConfiguration()) == true) goto L46;
    L47:
        r1 = true;
        goto L50
    L46:
        if (persistTaskBounds(getWindowConfiguration()) == false) goto L47;
    L50:
        if ((r1 | shouldInheritBounds2) == false) goto L53;
        setBounds(null);
        return;
    L53:
        if (hasParentTask == false) goto L55;
    L57:
        setBounds(this.mLastNonFullscreenBounds);
        return;
    L55:
        if (persistTaskBounds(getWindowConfiguration()) == true) goto L57;
        return;
    L36:
        if (rootTask.isOrganized() == false) goto L40;
        if (isOrganized() == true) goto L40;
        r8 = true;
        goto L41
    L31:
        if (isResizeable() == true) goto L33;
        shouldInheritBounds = true;
    L11:
        isNonStandardOrFullscreen = true;
        goto L12
    L5:
        hasParentTask = false;
        goto L6
    }

    void setRootProcess(WindowProcessController proc) {
        clearRootProcess();
        if (this.intent != null) goto L5;
        return;
    L5:
        if ((this.intent.getFlags() & 8388608) != 0) goto L9;
        this.mRootProcess = proc;
        this.mRootProcess.addRecentTask(this);
        return;
    }

    void clearRootProcess() {
        if (this.mRootProcess == null) goto L6;
        this.mRootProcess.removeRecentTask(this);
        this.mRootProcess = null;
        return;
    }

    int getRootTaskId() {
        return getRootTask().mTaskId;
    }

    Task getOrganizedTask() {
        if (isOrganized() == false) goto L5;
        return this;
    L5:
        WindowContainer parent = getParent();
        if (parent != null) goto L8;
        return null;
    L8:
        Task parentTask = parent.asTask();
        if (parentTask != null) goto L12;
        return null;
    L12:
        return parentTask.getOrganizedTask();
    }

    Task getCreatedByOrganizerTask() {
        if (this.mCreatedByOrganizer == false) goto L5;
        return this;
    L5:
        WindowContainer parent = getParent();
        if (parent != null) goto L8;
        return null;
    L8:
        Task parentTask = parent.asTask();
        if (parentTask != null) goto L12;
        return null;
    L12:
        return parentTask.getCreatedByOrganizerTask();
    }

    Task getTaskWithAdjacent() {
        if (hasAdjacentTaskFragment() == false) goto L5;
        return this;
    L5:
        WindowContainer parent = getParent();
        if (parent != null) goto L8;
        return null;
    L8:
        if (parent.asTask() != null) goto L11;
        return null;
    L11:
        return parent.asTask().getTaskWithAdjacent();
    }

    boolean hasAdjacentTask() {
        if (getTaskWithAdjacent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    void forOtherAdjacentTasks(final Consumer<Task> callback) {
        Task taskWithAdjacent = getTaskWithAdjacent();
        if (taskWithAdjacent != null) goto L5;
        return;
    L5:
        TaskFragment.AdjacentSet adjacentTasks = taskWithAdjacent.getAdjacentTaskFragments();
        adjacentTasks.forAllTaskFragments(new Task$$ExternalSyntheticLambda2(callback), taskWithAdjacent);
    }

    private static /* synthetic */ void lambda$forOtherAdjacentTasks$6(Consumer callback, TaskFragment tf) {
        callback.accept(tf.asTask());
    }

    boolean forOtherAdjacentTasks(final Predicate<Task> callback) {
        Task taskWithAdjacent = getTaskWithAdjacent();
        if (taskWithAdjacent != null) goto L6;
        return false;
    L6:
        TaskFragment.AdjacentSet adjacentTasks = taskWithAdjacent.getAdjacentTaskFragments();
        return adjacentTasks.forAllTaskFragments(new Task$$ExternalSyntheticLambda9(callback), taskWithAdjacent);
    }

    private static /* synthetic */ boolean lambda$forOtherAdjacentTasks$7(Predicate callback, TaskFragment tf) {
        return callback.test(tf.asTask());
    }

    boolean isRootTask() {
        if (getRootTask() != this) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isLeafTask() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L10;
        if (((WindowContainer) this.mChildren.get(i)).asTask() != null) goto L6;
        i = i - 1;
        goto L3
    L6:
        return false;
    L10:
        return true;
    }

    public Task getTopLeafTask() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L10;
        Task child = ((WindowContainer) this.mChildren.get(i)).asTask();
        if (child != null) goto L8;
        i = i - 1;
        goto L3
    L8:
        return child.getTopLeafTask();
    L10:
        return this;
    }

    int getDescendantTaskCount() {
        final int[] currentCount = {0};
        forAllLeafTasks(new Task$$ExternalSyntheticLambda12(currentCount), false);
        return currentCount[0];
    }

    private static /* synthetic */ void lambda$getDescendantTaskCount$8(int[] currentCount, Task t) {
        currentCount[0] = currentCount[0] + 1;
    }

    Task adjustFocusToNextFocusableTask(String reason) {
        return adjustFocusToNextFocusableTask(reason, false, true);
    }

    private Task getNextFocusableTask(final boolean allowFocusSelf) {
        WindowContainer parent = getParent();
        if (parent != null) goto L6;
        return null;
    L6:
        Task focusableTask = parent.getTask(new Task$$ExternalSyntheticLambda39(this, allowFocusSelf));
        if (focusableTask == null) goto L9;
    L12:
        return focusableTask;
    L9:
        if (parent.asTask() == null) goto L12;
        return parent.asTask().getNextFocusableTask(allowFocusSelf);
    }

    private /* synthetic */ boolean lambda$getNextFocusableTask$9(boolean allowFocusSelf, Object task) {
        if (allowFocusSelf == true) goto L5;
        if (task != this) goto L5;
    L9:
        return false;
    L5:
        if (getExt().skipQuickTask((Task) task, allowFocusSelf) == true) goto L9;
        if (((Task) task).isFocusableAndVisible() == false) goto L9;
        return true;
    }

    Task adjustFocusToNextFocusableTask(String reason, boolean allowFocusSelf, boolean moveDisplayToTop) {
        Task focusableTask = getNextFocusableTask(allowFocusSelf);
        if (focusableTask != null) goto L5;
        focusableTask = this.mRootWindowContainer.getNextFocusableRootTask(this, !allowFocusSelf);
    L5:
        if (focusableTask != null) goto L11;
        TaskDisplayArea taskDisplayArea = getDisplayArea();
        if (taskDisplayArea == null) goto L32;
        taskDisplayArea.clearPreferredTopFocusableRootTask();
        return null;
    L32:
        return null;
    L11:
        Task rootTask = focusableTask.getRootTask();
        if (moveDisplayToTop == true) goto L18;
        WindowContainer parent = focusableTask.getParent();
        Task r3 = focusableTask;
    L14:
        parent.positionChildAt(Integer.MAX_VALUE, r3, false);
        r3 = parent;
        parent = r3.getParent();
        if (r3.asTask() == null) goto L17;
        if (parent != null) goto L14;
    L17:
        return rootTask;
    L18:
        String myReason = reason + " adjustFocusToNextFocusableTask";
        ActivityRecord top = focusableTask.topRunningActivity();
        if (focusableTask.isActivityTypeHome() == false) goto L25;
        if (top != null) goto L22;
    L23:
        focusableTask.getDisplayArea().moveHomeActivityToTop(myReason);
        return rootTask;
    L22:
        if (top.isVisibleRequested() == false) goto L23;
    L25:
        focusableTask.moveToFront(myReason);
        if (rootTask.getTopResumedActivity() == null) goto L28;
        this.mTaskSupervisor.updateTopResumedActivityIfNeeded(reason);
    L28:
        return rootTask;
    }

    private int computeMinUserPosition(int minPosition, int size) {
    L2:
        if (minPosition >= size) goto L7;
        WindowContainer child = (WindowContainer) this.mChildren.get(minPosition);
        boolean canShow = child.showToCurrentUser();
        if (canShow == true) goto L7;
        minPosition = minPosition + 1;
    L7:
        return minPosition;
    }

    private int computeMaxUserPosition(int maxPosition) {
    L2:
        if (maxPosition <= 0) goto L7;
        WindowContainer child = (WindowContainer) this.mChildren.get(maxPosition);
        boolean canShow = child.showToCurrentUser();
        if (canShow == false) goto L7;
        maxPosition = maxPosition - 1;
    L7:
        return maxPosition;
    }

    private int getAdjustedChildPosition(WindowContainer wc, int suggestedPosition) {
        boolean canShowChild = wc.showToCurrentUser();
        int size = this.mChildren.size();
        int minPosition = 0;
        if (canShowChild == false) goto L5;
        minPosition = computeMinUserPosition(0, size);
    L5:
        int maxPosition = minPosition;
        if (size <= 0) goto L13;
        int r4 = size - 1;
        if (canShowChild == true) goto L11;
        r4 = computeMaxUserPosition(r4);
    L11:
        maxPosition = r4;
    L13:
        if (wc.isAlwaysOnTop() == true) goto L20;
    L14:
        if (maxPosition <= minPosition) goto L20;
        if (((WindowContainer) this.mChildren.get(maxPosition)).isAlwaysOnTop() == false) goto L20;
        maxPosition = maxPosition - 1;
    L20:
        if (suggestedPosition != Integer.MIN_VALUE) goto L24;
        if (minPosition != 0) goto L24;
        return Integer.MIN_VALUE;
    L24:
        if (suggestedPosition != Integer.MAX_VALUE) goto L29;
        if (maxPosition < (size - 1)) goto L29;
        return Integer.MAX_VALUE;
    L29:
        if (hasChild(wc) == true) goto L32;
        maxPosition = maxPosition + 1;
    L32:
        return Math.min(Math.max(suggestedPosition, minPosition), maxPosition);
    }

    @Override // com.android.server.wm.WindowContainer
    void positionChildAt(int position, WindowContainer child, boolean includingParents) {
        boolean r1 = true;
        if (position < (this.mChildren.size() - 1)) goto L5;
        boolean toTop = true;
    L6:
        int position2 = getAdjustedChildPosition(child, position);
        super.positionChildAt(position2, child, includingParents);
        if (WindowManagerDebugConfig.DEBUG_TASK_MOVEMENT == false) goto L9;
        Slog.d("WindowManager", "positionChildAt: child=" + child + " position=" + position2 + " parent=" + this);
    L9:
        Task task = child.asTask();
        if (task != null) goto L12;
        return;
    L12:
        if (position2 == Integer.MIN_VALUE) goto L15;
        r1 = false;
    L15:
        task.updateTaskMovement(toTop, r1, position2);
        return;
    L5:
        toTop = false;
        goto L6
    }

    @Override // com.android.server.wm.TaskFragment, com.android.server.wm.WindowContainer
    void removeImmediately() {
        removeImmediately("removeTask");
    }

    @Override // com.android.server.wm.TaskFragment
    void removeImmediately(String reason) {
        if (WindowManagerDebugConfig.DEBUG_ROOT_TASK == false) goto L6;
        Slog.i("ActivityTaskManager", "removeTask:" + reason + " removing taskId=" + this.mTaskId);
    L6:
        if (this.mRemoving == false) goto L8;
        return;
    L8:
        this.mRemoving = true;
        EventLogTags.writeWmTaskRemoved(this.mTaskId, getRootTaskId(), getDisplayId(), reason);
        ZTEActivityEventsInternal zteActivityEventsInternal = (ZTEActivityEventsInternal) LocalServices.getService(ZTEActivityEventsInternal.class);
        if (zteActivityEventsInternal == null) goto L11;
        zteActivityEventsInternal.notifyActivityEvent(16384, getDisplayId(), this.mUserId, topRunningActivity(), getRootTaskId());
    L11:
        clearPinnedTaskIfNeed();
        if (this.mChildPipActivity == null) goto L14;
        this.mChildPipActivity.clearLastParentBeforePip();
    L14:
        setTaskOrganizer(null);
        if (this.mDecorSurfaceContainer == null) goto L17;
        DecorSurfaceContainer.m10216$$Nest$mrelease(this.mDecorSurfaceContainer);
    L17:
        super.removeImmediately();
        this.mDisplayContent = null;
        this.mRemoving = false;
    }

    void reparent(Task rootTask, int position, boolean moveParents, String reason) {
        if (WindowManagerDebugConfig.DEBUG_ROOT_TASK == false) goto L5;
        Slog.i("ActivityTaskManager", "reParentTask: removing taskId=" + this.mTaskId + " from rootTask=" + getRootTask());
    L5:
        EventLogTags.writeWmTaskRemoved(this.mTaskId, getRootTaskId(), getDisplayId(), "reParentTask:" + reason);
        reparent(rootTask, position);
        rootTask.positionChildAt(position, this, moveParents);
    }

    public int setBounds(Rect bounds, boolean forceResize) {
        int boundsChanged = setBounds(bounds);
        if (forceResize == true) goto L5;
    L8:
        return boundsChanged;
    L5:
        if ((boundsChanged & 2) == 2) goto L8;
        onResize();
        return boundsChanged | 2;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public int setBounds(Rect bounds) {
        if (isRootTask() == true) goto L5;
        int boundsChange = super.setBounds(bounds);
        updateSurfacePositionNonOrganized();
        return boundsChange;
    L5:
        return setBounds(getRequestedOverrideBounds(), bounds);
    }

    int setBoundsUnchecked(Rect bounds) {
        int boundsChange = super.setBounds(bounds);
        updateSurfaceBounds();
        return boundsChange;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public boolean isCompatible(int windowingMode, int activityType) {
        if (activityType != 0) goto L5;
        activityType = 1;
    L5:
        return super.isCompatible(windowingMode, activityType);
    }

    @Override // com.android.server.wm.WindowContainer
    public boolean onDescendantOrientationChanged(WindowContainer requestingContainer) {
        if (super.onDescendantOrientationChanged(requestingContainer) == false) goto L6;
        return true;
    L6:
        if (getParent() == null) goto L9;
        onConfigurationChanged(getParent().getConfiguration());
        return true;
    L9:
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean handlesOrientationChangeFromDescendant(int orientation) {
        if (super.handlesOrientationChangeFromDescendant(orientation) == true) goto L6;
        return false;
    L6:
        if (isLeafTask() == true) goto L9;
        return true;
    L9:
        if (canSpecifyOrientation() == true) goto L11;
        return false;
    L11:
        if (getDisplayArea().canSpecifyOrientation(orientation) == true) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    void onDisplayChanged(DisplayContent dc) {
        int lastDisplayId = getDisplayId();
        super.onDisplayChanged(dc);
        if (isLeafTask() == false) goto L10;
        if (dc == null) goto L6;
        int displayId = dc.getDisplayId();
    L7:
        if (lastDisplayId == displayId) goto L10;
        this.mWmService.mAtmService.getTaskChangeNotificationController().notifyTaskDisplayChanged(this.mTaskId, displayId);
        goto L10
    L6:
        displayId = -1;
    L10:
        if (isRootTask() == false) goto L12;
        updateSurfaceBounds();
    L12:
        sendTaskFragmentParentInfoChangedIfNeeded();
    }

    boolean isResizeable() {
        return isResizeable(true);
    }

    boolean isResizeable(boolean checkPictureInPictureSupport) {
        if (this.mAtmService.mForceResizableActivities == true) goto L5;
    L7:
        boolean forceResizable = false;
    L9:
        if (forceResizable == false) goto L12;
        return true;
    L12:
        if (getExt().forceResizeable() == false) goto L15;
        return true;
    L15:
        if (this.mForceNonResizeOverride == false) goto L18;
        return false;
    L18:
        if (this.mForceResizeOverride == true) goto L25;
        if (ActivityInfo.isResizeableMode(this.mResizeMode) == true) goto L25;
        if (this.mSupportsPictureInPicture == false) goto L26;
        if (checkPictureInPictureSupport == true) goto L25;
        return false;
    L26:
        return false;
    L25:
        return true;
    L5:
        if (getActivityType() != 1) goto L7;
        forceResizable = true;
        goto L9
    }

    boolean preserveOrientationOnResize() {
        if (this.mResizeMode != 6) goto L5;
    L10:
        return true;
    L5:
        if (this.mResizeMode == 5) goto L10;
        if (this.mResizeMode == 7) goto L10;
        return false;
    }

    boolean cropWindowsToRootTaskBounds() {
        if (isActivityTypeHomeOrRecents() == false) goto L14;
        Task rootTask = getRootTask();
        if (rootTask.mCreatedByOrganizer == false) goto L7;
        Task topNonOrgTask = rootTask.getTopMostTask();
    L8:
        if (this != topNonOrgTask) goto L10;
        return false;
    L10:
        if (isDescendantOf(topNonOrgTask) == false) goto L14;
        return false;
    L7:
        topNonOrgTask = rootTask;
    L14:
        return isResizeable();
    }

    @Override // com.android.server.wm.WindowContainer
    void getAnimationFrames(Rect outFrame, Rect outInsets, Rect outStableInsets, Rect outSurfaceInsets) {
        if (hasAdjacentTask() == false) goto L6;
        super.getAnimationFrames(outFrame, outInsets, outStableInsets, outSurfaceInsets);
        return;
    L6:
        WindowState windowState = getTopVisibleAppMainWindow();
        if (windowState == null) goto L9;
        windowState.getAnimationFrames(outFrame, outInsets, outStableInsets, outSurfaceInsets);
        return;
    L9:
        super.getAnimationFrames(outFrame, outInsets, outStableInsets, outSurfaceInsets);
    }

    void setDragResizing(boolean dragResizing) {
        if (this.mDragResizing == dragResizing) goto L11;
        if (dragResizing == true) goto L6;
    L9:
        this.mDragResizing = dragResizing;
        resetDragResizingChangeReported();
        return;
    L6:
        if (getRootTask().getWindowConfiguration().canResizeTask() == true) goto L9;
        Slog.e("ActivityTaskManager", "Drag resize isn't allowed for root task id=" + getRootTaskId());
        return;
    }

    boolean isDragResizing() {
        return this.mDragResizing;
    }

    void cancelTaskWindowTransition() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L6;
        ((WindowContainer) this.mChildren.get(i)).cancelAnimation();
        i = i - 1;
        goto L3
    }

    boolean showForAllUsers() {
        if (this.mChildren.isEmpty() == false) goto L5;
        return false;
    L5:
        ActivityRecord r = getTopNonFinishingActivity();
        if (r != null) goto L8;
        return false;
    L8:
        if (r.mShowForAllUsers == false) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean showToCurrentUser() {
        if (this.mForceShowForAllUsers == false) goto L5;
    L10:
        return true;
    L5:
        if (showForAllUsers() == true) goto L10;
        if (this.mWmService.isUserVisible(getTopMostTask().mUserId) == true) goto L10;
        return false;
    }

    void setForceShowForAllUsers(boolean forceShowForAllUsers) {
        this.mForceShowForAllUsers = forceShowForAllUsers;
    }

    ActivityRecord getOccludingActivityAbove(final ActivityRecord activity) {
        ActivityRecord top = getActivity(new Task$$ExternalSyntheticLambda14(activity));
        if (top != activity) goto L7;
        return null;
    L7:
        return top;
    }

    private static /* synthetic */ boolean lambda$getOccludingActivityAbove$10(ActivityRecord activity, ActivityRecord r) {
        if (r != activity) goto L6;
        return true;
    L6:
        if (r.occludesParent() == true) goto L8;
        return false;
    L8:
        TaskFragment parent = r.getTaskFragment();
        if (parent != activity.getTaskFragment()) goto L11;
        return true;
    L11:
        if (parent != null) goto L13;
    L15:
        TaskFragment grandParent = parent.getParent().asTaskFragment();
    L16:
        if (grandParent == null) goto L24;
        if (parent.getBounds().equals(grandParent.getBounds()) == false) goto L24;
        if (grandParent.asTask() != null) goto L22;
        parent = grandParent;
        grandParent = parent.getParent().asTaskFragment();
        goto L16
    L22:
        return true;
    L24:
        return false;
    L13:
        if (parent.asTask() == null) goto L15;
        return true;
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public SurfaceControl.Builder makeAnimationLeash() {
        return super.makeAnimationLeash().setMetadata(3, this.mTaskId);
    }

    boolean shouldAnimate() {
        if (isOrganized() == false) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    void setInitialSurfaceControlProperties(SurfaceControl.Builder b) {
        b.setEffectLayer().setMetadata(3, this.mTaskId);
        super.setInitialSurfaceControlProperties(b);
    }

    boolean isAnimatingByRecents() {
        return this.mTransitionController.isTransientHide(this);
    }

    WindowState getTopVisibleAppMainWindow() {
        ActivityRecord activity = getTopVisibleActivity();
        if (activity != null) goto L7;
        return null;
    L7:
        return activity.findMainWindow();
    }

    ActivityRecord topRunningNonDelayedActivityLocked(ActivityRecord notTop) {
        PooledPredicate p = PooledLambda.obtainPredicate(new Task$$ExternalSyntheticLambda21(), PooledLambda.__(ActivityRecord.class), notTop);
        ActivityRecord r = getActivity(p);
        p.recycle();
        return r;
    }

    private static boolean isTopRunningNonDelayed(ActivityRecord r, ActivityRecord notTop) {
        if (r.delayedResume == true) goto L8;
        if (r == notTop) goto L8;
        if (r.canBeTopRunning() == false) goto L8;
        return true;
    L8:
        return false;
    }

    ActivityRecord topRunningActivity(IBinder token, int taskId) {
        PooledPredicate p = PooledLambda.obtainPredicate(new Task$$ExternalSyntheticLambda8(), PooledLambda.__(ActivityRecord.class), Integer.valueOf(taskId), token);
        ActivityRecord r = getActivity(p);
        p.recycle();
        return r;
    }

    private static boolean isTopRunning(ActivityRecord r, int taskId, IBinder notTop) {
        if (r.getTask().mTaskId != taskId) goto L5;
    L9:
        return false;
    L5:
        if (r.token == notTop) goto L9;
        if (r.canBeTopRunning() == false) goto L9;
        return true;
    }

    private static /* synthetic */ boolean lambda$getTopFullscreenMainWindow$11(WindowState w) {
        if (w.mAttrs.type == 1) goto L5;
    L7:
        return false;
    L5:
        if (w.mAttrs.isFullscreen() == false) goto L7;
        return true;
    }

    WindowState getTopFullscreenMainWindow() {
        return getWindow(new Task$$ExternalSyntheticLambda10());
    }

    private static /* synthetic */ boolean lambda$getTopVisibleActivity$12(ActivityRecord r) {
        if (r.mIsExiting == false) goto L5;
    L9:
        return false;
    L5:
        if (r.isClientVisible() == false) goto L9;
        if (r.isVisibleRequested() == false) goto L9;
        return true;
    }

    ActivityRecord getTopVisibleActivity() {
        return getActivity(new Task$$ExternalSyntheticLambda27());
    }

    private static /* synthetic */ boolean lambda$getTopRealVisibleActivity$13(ActivityRecord r) {
        if (r.mIsExiting == false) goto L5;
    L9:
        return false;
    L5:
        if (r.isClientVisible() == false) goto L9;
        if (r.isVisible() == false) goto L9;
        return true;
    }

    ActivityRecord getTopRealVisibleActivity() {
        return getActivity(new Task$$ExternalSyntheticLambda36());
    }

    ActivityRecord getTopWaitSplashScreenActivity() {
        return getActivity(new Task$$ExternalSyntheticLambda13());
    }

    private static /* synthetic */ boolean lambda$getTopWaitSplashScreenActivity$14(ActivityRecord r) {
        if (r.mHandleExitSplashScreen == true) goto L5;
    L7:
        return false;
    L5:
        if (r.mTransferringSplashScreenState != 1) goto L7;
        return true;
    }

    void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        this.mTaskDescription = taskDescription;
    }

    void onSnapshotChanged(TaskSnapshot snapshot) {
        this.mAtmService.getTaskChangeNotificationController().notifyTaskSnapshotChanged(this.mTaskId, snapshot);
    }

    void onSnapshotInvalidated() {
        this.mAtmService.getTaskChangeNotificationController().notifyTaskSnapshotInvalidated(this.mTaskId);
    }

    ActivityManager.TaskDescription getTaskDescription() {
        return this.mTaskDescription;
    }

    @Override // com.android.server.wm.WindowContainer
    void forAllLeafTasks(Consumer<Task> callback, boolean traverseTopToBottom) {
        int count = this.mChildren.size();
        boolean isLeafTask = true;
        if (traverseTopToBottom == false) goto L11;
        int i = count - 1;
    L5:
        if (i < 0) goto L17;
        Task child = ((WindowContainer) this.mChildren.get(i)).asTask();
        if (child == null) goto L9;
        isLeafTask = false;
        child.forAllLeafTasks(callback, traverseTopToBottom);
    L9:
        i = i - 1;
    L17:
        if (isLeafTask == false) goto L26;
        callback.accept(this);
        return;
    L26:
        return;
    L11:
        int i2 = 0;
    L12:
        if (i2 >= count) goto L17;
        Task child2 = ((WindowContainer) this.mChildren.get(i2)).asTask();
        if (child2 == null) goto L16;
        isLeafTask = false;
        child2.forAllLeafTasks(callback, traverseTopToBottom);
    L16:
        i2 = i2 + 1;
        goto L12
    }

    @Override // com.android.server.wm.WindowContainer
    void forAllTasks(Consumer<Task> callback, boolean traverseTopToBottom) {
        super.forAllTasks(callback, traverseTopToBottom);
        callback.accept(this);
    }

    @Override // com.android.server.wm.WindowContainer
    void forAllRootTasks(Consumer<Task> callback, boolean traverseTopToBottom) {
        if (isRootTask() == false) goto L6;
        callback.accept(this);
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean forAllTasks(Predicate<Task> callback) {
        if (super.forAllTasks(callback) == false) goto L7;
        return true;
    L7:
        return callback.test(this);
    }

    @Override // com.android.server.wm.WindowContainer
    boolean forAllLeafTasks(Predicate<Task> callback) {
        boolean isLeafTask = true;
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L11;
        Task child = ((WindowContainer) this.mChildren.get(i)).asTask();
        if (child == null) goto L9;
        isLeafTask = false;
        if (child.forAllLeafTasks(callback) == false) goto L9;
        return true;
    L9:
        i = i - 1;
        goto L3
    L11:
        if (isLeafTask == true) goto L13;
        return false;
    L13:
        return callback.test(this);
    }

    void forAllLeafTasksAndLeafTaskFragments(final Consumer<TaskFragment> callback, final boolean traverseTopToBottom) {
        forAllLeafTasks(new Task$$ExternalSyntheticLambda29(callback, traverseTopToBottom), traverseTopToBottom);
    }

    private static /* synthetic */ void lambda$forAllLeafTasksAndLeafTaskFragments$15(Consumer callback, boolean traverseTopToBottom, Task task) {
        if (task.isLeafTaskFragment() == false) goto L6;
        callback.accept(task);
        return;
    L6:
        boolean consumed = false;
        if (traverseTopToBottom == false) goto L19;
        int i = task.mChildren.size() - 1;
    L9:
        if (i < 0) goto L30;
        WindowContainer child = (WindowContainer) task.mChildren.get(i);
        if (child.asTaskFragment() == null) goto L14;
        child.forAllLeafTaskFragments(callback, traverseTopToBottom);
    L17:
        i = i - 1;
        goto L9
    L14:
        if (child.asActivityRecord() == null) goto L17;
        if (consumed == true) goto L17;
        callback.accept(task);
        consumed = true;
        goto L17
    L30:
        return;
    L19:
        int i2 = 0;
    L21:
        if (i2 >= task.mChildren.size()) goto L41;
        WindowContainer child2 = (WindowContainer) task.mChildren.get(i2);
        if (child2.asTaskFragment() == null) goto L26;
        child2.forAllLeafTaskFragments(callback, traverseTopToBottom);
    L29:
        i2 = i2 + 1;
        goto L21
    L26:
        if (child2.asActivityRecord() == null) goto L29;
        if (consumed == true) goto L29;
        callback.accept(task);
        consumed = true;
        goto L29
    }

    @Override // com.android.server.wm.WindowContainer
    boolean forAllRootTasks(Predicate<Task> callback, boolean traverseTopToBottom) {
        if (isRootTask() == true) goto L7;
        return false;
    L7:
        return callback.test(this);
    }

    @Override // com.android.server.wm.WindowContainer
    Task getTask(Predicate<Task> callback, boolean traverseTopToBottom) {
        Task t = super.getTask(callback, traverseTopToBottom);
        if (t == null) goto L6;
        return t;
    L6:
        if (callback.test(this) == true) goto L10;
        return null;
    L10:
        return this;
    }

    @Override // com.android.server.wm.WindowContainer
    Task getRootTask(Predicate<Task> callback, boolean traverseTopToBottom) {
        if (isRootTask() == true) goto L5;
    L7:
        return null;
    L5:
        if (callback.test(this) == false) goto L7;
        return this;
    }

    void dontAnimateDimExit() {
        this.mDimmer.dontAnimateExit();
    }

    @Override // com.android.server.wm.ConfigurationContainer
    String getName() {
        return "Task=" + this.mTaskId;
    }

    @Override // com.android.server.wm.TaskFragment, com.android.server.wm.WindowContainer
    @Deprecated
    Dimmer getDimmer() {
        if (inMultiWindowMode() == false) goto L7;
        return this.mDimmer;
    L7:
        if (isRootTask() == false) goto L16;
        if (isTranslucentAndVisible() == true) goto L16;
        if (isTranslucentForTransition() == true) goto L16;
        return this.mDimmer;
    L16:
        return super.getDimmer();
    }

    boolean isSuitableForDimming() {
        if (inMultiWindowMode() == false) goto L5;
    L8:
        return true;
    L5:
        if (isTranslucentAndVisible() == false) goto L8;
        return false;
    }

    @Override // com.android.server.wm.TaskFragment, com.android.server.wm.WindowContainer
    void prepareSurfaces() {
        this.mDimmer.resetDimStates();
        super.prepareSurfaces();
        SurfaceControl.Transaction t = getSyncTransaction();
        if (this.mDimmer.hasDimState() == false) goto L8;
        if (this.mDimmer.updateDims(t) == false) goto L8;
        scheduleAnimation();
    L8:
        if (this.mTransitionController.isCollecting() == true) goto L10;
    L12:
        boolean visible = isVisible();
        if (visible == false) goto L15;
    L18:
        boolean show = true;
    L20:
        if (this.mSurfaceControl == null) goto L25;
        if (show == this.mLastSurfaceShowing) goto L25;
        getExt().traceStartTrace(t, "prepareSurfaces");
        t.setVisibility(this.mSurfaceControl, show);
        getExt().traceEndTrace(t);
    L25:
        if (this.mOverlayHost == null) goto L27;
        this.mOverlayHost.setVisibility(t, visible);
    L27:
        this.mLastSurfaceShowing = show;
        if (Features.FEAT_QUICK_WIN == false) goto L31;
        getExt().prepareSurfaces(visible);
        return;
    L31:
        return;
    L15:
        if (isAnimating(7) == true) goto L18;
        show = false;
        goto L20
    L10:
        if (this.mCreatedByOrganizer == false) goto L12;
    }

    void fillTaskInfo(TaskInfo info) {
        fillTaskInfo(info, true);
    }

    void fillTaskInfo(TaskInfo info, boolean stripExtras) {
        fillTaskInfo(info, stripExtras, getDisplayArea());
    }

    void fillTaskInfo(TaskInfo info, boolean stripExtras, TaskDisplayArea tda) {
        info.launchCookies.clear();
        info.addLaunchCookie(this.mLaunchCookie);
        ActivityRecord top = this.mTaskSupervisor.mTaskInfoHelper.fillAndReturnTop(this, info);
        if (isLeafTask() == false) goto L5;
        int r1 = this.mUserId;
    L6:
        info.userId = r1;
        info.taskId = this.mTaskId;
        info.effectiveUid = this.effectiveUid;
        info.displayId = getDisplayId();
        int r2 = -1;
        if (tda == null) goto L9;
        int r3 = tda.mFeatureId;
    L10:
        info.displayAreaFeatureId = r3;
        Intent baseIntent = getBaseIntent();
        if (baseIntent != null) goto L13;
        int baseIntentFlags = 0;
    L14:
        if (baseIntent != null) goto L16;
        Intent r5 = new Intent();
    L19:
        info.baseIntent = r5;
        info.baseIntent.setFlags(baseIntentFlags);
        if (top == null) goto L22;
        boolean r6 = true;
    L23:
        info.isRunning = r6;
        WindowState windowState = null;
        if (top == null) goto L26;
        ComponentName r7 = top.mActivityComponent;
    L27:
        info.topActivity = r7;
        info.origActivity = this.origActivity;
        info.realActivity = this.realActivity;
        info.lastActiveTime = this.lastActiveTime;
        info.taskDescription = new ActivityManager.TaskDescription(getTaskDescription());
        info.supportsMultiWindow = supportsMultiWindowInDisplayArea(tda);
        info.configuration.setTo(getConfiguration());
        info.configuration.windowConfiguration.setActivityType(getActivityType());
        info.configuration.windowConfiguration.setWindowingMode(getWindowingMode());
        info.token = this.mRemoteToken.toWindowContainerToken();
        if (top != null) goto L30;
    L32:
        Task topTask = this;
    L33:
        info.resizeMode = topTask.mResizeMode;
        info.topActivityType = topTask.getActivityType();
        info.displayCutoutInsets = topTask.getDisplayCutoutInsets();
        info.isResizeable = isResizeable();
        info.minWidth = this.mMinWidth;
        info.minHeight = this.mMinHeight;
        if (this.mDisplayContent != null) goto L36;
        int r8 = 220;
    L37:
        info.defaultMinSize = r8;
        info.positionInParent = getRelativePosition();
        if (top == null) goto L40;
        ActivityInfo r9 = top.info;
    L41:
        info.topActivityInfo = r9;
        info.pictureInPictureParams = getPictureInPictureParams(top);
        if (info.pictureInPictureParams != null) goto L44;
    L48:
        int r10 = -1;
    L49:
        info.launchIntoPipHostTaskId = r10;
        if (top != null) goto L52;
    L54:
        int r11 = -1;
    L55:
        info.lastParentTaskIdBeforePip = r11;
        if (top != null) goto L58;
    L60:
        boolean r12 = false;
    L61:
        info.shouldDockBigOverlays = r12;
        if (top == null) goto L64;
        LocusId r13 = top.getLocusId();
    L65:
        info.mTopActivityLocusId = r13;
        if (top == null) goto L68;
        long r14 = top.mRequestOpenInBrowserEducationTimestamp;
    L69:
        info.topActivityRequestOpenInBrowserEducationTimestamp = r14;
        if (getParent() == null) goto L72;
        Task parentTask = getParent().asTask();
    L73:
        if (parentTask != null) goto L75;
    L78:
        info.parentTaskId = r2;
        info.isFocused = isFocused();
        info.isVisible = hasVisibleChildren();
        info.isVisibleRequested = isVisibleRequested();
        if (top != null) goto L81;
    L83:
        boolean r4 = false;
    L84:
        info.isTopActivityNoDisplay = r4;
        info.isSleeping = shouldSleepActivities();
        if (top != null) goto L87;
    L89:
        boolean r15 = false;
    L90:
        info.isTopActivityTransparent = r15;
        info.isActivityStackTransparent = !topTask.forAllActivities(new Task$$ExternalSyntheticLambda35());
        info.lastNonFullscreenBounds = topTask.mLastNonFullscreenBounds;
        if (top == null) goto L95;
        windowState = top.findMainWindow(false);
    L95:
        if (windowState != null) goto L97;
    L99:
        int r16 = WindowInsets.Type.defaultVisible();
    L100:
        info.requestedVisibleTypes = r16;
        AppCompatUtils.fillAppCompatTaskInfo(this, info, top);
        info.topActivityMainWindowFrame = calculateTopActivityMainWindowFrameForTaskInfo(top);
        if (Features.FEAT_QUICK_WIN == false) goto L104;
        info.scale = getExt().getScale();
        info.offset = getExt().getOffset();
        return;
    L104:
        return;
    L97:
        if (DesktopModeFlags.ENABLE_FULLY_IMMERSIVE_IN_DESKTOP.isTrue() == false) goto L99;
        r16 = windowState.getRequestedVisibleTypes();
        goto L100
    L87:
        if (top.fillsParent() == true) goto L89;
        r15 = true;
        goto L90
    L81:
        if (top.isNoDisplay() == false) goto L83;
        r4 = true;
        goto L84
    L75:
        if (parentTask.mCreatedByOrganizer == false) goto L78;
        r2 = parentTask.mTaskId;
        goto L78
    L72:
        parentTask = null;
        goto L73
    L68:
        r14 = 0;
        goto L69
    L64:
        r13 = null;
        goto L65
    L58:
        if (top.shouldDockBigOverlays == false) goto L60;
        r12 = true;
        goto L61
    L52:
        if (top.getLastParentBeforePip() == null) goto L54;
        r11 = top.getLastParentBeforePip().mTaskId;
        goto L55
    L44:
        if (info.pictureInPictureParams.isLaunchIntoPip() == false) goto L48;
        if (top.getLastParentBeforePip() == null) goto L48;
        r10 = top.getLastParentBeforePip().mTaskId;
        goto L49
    L40:
        r9 = null;
        goto L41
    L36:
        r8 = this.mDisplayContent.mMinSizeOfResizeableTaskDp;
        goto L37
    L30:
        if (top.getTask() == null) goto L32;
        topTask = top.getTask();
        goto L33
    L26:
        r7 = null;
        goto L27
    L22:
        r6 = false;
        goto L23
    L16:
        if (stripExtras == false) goto L18;
        r5 = baseIntent.cloneFilter();
        goto L19
    L18:
        r5 = new Intent(baseIntent);
        goto L19
    L13:
        baseIntentFlags = baseIntent.getFlags();
        goto L14
    L9:
        r3 = -1;
        goto L10
    L5:
        r1 = this.mCurrentUser;
        goto L6
    }

    private static /* synthetic */ boolean lambda$fillTaskInfo$16(ActivityRecord r) {
        return r.occludesParent();
    }

    private static Rect calculateTopActivityMainWindowFrameForTaskInfo(ActivityRecord top) {
        if (top != null) goto L5;
        return null;
    L5:
        WindowState mainWindow = top.findMainWindow();
        if (mainWindow != null) goto L9;
        return null;
    L9:
        if (mainWindow.mHaveFrame == true) goto L11;
        return null;
    L11:
        Rect windowFrame = mainWindow.getFrame();
        Rect parentFrame = mainWindow.getParentFrame();
        if (parentFrame.equals(windowFrame) == false) goto L14;
        return null;
    L14:
        return windowFrame;
    }

    private static /* synthetic */ boolean lambda$trimIneffectiveInfo$17(ActivityRecord r) {
        return !r.finishing;
    }

    static void trimIneffectiveInfo(Task task, TaskInfo info) {
        ActivityRecord baseActivity = task.getActivity(new Task$$ExternalSyntheticLambda16(), false);
        if (baseActivity == null) goto L5;
        int baseActivityUid = baseActivity.getUid();
    L7:
        if (info.topActivityInfo == null) goto L12;
        if (task.effectiveUid == info.topActivityInfo.applicationInfo.uid) goto L12;
        info.topActivityInfo = new ActivityInfo(info.topActivityInfo);
        ActivityInfo r2 = info.topActivityInfo;
        r2.applicationInfo = new ApplicationInfo(info.topActivityInfo.applicationInfo);
        info.topActivity = new ComponentName("", "");
        info.topActivityInfo.packageName = "";
        info.topActivityInfo.taskAffinity = "";
        info.topActivityInfo.processName = "";
        info.topActivityInfo.name = "";
        info.topActivityInfo.parentActivityName = "";
        info.topActivityInfo.targetActivity = "";
        info.topActivityInfo.splitName = "";
        info.topActivityInfo.applicationInfo.className = "";
        info.topActivityInfo.applicationInfo.credentialProtectedDataDir = "";
        info.topActivityInfo.applicationInfo.dataDir = "";
        info.topActivityInfo.applicationInfo.deviceProtectedDataDir = "";
        info.topActivityInfo.applicationInfo.manageSpaceActivityName = "";
        info.topActivityInfo.applicationInfo.nativeLibraryDir = "";
        info.topActivityInfo.applicationInfo.nativeLibraryRootDir = "";
        info.topActivityInfo.applicationInfo.processName = "";
        info.topActivityInfo.applicationInfo.publicSourceDir = "";
        info.topActivityInfo.applicationInfo.scanPublicSourceDir = "";
        info.topActivityInfo.applicationInfo.scanSourceDir = "";
        info.topActivityInfo.applicationInfo.sourceDir = "";
        info.topActivityInfo.applicationInfo.taskAffinity = "";
        info.topActivityInfo.applicationInfo.name = "";
        info.topActivityInfo.applicationInfo.packageName = "";
    L12:
        if (task.effectiveUid == baseActivityUid) goto L14;
        info.baseActivity = new ComponentName("", "");
    L14:
        info.capturedLink = null;
        info.capturedLinkTimestamp = 0;
        info.topActivityRequestOpenInBrowserEducationTimestamp = 0;
        return;
    L5:
        baseActivityUid = task.effectiveUid;
        goto L7
    }

    PictureInPictureParams getPictureInPictureParams() {
        Task topTask = getTopMostTask();
        if (topTask != null) goto L7;
        return null;
    L7:
        return getPictureInPictureParams(topTask.getTopMostActivity());
    }

    private static PictureInPictureParams getPictureInPictureParams(ActivityRecord top) {
        if (top != null) goto L4;
    L7:
        return null;
    L4:
        if (top.pictureInPictureArgs.empty() == true) goto L7;
        return new PictureInPictureParams(top.pictureInPictureArgs);
    }

    Rect getDisplayCutoutInsets() {
        Rect displayCutoutInsets = new Rect();
        if (this.mDisplayContent != null) goto L5;
    L17:
        return displayCutoutInsets;
    L5:
        if (getDisplayInfo().displayCutout == null) goto L17;
        WindowState w = getTopVisibleAppMainWindow();
        if (w != null) goto L10;
    L12:
        Rect displayFrame = this.mDisplayContent.getBounds();
        displayFrame.inset(getDisplayInfo().displayCutout.getSafeInsets());
    L13:
        Rect taskBounds = getBounds();
        if (displayCutoutInsets.setIntersect(taskBounds, displayFrame) == false) goto L16;
        displayCutoutInsets.set(displayCutoutInsets.left - taskBounds.left, displayCutoutInsets.top - taskBounds.top, taskBounds.right - displayCutoutInsets.right, taskBounds.bottom - displayCutoutInsets.bottom);
    L16:
        return displayCutoutInsets;
    L10:
        if (w.mHaveFrame == false) goto L12;
        displayFrame = w.getDisplayFrame();
        goto L13
    }

    ActivityManager.RunningTaskInfo getTaskInfo() {
        ActivityManager.RunningTaskInfo info = new ActivityManager.RunningTaskInfo();
        fillTaskInfo(info);
        return info;
    }

    StartingWindowInfo getStartingWindowInfo(ActivityRecord activity) {
        StartingWindowInfo info = new StartingWindowInfo();
        info.taskInfo = getTaskInfo();
        if (info.taskInfo.topActivityInfo != null) goto L5;
    L7:
        ActivityInfo r1 = null;
    L8:
        info.targetActivityInfo = r1;
        info.isKeyguardOccluded = this.mAtmService.mKeyguardController.isKeyguardOccluded(info.taskInfo.displayId);
        if (activity.mStartingData == null) goto L11;
        int r2 = activity.mStartingData.mTypeParams;
    L12:
        info.startingWindowTypeParameter = r2;
        if ((info.startingWindowTypeParameter & 16) == 0) goto L17;
        WindowState topMainWin = getTopFullscreenMainWindow();
        if (topMainWin == null) goto L17;
        info.mainWindowLayoutParams = topMainWin.mAttrs;
        info.requestedVisibleTypes = topMainWin.getRequestedVisibleTypes();
    L17:
        Rect rotatedBounds = activity.getFixedRotationTransformDisplayBounds();
        Rect r3 = info.taskBounds;
        if (rotatedBounds == null) goto L20;
        Rect r4 = rotatedBounds;
    L21:
        r3.set(r4);
        info.taskInfo.configuration.setTo(activity.getConfiguration());
        return info;
    L20:
        r4 = info.taskInfo.configuration.windowConfiguration.getBounds();
        goto L21
    L11:
        r2 = 272;
        goto L12
    L5:
        if (activity.info == info.taskInfo.topActivityInfo) goto L7;
        r1 = activity.info;
        goto L8
    }

    TaskFragmentParentInfo getTaskFragmentParentInfo() {
        return new TaskFragmentParentInfo(getConfiguration(), getDisplayId(), this.mTaskId, shouldBeVisible(null), hasNonFinishingDirectActivity(), getDecorSurface());
    }

    @Override // com.android.server.wm.TaskFragment, com.android.server.wm.WindowContainer
    protected boolean onChildVisibleRequestedChanged(WindowContainer child) {
        if (super.onChildVisibleRequestedChanged(child) == true) goto L6;
        return false;
    L6:
        sendTaskFragmentParentInfoChangedIfNeeded();
        return true;
    }

    void sendTaskFragmentParentInfoChangedIfNeeded() {
        if (isLeafTask() == true) goto L5;
        return;
    L5:
        TaskFragment childOrganizedTf = getTaskFragment(new Task$$ExternalSyntheticLambda3());
        if (childOrganizedTf == null) goto L9;
        childOrganizedTf.sendTaskFragmentParentInfoChanged();
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    void assignChildLayers(final SurfaceControl.Transaction t) {
        int layer = 0;
        boolean decorSurfacePlaced = false;
        int j = 0;
    L4:
        if (j >= this.mChildren.size()) goto L31;
        WindowContainer wc = (WindowContainer) this.mChildren.get(j);
        wc.assignChildLayers(t);
        if (this.mDecorSurfaceContainer != null) goto L8;
    L13:
        int layer2 = layer + 1;
        wc.assignLayer(t, layer);
        TaskFragment taskFragment = wc.asTaskFragment();
        if (taskFragment == null) goto L21;
        if (taskFragment.isEmbedded() == false) goto L21;
        if (taskFragment.hasAdjacentTaskFragment() == false) goto L21;
        final int[] nextLayer = {layer2};
        taskFragment.forOtherAdjacentTaskFragments(new Task$$ExternalSyntheticLambda28(t, nextLayer));
        layer2 = nextLayer[0];
    L21:
        if (this.mDecorSurfaceContainer != null) goto L23;
    L28:
        layer = layer2;
    L29:
        j = j + 1;
        goto L4
    L23:
        if (DecorSurfaceContainer.m10213$$Nest$fgetmIsBoosted(this.mDecorSurfaceContainer) == true) goto L28;
        if (decorSurfacePlaced == true) goto L28;
        if (wc != this.mDecorSurfaceContainer.mOwnerTaskFragment) goto L28;
        DecorSurfaceContainer.m10214$$Nest$massignLayer(this.mDecorSurfaceContainer, t, layer2);
        decorSurfacePlaced = true;
        layer = layer2 + 1;
        goto L29
    L8:
        if (DecorSurfaceContainer.m10213$$Nest$fgetmIsBoosted(this.mDecorSurfaceContainer) == true) goto L13;
        if (decorSurfacePlaced == true) goto L13;
        if (shouldPlaceDecorSurfaceBelowContainer(wc) == false) goto L13;
        DecorSurfaceContainer.m10214$$Nest$massignLayer(this.mDecorSurfaceContainer, t, layer);
        decorSurfacePlaced = true;
        layer = layer + 1;
        goto L13
    L31:
        if (this.mDecorSurfaceContainer == null) goto L36;
        if (DecorSurfaceContainer.m10213$$Nest$fgetmIsBoosted(this.mDecorSurfaceContainer) == false) goto L36;
        DecorSurfaceContainer.m10214$$Nest$massignLayer(this.mDecorSurfaceContainer, t, layer);
        layer = layer + 1;
    L36:
        if (this.mOverlayHost == null) goto L42;
        int r3 = layer + 1;
        this.mOverlayHost.setLayer(t, layer);
        return;
    }

    private static /* synthetic */ void lambda$assignChildLayers$18(SurfaceControl.Transaction t, int[] nextLayer, TaskFragment adjacentTf) {
        if (adjacentTf.shouldBoostDimmer() == false) goto L6;
        int r1 = nextLayer[0];
        nextLayer[0] = r1 + 1;
        adjacentTf.assignLayer(t, r1);
        return;
    }

    boolean shouldPlaceDecorSurfaceBelowContainer(WindowContainer wc) {
        if (wc.asActivityRecord() != null) goto L5;
    L7:
        boolean isOwnActivity = false;
    L9:
        if (wc.asTaskFragment() != null) goto L11;
    L15:
        boolean isTrustedTaskFragment = false;
    L17:
        if (isOwnActivity == true) goto L21;
        if (isTrustedTaskFragment == false) goto L20;
        return false;
    L20:
        return true;
    L21:
        return false;
    L11:
        if (wc.asTaskFragment().isEmbedded() == false) goto L15;
        if (wc.asTaskFragment().isAllowedToBeEmbeddedInTrustedMode() == false) goto L15;
        isTrustedTaskFragment = true;
        goto L17
    L5:
        if (wc.asActivityRecord().isUid(this.effectiveUid) == false) goto L7;
        isOwnActivity = true;
        goto L9
    }

    void requestDecorSurfaceBoosted(TaskFragment ownerTaskFragment, boolean isBoosted, SurfaceControl.Transaction clientTransaction) {
        if (this.mDecorSurfaceContainer != null) goto L5;
        return;
    L5:
        if (this.mDecorSurfaceContainer.mOwnerTaskFragment != ownerTaskFragment) goto L10;
        DecorSurfaceContainer.m10217$$Nest$mrequestBoosted(this.mDecorSurfaceContainer, isBoosted, clientTransaction);
        return;
    }

    void commitDecorSurfaceBoostedState() {
        if (this.mDecorSurfaceContainer != null) goto L5;
        return;
    L5:
        DecorSurfaceContainer.m10215$$Nest$mcommitBoostedState(this.mDecorSurfaceContainer);
        assignChildLayers();
    }

    boolean isDecorSurfaceBoosted() {
        if (this.mDecorSurfaceContainer != null) goto L5;
    L7:
        return false;
    L5:
        if (DecorSurfaceContainer.m10213$$Nest$fgetmIsBoosted(this.mDecorSurfaceContainer) == false) goto L7;
        return true;
    }

    boolean isTaskId(int taskId) {
        if (this.mTaskId != taskId) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    Task asTask() {
        return this;
    }

    ActivityRecord isInTask(ActivityRecord r) {
        if (r != null) goto L6;
        return null;
    L6:
        if (r.isDescendantOf(this) == false) goto L8;
        return r;
    L8:
        return null;
    }

    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("userId=");
        pw.print(this.mUserId);
        pw.print(" effectiveUid=");
        UserHandle.formatUid(pw, this.effectiveUid);
        pw.print(" mCallingUid=");
        UserHandle.formatUid(pw, this.mCallingUid);
        pw.print(" mUserSetupComplete=");
        pw.print(this.mUserSetupComplete);
        pw.print(" mCallingPackage=");
        pw.print(this.mCallingPackage);
        pw.print(" mCallingFeatureId=");
        pw.println(this.mCallingFeatureId);
        if (this.affinity == null) goto L5;
    L6:
        pw.print(prefix);
        pw.print("affinity=");
        pw.print(this.affinity);
        if (this.affinity != null) goto L9;
    L12:
        pw.print(" root=");
        pw.println(this.rootAffinity);
    L14:
        if (this.mWindowLayoutAffinity == null) goto L17;
        pw.print(prefix);
        pw.print("windowLayoutAffinity=");
        pw.println(this.mWindowLayoutAffinity);
    L17:
        if (this.voiceSession == null) goto L19;
    L20:
        pw.print(prefix);
        pw.print("VOICE: session=0x");
        pw.print(Integer.toHexString(System.identityHashCode(this.voiceSession)));
        pw.print(" interactor=0x");
        pw.println(Integer.toHexString(System.identityHashCode(this.voiceInteractor)));
    L22:
        if (this.intent == null) goto L25;
        StringBuilder sb = new StringBuilder(128);
        sb.append(prefix);
        sb.append("intent={");
        this.intent.toShortString(sb, false, true, false, false);
        sb.append('}');
        pw.println(sb.toString());
    L25:
        if (this.affinityIntent == null) goto L28;
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(prefix);
        sb2.append("affinityIntent={");
        this.affinityIntent.toShortString(sb2, false, true, false, false);
        sb2.append('}');
        pw.println(sb2.toString());
    L28:
        if (this.origActivity == null) goto L31;
        pw.print(prefix);
        pw.print("origActivity=");
        pw.println(this.origActivity.flattenToShortString());
    L31:
        if (this.realActivity == null) goto L34;
        pw.print(prefix);
        pw.print("mActivityComponent=");
        pw.println(this.realActivity.flattenToShortString());
    L34:
        if (this.autoRemoveRecents == false) goto L36;
    L39:
        pw.print(prefix);
        pw.print("autoRemoveRecents=");
        pw.print(this.autoRemoveRecents);
        pw.print(" isPersistable=");
        pw.print(this.isPersistable);
        pw.print(" activityType=");
        pw.println(getActivityType());
    L40:
        boolean r1 = true;
        if (this.rootWasReset == false) goto L43;
    L48:
        pw.print(prefix);
        pw.print("rootWasReset=");
        pw.print(this.rootWasReset);
        pw.print(" mNeverRelinquishIdentity=");
        pw.print(this.mNeverRelinquishIdentity);
        pw.print(" mReuseTask=");
        pw.print(this.mReuseTask);
        pw.print(" mLockTaskAuth=");
        pw.println(lockTaskAuthToString());
    L50:
        if (this.mAffiliatedTaskId == this.mTaskId) goto L52;
    L59:
        pw.print(prefix);
        pw.print("affiliation=");
        pw.print(this.mAffiliatedTaskId);
        pw.print(" prevAffiliation=");
        pw.print(this.mPrevAffiliateTaskId);
        pw.print(" (");
        if (this.mPrevAffiliate != null) goto L62;
        pw.print("null");
    L63:
        pw.print(") nextAffiliation=");
        pw.print(this.mNextAffiliateTaskId);
        pw.print(" (");
        if (this.mNextAffiliate != null) goto L66;
        pw.print("null");
    L67:
        pw.println(")");
    L68:
        pw.print(prefix);
        pw.print("Activities=");
        pw.println(this.mChildren);
        if (this.inRecents == true) goto L71;
    L72:
        pw.print(prefix);
        pw.print(" inRecents=");
        pw.print(this.inRecents);
        pw.print(" isAvailable=");
        pw.println(this.isAvailable);
    L74:
        if (this.lastDescription == null) goto L77;
        pw.print(prefix);
        pw.print("lastDescription=");
        pw.println(this.lastDescription);
    L77:
        if (this.mRootProcess == null) goto L80;
        pw.print(prefix);
        pw.print("mRootProcess=");
        pw.println(this.mRootProcess);
    L80:
        if (this.mSharedStartingData == null) goto L83;
        pw.println(prefix + "mSharedStartingData=" + this.mSharedStartingData);
    L83:
        if (this.mKillProcessesOnDestroyed == false) goto L85;
        pw.println(prefix + "mKillProcessesOnDestroyed=true");
    L85:
        pw.print(prefix);
        pw.print("taskId=" + this.mTaskId);
        pw.println(" rootTaskId=" + getRootTaskId());
        pw.print(prefix);
        StringBuilder r0 = new StringBuilder();
        r0.append("hasChildPipActivity=");
        if (this.mChildPipActivity != null) goto L89;
        r1 = false;
    L89:
        r0.append(r1);
        pw.println(r0.toString());
        pw.print(prefix);
        pw.print("mHasBeenVisible=");
        pw.println(getHasBeenVisible());
        pw.print(prefix);
        pw.print("mResizeMode=");
        pw.print(ActivityInfo.resizeModeToString(this.mResizeMode));
        pw.print(" mSupportsPictureInPicture=");
        pw.print(this.mSupportsPictureInPicture);
        pw.print(" isResizeable=");
        pw.println(isResizeable());
        pw.print(prefix);
        pw.print("isPerceptible=");
        pw.println(this.mIsPerceptible);
        pw.print(prefix);
        pw.print("lastActiveTime=");
        pw.print(this.lastActiveTime);
        pw.println(" (inactive for " + (getInactiveDuration() / 1000) + "s)");
        pw.print(prefix);
        pw.print("isTrimmable=" + this.mIsTrimmableFromRecents);
        pw.print(" isForceHidden=");
        pw.print(isForceHidden());
        pw.print(" isForceExcludedFromRecents=");
        pw.println(isForceExcludedFromRecents());
        if (this.mLaunchAdjacentDisabled == false) goto L93;
        pw.println(prefix + "mLaunchAdjacentDisabled=true");
    L93:
        if (this.mReparentLeafTaskIfRelaunch == false) goto L96;
        pw.println(prefix + "mReparentLeafTaskIfRelaunch=true");
        return;
    L96:
        return;
    L71:
        if (this.isAvailable == true) goto L74;
    L66:
        pw.print(Integer.toHexString(System.identityHashCode(this.mNextAffiliate)));
        goto L67
    L62:
        pw.print(Integer.toHexString(System.identityHashCode(this.mPrevAffiliate)));
        goto L63
    L52:
        if (this.mPrevAffiliateTaskId != (-1)) goto L59;
        if (this.mPrevAffiliate != null) goto L59;
        if (this.mNextAffiliateTaskId != (-1)) goto L59;
        if (this.mNextAffiliate == null) goto L68;
    L43:
        if (this.mNeverRelinquishIdentity == true) goto L48;
        if (this.mReuseTask == true) goto L48;
        if (this.mLockTaskAuth == 1) goto L50;
    L36:
        if (this.isPersistable == true) goto L39;
        if (isActivityTypeStandard() == true) goto L40;
    L19:
        if (this.voiceInteractor == null) goto L22;
    L9:
        if (this.affinity.equals(this.rootAffinity) == false) goto L12;
        pw.println();
        goto L14
    L5:
        if (this.rootAffinity == null) goto L14;
        goto L6
    }

    @Override // com.android.server.wm.TaskFragment
    String toFullString() {
        StringBuilder sb = new StringBuilder(192);
        sb.append(this);
        sb.setLength(sb.length() - 1);
        sb.append(" U=");
        sb.append(this.mUserId);
        Task rootTask = getRootTask();
        if (rootTask == this) goto L5;
        sb.append(" rootTaskId=");
        sb.append(rootTask.mTaskId);
    L5:
        sb.append(" visible=");
        sb.append(shouldBeVisible(null));
        sb.append(" visibleRequested=");
        sb.append(isVisibleRequested());
        sb.append(" mode=");
        sb.append(WindowConfiguration.windowingModeToString(getWindowingMode()));
        sb.append(" translucent=");
        sb.append(isTranslucent(null));
        sb.append(" sz=");
        sb.append(getChildCount());
        sb.append('}');
        return sb.toString();
    }

    @Override // com.android.server.wm.TaskFragment
    public String toString() {
        if (this.stringName != null) goto L5;
        StringBuilder sb = new StringBuilder(128);
        sb.append("Task{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" #");
        sb.append(this.mTaskId);
        sb.append(" type=" + WindowConfiguration.activityTypeToString(getActivityType()));
        if (this.affinity == null) goto L10;
        sb.append(" A=");
        sb.append(this.affinity);
    L20:
        if (isResizeable() == true) goto L23;
        sb.append(" nonResizable");
    L23:
        if (this.mMinWidth == (-1)) goto L25;
    L26:
        sb.append(" minWidth=");
        sb.append(this.mMinWidth);
        sb.append(" minHeight=");
        sb.append(this.mMinHeight);
    L27:
        sb.append('}');
        String r1 = sb.toString();
        this.stringName = r1;
        return r1;
    L25:
        if (this.mMinHeight == (-1)) goto L27;
    L10:
        if (this.intent == null) goto L15;
        if (this.intent.getComponent() == null) goto L15;
        sb.append(" I=");
        sb.append(this.intent.getComponent().flattenToShortString());
    L15:
        if (this.affinityIntent == null) goto L20;
        if (this.affinityIntent.getComponent() == null) goto L20;
        sb.append(" aI=");
        sb.append(this.affinityIntent.getComponent().flattenToShortString());
        goto L20
    L5:
        return this.stringName;
    }

    void saveToXml(TypedXmlSerializer out) throws Exception {
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L5;
        Slog.i("ActivityTaskManager", "Saving task=" + this);
    L5:
        out.attributeInt(null, ATTR_TASKID, this.mTaskId);
        if (this.realActivity == null) goto L8;
        out.attribute(null, ATTR_REALACTIVITY, this.realActivity.flattenToShortString());
    L8:
        out.attributeBoolean(null, ATTR_REALACTIVITY_SUSPENDED, this.realActivitySuspended);
        if (this.origActivity == null) goto L11;
        out.attribute(null, ATTR_ORIGACTIVITY, this.origActivity.flattenToShortString());
    L11:
        String r1 = "@";
        if (this.affinity == null) goto L20;
        out.attribute(null, ATTR_AFFINITY, this.affinity);
        if (this.affinity.equals(this.rootAffinity) == true) goto L26;
        if (this.rootAffinity == null) goto L18;
        r1 = this.rootAffinity;
    L18:
        out.attribute(null, ATTR_ROOT_AFFINITY, r1);
    L26:
        if (this.mWindowLayoutAffinity == null) goto L28;
        out.attribute(null, ATTR_WINDOW_LAYOUT_AFFINITY, this.mWindowLayoutAffinity);
    L28:
        out.attributeBoolean(null, ATTR_ROOTHASRESET, this.rootWasReset);
        out.attributeBoolean(null, ATTR_AUTOREMOVERECENTS, this.autoRemoveRecents);
        out.attributeInt(null, ATTR_USERID, this.mUserId);
        out.attributeBoolean(null, ATTR_USER_SETUP_COMPLETE, this.mUserSetupComplete);
        out.attributeInt(null, ATTR_EFFECTIVE_UID, this.effectiveUid);
        out.attributeLong(null, ATTR_LASTTIMEMOVED, this.mLastTimeMoved);
        out.attributeBoolean(null, ATTR_NEVERRELINQUISH, this.mNeverRelinquishIdentity);
        if (this.lastDescription == null) goto L32;
        out.attribute(null, ATTR_LASTDESCRIPTION, this.lastDescription.toString());
    L32:
        if (getTaskDescription() == null) goto L34;
        getTaskDescription().saveToXml(out);
    L34:
        out.attributeInt(null, ATTR_TASK_AFFILIATION, this.mAffiliatedTaskId);
        out.attributeInt(null, ATTR_PREV_AFFILIATION, this.mPrevAffiliateTaskId);
        out.attributeInt(null, ATTR_NEXT_AFFILIATION, this.mNextAffiliateTaskId);
        out.attributeInt(null, ATTR_CALLING_UID, this.mCallingUid);
        String r2 = "";
        if (this.mCallingPackage != null) goto L37;
        String r0 = "";
    L38:
        out.attribute(null, ATTR_CALLING_PACKAGE, r0);
        if (this.mCallingFeatureId == null) goto L42;
        r2 = this.mCallingFeatureId;
    L42:
        out.attribute(null, ATTR_CALLING_FEATURE_ID, r2);
        out.attributeInt(null, ATTR_RESIZE_MODE, this.mResizeMode);
        out.attributeBoolean(null, ATTR_SUPPORTS_PICTURE_IN_PICTURE, this.mSupportsPictureInPicture);
        if (this.mLastNonFullscreenBounds == null) goto L45;
        out.attribute(null, ATTR_NON_FULLSCREEN_BOUNDS, this.mLastNonFullscreenBounds.flattenToString());
    L45:
        out.attributeInt(null, ATTR_MIN_WIDTH, this.mMinWidth);
        out.attributeInt(null, ATTR_MIN_HEIGHT, this.mMinHeight);
        out.attributeInt(null, ATTR_PERSIST_TASK_VERSION, 1);
        if (this.affinityIntent == null) goto L49;
        out.startTag(null, TAG_AFFINITYINTENT);
        this.affinityIntent.saveToXml(out);
        out.endTag(null, TAG_AFFINITYINTENT);
    L49:
        if (this.intent == null) goto L51;
        out.startTag(null, TAG_INTENT);
        this.intent.saveToXml(out);
        out.endTag(null, TAG_INTENT);
    L51:
        sTmpException = null;
        PooledPredicate f = PooledLambda.obtainPredicate(new Task$$ExternalSyntheticLambda33(), PooledLambda.__(ActivityRecord.class), getBottomMostActivity(), out);
        forAllActivities(f);
        f.recycle();
        if (sTmpException != null) goto L55;
        return;
    L55:
        throw sTmpException;
    L37:
        r0 = this.mCallingPackage;
        goto L38
    L20:
        if (this.rootAffinity == null) goto L26;
        if (this.rootAffinity == null) goto L24;
        r1 = this.rootAffinity;
    L24:
        out.attribute(null, ATTR_ROOT_AFFINITY, r1);
        goto L26
    }

    private static boolean saveActivityToXml(ActivityRecord r, ActivityRecord first, TypedXmlSerializer out) {
        if (r.info.persistableMode != 0) goto L5;
    L17:
        return true;
    L5:
        if (r.isPersistable() == false) goto L17;
        if (((r.intent.getFlags() & 524288) | 8192) != 524288) goto L18;
        if (r != first) goto L17;
    L18:
        out.startTag(null, "activity");     // Catch: Exception -> L14
        r.saveToXml(out);     // Catch: Exception -> L14
        out.endTag(null, "activity");     // Catch: Exception -> L14
        return false;
    L14:
        e = move-exception;
        sTmpException = e;
        return true;
    }

    static Task restoreFromXml(TypedXmlPullParser in, ActivityTaskSupervisor taskSupervisor) throws IOException, XmlPullParserException {
        ArrayList<ActivityRecord> activities = new ArrayList();
        int effectiveUid = -1;
        int outerDepth = in.getDepth();
        ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription();
        boolean supportsPictureInPicture = false;
        int userId = 0;
        boolean userSetupComplete = true;
        String lastDescription = null;
        long lastTimeOnTop = 0;
        boolean neverRelinquishIdentity = true;
        int taskId = -1;
        int taskId2 = -1;
        int nextTaskId = -1;
        int callingUid = -1;
        String callingPackage = "";
        String callingFeatureId = null;
        Rect lastNonFullscreenBounds = null;
        int minWidth = -1;
        int minHeight = -1;
        boolean realActivitySuspended = false;
        boolean hasRootAffinity = false;
        String windowLayoutAffinity = null;
        int userId2 = 0;
        int taskAffiliation = -1;
        ComponentName realActivity = null;
        String rootAffinity = null;
        boolean autoRemoveRecents = false;
        int attrNdx = in.getAttributeCount() - 1;
        String rootAffinity2 = null;
        boolean rootHasReset = false;
        int persistTaskVersion = 0;
        ComponentName origActivity = null;
        int resizeMode = 4;
    L3:
        int prevTaskId = taskAffiliation;
        if (attrNdx < 0) goto L130;
        boolean autoRemoveRecents2 = autoRemoveRecents;
        String attrName = in.getAttributeName(attrNdx);
        String attrValue = in.getAttributeValue(attrNdx);
        int attrNdx2 = attrNdx;
        switch(attrName.hashCode()) {
            case -1556983798: goto L90;
            case -1537240555: goto L87;
            case -1494902876: goto L84;
            case -1138503444: goto L81;
            case -1124927690: goto L78;
            case -974080081: goto L75;
            case -929566280: goto L72;
            case -865458610: goto L69;
            case -826243148: goto L66;
            case -707249465: goto L63;
            case -705269939: goto L60;
            case -502399667: goto L57;
            case -360792224: goto L54;
            case -162744347: goto L51;
            case -147132913: goto L48;
            case -132216235: goto L45;
            case 180927924: goto L42;
            case 331206372: goto L39;
            case 394454367: goto L36;
            case 541503897: goto L33;
            case 605497640: goto L30;
            case 869221331: goto L27;
            case 1007873193: goto L24;
            case 1081438155: goto L21;
            case 1457608782: goto L18;
            case 1539554448: goto L15;
            case 1999609934: goto L12;
            case 2023391309: goto L9;
            default: goto L92;
        };
    L92:
        byte r0 = -1;
    L93:
        switch(r0) {
            case 0: goto L125;
            case 1: goto L124;
            case 2: goto L123;
            case 3: goto L122;
            case 4: goto L121;
            case 5: goto L120;
            case 6: goto L119;
            case 7: goto L118;
            case 8: goto L117;
            case 9: goto L116;
            case 10: goto L115;
            case 11: goto L114;
            case 12: goto L113;
            case 13: goto L112;
            case 14: goto L111;
            case 15: goto L110;
            case 16: goto L109;
            case 17: goto L108;
            case 18: goto L107;
            case 19: goto L106;
            case 20: goto L105;
            case 21: goto L104;
            case 22: goto L103;
            case 23: goto L102;
            case 24: goto L101;
            case 25: goto L100;
            case 26: goto L99;
            case 27: goto L98;
            default: goto L95;
        };
    L98:
        int persistTaskVersion2 = Integer.parseInt(attrValue);
        persistTaskVersion = persistTaskVersion2;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
    L129:
        attrNdx = attrNdx2 - 1;
        goto L3
    L99:
        int minHeight2 = Integer.parseInt(attrValue);
        minHeight = minHeight2;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L100:
        int minWidth2 = Integer.parseInt(attrValue);
        minWidth = minWidth2;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L101:
        Rect lastNonFullscreenBounds2 = Rect.unflattenFromString(attrValue);
        lastNonFullscreenBounds = lastNonFullscreenBounds2;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L102:
        boolean supportsPictureInPicture2 = Boolean.parseBoolean(attrValue);
        supportsPictureInPicture = supportsPictureInPicture2;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L103:
        int resizeMode2 = Integer.parseInt(attrValue);
        resizeMode = resizeMode2;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L104:
        callingFeatureId = attrValue;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L105:
        callingPackage = attrValue;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L106:
        int callingUid2 = Integer.parseInt(attrValue);
        callingUid = callingUid2;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L107:
        int nextTaskId2 = Integer.parseInt(attrValue);
        nextTaskId = nextTaskId2;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L108:
        taskId2 = Integer.parseInt(attrValue);
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L109:
        int taskAffiliation2 = Integer.parseInt(attrValue);
        taskAffiliation = taskAffiliation2;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L110:
        boolean neverRelinquishIdentity2 = Boolean.parseBoolean(attrValue);
        neverRelinquishIdentity = neverRelinquishIdentity2;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L111:
        long lastTimeOnTop2 = Long.parseLong(attrValue);
        taskAffiliation = prevTaskId;
        lastTimeOnTop = lastTimeOnTop2;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L112:
        lastDescription = attrValue;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L113:
        int taskType = Integer.parseInt(attrValue);
        userId2 = taskType;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L114:
        int effectiveUid2 = Integer.parseInt(attrValue);
        effectiveUid = effectiveUid2;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L115:
        boolean userSetupComplete2 = Boolean.parseBoolean(attrValue);
        userSetupComplete = userSetupComplete2;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L116:
        int userId3 = Integer.parseInt(attrValue);
        userId = userId3;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L117:
        boolean autoRemoveRecents3 = Boolean.parseBoolean(attrValue);
        autoRemoveRecents = autoRemoveRecents3;
        taskAffiliation = prevTaskId;
        goto L129
    L118:
        boolean rootHasReset2 = Boolean.parseBoolean(attrValue);
        rootHasReset = rootHasReset2;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L119:
        windowLayoutAffinity = attrValue;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L120:
        hasRootAffinity = true;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        rootAffinity = attrValue;
        goto L129
    L121:
        rootAffinity2 = attrValue;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L122:
        ComponentName origActivity2 = ComponentName.unflattenFromString(attrValue);
        origActivity = origActivity2;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L123:
        boolean realActivitySuspended2 = Boolean.valueOf(attrValue).booleanValue();
        realActivitySuspended = realActivitySuspended2;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L124:
        ComponentName realActivity2 = ComponentName.unflattenFromString(attrValue);
        realActivity = realActivity2;
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        goto L129
    L125:
        boolean rootHasReset3 = rootHasReset;
        if (taskId != (-1)) goto L128;
        taskId = Integer.parseInt(attrValue);
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        rootHasReset = rootHasReset3;
    L128:
        taskAffiliation = prevTaskId;
        autoRemoveRecents = autoRemoveRecents2;
        rootHasReset = rootHasReset3;
        goto L129
    L95:
        if (attrName.startsWith("task_description_") == true) goto L97;
        StringBuilder r1 = new StringBuilder();
        rootHasReset3 = rootHasReset;
        r1.append("Task: Unknown attribute=");
        r1.append(attrName);
        Slog.w("ActivityTaskManager", r1.toString());
        goto L128
    L97:
        rootHasReset3 = rootHasReset;
        goto L128
    L9:
        if (attrName.equals(ATTR_ROOTHASRESET) == false) goto L92;
        r0 = 7;
        goto L93
    L12:
        if (attrName.equals(ATTR_WINDOW_LAYOUT_AFFINITY) == false) goto L92;
        r0 = 6;
        goto L93
    L15:
        if (attrName.equals(ATTR_REALACTIVITY) == false) goto L92;
        r0 = 1;
        goto L93
    L18:
        if (attrName.equals(ATTR_NEVERRELINQUISH) == false) goto L92;
        r0 = 15;
        goto L93
    L21:
        if (attrName.equals(ATTR_CALLING_PACKAGE) == false) goto L92;
        r0 = ParameterName.BLACK_STRETCH;
        goto L93
    L24:
        if (attrName.equals(ATTR_PERSIST_TASK_VERSION) == false) goto L92;
        r0 = ParameterName.LEVEL_RANGE;
        goto L93
    L27:
        if (attrName.equals(ATTR_LASTDESCRIPTION) == false) goto L92;
        r0 = 13;
        goto L93
    L30:
        if (attrName.equals(ATTR_AFFINITY) == false) goto L92;
        r0 = 4;
        goto L93
    L33:
        if (attrName.equals(ATTR_MIN_WIDTH) == false) goto L92;
        r0 = ParameterName.AUTO_PICTUREQUALITY_ENABLED;
        goto L93
    L36:
        if (attrName.equals(ATTR_CALLING_FEATURE_ID) == false) goto L92;
        r0 = ParameterName.BLUE_STRETCH;
        goto L93
    L39:
        if (attrName.equals(ATTR_PREV_AFFILIATION) == false) goto L92;
        r0 = ParameterName.DE_CONTOUR;
        goto L93
    L42:
        if (attrName.equals(ATTR_TASKTYPE) == false) goto L92;
        r0 = 12;
        goto L93
    L45:
        if (attrName.equals(ATTR_CALLING_UID) == false) goto L92;
        r0 = ParameterName.FILM_MODE;
        goto L93
    L48:
        if (attrName.equals(ATTR_USERID) == false) goto L92;
        r0 = 9;
        goto L93
    L51:
        if (attrName.equals(ATTR_ROOT_AFFINITY) == false) goto L92;
        r0 = 5;
        goto L93
    L54:
        if (attrName.equals(ATTR_SUPPORTS_PICTURE_IN_PICTURE) == false) goto L92;
        r0 = ParameterName.COLOR_TEMPERATURE;
        goto L93
    L57:
        if (attrName.equals(ATTR_AUTOREMOVERECENTS) == false) goto L92;
        r0 = 8;
        goto L93
    L60:
        if (attrName.equals(ATTR_ORIGACTIVITY) == false) goto L92;
        r0 = 3;
        goto L93
    L63:
        if (attrName.equals(ATTR_NON_FULLSCREEN_BOUNDS) == false) goto L92;
        r0 = ParameterName.GLOBE_DIMMING;
        goto L93
    L66:
        if (attrName.equals(ATTR_MIN_HEIGHT) == false) goto L92;
        r0 = ParameterName.AUTO_SUPER_RESOLUTION_ENABLED;
        goto L93
    L69:
        if (attrName.equals(ATTR_RESIZE_MODE) == false) goto L92;
        r0 = ParameterName.COLOR_TUNE;
        goto L93
    L72:
        if (attrName.equals(ATTR_EFFECTIVE_UID) == false) goto L92;
        r0 = 11;
        goto L93
    L75:
        if (attrName.equals(ATTR_USER_SETUP_COMPLETE) == false) goto L92;
        r0 = 10;
        goto L93
    L78:
        if (attrName.equals(ATTR_TASK_AFFILIATION) == false) goto L92;
        r0 = 16;
        goto L93
    L81:
        if (attrName.equals(ATTR_REALACTIVITY_SUSPENDED) == false) goto L92;
        r0 = 2;
        goto L93
    L84:
        if (attrName.equals(ATTR_NEXT_AFFILIATION) == false) goto L92;
        r0 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L93
    L87:
        if (attrName.equals(ATTR_TASKID) == false) goto L92;
        r0 = 0;
        goto L93
    L90:
        if (attrName.equals(ATTR_LASTTIMEMOVED) == false) goto L92;
        r0 = 14;
        goto L93
    L130:
        boolean rootHasReset4 = rootHasReset;
        boolean autoRemoveRecents4 = autoRemoveRecents;
        ActivityManager.TaskDescription taskDescription2 = taskDescription;
        taskDescription2.restoreFromXml(in);
        Intent affinityIntent = null;
        Intent intent = null;
    L131:
        int event = in.next();
        taskDescription2 = taskDescription2;
        if (event == 1) goto L156;
        origActivity = origActivity;
        int event2 = event;
        if (event2 != 3) goto L140;
        if (in.getDepth() >= outerDepth) goto L140;
    L157:
        if (hasRootAffinity == true) goto L160;
        rootAffinity = rootAffinity2;
    L162:
        if (effectiveUid > 0) goto L183;
        if (intent == null) goto L165;
        Intent r2 = intent;
    L166:
        Intent checkIntent = r2;
        if (checkIntent == null) goto L180;
        IPackageManager pm = AppGlobals.getPackageManager();
        String affinity = rootAffinity2;
        String rootAffinity3 = rootAffinity;
        int effectiveUid3 = 0;
        int effectiveUid4 = userId;
        ApplicationInfo ai = pm.getApplicationInfo(checkIntent.getComponent().getPackageName(), 8704, effectiveUid4);     // Catch: RemoteException -> L175
        if (ai == null) goto L177;
        effectiveUid3 = ai.uid;     // Catch: RemoteException -> L175
    L177:
        int effectiveUid5 = effectiveUid3;
    L182:
        Slog.w("ActivityTaskManager", "Updating task #" + taskId + " for " + checkIntent + ": effectiveUid=" + effectiveUid5);
    L185:
        if (persistTaskVersion >= 1) goto L191;
        if (userId2 == 1) goto L188;
    L193:
        boolean supportsPictureInPicture3 = supportsPictureInPicture;
    L194:
        Builder r8 = Builder.m10209$$Nest$msetTaskAffiliation(Builder.m10198$$Nest$msetLastTaskDescription(Builder.m10200$$Nest$msetNeverRelinquishIdentity(Builder.m10199$$Nest$msetLastTimeMoved(Builder.m10197$$Nest$msetLastDescription(Builder.m10210$$Nest$msetUserId(Builder.m10193$$Nest$msetAutoRemoveRecents(Builder.m10207$$Nest$msetRootWasReset(Builder.m10202$$Nest$msetOrigActivity(Builder.m10206$$Nest$msetRootAffinity(Builder.m10191$$Nest$msetAffinity(Builder.m10192$$Nest$msetAffinityIntent(new Builder(taskSupervisor.mService).setTaskId(taskId).setIntent(intent), affinityIntent), affinity), rootAffinity3).setRealActivity(realActivity), origActivity), rootHasReset4), autoRemoveRecents4), effectiveUid4).setEffectiveUid(effectiveUid5), lastDescription), lastTimeOnTop), neverRelinquishIdentity), taskDescription2), prevTaskId);
        int taskAffiliation3 = taskId2;
        Builder r9 = Builder.m10201$$Nest$msetNextAffiliateTaskId(Builder.m10203$$Nest$msetPrevAffiliateTaskId(r8, taskAffiliation3), nextTaskId);
        int nextTaskId3 = callingUid;
        Builder r10 = Builder.m10195$$Nest$msetCallingPackage(Builder.m10196$$Nest$msetCallingUid(r9, nextTaskId3), callingPackage);
        String callingPackage2 = callingFeatureId;
        Builder r11 = Builder.m10204$$Nest$msetRealActivitySuspended(Builder.m10208$$Nest$msetSupportsPictureInPicture(Builder.m10205$$Nest$msetResizeMode(Builder.m10194$$Nest$msetCallingFeatureId(r10, callingPackage2), resizeMode), supportsPictureInPicture3), realActivitySuspended);
        boolean realActivitySuspended3 = userSetupComplete;
        Builder r12 = Builder.m10211$$Nest$msetUserSetupComplete(r11, realActivitySuspended3).setMinWidth(minWidth);
        int minWidth3 = minHeight;
        Task task = r12.setMinHeight(minWidth3).buildInner();
        Rect lastNonFullscreenBounds3 = lastNonFullscreenBounds;
        task.mLastNonFullscreenBounds = lastNonFullscreenBounds3;
        task.setBounds(lastNonFullscreenBounds3);
        task.mWindowLayoutAffinity = windowLayoutAffinity;
        if (activities.size() <= 0) goto L201;
        DisplayContent dc = taskSupervisor.mRootWindowContainer.getDisplayContent(0);
        dc.getDefaultTaskDisplayArea().addChild(task, Integer.MIN_VALUE);
        int activityNdx = activities.size() - 1;
    L197:
        if (activityNdx < 0) goto L201;
        task.addChild(activities.get(activityNdx));
        activityNdx = activityNdx - 1;
    L201:
        if (ActivityTaskManagerDebugConfig.DEBUG_RECENTS == false) goto L203;
        Slog.d("ActivityTaskManager", "Restored task=" + task);
    L203:
        return task;
    L188:
        if (resizeMode != 2) goto L193;
        resizeMode = 1;
        supportsPictureInPicture3 = supportsPictureInPicture;
        goto L194
    L191:
        if (resizeMode != 3) goto L193;
        resizeMode = 2;
        supportsPictureInPicture3 = true;
    L181:
        effectiveUid5 = effectiveUid3;
    L179:
        affinity = rootAffinity2;
        rootAffinity3 = rootAffinity;
        effectiveUid3 = 0;
        effectiveUid4 = userId;
        goto L181
    L180:
        affinity = rootAffinity2;
        rootAffinity3 = rootAffinity;
        effectiveUid3 = 0;
        effectiveUid4 = userId;
        goto L181
    L165:
        r2 = affinityIntent;
        goto L166
    L183:
        affinity = rootAffinity2;
        rootAffinity3 = rootAffinity;
        effectiveUid4 = userId;
        effectiveUid5 = effectiveUid;
        goto L185
    L160:
        if ("@".equals(rootAffinity) == false) goto L162;
        rootAffinity = null;
    L140:
        if (event2 != 2) goto L131;
        String name = in.getName();
        if (TAG_AFFINITYINTENT.equals(name) == false) goto L145;
        affinityIntent = Intent.restoreFromXml(in);
    L154:
        outerDepth = outerDepth;
        goto L131
    L145:
        if (TAG_INTENT.equals(name) == false) goto L148;
        intent = Intent.restoreFromXml(in);
        goto L154
    L148:
        if ("activity".equals(name) == false) goto L153;
        ActivityRecord activity = ActivityRecord.restoreFromXml(in, taskSupervisor);
        if (activity == null) goto L154;
        activities.add(activity);
        goto L154
    L153:
        Slog.e("ActivityTaskManager", "restoreTask: Unexpected name=" + name);
        XmlUtils.skipCurrentTag(in);
        goto L154
    L156:
        origActivity = origActivity;
        event2 = event;
        goto L157
    }

    @Override // com.android.server.wm.TaskFragment, com.android.server.wm.WindowContainer
    boolean isOrganized() {
        if (this.mTaskOrganizer == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean canBeOrganized() {
        if (isRootTask() == false) goto L5;
    L14:
        return true;
    L5:
        if (this.mCreatedByOrganizer == true) goto L14;
        Task parentTask = getParent().asTask();
        if (parentTask != null) goto L10;
    L12:
        return false;
    L10:
        if (parentTask.mCreatedByOrganizer == false) goto L12;
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean showSurfaceOnCreation() {
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    protected void reparentSurfaceControl(SurfaceControl.Transaction t, SurfaceControl newParent) {
        if (isOrganized() == true) goto L5;
    L7:
        super.reparentSurfaceControl(t, newParent);
        return;
    L5:
        if (isAlwaysOnTop() == false) goto L7;
    }

    void setHasBeenVisible(boolean hasBeenVisible) {
        this.mHasBeenVisible = hasBeenVisible;
        if (hasBeenVisible == true) goto L6;
        return;
    L6:
        if (this.mDeferTaskAppear == true) goto L8;
        sendTaskAppeared();
    L8:
        WindowContainer<?> parent = getParent();
    L9:
        if (parent == null) goto L14;
        Task parentTask = parent.asTask();
        if (parentTask == null) goto L17;
        parentTask.setHasBeenVisible(true);
        parent = parent.getParent();
        goto L9
    L17:
        return;
    }

    boolean getHasBeenVisible() {
        return this.mHasBeenVisible;
    }

    void setDeferTaskAppear(boolean deferTaskAppear) {
        boolean wasDeferred = this.mDeferTaskAppear;
        this.mDeferTaskAppear = deferTaskAppear;
        if (wasDeferred == false) goto L7;
        if (deferTaskAppear == true) goto L8;
        sendTaskAppeared();
        return;
    L8:
        return;
    }

    boolean taskAppearedReady() {
        if (this.mTaskOrganizer != null) goto L6;
        return false;
    L6:
        if (this.mDeferTaskAppear == false) goto L9;
        return false;
    L9:
        if (this.mCreatedByOrganizer == false) goto L12;
        return true;
    L12:
        if (this.mSurfaceControl != null) goto L14;
        return false;
    L14:
        if (getHasBeenVisible() == true) goto L16;
        return false;
    L16:
        return true;
    }

    private void sendTaskAppeared() {
        if (this.mTaskOrganizer == null) goto L6;
        this.mAtmService.mTaskOrganizerController.onTaskAppeared(this.mTaskOrganizer, this);
        return;
    }

    private void sendTaskVanished(ITaskOrganizer organizer) {
        if (organizer == null) goto L5;
        this.mAtmService.mTaskOrganizerController.onTaskVanished(organizer, this);
        return;
    }

    boolean setTaskOrganizer(ITaskOrganizer organizer) {
        return setTaskOrganizer(organizer, false);
    }

    boolean setTaskOrganizer(ITaskOrganizer organizer, boolean skipTaskAppeared) {
        if (this.mTaskOrganizer != organizer) goto L5;
        return false;
    L5:
        ITaskOrganizer prevOrganizer = this.mTaskOrganizer;
        this.mTaskOrganizer = organizer;
        sendTaskVanished(prevOrganizer);
        if (this.mTaskOrganizer == null) goto L9;
        if (skipTaskAppeared == true) goto L17;
        sendTaskAppeared();
        return true;
    L17:
        return true;
    L9:
        TaskDisplayArea taskDisplayArea = getDisplayArea();
        if (taskDisplayArea == null) goto L12;
        taskDisplayArea.removeLaunchRootTask(this);
    L12:
        setForceHidden(2, false);
        if (this.mCreatedByOrganizer == false) goto L19;
        removeImmediately("setTaskOrganizer");
        return true;
    L19:
        return true;
    }

    boolean updateTaskOrganizerState() {
        return updateTaskOrganizerState(false);
    }

    boolean updateTaskOrganizerState(boolean skipTaskAppeared) {
        if (getSurfaceControl() != null) goto L6;
        return false;
    L6:
        if (canBeOrganized() == false) goto L8;
        TaskOrganizerController controller = this.mWmService.mAtmService.mTaskOrganizerController;
        ITaskOrganizer organizer = controller.getTaskOrganizer();
        if (this.mCreatedByOrganizer == false) goto L18;
        if (this.mTaskOrganizer == null) goto L18;
        if (organizer == null) goto L18;
        if (this.mTaskOrganizer == organizer) goto L18;
        return false;
    L18:
        return setTaskOrganizer(organizer, skipTaskAppeared);
    L8:
        return setTaskOrganizer(null);
    }

    @Override // com.android.server.wm.TaskFragment, com.android.server.wm.WindowContainer
    void setSurfaceControl(SurfaceControl sc) {
        super.setSurfaceControl(sc);
        sendTaskAppeared();
    }

    boolean isFocused() {
        if (this.mDisplayContent != null) goto L5;
    L14:
        return false;
    L5:
        if (this.mDisplayContent.mFocusedApp == null) goto L14;
        Task focusedTask = this.mDisplayContent.mFocusedApp.getTask();
        if (focusedTask == this) goto L12;
        if (focusedTask != null) goto L11;
        return false;
    L11:
        if (focusedTask.getParent() == this) goto L12;
        return false;
    L12:
        return true;
    }

    private boolean hasVisibleChildren() {
        if (isAttached() == true) goto L5;
    L11:
        return false;
    L5:
        if (isForceHidden() == true) goto L11;
        if (getActivity(new Task$$ExternalSyntheticLambda38()) == null) goto L12;
        return true;
    L12:
        return false;
    }

    void onAppFocusChanged(boolean hasFocus) {
        dispatchTaskInfoChangedIfNeeded(false);
        Task parentTask = getParent().asTask();
        if (parentTask == null) goto L5;
        parentTask.dispatchTaskInfoChangedIfNeeded(false);
    L5:
        this.mAtmService.getTaskChangeNotificationController().notifyTaskFocusChanged(this.mTaskId, hasFocus);
    }

    void onPictureInPictureParamsChanged() {
        if (inPinnedWindowingMode() == false) goto L5;
    L6:
        dispatchTaskInfoChangedIfNeeded(true);
        return;
    L5:
        if (DesktopModeFlags.ENABLE_DESKTOP_WINDOWING_PIP.isTrue() == true) goto L6;
    }

    void onShouldDockBigOverlaysChanged() {
        dispatchTaskInfoChangedIfNeeded(true);
    }

    void onSizeCompatActivityChanged() {
        dispatchTaskInfoChangedIfNeeded(true);
    }

    void setMainWindowSizeChangeTransaction(SurfaceControl.Transaction t) {
        setMainWindowSizeChangeTransaction(t, this);
        forAllWindows(new Task$$ExternalSyntheticLambda7(), true);
    }

    private void setMainWindowSizeChangeTransaction(final SurfaceControl.Transaction t, Task origin) {
        ActivityRecord topActivity = getTopNonFinishingActivity();
        if (topActivity == null) goto L5;
        Task leaf = topActivity.getTask();
    L6:
        if (leaf != null) goto L8;
        return;
    L8:
        if (leaf == this) goto L11;
        leaf.setMainWindowSizeChangeTransaction(t, origin);
        return;
    L11:
        final WindowState w = getTopVisibleAppMainWindow();
        if (w == null) goto L14;
        w.mIsSurfacePositionPaused = true;
        w.applyWithNextDraw(new Task$$ExternalSyntheticLambda43(w, t));
        return;
    L14:
        t.apply();
        return;
    L5:
        leaf = null;
        goto L6
    }

    private static /* synthetic */ void lambda$setMainWindowSizeChangeTransaction$19(WindowState w, SurfaceControl.Transaction t, SurfaceControl.Transaction d) {
        w.mIsSurfacePositionPaused = false;
        w.updateSurfacePosition(d);
        d.merge(t);
    }

    @Override // com.android.server.wm.TaskFragment
    boolean setForceHidden(int flags, boolean set) {
        boolean wasHidden = isForceHidden();
        boolean wasVisible = isVisible();
        if (super.setForceHidden(flags, set) == true) goto L6;
        return false;
    L6:
        boolean nowHidden = isForceHidden();
        if (wasHidden != nowHidden) goto L9;
        return true;
    L9:
        if (wasVisible == false) goto L13;
        if (nowHidden == false) goto L13;
        moveToBack("setForceHidden", null);
        return true;
    L13:
        if (isAlwaysOnTop() == false) goto L19;
        moveToFront("setForceHidden");
        return true;
    L19:
        return true;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public boolean isAlwaysOnTop() {
        if (isForceHidden() == false) goto L5;
    L7:
        return false;
    L5:
        if (super.isAlwaysOnTop() == false) goto L7;
        return true;
    }

    @Deprecated
    boolean isAlwaysOnTopWhenVisible() {
        return super.isAlwaysOnTop();
    }

    boolean isForceExcludedFromRecents() {
        return this.mForceExcludedFromRecents;
    }

    void setForceExcludedFromRecents(boolean excluded) {
        Slog.w("ActivityTaskManager", "Flag com.android.window.flags.exclude_task_from_recents is not enabled");
    }

    boolean isForceHiddenForPinnedTask() {
        if ((this.mForceHiddenFlags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.android.server.wm.TaskFragment, com.android.server.wm.WindowContainer
    long getProtoFieldId() {
        return 1146756268037L;
    }

    public int getTaskLabelHashcode() {
        if (Constants.ENABLE_GAME_ASSIST == true) goto L5;
        return 0;
    L5:
        if (this.mTaskDescription != null) goto L7;
        return 0;
    L7:
        if (this.mTaskDescription.getLabel() == null) goto L12;
        int taskHashcode = this.mTaskDescription.getLabel().hashCode();
        return taskHashcode;
    L12:
        return 0;
    }

    void restoreWindowingMode() {
        if (this.mMultiWindowRestoreWindowingMode != (-1)) goto L6;
        return;
    L6:
        if (getParent().mRemoteToken.toWindowContainerToken().equals(this.mMultiWindowRestoreParent) == true) goto L8;
        Task parent = fromWindowContainerToken(this.mMultiWindowRestoreParent);
        reparent(parent, Integer.MAX_VALUE);
    L8:
        setRootTaskWindowingMode(this.mMultiWindowRestoreWindowingMode);
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public void setWindowingMode(int windowingMode) {
        if (isRootTask() == true) goto L6;
        this.mMultiWindowRestoreWindowingMode = -1;
        super.setWindowingMode(windowingMode);
        return;
    L6:
        setWindowingModeInner(windowingMode, false);
    }

    public void setRootTaskWindowingMode(int preferredWindowingMode) {
        if (isRootTask() == true) goto L6;
        Slog.wtf("ActivityTaskManager", "Trying to set root-task windowing-mode on a non-root-task: " + this, new Throwable());
        super.setWindowingMode(preferredWindowingMode);
        return;
    L6:
        setWindowingModeInner(preferredWindowingMode, false);
    }

    private void setWindowingModeInner(int preferredWindowingMode, boolean creating) {
        TaskDisplayArea taskDisplayArea = getDisplayArea();
        if (taskDisplayArea != null) goto L6;
        Slog.d("ActivityTaskManager", "taskDisplayArea is null, bail early");
        return;
    L6:
        int currentMode = getWindowingMode();
        Task topTask = getTopMostTask();
        int windowingMode = preferredWindowingMode;
        if (creating == false) goto L9;
    L11:
        if (currentMode != windowingMode) goto L14;
        getRequestedOverrideConfiguration().windowConfiguration.setWindowingMode(windowingMode);
        return;
    L14:
        this.mMultiWindowRestoreWindowingMode = -1;
        ActivityRecord topActivity = getTopNonFinishingActivity();
        int likelyResolvedMode = windowingMode;
        if (windowingMode != 0) goto L22;
        ConfigurationContainer parent = getParent();
        if (parent == null) goto L19;
        int r10 = parent.getWindowingMode();
    L20:
        likelyResolvedMode = r10;
        goto L22
    L19:
        r10 = 1;
    L22:
        if (currentMode != 2) goto L24;
        setCanAffectSystemUiFlags(true);
        this.mRootWindowContainer.notifyActivityPipModeChanged(this, null);
    L24:
        if (likelyResolvedMode == 2) goto L26;
    L28:
        if (likelyResolvedMode == 1) goto L35;
        if (topActivity == null) goto L35;
        if (topActivity.isNoDisplay() == true) goto L35;
        if (topActivity.canForceResizeNonResizable(likelyResolvedMode) == false) goto L35;
        String packageName = topActivity.info.applicationInfo.packageName;
        this.mAtmService.getTaskChangeNotificationController().notifyActivityForcedResizable(topTask.mTaskId, 1, packageName);
    L35:
        this.mAtmService.deferWindowLayout();
        if (topActivity == null) goto L41;
        this.mTaskSupervisor.mNoAnimActivities.add(topActivity);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        this.mAtmService.continueWindowLayout();
        throw th;
    L41:
        if (windowingMode == 1) goto L43;
    L51:
        boolean isPip2ExperimentEnabled = ActivityTaskManagerService.isPip2ExperimentEnabled();     // Catch: Throwable -> L38
        if (isPip2ExperimentEnabled == true) goto L66;
        if (windowingMode == 1) goto L55;
    L65:
        super.setWindowingMode(windowingMode);     // Catch: Throwable -> L38
        goto L66
    L55:
        if (getWindowingMode() != 5) goto L65;
        if (isVisible() == false) goto L65;
        if (getParent() == null) goto L65;
        if (getParent().getConfiguration().orientation != 1) goto L65;
        if (getConfiguration().orientation != 2) goto L65;
        this.mExt.setLandFreeformToFull(true);     // Catch: Throwable -> L38
    L66:
        if (currentMode != 2) goto L98;
        if (topActivity == null) goto L98;
        if (topActivity.getLastParentBeforePip() != null) goto L71;
    L86:
        if (isPip2ExperimentEnabled == false) goto L89;
        super.setWindowingMode(windowingMode);     // Catch: Throwable -> L38
    L89:
        if (topActivity.shouldBeVisible() == false) goto L100;
        this.mAtmService.resumeAppSwitches();     // Catch: Throwable -> L38
        if (isPip2ExperimentEnabled == true) goto L100;
        ActivityRecord ar = this.mAtmService.mLastResumedActivity;     // Catch: Throwable -> L38
        if (ar == null) goto L100;
        if (ar.getTask() == null) goto L100;
        this.mAtmService.takeTaskSnapshot(ar.getTask().mTaskId, true);     // Catch: Throwable -> L38
    L100:
        if (creating == false) goto L103;
        this.mAtmService.continueWindowLayout();
        return;
    L103:
        if (topActivity == null) goto L109;
        if (currentMode != 1) goto L109;
        if (windowingMode != 2) goto L109;
        if (this.mTransitionController.isShellTransitionsEnabled() == true) goto L109;
        this.mDisplayContent.mPinnedTaskController.deferOrientationChangeForEnteringPipFromFullScreenIfNeeded();     // Catch: Throwable -> L38
    L109:
        this.mAtmService.continueWindowLayout();
        if (this.mTaskSupervisor.isRootVisibilityUpdateDeferred() == true) goto L112;
        this.mRootWindowContainer.ensureActivitiesVisible();
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();
    L112:
        getExt().onTaskWindowingModeChanged(currentMode, getWindowingMode(), "setWindowingModeInner");
        return;
    L71:
        if (isForceHidden() == true) goto L86;
        if (topActivity.getLastParentBeforePip().isAttached() == false) goto L86;
        this.mTransitionController.collect(topActivity);     // Catch: Throwable -> L38
        Task lastParentBeforePip = topActivity.getLastParentBeforePip();     // Catch: Throwable -> L38
        topActivity.getRequestedOverrideConfiguration().windowConfiguration.setWindowingMode(0);     // Catch: Throwable -> L38
        topActivity.reparent(lastParentBeforePip, lastParentBeforePip.getChildCount(), "movePinnedActivityToOriginalTask");     // Catch: Throwable -> L38
        DisplayContent dc = topActivity.getDisplayContent();     // Catch: Throwable -> L38
        if (dc != null) goto L77;
    L79:
        lastParentBeforePip.moveToFront("movePinnedActivityToOriginalTask");     // Catch: Throwable -> L38
        if (lastParentBeforePip.mSyncState != 0) goto L86;
        lastParentBeforePip.prepareSurfaces();     // Catch: Throwable -> L38
        if (topActivity.mTransitionController.inFinishingTransition(topActivity) == false) goto L86;
        SurfaceControl.Transaction tx = taskDisplayArea.getPendingTransaction();     // Catch: Throwable -> L38
        Transition.assignLayers(taskDisplayArea, tx);     // Catch: Throwable -> L38
        SurfaceControl leash = topActivity.getFixedRotationLeash();     // Catch: Throwable -> L38
        if (leash == null) goto L86;
        tx.setLayer(leash, topActivity.getLastLayer());     // Catch: Throwable -> L38
        goto L86
    L77:
        if (dc.isFixedRotationLaunchingApp(topActivity) == false) goto L79;
        topActivity.getOrCreateFixedRotationLeash(topActivity.getSyncTransaction());     // Catch: Throwable -> L38
    L98:
        if (isPip2ExperimentEnabled == false) goto L100;
        super.setWindowingMode(windowingMode);     // Catch: Throwable -> L38
        goto L100
    L43:
        if (getWindowingMode() != 5) goto L51;
        if (isVisible() == false) goto L51;
        if (getParent() == null) goto L51;
        if (getParent().getConfiguration().orientation == getConfiguration().orientation) goto L51;
        this.mExt.setFreeformToFullChangeOrientation(getConfiguration().orientation);     // Catch: Throwable -> L38
        goto L51
    L26:
        if (taskDisplayArea.getRootPinnedTask() == null) goto L28;
        taskDisplayArea.getRootPinnedTask().dismissPip();
        goto L28
    L9:
        if (taskDisplayArea.isValidWindowingMode(windowingMode, null, topTask) == true) goto L11;
        windowingMode = 0;
        goto L11
    }

    boolean abortPipEnter(ActivityRecord top) {
        if (inPinnedWindowingMode() == true) goto L5;
    L22:
        return false;
    L5:
        if (top.inPinnedWindowingMode() == true) goto L22;
        if (canMoveTaskToBack(this) == false) goto L22;
        Transition transition = new Transition(4, 0, this.mTransitionController, this.mWmService.mSyncEngine);
        this.mTransitionController.moveToCollecting(transition);
        this.mTransitionController.requestStartTransition(transition, this, null, null);
        if (top.getLastParentBeforePip() == null) goto L15;
        Task lastParentBeforePip = top.getLastParentBeforePip();
        if (lastParentBeforePip.isAttached() == false) goto L15;
        top.reparent(lastParentBeforePip, lastParentBeforePip.getChildCount(), "movePinnedActivityToOriginalTask");
    L15:
        if (isAttached() == false) goto L18;
        setRootTaskWindowingMode(0);
        moveTaskToBackInner(this, null);
    L18:
        if (top.isAttached() == false) goto L23;
        top.setWindowingMode(0);
        top.mWaitForEnteringPinnedMode = false;
        return true;
    L23:
        return true;
    }

    void resumeNextFocusAfterReparent() {
        adjustFocusToNextFocusableTask("reparent", true, true);
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();
        this.mRootWindowContainer.ensureActivitiesVisible();
    }

    final boolean isOnHomeDisplay() {
        if (getDisplayId() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    void moveToFront(String reason) {
        moveToFront(reason, null);
    }

    void moveToFront(String reason, Task task) {
        if (isAttached() == true) goto L6;
        return;
    L6:
        if (Features.FEAT_QUICK_WIN == false) goto L8;
        getExt().moveToFront(reason);
    L8:
        this.mTransitionController.recordTaskOrder(this);
        TaskDisplayArea taskDisplayArea = getDisplayArea();
        if (isActivityTypeHome() == true) goto L14;
        if (returnsToHomeRootTask() == false) goto L14;
        taskDisplayArea.moveHomeRootTaskToFront(reason + " returnToHome");
    L14:
        if (isRootTask() == false) goto L16;
        Task lastFocusedTask = taskDisplayArea.getFocusedRootTask();
    L17:
        if (task != null) goto L19;
        task = this;
    L19:
        task.getParent().positionChildAt(Integer.MAX_VALUE, task, true);
        taskDisplayArea.updateLastFocusedRootTask(lastFocusedTask, reason);
        return;
    L16:
        lastFocusedTask = null;
        goto L17
    }

    void moveToBack(String reason, Task task) {
        if (isAttached() == true) goto L6;
        return;
    L6:
        if (Features.FEAT_QUICK_WIN == false) goto L8;
        getExt().moveToBack(reason);
    L8:
        TaskDisplayArea displayArea = getDisplayArea();
        if (this.mCreatedByOrganizer == true) goto L21;
        WindowContainer parent = getParent();
        if (parent == null) goto L13;
        Task parentTask = parent.asTask();
    L14:
        if (parentTask == null) goto L16;
        parentTask.moveToBack(reason, this);
    L17:
        if (task == null) goto L27;
        if (task == this) goto L28;
        positionChildAtBottom(task);
        return;
    L28:
        return;
    L27:
        return;
    L16:
        Task lastFocusedTask = displayArea.getFocusedRootTask();
        displayArea.positionChildAt(Integer.MIN_VALUE, this, false);
        displayArea.updateLastFocusedRootTask(lastFocusedTask, reason);
        goto L17
    L13:
        parentTask = null;
        goto L14
    L21:
        if (task == null) goto L26;
        if (task == this) goto L29;
        displayArea.positionTaskBehindHome(task);
        return;
    L29:
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    void switchUser(int userId) {
        if (this.mCurrentUser != userId) goto L5;
        return;
    L5:
        this.mCurrentUser = userId;
        super.switchUser(userId);
        if (isRootTask() == false) goto L8;
        return;
    L8:
        if (showToCurrentUser() == false) goto L12;
        getParent().positionChildAt(Integer.MAX_VALUE, this, false);
        return;
    }

    void checkReadyForSleep() {
        if (shouldSleepActivities() == true) goto L5;
        return;
    L5:
        if (goToSleepIfPossible(false) == false) goto L9;
        this.mTaskSupervisor.checkReadyForSleepLocked(true);
        return;
    }

    boolean goToSleepIfPossible(final boolean shuttingDown) {
        final int[] sleepInProgress = {0};
        forAllLeafTasksAndLeafTaskFragments(new Task$$ExternalSyntheticLambda17(shuttingDown, sleepInProgress), true);
        if (sleepInProgress[0] == 0) goto L5;
        return false;
    L5:
        return true;
    }

    private static /* synthetic */ void lambda$goToSleepIfPossible$20(boolean shuttingDown, int[] sleepInProgress, TaskFragment taskFragment) {
        if (taskFragment.sleepIfPossible(shuttingDown) == true) goto L6;
        sleepInProgress[0] = sleepInProgress[0] + 1;
        return;
    }

    boolean isTopRootTaskInDisplayArea() {
        TaskDisplayArea taskDisplayArea = getDisplayArea();
        if (taskDisplayArea != null) goto L5;
    L7:
        return false;
    L5:
        if (taskDisplayArea.isTopRootTask(this) == false) goto L7;
        return true;
    }

    boolean isFocusedRootTaskOnDisplay() {
        if (this.mDisplayContent != null) goto L5;
    L7:
        return false;
    L5:
        if (this != this.mDisplayContent.getFocusedRootTask()) goto L7;
        return true;
    }

    void ensureActivitiesVisible(ActivityRecord starting) {
        ensureActivitiesVisible(starting, true);
    }

    void ensureActivitiesVisible(final ActivityRecord starting, final boolean notifyClients) {
        this.mTaskSupervisor.beginActivityVisibilityUpdate();
        forAllLeafTasks(new Task$$ExternalSyntheticLambda1(starting, notifyClients), true);     // Catch: Throwable -> L9
        if (this.mTranslucentActivityWaiting != null) goto L6;
    L11:
        this.mTaskSupervisor.endActivityVisibilityUpdate();
        return;
    L6:
        if (this.mUndrawnActivitiesBelowTopTranslucent.isEmpty() == false) goto L11;
        notifyActivityDrawnLocked(null);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.mTaskSupervisor.endActivityVisibilityUpdate();
        throw th;
    }

    private static /* synthetic */ void lambda$ensureActivitiesVisible$21(ActivityRecord starting, boolean notifyClients, Task task) {
        task.updateActivityVisibilities(starting, notifyClients);
    }

    void abortTranslucentActivityWaiting(ActivityRecord r) {
        if (r == this.mTranslucentActivityWaiting) goto L8;
        if (r == this.mPendingConvertFromTranslucentActivity) goto L8;
        return;
    L8:
        if (this.mTranslucentActivityWaiting == null) goto L14;
        if (this.mTranslucentActivityWaiting.finishing == true) goto L12;
        this.mTranslucentActivityWaiting.setOccludesParent(true);
    L12:
        this.mTranslucentActivityWaiting = null;
    L14:
        if (this.mPendingConvertFromTranslucentActivity != null) goto L16;
    L19:
        this.mUndrawnActivitiesBelowTopTranslucent.clear();
        this.mHandler.removeMessages(101);
        return;
    L16:
        if (this.mPendingConvertFromTranslucentActivity.finishing == true) goto L18;
        this.mPendingConvertFromTranslucentActivity.setOccludesParent(true);
    L18:
        this.mPendingConvertFromTranslucentActivity = null;
        goto L19
    }

    void checkTranslucentActivityWaiting(ActivityRecord top) {
        if (this.mTranslucentActivityWaiting == top) goto L9;
        this.mUndrawnActivitiesBelowTopTranslucent.clear();
        if (this.mTranslucentActivityWaiting == null) goto L7;
        notifyActivityDrawnLocked(null);
        this.mTranslucentActivityWaiting = null;
    L7:
        this.mHandler.removeMessages(101);
        return;
    }

    void convertActivityToTranslucent(ActivityRecord r) {
        this.mTranslucentActivityWaiting = r;
        this.mPendingConvertFromTranslucentActivity = r;
        this.mUndrawnActivitiesBelowTopTranslucent.clear();
        updateTaskDescription();
        this.mHandler.sendEmptyMessageDelayed(101, 2000);
    }

    void convertActivityFromTranslucent(ActivityRecord r) {
        if (r == this.mPendingConvertFromTranslucentActivity) goto L5;
        Slog.e("ActivityTaskManager", "convertFromTranslucent expects " + this.mPendingConvertFromTranslucentActivity + " but is " + r);
    L5:
        this.mPendingConvertFromTranslucentActivity = null;
        updateTaskDescription();
    }

    void notifyActivityDrawnLocked(ActivityRecord r) {
        if (r != null) goto L4;
    L7:
        ActivityRecord waitingActivity = this.mTranslucentActivityWaiting;
        this.mTranslucentActivityWaiting = null;
        this.mUndrawnActivitiesBelowTopTranslucent.clear();
        this.mHandler.removeMessages(101);
        if (waitingActivity == null) goto L22;
        boolean r1 = false;
        waitingActivity.setMainWindowOpaque(false);
        if (waitingActivity.attachedToProcess() == false) goto L23;
        IApplicationThread r2 = waitingActivity.app.getThread();     // Catch: RemoteException -> L16
        IBinder r3 = waitingActivity.token;     // Catch: RemoteException -> L16
        if (r == null) goto L14;
        r1 = true;
    L14:
        r2.scheduleTranslucentConversionComplete(r3, r1);     // Catch: RemoteException -> L16
        return;
    L17:
        return;
    L23:
        return;
    L22:
        return;
    L4:
        if (this.mUndrawnActivitiesBelowTopTranslucent.remove(r) == true) goto L6;
        return;
    L6:
        if (this.mUndrawnActivitiesBelowTopTranslucent.isEmpty() == true) goto L7;
    }

    boolean resumeTopActivityUncheckedLocked(ActivityRecord prev, ActivityOptions options, boolean deferPause) {
        if (this.mInResumeTopActivity == false) goto L5;
        return false;
    L5:
        boolean someActivityResumed = false;
        this.mInResumeTopActivity = true;     // Catch: Throwable -> L11
        if (isLeafTask() == true) goto L9;
        int idx = this.mChildren.size() - 1;     // Catch: Throwable -> L11
    L14:
        if (idx < 0) goto L29;
        int idx2 = idx - 1;     // Catch: Throwable -> L11
        Task child = (Task) getChildAt(idx);     // Catch: Throwable -> L11
        if (child.isTopActivityFocusable() == false) goto L22;
        if (child.getVisibility(null) != 0) goto L21;
        someActivityResumed = someActivityResumed | child.resumeTopActivityUncheckedLocked(prev, options, deferPause);     // Catch: Throwable -> L11
        if (idx2 < this.mChildren.size()) goto L26;
        idx = this.mChildren.size() - 1;     // Catch: Throwable -> L11
        goto L14
    L26:
        idx = idx2;
        goto L14
    L21:
        if (child.topRunningActivity() != null) goto L29;
    L22:
        idx = idx2;
    L29:
        if (shouldSleepActivities() == false) goto L45;
        ActivityRecord next = topRunningActivity(true);     // Catch: Throwable -> L11
        if (next != null) goto L33;
    L37:
        if (next == null) goto L45;
        if (next.info == null) goto L45;
        if (next.info.applicationInfo == null) goto L45;
        if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(next.info.applicationInfo.getSysEx().prefetchState) == true) goto L45;
        checkReadyForSleep();     // Catch: Throwable -> L11
        goto L45
    L33:
        if (next.canTurnScreenOn() == false) goto L37;
        if (this.mWmService.mPowerManager.isInteractive() == true) goto L37;
        this.mTaskSupervisor.wakeUp(getDisplayId(), "resumeTop-turnScreenOnFlag");     // Catch: Throwable -> L11
        next.setCurrentLaunchCanTurnScreenOn(false);     // Catch: Throwable -> L11
    L45:
        this.mInResumeTopActivity = false;
        return someActivityResumed;
    L9:
        if (isFocusableAndVisible() == false) goto L29;
        someActivityResumed = resumeTopActivityInnerLocked(prev, options, deferPause);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.mInResumeTopActivity = false;
        throw th;
    }

    boolean resumeTopActivityUncheckedLocked() {
        return resumeTopActivityUncheckedLocked(null, null, false);
    }

    private boolean resumeTopActivityInnerLocked(final ActivityRecord prev, final ActivityOptions options, final boolean deferPause) {
        if (this.mAtmService.isBooting() == true) goto L7;
        if (this.mAtmService.isBooted() == true) goto L7;
    L8:
        return false;
    L7:
        if (this.mTaskSupervisor.readyToResume() == false) goto L8;
        ActivityRecord topActivity = topRunningActivity(true);
        if (topActivity == null) goto L12;
        final boolean[] resumed = new boolean[1];
        final TaskFragment topFragment = topActivity.getTaskFragment();
        if (mQtiActivityPluginDelegate != null) goto L16;
    L24:
        forAllLeafTaskFragments(new Task$$ExternalSyntheticLambda44(topFragment, resumed, prev, options, deferPause), true);
        resumed[0] = resumed[0] | topFragment.resumeTopActivity(prev, options, deferPause);
        return resumed[0];
    L16:
        if (getWindowingMode() == 0) goto L24;
        if (topActivity.info == null) goto L24;
        String r3 = topActivity.info.packageName;
        if (getWindowingMode() != 1) goto L22;
        boolean r6 = true;
    L23:
        ActivityPluginDelegate.activityInvokeNotification(r3, r6);
        goto L24
    L22:
        r6 = false;
        goto L23
    L12:
        return resumeNextFocusableActivityWhenRootTaskIsEmpty(prev, options);
    }

    private static /* synthetic */ void lambda$resumeTopActivityInnerLocked$22(TaskFragment topFragment, boolean[] resumed, ActivityRecord prev, ActivityOptions options, boolean deferPause, TaskFragment f) {
        if (topFragment != f) goto L5;
        return;
    L5:
        if (f.canBeResumed(null) == true) goto L7;
        return;
    L7:
        resumed[0] = resumed[0] | f.resumeTopActivity(prev, options, deferPause);
    }

    private boolean resumeNextFocusableActivityWhenRootTaskIsEmpty(ActivityRecord prev, ActivityOptions options) {
        if (isActivityTypeHome() == true) goto L8;
        Task nextFocusedTask = adjustFocusToNextFocusableTask("noMoreActivities");
        if (nextFocusedTask == null) goto L8;
        return this.mRootWindowContainer.resumeFocusedTasksTopActivities(nextFocusedTask, prev);
    L8:
        ActivityOptions.abort(options);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[0] == false) goto L12;
        String protoLogParam0 = String.valueOf("noMoreActivities");
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_STATES, 4037728373502324767L, 0, new Object[]{protoLogParam0});
    L12:
        return this.mRootWindowContainer.resumeHomeActivity(prev, "noMoreActivities", getDisplayArea());
    }

    void startActivityLocked(ActivityRecord r, Task topTask, boolean newTask, boolean isTaskSwitch, ActivityOptions options, ActivityRecord sourceRecord) {
        boolean r1 = false;
        if (options != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        boolean allowMoveToFront = r4;
        Task activityTask = r.getTask();
        if (activityTask != this) goto L12;
    L15:
        boolean r5 = true;
    L16:
        boolean isThisOrHasChildTask = r5;
        if (r.mLaunchTaskBehind == true) goto L23;
        if (allowMoveToFront == false) goto L23;
        if (isThisOrHasChildTask == false) goto L21;
        if (newTask == false) goto L23;
    L21:
        positionChildAtTop(activityTask);
    L23:
        if (newTask == true) goto L30;
        if (isThisOrHasChildTask == false) goto L30;
        if (r.shouldBeVisible() == true) goto L30;
        ActivityOptions.abort(options);
        return;
    L30:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[2] == false) goto L33;
        String protoLogParam0 = String.valueOf(r);
        String protoLogParam1 = String.valueOf(activityTask);
        String protoLogParam2 = String.valueOf(new RuntimeException("here").fillInStackTrace());
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, -2261257617975724313L, 0, new Object[]{protoLogParam0, protoLogParam1, protoLogParam2});
    L33:
        if (mQtiActivityPluginDelegate == null) goto L40;
        String r6 = r.info.packageName;
        if (getWindowingMode() != 1) goto L37;
        boolean r7 = true;
    L38:
        ActivityPluginDelegate.activityInvokeNotification(r6, r7);
        goto L40
    L37:
        r7 = false;
    L40:
        if (isActivityTypeHomeOrRecents() == true) goto L42;
    L45:
        if (allowMoveToFront == true) goto L49;
        ActivityOptions.abort(options);
        return;
    L49:
        if (ActivityTaskManagerDebugConfig.DEBUG_TRANSITION == false) goto L52;
        Slog.v("ActivityTaskManager", "Prepare open transition: starting " + r);
    L52:
        if ((r.intent.getFlags() & 65536) == 0) goto L54;
        this.mTaskSupervisor.mNoAnimActivities.add(r);
        this.mTransitionController.setNoAnimation(r);
    L56:
        if (newTask == true) goto L58;
    L62:
        boolean doShow = true;
        if (newTask == true) goto L65;
        if (options != null) goto L72;
    L74:
        if (options != null) goto L76;
    L78:
        boolean doShow2 = doShow;
    L80:
        if (r.mLaunchTaskBehind == false) goto L85;
        r.setVisibility(true);
        ensureActivitiesVisible(null);
        if (r.isVisibleRequested() == true) goto L84;
        r.notifyUnknownVisibilityLaunchedForKeyguardTransition();
    L84:
        this.mDisplayContent.executeAppTransition();
        return;
    L85:
        if (doShow2 == false) goto L92;
        ActivityRecord prev = activityTask.getActivity(new Task$$ExternalSyntheticLambda26());
        if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(activityTask.prefetchState) == false) goto L89;
        Slog.i("ActivityTaskManager", "skip add StartingWindow for prefetch");
        return;
    L89:
        this.mWmService.mStartingSurfaceController.showStartingWindow(r, prev, newTask, isTaskSwitch, sourceRecord);
        return;
    L92:
        return;
    L76:
        if (options.getDisableStartingWindow() == false) goto L78;
        doShow2 = false;
        goto L80
    L72:
        if (options.getAnimationType() != 5) goto L74;
        doShow = false;
        goto L74
    L65:
        if ((r.intent.getFlags() & 2097152) == 0) goto L74;
        resetTaskIfNeeded(r, r);
        if (topRunningNonDelayedActivityLocked(null) != r) goto L69;
        r1 = true;
    L69:
        doShow = r1;
        goto L74
    L58:
        if (r.mLaunchTaskBehind == true) goto L62;
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == true) goto L62;
        ActivityRecord pipCandidate = findEnterPipOnTaskSwitchCandidate(topTask);
        enableEnterPipOnTaskSwitch(pipCandidate, null, r, options);
        goto L62
    L54:
        this.mTaskSupervisor.mNoAnimActivities.remove(r);
        goto L56
    L42:
        if (getActivityBelow(r) != null) goto L45;
        ActivityOptions.abort(options);
        return;
    L12:
        if (hasChild(activityTask) == true) goto L15;
        r5 = false;
        goto L16
    L5:
        if (options.getAvoidMoveToFront() == false) goto L8;
        r4 = false;
        goto L9
    }

    private static /* synthetic */ boolean lambda$startActivityLocked$23(ActivityRecord a) {
        if (a.mStartingData != null) goto L5;
    L7:
        return false;
    L5:
        if (a.showToCurrentUser() == false) goto L7;
        return true;
    }

    static ActivityRecord findEnterPipOnTaskSwitchCandidate(Task topTask) {
        if (topTask != null) goto L5;
        return null;
    L5:
        final ActivityRecord[] candidate = new ActivityRecord[1];
        topTask.forAllLeafTaskFragments(new Task$$ExternalSyntheticLambda6(candidate));
        return candidate[0];
    }

    private static /* synthetic */ boolean lambda$findEnterPipOnTaskSwitchCandidate$24(ActivityRecord[] candidate, TaskFragment tf) {
        ActivityRecord topActivity = tf.getTopNonFinishingActivity();
        if (topActivity != null) goto L5;
    L10:
        return false;
    L5:
        if (topActivity.isState(ActivityRecord.State.RESUMED, ActivityRecord.State.PAUSING) == false) goto L10;
        if (topActivity.supportsPictureInPicture() == false) goto L10;
        candidate[0] = topActivity;
        return true;
    }

    static void enableEnterPipOnTaskSwitch(ActivityRecord pipCandidate, Task toFrontTask, ActivityRecord toFrontActivity, ActivityOptions opts) {
        if (pipCandidate != null) goto L4;
        return;
    L4:
        if (opts == null) goto L9;
        if (opts.disallowEnterPictureInPictureWhileLaunching() == false) goto L9;
        return;
    L9:
        if (pipCandidate.inPinnedWindowingMode() == false) goto L11;
        return;
    L11:
        if (toFrontTask == null) goto L13;
        Task targetRootTask = toFrontTask.getRootTask();
    L17:
        if (targetRootTask != null) goto L20;
        Slog.e("ActivityTaskManager", "No root task for enter pip, both to front task and activity are null?");
        return;
    L20:
        boolean r1 = false;
        if (opts == null) goto L25;
        if (opts.getTransientLaunch() == false) goto L25;
    L26:
        boolean isTransient = true;
    L29:
        if (targetRootTask.isActivityTypeAssistant() == true) goto L32;
        if (isTransient == true) goto L32;
        r1 = true;
    L32:
        pipCandidate.supportsEnterPipOnTaskSwitch = r1;
        return;
    L25:
        if (targetRootTask.mTransitionController.isTransientHide(targetRootTask) == true) goto L26;
        isTransient = false;
        goto L29
    L13:
        if (toFrontActivity == null) goto L15;
        targetRootTask = toFrontActivity.getRootTask();
        goto L17
    L15:
        targetRootTask = null;
        goto L17
    }

    ActivityRecord resetTaskIfNeeded(ActivityRecord taskTop, ActivityRecord newActivity) {
        if ((newActivity.info.flags & 4) == 0) goto L5;
        boolean forceReset = true;
    L6:
        Task task = taskTop.getTask();
        this.mReuseTask = true;
        ActivityOptions topOptions = sResetTargetTaskHelper.process(task, forceReset);     // Catch: Throwable -> L16
        this.mReuseTask = false;
        if (this.mChildren.contains(task) == false) goto L13;
        ActivityRecord newTop = task.getTopNonFinishingActivity();
        if (newTop == null) goto L13;
        taskTop = newTop;
    L13:
        if (topOptions == null) goto L15;
        taskTop.updateOptionsLocked(topOptions);
    L15:
        return taskTop;
    L16:
        th = move-exception;
        this.mReuseTask = false;
        throw th;
    L5:
        forceReset = false;
        goto L6
    }

    final Task finishTopCrashedActivityLocked(WindowProcessController app, String reason) {
        ActivityRecord r = topRunningActivity();
        if (r != null) goto L5;
    L23:
        return null;
    L5:
        if (r.app != app) goto L23;
        if (r.isActivityTypeHome() == true) goto L10;
    L13:
        Slog.w("ActivityTaskManager", "  Force finishing activity " + r.intent.getComponent().flattenToShortString());
        Task finishedTask = r.getTask();
        this.mDisplayContent.requestTransitionAndLegacyPrepare(2, 16, finishedTask);
        r.finishIfPossible(reason, false);
        ActivityRecord activityBelow = getActivityBelow(r);
        if (activityBelow != null) goto L16;
    L22:
        return finishedTask;
    L16:
        if (activityBelow.isState(ActivityRecord.State.STARTED, ActivityRecord.State.RESUMED, ActivityRecord.State.PAUSING, ActivityRecord.State.PAUSED) == false) goto L22;
        if (activityBelow.isActivityTypeHome() == true) goto L20;
    L21:
        Slog.w("ActivityTaskManager", "  Force finishing activity " + activityBelow.intent.getComponent().flattenToShortString());
        activityBelow.finishIfPossible(reason, false);
        goto L22
    L20:
        if (this.mAtmService.mHomeProcess == activityBelow.app) goto L22;
    L10:
        if (this.mAtmService.mHomeProcess != app) goto L13;
        Slog.w("ActivityTaskManager", "  Not force finishing home activity " + r.intent.getComponent().flattenToShortString());
        return null;
    }

    void finishIfVoiceTask(IBinder binder) {
        if (this.voiceSession != null) goto L5;
    L7:
        PooledPredicate f = PooledLambda.obtainPredicate(new Task$$ExternalSyntheticLambda5(), PooledLambda.__(ActivityRecord.class), binder);
        forAllActivities(f);
        f.recycle();
        return;
    L5:
        if (this.voiceSession.asBinder() != binder) goto L7;
        forAllActivities(new Task$$ExternalSyntheticLambda4(this));
    }

    private /* synthetic */ void lambda$finishIfVoiceTask$25(ActivityRecord r) {
        if (r.finishing == false) goto L5;
        return;
    L5:
        r.finishIfPossible("finish-voice", false);
        this.mAtmService.updateOomAdj();
    }

    private static boolean finishIfVoiceActivity(ActivityRecord r, IBinder binder) {
        if (r.voiceSession != null) goto L5;
        return false;
    L5:
        if (r.voiceSession.asBinder() != binder) goto L17;
        r.clearVoiceSessionLocked();
        r.app.getThread().scheduleLocalVoiceInteractionStarted(r.token, null);     // Catch: RemoteException -> L10
    L11:
        r.mAtmService.finishRunningVoiceLocked();
        return true;
    L17:
        return false;
    }

    private boolean inFrontOfStandardRootTask() {
        TaskDisplayArea taskDisplayArea = getDisplayArea();
        if (taskDisplayArea != null) goto L5;
        return false;
    L5:
        final boolean[] hasFound = new boolean[1];
        Task rootTaskBehind = taskDisplayArea.getRootTask(new Task$$ExternalSyntheticLambda23(this, hasFound));
        if (rootTaskBehind != null) goto L8;
        return false;
    L8:
        if (rootTaskBehind.isActivityTypeStandard() == true) goto L10;
        return false;
    L10:
        return true;
    }

    private /* synthetic */ boolean lambda$inFrontOfStandardRootTask$26(boolean[] hasFound, Task task) {
        if (hasFound[0] == false) goto L5;
        return true;
    L5:
        if (task != this) goto L7;
        hasFound[0] = true;
    L7:
        return false;
    }

    boolean shouldUpRecreateTaskLocked(ActivityRecord srec, String destAffinity) {
        String affinity = ActivityRecord.computeTaskAffinity(destAffinity, srec.getUid());
        if (srec.getTask().affinity != null) goto L5;
    L24:
        return true;
    L5:
        if (srec.getTask().affinity.equals(affinity) == false) goto L24;
        Task task = srec.getTask();
        if (srec.isRootOfTask() == true) goto L10;
    L23:
        return false;
    L10:
        if (task.getBaseIntent() == null) goto L23;
        if (task.getBaseIntent().isDocument() == false) goto L23;
        if (inFrontOfStandardRootTask() == true) goto L16;
        return true;
    L16:
        Task prevTask = getTaskBelow(task);
        if (prevTask != null) goto L21;
        Slog.w("ActivityTaskManager", "shouldUpRecreateTask: task not in history for " + srec);
        return false;
    L21:
        if (task.affinity.equals(prevTask.affinity) == true) goto L23;
        return true;
    }

    boolean navigateUpTo(ActivityRecord srec, Intent destIntent, String resolvedType, NeededUriGrants destGrants, int resultCode, Intent resultData, NeededUriGrants resultGrants) {
        if (srec.attachedToProcess() == true) goto L5;
        return false;
    L5:
        Task task = srec.getTask();
        if (srec.isDescendantOf(this) == true) goto L8;
        return false;
    L8:
        ActivityRecord parent = task.getActivityBelow(srec);
        boolean foundParentInTask = false;
        final ComponentName dest = destIntent.getComponent();
        if (task.getBottomMostActivity() == srec) goto L14;
        if (dest == null) goto L14;
        ActivityRecord candidate = task.getActivity(new Task$$ExternalSyntheticLambda24(dest), srec, false, true);
        if (candidate == null) goto L14;
        foundParentInTask = true;
        ActivityRecord parent2 = candidate;
    L15:
        IActivityController controller = this.mAtmService.mController;
        if (controller == null) goto L26;
        ActivityRecord next = topRunningActivity(srec.token, -1);
        if (next == null) goto L26;
        boolean resumeOK = true;
        resumeOK = controller.activityResuming(next.packageName);     // Catch: RemoteException -> L22
    L24:
        if (resumeOK == true) goto L26;
        return false;
    L23:
        this.mAtmService.mController = null;
        Watchdog.getInstance().setActivityController(null);
    L26:
        long origId = Binder.clearCallingIdentity();
        final int[] resultCodeHolder = {resultCode};
        final Intent[] resultDataHolder = {resultData};
        final NeededUriGrants[] resultGrantsHolder = {resultGrants};
        final ActivityRecord finalParent = parent2;
        task.forAllActivities(new Task$$ExternalSyntheticLambda25(finalParent, resultCodeHolder, resultDataHolder, resultGrantsHolder), srec, true, true);
        int resultCode2 = resultCodeHolder[0];
        Intent resultData2 = resultDataHolder[0];
        if (parent2 == null) goto L34;
        if (foundParentInTask == false) goto L34;
        int callingUid = srec.info.applicationInfo.uid;
        int res = this.mAtmService.getActivityStartController().obtainStarter(destIntent, "navigateUpTo").setResolvedType(resolvedType).setUserId(srec.mUserId).setCaller(srec.app.getThread()).setResultTo(parent2.token).setIntentGrants(destGrants).setCallingPid(-1).setCallingUid(callingUid).setCallingPackage(srec.packageName).setCallingFeatureId(parent2.launchedFromFeatureId).setRealCallingPid(-1).setRealCallingUid(callingUid).setComponentSpecified(true).execute();
        foundParentInTask = ActivityManager.isStartResultSuccessful(res);
        if (res != 0) goto L34;
        parent2.finishIfPossible(resultCode2, resultData2, resultGrants, "navigate-top", true);
    L34:
        Binder.restoreCallingIdentity(origId);
        return foundParentInTask;
    L14:
        parent2 = parent;
        goto L15
    }

    private static /* synthetic */ boolean lambda$navigateUpTo$27(ComponentName dest, ActivityRecord ar) {
        if (ar.info.packageName.equals(dest.getPackageName()) == true) goto L5;
    L7:
        return false;
    L5:
        if (ar.info.name.equals(dest.getClassName()) == false) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$navigateUpTo$28(ActivityRecord finalParent, int[] resultCodeHolder, Intent[] resultDataHolder, NeededUriGrants[] resultGrantsHolder, ActivityRecord ar) {
        if (ar != finalParent) goto L5;
        return true;
    L5:
        ar.finishIfPossible(resultCodeHolder[0], resultDataHolder[0], resultGrantsHolder[0], "navigate-up", true);
        resultCodeHolder[0] = 0;
        resultDataHolder[0] = null;
        return false;
    }

    private void updateTransitLocked(int transit, ActivityOptions options) {
        if (options == null) goto L10;
        ActivityRecord r = topRunningActivity();
        if (r != null) goto L6;
    L8:
        ActivityOptions.abort(options);
        return;
    L6:
        if (r.isState(ActivityRecord.State.RESUMED) == true) goto L8;
        r.updateOptionsLocked(options);
        return;
    }

    final void moveTaskToFront(Task tr, boolean noAnimation, ActivityOptions options, AppTimeTracker timeTracker, String reason) {
        moveTaskToFront(tr, noAnimation, options, timeTracker, false, reason);
    }

    final void moveTaskToFront(Task tr, boolean noAnimation, ActivityOptions options, final AppTimeTracker timeTracker, boolean deferResume, String reason) {
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L5;
        Slog.v("ActivityTaskManager", "moveTaskToFront: " + tr);
    L5:
        ActivityRecord pipCandidate = findEnterPipOnTaskSwitchCandidate(getDisplayArea().getTopRootTask());
        if (tr != this) goto L8;
    L13:
        if (timeTracker == null) goto L41;
        tr.forAllActivities(new Task$$ExternalSyntheticLambda22(timeTracker));
    L41:
        this.mDisplayContent.deferUpdateImeTarget();     // Catch: Throwable -> L23
        ActivityRecord top = tr.getTopNonFinishingActivity();     // Catch: Throwable -> L23
        if (top == null) goto L33;
        if (top.showToCurrentUser() == false) goto L33;
        top.moveFocusableActivityToTop(reason);     // Catch: Throwable -> L23
        if (ActivityTaskManagerDebugConfig.DEBUG_TRANSITION == false) goto L25;
        Slog.v("ActivityTaskManager", "Prepare to front transition: task=" + tr);     // Catch: Throwable -> L23
    L25:
        if (noAnimation == false) goto L27;
        this.mTaskSupervisor.mNoAnimActivities.add(top);     // Catch: Throwable -> L23
        this.mTransitionController.collect(top);     // Catch: Throwable -> L23
        this.mTransitionController.setNoAnimation(top);     // Catch: Throwable -> L23
        ActivityOptions.abort(options);     // Catch: Throwable -> L23
    L28:
        enableEnterPipOnTaskSwitch(pipCandidate, tr, null, options);     // Catch: Throwable -> L23
        if (deferResume == true) goto L31;
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();     // Catch: Throwable -> L23
    L31:
        this.mDisplayContent.continueUpdateImeTarget();
        return;
    L27:
        updateTransitLocked(3, options);     // Catch: Throwable -> L23
    L33:
        positionChildAtTop(tr);     // Catch: Throwable -> L23
        if (top == null) goto L36;
        this.mTaskSupervisor.mRecentTasks.add(top.getTask());     // Catch: Throwable -> L23
    L36:
        ActivityOptions.abort(options);     // Catch: Throwable -> L23
        this.mDisplayContent.continueUpdateImeTarget();
        return;
    L23:
        th = move-exception;
        this.mDisplayContent.continueUpdateImeTarget();
        throw th;
    L8:
        if (tr.isDescendantOf(this) == true) goto L13;
        if (noAnimation == false) goto L11;
        ActivityOptions.abort(options);
        return;
    L11:
        updateTransitLocked(3, options);
    }

    private static /* synthetic */ void lambda$moveTaskToFront$29(AppTimeTracker timeTracker, ActivityRecord a) {
        a.appTimeTracker = timeTracker;
    }

    private boolean canMoveTaskToBack(final Task task) {
        if (task == this) goto L8;
        if (task.isDescendantOf(this) == true) goto L8;
        return false;
    L8:
        if (this.mAtmService.getLockTaskController().canMoveTaskToBack(task) == true) goto L11;
        return false;
    L11:
        if (this.mAtmService.mController != null) goto L13;
    L26:
        return true;
    L13:
        if (isTopRootTaskInDisplayArea() == false) goto L26;
        ActivityRecord next = getDisplayArea().getActivity(new Task$$ExternalSyntheticLambda0(task));
        if (next == null) goto L26;
        if (next.isState(ActivityRecord.State.RESUMED) == false) goto L19;
        return true;
    L19:
        boolean moveOK = true;
        moveOK = this.mAtmService.mController.activityResuming(next.packageName);     // Catch: RemoteException -> L22
    L24:
        if (moveOK == true) goto L26;
        return false;
    L23:
        this.mAtmService.mController = null;
        Watchdog.getInstance().setActivityController(null);
        goto L24
    }

    private static /* synthetic */ boolean lambda$canMoveTaskToBack$30(Task task, ActivityRecord a) {
        return isTopRunning(a, task.mTaskId, null);
    }

    boolean moveTaskToBack(final Task tr) {
        Slog.i("ActivityTaskManager", "moveTaskToBack: " + tr + ", callers=" + Debug.getCallers(5));
        if (canMoveTaskToBack(tr) == true) goto L6;
        return false;
    L6:
        if (ActivityTaskManagerDebugConfig.DEBUG_TRANSITION == false) goto L9;
        Slog.v("ActivityTaskManager", "Prepare to back transition: task=" + tr.mTaskId);
    L9:
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L20;
        Transition collecting = this.mTransitionController.getCollectingTransition();
        if (getExt().needReturnMoveTaskToBack(tr, collecting) == false) goto L14;
        Slog.d("ActivityTaskManager", "moveTaskToBack: already bottom task=" + tr);
        return false;
    L14:
        if (collecting != null) goto L16;
    L19:
        final Transition transition = new Transition(4, 0, this.mTransitionController, this.mWmService.mSyncEngine);
        this.mTransitionController.startCollectOrQueue(transition, new Task$$ExternalSyntheticLambda34(this, tr, transition));
    L21:
        return true;
    L16:
        if (collecting.mType != 1) goto L19;
        collecting.collect(tr);
        moveTaskToBackInner(tr, collecting);
        return true;
    L20:
        moveTaskToBackInner(tr, null);
        goto L21
    }

    private /* synthetic */ void lambda$moveTaskToBack$31(Task tr, Transition transition, boolean deferred) {
        if (tr.isAttached() == false) goto L10;
        if (deferred == true) goto L6;
    L8:
        this.mTransitionController.requestStartTransition(transition, tr, null, null);
        this.mTransitionController.collect(tr);
        moveTaskToBackInner(tr, transition);
        return;
    L6:
        if (canMoveTaskToBack(tr) == true) goto L8;
    L10:
        Slog.e("ActivityTaskManager", "Failed to move task to back after saying we could: " + tr.mTaskId);
        transition.abort();
    }

    private void moveTaskToBackInner(Task task, Transition transition) {
        Transition.ReadyCondition movedToBack = new Transition.ReadyCondition("moved-to-back", task);
        if (transition == null) goto L45;
        this.mAtmService.deferWindowLayout();
        transition.mReadyTracker.add(movedToBack);
    L45:
        moveToBack("moveTaskToBackInner", task);     // Catch: Throwable -> L14
        if (inPinnedWindowingMode() == false) goto L16;
        this.mTaskSupervisor.removeRootTask(this);     // Catch: Throwable -> L14
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L11;
        this.mAtmService.continueWindowLayout();
    L11:
        if (transition == null) goto L46;
        movedToBack.meet();
        return;
    L46:
        return;
    L16:
        Task topRootTask = null;
        this.mRootWindowContainer.ensureVisibilityAndConfig(null, this.mDisplayContent, false);     // Catch: Throwable -> L14
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L20;
        this.mAtmService.continueWindowLayout();
    L20:
        if (transition == null) goto L22;
        movedToBack.meet();
    L22:
        ActivityRecord topActivity = getDisplayArea().topRunningActivity();
        if (topActivity == null) goto L26;
        topRootTask = topActivity.getRootTask();
    L26:
        boolean forceResumeFocusedTask = false;
        if (Features.FEAT_QUICK_WIN == true) goto L29;
    L31:
        if (topRootTask == null) goto L37;
        if (topRootTask == this) goto L37;
        if (topActivity.isState(ActivityRecord.State.RESUMED) == false) goto L37;
        if (forceResumeFocusedTask == true) goto L37;
        this.mDisplayContent.executeAppTransition();
        this.mDisplayContent.setFocusedApp(topActivity);
        return;
    L37:
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();
        return;
    L29:
        if (getExt().resumeFocusedTasksTopActivities(topRootTask, task) == false) goto L31;
        forceResumeFocusedTask = true;
    L14:
        th = move-exception;
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L42;
        this.mAtmService.continueWindowLayout();
    L42:
        if (transition == null) goto L44;
        movedToBack.meet();
    L44:
        throw th;
    }

    boolean willActivityBeVisible(IBinder token) {
        ActivityRecord r = ActivityRecord.forTokenLocked(token);
        if (r != null) goto L6;
        return false;
    L6:
        if (r.shouldBeVisible() == true) goto L9;
        return false;
    L9:
        if (r.finishing == false) goto L12;
        Slog.e("ActivityTaskManager", "willActivityBeVisible: Returning false, would have returned true for r=" + r);
    L12:
        return !r.finishing;
    }

    void unhandledBackLocked() {
        ActivityRecord topActivity = getTopMostActivity();
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L5;
        Slog.d("ActivityTaskManager", "Performing unhandledBack(): top activity: " + topActivity);
    L5:
        if (topActivity == null) goto L8;
        topActivity.finishIfPossible("unhandled-back", true);
        return;
    }

    boolean dump(FileDescriptor fd, PrintWriter pw, boolean dumpAll, boolean dumpClient, String dumpPackage, boolean needSep) {
        return dump("  ", fd, pw, dumpAll, dumpClient, dumpPackage, needSep, null);
    }

    @Override // com.android.server.wm.TaskFragment
    void dumpInner(String prefix, PrintWriter pw, boolean dumpAll, String dumpPackage) {
        super.dumpInner(prefix, pw, dumpAll, dumpPackage);
        if (this.mCreatedByOrganizer == false) goto L10;
        pw.println(prefix + "  mCreatedByOrganizer=true");
        if (this.mOffsetXForInsets == 0) goto L7;
    L8:
        pw.println(prefix + "  mOffsetXForInsets=" + this.mOffsetXForInsets + " mOffsetYForInsets=" + this.mOffsetYForInsets);
        goto L10
    L7:
        if (this.mOffsetYForInsets != 0) goto L8;
    L10:
        if (this.mLastNonFullscreenBounds == null) goto L13;
        pw.print(prefix);
        pw.print("  mLastNonFullscreenBounds=");
        pw.println(this.mLastNonFullscreenBounds);
    L13:
        if (this.mNonOccludedFreeformAreaRatio == 0) goto L16;
        pw.print(prefix);
        pw.print("  mNonOccludedFreeformAreaRatio=");
        pw.println(this.mNonOccludedFreeformAreaRatio);
    L16:
        if (isLeafTask() == false) goto L23;
        pw.println(prefix + "  isSleeping=" + shouldSleepActivities());
        ActivityTaskSupervisor.printThisActivity(pw, getTopPausingActivity(), dumpPackage, false, prefix + "  topPausingActivity=", null);
        ActivityTaskSupervisor.printThisActivity(pw, getTopResumedActivity(), dumpPackage, false, prefix + "  topResumedActivity=", null);
        if (this.mMinWidth == (-1)) goto L20;
    L21:
        pw.print(prefix);
        pw.print("  mMinWidth=");
        pw.print(this.mMinWidth);
        pw.print(" mMinHeight=");
        pw.println(this.mMinHeight);
        return;
    L20:
        if (this.mMinHeight != (-1)) goto L21;
        return;
    }

    ArrayList<ActivityRecord> getDumpActivitiesLocked(String name, int userId) {
        final ArrayList<ActivityRecord> activities = new ArrayList();
        if (IZswContentProviderHelper.DUMP_ALL.equals(name) == false) goto L6;
        forAllActivities(new Task$$ExternalSyntheticLambda40(activities));
    L13:
        if (userId == (-1)) goto L20;
        int i = activities.size() - 1;
    L15:
        if (i < 0) goto L20;
        if (activities.get(i).mUserId == userId) goto L19;
        activities.remove(i);
    L19:
        i = i - 1;
    L20:
        return activities;
    L6:
        if ("top".equals(name) == false) goto L11;
        ActivityRecord topActivity = getTopMostActivity();
        if (topActivity == null) goto L13;
        activities.add(topActivity);
        goto L13
    L11:
        final ActivityManagerService.ItemMatcher matcher = new ActivityManagerService.ItemMatcher();
        matcher.build(name);
        forAllActivities(new Task$$ExternalSyntheticLambda41(matcher, activities));
        goto L13
    }

    private static /* synthetic */ void lambda$getDumpActivitiesLocked$32(ActivityManagerService.ItemMatcher matcher, ArrayList activities, ActivityRecord r) {
        if (matcher.match(r, r.intent.getComponent()) == false) goto L6;
        activities.add(r);
        return;
    }

    Task reuseOrCreateTask(ActivityInfo info, Intent intent, boolean toTop) {
        return reuseOrCreateTask(info, intent, null, null, toTop, null, null, null);
    }

    Task reuseOrCreateTask(ActivityInfo info, Intent intent, IVoiceInteractionSession voiceSession, IVoiceInteractor voiceInteractor, boolean toTop, ActivityRecord activity, ActivityRecord source, ActivityOptions options) {
        if (canReuseAsLeafTask() == false) goto L5;
        ActivityRecord r3 = activity;
        ActivityOptions r5 = options;
        Task task = reuseAsLeafTask(voiceSession, voiceInteractor, intent, info, activity);
    L10:
        this.mTaskSupervisor.getLaunchParamsController().layoutTask(task, info.windowLayout, r3, source, r5);
        return task;
    L5:
        r3 = activity;
        if (r3 == null) goto L8;
        int taskId = this.mTaskSupervisor.getNextTaskIdForUser(r3.mUserId);
    L9:
        r5 = options;
        task = Builder.m10212$$Nest$msetVoiceInteractor(new Builder(this.mAtmService).setTaskId(taskId).setActivityInfo(info).setActivityOptions(r5).setIntent(intent).setVoiceSession(voiceSession), voiceInteractor).setOnTop(toTop).setParent(this).build();
        goto L10
    L8:
        taskId = this.mTaskSupervisor.getNextTaskIdForUser();
        goto L9
    }

    private boolean canReuseAsLeafTask() {
        if (this.mCreatedByOrganizer == false) goto L5;
        return false;
    L5:
        if (isLeafTask() == false) goto L11;
        int windowingMode = getWindowingMode();
        int activityType = getActivityType();
        return DisplayContent.alwaysCreateRootTask(windowingMode, activityType);
    L11:
        return false;
    }

    void addChild(WindowContainer child, boolean toTop, boolean showForAllUsers) {
        Task task = child.asTask();
        if (task != null) goto L17;
    L7:
        if (toTop == false) goto L9;
        int r2 = Integer.MAX_VALUE;
    L10:
        addChild(child, r2, toTop);     // Catch: Throwable -> L5
        if (task == null) goto L19;
        task.setForceShowForAllUsers(false);
        return;
    L19:
        return;
    L5:
        th = move-exception;
        if (task == null) goto L16;
        task.setForceShowForAllUsers(false);
    L16:
        throw th;
    L9:
        r2 = 0;
        goto L10
    L17:
        task.setForceShowForAllUsers(showForAllUsers);     // Catch: Throwable -> L5
        goto L7
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public void setAlwaysOnTop(boolean alwaysOnTop) {
        if (super.isAlwaysOnTop() != alwaysOnTop) goto L5;
        return;
    L5:
        super.setAlwaysOnTop(alwaysOnTop);
        if (isForceHidden() == true) goto L9;
        getDisplayArea().positionChildAt(Integer.MAX_VALUE, this, false);
        return;
    }

    void dismissPip() {
        if (isActivityTypeStandardOrUndefined() == false) goto L14;
        if (getWindowingMode() != 2) goto L12;
        Task task = getBottomMostTask();
        setRootTaskWindowingMode(0);
        if (isAttached() == false) goto L9;
        getDisplayArea().positionChildAt(Integer.MAX_VALUE, this, false);
    L9:
        this.mTaskSupervisor.scheduleUpdatePictureInPictureModeIfNeeded(task, this);
        return;
    L12:
        throw new IllegalArgumentException("Can't exit pinned mode if it's not pinned already.");
    L14:
        throw new IllegalArgumentException("You can't move tasks from non-standard root tasks.");
    }

    private int setBounds(Rect existing, Rect bounds) {
        if (ConfigurationContainer.equivalentBounds(existing, bounds) == false) goto L7;
        return 0;
    L7:
        if (inMultiWindowMode() == true) goto L9;
        Rect r0 = null;
    L11:
        return setBoundsUnchecked(r0);
    L9:
        r0 = bounds;
        goto L11
    }

    private void addChild(WindowContainer child, int position, boolean moveParents) {
        addChild(child, null);
        positionChildAt(position, child, moveParents);
    }

    void positionChildAtTop(Task child) {
        if (child != null) goto L4;
        return;
    L4:
        if (child != this) goto L7;
        moveToFront("positionChildAtTop");
        return;
    L7:
        positionChildAt(Integer.MAX_VALUE, child, true);
    }

    void positionChildAtBottom(Task child) {
        boolean r2 = true;
        Task nextFocusableRootTask = getDisplayArea().getNextFocusableRootTask(child.getRootTask(), true);
        if (nextFocusableRootTask == null) goto L6;
        r2 = false;
    L6:
        positionChildAtBottom(child, r2);
    }

    void positionChildAtBottom(Task child, boolean includingParents) {
        if (child != null) goto L4;
        return;
    L4:
        positionChildAt(Integer.MIN_VALUE, child, includingParents);
    }

    @Override // com.android.server.wm.TaskFragment, com.android.server.wm.WindowContainer
    void onChildPositionChanged(WindowContainer child) {
        if (this.mChildren.contains(child) == true) goto L7;
        dispatchTaskInfoChangedIfNeeded(false);
        return;
    L7:
        if (child.asTask() == null) goto L10;
        this.mRootWindowContainer.invalidateTaskLayers();
    L10:
        if (child.asActivityRecord() == null) goto L12;
        sendTaskFragmentParentInfoChangedIfNeeded();
    L12:
        updateTaskDescription();
        dispatchTaskInfoChangedIfNeeded(false);
    }

    void reparent(TaskDisplayArea newParent, boolean onTop) {
        if (newParent == null) goto L16;
        if (getParent() == newParent) goto L14;
        if (canBeLaunchedOnDisplay(newParent.getDisplayId()) == false) goto L11;
        if (onTop == false) goto L9;
        int r0 = Integer.MAX_VALUE;
    L10:
        reparent(newParent, r0);
        newParent.onTaskMoved(this, onTop, !onTop);
        return;
    L9:
        r0 = Integer.MIN_VALUE;
        goto L10
    L11:
        Slog.w("ActivityTaskManager", "Task=" + this + " can't reparent to " + newParent);
        return;
    L14:
        throw new IllegalArgumentException("Task=" + this + " already child of " + newParent);
    L16:
        throw new IllegalArgumentException("Task can't reparent to null " + this);
    }

    void setLastRecentsAnimationTransaction(PictureInPictureSurfaceTransaction transaction, SurfaceControl overlay) {
        this.mLastRecentsAnimationTransaction = new PictureInPictureSurfaceTransaction(transaction);
        this.mLastRecentsAnimationOverlay = overlay;
    }

    void clearLastRecentsAnimationTransaction(boolean forceRemoveOverlay) {
        if (forceRemoveOverlay == true) goto L4;
    L6:
        this.mLastRecentsAnimationTransaction = null;
        this.mLastRecentsAnimationOverlay = null;
        resetSurfaceControlTransforms();
        return;
    L4:
        if (this.mLastRecentsAnimationOverlay == null) goto L6;
        getPendingTransaction().remove(this.mLastRecentsAnimationOverlay);
        goto L6
    }

    void resetSurfaceControlTransforms() {
        if (Features.FEAT_QUICK_WIN == true) goto L5;
    L7:
        getSyncTransaction().setMatrix(this.mSurfaceControl, Matrix.IDENTITY_MATRIX, new float[9]).setWindowCrop(this.mSurfaceControl, null).setShadowRadius(this.mSurfaceControl, 0.0f).setCornerRadius(this.mSurfaceControl, 0.0f);
        return;
    L5:
        if (inFreeformWindowingMode() == false) goto L7;
    }

    void maybeApplyLastRecentsAnimationTransaction() {
        if (this.mLastRecentsAnimationTransaction != null) goto L5;
        return;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[0] == false) goto L7;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, 1713325321956242576L, 0, null);
    L7:
        SurfaceControl.Transaction tx = getPendingTransaction();
        if (this.mLastRecentsAnimationOverlay == null) goto L10;
        tx.reparent(this.mLastRecentsAnimationOverlay, this.mSurfaceControl);
    L10:
        PictureInPictureSurfaceTransaction.apply(this.mLastRecentsAnimationTransaction, this.mSurfaceControl, tx);
        tx.show(this.mSurfaceControl);
        this.mLastRecentsAnimationTransaction = null;
        this.mLastRecentsAnimationOverlay = null;
    }

    private void updateSurfaceBounds() {
        updateSurfaceSize(getSyncTransaction());
        updateSurfacePositionNonOrganized();
        scheduleAnimation();
    }

    private Point getRelativePosition() {
        Point position = new Point();
        getRelativePosition(position);
        return position;
    }

    boolean shouldIgnoreInput() {
        if (this.mAtmService.mHasLeanbackFeature == true) goto L5;
        return false;
    L5:
        if (inPinnedWindowingMode() == true) goto L7;
        return false;
    L7:
        if (isFocusedRootTaskOnDisplay() == true) goto L13;
        return true;
    L13:
        return false;
    }

    private void warnForNonLeafTask(String func) {
        if (isLeafTask() == true) goto L6;
        Slog.w("ActivityTaskManager", func + " on non-leaf task " + this);
        return;
    }

    public DisplayInfo getDisplayInfo() {
        return this.mDisplayContent.getDisplayInfo();
    }

    public void onARStopTriggered(ActivityRecord r) {
        if (mQtiActivityPluginDelegate != null) goto L5;
        return;
    L5:
        if (getWindowingMode() == 0) goto L13;
        String r0 = r.info.applicationInfo.packageName;
        boolean r3 = true;
        if (getWindowingMode() == 1) goto L10;
        r3 = false;
    L10:
        ActivityPluginDelegate.activitySuspendNotification(r0, r3, false);
        return;
    }

    private Rect getRawBounds() {
        return super.getBounds();
    }

    void dispatchTaskInfoChangedIfNeeded(boolean force) {
        if (isOrganized() == false) goto L6;
        this.mAtmService.mTaskOrganizerController.onTaskInfoChanged(this, force);
        return;
    }

    void setReparentLeafTaskIfRelaunch(boolean reparentLeafTaskIfRelaunch) {
        if (isOrganized() == false) goto L6;
        this.mReparentLeafTaskIfRelaunch = reparentLeafTaskIfRelaunch;
        return;
    }

    void setTrimmableFromRecents(boolean isTrimmable) {
        this.mIsTrimmableFromRecents = isTrimmable;
    }

    void setLaunchAdjacentDisabled(boolean disabled) {
        this.mLaunchAdjacentDisabled = disabled;
    }

    boolean isLaunchAdjacentDisabled() {
        Task t = this;
    L3:
        if (t == null) goto L9;
        if (t.mLaunchAdjacentDisabled == true) goto L6;
        t = t.getParent().asTask();
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    boolean isSameRequiredDisplayCategory(ActivityInfo info) {
        if (this.mRequiredDisplayCategory == null) goto L7;
        if (this.mRequiredDisplayCategory.equals(info.requiredDisplayCategory) == false) goto L7;
    L10:
        return true;
    L7:
        if (this.mRequiredDisplayCategory == null) goto L9;
    L11:
        return false;
    L9:
        if (info.requiredDisplayCategory != null) goto L11;
        goto L10
    }

    @Override // com.android.server.wm.TaskFragment, com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public void dumpDebug(ProtoOutputStream proto, long fieldId, int logLevel) {
        if (logLevel == 2) goto L5;
    L7:
        long token = proto.start(fieldId);
        proto.write(1120986464258L, this.mTaskId);
        proto.write(1120986464272L, getRootTaskId());
        if (getTopResumedActivity() == null) goto L11;
        getTopResumedActivity().writeIdentifierToProto(proto, 1146756268044L);
    L11:
        if (this.realActivity == null) goto L14;
        proto.write(1138166333453L, this.realActivity.flattenToShortString());
    L14:
        if (this.origActivity == null) goto L16;
        proto.write(1138166333454L, this.origActivity.flattenToShortString());
    L16:
        proto.write(1120986464274L, this.mResizeMode);
        proto.write(1133871366148L, matchParentBounds());
        getRawBounds().dumpDebug(proto, 1146756268037L);
        if (this.mLastNonFullscreenBounds == null) goto L20;
        this.mLastNonFullscreenBounds.dumpDebug(proto, 1146756268054L);
    L20:
        if (this.mSurfaceControl == null) goto L22;
        proto.write(1120986464264L, this.mSurfaceControl.getWidth());
        proto.write(1120986464265L, this.mSurfaceControl.getHeight());
    L22:
        proto.write(1133871366172L, this.mCreatedByOrganizer);
        proto.write(1138166333469L, this.affinity);
        if (this.mChildPipActivity == null) goto L25;
        boolean r2 = true;
    L26:
        proto.write(1133871366174L, r2);
        super.dumpDebug(proto, 1146756268063L, logLevel);
        proto.end(token);
        return;
    L25:
        r2 = false;
        goto L26
    L5:
        if (isVisible() == true) goto L7;
    }

    @Override // com.android.server.wm.WindowContainer
    void updateOverlayInsetsState(WindowState originalChange) {
        super.updateOverlayInsetsState(originalChange);
        if (originalChange == getTopVisibleAppMainWindow()) goto L6;
        return;
    L6:
        if (this.mOverlayHost == null) goto L9;
        InsetsState s = originalChange.getInsetsState(true);
        getBounds(this.mTmpRect);
        this.mOverlayHost.dispatchInsetsChanged(s, this.mTmpRect);
        return;
    }

    ActivityRecord getBottomMostActivityInSamePackage() {
        if (this.realActivity != null) goto L7;
        return null;
    L7:
        return getActivity(new Task$$ExternalSyntheticLambda31(this), false);
    }

    private /* synthetic */ boolean lambda$getBottomMostActivityInSamePackage$33(ActivityRecord ar) {
        return ar.packageName.equals(this.realActivity.getPackageName());
    }

    void moveOrCreateDecorSurfaceFor(TaskFragment taskFragment, boolean visible) {
        if (this.mDecorSurfaceContainer == null) goto L5;
        this.mDecorSurfaceContainer.mOwnerTaskFragment = taskFragment;
        return;
    L5:
        this.mDecorSurfaceContainer = new DecorSurfaceContainer(this, taskFragment, visible, null);
        assignChildLayers();
        sendTaskFragmentParentInfoChangedIfNeeded();
    }

    void removeDecorSurface() {
        if (this.mDecorSurfaceContainer != null) goto L5;
        return;
    L5:
        DecorSurfaceContainer.m10216$$Nest$mrelease(this.mDecorSurfaceContainer);
        this.mDecorSurfaceContainer = null;
        sendTaskFragmentParentInfoChangedIfNeeded();
    }

    SurfaceControl getDecorSurface() {
        if (this.mDecorSurfaceContainer != null) goto L7;
        return null;
    L7:
        return this.mDecorSurfaceContainer.mDecorSurface;
    }

    void setDecorSurfaceVisible(SurfaceControl.Transaction t) {
        if (this.mDecorSurfaceContainer != null) goto L5;
        return;
    L5:
        t.show(this.mDecorSurfaceContainer.mDecorSurface);
    }

    public TaskSmtBase getTaskSmtBase() {
        return this.mTaskSmtBase;
    }

    public WindowProcessController getRootProcess() {
        return this.mRootProcess;
    }

    public IExtTask getExt() {
        return this.mExt;
    }

    @Override // com.android.server.wm.WindowContainer
    void getRelativePosition(Rect curBounds, Point outPos) {
        super.getRelativePosition(curBounds, outPos);
        Point position = getExt().getOffset();
        if (position == null) goto L6;
        outPos.offset(position.x, position.y);
        return;
    }
}
