package com.android.server.appop;

import android.mifavor.MFVUtils;
import android.os.UserHandle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public interface IZswAppOpsService {
    public static final String TAG = "IZswAppOpsService";

    static boolean checkPackage_Allowed_DoubleApp(int uid, String packageName) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L8;
        int userId = UserHandle.getUserId(uid);
        if (userId != 999) goto L10;
        Log.d(TAG, "checkPackage allow 999  packageName:" + packageName + ",Uid:" + uid);
        return true;
    L10:
        return false;
    L8:
        return false;
    }
}
