package com.android.server.wm;

import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtTransitionController extends IExtBase {
    boolean hasDisplayChangedContainer();

    boolean isSameTransientInPlaying(Task r1, int r2);

    boolean isTransitionKeyguardGoingAway();

    boolean makeIndependentTrackIfNeed(Transition r1, Transition r2, android.window.TransitionInfo r3, int r4);

    default void validateHomeActivity(Transition transition) {
    }

    default void processValidateActivity() {
    }

    default boolean isWmTraceEnable() {
        return false;
    }

    default void traceStartCollecting(int syncId) {
    }

    default void traceRequestingStartTransition(int syncId) {
    }

    default void onActiveTransitionPlayerDiedForSplitDragImeSuppression() {
    }

    default void onFinishTransition() {
    }

    default void onAbortTransition() {
    }

    default void initValidateWC(Transition transition) {
    }

    default void processValidateWC() {
    }

    default int getTransitionModeInTransition(WindowContainer wc) {
        return 0;
    }

    default boolean shouldInterceptBackForRecents(ActivityRecord activityRecord) {
        return false;
    }

    default boolean isInRecentsFromRemote() {
        return false;
    }

    default Transition getPlayingRecentsTransition() {
        return null;
    }

    default boolean isTransientLaunchNotFromRemote(ActivityRecord ar) {
        return false;
    }
}
