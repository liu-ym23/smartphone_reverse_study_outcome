package com.android.server.policy;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.AppOpsManager;
import android.app.AppOpsManagerInternal;
import android.app.KeyguardManager;
import android.app.TaskInfo;
import android.app.compat.CompatChanges;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.PermissionInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.permission.LegacyPermissionManager;
import android.permission.PermissionControllerManager;
import android.permission.PermissionManager;
import android.telephony.TelephonyManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.LongSparseLongArray;
import android.util.Slog;
import android.util.SparseBooleanArray;
import com.android.internal.app.IAppOpsCallback;
import com.android.internal.app.IAppOpsService;
import com.android.internal.infra.AndroidFuture;
import com.android.internal.util.IntPair;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.PermissionThread;
import com.android.server.SystemService;
import com.android.server.notification.NotificationManagerInternal;
import com.android.server.pm.Settings;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.permission.PermissionManagerServiceInternal;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.utils.TimingsTraceAndSlog;
import com.android.server.wm.ActivityInterceptorCallback;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class PermissionPolicyService extends SystemService {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = null;
    private static final long NOTIFICATION_PERM_CHANGE_ID = 194833441;
    private static final String SYSTEM_PKG = "android";
    private static final long USER_SENSITIVE_UPDATE_DELAY_MS = 60000;
    private ActivityTaskManagerInternal mActivityTaskManagerInternal;
    private List<String> mAppOpPermissions;
    private IAppOpsCallback mAppOpsCallback;
    private boolean mBootCompleted;
    private Context mContext;
    private final Handler mHandler;
    private final SparseBooleanArray mIsStarted;
    private final SparseBooleanArray mIsUidResetScheduled;
    private final SparseBooleanArray mIsUidSyncScheduled;
    private final KeyguardManager mKeyguardManager;
    private final Object mLock;
    private NotificationManagerInternal mNotificationManager;
    private PermissionPolicyInternal.OnInitializedCallback mOnInitializedCallback;
    private final PackageManager mPackageManager;
    private PackageManagerInternal mPackageManagerInternal;
    private PermissionManagerServiceInternal mPermissionManagerInternal;
    private final ArrayList<PhoneCarrierPrivilegesCallback> mPhoneCarrierPrivilegesCallbacks;
    private final BroadcastReceiver mSimConfigBroadcastReceiver;
    private TelephonyManager mTelephonyManager;

    private class Internal extends PermissionPolicyInternal {
        private final ActivityInterceptorCallback mActivityInterceptorCallback;
        final /* synthetic */ PermissionPolicyService this$0;

        /* JADX INFO: renamed from: com.android.server.policy.PermissionPolicyService$Internal$1, reason: invalid class name */
        class AnonymousClass1 implements ActivityInterceptorCallback {
            final /* synthetic */ Internal this$1;

            public static /* synthetic */ void $r8$lambda$KFNWNgXE65krgQRxKXzqQpupngM(AnonymousClass1 r0, ActivityInfo r1, TaskInfo r2, ActivityInterceptorCallback.ActivityInterceptorInfo r3) {
                r0.lambda$onActivityLaunched$0(r1, r2, r3);
            }

            AnonymousClass1(Internal this$1) {
                this.this$1 = this$1;
            }

            @Override // com.android.server.wm.ActivityInterceptorCallback
            public ActivityInterceptorCallback.ActivityInterceptResult onInterceptActivityLaunch(ActivityInterceptorCallback.ActivityInterceptorInfo info) {
                return null;
            }

            @Override // com.android.server.wm.ActivityInterceptorCallback
            public void onActivityLaunched(final TaskInfo taskInfo, final ActivityInfo activityInfo, final ActivityInterceptorCallback.ActivityInterceptorInfo info) {
                if (Internal.m7183$$Nest$mshouldShowNotificationDialogOrClearFlags(this.this$1, taskInfo, activityInfo.packageName, info.getCallingPackage(), info.getIntent(), info.getCheckedOptions(), activityInfo.name, true) == true) goto L5;
                return;
            L5:
                if (Internal.m7181$$Nest$misNoDisplayActivity(this.this$1, activityInfo, info.getUserId()) == true) goto L13;
                UserHandle user = UserHandle.of(taskInfo.userId);
                if (CompatChanges.isChangeEnabled(PermissionPolicyService.NOTIFICATION_PERM_CHANGE_ID, activityInfo.packageName, user) == true) goto L12;
                PermissionPolicyService.m7160$$Nest$fgetmHandler(this.this$1.this$0).post(new PermissionPolicyService$Internal$1$$ExternalSyntheticLambda0(this, activityInfo, taskInfo, info));
                return;
            L12:
                return;
            }

            private /* synthetic */ void lambda$onActivityLaunched$0(ActivityInfo activityInfo, TaskInfo taskInfo, ActivityInterceptorCallback.ActivityInterceptorInfo info) {
                this.this$1.showNotificationPromptIfNeeded(activityInfo.packageName, taskInfo.userId, taskInfo.taskId, info);
            }
        }

        /* JADX INFO: renamed from: -$$Nest$misNoDisplayActivity, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m7181$$Nest$misNoDisplayActivity(Internal r0, ActivityInfo r1, int r2) {
            return r0.isNoDisplayActivity(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$monActivityManagerReady, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7182$$Nest$monActivityManagerReady(Internal r0) {
            r0.onActivityManagerReady();
        }

        /* JADX INFO: renamed from: -$$Nest$mshouldShowNotificationDialogOrClearFlags, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m7183$$Nest$mshouldShowNotificationDialogOrClearFlags(Internal r0, TaskInfo r1, String r2, String r3, Intent r4, ActivityOptions r5, String r6, boolean r7) {
            return r0.shouldShowNotificationDialogOrClearFlags(r1, r2, r3, r4, r5, r6, r7);
        }

        /* synthetic */ Internal(PermissionPolicyService r1, PermissionPolicyServiceIA r2) {
            this(r1);
        }

        private Internal(PermissionPolicyService r1) {
            this.this$0 = r1;
            this.mActivityInterceptorCallback = new AnonymousClass1(this);
        }

        private void onActivityManagerReady() {
            PermissionPolicyService.m7156$$Nest$fgetmActivityTaskManagerInternal(this.this$0).registerActivityStartInterceptor(1, this.mActivityInterceptorCallback);
        }

        @Override // com.android.server.policy.PermissionPolicyInternal
        public boolean checkStartActivity(Intent intent, int callingUid, String callingPackage) {
            if (callingPackage == null) goto L9;
            if (isActionRemovedForCallingPackage(intent, callingUid, callingPackage) == false) goto L9;
            Slog.w(PermissionPolicyService.m7178$$Nest$sfgetLOG_TAG(), "Action Removed: starting " + intent.toString() + " from " + callingPackage + " (uid=" + callingUid + ")");
            return false;
        L9:
            if ("android.content.pm.action.REQUEST_PERMISSIONS_FOR_OTHER".equals(intent.getAction()) == true) goto L11;
            return true;
        L11:
            if (callingUid == 1000) goto L13;
        L14:
            return false;
        L13:
            if ("android".equals(callingPackage) == false) goto L14;
            return true;
        }

        @Override // com.android.server.policy.PermissionPolicyInternal
        public void showNotificationPromptIfNeeded(String packageName, int userId, int taskId) {
            showNotificationPromptIfNeeded(packageName, userId, taskId, null);
        }

        void showNotificationPromptIfNeeded(String packageName, int userId, int taskId, ActivityInterceptorCallback.ActivityInterceptorInfo info) {
            UserHandle user = UserHandle.of(userId);
            if (packageName != null) goto L5;
            return;
        L5:
            if (taskId != (-1)) goto L7;
            return;
        L7:
            if (shouldForceShowNotificationPermissionRequest(packageName, user) == false) goto L13;
            launchNotificationPermissionRequestDialog(packageName, user, taskId, info);
            return;
        }

        @Override // com.android.server.policy.PermissionPolicyInternal
        public boolean isIntentToPermissionDialog(Intent intent) {
            if (Objects.equals(intent.getPackage(), PermissionPolicyService.m7164$$Nest$fgetmPackageManager(this.this$0).getPermissionControllerPackageName()) == true) goto L5;
        L9:
            return false;
        L5:
            if (Objects.equals(intent.getAction(), "android.content.pm.action.REQUEST_PERMISSIONS_FOR_OTHER") == false) goto L7;
        L8:
            return true;
        L7:
            if (Objects.equals(intent.getAction(), "android.content.pm.action.REQUEST_PERMISSIONS") == false) goto L9;
            goto L8
        }

        @Override // com.android.server.policy.PermissionPolicyInternal
        public boolean shouldShowNotificationDialogForTask(TaskInfo taskInfo, String currPkg, String callingPkg, Intent intent, String activityName) {
            return shouldShowNotificationDialogOrClearFlags(taskInfo, currPkg, callingPkg, intent, null, activityName, false);
        }

        private boolean isNoDisplayActivity(ActivityInfo aInfo, int userId) {
            int themeResource = aInfo.getThemeResource();
            if (themeResource != 0) goto L7;
            return false;
        L7:
            return PermissionPolicyService.m7156$$Nest$fgetmActivityTaskManagerInternal(this.this$0).isNoDisplay(aInfo.packageName, themeResource, userId);
        }

        private boolean shouldShowNotificationDialogOrClearFlags(TaskInfo taskInfo, String currPkg, String callingPkg, Intent intent, ActivityOptions options, String topActivityName, boolean startedActivity) {
            if (intent == null) goto L36;
            if (currPkg == null) goto L36;
            if (taskInfo == null) goto L36;
            if (topActivityName == null) goto L36;
            if (taskInfo.isFocused == true) goto L10;
        L13:
            if (startedActivity == false) goto L36;
        L16:
            if (isLauncherIntent(intent) == true) goto L33;
            if (options == null) goto L23;
            if (options.isEligibleForLegacyPermissionPrompt() == true) goto L33;
        L23:
            if (isTaskStartedFromLauncher(currPkg, taskInfo) == true) goto L33;
            if (isTaskPotentialTrampoline(topActivityName, currPkg, callingPkg, taskInfo, intent) == false) goto L37;
            if (startedActivity == false) goto L33;
            if (pkgHasRunningLauncherTask(currPkg, taskInfo) == true) goto L33;
            return false;
        L37:
            return false;
        L33:
            return true;
        L10:
            if (taskInfo.isVisible == false) goto L13;
            if (taskInfo.isRunning == true) goto L16;
        L36:
            return false;
        }

        private boolean isTaskPotentialTrampoline(String activityName, String currPkg, String callingPkg, TaskInfo taskInfo, Intent intent) {
            if (currPkg.equals(callingPkg) == true) goto L5;
        L11:
            return false;
        L5:
            if (taskInfo.baseIntent.filterEquals(intent) == false) goto L11;
            if (taskInfo.numActivities != 1) goto L11;
            if (activityName.equals(taskInfo.topActivityInfo.name) == false) goto L11;
            return true;
        }

        private boolean pkgHasRunningLauncherTask(String currPkg, TaskInfo taskInfo) {
            ActivityTaskManagerInternal m = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
            List<ActivityManager.AppTask> tasks = m.getAppTasks(currPkg, PermissionPolicyService.m7164$$Nest$fgetmPackageManager(this.this$0).getPackageUid(currPkg, 0));     // Catch: PackageManager.NameNotFoundException -> L16
            int i = 0;
        L5:
            if (i >= tasks.size()) goto L20;
            TaskInfo other = tasks.get(i).getTaskInfo();     // Catch: PackageManager.NameNotFoundException -> L16
            if (other.taskId == taskInfo.taskId) goto L18;
            if (other.isFocused == false) goto L18;
            if (other.isRunning == false) goto L18;
            if (isTaskStartedFromLauncher(currPkg, other) == false) goto L18;
            return true;
        L18:
            i = i + 1;
        L20:
            return false;
        }

        private boolean isLauncherIntent(Intent intent) {
            if ("android.intent.action.MAIN".equals(intent.getAction()) == true) goto L5;
        L13:
            return false;
        L5:
            if (intent.getCategories() == null) goto L13;
            if (intent.getCategories().contains("android.intent.category.LAUNCHER") == false) goto L9;
        L12:
            return true;
        L9:
            if (intent.getCategories().contains("android.intent.category.LEANBACK_LAUNCHER") == true) goto L12;
            if (intent.getCategories().contains("android.intent.category.CAR_LAUNCHER") == false) goto L13;
            goto L12
        }

        private boolean isTaskStartedFromLauncher(String currPkg, TaskInfo taskInfo) {
            if (taskInfo.baseActivity != null) goto L5;
        L9:
            return false;
        L5:
            if (currPkg.equals(taskInfo.baseActivity.getPackageName()) == false) goto L9;
            if (isLauncherIntent(taskInfo.baseIntent) == false) goto L9;
            return true;
        }

        private void launchNotificationPermissionRequestDialog(String pkgName, UserHandle user, int taskId, ActivityInterceptorCallback.ActivityInterceptorInfo info) {
            Intent grantPermission = PermissionPolicyService.m7164$$Nest$fgetmPackageManager(this.this$0).buildRequestPermissionsIntent(new String[]{"android.permission.POST_NOTIFICATIONS"});
            grantPermission.addFlags(268697600);
            grantPermission.setAction("android.content.pm.action.REQUEST_PERMISSIONS_FOR_OTHER");
            grantPermission.putExtra("android.intent.extra.PACKAGE_NAME", pkgName);
            grantPermission.putExtra("android.intent.extra.USER_ID", user.getIdentifier());
            if (info != null) goto L5;
        L11:
            boolean remoteAnimation = false;
        L13:
            if (remoteAnimation == false) goto L15;
            ActivityOptions options = ActivityOptions.makeRemoteAnimation(info.getCheckedOptions().getRemoteAnimationAdapter(), info.getCheckedOptions().getRemoteTransition());
        L16:
            options.setTaskOverlay(true, false);
            options.setLaunchTaskId(taskId);
            if (remoteAnimation == false) goto L24;
            info.getClearOptionsAnimationRunnable().run();
        L24:
            PermissionPolicyService.m7159$$Nest$fgetmContext(this.this$0).startActivityAsUser(grantPermission, options.toBundle(), user);     // Catch: Exception -> L21
            return;
        L21:
            e = move-exception;
            Log.e(PermissionPolicyService.m7178$$Nest$sfgetLOG_TAG(), "couldn't start grant permission dialogfor other package " + pkgName, e);
            return;
        L15:
            options = new ActivityOptions(new Bundle());
            goto L16
        L5:
            if (info.getCheckedOptions() == null) goto L11;
            if (info.getCheckedOptions().getAnimationType() != 13) goto L11;
            if (info.getClearOptionsAnimationRunnable() == null) goto L11;
            remoteAnimation = true;
            goto L13
        }

        @Override // com.android.server.policy.PermissionPolicyInternal
        public boolean isInitialized(int userId) {
            return PermissionPolicyService.m7171$$Nest$misStarted(this.this$0, userId);
        }

        @Override // com.android.server.policy.PermissionPolicyInternal
        public void setOnInitializedCallback(PermissionPolicyInternal.OnInitializedCallback callback) {
            Object r0 = PermissionPolicyService.m7162$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            PermissionPolicyService.m7169$$Nest$fputmOnInitializedCallback(this.this$0, callback);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private boolean isActionRemovedForCallingPackage(Intent intent, int callingUid, String callingPackage) {
            String action = intent.getAction();
            if (action != null) goto L6;
            return false;
        L6:
            switch(action.hashCode()) {
                case -1673968409: goto L12;
                case 579418056: goto L9;
                default: goto L14;
            };
        L14:
            byte r2 = -1;
        L15:
            switch(r2) {
                case 0: goto L26;
                case 1: goto L26;
                default: goto L16;
            };
        L16:
            return false;
        L26:
            ApplicationInfo applicationInfo = this.this$0.getContext().getPackageManager().getApplicationInfoAsUser(callingPackage, 0, UserHandle.getUserId(callingUid));     // Catch: PackageManager.NameNotFoundException -> L22
            if (applicationInfo.targetSdkVersion < 29) goto L24;
            return true;
        L24:
            intent.putExtra("android.intent.extra.CALLING_PACKAGE", callingPackage);
            return false;
        L23:
            Slog.i(PermissionPolicyService.m7178$$Nest$sfgetLOG_TAG(), "Cannot find application info for " + callingPackage);
            goto L24
        L9:
            if (action.equals("android.telecom.action.CHANGE_DEFAULT_DIALER") == false) goto L14;
            r2 = 0;
            goto L15
        L12:
            if (action.equals("android.provider.Telephony.ACTION_CHANGE_DEFAULT") == false) goto L14;
            r2 = 1;
            goto L15
        }

        private boolean shouldForceShowNotificationPermissionRequest(String pkgName, UserHandle user) {
            AndroidPackage pkg = PermissionPolicyService.m7165$$Nest$fgetmPackageManagerInternal(this.this$0).getPackage(pkgName);
            if (pkg != null) goto L5;
        L50:
            if (pkg != null) goto L52;
            Slog.w(PermissionPolicyService.m7178$$Nest$sfgetLOG_TAG(), "Cannot check for Notification prompt, no package for " + pkgName);
        L52:
            return false;
        L5:
            if (pkg.getPackageName() == null) goto L50;
            if (Objects.equals(pkgName, PermissionPolicyService.m7164$$Nest$fgetmPackageManager(this.this$0).getPermissionControllerPackageName()) == true) goto L50;
            if (pkg.getTargetSdkVersion() < 23) goto L50;
            Object r2 = PermissionPolicyService.m7162$$Nest$fgetmLock(this.this$0);
            monitor-enter(r2);
        L17:
            th = move-exception;
            throw th;
        L14:
            if (PermissionPolicyService.m7158$$Nest$fgetmBootCompleted(this.this$0) == true) goto L19;
            monitor-exit(r2);     // Catch: Throwable -> L17
            return false;
        L19:
            monitor-exit(r2);     // Catch: Throwable -> L17
            if (pkg.getRequestedPermissions().contains("android.permission.POST_NOTIFICATIONS") == true) goto L23;
        L47:
            return false;
        L23:
            if (CompatChanges.isChangeEnabled(PermissionPolicyService.NOTIFICATION_PERM_CHANGE_ID, pkgName, user) == true) goto L47;
            if (PermissionPolicyService.m7161$$Nest$fgetmKeyguardManager(this.this$0).isKeyguardLocked() == true) goto L47;
            int uid = user.getUid(pkg.getUid());
            if (PermissionPolicyService.m7163$$Nest$fgetmNotificationManager(this.this$0) != null) goto L31;
            PermissionPolicyService.m7168$$Nest$fputmNotificationManager(this.this$0, (NotificationManagerInternal) LocalServices.getService(NotificationManagerInternal.class));
        L31:
            if (PermissionPolicyService.m7163$$Nest$fgetmNotificationManager(this.this$0).getNumNotificationChannelsForPackage(pkgName, uid, true) <= 0) goto L33;
            boolean hasCreatedNotificationChannels = true;
        L35:
            if (PermissionPolicyService.m7166$$Nest$fgetmPermissionManagerInternal(this.this$0).checkUidPermission(uid, "android.permission.POST_NOTIFICATIONS", 0) != 0) goto L37;
            boolean granted = true;
        L38:
            int flags = PermissionPolicyService.m7164$$Nest$fgetmPackageManager(this.this$0).getPermissionFlags("android.permission.POST_NOTIFICATIONS", pkgName, user);
            if ((32823 & flags) == 0) goto L41;
            boolean explicitlySet = true;
        L42:
            if (granted == true) goto L54;
            if (hasCreatedNotificationChannels == false) goto L55;
            if (explicitlySet == false) goto L46;
            return false;
        L46:
            return true;
        L55:
            return false;
        L54:
            return false;
        L41:
            explicitlySet = false;
            goto L42
        L37:
            granted = false;
            goto L38
        L33:
            hasCreatedNotificationChannels = false;
            goto L35
        }
    }

    private class PermissionToOpSynchroniser {
        private final AppOpsManager mAppOpsManager;
        private final AppOpsManagerInternal mAppOpsManagerInternal;
        private final Context mContext;
        private final ArrayList<OpToChange> mOpsToAllow;
        private final ArrayList<OpToChange> mOpsToForeground;
        private final ArrayList<OpToChange> mOpsToIgnore;
        private final ArrayList<OpToChange> mOpsToIgnoreIfNotAllowed;
        private final PackageManager mPackageManager;
        private final ArrayMap<String, PermissionInfo> mRuntimeAndTheirBgPermissionInfos;
        final /* synthetic */ PermissionPolicyService this$0;

        private class OpToChange {
            final int code;
            final String packageName;
            final int uid;

            OpToChange(PermissionToOpSynchroniser r1, int uid, String packageName, int code) {
                this.uid = uid;
                this.packageName = packageName;
                this.code = code;
            }
        }

        /* JADX INFO: renamed from: -$$Nest$msyncPackages, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7184$$Nest$msyncPackages(PermissionToOpSynchroniser r0) {
            r0.syncPackages();
        }

        PermissionToOpSynchroniser(PermissionPolicyService r10, Context context) {
            this.this$0 = r10;
            this.mOpsToAllow = new ArrayList();
            this.mOpsToIgnore = new ArrayList();
            this.mOpsToIgnoreIfNotAllowed = new ArrayList();
            this.mOpsToForeground = new ArrayList();
            this.mContext = context;
            this.mPackageManager = context.getPackageManager();
            this.mAppOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
            this.mAppOpsManagerInternal = (AppOpsManagerInternal) LocalServices.getService(AppOpsManagerInternal.class);
            this.mRuntimeAndTheirBgPermissionInfos = new ArrayMap();
            PermissionManagerServiceInternal permissionManagerInternal = (PermissionManagerServiceInternal) LocalServices.getService(PermissionManagerServiceInternal.class);
            List<PermissionInfo> permissionInfos = permissionManagerInternal.getAllPermissionsWithProtection(1);
            int permissionInfosSize = permissionInfos.size();
            int i = 0;
        L3:
            if (i >= permissionInfosSize) goto L19;
            PermissionInfo permissionInfo = permissionInfos.get(i);
            this.mRuntimeAndTheirBgPermissionInfos.put(permissionInfo.name, permissionInfo);
            if (permissionInfo.backgroundPermission == null) goto L17;
            String backgroundNonRuntimePermission = permissionInfo.backgroundPermission;
            int j = 0;
        L7:
            if (j >= permissionInfosSize) goto L12;
            PermissionInfo bgPermissionCandidate = permissionInfos.get(j);
            if (permissionInfo.backgroundPermission.equals(bgPermissionCandidate.name) == true) goto L10;
            j = j + 1;
            goto L7
        L10:
            backgroundNonRuntimePermission = null;
        L12:
            if (backgroundNonRuntimePermission == null) goto L17;
            PermissionInfo backgroundPermissionInfo = this.mPackageManager.getPermissionInfo(backgroundNonRuntimePermission, 0);     // Catch: PackageManager.NameNotFoundException -> L15
            this.mRuntimeAndTheirBgPermissionInfos.put(backgroundPermissionInfo.name, backgroundPermissionInfo);     // Catch: PackageManager.NameNotFoundException -> L15
        L16:
            Slog.w(PermissionPolicyService.m7178$$Nest$sfgetLOG_TAG(), "Unknown background permission: " + backgroundNonRuntimePermission);
        L17:
            i = i + 1;
            goto L3
        }

        private void syncPackages() {
            LongSparseLongArray alreadySetAppOps = new LongSparseLongArray();
            int allowCount = this.mOpsToAllow.size();
            int i = 0;
        L4:
            if (i >= allowCount) goto L6;
            OpToChange op = this.mOpsToAllow.get(i);
            setUidModeAllowed(op.code, op.uid, op.packageName);
            alreadySetAppOps.put(IntPair.of(op.uid, op.code), 1);
            i = i + 1;
            goto L4
        L6:
            int foregroundCount = this.mOpsToForeground.size();
            int i2 = 0;
        L7:
            if (i2 >= foregroundCount) goto L13;
            OpToChange op2 = this.mOpsToForeground.get(i2);
            if (alreadySetAppOps.indexOfKey(IntPair.of(op2.uid, op2.code)) >= 0) goto L12;
            setUidModeForeground(op2.code, op2.uid, op2.packageName);
            alreadySetAppOps.put(IntPair.of(op2.uid, op2.code), 1);
        L12:
            i2 = i2 + 1;
            goto L7
        L13:
            int ignoreCount = this.mOpsToIgnore.size();
            int i3 = 0;
        L14:
            if (i3 >= ignoreCount) goto L20;
            OpToChange op3 = this.mOpsToIgnore.get(i3);
            if (alreadySetAppOps.indexOfKey(IntPair.of(op3.uid, op3.code)) >= 0) goto L19;
            setUidModeIgnored(op3.code, op3.uid, op3.packageName);
            alreadySetAppOps.put(IntPair.of(op3.uid, op3.code), 1);
        L19:
            i3 = i3 + 1;
            goto L14
        L20:
            int ignoreIfNotAllowedCount = this.mOpsToIgnoreIfNotAllowed.size();
            int i4 = 0;
        L21:
            if (i4 >= ignoreIfNotAllowedCount) goto L30;
            OpToChange op4 = this.mOpsToIgnoreIfNotAllowed.get(i4);
            if (alreadySetAppOps.indexOfKey(IntPair.of(op4.uid, op4.code)) >= 0) goto L28;
            boolean wasSet = setUidModeIgnoredIfNotAllowed(op4.code, op4.uid, op4.packageName);
            if (wasSet == false) goto L28;
            alreadySetAppOps.put(IntPair.of(op4.uid, op4.code), 1);
        L28:
            i4 = i4 + 1;
            goto L21
        }

        private void addAppOps(PackageInfo packageInfo, AndroidPackage pkg, String permissionName) {
            PermissionInfo permissionInfo = this.mRuntimeAndTheirBgPermissionInfos.get(permissionName);
            if (permissionInfo != null) goto L5;
            return;
        L5:
            addPermissionAppOp(packageInfo, pkg, permissionInfo);
            addExtraAppOp(packageInfo, pkg, permissionInfo);
        }

        private void addPermissionAppOp(PackageInfo packageInfo, AndroidPackage pkg, PermissionInfo permissionInfo) {
            if (permissionInfo.isRuntime() == true) goto L5;
            return;
        L5:
            String permissionName = permissionInfo.name;
            String packageName = packageInfo.packageName;
            UserHandle.getUserHandleForUid(packageInfo.applicationInfo.uid);
            int permissionFlags = this.mPackageManager.getPermissionFlags(permissionName, packageName, this.mContext.getUser());
            boolean shouldGrantBackgroundAppOp = true;
            int appOpMode = 0;
            if ((permissionFlags & 64) == 0) goto L8;
            boolean isReviewRequired = true;
        L9:
            if (isReviewRequired == false) goto L11;
            return;
        L11:
            int appOpCode = PermissionPolicyService.m7179$$Nest$smgetSwitchOp(permissionName);
            if (appOpCode != (-1)) goto L14;
            return;
        L14:
            boolean shouldGrantAppOp = shouldGrantAppOp(packageInfo, pkg, permissionInfo);
            if (shouldGrantAppOp == true) goto L17;
            appOpMode = 1;
        L31:
            int uid = packageInfo.applicationInfo.uid;
            OpToChange opToChange = new OpToChange(this, uid, packageName, appOpCode);
            switch(appOpMode) {
                case 0: goto L36;
                case 1: goto L35;
                case 2: goto L40;
                case 3: goto L40;
                case 4: goto L34;
                default: goto L40;
            };
        L34:
            this.mOpsToForeground.add(opToChange);
            return;
        L35:
            this.mOpsToIgnore.add(opToChange);
            return;
        L36:
            this.mOpsToAllow.add(opToChange);
            return;
        L40:
            return;
        L17:
            if (permissionInfo.backgroundPermission == null) goto L29;
            PermissionInfo backgroundPermissionInfo = this.mRuntimeAndTheirBgPermissionInfos.get(permissionInfo.backgroundPermission);
            if (backgroundPermissionInfo != null) goto L21;
        L23:
            shouldGrantBackgroundAppOp = false;
        L25:
            if (shouldGrantBackgroundAppOp == true) goto L31;
            appOpMode = 4;
            goto L31
        L21:
            if (shouldGrantAppOp(packageInfo, pkg, backgroundPermissionInfo) == false) goto L23;
        L29:
            appOpMode = 0;
            goto L31
        L8:
            isReviewRequired = false;
            goto L9
        }

        private boolean shouldGrantAppOp(PackageInfo packageInfo, AndroidPackage pkg, PermissionInfo permissionInfo) {
            String permissionName = permissionInfo.name;
            String packageName = packageInfo.packageName;
            if (this.mPackageManager.checkPermission(permissionName, packageName) != 0) goto L5;
            boolean isGranted = true;
        L6:
            if (isGranted == true) goto L8;
            return false;
        L8:
            int permissionFlags = this.mPackageManager.getPermissionFlags(permissionName, packageName, this.mContext.getUser());
            if ((permissionFlags & 8) != 8) goto L11;
            boolean isRevokedCompat = true;
        L12:
            if (isRevokedCompat == false) goto L15;
            return false;
        L15:
            if (permissionInfo.isHardRestricted() == false) goto L25;
            if ((permissionFlags & 16384) != 16384) goto L19;
            boolean shouldApplyRestriction = true;
        L20:
            if (shouldApplyRestriction == true) goto L23;
            return true;
        L23:
            return false;
        L19:
            shouldApplyRestriction = false;
            goto L20
        L25:
            if (permissionInfo.isSoftRestricted() == false) goto L28;
            SoftRestrictedPermissionPolicy policy = SoftRestrictedPermissionPolicy.forPermission(this.mContext, packageInfo.applicationInfo, pkg, this.mContext.getUser(), permissionName);
            return policy.mayGrantPermission();
        L28:
            return true;
        L11:
            isRevokedCompat = false;
            goto L12
        L5:
            isGranted = false;
            goto L6
        }

        private void addExtraAppOp(PackageInfo packageInfo, AndroidPackage pkg, PermissionInfo permissionInfo) {
            if (permissionInfo.isSoftRestricted() == true) goto L5;
            return;
        L5:
            String permissionName = permissionInfo.name;
            SoftRestrictedPermissionPolicy policy = SoftRestrictedPermissionPolicy.forPermission(this.mContext, packageInfo.applicationInfo, pkg, this.mContext.getUser(), permissionName);
            int extraOpCode = policy.getExtraAppOpCode();
            if (extraOpCode != (-1)) goto L8;
            return;
        L8:
            int uid = packageInfo.applicationInfo.uid;
            String packageName = packageInfo.packageName;
            OpToChange extraOpToChange = new OpToChange(this, uid, packageName, extraOpCode);
            if (policy.mayAllowExtraAppOp() == false) goto L12;
            this.mOpsToAllow.add(extraOpToChange);
            return;
        L12:
            if (policy.mayDenyExtraAppOpIfGranted() == false) goto L14;
            this.mOpsToIgnore.add(extraOpToChange);
            return;
        L14:
            this.mOpsToIgnoreIfNotAllowed.add(extraOpToChange);
        }

        void addPackage(String pkgName) {
            PackageInfo pkgInfo = this.mPackageManager.getPackageInfo(pkgName, 4096);     // Catch: PackageManager.NameNotFoundException -> L21
            AndroidPackage pkg = PermissionPolicyService.m7165$$Nest$fgetmPackageManagerInternal(this.this$0).getPackage(pkgName);     // Catch: PackageManager.NameNotFoundException -> L21
            if (pkgInfo == null) goto L20;
            if (pkg != null) goto L6;
            return;
        L6:
            if (pkgInfo.applicationInfo != null) goto L8;
            return;
        L8:
            if (pkgInfo.requestedPermissions == null) goto L29;
            int uid = pkgInfo.applicationInfo.uid;
            if (uid != 0) goto L13;
            return;
        L13:
            if (uid == 1000) goto L26;
            String[] r3 = pkgInfo.requestedPermissions;
            int r4 = r3.length;
            int r5 = 0;
        L16:
            if (r5 >= r4) goto L18;
            String permission = r3[r5];
            addAppOps(pkgInfo, pkg, permission);
            r5 = r5 + 1;
            goto L16
        L18:
            return;
        L26:
            return;
        L29:
            return;
        L20:
            return;
        }

        private void setUidModeAllowed(int opCode, int uid, String packageName) {
            setUidMode(opCode, uid, 0, packageName);
        }

        private void setUidModeForeground(int opCode, int uid, String packageName) {
            setUidMode(opCode, uid, 4, packageName);
        }

        private void setUidModeIgnored(int opCode, int uid, String packageName) {
            setUidMode(opCode, uid, 1, packageName);
        }

        private boolean setUidModeIgnoredIfNotAllowed(int opCode, int uid, String packageName) {
            int currentMode = this.mAppOpsManager.unsafeCheckOpRaw(AppOpsManager.opToPublicName(opCode), uid, packageName);
            if (currentMode != 0) goto L5;
            return false;
        L5:
            if (currentMode == 1) goto L7;
            this.mAppOpsManagerInternal.setUidModeFromPermissionPolicy(opCode, uid, 1, PermissionPolicyService.m7157$$Nest$fgetmAppOpsCallback(this.this$0));
        L7:
            return true;
        }

        private void setUidMode(int opCode, int uid, int mode, String packageName) {
            int oldMode = this.mAppOpsManager.unsafeCheckOpRaw(AppOpsManager.opToPublicName(opCode), uid, packageName);
            if (oldMode == mode) goto L9;
            this.mAppOpsManagerInternal.setUidModeFromPermissionPolicy(opCode, uid, mode, PermissionPolicyService.m7157$$Nest$fgetmAppOpsCallback(this.this$0));
            int newMode = this.mAppOpsManager.unsafeCheckOpRaw(AppOpsManager.opToPublicName(opCode), uid, packageName);
            if (newMode == mode) goto L11;
            this.mAppOpsManagerInternal.setModeFromPermissionPolicy(opCode, uid, packageName, AppOpsManager.opToDefaultMode(opCode), PermissionPolicyService.m7157$$Nest$fgetmAppOpsCallback(this.this$0));
            return;
        L11:
            return;
        }
    }

    private final class PhoneCarrierPrivilegesCallback implements TelephonyManager.CarrierPrivilegesCallback {
        private int mPhoneId;
        final /* synthetic */ PermissionPolicyService this$0;

        PhoneCarrierPrivilegesCallback(PermissionPolicyService r1, int phoneId) {
            this.this$0 = r1;
            this.mPhoneId = phoneId;
        }

        public void onCarrierPrivilegesChanged(Set<String> privilegedPackageNames, Set<Integer> privilegedUids) {
            PermissionPolicyService.m7170$$Nest$minitTelephonyManagerIfNeeded(this.this$0);
            if (PermissionPolicyService.m7167$$Nest$fgetmTelephonyManager(this.this$0) != null) goto L6;
            Log.e(PermissionPolicyService.m7178$$Nest$sfgetLOG_TAG(), "Cannot grant default permissions to Carrier Service app. TelephonyManager is null");
            return;
        L6:
            String servicePkg = PermissionPolicyService.m7167$$Nest$fgetmTelephonyManager(this.this$0).getCarrierServicePackageNameForLogicalSlot(this.mPhoneId);
            if (servicePkg != null) goto L9;
            return;
        L9:
            int[] users = ((UserManagerInternal) LocalServices.getService(UserManagerInternal.class)).getUserIds();
            LegacyPermissionManager legacyPermManager = (LegacyPermissionManager) PermissionPolicyService.m7159$$Nest$fgetmContext(this.this$0).getSystemService(LegacyPermissionManager.class);
            int i = 0;
        L11:
            if (i >= users.length) goto L17;
            PermissionPolicyService.m7164$$Nest$fgetmPackageManager(this.this$0).getPackageInfoAsUser(servicePkg, 0, users[i]);     // Catch: PackageManager.NameNotFoundException -> L14
            legacyPermManager.grantDefaultPermissionsToCarrierServiceApp(servicePkg, users[i]);     // Catch: PackageManager.NameNotFoundException -> L14
        L15:
            i = i + 1;
            goto L11
        }
    }

    public static /* synthetic */ void $r8$lambda$W3Db6krHK_VogswF5lIrWu7rLuk(PermissionPolicyService r0, int r1) {
        r0.resetAppOpPermissionsIfNotRequestedForUid(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$g9YhLNd1OZQfuSCyT_yO-G8mZv0, reason: not valid java name */
    public static /* synthetic */ void m7154$r8$lambda$g9YhLNd1OZQfuSCyT_yOG8mZv0(PermissionPolicyService r0, int r1) {
        r0.synchronizeUidPermissionsAndAppOps(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$kXuSNWF3S7jBnqn-bwqHq3GSl6A, reason: not valid java name */
    public static /* synthetic */ void m7155$r8$lambda$kXuSNWF3S7jBnqnbwqHq3GSl6A(AndroidFuture r0, int r1, Boolean r2) {
        lambda$grantOrUpgradeDefaultRuntimePermissions$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ld1nnNDCxf7vPuA1kAJMQY6ne5I(PermissionPolicyService r0, int r1) {
        r0.synchronizeUidPermissionsAndAppOpsAsync(r1);
    }

    public static /* synthetic */ void $r8$lambda$rznrndUGsirjpBcjHOGDjKWoSAo(PermissionToOpSynchroniser r0, AndroidPackage r1) {
        lambda$synchronizePermissionsAndAppOpsForUser$1(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityTaskManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerInternal m7156$$Nest$fgetmActivityTaskManagerInternal(PermissionPolicyService r0) {
        return r0.mActivityTaskManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppOpsCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ IAppOpsCallback m7157$$Nest$fgetmAppOpsCallback(PermissionPolicyService r0) {
        return r0.mAppOpsCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBootCompleted, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7158$$Nest$fgetmBootCompleted(PermissionPolicyService r0) {
        return r0.mBootCompleted;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7159$$Nest$fgetmContext(PermissionPolicyService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7160$$Nest$fgetmHandler(PermissionPolicyService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmKeyguardManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ KeyguardManager m7161$$Nest$fgetmKeyguardManager(PermissionPolicyService r0) {
        return r0.mKeyguardManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7162$$Nest$fgetmLock(PermissionPolicyService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationManagerInternal m7163$$Nest$fgetmNotificationManager(PermissionPolicyService r0) {
        return r0.mNotificationManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManager m7164$$Nest$fgetmPackageManager(PermissionPolicyService r0) {
        return r0.mPackageManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerInternal m7165$$Nest$fgetmPackageManagerInternal(PermissionPolicyService r0) {
        return r0.mPackageManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPermissionManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PermissionManagerServiceInternal m7166$$Nest$fgetmPermissionManagerInternal(PermissionPolicyService r0) {
        return r0.mPermissionManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTelephonyManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ TelephonyManager m7167$$Nest$fgetmTelephonyManager(PermissionPolicyService r0) {
        return r0.mTelephonyManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNotificationManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7168$$Nest$fputmNotificationManager(PermissionPolicyService r0, NotificationManagerInternal r1) {
        r0.mNotificationManager = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmOnInitializedCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7169$$Nest$fputmOnInitializedCallback(PermissionPolicyService r0, PermissionPolicyInternal.OnInitializedCallback r1) {
        r0.mOnInitializedCallback = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$minitTelephonyManagerIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7170$$Nest$minitTelephonyManagerIfNeeded(PermissionPolicyService r0) {
        r0.initTelephonyManagerIfNeeded();
    }

    /* JADX INFO: renamed from: -$$Nest$misStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7171$$Nest$misStarted(PermissionPolicyService r0, int r1) {
        return r0.isStarted(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterCarrierPrivilegesCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7172$$Nest$mregisterCarrierPrivilegesCallbacks(PermissionPolicyService r0) {
        r0.registerCarrierPrivilegesCallbacks();
    }

    /* JADX INFO: renamed from: -$$Nest$mresetAppOpPermissionsIfNotRequestedForUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7173$$Nest$mresetAppOpPermissionsIfNotRequestedForUid(PermissionPolicyService r0, int r1) {
        r0.resetAppOpPermissionsIfNotRequestedForUid(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mresetAppOpPermissionsIfNotRequestedForUidAsync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7174$$Nest$mresetAppOpPermissionsIfNotRequestedForUidAsync(PermissionPolicyService r0, int r1) {
        r0.resetAppOpPermissionsIfNotRequestedForUidAsync(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msynchronizeUidPermissionsAndAppOps, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7175$$Nest$msynchronizeUidPermissionsAndAppOps(PermissionPolicyService r0, int r1) {
        r0.synchronizeUidPermissionsAndAppOps(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msynchronizeUidPermissionsAndAppOpsAsync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7176$$Nest$msynchronizeUidPermissionsAndAppOpsAsync(PermissionPolicyService r0, int r1) {
        r0.synchronizeUidPermissionsAndAppOpsAsync(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$munregisterCarrierPrivilegesCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7177$$Nest$munregisterCarrierPrivilegesCallback(PermissionPolicyService r0) {
        r0.unregisterCarrierPrivilegesCallback();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetLOG_TAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7178$$Nest$sfgetLOG_TAG() {
        return LOG_TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smgetSwitchOp, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7179$$Nest$smgetSwitchOp(String r0) {
        return getSwitchOp(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetUserContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7180$$Nest$smgetUserContext(Context r0, UserHandle r1) {
        return getUserContext(r0, r1);
    }

    static {
        LOG_TAG = PermissionPolicyService.class.getSimpleName();
    }

    public PermissionPolicyService(Context context) {
        super(context);
        this.mLock = new Object();
        this.mBootCompleted = false;
        this.mIsStarted = new SparseBooleanArray();
        this.mIsUidSyncScheduled = new SparseBooleanArray();
        this.mIsUidResetScheduled = new SparseBooleanArray();
        this.mPhoneCarrierPrivilegesCallbacks = new ArrayList();
        this.mSimConfigBroadcastReceiver = new AnonymousClass4(this);
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mPackageManager = context.getPackageManager();
        this.mKeyguardManager = (KeyguardManager) context.getSystemService(KeyguardManager.class);
        LocalServices.addService(PermissionPolicyInternal.class, new Internal(this, null));
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mPermissionManagerInternal = (PermissionManagerServiceInternal) LocalServices.getService(PermissionManagerServiceInternal.class);
        this.mActivityTaskManagerInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        IAppOpsService appOpsService = IAppOpsService.Stub.asInterface(ServiceManager.getService("appops"));
        this.mPackageManagerInternal.getPackageList(new AnonymousClass1(this));
        this.mPackageManager.addOnPermissionsChangeListener(new PermissionPolicyService$$ExternalSyntheticLambda0(this));
        this.mAppOpsCallback = new AnonymousClass2(this);
        List<PermissionInfo> dangerousPerms = this.mPermissionManagerInternal.getAllPermissionsWithProtection(1);
        int numDangerousPerms = dangerousPerms.size();     // Catch: RemoteException -> L8
        int i = 0;
    L4:
        if (i >= numDangerousPerms) goto L18;
        PermissionInfo perm = dangerousPerms.get(i);     // Catch: RemoteException -> L8
        if (perm.isRuntime() == false) goto L11;
        appOpsService.startWatchingMode(getSwitchOp(perm.name), null, this.mAppOpsCallback);     // Catch: RemoteException -> L8
    L11:
        if (perm.isSoftRestricted() == false) goto L15;
        SoftRestrictedPermissionPolicy policy = SoftRestrictedPermissionPolicy.forPermission(null, null, null, null, perm.name);     // Catch: RemoteException -> L8
        int extraAppOp = policy.getExtraAppOpCode();     // Catch: RemoteException -> L8
        if (extraAppOp == (-1)) goto L15;
        appOpsService.startWatchingMode(extraAppOp, null, this.mAppOpsCallback);     // Catch: RemoteException -> L8
    L15:
        i = i + 1;
    L18:
        List<PermissionInfo> appOpPermissionInfos = this.mPermissionManagerInternal.getAllPermissionsWithProtectionFlags(64);
        this.mAppOpPermissions = new ArrayList();
        int appOpPermissionInfosSize = appOpPermissionInfos.size();
        int i2 = 0;
    L19:
        if (i2 >= appOpPermissionInfosSize) goto L44;
        PermissionInfo appOpPermissionInfo = appOpPermissionInfos.get(i2);
        String r0 = appOpPermissionInfo.name;
        switch(r0.hashCode()) {
            case 309844284: goto L30;
            case 1353874541: goto L27;
            case 1777263169: goto L24;
            default: goto L32;
        };
    L32:
        byte r1 = -1;
    L33:
        switch(r1) {
            case 0: goto L43;
            case 1: goto L43;
            case 2: goto L43;
            default: goto L34;
        };
    L34:
        int appOpCode = AppOpsManager.permissionToOpCode(appOpPermissionInfo.name);
        if (appOpCode == (-1)) goto L43;
        this.mAppOpPermissions.add(appOpPermissionInfo.name);
        appOpsService.startWatchingMode(appOpCode, null, this.mAppOpsCallback);     // Catch: RemoteException -> L39
    L39:
        e = move-exception;
        Slog.wtf(LOG_TAG, "Cannot set up app-ops listener", e);
    L43:
        i2 = i2 + 1;
        goto L19
    L24:
        if (r0.equals("android.permission.REQUEST_INSTALL_PACKAGES") == false) goto L59;
        r1 = 2;
        goto L33
    L59:
        r1 = -1;
        goto L33
    L27:
        if (r0.equals("android.permission.ACCESS_NOTIFICATIONS") == false) goto L60;
        r1 = 0;
        goto L33
    L60:
        r1 = -1;
        goto L33
    L30:
        if (r0.equals("android.permission.MANAGE_IPSEC_TUNNELS") == false) goto L61;
        r1 = 1;
        goto L33
    L61:
        r1 = -1;
        goto L33
    L44:
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addDataScheme(Settings.ATTR_PACKAGE);
        getContext().registerReceiverAsUser(new AnonymousClass3(this), UserHandle.ALL, intentFilter, null, null);
        final PermissionControllerManager manager = new PermissionControllerManager(getUserContext(getContext(), Process.myUserHandle()), PermissionThread.getHandler());
        PermissionThread.getHandler().postDelayed(new PermissionPolicyService$$ExternalSyntheticLambda1(manager), 60000);
        return;
    L17:
        Slog.wtf(LOG_TAG, "Cannot set up app-ops listener");
        goto L18
    }

    private static int getSwitchOp(String permission) {
        int op = AppOpsManager.permissionToOpCode(permission);
        if (op != (-1)) goto L6;
        return -1;
    L6:
        return AppOpsManager.opToSwitch(op);
    }

    private void synchronizeUidPermissionsAndAppOpsAsync(int uid) {
        int userId = UserHandle.getUserId(uid);
        if (isStarted(userId) == false) goto L15;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.mIsUidSyncScheduled.get(uid) == true) goto L11;
        FgThread.getHandler().sendMessage(PooledLambda.obtainMessage(new PermissionPolicyService$$ExternalSyntheticLambda5(), this, Integer.valueOf(uid)));     // Catch: Throwable -> L9
        this.mIsUidSyncScheduled.put(uid, true);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 520) goto L6;
        registerCarrierPrivilegesCallbacks();
        IntentFilter filter = new IntentFilter("android.telephony.action.MULTI_SIM_CONFIG_CHANGED");
        this.mContext.registerReceiver(this.mSimConfigBroadcastReceiver, filter);
    L6:
        if (phase != 550) goto L14;
        UserManagerInternal um = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        int[] r2 = um.getUserIds();
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        int userId = r2[r4];
        if (um.isUserRunning(userId) == false) goto L13;
        onStartUser(userId);
    L13:
        r4 = r4 + 1;
    L14:
        if (phase != 550) goto L17;
        Internal.m7182$$Nest$monActivityManagerReady((Internal) LocalServices.getService(PermissionPolicyInternal.class));
    L17:
        if (phase != 1000) goto L27;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mBootCompleted = true;     // Catch: Throwable -> L24
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    }

    private void initTelephonyManagerIfNeeded() {
        if (this.mTelephonyManager != null) goto L6;
        this.mTelephonyManager = TelephonyManager.from(this.mContext);
        return;
    }

    private void registerCarrierPrivilegesCallbacks() {
        initTelephonyManagerIfNeeded();
        if (this.mTelephonyManager != null) goto L5;
        return;
    L5:
        int numPhones = this.mTelephonyManager.getActiveModemCount();
        int i = 0;
    L6:
        if (i >= numPhones) goto L9;
        PhoneCarrierPrivilegesCallback callback = new PhoneCarrierPrivilegesCallback(this, i);
        this.mPhoneCarrierPrivilegesCallbacks.add(callback);
        this.mTelephonyManager.registerCarrierPrivilegesCallback(i, this.mContext.getMainExecutor(), callback);
        i = i + 1;
        goto L6
    }

    private void unregisterCarrierPrivilegesCallback() {
        initTelephonyManagerIfNeeded();
        if (this.mTelephonyManager != null) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= this.mPhoneCarrierPrivilegesCallbacks.size()) goto L12;
        PhoneCarrierPrivilegesCallback callback = this.mPhoneCarrierPrivilegesCallbacks.get(i);
        if (callback == null) goto L11;
        this.mTelephonyManager.unregisterCarrierPrivilegesCallback(callback);
    L11:
        i = i + 1;
        goto L7
    L12:
        this.mPhoneCarrierPrivilegesCallbacks.clear();
    }

    private boolean isStarted(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mIsStarted.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onUserStarting(SystemService.TargetUser user) {
        onStartUser(user.getUserIdentifier());
    }

    private void onStartUser(int userId) {
        if (isStarted(userId) == false) goto L5;
        return;
    L5:
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("Permission_grant_default_permissions-" + userId);
        if (this.mPackageManagerInternal.isPermissionUpgradeNeeded(userId) == false) goto L8;
        grantOrUpgradeDefaultRuntimePermissions(userId);
        updateUserSensitive(userId);
        this.mPackageManagerInternal.updateRuntimePermissionsFingerprint(userId);
    L8:
        t.traceEnd();
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mIsStarted.put(userId, true);     // Catch: Throwable -> L16
        PermissionPolicyInternal.OnInitializedCallback callback = this.mOnInitializedCallback;     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        t.traceBegin("Permission_synchronize_permissions-" + userId);
        synchronizePermissionsAndAppOpsForUser(userId);
        t.traceEnd();
        if (callback == null) goto L21;
        t.traceBegin("Permission_onInitialized-" + userId);
        callback.onInitialized(userId);
        t.traceEnd();
        return;
    L21:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onUserStopping(SystemService.TargetUser user) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIsStarted.delete(user.getUserIdentifier());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void grantOrUpgradeDefaultRuntimePermissions(final int userId) {
        if (PermissionManager.USE_ACCESS_CHECKING_SERVICE == false) goto L5;
        return;
    L5:
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        final AndroidFuture<Boolean> future = new AndroidFuture();
        PermissionControllerManager permissionControllerManager = new PermissionControllerManager(getUserContext(getContext(), UserHandle.of(userId)), PermissionThread.getHandler());
        permissionControllerManager.grantOrUpgradeDefaultRuntimePermissions(PermissionThread.getExecutor(), new PermissionPolicyService$$ExternalSyntheticLambda2(future, userId));
        t.traceBegin("Permission_callback_waiting-" + userId);     // Catch: Throwable -> L9 Throwable -> L11
        future.get();     // Catch: Throwable -> L9 Throwable -> L11
        t.traceEnd();
        return;
    L11:
        e = move-exception;
        throw new IllegalStateException(e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        t.traceEnd();
        throw th;
    }

    private static /* synthetic */ void lambda$grantOrUpgradeDefaultRuntimePermissions$0(AndroidFuture future, int userId, Boolean successful) {
        if (successful.booleanValue() == false) goto L5;
        future.complete(null);
        return;
    L5:
        String message = "Error granting/upgrading runtime permissions for user " + userId;
        Slog.wtf(LOG_TAG, message);
        future.completeExceptionally(new IllegalStateException(message));
    }

    private void updateUserSensitive(int userId) {
        PermissionControllerManager permissionControllerManager = new PermissionControllerManager(getUserContext(getContext(), UserHandle.of(userId)), PermissionThread.getHandler());
        permissionControllerManager.updateUserSensitive();
    }

    private static Context getUserContext(Context context, UserHandle user) {
        if (context.getUser().equals(user) == false) goto L10;
        return context;
    L10:
        return context.createPackageContextAsUser(context.getPackageName(), 0, user);
    L7:
        e = move-exception;
        Slog.e(LOG_TAG, "Cannot create context for user " + user, e);
        return null;
    }

    private void synchronizeUidPermissionsAndAppOps(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIsUidSyncScheduled.delete(uid);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        UserHandle user = UserHandle.getUserHandleForUid(uid);
        PermissionToOpSynchroniser synchroniser = new PermissionToOpSynchroniser(this, getUserContext(getContext(), user));
        int appId = UserHandle.getAppId(uid);
        List<AndroidPackage> pkgs = this.mPackageManagerInternal.getPackagesForAppId(appId);
        int pkgsSize = pkgs.size();
        int i = 0;
    L7:
        if (i >= pkgsSize) goto L9;
        AndroidPackage pkg = pkgs.get(i);
        synchroniser.addPackage(pkg.getPackageName());
        i = i + 1;
        goto L7
    L9:
        PermissionToOpSynchroniser.m7184$$Nest$msyncPackages(synchroniser);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void synchronizePermissionsAndAppOpsForUser(int userId) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        final PermissionToOpSynchroniser synchronizer = new PermissionToOpSynchroniser(this, getUserContext(getContext(), UserHandle.of(userId)));
        t.traceBegin("Permission_synchronize_addPackages-" + userId);
        this.mPackageManagerInternal.forEachPackage(new PermissionPolicyService$$ExternalSyntheticLambda4(synchronizer));
        t.traceEnd();
        t.traceBegin("Permission_syncPackages-" + userId);
        PermissionToOpSynchroniser.m7184$$Nest$msyncPackages(synchronizer);
        t.traceEnd();
    }

    private static /* synthetic */ void lambda$synchronizePermissionsAndAppOpsForUser$1(PermissionToOpSynchroniser synchronizer, AndroidPackage pkg) {
        synchronizer.addPackage(pkg.getPackageName());
    }

    private void resetAppOpPermissionsIfNotRequestedForUidAsync(int uid) {
        if (isStarted(UserHandle.getUserId(uid)) == false) goto L15;
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.mIsUidResetScheduled.get(uid) == true) goto L11;
        this.mIsUidResetScheduled.put(uid, true);     // Catch: Throwable -> L9
        PermissionThread.getHandler().sendMessage(PooledLambda.obtainMessage(new PermissionPolicyService$$ExternalSyntheticLambda3(), this, Integer.valueOf(uid)));     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    }

    private void resetAppOpPermissionsIfNotRequestedForUid(int uid) {
        int r4 = uid;
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mIsUidResetScheduled.delete(r4);     // Catch: Throwable -> L39
        monitor-exit(r2);     // Catch: Throwable -> L39
        Context context = getContext();
        PackageManager userPackageManager = getUserContext(context, UserHandle.getUserHandleForUid(r4)).getPackageManager();
        String[] packageNames = userPackageManager.getPackagesForUid(r4);
        if (packageNames != null) goto L9;
        return;
    L9:
        if (packageNames.length == 0) goto L56;
        ArraySet<String> requestedPermissions = new ArraySet();
        int r3 = packageNames.length;
        int r5 = 0;
    L12:
        if (r5 >= r3) goto L22;
        PackageInfo packageInfo = userPackageManager.getPackageInfo(packageNames[r5], 4096);     // Catch: PackageManager.NameNotFoundException -> L20
        if (packageInfo == null) goto L21;
        if (packageInfo.requestedPermissions == null) goto L21;
        Collections.addAll(requestedPermissions, packageInfo.requestedPermissions);
    L21:
        r5 = r5 + 1;
        goto L12
    L22:
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        AppOpsManagerInternal appOpsManagerInternal = (AppOpsManagerInternal) LocalServices.getService(AppOpsManagerInternal.class);
        int appOpPermissionsSize = this.mAppOpPermissions.size();
        int i = 0;
    L23:
        if (i >= appOpPermissionsSize) goto L37;
        String appOpPermission = this.mAppOpPermissions.get(i);
        if (requestedPermissions.contains(appOpPermission) == true) goto L35;
        int appOpCode = AppOpsManager.permissionToOpCode(appOpPermission);
        int defaultAppOpMode = AppOpsManager.opToDefaultMode(appOpCode);
        int r6 = packageNames.length;
        int r7 = 0;
    L27:
        if (r7 >= r6) goto L35;
        int r16 = r6;
        String packageName = packageNames[r7];
        int appOpMode = appOpsManager.unsafeCheckOpRawNoThrow(appOpCode, r4, packageName);
        if (appOpMode == defaultAppOpMode) goto L32;
        appOpsManagerInternal.setUidModeFromPermissionPolicy(appOpCode, r4, defaultAppOpMode, this.mAppOpsCallback);
        appOpsManagerInternal.setModeFromPermissionPolicy(appOpCode, r4, packageName, defaultAppOpMode, this.mAppOpsCallback);
    L32:
        r7 = r7 + 1;
        r4 = uid;
        r6 = r16;
        appOpsManager = appOpsManager;
    L35:
        i = i + 1;
        r4 = uid;
        appOpsManager = appOpsManager;
        goto L23
    L37:
        return;
    L56:
        return;
    L39:
        th = move-exception;
        throw th;
    }
}
