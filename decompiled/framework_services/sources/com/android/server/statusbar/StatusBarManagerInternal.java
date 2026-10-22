package com.android.server.statusbar;

import android.app.ITransientNotificationCallback;
import android.content.ComponentName;
import android.hardware.fingerprint.IUdfpsRefreshRateRequestCallback;
import android.os.Bundle;
import android.os.IBinder;
import android.os.UserHandle;
import com.android.internal.statusbar.LetterboxDetails;
import com.android.internal.view.AppearanceRegion;
import com.android.server.notification.NotificationDelegate;
import java.io.FileDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public interface StatusBarManagerInternal {
    void abortTransient(int r1, int r2);

    void addQsTileToFrontOrEnd(ComponentName r1, boolean r2);

    void appTransitionCancelled(int r1);

    void appTransitionFinished(int r1);

    void appTransitionPending(int r1);

    void appTransitionStarting(int r1, long r2, long r4);

    void cancelPreloadRecentApps();

    void collapsePanels();

    void confirmImmersivePrompt();

    void dismissKeyboardShortcutsMenu();

    void hideRecentApps(boolean r1, boolean r2);

    void hideToast(String r1, IBinder r2);

    void immersiveModeChanged(int r1, int r2, boolean r3, int r4);

    void moveFocusedTaskToDesktop(int r1);

    void moveFocusedTaskToFullscreen(int r1);

    void moveFocusedTaskToStageSplit(int r1, boolean r2);

    void onBootAnimationFade(long r1);

    void onCameraLaunchGestureDetected(int r1);

    void onDisplayAddSystemDecorations(int r1);

    void onDisplayRemoveSystemDecorations(int r1);

    void onEmergencyActionLaunchGestureDetected();

    void onProposedRotationChanged(int r1, int r2, boolean r3);

    void onSystemBarAttributesChanged(int r1, int r2, AppearanceRegion[] r3, boolean r4, int r5, int r6, String r7, LetterboxDetails[] r8);

    void onWalletLaunchGestureDetected();

    void passThroughShellCommand(String[] r1, FileDescriptor r2);

    void preloadRecentApps();

    void removeQsTile(ComponentName r1);

    boolean requestMagnificationConnection(boolean r1);

    void setCurrentUser(int r1);

    void setDisableFlags(int r1, int r2, String r3);

    void setIcon(String r1, String r2, int r3, int r4, String r5);

    void setIconVisibility(String r1, boolean r2);

    void setImeWindowStatus(int r1, int r2, int r3, boolean r4);

    void setNavigationBarLumaSamplingEnabled(int r1, boolean r2);

    void setNotificationDelegate(NotificationDelegate r1);

    void setReverseState(int r1);

    void setSplitscreenFocus(boolean r1);

    void setTopAppHidesStatusBar(int r1, boolean r2);

    void setUdfpsRefreshRateCallback(IUdfpsRefreshRateRequestCallback r1);

    void setWindowState(int r1, int r2, int r3);

    void showAssistDisclosure();

    void showChargingAnimation(int r1);

    void showMediaOutputSwitcher(String r1, UserHandle r2);

    void showPictureInPictureMenu();

    void showRearDisplayDialog(int r1);

    void showRecentApps(boolean r1);

    void showScreenPinningRequest(int r1, int r2);

    boolean showShutdownUi(boolean r1, String r2);

    void showToast(int r1, String r2, IBinder r3, CharSequence r4, IBinder r5, int r6, ITransientNotificationCallback r7, int r8, int r9);

    void showTransient(int r1, int r2, boolean r3);

    void startAssist(Bundle r1);

    void toggleKeyboardShortcutsMenu(int r1);

    void toggleRecentApps();

    void toggleSplitScreen();

    void toggleTaskbar();
}
