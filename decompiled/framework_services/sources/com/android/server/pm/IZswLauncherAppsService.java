package com.android.server.pm;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.mifavor.MFVUtils;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswLauncherAppsService {
    public static final String TAG = "IZswLauncherAppsService";

    static boolean hideApps_DoubleApp(Context context, int callingUid, int userId, String packageName, ResolveInfo ri) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L25;
        String callingPackage = context.getPackageManager().getNameForUid(callingUid);
        if ("com.zte.mifavor.launcher".equals(callingPackage) == false) goto L11;
        if (userId != 9999) goto L11;
        Slog.d(TAG, "Delete package " + packageName + " for 9999 user in launcher");
        return true;
    L11:
        if ("com.zte.mifavor.launcher".equals(callingPackage) == true) goto L13;
        return false;
    L13:
        if (userId == 999) goto L15;
        return false;
    L15:
        if (packageName.equals("cn.zte.bbs") == false) goto L17;
    L24:
        CharSequence appLabel = ri.loadLabel(context.getPackageManager());
        Slog.d(TAG, "debug_999_overlay appLabel :" + appLabel + ",packageName:" + packageName);
        return false;
    L17:
        if (packageName.equals("cn.zte.zmall") == true) goto L24;
        if (packageName.equals("com.tencent.wetype") == false) goto L29;
        Slog.d(TAG, "debug_install do not display 999 wetype in launcher");
        return true;
    L29:
        return false;
    L25:
        return false;
    }
}
