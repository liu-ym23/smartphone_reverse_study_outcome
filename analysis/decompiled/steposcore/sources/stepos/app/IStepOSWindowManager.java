package stepos.app;

import android.app.ActivityManager;
import android.app.ResultInfo;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.IWindow;
import android.view.MotionEvent;
import android.view.SurfaceControl;
import android.window.ScreenCapture;
import android.window.TaskSnapshot;
import java.util.List;
import stepos.app.IAppEventListener;
import stepos.app.IOmniDisplayCallback;
import stepos.app.IStepOSSystemGestureListener;
import stepos.uicontroller.IUIController;
import stepos.view.IDisplayUIListener;
import stepos.view.IRecentsTransitionInputCallback;
import stepos.view.IWindowModeCallback;
import stepos.view.uicontroller.IUIControllerUpdateListener;

/* loaded from: classes.dex */
public interface IStepOSWindowManager extends IInterface {
    public static final String DESCRIPTOR = "stepos.app.IStepOSWindowManager";

    boolean acquireWakeLockForDisplay(int i) throws RemoteException;

    void addOmniDisplayControlPackage(String str) throws RemoteException;

    void addRefreshRateRangeForPackage(String str, float f, float f2) throws RemoteException;

    boolean applyFinishTransaction(IBinder iBinder, SurfaceControl.Transaction transaction) throws RemoteException;

    void captureDisplay(int i, ScreenCapture.CaptureArgs captureArgs, ScreenCapture.ScreenCaptureListener screenCaptureListener, int[] iArr) throws RemoteException;

    void closeWindowMode(int i, int i2, int i3, boolean z) throws RemoteException;

    Point covertWindowModeCoordinate(int i, int i2, int i3, Point point) throws RemoteException;

    long createStepOSEffect(String str) throws RemoteException;

    void enterWindowMode(int i, int i2, int i3, int i4, Rect rect, float f, boolean z) throws RemoteException;

    boolean flingWindowMode(int i, int i2, int i3, float f, float f2, Point point) throws RemoteException;

    List getAllColorBarInfo(String str) throws RemoteException;

    List<ActivityManager.RunningTaskInfo> getFilteredTasks(int i, boolean z, boolean z2, int i2) throws RemoteException;

    SurfaceControl getLockWallpaperSurfaceRoot(int i) throws RemoteException;

    int getResolutionType() throws RemoteException;

    int getShowingDisplayId(String str) throws RemoteException;

    IBinder getSubService(String str) throws RemoteException;

    List<ActivityManager.RunningTaskInfo> getTaskInfos(int[] iArr) throws RemoteException;

    TaskSnapshot getTaskSnapshot(int i) throws RemoteException;

    Intent getTopActivityIntent(int i) throws RemoteException;

    String getTopActivityWindowIdentityHashCode() throws RemoteException;

    int getVirtualWindowingMode(IBinder iBinder) throws RemoteException;

    int getVirtualWindowingModeByTask(int i, int i2) throws RemoteException;

    List<String> getWindowModeBlackList() throws RemoteException;

    Rect getWindowModeBound(int i, int i2, int i3, boolean z, int i4, boolean z2) throws RemoteException;

    void getWindowModeTouchOffset(IWindow iWindow, float[] fArr) throws RemoteException;

    List<String> getWindowModeWhiteList() throws RemoteException;

    void goBackPreviousWindowMode(int i, int i2, int i3) throws RemoteException;

    boolean hasVisibleWindow(String str, int i) throws RemoteException;

    boolean hasWindowingModeTasks(int i, int[] iArr) throws RemoteException;

    void importanceUXHint(int i, int i2) throws RemoteException;

    boolean isAppMuted(int i, String str, int i2) throws RemoteException;

    boolean isAutoResolutionEnabled() throws RemoteException;

    boolean isClipSystemBarByWindowMode(int i, int i2, int i3) throws RemoteException;

    boolean isFeatureOpen(int i, int i2, String str, int i3) throws RemoteException;

    boolean isInputMethodQsEnable(int i) throws RemoteException;

    boolean isLockOrientationForSensor(int i) throws RemoteException;

    boolean isOmniDisplayId(String str) throws RemoteException;

    boolean isOmniDisplayImeEnabled(int i) throws RemoteException;

    boolean isOmniDisplayTakeover(int i) throws RemoteException;

    boolean isTaskNotToBack(int i, int i2) throws RemoteException;

    boolean isWindowMode(int i, int i2, int i3, IBinder iBinder) throws RemoteException;

    boolean isWindowModeBlackList(String str) throws RemoteException;

    boolean isWindowModeDragging(int i, int i2) throws RemoteException;

    void moveAppToDisplay(String str, int i, boolean z) throws RemoteException;

    void moveTaskToBackInDisplay(int i, int i2, int i3) throws RemoteException;

    void moveTopTaskToFrontInDisplay(int i) throws RemoteException;

    void moveWindowModeBound(int i, int i2, int i3, Rect rect, float[] fArr, float[] fArr2, boolean z, boolean z2) throws RemoteException;

    boolean needWindowModeCaptionBackground(int i, int i2) throws RemoteException;

    void notifyRecentsTransitionFinish(IBinder iBinder, boolean z) throws RemoteException;

    void notifyTaskBackToHome(IBinder iBinder, IBinder iBinder2, int i) throws RemoteException;

    void notifyTransitionMerged(IBinder iBinder, IBinder iBinder2) throws RemoteException;

    void notifyTransitionRemoveTask(IBinder iBinder, IBinder iBinder2, int i) throws RemoteException;

    Bundle omniCall(String str, Bundle bundle) throws RemoteException;

    void overrideTaskSnapshot(IBinder iBinder, int i, Bitmap bitmap, boolean z, boolean z2) throws RemoteException;

    void registerAppEventsListener(IAppEventListener iAppEventListener, int i) throws RemoteException;

    void registerDisplayUIListener(int i, IDisplayUIListener iDisplayUIListener) throws RemoteException;

    void registerOmniDisplayCallback(IOmniDisplayCallback iOmniDisplayCallback) throws RemoteException;

    void registerSystemGestureListener(String str, int i, IStepOSSystemGestureListener iStepOSSystemGestureListener) throws RemoteException;

    void registerUIControllerUpdateListener(int i, IUIControllerUpdateListener iUIControllerUpdateListener) throws RemoteException;

    void registerWindowModeListener(int i, int i2, IWindowModeCallback iWindowModeCallback) throws RemoteException;

    void releaseWakeLockForDisplay(int i) throws RemoteException;

    void removeOmniDisplayControlPackage(String str) throws RemoteException;

    void removeRefreshRateRangeForPackage(String str) throws RemoteException;

    boolean removeTaskNotKillProcess(int i, int i2) throws RemoteException;

    void scrollTopActivity(MotionEvent[] motionEventArr, int i) throws RemoteException;

    void scrollTopActivityV2(MotionEvent[] motionEventArr, int i, String str) throws RemoteException;

    void sendResultToActivity(ActivityInfo activityInfo, ResultInfo resultInfo) throws RemoteException;

    void setAllowRefreshRateSwitching(boolean z) throws RemoteException;

    void setAppMuted(int i, String str, int i2, boolean z) throws RemoteException;

    void setAutoResolutionEnabled(boolean z) throws RemoteException;

    void setAvoidZone(int i, int i2, String str, Rect rect) throws RemoteException;

    void setDisplayBackgroundColor(int i, int i2) throws RemoteException;

    void setDisplayFocusable(int i, boolean z, boolean z2) throws RemoteException;

    void setDisplayTaskAnimation(int i, int i2, String str, String str2, int i3, int i4) throws RemoteException;

    void setFeatureOpen(int i, int i2, String str, int[] iArr, boolean z) throws RemoteException;

    void setLaunchCookie(String str, IBinder iBinder, int i) throws RemoteException;

    void setLockOrientationForSensor(int i, boolean z) throws RemoteException;

    void setOmniDisplayImeEnabled(int i, boolean z) throws RemoteException;

    void setOmniDisplayTakeover(int i, boolean z) throws RemoteException;

    void setPendingForcedDensityForUser(int i, int i2, int i3) throws RemoteException;

    void setRecentsTransitionInputCallback(IRecentsTransitionInputCallback iRecentsTransitionInputCallback) throws RemoteException;

    void setStartPackageInDisplay(int i, String str, int i2) throws RemoteException;

    void setStartWindowMode(int i, String str, int i2) throws RemoteException;

    void setTaskDeferResume(int i, boolean z, String str) throws RemoteException;

    void setTaskNotToBack(int i, int i2, boolean z) throws RemoteException;

    void setTaskSnapshotBlurRegion(IBinder iBinder, int i, Rect rect, int i2) throws RemoteException;

    void setVirtualImeHeight(int i, int i2) throws RemoteException;

    void startFreezingDisplay() throws RemoteException;

    void stopFreezingDisplay() throws RemoteException;

    void switchResolution(int i, int i2) throws RemoteException;

    void switchWindowModeToMaxMode(int i, int i2, int i3, boolean z) throws RemoteException;

    @Deprecated
    Bitmap takeScreenshot(int i, int i2, String str) throws RemoteException;

    Bitmap takeScreenshotWithScale(int i, int i2, String str, float f) throws RemoteException;

    Bundle takeScreenshotWithScaleResult(int i, int i2, String str, float f) throws RemoteException;

    void unRegisterAppEventsListener(IAppEventListener iAppEventListener) throws RemoteException;

    void unregisterDisplayUIListener(int i, IDisplayUIListener iDisplayUIListener) throws RemoteException;

    void unregisterOmniDisplayCallback(IOmniDisplayCallback iOmniDisplayCallback) throws RemoteException;

    void unregisterSystemGestureListener(String str, int i, IStepOSSystemGestureListener iStepOSSystemGestureListener) throws RemoteException;

    void unregisterUIControllerUpdateListener(int i, IUIControllerUpdateListener iUIControllerUpdateListener) throws RemoteException;

