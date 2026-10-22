package com.android.server.wm;

import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.app.TaskInfo;
import android.app.admin.DevicePolicyManagerInternal;
import android.content.ComponentName;
import android.content.Context;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.content.pm.SuspendDialogInfo;
import android.content.pm.UserInfo;
import android.content.pm.UserPackage;
import android.os.Bundle;
import android.os.IBinder;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.app.BlockedAppActivity;
import com.android.internal.app.HarmfulAppWarningActivity;
import com.android.internal.app.SuspendedAppActivity;
import com.android.internal.app.UnlaunchableAppActivity;
import com.android.server.LocalServices;
import com.android.server.pm.PackageManagerService;

/* JADX INFO: loaded from: classes3.dex */
class ActivityStartInterceptor {
    private static final String TAG = "ActivityStartInterceptor";
    ActivityInfo mAInfo;
    ActivityOptions mActivityOptions;
    private String mCallingFeatureId;
    private String mCallingPackage;
    int mCallingPid;
    int mCallingUid;
    boolean mComponentSpecified;
    Task mInTask;
    TaskFragment mInTaskFragment;
    Intent mIntent;
    TaskDisplayArea mPresumableLaunchDisplayArea;
    ResolveInfo mRInfo;
    private int mRealCallingPid;
    private int mRealCallingUid;
    String mResolvedType;
    private final ActivityTaskManagerService mService;
    private final Context mServiceContext;
    private int mStartFlags;
    private final ActivityTaskSupervisor mSupervisor;
    private int mUserId;
    private UserManager mUserManager;

    public static /* synthetic */ void $r8$lambda$wLcdO_nNod9fIYt5LBDXTWNyY3Q(ActivityStartInterceptor r0, ActivityRecord r1) {
        r0.lambda$onActivityLaunched$0(r1);
    }

    ActivityStartInterceptor(ActivityTaskManagerService service, ActivityTaskSupervisor supervisor) {
        this(service, supervisor, service.mContext);
    }

    ActivityStartInterceptor(ActivityTaskManagerService service, ActivityTaskSupervisor supervisor, Context context) {
        this.mService = service;
        this.mSupervisor = supervisor;
        this.mServiceContext = context;
    }

    void setStates(int userId, int realCallingPid, int realCallingUid, int startFlags, String callingPackage, String callingFeatureId) {
        this.mRealCallingPid = realCallingPid;
        this.mRealCallingUid = realCallingUid;
        this.mUserId = userId;
        this.mStartFlags = startFlags;
        this.mCallingPackage = callingPackage;
        this.mCallingFeatureId = callingFeatureId;
    }

    private IntentSender createIntentSenderForOriginalIntent(int callingUid, int flags) {
        ActivityOptions activityOptions = deferCrossProfileAppsAnimationIfNecessary();
        activityOptions.setPendingIntentCreatorBackgroundActivityStartMode(1);
        TaskFragment taskFragment = getLaunchTaskFragment();
        if (taskFragment == null) goto L5;
        activityOptions.setLaunchTaskFragmentToken(taskFragment.getFragmentToken());
    L5:
        IIntentSender target = this.mService.getIntentSenderLocked(2, this.mCallingPackage, this.mCallingFeatureId, callingUid, this.mUserId, null, null, 0, new Intent[]{this.mIntent}, new String[]{this.mResolvedType}, flags, activityOptions.toBundle());
        return new IntentSender(target);
    }

    private TaskFragment getLaunchTaskFragment() {
        if (this.mInTaskFragment == null) goto L7;
        return this.mInTaskFragment;
    L7:
        if (this.mActivityOptions != null) goto L9;
        return null;
    L9:
        IBinder taskFragToken = this.mActivityOptions.getLaunchTaskFragmentToken();
        if (taskFragToken != null) goto L13;
        return null;
    L13:
        return TaskFragment.fromTaskFragmentToken(taskFragToken, this.mService);
    }

