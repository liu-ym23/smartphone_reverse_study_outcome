package com.android.server.wm;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.pico.utils.IExtBase;
import android.view.SurfaceControl;
import android.window.WindowContainerTransaction;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtTask extends IExtBase {
    public static final String EXTRA_FROM_SHORTCUT = "smt_extra_from_shortcut";

    void adjustBoundsIfNeeded(ActivityOptions r1, ActivityRecord r2, Task r3, Intent r4, boolean r5, int r6);

    void moveToBack(String r1);

    void moveToFront(String r1);

    void onRootTaskWindowingModeChanged(int r1);

    void prepareSurfaces(boolean r1);

    default void setScale(float scale) {
    }

    default float getScale() {
        return 1.0f;
    }

    default void setOffset(Point offset) {
    }

    default Point getOffset() {
        return new Point();
    }

    default void applyQuickWindowScale(float scale, Rect bounds) {
    }

    default boolean isMiniMode() {
        return false;
    }

    default void applyTaskChanges(WindowContainerTransaction.Change c) {
    }

    default void notifyAppRequestOrientation(ActivityRecord activity) {
    }

    default boolean isFreeformOrientationChanging() {
        return false;
    }

    default boolean resumeFocusedTasksTopActivities(Task topRootTask, Task task) {
        return false;
    }

    default boolean skipQuickTask(Task task, boolean allowFocusSelf) {
        return false;
    }

    default void pauseTopActivityLocked() {
    }

    default boolean deferResumeTopActivity() {
        return false;
    }

    default void resetDeferResumeTopActivity() {
    }

    default boolean needReturnMoveTaskToBack(Task task, Transition collecting) {
        return false;
    }

    default boolean shouldSkipPausingForSplitReplace(ActivityRecord activity, ActivityRecord resuming) {
        return false;
    }

    default boolean forceResizeable() {
        return false;
    }

    default void handleRemoveTask(String reason) {
    }

    default boolean isSuspended() {
        return false;
    }

    default void onTopResumedActivityChanged(ActivityRecord activityRecord, String reason) {
    }

    default void onTaskWindowingModeChanged(int fromWindowingMode, int toWindowingMode, String reason) {
    }

    default void changeTaskToFullscreen() {
    }

    default boolean isInSplitScreen() {
        return false;
    }

    default void traceStartTrace(SurfaceControl.Transaction transaction, String tag) {
    }

    default void traceEndTrace(SurfaceControl.Transaction transaction) {
    }

    default boolean isLandFreeformToFull() {
        return false;
    }

    default void setLandFreeformToFull(boolean landFreeformToFull) {
    }

    default boolean isFreeformToFullChangeOrientation() {
        return false;
    }

    default void setFreeformToFullChangeOrientation(int orientation) {
    }

    default boolean deferKeyguardLockedResumeTopActivity(ActivityRecord prev, ActivityRecord next, ActivityOptions options) {
        return false;
    }

    default int getOrientation() {
        return -1;
    }

    default float getCornerRadius() {
        return 0.0f;
    }
}
