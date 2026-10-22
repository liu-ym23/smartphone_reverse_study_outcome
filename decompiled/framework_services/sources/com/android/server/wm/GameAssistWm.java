package com.android.server.wm;

import android.content.Context;
import android.provider.Settings;
import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
public class GameAssistWm {
    private static final String TAG = "GameAssist.GameAssistWm";
    private final WindowManagerGlobalLock mGlobalLock;
    private final ActivityTaskManagerService mService;

    /* JADX INFO: renamed from: $r8$lambda$0rXeZAf3zpDsau3HbccA2KC-a7k, reason: not valid java name */
    public static /* synthetic */ boolean m9993$r8$lambda$0rXeZAf3zpDsau3HbccA2KCa7k(String r0, ActivityRecord r1) {
        return lambda$restartPackage$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$XilShPKes9ieUsf2rb31pqAtNA0(String r0, DisplayContent r1) {
        lambda$restartPackage$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$bnolyeLKsEyFBEAVM55qzsLwSe0(String r0, DisplayContent r1) {
        lambda$updateAppBounds$4(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$dMv3owSRFw-Sd9vl-sosOZDaIkw, reason: not valid java name */
    public static /* synthetic */ boolean m9994$r8$lambda$dMv3owSRFwSd9vlsosOZDaIkw(String r0, ActivityRecord r1) {
        return lambda$updateAppBounds$3(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$zsYet0O_InGjIvYtaTs4NIATg6E(String r0, ActivityRecord r1) {
        return lambda$restartPackage$0(r0, r1);
    }

    public GameAssistWm(ActivityTaskManagerService atm) {
        this.mService = atm;
        this.mGlobalLock = atm.mGlobalLock;
    }

    public void restartPackage(final String packageName) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mService.mRootWindowContainer.forAllDisplays(new GameAssistWm$$ExternalSyntheticLambda0(packageName));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$restartPackage$2(final String packageName, DisplayContent dc) {
        ActivityRecord activity = dc.getActivity(new GameAssistWm$$ExternalSyntheticLambda2(packageName));
        if (activity != null) goto L5;
        Slog.w(TAG, "search for activity to restart again displaycontent id=" + dc.getDisplayId());
        activity = dc.getActivity(new GameAssistWm$$ExternalSyntheticLambda3(packageName));
    L5:
        if (activity != null) goto L8;
        Slog.w(TAG, "restartPackage No Activity found for package name: " + packageName + " displaycontent id=" + dc.getDisplayId());
        return;
    L8:
        Slog.i(TAG, "restartPackage " + activity);
        activity.setOrientation(activity.info.screenOrientation);
        activity.restartProcessIfVisible();
    }

    private static /* synthetic */ boolean lambda$restartPackage$0(String packageName, ActivityRecord activityRecord) {
        if (packageName.equals(activityRecord.packageName) == true) goto L5;
    L9:
        return false;
    L5:
        if (activityRecord.finishing == true) goto L9;
        if (activityRecord.occludesParent() == false) goto L9;
        return true;
    }

    private static /* synthetic */ boolean lambda$restartPackage$1(String packageName, ActivityRecord activityRecord) {
        if (packageName.equals(activityRecord.packageName) == true) goto L5;
    L7:
        return false;
    L5:
        if (activityRecord.finishing == true) goto L7;
        return true;
    }

    public void updateAppBounds(final String packageName) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mService.mRootWindowContainer.forAllDisplays(new GameAssistWm$$ExternalSyntheticLambda4(packageName));     // Catch: Throwable -> L6 Exception -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L6
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L6:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L6
        goto L10
    }

    private static /* synthetic */ void lambda$updateAppBounds$4(final String packageName, DisplayContent dc) {
        ActivityRecord activity = dc.getActivity(new GameAssistWm$$ExternalSyntheticLambda1(packageName));
        if (activity != null) goto L6;
        Slog.w(TAG, "updateAppBounds No Activity found for package name: " + packageName + " displaycontent id=" + dc.getDisplayId());
        return;
    L6:
        Slog.i(TAG, "updateAppBounds " + activity);
        activity.getDisplayContent().onRequestedOverrideConfigurationChanged(activity.getDisplayContent().getRequestedOverrideConfiguration());
    }

    private static /* synthetic */ boolean lambda$updateAppBounds$3(String packageName, ActivityRecord activityRecord) {
        if (packageName.equals(activityRecord.packageName) == true) goto L5;
    L7:
        return false;
    L5:
        if (activityRecord.finishing == true) goto L7;
        return true;
    }

    public void startHome(int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Slog.d(TAG, "startHome");     // Catch: Throwable -> L8
        this.mService.mRootWindowContainer.startHomeOnDisplay(0, "gameassist", displayId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public static boolean isGameLockScreen(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "nubia_game_lock_screen", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isGameScene(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "nubia_game_scene", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }
}