    boolean intercept(Intent intent, ResolveInfo rInfo, ActivityInfo aInfo, String resolvedType, Task inTask, TaskFragment inTaskFragment, int callingPid, int callingUid, ActivityOptions activityOptions, TaskDisplayArea presumableLaunchDisplayArea) {
        return intercept(intent, rInfo, aInfo, resolvedType, inTask, inTaskFragment, callingPid, callingUid, activityOptions, presumableLaunchDisplayArea, false);
    }

    boolean intercept(Intent intent, ResolveInfo rInfo, ActivityInfo aInfo, String resolvedType, Task inTask, TaskFragment inTaskFragment, int callingPid, int callingUid, ActivityOptions activityOptions, TaskDisplayArea presumableLaunchDisplayArea, boolean componentSpecified) {
        this.mUserManager = UserManager.get(this.mServiceContext);
        this.mIntent = intent;
        this.mCallingPid = callingPid;
        this.mCallingUid = callingUid;
        this.mRInfo = rInfo;
        this.mAInfo = aInfo;
        this.mResolvedType = resolvedType;
        this.mInTask = inTask;
        this.mInTaskFragment = inTaskFragment;
        this.mActivityOptions = activityOptions;
        this.mPresumableLaunchDisplayArea = presumableLaunchDisplayArea;
        this.mComponentSpecified = componentSpecified;
        if (interceptQuietProfileIfNeeded() == false) goto L6;
        return true;
    L6:
        if (interceptSuspendedPackageIfNeeded() == false) goto L9;
        return true;
    L9:
        if (interceptLockTaskModeViolationPackageIfNeeded() == false) goto L12;
        return true;
    L12:
        if (interceptHarmfulAppIfNeeded() == false) goto L15;
        return true;
    L15:
        if (interceptLockedProfileIfNeeded() == false) goto L18;
        return true;
    L18:
        if (interceptHomeIfNeeded() == false) goto L20;
        return true;
    L20:
        SparseArray<ActivityInterceptorCallback> callbacks = this.mService.getActivityInterceptorCallbacks();
        ActivityInterceptorCallback.ActivityInterceptorInfo interceptorInfo = getInterceptorInfo(null);
        int i = 0;
    L22:
        if (i >= callbacks.size()) goto L31;
        ActivityInterceptorCallback callback = callbacks.valueAt(i);
        ActivityInterceptorCallback.ActivityInterceptResult interceptResult = callback.onInterceptActivityLaunch(interceptorInfo);
        if (interceptResult != null) goto L26;
        i = i + 1;
        goto L22
    L26:
        this.mIntent = interceptResult.getIntent();
        this.mActivityOptions = interceptResult.getActivityOptions();
        this.mCallingPid = this.mRealCallingPid;
        this.mCallingUid = this.mRealCallingUid;
        this.mService.mAmInternal.addCreatorToken(this.mIntent, this.mCallingPackage);
        if (interceptResult.isActivityResolved() == false) goto L29;
        return true;
    L29:
        this.mRInfo = this.mSupervisor.resolveIntent(this.mIntent, null, this.mUserId, 0, this.mRealCallingUid, this.mRealCallingPid);
        this.mAInfo = this.mSupervisor.resolveActivity(this.mIntent, this.mRInfo, this.mStartFlags, null);
        return true;
    L31:
        return false;
    }

    private boolean hasCrossProfileAnimation() {
        if (this.mActivityOptions != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mActivityOptions.getAnimationType() != 12) goto L7;
        return true;
    }

    private ActivityOptions deferCrossProfileAppsAnimationIfNecessary() {
        if (hasCrossProfileAnimation() == false) goto L7;
        this.mActivityOptions = null;
        return ActivityOptions.makeOpenCrossProfileAppsAnimation();
    L7:
        return ActivityOptions.makeBasic();
    }

