package com.android.server.wm;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.IApplicationThread;
import android.app.IScreenCaptureObserver;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.ResultInfo;
import android.app.SysMonitorFwBridge;
import android.app.WindowConfiguration;
import android.app.assist.ActivityId;
import android.app.compat.CompatChanges;
import android.app.servertransaction.ActivityConfigurationChangeItem;
import android.app.servertransaction.ActivityLifecycleItem;
import android.app.servertransaction.ActivityRelaunchItem;
import android.app.servertransaction.ActivityResultItem;
import android.app.servertransaction.ClientTransactionItem;
import android.app.servertransaction.DestroyActivityItem;
import android.app.servertransaction.MoveToDisplayItem;
import android.app.servertransaction.NewIntentItem;
import android.app.servertransaction.PauseActivityItem;
import android.app.servertransaction.ResumeActivityItem;
import android.app.servertransaction.StartActivityItem;
import android.app.servertransaction.StopActivityItem;
import android.app.servertransaction.TopResumedActivityChangeItem;
import android.app.servertransaction.TransferSplashScreenViewStateItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.LocusId;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConstrainDisplayApisConfig;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.UserProperties;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.hardware.audio.common.V2_0.AudioChannelMask;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.FrozenObjectException;
import android.os.IBinder;
import android.os.IRemoteCallback;
import android.os.InputConstants;
import android.os.PersistableBundle;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.pico.utils.ExtImplFactory;
import android.pico.utils.Features;
import android.service.dreams.DreamActivity;
import android.service.voice.IVoiceInteractionSession;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.EventLog;
import android.util.Log;
import android.util.MergedConfiguration;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import android.view.DisplayInfo;
import android.view.InputApplicationHandle;
import android.view.RemoteAnimationAdapter;
import android.view.RemoteAnimationDefinition;
import android.view.SurfaceControl;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.window.ActivityWindowInfo;
import android.window.ITaskFragmentOrganizer;
import android.window.ITaskOrganizer;
import android.window.RemoteTransition;
import android.window.SizeConfigurationBuckets;
import android.window.SplashScreenView;
import android.window.TaskSnapshot;
import android.window.WindowContainerToken;
import android.window.WindowOnBackInvokedDispatcher;
import com.android.internal.app.ResolverActivity;
import com.android.internal.content.ReferrerIntent;
import com.android.internal.os.TimeoutRecord;
import com.android.internal.os.TransferPipe;
import com.android.internal.policy.PhoneWindow;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.ISmtResourceControl;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.am.AppTimeTracker;
import com.android.server.am.PendingIntentRecord;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.common.Constants;
import com.android.server.contentcapture.ContentCaptureManagerInternal;
import com.android.server.dispatcher.GameActivityStateEventDispatcher;
import com.android.server.display.color.ColorDisplayService;
import com.android.server.job.controllers.JobStatus;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.UserManagerInternal;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.uri.GrantUri;
import com.android.server.uri.NeededUriGrants;
import com.android.server.uri.UriPermissionOwner;
import com.google.android.collect.Sets;
import dalvik.annotation.optimization.NeverCompile;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.xmlpull.v1.XmlPullParserException;
import vendor.qti.hardware.servicetracker.V1_2.ActivityDetails;
import vendor.qti.hardware.servicetracker.V1_2.ActivityStats;
import vendor.qti.hardware.servicetracker.V1_2.IServicetracker;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityRecord extends WindowToken {
    static final String ACTIVITY_ICON_SUFFIX = "_activity_icon_";
    private static final String ATTR_COMPONENTSPECIFIED = "component_specified";
    private static final String ATTR_ID = "id";
    private static final String ATTR_LAUNCHEDFROMFEATURE = "launched_from_feature";
    private static final String ATTR_LAUNCHEDFROMPACKAGE = "launched_from_package";
    private static final String ATTR_LAUNCHEDFROMUID = "launched_from_uid";
    private static final String ATTR_RESOLVEDTYPE = "resolved_type";
    private static final String ATTR_USERID = "user_id";
    private static final HashSet<String> CAR_OWNER_APP = null;
    private static final int DESTROY_TIMEOUT = 10000;
    static final int FINISH_RESULT_CANCELLED = 0;
    static final int FINISH_RESULT_REMOVED = 2;
    static final int FINISH_RESULT_REQUESTED = 1;
    static final int INVALID_PID = -1;
    static final int LAUNCH_SOURCE_TYPE_APPLICATION = 4;
    static final int LAUNCH_SOURCE_TYPE_HOME = 2;
    static final int LAUNCH_SOURCE_TYPE_SYSTEM = 1;
    static final int LAUNCH_SOURCE_TYPE_SYSTEMUI = 3;
    private static final int MAX_STOPPING_TO_FORCE = 3;
    private static final int PAUSE_TIMEOUT = 500;
    private static final int SHOW_STARTING_WINDOW_TIMEOUT_HAS_PROCESS = 10000;
    private static final int SPLASH_SCREEN_BEHAVIOR_DEFAULT = 0;
    private static final int SPLASH_SCREEN_BEHAVIOR_ICON_PREFERRED = 1;
    static final int STARTING_WINDOW_TYPE_NONE = 0;
    static final int STARTING_WINDOW_TYPE_SNAPSHOT = 1;
    static final int STARTING_WINDOW_TYPE_SPLASH_SCREEN = 2;
    private static final int STOP_TIMEOUT = 11000;
    private static final String TAG = "ActivityTaskManager";
    private static final String TAG_ADD_REMOVE = "ActivityTaskManager";
    private static final String TAG_APP = "ActivityTaskManager";
    private static final String TAG_CONFIGURATION = "ActivityTaskManager";
    private static final String TAG_CONTAINERS = "ActivityTaskManager";
    private static final String TAG_FOCUS = "ActivityTaskManager";
    private static final String TAG_INITIAL_CALLER_INFO = "initial_caller_info";
    private static final String TAG_INTENT = "intent";
    private static final String TAG_PAUSE = "ActivityTaskManager";
    private static final String TAG_PERSISTABLEBUNDLE = "persistable_bundle";
    private static final String TAG_RESULTS = "ActivityTaskManager";
    private static final String TAG_SAVED_STATE = "ActivityTaskManager";
    private static final String TAG_STATES = "ActivityTaskManager";
    private static final String TAG_SWITCH = "ActivityTaskManager";
    private static final String TAG_TRANSITION = "ActivityTaskManager";
    private static final String TAG_USER_LEAVING = "ActivityTaskManager";
    private static final String TAG_VISIBILITY = "ActivityTaskManager";
    static final int TRANSFER_SPLASH_SCREEN_ATTACH_TO_CLIENT = 2;
    static final int TRANSFER_SPLASH_SCREEN_COPYING = 1;
    static final int TRANSFER_SPLASH_SCREEN_FINISH = 3;
    static final int TRANSFER_SPLASH_SCREEN_IDLE = 0;
    private static final int TRANSFER_SPLASH_SCREEN_TIMEOUT = 2000;
    private static ConstrainDisplayApisConfig sConstrainDisplayApisConfig;
    boolean allDrawn;
    WindowProcessController app;
    AppTimeTracker appTimeTracker;
    final Binder assistToken;
    WindowProcessController callerApp;
    private final boolean componentSpecified;
    private long createTime;
    boolean delayedResume;
    boolean finishing;
    private boolean firstTime;
    boolean firstWindowDrawn;
    boolean hasBeenLaunched;
    boolean idle;
    boolean immersive;
    volatile boolean inHistory;
    final ActivityInfo info;
    final IBinder initialCallerInfoAccessToken;
    final Intent intent;
    private final boolean isLowRamDevice;
    private boolean keysPaused;
    long lastLaunchTime;
    long lastVisibleTime;
    int launchCount;
    boolean launchFailed;
    int launchMode;
    final String launchedFromFeatureId;
    final String launchedFromPackage;
    final int launchedFromPid;
    final int launchedFromUid;
    public boolean launching;
    int lockTaskLaunchMode;
    public final ComponentName mActivityComponent;
    final ActivityRecordInputSink mActivityRecordInputSink;
    boolean mActivityRecordInputSinkEnabled;
    private final ActivityRecordMonitorEx mActivityRecordMonitorEx;
    boolean mAllowCrossUidActivitySwitchFromBelow;
    private final boolean mAllowUntrustedEmbeddingStateSharing;
    int mAllowedTouchUid;
    private final boolean mAppActivityEmbeddingSplitsEnabled;
    final AppCompatController mAppCompatController;
    boolean mAppStopped;
    final ActivityTaskManagerService mAtmService;
    boolean mAutoEnteringPip;
    final ActivityCallerState mCallerState;
    private RemoteCallbackList<IScreenCaptureObserver> mCaptureCallbacks;
    boolean mClientVisibilityDeferred;
    private final ColorDisplayService.ColorTransformController mColorTransformController;
    private int mConfigurationSeq;
    private boolean mCurrentLaunchCanTurnScreenOn;
    private CustomAppTransition mCustomCloseTransition;
    private CustomAppTransition mCustomOpenTransition;
    private boolean mDeferHidingClient;
    private final Runnable mDestroyTimeoutRunnable;
    boolean mDismissKeyguardIfInsecure;
    boolean mEnableRecentsScreenshot;
    boolean mEnteringAnimation;
    private IExtActivityRecord mExt;
    private boolean mForceSendResultForMediaProjection;
    boolean mHandleExitSplashScreen;
    int mHandoverLaunchDisplayId;
    TaskDisplayArea mHandoverTaskDisplayArea;
    private Boolean mHasDeskResources;
    final boolean mHasSceneTransition;
    private boolean mHaveState;
    private Bundle mIcicle;
    private boolean mInheritShownWhenLocked;
    private InputApplicationHandle mInputApplicationHandle;
    long mInputDispatchingTimeoutMillis;
    private boolean mIsInputDroppedForAnimation;
    private boolean mIsOnCarDisplay;
    private final boolean mIsUserAlwaysVisible;
    boolean mLastAllReadyAtSync;
    private AppSaturationInfo mLastAppSaturationInfo;
    private boolean mLastContainsDismissKeyguardWindow;
    private boolean mLastContainsShowWhenLockedWindow;
    private boolean mLastContainsTurnScreenOnWindow;
    private boolean mLastDeferHidingClient;
    private int mLastDropInputMode;
    private IBinder mLastEmbeddedParentTfTokenBeforePip;
    boolean mLastImeShown;
    Intent mLastNewIntent;
    private Task mLastParentBeforePip;
    private final ActivityWindowInfo mLastReportedActivityWindowInfo;
    private final MergedConfiguration mLastReportedConfiguration;
    private int mLastReportedDisplayId;
    private String mLastReportedDisplayName;
    boolean mLastReportedMultiWindowMode;
    boolean mLastReportedPictureInPictureMode;
    int mLastReportedProcState;
    boolean mLastSurfaceShowing;
    ITaskFragmentOrganizer mLastTaskFragmentOrganizerBeforePip;
    private long mLastTransactionSequence;
    IBinder mLaunchCookie;
    private ActivityRecord mLaunchIntoPipHostActivity;
    WindowContainerToken mLaunchRootTask;
    int mLaunchSourceType;
    private boolean mLaunchedFromBubble;
    private LocusId mLocusId;
    private boolean mNoDisplay;
    private int mNumDrawnWindows;
    private int mNumInterestingWindows;
    private boolean mOccludesParent;
    final boolean mOptInOnBackInvoked;
    final boolean mOptOutEdgeToEdge;
    boolean mOverrideTaskTransition;
    int mPauseConfigurationDispatchCount;
    boolean mPauseSchedulePendingForPip;
    private final Runnable mPauseTimeoutRunnable;
    private ActivityOptions mPendingOptions;
    int mPendingRelaunchCount;
    RemoteAnimationAdapter mPendingRemoteAnimation;
    private RemoteTransition mPendingRemoteTransition;
    public BoostFramework mPerf;
    private int mPerfScenarioBoostHandler;
    public BoostFramework mPerf_iop;
    private PersistableBundle mPersistentState;
    int mRelaunchReason;
    long mRelaunchStartTime;
    private RemoteAnimationDefinition mRemoteAnimationDefinition;
    private final Runnable mRemoveStartWindowTimeoutRunnable;
    private boolean mRemovingFromDisplay;
    private boolean mReportedDrawn;
    private final WindowState.UpdateReportedVisibilityResults mReportedVisibilityResults;
    public long mRequestOpenInBrowserEducationTimestamp;
    IBinder mRequestedLaunchingTaskFragmentToken;
    final TaskFragment.ConfigOverrideHint mResolveConfigHint;
    final RootWindowContainer mRootWindowContainer;
    int mRotationAnimationHint;
    ActivityServiceConnectionsHolder mServiceConnectionsHolder;
    boolean mShareIdentity;
    final boolean mShowForAllUsers;
    private boolean mShowWhenLocked;
    private SizeConfigurationBuckets mSizeConfigurations;
    boolean mSplashScreenStyleSolidColor;
    StartingData mStartingData;
    StartingSurfaceController.StartingSurface mStartingSurface;
    WindowState mStartingWindow;
    State mState;
    private final Runnable mStopTimeoutRunnable;
    long mStoppedTime;
    final boolean mStyleFillsParent;
    int mTargetSdk;
    private boolean mTaskOverlay;
    final ActivityTaskSupervisor mTaskSupervisor;
    private final ActivityWindowInfo mTmpActivityWindowInfo;
    private final Rect mTmpBounds;
    private final Configuration mTmpConfig;
    private final Runnable mTransferSplashScreenTimeoutRunnable;
    int mTransferringSplashScreenState;
    int mTransitionChangeFlags;
    private boolean mTurnScreenOn;
    public final int mUserId;
    private boolean mVisible;
    volatile boolean mVisibleForServiceConnection;
    private boolean mVisibleSetFromTransferredStartingWindow;
    boolean mVoiceInteraction;
    boolean mWaitForEnteringPinnedMode;
    private boolean mWillCloseOrEnterPip;
    final WindowStyle mWindowStyle;
    ArrayList<ReferrerIntent> newIntents;
    boolean nowVisible;
    public final String packageName;
    long pauseTime;
    HashSet<WeakReference<PendingIntentRecord>> pendingResults;
    boolean pendingVoiceInteractionStart;
    public int perfActivityBoostHandler;
    PictureInPictureParams pictureInPictureArgs;
    final String processName;
    boolean reportedVisible;
    final int requestCode;
    ComponentName requestedVrComponent;
    final String resolvedType;
    ActivityRecord resultTo;
    final String resultWho;
    ArrayList<ResultInfo> results;
    ActivityOptions returningOptions;
    final boolean rootVoiceInteraction;
    final Binder shareableActivityToken;
    public final String shortComponentName;
    boolean shouldDockBigOverlays;
    boolean startingMoved;
    final boolean stateNotNeeded;
    boolean supportsEnterPipOnTaskSwitch;
    private Task task;
    final String taskAffinity;
    ActivityManager.TaskDescription taskDescription;
    private final int theme;
    long topResumedStateLossTime;
    public boolean translucentWindowLaunch;
    UriPermissionOwner uriPermissions;
    boolean visibleIgnoringKeyguard;
    IVoiceInteractionSession voiceSession;

    private static class AppSaturationInfo {
        float[] mMatrix;
        float[] mTranslation;

        /* synthetic */ AppSaturationInfo(ActivityRecordIA r1) {
            this();
        }

        private AppSaturationInfo() {
            this.mMatrix = new float[9];
            this.mTranslation = new float[3];
        }

        void setSaturation(float[] matrix, float[] translation) {
            System.arraycopy(matrix, 0, this.mMatrix, 0, this.mMatrix.length);
            System.arraycopy(translation, 0, this.mTranslation, 0, this.mTranslation.length);
        }
    }

    static class Builder {
        private ActivityInfo mActivityInfo;
        private final ActivityTaskManagerService mAtmService;
        private WindowProcessController mCallerApp;
        private boolean mComponentSpecified;
        private Configuration mConfiguration;
        private long mCreateTime;
        private Intent mIntent;
        private String mLaunchedFromFeature;
        private String mLaunchedFromPackage;
        private int mLaunchedFromPid;
        private int mLaunchedFromUid;
        private ActivityOptions mOptions;
        private PersistableBundle mPersistentState;
        private int mRequestCode;
        private String mResolvedType;
        private ActivityRecord mResultTo;
        private String mResultWho;
        private boolean mRootVoiceInteraction;
        private ActivityRecord mSourceRecord;
        private ActivityManager.TaskDescription mTaskDescription;

        /* JADX INFO: renamed from: -$$Nest$msetCreateTime, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m9643$$Nest$msetCreateTime(Builder r0, long r1) {
            return r0.setCreateTime(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetPersistentState, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m9644$$Nest$msetPersistentState(Builder r0, PersistableBundle r1) {
            return r0.setPersistentState(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetTaskDescription, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m9645$$Nest$msetTaskDescription(Builder r0, ActivityManager.TaskDescription r1) {
            return r0.setTaskDescription(r1);
        }

        Builder(ActivityTaskManagerService service) {
            this.mAtmService = service;
        }

        Builder setCaller(WindowProcessController caller) {
            this.mCallerApp = caller;
            return this;
        }

        Builder setLaunchedFromPid(int pid) {
            this.mLaunchedFromPid = pid;
            return this;
        }

        Builder setLaunchedFromUid(int uid) {
            this.mLaunchedFromUid = uid;
            return this;
        }

        Builder setLaunchedFromPackage(String fromPackage) {
            this.mLaunchedFromPackage = fromPackage;
            return this;
        }

        Builder setLaunchedFromFeature(String fromFeature) {
            this.mLaunchedFromFeature = fromFeature;
            return this;
        }

        Builder setIntent(Intent intent) {
            this.mIntent = intent;
            return this;
        }

        Builder setResolvedType(String resolvedType) {
            this.mResolvedType = resolvedType;
            return this;
        }

        Builder setActivityInfo(ActivityInfo activityInfo) {
            this.mActivityInfo = activityInfo;
            return this;
        }

        Builder setResultTo(ActivityRecord resultTo) {
            this.mResultTo = resultTo;
            return this;
        }

        Builder setResultWho(String resultWho) {
            this.mResultWho = resultWho;
            return this;
        }

        Builder setRequestCode(int reqCode) {
            this.mRequestCode = reqCode;
            return this;
        }

        Builder setComponentSpecified(boolean componentSpecified) {
            this.mComponentSpecified = componentSpecified;
            return this;
        }

        Builder setRootVoiceInteraction(boolean rootVoiceInteraction) {
            this.mRootVoiceInteraction = rootVoiceInteraction;
            return this;
        }

        Builder setActivityOptions(ActivityOptions options) {
            this.mOptions = options;
            return this;
        }

        Builder setConfiguration(Configuration config) {
            this.mConfiguration = config;
            return this;
        }

        Builder setSourceRecord(ActivityRecord source) {
            this.mSourceRecord = source;
            return this;
        }

        private Builder setPersistentState(PersistableBundle persistentState) {
            this.mPersistentState = persistentState;
            return this;
        }

        private Builder setTaskDescription(ActivityManager.TaskDescription taskDescription) {
            this.mTaskDescription = taskDescription;
            return this;
        }

        private Builder setCreateTime(long createTime) {
            this.mCreateTime = createTime;
            return this;
        }

        ActivityRecord build() {
            if (this.mConfiguration != null) goto L6;
            this.mConfiguration = this.mAtmService.getConfiguration();
        L6:
            return new ActivityRecord(this.mAtmService, this.mCallerApp, this.mLaunchedFromPid, this.mLaunchedFromUid, this.mLaunchedFromPackage, this.mLaunchedFromFeature, this.mIntent, this.mResolvedType, this.mActivityInfo, this.mConfiguration, this.mResultTo, this.mResultWho, this.mRequestCode, this.mComponentSpecified, this.mRootVoiceInteraction, this.mAtmService.mTaskSupervisor, this.mOptions, this.mSourceRecord, this.mPersistentState, this.mTaskDescription, this.mCreateTime, null);
        }
    }

    static class CustomAppTransition {
        int mBackgroundColor;
        int mEnterAnim;
        int mExitAnim;

        CustomAppTransition() {
        }
    }

    @interface FinishRequest {
    }

    @interface LaunchSourceType {
    }

    @interface SplashScreenBehavior {
    }

    static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State DESTROYED = null;
        public static final State DESTROYING = null;
        public static final State FINISHING = null;
        public static final State INITIALIZING = null;
        public static final State PAUSED = null;
        public static final State PAUSING = null;
        public static final State RESTARTING_PROCESS = null;
        public static final State RESUMED = null;
        public static final State STARTED = null;
        public static final State STOPPED = null;
        public static final State STOPPING = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{INITIALIZING, STARTED, RESUMED, PAUSING, PAUSED, STOPPING, STOPPED, FINISHING, DESTROYING, DESTROYED, RESTARTING_PROCESS};
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String name) {
            return (State) Enum.valueOf(State.class, name);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            INITIALIZING = new State("INITIALIZING", 0);
            STARTED = new State("STARTED", 1);
            RESUMED = new State("RESUMED", 2);
            PAUSING = new State("PAUSING", 3);
            PAUSED = new State("PAUSED", 4);
            STOPPING = new State("STOPPING", 5);
            STOPPED = new State("STOPPED", 6);
            FINISHING = new State("FINISHING", 7);
            DESTROYING = new State("DESTROYING", 8);
            DESTROYED = new State("DESTROYED", 9);
            RESTARTING_PROCESS = new State("RESTARTING_PROCESS", 10);
            $VALUES = $values();
        }
    }

    private static class Token extends Binder {
        WeakReference<ActivityRecord> mActivityRef;

        /* synthetic */ Token(ActivityRecordIA r1) {
            this();
        }

        private Token() {
        }

        public String toString() {
            return "Token{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.mActivityRef.get() + "}";
        }
    }

    @interface TransferSplashScreenState {
    }

    public static class WindowStyle {
        private static final int FLAG_DISABLE_PREVIEW = 16;
        private static final int FLAG_IS_FLOATING = 2;
        private static final int FLAG_IS_TRANSLUCENT = 1;
        private static final int FLAG_NO_DISPLAY = 8;
        private static final int FLAG_OPT_OUT_EDGE_TO_EDGE = 32;
        private static final int FLAG_SHOW_WALLPAPER = 4;
        final int mFlags;
        final int mSplashScreenBehavior;

        public WindowStyle(TypedArray array) {
            int flags = 0;
            if (array.getBoolean(5, false) == false) goto L6;
            flags = 0 | 1;
        L6:
            if (array.getBoolean(4, false) == false) goto L9;
            flags = flags | 2;
        L9:
            if (array.getBoolean(14, false) == false) goto L12;
            flags = flags | 4;
        L12:
            if (array.getBoolean(10, false) == false) goto L15;
            flags = flags | 8;
        L15:
            if (array.getBoolean(12, false) == false) goto L18;
            flags = flags | 16;
        L18:
            if (array.getBoolean(64, false) == false) goto L20;
            flags = flags | 32;
        L20:
            this.mFlags = flags;
            this.mSplashScreenBehavior = array.getInt(62, 0);
        }

        boolean isTranslucent() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        boolean isFloating() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean showWallpaper() {
            if ((this.mFlags & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean noDisplay() {
            if ((this.mFlags & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean disablePreview() {
            if ((this.mFlags & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean optOutEdgeToEdge() {
            if ((this.mFlags & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static /* synthetic */ boolean $r8$lambda$0VlIB6dWpmd51rPHL9C7MBKVwyE(ActivityRecord r0) {
        return lambda$getSharedStartingWindowOwnerIfTaskDrawn$11(r0);
    }

    public static /* synthetic */ double $r8$lambda$6MLroGz7a6RoDyGfRCtQtFg6Itc(ActivityRecord r2) {
        return r2.lambda$getCompatScale$15();
    }

    /* JADX INFO: renamed from: $r8$lambda$8vzlXLXENSm-68EHSBTLK8LWcTs, reason: not valid java name */
    public static /* synthetic */ boolean m9634$r8$lambda$8vzlXLXENSm68EHSBTLK8LWcTs(WindowState r0) {
        return lambda$canCaptureSnapshot$21(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$AwDQJ0dWZB8EALcNOmrdnJC8KZg(ActivityRecord r0, ActivityRecord r1) {
        return r0.lambda$hasOverlayOverUntrustedModeEmbedded$12(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$F8rMEjORzhUqv_MA_mCPwKntOyU(ActivityRecord r0) {
        return lambda$getSharedStartingWindowOwnerIfTaskDrawn$10(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$I1MSNY3CpU-e9WIQbLSkEsRUKEo, reason: not valid java name */
    public static /* synthetic */ boolean m9635$r8$lambda$I1MSNY3CpUe9WIQbLSkEsRUKEo(ActivityRecord r0, ActivityRecord r1) {
        return r0.lambda$transferStartingWindowFromHiddenAboveTokenIfNeeded$8(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$ItiBm5jcgD93hwA9ZFF48DkeNNc(ActivityRecord r0, ActivityRecord r1) {
        return r0.lambda$showStartingWindow$14(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$LtBMHQ7y8EQyUReiUIpBLrEBq_E(ActivityRecord r0) {
        return lambda$isSyncFinished$20(r0);
    }

    public static /* synthetic */ void $r8$lambda$MmiU0ssFHcqkng4bff7C5gjnYg0(ActivityRecord r0, Transition r1, boolean r2) {
        r0.lambda$restartProcessIfVisible$18(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$QNnqNDOZVE6AP9I2X8M_B8nQ_eI(ActivityRecord r0, ActivityRecord r1) {
        return r0.lambda$showStartingWindow$13(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Qf3yk0-HxIT9YAOC4KQtjKp5xM4, reason: not valid java name */
    public static /* synthetic */ boolean m9636$r8$lambda$Qf3yk0HxIT9YAOC4KQtjKp5xM4(Task r0) {
        return lambda$moveFocusableActivityToTop$4(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$UJ5D2OOfhN-KEnlK9AAYgyz-n3k, reason: not valid java name */
    public static /* synthetic */ boolean m9637$r8$lambda$UJ5D2OOfhNKEnlK9AAYgyzn3k(ActivityRecord r0, ActivityRecord r1) {
        return r0.lambda$makeFinishingLocked$7(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$aRDRNHdMF8x1-2k17vph61zjg3E, reason: not valid java name */
    public static /* synthetic */ void m9638$r8$lambda$aRDRNHdMF8x12k17vph61zjg3E(ActivityRecord r0) {
        lambda$finishIfPossible$6(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$fiaHX1R5zEFOeBlayAWb7sCNc1g(ActivityRecord r0, TaskDisplayArea r1) {
        return r0.lambda$isFocusedActivityOnDisplay$19(r1);
    }

    public static /* synthetic */ ApplicationInfo $r8$lambda$frIx42sGzixNFx4Rzg2c_xr985E(ActivityRecord r0) {
        return r0.lambda$addStartingWindow$3();
    }

    /* JADX INFO: renamed from: $r8$lambda$lM2_1C0rnc1UeOTpuhc1P-YSvVE, reason: not valid java name */
    public static /* synthetic */ void m9639$r8$lambda$lM2_1C0rnc1UeOTpuhc1PYSvVE(ActivityRecord r0, ActivityRecord r1, int r2, Intent r3, IBinder r4, NeededUriGrants r5) {
        r0.lambda$finishActivityResults$5(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$mvh_TWvv9KONkby139QVs32900g(ActivityRecord r0, float[] r1, float[] r2) {
        r0.lambda$new$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ojyNV75jmuyW9udUqCk5aov_tdI(ActivityRecord r0) {
        r0.lambda$restartProcessIfVisible$17();
    }

    public static /* synthetic */ void $r8$lambda$sGNMRQzVLwLnwOXuaISLbjk7guI(ActivityRecord r0) {
        r0.notifyActivityStartedToContentCaptureService();
    }

    public static /* synthetic */ Context $r8$lambda$tbbQczlHwYJa84Bl3WvoMl7sYRg(ActivityRecord r0) {
        return r0.lambda$new$2();
    }

    public static /* synthetic */ Rect $r8$lambda$uLNDSLBHeJbrC6FAFN5LQ5VaDpo(AppCompatSizeCompatModePolicy r0, Rect r1) {
        return lambda$getBounds$16(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ycM7wHZ0aNceb80D__M1ooSygCQ(ActivityRecord r0, float[] r1, float[] r2) {
        r0.lambda$new$0(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$zx_qTZ1Z-SruvSJ2Y7Yph1kQWb8, reason: not valid java name */
    public static /* synthetic */ boolean m9640$r8$lambda$zx_qTZ1ZSruvSJ2Y7Yph1kQWb8(TaskFragment r0) {
        return lambda$canShowWhenLocked$9(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVisible, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9641$$Nest$fgetmVisible(ActivityRecord r0) {
        return r0.mVisible;
    }

    /* JADX INFO: renamed from: -$$Nest$misTransferringSplashScreen, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9642$$Nest$misTransferringSplashScreen(ActivityRecord r0) {
        return r0.isTransferringSplashScreen();
    }

    /* synthetic */ ActivityRecord(ActivityTaskManagerService r1, WindowProcessController r2, int r3, int r4, String r5, String r6, Intent r7, String r8, ActivityInfo r9, Configuration r10, ActivityRecord r11, String r12, int r13, boolean r14, boolean r15, ActivityTaskSupervisor r16, ActivityOptions r17, ActivityRecord r18, PersistableBundle r19, ActivityManager.TaskDescription r20, long r21, ActivityRecordIA r23) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    static /* synthetic */ float access$001(ActivityRecord x0) {
        return super.getCompatScale();
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
        dispatchConfigurationToChild((WindowState) r1, r2);
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
    /* bridge */ /* synthetic */ DisplayArea getDisplayArea() {
        return getDisplayArea();
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

    @Override // com.android.server.wm.WindowToken
    public /* bridge */ /* synthetic */ WindowTokenSysEx getWindowTokenSysEx() {
        return super.getWindowTokenSysEx();
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
    public /* bridge */ /* synthetic */ void onRequestedOverrideConfigurationChanged(Configuration r1) {
        super.onRequestedOverrideConfigurationChanged(r1);
    }

    @Override // com.android.server.wm.WindowContainer
    /* bridge */ /* synthetic */ void removeChild(WindowContainer r1) {
        removeChild((WindowState) r1);
    }

    private /* synthetic */ void lambda$new$1(final float[] matrix, final float[] translation) {
        this.mWmService.mH.post(new ActivityRecord$$ExternalSyntheticLambda1(this, matrix, translation));
    }

    private /* synthetic */ void lambda$new$0(float[] matrix, float[] translation) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mLastAppSaturationInfo != null) goto L9;
        this.mLastAppSaturationInfo = new AppSaturationInfo(null);     // Catch: Throwable -> L7
    L9:
        this.mLastAppSaturationInfo.setSaturation(matrix, translation);     // Catch: Throwable -> L7
        updateColorTransform();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    static {
        CAR_OWNER_APP = new HashSet(Arrays.asList(new String[]{"com.zte.carmateservice", "com.zte.car.launcher"}));
    }

    @Override // com.android.server.wm.WindowToken, com.android.server.wm.WindowContainer
    @NeverCompile
    void dump(PrintWriter pw, String prefix, boolean dumpAll) {
        long now = SystemClock.uptimeMillis();
        pw.print(prefix);
        pw.print("packageName=");
        pw.print(this.packageName);
        pw.print(" processName=");
        pw.println(this.processName);
        pw.print(prefix);
        pw.print("launchedFromUid=");
        pw.print(this.launchedFromUid);
        pw.print(" launchedFromPackage=");
        pw.print(this.launchedFromPackage);
        pw.print(" launchedFromFeature=");
        pw.print(this.launchedFromFeatureId);
        pw.print(" userId=");
        pw.println(this.mUserId);
        pw.print(prefix);
        pw.print("app=");
        pw.println(this.app);
        pw.print(prefix);
        pw.println(this.intent.toInsecureString());
        pw.print(prefix);
        pw.print("rootOfTask=");
        pw.print(isRootOfTask());
        pw.print(" task=");
        pw.println(this.task);
        pw.print(prefix);
        pw.print("taskAffinity=");
        pw.println(this.taskAffinity);
        pw.print(prefix);
        pw.print("mActivityComponent=");
        pw.println(this.mActivityComponent.flattenToShortString());
        ApplicationInfo appInfo = this.info.applicationInfo;
        pw.print(prefix);
        pw.print("baseDir=");
        pw.println(appInfo.sourceDir);
        if (Objects.equals(appInfo.sourceDir, appInfo.publicSourceDir) == true) goto L5;
        pw.print(prefix);
        pw.print("resDir=");
        pw.println(appInfo.publicSourceDir);
    L5:
        pw.print(prefix);
        pw.print("dataDir=");
        pw.println(appInfo.dataDir);
        if (appInfo.splitSourceDirs == null) goto L8;
        pw.print(prefix);
        pw.print("splitDir=");
        pw.println(Arrays.toString(appInfo.splitSourceDirs));
    L8:
        pw.print(prefix);
        pw.print("stateNotNeeded=");
        pw.print(this.stateNotNeeded);
        pw.print(" componentSpecified=");
        pw.print(this.componentSpecified);
        pw.print(" mActivityType=");
        pw.println(WindowConfiguration.activityTypeToString(getActivityType()));
        if (this.rootVoiceInteraction == false) goto L11;
        pw.print(prefix);
        pw.print("rootVoiceInteraction=");
        pw.println(this.rootVoiceInteraction);
    L11:
        pw.print(prefix);
        pw.print("compat=");
        pw.print(this.mAtmService.compatibilityInfoForPackageLocked(this.info.applicationInfo));
        pw.print(" theme=0x");
        pw.println(Integer.toHexString(this.theme));
        pw.println(prefix + "mLastReportedConfigurations:");
        this.mLastReportedConfiguration.dump(pw, prefix + "  ");
        pw.print(prefix);
        pw.print("mLastReportedActivityWindowInfo=");
        pw.println(this.mLastReportedActivityWindowInfo);
        pw.print(prefix);
        pw.print("CurrentConfiguration=");
        pw.println(getConfiguration());
        if (getRequestedOverrideConfiguration().equals(Configuration.EMPTY) == true) goto L15;
        pw.println(prefix + "RequestedOverrideConfiguration=" + getRequestedOverrideConfiguration());
    L15:
        if (getResolvedOverrideConfiguration().equals(getRequestedOverrideConfiguration()) == true) goto L18;
        pw.println(prefix + "ResolvedOverrideConfiguration=" + getResolvedOverrideConfiguration());
    L18:
        if (matchParentBounds() == true) goto L21;
        pw.println(prefix + "bounds=" + getBounds());
    L21:
        if (this.resultTo == null) goto L23;
    L24:
        pw.print(prefix);
        pw.print("resultTo=");
        pw.print(this.resultTo);
        pw.print(" resultWho=");
        pw.print(this.resultWho);
        pw.print(" resultCode=");
        pw.println(this.requestCode);
    L26:
        if (this.taskDescription == null) goto L39;
        String iconFilename = this.taskDescription.getIconFilename();
        if (iconFilename == null) goto L30;
    L33:
        pw.print(prefix);
        pw.print("taskDescription:");
        pw.print(" label=\"");
        pw.print(this.taskDescription.getLabel());
        pw.print("\"");
        pw.print(" icon=");
        if (this.taskDescription.getInMemoryIcon() == null) goto L36;
        String r5 = this.taskDescription.getInMemoryIcon().getByteCount() + " bytes";
    L37:
        pw.print(r5);
        pw.print(" iconResource=");
        pw.print(this.taskDescription.getIconResourcePackage());
        pw.print(SliceClientPermissions.SliceAuthority.DELIMITER);
        pw.print(this.taskDescription.getIconResource());
        pw.print(" iconFilename=");
        pw.print(this.taskDescription.getIconFilename());
        pw.print(" primaryColor=");
        pw.println(Integer.toHexString(this.taskDescription.getPrimaryColor()));
        pw.print(prefix);
        pw.print("  backgroundColor=");
        pw.print(Integer.toHexString(this.taskDescription.getBackgroundColor()));
        pw.print(" statusBarColor=");
        pw.print(Integer.toHexString(this.taskDescription.getStatusBarColor()));
        pw.print(" navigationBarColor=");
        pw.println(Integer.toHexString(this.taskDescription.getNavigationBarColor()));
        pw.print(prefix);
        pw.print(" backgroundColorFloating=");
        pw.println(Integer.toHexString(this.taskDescription.getBackgroundColorFloating()));
        goto L39
    L36:
        r5 = "null";
        goto L37
    L30:
        if (this.taskDescription.getLabel() != null) goto L33;
        if (this.taskDescription.getPrimaryColor() != 0) goto L33;
    L39:
        if (this.results == null) goto L42;
        pw.print(prefix);
        pw.print("results=");
        pw.println(this.results);
    L42:
        if (this.pendingResults == null) goto L58;
        if (this.pendingResults.size() <= 0) goto L58;
        pw.print(prefix);
        pw.println("Pending Results:");
        Iterator<WeakReference<PendingIntentRecord>> r3 = this.pendingResults.iterator();
    L47:
        if (r3.hasNext() == false) goto L58;
        WeakReference<PendingIntentRecord> wpir = r3.next();
        if (wpir == null) goto L51;
        PendingIntentRecord pir = wpir.get();
    L52:
        pw.print(prefix);
        pw.print("  - ");
        if (pir == null) goto L54;
        pw.println(pir);
        pir.dump(pw, prefix + "    ");
        goto L47
    L54:
        pw.println("null");
        goto L47
    L51:
        pir = null;
    L58:
        if (this.newIntents == null) goto L70;
        if (this.newIntents.size() <= 0) goto L70;
        pw.print(prefix);
        pw.println("Pending New Intents:");
        int i = 0;
    L63:
        if (i >= this.newIntents.size()) goto L70;
        Intent intent = this.newIntents.get(i);
        pw.print(prefix);
        pw.print("  - ");
        if (intent != null) goto L67;
        pw.println("null");
    L68:
        i = i + 1;
        goto L63
    L67:
        pw.println(intent.toShortString(false, true, false, false));
    L70:
        if (this.mPendingOptions == null) goto L73;
        pw.print(prefix);
        pw.print("pendingOptions=");
        pw.println(this.mPendingOptions);
    L73:
        if (this.mPendingRemoteAnimation == null) goto L76;
        pw.print(prefix);
        pw.print("pendingRemoteAnimationCallingPid=");
        pw.println(this.mPendingRemoteAnimation.getCallingPid());
    L76:
        if (this.mPendingRemoteTransition == null) goto L79;
        pw.print(prefix + " pendingRemoteTransition=" + this.mPendingRemoteTransition.getRemoteTransition());
    L79:
        if (this.appTimeTracker == null) goto L82;
        this.appTimeTracker.dumpWithHeader(pw, prefix, false);
    L82:
        if (this.uriPermissions == null) goto L84;
        this.uriPermissions.dump(pw, prefix);
    L84:
        pw.print(prefix);
        pw.print("launchFailed=");
        pw.print(this.launchFailed);
        pw.print(" launchCount=");
        pw.print(this.launchCount);
        pw.print(" lastLaunchTime=");
        if (this.lastLaunchTime != 0) goto L87;
        pw.print("0");
    L88:
        pw.println();
        if (this.mLaunchCookie == null) goto L92;
        pw.print(prefix);
        pw.print("launchCookie=");
        pw.println(this.mLaunchCookie);
    L92:
        if (this.mLaunchRootTask == null) goto L94;
        pw.print(prefix);
        pw.print("mLaunchRootTask=");
        pw.println(this.mLaunchRootTask);
    L94:
        pw.print(prefix);
        pw.print("mHaveState=");
        pw.print(this.mHaveState);
        pw.print(" mIcicle=");
        pw.println(this.mIcicle);
        pw.print(prefix);
        pw.print("state=");
        pw.print(this.mState);
        pw.print(" delayedResume=");
        pw.print(this.delayedResume);
        pw.print(" finishing=");
        pw.println(this.finishing);
        pw.print(prefix);
        pw.print("keysPaused=");
        pw.print(this.keysPaused);
        pw.print(" inHistory=");
        pw.print(this.inHistory);
        pw.print(" idle=");
        pw.println(this.idle);
        pw.print(prefix);
        pw.print("occludesParent=");
        pw.print(occludesParent());
        pw.print(" mNoDisplay=");
        pw.print(this.mNoDisplay);
        pw.print(" immersive=");
        pw.print(this.immersive);
        pw.print(" launchMode=");
        pw.println(this.launchMode);
        pw.print(prefix);
        pw.print("mActivityType=");
        pw.println(WindowConfiguration.activityTypeToString(getActivityType()));
        if (this.requestedVrComponent == null) goto L97;
        pw.print(prefix);
        pw.print("requestedVrComponent=");
        pw.println(this.requestedVrComponent);
    L97:
        super.dump(pw, prefix, dumpAll);
        if (this.mVoiceInteraction == false) goto L100;
        pw.println(prefix + "mVoiceInteraction=true");
    L100:
        pw.print(prefix);
        pw.print("mOccludesParent=");
        pw.println(this.mOccludesParent);
        pw.print(prefix);
        pw.print("overrideOrientation=");
        pw.println(ActivityInfo.screenOrientationToString(getOverrideOrientation()));
        pw.print(prefix);
        pw.print("requestedOrientation=");
        pw.println(ActivityInfo.screenOrientationToString(super.getOverrideOrientation()));
        StringBuilder r4 = new StringBuilder();
        r4.append(prefix);
        r4.append("mVisibleRequested=");
        r4.append(this.mVisibleRequested);
        r4.append(" mVisible=");
        r4.append(this.mVisible);
        r4.append(" mClientVisible=");
        r4.append(isClientVisible());
        if (this.mDeferHidingClient == false) goto L103;
        String r7 = " mDeferHidingClient=" + this.mDeferHidingClient;
    L104:
        r4.append(r7);
        r4.append(" reportedDrawn=");
        r4.append(this.mReportedDrawn);
        r4.append(" reportedVisible=");
        r4.append(this.reportedVisible);
        pw.println(r4.toString());
        if (this.paused == false) goto L108;
        pw.print(prefix);
        pw.print("paused=");
        pw.println(this.paused);
    L108:
        if (this.mAppStopped == false) goto L111;
        pw.print(prefix);
        pw.print("mAppStopped=");
        pw.println(this.mAppStopped);
    L111:
        if (this.mNumInterestingWindows == 0) goto L113;
    L116:
        pw.print(prefix);
        pw.print("mNumInterestingWindows=");
        pw.print(this.mNumInterestingWindows);
        pw.print(" mNumDrawnWindows=");
        pw.print(this.mNumDrawnWindows);
        pw.print(" allDrawn=");
        pw.print(this.allDrawn);
        pw.println(")");
    L118:
        if (this.mStartingData == null) goto L120;
    L121:
        pw.print(prefix);
        pw.print("startingData=");
        pw.print(this.mStartingData);
        pw.print(" firstWindowDrawn=");
        pw.println(this.firstWindowDrawn);
    L123:
        if (this.mStartingWindow == null) goto L125;
    L132:
        pw.print(prefix);
        pw.print("startingWindow=");
        pw.print(this.mStartingWindow);
        pw.print(" startingSurface=");
        pw.print(this.mStartingSurface);
        pw.print(" startingDisplayed=");
        pw.print(isStartingWindowDisplayed());
        pw.print(" startingMoved=");
        pw.print(this.startingMoved);
        pw.println(" mVisibleSetFromTransferredStartingWindow=" + this.mVisibleSetFromTransferredStartingWindow);
    L134:
        if (this.mPendingRelaunchCount == 0) goto L137;
        pw.print(prefix);
        pw.print("mPendingRelaunchCount=");
        pw.println(this.mPendingRelaunchCount);
    L137:
        if (this.mRemovingFromDisplay == false) goto L140;
        pw.println(prefix + "mRemovingFromDisplay=" + this.mRemovingFromDisplay);
    L140:
        if (this.lastVisibleTime == 0) goto L142;
    L143:
        pw.print(prefix);
        pw.print("nowVisible=");
        pw.print(this.nowVisible);
        pw.print(" lastVisibleTime=");
        if (this.lastVisibleTime != 0) goto L146;
        pw.print("0");
    L147:
        pw.println();
    L149:
        if (this.mDeferHidingClient == false) goto L152;
        pw.println(prefix + "mDeferHidingClient=" + this.mDeferHidingClient);
    L152:
        if (this.mServiceConnectionsHolder == null) goto L155;
        pw.print(prefix);
        pw.print("connections=");
        pw.println(this.mServiceConnectionsHolder);
    L155:
        if (this.info == null) goto L173;
        pw.println(prefix + "resizeMode=" + ActivityInfo.resizeModeToString(this.info.resizeMode));
        pw.println(prefix + "mLastReportedMultiWindowMode=" + this.mLastReportedMultiWindowMode + " mLastReportedPictureInPictureMode=" + this.mLastReportedPictureInPictureMode);
        if (this.info.supportsPictureInPicture() == false) goto L160;
        pw.println(prefix + "supportsPictureInPicture=" + this.info.supportsPictureInPicture());
        pw.println(prefix + "supportsEnterPipOnTaskSwitch: " + this.supportsEnterPipOnTaskSwitch);
        pw.println(prefix + "mPauseSchedulePendingForPip=" + this.mPauseSchedulePendingForPip);
    L160:
        if (getMaxAspectRatio() == 0.0f) goto L162;
        pw.println(prefix + "maxAspectRatio=" + getMaxAspectRatio());
    L162:
        float minAspectRatio = getMinAspectRatio();
        if (minAspectRatio == 0.0f) goto L166;
        pw.println(prefix + "minAspectRatio=" + minAspectRatio);
    L166:
        if (minAspectRatio == this.info.getManifestMinAspectRatio()) goto L168;
        pw.println(prefix + "manifestMinAspectRatio=" + this.info.getManifestMinAspectRatio());
    L168:
        pw.println(prefix + "supportsSizeChanges=" + ActivityInfo.sizeChangesSupportModeToString(this.mAppCompatController.getSizeCompatModePolicy().supportsSizeChanges()));
        if (this.info.configChanges == 0) goto L171;
        pw.println(prefix + "configChanges=0x" + Integer.toHexString(this.info.configChanges));
    L171:
        pw.println(prefix + "neverSandboxDisplayApis=" + this.info.neverSandboxDisplayApis(sConstrainDisplayApisConfig));
        pw.println(prefix + "alwaysSandboxDisplayApis=" + this.info.alwaysSandboxDisplayApis(sConstrainDisplayApisConfig));
    L173:
        if (this.mLastParentBeforePip == null) goto L176;
        pw.println(prefix + "lastParentTaskIdBeforePip=" + this.mLastParentBeforePip.mTaskId);
    L176:
        if (this.mLaunchIntoPipHostActivity == null) goto L179;
        pw.println(prefix + "launchIntoPipHostActivity=" + this.mLaunchIntoPipHostActivity);
    L179:
        if (this.mWaitForEnteringPinnedMode == false) goto L181;
        pw.print(prefix);
        pw.println("mWaitForEnteringPinnedMode=true");
    L181:
        this.mAppCompatController.dump(pw, prefix);
        return;
    L146:
        TimeUtils.formatDuration(this.lastVisibleTime, now, pw);
        goto L147
    L142:
        if (this.nowVisible == false) goto L149;
    L125:
        if (this.mStartingData != null) goto L132;
        if (this.mStartingSurface != null) goto L132;
        if (this.startingMoved == true) goto L132;
        if (this.mVisibleSetFromTransferredStartingWindow == false) goto L134;
    L120:
        if (this.firstWindowDrawn == false) goto L123;
    L113:
        if (this.mNumDrawnWindows != 0) goto L116;
        if (this.allDrawn == false) goto L118;
    L103:
        r7 = "";
        goto L104
    L87:
        TimeUtils.formatDuration(this.lastLaunchTime, now, pw);
        goto L88
    L23:
        if (this.resultWho == null) goto L26;
        goto L24
    }

    static boolean dumpActivity(FileDescriptor fd, PrintWriter pw, int index, ActivityRecord r, String prefix, String label, boolean complete, boolean brief, boolean client, String dumpPackage, boolean needNL, Runnable header, Task lastTask) {
        if (dumpPackage == null) goto L8;
        if (dumpPackage.equals(r.packageName) == true) goto L8;
        return false;
    L8:
        if (brief == true) goto L13;
        if (complete == false) goto L11;
    L12:
        boolean full = true;
    L14:
        if (needNL == false) goto L16;
        pw.println("");
    L16:
        if (header == null) goto L18;
        header.run();
    L18:
        String innerPrefix = prefix + "  ";
        String[] args = new String[0];
        String r9 = "* ";
        if (lastTask == r.getTask()) goto L32;
        Task lastTask2 = r.getTask();
        pw.print(prefix);
        if (full == false) goto L23;
        String r10 = "* ";
    L24:
        pw.print(r10);
        pw.println(lastTask2);
        if (full == false) goto L27;
        lastTask2.dump(pw, prefix + "  ");
        goto L32
    L27:
        if (complete == false) goto L32;
        if (lastTask2.intent == null) goto L32;
        pw.print(prefix);
        pw.print("  ");
        pw.println(lastTask2.intent.toInsecureString());
        goto L32
    L23:
        r10 = "  ";
    L32:
        pw.print(prefix);
        if (full == true) goto L36;
        r9 = "    ";
    L36:
        pw.print(r9);
        pw.print(label);
        pw.print(" #");
        pw.print(index);
        pw.print(": ");
        pw.println(r);
        if (full == false) goto L39;
        r.dump(pw, innerPrefix, true);
    L43:
        if (client == true) goto L45;
    L61:
        return true;
    L45:
        if (r.attachedToProcess() == false) goto L61;
        pw.flush();
        TransferPipe tp = new TransferPipe();     // Catch: RemoteException -> L52 IOException -> L54
        r.app.getThread().dumpActivity(tp.getWriteFd(), r.token, innerPrefix, args);     // Catch: Throwable -> L56
        tp.go(fd, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);     // Catch: Throwable -> L56
        tp.kill();     // Catch: RemoteException -> L52 IOException -> L54
        goto L61
    L56:
        th = move-exception;
        tp.kill();     // Catch: RemoteException -> L52 IOException -> L54
        throw th;     // Catch: RemoteException -> L52 IOException -> L54
    L54:
        e = move-exception;
        pw.println(innerPrefix + "Failure while dumping the activity: " + e);
    L59:
        pw.println(innerPrefix + "Got a RemoteException while dumping the activity");
        goto L61
    L39:
        if (complete == false) goto L43;
        pw.print(innerPrefix);
        pw.println(r.intent.toInsecureString());
        if (r.app == null) goto L43;
        pw.print(innerPrefix);
        pw.println(r.app);
        goto L43
    L11:
        if (r.isInHistory() == false) goto L12;
    L13:
        full = false;
        goto L14
    }

    void setSavedState(Bundle savedState) {
        this.mIcicle = savedState;
        if (this.mIcicle == null) goto L5;
        boolean r0 = true;
    L6:
        this.mHaveState = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    Bundle getSavedState() {
        return this.mIcicle;
    }

    boolean hasSavedState() {
        return this.mHaveState;
    }

    PersistableBundle getPersistentSavedState() {
        return this.mPersistentState;
    }

    void updateApplicationInfo(ApplicationInfo aInfo) {
        this.info.applicationInfo = aInfo;
    }

    void setSizeConfigurations(SizeConfigurationBuckets sizeConfigurations) {
        this.mSizeConfigurations = sizeConfigurations;
    }

    private void scheduleActivityMovedToDisplay(int displayId, Configuration config, ActivityWindowInfo activityWindowInfo) {
        if (attachedToProcess() == true) goto L9;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SWITCH_enabled[3] == false) goto L18;
        String protoLogParam0 = String.valueOf(this);
        long protoLogParam1 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_SWITCH, -6509265758887333864L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1)});
        return;
    L18:
        return;
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SWITCH_enabled[1] == false) goto L16;
        String protoLogParam2 = String.valueOf(this);
        long protoLogParam3 = displayId;
        String protoLogParam4 = String.valueOf(config);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_SWITCH, -4183059578873561863L, 4, new Object[]{protoLogParam2, Long.valueOf(protoLogParam3), protoLogParam4});
    L16:
        this.mAtmService.getLifecycleManager().scheduleTransactionItem(this.app.getThread(), new MoveToDisplayItem(this.token, displayId, config, activityWindowInfo));     // Catch: RemoteException -> L14
        return;
    }

    private void scheduleConfigurationChanged(Configuration config, ActivityWindowInfo activityWindowInfo) {
        if (attachedToProcess() == true) goto L9;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[3] == false) goto L18;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, 7435279034964784633L, 0, new Object[]{protoLogParam0});
        return;
    L18:
        return;
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L11;
        String protoLogParam1 = String.valueOf(this);
        String protoLogParam2 = String.valueOf(config);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, -7418876140361338495L, 0, new Object[]{protoLogParam1, protoLogParam2});
    L11:
        ClientTransactionItem r0 = new ActivityConfigurationChangeItem(this.token, config, activityWindowInfo);
        this.mAtmService.getLifecycleManager().scheduleTransactionItem(this.app.getThread(), r0);     // Catch: RemoteException -> L14
        return;
    }

    boolean scheduleTopResumedActivityChanged(boolean onTop) {
        if (attachedToProcess() == false) goto L35;
        if (isState(State.DESTROYING, State.DESTROYED) == true) goto L35;
        if (onTop == false) goto L10;
        this.app.addToPendingTop();
    L10:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L12;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 7244227111034368231L, 12, new Object[]{protoLogParam0, Boolean.valueOf(onTop)});
    L12:
        ClientTransactionItem r0 = new TopResumedActivityChangeItem(this.token, onTop);
        ZTEActivityEventsInternal zteActivityEventsInternal = (ZTEActivityEventsInternal) LocalServices.getService(ZTEActivityEventsInternal.class);     // Catch: RemoteException -> L22 FrozenObjectException -> L24
        if (zteActivityEventsInternal == null) goto L26;
        ActivityRecord r8 = this;
        zteActivityEventsInternal.notifyActivityEvent(4096, getDisplayId(), this.mUserId, r8, getRootTaskId());     // Catch: RemoteException -> L18 FrozenObjectException -> L20
    L27:
        return r8.mAtmService.getLifecycleManager().scheduleTransactionItem(r8.app.getThread(), r0);
    L20:
        e = e;
    L31:
        Slog.e("ActivityTaskManager", "schedule top resume activity change failed", e);
        return false;
    L18:
        e = e;
    L29:
        Slog.w("ActivityTaskManager", "Failed to send top-resumed=" + onTop + " to " + this, e);
        return false;
    L26:
        r8 = this;
    L24:
        e = e;
    L22:
        e = e;
    L35:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[3] == false) goto L37;
        String protoLogParam1 = String.valueOf(this + ", onTop=" + onTop);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_STATES, -4284934398288119962L, 0, new Object[]{protoLogParam1});
    L37:
        return false;
    }

    void updateMultiWindowMode() {
        if (this.task != null) goto L5;
        return;
    L5:
        if (this.task.getRootTask() != null) goto L7;
        return;
    L7:
        if (attachedToProcess() == false) goto L21;
        boolean inMultiWindowMode = inMultiWindowMode();
        if (inMultiWindowMode == this.mLastReportedMultiWindowMode) goto L18;
        if (inMultiWindowMode == false) goto L13;
    L15:
        this.mLastReportedMultiWindowMode = inMultiWindowMode;
        ensureActivityConfiguration();
        return;
    L13:
        if (this.mLastReportedPictureInPictureMode == false) goto L15;
        updatePictureInPictureMode(null, false);
        return;
    L18:
        return;
    }

    void updatePictureInPictureMode(Rect targetRootTaskBounds, boolean forceUpdate) {
        if (this.task != null) goto L5;
        return;
    L5:
        if (this.task.getRootTask() != null) goto L7;
        return;
    L7:
        if (attachedToProcess() == true) goto L10;
        return;
    L10:
        if (inPinnedWindowingMode() == false) goto L13;
        if (targetRootTaskBounds == null) goto L13;
        boolean inPictureInPictureMode = true;
    L15:
        if (inPictureInPictureMode != this.mLastReportedPictureInPictureMode) goto L17;
        if (forceUpdate == true) goto L17;
        return;
    L17:
        this.mLastReportedPictureInPictureMode = inPictureInPictureMode;
        this.mLastReportedMultiWindowMode = inPictureInPictureMode;
        if (forceUpdate == false) goto L20;
    L21:
        ensureActivityConfiguration(true);
    L22:
        if (inPictureInPictureMode == true) goto L24;
        return;
    L24:
        if (findMainWindow() == null) goto L26;
        return;
    L26:
        if (this.task.topRunningActivity() != this) goto L33;
        EventLog.writeEvent(1397638484, new Object[]{"265293293", -1, ""});
        removeImmediately();
        return;
    L33:
        return;
    L20:
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == true) goto L22;
    L13:
        inPictureInPictureMode = false;
        goto L15
    }

    Task getTask() {
        return this.task;
    }

    TaskFragment getTaskFragment() {
        WindowContainer parent = getParent();
        if (parent != null) goto L7;
        return null;
    L7:
        return parent.asTaskFragment();
    }

    private boolean shouldStartChangeTransition(TaskFragment newParent, TaskFragment oldParent) {
        if (newParent == null) goto L20;
        if (oldParent == null) goto L20;
        if (canStartChangeTransition() == false) goto L20;
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == true) goto L11;
    L13:
        boolean isInPip2 = false;
    L15:
        if (newParent.isOrganizedTaskFragment() == true) goto L19;
        if (isInPip2 == true) goto L19;
        return false;
    L19:
        return !newParent.getBounds().equals(oldParent.getBounds());
    L11:
        if (inPinnedWindowingMode() == false) goto L13;
        isInPip2 = true;
    L20:
        return false;
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

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    void onParentChanged(ConfigurationContainer rawNewParent, ConfigurationContainer rawOldParent) {
        TaskFragment oldParent = (TaskFragment) rawOldParent;
        TaskFragment newParent = (TaskFragment) rawNewParent;
        if (oldParent == null) goto L5;
        Task oldTask = oldParent.getTask();
    L6:
        if (newParent == null) goto L8;
        Task newTask = newParent.getTask();
    L9:
        this.task = newTask;
        if (shouldStartChangeTransition(newParent, oldParent) == false) goto L12;
        this.mTransitionController.collectVisibleChange(this);
    L12:
        super.onParentChanged(newParent, oldParent);
        boolean r6 = false;
        if (isPersistable() == false) goto L19;
        if (oldTask == null) goto L16;
        this.mAtmService.notifyTaskPersisterLocked(oldTask, false);
    L16:
        if (newTask == null) goto L19;
        this.mAtmService.notifyTaskPersisterLocked(newTask, false);
    L19:
        if (oldParent != null) goto L25;
        if (newParent == null) goto L25;
        if (newTask.voiceSession == null) goto L24;
        r6 = true;
    L24:
        this.mVoiceInteraction = r6;
        newTask.updateOverrideConfigurationFromLaunchBounds();
        this.mLastReportedMultiWindowMode = inMultiWindowMode();
        this.mLastReportedPictureInPictureMode = inPinnedWindowingMode();
    L25:
        Task rootTask = getRootTask();
        if (this.task == this.mLastParentBeforePip) goto L28;
    L30:
        updateColorTransform();
        if (oldParent == null) goto L33;
        oldParent.cleanUpActivityReferences(this);
        this.mRequestedLaunchingTaskFragmentToken = null;
    L33:
        if (newParent != null) goto L35;
    L42:
        if (rootTask != null) goto L44;
    L48:
        updateUntrustedEmbeddingInputProtection();
        return;
    L44:
        if (rootTask.topRunningActivity() != this) goto L48;
        if (this.firstWindowDrawn == false) goto L48;
        rootTask.setHasBeenVisible(true);
        goto L48
    L35:
        if (isState(State.RESUMED) == false) goto L37;
        newParent.setResumedActivity(this, "onParentChanged");
    L37:
        this.mAppCompatController.getTransparentPolicy().start();
        if (this.mState != State.INITIALIZING) goto L42;
        if (isRestrictedFixedOrientation(this.info.screenOrientation) == false) goto L42;
        Slog.i("ActivityTaskManager", "Ignoring manifest-declared fixed orientation " + ActivityInfo.screenOrientationToString(this.info.screenOrientation) + " of " + this + " since target sdk 36");
        goto L42
    L28:
        if (this.task == null) goto L30;
        this.mAtmService.mWindowOrganizerController.mTaskFragmentOrganizerController.onActivityReparentedToTask(this);
        clearLastParentBeforePip();
        goto L30
    L8:
        newTask = null;
        goto L9
    L5:
        oldTask = null;
        goto L6
    }

    @Override // com.android.server.wm.WindowContainer
    void setSurfaceControl(SurfaceControl sc) {
        super.setSurfaceControl(sc);
        if (sc == null) goto L6;
        this.mLastDropInputMode = 0;
        updateUntrustedEmbeddingInputProtection();
        return;
    }

    void setDropInputForAnimation(boolean isInputDroppedForAnimation) {
        if (this.mIsInputDroppedForAnimation != isInputDroppedForAnimation) goto L5;
        return;
    L5:
        this.mIsInputDroppedForAnimation = isInputDroppedForAnimation;
        updateUntrustedEmbeddingInputProtection();
    }

    private void updateUntrustedEmbeddingInputProtection() {
        if (getSurfaceControl() != null) goto L6;
        return;
    L6:
        if (this.mIsInputDroppedForAnimation == false) goto L9;
        setDropInputMode(1);
        return;
    L9:
        if (isEmbeddedInUntrustedMode() == false) goto L11;
        setDropInputMode(2);
        return;
    L11:
        setDropInputMode(0);
    }

    void setDropInputMode(int mode) {
        if (this.mLastDropInputMode == mode) goto L6;
        this.mLastDropInputMode = mode;
        this.mWmService.mTransactionFactory.get().setDropInputMode(getSurfaceControl(), mode).apply();
        return;
    }

    private boolean isEmbeddedInUntrustedMode() {
        TaskFragment organizedTaskFragment = getOrganizedTaskFragment();
        if (organizedTaskFragment != null) goto L7;
        return false;
    L7:
        return !organizedTaskFragment.isAllowedToEmbedActivityInTrustedMode(this);
    }

    boolean canAutoEnterPip() {
        boolean activityCanPip = checkEnterPictureInPictureState("startActivityUnchecked", false);
        if (activityCanPip == true) goto L5;
        return false;
    L5:
        if (this.pictureInPictureArgs != null) goto L7;
        return false;
    L7:
        if (this.pictureInPictureArgs.isAutoEnterEnabled() == false) goto L13;
        return true;
    L13:
        return false;
    }

    void setLastParentBeforePip(ActivityRecord launchIntoPipHostActivity) {
        if (launchIntoPipHostActivity != null) goto L4;
        Task r0 = getTask();
    L5:
        this.mLastParentBeforePip = r0;
        this.mLastParentBeforePip.mChildPipActivity = this;
        this.mLaunchIntoPipHostActivity = launchIntoPipHostActivity;
        if (launchIntoPipHostActivity != null) goto L8;
        TaskFragment organizedTf = getOrganizedTaskFragment();
    L10:
        if (organizedTf == null) goto L12;
        ITaskFragmentOrganizer r1 = organizedTf.getTaskFragmentOrganizer();
    L13:
        this.mLastTaskFragmentOrganizerBeforePip = r1;
        if (organizedTf == null) goto L18;
        if (launchIntoPipHostActivity != null) goto L19;
        this.mLastEmbeddedParentTfTokenBeforePip = organizedTf.getFragmentToken();
        return;
    L19:
        return;
    L18:
        return;
    L12:
        r1 = null;
        goto L13
    L8:
        organizedTf = launchIntoPipHostActivity.getOrganizedTaskFragment();
        goto L10
    L4:
        r0 = launchIntoPipHostActivity.getTask();
        goto L5
    }

    void clearLastParentBeforePip() {
        if (this.mLastParentBeforePip == null) goto L5;
        this.mLastParentBeforePip.mChildPipActivity = null;
        this.mLastParentBeforePip = null;
    L5:
        this.mLaunchIntoPipHostActivity = null;
        this.mLastTaskFragmentOrganizerBeforePip = null;
        this.mLastEmbeddedParentTfTokenBeforePip = null;
    }

    Task getLastParentBeforePip() {
        return this.mLastParentBeforePip;
    }

    IBinder getLastEmbeddedParentTfTokenBeforePip() {
        return this.mLastEmbeddedParentTfTokenBeforePip;
    }

    ActivityRecord getLaunchIntoPipHostActivity() {
        return this.mLaunchIntoPipHostActivity;
    }

    private void updateColorTransform() {
        if (this.mSurfaceControl != null) goto L5;
        return;
    L5:
        if (this.mLastAppSaturationInfo == null) goto L9;
        getPendingTransaction().setColorTransform(this.mSurfaceControl, this.mLastAppSaturationInfo.mMatrix, this.mLastAppSaturationInfo.mTranslation);
        this.mWmService.scheduleAnimationLocked();
        return;
    }

    @Override // com.android.server.wm.WindowToken, com.android.server.wm.WindowContainer
    void onDisplayChanged(DisplayContent dc) {
        DisplayContent prevDc = this.mDisplayContent;
        super.onDisplayChanged(dc);
        if (prevDc != this.mDisplayContent) goto L5;
        return;
    L5:
        this.mDisplayContent.onRunningActivityChanged();
        if (prevDc != null) goto L8;
        return;
    L8:
        prevDc.onRunningActivityChanged();
        prevDc.getDisplayPolicy().removeRelaunchingApp(this);
        if (prevDc.mFocusedApp != this) goto L13;
        prevDc.setFocusedApp(null);
        if (dc.getTopMostActivity() != this) goto L13;
        dc.setFocusedApp(this);
    L13:
        this.mAppCompatController.getLetterboxPolicy().onMovedToDisplay(this.mDisplayContent.getDisplayId());
        this.mAppCompatController.getDisplayCompatModePolicy().onMovedToDisplay();
    }

    void layoutLetterboxIfNeeded(WindowState winHint) {
        this.mAppCompatController.getLetterboxPolicy().start(winHint);
    }

    boolean hasWallpaperBackgroundForLetterbox() {
        return this.mAppCompatController.getLetterboxOverrides().hasWallpaperBackgroundForLetterbox();
    }

    void updateLetterboxSurfaceIfNeeded(WindowState winHint, SurfaceControl.Transaction t) {
        this.mAppCompatController.getLetterboxPolicy().updateLetterboxSurfaceIfNeeded(winHint, t, getPendingTransaction());
    }

    void updateLetterboxSurfaceIfNeeded(WindowState winHint) {
        this.mAppCompatController.getLetterboxPolicy().updateLetterboxSurfaceIfNeeded(winHint);
    }

    Rect getLetterboxInsets() {
        return this.mAppCompatController.getLetterboxPolicy().getLetterboxInsets();
    }

    void getLetterboxInnerBounds(Rect outBounds) {
        this.mAppCompatController.getLetterboxPolicy().getLetterboxInnerBounds(outBounds);
    }

    boolean isFullyTransparentBarAllowed(Rect rect) {
        return this.mAppCompatController.getLetterboxPolicy().isFullyTransparentBarAllowed(rect);
    }

    static ActivityRecord forToken(IBinder token) {
        if (token != null) goto L11;
        return null;
    L11:
        Token activityToken = (Token) token;     // Catch: ClassCastException -> L8
        return activityToken.mActivityRef.get();
    L8:
        e = move-exception;
        Slog.w("ActivityTaskManager", "Bad activity token: " + token, e);
        return null;
    }

    static ActivityRecord forTokenLocked(IBinder token) {
        ActivityRecord r = forToken(token);
        if (r != null) goto L5;
    L8:
        return null;
    L5:
        if (r.getRootTask() == null) goto L8;
        return r;
    }

    static boolean isResolverActivity(String className) {
        return ResolverActivity.class.getName().equals(className);
    }

    boolean isResolverOrDelegateActivity() {
        if (getExt().isResolverOrDelegateActivity() == false) goto L6;
        return true;
    L6:
        if (isResolverActivity(this.mActivityComponent.getClassName()) == false) goto L8;
        return true;
    L8:
        if (Objects.equals(this.mActivityComponent, this.mAtmService.mTaskSupervisor.getSystemChooserActivity()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    boolean isResolverOrChildActivity() {
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(this.packageName) == true) goto L16;
        return false;
    L16:
        if (ResolverActivity.class.isAssignableFrom(Object.class.getClassLoader().loadClass(this.mActivityComponent.getClassName())) == true) goto L12;
        if (bytedanceos.app.ResolverActivity.class.isAssignableFrom(Object.class.getClassLoader().loadClass(this.mActivityComponent.getClassName())) == true) goto L12;
        return false;
    L12:
        return true;
    L15:
        return false;
    }

    boolean hasCaller(IBinder callerToken) {
        return this.mCallerState.hasCaller(callerToken);
    }

    int getCallerUid(IBinder callerToken) {
        return this.mCallerState.getUid(callerToken);
    }

    String getCallerPackage(IBinder callerToken) {
        return this.mCallerState.getPackage(callerToken);
    }

    boolean isCallerShareIdentityEnabled(IBinder callerToken) {
        return this.mCallerState.isShareIdentityEnabled(callerToken);
    }

    void computeInitialCallerInfo() {
        computeCallerInfo(this.initialCallerInfoAccessToken, this.intent, this.launchedFromUid, this.launchedFromPackage, this.mShareIdentity);
    }

    void computeCallerInfo(IBinder callerToken, Intent intent, int callerUid, String callerPackageName, boolean isCallerShareIdentityEnabled) {
        this.mCallerState.computeCallerInfo(callerToken, intent, callerUid, callerPackageName, isCallerShareIdentityEnabled);
    }

    boolean checkContentUriPermission(IBinder callerToken, GrantUri grantUri, int modeFlags) {
        return this.mCallerState.checkContentUriPermission(callerToken, grantUri, modeFlags);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ActivityRecord(ActivityTaskManagerService _service, WindowProcessController _caller, int _launchedFromPid, int _launchedFromUid, String _launchedFromPackage, String _launchedFromFeature, Intent _intent, String _resolvedType, ActivityInfo aInfo, Configuration _configuration, ActivityRecord _resultTo, String _resultWho, int _reqCode, boolean _componentSpecified, boolean _rootVoiceInteraction, ActivityTaskSupervisor supervisor, ActivityOptions options, ActivityRecord sourceRecord, PersistableBundle persistentState, ActivityManager.TaskDescription _taskDescription, long _createTime) {
        super(_service.mWindowManager, new Token(null), 2, true, null, false);
        this.mHandoverLaunchDisplayId = -1;
        this.perfActivityBoostHandler = -1;
        this.mPerfScenarioBoostHandler = -1;
        this.createTime = System.currentTimeMillis();
        this.mLastReportedActivityWindowInfo = new ActivityWindowInfo();
        this.mHaveState = true;
        this.pictureInPictureArgs = new PictureInPictureParams.Builder().build();
        this.mLastReportedProcState = -1;
        this.mSplashScreenStyleSolidColor = false;
        this.mPauseSchedulePendingForPip = false;
        this.mAutoEnteringPip = false;
        this.mTaskOverlay = false;
        this.mRelaunchReason = 0;
        this.mForceSendResultForMediaProjection = false;
        this.mPerf = null;
        this.mPerf_iop = null;
        this.isLowRamDevice = SystemProperties.getBoolean("ro.config.low_ram", false);
        this.mRemovingFromDisplay = false;
        this.mReportedVisibilityResults = new WindowState.UpdateReportedVisibilityResults();
        this.mCurrentLaunchCanTurnScreenOn = true;
        this.mInputDispatchingTimeoutMillis = InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS;
        this.mLastTransactionSequence = Long.MIN_VALUE;
        this.mLastAllReadyAtSync = false;
        this.mEnableRecentsScreenshot = true;
        this.mLastDropInputMode = 0;
        this.mTransferringSplashScreenState = 0;
        this.mRotationAnimationHint = -1;
        this.mColorTransformController = new ActivityRecord$$ExternalSyntheticLambda25(this);
        this.mTmpConfig = new Configuration();
        this.mTmpBounds = new Rect();
        this.mTmpActivityWindowInfo = new ActivityWindowInfo();
        this.assistToken = new Binder();
        this.shareableActivityToken = new Binder();
        this.initialCallerInfoAccessToken = new Binder();
        this.mActivityRecordInputSinkEnabled = true;
        this.mPauseConfigurationDispatchCount = 0;
        this.mIsOnCarDisplay = false;
        this.firstTime = true;
        this.mRemoveStartWindowTimeoutRunnable = new AnonymousClass1(this);
        this.mPauseTimeoutRunnable = new AnonymousClass2(this);
        this.mDestroyTimeoutRunnable = new AnonymousClass3(this);
        this.mStopTimeoutRunnable = new AnonymousClass4(this);
        this.mTransferSplashScreenTimeoutRunnable = new AnonymousClass5(this);
        this.mExt = (IExtActivityRecord) ExtImplFactory.getImpl(IExtActivityRecord.class, new Object[]{this});
        this.mAtmService = _service;
        ((Token) this.token).mActivityRef = new WeakReference(this);
        this.info = aInfo;
        this.mUserId = UserHandle.getUserId(this.info.applicationInfo.uid);
        this.packageName = this.info.applicationInfo.packageName;
        this.intent = _intent;
        if (this.info.targetActivity != null) goto L5;
    L12:
        this.mActivityComponent = this.intent.getComponent();
    L13:
        this.mAppCompatController = new AppCompatController(this.mWmService, this);
        this.mResolveConfigHint = new TaskFragment.ConfigOverrideHint();
        if (this.mWmService.mFlags.mInsetsDecoupledConfiguration == false) goto L22;
        TaskFragment.ConfigOverrideHint r1 = this.mResolveConfigHint;
        boolean r15 = 1;
        if (this.info.isChangeEnabled(151861875) == false) goto L18;
    L20:
        boolean r2 = false;
    L21:
        r1.mUseOverrideInsetsForConfig = r2;
    L23:
        this.mTargetSdk = this.info.applicationInfo.targetSdkVersion;
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        UserProperties properties = umi.getUserProperties(this.mUserId);
        if (properties != null) goto L26;
    L28:
        boolean r3 = false;
    L29:
        this.mIsUserAlwaysVisible = r3;
        if ((this.info.flags & 1024) == 0) goto L32;
    L35:
        boolean r4 = r15;
    L36:
        this.mShowForAllUsers = r4;
        setOverrideOrientation(this.info.screenOrientation);
        this.mRotationAnimationHint = this.info.rotationAnimation;
        if ((aInfo.flags & 8388608) == 0) goto L39;
        boolean r5 = r15;
    L40:
        this.mShowWhenLocked = r5;
        if ((aInfo.privateFlags & r15) == 0) goto L43;
        boolean r6 = r15;
    L44:
        this.mInheritShownWhenLocked = r6;
        if ((aInfo.flags & 16777216) == 0) goto L47;
        boolean r7 = r15;
    L48:
        this.mTurnScreenOn = r7;
        int realTheme = this.info.getThemeResource();
        if (realTheme == 0) goto L51;
    L55:
        WindowStyle style = this.mAtmService.getWindowStyle(this.packageName, realTheme, this.mUserId);
        this.mWindowStyle = style;
        if (style != null) goto L58;
        this.mOccludesParent = r15;
        this.mStyleFillsParent = r15;
        this.mNoDisplay = false;
        this.mOptOutEdgeToEdge = false;
    L73:
        this.callerApp = _caller;
        if (options == null) goto L84;
        this.mLaunchTaskBehind = options.getLaunchTaskBehind();
        int rotationAnimation = options.getRotationAnimationHint();
        if (rotationAnimation < 0) goto L79;
        this.mRotationAnimationHint = rotationAnimation;
    L79:
        if (options.getLaunchIntoPipParams() == null) goto L83;
        this.pictureInPictureArgs = options.getLaunchIntoPipParams();
        if (sourceRecord == null) goto L83;
        adjustPictureInPictureParamsIfNeeded(sourceRecord.getBounds());
    L83:
        this.mOverrideTaskTransition = options.getOverrideTaskTransition();
        this.mDismissKeyguardIfInsecure = options.getDismissKeyguardIfInsecure();
        this.mShareIdentity = options.isShareIdentityEnabled();
    L84:
        ColorDisplayService.ColorDisplayServiceInternal cds = (ColorDisplayService.ColorDisplayServiceInternal) LocalServices.getService(ColorDisplayService.ColorDisplayServiceInternal.class);
        cds.attachColorTransformController(this.packageName, this.mUserId, new WeakReference(this.mColorTransformController));
        this.mRootWindowContainer = _service.mRootWindowContainer;
        this.launchedFromPid = _launchedFromPid;
        this.launchedFromUid = _launchedFromUid;
        this.launchedFromPackage = _launchedFromPackage;
        this.launchedFromFeatureId = _launchedFromFeature;
        this.mLaunchSourceType = determineLaunchSourceType(_launchedFromUid, _caller);
        this.shortComponentName = _intent.getComponent().flattenToShortString();
        this.resolvedType = _resolvedType;
        this.componentSpecified = _componentSpecified;
        this.rootVoiceInteraction = _rootVoiceInteraction;
        this.mLastReportedConfiguration = new MergedConfiguration(_configuration);
        this.resultTo = _resultTo;
        this.resultWho = _resultWho;
        this.requestCode = _reqCode;
        setState(State.INITIALIZING, "ActivityRecord ctor");
        callServiceTrackeronActivityStatechange(State.INITIALIZING, true);
        this.launchFailed = false;
        this.delayedResume = false;
        this.finishing = false;
        this.keysPaused = false;
        this.inHistory = false;
        this.nowVisible = false;
        super.setClientVisible(true);
        this.idle = false;
        this.hasBeenLaunched = false;
        this.launching = false;
        this.translucentWindowLaunch = false;
        this.mTaskSupervisor = supervisor;
        this.info.taskAffinity = computeTaskAffinity(this.info.taskAffinity, this.info.applicationInfo.uid);
        this.taskAffinity = this.info.taskAffinity;
        String uid = Integer.toString(this.info.applicationInfo.uid);
        if (this.info.windowLayout == null) goto L94;
        if (this.info.windowLayout.windowLayoutAffinity == null) goto L94;
        if (this.info.windowLayout.windowLayoutAffinity.startsWith(uid) == true) goto L94;
        this.info.windowLayout.windowLayoutAffinity = uid + ":" + this.info.windowLayout.windowLayoutAffinity;
    L94:
        if (sConstrainDisplayApisConfig != null) goto L97;
        sConstrainDisplayApisConfig = new ConstrainDisplayApisConfig();
    L97:
        if ((aInfo.flags & 16) == 0) goto L99;
        boolean r16 = true;
    L100:
        this.stateNotNeeded = r16;
        this.theme = aInfo.getThemeResource();
        if ((aInfo.flags & 1) == 0) goto L108;
        if (_caller == null) goto L108;
        if (aInfo.applicationInfo.uid != 1000) goto L106;
    L107:
        this.processName = _caller.mName;
    L110:
        if ((aInfo.flags & 32) == 0) goto L112;
        this.intent.addFlags(8388608);
    L112:
        this.launchMode = aInfo.launchMode;
        setActivityType(_componentSpecified, _launchedFromUid, _intent, options, sourceRecord);
        if ((aInfo.flags & 2048) == 0) goto L115;
        boolean r8 = true;
    L116:
        this.immersive = r8;
        if (aInfo.requestedVrComponent != null) goto L119;
        ComponentName r9 = null;
    L120:
        this.requestedVrComponent = r9;
        this.lockTaskLaunchMode = getLockTaskLaunchMode(aInfo, options);
        if (options == null) goto L145;
        setOptions(options);
        if (options.getAnimationType() == 5) goto L125;
    L129:
        boolean r10 = false;
    L130:
        this.mHasSceneTransition = r10;
        PendingIntent usageReport = options.getUsageTimeReport();
        if (usageReport == null) goto L133;
        this.appTimeTracker = new AppTimeTracker(usageReport);
    L133:
        WindowContainerToken daToken = options.getLaunchTaskDisplayArea();
        if (daToken == null) goto L136;
        TaskDisplayArea r11 = (TaskDisplayArea) WindowContainer.fromBinder(daToken.asBinder());
    L137:
        this.mHandoverTaskDisplayArea = r11;
        this.mHandoverLaunchDisplayId = options.getLaunchDisplayId();
        this.mLaunchCookie = options.getLaunchCookie();
        this.mLaunchRootTask = options.getLaunchRootTask();
        if (this.mLaunchCookie == null) goto L143;
        boolean r17 = true;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L144;
        String protoLogParam0 = String.valueOf(this.mLaunchCookie);
        String protoLogParam1 = String.valueOf(this.packageName);
        long protoLogParam2 = System.identityHashCode(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 6621250641965102475L, 16, new Object[]{protoLogParam0, protoLogParam1, Long.valueOf(protoLogParam2)});
    L144:
        boolean r12 = false;
    L146:
        this.mPersistentState = persistentState;
        this.taskDescription = _taskDescription;
        this.shouldDockBigOverlays = this.mWmService.mContext.getResources().getBoolean(R.bool.config_dozeAfterScreenOffByDefault);
        if (_createTime <= 0) goto L149;
        this.createTime = _createTime;
    L149:
        this.mAtmService.mPackageConfigPersister.updateConfigIfNeeded(this, this.mUserId, this.packageName);
        if (options != null) goto L152;
    L154:
        boolean appOptInTouchPassThrough = r12;
    L155:
        this.mActivityRecordInputSink = new ActivityRecordInputSink(this, sourceRecord, appOptInTouchPassThrough);
        this.mAppActivityEmbeddingSplitsEnabled = isAppActivityEmbeddingSplitsEnabled();
        this.mAllowUntrustedEmbeddingStateSharing = getAllowUntrustedEmbeddingStateSharingProperty();
        if (this.mPerf != null) goto L158;
        this.mPerf = new BoostFramework();
    L158:
        this.mOptInOnBackInvoked = WindowOnBackInvokedDispatcher.isOnBackInvokedCallbackEnabled(this.info, this.info.applicationInfo, new ActivityRecord$$ExternalSyntheticLambda26(this));
        this.mCallerState = new ActivityCallerState(this.mAtmService);
        this.mActivityRecordMonitorEx = new ActivityRecordMonitorEx(this);
        SysMonitorSvcBridge.getFactory().getAnrMonitor().notifyObjectCreate(this);
        return;
    L152:
        if (options.isAllowPassThroughOnTouchOutside() == false) goto L154;
        appOptInTouchPassThrough = r17;
        goto L155
    L143:
        r17 = true;
        goto L144
    L136:
        r11 = null;
        goto L137
    L125:
        if (options.getSceneTransitionInfo() == null) goto L129;
        if (options.getSceneTransitionInfo().getResultReceiver() == null) goto L129;
        r10 = true;
        goto L130
    L145:
        r17 = true;
        r12 = false;
        this.mHasSceneTransition = false;
        goto L146
    L119:
        r9 = ComponentName.unflattenFromString(aInfo.requestedVrComponent);
        goto L120
    L115:
        r8 = false;
        goto L116
    L106:
        if (aInfo.applicationInfo.uid == _caller.mInfo.uid) goto L107;
    L108:
        this.processName = aInfo.processName;
        goto L110
    L99:
        r16 = false;
        goto L100
    L58:
        if (style.isTranslucent() == true) goto L62;
        if (style.isFloating() == true) goto L62;
    L63:
        boolean r13 = r15;
    L65:
        this.mOccludesParent = r13;
        this.mStyleFillsParent = this.mOccludesParent;
        this.mNoDisplay = style.noDisplay();
        if (style.optOutEdgeToEdge() == true) goto L68;
    L70:
        boolean r14 = false;
    L71:
        this.mOptOutEdgeToEdge = r14;
        goto L73
    L68:
        if (PhoneWindow.isOptOutEdgeToEdgeEnabled(aInfo.applicationInfo, false) == false) goto L70;
        r14 = r15;
    L62:
        if (style.showWallpaper() == true) goto L63;
        r13 = false;
        goto L65
    L51:
        if (aInfo.applicationInfo.targetSdkVersion >= 11) goto L53;
        int r18 = R.style.Theme;
    L54:
        realTheme = r18;
        goto L55
    L53:
        r18 = R.style.Theme.Holo;
        goto L54
    L47:
        r7 = false;
        goto L48
    L43:
        r6 = false;
        goto L44
    L39:
        r5 = false;
        goto L40
    L32:
        if (this.mIsUserAlwaysVisible == true) goto L35;
        r4 = false;
        goto L36
    L26:
        if (properties.getAlwaysVisible() == false) goto L28;
        r3 = r15;
        goto L29
    L18:
        if (this.info.isChangeEnabled(327313645) == true) goto L20;
        r2 = true;
        goto L21
    L22:
        r15 = 1;
        this.mResolveConfigHint.mUseOverrideInsetsForConfig = this.info.isChangeEnabled(327313645);
        goto L23
    L5:
        if (this.info.targetActivity.equals(this.intent.getComponent().getClassName()) == true) goto L7;
    L11:
        this.mActivityComponent = new ComponentName(this.info.packageName, this.info.targetActivity);
        goto L13
    L7:
        if (this.info.launchMode == 0) goto L12;
        if (this.info.launchMode != 1) goto L11;
        goto L11
    }

    private /* synthetic */ Context lambda$new$2() {
        Context appContext = null;
        appContext = this.mAtmService.mContext.createPackageContextAsUser(this.info.packageName, 4, UserHandle.of(this.mUserId));     // Catch: PackageManager.NameNotFoundException -> L5
        appContext.setTheme(this.theme);     // Catch: PackageManager.NameNotFoundException -> L5
        return appContext;
    L6:
        return appContext;
    }

    private boolean isAppActivityEmbeddingSplitsEnabled() {
        if (WindowManager.hasWindowExtensionsEnabled() == true) goto L6;
        return false;
    L6:
        if (WindowManager.ACTIVITY_EMBEDDING_GUARD_WITH_ANDROID_15 == true) goto L8;
    L14:
        return this.mAtmService.mContext.getPackageManager().getPropertyAsUser("android.window.PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED", this.packageName, null, this.mUserId).getBoolean();
    L13:
        return false;
    L8:
        if (CompatChanges.isChangeEnabled(306666082, this.info.packageName, UserHandle.getUserHandleForUid(getUid())) == true) goto L14;
        return false;
    }

    static String computeTaskAffinity(String affinity, int uid) {
        String uidStr = Integer.toString(uid);
        if (affinity != null) goto L5;
        return affinity;
    L5:
        if (affinity.startsWith(uidStr) == false) goto L7;
        return affinity;
    L7:
        return uidStr + ":" + affinity;
    }

    static int getLockTaskLaunchMode(ActivityInfo aInfo, ActivityOptions options) {
        int lockTaskLaunchMode = aInfo.lockTaskLaunchMode;
        if (aInfo.applicationInfo.isPrivilegedApp() == false) goto L5;
    L9:
        if (options == null) goto L15;
        boolean useLockTask = options.getLockTaskMode();
        if (useLockTask == false) goto L16;
        if (lockTaskLaunchMode != 0) goto L17;
        return 3;
    L17:
        return lockTaskLaunchMode;
    L16:
        return lockTaskLaunchMode;
    L15:
        return lockTaskLaunchMode;
    L5:
        if (lockTaskLaunchMode != 2) goto L7;
    L8:
        lockTaskLaunchMode = 0;
        goto L9
    L7:
        if (lockTaskLaunchMode != 1) goto L9;
        goto L8
    }

    InputApplicationHandle getInputApplicationHandle(boolean update) {
        if (this.mInputApplicationHandle != null) goto L5;
        this.mInputApplicationHandle = new InputApplicationHandle(this.token, toString(), this.mInputDispatchingTimeoutMillis);
    L12:
        return this.mInputApplicationHandle;
    L5:
        if (update == false) goto L12;
        String name = toString();
        if (this.mInputDispatchingTimeoutMillis == this.mInputApplicationHandle.dispatchingTimeoutMillis) goto L9;
    L10:
        this.mInputApplicationHandle = new InputApplicationHandle(this.token, name, this.mInputDispatchingTimeoutMillis);
        goto L12
    L9:
        if (name.equals(this.mInputApplicationHandle.name) == true) goto L12;
        goto L10
    }

    @Override // com.android.server.wm.WindowContainer
    ActivityRecord asActivityRecord() {
        return this;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean hasActivity() {
        return true;
    }

    void setProcess(WindowProcessController proc) {
        this.app = proc;
        if (this.task == null) goto L5;
        ActivityRecord root = this.task.getRootActivity();
    L6:
        if (root != this) goto L8;
        this.task.setRootProcess(proc);
    L8:
        proc.addActivityIfNeeded(this);
        this.mInputDispatchingTimeoutMillis = ActivityTaskManagerService.getInputDispatchingTimeoutMillisLocked(this);
        TaskFragment tf = getTaskFragment();
        if (tf == null) goto L12;
        tf.sendTaskFragmentInfoChanged();
        return;
    L12:
        return;
    L5:
        root = null;
        goto L6
    }

    boolean hasProcess() {
        if (this.app == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean attachedToProcess() {
        if (hasProcess() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.app.hasThread() == false) goto L7;
        return true;
    }

    boolean attachedToProcessOrFrozen() {
        boolean isFreezing = false;
        if (this.app == null) goto L19;
        if (this.app.mName == null) goto L19;
        Object r1 = this.mAtmService.mGlobalLockWithoutBoost;
        monitor-enter(r1);
    L15:
        th = move-exception;
        throw th;
    L9:
        if (this.mAtmService.getSmtEx().getFrozenProcessController(this.app.mName, this.app.mUid) == null) goto L11;
        boolean r4 = true;
    L12:
        isFreezing = r4;
        monitor-exit(r1);     // Catch: Throwable -> L15
        goto L19
    L11:
        r4 = false;
    L19:
        if (hasProcess() == true) goto L21;
        return false;
    L21:
        if (this.app.hasThread() == true) goto L24;
        if (isFreezing == true) goto L24;
        return false;
    L24:
        return true;
    }

    private int evaluateStartingWindowTheme(ActivityRecord prev, String pkg, int originalTheme, int replaceTheme) {
        if (validateStartingWindowTheme(prev, pkg, originalTheme) == true) goto L7;
        return 0;
    L7:
        if (replaceTheme != 0) goto L9;
        return originalTheme;
    L9:
        if (validateStartingWindowTheme(prev, pkg, replaceTheme) == true) goto L11;
        return originalTheme;
    L11:
        return replaceTheme;
    }

    private boolean launchedFromSystemSurface() {
        if (this.mLaunchSourceType != 1) goto L5;
        return true;
    L5:
        if (this.mLaunchSourceType != 2) goto L7;
        return true;
    L7:
        if (this.mLaunchSourceType == 3) goto L13;
        return false;
    L13:
        return true;
    }

    boolean isLaunchSourceType(int type) {
        if (this.mLaunchSourceType != type) goto L5;
        return true;
    L5:
        return false;
    }

    void updateLaunchSourceType(int launchFromUid, WindowProcessController caller) {
        this.mLaunchSourceType = determineLaunchSourceType(launchFromUid, caller);
    }

    private int determineLaunchSourceType(int launchFromUid, WindowProcessController caller) {
        if (launchFromUid == 1000) goto L17;
        if (launchFromUid == 0) goto L20;
        if (caller != null) goto L8;
        return 4;
    L8:
        if (caller.isHomeProcess() == false) goto L12;
        return 2;
    L12:
        if (this.mAtmService.getSysUiServiceComponentLocked().getPackageName().equals(caller.mInfo.packageName) == false) goto L19;
        return 3;
    L19:
        return 4;
    L20:
        return 1;
    L17:
        return 1;
    }

    private boolean validateStartingWindowTheme(ActivityRecord prev, String pkg, int theme) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L6;
        long protoLogParam0 = theme;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, 338586566486930495L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L6:
        if (theme != 0) goto L9;
        return false;
    L9:
        if (theme != this.theme) goto L11;
        WindowStyle style = this.mWindowStyle;
    L12:
        if (style != null) goto L14;
        return false;
    L14:
        boolean windowIsTranslucent = style.isTranslucent();
        boolean windowIsFloating = style.isFloating();
        boolean windowShowWallpaper = style.showWallpaper();
        boolean windowDisableStarting = style.disablePreview();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L18;
        String protoLogParam1 = String.valueOf(windowIsTranslucent);
        String protoLogParam2 = String.valueOf(windowIsFloating);
        String protoLogParam3 = String.valueOf(windowShowWallpaper);
        String protoLogParam4 = String.valueOf(windowDisableStarting);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, -2561793317091789573L, 0, new Object[]{protoLogParam1, protoLogParam2, protoLogParam3, protoLogParam4});
    L18:
        if (windowIsTranslucent == true) goto L21;
        if (windowIsFloating == true) goto L21;
    L24:
        if (windowShowWallpaper == true) goto L26;
    L28:
        if (windowDisableStarting == true) goto L30;
        return true;
    L30:
        if (launchedFromSystemSurface() == true) goto L48;
        if (prev == null) goto L44;
        if (prev.getActivityType() != 1) goto L44;
        if (prev.mTransferringSplashScreenState != 0) goto L44;
        if (prev.mStartingData == null) goto L39;
    L42:
        return true;
    L39:
        if (prev.mStartingWindow == null) goto L44;
        if (prev.mStartingSurface != null) goto L42;
    L44:
        return false;
    L48:
        return true;
    L26:
        if (getDisplayContent().mWallpaperController.getWallpaperTarget() == null) goto L28;
        return false;
    L21:
        if (this.mExt.shouldAddStartingForTranslucent() == true) goto L24;
        this.translucentWindowLaunch = true;
        return false;
    L11:
        style = this.mAtmService.getWindowStyle(pkg, theme, this.mUserId);
        goto L12
    }

    boolean addStartingWindow(String pkg, int resolvedTheme, ActivityRecord from, boolean newTask, boolean taskSwitch, boolean processRunning, boolean allowTaskSnapshot, boolean activityCreated, boolean isSimple, boolean activityAllDrawn) {
        if (okToDisplay() == true) goto L6;
        return false;
    L6:
        if (hasStartingWindow() == false) goto L8;
        return false;
    L8:
        WindowState mainWin = findMainWindow(false);
        if (SysMonitorFwBridge.getFactory().getPrefetchState().prefetchNotReadyThenStart(getTask().prefetchState) == false) goto L11;
        getTask().prefetchState |= 131072;
        boolean parallelStartWithPrefetch = true;
    L12:
        if (mainWin != null) goto L14;
    L17:
        TaskSnapshot snapshot = this.mWmService.mTaskSnapshotController.getSnapshot(this.task.mTaskId, false);
        if (this.mExt.shouldBlockAddStartingWindow(snapshot) == false) goto L21;
        return false;
    L21:
        if (this.mWmService.getObricExt().shouldBlockAddStartingWindow(this) == false) goto L23;
        return false;
    L23:
        int type = getStartingWindowType(newTask, taskSwitch, processRunning, allowTaskSnapshot, activityCreated, activityAllDrawn, snapshot);
        boolean isBackgroundKilledApp = false;
        if (this.mWmService.mTaskSnapshotController.hasBackgroundKilledAppInfo(getUid(), this.mUserId) == false) goto L29;
        TaskSnapshot backgroundKilledAppSnapshot = this.mWmService.mTaskSnapshotController.getBackgroundKilledAppSnapshot(getUid(), this.mUserId);
        if (backgroundKilledAppSnapshot == null) goto L29;
        snapshot = backgroundKilledAppSnapshot;
        isBackgroundKilledApp = true;
        this.mWmService.mTaskSnapshotController.removeBackgroundKilledAppInfo(getUid(), this.mUserId);
    L29:
        if (type == 2) goto L31;
    L33:
        boolean useLegacy = false;
    L35:
        if (processRunning == false) goto L38;
        if (parallelStartWithPrefetch == true) goto L38;
        boolean r15 = true;
    L39:
        int typeParameter = StartingSurfaceController.makeStartingWindowTypeParameter(newTask, taskSwitch, r15, allowTaskSnapshot, activityCreated, isSimple, useLegacy, activityAllDrawn, type, isIconStylePreferred(resolvedTheme), this.packageName, this.mUserId);
        if (type != 1) goto L56;
        if (this.mExt.shouldCreateSnapshot(pkg, taskSwitch, snapshot) == true) goto L45;
        return false;
    L45:
        if (isActivityTypeHome() == false) goto L54;
        Transition transition = this.mTransitionController.getCollectingTransition();
        if (transition != null) goto L49;
    L52:
        snapshot.addReference(16);
        this.mWmService.mTaskSnapshotController.removeSnapshotCache(this.task.mTaskId);
        goto L54
    L49:
        if ((2 & transition.getFlags()) != 0) goto L52;
        this.mWmService.mTaskSnapshotController.removeSnapshotCache(this.task.mTaskId);
        return false;
    L54:
        return createSnapshot(snapshot, typeParameter);
    L56:
        if (resolvedTheme == 0) goto L58;
    L60:
        if (from != null) goto L62;
    L64:
        if (type == 2) goto L67;
        return false;
    L67:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L69;
        boolean r16 = true;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, 7269690012594027154L, 0, null);
    L70:
        if (isBackgroundKilledApp == true) goto L72;
        snapshot = null;
    L72:
        this.mStartingData = new SplashScreenStartingData(this.mWmService, resolvedTheme, typeParameter, snapshot);
        scheduleAddStartingWindow();
        this.mAtmService.mH.removeCallbacks(this.mRemoveStartWindowTimeoutRunnable);
        if (processRunning == false) goto L76;
        this.mAtmService.mH.postDelayed(this.mRemoveStartWindowTimeoutRunnable, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
    L76:
        return r16;
    L69:
        r16 = true;
        goto L70
    L62:
        if (transferStartingWindow(from) == false) goto L64;
        return true;
    L58:
        if (this.theme == 0) goto L60;
        return false;
    L38:
        r15 = false;
        goto L39
    L31:
        if (this.mWmService.mStartingSurfaceController.isExceptionApp(this.packageName, this.mTargetSdk, new ActivityRecord$$ExternalSyntheticLambda20(this)) == false) goto L33;
        useLegacy = true;
        goto L35
    L14:
        if (mainWin.isDrawn() == false) goto L17;
        if (parallelStartWithPrefetch == true) goto L17;
        return false;
    L11:
        parallelStartWithPrefetch = false;
        goto L12
    }

    private /* synthetic */ ApplicationInfo lambda$addStartingWindow$3() {
        ActivityInfo activityInfo = this.intent.resolveActivityInfo(this.mAtmService.mContext.getPackageManager(), 128);
        if (activityInfo != null) goto L7;
        return null;
    L7:
        return activityInfo.applicationInfo;
    }

    private boolean createSnapshot(TaskSnapshot snapshot, int typeParams) {
        if (snapshot != null) goto L6;
        return false;
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L8;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, -3432060893368468911L, 0, null);
    L8:
        this.mStartingData = new SnapshotStartingData(this.mWmService, snapshot, typeParams);
        if (this.mStyleFillsParent == true) goto L13;
        if (this.task.getChildCount() <= 1) goto L13;
    L14:
        associateStartingDataWithTask();
    L15:
        scheduleAddStartingWindow();
        return true;
    L13:
        if (this.task.forAllLeafTaskFragments(new ActivityRecord$$ExternalSyntheticLambda7()) == false) goto L15;
        goto L14
    }

    private void scheduleAddStartingWindow() {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L5;
        String protoLogParam0 = String.valueOf(this);
        String protoLogParam1 = String.valueOf(this.mStartingData);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, 5659016061937922595L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L5:
        getExt().traceAddStartingWindow(this, this.mStartingData);
        this.mStartingSurface = this.mStartingData.createStartingSurface(this);
        if (this.mStartingSurface == null) goto L11;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L14;
        String protoLogParam2 = String.valueOf(this);
        String protoLogParam3 = String.valueOf(this.mStartingWindow);
        String protoLogParam4 = String.valueOf(this.mStartingSurface);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, 7506106334102501360L, 0, new Object[]{protoLogParam2, protoLogParam3, protoLogParam4});
        return;
    L14:
        return;
    L11:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L16;
        String protoLogParam5 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, 1048048288756547220L, 0, new Object[]{protoLogParam5});
        return;
    }

    private int getStartingWindowType(boolean newTask, boolean taskSwitch, boolean processRunning, boolean allowTaskSnapshot, boolean activityCreated, boolean activityAllDrawn, TaskSnapshot snapshot) {
        this.mExt.traceGetStartingWindowType(newTask, taskSwitch, processRunning, allowTaskSnapshot, activityCreated, activityAllDrawn, snapshot, this.mOccludesParent);
        if (this.mExt.shouldUseSplashScreen(this.intent) == false) goto L6;
        return 2;
    L6:
        if (newTask == true) goto L23;
        if (taskSwitch == false) goto L23;
        if (activityCreated == true) goto L23;
        if (this.task.intent == null) goto L23;
        if (this.mOccludesParent == true) goto L14;
    L15:
        ActivityRecord topAttached = this.task.getActivity(new ActivityRecord$$ExternalSyntheticLambda4());
        if (topAttached == null) goto L23;
        if (topAttached.isSnapshotCompatible(snapshot) == true) goto L20;
    L22:
        return 0;
    L20:
        if (this.mDisplayContent.getDisplayRotation().rotationForOrientation(getOverrideOrientation(), this.mDisplayContent.getRotation()) != snapshot.getRotation()) goto L22;
        return 1;
    L14:
        if (this.mActivityComponent.equals(this.task.intent.getComponent()) == true) goto L15;
    L23:
        boolean isActivityHome = isActivityTypeHome();
        if (newTask == true) goto L28;
        if (processRunning == false) goto L28;
        if (taskSwitch == false) goto L30;
        if (activityCreated == false) goto L28;
    L30:
        if (taskSwitch == false) goto L56;
        if (allowTaskSnapshot == false) goto L43;
        WindowState mainWin = findMainWindow();
        if (mainWin == null) goto L39;
        if ((mainWin.mAttrs.getExt().getPrivateFlags() & 1) == 0) goto L39;
        Slog.i("WindowManager", "ignore wrong snapshot of in call screen or others");
        return 0;
    L39:
        if (isSnapshotCompatible(snapshot) == false) goto L41;
        return 1;
    L41:
        if (isActivityHome == true) goto L43;
        return 2;
    L43:
        if (activityAllDrawn == true) goto L56;
        if (isActivityHome == true) goto L56;
        if (this.task.mTaskFragmentHostProcessName == null) goto L54;
        Task prevTask = this.task.getParent().getTaskBelow(this.task);
        if (prevTask == null) goto L54;
        ActivityRecord prevTaskTop = prevTask.getTopMostActivity();
        if (prevTaskTop == null) goto L54;
        if (prevTaskTop.hasStartingWindow() == false) goto L54;
        return 0;
    L54:
        return 2;
    L56:
        if (this.mExt.shouldAddStartingForTranslucent() == false) goto L58;
        return 2;
    L58:
        return 0;
    L28:
        if (isActivityHome == true) goto L30;
        return 2;
    }

    boolean isSnapshotCompatible(TaskSnapshot snapshot) {
        if (snapshot != null) goto L6;
        return false;
    L6:
        if (isSnapshotComponentCompatible(snapshot) == true) goto L8;
        return false;
    L8:
        if (isSnapshotOrientationCompatible(snapshot) == false) goto L12;
        return true;
    L12:
        return false;
    }

    boolean isSnapshotComponentCompatible(TaskSnapshot snapshot) {
        return snapshot.getTopActivityComponent().equals(this.mActivityComponent);
    }

    boolean isSnapshotOrientationCompatible(TaskSnapshot snapshot) {
        int rotation = this.mDisplayContent.rotationForActivityInDifferentOrientation(this);
        int currentRotation = this.task.getWindowConfiguration().getRotation();
        if (rotation == (-1)) goto L5;
        int targetRotation = rotation;
    L7:
        if (snapshot.getRotation() == targetRotation) goto L9;
        return false;
    L9:
        Rect taskBounds = this.task.getBounds();
        int w = taskBounds.width();
        int h = taskBounds.height();
        Point taskSize = snapshot.getTaskSize();
        if ((Math.abs(currentRotation - targetRotation) % 2) != 1) goto L12;
        w = h;
        h = w;
    L12:
        int t = taskSize.x;
        if (Math.abs((t / Math.max(taskSize.y, 1)) - (w / Math.max(h, 1))) <= 0.01f) goto L15;
        return false;
    L15:
        return true;
    L5:
        targetRotation = currentRotation;
        goto L7
    }

    void setCustomizeSplashScreenExitAnimation(boolean enable) {
        if (this.mHandleExitSplashScreen != enable) goto L5;
        return;
    L5:
        this.mHandleExitSplashScreen = enable;
    }

    private void scheduleTransferSplashScreenTimeout() {
        this.mAtmService.mH.postDelayed(this.mTransferSplashScreenTimeoutRunnable, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);
    }

    private void removeTransferSplashScreenTimeout() {
        this.mAtmService.mH.removeCallbacks(this.mTransferSplashScreenTimeoutRunnable);
    }

    private boolean transferSplashScreenIfNeeded() {
        if (this.finishing == false) goto L5;
        return false;
    L5:
        if (this.mHandleExitSplashScreen == true) goto L7;
        return false;
    L7:
        if (this.mStartingSurface != null) goto L9;
        return false;
    L9:
        if (this.mStartingWindow != null) goto L11;
        return false;
    L11:
        if (this.mTransferringSplashScreenState != 3) goto L13;
        return false;
    L13:
        if (this.mStartingData == null) goto L19;
        if (this.mStartingData.mResizedFromTransfer == false) goto L17;
        return false;
    L17:
        if (this.mStartingData.mRemoveAfterTransaction != 1) goto L19;
        return false;
    L19:
        if (isRelaunching() == false) goto L22;
        return false;
    L22:
        if (isTransferringSplashScreen() == false) goto L25;
        return true;
    L25:
        if (this.mStartingData != null) goto L27;
    L30:
        requestCopySplashScreen();
        return isTransferringSplashScreen();
    L27:
        if (getSyncTransactionCommitCallbackDepth() <= 0) goto L30;
        this.mStartingData.mRemoveAfterTransaction = 2;
        return true;
    }

    private boolean isTransferringSplashScreen() {
        if (this.mTransferringSplashScreenState != 2) goto L5;
        return true;
    L5:
        if (this.mTransferringSplashScreenState == 1) goto L10;
        return false;
    L10:
        return true;
    }

    private void requestCopySplashScreen() {
        this.mTransferringSplashScreenState = 1;
        if (this.mStartingSurface != null) goto L5;
    L6:
        this.mTransferringSplashScreenState = 3;
        removeStartingWindow();
    L7:
        scheduleTransferSplashScreenTimeout();
        return;
    L5:
        if (this.mAtmService.mTaskOrganizerController.copySplashScreenView(getTask(), this.mStartingSurface.mTaskOrganizer) == true) goto L7;
        goto L6
    }

    void onCopySplashScreenFinish(SplashScreenView.SplashScreenViewParcelable parcelable) {
        removeTransferSplashScreenTimeout();
        if (parcelable != null) goto L5;
    L16:
        SurfaceControl windowAnimationLeash = null;
    L18:
        if (windowAnimationLeash != null) goto L23;
        if (parcelable == null) goto L21;
        parcelable.clearIfNeeded();
    L21:
        this.mTransferringSplashScreenState = 3;
        removeStartingWindow();
        return;
    L23:
        this.mTransferringSplashScreenState = 2;
        boolean isSuccessful = this.mAtmService.getLifecycleManager().scheduleTransactionItem(this.app.getThread(), new TransferSplashScreenViewStateItem(this.token, parcelable, windowAnimationLeash));     // Catch: RemoteException -> L26
    L28:
        if (isSuccessful == false) goto L30;
        scheduleTransferSplashScreenTimeout();
        return;
    L30:
        this.mStartingWindow.cancelAnimation();
        parcelable.clearIfNeeded();
        this.mTransferringSplashScreenState = 3;
        return;
    L27:
        Slog.w("ActivityTaskManager", "onCopySplashScreenComplete fail: " + this);
        isSuccessful = false;
        goto L28
    L5:
        if (this.mTransferringSplashScreenState != 1) goto L16;
        if (this.mStartingWindow == null) goto L16;
        if (this.mStartingWindow.mRemoved == true) goto L16;
        if (this.finishing == true) goto L16;
        if (this.app == null) goto L16;
        windowAnimationLeash = TaskOrganizerController.applyStartingWindowAnimation(this.mStartingWindow);
        goto L18
    }

    private void onSplashScreenAttachComplete() {
        removeTransferSplashScreenTimeout();
        if (this.mStartingWindow == null) goto L5;
        this.mStartingWindow.cancelAnimation();
        this.mStartingWindow.hide(false, false);
    L5:
        this.mTransferringSplashScreenState = 3;
        removeStartingWindowAnimation(false);
    }

    void cleanUpSplashScreen() {
        if (this.mHandleExitSplashScreen == true) goto L5;
        return;
    L5:
        if (this.startingMoved == false) goto L7;
        return;
    L7:
        if (this.mTransferringSplashScreenState == 3) goto L11;
        if (this.mTransferringSplashScreenState == 0) goto L11;
        return;
    L11:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L13;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, -1298801500610545721L, 0, new Object[]{protoLogParam0});
    L13:
        TaskOrganizerController r0 = this.mAtmService.mTaskOrganizerController;
        Task r1 = getTask();
        if (this.mStartingSurface == null) goto L16;
        ITaskOrganizer r2 = this.mStartingSurface.mTaskOrganizer;
    L17:
        r0.onAppSplashScreenViewRemoved(r1, r2);
        return;
    L16:
        r2 = null;
        goto L17
    }

    boolean isStartingWindowDisplayed() {
        if (this.mStartingData == null) goto L6;
        StartingData data = this.mStartingData;
    L10:
        if (data != null) goto L12;
    L14:
        return false;
    L12:
        if (data.mIsDisplayed == false) goto L14;
        return true;
    L6:
        if (this.task == null) goto L8;
        data = this.task.mSharedStartingData;
        goto L10
    L8:
        data = null;
        goto L10
    }

    void attachStartingWindow(WindowState startingWindow) {
        startingWindow.mStartingData = this.mStartingData;
        this.mStartingWindow = startingWindow;
        if (this.mStartingData != null) goto L5;
        return;
    L5:
        if (this.mStartingData.mAssociatedTask == null) goto L10;
        if (hasFixedRotationTransform() == true) goto L13;
        attachStartingSurfaceToAssociatedTask();
    L13:
        if (this.mTransitionController.isCollecting() == false) goto L17;
        StartingData r0 = this.mStartingData;
        r0.mTransitionId = this.mTransitionController.getCollectingTransitionId();
        return;
    L17:
        return;
    L10:
        if (isEmbedded() == false) goto L13;
        associateStartingWindowWithTaskIfNeeded();
        goto L13
    }

    private void attachStartingSurfaceToAssociatedTask() {
        this.mTransitionController.collect(this.mStartingWindow);
        WindowContainer.overrideConfigurationPropagation(this.mStartingWindow, this.mStartingData.mAssociatedTask);
        this.mStartingWindow.getSyncTransaction().reparent(this.mStartingWindow.mSurfaceControl, this.mStartingData.mAssociatedTask.mSurfaceControl);
    }

    private void associateStartingDataWithTask() {
        StartingData r0 = this.mStartingData;
        r0.mAssociatedTask = this.task;
        Task r1 = this.task;
        r1.mSharedStartingData = this.mStartingData;
    }

    void associateStartingWindowWithTaskIfNeeded() {
        if (this.mStartingWindow != null) goto L5;
        return;
    L5:
        if (this.mStartingData != null) goto L7;
        return;
    L7:
        if (this.mStartingData.mAssociatedTask == null) goto L10;
        return;
    L10:
        if (this.task.isVisible() == true) goto L12;
    L14:
        associateStartingDataWithTask();
        attachStartingSurfaceToAssociatedTask();
        return;
    L12:
        if (this.task.inTransition() == true) goto L14;
    }

    void deferStartingWindowRemovalForKeyguardUnoccluding() {
        if (this.mStartingData != null) goto L5;
        return;
    L5:
        if (this.mStartingData.mRemoveAfterTransaction != 3) goto L7;
        return;
    L7:
        if (isKeyguardLocked() == true) goto L9;
        return;
    L9:
        if (canShowWhenLockedInner(this) == false) goto L11;
        return;
    L11:
        if (isVisibleRequested() == false) goto L13;
        return;
    L13:
        if (this.mTransitionController.inTransition(this) == false) goto L21;
        this.mStartingData.mRemoveAfterTransaction = 3;
        return;
    }

    void removeStartingWindow() {
        AppCompatLetterboxPolicy letterboxPolicy = this.mAppCompatController.getLetterboxPolicy();
        boolean prevEligibleForLetterboxEducation = letterboxPolicy.isEligibleForLetterboxEducation();
        if (this.mStartingData == null) goto L8;
        if (this.mStartingData.mRemoveAfterTransaction != 3) goto L8;
        return;
    L8:
        if (transferSplashScreenIfNeeded() == false) goto L10;
        return;
    L10:
        removeStartingWindowAnimation(true);
        Task task = getTask();
        if (task != null) goto L13;
        return;
    L13:
        if (prevEligibleForLetterboxEducation == letterboxPolicy.isEligibleForLetterboxEducation()) goto L17;
        task.dispatchTaskInfoChangedIfNeeded(true);
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    void onSyncTransactionCommitted(SurfaceControl.Transaction t) {
        super.onSyncTransactionCommitted(t);
        if (this.mStartingData != null) goto L5;
        return;
    L5:
        StartingData lastData = this.mStartingData;
        if (lastData.mRemoveAfterTransaction != 1) goto L9;
        removeStartingWindowAnimation(lastData.mPrepareRemoveAnimation);
        return;
    L9:
        if (lastData.mRemoveAfterTransaction != 2) goto L13;
        removeStartingWindow();
        return;
    }

    void removeStartingWindowAnimation(boolean prepareAnimation) {
        this.mTransferringSplashScreenState = 0;
        this.mAtmService.mH.removeCallbacks(this.mRemoveStartWindowTimeoutRunnable);
        if (this.mStartingData == null) goto L8;
        if (this.task == null) goto L8;
        this.task.mSharedStartingData = null;
    L8:
        if (this.mStartingWindow != null) goto L17;
        if (this.mStartingData != null) goto L12;
        return;
    L12:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L14;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, -1948849214526113495L, 0, new Object[]{protoLogParam0});
    L14:
        getExt().traceClearStartingData(this);
        this.mStartingData = null;
        this.mStartingSurface = null;
        return;
    L17:
        if (this.mStartingData == null) goto L44;
        if (getSyncTransactionCommitCallbackDepth() <= 0) goto L21;
    L41:
        this.mStartingData.mRemoveAfterTransaction = 1;
        this.mStartingData.mPrepareRemoveAnimation = prepareAnimation;
        return;
    L21:
        if (this.mSyncState != 0) goto L41;
        if (prepareAnimation == true) goto L25;
    L29:
        boolean animate = false;
    L30:
        boolean hasImeSurface = this.mStartingData.hasImeSurface();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L33;
        String protoLogParam1 = String.valueOf(this);
        String protoLogParam2 = String.valueOf(this.mStartingWindow);
        boolean protoLogParam3 = animate;
        String protoLogParam4 = String.valueOf(Debug.getCallers(5));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, 5545923784327902026L, 48, new Object[]{protoLogParam1, protoLogParam2, Boolean.valueOf(protoLogParam3), protoLogParam4});
    L33:
        getExt().traceScheduleRemoveStartingWindow(this.mStartingWindow);
        StartingSurfaceController.StartingSurface surface = this.mStartingSurface;
        this.mStartingData = null;
        this.mStartingSurface = null;
        this.mStartingWindow = null;
        this.mTransitionChangeFlags &= -9;
        if (surface == null) goto L36;
        surface.remove(animate, hasImeSurface);
        return;
    L36:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L49;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, -5150982660941074218L, 0, null);
        return;
    L49:
        return;
    L25:
        if (this.mStartingData.needRevealAnimation() == false) goto L29;
        if (this.mStartingWindow.isVisibleByPolicy() == false) goto L29;
        animate = true;
        goto L30
    L44:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L46;
        String protoLogParam5 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, -2178757341169633804L, 0, new Object[]{protoLogParam5});
    L46:
        getExt().traceRemoveStartingWindowNull(this);
    }

    void reparent(TaskFragment newTaskFrag, int position, String reason) {
        if (getParent() != null) goto L6;
        Slog.w("ActivityTaskManager", "reparent: Attempted to reparent non-existing app token: " + this.token);
        return;
    L6:
        TaskFragment prevTaskFrag = getTaskFragment();
        if (prevTaskFrag == newTaskFrag) goto L14;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[2] == false) goto L11;
        String protoLogParam0 = String.valueOf(this);
        long protoLogParam1 = this.task.mTaskId;
        long protoLogParam2 = position;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 5521236266092347335L, 20, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), Long.valueOf(protoLogParam2)});
    L11:
        reparent(newTaskFrag, position);
        return;
    L14:
        throw new IllegalArgumentException(reason + ": task fragment =" + newTaskFrag + " is already the parent of r=" + this);
    }

    static boolean isHomeIntent(Intent intent) {
        if ("android.intent.action.MAIN".equals(intent.getAction()) == true) goto L5;
    L15:
        return false;
    L5:
        if (intent.hasCategory("android.intent.category.HOME") == true) goto L9;
        if (intent.hasCategory("android.intent.category.SECONDARY_HOME") == false) goto L15;
    L9:
        if (intent.getCategories().size() != 1) goto L15;
        if (intent.getData() != null) goto L15;
        if (intent.getType() != null) goto L15;
        return true;
    }

    static boolean isMainIntent(Intent intent) {
        if ("android.intent.action.MAIN".equals(intent.getAction()) == true) goto L5;
    L13:
        return false;
    L5:
        if (intent.hasCategory("android.intent.category.LAUNCHER") == false) goto L13;
        if (intent.getCategories().size() != 1) goto L13;
        if (intent.getData() != null) goto L13;
        if (intent.getType() != null) goto L13;
        return true;
    }

    boolean canLaunchHomeActivity(int uid, ActivityRecord sourceRecord) {
        if (uid == 1000) goto L17;
        if (uid == 0) goto L17;
        RecentTasks recentTasks = this.mTaskSupervisor.mService.getRecentTasks();
        if (recentTasks != null) goto L9;
    L11:
        if (sourceRecord != null) goto L13;
    L15:
        return false;
    L13:
        if (sourceRecord.isResolverOrDelegateActivity() == false) goto L15;
        return true;
    L9:
        if (recentTasks.isCallerRecents(uid) == false) goto L11;
        return true;
    L17:
        return true;
    }

    private boolean canLaunchAssistActivity(String packageName) {
        ComponentName assistComponent = this.mAtmService.mActiveVoiceInteractionServiceComponent;
        if (assistComponent != null) goto L5;
        return false;
    L5:
        return assistComponent.getPackageName().equals(packageName);
    }

    private void setActivityType(boolean componentSpecified, int launchedFromUid, Intent intent, ActivityOptions options, ActivityRecord sourceRecord) {
        int activityType = 0;
        if (componentSpecified == false) goto L7;
        if (canLaunchHomeActivity(launchedFromUid, sourceRecord) == true) goto L7;
    L16:
        if (this.mAtmService.getRecentTasks().isRecentsComponent(this.mActivityComponent, this.info.applicationInfo.uid) == false) goto L18;
        activityType = 3;
    L32:
        setActivityType(activityType);
        return;
    L18:
        if (options != null) goto L20;
    L24:
        if (options == null) goto L32;
        if (options.getLaunchActivityType() != 5) goto L32;
        if (this.mAtmService.canLaunchDreamActivity(this.launchedFromPackage) == false) goto L32;
        if (DreamActivity.class.getName() != this.info.name) goto L32;
        activityType = 5;
        goto L32
    L20:
        if (options.getLaunchActivityType() != 4) goto L24;
        if (canLaunchAssistActivity(this.launchedFromPackage) == false) goto L24;
        activityType = 4;
    L7:
        if (isHomeIntent(intent) == false) goto L16;
        if (isResolverOrDelegateActivity() == true) goto L16;
        activityType = 2;
        if (this.info.resizeMode != 4) goto L13;
    L14:
        this.info.resizeMode = 0;
        goto L32
    L13:
        if (this.info.resizeMode != 1) goto L32;
        goto L14
    }

    void setTaskToAffiliateWith(Task taskToAffiliateWith) {
        if (this.launchMode != 3) goto L5;
        return;
    L5:
        if (this.launchMode == 2) goto L9;
        this.task.setTaskToAffiliateWith(taskToAffiliateWith);
        return;
    }

    Task getRootTask() {
        if (this.task != null) goto L7;
        return null;
    L7:
        return this.task.getRootTask();
    }

    int getRootTaskId() {
        if (this.task != null) goto L7;
        return -1;
    L7:
        return this.task.getRootTaskId();
    }

    Task getOrganizedTask() {
        if (this.task != null) goto L7;
        return null;
    L7:
        return this.task.getOrganizedTask();
    }

    TaskFragment getOrganizedTaskFragment() {
        TaskFragment parent = getTaskFragment();
        if (parent != null) goto L7;
        return null;
    L7:
        return parent.getOrganizedTaskFragment();
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isEmbedded() {
        TaskFragment parent = getTaskFragment();
        if (parent != null) goto L5;
    L7:
        return false;
    L5:
        if (parent.isEmbedded() == false) goto L7;
        return true;
    }

    boolean isUntrustedEmbeddingStateSharingAllowed() {
        return this.mAllowUntrustedEmbeddingStateSharing;
    }

    private boolean getAllowUntrustedEmbeddingStateSharingProperty() {
        return this.mAtmService.mContext.getPackageManager().getPropertyAsUser("android.window.PROPERTY_ALLOW_UNTRUSTED_ACTIVITY_EMBEDDING_STATE_SHARING", this.mActivityComponent.getPackageName(), this.mActivityComponent.getClassName(), this.mUserId).getBoolean();
    L5:
        return false;
    }

    boolean isEmbeddedInHostContainer() {
        TaskFragment taskFragment = getOrganizedTaskFragment();
        if (taskFragment != null) goto L5;
    L7:
        return false;
    L5:
        if (taskFragment.isEmbeddedWithBoundsOverride() == false) goto L7;
        return true;
    }

    ActivityWindowInfo getActivityWindowInfo() {
        if (isAttached() == true) goto L7;
        return this.mTmpActivityWindowInfo;
    L7:
        if (isFixedRotationTransforming() == false) goto L9;
        Rect bounds = getBounds();
        this.mTmpActivityWindowInfo.set(false, bounds, bounds);
    L11:
        return this.mTmpActivityWindowInfo;
    L9:
        this.mTmpActivityWindowInfo.set(isEmbeddedInHostContainer(), getTask().getBounds(), getTaskFragment().getBounds());
        goto L11
    }

    @Override // com.android.server.wm.WindowContainer
    TaskDisplayArea getDisplayArea() {
        return (TaskDisplayArea) super.getDisplayArea();
    }

    @Override // com.android.server.wm.WindowContainer
    boolean providesOrientation() {
        if (this.mStyleFillsParent == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mOccludesParent == true) goto L8;
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean fillsParent() {
        return occludesParent(true);
    }

    boolean isNoDisplay() {
        return this.mNoDisplay;
    }

    void setIsNoDisplay(boolean isNoDisplay) {
        this.mNoDisplay = isNoDisplay;
    }

    boolean occludesParent() {
        return occludesParent(false);
    }

    boolean occludesParent(boolean includingFinishing) {
        if (includingFinishing == true) goto L8;
        if (this.finishing == false) goto L8;
        return false;
    L8:
        if (this.mOccludesParent == false) goto L10;
    L11:
        return true;
    L10:
        if (showWallpaper() == true) goto L11;
        return false;
    }

    boolean setOccludesParent(boolean occludesParent) {
        if (occludesParent == this.mOccludesParent) goto L5;
        boolean changed = true;
    L6:
        this.mOccludesParent = occludesParent;
        setMainWindowOpaque(occludesParent);
        if (changed == true) goto L9;
    L13:
        if (changed == true) goto L15;
        if (occludesParent == false) goto L15;
    L16:
        return changed;
    L15:
        this.mRootWindowContainer.ensureActivitiesVisible();
        goto L16
    L9:
        if (this.task == null) goto L13;
        if (occludesParent == true) goto L12;
        getRootTask().convertActivityToTranslucent(this);
        goto L13
    L12:
        getRootTask().convertActivityFromTranslucent(this);
        goto L13
    L5:
        changed = false;
        goto L6
    }

    void setMainWindowOpaque(boolean isOpaque) {
        WindowState win = findMainWindow();
        if (win != null) goto L5;
        return;
    L5:
        win.mWinAnimator.setOpaqueLocked(isOpaque & (!PixelFormat.formatHasAlpha(win.mAttrs.format)));
    }

    void takeFromHistory() {
        if (this.inHistory == false) goto L11;
        this.inHistory = false;
        if (this.task != null) goto L7;
    L9:
        abortAndClearOptionsAnimation();
        return;
    L7:
        if (this.finishing == true) goto L9;
        this.task = null;
        goto L9
    }

    boolean isInHistory() {
        return this.inHistory;
    }

    boolean isInRootTaskLocked() {
        Task rootTask = getRootTask();
        if (rootTask != null) goto L5;
    L7:
        return false;
    L5:
        if (rootTask.isInTask(this) == null) goto L7;
        return true;
    }

    boolean isPersistable() {
        if (this.info.persistableMode == 0) goto L7;
        if (this.info.persistableMode == 2) goto L7;
    L11:
        return false;
    L7:
        if (this.intent != null) goto L9;
    L12:
        return true;
    L9:
        if ((this.intent.getFlags() & 8388608) != 0) goto L11;
        goto L11
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isFocusable() {
        if (super.isFocusable() == true) goto L5;
    L9:
        return false;
    L5:
        if (canReceiveKeys() == false) goto L7;
    L8:
        return true;
    L7:
        if (isAlwaysFocusable() == false) goto L9;
        goto L8
    }

    boolean canReceiveKeys() {
        if (getWindowConfiguration().canReceiveKeys() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mWaitForEnteringPinnedMode == true) goto L7;
        return true;
    }

    private boolean isRestrictedFixedOrientation(int orientation) {
        if (orientation != 14) goto L5;
    L9:
        return false;
    L5:
        if (ActivityInfo.isFixedOrientation(orientation) == false) goto L9;
        if (isUniversalResizeable() == false) goto L9;
        return true;
    }

    boolean isUniversalResizeable() {
        if (this.mDisplayContent != null) goto L5;
    L9:
        boolean isLargeScreen = false;
    L11:
        if (canBeUniversalResizeable(this.info.applicationInfo, this.mWmService, isLargeScreen, true) == true) goto L14;
        return false;
    L14:
        if (this.mAppCompatController.getResizeOverrides().allowRestrictedResizability() == false) goto L17;
        return false;
    L17:
        return this.mAppCompatController.getAspectRatioOverrides().userPreferenceCompatibleWithNonResizability();
    L5:
        if (this.mDisplayContent.isLargeScreen() == false) goto L9;
        if (this.mDisplayContent.getIgnoreOrientationRequest() == false) goto L9;
        isLargeScreen = true;
        goto L11
    }

    static boolean canBeUniversalResizeable(ApplicationInfo appInfo, WindowManagerService wms, boolean isLargeScreen, boolean forActivity) {
        if (appInfo.category != 0) goto L6;
        return false;
    L6:
        if (isLargeScreen == true) goto L8;
    L10:
        boolean compatEnabled = false;
    L11:
        WindowManagerConstants r3 = wms.mConstants;
        if (isLargeScreen == false) goto L17;
        if (r3.mIgnoreActivityOrientationRequestLargeScreen == true) goto L20;
    L22:
        boolean configEnabled = false;
    L24:
        if (compatEnabled == true) goto L27;
        if (configEnabled == true) goto L27;
        return false;
    L27:
        if (forActivity == false) goto L30;
        return true;
    L30:
        return true ^ AppCompatResizeOverrides.allowRestrictedResizability(wms.mContext.getPackageManager(), appInfo.packageName, UserHandle.getUserId(appInfo.uid));
    L20:
        if (wms.mConstants.isPackageOptOutIgnoreActivityOrientationRequest(appInfo.packageName) == true) goto L22;
        configEnabled = true;
        goto L24
    L17:
        if (r3.mIgnoreActivityOrientationRequestSmallScreen == false) goto L22;
    L8:
        if (appInfo.isChangeEnabled(357141415) == false) goto L10;
        compatEnabled = true;
        goto L11
    }

    boolean isResizeable() {
        if (this.mAtmService.mForceResizableActivities == false) goto L5;
    L16:
        return true;
    L5:
        if (getExt().forceResizeable() == true) goto L16;
        if (ActivityInfo.isResizeableMode(this.info.resizeMode) == true) goto L16;
        if (this.info.supportsPictureInPicture() == true) goto L16;
        if (isUniversalResizeable() == true) goto L16;
        if (isEmbedded() == true) goto L16;
        return false;
    }

    boolean canForceResizeNonResizable(int windowingMode) {
        if (windowingMode != 2) goto L8;
        if (this.info.supportsPictureInPicture() == false) goto L8;
        return false;
    L8:
        if (this.task != null) goto L10;
        boolean supportsMultiWindow = supportsMultiWindow();
    L18:
        if (WindowConfiguration.inMultiWindowMode(windowingMode) == false) goto L26;
        if (supportsMultiWindow == false) goto L26;
        if (getExt().forceResizeable() == true) goto L26;
        if (this.mAtmService.mForceResizableActivities == true) goto L26;
        return false;
    L26:
        if (this.info.resizeMode != 2) goto L28;
        return false;
    L28:
        if (this.info.resizeMode != 1) goto L30;
        return false;
    L30:
        return true;
    L10:
        if (this.task.supportsMultiWindow() == false) goto L12;
    L15:
        supportsMultiWindow = true;
        goto L18
    L12:
        if (supportsMultiWindow() == true) goto L15;
        supportsMultiWindow = false;
        goto L18
    }

    boolean supportsPictureInPicture() {
        if (this.mAtmService.mSupportsPictureInPicture == true) goto L5;
    L9:
        return false;
    L5:
        if (isActivityTypeStandardOrUndefined() == false) goto L9;
        if (this.info.supportsPictureInPicture() == false) goto L9;
        return true;
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

    boolean supportsMultiWindow() {
        return supportsMultiWindowInDisplayArea(getDisplayArea());
    }

    boolean supportsMultiWindowInDisplayArea(TaskDisplayArea tda) {
        if (isActivityTypeHome() == false) goto L6;
        return false;
    L6:
        if (this.mAtmService.mSupportsMultiWindow == true) goto L8;
        return false;
    L8:
        if (tda != null) goto L11;
        return false;
    L11:
        if (isResizeable() == false) goto L13;
    L15:
        ActivityInfo.WindowLayout windowLayout = this.info.windowLayout;
        if (windowLayout != null) goto L18;
    L19:
        return true;
    L18:
        if (tda.supportsActivityMinWidthHeightMultiWindow(windowLayout.minWidth, windowLayout.minHeight, this.info) == true) goto L19;
        return false;
    L13:
        if (tda.supportsNonResizableMultiWindow() == true) goto L15;
        return false;
    }

    boolean canBeLaunchedOnDisplay(int displayId) {
        return this.mAtmService.mTaskSupervisor.canPlaceEntityOnDisplay(displayId, this.launchedFromPid, this.launchedFromUid, this.info);
    }

    boolean checkEnterPictureInPictureState(String caller, boolean beforeStopping) {
        if (supportsPictureInPicture() == true) goto L6;
        return false;
    L6:
        if (checkEnterPictureInPictureAppOpsState() == true) goto L9;
        return false;
    L9:
        if (this.mAtmService.shouldDisableNonVrUiLocked() == false) goto L12;
        return false;
    L12:
        if (getTaskFragment() != null) goto L14;
    L62:
        return false;
    L14:
        if (getTaskFragment().getTopNonFinishingActivity() != this) goto L62;
        if (this.mDisplayContent == null) goto L23;
        if (this.mDisplayContent.mDwpcHelper.isEnteringPipAllowed(getUid()) == true) goto L23;
        Slog.w("ActivityTaskManager", "Display " + this.mDisplayContent.getDisplayId() + " doesn't support enter picture-in-picture mode. caller = " + caller);
        return false;
    L23:
        if (this.mAtmService.getLockTaskModeState() == 0) goto L25;
        boolean isCurrentAppLocked = true;
    L26:
        TaskDisplayArea taskDisplayArea = getDisplayArea();
        if (taskDisplayArea != null) goto L29;
    L31:
        boolean hasRootPinnedTask = false;
    L33:
        if (isKeyguardLocked() == true) goto L36;
        if (isCurrentAppLocked == true) goto L36;
        boolean isNotLockedOrOnKeyguard = true;
    L37:
        if (beforeStopping == false) goto L41;
        if (hasRootPinnedTask == false) goto L41;
        return false;
    L41:
        switch(this.mState.ordinal()) {
            case 2: goto L56;
            case 3: goto L50;
            case 4: goto L50;
            case 5: goto L44;
            default: goto L49;
        };
    L50:
        if (isNotLockedOrOnKeyguard == false) goto L65;
        if (hasRootPinnedTask == false) goto L53;
        return false;
    L53:
        if (this.supportsEnterPipOnTaskSwitch == true) goto L55;
        return false;
    L55:
        return true;
    L65:
        return false;
    L56:
        if (isCurrentAppLocked == false) goto L58;
        return false;
    L58:
        if (this.supportsEnterPipOnTaskSwitch == true) goto L61;
        if (beforeStopping == false) goto L61;
        return false;
    L61:
        return true;
    L49:
        return false;
    L44:
        if (this.supportsEnterPipOnTaskSwitch == false) goto L49;
        if (isNotLockedOrOnKeyguard == false) goto L63;
        if (hasRootPinnedTask == false) goto L48;
        return false;
    L48:
        return true;
    L63:
        return false;
    L36:
        isNotLockedOrOnKeyguard = false;
        goto L37
    L29:
        if (taskDisplayArea.hasPinnedTask() == false) goto L31;
        hasRootPinnedTask = true;
        goto L33
    L25:
        isCurrentAppLocked = false;
        goto L26
    }

    void setWillCloseOrEnterPip(boolean willCloseOrEnterPip) {
        this.mWillCloseOrEnterPip = willCloseOrEnterPip;
    }

    boolean willCloseOrEnterPip() {
        return this.mWillCloseOrEnterPip;
    }

    boolean checkEnterPictureInPictureAppOpsState() {
        if (this.mAtmService.getAppOpsManager().checkOpNoThrow(67, this.info.applicationInfo.uid, this.packageName) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isAlwaysFocusable() {
        if ((this.info.flags & 262144) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean windowsAreFocusable() {
        return windowsAreFocusable(false);
    }

    boolean windowsAreFocusable(boolean fromUserTouch) {
        if (fromUserTouch == true) goto L11;
        if (this.mTargetSdk >= 29) goto L11;
        int pid = getPid();
        ActivityRecord topFocusedAppOfMyProcess = this.mWmService.mRoot.mTopFocusedAppByProcess.get(Integer.valueOf(pid));
        if (topFocusedAppOfMyProcess == null) goto L11;
        if (topFocusedAppOfMyProcess == this) goto L11;
        return false;
    L11:
        if (canReceiveKeys() == true) goto L15;
        if (isAlwaysFocusable() == true) goto L15;
        return false;
    L15:
        if (isAttached() == false) goto L19;
        return true;
    L19:
        return false;
    }

    boolean moveFocusableActivityToTop(String reason) {
        if (isFocusable() == false) goto L5;
        Task rootTask = getRootTask();
        if (rootTask != null) goto L12;
        Slog.w("ActivityTaskManager", "moveFocusableActivityToTop: invalid root task: activity=" + this + " task=" + this.task);
        return false;
    L12:
        ActivityRecord currentFocusedApp = this.mDisplayContent.mFocusedApp;
        if (this.mRootWindowContainer.getTopFocusedDisplayContent() == null) goto L15;
        int topFocusedDisplayId = this.mRootWindowContainer.getTopFocusedDisplayContent().getDisplayId();
    L17:
        if (currentFocusedApp == null) goto L35;
        if (currentFocusedApp.task != this.task) goto L35;
        if (topFocusedDisplayId != this.mDisplayContent.getDisplayId()) goto L35;
        Task topFocusableTask = this.mDisplayContent.getTask(new ActivityRecord$$ExternalSyntheticLambda28(), true);
        if (this.task != topFocusableTask) goto L35;
        if (currentFocusedApp != this) goto L29;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_enabled[0] == false) goto L33;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_FOCUS, 134255351804410010L, 0, new Object[]{protoLogParam0});
    L33:
        return !isState(State.RESUMED);
    L29:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_enabled[0] == false) goto L31;
        String protoLogParam1 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_FOCUS, -1058622321669556178L, 0, new Object[]{protoLogParam1});
    L31:
        this.mDisplayContent.setFocusedApp(this);
        this.mAtmService.mWindowManager.updateFocusedWindowLocked(0, true);
    L35:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_enabled[0] == false) goto L37;
        String protoLogParam2 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_FOCUS, 731006689098152100L, 0, new Object[]{protoLogParam2});
    L37:
        rootTask.moveToFront(reason, this.task);
        if (this.mState == State.RESUMED) goto L40;
    L42:
        return true;
    L40:
        if (this.mRootWindowContainer.getTopResumedActivity() != this) goto L42;
        this.mAtmService.setLastResumedActivityUncheckLocked(this, reason);
        goto L42
    L15:
        topFocusedDisplayId = -1;
        goto L17
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_enabled[0] == false) goto L7;
        String protoLogParam3 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_FOCUS, -9024836052864189016L, 0, new Object[]{protoLogParam3});
    L7:
        return false;
    }

    private static /* synthetic */ boolean lambda$moveFocusableActivityToTop$4(Task t) {
        if (t.isLeafTask() == true) goto L5;
    L9:
        return false;
    L5:
        if (t.isFocusable() == false) goto L9;
        if (t.inPinnedWindowingMode() == true) goto L9;
        return true;
    }

    void finishIfSubActivity(ActivityRecord parent, String otherResultWho, int otherRequestCode) {
        if (this.resultTo == parent) goto L5;
        return;
    L5:
        if (this.requestCode == otherRequestCode) goto L7;
        return;
    L7:
        if (Objects.equals(this.resultWho, otherResultWho) == false) goto L13;
        finishIfPossible("request-sub", false);
        return;
    }

    boolean finishIfSameAffinity(ActivityRecord r) {
        if (Objects.equals(r.taskAffinity, this.taskAffinity) == true) goto L5;
        return true;
    L5:
        r.finishIfPossible("request-affinity", true);
        return false;
    }

    private void finishActivityResults(final int resultCode, final Intent resultData, final NeededUriGrants resultGrants) {
        if (this.resultTo != null) goto L5;
        final ActivityRecord this = this;
        if (ActivityTaskManagerDebugConfig.DEBUG_RESULTS == false) goto L37;
        Slog.v("ActivityTaskManager", "No result destination from " + this);
    L37:
        this.results = null;
        this.pendingResults = null;
        this.newIntents = null;
        setSavedState(null);
        return;
    L5:
        if (ActivityTaskManagerDebugConfig.DEBUG_RESULTS == false) goto L8;
        Slog.v("ActivityTaskManager", "Adding result to " + this.resultTo + " who=" + this.resultWho + " req=" + this.requestCode + " res=" + resultCode + " data=" + resultData);
    L8:
        if (this.resultTo.mUserId == this.mUserId) goto L12;
        if (resultData == null) goto L12;
        resultData.prepareToLeaveUser(this.mUserId);
    L12:
        if (this.info.applicationInfo.uid <= 0) goto L14;
        this.mAtmService.mUgmInternal.grantUriPermissionUncheckedFromIntent(resultGrants, this.resultTo.getUriPermissionsLocked());
    L14:
        final IBinder callerToken = new Binder();
        this.resultTo.computeCallerInfo(callerToken, resultData, getUid(), this.mAtmService.getPackageManager().getNameForUid(getUid()), false);     // Catch: RemoteException -> L28
        if (this.mForceSendResultForMediaProjection == true) goto L25;
        if (this.resultTo.isState(State.RESUMED) == true) goto L25;
        this = this;
        this.resultTo.addResultLocked(this, this.resultWho, this.requestCode, resultCode, resultData, callerToken);
    L26:
        this.resultTo = null;
    L25:
        final ActivityRecord resultToActivity = this.resultTo;
        this.mAtmService.mH.post(new ActivityRecord$$ExternalSyntheticLambda10(this, resultToActivity, resultCode, resultData, callerToken, resultGrants));
    L28:
        e = move-exception;
        RemoteException e = e;
    L33:
        throw new RuntimeException(e);
    L30:
        e = move-exception;
        e = e;
        goto L33
    }

    private /* synthetic */ void lambda$finishActivityResults$5(ActivityRecord resultToActivity, int resultCode, Intent resultData, IBinder callerToken, NeededUriGrants resultGrants) {
        WindowManagerGlobalLock r1 = this.mAtmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        resultToActivity.sendResult(getUid(), this.resultWho, this.requestCode, resultCode, resultData, callerToken, resultGrants, this.mForceSendResultForMediaProjection);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    int finishIfPossible(String reason, boolean oomAdj) {
        return finishIfPossible(0, null, null, reason, oomAdj);
    }

    int finishIfPossible(int resultCode, Intent resultData, NeededUriGrants resultGrants, String reason, boolean oomAdj) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L7;
        String protoLogParam0 = String.valueOf(this);
        long protoLogParam1 = resultCode;
        String protoLogParam2 = String.valueOf(resultData);
        String protoLogParam3 = String.valueOf(reason);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 3707721620395081349L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), protoLogParam2, protoLogParam3});
    L7:
        if (this.finishing == false) goto L11;
        Slog.w("ActivityTaskManager", "Duplicate finish request for r=" + this);
        return 0;
    L11:
        if (isInRootTaskLocked() == true) goto L14;
        Slog.w("ActivityTaskManager", "Finish request when not in root task for r=" + this);
        return 0;
    L14:
        Task rootTask = getRootTask();
        if (isState(State.RESUMED) == true) goto L19;
        if (rootTask.getTopResumedActivity() == null) goto L19;
    L23:
        boolean r0 = false;
    L24:
        boolean mayAdjustTop = r0;
        if (mayAdjustTop == true) goto L27;
    L29:
        boolean r1 = false;
    L30:
        boolean shouldAdjustGlobalFocus = r1;
        this.mAtmService.deferWindowLayout();
        this.mTaskSupervisor.mNoHistoryActivities.remove(this);     // Catch: Throwable -> L128
        makeFinishingLocked();     // Catch: Throwable -> L128
        Task task = getTask();     // Catch: Throwable -> L128
        EventLogTags.writeWmFinishActivity(this.mUserId, System.identityHashCode(this), task.mTaskId, this.shortComponentName, reason);     // Catch: Throwable -> L36
        ZTEActivityEventsInternal zteActivityEventsInternal = (ZTEActivityEventsInternal) LocalServices.getService(ZTEActivityEventsInternal.class);     // Catch: Throwable -> L36
        if (zteActivityEventsInternal == null) goto L38;
        zteActivityEventsInternal.notifyActivityEvent(4, getDisplayId(), this.mUserId, this, getRootTaskId());     // Catch: Throwable -> L36
    L38:
        ActivityRecord next = task.getActivityAbove(this);     // Catch: Throwable -> L36
        if (next != null) goto L41;
    L43:
        pauseKeyDispatchingLocked();     // Catch: Throwable -> L36
        if (task.getTopNonFinishingActivity() == null) goto L46;
    L48:
        boolean endTask = false;
    L50:
        if (endTask == false) goto L52;
        WindowContainer<?> trigger = task;
    L53:
        Transition newTransition = this.mTransitionController.requestCloseTransitionIfNeeded(trigger);     // Catch: Throwable -> L36
        if (newTransition == null) goto L56;
        Transition transition = newTransition;
    L57:
        if (transition == null) goto L59;
        transition.collectClose(trigger);     // Catch: Throwable -> L36
    L59:
        if (mayAdjustTop == true) goto L61;
    L63:
        finishActivityResults(resultCode, resultData, resultGrants);     // Catch: Throwable -> L36
        if (isState(State.RESUMED) == false) goto L98;
        if (endTask == false) goto L68;
        this.mAtmService.getTaskChangeNotificationController().notifyTaskRemovalStarted(task.getTaskInfo());     // Catch: Throwable -> L36
    L68:
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L70;
    L71:
        Slog.v("ActivityTaskManager", "Prepare close transition: finishing " + this);     // Catch: Throwable -> L36
    L73:
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L75;
    L77:
        setVisibility(false);     // Catch: Throwable -> L36
        if (this.mLastImeShown == false) goto L85;
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L85;
        ActivityRecord nextRunning = task.topRunningActivity();     // Catch: Throwable -> L36
        if (nextRunning == null) goto L85;
        nextRunning.mLastImeShown = true;     // Catch: Throwable -> L36
    L85:
        if (getTaskFragment().getPausingActivity() == null) goto L87;
        endTask = endTask;
    L95:
        if (endTask == false) goto L126;
        this.mAtmService.getLockTaskController().clearLockedTask(task);     // Catch: Throwable -> L36
    L126:
        this.mAtmService.continueWindowLayout();
        return 1;
    L87:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L91;
        String protoLogParam4 = String.valueOf(this);     // Catch: Throwable -> L36
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, -3691592300155948194L, 0, new Object[]{protoLogParam4});     // Catch: Throwable -> L36
    L91:
        if (ActivityTaskManagerDebugConfig.DEBUG_USER_LEAVING == false) goto L93;
        Slog.v("ActivityTaskManager", "finish() => pause with userLeaving=false");     // Catch: Throwable -> L36
    L93:
        getTaskFragment().startPausing(false, false, null, "finish");     // Catch: Throwable -> L36
        goto L95
    L75:
        if (task.isAnimatingByRecents() == true) goto L77;
        ArraySet<Task> tasks = Sets.newArraySet(new Task[]{task});     // Catch: Throwable -> L36
        this.mAtmService.mWindowManager.mTaskSnapshotController.snapshotTasks(tasks);     // Catch: Throwable -> L36
        this.mAtmService.mWindowManager.mTaskSnapshotController.addSkipClosingAppSnapshotTasks(tasks);     // Catch: Throwable -> L36
        goto L77
    L70:
        if (ActivityTaskManagerDebugConfig.DEBUG_TRANSITION == false) goto L73;
    L98:
        if (isState(State.PAUSING) == true) goto L124;
        if (this.mVisibleRequested == false) goto L108;
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L106;
        setVisibility(false);     // Catch: Throwable -> L36
        if (newTransition == null) goto L108;
        newTransition.setReady(this.mDisplayContent, true);     // Catch: Throwable -> L36
        goto L108
    L106:
        prepareActivityHideTransitionAnimation();     // Catch: Throwable -> L36
    L108:
        if (completeFinishing("finishIfPossible") != null) goto L110;
        boolean removedActivity = true;
    L111:
        if (oomAdj == false) goto L116;
        if (isState(State.STOPPING) == false) goto L116;
        this.mAtmService.updateOomAdj();     // Catch: Throwable -> L36
    L116:
        if (task.onlyHasTaskOverlayActivities(false) == false) goto L118;
        task.forAllActivities(new ActivityRecord$$ExternalSyntheticLambda16());     // Catch: Throwable -> L36
    L118:
        if (removedActivity == false) goto L120;
        int r6 = 2;
    L121:
        this.mAtmService.continueWindowLayout();
        return r6;
    L120:
        r6 = 1;
        goto L121
    L110:
        removedActivity = false;
        goto L111
    L124:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L126;
        String protoLogParam5 = String.valueOf(this);     // Catch: Throwable -> L36
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 5813636479397543744L, 0, new Object[]{protoLogParam5});     // Catch: Throwable -> L36
        goto L126
    L61:
        if (task.topRunningActivity(true) != null) goto L63;
        task.adjustFocusToNextFocusableTask("finish-top", false, shouldAdjustGlobalFocus);     // Catch: Throwable -> L36
        goto L63
    L56:
        transition = this.mTransitionController.getCollectingTransition();     // Catch: Throwable -> L36
        goto L57
    L52:
        trigger = this;
        goto L53
    L46:
        if (task.isClearingToReuseTask() == true) goto L48;
        endTask = true;
        goto L50
    L41:
        if ((this.intent.getFlags() & 524288) == 0) goto L43;
        next.intent.addFlags(524288);     // Catch: Throwable -> L36
    L36:
        th = th;
    L130:
        this.mAtmService.continueWindowLayout();
        throw th;
    L128:
        th = th;
        goto L130
    L27:
        if (this.mRootWindowContainer.isTopDisplayFocusedRootTask(rootTask) == false) goto L29;
        r1 = true;
    L19:
        if (rootTask.isFocusedRootTaskOnDisplay() == false) goto L23;
        if (this.task.isClearingToReuseTask() == true) goto L23;
        r0 = true;
        goto L24
    }

    private static /* synthetic */ void lambda$finishIfPossible$6(ActivityRecord r) {
        r.prepareActivityHideTransitionAnimationIfOvarlay();
    }

    void setForceSendResultForMediaProjection() {
        this.mForceSendResultForMediaProjection = true;
    }

    private void prepareActivityHideTransitionAnimationIfOvarlay() {
        if (this.mTaskOverlay == false) goto L6;
        prepareActivityHideTransitionAnimation();
        return;
    }

    private void prepareActivityHideTransitionAnimation() {
        DisplayContent dc = this.mDisplayContent;
        setVisibility(false);
        dc.executeAppTransition();
    }

    ActivityRecord completeFinishing(String reason) {
        return completeFinishing(true, reason);
    }

    ActivityRecord completeFinishing(boolean updateVisibility, String reason) {
        if (this.finishing == false) goto L80;
        if (isState(State.RESUMED) == true) goto L80;
        if (isState(State.PAUSING) == false) goto L10;
        return this;
    L10:
        if (this.mVisibleRequested == false) goto L12;
    L15:
        boolean isCurrentVisible = true;
    L17:
        if (updateVisibility == false) goto L31;
        if (isCurrentVisible == false) goto L31;
        if (this.task.isClearingToReuseTask() == true) goto L31;
        boolean ensureVisibility = false;
        if (occludesParent(true) == false) goto L25;
        ensureVisibility = true;
    L29:
        if (ensureVisibility == false) goto L31;
        this.mDisplayContent.ensureActivitiesVisible(null, true);
        goto L31
    L25:
        if (isKeyguardLocked() == false) goto L29;
        if (this.mTaskSupervisor.getKeyguardController().topActivityOccludesKeyguard(this) == false) goto L29;
        ensureVisibility = true;
    L31:
        boolean activityRemoved = false;
        final ActivityRecord next = getDisplayArea().topRunningActivity(true);
        boolean delayRemoval = false;
        TaskFragment taskFragment = getTaskFragment();
        if (next == null) goto L48;
        if (taskFragment == null) goto L48;
        if (taskFragment.isEmbedded() == false) goto L48;
        TaskFragment organized = taskFragment.getOrganizedTaskFragment();
        if (organized != null) goto L39;
    L45:
        boolean r9 = false;
    L46:
        delayRemoval = r9;
        goto L48
    L39:
        if (organized.topRunningActivity() != null) goto L45;
        if (organized.isDelayLastActivityRemoval() == false) goto L45;
        next.getClass();
        if (organized.forOtherAdjacentTaskFragments(new ActivityRecord$$ExternalSyntheticLambda6(next)) == false) goto L45;
        r9 = true;
    L48:
        if (next != null) goto L50;
    L54:
        boolean isNextNotYetVisible = false;
    L56:
        if (isNextNotYetVisible == true) goto L58;
    L62:
        if (isCurrentVisible == false) goto L74;
        if (isNextNotYetVisible == true) goto L73;
        if (delayRemoval == true) goto L73;
        if (next == null) goto L70;
        if (isInTransition() == true) goto L73;
    L70:
        if (addToFinishingAndWaitForIdle() == true) goto L75;
        activityRemoved = destroyIfPossible(reason);
    L75:
        if (activityRemoved == false) goto L78;
        return null;
    L78:
        return this;
    L73:
        addToStopping(false, false, "completeFinishing");
        callServiceTrackeronActivityStatechange(State.STOPPING, true);
        setState(State.STOPPING, "completeFinishing");
        goto L75
    L74:
        addToFinishingAndWaitForIdle();
        activityRemoved = destroyIfPossible(reason);
        goto L75
    L58:
        if (this.mDisplayContent.isSleeping() == false) goto L62;
        if (next != next.getTaskFragment().mLastPausedActivity) goto L62;
        next.getTaskFragment().clearLastPausedActivity();
        goto L62
    L50:
        if (next.nowVisible == true) goto L52;
    L53:
        isNextNotYetVisible = true;
        goto L56
    L52:
        if (next.isVisibleRequested() == true) goto L54;
    L12:
        if (isState(State.PAUSED, State.STARTED) == true) goto L15;
        isCurrentVisible = false;
    L80:
        throw new IllegalArgumentException("Activity must be finishing and not resumed to complete, r=" + this + ", finishing=" + this.finishing + ", state=" + this.mState);
    }

    boolean destroyIfPossible(String reason) {
        callServiceTrackeronActivityStatechange(State.FINISHING, true);
        setState(State.FINISHING, "destroyIfPossible");
        this.mTaskSupervisor.mStoppingActivities.remove(this);
        Task rootTask = getRootTask();
        TaskDisplayArea taskDisplayArea = getDisplayArea();
        ActivityRecord next = taskDisplayArea.topRunningActivity();
        if (next == null) goto L5;
    L9:
        boolean isLastRootTaskOverEmptyHome = false;
    L11:
        if (isLastRootTaskOverEmptyHome == false) goto L14;
        addToFinishingAndWaitForIdle();
        return false;
    L14:
        makeFinishingLocked();
        getRootTask().onARStopTriggered(this);
        boolean activityRemoved = destroyImmediately("finish-imm:" + reason);
        if (next != null) goto L19;
        this.mRootWindowContainer.ensureVisibilityAndConfig(null, this.mDisplayContent, true);
        if (this.mDisplayContent.topRunningActivity() != null) goto L19;
        this.mTransitionController.setReady(this.mDisplayContent);
    L19:
        if (activityRemoved == false) goto L22;
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();
    L22:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTAINERS_enabled[0] == false) goto L24;
        String protoLogParam0 = String.valueOf(this);
        String protoLogParam1 = String.valueOf(activityRemoved);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_CONTAINERS, -2989211291975863399L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L24:
        return activityRemoved;
    L5:
        if (rootTask.isFocusedRootTaskOnDisplay() == false) goto L9;
        if (taskDisplayArea.getOrCreateRootHomeTask() == null) goto L9;
        isLastRootTaskOverEmptyHome = true;
        goto L11
    }

    boolean addToFinishingAndWaitForIdle() {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L5;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 3169053633576517098L, 0, new Object[]{protoLogParam0});
    L5:
        callServiceTrackeronActivityStatechange(State.FINISHING, true);
        setState(State.FINISHING, "addToFinishingAndWaitForIdle");
        if (this.mTaskSupervisor.mFinishingActivities.contains(this) == true) goto L8;
        this.mTaskSupervisor.mFinishingActivities.add(this);
    L8:
        resumeKeyDispatchingLocked();
        return this.mRootWindowContainer.resumeFocusedTasksTopActivities();
    }

    boolean destroyImmediately(String reason) {
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L5;
    L6:
        StringBuilder r0 = new StringBuilder();
        r0.append("Removing activity from ");
        r0.append(reason);
        r0.append(": token=");
        r0.append(this);
        r0.append(", app=");
        if (hasProcess() == false) goto L9;
        String r2 = this.app.mName;
    L10:
        r0.append(r2);
        Slog.v("ActivityTaskManager", r0.toString());
    L12:
        if (isState(State.DESTROYING, State.DESTROYED) == true) goto L14;
        EventLogTags.writeWmDestroyActivity(this.mUserId, System.identityHashCode(this), this.task.mTaskId, this.shortComponentName, reason);
        ZTEActivityEventsInternal zteActivityEventsInternal = (ZTEActivityEventsInternal) LocalServices.getService(ZTEActivityEventsInternal.class);
        if (zteActivityEventsInternal == null) goto L20;
        ActivityRecord r8 = this;
        zteActivityEventsInternal.notifyActivityEvent(32, getDisplayId(), this.mUserId, r8, getRootTaskId());
    L21:
        boolean removedFromHistory = false;
        cleanUp(false, false);
        setVisibleRequested(false);
        if (hasProcess() == false) goto L68;
        r8.app.removeActivity(this, true);
        if (r8.app.hasActivities() == true) goto L26;
        r8.mAtmService.clearHeavyWeightProcessIfEquals(r8.app);
    L26:
        boolean skipDestroy = false;
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L30;
        Slog.i("ActivityTaskManager", "Destroying: " + this);
    L30:
        if (r8.app.getThread() != null) goto L32;
        IApplicationThread r1 = ((WindowProcessControllerSmtBase) r8.app.getSmtEx()).thread;
    L33:
        IApplicationThread client = r1;
        if (client != null) goto L36;
        Slog.w("WindowManager", "Failed to schedule DestroyActivityItem because client is inactive");
        boolean isSuccessful = false;
    L48:
        if (isSuccessful == false) goto L50;
    L52:
        r8.nowVisible = false;
        if (r8.finishing == false) goto L60;
        if (skipDestroy == true) goto L60;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L58;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 5672598223877126839L, 0, new Object[]{protoLogParam0});
    L58:
        callServiceTrackeronActivityStatechange(State.DESTROYING, true);
        setState(State.DESTROYING, "destroyActivityLocked. finishing and not skipping destroy");
        r8.mAtmService.mH.postDelayed(r8.mDestroyTimeoutRunnable, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        return removedFromHistory;
    L60:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L62;
        String protoLogParam1 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, -1834399855266808961L, 0, new Object[]{protoLogParam1});
    L62:
        callServiceTrackeronActivityStatechange(State.DESTROYED, true);
        setState(State.DESTROYED, "destroyActivityLocked. not finishing or skipping destroy");
        if (ActivityTaskManagerDebugConfig.DEBUG_APP == false) goto L65;
        Slog.v("ActivityTaskManager", "Clearing app during destroy for activity " + this);
    L65:
        detachFromProcess();
        return removedFromHistory;
    L50:
        if (r8.finishing == false) goto L52;
        removeFromHistory(reason + " exceptionInScheduleDestroy");
        removedFromHistory = true;
        skipDestroy = true;
        goto L52
    L36:
        ClientTransactionItem r3 = new DestroyActivityItem(r8.token, r8.finishing);
        if (r8.finishing == false) goto L76;
        r3.getExt().setFinishReason(reason);
    L76:
        WindowProcessControllerSmtBase wpcBase = r8.app.getWPCSmtEx();     // Catch: RemoteException -> L42
        if (wpcBase.isFreezing() == false) goto L45;
        wpcBase.unFreezeProcIfNeedLocked(new DestroyActivityEvent(r8.app, wpcBase.thread, r8.token, r3));     // Catch: RemoteException -> L42
        Slog.i("AMS.Freeze", "unFreezeProcIfNeedLocked proc:" + r8.app + " for DestroyActivityEvent, at destroyImmediately");     // Catch: RemoteException -> L42
        isSuccessful = true;
    L75:
    L45:
        isSuccessful = r8.mAtmService.getLifecycleManager().scheduleTransactionItem(client, r3);     // Catch: RemoteException -> L42
    L47:
        isSuccessful = false;
        goto L48
    L32:
        r1 = r8.app.getThread();
        goto L33
    L68:
        if (r8.finishing == false) goto L71;
        removeFromHistory(reason + " hadNoApp");
        return true;
    L71:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L73;
        String protoLogParam2 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 3282063745558462269L, 0, new Object[]{protoLogParam2});
    L73:
        callServiceTrackeronActivityStatechange(State.DESTROYED, true);
        setState(State.DESTROYED, "destroyActivityLocked. not finishing and had no app");
        return false;
    L20:
        r8 = this;
        goto L21
    L14:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L16;
        String protoLogParam3 = String.valueOf(this);
        String protoLogParam4 = String.valueOf(reason);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 9050478058743283018L, 0, new Object[]{protoLogParam3, protoLogParam4});
    L16:
        return false;
    L9:
        r2 = "(null)";
        goto L10
    L5:
        if (ActivityTaskManagerDebugConfig.DEBUG_CLEANUP == false) goto L12;
        goto L6
    }

    void removeFromHistory(String reason) {
        finishActivityResults(0, null, null);
        makeFinishingLocked();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[2] == false) goto L5;
        String protoLogParam0 = String.valueOf(this);
        String protoLogParam1 = String.valueOf(reason);
        String protoLogParam2 = String.valueOf(Debug.getCallers(5));
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 8836546031252812807L, 0, new Object[]{protoLogParam0, protoLogParam1, protoLogParam2});
    L5:
        takeFromHistory();
        removeTimeouts();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L8;
        String protoLogParam3 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 8348126473928520781L, 0, new Object[]{protoLogParam3});
    L8:
        callServiceTrackeronActivityStatechange(State.DESTROYED, true);
        setState(State.DESTROYED, "removeFromHistory");
        if (ActivityTaskManagerDebugConfig.DEBUG_APP == false) goto L11;
        Slog.v("ActivityTaskManager", "Clearing app during remove for activity " + this);
    L11:
        detachFromProcess();
        resumeKeyDispatchingLocked();
        this.mDisplayContent.removeAppToken(this.token);
        cleanUpActivityServices();
        removeUriPermissionsLocked();
    }

    void detachFromProcess() {
        if (this.app == null) goto L6;
        this.app.removeActivity(this, false);
    L6:
        if (this.app == null) goto L8;
        this.mLastReportedProcState = this.app.getReportedProcState();
    L8:
        this.app = null;
        this.mInputDispatchingTimeoutMillis = InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS;
    }

    int getCurrentReportedProcState() {
        if (this.app == null) goto L7;
        return this.app.getReportedProcState();
    L7:
        return this.mLastReportedProcState;
    }

    void resetCurrentReportedProcState() {
        this.mLastReportedProcState = -1;
    }

    void makeFinishingLocked() {
        if (this.finishing == false) goto L5;
        return;
    L5:
        this.finishing = true;
        if (this.mLaunchCookie != null) goto L8;
    L21:
        TaskFragment taskFragment = getTaskFragment();
        if (taskFragment == null) goto L32;
        Task task = taskFragment.getTask();
        if (task != null) goto L26;
    L30:
        taskFragment.sendTaskFragmentInfoChanged();
        goto L32
    L26:
        if (task.isClearingToReuseTask() == false) goto L30;
        if (taskFragment.getTopNonFinishingActivity() != null) goto L30;
        taskFragment.mClearedTaskForReuse = true;
    L32:
        if (this.mAppStopped == false) goto L35;
        abortAndClearOptionsAnimation();
    L35:
        if (this.mDisplayContent == null) goto L38;
        this.mDisplayContent.mUnknownAppVisibilityController.appRemovedOrHidden(this);
        return;
    L38:
        return;
    L8:
        if (this.mState == State.RESUMED) goto L21;
        if (this.task == null) goto L21;
        if (this.task.mInRemoveTask == true) goto L21;
        if (this.task.isClearingToReuseTask() == true) goto L21;
        ActivityRecord nextCookieTarget = this.task.getActivity(new ActivityRecord$$ExternalSyntheticLambda29(this), this, false, false);
        if (nextCookieTarget == null) goto L21;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L20;
        String protoLogParam0 = String.valueOf(this.mLaunchCookie);
        String protoLogParam1 = String.valueOf(this.packageName);
        long protoLogParam2 = System.identityHashCode(this);
        String protoLogParam3 = String.valueOf(nextCookieTarget.packageName);
        long protoLogParam4 = System.identityHashCode(nextCookieTarget);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -7340022616576870808L, 272, new Object[]{protoLogParam0, protoLogParam1, Long.valueOf(protoLogParam2), protoLogParam3, Long.valueOf(protoLogParam4)});
    L20:
        nextCookieTarget.mLaunchCookie = this.mLaunchCookie;
        this.mLaunchCookie = null;
        goto L21
    }

    private /* synthetic */ boolean lambda$makeFinishingLocked$7(ActivityRecord r) {
        if (r.mLaunchCookie == null) goto L5;
    L9:
        return false;
    L5:
        if (r.finishing == true) goto L9;
        if (r.isUid(getUid()) == false) goto L9;
        return true;
    }

    void destroyed(String reason) {
        removeDestroyTimeout();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTAINERS_enabled[0] == false) goto L6;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_CONTAINERS, -8001673213497887656L, 0, new Object[]{protoLogParam0});
    L6:
        if (isState(State.DESTROYING, State.DESTROYED) == false) goto L13;
        this.mTaskSupervisor.killTaskProcessesOnDestroyedIfNeeded(this.task);
        if (isInRootTaskLocked() == false) goto L10;
        cleanUp(true, false);
        removeFromHistory(reason);
    L10:
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();
        return;
    L13:
        throw new IllegalStateException("Reported destroyed for activity that is not destroying: r=" + this);
    }

    void cleanUp(boolean cleanServices, boolean setState) {
        getTaskFragment().cleanUpActivityReferences(this);
        clearLastParentBeforePip();
        Task rootTask = getRootTask();
        if (rootTask == null) goto L5;
        rootTask.abortTranslucentActivityWaiting(this);
    L5:
        cleanUpSplashScreen();
        if (setState == false) goto L11;
        callServiceTrackeronActivityStatechange(State.DESTROYED, true);
        setState(State.DESTROYED, "cleanUp");
        if (ActivityTaskManagerDebugConfig.DEBUG_APP == false) goto L10;
        Slog.v("ActivityTaskManager", "Clearing app during cleanUp for activity " + this);
    L10:
        detachFromProcess();
    L11:
        this.mTaskSupervisor.cleanupActivity(this);
        if (this.finishing == true) goto L14;
    L23:
        if (cleanServices == false) goto L25;
        cleanUpActivityServices();
    L25:
        removeTimeouts();
        clearRelaunching();
        return;
    L14:
        if (this.pendingResults == null) goto L23;
        Iterator<WeakReference<PendingIntentRecord>> r1 = this.pendingResults.iterator();
    L17:
        if (r1.hasNext() == false) goto L22;
        WeakReference<PendingIntentRecord> apr = r1.next();
        PendingIntentRecord rec = apr.get();
        if (rec == null) goto L17;
        this.mAtmService.mPendingIntentController.cancelIntentSender(rec, false, 16);
        goto L17
    L22:
        this.pendingResults = null;
        goto L23
    }

    boolean isRelaunching() {
        if (this.mPendingRelaunchCount <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    void startRelaunching() {
        if (this.mPendingRelaunchCount != 0) goto L7;
        this.mRelaunchStartTime = SystemClock.elapsedRealtime();
        if (this.mVisibleRequested == false) goto L7;
        this.mDisplayContent.getDisplayPolicy().addRelaunchingApp(this);
    L7:
        clearAllDrawn();
        this.mPendingRelaunchCount++;
    }

    void finishRelaunching() {
        this.mAppCompatController.getOrientationOverrides().setRelaunchingAfterRequestedOrientationChanged(false);
        this.mTaskSupervisor.getActivityMetricsLogger().notifyActivityRelaunched(this);
        if (this.mPendingRelaunchCount <= 0) goto L9;
        this.mPendingRelaunchCount--;
        if (this.mPendingRelaunchCount == 0) goto L7;
    L10:
        Task rootTask = getRootTask();
        if (rootTask != null) goto L13;
        return;
    L13:
        if (rootTask.shouldSleepOrShutDownActivities() == false) goto L17;
        rootTask.ensureActivitiesVisible(null);
        return;
    L17:
        return;
    L7:
        if (isClientVisible() == true) goto L10;
        finishOrAbortReplacingWindow();
        goto L10
    L9:
        checkKeyguardFlagsChanged();
        goto L10
    }

    void clearRelaunching() {
        if (this.mPendingRelaunchCount != 0) goto L5;
        return;
    L5:
        this.mPendingRelaunchCount = 0;
        finishOrAbortReplacingWindow();
    }

    void finishOrAbortReplacingWindow() {
        this.mRelaunchStartTime = 0;
        this.mDisplayContent.getDisplayPolicy().removeRelaunchingApp(this);
    }

    ActivityServiceConnectionsHolder getOrCreateServiceConnectionsHolder() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mServiceConnectionsHolder != null) goto L8;
        this.mServiceConnectionsHolder = new ActivityServiceConnectionsHolder(this);     // Catch: Throwable -> L6
    L8:
        ActivityServiceConnectionsHolder r0 = this.mServiceConnectionsHolder;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    }

    private void cleanUpActivityServices() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mServiceConnectionsHolder != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.mServiceConnectionsHolder.disconnectActivityFromServices();     // Catch: Throwable -> L7
        this.mServiceConnectionsHolder = null;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    private void updateVisibleForServiceConnection() {
        if (this.mVisibleRequested == false) goto L5;
    L10:
        boolean r0 = true;
    L11:
        this.mVisibleForServiceConnection = r0;
        return;
    L5:
        if (this.mState == State.RESUMED) goto L10;
        if (this.mState == State.PAUSING) goto L10;
        r0 = false;
        goto L11
    }

    void handleAppDied() {
        if (Process.isSdkSandboxUid(getUid()) == false) goto L6;
        boolean remove = true;
    L31:
        if (remove == true) goto L40;
        if (this.info.applicationInfo.isSystemApp() == false) goto L40;
        if ((this.mExt.getActivityInfoMetaData("app_die_remove_history") instanceof Boolean) == false) goto L40;
        if (((Boolean) this.mExt.getActivityInfoMetaData("app_die_remove_history")).booleanValue() == false) goto L40;
        remove = true;
    L40:
        if (this.mRelaunchReason != 1) goto L45;
        if (inFreeformWindowingMode() == false) goto L45;
        remove = true;
    L45:
        if (remove == true) goto L47;
        ActivityRecord r7 = this;
        if (ActivityTaskManagerDebugConfig.DEBUG_APP == false) goto L69;
        Slog.v("ActivityTaskManager", "Keeping entry during removeHistory for activity " + this);
    L69:
        Slog.i("ActivityTaskManager", "handleAppDied igore remove " + this + " mHaveState: " + r7.mHaveState + " stateNotNeeded: " + r7.stateNotNeeded + " launchCount: " + r7.launchCount + " mVisibleRequested: " + r7.mVisibleRequested + " finishing: " + r7.finishing + " mRelaunchReason: " + r7.mRelaunchReason);
    L71:
        if (r7.task != null) goto L73;
    L75:
        if (remove == true) goto L77;
    L81:
        WindowContainer<?> r1 = r7;
    L82:
        Transition tr = r7.mTransitionController.requestCloseTransitionIfNeeded(r1);
        if (tr == null) goto L86;
        tr.collectClose(r1);
    L88:
        cleanUp(true, true);
        if (remove == true) goto L91;
        return;
    L91:
        if (r7.mStartingData != null) goto L93;
    L103:
        removeFromHistory("appDied");
        return;
    L93:
        if (r7.mVisible == false) goto L103;
        if (r7.task == null) goto L103;
        ActivityRecord top = r7.task.topRunningActivity();
        if (top == null) goto L103;
        if (top.mVisible == true) goto L103;
        if (top.shouldBeVisible() == false) goto L103;
        top.transferStartingWindow(this);
        goto L103
    L86:
        if (r7.mTransitionController.isCollecting() == false) goto L88;
        r7.mTransitionController.getCollectingTransition().collectClose(r1);
        goto L88
    L77:
        if (r7.task == null) goto L81;
        if (r7.task.getChildCount() != 1) goto L81;
        r1 = r7.task;
        goto L82
    L73:
        if (r7.task.mKillProcessesOnDestroyed == false) goto L75;
        r7.mTaskSupervisor.removeTimeoutOfKillProcessesOnProcessDied(this, r7.task);
        goto L75
    L47:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[2] == false) goto L49;
        String protoLogParam0 = String.valueOf(this);
        boolean protoLogParam1 = this.mHaveState;
        String protoLogParam2 = String.valueOf(this.stateNotNeeded);
        boolean protoLogParam3 = this.finishing;
        String protoLogParam4 = String.valueOf(this.mState);
        String protoLogParam5 = String.valueOf(Debug.getCallers(5));
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 587363723665813898L, 204, new Object[]{protoLogParam0, Boolean.valueOf(protoLogParam1), protoLogParam2, Boolean.valueOf(protoLogParam3), protoLogParam4, protoLogParam5});
    L49:
        boolean protoLogParam6 = this.finishing;
        if (protoLogParam6 == true) goto L52;
    L57:
        Slog.w("ActivityTaskManager", "Force removing " + this + ": app died, no saved state");
        int r2 = this.mUserId;
        int r3 = System.identityHashCode(this);
        if (this.task == null) goto L60;
        int r4 = this.task.mTaskId;
    L61:
        EventLogTags.writeWmFinishActivity(r2, r3, r4, this.shortComponentName, "proc died without state saved");
        ZTEActivityEventsInternal zteActivityEventsInternal = (ZTEActivityEventsInternal) LocalServices.getService(ZTEActivityEventsInternal.class);
        if (zteActivityEventsInternal == null) goto L64;
        r7 = this;
        zteActivityEventsInternal.notifyActivityEvent(4, getDisplayId(), this.mUserId, r7, getRootTaskId());
        goto L71
    L64:
        r7 = this;
        goto L71
    L60:
        r4 = -1;
        goto L61
    L52:
        if (this.app != null) goto L54;
    L56:
        r7 = this;
        goto L71
    L54:
        if (this.app.isRemoved() == false) goto L56;
    L6:
        if (this.mRelaunchReason == 1) goto L10;
        if (this.mRelaunchReason == 2) goto L10;
    L14:
        boolean remove2 = this.mHaveState;
        if (remove2 == true) goto L21;
        if (this.stateNotNeeded == true) goto L21;
        if (isState(State.RESTARTING_PROCESS) == true) goto L21;
    L22:
        remove = true;
    L21:
        if (this.finishing == true) goto L22;
        boolean remove3 = this.mVisibleRequested;
        if (remove3 == false) goto L26;
    L30:
        remove = false;
        goto L31
    L26:
        if (this.launchCount <= 2) goto L30;
        if (this.lastLaunchTime <= (SystemClock.uptimeMillis() - 60000)) goto L30;
        remove = true;
    L10:
        if (this.launchCount >= 3) goto L14;
        if (this.finishing == true) goto L14;
        remove = false;
        goto L31
    }

    @Override // com.android.server.wm.WindowToken, com.android.server.wm.WindowContainer
    void removeImmediately() {
        if (this.mState == State.DESTROYED) goto L5;
        Slog.w("ActivityTaskManager", "Force remove immediately " + this + " state=" + this.mState);
        destroyImmediately("removeImmediately");
        destroyed("removeImmediately");
    L6:
        this.mActivityRecordInputSink.releaseSurfaceControl();
        super.removeImmediately();
        return;
    L5:
        onRemovedFromDisplay();
        goto L6
    }

    void onRemovedFromDisplay() {
        if (this.mRemovingFromDisplay == false) goto L5;
        return;
    L5:
        this.mRemovingFromDisplay = true;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_APP_TRANSITIONS_enabled[1] == false) goto L8;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, -1842512343787359105L, 0, new Object[]{protoLogParam0});
    L8:
        getDisplayContent().mUnknownAppVisibilityController.appRemovedOrHidden(this);
        this.mWmService.mSnapshotController.onAppRemoved(this);
        this.mAtmService.mStartingProcessActivities.remove(this);
        this.mTaskSupervisor.getActivityMetricsLogger().notifyActivityRemoved(this);
        this.mTaskSupervisor.mStoppingActivities.remove(this);
        this.mAppCompatController.getLetterboxPolicy().stop();
        this.mAppCompatController.getTransparentPolicy().stop();
        if (isAnimating(4, 16) == false) goto L11;
    L14:
        boolean delayed = true;
    L16:
        if (delayed == true) goto L18;
        commitVisibility(false, true);
    L19:
        this.mTransitionController.collect(this);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_APP_TRANSITIONS_enabled[1] == false) goto L23;
        String protoLogParam1 = String.valueOf(this);
        boolean protoLogParam2 = delayed;
        String protoLogParam3 = String.valueOf(getAnimation());
        boolean protoLogParam4 = isAnimating(3, 1);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, 5548174277852675449L, 204, new Object[]{protoLogParam1, Boolean.valueOf(protoLogParam2), protoLogParam3, Boolean.valueOf(protoLogParam4)});
    L23:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[1] == false) goto L26;
        String protoLogParam5 = String.valueOf(this);
        boolean protoLogParam6 = delayed;
        String protoLogParam7 = String.valueOf(Debug.getCallers(4));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, -601582700132879947L, 12, new Object[]{protoLogParam5, Boolean.valueOf(protoLogParam6), protoLogParam7});
    L26:
        if (this.mStartingData == null) goto L28;
        removeStartingWindow();
    L28:
        if (delayed == true) goto L30;
    L35:
        cancelAnimation();
        removeIfPossible();
    L36:
        DisplayContent dc = getDisplayContent();
        if (dc.mFocusedApp == this) goto L39;
    L42:
        if (delayed == true) goto L44;
        updateReportedVisibilityLocked();
    L44:
        this.mDisplayContent.onRunningActivityChanged();
        this.mRemovingFromDisplay = false;
        return;
    L39:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[1] == false) goto L41;
        String protoLogParam8 = String.valueOf(this);
        long protoLogParam9 = dc.getDisplayId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, -7226216420432530281L, 4, new Object[]{protoLogParam8, Long.valueOf(protoLogParam9)});
    L41:
        dc.setFocusedApp(null);
        this.mWmService.updateFocusedWindowLocked(0, true);
        goto L42
    L30:
        if (isEmpty() == true) goto L35;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[1] == false) goto L34;
        String protoLogParam10 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 3478214322581157355L, 0, new Object[]{protoLogParam10});
    L34:
        this.mIsExiting = true;
        goto L36
    L18:
        setVisibleRequested(false);
        goto L19
    L11:
        if (this.mTransitionController.inTransition() == true) goto L14;
        delayed = false;
        goto L16
    }

    @Override // com.android.server.wm.WindowToken
    protected boolean isFirstChildWindowGreaterThanSecond(WindowState newWindow, WindowState existingWindow) {
        int type1 = newWindow.mAttrs.type;
        int type2 = existingWindow.mAttrs.type;
        if (type1 != 1) goto L6;
        if (type2 == 1) goto L6;
        return false;
    L6:
        if (type1 == 1) goto L10;
        if (type2 != 1) goto L10;
        return true;
    L10:
        if (type1 != 3) goto L13;
        if (type2 == 3) goto L13;
        return true;
    L13:
        if (type1 == 3) goto L16;
        if (type2 != 3) goto L16;
        return false;
    L16:
        return true;
    }

    boolean hasStartingWindow() {
        if (this.mStartingData == null) goto L5;
        return true;
    L5:
        int i = this.mChildren.size() - 1;
    L6:
        if (i < 0) goto L11;
        if (getChildAt(i).mAttrs.type == 3) goto L9;
        i = i - 1;
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    boolean isLastWindow(WindowState win) {
        if (this.mChildren.size() == 1) goto L5;
        return false;
    L5:
        if (this.mChildren.get(0) == win) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.android.server.wm.WindowToken
    void addWindow(WindowState w) {
        super.addWindow(w);
        checkKeyguardFlagsChanged();
    }

    void removeChild(WindowState child) {
        if (this.mChildren.contains(child) == true) goto L5;
        return;
    L5:
        super.removeChild(child);
        checkKeyguardFlagsChanged();
        updateLetterboxSurfaceIfNeeded(child);
    }

    void setAppLayoutChanges(int changes, String reason) {
        if (this.mChildren.isEmpty() == true) goto L8;
        DisplayContent dc = getDisplayContent();
        dc.pendingLayoutChanges |= changes;
        if (WindowManagerDebugConfig.DEBUG_LAYOUT_REPEATS == false) goto L9;
        this.mWmService.mWindowPlacerLocked.debugLayoutRepeats(reason, dc.pendingLayoutChanges);
        return;
    L9:
        return;
    }

    private boolean isStartingOrientationCompatible(ActivityRecord fromActivity) {
        int fromOrientation = fromActivity.getConfiguration().orientation;
        int requestedOrientation = getRequestedConfigurationOrientation();
        if (requestedOrientation == 0) goto L5;
        if (fromOrientation == requestedOrientation) goto L10;
        return false;
    L10:
        return true;
    L5:
        if (fromOrientation == getConfiguration().orientation) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean transferStartingWindow(ActivityRecord fromActivity) {
        WindowState tStartingWindow = fromActivity.mStartingWindow;
        if (tStartingWindow == null) goto L65;
        if (fromActivity.mStartingSurface == null) goto L65;
        if (tStartingWindow.getParent() != null) goto L10;
        return false;
    L10:
        if (fromActivity.hasFixedRotationTransform() == false) goto L13;
        this.mDisplayContent.handleTopActivityLaunchingInDifferentOrientation(this, false);
    L13:
        if (isStartingOrientationCompatible(fromActivity) == true) goto L16;
        return false;
    L16:
        if (this.task.getChildCount() < 3) goto L26;
        if (fromActivity.mStartingData.mAssociatedTask != null) goto L26;
        ActivityRecord aboveFrom = this.task.getActivityAbove(fromActivity);
        if (aboveFrom == null) goto L26;
        if (aboveFrom == this) goto L26;
        if (aboveFrom.mReportedDrawn == true) goto L26;
        return false;
    L26:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L28;
        String protoLogParam0 = String.valueOf(tStartingWindow);
        String protoLogParam1 = String.valueOf(fromActivity);
        String protoLogParam2 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, 8361394136152947990L, 0, new Object[]{protoLogParam0, protoLogParam1, protoLogParam2});
    L28:
        getExt().traceMovingExistingStarting(tStartingWindow, fromActivity, this);
        long origId = Binder.clearCallingIdentity();
        this.mStartingData = fromActivity.mStartingData;     // Catch: Throwable -> L32
        this.mStartingSurface = fromActivity.mStartingSurface;     // Catch: Throwable -> L32
        this.mStartingWindow = tStartingWindow;     // Catch: Throwable -> L32
        this.reportedVisible = fromActivity.reportedVisible;     // Catch: Throwable -> L32
        fromActivity.mStartingData = null;     // Catch: Throwable -> L32
        fromActivity.mStartingSurface = null;     // Catch: Throwable -> L32
        fromActivity.mStartingWindow = null;     // Catch: Throwable -> L32
        fromActivity.startingMoved = true;     // Catch: Throwable -> L32
        tStartingWindow.mToken = this;     // Catch: Throwable -> L32
        tStartingWindow.mActivityRecord = this;     // Catch: Throwable -> L32
        if (this.mStartingData.mRemoveAfterTransaction != 3) goto L35;
        this.mStartingData.mRemoveAfterTransaction = 0;     // Catch: Throwable -> L32
    L35:
        if (this.mStartingData.mRemoveAfterTransaction != 1) goto L42;
        WindowState mainWin = findMainWindow(false);     // Catch: Throwable -> L32
        if (mainWin != null) goto L39;
    L40:
        this.mStartingData.mRemoveAfterTransaction = 0;     // Catch: Throwable -> L32
        this.mStartingData.mPrepareRemoveAnimation = false;     // Catch: Throwable -> L32
        goto L42
    L39:
        if (mainWin.isDrawn() == false) goto L40;
    L42:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[1] == false) goto L44;
        String protoLogParam3 = String.valueOf(tStartingWindow);     // Catch: Throwable -> L32
        String protoLogParam4 = String.valueOf(fromActivity);     // Catch: Throwable -> L32
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, -3450064502566932331L, 0, new Object[]{protoLogParam3, protoLogParam4});     // Catch: Throwable -> L32
    L44:
        this.mTransitionController.collect(tStartingWindow);     // Catch: Throwable -> L32
        tStartingWindow.reparent(this, Integer.MAX_VALUE);     // Catch: Throwable -> L32
        tStartingWindow.clearFrozenInsetsState();     // Catch: Throwable -> L32
        if (fromActivity.allDrawn == false) goto L48;
        this.allDrawn = true;     // Catch: Throwable -> L32
    L48:
        if (fromActivity.firstWindowDrawn == false) goto L51;
        this.firstWindowDrawn = true;     // Catch: Throwable -> L32
    L51:
        if (fromActivity.isVisible() == false) goto L53;
        setVisible(true);     // Catch: Throwable -> L32
        setVisibleRequested(true);     // Catch: Throwable -> L32
        this.mVisibleSetFromTransferredStartingWindow = true;     // Catch: Throwable -> L32
    L53:
        setClientVisible(fromActivity.isClientVisible());     // Catch: Throwable -> L32
        if (fromActivity.isAnimating() == false) goto L57;
        transferAnimation(fromActivity);     // Catch: Throwable -> L32
        this.mTransitionChangeFlags |= 8;     // Catch: Throwable -> L32
    L59:
        fromActivity.postWindowRemoveStartingWindowCleanup(tStartingWindow);     // Catch: Throwable -> L32
        fromActivity.mVisibleSetFromTransferredStartingWindow = false;     // Catch: Throwable -> L32
        this.mWmService.updateFocusedWindowLocked(3, true);     // Catch: Throwable -> L32
        getDisplayContent().setLayoutNeeded();     // Catch: Throwable -> L32
        this.mWmService.mWindowPlacerLocked.performSurfacePlacement();     // Catch: Throwable -> L32
        Binder.restoreCallingIdentity(origId);
        return true;
    L57:
        if (this.mTransitionController.getTransitionPlayer() == null) goto L59;
        this.mTransitionChangeFlags |= 8;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L65:
        if (fromActivity.mStartingData != null) goto L67;
        return false;
    L67:
        if ((fromActivity.mStartingData instanceof SnapshotStartingData) == false) goto L72;
        if (isStartingOrientationCompatible(fromActivity) == true) goto L72;
        return false;
    L72:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L74;
        String protoLogParam5 = String.valueOf(fromActivity);
        String protoLogParam6 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, 8639603536400037285L, 0, new Object[]{protoLogParam5, protoLogParam6});
    L74:
        this.mStartingData = fromActivity.mStartingData;
        fromActivity.mStartingData = null;
        fromActivity.startingMoved = true;
        scheduleAddStartingWindow();
        return true;
    }

    void transferStartingWindowFromHiddenAboveTokenIfNeeded() {
        WindowState mainWin = findMainWindow(false);
        if (mainWin != null) goto L5;
    L7:
        this.task.forAllActivities(new ActivityRecord$$ExternalSyntheticLambda13(this));
        return;
    L5:
        if (mainWin.mWinAnimator.getShown() == false) goto L7;
    }

    private /* synthetic */ boolean lambda$transferStartingWindowFromHiddenAboveTokenIfNeeded$8(ActivityRecord fromActivity) {
        if (fromActivity != this) goto L5;
        return true;
    L5:
        StartingData tmpStartingData = fromActivity.mStartingData;
        if (tmpStartingData == null) goto L21;
        if (tmpStartingData.mAssociatedTask != null) goto L21;
        if (this.mTransitionController.isCollecting(fromActivity) == false) goto L21;
        if ((tmpStartingData instanceof SnapshotStartingData) == false) goto L21;
        Rect fromBounds = fromActivity.getBounds();
        Rect myBounds = getBounds();
        if (fromBounds.equals(myBounds) == true) goto L21;
        if (this.mTransitionController.inPlayingTransition(fromActivity) == false) goto L18;
        this.mTransitionController.setNoAnimation(this);
        this.mTransitionController.setNoAnimation(fromActivity);
    L18:
        fromActivity.removeStartingWindow();
        return true;
    L21:
        if (fromActivity.isVisibleRequested() == false) goto L23;
    L25:
        return false;
    L23:
        if (transferStartingWindow(fromActivity) == false) goto L25;
        return true;
    }

    boolean isKeyguardLocked() {
        if (this.mDisplayContent == null) goto L6;
        return this.mDisplayContent.isKeyguardLocked();
    L6:
        return this.mRootWindowContainer.getDefaultDisplay().isKeyguardLocked();
    }

    void checkKeyguardFlagsChanged() {
        boolean containsDismissKeyguard = containsDismissKeyguardWindow();
        boolean containsShowWhenLocked = containsShowWhenLockedWindow();
        if (containsDismissKeyguard == this.mLastContainsDismissKeyguardWindow) goto L5;
    L6:
        this.mDisplayContent.notifyKeyguardFlagsChanged();
    L7:
        this.mLastContainsDismissKeyguardWindow = containsDismissKeyguard;
        this.mLastContainsShowWhenLockedWindow = containsShowWhenLocked;
        this.mLastContainsTurnScreenOnWindow = containsTurnScreenOnWindow();
        return;
    L5:
        if (containsShowWhenLocked == this.mLastContainsShowWhenLockedWindow) goto L7;
        goto L6
    }

    boolean containsDismissKeyguardWindow() {
        if (isRelaunching() == true) goto L5;
        int i = this.mChildren.size() - 1;
    L7:
        if (i < 0) goto L12;
        if ((((WindowState) this.mChildren.get(i)).mAttrs.flags & 4194304) != 0) goto L10;
        i = i - 1;
        goto L7
    L10:
        return true;
    L12:
        return false;
    L5:
        return this.mLastContainsDismissKeyguardWindow;
    }

    boolean containsShowWhenLockedWindow() {
        if (isRelaunching() == true) goto L5;
        int i = this.mChildren.size() - 1;
    L7:
        if (i < 0) goto L12;
        if ((((WindowState) this.mChildren.get(i)).mAttrs.flags & 524288) != 0) goto L10;
        i = i - 1;
        goto L7
    L10:
        return true;
    L12:
        return false;
    L5:
        return this.mLastContainsShowWhenLockedWindow;
    }

    void setShowWhenLocked(boolean showWhenLocked) {
        getExt().traceSetShowWhenLocked(showWhenLocked);
        this.mShowWhenLocked = showWhenLocked;
        this.mAtmService.mRootWindowContainer.ensureActivitiesVisible();
        getExt().executeAppTransitionIfNeeded();
    }

    void setInheritShowWhenLocked(boolean inheritShowWhenLocked) {
        this.mInheritShownWhenLocked = inheritShowWhenLocked;
        this.mAtmService.mRootWindowContainer.ensureActivitiesVisible();
    }

    private static boolean canShowWhenLocked(ActivityRecord r) {
        if (r != null) goto L5;
    L19:
        return false;
    L5:
        if (r.getTaskFragment() == null) goto L19;
        if (canShowWhenLockedInner(r) == false) goto L11;
        return true;
    L11:
        if (r.mInheritShownWhenLocked == false) goto L18;
        ActivityRecord activity = r.getTaskFragment().getActivityBelow(r);
        if (activity != null) goto L15;
        return false;
    L15:
        if (canShowWhenLockedInner(activity) == true) goto L17;
        return false;
    L17:
        return true;
    L18:
        return false;
    }

    private static boolean canShowWhenLockedInner(ActivityRecord r) {
        if (r.inPinnedWindowingMode() == false) goto L5;
    L11:
        return false;
    L5:
        if (r.mShowWhenLocked == false) goto L7;
    L10:
        return true;
    L7:
        if (r.containsShowWhenLockedWindow() == true) goto L10;
        if (r.mIsUserAlwaysVisible == false) goto L11;
        goto L10
    }

    boolean canShowWhenLocked() {
        if (canShowWhenLocked(this) == true) goto L6;
        return false;
    L6:
        TaskFragment taskFragment = getTaskFragment();
        if (taskFragment != null) goto L9;
        return true;
    L9:
        if (taskFragment.hasAdjacentTaskFragment() == true) goto L11;
        return true;
    L11:
        if (taskFragment.isEmbedded() == false) goto L18;
        boolean hasAdjacentNotAllowToShow = taskFragment.forOtherAdjacentTaskFragments(new ActivityRecord$$ExternalSyntheticLambda0());
        return !hasAdjacentNotAllowToShow;
    L18:
        return true;
    }

    private static /* synthetic */ boolean lambda$canShowWhenLocked$9(TaskFragment adjacentTF) {
        return !canShowWhenLocked(adjacentTF.getTopNonFinishingActivity());
    }

    boolean canShowWindows() {
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L9;
        if (this.mSyncState != 1) goto L11;
        return false;
    L11:
        return true;
    L9:
        return this.allDrawn;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean forAllActivities(Predicate<ActivityRecord> callback, boolean traverseTopToBottom) {
        return callback.test(this);
    }

    @Override // com.android.server.wm.WindowContainer
    void forAllActivities(Consumer<ActivityRecord> callback, boolean traverseTopToBottom) {
        callback.accept(this);
    }

    @Override // com.android.server.wm.WindowContainer
    ActivityRecord getActivity(Predicate<ActivityRecord> callback, boolean traverseTopToBottom, ActivityRecord boundary) {
        if (callback.test(this) == true) goto L7;
        return null;
    L7:
        return this;
    }

    void logStartActivity(int tag, Task task) {
        Uri data = this.intent.getData();
        if (data == null) goto L5;
        String r1 = data.toSafeString();
    L6:
        String strData = r1;
        EventLog.writeEvent(tag, new Object[]{Integer.valueOf(this.mUserId), Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(task.mTaskId), this.shortComponentName, this.intent.getAction(), this.intent.getType(), strData, Integer.valueOf(this.intent.getFlags())});
        return;
    L5:
        r1 = null;
        goto L6
    }

    UriPermissionOwner getUriPermissionsLocked() {
        if (this.uriPermissions != null) goto L6;
        this.uriPermissions = new UriPermissionOwner(this.mAtmService.mUgmInternal, this);
    L6:
        return this.uriPermissions;
    }

    void addResultLocked(ActivityRecord from, String resultWho, int requestCode, int resultCode, Intent resultData, IBinder callerToken) {
        ActivityResult r = new ActivityResult(from, resultWho, requestCode, resultCode, resultData, callerToken);
        if (this.results != null) goto L5;
        this.results = new ArrayList();
    L5:
        this.results.add(r);
    }

    void removeResultsLocked(ActivityRecord from, String resultWho, int requestCode) {
        if (this.results == null) goto L21;
        int i = this.results.size() - 1;
    L5:
        if (i < 0) goto L28;
        ActivityResult r = (ActivityResult) this.results.get(i);
        if (r.mFrom != from) goto L20;
        if (((ResultInfo) r).mResultWho != null) goto L14;
        if (resultWho != null) goto L20;
    L17:
        if (((ResultInfo) r).mRequestCode != requestCode) goto L20;
        this.results.remove(i);
        goto L20
    L14:
        if (((ResultInfo) r).mResultWho.equals(resultWho) == true) goto L17;
    L20:
        i = i - 1;
        goto L5
    L28:
        return;
    }

    void sendResult(int callingUid, String resultWho, int requestCode, int resultCode, Intent data, IBinder callerToken, NeededUriGrants dataGrants) {
        sendResult(callingUid, resultWho, requestCode, resultCode, data, callerToken, dataGrants, false);
    }

    void sendResult(int callingUid, String resultWho, int requestCode, int resultCode, Intent data, IBinder callerToken, NeededUriGrants dataGrants, boolean forceSendForMediaProjection) {
        if (this.mCallerState.hasCaller(callerToken) == false) goto L43;
    L9:
        if (callingUid <= 0) goto L13;
        this.mAtmService.mUgmInternal.grantUriPermissionUncheckedFromIntent(dataGrants, getUriPermissionsLocked());
    L13:
        if (ActivityTaskManagerDebugConfig.DEBUG_RESULTS == false) goto L15;
        StringBuilder r0 = new StringBuilder();
        r0.append("Send activity result to ");
        r0.append(this);
        r0.append(" : who=");
        r0.append(resultWho);
        r0.append(" req=");
        int r3 = requestCode;
        r0.append(r3);
        r0.append(" res=");
        int r4 = resultCode;
        r0.append(r4);
        r0.append(" data=");
        Intent r5 = data;
        r0.append(r5);
        r0.append(" forceSendForMediaProjection=");
        r0.append(forceSendForMediaProjection);
        Slog.v("ActivityTaskManager", r0.toString());
    L17:
        if (isState(State.RESUMED) == true) goto L19;
    L27:
        if (forceSendForMediaProjection == true) goto L29;
    L41:
        addResultLocked(null, resultWho, requestCode, resultCode, data, callerToken);
        return;
    L29:
        if (attachedToProcess() == false) goto L41;
        if (isState(State.STARTED, State.PAUSING, State.PAUSED, State.STOPPING, State.STOPPED) == false) goto L41;
        List<ResultInfo> infos = List.of(new ResultInfo(resultWho, requestCode, resultCode, data, callerToken));
        ClientTransactionItem r1 = new ActivityResultItem(this.token, infos);
        ClientTransactionItem r6 = getLifecycleItemForCurrentStateForResult();
        if (r6 == null) goto L37;
        this.mAtmService.getLifecycleManager().scheduleTransactionItems(this.app.getThread(), new ClientTransactionItem[]{r1, r6});     // Catch: RemoteException -> L35
    L45:
        return;
    L37:
        Slog.w("ActivityTaskManager", "Unable to get the lifecycle item for state " + this.mState + " so couldn't immediately send result");     // Catch: RemoteException -> L35
        this.mAtmService.getLifecycleManager().scheduleTransactionItem(this.app.getThread(), r1);     // Catch: RemoteException -> L35
    L35:
        e = move-exception;
        Slog.w("ActivityTaskManager", "Exception thrown sending result to " + this, e);
        return;
    L19:
        if (attachedToProcess() == false) goto L27;
        ArrayList<ResultInfo> list = new ArrayList();
        list.add(new ResultInfo(resultWho, r3, r4, r5, callerToken));
        boolean isSuccessful = this.mAtmService.getLifecycleManager().scheduleTransactionItem(this.app.getThread(), new ActivityResultItem(this.token, list));     // Catch: RemoteException -> L25
        if (isSuccessful == false) goto L27;
        return;
    L25:
        e = move-exception;
        Slog.w("ActivityTaskManager", "Exception thrown sending result to " + this, e);
        goto L27
    L15:
        r3 = requestCode;
        r4 = resultCode;
        r5 = data;
        goto L17
    L43:
        computeCallerInfo(callerToken, data, callingUid, this.mAtmService.getPackageManager().getNameForUid(callingUid), false);     // Catch: RemoteException -> L6
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private ActivityLifecycleItem getLifecycleItemForCurrentStateForResult() {
        switch(this.mState.ordinal()) {
            case 1: goto L10;
            case 2: goto L4;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L6;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        return null;
    L6:
        return new StopActivityItem(this.token);
    L8:
        return new PauseActivityItem(this.token);
    L10:
        return new StartActivityItem(this.token, null);
    }

    private void addNewIntentLocked(ReferrerIntent intent) {
        if (this.newIntents != null) goto L5;
        this.newIntents = new ArrayList();
    L5:
        this.newIntents.add(intent);
    }

    boolean isSleeping() {
        if (this.task == null) goto L6;
        return this.task.shouldSleepActivities();
    L6:
        return this.mAtmService.isSleepingLocked();
    }

    final void deliverNewIntentLocked(int callingUid, Intent intent, NeededUriGrants intentGrants, String referrer, boolean isShareIdentityEnabled, int userId, int recipientAppId) {
        IBinder callerToken = new Binder();
        computeCallerInfo(callerToken, intent, callingUid, referrer, isShareIdentityEnabled);
        this.mAtmService.mUgmInternal.grantUriPermissionUncheckedFromIntent(intentGrants, getUriPermissionsLocked());
        if (isShareIdentityEnabled == false) goto L5;
        PackageManagerInternal pmInternal = this.mAtmService.getPackageManagerInternalLocked();
        pmInternal.grantImplicitAccess(userId, intent, recipientAppId, callingUid, true);
    L5:
        ReferrerIntent rintent = new ReferrerIntent(intent, getFilteredReferrer(referrer), callerToken);
        boolean r4 = false;
        if (isSleeping() == true) goto L8;
    L10:
        boolean r0 = false;
    L11:
        boolean isTopActivityWhileSleeping = r0;
        if (this.mState == State.RESUMED) goto L17;
        if (this.mState == State.PAUSED) goto L17;
        if (isTopActivityWhileSleeping == true) goto L17;
    L28:
        addNewIntentLocked(rintent);
        return;
    L17:
        if (attachedToProcess() == false) goto L28;
        ArrayList<ReferrerIntent> ar = new ArrayList(1);
        ar.add(rintent);
        IBinder r11 = this.token;
        if (this.mState != State.RESUMED) goto L30;
        r4 = true;
    L30:
        boolean isSuccessful = this.mAtmService.getLifecycleManager().scheduleTransactionItem(this.app.getThread(), new NewIntentItem(r11, ar, r4));     // Catch: RemoteException -> L26
        if (isSuccessful == false) goto L28;
        return;
    L26:
        e = move-exception;
        Slog.w("ActivityTaskManager", "Exception thrown sending new intent to " + this, e);
        goto L28
    L8:
        if (isTopRunningActivity() == false) goto L10;
        r0 = true;
        goto L11
    }

    void updateOptionsLocked(ActivityOptions options) {
        if (options != null) goto L4;
        return;
    L4:
        if (ActivityTaskManagerDebugConfig.DEBUG_TRANSITION == false) goto L7;
        Slog.i("ActivityTaskManager", "Update options for " + this);
    L7:
        if (this.mPendingOptions == null) goto L9;
        this.mPendingOptions.abort();
    L9:
        setOptions(options);
    }

    boolean getLaunchedFromBubble() {
        return this.mLaunchedFromBubble;
    }

    private void setOptions(ActivityOptions options) {
        this.mLaunchedFromBubble = options.getLaunchedFromBubble();
        this.mPendingOptions = options;
        if (options.getAnimationType() != 13) goto L5;
        this.mPendingRemoteAnimation = options.getRemoteAnimationAdapter();
    L5:
        this.mPendingRemoteTransition = options.getRemoteTransition();
    }

    void applyOptionsAnimation() {
        if (ActivityTaskManagerDebugConfig.DEBUG_TRANSITION == false) goto L6;
        Slog.i("ActivityTaskManager", "Applying options for " + this);
    L6:
        if (this.mPendingRemoteAnimation == null) goto L9;
        this.mTransitionController.setStatusBarTransitionDelay(this.mPendingRemoteAnimation.getStatusBarTransitionDelay());
    L16:
        clearOptionsAnimationForSiblings();
        return;
    L9:
        if (this.mPendingOptions != null) goto L12;
        return;
    L12:
        if (this.mPendingOptions.getAnimationType() != 5) goto L15;
        this.mTransitionController.setOverrideAnimation(android.window.TransitionInfo.AnimationOptions.makeSceneTransitionAnimOptions(), this, null, null);
        return;
    L15:
        applyOptionsAnimation(this.mPendingOptions, this.intent);
        goto L16
    }

    private void applyOptionsAnimation(ActivityOptions pendingOptions, Intent intent) {
        int animationType = pendingOptions.getAnimationType();
        getDisplayContent();
        android.window.TransitionInfo.AnimationOptions options = null;
        IRemoteCallback startCallback = null;
        IRemoteCallback finishCallback = null;
        boolean scaleUp = false;
        switch(animationType) {
            case -1: goto L22;
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L17;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L22;
            case 9: goto L22;
            case 10: goto L4;
            case 11: goto L6;
            case 12: goto L5;
            default: goto L4;
        };
    L4:
        Slog.e("WindowManager", "applyOptionsLocked: Unknown animationType=" + animationType);
        goto L22
    L5:
        options = android.window.TransitionInfo.AnimationOptions.makeCrossProfileAnimOptions();
        goto L22
    L6:
        options = android.window.TransitionInfo.AnimationOptions.makeClipRevealAnimOptions(pendingOptions.getStartX(), pendingOptions.getStartY(), pendingOptions.getWidth(), pendingOptions.getHeight());
        if (intent.getSourceBounds() != null) goto L22;
        intent.setSourceBounds(new Rect(pendingOptions.getStartX(), pendingOptions.getStartY(), pendingOptions.getStartX() + pendingOptions.getWidth(), pendingOptions.getStartY() + pendingOptions.getHeight()));
        goto L22
    L17:
        options = android.window.TransitionInfo.AnimationOptions.makeScaleUpAnimOptions(pendingOptions.getStartX(), pendingOptions.getStartY(), pendingOptions.getWidth(), pendingOptions.getHeight(), pendingOptions.getOverrideTaskTransition());
        if (intent.getSourceBounds() != null) goto L22;
        intent.setSourceBounds(new Rect(pendingOptions.getStartX(), pendingOptions.getStartY(), pendingOptions.getStartX() + pendingOptions.getWidth(), pendingOptions.getStartY() + pendingOptions.getHeight()));
        goto L22
    L20:
        options = android.window.TransitionInfo.AnimationOptions.makeCustomAnimOptions(pendingOptions.getPackageName(), pendingOptions.getCustomEnterResId(), 0, pendingOptions.getCustomExitResId(), pendingOptions.getOverrideTaskTransition());
        startCallback = pendingOptions.getAnimationStartedListener();
        finishCallback = pendingOptions.getAnimationFinishedListener();
    L22:
        if (options == null) goto L24;
        this.mTransitionController.setOverrideAnimation(options, this, startCallback, finishCallback);
    L24:
        int backgroundColor = pendingOptions.getCustomBackgroundColor();
        if (backgroundColor == 0) goto L28;
        this.mTransitionController.setOverrideBackgroundColor(backgroundColor);
        return;
    L28:
        return;
    L11:
        if (animationType != 3) goto L13;
        scaleUp = true;
    L13:
        HardwareBuffer buffer = pendingOptions.getThumbnail();
        options = android.window.TransitionInfo.AnimationOptions.makeThumbnailAnimOptions(buffer, pendingOptions.getStartX(), pendingOptions.getStartY(), scaleUp);
        startCallback = pendingOptions.getAnimationStartedListener();
        if (intent.getSourceBounds() != null) goto L22;
        if (buffer == null) goto L22;
        intent.setSourceBounds(new Rect(pendingOptions.getStartX(), pendingOptions.getStartY(), pendingOptions.getStartX() + buffer.getWidth(), pendingOptions.getStartY() + buffer.getHeight()));
        goto L22
    }

    void clearAllDrawn() {
        this.allDrawn = false;
    }

    private boolean allDrawnStatesConsidered() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L12;
        WindowState child = (WindowState) this.mChildren.get(i);
        if (child.mightAffectAllDrawn() == false) goto L10;
        if (child.getDrawnStateEvaluated() == true) goto L10;
        return false;
    L10:
        i = i - 1;
        goto L3
    L12:
        return true;
    }

    void updateAllDrawn() {
        if (this.allDrawn == true) goto L20;
        int numInteresting = this.mNumInterestingWindows;
        if (numInteresting > 0) goto L7;
        return;
    L7:
        if (allDrawnStatesConsidered() == true) goto L9;
        return;
    L9:
        if (this.mNumDrawnWindows >= numInteresting) goto L11;
        return;
    L11:
        if (isRelaunching() == false) goto L13;
        return;
    L13:
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L15;
        Slog.v("ActivityTaskManager", "allDrawn: " + this + " interesting=" + numInteresting + " drawn=" + this.mNumDrawnWindows);
    L15:
        this.allDrawn = true;
        if (this.mDisplayContent == null) goto L18;
        this.mDisplayContent.setLayoutNeeded();
    L18:
        this.mWmService.mH.obtainMessage(32, this).sendToTarget();
        return;
    }

    void abortAndClearOptionsAnimation() {
        if (this.mPendingOptions == null) goto L5;
        this.mPendingOptions.abort();
    L5:
        clearOptionsAnimation();
    }

    void clearOptionsAnimation() {
        this.mPendingOptions = null;
        this.mPendingRemoteAnimation = null;
        this.mPendingRemoteTransition = null;
    }

    void clearOptionsAnimationForSiblings() {
        if (this.task != null) goto L5;
        clearOptionsAnimation();
        return;
    L5:
        this.task.forAllActivities(new ActivityRecord$$ExternalSyntheticLambda17());
    }

    ActivityOptions getOptions() {
        return this.mPendingOptions;
    }

    ActivityOptions.SceneTransitionInfo takeSceneTransitionInfo() {
        if (ActivityTaskManagerDebugConfig.DEBUG_TRANSITION == false) goto L6;
        Slog.i("ActivityTaskManager", "Taking SceneTransitionInfo for " + this + " callers=" + Debug.getCallers(6));
    L6:
        if (this.mPendingOptions != null) goto L8;
        return null;
    L8:
        ActivityOptions opts = this.mPendingOptions;
        this.mPendingOptions = null;
        return opts.getSceneTransitionInfo();
    }

    RemoteTransition takeRemoteTransition() {
        RemoteTransition out = this.mPendingRemoteTransition;
        this.mPendingRemoteTransition = null;
        return out;
    }

    boolean allowMoveToFront() {
        if (this.mPendingOptions != null) goto L5;
    L8:
        return true;
    L5:
        if (this.mPendingOptions.getAvoidMoveToFront() == false) goto L8;
        return false;
    }

    void removeUriPermissionsLocked() {
        if (this.uriPermissions == null) goto L6;
        this.uriPermissions.removeUriPermissions();
        this.uriPermissions = null;
        return;
    }

    void pauseKeyDispatchingLocked() {
        if (this.keysPaused == true) goto L8;
        this.keysPaused = true;
        if (getDisplayContent() == null) goto L9;
        getDisplayContent().getInputMonitor().pauseDispatchingLw(this);
        return;
    L9:
        return;
    }

    void resumeKeyDispatchingLocked() {
        if (this.keysPaused == false) goto L8;
        this.keysPaused = false;
        if (getDisplayContent() == null) goto L9;
        getDisplayContent().getInputMonitor().resumeDispatchingLw(this);
        return;
    L9:
        return;
    }

    private void updateTaskDescription(CharSequence description) {
        this.task.lastDescription = description;
    }

    void setDeferHidingClient() {
    }

    void clearDeferHidingClient() {
    }

    boolean getDeferHidingClient() {
        return this.mDeferHidingClient;
    }

    boolean canAffectSystemUiFlags() {
        TaskFragment taskFragment = getTaskFragment();
        if (taskFragment != null) goto L5;
    L13:
        return false;
    L5:
        if (taskFragment.canAffectSystemUiFlags() == false) goto L13;
        if (isVisible() == false) goto L13;
        if (this.mWaitForEnteringPinnedMode == true) goto L13;
        if (inPinnedWindowingMode() == true) goto L13;
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isVisible() {
        return this.mVisible;
    }

    void setVisible(boolean visible) {
        if (visible == this.mVisible) goto L9;
        this.mVisible = visible;
        if (this.app == null) goto L7;
        this.mTaskSupervisor.onProcessActivityStateChanged(this.app, false);
    L7:
        scheduleAnimation();
        return;
    }

    private ActivityRecord getSharedStartingWindowOwnerIfTaskDrawn() {
        if (this.task.getActivity(new ActivityRecord$$ExternalSyntheticLambda2()) == null) goto L5;
        return null;
    L5:
        return this.task.getActivity(new ActivityRecord$$ExternalSyntheticLambda3());
    }

    private static /* synthetic */ boolean lambda$getSharedStartingWindowOwnerIfTaskDrawn$10(ActivityRecord r) {
        if (r.isVisibleRequested() == true) goto L5;
    L7:
        return false;
    L5:
        if (r.firstWindowDrawn == true) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$getSharedStartingWindowOwnerIfTaskDrawn$11(ActivityRecord ar) {
        if (ar.mStartingData == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean setVisibleRequested(boolean visible) {
        boolean r1 = false;
        if (super.setVisibleRequested(visible) == true) goto L5;
        return false;
    L5:
        setInsetsFrozen(!visible);
        updateVisibleForServiceConnection();
        if (this.app == null) goto L8;
        this.mTaskSupervisor.onProcessActivityStateChanged(this.app, false);
    L8:
        logAppCompatState();
        if (visible == true) goto L31;
        InputTarget imeInputTarget = this.mDisplayContent.getImeInputTarget();
        if (imeInputTarget != null) goto L13;
    L22:
        this.mLastImeShown = r1;
        finishOrAbortReplacingWindow();
        if (this.firstWindowDrawn == true) goto L31;
        if (this.task == null) goto L31;
        if (this.task.mSharedStartingData == null) goto L31;
        ActivityRecord r = getSharedStartingWindowOwnerIfTaskDrawn();
        if (r == null) goto L31;
        r.removeStartingWindow();
        goto L31
    L13:
        if (imeInputTarget.getWindowState() == null) goto L22;
        if (imeInputTarget.getWindowState().mActivityRecord != this) goto L22;
        if (this.mDisplayContent.mInputMethodWindow == null) goto L22;
        if (this.mDisplayContent.mInputMethodWindow.isVisible() == false) goto L22;
        r1 = true;
    L31:
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    protected boolean onChildVisibleRequestedChanged(WindowContainer child) {
        return false;
    }

    void setVisibility(boolean visible) {
        if (getParent() != null) goto L7;
        Slog.w("WindowManager", "Attempted to set visibility of non-existing app token: " + this.token);
        return;
    L7:
        if (visible == this.mVisibleRequested) goto L9;
    L15:
        if (visible == false) goto L17;
        this.mDeferHidingClient = false;
    L17:
        setVisibility(visible, this.mDeferHidingClient);
        this.mAtmService.addWindowLayoutReasons(2);
        this.mTaskSupervisor.getActivityMetricsLogger().notifyVisibilityChanged(this);
        this.mTaskSupervisor.mAppVisibilitiesChangedSinceLastPause = true;
        return;
    L9:
        if (visible != this.mVisible) goto L15;
        if (visible != isClientVisible()) goto L15;
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L15;
    }

    private void setVisibility(boolean visible, boolean deferHidingClient) {
        if (visible == true) goto L12;
        if (this.mVisibleRequested == true) goto L12;
        if (deferHidingClient == false) goto L8;
        return;
    L8:
        if (this.mLastDeferHidingClient == false) goto L72;
        this.mLastDeferHidingClient = deferHidingClient;
        setClientVisible(false);
        return;
    L72:
        return;
    L12:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_APP_TRANSITIONS_enabled[1] == false) goto L14;
        String protoLogParam0 = String.valueOf(this.token);
        boolean protoLogParam2 = isVisible();
        boolean protoLogParam3 = this.mVisibleRequested;
        String protoLogParam4 = String.valueOf(Debug.getCallers(30));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, 4035933462427483756L, AudioChannelMask.IN_6, new Object[]{protoLogParam0, Boolean.valueOf(visible), Boolean.valueOf(protoLogParam2), Boolean.valueOf(protoLogParam3), protoLogParam4});
    L14:
        getExt().traceSetAppVisibility(this, visible);
        boolean isCollecting = false;
        boolean inFinishingTransition = false;
        if (this.mTransitionController.isShellTransitionsEnabled() == true) goto L17;
    L30:
        this.mAtmService.mBackNavigationController.onAppVisibilityChanged(this, visible);
        setVisibleRequested(visible);
        this.mLastDeferHidingClient = deferHidingClient;
        if (visible == false) goto L33;
        this.startingMoved = false;
        if (isVisible() == true) goto L42;
    L43:
        clearAllDrawn();
    L44:
        setClientVisible(true);
        if (this.mWmService.mFlags.mEnsureWallpaperInTransitions == true) goto L48;
        requestUpdateWallpaperIfNeeded();
    L48:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[1] == false) goto L50;
        String protoLogParam1 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 1728033820691545386L, 0, new Object[]{protoLogParam1});
    L50:
        this.mAppStopped = false;
        transferStartingWindowFromHiddenAboveTokenIfNeeded();
    L52:
        if (this.mWmService.mFlags.mEnsureWallpaperInTransitions == false) goto L54;
        requestUpdateWallpaperIfNeeded();
    L54:
        if (isCollecting == false) goto L66;
        if (visible == false) goto L57;
        this.mTransitionChangeFlags &= -32769;
    L64:
        getExt().updateFocusedWindowIfNeeded(visible);
        return;
    L57:
        if (this.mTransitionController.inPlayingTransition(this) == false) goto L64;
        this.mTransitionChangeFlags |= 32768;
        if (this.mTransitionController.mFinishingTransition == null) goto L64;
        if (this.mTransitionController.mFinishingTransition.isTransientLaunch(this) == false) goto L64;
        this.mTransitionChangeFlags |= 294912;
        goto L64
    L66:
        if (inFinishingTransition == false) goto L69;
        this.mTransitionController.mValidateCommitVis.add(this);
        return;
    L69:
        commitVisibility(visible, true);
        updateReportedVisibilityLocked();
        return;
    L42:
        if (this.mAppStopped == false) goto L44;
    L33:
        if (this.startingMoved == false) goto L52;
        if (this.firstWindowDrawn == true) goto L52;
        if (hasChild() == false) goto L52;
        setClientVisible(false);
        goto L52
    L17:
        if (this.mTransitionController.isCollecting() == false) goto L19;
        isCollecting = true;
        this.mTransitionController.collect(this);
        goto L30
    L19:
        inFinishingTransition = this.mTransitionController.inFinishingTransition(this);
        if (inFinishingTransition == true) goto L30;
        if (visible == false) goto L28;
        if (this.mDisplayContent.isSleeping() == true) goto L25;
    L26:
        this.mTransitionController.onVisibleWithoutCollectingTransition(this, Debug.getCallers(1, 1));
        goto L30
    L25:
        if (canShowWhenLocked() == false) goto L30;
    L28:
        if (this.mDisplayContent.isSleeping() == true) goto L30;
        Slog.w("ActivityTaskManager", "Set invisible without transition " + this);
        goto L30
    }

    void commitVisibility(boolean visible, boolean performLayout, boolean fromTransition) {
        this.mVisibleSetFromTransferredStartingWindow = false;
        if (visible != isVisible()) goto L6;
        return;
    L6:
        if (visible == true) goto L10;
        int i = this.mChildren.size() - 1;
    L8:
        if (i < 0) goto L10;
        ((WindowState) this.mChildren.get(i)).onAppCommitInvisible();
        i = i - 1;
    L10:
        setVisible(visible);
        setVisibleRequested(visible);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_APP_TRANSITIONS_enabled[1] == false) goto L13;
        String protoLogParam0 = String.valueOf(this);
        boolean protoLogParam2 = this.mVisibleRequested;
        boolean protoLogParam3 = inTransition();
        String protoLogParam4 = String.valueOf(Debug.getCallers(5));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, 7522671199860044140L, AudioChannelMask.IN_6, new Object[]{protoLogParam0, Boolean.valueOf(visible), Boolean.valueOf(protoLogParam2), Boolean.valueOf(protoLogParam3), protoLogParam4});
    L13:
        getExt().traceCommitVisibility(this, visible);
        if (visible == true) goto L16;
    L24:
        Task task = getOrganizedTask();
    L25:
        if (task == null) goto L27;
        task.dispatchTaskInfoChangedIfNeeded(false);
        task = task.getParent().asTask();
        goto L25
    L27:
        DisplayContent displayContent = getDisplayContent();
        displayContent.getInputMonitor().setUpdateInputWindowsNeededLw();
        if (performLayout == false) goto L30;
        this.mWmService.updateFocusedWindowLocked(3, false);
        this.mWmService.mWindowPlacerLocked.performSurfacePlacement();
    L30:
        displayContent.getInputMonitor().updateInputWindowsLw(false);
        this.mTransitionChangeFlags = 0;
        if (visible == false) goto L33;
    L34:
        setClientVisible(visible);
    L35:
        if (fromTransition == true) goto L42;
        this.mWmService.mSnapshotController.notifyAppVisibilityChanged(this, visible);
        if (visible == false) goto L43;
        this.mEnteringAnimation = true;
        this.mWmService.mActivityManagerAppTransitionNotifier.onAppTransitionFinishedLocked(this.token);
        return;
    L43:
        return;
    L42:
        return;
    L33:
        if (this.mState == State.RESUMED) goto L35;
    L16:
        if (this.mStartingWindow == null) goto L24;
        if (this.mStartingWindow.isDrawn() == true) goto L24;
        if (this.firstWindowDrawn == false) goto L22;
    L23:
        this.mStartingWindow.clearPolicyVisibilityFlag(1);
        this.mStartingWindow.mLegacyPolicyVisibilityAfterAnim = false;
        goto L24
    L22:
        if (this.allDrawn == false) goto L24;
        goto L23
    }

    void commitVisibility(boolean visible, boolean performLayout) {
        commitVisibility(visible, performLayout, false);
    }

    void setNeedsSafeRegionBounds(boolean needsSafeRegionBounds) {
        this.mAppCompatController.getSafeRegionPolicy().setNeedsSafeRegionBounds(needsSafeRegionBounds);
    }

    void commitFinishDrawing(SurfaceControl.Transaction t) {
        boolean committed = false;
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L6;
        committed = committed | ((WindowState) this.mChildren.get(i)).commitFinishDrawing(t);
        i = i - 1;
        goto L3
    L6:
        if (committed == false) goto L10;
        requestUpdateWallpaperIfNeeded();
        return;
    }

    void setRecentsScreenshotEnabled(boolean enabled) {
        this.mEnableRecentsScreenshot = enabled;
    }

    boolean shouldUseAppThemeSnapshot() {
        if (this.mEnableRecentsScreenshot == true) goto L5;
        return true;
    L5:
        if (forAllWindows(new ActivityRecord$$ExternalSyntheticLambda27(), true) == true) goto L10;
        return false;
    L10:
        return true;
    }

    void setCurrentLaunchCanTurnScreenOn(boolean currentLaunchCanTurnScreenOn) {
        this.mCurrentLaunchCanTurnScreenOn = currentLaunchCanTurnScreenOn;
    }

    boolean currentLaunchCanTurnScreenOn() {
        return this.mCurrentLaunchCanTurnScreenOn;
    }

    void setState(State state, String reason) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L6;
        String protoLogParam0 = String.valueOf(this);
        String protoLogParam1 = String.valueOf(this.mState);
        String protoLogParam2 = String.valueOf(state);
        String protoLogParam3 = String.valueOf(reason);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, -6873410057142191118L, 0, new Object[]{protoLogParam0, protoLogParam1, protoLogParam2, protoLogParam3});
    L6:
        if (state == this.mState) goto L8;
        State prevState = this.mState;
        this.mState = state;
        callServiceTrackeronActivityStatechange(state, false);
        if (getTaskFragment() == null) goto L15;
        getTaskFragment().onActivityStateChanged(this, state, reason);
    L15:
        if (state == State.STOPPING) goto L17;
    L22:
        updateVisibleForServiceConnection();
        if (this.app == null) goto L25;
        this.mTaskSupervisor.onProcessActivityStateChanged(this.app, false);
    L25:
        String mDisplayInfo = "";
        mDisplayInfo = getRootTask().getDisplayContent().getDisplay().getDisplayId() + "###" + getRootTask().getDisplayContent().getDisplay().getName();     // Catch: Exception -> L28
    L30:
        switch(state.ordinal()) {
            case 1: goto L57;
            case 2: goto L52;
            case 3: goto L72;
            case 4: goto L51;
            case 5: goto L49;
            case 6: goto L45;
            case 7: goto L72;
            case 8: goto L41;
            case 9: goto L33;
            default: goto L72;
        };
    L45:
        this.mAtmService.updateActivityUsageStats(this, 23, null, mDisplayInfo);
        if (this.mDisplayContent == null) goto L67;
        this.mDisplayContent.mUnknownAppVisibilityController.appRemovedOrHidden(this);
        return;
    L67:
        return;
    L51:
        this.mAtmService.updateBatteryStats(this, false);
        this.mAtmService.updateActivityUsageStats(this, 2, null, mDisplayInfo);
        return;
    L52:
        this.mAtmService.updateBatteryStats(this, true);
        if (getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L55;
        this.mAtmService.getObricExt().updateMutePackageLocked();
    L55:
        this.mAtmService.updateActivityUsageStats(this, 1, null, mDisplayInfo);
        goto L57
    L72:
        return;
    L33:
        if (this.app != null) goto L35;
    L39:
        this.mAtmService.updateActivityUsageStats(this, 24, null, mDisplayInfo);
        this.idle = false;
        goto L41
    L35:
        if (this.mVisible == false) goto L37;
    L38:
        this.mAtmService.updateBatteryStats(this, false);
        goto L39
    L37:
        if (this.mVisibleRequested == false) goto L39;
    L41:
        if (this.app != null) goto L43;
        return;
    L43:
        if (this.app.hasActivities() == true) goto L65;
        this.app.updateProcessInfo(true, false, true, false);
        return;
    L65:
        return;
    L49:
        if (prevState != State.RESUMED) goto L69;
        this.mAtmService.updateActivityUsageStats(this, 2, null, mDisplayInfo);
        return;
    L69:
        return;
    L57:
        if (this.app == null) goto L59;
        this.app.updateProcessInfo(false, true, true, true);
    L59:
        this.mAtmService.mH.post(new ActivityRecord$$ExternalSyntheticLambda24(this));
        return;
    L17:
        if (isSleeping() == true) goto L22;
        if (getParent() != null) goto L22;
        Slog.w("WindowManager", "Attempted to notify stopping on non-existing app token: " + this.token);
        return;
    L8:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L63;
        String protoLogParam4 = String.valueOf(state);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 4437231720834282527L, 0, new Object[]{protoLogParam4});
        return;
    }

    void callServiceTrackeronActivityStatechange(State state, boolean early_notify) {
        ActivityDetails aDetails = new ActivityDetails();
        ActivityStats aStats = new ActivityStats();
        int aState = 11;
        aDetails.launchedFromPid = this.launchedFromPid;
        aDetails.launchedFromUid = this.launchedFromUid;
        aDetails.packageName = this.packageName;
        if (this.processName == null) goto L5;
        String r3 = this.processName;
    L6:
        aDetails.processName = r3;
        aDetails.intent = this.intent.getComponent().toString();
        aDetails.className = this.intent.getComponent().getClassName();
        aDetails.versioncode = this.info.applicationInfo.versionCode;
        aStats.createTime = this.createTime;
        aStats.lastVisibleTime = this.lastVisibleTime;
        aStats.launchCount = this.launchCount;
        aStats.lastLaunchTime = this.lastLaunchTime;
        switch(state.ordinal()) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            default: goto L21;
        };
    L9:
        aState = 10;
        goto L21
    L10:
        aState = 9;
        goto L21
    L11:
        aState = 8;
        goto L21
    L12:
        aState = 7;
        goto L21
    L13:
        aState = 6;
        goto L21
    L14:
        aState = 5;
        goto L21
    L15:
        aState = 4;
        goto L21
    L16:
        aState = 3;
        goto L21
    L17:
        aState = 2;
        goto L21
    L18:
        aState = 1;
        goto L21
    L19:
        aState = 0;
    L21:
        if (this.isLowRamDevice == false) goto L23;
        return;
    L23:
        if (ActivityTaskManagerDebugConfig.DEBUG_SERVICETRACKER == false) goto L25;
        Slog.v("ActivityTaskManager", "Calling mServicetracker.OnActivityStateChange with flag " + early_notify + " state " + state);
    L25:
        IServicetracker mServicetracker = null;
        if (0 == 0) goto L30;
        mServicetracker.OnActivityStateChange(aState, aDetails, aStats, early_notify);     // Catch: RemoteException -> L28
    L34:
        return;
    L30:
        Slog.v("ActivityTaskManager", "Unable to get servicetracker HAL instance");     // Catch: RemoteException -> L28
    L28:
        e = move-exception;
        Slog.e("ActivityTaskManager", "Failed to send activity state change details to servicetracker HAL", e);
        this.mAtmService.mTaskSupervisor.destroyServicetrackerInstance();
        return;
    L5:
        r3 = "none";
        goto L6
    }

    private void notifyActivityStartedToContentCaptureService() {
        ContentCaptureManagerInternal contentCaptureService = (ContentCaptureManagerInternal) LocalServices.getService(ContentCaptureManagerInternal.class);
        if (contentCaptureService == null) goto L10;
        int r1 = this.mUserId;
        ComponentName r2 = this.mActivityComponent;
        if (getTask() == null) goto L7;
        int r4 = getTask().mTaskId;
    L8:
        contentCaptureService.notifyActivityEvent(r1, r2, 10000, new ActivityId(r4, this.shareableActivityToken));
        contentCaptureService.sendActivityStartAssistData(this.mUserId, this.shareableActivityToken, this.intent);
        return;
    L7:
        r4 = -1;
        goto L8
    }

    State getState() {
        return this.mState;
    }

    boolean isState(State state) {
        if (state != this.mState) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isState(State state1, State state2) {
        if (state1 != this.mState) goto L5;
    L8:
        return true;
    L5:
        if (state2 == this.mState) goto L8;
        return false;
    }

    boolean isState(State state1, State state2, State state3) {
        if (state1 != this.mState) goto L5;
    L10:
        return true;
    L5:
        if (state2 == this.mState) goto L10;
        if (state3 == this.mState) goto L10;
        return false;
    }

    boolean isState(State state1, State state2, State state3, State state4) {
        if (state1 != this.mState) goto L5;
    L12:
        return true;
    L5:
        if (state2 == this.mState) goto L12;
        if (state3 == this.mState) goto L12;
        if (state4 == this.mState) goto L12;
        return false;
    }

    boolean isState(State state1, State state2, State state3, State state4, State state5) {
        if (state1 != this.mState) goto L5;
    L14:
        return true;
    L5:
        if (state2 == this.mState) goto L14;
        if (state3 == this.mState) goto L14;
        if (state4 == this.mState) goto L14;
        if (state5 == this.mState) goto L14;
        return false;
    }

    boolean isState(State state1, State state2, State state3, State state4, State state5, State state6) {
        if (state1 != this.mState) goto L5;
    L16:
        return true;
    L5:
        if (state2 == this.mState) goto L16;
        if (state3 == this.mState) goto L16;
        if (state4 == this.mState) goto L16;
        if (state5 == this.mState) goto L16;
        if (state6 == this.mState) goto L16;
        return false;
    }

    void destroySurfaces() {
        destroySurfaces(false);
    }

    private void destroySurfaces(boolean cleanupOnResume) {
        boolean destroyedSomething = false;
        ArrayList<WindowState> children = new ArrayList(this.mChildren);
        int i = children.size() - 1;
    L3:
        if (i < 0) goto L6;
        WindowState win = children.get(i);
        destroyedSomething = destroyedSomething | win.destroySurface(cleanupOnResume, this.mAppStopped);
        i = i - 1;
        goto L3
    L6:
        if (destroyedSomething == false) goto L10;
        DisplayContent dc = getDisplayContent();
        dc.assignWindowLayers(true);
        updateLetterboxSurfaceIfNeeded(null);
        return;
    }

    void notifyAppResumed() {
        if (getParent() != null) goto L6;
        Slog.w("WindowManager", "Attempted to notify resumed of non-existing app token: " + this.token);
        return;
    L6:
        boolean wasStopped = this.mAppStopped;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[1] == false) goto L9;
        String protoLogParam1 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 926038819327785799L, 3, new Object[]{Boolean.valueOf(wasStopped), protoLogParam1});
    L9:
        this.mAppStopped = false;
        if (this.mAtmService.getActivityStartController().isInExecution() == false) goto L12;
        setCurrentLaunchCanTurnScreenOn(true);
    L12:
        if (wasStopped == true) goto L15;
        destroySurfaces(true);
        return;
    }

    void notifyUnknownVisibilityLaunchedForKeyguardTransition() {
        if (this.mNoDisplay == false) goto L5;
        return;
    L5:
        if (isKeyguardLocked() == false) goto L10;
        this.mDisplayContent.mUnknownAppVisibilityController.notifyLaunched(this);
        return;
    }

    private boolean shouldBeVisible(boolean behindOccludedContainer, boolean ignoringKeyguard) {
        updateVisibilityIgnoringKeyguard(behindOccludedContainer);
        if (ignoringKeyguard == false) goto L7;
        return this.visibleIgnoringKeyguard;
    L7:
        return shouldBeVisibleUnchecked();
    }

    boolean shouldBeVisibleUnchecked() {
        Task rootTask = getRootTask();
        if (rootTask != null) goto L5;
    L26:
        return false;
    L5:
        if (this.visibleIgnoringKeyguard == false) goto L26;
        if (inPinnedWindowingMode() == false) goto L13;
        if (rootTask.isForceHidden() == false) goto L13;
        return false;
    L13:
        if (hasOverlayOverUntrustedModeEmbedded() == false) goto L16;
        return false;
    L16:
        if (this.mWmService.mPresentationController.shouldOccludeActivities(getDisplayId()) == false) goto L19;
        return false;
    L19:
        if (this.mDisplayContent.isSleeping() == false) goto L25;
        if (this.mDisplayContent.isKeyguardGoingAway() == true) goto L25;
        return canTurnScreenOn();
    L25:
        return this.mTaskSupervisor.getKeyguardController().checkKeyguardVisibility(this);
    }

    boolean hasOverlayOverUntrustedModeEmbedded() {
        if (isEmbeddedInUntrustedMode() == true) goto L5;
    L11:
        return false;
    L5:
        if (getTask() == null) goto L11;
        ActivityRecord differentUidOverlayActivity = getTask().getActivity(new ActivityRecord$$ExternalSyntheticLambda30(this), this, false, false);
        if (differentUidOverlayActivity == null) goto L12;
        return true;
    L12:
        return false;
    }

    private /* synthetic */ boolean lambda$hasOverlayOverUntrustedModeEmbedded$12(ActivityRecord a) {
        if (a.finishing == false) goto L5;
    L9:
        return false;
    L5:
        if (a.getUid() == getUid()) goto L9;
        if (Rect.intersects(a.getBounds(), getBounds()) == false) goto L9;
        return true;
    }

    void updateVisibilityIgnoringKeyguard(boolean behindOccludedContainer) {
        if (behindOccludedContainer == false) goto L6;
        if (this.mLaunchTaskBehind == true) goto L6;
    L8:
        boolean r0 = false;
    L9:
        this.visibleIgnoringKeyguard = r0;
        return;
    L6:
        if (showToCurrentUser() == false) goto L8;
        r0 = true;
        goto L9
    }

    boolean shouldBeVisible() {
        return shouldBeVisible(false);
    }

    boolean shouldBeVisible(boolean ignoringKeyguard) {
        Task task = getTask();
        boolean behindOccludedContainer = false;
        if (task != null) goto L6;
        return false;
    L6:
        if (task.shouldBeVisible(null) == true) goto L8;
    L9:
        behindOccludedContainer = true;
    L11:
        return shouldBeVisible(behindOccludedContainer, ignoringKeyguard);
    L8:
        if (task.getOccludingActivityAbove(this) == null) goto L11;
        goto L9
    }

    void makeVisibleIfNeeded(ActivityRecord starting, boolean reportToClient) {
        if (this.mState == State.RESUMED) goto L5;
    L6:
        if (this != starting) goto L12;
    L8:
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L31;
        Slog.d("ActivityTaskManager", "Not making visible, r=" + this + " state=" + this.mState + " starting=" + starting);
        return;
    L31:
        return;
    L12:
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L14;
        Slog.v("ActivityTaskManager", "Making visible and scheduling visibility: " + this);
    L14:
        Task rootTask = getRootTask();
    L18:
        e = move-exception;
        Slog.w("ActivityTaskManager", "Exception thrown making visible: " + this.intent.getComponent(), e);
    L27:
        handleAlreadyVisible();
        return;
    L16:
        if (rootTask.mTranslucentActivityWaiting == null) goto L20;
        updateOptionsLocked(this.returningOptions);     // Catch: Exception -> L18
        rootTask.mUndrawnActivitiesBelowTopTranslucent.add(this);     // Catch: Exception -> L18
    L20:
        setVisibility(true);     // Catch: Exception -> L18
        this.app.postPendingUiCleanMsg(true);     // Catch: Exception -> L18
        if (reportToClient == false) goto L23;
        this.mClientVisibilityDeferred = false;     // Catch: Exception -> L18
        makeActiveIfNeeded(starting);     // Catch: Exception -> L18
    L24:
        this.mTaskSupervisor.mStoppingActivities.remove(this);     // Catch: Exception -> L18
        goto L27
    L23:
        this.mClientVisibilityDeferred = true;     // Catch: Exception -> L18
        goto L24
    L5:
        if (this.mVisibleRequested == true) goto L8;
        goto L6
    }

    void makeInvisible() {
        if (this.mVisibleRequested == true) goto L9;
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L33;
        Slog.v("ActivityTaskManager", "Already invisible: " + this);
        return;
    L33:
        return;
    L9:
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L31;
        Slog.v("ActivityTaskManager", "Making invisible: " + this + ", state=" + this.mState);
    L31:
        boolean canEnterPictureInPicture = checkEnterPictureInPictureState("makeInvisible", true);     // Catch: Exception -> L17
        if (canEnterPictureInPicture == true) goto L15;
    L19:
        boolean deferHidingClient = false;
    L21:
        if (deferHidingClient == false) goto L23;
        setDeferHidingClient();     // Catch: Exception -> L17
    L24:
        setVisibility(false);     // Catch: Exception -> L17
        switch(this.mState.ordinal()) {
            case 0: goto L27;
            case 1: goto L27;
            case 2: goto L27;
            case 3: goto L27;
            case 4: goto L27;
            default: goto L35;
        };     // Catch: Exception -> L17
    L27:
        addToStopping(true, canEnterPictureInPicture, "makeInvisible");     // Catch: Exception -> L17
        return;
    L35:
        return;
    L23:
        clearDeferHidingClient();     // Catch: Exception -> L17
        goto L24
    L15:
        if (isState(State.STARTED, State.STOPPING, State.STOPPED, State.PAUSED) == true) goto L19;
        deferHidingClient = true;
    L17:
        e = move-exception;
        Slog.w("ActivityTaskManager", "Exception thrown making hidden: " + this.intent.getComponent(), e);
    }

    boolean makeActiveIfNeeded(ActivityRecord activeActivity) {
        if (shouldResumeActivity(activeActivity) == false) goto L10;
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L8;
        Slog.v("ActivityTaskManager", "Resume visible activity, " + this);
    L8:
        return getRootTask().resumeTopActivityUncheckedLocked(activeActivity, null, false);
    L10:
        if (shouldPauseActivity(activeActivity) == false) goto L21;
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L14;
        Slog.v("ActivityTaskManager", "Pause visible activity, " + this);
    L14:
        callServiceTrackeronActivityStatechange(State.PAUSING, true);
        setState(State.PAUSING, "makeActiveIfNeeded");
        EventLogTags.writeWmPauseActivity(this.mUserId, System.identityHashCode(this), this.shortComponentName, "userLeaving=false", "make-active");
        this.mAtmService.getLifecycleManager().scheduleTransactionItem(this.app.getThread(), new PauseActivityItem(this.token, this.finishing, false, false, this.mAutoEnteringPip));     // Catch: RemoteException -> L17
    L31:
        return false;
    L17:
        e = move-exception;
        Slog.w("ActivityTaskManager", "Exception thrown sending pause: " + this.intent.getComponent(), e);
        goto L31
    L21:
        if (shouldStartActivity() == false) goto L31;
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L25;
        Slog.v("ActivityTaskManager", "Start visible activity, " + this);
    L25:
        callServiceTrackeronActivityStatechange(State.STARTED, true);
        setState(State.STARTED, "makeActiveIfNeeded");
        acquireActivityBoost();
        this.mAtmService.getLifecycleManager().scheduleTransactionItem(this.app.getThread(), new StartActivityItem(this.token, takeSceneTransitionInfo()));     // Catch: RemoteException -> L28
    L30:
        this.mTaskSupervisor.mStoppingActivities.remove(this);
    L28:
        e = move-exception;
        Slog.w("ActivityTaskManager", "Exception thrown sending start: " + this.intent.getComponent(), e);
        releaseActivityBoost();
        goto L30
    }

    boolean shouldPauseActivity(ActivityRecord activeActivity) {
        if (shouldMakeActive(activeActivity) == true) goto L5;
    L11:
        return false;
    L5:
        if (isFocusable() == true) goto L11;
        if (isState(State.PAUSING, State.PAUSED) == true) goto L11;
        if (this.results != null) goto L11;
        return true;
    }

    boolean shouldResumeActivity(ActivityRecord activeActivity) {
        if (shouldBeResumed(activeActivity) == true) goto L5;
    L7:
        return false;
    L5:
        if (isState(State.RESUMED) == true) goto L7;
        return true;
    }

    private boolean shouldBeResumed(ActivityRecord activeActivity) {
        if (shouldMakeActive(activeActivity) == true) goto L5;
    L11:
        return false;
    L5:
        if (isFocusable() == false) goto L11;
        if (getTaskFragment().getVisibility(activeActivity) != 0) goto L11;
        if (canResumeByCompat() == false) goto L11;
        return true;
    }

    private boolean shouldStartActivity() {
        if (this.mVisibleRequested == true) goto L5;
    L9:
        return false;
    L5:
        if (isState(State.STOPPED) == false) goto L7;
    L8:
        return true;
    L7:
        if (isState(State.STOPPING) == false) goto L9;
        goto L8
    }

    boolean shouldMakeActive(ActivityRecord activeActivity) {
        if (isState(State.STARTED, State.RESUMED, State.PAUSED, State.STOPPED, State.STOPPING) == true) goto L5;
    L23:
        return false;
    L5:
        if (getRootTask().mTranslucentActivityWaiting != null) goto L23;
        if (this != activeActivity) goto L10;
        return false;
    L10:
        if (this.mTaskSupervisor.readyToResume() == true) goto L13;
        return false;
    L13:
        if (this.mLaunchTaskBehind == false) goto L16;
        return false;
    L16:
        if (this.task.hasChild(this) == false) goto L22;
        if (getTaskFragment().topRunningActivity() != this) goto L24;
        return true;
    L24:
        return false;
    L22:
        throw new IllegalStateException("Activity not found in its task");
    }

    void handleAlreadyVisible() {
        if (this.returningOptions != null) goto L5;
        return;
    L5:
        if (this.returningOptions.getAnimationType() == 5) goto L7;
        return;
    L7:
        if (this.returningOptions.getSceneTransitionInfo() == null) goto L18;
        this.app.getThread().scheduleOnNewSceneTransitionInfo(this.token, this.returningOptions.getSceneTransitionInfo());     // Catch: RemoteException -> L10
        return;
    L18:
        return;
    }

    static void activityResumedLocked(IBinder token, boolean handleSplashScreenExit) {
        ActivityRecord r = forTokenLocked(token);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[2] == false) goto L5;
        String protoLogParam0 = String.valueOf(r);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_STATES, 1734586111478674085L, 0, new Object[]{protoLogParam0});
    L5:
        if (r != null) goto L7;
        return;
    L7:
        r.setCustomizeSplashScreenExitAnimation(handleSplashScreenExit);
        r.setSavedState(null);
        r.mDisplayContent.handleActivitySizeCompatModeIfNeeded(r);
        r.mDisplayContent.mUnknownAppVisibilityController.notifyAppResumedFinished(r);
    }

    static void activityRefreshedLocked(IBinder token) {
        ActivityRecord r = forTokenLocked(token);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[2] == false) goto L5;
        String protoLogParam0 = String.valueOf(r);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_STATES, -69666241054231397L, 0, new Object[]{protoLogParam0});
    L5:
        if (r != null) goto L7;
        return;
    L7:
        AppCompatCameraPolicy.onActivityRefreshed(r);
    }

    static void splashScreenAttachedLocked(IBinder token) {
        ActivityRecord r = forTokenLocked(token);
        if (r != null) goto L6;
        Slog.w("ActivityTaskManager", "splashScreenTransferredLocked cannot find activity");
        return;
    L6:
        r.onSplashScreenAttachComplete();
    }

    void completeResumeLocked() {
        ZTEActivityEventsInternal zteActivityEventsInternal = (ZTEActivityEventsInternal) LocalServices.getService(ZTEActivityEventsInternal.class);
        if (zteActivityEventsInternal == null) goto L5;
        ActivityRecord r5 = this;
        zteActivityEventsInternal.notifyActivityEvent(128, getDisplayId(), this.mUserId, r5, getRootTaskId());
    L6:
        r5.idle = false;
        r5.results = null;
        if (r5.newIntents != null) goto L9;
    L11:
        r5.newIntents = null;
        r5.mTaskSupervisor.updateHomeProcessIfNeeded(this);
    L16:
        e = move-exception;
        Slog.v("ActivityTaskManager", "Exception: " + e);
    L21:
        if (r5.nowVisible == false) goto L23;
        r5.mTaskSupervisor.stopWaitingForActivityVisible(this);
    L23:
        r5.mTaskSupervisor.scheduleIdleTimeout(this);
        r5.mTaskSupervisor.mStoppingActivities.remove(this);
        if (getDisplayArea().allResumedActivitiesComplete() == false) goto L26;
        r5.mAppCompatController.getSizeCompatModePolicy().updateAppCompatDisplayInsets();
        r5.mRootWindowContainer.executeAppTransitionForAllDisplay();
    L26:
        resumeKeyDispatchingLocked();
        Task rootTask = getRootTask();
        r5.mTaskSupervisor.mNoAnimActivities.clear();
        r5.returningOptions = null;
        if (canTurnScreenOn() == false) goto L29;
        r5.mTaskSupervisor.wakeUp(getDisplayId(), "turnScreenOnFlag");
        return;
    L29:
        rootTask.checkReadyForSleep();
        return;
    L13:
        if (isActivityTypeHome() == false) goto L21;
        ActivityTaskSupervisor r3 = r5.mTaskSupervisor;     // Catch: Exception -> L16
        r3.getClass();     // Catch: Exception -> L16
        new ActivityTaskSupervisor.PreferredAppsTask(r3).execute(new Void[0]);     // Catch: Exception -> L16
        goto L21
    L9:
        if (r5.newIntents.size() <= 0) goto L11;
        r5.mLastNewIntent = r5.newIntents.get(r5.newIntents.size() - 1);
        goto L11
    L5:
        r5 = this;
        goto L6
    }

    void activityPaused(boolean timeout) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L5;
        String protoLogParam0 = String.valueOf(this.token);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 1256300416726217367L, 12, new Object[]{protoLogParam0, Boolean.valueOf(timeout)});
    L5:
        TaskFragment taskFragment = getTaskFragment();
        if (taskFragment == null) goto L35;
        removePauseTimeout();
        ActivityRecord pausingActivity = taskFragment.getPausingActivity();
        if (pausingActivity == this) goto L10;
        int r4 = this.mUserId;
        int r5 = System.identityHashCode(this);
        String r6 = this.shortComponentName;
        if (pausingActivity == null) goto L26;
        String r7 = pausingActivity.shortComponentName;
    L27:
        EventLogTags.writeWmFailedToPause(r4, r5, r6, r7);
        if (isState(State.PAUSING) == false) goto L35;
        callServiceTrackeronActivityStatechange(State.PAUSED, true);
        setState(State.PAUSED, "activityPausedLocked");
        if (this.finishing == false) goto L35;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L34;
        String protoLogParam1 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 2737811012914917932L, 0, new Object[]{protoLogParam1});
    L34:
        completeFinishing("activityPausedLocked");
        goto L35
    L26:
        r7 = "(none)";
        goto L27
    L10:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L16;
        String protoLogParam2 = String.valueOf(this);
        if (timeout == false) goto L14;
        String r8 = "(due to timeout)";
    L15:
        String protoLogParam3 = String.valueOf(r8);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 6879640870754727133L, 0, new Object[]{protoLogParam2, protoLogParam3});
        goto L16
    L14:
        r8 = " (pause complete)";
    L16:
        this.mAtmService.deferWindowLayout();
        taskFragment.completePause(true, null);     // Catch: Throwable -> L20
        this.mAtmService.continueWindowLayout();
        return;
    L20:
        th = move-exception;
        this.mAtmService.continueWindowLayout();
        throw th;
    L35:
        this.mDisplayContent.handleActivitySizeCompatModeIfNeeded(this);
        this.mRootWindowContainer.ensureActivitiesVisible();
    }

    void schedulePauseTimeout() {
        this.pauseTime = SystemClock.uptimeMillis();
        this.mAtmService.mH.postDelayed(this.mPauseTimeoutRunnable, 500);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L6;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, -2566496855129705006L, 0, null);
        return;
    }

    private void removePauseTimeout() {
        this.mAtmService.mH.removeCallbacks(this.mPauseTimeoutRunnable);
    }

    private void removeDestroyTimeout() {
        this.mAtmService.mH.removeCallbacks(this.mDestroyTimeoutRunnable);
    }

    private void removeStopTimeout() {
        this.mAtmService.mH.removeCallbacks(this.mStopTimeoutRunnable);
    }

    void removeTimeouts() {
        this.mTaskSupervisor.removeIdleTimeoutForActivity(this);
        removePauseTimeout();
        removeStopTimeout();
        removeDestroyTimeout();
    }

    void stopIfPossible() {
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L6;
        Slog.d("ActivityTaskManager", "Stopping: " + this);
    L6:
        if (this.finishing == true) goto L54;
        if (isNoHistory() == false) goto L22;
        if (this.task.shouldSleepActivities() == true) goto L19;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[0] == false) goto L15;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_STATES, 7498807658620137882L, 0, new Object[]{protoLogParam0});
    L15:
        if (finishIfPossible("stop-no-history", false) == 0) goto L22;
        resumeKeyDispatchingLocked();
        return;
    L19:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[0] == false) goto L22;
        String protoLogParam1 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_STATES, 3207149655622038378L, 0, new Object[]{protoLogParam1});
    L22:
        if (attachedToProcess() == true) goto L24;
        return;
    L24:
        resumeKeyDispatchingLocked();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L27;
        String protoLogParam2 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, -2530718588485487045L, 0, new Object[]{protoLogParam2});
    L27:
        setState(State.STOPPING, "stopIfPossible");
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L30;
        Slog.v("ActivityTaskManager", "Stopping:" + this);
    L30:
        EventLogTags.writeWmStopActivity(this.mUserId, System.identityHashCode(this), this.shortComponentName);
        ZTEActivityEventsInternal zteActivityEventsInternal = (ZTEActivityEventsInternal) LocalServices.getService(ZTEActivityEventsInternal.class);
        if (zteActivityEventsInternal == null) goto L33;
        ActivityRecord r9 = this;
        zteActivityEventsInternal.notifyActivityEvent(16, getDisplayId(), this.mUserId, r9, getRootTaskId());
    L34:
        ClientTransactionItem r0 = new StopActivityItem(r9.token);
        callServiceTrackeronActivityStatechange(State.STOPPING, true);     // Catch: RemoteException -> L37
        boolean isSuccessful = r9.mAtmService.getLifecycleManager().scheduleTransactionItem(r9.app.getThread(), r0);     // Catch: RemoteException -> L37
    L39:
        if (isSuccessful == false) goto L48;
        int lastReportedWinMode = r9.mLastReportedConfiguration.getMergedConfiguration().windowConfiguration.getWindowingMode();
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == true) goto L43;
    L47:
        r9.mAtmService.mH.postDelayed(r9.mStopTimeoutRunnable, 11000);
        return;
    L43:
        if (lastReportedWinMode != 2) goto L47;
        if (inPinnedWindowingMode() == true) goto L47;
        updatePictureInPictureMode(null, true);
        goto L47
    L48:
        r9.mAppStopped = true;
        r9.mStoppedTime = SystemClock.uptimeMillis();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L51;
        String protoLogParam3 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, -8424334454318351870L, 0, new Object[]{protoLogParam3});
    L51:
        callServiceTrackeronActivityStatechange(State.STOPPED, true);
        setState(State.STOPPED, "stopIfPossible");
        return;
    L37:
        e = move-exception;
        Slog.w("ActivityTaskManager", "Exception thrown during pause", e);
        isSuccessful = false;
        goto L39
    L33:
        r9 = this;
        goto L34
    L54:
        throw new IllegalStateException("Request to stop a finishing activity: " + this);
    }

    void activityStopped(Bundle newIcicle, PersistableBundle newPersistentState, CharSequence description) {
        removeStopTimeout();
        if (this.mState != State.STOPPING) goto L5;
        boolean isStopping = true;
    L7:
        if (isStopping == false) goto L9;
    L12:
        if (newPersistentState == null) goto L14;
        this.mPersistentState = newPersistentState;
        this.mAtmService.notifyTaskPersisterLocked(this.task, false);
    L14:
        if (newIcicle == null) goto L17;
        setSavedState(newIcicle);
        this.launchCount = 0;
        updateTaskDescription(description);
    L17:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[2] == false) goto L19;
        String protoLogParam0 = String.valueOf(this);
        String protoLogParam1 = String.valueOf(this.mIcicle);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_STATES, -4913512058893421188L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L19:
        if (isStopping == true) goto L21;
    L24:
        this.mAppStopped = true;
        this.firstWindowDrawn = false;
        if (this.task.mLastRecentsAnimationTransaction == null) goto L28;
        this.task.clearLastRecentsAnimationTransaction(true);
    L28:
        if (isClientVisible() == false) goto L30;
        setClientVisible(false);
    L30:
        destroySurfaces();
        removeStartingWindow();
        if (this.mPendingRelaunchCount <= 0) goto L34;
        Slog.i("ActivityTaskManager", "Clear pending relaunch count on stopped " + this);
        clearRelaunching();
    L34:
        if (this.finishing == false) goto L36;
        abortAndClearOptionsAnimation();
    L37:
        this.mAtmService.getObricExt().activityPaused(this);
        this.mTaskSupervisor.checkReadyForSleepLocked(true);
        return;
    L36:
        this.mAtmService.updatePreviousProcess(this);
        goto L37
    L21:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L23;
        String protoLogParam2 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 7613353074402340933L, 0, new Object[]{protoLogParam2});
    L23:
        this.mStoppedTime = SystemClock.uptimeMillis();
        callServiceTrackeronActivityStatechange(State.STOPPED, true);
        setState(State.STOPPED, "activityStopped");
        goto L24
    L9:
        if (this.mState == State.RESTARTING_PROCESS) goto L12;
        Slog.i("ActivityTaskManager", "Activity reported stop, but no longer stopping: " + this + " " + this.mState);
        return;
    L5:
        isStopping = false;
        goto L7
    }

    void addToStopping(boolean scheduleIdle, boolean idleDelayed, String reason) {
        if (this.mTaskSupervisor.mStoppingActivities.contains(this) == true) goto L5;
        EventLogTags.writeWmAddToStopping(this.mUserId, System.identityHashCode(this), this.shortComponentName, reason);
        this.mTaskSupervisor.mStoppingActivities.add(this);
    L5:
        Task rootTask = getRootTask();
        if (this.mTaskSupervisor.mStoppingActivities.size() <= 3) goto L8;
    L13:
        boolean forceIdle = true;
    L15:
        if (scheduleIdle == true) goto L20;
        if (forceIdle == true) goto L20;
        rootTask.checkReadyForSleep();
        return;
    L20:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L22;
        boolean protoLogParam0 = forceIdle;
        boolean protoLogParam1 = !idleDelayed;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 3981777934616509782L, 15, new Object[]{Boolean.valueOf(protoLogParam0), Boolean.valueOf(protoLogParam1)});
    L22:
        if (idleDelayed == true) goto L24;
        this.mTaskSupervisor.scheduleIdle();
        return;
    L24:
        this.mTaskSupervisor.scheduleIdleTimeout(this);
        return;
    L8:
        if (isRootOfTask() == true) goto L10;
    L12:
        forceIdle = false;
        goto L15
    L10:
        if (rootTask.getChildCount() > 1) goto L12;
        goto L12
    }

    void onFirstWindowDrawn(WindowState win) {
        this.firstWindowDrawn = true;
        this.mSplashScreenStyleSolidColor = true;
        this.mAtmService.mBackNavigationController.removePredictiveSurfaceIfNeeded(this);
        if (this.mStartingWindow == null) goto L9;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L7;
        String protoLogParam0 = String.valueOf(win.mToken);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, -6965298896142649709L, 0, new Object[]{protoLogParam0});
    L7:
        win.cancelAnimation();
    L9:
        if (this.mExt.shouldRemoveStartingIfNeeded(this) == true) goto L11;
        Slog.d("ActivityTaskManager", "defer remove start window because [%s] is not main window" + win);
    L21:
        getExt().onActivityFirstWindowDrawn("onFirstWindowDrawn");
        updateReportedVisibilityLocked();
        return;
    L11:
        if (this.task.mSharedStartingData == null) goto L13;
        Task associatedTask = this.task;
    L14:
        if (associatedTask != null) goto L16;
        removeStartingWindow();
        goto L21
    L16:
        ActivityRecord r = getSharedStartingWindowOwnerIfTaskDrawn();
        if (r == null) goto L21;
        r.removeStartingWindow();
        goto L21
    L13:
        associatedTask = null;
        goto L14
    }

    private void setTaskHasBeenVisible() {
        boolean wasTaskVisible = this.task.getHasBeenVisible();
        if (wasTaskVisible == false) goto L6;
        return;
    L6:
        if (inTransition() == false) goto L8;
        this.task.setDeferTaskAppear(true);
    L8:
        this.task.setHasBeenVisible(true);
    }

    void onStartingWindowDrawn() {
        if (this.task == null) goto L6;
        this.mSplashScreenStyleSolidColor = true;
        setTaskHasBeenVisible();
    L6:
        if (this.mStartingData != null) goto L8;
        return;
    L8:
        if (this.mStartingData.mIsDisplayed == true) goto L31;
        this.mStartingData.mIsDisplayed = true;
        if (this.app == null) goto L13;
        return;
    L13:
        if (this.finishing == false) goto L15;
        return;
    L15:
        if (this.mLaunchedFromBubble == false) goto L17;
        return;
    L17:
        if (this.mVisibleRequested == true) goto L19;
        return;
    L19:
        if (this.mDisplayContent.isNextTransitionForward() == false) goto L30;
        this.mStartingData.mIsTransitionForward = true;
        if (this == this.mDisplayContent.getLastOrientationSource()) goto L23;
        this.mDisplayContent.updateOrientation();
    L23:
        this.mDisplayContent.executeAppTransition();
        return;
    L30:
        return;
    }

    protected void releaseActivityBoost() {
        if (this.mPerf == null) goto L23;
        if (this.perfActivityBoostHandler <= 0) goto L23;
        WindowProcessController homeProcess = this.mAtmService.mHomeProcess;
        if (homeProcess != null) goto L9;
    L11:
        boolean isHomeLaunched = false;
    L13:
        if (SysOptBridge.getFactory().getPerformanceSchedUtils().isBoostEnabled() == false) goto L19;
        if (isHomeLaunched == false) goto L19;
        if (this.launchedFromUid == this.info.applicationInfo.uid) goto L19;
        if (getActivityRecordSmtEx().perfActivityBoostCanRelease != 0) goto L19;
    L20:
        this.perfActivityBoostHandler = -1;
        return;
    L19:
        Trace.traceBegin(64, "rel cold_lunch_boost");
        this.mPerf.perfLockReleaseHandler(this.perfActivityBoostHandler);
        Trace.traceEnd(64);
        goto L20
    L9:
        if (this.launchedFromUid != homeProcess.mUid) goto L11;
        isHomeLaunched = true;
    L23:
        if (this.perfActivityBoostHandler <= 0) goto L27;
        Slog.w("ActivityTaskManager", "activity boost didn't release as expected");
        return;
    }

    protected void acquireActivityBoost() {
        if (this.mPerf != null) goto L5;
        return;
    L5:
        if (this.mPerf.shouldUseUiPerf(this.mWmService.mContext, this.packageName) == false) goto L8;
        return;
    L8:
        if (this.mPerf.getPerfHalVersion() < 2.299999952316284d) goto L34;
        this.mPerf.perfGetFeedback(5633, this.packageName);
        int pid = -1;
        WindowProcessController wpc = null;
        if (this.app == null) goto L12;
        wpc = this.app;
    L19:
        if (wpc != null) goto L21;
    L23:
        int hintType = 10;
        if (SysOptBridge.getFactory().getPerformanceSchedUtils().isBoostEnabled() == true) goto L26;
    L32:
        Trace.traceBegin(64, "start cold_lunch_boost");
        this.perfActivityBoostHandler = SysOptBridge.getFactory().getBoostFrameworkService().perfLockAcquireType(4225, hintType, 0, pid);
        Trace.traceEnd(64);
        getActivityRecordSmtEx().perfActivityBoostCanRelease = 0;
        return;
    L26:
        if (this.info.applicationInfo.isSystemApp() == false) goto L28;
        SysOptBridge.getFactory().getPerformanceSchedUtils().getBoostSystemAppDuration();
    L30:
        if (this.info.applicationInfo.getSysEx().bytedanceLaunchBoostValue <= 0) goto L32;
        int druation = this.info.applicationInfo.getSysEx().bytedanceLaunchBoostValue;
        hintType = this.info.applicationInfo.getSysEx().bytedanceLaunchHintTypeValue;
        goto L32
    L28:
        SysOptBridge.getFactory().getPerformanceSchedUtils().getBoostNormalDuration();
        goto L30
    L21:
        if (wpc.hasThread() == false) goto L23;
        pid = wpc.getPid();
        goto L23
    L12:
        if (this.info == null) goto L19;
        if (this.info.applicationInfo == null) goto L19;
        if (this.mAtmService == null) goto L19;
        wpc = this.mAtmService.getProcessController(this.processName, this.info.applicationInfo.uid);
        goto L19
    L34:
        if (this.perfActivityBoostHandler <= 0) goto L36;
        Slog.i("ActivityTaskManager", "Activity boosted, release it firstly");
        this.mPerf.perfLockReleaseHandler(this.perfActivityBoostHandler);
    L36:
        this.perfActivityBoostHandler = this.mPerf.perfHint(4225, this.packageName, -1, 1);
    }

    private void onWindowsDrawn() {
        releaseActivityBoost();
        ActivityMetricsLogger.TransitionInfoSnapshot info = this.mTaskSupervisor.getActivityMetricsLogger().notifyWindowsDrawn(this);
        int r1 = 0;
        if (info == null) goto L5;
        boolean validInfo = true;
    L6:
        if (validInfo == false) goto L8;
        int windowsDrawnDelayMs = info.windowsDrawnDelayMs;
    L9:
        if (validInfo == false) goto L11;
        r1 = info.getLaunchState();
    L11:
        int launchState = r1;
        if (validInfo == false) goto L14;
    L17:
        ActivityRecord r6 = this;
        this.mTaskSupervisor.reportActivityLaunched(false, r6, windowsDrawnDelayMs, launchState);
    L19:
        if (r6.task == null) goto L21;
        setTaskHasBeenVisible();
    L21:
        r6.mLaunchRootTask = null;
        return;
    L14:
        if (this == getDisplayArea().topRunningActivity()) goto L17;
        r6 = this;
        goto L19
    L8:
        windowsDrawnDelayMs = -1;
        goto L9
    L5:
        validInfo = false;
        goto L6
    }

    void onWindowsVisible() {
        if (this.mPerf == null) goto L10;
        if (this.mPerf.shouldUseUiPerf(this.mWmService.mContext, this.packageName) == false) goto L10;
        int hint = this.mPerf.getUiPerfHint(this.mWmService.mContext, this.info.name);
        if (hint == (-1)) goto L10;
        this.mPerfScenarioBoostHandler = this.mPerf.perfHintAcqRel(this.mPerfScenarioBoostHandler, hint, PackageManagerService.PLATFORM_PACKAGE_NAME, 300000);
    L10:
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L12;
        Slog.v("WindowManager", "Reporting visible in " + this.token);
    L12:
        this.mTaskSupervisor.stopWaitingForActivityVisible(this);
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L16;
        Log.v("ActivityTaskManager", "windowsVisibleLocked(): " + this);
    L16:
        if (this.nowVisible == true) goto L19;
        this.nowVisible = true;
        this.launching = false;
        this.lastVisibleTime = SystemClock.uptimeMillis();
        this.mAtmService.scheduleAppGcsLocked();
        this.mTaskSupervisor.scheduleProcessStoppingAndFinishingActivitiesIfNeeded();
        return;
    }

    void onWindowsGone() {
        if (this.mPerfScenarioBoostHandler == (-1)) goto L8;
        if (this.mPerf == null) goto L8;
        this.mPerf.perfLockReleaseHandler(this.mPerfScenarioBoostHandler);
        this.mPerfScenarioBoostHandler = -1;
    L8:
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L11;
        Slog.v("WindowManager", "Reporting gone in " + this.token);
    L11:
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L13;
        Log.v("ActivityTaskManager", "windowsGone(): " + this);
    L13:
        this.nowVisible = false;
        this.launching = false;
    }

    void updateReportedVisibilityLocked() {
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L5;
        Slog.v("ActivityTaskManager", "Update reported visibility: " + this);
    L5:
        int count = this.mChildren.size();
        this.mReportedVisibilityResults.reset();
        int i = 0;
    L6:
        if (i >= count) goto L8;
        WindowState win = (WindowState) this.mChildren.get(i);
        win.updateReportedVisibility(this.mReportedVisibilityResults);
        i = i + 1;
        goto L6
    L8:
        int numInteresting = this.mReportedVisibilityResults.numInteresting;
        int numVisible = this.mReportedVisibilityResults.numVisible;
        int numDrawn = this.mReportedVisibilityResults.numDrawn;
        boolean nowGone = this.mReportedVisibilityResults.nowGone;
        boolean nowVisible = false;
        if (numInteresting <= 0) goto L12;
        if (numDrawn < numInteresting) goto L12;
        boolean nowDrawn = true;
    L13:
        if (numInteresting <= 0) goto L18;
        if (numVisible < numInteresting) goto L18;
        if (isVisible() == false) goto L18;
        nowVisible = true;
    L18:
        if (nowGone == true) goto L24;
        if (nowDrawn == true) goto L21;
        nowDrawn = this.mReportedDrawn;
    L21:
        if (nowVisible == true) goto L24;
        nowVisible = this.reportedVisible;
    L24:
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L27;
        Slog.v("ActivityTaskManager", "VIS " + this + ": interesting=" + numInteresting + " visible=" + numVisible);
    L27:
        if (nowDrawn == this.mReportedDrawn) goto L32;
        if (nowDrawn == false) goto L30;
        onWindowsDrawn();
    L30:
        this.mReportedDrawn = nowDrawn;
    L32:
        if (nowVisible != this.reportedVisible) goto L34;
        return;
    L34:
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L36;
        Slog.v("ActivityTaskManager", "Visibility changed in " + this + ": vis=" + nowVisible);
    L36:
        this.reportedVisible = nowVisible;
        if (nowVisible == false) goto L39;
        onWindowsVisible();
        return;
    L39:
        onWindowsGone();
        return;
    L12:
        nowDrawn = false;
        goto L13
    }

    boolean isReportedDrawn() {
        return this.mReportedDrawn;
    }

    @Override // com.android.server.wm.WindowToken
    void setClientVisible(boolean clientVisible) {
        super.setClientVisible(clientVisible);
    }

    boolean updateDrawnWindowStates(WindowState w) {
        w.setDrawnStateEvaluated(true);
        if (WindowManagerDebugConfig.DEBUG_STARTING_WINDOW_VERBOSE == false) goto L8;
        if (w != this.mStartingWindow) goto L8;
        Slog.d("ActivityTaskManager", "updateWindows: starting " + w + " isOnScreen=" + w.isOnScreen() + " allDrawn=" + this.allDrawn);
    L8:
        if (this.allDrawn == false) goto L11;
        return false;
    L11:
        if (this.mLastTransactionSequence == this.mWmService.mTransactionSequence) goto L17;
        this.mLastTransactionSequence = this.mWmService.mTransactionSequence;
        this.mNumDrawnWindows = 0;
        if (findMainWindow(false) == null) goto L15;
        int r1 = 1;
    L16:
        this.mNumInterestingWindows = r1;
        goto L17
    L15:
        r1 = 0;
    L17:
        WindowStateAnimator winAnimator = w.mWinAnimator;
        if (this.allDrawn == false) goto L20;
        return false;
    L20:
        if (w.mightAffectAllDrawn() == true) goto L22;
        return false;
    L22:
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L24;
    L25:
        boolean isAnimationSet = isAnimating(3, 1);
        Slog.v("ActivityTaskManager", "Eval win " + w + ": isDrawn=" + w.isDrawn() + ", isAnimationSet=" + isAnimationSet);
        if (w.isDrawn() == true) goto L29;
        Slog.v("ActivityTaskManager", "Not displayed: s=" + winAnimator.mSurfaceControl + " pv=" + w.isVisibleByPolicy() + " mDrawState=" + winAnimator.drawStateToString() + " ph=" + w.isParentWindowHidden() + " th=" + this.mVisibleRequested + " a=" + isAnimationSet);
    L29:
        if (w != this.mStartingWindow) goto L31;
        return false;
    L31:
        if (w.isInteresting() == true) goto L33;
        return false;
    L33:
        if (findMainWindow(false) == w) goto L36;
        this.mNumInterestingWindows++;
    L36:
        if (w.isDrawn() == false) goto L48;
        this.mNumDrawnWindows++;
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L40;
    L41:
        Slog.v("ActivityTaskManager", "tokenMayBeDrawn: " + this + " w=" + w + " numInteresting=" + this.mNumInterestingWindows);
    L42:
        return true;
    L40:
        if (WmProtoLogGroups.WM_DEBUG_ORIENTATION.isLogToLogcat() == false) goto L42;
    L48:
        return false;
    L24:
        if (WmProtoLogGroups.WM_DEBUG_ORIENTATION.isLogToLogcat() == false) goto L29;
        goto L25
    }

    public boolean inputDispatchingTimedOut(TimeoutRecord timeoutRecord, int windowPid) {
        Trace.traceBegin(64, "ActivityRecord#inputDispatchingTimedOut()");     // Catch: Throwable -> L22
        timeoutRecord.mLatencyTracker.waitingOnGlobalLockStarted();     // Catch: Throwable -> L22
        WindowManagerGlobalLock r1 = this.mAtmService.mGlobalLock;     // Catch: Throwable -> L22
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L22
        monitor-enter(r1);     // Catch: Throwable -> L22
        timeoutRecord.mLatencyTracker.waitingOnGlobalLockEnded();     // Catch: Throwable -> L12
        ActivityRecord anrActivity = getWaitingHistoryRecordLocked();     // Catch: Throwable -> L12
        WindowProcessController anrApp = this.app;     // Catch: Throwable -> L12
        boolean r3 = true;
        if (hasProcess() == true) goto L8;
    L14:
        boolean r2 = false;
    L15:
        boolean blameActivityProcess = r2;
        monitor-exit(r1);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L22
        if (blameActivityProcess == false) goto L24;
        boolean r4 = this.mAtmService.mAmInternal.inputDispatchingTimedOut(anrApp.mOwner, anrActivity.shortComponentName, anrActivity.info.applicationInfo, this.shortComponentName, this.app, false, timeoutRecord);     // Catch: Throwable -> L22
        Trace.traceEnd(64);
        return r4;
    L24:
        long timeoutMillis = this.mAtmService.mAmInternal.inputDispatchingTimedOut(windowPid, false, timeoutRecord);     // Catch: Throwable -> L22
        if (timeoutMillis <= 0) goto L29;
        r3 = false;
    L29:
        Trace.traceEnd(64);
        return r3;
    L8:
        if (this.app.getPid() != windowPid) goto L10;
    L11:
        r2 = true;
        goto L15
    L10:
        if (windowPid != (-1)) goto L14;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    private ActivityRecord getWaitingHistoryRecordLocked() {
        if (this.mAppStopped == false) goto L12;
        Task rootTask = this.mRootWindowContainer.getTopDisplayFocusedRootTask();
        if (rootTask != null) goto L7;
        return this;
    L7:
        ActivityRecord r = rootTask.getTopResumedActivity();
        if (r != null) goto L10;
        r = rootTask.getTopPausingActivity();
    L10:
        if (r == null) goto L12;
        return r;
    L12:
        return this;
    }

    boolean canBeTopRunning() {
        if (this.finishing == false) goto L5;
    L7:
        return false;
    L5:
        if (showToCurrentUser() == false) goto L7;
        return true;
    }

    public boolean isInterestingToUserLocked() {
        if (this.mVisibleRequested == false) goto L5;
    L12:
        return true;
    L5:
        if (this.nowVisible == true) goto L12;
        if (this.mState == State.PAUSING) goto L12;
        if (this.mState == State.RESUMED) goto L12;
        return false;
    }

    static int getTaskForActivityLocked(IBinder token, boolean onlyRoot) {
        ActivityRecord r = forTokenLocked(token);
        if (r != null) goto L5;
    L14:
        return -1;
    L5:
        if (r.getParent() == null) goto L14;
        Task task = r.task;
        if (onlyRoot == false) goto L13;
        if (r.compareTo(task.getRootActivity(false, true)) <= 0) goto L13;
        return -1;
    L13:
        return task.mTaskId;
    }

    static ActivityRecord isInRootTaskLocked(IBinder token) {
        ActivityRecord r = forTokenLocked(token);
        if (r != null) goto L7;
        return null;
    L7:
        return r.getRootTask().isInTask(r);
    }

    static Task getRootTask(IBinder token) {
        ActivityRecord r = isInRootTaskLocked(token);
        if (r != null) goto L5;
        return null;
    L5:
        return r.getRootTask();
    }

    static ActivityRecord isInAnyTask(IBinder token) {
        ActivityRecord r = forTokenLocked(token);
        if (r != null) goto L5;
    L7:
        return null;
    L5:
        if (r.isAttached() == false) goto L7;
        return r;
    }

    int getDisplayId() {
        if (this.task != null) goto L5;
    L7:
        return -1;
    L5:
        if (this.task.mDisplayContent == null) goto L7;
        return this.task.mDisplayContent.mDisplayId;
    }

    final boolean isDestroyable() {
        if (this.finishing == false) goto L5;
    L24:
        return false;
    L5:
        if (hasProcess() == false) goto L24;
        if (isState(State.RESUMED) == false) goto L10;
    L23:
        return false;
    L10:
        if (getRootTask() == null) goto L23;
        if (this == getTaskFragment().getPausingActivity()) goto L23;
        if (this.mHaveState == false) goto L23;
        if (this.mAppStopped == false) goto L23;
        if (this.mVisibleRequested == false) goto L21;
        return false;
    L21:
        return true;
    }

    private static String createImageFilename(long createTime, int taskId) {
        return String.valueOf(taskId) + ACTIVITY_ICON_SUFFIX + createTime + ".png";
    }

    void setTaskDescription(ActivityManager.TaskDescription _taskDescription) {
        if (_taskDescription.getIconFilename() != null) goto L7;
        Bitmap icon = _taskDescription.getIcon();
        if (icon == null) goto L7;
        String iconFilename = createImageFilename(this.createTime, this.task.mTaskId);
        File iconFile = new File(TaskPersister.getUserImagesDir(this.task.mUserId), iconFilename);
        String iconFilePath = iconFile.getAbsolutePath();
        this.mAtmService.getRecentTasks().saveImage(icon, iconFilePath);
        _taskDescription.setIconFilename(iconFilePath);
    L7:
        this.taskDescription = _taskDescription;
        getTask().updateTaskDescription();
        if (Constants.ENABLE_GAME_ASSIST == true) goto L10;
        return;
    L10:
        if (hasProcess() == true) goto L12;
        return;
    L12:
        if ("com.tencent.mm".equals(this.packageName) == true) goto L14;
        return;
    L14:
        if (this.mActivityComponent.getClassName().contains("AppBrand") == true) goto L16;
        return;
    L16:
        if (this.taskDescription == null) goto L23;
        Slog.d("ActivityTaskManager", "setTaskDescription " + this.taskDescription.getLabel());
        GameActivityStateEventDispatcher.getInstance().notifyGameActivityResumed(getDisplayId(), this.info, getRootTaskId(), this.app.getPid(), getWindowingMode(), getActivityType(), this, this.mActivityComponent, this.mUserId, getTask().getTaskLabelHashcode());
        return;
    }

    void setLocusId(LocusId locusId) {
        if (Objects.equals(locusId, this.mLocusId) == false) goto L5;
        return;
    L5:
        this.mLocusId = locusId;
        Task task = getTask();
        if (task == null) goto L9;
        getTask().dispatchTaskInfoChangedIfNeeded(false);
        return;
    }

    LocusId getLocusId() {
        return this.mLocusId;
    }

    void requestOpenInBrowserEducation() {
        this.mRequestOpenInBrowserEducationTimestamp = System.currentTimeMillis();
        Task task = getTask();
        if (task != null) goto L5;
        return;
    L5:
        if (isVisibleRequested() == true) goto L7;
    L9:
        boolean force = false;
    L10:
        getTask().dispatchTaskInfoChangedIfNeeded(force);
        return;
    L7:
        if (this != task.getTopNonFinishingActivity()) goto L9;
        force = true;
        goto L10
    }

    public void reportScreenCaptured() {
        if (this.mCaptureCallbacks == null) goto L18;
        int n = this.mCaptureCallbacks.beginBroadcast();
        int i = 0;
    L5:
        if (i >= n) goto L11;
        IScreenCaptureObserver obs = this.mCaptureCallbacks.getBroadcastItem(i);
        obs.onScreenCaptured();     // Catch: RemoteException -> L9
    L10:
        i = i + 1;
        goto L5
    L11:
        this.mCaptureCallbacks.finishBroadcast();
        return;
    }

    public void registerCaptureObserver(IScreenCaptureObserver observer) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mCaptureCallbacks != null) goto L9;
        this.mCaptureCallbacks = new RemoteCallbackList();     // Catch: Throwable -> L7
    L9:
        this.mCaptureCallbacks.register(observer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    public void unregisterCaptureObserver(IScreenCaptureObserver observer) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mCaptureCallbacks == null) goto L9;
        this.mCaptureCallbacks.unregister(observer);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    boolean isRegisteredForScreenCaptureCallback() {
        if (this.mCaptureCallbacks != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mCaptureCallbacks.getRegisteredCallbackCount() <= 0) goto L7;
        return true;
    }

    void setVoiceSessionLocked(IVoiceInteractionSession session) {
        this.voiceSession = session;
        this.pendingVoiceInteractionStart = false;
    }

    void clearVoiceSessionLocked() {
        this.voiceSession = null;
        this.pendingVoiceInteractionStart = false;
    }

    void showStartingWindow(boolean taskSwitch) {
        ActivityRecord prev = this.task.getActivity(new ActivityRecord$$ExternalSyntheticLambda5(this));
        showStartingWindow(prev, false, taskSwitch, false, null);
    }

    private /* synthetic */ boolean lambda$showStartingWindow$13(ActivityRecord a) {
        if (a != this) goto L4;
    L8:
        return false;
    L4:
        if (a.mStartingData == null) goto L8;
        if (a.showToCurrentUser() == false) goto L8;
        return true;
    }

    private ActivityRecord searchCandidateLaunchingActivity() {
        ActivityRecord below = this.task.getActivityBelow(this);
        if (below != null) goto L6;
        below = this.task.getParent().getActivityBelow(this);
    L6:
        if (below != null) goto L8;
    L25:
        return null;
    L8:
        if (below.isActivityTypeHome() == true) goto L25;
        if (this.app == null) goto L13;
        WindowProcessController myProcess = this.app;
    L15:
        if (below.app == null) goto L17;
        WindowProcessController candidateProcess = below.app;
    L19:
        if (candidateProcess != myProcess) goto L21;
    L24:
        return below;
    L21:
        if (this.mActivityComponent.getPackageName().equals(below.mActivityComponent.getPackageName()) == true) goto L24;
        return null;
    L17:
        candidateProcess = (WindowProcessController) this.mAtmService.mProcessNames.get(below.processName, below.info.applicationInfo.uid);
        goto L19
    L13:
        myProcess = (WindowProcessController) this.mAtmService.mProcessNames.get(this.processName, this.info.applicationInfo.uid);
        goto L15
    }

    private boolean isIconStylePreferred(int theme) {
        if (theme != 0) goto L6;
        return false;
    L6:
        if (theme != this.theme) goto L8;
        WindowStyle style = this.mWindowStyle;
    L9:
        if (style != null) goto L11;
        return false;
    L11:
        if (style.mSplashScreenBehavior == 1) goto L13;
        return false;
    L13:
        return true;
    L8:
        style = this.mAtmService.getWindowStyle(this.packageName, theme, this.mUserId);
        goto L9
    }

    private boolean shouldUseSolidColorSplashScreen(ActivityRecord sourceRecord, boolean startActivity, ActivityOptions options, int resolvedTheme, boolean newTask) {
        if (sourceRecord != null) goto L8;
        if (startActivity == true) goto L8;
        ActivityRecord above = this.task.getActivityAbove(this);
        if (above == null) goto L8;
        return true;
    L8:
        if (options == null) goto L10;
        int optionsStyle = options.getSplashScreenStyle();
    L12:
        if (optionsStyle != 0) goto L15;
        return true;
    L15:
        if (optionsStyle != 1) goto L17;
    L40:
        return false;
    L17:
        if (isIconStylePreferred(resolvedTheme) == true) goto L40;
        if (this.mLaunchSourceType != 3) goto L22;
        return true;
    L22:
        if (sourceRecord != null) goto L24;
        sourceRecord = searchCandidateLaunchingActivity();
    L24:
        if (sourceRecord == null) goto L28;
        return sourceRecord.mSplashScreenStyleSolidColor;
    L28:
        if (this.mLaunchSourceType == 2) goto L39;
        if (this.launchedFromUid == 2000) goto L39;
        if (this.mLaunchSourceType != 1) goto L41;
        if (startActivity == true) goto L37;
        return true;
    L37:
        return false;
    L41:
        return true;
    L39:
        return !newTask;
    L10:
        optionsStyle = -1;
        goto L12
    }

    private int getSplashscreenTheme(ActivityOptions options) {
        if (options == null) goto L5;
        String splashScreenThemeResName = options.getSplashScreenThemeResName();
    L6:
        if (splashScreenThemeResName != null) goto L8;
    L20:
        splashScreenThemeResName = this.mAtmService.getPackageManager().getSplashScreenTheme(this.packageName, this.mUserId);     // Catch: RemoteException -> L11
    L13:
        if (splashScreenThemeResName != null) goto L15;
        return 0;
    L15:
        if (splashScreenThemeResName.isEmpty() == true) goto L25;
        Context packageContext = this.mAtmService.mContext.createPackageContext(this.packageName, 0);     // Catch: Throwable -> L18
        int splashScreenThemeResId = packageContext.getResources().getIdentifier(splashScreenThemeResName, null, null);     // Catch: Throwable -> L18
        return splashScreenThemeResId;
    L19:
        return 0;
    L25:
        return 0;
    L8:
        if (splashScreenThemeResName.isEmpty() == false) goto L13;
    L5:
        splashScreenThemeResName = null;
        goto L6
    }

    void showStartingWindow(ActivityRecord prev, boolean newTask, boolean taskSwitch, boolean startActivity, ActivityRecord sourceRecord) {
        if (isProcessRunning() == false) goto L5;
    L11:
        boolean r0 = true;
    L12:
        showStartingWindow(prev, newTask, taskSwitch, r0, startActivity, sourceRecord, null);
        return;
    L5:
        if (this.app != null) goto L7;
    L9:
        r0 = false;
        goto L12
    L7:
        if (this.app.getWPCSmtEx().isFreezing() == false) goto L9;
        goto L9
    }

    void showStartingWindow(ActivityRecord prev, boolean newTask, boolean taskSwitch, boolean processRunning, boolean startActivity, ActivityRecord sourceRecord, ActivityOptions candidateOptions) {
        if (this.mTaskOverlay == false) goto L6;
        return;
    L6:
        if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(getActivityInfo().applicationInfo.getSysEx().prefetchState) == false) goto L8;
        return;
    L8:
        if (candidateOptions == null) goto L10;
        ActivityOptions startOptions = candidateOptions;
    L11:
        if (startOptions == null) goto L16;
        if (startOptions.getAnimationType() != 5) goto L16;
        return;
    L16:
        if (startActivity == false) goto L18;
        int r1 = getSplashscreenTheme(startOptions);
    L19:
        int splashScreenTheme = r1;
        int resolvedTheme = evaluateStartingWindowTheme(prev, this.packageName, this.theme, splashScreenTheme);
        this.mSplashScreenStyleSolidColor = shouldUseSolidColorSplashScreen(sourceRecord, startActivity, startOptions, resolvedTheme, newTask);
        boolean r4 = true;
        if (this.mState.ordinal() >= State.STARTED.ordinal()) goto L22;
    L24:
        boolean activityCreated = false;
    L26:
        if (SysMonitorFwBridge.getFactory().getPrefetchState().prefetchNotReadyThenStart(getTask().prefetchState) == false) goto L28;
        boolean activityCreated2 = false;
    L29:
        if (newTask == true) goto L34;
        if (activityCreated2 == true) goto L34;
        if (this.task.getActivity(new ActivityRecord$$ExternalSyntheticLambda23(this)) != null) goto L34;
        boolean r2 = true;
    L35:
        boolean newSingleActivity = r2;
        String r3 = this.packageName;
        if (newTask == true) goto L40;
        if (newSingleActivity == true) goto L40;
        r4 = false;
    L40:
        boolean scheduled = addStartingWindow(r3, resolvedTheme, prev, r4, taskSwitch, processRunning, allowTaskSnapshot(), activityCreated2, this.mSplashScreenStyleSolidColor, this.allDrawn);
        if (WindowManagerDebugConfig.DEBUG_STARTING_WINDOW_VERBOSE == false) goto L45;
        if (scheduled == false) goto L46;
        Slog.d("ActivityTaskManager", "Scheduled starting window for " + this);
        return;
    L46:
        return;
    L45:
        return;
    L34:
        r2 = false;
        goto L35
    L28:
        activityCreated2 = activityCreated;
        goto L29
    L22:
        if (this.mState.ordinal() > State.STOPPED.ordinal()) goto L24;
        activityCreated = true;
        goto L26
    L18:
        r1 = 0;
        goto L19
    L10:
        startOptions = this.mPendingOptions;
        goto L11
    }

    private /* synthetic */ boolean lambda$showStartingWindow$14(ActivityRecord r) {
        if (r.finishing == true) goto L6;
        if (r == this) goto L6;
        return true;
    L6:
        return false;
    }

    void cancelInitializing() {
        if (this.mStartingData == null) goto L9;
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L7;
        Slog.w("ActivityTaskManager", "Found orphaned starting window " + this);
    L7:
        removeStartingWindowAnimation(false);
    L9:
        if (this.mDisplayContent.mUnknownAppVisibilityController.allResolved() == true) goto L12;
        this.mDisplayContent.mUnknownAppVisibilityController.appRemovedOrHidden(this);
        return;
    }

    void postWindowRemoveStartingWindowCleanup(WindowState win) {
        if (this.mStartingWindow != win) goto L9;
        if (this.mStartingSurface == null) goto L7;
        this.mStartingSurface.remove(false, false);
    L7:
        this.mStartingWindow = null;
        this.mStartingData = null;
        this.mStartingSurface = null;
    L9:
        if (this.mChildren.size() == 0) goto L11;
        return;
    L11:
        if (this.mVisibleSetFromTransferredStartingWindow == false) goto L15;
        setVisible(false);
        return;
    }

    void requestUpdateWallpaperIfNeeded() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L6;
        WindowState w = (WindowState) this.mChildren.get(i);
        w.requestUpdateWallpaperIfNeeded();
        i = i - 1;
        goto L3
    }

    WindowState findMainWindow() {
        return findMainWindow(true);
    }

    WindowState findMainWindow(boolean includeStartingApp) {
        WindowState candidate = null;
        int j = this.mChildren.size() - 1;
    L3:
        if (j < 0) goto L15;
        WindowState win = (WindowState) this.mChildren.get(j);
        int type = win.mAttrs.type;
        if (type == 1) goto L10;
        if (includeStartingApp == false) goto L12;
        if (type == 3) goto L10;
    L12:
        j = j - 1;
    L10:
        if (win.mAnimatingExit == false) goto L13;
        candidate = win;
        goto L12
    L13:
        return win;
    L15:
        return candidate;
    }

    public int isAppInfoGame() {
        if (this.info.applicationInfo != null) goto L5;
        return 0;
    L5:
        if (this.info.applicationInfo.category != 0) goto L7;
    L10:
        int r1 = 1;
    L11:
        int isGame = r1;
        return isGame;
    L7:
        if ((this.info.applicationInfo.flags & 33554432) == 33554432) goto L10;
        r1 = 0;
        goto L11
    }

    boolean isTransitionForward() {
        if (this.mStartingData == null) goto L7;
        if (this.mStartingData.mIsTransitionForward == false) goto L7;
    L8:
        return true;
    L7:
        if (this.mDisplayContent.isNextTransitionForward() == true) goto L8;
        return false;
    }

    @Override // com.android.server.wm.WindowToken, com.android.server.wm.WindowContainer
    void resetSurfacePositionForAnimationLeash(SurfaceControl.Transaction t) {
    }

    @Override // com.android.server.wm.WindowContainer
    boolean showSurfaceOnCreation() {
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    void prepareSurfaces() {
        boolean show = false;
        if (getTask() != null) goto L5;
    L7:
        boolean isDecorSurfaceBoosted = false;
    L9:
        if (isVisible() == false) goto L12;
        if (isDecorSurfaceBoosted == true) goto L12;
    L13:
        show = true;
    L15:
        if (this.mSurfaceControl == null) goto L30;
        getExt().traceStartTrace(getSyncTransaction(), "prepareSurfaces");
        if (show == true) goto L19;
    L21:
        if (show == false) goto L23;
    L25:
        getExt().traceEndTrace(getSyncTransaction());
        if (show == false) goto L30;
        if (this.mSyncState != 0) goto L30;
        this.mActivityRecordInputSink.applyChangesToSurfaceIfChanged(getPendingTransaction());
        goto L30
    L23:
        if (this.mLastSurfaceShowing == false) goto L25;
        getSyncTransaction().hide(this.mSurfaceControl);
        goto L25
    L19:
        if (this.mLastSurfaceShowing == true) goto L21;
        getSyncTransaction().show(this.mSurfaceControl);
    L30:
        this.mLastSurfaceShowing = show;
        super.prepareSurfaces();
        return;
    L12:
        if (isAnimating(2, 257) == false) goto L15;
    L5:
        if (getTask().isDecorSurfaceBoosted() == false) goto L7;
        isDecorSurfaceBoosted = true;
        goto L9
    }

    boolean isSurfaceShowing() {
        return this.mLastSurfaceShowing;
    }

    public int getTransit() {
        return this.mTransit;
    }

    void registerRemoteAnimations(RemoteAnimationDefinition definition) {
        this.mRemoteAnimationDefinition = definition;
        if (definition == null) goto L6;
        definition.linkToDeath(new ActivityRecord$$ExternalSyntheticLambda14(this));
        return;
    }

    void unregisterRemoteAnimations() {
        this.mRemoteAnimationDefinition = null;
    }

    @Override // com.android.server.wm.WindowContainer
    RemoteAnimationDefinition getRemoteAnimationDefinition() {
        return this.mRemoteAnimationDefinition;
    }

    @Override // com.android.server.wm.WindowToken
    void applyFixedRotationTransform(DisplayInfo info, DisplayFrames displayFrames, Configuration config) {
        super.applyFixedRotationTransform(info, displayFrames, config);
        ensureActivityConfiguration();
    }

    @Override // com.android.server.wm.WindowContainer
    int getRequestedConfigurationOrientation(boolean forDisplay) {
        return getRequestedConfigurationOrientation(forDisplay, getOverrideOrientation());
    }

    @Override // com.android.server.wm.WindowContainer
    int getRequestedConfigurationOrientation(boolean forDisplay, int requestedOrientation) {
        if (this.mAppCompatController.getTransparentPolicy().hasInheritedOrientation() == false) goto L14;
        RootDisplayArea root = getRootDisplayArea();
        if (forDisplay == false) goto L12;
        if (root == null) goto L12;
        if (root.isOrientationDifferentFromDisplay() == false) goto L12;
        return reverseConfigurationOrientation(this.mAppCompatController.getTransparentPolicy().getInheritedOrientation());
    L12:
        return this.mAppCompatController.getTransparentPolicy().getInheritedOrientation();
    L14:
        if (this.task == null) goto L22;
        if (requestedOrientation != 3) goto L22;
        ActivityRecord belowCandidate = this.task.getActivityBelowForDefiningOrientation(this);
        if (belowCandidate == null) goto L22;
        return belowCandidate.getRequestedConfigurationOrientation(forDisplay);
    L22:
        return super.getRequestedConfigurationOrientation(forDisplay, requestedOrientation);
    }

    public static int reverseConfigurationOrientation(int orientation) {
        switch(orientation) {
            case 1: goto L6;
            case 2: goto L4;
            default: goto L3;
        };
    L3:
        return orientation;
    L4:
        return 1;
    L6:
        return 2;
    }

    boolean canDefineOrientationForActivitiesAbove() {
        if (this.finishing == false) goto L5;
        return false;
    L5:
        int overrideOrientation = getOverrideOrientation();
        if (overrideOrientation != (-2)) goto L8;
        return false;
    L8:
        if (overrideOrientation == 3) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.android.server.wm.WindowToken
    void onCancelFixedRotationTransform(int originalDisplayRotation) {
        if (this == this.mDisplayContent.getLastOrientationSource()) goto L5;
        return;
    L5:
        int requestedOrientation = getRequestedConfigurationOrientation();
        if (requestedOrientation != 0) goto L8;
    L10:
        this.mDisplayContent.mPinnedTaskController.onCancelFixedRotationTransform();
        ensureActivityConfiguration();
        if (this.mTransitionController.isCollecting(this) == false) goto L14;
        this.task.resetSurfaceControlTransforms();
        return;
    L14:
        return;
    L8:
        if (requestedOrientation == this.mDisplayContent.getConfiguration().orientation) goto L10;
    }

    void setRequestedOrientation(int requestedOrientation) {
        if (this.mAppCompatController.getOrientationPolicy().shouldIgnoreRequestedOrientation(requestedOrientation) == false) goto L5;
        return;
    L5:
        int originalRelaunchingCount = this.mPendingRelaunchCount;
        if (getRequestedConfigurationOrientation(false, requestedOrientation) == getRequestedConfigurationOrientation(false)) goto L9;
        this.mAppCompatController.getSizeCompatModePolicy().clearSizeCompatModeAttributes();
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L11;
        String protoLogParam0 = String.valueOf(ActivityInfo.screenOrientationToString(requestedOrientation));
        String protoLogParam1 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -9178011226407552682L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L11:
        int resolvedOrientation = setOrientation(requestedOrientation, this);
        if (resolvedOrientation == requestedOrientation) goto L17;
        if (isRestrictedFixedOrientation(requestedOrientation) == false) goto L17;
        Slog.i("ActivityTaskManager", "Ignoring requested fixed orientation " + ActivityInfo.screenOrientationToString(requestedOrientation) + " of " + this + " since target sdk 36");
    L17:
        if (getMergedOverrideConfiguration().equals(this.mLastReportedConfiguration.getMergedConfiguration()) == true) goto L24;
        ensureActivityConfiguration(false);
        if (this.mPendingRelaunchCount <= originalRelaunchingCount) goto L22;
        this.mAppCompatController.getOrientationOverrides().setRelaunchingAfterRequestedOrientationChanged(true);
    L22:
        if (this.mTransitionController.inPlayingTransition(this) == false) goto L24;
        this.mTransitionController.mValidateActivityCompat.add(this);
    L24:
        this.mAtmService.getTaskChangeNotificationController().notifyActivityRequestedOrientationChanged(this.task.mTaskId, requestedOrientation);
        this.mDisplayContent.getDisplayRotation().onSetRequestedOrientation();
    }

    void reportDescendantOrientationChangeIfNeeded() {
        if (onDescendantOrientationChanged(this) == false) goto L6;
        this.task.dispatchTaskInfoChangedIfNeeded(true);
        return;
    }

    boolean shouldIgnoreOrientationRequests() {
        if (this.mAppActivityEmbeddingSplitsEnabled == true) goto L5;
    L13:
        return false;
    L5:
        if (ActivityInfo.isFixedOrientationPortrait(getOverrideOrientation()) == false) goto L13;
        if (this.task.inMultiWindowMode() == true) goto L13;
        if (getTask().getConfiguration().smallestScreenWidthDp < 600) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    int getOrientation(int candidate) {
        if (this.finishing == false) goto L5;
    L19:
        return -2;
    L5:
        if (shouldIgnoreOrientationRequests() == true) goto L19;
        if (candidate != 3) goto L12;
        return getOverrideOrientation();
    L12:
        if (isVisibleRequested() == true) goto L14;
        int fixedRotation = getExt().getFixedRotationForSplashScreen();
        if (fixedRotation <= (-2)) goto L18;
        return fixedRotation;
    L18:
        return -2;
    L14:
        return getOverrideOrientation();
    }

    @Override // com.android.server.wm.WindowContainer
    protected int getOverrideOrientation() {
        int candidateOrientation = super.getOverrideOrientation();
        if (isRestrictedFixedOrientation(candidateOrientation) == false) goto L6;
        candidateOrientation = -1;
    L6:
        return this.mAppCompatController.getOrientationPolicy().overrideOrientationIfNeeded(candidateOrientation);
    }

    int getRequestedOrientation() {
        return super.getOverrideOrientation();
    }

    void setLastReportedGlobalConfiguration(Configuration config) {
        this.mLastReportedConfiguration.setGlobalConfiguration(config);
    }

    void setLastReportedConfiguration(Configuration global, Configuration override) {
        this.mLastReportedConfiguration.setConfiguration(global, override);
    }

    void setLastReportedActivityWindowInfo(ActivityWindowInfo activityWindowInfo) {
        this.mLastReportedActivityWindowInfo.set(activityWindowInfo);
    }

    AppCompatDisplayInsets getAppCompatDisplayInsets() {
        return this.mAppCompatController.getSizeCompatModePolicy().getAppCompatDisplayInsets();
    }

    boolean inSizeCompatMode() {
        return this.mAppCompatController.getSizeCompatModePolicy().inSizeCompatMode();
    }

    boolean shouldCreateAppCompatDisplayInsets() {
        return this.mAppCompatController.getSizeCompatModePolicy().shouldCreateAppCompatDisplayInsets();
    }

    @Override // com.android.server.wm.WindowToken
    boolean hasSizeCompatBounds() {
        return this.mAppCompatController.getSizeCompatModePolicy().hasSizeCompatBounds();
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public boolean matchParentBounds() {
        Rect overrideBounds = getResolvedOverrideBounds();
        if (overrideBounds.isEmpty() == false) goto L5;
        return true;
    L5:
        WindowContainer parent = getParent();
        if (parent != null) goto L8;
        return true;
    L8:
        if (parent.getBounds().equals(overrideBounds) == true) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.android.server.wm.WindowToken
    float getCompatScale() {
        return this.mAppCompatController.getSizeCompatModePolicy().getCompatScaleIfAvailable(new ActivityRecord$$ExternalSyntheticLambda22(this));
    }

    private /* synthetic */ double lambda$getCompatScale$15() {
        return access$001(this);
    }

    /* JADX WARN: Failed to apply debug info
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v12 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyDebugInfo(TypeUpdate.java:77)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:79)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v6 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r28v4 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    @Override // com.android.server.wm.WindowToken, com.android.server.wm.ConfigurationContainer
    void resolveOverrideConfiguration(android.content.res.Configuration r28) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ef: MOVE (r28v5 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (1 ??[boolean, int, float, short, byte, char]) A[DECLARE_VAR] in method: com.android.server.wm.ActivityRecord.resolveOverrideConfiguration(android.content.res.Configuration):void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 736
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.wm.ActivityRecord.resolveOverrideConfiguration(android.content.res.Configuration):void");
    }

    Rect getParentAppBoundsOverride() {
        return Rect.copyOrNull(this.mResolveConfigHint.mParentAppBoundsOverride);
    }

    void computeConfigByResolveHint(Configuration resolvedConfig, Configuration parentConfig) {
        this.task.computeConfigResourceOverrides(resolvedConfig, parentConfig, this.mResolveConfigHint);
        this.mResolveConfigHint.mTmpCompatInsets = null;
        this.mResolveConfigHint.mTmpOverrideDisplayInfo = null;
    }

    boolean areBoundsLetterboxed() {
        if (getAppCompatState(true) != 2) goto L7;
        return false;
    L7:
        return true;
    }

    private void logAppCompatState() {
        this.mTaskSupervisor.getActivityMetricsLogger().logAppCompatState(this);
    }

    int getAppCompatState() {
        return getAppCompatState(false);
    }

    private int getAppCompatState(boolean ignoreVisibility) {
        if (ignoreVisibility == true) goto L8;
        if (this.mVisibleRequested == true) goto L8;
        return 1;
    L8:
        if (this.mAppCompatController.getTransparentPolicy().isRunning() == true) goto L10;
        AppCompatSizeCompatModePolicy scmPolicy = this.mAppCompatController.getSizeCompatModePolicy();
        if (scmPolicy.isInSizeCompatModeForBounds() == false) goto L15;
        return 3;
    L15:
        AppCompatAspectRatioPolicy aspectRatioPolicy = this.mAppCompatController.getAspectRatioPolicy();
        if (aspectRatioPolicy.isLetterboxedForFixedOrientationAndAspectRatio() == false) goto L20;
        return 4;
    L20:
        if (aspectRatioPolicy.isLetterboxedForAspectRatioOnly() == false) goto L23;
        return 5;
    L23:
        return 2;
    L10:
        return this.mAppCompatController.getTransparentPolicy().getInheritedAppCompatState();
    }

    private void updateResolvedBoundsPosition(Configuration newParentConfiguration) {
        Configuration resolvedConfig = getResolvedOverrideConfiguration();
        Rect resolvedBounds = resolvedConfig.windowConfiguration.getBounds();
        if (resolvedBounds.isEmpty() == false) goto L5;
        return;
    L5:
        AppCompatSizeCompatModePolicy scmPolicy = this.mAppCompatController.getSizeCompatModePolicy();
        Rect screenResolvedBounds = scmPolicy.replaceResolvedBoundsIfNeeded(resolvedBounds);
        Rect parentAppBounds = this.mResolveConfigHint.mParentAppBoundsOverride;
        Rect parentBounds = this.mResolveConfigHint.mParentBoundsOverride;
        float screenResolvedBoundsWidth = screenResolvedBounds.width();
        float parentAppBoundsWidth = parentAppBounds.width();
        boolean isImmersiveMode = isImmersiveMode(parentBounds);
        if (isImmersiveMode == false) goto L8;
        Insets navBarInsets = this.mDisplayContent.getInsetsStateController().getRawInsetsState().calculateInsets(parentBounds, WindowInsets.Type.navigationBars(), true);
    L9:
        AppCompatReachabilityOverrides reachabilityOverrides = this.mAppCompatController.getReachabilityOverrides();
        int offsetX = 0;
        if (parentBounds.width() == screenResolvedBoundsWidth) goto L16;
        if (screenResolvedBoundsWidth > parentAppBoundsWidth) goto L16;
        float positionMultiplier = reachabilityOverrides.getHorizontalPositionMultiplier(newParentConfiguration);
        int appWidth = (int) (navBarInsets.right + parentAppBoundsWidth);
        offsetX = Math.max(0, (((int) Math.ceil((appWidth - screenResolvedBoundsWidth) * positionMultiplier)) - screenResolvedBounds.left) + parentAppBounds.left);
    L16:
        float parentAppBoundsHeight = parentAppBounds.height();
        float parentBoundsHeight = parentBounds.height();
        float screenResolvedBoundsHeight = screenResolvedBounds.height();
        int offsetY = 0;
        if (parentBoundsHeight == screenResolvedBoundsHeight) goto L24;
        if (screenResolvedBoundsHeight > parentAppBoundsHeight) goto L24;
        float positionMultiplier2 = reachabilityOverrides.getVerticalPositionMultiplier(newParentConfiguration);
        int appHeight = (int) (parentAppBoundsHeight + navBarInsets.bottom);
        float parentBoundsHeight2 = appHeight;
        offsetY = Math.max(0, (((int) Math.ceil((parentBoundsHeight2 - screenResolvedBoundsHeight) * positionMultiplier2)) - screenResolvedBounds.top) + parentAppBounds.top);
    L24:
        if (scmPolicy.applyOffsetIfNeeded(resolvedBounds, resolvedConfig, offsetX, offsetY) == true) goto L27;
        AppCompatUtils.offsetBounds(resolvedConfig, offsetX, offsetY);
    L27:
        if (resolvedConfig.windowConfiguration.getAppBounds().top != parentAppBounds.top) goto L30;
        if (isImmersiveMode == true) goto L30;
        resolvedConfig.windowConfiguration.getBounds().top = parentBounds.top;
        scmPolicy.alignToTopIfNeeded(parentBounds);
    L30:
        computeConfigByResolveHint(resolvedConfig, newParentConfiguration);
        scmPolicy.applySizeCompatScaleIfNeeded(resolvedBounds, resolvedConfig);
        return;
    L8:
        navBarInsets = Insets.NONE;
        goto L9
    }

    boolean isImmersiveMode(Rect parentBounds) {
        if (this.mResolveConfigHint.mUseOverrideInsetsForConfig == false) goto L5;
    L7:
        Insets navBarInsets = this.mDisplayContent.getInsetsStateController().getRawInsetsState().calculateInsets(parentBounds, WindowInsets.Type.navigationBars(), false);
        return Insets.NONE.equals(navBarInsets);
    L5:
        if (this.mWmService.mFlags.mInsetsDecoupledConfiguration == false) goto L7;
        return false;
    }

    Rect getScreenResolvedBounds() {
        Configuration resolvedConfig = getResolvedOverrideConfiguration();
        Rect resolvedBounds = resolvedConfig.windowConfiguration.getBounds();
        AppCompatSizeCompatModePolicy scmPolicy = this.mAppCompatController.getSizeCompatModePolicy();
        return scmPolicy.replaceResolvedBoundsIfNeeded(resolvedBounds);
    }

    void recomputeConfiguration() {
        if (this.mAppCompatController.getTransparentPolicy().applyOnOpaqueActivityBelow(new ActivityRecord$$ExternalSyntheticLambda15()) == true) goto L6;
        onRequestedOverrideConfigurationChanged(getRequestedOverrideConfiguration());
        return;
    }

    boolean isInTransition() {
        return inTransitionSelfOrParent();
    }

    private boolean orientationRespectedWithInsets(Rect parentBounds, Rect outStableBounds, Rect outNonDecorBounds) {
        outStableBounds.setEmpty();
        if (this.mDisplayContent != null) goto L6;
        return true;
    L6:
        if (this.mResolveConfigHint.mUseOverrideInsetsForConfig == true) goto L8;
        return true;
    L8:
        int requestedOrientation = getRequestedConfigurationOrientation();
        if (requestedOrientation != 0) goto L11;
        return true;
    L11:
        int orientationWithInsets = 2;
        if (parentBounds.height() < parentBounds.width()) goto L14;
        int orientation = 1;
    L16:
        if (isFixedRotationTransforming() == false) goto L18;
        DisplayInfo r3 = getFixedRotationTransformDisplayInfo();
    L19:
        DisplayInfo di = r3;
        Task task = getTask();
        task.calculateInsetFrames(outNonDecorBounds, outStableBounds, parentBounds, di, this.mResolveConfigHint.mUseOverrideInsetsForConfig);
        if (outStableBounds.height() < outStableBounds.width()) goto L23;
        orientationWithInsets = 1;
    L23:
        if (orientation == orientationWithInsets) goto L28;
        if (orientationWithInsets == requestedOrientation) goto L29;
        return false;
    L29:
        return true;
    L28:
        return true;
    L18:
        r3 = this.mDisplayContent.getDisplayInfo();
        goto L19
    L14:
        orientation = 2;
        goto L16
    }

    @Override // com.android.server.wm.WindowContainer
    boolean handlesOrientationChangeFromDescendant(int orientation) {
        if (shouldIgnoreOrientationRequests() == false) goto L7;
        return false;
    L7:
        return super.handlesOrientationChangeFromDescendant(orientation);
    }

    private void resolveFixedOrientationConfiguration(Configuration newParentConfig) {
        Rect parentBounds = this.mResolveConfigHint.mParentBoundsOverride;
        Rect stableBounds = new Rect();
        Rect outNonDecorBounds = this.mTmpBounds;
        if (shouldBypassSizeCompatMode(this.mDisplayContent) == false) goto L6;
        Slog.d("ActivityTaskManager", "don't use resolve fixed orientation configuration for carmateservice");
        return;
    L6:
        boolean orientationRespectedWithInsets = orientationRespectedWithInsets(parentBounds, stableBounds, outNonDecorBounds);
        if (orientationRespectedWithInsets == true) goto L9;
    L11:
        TaskFragment organizedTf = getOrganizedTaskFragment();
        if (organizedTf != null) goto L14;
    L16:
        Rect resolvedBounds = getResolvedOverrideConfiguration().windowConfiguration.getBounds();
        if (stableBounds.width() <= stableBounds.height()) goto L19;
        int r1 = 2;
    L20:
        int stableBoundsOrientation = r1;
        if (this.mResolveConfigHint.mUseOverrideInsetsForConfig == false) goto L23;
        int r2 = stableBoundsOrientation;
    L24:
        int parentOrientation = r2;
        int forcedOrientation = getRequestedConfigurationOrientation();
        boolean isEligibleForFixedOrientationLetterbox = this.mAppCompatController.getLetterboxPolicy().resolveFixedOrientationLetterboxEligibility(forcedOrientation, parentOrientation);
        if (isEligibleForFixedOrientationLetterbox == true) goto L29;
        if (forcedOrientation == 0) goto L28;
        if (orientationRespectedWithInsets == false) goto L29;
        return;
    L28:
        return;
    L29:
        AppCompatDisplayInsets appCompatDisplayInsets = getAppCompatDisplayInsets();
        this.mAppCompatController.getSizeCompatModePolicy();
        if (appCompatDisplayInsets == null) goto L35;
        if (appCompatDisplayInsets.mIsInFixedOrientationOrAspectRatioLetterbox == true) goto L35;
        return;
    L35:
        if (this.mResolveConfigHint.mUseOverrideInsetsForConfig == false) goto L37;
        Rect r5 = outNonDecorBounds;
    L38:
        Rect parentAppBounds = r5;
        if (orientationRespectedWithInsets == false) goto L41;
        Rect parentBoundsWithInsets = parentAppBounds;
    L42:
        Rect containingBounds = new Rect();
        Rect containingBoundsWithInsets = new Rect();
        if (forcedOrientation != 2) goto L45;
        int bottom = Math.min((parentBoundsWithInsets.top + parentBoundsWithInsets.width()) - 1, parentBoundsWithInsets.bottom);
        Rect stableBounds2 = containingBounds;
        stableBounds2.set(parentBounds.left, parentBoundsWithInsets.top, parentBounds.right, bottom);
        Rect outNonDecorBounds2 = containingBoundsWithInsets;
        outNonDecorBounds2.set(parentBoundsWithInsets.left, parentBoundsWithInsets.top, parentBoundsWithInsets.right, bottom);
    L46:
        Rect prevResolvedBounds = new Rect(resolvedBounds);
        resolvedBounds.set(stableBounds2);
        AppCompatAspectRatioPolicy aspectRatioPolicy = this.mAppCompatController.getAspectRatioPolicy();
        aspectRatioPolicy.applyDesiredAspectRatio(newParentConfig, parentBounds, resolvedBounds, outNonDecorBounds2, stableBounds2);
        if (appCompatDisplayInsets == null) goto L56;
        appCompatDisplayInsets.getBoundsByRotation(this.mTmpBounds, newParentConfig.windowConfiguration.getRotation());
        if (resolvedBounds.width() == this.mTmpBounds.width()) goto L51;
    L52:
        resolvedBounds.set(prevResolvedBounds);
        return;
    L51:
        if (resolvedBounds.height() != this.mTmpBounds.height()) goto L52;
    L56:
        if (resolvedBounds.equals(parentBounds) == false) goto L59;
        resolvedBounds.set(prevResolvedBounds);
        return;
    L59:
        this.mResolveConfigHint.mTmpCompatInsets = appCompatDisplayInsets;
        computeConfigByResolveHint(getResolvedOverrideConfiguration(), newParentConfig);
        aspectRatioPolicy.setLetterboxBoundsForFixedOrientationAndAspectRatio(new Rect(resolvedBounds));
        return;
    L45:
        stableBounds2 = containingBounds;
        outNonDecorBounds2 = containingBoundsWithInsets;
        int right = Math.min(parentBoundsWithInsets.left + parentBoundsWithInsets.height(), parentBoundsWithInsets.right);
        stableBounds2.set(parentBoundsWithInsets.left, parentBounds.top, right, parentBounds.bottom);
        outNonDecorBounds2.set(parentBoundsWithInsets.left, parentBoundsWithInsets.top, right, parentBoundsWithInsets.bottom);
        goto L46
    L41:
        parentBoundsWithInsets = stableBounds;
        goto L42
    L37:
        r5 = newParentConfig.windowConfiguration.getAppBounds();
        goto L38
    L23:
        r2 = newParentConfig.orientation;
        goto L24
    L19:
        r1 = 1;
        goto L20
    L14:
        if (organizedTf.fillsParent() == true) goto L16;
        return;
    L9:
        if (handlesOrientationChangeFromDescendant(getOverrideOrientation()) == false) goto L11;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public Rect getBounds() {
        final Rect superBounds = super.getBounds();
        final AppCompatSizeCompatModePolicy scmPolicy = this.mAppCompatController.getSizeCompatModePolicy();
        return (Rect) this.mAppCompatController.getTransparentPolicy().findOpaqueNotFinishingActivityBelow().map(new ActivityRecord$$ExternalSyntheticLambda18()).orElseGet(new ActivityRecord$$ExternalSyntheticLambda19(scmPolicy, superBounds));
    }

    private static /* synthetic */ Rect lambda$getBounds$16(AppCompatSizeCompatModePolicy scmPolicy, Rect superBounds) {
        return scmPolicy.getAppSizeCompatBoundsIfAvailable(superBounds);
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public boolean providesMaxBounds() {
        if (getUid() != 1000) goto L6;
        return false;
    L6:
        if (this.mDisplayContent == null) goto L11;
        if (this.mDisplayContent.sandboxDisplayApis() == true) goto L11;
        return false;
    L11:
        if (this.info.neverSandboxDisplayApis(sConstrainDisplayApisConfig) == false) goto L14;
        return false;
    L14:
        if (this.info.alwaysSandboxDisplayApis(sConstrainDisplayApisConfig) == false) goto L17;
        return true;
    L17:
        if (getAppCompatDisplayInsets() == null) goto L19;
    L22:
        return true;
    L19:
        if (shouldCreateAppCompatDisplayInsets() == true) goto L22;
        return false;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    protected boolean setOverrideGender(Configuration requestsTmpConfig, int gender) {
        return WindowProcessController.applyConfigGenderOverride(requestsTmpConfig, gender, this.mAtmService.mGrammaticalManagerInternal, getUid());
    }

    @Override // com.android.server.wm.WindowContainer
    Rect getAnimationBounds(int appRootTaskClipMode) {
        TaskFragment taskFragment = getTaskFragment();
        if (taskFragment == null) goto L6;
        return taskFragment.getBounds();
    L6:
        return getBounds();
    }

    @Override // com.android.server.wm.WindowContainer
    void getAnimationPosition(Point outPosition) {
        outPosition.set(0, 0);
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public void onConfigurationChanged(Configuration newParentConfig) {
        if (this.mTransitionController.isShellTransitionsEnabled() == true) goto L5;
    L19:
        boolean hasNonOrienSizeChanged = true;
        if (getAppCompatDisplayInsets() == null) goto L41;
        Configuration overrideConfig = getRequestedOverrideConfiguration();
        if (overrideConfig.windowConfiguration.getRotation() == (-1)) goto L24;
        boolean wasFixedOrient = true;
    L25:
        int requestedOrient = getRequestedConfigurationOrientation();
        if (requestedOrient != 0) goto L28;
    L35:
        if (wasFixedOrient == false) goto L41;
        if (requestedOrient != 0) goto L41;
        if (overrideConfig.windowConfiguration.getRotation() == (-1)) goto L41;
        overrideConfig.windowConfiguration.setRotation(-1);
        onRequestedOverrideConfigurationChanged(overrideConfig);
        return;
    L28:
        if (requestedOrient == getConfiguration().orientation) goto L35;
        if (requestedOrient != getParent().getConfiguration().orientation) goto L35;
        if (overrideConfig.windowConfiguration.getRotation() == getParent().getWindowConfiguration().getRotation()) goto L35;
        overrideConfig.windowConfiguration.setRotation(getParent().getWindowConfiguration().getRotation());
        onRequestedOverrideConfigurationChanged(overrideConfig);
        return;
    L24:
        wasFixedOrient = false;
    L41:
        boolean wasInPictureInPicture = inPinnedWindowingMode();
        DisplayContent display = this.mDisplayContent;
        int activityType = getActivityType();
        if (wasInPictureInPicture == true) goto L44;
    L64:
        super.onConfigurationChanged(newParentConfig);
    L65:
        if (activityType != 0) goto L67;
    L73:
        if (wasInPictureInPicture == false) goto L75;
    L79:
        if (display != null) goto L82;
        return;
    L82:
        if (this.mVisibleRequested == false) goto L85;
        display.handleActivitySizeCompatModeIfNeeded(this);
        return;
    L85:
        if (getAppCompatDisplayInsets() != null) goto L87;
        return;
    L87:
        if (this.visibleIgnoringKeyguard == false) goto L89;
        return;
    L89:
        if (this.app != null) goto L91;
    L92:
        int displayChanges = display.getCurrentOverrideConfigurationChanges();
        if (hasResizeChange(displayChanges) == true) goto L95;
    L97:
        hasNonOrienSizeChanged = false;
    L98:
        if (hasNonOrienSizeChanged == false) goto L100;
    L101:
        restartProcessIfVisible();
        return;
    L100:
        if ((displayChanges & 4096) != 0) goto L101;
        return;
    L95:
        if ((displayChanges & 536872064) == 536872064) goto L97;
    L91:
        if (this.app.hasVisibleActivities() == false) goto L92;
        return;
    L75:
        if (inPinnedWindowingMode() == false) goto L79;
        if (this.task == null) goto L79;
        this.mWaitForEnteringPinnedMode = false;
        this.mTaskSupervisor.scheduleUpdatePictureInPictureModeIfNeeded(this.task, this.task.getBounds());
        goto L79
    L67:
        if (activityType == getActivityType()) goto L73;
        String errorMessage = "Can't change activity type once set: " + this + " activityType=" + WindowConfiguration.activityTypeToString(getActivityType()) + ", was " + WindowConfiguration.activityTypeToString(activityType);
        if (Build.IS_DEBUGGABLE == true) goto L72;
        Slog.w("ActivityTaskManager", errorMessage);
        goto L73
    L72:
        throw new IllegalStateException(errorMessage);
    L44:
        if (attachedToProcess() == false) goto L64;
        if (display == null) goto L64;
        this.app.pauseConfigurationDispatch();     // Catch: Throwable -> L54
        super.onConfigurationChanged(newParentConfig);     // Catch: Throwable -> L54
        if (this.mVisibleRequested == false) goto L57;
        if (inMultiWindowMode() == true) goto L57;
        int rotation = display.rotationForActivityInDifferentOrientation(this);     // Catch: Throwable -> L54
        if (rotation == (-1)) goto L57;
        this.app.resumeConfigurationDispatch();     // Catch: Throwable -> L54
        display.setFixedRotationLaunchingApp(this, rotation);     // Catch: Throwable -> L54
    L57:
        if (this.app.resumeConfigurationDispatch() == false) goto L65;
        this.app.dispatchConfiguration(this.app.getConfiguration());
    L54:
        th = move-exception;
        if (this.app.resumeConfigurationDispatch() == false) goto L63;
        this.app.dispatchConfiguration(this.app.getConfiguration());
    L63:
        throw th;
    L5:
        if (isVisible() == false) goto L19;
        if (isVisibleRequested() == false) goto L19;
        if (getRequestedOverrideWindowingMode() != 0) goto L11;
        int projectedWindowingMode = newParentConfig.windowConfiguration.getWindowingMode();
    L13:
        if (getWindowingMode() == projectedWindowingMode) goto L19;
        if (this.mWaitForEnteringPinnedMode == true) goto L17;
    L18:
        this.mTransitionController.collect(this);
        goto L19
    L17:
        if (this.mTransitionController.inFinishingTransition(this) == true) goto L19;
    L11:
        projectedWindowingMode = getRequestedOverrideWindowingMode();
        goto L13
    }

    void dispatchConfigurationToChild(WindowState child, Configuration config) {
        if (isConfigurationDispatchPaused() == false) goto L5;
        return;
    L5:
        super.dispatchConfigurationToChild(child, config);
    }

    void pauseConfigurationDispatch() {
        this.mPauseConfigurationDispatchCount++;
        if (this.mPauseConfigurationDispatchCount == 1) goto L5;
        return;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[1] == false) goto L9;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, 2612201759169917322L, 0, new Object[]{protoLogParam0});
        return;
    }

    boolean resumeConfigurationDispatch() {
        this.mPauseConfigurationDispatchCount--;
        if (this.mPauseConfigurationDispatchCount <= 0) goto L6;
        return false;
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[1] == false) goto L9;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, 5153784493059555057L, 0, new Object[]{protoLogParam0});
    L9:
        if (this.mPauseConfigurationDispatchCount >= 0) goto L13;
        Slog.wtf("ActivityTaskManager", "Trying to resume non-paused configuration dispatch");
        this.mPauseConfigurationDispatchCount = 0;
        return false;
    L13:
        if (this.mLastReportedDisplayId == getDisplayId()) goto L15;
    L17:
        int i = getChildCount() - 1;
    L18:
        if (i < 0) goto L20;
        dispatchConfigurationToChild(getChildAt(i), getConfiguration());
        i = i - 1;
        goto L18
    L20:
        updateReportedConfigurationAndSend();
        return true;
    L15:
        if (getConfiguration().equals(this.mLastReportedConfiguration.getMergedConfiguration()) == false) goto L17;
        return false;
    }

    boolean isConfigurationDispatchPaused() {
        if (this.mPauseConfigurationDispatchCount <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    float getMinAspectRatio() {
        return this.mAppCompatController.getAspectRatioPolicy().getMinAspectRatio();
    }

    float getMaxAspectRatio() {
        return this.mAppCompatController.getAspectRatioPolicy().getMaxAspectRatio();
    }

    boolean shouldUpdateConfigForDisplayChanged() {
        if (this.mLastReportedDisplayId == getDisplayId()) goto L5;
        return true;
    L5:
        return false;
    }

    boolean ensureActivityConfiguration() {
        return ensureActivityConfiguration(false);
    }

    boolean ensureActivityConfiguration(boolean ignoreVisibility) {
        Task rootTask = getRootTask();
        if (rootTask.mConfigWillChange == false) goto L9;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L7;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, -8630021188868292872L, 0, new Object[]{protoLogParam0});
    L7:
        return true;
    L9:
        if (this.finishing == false) goto L15;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L13;
        String protoLogParam1 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, -3976984054291875926L, 0, new Object[]{protoLogParam1});
    L13:
        return true;
    L15:
        if (isState(State.DESTROYED) == true) goto L17;
        if (ignoreVisibility == true) goto L32;
        if (this.mState == State.STOPPING) goto L28;
        if (this.mState == State.STOPPED) goto L28;
        if (shouldBeVisible() == true) goto L32;
    L28:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L30;
        String protoLogParam2 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, -6543078196636665108L, 0, new Object[]{protoLogParam2});
    L30:
        return true;
    L32:
        if (isConfigurationDispatchPaused() == false) goto L35;
        return true;
    L35:
        return updateReportedConfigurationAndSend();
    L17:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L19;
        String protoLogParam3 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, -1036762753077003128L, 0, new Object[]{protoLogParam3});
    L19:
        return true;
    }

    boolean updateReportedConfigurationAndSend() {
        if (isConfigurationDispatchPaused() == false) goto L6;
        Slog.wtf("ActivityTaskManager", "trying to update reported(client) config while dispatch is paused");
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L8;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, -3588725633248053181L, 0, new Object[]{protoLogParam0});
    L8:
        int newDisplayId = getDisplayId();
        if (this.mLastReportedDisplayId == newDisplayId) goto L11;
        boolean r0 = true;
    L12:
        boolean displayChanged = r0;
        boolean fromPrefetchDisplay = SysOptBridge.getFactory().getSysPrefetchService().isVirtualDisplayId(this.mLastReportedDisplayId);
        if (fromPrefetchDisplay == false) goto L16;
        if (displayChanged == false) goto L16;
        Slog.i("ActivityTaskManager", "mLastReportedDisplayId = " + this.mLastReportedDisplayId + " newDisplayId =" + newDisplayId + " fromPrefetch=" + fromPrefetchDisplay);
    L16:
        String mTmpLastReportedDisplayInfo = String.valueOf(this.mLastReportedDisplayId) + "###";
        String mTmpNewDisplayInfo = String.valueOf(newDisplayId) + "###";
        if (displayChanged == false) goto L25;
        this.mLastReportedDisplayId = newDisplayId;
        mTmpLastReportedDisplayInfo = mTmpLastReportedDisplayInfo + this.mLastReportedDisplayName;     // Catch: Exception -> L22
        this.mLastReportedDisplayName = getRootTask().getDisplayContent().getDisplay().getName();     // Catch: Exception -> L22
        mTmpNewDisplayInfo = mTmpNewDisplayInfo + this.mLastReportedDisplayName;     // Catch: Exception -> L22
    L25:
        if (this.mVisibleRequested == false) goto L27;
        this.mAppCompatController.getSizeCompatModePolicy().updateAppCompatDisplayInsets();
    L27:
        this.mTmpConfig.setTo(this.mLastReportedConfiguration.getMergedConfiguration());
        ActivityWindowInfo newActivityWindowInfo = getActivityWindowInfo();
        boolean isActivityWindowInfoChanged = !this.mLastReportedActivityWindowInfo.equals(newActivityWindowInfo);
        if (displayChanged == true) goto L36;
        if (isActivityWindowInfoChanged == true) goto L36;
        if (getConfiguration().equals(this.mTmpConfig) == false) goto L36;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L35;
        String protoLogParam1 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, 4672360193194734037L, 0, new Object[]{protoLogParam1});
    L35:
        return true;
    L36:
        int changes = getConfigurationChanges(this.mTmpConfig);
        Configuration newMergedOverrideConfig = getMergedOverrideConfiguration();
        setLastReportedConfiguration(getProcessGlobalConfiguration(), newMergedOverrideConfig);
        setLastReportedActivityWindowInfo(newActivityWindowInfo);
        if (this.mState != State.INITIALIZING) goto L44;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L42;
        String protoLogParam2 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, -8624278141553396410L, 0, new Object[]{protoLogParam2});
        return true;
    L42:
        return true;
    L44:
        if (changes != 0) goto L58;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L48;
        String protoLogParam3 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, 2485365009287691179L, 0, new Object[]{protoLogParam3});
    L48:
        if (displayChanged == false) goto L54;
        if (displayChanged == true) goto L51;
    L53:
        scheduleActivityMovedToDisplay(newDisplayId, newMergedOverrideConfig, newActivityWindowInfo);
    L55:
        notifyActivityRefresherAboutConfigurationChange(this.mLastReportedConfiguration.getMergedConfiguration(), this.mTmpConfig);
        return true;
    L51:
        if (getState() != State.RESUMED) goto L53;
        this.mAtmService.updateActivityUsageStats(this, 32, mTmpLastReportedDisplayInfo, mTmpNewDisplayInfo);
        goto L53
    L54:
        scheduleConfigurationChanged(newMergedOverrideConfig, newActivityWindowInfo);
        goto L55
    L58:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L62;
        String protoLogParam4 = String.valueOf(this);
        String protoLogParam5 = String.valueOf(Configuration.configurationDiffToString(changes));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, -8909639363543223474L, 0, new Object[]{protoLogParam4, protoLogParam5});
    L62:
        if (attachedToProcess() == true) goto L68;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L66;
        String protoLogParam6 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, -8048404379899908050L, 0, new Object[]{protoLogParam6});
    L66:
        return true;
    L68:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L72;
        String protoLogParam7 = String.valueOf(this.info.name);
        String protoLogParam8 = String.valueOf(Configuration.configurationDiffToString(changes));
        String protoLogParam9 = String.valueOf(Configuration.configurationDiffToString(this.info.getRealConfigChanged()));
        String protoLogParam10 = String.valueOf(Configuration.configurationDiffToString((~this.info.getRealConfigChanged()) & changes));
        String protoLogParam11 = String.valueOf(this.mLastReportedConfiguration);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, 5990673168178757529L, 0, new Object[]{protoLogParam7, protoLogParam8, protoLogParam9, protoLogParam10, protoLogParam11});
    L72:
        if (shouldRelaunchLocked(changes, this.mTmpConfig) == true) goto L74;
        if (displayChanged == true) goto L108;
        scheduleConfigurationChanged(newMergedOverrideConfig, newActivityWindowInfo);
    L113:
        notifyActivityRefresherAboutConfigurationChange(this.mLastReportedConfiguration.getMergedConfiguration(), this.mTmpConfig);
        return true;
    L108:
        if (getState() != State.RESUMED) goto L111;
        this.mAtmService.updateActivityUsageStats(this, 32, mTmpLastReportedDisplayInfo, mTmpNewDisplayInfo);
    L111:
        scheduleActivityMovedToDisplay(newDisplayId, newMergedOverrideConfig, newActivityWindowInfo);
        goto L113
    L74:
        if (this.mTmpConfig.windowConfiguration.getDisplayRotation() == getWindowConfiguration().getDisplayRotation()) goto L76;
    L79:
        boolean displayMayChange = true;
    L81:
        if (displayMayChange == false) goto L83;
    L85:
        boolean isAppResizeOnly = false;
    L86:
        boolean preserveWindow = isAppResizeOnly;
        boolean hasResizeChange = hasResizeChange((~this.info.getRealConfigChanged()) & changes);
        if (hasResizeChange == false) goto L93;
        boolean isDragResizing = this.task.isDragResizing();
        if (isDragResizing == false) goto L91;
        int r10 = 2;
    L92:
        this.mRelaunchReason = r10;
    L95:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L98;
        String protoLogParam12 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, 6779426581354721909L, 0, new Object[]{protoLogParam12});
    L98:
        if (this.mVisibleRequested == true) goto L104;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L104;
        String protoLogParam13 = String.valueOf(this);
        String protoLogParam14 = String.valueOf(Debug.getCallers(4));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 8969401915706456725L, 0, new Object[]{protoLogParam13, protoLogParam14});
    L104:
        Slog.w("ActivityTaskManager", " restart: " + this.info.name + " changed: " + Configuration.configurationDiffToString(changes) + " handles: " + Configuration.configurationDiffToString(this.info.getRealConfigChanged()) + " not-handles: " + Configuration.configurationDiffToString((~this.info.getRealConfigChanged()) & changes) + " mLastReportedConfiguration: " + this.mLastReportedConfiguration);
        relaunchActivityLocked(preserveWindow, changes);
        return false;
    L91:
        r10 = 1;
        goto L92
    L93:
        this.mRelaunchReason = 0;
        goto L95
    L83:
        if ((changes & (-3457)) != 0) goto L85;
        isAppResizeOnly = true;
        goto L86
    L76:
        if (this.mTmpConfig.windowConfiguration.getMaxBounds().equals(getWindowConfiguration().getMaxBounds()) == false) goto L79;
        displayMayChange = false;
        goto L81
    L11:
        r0 = false;
        goto L12
    }

    private void notifyActivityRefresherAboutConfigurationChange(Configuration newConfig, Configuration lastReportedConfig) {
        if (shouldBeResumed(null) == true) goto L5;
        return;
    L5:
        AppCompatCameraPolicy.onActivityConfigurationChanging(this, newConfig, lastReportedConfig);
    }

    private Configuration getProcessGlobalConfiguration() {
        if (this.app == null) goto L6;
        return this.app.getConfiguration();
    L6:
        return this.mAtmService.getGlobalConfiguration();
    }

    private boolean shouldRelaunchLocked(int changes, Configuration changesConfig) {
        if (Features.FEAT_QUICK_WIN == true) goto L5;
    L7:
        int configChanged = this.info.getRealConfigChanged();
        if ((134217728 & configChanged) == 0) goto L10;
        return false;
    L10:
        boolean onlyVrUiModeChanged = onlyVrUiModeChanged(changes, changesConfig);
        if (this.info.applicationInfo.targetSdkVersion >= 26) goto L17;
        if (this.requestedVrComponent == null) goto L17;
        if (onlyVrUiModeChanged == false) goto L17;
        configChanged = configChanged | 512;
    L17:
        if (this.mWmService.mSkipActivityRelaunchWhenDocking == false) goto L24;
        if (onlyDeskInUiModeChanged(changesConfig) == false) goto L24;
        if (hasDeskResources() == true) goto L24;
        configChanged = configChanged | 512;
    L24:
        if (((~configChanged) & changes) == 0) goto L27;
        return true;
    L27:
        return false;
    L5:
        if (getExt().skipRelaunch(changes, changesConfig) == false) goto L7;
        return false;
    }

    private boolean onlyVrUiModeChanged(int changes, Configuration lastReportedConfig) {
        Configuration currentConfig = getConfiguration();
        if (changes == 512) goto L5;
    L7:
        return false;
    L5:
        if (AppCompatUtils.isInVrUiMode(currentConfig) == AppCompatUtils.isInVrUiMode(lastReportedConfig)) goto L7;
        return true;
    }

    private boolean onlyDeskInUiModeChanged(Configuration lastReportedConfig) {
        Configuration currentConfig = getConfiguration();
        if (isInDeskUiMode(currentConfig) == isInDeskUiMode(lastReportedConfig)) goto L5;
        boolean deskModeChanged = true;
    L7:
        if ((currentConfig.uiMode & (-16)) == (lastReportedConfig.uiMode & (-16))) goto L9;
        boolean uiModeOtherFieldsChanged = true;
    L10:
        if (deskModeChanged == false) goto L14;
        if (uiModeOtherFieldsChanged == false) goto L13;
        return false;
    L13:
        return true;
    L14:
        return false;
    L9:
        uiModeOtherFieldsChanged = false;
        goto L10
    L5:
        deskModeChanged = false;
        goto L7
    }

    boolean hasDeskResources() {
        if (this.mHasDeskResources != null) goto L5;
        int r0 = 0;
        this.mHasDeskResources = false;
        Resources packageResources = this.mAtmService.mContext.createPackageContextAsUser(this.packageName, 0, UserHandle.of(this.mUserId)).getResources();     // Catch: PackageManager.NameNotFoundException -> L13
        Configuration[] r2 = packageResources.getSizeAndUiModeConfigurations();     // Catch: PackageManager.NameNotFoundException -> L13
        int r3 = r2.length;     // Catch: PackageManager.NameNotFoundException -> L13
    L8:
        if (r0 >= r3) goto L19;
        Configuration sizeConfiguration = r2[r0];     // Catch: PackageManager.NameNotFoundException -> L13
        if (isInDeskUiMode(sizeConfiguration) == true) goto L11;
        r0 = r0 + 1;
        goto L8
    L11:
        this.mHasDeskResources = true;     // Catch: PackageManager.NameNotFoundException -> L13
    L19:
        return this.mHasDeskResources.booleanValue();
    L13:
        e = move-exception;
        Slog.w("ActivityTaskManager", "Exception thrown during checking for desk resources " + this, e);
        goto L19
    L5:
        return this.mHasDeskResources.booleanValue();
    }

    private int getConfigurationChanges(Configuration lastReportedConfig) {
        int changes = SizeConfigurationBuckets.filterDiff(lastReportedConfig.diff(getConfiguration()), lastReportedConfig, getConfiguration(), this.mSizeConfigurations);
        if ((536870912 & changes) != 0) goto L5;
        return changes;
    L5:
        return changes & (-536870913);
    }

    private static boolean hasResizeChange(int change) {
        if ((change & 3456) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    void relaunchActivityLocked(boolean preserveWindow, int configChangeFlags) {
        ActivityRecord r4 = this;
        if (r4.mAtmService.mSuppressResizeConfigChanges == false) goto L7;
        if (preserveWindow == false) goto L7;
        return;
    L7:
        if (preserveWindow == true) goto L21;
        InputTarget imeInputTarget = r4.mDisplayContent.getImeInputTarget();
        if (imeInputTarget != null) goto L11;
    L19:
        boolean r1 = false;
    L20:
        r4.mLastImeShown = r1;
        goto L21
    L11:
        if (imeInputTarget.getWindowState() == null) goto L19;
        if (imeInputTarget.getWindowState().mActivityRecord != r4) goto L19;
        if (r4.mDisplayContent.mInputMethodWindow == null) goto L19;
        if (r4.mDisplayContent.mInputMethodWindow.isVisible() == false) goto L19;
        r1 = true;
    L21:
        Task rootTask = r4.getRootTask();
        if (rootTask == null) goto L27;
        if (rootTask.mTranslucentActivityWaiting != r4) goto L27;
        rootTask.checkTranslucentActivityWaiting(null);
    L27:
        if (r4.isState(State.RESUMED) == false) goto L29;
    L32:
        boolean r0 = true;
    L33:
        boolean andResume = r0;
        if (andResume == false) goto L36;
        List<ResultInfo> pendingResults = r4.results;
        List<ReferrerIntent> pendingNewIntents = r4.newIntents;
        List<ResultInfo> pendingResults2 = pendingResults;
        List<ReferrerIntent> pendingNewIntents2 = pendingNewIntents;
    L38:
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == false) goto L40;
        Slog.v("ActivityTaskManager", "Relaunching: " + r4 + " with results=" + pendingResults2 + " newIntents=" + pendingNewIntents2 + " andResume=" + andResume + " preserveWindow=" + preserveWindow);
    L40:
        if (andResume == false) goto L46;
        ZTEActivityEventsInternal zteActivityEventsInternal = (ZTEActivityEventsInternal) LocalServices.getService(ZTEActivityEventsInternal.class);
        if (zteActivityEventsInternal == null) goto L45;
        zteActivityEventsInternal.notifyActivityEvent(2, r4.getDisplayId(), r4.mUserId, r4, r4.getRootTaskId());
    L45:
        EventLogTags.writeWmRelaunchResumeActivity(r4.mUserId, System.identityHashCode(r4), r4.task.mTaskId, r4.shortComponentName, Integer.toHexString(configChangeFlags));
    L48:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[2] == false) goto L54;
        if (andResume == false) goto L51;
        String r2 = "RESUMED";
    L52:
        String protoLogParam0 = String.valueOf(r2);
        String protoLogParam1 = String.valueOf(r4);
        String protoLogParam2 = String.valueOf(Debug.getCallers(6));
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_STATES, 328802837600679598L, 0, new Object[]{protoLogParam0, protoLogParam1, protoLogParam2});
        goto L54
    L51:
        r2 = "PAUSED";
    L54:
        ClientTransactionItem callbackItem = new ActivityRelaunchItem(r4.token, pendingResults2, pendingNewIntents2, configChangeFlags, new MergedConfiguration(r4.getProcessGlobalConfiguration(), r4.getMergedOverrideConfiguration()), preserveWindow, r4.getActivityWindowInfo());
        if (andResume == 0) goto L57;
        ResumeActivityItem r5 = new ResumeActivityItem(r4.token, r4.isTransitionForward(), r4.shouldSendCompatFakeFocus());
    L74:
        boolean isSuccessful = r4.mAtmService.getLifecycleManager().scheduleTransactionItems(r4.app.getThread(), new ClientTransactionItem[]{callbackItem, r5});     // Catch: RemoteException -> L60
    L62:
        if (isSuccessful == false) goto L66;
        r4.startRelaunching();
        if (r4.task == null) goto L66;
        r4.mWmService.getObricExt().reportErrorToListener(r4.task.mTaskId, 3);
    L66:
        if (andResume == true) goto L68;
        r4.removePauseTimeout();
        r4.callServiceTrackeronActivityStatechange(State.PAUSED, true);
        r4.setState(State.PAUSED, "relaunchActivityLocked");
    L72:
        r4.mTaskSupervisor.mStoppingActivities.remove(r4);
        return;
    L68:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[0] == false) goto L70;
        String protoLogParam3 = String.valueOf(r4);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_STATES, -3997125892953197985L, 0, new Object[]{protoLogParam3});
    L70:
        r4.results = null;
        r4.newIntents = null;
        r4.mAtmService.getAppWarningsLocked().onResumeActivity(r4);
    L60:
        e = move-exception;
        Slog.w("ActivityTaskManager", "Failed to relaunch " + r4 + ": " + e);
        isSuccessful = false;
        goto L62
    L57:
        r5 = new PauseActivityItem(r4.token);
        goto L74
    L46:
        r4 = r4;
        EventLogTags.writeWmRelaunchActivity(r4.mUserId, System.identityHashCode(r4), r4.task.mTaskId, r4.shortComponentName, Integer.toHexString(configChangeFlags));
        goto L48
    L36:
        pendingResults2 = null;
        pendingNewIntents2 = null;
        goto L38
    L29:
        if (r4.shouldBeResumed(null) == true) goto L32;
        r0 = false;
        goto L33
    }

    void restartProcessIfVisible() {
        if (this.finishing == false) goto L5;
        return;
    L5:
        Slog.i("ActivityTaskManager", "Request to restart process of " + this);
        this.mAppCompatController.getSizeCompatModePolicy().clearSizeCompatMode();
        this.mAppCompatController.getDisplayCompatModePolicy().onProcessRestarted();
        if (attachedToProcess() == true) goto L8;
        return;
    L8:
        callServiceTrackeronActivityStatechange(State.RESTARTING_PROCESS, true);
        setState(State.RESTARTING_PROCESS, "restartActivityProcess");
        if (this.mVisibleRequested == true) goto L11;
    L18:
        this.mAtmService.mH.post(new ActivityRecord$$ExternalSyntheticLambda11(this));
        return;
    L11:
        if (this.mHaveState == true) goto L18;
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L16;
        final Transition transition = new Transition(5, 0, this.mTransitionController, this.mWmService.mSyncEngine);
        this.mTransitionController.startCollectOrQueue(transition, new ActivityRecord$$ExternalSyntheticLambda12(this, transition));
        return;
    L16:
        scheduleStopForRestartProcess();
    }

    private /* synthetic */ void lambda$restartProcessIfVisible$17() {
        WindowManagerGlobalLock r0 = this.mAtmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L13:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (hasProcess() == true) goto L7;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        if (this.app.getReportedProcState() <= 6) goto L15;
        WindowProcessController wpc = this.app;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        this.mAtmService.mAmInternal.killProcess(wpc.mName, wpc.mUid, "resetConfig");
    }

    private /* synthetic */ void lambda$restartProcessIfVisible$18(Transition transition, boolean deferred) {
        if (this.mState == State.RESTARTING_PROCESS) goto L5;
    L9:
        transition.abort();
        return;
    L5:
        if (attachedToProcess() == false) goto L9;
        setVisibleRequested(false);
        transition.collect(this);
        this.mTransitionController.requestStartTransition(transition, this.task, null, null);
        scheduleStopForRestartProcess();
    }

    private void scheduleStopForRestartProcess() {
        this.mAtmService.getLifecycleManager().scheduleTransactionItem(this.app.getThread(), new StopActivityItem(this.token));     // Catch: RemoteException -> L5
    L7:
        this.mTaskSupervisor.scheduleRestartTimeout(this);
        return;
    L5:
        e = move-exception;
        Slog.w("ActivityTaskManager", "Exception thrown during restart " + this, e);
        goto L7
    }

    boolean isProcessRunning() {
        WindowProcessController proc = this.app;
        if (proc != null) goto L5;
        proc = (WindowProcessController) this.mAtmService.mProcessNames.get(this.processName, this.info.applicationInfo.uid);
    L5:
        if (proc != null) goto L7;
    L9:
        return false;
    L7:
        if (proc.hasThread() == false) goto L9;
        return true;
    }

    private boolean allowTaskSnapshot() {
        if (this.newIntents != null) goto L5;
        return true;
    L5:
        int i = this.newIntents.size() - 1;
    L6:
        if (i < 0) goto L24;
        Intent intent = this.newIntents.get(i);
        if (intent == null) goto L22;
        if (isMainIntent(intent) == true) goto L22;
        if (this.mLastNewIntent == null) goto L15;
        boolean sameIntent = this.mLastNewIntent.filterEquals(intent);
    L17:
        if (sameIntent == false) goto L20;
        if (intent.getExtras() == null) goto L22;
        return false;
    L20:
        return false;
    L15:
        sameIntent = this.intent.filterEquals(intent);
    L22:
        i = i - 1;
        goto L6
    L24:
        return true;
    }

    boolean isNoHistory() {
        if ((this.intent.getFlags() & 1073741824) == 0) goto L5;
    L8:
        return true;
    L5:
        if ((this.info.flags & 128) != 0) goto L8;
        return false;
    }

    void saveToXml(TypedXmlSerializer out) throws IOException, XmlPullParserException {
        out.attributeLong(null, ATTR_ID, this.createTime);
        out.attributeInt(null, ATTR_LAUNCHEDFROMUID, this.launchedFromUid);
        if (this.launchedFromPackage == null) goto L6;
        out.attribute(null, ATTR_LAUNCHEDFROMPACKAGE, this.launchedFromPackage);
    L6:
        if (this.launchedFromFeatureId == null) goto L9;
        out.attribute(null, ATTR_LAUNCHEDFROMFEATURE, this.launchedFromFeatureId);
    L9:
        if (this.resolvedType == null) goto L11;
        out.attribute(null, ATTR_RESOLVEDTYPE, this.resolvedType);
    L11:
        out.attributeBoolean(null, ATTR_COMPONENTSPECIFIED, this.componentSpecified);
        out.attributeInt(null, ATTR_USERID, this.mUserId);
        if (this.taskDescription == null) goto L14;
        this.taskDescription.saveToXml(out);
    L14:
        out.startTag(null, TAG_INTENT);
        this.intent.saveToXml(out);
        out.endTag(null, TAG_INTENT);
        if (isPersistable() == true) goto L17;
    L19:
        ActivityCallerState.CallerInfo initialCallerInfo = this.mCallerState.getCallerInfoOrNull(this.initialCallerInfoAccessToken);
        if (initialCallerInfo == null) goto L23;
        out.startTag(null, TAG_INITIAL_CALLER_INFO);
        initialCallerInfo.saveToXml(out);
        out.endTag(null, TAG_INITIAL_CALLER_INFO);
        return;
    L23:
        return;
    L17:
        if (this.mPersistentState == null) goto L19;
        out.startTag(null, TAG_PERSISTABLEBUNDLE);
        this.mPersistentState.saveToXml(out);
        out.endTag(null, TAG_PERSISTABLEBUNDLE);
        goto L19
    }

    static ActivityRecord restoreFromXml(TypedXmlPullParser in, ActivityTaskSupervisor taskSupervisor) throws IOException, XmlPullParserException {
        in = in;
        Intent intent = null;
        PersistableBundle persistentState = null;
        int launchedFromUid = in.getAttributeInt(null, ATTR_LAUNCHEDFROMUID, 0);
        String launchedFromPackage = in.getAttributeValue(null, ATTR_LAUNCHEDFROMPACKAGE);
        String launchedFromFeature = in.getAttributeValue(null, ATTR_LAUNCHEDFROMFEATURE);
        String resolvedType = in.getAttributeValue(null, ATTR_RESOLVEDTYPE);
        boolean componentSpecified = in.getAttributeBoolean(null, ATTR_COMPONENTSPECIFIED, false);
        int userId = in.getAttributeInt(null, ATTR_USERID, 0);
        long createTime = in.getAttributeLong(null, ATTR_ID, -1);
        int outerDepth = in.getDepth();
        ActivityCallerState.CallerInfo initialCallerInfo = null;
        ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription();
        taskDescription.restoreFromXml(in);
    L3:
        int event = in.next();
        if (event == 1) goto L26;
        if (event != 3) goto L12;
        if (in.getDepth() < outerDepth) goto L26;
    L12:
        if (event != 2) goto L3;
        String name = in.getName();
        if (TAG_INTENT.equals(name) == false) goto L17;
        intent = Intent.restoreFromXml(in);
        goto L3
    L17:
        if (TAG_PERSISTABLEBUNDLE.equals(name) == false) goto L20;
        persistentState = PersistableBundle.restoreFromXml(in);
        goto L3
    L20:
        if (TAG_INITIAL_CALLER_INFO.equals(name) == false) goto L22;
        initialCallerInfo = ActivityCallerState.CallerInfo.restoreFromXml(in);
        goto L3
    L22:
        StringBuilder r13 = new StringBuilder();
        r13.append("restoreActivity: unexpected name=");
        r13.append(name);
        Slog.w("ActivityTaskManager", r13.toString());
        XmlUtils.skipCurrentTag(in);
        intent = intent;
    L26:
        if (intent == 0) goto L37;
        ActivityTaskManagerService service = taskSupervisor.mService;
        Intent intent2 = intent;
        ActivityInfo aInfo = taskSupervisor.resolveActivity(intent2, resolvedType, 0, null, userId, Binder.getCallingUid(), 0);
        if (aInfo == null) goto L35;
        ActivityRecord r = Builder.m9643$$Nest$msetCreateTime(Builder.m9645$$Nest$msetTaskDescription(Builder.m9644$$Nest$msetPersistentState(new Builder(service).setLaunchedFromUid(launchedFromUid).setLaunchedFromPackage(launchedFromPackage).setLaunchedFromFeature(launchedFromFeature).setIntent(intent2).setResolvedType(resolvedType).setActivityInfo(aInfo).setComponentSpecified(componentSpecified), persistentState), taskDescription), createTime).build();
        if (initialCallerInfo == null) goto L33;
        r.mCallerState.add(r.initialCallerInfoAccessToken, initialCallerInfo);
    L33:
        return r;
    L35:
        throw new XmlPullParserException("restoreActivity resolver error. Intent=" + intent2 + " resolvedType=" + resolvedType);
    L37:
        throw new XmlPullParserException("restoreActivity error intent=" + intent);
    }

    private static boolean isInDeskUiMode(Configuration config) {
        if ((config.uiMode & 15) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    String getProcessName() {
        return this.info.applicationInfo.processName;
    }

    public int getUid() {
        return this.info.applicationInfo.uid;
    }

    boolean isUid(int uid) {
        if (this.info.applicationInfo.uid != uid) goto L5;
        return true;
    L5:
        return false;
    }

    public int getPid() {
        if (this.app != null) goto L7;
        return 0;
    L7:
        return this.app.getPid();
    }

    public int getLaunchedFromPid() {
        return this.launchedFromPid;
    }

    public int getLaunchedFromUid() {
        return this.launchedFromUid;
    }

    String getFilteredReferrer(String referrerPackage) {
        if (referrerPackage != null) goto L4;
        return null;
    L4:
        if (referrerPackage.equals(this.packageName) == false) goto L6;
    L8:
        return referrerPackage;
    L6:
        if (this.mWmService.mPmInternal.filterAppAccess(referrerPackage, this.info.applicationInfo.uid, this.mUserId) == false) goto L8;
        return null;
    }

    boolean canTurnScreenOn() {
        if (getTurnScreenOnFlag() == true) goto L6;
        return false;
    L6:
        if (this.mCurrentLaunchCanTurnScreenOn == true) goto L8;
        return false;
    L8:
        if (this.mTaskSupervisor.getKeyguardController().checkKeyguardVisibility(this) == false) goto L13;
        return true;
    L13:
        return false;
    }

    void setTurnScreenOn(boolean turnScreenOn) {
        this.mTurnScreenOn = turnScreenOn;
    }

    void setAllowCrossUidActivitySwitchFromBelow(boolean allowed) {
        this.mAllowCrossUidActivitySwitchFromBelow = allowed;
    }

    boolean getTurnScreenOnFlag() {
        if (this.mTurnScreenOn == false) goto L5;
    L8:
        return true;
    L5:
        if (containsTurnScreenOnWindow() == true) goto L8;
        return false;
    }

    private boolean containsTurnScreenOnWindow() {
        if (isRelaunching() == true) goto L5;
        int i = this.mChildren.size() - 1;
    L7:
        if (i < 0) goto L12;
        if ((((WindowState) this.mChildren.get(i)).mAttrs.flags & 2097152) != 0) goto L10;
        i = i - 1;
        goto L7
    L10:
        return true;
    L12:
        return false;
    L5:
        return this.mLastContainsTurnScreenOnWindow;
    }

    boolean canResumeByCompat() {
        if (this.app != null) goto L5;
    L8:
        return true;
    L5:
        if (this.app.updateTopResumingActivityInProcessIfNeeded(this) == true) goto L8;
        return false;
    }

    boolean isTopRunningActivity() {
        if (this.mRootWindowContainer.topRunningActivity() != this) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isFocusedActivityOnDisplay() {
        return this.mDisplayContent.forAllTaskDisplayAreas(new ActivityRecord$$ExternalSyntheticLambda9(this));
    }

    private /* synthetic */ boolean lambda$isFocusedActivityOnDisplay$19(TaskDisplayArea taskDisplayArea) {
        if (taskDisplayArea.getFocusedActivity() != this) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isRootOfTask() {
        if (this.task != null) goto L5;
        return false;
    L5:
        ActivityRecord rootActivity = this.task.getRootActivity(true);
        if (this == rootActivity) goto L8;
        return false;
    L8:
        return true;
    }

    void setTaskOverlay(boolean taskOverlay) {
        this.mTaskOverlay = taskOverlay;
        setAlwaysOnTop(this.mTaskOverlay);
    }

    boolean isTaskOverlay() {
        return this.mTaskOverlay;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public boolean isAlwaysOnTop() {
        if (this.mTaskOverlay == false) goto L5;
    L8:
        return true;
    L5:
        if (super.isAlwaysOnTop() == true) goto L8;
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean showToCurrentUser() {
        if (this.mShowForAllUsers == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mWmService.isUserVisible(this.mUserId) == true) goto L8;
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean canCustomizeAppTransition() {
        return true;
    }

    @Override // com.android.server.wm.WindowToken
    public String toString() {
        if (this.stringName == null) goto L17;
        StringBuilder r0 = new StringBuilder();
        r0.append(this.stringName);
        r0.append(" t");
        if (this.task != null) goto L7;
        int r1 = -1;
    L8:
        r0.append(r1);
        String r2 = "";
        if (this.finishing == false) goto L11;
        String r3 = " f}";
    L12:
        r0.append(r3);
        if (this.mIsExiting == false) goto L15;
        r2 = " isExiting";
    L15:
        r0.append(r2);
        r0.append("}");
        return r0.toString();
    L11:
        r3 = "";
        goto L12
    L7:
        r1 = this.task.mTaskId;
        goto L8
    L17:
        StringBuilder sb = new StringBuilder(128);
        sb.append("ActivityRecord{");
        sb.append(System.identityHashCode(this));
        sb.append(" u");
        sb.append(this.mUserId);
        sb.append(' ');
        sb.append(this.intent.getComponent().flattenToShortString());
        this.stringName = sb.toString();
        return this.stringName;
    }

    void dumpDebug(ProtoOutputStream proto, int logLevel) {
        writeNameToProto(proto, 1138166333441L);
        super.dumpDebug(proto, 1146756268034L, logLevel);
        proto.write(1133871366147L, this.mLastSurfaceShowing);
        proto.write(1133871366149L, isAnimating(7, 17));
        proto.write(1133871366151L, fillsParent());
        proto.write(1133871366152L, this.mAppStopped);
        proto.write(1133871366174L, !occludesParent());
        proto.write(1133871366168L, this.mVisible);
        proto.write(1133871366153L, this.mVisibleRequested);
        proto.write(1133871366154L, isClientVisible());
        proto.write(1133871366155L, this.mDeferHidingClient);
        proto.write(1133871366156L, this.mReportedDrawn);
        proto.write(1133871366157L, this.reportedVisible);
        proto.write(1120986464270L, this.mNumInterestingWindows);
        proto.write(1120986464271L, this.mNumDrawnWindows);
        proto.write(1133871366160L, this.allDrawn);
        if (this.mStartingWindow == null) goto L5;
        this.mStartingWindow.writeIdentifierToProto(proto, 1146756268051L);
    L5:
        proto.write(1133871366164L, isStartingWindowDisplayed());
        proto.write(1133871366345L, this.startingMoved);
        proto.write(1133871366166L, this.mVisibleSetFromTransferredStartingWindow);
        proto.write(1138166333467L, this.mState.toString());
        proto.write(1133871366172L, isRootOfTask());
        if (hasProcess() == false) goto L8;
        proto.write(1120986464285L, this.app.getPid());
    L8:
        proto.write(1133871366175L, this.pictureInPictureArgs.isAutoEnterEnabled());
        proto.write(1133871366176L, inSizeCompatMode());
        proto.write(1108101562401L, getMinAspectRatio());
        proto.write(1133871366178L, providesMaxBounds());
        proto.write(1133871366179L, this.mEnableRecentsScreenshot);
        proto.write(1120986464292L, this.mLastDropInputMode);
        proto.write(1120986464293L, getOverrideOrientation());
        proto.write(1133871366182L, shouldSendCompatFakeFocus());
        AppCompatCameraOverrides cameraOverrides = this.mAppCompatController.getCameraOverrides();
        proto.write(1133871366183L, cameraOverrides.shouldForceRotateForCameraCompat());
        proto.write(1133871366184L, cameraOverrides.shouldRefreshActivityForCameraCompat());
        proto.write(1133871366185L, cameraOverrides.shouldRefreshActivityViaPauseForCameraCompat());
        AppCompatAspectRatioOverrides aspectRatioOverrides = this.mAppCompatController.getAspectRatioOverrides();
        proto.write(1133871366186L, aspectRatioOverrides.shouldOverrideMinAspectRatio());
        proto.write(1133871366187L, this.mAppCompatController.getOrientationOverrides().shouldIgnoreOrientationRequestLoop());
        proto.write(1133871366188L, this.mAppCompatController.getResizeOverrides().shouldOverrideForceResizeApp());
        proto.write(1133871366189L, aspectRatioOverrides.shouldEnableUserAspectRatioSettings());
        proto.write(1133871366190L, aspectRatioOverrides.isUserFullscreenOverrideEnabled());
        proto.write(1112396529711L, this.mRequestOpenInBrowserEducationTimestamp);
    }

    @Override // com.android.server.wm.WindowToken, com.android.server.wm.WindowContainer
    long getProtoFieldId() {
        return 1146756268038L;
    }

    @Override // com.android.server.wm.WindowToken, com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public void dumpDebug(ProtoOutputStream proto, long fieldId, int logLevel) {
        if (logLevel == 2) goto L5;
    L7:
        long token = proto.start(fieldId);
        dumpDebug(proto, logLevel);
        proto.end(token);
        return;
    L5:
        if (isVisible() == true) goto L7;
    }

    void writeNameToProto(ProtoOutputStream proto, long fieldId) {
        proto.write(fieldId, this.shortComponentName);
    }

    @Override // com.android.server.wm.WindowContainer
    void writeIdentifierToProto(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, System.identityHashCode(this));
        proto.write(1120986464258L, this.mUserId);
        proto.write(1138166333443L, this.intent.getComponent().flattenToShortString());
        proto.end(token);
    }

    @Override // com.android.server.wm.WindowContainer
    boolean canCreateRemoteAnimationTarget() {
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    void getAnimationFrames(Rect outFrame, Rect outInsets, Rect outStableInsets, Rect outSurfaceInsets) {
        WindowState win = findMainWindow();
        if (win != null) goto L5;
        return;
    L5:
        win.getAnimationFrames(outFrame, outInsets, outStableInsets, outSurfaceInsets);
    }

    void setPictureInPictureParams(PictureInPictureParams p) {
        this.pictureInPictureArgs.copyOnlySet(p);
        adjustPictureInPictureParamsIfNeeded(getBounds());
        getTask().getRootTask().onPictureInPictureParamsChanged();
    }

    void setShouldDockBigOverlays(boolean shouldDockBigOverlays) {
        this.shouldDockBigOverlays = shouldDockBigOverlays;
        getTask().getRootTask().onShouldDockBigOverlaysChanged();
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isSyncFinished(BLASTSyncEngine.SyncGroup group) {
        if (getExt().shouldSkipSyncFinishedForKeyguard() == false) goto L6;
        return true;
    L6:
        if (this.task == null) goto L17;
        if (this.task.mSharedStartingData == null) goto L17;
        WindowState startingWin = this.task.topStartingWindow();
        if (startingWin == null) goto L17;
        if (startingWin.mSyncState != 2) goto L17;
        if (this.mDisplayContent.mUnknownAppVisibilityController.allResolved() == false) goto L17;
        return true;
    L17:
        if (this.mAtmService.mBackNavigationController.isStartingSurfaceShown(this) == false) goto L20;
        return true;
    L20:
        if (super.isSyncFinished(group) == true) goto L23;
        return false;
    L23:
        if (this.mDisplayContent == null) goto L29;
        if (this.mDisplayContent.mUnknownAppVisibilityController.isVisibilityUnknown(this) == false) goto L29;
        Slog.d("ActivityTaskManager", "unknownApps is not empty: " + this.mDisplayContent.mUnknownAppVisibilityController.getDebugMessage());
        return false;
    L29:
        if (isVisibleRequested() == true) goto L50;
        if (this.task != null) goto L33;
    L48:
        return true;
    L33:
        if (this.task.getPausingActivity() != this) goto L48;
        if (this.mDisplayContent.isSleeping() == true) goto L48;
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == false) goto L39;
        ActivityRecord toResume = null;
    L41:
        if (toResume != null) goto L43;
    L46:
        Slog.d("ActivityTaskManager", this + " is pausing, and toResume is " + toResume);
        return false;
    L43:
        if (toResume.isVisible() == false) goto L46;
        Slog.i("ActivityTaskManager", "Assuming sync-finish while pausing due to visible target");
        goto L48
    L39:
        toResume = this.mDisplayContent.getActivity(new ActivityRecord$$ExternalSyntheticLambda8());
        goto L41
    L50:
        if (this.mPendingRelaunchCount <= 0) goto L53;
        return false;
    L53:
        if (isAttached() == true) goto L55;
        return false;
    L55:
        int i = this.mChildren.size() - 1;
    L56:
        if (i < 0) goto L62;
        if (((WindowState) this.mChildren.get(i)).isVisibleRequested() == true) goto L59;
        i = i - 1;
        goto L56
    L59:
        return true;
    L62:
        return false;
    }

    private static /* synthetic */ boolean lambda$isSyncFinished$20(ActivityRecord r) {
        if (r.finishing == false) goto L5;
    L11:
        return false;
    L5:
        if (r.isVisibleRequested() == false) goto L11;
        if (r.isTaskOverlay() == true) goto L11;
        if (r.isAlwaysOnTop() == true) goto L11;
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    void finishSync(SurfaceControl.Transaction outMergedTransaction, BLASTSyncEngine.SyncGroup group, boolean cancel) {
        if (isDifferentSyncGroup(group) == false) goto L5;
        return;
    L5:
        this.mLastAllReadyAtSync = allSyncFinished();
        super.finishSync(outMergedTransaction, group, cancel);
    }

    Point getMinDimensions() {
        ActivityInfo.WindowLayout windowLayout = this.info.windowLayout;
        if (windowLayout != null) goto L7;
        return null;
    L7:
        return new Point(windowLayout.minWidth, windowLayout.minHeight);
    }

    long getLastWindowCreateTime() {
        WindowState window = getWindow(WindowContainer.alwaysTruePredicate());
        if (window == null) goto L8;
        if (window.mAttrs.type == 1) goto L8;
        return window.getCreateTime();
    L8:
        return this.createTime;
    }

    private void adjustPictureInPictureParamsIfNeeded(Rect windowBounds) {
        if (this.pictureInPictureArgs != null) goto L5;
    L7:
        PackageManager pm = this.mAtmService.mContext.getPackageManager();
        if (this.pictureInPictureArgs.isAutoEnterEnabled() == true) goto L10;
        return;
    L10:
        if (pm.hasSystemFeature("android.software.leanback") == true) goto L12;
        return;
    L12:
        if (pm.checkPermission("android.permission.TV_IMPLICIT_ENTER_PIP", this.packageName) != (-1)) goto L17;
        Log.i("ActivityTaskManager", "Auto-enter PiP only allowed on TV if android.permission.TV_IMPLICIT_ENTER_PIP permission is held by the app.");
        PictureInPictureParams.Builder builder = new PictureInPictureParams.Builder();
        builder.setAutoEnterEnabled(false);
        this.pictureInPictureArgs.copyOnlySet(builder.build());
        return;
    L17:
        return;
    L5:
        if (this.pictureInPictureArgs.hasSourceBoundsHint() == false) goto L7;
        this.pictureInPictureArgs.getSourceRectHint().offset(windowBounds.left, windowBounds.top);
        goto L7
    }

    private void applyLocaleOverrideIfNeeded(Configuration resolvedConfig) {
        boolean differentPackage = true;
        if (isEmbedded() == false) goto L5;
    L10:
        boolean shouldAlignLocale = true;
    L11:
        if (shouldAlignLocale == true) goto L14;
        return;
    L14:
        if (this.task != null) goto L16;
    L20:
        differentPackage = false;
    L22:
        if (differentPackage == true) goto L24;
        return;
    L24:
        ActivityTaskManagerInternal.PackageConfig appConfig = this.mAtmService.mPackageConfigPersister.findPackageConfiguration(this.task.realActivity.getPackageName(), this.mUserId);
        if (appConfig != null) goto L27;
        return;
    L27:
        if (appConfig.mLocales != null) goto L29;
        return;
    L29:
        if (appConfig.mLocales.isEmpty() == true) goto L34;
        resolvedConfig.setLocales(appConfig.mLocales);
        return;
    L34:
        return;
    L16:
        if (this.task.realActivity == null) goto L20;
        if (this.task.realActivity.getPackageName().equals(this.packageName) == true) goto L20;
    L5:
        if (this.task != null) goto L7;
    L9:
        shouldAlignLocale = false;
        goto L11
    L7:
        if (this.task.mAlignActivityLocaleWithTask == false) goto L9;
        goto L9
    }

    boolean shouldSendCompatFakeFocus() {
        if (Features.FEAT_QUICK_WIN == false) goto L9;
        if (getExt().shouldSendCompatFakeFocus() == false) goto L9;
        return true;
    L9:
        return this.mAppCompatController.getFocusOverrides().shouldSendFakeFocus();
    }

    boolean canCaptureSnapshot() {
        if (isSurfaceShowing() == true) goto L5;
        return false;
    L5:
        if (findMainWindow() != null) goto L8;
        return false;
    L8:
        return forAllWindows(new ActivityRecord$$ExternalSyntheticLambda21(), true);
    }

    private static /* synthetic */ boolean lambda$canCaptureSnapshot$21(WindowState ws) {
        if (ws.mWinAnimator != null) goto L5;
    L9:
        return false;
    L5:
        if (ws.mWinAnimator.getShown() == false) goto L9;
        if (ws.mWinAnimator.mLastAlpha <= 0.0f) goto L9;
        return true;
    }

    void overrideCustomTransition(boolean open, int enterAnim, int exitAnim, int backgroundColor) {
        CustomAppTransition transition = getCustomAnimation(open);
        if (transition != null) goto L8;
        transition = new CustomAppTransition();
        if (open == false) goto L7;
        this.mCustomOpenTransition = transition;
        goto L8
    L7:
        this.mCustomCloseTransition = transition;
    L8:
        transition.mEnterAnim = enterAnim;
        transition.mExitAnim = exitAnim;
        transition.mBackgroundColor = backgroundColor;
    }

    void clearCustomTransition(boolean open) {
        if (open == false) goto L5;
        this.mCustomOpenTransition = null;
        return;
    L5:
        this.mCustomCloseTransition = null;
    }

    CustomAppTransition getCustomAnimation(boolean open) {
        if (open == false) goto L5;
        return this.mCustomOpenTransition;
    L5:
        return this.mCustomCloseTransition;
    }

    public ActivityRecordSmtBase getActivityRecordSmtEx() {
        return (ActivityRecordSmtBase) getSmtEx();
    }

    public ActivityRecordMonitorEx getActivityRecordMonitorEx() {
        return this.mActivityRecordMonitorEx;
    }

    public IExtActivityRecord getExt() {
        return this.mExt;
    }

    public ActivityInfo getActivityInfo() {
        return this.info;
    }

    public void notifyActivityDisplayChanged(DisplayContent prevDc, DisplayContent dc) {
        boolean carDisplayChanged = false;
        boolean isOnCarDisplay = isDisplayOwnByCarmateservice(dc);
        boolean r3 = false;
        if (this.firstTime == false) goto L6;
        this.mIsOnCarDisplay = isDisplayOwnByCarmateservice(prevDc);
        this.firstTime = false;
    L6:
        if (isOnCarDisplay == this.mIsOnCarDisplay) goto L18;
        this.mIsOnCarDisplay = isOnCarDisplay;
        if (isOnCarDisplay == false) goto L13;
        if (prevDc != null) goto L11;
    L17:
        carDisplayChanged = r3;
        Slog.d("ActivityTaskManager", "notifyActivityDisplayChanged mIsOnCarDisplay:" + isOnCarDisplay + " of " + this);
        goto L18
    L11:
        if (prevDc.getDisplayId() != 0) goto L17;
        r3 = true;
        goto L17
    L13:
        if (dc == null) goto L17;
        if (dc.getDisplayId() != 0) goto L17;
        r3 = true;
    L18:
        if (carDisplayChanged == false) goto L21;
        restartProcessIfVisible();
        Slog.d("ActivityTaskManager", "notifyActivityDisplayChanged: restart " + this + " moved between car display and default display");
        return;
    }

    public boolean isDisplayOwnByCarmateservice(DisplayContent dc) {
        if (dc != null) goto L4;
        return false;
    L4:
        if (dc.mDisplay != null) goto L6;
        return false;
    L6:
        if (dc.getDisplayId() != 0) goto L8;
        return false;
    L8:
        if (CAR_OWNER_APP.contains(dc.mDisplay.getOwnerPackageName()) == false) goto L15;
        Slog.d("ActivityTaskManager", "isDisplayOwnByCarmateservice DisplayId:" + dc.getDisplayId() + ", this = " + this);
        return true;
    L15:
        return false;
    }

    public boolean shouldBypassSizeCompatMode(DisplayContent dc) {
        if (dc == null) goto L5;
        this.mIsOnCarDisplay = isDisplayOwnByCarmateservice(dc);
    L5:
        if (this.mIsOnCarDisplay == false) goto L8;
        Slog.d("ActivityTaskManager", "shouldBypassSizeCompatMode for " + this + " on car display");
    L8:
        return this.mIsOnCarDisplay;
    }
}
