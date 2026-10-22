package com.android.server.wm;

import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtInsetsPolicy extends IExtBase {
    default boolean shouldTreatNavigationBarHiddenForGestureNavigation() {
        return false;
    }

    default void updateStatusBarHidingTaskForHomeTransition(WindowState topApp, boolean topAppHidesStatusBar, int showingTransientTypes) {
    }

    default InsetsControlTarget getStatusControlTargetForHomeTransition(WindowState focusedWin, boolean isTransientStatusBar, int showingTransientTypes, DisplayContent displayContent) {
        return null;
    }
}
