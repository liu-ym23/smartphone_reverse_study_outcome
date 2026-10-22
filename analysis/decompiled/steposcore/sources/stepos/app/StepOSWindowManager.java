package stepos.app;

import android.app.ActivityManager;
import android.app.PreloadManager;
import android.app.ResultInfo;
import android.app.WindowConfiguration;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.display.StepOSDisplayManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.StepOSDateTimeUrlHelper;
import android.view.IWindow;
import android.view.MotionEvent;
import android.view.SurfaceControl;
import android.view.WindowInsets;
import android.window.ScreenCapture;
import android.window.TaskSnapshot;
import com.android.internal.view.AppearanceRegion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import stepos.app.IAppEventListener;
import stepos.app.IStepOSWindowManager;
import stepos.config.StepOSFeature;
import stepos.uicontroller.IUIController;
import stepos.view.IDisplayUIListener;
import stepos.view.IRecentsTransitionInputCallback;
import stepos.view.IWindowModeCallback;
import stepos.view.uicontroller.IUIControllerUpdateListener;

/* loaded from: classes.dex */
public class StepOSWindowManager {
    public static final int FINISH_TASK_WITH_KEYGUARD = 10;
    private static final long IMPORTANCE_UX_HINT_INTERVAL = 200;
    public static final String KEY_SCREENSHOT_RESULT_BITMAP = "android.view.screenshot.result_bitmap";
    public static final String KEY_SCREENSHOT_RESULT_CODE = "android.view.screenshot.result_code";
    public static final String KEY_SCREENSHOT_RESULT_MESSAGE = "android.view.screenshot.result_message";
    public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_UNDEFINED = -1;
    public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_UNSET = -2;
    public static final int SCREENSHOT_RESULT_ERROR_CAPTURE_FAILED = 3;
    public static final int SCREENSHOT_RESULT_ERROR_SECURE = 2;
    public static final int SCREENSHOT_RESULT_ERROR_UNKNOWN = 1;
    public static final int SCREENSHOT_RESULT_ERROR_UNSUPPORTED = 4;
    public static final int SCREENSHOT_RESULT_SUCCESS = 0;
    public static final int STEPOS_FEATURE_ALLOW_ACCESSIBILITY = 22;
    public static final int STEPOS_FEATURE_APP_ACCESS = 12;
    public static final int STEPOS_FEATURE_APP_EVENTS = 45;
    public static final int STEPOS_FEATURE_APP_FULLSCREEN = 11;
    public static final int STEPOS_FEATURE_APP_SECURE = 13;
    public static final int STEPOS_FEATURE_ASSURANCE_SECURITY = 23;
    public static final int STEPOS_FEATURE_BLACK_SCREEN_OVERLAY = 39;
    public static final int STEPOS_FEATURE_CLEAR_COMPAT_MODE_DISPLAY_SIZE_CHANGED = 36;
    public static final int STEPOS_FEATURE_CLEAR_COMPAT_MODE_MOVE_FROM_OTHER_DISPLAY = 35;
    public static final int STEPOS_FEATURE_CLEAR_COMPAT_MODE_MOVE_TO_OTHER_DISPLAY = 34;
    public static final int STEPOS_FEATURE_CONTINUE_DISPLAY_ID = 25;
    public static final int STEPOS_FEATURE_CUSTOM_HOME = 20;
    public static final int STEPOS_FEATURE_DISABLE_HOME_START = 27;
    public static final int STEPOS_FEATURE_DISABLE_MULTI_WINDOW = 28;
    public static final int STEPOS_FEATURE_DISABLE_ORIENTATION_EVENT = 26;
    public static final int STEPOS_FEATURE_DISABLE_WALLPAPER = 30;
    public static final int STEPOS_FEATURE_DISPLAY_AMIN = 17;
    public static final int STEPOS_FEATURE_FORCE_INPUT = 21;
    public static final int STEPOS_FEATURE_FREEFORM_WINDOW = 7;
    public static final int STEPOS_FEATURE_GAME_MODE = 15;
    public static final int STEPOS_FEATURE_INPUT_METHOD_QS = 16;
    public static final int STEPOS_FEATURE_INTERCEPT_BROADCAST = 31;
    public static final int STEPOS_FEATURE_INTERCEPT_FONT_ACTIVITY_START_TO_VIRTUAL_DISPLAY = 32;
    public static final int STEPOS_FEATURE_INTERCEPT_INTENT = 48;
    public static final int STEPOS_FEATURE_INTERCEPT_MAIN_ACTIVITY_START_TO_OTHER_DISPLAY = 33;
    public static final int STEPOS_FEATURE_INTERCEPT_WINDOW = 10;
    public static final int STEPOS_FEATURE_LIVE_WALLPAPER = 14;
    public static final int STEPOS_FEATURE_LOCK_ROTATION = 41;
    public static final int STEPOS_FEATURE_MAGIC_WINDOW = 4;
    public static final int STEPOS_FEATURE_MINI_WINDOW = 1;
    public static final int STEPOS_FEATURE_NEED_SYSUI_VIRTUAL_EDGE_BACK = 43;
    public static final int STEPOS_FEATURE_NOT_RELAUNCH_TO_CURRENT_DISPLAY = 38;
    public static final int STEPOS_FEATURE_NOT_RELAUNCH_TO_OTHER_DISPLAY = 37;
    public static final int STEPOS_FEATURE_NOT_REMOVE_ON_DESTROY = 24;
    public static final int STEPOS_FEATURE_PIN_WINDOW = 2;
    public static final int STEPOS_FEATURE_PRELOAD_WINDOW = 5;
    public static final int STEPOS_FEATURE_PROCESS_AUDIO = 44;
    public static final int STEPOS_FEATURE_RECENTS_TRANSITION = 47;
    public static final int STEPOS_FEATURE_SPACE_MODE = 6;
    public static final int STEPOS_FEATURE_SWITCH_TASK_TO_DISPLAY = 29;
    public static final int STEPOS_FEATURE_SYSUI_ACCESS_UID = 42;
    public static final int STEPOS_FEATURE_WATERMARK = 46;
    public static final int STEPOS_FEATURE_WELT_WINDOW = 3;
    public static final int STEPOS_FEATURE_WINDOW_UI_CONTROL = 40;
    public static final int STEPOS_FREEFORM_WINDOW = 1035;
    public static final int STEPOS_MAGIC_WINDOW = 13;
    public static final int STEPOS_MINI_WINDOW = 11;
    public static final int STEPOS_PINNED_WINDOW = 12;
    public static final int STEPOS_PRELOAD_WINDOW = 524;
    public static final String STEPOS_PROP_WM_MONKEY = "debug.wm.monkey";
    public static final boolean STEPOS_RECENTS_MERGE_ANIMATION;
    public static final int STEPOS_WELT_WINDOW = 268;
    private static final String TAG = "StepOSWindowManager";
    public static final int VERSION_CODE = 9001;
    public static final String WINDOW_EXT_SERVICE = "window_ext";
    public static final int WINDOW_SUB_TYPE_DEFAULT = 0;
    public static final int WINDOW_SUB_TYPE_FREEFORM = 4;
    public static final int WINDOW_SUB_TYPE_PRELOAD = 2;
    public static final int WINDOW_SUB_TYPE_WELT = 1;
    private static volatile IStepOSWindowManager mService;
    public static boolean sDisableStartingWindow;
    private static StepOSWindowManager sInstance;
    private static volatile SystemProperties.Handle sMonkeyPropHandle;
    private final AppEventCallBack mAECB;
    private final SparseArray<DisplayUICallback> mDUICBs = new SparseArray<>();
    private final SparseArray<UIControllerUpdateCallback> mUIControllerCallbacks = new SparseArray<>();
    private final SparseArray<WindowModeCallback> mWMCbs;
    public static final float[] ENABLE_APP_ASPECT_RATIO_LIST = {0.33125f, 0.5f, 0.66875f};
    public static final float[] DISABLE_APP_ASPECT_RATIO_LIST = {0.33125f};

    public @interface Feature {
    }

    public interface UIControllerUpdateListener {
        void onTopWindowUIControllerChanged(int i, IUIController iUIController, ActivityManager.RunningTaskInfo runningTaskInfo);
    }

    public @interface WINDOW_SUB_TYPE {
    }

