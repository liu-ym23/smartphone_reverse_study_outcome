package com.android.server.pm.permission;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ApplicationInfoEx;
import android.content.pm.PackageManager;
import android.util.Log;
import android.util.Slog;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ObricPermissionCheckHelper {
    private static final String TAG = "PermissionCheckHelper";

    public ObricPermissionCheckHelper() {
    }

    public static boolean isSystemSignatureApp(Context context, int callingUid) {
        PackageManager pm = context.getPackageManager();
        if (pm.checkSignatures(1000, callingUid) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isSystemApp(Context context, int callingUid) {
        if (callingUid != 1000) goto L5;
        return true;
    L5:
        PackageManager pm = context.getPackageManager();
        ApplicationInfo info = null;
        String packageName = (String) getPackageNamesForUid(context, callingUid).getFirst();     // Catch: PackageManager.NameNotFoundException -> L8
        info = pm.getApplicationInfo(packageName, 128);     // Catch: PackageManager.NameNotFoundException -> L8
    L11:
        if (info != null) goto L13;
    L19:
        return false;
    L13:
        if (info.isSystemApp() == false) goto L15;
        return true;
    L15:
        if (info.isUpdatedSystemApp() == false) goto L17;
        return true;
    L17:
        if (ApplicationInfoEx.isObricApp(info) == false) goto L19;
        return true;
    L9:
        Slog.d(TAG, "Failed to get application info for UID " + callingUid);
        goto L11
    }

    public static List<String> getPackageNamesForUid(Context context, int callingUid) throws PackageManager.NameNotFoundException {
        String[] possibleAppPackages = context.getPackageManager().getPackagesForUid(callingUid);
        if (possibleAppPackages == null) goto L12;
        if (possibleAppPackages.length == 0) goto L12;
        if (possibleAppPackages.length <= 1) goto L10;
        Log.d(TAG, "More than one package name available for UID " + callingUid + ". Count: " + possibleAppPackages.length);
    L10:
        return List.of(possibleAppPackages);
    L12:
        throw new PackageManager.NameNotFoundException("Could not find package for " + callingUid);
    }
}
