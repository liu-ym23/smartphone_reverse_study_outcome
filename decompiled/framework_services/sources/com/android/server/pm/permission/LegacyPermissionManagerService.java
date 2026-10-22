package com.android.server.pm.permission;

import android.app.AppOpsManager;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.PermissionChecker;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.os.Binder;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.permission.ILegacyPermissionManager;
import android.util.EventLog;
import android.util.Log;
import com.android.server.LocalServices;
import com.android.server.pm.PackageManagerServiceUtils;
import com.android.server.pm.PackageSetting;
import com.android.server.pm.UserManagerService;
import com.android.server.pm.pkg.AndroidPackage;

/* JADX INFO: loaded from: classes2.dex */
public class LegacyPermissionManagerService extends ILegacyPermissionManager.Stub {
    private static final String TAG = "PermissionManager";
    private final Context mContext;
    private final DefaultPermissionGrantPolicy mDefaultPermissionGrantPolicy;
    private final Injector mInjector;

    public static class Injector {
        private final Context mContext;
        private final PackageManagerInternal mPackageManagerInternal;

        public Injector(Context context) {
            this.mContext = context;
            this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        }

        public int getCallingUid() {
            return Binder.getCallingUid();
        }

        public int getCallingPid() {
            return Binder.getCallingPid();
        }

        public int checkPermission(String permission, int pid, int uid) {
            return this.mContext.checkPermission(permission, pid, uid);
        }

        public long clearCallingIdentity() {
            return Binder.clearCallingIdentity();
        }

        public void restoreCallingIdentity(long token) {
            Binder.restoreCallingIdentity(token);
        }

        public Object getSystemService(String name) {
            return this.mContext.getSystemService(name);
        }

        public ApplicationInfo getApplicationInfo(String packageName, int uid) throws PackageManager.NameNotFoundException {
            return this.mContext.getPackageManager().getApplicationInfoAsUser(packageName, 0, UserHandle.getUserHandleForUid(uid));
        }

        public int getPackageUidForUser(String packageName, int userId) {
            return this.mPackageManagerInternal.getPackageUid(packageName, 0, userId);
        }
    }

    private class Internal implements LegacyPermissionManagerInternal {
        final /* synthetic */ LegacyPermissionManagerService this$0;

        public static /* synthetic */ void $r8$lambda$ulgQS7HHKIrymr0crweorZLwxHo(PermissionManagerServiceInternal r0, int r1, AndroidPackage r2) {
            lambda$resetRuntimePermissions$0(r0, r1, r2);
        }

        /* synthetic */ Internal(LegacyPermissionManagerService r1, LegacyPermissionManagerServiceIA r2) {
            this(r1);
        }

        private Internal(LegacyPermissionManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.pm.permission.LegacyPermissionManagerInternal
        public void resetRuntimePermissions() {
            LegacyPermissionManagerService.m7070$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.REVOKE_RUNTIME_PERMISSIONS", "revokeRuntimePermission");
            int callingUid = Binder.getCallingUid();
            if (callingUid == 1000) goto L6;
            if (callingUid == 0) goto L6;
            LegacyPermissionManagerService.m7070$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "resetRuntimePermissions");
        L6:
            PackageManagerInternal packageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
            final PermissionManagerServiceInternal permissionManagerInternal = (PermissionManagerServiceInternal) LocalServices.getService(PermissionManagerServiceInternal.class);
            int[] r3 = UserManagerService.getInstance().getUserIds();
            int r4 = r3.length;
            int r5 = 0;
        L7:
            if (r5 >= r4) goto L9;
            final int userId = r3[r5];
            packageManagerInternal.forEachPackage(new LegacyPermissionManagerService$Internal$$ExternalSyntheticLambda0(permissionManagerInternal, userId));
            r5 = r5 + 1;
            goto L7
        }

        private static /* synthetic */ void lambda$resetRuntimePermissions$0(PermissionManagerServiceInternal permissionManagerInternal, int userId, AndroidPackage pkg) {
            if (pkg.getUid() == (-1)) goto L6;
            permissionManagerInternal.resetRuntimePermissions(pkg, userId, true);
            return;
        }

        @Override // com.android.server.pm.permission.LegacyPermissionManagerInternal
        public void setDialerAppPackagesProvider(LegacyPermissionManagerInternal.PackagesProvider provider) {
            LegacyPermissionManagerService.m7071$$Nest$fgetmDefaultPermissionGrantPolicy(this.this$0).setDialerAppPackagesProvider(provider);
        }

