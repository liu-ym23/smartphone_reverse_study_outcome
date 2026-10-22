package com.android.server.wm;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.util.ArraySet;
import android.util.Pair;
import android.util.SparseArray;
import android.view.ContentRecordingSession;
import android.view.Display;
import android.view.IInputFilter;
import android.view.IRemoteAnimationFinishedCallback;
import android.view.IWindow;
import android.view.MagnificationSpec;
import android.view.RemoteAnimationTarget;
import android.view.SurfaceControl;
import android.view.SurfaceControlViewHost;
import android.view.inputmethod.ImeTracker;
import android.window.ScreenCapture;
import com.android.internal.policy.KeyInterceptionInfo;
import com.android.server.input.InputManagerService;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: loaded from: classes3.dex */
public abstract class WindowManagerInternal implements IZteWindowManagerInternal.IZteWindowManagerInternalExport {
    private final IZteWindowManagerInternal mZteWm;

    public interface AccessibilityControllerInternal {

        public interface UiChangesForAccessibilityCallbacks {
            void onRectangleOnScreenRequested(int r1, int r2, int r3, int r4, int r5);
        }

        boolean isAccessibilityTracingEnabled();

        void logTrace(String r1, long r2, String r4, byte[] r5, int r6, StackTraceElement[] r7, long r8, int r10, long r11, Set<String> r13);

        void logTrace(String r1, long r2, String r4, byte[] r5, int r6, StackTraceElement[] r7, Set<String> r8);

        void setUiChangesForAccessibilityCallbacks(UiChangesForAccessibilityCallbacks r1);

        void startTrace(long r1);

        void stopTrace();
    }

    public static abstract class AppTransitionListener {
        public final int mTargetDisplayId;

        public AppTransitionListener() {
            this(-1);
        }

        public AppTransitionListener(int displayId) {
            this.mTargetDisplayId = displayId;
        }

        public void onAppTransitionPendingLocked() {
        }

        public void onAppTransitionCancelledLocked(boolean keyguardGoingAwayCancelled) {
        }

        public void onAppTransitionTimeoutLocked() {
        }

        public int onAppTransitionStartingLocked(long statusBarAnimationStartTime, long statusBarAnimationDuration) {
            return 0;
        }

        public void onAppTransitionFinishedLocked(IBinder token) {
        }
    }

    public interface IDragDropCallback {
        static /* synthetic */ Boolean $r8$lambda$6yNQikD5pZ5UQHacgGeb_pDSRTc(InputManagerService r0, IBinder r1, DragState r2, Void r3) {
            return lambda$registerInputChannel$0(r0, r1, r2, r3);
        }

        default CompletableFuture<Boolean> registerInputChannel(final DragState state, Display display, final InputManagerService service, final IBinder sourceInputChannelToken) {
            return state.register(display).thenApply(new WindowManagerInternal$IDragDropCallback$$ExternalSyntheticLambda0(service, sourceInputChannelToken, state));
        }

        private static /* synthetic */ Boolean lambda$registerInputChannel$0(InputManagerService service, IBinder sourceInputChannelToken, DragState state, Void unused) {
            return Boolean.valueOf(service.startDragAndDrop(sourceInputChannelToken, state.getInputToken()));
        }

        default boolean prePerformDrag(IWindow window, IBinder dragToken, int touchSource, float touchX, float touchY, float thumbCenterX, float thumbCenterY, ClipData data) {
            return true;
        }

        default void postPerformDrag() {
        }

        default void preReportDropResult(IWindow window, boolean consumed) {
        }

        default void postReportDropResult() {
        }

        default void preCancelDragAndDrop(IBinder dragToken) {
        }

        default void postCancelDragAndDrop() {
        }

        default void dragRecipientEntered(IWindow window) {
        }

        default void dragRecipientExited(IWindow window) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImeClientFocusResult {
        public static final int AUTO_VIRTUAL_OBRIC = -4;
        public static final int DISPLAY_ID_MISMATCH = -2;
        public static final int HAS_IME_FOCUS = 0;
        public static final int INVALID_DISPLAY_ID = -3;
        public static final int NOT_IME_TARGET_WINDOW = -1;
        public static final int OBRIC_IGNORE = -5;
    }

    public static class ImeTargetInfo {
        public final String focusedWindowName;
        public final String imeControlTargetName;
        public final String imeLayerTargetName;
        public final String imeSurfaceParentName;
        public final String requestWindowName;

