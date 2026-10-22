package com.android.server.wm;

import android.app.IActivityController;
import android.app.SysMonitorFwBridge;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerAdvisorInternal;
import android.os.Process;
import android.os.UserHandle;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.Slog;
import android.util.TimeUtils;
import android.view.Display;
import com.android.internal.app.ProcessMap;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.am.ActivityManagerService;
import com.android.server.am.ProcessRecord;
import com.android.server.resmng.IResMngConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityTaskManagerServiceSmtBase {
    protected static final String TAG = "ActivityTaskManagerService";
    private static boolean mIsPerfBoost_V5_Acquired;
    public static boolean mIsPerfLockAcquired;
    private static BoostFramework mPerfBoost_V5;
    protected int boost_v5_TimeOut;
    ActivityManagerService mAMS;
    protected ActivityTaskManagerService mAtmServices;
    private int mBoostUid;
    public boolean mBoostWhiteListEnabled;
    boolean mControllerIsAMonkeySmt;
    Object mControllerLock;
    IActivityController mControllerSmt;
    int mCurrentUser;
    protected int mDefaultBoostTimeOut;
    private DisplayManager mDisplayManager;
    public Handler mHandler;
    public WindowProcessController mHomePreviousProcess;
    protected boolean mIsColdLaunch;
    private int mLaunchTimeOut;
    String mLauncherPackageName;
    private final Object mLock;
    Handler mPerfHandler;
    public PowerAdvisorInternal mPowerAdvisorInternal;
    final ProcessMap<WindowProcessController> mPrefetchProcessNames;
    public WindowProcessController mPreviousVrProcess;
    public long mPreviousVrProcessVisibleTime;
    final ProcessMap<WindowProcessController> mProcessFrozenNames;
    private RootActivityContainerSmtBase mRacSmtBase;
    private boolean mReleaseInQueue;
    Runnable mReleaseRunnable;
    private final ArraySet<Integer> mResumedUids;
    private final Object mResumedUidsLock;
    private RootWindowContainerSmtBase mRwcSmtBase;
    private final ArraySet<Integer> mSetResumedUids;
    public boolean uiFirstSwitch;
    final List<WindowProcessController> unFreezeAppsForVisibility;
    public Handler warmStartHandler;

    public static /* synthetic */ void $r8$lambda$zuQIDiAnVTIIlWOWTddptyZFNGY(ActivityRecord[] r0, Task r1) {
        lambda$getLast3DActivity$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fputmReleaseInQueue, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9690$$Nest$fputmReleaseInQueue(ActivityTaskManagerServiceSmtBase r0, boolean r1) {
        r0.mReleaseInQueue = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mreleasePerfLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9691$$Nest$mreleasePerfLock(ActivityTaskManagerServiceSmtBase r0) {
        r0.releasePerfLock();
    }

    static {
        mIsPerfBoost_V5_Acquired = false;
        mIsPerfLockAcquired = false;
    }

    public ActivityTaskManagerServiceSmtBase(ActivityTaskManagerService atmServices) {
        this.mPerfHandler = new Handler();
        this.mBoostWhiteListEnabled = true;
        this.mLaunchTimeOut = 2000;
        this.boost_v5_TimeOut = 2000;
        this.mDefaultBoostTimeOut = 2000;
        this.mBoostUid = -1;
        this.mLock = new Object();
        this.uiFirstSwitch = true;
        this.mPreviousVrProcess = null;
        this.mPreviousVrProcessVisibleTime = 0;
        this.mHandler = null;
        this.mControllerLock = new Object();
        this.mControllerSmt = null;
        this.mControllerIsAMonkeySmt = false;
        this.mProcessFrozenNames = new ProcessMap();
        this.mPrefetchProcessNames = new ProcessMap();
        this.unFreezeAppsForVisibility = new ArrayList();
        this.mReleaseRunnable = new AnonymousClass1(this);
        this.mResumedUidsLock = new Object();
        this.mResumedUids = new ArraySet();
        this.mSetResumedUids = new ArraySet();
        this.mAtmServices = atmServices;
        SysOptBridge.getFactory().getAtmOptEx().init(atmServices);
        this.mHandler = new Handler(BackgroundThread.getHandler().getLooper());
        HandlerThread warmStartThread = new HandlerThread("warmStartThread", 0);
        warmStartThread.start();
        this.warmStartHandler = new Handler(warmStartThread.getLooper());
        Process.setUIFirstSchedEventTrack(Process.myPid(), warmStartThread.getThreadId(), 2, "warmStartThread", false, 0);
    }

    public void setAMS(ActivityManagerService ams) {
        this.mAMS = ams;
    }

    private boolean isWarmStartSvpEnabled() {
        return SysOptBridge.getFactory().getResMngConfig().isModuleEnable(IResMngConfig.FEAT_CPU_OPTIMIZE, IResMngConfig.MOD_SVP_SCENARIO_LIMIT_EXEMPT);
    }

    public int setSvpBeforeUnfreeze(String packageName, int uid) {
        if (isWarmStartSvpEnabled() == true) goto L22;
        return 0;
    L22:
        ProcessRecord pr = SysOptBridge.getFactory().getApplicationFreezer().get(packageName, uid);     // Catch: Exception -> L16
        if (pr != null) goto L8;
        return 0;
    L8:
        int unfreezedPid = pr.getSmtEx().getPid();     // Catch: Exception -> L16
        if (unfreezedPid == 0) goto L19;
        Slog.i(TAG, "set svp before unfreeze pid: " + unfreezedPid + " package: " + packageName);     // Catch: Exception -> L16
        Process.setUIFirstSchedEventTrack(unfreezedPid, unfreezedPid, 2, packageName, true, 2);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Exception e = e;
    L20:
        Slog.e(TAG, "set svp before unfreeze exception: " + e);
        return 0;
    L19:
        return unfreezedPid;
    L16:
        e = move-exception;
        e = e;
        goto L20
    }

    public void clearSvpBeforeUnfreeze(int unfreezedPid, int callingPid) {
        if (unfreezedPid == 0) goto L6;
        if (unfreezedPid == callingPid) goto L6;
        Process.setUIFirstSchedEventTrack(unfreezedPid, unfreezedPid, -1, null, true, 0);
        return;
    }

    public void hotStartSvpSetting(Task targetTask, ActivityRecord startActivity, int unfreezedPid) {
        if (isWarmStartSvpEnabled() == true) goto L6;
        return;
    L6:
        if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(targetTask.prefetchState) == false) goto L8;
        return;
    L8:
        PackageManagerInternal pmInternal = this.mAtmServices.getPackageManagerInternalLocked();
        if (pmInternal != null) goto L11;
        return;
    L11:
        int uid = pmInternal.getPackageUid(startActivity.packageName, 0, startActivity.mUserId);
        if (this.mAtmServices.mAmInternal.hotWarmStartSvpSettingIfCached(startActivity.packageName, uid, 2, unfreezedPid) == true) goto L15;
        this.warmStartHandler.sendMessageAtFrontOfQueue(PooledLambda.obtainMessage(new ActivityTaskManagerServiceSmtBase$$ExternalSyntheticLambda0(), this.mAtmServices.mAmInternal, startActivity.packageName, Integer.valueOf(uid), 2, Integer.valueOf(unfreezedPid)));
        return;
    }

    public void warmStartSvpSetting(Task targetRootTask, ActivityRecord startActivity, int unfreezedPid) {
        if (isWarmStartSvpEnabled() == true) goto L6;
        return;
    L6:
        if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(targetRootTask.prefetchState) == false) goto L8;
        return;
    L8:
        PackageManagerInternal pmInternal = this.mAtmServices.getPackageManagerInternalLocked();
        if (pmInternal != null) goto L11;
        return;
    L11:
        int uid = pmInternal.getPackageUid(startActivity.packageName, 0, startActivity.mUserId);
        if (this.mAtmServices.mAmInternal.hotWarmStartSvpSettingIfCached(startActivity.packageName, uid, 2, unfreezedPid) == true) goto L15;
        this.warmStartHandler.sendMessageAtFrontOfQueue(PooledLambda.obtainMessage(new ActivityTaskManagerServiceSmtBase$$ExternalSyntheticLambda0(), this.mAtmServices.mAmInternal, startActivity.packageName, Integer.valueOf(uid), 2, Integer.valueOf(unfreezedPid)));
        return;
    }

    public boolean isColdLaunch() {
        return this.mIsColdLaunch;
    }

    public void setIsColdLaunch(boolean value) {
        this.mIsColdLaunch = value;
    }

    WindowProcessController getFrozenProcessController(String processName, int uid) {
        return (WindowProcessController) this.mProcessFrozenNames.get(processName, uid);
    }

    boolean isPrefetchProcess(String processName, int uid) {
        if (this.mPrefetchProcessNames.get(processName, uid) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void perfLockRelease(long delay) {
        if (delay > 0) goto L7;
        releasePerfLock();
        return;
    L7:
        if (mIsPerfBoost_V5_Acquired == true) goto L9;
        return;
    L9:
        this.mReleaseInQueue = true;
        this.mPerfHandler.postDelayed(this.mReleaseRunnable, delay);
    }

    private void releasePerfLock() {
        if (mPerfBoost_V5 == null) goto L15;
        BoostFramework r0 = mPerfBoost_V5;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (mIsPerfBoost_V5_Acquired == false) goto L11;
        mIsPerfBoost_V5_Acquired = false;     // Catch: Throwable -> L9
        mPerfBoost_V5.perfLockRelease();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    }

    public boolean isVrActivity(ActivityRecord r) {
        Display dp = getDisplay(r.getDisplayId());
        if (dp != null) goto L5;
        return false;
    L5:
        if (dp.getType() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public WindowProcessController getPreviousVrProcess() {
        WindowManagerGlobalLock r0 = this.mAtmServices.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowProcessController r1 = this.mPreviousVrProcess;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return r1;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void dumpVrPreviousInfo(String dumpPackage, boolean needSep, PrintWriter pw, boolean dumpAll) {
        if (this.mPreviousVrProcess == null) goto L11;
        if (dumpPackage != null) goto L6;
    L7:
        if (needSep == false) goto L9;
        pw.println();
    L9:
        pw.println("  mPreviousVrProcess: " + this.mPreviousVrProcess);
        goto L11
    L6:
        if (this.mPreviousVrProcess.mPkgList.contains(dumpPackage) == true) goto L7;
    L11:
        if (dumpAll == true) goto L13;
        return;
    L13:
        if (this.mPreviousVrProcess == null) goto L17;
        if (dumpPackage == null) goto L17;
        if (this.mPreviousVrProcess.mPkgList.contains(dumpPackage) == true) goto L17;
        return;
    L17:
        StringBuilder sb = new StringBuilder(128);
        sb.append("  mPreviousVrProcessVisibleTime: ");
        TimeUtils.formatDuration(this.mPreviousVrProcessVisibleTime, sb);
        pw.println(sb);
    }

    public Display getDisplay(int displayId) {
        if (this.mDisplayManager != null) goto L6;
        this.mDisplayManager = (DisplayManager) this.mAtmServices.mContext.getSystemService("display");
    L6:
        if (this.mDisplayManager != null) goto L8;
        return null;
    L8:
        return this.mDisplayManager.getDisplay(displayId);
    }

    public void updateTopResumedActivityToSingle3DApp(ActivityRecord topResumedActivity) {
    }

    public ApplicationInfo getTopApplication() {
        return null;
    }

    public ActivityRecord getLast3DActivity() {
        final ActivityRecord[] lastResumedActivity = new ActivityRecord[1];
        WindowManagerGlobalLock r1 = this.mAtmServices.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        DisplayContent defaultdisplaycontent = this.mAtmServices.mRootWindowContainer.getDisplayContent(0);     // Catch: Throwable -> L7
        if (defaultdisplaycontent == null) goto L9;
        defaultdisplaycontent.forAllTasks(new ActivityTaskManagerServiceSmtBase$$ExternalSyntheticLambda1(lastResumedActivity));     // Catch: Throwable -> L7
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        if (lastResumedActivity[0] != null) goto L20;
        return null;
    L20:
        return lastResumedActivity[0];
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$getLast3DActivity$0(ActivityRecord[] lastResumedActivity, Task task) {
        ActivityRecord curActivity = task.getTopResumedActivity();
        if (curActivity != null) goto L5;
        return;
    L5:
        if (curActivity.getDisplayId() != 0) goto L9;
        lastResumedActivity[0] = curActivity;
        return;
    }

    public void perfLockAcquire(String pkg_name) {
        if (mPerfBoost_V5 != null) goto L16;
        ActivityTaskManagerService r0 = this.mAtmServices;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (mPerfBoost_V5 != null) goto L11;
        mPerfBoost_V5 = new BoostFramework();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
    L16:
        if (mPerfBoost_V5 == null) goto L35;
        BoostFramework r1 = mPerfBoost_V5;
        monitor-enter(r1);
    L22:
        th = move-exception;
        throw th;
    L20:
        if (this.mReleaseInQueue == false) goto L25;
        this.mPerfHandler.removeCallbacks(this.mReleaseRunnable);     // Catch: Throwable -> L22
        this.mReleaseInQueue = false;     // Catch: Throwable -> L22
        mIsPerfBoost_V5_Acquired = false;     // Catch: Throwable -> L22
    L25:
        if (mIsPerfBoost_V5_Acquired == false) goto L27;
    L31:
        monitor-exit(r1);     // Catch: Throwable -> L22
        return;
    L27:
        if (this.mIsColdLaunch == false) goto L29;
        this.mLaunchTimeOut = this.boost_v5_TimeOut;     // Catch: Throwable -> L22
    L30:
        mPerfBoost_V5.perfHint(4225, pkg_name, this.mLaunchTimeOut, 8);     // Catch: Throwable -> L22
        mIsPerfBoost_V5_Acquired = true;     // Catch: Throwable -> L22
        perfLockRelease(this.mLaunchTimeOut);     // Catch: Throwable -> L22
        goto L31
    L29:
        this.mLaunchTimeOut = this.mDefaultBoostTimeOut;     // Catch: Throwable -> L22
        goto L30
    }

    public void adjustHomePrevProcess(ActivityRecord resuming, ActivityRecord prev) {
        if (resuming != null) goto L4;
        return;
    L4:
        if (resuming.isActivityTypeHome() == false) goto L8;
        this.mHomePreviousProcess = prev.app;
        return;
    }

    public void onCleanUpApplicationRecord(WindowProcessController proc) {
        if (proc != this.mHomePreviousProcess) goto L6;
        this.mHomePreviousProcess = null;
        return;
    }

    public String isAnyDisplayStackTop(String pkg) {
        WindowManagerGlobalLock r0 = this.mAtmServices.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mRwcSmtBase == null) goto L7;
        String r1 = this.mRwcSmtBase.isAnyDisplayTaskTopLocked(pkg);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return r1;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return "mRwcSmtBase is null";
    }

    public void updateTopDisplayType(ActivityRecord top) {
        if (top != null) goto L4;
        return;
    L4:
        if (top.app == null) goto L8;
        getDisplay(top.getDisplayId());
        return;
    }

    public void notifyAppVisible(String packageName, boolean visible, int uid) {
        if (this.mPowerAdvisorInternal != null) goto L6;
        this.mPowerAdvisorInternal = (PowerAdvisorInternal) LocalServices.getService(PowerAdvisorInternal.class);
    L6:
        if (uid == 1000) goto L10;
        if (UserHandle.isApp(uid) == true) goto L10;
        return;
    L10:
        if (this.mPowerAdvisorInternal == null) goto L14;
        this.mPowerAdvisorInternal.notifyAppVisible(packageName, visible);
        return;
    }

    void onUserUnlocked(int user) {
        initLauncherPackageName(user);
    }

    String getLauncherPackageName() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = this.mLauncherPackageName;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void initLauncherPackageName(int user) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (user == this.mCurrentUser) goto L10;
        this.mLauncherPackageName = null;     // Catch: Throwable -> L7
        this.mCurrentUser = user;     // Catch: Throwable -> L7
    L10:
        if (this.mLauncherPackageName == null) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L13:
        Intent intent = new Intent("android.intent.action.MAIN");     // Catch: Throwable -> L7
        intent.addCategory("android.intent.category.HOME");     // Catch: Throwable -> L7
        intent.addCategory("android.intent.category.LAUNCHER_APP");     // Catch: Throwable -> L7
        ResolveInfo resolveInfo = this.mAtmServices.mContext.getPackageManager().resolveActivity(intent, 65536);     // Catch: Throwable -> L7
        if (resolveInfo == null) goto L16;
        this.mLauncherPackageName = resolveInfo.activityInfo.packageName;     // Catch: Throwable -> L7
        Slog.i(TAG, "set launcher pkg=" + this.mLauncherPackageName);     // Catch: Throwable -> L7
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void updateResumedUid(int uid, boolean isResumed) {
        Object r0 = this.mResumedUidsLock;
        monitor-enter(r0);
        if (isResumed == false) goto L8;
        this.mResumedUids.add(Integer.valueOf(uid));     // Catch: Throwable -> L6
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        this.mResumedUids.remove(Integer.valueOf(uid));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public void updateSetResumedUid(int uid, boolean isResumed) {
        Object r0 = this.mResumedUidsLock;
        monitor-enter(r0);
        if (isResumed == false) goto L8;
        this.mSetResumedUids.add(Integer.valueOf(uid));     // Catch: Throwable -> L6
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        this.mSetResumedUids.remove(Integer.valueOf(uid));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public boolean hasResumedActivity(int uid) {
        Object r0 = this.mResumedUidsLock;
        monitor-enter(r0);
        boolean r1 = this.mResumedUids.contains(Integer.valueOf(uid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean hasSetResumedActivity(int uid) {
        Object r0 = this.mResumedUidsLock;
        monitor-enter(r0);
        boolean r1 = this.mSetResumedUids.contains(Integer.valueOf(uid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public ActivityRecord resolveReusableActivityRecord(ActivityRecord r) {
        if ("android.intent.action.MAIN".equals(r.intent.getAction()) == true) goto L5;
    L67:
        return null;
    L5:
        if (r.intent.hasCategory("android.intent.category.LAUNCHER") == false) goto L67;
        if (r.getOptions() != null) goto L10;
    L18:
        TaskDisplayArea preferredTaskDisplayArea = this.mAtmServices.mRootWindowContainer.getDefaultTaskDisplayArea();
        boolean r4 = true;
        if ((r.intent.getFlags() & 268435456) == 0) goto L23;
        if ((r.intent.getFlags() & 134217728) != 0) goto L23;
    L28:
        boolean putIntoExistingTask = true;
    L30:
        if (r.resultTo != null) goto L32;
        boolean r6 = true;
    L33:
        boolean putIntoExistingTask2 = putIntoExistingTask & r6;
        ActivityRecord intentActivity = null;
        if (putIntoExistingTask2 == true) goto L36;
    L52:
        if (intentActivity != null) goto L54;
    L58:
        if (intentActivity != null) goto L60;
        return intentActivity;
    L60:
        if (r.isActivityTypeHome() == true) goto L64;
        if (intentActivity.isActivityTypeHome() == true) goto L64;
        return intentActivity;
    L64:
        if (intentActivity.getDisplayArea() == preferredTaskDisplayArea) goto L70;
        return null;
    L70:
        return intentActivity;
    L54:
        if (r.launchMode != 4) goto L58;
        if (intentActivity.getTask().getRootActivity().mActivityComponent.equals(r.mActivityComponent) == true) goto L58;
        intentActivity = null;
        goto L58
    L36:
        if (3 != r.launchMode) goto L45;
        intentActivity = this.mAtmServices.mRootWindowContainer.findActivity(r.intent, r.info, false);
        if (intentActivity == null) goto L52;
        if (r.isActivityTypeHome() == false) goto L52;
        if (intentActivity.isActivityTypeHome() == true) goto L52;
        intentActivity = null;
        goto L52
    L45:
        if ((r.intent.getFlags() & 4096) == 0) goto L51;
        RootWindowContainer r3 = this.mAtmServices.mRootWindowContainer;
        Intent r7 = r.intent;
        ActivityInfo r8 = r.info;
        if (2 != r.launchMode) goto L50;
        r4 = false;
    L50:
        intentActivity = r3.findActivity(r7, r8, r4);
        goto L52
    L51:
        intentActivity = this.mAtmServices.mRootWindowContainer.findTask(r, preferredTaskDisplayArea, false);
        goto L52
    L32:
        r6 = false;
    L23:
        if (3 == r.launchMode) goto L28;
        if (2 == r.launchMode) goto L28;
        putIntoExistingTask = false;
        goto L30
    L10:
        if (r.getOptions().getLaunchTaskId() == (-1)) goto L18;
        Task launchTask = this.mAtmServices.mRootWindowContainer.anyTaskForId(r.getOptions().getLaunchTaskId());
        if (launchTask != null) goto L14;
    L17:
        return null;
    L14:
        if (launchTask.isLeafTask() == false) goto L17;
        return launchTask.getTopNonFinishingActivity();
    }

    public void setControllerLocked(IActivityController controller, boolean controllerIsAMonkey) {
        Object r0 = this.mControllerLock;
        monitor-enter(r0);
        this.mControllerSmt = controller;     // Catch: Throwable -> L7
        this.mControllerIsAMonkeySmt = controllerIsAMonkey;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    int getLauncherLoaderTid(int launcherPid) {
        File tasksDir = new File("/proc/" + launcherPid + "/task/");
        if (tasksDir.exists() == true) goto L5;
        return -1;
    L5:
        String[] r1 = tasksDir.list();
        int r5 = r1.length;
        int r6 = 0;
    L6:
        if (r6 >= r5) goto L18;
        String tidStr = r1[r6];
        int tid = Integer.parseInt(tidStr);     // Catch: Exception -> L13
        File commFile = new File("/proc/" + launcherPid + "/task/" + tid + "/comm");     // Catch: Exception -> L13
        if (commFile.exists() == false) goto L17;
        BufferedReader reader = new BufferedReader(new FileReader(commFile));     // Catch: Exception -> L13
        String threadName = reader.readLine().trim();     // Catch: Exception -> L13
        if ("launcher-loader".equals(threadName) == false) goto L17;
        return tid;
    L17:
        r6 = r6 + 1;
    L13:
        e = move-exception;
        Slog.e(TAG, "getLauncherLoaderTid launcherPid = " + launcherPid, e);
        goto L17
    L18:
        return -1;
    }

    public boolean isControllerAMonkeySmt() {
        Object r0 = this.mControllerLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mControllerSmt != null) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mControllerIsAMonkeySmt == false) goto L11;
        r1 = true;
        goto L12
    }
}
