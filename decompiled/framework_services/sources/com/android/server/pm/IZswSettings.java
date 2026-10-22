package com.android.server.pm;

import android.content.pm.UserInfo;
import android.mifavor.MFVUtils;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswSettings {
    public static final String TAG = "IZswSettings";

    static boolean updatePackageSetting_DoubleLay(UserInfo userInfo, PackageSetting pkgSetting, boolean origin) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
    L8:
        return origin;
    L5:
        if (userInfo.id != 999) goto L8;
        Slog.d(TAG, "DOUBLE_LAY: updatePackageSetting " + pkgSetting.getPackageName());
        return pkgSetting.getInstalled(userInfo.id);
    }
}