        public ImeTargetInfo(String focusedWindowName, String requestWindowName, String imeControlTargetName, String imeLayerTargetName, String imeSurfaceParentName) {
            this.focusedWindowName = focusedWindowName;
            this.requestWindowName = requestWindowName;
            this.imeControlTargetName = imeControlTargetName;
            this.imeLayerTargetName = imeLayerTargetName;
            this.imeSurfaceParentName = imeSurfaceParentName;
        }
    }

    public interface KeyguardExitAnimationStartListener {
        void onAnimationStart(RemoteAnimationTarget[] r1, RemoteAnimationTarget[] r2, IRemoteAnimationFinishedCallback r3);
    }

    public interface MagnificationCallbacks {
        void onDisplaySizeChanged();

        void onImeWindowVisibilityChanged(boolean r1);

        void onMagnificationRegionChanged(Region r1);

        void onRectangleOnScreenRequested(int r1, int r2, int r3, int r4);

        void onUserContextChanged();
    }

    public interface OnHardKeyboardStatusChangeListener {
        void onHardKeyboardStatusChange(boolean r1);
    }

    public interface OnImeRequestedChangedListener {
        void onImeRequestedChanged(IBinder r1, boolean r2, ImeTracker.Token r3);
    }

    public interface OnWindowRemovedListener {
        void onWindowRemoved(IBinder r1);
    }

    public interface TaskSystemBarsListener {
        void onTransientSystemBarsVisibilityChanged(int r1, boolean r2, boolean r3);
    }

    public interface WindowFocusChangeListener {
        void focusChanged(IBinder r1);
    }

    public interface WindowsForAccessibilityCallback {
        void onAccessibilityWindowsChanged(boolean r1, int r2, IBinder r3, Point r4, List<AccessibilityWindowsPopulator.AccessibilityWindow> r5);
    }

    public abstract void addBlockScreenCaptureForApps(ArraySet<SensitiveContentPackages.PackageInfo> r1);

    public abstract void addRefreshRateRangeForPackage(String r1, float r2, float r3);

    public abstract void addTrustedTaskOverlay(int r1, SurfaceControlViewHost.SurfacePackage r2);

    public abstract void addWindowToken(IBinder r1, int r2, int r3, Bundle r4);

    public abstract void captureDisplay(int r1, ScreenCapture.CaptureArgs r2, ScreenCapture.ScreenCaptureListener r3);

    public abstract void clearBlockedApps();

    public abstract void clearDisplaySettings(String r1, int r2);

    public abstract void clearForcedDisplaySize(int r1);

    public abstract void clearSnapshotCache();

    public abstract void computeWindowsForAccessibility(int r1);

    public abstract SurfaceControl getA11yOverlayLayer(int r1);

    public abstract AccessibilityControllerInternal getAccessibilityController();

    public abstract int getDisplayIdForWindow(IBinder r1);

    public abstract int getDisplayImePolicy(int r1);

    public abstract IBinder getFocusedWindowToken();

    public abstract IBinder getFocusedWindowTokenFromWindowStates();

    public abstract SurfaceControl getHandwritingSurfaceForDisplay(int r1);

    public abstract int getInputMethodWindowVisibleHeight(int r1);

    public abstract ExtWindowManagerInternal getInternalExt();

    public abstract KeyInterceptionInfo getKeyInterceptionInfoFromToken(IBinder r1);

    public abstract void getMagnificationRegion(int r1, Region r2);

    public abstract IObricWindowManagerInternal getObricWindowManagerInternal();

    public abstract float getResolutionScaleByToken(IBinder r1);

    public abstract IBinder getTargetWindowTokenFromInputToken(IBinder r1);

    public abstract int getTopFocusedDisplayId();

    public abstract Context getTopFocusedDisplayUiContext();

    public abstract void getWindowFrame(IBinder r1, Rect r2);

    public abstract String getWindowName(IBinder r1);

    public abstract int getWindowOwnerUserId(IBinder r1);

    public abstract Pair<Matrix, MagnificationSpec> getWindowTransformationMatrixAndMagnificationSpec(IBinder r1);

    public abstract int hasInputMethodClientFocus(IBinder r1, int r2, int r3, int r4);

    public abstract boolean hasNavigationBar(int r1);

    public abstract void hideIme(IBinder r1, int r2, ImeTracker.Token r3);

    public abstract boolean isHardKeyboardAvailable();

    public abstract boolean isHomeSupportedOnDisplay(int r1);

    public abstract boolean isKeyguardLocked();

    public abstract boolean isKeyguardSecure(int r1);

    public abstract boolean isKeyguardShowingAndNotOccluded();

    public abstract boolean isPointInsideWindow(IBinder r1, int r2, float r3, float r4);

    public abstract boolean isTouchOrFaketouchDevice();

    public abstract boolean isUidAllowedOnDisplay(int r1, int r2);

