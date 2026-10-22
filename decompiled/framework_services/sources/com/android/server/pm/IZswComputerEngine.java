package com.android.server.pm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.mifavor.MFVUtils;
import android.os.UserHandle;
import android.util.Slog;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswComputerEngine {
    public static final String TAG = "IZswComputerEngine";

    boolean checkPackageNameIsOverlay_multheme(String r1);

    void filterQueryResultForKidsZoneMode(Intent r1, List<ResolveInfo> r2, Context r3);

    static boolean enforceCrossUserOrProfilePermission_DoubleApp(ComputerEngine ce, int callingUid, int userId) {
        int callingUserId = UserHandle.getUserId(callingUid);
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return false;
    L5:
        if (callingUserId != 999) goto L7;
        if (userId != 0) goto L7;
    L9:
        Slog.d(TAG, "debug_double enforceCrossUserOrProfilePermission allow cross access callerPackage:" + ce.getPackage(callingUid).getPackageName() + ",userId:" + userId + ",callingUserId:" + callingUserId);
        return true;
    L7:
        if (callingUserId != 0) goto L13;
        if (userId == 999) goto L9;
        return false;
    L13:
        return false;
    }
}
