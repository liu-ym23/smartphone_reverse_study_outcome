package com.android.server.wm;

import android.app.ActivityManager;
import android.app.IObricDisplayInfoCallback;
import android.app.IObricTaskStackListener;
import android.app.ITopActivityAssistDataReceiver;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import android.view.IObricWindowManager;
import android.view.WindowManager;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IObricWindowManagerService extends IObricBase {
    default IObricWindowManager getIObricExt() {
        return null;
    }

    default Bitmap takeAssistScreenshotForTopApp() {
        return null;
    }

    default void updateWindowStateShowWhenKeyguard(WindowManager.LayoutParams attrs, int callingPid, int callingUid, WindowState win) {
    }

    default boolean shouldDispatchToAutoDisplay() {
        return false;
    }

    default WindowState resolveBackFocusedWindow() {
        return null;
    }

    default void enableCallUser(boolean enable) {
    }

    default DisplayContent getAutoVirtualDisplayContent() {
        return null;
    }

    default boolean isAutoActionRunning() {
        return false;
    }

    default boolean isPackageVisibleOnDisplay(String pakcageName, int displayId) {
        return false;
    }

    default boolean isUidRunningOnAutoActionDisplay(int uid) {
        return false;
    }

    default void onDisplayStatusBarChanged(int displayId, int appearance) {
    }

    default boolean moveTaskToDisplay(int taskId, int displayId, boolean isTop) {
        return false;
    }

    default int getAutoDisplayId() {
        return 0;
    }

    default Pair<WindowToken, DisplayContent> findSuitableWindowTokenLocked(boolean hasParent, WindowState parentWindow, WindowManager.LayoutParams attrs, WindowToken token) {
        return null;
    }

    default void setAutoFocusedPkg(String owningPackage) {
    }

    default void onInputMethodShown(boolean shown) {
    }

    default boolean showImeInAuto(IBinder windowToken, int selfReportedDisplayId) {
        return false;
    }

    default void hideImeInAuto(int selfReportedDisplayId) {
    }

    default void onAutoBlacklistAppOpen(String packageName) {
    }

    default boolean registerTaskStackListenerEx(IObricTaskStackListener listener) {
        return false;
    }

    default void reportError(WindowProcessController app, int error) {
    }

    default void reportErrorToListener(int taskid, int error) {
    }

    default void tryToMuteDelay(Long delay) {
    }

    default void tryToMute(boolean shouldMute) {
    }

    default boolean unregisterTaskStackListenerEx(IObricTaskStackListener listener) {
        return false;
    }

    default boolean onWindowSecureChanged(DisplayContent displayContent, boolean hasSecureWindow, boolean newWindowSecure) {
        return false;
    }

    default void onTaskRemovedBeforeFocusChanged(ActivityManager.RunningTaskInfo info) {
    }

    default void onTaskToBackground(ActivityManager.RunningTaskInfo taskInfo) {
    }

    default void onDisplaySecureChanged(int displayId, boolean secure) {
    }

    default IObricWindowManagerInternal getLocalService() {
        return null;
    }

    default ActivityManager.RunningTaskInfo getCurrentTaskInfo(int displayId) {
        return null;
    }

    default boolean registerDisplayInfoListenerEx(IObricDisplayInfoCallback listener) {
        return false;
    }

    default boolean unregisterObricDisplayInfoCallback(IObricDisplayInfoCallback listener) {
        return false;
    }

    default int hasInputMethodClientFocus(int displayId) {
        return -5;
    }

    default boolean requestTopActivityAssistData(int requestId, int displayId, ITopActivityAssistDataReceiver receiver) {
        return false;
    }

    default void onWindowRemoved(WindowState window) {
    }

    default void onWindowLostFocus(WindowState window) {
    }

    default void onWindowGainedFocus(WindowState window) {
    }

    default void onDisplayCaptured(int displayId) {
    }

    default void notifyWindowVisibleChanged(WindowState win, boolean winVisible) {
    }

    default boolean isAssistWindow(WindowState window) {
        return false;
    }

    default boolean shouldBlockAddStartingWindow(ActivityRecord activityRecord) {
        return false;
    }

    default void requestScenePerception(Bundle bundle) {
    }

    default void reportScenePerceptionEvent(int type, Bundle bundle, int callingUid) {
    }

    default void recordObricVirtualDisplayRemoved(int displayId) {
    }

    default boolean isRemovedObricVirtualDisplayId(int displayId) {
        return false;
    }
}