    private boolean interceptQuietProfileIfNeeded() {
        if (this.mUserManager.isQuietModeEnabled(UserHandle.of(this.mUserId)) == true) goto L6;
        return false;
    L6:
        Slog.i(TAG, "Intent : " + this.mIntent + " intercepted for user: " + this.mUserId + " because quiet mode is enabled.");
        IntentSender target = createIntentSenderForOriginalIntent(this.mCallingUid, 1342177280);
        this.mIntent = UnlaunchableAppActivity.createInQuietModeDialogIntent(this.mUserId, target, this.mRInfo);
        this.mCallingPid = this.mRealCallingPid;
        this.mCallingUid = this.mRealCallingUid;
        this.mResolvedType = null;
        UserInfo parent = this.mUserManager.getProfileParent(this.mUserId);
        this.mRInfo = this.mSupervisor.resolveIntent(this.mIntent, this.mResolvedType, parent.id, 0, this.mRealCallingUid, this.mRealCallingPid);
        this.mAInfo = this.mSupervisor.resolveActivity(this.mIntent, this.mRInfo, this.mStartFlags, null);
        return true;
    }

    private boolean interceptSuspendedByAdminPackage() {
        DevicePolicyManagerInternal devicePolicyManager = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        if (devicePolicyManager != null) goto L6;
        return false;
    L6:
        this.mIntent = devicePolicyManager.createShowAdminSupportIntent(this.mUserId, true);
        this.mIntent.putExtra("android.app.extra.RESTRICTION", "policy_suspend_packages");
        this.mCallingPid = this.mRealCallingPid;
        this.mCallingUid = this.mRealCallingUid;
        this.mResolvedType = null;
        UserInfo parent = this.mUserManager.getProfileParent(this.mUserId);
        if (parent == null) goto L9;
        this.mRInfo = this.mSupervisor.resolveIntent(this.mIntent, this.mResolvedType, parent.id, 0, this.mRealCallingUid, this.mRealCallingPid);
    L10:
        this.mAInfo = this.mSupervisor.resolveActivity(this.mIntent, this.mRInfo, this.mStartFlags, null);
        return true;
    L9:
        this.mRInfo = this.mSupervisor.resolveIntent(this.mIntent, this.mResolvedType, this.mUserId, 0, this.mRealCallingUid, this.mRealCallingPid);
        goto L10
    }