        @Override // com.android.server.pm.permission.LegacyPermissionManagerInternal
        public void setLocationExtraPackagesProvider(LegacyPermissionManagerInternal.PackagesProvider provider) {
            LegacyPermissionManagerService.m7071$$Nest$fgetmDefaultPermissionGrantPolicy(this.this$0).setLocationExtraPackagesProvider(provider);
        }

        @Override // com.android.server.pm.permission.LegacyPermissionManagerInternal
        public void setLocationPackagesProvider(LegacyPermissionManagerInternal.PackagesProvider provider) {
            LegacyPermissionManagerService.m7071$$Nest$fgetmDefaultPermissionGrantPolicy(this.this$0).setLocationPackagesProvider(provider);
        }

        @Override // com.android.server.pm.permission.LegacyPermissionManagerInternal
        public void setSimCallManagerPackagesProvider(LegacyPermissionManagerInternal.PackagesProvider provider) {
            LegacyPermissionManagerService.m7071$$Nest$fgetmDefaultPermissionGrantPolicy(this.this$0).setSimCallManagerPackagesProvider(provider);
        }

        @Override // com.android.server.pm.permission.LegacyPermissionManagerInternal
        public void setSmsAppPackagesProvider(LegacyPermissionManagerInternal.PackagesProvider provider) {
            LegacyPermissionManagerService.m7071$$Nest$fgetmDefaultPermissionGrantPolicy(this.this$0).setSmsAppPackagesProvider(provider);
        }

        @Override // com.android.server.pm.permission.LegacyPermissionManagerInternal
        public void setSyncAdapterPackagesProvider(LegacyPermissionManagerInternal.SyncAdapterPackagesProvider provider) {
            LegacyPermissionManagerService.m7071$$Nest$fgetmDefaultPermissionGrantPolicy(this.this$0).setSyncAdapterPackagesProvider(provider);
        }

        @Override // com.android.server.pm.permission.LegacyPermissionManagerInternal
        public void setUseOpenWifiAppPackagesProvider(LegacyPermissionManagerInternal.PackagesProvider provider) {
            LegacyPermissionManagerService.m7071$$Nest$fgetmDefaultPermissionGrantPolicy(this.this$0).setUseOpenWifiAppPackagesProvider(provider);
        }

        @Override // com.android.server.pm.permission.LegacyPermissionManagerInternal
        public void setVoiceInteractionPackagesProvider(LegacyPermissionManagerInternal.PackagesProvider provider) {
            LegacyPermissionManagerService.m7071$$Nest$fgetmDefaultPermissionGrantPolicy(this.this$0).setVoiceInteractionPackagesProvider(provider);
        }

        @Override // com.android.server.pm.permission.LegacyPermissionManagerInternal
        public void grantDefaultPermissionsToDefaultSimCallManager(String packageName, int userId) {
            LegacyPermissionManagerService.m7071$$Nest$fgetmDefaultPermissionGrantPolicy(this.this$0).grantDefaultPermissionsToDefaultSimCallManager(packageName, userId);
        }

        @Override // com.android.server.pm.permission.LegacyPermissionManagerInternal
        public void grantDefaultPermissionsToDefaultUseOpenWifiApp(String packageName, int userId) {
            LegacyPermissionManagerService.m7071$$Nest$fgetmDefaultPermissionGrantPolicy(this.this$0).grantDefaultPermissionsToDefaultUseOpenWifiApp(packageName, userId);
        }

        @Override // com.android.server.pm.permission.LegacyPermissionManagerInternal
        public void grantDefaultPermissions(int userId) {
            LegacyPermissionManagerService.m7071$$Nest$fgetmDefaultPermissionGrantPolicy(this.this$0).grantDefaultPermissions(userId);
        }

        @Override // com.android.server.pm.permission.LegacyPermissionManagerInternal
        public void scheduleReadDefaultPermissionExceptions() {
            LegacyPermissionManagerService.m7071$$Nest$fgetmDefaultPermissionGrantPolicy(this.this$0).scheduleReadDefaultPermissionExceptions();
        }

        @Override // com.android.server.pm.permission.LegacyPermissionManagerInternal
        public int checkSoundTriggerRecordAudioPermissionForDataDelivery(int uid, String packageName, String attributionTag, String reason) {
            int result = PermissionChecker.checkPermissionForPreflight(LegacyPermissionManagerService.m7070$$Nest$fgetmContext(this.this$0), "android.permission.RECORD_AUDIO", -1, uid, packageName);
            if (result == 0) goto L5;
            return result;
        L5:
            ((AppOpsManager) LegacyPermissionManagerService.m7070$$Nest$fgetmContext(this.this$0).getSystemService(AppOpsManager.class)).noteOpNoThrow(120, uid, packageName, attributionTag, reason);
            return result;
        }

