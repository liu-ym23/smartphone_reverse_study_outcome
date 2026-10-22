package com.android.server.wm;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.IApplicationThread;
import android.app.ProfilerInfo;
import android.app.SysFwBridge;
import android.app.SysMonitorFwBridge;
import android.app.WaitResult;
import android.app.compat.CompatChanges;
import android.app.doppelganger.DoppelgangerManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.AuxiliaryResolveInfo;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.OperationCanceledException;
import android.os.RemoteException;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.pico.utils.ExtImplFactory;
import android.pico.utils.Features;
import android.service.voice.IVoiceInteractionSession;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Pools;
import android.util.Slog;
import android.widget.Toast;
import android.window.ITaskFragmentOrganizer;
import android.window.RemoteTransition;
import com.android.internal.app.HeavyWeightSwitcherActivity;
import com.android.internal.app.IVoiceInteractor;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.BaseZswSystemServiceFactory;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.am.ActivityManagerService;
import com.android.server.am.IApplicationFreezer;
import com.android.server.am.PendingIntentRecord;
import com.android.server.am.ProcessList;
import com.android.server.common.Constants;
import com.android.server.dispatcher.GameActivityStateEventDispatcher;
import com.android.server.perf.IPerfThermalMonitor;
import com.android.server.pm.InstantAppResolver;
import com.android.server.pm.PackageArchiver;
import com.android.server.pm.PackageManagerService;
import com.android.server.power.ShutdownCheckPoints;
import com.android.server.redmagic.GameKeysPatch;
import com.android.server.statusbar.StatusBarManagerInternal;
import com.android.server.uri.NeededUriGrants;
import com.android.server.uri.UriGrantsManagerInternal;
import com.obric.utils.ObricImplFactory;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class ActivityStarter {
    static final long ASM_RESTRICTIONS = 230590090;
    static final long ENABLE_PENDING_INTENT_BAL_OPTION = 192341120;
    private static final long ENABLE_PREVENT_INTENT_REDIRECT_TAKE_ACTION = 29623414;
    static final int INTENT_REDIRECT_ABORT_INTENT_FIREWALL_START_ACTIVITY = 5;
    static final int INTENT_REDIRECT_ABORT_PERMISSION_POLICY_START_ACTIVITY = 6;
    static final int INTENT_REDIRECT_ABORT_START_ANY_ACTIVITY_PERMISSION = 4;
    static final int INTENT_REDIRECT_EXCEPTION_GRANT_URI_PERMISSION = 2;
    static final int INTENT_REDIRECT_EXCEPTION_MISSING_OR_INVALID_TOKEN = 1;
    static final int INTENT_REDIRECT_EXCEPTION_START_ANY_ACTIVITY_PERMISSION = 3;
    private static final int INVALID_LAUNCH_MODE = -1;
    private static final long MAX_TASK_WEIGHT_FOR_ADDING_ACTIVITY = 300;
    private static final int MOVE_TO_FRONT_ALLOWED = 0;
    private static final int MOVE_TO_FRONT_AVOID_LEGACY = 2;
    private static final int MOVE_TO_FRONT_AVOID_PI_ONLY_CREATOR_ALLOWS = 1;
    private static final String TAG = "ActivityTaskManager";
    private static final String TAG_CONFIGURATION = "ActivityTaskManager";
    private static final String TAG_FOCUS = "ActivityTaskManager";
    private static final String TAG_RESULTS = "ActivityTaskManager";
    private static final String TAG_USER_LEAVING = "ActivityTaskManager";
    boolean mAddingToTask;
    private TaskFragment mAddingToTaskFragment;
    private int mBalCode;
    private int mCallingUid;
    private int mCanMoveToFrontCode;
    private final ActivityStartController mController;
    private boolean mDisplayLockAndOccluded;
    private boolean mDoResume;
    private IExtActivityStarter mExt;
    private boolean mFrozeTaskList;
    private Task mInTask;
    private TaskFragment mInTaskFragment;
    private Intent mIntent;
    private boolean mIntentDelivered;
    private final ActivityStartInterceptor mInterceptor;
    private boolean mIsTaskCleared;
    private ActivityRecord mLastStartActivityRecord;
    private int mLastStartActivityResult;
    private long mLastStartActivityTimeMs;
    private String mLastStartReason;
    private int mLaunchFlags;
    private int mLaunchMode;
    private LaunchParamsController.LaunchParams mLaunchParams;
    private boolean mLaunchTaskBehind;
    private boolean mMovedToFront;
    ActivityRecord mMovedToTopActivity;
    private boolean mNoAnimation;
    private ActivityRecord mNotTop;
    private IObricActivityStarter mObricExt;
    private ActivityOptions mOptions;
    private TaskDisplayArea mPreferredTaskDisplayArea;
    private int mPreferredWindowingMode;
    private boolean mPrefetchFirstStart;
    private Task mPriorAboveTask;
    private int mRealCallingUid;
    Request mRequest;
    private final RootWindowContainer mRootWindowContainer;
    private final ActivityTaskManagerService mService;
    private ActivityRecord mSourceRecord;
    private Task mSourceRootTask;
    ActivityRecord mStartActivity;
    private int mStartFlags;
    private final ActivityTaskSupervisor mSupervisor;
    private Task mTargetRootTask;
    private Task mTargetTask;
    private boolean mTransientLaunch;
    private IVoiceInteractor mVoiceInteractor;
    private IVoiceInteractionSession mVoiceSession;
    IZswActivityStarter mZswExt;

    static class DefaultFactory implements Factory {
        private final int MAX_STARTER_COUNT;
        private ActivityStartController mController;
        private ActivityStartInterceptor mInterceptor;
        private ActivityTaskManagerService mService;
        private Pools.SynchronizedPool<ActivityStarter> mStarterPool;
        private ActivityTaskSupervisor mSupervisor;

        DefaultFactory(ActivityTaskManagerService service, ActivityTaskSupervisor supervisor, ActivityStartInterceptor interceptor) {
            this.MAX_STARTER_COUNT = 3;
            this.mStarterPool = new Pools.SynchronizedPool(3);
            this.mService = service;
            this.mSupervisor = supervisor;
            this.mInterceptor = interceptor;
        }

        @Override // com.android.server.wm.ActivityStarter.Factory
        public void setController(ActivityStartController controller) {
            this.mController = controller;
        }

        @Override // com.android.server.wm.ActivityStarter.Factory
        public ActivityStarter obtain() {
            ActivityStarter starter = (ActivityStarter) this.mStarterPool.acquire();
            if (starter == null) goto L5;
            return starter;
        L5:
            if (this.mService.mRootWindowContainer == null) goto L8;
            return new ActivityStarter(this.mController, this.mService, this.mSupervisor, this.mInterceptor);
        L8:
            throw new IllegalStateException("Too early to start activity.");
        }

        @Override // com.android.server.wm.ActivityStarter.Factory
        public void recycle(ActivityStarter starter) {
            starter.reset(true);
            this.mStarterPool.release(starter);
        }
    }

    interface Factory {
        ActivityStarter obtain();

        void recycle(ActivityStarter r1);

        void setController(ActivityStartController r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface IntentRedirectErrorCode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MoveToFrontCode {
    }

    static class Request {
        private static final int DEFAULT_CALLING_PID = 0;
        private static final int DEFAULT_CALLING_UID = -1;
        static final int DEFAULT_INTENT_CREATOR_UID = -1;
        static final int DEFAULT_REAL_CALLING_PID = 0;
        static final int DEFAULT_REAL_CALLING_UID = -1;
        ActivityInfo activityInfo;
        SafeActivityOptions activityOptions;
        boolean allowBalExemptionForSystemProcess;
        boolean allowPendingRemoteAnimationRegistryLookup;
        boolean avoidMoveToFront;
        IApplicationThread caller;
        String callingFeatureId;
        String callingPackage;
        int callingPid;
        int callingUid;
        boolean componentSpecified;
        Intent ephemeralIntent;
        IBinder errorCallbackToken;
        int filterCallingUid;
        boolean freezeScreen;
        Configuration globalConfig;
        boolean ignoreTargetSecurity;
        Task inTask;
        TaskFragment inTaskFragment;
        Intent intent;
        String intentCreatorPackage;
        int intentCreatorUid;
        NeededUriGrants intentGrants;
        final StringBuilder logMessage;
        PendingIntentRecord originatingPendingIntent;
        ActivityRecord[] outActivity;
        ProfilerInfo profilerInfo;
        int realCallingPid;
        int realCallingUid;
        String reason;
        int requestCode;
        ResolveInfo resolveInfo;
        String resolvedType;
        IBinder resultTo;
        String resultWho;
        int startFlags;
        int userId;
        IVoiceInteractor voiceInteractor;
        IVoiceInteractionSession voiceSession;
        WaitResult waitResult;

        Request() {
            this.callingPid = 0;
            this.callingUid = -1;
            this.realCallingPid = 0;
            this.realCallingUid = -1;
            this.intentCreatorUid = -1;
            this.logMessage = new StringBuilder();
            reset();
        }

        void reset() {
            this.caller = null;
            this.intent = null;
            this.intentGrants = null;
            this.ephemeralIntent = null;
            this.resolvedType = null;
            this.activityInfo = null;
            this.resolveInfo = null;
            this.voiceSession = null;
            this.voiceInteractor = null;
            this.resultTo = null;
            this.resultWho = null;
            this.requestCode = 0;
            this.callingPid = 0;
            this.callingUid = -1;
            this.callingPackage = null;
            this.intentCreatorUid = -1;
            this.intentCreatorPackage = null;
            this.callingFeatureId = null;
            this.realCallingPid = 0;
            this.realCallingUid = -1;
            this.startFlags = 0;
            this.activityOptions = null;
            this.ignoreTargetSecurity = false;
            this.componentSpecified = false;
            this.outActivity = null;
            this.inTask = null;
            this.inTaskFragment = null;
            this.reason = null;
            this.profilerInfo = null;
            this.globalConfig = null;
            this.userId = 0;
            this.waitResult = null;
            this.avoidMoveToFront = false;
            this.allowPendingRemoteAnimationRegistryLookup = true;
            this.filterCallingUid = ProcessList.INVALID_ADJ;
            this.originatingPendingIntent = null;
            this.allowBalExemptionForSystemProcess = false;
            this.freezeScreen = false;
            this.errorCallbackToken = null;
        }

        void set(Request request) {
            this.caller = request.caller;
            this.intent = request.intent;
            this.intentGrants = request.intentGrants;
            this.ephemeralIntent = request.ephemeralIntent;
            this.resolvedType = request.resolvedType;
            this.activityInfo = request.activityInfo;
            this.resolveInfo = request.resolveInfo;
            this.voiceSession = request.voiceSession;
            this.voiceInteractor = request.voiceInteractor;
            this.resultTo = request.resultTo;
            this.resultWho = request.resultWho;
            this.requestCode = request.requestCode;
            this.callingPid = request.callingPid;
            this.callingUid = request.callingUid;
            this.callingPackage = request.callingPackage;
            this.callingFeatureId = request.callingFeatureId;
            this.realCallingPid = request.realCallingPid;
            this.realCallingUid = request.realCallingUid;
            this.startFlags = request.startFlags;
            this.activityOptions = request.activityOptions;
            this.ignoreTargetSecurity = request.ignoreTargetSecurity;
            this.componentSpecified = request.componentSpecified;
            this.outActivity = request.outActivity;
            this.inTask = request.inTask;
            this.inTaskFragment = request.inTaskFragment;
            this.reason = request.reason;
            this.profilerInfo = request.profilerInfo;
            this.globalConfig = request.globalConfig;
            this.userId = request.userId;
            this.waitResult = request.waitResult;
            this.avoidMoveToFront = request.avoidMoveToFront;
            this.allowPendingRemoteAnimationRegistryLookup = request.allowPendingRemoteAnimationRegistryLookup;
            this.filterCallingUid = request.filterCallingUid;
            this.originatingPendingIntent = request.originatingPendingIntent;
            this.allowBalExemptionForSystemProcess = request.allowBalExemptionForSystemProcess;
            this.freezeScreen = request.freezeScreen;
            this.errorCallbackToken = request.errorCallbackToken;
        }

        void resolveActivity(ActivityTaskSupervisor supervisor) {
            if (this.realCallingPid != 0) goto L6;
            this.realCallingPid = Binder.getCallingPid();
        L6:
            if (this.realCallingUid != (-1)) goto L9;
            this.realCallingUid = Binder.getCallingUid();
        L9:
            if (this.callingUid < 0) goto L12;
            this.callingPid = -1;
        L15:
            int resolvedCallingUid = this.callingUid;
            String resolvedCallingPackage = this.callingPackage;
            if (this.caller == null) goto L29;
            WindowManagerGlobalLock r5 = supervisor.mService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r5);
            WindowProcessController callerApp = supervisor.mService.getProcessController(this.caller);     // Catch: Throwable -> L22
            if (callerApp == null) goto L24;
            resolvedCallingUid = callerApp.mInfo.uid;     // Catch: Throwable -> L22
            resolvedCallingPackage = callerApp.mInfo.packageName;     // Catch: Throwable -> L22
        L24:
            monitor-exit(r5);     // Catch: Throwable -> L22
            WindowManagerService.resetPriorityAfterLockedSection();
            int resolvedCallingUid2 = resolvedCallingUid;
            String resolvedCallingPackage2 = resolvedCallingPackage;
        L30:
            this.ephemeralIntent = new Intent(this.intent);
            this.intent = new Intent(this.intent);
            if (this.intent.getComponent() != null) goto L33;
        L43:
            this.resolveInfo = supervisor.resolveIntent(this.intent, this.resolvedType, this.userId, 0, ActivityStarter.computeResolveFilterUid(this.callingUid, this.realCallingUid, this.filterCallingUid), this.realCallingPid);
            if (this.resolveInfo != null) goto L47;
            this.resolveInfo = resolveIntentForLockedOrStoppedProfiles(supervisor);
        L47:
            if (DoppelgangerManager.isActive() == true) goto L49;
            ActivityTaskSupervisor r2 = supervisor;
        L63:
            this.activityInfo = r2.resolveActivity(this.intent, this.resolveInfo, this.startFlags, this.profilerInfo);
            if ((this.intent.getExtendedFlags() & 2) == 0) goto L68;
            ActivityStarter.logAndThrowExceptionForIntentRedirect(r2.mService.mContext, 1, this.intent, this.intentCreatorUid, this.intentCreatorPackage, resolvedCallingUid2, resolvedCallingPackage2, null);
        L68:
            if (ActivityManagerService.IntentCreatorToken.isValid(this.intent) == false) goto L73;
            ActivityManagerService.IntentCreatorToken creatorToken = (ActivityManagerService.IntentCreatorToken) this.intent.getCreatorToken();
            if (creatorToken.getCreatorUid() == resolvedCallingUid2) goto L73;
            this.intentCreatorUid = creatorToken.getCreatorUid();
            this.intentCreatorPackage = creatorToken.getCreatorPackage();
        L73:
            if (this.activityInfo == null) goto L90;
            int doppelgangerSourceUid = this.intent.getSmtEx().getSmtIntExtra("extra_source_calling_uid", -1);
            if (doppelgangerSourceUid <= (-1)) goto L77;
            int resolvedCallingUid3 = doppelgangerSourceUid;
        L78:
            this.intentGrants = r2.mService.mUgmInternal.checkGrantUriPermissionFromIntent(this.intent, resolvedCallingUid3, this.activityInfo.applicationInfo.packageName, UserHandle.getUserId(this.activityInfo.applicationInfo.uid), this.activityInfo.requireContentUriPermissionFromCaller, hashCode());
            if (this.intentCreatorUid == (-1)) goto L96;
            NeededUriGrants creatorIntentGrants = r2.mService.mUgmInternal.checkGrantUriPermissionFromIntent(this.intent, this.intentCreatorUid, this.activityInfo.applicationInfo.packageName, UserHandle.getUserId(this.activityInfo.applicationInfo.uid), this.activityInfo.requireContentUriPermissionFromCaller, hashCode());     // Catch: SecurityException -> L83
            if (this.intentGrants != null) goto L85;
            this.intentGrants = creatorIntentGrants;     // Catch: SecurityException -> L83
        L93:
            goto L96
        L85:
            this.intentGrants.merge(creatorIntentGrants);     // Catch: SecurityException -> L83
        L83:
            securityException = move-exception;
            int resolvedCallingUid4 = resolvedCallingUid3;
            ActivityStarter.logAndThrowExceptionForIntentRedirect(r2.mService.mContext, 2, this.intent, this.intentCreatorUid, this.intentCreatorPackage, resolvedCallingUid4, resolvedCallingPackage2, securityException);
            resolvedCallingUid3 = resolvedCallingUid4;
        L96:
            return;
        L77:
            resolvedCallingUid3 = resolvedCallingUid2;
            goto L78
        L90:
            return;
        L49:
            if ((this.intent.getFlags() & 1048576) != 0) goto L51;
            r2 = supervisor;
            Pair<Pair<ResolveInfo, Intent>, SafeActivityOptions> pair = ActivityStackSupervisorHook.hookStartActivityMayWait(r2, this.resolveInfo, this.intent, this.userId, this.resolvedType, this.profilerInfo, this.callingPackage, this.activityOptions);
            this.resolveInfo = (ResolveInfo) ((Pair) pair.first).first;
            this.intent = (Intent) ((Pair) pair.first).second;
            this.activityOptions = (SafeActivityOptions) pair.second;
        L53:
            if (this.userId != 10) goto L55;
            boolean isDoppelgangerUser = true;
        L56:
            if (isDoppelgangerUser == false) goto L63;
            if (this.intent == null) goto L63;
            if ("android.media.action.IMAGE_CAPTURE".equals(this.intent.getAction()) == false) goto L63;
            this.intent.prepareToLeaveUser(this.userId);
            Slog.i("ActivityTaskManager", "prepareToLeaveUser for IMAGE_CAPTURE: u" + this.userId + " intent=" + this.intent);
            goto L63
        L55:
            isDoppelgangerUser = false;
            goto L56
        L51:
            r2 = supervisor;
            goto L53
        L33:
            if ("android.intent.action.VIEW".equals(this.intent.getAction()) == false) goto L37;
            if (this.intent.getData() == null) goto L43;
        L37:
            if ("android.intent.action.INSTALL_INSTANT_APP_PACKAGE".equals(this.intent.getAction()) == true) goto L43;
            if ("android.intent.action.RESOLVE_INSTANT_APP_PACKAGE".equals(this.intent.getAction()) == true) goto L43;
            if (supervisor.mService.getPackageManagerInternalLocked().isInstantAppInstallerComponent(this.intent.getComponent()) == false) goto L43;
            this.intent.setComponent(null);
        L22:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L29:
            resolvedCallingUid2 = resolvedCallingUid;
            resolvedCallingPackage2 = resolvedCallingPackage;
            goto L30
        L12:
            if (this.caller != null) goto L14;
            this.callingPid = this.realCallingPid;
            this.callingUid = this.realCallingUid;
            goto L15
        L14:
            this.callingUid = -1;
            this.callingPid = -1;
            goto L15
        }

        ResolveInfo resolveIntentForLockedOrStoppedProfiles(ActivityTaskSupervisor supervisor) {
            UserInfo userInfo = supervisor.getUserInfo(this.userId);
            if (userInfo == null) goto L27;
            if (userInfo.isProfile() == false) goto L27;
            UserManager userManager = UserManager.get(supervisor.mService.mContext);
            long token = Binder.clearCallingIdentity();
            UserInfo parent = userManager.getProfileParent(this.userId);     // Catch: Throwable -> L22
            if (parent != null) goto L29;
        L16:
            boolean profileLockedAndParentUnlockingOrUnlocked = false;
        L17:
            Binder.restoreCallingIdentity(token);
            if (profileLockedAndParentUnlockingOrUnlocked == false) goto L33;
            return supervisor.resolveIntent(this.intent, this.resolvedType, this.userId, 786432, ActivityStarter.computeResolveFilterUid(this.callingUid, this.realCallingUid, this.filterCallingUid), this.realCallingPid);
        L33:
            return null;
        L29:
        L14:
            th = th;
        L24:
            Binder.restoreCallingIdentity(token);
            throw th;
        L10:
            if (userManager.isUserUnlockingOrUnlocked(parent.id) == false) goto L16;
            if (userManager.isUserUnlockingOrUnlocked(this.userId) == true) goto L16;
            profileLockedAndParentUnlockingOrUnlocked = true;
        L22:
            th = th;
        L27:
            return null;
        }
    }

    public static /* synthetic */ IntentSender $r8$lambda$VpzkeOnQfVl_Vv7TzBnE2MNG_dM(ActivityStarter r0, ActivityRecord r1) {
        return r0.lambda$isAllowedToStart$0(r1);
    }

    ActivityStarter(ActivityStartController controller, ActivityTaskManagerService service, ActivityTaskSupervisor supervisor, ActivityStartInterceptor interceptor) {
        this.mLaunchParams = new LaunchParamsController.LaunchParams();
        this.mCanMoveToFrontCode = 0;
        this.mPrefetchFirstStart = false;
        this.mRequest = new Request();
        this.mObricExt = (IObricActivityStarter) ObricImplFactory.getImpl(IObricActivityStarter.class, new Object[]{this});
        this.mExt = (IExtActivityStarter) ExtImplFactory.getImpl(IExtActivityStarter.class, new Object[]{this});
        this.mController = controller;
        this.mService = service;
        this.mRootWindowContainer = service.mRootWindowContainer;
        this.mSupervisor = supervisor;
        this.mInterceptor = interceptor;
        reset(true);
        this.mZswExt = BaseZswSystemServiceFactory.getZswSystemServiceFactoryImpl().createZswActivityStarter(this.mService, this.mSupervisor);
        this.mObricExt.setService(this.mService);
    }

    void set(ActivityStarter starter) {
        this.mStartActivity = starter.mStartActivity;
        this.mIntent = starter.mIntent;
        this.mCallingUid = starter.mCallingUid;
        this.mRealCallingUid = starter.mRealCallingUid;
        this.mOptions = starter.mOptions;
        this.mBalCode = starter.mBalCode;
        this.mLaunchTaskBehind = starter.mLaunchTaskBehind;
        this.mLaunchFlags = starter.mLaunchFlags;
        this.mLaunchMode = starter.mLaunchMode;
        this.mLaunchParams.set(starter.mLaunchParams);
        this.mNotTop = starter.mNotTop;
        this.mDoResume = starter.mDoResume;
        this.mStartFlags = starter.mStartFlags;
        this.mSourceRecord = starter.mSourceRecord;
        this.mPreferredTaskDisplayArea = starter.mPreferredTaskDisplayArea;
        this.mPreferredWindowingMode = starter.mPreferredWindowingMode;
        this.mInTask = starter.mInTask;
        this.mInTaskFragment = starter.mInTaskFragment;
        this.mAddingToTask = starter.mAddingToTask;
        this.mSourceRootTask = starter.mSourceRootTask;
        this.mTargetTask = starter.mTargetTask;
        this.mTargetRootTask = starter.mTargetRootTask;
        this.mIsTaskCleared = starter.mIsTaskCleared;
        this.mMovedToFront = starter.mMovedToFront;
        this.mNoAnimation = starter.mNoAnimation;
        this.mCanMoveToFrontCode = starter.mCanMoveToFrontCode;
        this.mFrozeTaskList = starter.mFrozeTaskList;
        this.mVoiceSession = starter.mVoiceSession;
        this.mVoiceInteractor = starter.mVoiceInteractor;
        this.mIntentDelivered = starter.mIntentDelivered;
        this.mLastStartActivityResult = starter.mLastStartActivityResult;
        this.mLastStartActivityTimeMs = starter.mLastStartActivityTimeMs;
        this.mLastStartReason = starter.mLastStartReason;
        this.mRequest.set(starter.mRequest);
    }

    boolean relatedToPackage(String packageName) {
        if (this.mLastStartActivityRecord == null) goto L7;
        if (packageName.equals(this.mLastStartActivityRecord.packageName) == false) goto L7;
    L10:
        return true;
    L7:
        if (this.mStartActivity != null) goto L9;
    L11:
        return false;
    L9:
        if (packageName.equals(this.mStartActivity.packageName) == false) goto L11;
        goto L10
    }

    int execute() {
        ActivityRecord launchingRecord = null;
        String r5 = null;
        onExecutionStarted();     // Catch: Throwable -> L8
        if (this.mRequest.intent != null) goto L6;
    L12:
        WindowManagerGlobalLock r8 = this.mService.mGlobalLock;     // Catch: Throwable -> L8
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L8
        monitor-enter(r8);     // Catch: Throwable -> L8
        ActivityRecord caller = ActivityRecord.forTokenLocked(this.mRequest.resultTo);     // Catch: Throwable -> L17
        if (this.mRequest.realCallingUid != (-1)) goto L19;
        int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L17
    L20:
        ActivityMetricsLogger.LaunchingState launchingState = this.mSupervisor.getActivityMetricsLogger().notifyActivityLaunching(this.mRequest.intent, caller, callingUid);     // Catch: Throwable -> L17
        if (caller == null) goto L24;
        String r10 = caller.info.name;     // Catch: Throwable -> L17
    L25:
        String callerActivityName = r10;
        monitor-exit(r8);     // Catch: Throwable -> L170
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L34
        if (this.mRequest.intent == null) goto L37;
        Request r0 = this.mRequest;     // Catch: Throwable -> L34
        boolean r2 = r0.componentSpecified;     // Catch: Throwable -> L34
        if (this.mRequest.intent.getComponent() == null) goto L32;
        boolean r9 = true;
    L33:
        r0.componentSpecified = r2 | r9;     // Catch: Throwable -> L34
        goto L37
    L32:
        r9 = false;
    L37:
        if (this.mRequest.activityInfo != null) goto L40;
        this.mRequest.resolveActivity(this.mSupervisor);     // Catch: Throwable -> L34
    L40:
        if (this.mRequest.intent == null) goto L51;
        String intentAction = this.mRequest.intent.getAction();     // Catch: Throwable -> L34
        String callingPackage = this.mRequest.callingPackage;     // Catch: Throwable -> L34
        if (intentAction == null) goto L51;
        if (callingPackage == null) goto L51;
        if ("com.android.internal.intent.action.REQUEST_SHUTDOWN".equals(intentAction) == false) goto L47;
    L50:
        ShutdownCheckPoints.recordCheckPoint(intentAction, callingPackage, null);     // Catch: Throwable -> L34
        goto L51
    L47:
        if ("android.intent.action.ACTION_SHUTDOWN".equals(intentAction) == true) goto L50;
        if ("android.intent.action.REBOOT".equals(intentAction) == true) goto L50;
    L51:
        int res = -96;
        WindowManagerGlobalLock r11 = this.mService.mGlobalLock;     // Catch: Throwable -> L34
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L34
        monitor-enter(r11);     // Catch: Throwable -> L34
    L58:
        th = th;
    L167:
        monitor-exit(r11);     // Catch: Throwable -> L58
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L54:
        if (this.mRequest.globalConfig != null) goto L56;
    L60:
        boolean r1 = false;
    L61:
        boolean globalConfigWillChange = r1;
        Task rootTask = this.mRootWindowContainer.getTopDisplayFocusedRootTask();     // Catch: Throwable -> L58
        if (rootTask == null) goto L65;
        rootTask.mConfigWillChange = globalConfigWillChange;     // Catch: Throwable -> L58
    L65:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L67;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, 1665699123574159131L, 3, new Object[]{Boolean.valueOf(globalConfigWillChange)});     // Catch: Throwable -> L58
    L67:
        long origId = Binder.clearCallingIdentity();     // Catch: Throwable -> L58
    L164:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L58
        StringBuilder r4 = this.mRequest.logMessage;     // Catch: Throwable -> L58
        r4.append(" result code=");     // Catch: Throwable -> L58
        r4.append(res);     // Catch: Throwable -> L58
        Slog.i("ActivityTaskManager", this.mRequest.logMessage.toString());     // Catch: Throwable -> L58
        this.mRequest.logMessage.setLength(0);     // Catch: Throwable -> L58
        throw th;     // Catch: Throwable -> L58
    L70:
        res = resolveToHeavyWeightSwitcherIfNeeded();     // Catch: Throwable -> L164
        if (res == 0) goto L97;
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L58
        StringBuilder r3 = this.mRequest.logMessage;     // Catch: Throwable -> L58
        r3.append(" result code=");     // Catch: Throwable -> L58
        r3.append(res);     // Catch: Throwable -> L58
        Slog.i("ActivityTaskManager", this.mRequest.logMessage.toString());     // Catch: Throwable -> L58
        this.mRequest.logMessage.setLength(0);     // Catch: Throwable -> L58
        monitor-exit(r11);     // Catch: Throwable -> L58
        WindowManagerService.resetPriorityAfterLockedSection();
        UriGrantsManagerInternal r13 = this.mSupervisor.mService.mUgmInternal;
        int r14 = this.mRequest.hashCode();
        if (0 == 0) goto L77;
        boolean r15 = true;
    L79:
        if (this.mRequest.intent == null) goto L81;
        String r16 = this.mRequest.intent.getAction();
    L82:
        int r6 = this.mRequest.realCallingUid;
        if (this.mRequest.activityInfo == null) goto L85;
        int r19 = this.mRequest.activityInfo.applicationInfo.uid;
    L87:
        if (this.mRequest.activityInfo == null) goto L89;
        r5 = this.mRequest.activityInfo.name;
    L89:
        String r20 = r5;
        if (0 != 0) goto L92;
    L94:
        boolean r21 = false;
    L95:
        r13.notifyActivityLaunchRequestCompleted(r14, r15, r16, r6, callerActivityName, r19, r20, r21);
        onExecutionComplete();
        return res;
    L92:
        if (launchingRecord.resultTo == null) goto L94;
        r21 = true;
        goto L95
    L85:
        r19 = -1;
        goto L87
    L81:
        r16 = null;
        goto L82
    L77:
        r15 = false;
        goto L79
    L97:
        int res2 = executeRequest(this.mRequest);     // Catch: Throwable -> L164
    L201:
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L103
        StringBuilder r7 = this.mRequest.logMessage;     // Catch: Throwable -> L103
        r7.append(" result code=");     // Catch: Throwable -> L103
        r7.append(res2);     // Catch: Throwable -> L103
        Slog.i("ActivityTaskManager", this.mRequest.logMessage.toString());     // Catch: Throwable -> L103
        this.mRequest.logMessage.setLength(0);     // Catch: Throwable -> L103
        if (globalConfigWillChange == false) goto L110;
        this.mService.mAmInternal.enforceCallingPermission("android.permission.CHANGE_CONFIGURATION", "updateConfiguration()");     // Catch: Throwable -> L103
        if (rootTask == null) goto L106;
        rootTask.mConfigWillChange = false;     // Catch: Throwable -> L103
    L106:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L108;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, 4748139468532105082L, 0, null);     // Catch: Throwable -> L103
    L108:
        this.mService.updateConfigurationLocked(this.mRequest.globalConfig, null, false);     // Catch: Throwable -> L103
    L110:
        if (this.mRequest.activityOptions == null) goto L112;
        ActivityOptions originalOptions = this.mRequest.activityOptions.getOriginalOptions();     // Catch: Throwable -> L103
    L114:
        if (this.mDoResume == true) goto L122;
        if (ActivityManager.isStartResultSuccessful(res2) == true) goto L118;
    L120:
        ActivityRecord launchingRecord2 = null;
    L210:
    L162:
        th = th;
        launchingRecord = launchingRecord2;
        goto L167
    L124:
        if (this.mStartActivity != launchingRecord2) goto L126;
        boolean newActivityCreated = true;
    L127:
        this.mSupervisor.getActivityMetricsLogger().notifyActivityLaunched(launchingState, res2, newActivityCreated, launchingRecord2, originalOptions);     // Catch: Throwable -> L162
        launchingRecord = launchingRecord2;
        if (this.mRequest.waitResult == null) goto L133;
        this.mRequest.waitResult.result = res2;     // Catch: Throwable -> L103
        int res3 = waitResultIfNeeded(this.mRequest.waitResult, this.mLastStartActivityRecord, launchingState);     // Catch: Throwable -> L103
    L206:
        int r12 = getExternalResult(res3);     // Catch: Throwable -> L160
        monitor-exit(r11);     // Catch: Throwable -> L160
        WindowManagerService.resetPriorityAfterLockedSection();
        UriGrantsManagerInternal r17 = this.mSupervisor.mService.mUgmInternal;
        int r18 = this.mRequest.hashCode();
        if (launchingRecord == null) goto L139;
        boolean r110 = true;
    L141:
        if (this.mRequest.intent == null) goto L143;
        String r111 = this.mRequest.intent.getAction();
    L144:
        int r22 = this.mRequest.realCallingUid;
        if (this.mRequest.activityInfo == null) goto L148;
        int r112 = this.mRequest.activityInfo.applicationInfo.uid;
    L150:
        if (this.mRequest.activityInfo == null) goto L152;
        String r23 = this.mRequest.activityInfo.name;
    L153:
        if (launchingRecord != null) goto L155;
    L157:
        boolean r24 = false;
    L158:
        r17.notifyActivityLaunchRequestCompleted(r18, r110, r111, r22, callerActivityName, r112, r23, r24);
        onExecutionComplete();
        return r12;
    L155:
        if (launchingRecord.resultTo == null) goto L157;
        r24 = true;
        goto L158
    L152:
        r23 = null;
        goto L153
    L148:
        r112 = -1;
        goto L150
    L143:
        r111 = null;
        goto L144
    L139:
        r110 = false;
    L160:
        th = th;
        goto L167
    L133:
        res3 = res2;
        goto L206
    L126:
        newActivityCreated = false;
        goto L127
    L118:
        if (this.mLastStartActivityRecord.getTask().isVisibleRequested() == false) goto L120;
    L122:
        launchingRecord2 = this.mLastStartActivityRecord;     // Catch: Throwable -> L103
        goto L210
    L112:
        originalOptions = null;
    L103:
        th = th;
        goto L167
    L56:
        if (this.mService.getGlobalConfiguration().diff(this.mRequest.globalConfig) == 0) goto L60;
        r1 = true;
    L34:
        th = th;
        String callerActivityName2 = callerActivityName;
    L175:
        UriGrantsManagerInternal r25 = this.mSupervisor.mService.mUgmInternal;
        int r26 = this.mRequest.hashCode();
        if (launchingRecord == null) goto L178;
        boolean r113 = true;
    L180:
        if (this.mRequest.intent == null) goto L182;
        String r114 = this.mRequest.intent.getAction();
    L183:
        int r115 = this.mRequest.realCallingUid;
        if (this.mRequest.activityInfo == null) goto L186;
        int r116 = this.mRequest.activityInfo.applicationInfo.uid;
    L188:
        if (this.mRequest.activityInfo == null) goto L190;
        String r117 = this.mRequest.activityInfo.name;
    L191:
        if (launchingRecord != null) goto L193;
    L195:
        boolean r118 = false;
    L196:
        r25.notifyActivityLaunchRequestCompleted(r26, r113, r114, r115, callerActivityName2, r116, r117, r118);
        onExecutionComplete();
        throw th;
    L193:
        if (launchingRecord.resultTo == null) goto L195;
        r118 = true;
        goto L196
    L190:
        r117 = null;
        goto L191
    L186:
        r116 = -1;
        goto L188
    L182:
        r114 = null;
        goto L183
    L178:
        r113 = false;
    L170:
        th = th;
    L172:
        monitor-exit(r8);     // Catch: Throwable -> L17
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L24:
        r10 = null;
        goto L25
    L19:
        callingUid = this.mRequest.realCallingUid;     // Catch: Throwable -> L17
    L17:
        th = th;
        goto L172
    L6:
        if (this.mRequest.intent.hasFileDescriptors() == true) goto L11;
        this.mRequest.intent.removeExtendedFlags(1);     // Catch: Throwable -> L8
        goto L12
    L11:
        throw new IllegalArgumentException("File descriptors passed in Intent");     // Catch: Throwable -> L8
    L8:
        th = th;
        callerActivityName2 = null;
        goto L175
    }

    private int resolveToHeavyWeightSwitcherIfNeeded() {
        if (this.mRequest.activityInfo != null) goto L5;
    L38:
        return 0;
    L5:
        if (this.mService.mHasHeavyWeightFeature == false) goto L38;
        if ((this.mRequest.activityInfo.applicationInfo.privateFlags & 2) == 0) goto L38;
        if (this.mRequest.activityInfo.processName.equals(this.mRequest.activityInfo.applicationInfo.packageName) == true) goto L12;
        return 0;
    L12:
        WindowProcessController heavy = this.mService.mHeavyWeightProcess;
        if (heavy != null) goto L15;
    L37:
        return 0;
    L15:
        if (heavy.mInfo.uid == this.mRequest.activityInfo.applicationInfo.uid) goto L17;
    L19:
        int appCallingUid = this.mRequest.callingUid;
        if (this.mRequest.caller == null) goto L26;
        WindowProcessController callerApp = this.mService.getProcessController(this.mRequest.caller);
        if (callerApp == null) goto L24;
        int appCallingUid2 = callerApp.mInfo.uid;
        int appCallingUid3 = appCallingUid2;
    L27:
        IIntentSender target = this.mService.getIntentSenderLocked(2, PackageManagerService.PLATFORM_PACKAGE_NAME, null, appCallingUid3, this.mRequest.userId, null, null, 0, new Intent[]{this.mRequest.intent}, new String[]{this.mRequest.resolvedType}, 1342177280, null);
        Intent newIntent = new Intent();
        if (this.mRequest.requestCode < 0) goto L30;
        newIntent.putExtra("has_result", true);
    L30:
        newIntent.putExtra("intent", new IntentSender(target));
        heavy.updateIntentForHeavyWeightActivity(newIntent);
        newIntent.putExtra("new_app", this.mRequest.activityInfo.packageName);
        newIntent.setFlags(this.mRequest.intent.getFlags());
        newIntent.setClassName(PackageManagerService.PLATFORM_PACKAGE_NAME, HeavyWeightSwitcherActivity.class.getName());
        this.mRequest.intent = newIntent;
        ActivityInfo r7 = null;
        this.mRequest.resolvedType = null;
        this.mRequest.caller = null;
        this.mRequest.callingUid = Binder.getCallingUid();
        this.mRequest.callingPid = Binder.getCallingPid();
        this.mRequest.componentSpecified = true;
        this.mRequest.resolveInfo = this.mSupervisor.resolveIntent(this.mRequest.intent, null, this.mRequest.userId, 0, computeResolveFilterUid(this.mRequest.callingUid, this.mRequest.realCallingUid, this.mRequest.filterCallingUid), this.mRequest.realCallingPid);
        Request r3 = this.mRequest;
        if (this.mRequest.resolveInfo == null) goto L33;
        r7 = this.mRequest.resolveInfo.activityInfo;
    L33:
        r3.activityInfo = r7;
        if (this.mRequest.activityInfo == null) goto L36;
        this.mRequest.activityInfo = this.mService.mAmInternal.getActivityInfoForUser(this.mRequest.activityInfo, this.mRequest.userId);
    L36:
        return 0;
    L24:
        Slog.w("ActivityTaskManager", "Unable to find app for caller " + this.mRequest.caller + " (pid=" + this.mRequest.callingPid + ") when starting: " + this.mRequest.intent.toString());
        SafeActivityOptions.abort(this.mRequest.activityOptions);
        return -94;
    L26:
        appCallingUid3 = appCallingUid;
        goto L27
    L17:
        if (heavy.mName.equals(this.mRequest.activityInfo.processName) == false) goto L19;
        goto L19
    }

    private int waitResultIfNeeded(WaitResult waitResult, ActivityRecord r, ActivityMetricsLogger.LaunchingState launchingState) {
        int res = waitResult.result;
        if (res != 3) goto L5;
    L17:
        waitResult.timeout = false;
        waitResult.who = r.mActivityComponent;
        waitResult.totalTime = 0;
        return res;
    L5:
        if (res == 2) goto L7;
    L11:
        this.mSupervisor.waitActivityVisibleOrLaunched(waitResult, r, launchingState);
        if (res == 0) goto L14;
    L16:
        return res;
    L14:
        if (waitResult.result != 2) goto L16;
        return 2;
    L7:
        if (r.nowVisible == false) goto L11;
        if (r.isState(ActivityRecord.State.RESUMED) == false) goto L11;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int executeRequest(Request request) {
        if (TextUtils.isEmpty(request.reason) == true) goto L509;
        this.mLastStartReason = request.reason;
        this.mLastStartActivityTimeMs = System.currentTimeMillis();
        IApplicationThread caller = request.caller;
        Intent intent = request.intent;
        NeededUriGrants intentGrants = request.intentGrants;
        String resolvedType = request.resolvedType;
        ActivityInfo aInfo = request.activityInfo;
        ResolveInfo rInfo = request.resolveInfo;
        IVoiceInteractionSession r3 = request.voiceSession;
        IBinder r5 = request.resultTo;
        String r7 = request.resultWho;
        int requestCode = request.requestCode;
        int callingPid = request.callingPid;
        int callingUid = request.callingUid;
        int intentCreatorUid = request.intentCreatorUid;
        String r14 = request.intentCreatorPackage;
        String callingPackage = request.callingPackage;
        NeededUriGrants intentGrants2 = intentGrants;
        String callingFeatureId = request.callingFeatureId;
        int realCallingPid = request.realCallingPid;
        int realCallingPid2 = request.realCallingUid;
        int startFlags = request.startFlags;
        SafeActivityOptions options = request.activityOptions;
        Task inTask = request.inTask;
        TaskFragment inTaskFragment = request.inTaskFragment;
        if (options == null) goto L7;
        Bundle r17 = options.popAppVerificationBundle();
    L8:
        Bundle verificationBundle = r17;
        if (caller == null) goto L14;
        Intent intent2 = intent;
        WindowProcessController callerApp = this.mService.getProcessController(caller);
        if (callerApp == null) goto L13;
        int callingPid2 = callerApp.getPid();
        WindowProcessController callerApp2 = callerApp;
        int callingUid2 = callerApp.mInfo.uid;
        int err = 0;
        int callingPid3 = callingPid2;
    L15:
        GameKeysPatch gameKeysPatch = GameKeysPatch.getInstance();
        if (gameKeysPatch == null) goto L21;
        Intent intent3 = intent2;
        WindowProcessController callerApp3 = callerApp2;
        int callingUid3 = callingUid2;
        boolean r0 = gameKeysPatch.interceptExecuteRequest(this.mService.mContext, this.mRootWindowContainer, intent3, rInfo, callingUid3, this.mService.hasAlertWindow(callingUid2, callingPid3), callerApp3);
        int intentCreatorUid2 = intentCreatorUid;
        Intent intent4 = intent3;
        callingUid2 = callingUid3;
        if (r0 == false) goto L23;
        return -94;
    L23:
        if (aInfo != null) goto L25;
    L27:
        int r39 = 0;
    L28:
        int userId = r39;
        if (aInfo == null) goto L31;
        int r1 = aInfo.launchMode;
    L32:
        int launchMode = r1;
        int isFromPrefetch = intent4.getSmtEx().getSmtIntExtra("prefetch_app", 0);
        if (isFromPrefetch == 0) goto L36;
        intent4.getSmtEx().removeSmtExtra("prefetch_app");
        aInfo.applicationInfo.getSysEx().prefetchReason |= 7;
    L36:
        if (aInfo == null) goto L45;
        if (aInfo.applicationInfo == null) goto L45;
        if (realCallingPid2 != 1000) goto L45;
        if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(isFromPrefetch) == false) goto L45;
        aInfo.applicationInfo.getSysEx().prefetchState |= 1;
        SysOptBridge.getFactory().getSysPrefetchService().setPrefetchState(aInfo.applicationInfo.uid, aInfo.applicationInfo.packageName, 1);
    L45:
        this.mPrefetchFirstStart = false;
        if (aInfo != null) goto L48;
    L71:
        callingPackage = callingPackage;
        int queryPrefetchState = 0;
        int setToAms = isFromPrefetch;
    L72:
        int finalPrefetchState = (isFromPrefetch | setToAms) | queryPrefetchState;
        if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(finalPrefetchState) == false) goto L90;
        if (aInfo == null) goto L90;
        if (aInfo.applicationInfo == null) goto L90;
        int finalPrefetchState2 = finalPrefetchState;
        int callingUid4 = callingUid2;
        SysOptBridge.getFactory().getSysPrefetchService().notifyActivityStart(aInfo.applicationInfo.packageName, intent4.getComponent().flattenToShortString());     // Catch: Exception -> L83
    L92:
        if (err != 0) goto L107;
        if (rInfo != 0) goto L95;
    L100:
        if (aInfo != null) goto L102;
    L106:
        String callingPackage2 = callingPackage;
        int callingUid5 = callingUid4;
        String r15 = " exception=";
        Intent intent5 = intent4;
    L108:
        String callingPackage3 = callingPackage2;
        if (err != 0) goto L149;
        StringBuilder r2 = request.logMessage;
        r2.append("START u");
        r2.append(userId);
        r2.append(" {");
        String r34 = "START u";
        String r35 = " {";
        r2.append(intent5.toShortString(true, true, true, false));
        r2.append("} with ");
        r2.append(ActivityInfo.launchModeToString(launchMode));
        r2.append(" from uid ");
        r2.append(callingUid5);
        if (callingUid5 == realCallingPid2) goto L116;
        if (realCallingPid2 == (-1)) goto L116;
        StringBuilder r4 = request.logMessage;
        r4.append(" (realCallingUid=");
        r4.append(realCallingPid2);
        r4.append(")");
    L116:
        if (Features.FEAT_QUICK_WIN == true) goto L118;
    L120:
        if (aInfo == null) goto L150;
        if (aInfo.applicationInfo == null) goto L150;
        String activityPkg = aInfo.applicationInfo.packageName;
        int uid = aInfo.applicationInfo.uid;
        if (activityPkg == null) goto L150;
        if (uid == (-1)) goto L150;
        if (this.mRootWindowContainer == null) goto L130;
        ActivityRecord r6 = this.mSupervisor.getTopResumedActivity();
    L131:
        ActivityRecord top = r6;
        if (top == null) goto L134;
        String r8 = top.packageName;
    L135:
        String focusedPkg = r8;
        if (focusedPkg == null) goto L141;
        String focusedPkg2 = focusedPkg;
        if (focusedPkg2.equals(activityPkg) == true) goto L150;
    L552:
        int unfreezedPid = this.mService.getSmtEx().setSvpBeforeUnfreeze(activityPkg, uid);     // Catch: Exception -> L144
    L146:
        SysOptBridge.getFactory().getApplicationFreezer().unfreezeAppIfNeededAsync(null, activityPkg, uid, IApplicationFreezer.UnfreezeReason.START_ACTIVITY, null, null);
        int unfreezedPid2 = unfreezedPid;
    L152:
        if (ActivityTaskManagerDebugConfig.DEBUG_PREFETCH == false) goto L154;
        StringBuilder r9 = new StringBuilder();
        r9.append("start u0 finalPrefetchState=");
        r9.append(finalPrefetchState2);
        r9.append("(");
        r9.append(isFromPrefetch);
        r9.append(" ");
        int setToAms2 = setToAms;
        r9.append(setToAms2);
        r9.append(" ");
        r9.append(queryPrefetchState);
        r9.append(")");
        Slog.i("SmartPrefetch", r9.toString());
    L155:
        ActivityRecord resultRecord = null;
        if (r5 == 0) goto L169;
        ActivityRecord sourceRecord = ActivityRecord.isInAnyTask(r5);
        if (ActivityTaskManagerDebugConfig.DEBUG_RESULTS == false) goto L161;
        Slog.v(r2, "Will send result to " + r5 + " " + sourceRecord);
    L161:
        if (sourceRecord == null) goto L168;
        if (requestCode >= 0) goto L164;
    L166:
        request.logMessage.append(" (sr=");
        resultRecord = null;
    L167:
        request.logMessage.append(System.identityHashCode(sourceRecord) + ")");
        ActivityRecord sourceRecord2 = sourceRecord;
    L170:
        int launchFlags = intent5.getFlags();
        if ((launchFlags & 33554432) == 0) goto L205;
        if (sourceRecord2 == null) goto L205;
        if (r12 < 0) goto L186;
        SafeActivityOptions.abort(r22);
        int callingPid4 = callingPid3;
        this.mService.getSmtEx().clearSvpBeforeUnfreeze(unfreezedPid2, callingPid4);     // Catch: Exception -> L179
        return -93;
    L179:
        e = e;
    L183:
        Slog.w(r2, "clearSvpBeforeUnfreeze error unfreezedPid " + unfreezedPid2 + r15 + e);
        return -93;
    L181:
        e = e;
        callingPid4 = callingPid3;
        goto L183
    L186:
        String r36 = ")";
        int callingPid5 = callingPid3;
        ActivityRecord resultRecord2 = sourceRecord2.resultTo;
        if (resultRecord2 != null) goto L189;
    L191:
        ActivityRecord resultRecord3 = resultRecord2;
    L192:
        String resultWho = sourceRecord2.resultWho;
        IBinder resultTo = r5;
        int requestCode2 = sourceRecord2.requestCode;
        int setToAms3 = setToAms2;
        sourceRecord2.resultTo = null;
        if (resultRecord3 == null) goto L196;
        resultRecord3.removeResultsLocked(sourceRecord2, resultWho, requestCode2);
    L196:
        if (sourceRecord2.launchedFromUid != callingUid5) goto L203;
        String launchedFromPackage = sourceRecord2.launchedFromPackage;
        if (launchedFromPackage == null) goto L202;
        String resultWho2 = resultWho;
        PackageManagerInternal pmInternal = this.mService.getPackageManagerInternalLocked();
        ActivityRecord resultRecord4 = resultRecord3;
        int requestCode3 = requestCode2;
        String r41 = "clearSvpBeforeUnfreeze error unfreezedPid ";
        int packageUid = pmInternal.getPackageUid(launchedFromPackage, 0, UserHandle.getUserId(callingUid5));
        if (UserHandle.isSameApp(packageUid, callingUid5) == false) goto L204;
        String callingPackage4 = sourceRecord2.launchedFromFeatureId;
        String resultWho3 = resultWho2;
        int requestCode4 = requestCode3;
        ActivityRecord resultRecord5 = resultRecord4;
    L206:
        if (err == 0) goto L208;
    L210:
        if (err != 0) goto L218;
        if (aInfo != null) goto L218;
        err = -92;
        if (PackageArchiver.isArchivingEnabled() == false) goto L218;
        PackageArchiver packageArchiver = this.mService.getPackageManagerInternalLocked().getPackageArchiver();
        if (packageArchiver.isIntentResolvedToArchivedApp(intent5, this.mRequest.userId) == false) goto L218;
        err = packageArchiver.requestUnarchiveOnActivityStart(intent5, launchedFromPackage, this.mRequest.userId, realCallingPid2);
    L218:
        if (err != 0) goto L240;
        if (sourceRecord2 == null) goto L240;
        if (sourceRecord2.getTask().voiceSession != null) goto L223;
        ActivityRecord sourceRecord3 = sourceRecord2;
        int userId2 = userId;
        String resolvedType2 = r21;
    L241:
        if (err != 0) goto L251;
        if (r19 == 0) goto L251;
    L247:
        e = move-exception;
        Slog.w(r2, "Failure checking voice capabilities", e);
        int err2 = -97;
    L252:
        if (resultRecord5 != null) goto L254;
        Task r10 = null;
    L255:
        Task resultRootTask = r10;
        if (err2 == 0) goto L265;
        if (resultRecord5 == null) goto L259;
        resultRecord5.sendResult(-1, resultWho3, requestCode4, 0, null, null, null);
    L259:
        SafeActivityOptions.abort(r22);
        this.mService.getSmtEx().clearSvpBeforeUnfreeze(unfreezedPid2, callingPid5);     // Catch: Exception -> L262
    L264:
        return err2;
    L262:
        e = move-exception;
        Slog.w(r2, r41 + unfreezedPid2 + r15 + e);
        goto L264
    L265:
        int userId3 = userId2;
        String r11 = r41;
        ActivityTaskSupervisor r12 = this.mSupervisor;     // Catch: SecurityException -> L476
        boolean r13 = request.ignoreTargetSecurity;     // Catch: SecurityException -> L476
        if (inTask == null) goto L269;
        boolean r21 = true;
    L270:
        int finalPrefetchState3 = finalPrefetchState2;
        String resolvedType3 = resolvedType2;
        String callingFeatureId2 = callingPackage4;
        int callingPid6 = callingPid5;
        ActivityRecord resultRecord6 = resultRecord5;
        Intent intent6 = intent5;
        int queryPrefetchState2 = callingUid5;
        String r16 = r15;
        WindowProcessController callerApp4 = callerApp3;
        int requestCode5 = requestCode4;
        String callingPackage5 = launchedFromPackage;
        String callingPackage6 = resultWho3;
        boolean r18 = r12.checkStartAnyActivityPermission(intent6, aInfo, callingPackage6, requestCode5, callingPid6, queryPrefetchState2, callingPackage5, callingFeatureId2, r13, r21, callerApp4, resultRecord6, resultRootTask);     // Catch: SecurityException -> L474
        String callingPackage7 = callingPackage5;
        String intentCreatorPackage = r14;
        String callingFeatureId3 = callingFeatureId2;
        WindowProcessController callerApp5 = callerApp4;
        Task inTask2 = inTask;
        int unfreezedPid3 = unfreezedPid2;
        ActivityRecord sourceRecord4 = sourceRecord3;
        String r71 = r34;
        String r70 = r35;
        String r19 = r36;
        String r110 = "ActivityTaskManager";
        int callingUid6 = 0;
        int finalPrefetchState4 = finalPrefetchState3;
        int callingUid7 = queryPrefetchState2;
        Intent intent7 = intent6;
        boolean abort = ((!r18) | (!this.mService.mIntentFirewall.checkStartActivity(intent6, queryPrefetchState2, callingPid6, resolvedType3, aInfo.applicationInfo))) | (!this.mService.getPermissionPolicyInternal().checkStartActivity(intent7, callingUid7, callingPackage7));
        int intentCreatorUid3 = intentCreatorUid2;
        if (intentCreatorUid3 != (-1)) goto L538;
        String r74 = r16;
        String resolvedType4 = resolvedType3;
        ActivityInfo aInfo2 = aInfo;
        int finalPrefetchState5 = finalPrefetchState4;
        WindowProcessController callerApp6 = callerApp5;
    L307:
        intent7.removeCreatorToken();
        if (r22 == 0) goto L310;
        SafeActivityOptions options2 = r22;
        ActivityOptions checkedOptions = options2.getOptions(intent7, aInfo2, callerApp6, this.mSupervisor);
    L311:
        if (abort == false) goto L532;
        ActivityInfo r20 = aInfo2;
        String callingPackage8 = callingPackage7;
        ActivityInfo aInfo3 = r20;
        int realCallingPid3 = callingUid7;
        WindowProcessController callerApp7 = callerApp6;
        Intent intent8 = intent7;
        BackgroundActivityStartController.BalVerdict balVerdict = BackgroundActivityStartController.BalVerdict.ALLOW_BY_DEFAULT;
    L333:
        if (request.allowPendingRemoteAnimationRegistryLookup == false) goto L336;
        checkedOptions = this.mService.getActivityStartController().getPendingRemoteAnimationRegistry().overrideOptionsIfNeeded(callingPackage8, checkedOptions);
    L336:
        if (this.mService.mController != null) goto L544;
    L341:
        boolean abort2 = abort;
    L342:
        ActivityRecord sourceRecord5 = sourceRecord4;
        TaskDisplayArea suggestedLaunchDisplayArea = computeSuggestedLaunchDisplayArea(inTask2, sourceRecord5, checkedOptions);
        String callingPackage9 = callingPackage8;
        this.mInterceptor.setStates(userId3, realCallingPid, realCallingPid2, startFlags, callingPackage9, callingFeatureId3);
        int userId4 = realCallingPid2;
        ActivityOptions checkedOptions2 = checkedOptions;
        ActivityInfo aInfo4 = aInfo3;
        int callingUid8 = realCallingPid3;
        String resolvedType5 = resolvedType4;
        int callingPid7 = userId3;
        Task inTask3 = inTask2;
        boolean r22 = this.mInterceptor.intercept(intent8, rInfo, aInfo4, resolvedType5, inTask3, inTaskFragment, callingPid6, callingUid8, checkedOptions2, suggestedLaunchDisplayArea, request.componentSpecified);
        int callingUid9 = callingUid8;
        ResolveInfo rInfo2 = rInfo;
        int callingPid8 = callingPid6;
        if (r22 == false) goto L349;
        Intent intent9 = this.mInterceptor.mIntent;
        ResolveInfo rInfo3 = this.mInterceptor.mRInfo;
        Intent intent10 = intent9;
        ActivityInfo aInfo5 = this.mInterceptor.mAInfo;
        String resolvedType6 = this.mInterceptor.mResolvedType;
        Task inTask4 = this.mInterceptor.mInTask;
        int r23 = this.mInterceptor.mCallingPid;
        callingUid9 = this.mInterceptor.mCallingUid;
        ActivityOptions checkedOptions3 = this.mInterceptor.mActivityOptions;
        if (inTask4 == null) goto L348;
        inTask4.prefetchState |= finalPrefetchState5;
    L348:
        rInfo2 = rInfo3;
        ActivityInfo aInfo6 = aInfo5;
        intentGrants2 = null;
        ActivityOptions checkedOptions4 = checkedOptions3;
        callingPid8 = r23;
    L350:
        if (abort2 == false) goto L366;
        if (resultRecord5 == null) goto L354;
        resultRecord5.sendResult(-1, resultWho3, requestCode4, 0, null, null, null);
    L354:
        ActivityOptions.abort(checkedOptions4);
        int unfreezedPid4 = unfreezedPid3;
        this.mService.getSmtEx().clearSvpBeforeUnfreeze(unfreezedPid4, callingPid8);     // Catch: Exception -> L359
        return 102;
    L359:
        e = e;
    L363:
        Slog.w(r110, r11 + unfreezedPid4 + r74 + e);
        return 102;
    L361:
        e = e;
        unfreezedPid4 = unfreezedPid3;
        goto L363
    L366:
        BackgroundActivityStartController.BalVerdict balVerdict2 = balVerdict;
        int callingUid10 = callingUid9;
        int callingPid9 = callingPid8;
        String resolvedType7 = resolvedType6;
        ActivityRecord resultRecord7 = resultRecord5;
        String resultWho4 = resultWho3;
        int callingUid11 = requestCode4;
        if (aInfo6 != null) goto L369;
        int startFlags2 = 0;
    L387:
        String callingPackage10 = callingPackage9;
        int flags = callingUid10;
        String resolvedType8 = resolvedType7;
        int callingPid10 = callingPid9;
        ActivityInfo aInfo7 = aInfo6;
    L388:
        int realCallingUid = userId4;
        int realCallingPid4 = realCallingPid;
        WindowProcessController callerApp8 = callerApp7;
        Intent intent11 = intent10;
        Pair<Intent, Pair<ResolveInfo, ActivityInfo>> confirmInfo = getExt().startConfirmActivityIfNeeded(this.mService, aInfo7, intent11, sourceRecord5, resultRecord7, callerApp8, flags, realCallingUid, request.filterCallingUid, callingPackage10, callingFeatureId3, realCallingPid4, callingPid7, resolvedType8, r3, checkedOptions4);
        if (confirmInfo == null) goto L391;
        Intent intent12 = (Intent) confirmInfo.first;
        intentGrants2 = null;
        resolvedType8 = null;
        flags = realCallingUid;
        callingPid10 = realCallingPid4;
        ResolveInfo rInfo4 = (ResolveInfo) ((Pair) confirmInfo.second).first;
        aInfo7 = (ActivityInfo) ((Pair) confirmInfo.second).second;
        ResolveInfo rInfo5 = rInfo4;
    L392:
        if (rInfo5 != null) goto L394;
    L396:
        int startFlags3 = r3;
        int realCallingPid5 = realCallingPid4;
        String callingFeatureId4 = callingFeatureId3;
        ResolveInfo rInfo6 = rInfo5;
        String callingPackage11 = callingPackage10;
        String resolvedType9 = resolvedType8;
        Intent intent13 = intent12;
        int callingPid11 = callingPid10;
        ActivityInfo aInfo8 = aInfo7;
        int callingUid12 = flags;
    L397:
        if (callerApp8 != null) goto L402;
        if (realCallingPid5 <= 0) goto L402;
        int startFlags4 = startFlags3;
        int startFlags5 = realCallingPid5;
        WindowProcessController wpc = this.mService.mProcessMap.getProcess(startFlags5);
        if (wpc == null) goto L403;
        WindowProcessController callerApp9 = wpc;
    L404:
        ActivityRecord.Builder r24 = new ActivityRecord.Builder(this.mService).setCaller(callerApp9).setLaunchedFromPid(callingPid11).setLaunchedFromUid(callingUid12).setLaunchedFromPackage(callingPackage11).setLaunchedFromFeature(callingFeatureId4).setIntent(intent13).setResolvedType(resolvedType9).setActivityInfo(aInfo8).setConfiguration(this.mService.getGlobalConfiguration()).setResultTo(resultRecord7).setResultWho(resultWho4).setRequestCode(callingUid11).setComponentSpecified(request.componentSpecified);
        if (r19 == 0) goto L407;
        boolean r25 = true;
    L408:
        ActivityRecord.Builder r26 = r24.setRootVoiceInteraction(r25);
        ActivityOptions checkedOptions5 = checkedOptions4;
        ActivityRecord.Builder r27 = r26.setActivityOptions(checkedOptions5);
        ActivityRecord sourceRecord6 = sourceRecord5;
        ActivityRecord r = r27.setSourceRecord(sourceRecord6).build();
        this.mLastStartActivityRecord = r;
        int callingPid12 = callingPid11;
        boolean prefetchAffected = SysMonitorFwBridge.getFactory().getPrefetchState().prefetchActivityNotShown(finalPrefetchState5);
        int startType = SysOptBridge.getFactory().getAppRecordManagerService().getActivityStartType(r, prefetchAffected);
        SysOptBridge.getFactory().getIntelliScene().onActivityStartEventSync(r, startType, prefetchAffected);
        if (checkedOptions5 != null) goto L411;
    L413:
        int displayId = startFlags2;
    L414:
        ZTEActivityEventsInternal zteActivityEventsInternal = (ZTEActivityEventsInternal) LocalServices.getService(ZTEActivityEventsInternal.class);
        if (zteActivityEventsInternal == null) goto L418;
        zteActivityEventsInternal.notifyActivityEvent(1024, displayId, r.mUserId, r, -1);
    L418:
        if (r.appTimeTracker != null) goto L421;
        if (sourceRecord6 == null) goto L421;
        r.appTimeTracker = sourceRecord6.appTimeTracker;
    L421:
        WindowProcessController homeProcess = this.mService.mHomeProcess;
        if (homeProcess == null) goto L426;
        ActivityRecord sourceRecord7 = sourceRecord6;
        if (aInfo8.applicationInfo.uid != homeProcess.mUid) goto L427;
        char r28 = 1;
    L428:
        char r111 = r28;
        if (balVerdict2.allows() == false) goto L433;
        if (r111 != 0) goto L433;
        this.mService.resumeAppSwitches();
    L433:
        if (r.mTransitionController.isShellTransitionsEnabled() == true) goto L435;
        int r29 = 1;
    L439:
        Transition r30 = null;
    L440:
        Transition newTransition = r30;
        if (newTransition != null) goto L444;
        r29 = startFlags2;
    L444:
        if (r29 == 0) goto L446;
        Transition r31 = newTransition;
    L447:
        Transition transition = r31;
        if (transition == null) goto L451;
        transition.getExt().setStartActivity(r);
    L451:
        if (this.mZswExt != null) goto L453;
    L455:
        boolean isIndependent = r29;
        ActivityStarter r32 = this;
        ActivityRecord sourceRecord8 = sourceRecord7;
        int r33 = r32.startActivityUnchecked(r, sourceRecord8, r19, request.voiceInteractor, startFlags4, checkedOptions5, inTask4, inTaskFragment, balVerdict2, intentGrants2, realCallingUid, transition, isIndependent, r14);
        int unfreezedPid5 = r14;
        r32.mLastStartActivityResult = r33;
    L457:
        if (request.outActivity == null) goto L528;
        request.outActivity[startFlags2] = r32.mLastStartActivityRecord;
    L528:
    L467:
        e = e;
    L471:
        Slog.w(r110, r11 + unfreezedPid5 + r74 + e);
    L473:
        return r32.mLastStartActivityResult;
    L460:
        if (ActivityManager.isStartResultSuccessful(r32.mLastStartActivityResult) == true) goto L473;
        r32.mService.getSmtEx().clearSvpBeforeUnfreeze(unfreezedPid5, callingPid12);     // Catch: Exception -> L465
    L465:
        e = e;
        goto L471
    L453:
        if (this.mZswExt.isSurpportHSAppLockByFrameWork() == false) goto L455;
        boolean isIndependent2 = r29;
        this.mLastStartActivityResult = startActivityUncheckedZTE(r, sourceRecord7, r19, request.voiceInteractor, startFlags4, checkedOptions5, inTask4, inTaskFragment, balVerdict2, intentGrants2, realCallingUid, transition, isIndependent2, callerApp9, r14);
        r32 = this;
        unfreezedPid5 = unfreezedPid3;
        goto L457
    L446:
        r31 = this.mService.getTransitionController().getCollectingTransition();
        goto L447
    L435:
        if (balVerdict2.allows() == false) goto L437;
        r29 = 1;
        r30 = r.mTransitionController.createAndStartCollecting(1);
        goto L440
    L437:
        r29 = 1;
    L427:
        r28 = startFlags2;
        goto L428
    L426:
        sourceRecord7 = sourceRecord6;
        goto L427
    L411:
        if (checkedOptions5.getLaunchDisplayId() == (-1)) goto L413;
        displayId = checkedOptions5.getLaunchDisplayId();
        goto L414
    L407:
        r25 = startFlags2;
    L403:
        callerApp9 = callerApp8;
    L402:
        startFlags4 = startFlags3;
        startFlags5 = realCallingPid5;
        goto L403
    L394:
        if (rInfo5.auxiliaryInfo == null) goto L396;
        ResolveInfo rInfo7 = rInfo5;
        startFlags3 = r3;
        realCallingPid5 = realCallingPid4;
        String callingFeatureId5 = callingFeatureId3;
        rInfo6 = rInfo7;
        String callingPackage12 = callingPackage10;
        int userId5 = callingPid7;
        Intent intent14 = createLaunchIntent(rInfo7.auxiliaryInfo, request.ephemeralIntent, callingPackage12, callingFeatureId5, verificationBundle, resolvedType8, userId5);
        callingPackage11 = callingPackage12;
        callingFeatureId4 = callingFeatureId5;
        intentGrants2 = null;
        resolvedType9 = null;
        intent13 = intent14;
        callingPid11 = realCallingPid5;
        aInfo8 = this.mSupervisor.resolveActivity(intent14, rInfo6, startFlags3, null);
        callingUid12 = realCallingUid;
        goto L397
    L391:
        intent12 = intent11;
        rInfo5 = rInfo2;
        goto L392
    L369:
        if (this.mService.getPackageManagerInternalLocked().isPermissionsReviewRequired(aInfo6.packageName, callingPid7) == false) goto L385;
        callingFeatureId3 = callingFeatureId3;
        IIntentSender target = this.mService.getIntentSenderLocked(2, callingPackage9, callingFeatureId3, callingUid10, callingPid7, null, null, 0, new Intent[]{intent10}, new String[]{resolvedType7}, 1342177280, null);
        finalPrefetchState5 = finalPrefetchState5;
        Intent newIntent = new Intent("android.intent.action.REVIEW_PERMISSIONS");
        int flags2 = intent10.getFlags();
        int flags3 = flags2 | 8388608;
        if ((flags3 & 268959744) == 0) goto L373;
        flags3 = flags3 | 134217728;
    L373:
        newIntent.setFlags(flags3);
        sourceRecord5 = sourceRecord5;
        newIntent.putExtra("android.intent.extra.PACKAGE_NAME", aInfo6.packageName);
        newIntent.putExtra("android.intent.extra.INTENT", new IntentSender(target));
        if (resultRecord7 == null) goto L376;
        newIntent.putExtra("android.intent.extra.RESULT_NEEDED", true);
    L376:
        intentGrants2 = null;
        realCallingPid = realCallingPid;
        ResolveInfo rInfo8 = this.mSupervisor.resolveIntent(newIntent, null, callingPid7, 0, computeResolveFilterUid(userId4, userId4, request.filterCallingUid), realCallingPid);
        callingPid10 = realCallingPid;
        callingPid7 = callingPid7;
        userId4 = userId4;
        ActivityInfo aInfo9 = this.mSupervisor.resolveActivity(newIntent, rInfo8, startFlags, null);
        if (ActivityTaskManagerDebugConfig.DEBUG_PERMISSIONS_REVIEW == false) goto L383;
        Task focusedRootTask = this.mRootWindowContainer.getTopDisplayFocusedRootTask();
        StringBuilder r37 = new StringBuilder();
        r37.append(r71);
        r37.append(callingPid7);
        r37.append(r70);
        startFlags2 = 0;
        r37.append(newIntent.toShortString(true, true, true, false));
        r37.append("} from uid ");
        r37.append(userId4);
        r37.append(" on display ");
        if (focusedRootTask != null) goto L381;
        int r38 = 0;
    L382:
        r37.append(r38);
        Slog.i(r110, r37.toString());
    L384:
        flags = userId4;
        rInfo2 = rInfo8;
        callingPackage10 = callingPackage9;
        intent10 = newIntent;
        resolvedType8 = null;
        aInfo7 = aInfo9;
        goto L388
    L381:
        r38 = focusedRootTask.getDisplayId();
        goto L382
    L383:
        startFlags2 = 0;
        goto L384
    L385:
        startFlags2 = 0;
        goto L387
    L349:
        intent10 = intent8;
        aInfo6 = aInfo4;
        resolvedType6 = resolvedType5;
        inTask4 = inTask3;
        checkedOptions4 = checkedOptions2;
        goto L350
    L544:
        Intent watchIntent = intent8.cloneFilter();     // Catch: Exception -> L339
        abort2 = abort | (!this.mService.mController.activityStarting(watchIntent, aInfo3.applicationInfo.packageName));
    L339:
        e = move-exception;
        e.printStackTrace();
        this.mService.mController = null;
        goto L341
    L532:
        Trace.traceBegin(32, "shouldAbortBackgroundActivityStart");     // Catch: Throwable -> L327
        BackgroundActivityStartController balController = this.mSupervisor.getBackgroundActivityLaunchController();     // Catch: Throwable -> L327
        ActivityInfo r112 = aInfo2;
        callingPackage8 = callingPackage7;
        aInfo3 = r112;
        Intent intent15 = intent7;
        WindowProcessController callerApp10 = callerApp6;
        int callingUid13 = callingUid7;
        BackgroundActivityStartController.BalVerdict balVerdict3 = balController.checkBackgroundActivityStart(callingUid13, callingPid6, callingPackage8, realCallingPid2, realCallingPid, callerApp10, request.originatingPendingIntent, request.allowBalExemptionForSystemProcess, resultRecord5, intent15, checkedOptions);     // Catch: Throwable -> L325
        callerApp7 = callerApp10;
        realCallingPid3 = callingUid13;
        intent8 = intent15;
        StringBuilder r113 = request.logMessage;     // Catch: Throwable -> L323
        long r114 = 32;
        r113.append(" (");     // Catch: Throwable -> L321
        r113.append(balVerdict3);     // Catch: Throwable -> L321
        r113.append(r19);     // Catch: Throwable -> L321
        Trace.traceEnd(32);
        balVerdict = balVerdict3;
    L321:
        th = th;
    L329:
        Trace.traceEnd(r114);
        throw th;
    L323:
        th = th;
        r114 = 32;
    L325:
        th = th;
        r114 = 32;
    L327:
        th = th;
        r114 = 32;
        goto L329
    L310:
        options2 = r22;
        checkedOptions = null;
        goto L311
    L538:
        ActivityTaskSupervisor r115 = this.mSupervisor;     // Catch: SecurityException -> L295
        boolean r40 = request.ignoreTargetSecurity;     // Catch: SecurityException -> L295
        if (inTask2 == null) goto L278;
        boolean r210 = true;
    L279:
        r74 = r16;
        String resultWho5 = resultWho3;
        int requestCode6 = requestCode4;
        ActivityRecord resultRecord8 = resultRecord5;
        boolean r42 = r115.checkStartAnyActivityPermission(intent7, aInfo, resultWho5, requestCode6, 0, intentCreatorUid3, intentCreatorPackage, "", r40, r210, null, resultRecord8, resultRootTask);     // Catch: SecurityException -> L293
        intentCreatorPackage = intentCreatorPackage;
        if (r42 == false) goto L526;
        inTask2 = inTask2;
        String r116 = r110;
        callingUid6 = 0;
        intentCreatorUid3 = intentCreatorUid3;
        callerApp5 = callerApp5;
        intent7 = intent7;
        finalPrefetchState4 = finalPrefetchState4;
    L292:
        String callingPackage13 = callingPackage7;
        String r43 = r116;
        int finalPrefetchState6 = finalPrefetchState4;
        aInfo2 = aInfo;
        int r44 = callingUid6;
        Intent intent16 = intent7;
        int callingUid14 = callingUid7;
        WindowProcessController callerApp11 = callerApp5;
    L298:
        int intentCreatorUid4 = intentCreatorUid3;
        r110 = r43;
        finalPrefetchState5 = finalPrefetchState6;
        Intent intent17 = intent16;
        callerApp6 = callerApp11;
        resolvedType4 = resolvedType3;
        intent7 = intent17;
        if (this.mService.mIntentFirewall.checkStartActivity(intent17, intentCreatorUid4, 0, resolvedType3, aInfo2.applicationInfo) == true) goto L301;
        callingPackage7 = callingPackage13;
        callingUid7 = callingUid14;
        abort = logAndAbortForIntentRedirect(this.mService.mContext, 5, intent7, intentCreatorUid4, intentCreatorPackage, callingUid7, callingPackage7);
    L303:
        if (this.mService.getPermissionPolicyInternal().checkStartActivity(intent7, intentCreatorUid4, intentCreatorPackage) == true) goto L307;
        abort = logAndAbortForIntentRedirect(this.mService.mContext, 6, intent7, intentCreatorUid4, intentCreatorPackage, callingUid7, callingPackage7);
        goto L307
    L301:
        callingPackage7 = callingPackage13;
        callingUid7 = callingUid14;
        goto L303
    L526:
        r116 = r110;
        inTask2 = inTask2;
        callingUid6 = 0;
        intentCreatorUid3 = intentCreatorUid3;
        callerApp5 = callerApp5;
        intent7 = intent7;
        finalPrefetchState4 = finalPrefetchState4;
        abort = logAndAbortForIntentRedirect(this.mService.mContext, 4, intent7, intentCreatorUid3, intentCreatorPackage, callingUid7, callingPackage7);     // Catch: SecurityException -> L287
    L287:
        e = move-exception;
        intentCreatorPackage = intentCreatorPackage;
        SecurityException e = e;
    L297:
        finalPrefetchState6 = finalPrefetchState4;
        Intent intent18 = intent7;
        callerApp11 = callerApp5;
        aInfo2 = aInfo;
        r43 = r116;
        r44 = callingUid6;
        callingUid14 = callingUid7;
        logAndThrowExceptionForIntentRedirect(this.mService.mContext, 3, intent18, intentCreatorUid3, intentCreatorPackage, callingUid14, callingPackage7, e);
        intent16 = intent18;
        callingPackage13 = callingPackage7;
    L289:
        e = move-exception;
        inTask2 = inTask2;
        r116 = r110;
        callingUid6 = 0;
        intentCreatorUid3 = intentCreatorUid3;
        callerApp5 = callerApp5;
        intent7 = intent7;
        finalPrefetchState4 = finalPrefetchState4;
        e = e;
    L293:
        e = move-exception;
        r116 = r110;
        callingUid6 = 0;
        resultWho3 = resultWho5;
        requestCode4 = requestCode6;
        intentCreatorUid3 = intentCreatorUid3;
        intentCreatorPackage = intentCreatorPackage;
        resultRecord5 = resultRecord8;
        inTask2 = inTask2;
        callerApp5 = callerApp5;
        intent7 = intent7;
        finalPrefetchState4 = finalPrefetchState4;
        e = e;
        goto L297
    L278:
        r210 = false;
    L295:
        e = move-exception;
        r116 = r110;
        r74 = r16;
        e = e;
    L474:
        e = e;
        resultWho3 = callingPackage6;
        requestCode4 = requestCode5;
        int callingUid15 = queryPrefetchState2;
        resultRecord5 = resultRecord6;
        String r45 = r16;
        int callingPid13 = callingPid6;
        String r46 = r11;
        String r47 = "ActivityTaskManager";
    L478:
        SecurityException e2 = e;
        Intent originalIntent = request.ephemeralIntent;
        if (originalIntent == null) goto L518;
        if (originalIntent.getComponent() != null) goto L487;
        if (originalIntent.getPackage() == null) goto L518;
    L487:
        if (originalIntent.getComponent() == null) goto L489;
        String r48 = originalIntent.getComponent().getPackageName();
    L490:
        String targetPackageName = r48;
        if (this.mService.getPackageManagerInternalLocked().filterAppAccess(targetPackageName, callingUid15, userId3) == false) goto L518;
        if (resultRecord5 == null) goto L494;
        resultRecord5.sendResult(-1, resultWho3, requestCode4, 0, null, null, null);
    L494:
        SafeActivityOptions.abort(options);
        this.mService.getSmtEx().clearSvpBeforeUnfreeze(unfreezedPid2, callingPid13);     // Catch: Exception -> L497
        return -92;
    L497:
        ex = move-exception;
        Slog.w(r47, r46 + unfreezedPid2 + r45 + ex);
        return -92;
    L489:
        r48 = originalIntent.getPackage();
    L518:
        this.mService.getSmtEx().clearSvpBeforeUnfreeze(unfreezedPid2, callingPid13);     // Catch: Exception -> L505
        throw e2;
    L505:
        ex = move-exception;
        Slog.w(r47, r46 + unfreezedPid2 + r45 + ex);
        throw e2;
    L269:
        r21 = false;
    L476:
        e = e;
        callingUid15 = callingUid5;
        r47 = "ActivityTaskManager";
        r45 = r15;
        r46 = r11;
        callingPid13 = callingPid5;
        goto L478
    L254:
        r10 = resultRecord5.getRootTask();
        goto L255
    L244:
        if (this.mService.getPackageManager().activitySupportsIntentAsUser(intent5.getComponent(), intent5, resolvedType2, userId2) == true) goto L249;
        Slog.w(r2, "Activity being started in new voice task does not support: " + intent5);     // Catch: RemoteException -> L247
        err = -97;
    L249:
        err2 = err;
    L251:
        err2 = err;
        goto L252
    L223:
        if ((launchFlags & 268435456) == 0) goto L225;
    L238:
        sourceRecord3 = sourceRecord2;
        userId2 = userId;
        resolvedType2 = r21;
        goto L241
    L225:
        if (sourceRecord2.info.applicationInfo.uid == aInfo.applicationInfo.uid) goto L238;
        intent5.addCategory("android.intent.category.VOICE");     // Catch: RemoteException -> L235
        sourceRecord3 = sourceRecord2;
        userId2 = userId;
        resolvedType2 = resolvedType;
    L232:
        e = e;
    L237:
        Slog.w(r2, "Failure checking voice capabilities", e);
        err = -97;
        goto L241
    L229:
        if (this.mService.getPackageManager().activitySupportsIntentAsUser(intent5.getComponent(), intent5, resolvedType2, userId2) == true) goto L241;
        Slog.w(r2, "Activity being started in current voice task does not support voice: " + intent5);     // Catch: RemoteException -> L232
        err = -97;
    L235:
        e = e;
        sourceRecord3 = sourceRecord2;
        userId2 = userId;
        resolvedType2 = r21;
    L240:
        sourceRecord3 = sourceRecord2;
        userId2 = userId;
        resolvedType2 = r21;
        goto L241
    L208:
        if (intent5.getComponent() != null) goto L210;
        err = -91;
    L204:
        resultWho3 = resultWho2;
        requestCode4 = requestCode3;
        launchedFromPackage = callingPackage3;
        resultRecord5 = resultRecord4;
        callingPackage4 = callingFeatureId;
        goto L206
    L202:
        resultWho2 = resultWho;
        resultRecord4 = resultRecord3;
        requestCode3 = requestCode2;
        r41 = "clearSvpBeforeUnfreeze error unfreezedPid ";
        goto L204
    L203:
        resultWho2 = resultWho;
        resultRecord4 = resultRecord3;
        requestCode3 = requestCode2;
        r41 = "clearSvpBeforeUnfreeze error unfreezedPid ";
        goto L204
    L189:
        if (resultRecord2.isInRootTaskLocked() == true) goto L191;
        resultRecord3 = null;
    L205:
        r36 = ")";
        resultTo = r5;
        r41 = "clearSvpBeforeUnfreeze error unfreezedPid ";
        setToAms3 = setToAms2;
        callingPid5 = callingPid3;
        resultRecord5 = resultRecord;
        resultWho3 = r7;
        requestCode4 = r12;
        launchedFromPackage = callingPackage3;
        callingPackage4 = callingFeatureId;
        goto L206
    L164:
        if (sourceRecord.finishing == true) goto L166;
        resultRecord = sourceRecord;
        request.logMessage.append(" (rr=");
        goto L167
    L168:
        resultRecord = resultRecord;
        sourceRecord2 = sourceRecord;
        goto L170
    L169:
        finalPrefetchState2 = finalPrefetchState2;
        sourceRecord2 = null;
        goto L170
    L154:
        setToAms2 = setToAms;
    L144:
        e = move-exception;
        Slog.w(r2, "setSvpBeforeUnfreeze error activityPkg " + activityPkg + " uid " + uid + r15 + e);
        unfreezedPid = 0;
        goto L146
    L141:
        focusedPkg2 = focusedPkg;
        goto L552
    L134:
        r8 = null;
        goto L135
    L130:
        r6 = null;
    L150:
        unfreezedPid2 = 0;
        goto L152
    L118:
        if (this.mExt.refuseStartLauncherInFreeform(intent5, callingUid5, r5) == false) goto L120;
        return -96;
    L149:
        r34 = "START u";
        r35 = " {";
        goto L150
    L102:
        if (aInfo.applicationInfo == null) goto L106;
        Intent intent19 = intent4;
        r15 = " exception=";
        callingPackage2 = callingPackage;
        int callingUid16 = callingUid4;
        boolean r49 = SysOptBridge.getFactory().getProcessIntercept().isActivityAllowStart(callingPackage2, request.realCallingPid, callingUid16, aInfo, intent19);
        intent5 = intent19;
        callingUid5 = callingUid16;
        if (r49 == true) goto L108;
        return -96;
    L95:
        if (rInfo.activityInfo == null) goto L100;
        if ((rInfo.activityInfo.getSysEx().smXMLFlags & 1) == 0) goto L100;
        Slog.w("FEAT_PROCESS_INTERCEPT", "It is an empty Activity and block to start it : " + rInfo.activityInfo.getComponentName());
        return 0;
    L107:
        callingPackage2 = callingPackage;
        callingUid5 = callingUid4;
        r15 = " exception=";
        intent5 = intent4;
    L83:
        e = e;
    L89:
        Slog.w("ActivityTaskManager", "activity task can't delay move to primary display. intent=" + intent4 + " exception=" + e);
    L85:
        e = e;
        callingUid4 = callingUid2;
    L87:
        e = e;
        finalPrefetchState2 = finalPrefetchState;
        callingUid4 = callingUid2;
    L90:
        finalPrefetchState2 = finalPrefetchState;
        callingUid4 = callingUid2;
        goto L92
    L48:
        if (aInfo.applicationInfo == null) goto L71;
        if (callingUid2 != 1000) goto L56;
        if (isFromPrefetch == 0) goto L56;
        if (this.mService.mWindowManager.getSmtEx().checkTaskForPrefetchLocked(aInfo.applicationInfo.packageName) == false) goto L56;
        return 0;
    L56:
        int queryPrefetchState3 = SysOptBridge.getFactory().getSysPrefetchService().getPrefetchStateByInfo(aInfo.applicationInfo.packageName, aInfo.applicationInfo.uid);
        Task prefetchTask = this.mService.mWindowManager.getSmtEx().getPrefetchTaskLocked(aInfo.applicationInfo.packageName);
        if (callingUid2 != 1000) goto L61;
        if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(isFromPrefetch) == true) goto L61;
    L67:
        callingPackage = callingPackage;
        SysOptBridge.getFactory().getSysPrefetchService().moveTaskToDisplay(aInfo.applicationInfo.packageName, true);
        SysOptBridge.getFactory().getSysPrefetchService().setPrefetchState(aInfo.applicationInfo.uid, aInfo.applicationInfo.packageName, 65536);
        this.mPrefetchFirstStart = true;
        setToAms = 65536;
        queryPrefetchState = queryPrefetchState3;
    L61:
        if (aInfo.applicationInfo.uid != callingUid2) goto L63;
    L64:
        if (prefetchTask == null) goto L70;
        if (prefetchTask.getBasePackageName().equals(callingPackage) == false) goto L67;
    L70:
        queryPrefetchState = queryPrefetchState3;
        setToAms = isFromPrefetch;
        goto L72
    L63:
        if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(queryPrefetchState3) == true) goto L67;
    L31:
        r1 = 0;
        goto L32
    L25:
        if (aInfo.applicationInfo == null) goto L27;
        r39 = UserHandle.getUserId(aInfo.applicationInfo.uid);
        goto L28
    L21:
        intentCreatorUid2 = intentCreatorUid;
        intent4 = intent2;
        callerApp3 = callerApp2;
        goto L23
    L13:
        Slog.w("ActivityTaskManager", "Unable to find app for caller " + caller + " (pid=" + callingPid + ") when starting: " + intent2.toString());
        callingPid3 = callingPid;
        callingUid2 = callingUid;
        err = -94;
        callerApp2 = callerApp;
        goto L15
    L14:
        intent2 = intent;
        callingPid3 = callingPid;
        callingUid2 = callingUid;
        err = 0;
        callerApp2 = null;
        goto L15
    L7:
        r17 = null;
        goto L8
    L509:
        throw new IllegalArgumentException("Need to specify a reason.");
    }

    private boolean handleBackgroundActivityAbort(ActivityRecord r) {
        boolean abort = !this.mService.isBackgroundActivityStartsEnabled();
        if (abort == true) goto L6;
        return false;
    L6:
        ActivityRecord resultRecord = r.resultTo;
        String resultWho = r.resultWho;
        int requestCode = r.requestCode;
        if (resultRecord == null) goto L9;
        resultRecord.sendResult(-1, resultWho, requestCode, 0, null, null, null);
    L9:
        ActivityOptions.abort(r.getOptions());
        return true;
    }

    static int getExternalResult(int result) {
        if (result != 102) goto L7;
        return 0;
    L7:
        return result;
    }

    private void onExecutionComplete() {
        this.mController.onExecutionComplete(this);
    }

    private void onExecutionStarted() {
        this.mController.onExecutionStarted();
    }

    private Intent createLaunchIntent(AuxiliaryResolveInfo auxiliaryResponse, Intent originalIntent, String callingPackage, String callingFeatureId, Bundle verificationBundle, String resolvedType, int userId) {
        if (auxiliaryResponse == null) goto L8;
        if (auxiliaryResponse.needsPhaseTwo == false) goto L8;
        PackageManagerInternal packageManager = this.mService.getPackageManagerInternalLocked();
        boolean isRequesterInstantApp = packageManager.isInstantApp(callingPackage, userId);
        packageManager.requestInstantAppResolutionPhaseTwo(auxiliaryResponse, originalIntent, resolvedType, callingPackage, callingFeatureId, isRequesterInstantApp, verificationBundle, userId);
    L8:
        Intent r11 = InstantAppResolver.sanitizeIntent(originalIntent);
        List r0 = null;
        if (auxiliaryResponse != null) goto L11;
        Intent r12 = null;
    L12:
        if (auxiliaryResponse != null) goto L14;
        ComponentName r18 = null;
    L15:
        if (auxiliaryResponse != null) goto L17;
        String r19 = null;
    L18:
        if (auxiliaryResponse != null) goto L20;
    L23:
        boolean r2 = false;
    L22:
        boolean r20 = r2;
        if (auxiliaryResponse == null) goto L28;
        r0 = auxiliaryResponse.filters;
    L28:
        return InstantAppResolver.buildEphemeralInstallerIntent(originalIntent, r11, r12, callingPackage, callingFeatureId, verificationBundle, resolvedType, userId, r18, r19, r20, r0);
    L20:
        if (auxiliaryResponse.needsPhaseTwo == false) goto L23;
        r2 = true;
        goto L22
    L17:
        r19 = auxiliaryResponse.token;
        goto L18
    L14:
        r18 = auxiliaryResponse.installFailureActivity;
        goto L15
    L11:
        r12 = auxiliaryResponse.failureIntent;
        goto L12
    }

    void postStartActivityProcessing(ActivityRecord r, int result, Task startedActivityRootTask) {
        if (ActivityManager.isStartResultSuccessful(result) == true) goto L8;
        if (this.mFrozeTaskList == false) goto L8;
        this.mSupervisor.mRecentTasks.resetFreezeTaskListReorderingOnTimeout();
    L8:
        if (ActivityManager.isStartResultFatalError(result) == false) goto L10;
        return;
    L10:
        this.mSupervisor.reportWaitingActivityLaunchedIfNeeded(r, result);
        if (r.getTask() == null) goto L13;
        Task targetTask = r.getTask();
    L15:
        if (startedActivityRootTask == null) goto L40;
        if (targetTask != null) goto L18;
        return;
    L18:
        if (targetTask.isAttached() == true) goto L21;
        return;
    L21:
        if (result != 2) goto L23;
    L24:
        Task rootHomeTask = targetTask.getDisplayArea().getRootHomeTask();
        boolean visible = false;
        if (rootHomeTask != null) goto L27;
    L29:
        boolean homeTaskVisible = false;
    L30:
        ActivityRecord top = targetTask.getTopNonFinishingActivity();
        if (top != null) goto L33;
    L35:
        this.mService.getTaskChangeNotificationController().notifyActivityRestartAttempt(targetTask.getTaskInfo(), homeTaskVisible, this.mIsTaskCleared, visible);
    L37:
        if (ActivityManager.isStartResultSuccessful(result) == false) goto L41;
        this.mInterceptor.onActivityLaunched(targetTask.getTaskInfo(), r);
        return;
    L41:
        return;
    L33:
        if (top.isVisible() == false) goto L35;
        visible = true;
        goto L35
    L27:
        if (rootHomeTask.shouldBeVisible(null) == false) goto L29;
        homeTaskVisible = true;
        goto L30
    L23:
        if (result != 3) goto L37;
    L40:
        return;
    L13:
        targetTask = this.mTargetTask;
        goto L15
    }

    static int computeResolveFilterUid(int customCallingUid, int actualCallingUid, int filterCallingUid) {
        if (filterCallingUid != (-10000)) goto L9;
        if (customCallingUid < 0) goto L8;
        return customCallingUid;
    L8:
        return actualCallingUid;
    L9:
        return filterCallingUid;
    }

    private int startActivityUncheckedZTE(ActivityRecord r, ActivityRecord sourceRecord, IVoiceInteractionSession voiceSession, IVoiceInteractor voiceInteractor, int startFlags, ActivityOptions options, Task inTask, TaskFragment inTaskFragment, BackgroundActivityStartController.BalVerdict balVerdict, NeededUriGrants intentGrants, int realCallingUid, Transition transition, boolean isIndependentLaunch, WindowProcessController callerApp, int unfreezedPid) {
        if (this.mZswExt == null) goto L7;
        HsLockTempInfo info = this.mZswExt.getHsLockTempInfo(r, sourceRecord, voiceSession, voiceInteractor, startFlags, options, inTask, inTaskFragment, balVerdict, intentGrants, realCallingUid, transition, isIndependentLaunch, callerApp);
        if (info == null) goto L7;
        ActivityRecord r2 = info.r;
        ActivityRecord sourceRecord2 = info.sourceRecord;
        IVoiceInteractionSession voiceSession2 = info.voiceSession;
        IVoiceInteractor voiceInteractor2 = info.voiceInteractor;
        int startFlags2 = info.startFlags;
        ActivityOptions options2 = info.options;
        Task inTask2 = info.inTask;
        ActivityRecord r3 = r2;
        ActivityRecord r4 = sourceRecord2;
        IVoiceInteractionSession voiceSession3 = voiceSession2;
        IVoiceInteractor voiceInteractor3 = voiceInteractor2;
        int startFlags3 = startFlags2;
        ActivityOptions options3 = options2;
    L9:
        return startActivityUnchecked(r3, r4, voiceSession3, voiceInteractor3, startFlags3, options3, inTask2, inTaskFragment, balVerdict, intentGrants, realCallingUid, transition, isIndependentLaunch, unfreezedPid);
    L7:
        r3 = r;
        r4 = sourceRecord;
        voiceSession3 = voiceSession;
        voiceInteractor3 = voiceInteractor;
        startFlags3 = startFlags;
        options3 = options;
        inTask2 = inTask;
        goto L9
    }

    private int startActivityUnchecked(ActivityRecord r, ActivityRecord sourceRecord, IVoiceInteractionSession voiceSession, IVoiceInteractor voiceInteractor, int startFlags, ActivityOptions options, Task inTask, TaskFragment inTaskFragment, BackgroundActivityStartController.BalVerdict balVerdict, NeededUriGrants intentGrants, int realCallingUid, Transition transition, boolean isIndependentLaunch, int unfreezedPid) {
        ActivityStarter r1 = this;
        RemoteTransition remoteTransition = r.takeRemoteTransition();
        if (isIndependentLaunch == true) goto L5;
    L63:
        r1.mService.deferWindowLayout();     // Catch: Throwable -> L53
        r.mTransitionController.collect(r);     // Catch: Throwable -> L33 Exception -> L35
        Trace.traceBegin(32, "startActivityInner");     // Catch: Throwable -> L33 Exception -> L35
        long r17 = 32;
        int result = r1.startActivityInner(r, sourceRecord, voiceSession, voiceInteractor, startFlags, options, inTask, inTaskFragment, balVerdict, intentGrants, realCallingUid, unfreezedPid);     // Catch: Throwable -> L29 Exception -> L31
        Trace.traceEnd(32);     // Catch: Throwable -> L27
        Task startedActivityRootTask = handleStartResult(r, options, result, isIndependentLaunch, remoteTransition, transition);     // Catch: Throwable -> L24
        ActivityStarter r2 = this;
        ActivityRecord r3 = r;
    L23:
        int result2 = result;
        r2.mService.continueWindowLayout();
        r2.postStartActivityProcessing(r3, result2, startedActivityRootTask);
        return result2;
    L24:
        th = th;
        r1 = this;
    L55:
        r1.mService.continueWindowLayout();
        throw th;
    L27:
        th = th;
        r1 = this;
        goto L55
    L31:
        ex = e;
    L32:
        RemoteTransition remoteTransition2 = remoteTransition;
        Slog.e("ActivityTaskManager", "Exception on startActivityInner", ex);     // Catch: Throwable -> L49
        Trace.traceEnd(r17);     // Catch: Throwable -> L47
        r2 = this;
        r3 = r;
        result = -96;
        startedActivityRootTask = r2.handleStartResult(r3, options, -96, isIndependentLaunch, remoteTransition2, transition);     // Catch: Throwable -> L45
    L47:
        th = th;
        r1 = this;
    L49:
        th = th;
    L51:
        Trace.traceEnd(r17);     // Catch: Throwable -> L45
        handleStartResult(r, options, -96, isIndependentLaunch, remoteTransition2, transition);     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L29:
        th = th;
    L30:
        remoteTransition2 = remoteTransition;
        goto L51
    L45:
        th = th;
    L35:
        ex = e;
        r17 = 32;
    L33:
        th = th;
        r17 = 32;
    L53:
        th = th;
        goto L55
    L5:
        if (r1.mRequest.freezeScreen == false) goto L63;
        if (r1.mLaunchParams.hasPreferredTaskDisplayArea() == false) goto L9;
        TaskDisplayArea tda = r1.mLaunchParams.mPreferredTaskDisplayArea;
    L10:
        RootWindowContainer r4 = r1.mRootWindowContainer;
        result = tda.getDisplayId();
        DisplayContent dc = r4.getDisplayContentOrCreate(result);
        if (dc == null) goto L63;
        transition.collect(dc);
        transition.collectVisibleChange(dc);
        goto L63
    L9:
        tda = r1.mRootWindowContainer.getDefaultTaskDisplayArea();
        goto L10
    }

    private boolean avoidMoveToFront() {
        if (this.mCanMoveToFrontCode == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean avoidMoveToFrontPIOnlyCreatorAllows() {
        if (this.mCanMoveToFrontCode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private Task handleStartResult(ActivityRecord started, ActivityOptions options, int result, boolean isIndependentLaunch, RemoteTransition remoteTransition, Transition transition) {
        Transition transition2 = transition;
        boolean userLeaving = this.mSupervisor.mUserLeaving;
        this.mSupervisor.mUserLeaving = false;
        Task currentRootTask = started.getRootTask();
        if (currentRootTask == null) goto L5;
        Task startedActivityRootTask = currentRootTask;
    L7:
        if (ActivityManager.isStartResultSuccessful(result) == false) goto L112;
        if (startedActivityRootTask == null) goto L112;
        if (started.isAttached() == false) goto L13;
        started.computeInitialCallerInfo();
    L13:
        if (options != null) goto L15;
    L17:
        if (isIndependentLaunch == true) goto L19;
    L28:
        ActivityRecord currentTop = startedActivityRootTask.topRunningActivity();
        if (currentTop == null) goto L34;
        if (currentTop.shouldUpdateConfigForDisplayChanged() == false) goto L34;
        this.mRootWindowContainer.ensureVisibilityAndConfig(currentTop, currentTop.mDisplayContent, false);
    L34:
        if (avoidMoveToFront() == false) goto L36;
    L44:
        TransitionController transitionController = started.mTransitionController;
        if (result != 0) goto L47;
    L50:
        boolean isStarted = true;
    L51:
        if (options != null) goto L53;
    L55:
        boolean isTransientLaunch = false;
    L56:
        if (isTransientLaunch == true) goto L58;
    L62:
        boolean forceTransientTransition = false;
    L63:
        if (isStarted == false) goto L66;
        transitionController.collectExistenceChange(started);
    L80:
        if (forceTransientTransition == false) goto L83;
        if (transition2 == null) goto L83;
        transition2.collect(this.mLastStartActivityRecord);
        transition2.collect(this.mPriorAboveTask);
        transition2.setTransientLaunch(this.mLastStartActivityRecord, this.mPriorAboveTask);
        DisplayContent dc = this.mLastStartActivityRecord.getDisplayContent();
        dc.mWallpaperController.adjustWallpaperWindows();
        transition2.setReady(dc, true);
    L83:
        if (userLeaving == true) goto L87;
        if (transition2 == null) goto L87;
        transition2.setCanPipOnFinish(false);
    L87:
        if (avoidMoveToFront() == false) goto L90;
        if (transition2 == null) goto L90;
        transition2.addFlag(65536);
    L90:
        if (isIndependentLaunch == false) goto L98;
        if (transition2 == null) goto L98;
        if (this.mTargetTask != null) goto L95;
        Task r6 = started.getTask();
    L96:
        transitionController.requestStartTransition(transition2, r6, remoteTransition, null);
    L109:
        return startedActivityRootTask;
    L95:
        r6 = this.mTargetTask;
    L98:
        if (result == 0) goto L100;
    L102:
        if (isStarted == false) goto L109;
        if (this.mBalCode == 127) goto L106;
    L107:
        if (transition2 == null) goto L109;
        transition2.setReady(started, false);
        goto L109
    L106:
        if (this.mDoResume == false) goto L109;
    L100:
        if (this.mStartActivity.isState(ActivityRecord.State.RESUMED) == false) goto L102;
    L66:
        if (result != 3) goto L80;
        if (isIndependentLaunch == false) goto L80;
        if (this.mMovedToTopActivity != null) goto L80;
        if (transitionController.hasOrderChanges() == true) goto L80;
        if (transitionController.isTransientHide(startedActivityRootTask) == true) goto L80;
        if (transitionController.getExt().hasDisplayChangedContainer() == true) goto L80;
        if (transition2.hasChanged(this.mLastStartActivityRecord) == true) goto L80;
        if (forceTransientTransition == true) goto L80;
        transition2.abort();
        transition2 = null;
        goto L80
    L58:
        if (this.mPriorAboveTask == null) goto L62;
        if (this.mDisplayLockAndOccluded == false) goto L62;
        forceTransientTransition = true;
        goto L63
    L53:
        if (options.getTransientLaunch() == false) goto L55;
        isTransientLaunch = true;
        goto L56
    L47:
        if (result == 2) goto L50;
        isStarted = false;
        goto L51
    L36:
        if (this.mDoResume == false) goto L44;
        if (this.mService.getUserManagerInternal().isVisibleBackgroundFullUser(started.mUserId) == true) goto L44;
        if (this.mRootWindowContainer.hasVisibleWindowAboveButDoesNotOwnNotificationShade(started.launchedFromUid) == false) goto L44;
        StatusBarManagerInternal statusBar = this.mService.getStatusBarManagerInternal();
        if (statusBar == null) goto L44;
        statusBar.collapsePanels();
        goto L44
    L19:
        if (this.mDoResume == true) goto L28;
        if (avoidMoveToFront() == false) goto L28;
        if (this.mTransientLaunch == true) goto L28;
        if (started.shouldBeVisible(true) == true) goto L28;
        Slog.i("ActivityTaskManager", "Abort " + transition2 + " of invisible launch " + started);
        transition2.abort();
        return startedActivityRootTask;
    L15:
        if (options.getTaskAlwaysOnTop() == false) goto L17;
        startedActivityRootTask.setAlwaysOnTop(true);
    L112:
        if (this.mStartActivity.getTask() == null) goto L115;
        this.mStartActivity.finishIfPossible("startActivity", true);
    L117:
        if (startedActivityRootTask != null) goto L119;
    L128:
        if (isIndependentLaunch == true) goto L130;
        return null;
    L130:
        if (this.mService.getTransitionController().isShellTransitionsEnabled() == false) goto L135;
        transition2.abort();
        return null;
    L135:
        return null;
    L119:
        if (startedActivityRootTask.isAttached() == false) goto L128;
        if (startedActivityRootTask.hasActivity() == true) goto L128;
        if (startedActivityRootTask.isActivityTypeHome() == true) goto L128;
        if (startedActivityRootTask.mCreatedByOrganizer == true) goto L128;
        startedActivityRootTask.removeIfPossible("handleStartResult");
        goto L128
    L115:
        if (this.mStartActivity.getParent() == null) goto L117;
        this.mStartActivity.getParent().removeChild(this.mStartActivity);
        goto L117
    L5:
        startedActivityRootTask = this.mTargetRootTask;
        goto L7
    }

    private void modifyPrefetchStateInTask(Task task, String reason) {
        int curDispId = this.mPreferredTaskDisplayArea.getDisplayId();
        boolean isPrefetchDispId = SysOptBridge.getFactory().getSysPrefetchService().isVirtualDisplayId(curDispId);
        if (task == null) goto L6;
        if (isPrefetchDispId == false) goto L6;
        task.prefetchState |= 1;
        return;
    L6:
        task.prefetchState |= 65536;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.android.server.wm.Task] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    int startActivityInner(ActivityRecord r, ActivityRecord sourceRecord, IVoiceInteractionSession voiceSession, IVoiceInteractor voiceInteractor, int startFlags, ActivityOptions options, Task inTask, TaskFragment inTaskFragment, BackgroundActivityStartController.BalVerdict balVerdict, NeededUriGrants intentGrants, int realCallingUid, int unfreezedPid) {
        setInitialState(r, options, inTask, inTaskFragment, startFlags, sourceRecord, voiceSession, voiceInteractor, balVerdict.getCode(), realCallingUid);
        computeLaunchingTaskFlags();
        SysFwBridge.getFactory().getPreStartingWindowOpt().initEx();
        this.mIntent.setFlags(this.mLaunchFlags);
        Iterator<ActivityRecord> r2 = this.mSupervisor.mStoppingActivities.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        ActivityRecord stoppingActivity = r2.next();
        if (stoppingActivity.getActivityType() != 5) goto L4;
        boolean dreamStopping = true;
    L10:
        Task prevTopRootTask = this.mPreferredTaskDisplayArea.getFocusedRootTask();
        if (prevTopRootTask == null) goto L13;
        Task r1 = prevTopRootTask.getTopLeafTask();
    L14:
        Task prevTopTask = r1;
        if (sourceRecord != null) goto L17;
    L19:
        boolean r3 = false;
    L20:
        boolean sourceActivityLaunchedFromBubble = r3;
        Task reusedTask = resolveReusableTask(sourceActivityLaunchedFromBubble);
        IPerfThermalMonitor r4 = SysOptBridge.getFactory().getPerfThermalMonitorInstance();
        if (r != null) goto L23;
    L25:
        ApplicationInfo r5 = null;
    L27:
        if (r4.isAllowStart(r5) == true) goto L30;
        return 102;
    L30:
        if (this.mOptions != null) goto L32;
    L38:
        if (reusedTask == null) goto L40;
        Task targetTask = reusedTask;
    L41:
        if (targetTask != null) goto L43;
        boolean newTask = true;
    L44:
        this.mTargetTask = targetTask;
        if (r == null) goto L53;
        int r16 = 102;
        if (this.mPreferredTaskDisplayArea == null) goto L54;
        if (this.mSupervisor.mActivityTaskSupervisorZteHook.checkShouldAbortStartForCarMap(r.packageName, this.mPreferredTaskDisplayArea.getDisplayId(), r.intent, this.mCallingUid) == false) goto L54;
        Slog.d("ActivityTaskManager", "abortForCarMap r=" + r);
        return 102;
    L54:
        computeLaunchParams(r, sourceRecord, targetTask);
        int startResult = isAllowedToStart(r, newTask, targetTask);
        if (startResult != 0) goto L57;
        if (targetTask == null) goto L87;
        if (targetTask.getTreeWeight() <= MAX_TASK_WEIGHT_FOR_ADDING_ACTIVITY) goto L66;
        Slog.e("ActivityTaskManager", "Remove " + targetTask + " because it has contained too many activities or windows (abort starting " + r + " from uid=" + this.mCallingUid);
        targetTask.removeImmediately("bulky-task");
        return r16;
    L66:
        if (avoidMoveToFront() == true) goto L81;
        if (this.mService.mHomeProcess == null) goto L73;
        if (this.mService.mHomeProcess.mUid == realCallingUid) goto L81;
    L73:
        if (prevTopTask == null) goto L81;
        if (prevTopTask.isActivityTypeHomeOrRecents() == false) goto L81;
        if (r.mTransitionController.isTransientHide(targetTask) == false) goto L81;
        this.mCanMoveToFrontCode = 2;
    L81:
        if (avoidMoveToFront() == false) goto L83;
    L85:
        this.mPriorAboveTask = TaskDisplayArea.getRootTaskAbove(targetTask.getRootTask());
        goto L87
    L83:
        if (balVerdict.onlyCreatorAllows() == false) goto L85;
        this.mCanMoveToFrontCode = 1;
    L87:
        if (newTask == false) goto L89;
        ActivityRecord targetTaskTop = null;
    L91:
        if (this.mStartActivity.mActivityComponent.toString().contains("com.android.provision/.DefaultActivity") == false) goto L93;
        Slog.d("ActivityTaskManager", "startActivityInner: " + this.mStartActivity.mActivityComponent + " launcherflag: " + this.mLaunchFlags + " launchemode: " + this.mStartActivity.launchMode + " activityType: " + this.mStartActivity.getActivityType() + " windowMode: " + this.mStartActivity.getWindowingMode() + " reusetask: " + reusedTask + " targetTask: " + targetTask + " sourcerecord: " + this.mSourceRecord + " homeRootTask: " + this.mPreferredTaskDisplayArea.getRootHomeTask());
    L93:
        if (targetTaskTop != null) goto L95;
    L97:
        if (targetTaskTop != null) goto L99;
        Task targetTask2 = targetTask;
        NeededUriGrants r6 = intentGrants;
        boolean newTask2 = true;
        this.mAddingToTask = true;
    L129:
        Task topRootTask = this.mPreferredTaskDisplayArea.getFocusedRootTask();
        if (topRootTask == null) goto L137;
        modifyPrefetchStateInTask(topRootTask, "topRootTask");
        int startResult2 = deliverToCurrentTopIfNeeded(topRootTask, r6);
        if (startResult2 == 0) goto L137;
        if (Features.FEAT_QUICK_WIN == false) goto L136;
        topRootTask.getExt().adjustBoundsIfNeeded(options, this.mStartActivity, this.mSourceRootTask, this.mIntent, false, this.mRequest.realCallingPid);
    L136:
        return startResult2;
    L137:
        this.mRootWindowContainer.startPowerModeLaunchIfNeeded(false, this.mStartActivity);
        if (this.mTargetRootTask != null) goto L141;
        this.mTargetRootTask = getOrCreateRootTask(this.mStartActivity, this.mLaunchFlags, targetTask2, this.mOptions);
    L141:
        if (this.mTargetRootTask == null) goto L144;
        if (newTask == false) goto L144;
        modifyPrefetchStateInTask(this.mTargetRootTask, "newTask");
        this.mService.getSmtEx().warmStartSvpSetting(this.mTargetRootTask, this.mStartActivity, unfreezedPid);
    L144:
        if (newTask == 0) goto L154;
        if (this.mLaunchTaskBehind == true) goto L148;
    L150:
        Task taskToAffiliate = null;
    L151:
        setNewTask(taskToAffiliate);
    L157:
        if (Features.FEAT_QUICK_WIN == false) goto L159;
        int r25 = 0;
        newTask2 = true;
        this.mTargetRootTask.getExt().adjustBoundsIfNeeded(options, this.mStartActivity, this.mSourceRootTask, this.mIntent, false, this.mRequest.realCallingPid);
    L160:
        recordTransientLaunchIfNeeded(this.mLastStartActivityRecord);
        if (this.mDoResume == true) goto L163;
    L176:
        this.mService.mUgmInternal.grantUriPermissionUncheckedFromIntent(r6, this.mStartActivity.getUriPermissionsLocked());
        if (this.mStartActivity.resultTo != null) goto L179;
    L182:
        Task topRootTask2 = topRootTask;
        if (this.mStartActivity.mShareIdentity == false) goto L185;
        this.mService.getPackageManagerInternalLocked().grantImplicitAccess(this.mStartActivity.mUserId, this.mIntent, UserHandle.getAppId(this.mStartActivity.info.applicationInfo.uid), r.launchedFromUid, true);
    L185:
        Task startedTask = this.mStartActivity.getTask();
        if (newTask == 0) goto L190;
        EventLogTags.writeWmCreateTask(this.mStartActivity.mUserId, startedTask.mTaskId, startedTask.getRootTaskId(), startedTask.getDisplayId());
        ZTEActivityEventsInternal zteActivityEventsInternal = (ZTEActivityEventsInternal) LocalServices.getService(ZTEActivityEventsInternal.class);
        if (zteActivityEventsInternal == null) goto L190;
        zteActivityEventsInternal.notifyActivityEvent(8192, startedTask.getDisplayId(), startedTask.mUserId, startedTask.topRunningActivity(), startedTask.getRootTaskId());
    L190:
        this.mStartActivity.logStartActivity(EventLogTags.WM_CREATE_ACTIVITY, startedTask);
        ZTEActivityEventsInternal zteActivityEventsInternal2 = (ZTEActivityEventsInternal) LocalServices.getService(ZTEActivityEventsInternal.class);
        if (zteActivityEventsInternal2 == null) goto L193;
        zteActivityEventsInternal2.notifyActivityEvent(8, startedTask.getDisplayId(), startedTask.mUserId, this.mStartActivity, startedTask.getRootTaskId());
    L193:
        this.mStartActivity.getTaskFragment().clearLastPausedActivity();
        if (startedTask == prevTopTask) goto L196;
        ?? r7 = 1;
    L197:
        Task targetTask3 = topRootTask2;
        this.mTargetRootTask.startActivityLocked(this.mStartActivity, targetTask3, newTask, r7, this.mOptions, sourceRecord);
        if (this.mDoResume == false) goto L219;
        ActivityRecord topTaskActivity = startedTask.topRunningActivityLocked();
        if (this.mTargetRootTask.isTopActivityFocusable() == false) goto L217;
        if (topTaskActivity == null) goto L208;
        if (topTaskActivity.isTaskOverlay() == false) goto L208;
        if (this.mStartActivity != topTaskActivity) goto L217;
    L208:
        if (this.mTargetRootTask.isTopActivityFocusable() == true) goto L210;
    L215:
        RootWindowContainer r8 = this.mRootWindowContainer;
        Task r9 = this.mTargetRootTask;
        ActivityRecord r10 = this.mStartActivity;
        ActivityOptions r0 = this.mOptions;
        boolean newTask3 = this.mTransientLaunch;
        r8.resumeFocusedTasksTopActivities(r9, r10, r0, newTask3);
        goto L219
    L210:
        if (this.mRootWindowContainer.isTopDisplayFocusedRootTask(this.mTargetRootTask) == true) goto L215;
        if (avoidMoveToFront() == true) goto L214;
        this.mTargetRootTask.moveToFront("startActivityInner");
        goto L215
    L214:
        logPIOnlyCreatorAllowsBAL();
    L217:
        this.mTargetRootTask.ensureActivitiesVisible(null);
        this.mTargetRootTask.mDisplayContent.executeAppTransition();
    L219:
        this.mRootWindowContainer.updateUserRootTask(this.mStartActivity.mUserId, this.mTargetRootTask);
        this.mSupervisor.mRecentTasks.add(startedTask);
        this.mSupervisor.handleNonResizableTaskIfNeeded(startedTask, this.mPreferredWindowingMode, this.mPreferredTaskDisplayArea, this.mTargetRootTask);
        if (this.mOptions != null) goto L222;
    L229:
        this.mSupervisor.getBackgroundActivityLaunchController().onNewActivityLaunched(this.mStartActivity);
        return r25;
    L222:
        if (this.mOptions.isLaunchIntoPip() == false) goto L229;
        if (sourceRecord == null) goto L229;
        if (sourceRecord.getTask() != this.mStartActivity.getTask()) goto L229;
        if (balVerdict.allows() == false) goto L229;
        this.mRootWindowContainer.moveActivityToPinnedRootTask(this.mStartActivity, sourceRecord, "launch-into-pip", null);
        goto L229
    L196:
        r7 = r25;
        goto L197
    L179:
        if (this.mStartActivity.resultTo.info == null) goto L182;
        PackageManagerInternal pmInternal = this.mService.getPackageManagerInternalLocked();
        topRootTask2 = topRootTask;
        int resultToUid = pmInternal.getPackageUid(this.mStartActivity.resultTo.info.packageName, 0, this.mStartActivity.mUserId);
        pmInternal.grantImplicitAccess(this.mStartActivity.mUserId, this.mIntent, UserHandle.getAppId(this.mStartActivity.info.applicationInfo.uid), resultToUid, true);
        goto L185
    L163:
        if (avoidMoveToFront() == true) goto L175;
        this.mTargetRootTask.getRootTask().moveToFront("reuseOrNewTask", targetTask2);
        if (this.mTargetRootTask.isTopRootTaskInDisplayArea() == false) goto L167;
    L170:
        ?? r13 = r25;
    L172:
        if (r13 == 0) goto L176;
        this.mLaunchTaskBehind = newTask2;
        r.mLaunchTaskBehind = newTask2;
        goto L176
    L167:
        if (this.mService.isDreaming() == false) goto L170;
        if (dreamStopping == true) goto L170;
        r13 = newTask2;
        goto L172
    L175:
        logPIOnlyCreatorAllowsBAL();
        goto L176
    L159:
        r25 = 0;
        goto L160
    L148:
        if (this.mSourceRecord == null) goto L150;
        taskToAffiliate = this.mSourceRecord.getTask();
        goto L151
    L154:
        if (this.mAddingToTask == false) goto L157;
        addOrReparentStartingActivity(targetTask2, "adding to task");
        goto L157
    L99:
        if (3 == this.mLaunchMode) goto L101;
    L110:
        Task reusedTask2 = reusedTask;
    L112:
        if (this.mLastStartActivityRecord == null) goto L114;
        targetTaskTop.mLaunchSourceType = this.mLastStartActivityRecord.mLaunchSourceType;
    L114:
        recordTransientLaunchIfNeeded(targetTaskTop);
        if (reusedTask2 == null) goto L117;
        this.mService.getSmtEx().hotStartSvpSetting(targetTask, this.mStartActivity, unfreezedPid);
    L117:
        int startResult3 = recycleTask(targetTask, targetTaskTop, reusedTask2, intentGrants, balVerdict);
        targetTask2 = targetTask;
        r6 = intentGrants;
        if (startResult3 != 0) goto L120;
        newTask2 = true;
        goto L129
    L120:
        if (this.mPrefetchFirstStart == false) goto L123;
        this.mSupervisor.mRecentTasks.add(targetTask2);
    L123:
        if (Features.FEAT_QUICK_WIN == false) goto L126;
        targetTask2.getExt().adjustBoundsIfNeeded(options, this.mStartActivity, this.mSourceRootTask, this.mIntent, false, this.mRequest.realCallingPid);
    L126:
        return startResult3;
    L101:
        if (this.mSourceRecord == null) goto L110;
        if (targetTask != this.mSourceRecord.getTask()) goto L109;
        reusedTask2 = reusedTask;
        ActivityRecord activity = this.mRootWindowContainer.findActivity(this.mIntent, this.mStartActivity.info, false);
        if (activity == null) goto L112;
        if (activity.getTask() == targetTask) goto L112;
        activity.destroyIfPossible("Removes redundant singleInstance");
        goto L112
    L109:
        reusedTask2 = reusedTask;
        goto L112
    L95:
        if (targetTaskTop.getTask() == null) goto L97;
        modifyPrefetchStateInTask(targetTaskTop.getTask(), "targetTaskTop");
        goto L97
    L89:
        targetTaskTop = targetTask.getTopNonFinishingActivity();
        goto L91
    L57:
        if (r.resultTo == null) goto L59;
        r.resultTo.sendResult(-1, r.resultWho, r.requestCode, 0, null, null, null);
    L59:
        return startResult;
    L53:
        r16 = 102;
        goto L54
    L43:
        newTask = false;
        goto L44
    L40:
        targetTask = computeTargetTask();
        goto L41
    L32:
        if (this.mOptions.freezeRecentTasksReordering() == false) goto L38;
        if (this.mSupervisor.mRecentTasks.isCallerRecents(r.launchedFromUid) == false) goto L38;
        if (this.mSupervisor.mRecentTasks.isFreezeTaskListReorderingSet() == true) goto L38;
        this.mFrozeTaskList = true;
        this.mSupervisor.mRecentTasks.setFreezeTaskListReordering();
        goto L38
    L23:
        if (r.info == null) goto L25;
        r5 = r.info.applicationInfo;
        goto L27
    L17:
        if (sourceRecord.getLaunchedFromBubble() == false) goto L19;
        r3 = true;
        goto L20
    L13:
        r1 = null;
        goto L14
    L9:
        dreamStopping = false;
        goto L10
    }

    private void logPIOnlyCreatorAllowsBAL() {
        if (avoidMoveToFrontPIOnlyCreatorAllows() == true) goto L5;
        return;
    L5:
        String realCallingPackage = this.mService.mContext.getPackageManager().getNameForUid(this.mRealCallingUid);
        if (realCallingPackage != null) goto L8;
        realCallingPackage = "uid=" + this.mRealCallingUid;
    L8:
        Slog.wtf("ActivityTaskManager", "Without Android 15 BAL hardening this activity would be moved to the foreground. The activity is started by a PendingIntent. However, only the creator of the PendingIntent allows BAL while the sender does not allow BAL. realCallingPackage: " + realCallingPackage + "; callingPackage: " + this.mRequest.callingPackage + "; mTargetRootTask:" + this.mTargetRootTask + "; mIntent: " + this.mIntent + "; mTargetRootTask.getTopNonFinishingActivity: " + this.mTargetRootTask.getTopNonFinishingActivity() + "; mTargetRootTask.getRootActivity: " + this.mTargetRootTask.getRootActivity());
    }

    private void recordTransientLaunchIfNeeded(ActivityRecord r) {
        if (r != null) goto L4;
        return;
    L4:
        if (this.mTransientLaunch == false) goto L15;
        TransitionController controller = r.mTransitionController;
        if (controller.isCollecting() == true) goto L9;
        return;
    L9:
        if (controller.isTransientCollect(r) == true) goto L14;
        controller.setTransientLaunch(r, this.mPriorAboveTask);
        return;
    L14:
        return;
    }

    private Task computeTargetTask() {
        if (this.mStartActivity.resultTo != null) goto L12;
        if (this.mInTask != null) goto L12;
        if (this.mAddingToTask == true) goto L12;
        if ((this.mLaunchFlags & 268435456) == 0) goto L12;
        return null;
    L12:
        if (this.mSourceRecord == null) goto L16;
        return this.mSourceRecord.getTask();
    L16:
        if (this.mInTask != null) goto L18;
        Task rootTask = getOrCreateRootTask(this.mStartActivity, this.mLaunchFlags, null, this.mOptions);
        ActivityRecord top = rootTask.getTopNonFinishingActivity();
        if (top != null) goto L25;
        rootTask.removeIfPossible("computeTargetTask");
        return null;
    L25:
        return top.getTask();
    L18:
        if (this.mInTask.isAttached() == true) goto L21;
        getOrCreateRootTask(this.mStartActivity, this.mLaunchFlags, this.mInTask, this.mOptions);
    L21:
        return this.mInTask;
    }

    private void computeLaunchParams(ActivityRecord r, ActivityRecord sourceRecord, Task targetTask) {
        this.mSupervisor.getLaunchParamsController().calculate(targetTask, r.info.windowLayout, r, sourceRecord, this.mOptions, this.mRequest, 3, this.mLaunchParams);
        if (this.mLaunchParams.hasPreferredTaskDisplayArea() == false) goto L5;
        TaskDisplayArea r11 = this.mLaunchParams.mPreferredTaskDisplayArea;
    L6:
        this.mPreferredTaskDisplayArea = r11;
        this.mPreferredWindowingMode = this.mLaunchParams.mWindowingMode;
        if (this.mLaunchParams.mNeedsSafeRegionBounds == null) goto L9;
        r.setNeedsSafeRegionBounds(this.mLaunchParams.mNeedsSafeRegionBounds.booleanValue());
    L9:
        this.mOptions = this.mObricExt.adjustLaunchParams(this.mLaunchParams, r, this.mOptions);
        if (this.mLaunchParams.hasPreferredTaskDisplayArea() == false) goto L13;
        this.mPreferredTaskDisplayArea = this.mLaunchParams.mPreferredTaskDisplayArea;
        return;
    L13:
        return;
    L5:
        r11 = this.mRootWindowContainer.getDefaultTaskDisplayArea();
        goto L6
    }

    private TaskDisplayArea computeSuggestedLaunchDisplayArea(Task task, ActivityRecord source, ActivityOptions options) {
        this.mSupervisor.getLaunchParamsController().calculate(task, null, null, source, options, this.mRequest, 0, this.mLaunchParams);
        if (this.mLaunchParams.hasPreferredTaskDisplayArea() == false) goto L6;
        return this.mLaunchParams.mPreferredTaskDisplayArea;
    L6:
        return this.mRootWindowContainer.getDefaultTaskDisplayArea();
    }

    int isAllowedToStart(final ActivityRecord r, boolean newTask, Task targetTask) {
        if (r.packageName != null) goto L7;
        ActivityOptions.abort(this.mOptions);
        return -92;
    L7:
        if (r.isActivityTypeHome() == false) goto L13;
        if (this.mRootWindowContainer.canStartHomeOnDisplayArea(r.info, this.mPreferredTaskDisplayArea, true) == true) goto L13;
        Slog.w("ActivityTaskManager", "Cannot launch home on display area " + this.mPreferredTaskDisplayArea);
        return -96;
    L13:
        if (newTask == false) goto L15;
    L22:
        boolean r1 = true;
    L23:
        boolean blockBalInTask = r1;
        if (this.mBalCode != 127) goto L31;
        if (blockBalInTask == false) goto L31;
        if (handleBackgroundActivityAbort(r) == false) goto L31;
        Slog.e("ActivityTaskManager", "Abort background activity starts from " + this.mCallingUid);
        return 102;
    L31:
        if ((this.mLaunchFlags & 268468224) != 268468224) goto L33;
        boolean r2 = true;
    L34:
        boolean isNewClearTask = r2;
        if (newTask == true) goto L41;
        if (this.mService.getLockTaskController().isLockTaskModeViolation(targetTask, isNewClearTask) == false) goto L45;
        Slog.e("ActivityTaskManager", "Attempted Lock Task Mode violation r=" + r);
        return 101;
    L45:
        if (this.mPreferredTaskDisplayArea == null) goto L68;
        DisplayContent displayContent = this.mRootWindowContainer.getDisplayContentOrCreate(this.mPreferredTaskDisplayArea.getDisplayId());
        if (displayContent == null) goto L68;
        if (this.mObricExt.blockAppLaunch(displayContent, r.packageName) == false) goto L52;
        Slog.d("ActivityTaskManager", "block app start since it's in blacklist");
        return 102;
    L52:
        if (targetTask == null) goto L54;
        int r5 = targetTask.getWindowingMode();
    L55:
        int targetWindowingMode = r5;
        if (this.mSourceRecord == null) goto L58;
        int launchingFromDisplayId = this.mSourceRecord.getDisplayId();
    L60:
        if (r.resultTo == null) goto L62;
        boolean isResultExpected = true;
    L63:
        Supplier<IntentSender> intentSender = new ActivityStarter$$ExternalSyntheticLambda1(this, r);
        if (displayContent.mDwpcHelper.canActivityBeLaunched(r.info, r.intent, targetWindowingMode, launchingFromDisplayId, newTask, isResultExpected, intentSender) == true) goto L68;
        Slog.w("ActivityTaskManager", "Abort to launch " + r.info.getComponentName() + " on display area " + this.mPreferredTaskDisplayArea);
        return 102;
    L62:
        isResultExpected = false;
        goto L63
    L58:
        launchingFromDisplayId = 0;
        goto L60
    L54:
        r5 = displayContent.getWindowingMode();
    L68:
        if (this.mSupervisor.getBackgroundActivityLaunchController().checkActivityAllowedToStart(this.mSourceRecord, r, newTask, avoidMoveToFront(), targetTask, this.mLaunchFlags, this.mBalCode, this.mCallingUid, this.mRealCallingUid, this.mPreferredTaskDisplayArea) == true) goto L70;
        return 102;
    L70:
        return 0;
    L41:
        if (this.mService.getLockTaskController().isNewTaskLockTaskModeViolation(r) == false) goto L45;
        Slog.e("ActivityTaskManager", "Attempted Lock Task Mode violation r=" + r);
        return 101;
    L33:
        r2 = false;
        goto L34
    L15:
        if (targetTask.isUidPresent(this.mCallingUid) == false) goto L22;
        if (3 == this.mLaunchMode) goto L19;
    L21:
        r1 = false;
        goto L23
    L19:
        if (targetTask.inPinnedWindowingMode() == false) goto L21;
        goto L21
    }

    private /* synthetic */ IntentSender lambda$isAllowedToStart$0(ActivityRecord r) {
        ActivityTaskManagerService r0 = this.mService;
        String r2 = this.mRequest.callingPackage;
        String r3 = this.mRequest.callingFeatureId;
        int r4 = this.mCallingUid;
        int r5 = r.mUserId;
        Intent[] r9 = {this.mIntent};
        String[] r10 = {r.resolvedType};
        if (this.mOptions != null) goto L6;
        Bundle r1 = null;
    L7:
        IIntentSender target = r0.getIntentSenderLocked(2, r2, r3, r4, r5, null, null, 0, r9, r10, 1342177280, r1);
        return new IntentSender(target);
    L6:
        r1 = this.mOptions.toBundle();
        goto L7
    }

    static int canEmbedActivity(TaskFragment taskFragment, ActivityRecord starting, Task targetTask) {
        Task hostTask = taskFragment.getTask();
        if (hostTask == null) goto L8;
        if (targetTask == hostTask) goto L7;
        return 3;
    L7:
        return taskFragment.isAllowedToEmbedActivity(starting);
    L8:
        return 3;
    }

    int recycleTask(Task targetTask, ActivityRecord targetTaskTop, Task reusedTask, NeededUriGrants intentGrants, BackgroundActivityStartController.BalVerdict balVerdict) {
        if (targetTask.mUserId == this.mStartActivity.mUserId) goto L7;
        this.mTargetRootTask = targetTask.getRootTask();
        this.mAddingToTask = true;
        return 0;
    L7:
        if (this.mObricExt.recycleTask(reusedTask, this.mLaunchParams) == false) goto L10;
        Slog.d("ActivityTaskManager", "the app is visible on user's display, do not open");
        return 102;
    L10:
        if (reusedTask != null) goto L12;
    L21:
        this.mRootWindowContainer.startPowerModeLaunchIfNeeded(false, targetTaskTop);
        setTargetRootTaskIfNeeded(targetTaskTop);
        if (this.mLastStartActivityRecord == null) goto L29;
        if (this.mLastStartActivityRecord.finishing == false) goto L26;
    L27:
        this.mLastStartActivityRecord = targetTaskTop;
        goto L29
    L26:
        if (this.mLastStartActivityRecord.isNoDisplay() == true) goto L27;
    L29:
        if ((this.mStartFlags & 1) != 0) goto L31;
        if (reusedTask == null) goto L43;
        ActivityRecord r1 = reusedTask.getTopNonFinishingActivity();
    L44:
        complyActivityFlags(targetTask, r1, intentGrants);
        if (this.mAddingToTask == false) goto L49;
        this.mSupervisor.getBackgroundActivityLaunchController().clearTopIfNeeded(targetTask, this.mSourceRecord, this.mStartActivity, this.mCallingUid, this.mRealCallingUid, this.mLaunchFlags, this.mBalCode);
        return 0;
    L49:
        if (this.mMovedToTopActivity == null) goto L51;
        ActivityRecord targetTaskTop2 = this.mMovedToTopActivity;
    L53:
        if (targetTaskTop2.finishing == false) goto L55;
        ActivityRecord r2 = targetTask.getTopNonFinishingActivity();
    L56:
        ActivityRecord targetTaskTop3 = r2;
        if (this.mMovedToFront == true) goto L62;
        if (this.mPrefetchFirstStart == false) goto L62;
        targetTaskTop3.showStartingWindow(null, true, true, false, null);
    L62:
        if (this.mMovedToFront == false) goto L65;
        targetTaskTop3.showStartingWindow(true);
    L67:
        resumeTargetRootTaskIfNeeded();
        if (this.mService.isDreaming() == true) goto L70;
    L72:
        this.mLastStartActivityRecord = targetTaskTop3;
        if (this.mMovedToFront == false) goto L75;
        return 2;
    L75:
        return 3;
    L70:
        if (targetTaskTop3.canTurnScreenOn() == false) goto L72;
        targetTaskTop3.mTaskSupervisor.wakeUp(targetTaskTop3.getDisplayId(), "recycleTask#turnScreenOnFlag");
        goto L72
    L65:
        if (this.mDoResume == false) goto L67;
        this.mTargetRootTask.moveToFront("intentActivityFound");
        goto L67
    L55:
        r2 = targetTaskTop2;
        goto L56
    L51:
        targetTaskTop2 = targetTaskTop;
        goto L53
    L43:
        r1 = null;
        goto L44
    L31:
        if (this.mMovedToFront == false) goto L33;
    L38:
        resumeTargetRootTaskIfNeeded();
        return 1;
    L33:
        if (this.mDoResume == false) goto L38;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L37;
        String protoLogParam0 = String.valueOf(this.mTargetRootTask);
        String protoLogParam1 = String.valueOf(targetTaskTop);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, -2867366986304729L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L37:
        this.mTargetRootTask.moveToFront("intentActivityFound");
        goto L38
    L12:
        if (targetTask.intent != null) goto L15;
        targetTask.setIntent(this.mStartActivity);
        goto L21
    L15:
        if ((this.mStartActivity.intent.getFlags() & 16384) == 0) goto L17;
        boolean taskOnHome = true;
    L18:
        if (taskOnHome == false) goto L20;
        targetTask.intent.addFlags(16384);
        goto L21
    L20:
        targetTask.intent.removeFlags(16384);
        goto L21
    L17:
        taskOnHome = false;
        goto L18
    }

    private int deliverToCurrentTopIfNeeded(Task topRootTask, NeededUriGrants intentGrants) {
        ActivityRecord top = topRootTask.topRunningNonDelayedActivityLocked(this.mNotTop);
        if (top != null) goto L5;
    L19:
        boolean dontStart = false;
    L21:
        if (dontStart == true) goto L23;
        return 0;
    L23:
        top.getTaskFragment().clearLastPausedActivity();
        if (this.mDoResume == false) goto L26;
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();
    L26:
        ActivityOptions.abort(this.mOptions);
        if ((this.mStartFlags & 1) == 0) goto L30;
        return 1;
    L30:
        if (this.mStartActivity.resultTo == null) goto L32;
        this.mStartActivity.resultTo.sendResult(-1, this.mStartActivity.resultWho, this.mStartActivity.requestCode, 0, null, null, null);
        this.mStartActivity.resultTo = null;
    L32:
        deliverNewIntent(top, intentGrants);
        this.mSupervisor.handleNonResizableTaskIfNeeded(top.getTask(), this.mLaunchParams.mWindowingMode, this.mPreferredTaskDisplayArea, topRootTask);
        return 3;
    L5:
        if (top.mActivityComponent.equals(this.mStartActivity.mActivityComponent) == false) goto L19;
        if (top.mUserId != this.mStartActivity.mUserId) goto L19;
        if (top.attachedToProcess() == false) goto L19;
        if ((this.mLaunchFlags & 536870912) != 0) goto L15;
        if (1 != this.mLaunchMode) goto L19;
    L15:
        if (top.isActivityTypeHome() == true) goto L17;
    L18:
        dontStart = true;
        goto L21
    L17:
        if (top.getDisplayArea() != this.mPreferredTaskDisplayArea) goto L19;
        goto L18
    }

    private void complyActivityFlags(Task targetTask, ActivityRecord reusedActivity, NeededUriGrants intentGrants) {
        ActivityRecord targetTaskTop = targetTask.getTopNonFinishingActivity();
        boolean r1 = false;
        if (reusedActivity != null) goto L5;
    L7:
        boolean resetTask = false;
    L8:
        if (resetTask == false) goto L11;
        targetTaskTop = this.mTargetRootTask.resetTaskIfNeeded(targetTaskTop, this.mStartActivity);
    L11:
        if ((this.mLaunchFlags & 268468224) != 268468224) goto L14;
        targetTask.performClearTaskForReuse(true);
        targetTask.setIntent(this.mStartActivity);
        this.mAddingToTask = true;
        this.mIsTaskCleared = true;
        return;
    L14:
        if ((this.mLaunchFlags & 67108864) == 0) goto L16;
    L61:
        int[] finishCount = new int[1];
        ActivityRecord clearTop = targetTask.performClearTop(this.mStartActivity, this.mLaunchFlags, finishCount);
        if (clearTop != null) goto L64;
    L72:
        this.mAddingToTask = true;
        if (clearTop == null) goto L80;
        if (clearTop.getTaskFragment() == null) goto L80;
        if (clearTop.getTaskFragment().isEmbedded() == false) goto L80;
        this.mAddingToTaskFragment = clearTop.getTaskFragment();
    L80:
        if (targetTask.getRootTask() != null) goto L99;
        this.mTargetRootTask = getOrCreateRootTask(this.mStartActivity, this.mLaunchFlags, null, this.mOptions);
        Task r6 = this.mTargetRootTask;
        boolean r7 = !this.mLaunchTaskBehind;
        if ((this.mStartActivity.info.flags & 1024) == 0) goto L84;
        r1 = true;
    L84:
        r6.addChild(targetTask, r7, r1);
        return;
    L99:
        return;
    L64:
        if (clearTop.finishing == true) goto L72;
        if (finishCount[0] <= 0) goto L69;
        this.mMovedToTopActivity = clearTop;
    L69:
        if (clearTop.isRootOfTask() == false) goto L71;
        clearTop.getTask().setIntent(this.mStartActivity);
    L71:
        deliverNewIntent(clearTop, intentGrants);
        return;
    L16:
        if (isDocumentLaunchesIntoExisting(this.mLaunchFlags) == true) goto L61;
        if (isLaunchModeOneOf(3, 2, 4) == true) goto L61;
        if ((this.mLaunchFlags & 67108864) != 0) goto L35;
        if (this.mAddingToTask == true) goto L35;
        if ((this.mLaunchFlags & 131072) == 0) goto L35;
        ActivityRecord act = targetTask.findActivityInHistory(this.mStartActivity.mActivityComponent, this.mStartActivity.mUserId);
        if (act == null) goto L32;
        Task task = act.getTask();
        boolean actuallyMoved = task.moveActivityToFront(act);
        if (actuallyMoved == false) goto L31;
        this.mMovedToTopActivity = act;
    L31:
        act.updateOptionsLocked(this.mOptions);
        deliverNewIntent(act, intentGrants);
        act.getTaskFragment().clearLastPausedActivity();
        return;
    L32:
        this.mAddingToTask = true;
        return;
    L35:
        if (this.mStartActivity.mActivityComponent.equals(targetTask.realActivity) == true) goto L37;
        if (resetTask == true) goto L59;
        this.mAddingToTask = true;
        return;
    L59:
        if (targetTask.rootWasReset == true) goto L92;
        targetTask.setIntent(this.mStartActivity);
        return;
    L92:
        return;
    L37:
        if (targetTask != this.mInTask) goto L40;
        return;
    L40:
        if ((this.mLaunchFlags & 536870912) != 0) goto L44;
        if (1 == this.mLaunchMode) goto L44;
    L52:
        if (targetTask.isSameIntentFilter(this.mStartActivity) == true) goto L54;
        this.mAddingToTask = true;
        return;
    L54:
        if (reusedActivity != null) goto L89;
        this.mAddingToTask = true;
        return;
    L89:
        return;
    L44:
        if (targetTaskTop.mActivityComponent.equals(this.mStartActivity.mActivityComponent) == false) goto L52;
        if (this.mStartActivity.resultTo != null) goto L52;
        if (targetTaskTop.isRootOfTask() == false) goto L50;
        targetTaskTop.getTask().setIntent(this.mStartActivity);
    L50:
        deliverNewIntent(targetTaskTop, intentGrants);
        return;
    L5:
        if ((this.mLaunchFlags & 2097152) == 0) goto L7;
        resetTask = true;
        goto L8
    }

    void reset(boolean clearRequest) {
        this.mStartActivity = null;
        this.mIntent = null;
        this.mCallingUid = -1;
        this.mRealCallingUid = -1;
        this.mOptions = null;
        this.mBalCode = 1;
        this.mLaunchTaskBehind = false;
        this.mLaunchFlags = 0;
        this.mLaunchMode = -1;
        this.mLaunchParams.reset();
        this.mNotTop = null;
        this.mDoResume = false;
        this.mStartFlags = 0;
        this.mSourceRecord = null;
        this.mPreferredTaskDisplayArea = null;
        this.mPreferredWindowingMode = 0;
        this.mInTask = null;
        this.mInTaskFragment = null;
        this.mAddingToTaskFragment = null;
        this.mAddingToTask = false;
        this.mMovedToTopActivity = null;
        this.mSourceRootTask = null;
        this.mTargetRootTask = null;
        this.mTargetTask = null;
        this.mIsTaskCleared = false;
        this.mMovedToFront = false;
        this.mNoAnimation = false;
        this.mCanMoveToFrontCode = 0;
        this.mFrozeTaskList = false;
        this.mTransientLaunch = false;
        this.mPriorAboveTask = null;
        this.mDisplayLockAndOccluded = false;
        this.mVoiceSession = null;
        this.mVoiceInteractor = null;
        this.mIntentDelivered = false;
        if (clearRequest == false) goto L6;
        this.mRequest.reset();
        return;
    }

    private void setInitialState(ActivityRecord r, ActivityOptions options, Task inTask, TaskFragment inTaskFragment, int startFlags, ActivityRecord sourceRecord, IVoiceInteractionSession voiceSession, IVoiceInteractor voiceInteractor, int balCode, int realCallingUid) {
        reset(false);
        this.mStartActivity = r;
        this.mIntent = r.intent;
        this.mOptions = options;
        this.mCallingUid = r.launchedFromUid;
        this.mRealCallingUid = realCallingUid;
        this.mSourceRecord = sourceRecord;
        if (this.mSourceRecord == null) goto L5;
        Task r1 = this.mSourceRecord.getRootTask();
    L6:
        this.mSourceRootTask = r1;
        this.mVoiceSession = voiceSession;
        this.mVoiceInteractor = voiceInteractor;
        this.mBalCode = balCode;
        this.mLaunchParams.reset();
        this.mSupervisor.getLaunchParamsController().calculate(inTask, r.info.windowLayout, r, sourceRecord, options, this.mRequest, 0, this.mLaunchParams);
        if (this.mLaunchParams.hasPreferredTaskDisplayArea() == false) goto L9;
        TaskDisplayArea r2 = this.mLaunchParams.mPreferredTaskDisplayArea;
    L10:
        this.mPreferredTaskDisplayArea = r2;
        this.mPreferredWindowingMode = this.mLaunchParams.mWindowingMode;
        this.mLaunchMode = r.launchMode;
        if (3 != this.mLaunchMode) goto L13;
        boolean r3 = true;
    L15:
        if (2 != this.mLaunchMode) goto L17;
        boolean r6 = true;
    L18:
        this.mLaunchFlags = adjustLaunchFlagsToDocumentMode(r, r3, r6, this.mIntent.getFlags());
        if (r.mLaunchTaskBehind == true) goto L21;
    L25:
        boolean r4 = false;
    L26:
        this.mLaunchTaskBehind = r4;
        if (this.mLaunchMode != 4) goto L30;
        this.mLaunchFlags |= 268435456;
    L30:
        if (r.info.requiredDisplayCategory != null) goto L32;
    L36:
        sendNewTaskResultRequestIfNeeded();
        if ((this.mLaunchFlags & 524288) == 0) goto L42;
        if (r.resultTo != null) goto L42;
        this.mLaunchFlags |= 268435456;
    L42:
        if ((this.mLaunchFlags & 268435456) != 0) goto L44;
    L48:
        ActivityTaskSupervisor r5 = this.mSupervisor;
        if ((this.mLaunchFlags & 262144) != 0) goto L51;
        boolean r7 = true;
    L52:
        r5.mUserLeaving = r7;
        if (ActivityTaskManagerDebugConfig.DEBUG_USER_LEAVING == false) goto L55;
        Slog.v("ActivityTaskManager", "startActivity() => mUserLeaving=" + this.mSupervisor.mUserLeaving);
    L55:
        boolean canShowActivity = r.showToCurrentUser();
        if (canShowActivity == true) goto L58;
        Slog.w("ActivityTaskManager", "Can't resume non-current user r=" + r);
    L58:
        if (canShowActivity == true) goto L60;
    L63:
        r.delayedResume = true;
        this.mDoResume = false;
    L65:
        if (this.mOptions != null) goto L67;
    L98:
        TaskFragment inTaskFragment2 = inTaskFragment;
    L100:
        if ((this.mLaunchFlags & 16777216) == 0) goto L102;
        ActivityRecord r8 = sourceRecord;
    L103:
        this.mNotTop = r8;
        this.mInTask = inTask;
        if (inTask == null) goto L109;
        if (inTask.inRecents == true) goto L109;
        Slog.w("ActivityTaskManager", "Starting activity in task not in recents: " + inTask);
        this.mInTask = null;
    L109:
        if (this.mInTask != null) goto L111;
    L113:
        this.mInTaskFragment = inTaskFragment2;
        this.mStartFlags = startFlags;
        if ((startFlags & 1) == 0) goto L126;
        ActivityRecord checkedCaller = sourceRecord;
        if (checkedCaller != null) goto L121;
        Task topFocusedRootTask = this.mRootWindowContainer.getTopDisplayFocusedRootTask();
        if (topFocusedRootTask == null) goto L121;
        checkedCaller = topFocusedRootTask.topRunningNonDelayedActivityLocked(this.mNotTop);
    L121:
        if (checkedCaller != null) goto L123;
    L124:
        this.mStartFlags &= -2;
        goto L126
    L123:
        if (checkedCaller.mActivityComponent.equals(r.mActivityComponent) == false) goto L124;
    L126:
        if ((this.mLaunchFlags & 65536) == 0) goto L128;
        boolean r9 = true;
    L129:
        this.mNoAnimation = r9;
        if (this.mBalCode == 127) goto L132;
        return;
    L132:
        if (this.mService.isBackgroundActivityStartsEnabled() == true) goto L136;
        this.mCanMoveToFrontCode = 2;
        this.mDoResume = false;
        return;
    L136:
        return;
    L128:
        r9 = false;
        goto L129
    L111:
        if (this.mInTask.isSameRequiredDisplayCategory(r.info) == true) goto L113;
        Slog.w("ActivityTaskManager", "Starting activity in task with different display category: " + this.mInTask);
        this.mInTask = null;
        goto L113
    L102:
        r8 = null;
        goto L103
    L67:
        if (this.mOptions.getLaunchTaskId() == (-1)) goto L79;
        if (this.mOptions.getTaskOverlay() == false) goto L79;
        r.setTaskOverlay(true);
        if (this.mOptions.canTaskOverlayResume() == true) goto L81;
        Task task = this.mRootWindowContainer.anyTaskForId(this.mOptions.getLaunchTaskId());
        if (task == null) goto L81;
        if (task.canBeResumed(r) == true) goto L81;
        this.mDoResume = false;
        this.mCanMoveToFrontCode = 2;
    L81:
        this.mTransientLaunch = this.mOptions.getTransientLaunch();
        KeyguardController kc = this.mSupervisor.getKeyguardController();
        int displayId = this.mPreferredTaskDisplayArea.getDisplayId();
        if (SysOptBridge.getFactory().getSysPrefetchService().isVirtualDisplayId(displayId) == false) goto L84;
        Slog.i("ActivityTaskManager", "prefetch set doResume");
        this.mDoResume = true;
        this.mCanMoveToFrontCode = 0;
    L84:
        this.mDisplayLockAndOccluded = kc.isKeyguardOccluded(displayId);
        if (this.mTransientLaunch == true) goto L87;
    L91:
        this.mTargetRootTask = Task.fromWindowContainerToken(this.mOptions.getLaunchRootTask());
        if (inTaskFragment != null) goto L98;
        inTaskFragment2 = TaskFragment.fromTaskFragmentToken(this.mOptions.getLaunchTaskFragmentToken(), this.mService);
        if (inTaskFragment2 == null) goto L100;
        if (inTaskFragment2.isEmbeddedTaskFragmentInPip() == false) goto L100;
        Slog.w("ActivityTaskManager", "Can not start activity in TaskFragment in PIP: " + inTaskFragment2);
        inTaskFragment2 = null;
        goto L100
    L87:
        if (this.mDisplayLockAndOccluded == false) goto L91;
        if (this.mService.getTransitionController().isShellTransitionsEnabled() == false) goto L91;
        this.mDoResume = false;
        this.mCanMoveToFrontCode = 2;
    L79:
        if (this.mOptions.getAvoidMoveToFront() == false) goto L81;
        this.mDoResume = false;
        this.mCanMoveToFrontCode = 2;
        goto L81
    L60:
        if (this.mLaunchTaskBehind == true) goto L63;
        this.mDoResume = true;
        goto L65
    L51:
        r7 = false;
        goto L52
    L44:
        if (this.mLaunchTaskBehind == false) goto L46;
    L47:
        this.mLaunchFlags |= 134217728;
        goto L48
    L46:
        if (r.info.documentLaunchMode != 2) goto L48;
    L32:
        if (this.mSourceRecord == null) goto L36;
        if (r.info.requiredDisplayCategory.equals(this.mSourceRecord.info.requiredDisplayCategory) == true) goto L36;
        this.mLaunchFlags |= 268435456;
        goto L36
    L21:
        if (isLaunchModeOneOf(2, 3) == true) goto L25;
        if ((this.mLaunchFlags & 524288) == 0) goto L25;
        r4 = true;
        goto L26
    L17:
        r6 = false;
        goto L18
    L13:
        r3 = false;
        goto L15
    L9:
        r2 = this.mRootWindowContainer.getDefaultTaskDisplayArea();
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private void sendNewTaskResultRequestIfNeeded() {
        if (this.mStartActivity.resultTo != null) goto L5;
        return;
    L5:
        if ((this.mLaunchFlags & 268435456) == 0) goto L9;
        Slog.w("ActivityTaskManager", "Activity is launching as a new task, so cancelling activity result.");
        this.mStartActivity.resultTo.sendResult(-1, this.mStartActivity.resultWho, this.mStartActivity.requestCode, 0, null, null, null);
        this.mStartActivity.resultTo = null;
        return;
    }

    private void computeLaunchingTaskFlags() {
        if (this.mSourceRecord == null) goto L5;
    L29:
        this.mInTask = null;
        if (this.mStartActivity.isResolverOrDelegateActivity() == true) goto L32;
    L37:
        if (this.mInTask == null) goto L39;
        return;
    L39:
        if (this.mSourceRecord != null) goto L46;
        if ((this.mLaunchFlags & 268435456) == 0) goto L43;
        return;
    L43:
        if (this.mInTask != null) goto L54;
        Slog.w("ActivityTaskManager", "startActivity called from non-Activity context; forcing Intent.FLAG_ACTIVITY_NEW_TASK for: " + this.mIntent);
        this.mLaunchFlags = this.mLaunchFlags | 268435456;
        return;
    L54:
        return;
    L46:
        if (this.mSourceRecord.launchMode != 3) goto L49;
        this.mLaunchFlags |= 268435456;
        return;
    L49:
        if (isLaunchModeOneOf(3, 2) == false) goto L57;
        this.mLaunchFlags |= 268435456;
        return;
    L57:
        return;
    L32:
        if (this.mSourceRecord == null) goto L37;
        if (this.mSourceRecord.inFreeformWindowingMode() == false) goto L37;
        this.mAddingToTask = true;
        goto L37
    L5:
        if (this.mInTask == null) goto L29;
        if (this.mInTask.getRootTask() == null) goto L29;
        Intent baseIntent = this.mInTask.getBaseIntent();
        ActivityRecord root = this.mInTask.getRootActivity();
        if (baseIntent != null) goto L11;
        ActivityOptions.abort(this.mOptions);
        throw new IllegalArgumentException("Launching into task without base intent: " + this.mInTask);
    L11:
        if (isLaunchModeOneOf(3, 2) == true) goto L13;
    L20:
        if (root != null) goto L23;
        this.mLaunchFlags = (this.mLaunchFlags & (-403185665)) | (baseIntent.getFlags() & 403185664);
        this.mIntent.setFlags(this.mLaunchFlags);
        this.mInTask.setIntent(this.mStartActivity);
        this.mAddingToTask = true;
        goto L37
    L23:
        if ((this.mLaunchFlags & 268435456) == 0) goto L25;
        this.mAddingToTask = false;
        goto L37
    L25:
        this.mAddingToTask = true;
        goto L37
    L13:
        if (baseIntent.getComponent().equals(this.mStartActivity.intent.getComponent()) == false) goto L18;
        if (root == null) goto L20;
        ActivityOptions.abort(this.mOptions);
        throw new IllegalArgumentException("Caller with mInTask " + this.mInTask + " has root " + root + " but target is singleInstance/Task");
    L18:
        ActivityOptions.abort(this.mOptions);
        throw new IllegalArgumentException("Trying to launch singleInstance/Task " + this.mStartActivity + " into different task " + this.mInTask);
    }

    private Task resolveReusableTask(boolean includeLaunchedFromBubble) {
        if (this.mOptions != null) goto L5;
    L12:
        boolean r4 = true;
        if ((this.mLaunchFlags & 268435456) == 0) goto L17;
        if ((this.mLaunchFlags & 134217728) != 0) goto L17;
    L18:
        boolean putIntoExistingTask = true;
    L21:
        if (this.mInTask == null) goto L23;
    L25:
        boolean r6 = false;
    L26:
        boolean putIntoExistingTask2 = putIntoExistingTask & r6;
        ActivityRecord intentActivity = null;
        if (putIntoExistingTask2 == true) goto L29;
    L45:
        if (intentActivity != null) goto L47;
    L52:
        if (intentActivity != null) goto L54;
    L60:
        if (intentActivity != null) goto L62;
        return null;
    L62:
        return intentActivity.getTask();
    L54:
        if (this.mStartActivity.isActivityTypeHome() == true) goto L58;
        if (intentActivity.isActivityTypeHome() == false) goto L60;
    L58:
        if (intentActivity.getDisplayArea() == this.mPreferredTaskDisplayArea) goto L60;
        intentActivity = null;
        goto L60
    L47:
        if (this.mLaunchMode != 4) goto L52;
        if (intentActivity.getTask().getRootActivity().mActivityComponent.equals(this.mStartActivity.mActivityComponent) == true) goto L52;
        intentActivity = null;
        goto L52
    L29:
        if (3 != this.mLaunchMode) goto L38;
        intentActivity = this.mRootWindowContainer.findActivity(this.mIntent, this.mStartActivity.info, false);
        if (intentActivity == null) goto L45;
        if (this.mStartActivity.isActivityTypeHome() == false) goto L45;
        if (intentActivity.isActivityTypeHome() == true) goto L45;
        intentActivity.destroyIfPossible("Removes redundant singleInstance");
        intentActivity = null;
        goto L45
    L38:
        if ((this.mLaunchFlags & 4096) == 0) goto L44;
        RootWindowContainer r3 = this.mRootWindowContainer;
        Intent r7 = this.mIntent;
        ActivityInfo r8 = this.mStartActivity.info;
        if (2 != this.mLaunchMode) goto L43;
        r4 = false;
    L43:
        intentActivity = r3.findActivity(r7, r8, r4);
        goto L45
    L44:
        intentActivity = this.mRootWindowContainer.findTask(this.mStartActivity, this.mPreferredTaskDisplayArea, includeLaunchedFromBubble);
        goto L45
    L23:
        if (this.mStartActivity.resultTo != null) goto L25;
        r6 = true;
    L17:
        if (isLaunchModeOneOf(3, 2) == true) goto L18;
        putIntoExistingTask = false;
        goto L21
    L5:
        if (this.mOptions.getLaunchTaskId() == (-1)) goto L12;
        Task launchTask = this.mRootWindowContainer.anyTaskForId(this.mOptions.getLaunchTaskId());
        if (launchTask != null) goto L9;
    L11:
        return null;
    L9:
        if (launchTask.isLeafTask() == false) goto L11;
        return launchTask;
    }

    private void setTargetRootTaskIfNeeded(ActivityRecord intentActivity) {
        intentActivity.getTaskFragment().clearLastPausedActivity();
        Task intentTask = intentActivity.getTask();
        if (intentTask == null) goto L5;
        Task r4 = intentTask.getRootTask();
    L6:
        Task origRootTask = r4;
        if (this.mTargetRootTask == null) goto L9;
    L14:
        this.mSupervisor.getLaunchParamsController().layoutTask(intentTask, this.mStartActivity.info.windowLayout, this.mStartActivity, this.mSourceRecord, this.mOptions);
        Task intentTask2 = intentTask;
        if (this.mTargetRootTask.getDisplayArea() != this.mPreferredTaskDisplayArea) goto L34;
        Task focusRootTask = this.mTargetRootTask.mDisplayContent.getFocusedRootTask();
        if (focusRootTask != null) goto L19;
        ActivityRecord curTop = null;
    L20:
        if (curTop == null) goto L22;
        Task topTask = curTop.getTask();
    L24:
        if (topTask != intentTask2) goto L32;
        if (focusRootTask != null) goto L27;
    L28:
        if (focusRootTask == null) goto L31;
        if (focusRootTask != origRootTask) goto L32;
    L31:
        boolean differentTopTask = false;
    L33:
        boolean differentTopTask2 = differentTopTask;
    L35:
        if (differentTopTask2 == true) goto L37;
    L70:
        if (differentTopTask2 == false) goto L73;
        logPIOnlyCreatorAllowsBAL();
    L73:
        if (this.mStartActivity.mLaunchCookie == null) goto L78;
        intentActivity.mLaunchCookie = this.mStartActivity.mLaunchCookie;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L78;
        String protoLogParam0 = String.valueOf(intentActivity.mLaunchCookie);
        String protoLogParam1 = String.valueOf(intentActivity.packageName);
        long protoLogParam2 = System.identityHashCode(intentActivity);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 4862920467861746215L, 16, new Object[]{protoLogParam0, protoLogParam1, Long.valueOf(protoLogParam2)});
    L78:
        if (this.mStartActivity.mPendingRemoteAnimation == null) goto L80;
        intentActivity.mPendingRemoteAnimation = this.mStartActivity.mPendingRemoteAnimation;
    L80:
        this.mTargetRootTask = intentActivity.getRootTask();
        this.mSupervisor.handleNonResizableTaskIfNeeded(intentTask2, 0, this.mRootWindowContainer.getDefaultTaskDisplayArea(), this.mTargetRootTask);
        return;
    L37:
        if (avoidMoveToFront() == true) goto L70;
        this.mStartActivity.intent.addFlags(4194304);
        if (this.mLaunchTaskBehind == false) goto L44;
        if (this.mSourceRecord == null) goto L44;
        intentActivity.setTaskToAffiliateWith(this.mSourceRecord.getTask());
    L44:
        if (intentActivity.isDescendantOf(this.mTargetRootTask) == false) goto L67;
        if (this.mTargetRootTask != intentTask2) goto L48;
    L50:
        Task intentTask3 = intentTask2;
    L52:
        if (intentActivity.isVisibleRequested() == true) goto L54;
    L60:
        boolean wasTopOfVisibleRootTask = false;
    L61:
        this.mTargetRootTask.moveTaskToFront(intentTask3, this.mNoAnimation, this.mOptions, this.mStartActivity.appTimeTracker, true, "bringingFoundTaskToFront");
        if (wasTopOfVisibleRootTask == true) goto L64;
        boolean r5 = true;
    L65:
        this.mMovedToFront = r5;
        intentTask2 = intentTask3;
    L69:
        this.mOptions = null;
        goto L70
    L64:
        r5 = false;
        goto L65
    L54:
        if (intentActivity.inMultiWindowMode() == false) goto L60;
        if (intentActivity != this.mTargetRootTask.topRunningActivity()) goto L60;
        if (intentActivity.mTransitionController.isTransientHide(this.mTargetRootTask) == true) goto L60;
        wasTopOfVisibleRootTask = true;
        goto L61
    L48:
        if (this.mTargetRootTask == intentTask2.getParent().asTask()) goto L50;
        intentTask2.getParent().positionChildAt(Integer.MAX_VALUE, intentTask2, false);
        intentTask3 = intentTask2.getParent().asTaskFragment().getTask();
        goto L52
    L67:
        if (intentActivity.getWindowingMode() == 2) goto L69;
        intentTask2.reparent(this.mTargetRootTask, true, 0, true, true, "reparentToTargetRootTask");
        this.mMovedToFront = true;
        goto L69
    L27:
        if (topTask == focusRootTask.getTopMostTask()) goto L28;
    L32:
        differentTopTask = true;
        goto L33
    L22:
        topTask = null;
        goto L24
    L19:
        curTop = focusRootTask.topRunningNonDelayedActivityLocked(this.mNotTop);
        goto L20
    L34:
        differentTopTask2 = true;
        goto L35
    L9:
        if (this.mSourceRecord != null) goto L11;
    L13:
        this.mTargetRootTask = getOrCreateRootTask(this.mStartActivity, this.mLaunchFlags, intentTask, this.mOptions);
        goto L14
    L11:
        if (this.mSourceRecord.mLaunchRootTask == null) goto L13;
        this.mTargetRootTask = Task.fromWindowContainerToken(this.mSourceRecord.mLaunchRootTask);
        goto L14
    L5:
        r4 = null;
        goto L6
    }

    private void resumeTargetRootTaskIfNeeded() {
        if (this.mDoResume == false) goto L12;
        ActivityRecord next = this.mTargetRootTask.topRunningActivity(true);
        if (next == null) goto L8;
        next.setCurrentLaunchCanTurnScreenOn(true);
    L8:
        if (this.mTargetRootTask.isFocusable() == false) goto L10;
        this.mRootWindowContainer.resumeFocusedTasksTopActivities(this.mTargetRootTask, null, this.mOptions, this.mTransientLaunch);
    L13:
        this.mRootWindowContainer.updateUserRootTask(this.mStartActivity.mUserId, this.mTargetRootTask);
        return;
    L10:
        this.mRootWindowContainer.ensureActivitiesVisible();
        goto L13
    L12:
        ActivityOptions.abort(this.mOptions);
        goto L13
    }

    private void setNewTask(Task taskToAffiliate) {
        if (this.mLaunchTaskBehind == false) goto L5;
    L7:
        boolean r2 = false;
    L8:
        boolean toTop = r2;
        Task task = this.mTargetRootTask.reuseOrCreateTask(this.mStartActivity.info, this.mIntent, this.mVoiceSession, this.mVoiceInteractor, toTop, this.mStartActivity, this.mSourceRecord, this.mOptions);
        task.mTransitionController.collectExistenceChange(task);
        addOrReparentStartingActivity(task, "setTaskFromReuseOrCreateNewTask");
        if (Constants.ENABLE_GAME_ASSIST == false) goto L23;
        if (this.mStartActivity == null) goto L23;
        if (this.mStartActivity.mActivityComponent == null) goto L23;
        if (this.mStartActivity.getTask() == null) goto L23;
        GameActivityStateEventDispatcher r11 = GameActivityStateEventDispatcher.getInstance();
        int r12 = this.mStartActivity.getDisplayId();
        ActivityInfo r13 = this.mStartActivity.info;
        int r14 = this.mStartActivity.getRootTaskId();
        if (this.mStartActivity.app == null) goto L20;
        int r5 = this.mStartActivity.app.getPid();
    L21:
        r11.notifyGameFullActivityFirstCreate(r12, r13, r14, r5, this.mStartActivity.getWindowingMode(), this.mStartActivity.getActivityType(), this.mStartActivity, this.mStartActivity.mActivityComponent, this.mStartActivity.mUserId, this.mStartActivity.getTask().getTaskLabelHashcode());
        goto L23
    L20:
        r5 = 9999;
    L23:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[1] == false) goto L26;
        String protoLogParam0 = String.valueOf(this.mStartActivity);
        String protoLogParam1 = String.valueOf(this.mStartActivity.getTask());
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_TASKS, -2190454940975874759L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L26:
        if (this.mStartActivity.mActivityComponent.toString().contains("com.android.provision/.DefaultActivity") == false) goto L28;
        Slog.d("ActivityTaskManager", "setNewTask: " + this.mStartActivity.mActivityComponent + " mTargetRootTask: " + this.mTargetRootTask + " task: " + task + " taskToAffiliate: " + taskToAffiliate);
    L28:
        if (taskToAffiliate == null) goto L31;
        this.mStartActivity.setTaskToAffiliateWith(taskToAffiliate);
        return;
    L31:
        return;
    L5:
        if (avoidMoveToFront() == true) goto L7;
        r2 = true;
        goto L8
    }

    private void deliverNewIntent(ActivityRecord activity, NeededUriGrants intentGrants) {
        if (this.mIntentDelivered == false) goto L5;
        return;
    L5:
        activity.logStartActivity(EventLogTags.WM_NEW_INTENT, activity.getTask());
        activity.deliverNewIntentLocked(this.mCallingUid, this.mStartActivity.intent, intentGrants, this.mStartActivity.launchedFromPackage, this.mStartActivity.mShareIdentity, this.mStartActivity.mUserId, UserHandle.getAppId(this.mStartActivity.info.applicationInfo.uid));
        this.mIntentDelivered = true;
    }

    private void addOrReparentStartingActivity(Task task, String reason) {
        this.mStartActivity.acquireActivityBoost();
        TaskFragment newParent = task;
        if (this.mInTaskFragment == null) goto L9;
        int embeddingCheckResult = canEmbedActivity(this.mInTaskFragment, this.mStartActivity, task);
        if (embeddingCheckResult != 0) goto L7;
        newParent = this.mInTaskFragment;
        ActivityRecord r2 = this.mStartActivity;
        r2.mRequestedLaunchingTaskFragmentToken = this.mInTaskFragment.getFragmentToken();
    L19:
        if (this.mStartActivity.getTaskFragment() != null) goto L21;
    L24:
        newParent.addChild(this.mStartActivity, Integer.MAX_VALUE);
        return;
    L21:
        if (this.mStartActivity.getTaskFragment() == newParent) goto L24;
        this.mStartActivity.reparent(newParent, newParent.getChildCount(), reason);
        return;
    L7:
        sendCanNotEmbedActivityError(this.mInTaskFragment, embeddingCheckResult);
        goto L19
    L9:
        TaskFragment candidateTf = this.mAddingToTaskFragment;
        if (candidateTf != null) goto L12;
        candidateTf = findCandidateTaskFragment(task);
    L12:
        if (candidateTf == null) goto L19;
        if (candidateTf.isEmbedded() == false) goto L19;
        if (canEmbedActivity(candidateTf, this.mStartActivity, task) != 0) goto L19;
        newParent = candidateTf;
        goto L19
    }

    private TaskFragment findCandidateTaskFragment(Task task) {
        if (this.mSourceRecord == null) goto L5;
        TaskFragment sourceTaskFragment = this.mSourceRecord.getTaskFragment();
    L6:
        int i = task.getChildCount() - 1;
    L7:
        if (i < 0) goto L34;
        WindowContainer<?> wc = task.getChildAt(i);
        ActivityRecord activity = wc.asActivityRecord();
        if (activity != null) goto L11;
        TaskFragment taskFragment = wc.asTaskFragment();
        if (taskFragment == null) goto L32;
        if (taskFragment.isRemovalRequested() == true) goto L32;
        if (taskFragment.getActivity(new ActivityStarter$$ExternalSyntheticLambda0()) == null) goto L32;
        if (taskFragment.isIsolatedNav() == true) goto L24;
        if (sourceTaskFragment == null) goto L29;
        if (sourceTaskFragment != taskFragment) goto L29;
        return taskFragment;
    L29:
        if (taskFragment.isPinned() == true) goto L32;
        return taskFragment;
    L24:
        return null;
    L32:
        i = i - 1;
        goto L7
    L11:
        if (activity.finishing == true) goto L32;
        return null;
    L34:
        return null;
    L5:
        sourceTaskFragment = null;
        goto L6
    }

    private void sendCanNotEmbedActivityError(TaskFragment taskFragment, int result) {
        boolean fatalError = true;
        switch(result) {
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        String errMsg = "Unhandled embed result:" + result;
    L9:
        if (taskFragment.isOrganized() == false) goto L15;
        WindowOrganizerController r3 = this.mService.mWindowOrganizerController;
        ITaskFragmentOrganizer r4 = taskFragment.getTaskFragmentOrganizer();
        IBinder r5 = this.mRequest.errorCallbackToken;
        if (fatalError == false) goto L13;
        Throwable r8 = new SecurityException(errMsg);
    L14:
        r3.sendTaskFragmentOperationFailure(r4, r5, taskFragment, 2, r8);
        return;
    L13:
        r8 = new OperationCanceledException(errMsg);
        goto L14
    L15:
        Slog.w("ActivityTaskManager", errMsg);
        return;
    L5:
        errMsg = "Cannot embed " + this.mStartActivity + " that launched on another task,mLaunchMode=" + ActivityInfo.launchModeToString(this.mLaunchMode) + ",mLaunchFlag=" + Integer.toHexString(this.mLaunchFlags);
        fatalError = false;
        goto L9
    L6:
        errMsg = "Cannot embed " + this.mStartActivity + ". TaskFragment's bounds:" + taskFragment.getBounds() + ", minimum dimensions:" + this.mStartActivity.getMinDimensions();
        goto L9
    L7:
        errMsg = "The app:" + this.mCallingUid + "is not trusted to " + this.mStartActivity;
        goto L9
    }

    private int adjustLaunchFlagsToDocumentMode(ActivityRecord r, boolean launchSingleInstance, boolean launchSingleTask, int launchFlags) {
        if ((launchFlags & 524288) == 0) goto L8;
        if (launchSingleInstance == true) goto L6;
        if (launchSingleTask == false) goto L8;
    L6:
        Slog.i("ActivityTaskManager", "Ignoring FLAG_ACTIVITY_NEW_DOCUMENT, launchMode is \"singleInstance\" or \"singleTask\"");
        return launchFlags & (-134742017);
    L8:
        switch(r.info.documentLaunchMode) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L11;
            default: goto L25;
        };
    L25:
        return launchFlags;
    L11:
        if (this.mLaunchMode != 4) goto L22;
        if ((524288 & launchFlags) != 0) goto L21;
        return launchFlags;
    L21:
        return launchFlags & (-134742017);
    L22:
        return launchFlags & (-134742017);
    L23:
        return launchFlags | 524288;
    L24:
        return launchFlags | 524288;
    }

    private Task getOrCreateRootTask(ActivityRecord r, int launchFlags, Task task, ActivityOptions aOptions) {
        if (aOptions == null) goto L6;
        if (aOptions.getAvoidMoveToFront() == false) goto L6;
    L8:
        boolean r0 = false;
    L9:
        boolean onTop = r0;
        if (this.mSourceRecord == null) goto L13;
        Task r1 = this.mSourceRecord.getTask();
    L12:
        Task sourceTask = r1;
        return this.mRootWindowContainer.getOrCreateRootTask(r, aOptions, task, sourceTask, onTop, this.mLaunchParams, launchFlags);
    L13:
        r1 = null;
    L6:
        if (this.mLaunchTaskBehind == true) goto L8;
        r0 = true;
        goto L9
    }

    private boolean isLaunchModeOneOf(int mode1, int mode2) {
        if (mode1 != this.mLaunchMode) goto L5;
    L8:
        return true;
    L5:
        if (mode2 == this.mLaunchMode) goto L8;
        return false;
    }

    private boolean isLaunchModeOneOf(int mode1, int mode2, int mode3) {
        if (mode1 != this.mLaunchMode) goto L5;
    L10:
        return true;
    L5:
        if (mode2 == this.mLaunchMode) goto L10;
        if (mode3 == this.mLaunchMode) goto L10;
        return false;
    }

    static boolean isDocumentLaunchesIntoExisting(int flags) {
        if ((524288 & flags) != 0) goto L5;
    L7:
        return false;
    L5:
        if ((134217728 & flags) != 0) goto L7;
        return true;
    }

    ActivityStarter setIntent(Intent intent) {
        this.mRequest.intent = intent;
        return this;
    }

    Intent getIntent() {
        return this.mRequest.intent;
    }

    ActivityStarter setIntentGrants(NeededUriGrants intentGrants) {
        this.mRequest.intentGrants = intentGrants;
        return this;
    }

    ActivityStarter setReason(String reason) {
        this.mRequest.reason = reason;
        return this;
    }

    ActivityStarter setCaller(IApplicationThread caller) {
        this.mRequest.caller = caller;
        return this;
    }

    ActivityStarter setResolvedType(String type) {
        this.mRequest.resolvedType = type;
        return this;
    }

    ActivityStarter setActivityInfo(ActivityInfo info) {
        this.mRequest.activityInfo = info;
        return this;
    }

    ActivityStarter setResolveInfo(ResolveInfo info) {
        this.mRequest.resolveInfo = info;
        return this;
    }

    ActivityStarter setVoiceSession(IVoiceInteractionSession voiceSession) {
        this.mRequest.voiceSession = voiceSession;
        return this;
    }

    ActivityStarter setVoiceInteractor(IVoiceInteractor voiceInteractor) {
        this.mRequest.voiceInteractor = voiceInteractor;
        return this;
    }

    ActivityStarter setResultTo(IBinder resultTo) {
        this.mRequest.resultTo = resultTo;
        return this;
    }

    ActivityStarter setResultWho(String resultWho) {
        this.mRequest.resultWho = resultWho;
        return this;
    }

    ActivityStarter setRequestCode(int requestCode) {
        this.mRequest.requestCode = requestCode;
        return this;
    }

    ActivityStarter setCallingPid(int pid) {
        this.mRequest.callingPid = pid;
        return this;
    }

    ActivityStarter setCallingUid(int uid) {
        this.mRequest.callingUid = uid;
        return this;
    }

    ActivityStarter setCallingPackage(String callingPackage) {
        this.mRequest.callingPackage = callingPackage;
        return this;
    }

    ActivityStarter setCallingFeatureId(String callingFeatureId) {
        this.mRequest.callingFeatureId = callingFeatureId;
        return this;
    }

    ActivityStarter setIntentCreatorUid(int uid) {
        this.mRequest.intentCreatorUid = uid;
        return this;
    }

    ActivityStarter setIntentCreatorPackage(String intentCreatorPackage) {
        this.mRequest.intentCreatorPackage = intentCreatorPackage;
        return this;
    }

    ActivityStarter setRealCallingPid(int pid) {
        this.mRequest.realCallingPid = pid;
        return this;
    }

    ActivityStarter setRealCallingUid(int uid) {
        this.mRequest.realCallingUid = uid;
        return this;
    }

    ActivityStarter setStartFlags(int startFlags) {
        this.mRequest.startFlags = startFlags;
        return this;
    }

    ActivityStarter setActivityOptions(SafeActivityOptions options) {
        this.mRequest.activityOptions = options;
        return this;
    }

    ActivityStarter setActivityOptions(Bundle bOptions, int callingPid, int callingUid) {
        return setActivityOptions(SafeActivityOptions.fromBundle(bOptions, callingPid, callingUid));
    }

    ActivityStarter setIgnoreTargetSecurity(boolean ignoreTargetSecurity) {
        this.mRequest.ignoreTargetSecurity = ignoreTargetSecurity;
        return this;
    }

    ActivityStarter setFilterCallingUid(int filterCallingUid) {
        this.mRequest.filterCallingUid = filterCallingUid;
        return this;
    }

    ActivityStarter setComponentSpecified(boolean componentSpecified) {
        this.mRequest.componentSpecified = componentSpecified;
        return this;
    }

    ActivityStarter setOutActivity(ActivityRecord[] outActivity) {
        this.mRequest.outActivity = outActivity;
        return this;
    }

    ActivityStarter setInTask(Task inTask) {
        this.mRequest.inTask = inTask;
        return this;
    }

    ActivityStarter setInTaskFragment(TaskFragment taskFragment) {
        this.mRequest.inTaskFragment = taskFragment;
        return this;
    }

    ActivityStarter setWaitResult(WaitResult result) {
        this.mRequest.waitResult = result;
        return this;
    }

    ActivityStarter setProfilerInfo(ProfilerInfo info) {
        this.mRequest.profilerInfo = info;
        return this;
    }

    ActivityStarter setGlobalConfiguration(Configuration config) {
        this.mRequest.globalConfig = config;
        return this;
    }

    ActivityStarter setUserId(int userId) {
        this.mRequest.userId = userId;
        return this;
    }

    ActivityStarter setAllowPendingRemoteAnimationRegistryLookup(boolean allowLookup) {
        this.mRequest.allowPendingRemoteAnimationRegistryLookup = allowLookup;
        return this;
    }

    ActivityStarter setOriginatingPendingIntent(PendingIntentRecord originatingPendingIntent) {
        this.mRequest.originatingPendingIntent = originatingPendingIntent;
        return this;
    }

    ActivityStarter setAllowBalExemptionForSystemProcess(boolean allowBalExemptionForSystemProcess) {
        this.mRequest.allowBalExemptionForSystemProcess = allowBalExemptionForSystemProcess;
        return this;
    }

    ActivityStarter setFreezeScreen(boolean freezeScreen) {
        this.mRequest.freezeScreen = freezeScreen;
        return this;
    }

    ActivityStarter setErrorCallbackToken(IBinder errorCallbackToken) {
        this.mRequest.errorCallbackToken = errorCallbackToken;
        return this;
    }

    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("mCurrentUser=");
        pw.println(this.mRootWindowContainer.mCurrentUser);
        pw.print(prefix);
        pw.print("mLastStartReason=");
        pw.println(this.mLastStartReason);
        pw.print(prefix);
        pw.print("mLastStartActivityTimeMs=");
        pw.println(DateFormat.getDateTimeInstance().format(new Date(this.mLastStartActivityTimeMs)));
        pw.print(prefix);
        pw.print("mLastStartActivityResult=");
        pw.println(this.mLastStartActivityResult);
        if (this.mLastStartActivityRecord == null) goto L6;
        pw.print(prefix);
        pw.println("mLastStartActivityRecord:");
        this.mLastStartActivityRecord.dump(pw, prefix + "  ", true);
    L6:
        if (this.mStartActivity == null) goto L9;
        pw.print(prefix);
        pw.println("mStartActivity:");
        this.mStartActivity.dump(pw, prefix + "  ", true);
    L9:
        if (this.mIntent == null) goto L12;
        pw.print(prefix);
        pw.print("mIntent=");
        pw.println(this.mIntent);
    L12:
        if (this.mOptions == null) goto L14;
        pw.print(prefix);
        pw.print("mOptions=");
        pw.println(this.mOptions);
    L14:
        pw.print(prefix);
        pw.print("mLaunchMode=");
        pw.print(ActivityInfo.launchModeToString(this.mLaunchMode));
        pw.print(prefix);
        pw.print("mLaunchFlags=0x");
        pw.print(Integer.toHexString(this.mLaunchFlags));
        pw.print(" mDoResume=");
        pw.print(this.mDoResume);
        pw.print(" mAddingToTask=");
        pw.print(this.mAddingToTask);
        pw.print(" mInTaskFragment=");
        pw.println(this.mInTaskFragment);
    }

    static void logAndThrowExceptionForIntentRedirect(Context context, int errorCode, Intent intent, int intentCreatorUid, String intentCreatorPackage, int callingUid, String callingPackage, SecurityException originalException) {
        String msg = getIntentRedirectPreventedLogMessage(errorCode, intent, intentCreatorUid, intentCreatorPackage, callingUid, callingPackage);
        Slog.wtf("ActivityTaskManager", msg);
        FrameworkStatsLog.write(FrameworkStatsLog.INTENT_REDIRECT_BLOCKED, intentCreatorUid, callingUid, errorCode);
        if (CompatChanges.isChangeEnabled(ENABLE_PREVENT_INTENT_REDIRECT_TAKE_ACTION, callingUid) == true) goto L6;
        return;
    L6:
        throw new SecurityException(msg, originalException);
    }

    private static /* synthetic */ void lambda$logAndThrowExceptionForIntentRedirect$1(Context context) {
        Toast.makeText(context, "Activity launch blocked. go/report-bug-intentRedir to report a bug", 1).show();
    }

    private static boolean logAndAbortForIntentRedirect(Context context, int errorCode, Intent intent, int intentCreatorUid, String intentCreatorPackage, int callingUid, String callingPackage) {
        String msg = getIntentRedirectPreventedLogMessage(errorCode, intent, intentCreatorUid, intentCreatorPackage, callingUid, callingPackage);
        Slog.wtf("ActivityTaskManager", msg);
        FrameworkStatsLog.write(FrameworkStatsLog.INTENT_REDIRECT_BLOCKED, intentCreatorUid, callingUid, errorCode);
        if (CompatChanges.isChangeEnabled(ENABLE_PREVENT_INTENT_REDIRECT_TAKE_ACTION, callingUid) == false) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ void lambda$logAndAbortForIntentRedirect$2(Context context) {
        Toast.makeText(context, "Activity launch blocked. go/report-bug-intentRedir to report a bug", 1).show();
    }

    private static String getIntentRedirectPreventedLogMessage(int errorCode, Intent intent, int intentCreatorUid, String intentCreatorPackage, int callingUid, String callingPackage) {
        String message = getIntentRedirectErrorMessageFromCode(errorCode);
        return "[IntentRedirect Hardening] " + message + " intentCreatorUid: " + intentCreatorUid + "; intentCreatorPackage: " + intentCreatorPackage + "; callingUid: " + callingUid + "; callingPackage: " + callingPackage + "; intent: " + intent;
    }

    private static String getIntentRedirectErrorMessageFromCode(int errorCode) {
        switch(errorCode) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L4;
            default: goto L11;
        };
    L4:
        return "INTENT_REDIRECT_ABORT_PERMISSION_POLICY_START_ACTIVITY (Creator PermissionPolicyService.checkStartActivity, abort)";
    L5:
        return "INTENT_REDIRECT_ABORT_INTENT_FIREWALL_START_ACTIVITY (Creator IntentFirewall.checkStartActivity, abort)";
    L6:
        return "INTENT_REDIRECT_ABORT_START_ANY_ACTIVITY_PERMISSION (Creator checkStartAnyActivityPermission, abort)";
    L7:
        return "INTENT_REDIRECT_ABORT_START_ANY_ACTIVITY_PERMISSION (Creator checkStartAnyActivityPermission, throw exception)";
    L8:
        return "INTENT_REDIRECT_EXCEPTION_GRANT_URI_PERMISSION (Creator URI permission grant throw exception.)";
    L9:
        return "INTENT_REDIRECT_EXCEPTION_MISSING_OR_INVALID_TOKEN (Unparceled intent does not have a creator token set, throw exception.)";
    L11:
        return "Unknown error code: " + errorCode;
    }

    public IExtActivityStarter getExt() {
        return this.mExt;
    }

    public IObricActivityStarter getObricExt() {
        return this.mObricExt;
    }
}