    private boolean interceptSuspendedPackageIfNeeded() {
        if (isPackageSuspended() == true) goto L5;
        return false;
    L5:
        PackageManagerInternal pmi = this.mService.getPackageManagerInternalLocked();
        if (pmi != null) goto L8;
        return false;
    L8:
        String suspendedPackage = this.mAInfo.applicationInfo.packageName;
        UserPackage suspender = pmi.getSuspendingPackage(suspendedPackage, this.mUserId);
        if (suspender != null) goto L11;
    L14:
        SuspendDialogInfo dialogInfo = pmi.getSuspendedDialogInfo(suspendedPackage, suspender, this.mUserId);
        if (hasCrossProfileAnimation() == false) goto L17;
        Bundle crossProfileOptions = ActivityOptions.makeOpenCrossProfileAppsAnimation().toBundle();
    L18:
        IntentSender target = createIntentSenderForOriginalIntent(this.mCallingUid, 67108864);
        this.mIntent = SuspendedAppActivity.createSuspendedAppInterceptIntent(suspendedPackage, suspender, dialogInfo, crossProfileOptions, target, this.mUserId);
        this.mCallingPid = this.mRealCallingPid;
        this.mCallingUid = this.mRealCallingUid;
        this.mResolvedType = null;
        this.mRInfo = this.mSupervisor.resolveIntent(this.mIntent, this.mResolvedType, this.mUserId, 0, this.mRealCallingUid, this.mRealCallingPid);
        this.mAInfo = this.mSupervisor.resolveActivity(this.mIntent, this.mRInfo, this.mStartFlags, null);
        return true;
    L17:
        crossProfileOptions = null;
        goto L18
    L11:
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(suspender.packageName) == false) goto L14;
        return interceptSuspendedByAdminPackage();
    }

    private boolean interceptLockTaskModeViolationPackageIfNeeded() {
        if (this.mAInfo != null) goto L5;
    L12:
        return false;
    L5:
        if (this.mAInfo.applicationInfo == null) goto L12;
        LockTaskController controller = this.mService.getLockTaskController();
        String packageName = this.mAInfo.applicationInfo.packageName;
        int lockTaskLaunchMode = ActivityRecord.getLockTaskLaunchMode(this.mAInfo, this.mActivityOptions);
        if (controller.isActivityAllowed(this.mUserId, packageName, lockTaskLaunchMode) == false) goto L10;
        return false;
    L10:
        this.mIntent = BlockedAppActivity.createIntent(this.mUserId, this.mAInfo.applicationInfo.packageName);
        this.mCallingPid = this.mRealCallingPid;
        this.mCallingUid = this.mRealCallingUid;
        this.mResolvedType = null;
        this.mRInfo = this.mSupervisor.resolveIntent(this.mIntent, this.mResolvedType, this.mUserId, 0, this.mRealCallingUid, this.mRealCallingPid);
        this.mAInfo = this.mSupervisor.resolveActivity(this.mIntent, this.mRInfo, this.mStartFlags, null);
        return true;
    }

    private boolean interceptLockedProfileIfNeeded() {
        Intent interceptingIntent = interceptWithConfirmCredentialsIfNeeded(this.mAInfo, this.mUserId);
        if (interceptingIntent != null) goto L6;
        return false;
    L6:
        this.mIntent = interceptingIntent;
        this.mCallingPid = this.mRealCallingPid;
        this.mCallingUid = this.mRealCallingUid;
        this.mResolvedType = null;
        TaskFragment taskFragment = getLaunchTaskFragment();
        if (this.mInTask == null) goto L9;
        this.mIntent.putExtra("android.intent.extra.TASK_ID", this.mInTask.mTaskId);
        this.mInTask = null;
    L14:
        if (this.mActivityOptions != null) goto L16;
        this.mActivityOptions = ActivityOptions.makeBasic();
    L16:
        UserInfo parent = this.mUserManager.getProfileParent(this.mUserId);
        this.mRInfo = this.mSupervisor.resolveIntent(this.mIntent, this.mResolvedType, parent.id, 0, this.mRealCallingUid, this.mRealCallingPid);
        this.mAInfo = this.mSupervisor.resolveActivity(this.mIntent, this.mRInfo, this.mStartFlags, null);
        return true;
    L9:
        if (taskFragment == null) goto L14;
        Task parentTask = taskFragment.getTask();
        if (parentTask == null) goto L14;
        this.mIntent.putExtra("android.intent.extra.TASK_ID", parentTask.mTaskId);
        goto L14
    }

    private Intent interceptWithConfirmCredentialsIfNeeded(ActivityInfo aInfo, int userId) {
        if (this.mService.mAmInternal.shouldConfirmCredentials(userId) == true) goto L6;
        return null;
    L6:
        if ((aInfo.flags & 8388608) != 0) goto L8;
    L12:
        IntentSender target = createIntentSenderForOriginalIntent(this.mCallingUid, 1409286144);
        KeyguardManager km = (KeyguardManager) this.mServiceContext.getSystemService("keyguard");
        Intent newIntent = km.createConfirmDeviceCredentialIntent(null, null, userId, true);
        if (newIntent != null) goto L15;
        return null;
    L15:
        newIntent.setFlags(276840448);
        newIntent.putExtra("android.intent.extra.PACKAGE_NAME", aInfo.packageName);
        newIntent.putExtra("android.intent.extra.INTENT", target);
        return newIntent;
    L8:
        if (this.mUserManager.isUserUnlocked(userId) == false) goto L10;
    L11:
        return null;
    L10:
        if (aInfo.directBootAware == false) goto L12;
        goto L11
    }

    private boolean interceptHarmfulAppIfNeeded() {
        CharSequence harmfulAppWarning = this.mService.getPackageManager().getHarmfulAppWarning(this.mAInfo.packageName, this.mUserId);     // Catch: Throwable -> L8
        if (harmfulAppWarning != null) goto L6;
        return false;
    L6:
        IntentSender target = createIntentSenderForOriginalIntent(this.mCallingUid, 1409286144);
        this.mIntent = HarmfulAppWarningActivity.createHarmfulAppWarningIntent(this.mServiceContext, this.mAInfo.packageName, target, harmfulAppWarning);
        this.mCallingPid = this.mRealCallingPid;
        this.mCallingUid = this.mRealCallingUid;
        this.mResolvedType = null;
        this.mRInfo = this.mSupervisor.resolveIntent(this.mIntent, this.mResolvedType, this.mUserId, 0, this.mRealCallingUid, this.mRealCallingPid);
        this.mAInfo = this.mSupervisor.resolveActivity(this.mIntent, this.mRInfo, this.mStartFlags, null);
        return true;
    L9:
        return false;
    }

    private boolean interceptHomeIfNeeded() {
        if (this.mPresumableLaunchDisplayArea != null) goto L5;
    L35:
        return false;
    L5:
        if (this.mService.mRootWindowContainer == null) goto L35;
        boolean intercepted = false;
        if ("android.intent.action.MAIN".equals(this.mIntent.getAction()) == true) goto L10;
    L34:
        return false;
    L10:
        if (this.mIntent.hasCategory("android.intent.category.HOME") == true) goto L15;
        if (this.mIntent.hasCategory("android.intent.category.SECONDARY_HOME") == false) goto L34;
    L15:
        if (this.mComponentSpecified == false) goto L26;
        Slog.w(TAG, "Starting home with component specified, uid=" + this.mCallingUid);
        if (this.mService.isCallerRecents(this.mCallingUid) == false) goto L19;
    L24:
        return false;
    L19:
        if (ActivityTaskManagerService.checkPermission("android.permission.MANAGE_ACTIVITY_TASKS", this.mCallingPid, this.mCallingUid) == 0) goto L24;
        ComponentName homeComponent = this.mIntent.getComponent();
        Intent homeIntent = this.mService.getHomeIntent();
        ActivityInfo aInfo = this.mService.mRootWindowContainer.resolveHomeActivity(this.mUserId, homeIntent);
        if (aInfo.getComponentName().equals(homeComponent) == true) goto L26;
        return false;
    L26:
        if (ActivityRecord.isHomeIntent(this.mIntent) == true) goto L28;
    L29:
        normalizeHomeIntent();
        intercepted = true;
    L30:
        boolean intercepted2 = intercepted | replaceToSecondaryHomeIntentIfNeeded();
        if (intercepted2 == false) goto L33;
        this.mCallingPid = this.mRealCallingPid;
        this.mCallingUid = this.mRealCallingUid;
        this.mResolvedType = null;
        this.mRInfo = this.mSupervisor.resolveIntent(this.mIntent, this.mResolvedType, this.mUserId, 0, this.mRealCallingUid, this.mRealCallingPid);
        this.mAInfo = this.mSupervisor.resolveActivity(this.mIntent, this.mRInfo, this.mStartFlags, null);
    L33:
        return intercepted2;
    L28:
        if (this.mComponentSpecified == false) goto L30;
        goto L29
    }

    private void normalizeHomeIntent() {
        Slog.w(TAG, "The home Intent is not correctly formatted");
        if (this.mIntent.getCategories().size() <= 1) goto L17;
        Slog.d(TAG, "Purge home intent categories");
        boolean isSecondaryHome = false;
        Object[] categories = this.mIntent.getCategories().toArray();
        int i = categories.length - 1;
    L5:
        String r2 = "android.intent.category.SECONDARY_HOME";
        if (i < 0) goto L11;
        String category = (String) categories[i];
        if ("android.intent.category.SECONDARY_HOME".equals(category) == false) goto L10;
        isSecondaryHome = true;
    L10:
        this.mIntent.removeCategory(category);
        i = i - 1;
        goto L5
    L11:
        Intent r4 = this.mIntent;
        if (isSecondaryHome == true) goto L15;
        r2 = "android.intent.category.HOME";
    L15:
        r4.addCategory(r2);
    L17:
        if (this.mIntent.getType() == null) goto L19;
    L20:
        Slog.d(TAG, "Purge home intent data/type");
        this.mIntent.setType(null);
    L22:
        if (this.mComponentSpecified == false) goto L24;
        Slog.d(TAG, "Purge home intent component, " + this.mIntent.getComponent());
        this.mIntent.setComponent(null);
    L24:
        this.mIntent.addFlags(268435456);
        return;
    L19:
        if (this.mIntent.getData() == null) goto L22;
        goto L20
    }

    private boolean replaceToSecondaryHomeIntentIfNeeded() {
        if (this.mIntent.hasCategory("android.intent.category.HOME") == true) goto L6;
        return false;
    L6:
        if (this.mService.mRootWindowContainer.shouldPlacePrimaryHomeOnDisplay(this.mPresumableLaunchDisplayArea.getDisplayId()) == false) goto L9;
        return false;
    L9:
        if (this.mService.mRootWindowContainer.shouldPlaceSecondaryHomeOnDisplayArea(this.mPresumableLaunchDisplayArea) == true) goto L11;
        return false;
    L11:
        Pair<ActivityInfo, Intent> info = this.mService.mRootWindowContainer.resolveSecondaryHomeActivity(this.mUserId, this.mPresumableLaunchDisplayArea);
        this.mIntent = (Intent) info.second;
        this.mIntent.addFlags(268435456);
        return true;
    }

    private boolean isPackageSuspended() {
        if (this.mAInfo != null) goto L5;
    L9:
        return false;
    L5:
        if (this.mAInfo.applicationInfo == null) goto L9;
        if ((this.mAInfo.applicationInfo.flags & 1073741824) == 0) goto L9;
        return true;
    }

    void onActivityLaunched(TaskInfo taskInfo, final ActivityRecord r) {
        SparseArray<ActivityInterceptorCallback> callbacks = this.mService.getActivityInterceptorCallbacks();
        ActivityInterceptorCallback.ActivityInterceptorInfo info = getInterceptorInfo(new ActivityStartInterceptor$$ExternalSyntheticLambda0(this, r));
        int i = 0;
    L4:
        if (i >= callbacks.size()) goto L7;
        ActivityInterceptorCallback callback = callbacks.valueAt(i);
        callback.onActivityLaunched(taskInfo, r.info, info);
        i = i + 1;
        goto L4
    }

    private /* synthetic */ void lambda$onActivityLaunched$0(ActivityRecord r) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        r.clearOptionsAnimationForSiblings();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private ActivityInterceptorCallback.ActivityInterceptorInfo getInterceptorInfo(Runnable clearOptionsAnimation) {
        return new ActivityInterceptorCallback.ActivityInterceptorInfo.Builder(this.mCallingUid, this.mCallingPid, this.mRealCallingUid, this.mRealCallingPid, this.mUserId, this.mIntent, this.mRInfo, this.mAInfo).setResolvedType(this.mResolvedType).setCallingPackage(this.mCallingPackage).setCallingFeatureId(this.mCallingFeatureId).setCheckedOptions(this.mActivityOptions).setClearOptionsAnimationRunnable(clearOptionsAnimation).build();
    }
}
