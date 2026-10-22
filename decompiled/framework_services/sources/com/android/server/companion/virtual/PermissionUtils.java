package com.android.server.companion.virtual;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.UserHandle;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
class PermissionUtils {
    private static final String LOG_TAG = "VDM.PermissionUtils";

    PermissionUtils() {
    }

    public static boolean validateCallingPackageName(Context context, String callingPackage) {
        int callingUid = Binder.getCallingUid();
        long token = Binder.clearCallingIdentity();
        int packageUid = context.getPackageManager().getPackageUidAsUser(callingPackage, UserHandle.getUserId(callingUid));     // Catch: Throwable -> L8 PackageManager.NameNotFoundException -> L10
        if (packageUid == callingUid) goto L12;
        Slog.e(LOG_TAG, "validatePackageName: App with package name " + callingPackage + " is UID " + packageUid + " but caller is " + callingUid);     // Catch: Throwable -> L8 PackageManager.NameNotFoundException -> L10
        Binder.restoreCallingIdentity(token);
        return false;
        goto L15
    L12:
        Binder.restoreCallingIdentity(token);
        return true;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L15:
        Slog.e(LOG_TAG, "validatePackageName: App with package name " + callingPackage + " does not exist");     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(token);
        return false;
    }
}