        @Override // com.android.server.pm.permission.LegacyPermissionManagerInternal
        public void onPackageAdded(PackageSetting pkgSetting) {
            LegacyPermissionManagerService.m7071$$Nest$fgetmDefaultPermissionGrantPolicy(this.this$0).getExt().onPackageAdded(pkgSetting);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$Copv155KKSqRAhwcyL0gjbaD-J4, reason: not valid java name */
    public static /* synthetic */ void m7067$r8$lambda$Copv155KKSqRAhwcyL0gjbaDJ4(LegacyPermissionManagerService r0, String r1, int r2) {
        r0.lambda$grantDefaultPermissionsToActiveLuiApp$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$GIWFoeLExYzdD6nXkWS3dnSYhy0(LegacyPermissionManagerService r0, String[] r1, int r2) {
        r0.lambda$grantDefaultPermissionsToEnabledCarrierApps$6(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$IYpM1sQJXOv1NEN69ZcIlh1GXNw(LegacyPermissionManagerService r0, String[] r1, int r2) {
        r0.lambda$revokeDefaultPermissionsFromLuiApps$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$O6tv_UbMuswOlGybw9yEK7Ox7n0(LegacyPermissionManagerService r0, String r1, int r2) {
        r0.lambda$grantDefaultPermissionsToCarrierServiceApp$0(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$XJRM--KlcwdVcvJ6T-8uozQ32tE, reason: not valid java name */
    public static /* synthetic */ void m7068$r8$lambda$XJRMKlcwdVcvJ6T8uozQ32tE(LegacyPermissionManagerService r0, String[] r1, int r2) {
        r0.lambda$grantDefaultPermissionsToEnabledImsServices$3(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$lv-8Ha9p9dV0QQzCs6vFH7LiTB8, reason: not valid java name */
    public static /* synthetic */ void m7069$r8$lambda$lv8Ha9p9dV0QQzCs6vFH7LiTB8(LegacyPermissionManagerService r0, String[] r1, int r2) {
        r0.lambda$revokeDefaultPermissionsFromDisabledTelephonyDataServices$5(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$u77Y4zP2_UA0sARUr92T0pFuRWw(LegacyPermissionManagerService r0, String[] r1, int r2) {
        r0.lambda$grantDefaultPermissionsToEnabledTelephonyDataServices$4(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7070$$Nest$fgetmContext(LegacyPermissionManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDefaultPermissionGrantPolicy, reason: not valid java name */
    static /* bridge */ /* synthetic */ DefaultPermissionGrantPolicy m7071$$Nest$fgetmDefaultPermissionGrantPolicy(LegacyPermissionManagerService r0) {
        return r0.mDefaultPermissionGrantPolicy;
    }

    public static LegacyPermissionManagerInternal create(Context context) {
        LegacyPermissionManagerInternal legacyPermissionManagerInternal = (LegacyPermissionManagerInternal) LocalServices.getService(LegacyPermissionManagerInternal.class);
        if (legacyPermissionManagerInternal != null) goto L6;
        new LegacyPermissionManagerService(context);
        return (LegacyPermissionManagerInternal) LocalServices.getService(LegacyPermissionManagerInternal.class);
    L6:
        return legacyPermissionManagerInternal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LegacyPermissionManagerService(Context context) {
        this(context, new Injector(context));
        LocalServices.addService(LegacyPermissionManagerInternal.class, new Internal(this, null));
        ServiceManager.addService("legacy_permission", this);
    }

    LegacyPermissionManagerService(Context context, Injector injector) {
        this.mContext = context;
        this.mInjector = injector;
        this.mDefaultPermissionGrantPolicy = new DefaultPermissionGrantPolicy(context);
    }

    public int checkDeviceIdentifierAccess(String packageName, String message, String callingFeatureId, int pid, int uid) {
        verifyCallerCanCheckAccess(packageName, message, pid, uid);
        int appId = UserHandle.getAppId(uid);
        if (appId == 1000) goto L25;
        if (appId == 0) goto L25;
        if (this.mInjector.checkPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", pid, uid) != 0) goto L9;
        return 0;
    L9:
        if (packageName == null) goto L23;
        long token = this.mInjector.clearCallingIdentity();
        AppOpsManager appOpsManager = (AppOpsManager) this.mInjector.getSystemService("appops");
        if (appOpsManager.noteOpNoThrow("android:read_device_identifiers", uid, packageName, callingFeatureId, message) != 0) goto L15;
        this.mInjector.restoreCallingIdentity(token);
        return 0;
    L15:
        this.mInjector.restoreCallingIdentity(token);
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) this.mInjector.getSystemService("device_policy");
        if (devicePolicyManager != null) goto L18;
        return -1;
    L18:
        if (devicePolicyManager.hasDeviceIdentifierAccess(packageName, pid, uid) == false) goto L29;
        return 0;
    L29:
        return -1;
    L20:
        th = move-exception;
        this.mInjector.restoreCallingIdentity(token);
        throw th;
    L23:
        return -1;
    L25:
        return 0;
    }

    public int checkPhoneNumberAccess(String packageName, String message, String callingFeatureId, int pid, int uid) {
        verifyCallerCanCheckAccess(packageName, message, pid, uid);
        if (this.mInjector.checkPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", pid, uid) != 0) goto L5;
        return 0;
    L5:
        if (packageName != null) goto L8;
        return -1;
    L8:
        int result = -1;
        ApplicationInfo info = this.mInjector.getApplicationInfo(packageName, uid);     // Catch: PackageManager.NameNotFoundException -> L15
        if (info.targetSdkVersion > 29) goto L13;
        boolean r2 = true;
    L14:
        boolean preR = r2;
        boolean preR2 = preR;
    L17:
        if (preR2 == false) goto L22;
        result = checkPermissionAndAppop(packageName, "android.permission.READ_PHONE_STATE", "android:read_phone_state", callingFeatureId, message, pid, uid);
        if (result != 0) goto L22;
        return result;
    L22:
        if (checkPermissionAndAppop(packageName, null, "android:write_sms", callingFeatureId, message, pid, uid) != 0) goto L25;
        return 0;
    L25:
        if (checkPermissionAndAppop(packageName, "android.permission.READ_PHONE_NUMBERS", "android:read_phone_numbers", callingFeatureId, message, pid, uid) != 0) goto L28;
        return 0;
    L28:
        if (checkPermissionAndAppop(packageName, "android.permission.READ_SMS", "android:read_sms", callingFeatureId, message, pid, uid) != 0) goto L30;
        return 0;
    L30:
        return result;
    L13:
        r2 = false;
    L16:
        preR2 = false;
        goto L17
    }

    private void verifyCallerCanCheckAccess(String packageName, String message, int pid, int uid) {
        boolean reportError = false;
        int callingUid = this.mInjector.getCallingUid();
        int callingPid = this.mInjector.getCallingPid();
        if (UserHandle.getAppId(callingUid) < 10000) goto L7;
        if (callingUid != uid) goto L6;
        if (callingPid == pid) goto L7;
    L6:
        reportError = true;
    L7:
        if (packageName != null) goto L9;
    L17:
        if (reportError == true) goto L19;
        return;
    L19:
        String response = String.format("Calling uid %d, pid %d cannot access for package %s (uid=%d, pid=%d): %s", new Object[]{Integer.valueOf(callingUid), Integer.valueOf(callingPid), packageName, Integer.valueOf(uid), Integer.valueOf(pid), message});
        Log.w(TAG, response);
        throw new SecurityException(response);
    L9:
        if (UserHandle.getAppId(uid) < 10000) goto L17;
        int packageUid = this.mInjector.getPackageUidForUser(packageName, UserHandle.getUserId(uid));
        if (uid == packageUid) goto L17;
        if (UserHandle.getAppId(callingUid) < 10000) goto L15;
        int r4 = callingUid;
    L16:
        EventLog.writeEvent(1397638484, new Object[]{"193441322", Integer.valueOf(r4), "Package uid mismatch"});
        reportError = true;
        goto L17
    L15:
        r4 = uid;
        goto L16
    }

    private int checkPermissionAndAppop(String packageName, String permission, String appop, String callingFeatureId, String message, int pid, int uid) {
        if (permission != null) goto L4;
    L7:
        AppOpsManager appOpsManager = (AppOpsManager) this.mInjector.getSystemService("appops");
        if (appOpsManager.noteOpNoThrow(appop, uid, packageName, callingFeatureId, message) == 0) goto L11;
        return 1;
    L11:
        return 0;
    L4:
        if (this.mInjector.checkPermission(permission, pid, uid) == 0) goto L7;
        return -1;
    }

    public void grantDefaultPermissionsToCarrierServiceApp(final String packageName, final int userId) {
        PackageManagerServiceUtils.enforceSystemOrRoot("grantDefaultPermissionsForCarrierServiceApp");
        Binder.withCleanCallingIdentity(new LegacyPermissionManagerService$$ExternalSyntheticLambda5(this, packageName, userId));
    }

    private /* synthetic */ void lambda$grantDefaultPermissionsToCarrierServiceApp$0(String packageName, int userId) throws Exception {
        this.mDefaultPermissionGrantPolicy.grantDefaultPermissionsToCarrierServiceApp(packageName, userId);
    }

    public void grantDefaultPermissionsToActiveLuiApp(final String packageName, final int userId) {
        int callingUid = Binder.getCallingUid();
        PackageManagerServiceUtils.enforceSystemOrPhoneCaller("grantDefaultPermissionsToActiveLuiApp", callingUid);
        Binder.withCleanCallingIdentity(new LegacyPermissionManagerService$$ExternalSyntheticLambda4(this, packageName, userId));
    }

    private /* synthetic */ void lambda$grantDefaultPermissionsToActiveLuiApp$1(String packageName, int userId) throws Exception {
        this.mDefaultPermissionGrantPolicy.grantDefaultPermissionsToActiveLuiApp(packageName, userId);
    }

    public void revokeDefaultPermissionsFromLuiApps(final String[] packageNames, final int userId) {
        int callingUid = Binder.getCallingUid();
        PackageManagerServiceUtils.enforceSystemOrPhoneCaller("revokeDefaultPermissionsFromLuiApps", callingUid);
        Binder.withCleanCallingIdentity(new LegacyPermissionManagerService$$ExternalSyntheticLambda2(this, packageNames, userId));
    }

    private /* synthetic */ void lambda$revokeDefaultPermissionsFromLuiApps$2(String[] packageNames, int userId) throws Exception {
        this.mDefaultPermissionGrantPolicy.revokeDefaultPermissionsFromLuiApps(packageNames, userId);
    }

    public void grantDefaultPermissionsToEnabledImsServices(final String[] packageNames, final int userId) {
        int callingUid = Binder.getCallingUid();
        PackageManagerServiceUtils.enforceSystemOrPhoneCaller("grantDefaultPermissionsToEnabledImsServices", callingUid);
        Binder.withCleanCallingIdentity(new LegacyPermissionManagerService$$ExternalSyntheticLambda0(this, packageNames, userId));
    }

    private /* synthetic */ void lambda$grantDefaultPermissionsToEnabledImsServices$3(String[] packageNames, int userId) throws Exception {
        this.mDefaultPermissionGrantPolicy.grantDefaultPermissionsToEnabledImsServices(packageNames, userId);
    }

    public void grantDefaultPermissionsToEnabledTelephonyDataServices(final String[] packageNames, final int userId) {
        int callingUid = Binder.getCallingUid();
        PackageManagerServiceUtils.enforceSystemOrPhoneCaller("grantDefaultPermissionsToEnabledTelephonyDataServices", callingUid);
        Binder.withCleanCallingIdentity(new LegacyPermissionManagerService$$ExternalSyntheticLambda3(this, packageNames, userId));
    }

    private /* synthetic */ void lambda$grantDefaultPermissionsToEnabledTelephonyDataServices$4(String[] packageNames, int userId) throws Exception {
        this.mDefaultPermissionGrantPolicy.grantDefaultPermissionsToEnabledTelephonyDataServices(packageNames, userId);
    }

    public void revokeDefaultPermissionsFromDisabledTelephonyDataServices(final String[] packageNames, final int userId) {
        int callingUid = Binder.getCallingUid();
        PackageManagerServiceUtils.enforceSystemOrPhoneCaller("revokeDefaultPermissionsFromDisabledTelephonyDataServices", callingUid);
        Binder.withCleanCallingIdentity(new LegacyPermissionManagerService$$ExternalSyntheticLambda6(this, packageNames, userId));
    }

    private /* synthetic */ void lambda$revokeDefaultPermissionsFromDisabledTelephonyDataServices$5(String[] packageNames, int userId) throws Exception {
        this.mDefaultPermissionGrantPolicy.revokeDefaultPermissionsFromDisabledTelephonyDataServices(packageNames, userId);
    }

    public void grantDefaultPermissionsToEnabledCarrierApps(final String[] packageNames, final int userId) {
        int callingUid = Binder.getCallingUid();
        PackageManagerServiceUtils.enforceSystemOrPhoneCaller("grantPermissionsToEnabledCarrierApps", callingUid);
        Binder.withCleanCallingIdentity(new LegacyPermissionManagerService$$ExternalSyntheticLambda1(this, packageNames, userId));
    }

    private /* synthetic */ void lambda$grantDefaultPermissionsToEnabledCarrierApps$6(String[] packageNames, int userId) throws Exception {
        this.mDefaultPermissionGrantPolicy.grantDefaultPermissionsToEnabledCarrierApps(packageNames, userId);
    }
}
