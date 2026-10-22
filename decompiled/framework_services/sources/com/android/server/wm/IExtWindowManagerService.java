package com.android.server.wm;

import android.app.ActivityManager;
import android.app.IDisplayInfoCallbackEx;
import android.app.ITaskStackListenerEx;
import android.app.ITopActivityAssistDataReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.os.IBinder;
import android.os.Parcel;
import android.pico.utils.IExtBase;
import android.view.IWindow;
import android.view.IWindowManagerExt;
import android.view.SurfaceControl;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtWindowManagerService extends IExtBase {
    public static final int TRANSACT_CODE_FORCE_HIDE_KEYGUARD = 10001;
    public static final int TRANSACT_CODE_KEYGUARD_STATE_LISTENER = 10002;
    public static final int TRANSACT_CODE_KEYGUARD_WAITING_FOR_ACTIVITY_DRAWN = 10003;
    public static final int TRANSACT_CODE_SCREENSHOT = 10000;
    public static final int TRANSACT_CODE_SWITCH_DYNAMIC_RESOLUTION = 10004;

    void dispatchKeyguardLockedState(boolean r1, boolean r2);

    ActivityManager.RunningTaskInfo getCurrentTaskInfo(int r1);

    Intent getCurrentTopIntent(boolean r1, List<String> r2);

    IWindowManagerExt getIExt();

    ExtWindowManagerInternal getLocalService();

    float getResolutionScaleByToken(IBinder r1);

    void grantInputChannel(IBinder r1, SurfaceControl r2, String r3);

    void hideImeInAuto(int r1);

    void init();

    boolean isAutoActionRunning();

    boolean isFreezingDisplayForSwitchResolution();

    boolean isImeHidingAnimation();

    boolean isNeedRedoWallpaperLayout(WindowState r1, int r2, boolean r3);

    void moveQuickWinToMiniMode();

    void onActivityWindowsVisible(ActivityInfo r1);

    void onAutoBlacklistAppOpen(String r1);

    void onBootAnimationFade(long r1);

    void onDisplayChanged(int r1, int r2);

    void onDisplaySecureChanged(int r1, boolean r2);

    void onDisplayStatusBarChanged(int r1, int r2);

    void onSetStatusBarDisabled(int r1, int r2, int r3, int r4, boolean r5);

    void onTaskRemovedBeforeFocusChanged(ActivityManager.RunningTaskInfo r1);

    void onTaskToBackground(ActivityManager.RunningTaskInfo r1);

    boolean onTransact(int r1, Parcel r2, Parcel r3, int r4);

    boolean onWindowSecureChanged(DisplayContent r1, boolean r2, boolean r3);

    void openLogs(String r1);

    void pauseCurrentTaskTopActivity(int r1);

    boolean registerDisplayInfoListenerEx(IDisplayInfoCallbackEx r1);

    boolean registerTaskStackListenerEx(ITaskStackListenerEx r1);

    void removeClientToken(IBinder r1);

    void reportError(WindowProcessController r1, int r2);

    void reportErrorToListener(int r1, int r2);

    ResolveInfo resolveHomeIntent(int r1, Intent r2);

    HardwareBuffer screenShotAppWindows(int r1, Rect r2, float r3);

    void setAnimationScaleByPkgName(String r1, float r2);

    void setAutoFocusedPkg(String r1);

    void setResolutionScaleByPkgName(String r1, float r2);

    void setResolutionScaleGtByPkgName(String r1, float r2);

    boolean showImeInAuto(IBinder r1, int r2);

    void systemReady();

    void tryFinishSwitchResolution();

    void tryToMute(boolean r1);

    void tryToMuteDelay(Long r1);

    boolean unregisterDisplayInfoListenerEx(IDisplayInfoCallbackEx r1);

    boolean unregisterTaskStackListenerEx(ITaskStackListenerEx r1);

    void updateImeHidingState(boolean r1);

    void updateResolutionScaleToServer(IWindow r1, float r2);

    default boolean focusedWindowIsSecure() {
        return false;
    }

    default SurfaceControl[] handleQuickWinSnapshot(SurfaceControl[] excludeLayers) {
        return excludeLayers;
    }

    default ActivityRecord getMostRecentActivityInAdjacent(ActivityRecord focusedActivity) {
        return null;
    }

    default boolean dropEventIfNeeded(ActivityRecord touchedApp) {
        return false;
    }

    default boolean requestTopActivityAssistDataForOreader(int requestId, int displayId, ITopActivityAssistDataReceiver receiver) {
        return false;
    }

    default void dumpWmTrace() {
    }

    default boolean isWmTraceEnable() {
        return false;
    }

    default void traceAddWindow(Object win) {
    }

    default void traceRemoveWindow(Object win) {
    }

    default void traceFinishDrawing(Object win) {
    }

    default void traceRelayoutWindow(WindowState win, boolean wallpaperMayMove, int viewVisibility) {
    }

    default void updateInterceptKeyAndAnimationState(boolean homeEnabled, boolean backEnabled, int recentAnimationState, int focusTaskId, IBinder runner) {
    }

    default void updateReverseTransitionEnabled(Context context) {
    }
}
