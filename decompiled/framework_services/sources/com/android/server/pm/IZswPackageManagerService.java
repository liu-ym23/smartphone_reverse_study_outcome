package com.android.server.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.IPackageDeleteObserver2;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManagerInternal;
import android.content.pm.VersionedPackage;
import android.mifavor.MFVUtils;
import android.os.Handler;
import android.os.UserHandle;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.server.LocalServices;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageUserStateInternal;
import com.android.server.pm.pkg.PackageUserStateUtils;
import com.android.server.wm.ActivityStarterHook;
import com.zte.feature.Feature;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswPackageManagerService {
    public static final String TAG = "IZswPackageManagerService";

    public interface IZswIPackageManagerImplInner {
        void setApplicationEnabledSetting(String r1, int r2, int r3, int r4, String r5);
    }

    IZswIPackageManagerImplInner createZswIPackageManagerImplInner();

    void deletePackageVersioned(DeletePackageHelper r1, VersionedPackage r2, IPackageDeleteObserver2 r3, int r4, int r5, int r6);

    void disableCompassApp(Context r1);

    void grantDefaultAppOpsZte(int r1);

    void init(Context r1, PackageManagerService r2, InstallPackageHelper r3, AppDataHelper r4, SharedLibrariesImpl r5, BroadcastHelper r6, UserManagerService r7);

    void initKidszoneDatabaseObserve(Context r1, Handler r2);

    boolean isRemovableSysApp(String r1);

    void onAfterScan();

    void onBeforeScan();

    void registerGmsStateBroadcastZte(Context r1);

    void setSetupWizardFlag(Context r1);

    boolean skipVerificationByZTE();

    void systemReady();

    static boolean enforceCrossUserPermission_DoubleApp(int callingUid, int userId) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L11;
        int uid = UserHandle.getUserId(callingUid);
        if (userId != 0) goto L7;
        if (uid != 999) goto L7;
    L9:
        return true;
    L7:
        if (userId != 999) goto L12;
        if (uid == 0) goto L9;
        return false;
    L12:
        return false;
    L11:
        return false;
    }

    static void scanPackageDirtyLI_DoubleApp(PackageSetting pkgSetting, String pkgName, boolean isSystemApp) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return;
    L5:
        if (UserManagerService.getInstance() != null) goto L7;
        return;
    L7:
        if (ArrayUtils.contains(UserManagerService.getInstance().getUserIds(), 999) == true) goto L9;
        return;
    L9:
        if ("org.codeaurora.ims".equals(pkgName) == false) goto L11;
    L16:
        Slog.d(TAG, "MFV_DOUBLE_APP: scanPackageDirtyLI pkgName=" + pkgName + " Installed=" + pkgSetting.getInstalled(999));
        isSystemApp = false;
    L18:
        if (RemovableSystemAppHelper.isRemovableSysApp(pkgName) == false) goto L20;
        isSystemApp = false;
    L20:
        Slog.d(TAG, "MFV_DOUBLE_APP: scanPackageDirtyLI pkgName=" + pkgName + " isSystemApp=" + isSystemApp);
        pkgSetting.setInstalled(isSystemApp, 999);
        return;
    L11:
        if ("com.zte.smartcast".equals(pkgName) == true) goto L16;
        if ("com.android.camera".equals(pkgName) == true) goto L16;
        if ("com.zte.beidou.sms".equals(pkgName) == false) goto L18;
        goto L16
    }

    static void deletePackageVersioned_DoubleApp(PackageManagerService pms, DeletePackageHelper helper, String packageName, long versionCode, int userId, int deleteFlags) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return;
    L5:
        if (UserManagerService.getInstance() == null) goto L18;
        if (userId == 0) goto L8;
        return;
    L8:
        if (UserManagerService.getInstance().getUserInfo(999) == null) goto L20;
        Computer snapshot = pms.snapshotComputer();
        if (snapshot == null) goto L12;
        PackageInfo ps = snapshot.getPackageInfo(packageName, 0, 999);
        PackageInfo ps2 = ps;
    L13:
        Slog.d(TAG, "MFV_DOUBLE_APP: deletePackageVersioned ps = " + ps2 + " packageName = " + packageName);
        if (ps2 == null) goto L21;
        helper.deletePackageX(packageName, versionCode, 999, deleteFlags, false);
        return;
    L21:
        return;
    L12:
        ps2 = null;
        goto L13
    L20:
        return;
    }

    static int getPackageInfoInternalBody_DoubleApp(PackageStateInternal ps, long flags, int defaultValue) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
    L14:
        return defaultValue;
    L5:
        if (UserHandle.getCallingUserId() != 999) goto L14;
        if (defaultValue != 999) goto L14;
        if (ps == null) goto L14;
        PackageUserStateInternal state = ps.getUserStateOrDefault(defaultValue);
        if (state == null) goto L14;
        if (PackageUserStateUtils.isAvailable(state, flags) == true) goto L14;
        return 0;
    }

    static boolean setEnabledSettings_DoubleApp(int userId, int callingUid, boolean allowedByPermission) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return allowedByPermission;
    L5:
        if (userId != 999) goto L13;
        String callingPackageName = ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getNameForUid(callingUid);
        if (callingPackageName != null) goto L9;
        return allowedByPermission;
    L9:
        if (callingPackageName.contains(ActivityStarterHook.mDoubleAppPackageName) == false) goto L15;
        Slog.d(TAG, "setEnabledSettings(allow doubleapp!) allowedByPermission:" + allowedByPermission + ",userId:" + userId + ",callingPackageName:" + callingPackageName);
        return true;
    L15:
        return allowedByPermission;
    L13:
        return allowedByPermission;
    }

    private static boolean isCtsTesting() {
        boolean isCts = Feature.getCtsRunningStatus();
        Slog.d(TAG, "isCtsTesting isCts:" + isCts);
        return isCts;
    }

    static String commitPackageSettings_Chooser(String defaultValue) {
        return defaultValue;
    }

    static boolean getActivityInfo_ResolverActivityUI(ComponentName component) {
        if (MFVUtils.MFV_FEATURE_CHOOSER == true) goto L5;
        return false;
    L5:
        if (isCtsTesting() == true) goto L10;
        ComponentName aospResolveComponentName = new ComponentName(PackageManagerService.PLATFORM_PACKAGE_NAME, "com.android.internal.app.ResolverActivity");
        return aospResolveComponentName.equals(component);
    L10:
        return false;
    }
}
