package com.android.server.pm;

import android.content.pm.PackageManagerInternal;
import android.content.pm.UserInfo;
import android.mifavor.MFVUtils;
import android.util.Slog;
import android.util.SparseBooleanArray;
import com.android.server.wm.ActivityStarterHook;

/* JADX INFO: loaded from: classes2.dex */
public class ZswUserManagerServiceHook {
    private static final String LOG_TAG = "ZswUserManagerServiceHook";
    private static boolean mDoubleLayCreating;
    private static boolean mDoubleLayEnabled;
    private static final Object mLock = null;

    public ZswUserManagerServiceHook() {
    }

    static {
        mDoubleLayEnabled = false;
        mDoubleLayCreating = false;
        mLock = new Object();
    }

    static void systemReady_DoubleApp(UserManagerService ums) {
        Object r0 = mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L11;
        UserInfo doubleLayUser = ums.getUserInfo(999);     // Catch: Throwable -> L9
        if (doubleLayUser == null) goto L11;
        mDoubleLayEnabled = true;     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public static int canAddMoreManagedProfiles_DoubleApp() {
        Object r0 = mLock;
        monitor-enter(r0);
        int r2 = 0;
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L7;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return 0;
    L7:
        if (mDoubleLayEnabled == false) goto L9;
        r2 = 1;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L11:
        th = move-exception;
        throw th;
    }

    static void createUserInternalUnchecked_DoubleApp_01(String name) {
        Object r0 = mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L7;
        mDoubleLayCreating = false;     // Catch: Throwable -> L12
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L7:
        if ("double_lay_zte".equals(name) == true) goto L14;
        if ("double_lay_zte_clone".equals(name) == true) goto L14;
        mDoubleLayCreating = false;     // Catch: Throwable -> L12
    L14:
        mDoubleLayEnabled = true;     // Catch: Throwable -> L12
        mDoubleLayCreating = true;     // Catch: Throwable -> L12
        goto L16
    }

    static int createUserInternalUnchecked_DoubleApp_02(String name, int userId) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return userId;
    L5:
        if ("double_lay_zte".equals(name) == false) goto L7;
    L8:
        Slog.d(LOG_TAG, "createUserInternalUnchecked: double_lay_zte");
        return 999;
    L7:
        if ("double_lay_zte_clone".equals(name) == true) goto L8;
        return userId;
    }

    static void createUserInternalUnchecked_end_DoubleApp(String name) {
        mDoubleLayCreating = false;
    }

    public static boolean isCreatingDoubleLay() {
        return mDoubleLayCreating;
    }

    static int createProfileForUserWithThrow_DoubleApp(String name, int flag) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return flag;
    L5:
        if ("double_lay_zte".equals(name) == false) goto L7;
        Slog.d(LOG_TAG, "createProfileForUserWithThrow_DoubleApp");
        return flag | 96;
    L7:
        Slog.d(LOG_TAG, "createProfileForUserWithThrow_DoubleApp name:" + name + ",flag:" + flag);
        return flag;
    }

    static boolean notAllowQuietModeForDoubleLay(int userId, String callingPackage, boolean enableQuietMode) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return false;
    L5:
        if (userId != 999) goto L10;
        Slog.d(LOG_TAG, "requestQuietModeEnabled do not enable quietmode for user 999 !!!,enableQuietMode:" + enableQuietMode + ",callingPackage:" + callingPackage);
        return true;
    L10:
        return false;
    }

    static boolean isDoubleLay(int userId) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return false;
    L5:
        if (userId != 999) goto L10;
        Slog.d(LOG_TAG, "isDoubleLay 999");
        return true;
    L10:
        return false;
    }

    static boolean allowSetCrossProfileIntentFilter_DoubleApp(PackageManagerInternal pm, int callingUid) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return false;
    L5:
        if (pm == null) goto L22;
        String callingPackage = pm.getNameForUid(callingUid);     // Catch: Exception -> L13
        if (callingPackage != null) goto L9;
        return false;
    L9:
        if (callingPackage.equals(ActivityStarterHook.mDoubleAppPackageName) == false) goto L24;
        Slog.d(LOG_TAG, "allow double app(999) set CrossProfileIntentFilter");     // Catch: Exception -> L13
        return true;
    L24:
        return false;
    L13:
        e = move-exception;
        Slog.d(LOG_TAG, "enforceCrossProfileIntentFilterAccess e:" + e);
        return false;
    L22:
        return false;
    }

    static boolean createUserInternalNoRestriction(String name) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return false;
    L5:
        if ("double_lay_zte".equals(name) == false) goto L7;
    L8:
        Slog.d(LOG_TAG, "createUserInternal, allow(no check restriction)add doublelay profile for :" + name);
        return true;
    L7:
        if ("double_lay_zte_clone".equals(name) == true) goto L8;
        return false;
    }

    static void removeUserState_DoubleLay(int userId, SparseBooleanArray removingUserIds) {
        if (userId != 999) goto L6;
        Slog.i(LOG_TAG, "mRemovingUserIds.delete : " + userId);
        removingUserIds.delete(userId);
        return;
    }
}
