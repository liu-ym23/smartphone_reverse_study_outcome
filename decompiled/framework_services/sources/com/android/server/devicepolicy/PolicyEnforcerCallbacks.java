package com.android.server.devicepolicy;

import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.app.admin.DevicePolicyCache;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.admin.IntentFilterPolicyKey;
import android.app.admin.LockTaskPolicy;
import android.app.admin.PackagePermissionPolicyKey;
import android.app.admin.PackagePolicyKey;
import android.app.admin.PolicyKey;
import android.app.admin.UserRestrictionPolicyKey;
import android.app.usage.UsageStatsManagerInternal;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.UserInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.permission.AdminPermissionControlParams;
import android.permission.PermissionControllerManager;
import android.provider.Settings;
import android.util.ArraySet;
import android.util.Slog;
import android.view.IWindowManager;
import com.android.internal.infra.AndroidFuture;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.ArrayUtils;
import com.android.server.LocalServices;
import com.android.server.pm.UserManagerInternal;
import com.android.server.utils.Slogf;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class PolicyEnforcerCallbacks {
    private static final String LOG_TAG = "PolicyEnforcerCallbacks";

    private static class BlockingCallback {
        private final CountDownLatch mLatch;
        private final AtomicReference<Boolean> mValue;

        /* synthetic */ BlockingCallback(PolicyEnforcerCallbacksIA r1) {
            this();
        }

        private BlockingCallback() {
            this.mLatch = new CountDownLatch(1);
            this.mValue = new AtomicReference();
        }

        public void trigger(Boolean value) {
            this.mValue.set(value);
            this.mLatch.countDown();
        }

        public Boolean await(long timeout, TimeUnit unit) throws InterruptedException {
            if (this.mLatch.await(timeout, unit) == true) goto L6;
            Slogf.e(PolicyEnforcerCallbacks.LOG_TAG, "Callback was not received");
        L6:
            return this.mValue.get();
        }
    }

    public static /* synthetic */ void $r8$lambda$3A7A7sIJ5RIm2lhycHAktZ_v_wg(Boolean r0, Context r1, int r2) {
        lambda$setPersonalAppsSuspended$13(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$4ggaUHwmXRH9DSZY2qstuZxIcwI(Context r0, int r1, Set r2) {
        lambda$setUserControlDisabledPackages$4(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$923vf4aExZGFKsRX2l5EqcJweW4() {
        lambda$updateScreenCaptureDisabled$12();
    }

    public static /* synthetic */ AndroidFuture $r8$lambda$D1RBEpFVJNTU1BZDBtLcWbDin4w(PolicyKey r0, Boolean r1, int r2) {
        return lambda$setApplicationHidden$9(r0, r1, r2);
    }

    public static /* synthetic */ AndroidFuture $r8$lambda$GufZ51Ay23GzqrICE8M3gGd8Aqc(Context r0, Boolean r1) {
        return lambda$setUsbDataSignalingEnabled$14(r0, r1);
    }

    public static /* synthetic */ AndroidFuture $r8$lambda$L1rxGGUzNJ4aUGTAR8iOoKaDmig(Context r0, Integer r1) {
        return lambda$setAutoTimePolicy$3(r0, r1);
    }

    public static /* synthetic */ AndroidFuture $r8$lambda$QKViEWd2gERgQLjX9mqDPmUb95w(Context r0, Integer r1) {
        return lambda$setAutoTimeZonePolicy$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$UERPhmxAVy3sxr1v41E8a4Miyr0(PolicyKey r0, ComponentName r1, int r2) {
        lambda$addPersistentPreferredActivity$6(r0, r1, r2);
    }

    public static /* synthetic */ AndroidFuture $r8$lambda$WijCbL7fEj9lotKYMgvPtIYYdmE(PolicyKey r0, int r1, Boolean r2) {
        return lambda$setUserRestriction$8(r0, r1, r2);
    }

    public static /* synthetic */ AndroidFuture $r8$lambda$gxoPg1ULKK1uZv0lpeBqocEMEys(PolicyKey r0, Boolean r1, int r2) {
        return lambda$setUninstallBlocked$7(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$hroBZBFtiu0Fc4d2ycR1WqFQV2U(PolicyKey r0, Context r1, Integer r2) {
        lambda$setApplicationRestrictions$2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$mhU4RwcN2rvgJiX5zFqW30EJig0(Integer r0, Integer r1) {
        lambda$setContentProtectionPolicy$11(r0, r1);
    }

    public static /* synthetic */ Integer $r8$lambda$o4x0wEv9V1ApGxPYNb629kkq4D0(UserInfo r0) {
        return lambda$resolveUsers$5(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$zi0x2TqIW93rOUZeDZ-HpdjcV44, reason: not valid java name */
    public static /* synthetic */ void m3518$r8$lambda$zi0x2TqIW93rOUZeDZHpdjcV44(int r0, Boolean r1) {
        lambda$setScreenCaptureDisabled$10(r0, r1);
    }

    PolicyEnforcerCallbacks() {
    }

    static <T> CompletableFuture<Boolean> noOp(T value, Context context, Integer userId, PolicyKey policyKey) {
        return AndroidFuture.completedFuture(true);
    }

    static CompletableFuture<Boolean> setAutoTimeZonePolicy(final Integer policy, final Context context, int userId, PolicyKey policyKey) {
        return (CompletableFuture) Binder.withCleanCallingIdentity(new PolicyEnforcerCallbacks$$ExternalSyntheticLambda13(context, policy));
    }

    private static /* synthetic */ AndroidFuture lambda$setAutoTimeZonePolicy$0(Context context, Integer policy) throws Exception {
        context.getClass();
        int enabled = 0;
        if (policy != null) goto L5;
    L8:
        if (policy == null) goto L14;
        if (policy.intValue() != 2) goto L14;
        enabled = 1;
    L14:
        return AndroidFuture.completedFuture(Boolean.valueOf(Settings.Global.putInt(context.getContentResolver(), "auto_time_zone", enabled)));
    L5:
        if (policy.intValue() != 0) goto L8;
        return AndroidFuture.completedFuture(false);
    }

    static CompletableFuture<Boolean> setPermissionGrantState(Integer grantState, Context context, int userId, PolicyKey policyKey) {
        Slogf.w(LOG_TAG, "Trying to enforce setPermissionGrantState while flag is off.");
        return AndroidFuture.completedFuture(true);
    }

    private static /* synthetic */ AndroidFuture lambda$setPermissionGrantState$1(PolicyKey policyKey, Context context, Integer grantState, int userId) throws Exception {
        if ((policyKey instanceof PackagePermissionPolicyKey) == false) goto L15;
        PackagePermissionPolicyKey parsedKey = (PackagePermissionPolicyKey) policyKey;
        parsedKey.getPermissionName().getClass();
        parsedKey.getPackageName().getClass();
        context.getClass();
        if (grantState != null) goto L7;
        int value = 0;
    L8:
        final BlockingCallback callback = new BlockingCallback(null);
        AdminPermissionControlParams permissionParams = new AdminPermissionControlParams(parsedKey.getPackageName(), parsedKey.getPermissionName(), value, true);
        getPermissionControllerManager(context, UserHandle.of(userId)).setRuntimePermissionGrantStateByDeviceAdmin(context.getPackageName(), permissionParams, context.getMainExecutor(), new PolicyEnforcerCallbacks$$ExternalSyntheticLambda0(callback));
        return AndroidFuture.completedFuture(callback.await(20000, TimeUnit.MILLISECONDS));
    L13:
        return AndroidFuture.completedFuture(false);
    L7:
        value = grantState.intValue();
        goto L8
    L15:
        throw new IllegalArgumentException("policyKey is not of type PermissionGrantStatePolicyKey, passed in policyKey is: " + policyKey);
    }

    private static PermissionControllerManager getPermissionControllerManager(Context context, UserHandle user) {
        if (user.equals(context.getUser()) == true) goto L5;
        return (PermissionControllerManager) context.createPackageContextAsUser(context.getPackageName(), 0, user).getSystemService(PermissionControllerManager.class);
    L8:
        notPossible = move-exception;
        throw new IllegalStateException(notPossible);
    L5:
        return (PermissionControllerManager) context.getSystemService(PermissionControllerManager.class);
    }

    static CompletableFuture<Boolean> enforceSecurityLogging(Boolean value, Context context, int userId, PolicyKey policyKey) {
        DevicePolicyManagerInternal dpmi = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        dpmi.enforceSecurityLoggingPolicy(Boolean.TRUE.equals(value));
        return AndroidFuture.completedFuture(true);
    }

    static CompletableFuture<Boolean> enforceAuditLogging(Boolean value, Context context, int userId, PolicyKey policyKey) {
        DevicePolicyManagerInternal dpmi = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        dpmi.enforceAuditLoggingPolicy(Boolean.TRUE.equals(value));
        return AndroidFuture.completedFuture(true);
    }

    static CompletableFuture<Boolean> setLockTask(LockTaskPolicy policy, Context context, int userId) {
        List<String> packages = Collections.emptyList();
        int flags = 16;
        if (policy == null) goto L5;
        packages = List.copyOf(policy.getPackages());
        flags = policy.getFlags();
    L5:
        DevicePolicyManagerService.updateLockTaskPackagesLocked(context, packages, userId);
        DevicePolicyManagerService.updateLockTaskFeaturesLocked(flags, userId);
        return AndroidFuture.completedFuture(true);
    }

    static CompletableFuture<Boolean> setApplicationRestrictions(Bundle bundle, final Context context, final Integer userId, final PolicyKey policyKey) {
        Binder.withCleanCallingIdentity(new PolicyEnforcerCallbacks$$ExternalSyntheticLambda11(policyKey, context, userId));
        return AndroidFuture.completedFuture(true);
    }

    private static /* synthetic */ void lambda$setApplicationRestrictions$2(PolicyKey policyKey, Context context, Integer userId) throws Exception {
        PackagePolicyKey key = (PackagePolicyKey) policyKey;
        String packageName = key.getPackageName();
        packageName.getClass();
        Intent changeIntent = new Intent("android.intent.action.APPLICATION_RESTRICTIONS_CHANGED");
        changeIntent.setPackage(packageName);
        changeIntent.addFlags(1073741824);
        context.sendBroadcastAsUser(changeIntent, UserHandle.of(userId.intValue()));
    }

    public static CompletableFuture<Boolean> setAutoTimePolicy(final Integer policy, final Context context, Integer userId, PolicyKey policyKey) {
        return (CompletableFuture) Binder.withCleanCallingIdentity(new PolicyEnforcerCallbacks$$ExternalSyntheticLambda2(context, policy));
    }

    private static /* synthetic */ AndroidFuture lambda$setAutoTimePolicy$3(Context context, Integer policy) throws Exception {
        context.getClass();
        int enabled = 0;
        if (policy != null) goto L5;
    L8:
        if (policy == null) goto L13;
        if (policy.intValue() != 2) goto L13;
        enabled = 1;
    L13:
        return AndroidFuture.completedFuture(Boolean.valueOf(Settings.Global.putInt(context.getContentResolver(), "auto_time", enabled)));
    L5:
        if (policy.intValue() != 0) goto L8;
        return AndroidFuture.completedFuture(false);
    }

    static CompletableFuture<Boolean> setUserControlDisabledPackages(final Set<String> packages, final Context context, final int userId, PolicyKey policyKey) {
        Binder.withCleanCallingIdentity(new PolicyEnforcerCallbacks$$ExternalSyntheticLambda1(context, userId, packages));
        return AndroidFuture.completedFuture(true);
    }

    private static /* synthetic */ void lambda$setUserControlDisabledPackages$4(Context context, int userId, Set packages) throws Exception {
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        ArraySet r2 = null;
        if (packages != null) goto L5;
        List<String> r3 = null;
    L6:
        pmi.setOwnerProtectedPackages(userId, r3);
        UsageStatsManagerInternal r4 = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
        if (packages == null) goto L10;
        r2 = new ArraySet(packages);
    L10:
        r4.setAdminProtectedPackages(r2, userId);
        if (packages != null) goto L13;
        return;
    L13:
        if (packages.isEmpty() == true) goto L27;
        Iterator<Integer> r5 = resolveUsers(userId).iterator();
    L17:
        if (r5.hasNext() == false) goto L23;
        int user = r5.next().intValue();
        setBgUsageAppOp(packages, pmi, user, appOpsManager);
        Iterator r6 = packages.iterator();
    L20:
        if (r6.hasNext() == false) goto L17;
        String packageName = (String) r6.next();
        pmi.setPackageStoppedState(packageName, false, user);
        goto L20
    L23:
        return;
    L27:
        return;
    L5:
        r3 = packages.stream().toList();
        goto L6
    }

    private static List<Integer> resolveUsers(int userId) {
        if (userId != (-1)) goto L7;
        UserManagerInternal userManager = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        return userManager.getUsers(true).stream().map(new PolicyEnforcerCallbacks$$ExternalSyntheticLambda9()).toList();
    L7:
        return List.of(Integer.valueOf(userId));
    }

    private static /* synthetic */ Integer lambda$resolveUsers$5(UserInfo ui) {
        return Integer.valueOf(ui.id);
    }

    private static void setBgUsageAppOp(Set<String> packages, PackageManagerInternal pmi, int userId, AppOpsManager appOpsManager) {
        Iterator<String> r0 = packages.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        String pkg = r0.next();
        PackageManagerInternal pmi2 = pmi;
        int userId2 = userId;
        ApplicationInfo appInfo = pmi2.getApplicationInfo(pkg, 786432, Process.myUid(), userId2);
        if (appInfo == null) goto L8;
        DevicePolicyManagerService.setBgUsageAppOp(appOpsManager, appInfo);
    L8:
        pmi = pmi2;
        userId = userId2;
        goto L4
    }

    static CompletableFuture<Boolean> addPersistentPreferredActivity(final ComponentName preferredActivity, Context context, final int userId, final PolicyKey policyKey) {
        Binder.withCleanCallingIdentity(new PolicyEnforcerCallbacks$$ExternalSyntheticLambda10(policyKey, preferredActivity, userId));
        return AndroidFuture.completedFuture(true);
    }

    private static /* synthetic */ void lambda$addPersistentPreferredActivity$6(PolicyKey policyKey, ComponentName preferredActivity, int userId) throws Exception {
    L7:
        re = move-exception;
        Slog.wtf(LOG_TAG, "Error adding/removing persistent preferred activity", re);
        return;
    L3:
        if ((policyKey instanceof IntentFilterPolicyKey) == false) goto L12;
        IntentFilterPolicyKey parsedKey = (IntentFilterPolicyKey) policyKey;     // Catch: RemoteException -> L7
        IntentFilter filter = parsedKey.getIntentFilter();     // Catch: RemoteException -> L7
        filter.getClass();     // Catch: RemoteException -> L7
        IPackageManager packageManager = AppGlobals.getPackageManager();     // Catch: RemoteException -> L7
        if (preferredActivity == null) goto L9;
        packageManager.addPersistentPreferredActivity(filter, preferredActivity, userId);     // Catch: RemoteException -> L7
    L10:
        packageManager.flushPackageRestrictionsAsUser(userId);     // Catch: RemoteException -> L7
        return;
    L9:
        packageManager.clearPersistentPreferredActivity(filter, userId);     // Catch: RemoteException -> L7
        goto L10
    L12:
        throw new IllegalArgumentException("policyKey is not of type IntentFilterPolicyKey, passed in policyKey is: " + policyKey);     // Catch: RemoteException -> L7
    }

    static CompletableFuture<Boolean> setUninstallBlocked(final Boolean uninstallBlocked, Context context, final int userId, final PolicyKey policyKey) {
        return (CompletableFuture) Binder.withCleanCallingIdentity(new PolicyEnforcerCallbacks$$ExternalSyntheticLambda5(policyKey, uninstallBlocked, userId));
    }

    private static /* synthetic */ AndroidFuture lambda$setUninstallBlocked$7(PolicyKey policyKey, Boolean uninstallBlocked, int userId) throws Exception {
        if ((policyKey instanceof PackagePolicyKey) == false) goto L13;
        PackagePolicyKey parsedKey = (PackagePolicyKey) policyKey;
        String packageName = parsedKey.getPackageName();
        packageName.getClass();
        if (uninstallBlocked != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        DevicePolicyManagerService.setUninstallBlockedUnchecked(packageName, r3, userId);
        return AndroidFuture.completedFuture(true);
    L7:
        if (uninstallBlocked.booleanValue() == false) goto L9;
        r3 = true;
        goto L10
    L13:
        throw new IllegalArgumentException("policyKey is not of type PackagePolicyKey, passed in policyKey is: " + policyKey);
    }

    static CompletableFuture<Boolean> setUserRestriction(final Boolean enabled, Context context, final int userId, final PolicyKey policyKey) {
        return (CompletableFuture) Binder.withCleanCallingIdentity(new PolicyEnforcerCallbacks$$ExternalSyntheticLambda14(policyKey, userId, enabled));
    }

    private static /* synthetic */ AndroidFuture lambda$setUserRestriction$8(PolicyKey policyKey, int userId, Boolean enabled) throws Exception {
        if ((policyKey instanceof UserRestrictionPolicyKey) == false) goto L13;
        UserRestrictionPolicyKey parsedKey = (UserRestrictionPolicyKey) policyKey;
        UserManagerInternal userManager = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        String r2 = parsedKey.getRestriction();
        if (enabled != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        userManager.setUserRestriction(userId, r2, r4);
        return AndroidFuture.completedFuture(true);
    L7:
        if (enabled.booleanValue() == false) goto L9;
        r4 = true;
        goto L10
    L13:
        throw new IllegalArgumentException("policyKey is not of type UserRestrictionPolicyKey, passed in policyKey is: " + policyKey);
    }

    static CompletableFuture<Boolean> setApplicationHidden(final Boolean hide, Context context, final int userId, final PolicyKey policyKey) {
        return (CompletableFuture) Binder.withCleanCallingIdentity(new PolicyEnforcerCallbacks$$ExternalSyntheticLambda7(policyKey, hide, userId));
    }

    private static /* synthetic */ AndroidFuture lambda$setApplicationHidden$9(PolicyKey policyKey, Boolean hide, int userId) throws Exception {
        if ((policyKey instanceof PackagePolicyKey) == false) goto L13;
        PackagePolicyKey parsedKey = (PackagePolicyKey) policyKey;
        String packageName = parsedKey.getPackageName();
        packageName.getClass();
        IPackageManager packageManager = AppGlobals.getPackageManager();
        if (hide != null) goto L7;
    L9:
        boolean r3 = false;
    L11:
        return AndroidFuture.completedFuture(Boolean.valueOf(packageManager.setApplicationHiddenSettingAsUser(packageName, r3, userId)));
    L7:
        if (hide.booleanValue() == false) goto L9;
        r3 = true;
        goto L11
    L13:
        throw new IllegalArgumentException("policyKey is not of type PackagePolicyKey, passed in policyKey is: " + policyKey);
    }

    static CompletableFuture<Boolean> setScreenCaptureDisabled(final Boolean disabled, Context context, final int userId, PolicyKey policyKey) {
        Binder.withCleanCallingIdentity(new PolicyEnforcerCallbacks$$ExternalSyntheticLambda4(userId, disabled));
        return AndroidFuture.completedFuture(true);
    }

    private static /* synthetic */ void lambda$setScreenCaptureDisabled$10(int userId, Boolean disabled) throws Exception {
        DevicePolicyCache cache = DevicePolicyCache.getInstance();
        if ((cache instanceof DevicePolicyCacheImpl) == false) goto L12;
        DevicePolicyCacheImpl parsedCache = (DevicePolicyCacheImpl) cache;
        if (disabled != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        parsedCache.setScreenCaptureDisallowedUser(userId, r2);
        updateScreenCaptureDisabled();
        return;
    L7:
        if (disabled.booleanValue() == false) goto L9;
        r2 = true;
        goto L10
    }

    static CompletableFuture<Boolean> setContentProtectionPolicy(final Integer value, Context context, final Integer userId, PolicyKey policyKey) {
        Binder.withCleanCallingIdentity(new PolicyEnforcerCallbacks$$ExternalSyntheticLambda3(userId, value));
        return AndroidFuture.completedFuture(true);
    }

    private static /* synthetic */ void lambda$setContentProtectionPolicy$11(Integer userId, Integer value) throws Exception {
        DevicePolicyCache cache = DevicePolicyCache.getInstance();
        if ((cache instanceof DevicePolicyCacheImpl) == false) goto L6;
        DevicePolicyCacheImpl cacheImpl = (DevicePolicyCacheImpl) cache;
        cacheImpl.setContentProtectionPolicy(userId.intValue(), value);
        return;
    }

    private static void updateScreenCaptureDisabled() {
        BackgroundThread.getHandler().post(new PolicyEnforcerCallbacks$$ExternalSyntheticLambda8());
    }

    private static /* synthetic */ void lambda$updateScreenCaptureDisabled$12() {
        IWindowManager.Stub.asInterface(ServiceManager.getService("window")).refreshScreenCaptureDisabled();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slogf.w(LOG_TAG, "Unable to notify WindowManager.", e);
    }

    static CompletableFuture<Boolean> setPersonalAppsSuspended(final Boolean suspended, final Context context, final int userId, PolicyKey policyKey) {
        Binder.withCleanCallingIdentity(new PolicyEnforcerCallbacks$$ExternalSyntheticLambda6(suspended, context, userId));
        return AndroidFuture.completedFuture(true);
    }

    private static /* synthetic */ void lambda$setPersonalAppsSuspended$13(Boolean suspended, Context context, int userId) throws Exception {
        if (suspended != null) goto L4;
    L6:
        ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).unsuspendAdminSuspendedPackages(userId);
        return;
    L4:
        if (suspended.booleanValue() == false) goto L6;
        suspendPersonalAppsInPackageManager(context, userId);
    }

    private static void suspendPersonalAppsInPackageManager(Context context, int userId) {
        String[] appsToSuspend = PersonalAppsSuspensionHelper.forUser(context, userId).getPersonalAppsForSuspension();
        Slogf.i(LOG_TAG, "Suspending personal apps: %s", new Object[]{String.join(",", appsToSuspend)});
        String[] failedApps = ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).setPackagesSuspendedByAdmin(userId, appsToSuspend, true);
        if (ArrayUtils.isEmpty(failedApps) == true) goto L6;
        Slogf.wtf(LOG_TAG, "Failed to suspend apps: " + String.join(",", failedApps));
        return;
    }

    static CompletableFuture<Boolean> setUsbDataSignalingEnabled(final Boolean value, final Context context) {
        return (CompletableFuture) Binder.withCleanCallingIdentity(new PolicyEnforcerCallbacks$$ExternalSyntheticLambda12(context, value));
    }

    private static /* synthetic */ AndroidFuture lambda$setUsbDataSignalingEnabled$14(Context context, Boolean value) throws Exception {
        context.getClass();
        if (value != null) goto L5;
    L8:
        boolean enabled = true;
    L9:
        DevicePolicyManagerService.updateUsbDataSignal(context, enabled);
        return AndroidFuture.completedFuture(true);
    L5:
        if (value.booleanValue() == true) goto L8;
        enabled = false;
        goto L9
    }

    static CompletableFuture<Boolean> setMtePolicy(Integer mtePolicy, Context context, int userId, PolicyKey policyKey) {
        if (mtePolicy != null) goto L5;
        mtePolicy = 0;
    L5:
        Set<Integer> allowedModes = Set.of(0, 2, 1);
        if (allowedModes.contains(mtePolicy) == true) goto L9;
        Slog.wtf(LOG_TAG, "MTE policy is not a known one: " + mtePolicy);
        return AndroidFuture.completedFuture(false);
    L9:
        boolean isAvailable = SystemProperties.getBoolean("ro.arm64.memtag.bootctl_device_policy_manager", SystemProperties.getBoolean("ro.arm64.memtag.bootctl_settings_toggle", false));
        if (isAvailable == true) goto L14;
        return AndroidFuture.completedFuture(false);
    L14:
        if (mtePolicy.intValue() != 1) goto L17;
        SystemProperties.set("arm64.memtag.bootctl", "memtag");
    L23:
        return AndroidFuture.completedFuture(true);
    L17:
        if (mtePolicy.intValue() != 2) goto L20;
        SystemProperties.set("arm64.memtag.bootctl", "memtag-off");
        goto L23
    L20:
        if (mtePolicy.intValue() != 0) goto L23;
        SystemProperties.set("arm64.memtag.bootctl", "default");
        goto L23
    }
}
