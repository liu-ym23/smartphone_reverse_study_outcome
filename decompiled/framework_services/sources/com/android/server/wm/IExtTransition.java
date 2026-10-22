package com.android.server.wm;

import android.pico.utils.IExtBase;
import android.util.ArraySet;
import android.view.SurfaceControl;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtTransition extends IExtBase {
    void addDisplayChangedContainer();

    void finishTransition(SurfaceControl.Transaction r1);

    ActivityRecord getStartActivity();

    void handleSeamlessRotation();

    boolean hasDisplayChangedContainer();

    void setStartActivity(ActivityRecord r1);

    default void markSyncFinished(int syncId, SurfaceControl.Transaction transaction) {
    }

    default boolean isSyncFinished() {
        return false;
    }

    default void onTransactionReady(int type, ArrayList<Transition.ChangeInfo> changeInfos, SnapshotController snapshotController) {
    }

    default boolean skipSnapshotWhenReady() {
        return false;
    }

    default void updateDimsIfNeeded(int type, ArrayList<Transition.ChangeInfo> changeInfos, SurfaceControl.Transaction transaction) {
    }

    default void updateAnimTargetIfNeed(ArrayList<Transition.ChangeInfo> outTargets, ArraySet<WindowContainer> participants) {
    }

    default void checkForFreeformAppInvisible(android.window.TransitionInfo info, SurfaceControl.Transaction transaction) {
    }

    default void onTransactionReady(android.window.TransitionInfo info, SurfaceControl.Transaction transaction) {
    }

    default boolean skipCommitInvisibleWhenFinish(WindowContainer participant) {
        return false;
    }

    default boolean isReverseActivityTransition() {
        return false;
    }

    default void finishTransition(TransitionController controller) {
    }

    default boolean isWmTraceEnable() {
        return false;
    }

    default void traceSetTransitionReady(boolean ready, int syncId) {
    }

    default void traceTransitionFinish(String finishLog) {
    }

    default void traceOnTransactionReady(String tag, int syncId, String infoStr) {
    }

    default void traceAbort(Transition transition, int state, boolean isCollecting, Transition collectingTransition) {
    }

    default void traceStartTrace(SurfaceControl.Transaction transaction, String tag) {
    }

    default void traceEndTrace(SurfaceControl.Transaction transaction) {
    }

    default void markStartSplitFromRecentsOrLauncher() {
    }

    default boolean isStartSplitFromRecentsOrLauncher() {
        return false;
    }

    default void setDeferredRotationApp(ActivityRecord app) {
    }

    default ActivityRecord getDeferredRotationApp() {
        return null;
    }

    default void clearDeferredRotationApp() {
    }

    default void onFreezeSnapshotReady(int type, WindowContainer wc, Transition.ChangeInfo changeInfo, SurfaceControl snapshotSurface, SurfaceControl.Transaction transaction) {
    }

    default boolean shouldSkipFreeze(WindowContainer windowContainer) {
        return false;
    }

    default void setRecentsForOpen(boolean forOpen) {
    }

    default void setRecentsForBackOrHome(boolean forBack) {
    }

    default boolean getIsRecentsFromRemote() {
        return false;
    }

    default boolean hasKeyguardLockedFlag() {
        return false;
    }

    default void setTransientHideTaskInsetsFrozen(ArrayList<Task> transientHideTasks, boolean freeze) {
    }
}
