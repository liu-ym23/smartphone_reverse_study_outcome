package com.android.server.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class AppInstallerUtil {
    private static final String LOG_TAG = "AppInstallerUtil";

    public AppInstallerUtil() {
    }

    private static Intent resolveIntent(Context context, Intent i) {
        ResolveInfo result = context.getPackageManager().resolveActivity(i, 0);
        if (result != null) goto L7;
        return null;
    L7:
        return new Intent(i.getAction()).setClassName(result.activityInfo.packageName, result.activityInfo.name);
    }

    public static String getInstallerPackageName(Context context, String packageName) {
        String installerPackageName = null;
        installerPackageName = context.getPackageManager().getInstallerPackageName(packageName);     // Catch: IllegalArgumentException -> L5
    L7:
        if (installerPackageName != null) goto L10;
        return null;
    L10:
        return installerPackageName;
    L5:
        e = move-exception;
        Log.e(LOG_TAG, "Exception while retrieving the package installer of " + packageName, e);
        goto L7
    }

    public static Intent createIntent(Context context, String installerPackageName, String packageName) {
        Intent intent = new Intent("android.intent.action.SHOW_APP_INFO").setPackage(installerPackageName);
        Intent result = resolveIntent(context, intent);
        if (result == null) goto L6;
        result.putExtra("android.intent.extra.PACKAGE_NAME", packageName);
        result.addFlags(268435456);
        return result;
    L6:
        return null;
    }

    public static Intent createIntent(Context context, String packageName) {
        String installerPackageName = getInstallerPackageName(context, packageName);
        return createIntent(context, installerPackageName, packageName);
    }
}
