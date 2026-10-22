package com.android.server.display;

import android.content.Context;
import android.os.DebugSmtEx;
import com.android.server.display.mode.DisplayModeDirector;
import com.android.server.wm.ActivityRecord;
import com.android.server.wm.WindowManagerServiceSmtEx;

/* JADX INFO: loaded from: classes2.dex */
public interface IDynamicRefreshRateService {
    default void startService(Context context) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setWindowManagerServiceSmtEx(WindowManagerServiceSmtEx mSmtEx) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default String getCurrentPackageName() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default void onLocalAnimationStartLocked(long animDuration) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onInsetAnimationShow(int type) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onInsetAnimationHide(int type) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onFocusedWindowChangeLocked(String oldFocusPackage, String newFocusPackage) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onMove() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onFling(float velocityX, float velocityY, int duration) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean shouldInterceptUpdateDisplayModeSpecs(int displayId, DisplayModeDirector.DesiredDisplayModeSpecs modeSpecs) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void onTopResumedActivityChangedLocked(ActivityRecord r) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onAppPreferredRefreshRateRangeChanged(float requestedRefreshRate) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onInputEventReceivedBeforeDispatch(int displayId, int state) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setLowTempLowPowerLevel(int level) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onPhysicalDisplayStateChanged(int displayId, boolean connect) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onRootTaskWindowingModeChanged(String basePackageName, ActivityRecord topRunningActivity, int prevWindowingMode, int windowingMode) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isXtsMode() {
        return false;
    }

    default boolean shouldInterceptPowerBoost(String scene) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void onStatusBarDropStateChanged(int type) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
