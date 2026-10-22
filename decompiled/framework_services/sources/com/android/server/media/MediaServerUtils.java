package com.android.server.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.UserHandle;
import android.text.TextUtils;
import com.android.server.LocalServices;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class MediaServerUtils {
    MediaServerUtils() {
    }

    public static boolean isValidActivityComponentName(Context context, ComponentName componentName, String action, UserHandle userHandle) {
        Intent intent = new Intent(action);
        intent.setComponent(componentName);
        List<ResolveInfo> resolveInfos = context.getPackageManager().queryIntentActivitiesAsUser(intent, 0, userHandle);
        return !resolveInfos.isEmpty();
    }

    public static void enforcePackageName(Context context, String packageName, int uid) {
        if (uid != 0) goto L4;
        return;
    L4:
        if (uid != 2000) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(packageName) == true) goto L14;
        PackageManagerInternal packageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        if (packageManagerInternal.isSameApp(packageName, uid, UserHandle.getUserId(uid)) == false) goto L11;
        return;
    L11:
        String[] uidPackages = context.getPackageManager().getPackagesForUid(uid);
        throw new IllegalArgumentException("packageName does not belong to the calling uid; pkg=" + packageName + ", uid=" + uid + " (" + Arrays.toString(uidPackages) + ")");
    L14:
        throw new IllegalArgumentException("packageName may not be empty");
    }

    public static boolean checkDumpPermission(Context context, String tag, PrintWriter pw) {
        if (context.checkCallingOrSelfPermission("android.permission.DUMP") == 0) goto L6;
        pw.println("Permission Denial: can't dump " + tag + " from from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " due to missing android.permission.DUMP permission");
        return false;
    L6:
        return true;
    }
}
