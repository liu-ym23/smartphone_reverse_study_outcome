package com.android.server.accessibility;

import android.graphics.Point;
import android.graphics.Region;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.SparseArray;
import android.view.IWindow;
import android.view.WindowInfo;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityWindowAttributes;
import android.view.accessibility.AccessibilityWindowInfo;
import android.view.accessibility.IAccessibilityInteractionConnection;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.wm.AccessibilityWindowsPopulator;
import com.android.server.wm.WindowManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityWindowManager {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "AccessibilityWindowManager";
    private static final boolean VERBOSE = false;
    private static int sNextWindowId;
    private final AccessibilityEventSender mAccessibilityEventSender;
    private long mAccessibilityFocusNodeId;
    private int mAccessibilityFocusedDisplayId;
    private int mAccessibilityFocusedWindowId;
    private final AccessibilitySecurityPolicy.AccessibilityUserManager mAccessibilityUserManager;
    private int mActiveWindowId;
    private final SparseArray<DisplayWindowsObserver> mDisplayWindowsObservers;
    private final SparseArray<RemoteAccessibilityConnection> mGlobalInteractionConnections;
    private final SparseArray<IBinder> mGlobalWindowTokens;
    private final Handler mHandler;
    private boolean mHasProxy;
    private final ArrayMap<IBinder, IBinder> mHostEmbeddedMap;
    private final SparseArray<SparseArray<RemoteAccessibilityConnection>> mInteractionConnections;
    private int mLastNonProxyTopFocusedDisplayId;
    private final Object mLock;
    private RemoteAccessibilityConnection mPictureInPictureActionReplacingConnection;
    private final AccessibilitySecurityPolicy mSecurityPolicy;
    private final Region mTmpRegion;
    private int mTopFocusedDisplayId;
    private int mTopFocusedWindowId;
    private IBinder mTopFocusedWindowToken;
    private boolean mTouchInteractionInProgress;
    private final AccessibilityTraceManager mTraceManager;
    private final SparseArray<AccessibilityWindowAttributes> mWindowAttributes;
    private final SparseArray<IBinder> mWindowIdMap;
    private final WindowManagerInternal mWindowManagerInternal;
    private final SparseArray<SparseArray<IBinder>> mWindowTokens;

    public interface AccessibilityEventSender {
        void sendAccessibilityEventForCurrentUserLocked(AccessibilityEvent r1);
    }

    private final class DisplayWindowsObserver implements WindowManagerInternal.WindowsForAccessibilityCallback {
        private final SparseArray<AccessibilityWindowInfo> mA11yWindowInfoById;
        private final List<WindowInfo> mCachedWindowInfos;
        private final int mDisplayId;
        private boolean mHasWatchOutsideTouchWindow;
        private boolean mIsProxy;
        private int mProxyDisplayAccessibilityFocusedWindow;
        private boolean mTrackingWindows;
        private final SparseArray<WindowInfo> mWindowInfoById;
        private List<AccessibilityWindowInfo> mWindows;
        final /* synthetic */ AccessibilityWindowManager this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmDisplayId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m661$$Nest$fgetmDisplayId(DisplayWindowsObserver r0) {
            return r0.mDisplayId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIsProxy, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m662$$Nest$fgetmIsProxy(DisplayWindowsObserver r0) {
            return r0.mIsProxy;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmProxyDisplayAccessibilityFocusedWindow, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m663$$Nest$fgetmProxyDisplayAccessibilityFocusedWindow(DisplayWindowsObserver r0) {
            return r0.mProxyDisplayAccessibilityFocusedWindow;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmWindows, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m664$$Nest$fgetmWindows(DisplayWindowsObserver r0) {
            return r0.mWindows;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmIsProxy, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m665$$Nest$fputmIsProxy(DisplayWindowsObserver r0, boolean r1) {
            r0.mIsProxy = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmProxyDisplayAccessibilityFocusedWindow, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m666$$Nest$fputmProxyDisplayAccessibilityFocusedWindow(DisplayWindowsObserver r0, int r1) {
            r0.mProxyDisplayAccessibilityFocusedWindow = r1;
        }

        DisplayWindowsObserver(AccessibilityWindowManager r1, int displayId) {
            this.this$0 = r1;
            this.mA11yWindowInfoById = new SparseArray();
            this.mWindowInfoById = new SparseArray();
            this.mCachedWindowInfos = new ArrayList();
            this.mTrackingWindows = false;
            this.mProxyDisplayAccessibilityFocusedWindow = -1;
            this.mDisplayId = displayId;
        }

        void startTrackingWindowsLocked() {
            if (this.mTrackingWindows == true) goto L9;
            this.mTrackingWindows = true;
            if (AccessibilityWindowManager.m660$$Nest$mtraceWMEnabled(this.this$0) == false) goto L7;
            AccessibilityWindowManager.m658$$Nest$mlogTraceWM(this.this$0, "setWindowsForAccessibilityCallback", "displayId=" + this.mDisplayId + ";callback=" + this);
        L7:
            AccessibilityWindowManager.m650$$Nest$fgetmWindowManagerInternal(this.this$0).setWindowsForAccessibilityCallback(this.mDisplayId, this);
            return;
        }

        void stopTrackingWindowsLocked() {
            if (this.mTrackingWindows == true) goto L5;
            return;
        L5:
            if (AccessibilityWindowManager.m660$$Nest$mtraceWMEnabled(this.this$0) == false) goto L7;
            AccessibilityWindowManager.m658$$Nest$mlogTraceWM(this.this$0, "setWindowsForAccessibilityCallback", "displayId=" + this.mDisplayId + ";callback=null");
        L7:
            AccessibilityWindowManager.m650$$Nest$fgetmWindowManagerInternal(this.this$0).setWindowsForAccessibilityCallback(this.mDisplayId, null);
            this.mTrackingWindows = false;
            clearWindowsLocked();
        }

        boolean isTrackingWindowsLocked() {
            return this.mTrackingWindows;
        }

        List<AccessibilityWindowInfo> getWindowListLocked() {
            return this.mWindows;
        }

        AccessibilityWindowInfo findA11yWindowInfoByIdLocked(int windowId) {
            return this.mA11yWindowInfoById.get(windowId);
        }

        WindowInfo findWindowInfoByIdLocked(int windowId) {
            return this.mWindowInfoById.get(windowId);
        }

        AccessibilityWindowInfo getPictureInPictureWindowLocked() {
            if (this.mWindows == null) goto L10;
            int windowCount = this.mWindows.size();
            int i = 0;
        L5:
            if (i >= windowCount) goto L14;
            AccessibilityWindowInfo window = this.mWindows.get(i);
            if (window.isInPictureInPictureMode() == true) goto L8;
            i = i + 1;
            goto L5
        L8:
            return window;
        L14:
            return null;
        L10:
            return null;
        }

        boolean setActiveWindowLocked(int windowId) {
            boolean foundWindow = false;
            if (this.mWindows == null) goto L11;
            int windowCount = this.mWindows.size();
            int i = 0;
        L5:
            if (i >= windowCount) goto L11;
            AccessibilityWindowInfo window = this.mWindows.get(i);
            if (window.getId() != windowId) goto L9;
            window.setActive(true);
            foundWindow = true;
        L10:
            i = i + 1;
            goto L5
        L9:
            window.setActive(false);
        L11:
            return foundWindow;
        }

        boolean setAccessibilityFocusedWindowLocked(int windowId) {
            boolean foundWindow = false;
            if (this.mWindows == null) goto L11;
            int windowCount = this.mWindows.size();
            int i = 0;
        L5:
            if (i >= windowCount) goto L11;
            AccessibilityWindowInfo window = this.mWindows.get(i);
            if (window.getId() != windowId) goto L9;
            window.setAccessibilityFocused(true);
            foundWindow = true;
        L10:
            i = i + 1;
            goto L5
        L9:
            window.setAccessibilityFocused(false);
        L11:
            return foundWindow;
        }

        boolean computePartialInteractiveRegionForWindowLocked(int windowId, boolean forceComputeRegion, Region outRegion) {
            if (this.mWindows != null) goto L6;
            return false;
        L6:
            Region windowInteractiveRegion = null;
            boolean windowInteractiveRegionChanged = false;
            int windowCount = this.mWindows.size();
            Region currentWindowRegions = new Region();
            int i = windowCount - 1;
        L7:
            if (i < 0) goto L22;
            AccessibilityWindowInfo currentWindow = this.mWindows.get(i);
            if (windowInteractiveRegion != null) goto L16;
            if (currentWindow.getId() != windowId) goto L20;
            currentWindow.getRegionInScreen(currentWindowRegions);
            outRegion.set(currentWindowRegions);
            windowInteractiveRegion = outRegion;
            if (forceComputeRegion == false) goto L20;
            windowInteractiveRegionChanged = true;
        L20:
            i = i - 1;
            goto L7
        L16:
            if (currentWindow.getType() == 4) goto L20;
            currentWindow.getRegionInScreen(currentWindowRegions);
            if (windowInteractiveRegion.op(currentWindowRegions, Region.Op.DIFFERENCE) == false) goto L20;
            windowInteractiveRegionChanged = true;
            goto L20
        L22:
            return windowInteractiveRegionChanged;
        }

        List<Integer> getWatchOutsideTouchWindowIdLocked(int targetWindowId) {
            WindowInfo targetWindow = this.mWindowInfoById.get(targetWindowId);
            if (targetWindow == null) goto L20;
            if (this.mHasWatchOutsideTouchWindow == false) goto L20;
            List<Integer> outsideWindowsId = new ArrayList();
            int i = 0;
        L8:
            if (i >= this.mWindowInfoById.size()) goto L18;
            WindowInfo window = this.mWindowInfoById.valueAt(i);
            if (window == null) goto L16;
            if (window.layer >= targetWindow.layer) goto L16;
            if (window.hasFlagWatchOutsideTouch == false) goto L16;
            outsideWindowsId.add(Integer.valueOf(this.mWindowInfoById.keyAt(i)));
        L16:
            i = i + 1;
            goto L8
        L18:
            return outsideWindowsId;
        L20:
            return Collections.emptyList();
        }

        @Override // com.android.server.wm.WindowManagerInternal.WindowsForAccessibilityCallback
        public void onAccessibilityWindowsChanged(boolean forceSend, int topFocusedDisplayId, IBinder topFocusedWindowToken, Point screenSize, List<AccessibilityWindowsPopulator.AccessibilityWindow> accessibilityWindows) {
            Object r0 = AccessibilityWindowManager.m643$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            List<WindowInfo> windows = createWindowInfoListLocked(screenSize, accessibilityWindows);     // Catch: Throwable -> L9
            if (forceSend == true) goto L11;
            if (shouldUpdateWindowsLocked(windows) == true) goto L11;
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            AccessibilityWindowManager.m653$$Nest$fputmTopFocusedDisplayId(this.this$0, topFocusedDisplayId);     // Catch: Throwable -> L9
            if (AccessibilityWindowManager.m657$$Nest$misProxyed(this.this$0, topFocusedDisplayId) == true) goto L14;
            AccessibilityWindowManager.m652$$Nest$fputmLastNonProxyTopFocusedDisplayId(this.this$0, topFocusedDisplayId);     // Catch: Throwable -> L9
        L14:
            AccessibilityWindowManager.m655$$Nest$fputmTopFocusedWindowToken(this.this$0, topFocusedWindowToken);     // Catch: Throwable -> L9
            cacheWindows(windows);     // Catch: Throwable -> L9
            updateWindowsLocked(AccessibilityWindowManager.m641$$Nest$fgetmAccessibilityUserManager(this.this$0).getCurrentUserIdLocked(), windows);     // Catch: Throwable -> L9
            AccessibilityWindowManager.m643$$Nest$fgetmLock(this.this$0).notifyAll();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ String lambda$onAccessibilityWindowsChanged$0(WindowInfo w) {
            return "{displayId=" + w.displayId + ", title=" + w.title + "}";
        }

        private List<WindowInfo> createWindowInfoListLocked(Point screenSize, List<AccessibilityWindowsPopulator.AccessibilityWindow> visibleWindows) {
            Set<IBinder> addedWindows = new ArraySet();
            List<WindowInfo> windows = new ArrayList();
            Region regionInWindow = new Region();
            Region touchableRegionInScreen = new Region();
            int userId = AccessibilityWindowManager.m641$$Nest$fgetmAccessibilityUserManager(this.this$0).getCurrentUserIdLocked();
            boolean focusedWindowAdded = false;
            Region unaccountedSpace = new Region(0, 0, screenSize.x, screenSize.y);
            Iterator<AccessibilityWindowsPopulator.AccessibilityWindow> r7 = visibleWindows.iterator();
        L4:
            if (r7.hasNext() == false) goto L27;
            AccessibilityWindowsPopulator.AccessibilityWindow a11yWindow = r7.next();
            a11yWindow.getTouchableRegionInWindow(regionInWindow);
            WindowInfo window = a11yWindow.getWindowInfo();
            if (window.token == null) goto L8;
            int windowId = this.this$0.findWindowIdLocked(userId, window.token);
        L10:
            if (windowMattersToAccessibilityLocked(a11yWindow, windowId, regionInWindow, unaccountedSpace) == false) goto L18;
            if (windowId < 0) goto L14;
            window.regionInScreen.set(regionInWindow);
            window.layer = addedWindows.size();
            updateWindowWithWindowAttributes(window, (AccessibilityWindowAttributes) AccessibilityWindowManager.m649$$Nest$fgetmWindowAttributes(this.this$0).get(windowId));
            windows.add(window);
            addedWindows.add(window.token);
        L14:
            if (windowMattersToUnaccountedSpaceComputation(a11yWindow) == false) goto L16;
            a11yWindow.getTouchableRegionInScreen(touchableRegionInScreen);
            unaccountedSpace.op(touchableRegionInScreen, unaccountedSpace, Region.Op.REVERSE_DIFFERENCE);
        L16:
            focusedWindowAdded = focusedWindowAdded | a11yWindow.isFocused();
        L23:
            if (unaccountedSpace.isEmpty() == false) goto L4;
            if (focusedWindowAdded == false) goto L4;
        L18:
            if (a11yWindow.isUntouchableNavigationBar() == false) goto L23;
            if (a11yWindow.getSystemBarInsetsFrame() == null) goto L23;
            unaccountedSpace.op(a11yWindow.getSystemBarInsetsFrame(), unaccountedSpace, Region.Op.REVERSE_DIFFERENCE);
            goto L23
        L8:
            windowId = -1;
        L27:
            Iterator<WindowInfo> r8 = windows.iterator();
        L29:
            if (r8.hasNext() == false) goto L42;
            WindowInfo window2 = r8.next();
            if (addedWindows.contains(window2.parentToken) == true) goto L34;
            window2.parentToken = null;
        L34:
            if (window2.childTokens == null) goto L29;
            int childTokenCount = window2.childTokens.size();
            int j = childTokenCount - 1;
        L36:
            if (j < 0) goto L29;
            if (addedWindows.contains(window2.childTokens.get(j)) == true) goto L40;
            window2.childTokens.remove(j);
        L40:
            j = j - 1;
            goto L36
        L42:
            return windows;
        }

        private boolean windowMattersToAccessibilityLocked(AccessibilityWindowsPopulator.AccessibilityWindow a11yWindow, int windowId, Region regionInScreen, Region unaccountedSpace) {
            if (a11yWindow.isFocused() == false) goto L6;
            return true;
        L6:
            if (a11yWindow.isTouchable() == true) goto L13;
            if (a11yWindow.getType() == 2034) goto L13;
            if (a11yWindow.isPIPMenu() == true) goto L13;
            return false;
        L13:
            if (this.this$0.isEmbeddedHierarchyWindowsLocked(windowId) == false) goto L16;
            return false;
        L16:
            if (AccessibilityWindowManager.m644$$Nest$fgetmTmpRegion(this.this$0).op(unaccountedSpace, regionInScreen, Region.Op.INTERSECT) == true) goto L19;
            return false;
        L19:
            if (isReportedWindowType(a11yWindow.getType()) == false) goto L21;
            return true;
        L21:
            return false;
        }

        private static boolean isReportedWindowType(int windowType) {
            if (windowType != 2013) goto L5;
        L23:
            return false;
        L5:
            if (windowType == 2021) goto L23;
            if (windowType == 2026) goto L23;
            if (windowType == 2016) goto L23;
            if (windowType == 2022) goto L23;
            if (windowType == 2018) goto L23;
            if (windowType == 2027) goto L23;
            if (windowType == 1004) goto L23;
            if (windowType == 2015) goto L23;
            if (windowType == 2030) goto L23;
            return true;
        }

        private static boolean windowMattersToUnaccountedSpaceComputation(AccessibilityWindowsPopulator.AccessibilityWindow a11yWindow) {
            if (a11yWindow.isTouchable() == true) goto L10;
            if (a11yWindow.getType() == 2034) goto L10;
            if (a11yWindow.isTrustedOverlay() == false) goto L10;
            return false;
        L10:
            if (a11yWindow.getType() != 2032) goto L12;
            return false;
        L12:
            return true;
        }

        private void updateWindowWithWindowAttributes(WindowInfo windowInfo, AccessibilityWindowAttributes attributes) {
            if (attributes != null) goto L4;
            return;
        L4:
            windowInfo.title = attributes.getWindowTitle();
            windowInfo.locales = attributes.getLocales();
        }

        private boolean shouldUpdateWindowsLocked(List<WindowInfo> windows) {
            int windowCount = windows.size();
            if (this.mCachedWindowInfos.size() == windowCount) goto L6;
            return true;
        L6:
            if (this.mCachedWindowInfos.isEmpty() == true) goto L8;
        L9:
            int i = 0;
        L10:
            if (i >= windowCount) goto L19;
            WindowInfo oldWindow = this.mCachedWindowInfos.get(i);
            WindowInfo newWindow = windows.get(i);
            if (windowChangedNoLayer(oldWindow, newWindow) == true) goto L13;
            i = i + 1;
            goto L10
        L13:
            return true;
        L19:
            return false;
        L8:
            if (windows.isEmpty() == false) goto L9;
            return false;
        }

        private void cacheWindows(List<WindowInfo> windows) {
            int oldWindowCount = this.mCachedWindowInfos.size();
            int i = oldWindowCount - 1;
        L3:
            if (i < 0) goto L5;
            this.mCachedWindowInfos.remove(i).recycle();
            i = i - 1;
            goto L3
        L5:
            int newWindowCount = windows.size();
            int i2 = 0;
        L6:
            if (i2 >= newWindowCount) goto L9;
            WindowInfo newWindow = windows.get(i2);
            this.mCachedWindowInfos.add(WindowInfo.obtain(newWindow));
            i2 = i2 + 1;
            goto L6
        }

        private boolean windowChangedNoLayer(WindowInfo oldWindow, WindowInfo newWindow) {
            if (oldWindow != newWindow) goto L6;
            return false;
        L6:
            if (oldWindow != null) goto L8;
            return true;
        L8:
            if (newWindow != null) goto L11;
            return true;
        L11:
            if (oldWindow.type == newWindow.type) goto L14;
            return true;
        L14:
            if (oldWindow.focused == newWindow.focused) goto L17;
            return true;
        L17:
            if (oldWindow.token != null) goto L22;
            if (newWindow.token == null) goto L25;
            return true;
        L25:
            if (oldWindow.parentToken != null) goto L30;
            if (newWindow.parentToken == null) goto L33;
            return true;
        L33:
            if (oldWindow.activityToken != null) goto L38;
            if (newWindow.activityToken == null) goto L41;
            return true;
        L41:
            if (oldWindow.regionInScreen.equals(newWindow.regionInScreen) == true) goto L44;
            return true;
        L44:
            if (oldWindow.childTokens == null) goto L51;
            if (newWindow.childTokens == null) goto L51;
            if (oldWindow.childTokens.equals(newWindow.childTokens) == true) goto L51;
            return true;
        L51:
            if (TextUtils.equals(oldWindow.title, newWindow.title) == true) goto L54;
            return true;
        L54:
            if (oldWindow.accessibilityIdOfAnchor == newWindow.accessibilityIdOfAnchor) goto L57;
            return true;
        L57:
            if (oldWindow.inPictureInPicture == newWindow.inPictureInPicture) goto L60;
            return true;
        L60:
            if (oldWindow.hasFlagWatchOutsideTouch == newWindow.hasFlagWatchOutsideTouch) goto L63;
            return true;
        L63:
            if (oldWindow.displayId == newWindow.displayId) goto L66;
            return true;
        L66:
            if (oldWindow.taskId == newWindow.taskId) goto L69;
            return true;
        L69:
            if (Arrays.equals(oldWindow.mTransformMatrix, newWindow.mTransformMatrix) == true) goto L71;
            return true;
        L71:
            return false;
        L38:
            if (oldWindow.activityToken.equals(newWindow.activityToken) == true) goto L41;
            return true;
        L30:
            if (oldWindow.parentToken.equals(newWindow.parentToken) == true) goto L33;
            return true;
        L22:
            if (oldWindow.token.equals(newWindow.token) == true) goto L25;
            return true;
        }

        private void clearWindowsLocked() {
            List<WindowInfo> windows = Collections.emptyList();
            int activeWindowId = AccessibilityWindowManager.m642$$Nest$fgetmActiveWindowId(this.this$0);
            updateWindowsLocked(AccessibilityWindowManager.m641$$Nest$fgetmAccessibilityUserManager(this.this$0).getCurrentUserIdLocked(), windows);
            AccessibilityWindowManager.m651$$Nest$fputmActiveWindowId(this.this$0, activeWindowId);
            this.mWindows = null;
        }

        private void updateWindowsLocked(int userId, List<WindowInfo> windows) {
            int r1 = userId;
            if (this.mWindows != null) goto L5;
            this.mWindows = new ArrayList();
        L5:
            List<AccessibilityWindowInfo> oldWindowList = new ArrayList(this.mWindows);
            SparseArray<AccessibilityWindowInfo> oldWindowsById = this.mA11yWindowInfoById.clone();
            boolean shouldClearAccessibilityFocus = false;
            this.mWindows.clear();
            this.mA11yWindowInfoById.clear();
            int i = 0;
        L7:
            if (i >= this.mWindowInfoById.size()) goto L9;
            this.mWindowInfoById.valueAt(i).recycle();
            i = i + 1;
            goto L7
        L9:
            this.mWindowInfoById.clear();
            boolean r5 = false;
            this.mHasWatchOutsideTouchWindow = false;
            int windowCount = windows.size();
            if (this.mDisplayId != AccessibilityWindowManager.m645$$Nest$fgetmTopFocusedDisplayId(this.this$0)) goto L12;
            boolean isTopFocusedDisplay = true;
        L14:
            if (this.mDisplayId != AccessibilityWindowManager.m639$$Nest$fgetmAccessibilityFocusedDisplayId(this.this$0)) goto L16;
        L21:
            boolean isAccessibilityFocusedDisplay = true;
        L22:
            if (isTopFocusedDisplay == false) goto L29;
            if (windowCount <= 0) goto L25;
            AccessibilityWindowManager.m654$$Nest$fputmTopFocusedWindowId(this.this$0, this.this$0.findWindowIdLocked(r1, AccessibilityWindowManager.m647$$Nest$fgetmTopFocusedWindowToken(this.this$0)));
        L27:
            if (AccessibilityWindowManager.m648$$Nest$fgetmTouchInteractionInProgress(this.this$0) == true) goto L29;
            AccessibilityWindowManager.m651$$Nest$fputmActiveWindowId(this.this$0, -1);
            goto L29
        L25:
            AccessibilityWindowManager.m654$$Nest$fputmTopFocusedWindowId(this.this$0, -1);
        L29:
            boolean activeWindowGone = true;
            if (this.mIsProxy == false) goto L32;
            int a11yFocusedWindowId = this.mProxyDisplayAccessibilityFocusedWindow;
        L34:
            if (isAccessibilityFocusedDisplay == false) goto L38;
            if (a11yFocusedWindowId == (-1)) goto L37;
            r5 = true;
        L37:
            shouldClearAccessibilityFocus = r5;
        L38:
            if (windowCount <= 0) goto L80;
            if (this.mTrackingWindows == false) goto L60;
            int i2 = 0;
        L42:
            if (i2 >= windowCount) goto L60;
            WindowInfo windowInfo = windows.get(i2);
            AccessibilityWindowInfo window = populateReportedWindowLocked(r1, windowInfo, oldWindowsById);
            window.setLayer((windowCount - 1) - window.getLayer());
            int windowId = window.getId();
            if (window.isFocused() == false) goto L53;
            if (isTopFocusedDisplay == false) goto L53;
            if (AccessibilityWindowManager.m648$$Nest$fgetmTouchInteractionInProgress(this.this$0) == true) goto L50;
            AccessibilityWindowManager.m651$$Nest$fputmActiveWindowId(this.this$0, windowId);
            window.setActive(true);
            goto L53
        L50:
            if (windowId != AccessibilityWindowManager.m642$$Nest$fgetmActiveWindowId(this.this$0)) goto L53;
            activeWindowGone = false;
        L53:
            if (this.mHasWatchOutsideTouchWindow == true) goto L57;
            if (windowInfo.hasFlagWatchOutsideTouch == false) goto L57;
            this.mHasWatchOutsideTouchWindow = true;
        L57:
            this.mWindows.add(window);
            this.mA11yWindowInfoById.put(windowId, window);
            this.mWindowInfoById.put(windowId, WindowInfo.obtain(windowInfo));
            i2 = i2 + 1;
            r1 = userId;
        L60:
            int accessibilityWindowCount = this.mWindows.size();
            if (isTopFocusedDisplay == true) goto L63;
        L72:
            if (isAccessibilityFocusedDisplay == false) goto L80;
            int i3 = 0;
        L74:
            if (i3 >= accessibilityWindowCount) goto L80;
            AccessibilityWindowInfo window2 = this.mWindows.get(i3);
            if (window2.getId() == a11yFocusedWindowId) goto L77;
            i3 = i3 + 1;
            goto L74
        L77:
            window2.setAccessibilityFocused(true);
            shouldClearAccessibilityFocus = false;
            goto L80
        L63:
            if (AccessibilityWindowManager.m648$$Nest$fgetmTouchInteractionInProgress(this.this$0) == false) goto L66;
            if (activeWindowGone == false) goto L66;
            AccessibilityWindowManager.m651$$Nest$fputmActiveWindowId(this.this$0, AccessibilityWindowManager.m646$$Nest$fgetmTopFocusedWindowId(this.this$0));
        L66:
            int i4 = 0;
        L67:
            if (i4 >= accessibilityWindowCount) goto L72;
            AccessibilityWindowInfo window3 = this.mWindows.get(i4);
            if (window3.getId() != AccessibilityWindowManager.m642$$Nest$fgetmActiveWindowId(this.this$0)) goto L71;
            window3.setActive(true);
        L71:
            i4 = i4 + 1;
        L80:
            sendEventsForChangedWindowsLocked(oldWindowList, oldWindowsById);
            int oldWindowCount = oldWindowList.size();
            int i5 = oldWindowCount - 1;
        L81:
            if (i5 < 0) goto L84;
            oldWindowList.remove(i5).recycle();
            i5 = i5 - 1;
            goto L81
        L84:
            if (shouldClearAccessibilityFocus == false) goto L98;
            AccessibilityWindowManager.m656$$Nest$mclearAccessibilityFocusLocked(this.this$0, a11yFocusedWindowId);
            return;
        L98:
            return;
        L32:
            a11yFocusedWindowId = AccessibilityWindowManager.m640$$Nest$fgetmAccessibilityFocusedWindowId(this.this$0);
            goto L34
        L16:
            if (this.mIsProxy == true) goto L18;
        L20:
            isAccessibilityFocusedDisplay = false;
            goto L22
        L18:
            if (this.mProxyDisplayAccessibilityFocusedWindow == (-1)) goto L20;
        L12:
            isTopFocusedDisplay = false;
            goto L14
        }

        private void sendEventsForChangedWindowsLocked(List<AccessibilityWindowInfo> oldWindows, SparseArray<AccessibilityWindowInfo> oldWindowsById) {
            List<AccessibilityEvent> events = new ArrayList();
            int oldWindowsCount = oldWindows.size();
            int i = 0;
        L3:
            if (i >= oldWindowsCount) goto L8;
            AccessibilityWindowInfo window = oldWindows.get(i);
            if (this.mA11yWindowInfoById.get(window.getId()) != null) goto L7;
            events.add(AccessibilityEvent.obtainWindowsChangedEvent(this.mDisplayId, window.getId(), 2));
        L7:
            i = i + 1;
            goto L3
        L8:
            int newWindowCount = this.mWindows.size();
            int i2 = 0;
        L9:
            if (i2 >= newWindowCount) goto L17;
            AccessibilityWindowInfo newWindow = this.mWindows.get(i2);
            AccessibilityWindowInfo oldWindow = oldWindowsById.get(newWindow.getId());
            if (oldWindow != null) goto L13;
            events.add(AccessibilityEvent.obtainWindowsChangedEvent(this.mDisplayId, newWindow.getId(), 1));
        L16:
            i2 = i2 + 1;
            goto L9
        L13:
            int changes = newWindow.differenceFrom(oldWindow);
            if (changes == 0) goto L16;
            events.add(AccessibilityEvent.obtainWindowsChangedEvent(this.mDisplayId, newWindow.getId(), changes));
            goto L16
        L17:
            int numEvents = events.size();
            int i3 = 0;
        L18:
            if (i3 >= numEvents) goto L21;
            AccessibilityWindowManager.m638$$Nest$fgetmAccessibilityEventSender(this.this$0).sendAccessibilityEventForCurrentUserLocked(events.get(i3));
            i3 = i3 + 1;
            goto L18
        }

        private AccessibilityWindowInfo populateReportedWindowLocked(int userId, WindowInfo window, SparseArray<AccessibilityWindowInfo> oldWindowsById) {
            int windowId = this.this$0.findWindowIdLocked(userId, window.token);
            AccessibilityWindowInfo reportedWindow = AccessibilityWindowInfo.obtain();
            reportedWindow.setId(windowId);
            reportedWindow.setType(getTypeForWindowManagerWindowType(window.type));
            reportedWindow.setLayer(window.layer);
            reportedWindow.setFocused(window.focused);
            reportedWindow.setRegionInScreen(window.regionInScreen);
            reportedWindow.setTitle(window.title);
            reportedWindow.setAnchorId(window.accessibilityIdOfAnchor);
            reportedWindow.setPictureInPicture(window.inPictureInPicture);
            reportedWindow.setDisplayId(window.displayId);
            reportedWindow.setTaskId(window.taskId);
            reportedWindow.setLocales(window.locales);
            int parentId = this.this$0.findWindowIdLocked(userId, window.parentToken);
            if (parentId < 0) goto L6;
            reportedWindow.setParentId(parentId);
        L6:
            if (window.childTokens == null) goto L13;
            int childCount = window.childTokens.size();
            int i = 0;
        L8:
            if (i >= childCount) goto L13;
            IBinder childToken = (IBinder) window.childTokens.get(i);
            int childId = this.this$0.findWindowIdLocked(userId, childToken);
            if (childId < 0) goto L12;
            reportedWindow.addChild(childId);
        L12:
            i = i + 1;
        L13:
            AccessibilityWindowInfo oldWindowInfo = oldWindowsById.get(windowId);
            if (oldWindowInfo != null) goto L16;
            reportedWindow.setTransitionTimeMillis(SystemClock.uptimeMillis());
        L20:
            return reportedWindow;
        L16:
            Region oldTouchRegion = new Region();
            oldWindowInfo.getRegionInScreen(oldTouchRegion);
            if (oldTouchRegion.equals(window.regionInScreen) == false) goto L19;
            reportedWindow.setTransitionTimeMillis(oldWindowInfo.getTransitionTimeMillis());
            goto L20
        L19:
            reportedWindow.setTransitionTimeMillis(SystemClock.uptimeMillis());
            goto L20
        }

        private int getTypeForWindowManagerWindowType(int windowType) {
            switch(windowType) {
                case 1: goto L15;
                case 2: goto L15;
                case 3: goto L15;
                case 4: goto L15;
                case 1000: goto L15;
                case 1001: goto L15;
                case 1002: goto L15;
                case 1003: goto L15;
                case 1005: goto L15;
                case 2000: goto L13;
                case 2001: goto L13;
                case 2002: goto L15;
                case 2003: goto L13;
                case 2005: goto L15;
                case 2006: goto L13;
                case 2007: goto L15;
                case 2008: goto L13;
                case 2009: goto L13;
                case 2010: goto L13;
                case 2011: goto L11;
                case 2012: goto L15;
                case 2017: goto L13;
                case 2019: goto L13;
                case 2020: goto L13;
                case 2024: goto L13;
                case 2032: goto L9;
                case 2034: goto L7;
                case 2036: goto L13;
                case 2038: goto L13;
                case 2039: goto L5;
                case 2040: goto L13;
                case 2041: goto L13;
                default: goto L3;
            };
        L3:
            return -1;
        L5:
            return 6;
        L7:
            return 5;
        L9:
            return 4;
        L11:
            return 2;
        L13:
            return 3;
        L15:
            return 1;
        }

        void dumpLocked(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (this.mIsProxy == false) goto L6;
            pw.println("Proxy accessibility focused window = " + this.mProxyDisplayAccessibilityFocusedWindow);
            pw.println();
        L6:
            if (this.mWindows == null) goto L22;
            int windowCount = this.mWindows.size();
            int j = 0;
        L8:
            if (j >= windowCount) goto L17;
            if (j != 0) goto L11;
            pw.append("Display[");
            pw.append(Integer.toString(this.mDisplayId));
            pw.append("] : ");
            pw.println();
        L11:
            if (j <= 0) goto L13;
            pw.append(',');
            pw.println();
        L13:
            pw.append("A11yWindow[");
            AccessibilityWindowInfo window = this.mWindows.get(j);
            pw.append(window.toString());
            pw.append(']');
            pw.println();
            WindowInfo windowInfo = findWindowInfoByIdLocked(window.getId());
            if (windowInfo == null) goto L16;
            pw.append("WindowInfo[");
            pw.append(windowInfo.toString());
            pw.append("]");
            pw.println();
        L16:
            j = j + 1;
            goto L8
        L17:
            pw.println();
            return;
        }
    }

    public final class RemoteAccessibilityConnection implements IBinder.DeathRecipient {
        private final IAccessibilityInteractionConnection mConnection;
        private final String mPackageName;
        private final int mUid;
        private final int mUserId;
        private final int mWindowId;
        final /* synthetic */ AccessibilityWindowManager this$0;

        RemoteAccessibilityConnection(AccessibilityWindowManager this$0, int windowId, IAccessibilityInteractionConnection connection, String packageName, int uid, int userId) {
            this.this$0 = this$0;
            this.mWindowId = windowId;
            this.mPackageName = packageName;
            this.mUid = uid;
            this.mUserId = userId;
            this.mConnection = connection;
        }

        int getUid() {
            return this.mUid;
        }

        String getPackageName() {
            return this.mPackageName;
        }

        IAccessibilityInteractionConnection getRemote() {
            return this.mConnection;
        }

        void linkToDeath() throws RemoteException {
            this.mConnection.asBinder().linkToDeath(this, 0);
        }

        void unlinkToDeath() {
            this.mConnection.asBinder().unlinkToDeath(this, 0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            unlinkToDeath();
            Object r0 = AccessibilityWindowManager.m643$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            AccessibilityWindowManager.m659$$Nest$mremoveAccessibilityInteractionConnectionLocked(this.this$0, this.mWindowId, this.mUserId);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$YhP75-7wzMSIl7oTi9YhSqMv54o, reason: not valid java name */
    public static /* synthetic */ void m637$r8$lambda$YhP757wzMSIl7oTi9YhSqMv54o(AccessibilityWindowManager r0, int r1, int r2) {
        r0.clearAccessibilityFocusMainThread(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAccessibilityEventSender, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccessibilityEventSender m638$$Nest$fgetmAccessibilityEventSender(AccessibilityWindowManager r0) {
        return r0.mAccessibilityEventSender;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAccessibilityFocusedDisplayId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m639$$Nest$fgetmAccessibilityFocusedDisplayId(AccessibilityWindowManager r0) {
        return r0.mAccessibilityFocusedDisplayId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAccessibilityFocusedWindowId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m640$$Nest$fgetmAccessibilityFocusedWindowId(AccessibilityWindowManager r0) {
        return r0.mAccessibilityFocusedWindowId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAccessibilityUserManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccessibilitySecurityPolicy.AccessibilityUserManager m641$$Nest$fgetmAccessibilityUserManager(AccessibilityWindowManager r0) {
        return r0.mAccessibilityUserManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveWindowId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m642$$Nest$fgetmActiveWindowId(AccessibilityWindowManager r0) {
        return r0.mActiveWindowId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m643$$Nest$fgetmLock(AccessibilityWindowManager r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTmpRegion, reason: not valid java name */
    static /* bridge */ /* synthetic */ Region m644$$Nest$fgetmTmpRegion(AccessibilityWindowManager r0) {
        return r0.mTmpRegion;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTopFocusedDisplayId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m645$$Nest$fgetmTopFocusedDisplayId(AccessibilityWindowManager r0) {
        return r0.mTopFocusedDisplayId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTopFocusedWindowId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m646$$Nest$fgetmTopFocusedWindowId(AccessibilityWindowManager r0) {
        return r0.mTopFocusedWindowId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTopFocusedWindowToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m647$$Nest$fgetmTopFocusedWindowToken(AccessibilityWindowManager r0) {
        return r0.mTopFocusedWindowToken;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTouchInteractionInProgress, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m648$$Nest$fgetmTouchInteractionInProgress(AccessibilityWindowManager r0) {
        return r0.mTouchInteractionInProgress;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowAttributes, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m649$$Nest$fgetmWindowAttributes(AccessibilityWindowManager r0) {
        return r0.mWindowAttributes;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerInternal m650$$Nest$fgetmWindowManagerInternal(AccessibilityWindowManager r0) {
        return r0.mWindowManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmActiveWindowId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m651$$Nest$fputmActiveWindowId(AccessibilityWindowManager r0, int r1) {
        r0.mActiveWindowId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastNonProxyTopFocusedDisplayId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m652$$Nest$fputmLastNonProxyTopFocusedDisplayId(AccessibilityWindowManager r0, int r1) {
        r0.mLastNonProxyTopFocusedDisplayId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTopFocusedDisplayId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m653$$Nest$fputmTopFocusedDisplayId(AccessibilityWindowManager r0, int r1) {
        r0.mTopFocusedDisplayId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTopFocusedWindowId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m654$$Nest$fputmTopFocusedWindowId(AccessibilityWindowManager r0, int r1) {
        r0.mTopFocusedWindowId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTopFocusedWindowToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m655$$Nest$fputmTopFocusedWindowToken(AccessibilityWindowManager r0, IBinder r1) {
        r0.mTopFocusedWindowToken = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mclearAccessibilityFocusLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m656$$Nest$mclearAccessibilityFocusLocked(AccessibilityWindowManager r0, int r1) {
        r0.clearAccessibilityFocusLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misProxyed, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m657$$Nest$misProxyed(AccessibilityWindowManager r0, int r1) {
        return r0.isProxyed(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mlogTraceWM, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m658$$Nest$mlogTraceWM(AccessibilityWindowManager r0, String r1, String r2) {
        r0.logTraceWM(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveAccessibilityInteractionConnectionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m659$$Nest$mremoveAccessibilityInteractionConnectionLocked(AccessibilityWindowManager r0, int r1, int r2) {
        r0.removeAccessibilityInteractionConnectionLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mtraceWMEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m660$$Nest$mtraceWMEnabled(AccessibilityWindowManager r0) {
        return r0.traceWMEnabled();
    }

    public void setAccessibilityWindowAttributes(int displayId, int windowId, int userId, AccessibilityWindowAttributes attributes) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        int resolvedUserId = this.mSecurityPolicy.resolveCallingUserIdEnforcingPermissionsLocked(userId);     // Catch: Throwable -> L8
        if (getWindowTokenForUserAndWindowIdLocked(resolvedUserId, windowId) != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        this.mWindowAttributes.put(windowId, attributes);     // Catch: Throwable -> L8
        if (findWindowInfoByIdLocked(windowId) == null) goto L13;
        boolean r3 = true;
    L14:
        boolean shouldComputeWindows = r3;
        monitor-exit(r1);     // Catch: Throwable -> L8
        if (shouldComputeWindows == false) goto L22;
        this.mWindowManagerInternal.computeWindowsForAccessibility(displayId);
        return;
    L22:
        return;
    L13:
        r3 = false;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean windowIdBelongsToDisplayType(int focusedWindowId, int displayTypes) {
        boolean r1 = true;
        if (this.mHasProxy == true) goto L6;
        return true;
    L6:
        if ((displayTypes & 3) != 3) goto L8;
        return true;
    L8:
        Object r2 = this.mLock;
        monitor-enter(r2);
        int count = this.mDisplayWindowsObservers.size();     // Catch: Throwable -> L29
        int i = 0;
    L12:
        if (i >= count) goto L33;
        DisplayWindowsObserver observer = this.mDisplayWindowsObservers.valueAt(i);     // Catch: Throwable -> L29
        if (observer == null) goto L31;
        if (observer.findA11yWindowInfoByIdLocked(focusedWindowId) == null) goto L31;
        if (DisplayWindowsObserver.m662$$Nest$fgetmIsProxy(observer) == false) goto L24;
        if ((displayTypes & 2) != 0) goto L27;
        r1 = false;
    L27:
        monitor-exit(r2);     // Catch: Throwable -> L29
        return r1;
    L24:
        if ((displayTypes & 1) != 0) goto L27;
        r1 = false;
    L31:
        i = i + 1;     // Catch: Throwable -> L29
        goto L12
    L33:
        monitor-exit(r2);     // Catch: Throwable -> L29
        return false;
    L29:
        th = move-exception;
        throw th;
    }

    public AccessibilityWindowManager(Object lock, Handler handler, WindowManagerInternal windowManagerInternal, AccessibilityEventSender accessibilityEventSender, AccessibilitySecurityPolicy securityPolicy, AccessibilitySecurityPolicy.AccessibilityUserManager accessibilityUserManager, AccessibilityTraceManager traceManager) {
        this.mTmpRegion = new Region();
        this.mGlobalInteractionConnections = new SparseArray();
        this.mGlobalWindowTokens = new SparseArray();
        this.mInteractionConnections = new SparseArray();
        this.mWindowTokens = new SparseArray();
        this.mActiveWindowId = -1;
        this.mTopFocusedWindowId = -1;
        this.mAccessibilityFocusedWindowId = -1;
        this.mAccessibilityFocusNodeId = 2147483647L;
        this.mAccessibilityFocusedDisplayId = -1;
        this.mDisplayWindowsObservers = new SparseArray();
        this.mHostEmbeddedMap = new ArrayMap();
        this.mWindowIdMap = new SparseArray();
        this.mWindowAttributes = new SparseArray();
        this.mLock = lock;
        this.mHandler = handler;
        this.mWindowManagerInternal = windowManagerInternal;
        this.mAccessibilityEventSender = accessibilityEventSender;
        this.mSecurityPolicy = securityPolicy;
        this.mAccessibilityUserManager = accessibilityUserManager;
        this.mTraceManager = traceManager;
    }

    public void startTrackingWindows(int displayId, boolean proxyed) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayWindowsObserver observer = this.mDisplayWindowsObservers.get(displayId);     // Catch: Throwable -> L7
        if (observer != null) goto L9;
        observer = new DisplayWindowsObserver(this, displayId);     // Catch: Throwable -> L7
    L9:
        if (proxyed == false) goto L14;
        if (DisplayWindowsObserver.m662$$Nest$fgetmIsProxy(observer) == true) goto L14;
        DisplayWindowsObserver.m665$$Nest$fputmIsProxy(observer, true);     // Catch: Throwable -> L7
        this.mHasProxy = true;     // Catch: Throwable -> L7
    L14:
        if (observer.isTrackingWindowsLocked() == false) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L17:
        observer.startTrackingWindowsLocked();     // Catch: Throwable -> L7
        this.mDisplayWindowsObservers.put(displayId, observer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void stopTrackingWindows(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayWindowsObserver observer = this.mDisplayWindowsObservers.get(displayId);     // Catch: Throwable -> L7
        if (observer == null) goto L9;
        observer.stopTrackingWindowsLocked();     // Catch: Throwable -> L7
        this.mDisplayWindowsObservers.remove(displayId);     // Catch: Throwable -> L7
    L9:
        resetHasProxyIfNeededLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void stopTrackingDisplayProxy(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayWindowsObserver proxyObserver = this.mDisplayWindowsObservers.get(displayId);     // Catch: Throwable -> L7
        if (proxyObserver == null) goto L9;
        DisplayWindowsObserver.m665$$Nest$fputmIsProxy(proxyObserver, false);     // Catch: Throwable -> L7
    L9:
        resetHasProxyIfNeededLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void resetHasProxyIfNeededLocked() {
        boolean hasProxy = false;
        int count = this.mDisplayWindowsObservers.size();
        int i = 0;
    L3:
        if (i >= count) goto L10;
        DisplayWindowsObserver observer = this.mDisplayWindowsObservers.valueAt(i);
        if (observer == null) goto L9;
        if (DisplayWindowsObserver.m662$$Nest$fgetmIsProxy(observer) == false) goto L9;
        hasProxy = true;
    L9:
        i = i + 1;
        goto L3
    L10:
        this.mHasProxy = hasProxy;
    }

    public boolean isTrackingWindowsLocked() {
        int count = this.mDisplayWindowsObservers.size();
        if (count <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isProxyed(int displayId) {
        DisplayWindowsObserver observer = this.mDisplayWindowsObservers.get(displayId);
        if (observer != null) goto L5;
    L7:
        return false;
    L5:
        if (DisplayWindowsObserver.m662$$Nest$fgetmIsProxy(observer) == false) goto L7;
        return true;
    }

    void moveNonProxyTopFocusedDisplayToTopIfNeeded() {
        if (this.mHasProxy == true) goto L5;
        return;
    L5:
        if (this.mLastNonProxyTopFocusedDisplayId == this.mTopFocusedDisplayId) goto L9;
        this.mWindowManagerInternal.moveDisplayToTopIfAllowed(this.mLastNonProxyTopFocusedDisplayId);
        return;
    }

    int getLastNonProxyTopFocusedDisplayId() {
        return this.mLastNonProxyTopFocusedDisplayId;
    }

    public boolean isTrackingWindowsLocked(int displayId) {
        DisplayWindowsObserver observer = this.mDisplayWindowsObservers.get(displayId);
        if (observer != null) goto L5;
        return false;
    L5:
        return observer.isTrackingWindowsLocked();
    }

    public List<AccessibilityWindowInfo> getWindowListLocked(int displayId) {
        DisplayWindowsObserver observer = this.mDisplayWindowsObservers.get(displayId);
        if (observer != null) goto L5;
        return null;
    L5:
        return observer.getWindowListLocked();
    }

    public int addAccessibilityInteractionConnection(IWindow window, IBinder leashToken, IAccessibilityInteractionConnection connection, String packageName, int userId) throws RemoteException {
        boolean shouldComputeWindows = false;
        IBinder token = window.asBinder();
        if (traceWMEnabled() == false) goto L5;
        logTraceWM("getDisplayIdForWindow", "token=" + token);
    L5:
        int displayId = this.mWindowManagerInternal.getDisplayIdForWindow(token);
        Object r11 = this.mLock;
        monitor-enter(r11);
        int resolvedUserId = this.mSecurityPolicy.resolveCallingUserIdEnforcingPermissionsLocked(userId);     // Catch: Throwable -> L34
        int resolvedUid = UserHandle.getUid(resolvedUserId, UserHandle.getCallingAppId());     // Catch: Throwable -> L34
        String packageName2 = this.mSecurityPolicy.resolveValidReportedPackageLocked(packageName, UserHandle.getCallingAppId(), resolvedUserId, Binder.getCallingPid());     // Catch: Throwable -> L32
        int windowId = sNextWindowId;     // Catch: Throwable -> L14
        sNextWindowId = windowId + 1;     // Catch: Throwable -> L14
        if (this.mSecurityPolicy.isCallerInteractingAcrossUsers(userId) == false) goto L16;
        RemoteAccessibilityConnection wrapper = new RemoteAccessibilityConnection(this, windowId, connection, packageName2, resolvedUid, -1);     // Catch: Throwable -> L14
        wrapper.linkToDeath();     // Catch: Throwable -> L14
        this.mGlobalInteractionConnections.put(windowId, wrapper);     // Catch: Throwable -> L14
        this.mGlobalWindowTokens.put(windowId, token);     // Catch: Throwable -> L14
    L18:
        if (isTrackingWindowsLocked(displayId) == false) goto L20;
        shouldComputeWindows = true;
    L20:
        registerIdLocked(leashToken, windowId);     // Catch: Throwable -> L14
        monitor-exit(r11);     // Catch: Throwable -> L14
        if (shouldComputeWindows == false) goto L28;
        if (traceWMEnabled() == false) goto L26;
        logTraceWM("computeWindowsForAccessibility", "displayId=" + displayId);
    L26:
        this.mWindowManagerInternal.computeWindowsForAccessibility(displayId);
    L28:
        if (traceWMEnabled() == false) goto L30;
        logTraceWM("setAccessibilityIdToSurfaceMetadata", "token=" + token + ";windowId=" + windowId);
    L30:
        this.mWindowManagerInternal.setAccessibilityIdToSurfaceMetadata(token, windowId);
        return windowId;
    L16:
        RemoteAccessibilityConnection wrapper2 = new RemoteAccessibilityConnection(this, windowId, connection, packageName2, resolvedUid, resolvedUserId);     // Catch: Throwable -> L14
        wrapper2.linkToDeath();     // Catch: Throwable -> L14
        getInteractionConnectionsForUserLocked(resolvedUserId).put(windowId, wrapper2);     // Catch: Throwable -> L14
        getWindowTokensForUserLocked(resolvedUserId).put(windowId, token);     // Catch: Throwable -> L14
    L32:
        th = th;
    L36:
        monitor-exit(r11);     // Catch: Throwable -> L14
        throw th;
    L14:
        th = th;
    L34:
        th = th;
        goto L36
    }

    public void removeAccessibilityInteractionConnection(IWindow window) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSecurityPolicy.resolveCallingUserIdEnforcingPermissionsLocked(UserHandle.getCallingUserId());     // Catch: Throwable -> L9
        IBinder token = window.asBinder();     // Catch: Throwable -> L9
        int removedWindowId = removeAccessibilityInteractionConnectionInternalLocked(token, this.mGlobalWindowTokens, this.mGlobalInteractionConnections);     // Catch: Throwable -> L9
        if (removedWindowId < 0) goto L11;
        onAccessibilityInteractionConnectionRemovedLocked(removedWindowId, token);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        int userCount = this.mWindowTokens.size();     // Catch: Throwable -> L9
        int i = 0;
    L12:
        if (i >= userCount) goto L20;
        int userId = this.mWindowTokens.keyAt(i);     // Catch: Throwable -> L9
        int removedWindowIdForUser = removeAccessibilityInteractionConnectionInternalLocked(token, getWindowTokensForUserLocked(userId), getInteractionConnectionsForUserLocked(userId));     // Catch: Throwable -> L9
        if (removedWindowIdForUser >= 0) goto L15;
        i = i + 1;     // Catch: Throwable -> L9
        goto L12
    L15:
        onAccessibilityInteractionConnectionRemovedLocked(removedWindowIdForUser, token);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public RemoteAccessibilityConnection getConnectionLocked(int userId, int windowId) {
        RemoteAccessibilityConnection connection = this.mGlobalInteractionConnections.get(windowId);
        if (connection == null) goto L5;
    L7:
        if (connection != null) goto L9;
        return null;
    L9:
        if (connection.getRemote() == null) goto L13;
        return connection;
    L13:
        return null;
    L5:
        if (isValidUserForInteractionConnectionsLocked(userId) == false) goto L7;
        connection = getInteractionConnectionsForUserLocked(userId).get(windowId);
        goto L7
    }

    private int removeAccessibilityInteractionConnectionInternalLocked(IBinder windowToken, SparseArray<IBinder> windowTokens, SparseArray<RemoteAccessibilityConnection> interactionConnections) {
        int count = windowTokens.size();
        int i = 0;
    L3:
        if (i >= count) goto L9;
        if (windowTokens.valueAt(i) == windowToken) goto L6;
        i = i + 1;
        goto L3
    L6:
        int windowId = windowTokens.keyAt(i);
        windowTokens.removeAt(i);
        RemoteAccessibilityConnection wrapper = interactionConnections.get(windowId);
        wrapper.unlinkToDeath();
        interactionConnections.remove(windowId);
        return windowId;
    L9:
        return -1;
    }

    private void removeAccessibilityInteractionConnectionLocked(int windowId, int userId) {
        IBinder window = null;
        if (userId != (-1)) goto L6;
        IBinder window2 = this.mGlobalWindowTokens.get(windowId);
        window = window2;
        this.mGlobalWindowTokens.remove(windowId);
        this.mGlobalInteractionConnections.remove(windowId);
    L11:
        onAccessibilityInteractionConnectionRemovedLocked(windowId, window);
        return;
    L6:
        if (isValidUserForWindowTokensLocked(userId) == false) goto L9;
        IBinder window3 = getWindowTokensForUserLocked(userId).get(windowId);
        window = window3;
        getWindowTokensForUserLocked(userId).remove(windowId);
    L9:
        if (isValidUserForInteractionConnectionsLocked(userId) == false) goto L11;
        getInteractionConnectionsForUserLocked(userId).remove(windowId);
        goto L11
    }

    private void onAccessibilityInteractionConnectionRemovedLocked(int windowId, IBinder binder) {
        if (isTrackingWindowsLocked() == true) goto L8;
        if (windowId < 0) goto L8;
        if (this.mActiveWindowId != windowId) goto L8;
        this.mActiveWindowId = -1;
    L8:
        if (binder != null) goto L10;
    L13:
        unregisterIdLocked(windowId);
        this.mWindowAttributes.remove(windowId);
        return;
    L10:
        if (traceWMEnabled() == false) goto L12;
        logTraceWM("setAccessibilityIdToSurfaceMetadata", "token=" + binder + ";windowId=AccessibilityWindowInfo.UNDEFINED_WINDOW_ID");
    L12:
        this.mWindowManagerInternal.setAccessibilityIdToSurfaceMetadata(binder, -1);
        goto L13
    }

    public IBinder getWindowTokenForUserAndWindowIdLocked(int userId, int windowId) {
        IBinder windowToken = this.mGlobalWindowTokens.get(windowId);
        if (windowToken == null) goto L5;
        return windowToken;
    L5:
        if (isValidUserForWindowTokensLocked(userId) == true) goto L7;
        return windowToken;
    L7:
        return getWindowTokensForUserLocked(userId).get(windowId);
    }

    public int getWindowOwnerUserId(IBinder windowToken) {
        if (traceWMEnabled() == false) goto L6;
        logTraceWM("getWindowOwnerUserId", "token=" + windowToken);
    L6:
        return this.mWindowManagerInternal.getWindowOwnerUserId(windowToken);
    }

    public int findWindowIdLocked(int userId, IBinder token) {
        int globalIndex = this.mGlobalWindowTokens.indexOfValue(token);
        if (globalIndex < 0) goto L7;
        return this.mGlobalWindowTokens.keyAt(globalIndex);
    L7:
        if (isValidUserForWindowTokensLocked(userId) == false) goto L12;
        int userIndex = getWindowTokensForUserLocked(userId).indexOfValue(token);
        if (userIndex >= 0) goto L11;
        return -1;
    L11:
        return getWindowTokensForUserLocked(userId).keyAt(userIndex);
    L12:
        return -1;
    }

    public void associateEmbeddedHierarchyLocked(IBinder host, IBinder embedded) {
        associateLocked(embedded, host);
    }

    public void disassociateEmbeddedHierarchyLocked(IBinder token) {
        disassociateLocked(token);
    }

    public int resolveParentWindowIdLocked(int windowId) {
        IBinder token = getLeashTokenLocked(windowId);
        if (token != null) goto L5;
        return windowId;
    L5:
        IBinder resolvedToken = resolveTopParentTokenLocked(token);
        int resolvedWindowId = getWindowIdLocked(resolvedToken);
        if (resolvedWindowId == (-1)) goto L9;
        return resolvedWindowId;
    L9:
        return windowId;
    }

    private IBinder resolveTopParentTokenLocked(IBinder token) {
        IBinder hostToken = getHostTokenLocked(token);
        if (hostToken != null) goto L6;
        return token;
    L6:
        return resolveTopParentTokenLocked(hostToken);
    }

    public boolean computePartialInteractiveRegionForWindowLocked(int windowId, Region outRegion) {
        int parentWindowId = resolveParentWindowIdLocked(windowId);
        DisplayWindowsObserver observer = getDisplayWindowObserverByWindowIdLocked(parentWindowId);
        boolean r2 = false;
        if (observer == null) goto L8;
        if (parentWindowId == windowId) goto L7;
        r2 = true;
    L7:
        return observer.computePartialInteractiveRegionForWindowLocked(parentWindowId, r2, outRegion);
    L8:
        return false;
    }

    public void updateActiveAndAccessibilityFocusedWindowLocked(int userId, int windowId, long nodeId, int eventType, int eventAction) {
        switch(eventType) {
            case 32: goto L59;
            case 128: goto L46;
            case 32768: goto L28;
            case 65536: goto L4;
            default: goto L81;
        };
    L4:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.mHasProxy == false) goto L15;
        if (clearProxyFocusLocked(windowId, eventAction) == false) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L15:
        if (this.mAccessibilityFocusNodeId != nodeId) goto L18;
        this.mAccessibilityFocusNodeId = 2147483647L;     // Catch: Throwable -> L12
    L18:
        if (this.mAccessibilityFocusNodeId == 2147483647L) goto L20;
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L20:
        if (this.mAccessibilityFocusedWindowId != windowId) goto L24;
        if (eventAction == 64) goto L24;
        this.mAccessibilityFocusedWindowId = -1;     // Catch: Throwable -> L12
        this.mAccessibilityFocusedDisplayId = -1;     // Catch: Throwable -> L12
        goto L24
    L28:
        Object r1 = this.mLock;
        monitor-enter(r1);
    L36:
        th = move-exception;
        throw th;
    L31:
        if (this.mHasProxy == false) goto L39;
        if (setProxyFocusLocked(windowId) == false) goto L39;
        monitor-exit(r1);     // Catch: Throwable -> L36
        return;
    L39:
        if (this.mAccessibilityFocusedWindowId == windowId) goto L41;
        clearAccessibilityFocusLocked(this.mAccessibilityFocusedWindowId);     // Catch: Throwable -> L36
        setAccessibilityFocusedWindowLocked(windowId);     // Catch: Throwable -> L36
    L41:
        this.mAccessibilityFocusNodeId = nodeId;     // Catch: Throwable -> L36
        monitor-exit(r1);     // Catch: Throwable -> L36
        return;
    L46:
        Object r2 = this.mLock;
        monitor-enter(r2);
    L53:
        th = move-exception;
        throw th;
    L49:
        if (this.mTouchInteractionInProgress == true) goto L51;
    L55:
        monitor-exit(r2);     // Catch: Throwable -> L53
        return;
    L51:
        if (this.mActiveWindowId == windowId) goto L55;
        setActiveWindowLocked(windowId);     // Catch: Throwable -> L53
        goto L55
    L59:
        Object r3 = this.mLock;
        monitor-enter(r3);
    L66:
        th = move-exception;
        throw th;
    L62:
        if (isTrackingWindowsLocked() == true) goto L68;
        this.mTopFocusedWindowId = findFocusedWindowId(userId);     // Catch: Throwable -> L66
        if (windowId != this.mTopFocusedWindowId) goto L68;
        this.mActiveWindowId = windowId;     // Catch: Throwable -> L66
    L68:
        monitor-exit(r3);     // Catch: Throwable -> L66
        return;
    }

    public void onTouchInteractionStart() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mTouchInteractionInProgress = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void onTouchInteractionEnd() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mTouchInteractionInProgress = false;     // Catch: Throwable -> L12
        int oldActiveWindow = this.mActiveWindowId;     // Catch: Throwable -> L12
        setActiveWindowLocked(this.mTopFocusedWindowId);     // Catch: Throwable -> L12
        if (oldActiveWindow != this.mActiveWindowId) goto L8;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L8:
        if (this.mAccessibilityFocusedWindowId != oldActiveWindow) goto L14;
        if (accessibilityFocusOnlyInActiveWindowLocked() == false) goto L14;
        clearAccessibilityFocusLocked(oldActiveWindow);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public int getActiveWindowId(int userId) {
        if (this.mActiveWindowId != (-1)) goto L8;
        if (this.mTouchInteractionInProgress == true) goto L8;
        this.mActiveWindowId = findFocusedWindowId(userId);
    L8:
        return this.mActiveWindowId;
    }

    private void setActiveWindowLocked(int windowId) {
        if (this.mActiveWindowId == windowId) goto L21;
        List<AccessibilityEvent> events = new ArrayList(2);
        if (this.mActiveWindowId == (-1)) goto L9;
        DisplayWindowsObserver observer = getDisplayWindowObserverByWindowIdLocked(this.mActiveWindowId);
        if (observer == null) goto L9;
        events.add(AccessibilityEvent.obtainWindowsChangedEvent(DisplayWindowsObserver.m661$$Nest$fgetmDisplayId(observer), this.mActiveWindowId, 32));
    L9:
        this.mActiveWindowId = windowId;
        int count = this.mDisplayWindowsObservers.size();
        int i = 0;
    L10:
        if (i >= count) goto L17;
        DisplayWindowsObserver observer2 = this.mDisplayWindowsObservers.valueAt(i);
        if (observer2 == null) goto L16;
        if (observer2.setActiveWindowLocked(windowId) == false) goto L16;
        events.add(AccessibilityEvent.obtainWindowsChangedEvent(DisplayWindowsObserver.m661$$Nest$fgetmDisplayId(observer2), windowId, 32));
    L16:
        i = i + 1;
        goto L10
    L17:
        Iterator<AccessibilityEvent> r2 = events.iterator();
    L19:
        if (r2.hasNext() == false) goto L27;
        AccessibilityEvent event = r2.next();
        this.mAccessibilityEventSender.sendAccessibilityEventForCurrentUserLocked(event);
        goto L19
    L27:
        return;
    }

    private void setAccessibilityFocusedWindowLocked(int windowId) {
        if (this.mAccessibilityFocusedWindowId == windowId) goto L21;
        List<AccessibilityEvent> events = new ArrayList(2);
        if (this.mAccessibilityFocusedDisplayId != (-1)) goto L7;
    L9:
        this.mAccessibilityFocusedWindowId = windowId;
        int count = this.mDisplayWindowsObservers.size();
        int i = 0;
    L10:
        if (i >= count) goto L17;
        DisplayWindowsObserver observer = this.mDisplayWindowsObservers.valueAt(i);
        if (observer == null) goto L16;
        if (observer.setAccessibilityFocusedWindowLocked(windowId) == false) goto L16;
        this.mAccessibilityFocusedDisplayId = DisplayWindowsObserver.m661$$Nest$fgetmDisplayId(observer);
        events.add(AccessibilityEvent.obtainWindowsChangedEvent(DisplayWindowsObserver.m661$$Nest$fgetmDisplayId(observer), windowId, 128));
    L16:
        i = i + 1;
        goto L10
    L17:
        Iterator<AccessibilityEvent> r2 = events.iterator();
    L19:
        if (r2.hasNext() == false) goto L27;
        AccessibilityEvent event = r2.next();
        this.mAccessibilityEventSender.sendAccessibilityEventForCurrentUserLocked(event);
        goto L19
    L27:
        return;
    L7:
        if (this.mAccessibilityFocusedWindowId == (-1)) goto L9;
        events.add(AccessibilityEvent.obtainWindowsChangedEvent(this.mAccessibilityFocusedDisplayId, this.mAccessibilityFocusedWindowId, 128));
        goto L9
    }

    public AccessibilityWindowInfo findA11yWindowInfoByIdLocked(int windowId) {
        int windowId2 = resolveParentWindowIdLocked(windowId);
        DisplayWindowsObserver observer = getDisplayWindowObserverByWindowIdLocked(windowId2);
        if (observer != null) goto L5;
        return null;
    L5:
        return observer.findA11yWindowInfoByIdLocked(windowId2);
    }

    public WindowInfo findWindowInfoByIdLocked(int windowId) {
        int windowId2 = resolveParentWindowIdLocked(windowId);
        DisplayWindowsObserver observer = getDisplayWindowObserverByWindowIdLocked(windowId2);
        if (observer != null) goto L5;
        return null;
    L5:
        return observer.findWindowInfoByIdLocked(windowId2);
    }

    public int getFocusedWindowId(int focusType) {
        return getFocusedWindowId(focusType, -1);
    }

    public int getFocusedWindowId(int focusType, int displayId) {
        if (displayId == (-1)) goto L17;
        if (displayId == 0) goto L17;
        if (this.mHasProxy == false) goto L17;
        DisplayWindowsObserver observer = this.mDisplayWindowsObservers.get(displayId);
        if (observer == null) goto L15;
        if (DisplayWindowsObserver.m662$$Nest$fgetmIsProxy(observer) == false) goto L15;
        return getProxyFocus(focusType, observer);
    L15:
        return getDefaultFocus(focusType);
    L17:
        return getDefaultFocus(focusType);
    }

    private int getDefaultFocus(int focusType) {
        if (focusType != 1) goto L7;
        return this.mTopFocusedWindowId;
    L7:
        if (focusType == 2) goto L9;
        return -1;
    L9:
        return this.mAccessibilityFocusedWindowId;
    }

    private int getProxyFocus(int focusType, DisplayWindowsObserver observer) {
        if (focusType != 1) goto L7;
        return this.mTopFocusedWindowId;
    L7:
        if (focusType == 2) goto L9;
        return -1;
    L9:
        return DisplayWindowsObserver.m663$$Nest$fgetmProxyDisplayAccessibilityFocusedWindow(observer);
    }

    public AccessibilityWindowInfo getPictureInPictureWindowLocked() {
        AccessibilityWindowInfo windowInfo = null;
        int count = this.mDisplayWindowsObservers.size();
        int i = 0;
    L3:
        if (i >= count) goto L10;
        DisplayWindowsObserver observer = this.mDisplayWindowsObservers.valueAt(i);
        if (observer == null) goto L9;
        AccessibilityWindowInfo r4 = observer.getPictureInPictureWindowLocked();
        windowInfo = r4;
        if (r4 != null) goto L10;
    L9:
        i = i + 1;
    L10:
        return windowInfo;
    }

    public void setPictureInPictureActionReplacingConnection(IAccessibilityInteractionConnection connection) throws RemoteException {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L14:
        th = th;
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L14
        throw th;
    L16:
        th = th;
        goto L21
    L5:
        if (this.mPictureInPictureActionReplacingConnection != null) goto L23;
    L10:
        if (connection == null) goto L19;
        RemoteAccessibilityConnection wrapper = new RemoteAccessibilityConnection(this, -3, connection, "foo.bar.baz", 1000, -1);     // Catch: Throwable -> L14
        this.mPictureInPictureActionReplacingConnection = wrapper;     // Catch: Throwable -> L14
        wrapper.linkToDeath();     // Catch: Throwable -> L14
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L23:
        this.mPictureInPictureActionReplacingConnection.unlinkToDeath();     // Catch: Throwable -> L8
        this.mPictureInPictureActionReplacingConnection = null;     // Catch: Throwable -> L8
    L8:
        th = th;
        goto L21
    }

    public RemoteAccessibilityConnection getPictureInPictureActionReplacingConnection() {
        return this.mPictureInPictureActionReplacingConnection;
    }

    public void notifyOutsideTouch(int userId, int targetWindowId) {
        List<RemoteAccessibilityConnection> connectionList = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        DisplayWindowsObserver observer = getDisplayWindowObserverByWindowIdLocked(targetWindowId);     // Catch: Throwable -> L10
        if (observer == null) goto L12;
        List<Integer> outsideWindowsIds = observer.getWatchOutsideTouchWindowIdLocked(targetWindowId);     // Catch: Throwable -> L10
        int i = 0;
    L8:
        if (i >= outsideWindowsIds.size()) goto L12;
        connectionList.add(getConnectionLocked(userId, outsideWindowsIds.get(i).intValue()));     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L10
        int i2 = 0;
    L15:
        if (i2 >= connectionList.size()) goto L26;
        RemoteAccessibilityConnection connection = connectionList.get(i2);
        if (connection == null) goto L24;
        if (traceIntConnEnabled() == false) goto L29;
        logTraceIntConn("notifyOutsideTouch");
    L29:
        connection.getRemote().notifyOutsideTouch();     // Catch: RemoteException -> L23
    L24:
        i2 = i2 + 1;
        goto L15
    L26:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public int getDisplayIdByUserIdAndWindowId(int userId, int windowId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        IBinder windowToken = getWindowTokenForUserAndWindowIdLocked(userId, windowId);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        if (traceWMEnabled() == false) goto L9;
        logTraceWM("getDisplayIdForWindow", "token=" + windowToken);
    L9:
        int displayId = this.mWindowManagerInternal.getDisplayIdForWindow(windowToken);
        return displayId;
    L11:
        th = move-exception;
        throw th;
    }

    public ArrayList<Integer> getDisplayListLocked(int displayTypes) {
        ArrayList<Integer> displayList = new ArrayList();
        int count = this.mDisplayWindowsObservers.size();
        int i = 0;
    L3:
        if (i >= count) goto L18;
        DisplayWindowsObserver observer = this.mDisplayWindowsObservers.valueAt(i);
        if (observer == null) goto L16;
        if (DisplayWindowsObserver.m662$$Nest$fgetmIsProxy(observer) == true) goto L12;
        if ((displayTypes & 1) == 0) goto L12;
        displayList.add(Integer.valueOf(DisplayWindowsObserver.m661$$Nest$fgetmDisplayId(observer)));
    L12:
        if (DisplayWindowsObserver.m662$$Nest$fgetmIsProxy(observer) == false) goto L16;
        if ((displayTypes & 2) == 0) goto L16;
        displayList.add(Integer.valueOf(DisplayWindowsObserver.m661$$Nest$fgetmDisplayId(observer)));
    L16:
        i = i + 1;
        goto L3
    L18:
        return displayList;
    }

    boolean accessibilityFocusOnlyInActiveWindowLocked() {
        return !isTrackingWindowsLocked();
    }

    private int findFocusedWindowId(int userId) {
        if (traceWMEnabled() == false) goto L5;
        logTraceWM("getFocusedWindowToken", "");
    L5:
        IBinder token = this.mWindowManagerInternal.getFocusedWindowTokenFromWindowStates();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int r2 = findWindowIdLocked(userId, token);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean isValidUserForInteractionConnectionsLocked(int userId) {
        if (this.mInteractionConnections.indexOfKey(userId) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isValidUserForWindowTokensLocked(int userId) {
        if (this.mWindowTokens.indexOfKey(userId) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    private SparseArray<RemoteAccessibilityConnection> getInteractionConnectionsForUserLocked(int userId) {
        SparseArray<RemoteAccessibilityConnection> connection = this.mInteractionConnections.get(userId);
        if (connection != null) goto L6;
        SparseArray<RemoteAccessibilityConnection> connection2 = new SparseArray();
        this.mInteractionConnections.put(userId, connection2);
        return connection2;
    L6:
        return connection;
    }

    private SparseArray<IBinder> getWindowTokensForUserLocked(int userId) {
        SparseArray<IBinder> windowTokens = this.mWindowTokens.get(userId);
        if (windowTokens != null) goto L6;
        SparseArray<IBinder> windowTokens2 = new SparseArray();
        this.mWindowTokens.put(userId, windowTokens2);
        return windowTokens2;
    L6:
        return windowTokens;
    }

    private void clearAccessibilityFocusLocked(int windowId) {
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityWindowManager$$ExternalSyntheticLambda0(), this, Integer.valueOf(this.mAccessibilityUserManager.getCurrentUserIdLocked()), Integer.valueOf(windowId)));
    }

    private void clearAccessibilityFocusMainThread(int userId, int windowId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        RemoteAccessibilityConnection connection = getConnectionLocked(userId, windowId);     // Catch: Throwable -> L8
        if (connection != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        if (traceIntConnEnabled() == false) goto L20;
        logTraceIntConn("notifyOutsideTouch");
    L20:
        connection.getRemote().clearAccessibilityFocus();     // Catch: RemoteException -> L16
        return;
    L17:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private DisplayWindowsObserver getDisplayWindowObserverByWindowIdLocked(int windowId) {
        int count = this.mDisplayWindowsObservers.size();
        int i = 0;
    L3:
        if (i >= count) goto L11;
        DisplayWindowsObserver observer = this.mDisplayWindowsObservers.valueAt(i);
        if (observer == null) goto L10;
        if (observer.findWindowInfoByIdLocked(windowId) == null) goto L10;
        return this.mDisplayWindowsObservers.get(DisplayWindowsObserver.m661$$Nest$fgetmDisplayId(observer));
    L10:
        i = i + 1;
        goto L3
    L11:
        return null;
    }

    private boolean traceWMEnabled() {
        return this.mTraceManager.isA11yTracingEnabledForTypes(512);
    }

    private void logTraceWM(String methodName, String params) {
        this.mTraceManager.logTrace("WindowManagerInternal." + methodName, 512, params);
    }

    private boolean traceIntConnEnabled() {
        return this.mTraceManager.isA11yTracingEnabledForTypes(16);
    }

    private void logTraceIntConn(String methodName) {
        this.mTraceManager.logTrace("AccessibilityWindowManager." + methodName, 16);
    }

    void associateLocked(IBinder embedded, IBinder host) {
        this.mHostEmbeddedMap.put(embedded, host);
    }

    void disassociateLocked(IBinder token) {
        this.mHostEmbeddedMap.remove(token);
        int i = this.mHostEmbeddedMap.size() - 1;
    L3:
        if (i < 0) goto L9;
        if (this.mHostEmbeddedMap.valueAt(i).equals(token) == false) goto L7;
        this.mHostEmbeddedMap.removeAt(i);
    L7:
        i = i - 1;
        goto L3
    }

    void registerIdLocked(IBinder token, int windowId) {
        this.mWindowIdMap.put(windowId, token);
    }

    void unregisterIdLocked(int windowId) {
        IBinder token = this.mWindowIdMap.get(windowId);
        if (token != null) goto L5;
        return;
    L5:
        disassociateLocked(token);
        this.mWindowIdMap.remove(windowId);
    }

    IBinder getLeashTokenLocked(int windowId) {
        return this.mWindowIdMap.get(windowId);
    }

    int getWindowIdLocked(IBinder token) {
        int index = this.mWindowIdMap.indexOfValue(token);
        if (index != (-1)) goto L6;
        return index;
    L6:
        return this.mWindowIdMap.keyAt(index);
    }

    IBinder getHostTokenLocked(IBinder token) {
        return this.mHostEmbeddedMap.get(token);
    }

    boolean isEmbeddedHierarchyWindowsLocked(int windowId) {
        if (this.mHostEmbeddedMap.size() != 0) goto L5;
        return false;
    L5:
        IBinder leashToken = getLeashTokenLocked(windowId);
        if (leashToken != null) goto L9;
        return false;
    L9:
        return this.mHostEmbeddedMap.containsKey(leashToken);
    }

    private boolean clearProxyFocusLocked(int focusClearedWindowId, int eventAction) {
        if (eventAction != 64) goto L5;
        return false;
    L5:
        int i = 0;
    L7:
        if (i >= this.mDisplayWindowsObservers.size()) goto L23;
        DisplayWindowsObserver observer = this.mDisplayWindowsObservers.get(i);
        if (observer == null) goto L21;
        if (DisplayWindowsObserver.m664$$Nest$fgetmWindows(observer) == null) goto L21;
        if (DisplayWindowsObserver.m662$$Nest$fgetmIsProxy(observer) == false) goto L21;
        int windowCount = DisplayWindowsObserver.m664$$Nest$fgetmWindows(observer).size();
        int j = 0;
    L15:
        if (j >= windowCount) goto L21;
        AccessibilityWindowInfo window = (AccessibilityWindowInfo) DisplayWindowsObserver.m664$$Nest$fgetmWindows(observer).get(j);
        if (window.getId() == focusClearedWindowId) goto L18;
        j = j + 1;
        goto L15
    L18:
        DisplayWindowsObserver.m666$$Nest$fputmProxyDisplayAccessibilityFocusedWindow(observer, -1);
        return true;
    L21:
        i = i + 1;
        goto L7
    L23:
        return false;
    }

    private boolean setProxyFocusLocked(int focusedWindowId) {
        int i = 0;
    L4:
        if (i >= this.mDisplayWindowsObservers.size()) goto L20;
        DisplayWindowsObserver observer = this.mDisplayWindowsObservers.valueAt(i);
        if (observer == null) goto L19;
        if (DisplayWindowsObserver.m662$$Nest$fgetmIsProxy(observer) == false) goto L19;
        if (observer.setAccessibilityFocusedWindowLocked(focusedWindowId) == false) goto L19;
        int previouslyFocusedWindowId = DisplayWindowsObserver.m663$$Nest$fgetmProxyDisplayAccessibilityFocusedWindow(observer);
        if (previouslyFocusedWindowId != focusedWindowId) goto L15;
        return true;
    L15:
        if (previouslyFocusedWindowId == (-1)) goto L17;
        clearAccessibilityFocusLocked(previouslyFocusedWindowId);
        this.mAccessibilityEventSender.sendAccessibilityEventForCurrentUserLocked(AccessibilityEvent.obtainWindowsChangedEvent(DisplayWindowsObserver.m661$$Nest$fgetmDisplayId(observer), previouslyFocusedWindowId, 128));
    L17:
        DisplayWindowsObserver.m666$$Nest$fputmProxyDisplayAccessibilityFocusedWindow(observer, focusedWindowId);
        this.mAccessibilityEventSender.sendAccessibilityEventForCurrentUserLocked(AccessibilityEvent.obtainWindowsChangedEvent(DisplayWindowsObserver.m661$$Nest$fgetmDisplayId(observer), DisplayWindowsObserver.m663$$Nest$fgetmProxyDisplayAccessibilityFocusedWindow(observer), 128));
        return true;
    L19:
        i = i + 1;
        goto L4
    L20:
        return false;
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        pw.append("Global Info [ ");
        pw.println("Top focused display Id = " + this.mTopFocusedDisplayId);
        pw.println("     Active Window Id = " + this.mActiveWindowId);
        pw.println("     Top Focused Window Id = " + this.mTopFocusedWindowId);
        pw.println("     Accessibility Focused Window Id = " + this.mAccessibilityFocusedWindowId + " ]");
        pw.println();
        int count = this.mDisplayWindowsObservers.size();
        int i = 0;
    L3:
        if (i >= count) goto L8;
        DisplayWindowsObserver observer = this.mDisplayWindowsObservers.valueAt(i);
        if (observer == null) goto L7;
        observer.dumpLocked(fd, pw, args);
    L7:
        i = i + 1;
        goto L3
    L8:
        pw.println();
        pw.append("Window attributes:[");
        pw.append(this.mWindowAttributes.toString());
        pw.append("]");
        pw.println();
    }
}