    public static boolean isMonkeyRunning() {
        SystemProperties.Handle handle = sMonkeyPropHandle;
        if (handle == null) {
            handle = SystemProperties.find(STEPOS_PROP_WM_MONKEY);
            if (handle == null) {
                return false;
            }
            sMonkeyPropHandle = handle;
        }
        return handle.getBoolean(false);
    }

    static {
        boolean z = true;
        if (!StepOSFeature.STEPOS_RECENTS_MERGE_ANIMATION && !SystemProperties.getBoolean("persist.wm.debug.stepos_recents_merge_animation", false)) {
            z = false;
        }
        STEPOS_RECENTS_MERGE_ANIMATION = z;
        sDisableStartingWindow = false;
    }

    public static int getVirtualWindowingMode(int windowingMode, int windowSubtype) {
        return (windowSubtype << 8) + windowingMode;
    }

    public static int getWindowingMode(int virtualWindowingMode) {
        return virtualWindowingMode & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
    }

    public static int getWindowSubtype(int virtualWindowingMode) {
        return (65280 & virtualWindowingMode) >> 8;
    }

    public static boolean isValidWindowSubtype(int windowSubtype) {
        switch (windowSubtype) {
            case 0:
            case 1:
            case 2:
            case 4:
                return true;
            case 3:
            default:
                return false;
        }
    }

    public static String windowSubtypeToString(int windowSubtype, String prefix) {
        switch (windowSubtype) {
            case 0:
                return "";
            case 1:
                return prefix + "welt";
            case 2:
                return prefix + PreloadManager.SERVICE_NAME;
            case 3:
            default:
                return prefix + windowSubtype;
            case 4:
                return prefix + "freeform";
        }
    }

    public static String windowSubtypeToString(int windowSubtype) {
        switch (windowSubtype) {
            case 0:
                return "";
            case 1:
                return "welt";
            case 2:
                return PreloadManager.SERVICE_NAME;
            case 3:
            default:
                return String.valueOf(windowSubtype);
            case 4:
                return "freeform";
        }
    }

    public static String windowModeToString(int virtualWindowingMode) {
        int windowingMode = getWindowingMode(virtualWindowingMode);
        int windowSubType = getWindowSubtype(virtualWindowingMode);
        return windowModeToString(windowingMode, windowSubType);
    }

    public static String windowModeToString(int windowingMode, int windowSubType) {
        return WindowConfiguration.windowingModeToString(windowingMode) + windowSubtypeToString(windowSubType, StepOSDateTimeUrlHelper.COLON_STRING);
    }

    public interface DisplayUIListener {
        default void onTaskWillBackStateChange(int displayId, int taskId, boolean willBack) {
        }

        default void onDisplayEmpty(int displayId) {
        }

        default void onTopActivityChanged(ComponentName topActivity, int uid) {
        }

        default void onSystemBarVisibleChanged(int displayId, boolean isImmersive, boolean isStatusBarVisible, boolean isNavBarVisible, String packageName) {
        }

        @Deprecated
        default void onSystemBarAttributesChanged(int displayId, int appearance, AppearanceRegion[] appearanceRegions, boolean navbarColorManagedByIme, int behavior, int requestedVisibleTypes, String packageName) {
        }

        default void onDisplayStartAsyncRotation(int displayId, int oldRotation, int newRotation) {
        }

        default void onDisplayFinishAsyncRotation(int displayId) {
        }

        default void onVisibleSecureWindowState(int displayId, boolean hasVisibleSecureWindow) {
        }

        default void onDisplayWatchIntentReceived(int displayId, String packageName, Intent activityIntent) {
        }
    }

    public interface AppEventListener {
        public static final int FLAG_EVENT_ACTIVITY = 1;
        public static final int FLAG_EVENT_ALL = 65535;
        public static final int FLAG_EVENT_PROCESS = 2;
        public static final int FLAG_EVENT_WINDOW = 3;

        default void onActivityStateChange(String packageName, String className, Bundle data) {
        }

        default void onProcessStateChange(String packageName, String processName, Bundle data) {
        }

        default void onWindowRequestedVisibleTypesChanged(String packageName, String className, Bundle data) {
        }
    }

