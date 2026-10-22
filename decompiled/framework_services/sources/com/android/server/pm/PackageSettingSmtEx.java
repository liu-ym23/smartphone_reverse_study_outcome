package com.android.server.pm;

import android.os.Binder;
import android.os.Debug;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
public class PackageSettingSmtEx {
    private PackageSetting mPackageSetting;

    public PackageSettingSmtEx(PackageSetting packageSettingBase) {
        this.mPackageSetting = packageSettingBase;
    }

    boolean getNotActive(int userId) {
        return this.mPackageSetting.readUserState(userId).getSmtEx().notActive;
    }

    void setNotActive(boolean notActive, int userId) {
        this.mPackageSetting.modifyUserState(userId).getSmtEx().notActive = notActive;
    }

    int getUserOrientation(int userId, String userOrientationActivity) {
        if (userOrientationActivity == null) goto L9;
        if (userOrientationActivity.equals(this.mPackageSetting.readUserState(userId).getSmtEx().userOrientationActivity) == true) goto L9;
        return -1;
    L9:
        return this.mPackageSetting.readUserState(userId).getSmtEx().userOrientation;
    }

    void setUserOrientation(int userOrientation, String userOrientationActivity, int userId) {
        this.mPackageSetting.modifyUserState(userId).getSmtEx().userOrientation = userOrientation;
        this.mPackageSetting.modifyUserState(userId).getSmtEx().userOrientationActivity = userOrientationActivity;
    }

    String getUserOrientationActivity(int userId) {
        return this.mPackageSetting.readUserState(userId).getSmtEx().userOrientationActivity;
    }

    void setInstalled(boolean inst, int userId) {
        if (inst == true) goto L4;
        return;
    L4:
        if (userId == 10) goto L6;
        return;
    L6:
        if (this.mPackageSetting.isSystem() == false) goto L11;
        Slog.d("PackageSetting", "doppelganger install system uid: " + Binder.getCallingUid() + " pid: " + Binder.getCallingPid() + " app: " + this.mPackageSetting.getName() + " callers: " + Debug.getCallers(6));
        return;
    }
}