    public abstract boolean isUidFocused(int r1);

    public abstract void lockNow();

    public abstract void moveDisplayToTopIfAllowed(int r1);

    public abstract boolean moveFocusToAdjacentEmbeddedActivityIfNeeded();

    public abstract void moveWindowTokenToDisplay(IBinder r1, int r2);

    public abstract void onDisplayManagerReceivedDeviceState(int r1);

    public abstract ImeTargetInfo onToggleImeRequested(boolean r1, IBinder r2, IBinder r3, int r4);

    public abstract void registerAppTransitionListener(AppTransitionListener r1);

    public abstract void registerDragDropControllerCallback(IDragDropCallback r1);

    public abstract void registerOnWindowRemovedListener(OnWindowRemovedListener r1);

    public abstract void registerTaskSystemBarsListener(TaskSystemBarsListener r1);

    public abstract void registerWindowFocusChangeListener(WindowFocusChangeListener r1);

    public abstract void removeBlockScreenCaptureForApps(ArraySet<SensitiveContentPackages.PackageInfo> r1);

    public abstract void removeRefreshRateRangeForPackage(String r1);

    public abstract void removeTrustedTaskOverlay(int r1, SurfaceControlViewHost.SurfacePackage r2);

    public abstract void removeWindowToken(IBinder r1, boolean r2, boolean r3, int r4);

    public abstract void reportPasswordChanged(int r1);

    public abstract void requestTraversalFromDisplayManager();

    public abstract void requestWindowFocus(IBinder r1);

    public abstract void setAccessibilityIdToSurfaceMetadata(IBinder r1, int r2);

    public abstract void setBlockScreenCaptureForAppsSessionId(long r1);

    public abstract boolean setContentRecordingSession(ContentRecordingSession r1);

    public abstract void setDismissImeOnBackKeyPressed(boolean r1);

    public abstract void setForcedDisplaySize(int r1, int r2, int r3);

    public abstract void setFullscreenMagnificationActivated(int r1, boolean r2);

    public abstract void setHomeSupportedOnDisplay(String r1, int r2, boolean r3);

    public abstract void setIgnoreActivitySizeRestrictionsOnDisplay(String r1, int r2, boolean r3);

    public abstract void setInputFilter(IInputFilter r1);

    public abstract boolean setMagnificationCallbacks(int r1, MagnificationCallbacks r2);

    public abstract void setMagnificationSpec(int r1, MagnificationSpec r2);

    public abstract void setNonDefaultDisplayRotation(int r1, int r2, String r3);

    public abstract void setOnHardKeyboardStatusChangeListener(OnHardKeyboardStatusChangeListener r1);

    public abstract void setOnImeRequestedChangedListener(OnImeRequestedChangedListener r1);

    public abstract void setOrientationRequestPolicy(boolean r1, int[] r2, int[] r3);

    public abstract void setResolutionScaleByPkgName(String r1, float r2);

    public abstract void setVr2dDisplayId(int r1);

    public abstract void setWallpaperCropHints(IBinder r1, SparseArray<Rect> r2);

    public abstract void setWallpaperShowWhenLocked(IBinder r1, boolean r2);

    public abstract void setWindowsForAccessibilityCallback(int r1, WindowsForAccessibilityCallback r2);

    public abstract boolean shouldRestoreImeVisibility(IBinder r1);

    public abstract void showGlobalActions();

    public abstract void showImePostLayout(IBinder r1, ImeTracker.Token r2);

    public abstract ScreenCapture.ScreenshotHardwareBuffer takeAssistScreenshot();

    public abstract ScreenCapture.ScreenshotHardwareBuffer takeContextualSearchScreenshot(int r1);

    public abstract void unregisterOnWindowRemovedListener(OnWindowRemovedListener r1);

    public abstract void unregisterTaskSystemBarsListener(TaskSystemBarsListener r1);

    public abstract void unregisterWindowFocusChangeListener(WindowFocusChangeListener r1);

    public abstract void updateInputMethodTargetWindow(IBinder r1);

    public abstract void waitForAllWindowsDrawn(Message r1, long r2, int r4);

    WindowManagerInternal(RootWindowContainer root) {
        this.mZteWm = new ZteWindowManagerInternalImpl(root);
    }

    @Override // com.android.server.wm.IZteWindowManagerInternal.IZteWindowManagerInternalExport
    public IZteWindowManagerInternal getZteInjectInstance() {
        return this.mZteWm;
    }

    public final void removeWindowToken(IBinder token, boolean removeWindows, int displayId) {
        removeWindowToken(token, removeWindows, true, displayId);
    }
}
