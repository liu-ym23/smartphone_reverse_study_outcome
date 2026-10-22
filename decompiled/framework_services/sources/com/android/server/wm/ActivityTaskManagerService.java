package com.android.server.wm;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ActivityOptions;
import android.app.ActivityTaskManager;
import android.app.ActivityThread;
import android.app.AlertDialog;
import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.IActivityClientController;
import android.app.IActivityController;
import android.app.IActivityTaskManager;
import android.app.IAppTask;
import android.app.IApplicationThread;
import android.app.IAssistDataReceiver;
import android.app.INotificationManager;
import android.app.IObricActivityTaskManager;
import android.app.IScreenCaptureObserver;
import android.app.ITaskStackListener;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.PictureInPictureUiState;
import android.app.ProfilerInfo;
import android.app.WaitResult;
import android.app.admin.DevicePolicyCache;
import android.app.admin.DeviceStateCache;
import android.app.assist.ActivityId;
import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.app.compat.CompatChanges;
import android.app.sdksandbox.sandboxactivity.SdkSandboxActivityAuthority;
import android.app.usage.UsageStatsManagerInternal;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.LocusId;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.FactoryTest;
import android.os.Handler;
import android.os.IBinder;
import android.os.IUserManager;
import android.os.InputConstants;
import android.os.LocaleList;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.PowerManager;
import android.os.PowerManagerInternal;
import android.os.Process;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UpdateLock;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.WorkSource;
import android.pico.utils.ExtImplFactory;
import android.pico.utils.Features;
import android.provider.Settings;
import android.service.dreams.DreamActivity;
import android.service.voice.IVoiceInteractionSession;
import android.service.voice.VoiceInteractionManagerInternal;
import android.sysprop.DisplayProperties;
import android.telecom.TelecomManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.IntArray;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import android.view.Display;
import android.view.RemoteAnimationAdapter;
import android.view.RemoteAnimationDefinition;
import android.window.BackAnimationAdapter;
import android.window.BackNavigationInfo;
import android.window.IWindowOrganizerController;
import android.window.SplashScreenView;
import android.window.TaskSnapshot;
import com.android.internal.app.IVoiceInteractor;
import com.android.internal.app.ProcessMap;
import com.android.internal.os.TransferPipe;
import com.android.internal.policy.AttributeCache;
import com.android.internal.policy.KeyguardDismissCallback;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FastPrintWriter;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.LocalManagerRegistry;
import com.android.server.LocalServices;
import com.android.server.SysDataSyncServiceManager;
import com.android.server.SysOptBridge;
import com.android.server.SystemConfig;
import com.android.server.SystemService;
import com.android.server.SystemServiceManager;
import com.android.server.UiThread;
import com.android.server.Watchdog;
import com.android.server.am.ActivityManagerService;
import com.android.server.am.AppTimeTracker;
import com.android.server.am.AssistDataRequester;
import com.android.server.am.BaseErrorDialog;
import com.android.server.am.IApplicationFreezer;
import com.android.server.am.IExtATMService;
import com.android.server.am.IZswContentProviderHelper;
import com.android.server.am.PendingIntentController;
import com.android.server.am.PendingIntentRecord;
import com.android.server.am.ProcessList;
import com.android.server.am.StackTracesDumpHelper;
import com.android.server.am.UserState;
import com.android.server.firewall.IntentFirewall;
import com.android.server.grammaticalinflection.GrammaticalInflectionManagerInternal;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.UserManagerService;
import com.android.server.policy.PermissionPolicyInternal;
import com.android.server.policy.PhoneWindowManager;
import com.android.server.sdksandbox.SdkSandboxManagerLocal;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.statusbar.StatusBarManagerInternal;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.uri.NeededUriGrants;
import com.android.server.uri.UriGrantsManagerInternal;
import com.android.server.wm.utils.WindowStyleCache;
import com.obric.utils.ObricImplFactory;
import com.zte.vendorconfig.VendorConfigManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityTaskManagerService extends IActivityTaskManager.Stub {
    static final long ACTIVITY_BG_START_GRACE_PERIOD_MS = 10000;
    static final boolean ANIMATE = true;
    static final int APP_SWITCH_ALLOW = 2;
    static final int APP_SWITCH_DISALLOW = 0;
    static final int APP_SWITCH_FG_ONLY = 1;
    static final int DEMOTE_TOP_REASON_DURING_UNLOCKING = 1;
    static final int DEMOTE_TOP_REASON_EXPANDED_NOTIFICATION_SHADE = 2;
    private static final long DOZE_ANIMATING_STATE_RETAIN_TIME_MS = 2000;
    public static final String DUMP_ACTIVITIES_CMD = "activities";
    public static final String DUMP_ACTIVITIES_SHORT_CMD = "a";
    public static final String DUMP_CONTAINERS_CMD = "containers";
    public static final String DUMP_LASTANR_CMD = "lastanr";
    public static final String DUMP_LASTANR_TRACES_CMD = "lastanr-traces";
    public static final String DUMP_RECENTS_CMD = "recents";
    public static final String DUMP_RECENTS_SHORT_CMD = "r";
    public static final String DUMP_STARTER_CMD = "starter";
    public static final String DUMP_TOP_RESUMED_ACTIVITY = "top-resumed";
    public static final String DUMP_VISIBLE_ACTIVITIES = "visible";
    static final long INSTRUMENTATION_KEY_DISPATCHING_TIMEOUT_MILLIS = 60000;
    static final int LAYOUT_REASON_CONFIG_CHANGED = 1;
    static final int LAYOUT_REASON_VISIBILITY_CHANGED = 2;
    private static final int PENDING_ASSIST_EXTRAS_LONG_TIMEOUT = 2000;
    private static final int PENDING_ASSIST_EXTRAS_TIMEOUT = 500;
    private static final int PENDING_AUTOFILL_ASSIST_STRUCTURE_TIMEOUT = 2000;
    static final int POWER_MODE_REASON_ALL = 3;
    static final int POWER_MODE_REASON_CHANGE_DISPLAY = 2;
    static final int POWER_MODE_REASON_START_ACTIVITY = 1;
    static final int POWER_MODE_REASON_UNKNOWN_VISIBILITY = 4;
    private static final long POWER_MODE_UNKNOWN_VISIBILITY_TIMEOUT_MS = 1000;
    public static final int RELAUNCH_REASON_FREE_RESIZE = 2;
    public static final int RELAUNCH_REASON_NONE = 0;
    public static final int RELAUNCH_REASON_WINDOWING_MODE_RESIZE = 1;
    private static final long RESUME_FG_APP_SWITCH_MS = 500;
    private static final String TAG = "ActivityTaskManager";
    static final String TAG_ROOT_TASK = "ActivityTaskManager";
    static final String TAG_SWITCH = "ActivityTaskManager";
    private static Boolean sIsPip2ExperimentEnabled;
    final int GL_ES_VERSION;
    private final ActivityTaskManagerInternalSmtBase mATInternalSmtEx;
    private int[] mAccessibilityServiceUids;
    private volatile ComponentName mActiveDreamComponent;
    final MirrorActiveUids mActiveUids;
    ComponentName mActiveVoiceInteractionServiceComponent;
    ActivityClientController mActivityClientController;
    private SparseArray<ActivityInterceptorCallback> mActivityInterceptorCallbacks;
    private ActivityStartController mActivityStartController;
    final SparseArray<ArrayMap<String, Integer>> mAllowAppSwitchUids;
    ActivityManagerInternal mAmInternal;
    private final List<android.app.AnrController> mAnrController;
    private AppOpsManager mAppOpsManager;
    private volatile int mAppSwitchesState;
    AppWarnings mAppWarnings;
    final BackNavigationController mBackNavigationController;
    private BackgroundActivityStartCallback mBackgroundActivityStartCallback;
    ActionChain.Tracker mChainTracker;
    private final Map<Integer, Set<Integer>> mCompanionAppUidsMap;
    CompatModePackages mCompatModePackages;
    private int mConfigurationSeq;
    Context mContext;
    IActivityController mController;
    boolean mControllerIsAMonkey;
    AppTimeTracker mCurAppTimeTracker;
    volatile int mDemoteTopAppReasons;
    boolean mDevEnableNonResizableMultiWindow;
    private int mDeviceOwnerUid;
    final int mFactoryTest;
    boolean mForceResizableActivities;
    private int mGlobalAssetsSeq;
    final WindowManagerGlobalLock mGlobalLock;
    final Object mGlobalLockWithoutBoost;
    GrammaticalInflectionManagerInternal mGrammaticalManagerInternal;
    H mH;
    boolean mHasCompanionDeviceSetupFeature;
    boolean mHasHeavyWeightFeature;
    boolean mHasLeanbackFeature;
    volatile WindowProcessController mHeavyWeightProcess;
    volatile WindowProcessController mHomeProcess;
    private final IExtATMService mIExt;
    IntentFirewall mIntentFirewall;
    final ActivityTaskManagerInternal mInternal;
    KeyguardController mKeyguardController;
    private boolean mKeyguardShown;
    String mLastANRState;
    ActivityRecord mLastResumedActivity;
    private volatile long mLastStopAppSwitchesTime;
    private int mLayoutReasons;
    private int mLegacyUiPerfHandler;
    private final ClientLifecycleManager mLifecycleManager;
    private LockTaskController mLockTaskController;
    float mMinPercentageMultiWindowSupportHeight;
    float mMinPercentageMultiWindowSupportWidth;
    private IObricActivityTaskManagerService mObricExt;
    PackageConfigPersister mPackageConfigPersister;
    private final ArrayList<PendingAssistExtras> mPendingAssistExtras;
    PendingIntentController mPendingIntentController;
    private BoostFramework mPerf;
    private PermissionPolicyInternal mPermissionPolicyInternal;
    private PackageManagerInternal mPmInternal;
    private PowerManagerInternal mPowerManagerInternal;
    private int mPowerModeReasons;
    volatile WindowProcessController mPreviousProcess;
    private long mPreviousProcessVisibleTime;
    final WindowProcessControllerMap mProcessMap;
    final ProcessMap<WindowProcessController> mProcessNames;
    String mProfileApp;
    private Set<Integer> mProfileOwnerUids;
    WindowProcessController mProfileProc;
    ProfilerInfo mProfilerInfo;
    private RecentTasks mRecentTasks;
    int mRespectsActivityMinWidthHeightMultiWindow;
    private volatile boolean mRetainPowerModeAndTopProcessState;
    RootWindowContainer mRootWindowContainer;
    IVoiceInteractionSession mRunningVoice;
    final List<ActivityTaskManagerInternal.ScreenObserver> mScreenObservers;
    private SettingObserver mSettingsObserver;
    private boolean mShowDialogs;
    volatile boolean mShuttingDown;
    private volatile boolean mSleeping;
    private final ActivityTaskManagerServiceSmtEx mSmtEx;
    final ArrayList<ActivityRecord> mStartingProcessActivities;
    private StatusBarManagerInternal mStatusBarManagerInternal;
    private String[] mSupportedSystemLocales;
    boolean mSupportsExpandedPictureInPicture;
    boolean mSupportsFreeformWindowManagement;
    boolean mSupportsMultiDisplay;
    boolean mSupportsMultiWindow;
    int mSupportsNonResizableMultiWindow;
    boolean mSupportsPictureInPicture;
    boolean mSupportsSplitScreenMultiWindow;
    boolean mSuppressResizeConfigChanges;
    private ComponentName mSysUiServiceComponent;
    final ActivityThread mSystemThread;
    private TaskChangeNotificationController mTaskChangeNotificationController;
    TaskFragmentOrganizerController mTaskFragmentOrganizerController;
    TaskOrganizerController mTaskOrganizerController;
    public ActivityTaskSupervisor mTaskSupervisor;
    private Configuration mTempConfig;
    private int mThumbnailHeight;
    private int mThumbnailWidth;
    final UpdateConfigurationResult mTmpUpdateConfigurationResult;
    String mTopAction;
    volatile WindowProcessController mTopApp;
    ComponentName mTopComponent;
    String mTopData;
    volatile int mTopProcessState;
    private ActivityRecord mTracedResumedActivity;
    UriGrantsManagerInternal mUgmInternal;
    private final Context mUiContext;
    UiHandler mUiHandler;
    private final UpdateLock mUpdateLock;
    private final Runnable mUpdateOomAdjRunnable;
    private UsageStatsManagerInternal mUsageStatsInternal;
    private UserManagerService mUserManager;
    private UserManagerInternal mUserManagerInternal;
    private int mViSessionId;
    final VisibleActivityProcessTracker mVisibleActivityProcessTracker;
    volatile WindowProcessController mVisibleDozeUiProcess;
    PowerManager.WakeLock mVoiceWakeLock;
    int mVr2dDisplayId;
    VrController mVrController;
    WindowManagerService mWindowManager;
    WindowOrganizerController mWindowOrganizerController;
    private final WindowStyleCache<ActivityRecord.WindowStyle> mWindowStyleCache;
    boolean toastWindow;

    /* JADX INFO: renamed from: com.android.server.wm.ActivityTaskManagerService$2, reason: invalid class name */
    class AnonymousClass2 extends KeyguardDismissCallback {
        final /* synthetic */ ActivityTaskManagerService this$0;
        final /* synthetic */ Runnable val$enterPipRunnable;
        final /* synthetic */ Transition val$transition;

        /* JADX INFO: renamed from: $r8$lambda$lyK7Pbr6bzW7Ca4V-H0TxyGFzg0, reason: not valid java name */
        public static /* synthetic */ void m9687$r8$lambda$lyK7Pbr6bzW7Ca4VH0TxyGFzg0(AnonymousClass2 r0, Runnable r1, boolean r2) {
            r0.lambda$onDismissSucceeded$0(r1, r2);
        }

        AnonymousClass2(ActivityTaskManagerService this$0, Transition r2, Runnable r3) {
            this.this$0 = this$0;
            this.val$transition = r2;
            this.val$enterPipRunnable = r3;
        }

        public void onDismissSucceeded() {
            if (this.val$transition != null) goto L6;
            this.this$0.mH.post(this.val$enterPipRunnable);
            return;
        L6:
            TransitionController r0 = this.this$0.getTransitionController();
            Transition r1 = this.val$transition;
            final Runnable r2 = this.val$enterPipRunnable;
            r0.startCollectOrQueue(r1, new ActivityTaskManagerService$2$$ExternalSyntheticLambda0(this, r2));
        }

        private /* synthetic */ void lambda$onDismissSucceeded$0(Runnable enterPipRunnable, boolean deferred) {
            if (deferred == false) goto L4;
            enterPipRunnable.run();
            return;
        L4:
            this.this$0.mH.post(enterPipRunnable);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface AppSwitchState {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface DemoteTopReason {
    }

    final class H extends Handler {
        static final int ADD_WAKEFULNESS_ANIMATING_REASON = 5;
        static final int END_POWER_MODE_UNKNOWN_VISIBILITY_MSG = 3;
        static final int FIRST_ACTIVITY_TASK_MSG = 100;
        static final int FIRST_SUPERVISOR_TASK_MSG = 200;
        static final int REMOVE_WAKEFULNESS_ANIMATING_REASON = 6;
        static final int REPORT_TIME_TRACKER_MSG = 1;
        static final int RESUME_FG_APP_SWITCH_MSG = 4;
        final /* synthetic */ ActivityTaskManagerService this$0;

        H(ActivityTaskManagerService this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L49;
                case 2: goto L63;
                case 3: goto L35;
                case 4: goto L23;
                case 5: goto L14;
                case 6: goto L5;
                default: goto L63;
            };
        L5:
            WindowProcessController proc = (WindowProcessController) msg.obj;
            WindowManagerGlobalLock r1 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r1);
            proc.removeAnimatingReason(2);     // Catch: Throwable -> L10
            monitor-exit(r1);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            Trace.instant(32, "finishWakefulnessAnimating");
            return;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L14:
            WindowProcessController proc2 = (WindowProcessController) msg.obj;
            WindowManagerGlobalLock r3 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r3);
            proc2.addAnimatingReason(2);     // Catch: Throwable -> L19
            monitor-exit(r3);     // Catch: Throwable -> L19
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L19:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L23:
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L28:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L26:
            if (ActivityTaskManagerService.m9658$$Nest$fgetmAppSwitchesState(this.this$0) != 0) goto L30;
            ActivityTaskManagerService.m9669$$Nest$fputmAppSwitchesState(this.this$0, 1);     // Catch: Throwable -> L28
        L30:
            monitor-exit(r0);     // Catch: Throwable -> L28
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L35:
            WindowManagerGlobalLock r2 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r2);
            ActivityTaskManagerService.m9671$$Nest$fputmRetainPowerModeAndTopProcessState(this.this$0, false);     // Catch: Throwable -> L42
            this.this$0.endPowerMode(4);     // Catch: Throwable -> L42
            if (this.this$0.mTopApp != null) goto L40;
        L44:
            monitor-exit(r2);     // Catch: Throwable -> L42
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L40:
            if (this.this$0.mTopProcessState != 12) goto L44;
            this.this$0.mTopApp.updateProcessInfo(false, false, true, false);     // Catch: Throwable -> L42
        L42:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L49:
            AppTimeTracker tracker = (AppTimeTracker) msg.obj;
            tracker.deliverResult(this.this$0.mContext);
            return;
        }
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    @interface HotPath {
        public static final int LRU_UPDATE = 2;
        public static final int NONE = 0;
        public static final int OOM_ADJUSTMENT = 1;
        public static final int PROCESS_CHANGE = 3;
        public static final int START_SERVICE = 4;

        int caller() default 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface LayoutReason {
    }

    public static final class Lifecycle extends SystemService {
        private final ActivityTaskManagerService mService;

        public Lifecycle(Context context) {
            super(context);
            this.mService = new ActivityTaskManagerService(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            publishBinderService("activity_task", this.mService);
            ActivityTaskManagerService.m9680$$Nest$mstart(this.mService);
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocked(SystemService.TargetUser user) {
            WindowManagerGlobalLock r0 = this.mService.getGlobalLock();
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.mService.mTaskSupervisor.onUserUnlocked(user.getUserIdentifier());     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.SystemService
        public void onUserStopped(SystemService.TargetUser user) {
            WindowManagerGlobalLock r0 = this.mService.getGlobalLock();
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.mService.mTaskSupervisor.mLaunchParamsPersister.onCleanupUser(user.getUserIdentifier());     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        public ActivityTaskManagerService getService() {
            return this.mService;
        }
    }

    final class LocalService extends ActivityTaskManagerInternal {
        final /* synthetic */ ActivityTaskManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$9L6bCoFX770T8O7d1m-CEPsZJ2s, reason: not valid java name */
        public static /* synthetic */ void m9688$r8$lambda$9L6bCoFX770T8O7d1mCEPsZJ2s(List r0, ActivityRecord r1) {
            lambda$getAttachedNonFinishingActivityForTask$2(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$K0VNmX0HW4WinBFZDY9FY4g3qgY(LocalService r0) {
            r0.lambda$showSystemReadyErrorDialogsIfNeeded$1();
        }

        /* JADX INFO: renamed from: $r8$lambda$Pn00PT-waP7RrmY7143mXlFTzNw, reason: not valid java name */
        public static /* synthetic */ boolean m9689$r8$lambda$Pn00PTwaP7RrmY7143mXlFTzNw(ActivityRecord r0) {
            return lambda$getTopVisibleFullScreenActivity$5(r0);
        }

        public static /* synthetic */ void $r8$lambda$PsKU3qzgMIyouIjFl0dizi2h9WM(LocalService r0, CharSequence r1) {
            r0.lambda$updateTopComponentForFactoryTest$3(r1);
        }

        public static /* synthetic */ void $r8$lambda$ug6lRtoHhlMy1xUAPsiPFvoHcTY(LocalService r0) {
            r0.lambda$showSystemReadyErrorDialogsIfNeeded$0();
        }

        public static /* synthetic */ boolean $r8$lambda$wCfXAaYFqmTS3D17subNsxGP2is(String r0, ActivityRecord r1) {
            return lambda$restartTaskActivityProcessIfVisible$4(r0, r1);
        }

        LocalService(ActivityTaskManagerService this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public ComponentName getHomeActivityForUser(int userId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            ActivityRecord homeActivity = this.this$0.mRootWindowContainer.getDefaultDisplayHomeActivityForUser(userId);     // Catch: Throwable -> L11
            if (homeActivity != null) goto L7;
            ComponentName r2 = null;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L11
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L7:
            r2 = homeActivity.mActivityComponent;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void onLocalVoiceInteractionStarted(IBinder activity, IVoiceInteractionSession voiceSession, IVoiceInteractor voiceInteractor) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            ActivityTaskManagerService.m9677$$Nest$monLocalVoiceInteractionStartedLocked(this.this$0, activity, voiceSession, voiceInteractor);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public List<ActivityAssistInfo> getTopVisibleActivities() {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            List<ActivityAssistInfo> r1 = this.this$0.mRootWindowContainer.getTopVisibleActivities();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean hasResumedActivity(int uid) {
            return this.this$0.mVisibleActivityProcessTracker.hasResumedActivity(uid);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void setBackgroundActivityStartCallback(BackgroundActivityStartCallback backgroundActivityStartCallback) {
            ActivityTaskManagerService.m9670$$Nest$fputmBackgroundActivityStartCallback(this.this$0, backgroundActivityStartCallback);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void setAccessibilityServiceUids(IntArray uids) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            ActivityTaskManagerService.m9667$$Nest$fputmAccessibilityServiceUids(this.this$0, uids.toArray());     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public int startActivitiesAsPackage(String packageName, String featureId, int userId, Intent[] intents, Bundle bOptions) {
            intents.getClass();
            String[] resolvedTypes = new String[intents.length];
            int packageUid = 0;
            long ident = Binder.clearCallingIdentity();
            int i = 0;
        L23:
        L6:
            th = th;
        L19:
            Binder.restoreCallingIdentity(ident);
            throw th;
        L4:
            if (i >= intents.length) goto L10;
            resolvedTypes[i] = intents[i].resolveTypeIfNeeded(this.this$0.mContext.getContentResolver());     // Catch: Throwable -> L6 RemoteException -> L8
            i = i + 1;     // Catch: Throwable -> L6 RemoteException -> L8
            goto L23
        L10:
            String r5 = packageName;
            int r10 = userId;
            packageUid = AppGlobals.getPackageManager().getPackageUid(r5, 268435456, r10);     // Catch: Throwable -> L15 RemoteException -> L17
            goto L14
        L15:
            th = th;
        L14:
            Binder.restoreCallingIdentity(ident);
            int packageUid2 = packageUid;
            int callingPid = Binder.getCallingPid();
            int callingUid = Binder.getCallingUid();
            String r4 = r5;
            return this.this$0.getActivityStartController().startActivitiesInPackage(packageUid2, r4, featureId, intents, resolvedTypes, null, SafeActivityOptions.fromBundle(bOptions, callingPid, callingUid), r10, false, null, false);
        L9:
            r5 = packageName;
            r10 = userId;
            goto L14
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public int startActivitiesInPackage(int uid, int realCallingPid, int realCallingUid, String callingPackage, String callingFeatureId, Intent[] intents, String[] resolvedTypes, IBinder resultTo, SafeActivityOptions options, int userId, boolean validateIncomingUser, PendingIntentRecord originatingPendingIntent, boolean allowBalExemptionForSystemProcess) {
            this.this$0.assertPackageMatchesCallingUid(callingPackage);
            return this.this$0.getActivityStartController().startActivitiesInPackage(uid, realCallingPid, realCallingUid, callingPackage, callingFeatureId, intents, resolvedTypes, resultTo, options, userId, validateIncomingUser, originatingPendingIntent, allowBalExemptionForSystemProcess);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public int startActivityInPackage(int uid, int realCallingPid, int realCallingUid, String callingPackage, String callingFeatureId, Intent intent, String resolvedType, IBinder resultTo, String resultWho, int requestCode, int startFlags, SafeActivityOptions options, int userId, Task inTask, String reason, boolean validateIncomingUser, PendingIntentRecord originatingPendingIntent, boolean allowBalExemptionForSystemProcess) {
            this.this$0.assertPackageMatchesCallingUid(callingPackage);
            return this.this$0.getActivityStartController().startActivityInPackage(uid, realCallingPid, realCallingUid, callingPackage, callingFeatureId, intent, resolvedType, resultTo, resultWho, requestCode, startFlags, options, userId, inTask, reason, validateIncomingUser, originatingPendingIntent, allowBalExemptionForSystemProcess);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public int startActivityAsUser(IApplicationThread caller, String callerPackage, String callerFeatureId, Intent intent, IBinder resultTo, int startFlags, Bundle options, int userId) {
            return ActivityTaskManagerService.m9681$$Nest$mstartActivityAsUser(this.this$0, caller, callerPackage, callerFeatureId, intent, intent.resolveTypeIfNeeded(this.this$0.mContext.getContentResolver()), resultTo, null, 0, startFlags, null, options, userId, false);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public int startActivityWithScreenshot(Intent intent, String callingPackage, int callingUid, int callingPid, IBinder resultTo, Bundle options, int userId) {
            int userId2 = this.this$0.getActivityStartController().checkTargetUser(userId, false, Binder.getCallingPid(), Binder.getCallingUid(), "startActivityWithScreenshot");
            return this.this$0.getActivityStartController().obtainStarter(intent, "startActivityWithScreenshot").setCallingUid(callingUid).setCallingPid(callingPid).setCallingPackage(callingPackage).setResultTo(resultTo).setActivityOptions(ActivityTaskManagerService.m9673$$Nest$mcreateSafeActivityOptionsWithBalAllowed(this.this$0, options)).setRealCallingUid(Binder.getCallingUid()).setUserId(userId2).setAllowBalExemptionForSystemProcess(true).setFreezeScreen(true).execute();
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void setVr2dDisplayId(int vr2dDisplayId) {
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L5;
            long protoLogParam0 = vr2dDisplayId;
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, -1123414663662718691L, 1, new Object[]{Long.valueOf(protoLogParam0)});
        L5:
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mVr2dDisplayId = vr2dDisplayId;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L11:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public int getDisplayId(IBinder token) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            ActivityRecord r = ActivityRecord.forTokenLocked(token);     // Catch: Throwable -> L10
            if (r == null) goto L13;
            int r2 = r.getDisplayId();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L13:
            throw new IllegalArgumentException("getDisplayId: No activity record matching token=" + token);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void registerScreenObserver(ActivityTaskManagerInternal.ScreenObserver observer) {
            this.this$0.mScreenObservers.add(observer);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void unregisterScreenObserver(ActivityTaskManagerInternal.ScreenObserver observer) {
            this.this$0.mScreenObservers.remove(observer);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean isCallerRecents(int callingUid) {
            return this.this$0.isCallerRecents(callingUid);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean isRecentsComponentHomeActivity(int userId) {
            return this.this$0.getRecentTasks().isRecentsComponentHomeActivity(userId);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean checkCanCloseSystemDialogs(int pid, int uid, String packageName) {
            return this.this$0.checkCanCloseSystemDialogs(pid, uid, packageName);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean canCloseSystemDialogs(int pid, int uid) {
            return ActivityTaskManagerService.m9672$$Nest$mcanCloseSystemDialogs(this.this$0, pid, uid);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void notifyActiveVoiceInteractionServiceChanged(ComponentName component) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mActiveVoiceInteractionServiceComponent = component;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void notifyActiveDreamChanged(ComponentName dreamComponent) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            ActivityTaskManagerService.m9668$$Nest$fputmActiveDreamComponent(this.this$0, dreamComponent);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public IAppTask startDreamActivity(Intent intent, int callingUid, int callingPid) {
            return ActivityTaskManagerService.m9682$$Nest$mstartDreamActivityInternal(this.this$0, intent, callingUid, callingPid);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void setAllowAppSwitches(String type, int uid, int userId) {
            if (this.this$0.mAmInternal.isUserRunning(userId, 1) == true) goto L5;
            return;
        L5:
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            ArrayMap<String, Integer> types = this.this$0.mAllowAppSwitchUids.get(userId);     // Catch: Throwable -> L13
            if (types != null) goto L16;
            if (uid >= 0) goto L15;
            monitor-exit(r0);     // Catch: Throwable -> L13
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L15:
            types = new ArrayMap();     // Catch: Throwable -> L13
            this.this$0.mAllowAppSwitchUids.put(userId, types);     // Catch: Throwable -> L13
        L16:
            if (uid >= 0) goto L18;
            types.remove(type);     // Catch: Throwable -> L13
        L19:
            monitor-exit(r0);     // Catch: Throwable -> L13
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L18:
            types.put(type, Integer.valueOf(uid));     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void onUserStopped(int userId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.getRecentTasks().unloadUserDataFromMemoryLocked(userId);     // Catch: Throwable -> L8
            this.this$0.mAllowAppSwitchUids.remove(userId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean isGetTasksAllowed(String caller, int callingPid, int callingUid) {
            return this.this$0.isGetTasksAllowed(caller, callingPid, callingUid);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void onProcessAdded(WindowProcessController proc) {
            Object r0 = this.this$0.mGlobalLockWithoutBoost;
            monitor-enter(r0);
            this.this$0.mPackageConfigPersister.updateConfigIfNeeded(proc, proc.mUserId, proc.mInfo.packageName);     // Catch: Throwable -> L7
            this.this$0.mProcessNames.put(proc.mName, proc.mUid, proc);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void onProcessRemoved(String name, int uid) {
            Object r0 = this.this$0.mGlobalLockWithoutBoost;
            monitor-enter(r0);
            WindowProcessController proc = (WindowProcessController) this.this$0.mProcessNames.remove(name, uid);     // Catch: Throwable -> L19
            if (proc != null) goto L7;
        L22:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L7:
            if (proc.mHasEverAttached == true) goto L22;
            if (this.this$0.mStartingProcessActivities.isEmpty() == true) goto L22;
            ArrayList<ActivityRecord> activities = new ArrayList(this.this$0.mStartingProcessActivities);     // Catch: Throwable -> L19
            int i = activities.size() - 1;     // Catch: Throwable -> L19
        L11:
            if (i < 0) goto L22;
            ActivityRecord r = activities.get(i);     // Catch: Throwable -> L19
            if (uid != r.info.applicationInfo.uid) goto L21;
            if (name.equals(r.processName) == false) goto L21;
            Slog.w("ActivityTaskManager", proc + " is removed with pending start " + r);     // Catch: Throwable -> L19
            this.this$0.mStartingProcessActivities.remove(r);     // Catch: Throwable -> L19
            if (r.isVisibleRequested() == false) goto L21;
            r.finishIfPossible("starting-proc-removed", false);     // Catch: Throwable -> L19
        L21:
            i = i - 1;     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void onCleanUpApplicationRecord(WindowProcessController proc) {
            Object r0 = this.this$0.mGlobalLockWithoutBoost;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (proc != this.this$0.mHomeProcess) goto L10;
            this.this$0.mHomeProcess = null;     // Catch: Throwable -> L7
        L10:
            if (proc != this.this$0.mPreviousProcess) goto L12;
            this.this$0.mPreviousProcess = null;     // Catch: Throwable -> L7
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public int getTopProcessState() {
            if (ActivityTaskManagerService.m9662$$Nest$fgetmRetainPowerModeAndTopProcessState(this.this$0) == false) goto L7;
            return 2;
        L7:
            return this.this$0.mTopProcessState;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean useTopSchedGroupForTopProcess() {
            if (this.this$0.mDemoteTopAppReasons != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void clearHeavyWeightProcessIfEquals(WindowProcessController proc) {
            Object r0 = this.this$0.mGlobalLockWithoutBoost;
            monitor-enter(r0);
            this.this$0.clearHeavyWeightProcessIfEquals(proc);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void finishHeavyWeightApp() {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (this.this$0.mHeavyWeightProcess == null) goto L9;
            this.this$0.mHeavyWeightProcess.finishActivities();     // Catch: Throwable -> L7
        L9:
            this.this$0.clearHeavyWeightProcessIfEquals(this.this$0.mHeavyWeightProcess);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean isSleeping() {
            return ActivityTaskManagerService.m9664$$Nest$fgetmSleeping(this.this$0);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean isShuttingDown() {
            return this.this$0.mShuttingDown;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean shuttingDown(boolean booted, int timeout) {
            this.this$0.mShuttingDown = true;
            this.this$0.mWindowManager.mSnapshotController.mTaskSnapshotController.prepareShutdown();
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mRootWindowContainer.prepareForShutdown();     // Catch: Throwable -> L8
            ActivityTaskManagerService.m9683$$Nest$mupdateEventDispatchingLocked(this.this$0, booted);     // Catch: Throwable -> L8
            this.this$0.notifyTaskPersisterLocked(null, true);     // Catch: Throwable -> L8
            boolean r1 = this.this$0.mTaskSupervisor.shutdownLocked(timeout);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void enableScreenAfterBoot(boolean booted) {
            com.android.server.am.EventLogTags.writeBootProgressEnableScreen(SystemClock.uptimeMillis());
            SysOptBridge.getFactory().getBootEventStat().writeEvent("boot_event_enable_screen", SystemClock.elapsedRealtime());
            this.this$0.mWindowManager.enableScreenAfterBoot();
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            ActivityTaskManagerService.m9683$$Nest$mupdateEventDispatchingLocked(this.this$0, booted);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            new Thread(new AnonymousClass1(this), "mUidCpuRunner.start()").start();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean showStrictModeViolationDialog() {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L11:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (ActivityTaskManagerService.m9663$$Nest$fgetmShowDialogs(this.this$0) == true) goto L7;
        L13:
            boolean r1 = false;
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L11
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L7:
            if (ActivityTaskManagerService.m9664$$Nest$fgetmSleeping(this.this$0) == true) goto L13;
            if (this.this$0.mShuttingDown == true) goto L13;
            r1 = true;
            goto L14
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void showSystemReadyErrorDialogsIfNeeded() {
            if (Trace.isTagEnabled(32) == false) goto L5;
            Trace.traceBegin(32, "showSystemReadyErrorDialogs");
        L5:
            boolean isBuildConsistent = Build.isBuildConsistent();
            WindowManagerGlobalLock r3 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r3);
        L11:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L8:
            if (AppGlobals.getPackageManager().hasSystemUidErrors() == false) goto L16;
            Slog.e("ActivityTaskManager", "UIDs on the system are inconsistent, you need to wipe your data partition or your device will be unstable.");     // Catch: Throwable -> L11 RemoteException -> L13
            this.this$0.mUiHandler.post(new ActivityTaskManagerService$LocalService$$ExternalSyntheticLambda2(this));     // Catch: Throwable -> L11 RemoteException -> L13
        L16:
            if (isBuildConsistent == true) goto L18;
            Slog.e("ActivityTaskManager", "Build fingerprint is not consistent, warning user");     // Catch: Throwable -> L11
            this.this$0.mUiHandler.post(new ActivityTaskManagerService$LocalService$$ExternalSyntheticLambda3(this));     // Catch: Throwable -> L11
        L18:
            monitor-exit(r3);     // Catch: Throwable -> L11
            WindowManagerService.resetPriorityAfterLockedSection();
            Trace.traceEnd(32);
        }

        private /* synthetic */ void lambda$showSystemReadyErrorDialogsIfNeeded$0() {
            if (ActivityTaskManagerService.m9663$$Nest$fgetmShowDialogs(this.this$0) == false) goto L6;
            AlertDialog d = new BaseErrorDialog(ActivityTaskManagerService.m9665$$Nest$fgetmUiContext(this.this$0));
            d.getWindow().setType(2010);
            d.setCancelable(false);
            d.setTitle(ActivityTaskManagerService.m9665$$Nest$fgetmUiContext(this.this$0).getText(R.string.app_running_notification_text));
            d.setMessage(ActivityTaskManagerService.m9665$$Nest$fgetmUiContext(this.this$0).getText(17042211));
            d.setButton(-1, ActivityTaskManagerService.m9665$$Nest$fgetmUiContext(this.this$0).getText(R.string.ok), this.this$0.mUiHandler.obtainMessage(1, d));
            d.show();
            return;
        }

        private /* synthetic */ void lambda$showSystemReadyErrorDialogsIfNeeded$1() {
            if (ActivityTaskManagerService.m9663$$Nest$fgetmShowDialogs(this.this$0) == false) goto L6;
            AlertDialog d = new BaseErrorDialog(ActivityTaskManagerService.m9665$$Nest$fgetmUiContext(this.this$0));
            d.getWindow().setType(2010);
            d.setCancelable(false);
            d.setTitle(ActivityTaskManagerService.m9665$$Nest$fgetmUiContext(this.this$0).getText(R.string.app_running_notification_text));
            d.setMessage(ActivityTaskManagerService.m9665$$Nest$fgetmUiContext(this.this$0).getText(17042210));
            d.setButton(-1, ActivityTaskManagerService.m9665$$Nest$fgetmUiContext(this.this$0).getText(R.string.ok), this.this$0.mUiHandler.obtainMessage(1, d));
            d.show();
            return;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void onProcessMapped(int pid, WindowProcessController proc) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mProcessMap.put(pid, proc);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void onProcessUnMapped(int pid) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mProcessMap.remove(pid);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void onPackageDataCleared(String name, int userId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mCompatModePackages.handlePackageDataClearedLocked(name);     // Catch: Throwable -> L8
            this.this$0.mAppWarnings.onPackageDataCleared(name, userId);     // Catch: Throwable -> L8
            this.this$0.mPackageConfigPersister.onPackageDataCleared(name, userId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void onPackageUninstalled(String name, int userId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mAppWarnings.onPackageUninstalled(name, userId);     // Catch: Throwable -> L8
            this.this$0.mCompatModePackages.handlePackageUninstalledLocked(name);     // Catch: Throwable -> L8
            this.this$0.mPackageConfigPersister.onPackageUninstall(name, userId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            ActivityTaskManagerService.m9666$$Nest$fgetmWindowStyleCache(this.this$0).invalidatePackage(name);
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void onPackageAdded(String name, boolean replacing) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mCompatModePackages.handlePackageAddedLocked(name, replacing);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void onPackageReplaced(ApplicationInfo aInfo) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L9:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (this.this$0.mRootWindowContainer != null) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L11:
            this.this$0.mRootWindowContainer.updateActivityApplicationInfo(aInfo);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            ActivityTaskManagerService.m9666$$Nest$fgetmWindowStyleCache(this.this$0).invalidatePackage(aInfo.packageName);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void sendActivityResult(int callingUid, IBinder activityToken, String resultWho, int requestCode, int resultCode, Intent data) {
            WindowManagerGlobalLock r1 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r1);
            ActivityRecord r = ActivityRecord.isInRootTaskLocked(activityToken);     // Catch: Throwable -> L20
            if (r == null) goto L22;
            if (r.getRootTask() == null) goto L22;
            monitor-exit(r1);     // Catch: Throwable -> L20
            WindowManagerService.resetPriorityAfterLockedSection();
            NeededUriGrants dataGrants = this.this$0.collectGrants(data, r);
            WindowManagerGlobalLock r10 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r10);
            r.sendResult(callingUid, resultWho, requestCode, resultCode, data, new Binder(), dataGrants);     // Catch: Throwable -> L16
            monitor-exit(r10);     // Catch: Throwable -> L16
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L16:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L22:
            monitor-exit(r1);     // Catch: Throwable -> L20
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L20:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void clearPendingResultForActivity(IBinder activityToken, WeakReference<PendingIntentRecord> pir) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            ActivityRecord r = ActivityRecord.isInRootTaskLocked(activityToken);     // Catch: Throwable -> L9
            if (r != null) goto L7;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L7:
            if (r.pendingResults == null) goto L11;
            r.pendingResults.remove(pir);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public ComponentName getActivityName(IBinder activityToken) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            ActivityRecord r = ActivityRecord.isInRootTaskLocked(activityToken);     // Catch: Throwable -> L7
            if (r == null) goto L9;
            ComponentName r2 = r.intent.getComponent();     // Catch: Throwable -> L7
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L9:
            r2 = null;
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public ActivityTaskManagerInternal.ActivityTokens getAttachedNonFinishingActivityForTask(int taskId, IBinder token) {
            WindowManagerGlobalLock r8 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r8);
            Task task = this.this$0.mRootWindowContainer.anyTaskForId(taskId, 0);     // Catch: Throwable -> L10
            if (task != null) goto L12;
            Slog.w("ActivityTaskManager", "getApplicationThreadForTopActivity failed: Requested task not found");     // Catch: Throwable -> L10
            monitor-exit(r8);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return null;
        L12:
            final List<ActivityRecord> list = new ArrayList();     // Catch: Throwable -> L10
            task.forAllActivities(new ActivityTaskManagerService$LocalService$$ExternalSyntheticLambda0(list));     // Catch: Throwable -> L10
            if (list.size() > 0) goto L17;
            monitor-exit(r8);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return null;
        L17:
            if (token == null) goto L19;
        L24:
            int i = 0;
        L26:
            if (i >= list.size()) goto L37;
            ActivityRecord record = list.get(i);     // Catch: Throwable -> L10
            if (record.shareableActivityToken != token) goto L35;
            if (record.attachedToProcess() == false) goto L35;
            ActivityTaskManagerInternal.ActivityTokens r0 = new ActivityTaskManagerInternal.ActivityTokens(this, record.token, record.assistToken, record.app.getThread(), record.shareableActivityToken, record.getUid());     // Catch: Throwable -> L10
            monitor-exit(r8);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return r0;
        L35:
            i = i + 1;
            goto L26
        L37:
            monitor-exit(r8);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return null;
        L19:
            if (list.get(0).attachedToProcess() == false) goto L24;
            ActivityRecord topRecord = list.get(0);     // Catch: Throwable -> L10
            ActivityTaskManagerInternal.ActivityTokens r1 = new ActivityTaskManagerInternal.ActivityTokens(this, topRecord.token, topRecord.assistToken, topRecord.app.getThread(), topRecord.shareableActivityToken, topRecord.getUid());     // Catch: Throwable -> L10
            monitor-exit(r8);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        private static /* synthetic */ void lambda$getAttachedNonFinishingActivityForTask$2(List list, ActivityRecord r) {
            if (r.finishing == true) goto L6;
            list.add(r);
            return;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public IIntentSender getIntentSender(int type, String packageName, String featureId, int callingUid, int userId, IBinder token, String resultWho, int requestCode, Intent[] intents, String[] resolvedTypes, int flags, Bundle bOptions) {
            WindowManagerGlobalLock r2 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r2);
            IIntentSender r0 = this.this$0.getIntentSenderLocked(type, packageName, featureId, callingUid, userId, token, resultWho, requestCode, intents, resolvedTypes, flags, bOptions);     // Catch: Throwable -> L8
            monitor-exit(r2);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return r0;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public ActivityServiceConnectionsHolder getServiceConnectionsHolder(IBinder token) {
            ActivityRecord r = ActivityRecord.forToken(token);
            if (r != null) goto L5;
            return null;
        L5:
            if (r.inHistory == true) goto L8;
            return null;
        L8:
            return r.getOrCreateServiceConnectionsHolder();
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public Intent getHomeIntent() {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            Intent r1 = this.this$0.getHomeIntent();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean startHomeActivity(int userId, String reason) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            boolean r1 = this.this$0.mRootWindowContainer.startHomeOnDisplay(userId, reason, 0);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean startHomeOnDisplay(int userId, String reason, int displayId, boolean allowInstrumenting, boolean fromHomeKey) {
            WindowManagerGlobalLock r1 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r1);
            boolean r9 = this.this$0.mRootWindowContainer.startHomeOnDisplay(userId, reason, displayId, allowInstrumenting, fromHomeKey);     // Catch: Throwable -> L10
            monitor-exit(r1);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return r9;
        L10:
            th = move-exception;
            Throwable r10 = th;
        L14:
            monitor-exit(r1);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            throw r10;
        L12:
            th = move-exception;
            r10 = th;
            goto L14
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean startHomeOnAllDisplays(int userId, String reason) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            boolean r1 = this.this$0.mRootWindowContainer.startHomeOnAllDisplays(userId, reason);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void updateTopComponentForFactoryTest() {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L9:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (this.this$0.mFactoryTest == 1) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L11:
            ResolveInfo ri = this.this$0.mContext.getPackageManager().resolveActivity(new Intent("android.intent.action.FACTORY_TEST"), 1024);     // Catch: Throwable -> L9
            if (ri == null) goto L18;
            ActivityInfo ai = ri.activityInfo;     // Catch: Throwable -> L9
            ApplicationInfo app = ai.applicationInfo;     // Catch: Throwable -> L9
            if ((1 & app.flags) == 0) goto L16;
            this.this$0.mTopAction = "android.intent.action.FACTORY_TEST";     // Catch: Throwable -> L9
            this.this$0.mTopData = null;     // Catch: Throwable -> L9
            ActivityTaskManagerService r2 = this.this$0;     // Catch: Throwable -> L9
            r2.mTopComponent = new ComponentName(app.packageName, ai.name);     // Catch: Throwable -> L9
            final CharSequence errorMsg = null;
        L19:
            if (errorMsg != null) goto L23;
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L23:
            this.this$0.mTopAction = null;     // Catch: Throwable -> L9
            this.this$0.mTopData = null;     // Catch: Throwable -> L9
            this.this$0.mTopComponent = null;     // Catch: Throwable -> L9
            this.this$0.mUiHandler.post(new ActivityTaskManagerService$LocalService$$ExternalSyntheticLambda4(this, errorMsg));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L16:
            errorMsg = this.this$0.mContext.getResources().getText(R.string.global_action_bug_report);     // Catch: Throwable -> L9
            goto L19
        L18:
            errorMsg = this.this$0.mContext.getResources().getText(R.string.global_action_assist);     // Catch: Throwable -> L9
            goto L19
        }

        private /* synthetic */ void lambda$updateTopComponentForFactoryTest$3(CharSequence errorMsg) {
            Dialog d = new FactoryErrorDialog(ActivityTaskManagerService.m9665$$Nest$fgetmUiContext(this.this$0), errorMsg);
            d.show();
            this.this$0.mAmInternal.ensureBootCompleted();
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void handleAppDied(WindowProcessController wpc, boolean restarting, Runnable finishInstrumentationCallback) {
            Object r0 = this.this$0.mGlobalLockWithoutBoost;
            monitor-enter(r0);
            this.this$0.mTaskSupervisor.beginDeferResume();     // Catch: Throwable -> L12
            boolean hasVisibleActivities = wpc.handleAppDied();     // Catch: Throwable -> L22
            this.this$0.mTaskSupervisor.endDeferResume();     // Catch: Throwable -> L12
            if (restarting == true) goto L17;
            if (hasVisibleActivities == false) goto L17;
            this.this$0.deferWindowLayout();     // Catch: Throwable -> L12
            this.this$0.mRootWindowContainer.ensureVisibilityOnVisibleActivityDiedOrCrashed("handleAppDied");     // Catch: Throwable -> L14
            this.this$0.continueWindowLayout();     // Catch: Throwable -> L12
            goto L17
        L14:
            th = move-exception;
            this.this$0.continueWindowLayout();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L12
            if (wpc.isInstrumenting() == false) goto L32;
            finishInstrumentationCallback.run();
            return;
        L32:
            return;
        L22:
            th = move-exception;
            this.this$0.mTaskSupervisor.endDeferResume();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void closeSystemDialogs(String reason) {
            ActivityTaskManagerService.enforceNotIsolatedCaller("closeSystemDialogs");
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            if (checkCanCloseSystemDialogs(pid, uid, null) == true) goto L5;
            return;
        L5:
            long origId = Binder.clearCallingIdentity();
            WindowManagerGlobalLock r4 = this.this$0.mGlobalLock;     // Catch: Throwable -> L23
            WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L23
            monitor-enter(r4);     // Catch: Throwable -> L23
            if (uid >= 10000) goto L30;
        L18:
            this.this$0.mWindowManager.closeSystemDialogs(reason);     // Catch: Throwable -> L16
            this.this$0.mRootWindowContainer.closeSystemDialogActivities(reason);     // Catch: Throwable -> L16
            monitor-exit(r4);     // Catch: Throwable -> L16
            WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L23
            this.this$0.mAmInternal.broadcastCloseSystemDialogs(reason);     // Catch: Throwable -> L23
            Binder.restoreCallingIdentity(origId);
            return;
        L30:
            WindowProcessController proc = this.this$0.mProcessMap.getProcess(pid);     // Catch: Throwable -> L16
            if (proc.isPerceptible() == true) goto L18;
            Slog.w("ActivityTaskManager", "Ignoring closeSystemDialogs " + reason + " from background process " + proc);     // Catch: Throwable -> L16
            monitor-exit(r4);     // Catch: Throwable -> L16
            WindowManagerService.resetPriorityAfterLockedSection();
            Binder.restoreCallingIdentity(origId);
            return;
        L16:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L23
            throw th;     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            Binder.restoreCallingIdentity(origId);
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void cleanupDisabledPackageComponents(String packageName, Set<String> disabledClasses, int userId, boolean booted) {
            WindowManagerGlobalLock r1 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r1);
        L17:
            th = th;
        L25:
            monitor-exit(r1);     // Catch: Throwable -> L17
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L23:
            th = th;
            goto L25
        L5:
            if (this.this$0.mRootWindowContainer == null) goto L28;
            if (this.this$0.mRootWindowContainer.finishDisabledPackageActivities(packageName, disabledClasses, true, false, userId, false) == false) goto L19;
            if (booted == false) goto L19;
            this.this$0.mRootWindowContainer.resumeFocusedTasksTopActivities();     // Catch: Throwable -> L17
            this.this$0.mTaskSupervisor.scheduleIdle();     // Catch: Throwable -> L17
        L19:
            this.this$0.getRecentTasks().cleanupDisabledPackageTasksLocked(packageName, disabledClasses, userId);     // Catch: Throwable -> L17
            monitor-exit(r1);     // Catch: Throwable -> L17
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L28:
            monitor-exit(r1);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L9:
            th = th;
            goto L25
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean onForceStopPackage(String packageName, boolean doit, boolean evenPersistent, int userId) {
            WindowManagerGlobalLock r1 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r1);
        L17:
            th = th;
        L21:
            monitor-exit(r1);     // Catch: Throwable -> L17
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L19:
            th = th;
            goto L21
        L5:
            if (this.this$0.mRootWindowContainer == null) goto L24;
            boolean r10 = this.this$0.mRootWindowContainer.finishDisabledPackageActivities(packageName, null, doit, evenPersistent, userId, true);     // Catch: Throwable -> L17
            monitor-exit(r1);     // Catch: Throwable -> L17
            WindowManagerService.resetPriorityAfterLockedSection();
            return r10;
        L24:
            monitor-exit(r1);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return false;
        L9:
            th = th;
            goto L21
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void resumeTopActivities(boolean scheduleIdle) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mRootWindowContainer.resumeFocusedTasksTopActivities();     // Catch: Throwable -> L7
            if (scheduleIdle == false) goto L9;
            this.this$0.mTaskSupervisor.scheduleIdle();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public ActivityTaskManagerInternal.PreBindInfo preBindApplication(WindowProcessController wpc, ApplicationInfo info) {
            Object r0 = this.this$0.mGlobalLockWithoutBoost;
            monitor-enter(r0);
            this.this$0.mTaskSupervisor.getActivityMetricsLogger().notifyBindApplication(wpc.mInfo);     // Catch: Throwable -> L11
            this.this$0.getExt().preBindApplication(wpc.mInfo);     // Catch: Throwable -> L11
            wpc.onConfigurationChanged(this.this$0.getGlobalConfiguration());     // Catch: Throwable -> L11
            int i = this.this$0.mStartingProcessActivities.size() - 1;     // Catch: Throwable -> L11
        L5:
            if (i < 0) goto L15;
            ActivityRecord r = this.this$0.mStartingProcessActivities.get(i);     // Catch: Throwable -> L11
            if (wpc.mUid != r.info.applicationInfo.uid) goto L13;
            if (wpc.mName.equals(r.processName) == false) goto L13;
            wpc.registerActivityConfigurationListener(r);     // Catch: Throwable -> L11
        L13:
            i = i - 1;     // Catch: Throwable -> L11
        L15:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L17;
            String protoLogParam0 = String.valueOf(wpc.mName);     // Catch: Throwable -> L11
            String protoLogParam1 = String.valueOf(wpc.getConfiguration());     // Catch: Throwable -> L11
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, 8997932224368818278L, 0, new Object[]{protoLogParam0, protoLogParam1});     // Catch: Throwable -> L11
        L17:
            ActivityTaskManagerInternal.PreBindInfo r1 = new ActivityTaskManagerInternal.PreBindInfo(this.this$0.compatibilityInfoForPackageLocked(info), new Configuration(wpc.getConfiguration()));     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean attachApplication(WindowProcessController wpc) throws RemoteException {
            Object r0 = this.this$0.mGlobalLockWithoutBoost;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L6:
            if (Trace.isTagEnabled(32) == false) goto L20;
            Trace.traceBegin(32, "attachApplication:" + wpc.mName);     // Catch: Throwable -> L9
        L20:
            boolean r3 = this.this$0.mRootWindowContainer.attachApplication(wpc);     // Catch: Throwable -> L15
            Trace.traceEnd(32);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r3;
        L15:
            th = move-exception;
            Trace.traceEnd(32);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void notifyLockedProfile(int userId) {
        L26:
            ex = move-exception;
            throw new SecurityException("Fail to check is caller a privileged app", ex);
        L3:
            if (AppGlobals.getPackageManager().isUidPrivileged(Binder.getCallingUid()) == false) goto L25;
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L17
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L17
            throw th;     // Catch: Throwable -> L17
        L8:
            if (this.this$0.mAmInternal.shouldConfirmCredentials(userId) == false) goto L13;
            ActivityTaskManagerService.m9676$$Nest$mmaybeHideLockedProfileActivityLocked(this.this$0);     // Catch: Throwable -> L11
            this.this$0.mRootWindowContainer.lockAllProfileTasks(userId);     // Catch: Throwable -> L11
        L13:
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L17
            monitor-exit(r0);     // Catch: Throwable -> L17
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L17:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L25:
            throw new SecurityException("Only privileged app can call notifyLockedProfile");     // Catch: RemoteException -> L26
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void startConfirmDeviceCredentialIntent(Intent intent, Bundle options) {
            ActivityTaskManagerService.enforceTaskPermission("startConfirmDeviceCredentialIntent");
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L17
            intent.addFlags(276824064);     // Catch: Throwable -> L9
            if (options == null) goto L11;
            ActivityOptions activityOptions = new ActivityOptions(options);     // Catch: Throwable -> L9
        L12:
            this.this$0.mContext.startActivityAsUser(intent, activityOptions.toBundle(), UserHandle.CURRENT);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L17
            monitor-exit(r0);     // Catch: Throwable -> L17
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L11:
            activityOptions = ActivityOptions.makeBasic();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L17
            throw th;     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void writeActivitiesToProto(ProtoOutputStream proto) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mRootWindowContainer.dumpDebug(proto, 1146756268034L, 0);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void dump(String cmd, FileDescriptor fd, PrintWriter pw, String[] args, int opti, boolean dumpAll, boolean dumpClient, String dumpPackage, int displayIdFilter) {
            WindowManagerGlobalLock r9 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r9);
        L13:
            th = th;
        L61:
            monitor-exit(r9);     // Catch: Throwable -> L13
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (ActivityTaskManagerService.DUMP_ACTIVITIES_CMD.equals(cmd) == true) goto L57;
        L54:
            th = th;
            goto L61
        L7:
            if (ActivityTaskManagerService.DUMP_ACTIVITIES_SHORT_CMD.equals(cmd) == true) goto L57;
            if (ActivityTaskManagerService.DUMP_LASTANR_CMD.equals(cmd) == false) goto L16;
            this.this$0.dumpLastANRLocked(pw);     // Catch: Throwable -> L13
        L58:
            monitor-exit(r9);     // Catch: Throwable -> L13
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L16:
            if (ActivityTaskManagerService.DUMP_LASTANR_TRACES_CMD.equals(cmd) == false) goto L20;
            this.this$0.dumpLastANRTracesLocked(pw);     // Catch: Throwable -> L13
            goto L58
        L20:
            if (ActivityTaskManagerService.DUMP_STARTER_CMD.equals(cmd) == false) goto L24;
            this.this$0.dumpActivityStarterLocked(pw, dumpPackage);     // Catch: Throwable -> L13
            goto L58
        L24:
            if (ActivityTaskManagerService.DUMP_CONTAINERS_CMD.equals(cmd) == false) goto L27;
            this.this$0.dumpActivityContainersLocked(pw);     // Catch: Throwable -> L13
            goto L58
        L27:
            if (ActivityTaskManagerService.DUMP_RECENTS_CMD.equals(cmd) == true) goto L65;
        L42:
            th = th;
            goto L61
        L30:
            if (ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD.equals(cmd) == true) goto L65;
            if (ActivityTaskManagerService.DUMP_TOP_RESUMED_ACTIVITY.equals(cmd) == false) goto L37;
            this.this$0.dumpTopResumedActivityLocked(pw);     // Catch: Throwable -> L13
            goto L58
        L37:
            if ("visible".equals(cmd) == false) goto L58;
            this.this$0.dumpVisibleActivitiesLocked(pw, displayIdFilter);     // Catch: Throwable -> L13
        L65:
        L51:
            th = th;
            goto L61
        L47:
            if (this.this$0.getRecentTasks() == null) goto L58;
            this.this$0.getRecentTasks().dump(pw, dumpAll, dumpPackage);     // Catch: Throwable -> L13
        L57:
            this.this$0.dumpActivitiesLocked(fd, pw, args, opti, dumpAll, dumpClient, dumpPackage, displayIdFilter);     // Catch: Throwable -> L13
            goto L58
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean dumpForProcesses(FileDescriptor fd, PrintWriter pw, boolean dumpAll, String dumpPackage, int dumpAppId, boolean needSep, boolean testPssMode, int wakefulness) {
            WindowManagerGlobalLock r1 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r1);
            if (this.this$0.mHomeProcess == null) goto L19;
            if (dumpPackage != null) goto L112;
        L12:
            if (needSep == false) goto L15;
            pw.println();     // Catch: Throwable -> L10
            boolean needSep2 = false;
        L107:
            pw.println("  mHomeProcess: " + this.this$0.mHomeProcess);     // Catch: Throwable -> L17
        L21:
            if (this.this$0.mPreviousProcess == null) goto L28;
            if (dumpPackage != null) goto L24;
        L25:
            if (needSep2 == false) goto L27;
            pw.println();     // Catch: Throwable -> L17
            needSep2 = false;
        L27:
            pw.println("  mPreviousProcess: " + this.this$0.mPreviousProcess);     // Catch: Throwable -> L17
            goto L28
        L24:
            if (this.this$0.mPreviousProcess.containsPackage(dumpPackage) == true) goto L25;
        L28:
            if (dumpAll == false) goto L36;
            if (this.this$0.mPreviousProcess == null) goto L34;
            if (dumpPackage == null) goto L34;
            if (this.this$0.mPreviousProcess.containsPackage(dumpPackage) == false) goto L36;
        L34:
            StringBuilder sb = new StringBuilder(128);     // Catch: Throwable -> L17
            sb.append("  mPreviousProcessVisibleTime: ");     // Catch: Throwable -> L17
            TimeUtils.formatDuration(ActivityTaskManagerService.m9660$$Nest$fgetmPreviousProcessVisibleTime(this.this$0), sb);     // Catch: Throwable -> L17
            pw.println(sb);     // Catch: Throwable -> L17
        L36:
            if (this.this$0.mHeavyWeightProcess == null) goto L43;
            if (dumpPackage != null) goto L39;
        L40:
            if (needSep2 == false) goto L42;
            pw.println();     // Catch: Throwable -> L17
            needSep2 = false;
        L42:
            pw.println("  mHeavyWeightProcess: " + this.this$0.mHeavyWeightProcess);     // Catch: Throwable -> L17
            goto L43
        L39:
            if (this.this$0.mHeavyWeightProcess.containsPackage(dumpPackage) == true) goto L40;
        L43:
            if (dumpPackage != null) goto L45;
            pw.println("  mGlobalConfiguration: " + this.this$0.getGlobalConfiguration());     // Catch: Throwable -> L17
            this.this$0.mRootWindowContainer.dumpDisplayConfigs(pw, "  ");     // Catch: Throwable -> L17
        L45:
            if (dumpAll == false) goto L63;
            Task topFocusedRootTask = this.this$0.getTopDisplayFocusedRootTask();     // Catch: Throwable -> L17
            if (dumpPackage != null) goto L51;
            if (topFocusedRootTask == null) goto L51;
            pw.println("  mConfigWillChange: " + topFocusedRootTask.mConfigWillChange);     // Catch: Throwable -> L17
        L51:
            if (this.this$0.mCompatModePackages.getPackages().size() <= 0) goto L63;
            boolean printed = false;
            Iterator<Map.Entry<String, Integer>> r4 = this.this$0.mCompatModePackages.getPackages().entrySet().iterator();     // Catch: Throwable -> L17
        L54:
            if (r4.hasNext() == false) goto L63;
            Map.Entry<String, Integer> entry = r4.next();     // Catch: Throwable -> L17
            String pkg = entry.getKey();     // Catch: Throwable -> L17
            int mode = entry.getValue().intValue();     // Catch: Throwable -> L17
            if (dumpPackage == null) goto L60;
            if (dumpPackage.equals(pkg) == false) goto L54;
        L60:
            if (printed == true) goto L62;
            pw.println("  mScreenCompatPackages:");     // Catch: Throwable -> L17
            printed = true;
        L62:
            pw.println("    " + pkg + ": " + mode);     // Catch: Throwable -> L17
        L63:
            if (dumpPackage != null) goto L74;
            pw.println("  mWakefulness=" + PowerManagerInternal.wakefulnessToString(wakefulness));     // Catch: Throwable -> L17
            pw.println("  mSleepTokens=" + this.this$0.mRootWindowContainer.mSleepTokens);     // Catch: Throwable -> L17
            if (this.this$0.mRunningVoice == null) goto L67;
            pw.println("  mRunningVoice=" + this.this$0.mRunningVoice);     // Catch: Throwable -> L17
            pw.println("  mVoiceWakeLock" + this.this$0.mVoiceWakeLock);     // Catch: Throwable -> L17
        L67:
            pw.println("  mSleeping=" + ActivityTaskManagerService.m9664$$Nest$fgetmSleeping(this.this$0));     // Catch: Throwable -> L17
            StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L17
            r0.append("  mShuttingDown=");     // Catch: Throwable -> L17
            r0.append(this.this$0.mShuttingDown);     // Catch: Throwable -> L17
            r0.append(" mTestPssMode=");     // Catch: Throwable -> L17
            r0.append(testPssMode);     // Catch: Throwable -> L70
            pw.println(r0.toString());     // Catch: Throwable -> L70
            pw.println("  mVrController=" + this.this$0.mVrController);     // Catch: Throwable -> L70
        L74:
            if (this.this$0.mCurAppTimeTracker == null) goto L77;
            this.this$0.mCurAppTimeTracker.dumpWithHeader(pw, "  ", true);     // Catch: Throwable -> L70
        L77:
            if (this.this$0.mAllowAppSwitchUids.size() <= 0) goto L94;
            boolean printed2 = false;
            int i = 0;
        L80:
            if (i >= this.this$0.mAllowAppSwitchUids.size()) goto L94;
            ArrayMap<String, Integer> types = this.this$0.mAllowAppSwitchUids.valueAt(i);     // Catch: Throwable -> L70
            int j = 0;
        L83:
            if (j >= types.size()) goto L93;
            if (dumpPackage != null) goto L86;
        L87:
            if (needSep2 == false) goto L89;
            pw.println();     // Catch: Throwable -> L70
            needSep2 = false;
        L89:
            if (printed2 == true) goto L91;
            pw.println("  mAllowAppSwitchUids:");     // Catch: Throwable -> L70
            printed2 = true;
        L91:
            pw.print("    User ");     // Catch: Throwable -> L70
            pw.print(this.this$0.mAllowAppSwitchUids.keyAt(i));     // Catch: Throwable -> L70
            pw.print(": Type ");     // Catch: Throwable -> L70
            pw.print(types.keyAt(j));     // Catch: Throwable -> L70
            pw.print(" = ");     // Catch: Throwable -> L70
            UserHandle.formatUid(pw, types.valueAt(j).intValue());     // Catch: Throwable -> L70
            pw.println();     // Catch: Throwable -> L70
        L92:
            j = j + 1;     // Catch: Throwable -> L70
            goto L83
        L86:
            if (UserHandle.getAppId(types.valueAt(j).intValue()) != dumpAppId) goto L92;
        L93:
            i = i + 1;     // Catch: Throwable -> L70
        L94:
            if (dumpPackage == null) goto L96;
        L99:
            monitor-exit(r1);     // Catch: Throwable -> L70
            WindowManagerService.resetPriorityAfterLockedSection();
            return needSep2;
        L96:
            if (this.this$0.mController == null) goto L98;
            pw.println("  mController=" + this.this$0.mController + " mControllerIsAMonkey=" + this.this$0.mControllerIsAMonkey);     // Catch: Throwable -> L70
        L98:
            pw.println("  mGoingToSleepWakeLock=" + this.this$0.mTaskSupervisor.mGoingToSleepWakeLock);     // Catch: Throwable -> L70
            pw.println("  mLaunchingActivityWakeLock=" + this.this$0.mTaskSupervisor.mLaunchingActivityWakeLock);     // Catch: Throwable -> L70
        L17:
            th = th;
        L104:
            monitor-exit(r1);     // Catch: Throwable -> L70
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L10:
            th = th;
            goto L104
        L15:
            needSep2 = needSep;
            goto L107
        L112:
            if (this.this$0.mHomeProcess.containsPackage(dumpPackage) == true) goto L12;
        L19:
            needSep2 = needSep;
        L102:
            th = th;
        L70:
            th = th;
            goto L104
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void writeProcessesToProto(ProtoOutputStream proto, String dumpPackage, int wakeFullness, boolean testPssMode) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            if (dumpPackage != null) goto L19;
            this.this$0.getGlobalConfiguration().dumpDebug(proto, 1146756268051L);     // Catch: Throwable -> L9
            Task topFocusedRootTask = this.this$0.getTopDisplayFocusedRootTask();     // Catch: Throwable -> L9
            if (topFocusedRootTask == null) goto L11;
            proto.write(1133871366165L, topFocusedRootTask.mConfigWillChange);     // Catch: Throwable -> L9
        L11:
            ActivityTaskManagerService.m9686$$Nest$mwriteSleepStateToProto(this.this$0, proto, wakeFullness, testPssMode);     // Catch: Throwable -> L9
            if (this.this$0.mRunningVoice == null) goto L14;
            long vrToken = proto.start(1146756268060L);     // Catch: Throwable -> L9
            proto.write(1138166333441L, this.this$0.mRunningVoice.toString());     // Catch: Throwable -> L9
            this.this$0.mVoiceWakeLock.dumpDebug(proto, 1146756268034L);     // Catch: Throwable -> L9
            proto.end(vrToken);     // Catch: Throwable -> L9
        L14:
            this.this$0.mVrController.dumpDebug(proto, 1146756268061L);     // Catch: Throwable -> L9
            if (this.this$0.mController == null) goto L17;
            long token = proto.start(1146756268069L);     // Catch: Throwable -> L9
            proto.write(1138166333441L, this.this$0.mController.toString());     // Catch: Throwable -> L9
            proto.write(1133871366146L, this.this$0.mControllerIsAMonkey);     // Catch: Throwable -> L9
            proto.end(token);     // Catch: Throwable -> L9
        L17:
            this.this$0.mTaskSupervisor.mGoingToSleepWakeLock.dumpDebug(proto, 1146756268079L);     // Catch: Throwable -> L9
            this.this$0.mTaskSupervisor.mLaunchingActivityWakeLock.dumpDebug(proto, 1146756268080L);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L19:
            if (this.this$0.mHomeProcess == null) goto L25;
            if (dumpPackage != null) goto L22;
        L23:
            this.this$0.mHomeProcess.dumpDebug(proto, 1146756268047L);     // Catch: Throwable -> L9
            goto L25
        L22:
            if (this.this$0.mHomeProcess.containsPackage(dumpPackage) == true) goto L23;
        L25:
            if (this.this$0.mPreviousProcess == null) goto L31;
            if (dumpPackage != null) goto L28;
        L29:
            this.this$0.mPreviousProcess.dumpDebug(proto, 1146756268048L);     // Catch: Throwable -> L9
            proto.write(1112396529681L, ActivityTaskManagerService.m9660$$Nest$fgetmPreviousProcessVisibleTime(this.this$0));     // Catch: Throwable -> L9
            goto L31
        L28:
            if (this.this$0.mPreviousProcess.containsPackage(dumpPackage) == true) goto L29;
        L31:
            if (this.this$0.mHeavyWeightProcess == null) goto L36;
            if (dumpPackage != null) goto L34;
        L35:
            this.this$0.mHeavyWeightProcess.dumpDebug(proto, 1146756268050L);     // Catch: Throwable -> L9
            goto L36
        L34:
            if (this.this$0.mHeavyWeightProcess.containsPackage(dumpPackage) == true) goto L35;
        L36:
            Iterator<Map.Entry<String, Integer>> r3 = this.this$0.mCompatModePackages.getPackages().entrySet().iterator();     // Catch: Throwable -> L9
        L38:
            if (r3.hasNext() == false) goto L46;
            Map.Entry<String, Integer> entry = r3.next();     // Catch: Throwable -> L9
            String pkg = entry.getKey();     // Catch: Throwable -> L9
            int mode = entry.getValue().intValue();     // Catch: Throwable -> L9
            if (dumpPackage != null) goto L42;
        L43:
            long compatToken = proto.start(2246267895830L);     // Catch: Throwable -> L9
            proto.write(1138166333441L, pkg);     // Catch: Throwable -> L9
            proto.write(1120986464258L, mode);     // Catch: Throwable -> L9
            proto.end(compatToken);     // Catch: Throwable -> L9
            goto L38
        L42:
            if (dumpPackage.equals(pkg) == false) goto L38;
        L46:
            if (this.this$0.mCurAppTimeTracker == null) goto L48;
            this.this$0.mCurAppTimeTracker.dumpDebug(proto, 1146756268063L, true);     // Catch: Throwable -> L9
        L48:
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean dumpActivity(FileDescriptor fd, PrintWriter pw, String name, String[] args, int opti, boolean dumpAll, boolean dumpVisibleRootTasksOnly, boolean dumpFocusedRootTaskOnly, int displayIdFilter, int userId) {
            return this.this$0.dumpActivity(fd, pw, name, args, opti, dumpAll, dumpVisibleRootTasksOnly, dumpFocusedRootTaskOnly, displayIdFilter, userId, 5000);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void dumpForOom(PrintWriter pw) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            pw.println("  mHomeProcess: " + this.this$0.mHomeProcess);     // Catch: Throwable -> L7
            pw.println("  mPreviousProcess: " + this.this$0.mPreviousProcess);     // Catch: Throwable -> L7
            if (this.this$0.mHeavyWeightProcess == null) goto L9;
            pw.println("  mHeavyWeightProcess: " + this.this$0.mHeavyWeightProcess);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean canGcNow() {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (isSleeping() == true) goto L12;
            if (this.this$0.mRootWindowContainer.allResumedActivitiesIdle() == true) goto L12;
            boolean r1 = false;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L12:
            r1 = true;
            goto L13
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public WindowProcessController getTopApp() {
            return this.this$0.mTopApp;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void scheduleDestroyAllActivities(String reason) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mRootWindowContainer.scheduleDestroyAllActivities(reason);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void removeUser(int userId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mRootWindowContainer.removeUser(userId);     // Catch: Throwable -> L8
            this.this$0.mPackageConfigPersister.removeUser(userId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean switchUser(int userId, UserState userState) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            boolean r1 = this.this$0.mRootWindowContainer.switchUser(userId, userState);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void onHandleAppCrash(WindowProcessController wpc) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mTaskSupervisor.beginDeferResume();     // Catch: Throwable -> L11
            boolean hasVisibleActivity = wpc.handleAppCrash();     // Catch: Throwable -> L19
            this.this$0.mTaskSupervisor.endDeferResume();     // Catch: Throwable -> L11
            if (hasVisibleActivity == false) goto L16;
            this.this$0.deferWindowLayout();     // Catch: Throwable -> L11
            this.this$0.mRootWindowContainer.ensureVisibilityOnVisibleActivityDiedOrCrashed("onHandleAppCrash");     // Catch: Throwable -> L13
            this.this$0.continueWindowLayout();     // Catch: Throwable -> L11
            goto L16
        L13:
            th = move-exception;
            this.this$0.continueWindowLayout();     // Catch: Throwable -> L11
            throw th;     // Catch: Throwable -> L11
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L11
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L19:
            th = move-exception;
            this.this$0.mTaskSupervisor.endDeferResume();     // Catch: Throwable -> L11
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public int finishTopCrashedActivities(WindowProcessController crashedApp, String reason) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.deferWindowLayout();     // Catch: Throwable -> L12
            Task finishedTask = this.this$0.mRootWindowContainer.finishTopCrashedActivities(crashedApp, reason);     // Catch: Throwable -> L14
            if (finishedTask == null) goto L17;
            this.this$0.mRootWindowContainer.ensureVisibilityOnVisibleActivityDiedOrCrashed(reason);     // Catch: Throwable -> L14
            int r2 = finishedTask.mTaskId;     // Catch: Throwable -> L14
            this.this$0.continueWindowLayout();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L17:
            this.this$0.continueWindowLayout();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();
            return -1;
        L14:
            th = move-exception;
            this.this$0.continueWindowLayout();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void onUidActive(int uid, int procState) {
            this.this$0.mActiveUids.onUidActive(uid, procState);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void onUidInactive(int uid) {
            this.this$0.mActiveUids.onUidInactive(uid);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void onUidProcStateChanged(int uid, int procState) {
            this.this$0.mActiveUids.onUidProcStateChanged(uid, procState);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean handleAppCrashInActivityController(String processName, int pid, String shortMsg, String longMsg, long timeMillis, String stackTrace, Runnable killCrashingAppCallback) {
            Runnable targetRunnable = null;
            WindowManagerGlobalLock r2 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r2);
        L9:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (this.this$0.mController != null) goto L26;
            monitor-exit(r2);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return false;
        L26:
            if (this.this$0.mController.appCrashed(processName, pid, shortMsg, longMsg, timeMillis, stackTrace) == true) goto L17;
            targetRunnable = killCrashingAppCallback;
        L17:
            monitor-exit(r2);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            if (targetRunnable == null) goto L22;
            targetRunnable.run();
            return true;
        L22:
            return false;
        L16:
            this.this$0.mController = null;     // Catch: Throwable -> L9
            Watchdog.getInstance().setActivityController(null);     // Catch: Throwable -> L9
            goto L17
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void removeRecentTasksByPackageName(String packageName, int userId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            ActivityTaskManagerService.m9661$$Nest$fgetmRecentTasks(this.this$0).removeTasksByPackageName(packageName, userId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void cleanupRecentTasksForUser(int userId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            ActivityTaskManagerService.m9661$$Nest$fgetmRecentTasks(this.this$0).cleanupLocked(userId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void loadRecentTasksForUser(int userId) {
            ActivityTaskManagerService.m9661$$Nest$fgetmRecentTasks(this.this$0).loadRecentTasksIfNeeded(userId);
            this.this$0.mPackageConfigPersister.loadUserPackages(userId);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void onPackagesSuspendedChanged(String[] packages, boolean suspended, int userId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            ActivityTaskManagerService.m9661$$Nest$fgetmRecentTasks(this.this$0).onPackagesSuspendedChanged(packages, suspended, userId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void flushRecentTasks() {
            ActivityTaskManagerService.m9661$$Nest$fgetmRecentTasks(this.this$0).flush();
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void clearLockedTasks(String reason) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.getLockTaskController().clearLockedTasks(reason);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void updateUserConfiguration() {
            WindowManagerGlobalLock r1 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r1);
            Configuration configuration = new Configuration(this.this$0.getGlobalConfiguration());     // Catch: Throwable -> L8
            int currentUserId = this.this$0.mAmInternal.getCurrentUserId();     // Catch: Throwable -> L8
            Settings.System.adjustConfigurationForUser(this.this$0.mContext.getContentResolver(), configuration, currentUserId, Settings.System.canWrite(this.this$0.mContext));     // Catch: Throwable -> L8
            this.this$0.updateConfigurationLocked(configuration, null, false, false, currentUserId, false);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean canShowErrorDialogs(int userId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            boolean r2 = true;
            if (ActivityTaskManagerService.m9663$$Nest$fgetmShowDialogs(this.this$0) == false) goto L7;
        L12:
            boolean showDialogs = true;
        L13:
            UserInfo userInfo = this.this$0.getUserManager().getUserInfo(userId);     // Catch: Throwable -> L10
            if (userInfo != null) goto L18;
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return false;
        L18:
            if (showDialogs == true) goto L20;
        L32:
            r2 = false;
        L33:
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L20:
            if (ActivityTaskManagerService.m9664$$Nest$fgetmSleeping(this.this$0) == true) goto L32;
            if (this.this$0.mShuttingDown == true) goto L32;
            if (this.this$0.mKeyguardController.isKeyguardOrAodShowing(0) == true) goto L32;
            if (this.this$0.hasUserRestriction("no_system_error_dialogs", userId) == true) goto L32;
            if (UserManager.isDeviceInDemoMode(this.this$0.mContext) == false) goto L33;
            if (userInfo.isDemo() == true) goto L32;
        L7:
            if (shouldShowDialogsForVisibleBackgroundUserLocked(userId) == true) goto L12;
            showDialogs = false;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        private boolean shouldShowDialogsForVisibleBackgroundUserLocked(int userId) {
            if (this.this$0.mWindowManager.mUmInternal.isVisibleBackgroundFullUser(userId) == true) goto L5;
            return false;
        L5:
            int displayId = this.this$0.mWindowManager.mUmInternal.getMainDisplayAssignedToUser(userId);
            DisplayContent dc = this.this$0.mRootWindowContainer.getDisplayContent(displayId);
            if (dc != null) goto L9;
            return false;
        L9:
            return ActivityTaskManagerService.m9679$$Nest$mshouldShowDialogs(this.this$0, dc.getConfiguration(), false);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void setProfileApp(String profileApp) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mProfileApp = profileApp;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void setProfileProc(WindowProcessController wpc) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mProfileProc = wpc;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void setProfilerInfo(ProfilerInfo profilerInfo) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mProfilerInfo = profilerInfo;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public ActivityMetricsLaunchObserverRegistry getLaunchObserverRegistry() {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            ActivityMetricsLaunchObserverRegistry r1 = this.this$0.mTaskSupervisor.getActivityMetricsLogger().getLaunchObserverRegistry();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public IBinder getUriPermissionOwnerForActivity(IBinder activityToken) {
            ActivityTaskManagerService.enforceNotIsolatedCaller("getUriPermissionOwnerForActivity");
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            ActivityRecord r = ActivityRecord.isInRootTaskLocked(activityToken);     // Catch: Throwable -> L11
            if (r != null) goto L7;
            Binder r2 = null;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L11
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L7:
            r2 = r.getUriPermissionsLocked().getExternalToken();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public TaskSnapshot getTaskSnapshotBlocking(int taskId, boolean isLowResolution, int usage) {
            return ActivityTaskManagerService.m9675$$Nest$mgetTaskSnapshotInner(this.this$0, taskId, isLowResolution, usage);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean isUidForeground(int uid) {
            return this.this$0.hasActiveVisibleWindow(uid);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void setDeviceOwnerUid(int uid) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.setDeviceOwnerUid(uid);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            SysOptBridge.getFactory().getProcessIntercept().setDeviceOwnerUid(uid);
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void setProfileOwnerUids(Set<Integer> uids) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.setProfileOwnerUids(uids);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void setCompanionAppUids(int userId, Set<Integer> companionAppUids) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            ActivityTaskManagerService.m9659$$Nest$fgetmCompanionAppUidsMap(this.this$0).put(Integer.valueOf(userId), companionAppUids);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean isBaseOfLockedTask(String packageName) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            boolean r1 = this.this$0.getLockTaskController().isBaseOfLockedTask(packageName);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean isNoDisplay(String packageName, int theme, int userId) {
            ActivityRecord.WindowStyle style = this.this$0.getWindowStyle(packageName, theme, userId);
            if (style != null) goto L5;
        L7:
            return false;
        L5:
            if (style.noDisplay() == false) goto L7;
            return true;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public ActivityTaskManagerInternal.PackageConfigurationUpdater createPackageConfigurationUpdater() {
            return new PackageConfigurationUpdaterImpl(Binder.getCallingPid(), this.this$0);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public ActivityTaskManagerInternal.PackageConfigurationUpdater createPackageConfigurationUpdater(String packageName, int userId) {
            return new PackageConfigurationUpdaterImpl(packageName, userId, this.this$0);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public ActivityTaskManagerInternal.PackageConfig getApplicationConfig(String packageName, int userId) {
            return this.this$0.mPackageConfigPersister.findPackageConfiguration(packageName, userId);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean hasSystemAlertWindowPermission(int callingUid, int callingPid, String callingPackage) {
            return this.this$0.hasSystemAlertWindowPermission(callingUid, callingPid, callingPackage);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void registerActivityStartInterceptor(int id, ActivityInterceptorCallback callback) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L13:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (ActivityTaskManagerService.m9657$$Nest$fgetmActivityInterceptorCallbacks(this.this$0).contains(id) == true) goto L20;
            if (callback == null) goto L18;
            if (ActivityInterceptorCallback.isValidOrderId(id) == false) goto L16;
            ActivityTaskManagerService.m9657$$Nest$fgetmActivityInterceptorCallbacks(this.this$0).put(id, callback);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L16:
            throw new IllegalArgumentException("Provided id " + id + " is not in range of valid ids for system services [0,5] nor in range of valid ids for mainline module services [1000,1001]");     // Catch: Throwable -> L13
        L18:
            throw new IllegalArgumentException("The passed ActivityInterceptorCallback can not be null");     // Catch: Throwable -> L13
        L20:
            throw new IllegalArgumentException("Duplicate id provided: " + id);     // Catch: Throwable -> L13
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void unregisterActivityStartInterceptor(int id) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (ActivityTaskManagerService.m9657$$Nest$fgetmActivityInterceptorCallbacks(this.this$0).contains(id) == false) goto L13;
            ActivityTaskManagerService.m9657$$Nest$fgetmActivityInterceptorCallbacks(this.this$0).remove(id);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L13:
            throw new IllegalArgumentException("ActivityInterceptorCallback with id (" + id + ") is not registered");     // Catch: Throwable -> L10
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public ActivityManager.RecentTaskInfo getMostRecentTaskFromBackground() {
            List<ActivityManager.RunningTaskInfo> runningTaskInfoList = this.this$0.getTasks(1);
            if (runningTaskInfoList.size() <= 0) goto L12;
            ActivityManager.RunningTaskInfo runningTaskInfo = runningTaskInfoList.get(0);
            List<ActivityManager.RecentTaskInfo> recentTaskInfoList = this.this$0.getRecentTasks(2, 2, this.this$0.mContext.getUserId()).getList();
            Iterator<ActivityManager.RecentTaskInfo> r4 = recentTaskInfoList.iterator();
        L6:
            if (r4.hasNext() == false) goto L17;
            ActivityManager.RecentTaskInfo info = r4.next();
            if (info.id == runningTaskInfo.id) goto L6;
            return info;
        L17:
            return null;
        L12:
            Slog.i("ActivityTaskManager", "No running task found!");
            return null;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public List<ActivityManager.AppTask> getAppTasks(String pkgName, int uid) {
            ArrayList<ActivityManager.AppTask> tasks = new ArrayList();
            List<IBinder> appTasks = ActivityTaskManagerService.m9674$$Nest$mgetAppTasks(this.this$0, pkgName, uid);
            int numAppTasks = appTasks.size();
            int i = 0;
        L3:
            if (i >= numAppTasks) goto L6;
            tasks.add(new ActivityManager.AppTask(IAppTask.Stub.asInterface(appTasks.get(i))));
            i = i + 1;
            goto L3
        L6:
            return tasks;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public int getTaskToShowPermissionDialogOn(String pkgName, int uid) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            int r1 = this.this$0.mRootWindowContainer.getTaskToShowPermissionDialogOn(pkgName, uid);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void restartTaskActivityProcessIfVisible(int taskId, final String packageName) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            Task task = this.this$0.mRootWindowContainer.anyTaskForId(taskId, 0);     // Catch: Throwable -> L10
            if (task != null) goto L12;
            Slog.w("ActivityTaskManager", "Failed to restart Activity. No task found for id: " + taskId);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L12:
            ActivityRecord activity = task.getActivity(new ActivityTaskManagerService$LocalService$$ExternalSyntheticLambda5(packageName));     // Catch: Throwable -> L10
            if (activity != null) goto L18;
            Slog.w("ActivityTaskManager", "Failed to restart Activity. No Activity found for package name: " + packageName + " in task: " + taskId);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L18:
            activity.restartProcessIfVisible();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        private static /* synthetic */ boolean lambda$restartTaskActivityProcessIfVisible$4(String packageName, ActivityRecord activityRecord) {
            if (packageName.equals(activityRecord.packageName) == true) goto L5;
        L7:
            return false;
        L5:
            if (activityRecord.finishing == true) goto L7;
            return true;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public ActivityTaskManagerInternalSmtBase getSmtEx() {
            return ActivityTaskManagerService.m9656$$Nest$fgetmATInternalSmtEx(this.this$0);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void registerTaskStackListener(ITaskStackListener listener) {
            this.this$0.registerTaskStackListener(listener);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void unregisterTaskStackListener(ITaskStackListener listener) {
            this.this$0.unregisterTaskStackListener(listener);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void registerCompatScaleProvider(int id, CompatScaleProvider provider) {
            this.this$0.registerCompatScaleProvider(id, provider);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public void unregisterCompatScaleProvider(int id) {
            this.this$0.unregisterCompatScaleProvider(id);
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean isAssistDataAllowed() {
            return this.this$0.isAssistDataAllowed();
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public boolean requestBackGesture() {
            return this.this$0.mBackNavigationController.requestBackGesture();
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal
        public ActivityRecord getTopVisibleFullScreenActivity(int displayId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            DisplayContent displayContent = this.this$0.mRootWindowContainer.getDisplayContent(displayId);     // Catch: Throwable -> L10
            if (displayContent == null) goto L13;
            ActivityRecord r2 = displayContent.getActivity(new ActivityTaskManagerService$LocalService$$ExternalSyntheticLambda1());     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return null;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        private static /* synthetic */ boolean lambda$getTopVisibleFullScreenActivity$5(ActivityRecord r) {
            WindowState win = r.findMainWindow();
            if (r.getWindowingMode() != 1) goto L10;
            if (win == null) goto L10;
            if (win.isDrawn() == false) goto L10;
            if (win.matchesDisplayAreaBounds() == false) goto L10;
            return true;
        L10:
            return false;
        }
    }

    public class PendingAssistExtras extends Binder implements Runnable {
        public final ActivityRecord activity;
        public AssistContent content;
        public final Bundle extras;
        public boolean haveResult;
        public final String hint;
        public final Intent intent;
        public boolean isHome;
        public final IAssistDataReceiver receiver;
        public Bundle receiverExtras;
        public Bundle result;
        public AssistStructure structure;
        final /* synthetic */ ActivityTaskManagerService this$0;
        public final int userHandle;

        public PendingAssistExtras(ActivityTaskManagerService this$0, ActivityRecord _activity, Bundle _extras, Intent _intent, String _hint, IAssistDataReceiver _receiver, Bundle _receiverExtras, int _userHandle) {
            this.this$0 = this$0;
            this.haveResult = false;
            this.result = null;
            this.structure = null;
            this.content = null;
            this.activity = _activity;
            this.extras = _extras;
            this.intent = _intent;
            this.hint = _hint;
            this.receiver = _receiver;
            this.receiverExtras = _receiverExtras;
            this.userHandle = _userHandle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Slog.w("ActivityTaskManager", "getAssistContextExtras failed: timeout retrieving from " + this.activity);
            monitor-enter(this);
            this.haveResult = true;     // Catch: Throwable -> L9
            notifyAll();     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            ActivityTaskManagerService.m9678$$Nest$mpendingAssistExtrasTimedOut(this.this$0, this);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface PowerModeReason {
    }

    private final class SettingObserver extends ContentObserver {
        private final Uri mFontScaleUri;
        private final Uri mFontWeightAdjustmentUri;
        private final Uri mHideErrorDialogsUri;
        final /* synthetic */ ActivityTaskManagerService this$0;

        SettingObserver(ActivityTaskManagerService r4) {
            this.this$0 = r4;
            super(r4.mH);
            this.mFontScaleUri = Settings.System.getUriFor("font_scale");
            this.mHideErrorDialogsUri = Settings.Global.getUriFor("hide_error_dialogs");
            this.mFontWeightAdjustmentUri = Settings.Secure.getUriFor("font_weight_adjustment");
            ContentResolver resolver = r4.mContext.getContentResolver();
            resolver.registerContentObserver(this.mFontScaleUri, false, this, -1);
            resolver.registerContentObserver(this.mHideErrorDialogsUri, false, this, -1);
            resolver.registerContentObserver(this.mFontWeightAdjustmentUri, false, this, -1);
        }

        public void onChange(boolean selfChange, Collection<Uri> uris, int flags, int userId) {
            Iterator<Uri> r0 = uris.iterator();
        L4:
            if (r0.hasNext() == false) goto L23;
            Uri uri = r0.next();
            if (this.mFontScaleUri.equals(uri) == true) goto L7;
            if (this.mHideErrorDialogsUri.equals(uri) == true) goto L10;
            if (this.mFontWeightAdjustmentUri.equals(uri) == false) goto L4;
            ActivityTaskManagerService.m9684$$Nest$mupdateFontWeightAdjustmentIfNeeded(this.this$0, userId);
            goto L4
        L10:
            WindowManagerGlobalLock r2 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r2);
            ActivityTaskManagerService.m9685$$Nest$mupdateShouldShowDialogsLocked(this.this$0, this.this$0.getGlobalConfiguration());     // Catch: Throwable -> L15
            monitor-exit(r2);     // Catch: Throwable -> L15
            WindowManagerService.resetPriorityAfterLockedSection();
        L15:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L7:
            this.this$0.updateFontScaleIfNeeded(userId);
            goto L4
        }
    }

    final class SleepTokenAcquirer {
        private final SparseArray<RootWindowContainer.SleepToken> mSleepTokens;
        private final String mTag;
        final /* synthetic */ ActivityTaskManagerService this$0;

        SleepTokenAcquirer(ActivityTaskManagerService this$0, String tag) {
            this.this$0 = this$0;
            this.mSleepTokens = new SparseArray();
            this.mTag = tag;
        }

        void acquire(int displayId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (this.mSleepTokens.contains(displayId) == true) goto L9;
            this.mSleepTokens.append(displayId, this.this$0.mRootWindowContainer.createSleepToken(this.mTag, displayId));     // Catch: Throwable -> L7
            this.this$0.updateSleepIfNeededLocked();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
        }

        void release(int displayId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            RootWindowContainer.SleepToken token = this.mSleepTokens.get(displayId);     // Catch: Throwable -> L7
            if (token == null) goto L9;
            this.this$0.mRootWindowContainer.removeSleepToken(token);     // Catch: Throwable -> L7
            this.mSleepTokens.remove(displayId);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    final class UiHandler extends Handler {
        static final int DISMISS_DIALOG_UI_MSG = 1;

        public UiHandler(ActivityTaskManagerService this$0) {
            super(UiThread.get().getLooper(), null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L5;
                default: goto L7;
            };
        L5:
            Dialog d = (Dialog) msg.obj;
            d.dismiss();
            return;
        }
    }

    static final class UpdateConfigurationResult {
        boolean activityRelaunched;
        int changes;

        UpdateConfigurationResult() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$18FqW2JxWvpXjAD4R3_-oThisxw, reason: not valid java name */
    public static /* synthetic */ void m9647$r8$lambda$18FqW2JxWvpXjAD4R3_oThisxw(ActivityTaskManagerService r0, int r1) {
        r0.cancelHeavyWeightProcessNotification(r1);
    }

    public static /* synthetic */ void $r8$lambda$5Pvlno7e1cIoxthFfjHWzEWbdII(ActivityRecord r0, List r1, Task r2) {
        lambda$unfreezeEarlyForKeyguardGoingAway$9(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Aj2kezY3B4rvf6GqW97TWPZPy-w, reason: not valid java name */
    public static /* synthetic */ void m9648$r8$lambda$Aj2kezY3B4rvf6GqW97TWPZPyw(ActivityTaskManagerService r0, boolean r1) {
        r0.lambda$onScreenAwakeChanged$5(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$CIr2exPEoiboQZ-zK23XqHkBIa8, reason: not valid java name */
    public static /* synthetic */ boolean m9649$r8$lambda$CIr2exPEoiboQZzK23XqHkBIa8(String r0, ActivityRecord r1) {
        return lambda$getTaskDescriptionIcon$6(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$D8lxzvlc2eZNWm9PVahc0-e9PPc, reason: not valid java name */
    public static /* synthetic */ boolean m9650$r8$lambda$D8lxzvlc2eZNWm9PVahc0e9PPc(ActivityTaskManagerService r0, WindowState r1) {
        return r0.lambda$isAssistDataAllowed$7(r1);
    }

    public static /* synthetic */ void $r8$lambda$Dzdx8NGO5GKg1fx1XS7pXWs_zYw(ActivityTaskManagerService r0) {
        r0.lambda$scheduleAppGcsLocked$17();
    }

    public static /* synthetic */ void $r8$lambda$ECXlfYa3g8Z0jW22PGhUi32Ur04(ActivityTaskManagerService r0, Task r1, Transition r2, Rect r3, int r4, boolean r5, boolean r6) {
        r0.lambda$resizeTask$2(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: $r8$lambda$KCeFKG-C7oLAvzEmlNEBH0en1vQ, reason: not valid java name */
    public static /* synthetic */ void m9651$r8$lambda$KCeFKGC7oLAvzEmlNEBH0en1vQ(ActivityTaskManagerService r0, Configuration r1, int r2, Configuration r3, int r4, boolean r5) {
        r0.lambda$updateGlobalConfigurationLocked$15(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$LskztWboj4PLIApnqk1RB2MESSE(ActivityTaskManagerService r0, boolean r1, boolean r2) {
        r0.lambda$postFinishBooting$16(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$QZiyL8M02CRSzrNqPlyxvag592U(Runnable r0, boolean r1) {
        lambda$enterPictureInPictureMode$12(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Rlu-jwWX0tK76HrUf3PKzhgvKyk, reason: not valid java name */
    public static /* synthetic */ void m9652$r8$lambda$RlujwWX0tK76HrUf3PKzhgvKyk(ActivityTaskManagerService r0, ActivityRecord r1) {
        r0.lambda$applyUpdateVrModeLocked$13(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$SlaSKvjL5hDX6Ef9g3iUAYSFp7U(Task r0) {
        return lambda$focusTopTask$1(r0);
    }

    public static /* synthetic */ void $r8$lambda$TEuecxXNCWqAi3rt1Mj3nrRTLVE(PrintWriter r0, TaskFragment r1) {
        lambda$saveANRState$18(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$VuxKPH1Glxt2xZkAanGEX4uJDSE(ActivityTaskManagerService r0, Transition r1, ActivityRecord r2, boolean r3) {
        r0.lambda$enterPictureInPictureMode$10(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$bwVkizajCt3edKoCKwoDKRfzntk(ActivityTaskManagerService r0, boolean r1) {
        r0.lambda$setLockScreenShownLocked$4(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$k-qPyuhW0dECo_JQYZDA8vu2eoc, reason: not valid java name */
    public static /* synthetic */ void m9653$r8$lambda$kqPyuhW0dECo_JQYZDA8vu2eoc(ActivityTaskManagerService r0, WindowProcessController r1, Intent r2, int r3) {
        r0.postHeavyWeightProcessNotification(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$lofk0jN0NnMz-E5QuGkAiKj3fq4, reason: not valid java name */
    public static /* synthetic */ boolean m9654$r8$lambda$lofk0jN0NnMzE5QuGkAiKj3fq4(Task r0) {
        return lambda$onPictureInPictureUiStateChanged$14(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$sAz-yLBq8YuXryM7Wvn-Uzs5HUM, reason: not valid java name */
    public static /* synthetic */ void m9655$r8$lambda$sAzyLBq8YuXryM7WvnUzs5HUM(ActivityTaskManagerService r0) {
        r0.lambda$keyguardGoingAway$8();
    }

    public static /* synthetic */ void $r8$lambda$tg_Uh1txp55gBWJ2xe9W7nAfVEg(ActivityTaskManagerService r0, ActivityRecord r1, Transition r2, boolean r3, PictureInPictureParams r4) {
        r0.lambda$enterPictureInPictureMode$11(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$vPwKEubHOY9D75mDF7MPm7C3mHI(ActivityTaskManagerService r0, boolean r1, boolean r2, DisplayContent r3) {
        r0.lambda$setLockScreenShownLocked$3(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$xw3oVmq5ZU_M2JzNhcLEohfHV_4(ActivityTaskManagerService r0, boolean r1, ActivityRecord r2) {
        r0.lambda$applyUpdateLockStateLocked$0(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmATInternalSmtEx, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerInternalSmtBase m9656$$Nest$fgetmATInternalSmtEx(ActivityTaskManagerService r0) {
        return r0.mATInternalSmtEx;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityInterceptorCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m9657$$Nest$fgetmActivityInterceptorCallbacks(ActivityTaskManagerService r0) {
        return r0.mActivityInterceptorCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppSwitchesState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9658$$Nest$fgetmAppSwitchesState(ActivityTaskManagerService r0) {
        return r0.mAppSwitchesState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCompanionAppUidsMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m9659$$Nest$fgetmCompanionAppUidsMap(ActivityTaskManagerService r0) {
        return r0.mCompanionAppUidsMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPreviousProcessVisibleTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m9660$$Nest$fgetmPreviousProcessVisibleTime(ActivityTaskManagerService r2) {
        return r2.mPreviousProcessVisibleTime;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRecentTasks, reason: not valid java name */
    static /* bridge */ /* synthetic */ RecentTasks m9661$$Nest$fgetmRecentTasks(ActivityTaskManagerService r0) {
        return r0.mRecentTasks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRetainPowerModeAndTopProcessState, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9662$$Nest$fgetmRetainPowerModeAndTopProcessState(ActivityTaskManagerService r0) {
        return r0.mRetainPowerModeAndTopProcessState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmShowDialogs, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9663$$Nest$fgetmShowDialogs(ActivityTaskManagerService r0) {
        return r0.mShowDialogs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSleeping, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9664$$Nest$fgetmSleeping(ActivityTaskManagerService r0) {
        return r0.mSleeping;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUiContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m9665$$Nest$fgetmUiContext(ActivityTaskManagerService r0) {
        return r0.mUiContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowStyleCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowStyleCache m9666$$Nest$fgetmWindowStyleCache(ActivityTaskManagerService r0) {
        return r0.mWindowStyleCache;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAccessibilityServiceUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9667$$Nest$fputmAccessibilityServiceUids(ActivityTaskManagerService r0, int[] r1) {
        r0.mAccessibilityServiceUids = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmActiveDreamComponent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9668$$Nest$fputmActiveDreamComponent(ActivityTaskManagerService r0, ComponentName r1) {
        r0.mActiveDreamComponent = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAppSwitchesState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9669$$Nest$fputmAppSwitchesState(ActivityTaskManagerService r0, int r1) {
        r0.mAppSwitchesState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBackgroundActivityStartCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9670$$Nest$fputmBackgroundActivityStartCallback(ActivityTaskManagerService r0, BackgroundActivityStartCallback r1) {
        r0.mBackgroundActivityStartCallback = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRetainPowerModeAndTopProcessState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9671$$Nest$fputmRetainPowerModeAndTopProcessState(ActivityTaskManagerService r0, boolean r1) {
        r0.mRetainPowerModeAndTopProcessState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcanCloseSystemDialogs, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9672$$Nest$mcanCloseSystemDialogs(ActivityTaskManagerService r0, int r1, int r2) {
        return r0.canCloseSystemDialogs(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateSafeActivityOptionsWithBalAllowed, reason: not valid java name */
    static /* bridge */ /* synthetic */ SafeActivityOptions m9673$$Nest$mcreateSafeActivityOptionsWithBalAllowed(ActivityTaskManagerService r0, Bundle r1) {
        return r0.createSafeActivityOptionsWithBalAllowed(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAppTasks, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m9674$$Nest$mgetAppTasks(ActivityTaskManagerService r0, String r1, int r2) {
        return r0.getAppTasks(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetTaskSnapshotInner, reason: not valid java name */
    static /* bridge */ /* synthetic */ TaskSnapshot m9675$$Nest$mgetTaskSnapshotInner(ActivityTaskManagerService r0, int r1, boolean r2, int r3) {
        return r0.getTaskSnapshotInner(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeHideLockedProfileActivityLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9676$$Nest$mmaybeHideLockedProfileActivityLocked(ActivityTaskManagerService r0) {
        r0.maybeHideLockedProfileActivityLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$monLocalVoiceInteractionStartedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9677$$Nest$monLocalVoiceInteractionStartedLocked(ActivityTaskManagerService r0, IBinder r1, IVoiceInteractionSession r2, IVoiceInteractor r3) {
        r0.onLocalVoiceInteractionStartedLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mpendingAssistExtrasTimedOut, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9678$$Nest$mpendingAssistExtrasTimedOut(ActivityTaskManagerService r0, PendingAssistExtras r1) {
        r0.pendingAssistExtrasTimedOut(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldShowDialogs, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9679$$Nest$mshouldShowDialogs(ActivityTaskManagerService r0, Configuration r1, boolean r2) {
        return r0.shouldShowDialogs(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mstart, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9680$$Nest$mstart(ActivityTaskManagerService r0) {
        r0.start();
    }

    /* JADX INFO: renamed from: -$$Nest$mstartActivityAsUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9681$$Nest$mstartActivityAsUser(ActivityTaskManagerService r0, IApplicationThread r1, String r2, String r3, Intent r4, String r5, IBinder r6, String r7, int r8, int r9, ProfilerInfo r10, Bundle r11, int r12, boolean r13) {
        return r0.startActivityAsUser(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartDreamActivityInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ IAppTask m9682$$Nest$mstartDreamActivityInternal(ActivityTaskManagerService r0, Intent r1, int r2, int r3) {
        return r0.startDreamActivityInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateEventDispatchingLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9683$$Nest$mupdateEventDispatchingLocked(ActivityTaskManagerService r0, boolean r1) {
        r0.updateEventDispatchingLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFontWeightAdjustmentIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9684$$Nest$mupdateFontWeightAdjustmentIfNeeded(ActivityTaskManagerService r0, int r1) {
        r0.updateFontWeightAdjustmentIfNeeded(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateShouldShowDialogsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9685$$Nest$mupdateShouldShowDialogsLocked(ActivityTaskManagerService r0, Configuration r1) {
        r0.updateShouldShowDialogsLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mwriteSleepStateToProto, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9686$$Nest$mwriteSleepStateToProto(ActivityTaskManagerService r0, ProtoOutputStream r1, int r2, boolean r3) {
        r0.writeSleepStateToProto(r1, r2, r3);
    }

    public ActivityTaskManagerService(Context context) {
        this.mPerf = new BoostFramework();
        this.mLegacyUiPerfHandler = -1;
        this.mStartingProcessActivities = new ArrayList();
        this.mGlobalLock = new WindowManagerGlobalLock();
        this.mGlobalLockWithoutBoost = this.mGlobalLock;
        this.mActiveUids = new MirrorActiveUids();
        this.mProcessNames = new ProcessMap();
        this.mProcessMap = new WindowProcessControllerMap();
        this.mKeyguardShown = false;
        this.mViSessionId = 1000;
        this.mPendingAssistExtras = new ArrayList();
        this.mCompanionAppUidsMap = new ArrayMap();
        this.mActivityInterceptorCallbacks = new SparseArray();
        this.mWindowStyleCache = new WindowStyleCache(new ActivityTaskManagerService$$ExternalSyntheticLambda0());
        this.mTmpUpdateConfigurationResult = new UpdateConfigurationResult();
        this.mSupportedSystemLocales = null;
        this.mTempConfig = new Configuration();
        this.mAppSwitchesState = 2;
        this.mAnrController = new ArrayList();
        this.mController = null;
        this.mControllerIsAMonkey = false;
        this.mTopAction = "android.intent.action.MAIN";
        this.mProfileApp = null;
        this.mProfileProc = null;
        this.mProfilerInfo = null;
        this.mUpdateLock = new UpdateLock("immersive");
        this.mAllowAppSwitchUids = new SparseArray();
        this.mScreenObservers = Collections.synchronizedList(new ArrayList());
        this.mVr2dDisplayId = -1;
        this.mTopProcessState = 2;
        this.mShowDialogs = true;
        this.toastWindow = false;
        this.mAccessibilityServiceUids = new int[0];
        this.mDeviceOwnerUid = -1;
        this.mProfileOwnerUids = new ArraySet();
        this.mObricExt = (IObricActivityTaskManagerService) ObricImplFactory.getImpl(IObricActivityTaskManagerService.class, new Object[]{this});
        this.mUpdateOomAdjRunnable = new AnonymousClass1(this);
        this.mIExt = (IExtATMService) ExtImplFactory.getImpl(IExtATMService.class, new Object[0]);
        this.mATInternalSmtEx = new ActivityTaskManagerInternalSmtBase(this);
        this.mContext = context;
        this.mFactoryTest = FactoryTest.getMode();
        this.mSystemThread = ActivityThread.currentActivityThread();
        this.mUiContext = this.mSystemThread.getSystemUiContext();
        this.mLifecycleManager = new ClientLifecycleManager();
        this.mVisibleActivityProcessTracker = new VisibleActivityProcessTracker(this);
        this.mInternal = new LocalService(this);
        this.GL_ES_VERSION = SystemProperties.getInt("ro.opengles.version", 0);
        this.mWindowOrganizerController = new WindowOrganizerController(this);
        this.mChainTracker = new ActionChain.Tracker(this);
        this.mTaskOrganizerController = this.mWindowOrganizerController.mTaskOrganizerController;
        this.mTaskFragmentOrganizerController = this.mWindowOrganizerController.mTaskFragmentOrganizerController;
        this.mBackNavigationController = new BackNavigationController();
        this.mSmtEx = new ActivityTaskManagerServiceSmtEx(this);
    }

    public void onSystemReady() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        PackageManager pm = this.mContext.getPackageManager();     // Catch: Throwable -> L8
        this.mHasHeavyWeightFeature = pm.hasSystemFeature("android.software.cant_save_state");     // Catch: Throwable -> L8
        this.mHasLeanbackFeature = pm.hasSystemFeature("android.software.leanback");     // Catch: Throwable -> L8
        this.mHasCompanionDeviceSetupFeature = pm.hasSystemFeature("android.software.companion_device_setup");     // Catch: Throwable -> L8
        this.mVrController.onSystemReady();     // Catch: Throwable -> L8
        this.mRecentTasks.onSystemReadyLocked();     // Catch: Throwable -> L8
        this.mTaskSupervisor.onSystemReady();     // Catch: Throwable -> L8
        this.mActivityClientController.onSystemReady();     // Catch: Throwable -> L8
        this.mAppWarnings.onSystemReady();     // Catch: Throwable -> L8
        ActivitySecurityModelFeatureFlags.initialize(this.mContext.getMainExecutor());     // Catch: Throwable -> L8
        this.mGrammaticalManagerInternal = (GrammaticalInflectionManagerInternal) LocalServices.getService(GrammaticalInflectionManagerInternal.class);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void onInitPowerManagement() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mTaskSupervisor.initPowerManagement();     // Catch: Throwable -> L8
        PowerManager pm = (PowerManager) this.mContext.getSystemService("power");     // Catch: Throwable -> L8
        this.mPowerManagerInternal = (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class);     // Catch: Throwable -> L8
        this.mVoiceWakeLock = pm.newWakeLock(1, "*voice*");     // Catch: Throwable -> L8
        this.mVoiceWakeLock.setReferenceCounted(false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void installSystemProviders() {
        this.mSettingsObserver = new SettingObserver(this);
    }

    public void retrieveSettings(ContentResolver resolver) {
        if (this.mContext.getPackageManager().hasSystemFeature("android.software.freeform_window_management") == false) goto L5;
    L8:
        boolean freeformWindowManagement = true;
    L9:
        boolean supportsMultiWindow = ActivityTaskManager.supportsMultiWindow(this.mContext);
        if (supportsMultiWindow == true) goto L12;
    L14:
        boolean supportsPictureInPicture = false;
    L16:
        if (supportsPictureInPicture == true) goto L18;
    L20:
        boolean supportsExpandedPictureInPicture = false;
    L21:
        boolean supportsSplitScreenMultiWindow = ActivityTaskManager.supportsSplitScreenMultiWindow(this.mContext);
        boolean supportsMultiDisplay = this.mContext.getPackageManager().hasSystemFeature("android.software.activities_on_secondary_displays");
        if (Settings.Global.getInt(resolver, "debug.force_rtl", 0) == 0) goto L24;
        boolean forceRtl = true;
    L26:
        if (Settings.Global.getInt(resolver, "force_resizable_activities", 0) == 0) goto L28;
        boolean forceResizable = true;
    L30:
        if (Settings.Global.getInt(resolver, "enable_non_resizable_multi_window", 0) == 0) goto L32;
        boolean devEnableNonResizableMultiWindow = true;
    L33:
        int supportsNonResizableMultiWindow = this.mContext.getResources().getInteger(R.integer.config_vibratorControlServiceDumpSizeLimit);
        int respectsActivityMinWidthHeightMultiWindow = this.mContext.getResources().getInteger(R.integer.config_screenBrightnessDim);
        float minPercentageMultiWindowSupportHeight = this.mContext.getResources().getFloat(R.dimen.dialog_list_padding_top_no_title);
        float minPercentageMultiWindowSupportWidth = this.mContext.getResources().getFloat(R.dimen.dialog_no_title_padding_top);
        if (Features.FEAT_QUICK_WIN == false) goto L36;
        boolean freeformWindowManagement2 = true;
    L37:
        DisplayProperties.debug_force_rtl(Boolean.valueOf(forceRtl));
        Configuration configuration = new Configuration();
        Settings.System.getConfiguration(resolver, configuration);
        if (forceRtl == false) goto L40;
        configuration.setLayoutDirection(configuration.locale);
    L40:
        configuration.setGrammaticalGender(this.mGrammaticalManagerInternal.mergedFinalSystemGrammaticalGender());
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        this.mForceResizableActivities = forceResizable;     // Catch: Throwable -> L79
        this.mDevEnableNonResizableMultiWindow = devEnableNonResizableMultiWindow;     // Catch: Throwable -> L79
        this.mSupportsNonResizableMultiWindow = supportsNonResizableMultiWindow;     // Catch: Throwable -> L79
        this.mRespectsActivityMinWidthHeightMultiWindow = respectsActivityMinWidthHeightMultiWindow;     // Catch: Throwable -> L79
        this.mMinPercentageMultiWindowSupportHeight = minPercentageMultiWindowSupportHeight;     // Catch: Throwable -> L79
        this.mMinPercentageMultiWindowSupportWidth = minPercentageMultiWindowSupportWidth;     // Catch: Throwable -> L79
        if (freeformWindowManagement2 == true) goto L49;
        if (supportsSplitScreenMultiWindow == true) goto L49;
        if (supportsPictureInPicture == true) goto L49;
        if (supportsMultiDisplay == true) goto L49;
        boolean multiWindowFormEnabled = false;
    L50:
        if (supportsMultiWindow == true) goto L54;
        if (forceResizable == true) goto L54;
    L62:
        this.mSupportsMultiWindow = false;     // Catch: Throwable -> L79
        this.mSupportsFreeformWindowManagement = false;     // Catch: Throwable -> L79
        this.mSupportsSplitScreenMultiWindow = false;     // Catch: Throwable -> L79
        this.mSupportsPictureInPicture = false;     // Catch: Throwable -> L79
        this.mSupportsExpandedPictureInPicture = false;     // Catch: Throwable -> L79
        this.mSupportsMultiDisplay = false;     // Catch: Throwable -> L79
    L63:
        this.mWindowManager.mRoot.onSettingsRetrieved();     // Catch: Throwable -> L79
        updateConfigurationLocked(configuration, null, true);     // Catch: Throwable -> L72
        Configuration globalConfig = getGlobalConfiguration();     // Catch: Throwable -> L72
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L75;
        String protoLogParam0 = String.valueOf(globalConfig);     // Catch: Throwable -> L72
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, 5445799252721678675L, 0, new Object[]{protoLogParam0});     // Catch: Throwable -> L70
    L75:
        Resources res = this.mContext.getResources();     // Catch: Throwable -> L70
        this.mThumbnailWidth = res.getDimensionPixelSize(R.dimen.thumbnail_width);     // Catch: Throwable -> L70
        this.mThumbnailHeight = res.getDimensionPixelSize(R.dimen.thumbnail_height);     // Catch: Throwable -> L70
        monitor-exit(r2);     // Catch: Throwable -> L70
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L72:
        th = th;
    L81:
        monitor-exit(r2);     // Catch: Throwable -> L70
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L54:
        if (multiWindowFormEnabled == false) goto L62;
        this.mSupportsMultiWindow = true;     // Catch: Throwable -> L58
        this.mSupportsFreeformWindowManagement = freeformWindowManagement2;     // Catch: Throwable -> L58
        this.mSupportsSplitScreenMultiWindow = supportsSplitScreenMultiWindow;     // Catch: Throwable -> L58
        this.mSupportsPictureInPicture = supportsPictureInPicture;     // Catch: Throwable -> L58
        this.mSupportsExpandedPictureInPicture = supportsExpandedPictureInPicture;     // Catch: Throwable -> L58
        this.mSupportsMultiDisplay = supportsMultiDisplay;     // Catch: Throwable -> L58
    L58:
        th = th;
    L49:
        multiWindowFormEnabled = true;
    L79:
        th = th;
    L70:
        th = th;
        goto L81
    L36:
        freeformWindowManagement2 = freeformWindowManagement;
        goto L37
    L32:
        devEnableNonResizableMultiWindow = false;
        goto L33
    L28:
        forceResizable = false;
        goto L30
    L24:
        forceRtl = false;
        goto L26
    L18:
        if (this.mContext.getPackageManager().hasSystemFeature("android.software.expanded_picture_in_picture") == false) goto L20;
        supportsExpandedPictureInPicture = true;
        goto L21
    L12:
        if (this.mContext.getPackageManager().hasSystemFeature("android.software.picture_in_picture") == false) goto L14;
        supportsPictureInPicture = true;
        goto L16
    L5:
        if (Settings.Global.getInt(resolver, "enable_freeform_support", 0) != 0) goto L8;
        freeformWindowManagement = false;
        goto L9
    }

    public WindowManagerGlobalLock getGlobalLock() {
        return this.mGlobalLock;
    }

    public ActivityTaskManagerInternal getAtmInternal() {
        return this.mInternal;
    }

    public void initialize(IntentFirewall intentFirewall, PendingIntentController intentController, Looper looper) {
        this.mH = new H(this, looper);
        this.mUiHandler = new UiHandler(this);
        this.mIntentFirewall = intentFirewall;
        File systemDir = SystemServiceManager.ensureSystemDir();
        this.mAppWarnings = createAppWarnings(this.mUiContext, this.mH, this.mUiHandler, systemDir);
        this.mCompatModePackages = new CompatModePackages(this, systemDir, this.mH);
        this.mPendingIntentController = intentController;
        this.mTaskSupervisor = createTaskSupervisor();
        this.mActivityClientController = new ActivityClientController(this);
        this.mTaskChangeNotificationController = new TaskChangeNotificationController(this.mTaskSupervisor, this.mH);
        this.mLockTaskController = new LockTaskController(this.mContext, this.mTaskSupervisor, this.mH, this.mTaskChangeNotificationController);
        this.mActivityStartController = new ActivityStartController(this);
        setRecentTasks(new RecentTasks(this, this.mTaskSupervisor));
        this.mVrController = new VrController(this.mGlobalLock);
        this.mKeyguardController = this.mTaskSupervisor.getKeyguardController();
        this.mPackageConfigPersister = new PackageConfigPersister(this.mTaskSupervisor.mPersisterQueue, this);
    }

    public void onActivityManagerInternalAdded() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mAmInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);     // Catch: Throwable -> L8
        this.mUgmInternal = (UriGrantsManagerInternal) LocalServices.getService(UriGrantsManagerInternal.class);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    int increaseConfigurationSeqLocked() {
        int r0 = this.mConfigurationSeq + 1;
        this.mConfigurationSeq = r0;
        this.mConfigurationSeq = Math.max(r0, 1);
        return this.mConfigurationSeq;
    }

    protected ActivityTaskSupervisor createTaskSupervisor() {
        ActivityTaskSupervisor supervisor = new ActivityTaskSupervisor(this, this.mH.getLooper());
        supervisor.initialize();
        return supervisor;
    }

    protected AppWarnings createAppWarnings(Context uiContext, Handler handler, Handler uiHandler, File systemDir) {
        return new AppWarnings(this, uiContext, handler, uiHandler, systemDir);
    }

    public void setWindowManager(WindowManagerService wm) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mWindowManager = wm;     // Catch: Throwable -> L8
        this.mRootWindowContainer = wm.mRoot;     // Catch: Throwable -> L8
        this.mWindowOrganizerController.mTransitionController.setWindowManager(wm);     // Catch: Throwable -> L8
        this.mLifecycleManager.setWindowManager(wm);     // Catch: Throwable -> L8
        this.mTempConfig.setToDefaults();     // Catch: Throwable -> L8
        this.mTempConfig.setLocales(LocaleList.getDefault());     // Catch: Throwable -> L8
        this.mTempConfig.seq = 1;     // Catch: Throwable -> L8
        this.mConfigurationSeq = 1;     // Catch: Throwable -> L8
        this.mRootWindowContainer.onConfigurationChanged(this.mTempConfig);     // Catch: Throwable -> L8
        this.mLockTaskController.setWindowManager(wm);     // Catch: Throwable -> L8
        this.mTaskSupervisor.setWindowManager(wm);     // Catch: Throwable -> L8
        this.mRootWindowContainer.setWindowManager(wm);     // Catch: Throwable -> L8
        this.mBackNavigationController.setWindowManager(wm);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void setUsageStatsManager(UsageStatsManagerInternal usageStatsManager) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mUsageStatsInternal = usageStatsManager;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    Context getUiContext() {
        return this.mUiContext;
    }

    UserManagerService getUserManager() {
        if (this.mUserManager != null) goto L6;
        IBinder b = ServiceManager.getService("user");
        this.mUserManager = IUserManager.Stub.asInterface(b);
    L6:
        return this.mUserManager;
    }

    AppOpsManager getAppOpsManager() {
        if (this.mAppOpsManager != null) goto L6;
        this.mAppOpsManager = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
    L6:
        return this.mAppOpsManager;
    }

    boolean hasUserRestriction(String restriction, int userId) {
        return getUserManager().hasUserRestriction(restriction, userId);
    }

    boolean hasSystemAlertWindowPermission(int callingUid, int callingPid, String callingPackage) {
        int mode = getAppOpsManager().noteOpNoThrow(24, callingUid, callingPackage, null, "");
        if (mode == 3) goto L5;
        if (mode == 0) goto L10;
        return false;
    L10:
        return true;
    L5:
        if (checkPermission("android.permission.SYSTEM_ALERT_WINDOW", callingPid, callingUid) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    protected void setRecentTasks(RecentTasks recentTasks) {
        this.mRecentTasks = recentTasks;
        this.mTaskSupervisor.setRecentTasks(recentTasks);
    }

    RecentTasks getRecentTasks() {
        return this.mRecentTasks;
    }

    ClientLifecycleManager getLifecycleManager() {
        return this.mLifecycleManager;
    }

    ActivityStartController getActivityStartController() {
        return this.mActivityStartController;
    }

    TaskChangeNotificationController getTaskChangeNotificationController() {
        return this.mTaskChangeNotificationController;
    }

    LockTaskController getLockTaskController() {
        return this.mLockTaskController;
    }

    TransitionController getTransitionController() {
        return this.mWindowOrganizerController.getTransitionController();
    }

    private Configuration getGlobalConfigurationForCallingPid() {
        int pid = Binder.getCallingPid();
        if (pid == WindowManagerService.MY_PID) goto L12;
        if (pid < 0) goto L12;
        WindowProcessController app = this.mProcessMap.getProcess(pid);
        if (app == null) goto L10;
        return app.getConfiguration();
    L10:
        return getGlobalConfiguration();
    L12:
        return getGlobalConfiguration();
    }

    public ConfigurationInfo getDeviceConfigurationInfo() {
        ConfigurationInfo config = new ConfigurationInfo();
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        Configuration globalConfig = getGlobalConfigurationForCallingPid();     // Catch: Throwable -> L9
        config.reqTouchScreen = globalConfig.touchscreen;     // Catch: Throwable -> L9
        config.reqKeyboardType = globalConfig.keyboard;     // Catch: Throwable -> L9
        config.reqNavigation = globalConfig.navigation;     // Catch: Throwable -> L9
        if (globalConfig.navigation == 2) goto L11;
        if (globalConfig.navigation == 3) goto L11;
    L13:
        if (globalConfig.keyboard != 0) goto L15;
    L17:
        config.reqGlEsVersion = this.GL_ES_VERSION;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return config;
    L15:
        if (globalConfig.keyboard == 1) goto L17;
        config.reqInputFeatures |= 1;     // Catch: Throwable -> L9
    L11:
        config.reqInputFeatures |= 2;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public BackgroundActivityStartCallback getBackgroundActivityStartCallback() {
        return this.mBackgroundActivityStartCallback;
    }

    SparseArray<ActivityInterceptorCallback> getActivityInterceptorCallbacks() {
        return this.mActivityInterceptorCallbacks;
    }

    private void start() {
        LocalServices.addService(ActivityTaskManagerInternal.class, this.mInternal);
    }

    public final int startActivity(IApplicationThread caller, String callingPackage, String callingFeatureId, Intent intent, String resolvedType, IBinder resultTo, String resultWho, int requestCode, int startFlags, ProfilerInfo profilerInfo, Bundle bOptions) {
        return startActivityAsUser(caller, callingPackage, callingFeatureId, intent, resolvedType, resultTo, resultWho, requestCode, startFlags, profilerInfo, bOptions, UserHandle.getCallingUserId());
    }

    public final int startActivities(IApplicationThread caller, String callingPackage, String callingFeatureId, Intent[] intents, String[] resolvedTypes, IBinder resultTo, Bundle bOptions, int userId) {
        assertPackageMatchesCallingUid(callingPackage);
        enforceNotIsolatedCaller("startActivities");
        if (intents == null) goto L8;
        int r2 = intents.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        Intent intent = intents[r3];
        this.mAmInternal.addCreatorToken(intent, callingPackage);
        r3 = r3 + 1;
    L8:
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        int userId2 = handleIncomingUser(callingPid, callingUid, userId, "startActivities");
        return getActivityStartController().startActivities(caller, -1, 0, -1, callingPackage, callingFeatureId, intents, resolvedTypes, resultTo, SafeActivityOptions.fromBundle(bOptions, callingPid, callingUid), userId2, "startActivities", null, false);
    }

    public int startActivityAsUser(IApplicationThread caller, String callingPackage, String callingFeatureId, Intent intent, String resolvedType, IBinder resultTo, String resultWho, int requestCode, int startFlags, ProfilerInfo profilerInfo, Bundle bOptions, int userId) {
        return startActivityAsUser(caller, callingPackage, callingFeatureId, intent, resolvedType, resultTo, resultWho, requestCode, startFlags, profilerInfo, bOptions, userId, true);
    }

    static boolean isSdkSandboxActivityIntent(Context context, Intent intent) {
        return SdkSandboxActivityAuthority.isSdkSandboxActivityIntent(context, intent);
    }

    private int startActivityAsUser(IApplicationThread caller, String callingPackage, String callingFeatureId, Intent intent, String resolvedType, IBinder resultTo, String resultWho, int requestCode, int startFlags, ProfilerInfo profilerInfo, Bundle bOptions, int userId, boolean validateIncomingUser) {
        this.mAmInternal.addCreatorToken(intent, callingPackage);
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        if (SysOptBridge.getFactory().getSysPrefetchService().preloadTargetApp(intent, callingPackage, userId) == false) goto L5;
        return 0;
    L5:
        SafeActivityOptions opts = SafeActivityOptions.fromBundle(bOptions, callingPid, callingUid);
        this.mObricExt.clearInvalidLaunchDisplayId(opts);
        assertPackageMatchesCallingUid(callingPackage);
        enforceNotIsolatedCaller("startActivityAsUser");
        if (isSdkSandboxActivityIntent(this.mContext, intent) == false) goto L9;
        ((SdkSandboxManagerLocal) LocalManagerRegistry.getManager(SdkSandboxManagerLocal.class)).enforceAllowedToHostSandboxedActivity(intent, callingUid, callingPackage);
    L9:
        if (Process.isSdkSandboxUid(callingUid) == false) goto L15;
        SdkSandboxManagerLocal sdkSandboxManagerLocal = (SdkSandboxManagerLocal) LocalManagerRegistry.getManager(SdkSandboxManagerLocal.class);
        if (sdkSandboxManagerLocal == null) goto L14;
        sdkSandboxManagerLocal.enforceAllowedToStartActivity(intent);
        goto L15
    L14:
        throw new IllegalStateException("SdkSandboxManagerLocal not found when starting an activity from an SDK sandbox uid.");
    L15:
        int userId2 = getActivityStartController().checkTargetUser(userId, validateIncomingUser, callingPid, callingUid, "startActivityAsUser");
        if (getExt().deferStartActivityIfNeeded(this, caller, callingPackage, callingFeatureId, intent, resolvedType, resultTo, resultWho, requestCode, startFlags, profilerInfo, opts, userId2, callingPid, callingUid) == false) goto L18;
        return 0;
    L18:
        SysOptBridge.getFactory().getKernelTrigger().notifyActivityStart(intent, callingPackage);
        SysOptBridge.getFactory().getColdStartTrim().tryColdStartTrim(intent, callingPackage);
        return getActivityStartController().obtainStarter(intent, "startActivityAsUser").setCaller(caller).setCallingPackage(callingPackage).setCallingFeatureId(callingFeatureId).setResolvedType(resolvedType).setResultTo(resultTo).setResultWho(resultWho).setRequestCode(requestCode).setStartFlags(startFlags).setProfilerInfo(profilerInfo).setActivityOptions(opts).setUserId(userId2).execute();
    }

    public int startActivityIntentSender(IApplicationThread caller, IIntentSender target, IBinder allowlistToken, Intent fillInIntent, String resolvedType, IBinder resultTo, String resultWho, int requestCode, int flagsMask, int flagsValues, Bundle bOptions) {
        enforceNotIsolatedCaller("startActivityIntentSender");
        if (fillInIntent == null) goto L10;
        if (fillInIntent.hasFileDescriptors() == true) goto L8;
        fillInIntent.removeExtendedFlags(1);
        goto L10
    L8:
        throw new IllegalArgumentException("File descriptors passed in Intent");
    L10:
        if ((target instanceof PendingIntentRecord) == false) goto L32;
        PendingIntentRecord pir = (PendingIntentRecord) target;
        if (fillInIntent == null) goto L14;
        this.mAmInternal.addCreatorToken(fillInIntent, pir.getPackageName());
    L14:
        WindowManagerGlobalLock r4 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r4);
        Task topFocusedRootTask = getTopDisplayFocusedRootTask();     // Catch: Throwable -> L23
        if (topFocusedRootTask != null) goto L19;
    L25:
        monitor-exit(r4);     // Catch: Throwable -> L23
        WindowManagerService.resetPriorityAfterLockedSection();
        return pir.sendInner(caller, 0, fillInIntent, resolvedType, allowlistToken, null, null, resultTo, resultWho, requestCode, flagsMask, flagsValues, bOptions);
    L19:
        if (topFocusedRootTask.getTopResumedActivity() == null) goto L25;
        if (topFocusedRootTask.getTopResumedActivity().info.applicationInfo.uid != Binder.getCallingUid()) goto L25;
        this.mAppSwitchesState = 2;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L32:
        throw new IllegalArgumentException("Bad PendingIntent object");
    }

    public boolean startNextMatchingActivity(IBinder callingActivity, Intent intent, Bundle bOptions) {
        if (intent != null) goto L5;
    L9:
        int origCallingPid = Binder.getCallingPid();
        int origCallingUid = Binder.getCallingUid();
        SafeActivityOptions options = SafeActivityOptions.fromBundle(bOptions, origCallingPid, origCallingUid);
        WindowManagerGlobalLock r7 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r7);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(callingActivity);     // Catch: Throwable -> L17
        if (r != null) goto L20;
        SafeActivityOptions.abort(options);     // Catch: Throwable -> L17
        monitor-exit(r7);     // Catch: Throwable -> L17
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L20:
        if (r.attachedToProcess() == true) goto L25;
        SafeActivityOptions.abort(options);     // Catch: Throwable -> L17
        monitor-exit(r7);     // Catch: Throwable -> L17
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L25:
        this.mAmInternal.addCreatorToken(intent, r.packageName);     // Catch: Throwable -> L17
        Intent intent2 = new Intent(intent);     // Catch: Throwable -> L17
        int r2 = 1;
        intent2.removeExtendedFlags(1);     // Catch: Throwable -> L38
        intent2.setDataAndType(r.intent.getData(), r.intent.getType());     // Catch: Throwable -> L38
        intent2.setComponent(null);     // Catch: Throwable -> L38
        if ((intent2.getFlags() & 8) == 0) goto L30;
        boolean r0 = true;
    L31:
        boolean debug = r0;
        int userId = UserHandle.getCallingUserId();     // Catch: Throwable -> L38
        ActivityInfo aInfo = null;
        boolean r19 = false;
        List<ResolveInfo> resolves = AppGlobals.getPackageManager().queryIntentActivities(intent2, r.resolvedType, 66560, userId).getList();     // Catch: Throwable -> L38 RemoteException -> L40
        if (resolves == null) goto L42;
        int N = resolves.size();     // Catch: Throwable -> L38 RemoteException -> L40
    L43:
        int i = 0;
    L44:
        if (i >= N) goto L69;
        ResolveInfo rInfo = resolves.get(i);     // Catch: Throwable -> L38 RemoteException -> L40
        if (rInfo.activityInfo.packageName.equals(r.packageName) == false) goto L67;
        if (rInfo.activityInfo.name.equals(r.info.name) == false) goto L67;
        int i2 = i + r2;     // Catch: Throwable -> L38 RemoteException -> L40
        if (i2 >= N) goto L53;
        ActivityInfo aInfo2 = resolves.get(i2).activityInfo;     // Catch: Throwable -> L38 RemoteException -> L40
    L54:
        if (debug == false) goto L64;
        Slog.v("ActivityTaskManager", "Next matching activity: found current " + r.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + r.info.name);     // Catch: Throwable -> L38 RemoteException -> L58
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L38 RemoteException -> L58
        r3.append("Next matching activity: next is ");     // Catch: Throwable -> L38 RemoteException -> L58
        if (aInfo2 != null) goto L60;
        String r14 = "null";
    L61:
        r3.append(r14);     // Catch: Throwable -> L38 RemoteException -> L58
        Slog.v("ActivityTaskManager", r3.toString());     // Catch: Throwable -> L38 RemoteException -> L58
    L60:
        r14 = aInfo2.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + aInfo2.name;     // Catch: Throwable -> L38 RemoteException -> L58
    L59:
        aInfo = aInfo2;
    L64:
        aInfo = aInfo2;
        goto L69
    L53:
        aInfo2 = null;
    L67:
        i = i + 1;
        resolves = resolves;
        r2 = 1;
    L69:
        ActivityInfo aInfo3 = aInfo;
    L73:
        if (aInfo3 != null) goto L80;
        SafeActivityOptions.abort(options);     // Catch: Throwable -> L38
        if (debug == false) goto L77;
        Slog.d("ActivityTaskManager", "Next matching activity: nothing found");     // Catch: Throwable -> L38
    L77:
        monitor-exit(r7);     // Catch: Throwable -> L38
        WindowManagerService.resetPriorityAfterLockedSection();
        return r19;
    L80:
        intent2.setComponent(new ComponentName(aInfo3.applicationInfo.packageName, aInfo3.name));     // Catch: Throwable -> L38
        intent2.setFlags(intent2.getFlags() & (-503316481));     // Catch: Throwable -> L38
        boolean wasFinishing = r.finishing;     // Catch: Throwable -> L38
        r.finishing = true;     // Catch: Throwable -> L38
        ActivityRecord resultTo = r.resultTo;     // Catch: Throwable -> L38
        String resultWho = r.resultWho;     // Catch: Throwable -> L38
        int requestCode = r.requestCode;     // Catch: Throwable -> L38
        r.resultTo = null;     // Catch: Throwable -> L38
        if (resultTo == null) goto L83;
        resultTo.removeResultsLocked(r, resultWho, requestCode);     // Catch: Throwable -> L38
    L83:
        long origId = Binder.clearCallingIdentity();     // Catch: Throwable -> L38
        if (options == null) goto L106;
    L88:
        ActivityStarter r1 = getActivityStartController().obtainStarter(intent2, "startNextMatchingActivity").setCaller(r.app.getThread()).setResolvedType(r.resolvedType).setActivityInfo(aInfo3);     // Catch: Throwable -> L86
        if (resultTo == null) goto L91;
        IBinder r5 = resultTo.token;     // Catch: Throwable -> L86
    L92:
        int res = r1.setResultTo(r5).setResultWho(resultWho).setRequestCode(requestCode).setCallingPid(-1).setCallingUid(r.launchedFromUid).setCallingPackage(r.launchedFromPackage).setCallingFeatureId(r.launchedFromFeatureId).setRealCallingPid(origCallingPid).setRealCallingUid(origCallingUid).setActivityOptions(options).setUserId(userId).execute();     // Catch: Throwable -> L86
        r.finishing = wasFinishing;     // Catch: Throwable -> L86
        if (res != 0) goto L95;
        boolean r9 = true;
    L96:
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L38
        monitor-exit(r7);     // Catch: Throwable -> L38
        WindowManagerService.resetPriorityAfterLockedSection();
        return r9;
    L95:
        r9 = r19;
        goto L96
    L86:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L91:
        r5 = null;
        goto L92
    L106:
        options = new SafeActivityOptions(ActivityOptions.makeBasic(), Binder.getCallingPid(), Binder.getCallingUid());     // Catch: Throwable -> L86
        goto L88
    L42:
        N = 0;
    L72:
        aInfo3 = aInfo;
    L71:
        r19 = false;
        goto L72
    L30:
        r0 = false;
    L38:
        th = th;
    L102:
        monitor-exit(r7);     // Catch: Throwable -> L38
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L17:
        th = th;
        goto L102
    L5:
        if (intent.hasFileDescriptors() == false) goto L9;
        throw new IllegalArgumentException("File descriptors passed in Intent");
    }

    boolean isDreaming() {
        if (this.mActiveDreamComponent == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean canLaunchDreamActivity(String packageName) {
        if (this.mActiveDreamComponent == null) goto L15;
        if (packageName == null) goto L15;
        if (packageName.equals(this.mActiveDreamComponent.getPackageName()) == false) goto L11;
        return true;
    L11:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_DREAM_enabled[4] == false) goto L13;
        String protoLogParam0 = String.valueOf(packageName);
        String protoLogParam1 = String.valueOf(String.valueOf(this.mActiveDreamComponent));
        ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_DEBUG_DREAM, -6981899770129924827L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L13:
        return false;
    L15:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_DREAM_enabled[4] == false) goto L17;
        String protoLogParam2 = String.valueOf(this.mActiveDreamComponent);
        String protoLogParam3 = String.valueOf(packageName);
        ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_DEBUG_DREAM, -3811526397232923712L, 0, new Object[]{protoLogParam2, protoLogParam3});
    L17:
        return false;
    }

    private IAppTask startDreamActivityInternal(Intent intent, int callingUid, int callingPid) {
        ActivityInfo a = new ActivityInfo();
        a.theme = R.style.Widget.Holo.QuickContactBadgeSmall.WindowMedium;
        a.exported = true;
        a.name = DreamActivity.class.getName();
        a.enabled = true;
        a.persistableMode = 1;
        a.screenOrientation = -1;
        a.colorMode = 0;
        a.flags |= 8388640;
        a.configChanges = -1;
        a.launchMode = 0;
        a.documentLaunchMode = 2;
        ActivityOptions options = ActivityOptions.makeBasic();
        options.setLaunchActivityType(5);
        WindowManagerGlobalLock r4 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r4);
        WindowProcessController process = this.mProcessMap.getProcess(callingPid);     // Catch: Throwable -> L13
        a.packageName = process.mInfo.packageName;     // Catch: Throwable -> L13
        a.applicationInfo = process.mInfo;     // Catch: Throwable -> L13
        a.processName = process.mName;     // Catch: Throwable -> L13
        a.uiOptions = process.mInfo.uiOptions;     // Catch: Throwable -> L13
        a.taskAffinity = "android:" + a.packageName + "/dream";     // Catch: Throwable -> L13
        ActivityRecord[] outActivity = new ActivityRecord[1];     // Catch: Throwable -> L13
        int res = getActivityStartController().obtainStarter(intent, "dream").setCallingUid(callingUid).setCallingPid(callingPid).setCallingPackage(intent.getPackage()).setActivityInfo(a).setActivityOptions(createSafeActivityOptionsWithBalAllowed(options)).setOutActivity(outActivity).setRealCallingUid(Binder.getCallingUid()).setAllowBalExemptionForSystemProcess(true).execute();     // Catch: Throwable -> L13
        ActivityRecord started = outActivity[0];     // Catch: Throwable -> L13
        if (started == null) goto L15;
        if (ActivityManager.isStartResultSuccessful(res) == false) goto L15;
        AppTaskImpl r7 = new AppTaskImpl(this, started.getTask().mTaskId, callingUid);     // Catch: Throwable -> L13
        monitor-exit(r4);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        return r7;
    L15:
        monitor-exit(r4);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L13:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public final WaitResult startActivityAndWait(IApplicationThread caller, String callingPackage, String callingFeatureId, Intent intent, String resolvedType, IBinder resultTo, String resultWho, int requestCode, int startFlags, ProfilerInfo profilerInfo, Bundle bOptions, int userId) {
        assertPackageMatchesCallingUid(callingPackage);
        WaitResult res = new WaitResult();
        enforceNotIsolatedCaller("startActivityAndWait");
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        int userId2 = handleIncomingUser(callingPid, callingUid, userId, "startActivityAndWait");
        SysOptBridge.getFactory().getKernelTrigger().notifyActivityStart(intent, callingPackage);
        SysOptBridge.getFactory().getColdStartTrim().tryColdStartTrim(intent, callingPackage);
        getActivityStartController().obtainStarter(intent, "startActivityAndWait").setCaller(caller).setCallingPackage(callingPackage).setCallingFeatureId(callingFeatureId).setResolvedType(resolvedType).setResultTo(resultTo).setResultWho(resultWho).setRequestCode(requestCode).setStartFlags(startFlags).setActivityOptions(bOptions, callingPid, callingUid).setUserId(userId2).setProfilerInfo(profilerInfo).setWaitResult(res).execute();
        return res;
    }

    public final int startActivityWithConfig(IApplicationThread caller, String callingPackage, String callingFeatureId, Intent intent, String resolvedType, IBinder resultTo, String resultWho, int requestCode, int startFlags, Configuration config, Bundle bOptions, int userId) {
        assertPackageMatchesCallingUid(callingPackage);
        enforceNotIsolatedCaller("startActivityWithConfig");
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        int userId2 = handleIncomingUser(callingPid, callingUid, userId, "startActivityWithConfig");
        return getActivityStartController().obtainStarter(intent, "startActivityWithConfig").setCaller(caller).setCallingPackage(callingPackage).setCallingFeatureId(callingFeatureId).setResolvedType(resolvedType).setResultTo(resultTo).setResultWho(resultWho).setRequestCode(requestCode).setStartFlags(startFlags).setGlobalConfiguration(config).setActivityOptions(bOptions, callingPid, callingUid).setUserId(userId2).execute();
    }

    public final int startActivityAsCaller(IApplicationThread caller, String callingPackage, Intent intent, String resolvedType, IBinder resultTo, String resultWho, int requestCode, int startFlags, ProfilerInfo profilerInfo, Bundle bOptions, boolean ignoreTargetSecurity, int userId) {
        WindowManagerGlobalLock r4 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r4);
        if (resultTo == null) goto L80;
        ActivityRecord sourceRecord = ActivityRecord.isInAnyTask(resultTo);     // Catch: Throwable -> L20
        if (sourceRecord == null) goto L78;
        if (sourceRecord.app == null) goto L74;
        if (checkCallingPermission("android.permission.START_ACTIVITY_AS_CALLER") != 0) goto L12;
    L24:
        if (ignoreTargetSecurity == true) goto L26;
    L34:
        int targetUid = sourceRecord.launchedFromUid;     // Catch: Throwable -> L20
        String targetPackage = sourceRecord.launchedFromPackage;     // Catch: Throwable -> L20
        String targetFeatureId = sourceRecord.launchedFromFeatureId;     // Catch: Throwable -> L20
        boolean isResolver = sourceRecord.isResolverOrChildActivity();     // Catch: Throwable -> L20
        monitor-exit(r4);     // Catch: Throwable -> L20
        WindowManagerService.resetPriorityAfterLockedSection();
        int userId2 = userId;
        if (userId2 != (-10000)) goto L86;
        userId2 = UserHandle.getUserId(sourceRecord.app.mUid);
    L86:
        ActivityStarter r0 = getActivityStartController().obtainStarter(intent, "startActivityAsCaller").setCallingUid(targetUid).setCallingPackage(targetPackage).setCallingFeatureId(targetFeatureId).setResolvedType(resolvedType).setResultTo(resultTo).setResultWho(resultWho).setRequestCode(requestCode).setStartFlags(startFlags).setActivityOptions(createSafeActivityOptionsWithBalAllowed(bOptions)).setUserId(userId2).setIgnoreTargetSecurity(ignoreTargetSecurity);     // Catch: SecurityException -> L57
        if (isResolver == false) goto L54;
        int r5 = 0;
    L55:
        return r0.setFilterCallingUid(r5).setAllowBalExemptionForSystemProcess(true).execute();
    L54:
        r5 = targetUid;
    L57:
        e = move-exception;
        throw e;
    L59:
        e = e;
    L71:
        throw e;
    L61:
        e = e;
    L63:
        e = e;
    L65:
        e = e;
    L67:
        e = e;
    L69:
        e = e;
        goto L71
    L26:
        if (intent.getComponent() == null) goto L33;
        if (intent.getSelector() == null) goto L34;
        throw new SecurityException("Selector not allowed with ignoreTargetSecurity");     // Catch: Throwable -> L20
    L33:
        throw new SecurityException("Component must be specified with ignoreTargetSecurity");     // Catch: Throwable -> L20
    L12:
        if (sourceRecord.info.packageName.equals(PackageManagerService.PLATFORM_PACKAGE_NAME) == false) goto L23;
        if (UserHandle.getAppId(sourceRecord.app.mUid) == 1000) goto L24;
        if (sourceRecord.app.mUid == sourceRecord.launchedFromUid) goto L24;
        throw new SecurityException("Calling activity in uid " + sourceRecord.app.mUid + " must be system uid or original calling uid " + sourceRecord.launchedFromUid);     // Catch: Throwable -> L20
    L23:
        throw new SecurityException("Must be called from an activity that is declared in the android package");     // Catch: Throwable -> L20
    L74:
        throw new SecurityException("Called without a process attached to activity");     // Catch: Throwable -> L75
    L78:
        throw new SecurityException("Called with bad activity token: " + resultTo);     // Catch: Throwable -> L75
    L20:
        th = th;
    L81:
        monitor-exit(r4);     // Catch: Throwable -> L75
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L80:
        throw new SecurityException("Must be called from an activity");     // Catch: Throwable -> L75
    L75:
        th = th;
        goto L81
    }

    int handleIncomingUser(int callingPid, int callingUid, int userId, String name) {
        return this.mAmInternal.handleIncomingUser(callingPid, callingUid, userId, false, 0, name, null);
    }

    public int startVoiceActivity(String callingPackage, String callingFeatureId, int callingPid, int callingUid, Intent intent, String resolvedType, IVoiceInteractionSession session, IVoiceInteractor interactor, int startFlags, ProfilerInfo profilerInfo, Bundle bOptions, int userId) {
        assertPackageMatchesCallingUid(callingPackage);
        this.mAmInternal.enforceCallingPermission("android.permission.BIND_VOICE_INTERACTION", "startVoiceActivity()");
        if (session == null) goto L8;
        if (interactor == null) goto L8;
        int userId2 = handleIncomingUser(callingPid, callingUid, userId, "startVoiceActivity");
        return getActivityStartController().obtainStarter(intent, "startVoiceActivity").setCallingUid(callingUid).setCallingPackage(callingPackage).setCallingFeatureId(callingFeatureId).setResolvedType(resolvedType).setVoiceSession(session).setVoiceInteractor(interactor).setStartFlags(startFlags).setProfilerInfo(profilerInfo).setActivityOptions(createSafeActivityOptionsWithBalAllowed(bOptions)).setUserId(userId2).setAllowBalExemptionForSystemProcess(true).execute();
    L8:
        throw new NullPointerException("null session or interactor");
    }

    public String getVoiceInteractorPackageName(IBinder callingVoiceInteractor) {
        return ((VoiceInteractionManagerInternal) LocalServices.getService(VoiceInteractionManagerInternal.class)).getVoiceInteractorPackageName(callingVoiceInteractor);
    }

    public int startAssistantActivity(String callingPackage, String callingFeatureId, int callingPid, int callingUid, Intent intent, String resolvedType, Bundle bOptions, int userId) {
        assertPackageMatchesCallingUid(callingPackage);
        this.mAmInternal.enforceCallingPermission("android.permission.BIND_VOICE_INTERACTION", "startAssistantActivity()");
        int userId2 = handleIncomingUser(callingPid, callingUid, userId, "startAssistantActivity");
        long origId = Binder.clearCallingIdentity();
        int r0 = getActivityStartController().obtainStarter(intent, "startAssistantActivity").setCallingUid(callingUid).setCallingPackage(callingPackage).setCallingFeatureId(callingFeatureId).setResolvedType(resolvedType).setActivityOptions(createSafeActivityOptionsWithBalAllowed(bOptions)).setUserId(userId2).setAllowBalExemptionForSystemProcess(true).execute();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(origId);
        return r0;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void preloadRecentsActivity(Intent intent) {
        enforceTaskPermission("preloadRecentsActivity()");
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r3 = this.mGlobalLock;     // Catch: Throwable -> L21
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L21
        monitor-enter(r3);     // Catch: Throwable -> L21
        ComponentName recentsComponent = this.mRecentTasks.getRecentsComponent();     // Catch: Throwable -> L16
        String recentsFeatureId = this.mRecentTasks.getRecentsComponentFeatureId();     // Catch: Throwable -> L16
        int recentsUid = this.mRecentTasks.getRecentsComponentUid();     // Catch: Throwable -> L16
        RecentsAnimation anim = new RecentsAnimation(this, this.mTaskSupervisor, getActivityStartController(), intent, recentsComponent, recentsFeatureId, recentsUid);     // Catch: Throwable -> L14
        anim.preloadRecentsActivity();     // Catch: Throwable -> L14
        monitor-exit(r3);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(origId);
        return;
    L16:
        th = move-exception;
        Throwable r13 = th;
    L18:
        monitor-exit(r3);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L12
        throw r13;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Throwable r14 = th;
    L23:
        Binder.restoreCallingIdentity(origId);
        throw r14;
    L14:
        th = move-exception;
        r13 = th;
    L21:
        th = move-exception;
        r14 = th;
        goto L23
    }

    public final int startActivityFromRecents(int taskId, Bundle bOptions) {
        this.mAmInternal.enforceCallingPermission("android.permission.START_TASKS_FROM_RECENTS", "startActivityFromRecents()");
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        SafeActivityOptions safeOptions = SafeActivityOptions.fromBundle(bOptions, callingPid, callingUid);
        long origId = Binder.clearCallingIdentity();
        int result = this.mTaskSupervisor.startActivityFromRecents(callingPid, callingUid, taskId, safeOptions);     // Catch: Throwable -> L7
        if (ActivityManager.isStartResultSuccessful(result) == true) goto L9;
        Slog.w("ActivityTaskManager", "startActivityFromRecents start fail, result: " + result);     // Catch: Throwable -> L7
    L9:
        Binder.restoreCallingIdentity(origId);
        return result;
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public int startActivityFromGameSession(IApplicationThread caller, String callingPackage, String callingFeatureId, int callingPid, int callingUid, Intent intent, int taskId, int userId) {
        if (checkCallingPermission("android.permission.MANAGE_GAME_ACTIVITY") != 0) goto L11;
        assertPackageMatchesCallingUid(callingPackage);
        this.mAmInternal.addCreatorToken(intent, callingPackage);
        ActivityOptions activityOptions = ActivityOptions.makeBasic();
        activityOptions.setLaunchTaskId(taskId);
        SafeActivityOptions safeOptions = new SafeActivityOptions(activityOptions, Process.myPid(), 1000);
        int userId2 = handleIncomingUser(callingPid, callingUid, userId, "startActivityFromGameSession");
        long origId = Binder.clearCallingIdentity();
        int r2 = getActivityStartController().obtainStarter(intent, "startActivityFromGameSession").setCaller(caller).setCallingUid(callingUid).setCallingPid(callingPid).setCallingPackage(intent.getPackage()).setCallingFeatureId(callingFeatureId).setUserId(userId2).setActivityOptions(safeOptions).setRealCallingUid(Binder.getCallingUid()).execute();     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(origId);
        return r2;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L11:
        String msg = "Permission Denial: startActivityFromGameSession() from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " requires android.permission.MANAGE_GAME_ACTIVITY";
        Slog.w("ActivityTaskManager", msg);
        throw new SecurityException(msg);
    }

    public BackNavigationInfo startBackNavigation(RemoteCallback navigationObserver, BackAnimationAdapter adapter) {
        this.mAmInternal.enforceCallingPermission("android.permission.START_TASKS_FROM_RECENTS", "startBackNavigation()");
        long origId = Binder.clearCallingIdentity();
        BackNavigationInfo r2 = this.mBackNavigationController.startBackNavigation(navigationObserver, adapter);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(origId);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void registerBackGestureDelegate(RemoteCallback requestObserver) {
        this.mAmInternal.enforceCallingPermission("android.permission.START_TASKS_FROM_RECENTS", "registerBackGestureDelegate()");
        long origId = Binder.clearCallingIdentity();
        this.mBackNavigationController.registerBackGestureDelegate(requestObserver);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(origId);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public final boolean isActivityStartAllowedOnDisplay(int displayId, Intent intent, String resolvedType, int userId) {
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        long origId = Binder.clearCallingIdentity();
        ActivityInfo aInfo = resolveActivityInfoForIntent(intent, resolvedType, userId, callingUid, callingPid);     // Catch: Throwable -> L14
        WindowManagerGlobalLock r12 = this.mGlobalLock;     // Catch: Throwable -> L14
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L14
        monitor-enter(r12);     // Catch: Throwable -> L14
        boolean r13 = this.mTaskSupervisor.canPlaceEntityOnDisplay(displayId, callingPid, callingUid, aInfo);     // Catch: Throwable -> L9
        monitor-exit(r12);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r13;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    ActivityInfo resolveActivityInfoForIntent(Intent intent, String resolvedType, int userId, int callingUid, int callingPid) {
        ActivityInfo aInfo = this.mTaskSupervisor.resolveActivity(intent, resolvedType, 0, null, userId, ActivityStarter.computeResolveFilterUid(callingUid, callingUid, ProcessList.INVALID_ADJ), callingPid);
        return this.mAmInternal.getActivityInfoForUser(aInfo, userId);
    }

    public IActivityClientController getActivityClientController() {
        return this.mActivityClientController;
    }

    void applyUpdateLockStateLocked(final ActivityRecord r) {
        if (r != null) goto L4;
    L6:
        final boolean nextState = false;
    L7:
        this.mH.post(new ActivityTaskManagerService$$ExternalSyntheticLambda24(this, nextState, r));
        return;
    L4:
        if (r.immersive == false) goto L6;
        nextState = true;
        goto L7
    }

    private /* synthetic */ void lambda$applyUpdateLockStateLocked$0(boolean nextState, ActivityRecord r) {
        if (this.mUpdateLock.isHeld() != nextState) goto L5;
        return;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IMMERSIVE_enabled[0] == false) goto L7;
        String protoLogParam0 = String.valueOf(nextState);
        String protoLogParam1 = String.valueOf(r);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_IMMERSIVE, 6075150529915862250L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L7:
        if (nextState == false) goto L9;
        this.mUpdateLock.acquire();
        return;
    L9:
        this.mUpdateLock.release();
    }

    public boolean isTopActivityImmersive() {
        enforceNotIsolatedCaller("isTopActivityImmersive");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Task topFocusedRootTask = getTopDisplayFocusedRootTask();     // Catch: Throwable -> L9
        boolean r2 = false;
        if (topFocusedRootTask != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L11:
        ActivityRecord r = topFocusedRootTask.topRunningActivity();     // Catch: Throwable -> L9
        if (r != null) goto L14;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L14:
        if (r.immersive == false) goto L16;
        r2 = true;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public int getFrontActivityScreenCompatMode() {
        enforceNotIsolatedCaller("getFrontActivityScreenCompatMode");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Task rootTask = getTopDisplayFocusedRootTask();     // Catch: Throwable -> L7
        if (rootTask == null) goto L9;
        ActivityRecord r = rootTask.topRunningActivity();     // Catch: Throwable -> L7
    L10:
        if (r != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return -3;
    L14:
        int r3 = this.mCompatModePackages.computeCompatModeLocked(r.info.applicationInfo);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return r3;
    L9:
        r = null;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void setFrontActivityScreenCompatMode(int mode) {
        this.mAmInternal.enforceCallingPermission("android.permission.SET_SCREEN_COMPATIBILITY", "setFrontActivityScreenCompatMode");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Task rootTask = getTopDisplayFocusedRootTask();     // Catch: Throwable -> L7
        if (rootTask == null) goto L9;
        ActivityRecord r = rootTask.topRunningActivity();     // Catch: Throwable -> L7
    L10:
        if (r != null) goto L15;
        Slog.w("ActivityTaskManager", "setFrontActivityScreenCompatMode failed: no top activity");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L15:
        ApplicationInfo ai = r.info.applicationInfo;     // Catch: Throwable -> L7
        this.mCompatModePackages.setPackageScreenCompatModeLocked(ai, mode);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        r = null;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public ActivityTaskManager.RootTaskInfo getFocusedRootTaskInfo() throws RemoteException {
        enforceTaskPermission("getFocusedRootTaskInfo()");
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L19
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L19
        monitor-enter(r2);     // Catch: Throwable -> L19
        Task focusedRootTask = getTopDisplayFocusedRootTask();     // Catch: Throwable -> L11
        if (focusedRootTask == null) goto L13;
        ActivityTaskManager.RootTaskInfo r4 = this.mRootWindowContainer.getRootTaskInfo(focusedRootTask.mTaskId);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return r4;
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return null;
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void setFocusedRootTask(int taskId) {
        enforceTaskPermission("setFocusedRootTask()");
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_enabled[0] == false) goto L5;
        long protoLogParam0 = taskId;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_FOCUS, -4356952232698761083L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L5:
        long callingId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L28
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L28
        monitor-enter(r2);     // Catch: Throwable -> L28
        Task task = this.mRootWindowContainer.getRootTask(taskId);     // Catch: Throwable -> L14
        if (task != null) goto L16;
        Slog.w("ActivityTaskManager", "setFocusedRootTask: No task with id=" + taskId);     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(callingId);
        return;
    L16:
        ActivityRecord r = task.topRunningActivity();     // Catch: Throwable -> L14
        if (r != null) goto L19;
    L24:
        monitor-exit(r2);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L28
        Binder.restoreCallingIdentity(callingId);
        return;
    L19:
        if (r.app == null) goto L22;
        r.app.getWPCSmtEx().bringProcessToDefaultLocked();     // Catch: Throwable -> L14
    L22:
        if (r.moveFocusableActivityToTop("setFocusedRootTask") == false) goto L24;
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    }

    public void setFocusedTask(int taskId) {
        enforceTaskPermission("setFocusedTask()");
        long callingId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L11
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L11
        monitor-enter(r2);     // Catch: Throwable -> L11
        setFocusedTask(taskId, null);     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(callingId);
        return;
    L13:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    }

    public void focusTopTask(int displayId) {
        enforceTaskPermission("focusTopTask()");
        long callingId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L22
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L22
        monitor-enter(r2);     // Catch: Throwable -> L22
        DisplayContent dc = this.mRootWindowContainer.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (dc != null) goto L12;
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(callingId);
        return;
    L12:
        Task task = dc.getTask(new ActivityTaskManagerService$$ExternalSyntheticLambda2(), true);     // Catch: Throwable -> L10
        if (task != null) goto L17;
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(callingId);
        return;
    L17:
        setFocusedTask(task.mTaskId, null);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L22
        Binder.restoreCallingIdentity(callingId);
        return;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    }

    private static /* synthetic */ boolean lambda$focusTopTask$1(Task t) {
        if (t.isLeafTask() == true) goto L5;
    L9:
        return false;
    L5:
        if (t.isTopActivityFocusable() == false) goto L9;
        if (t.getExt().isMiniMode() == true) goto L9;
        return true;
    }

    void setFocusedTask(int taskId, ActivityRecord touchedActivity) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_enabled[0] == false) goto L5;
        long protoLogParam0 = taskId;
        String protoLogParam1 = String.valueOf(touchedActivity);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_FOCUS, 301842347780487555L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
    L5:
        Task task = this.mRootWindowContainer.anyTaskForId(taskId, 0);
        if (task != null) goto L8;
        return;
    L8:
        ActivityRecord r = task.topRunningActivityLocked();
        if (r != null) goto L11;
        return;
    L11:
        if (touchedActivity == null) goto L14;
        if (r == touchedActivity) goto L14;
    L20:
        if (getTransitionController().isCollecting() == false) goto L22;
    L25:
        Transition transition = null;
    L27:
        if (transition == null) goto L29;
        transition.setReady(task, true);
    L29:
        boolean movedToTop = r.moveFocusableActivityToTop("setFocusedTask");
        if (movedToTop == false) goto L34;
        if (transition == null) goto L33;
        getTransitionController().requestStartTransition(transition, null, null, null);
    L33:
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();
    L42:
        if (transition == null) goto L46;
        if (movedToTop == true) goto L47;
        transition.abort();
        return;
    L47:
        return;
    L46:
        return;
    L34:
        if (touchedActivity == null) goto L42;
        if (touchedActivity.isFocusable() == false) goto L42;
        TaskFragment parent = touchedActivity.getTaskFragment();
        if (parent == null) goto L42;
        if (parent.isEmbedded() == false) goto L42;
        DisplayContent displayContent = touchedActivity.getDisplayContent();
        displayContent.setFocusedApp(touchedActivity);
        this.mWindowManager.updateFocusedWindowLocked(0, true);
        goto L42
    L22:
        if (getTransitionController().isShellTransitionsEnabled() == false) goto L25;
        transition = getTransitionController().createTransition(3);
    L14:
        if (r.isState(ActivityRecord.State.RESUMED) == false) goto L20;
        if (r != this.mRootWindowContainer.getTopResumedActivity()) goto L20;
        setLastResumedActivityUncheckLocked(r, "setFocusedTask-alreadyTop");
    }

    public boolean setTaskIsPerceptible(int taskId, boolean isPerceptible) {
        enforceTaskPermission("setTaskIsPerceptible()");
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L18
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L18
        monitor-enter(r2);     // Catch: Throwable -> L18
        Task task = this.mRootWindowContainer.anyTaskForId(taskId, 0);     // Catch: Throwable -> L11
        if (task != null) goto L13;
        Slog.w("ActivityTaskManager", "setTaskIsPerceptible: No task to set with id=" + taskId);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return false;
    L13:
        task.mIsPerceptible = isPerceptible;     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(ident);
        return true;
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public boolean removeTask(int taskId) {
        this.mAmInternal.enforceCallingPermission("android.permission.REMOVE_TASKS", "removeTask()");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L12
        Task task = this.mRootWindowContainer.anyTaskForId(taskId, 1);     // Catch: Throwable -> L14
        if (task != null) goto L16;
        Slog.w("ActivityTaskManager", "removeTask: No task remove with id=" + taskId);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L16:
        removeTask(task);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void removeTask(Task task) {
        if (task.isLeafTask() == false) goto L5;
        this.mTaskSupervisor.removeTask(task, true, true, "remove-task");
        return;
    L5:
        this.mTaskSupervisor.removeRootTask(task);
    }

    public boolean canBeUniversalResizeable(ApplicationInfo appInfo) {
        return ActivityRecord.canBeUniversalResizeable(appInfo, this.mWindowManager, true, false);
    }

    public void removeAllVisibleRecentTasks() {
        this.mAmInternal.enforceCallingPermission("android.permission.REMOVE_TASKS", "removeAllVisibleRecentTasks()");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
        getRecentTasks().removeAllVisibleTasks(this.mAmInternal.getCurrentUserId());     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public Rect getTaskBounds(int taskId) {
        enforceTaskPermission("getTaskBounds()");
        long ident = Binder.clearCallingIdentity();
        Rect rect = new Rect();
        WindowManagerGlobalLock r3 = this.mGlobalLock;     // Catch: Throwable -> L23
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L23
        monitor-enter(r3);     // Catch: Throwable -> L23
        Task task = this.mRootWindowContainer.anyTaskForId(taskId, 1);     // Catch: Throwable -> L11
        if (task != null) goto L14;
        Slog.w("ActivityTaskManager", "getTaskBounds: taskId=" + taskId + " not found");     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return rect;
    L14:
        if (task.getParent() == null) goto L17;
        rect.set(task.getBounds());     // Catch: Throwable -> L11
    L19:
        monitor-exit(r3);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L23
        Binder.restoreCallingIdentity(ident);
        return rect;
    L17:
        if (task.mLastNonFullscreenBounds == null) goto L19;
        rect.set(task.mLastNonFullscreenBounds);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void setLocusId(LocusId locusId, IBinder appToken) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(appToken);     // Catch: Throwable -> L7
        if (r == null) goto L9;
        r.setLocusId(locusId);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    NeededUriGrants collectGrants(Intent intent, ActivityRecord target) {
        if (target != null) goto L4;
        return null;
    L4:
        return this.mUgmInternal.checkGrantUriPermissionFromIntent(intent, Binder.getCallingUid(), target.packageName, target.mUserId);
    }

    public void unhandledBack() {
        this.mAmInternal.enforceCallingPermission("android.permission.FORCE_BACK", "unhandledBack()");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long origId = Binder.clearCallingIdentity();     // Catch: Throwable -> L15
        Task topFocusedRootTask = getTopDisplayFocusedRootTask();     // Catch: Throwable -> L9
        if (topFocusedRootTask == null) goto L11;
        topFocusedRootTask.unhandledBackLocked();     // Catch: Throwable -> L9
    L11:
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void moveTaskToFront(IApplicationThread appThread, String callingPackage, int taskId, int flags, Bundle bOptions) {
        this.mAmInternal.enforceCallingPermission("android.permission.REORDER_TASKS", "moveTaskToFront()");
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L5;
        long protoLogParam0 = taskId;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, 7095858131234795548L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L5:
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        int callingPid = Binder.getCallingPid();     // Catch: Throwable -> L15
        int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L15
        moveTaskToFrontLocked(appThread, callingPackage, taskId, flags, SafeActivityOptions.fromBundle(bOptions, callingPid, callingUid));     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L13:
        th = move-exception;
        Throwable r10 = th;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        throw r10;
    L15:
        th = move-exception;
        r10 = th;
        goto L17
    }

    void moveTaskToFrontLocked(IApplicationThread appThread, String callingPackage, int taskId, int flags, SafeActivityOptions options) {
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        assertPackageMatchesCallingUid(callingPackage);
        long origId = Binder.clearCallingIdentity();
        if (appThread == null) goto L5;
        WindowProcessController callerApp = getProcessController(appThread);
        WindowProcessController callerApp2 = callerApp;
    L6:
        BackgroundActivityStartController balController = this.mTaskSupervisor.getBackgroundActivityLaunchController();
        BackgroundActivityStartController.BalVerdict balVerdict = balController.checkBackgroundActivityStart(callingUid, callingPid, callingPackage, -1, -1, callerApp2, null, false, null, null, null);
        if (balVerdict.blocks() == false) goto L13;
        if (isBackgroundActivityStartsEnabled() == true) goto L13;
        Slog.w("ActivityTaskManager", "moveTaskToFront blocked: " + balVerdict);
        return;
    L13:
        if (ActivityTaskManagerDebugConfig.DEBUG_ACTIVITY_STARTS == false) goto L38;
        Slog.d("ActivityTaskManager", "moveTaskToFront allowed: " + balVerdict);
    L38:
        Task task = this.mRootWindowContainer.anyTaskForId(taskId);     // Catch: Throwable -> L20
        if (task != null) goto L26;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L22;
        long protoLogParam0 = taskId;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, -4458288191054594222L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L20
    L22:
        SafeActivityOptions.abort(options);     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(origId);
        return;
    L26:
        if (getLockTaskController().isLockTaskModeViolation(task) == false) goto L30;
        Slog.e("ActivityTaskManager", "moveTaskToFront: Attempt to violate Lock Task Mode");     // Catch: Throwable -> L20
        SafeActivityOptions.abort(options);     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(origId);
        return;
    L30:
        if (options == null) goto L32;
        ActivityOptions realOptions = options.getOptions(this.mTaskSupervisor);     // Catch: Throwable -> L20
    L33:
        this.mTaskSupervisor.findTaskToMoveToFront(task, flags, realOptions, "moveTaskToFront", false);     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(origId);
        return;
    L32:
        realOptions = null;
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L5:
        callerApp2 = null;
        goto L6
    }

    private boolean isSameApp(int callingUid, String packageName) {
        if (callingUid != 0) goto L4;
        return true;
    L4:
        if (callingUid != 1000) goto L6;
        return true;
    L6:
        return this.mPmInternal.isSameApp(packageName, callingUid, UserHandle.getUserId(callingUid));
    }

    void assertPackageMatchesCallingUid(String packageName) {
        int callingUid = Binder.getCallingUid();
        if (isSameApp(callingUid, packageName) == false) goto L5;
        return;
    L5:
        String msg = "Permission Denial: package=" + packageName + " does not belong to uid=" + callingUid;
        Slog.w("ActivityTaskManager", msg);
        throw new SecurityException(msg);
    }

    int getBalAppSwitchesState() {
        return this.mAppSwitchesState;
    }

    public void registerAnrController(android.app.AnrController controller) {
        List<android.app.AnrController> r0 = this.mAnrController;
        monitor-enter(r0);
        this.mAnrController.add(controller);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unregisterAnrController(android.app.AnrController controller) {
        List<android.app.AnrController> r0 = this.mAnrController;
        monitor-enter(r0);
        this.mAnrController.remove(controller);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public android.app.AnrController getAnrController(ApplicationInfo info) {
        if (info != null) goto L4;
        return null;
    L4:
        if (info.packageName == null) goto L34;
        List<android.app.AnrController> r0 = this.mAnrController;
        monitor-enter(r0);
        ArrayList<android.app.AnrController> controllers = new ArrayList(this.mAnrController);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        String packageName = info.packageName;
        int uid = info.uid;
        long maxDelayMs = 0;
        android.app.AnrController controllerWithMaxDelay = null;
        Iterator<android.app.AnrController> r6 = controllers.iterator();
    L12:
        if (r6.hasNext() == false) goto L19;
        android.app.AnrController controller = r6.next();
        long delayMs = controller.getAnrDelayMillis(packageName, uid);
        if (delayMs <= 0) goto L12;
        if (delayMs <= maxDelayMs) goto L12;
        controllerWithMaxDelay = controller;
        maxDelayMs = delayMs;
        goto L12
    L19:
        return controllerWithMaxDelay;
    L20:
        th = move-exception;
        throw th;
    L34:
        return null;
    }

    public void setActivityController(IActivityController controller, boolean imAMonkey) {
        this.mAmInternal.enforceCallingPermission("android.permission.SET_ACTIVITY_WATCHER", "setActivityController()");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mController = controller;     // Catch: Throwable -> L8
        this.mControllerIsAMonkey = imAMonkey;     // Catch: Throwable -> L8
        Watchdog.getInstance().setActivityController(controller, imAMonkey);     // Catch: Throwable -> L8
        getSmtEx().setControllerLocked(controller, imAMonkey);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean isControllerAMonkey() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mController != null) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return r1;
    L7:
        if (this.mControllerIsAMonkey == false) goto L11;
        r1 = true;
        goto L12
    }

    public List<ActivityManager.RunningTaskInfo> getTasks(int maxNum) {
        return getTasks(maxNum, false, false, -1);
    }

    public List<ActivityManager.RunningTaskInfo> getTasks(int maxNum, boolean filterOnlyVisibleRecents, boolean keepIntentExtra) {
        return getTasks(maxNum, filterOnlyVisibleRecents, keepIntentExtra, -1);
    }

    public List<ActivityManager.RunningTaskInfo> getTasks(int r13, boolean r14, boolean r15, int r16) {
        int r5 = Binder.getCallingUid();
        int r8 = Binder.getCallingPid();
        int r1 = 0;
        if (r15 == false) goto L5;
        int r2 = 8;
    L6:
        int r0 = (r14 ? 1 : 0) | r2;
        if (isCrossUserAllowed(r8, r5) == false) goto L9;
        int r3 = 4;
    L10:
        int r4 = r3 | r0;
        int[] r10 = getUserManager().getProfileIds(UserHandle.getUserId(r5), true);
        ArraySet<Integer> r6 = new ArraySet();
        int r7 = 0;
    L12:
        if (r7 >= r10.length) goto L14;
        r6.add(Integer.valueOf(r10[r7]));
        r7 = r7 + 1;
        goto L12
    L14:
        ArrayList r9 = new ArrayList();
        WindowManagerGlobalLock r11 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r11);
    L19:
        th = th;
    L31:
        monitor-exit(r11);     // Catch: Throwable -> L19
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L17:
        if (ActivityTaskManagerDebugConfig.DEBUG_ALL == false) goto L22;
        Slog.v("ActivityTaskManager", "getTasks: max=" + r13);     // Catch: Throwable -> L19
    L22:
        if (isGetTasksAllowed("getTasks", r8, r5) == false) goto L35;
        r1 = 2;
    L35:
        this.mRootWindowContainer.getRunningTasks(r13, r9, r4 | r1, r5, r6, r16);     // Catch: Throwable -> L29
        monitor-exit(r11);     // Catch: Throwable -> L29
        WindowManagerService.resetPriorityAfterLockedSection();
        return r9;
    L29:
        th = th;
        goto L31
    L9:
        r3 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public void moveTaskToRootTask(int taskId, int rootTaskId, boolean toTop) {
        enforceTaskPermission("moveTaskToRootTask()");
        WindowManagerGlobalLock r4 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r4);
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L12
        Task task = this.mRootWindowContainer.anyTaskForId(taskId);     // Catch: Throwable -> L14
        if (task != null) goto L17;
        Slog.w("ActivityTaskManager", "moveTaskToRootTask: No task for id=" + taskId);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L12
        monitor-exit(r4);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L17:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L19;
        long protoLogParam0 = taskId;
        long protoLogParam1 = rootTaskId;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, -1136891560663761442L, 53, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1), Boolean.valueOf(toTop)});     // Catch: Throwable -> L14
    L19:
        Task rootTask = this.mRootWindowContainer.getRootTask(rootTaskId);     // Catch: Throwable -> L14
        if (rootTask == null) goto L31;
        if (rootTask.isActivityTypeStandardOrUndefined() == false) goto L29;
        task.reparent(rootTask, toTop, 1, true, false, "moveTaskToRootTask");     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L12
        monitor-exit(r4);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L29:
        throw new IllegalArgumentException("moveTaskToRootTask: Attempt to move task " + taskId + " to rootTask " + rootTaskId);     // Catch: Throwable -> L14
    L31:
        throw new IllegalStateException("moveTaskToRootTask: No rootTask for rootTaskId=" + rootTaskId);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void removeRootTasksInWindowingModes(int[] windowingModes) {
        enforceTaskPermission("removeRootTasksInWindowingModes()");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
        this.mRootWindowContainer.removeRootTasksInWindowingModes(windowingModes);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void removeRootTasksWithActivityTypes(int[] activityTypes) {
        enforceTaskPermission("removeRootTasksWithActivityTypes()");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
        this.mRootWindowContainer.removeRootTasksWithActivityTypes(activityTypes);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public ParceledListSlice<ActivityManager.RecentTaskInfo> getRecentTasks(int maxNum, int flags, int userId) {
        int callingUid = Binder.getCallingUid();
        int userId2 = handleIncomingUser(Binder.getCallingPid(), callingUid, userId, "getRecentTasks");
        boolean allowed = isGetTasksAllowed("getRecentTasks", Binder.getCallingPid(), callingUid);
        if (this.mAmInternal.isUserRunning(userId2, 4) == true) goto L6;
        Slog.i("ActivityTaskManager", "User " + userId2 + " is locked. Cannot load recents");
        return ParceledListSlice.emptyList();
    L6:
        this.mRecentTasks.loadRecentTasksIfNeeded(userId2);
        WindowManagerGlobalLock r9 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r9);
        ParceledListSlice<ActivityManager.RecentTaskInfo> r7 = this.mRecentTasks.getRecentTasks(maxNum, flags, allowed, userId2, callingUid);     // Catch: Throwable -> L14
        monitor-exit(r9);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        return r7;
    L14:
        th = move-exception;
        Throwable r8 = th;
    L18:
        monitor-exit(r9);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        throw r8;
    L16:
        th = move-exception;
        r8 = th;
        goto L18
    }

    public List<ActivityTaskManager.RootTaskInfo> getAllRootTaskInfos() {
        enforceTaskPermission("getAllRootTaskInfos()");
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L13
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L13
        monitor-enter(r2);     // Catch: Throwable -> L13
        ArrayList<ActivityTaskManager.RootTaskInfo> r3 = this.mRootWindowContainer.getAllRootTaskInfos(-1);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return r3;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public ActivityTaskManager.RootTaskInfo getRootTaskInfo(int windowingMode, int activityType) {
        enforceTaskPermission("getRootTaskInfo()");
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L13
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L13
        monitor-enter(r2);     // Catch: Throwable -> L13
        ActivityTaskManager.RootTaskInfo r3 = this.mRootWindowContainer.getRootTaskInfo(windowingMode, activityType);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return r3;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public List<ActivityTaskManager.RootTaskInfo> getAllRootTaskInfosOnDisplay(int displayId) {
        enforceTaskPermission("getAllRootTaskInfosOnDisplay()");
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L13
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L13
        monitor-enter(r2);     // Catch: Throwable -> L13
        ArrayList<ActivityTaskManager.RootTaskInfo> r3 = this.mRootWindowContainer.getAllRootTaskInfos(displayId);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return r3;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public ActivityTaskManager.RootTaskInfo getRootTaskInfoOnDisplay(int windowingMode, int activityType, int displayId) {
        enforceTaskPermission("getRootTaskInfoOnDisplay()");
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L13
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L13
        monitor-enter(r2);     // Catch: Throwable -> L13
        ActivityTaskManager.RootTaskInfo r3 = this.mRootWindowContainer.getRootTaskInfo(windowingMode, activityType, displayId);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return r3;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void startSystemLockTaskMode(int taskId) {
        enforceTaskPermission("startSystemLockTaskMode");
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L17
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L17
        monitor-enter(r2);     // Catch: Throwable -> L17
        Task task = this.mRootWindowContainer.anyTaskForId(taskId, 0);     // Catch: Throwable -> L10
        if (task != null) goto L12;
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return;
    L12:
        task.getRootTask().moveToFront("startSystemLockTaskMode");     // Catch: Throwable -> L10
        startLockTaskMode(task, true);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(ident);
        return;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void stopSystemLockTaskMode() throws RemoteException {
        enforceTaskPermission("stopSystemLockTaskMode");
        stopLockTaskModeInternal(null, true);
    }

    public void rebuildSystemLockTaskPinnedMode() {
        enforceTaskPermission("rebuildSystemLockTaskPinnedMode");
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L10
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L10
        monitor-enter(r2);     // Catch: Throwable -> L10
        getLockTaskController().rebuildSystemLockTaskPinnedMode();     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    void startLockTaskMode(Task task, boolean isSystemCaller) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_LOCKTASK_enabled[3] == false) goto L5;
        String protoLogParam0 = String.valueOf(task);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_LOCKTASK, 6954122272402912822L, 0, new Object[]{protoLogParam0});
    L5:
        if (task != null) goto L7;
        return;
    L7:
        if (task.mLockTaskAuth == 0) goto L25;
        Task rootTask = this.mRootWindowContainer.getTopDisplayFocusedRootTask();
        if (rootTask == null) goto L21;
        if (task != rootTask.getTopMostTask()) goto L21;
        int callingUid = Binder.getCallingUid();
        long ident = Binder.clearCallingIdentity();
        getLockTaskController().startLockTaskMode(task, isSystemCaller, callingUid);     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(ident);
        return;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L21:
        throw new IllegalArgumentException("Invalid task, not in foreground");
    }

    void stopLockTaskModeInternal(IBinder token, boolean isSystemCaller) {
        int callingUid = Binder.getCallingUid();
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r3 = this.mGlobalLock;     // Catch: Throwable -> L21
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L21
        monitor-enter(r3);     // Catch: Throwable -> L21
        Task task = null;
        if (token != null) goto L31;
    L15:
        getLockTaskController().stopLockTaskMode(task, isSystemCaller, callingUid);     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L21
        TelecomManager tm = (TelecomManager) this.mContext.getSystemService("telecom");     // Catch: Throwable -> L21
        if (tm == null) goto L23;
        tm.showInCallScreen(false);     // Catch: Throwable -> L21
    L23:
        Binder.restoreCallingIdentity(ident);
        return;
    L31:
        ActivityRecord r = ActivityRecord.forTokenLocked(token);     // Catch: Throwable -> L12
        if (r != null) goto L14;
        monitor-exit(r3);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return;
    L14:
        task = r.getTask();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void updateLockTaskPackages(int userId, String[] packages) {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 0) goto L5;
    L7:
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r3 = this.mGlobalLock;     // Catch: Throwable -> L20
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L20
        monitor-enter(r3);     // Catch: Throwable -> L20
    L13:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L11:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_LOCKTASK_enabled[3] == false) goto L15;
        long protoLogParam0 = userId;
        String protoLogParam1 = String.valueOf(Arrays.toString(packages));     // Catch: Throwable -> L13
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_LOCKTASK, -829638795650515884L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});     // Catch: Throwable -> L13
    L15:
        getLockTaskController().updateLockTaskPackages(userId, packages);     // Catch: Throwable -> L13
        monitor-exit(r3);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(origId);
        return;
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L5:
        if (callingUid == 1000) goto L7;
        this.mAmInternal.enforceCallingPermission("android.permission.UPDATE_LOCK_TASK_PACKAGES", "updateLockTaskPackages()");
        goto L7
    }

    public boolean isInLockTaskMode() {
        if (getLockTaskModeState() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getLockTaskModeState() {
        return getLockTaskController().getLockTaskModeState();
    }

    public List<IBinder> getAppTasks(String callingPackage) {
        assertPackageMatchesCallingUid(callingPackage);
        return getAppTasks(callingPackage, Binder.getCallingUid());
    }

    private List<IBinder> getAppTasks(String pkgName, int uid) {
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L13
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L13
        monitor-enter(r2);     // Catch: Throwable -> L13
        ArrayList<IBinder> r3 = this.mRecentTasks.getAppTasksList(uid, pkgName);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return r3;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void finishVoiceTask(IVoiceInteractionSession session) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long origId = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
        this.mRootWindowContainer.finishVoiceTask(session);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void reportAssistContextExtras(IBinder assistToken, Bundle extras, AssistStructure structure, AssistContent content, Uri referrer) {
        PendingAssistExtras pae = (PendingAssistExtras) assistToken;
        monitor-enter(pae);
        pae.result = extras;     // Catch: Throwable -> L7
        pae.structure = structure;     // Catch: Throwable -> L7
        pae.content = content;     // Catch: Throwable -> L7
        if (referrer == null) goto L10;
        pae.extras.putParcelable("android.intent.extra.REFERRER", referrer);     // Catch: Throwable -> L7
    L10:
        if (pae.activity.isAttached() == true) goto L13;
        monitor-exit(pae);     // Catch: Throwable -> L7
        return;
    L13:
        if (structure == null) goto L15;
        structure.setTaskId(pae.activity.getTask().mTaskId);     // Catch: Throwable -> L7
        structure.setActivityComponent(pae.activity.mActivityComponent);     // Catch: Throwable -> L7
        structure.setHomeActivity(pae.isHome);     // Catch: Throwable -> L7
    L15:
        pae.haveResult = true;     // Catch: Throwable -> L7
        pae.notifyAll();     // Catch: Throwable -> L7
        if (pae.intent == null) goto L18;
    L21:
        monitor-exit(pae);     // Catch: Throwable -> L7
        Bundle sendBundle = null;
        WindowManagerGlobalLock r3 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        buildAssistBundleLocked(pae, extras);     // Catch: Throwable -> L29
        boolean exists = this.mPendingAssistExtras.remove(pae);     // Catch: Throwable -> L29
        this.mUiHandler.removeCallbacks(pae);     // Catch: Throwable -> L29
        if (exists == true) goto L31;
        monitor-exit(r3);     // Catch: Throwable -> L29
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L31:
        IAssistDataReceiver sendReceiver = pae.receiver;     // Catch: Throwable -> L29
        if (sendReceiver == null) goto L34;
        sendBundle = new Bundle();     // Catch: Throwable -> L29
        sendBundle.putInt(ActivityTaskManagerInternal.ASSIST_TASK_ID, pae.activity.getTask().mTaskId);     // Catch: Throwable -> L29
        sendBundle.putBinder(ActivityTaskManagerInternal.ASSIST_ACTIVITY_ID, pae.activity.assistToken);     // Catch: Throwable -> L29
        sendBundle.putBundle("data", pae.extras);     // Catch: Throwable -> L29
        sendBundle.putParcelable(ActivityTaskManagerInternal.ASSIST_KEY_STRUCTURE, pae.structure);     // Catch: Throwable -> L29
        sendBundle.putParcelable(ActivityTaskManagerInternal.ASSIST_KEY_CONTENT, pae.content);     // Catch: Throwable -> L29
        sendBundle.putBundle(ActivityTaskManagerInternal.ASSIST_KEY_RECEIVER_EXTRAS, pae.receiverExtras);     // Catch: Throwable -> L29
    L34:
        monitor-exit(r3);     // Catch: Throwable -> L29
        WindowManagerService.resetPriorityAfterLockedSection();
        if (sendReceiver != null) goto L60;
        long ident = Binder.clearCallingIdentity();
        pae.intent.replaceExtras(pae.extras);     // Catch: Throwable -> L45
        pae.intent.setFlags(872415232);     // Catch: Throwable -> L45
        this.mInternal.closeSystemDialogs(PhoneWindowManager.SYSTEM_DIALOG_REASON_ASSIST);     // Catch: Throwable -> L45
        this.mContext.startActivityAsUser(pae.intent, new UserHandle(pae.userHandle));     // Catch: Throwable -> L45 ActivityNotFoundException -> L47
    L49:
        Binder.restoreCallingIdentity(ident);
        return;
    L47:
        e = move-exception;
        Slog.w("ActivityTaskManager", "No activity to handle assist action.", e);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L60:
        sendReceiver.onHandleAssistData(sendBundle);     // Catch: RemoteException -> L39
        return;
    L40:
        return;
    L29:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L18:
        if (pae.receiver != null) goto L21;
        monitor-exit(pae);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int addAppTask(IBinder activityToken, Intent intent, ActivityManager.TaskDescription description, Bitmap thumbnail) throws RemoteException {
        int callingUid = Binder.getCallingUid();
        long callingIdent = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r3 = this.mGlobalLock;     // Catch: Throwable -> L58
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L58
        monitor-enter(r3);     // Catch: Throwable -> L58
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(activityToken);     // Catch: Throwable -> L16
        if (r == null) goto L54;
        ComponentName comp = intent.getComponent();     // Catch: Throwable -> L16
        if (comp == null) goto L52;
        if (thumbnail.getWidth() != this.mThumbnailWidth) goto L50;
        if (thumbnail.getHeight() != this.mThumbnailHeight) goto L50;
        if (intent.getSelector() == null) goto L19;
        intent.setSelector(null);     // Catch: Throwable -> L16
    L19:
        if (intent.getSourceBounds() == null) goto L22;
        intent.setSourceBounds(null);     // Catch: Throwable -> L16
    L22:
        if ((intent.getFlags() & 524288) != 0) goto L24;
    L26:
        ActivityInfo ainfo = AppGlobals.getPackageManager().getActivityInfo(comp, DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, UserHandle.getUserId(callingUid));     // Catch: Throwable -> L16
        if (ainfo == null) goto L41;
        if (ainfo.applicationInfo.uid != callingUid) goto L41;
        Task rootTask = r.getRootTask();     // Catch: Throwable -> L16
        Task task = new Task.Builder(this).setWindowingMode(rootTask.getWindowingMode()).setActivityType(rootTask.getActivityType()).setActivityInfo(ainfo).setIntent(intent).setTaskId(rootTask.getDisplayArea().getNextRootTaskId()).build();     // Catch: Throwable -> L16
        if (this.mRecentTasks.addToBottom(task) == true) goto L37;
        rootTask.removeChild(task, "addAppTask");     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(callingIdent);
        return -1;
    L37:
        task.getTaskDescription().copyFrom(description);     // Catch: Throwable -> L16
        int r7 = task.mTaskId;     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(callingIdent);
        return r7;
    L41:
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L16
        r9.append("Can't add task for another application: target uid=");     // Catch: Throwable -> L16
        if (ainfo != null) goto L44;
        int r10 = -1;
    L45:
        r9.append(r10);     // Catch: Throwable -> L16
        r9.append(", calling uid=");     // Catch: Throwable -> L16
        r9.append(callingUid);     // Catch: Throwable -> L16
        Slog.e("ActivityTaskManager", r9.toString());     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(callingIdent);
        return -1;
    L44:
        r10 = ainfo.applicationInfo.uid;     // Catch: Throwable -> L16
        goto L45
    L24:
        if ((intent.getFlags() & 8192) != 0) goto L26;
        intent.addFlags(8192);     // Catch: Throwable -> L16
    L50:
        throw new IllegalArgumentException("Bad thumbnail size: got " + thumbnail.getWidth() + "x" + thumbnail.getHeight() + ", require " + this.mThumbnailWidth + "x" + this.mThumbnailHeight);     // Catch: Throwable -> L16
    L52:
        throw new IllegalArgumentException("Intent " + intent + " must specify explicit component");     // Catch: Throwable -> L16
    L54:
        throw new IllegalArgumentException("Activity does not exist; token=" + activityToken);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L58
        throw th;     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        Binder.restoreCallingIdentity(callingIdent);
        throw th;
    }

    public Point getAppTaskThumbnailSize() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Point r1 = new Point(this.mThumbnailWidth, this.mThumbnailHeight);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return r1;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void setTaskResizeable(int taskId, int resizeableMode) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Task task = this.mRootWindowContainer.anyTaskForId(taskId, 1);     // Catch: Throwable -> L10
        if (task != null) goto L12;
        Slog.w("ActivityTaskManager", "setTaskResizeable: taskId=" + taskId + " not found");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        task.setResizeMode(resizeableMode);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void resizeTask(int taskId, final Rect bounds, final int resizeMode) {
        enforceTaskPermission("resizeTask()");
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r3 = this.mGlobalLock;     // Catch: Throwable -> L46
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L46
        monitor-enter(r3);     // Catch: Throwable -> L46
        final Task task = this.mRootWindowContainer.anyTaskForId(taskId, 0);     // Catch: Throwable -> L41
        if (task != null) goto L15;
        Slog.w("ActivityTaskManager", "resizeTask: taskId=" + taskId + " not found");     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return;
    L15:
        if (task.getWindowConfiguration().canResizeTask() == true) goto L21;
        Slog.w("ActivityTaskManager", "resizeTask not allowed on task=" + task);     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return;
    L21:
        if ((resizeMode & 1) == 0) goto L23;
        final boolean preserveWindow = true;
    L25:
        if (getTransitionController().isShellTransitionsEnabled() == true) goto L30;
        task.resize(bounds, resizeMode, preserveWindow);     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return;
    L30:
        final Transition transition = new Transition(6, 0, getTransitionController(), this.mWindowManager.mSyncEngine);     // Catch: Throwable -> L41
        getTransitionController().startCollectOrQueue(transition, new ActivityTaskManagerService$$ExternalSyntheticLambda3(this, task, transition, bounds, resizeMode, preserveWindow));     // Catch: Throwable -> L39
        monitor-exit(r3);     // Catch: Throwable -> L39
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L37
        Binder.restoreCallingIdentity(ident);
        return;
    L23:
        preserveWindow = false;
    L12:
        th = th;
    L43:
        monitor-exit(r3);     // Catch: Throwable -> L39
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L37
        throw th;     // Catch: Throwable -> L37
    L41:
        th = th;
    L37:
        th = move-exception;
        Throwable r14 = th;
    L48:
        Binder.restoreCallingIdentity(ident);
        throw r14;
    L39:
        th = th;
    L46:
        th = move-exception;
        r14 = th;
        goto L48
    }

    private /* synthetic */ void lambda$resizeTask$2(Task task, Transition transition, Rect bounds, int resizeMode, boolean preserveWindow, boolean deferred) {
        if (deferred == true) goto L4;
    L7:
        getTransitionController().requestStartTransition(transition, task, null, null);
        transition.collect(task);
        task.resize(bounds, resizeMode, preserveWindow);
        transition.setReady(task, true);
        return;
    L4:
        if (task.getWindowConfiguration().canResizeTask() == true) goto L7;
        Slog.w("ActivityTaskManager", "resizeTask not allowed on task=" + task);
        transition.abort();
    }

    public void releaseSomeActivities(IApplicationThread appInt) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long origId = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
        WindowProcessController app = getProcessController(appInt);     // Catch: Throwable -> L12
        app.releaseSomeActivities("low-mem");     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void setLockScreenShown(boolean keyguardShowing, boolean aodShowing) {
        if (checkCallingPermission("android.permission.DEVICE_POWER") != 0) goto L21;
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L12
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        setLockScreenShownLocked(keyguardShowing, aodShowing);     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(ident);
        return;
    L14:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L21:
        throw new SecurityException("Requires permission android.permission.DEVICE_POWER");
    }

    void setLockScreenShownLocked(final boolean keyguardShowing, final boolean aodShowing) {
        if (this.mKeyguardShown == keyguardShowing) goto L6;
        this.mKeyguardShown = keyguardShowing;
        Message msg = PooledLambda.obtainMessage(new ActivityTaskManagerService$$ExternalSyntheticLambda14(), this.mAmInternal, Boolean.valueOf(keyguardShowing));
        this.mH.sendMessage(msg);
    L6:
        if ((this.mDemoteTopAppReasons & 1) == 0) goto L17;
        this.mDemoteTopAppReasons &= -2;
        if (this.mTopApp == null) goto L17;
        this.mTopApp.scheduleUpdateOomAdj();
    L17:
        Trace.traceBegin(32, "setLockScreenShown");     // Catch: Throwable -> L14
        this.mRootWindowContainer.forAllDisplays(new ActivityTaskManagerService$$ExternalSyntheticLambda15(this, keyguardShowing, aodShowing));     // Catch: Throwable -> L14
        maybeHideLockedProfileActivityLocked();     // Catch: Throwable -> L14
        Trace.traceEnd(32);
        this.mH.post(new ActivityTaskManagerService$$ExternalSyntheticLambda16(this, keyguardShowing));
        return;
    L14:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }

    private /* synthetic */ void lambda$setLockScreenShownLocked$3(boolean keyguardShowing, boolean aodShowing, DisplayContent displayContent) {
        this.mKeyguardController.setKeyguardShown(displayContent.getDisplayId(), keyguardShowing, aodShowing);
    }

    private /* synthetic */ void lambda$setLockScreenShownLocked$4(boolean keyguardShowing) {
        int i = this.mScreenObservers.size() - 1;
    L3:
        if (i < 0) goto L6;
        this.mScreenObservers.get(i).onKeyguardStateChanged(keyguardShowing);
        i = i - 1;
        goto L3
    }

    private void maybeHideLockedProfileActivityLocked() {
        if (this.mKeyguardController.isKeyguardLocked(0) == true) goto L5;
        return;
    L5:
        if (this.mLastResumedActivity == null) goto L20;
        UserInfo userInfo = getUserManager().getUserInfo(this.mLastResumedActivity.mUserId);
        if (userInfo != null) goto L10;
        return;
    L10:
        if (userInfo.isManagedProfile() == true) goto L13;
        return;
    L13:
        if (this.mAmInternal.shouldConfirmCredentials(this.mLastResumedActivity.mUserId) == false) goto L18;
        this.mInternal.startHomeActivity(this.mAmInternal.getCurrentUserId(), "maybeHideLockedProfileActivityLocked");
        return;
    L18:
        return;
    }

    public void onScreenAwakeChanged(final boolean isAwake) {
        this.mH.post(new ActivityTaskManagerService$$ExternalSyntheticLambda5(this, isAwake));
        if (isAwake == false) goto L5;
        return;
    L5:
        Object r0 = this.mGlobalLockWithoutBoost;
        monitor-enter(r0);
        this.mDemoteTopAppReasons &= -2;     // Catch: Throwable -> L10
        WindowState notificationShade = this.mRootWindowContainer.getDefaultDisplay().getDisplayPolicy().getNotificationShade();     // Catch: Throwable -> L10
        if (notificationShade == null) goto L12;
        WindowProcessController proc = notificationShade.getProcess();     // Catch: Throwable -> L10
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        setProcessAnimatingWhileDozing(proc);
        return;
    L12:
        proc = null;
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onScreenAwakeChanged$5(boolean isAwake) {
        int i = this.mScreenObservers.size() - 1;
    L3:
        if (i < 0) goto L6;
        this.mScreenObservers.get(i).onAwakeStateChanged(isAwake);
        i = i - 1;
        goto L3
    }

    void setProcessAnimatingWhileDozing(WindowProcessController proc) {
        if (proc != null) goto L4;
        return;
    L4:
        proc.setRunningAnimationUnsafe();
        this.mH.sendMessage(this.mH.obtainMessage(5, proc));
        this.mH.removeMessages(6, proc);
        this.mH.sendMessageDelayed(this.mH.obtainMessage(6, proc), 2000);
        Trace.instant(32, "requestWakefulnessAnimating");
    }

    public Bitmap getTaskDescriptionIcon(final String filePath, int userId) {
        int callingUid = Binder.getCallingUid();
        int userId2 = handleIncomingUser(Binder.getCallingPid(), callingUid, userId, "getTaskDescriptionIcon");
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        ActivityRecord matchingActivity = this.mRootWindowContainer.getActivity(new ActivityTaskManagerService$$ExternalSyntheticLambda10(filePath));     // Catch: Throwable -> L9
        if (matchingActivity != null) goto L7;
    L28:
        enforceActivityTaskPermission("getTaskDescriptionIcon");     // Catch: Throwable -> L9 SecurityException -> L21
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        File passedIconFile = new File(filePath);
        File legitIconFile = new File(TaskPersister.getUserImagesDir(userId2), passedIconFile.getName());
        if (legitIconFile.getPath().equals(filePath) == false) goto L20;
        if (filePath.contains("_activity_icon_") == false) goto L20;
        return this.mRecentTasks.getTaskDescriptionIcon(filePath);
    L20:
        throw new IllegalArgumentException("Bad file path: " + filePath + " passed for userId " + userId2);
    L21:
        e = move-exception;
        Slog.w("ActivityTaskManager", "getTaskDescriptionIcon(): request (callingUid=" + callingUid + ", filePath=" + filePath + ", user=" + userId2 + ") doesn't match any activity");     // Catch: Throwable -> L9
        throw e;     // Catch: Throwable -> L9
    L7:
        if (matchingActivity.getUid() == callingUid) goto L12;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ boolean lambda$getTaskDescriptionIcon$6(String filePath, ActivityRecord r) {
        if (r.taskDescription != null) goto L5;
        return false;
    L5:
        if (r.taskDescription.getIconFilename() != null) goto L8;
        return false;
    L8:
        return r.taskDescription.getIconFilename().equals(filePath);
    }

    public void moveRootTaskToDisplay(int taskId, int displayId) {
        this.mAmInternal.enforceCallingPermission("android.permission.INTERNAL_SYSTEM_WINDOW", "moveRootTaskToDisplay()");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L15
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L10;
        long protoLogParam0 = taskId;
        long protoLogParam1 = displayId;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, 893763316922465955L, 5, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1)});     // Catch: Throwable -> L8
    L10:
        this.mRootWindowContainer.moveRootTaskToDisplay(taskId, displayId, true);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L15:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void registerTaskStackListener(ITaskStackListener listener) {
        enforceTaskPermission("registerTaskStackListener()");
        this.mTaskChangeNotificationController.registerTaskStackListener(listener);
    }

    public void unregisterTaskStackListener(ITaskStackListener listener) {
        enforceTaskPermission("unregisterTaskStackListener()");
        this.mTaskChangeNotificationController.unregisterTaskStackListener(listener);
    }

    public boolean requestAssistContextExtras(int requestType, IAssistDataReceiver receiver, Bundle receiverExtras, IBinder activityToken, boolean checkActivityIsTop, boolean newSessionId) {
        if (enqueueAssistContext(requestType, null, null, receiver, receiverExtras, activityToken, checkActivityIsTop, newSessionId, UserHandle.getCallingUserId(), null, 2000, 0) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean requestAssistDataForTask(IAssistDataReceiver receiver, int taskId, String callingPackageName, String callingAttributionTag, boolean fetchStructure) {
        this.mAmInternal.enforceCallingPermission("android.permission.GET_TOP_ACTIVITY_INFO", "requestAssistDataForTask()");
        long callingId = Binder.clearCallingIdentity();
        ActivityTaskManagerInternal.ActivityTokens tokens = this.mInternal.getAttachedNonFinishingActivityForTask(taskId, null);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(callingId);
        if (tokens != null) goto L8;
        Log.e("ActivityTaskManager", "Could not find activity for task " + taskId);
        return false;
    L8:
        AssistDataReceiverProxy proxy = new AssistDataReceiverProxy(receiver, callingPackageName);
        Object lock = new Object();
        AssistDataRequester requester = new AssistDataRequester(this.mContext, this.mWindowManager, getAppOpsManager(), proxy, lock, 49, -1);
        List<IBinder> topActivityToken = new ArrayList();
        topActivityToken.add(tokens.getActivityToken());
        requester.requestAssistData(topActivityToken, true, false, fetchStructure, true, false, true, Binder.getCallingUid(), callingPackageName, callingAttributionTag);
        return true;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    }

    public boolean requestAutofillData(IAssistDataReceiver receiver, Bundle receiverExtras, IBinder activityToken, int flags) {
        if (enqueueAssistContext(2, null, null, receiver, receiverExtras, activityToken, true, true, UserHandle.getCallingUserId(), null, 2000, flags) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Bundle getAssistContextExtras(int requestType) {
        PendingAssistExtras pae = enqueueAssistContext(requestType, null, null, null, null, null, true, true, UserHandle.getCallingUserId(), null, 500, 0);
        if (pae != null) goto L6;
        return null;
    L6:
        monitor-enter(pae);
    L30:
    L11:
        th = move-exception;
        throw th;
    L8:
        if (pae.haveResult == true) goto L15;
        pae.wait();     // Catch: Throwable -> L11 InterruptedException -> L13
        goto L30
    L15:
        monitor-exit(pae);     // Catch: Throwable -> L11
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        buildAssistBundleLocked(pae, pae.result);     // Catch: Throwable -> L22
        this.mPendingAssistExtras.remove(pae);     // Catch: Throwable -> L22
        this.mUiHandler.removeCallbacks(pae);     // Catch: Throwable -> L22
        monitor-exit(r2);     // Catch: Throwable -> L22
        WindowManagerService.resetPriorityAfterLockedSection();
        return pae.extras;
    L22:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static int checkCallingPermission(String permission) {
        return checkPermission(permission, Binder.getCallingPid(), Binder.getCallingUid());
    }

    boolean checkCanCloseSystemDialogs(int pid, int uid, String packageName) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowProcessController process = this.mProcessMap.getProcess(pid);     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        WindowManagerService.resetPriorityAfterLockedSection();
        if (packageName != null) goto L10;
        if (process == null) goto L10;
        packageName = process.mInfo.packageName;
    L10:
        String caller = "(pid=" + pid + ", uid=" + uid + ")";
        if (packageName == null) goto L14;
        caller = packageName + " " + caller;
    L14:
        if (canCloseSystemDialogs(pid, uid) == false) goto L16;
        return true;
    L16:
        if (CompatChanges.isChangeEnabled(174664365, uid) == true) goto L24;
        if (CompatChanges.isChangeEnabled(174664120, uid) == false) goto L21;
        Slog.e("ActivityTaskManager", "Permission Denial: android.intent.action.CLOSE_SYSTEM_DIALOGS broadcast from " + caller + " requires android.permission.BROADCAST_CLOSE_SYSTEM_DIALOGS, dropping broadcast.");
        return false;
    L21:
        Slog.w("ActivityTaskManager", "android.intent.action.CLOSE_SYSTEM_DIALOGS broadcast from " + caller + " will require android.permission.BROADCAST_CLOSE_SYSTEM_DIALOGS in future builds.");
        return true;
    L24:
        throw new SecurityException("Permission Denial: android.intent.action.CLOSE_SYSTEM_DIALOGS broadcast from " + caller + " requires android.permission.BROADCAST_CLOSE_SYSTEM_DIALOGS.");
    L26:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private boolean canCloseSystemDialogs(int pid, int uid) {
        if (checkPermission("android.permission.BROADCAST_CLOSE_SYSTEM_DIALOGS", pid, uid) != 0) goto L5;
        return true;
    L5:
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ArraySet<WindowProcessController> processes = this.mProcessMap.getProcesses(uid);     // Catch: Throwable -> L20
        if (processes == null) goto L30;
        int i = 0;
        int n = processes.size();     // Catch: Throwable -> L20
    L10:
        if (i >= n) goto L30;
        WindowProcessController process = processes.valueAt(i);     // Catch: Throwable -> L20
        int sourceUid = process.getInstrumentationSourceUid();     // Catch: Throwable -> L20
        if (process.isInstrumenting() == false) goto L23;
        if (sourceUid == (-1)) goto L23;
        if (checkPermission("android.permission.BROADCAST_CLOSE_SYSTEM_DIALOGS", -1, sourceUid) != 0) goto L23;
        monitor-exit(r0);     // Catch: Throwable -> L20
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    L23:
        if (process.canCloseSystemDialogsByToken() == true) goto L24;
        i = i + 1;
        goto L10
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L20
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    L30:
        if (CompatChanges.isChangeEnabled(174664365, uid) == false) goto L32;
    L41:
        monitor-exit(r0);     // Catch: Throwable -> L20
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L32:
        if (this.mRootWindowContainer.hasVisibleWindowAboveButDoesNotOwnNotificationShade(uid) == false) goto L37;
        monitor-exit(r0);     // Catch: Throwable -> L20
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    L37:
        if (ArrayUtils.contains(this.mAccessibilityServiceUids, uid) == false) goto L41;
        monitor-exit(r0);     // Catch: Throwable -> L20
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    L20:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void enforceActivityTaskPermission(String func) {
        enforceTaskPermission(func);
    }

    static void enforceTaskPermission(String func) {
        if (checkCallingPermission("android.permission.MANAGE_ACTIVITY_TASKS") != 0) goto L6;
        return;
    L6:
        if (checkCallingPermission("android.permission.MANAGE_ACTIVITY_STACKS") != 0) goto L9;
        Slog.w("ActivityTaskManager", "MANAGE_ACTIVITY_STACKS is deprecated, please use alternative permission: MANAGE_ACTIVITY_TASKS");
        return;
    L9:
        String msg = "Permission Denial: " + func + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " requires android.permission.MANAGE_ACTIVITY_TASKS";
        Slog.w("ActivityTaskManager", msg);
        throw new SecurityException(msg);
    }

    static int checkPermission(String permission, int pid, int uid) {
        if (permission != null) goto L6;
        return -1;
    L6:
        return checkComponentPermission(permission, pid, uid, -1, true);
    }

    public static int checkComponentPermission(String permission, int pid, int uid, int owningUid, boolean exported) {
        return ActivityManagerService.checkComponentPermission(permission, pid, uid, owningUid, exported);
    }

    boolean isCallerRecents(int callingUid) {
        return this.mRecentTasks.isCallerRecents(callingUid);
    }

    boolean isGetTasksAllowed(String caller, int callingPid, int callingUid) {
        boolean allowed = true;
        if (isCallerRecents(callingUid) == false) goto L6;
        return true;
    L6:
        if (checkPermission("android.permission.REAL_GET_TASKS", callingPid, callingUid) == 0) goto L9;
        allowed = false;
    L9:
        if (allowed == false) goto L11;
    L24:
        return allowed;
    L11:
        if (checkPermission("android.permission.GET_TASKS", callingPid, callingUid) != 0) goto L22;
        if (AppGlobals.getPackageManager().isUidPrivileged(callingUid) == false) goto L22;
        allowed = true;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[3] == false) goto L22;
        String protoLogParam0 = String.valueOf(caller);     // Catch: RemoteException -> L18
        long protoLogParam1 = callingUid;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_TASKS, 8392804603924461448L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1)});     // Catch: RemoteException -> L18
    L22:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[3] == false) goto L24;
        String protoLogParam2 = String.valueOf(caller);
        long protoLogParam3 = callingUid;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_TASKS, 4303745325174700522L, 4, new Object[]{protoLogParam2, Long.valueOf(protoLogParam3)});
        goto L24
    }

    boolean isCrossUserAllowed(int pid, int uid) {
        if (checkPermission("android.permission.INTERACT_ACROSS_USERS", pid, uid) != 0) goto L5;
    L8:
        return true;
    L5:
        if (checkPermission("android.permission.INTERACT_ACROSS_USERS_FULL", pid, uid) == 0) goto L8;
        return false;
    }

    private PendingAssistExtras enqueueAssistContext(int requestType, Intent intent, String hint, IAssistDataReceiver receiver, Bundle receiverExtras, IBinder activityToken, boolean checkActivityIsTop, boolean newSessionId, int userHandle, Bundle args, long timeout, int flags) {
        this.mAmInternal.enforceCallingPermission("android.permission.GET_TOP_ACTIVITY_INFO", "enqueueAssistContext()");
        WindowManagerGlobalLock r11 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r11);
        Task rootTask = getObricExt().getTopDisplayFocusedRootTask(this);     // Catch: Throwable -> L7
        if (rootTask == null) goto L9;
        ActivityRecord activity = rootTask.getTopNonFinishingActivity();     // Catch: Throwable -> L7
    L10:
        if (activity != null) goto L16;
        Slog.w("ActivityTaskManager", "getAssistContextExtras failed: no top activity");     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L16:
        if (activity.attachedToProcess() == true) goto L21;
        Slog.w("ActivityTaskManager", "getAssistContextExtras failed: no process for " + activity);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L21:
        if (checkActivityIsTop == false) goto L31;
        if (activityToken == null) goto L30;
        ActivityRecord caller = ActivityRecord.forTokenLocked(activityToken);     // Catch: Throwable -> L7
        if (activity == caller) goto L30;
        Slog.w("ActivityTaskManager", "enqueueAssistContext failed: caller " + caller + " is not current top " + activity);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L30:
        ActivityRecord activity2 = activity;
    L44:
        Bundle extras = new Bundle();     // Catch: Throwable -> L7
        if (args == null) goto L47;
        extras.putAll(args);     // Catch: Throwable -> L7
    L47:
        extras.putString("android.intent.extra.ASSIST_PACKAGE", activity2.packageName);     // Catch: Throwable -> L7
        extras.putInt("android.intent.extra.ASSIST_UID", activity2.app.mUid);     // Catch: Throwable -> L7
        PendingAssistExtras pae = new PendingAssistExtras(this, activity2, extras, intent, hint, receiver, receiverExtras, userHandle);     // Catch: Throwable -> L7
        pae.isHome = activity2.isActivityTypeHome();     // Catch: Throwable -> L7
        if (newSessionId == false) goto L78;
        this.mViSessionId++;     // Catch: Throwable -> L7
    L78:
        activity2.app.getThread().requestAssistContextExtras(activity2.token, pae, requestType, this.mViSessionId, flags);     // Catch: Throwable -> L7 RemoteException -> L65
        this.mPendingAssistExtras.add(pae);     // Catch: Throwable -> L7 RemoteException -> L63
        this.mUiHandler.postDelayed(pae, timeout);     // Catch: Throwable -> L59 RemoteException -> L61
        monitor-exit(r11);     // Catch: Throwable -> L59
        WindowManagerService.resetPriorityAfterLockedSection();
        return pae;
    L68:
        Slog.w("ActivityTaskManager", "getAssistContextExtras failed: crash calling " + activity2);     // Catch: Throwable -> L59
        monitor-exit(r11);     // Catch: Throwable -> L59
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L31:
        ActivityRecord activity3 = ActivityRecord.forTokenLocked(activityToken);     // Catch: Throwable -> L7
        if (activity3 != null) goto L38;
        Slog.w("ActivityTaskManager", "enqueueAssistContext failed: activity for token=" + activityToken + " couldn't be found");     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L38:
        if (activity3.attachedToProcess() == true) goto L43;
        Slog.w("ActivityTaskManager", "enqueueAssistContext failed: no process for " + activity3);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L43:
        activity2 = activity3;
        goto L44
    L9:
        activity = null;
    L59:
        e = th;
    L72:
        monitor-exit(r11);     // Catch: Throwable -> L59
        WindowManagerService.resetPriorityAfterLockedSection();
        throw e;
    L7:
        e = th;
        goto L72
    }

    private void buildAssistBundleLocked(PendingAssistExtras pae, Bundle result) {
        if (result == null) goto L5;
        pae.extras.putBundle("android.intent.extra.ASSIST_CONTEXT", result);
    L5:
        if (pae.hint == null) goto L8;
        pae.extras.putBoolean(pae.hint, true);
        return;
    }

    private void pendingAssistExtrasTimedOut(PendingAssistExtras pae) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mPendingAssistExtras.remove(pae);     // Catch: Throwable -> L13
        IAssistDataReceiver receiver = pae.receiver;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        if (receiver == null) goto L21;
        Bundle sendBundle = new Bundle();
        sendBundle.putBundle(ActivityTaskManagerInternal.ASSIST_KEY_RECEIVER_EXTRAS, pae.receiverExtras);
        pae.receiver.onHandleAssistData(sendBundle);     // Catch: RemoteException -> L11
        return;
    L12:
        return;
    L21:
        return;
    L13:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean isAssistDataAllowed() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Task focusedRootTask = getTopDisplayFocusedRootTask();     // Catch: Throwable -> L14
        if (focusedRootTask == null) goto L33;
        if (focusedRootTask.isActivityTypeAssistant() == true) goto L33;
        ActivityRecord activity = focusedRootTask.getTopNonFinishingActivity();     // Catch: Throwable -> L14
        if (activity != null) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L16:
        int userId = activity.mUserId;     // Catch: Throwable -> L14
        DisplayContent displayContent = activity.getDisplayContent();     // Catch: Throwable -> L14
        if (displayContent != null) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L21:
        long callingIdentity = Binder.clearCallingIdentity();     // Catch: Throwable -> L14
        boolean hasRestrictedWindow = displayContent.forAllWindows(new ActivityTaskManagerService$$ExternalSyntheticLambda23(this), true);     // Catch: Throwable -> L30
        Binder.restoreCallingIdentity(callingIdentity);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        if (DevicePolicyCache.getInstance().isScreenCaptureAllowed(userId) == false) goto L42;
        if (hasRestrictedWindow == false) goto L29;
        return false;
    L29:
        return true;
    L42:
        return false;
    L30:
        th = move-exception;
        Binder.restoreCallingIdentity(callingIdentity);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L33:
        monitor-exit(r0);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L14:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private /* synthetic */ boolean lambda$isAssistDataAllowed$7(WindowState windowState) {
        if (windowState.isOnScreen() == true) goto L5;
    L9:
        return false;
    L5:
        if (UserManager.isUserTypePrivateProfile(getUserManager().getProfileType(windowState.mShowUserId)) == false) goto L7;
    L8:
        return true;
    L7:
        if (hasUserRestriction("no_assist_content", windowState.mShowUserId) == false) goto L9;
        goto L8
    }

    private void onLocalVoiceInteractionStartedLocked(IBinder activity, IVoiceInteractionSession voiceSession, IVoiceInteractor voiceInteractor) {
        ActivityRecord activityToCallback = ActivityRecord.forTokenLocked(activity);
        if (activityToCallback != null) goto L5;
        return;
    L5:
        activityToCallback.setVoiceSessionLocked(voiceSession);
        activityToCallback.app.getThread().scheduleLocalVoiceInteractionStarted(activity, voiceInteractor);     // Catch: RemoteException -> L9
        long token = Binder.clearCallingIdentity();     // Catch: RemoteException -> L9
        startRunningVoiceLocked(voiceSession, activityToCallback.info.applicationInfo.uid);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);     // Catch: RemoteException -> L9
        return;
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: RemoteException -> L9
        throw th;     // Catch: RemoteException -> L9
    L14:
        activityToCallback.clearVoiceSessionLocked();
    }

    private void startRunningVoiceLocked(IVoiceInteractionSession session, int targetUid) {
        Slog.d("ActivityTaskManager", "<<<  startRunningVoiceLocked()");
        this.mVoiceWakeLock.setWorkSource(new WorkSource(targetUid));
        if (this.mRunningVoice == null) goto L7;
        if (this.mRunningVoice.asBinder() != session.asBinder()) goto L7;
        return;
    L7:
        if (this.mRunningVoice == null) goto L9;
        boolean wasRunningVoice = true;
    L10:
        this.mRunningVoice = session;
        if (wasRunningVoice == true) goto L15;
        this.mVoiceWakeLock.acquire();
        updateSleepIfNeededLocked();
        return;
    L15:
        return;
    L9:
        wasRunningVoice = false;
        goto L10
    }

    void finishRunningVoiceLocked() {
        if (this.mRunningVoice == null) goto L6;
        this.mRunningVoice = null;
        this.mVoiceWakeLock.release();
        updateSleepIfNeededLocked();
        return;
    }

    public void setVoiceKeepAwake(IVoiceInteractionSession session, boolean keepAwake) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mRunningVoice != null) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        if (this.mRunningVoice.asBinder() != session.asBinder()) goto L13;
        if (keepAwake == false) goto L12;
        this.mVoiceWakeLock.acquire();     // Catch: Throwable -> L10
        goto L13
    L12:
        this.mVoiceWakeLock.release();     // Catch: Throwable -> L10
        goto L13
    }

    public void keyguardGoingAway(int flags) {
        this.mAmInternal.enforceCallingPermission("android.permission.CONTROL_KEYGUARD", "unlock keyguard");
        enforceNotIsolatedCaller("keyguardGoingAway");
        long token = Binder.clearCallingIdentity();
        unfreezeEarlyForKeyguardGoingAway();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L43
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L43
        monitor-enter(r2);     // Catch: Throwable -> L43
        boolean isPowerModePreApplied = false;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L43
    L7:
        if (this.mPowerModeReasons != 0) goto L12;
        startPowerMode(1);     // Catch: Throwable -> L9
        isPowerModePreApplied = true;
    L12:
        if ((flags & 16) == 0) goto L15;
        this.mActivityClientController.invalidateHomeTaskSnapshot(null);     // Catch: Throwable -> L9
    L17:
        boolean foundResumed = false;
        int i = this.mRootWindowContainer.getChildCount() - 1;     // Catch: Throwable -> L9
    L18:
        if (i < 0) goto L35;
        DisplayContent dc = this.mRootWindowContainer.getChildAt(i);     // Catch: Throwable -> L9
        if (dc.mFocusedApp != null) goto L22;
    L25:
        boolean wasNoResumed = true;
    L26:
        this.mKeyguardController.keyguardGoingAway(dc.mDisplayId, flags);     // Catch: Throwable -> L9
        if (wasNoResumed == false) goto L33;
        if (dc.mFocusedApp == null) goto L33;
        if (dc.mFocusedApp.isState(ActivityRecord.State.RESUMED) == false) goto L33;
        foundResumed = true;
    L33:
        i = i - 1;     // Catch: Throwable -> L9
        goto L18
    L22:
        if (dc.mFocusedApp.isState(ActivityRecord.State.RESUMED) == false) goto L25;
        wasNoResumed = false;
        goto L26
    L35:
        if (isPowerModePreApplied == false) goto L38;
        if (foundResumed == true) goto L38;
        endPowerMode(1);     // Catch: Throwable -> L9
    L38:
        this.mH.post(new ActivityTaskManagerService$$ExternalSyntheticLambda13(this));     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L43
        Binder.restoreCallingIdentity(token);
        return;
    L15:
        if (this.mKeyguardShown == false) goto L17;
        this.mDemoteTopAppReasons |= 1;     // Catch: Throwable -> L9
    L43:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private /* synthetic */ void lambda$keyguardGoingAway$8() {
        int i = this.mScreenObservers.size() - 1;
    L3:
        if (i < 0) goto L6;
        this.mScreenObservers.get(i).onKeyguardGoingAway();
        i = i - 1;
        goto L3
    }

    void unfreezeEarlyForKeyguardGoingAway() {
        long startTime = SystemClock.uptimeMillis();     // Catch: Exception -> L22
        final List<ActivityRecord> targets = new ArrayList();     // Catch: Exception -> L22
        WindowManagerGlobalLock r5 = this.mGlobalLock;     // Catch: Exception -> L22
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Exception -> L22
        monitor-enter(r5);     // Catch: Exception -> L22
        DisplayContent display = this.mRootWindowContainer.getDefaultDisplay();     // Catch: Throwable -> L9
        if (this.mTaskSupervisor.readyToResume() == false) goto L11;
        if (display == null) goto L11;
        final ActivityRecord topOfDisplay = display.topRunningActivity();     // Catch: Throwable -> L9
        display.forAllRootTasks(new ActivityTaskManagerService$$ExternalSyntheticLambda4(topOfDisplay, targets));     // Catch: Throwable -> L9
    L11:
        long wmCost = SystemClock.uptimeMillis() - startTime;     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Exception -> L22
        Iterator<ActivityRecord> r6 = targets.iterator();     // Catch: Exception -> L22
    L15:
        if (r6.hasNext() == false) goto L24;
        ActivityRecord target = r6.next();     // Catch: Exception -> L22
        if (target == null) goto L15;
        if (target.packageName == null) goto L15;
        SysOptBridge.getFactory().getApplicationFreezer().unfreezePackage(target.packageName, IApplicationFreezer.UnfreezeReason.KEYGUARD_GOINGAWAY);     // Catch: Exception -> L22
        goto L15
    L24:
        Slog.i("AMS.Freeze", "unfreezeEarly, activitys=" + targets + " wm cost: " + wmCost + "ms, unfrz cost: " + ((SystemClock.uptimeMillis() - startTime) - wmCost) + "ms");     // Catch: Exception -> L22
        return;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Exception -> L22
        throw th;     // Catch: Exception -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
    }

    private static /* synthetic */ void lambda$unfreezeEarlyForKeyguardGoingAway$9(ActivityRecord topOfDisplay, List targets, Task rootTask) {
        ActivityRecord topRunningActivity = rootTask.topRunningActivity();
        if (rootTask.isFocusableAndVisible() == false) goto L11;
        if (topRunningActivity != null) goto L7;
        return;
    L7:
        if (topRunningActivity.isState(ActivityRecord.State.RESUMED) == false) goto L9;
        if (topRunningActivity != topOfDisplay) goto L9;
        return;
    L9:
        targets.add(topRunningActivity);
        return;
    }

    public void suppressResizeConfigChanges(boolean suppress) throws RemoteException {
        this.mAmInternal.enforceCallingPermission("android.permission.MANAGE_ACTIVITY_TASKS", "suppressResizeConfigChanges()");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mSuppressResizeConfigChanges = suppress;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void onSplashScreenViewCopyFinished(int taskId, SplashScreenView.SplashScreenViewParcelable parcelable) throws RemoteException {
        this.mAmInternal.enforceCallingPermission("android.permission.MANAGE_ACTIVITY_TASKS", "copySplashScreenViewFinish()");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Task task = this.mRootWindowContainer.anyTaskForId(taskId, 0);     // Catch: Throwable -> L9
        if (task == null) goto L11;
        ActivityRecord r = task.getTopWaitSplashScreenActivity();     // Catch: Throwable -> L9
        if (r == null) goto L11;
        r.onCopySplashScreenFinish(parcelable);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    boolean prepareAutoEnterPictureAndPictureMode(ActivityRecord r) {
        if (r.inPinnedWindowingMode() == false) goto L6;
        return true;
    L6:
        if (r.canAutoEnterPip() == true) goto L8;
        return false;
    L8:
        if (getTransitionController().getCollectingTransition() == null) goto L13;
        getTransitionController().getCollectingTransition().setPipActivity(r);
        return true;
    L13:
        return false;
    }

    boolean enterPictureInPictureMode(ActivityRecord r, PictureInPictureParams params, boolean fromClient) {
        return enterPictureInPictureMode(r, params, fromClient, false);
    }

    boolean enterPictureInPictureMode(final ActivityRecord r, final PictureInPictureParams params, boolean fromClient, final boolean isAutoEnter) {
        if (r.inPinnedWindowingMode() == false) goto L6;
        return true;
    L6:
        if (r.checkEnterPictureInPictureState("enterPictureInPictureMode", false) == true) goto L8;
        return false;
    L8:
        if (fromClient == false) goto L16;
        if (r.isState(ActivityRecord.State.PAUSING) == false) goto L16;
        if (params.isAutoEnterEnabled() == false) goto L16;
        Slog.w("ActivityTaskManager", "Skip client enterPictureInPictureMode request while pausing, auto-enter-pip is enabled");
        return false;
    L16:
        if (isPip2ExperimentEnabled() == false) goto L25;
        final Transition enterPipTransition = new Transition(10, 0, getTransitionController(), this.mWindowManager.mSyncEngine);
        r.setPictureInPictureParams(params);
        enterPipTransition.setPipActivity(r);
        r.mAutoEnteringPip = isAutoEnter;
        if (r.getTaskFragment() != null) goto L20;
    L22:
        getTransitionController().startCollectOrQueue(enterPipTransition, new ActivityTaskManagerService$$ExternalSyntheticLambda6(this, enterPipTransition, r));
        return true;
    L20:
        if (r.getTaskFragment().isEmbeddedWithBoundsOverride() == false) goto L22;
        enterPipTransition.addFlag(512);
        goto L22
    L25:
        if (fromClient == true) goto L27;
    L31:
        boolean originallyFromClient = false;
    L33:
        if (getTransitionController().isShellTransitionsEnabled() == false) goto L36;
        if (originallyFromClient == false) goto L36;
        final Transition transition = new Transition(10, 0, getTransitionController(), this.mWindowManager.mSyncEngine);
    L38:
        if (r.getTaskFragment() != null) goto L40;
    L43:
        final Runnable enterPipRunnable = new ActivityTaskManagerService$$ExternalSyntheticLambda7(this, r, transition, isAutoEnter, params);
        if (r.isKeyguardLocked() == false) goto L46;
        this.mActivityClientController.dismissKeyguard(r.token, new AnonymousClass2(this, transition, enterPipRunnable), null);
    L49:
        return true;
    L46:
        if (transition == null) goto L48;
        getTransitionController().startCollectOrQueue(transition, new ActivityTaskManagerService$$ExternalSyntheticLambda8(enterPipRunnable));
        goto L49
    L48:
        enterPipRunnable.run();
        goto L49
    L40:
        if (r.getTaskFragment().isEmbeddedWithBoundsOverride() == false) goto L43;
        if (transition == null) goto L43;
        transition.addFlag(512);
    L36:
        transition = null;
        goto L38
    L27:
        if (r.isState(ActivityRecord.State.PAUSING) == true) goto L29;
    L30:
        originallyFromClient = true;
        goto L33
    L29:
        if (params.isAutoEnterEnabled() == false) goto L31;
        goto L30
    }

    private /* synthetic */ void lambda$enterPictureInPictureMode$10(Transition enterPipTransition, ActivityRecord r, boolean deferred) {
        getTransitionController().requestStartTransition(enterPipTransition, r.getTask(), null, null);
    }

    private /* synthetic */ void lambda$enterPictureInPictureMode$11(ActivityRecord r, Transition transition, boolean isAutoEnter, PictureInPictureParams params) {
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
    L33:
        th = th;
    L42:
        monitor-exit(r1);     // Catch: Throwable -> L33
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L35:
        th = th;
        goto L42
    L46:
        if (r.getParent() != null) goto L14;
        Slog.e("ActivityTaskManager", "Skip enterPictureInPictureMode, destroyed " + r);     // Catch: Throwable -> L9
        if (transition == null) goto L11;
        transition.abort();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L14:
        EventLogTags.writeWmEnterPip(r.mUserId, System.identityHashCode(r), r.shortComponentName, Boolean.toString(isAutoEnter));     // Catch: Throwable -> L35
        r.setPictureInPictureParams(params);     // Catch: Throwable -> L35
        r.mAutoEnteringPip = isAutoEnter;     // Catch: Throwable -> L35
        if (transition == null) goto L19;
        this.mRootWindowContainer.moveActivityToPinnedRootTaskAndRequestStart(r, "enterPictureInPictureMode");     // Catch: Throwable -> L9
    L27:
        if (r.isState(ActivityRecord.State.PAUSING) == true) goto L29;
    L37:
        ActivityRecord r2 = r;
    L38:
        r2.mAutoEnteringPip = false;     // Catch: Throwable -> L33
        monitor-exit(r1);     // Catch: Throwable -> L33
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L29:
        if (r.mPauseSchedulePendingForPip == false) goto L37;
        r2 = r;
        r.getTask().schedulePauseActivity(r2, false, false, true, "auto-pip");     // Catch: Throwable -> L33
        goto L38
    L19:
        if (getTransitionController().isCollecting() == false) goto L21;
    L25:
        this.mRootWindowContainer.moveActivityToPinnedRootTask(r, null, "enterPictureInPictureMode", null);     // Catch: Throwable -> L35
        goto L27
    L21:
        if (getTransitionController().isShellTransitionsEnabled() == false) goto L25;
        getTransitionController().createTransition(10);     // Catch: Throwable -> L9
        this.mRootWindowContainer.moveActivityToPinnedRootTaskAndRequestStart(r, "enterPictureInPictureMode");     // Catch: Throwable -> L9
    L9:
        th = th;
        goto L42
    }

    private static /* synthetic */ void lambda$enterPictureInPictureMode$12(Runnable enterPipRunnable, boolean deferred) {
        enterPipRunnable.run();
    }

    public IWindowOrganizerController getWindowOrganizerController() {
        return this.mWindowOrganizerController;
    }

    public void enforceSystemHasVrFeature() {
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance") == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("VR mode not supported on this device!");
    }

    public boolean supportsLocalVoiceInteraction() {
        return ((VoiceInteractionManagerInternal) LocalServices.getService(VoiceInteractionManagerInternal.class)).supportsLocalVoiceInteraction();
    }

    public void requestOpenInBrowserEducation(IBinder appToken) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(appToken);     // Catch: Throwable -> L7
        if (r == null) goto L9;
        r.requestOpenInBrowserEducation();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean updateConfiguration(Configuration values) {
        this.mAmInternal.enforceCallingPermission("android.permission.CHANGE_CONFIGURATION", "updateConfiguration()");
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        boolean r2 = false;
        if (this.mWindowManager != null) goto L12;
        Slog.w("ActivityTaskManager", "Skip updateConfiguration because mWindowManager isn't set");     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L12:
        if (values == null) goto L14;
        Configuration values2 = values;
    L45:
        this.mH.sendMessage(PooledLambda.obtainMessage(new ActivityTaskManagerService$$ExternalSyntheticLambda25(), this.mAmInternal, 0));     // Catch: Throwable -> L37
        long origId = Binder.clearCallingIdentity();     // Catch: Throwable -> L37
        if (values2 == null) goto L50;
        Settings.System.clearConfiguration(values2);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Throwable r13 = th;
    L35:
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L31
        throw r13;     // Catch: Throwable -> L31
    L50:
        updateConfigurationLocked(values2, null, false, false, ProcessList.INVALID_ADJ, false);     // Catch: Throwable -> L33
        if (this.mTmpUpdateConfigurationResult.changes == 0) goto L27;
        r2 = true;
    L27:
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L31
        monitor-exit(r1);     // Catch: Throwable -> L31
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L33:
        th = move-exception;
        r13 = th;
    L31:
        th = th;
    L48:
        monitor-exit(r1);     // Catch: Throwable -> L42
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L42:
        th = th;
    L37:
        th = th;
        goto L48
    L14:
        values2 = this.mWindowManager.computeNewConfiguration(0);     // Catch: Throwable -> L10
    L10:
        th = th;
        goto L48
    }

    public void cancelTaskWindowTransition(int taskId) {
        enforceTaskPermission("cancelTaskWindowTransition()");
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L18
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L18
        monitor-enter(r2);     // Catch: Throwable -> L18
        Task task = this.mRootWindowContainer.anyTaskForId(taskId, 0);     // Catch: Throwable -> L11
        if (task != null) goto L13;
        Slog.w("ActivityTaskManager", "cancelTaskWindowTransition: taskId=" + taskId + " not found");     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return;
    L13:
        task.cancelTaskWindowTransition();     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(ident);
        return;
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private TaskSnapshot getTaskSnapshotInner(int taskId, boolean isLowResolution, int usage) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Task task = this.mRootWindowContainer.anyTaskForId(taskId, 1);     // Catch: Throwable -> L10
        if (task != null) goto L12;
        Slog.w("ActivityTaskManager", "getTaskSnapshot: taskId=" + taskId + " not found");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L12:
        TaskSnapshot snapshot = this.mWindowManager.mTaskSnapshotController.getSnapshot(taskId, isLowResolution, usage);     // Catch: Throwable -> L10
        if (snapshot == null) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return snapshot;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return this.mWindowManager.mTaskSnapshotController.getSnapshotFromDisk(taskId, task.mUserId, isLowResolution, usage);
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public TaskSnapshot getTaskSnapshot(int taskId, boolean isLowResolution) {
        this.mAmInternal.enforceCallingPermission("android.permission.READ_FRAME_BUFFER", "getTaskSnapshot()");
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L23
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L23
        monitor-enter(r2);     // Catch: Throwable -> L23
        Task task = this.mRootWindowContainer.anyTaskForId(taskId, 1);     // Catch: Throwable -> L11
        if (task != null) goto L13;
        Slog.w("ActivityTaskManager", "getTaskSnapshot: taskId=" + taskId + " not found");     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return null;
    L13:
        TaskSnapshot snapshot = this.mWindowManager.mTaskSnapshotController.getSnapshot(taskId, isLowResolution, 16);     // Catch: Throwable -> L11
        if (snapshot == null) goto L19;
        monitor-exit(r2);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return snapshot;
    L19:
        monitor-exit(r2);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L23
        TaskSnapshot r3 = this.mWindowManager.mTaskSnapshotController.getSnapshotFromDisk(taskId, task.mUserId, isLowResolution, 16);     // Catch: Throwable -> L23
        Binder.restoreCallingIdentity(ident);
        return r3;
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public TaskSnapshot takeTaskSnapshot(int taskId, boolean updateCache) {
        this.mAmInternal.enforceCallingPermission("android.permission.READ_FRAME_BUFFER", "takeTaskSnapshot()");
        long ident = Binder.clearCallingIdentity();
        TaskSnapshot[] snapshotHolder = new TaskSnapshot[1];     // Catch: Throwable -> L20
        WindowManagerGlobalLock r4 = this.mGlobalLock;     // Catch: Throwable -> L20
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L20
        monitor-enter(r4);     // Catch: Throwable -> L20
        Task task = this.mRootWindowContainer.anyTaskForId(taskId, 1);     // Catch: Throwable -> L13
        if (task == null) goto L28;
        if (task.isVisible() == false) goto L28;
        if (updateCache == false) goto L15;
        Supplier<TaskSnapshot> supplier = this.mWindowManager.mTaskSnapshotController.getRecordSnapshotSupplier(task);     // Catch: Throwable -> L13
    L16:
        monitor-exit(r4);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L20
        if (supplier == null) goto L22;
        TaskSnapshot snapshot = supplier.get();     // Catch: Throwable -> L20
    L24:
        if (snapshot == null) goto L26;
        snapshot.addReference(16);     // Catch: Throwable -> L20
    L26:
        Binder.restoreCallingIdentity(ident);
        return snapshot;
    L22:
        snapshot = snapshotHolder[0];     // Catch: Throwable -> L20
        goto L24
    L15:
        supplier = null;
        snapshotHolder[0] = this.mWindowManager.mTaskSnapshotController.snapshot(task);     // Catch: Throwable -> L13
    L28:
        Slog.w("ActivityTaskManager", "takeTaskSnapshot: taskId=" + taskId + " not found or not visible");     // Catch: Throwable -> L13
        monitor-exit(r4);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return null;
    L13:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public int getLastResumedActivityUserId() {
        this.mAmInternal.enforceCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "getLastResumedActivityUserId()");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mLastResumedActivity != null) goto L12;
        int r1 = getCurrentUserId();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return r1;
    L12:
        int r2 = this.mLastResumedActivity.mUserId;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    }

    public void updateLockTaskFeatures(int userId, int flags) {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 0) goto L5;
    L7:
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L10:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_LOCKTASK_enabled[3] == false) goto L14;
        long protoLogParam0 = userId;
        String protoLogParam1 = String.valueOf(Integer.toHexString(flags));     // Catch: Throwable -> L12
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_LOCKTASK, -559595900417262876L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});     // Catch: Throwable -> L12
    L14:
        getLockTaskController().updateLockTaskFeatures(userId, flags);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L5:
        if (callingUid == 1000) goto L7;
        this.mAmInternal.enforceCallingPermission("android.permission.UPDATE_LOCK_TASK_PACKAGES", "updateLockTaskFeatures()");
        goto L7
    }

    public void registerRemoteAnimationForNextActivityStart(String packageName, RemoteAnimationAdapter adapter, IBinder launchCookie) {
        this.mAmInternal.enforceCallingPermission("android.permission.CONTROL_REMOTE_APP_TRANSITION_ANIMATIONS", "registerRemoteAnimationForNextActivityStart");
        adapter.setCallingPidUid(Binder.getCallingPid(), Binder.getCallingUid());
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long origId = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
        getActivityStartController().registerRemoteAnimationForNextActivityStart(packageName, adapter, launchCookie);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void registerRemoteAnimationsForDisplay(int displayId, RemoteAnimationDefinition definition) {
    }

    public void alwaysShowUnsupportedCompileSdkWarning(ComponentName activity) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long origId = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
        this.mAppWarnings.alwaysShowUnsupportedCompileSdkWarning(activity);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void setVrThread(int tid) {
        enforceSystemHasVrFeature();
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        int pid = Binder.getCallingPid();     // Catch: Throwable -> L8
        WindowProcessController wpc = this.mProcessMap.getProcess(pid);     // Catch: Throwable -> L8
        this.mVrController.setVrThreadLocked(tid, pid, wpc);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void setPersistentVrThread(int tid) {
        if (checkCallingPermission("android.permission.RESTRICTED_VR_ACCESS") != 0) goto L14;
        enforceSystemHasVrFeature();
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        int pid = Binder.getCallingPid();     // Catch: Throwable -> L10
        WindowProcessController proc = this.mProcessMap.getProcess(pid);     // Catch: Throwable -> L10
        this.mVrController.setPersistentVrThreadLocked(tid, pid, proc);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L14:
        String msg = "Permission Denial: setPersistentVrThread() from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " requires android.permission.RESTRICTED_VR_ACCESS";
        Slog.w("ActivityTaskManager", msg);
        throw new SecurityException(msg);
    }

    public void stopAppSwitches() {
        this.mAmInternal.enforceCallingPermission("android.permission.STOP_APP_SWITCHES", "stopAppSwitches");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mAppSwitchesState = 0;     // Catch: Throwable -> L9
        this.mLastStopAppSwitchesTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        this.mH.removeMessages(4);     // Catch: Throwable -> L9
        this.mH.sendEmptyMessageDelayed(4, 500);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void resumeAppSwitches() {
        this.mAmInternal.enforceCallingPermission("android.permission.STOP_APP_SWITCHES", "resumeAppSwitches");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mAppSwitchesState = 2;     // Catch: Throwable -> L9
        this.mH.removeMessages(4);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    long getLastStopAppSwitchesTime() {
        return this.mLastStopAppSwitchesTime;
    }

    boolean shouldDisableNonVrUiLocked() {
        return this.mVrController.shouldDisableNonVrUiLocked();
    }

    void applyUpdateVrModeLocked(final ActivityRecord r) {
        if (r.requestedVrComponent != null) goto L5;
    L7:
        this.mH.post(new ActivityTaskManagerService$$ExternalSyntheticLambda1(this, r));
        return;
    L5:
        if (r.getDisplayId() == 0) goto L7;
        Slog.i("ActivityTaskManager", "Moving " + r.shortComponentName + " from display " + r.getDisplayId() + " to main display for VR");
        this.mRootWindowContainer.moveRootTaskToDisplay(r.getRootTaskId(), 0, true);
        goto L7
    }

    private /* synthetic */ void lambda$applyUpdateVrModeLocked$13(ActivityRecord r) {
        if (this.mVrController.onVrModeChanged(r) == true) goto L5;
        return;
    L5:
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        boolean disableNonVrUi = this.mVrController.shouldDisableNonVrUiLocked();     // Catch: Throwable -> L10
        this.mWindowManager.disableNonVrUi(disableNonVrUi);     // Catch: Throwable -> L10
        if (disableNonVrUi == false) goto L12;
        this.mRootWindowContainer.removeRootTasksInWindowingModes(new int[]{2});     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public int getPackageScreenCompatMode(String packageName) {
        enforceNotIsolatedCaller("getPackageScreenCompatMode");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        int r1 = this.mCompatModePackages.getPackageScreenCompatModeLocked(packageName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return r1;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void setPackageScreenCompatMode(String packageName, int mode) {
        this.mAmInternal.enforceCallingPermission("android.permission.SET_SCREEN_COMPATIBILITY", "setPackageScreenCompatMode");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mCompatModePackages.setPackageScreenCompatModeLocked(packageName, mode);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean getPackageAskScreenCompat(String packageName) {
        enforceNotIsolatedCaller("getPackageAskScreenCompat");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        boolean r1 = this.mCompatModePackages.getPackageAskCompatModeLocked(packageName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return r1;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void setPackageAskScreenCompat(String packageName, boolean ask) {
        this.mAmInternal.enforceCallingPermission("android.permission.SET_SCREEN_COMPATIBILITY", "setPackageAskScreenCompat");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mCompatModePackages.setPackageAskCompatModeLocked(packageName, ask);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public static String relaunchReasonToString(int relaunchReason) {
        switch(relaunchReason) {
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return null;
    L5:
        return "free_resize";
    L7:
        return "window_resize";
    }

    Task getTopDisplayFocusedRootTask() {
        return this.mRootWindowContainer.getTopDisplayFocusedRootTask();
    }

    void notifyTaskPersisterLocked(Task task, boolean flush) {
        this.mRecentTasks.notifyTaskPersisterLocked(task, flush);
    }

    public void clearLaunchParamsForPackages(List<String> packageNames) {
        enforceTaskPermission("clearLaunchParamsForPackages");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        int i = 0;
    L17:
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L6:
        if (i >= packageNames.size()) goto L11;
        this.mTaskSupervisor.mLaunchParamsPersister.removeRecordForPackage(packageNames.get(i));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L17
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    public void onPictureInPictureUiStateChanged(PictureInPictureUiState pipState) {
        enforceTaskPermission("onPictureInPictureUiStateChanged");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mRootWindowContainer.getDefaultTaskDisplayArea().hasPinnedTask() == false) goto L9;
        Task task = this.mRootWindowContainer.getDefaultTaskDisplayArea().getRootPinnedTask();     // Catch: Throwable -> L7
    L10:
        if (task == null) goto L12;
        ActivityRecord topActivity = task.getTopMostActivity();     // Catch: Throwable -> L7
    L14:
        if (topActivity != null) goto L16;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L16:
        if (topActivity.isState(ActivityRecord.State.FINISHING, ActivityRecord.State.DESTROYING, ActivityRecord.State.DESTROYED) == true) goto L18;
        this.mWindowManager.mAtmService.mActivityClientController.onPictureInPictureUiStateChanged(topActivity, pipState);     // Catch: Throwable -> L7
        goto L18
    L12:
        topActivity = null;
        goto L14
    L9:
        task = this.mRootWindowContainer.getDefaultTaskDisplayArea().getRootTask(new ActivityTaskManagerService$$ExternalSyntheticLambda11());     // Catch: Throwable -> L7
        goto L10
    }

    private static /* synthetic */ boolean lambda$onPictureInPictureUiStateChanged$14(Task t) {
        return t.isActivityTypeStandard();
    }

    public void detachNavigationBarFromApp(IBinder transition) {
        this.mAmInternal.enforceCallingPermission("android.permission.CONTROL_REMOTE_APP_TRANSITION_ANIMATIONS", "detachNavigationBarFromApp");
        long token = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L10
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L10
        monitor-enter(r2);     // Catch: Throwable -> L10
        getTransitionController().legacyDetachNavigationBarFromApp(transition);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(token);
        return;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    void dumpLastANRLocked(PrintWriter pw) {
        pw.println("ACTIVITY MANAGER LAST ANR (dumpsys activity lastanr)");
        if (this.mLastANRState != null) goto L5;
        pw.println("  <no ANR has occurred since boot>");
        return;
    L5:
        pw.println(this.mLastANRState);
    }

    void dumpLastANRTracesLocked(PrintWriter pw) {
        pw.println("ACTIVITY MANAGER LAST ANR TRACES (dumpsys activity lastanr-traces)");
        File[] files = new File(StackTracesDumpHelper.ANR_TRACE_DIR).listFiles();
        if (ArrayUtils.isEmpty(files) == false) goto L6;
        pw.println("  <no ANR has occurred since boot>");
        return;
    L6:
        File latest = null;
        int r2 = files.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L14;
        File f = files[r3];
        if (latest != null) goto L11;
    L12:
        latest = f;
    L13:
        r3 = r3 + 1;
        goto L7
    L11:
        if (latest.lastModified() >= f.lastModified()) goto L13;
    L14:
        pw.print("File: ");
        pw.print(latest.getName());
        pw.println();
        BufferedReader in = new BufferedReader(new FileReader(latest));     // Catch: IOException -> L25
    L36:
        String line = in.readLine();     // Catch: Throwable -> L20
        if (line == null) goto L23;
        pw.println(line);     // Catch: Throwable -> L20
    L23:
        in.close();     // Catch: IOException -> L25
        return;
    L20:
        th = move-exception;
        in.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: IOException -> L25
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L25
    L25:
        e = move-exception;
        pw.print("Unable to read: ");
        pw.print(e);
        pw.println();
    }

    void dumpTopResumedActivityLocked(PrintWriter pw) {
        pw.println("ACTIVITY MANAGER TOP-RESUMED (dumpsys activity top-resumed)");
        ActivityRecord topRecord = this.mRootWindowContainer.getTopResumedActivity();
        if (topRecord == null) goto L6;
        topRecord.dump(pw, "", true);
        return;
    }

    void dumpVisibleActivitiesLocked(PrintWriter pw, int displayIdFilter) {
        pw.println("ACTIVITY MANAGER VISIBLE ACTIVITIES (dumpsys activity visible)");
        ArrayList<ActivityRecord> activities = this.mRootWindowContainer.getDumpActivities(IZswContentProviderHelper.DUMP_ALL, true, false, -1);
        boolean needSeparator = false;
        boolean printedAnything = false;
        int i = activities.size() - 1;
    L3:
        if (i < 0) goto L15;
        ActivityRecord activity = activities.get(i);
        if (activity.isVisible() == false) goto L13;
        if (displayIdFilter != (-1)) goto L8;
    L10:
        if (needSeparator == false) goto L12;
        pw.println();
    L12:
        printedAnything = true;
        activity.dump(pw, "", true);
        needSeparator = true;
        goto L13
    L8:
        if (activity.getDisplayId() == displayIdFilter) goto L10;
    L13:
        i = i - 1;
        goto L3
    L15:
        if (printedAnything == true) goto L22;
        pw.println("(nothing)");
        return;
    }

    void dumpActivitiesLocked(FileDescriptor fd, PrintWriter pw, String[] args, int opti, boolean dumpAll, boolean dumpClient, String dumpPackage, int displayIdFilter) {
        dumpActivitiesLocked(fd, pw, args, opti, dumpAll, dumpClient, dumpPackage, displayIdFilter, "ACTIVITY MANAGER ACTIVITIES (dumpsys activity activities)");
    }

    void dumpActivitiesLocked(FileDescriptor fd, PrintWriter pw, String[] args, int opti, boolean dumpAll, boolean dumpClient, String dumpPackage, int displayIdFilter, String header) {
        pw.println(header);
        boolean printedAnything = this.mRootWindowContainer.dumpActivities(fd, pw, dumpAll, dumpClient, dumpPackage, displayIdFilter);
        boolean needSep = printedAnything;
        boolean printed = ActivityTaskSupervisor.printThisActivity(pw, this.mRootWindowContainer.getTopResumedActivity(), dumpPackage, displayIdFilter, needSep, "  ResumedActivity: ", null);
        if (printed == false) goto L5;
        printedAnything = true;
        needSep = false;
    L5:
        if (dumpPackage != null) goto L14;
        if (needSep == false) goto L8;
        pw.println();
    L8:
        printedAnything = true;
        this.mTaskSupervisor.dump(pw, "  ");
        this.mTaskOrganizerController.dump(pw, "  ");
        this.mVisibleActivityProcessTracker.dump(pw, "  ");
        this.mActiveUids.dump(pw, "  ");
        pw.println("  SleepTokens=" + this.mRootWindowContainer.mSleepTokens);
        if (this.mDemoteTopAppReasons == 0) goto L12;
        pw.println("  mDemoteTopAppReasons=" + this.mDemoteTopAppReasons);
    L12:
        if (this.mStartingProcessActivities.isEmpty() == true) goto L14;
        pw.println("  mStartingProcessActivities=" + this.mStartingProcessActivities);
    L14:
        if (printedAnything == true) goto L17;
        pw.println("  (nothing)");
        return;
    }

    void dumpActivityContainersLocked(PrintWriter pw) {
        pw.println("ACTIVITY MANAGER CONTAINERS (dumpsys activity containers)");
        this.mRootWindowContainer.dumpChildrenNames(pw, "");
        pw.println(" ");
    }

    void dumpActivityStarterLocked(PrintWriter pw, String dumpPackage) {
        pw.println("ACTIVITY MANAGER STARTER (dumpsys activity starter)");
        getActivityStartController().dump(pw, "", dumpPackage);
    }

    void dumpInstalledPackagesConfig(PrintWriter pw) {
        this.mPackageConfigPersister.dump(pw, getCurrentUserId());
    }

    protected boolean dumpActivity(FileDescriptor fd, PrintWriter pw, String name, String[] args, int opti, boolean dumpAll, boolean dumpVisibleRootTasksOnly, boolean dumpFocusedRootTaskOnly, int displayIdFilter, int userId, long timeout) {
        ActivityTaskManagerService r1 = this;
        WindowManagerGlobalLock r2 = r1.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        ArrayList<ActivityRecord> activities = r1.mRootWindowContainer.getDumpActivities(name, dumpVisibleRootTasksOnly, dumpFocusedRootTaskOnly, userId);     // Catch: Throwable -> L51
        monitor-exit(r2);     // Catch: Throwable -> L51
        WindowManagerService.resetPriorityAfterLockedSection();
        if (activities.size() > 0) goto L11;
        return false;
    L11:
        String[] newArgs = new String[args.length - opti];
        System.arraycopy(args, opti, newArgs, 0, args.length - opti);
        boolean printedAnything = false;
        int i = activities.size() - 1;
        Task lastTask = null;
        boolean needSep = false;
    L12:
        if (i < 0) goto L48;
        ActivityRecord r = activities.get(i);
        if (needSep == false) goto L16;
        pw.println();
    L16:
        WindowManagerGlobalLock r3 = r1.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        Task task = r.getTask();     // Catch: Throwable -> L40
        int displayId = task.getDisplayId();     // Catch: Throwable -> L40
        String[] newArgs2 = newArgs;
        if (displayIdFilter == (-1)) goto L28;
        if (displayId == displayIdFilter) goto L28;
        monitor-exit(r3);     // Catch: Throwable -> L25
        WindowManagerService.resetPriorityAfterLockedSection();
        newArgs = newArgs2;
    L37:
        i = i - 1;
        r1 = this;
        needSep = true;
        activities = activities;
    L25:
        th = th;
    L59:
        monitor-exit(r3);     // Catch: Throwable -> L45
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L45:
        th = th;
    L28:
        if (lastTask != task) goto L30;
        Task task2 = lastTask;
        boolean printedAnything2 = printedAnything;
    L66:
        monitor-exit(r3);     // Catch: Throwable -> L38
        WindowManagerService.resetPriorityAfterLockedSection();
        newArgs = newArgs2;
        r1.dumpActivity("  ", fd, pw, activities.get(i), newArgs, dumpAll, timeout);
        lastTask = task2;
        printedAnything = printedAnything2;
    L38:
        th = th;
        goto L59
    L30:
        pw.print("TASK ");     // Catch: Throwable -> L25
        pw.print(task.affinity);     // Catch: Throwable -> L25
        pw.print(" id=");     // Catch: Throwable -> L25
        pw.print(task.mTaskId);     // Catch: Throwable -> L25
        pw.print(" userId=");     // Catch: Throwable -> L25
        pw.print(task.mUserId);     // Catch: Throwable -> L25
        r1.printDisplayInfoAndNewLine(pw, r);     // Catch: Throwable -> L25
        if (dumpAll == false) goto L33;
        task.dump(pw, "  ");     // Catch: Throwable -> L25
    L33:
        task2 = task;
        printedAnything2 = true;
    L40:
        th = th;
        goto L59
    L48:
        if (printedAnything == true) goto L50;
        pw.println("(nothing)");
    L50:
        return true;
    L51:
        th = th;
    L55:
        monitor-exit(r2);     // Catch: Throwable -> L51
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L53:
        th = th;
        goto L55
    }

    private void dumpActivity(String prefix, FileDescriptor fd, PrintWriter pw, ActivityRecord r, String[] args, boolean dumpAll, long timeout) {
        String innerPrefix = prefix + "  ";
        IApplicationThread appThread = null;
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("ACTIVITY ");     // Catch: Throwable -> L7
        pw.print(r.shortComponentName);     // Catch: Throwable -> L7
        pw.print(" ");     // Catch: Throwable -> L7
        pw.print(Integer.toHexString(System.identityHashCode(r)));     // Catch: Throwable -> L7
        pw.print(" pid=");     // Catch: Throwable -> L7
        if (r.hasProcess() == false) goto L9;
        pw.print(r.app.getPid());     // Catch: Throwable -> L7
        appThread = r.app.getThread();     // Catch: Throwable -> L7
    L10:
        pw.print(" userId=");     // Catch: Throwable -> L7
        pw.print(r.mUserId);     // Catch: Throwable -> L7
        pw.print(" uid=");     // Catch: Throwable -> L7
        pw.print(r.getUid());     // Catch: Throwable -> L7
        printDisplayInfoAndNewLine(pw, r);     // Catch: Throwable -> L7
        if (dumpAll == false) goto L13;
        r.dump(pw, innerPrefix, true);     // Catch: Throwable -> L7
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        if (appThread == null) goto L33;
        pw.flush();
        TransferPipe tp = new TransferPipe();     // Catch: RemoteException -> L21 IOException -> L23
        appThread.dumpActivity(tp.getWriteFd(), r.token, innerPrefix, args);     // Catch: Throwable -> L25
        tp.go(fd, timeout);     // Catch: Throwable -> L25
        tp.close();     // Catch: RemoteException -> L21 IOException -> L23
        return;
    L25:
        th = move-exception;
        tp.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: RemoteException -> L21 IOException -> L23
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RemoteException -> L21 IOException -> L23
    L23:
        e = move-exception;
        pw.println(innerPrefix + "Failure while dumping the activity: " + e);
        return;
    L31:
        pw.println(innerPrefix + "Got a RemoteException while dumping the activity");
        return;
    L33:
        return;
    L9:
        pw.print("(not running)");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void printDisplayInfoAndNewLine(PrintWriter pw, ActivityRecord r) {
        pw.print(" displayId=");
        DisplayContent displayContent = r.getDisplayContent();
        if (displayContent != null) goto L6;
        pw.println("N/A");
        return;
    L6:
        Display display = displayContent.getDisplay();
        pw.print(display.getDisplayId());
        pw.print("(type=");
        pw.print(Display.typeToString(display.getType()));
        pw.println(")");
    }

    private void writeSleepStateToProto(ProtoOutputStream proto, int wakeFullness, boolean testPssMode) {
        long sleepToken = proto.start(1146756268059L);
        proto.write(1159641169921L, PowerManagerInternal.wakefulnessToProtoEnum(wakeFullness));
        int tokenSize = this.mRootWindowContainer.mSleepTokens.size();
        int i = 0;
    L3:
        if (i >= tokenSize) goto L5;
        RootWindowContainer.SleepToken st = this.mRootWindowContainer.mSleepTokens.valueAt(i);
        proto.write(2237677961218L, st.toString());
        i = i + 1;
        goto L3
    L5:
        proto.write(1133871366147L, this.mSleeping);
        proto.write(1133871366148L, this.mShuttingDown);
        proto.write(1133871366149L, testPssMode);
        proto.end(sleepToken);
    }

    int getCurrentUserId() {
        return this.mAmInternal.getCurrentUserId();
    }

    static void enforceNotIsolatedCaller(String caller) {
        if (UserHandle.isIsolated(Binder.getCallingUid()) == true) goto L6;
        return;
    L6:
        throw new SecurityException("Isolated process not allowed to call " + caller);
    }

    public Configuration getConfiguration() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Configuration ci = new Configuration(getGlobalConfigurationForCallingPid());     // Catch: Throwable -> L8
        ci.userSetLocale = false;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return ci;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    Configuration getGlobalConfiguration() {
        if (this.mRootWindowContainer == null) goto L6;
        return this.mRootWindowContainer.getConfiguration();
    L6:
        return new Configuration();
    }

    boolean updateConfigurationLocked(Configuration values, ActivityRecord starting, boolean initLocale) {
        return updateConfigurationLocked(values, starting, initLocale, false);
    }

    boolean updateConfigurationLocked(Configuration values, ActivityRecord starting, boolean initLocale, boolean deferResume) {
        return updateConfigurationLocked(values, starting, initLocale, false, ProcessList.INVALID_ADJ, deferResume);
    }

    public void updatePersistentConfiguration(Configuration values, int userId) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r3 = this.mGlobalLock;     // Catch: Throwable -> L21
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L21
        monitor-enter(r3);     // Catch: Throwable -> L21
        values.windowConfiguration.setToDefaults();     // Catch: Throwable -> L16
        updateConfigurationLocked(values, null, false, true, userId, false);     // Catch: Throwable -> L14
        monitor-exit(r3);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(origId);
        return;
    L16:
        th = move-exception;
        Throwable r12 = th;
    L18:
        monitor-exit(r3);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L12
        throw r12;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Throwable r13 = th;
    L23:
        Binder.restoreCallingIdentity(origId);
        throw r13;
    L14:
        th = move-exception;
        r12 = th;
    L21:
        th = move-exception;
        r13 = th;
        goto L23
    }

    boolean updateConfigurationLocked(Configuration values, ActivityRecord starting, boolean initLocale, boolean persistent, int userId, boolean deferResume) {
        int changes = 0;
        boolean kept = true;
        deferWindowLayout();
        if (values != null) goto L18;
    L7:
        if (deferResume == true) goto L12;
        kept = ensureConfigAndVisibilityAfterUpdate(starting, changes);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        continueWindowLayout();
        throw th;
    L12:
        continueWindowLayout();
        UpdateConfigurationResult r2 = this.mTmpUpdateConfigurationResult;
        if (kept == true) goto L15;
        boolean r3 = true;
    L16:
        r2.activityRelaunched = r3;
        return kept;
    L15:
        r3 = false;
        goto L16
    L18:
        changes = updateGlobalConfigurationLocked(values, initLocale, persistent, userId);     // Catch: Throwable -> L5
        this.mTmpUpdateConfigurationResult.changes = changes;     // Catch: Throwable -> L5
        goto L7
    }

    int updateGlobalConfigurationLocked(final Configuration values, final boolean initLocale, boolean persistent, final int userId) {
        this.mTempConfig.setTo(getGlobalConfiguration());
        final int changes = this.mTempConfig.updateFrom(values);
        if (changes != 0) goto L5;
        return 0;
    L5:
        Trace.traceBegin(32, "updateGlobalConfiguration");
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[2] == false) goto L8;
        String protoLogParam0 = String.valueOf(values);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, 2008996027621913637L, 0, new Object[]{protoLogParam0});
    L8:
        com.android.server.am.EventLogTags.writeConfigurationChanged(changes);
        if ((changes & 4) == 0) goto L14;
        if (values.getLocales().isEmpty() == true) goto L14;
        Locale mainLocale = values.getLocales().get(0);
        String value = mainLocale.getLanguage() + "-" + mainLocale.getCountry();
        VendorConfigManager.getInstance().cfg_set("persist.sys.locale", value);
    L14:
        if (Process.myUid() == 1000) goto L16;
    L21:
        char r4 = 1;
        if (initLocale == false) goto L24;
    L34:
        this.mTempConfig.seq = increaseConfigurationSeqLocked();
        Slog.i("ActivityTaskManager", "Config changes=" + Integer.toHexString(changes) + " " + this.mTempConfig);
        this.mUsageStatsInternal.reportConfigurationChange(this.mTempConfig, this.mAmInternal.getCurrentUserId());
        updateShouldShowDialogsLocked(this.mTempConfig);
        AttributeCache ac = AttributeCache.instance();
        if (ac == null) goto L37;
        ac.updateConfiguration(this.mTempConfig);
    L37:
        this.mSystemThread.applyConfigurationToResources(this.mTempConfig);
        SparseArray<WindowProcessController> pidMap = this.mProcessMap.getPidMap();
        int i = pidMap.size() - 1;
    L38:
        if (i < 0) goto L44;
        int pid = pidMap.keyAt(i);
        WindowProcessController app = pidMap.get(pid);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[r4] == false) goto L43;
        String protoLogParam1 = String.valueOf(app.mName);
        String protoLogParam2 = String.valueOf(this.mTempConfig);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, -6404059840638143757L, 0, new Object[]{protoLogParam1, protoLogParam2});
    L43:
        app.onConfigurationChanged(this.mTempConfig);
        i = i - 1;
        r4 = 1;
        goto L38
    L44:
        ArrayMap<String, SparseArray<WindowProcessController>> names = getSmtEx().mProcessFrozenNames.getMap();
        int NA = 0;
    L46:
        if (NA >= names.size()) goto L53;
        SparseArray<WindowProcessController> procs = names.valueAt(NA);
        int NP = 0;
    L49:
        if (NP >= procs.size()) goto L51;
        procs.valueAt(NP).onConfigurationChanged(this.mTempConfig);
        NP = NP + 1;
        goto L49
    L51:
        NA = NA + 1;
        goto L46
    L53:
        if (persistent == true) goto L55;
    L58:
        Configuration r0 = null;
    L57:
        final Configuration configurationForSettings = r0;
        this.mH.post(new ActivityTaskManagerService$$ExternalSyntheticLambda12(this, values, changes, configurationForSettings, userId, initLocale));
        Trace.traceBegin(32, "RootConfigChange");
        this.mRootWindowContainer.onConfigurationChanged(this.mTempConfig);
        Trace.traceEnd(32);
        Trace.traceEnd(32);
        return changes;
    L55:
        if (Settings.System.hasInterestingConfigurationChanges(changes) == false) goto L58;
        r0 = new Configuration(this.mTempConfig);
        goto L57
    L24:
        if (values.getLocales().isEmpty() == true) goto L34;
        if (values.userSetLocale == false) goto L34;
        LocaleList locales = values.getLocales();
        int bestLocaleIndex = 0;
        if (locales.size() > 1) goto L30;
    L33:
        SystemProperties.set("persist.sys.locale", locales.get(bestLocaleIndex).toLanguageTag());
        LocaleList.setDefault(locales, bestLocaleIndex);
        goto L34
    L30:
        if (this.mSupportedSystemLocales != null) goto L32;
        this.mSupportedSystemLocales = Resources.getSystem().getAssets().getLocales();
    L32:
        bestLocaleIndex = Math.max(0, locales.getFirstMatchIndex(this.mSupportedSystemLocales));
        goto L33
    L16:
        if (values.mcc == 0) goto L19;
        SystemProperties.set("debug.tracing.mcc", Integer.toString(values.mcc));
    L19:
        if (values.mnc == 0) goto L21;
        SystemProperties.set("debug.tracing.mnc", Integer.toString(values.mnc));
        goto L21
    }

    private /* synthetic */ void lambda$updateGlobalConfigurationLocked$15(Configuration values, int changes, Configuration configurationForSettings, int userId, boolean initLocale) {
        FrameworkStatsLog.write(66, values.colorMode, values.densityDpi, values.fontScale, values.hardKeyboardHidden, values.keyboard, values.keyboardHidden, values.mcc, values.mnc, values.navigation, values.navigationHidden, values.orientation, values.screenHeightDp, values.screenLayout, values.screenWidthDp, values.smallestScreenWidthDp, values.touchscreen, values.uiMode);
        if ((changes & 128) == 0) goto L5;
        FrameworkStatsLog.write(FrameworkStatsLog.DEVICE_ORIENTATION_CHANGED, values.orientation);
    L5:
        if (configurationForSettings == null) goto L8;
        Settings.System.putConfigurationForUser(this.mContext.getContentResolver(), configurationForSettings, userId);
    L8:
        this.mAmInternal.broadcastGlobalConfigurationChanged(changes, initLocale);
    }

    private int increaseAssetConfigurationSeq() {
        int r0 = this.mGlobalAssetsSeq + 1;
        this.mGlobalAssetsSeq = r0;
        this.mGlobalAssetsSeq = Math.max(r0, 1);
        return this.mGlobalAssetsSeq;
    }

    public void updateActivityApplicationInfo(int userId, ArrayMap<String, ApplicationInfo> applicationInfoByPackage) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mRootWindowContainer == null) goto L9;
        this.mRootWindowContainer.updateActivityApplicationInfo(userId, applicationInfoByPackage);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    public void updateAssetConfiguration(List<WindowProcessController> processes, boolean updateFrameworkRes) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        int assetSeq = increaseAssetConfigurationSeq();     // Catch: Throwable -> L7
        if (updateFrameworkRes == false) goto L9;
        Configuration newConfig = new Configuration();     // Catch: Throwable -> L7
        newConfig.assetsSeq = assetSeq;     // Catch: Throwable -> L7
        updateConfiguration(newConfig);     // Catch: Throwable -> L7
    L9:
        int i = processes.size() - 1;     // Catch: Throwable -> L7
    L10:
        if (i < 0) goto L13;
        WindowProcessController wpc = processes.get(i);     // Catch: Throwable -> L7
        wpc.updateAssetConfiguration(assetSeq);     // Catch: Throwable -> L7
        i = i - 1;     // Catch: Throwable -> L7
        goto L10
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    boolean mayBeLaunchingApp() {
        if ((this.mPowerModeReasons & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    void startPowerMode(int reason) {
        int prevReasons = this.mPowerModeReasons;
        this.mPowerModeReasons |= reason;
        if ((reason & 4) == 0) goto L9;
        if (this.mRetainPowerModeAndTopProcessState == false) goto L7;
        this.mH.removeMessages(3);
    L7:
        this.mRetainPowerModeAndTopProcessState = true;
        this.mH.sendEmptyMessageDelayed(3, 1000);
        Slog.d("ActivityTaskManager", "Temporarily retain top process state for launching app");
    L9:
        if (this.mPowerManagerInternal != null) goto L12;
        return;
    L12:
        if ((reason & 1) == 0) goto L17;
        if ((prevReasons & 1) != 0) goto L17;
        Trace.instant(32, "StartModeLaunch");
        this.mPowerManagerInternal.setPowerMode(5, true);
        return;
    L17:
        if (reason == 2) goto L19;
        return;
    L19:
        if ((prevReasons & 2) != 0) goto L24;
        Trace.instant(32, "StartModeDisplayChange");
        this.mPowerManagerInternal.setPowerMode(17, true);
        return;
    }

    void endPowerMode(int reason) {
        if (this.mPowerModeReasons != 0) goto L5;
        return;
    L5:
        int prevReasons = this.mPowerModeReasons;
        this.mPowerModeReasons &= ~reason;
        if ((this.mPowerModeReasons & 4) == 0) goto L14;
        boolean allResolved = true;
        int i = this.mRootWindowContainer.getChildCount() - 1;
    L8:
        if (i < 0) goto L11;
        allResolved = allResolved & this.mRootWindowContainer.getChildAt(i).mUnknownAppVisibilityController.allResolved();
        i = i - 1;
        goto L8
    L11:
        if (allResolved == false) goto L14;
        this.mPowerModeReasons &= -5;
        this.mRetainPowerModeAndTopProcessState = false;
        this.mH.removeMessages(3);
    L14:
        if (this.mPowerManagerInternal != null) goto L17;
        return;
    L17:
        if ((prevReasons & 5) == 0) goto L22;
        if ((this.mPowerModeReasons & 5) != 0) goto L22;
        Trace.instant(32, "EndModeLaunch");
        this.mPowerManagerInternal.setPowerMode(5, false);
    L22:
        if ((prevReasons & 2) != 0) goto L24;
        return;
    L24:
        if ((this.mPowerModeReasons & 2) != 0) goto L29;
        Trace.instant(32, "EndModeDisplayChange");
        this.mPowerManagerInternal.setPowerMode(17, false);
        return;
    }

    void deferWindowLayout() {
        if (this.mWindowManager.mWindowPlacerLocked.isLayoutDeferred() == true) goto L5;
        this.mLayoutReasons = 0;
    L5:
        this.mWindowManager.mWindowPlacerLocked.deferLayout();
    }

    void continueWindowLayout() {
        WindowSurfacePlacer r0 = this.mWindowManager.mWindowPlacerLocked;
        if (this.mLayoutReasons == 0) goto L5;
        boolean r1 = true;
    L6:
        r0.continueLayout(r1);
        if (ActivityTaskManagerDebugConfig.DEBUG_ALL == true) goto L9;
    L11:
        this.mLifecycleManager.onLayoutContinued();
        return;
    L9:
        if (this.mWindowManager.mWindowPlacerLocked.isLayoutDeferred() == true) goto L11;
        Slog.i("ActivityTaskManager", "continueWindowLayout reason=" + this.mLayoutReasons);
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    void addWindowLayoutReasons(int reasons) {
        this.mLayoutReasons |= reasons;
    }

    private void updateEventDispatchingLocked(boolean booted) {
        WindowManagerService r0 = this.mWindowManager;
        if (booted == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        r0.setEventDispatching(r1);
        return;
    L5:
        if (this.mShuttingDown == true) goto L7;
        r1 = true;
        goto L8
    }

    boolean isActivityStartsLoggingEnabled() {
        return this.mAmInternal.isActivityStartsLoggingEnabled();
    }

    boolean isBackgroundActivityStartsEnabled() {
        return this.mAmInternal.isBackgroundActivityStartsEnabled();
    }

    static long getInputDispatchingTimeoutMillisLocked(ActivityRecord r) {
        if (r == null) goto L9;
        if (r.hasProcess() == false) goto L9;
        return getInputDispatchingTimeoutMillisLocked(r.app);
    L9:
        return InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS;
    }

    private static long getInputDispatchingTimeoutMillisLocked(WindowProcessController r) {
        if (r != null) goto L6;
        return InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS;
    L6:
        return r.getInputDispatchingTimeoutMillis();
    }

    private void updateShouldShowDialogsLocked(Configuration config) {
        this.mShowDialogs = shouldShowDialogs(config, true);
    }

    private boolean shouldShowDialogs(Configuration config, boolean checkUiMode) {
        boolean r1 = false;
        if (config.keyboard == 1) goto L5;
    L10:
        boolean inputMethodExists = true;
    L12:
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "hide_error_dialogs", 0) == 0) goto L14;
        boolean hideDialogsSet = true;
    L15:
        if (inputMethodExists == false) goto L18;
        if (hideDialogsSet == true) goto L18;
        boolean showDialogs = true;
    L19:
        if (checkUiMode == false) goto L27;
        if (showDialogs == true) goto L22;
    L25:
        boolean showDialogs2 = r1;
        return showDialogs2;
    L22:
        if (ActivityTaskManager.currentUiModeSupportsErrorDialogs(config) == false) goto L25;
        r1 = true;
        goto L25
    L27:
        return showDialogs;
    L18:
        showDialogs = false;
        goto L19
    L14:
        hideDialogsSet = false;
        goto L15
    L5:
        if (config.touchscreen != 1) goto L10;
        if (config.navigation != 1) goto L10;
        inputMethodExists = false;
        goto L12
    }

    void updateFontScaleIfNeeded(int userId) {
        if (userId == getCurrentUserId()) goto L5;
        return;
    L5:
        float scaleFactor = Settings.System.getFloatForUser(this.mContext.getContentResolver(), "font_scale", 1.0f, userId);
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L8:
        if (getGlobalConfiguration().fontScale != scaleFactor) goto L14;
        monitor-exit(r1);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L14:
        Configuration configuration = this.mWindowManager.computeNewConfiguration(0);     // Catch: Throwable -> L12
        configuration.fontScale = scaleFactor;     // Catch: Throwable -> L12
        updatePersistentConfiguration(configuration, userId);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    private void updateFontWeightAdjustmentIfNeeded(int userId) {
        if (userId == getCurrentUserId()) goto L5;
        return;
    L5:
        int fontWeightAdjustment = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "font_weight_adjustment", Integer.MAX_VALUE, userId);
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L8:
        if (getGlobalConfiguration().fontWeightAdjustment != fontWeightAdjustment) goto L14;
        monitor-exit(r1);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L14:
        Configuration configuration = this.mWindowManager.computeNewConfiguration(0);     // Catch: Throwable -> L12
        configuration.fontWeightAdjustment = fontWeightAdjustment;     // Catch: Throwable -> L12
        updatePersistentConfiguration(configuration, userId);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    boolean isSleepingOrShuttingDownLocked() {
        if (isSleepingLocked() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mShuttingDown == true) goto L8;
        return false;
    }

    boolean isSleepingLocked() {
        return this.mSleeping;
    }

    void setLastResumedActivityUncheckLocked(ActivityRecord r, String reason) {
        Task task = r.getTask();
        Task prevTask = null;
        if (task.isActivityTypeStandard() == true) goto L5;
        r.appTimeTracker = null;
    L15:
        if (task.voiceInteractor == null) goto L17;
        startRunningVoiceLocked(task.voiceSession, r.info.applicationInfo.uid);
    L28:
        if (this.mLastResumedActivity == null) goto L33;
        if (r.mUserId == this.mLastResumedActivity.mUserId) goto L33;
        this.mAmInternal.sendForegroundProfileChanged(r.mUserId);
    L33:
        if (this.mLastResumedActivity == null) goto L35;
        prevTask = this.mLastResumedActivity.getTask();
    L35:
        updateResumedAppTrace(r);
        this.mLastResumedActivity = r;
        boolean focusedAppChanged = false;
        if (getTransitionController().isTransientCollect(r) == true) goto L40;
        focusedAppChanged = r.mDisplayContent.setFocusedApp(r);
        if (focusedAppChanged == false) goto L40;
        this.mWindowManager.updateFocusedWindowLocked(0, true);
    L40:
        if (task == prevTask) goto L42;
        this.mTaskSupervisor.mRecentTasks.add(task);
    L42:
        if (focusedAppChanged == false) goto L45;
        applyUpdateLockStateLocked(r);
    L45:
        if (this.mVrController.mVrService == null) goto L47;
        applyUpdateVrModeLocked(r);
    L47:
        EventLogTags.writeWmSetResumedActivity(r.mUserId, r.shortComponentName, reason);
        ZTEActivityEventsInternal zteActivityEventsInternal = (ZTEActivityEventsInternal) LocalServices.getService(ZTEActivityEventsInternal.class);
        if (zteActivityEventsInternal == null) goto L51;
        zteActivityEventsInternal.notifyActivityEvent(512, r.getDisplayId(), r.mUserId, r, r.getRootTaskId());
        return;
    L51:
        return;
    L17:
        finishRunningVoiceLocked();
        if (this.mLastResumedActivity == null) goto L28;
        Task lastResumedActivityTask = this.mLastResumedActivity.getTask();
        if (lastResumedActivityTask != null) goto L22;
    L24:
        IVoiceInteractionSession session = this.mLastResumedActivity.voiceSession;
    L25:
        if (session == null) goto L28;
        finishVoiceTask(session);
        goto L28
    L22:
        if (lastResumedActivityTask.voiceSession == null) goto L24;
        session = lastResumedActivityTask.voiceSession;
        goto L25
    L5:
        if (this.mCurAppTimeTracker != r.appTimeTracker) goto L7;
        startTimeTrackingFocusedActivityLocked();
        goto L15
    L7:
        if (this.mCurAppTimeTracker == null) goto L10;
        this.mCurAppTimeTracker.stop();
        this.mH.obtainMessage(1, this.mCurAppTimeTracker).sendToTarget();
        this.mRootWindowContainer.clearOtherAppTimeTrackers(r.appTimeTracker);
        this.mCurAppTimeTracker = null;
    L10:
        if (r.appTimeTracker == null) goto L15;
        this.mCurAppTimeTracker = r.appTimeTracker;
        startTimeTrackingFocusedActivityLocked();
        goto L15
    }

    void updateSleepIfNeededLocked() {
        boolean shouldSleep = !this.mRootWindowContainer.hasAwakeDisplay();
        boolean wasSleeping = this.mSleeping;
        boolean updateOomAdj = false;
        if (shouldSleep == true) goto L13;
        if (wasSleeping == false) goto L9;
        this.mSleeping = false;
        FrameworkStatsLog.write(14, 2);
        startTimeTrackingFocusedActivityLocked();
        if (this.mTopApp == null) goto L8;
        this.mTopApp.addToPendingTop();
    L8:
        this.mTopProcessState = 2;
        Slog.d("ActivityTaskManager", "Top Process State changed to PROCESS_STATE_TOP");
        this.mTaskSupervisor.comeOutOfSleepIfNeededLocked();
    L9:
        this.mRootWindowContainer.applySleepTokens(true);
        if (wasSleeping == false) goto L19;
        updateOomAdj = true;
    L19:
        if (updateOomAdj == false) goto L22;
        updateOomAdj();
        return;
    L22:
        return;
    L13:
        if (this.mSleeping == true) goto L19;
        if (shouldSleep == false) goto L19;
        this.mSleeping = true;
        FrameworkStatsLog.write(14, 1);
        if (this.mCurAppTimeTracker == null) goto L18;
        this.mCurAppTimeTracker.stop();
    L18:
        this.mTopProcessState = 12;
        Slog.d("ActivityTaskManager", "Top Process State changed to PROCESS_STATE_TOP_SLEEPING");
        this.mTaskSupervisor.goingToSleepLocked();
        updateResumedAppTrace(null);
        updateOomAdj = true;
        goto L19
    }

    void updateOomAdj() {
        this.mH.removeCallbacks(this.mUpdateOomAdjRunnable);
        this.mH.post(this.mUpdateOomAdjRunnable);
    }

    void updateCpuStats() {
        H r0 = this.mH;
        final ActivityManagerInternal r1 = this.mAmInternal;
        r1.getClass();
        r0.post(new ActivityTaskManagerService$$ExternalSyntheticLambda20(r1));
    }

    void updateBatteryStats(ActivityRecord component, boolean resumed) {
        Message m = PooledLambda.obtainMessage(new ActivityTaskManagerService$$ExternalSyntheticLambda9(), this.mAmInternal, component.mActivityComponent, Integer.valueOf(component.app.mUid), Integer.valueOf(component.mUserId), Boolean.valueOf(resumed));
        this.mH.sendMessage(m);
    }

    void updateTopApp(ActivityRecord topResumedActivity) {
        if (topResumedActivity == null) goto L4;
        ActivityRecord top = topResumedActivity;
    L6:
        if (top == null) goto L8;
        WindowProcessController r2 = top.app;
    L9:
        this.mTopApp = r2;
        if (this.mPerf == null) goto L29;
        if (this.mTopApp != null) goto L14;
    L25:
        this.mPerf.updateUiPerfState(this.mContext, "", 0);
        if (this.mLegacyUiPerfHandler == (-1)) goto L29;
        this.mPerf.perfLockReleaseHandler(this.mLegacyUiPerfHandler);
        this.mLegacyUiPerfHandler = -1;
        goto L29
    L14:
        if (this.mTopApp.mInfo == null) goto L25;
        this.mPerf.updateUiPerfState(this.mContext, this.mTopApp.mInfo.packageName, this.mTopApp.getPid());
        if (this.mLegacyUiPerfHandler != (-1)) goto L22;
        int hint = this.mPerf.getLegacyUiPerfHint(this.mContext, this.mTopApp.mInfo.packageName);
        if (hint == (-1)) goto L29;
        this.mLegacyUiPerfHandler = this.mPerf.perfHint(hint, PackageManagerService.PLATFORM_PACKAGE_NAME, Integer.MAX_VALUE, -1);
        goto L29
    L22:
        if (this.mPerf.getLegacyUiPerfHint(this.mContext, this.mTopApp.mInfo.packageName) != (-1)) goto L29;
        this.mPerf.perfLockReleaseHandler(this.mLegacyUiPerfHandler);
        this.mLegacyUiPerfHandler = -1;
    L29:
        if (this.mTopApp != this.mPreviousProcess) goto L31;
        this.mPreviousProcess = null;
    L31:
        int demoteReasons = this.mDemoteTopAppReasons;
        if ((demoteReasons & 2) == 0) goto L35;
        Trace.instant(32, "cancel-demote-top-for-ns-switch");
        this.mDemoteTopAppReasons = demoteReasons & (-3);
        return;
    L35:
        return;
    L8:
        r2 = null;
        goto L9
    L4:
        top = this.mRootWindowContainer.getTopResumedActivity();
        goto L6
    }

    void updatePreviousProcess(ActivityRecord stoppedActivity) {
        if (stoppedActivity.app != null) goto L5;
        return;
    L5:
        if (this.mTopApp != null) goto L7;
        return;
    L7:
        if (stoppedActivity.app != this.mTopApp) goto L9;
        return;
    L9:
        if (stoppedActivity.lastVisibleTime > this.mPreviousProcessVisibleTime) goto L11;
        return;
    L11:
        if (stoppedActivity.app == this.mHomeProcess) goto L18;
        this.mPreviousProcess = stoppedActivity.app;
        this.mPreviousProcessVisibleTime = stoppedActivity.lastVisibleTime;
        return;
    }

    void updateActivityUsageStats(ActivityRecord activity, int event) {
        updateActivityUsageStats(activity, event, null, null);
    }

    void updateActivityUsageStats(ActivityRecord activity, int event, String oldDisplayInfo, String newDisplayInfo) {
        this.mObricExt.reportUsageInfo(activity, event);
        ComponentName taskRoot = null;
        Task task = activity.getTask();
        if (task == null) goto L8;
        ActivityRecord rootActivity = task.getRootActivity();
        if (rootActivity == null) goto L7;
        taskRoot = rootActivity.mActivityComponent;
    L7:
        int taskId = task.mTaskId;
        ComponentName taskRoot2 = taskRoot;
        int taskId2 = taskId;
    L9:
        Message m = PooledLambda.obtainMessage(new ActivityTaskManagerService$$ExternalSyntheticLambda18(), this.mAmInternal, activity.mActivityComponent, Integer.valueOf(activity.mUserId), Integer.valueOf(event), activity.token, taskRoot2, new ActivityId(taskId2, activity.shareableActivityToken), newDisplayInfo);
        this.mH.sendMessage(m);
        this.mObricExt.reportUsageInfo(activity, event);
        if (event != 2) goto L12;
    L26:
        reportUsageEvent(event, activity);
        return;
    L12:
        if (event == 1) goto L26;
        if (event == 24) goto L26;
        if (event == 16) goto L26;
        if (event == 23) goto L26;
        if (event == 15) goto L26;
        if (event != 32) goto L28;
        if (newDisplayInfo != null) goto L25;
        return;
    L25:
        if (newDisplayInfo.contains("0###") == true) goto L26;
        return;
    L28:
        return;
    L8:
        taskRoot2 = null;
        taskId2 = -1;
        goto L9
    }

    private void reportUsageEvent(int event, ActivityRecord activity) {
        if (activity == null) goto L16;
        if (activity.app == null) goto L16;
        if (activity.assistToken == null) goto L16;
        if (activity.getActivityInfo() == null) goto L17;
        String className = activity.info.getComponentName().getClassName();
        if (activity.assistToken != null) goto L13;
        return;
    L13:
        int instance = activity.assistToken.hashCode();
        int pid = activity.app.getPid();
        String pkg = activity.packageName;
        long timestamp = SystemClock.elapsedRealtime();
        SysDataSyncServiceManager.onUsageEvent(event, className, instance, pid, pkg, timestamp);
        return;
    L17:
        return;
    }

    void startProcessAsync(ActivityRecord activity, boolean knownToBeDead, boolean isTop, String hostingType) {
        if (this.mStartingProcessActivities.contains(activity) == true) goto L8;
        this.mStartingProcessActivities.add(activity);
        if (this.mStartingProcessActivities.size() <= 1) goto L32;
        this.mStartingProcessActivities.sort(null);
    L32:
    L24:
        th = th;
    L26:
        Trace.traceEnd(32);
        throw th;
    L12:
        if (Trace.isTagEnabled(32) == true) goto L30;
    L17:
        Message m = PooledLambda.obtainMessage(new ActivityTaskManagerService$$ExternalSyntheticLambda22(), this.mAmInternal, activity.processName, activity.info.applicationInfo, Boolean.valueOf(knownToBeDead), Boolean.valueOf(isTop), hostingType, activity.intent.getComponent());     // Catch: Throwable -> L22
        this.mH.sendMessage(m);     // Catch: Throwable -> L22
        Trace.traceEnd(32);
        return;
    L22:
        th = th;
        goto L26
    L30:
        Trace.traceBegin(32, "dispatchingStartProcess:" + activity.processName);     // Catch: Throwable -> L15
    L15:
        th = th;
        goto L26
    L8:
        if (this.mProcessNames.get(activity.processName, activity.info.applicationInfo.uid) == null) goto L32;
    }

    void setBooting(boolean booting) {
        this.mAmInternal.setBooting(booting);
    }

    boolean isBooting() {
        return this.mAmInternal.isBooting();
    }

    void setBooted(boolean booted) {
        this.mAmInternal.setBooted(booted);
    }

    boolean isBooted() {
        return this.mAmInternal.isBooted();
    }

    void postFinishBooting(final boolean finishBooting, final boolean enableScreen) {
        this.mH.post(new ActivityTaskManagerService$$ExternalSyntheticLambda27(this, finishBooting, enableScreen));
    }

    private /* synthetic */ void lambda$postFinishBooting$16(boolean finishBooting, boolean enableScreen) {
        if (finishBooting == false) goto L4;
        this.mAmInternal.finishBooting();
    L4:
        if (enableScreen == false) goto L7;
        this.mInternal.enableScreenAfterBoot(isBooted());
        return;
    }

    void setHeavyWeightProcess(ActivityRecord root) {
        this.mHeavyWeightProcess = root.app;
        Message m = PooledLambda.obtainMessage(new ActivityTaskManagerService$$ExternalSyntheticLambda19(), this, root.app, root.intent, Integer.valueOf(root.mUserId));
        this.mH.sendMessage(m);
    }

    void clearHeavyWeightProcessIfEquals(WindowProcessController proc) {
        if (this.mHeavyWeightProcess != null) goto L5;
        return;
    L5:
        if (this.mHeavyWeightProcess != proc) goto L10;
        this.mHeavyWeightProcess = null;
        Message m = PooledLambda.obtainMessage(new ActivityTaskManagerService$$ExternalSyntheticLambda17(), this, Integer.valueOf(proc.mUserId));
        this.mH.sendMessage(m);
        return;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    private void cancelHeavyWeightProcessNotification(int userId) {
        INotificationManager inm = NotificationManager.getService();
        if (inm != null) goto L19;
        return;
    L19:
        inm.cancelNotificationWithTag(PackageManagerService.PLATFORM_PACKAGE_NAME, PackageManagerService.PLATFORM_PACKAGE_NAME, null, 11, userId);     // Catch: RemoteException -> L9 RuntimeException -> L11
        return;
    L11:
        e = move-exception;
        Slog.w("ActivityTaskManager", "Error canceling notification for service", e);
        return;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    private void postHeavyWeightProcessNotification(WindowProcessController proc, Intent intent, int userId) {
        if (proc != null) goto L5;
        return;
    L5:
        INotificationManager inm = NotificationManager.getService();
        if (inm != null) goto L42;
        return;
    L42:
        Context context = this.mContext.createPackageContext(proc.mInfo.packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L34
        String text = this.mContext.getString(R.string.install_carrier_app_notification_title, new Object[]{context.getApplicationInfo().loadLabel(context.getPackageManager())});     // Catch: PackageManager.NameNotFoundException -> L34
        Notification notification = new Notification.Builder(context, "HEAVY_WEIGHT_APP").setSmallIcon(17305175).setWhen(0).setOngoing(true).setTicker(text).setColor(this.mContext.getColor(R.color.system_notification_accent_color)).setContentTitle(text).setContentText(this.mContext.getText(R.string.invalidPin)).setContentIntent(PendingIntent.getActivityAsUser(this.mContext, 0, intent, AudioFormat.AAC_ADIF, null, new UserHandle(userId))).build();     // Catch: PackageManager.NameNotFoundException -> L23
        inm.enqueueNotificationWithTag(PackageManagerService.PLATFORM_PACKAGE_NAME, PackageManagerService.PLATFORM_PACKAGE_NAME, null, 11, notification, userId);     // Catch: PackageManager.NameNotFoundException -> L17 RemoteException -> L19 RuntimeException -> L21
    L40:
        return;
    L21:
        e = move-exception;
        Slog.w("ActivityTaskManager", "Error showing notification for heavy-weight app", e);     // Catch: PackageManager.NameNotFoundException -> L17
    L49:
        return;
    L23:
        e = move-exception;
        PackageManager.NameNotFoundException e = e;
    L36:
        Slog.w("ActivityTaskManager", "Unable to create context for heavy notification", e);
        return;
    L17:
        e = move-exception;
        e = e;
    L32:
        e = move-exception;
        e = e;
    L34:
        e = move-exception;
        e = e;
        goto L36
    }

    IIntentSender getIntentSenderLocked(int type, String packageName, String featureId, int callingUid, int userId, IBinder token, String resultWho, int requestCode, Intent[] intents, String[] resolvedTypes, int flags, Bundle bOptions) {
        if (type != 3) goto L13;
        ActivityRecord activity = ActivityRecord.isInRootTaskLocked(token);
        if (activity != null) goto L9;
        Slog.w("ActivityTaskManager", "Failed createPendingResult: activity " + token + " not in any root task");
        return null;
    L9:
        if (activity.finishing == false) goto L12;
        Slog.w("ActivityTaskManager", "Failed createPendingResult: activity " + activity + " is finishing");
        return null;
    L12:
        ActivityRecord activity2 = activity;
    L14:
        PendingIntentRecord rec = this.mPendingIntentController.getIntentSender(type, packageName, featureId, callingUid, userId, token, resultWho, requestCode, intents, resolvedTypes, flags, bOptions);
        if ((flags & 536870912) == 0) goto L17;
        boolean noCreate = true;
    L18:
        if (noCreate == false) goto L20;
        return rec;
    L20:
        if (type == 3) goto L22;
    L25:
        return rec;
    L22:
        if (activity2.pendingResults != null) goto L24;
        activity2.pendingResults = new HashSet();
    L24:
        activity2.pendingResults.add(rec.ref);
        goto L25
    L17:
        noCreate = false;
        goto L18
    L13:
        activity2 = null;
        goto L14
    }

    private void startTimeTrackingFocusedActivityLocked() {
        ActivityRecord resumedActivity = this.mRootWindowContainer.getTopResumedActivity();
        if (this.mSleeping == false) goto L5;
        return;
    L5:
        if (this.mCurAppTimeTracker == null) goto L10;
        if (resumedActivity == null) goto L11;
        this.mCurAppTimeTracker.start(resumedActivity.packageName);
        return;
    L11:
        return;
    }

    private void updateResumedAppTrace(ActivityRecord resumed) {
        if (Trace.isTagEnabled(32) == true) goto L5;
    L9:
        this.mTracedResumedActivity = resumed;
        return;
    L5:
        if (this.mTracedResumedActivity == null) goto L7;
        Trace.asyncTraceForTrackEnd(32, "Focused app", System.identityHashCode(this.mTracedResumedActivity));
    L7:
        if (resumed == null) goto L9;
        Trace.asyncTraceForTrackBegin(32, "Focused app", resumed.mActivityComponent.flattenToShortString(), System.identityHashCode(resumed));
        goto L9
    }

    boolean ensureConfigAndVisibilityAfterUpdate(ActivityRecord starting, int changes) {
        if (starting == null) goto L4;
    L7:
        Task mainRootTask = this.mRootWindowContainer.getTopDisplayFocusedRootTask();
        if (mainRootTask == null) goto L15;
        if (changes == 0) goto L12;
        if (starting != null) goto L12;
        starting = mainRootTask.topRunningActivity();
    L12:
        if (starting == null) goto L16;
        boolean kept = starting.ensureActivityConfiguration();
        this.mRootWindowContainer.ensureActivitiesVisible(starting);
        return kept;
    L16:
        return true;
    L15:
        return true;
    L4:
        if (this.mTaskSupervisor.isRootVisibilityUpdateDeferred() == false) goto L7;
        return true;
    }

    private /* synthetic */ void lambda$scheduleAppGcsLocked$17() {
        this.mAmInternal.scheduleAppGcs();
    }

    void scheduleAppGcsLocked() {
        this.mH.post(new ActivityTaskManagerService$$ExternalSyntheticLambda26(this));
    }

    CompatibilityInfo compatibilityInfoForPackageLocked(ApplicationInfo ai) {
        return this.mCompatModePackages.compatibilityInfoForPackageLocked(ai);
    }

    void setToastWindow() {
        this.toastWindow = true;
    }

    void resetToastWindow() {
        this.toastWindow = false;
    }

    boolean getToastWindow() {
        return this.toastWindow;
    }

    IPackageManager getPackageManager() {
        return AppGlobals.getPackageManager();
    }

    PackageManagerInternal getPackageManagerInternalLocked() {
        if (this.mPmInternal != null) goto L6;
        this.mPmInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
    L6:
        return this.mPmInternal;
    }

    ComponentName getSysUiServiceComponentLocked() {
        if (this.mSysUiServiceComponent != null) goto L6;
        PackageManagerInternal pm = getPackageManagerInternalLocked();
        this.mSysUiServiceComponent = pm.getSystemUiServiceComponent();
    L6:
        return this.mSysUiServiceComponent;
    }

    PermissionPolicyInternal getPermissionPolicyInternal() {
        if (this.mPermissionPolicyInternal != null) goto L6;
        this.mPermissionPolicyInternal = (PermissionPolicyInternal) LocalServices.getService(PermissionPolicyInternal.class);
    L6:
        return this.mPermissionPolicyInternal;
    }

    StatusBarManagerInternal getStatusBarManagerInternal() {
        if (this.mStatusBarManagerInternal != null) goto L6;
        this.mStatusBarManagerInternal = (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);
    L6:
        return this.mStatusBarManagerInternal;
    }

    UserManagerInternal getUserManagerInternal() {
        if (this.mUserManagerInternal != null) goto L6;
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
    L6:
        return this.mUserManagerInternal;
    }

    ActivityRecord.WindowStyle getWindowStyle(String packageName, int theme, int userId) {
        ActivityRecord.WindowStyle cachedStyle = SysOptBridge.getFactory().getAppRecordManagerService().getCachedWindowStyle(packageName, theme, userId);
        if (cachedStyle == null) goto L6;
        return cachedStyle;
    L6:
        return this.mWindowStyleCache.get(packageName, theme, userId);
    }

    AppWarnings getAppWarningsLocked() {
        return this.mAppWarnings;
    }

    Intent getHomeIntent() {
        String r1 = this.mTopAction;
        if (this.mTopData == null) goto L5;
        Uri r2 = Uri.parse(this.mTopData);
    L6:
        Intent intent = new Intent(r1, r2);
        intent.setComponent(this.mTopComponent);
        intent.addFlags(256);
        if (this.mFactoryTest == 1) goto L9;
        intent.addCategory("android.intent.category.HOME");
    L9:
        return intent;
    L5:
        r2 = null;
        goto L6
    }

    Intent getSecondaryHomeIntent(String preferredPackage) {
        String r1 = this.mTopAction;
        if (this.mTopData == null) goto L5;
        Uri r2 = Uri.parse(this.mTopData);
    L6:
        Intent intent = new Intent(r1, r2);
        boolean useSystemProvidedLauncher = this.mContext.getResources().getBoolean(R.bool.config_viewRotaryEncoderHapticScrollFedbackEnabled);
        if (preferredPackage == null) goto L11;
        if (useSystemProvidedLauncher == true) goto L11;
        intent.setPackage(preferredPackage);
    L12:
        intent.addFlags(256);
        if (this.mFactoryTest == 1) goto L15;
        intent.addCategory("android.intent.category.SECONDARY_HOME");
    L15:
        return intent;
    L11:
        String secondaryHomePackage = this.mContext.getResources().getString(R.string.contentServiceSync);
        intent.setPackage(secondaryHomePackage);
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    ApplicationInfo getAppInfoForUser(ApplicationInfo info, int userId) {
        if (info != null) goto L5;
        return null;
    L5:
        ApplicationInfo newInfo = new ApplicationInfo(info);
        newInfo.initForUser(userId);
        return newInfo;
    }

    WindowProcessController getProcessController(String processName, int uid) {
        if (uid != 1000) goto L19;
        SparseArray<WindowProcessController> procs = (SparseArray) this.mProcessNames.getMap().get(processName);
        if (procs != null) goto L8;
        return null;
    L8:
        int procCount = procs.size();
        int i = 0;
    L9:
        if (i >= procCount) goto L19;
        int procUid = procs.keyAt(i);
        if (UserHandle.isCore(procUid) == false) goto L17;
        if (UserHandle.isSameUser(procUid, uid) == false) goto L17;
        return procs.valueAt(i);
    L17:
        i = i + 1;
    L19:
        return (WindowProcessController) this.mProcessNames.get(processName, uid);
    }

    WindowProcessController getProcessController(IApplicationThread thread) {
        if (thread != null) goto L5;
        return null;
    L5:
        IBinder threadBinder = thread.asBinder();
        ArrayMap<String, SparseArray<WindowProcessController>> pmap = this.mProcessNames.getMap();
        int i = pmap.size() - 1;
    L6:
        if (i < 0) goto L17;
        SparseArray<WindowProcessController> procs = pmap.valueAt(i);
        int j = procs.size() - 1;
    L8:
        if (j < 0) goto L15;
        WindowProcessController proc = procs.valueAt(j);
        if (proc.hasThread() == false) goto L14;
        if (proc.getThread().asBinder() != threadBinder) goto L14;
        return proc;
    L14:
        j = j - 1;
        goto L8
    L15:
        i = i - 1;
        goto L6
    L17:
        return null;
    }

    WindowProcessController getProcessController(int pid, int uid) {
        WindowProcessController proc = this.mProcessMap.getProcess(pid);
        if (proc != null) goto L6;
        return null;
    L6:
        if (UserHandle.isApp(uid) == true) goto L8;
    L10:
        return null;
    L8:
        if (proc.mUid != uid) goto L10;
        return proc;
    }

    String getPackageNameIfUnique(int uid, int pid) {
        WindowProcessController proc = this.mProcessMap.getProcess(pid);
        if (proc != null) goto L5;
    L13:
        Slog.w("ActivityTaskManager", "callingPackage for (uid=" + uid + ", pid=" + pid + ") has no WPC");
        return null;
    L5:
        if (proc.mUid != uid) goto L13;
        List<String> realCallingPackages = proc.getPackageList();
        if (realCallingPackages.size() == 1) goto L12;
        Slog.w("ActivityTaskManager", "callingPackage for (uid=" + uid + ", pid=" + pid + ") is ambiguous: " + realCallingPackages);
        return null;
    L12:
        return realCallingPackages.get(0);
    }

    boolean hasActiveVisibleWindow(int uid) {
        if (this.mVisibleActivityProcessTracker.hasVisibleActivity(uid) == false) goto L7;
        return true;
    L7:
        return this.mActiveUids.hasNonAppVisibleWindow(uid);
    }

    boolean isDeviceOwner(int uid) {
        if (uid >= 0) goto L4;
    L6:
        return false;
    L4:
        if (this.mDeviceOwnerUid != uid) goto L6;
        return true;
    }

    void setDeviceOwnerUid(int uid) {
        this.mDeviceOwnerUid = uid;
    }

    boolean isAffiliatedProfileOwner(int uid) {
        if (uid >= 0) goto L4;
    L8:
        return false;
    L4:
        if (this.mProfileOwnerUids.contains(Integer.valueOf(uid)) == false) goto L8;
        if (DeviceStateCache.getInstance().hasAffiliationWithDevice(UserHandle.getUserId(uid)) == false) goto L8;
        return true;
    }

    void setProfileOwnerUids(Set<Integer> uids) {
        this.mProfileOwnerUids = uids;
    }

    void saveANRState(ActivityRecord activity, String reason) {
        StringWriter sw = new StringWriter();
        final PrintWriter pw = new FastPrintWriter(sw, false, 1024);
        pw.println("  ANR time: " + DateFormat.getDateTimeInstance().format(new Date()));
        if (reason == null) goto L5;
        pw.println("  Reason: " + reason);
    L5:
        pw.println();
        if (activity == null) goto L13;
        Task rootTask = activity.getRootTask();
        if (rootTask == null) goto L10;
        rootTask.forAllTaskFragments(new ActivityTaskManagerService$$ExternalSyntheticLambda21(pw));
        pw.println();
    L10:
        this.mActivityStartController.dump(pw, "  ", activity.packageName);
        if (this.mActivityStartController.getLastStartActivity() == activity) goto L13;
        activity.dump(pw, "  ", true);
    L13:
        ActivityTaskSupervisor.printThisActivity(pw, this.mRootWindowContainer.getTopResumedActivity(), null, -1, true, "  ResumedActivity: ", null);
        this.mLockTaskController.dump(pw, "  ");
        this.mKeyguardController.dump(pw, "  ");
        pw.println("-------------------------------------------------------------------------------");
        pw.close();
        this.mLastANRState = sw.toString();
    }

    private static /* synthetic */ void lambda$saveANRState$18(PrintWriter pw, TaskFragment tf) {
        tf.dumpInner("  ", pw, true, null);
    }

    boolean isAssociatedCompanionApp(int userId, int uid) {
        Set<Integer> allUids = this.mCompanionAppUidsMap.get(Integer.valueOf(userId));
        if (allUids != null) goto L7;
        return false;
    L7:
        return allUids.contains(Integer.valueOf(uid));
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        return super.onTransact(code, data, reply, flags);
    L4:
        e = move-exception;
        throw logAndRethrowRuntimeExceptionOnTransact("ActivityTaskManager", e);
    }

    static RuntimeException logAndRethrowRuntimeExceptionOnTransact(String name, RuntimeException e) {
        if ((e instanceof SecurityException) == true) goto L6;
        Slog.w("ActivityTaskManager", name + " onTransact aborts UID:" + Binder.getCallingUid() + " PID:" + Binder.getCallingPid(), e);
        throw e;
    L6:
        throw e;
    }

    public void setRunningRemoteTransitionDelegate(IBinder transitionToken) {
        Transition transition = Transition.fromBinder(transitionToken);
        if (transition != null) goto L5;
        return;
    L5:
        IApplicationThread delegate = transition.mRemoteDelegate;
        TransitionController controller = getTransitionController();
        if (delegate != null) goto L8;
    L10:
        this.mAmInternal.enforceCallingPermission("android.permission.CONTROL_REMOTE_APP_TRANSITION_ANIMATIONS", "setRunningRemoteTransition");
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        WindowManagerGlobalLock r5 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r5);
        WindowProcessController callingProc = getProcessController(callingPid, callingUid);     // Catch: Throwable -> L22
        if (callingProc != null) goto L15;
    L28:
        String msg = "Can't call setRunningRemoteTransition from a process (pid=" + callingPid + " uid=" + callingUid + ") which isn't itself running a remote transition.";     // Catch: Throwable -> L22
        Slog.e("ActivityTaskManager", msg);     // Catch: Throwable -> L22
        throw new SecurityException(msg);     // Catch: Throwable -> L22
    L15:
        if (callingProc.isRunningRemoteTransition() == false) goto L28;
        WindowProcessController wpc = getProcessController(delegate);     // Catch: Throwable -> L22
        if (wpc != null) goto L24;
        Slog.w("ActivityTaskManager", "setRunningRemoteTransition: no process for " + delegate);     // Catch: Throwable -> L22
        monitor-exit(r5);     // Catch: Throwable -> L22
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L24:
        controller.mRemotePlayer.update(wpc, true, false);     // Catch: Throwable -> L22
        monitor-exit(r5);     // Catch: Throwable -> L22
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L22:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L8:
        if (controller.mRemotePlayer.reportRunning(delegate) == false) goto L10;
    }

    public void registerScreenCaptureObserver(IBinder activityToken, IScreenCaptureObserver observer) {
        this.mAmInternal.enforceCallingPermission("android.permission.DETECT_SCREEN_CAPTURE", "registerScreenCaptureObserver");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord activityRecord = ActivityRecord.forTokenLocked(activityToken);     // Catch: Throwable -> L7
        if (activityRecord == null) goto L9;
        activityRecord.registerCaptureObserver(observer);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void unregisterScreenCaptureObserver(IBinder activityToken, IScreenCaptureObserver observer) {
        this.mAmInternal.enforceCallingPermission("android.permission.DETECT_SCREEN_CAPTURE", "unregisterScreenCaptureObserver");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord activityRecord = ActivityRecord.forTokenLocked(activityToken);     // Catch: Throwable -> L7
        if (activityRecord == null) goto L9;
        activityRecord.unregisterCaptureObserver(observer);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void registerCompatScaleProvider(int id, CompatScaleProvider provider) {
        this.mCompatModePackages.registerCompatScaleProvider(id, provider);
    }

    void unregisterCompatScaleProvider(int id) {
        this.mCompatModePackages.unregisterCompatScaleProvider(id);
    }

    boolean instrumentationSourceHasPermission(int pid, String permission) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowProcessController process = this.mProcessMap.getProcess(pid);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();
        if (process != null) goto L9;
    L15:
        return false;
    L9:
        if (process.isInstrumenting() == false) goto L15;
        int sourceUid = process.getInstrumentationSourceUid();
        if (checkPermission(permission, -1, sourceUid) != 0) goto L22;
        return true;
    L22:
        return false;
    L16:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean registerBackgroundActivityStartCallback(IBinder callback) {
        return this.mTaskSupervisor.getBackgroundActivityLaunchController().addStrictModeCallback(Binder.getCallingUid(), callback);
    }

    public void unregisterBackgroundActivityStartCallback(IBinder callback) {
        this.mTaskSupervisor.getBackgroundActivityLaunchController().removeStrictModeCallback(Binder.getCallingUid(), callback);
    }

    private SafeActivityOptions createSafeActivityOptionsWithBalAllowed(ActivityOptions options) {
        if (options != null) goto L6;
        options = ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1);
    L9:
        return new SafeActivityOptions(options, Binder.getCallingPid(), Binder.getCallingUid());
    L6:
        if (options.getPendingIntentBackgroundActivityStartMode() != 0) goto L9;
        options.setPendingIntentBackgroundActivityStartMode(1);
        goto L9
    }

    private SafeActivityOptions createSafeActivityOptionsWithBalAllowed(Bundle bOptions) {
        return createSafeActivityOptionsWithBalAllowed(ActivityOptions.fromBundle(bOptions));
    }

    static {
        sIsPip2ExperimentEnabled = null;
    }

    static boolean isPip2ExperimentEnabled() {
        if (sIsPip2ExperimentEnabled != null) goto L17;
        FeatureInfo arcFeature = SystemConfig.getInstance().getAvailableFeatures().get("org.chromium.arc");
        FeatureInfo tvFeature = SystemConfig.getInstance().getAvailableFeatures().get("android.software.leanback");
        if (arcFeature == null) goto L10;
        if (arcFeature.version >= 0) goto L10;
    L10:
        if (tvFeature == null) goto L15;
        if (tvFeature.version >= 0) goto L15;
    L15:
        sIsPip2ExperimentEnabled = false;
    L17:
        return sIsPip2ExperimentEnabled.booleanValue();
    }

    public boolean hasAlertWindow(int callingUid, int callingPid) {
        return this.mWindowManager.hasAlertWindow(callingUid, callingPid);
    }

    public IExtATMService getExt() {
        return this.mIExt;
    }

    public WindowProcessController getHomeProcess() {
        return this.mHomeProcess;
    }

    public ActivityTaskManagerServiceSmtEx getSmtEx() {
        return this.mSmtEx;
    }

    public IObricActivityTaskManagerService getObricExt() {
        return this.mObricExt;
    }

    public IObricActivityTaskManager getIObricExt() {
        return this.mObricExt.getIObricExt();
    }
}