    public boolean isFeatureOpen(int displayId, int feature) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.isFeatureOpen(displayId, 0, null, feature);
        } catch (RemoteException e) {
            Slog.e(TAG, "isFeatureOpen failed", e);
            return false;
        }
    }

    public boolean isFeatureOpen(int uid, String displayName, int feature) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.isFeatureOpen(-1, uid, displayName, feature);
        } catch (RemoteException e) {
            Slog.e(TAG, "isFeatureOpen failed", e);
            return false;
        }
    }

    public void setFeatureOpen(int displayId, int feature, boolean open) {
        setFeatureOpen(displayId, new int[]{feature}, open);
    }

    public void setFeatureOpen(int displayId, int[] features, boolean open) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setFeatureOpen(displayId, 0, null, features, open);
        } catch (RemoteException e) {
            Slog.e(TAG, "setFeatureOpen failed", e);
        }
    }

    public void setFeatureOpen(String displayName, int feature, boolean open) {
        setFeatureOpen(0, displayName, new int[]{feature}, open);
    }

    public void setFeatureOpen(int uid, String displayName, int feature, boolean open) {
        setFeatureOpen(uid, displayName, new int[]{feature}, open);
    }

    public void setFeatureOpen(String displayName, int[] features, boolean open) {
        setFeatureOpen(0, displayName, features, open);
    }

    public void setFeatureOpen(int uid, String displayName, int[] features, boolean open) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setFeatureOpen(-1, uid, displayName, features, open);
        } catch (RemoteException e) {
            Slog.e(TAG, "setFeatureOpen failed", e);
        }
    }

    public void setDisplayTaskAnimation(int uid, String displayName, String packageName, int exitResId, int enterResId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setDisplayTaskAnimation(-1, uid, displayName, packageName, exitResId, enterResId);
        } catch (RemoteException e) {
            Slog.e(TAG, "setDisplayTaskAnimation failed", e);
        }
    }

    public void setDisplayTaskAnimation(int displayId, String packageName, int exitResId, int enterResId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setDisplayTaskAnimation(displayId, 0, null, packageName, exitResId, enterResId);
        } catch (RemoteException e) {
            Slog.e(TAG, "setDisplayTaskAnimation failed", e);
        }
    }

    public void setDisplayFocusable(int displayId, boolean focusable) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setDisplayFocusable(displayId, focusable, focusable);
        } catch (RemoteException e) {
            Slog.e(TAG, "setDisplayFocusable failed", e);
        }
    }

    public void setDisplayFocusable(int displayId, boolean focusable, boolean requestFocus) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setDisplayFocusable(displayId, focusable, requestFocus);
        } catch (RemoteException e) {
            Slog.e(TAG, "setDisplayFocusable failed", e);
        }
    }

    public void registerAppEventsListener(AppEventListener listener) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            synchronized (this.mAECB) {
                if (this.mAECB.addListener(listener) == 1) {
                    service.registerAppEventsListener(this.mAECB, 65535);
                }
            }
        } catch (RemoteException e) {
            Slog.e(TAG, "registerAppEventsListener failed", e);
        }
    }

    public void unRegisterAppEventsListener(AppEventListener listener) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            synchronized (this.mAECB) {
                if (this.mAECB.removeListener(listener) == 0) {
                    service.unRegisterAppEventsListener(this.mAECB);
                }
            }
        } catch (RemoteException e) {
            Slog.e(TAG, "unRegisterAppEventsListener failed", e);
        }
    }

    public void registerDisplayUIListener(int displayId, DisplayUIListener listener) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            synchronized (this.mDUICBs) {
                DisplayUICallback displayUICallback = this.mDUICBs.get(displayId);
                if (displayUICallback == null) {
                    displayUICallback = new DisplayUICallback();
                    this.mDUICBs.put(displayId, displayUICallback);
                }
                if (displayUICallback.addListener(listener) == 1) {
                    service.registerDisplayUIListener(displayId, displayUICallback);
                }
            }
        } catch (RemoteException e) {
            Slog.e(TAG, "registerDisplayUIListener failed", e);
        }
    }

    public void unregisterDisplayUIListener(int displayId, DisplayUIListener listener) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            synchronized (this.mDUICBs) {
                DisplayUICallback displayUICallback = this.mDUICBs.get(displayId);
                if (displayUICallback != null && displayUICallback.removeListener(listener) == 0) {
                    service.unregisterDisplayUIListener(displayId, displayUICallback);
                }
            }
        } catch (RemoteException e) {
            Slog.e(TAG, "unregisterDisplayUIListener failed", e);
        }
    }

    public void registerUIControllerUpdateListener(int displayId, UIControllerUpdateListener listener) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            synchronized (this.mUIControllerCallbacks) {
                UIControllerUpdateCallback uiControllerCallback = this.mUIControllerCallbacks.get(displayId);
                if (uiControllerCallback == null) {
                    uiControllerCallback = new UIControllerUpdateCallback();
                    this.mUIControllerCallbacks.put(displayId, uiControllerCallback);
                }
                if (uiControllerCallback.addListener(listener) == 1) {
                    service.registerUIControllerUpdateListener(displayId, uiControllerCallback);
                }
            }
        } catch (RemoteException e) {
            Slog.e(TAG, "registerUIControllerUpdateListener failed", e);
        }
    }

    public void unregisterUIControllerUpdateListener(int displayId, UIControllerUpdateListener listener) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            synchronized (this.mUIControllerCallbacks) {
                UIControllerUpdateCallback uiControllerCallback = this.mUIControllerCallbacks.get(displayId);
                if (uiControllerCallback != null && uiControllerCallback.removeListener(listener) == 0) {
                    service.unregisterUIControllerUpdateListener(displayId, uiControllerCallback);
                }
            }
        } catch (RemoteException e) {
            Slog.e(TAG, "unregisterUIControllerUpdateListener failed", e);
        }
    }

    public void setStartPackageInDisplay(int displayId, String packageName, int delaySecond) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setStartPackageInDisplay(displayId, packageName, delaySecond);
        } catch (RemoteException e) {
            Slog.e(TAG, "setStartPackageInDisplay failed", e);
        }
    }

    public void moveTaskToBackInDisplay(int taskId, int oldDisplayId, int newDisplayId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.moveTaskToBackInDisplay(taskId, oldDisplayId, newDisplayId);
        } catch (RemoteException e) {
            Slog.e(TAG, "moveTaskToBackInDisplay failed", e);
        }
    }

    public void moveTopTaskToFrontInDisplay(int displayId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.moveTopTaskToFrontInDisplay(displayId);
        } catch (RemoteException e) {
            Slog.e(TAG, "moveTopTaskToFrontInDisplay failed", e);
        }
    }

    public void setDisplayBackgroundColor(int displayId, int color) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setDisplayBackgroundColor(displayId, color);
        } catch (RemoteException e) {
            Slog.e(TAG, "setDisplayBackgroundColor failed", e);
        }
    }

    public boolean acquireWakeLockForDisplay(int displayId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.acquireWakeLockForDisplay(displayId);
        } catch (RemoteException e) {
            Slog.e(TAG, "acquireWakeLockForDisplay failed", e);
            return false;
        }
    }

    public void releaseWakeLockForDisplay(int displayId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.releaseWakeLockForDisplay(displayId);
        } catch (RemoteException e) {
            Slog.e(TAG, "releaseWakeLockForDisplay failed", e);
        }
    }

    public interface WindowModeListener {
        public static final int ANIMATION_TYPE_WINDOWMODE_SYNC = 1;
        public static final int WINDOWMODE_STATE_DISMISS_BOTTOM = 32;
        public static final int WINDOWMODE_STATE_DISMISS_TOP = 16;
        public static final int WINDOWMODE_STATE_HIDE_MODE = 2;
        public static final int WINDOWMODE_STATE_MASK = 65535;
        public static final int WINDOWMODE_STATE_MAX_MODE = 8;
        public static final int WINDOWMODE_STATE_MINIMIZE_MODE = 4;
        public static final int WINDOWMODE_STATE_SHOW_MENU = 1;

        default void onStackWindowModeChanged(boolean windowMode, Bundle data) {
        }

        default void onWindowModeChanged(int windowingMode, boolean isWindowMode) {
        }

        default void onPackageNameChanged(int windowingMode, String packageName, int uid, int pid, boolean topStack) {
        }

        default void onWindowModeBoundChanged(int windowingMode, Rect displayBound, int displayRotation) {
        }

        default void onWindowModeStateChanged(int windowingMode, int windowModeState) {
        }

        default void onWindowModeFlingToTarget(int windowingMode, Rect fromBound, Rect toBound) {
        }

        default void onImeVisibilityChanged(boolean imeVisible, int imeHeight) {
        }

        default void onStackChanged(int displayId, int windowingMode, int taskId, boolean isWindowMode, boolean topStack) {
        }

        default void onTopActivityChanged(int displayId, int windowingMode, int taskId, String packageName, String className, int uid, int pid) {
        }

        default void onBoundChanged(int displayId, int windowingMode, int taskId, Rect fromBound, Rect toBound, int rotation) {
        }

        default void onStateChanged(int displayId, int windowingMode, int taskId, int windowModeState) {
        }

        default void onImeVisibilityChanged(int displayId, int windowingMode, int taskId, boolean imeVisible, int imeHeight) {
        }

        default void onShellTransitionReady(int displayId, int animationType, int syncId) {
        }

        default void onShellTransitionFinished(int displayId, int animationType, int syncId) {
        }

        default void onWindowModeChangeAnimationFinished(int taskId) {
        }

        default void onPreferredWindowModeChanged(int taskId, int currentWindowMode, int preferredWindowMode) {
        }

        default void onCaptionMenuDismiss(int displayId, int windowingMode, int taskId) {
        }

        default void onWindowModeListsChanged() {
        }
    }

    public static StepOSWindowManager getInstance() {
        StepOSWindowManager stepOSWindowManager;
        synchronized (StepOSWindowManager.class) {
            if (sInstance == null) {
                sInstance = new StepOSWindowManager();
            }
            stepOSWindowManager = sInstance;
        }
        return stepOSWindowManager;
    }

    public boolean isInputMethodQsEnable(int displayId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.isInputMethodQsEnable(displayId);
        } catch (RemoteException e) {
            Slog.e(TAG, "isInputMethodQsEnable failed", e);
            return false;
        }
    }

    private StepOSWindowManager() {
        IBinder b = ServiceManager.getService("window_ext");
        mService = IStepOSWindowManager.Stub.asInterface(b);
        this.mWMCbs = new SparseArray<>();
        this.mAECB = new AppEventCallBack();
    }

    public IStepOSWindowManager getService() {
        if (mService == null) {
            IBinder b = ServiceManager.getService("window_ext");
            mService = IStepOSWindowManager.Stub.asInterface(b);
        }
        return mService;
    }

    private WindowModeCallback getOrCreateCallback(int displayId, int windowingMode, boolean create) {
        WindowModeCallback callback = this.mWMCbs.get((displayId << 8) + windowingMode);
        if (callback == null && create) {
            WindowModeCallback callback2 = new WindowModeCallback(displayId, windowingMode);
            this.mWMCbs.put((displayId << 8) + windowingMode, callback2);
            return callback2;
        }
        return callback;
    }

    public void registerWindowModeListener(WindowModeListener listener) {
        registerWindowModeListener(11, listener);
    }

    public void registerWindowModeListener(int windowingMode, WindowModeListener listener) {
        registerWindowModeListener(0, windowingMode, listener);
    }

    public void unregisterWindowModeListener(WindowModeListener listener) {
        unregisterWindowModeListener(11, listener);
    }

    public void unregisterWindowModeListener(int windowingMode, WindowModeListener listener) {
        unregisterWindowModeListener(0, windowingMode, listener);
    }

    public Rect getWindowModeBound() {
        return getWindowModeBound(11);
    }

    public Rect getWindowModeBound(int windowingMode) {
        return getWindowModeBound(0, 0, windowingMode);
    }

    public boolean isWindowMode(IBinder token) {
        return isWindowMode(11, token);
    }

    public boolean isWindowMode(int windowingMode, IBinder token) {
        return isWindowMode(0, 0, windowingMode, token);
    }

    public Point covertWindowModeCoordinate(Point point) {
        return covertWindowModeCoordinate(11, point);
    }

    public Point covertWindowModeCoordinate(int windowingMode, Point point) {
        return covertWindowModeCoordinate(0, 0, windowingMode, point);
    }

    public void updateWindowModeShowState(boolean show) {
        updateWindowModeShowState(11, show);
    }

    public void updateWindowModeShowState(int windowingMode, boolean show, boolean nextChange) {
        updateWindowModeShowState(0, 0, windowingMode, show, nextChange);
    }

    public void updateWindowModeShowState(int windowingMode, boolean show) {
        updateWindowModeShowState(windowingMode, show, false);
    }

    public void closeWindowMode(boolean anim) {
        closeWindowMode(11, anim);
    }

    public void closeWindowMode(int windowingMode, boolean anim) {
        closeWindowMode(0, 0, windowingMode, anim);
    }

    public void enterWindowMode(int taskId, int oldWindowingMode, int newWindowingMode, Rect showFrame) {
        enterWindowMode(taskId, oldWindowingMode, newWindowingMode, showFrame, -1.0f);
    }

    public void enterWindowMode(int taskId, int oldWindowingMode, int newWindowingMode, Rect showFrame, float cornerRadius) {
        enterWindowMode(0, taskId, oldWindowingMode, newWindowingMode, showFrame, cornerRadius, true);
    }

    public void enterWindowMode(int taskId, int oldWindowingMode, int newWindowingMode, Rect showFrame, float cornerRadius, boolean anim) {
        enterWindowMode(0, taskId, oldWindowingMode, newWindowingMode, showFrame, cornerRadius, anim);
    }

    public void moveWindowModeBound(int windowingMode, Rect showFrame, boolean anim) {
        moveWindowModeBound(0, 0, windowingMode, showFrame, null, anim);
    }

    public void moveWindowModeBound(int windowingMode, Rect showFrame, float[] float9, boolean anim) {
        moveWindowModeBound(0, 0, windowingMode, showFrame, float9, anim);
    }

    public void moveWindowModeBound(int displayId, int taskId, int windowingMode, Rect showFrame, float[] matrix1, boolean anim) {
        moveWindowModeBound(displayId, taskId, windowingMode, showFrame, matrix1, matrix1, anim);
    }

    public void switchWindowModeToMaxMode(int windowingMode, boolean maxMode) {
        switchWindowModeToMaxMode(0, 0, windowingMode, maxMode);
    }

    public void exitWindowModeToFullscreen(boolean anim) {
        exitWindowModeToFullscreen(11, anim);
    }

    public void exitWindowModeToFullscreen(int windowingMode, boolean anim) {
        enterWindowMode(0, windowingMode, 1, null, 0.0f, anim);
    }

    public void flingWindowMode(float velocityX, float velocityY, Point startPosition) {
        flingWindowMode(12, velocityX, velocityY, startPosition);
    }

    public void flingWindowMode(int windowingMode, float velocityX, float velocityY, Point startPosition) {
        flingWindowMode(0, 0, windowingMode, velocityX, velocityY, startPosition);
    }

    public void setWindowModeAvoidZone(int windowingMode, String packageName, Rect avoidZone) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setAvoidZone(0, windowingMode, packageName, avoidZone);
        } catch (RemoteException e) {
            Slog.e(TAG, "setWindowModeAvoidZone failed", e);
        }
    }

    public void setAppMuted(String packageName, int uid, boolean muted) {
        setAppMuted(0, packageName, uid, muted);
    }

    public boolean isAppMuted(String packageName, int uid) {
        return isAppMuted(0, packageName, uid);
    }

    public void setStartWindowMode(String packageName) {
        setStartWindowMode(0, packageName, 10);
    }

    public void setStartWindowMode(String packageName, boolean enable) {
        setStartWindowMode(0, packageName, enable ? 10 : -1);
    }

    public void setStartWindowMode(String packageName, int delaySecond) {
        setStartWindowMode(0, packageName, delaySecond);
    }

    public void getWindowModeTouchOffset(IWindow window, float[] values) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.getWindowModeTouchOffset(window, values);
        } catch (RemoteException e) {
            Slog.e(TAG, "getWindowModeTouchOffset failed", e);
        }
    }

    public void sendResultToActivity(ActivityInfo info, ResultInfo result) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.sendResultToActivity(info, result);
        } catch (RemoteException e) {
            Slog.e(TAG, "sendResultToActivity failed", e);
        }
    }

    public boolean removeTaskNotKillProcess(int taskId) {
        return removeTaskNotKillProcess(0, taskId);
    }

    public void setTaskDeferResume(int taskId, boolean deferResume, String reason) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setTaskDeferResume(taskId, deferResume, reason);
        } catch (RemoteException e) {
            Slog.e(TAG, "setTaskDeferResume failed", e);
        }
    }

    public void setLockOrientationForSensor(boolean lock) {
        setLockOrientationForSensor(0, lock);
    }

    public boolean isLockOrientationForSensor() {
        return isLockOrientationForSensor(0);
    }

    public void registerWindowModeListener(int displayId, int windowingMode, WindowModeListener listener) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            synchronized (this.mWMCbs) {
                WindowModeCallback callback = getOrCreateCallback(displayId, windowingMode, true);
                callback.addListener(listener);
                if (callback.size() == 1) {
                    service.registerWindowModeListener(displayId, windowingMode, callback);
                }
            }
        } catch (RemoteException e) {
            Slog.e(TAG, "registerWindowModeListener failed", e);
        }
    }

    public void unregisterWindowModeListener(int displayId, int windowingMode, WindowModeListener listener) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            synchronized (this.mWMCbs) {
                WindowModeCallback callback = getOrCreateCallback(displayId, windowingMode, false);
                if (callback != null) {
                    callback.removeListener(listener);
                    if (callback.size() == 0) {
                        service.unregisterWindowModeListener(displayId, windowingMode, callback);
                    }
                }
            }
        } catch (RemoteException e) {
            Slog.e(TAG, "unregisterWindowModeListener failed", e);
        }
    }

    public Rect getWindowModeBound(int displayId, int taskId, int windowingMode) {
        return getWindowModeBound(displayId, taskId, windowingMode, false, -1);
    }

    public Rect getWindowModeBound(int displayId, int taskId, int windowingMode, boolean pending, int displayRotation) {
        return getWindowModeBound(displayId, taskId, windowingMode, pending, displayRotation, false);
    }

    public Rect getWindowModeBound(int displayId, int taskId, int windowingMode, boolean baseBound) {
        return getWindowModeBound(displayId, taskId, windowingMode, false, -1, baseBound);
    }

    public Rect getWindowModeBound(int displayId, int taskId, int windowingMode, boolean pending, int displayRotation, boolean baseBound) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return null;
        }
        try {
            return service.getWindowModeBound(displayId, taskId, windowingMode, pending, displayRotation, baseBound);
        } catch (RemoteException e) {
            Slog.e(TAG, "getWindowModeBound failed", e);
            return null;
        }
    }

    public void moveWindowModeBound(int displayId, int taskId, int windowingMode, Rect showFrame, float[] matrix1, float[] matrix2, boolean anim) {
        moveWindowModeBound(displayId, taskId, windowingMode, showFrame, matrix1, matrix2, anim, true);
    }

    public void moveWindowModeBound(int displayId, int taskId, int windowingMode, Rect showFrame, float[] matrix1, float[] matrix2, boolean anim, boolean canShowStrokeLayer) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.moveWindowModeBound(displayId, taskId, windowingMode, showFrame, matrix1, matrix2, anim, canShowStrokeLayer);
        } catch (RemoteException e) {
            Slog.e(TAG, "moveWindowModeBound failed", e);
        }
    }

    public Point covertWindowModeCoordinate(int displayId, int taskId, int windowingMode, Point point) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return null;
        }
        try {
            return service.covertWindowModeCoordinate(displayId, taskId, windowingMode, point);
        } catch (RemoteException e) {
            Slog.e(TAG, "covertWindowModeCoordinate failed", e);
            return null;
        }
    }

    public boolean isWindowMode(int displayId, int taskId, int windowingMode, IBinder token) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.isWindowMode(displayId, taskId, windowingMode, token);
        } catch (RemoteException e) {
            Slog.e(TAG, "isWindowMode failed", e);
            return false;
        }
    }

    public boolean isClipSystemBarByWindowMode(int displayId, int taskId, int systemBarType) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.isClipSystemBarByWindowMode(displayId, taskId, systemBarType);
        } catch (RemoteException e) {
            Slog.e(TAG, "isClipSystemBarByWindowMode failed", e);
            return false;
        }
    }

    public boolean needWindowModeCaptionBackground(int displayId, int taskId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.needWindowModeCaptionBackground(displayId, taskId);
        } catch (RemoteException e) {
            Slog.e(TAG, "needWindowModeCaptionBackground failed", e);
            return false;
        }
    }

    public int getVirtualWindowingMode(IBinder token) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return 0;
        }
        try {
            return service.getVirtualWindowingMode(token);
        } catch (RemoteException e) {
            Slog.d(TAG, "getVirtualWindowingMode fail ", e);
            return 0;
        }
    }

    public int getVirtualWindowingModeByTask(int displayId, int taskId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return 0;
        }
        try {
            return service.getVirtualWindowingModeByTask(displayId, taskId);
        } catch (RemoteException e) {
            Slog.e(TAG, "getVirtualWindowingModeByTask failed", e);
            return 0;
        }
    }

    public void updateWindowModeShowState(int displayId, int taskId, int windowingMode, boolean show, boolean nextChange) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.updateWindowModeShowState(displayId, taskId, windowingMode, show, nextChange);
        } catch (RemoteException e) {
            Slog.e(TAG, "updateWindowModeShowState failed", e);
        }
    }

    public void closeWindowMode(int displayId, int taskId, int windowingMode, boolean anim) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.closeWindowMode(displayId, taskId, windowingMode, anim);
        } catch (RemoteException e) {
            Slog.e(TAG, "closeWindowMode failed", e);
        }
    }

    public void enterWindowMode(int displayId, int taskId, int oldWindowingMode, int newWindowingMode, Rect showBound, float cornerRadius, boolean anim) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.enterWindowMode(displayId, taskId, oldWindowingMode, newWindowingMode, showBound, cornerRadius, anim);
        } catch (RemoteException e) {
            Slog.e(TAG, "enterWindowMode failed", e);
        }
    }

    public void switchWindowModeToMaxMode(int displayId, int taskId, int windowingMode, boolean maxMode) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.switchWindowModeToMaxMode(displayId, taskId, windowingMode, maxMode);
        } catch (RemoteException e) {
            Slog.e(TAG, "switchWindowModeToMaxMode failed", e);
        }
    }

    public boolean flingWindowMode(int displayId, int taskId, int windowingMode, float velocityX, float velocityY, Point startPosition) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.flingWindowMode(displayId, taskId, windowingMode, velocityX, velocityY, startPosition);
        } catch (RemoteException e) {
            Slog.e(TAG, "flingWindowMode failed", e);
            return false;
        }
    }

    public void setStartWindowMode(int displayId, String packageName, boolean enable) {
        setStartWindowMode(displayId, packageName, enable ? 10 : -1);
    }

    public void setStartWindowMode(int displayId, String packageName, int delaySecond) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setStartWindowMode(displayId, packageName, delaySecond);
        } catch (RemoteException e) {
            Slog.e(TAG, "setStartWindowMode failed", e);
        }
    }

    public void setLaunchCookie(String packageName, IBinder launchCookie, int delaySecond) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setLaunchCookie(packageName, launchCookie, delaySecond);
        } catch (RemoteException e) {
            Slog.e(TAG, "setLaunchCookie failed", e);
        }
    }

    public void setTaskNotToBack(int displayId, int taskId, boolean notToBack) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setTaskNotToBack(displayId, taskId, notToBack);
        } catch (RemoteException e) {
            Slog.e(TAG, "setTaskNotToBack failed", e);
        }
    }

    public boolean isTaskNotToBack(int displayId, int taskId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.isTaskNotToBack(displayId, taskId);
        } catch (RemoteException e) {
            Slog.e(TAG, "isTaskNotToBack failed", e);
            return false;
        }
    }

    public boolean isWindowModeBlackList(String packageName) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.isWindowModeBlackList(packageName);
        } catch (RemoteException e) {
            Slog.e(TAG, "isWindowModeBlackList failed", e);
            return false;
        }
    }

    public List<String> getWindowModeBlackList() {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return new ArrayList();
        }
        try {
            List<String> list = service.getWindowModeBlackList();
            return list != null ? list : new ArrayList();
        } catch (RemoteException e) {
            Slog.e(TAG, "getWindowModeBlackList failed", e);
            return new ArrayList();
        }
    }

    public List<String> getWindowModeWhiteList() {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return new ArrayList();
        }
        try {
            List<String> list = service.getWindowModeWhiteList();
            return list != null ? list : new ArrayList();
        } catch (RemoteException e) {
            Slog.e(TAG, "getWindowModeWhiteList failed", e);
            return new ArrayList();
        }
    }

    public void setAppMuted(int displayId, String packageName, int uid, boolean muted) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setAppMuted(displayId, packageName, uid, muted);
        } catch (RemoteException e) {
            Slog.e(TAG, "setAppMuted failed", e);
        }
    }

    public boolean isAppMuted(int displayId, String packageName, int uid) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.isAppMuted(displayId, packageName, uid);
        } catch (RemoteException e) {
            Slog.e(TAG, "isAppMuted failed", e);
            return false;
        }
    }

    public boolean removeTaskNotKillProcess(int displayId, int taskId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.removeTaskNotKillProcess(displayId, taskId);
        } catch (RemoteException e) {
            Slog.e(TAG, "removeTaskNotKillProcess failed", e);
            return false;
        }
    }

    public void setLockOrientationForSensor(int displayId, boolean lock) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setLockOrientationForSensor(displayId, lock);
        } catch (RemoteException e) {
            Slog.e(TAG, "setLockOrientationForSensor failed", e);
        }
    }

    public boolean isLockOrientationForSensor(int displayId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.isLockOrientationForSensor(displayId);
        } catch (RemoteException e) {
            Slog.e(TAG, "isLockOrientationForSensor failed", e);
            return false;
        }
    }

    public List<ActivityManager.RunningTaskInfo> getFilteredTasks(int maxNum, boolean filterOnlyVisibleRecents, boolean keepIntentExtra, int ignoreWindowingMode) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return null;
        }
        try {
            return service.getFilteredTasks(maxNum, filterOnlyVisibleRecents, keepIntentExtra, ignoreWindowingMode);
        } catch (RemoteException e) {
            Slog.e(TAG, "getFilteredTasks failed", e);
            return null;
        }
    }

    public List<ActivityManager.RunningTaskInfo> getTaskInfos(int[] taskIds) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return null;
        }
        try {
            return service.getTaskInfos(taskIds);
        } catch (RemoteException e) {
            Slog.e(TAG, "getTaskInfos failed", e);
            return null;
        }
    }

    private static final class WindowModeCallback extends IWindowModeCallback.Stub {
        private final int mDisplayId;
        private final List<WindowModeListener> mListener = new ArrayList();
        private final int mWindowingMode;

        public WindowModeCallback(int displayId, int windowingMode) {
            this.mWindowingMode = windowingMode;
            this.mDisplayId = displayId;
        }

        public void addListener(WindowModeListener listener) {
            if (listener == null) {
                return;
            }
            synchronized (this.mListener) {
                boolean hasAdd = false;
                Iterator<WindowModeListener> it = this.mListener.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WindowModeListener l = it.next();
                    if (l == listener) {
                        hasAdd = true;
                        break;
                    }
                }
                if (!hasAdd) {
                    this.mListener.add(listener);
                }
            }
        }

        public void removeListener(WindowModeListener listener) {
            if (listener == null) {
                return;
            }
            synchronized (this.mListener) {
                for (int i = this.mListener.size() - 1; i >= 0; i--) {
                    WindowModeListener l = this.mListener.get(i);
                    if (l == listener) {
                        this.mListener.remove(i);
                    }
                }
            }
        }

        public int size() {
            int size;
            synchronized (this.mListener) {
                size = this.mListener.size();
            }
            return size;
        }

        @Override // stepos.view.IWindowModeCallback
        public void onStackChanged(int taskId, boolean windowMode, boolean topStack, Bundle data) throws Throwable {
            Throwable th;
            int taskId2;
            boolean windowMode2;
            boolean topStack2;
            synchronized (this.mListener) {
                try {
                    for (WindowModeListener listener : this.mListener) {
                        if (listener == null) {
                            taskId2 = taskId;
                            windowMode2 = windowMode;
                            topStack2 = topStack;
                        } else {
                            listener.onStackWindowModeChanged(windowMode, data);
                            listener.onWindowModeChanged(this.mWindowingMode, windowMode);
                            taskId2 = taskId;
                            windowMode2 = windowMode;
                            topStack2 = topStack;
                            try {
                                listener.onStackChanged(this.mDisplayId, this.mWindowingMode, taskId2, windowMode2, topStack2);
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        }
                        taskId = taskId2;
                        windowMode = windowMode2;
                        topStack = topStack2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }

        @Override // stepos.view.IWindowModeCallback
        public void onTopActivityChanged(int taskId, String packageName, String className, int uid, int pid, boolean topStack) {
            synchronized (this.mListener) {
                for (WindowModeListener listener : this.mListener) {
                    if (listener != null) {
                        listener.onPackageNameChanged(this.mWindowingMode, packageName, uid, pid, topStack);
                        listener.onTopActivityChanged(this.mDisplayId, this.mWindowingMode, taskId, packageName, className, uid, pid);
                    }
                }
            }
        }

        @Override // stepos.view.IWindowModeCallback
        public void onBoundChanged(int taskId, Rect fromBound, Rect toBound, int rotation) throws Throwable {
            Throwable th;
            int taskId2;
            Rect fromBound2;
            Rect toBound2;
            int rotation2;
            synchronized (this.mListener) {
                try {
                    for (WindowModeListener listener : this.mListener) {
                        if (listener == null) {
                            taskId2 = taskId;
                            fromBound2 = fromBound;
                            toBound2 = toBound;
                            rotation2 = rotation;
                        } else {
                            taskId2 = taskId;
                            fromBound2 = fromBound;
                            toBound2 = toBound;
                            rotation2 = rotation;
                            try {
                                listener.onBoundChanged(this.mDisplayId, this.mWindowingMode, taskId2, fromBound2, toBound2, rotation2);
                                if (fromBound2 == null) {
                                    listener.onWindowModeBoundChanged(this.mWindowingMode, toBound2, rotation2);
                                } else {
                                    listener.onWindowModeFlingToTarget(this.mWindowingMode, fromBound2, toBound2);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        }
                        taskId = taskId2;
                        fromBound = fromBound2;
                        toBound = toBound2;
                        rotation = rotation2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }

        @Override // stepos.view.IWindowModeCallback
        public void onStateChanged(int taskId, int windowModeState) {
            synchronized (this.mListener) {
                for (WindowModeListener listener : this.mListener) {
                    if (listener != null) {
                        listener.onWindowModeStateChanged(this.mWindowingMode, windowModeState);
                        listener.onStateChanged(this.mDisplayId, this.mWindowingMode, taskId, windowModeState);
                    }
                }
            }
        }

        @Override // stepos.view.IWindowModeCallback
        public void onImeVisibilityChanged(int taskId, boolean imeVisible, int imeHeight) throws Throwable {
            Throwable th;
            int taskId2;
            boolean imeVisible2;
            int imeHeight2;
            synchronized (this.mListener) {
                try {
                    for (WindowModeListener listener : this.mListener) {
                        if (listener == null) {
                            taskId2 = taskId;
                            imeVisible2 = imeVisible;
                            imeHeight2 = imeHeight;
                        } else {
                            listener.onImeVisibilityChanged(imeVisible, imeHeight);
                            taskId2 = taskId;
                            imeVisible2 = imeVisible;
                            imeHeight2 = imeHeight;
                            try {
                                listener.onImeVisibilityChanged(this.mDisplayId, this.mWindowingMode, taskId2, imeVisible2, imeHeight2);
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        }
                        taskId = taskId2;
                        imeVisible = imeVisible2;
                        imeHeight = imeHeight2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }

        @Override // stepos.view.IWindowModeCallback
        public void onShellTransitionReady(int animationType, int syncId) {
            synchronized (this.mListener) {
                for (WindowModeListener listener : this.mListener) {
                    if (listener != null) {
                        listener.onShellTransitionReady(this.mDisplayId, animationType, syncId);
                    }
                }
            }
        }

        @Override // stepos.view.IWindowModeCallback
        public void onShellTransitionFinished(int animationType, int syncId) {
            synchronized (this.mListener) {
                for (WindowModeListener listener : this.mListener) {
                    if (listener != null) {
                        listener.onShellTransitionFinished(this.mDisplayId, animationType, syncId);
                    }
                }
            }
        }

        @Override // stepos.view.IWindowModeCallback
        public void onWindowModeChangeAnimationFinished(int taskId) {
            synchronized (this.mListener) {
                for (WindowModeListener listener : this.mListener) {
                    if (listener != null) {
                        listener.onWindowModeChangeAnimationFinished(taskId);
                    }
                }
            }
        }

        @Override // stepos.view.IWindowModeCallback
        public void onPreferredWindowModeChanged(int taskId, int currentWindowMode, int preferredWindowMode) {
            synchronized (this.mListener) {
                for (WindowModeListener listener : this.mListener) {
                    if (listener != null) {
                        listener.onPreferredWindowModeChanged(taskId, currentWindowMode, preferredWindowMode);
                    }
                }
            }
        }

        @Override // stepos.view.IWindowModeCallback
        public void onCaptionMenuDismiss(int taskId) {
            synchronized (this.mListener) {
                for (WindowModeListener listener : this.mListener) {
                    if (listener != null) {
                        listener.onCaptionMenuDismiss(this.mDisplayId, this.mWindowingMode, taskId);
                    }
                }
            }
        }

        @Override // stepos.view.IWindowModeCallback
        public void onWindowModeListsChanged() {
            synchronized (this.mListener) {
                for (WindowModeListener listener : this.mListener) {
                    if (listener != null) {
                        listener.onWindowModeListsChanged();
                    }
                }
            }
        }
    }

    private static final class DisplayUICallback extends IDisplayUIListener.Stub {
        private final ArrayList<DisplayUIListener> mListeners;

        private DisplayUICallback() {
            this.mListeners = new ArrayList<>();
        }

        public int addListener(DisplayUIListener listener) {
            int size;
            synchronized (this.mListeners) {
                this.mListeners.add(listener);
                size = this.mListeners.size();
            }
            return size;
        }

        public int removeListener(DisplayUIListener listener) {
            int size;
            synchronized (this.mListeners) {
                this.mListeners.remove(listener);
                size = this.mListeners.size();
            }
            return size;
        }

        @Override // stepos.view.IDisplayUIListener
        public void onDisplayEmpty(int displayId) {
            synchronized (this.mListeners) {
                Iterator<DisplayUIListener> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    DisplayUIListener listener = it.next();
                    listener.onDisplayEmpty(displayId);
                }
            }
        }

        @Override // stepos.view.IDisplayUIListener
        public void onTopActivityChanged(ComponentName topActivity, int uid) {
            synchronized (this.mListeners) {
                Iterator<DisplayUIListener> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    DisplayUIListener listener = it.next();
                    listener.onTopActivityChanged(topActivity, uid);
                }
            }
        }

        @Override // stepos.view.IDisplayUIListener
        public void onTaskWillBackStateChange(int displayId, int taskId, boolean willBack) {
            synchronized (this.mListeners) {
                Iterator<DisplayUIListener> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    DisplayUIListener listener = it.next();
                    listener.onTaskWillBackStateChange(displayId, taskId, willBack);
                }
            }
        }

        @Override // stepos.view.IDisplayUIListener
        public void onSystemBarAttributesChanged(int displayId, int appearance, AppearanceRegion[] appearanceRegions, boolean navbarColorManagedByIme, int behavior, int requestedVisibleTypes, String packageName) {
            int i = behavior;
            boolean isImmersive = i == 2;
            boolean isStatusBarVisible = (WindowInsets.Type.statusBars() & requestedVisibleTypes) != 0;
            boolean isNavBarVisible = (WindowInsets.Type.navigationBars() & requestedVisibleTypes) != 0;
            synchronized (this.mListeners) {
                Iterator<DisplayUIListener> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    DisplayUIListener listener = it.next();
                    listener.onSystemBarVisibleChanged(displayId, isImmersive, isStatusBarVisible, isNavBarVisible, packageName);
                    listener.onSystemBarAttributesChanged(displayId, appearance, appearanceRegions, navbarColorManagedByIme, i, requestedVisibleTypes, packageName);
                    i = behavior;
                }
            }
        }

        @Override // stepos.view.IDisplayUIListener
        public void onDisplayStartAsyncRotation(int displayId, int oldRotation, int newRotation) {
            synchronized (this.mListeners) {
                Iterator<DisplayUIListener> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    DisplayUIListener listener = it.next();
                    listener.onDisplayStartAsyncRotation(displayId, oldRotation, newRotation);
                }
            }
        }

        @Override // stepos.view.IDisplayUIListener
        public void onDisplayFinishAsyncRotation(int displayId) {
            synchronized (this.mListeners) {
                Iterator<DisplayUIListener> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    DisplayUIListener listener = it.next();
                    listener.onDisplayFinishAsyncRotation(displayId);
                }
            }
        }

        @Override // stepos.view.IDisplayUIListener
        public void onVisibleSecureWindowState(int displayId, boolean hasVisibleSecureWindow) {
            synchronized (this.mListeners) {
                Iterator<DisplayUIListener> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    DisplayUIListener listener = it.next();
                    listener.onVisibleSecureWindowState(displayId, hasVisibleSecureWindow);
                }
            }
        }

        @Override // stepos.view.IDisplayUIListener
        public void onDisplayWatchIntentReceived(int displayId, String packageName, Intent activityIntent) {
            synchronized (this.mListeners) {
                Iterator<DisplayUIListener> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    DisplayUIListener listener = it.next();
                    listener.onDisplayWatchIntentReceived(displayId, packageName, activityIntent);
                }
            }
        }
    }

    private static final class UIControllerUpdateCallback extends IUIControllerUpdateListener.Stub {
        private final ArrayList<UIControllerUpdateListener> mListeners;

        private UIControllerUpdateCallback() {
            this.mListeners = new ArrayList<>();
        }

        public int addListener(UIControllerUpdateListener listener) {
            int size;
            synchronized (this.mListeners) {
                this.mListeners.add(listener);
                size = this.mListeners.size();
            }
            return size;
        }

        public int removeListener(UIControllerUpdateListener listener) {
            int size;
            synchronized (this.mListeners) {
                this.mListeners.remove(listener);
                size = this.mListeners.size();
            }
            return size;
        }

        @Override // stepos.view.uicontroller.IUIControllerUpdateListener
        public void onTopWindowUIControllerChanged(int displayId, IBinder binder, ActivityManager.RunningTaskInfo taskInfo) {
            synchronized (this.mListeners) {
                Iterator<UIControllerUpdateListener> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    UIControllerUpdateListener listener = it.next();
                    if (binder != null && binder.isBinderAlive()) {
                        IUIController uicontroller = IUIController.Stub.asInterface(binder);
                        listener.onTopWindowUIControllerChanged(displayId, uicontroller, taskInfo);
                    } else {
                        listener.onTopWindowUIControllerChanged(displayId, null, taskInfo);
                    }
                }
            }
        }
    }

    public boolean hasWindowingModeTasks(int displayId, int... windowmodes) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.hasWindowingModeTasks(displayId, windowmodes);
        } catch (RemoteException e) {
            Slog.e(TAG, "hasWindowingModeTasks failed", e);
            return false;
        }
    }

    public void goBackPreviousWindowMode(int displayId, int taskId, int currentWindowMode) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.goBackPreviousWindowMode(displayId, taskId, currentWindowMode);
        } catch (RemoteException e) {
            Slog.e(TAG, "goBackPreviousWindowMode failed", e);
        }
    }

    public TaskSnapshot getTaskSnapshot(int taskId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return null;
        }
        try {
            return service.getTaskSnapshot(taskId);
        } catch (RemoteException e) {
            Slog.e(TAG, "getTaskSnapshot failed", e);
            return null;
        }
    }

    public void overrideTaskSnapshot(IBinder token, Bitmap snapshot) {
        overrideTaskSnapshot(token, snapshot, true);
    }

    public void overrideTaskSnapshot(IBinder token, Bitmap snapshot, boolean notifyChange) {
        overrideTaskSnapshot(token, snapshot, notifyChange, false);
    }

    public void overrideTaskSnapshot(IBinder token, Bitmap snapshot, boolean notifyChange, boolean forever) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.overrideTaskSnapshot(token, 0, snapshot, notifyChange, forever);
        } catch (RemoteException e) {
            Slog.e(TAG, "overrideTaskSnapshot failed", e);
        }
    }

    public void overrideTaskSnapshot(int taskId, Bitmap snapshot, boolean notifyChange) {
        overrideTaskSnapshot(taskId, snapshot, notifyChange, false);
    }

    public void overrideTaskSnapshot(int taskId, Bitmap snapshot, boolean notifyChange, boolean forever) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.overrideTaskSnapshot(null, taskId, snapshot, notifyChange, forever);
        } catch (RemoteException e) {
            Slog.e(TAG, "overrideTaskSnapshot failed", e);
        }
    }

    public void setTaskSnapshotBlurRegion(IBinder token, Rect blurRegion, int radius) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setTaskSnapshotBlurRegion(token, 0, blurRegion, radius);
        } catch (RemoteException e) {
            Slog.e(TAG, "setTaskSnapshotBlurRegion failed", e);
        }
    }

    public void setTaskSnapshotBlurRegion(IBinder token, Rect blurRegion) {
        setTaskSnapshotBlurRegion(token, blurRegion, 100);
    }

    public void setTaskSnapshotBlurRegion(int taskId, Rect blurRegion) {
        setTaskSnapshotBlurRegion(taskId, blurRegion, 100);
    }

    public void setTaskSnapshotBlurRegion(int taskId, Rect blurRegion, int radius) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setTaskSnapshotBlurRegion(null, taskId, blurRegion, radius);
        } catch (RemoteException e) {
            Slog.e(TAG, "setTaskSnapshotBlurRegion failed", e);
        }
    }

    public boolean hasVisibleWindow(String packageName) {
        return hasVisibleWindow(packageName, -1);
    }

    public boolean hasVisibleWindow(String packageName, int displayId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.hasVisibleWindow(packageName, displayId);
        } catch (RemoteException e) {
            Slog.e(TAG, "hasVisibleWindow failed", e);
            return false;
        }
    }

    public void switchResolution(int width, int height) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.switchResolution(width, height);
        } catch (RemoteException e) {
            Slog.e(TAG, "switchResolution failed", e);
        }
    }

    public int getResolutionType() {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return 0;
        }
        try {
            return service.getResolutionType();
        } catch (RemoteException e) {
            Slog.e(TAG, "getResolutionType failed", e);
            return 0;
        }
    }

    public void setAutoResolutionEnabled(boolean enabled) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setAutoResolutionEnabled(enabled);
        } catch (RemoteException e) {
            Slog.e(TAG, "setAutoResolutionEnabled failed", e);
        }
    }

    public boolean isAutoResolutionEnabled() {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.isAutoResolutionEnabled();
        } catch (RemoteException e) {
            Slog.e(TAG, "isAutoResolutionEnabled failed", e);
            return false;
        }
    }

    public void startFreezingDisplay() {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.startFreezingDisplay();
        } catch (RemoteException e) {
            Slog.e(TAG, "startFreezingDisplay failed", e);
        }
    }

    public void stopFreezingDisplay() {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.stopFreezingDisplay();
        } catch (RemoteException e) {
            Slog.e(TAG, "stopFreezingDisplay failed", e);
        }
    }

    public void setPendingForcedDensityForUser(int displayId, int density, int userId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setPendingForcedDensityForUser(displayId, density, userId);
        } catch (RemoteException e) {
            Slog.e(TAG, "setPendingForcedDensityForUser failed", e);
        }
    }

    public void importanceUXHint(int type, int duration) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.importanceUXHint(type, duration);
        } catch (RemoteException e) {
            Slog.e(TAG, "importanceUXHint failed", e);
        }
    }

    public void addRefreshRateRangeForPackage(String packageName, float minRefreshRate, float maxRefreshRate) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.addRefreshRateRangeForPackage(packageName, minRefreshRate, maxRefreshRate);
        } catch (RemoteException e) {
            Slog.e(TAG, "addRefreshRateRangeForPackage failed", e);
        }
    }

    public void removeRefreshRateRangeForPackage(String packageName) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.removeRefreshRateRangeForPackage(packageName);
        } catch (RemoteException e) {
            Slog.e(TAG, "removeRefreshRateRangeForPackage failed", e);
        }
    }

    public void setAllowRefreshRateSwitching(boolean allow) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setAllowRefreshRateSwitching(allow);
        } catch (RemoteException e) {
            Slog.e(TAG, "setAllowRefreshRateSwitching failed", e);
        }
    }

    public void updateUIController(IWindow window, IUIController uiController) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.updateUIController(window, uiController);
        } catch (Exception e) {
            Slog.e(TAG, "updateUIController failed", e);
        }
    }

    public void setRecentsTransitionInputCallback(IRecentsTransitionInputCallback callback) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setRecentsTransitionInputCallback(callback);
        } catch (Exception e) {
            Slog.d(TAG, "setRecentsTransitionInputCallback fail ", e);
        }
    }

    private static final class AppEventCallBack extends IAppEventListener.Stub {
        private final ArrayList<AppEventListener> mListeners;

        private AppEventCallBack() {
            this.mListeners = new ArrayList<>();
        }

        public int addListener(AppEventListener listener) {
            int size;
            synchronized (this.mListeners) {
                this.mListeners.add(listener);
                size = this.mListeners.size();
            }
            return size;
        }

        public int removeListener(AppEventListener listener) {
            int size;
            synchronized (this.mListeners) {
                this.mListeners.remove(listener);
                size = this.mListeners.size();
            }
            return size;
        }

        @Override // stepos.app.IAppEventListener
        public void onEvent(int flag, Bundle data) {
            switch (flag) {
                case 1:
                    String packageName = data.getString("packageName");
                    String className = data.getString("className");
                    synchronized (this.mListeners) {
                        Iterator<AppEventListener> it = this.mListeners.iterator();
                        while (it.hasNext()) {
                            AppEventListener listener = it.next();
                            listener.onActivityStateChange(packageName, className, data);
                        }
                    }
                    return;
                case 2:
                    String packageName2 = data.getString("packageName");
                    String processName = data.getString("processName");
                    synchronized (this.mListeners) {
                        Iterator<AppEventListener> it2 = this.mListeners.iterator();
                        while (it2.hasNext()) {
                            AppEventListener listener2 = it2.next();
                            listener2.onProcessStateChange(packageName2, processName, data);
                        }
                    }
                    return;
                case 3:
                    String packageName3 = data.getString("packageName");
                    String className2 = data.getString("className");
                    synchronized (this.mListeners) {
                        Iterator<AppEventListener> it3 = this.mListeners.iterator();
                        while (it3.hasNext()) {
                            AppEventListener listener3 = it3.next();
                            listener3.onWindowRequestedVisibleTypesChanged(packageName3, className2, data);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void captureDisplay(int displayId, ScreenCapture.CaptureArgs captureArgs, ScreenCapture.ScreenCaptureListener listener) {
        captureDisplay(displayId, captureArgs, listener, null);
    }

    public void captureDisplay(int displayId, ScreenCapture.CaptureArgs captureArgs, ScreenCapture.ScreenCaptureListener listener, int[] excludeWindowTypes) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.captureDisplay(displayId, captureArgs, listener, excludeWindowTypes);
        } catch (RemoteException e) {
            e.rethrowFromSystemServer();
        }
    }

    public void registerSystemGestureListener(String pkg, int gesture, IStepOSSystemGestureListener listener) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.registerSystemGestureListener(pkg, gesture, listener);
        } catch (RemoteException e) {
            e.rethrowFromSystemServer();
        }
    }

    public void unregisterSystemGestureListener(String pkg, int gesture, IStepOSSystemGestureListener listener) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.unregisterSystemGestureListener(pkg, gesture, listener);
        } catch (RemoteException e) {
            e.rethrowFromSystemServer();
        }
    }

    public SurfaceControl getLockWallpaperSurfaceRoot(int displayId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return null;
        }
        try {
            return service.getLockWallpaperSurfaceRoot(displayId);
        } catch (RemoteException e) {
            e.rethrowFromSystemServer();
            return null;
        }
    }

    public void scrollTopActivity(MotionEvent[] event, int value) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.scrollTopActivity(event, value);
        } catch (RemoteException e) {
            Slog.e(TAG, "scrollTopActivity failed", e);
        }
    }

    public void scrollTopActivityV2(MotionEvent[] event, int value, String windowIdentityHashCode) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.scrollTopActivityV2(event, value, windowIdentityHashCode);
        } catch (RemoteException e) {
            Slog.e(TAG, "scrollTopActivityV2 failed", e);
        }
    }

    public String getTopActivityWindowIdentityHashCode() {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return null;
        }
        try {
            return service.getTopActivityWindowIdentityHashCode();
        } catch (RemoteException e) {
            Slog.e(TAG, "getTopActivityWindowIdentityHashCode failed", e);
            return null;
        }
    }

    public long createStepOSEffect(String shader) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return 0L;
        }
        try {
            return service.createStepOSEffect(shader);
        } catch (Throwable t) {
            Log.e(TAG, "createStepOSEffect failed", t);
            return 0L;
        }
    }

    public void registerOmniDisplayCallback(IOmniDisplayCallback callback) {
        IStepOSWindowManager service;
        if (callback == null || (service = getService()) == null) {
            return;
        }
        try {
            service.registerOmniDisplayCallback(callback);
        } catch (RemoteException e) {
            Slog.e(TAG, "registerOmniDisplayCallback failed", e);
        }
    }

    public void unregisterOmniDisplayCallback(IOmniDisplayCallback callback) {
        IStepOSWindowManager service;
        if (callback == null || (service = getService()) == null) {
            return;
        }
        try {
            service.unregisterOmniDisplayCallback(callback);
        } catch (RemoteException e) {
            Slog.e(TAG, "unregisterOmniDisplayCallback failed", e);
        }
    }

    public boolean isOmniDisplayImeEnabled(int displayId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.isOmniDisplayImeEnabled(displayId);
        } catch (RemoteException e) {
            Slog.e(TAG, "isOmniDisplayImeEnabled failed", e);
            return false;
        }
    }

    public void setOmniDisplayImeEnabled(int displayId, boolean enabled) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setOmniDisplayImeEnabled(displayId, enabled);
        } catch (RemoteException e) {
            Slog.e(TAG, "setOmniDisplayImeEnabled failed", e);
        }
    }

    public boolean isOmniDisplayTakeover(int displayId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.isOmniDisplayTakeover(displayId);
        } catch (RemoteException e) {
            Slog.e(TAG, "isOmniDisplayTakeover failed", e);
            return false;
        }
    }

    public void setOmniDisplayTakeover(int displayId, boolean takeover) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.setOmniDisplayTakeover(displayId, takeover);
        } catch (RemoteException e) {
            Slog.e(TAG, "setOmniDisplayTakeover failed", e);
        }
    }

    public Bundle takeScreenshotWithScaleResult(int displayId, int mode, String pkgName, float scale) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return makeUnknownErrorBundle();
        }
        try {
            Bundle b = service.takeScreenshotWithScaleResult(displayId, mode, pkgName, scale);
            return b != null ? b : makeUnknownErrorBundle();
        } catch (RemoteException e) {
            Slog.e(TAG, "takeScreenshotWithScaleResult failed", e);
            return makeUnknownErrorBundle();
        }
    }

    public Bitmap takeScreenshotWithScale(int displayId, int mode, String pkgName, float scale, Bundle outResult) {
        Bundle b = takeScreenshotWithScaleResult(displayId, mode, pkgName, scale);
        if (outResult != null) {
            outResult.clear();
            outResult.putAll(b);
        }
        int code = b.getInt(KEY_SCREENSHOT_RESULT_CODE, 1);
        if (code != 0) {
            return null;
        }
        return (Bitmap) b.getParcelable(KEY_SCREENSHOT_RESULT_BITMAP, Bitmap.class);
    }

    private static Bundle makeUnknownErrorBundle() {
        Bundle b = new Bundle();
        b.putInt(KEY_SCREENSHOT_RESULT_CODE, 1);
        return b;
    }

    public List getAllColorBarInfo(String pkg) {
        IStepOSWindowManager service = getService();
        if (service != null) {
            try {
                return service.getAllColorBarInfo(pkg);
            } catch (RemoteException e) {
                Slog.e(TAG, "getAllColorBarInfo failed", e);
                return null;
            }
        }
        return null;
    }

    public boolean isWindowModeDragging(int displayId, int taskId) {
        IStepOSWindowManager service = getService();
        if (service == null) {
            return false;
        }
        try {
            return service.isWindowModeDragging(displayId, taskId);
        } catch (RemoteException e) {
            Slog.e(TAG, "isWindowModeDragging failed", e);
            return false;
        }
    }
}
