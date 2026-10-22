package com.android.server.wm;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.pico.utils.IExtBase;
import android.view.SurfaceControl;
import android.window.TaskSnapshot;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtActivityRecord extends IExtBase {
    boolean containsTurnScreenOnWindow();

    Object getActivityInfoMetaData(String r1);

    boolean hasSubPanel();

    boolean isInCallUI();

    void onWindowsVisible(ActivityInfo r1);

    boolean shouldEnableTaskAnimation(ActivityInfo r1);

    int shouldRelaunchLocked(int r1);

    boolean shouldRemoveStartingIfNeeded(ActivityRecord r1);

    default boolean skipRelaunch(int changes, Configuration changesConfig) {
        return false;
    }

    default boolean shouldSendCompatFakeFocus() {
        return false;
    }

    default int getFixedRotationForSplashScreen() {
        return -2;
    }

    default boolean forceResizeable() {
        return false;
    }

    default boolean shouldBlockAddStartingWindow(TaskSnapshot snapshot) {
        return false;
    }

    default void updateFocusedWindowIfNeeded(boolean visible) {
    }

    default boolean isWmTraceEnable() {
        return false;
    }

    default void traceAddStartingWindow(ActivityRecord ar, Object startingData) {
    }

    default void traceGetStartingWindowType(boolean newTask, boolean taskSwitch, boolean processRunning, boolean allowTaskSnapshot, boolean activityCreated, boolean activityAllDrawn, TaskSnapshot snapshot, boolean occludesParent) {
    }

    default void traceClearStartingData(ActivityRecord ar) {
    }

    default void traceScheduleRemoveStartingWindow(Object startingWindow) {
    }

    default void traceRemoveStartingWindowNull(ActivityRecord ar) {
    }

    default void traceSkipRemoveStartingWindow(ActivityRecord ar) {
    }

    default void traceStartTrace(SurfaceControl.Transaction transaction, String tag) {
    }

    default void traceEndTrace(SurfaceControl.Transaction transaction) {
    }

    default void traceMovingExistingStarting(Object tStartingWindow, ActivityRecord fromActivity, ActivityRecord toActivity) {
    }

    default void traceSetAppVisibility(ActivityRecord ar, boolean visible) {
    }

    default void traceCommitVisibility(ActivityRecord ar, boolean visible) {
    }

    default boolean shouldCreateSnapshot(String packageName, boolean taskSwitch, TaskSnapshot snapshot) {
        return true;
    }

    default boolean isResolverOrDelegateActivity() {
        return false;
    }

    default boolean shouldUseSplashScreen(Intent intent) {
        return false;
    }

    default boolean shouldAddStartingForTranslucent() {
        return false;
    }

    default boolean shouldDisableLetterboxInSplitScreen() {
        return false;
    }

    default void executeAppTransitionIfNeeded() {
    }

    default boolean shouldSkipSyncFinishedForKeyguard() {
        return false;
    }

    default void traceSetShowWhenLocked(boolean showWhenLocked) {
    }

    default void handleFixedRotationIfNeeded() {
    }

    default void onActivityFirstWindowDrawn(String reason) {
    }
}
