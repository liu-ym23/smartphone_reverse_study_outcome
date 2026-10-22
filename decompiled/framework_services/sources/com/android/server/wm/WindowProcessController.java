package com.android.server.wm;

import android.app.ActivityThread;
import android.app.BackgroundStartPrivileges;
import android.app.IApplicationThread;
import android.app.ProfilerInfo;
import android.app.servertransaction.ClientTransactionItem;
import android.app.servertransaction.ConfigurationChangeItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.Build;
import android.os.InputConstants;
import android.os.LocaleList;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.pico.utils.ExtImplFactory;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.Preconditions;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.Watchdog;
import com.android.server.am.ProcessList;
import com.android.server.grammaticalinflection.GrammaticalInflectionManagerInternal;
import com.android.server.pm.PackageManagerService;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class WindowProcessController extends ConfigurationContainer<ConfigurationContainer> implements ConfigurationContainerListener {
    public static final int ACTIVITY_STATE_FLAG_HAS_ACTIVITY_IN_VISIBLE_TASK = 4194304;
    public static final int ACTIVITY_STATE_FLAG_HAS_RESUMED = 2097152;
    public static final int ACTIVITY_STATE_FLAG_IS_PAUSING_OR_PAUSED = 131072;
    public static final int ACTIVITY_STATE_FLAG_IS_STOPPING = 262144;
    public static final int ACTIVITY_STATE_FLAG_IS_STOPPING_FINISHING = 524288;
    public static final int ACTIVITY_STATE_FLAG_IS_VISIBLE = 65536;
    public static final int ACTIVITY_STATE_FLAG_IS_WINDOW_VISIBLE = 1048576;
    public static final int ACTIVITY_STATE_FLAG_MASK_MIN_TASK_LAYER = 65535;
    public static final int ACTIVITY_STATE_FLAG_PERCEPTIBLE_FREEFORM = 16777216;
    public static final int ACTIVITY_STATE_FLAG_RESUMED_SPLIT_SCREEN = 8388608;
    public static final int ACTIVITY_STATE_FLAG_VISIBLE_MULTI_WINDOW_MODE = 33554432;
    static final int ANIMATING_REASON_REMOTE_ANIMATION = 1;
    static final int ANIMATING_REASON_WAKEFULNESS_CHANGE = 2;
    private static final int CACHED_CONFIG_PROC_STATE = 16;
    private static final int MAX_NUM_PERCEPTIBLE_FREEFORM = 0;
    private static final int MAX_RAPID_ACTIVITY_LAUNCH_COUNT = 200;
    private static final int PERCEPTIBLE_FREEFORM_VISIBLE_RATIO = 90;
    private static final long RAPID_ACTIVITY_LAUNCH_MS = 500;
    private static final int REMOTE_ACTIVITY_FLAG_EMBEDDED_ACTIVITY = 2;
    private static final int REMOTE_ACTIVITY_FLAG_HOST_ACTIVITY = 1;
    private static final long RESET_RAPID_ACTIVITY_LAUNCH_MS = 1500;
    public static final int STOPPED_STATE_FIRST_LAUNCH = 1;
    public static final int STOPPED_STATE_FORCE_STOPPED = 2;
    public static final int STOPPED_STATE_NOT_STOPPED = 0;
    private static final String TAG = "ActivityTaskManager";
    private static final String TAG_CONFIGURATION = "ActivityTaskManager";
    private static final String TAG_RELEASE = "ActivityTaskManager";
    protected final ArrayList<ActivityRecord> mActivities;
    private volatile int mActivityStateFlags;
    private int mAnimatingReasons;
    protected final ActivityTaskManagerService mAtm;
    private final BackgroundLaunchProcessController mBgLaunchController;
    private ActivityRecord mConfigActivityRecord;
    private volatile boolean mCrashing;
    private volatile int mCurAdj;
    private volatile int mCurProcState;
    private volatile int mCurSchedGroup;
    private volatile boolean mDebugging;
    private DisplayArea mDisplayArea;
    private IExtWindowProcessController mExt;
    private volatile long mFgInteractionTime;
    private volatile boolean mHasActivities;
    private volatile boolean mHasCachedConfiguration;
    private volatile boolean mHasClientActivities;
    boolean mHasEverAttached;
    private volatile boolean mHasForegroundServices;
    private volatile boolean mHasImeService;
    private volatile boolean mHasOverlayUi;
    private boolean mHasPendingConfigurationChange;
    private volatile boolean mHasRecentTasks;
    private volatile boolean mHasTopUi;
    private ArrayList<ActivityRecord> mInactiveActivities;
    public volatile ApplicationInfo mInfo;
    private volatile int mInstrumentationSourceUid;
    private volatile boolean mInstrumenting;
    private volatile boolean mInstrumentingWithBackgroundActivityStartPrivileges;
    private volatile long mInteractionEventTime;
    private volatile boolean mIsActivityConfigOverrideAllowed;
    private volatile long mLastActivityFinishTime;
    private volatile long mLastActivityLaunchTime;
    private final Configuration mLastReportedConfiguration;
    private int mLastTopActivityDeviceId;
    protected final WindowProcessListener mListener;
    final String mName;
    private volatile boolean mNotResponding;
    public final Object mOwner;
    private int mPauseConfigurationDispatchCount;
    private volatile boolean mPendingUiClean;
    private volatile boolean mPerceptible;
    private volatile long mPerceptibleTaskStoppedTimeMillis;
    private volatile boolean mPersistent;
    protected volatile int mPid;
    final ArrayList<String> mPkgList;
    private ActivityRecord mPreQTopResumedActivity;
    private int mRapidActivityLaunchCount;
    private final ArrayList<Task> mRecentTasks;
    private ArrayMap<ActivityRecord, int[]> mRemoteActivities;
    private volatile int mRepProcState;
    private volatile String mRequiredAbi;
    private volatile int mStoppedState;
    private IApplicationThread mThread;
    final int mUid;
    private final boolean mUseFifoUiScheduling;
    final int mUserId;
    private volatile boolean mUsingWrapper;
    int mVrThreadTid;
    private volatile boolean mWasStoppedLogged;
    private volatile long mWhenUnimportant;
    Session mWindowSession;

    @Retention(RetentionPolicy.SOURCE)
    @interface AnimatingReason {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StoppedState {
    }

    public static /* synthetic */ void $r8$lambda$7DkZeFJ_HKGIlBuGcyQ0rMLS1wc(WindowProcessController r0) {
        r0.lambda$onTopProcChanged$3();
    }

    public static /* synthetic */ boolean $r8$lambda$F0Yc8f_QKZqEu2LPODjK6PGu3oo(ActivityRecord r0, ActivityRecord r1) {
        return lambda$updateTopResumingActivityInProcessIfNeeded$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$XqpEI_-p3OJIDEMgWmLxQ6oMfMk, reason: not valid java name */
    public static /* synthetic */ void m10476$r8$lambda$XqpEI_p3OJIDEMgWmLxQ6oMfMk(WindowProcessController r0, boolean r1) {
        r0.lambda$setAnimating$4(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$YiYJOZGNKWfGaS5LfLt6m3-o_YU, reason: not valid java name */
    public static /* synthetic */ void m10477$r8$lambda$YiYJOZGNKWfGaS5LfLt6m3o_YU(WindowProcessController r0, Task r1) {
        r0.lambda$updateRapidActivityLaunch$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$oUh--pFAcAXnuJ6Yyswq4-FmBfo, reason: not valid java name */
    public static /* synthetic */ void m10478$r8$lambda$oUhpFAcAXnuJ6Yyswq4FmBfo(WindowProcessController r0) {
        r0.lambda$onServiceStarted$2();
    }

    static {
        MAX_NUM_PERCEPTIBLE_FREEFORM = SystemProperties.getInt("persist.wm.max_num_perceptible_freeform", 1);
    }

    public WindowProcessController(final ActivityTaskManagerService atm, ApplicationInfo info, String name, int uid, int userId, Object owner, WindowProcessListener listener) {
        this.mPkgList = new ArrayList(1);
        this.mCurProcState = 20;
        this.mRepProcState = 20;
        this.mCurAdj = ProcessList.INVALID_ADJ;
        this.mInstrumentationSourceUid = -1;
        this.mActivities = new ArrayList();
        this.mRecentTasks = new ArrayList();
        this.mPreQTopResumedActivity = null;
        this.mLastReportedConfiguration = new Configuration();
        this.mLastTopActivityDeviceId = 0;
        this.mIsActivityConfigOverrideAllowed = true;
        this.mActivityStateFlags = 65535;
        this.mPerceptibleTaskStoppedTimeMillis = Long.MIN_VALUE;
        this.mExt = (IExtWindowProcessController) ExtImplFactory.getImpl(IExtWindowProcessController.class, new Object[]{this});
        this.mInfo = info;
        this.mName = name;
        this.mUid = uid;
        this.mUserId = userId;
        this.mOwner = owner;
        this.mListener = listener;
        this.mAtm = atm;
        getWPCSmtEx().init(atm, listener);
        atm.getClass();
        this.mBgLaunchController = new BackgroundLaunchProcessController(new WindowProcessController$$ExternalSyntheticLambda13(atm), atm.getBackgroundActivityStartCallback());
        boolean isSysUiPackage = info.packageName.equals(this.mAtm.getSysUiServiceComponentLocked().getPackageName());
        if (isSysUiPackage == false) goto L5;
    L6:
        this.mIsActivityConfigOverrideAllowed = false;
    L7:
        this.mUseFifoUiScheduling = false;
        return;
    L5:
        if (UserHandle.getAppId(this.mUid) != 1000) goto L7;
        goto L6
    }

    public void setPid(int pid) {
        this.mPid = pid;
        getWPCSmtEx().setOriginPid(pid);
    }

    public int getPid() {
        return this.mPid;
    }

    public void setThread(IApplicationThread thread) {
        Object r0 = this.mAtm.mGlobalLockWithoutBoost;
        monitor-enter(r0);
        this.mThread = thread;     // Catch: Throwable -> L7
        if (thread == null) goto L9;
        setLastReportedConfiguration(getConfiguration());     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mAtm.mVisibleActivityProcessTracker.removeProcess(this);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    IApplicationThread getThread() {
        return this.mThread;
    }

    boolean hasThread() {
        if (this.mThread == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void setCurrentSchedulingGroup(int curSchedGroup) {
        this.mCurSchedGroup = curSchedGroup;
    }

    int getCurrentSchedulingGroup() {
        return this.mCurSchedGroup;
    }

    public void setCurrentProcState(int curProcState) {
        this.mCurProcState = curProcState;
    }

    int getCurrentProcState() {
        return this.mCurProcState;
    }

    public void setCurrentAdj(int curAdj) {
        this.mCurAdj = curAdj;
    }

    int getCurrentAdj() {
        return this.mCurAdj;
    }

    public void setReportedProcState(int repProcState) {
        int prevProcState = this.mRepProcState;
        this.mRepProcState = repProcState;
        IApplicationThread thread = this.mThread;
        if (prevProcState < 16) goto L19;
        if (repProcState >= 16) goto L24;
        if (thread != null) goto L7;
        return;
    L7:
        if (this.mHasCachedConfiguration == false) goto L26;
        Configuration r2 = this.mLastReportedConfiguration;
        monitor-enter(r2);
        onConfigurationChangePreScheduled(this.mLastReportedConfiguration);     // Catch: Throwable -> L16
        ClientTransactionItem r3 = new ConfigurationChangeItem(this.mLastReportedConfiguration, this.mLastTopActivityDeviceId);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        this.mAtm.getLifecycleManager().scheduleTransactionItemNow(thread, r3);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Slog.e("ActivityTaskManager", "Failed to schedule ConfigurationChangeItem=" + r3 + " owner=" + this.mOwner, e);
        return;
    L16:
        th = move-exception;
        throw th;
    L26:
        return;
    L24:
        return;
    }

    int getReportedProcState() {
        return this.mRepProcState;
    }

    public void setCrashing(boolean crashing) {
        this.mCrashing = crashing;
    }

    boolean handleAppCrash() {
        boolean hasVisibleActivity = false;
        ArrayList<ActivityRecord> activities = new ArrayList(this.mActivities);
        int i = activities.size() - 1;
    L3:
        if (i < 0) goto L9;
        ActivityRecord r = activities.get(i);
        Slog.w("ActivityTaskManager", "  Force finishing activity " + r.mActivityComponent.flattenToShortString());
        r.detachFromProcess();
        if (r.isVisibleRequested() == false) goto L7;
        hasVisibleActivity = true;
        Task finishingTask = r.getTask();
        r.mDisplayContent.requestTransitionAndLegacyPrepare(2, 16, finishingTask);
    L7:
        r.destroyIfPossible("handleAppCrashed");
        i = i - 1;
        goto L3
    L9:
        return hasVisibleActivity;
    }

    boolean isCrashing() {
        return this.mCrashing;
    }

    public void setNotResponding(boolean notResponding) {
        this.mNotResponding = notResponding;
    }

    boolean isNotResponding() {
        return this.mNotResponding;
    }

    public void setPersistent(boolean persistent) {
        this.mPersistent = persistent;
    }

    boolean isPersistent() {
        return this.mPersistent;
    }

    public void setHasForegroundServices(boolean hasForegroundServices) {
        this.mHasForegroundServices = hasForegroundServices;
    }

    boolean hasForegroundServices() {
        return this.mHasForegroundServices;
    }

    boolean hasForegroundActivities() {
        if (this.mAtm.mTopApp != this) goto L5;
    L8:
        return true;
    L5:
        if ((this.mActivityStateFlags & 458752) != 0) goto L8;
        return false;
    }

    public void setHasClientActivities(boolean hasClientActivities) {
        this.mHasClientActivities = hasClientActivities;
    }

    boolean hasClientActivities() {
        return this.mHasClientActivities;
    }

    public void setHasTopUi(boolean hasTopUi) {
        this.mHasTopUi = hasTopUi;
    }

    boolean hasTopUi() {
        return this.mHasTopUi;
    }

    public void setHasOverlayUi(boolean hasOverlayUi) {
        this.mHasOverlayUi = hasOverlayUi;
    }

    boolean hasOverlayUi() {
        return this.mHasOverlayUi;
    }

    public void setPendingUiClean(boolean hasPendingUiClean) {
        this.mPendingUiClean = hasPendingUiClean;
    }

    boolean hasPendingUiClean() {
        return this.mPendingUiClean;
    }

    boolean registeredForDisplayAreaConfigChanges() {
        if (this.mDisplayArea == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean registeredForActivityConfigChanges() {
        if (this.mConfigActivityRecord == null) goto L5;
        return true;
    L5:
        return false;
    }

    void postPendingUiCleanMsg(boolean pendingUiClean) {
        Message m = PooledLambda.obtainMessage(new WindowProcessController$$ExternalSyntheticLambda1(), this.mListener, Boolean.valueOf(pendingUiClean));
        this.mAtm.mH.sendMessage(m);
    }

    public void setInteractionEventTime(long interactionEventTime) {
        this.mInteractionEventTime = interactionEventTime;
    }

    long getInteractionEventTime() {
        return this.mInteractionEventTime;
    }

    public void setFgInteractionTime(long fgInteractionTime) {
        this.mFgInteractionTime = fgInteractionTime;
    }

    long getFgInteractionTime() {
        return this.mFgInteractionTime;
    }

    public void setWhenUnimportant(long whenUnimportant) {
        this.mWhenUnimportant = whenUnimportant;
    }

    long getWhenUnimportant() {
        return this.mWhenUnimportant;
    }

    public void setRequiredAbi(String requiredAbi) {
        this.mRequiredAbi = requiredAbi;
    }

    String getRequiredAbi() {
        return this.mRequiredAbi;
    }

    DisplayArea getDisplayArea() {
        return this.mDisplayArea;
    }

    public void setDebugging(boolean debugging) {
        this.mDebugging = debugging;
    }

    boolean isDebugging() {
        return this.mDebugging;
    }

    public void setUsingWrapper(boolean usingWrapper) {
        this.mUsingWrapper = usingWrapper;
    }

    boolean isUsingWrapper() {
        return this.mUsingWrapper;
    }

    boolean hasEverLaunchedActivity() {
        if (this.mLastActivityLaunchTime <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    void setLastActivityLaunchTime(ActivityRecord r) {
        long launchTime = r.lastLaunchTime;
        if (launchTime <= this.mLastActivityLaunchTime) goto L5;
        updateRapidActivityLaunch(r, launchTime, this.mLastActivityLaunchTime);
        this.mLastActivityLaunchTime = launchTime;
        return;
    L5:
        if (launchTime >= this.mLastActivityLaunchTime) goto L10;
        Slog.w("ActivityTaskManager", "Tried to set launchTime (" + launchTime + ") < mLastActivityLaunchTime (" + this.mLastActivityLaunchTime + ")");
        return;
    }

    void updateRapidActivityLaunch(ActivityRecord r, long launchTime, long lastLaunchTime) {
        if (this.mInstrumenting == false) goto L5;
        return;
    L5:
        if (this.mDebugging == false) goto L7;
        return;
    L7:
        if (lastLaunchTime <= 0) goto L27;
        WindowProcessController caller = this.mAtm.mProcessMap.getProcess(r.launchedFromPid);
        if (caller != null) goto L12;
    L14:
        long diff = launchTime - lastLaunchTime;
        if (diff >= 500) goto L18;
        this.mRapidActivityLaunchCount++;
    L21:
        if (this.mRapidActivityLaunchCount <= 200) goto L25;
        this.mRapidActivityLaunchCount = 0;
        final Task task = r.getTask();
        Slog.w("ActivityTaskManager", "Removing task " + task.mTaskId + " because of rapid activity launch");
        this.mAtm.mH.post(new WindowProcessController$$ExternalSyntheticLambda10(this, task));
        return;
    L25:
        return;
    L18:
        if (diff < RESET_RAPID_ACTIVITY_LAUNCH_MS) goto L21;
        this.mRapidActivityLaunchCount = 0;
        goto L21
    L12:
        if (caller.mInstrumenting == false) goto L14;
        return;
    }

    private /* synthetic */ void lambda$updateRapidActivityLaunch$0(Task task) {
        WindowManagerGlobalLock r0 = this.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        task.removeImmediately("rapid-activity-launch");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        this.mAtm.mAmInternal.killProcess(this.mName, this.mUid, "rapidActivityLaunch");
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void setLastActivityFinishTimeIfNeeded(long finishTime) {
        if (finishTime > this.mLastActivityFinishTime) goto L5;
        return;
    L5:
        if (hasActivityInVisibleTask() == false) goto L10;
        this.mLastActivityFinishTime = finishTime;
        return;
    }

    public void addOrUpdateBackgroundStartPrivileges(Binder entity, BackgroundStartPrivileges backgroundStartPrivileges) {
        entity.getClass();
        backgroundStartPrivileges.getClass();
        Preconditions.checkArgument(backgroundStartPrivileges.allowsAny(), "backgroundStartPrivileges does not allow anything");
        this.mBgLaunchController.addOrUpdateAllowBackgroundStartPrivileges(entity, backgroundStartPrivileges);
    }

    public void removeBackgroundStartPrivileges(Binder entity) {
        entity.getClass();
        this.mBgLaunchController.removeAllowBackgroundStartPrivileges(entity);
    }

    public boolean areBackgroundFgsStartsAllowed() {
        return areBackgroundActivityStartsAllowed(this.mAtm.getBalAppSwitchesState(), BackgroundLaunchProcessController.CHECK_FOR_FGS_START).allows();
    }

    BackgroundActivityStartController.BalVerdict areBackgroundActivityStartsAllowed(int appSwitchState, BackgroundLaunchProcessController.BalCheckConfiguration checkConfiguration) {
        return this.mBgLaunchController.areBackgroundActivityStartsAllowed(this.mPid, this.mUid, this.mInfo.packageName, appSwitchState, checkConfiguration, hasActivityInVisibleTask(), inPinnedWindowingMode(), this.mInstrumentingWithBackgroundActivityStartPrivileges, this.mAtm.getLastStopAppSwitchesTime(), this.mLastActivityLaunchTime, this.mLastActivityFinishTime);
    }

    boolean canCloseSystemDialogsByToken() {
        return this.mBgLaunchController.canCloseSystemDialogsByToken(this.mUid);
    }

    public void clearBoundClientUids() {
        this.mBgLaunchController.clearBalOptInBoundClientUids();
    }

    public void addBoundClientUid(int clientUid, String clientPackageName, long bindFlags) {
        this.mBgLaunchController.addBoundClientUid(clientUid, clientPackageName, bindFlags);
    }

    public void setInstrumenting(boolean instrumenting, int sourceUid, boolean hasBackgroundActivityStartPrivileges) {
        if (instrumenting == false) goto L4;
    L7:
        boolean r0 = true;
    L8:
        Preconditions.checkArgument(r0);
        this.mInstrumenting = instrumenting;
        this.mInstrumentationSourceUid = sourceUid;
        this.mInstrumentingWithBackgroundActivityStartPrivileges = hasBackgroundActivityStartPrivileges;
        return;
    L4:
        if (sourceUid == (-1)) goto L7;
        r0 = false;
        goto L8
    }

    boolean isInstrumenting() {
        return this.mInstrumenting;
    }

    int getInstrumentationSourceUid() {
        return this.mInstrumentationSourceUid;
    }

    public void setPerceptible(boolean perceptible) {
        this.mPerceptible = perceptible;
    }

    boolean isPerceptible() {
        return this.mPerceptible;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    protected int getChildCount() {
        return 0;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    protected ConfigurationContainer getChildAt(int index) {
        return null;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    protected ConfigurationContainer getParent() {
        return this.mAtm.mRootWindowContainer;
    }

    public void addPackage(String packageName) {
        ArrayList<String> r0 = this.mPkgList;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mPkgList.contains(packageName) == true) goto L9;
        this.mPkgList.add(packageName);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void clearPackageList() {
        ArrayList<String> r0 = this.mPkgList;
        monitor-enter(r0);
        this.mPkgList.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean containsPackage(String packageName) {
        ArrayList<String> r0 = this.mPkgList;
        monitor-enter(r0);
        boolean r1 = this.mPkgList.contains(packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    List<String> getPackageList() {
        ArrayList<String> r0 = this.mPkgList;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mPkgList);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void addActivityIfNeeded(ActivityRecord r) {
        setLastActivityLaunchTime(r);
        if (this.mActivities.contains(r) == false) goto L5;
        return;
    L5:
        this.mActivities.add(r);
        this.mHasActivities = true;
        if (this.mInactiveActivities == null) goto L8;
        this.mInactiveActivities.remove(r);
    L8:
        updateActivityConfigurationListener();
    }

    void removeActivity(ActivityRecord r, boolean keepAssociation) {
        if (keepAssociation == false) goto L10;
        if (this.mInactiveActivities != null) goto L7;
        this.mInactiveActivities = new ArrayList();
        this.mInactiveActivities.add(r);
    L12:
        this.mActivities.remove(r);
        this.mHasActivities = !this.mActivities.isEmpty();
        updateActivityConfigurationListener();
        return;
    L7:
        if (this.mInactiveActivities.contains(r) == true) goto L12;
        this.mInactiveActivities.add(r);
        goto L12
    L10:
        if (this.mInactiveActivities == null) goto L12;
        this.mInactiveActivities.remove(r);
        goto L12
    }

    void clearActivities() {
        this.mInactiveActivities = null;
        this.mActivities.clear();
        this.mHasActivities = false;
        updateActivityConfigurationListener();
    }

    public boolean hasActivities() {
        return this.mHasActivities;
    }

    public boolean hasVisibleActivities() {
        if ((this.mActivityStateFlags & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean hasActivityInVisibleTask() {
        if ((this.mActivityStateFlags & 4194304) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasActivitiesOrRecentTasks() {
        if (this.mHasActivities == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mHasRecentTasks == true) goto L8;
        return false;
    }

    boolean hasVisibleNotPinnedActivity() {
        if (hasVisibleActivities() == true) goto L5;
        return false;
    L5:
        int i = this.mActivities.size() - 1;
    L6:
        if (i < 0) goto L16;
        ActivityRecord activityRecord = this.mActivities.get(i);
        if (activityRecord.isVisible() == true) goto L12;
        if (activityRecord.isVisibleRequested() == true) goto L12;
    L14:
        i = i - 1;
    L12:
        if (activityRecord.inPinnedWindowingMode() == true) goto L14;
        return true;
    L16:
        return false;
    }

    TaskDisplayArea getTopActivityDisplayArea() {
        if (this.mActivities.isEmpty() == false) goto L6;
        return null;
    L6:
        int lastIndex = this.mActivities.size() - 1;
        ActivityRecord topRecord = this.mActivities.get(lastIndex);
        TaskDisplayArea displayArea = topRecord.getDisplayArea();
        int index = lastIndex - 1;
    L7:
        if (index < 0) goto L14;
        ActivityRecord nextRecord = this.mActivities.get(index);
        TaskDisplayArea nextDisplayArea = nextRecord.getDisplayArea();
        if (nextRecord.compareTo(topRecord) <= 0) goto L12;
        if (nextDisplayArea == null) goto L12;
        topRecord = nextRecord;
        displayArea = nextDisplayArea;
    L12:
        index = index - 1;
        goto L7
    L14:
        return displayArea;
    }

    boolean updateTopResumingActivityInProcessIfNeeded(final ActivityRecord activity) {
        if (this.mInfo.targetSdkVersion < 29) goto L5;
    L44:
        return true;
    L5:
        if (this.mPreQTopResumedActivity == activity) goto L44;
        if (activity.isAttached() == true) goto L10;
        return false;
    L10:
        boolean canUpdate = false;
        if (this.mPreQTopResumedActivity != null) goto L13;
    L15:
        DisplayContent topDisplay = null;
    L17:
        if (topDisplay != null) goto L19;
    L22:
        canUpdate = true;
    L23:
        DisplayContent display = activity.mDisplayContent;
        if (canUpdate == false) goto L26;
    L28:
        if (canUpdate == true) goto L34;
        ActivityRecord ar = topDisplay.getActivity(new WindowProcessController$$ExternalSyntheticLambda12(activity), true, this.mPreQTopResumedActivity);
        if (ar == null) goto L34;
        if (ar == this.mPreQTopResumedActivity) goto L34;
        canUpdate = true;
    L34:
        if (canUpdate == true) goto L36;
    L43:
        return canUpdate;
    L36:
        if (this.mPreQTopResumedActivity != null) goto L38;
    L42:
        this.mPreQTopResumedActivity = activity;
        goto L43
    L38:
        if (this.mPreQTopResumedActivity.isState(ActivityRecord.State.RESUMED) == false) goto L42;
        TaskFragment taskFrag = this.mPreQTopResumedActivity.getTaskFragment();
        if (taskFrag == null) goto L42;
        boolean userLeaving = taskFrag.shouldBeVisible(null);
        taskFrag.startPausing(userLeaving, false, activity, "top-resumed-changed");
        goto L42
    L26:
        if (topDisplay.compareTo(display) >= 0) goto L28;
        canUpdate = true;
        goto L28
    L19:
        if (this.mPreQTopResumedActivity.isVisibleRequested() == false) goto L22;
        if (this.mPreQTopResumedActivity.isFocusable() == true) goto L23;
    L13:
        if (this.mPreQTopResumedActivity.isAttached() == false) goto L15;
        topDisplay = this.mPreQTopResumedActivity.mDisplayContent;
        goto L17
    }

    private static /* synthetic */ boolean lambda$updateTopResumingActivityInProcessIfNeeded$1(ActivityRecord activity, ActivityRecord r) {
        if (r != activity) goto L4;
        return true;
    L4:
        return false;
    }

    public void stopFreezingActivities() {
    }

    void finishActivities() {
        ArrayList<ActivityRecord> activities = new ArrayList(this.mActivities);
        int i = 0;
    L4:
        if (i >= activities.size()) goto L12;
        ActivityRecord r = activities.get(i);
        if (r.finishing == true) goto L10;
        if (r.isInRootTaskLocked() == false) goto L10;
        r.finishIfPossible("finish-heavy", true);
    L10:
        i = i + 1;
        goto L4
    }

    public boolean isInterestingToUser() {
        WindowManagerGlobalLock r0 = this.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        int size = this.mActivities.size();     // Catch: Throwable -> L12
        int i = 0;
    L6:
        if (i >= size) goto L17;
        ActivityRecord r = this.mActivities.get(i);     // Catch: Throwable -> L12
        if (r.isInterestingToUserLocked() == true) goto L9;
        i = i + 1;
        goto L6
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    L17:
        if (hasEmbeddedWindow() == false) goto L22;
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private boolean hasEmbeddedWindow() {
        if (this.mRemoteActivities != null) goto L5;
        return false;
    L5:
        int i = this.mRemoteActivities.size() - 1;
    L6:
        if (i < 0) goto L15;
        if ((this.mRemoteActivities.valueAt(i)[0] & 1) == 0) goto L13;
        ActivityRecord r = this.mRemoteActivities.keyAt(i);
        if (r.isInterestingToUserLocked() == false) goto L13;
        return true;
    L13:
        i = i - 1;
        goto L6
    L15:
        return false;
    }

    public boolean hasRunningActivity(String packageName) {
        WindowManagerGlobalLock r0 = this.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        int i = this.mActivities.size() - 1;     // Catch: Throwable -> L11
    L5:
        if (i < 0) goto L15;
        ActivityRecord r = this.mActivities.get(i);     // Catch: Throwable -> L11
        if (packageName.equals(r.packageName) == true) goto L8;
        i = i - 1;
        goto L5
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void updateAppSpecificSettingsForAllActivitiesInPackage(String packageName, Integer nightMode, LocaleList localesOverride, int gender) {
        int i = this.mActivities.size() - 1;
    L3:
        if (i < 0) goto L13;
        ActivityRecord r = this.mActivities.get(i);
        if (packageName.equals(r.packageName) == false) goto L11;
        if (r.applyAppSpecificConfig(nightMode, localesOverride, Integer.valueOf(gender)) == false) goto L11;
        if (r.isVisibleRequested() == false) goto L11;
        r.ensureActivityConfiguration();
    L11:
        i = i - 1;
        goto L3
    }

    public void clearPackagePreferredForHomeActivities() {
        WindowManagerGlobalLock r0 = this.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        int i = this.mActivities.size() - 1;     // Catch: Throwable -> L11
    L5:
        if (i < 0) goto L16;
        ActivityRecord r = this.mActivities.get(i);     // Catch: Throwable -> L11
        if (r.isActivityTypeHome() == false) goto L14;
        Log.i("ActivityTaskManager", "Clearing package preferred activities from " + r.packageName);     // Catch: Throwable -> L11
        ActivityThread.getPackageManager().clearPackagePreferredActivities(r.packageName);     // Catch: Throwable -> L11 RemoteException -> L13
    L14:
        i = i - 1;
        goto L5
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    boolean hasStartedActivity(ActivityRecord launchedActivity) {
        int i = this.mActivities.size() - 1;
    L3:
        if (i < 0) goto L11;
        ActivityRecord activity = this.mActivities.get(i);
        if (launchedActivity == activity) goto L10;
        if (activity.mAppStopped == true) goto L10;
        return true;
    L10:
        i = i - 1;
        goto L3
    L11:
        return false;
    }

    boolean hasResumedActivity() {
        if ((this.mActivityStateFlags & 2097152) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    void updateIntentForHeavyWeightActivity(Intent intent) {
        if (this.mActivities.isEmpty() == false) goto L5;
        return;
    L5:
        ActivityRecord hist = this.mActivities.get(0);
        intent.putExtra("cur_app", hist.packageName);
        intent.putExtra("cur_task", hist.getTask().mTaskId);
    }

    boolean shouldKillProcessForRemovedTask(Task task) {
        int k = 0;
    L4:
        if (k >= this.mActivities.size()) goto L14;
        ActivityRecord activity = this.mActivities.get(k);
        if (activity.mAppStopped == false) goto L7;
        Task otherTask = activity.getTask();
        if (task.mTaskId == otherTask.mTaskId) goto L13;
        if (otherTask.inRecents == false) goto L13;
        return false;
    L13:
        k = k + 1;
        goto L4
    L7:
        return false;
    L14:
        return true;
    }

    void releaseSomeActivities(String reason) {
        ArrayList<ActivityRecord> candidates = null;
        if (ActivityTaskManagerDebugConfig.DEBUG_RELEASE == false) goto L5;
        Slog.d("ActivityTaskManager", "Trying to release some activities in " + this);
    L5:
        int i = 0;
    L7:
        if (i >= this.mActivities.size()) goto L38;
        ActivityRecord r = this.mActivities.get(i);
        if (r.finishing == true) goto L34;
        if (r.isState(ActivityRecord.State.DESTROYING, ActivityRecord.State.DESTROYED) == true) goto L34;
        if (r.isVisibleRequested() == true) goto L30;
        if (r.mAppStopped == false) goto L30;
        if (r.hasSavedState() == false) goto L30;
        if (r.isDestroyable() == false) goto L30;
        if (r.isState(ActivityRecord.State.STARTED, ActivityRecord.State.RESUMED, ActivityRecord.State.PAUSING, ActivityRecord.State.PAUSED, ActivityRecord.State.STOPPING) == true) goto L30;
        if (r.getParent() == null) goto L32;
        if (candidates != null) goto L28;
        candidates = new ArrayList();
    L28:
        candidates.add(r);
    L32:
        i = i + 1;
    L30:
        if (ActivityTaskManagerDebugConfig.DEBUG_RELEASE == false) goto L32;
        Slog.d("ActivityTaskManager", "Not releasing in-use activity: " + r);
    L34:
        if (ActivityTaskManagerDebugConfig.DEBUG_RELEASE == false) goto L55;
        Slog.d("ActivityTaskManager", "Abort release; already destroying: " + r);
        return;
    L55:
        return;
    L38:
        if (candidates == null) goto L45;
        candidates.sort(new WindowProcessController$$ExternalSyntheticLambda2());
        int maxRelease = Math.max(candidates.size(), 1);
    L40:
        ActivityRecord r2 = candidates.remove(0);
        if (ActivityTaskManagerDebugConfig.DEBUG_RELEASE == false) goto L43;
        Slog.v("ActivityTaskManager", "Destroying " + r2 + " in state " + r2.getState() + " for reason " + reason);
    L43:
        r2.destroyImmediately(reason);
        maxRelease = maxRelease - 1;
        if (maxRelease > 0) goto L40;
        return;
    }

    public void getDisplayContextsWithErrorDialogs(List<Context> displayContexts) {
        if (displayContexts != null) goto L4;
        return;
    L4:
        WindowManagerGlobalLock r0 = this.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        RootWindowContainer root = this.mAtm.mWindowManager.mRoot;     // Catch: Throwable -> L15
        root.getDisplayContextsWithNonToastVisibleWindows(this.mPid, displayContexts);     // Catch: Throwable -> L15
        int i = this.mActivities.size() - 1;     // Catch: Throwable -> L15
    L7:
        if (i < 0) goto L19;
        ActivityRecord r = this.mActivities.get(i);     // Catch: Throwable -> L15
        int displayId = r.getDisplayId();     // Catch: Throwable -> L15
        Context c = root.getDisplayUiContext(displayId);     // Catch: Throwable -> L15
        if (c == null) goto L17;
        if (r.isVisibleRequested() == false) goto L17;
        if (displayContexts.contains(c) == true) goto L17;
        displayContexts.add(c);     // Catch: Throwable -> L15
    L17:
        i = i - 1;     // Catch: Throwable -> L15
        goto L7
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L15
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L15:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void addHostActivity(ActivityRecord r) {
        int[] flags = getRemoteActivityFlags(r);
        flags[0] = flags[0] | 1;
    }

    void removeHostActivity(ActivityRecord r) {
        removeRemoteActivityFlags(r, 1);
    }

    void addEmbeddedActivity(ActivityRecord r) {
        int[] flags = getRemoteActivityFlags(r);
        flags[0] = flags[0] | 2;
    }

    void removeEmbeddedActivity(ActivityRecord r) {
        removeRemoteActivityFlags(r, 2);
    }

    private int[] getRemoteActivityFlags(ActivityRecord r) {
        if (this.mRemoteActivities != null) goto L5;
        this.mRemoteActivities = new ArrayMap();
    L5:
        int[] flags = this.mRemoteActivities.get(r);
        if (flags != null) goto L9;
        int[] flags2 = new int[1];
        this.mRemoteActivities.put(r, flags2);
        return flags2;
    L9:
        return flags;
    }

    private void removeRemoteActivityFlags(ActivityRecord r, int flags) {
        if (this.mRemoteActivities != null) goto L5;
        return;
    L5:
        int index = this.mRemoteActivities.indexOfKey(r);
        if (index >= 0) goto L8;
        return;
    L8:
        int[] currentFlags = this.mRemoteActivities.valueAt(index);
        currentFlags[0] = currentFlags[0] & (~flags);
        if (currentFlags[0] != 0) goto L12;
        this.mRemoteActivities.removeAt(index);
        return;
    }

    public int getActivityStateFlags() {
        return this.mActivityStateFlags;
    }

    public long getPerceptibleTaskStoppedTimeMillis() {
        return this.mPerceptibleTaskStoppedTimeMillis;
    }

    void computeProcessActivityState() {
        ActivityRecord.State bestInvisibleState = ActivityRecord.State.DESTROYED;
        boolean allStoppingFinishing = true;
        boolean visible = false;
        boolean hasResumedFreeform = false;
        int minTaskLayer = Integer.MAX_VALUE;
        int stateFlags = 0;
        int nonOccludedRatio = 0;
        long perceptibleTaskStoppedTimeMillis = Long.MIN_VALUE;
        boolean wasResumed = hasResumedActivity();
        int r12 = 65536;
        int r14 = 1;
        if ((this.mActivityStateFlags & 65536) == 0) goto L5;
        boolean wasAnyVisible = true;
    L6:
        int i = this.mActivities.size() - 1;
    L7:
        if (i < 0) goto L64;
        int r16 = r12;
        ActivityRecord r = this.mActivities.get(i);
        if (r.isVisible() == false) goto L11;
        stateFlags = stateFlags | 1048576;
    L11:
        Task task = r.getTask();
        if (task != null) goto L14;
        int r18 = r14;
        StringBuilder r15 = new StringBuilder();
        r15.append("Unexpected detached ");
        r15.append(r);
        r15.append(" in ");
        r15.append(this);
        Slog.e("ActivityTaskManager", r15.toString());
        allStoppingFinishing = allStoppingFinishing;
    L63:
        i = i - 1;
        r12 = r16;
        r14 = r18;
        goto L7
    L14:
        boolean allStoppingFinishing2 = allStoppingFinishing;
        r18 = r14;
        if (task.mLayerRank == (-1)) goto L17;
        stateFlags = stateFlags | 4194304;
    L17:
        ActivityRecord.State state = r.getState();
        if (r.isVisibleRequested() == true) goto L20;
        boolean visible2 = visible;
        if (visible2 == true) goto L62;
        if (bestInvisibleState == ActivityRecord.State.PAUSING) goto L62;
        if (state != ActivityRecord.State.PAUSING) goto L47;
        bestInvisibleState = ActivityRecord.State.PAUSING;
        if (r.isVisible() == false) goto L45;
        stateFlags = stateFlags | r16;
        allStoppingFinishing = allStoppingFinishing2;
        visible = visible2;
        goto L63
    L45:
        allStoppingFinishing = allStoppingFinishing2;
        visible = visible2;
        goto L63
    L47:
        if (state != ActivityRecord.State.PAUSED) goto L50;
        bestInvisibleState = ActivityRecord.State.PAUSED;
        allStoppingFinishing = allStoppingFinishing2;
        visible = visible2;
        goto L63
    L50:
        if (state != ActivityRecord.State.STOPPING) goto L53;
        bestInvisibleState = ActivityRecord.State.STOPPING;
        allStoppingFinishing = allStoppingFinishing2 & r.finishing;
        visible = visible2;
        goto L63
    L53:
        if (bestInvisibleState != ActivityRecord.State.DESTROYED) goto L62;
        if (state != ActivityRecord.State.STOPPED) goto L62;
        if (task.mIsPerceptible == false) goto L62;
        perceptibleTaskStoppedTimeMillis = Long.max(r.mStoppedTime, perceptibleTaskStoppedTimeMillis);
        allStoppingFinishing = allStoppingFinishing2;
        visible = visible2;
    L62:
        allStoppingFinishing = allStoppingFinishing2;
        visible = visible2;
        goto L63
    L20:
        if (state != ActivityRecord.State.RESUMED) goto L30;
        stateFlags = stateFlags | 2097152;
        int windowingMode = r.getWindowingMode();
        if (windowingMode != 6) goto L27;
        if (task.hasAdjacentTask() == false) goto L27;
        stateFlags = stateFlags | 8388608;
    L27:
        if (windowingMode != 5) goto L30;
        hasResumedFreeform = true;
        nonOccludedRatio = Math.max(task.mNonOccludedFreeformAreaRatio, nonOccludedRatio);
    L30:
        if (minTaskLayer <= 0) goto L35;
        int layer = task.mLayerRank;
        if (layer < 0) goto L35;
        if (minTaskLayer <= layer) goto L35;
        minTaskLayer = layer;
    L35:
        visible = true;
        allStoppingFinishing = allStoppingFinishing2;
        goto L63
    L64:
        boolean allStoppingFinishing3 = allStoppingFinishing;
        boolean visible3 = visible;
        int r17 = r12;
        int r19 = r14;
        if (this.mRemoteActivities == null) goto L74;
        int i2 = this.mRemoteActivities.size() - 1;
    L67:
        if (i2 < 0) goto L74;
        if ((this.mRemoteActivities.valueAt(i2)[0] & 2) == 0) goto L73;
        if (this.mRemoteActivities.keyAt(i2).isVisibleRequested() == false) goto L73;
        stateFlags = stateFlags | r17;
    L73:
        i2 = i2 - 1;
    L74:
        if (hasResumedFreeform == true) goto L76;
    L84:
        int stateFlags2 = (65535 & minTaskLayer) | stateFlags;
        if (visible3 == false) goto L88;
        stateFlags2 = stateFlags2 | r17;
    L98:
        this.mActivityStateFlags = stateFlags2;
        this.mPerceptibleTaskStoppedTimeMillis = perceptibleTaskStoppedTimeMillis;
        if ((stateFlags2 & r17) == 0) goto L101;
        boolean anyVisible = true;
    L102:
        if (wasAnyVisible == true) goto L105;
        if (anyVisible == false) goto L105;
        this.mAtm.mVisibleActivityProcessTracker.onAnyActivityVisible(this);
        this.mAtm.mWindowManager.onProcessActivityVisibilityChanged(this.mUid, true);
        return;
    L105:
        if (wasAnyVisible == false) goto L108;
        if (anyVisible == true) goto L108;
        this.mAtm.mVisibleActivityProcessTracker.onAllActivitiesInvisible(this);
        this.mAtm.mWindowManager.onProcessActivityVisibilityChanged(this.mUid, false);
        return;
    L108:
        if (wasAnyVisible == false) goto L129;
        if (wasResumed == false) goto L111;
        return;
    L111:
        if (hasResumedActivity() == false) goto L131;
        this.mAtm.mVisibleActivityProcessTracker.onActivityResumedWhileVisible(this);
        return;
    L131:
        return;
    L129:
        return;
    L101:
        anyVisible = false;
        goto L102
    L88:
        if (bestInvisibleState != ActivityRecord.State.PAUSING) goto L90;
    L97:
        stateFlags2 = stateFlags2 | 131072;
        goto L98
    L90:
        if (bestInvisibleState == ActivityRecord.State.PAUSED) goto L97;
        if (bestInvisibleState != ActivityRecord.State.STOPPING) goto L98;
        stateFlags2 = stateFlags2 | 262144;
        if (allStoppingFinishing3 == false) goto L98;
        stateFlags2 = stateFlags2 | 524288;
        goto L98
    L76:
        if (minTaskLayer <= r19) goto L84;
        if (minTaskLayer > (MAX_NUM_PERCEPTIBLE_FREEFORM + r19)) goto L80;
    L83:
        stateFlags = stateFlags | 16777216;
        goto L84
    L80:
        if (nonOccludedRatio >= 90) goto L83;
        stateFlags = stateFlags | 33554432;
        goto L84
    L5:
        wasAnyVisible = false;
        goto L6
    }

    private void prepareOomAdjustment() {
        this.mAtm.mRootWindowContainer.rankTaskLayers();
        this.mAtm.mTaskSupervisor.computeProcessActivityStateBatch();
    }

    public int computeRelaunchReason() {
        WindowManagerGlobalLock r0 = this.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        int activitiesSize = this.mActivities.size();     // Catch: Throwable -> L12
        int i = activitiesSize - 1;     // Catch: Throwable -> L12
    L5:
        if (i < 0) goto L16;
        ActivityRecord r = this.mActivities.get(i);     // Catch: Throwable -> L12
        if (r.mRelaunchReason != 0) goto L8;
        i = i - 1;
        goto L5
    L8:
        int r4 = r.mRelaunchReason;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return r4;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public long getInputDispatchingTimeoutMillis() {
        WindowManagerGlobalLock r0 = this.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (isInstrumenting() == true) goto L12;
        if (isUsingWrapper() == true) goto L12;
        long r1 = InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS;     // Catch: Throwable -> L10
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return r1;
    L12:
        r1 = 60000;
        goto L13
    }

    void clearProfilerIfNeeded() {
        this.mAtm.mH.sendMessage(PooledLambda.obtainMessage(new WindowProcessController$$ExternalSyntheticLambda6(), this.mListener));
    }

    void updateProcessInfo(boolean updateServiceConnectionActivities, boolean activityChange, boolean updateOomAdj, boolean addPendingTopUid) {
        if (addPendingTopUid == false) goto L4;
        addToPendingTop();
    L4:
        if (updateOomAdj == false) goto L6;
        prepareOomAdjustment();
    L6:
        Message m = PooledLambda.obtainMessage(new WindowProcessController$$ExternalSyntheticLambda7(), this.mListener, Boolean.valueOf(updateServiceConnectionActivities), Boolean.valueOf(activityChange), Boolean.valueOf(updateOomAdj));
        this.mAtm.mH.sendMessage(m);
    }

    void scheduleUpdateOomAdj() {
        this.mAtm.mH.sendMessage(PooledLambda.obtainMessage(new WindowProcessController$$ExternalSyntheticLambda7(), this.mListener, false, false, true));
    }

    void addToPendingTop() {
        this.mAtm.mAmInternal.addPendingTopUid(this.mUid, this.mPid, this.mThread);
    }

    void updateServiceConnectionActivities() {
        this.mAtm.mH.sendMessage(PooledLambda.obtainMessage(new WindowProcessController$$ExternalSyntheticLambda3(), this.mListener));
    }

    void setPendingUiCleanAndForceProcessStateUpTo(int newState) {
        Message m = PooledLambda.obtainMessage(new WindowProcessController$$ExternalSyntheticLambda0(), this.mListener, Integer.valueOf(newState));
        this.mAtm.mH.sendMessage(m);
    }

    boolean isRemoved() {
        return this.mListener.isRemoved();
    }

    private boolean shouldSetProfileProc() {
        if (this.mAtm.mProfileApp != null) goto L5;
    L11:
        return false;
    L5:
        if (this.mAtm.mProfileApp.equals(this.mName) == false) goto L11;
        if (this.mAtm.mProfileProc != null) goto L9;
    L10:
        return true;
    L9:
        if (this.mAtm.mProfileProc != this) goto L11;
        goto L10
    }

    ProfilerInfo createProfilerInfoIfNeeded() {
        ProfilerInfo currentProfilerInfo = this.mAtm.mProfilerInfo;
        if (currentProfilerInfo != null) goto L5;
        return null;
    L5:
        if (currentProfilerInfo.profileFile != null) goto L7;
        return null;
    L7:
        if (shouldSetProfileProc() == true) goto L10;
        return null;
    L10:
        if (currentProfilerInfo.profileFd == null) goto L16;
        currentProfilerInfo.profileFd = currentProfilerInfo.profileFd.dup();     // Catch: IOException -> L13
    L14:
        currentProfilerInfo.closeFd();
    L16:
        return new ProfilerInfo(currentProfilerInfo);
    }

    void onStartActivity(int topProcessState, ActivityInfo info) {
        if ((info.flags & 1) != 0) goto L5;
    L8:
        String packageName = info.packageName;
        String packageName2 = packageName;
    L10:
        if (topProcessState != 2) goto L12;
        this.mAtm.mAmInternal.addPendingTopUid(this.mUid, this.mPid, this.mThread);
    L12:
        prepareOomAdjustment();
        Message m = PooledLambda.obtainMessage(new WindowProcessController$$ExternalSyntheticLambda11(), this.mListener, Integer.valueOf(topProcessState), Boolean.valueOf(shouldSetProfileProc()), packageName2, Long.valueOf(info.applicationInfo.longVersionCode));
        this.mAtm.mH.sendMessageAtFrontOfQueue(m);
        return;
    L5:
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(info.packageName) == false) goto L8;
        packageName2 = null;
        goto L10
    }

    void appDied(String reason) {
        Message m = PooledLambda.obtainMessage(new WindowProcessController$$ExternalSyntheticLambda8(), this.mListener, reason);
        this.mAtm.mH.sendMessage(m);
    }

    boolean handleAppDied() {
        this.mAtm.mTaskSupervisor.removeHistoryRecords(this);
        boolean hasVisibleActivities = false;
        if (this.mInactiveActivities != null) goto L5;
    L7:
        boolean hasInactiveActivities = false;
    L9:
        if (this.mHasActivities == true) goto L13;
        if (hasInactiveActivities == true) goto L13;
        ArrayList<ActivityRecord> activities = this.mActivities;
    L15:
        if (this.mHasActivities == false) goto L17;
        activities.addAll(this.mActivities);
    L17:
        if (hasInactiveActivities == false) goto L20;
        activities.addAll(this.mInactiveActivities);
    L20:
        if (isRemoved() == false) goto L24;
        int i = activities.size() - 1;
    L22:
        if (i < 0) goto L24;
        activities.get(i).makeFinishingLocked();
        i = i - 1;
    L24:
        getExt().traceHandleAppDied(this, activities);
        int i2 = activities.size() - 1;
    L25:
        if (i2 < 0) goto L35;
        ActivityRecord r = activities.get(i2);
        if (r.isVisibleRequested() == false) goto L29;
    L30:
        hasVisibleActivities = true;
    L31:
        TaskFragment taskFragment = r.getTaskFragment();
        if (taskFragment == null) goto L34;
        hasVisibleActivities = hasVisibleActivities | taskFragment.handleAppDied(this);
    L34:
        r.handleAppDied();
        i2 = i2 - 1;
        goto L25
    L29:
        if (r.isVisible() == false) goto L31;
    L35:
        clearRecentTasks();
        clearActivities();
        return hasVisibleActivities;
    L13:
        activities = new ArrayList();
        goto L15
    L5:
        if (this.mInactiveActivities.isEmpty() == true) goto L7;
        hasInactiveActivities = true;
        goto L9
    }

    void registerDisplayAreaConfigurationListener(DisplayArea displayArea) {
        if (displayArea != null) goto L4;
        return;
    L4:
        if (displayArea.containsListener(this) == true) goto L9;
        unregisterConfigurationListeners();
        this.mDisplayArea = displayArea;
        displayArea.registerConfigurationChangeListener(this);
        return;
    }

    void unregisterDisplayAreaConfigurationListener() {
        if (this.mDisplayArea != null) goto L5;
        return;
    L5:
        this.mDisplayArea.unregisterConfigurationChangeListener(this);
        this.mDisplayArea = null;
        onMergedOverrideConfigurationChanged(Configuration.EMPTY);
    }

    void registerActivityConfigurationListener(ActivityRecord activityRecord) {
        if (activityRecord != null) goto L4;
        return;
    L4:
        if (activityRecord.containsListener(this) == false) goto L6;
        return;
    L6:
        if (this.mIsActivityConfigOverrideAllowed == false) goto L15;
        unregisterConfigurationListeners();
        this.mConfigActivityRecord = activityRecord;
        activityRecord.registerConfigurationChangeListener(this);
        if (this.mThread != null) goto L13;
        this.mHasPendingConfigurationChange = true;
        return;
    L13:
        return;
    }

    private void unregisterActivityConfigurationListener() {
        if (this.mConfigActivityRecord != null) goto L5;
        return;
    L5:
        this.mConfigActivityRecord.unregisterConfigurationChangeListener(this);
        this.mConfigActivityRecord = null;
        onMergedOverrideConfigurationChanged(Configuration.EMPTY);
    }

    private void unregisterConfigurationListeners() {
        unregisterActivityConfigurationListener();
        unregisterDisplayAreaConfigurationListener();
    }

    void destroy() {
        unregisterConfigurationListeners();
    }

    private void updateActivityConfigurationListener() {
        if (this.mIsActivityConfigOverrideAllowed == true) goto L5;
        return;
    L5:
        int i = this.mActivities.size() - 1;
    L6:
        if (i < 0) goto L12;
        ActivityRecord activityRecord = this.mActivities.get(i);
        if (activityRecord.finishing == false) goto L9;
        i = i - 1;
        goto L6
    L9:
        registerActivityConfigurationListener(activityRecord);
        return;
    L12:
        unregisterActivityConfigurationListener();
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public void onConfigurationChanged(Configuration newGlobalConfig) {
        super.onConfigurationChanged(newGlobalConfig);
        boolean topActivityDeviceChanged = false;
        int deviceId = getTopActivityDeviceId();
        if (deviceId == this.mLastTopActivityDeviceId) goto L5;
        topActivityDeviceChanged = true;
        this.mLastTopActivityDeviceId = deviceId;
    L5:
        Configuration config = getConfiguration();
        if (getWPCSmtEx().cacheFrozenConfiguration(config) == false) goto L9;
        return;
    L9:
        if ((this.mLastReportedConfiguration.equals(config) & (!topActivityDeviceChanged)) == false) goto L17;
        if (Build.IS_DEBUGGABLE == true) goto L13;
        return;
    L13:
        if (this.mHasImeService == false) goto L23;
        Slog.w("ActivityTaskManager", "Current config: " + config + " unchanged for IME proc " + this.mName);
        return;
    L23:
        return;
    L17:
        if (this.mPauseConfigurationDispatchCount <= 0) goto L20;
        this.mHasPendingConfigurationChange = true;
        return;
    L20:
        dispatchConfiguration(config);
    }

    private int getTopActivityDeviceId() {
        ActivityRecord topActivity = getTopNonFinishingActivity();
        if (topActivity != null) goto L5;
        return 0;
    L5:
        if (topActivity.mDisplayContent == null) goto L9;
        int updatedDeviceId = this.mAtm.mTaskSupervisor.getDeviceIdForDisplayId(topActivity.mDisplayContent.mDisplayId);
        return updatedDeviceId;
    L9:
        return 0;
    }

    protected ActivityRecord getTopNonFinishingActivity() {
        if (this.mActivities.isEmpty() == false) goto L5;
        return null;
    L5:
        int i = this.mActivities.size() - 1;
    L6:
        if (i < 0) goto L13;
        if (this.mActivities.get(i).finishing == false) goto L10;
        i = i - 1;
        goto L6
    L10:
        return this.mActivities.get(i);
    L13:
        return null;
    }

    @Override // com.android.server.wm.ConfigurationContainerListener
    public void onMergedOverrideConfigurationChanged(Configuration mergedOverrideConfig) {
        super.onRequestedOverrideConfigurationChanged(mergedOverrideConfig);
    }

    @Override // com.android.server.wm.ConfigurationContainer
    void resolveOverrideConfiguration(Configuration newParentConfig) {
        Configuration requestedOverrideConfig = getRequestedOverrideConfiguration();
        if (requestedOverrideConfig.assetsSeq != 0) goto L5;
    L7:
        super.resolveOverrideConfiguration(newParentConfig);
        Configuration resolvedConfig = getResolvedOverrideConfiguration();
        resolvedConfig.windowConfiguration.setActivityType(0);
        resolvedConfig.seq = newParentConfig.seq;
        if (this.mConfigActivityRecord == null) goto L11;
        return;
    L11:
        if (this.mAtm.mWindowManager == null) goto L13;
        DisplayContent displayContent = this.mAtm.mWindowManager.getDefaultDisplayContentLocked();
    L14:
        ConfigurationContainer.applySizeOverrideIfNeeded(displayContent, this.mInfo, newParentConfig, resolvedConfig, false, false, false, null);
        return;
    L13:
        displayContent = null;
        goto L14
    L5:
        if (newParentConfig.assetsSeq <= requestedOverrideConfig.assetsSeq) goto L7;
        requestedOverrideConfig.assetsSeq = 0;
        goto L7
    }

    void dispatchConfiguration(Configuration config) {
        this.mHasPendingConfigurationChange = false;
        IApplicationThread thread = this.mThread;
        if (thread == null) goto L5;
        config.seq = this.mAtm.increaseConfigurationSeqLocked();
        setLastReportedConfiguration(config);
        if (this.mRepProcState < 16) goto L15;
        this.mHasCachedConfiguration = true;
        if (this.mRepProcState < 16) goto L15;
        return;
    L15:
        onConfigurationChangePreScheduled(config);
        scheduleClientTransactionItem(thread, new ConfigurationChangeItem(config, this.mLastTopActivityDeviceId));
        return;
    L5:
        if (Build.IS_DEBUGGABLE == true) goto L7;
        return;
    L7:
        if (this.mHasImeService == false) goto L18;
        Slog.w("ActivityTaskManager", "Unable to send config for IME proc " + this.mName + ": no app thread");
        return;
    }

    private void onConfigurationChangePreScheduled(Configuration config) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L6;
        String protoLogParam0 = String.valueOf(this.mName);
        String protoLogParam1 = String.valueOf(config);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, -4629255026637000251L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L6:
        if (Build.IS_DEBUGGABLE == true) goto L8;
    L10:
        this.mHasCachedConfiguration = false;
        return;
    L8:
        if (this.mHasImeService == false) goto L10;
        Slog.v("ActivityTaskManager", "Sending to IME proc " + this.mName + " new config " + config);
        goto L10
    }

    void scheduleClientTransactionItem(ClientTransactionItem transactionItem) {
        IApplicationThread thread = this.mThread;
        if (thread == null) goto L5;
        scheduleClientTransactionItem(thread, transactionItem);
        return;
    L5:
        if (Build.IS_DEBUGGABLE == false) goto L10;
        Slog.w("ActivityTaskManager", "Unable to send transaction to client proc " + this.mName + ": no app thread");
        return;
    }

    private void scheduleClientTransactionItem(IApplicationThread thread, ClientTransactionItem transactionItem) {
        if (this.mWindowSession != null) goto L5;
    L9:
        this.mAtm.getLifecycleManager().scheduleTransactionItemNow(thread, transactionItem);     // Catch: RemoteException -> L7
    L13:
        return;
    L5:
        if (this.mWindowSession.hasWindow() == false) goto L9;
        this.mAtm.getLifecycleManager().scheduleTransactionItem(thread, transactionItem);     // Catch: RemoteException -> L7
    L11:
        Slog.w("ActivityTaskManager", "Failed for dead process. ClientTransactionItem=" + transactionItem + " owner=" + this.mOwner);
    }

    void setLastReportedConfiguration(Configuration config) {
        Configuration r0 = this.mLastReportedConfiguration;
        monitor-enter(r0);
        this.mLastReportedConfiguration.setTo(config);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void pauseConfigurationDispatch() {
        this.mPauseConfigurationDispatchCount++;
    }

    boolean resumeConfigurationDispatch() {
        if (this.mPauseConfigurationDispatchCount != 0) goto L6;
        return false;
    L6:
        this.mPauseConfigurationDispatchCount--;
        return this.mHasPendingConfigurationChange;
    }

    void updateAssetConfiguration(int assetSeq) {
        if (this.mHasActivities == true) goto L5;
    L15:
        Configuration overrideConfig = new Configuration(getRequestedOverrideConfiguration());
        overrideConfig.assetsSeq = assetSeq;
        onRequestedOverrideConfigurationChanged(overrideConfig);
        return;
    L5:
        if (this.mIsActivityConfigOverrideAllowed == false) goto L15;
        int i = this.mActivities.size() - 1;
    L8:
        if (i < 0) goto L14;
        ActivityRecord r = this.mActivities.get(i);
        Configuration overrideConfig2 = new Configuration(r.getRequestedOverrideConfiguration());
        overrideConfig2.assetsSeq = assetSeq;
        r.onRequestedOverrideConfigurationChanged(overrideConfig2);
        r.updateApplicationInfo(this.mInfo);
        if (r.isVisibleRequested() == false) goto L12;
        r.ensureActivityConfiguration();
    L12:
        i = i - 1;
        goto L8
    }

    public void updateApplicationInfo(ApplicationInfo aInfo) {
        this.mInfo = aInfo;
    }

    Configuration prepareConfigurationForLaunchingActivity() {
        Configuration config = getConfiguration();
        if (this.mHasPendingConfigurationChange == false) goto L5;
        this.mHasPendingConfigurationChange = false;
        config.seq = this.mAtm.increaseConfigurationSeqLocked();
    L5:
        this.mHasCachedConfiguration = false;
        return config;
    }

    public long getCpuTime() {
        return this.mListener.getCpuTime();
    }

    void addRecentTask(Task task) {
        this.mRecentTasks.add(task);
        this.mHasRecentTasks = true;
    }

    void removeRecentTask(Task task) {
        this.mRecentTasks.remove(task);
        this.mHasRecentTasks = !this.mRecentTasks.isEmpty();
    }

    public boolean hasRecentTasks() {
        return this.mHasRecentTasks;
    }

    void clearRecentTasks() {
        int i = this.mRecentTasks.size() - 1;
    L3:
        if (i < 0) goto L5;
        this.mRecentTasks.get(i).clearRootProcess();
        i = i - 1;
        goto L3
    L5:
        this.mRecentTasks.clear();
        this.mHasRecentTasks = false;
    }

    public void appEarlyNotResponding(String annotation, Runnable killAppCallback) {
        Runnable targetRunnable = null;
        WindowManagerGlobalLock r1 = this.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mAtm.mController != null) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        if (this.mAtm.mControllerIsAMonkey == false) goto L36;
        Slog.i("ActivityTaskManager", "the Monkey device doesn't let it control anr, otherwise the application will never exit, causing many inexplicable problems.");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L36:
        int res = this.mAtm.mController.appEarlyNotResponding(this.mName, this.mPid, annotation);     // Catch: Throwable -> L9 RemoteException -> L22
        if (res >= 0) goto L27;
        if (this.mPid == WindowManagerService.MY_PID) goto L27;
        targetRunnable = killAppCallback;
        goto L27
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        if (targetRunnable == null) goto L38;
        targetRunnable.run();
        return;
    L38:
        return;
    L26:
        this.mAtm.mController = null;     // Catch: Throwable -> L9
        Watchdog.getInstance().setActivityController(null);     // Catch: Throwable -> L9
        goto L27
    }

    public boolean appNotResponding(String info, Runnable killAppCallback, Runnable serviceTimeoutCallback) {
        Runnable targetRunnable = null;
        WindowManagerGlobalLock r1 = this.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mAtm.mController != null) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L12:
        if (this.mAtm.mControllerIsAMonkey == false) goto L41;
        Slog.i("ActivityTaskManager", "the Monkey device doesn't let it control anr, otherwise the application will never exit, causing many inexplicable problems.");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L41:
        int res = this.mAtm.mController.appNotResponding(this.mName, this.mPid, info);     // Catch: Throwable -> L9 RemoteException -> L23
        if (res == 0) goto L27;
        if (res >= 0) goto L25;
        if (this.mPid == WindowManagerService.MY_PID) goto L25;
        targetRunnable = killAppCallback;
        goto L27
    L25:
        targetRunnable = serviceTimeoutCallback;
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        if (targetRunnable == null) goto L32;
        targetRunnable.run();
        return true;
    L32:
        return false;
    L34:
        this.mAtm.mController = null;     // Catch: Throwable -> L9
        Watchdog.getInstance().setActivityController(null);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    }

    public void onServiceStarted(ServiceInfo serviceInfo) {
        String permission = serviceInfo.permission;
        if (permission != null) goto L6;
        return;
    L6:
        switch(permission.hashCode()) {
            case -769871357: goto L15;
            case 1412417858: goto L12;
            case 1448369304: goto L9;
            default: goto L17;
        };
    L17:
        byte r1 = -1;
    L18:
        switch(r1) {
            case 0: goto L20;
            case 1: goto L21;
            case 2: goto L21;
            default: goto L23;
        };
    L20:
        this.mHasImeService = true;
    L21:
        this.mIsActivityConfigOverrideAllowed = false;
        this.mAtm.mH.post(new WindowProcessController$$ExternalSyntheticLambda4(this));
        return;
    L23:
        return;
    L9:
        if (permission.equals("android.permission.BIND_INPUT_METHOD") == false) goto L17;
        r1 = 0;
        goto L18
    L12:
        if (permission.equals("android.permission.BIND_ACCESSIBILITY_SERVICE") == false) goto L17;
        r1 = 1;
        goto L18
    L15:
        if (permission.equals("android.permission.BIND_VOICE_INTERACTION") == false) goto L17;
        r1 = 2;
        goto L18
    }

    private /* synthetic */ void lambda$onServiceStarted$2() {
        WindowManagerGlobalLock r0 = this.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        unregisterActivityConfigurationListener();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean useFifoUiScheduling() {
        return this.mUseFifoUiScheduling;
    }

    public void onTopProcChanged() {
        if (this.mAtm.mVrController.isInterestingToSchedGroup() == false) goto L6;
        this.mAtm.mH.post(new WindowProcessController$$ExternalSyntheticLambda9(this));
        return;
    }

    private /* synthetic */ void lambda$onTopProcChanged$3() {
        WindowManagerGlobalLock r0 = this.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mAtm.mVrController.onTopProcChangedLocked(this);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean isHomeProcess() {
        if (this != this.mAtm.mHomeProcess) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isShowingUiWhileDozing() {
        if (this != this.mAtm.mVisibleDozeUiProcess) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPreviousProcess() {
        if (this != this.mAtm.mPreviousProcess) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isHeavyWeightProcess() {
        if (this != this.mAtm.mHeavyWeightProcess) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFactoryTestProcess() {
        int factoryTestMode = this.mAtm.mFactoryTest;
        if (factoryTestMode != 0) goto L6;
        return false;
    L6:
        if (factoryTestMode != 1) goto L13;
        ComponentName topComponent = this.mAtm.mTopComponent;
        if (topComponent == null) goto L13;
        if (this.mName.equals(topComponent.getPackageName()) == false) goto L13;
        return true;
    L13:
        if (factoryTestMode == 2) goto L15;
        return false;
    L15:
        if ((this.mInfo.flags & 16) != 0) goto L17;
        return false;
    L17:
        return true;
    }

    public void setStoppedState(int stoppedState) {
        this.mStoppedState = stoppedState;
    }

    boolean getWasStoppedLogged() {
        return this.mWasStoppedLogged;
    }

    void setWasStoppedLogged(boolean logged) {
        this.mWasStoppedLogged = logged;
    }

    public boolean wasForceStopped() {
        if (this.mStoppedState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    boolean wasFirstLaunch() {
        if (this.mStoppedState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    void setRunningRemoteAnimation(boolean running) {
        if (running == false) goto L5;
        addAnimatingReason(1);
        return;
    L5:
        removeAnimatingReason(1);
    }

    void addAnimatingReason(int reason) {
        int prevReasons = this.mAnimatingReasons;
        this.mAnimatingReasons |= reason;
        if (prevReasons != 0) goto L6;
        setAnimating(true);
        return;
    }

    void removeAnimatingReason(int reason) {
        int prevReasons = this.mAnimatingReasons;
        this.mAnimatingReasons &= ~reason;
        if (prevReasons != 0) goto L5;
        return;
    L5:
        if (this.mAnimatingReasons != 0) goto L9;
        setAnimating(false);
        return;
    }

    private /* synthetic */ void lambda$setAnimating$4(boolean animating) {
        this.mListener.setRunningRemoteAnimation(animating);
    }

    private void setAnimating(final boolean animating) {
        this.mAtm.mH.post(new WindowProcessController$$ExternalSyntheticLambda5(this, animating));
    }

    boolean isRunningRemoteTransition() {
        if ((this.mAnimatingReasons & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    void setRunningAnimationUnsafe() {
        this.mListener.setRunningRemoteAnimation(true);
    }

    public String toString() {
        if (this.mOwner != null) goto L7;
        return null;
    L7:
        return this.mOwner.toString();
    }

    public void dump(PrintWriter pw, String prefix) {
        WindowManagerGlobalLock r0 = this.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mActivities.size() <= 0) goto L13;
        pw.print(prefix);     // Catch: Throwable -> L10
        pw.println("Activities:");     // Catch: Throwable -> L10
        int i = 0;
    L8:
        if (i >= this.mActivities.size()) goto L13;
        pw.print(prefix);     // Catch: Throwable -> L10
        pw.print("  - ");     // Catch: Throwable -> L10
        pw.println(this.mActivities.get(i));     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
    L13:
        if (this.mRemoteActivities == null) goto L26;
        if (this.mRemoteActivities.isEmpty() == true) goto L26;
        pw.print(prefix);     // Catch: Throwable -> L10
        pw.println("Remote Activities:");     // Catch: Throwable -> L10
        int i2 = this.mRemoteActivities.size() - 1;     // Catch: Throwable -> L10
    L17:
        if (i2 < 0) goto L26;
        pw.print(prefix);     // Catch: Throwable -> L10
        pw.print("  - ");     // Catch: Throwable -> L10
        pw.print(this.mRemoteActivities.keyAt(i2));     // Catch: Throwable -> L10
        pw.print(" flags=");     // Catch: Throwable -> L10
        int flags = this.mRemoteActivities.valueAt(i2)[0];     // Catch: Throwable -> L10
        if ((flags & 1) == 0) goto L22;
        pw.print("host ");     // Catch: Throwable -> L10
    L22:
        if ((flags & 2) == 0) goto L24;
        pw.print("embedded");     // Catch: Throwable -> L10
    L24:
        pw.println();     // Catch: Throwable -> L10
        i2 = i2 - 1;     // Catch: Throwable -> L10
    L26:
        if (this.mRecentTasks.size() <= 0) goto L31;
        pw.println(prefix + "Recent Tasks:");     // Catch: Throwable -> L10
        int i3 = 0;
    L29:
        if (i3 >= this.mRecentTasks.size()) goto L31;
        pw.println(prefix + "  - " + this.mRecentTasks.get(i3));     // Catch: Throwable -> L10
        i3 = i3 + 1;     // Catch: Throwable -> L10
    L31:
        int i4 = this.mVrThreadTid;     // Catch: Throwable -> L10
        if (i4 == 0) goto L34;
        pw.print(prefix);     // Catch: Throwable -> L10
        pw.print("mVrThreadTid=");     // Catch: Throwable -> L10
        pw.println(this.mVrThreadTid);     // Catch: Throwable -> L10
    L34:
        this.mBgLaunchController.dump(pw, prefix);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        pw.println(prefix + " Configuration=" + getConfiguration());
        pw.println(prefix + " OverrideConfiguration=" + getRequestedOverrideConfiguration());
        StringBuilder r1 = new StringBuilder();
        r1.append(prefix);
        r1.append(" mLastReportedConfiguration=");
        if (this.mHasCachedConfiguration == false) goto L39;
        Object r2 = "(cached) " + this.mLastReportedConfiguration;
    L40:
        r1.append(r2);
        pw.println(r1.toString());
        int animatingReasons = this.mAnimatingReasons;
        if (animatingReasons == 0) goto L50;
        pw.print(prefix + " mAnimatingReasons=");
        if ((animatingReasons & 1) == 0) goto L46;
        pw.print("remote-animation|");
    L46:
        if ((animatingReasons & 2) == 0) goto L48;
        pw.print("wakefulness|");
    L48:
        pw.println();
    L50:
        if (this.mUseFifoUiScheduling == false) goto L52;
        pw.println(prefix + " mUseFifoUiScheduling=true");
    L52:
        int stateFlags = this.mActivityStateFlags;
        if (stateFlags == 65535) goto L93;
        pw.print(prefix + " mActivityStateFlags=");
        if ((1048576 & stateFlags) == 0) goto L58;
        pw.print("W|");
    L58:
        if ((65536 & stateFlags) == 0) goto L68;
        pw.print("V|");
        if ((2097152 & stateFlags) == 0) goto L76;
        pw.print("R|");
        if ((8388608 & stateFlags) == 0) goto L65;
        pw.print("RS|");
    L65:
        if ((16777216 & stateFlags) == 0) goto L76;
        pw.print("PF|");
    L76:
        if ((4194304 & stateFlags) == 0) goto L78;
        pw.print("VT|");
    L78:
        int taskLayer = stateFlags & 65535;
        if (taskLayer == 65535) goto L81;
        pw.print("taskLayer=" + taskLayer);
    L81:
        pw.println();
        return;
    L68:
        if ((131072 & stateFlags) == 0) goto L71;
        pw.print("P|");
        goto L76
    L71:
        if ((262144 & stateFlags) == 0) goto L76;
        pw.print("S|");
        if ((524288 & stateFlags) == 0) goto L76;
        pw.print("F|");
        goto L76
    L93:
        return;
    L39:
        r2 = this.mLastReportedConfiguration;
        goto L40
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        this.mListener.dumpDebug(proto, fieldId);
    }

    @Override // com.android.server.wm.ConfigurationContainer
    protected boolean setOverrideGender(Configuration requestsTmpConfig, int gender) {
        return applyConfigGenderOverride(requestsTmpConfig, gender, this.mAtm.mGrammaticalManagerInternal, this.mUid);
    }

    static boolean applyConfigGenderOverride(Configuration overrideConfig, int override, GrammaticalInflectionManagerInternal service, int uid) {
        if (service != null) goto L5;
    L7:
        boolean canGetSystemValue = false;
    L9:
        if (override == 0) goto L11;
        int targetValue = override;
    L17:
        if (overrideConfig.getGrammaticalGenderRaw() != targetValue) goto L19;
        return false;
    L19:
        overrideConfig.setGrammaticalGender(targetValue);
        return true;
    L11:
        if (canGetSystemValue == false) goto L13;
        targetValue = -1;
        goto L17
    L13:
        if (service == null) goto L15;
        targetValue = service.getGrammaticalGenderFromDeveloperSettings();
        goto L17
    L15:
        targetValue = 0;
        goto L17
    L5:
        if (service.canGetSystemGrammaticalGender(uid) == false) goto L7;
        canGetSystemValue = true;
        goto L9
    }

    public WindowProcessControllerSmtBase getWPCSmtEx() {
        return (WindowProcessControllerSmtBase) getSmtEx();
    }

    public ArrayList<String> getPkgList() {
        return this.mPkgList;
    }

    void updateActivityConfigurationListenerIfNeeded() {
        updateActivityConfigurationListener();
    }

    ArrayList<ActivityRecord> getActivities() {
        return this.mActivities;
    }

    public IExtWindowProcessController getExt() {
        return this.mExt;
    }
}
