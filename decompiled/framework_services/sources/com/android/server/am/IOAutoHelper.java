package com.android.server.am;

import android.content.ComponentName;
import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IOAutoHelper {
    default void init(ActivityManagerService ams) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setFocusedActivity(ComponentName activityComponent, boolean isOnMainDisplay) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onLogAppDisplayed(String packageName, String launchedActivityShortComponentName, int sysType) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onAppTransitionFinished(ComponentName activityComponent) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onActivityIdle(ComponentName activityComponent) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onAppRelayoutWindow(ComponentName activityComponent, boolean isOnMainDisplay, boolean flagFullscreen, boolean flagDimBehind, boolean isLandscape) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
