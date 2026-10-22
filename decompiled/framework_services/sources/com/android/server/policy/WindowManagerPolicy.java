package com.android.server.policy;

import android.content.ComponentName;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.view.Display;
import android.view.IDisplayFoldListener;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.WindowManager;
import android.view.WindowManagerPolicyConstants;
import android.view.animation.Animation;
import com.android.internal.policy.IKeyguardDismissCallback;
import com.android.internal.policy.IShortcutService;
import com.android.server.wm.DisplayRotation;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface WindowManagerPolicy extends WindowManagerPolicyConstants {
    public static final int ACTION_PASS_TO_USER = 1;
    public static final int COLOR_FADE_LAYER = 1073741825;
    public static final int FINISH_LAYOUT_REDO_ANIM = 8;
    public static final int FINISH_LAYOUT_REDO_CONFIG = 2;
    public static final int FINISH_LAYOUT_REDO_LAYOUT = 1;
    public static final int FINISH_LAYOUT_REDO_WALLPAPER = 4;
    public static final int TRANSIT_ENTER = 1;
    public static final int TRANSIT_EXIT = 2;
    public static final int TRANSIT_HIDE = 4;
    public static final int TRANSIT_PREVIEW_DONE = 5;
    public static final int TRANSIT_SHOW = 3;
    public static final int USER_ROTATION_FREE = 0;
    public static final int USER_ROTATION_LOCKED = 1;

    public interface DisplayContentInfo {
        Display getDisplay();

        DisplayRotation getDisplayRotation();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NavigationBarPosition {
    }

    public interface OnKeyguardExitResult {
        void onKeyguardExitResult(boolean r1);
    }

    public interface ScreenOffListener {
        void onScreenOff();
    }

    public interface ScreenOnListener {
        void onScreenOn();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UserRotationMode {
    }

    public interface WindowManagerFuncs {
        public static final int CAMERA_LENS_COVERED = 1;
        public static final int CAMERA_LENS_COVER_ABSENT = -1;
        public static final int CAMERA_LENS_UNCOVERED = 0;
        public static final int LID_ABSENT = -1;
        public static final int LID_BEHAVIOR_LOCK = 2;
        public static final int LID_BEHAVIOR_NONE = 0;
        public static final int LID_BEHAVIOR_SLEEP = 1;
        public static final int LID_CLOSED = 0;
        public static final int LID_OPEN = 1;

        void enableScreenIfNeeded();

        int getCameraLensCoverState();

        int getLidState();

        Object getWindowManagerLock();

        boolean isCallerVirtualDeviceOwner(int r1, int r2);

        boolean isDisplayTrusted(int r1);

        void lockDeviceNow();

        void moveDisplayToTopIfAllowed(int r1);

        void notifyKeyguardTrustedChanged();

        List<ComponentName> notifyScreenshotListeners(int r1);

        void onKeyguardShowingAndNotOccludedChanged();

        void onPowerKeyDown(boolean r1);

        void onUserSwitched();

        void reboot(boolean r1);

        void rebootSafeMode(boolean r1);

        void registerPointerEventListener(WindowManagerPolicyConstants.PointerEventListener r1, int r2);

        void screenTurningOff(int r1, ScreenOffListener r2);

        void shutdown(boolean r1);

        void unregisterPointerEventListener(WindowManagerPolicyConstants.PointerEventListener r1, int r2);

        void updateRotation(boolean r1, boolean r2);

        static String lidStateToString(int lid) {
            switch(lid) {
                case -1: goto L9;
                case 0: goto L7;
                case 1: goto L5;
                default: goto L4;
            };
        L5:
            return "LID_OPEN";
        L7:
            return "LID_CLOSED";
        L9:
            return "LID_ABSENT";
        L4:
            return Integer.toString(lid);
        }

        static String cameraLensStateToString(int lens) {
            switch(lens) {
                case -1: goto L9;
                case 0: goto L7;
                case 1: goto L5;
                default: goto L4;
            };
        L5:
            return "CAMERA_LENS_COVERED";
        L7:
            return "CAMERA_LENS_UNCOVERED";
        L9:
            return "CAMERA_LENS_COVER_ABSENT";
        L4:
            return Integer.toString(lens);
        }
    }

    public interface WindowState {
        boolean canShowWhenLocked();

        int getBaseType();

        String getOwningPackage();

        boolean isAnimatingLw();

        default boolean canAddInternalSystemWindow() {
            return false;
        }
    }

    void adjustConfigurationLw(Configuration r1, int r2, int r3);

    int applyKeyguardOcclusionChange();

    boolean canDismissBootAnimation();

    int checkAddPermission(int r1, boolean r2, String r3, int[] r4, int r5);

    Animation createHiddenByKeyguardExit(boolean r1, boolean r2, boolean r3);

    Animation createKeyguardWallpaperExit(boolean r1);

    void dismissKeyguardLw(IKeyguardDismissCallback r1, CharSequence r2);

    void dump(String r1, PrintWriter r2, String[] r3);

    void dumpDebug(ProtoOutputStream r1, long r2);

    void enableKeyguard(boolean r1);

    void enableScreenAfterBoot();

    void exitKeyguardSecurely(OnKeyguardExitResult r1);

    void finishedGoingToSleep(int r1, int r2);

    void finishedGoingToSleepGlobal(int r1);

    void finishedWakingUp(int r1, int r2);

    void finishedWakingUpGlobal(int r1);

    KeyboardShortcutGroup getApplicationLaunchKeyboardShortcuts(int r1);

    IExtPhoneWindowManager getExt();

    int getUiMode();

    boolean hasNavigationBar();

    void hideBootMessages();

    boolean inKeyguardRestrictedKeyInputMode();

    void init(Context r1, WindowManagerFuncs r2);

    long interceptKeyBeforeDispatching(IBinder r1, KeyEvent r2, int r3);

    int interceptKeyBeforeQueueing(KeyEvent r1, int r2);

    int interceptMotionBeforeQueueingNonInteractive(int r1, int r2, int r3, long r4, int r6);

    boolean interceptUnhandledKey(KeyEvent r1, IBinder r2);

    boolean isGlobalKey(int r1);

    boolean isKeyguardDrawnLw();

    boolean isKeyguardHostWindow(WindowManager.LayoutParams r1);

    boolean isKeyguardLocked();

    boolean isKeyguardOccluded();

    boolean isKeyguardSecure(int r1);

    boolean isKeyguardShowing();

    boolean isKeyguardShowingAndNotOccluded();

    boolean isKeyguardTrustedLw();

    boolean isScreenOn();

    boolean isUserSetupComplete();

    void keepScreenOnStartedLw();

    void keepScreenOnStoppedLw();

    void lockNow(Bundle r1);

    void notifyCameraLensCoverSwitchChanged(long r1, boolean r3);

    void notifyLidSwitchChanged(long r1, boolean r3);

    boolean okToAnimate(boolean r1);

    void onDisplaySwitchStart(int r1);

    void onKeyguardOccludedChangedLw(boolean r1);

    void onSystemUiStarted();

    void registerShortcutKey(long r1, IShortcutService r3) throws RemoteException;

    void screenTurnedOff(int r1, boolean r2);

    void screenTurnedOn(int r1);

    void screenTurningOff(int r1, ScreenOffListener r2);

    void screenTurningOn(int r1, ScreenOnListener r2);

    void setAllowLockscreenWhenOn(int r1, boolean r2);

    void setCurrentUserLw(int r1);

    void setDefaultDisplay(DisplayContentInfo r1);

    void setNavBarVirtualKeyHapticFeedbackEnabledLw(boolean r1);

    void setPipVisibilityLw(boolean r1);

    void setRecentsVisibilityLw(boolean r1);

    void setSafeMode(boolean r1);

    void setSwitchingUser(boolean r1);

    void setTopFocusedDisplay(int r1);

    void showBootMessage(CharSequence r1, boolean r2);

    void showDismissibleKeyguard();

    void showGlobalActions();

    void showRecentApps();

    void startKeyguardExitAnimation(long r1);

    void startedGoingToSleep(int r1, int r2);

    void startedGoingToSleepGlobal(int r1);

    void startedWakingUp(int r1, int r2);

    void startedWakingUpGlobal(int r1);

    void systemBooted();

    void systemReady();

    void togglePowerAndAiKey(boolean r1);

    void userActivity(int r1, int r2);

    default int getWindowLayerLw(WindowState win) {
        return getWindowLayerFromTypeLw(win.getBaseType(), win.canAddInternalSystemWindow());
    }

    default int getWindowLayerFromTypeLw(int type) {
        if (WindowManager.LayoutParams.isSystemAlertWindowType(type) == true) goto L7;
        return getWindowLayerFromTypeLw(type, false);
    L7:
        throw new IllegalArgumentException("Use getWindowLayerFromTypeLw() or getWindowLayerLw() for alert window types");
    }

    default int getWindowLayerFromTypeLw(int type, boolean canAddInternalSystemWindow) {
        return getWindowLayerFromTypeLw(type, canAddInternalSystemWindow, false);
    }

    default int getWindowLayerFromTypeLw(int type, boolean canAddInternalSystemWindow, boolean roundedCornerOverlay) {
        if (roundedCornerOverlay == false) goto L7;
        if (canAddInternalSystemWindow == false) goto L7;
        return getMaxWindowLayer();
    L7:
        if (type >= 1) goto L9;
    L12:
        int layer = IExtWindowManagerPolicy.getWindowLayerFromTypeLw(type, canAddInternalSystemWindow);
        if (layer == (-1)) goto L16;
        return layer;
    L16:
        switch(type) {
            case 2000: goto L83;
            case 2001: goto L81;
            case 2002: goto L80;
            case 2003: goto L77;
            case 2004: goto L17;
            case 2005: goto L75;
            case 2006: goto L71;
            case 2007: goto L69;
            case 2008: goto L67;
            case 2009: goto L65;
            case 2010: goto L62;
            case 2011: goto L60;
            case 2012: goto L58;
            case 2013: goto L57;
            case 2014: goto L17;
            case 2015: goto L55;
            case 2016: goto L53;
            case 2017: goto L51;
            case 2018: goto L49;
            case 2019: goto L47;
            case 2020: goto L45;
            case 2021: goto L43;
            case 2022: goto L41;
            case 2023: goto L17;
            case 2024: goto L39;
            case 2025: goto L17;
            case 2026: goto L37;
            case 2027: goto L35;
            case 2028: goto L17;
            case 2029: goto L17;
            case 2030: goto L80;
            case 2031: goto L33;
            case 2032: goto L31;
            case 2033: goto L29;
            case 2034: goto L80;
            case 2035: goto L80;
            case 2036: goto L27;
            case 2037: goto L80;
            case 2038: goto L25;
            case 2039: goto L23;
            case 2040: goto L21;
            case 2041: goto L19;
            default: goto L17;
        };
    L17:
        Slog.e("WindowManager", "Unknown window type: " + type);
        return 3;
    L19:
        return 16;
    L21:
        return 17;
    L23:
        return 32;
    L25:
        return 11;
    L27:
        return 26;
    L29:
        return 20;
    L31:
        return 31;
    L33:
        return 21;
    L35:
        return 28;
    L37:
        return 29;
    L39:
        return 25;
    L41:
        return 5;
    L43:
        return 34;
    L45:
        return 22;
    L47:
        return 24;
    L49:
        return 35;
    L51:
        return 18;
    L53:
        return 30;
    L55:
        return 33;
    L57:
        return 1;
    L58:
        return 14;
    L60:
        return 13;
    L62:
        if (canAddInternalSystemWindow == false) goto L85;
        return 27;
    L85:
        return 9;
    L65:
        return 19;
    L67:
        return 6;
    L69:
        return 8;
    L71:
        if (canAddInternalSystemWindow == false) goto L73;
        return 23;
    L73:
        return 10;
    L75:
        return 7;
    L77:
        if (canAddInternalSystemWindow == false) goto L87;
        return 12;
    L87:
        return 9;
    L80:
        return 3;
    L81:
        return 4;
    L83:
        return 15;
    L9:
        if (type > 99) goto L12;
        return 2;
    }

    default int getMaxWindowLayer() {
        return 36;
    }

    default int getSubWindowLayerFromTypeLw(int type) {
        switch(type) {
            case 1000: goto L13;
            case 1001: goto L11;
            case 1002: goto L9;
            case 1003: goto L13;
            case 1004: goto L7;
            case 1005: goto L5;
            default: goto L3;
        };
    L3:
        Slog.e("WindowManager", "Unknown sub-window type: " + type);
        return 0;
    L5:
        return 3;
    L7:
        return -1;
    L9:
        return 2;
    L11:
        return -2;
    L13:
        return 1;
    }

    default void setDismissImeOnBackKeyPressed(boolean newValue) {
    }

    static String userRotationModeToString(int mode) {
        switch(mode) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L5:
        return "USER_ROTATION_LOCKED";
    L7:
        return "USER_ROTATION_FREE";
    L4:
        return Integer.toString(mode);
    }

    default void registerDisplayFoldListener(IDisplayFoldListener listener) {
    }

    default void unregisterDisplayFoldListener(IDisplayFoldListener listener) {
    }

    default void setOverrideFoldedArea(Rect area) {
    }

    default Rect getFoldedArea() {
        return new Rect();
    }

    default void onDefaultDisplayFocusChangedLw(WindowState newFocus) {
    }

    default IObricPhoneWindowManager getObricExt() {
        return null;
    }
}
