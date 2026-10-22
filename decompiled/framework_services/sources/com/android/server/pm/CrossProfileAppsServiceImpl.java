package com.android.server.pm;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ActivityOptions;
import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.app.IApplicationThread;
import android.app.admin.DevicePolicyEventLogger;
import android.app.admin.DevicePolicyManagerInternal;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.PermissionChecker;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.CrossProfileAppsInternal;
import android.content.pm.ICrossProfileApps;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FunctionalUtils;
import com.android.server.LocalServices;
import com.android.server.pm.permission.PermissionManagerService;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class CrossProfileAppsServiceImpl extends ICrossProfileApps.Stub {
    private static final String TAG = "CrossProfileAppsService";
    private final Context mContext;
    private final Injector mInjector;
    private final LocalService mLocalService;

    public interface Injector {
        int checkComponentPermission(String r1, int r2, int r3, boolean r4);

        long clearCallingIdentity();

        ActivityManagerInternal getActivityManagerInternal();

        ActivityTaskManagerInternal getActivityTaskManagerInternal();

        AppOpsManager getAppOpsManager();

        int getCallingPid();

        int getCallingUid();

        UserHandle getCallingUserHandle();

        int getCallingUserId();

        DevicePolicyManagerInternal getDevicePolicyManagerInternal();

        IPackageManager getIPackageManager();

        PackageManager getPackageManager();

        PackageManagerInternal getPackageManagerInternal();

        UserManager getUserManager();

        void killUid(int r1);

        void restoreCallingIdentity(long r1);

        void sendBroadcastAsUser(Intent r1, UserHandle r2);

        <T> T withCleanCallingIdentity(FunctionalUtils.ThrowingSupplier<T> r1);

        void withCleanCallingIdentity(FunctionalUtils.ThrowingRunnable r1);
    }

    private static class InjectorImpl implements Injector {
        private final Context mContext;

        public InjectorImpl(Context context) {
            this.mContext = context;
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public int getCallingUid() {
            return Binder.getCallingUid();
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public int getCallingPid() {
            return Binder.getCallingPid();
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public int getCallingUserId() {
            return UserHandle.getCallingUserId();
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public UserHandle getCallingUserHandle() {
            return Binder.getCallingUserHandle();
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public long clearCallingIdentity() {
            return Binder.clearCallingIdentity();
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public void restoreCallingIdentity(long token) {
            Binder.restoreCallingIdentity(token);
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public void withCleanCallingIdentity(FunctionalUtils.ThrowingRunnable action) {
            Binder.withCleanCallingIdentity(action);
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public final <T> T withCleanCallingIdentity(FunctionalUtils.ThrowingSupplier<T> r2) {
            return (T) Binder.withCleanCallingIdentity(r2);
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public UserManager getUserManager() {
            return (UserManager) this.mContext.getSystemService(UserManager.class);
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public PackageManagerInternal getPackageManagerInternal() {
            return (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public PackageManager getPackageManager() {
            return this.mContext.getPackageManager();
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public AppOpsManager getAppOpsManager() {
            return (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public ActivityManagerInternal getActivityManagerInternal() {
            return (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public ActivityTaskManagerInternal getActivityTaskManagerInternal() {
            return (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public IPackageManager getIPackageManager() {
            return AppGlobals.getPackageManager();
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public DevicePolicyManagerInternal getDevicePolicyManagerInternal() {
            return (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public void sendBroadcastAsUser(Intent intent, UserHandle user) {
            this.mContext.sendBroadcastAsUser(intent, user);
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public int checkComponentPermission(String permission, int uid, int owningUid, boolean exported) {
            return ActivityManager.checkComponentPermission(permission, uid, owningUid, exported);
        }

        @Override // com.android.server.pm.CrossProfileAppsServiceImpl.Injector
        public void killUid(int uid) {
            PermissionManagerService.killUid(UserHandle.getAppId(uid), UserHandle.getUserId(uid), "permissions revoked");
        }
    }

    class LocalService extends CrossProfileAppsInternal {
        final /* synthetic */ CrossProfileAppsServiceImpl this$0;

        LocalService(CrossProfileAppsServiceImpl this$0) {
            this.this$0 = this$0;
        }

        public boolean verifyPackageHasInteractAcrossProfilePermission(String packageName, int userId) throws PackageManager.NameNotFoundException {
            PackageManager r0 = CrossProfileAppsServiceImpl.m6622$$Nest$fgetmInjector(this.this$0).getPackageManager();
            packageName.getClass();
            ApplicationInfo r1 = r0.getApplicationInfoAsUser(packageName, 0, userId);
            r1.getClass();
            int uid = r1.uid;
            return verifyUidHasInteractAcrossProfilePermission(packageName, uid);
        }

        public boolean verifyUidHasInteractAcrossProfilePermission(String packageName, int uid) {
            packageName.getClass();
            return CrossProfileAppsServiceImpl.m6624$$Nest$mhasInteractAcrossProfilesPermission(this.this$0, packageName, uid, -1);
        }

        public List<UserHandle> getTargetUserProfiles(String packageName, int userId) {
            return CrossProfileAppsServiceImpl.m6623$$Nest$mgetTargetUserProfilesUnchecked(this.this$0, packageName, userId);
        }

        public void setInteractAcrossProfilesAppOp(String packageName, int newMode, int userId) {
            CrossProfileAppsServiceImpl.m6625$$Nest$msetInteractAcrossProfilesAppOpUnchecked(this.this$0, packageName, newMode, userId);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$1q6O7czzis-ieohvRBof-j1MtmA, reason: not valid java name */
    public static /* synthetic */ Boolean m6616$r8$lambda$1q6O7czzisieohvRBofj1MtmA(CrossProfileAppsServiceImpl r0, int r1) {
        return r0.lambda$isManagedProfile$14(r1);
    }

    public static /* synthetic */ Boolean $r8$lambda$3b94qNwu3EgHZqk9byhP5SigzLo(CrossProfileAppsServiceImpl r0, int r1, String r2) {
        return r0.lambda$isCrossProfilePackageAllowlisted$1(r1, r2);
    }

    public static /* synthetic */ Integer $r8$lambda$7Gnb5nEhqQF18nrT3_a_SZS0tGw(CrossProfileAppsServiceImpl r0, String r1, UserHandle r2) {
        return r0.lambda$haveProfilesGotInteractAcrossProfilesPermission$0(r1, r2);
    }

    public static /* synthetic */ String $r8$lambda$7M0qYzyEYlknzcmjjC2rV5gyQtQ(ApplicationInfo r0) {
        return lambda$findAllPackageNames$12(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$KNm-BPmkcAcCG_BZLrZDJrEfmG8, reason: not valid java name */
    public static /* synthetic */ ComponentName m6617$r8$lambda$KNmBPmkcAcCG_BZLrZDJrEfmG8(CrossProfileAppsServiceImpl r0, int r1) {
        return r0.lambda$isProfileOwner$15(r1);
    }

    public static /* synthetic */ void $r8$lambda$NZ0PusYDX_IhtKX6qukMmV17X6U(CrossProfileAppsServiceImpl r0, int r1, int r2) {
        r0.lambda$setInteractAcrossProfilesAppOpForProfileOrThrow$8(r1, r2);
    }

    public static /* synthetic */ Boolean $r8$lambda$STFKVoQqrKBHvnq_bXRTyIZpNi4(CrossProfileAppsServiceImpl r0, int r1, String r2, int r3, String r4) {
        return r0.lambda$currentModeEquals$9(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$TNpOtPO-C0UcqheAqb9YRlNVdPA, reason: not valid java name */
    public static /* synthetic */ Boolean m6618$r8$lambda$TNpOtPOC0UcqheAqb9YRlNVdPA(CrossProfileAppsServiceImpl r0, int r1, int r2) {
        return r0.lambda$isSameProfileGroup$13(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$UOzpBnqLs7YPM4SAzIckq5OoeXY(CrossProfileAppsServiceImpl r0, Intent r1, int r2, int r3) {
        r0.lambda$verifyActivityCanHandleIntent$5(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$WQ7U-C4J-lNKzIvuDrSbbUN4Hy4, reason: not valid java name */
    public static /* synthetic */ Boolean m6619$r8$lambda$WQ7UC4JlNKzIvuDrSbbUN4Hy4(CrossProfileAppsServiceImpl r0, String r1, int r2, int r3) {
        return r0.lambda$isPackageEnabled$4(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$_ZpTPpyYbZ_pI_biZrhps9Od23M(CrossProfileAppsServiceImpl r0, Intent r1, int r2, int r3, ComponentName r4) {
        r0.lambda$verifyActivityCanHandleIntentAndExported$6(r1, r2, r3, r4);
    }

    public static /* synthetic */ Boolean $r8$lambda$bKB1A5xgWyhpXdyIkMAM5fYWivI(CrossProfileAppsServiceImpl r0, String r1) {
        return r0.lambda$isCrossProfilePackageAllowlistedByDefault$2(r1);
    }

    public static /* synthetic */ Boolean $r8$lambda$jMzR006nwGzHJvTaOjiCgdEN_kE(CrossProfileAppsServiceImpl r0, int r1, String r2) {
        return r0.lambda$hasOtherProfileWithPackageInstalled$10(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$p7Oy6sRcH-S1ZSrXYZmHOI0KHco, reason: not valid java name */
    public static /* synthetic */ void m6620$r8$lambda$p7Oy6sRcHS1ZSrXYZmHOI0KHco(CrossProfileAppsServiceImpl r0, int r1, int r2, String r3) {
        r0.lambda$clearInteractAcrossProfilesAppOps$11(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$qZjJDDDU0nsy6zkz3WU8u_N-bKI, reason: not valid java name */
    public static /* synthetic */ Boolean m6621$r8$lambda$qZjJDDDU0nsy6zkz3WU8u_NbKI(CrossProfileAppsServiceImpl r0, String r1, int r2) {
        return r0.lambda$isPackageInstalled$7(r1, r2);
    }

    public static /* synthetic */ List $r8$lambda$vikD5Mw9q_Jc9YJF2vwkg_I5o_A(CrossProfileAppsServiceImpl r0, int r1, String r2) {
        return r0.lambda$getTargetUserProfilesUnchecked$3(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m6622$$Nest$fgetmInjector(CrossProfileAppsServiceImpl r0) {
        return r0.mInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetTargetUserProfilesUnchecked, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m6623$$Nest$mgetTargetUserProfilesUnchecked(CrossProfileAppsServiceImpl r0, String r1, int r2) {
        return r0.getTargetUserProfilesUnchecked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhasInteractAcrossProfilesPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6624$$Nest$mhasInteractAcrossProfilesPermission(CrossProfileAppsServiceImpl r0, String r1, int r2, int r3) {
        return r0.hasInteractAcrossProfilesPermission(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msetInteractAcrossProfilesAppOpUnchecked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6625$$Nest$msetInteractAcrossProfilesAppOpUnchecked(CrossProfileAppsServiceImpl r0, String r1, int r2, int r3) {
        r0.setInteractAcrossProfilesAppOpUnchecked(r1, r2, r3);
    }

    public CrossProfileAppsServiceImpl(Context context) {
        this(context, new InjectorImpl(context));
    }

    CrossProfileAppsServiceImpl(Context context, Injector injector) {
        this.mLocalService = new LocalService(this);
        this.mContext = context;
        this.mInjector = injector;
    }

    public List<UserHandle> getTargetUserProfiles(String callingPackage) {
        callingPackage.getClass();
        verifyCallingPackage(callingPackage);
        DevicePolicyEventLogger.createEvent(125).setStrings(new String[]{callingPackage}).write();
        return getTargetUserProfilesUnchecked(callingPackage, this.mInjector.getCallingUserId());
    }

    public void startActivityAsUser(IApplicationThread caller, String callingPackage, String callingFeatureId, ComponentName component, int userId, boolean launchMainActivity, IBinder targetTask, Bundle options) throws RemoteException {
        callingPackage.getClass();
        component.getClass();
        verifyCallingPackage(callingPackage);
        DevicePolicyEventLogger.createEvent(126).setStrings(new String[]{callingPackage}).write();
        int callerUserId = this.mInjector.getCallingUserId();
        int callingUid = this.mInjector.getCallingUid();
        int callingPid = this.mInjector.getCallingPid();
        List<UserHandle> allowedTargetUsers = getTargetUserProfilesUnchecked(callingPackage, callerUserId);
        if (allowedTargetUsers.contains(UserHandle.of(userId)) == false) goto L38;
        if (callingPackage.equals(component.getPackageName()) == false) goto L36;
        Intent launchIntent = new Intent();
        if (launchMainActivity == false) goto L15;
        launchIntent.setAction("android.intent.action.MAIN");
        launchIntent.addCategory("android.intent.category.LAUNCHER");
        if (targetTask == null) goto L13;
        if (options != null) goto L13;
        launchIntent.addFlags(2097152);
    L14:
        launchIntent.setPackage(component.getPackageName());
    L29:
        verifyActivityCanHandleIntentAndExported(launchIntent, component, callingUid, userId);
        if (options != null) goto L32;
        Bundle options2 = ActivityOptions.makeOpenCrossProfileAppsAnimation().toBundle();
    L33:
        launchIntent.setPackage(null);
        launchIntent.setComponent(component);
        this.mInjector.getActivityTaskManagerInternal().startActivityAsUser(caller, callingPackage, callingFeatureId, launchIntent, targetTask, 0, options2, userId);
        return;
    L32:
        options.putAll(ActivityOptions.makeOpenCrossProfileAppsAnimation().toBundle());
        options2 = options;
    L13:
        launchIntent.addFlags(270532608);
        goto L14
    L15:
        if (callerUserId != userId) goto L17;
    L28:
        launchIntent.setComponent(component);
        goto L29
    L17:
        if (hasInteractAcrossProfilesPermission(callingPackage, callingUid, callingPid) == true) goto L24;
        if (isPermissionGranted("android.permission.START_CROSS_PROFILE_ACTIVITIES", callingUid) == true) goto L24;
        throw new SecurityException("Attempt to launch activity without one of the required android.permission.INTERACT_ACROSS_PROFILES or android.permission.START_CROSS_PROFILE_ACTIVITIES permissions.");
    L24:
        if (isSameProfileGroup(callerUserId, userId) == true) goto L28;
        throw new SecurityException("Attempt to launch activity when target user is not in the same profile group.");
    L36:
        throw new SecurityException(callingPackage + " attempts to start an activity in other package - " + component.getPackageName());
    L38:
        throw new SecurityException(callingPackage + " cannot access unrelated user " + userId);
    }

    public void startActivityAsUserByIntent(IApplicationThread caller, String callingPackage, String callingFeatureId, Intent intent, int userId, IBinder callingActivity, Bundle options) throws RemoteException {
        callingPackage.getClass();
        intent.getClass();
        intent.getComponent().getClass();
        verifyCallingPackage(callingPackage);
        int callerUserId = this.mInjector.getCallingUserId();
        int callingUid = this.mInjector.getCallingUid();
        List<UserHandle> allowedTargetUsers = getTargetUserProfilesUnchecked(callingPackage, callerUserId);
        if (callerUserId != userId) goto L5;
    L9:
        Intent launchIntent = new Intent(intent);
        launchIntent.setPackage(callingPackage);
        if (callingPackage.equals(launchIntent.getComponent().getPackageName()) == false) goto L20;
        if (callerUserId != userId) goto L13;
    L17:
        verifyActivityCanHandleIntent(launchIntent, callingUid, userId);
        this.mInjector.getActivityTaskManagerInternal().startActivityAsUser(caller, callingPackage, callingFeatureId, launchIntent, callingActivity, 0, options, userId);
        logStartActivityByIntent(callingPackage);
        return;
    L13:
        if (hasCallerGotInteractAcrossProfilesPermission(callingPackage) == true) goto L17;
        throw new SecurityException("Attempt to launch activity without required android.permission.INTERACT_ACROSS_PROFILES permission or target user is not in the same profile group.");
    L20:
        throw new SecurityException(callingPackage + " attempts to start an activity in other package - " + launchIntent.getComponent().getPackageName());
    L5:
        if (allowedTargetUsers.contains(UserHandle.of(userId)) == true) goto L9;
        throw new SecurityException(callingPackage + " cannot access unrelated user " + userId);
    }

    private void logStartActivityByIntent(String packageName) {
        DevicePolicyEventLogger.createEvent(150).setStrings(new String[]{packageName}).setBoolean(isCallingUserAManagedProfile()).write();
    }

    public boolean canRequestInteractAcrossProfiles(String callingPackage) {
        callingPackage.getClass();
        verifyCallingPackage(callingPackage);
        return canRequestInteractAcrossProfilesUnchecked(callingPackage);
    }

    private boolean canRequestInteractAcrossProfilesUnchecked(String packageName) {
        int callingUserId = this.mInjector.getCallingUserId();
        int[] enabledProfileIds = this.mInjector.getUserManager().getProfileIdsExcludingHidden(callingUserId, true);
        if (enabledProfileIds.length >= 2) goto L6;
        return false;
    L6:
        if (isProfileOwner(packageName, enabledProfileIds) == false) goto L9;
        return false;
    L9:
        return hasRequestedAppOpPermission(AppOpsManager.opToPermission(93), packageName, callingUserId);
    }

    private boolean hasRequestedAppOpPermission(String permission, String packageName, int userId) {
        String[] packages = this.mInjector.getIPackageManager().getAppOpPermissionPackages(permission, userId);     // Catch: RemoteException -> L4
        return ArrayUtils.contains(packages, packageName);
    L5:
        Slog.e(TAG, "PackageManager dead. Cannot get permission info");
        return false;
    }

    public boolean canInteractAcrossProfiles(String callingPackage) {
        callingPackage.getClass();
        verifyCallingPackage(callingPackage);
        List<UserHandle> targetUserProfiles = getTargetUserProfilesUnchecked(callingPackage, this.mInjector.getCallingUserId());
        if (targetUserProfiles.isEmpty() == false) goto L6;
        return false;
    L6:
        if (hasCallerGotInteractAcrossProfilesPermission(callingPackage) == true) goto L8;
        return false;
    L8:
        if (haveProfilesGotInteractAcrossProfilesPermission(callingPackage, targetUserProfiles) == false) goto L13;
        return true;
    L13:
        return false;
    }

    private boolean hasCallerGotInteractAcrossProfilesPermission(String callingPackage) {
        return hasInteractAcrossProfilesPermission(callingPackage, this.mInjector.getCallingUid(), this.mInjector.getCallingPid());
    }

    private boolean haveProfilesGotInteractAcrossProfilesPermission(final String packageName, List<UserHandle> profiles) {
        Iterator<UserHandle> r0 = profiles.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        final UserHandle profile = r0.next();
        int uid = ((Integer) this.mInjector.withCleanCallingIdentity(new CrossProfileAppsServiceImpl$$ExternalSyntheticLambda12(this, packageName, profile))).intValue();
        if (uid == (-1)) goto L7;
        if (hasInteractAcrossProfilesPermission(packageName, uid, -1) == true) goto L4;
        return false;
    L7:
        return false;
    L12:
        return true;
    }

    private /* synthetic */ Integer lambda$haveProfilesGotInteractAcrossProfilesPermission$0(String packageName, UserHandle profile) throws Exception {
        return Integer.valueOf(this.mInjector.getPackageManager().getPackageUidAsUser(packageName, 0, profile.getIdentifier()));
    L6:
        return -1;
    }

    private boolean isCrossProfilePackageAllowlisted(final String packageName) {
        final int userId = this.mInjector.getCallingUserId();
        return ((Boolean) this.mInjector.withCleanCallingIdentity(new CrossProfileAppsServiceImpl$$ExternalSyntheticLambda14(this, userId, packageName))).booleanValue();
    }

    private /* synthetic */ Boolean lambda$isCrossProfilePackageAllowlisted$1(int userId, String packageName) throws Exception {
        return Boolean.valueOf(this.mInjector.getDevicePolicyManagerInternal().getAllCrossProfilePackages(userId).contains(packageName));
    }

    private boolean isCrossProfilePackageAllowlistedByDefault(final String packageName) {
        return ((Boolean) this.mInjector.withCleanCallingIdentity(new CrossProfileAppsServiceImpl$$ExternalSyntheticLambda6(this, packageName))).booleanValue();
    }

    private /* synthetic */ Boolean lambda$isCrossProfilePackageAllowlistedByDefault$2(String packageName) throws Exception {
        return Boolean.valueOf(this.mInjector.getDevicePolicyManagerInternal().getDefaultCrossProfilePackages().contains(packageName));
    }

    private List<UserHandle> getTargetUserProfilesUnchecked(final String packageName, final int userId) {
        return (List) this.mInjector.withCleanCallingIdentity(new CrossProfileAppsServiceImpl$$ExternalSyntheticLambda9(this, userId, packageName));
    }

    private /* synthetic */ List lambda$getTargetUserProfilesUnchecked$3(int userId, String packageName) throws Exception {
        int[] enabledProfileIds = this.mInjector.getUserManager().getProfileIdsExcludingHidden(userId, true);
        List<UserHandle> targetProfiles = new ArrayList();
        int r2 = enabledProfileIds.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L12;
        int profileId = enabledProfileIds[r3];
        if (profileId == userId) goto L11;
        if (isPackageEnabled(packageName, profileId) == false) goto L11;
        targetProfiles.add(UserHandle.of(profileId));
    L11:
        r3 = r3 + 1;
        goto L3
    L12:
        return targetProfiles;
    }

    private boolean isPackageEnabled(final String packageName, final int userId) {
        final int callingUid = this.mInjector.getCallingUid();
        return ((Boolean) this.mInjector.withCleanCallingIdentity(new CrossProfileAppsServiceImpl$$ExternalSyntheticLambda11(this, packageName, callingUid, userId))).booleanValue();
    }

    private /* synthetic */ Boolean lambda$isPackageEnabled$4(String packageName, int callingUid, int userId) throws Exception {
        PackageInfo info = this.mInjector.getPackageManagerInternal().getPackageInfo(packageName, 786432, callingUid, userId);
        if (info != null) goto L5;
    L7:
        boolean r9 = false;
    L9:
        return Boolean.valueOf(r9);
    L5:
        if (info.applicationInfo.enabled == false) goto L7;
        r9 = true;
        goto L9
    }

    private void verifyActivityCanHandleIntent(final Intent launchIntent, final int callingUid, final int userId) {
        this.mInjector.withCleanCallingIdentity(new CrossProfileAppsServiceImpl$$ExternalSyntheticLambda13(this, launchIntent, callingUid, userId));
    }

    private /* synthetic */ void lambda$verifyActivityCanHandleIntent$5(Intent launchIntent, int callingUid, int userId) throws Exception {
        List<ResolveInfo> activities = this.mInjector.getPackageManagerInternal().queryIntentActivities(launchIntent, launchIntent.resolveTypeIfNeeded(this.mContext.getContentResolver()), 786432, callingUid, userId);
        if (activities.isEmpty() == true) goto L6;
        return;
    L6:
        throw new SecurityException("Activity cannot handle intent");
    }

    private void verifyActivityCanHandleIntentAndExported(final Intent launchIntent, final ComponentName component, final int callingUid, final int userId) {
        this.mInjector.withCleanCallingIdentity(new CrossProfileAppsServiceImpl$$ExternalSyntheticLambda0(this, launchIntent, callingUid, userId, component));
    }

    private /* synthetic */ void lambda$verifyActivityCanHandleIntentAndExported$6(Intent launchIntent, int callingUid, int userId, ComponentName component) throws Exception {
        List<ResolveInfo> apps = this.mInjector.getPackageManagerInternal().queryIntentActivities(launchIntent, launchIntent.resolveTypeIfNeeded(this.mContext.getContentResolver()), 786432, callingUid, userId);
        int size = apps.size();
        int i = 0;
    L3:
        if (i >= size) goto L13;
        ActivityInfo activityInfo = apps.get(i).activityInfo;
        if (TextUtils.equals(activityInfo.packageName, component.getPackageName()) == false) goto L11;
        if (TextUtils.equals(activityInfo.name, component.getClassName()) == false) goto L11;
        if (activityInfo.exported == false) goto L11;
        return;
    L11:
        i = i + 1;
        goto L3
    L13:
        throw new SecurityException("Attempt to launch activity without  category Intent.CATEGORY_LAUNCHER or activity is not exported" + component);
    }

    public void setInteractAcrossProfilesAppOp(int userId, String packageName, int newMode) {
        setInteractAcrossProfilesAppOp(packageName, newMode, userId);
    }

    private void setInteractAcrossProfilesAppOp(String packageName, int newMode, int userId) {
        int callingUid = this.mInjector.getCallingUid();
        if (isPermissionGranted("android.permission.INTERACT_ACROSS_USERS_FULL", callingUid) == true) goto L10;
        if (isPermissionGranted("android.permission.INTERACT_ACROSS_USERS", callingUid) == true) goto L10;
        throw new SecurityException("INTERACT_ACROSS_USERS or INTERACT_ACROSS_USERS_FULL is required to set the app-op for interacting across profiles.");
    L10:
        if (isPermissionGranted("android.permission.MANAGE_APP_OPS_MODES", callingUid) == false) goto L12;
    L16:
        setInteractAcrossProfilesAppOpUnchecked(packageName, newMode, userId);
        return;
    L12:
        if (isPermissionGranted("android.permission.CONFIGURE_INTERACT_ACROSS_PROFILES", callingUid) == true) goto L16;
        throw new SecurityException("MANAGE_APP_OPS_MODES or CONFIGURE_INTERACT_ACROSS_PROFILES is required to set the app-op for interacting across profiles.");
    }

    private void setInteractAcrossProfilesAppOpUnchecked(String packageName, int newMode, int userId) {
        if (newMode == 0) goto L4;
    L7:
        int[] profileIds = this.mInjector.getUserManager().getProfileIdsExcludingHidden(userId, false);
        int r2 = profileIds.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L17;
        int profileId = profileIds[r3];
        if (isPackageInstalled(packageName, profileId) == false) goto L16;
        if (profileId != userId) goto L14;
        boolean r5 = true;
    L15:
        setInteractAcrossProfilesAppOpForProfile(packageName, newMode, profileId, r5);
        goto L16
    L14:
        r5 = false;
    L16:
        r3 = r3 + 1;
        goto L8
    L17:
        return;
    L4:
        if (canConfigureInteractAcrossProfiles(packageName, userId) == true) goto L7;
        Slog.e(TAG, "Tried to turn on the appop for interacting across profiles for invalid app " + packageName);
    }

    private boolean isPackageInstalled(final String packageName, final int userId) {
        return ((Boolean) this.mInjector.withCleanCallingIdentity(new CrossProfileAppsServiceImpl$$ExternalSyntheticLambda4(this, packageName, userId))).booleanValue();
    }

    private /* synthetic */ Boolean lambda$isPackageInstalled$7(String packageName, int userId) throws Exception {
        PackageInfo info = this.mInjector.getPackageManagerInternal().getPackageInfo(packageName, 786432, this.mInjector.getCallingUid(), userId);
        if (info == null) goto L5;
        boolean r10 = true;
    L7:
        return Boolean.valueOf(r10);
    L5:
        r10 = false;
        goto L7
    }

    private void setInteractAcrossProfilesAppOpForProfile(String packageName, int newMode, int profileId, boolean logMetrics) {
        setInteractAcrossProfilesAppOpForProfileOrThrow(packageName, newMode, profileId, logMetrics);     // Catch: PackageManager.NameNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Missing package " + packageName + " on profile user ID " + profileId, e);
    }

    private void setInteractAcrossProfilesAppOpForProfileOrThrow(String packageName, final int newMode, int profileId, boolean logMetrics) throws PackageManager.NameNotFoundException {
        final int uid = this.mInjector.getPackageManager().getPackageUidAsUser(packageName, 0, profileId);
        if (currentModeEquals(newMode, packageName, uid) == false) goto L6;
        Slog.i(TAG, "Attempt to set mode to existing value of " + newMode + " for " + packageName + " on profile user ID " + profileId);
        return;
    L6:
        boolean hadPermission = hasInteractAcrossProfilesPermission(packageName, uid, -1);
        if (isPermissionGranted("android.permission.CONFIGURE_INTERACT_ACROSS_PROFILES", this.mInjector.getCallingUid()) == false) goto L9;
        this.mInjector.withCleanCallingIdentity(new CrossProfileAppsServiceImpl$$ExternalSyntheticLambda8(this, uid, newMode));
    L10:
        maybeKillUid(packageName, uid, hadPermission);
        sendCanInteractAcrossProfilesChangedBroadcast(packageName, UserHandle.of(profileId));
        maybeLogSetInteractAcrossProfilesAppOp(packageName, newMode, logMetrics);
        return;
    L9:
        this.mInjector.getAppOpsManager().setUidMode(93, uid, newMode);
        goto L10
    }

    private /* synthetic */ void lambda$setInteractAcrossProfilesAppOpForProfileOrThrow$8(int uid, int newMode) throws Exception {
        this.mInjector.getAppOpsManager().setUidMode(93, uid, newMode);
    }

    private void maybeKillUid(String packageName, int uid, boolean hadPermission) {
        if (hadPermission == true) goto L5;
        return;
    L5:
        if (hasInteractAcrossProfilesPermission(packageName, uid, -1) == false) goto L7;
        return;
    L7:
        this.mInjector.killUid(uid);
    }

    private void maybeLogSetInteractAcrossProfilesAppOp(String packageName, int newMode, boolean logMetrics) {
        if (logMetrics == true) goto L4;
        return;
    L4:
        DevicePolicyEventLogger.createEvent(139).setStrings(new String[]{packageName}).setInt(newMode).setBoolean(appDeclaresCrossProfileAttribute(packageName)).write();
    }

    private boolean currentModeEquals(final int otherMode, final String packageName, final int uid) {
        final String op = AppOpsManager.permissionToOp("android.permission.INTERACT_ACROSS_PROFILES");
        return ((Boolean) this.mInjector.withCleanCallingIdentity(new CrossProfileAppsServiceImpl$$ExternalSyntheticLambda5(this, otherMode, op, uid, packageName))).booleanValue();
    }

    private /* synthetic */ Boolean lambda$currentModeEquals$9(int otherMode, String op, int uid, String packageName) throws Exception {
        if (otherMode != this.mInjector.getAppOpsManager().unsafeCheckOpNoThrow(op, uid, packageName)) goto L5;
        boolean r0 = true;
    L7:
        return Boolean.valueOf(r0);
    L5:
        r0 = false;
        goto L7
    }

    private void sendCanInteractAcrossProfilesChangedBroadcast(String packageName, UserHandle userHandle) {
        Intent intent = new Intent("android.content.pm.action.CAN_INTERACT_ACROSS_PROFILES_CHANGED").setPackage(packageName);
        if (appDeclaresCrossProfileAttribute(packageName) == false) goto L5;
        intent.addFlags(AudioFormat.EVRCB);
    L6:
        Iterator<ResolveInfo> r1 = findBroadcastReceiversForUser(intent, userHandle).iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ResolveInfo receiver = r1.next();
        intent.setComponent(receiver.getComponentInfo().getComponentName());
        this.mInjector.sendBroadcastAsUser(intent, userHandle);
        goto L8
    L10:
        return;
    L5:
        intent.addFlags(1073741824);
        goto L6
    }

    private List<ResolveInfo> findBroadcastReceiversForUser(Intent intent, UserHandle userHandle) {
        return this.mInjector.getPackageManager().queryBroadcastReceiversAsUser(intent, 0, userHandle);
    }

    private boolean appDeclaresCrossProfileAttribute(String packageName) {
        return this.mInjector.getPackageManagerInternal().getPackage(packageName).isCrossProfile();
    }

    public boolean canConfigureInteractAcrossProfiles(int userId, String packageName) {
        if (this.mInjector.getCallingUserId() == userId) goto L6;
        this.mContext.checkCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS");
    L6:
        return canConfigureInteractAcrossProfiles(packageName, userId);
    }

    private boolean canConfigureInteractAcrossProfiles(String packageName, int userId) {
        if (canUserAttemptToConfigureInteractAcrossProfiles(packageName, userId) == true) goto L6;
        return false;
    L6:
        if (hasOtherProfileWithPackageInstalled(packageName, userId) == true) goto L9;
        return false;
    L9:
        if (hasRequestedAppOpPermission(AppOpsManager.opToPermission(93), packageName, userId) == true) goto L12;
        return false;
    L12:
        return isCrossProfilePackageAllowlisted(packageName);
    }

    public boolean canUserAttemptToConfigureInteractAcrossProfiles(int userId, String packageName) {
        if (this.mInjector.getCallingUserId() == userId) goto L6;
        this.mContext.checkCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS");
    L6:
        return canUserAttemptToConfigureInteractAcrossProfiles(packageName, userId);
    }

    private boolean canUserAttemptToConfigureInteractAcrossProfiles(String packageName, int userId) {
        int[] profileIds = this.mInjector.getUserManager().getProfileIdsExcludingHidden(userId, false);
        if (profileIds.length >= 2) goto L6;
        return false;
    L6:
        if (isProfileOwner(packageName, profileIds) == false) goto L9;
        return false;
    L9:
        if (hasRequestedAppOpPermission(AppOpsManager.opToPermission(93), packageName, userId) == true) goto L12;
        return false;
    L12:
        return !isPlatformSignedAppWithNonUserConfigurablePermission(packageName, profileIds);
    }

    private boolean isPlatformSignedAppWithNonUserConfigurablePermission(String packageName, int[] profileIds) {
        if (isCrossProfilePackageAllowlistedByDefault(packageName) == false) goto L5;
    L7:
        return false;
    L5:
        if (isPlatformSignedAppWithAutomaticProfilesPermission(packageName, profileIds) == false) goto L7;
        return true;
    }

    private boolean isPlatformSignedAppWithAutomaticProfilesPermission(String packageName, int[] profileIds) {
        int r0 = profileIds.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        int userId = profileIds[r2];
        int uid = this.mInjector.getPackageManagerInternal().getPackageUid(packageName, 0, userId);
        if (uid == (-1)) goto L11;
        if (isPermissionGranted("android.permission.INTERACT_ACROSS_PROFILES", uid) == false) goto L11;
        return true;
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return false;
    }

    private boolean hasOtherProfileWithPackageInstalled(final String packageName, final int userId) {
        return ((Boolean) this.mInjector.withCleanCallingIdentity(new CrossProfileAppsServiceImpl$$ExternalSyntheticLambda15(this, userId, packageName))).booleanValue();
    }

    private /* synthetic */ Boolean lambda$hasOtherProfileWithPackageInstalled$10(int userId, String packageName) throws Exception {
        int[] profileIds = this.mInjector.getUserManager().getProfileIdsExcludingHidden(userId, false);
        int r2 = profileIds.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L12;
        int profileId = profileIds[r3];
        if (profileId == userId) goto L10;
        if (isPackageInstalled(packageName, profileId) == false) goto L10;
        return true;
    L10:
        r3 = r3 + 1;
        goto L3
    L12:
        return false;
    }

    public void resetInteractAcrossProfilesAppOps(int userId, List<String> packageNames) {
        Iterator<String> r0 = packageNames.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String packageName = r0.next();
        resetInteractAcrossProfilesAppOp(userId, packageName);
        goto L4
    }

    private void resetInteractAcrossProfilesAppOp(int userId, String packageName) {
        if (canConfigureInteractAcrossProfiles(packageName, userId) == false) goto L6;
        Slog.w(TAG, "Not resetting app-op for package " + packageName + " since it is still configurable by users.");
        return;
    L6:
        String op = AppOpsManager.permissionToOp("android.permission.INTERACT_ACROSS_PROFILES");
        setInteractAcrossProfilesAppOp(userId, packageName, AppOpsManager.opToDefaultMode(op));
    }

    public void clearInteractAcrossProfilesAppOps(final int userId) {
        final int defaultMode = AppOpsManager.opToDefaultMode(AppOpsManager.permissionToOp("android.permission.INTERACT_ACROSS_PROFILES"));
        findAllPackageNames().forEach(new CrossProfileAppsServiceImpl$$ExternalSyntheticLambda7(this, userId, defaultMode));
    }

    private /* synthetic */ void lambda$clearInteractAcrossProfilesAppOps$11(int userId, int defaultMode, String packageName) {
        setInteractAcrossProfilesAppOp(userId, packageName, defaultMode);
    }

    private List<String> findAllPackageNames() {
        return (List) this.mInjector.getPackageManagerInternal().getInstalledApplications(0, this.mInjector.getCallingUserId(), this.mInjector.getCallingUid()).stream().map(new CrossProfileAppsServiceImpl$$ExternalSyntheticLambda2()).collect(Collectors.toList());
    }

    private static /* synthetic */ String lambda$findAllPackageNames$12(ApplicationInfo applicationInfo) {
        return applicationInfo.packageName;
    }

    CrossProfileAppsInternal getLocalService() {
        return this.mLocalService;
    }

    private boolean isSameProfileGroup(final int callerUserId, final int userId) {
        return ((Boolean) this.mInjector.withCleanCallingIdentity(new CrossProfileAppsServiceImpl$$ExternalSyntheticLambda10(this, callerUserId, userId))).booleanValue();
    }

    private /* synthetic */ Boolean lambda$isSameProfileGroup$13(int callerUserId, int userId) throws Exception {
        return Boolean.valueOf(this.mInjector.getUserManager().isSameProfileGroup(callerUserId, userId));
    }

    private void verifyCallingPackage(String callingPackage) {
        this.mInjector.getAppOpsManager().checkPackage(this.mInjector.getCallingUid(), callingPackage);
    }

    private boolean isPermissionGranted(String permission, int uid) {
        if (this.mInjector.checkComponentPermission(permission, uid, -1, true) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isCallingUserAManagedProfile() {
        return isManagedProfile(this.mInjector.getCallingUserId());
    }

    private boolean isManagedProfile(final int userId) {
        return ((Boolean) this.mInjector.withCleanCallingIdentity(new CrossProfileAppsServiceImpl$$ExternalSyntheticLambda1(this, userId))).booleanValue();
    }

    private /* synthetic */ Boolean lambda$isManagedProfile$14(int userId) throws Exception {
        return Boolean.valueOf(((UserManager) this.mContext.getSystemService(UserManager.class)).isManagedProfile(userId));
    }

    private boolean hasInteractAcrossProfilesPermission(String packageName, int uid, int pid) {
        if (isPermissionGranted("android.permission.INTERACT_ACROSS_USERS_FULL", uid) == false) goto L5;
    L12:
        return true;
    L5:
        if (isPermissionGranted("android.permission.INTERACT_ACROSS_USERS", uid) == true) goto L12;
        if (PermissionChecker.checkPermissionForPreflight(this.mContext, "android.permission.INTERACT_ACROSS_PROFILES", pid, uid, packageName) == 0) goto L13;
        return false;
    L13:
        return true;
    }

    private boolean isProfileOwner(String packageName, int[] userIds) {
        int r0 = userIds.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        int userId = userIds[r2];
        if (isProfileOwner(packageName, userId) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private boolean isProfileOwner(String packageName, final int userId) {
        ComponentName profileOwner = (ComponentName) this.mInjector.withCleanCallingIdentity(new CrossProfileAppsServiceImpl$$ExternalSyntheticLambda3(this, userId));
        if (profileOwner != null) goto L7;
        return false;
    L7:
        return profileOwner.getPackageName().equals(packageName);
    }

    private /* synthetic */ ComponentName lambda$isProfileOwner$15(int userId) throws Exception {
        return this.mInjector.getDevicePolicyManagerInternal().getProfileOwnerAsUser(userId);
    }
}
