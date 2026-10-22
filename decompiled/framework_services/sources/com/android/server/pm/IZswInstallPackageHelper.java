package com.android.server.pm;

import android.content.Context;
import android.content.pm.PackageManagerInternal;
import android.mifavor.MFVUtils;
import android.os.Handler;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.wm.ActivityStarterHook;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswInstallPackageHelper {
    public static final String TAG = "IZswInstallPackageHelper";

    static /* synthetic */ void $r8$lambda$8w49ELdPtz2KEAjJ6QKmomo4UUQ(InstallPackageHelper r0, String r1, Computer r2) {
        lambda$handlePackagePostInstall_DoubleLay$0(r0, r1, r2);
    }

    boolean forbidThirdAppBySetupWizard(PackageManagerService r1, Context r2, InstallRequest r3, String r4);

    void installPackagesTracedBegin();

    void installPackagesTracedEnd();

    static boolean allowDoubleAppInstalled999(int callingUid, int userId, String packageName) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return false;
    L5:
        if (userId != 999) goto L22;
        String callingPackageName = ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getNameForUid(callingUid);     // Catch: Exception -> L13
        if (callingPackageName != null) goto L9;
        return false;
    L9:
        if (callingPackageName.contains(ActivityStarterHook.mDoubleAppPackageName) == false) goto L24;
        Slog.d(TAG, "installExistingPackageAsUser(ingnore doubleapp !!!) packageName:" + packageName + ",userId:" + userId + ",callingUid:" + callingUid + ",callingPackageName:" + callingPackageName);     // Catch: Exception -> L13
        return true;
    L24:
        return false;
    L13:
        e = move-exception;
        Slog.e(TAG, "installExistingPackageAsUser e:" + e + ",userId:" + userId + ",packageName:" + packageName);
        return false;
    L22:
        return false;
    }

    static boolean ingnoreInstall999(int currentUserId) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return false;
    L5:
        if (currentUserId != 999) goto L10;
        return true;
    L10:
        return false;
    }

    static void installWeType999IfNecessary(InstallPackageHelper helper, String packageName, Computer snapshot) {
        if ("com.tencent.wetype".equals(packageName) == false) goto L22;
        if (snapshot.getPackageInfo("com.tencent.mm", 0, 999) == null) goto L8;
        boolean isWechat999installed = true;
    L9:
        boolean isWechat999installed2 = isWechat999installed;
    L12:
        if (isWechat999installed2 == false) goto L17;
        String packageName2 = packageName;
        helper.installExistingPackageAsUser(packageName2, 999, 4194304, 0, null, null);     // Catch: Exception -> L15
    L18:
        Slog.d(TAG, "debug_install installWeType999IfNecessary try install 999 wetype if 999 wechat exits, pkg = " + packageName2 + ",isWechat999installed:" + isWechat999installed2);     // Catch: Exception -> L15
        return;
    L20:
        Slog.d(TAG, "debug_install installExistingPackageAsUser fail packageName:" + packageName2);
        return;
    L17:
        packageName2 = packageName;
        goto L18
    L8:
        isWechat999installed = false;
    L10:
        e = move-exception;
        isWechat999installed2 = false;
        Slog.d(TAG, "e:" + e);
        goto L12
    }

    static void handlePackagePostInstall_DoubleLay(boolean succeeded, Handler handler, final InstallPackageHelper helper, final String packageName, final Computer snapshot) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L7;
        if (succeeded == false) goto L8;
        handler.post(new IZswInstallPackageHelper$$ExternalSyntheticLambda0(helper, packageName, snapshot));
        return;
    L8:
        return;
    }

    private static /* synthetic */ void lambda$handlePackagePostInstall_DoubleLay$0(InstallPackageHelper helper, String packageName, Computer snapshot) {
        installWeType999IfNecessary(helper, packageName, snapshot);
    }
}
