package com.android.server.wm;

import android.app.IObricActivityTaskManager;
import android.app.IObricBackNavigationListener;
import android.view.InputEvent;
import android.view.MotionEvent;
import com.android.server.appop.AppOpsService;
import com.obric.utils.IObricBase;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface IObricActivityTaskManagerService extends IObricBase {
    default Task getTopDisplayFocusedRootTask(ActivityTaskManagerService service) {
        return service.getTopDisplayFocusedRootTask();
    }

    default void reportUsageInfo(ActivityRecord activity, int event) {
    }

    default IObricActivityTaskManager getIObricExt() {
        return null;
    }

    default void updateMutePackageLocked() {
    }

    default void setAppops(AppOpsService appOpsService) {
    }

    default void updateMuteStatus(boolean b) {
    }

    default boolean isAppBlockedByAuto(String packageName) {
        return false;
    }

    default void addDisablePackage(String[] packageName) {
    }

    default boolean registerBackNavigationInVirtualDisplayListenerEx(IObricBackNavigationListener listener) {
        return false;
    }

    default boolean unregisterBackNavigationInVirtualDisplayListenerEx(IObricBackNavigationListener listener) {
        return false;
    }

    default boolean registerBackNavigationListener(IObricBackNavigationListener listener) {
        return false;
    }

    default boolean unregisterBackNavigationListener(IObricBackNavigationListener listener) {
        return false;
    }

    default void onBackNavigationStarted(WindowState window) {
    }

    default void onBackNavigationDone(WindowManagerService wms) {
    }

    default boolean filterTaskFromRecents(Task task) {
        return false;
    }

    default void activityPaused(ActivityRecord activityRecord) {
    }

    default boolean shouldBeBlockInVisibleRange(Task task, int taskIndex) {
        return false;
    }

    default boolean writeRobotsLog(String targetPackage, String targetActivity, String actionType, String timestamp, String args) {
        return false;
    }

    default int getRobotsAgentUid() {
        return 0;
    }

    default void reportKeyEventOnAutoDisplay(InputEvent event) {
    }

    default void recordClickViewTreeCandidate(MotionEvent event) {
    }

    default void clearInvalidLaunchDisplayId(SafeActivityOptions opts) {
    }

    default void cleanupAutoActionSecondaryHomeOnDisplay(int displayId) {
    }

    default void cleanupStaleAutoActionSecondaryHomeExceptDisplay(int displayId) {
    }

    default void resetMuteSessionState() {
    }

    default void setWhitelist(Set<String> whitelist) {
    }
}