    void unregisterWindowModeListener(int i, int i2, IWindowModeCallback iWindowModeCallback) throws RemoteException;

    void updateUIController(IWindow iWindow, IUIController iUIController) throws RemoteException;

    void updateWindowModeShowState(int i, int i2, int i3, boolean z, boolean z2) throws RemoteException;

    public static class Default implements IStepOSWindowManager {
        @Override // stepos.app.IStepOSWindowManager
        public void registerAppEventsListener(IAppEventListener callback, int flags) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void unRegisterAppEventsListener(IAppEventListener callback) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void registerWindowModeListener(int displayId, int windowingMode, IWindowModeCallback callback) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void unregisterWindowModeListener(int displayId, int windowingMode, IWindowModeCallback callback) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public Rect getWindowModeBound(int displayId, int taskId, int windowingMode, boolean pending, int displayRotation, boolean baseBound) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void moveWindowModeBound(int displayId, int taskId, int windowingMode, Rect showFrame, float[] matrix1, float[] matrix2, boolean anim, boolean canShowStrokeLayer) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public Point covertWindowModeCoordinate(int displayId, int taskId, int windowingMode, Point point) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean isWindowMode(int displayId, int taskId, int windowingMode, IBinder token) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean isClipSystemBarByWindowMode(int displayId, int taskId, int systemBarType) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean needWindowModeCaptionBackground(int displayId, int taskId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public int getVirtualWindowingMode(IBinder token) throws RemoteException {
            return 0;
        }

        @Override // stepos.app.IStepOSWindowManager
        public int getVirtualWindowingModeByTask(int displayId, int taskId) throws RemoteException {
            return 0;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void updateWindowModeShowState(int displayId, int taskId, int windowingMode, boolean show, boolean nextChange) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void closeWindowMode(int displayId, int taskId, int windowingMode, boolean anim) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void enterWindowMode(int displayId, int taskId, int oldWindowingMode, int newWindowingMode, Rect showBound, float cornerRadius, boolean anim) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void switchWindowModeToMaxMode(int displayId, int taskId, int windowingMode, boolean maxMode) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean flingWindowMode(int displayId, int taskId, int windowingMode, float velocityX, float velocityY, Point startPosition) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setAvoidZone(int displayId, int windowingMode, String packageName, Rect avoidZone) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setStartWindowMode(int displayId, String packageName, int delaySecond) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setTaskNotToBack(int displayId, int taskId, boolean notToBack) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean isTaskNotToBack(int displayId, int taskId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean isWindowModeBlackList(String packageName) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public List<String> getWindowModeBlackList() throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWindowManager
        public List<String> getWindowModeWhiteList() throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setAppMuted(int displayId, String packageName, int uid, boolean muted) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean isAppMuted(int displayId, String packageName, int uid) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void getWindowModeTouchOffset(IWindow window, float[] values) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean hasWindowingModeTasks(int display, int[] windowmodes) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void goBackPreviousWindowMode(int displayId, int taskId, int currentWindowMode) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public List<ActivityManager.RunningTaskInfo> getFilteredTasks(int maxNum, boolean filterOnlyVisibleRecents, boolean keepIntentExtra, int ignoreWindowingMode) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWindowManager
        public List<ActivityManager.RunningTaskInfo> getTaskInfos(int[] taskIds) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void sendResultToActivity(ActivityInfo info, ResultInfo result) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean removeTaskNotKillProcess(int displayId, int taskId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setTaskDeferResume(int taskId, boolean deferResume, String reason) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setLockOrientationForSensor(int displayId, boolean lock) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean isLockOrientationForSensor(int displayId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean isFeatureOpen(int displayId, int uid, String displayName, int feature) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setFeatureOpen(int displayId, int uid, String displayName, int[] feature, boolean open) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setDisplayTaskAnimation(int displayId, int uid, String displayName, String packageName, int exitResId, int enterResId) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setDisplayFocusable(int displayId, boolean focusable, boolean requestFocus) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public TaskSnapshot getTaskSnapshot(int taskId) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void overrideTaskSnapshot(IBinder token, int taskId, Bitmap bitmap, boolean notifyChange, boolean forever) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setTaskSnapshotBlurRegion(IBinder token, int taskId, Rect region, int radius) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean hasVisibleWindow(String packageName, int displayId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void registerDisplayUIListener(int displayId, IDisplayUIListener callback) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void unregisterDisplayUIListener(int displayId, IDisplayUIListener callback) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setStartPackageInDisplay(int displayId, String packageName, int delaySecond) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void moveTaskToBackInDisplay(int taskId, int oldDisplayId, int newDisplayId) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void moveTopTaskToFrontInDisplay(int displayId) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setDisplayBackgroundColor(int displayId, int color) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean acquireWakeLockForDisplay(int displayId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void releaseWakeLockForDisplay(int displayId) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void registerUIControllerUpdateListener(int displayId, IUIControllerUpdateListener listener) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void unregisterUIControllerUpdateListener(int displayId, IUIControllerUpdateListener listener) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void updateUIController(IWindow window, IUIController uiController) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean applyFinishTransaction(IBinder transitionToken, SurfaceControl.Transaction t) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void notifyTransitionMerged(IBinder playing, IBinder merged) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void notifyTransitionRemoveTask(IBinder playing, IBinder merged, int removeTaskId) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void notifyRecentsTransitionFinish(IBinder playing, boolean toHome) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setRecentsTransitionInputCallback(IRecentsTransitionInputCallback callback) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void notifyTaskBackToHome(IBinder playing, IBinder merged, int removeTaskId) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void switchResolution(int width, int height) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public int getResolutionType() throws RemoteException {
            return 0;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setAutoResolutionEnabled(boolean enabled) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean isAutoResolutionEnabled() throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public IBinder getSubService(String serviceName) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setVirtualImeHeight(int displayId, int height) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean isInputMethodQsEnable(int displayId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setLaunchCookie(String packageName, IBinder launchCookie, int delaySecond) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void captureDisplay(int displayId, ScreenCapture.CaptureArgs captureArgs, ScreenCapture.ScreenCaptureListener listener, int[] excludeWindowTypes) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void startFreezingDisplay() throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void stopFreezingDisplay() throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setPendingForcedDensityForUser(int displayId, int density, int userId) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void importanceUXHint(int type, int duration) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void addRefreshRateRangeForPackage(String packageName, float minRefreshRate, float maxRefreshRate) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void removeRefreshRateRangeForPackage(String packageName) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setAllowRefreshRateSwitching(boolean allow) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void registerSystemGestureListener(String pkg, int gesture, IStepOSSystemGestureListener listener) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void unregisterSystemGestureListener(String pkg, int gesture, IStepOSSystemGestureListener listener) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void scrollTopActivity(MotionEvent[] event, int value) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void scrollTopActivityV2(MotionEvent[] event, int value, String windowIdentityHashCode) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public String getTopActivityWindowIdentityHashCode() throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWindowManager
        public SurfaceControl getLockWallpaperSurfaceRoot(int displayId) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWindowManager
        public long createStepOSEffect(String shader) throws RemoteException {
            return 0L;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void moveAppToDisplay(String packageName, int displayId, boolean top) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void addOmniDisplayControlPackage(String packageName) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void removeOmniDisplayControlPackage(String packageName) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public Intent getTopActivityIntent(int displayId) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWindowManager
        public int getShowingDisplayId(String packageName) throws RemoteException {
            return 0;
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean isOmniDisplayId(String packageName) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void registerOmniDisplayCallback(IOmniDisplayCallback callback) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public void unregisterOmniDisplayCallback(IOmniDisplayCallback callback) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean isOmniDisplayImeEnabled(int displayId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setOmniDisplayImeEnabled(int displayId, boolean enabled) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean isOmniDisplayTakeover(int displayId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSWindowManager
        public void setOmniDisplayTakeover(int displayId, boolean takeover) throws RemoteException {
        }

        @Override // stepos.app.IStepOSWindowManager
        public Bundle omniCall(String key, Bundle params) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWindowManager
        public Bundle takeScreenshotWithScaleResult(int displayId, int mode, String pkgName, float scale) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWindowManager
        public Bitmap takeScreenshot(int displayId, int mode, String pkgName) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWindowManager
        public Bitmap takeScreenshotWithScale(int displayId, int mode, String pkgName, float scale) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWindowManager
        public List getAllColorBarInfo(String pkg) throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWindowManager
        public boolean isWindowModeDragging(int displayId, int taskId) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSWindowManager {
        static final int TRANSACTION_acquireWakeLockForDisplay = 51;
        static final int TRANSACTION_addOmniDisplayControlPackage = 86;
        static final int TRANSACTION_addRefreshRateRangeForPackage = 75;
        static final int TRANSACTION_applyFinishTransaction = 56;
        static final int TRANSACTION_captureDisplay = 70;
        static final int TRANSACTION_closeWindowMode = 14;
        static final int TRANSACTION_covertWindowModeCoordinate = 7;
        static final int TRANSACTION_createStepOSEffect = 84;
        static final int TRANSACTION_enterWindowMode = 15;
        static final int TRANSACTION_flingWindowMode = 17;
        static final int TRANSACTION_getAllColorBarInfo = 101;
        static final int TRANSACTION_getFilteredTasks = 30;
        static final int TRANSACTION_getLockWallpaperSurfaceRoot = 83;
        static final int TRANSACTION_getResolutionType = 63;
        static final int TRANSACTION_getShowingDisplayId = 89;
        static final int TRANSACTION_getSubService = 66;
        static final int TRANSACTION_getTaskInfos = 31;
        static final int TRANSACTION_getTaskSnapshot = 41;
        static final int TRANSACTION_getTopActivityIntent = 88;
        static final int TRANSACTION_getTopActivityWindowIdentityHashCode = 82;
        static final int TRANSACTION_getVirtualWindowingMode = 11;
        static final int TRANSACTION_getVirtualWindowingModeByTask = 12;
        static final int TRANSACTION_getWindowModeBlackList = 23;
        static final int TRANSACTION_getWindowModeBound = 5;
        static final int TRANSACTION_getWindowModeTouchOffset = 27;
        static final int TRANSACTION_getWindowModeWhiteList = 24;
        static final int TRANSACTION_goBackPreviousWindowMode = 29;
        static final int TRANSACTION_hasVisibleWindow = 44;
        static final int TRANSACTION_hasWindowingModeTasks = 28;
        static final int TRANSACTION_importanceUXHint = 74;
        static final int TRANSACTION_isAppMuted = 26;
        static final int TRANSACTION_isAutoResolutionEnabled = 65;
        static final int TRANSACTION_isClipSystemBarByWindowMode = 9;
        static final int TRANSACTION_isFeatureOpen = 37;
        static final int TRANSACTION_isInputMethodQsEnable = 68;
        static final int TRANSACTION_isLockOrientationForSensor = 36;
        static final int TRANSACTION_isOmniDisplayId = 90;
        static final int TRANSACTION_isOmniDisplayImeEnabled = 93;
        static final int TRANSACTION_isOmniDisplayTakeover = 95;
        static final int TRANSACTION_isTaskNotToBack = 21;
        static final int TRANSACTION_isWindowMode = 8;
        static final int TRANSACTION_isWindowModeBlackList = 22;
        static final int TRANSACTION_isWindowModeDragging = 102;
        static final int TRANSACTION_moveAppToDisplay = 85;
        static final int TRANSACTION_moveTaskToBackInDisplay = 48;
        static final int TRANSACTION_moveTopTaskToFrontInDisplay = 49;
        static final int TRANSACTION_moveWindowModeBound = 6;
        static final int TRANSACTION_needWindowModeCaptionBackground = 10;
        static final int TRANSACTION_notifyRecentsTransitionFinish = 59;
        static final int TRANSACTION_notifyTaskBackToHome = 61;
        static final int TRANSACTION_notifyTransitionMerged = 57;
        static final int TRANSACTION_notifyTransitionRemoveTask = 58;
        static final int TRANSACTION_omniCall = 97;
        static final int TRANSACTION_overrideTaskSnapshot = 42;
        static final int TRANSACTION_registerAppEventsListener = 1;
        static final int TRANSACTION_registerDisplayUIListener = 45;
        static final int TRANSACTION_registerOmniDisplayCallback = 91;
        static final int TRANSACTION_registerSystemGestureListener = 78;
        static final int TRANSACTION_registerUIControllerUpdateListener = 53;
        static final int TRANSACTION_registerWindowModeListener = 3;
        static final int TRANSACTION_releaseWakeLockForDisplay = 52;
        static final int TRANSACTION_removeOmniDisplayControlPackage = 87;
        static final int TRANSACTION_removeRefreshRateRangeForPackage = 76;
        static final int TRANSACTION_removeTaskNotKillProcess = 33;
        static final int TRANSACTION_scrollTopActivity = 80;
        static final int TRANSACTION_scrollTopActivityV2 = 81;
        static final int TRANSACTION_sendResultToActivity = 32;
        static final int TRANSACTION_setAllowRefreshRateSwitching = 77;
        static final int TRANSACTION_setAppMuted = 25;
        static final int TRANSACTION_setAutoResolutionEnabled = 64;
        static final int TRANSACTION_setAvoidZone = 18;
        static final int TRANSACTION_setDisplayBackgroundColor = 50;
        static final int TRANSACTION_setDisplayFocusable = 40;
        static final int TRANSACTION_setDisplayTaskAnimation = 39;
        static final int TRANSACTION_setFeatureOpen = 38;
        static final int TRANSACTION_setLaunchCookie = 69;
        static final int TRANSACTION_setLockOrientationForSensor = 35;
        static final int TRANSACTION_setOmniDisplayImeEnabled = 94;
        static final int TRANSACTION_setOmniDisplayTakeover = 96;
        static final int TRANSACTION_setPendingForcedDensityForUser = 73;
        static final int TRANSACTION_setRecentsTransitionInputCallback = 60;
        static final int TRANSACTION_setStartPackageInDisplay = 47;
        static final int TRANSACTION_setStartWindowMode = 19;
        static final int TRANSACTION_setTaskDeferResume = 34;
        static final int TRANSACTION_setTaskNotToBack = 20;
        static final int TRANSACTION_setTaskSnapshotBlurRegion = 43;
        static final int TRANSACTION_setVirtualImeHeight = 67;
        static final int TRANSACTION_startFreezingDisplay = 71;
        static final int TRANSACTION_stopFreezingDisplay = 72;
        static final int TRANSACTION_switchResolution = 62;
        static final int TRANSACTION_switchWindowModeToMaxMode = 16;
        static final int TRANSACTION_takeScreenshot = 99;
        static final int TRANSACTION_takeScreenshotWithScale = 100;
        static final int TRANSACTION_takeScreenshotWithScaleResult = 98;
        static final int TRANSACTION_unRegisterAppEventsListener = 2;
        static final int TRANSACTION_unregisterDisplayUIListener = 46;
        static final int TRANSACTION_unregisterOmniDisplayCallback = 92;
        static final int TRANSACTION_unregisterSystemGestureListener = 79;
        static final int TRANSACTION_unregisterUIControllerUpdateListener = 54;
        static final int TRANSACTION_unregisterWindowModeListener = 4;
        static final int TRANSACTION_updateUIController = 55;
        static final int TRANSACTION_updateWindowModeShowState = 13;

        public Stub() {
            attachInterface(this, IStepOSWindowManager.DESCRIPTOR);
        }

        public static IStepOSWindowManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSWindowManager.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSWindowManager)) {
                return (IStepOSWindowManager) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case 1:
                    return "registerAppEventsListener";
                case 2:
                    return "unRegisterAppEventsListener";
                case 3:
                    return "registerWindowModeListener";
                case 4:
                    return "unregisterWindowModeListener";
                case 5:
                    return "getWindowModeBound";
                case 6:
                    return "moveWindowModeBound";
                case 7:
                    return "covertWindowModeCoordinate";
                case 8:
                    return "isWindowMode";
                case 9:
                    return "isClipSystemBarByWindowMode";
                case 10:
                    return "needWindowModeCaptionBackground";
                case 11:
                    return "getVirtualWindowingMode";
                case 12:
                    return "getVirtualWindowingModeByTask";
                case 13:
                    return "updateWindowModeShowState";
                case 14:
                    return "closeWindowMode";
                case 15:
                    return "enterWindowMode";
                case 16:
                    return "switchWindowModeToMaxMode";
                case 17:
                    return "flingWindowMode";
                case 18:
                    return "setAvoidZone";
                case 19:
                    return "setStartWindowMode";
                case 20:
                    return "setTaskNotToBack";
                case 21:
                    return "isTaskNotToBack";
                case 22:
                    return "isWindowModeBlackList";
                case 23:
                    return "getWindowModeBlackList";
                case 24:
                    return "getWindowModeWhiteList";
                case 25:
                    return "setAppMuted";
                case 26:
                    return "isAppMuted";
                case 27:
                    return "getWindowModeTouchOffset";
                case 28:
                    return "hasWindowingModeTasks";
                case 29:
                    return "goBackPreviousWindowMode";
                case 30:
                    return "getFilteredTasks";
                case 31:
                    return "getTaskInfos";
                case 32:
                    return "sendResultToActivity";
                case 33:
                    return "removeTaskNotKillProcess";
                case 34:
                    return "setTaskDeferResume";
                case 35:
                    return "setLockOrientationForSensor";
                case 36:
                    return "isLockOrientationForSensor";
                case 37:
                    return "isFeatureOpen";
                case 38:
                    return "setFeatureOpen";
                case 39:
                    return "setDisplayTaskAnimation";
                case 40:
                    return "setDisplayFocusable";
                case 41:
                    return "getTaskSnapshot";
                case 42:
                    return "overrideTaskSnapshot";
                case 43:
                    return "setTaskSnapshotBlurRegion";
                case 44:
                    return "hasVisibleWindow";
                case 45:
                    return "registerDisplayUIListener";
                case 46:
                    return "unregisterDisplayUIListener";
                case 47:
                    return "setStartPackageInDisplay";
                case 48:
                    return "moveTaskToBackInDisplay";
                case TRANSACTION_moveTopTaskToFrontInDisplay /* 49 */:
                    return "moveTopTaskToFrontInDisplay";
                case TRANSACTION_setDisplayBackgroundColor /* 50 */:
                    return "setDisplayBackgroundColor";
                case TRANSACTION_acquireWakeLockForDisplay /* 51 */:
                    return "acquireWakeLockForDisplay";
                case TRANSACTION_releaseWakeLockForDisplay /* 52 */:
                    return "releaseWakeLockForDisplay";
                case TRANSACTION_registerUIControllerUpdateListener /* 53 */:
                    return "registerUIControllerUpdateListener";
                case TRANSACTION_unregisterUIControllerUpdateListener /* 54 */:
                    return "unregisterUIControllerUpdateListener";
                case TRANSACTION_updateUIController /* 55 */:
                    return "updateUIController";
                case 56:
                    return "applyFinishTransaction";
                case TRANSACTION_notifyTransitionMerged /* 57 */:
                    return "notifyTransitionMerged";
                case 58:
                    return "notifyTransitionRemoveTask";
                case 59:
                    return "notifyRecentsTransitionFinish";
                case 60:
                    return "setRecentsTransitionInputCallback";
                case 61:
                    return "notifyTaskBackToHome";
                case 62:
                    return "switchResolution";
                case 63:
                    return "getResolutionType";
                case 64:
                    return "setAutoResolutionEnabled";
                case 65:
                    return "isAutoResolutionEnabled";
                case 66:
                    return "getSubService";
                case 67:
                    return "setVirtualImeHeight";
                case 68:
                    return "isInputMethodQsEnable";
                case 69:
                    return "setLaunchCookie";
                case TRANSACTION_captureDisplay /* 70 */:
                    return "captureDisplay";
                case TRANSACTION_startFreezingDisplay /* 71 */:
                    return "startFreezingDisplay";
                case 72:
                    return "stopFreezingDisplay";
                case 73:
                    return "setPendingForcedDensityForUser";
                case TRANSACTION_importanceUXHint /* 74 */:
                    return "importanceUXHint";
                case 75:
                    return "addRefreshRateRangeForPackage";
                case 76:
                    return "removeRefreshRateRangeForPackage";
                case 77:
                    return "setAllowRefreshRateSwitching";
                case 78:
                    return "registerSystemGestureListener";
                case 79:
                    return "unregisterSystemGestureListener";
                case 80:
                    return "scrollTopActivity";
                case TRANSACTION_scrollTopActivityV2 /* 81 */:
                    return "scrollTopActivityV2";
                case TRANSACTION_getTopActivityWindowIdentityHashCode /* 82 */:
                    return "getTopActivityWindowIdentityHashCode";
                case TRANSACTION_getLockWallpaperSurfaceRoot /* 83 */:
                    return "getLockWallpaperSurfaceRoot";
                case TRANSACTION_createStepOSEffect /* 84 */:
                    return "createStepOSEffect";
                case TRANSACTION_moveAppToDisplay /* 85 */:
                    return "moveAppToDisplay";
                case TRANSACTION_addOmniDisplayControlPackage /* 86 */:
                    return "addOmniDisplayControlPackage";
                case TRANSACTION_removeOmniDisplayControlPackage /* 87 */:
                    return "removeOmniDisplayControlPackage";
                case TRANSACTION_getTopActivityIntent /* 88 */:
                    return "getTopActivityIntent";
                case TRANSACTION_getShowingDisplayId /* 89 */:
                    return "getShowingDisplayId";
                case TRANSACTION_isOmniDisplayId /* 90 */:
                    return "isOmniDisplayId";
                case TRANSACTION_registerOmniDisplayCallback /* 91 */:
                    return "registerOmniDisplayCallback";
                case TRANSACTION_unregisterOmniDisplayCallback /* 92 */:
                    return "unregisterOmniDisplayCallback";
                case TRANSACTION_isOmniDisplayImeEnabled /* 93 */:
                    return "isOmniDisplayImeEnabled";
                case TRANSACTION_setOmniDisplayImeEnabled /* 94 */:
                    return "setOmniDisplayImeEnabled";
                case TRANSACTION_isOmniDisplayTakeover /* 95 */:
                    return "isOmniDisplayTakeover";
                case TRANSACTION_setOmniDisplayTakeover /* 96 */:
                    return "setOmniDisplayTakeover";
                case TRANSACTION_omniCall /* 97 */:
                    return "omniCall";
                case TRANSACTION_takeScreenshotWithScaleResult /* 98 */:
                    return "takeScreenshotWithScaleResult";
                case TRANSACTION_takeScreenshot /* 99 */:
                    return "takeScreenshot";
                case 100:
                    return "takeScreenshotWithScale";
                case 101:
                    return "getAllColorBarInfo";
                case 102:
                    return "isWindowModeDragging";
                default:
                    return null;
            }
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code >= 1 && code <= 16777215) {
                data.enforceInterface(IStepOSWindowManager.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSWindowManager.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    IAppEventListener _arg0 = IAppEventListener.Stub.asInterface(data.readStrongBinder());
                    int _arg1 = data.readInt();
                    registerAppEventsListener(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                case 2:
                    IAppEventListener _arg02 = IAppEventListener.Stub.asInterface(data.readStrongBinder());
                    unRegisterAppEventsListener(_arg02);
                    reply.writeNoException();
                    return true;
                case 3:
                    int _arg03 = data.readInt();
                    int _arg12 = data.readInt();
                    IWindowModeCallback _arg2 = IWindowModeCallback.Stub.asInterface(data.readStrongBinder());
                    registerWindowModeListener(_arg03, _arg12, _arg2);
                    reply.writeNoException();
                    return true;
                case 4:
                    int _arg04 = data.readInt();
                    int _arg13 = data.readInt();
                    IWindowModeCallback _arg22 = IWindowModeCallback.Stub.asInterface(data.readStrongBinder());
                    unregisterWindowModeListener(_arg04, _arg13, _arg22);
                    reply.writeNoException();
                    return true;
                case 5:
                    int _arg05 = data.readInt();
                    int _arg14 = data.readInt();
                    int _arg23 = data.readInt();
                    boolean _arg3 = data.readBoolean();
                    int _arg4 = data.readInt();
                    boolean _arg5 = data.readBoolean();
                    Rect _result = getWindowModeBound(_arg05, _arg14, _arg23, _arg3, _arg4, _arg5);
                    reply.writeNoException();
                    reply.writeTypedObject(_result, 1);
                    return true;
                case 6:
                    int _arg06 = data.readInt();
                    int _arg15 = data.readInt();
                    int _arg24 = data.readInt();
                    Rect _arg32 = (Rect) data.readTypedObject(Rect.CREATOR);
                    float[] _arg42 = data.createFloatArray();
                    float[] _arg52 = data.createFloatArray();
                    boolean _arg6 = data.readBoolean();
                    boolean _arg7 = data.readBoolean();
                    moveWindowModeBound(_arg06, _arg15, _arg24, _arg32, _arg42, _arg52, _arg6, _arg7);
                    reply.writeNoException();
                    return true;
                case 7:
                    int _arg07 = data.readInt();
                    int _arg16 = data.readInt();
                    int _arg25 = data.readInt();
                    Point _arg33 = (Point) data.readTypedObject(Point.CREATOR);
                    Point _result2 = covertWindowModeCoordinate(_arg07, _arg16, _arg25, _arg33);
                    reply.writeNoException();
                    reply.writeTypedObject(_result2, 1);
                    return true;
                case 8:
                    int _arg08 = data.readInt();
                    int _arg17 = data.readInt();
                    int _arg26 = data.readInt();
                    IBinder _arg34 = data.readStrongBinder();
                    boolean _result3 = isWindowMode(_arg08, _arg17, _arg26, _arg34);
                    reply.writeNoException();
                    reply.writeBoolean(_result3);
                    return true;
                case 9:
                    int _arg09 = data.readInt();
                    int _arg18 = data.readInt();
                    int _arg27 = data.readInt();
                    boolean _result4 = isClipSystemBarByWindowMode(_arg09, _arg18, _arg27);
                    reply.writeNoException();
                    reply.writeBoolean(_result4);
                    return true;
                case 10:
                    int _arg010 = data.readInt();
                    int _arg19 = data.readInt();
                    boolean _result5 = needWindowModeCaptionBackground(_arg010, _arg19);
                    reply.writeNoException();
                    reply.writeBoolean(_result5);
                    return true;
                case 11:
                    IBinder _arg011 = data.readStrongBinder();
                    int _result6 = getVirtualWindowingMode(_arg011);
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    return true;
                case 12:
                    int _arg012 = data.readInt();
                    int _arg110 = data.readInt();
                    int _result7 = getVirtualWindowingModeByTask(_arg012, _arg110);
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                case 13:
                    int _arg013 = data.readInt();
                    int _arg111 = data.readInt();
                    int _arg28 = data.readInt();
                    boolean _arg35 = data.readBoolean();
                    boolean _arg43 = data.readBoolean();
                    updateWindowModeShowState(_arg013, _arg111, _arg28, _arg35, _arg43);
                    reply.writeNoException();
                    return true;
                case 14:
                    int _arg014 = data.readInt();
                    int _arg112 = data.readInt();
                    int _arg29 = data.readInt();
                    boolean _arg36 = data.readBoolean();
                    closeWindowMode(_arg014, _arg112, _arg29, _arg36);
                    reply.writeNoException();
                    return true;
                case 15:
                    int _arg015 = data.readInt();
                    int _arg113 = data.readInt();
                    int _arg210 = data.readInt();
                    int _arg37 = data.readInt();
                    Rect _arg44 = (Rect) data.readTypedObject(Rect.CREATOR);
                    float _arg53 = data.readFloat();
                    boolean _arg62 = data.readBoolean();
                    enterWindowMode(_arg015, _arg113, _arg210, _arg37, _arg44, _arg53, _arg62);
                    reply.writeNoException();
                    return true;
                case 16:
                    int _arg016 = data.readInt();
                    int _arg114 = data.readInt();
                    int _arg211 = data.readInt();
                    boolean _arg38 = data.readBoolean();
                    switchWindowModeToMaxMode(_arg016, _arg114, _arg211, _arg38);
                    reply.writeNoException();
                    return true;
                case 17:
                    int _arg017 = data.readInt();
                    int _arg115 = data.readInt();
                    int _arg212 = data.readInt();
                    float _arg39 = data.readFloat();
                    float _arg45 = data.readFloat();
                    Point _arg54 = (Point) data.readTypedObject(Point.CREATOR);
                    boolean _result8 = flingWindowMode(_arg017, _arg115, _arg212, _arg39, _arg45, _arg54);
                    reply.writeNoException();
                    reply.writeBoolean(_result8);
                    return true;
                case 18:
                    int _arg018 = data.readInt();
                    int _arg116 = data.readInt();
                    String _arg213 = data.readString();
                    Rect _arg310 = (Rect) data.readTypedObject(Rect.CREATOR);
                    setAvoidZone(_arg018, _arg116, _arg213, _arg310);
                    reply.writeNoException();
                    return true;
                case 19:
                    int _arg019 = data.readInt();
                    String _arg117 = data.readString();
                    int _arg214 = data.readInt();
                    setStartWindowMode(_arg019, _arg117, _arg214);
                    reply.writeNoException();
                    return true;
                case 20:
                    int _arg020 = data.readInt();
                    int _arg118 = data.readInt();
                    boolean _arg215 = data.readBoolean();
                    setTaskNotToBack(_arg020, _arg118, _arg215);
                    reply.writeNoException();
                    return true;
                case 21:
                    int _arg021 = data.readInt();
                    int _arg119 = data.readInt();
                    boolean _result9 = isTaskNotToBack(_arg021, _arg119);
                    reply.writeNoException();
                    reply.writeBoolean(_result9);
                    return true;
                case 22:
                    String _arg022 = data.readString();
                    boolean _result10 = isWindowModeBlackList(_arg022);
                    reply.writeNoException();
                    reply.writeBoolean(_result10);
                    return true;
                case 23:
                    List<String> _result11 = getWindowModeBlackList();
                    reply.writeNoException();
                    reply.writeStringList(_result11);
                    return true;
                case 24:
                    List<String> _result12 = getWindowModeWhiteList();
                    reply.writeNoException();
                    reply.writeStringList(_result12);
                    return true;
                case 25:
                    int _arg023 = data.readInt();
                    String _arg120 = data.readString();
                    int _arg216 = data.readInt();
                    boolean _arg311 = data.readBoolean();
                    setAppMuted(_arg023, _arg120, _arg216, _arg311);
                    reply.writeNoException();
                    return true;
                case 26:
                    int _arg024 = data.readInt();
                    String _arg121 = data.readString();
                    int _arg217 = data.readInt();
                    boolean _result13 = isAppMuted(_arg024, _arg121, _arg217);
                    reply.writeNoException();
                    reply.writeBoolean(_result13);
                    return true;
                case 27:
                    IWindow _arg025 = IWindow.Stub.asInterface(data.readStrongBinder());
                    float[] _arg122 = data.createFloatArray();
                    getWindowModeTouchOffset(_arg025, _arg122);
                    reply.writeNoException();
                    reply.writeFloatArray(_arg122);
                    return true;
                case 28:
                    int _arg026 = data.readInt();
                    int[] _arg123 = data.createIntArray();
                    boolean _result14 = hasWindowingModeTasks(_arg026, _arg123);
                    reply.writeNoException();
                    reply.writeBoolean(_result14);
                    return true;
                case 29:
                    int _arg027 = data.readInt();
                    int _arg124 = data.readInt();
                    int _arg218 = data.readInt();
                    goBackPreviousWindowMode(_arg027, _arg124, _arg218);
                    reply.writeNoException();
                    return true;
                case 30:
                    int _arg028 = data.readInt();
                    boolean _arg125 = data.readBoolean();
                    boolean _arg219 = data.readBoolean();
                    int _arg312 = data.readInt();
                    List<ActivityManager.RunningTaskInfo> _result15 = getFilteredTasks(_arg028, _arg125, _arg219, _arg312);
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result15, 1);
                    return true;
                case 31:
                    int[] _arg029 = data.createIntArray();
                    List<ActivityManager.RunningTaskInfo> _result16 = getTaskInfos(_arg029);
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result16, 1);
                    return true;
                case 32:
                    ActivityInfo _arg030 = (ActivityInfo) data.readTypedObject(ActivityInfo.CREATOR);
                    ResultInfo _arg126 = (ResultInfo) data.readTypedObject(ResultInfo.CREATOR);
                    sendResultToActivity(_arg030, _arg126);
                    reply.writeNoException();
                    return true;
                case 33:
                    int _arg031 = data.readInt();
                    int _arg127 = data.readInt();
                    boolean _result17 = removeTaskNotKillProcess(_arg031, _arg127);
                    reply.writeNoException();
                    reply.writeBoolean(_result17);
                    return true;
                case 34:
                    int _arg032 = data.readInt();
                    boolean _arg128 = data.readBoolean();
                    String _arg220 = data.readString();
                    setTaskDeferResume(_arg032, _arg128, _arg220);
                    return true;
                case 35:
                    int _arg033 = data.readInt();
                    boolean _arg129 = data.readBoolean();
                    setLockOrientationForSensor(_arg033, _arg129);
                    reply.writeNoException();
                    return true;
                case 36:
                    int _arg034 = data.readInt();
                    boolean _result18 = isLockOrientationForSensor(_arg034);
                    reply.writeNoException();
                    reply.writeBoolean(_result18);
                    return true;
                case 37:
                    int _arg035 = data.readInt();
                    int _arg130 = data.readInt();
                    String _arg221 = data.readString();
                    int _arg313 = data.readInt();
                    boolean _result19 = isFeatureOpen(_arg035, _arg130, _arg221, _arg313);
                    reply.writeNoException();
                    reply.writeBoolean(_result19);
                    return true;
                case 38:
                    int _arg036 = data.readInt();
                    int _arg131 = data.readInt();
                    String _arg222 = data.readString();
                    int[] _arg314 = data.createIntArray();
                    boolean _arg46 = data.readBoolean();
                    setFeatureOpen(_arg036, _arg131, _arg222, _arg314, _arg46);
                    reply.writeNoException();
                    return true;
                case 39:
                    int _arg037 = data.readInt();
                    int _arg132 = data.readInt();
                    String _arg223 = data.readString();
                    String _arg315 = data.readString();
                    int _arg47 = data.readInt();
                    int _arg55 = data.readInt();
                    setDisplayTaskAnimation(_arg037, _arg132, _arg223, _arg315, _arg47, _arg55);
                    reply.writeNoException();
                    return true;
                case 40:
                    int _arg038 = data.readInt();
                    boolean _arg133 = data.readBoolean();
                    boolean _arg224 = data.readBoolean();
                    setDisplayFocusable(_arg038, _arg133, _arg224);
                    reply.writeNoException();
                    return true;
                case 41:
                    int _arg039 = data.readInt();
                    TaskSnapshot _result20 = getTaskSnapshot(_arg039);
                    reply.writeNoException();
                    reply.writeTypedObject(_result20, 1);
                    return true;
                case 42:
                    IBinder _arg040 = data.readStrongBinder();
                    int _arg134 = data.readInt();
                    Bitmap _arg225 = (Bitmap) data.readTypedObject(Bitmap.CREATOR);
                    boolean _arg316 = data.readBoolean();
                    boolean _arg48 = data.readBoolean();
                    overrideTaskSnapshot(_arg040, _arg134, _arg225, _arg316, _arg48);
                    reply.writeNoException();
                    return true;
                case 43:
                    IBinder _arg041 = data.readStrongBinder();
                    int _arg135 = data.readInt();
                    Rect _arg226 = (Rect) data.readTypedObject(Rect.CREATOR);
                    int _arg317 = data.readInt();
                    setTaskSnapshotBlurRegion(_arg041, _arg135, _arg226, _arg317);
                    reply.writeNoException();
                    return true;
                case 44:
                    String _arg042 = data.readString();
                    int _arg136 = data.readInt();
                    boolean _result21 = hasVisibleWindow(_arg042, _arg136);
                    reply.writeNoException();
                    reply.writeBoolean(_result21);
                    return true;
                case 45:
                    int _arg043 = data.readInt();
                    IDisplayUIListener _arg137 = IDisplayUIListener.Stub.asInterface(data.readStrongBinder());
                    registerDisplayUIListener(_arg043, _arg137);
                    reply.writeNoException();
                    return true;
                case 46:
                    int _arg044 = data.readInt();
                    IDisplayUIListener _arg138 = IDisplayUIListener.Stub.asInterface(data.readStrongBinder());
                    unregisterDisplayUIListener(_arg044, _arg138);
                    reply.writeNoException();
                    return true;
                case 47:
                    int _arg045 = data.readInt();
                    String _arg139 = data.readString();
                    int _arg227 = data.readInt();
                    setStartPackageInDisplay(_arg045, _arg139, _arg227);
                    reply.writeNoException();
                    return true;
                case 48:
                    int _arg046 = data.readInt();
                    int _arg140 = data.readInt();
                    int _arg228 = data.readInt();
                    moveTaskToBackInDisplay(_arg046, _arg140, _arg228);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_moveTopTaskToFrontInDisplay /* 49 */:
                    int _arg047 = data.readInt();
                    moveTopTaskToFrontInDisplay(_arg047);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setDisplayBackgroundColor /* 50 */:
                    int _arg048 = data.readInt();
                    int _arg141 = data.readInt();
                    setDisplayBackgroundColor(_arg048, _arg141);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_acquireWakeLockForDisplay /* 51 */:
                    int _arg049 = data.readInt();
                    boolean _result22 = acquireWakeLockForDisplay(_arg049);
                    reply.writeNoException();
                    reply.writeBoolean(_result22);
                    return true;
                case TRANSACTION_releaseWakeLockForDisplay /* 52 */:
                    int _arg050 = data.readInt();
                    releaseWakeLockForDisplay(_arg050);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_registerUIControllerUpdateListener /* 53 */:
                    int _arg051 = data.readInt();
                    IUIControllerUpdateListener _arg142 = IUIControllerUpdateListener.Stub.asInterface(data.readStrongBinder());
                    registerUIControllerUpdateListener(_arg051, _arg142);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_unregisterUIControllerUpdateListener /* 54 */:
                    int _arg052 = data.readInt();
                    IUIControllerUpdateListener _arg143 = IUIControllerUpdateListener.Stub.asInterface(data.readStrongBinder());
                    unregisterUIControllerUpdateListener(_arg052, _arg143);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_updateUIController /* 55 */:
                    IBinder _arg053 = data.readStrongBinder();
                    IWindow _arg054 = IWindow.Stub.asInterface(_arg053);
                    IUIController _arg144 = IUIController.Stub.asInterface(data.readStrongBinder());
                    updateUIController(_arg054, _arg144);
                    reply.writeNoException();
                    return true;
                case 56:
                    IBinder _arg055 = data.readStrongBinder();
                    SurfaceControl.Transaction _arg145 = (SurfaceControl.Transaction) data.readTypedObject(SurfaceControl.Transaction.CREATOR);
                    boolean _result23 = applyFinishTransaction(_arg055, _arg145);
                    reply.writeNoException();
                    reply.writeBoolean(_result23);
                    return true;
                case TRANSACTION_notifyTransitionMerged /* 57 */:
                    IBinder _arg056 = data.readStrongBinder();
                    IBinder _arg146 = data.readStrongBinder();
                    notifyTransitionMerged(_arg056, _arg146);
                    return true;
                case 58:
                    IBinder _arg057 = data.readStrongBinder();
                    IBinder _arg147 = data.readStrongBinder();
                    int _arg229 = data.readInt();
                    notifyTransitionRemoveTask(_arg057, _arg147, _arg229);
                    reply.writeNoException();
                    return true;
                case 59:
                    IBinder _arg058 = data.readStrongBinder();
                    boolean _arg148 = data.readBoolean();
                    notifyRecentsTransitionFinish(_arg058, _arg148);
                    reply.writeNoException();
                    return true;
                case 60:
                    IBinder _arg059 = data.readStrongBinder();
                    setRecentsTransitionInputCallback(IRecentsTransitionInputCallback.Stub.asInterface(_arg059));
                    reply.writeNoException();
                    return true;
                case 61:
                    IBinder _arg060 = data.readStrongBinder();
                    IBinder _arg149 = data.readStrongBinder();
                    int _arg230 = data.readInt();
                    notifyTaskBackToHome(_arg060, _arg149, _arg230);
                    reply.writeNoException();
                    return true;
                case 62:
                    int _arg061 = data.readInt();
                    int _arg150 = data.readInt();
                    switchResolution(_arg061, _arg150);
                    reply.writeNoException();
                    return true;
                case 63:
                    int _result24 = getResolutionType();
                    reply.writeNoException();
                    reply.writeInt(_result24);
                    return true;
                case 64:
                    boolean _arg062 = data.readBoolean();
                    setAutoResolutionEnabled(_arg062);
                    reply.writeNoException();
                    return true;
                case 65:
                    boolean _result25 = isAutoResolutionEnabled();
                    reply.writeNoException();
                    reply.writeBoolean(_result25);
                    return true;
                case 66:
                    String _arg063 = data.readString();
                    IBinder _result26 = getSubService(_arg063);
                    reply.writeNoException();
                    reply.writeStrongBinder(_result26);
                    return true;
                case 67:
                    int _arg064 = data.readInt();
                    int _arg151 = data.readInt();
                    setVirtualImeHeight(_arg064, _arg151);
                    reply.writeNoException();
                    return true;
                case 68:
                    int _arg065 = data.readInt();
                    boolean _result27 = isInputMethodQsEnable(_arg065);
                    reply.writeNoException();
                    reply.writeBoolean(_result27);
                    return true;
                case 69:
                    String _arg066 = data.readString();
                    IBinder _arg152 = data.readStrongBinder();
                    int _arg231 = data.readInt();
                    setLaunchCookie(_arg066, _arg152, _arg231);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_captureDisplay /* 70 */:
                    int _arg067 = data.readInt();
                    ScreenCapture.CaptureArgs _arg153 = (ScreenCapture.CaptureArgs) data.readTypedObject(ScreenCapture.CaptureArgs.CREATOR);
                    ScreenCapture.ScreenCaptureListener _arg232 = (ScreenCapture.ScreenCaptureListener) data.readTypedObject(ScreenCapture.ScreenCaptureListener.CREATOR);
                    int[] _arg318 = data.createIntArray();
                    captureDisplay(_arg067, _arg153, _arg232, _arg318);
                    return true;
                case TRANSACTION_startFreezingDisplay /* 71 */:
                    startFreezingDisplay();
                    reply.writeNoException();
                    return true;
                case 72:
                    stopFreezingDisplay();
                    reply.writeNoException();
                    return true;
                case 73:
                    int _arg068 = data.readInt();
                    int _arg154 = data.readInt();
                    int _arg233 = data.readInt();
                    setPendingForcedDensityForUser(_arg068, _arg154, _arg233);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_importanceUXHint /* 74 */:
                    int _arg069 = data.readInt();
                    int _arg155 = data.readInt();
                    importanceUXHint(_arg069, _arg155);
                    reply.writeNoException();
                    return true;
                case 75:
                    String _arg070 = data.readString();
                    float _arg156 = data.readFloat();
                    float _arg234 = data.readFloat();
                    addRefreshRateRangeForPackage(_arg070, _arg156, _arg234);
                    reply.writeNoException();
                    return true;
                case 76:
                    String _arg071 = data.readString();
                    removeRefreshRateRangeForPackage(_arg071);
                    reply.writeNoException();
                    return true;
                case 77:
                    boolean _arg072 = data.readBoolean();
                    setAllowRefreshRateSwitching(_arg072);
                    reply.writeNoException();
                    return true;
                case 78:
                    String _arg073 = data.readString();
                    int _arg157 = data.readInt();
                    IStepOSSystemGestureListener _arg235 = IStepOSSystemGestureListener.Stub.asInterface(data.readStrongBinder());
                    registerSystemGestureListener(_arg073, _arg157, _arg235);
                    reply.writeNoException();
                    return true;
                case 79:
                    String _arg074 = data.readString();
                    int _arg158 = data.readInt();
                    IStepOSSystemGestureListener _arg236 = IStepOSSystemGestureListener.Stub.asInterface(data.readStrongBinder());
                    unregisterSystemGestureListener(_arg074, _arg158, _arg236);
                    reply.writeNoException();
                    return true;
                case 80:
                    MotionEvent[] _arg075 = (MotionEvent[]) data.createTypedArray(MotionEvent.CREATOR);
                    int _arg159 = data.readInt();
                    scrollTopActivity(_arg075, _arg159);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_scrollTopActivityV2 /* 81 */:
                    MotionEvent[] _arg076 = (MotionEvent[]) data.createTypedArray(MotionEvent.CREATOR);
                    int _arg160 = data.readInt();
                    String _arg237 = data.readString();
                    scrollTopActivityV2(_arg076, _arg160, _arg237);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getTopActivityWindowIdentityHashCode /* 82 */:
                    String _result28 = getTopActivityWindowIdentityHashCode();
                    reply.writeNoException();
                    reply.writeString(_result28);
                    return true;
                case TRANSACTION_getLockWallpaperSurfaceRoot /* 83 */:
                    int _arg077 = data.readInt();
                    SurfaceControl _result29 = getLockWallpaperSurfaceRoot(_arg077);
                    reply.writeNoException();
                    reply.writeTypedObject(_result29, 1);
                    return true;
                case TRANSACTION_createStepOSEffect /* 84 */:
                    String _arg078 = data.readString();
                    long _result30 = createStepOSEffect(_arg078);
                    reply.writeNoException();
                    reply.writeLong(_result30);
                    return true;
                case TRANSACTION_moveAppToDisplay /* 85 */:
                    String _arg079 = data.readString();
                    int _arg161 = data.readInt();
                    boolean _arg238 = data.readBoolean();
                    moveAppToDisplay(_arg079, _arg161, _arg238);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_addOmniDisplayControlPackage /* 86 */:
                    String _arg080 = data.readString();
                    addOmniDisplayControlPackage(_arg080);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_removeOmniDisplayControlPackage /* 87 */:
                    String _arg081 = data.readString();
                    removeOmniDisplayControlPackage(_arg081);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getTopActivityIntent /* 88 */:
                    int _arg082 = data.readInt();
                    Intent _result31 = getTopActivityIntent(_arg082);
                    reply.writeNoException();
                    reply.writeTypedObject(_result31, 1);
                    return true;
                case TRANSACTION_getShowingDisplayId /* 89 */:
                    String _arg083 = data.readString();
                    int _result32 = getShowingDisplayId(_arg083);
                    reply.writeNoException();
                    reply.writeInt(_result32);
                    return true;
                case TRANSACTION_isOmniDisplayId /* 90 */:
                    String _arg084 = data.readString();
                    boolean _result33 = isOmniDisplayId(_arg084);
                    reply.writeNoException();
                    reply.writeBoolean(_result33);
                    return true;
                case TRANSACTION_registerOmniDisplayCallback /* 91 */:
                    IOmniDisplayCallback _arg085 = IOmniDisplayCallback.Stub.asInterface(data.readStrongBinder());
                    registerOmniDisplayCallback(_arg085);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_unregisterOmniDisplayCallback /* 92 */:
                    IOmniDisplayCallback _arg086 = IOmniDisplayCallback.Stub.asInterface(data.readStrongBinder());
                    unregisterOmniDisplayCallback(_arg086);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_isOmniDisplayImeEnabled /* 93 */:
                    int _arg087 = data.readInt();
                    boolean _result34 = isOmniDisplayImeEnabled(_arg087);
                    reply.writeNoException();
                    reply.writeBoolean(_result34);
                    return true;
                case TRANSACTION_setOmniDisplayImeEnabled /* 94 */:
                    int _arg088 = data.readInt();
                    boolean _arg162 = data.readBoolean();
                    setOmniDisplayImeEnabled(_arg088, _arg162);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_isOmniDisplayTakeover /* 95 */:
                    int _arg089 = data.readInt();
                    boolean _result35 = isOmniDisplayTakeover(_arg089);
                    reply.writeNoException();
                    reply.writeBoolean(_result35);
                    return true;
                case TRANSACTION_setOmniDisplayTakeover /* 96 */:
                    int _arg090 = data.readInt();
                    boolean _arg163 = data.readBoolean();
                    setOmniDisplayTakeover(_arg090, _arg163);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_omniCall /* 97 */:
                    String _arg091 = data.readString();
                    Bundle _arg164 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    Bundle _result36 = omniCall(_arg091, _arg164);
                    reply.writeNoException();
                    reply.writeTypedObject(_result36, 1);
                    return true;
                case TRANSACTION_takeScreenshotWithScaleResult /* 98 */:
                    int _arg092 = data.readInt();
                    int _arg165 = data.readInt();
                    String _arg239 = data.readString();
                    float _arg319 = data.readFloat();
                    Bundle _result37 = takeScreenshotWithScaleResult(_arg092, _arg165, _arg239, _arg319);
                    reply.writeNoException();
                    reply.writeTypedObject(_result37, 1);
                    return true;
                case TRANSACTION_takeScreenshot /* 99 */:
                    int _arg093 = data.readInt();
                    int _arg166 = data.readInt();
                    String _arg240 = data.readString();
                    Bitmap _result38 = takeScreenshot(_arg093, _arg166, _arg240);
                    reply.writeNoException();
                    reply.writeTypedObject(_result38, 1);
                    return true;
                case 100:
                    int _arg094 = data.readInt();
                    int _arg167 = data.readInt();
                    String _arg241 = data.readString();
                    float _arg320 = data.readFloat();
                    Bitmap _result39 = takeScreenshotWithScale(_arg094, _arg167, _arg241, _arg320);
                    reply.writeNoException();
                    reply.writeTypedObject(_result39, 1);
                    return true;
                case 101:
                    String _arg095 = data.readString();
                    List _result40 = getAllColorBarInfo(_arg095);
                    reply.writeNoException();
                    reply.writeList(_result40);
                    return true;
                case 102:
                    int _arg096 = data.readInt();
                    int _arg168 = data.readInt();
                    boolean _result41 = isWindowModeDragging(_arg096, _arg168);
                    reply.writeNoException();
                    reply.writeBoolean(_result41);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSWindowManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSWindowManager.DESCRIPTOR;
            }

            @Override // stepos.app.IStepOSWindowManager
            public void registerAppEventsListener(IAppEventListener callback, int flags) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    _data.writeInt(flags);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void unRegisterAppEventsListener(IAppEventListener callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void registerWindowModeListener(int displayId, int windowingMode, IWindowModeCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(windowingMode);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void unregisterWindowModeListener(int displayId, int windowingMode, IWindowModeCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(windowingMode);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public Rect getWindowModeBound(int displayId, int taskId, int windowingMode, boolean pending, int displayRotation, boolean baseBound) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    _data.writeInt(windowingMode);
                    _data.writeBoolean(pending);
                    _data.writeInt(displayRotation);
                    _data.writeBoolean(baseBound);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    Rect _result = (Rect) _reply.readTypedObject(Rect.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void moveWindowModeBound(int displayId, int taskId, int windowingMode, Rect showFrame, float[] matrix1, float[] matrix2, boolean anim, boolean canShowStrokeLayer) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    _data.writeInt(windowingMode);
                    _data.writeTypedObject(showFrame, 0);
                    _data.writeFloatArray(matrix1);
                    _data.writeFloatArray(matrix2);
                    _data.writeBoolean(anim);
                    _data.writeBoolean(canShowStrokeLayer);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public Point covertWindowModeCoordinate(int displayId, int taskId, int windowingMode, Point point) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    _data.writeInt(windowingMode);
                    _data.writeTypedObject(point, 0);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    Point _result = (Point) _reply.readTypedObject(Point.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean isWindowMode(int displayId, int taskId, int windowingMode, IBinder token) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    _data.writeInt(windowingMode);
                    _data.writeStrongBinder(token);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean isClipSystemBarByWindowMode(int displayId, int taskId, int systemBarType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    _data.writeInt(systemBarType);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean needWindowModeCaptionBackground(int displayId, int taskId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public int getVirtualWindowingMode(IBinder token) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public int getVirtualWindowingModeByTask(int displayId, int taskId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void updateWindowModeShowState(int displayId, int taskId, int windowingMode, boolean show, boolean nextChange) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    _data.writeInt(windowingMode);
                    _data.writeBoolean(show);
                    _data.writeBoolean(nextChange);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void closeWindowMode(int displayId, int taskId, int windowingMode, boolean anim) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    _data.writeInt(windowingMode);
                    _data.writeBoolean(anim);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void enterWindowMode(int displayId, int taskId, int oldWindowingMode, int newWindowingMode, Rect showBound, float cornerRadius, boolean anim) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    _data.writeInt(oldWindowingMode);
                    _data.writeInt(newWindowingMode);
                    _data.writeTypedObject(showBound, 0);
                    _data.writeFloat(cornerRadius);
                    _data.writeBoolean(anim);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void switchWindowModeToMaxMode(int displayId, int taskId, int windowingMode, boolean maxMode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    _data.writeInt(windowingMode);
                    _data.writeBoolean(maxMode);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean flingWindowMode(int displayId, int taskId, int windowingMode, float velocityX, float velocityY, Point startPosition) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    _data.writeInt(windowingMode);
                    _data.writeFloat(velocityX);
                    _data.writeFloat(velocityY);
                    _data.writeTypedObject(startPosition, 0);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setAvoidZone(int displayId, int windowingMode, String packageName, Rect avoidZone) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(windowingMode);
                    _data.writeString(packageName);
                    _data.writeTypedObject(avoidZone, 0);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setStartWindowMode(int displayId, String packageName, int delaySecond) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeString(packageName);
                    _data.writeInt(delaySecond);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setTaskNotToBack(int displayId, int taskId, boolean notToBack) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    _data.writeBoolean(notToBack);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean isTaskNotToBack(int displayId, int taskId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    this.mRemote.transact(21, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean isWindowModeBlackList(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(22, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public List<String> getWindowModeBlackList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    this.mRemote.transact(23, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public List<String> getWindowModeWhiteList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    this.mRemote.transact(24, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setAppMuted(int displayId, String packageName, int uid, boolean muted) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeString(packageName);
                    _data.writeInt(uid);
                    _data.writeBoolean(muted);
                    this.mRemote.transact(25, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean isAppMuted(int displayId, String packageName, int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeString(packageName);
                    _data.writeInt(uid);
                    this.mRemote.transact(26, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void getWindowModeTouchOffset(IWindow window, float[] values) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeFloatArray(values);
                    this.mRemote.transact(27, _data, _reply, 0);
                    _reply.readException();
                    _reply.readFloatArray(values);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean hasWindowingModeTasks(int display, int[] windowmodes) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(display);
                    _data.writeIntArray(windowmodes);
                    this.mRemote.transact(28, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void goBackPreviousWindowMode(int displayId, int taskId, int currentWindowMode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    _data.writeInt(currentWindowMode);
                    this.mRemote.transact(29, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public List<ActivityManager.RunningTaskInfo> getFilteredTasks(int maxNum, boolean filterOnlyVisibleRecents, boolean keepIntentExtra, int ignoreWindowingMode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(maxNum);
                    _data.writeBoolean(filterOnlyVisibleRecents);
                    _data.writeBoolean(keepIntentExtra);
                    _data.writeInt(ignoreWindowingMode);
                    this.mRemote.transact(30, _data, _reply, 0);
                    _reply.readException();
                    List<ActivityManager.RunningTaskInfo> _result = _reply.createTypedArrayList(ActivityManager.RunningTaskInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public List<ActivityManager.RunningTaskInfo> getTaskInfos(int[] taskIds) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeIntArray(taskIds);
                    this.mRemote.transact(31, _data, _reply, 0);
                    _reply.readException();
                    List<ActivityManager.RunningTaskInfo> _result = _reply.createTypedArrayList(ActivityManager.RunningTaskInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void sendResultToActivity(ActivityInfo info, ResultInfo result) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeTypedObject(info, 0);
                    _data.writeTypedObject(result, 0);
                    this.mRemote.transact(32, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean removeTaskNotKillProcess(int displayId, int taskId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    this.mRemote.transact(33, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setTaskDeferResume(int taskId, boolean deferResume, String reason) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(taskId);
                    _data.writeBoolean(deferResume);
                    _data.writeString(reason);
                    this.mRemote.transact(34, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setLockOrientationForSensor(int displayId, boolean lock) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeBoolean(lock);
                    this.mRemote.transact(35, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean isLockOrientationForSensor(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(36, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean isFeatureOpen(int displayId, int uid, String displayName, int feature) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(uid);
                    _data.writeString(displayName);
                    _data.writeInt(feature);
                    this.mRemote.transact(37, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setFeatureOpen(int displayId, int uid, String displayName, int[] feature, boolean open) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(uid);
                    _data.writeString(displayName);
                    _data.writeIntArray(feature);
                    _data.writeBoolean(open);
                    this.mRemote.transact(38, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setDisplayTaskAnimation(int displayId, int uid, String displayName, String packageName, int exitResId, int enterResId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(uid);
                    _data.writeString(displayName);
                    _data.writeString(packageName);
                    _data.writeInt(exitResId);
                    _data.writeInt(enterResId);
                    this.mRemote.transact(39, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setDisplayFocusable(int displayId, boolean focusable, boolean requestFocus) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeBoolean(focusable);
                    _data.writeBoolean(requestFocus);
                    this.mRemote.transact(40, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public TaskSnapshot getTaskSnapshot(int taskId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(taskId);
                    this.mRemote.transact(41, _data, _reply, 0);
                    _reply.readException();
                    TaskSnapshot _result = (TaskSnapshot) _reply.readTypedObject(TaskSnapshot.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void overrideTaskSnapshot(IBinder token, int taskId, Bitmap bitmap, boolean notifyChange, boolean forever) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeInt(taskId);
                    _data.writeTypedObject(bitmap, 0);
                    _data.writeBoolean(notifyChange);
                    _data.writeBoolean(forever);
                    this.mRemote.transact(42, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setTaskSnapshotBlurRegion(IBinder token, int taskId, Rect region, int radius) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeInt(taskId);
                    _data.writeTypedObject(region, 0);
                    _data.writeInt(radius);
                    this.mRemote.transact(43, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean hasVisibleWindow(String packageName, int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(displayId);
                    this.mRemote.transact(44, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void registerDisplayUIListener(int displayId, IDisplayUIListener callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(45, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void unregisterDisplayUIListener(int displayId, IDisplayUIListener callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(46, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setStartPackageInDisplay(int displayId, String packageName, int delaySecond) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeString(packageName);
                    _data.writeInt(delaySecond);
                    this.mRemote.transact(47, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void moveTaskToBackInDisplay(int taskId, int oldDisplayId, int newDisplayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(taskId);
                    _data.writeInt(oldDisplayId);
                    _data.writeInt(newDisplayId);
                    this.mRemote.transact(48, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void moveTopTaskToFrontInDisplay(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(Stub.TRANSACTION_moveTopTaskToFrontInDisplay, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setDisplayBackgroundColor(int displayId, int color) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(color);
                    this.mRemote.transact(Stub.TRANSACTION_setDisplayBackgroundColor, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean acquireWakeLockForDisplay(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(Stub.TRANSACTION_acquireWakeLockForDisplay, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void releaseWakeLockForDisplay(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(Stub.TRANSACTION_releaseWakeLockForDisplay, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void registerUIControllerUpdateListener(int displayId, IUIControllerUpdateListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(Stub.TRANSACTION_registerUIControllerUpdateListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void unregisterUIControllerUpdateListener(int displayId, IUIControllerUpdateListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(Stub.TRANSACTION_unregisterUIControllerUpdateListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void updateUIController(IWindow window, IUIController uiController) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeStrongInterface(uiController);
                    this.mRemote.transact(Stub.TRANSACTION_updateUIController, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean applyFinishTransaction(IBinder transitionToken, SurfaceControl.Transaction t) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeStrongBinder(transitionToken);
                    _data.writeTypedObject(t, 0);
                    this.mRemote.transact(56, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void notifyTransitionMerged(IBinder playing, IBinder merged) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeStrongBinder(playing);
                    _data.writeStrongBinder(merged);
                    this.mRemote.transact(Stub.TRANSACTION_notifyTransitionMerged, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void notifyTransitionRemoveTask(IBinder playing, IBinder merged, int removeTaskId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeStrongBinder(playing);
                    _data.writeStrongBinder(merged);
                    _data.writeInt(removeTaskId);
                    this.mRemote.transact(58, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void notifyRecentsTransitionFinish(IBinder playing, boolean toHome) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeStrongBinder(playing);
                    _data.writeBoolean(toHome);
                    this.mRemote.transact(59, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setRecentsTransitionInputCallback(IRecentsTransitionInputCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(60, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void notifyTaskBackToHome(IBinder playing, IBinder merged, int removeTaskId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeStrongBinder(playing);
                    _data.writeStrongBinder(merged);
                    _data.writeInt(removeTaskId);
                    this.mRemote.transact(61, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void switchResolution(int width, int height) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(width);
                    _data.writeInt(height);
                    this.mRemote.transact(62, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public int getResolutionType() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    this.mRemote.transact(63, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setAutoResolutionEnabled(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeBoolean(enabled);
                    this.mRemote.transact(64, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean isAutoResolutionEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    this.mRemote.transact(65, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public IBinder getSubService(String serviceName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeString(serviceName);
                    this.mRemote.transact(66, _data, _reply, 0);
                    _reply.readException();
                    IBinder _result = _reply.readStrongBinder();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setVirtualImeHeight(int displayId, int height) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(height);
                    this.mRemote.transact(67, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean isInputMethodQsEnable(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(68, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setLaunchCookie(String packageName, IBinder launchCookie, int delaySecond) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeStrongBinder(launchCookie);
                    _data.writeInt(delaySecond);
                    this.mRemote.transact(69, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void captureDisplay(int displayId, ScreenCapture.CaptureArgs captureArgs, ScreenCapture.ScreenCaptureListener listener, int[] excludeWindowTypes) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeTypedObject(captureArgs, 0);
                    _data.writeTypedObject(listener, 0);
                    _data.writeIntArray(excludeWindowTypes);
                    this.mRemote.transact(Stub.TRANSACTION_captureDisplay, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void startFreezingDisplay() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_startFreezingDisplay, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void stopFreezingDisplay() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    this.mRemote.transact(72, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setPendingForcedDensityForUser(int displayId, int density, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(density);
                    _data.writeInt(userId);
                    this.mRemote.transact(73, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void importanceUXHint(int type, int duration) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeInt(duration);
                    this.mRemote.transact(Stub.TRANSACTION_importanceUXHint, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void addRefreshRateRangeForPackage(String packageName, float minRefreshRate, float maxRefreshRate) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeFloat(minRefreshRate);
                    _data.writeFloat(maxRefreshRate);
                    this.mRemote.transact(75, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void removeRefreshRateRangeForPackage(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(76, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setAllowRefreshRateSwitching(boolean allow) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeBoolean(allow);
                    this.mRemote.transact(77, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void registerSystemGestureListener(String pkg, int gesture, IStepOSSystemGestureListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeInt(gesture);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(78, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void unregisterSystemGestureListener(String pkg, int gesture, IStepOSSystemGestureListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeInt(gesture);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(79, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void scrollTopActivity(MotionEvent[] event, int value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeTypedArray(event, 0);
                    _data.writeInt(value);
                    this.mRemote.transact(80, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void scrollTopActivityV2(MotionEvent[] event, int value, String windowIdentityHashCode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeTypedArray(event, 0);
                    _data.writeInt(value);
                    _data.writeString(windowIdentityHashCode);
                    this.mRemote.transact(Stub.TRANSACTION_scrollTopActivityV2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public String getTopActivityWindowIdentityHashCode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTopActivityWindowIdentityHashCode, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public SurfaceControl getLockWallpaperSurfaceRoot(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(Stub.TRANSACTION_getLockWallpaperSurfaceRoot, _data, _reply, 0);
                    _reply.readException();
                    SurfaceControl _result = (SurfaceControl) _reply.readTypedObject(SurfaceControl.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public long createStepOSEffect(String shader) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeString(shader);
                    this.mRemote.transact(Stub.TRANSACTION_createStepOSEffect, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void moveAppToDisplay(String packageName, int displayId, boolean top) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(displayId);
                    _data.writeBoolean(top);
                    this.mRemote.transact(Stub.TRANSACTION_moveAppToDisplay, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void addOmniDisplayControlPackage(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(Stub.TRANSACTION_addOmniDisplayControlPackage, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void removeOmniDisplayControlPackage(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(Stub.TRANSACTION_removeOmniDisplayControlPackage, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public Intent getTopActivityIntent(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(Stub.TRANSACTION_getTopActivityIntent, _data, _reply, 0);
                    _reply.readException();
                    Intent _result = (Intent) _reply.readTypedObject(Intent.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public int getShowingDisplayId(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(Stub.TRANSACTION_getShowingDisplayId, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean isOmniDisplayId(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(Stub.TRANSACTION_isOmniDisplayId, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void registerOmniDisplayCallback(IOmniDisplayCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(Stub.TRANSACTION_registerOmniDisplayCallback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void unregisterOmniDisplayCallback(IOmniDisplayCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(Stub.TRANSACTION_unregisterOmniDisplayCallback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean isOmniDisplayImeEnabled(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(Stub.TRANSACTION_isOmniDisplayImeEnabled, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setOmniDisplayImeEnabled(int displayId, boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeBoolean(enabled);
                    this.mRemote.transact(Stub.TRANSACTION_setOmniDisplayImeEnabled, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean isOmniDisplayTakeover(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(Stub.TRANSACTION_isOmniDisplayTakeover, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public void setOmniDisplayTakeover(int displayId, boolean takeover) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeBoolean(takeover);
                    this.mRemote.transact(Stub.TRANSACTION_setOmniDisplayTakeover, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public Bundle omniCall(String key, Bundle params) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeTypedObject(params, 0);
                    this.mRemote.transact(Stub.TRANSACTION_omniCall, _data, _reply, 0);
                    _reply.readException();
                    Bundle _result = (Bundle) _reply.readTypedObject(Bundle.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public Bundle takeScreenshotWithScaleResult(int displayId, int mode, String pkgName, float scale) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(mode);
                    _data.writeString(pkgName);
                    _data.writeFloat(scale);
                    this.mRemote.transact(Stub.TRANSACTION_takeScreenshotWithScaleResult, _data, _reply, 0);
                    _reply.readException();
                    Bundle _result = (Bundle) _reply.readTypedObject(Bundle.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public Bitmap takeScreenshot(int displayId, int mode, String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(mode);
                    _data.writeString(pkgName);
                    this.mRemote.transact(Stub.TRANSACTION_takeScreenshot, _data, _reply, 0);
                    _reply.readException();
                    Bitmap _result = (Bitmap) _reply.readTypedObject(Bitmap.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public Bitmap takeScreenshotWithScale(int displayId, int mode, String pkgName, float scale) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(mode);
                    _data.writeString(pkgName);
                    _data.writeFloat(scale);
                    this.mRemote.transact(100, _data, _reply, 0);
                    _reply.readException();
                    Bitmap _result = (Bitmap) _reply.readTypedObject(Bitmap.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public List getAllColorBarInfo(String pkg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeString(pkg);
                    this.mRemote.transact(101, _data, _reply, 0);
                    _reply.readException();
                    ClassLoader cl = getClass().getClassLoader();
                    List _result = _reply.readArrayList(cl);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWindowManager
            public boolean isWindowModeDragging(int displayId, int taskId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWindowManager.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    this.mRemote.transact(102, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 101;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> value, int parcelableFlags) {
            if (value == null) {
                parcel.writeInt(-1);
                return;
            }
            int N = value.size();
            parcel.writeInt(N);
            for (int i = 0; i < N; i++) {
                parcel.writeTypedObject(value.get(i), parcelableFlags);
            }
        }
    }
}
