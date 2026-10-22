package com.android.server.am;

import android.content.Intent;
import android.content.pm.PackageManagerInternal;
import android.content.pm.UserInfo;
import android.mifavor.MFVUtils;
import android.os.Binder;
import android.util.EventLog;
import android.util.Log;
import com.android.server.LocalServices;
import com.android.server.pm.UserManagerService;
import com.android.server.scene.ZteSceneDecisionInternal;
import com.android.server.utils.Slogf;
import com.android.server.wm.ActivityStarterHook;
import com.zte.feature.Feature;
import com.zte.performance.scene.ZteSceneDecisionManager;

/* JADX INFO: loaded from: classes.dex */
public interface IZswUserController {
    public static final String TAG = "IZswUserController";

    public static class Injector {
        public Injector() {
        }

        public void broadcastIntent(int logUserId, Intent intent) {
            if (ZteSceneDecisionManager.ENABLED == false) goto L10;
            ZteSceneDecisionInternal sceneDecision = (ZteSceneDecisionInternal) LocalServices.getService(ZteSceneDecisionInternal.class);
            String action = null;
            if (sceneDecision == null) goto L8;
            if (intent == null) goto L8;
            action = intent.getAction();
            sceneDecision.noteUserSwitchEvent(logUserId, action);
        L8:
            EventLog.writeEvent(EventLogTags.UC_SEND_USER_BROADCAST, new Object[]{Integer.valueOf(logUserId), action});
            return;
        }
    }

    void finishUserUnlockedCompleted(int r1);

    void handleNotifyMulthemeUserSwitch(int r1);

    static int addOneForDoubleLay() {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return 0;
    L5:
        if (Feature.getCtsRunningStatus() == true) goto L8;
        return 1;
    L8:
        Slogf.d(TAG, "setInitialConfig -> addOneForDoubleLay cts running keep org...");
        return 0;
    }

    static boolean notAllowStopDoubleLay(int userId) {
    L16:
        e = move-exception;
        Slogf.w(TAG, "stopSingleUserLU -> notAllowStopDoubleLay e:" + e);
    L22:
        return false;
    L4:
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L22;
        if (userId != 999) goto L22;
        int callingUid = Binder.getCallingUid();     // Catch: Exception -> L16
        String callingPackageName = ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getNameForUid(callingUid);     // Catch: Exception -> L16
        if (callingPackageName != null) goto L11;
    L18:
        Slogf.d(TAG, "stopSingleUserLU -> notAllowStopDoubleLay allow stop for doubleapp ,callingPackageName:" + callingPackageName + ",callingUid:" + callingUid);     // Catch: Exception -> L16
        return false;
    L11:
        if (ActivityStarterHook.mDoubleAppPackageName.equals(callingPackageName) == true) goto L18;
        if (callingUid == 1000) goto L18;
        Slogf.d(TAG, "stopSingleUserLU -> notAllowStopDoubleLay not allow stopUser 999 !!!, reason: not doubleapp,callingPackageName:" + callingPackageName + ",callingUid:" + callingUid);     // Catch: Exception -> L16
        return true;
    }

    static void makeInitialized_DoubleLay(UserInfo user, UserManagerService userManager) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L17;
    L10:
        e = move-exception;
        Slogf.e(TAG, "debug_lock_999 startProfilesLocked -> makeInitialized_DoubleLay e:" + e);
        return;
    L5:
        if (user.id != 999) goto L18;
        Slogf.d(TAG, "debug_lock_999 startProfilesLocked -> makeInitialized_DoubleLay ,isInitialized():" + user.isInitialized() + ",user.isQuietModeEnabled:" + user.isQuietModeEnabled() + ",user:" + user);     // Catch: Exception -> L10
        if (user.isInitialized() == true) goto L19;
        userManager.makeInitialized(999);     // Catch: Exception -> L10
        Slogf.d(TAG, "debug_lock_999 startProfilesLocked -> makeInitialized_DoubleLay(after):,isInitialized():" + user.isInitialized());     // Catch: Exception -> L10
        return;
    L19:
        return;
    L18:
        return;
    }

    static boolean isDoubleLayExist(UserInfo user) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return false;
    L5:
        if (user.id != 999) goto L10;
        Slogf.d(TAG, "debug_lock_999 profilesToStart -> isDoubleLayExist 999 exist ");
        return true;
    L10:
        return false;
    }

    static boolean isDoubleLayStarted(int startedUserId, boolean isDoubleLayExist, int maxRunningUsers) {
        boolean isDoubleLayStarted = false;
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
    L8:
        return isDoubleLayStarted;
    L5:
        if (startedUserId != 999) goto L7;
        isDoubleLayStarted = true;
    L7:
        Slogf.d(TAG, "debug_lock_999 to startUser -> isDoubleLayStarted startedUserId:" + startedUserId + ",isDoubleLayExist:" + isDoubleLayExist + ",isDoubleLayStarted:" + isDoubleLayStarted + ",MaxRunningUsers:" + maxRunningUsers);
        goto L8
    }

    static void startUser_DoubleLay(UserController controller, boolean isDoubleLayExist, boolean isDoubleLayStarted) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L11;
        if (isDoubleLayExist == false) goto L15;
        if (isDoubleLayStarted == true) goto L16;
        Slogf.d(TAG, "debug_lock_999 to startUser_DoubleLay 999,even if over MAX_RUNNING_USERS(3)");     // Catch: Exception -> L8
        controller.startUser(999, 3);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Slogf.e(TAG, "debug_lock_999 startUser_DoubleLay e:" + e);
        return;
    L16:
        return;
    L15:
        return;
    }

    static boolean handleIncomingUser_DoubleLay(String callerPackage, int callingUserId, int userId) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return false;
    L5:
        if (callingUserId != 999) goto L7;
        if (userId != 0) goto L7;
    L9:
        Log.d(TAG, "handleIncomingUser_DoubleLay allow cross access callerPackage:" + callerPackage + ",userId:" + userId + ",callingUserId:" + callingUserId);
        return true;
    L7:
        if (callingUserId != 0) goto L13;
        if (userId == 999) goto L9;
        return false;
    L13:
        return false;
    }
}
