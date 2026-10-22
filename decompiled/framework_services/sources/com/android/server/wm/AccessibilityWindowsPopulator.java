package com.android.server.wm;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.view.InputWindowHandle;
import android.view.MagnificationSpec;
import android.view.WindowInfo;
import android.window.WindowInfosListener;
import com.android.internal.util.DumpUtils;
import com.android.server.wm.utils.RegionUtils;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class AccessibilityWindowsPopulator extends WindowInfosListener {
    private static final int SURFACE_FLINGER_CALLBACK_WINDOWS_STABLE_TIMES_MS = 35;
    private static final String TAG = null;
    private static final int WINDOWS_CHANGED_NOTIFICATION_MAX_DURATION_TIMES_MS = 450;
    private static final float[] sTempFloats = null;
    private final AccessibilityController mAccessibilityController;
    private final SparseArray<MagnificationSpec> mCurrentMagnificationSpec;
    private final SparseArray<WindowInfosListener.DisplayInfo> mDisplayInfos;
    private final Handler mHandler;
    private final SparseArray<List<InputWindowHandle>> mInputWindowHandlesOnDisplays;
    private final Object mLock;
    private final SparseArray<Matrix> mMagnificationSpecInverseMatrix;
    private final SparseArray<MagnificationSpec> mPreviousMagnificationSpec;
    private final WindowManagerService mService;
    private final float[] mTempFloat1;
    private final float[] mTempFloat2;
    private final float[] mTempFloat3;
    private final Matrix mTempMatrix1;
    private final Matrix mTempMatrix2;
    private final List<InputWindowHandle> mVisibleWindows;
    private boolean mWindowsNotificationEnabled;
    private final Map<IBinder, Matrix> mWindowsTransformMatrixMap;

    public static class AccessibilityWindow {
        private int mDisplayId;
        private int mInputConfig;
        private boolean mIsFocused;
        private boolean mIsPIPMenu;
        private int mPrivateFlags;
        private boolean mShouldMagnify;
        private Rect mSystemBarInsetFrame;
        private final Region mTouchableRegionInScreen;
        private final Region mTouchableRegionInWindow;
        private int mType;
        private IBinder mWindow;
        private WindowInfo mWindowInfo;

        public static /* synthetic */ void $r8$lambda$mgve4lmpe0TAPbOqbfYHFvU6UUM(Matrix r0, Matrix r1, Region r2, Rect r3) {
            lambda$getUnMagnifiedTouchableRegion$0(r0, r1, r2, r3);
        }

        public AccessibilityWindow() {
            this.mTouchableRegionInScreen = new Region();
            this.mTouchableRegionInWindow = new Region();
            this.mSystemBarInsetFrame = null;
        }

        public static AccessibilityWindow initializeData(WindowManagerService service, InputWindowHandle inputWindowHandle, Matrix magnificationInverseMatrix, IBinder pipIBinder, Matrix displayMatrix) {
            IBinder window = inputWindowHandle.getWindowToken();
            if (window == null) goto L5;
            WindowState r0 = service.mWindowMap.get(window);
        L6:
            WindowState windowState = r0;
            AccessibilityWindow instance = new AccessibilityWindow();
            instance.mWindow = window;
            instance.mDisplayId = inputWindowHandle.displayId;
            instance.mInputConfig = inputWindowHandle.inputConfig;
            instance.mType = inputWindowHandle.layoutParamsType;
            boolean r1 = true;
            if (window != null) goto L9;
        L11:
            boolean r2 = false;
        L12:
            instance.mIsPIPMenu = r2;
            if (windowState == null) goto L15;
            int r3 = windowState.mAttrs.privateFlags;
        L16:
            instance.mPrivateFlags = r3;
            if (windowState != null) goto L19;
        L21:
            boolean r4 = false;
        L22:
            instance.mIsFocused = r4;
            if (windowState != null) goto L25;
        L28:
            instance.mShouldMagnify = r1;
            Rect windowFrame = new Rect(inputWindowHandle.frame);
            getTouchableRegionInWindow(instance.mShouldMagnify, inputWindowHandle.touchableRegion, instance.mTouchableRegionInWindow, windowFrame, magnificationInverseMatrix, displayMatrix);
            getUnMagnifiedTouchableRegion(instance.mShouldMagnify, inputWindowHandle.touchableRegion, instance.mTouchableRegionInScreen, magnificationInverseMatrix, displayMatrix);
            if (windowState == null) goto L31;
            WindowInfo r5 = windowState.getWindowInfo();
        L32:
            instance.mWindowInfo = r5;
            Matrix inverseTransform = new Matrix();
            inputWindowHandle.transform.invert(inverseTransform);
            inverseTransform.postConcat(displayMatrix);
            inverseTransform.getValues(instance.mWindowInfo.mTransformMatrix);
            Matrix magnificationSpecMatrix = new Matrix();
            if (instance.shouldMagnify() == false) goto L41;
            if (magnificationInverseMatrix == null) goto L41;
            if (magnificationInverseMatrix.isIdentity() == true) goto L41;
            if (magnificationInverseMatrix.invert(magnificationSpecMatrix) == false) goto L40;
            magnificationSpecMatrix.getValues(AccessibilityWindowsPopulator.m9606$$Nest$sfgetsTempFloats());
            MagnificationSpec spec = instance.mWindowInfo.mMagnificationSpec;
            spec.scale = AccessibilityWindowsPopulator.m9606$$Nest$sfgetsTempFloats()[0];
            spec.offsetX = AccessibilityWindowsPopulator.m9606$$Nest$sfgetsTempFloats()[2];
            spec.offsetY = AccessibilityWindowsPopulator.m9606$$Nest$sfgetsTempFloats()[5];
            goto L41
        L40:
            Slog.w(AccessibilityWindowsPopulator.m9605$$Nest$sfgetTAG(), "can't find spec");
        L41:
            if (windowState != null) goto L43;
        L47:
            return instance;
        L43:
            if (instance.isUntouchableNavigationBar() == false) goto L47;
            InsetsSourceProvider provider = windowState.getControllableInsetProvider();
            if (provider == null) goto L47;
            instance.mSystemBarInsetFrame = provider.getSource().getFrame();
            goto L47
        L31:
            r5 = getWindowInfoForWindowlessWindows(instance);
            goto L32
        L25:
            if (windowState.shouldMagnify() == true) goto L28;
            r1 = false;
            goto L28
        L19:
            if (windowState.isFocused() == false) goto L21;
            r4 = true;
            goto L22
        L15:
            r3 = 0;
            goto L16
        L9:
            if (window.equals(pipIBinder) == false) goto L11;
            r2 = true;
            goto L12
        L5:
            r0 = null;
            goto L6
        }

        public void getTouchableRegionInScreen(Region outRegion) {
            outRegion.set(this.mTouchableRegionInScreen);
        }

        public void getTouchableRegionInWindow(Region outRegion) {
            outRegion.set(this.mTouchableRegionInWindow);
        }

        public int getType() {
            return this.mType;
        }

        public int getPrivateFlag() {
            return this.mPrivateFlags;
        }

        public WindowInfo getWindowInfo() {
            return this.mWindowInfo;
        }

        public boolean shouldMagnify() {
            return this.mShouldMagnify;
        }

        public boolean isFocused() {
            return this.mIsFocused;
        }

        public boolean isTrustedOverlay() {
            if ((this.mInputConfig & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isTouchable() {
            if ((this.mInputConfig & 8) != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isUntouchableNavigationBar() {
            if (this.mType == 2019) goto L7;
            return false;
        L7:
            return this.mTouchableRegionInScreen.isEmpty();
        }

        public boolean isPIPMenu() {
            return this.mIsPIPMenu;
        }

        public Rect getSystemBarInsetsFrame() {
            return this.mSystemBarInsetFrame;
        }

        private static void getTouchableRegionInWindow(boolean shouldMagnify, Region inRegion, Region outRegion, Rect frame, Matrix inverseMatrix, Matrix displayMatrix) {
            Region touchRegion = new Region();
            touchRegion.set(inRegion);
            touchRegion.op(frame, Region.Op.INTERSECT);
            getUnMagnifiedTouchableRegion(shouldMagnify, touchRegion, outRegion, inverseMatrix, displayMatrix);
        }

        private static void getUnMagnifiedTouchableRegion(boolean shouldMagnify, Region inRegion, final Region outRegion, final Matrix inverseMatrix, final Matrix displayMatrix) {
            if (shouldMagnify == false) goto L6;
            if (inverseMatrix.isIdentity() == true) goto L6;
        L9:
            RegionUtils.forEachRect(inRegion, new AccessibilityWindowsPopulator$AccessibilityWindow$$ExternalSyntheticLambda0(displayMatrix, inverseMatrix, outRegion));
            return;
        L6:
            if (displayMatrix.isIdentity() == false) goto L9;
            outRegion.set(inRegion);
        }

        private static /* synthetic */ void lambda$getUnMagnifiedTouchableRegion$0(Matrix displayMatrix, Matrix inverseMatrix, Region outRegion, Rect rect) {
            RectF windowFrame = new RectF(rect);
            displayMatrix.mapRect(windowFrame);
            inverseMatrix.mapRect(windowFrame);
            outRegion.union(new Rect((int) windowFrame.left, (int) windowFrame.top, (int) windowFrame.right, (int) windowFrame.bottom));
        }

        private static WindowInfo getWindowInfoForWindowlessWindows(AccessibilityWindow window) {
            WindowInfo windowInfo = WindowInfo.obtain();
            windowInfo.displayId = window.mDisplayId;
            windowInfo.type = window.mType;
            windowInfo.token = window.mWindow;
            if ((window.mInputConfig & 512) == 0) goto L5;
            boolean r1 = true;
        L6:
            windowInfo.hasFlagWatchOutsideTouch = r1;
            windowInfo.inPictureInPicture = window.mIsPIPMenu;
            return windowInfo;
        L5:
            r1 = false;
            goto L6
        }

        public String toString() {
            if (this.mWindow == null) goto L5;
            String windowToken = this.mWindow.toString();
        L7:
            return "A11yWindow=[" + windowToken + ", displayId=" + this.mDisplayId + ", inputConfig=0x" + Integer.toHexString(this.mInputConfig) + ", type=" + this.mType + ", privateFlag=0x" + Integer.toHexString(this.mPrivateFlags) + ", focused=" + this.mIsFocused + ", shouldMagnify=" + this.mShouldMagnify + ", isTrustedOverlay=" + isTrustedOverlay() + ", regionInScreen=" + this.mTouchableRegionInScreen + ", touchableRegion=" + this.mTouchableRegionInWindow + ", isPIPMenu=" + this.mIsPIPMenu + ", windowInfo=" + this.mWindowInfo + "]";
        L5:
            windowToken = "(no window token)";
            goto L7
        }
    }

    private class MyHandler extends Handler {
        public static final int MESSAGE_NOTIFY_WINDOWS_CHANGED = 1;
        public static final int MESSAGE_NOTIFY_WINDOWS_CHANGED_BY_TIMEOUT = 3;
        public static final int MESSAGE_NOTIFY_WINDOWS_CHANGED_BY_UI_STABLE = 2;
        final /* synthetic */ AccessibilityWindowsPopulator this$0;

        MyHandler(AccessibilityWindowsPopulator r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, false);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch(message.what) {
                case 1: goto L7;
                case 2: goto L6;
                case 3: goto L5;
                default: goto L11;
            };
        L5:
            Slog.w(AccessibilityWindowsPopulator.m9605$$Nest$sfgetTAG(), "Windows change within in 2 frames continuously over 500 ms and notify windows changed immediately");
            AccessibilityWindowsPopulator.m9602$$Nest$fgetmHandler(this.this$0).removeMessages(2);
            AccessibilityWindowsPopulator.m9603$$Nest$mforceUpdateWindows(this.this$0);
            return;
        L6:
            AccessibilityWindowsPopulator.m9603$$Nest$mforceUpdateWindows(this.this$0);
            return;
        L7:
            List<Integer> displayIdsForWindowsChanged = (List) message.obj;
            AccessibilityWindowsPopulator.m9604$$Nest$mnotifyWindowsChanged(this.this$0, displayIdsForWindowsChanged);
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$0ZOdxFPt5mH0JXsyDze2JXR79BQ(int r0, int r1) {
        lambda$dump$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$BH-4a-VMnVRz4jfRJ_1ndkIpLBQ, reason: not valid java name */
    public static /* synthetic */ void m9600$r8$lambda$BH4aVMnVRz4jfRJ_1ndkIpLBQ(PrintWriter r0, MagnificationSpec r1) {
        lambda$dump$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$FmzIIhm3p1e0E4EMWm4iYLyOTkY(PrintWriter r0, String r1, int r2, int r3) {
        lambda$dump$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$Ov2B_jJ4JELYpcSrjDOt0IVOvc8(PrintWriter r0, Matrix r1) {
        lambda$dump$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$eJUaCl84C2crO8ycCGqh-Wfj1do, reason: not valid java name */
    public static /* synthetic */ void m9601$r8$lambda$eJUaCl84C2crO8ycCGqhWfj1do(PrintWriter r0, List r1) {
        lambda$dump$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$fdndmmlyHS8VNpoJhf5Ye85Qano(PrintWriter r0, WindowInfosListener.DisplayInfo r1) {
        lambda$dump$3(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m9602$$Nest$fgetmHandler(AccessibilityWindowsPopulator r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mforceUpdateWindows, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9603$$Nest$mforceUpdateWindows(AccessibilityWindowsPopulator r0) {
        r0.forceUpdateWindows();
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyWindowsChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9604$$Nest$mnotifyWindowsChanged(AccessibilityWindowsPopulator r0, List r1) {
        r0.notifyWindowsChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9605$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsTempFloats, reason: not valid java name */
    static /* bridge */ /* synthetic */ float[] m9606$$Nest$sfgetsTempFloats() {
        return sTempFloats;
    }

    static {
        TAG = AccessibilityWindowsPopulator.class.getSimpleName();
        sTempFloats = new float[9];
    }

    AccessibilityWindowsPopulator(WindowManagerService service, AccessibilityController accessibilityController) {
        this.mInputWindowHandlesOnDisplays = new SparseArray();
        this.mMagnificationSpecInverseMatrix = new SparseArray();
        this.mDisplayInfos = new SparseArray();
        this.mCurrentMagnificationSpec = new SparseArray();
        this.mPreviousMagnificationSpec = new SparseArray();
        this.mVisibleWindows = new ArrayList();
        this.mWindowsNotificationEnabled = false;
        this.mWindowsTransformMatrixMap = new HashMap();
        this.mLock = new Object();
        this.mTempMatrix1 = new Matrix();
        this.mTempMatrix2 = new Matrix();
        this.mTempFloat1 = new float[9];
        this.mTempFloat2 = new float[9];
        this.mTempFloat3 = new float[9];
        this.mService = service;
        this.mAccessibilityController = accessibilityController;
        this.mHandler = new MyHandler(this, this.mService.mH.getLooper());
    }

    public void populateVisibleWindowsOnScreenLocked(int displayId, List<AccessibilityWindow> outWindows) {
        Matrix inverseMatrix = new Matrix();
        Matrix displayMatrix = new Matrix();
        Object r2 = this.mLock;
        monitor-enter(r2);
        List<InputWindowHandle> inputWindowHandles = this.mInputWindowHandlesOnDisplays.get(displayId);     // Catch: Throwable -> L9
        if (inputWindowHandles != null) goto L11;
        outWindows.clear();     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L11:
        inverseMatrix.set(this.mMagnificationSpecInverseMatrix.get(displayId));     // Catch: Throwable -> L9
        WindowInfosListener.DisplayInfo displayInfo = this.mDisplayInfos.get(displayId);     // Catch: Throwable -> L9
        if (displayInfo == null) goto L14;
        displayMatrix.set(displayInfo.mTransform);     // Catch: Throwable -> L9
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L9
        DisplayContent dc = this.mService.mRoot.getDisplayContent(displayId);
        ShellRoot shellroot = dc.mShellRoots.get(1);
        if (shellroot == null) goto L19;
        IBinder pipMenuIBinder = shellroot.getAccessibilityWindowToken();
    L20:
        Iterator<InputWindowHandle> r6 = inputWindowHandles.iterator();
    L22:
        if (r6.hasNext() == false) goto L24;
        InputWindowHandle windowHandle = r6.next();
        AccessibilityWindow accessibilityWindow = AccessibilityWindow.initializeData(this.mService, windowHandle, inverseMatrix, pipMenuIBinder, displayMatrix);
        outWindows.add(accessibilityWindow);
        goto L22
    L24:
        return;
    L19:
        pipMenuIBinder = null;
        goto L20
    L14:
        Slog.w(TAG, "The displayInfo of this displayId (" + displayId + ") called back from the surface fligner is null");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void onWindowInfosChanged(InputWindowHandle[] windowHandles, WindowInfosListener.DisplayInfo[] displayInfos) {
        onWindowInfosChangedInternal(windowHandles, displayInfos);
    }

    private void onWindowInfosChangedInternal(InputWindowHandle[] windowHandles, WindowInfosListener.DisplayInfo[] displayInfos) {
        List<InputWindowHandle> tempVisibleWindows = new ArrayList();
        int r1 = windowHandles.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L19;
        InputWindowHandle window = windowHandles[r3];
        if ((window.inputConfig & 2) != 0) goto L7;
        boolean visible = true;
    L9:
        if ((window.inputConfig & 65536) != 0) goto L11;
        boolean isNotClone = true;
    L12:
        boolean hasTouchableRegion = !window.touchableRegion.isEmpty();
        boolean hasNonEmptyFrame = true ^ window.frame.isEmpty();
        if (visible == false) goto L18;
        if (isNotClone == false) goto L18;
        if (hasTouchableRegion == false) goto L18;
        if (hasNonEmptyFrame == false) goto L18;
        tempVisibleWindows.add(window);
    L18:
        r3 = r3 + 1;
        goto L3
    L11:
        isNotClone = false;
        goto L12
    L7:
        visible = false;
        goto L9
    L19:
        HashMap<IBinder, Matrix> windowsTransformMatrixMap = getWindowsTransformMatrix(tempVisibleWindows);
        Object r4 = this.mLock;
        monitor-enter(r4);
        this.mWindowsTransformMatrixMap.clear();     // Catch: Throwable -> L24
        this.mWindowsTransformMatrixMap.putAll(windowsTransformMatrixMap);     // Catch: Throwable -> L24
        this.mVisibleWindows.clear();     // Catch: Throwable -> L24
        this.mVisibleWindows.addAll(tempVisibleWindows);     // Catch: Throwable -> L24
        this.mDisplayInfos.clear();     // Catch: Throwable -> L24
        int r5 = displayInfos.length;     // Catch: Throwable -> L24
    L22:
        if (r2 >= r5) goto L27;
        WindowInfosListener.DisplayInfo displayInfo = displayInfos[r2];     // Catch: Throwable -> L24
        this.mDisplayInfos.put(displayInfo.mDisplayId, displayInfo);     // Catch: Throwable -> L24
        r2 = r2 + 1;     // Catch: Throwable -> L24
        goto L22
    L27:
        if (this.mWindowsNotificationEnabled == true) goto L29;
    L32:
        monitor-exit(r4);     // Catch: Throwable -> L24
        return;
    L29:
        if (this.mHandler.hasMessages(3) == true) goto L31;
        this.mHandler.sendEmptyMessageDelayed(3, 450);     // Catch: Throwable -> L24
    L31:
        populateVisibleWindowHandlesAndNotifyWindowsChangeIfNeeded();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private HashMap<IBinder, Matrix> getWindowsTransformMatrix(List<InputWindowHandle> windows) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        HashMap<IBinder, Matrix> windowsTransformMatrixMap = new HashMap();     // Catch: Throwable -> L10
        Iterator<InputWindowHandle> r2 = windows.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L19;
        InputWindowHandle inputWindowHandle = r2.next();     // Catch: Throwable -> L10
        IBinder iWindow = inputWindowHandle.getWindowToken();     // Catch: Throwable -> L10
        if (iWindow == null) goto L12;
        WindowState windowState = this.mService.mWindowMap.get(iWindow);     // Catch: Throwable -> L10
    L14:
        if (windowState == null) goto L6;
        if (windowState.shouldMagnify() == false) goto L6;
        Matrix transformMatrix = new Matrix();     // Catch: Throwable -> L10
        windowState.getTransformationMatrix(sTempFloats, transformMatrix);     // Catch: Throwable -> L10
        windowsTransformMatrixMap.put(iWindow, transformMatrix);     // Catch: Throwable -> L10
        goto L6
    L12:
        windowState = null;
        goto L14
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return windowsTransformMatrixMap;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void setWindowsNotification(boolean register) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mWindowsNotificationEnabled != register) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mWindowsNotificationEnabled = register;     // Catch: Throwable -> L8
        if (this.mWindowsNotificationEnabled == false) goto L13;
        Pair<InputWindowHandle[], WindowInfosListener.DisplayInfo[]> info = register();     // Catch: Throwable -> L8
        onWindowInfosChangedInternal((InputWindowHandle[]) info.first, (WindowInfosListener.DisplayInfo[]) info.second);     // Catch: Throwable -> L8
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        unregister();     // Catch: Throwable -> L8
        releaseResources();     // Catch: Throwable -> L8
        goto L14
    }

    public void setMagnificationSpec(int displayId, MagnificationSpec spec) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        MagnificationSpec currentMagnificationSpec = this.mCurrentMagnificationSpec.get(displayId);     // Catch: Throwable -> L9
        if (currentMagnificationSpec != null) goto L11;
        MagnificationSpec currentMagnificationSpec2 = new MagnificationSpec();     // Catch: Throwable -> L9
        currentMagnificationSpec2.setTo(spec);     // Catch: Throwable -> L9
        this.mCurrentMagnificationSpec.put(displayId, currentMagnificationSpec2);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        MagnificationSpec previousMagnificationSpec = this.mPreviousMagnificationSpec.get(displayId);     // Catch: Throwable -> L9
        if (previousMagnificationSpec != null) goto L14;
        previousMagnificationSpec = new MagnificationSpec();     // Catch: Throwable -> L9
        this.mPreviousMagnificationSpec.put(displayId, previousMagnificationSpec);     // Catch: Throwable -> L9
    L14:
        previousMagnificationSpec.setTo(currentMagnificationSpec);     // Catch: Throwable -> L9
        currentMagnificationSpec.setTo(spec);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void populateVisibleWindowHandlesAndNotifyWindowsChangeIfNeeded() {
        SparseArray<List<InputWindowHandle>> tempWindowHandleList = new SparseArray();
        Iterator<InputWindowHandle> r1 = this.mVisibleWindows.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        InputWindowHandle windowHandle = r1.next();
        List<InputWindowHandle> inputWindowHandles = tempWindowHandleList.get(windowHandle.displayId);
        if (inputWindowHandles != null) goto L8;
        inputWindowHandles = new ArrayList();
        tempWindowHandleList.put(windowHandle.displayId, inputWindowHandles);
    L8:
        inputWindowHandles.add(windowHandle);
        goto L4
    L9:
        findMagnificationSpecInverseMatrixIfNeeded(tempWindowHandleList);
        List<Integer> displayIdsForWindowsChanged = new ArrayList();
        getDisplaysForWindowsChanged(displayIdsForWindowsChanged, tempWindowHandleList, this.mInputWindowHandlesOnDisplays);
        this.mInputWindowHandlesOnDisplays.clear();
        int i = 0;
    L11:
        if (i >= tempWindowHandleList.size()) goto L14;
        int displayId = tempWindowHandleList.keyAt(i);
        this.mInputWindowHandlesOnDisplays.put(displayId, tempWindowHandleList.get(displayId));
        i = i + 1;
        goto L11
    L14:
        if (displayIdsForWindowsChanged.isEmpty() == false) goto L16;
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, 35);
        return;
    L16:
        if (this.mHandler.hasMessages(1) == true) goto L25;
        this.mHandler.obtainMessage(1, displayIdsForWindowsChanged).sendToTarget();
        return;
    }

    private static void getDisplaysForWindowsChanged(List<Integer> outDisplayIdsForWindowsChanged, SparseArray<List<InputWindowHandle>> newWindowsList, SparseArray<List<InputWindowHandle>> oldWindowsList) {
        int i = 0;
    L4:
        if (i >= newWindowsList.size()) goto L10;
        int displayId = newWindowsList.keyAt(i);
        List<InputWindowHandle> newWindows = newWindowsList.get(displayId);
        List<InputWindowHandle> oldWindows = oldWindowsList.get(displayId);
        if (hasWindowsChanged(newWindows, oldWindows) == false) goto L8;
        outDisplayIdsForWindowsChanged.add(Integer.valueOf(displayId));
    L8:
        i = i + 1;
        goto L4
    }

    private static boolean hasWindowsChanged(List<InputWindowHandle> newWindows, List<InputWindowHandle> oldWindows) {
        if (oldWindows != null) goto L5;
    L26:
        return true;
    L5:
        if (oldWindows.size() != newWindows.size()) goto L26;
        int windowsCount = newWindows.size();
        int i = 0;
    L8:
        boolean hasOldWindowToken = false;
        if (i >= windowsCount) goto L25;
        IBinder newWindowToken = newWindows.get(i).getWindowToken();
        IBinder oldWindowToken = oldWindows.get(i).getWindowToken();
        if (newWindowToken == null) goto L13;
        boolean hasNewWindowToken = true;
    L14:
        if (oldWindowToken == null) goto L16;
        hasOldWindowToken = true;
    L16:
        if (hasNewWindowToken != hasOldWindowToken) goto L17;
        if (hasNewWindowToken == false) goto L23;
        if (hasOldWindowToken == false) goto L23;
        if (newWindowToken.equals(oldWindowToken) == true) goto L23;
        return true;
    L23:
        i = i + 1;
        goto L8
    L17:
        return true;
    L13:
        hasNewWindowToken = false;
        goto L14
    L25:
        return false;
    }

    private void findMagnificationSpecInverseMatrixIfNeeded(SparseArray<List<InputWindowHandle>> windowHandleList) {
        int i = 0;
    L4:
        if (i >= windowHandleList.size()) goto L14;
        int displayId = windowHandleList.keyAt(i);
        List<InputWindowHandle> inputWindowHandles = windowHandleList.get(displayId);
        MagnificationSpec currentSpec = this.mCurrentMagnificationSpec.get(displayId);
        if (currentSpec == null) goto L12;
        MagnificationSpec currentMagnificationSpec = new MagnificationSpec();
        currentMagnificationSpec.setTo(currentSpec);
        MagnificationSpec previousSpec = this.mPreviousMagnificationSpec.get(displayId);
        if (previousSpec != null) goto L11;
        Matrix inverseMatrixForCurrentSpec = new Matrix();
        generateInverseMatrix(currentMagnificationSpec, inverseMatrixForCurrentSpec);
        this.mMagnificationSpecInverseMatrix.put(displayId, inverseMatrixForCurrentSpec);
        goto L12
    L11:
        MagnificationSpec previousMagnificationSpec = new MagnificationSpec();
        previousMagnificationSpec.setTo(previousSpec);
        generateInverseMatrixBasedOnProperMagnificationSpecForDisplay(inputWindowHandles, currentMagnificationSpec, previousMagnificationSpec);
    L12:
        i = i + 1;
        goto L4
    }

    private void generateInverseMatrixBasedOnProperMagnificationSpecForDisplay(List<InputWindowHandle> inputWindowHandles, MagnificationSpec currentMagnificationSpec, MagnificationSpec previousMagnificationSpec) {
        int index = inputWindowHandles.size() - 1;
    L3:
        if (index < 0) goto L11;
        Matrix windowTransformMatrix = this.mTempMatrix2;
        InputWindowHandle windowHandle = inputWindowHandles.get(index);
        IBinder iBinder = windowHandle.getWindowToken();
        if (getWindowTransformMatrix(iBinder, windowTransformMatrix) == true) goto L6;
        index = index - 1;
        goto L3
    L6:
        generateMagnificationSpecInverseMatrix(windowHandle, currentMagnificationSpec, previousMagnificationSpec, windowTransformMatrix);
        return;
    }

    private boolean getWindowTransformMatrix(IBinder iBinder, Matrix outTransform) {
        if (iBinder == null) goto L4;
        Matrix windowMatrix = this.mWindowsTransformMatrixMap.get(iBinder);
    L5:
        if (windowMatrix != null) goto L8;
        return false;
    L8:
        outTransform.set(windowMatrix);
        return true;
    L4:
        windowMatrix = null;
        goto L5
    }

    private void generateMagnificationSpecInverseMatrix(InputWindowHandle inputWindowHandle, MagnificationSpec currentMagnificationSpec, MagnificationSpec previousMagnificationSpec, Matrix transformMatrix) {
        float[] identityMatrixFloatsForCurrentSpec = this.mTempFloat1;
        computeIdentityMatrix(inputWindowHandle, currentMagnificationSpec, transformMatrix, identityMatrixFloatsForCurrentSpec);
        float[] identityMatrixFloatsForPreviousSpec = this.mTempFloat2;
        computeIdentityMatrix(inputWindowHandle, previousMagnificationSpec, transformMatrix, identityMatrixFloatsForPreviousSpec);
        Matrix inverseMatrixForMagnificationSpec = new Matrix();
        if (selectProperMagnificationSpecByComparingIdentityDegree(identityMatrixFloatsForCurrentSpec, identityMatrixFloatsForPreviousSpec) == false) goto L8;
        generateInverseMatrix(currentMagnificationSpec, inverseMatrixForMagnificationSpec);
        this.mPreviousMagnificationSpec.remove(inputWindowHandle.displayId);
        if (currentMagnificationSpec.isNop() == false) goto L9;
        this.mCurrentMagnificationSpec.remove(inputWindowHandle.displayId);
        this.mMagnificationSpecInverseMatrix.remove(inputWindowHandle.displayId);
        return;
    L9:
        this.mMagnificationSpecInverseMatrix.put(inputWindowHandle.displayId, inverseMatrixForMagnificationSpec);
        return;
    L8:
        generateInverseMatrix(previousMagnificationSpec, inverseMatrixForMagnificationSpec);
        goto L9
    }

    private void computeIdentityMatrix(InputWindowHandle inputWindowHandle, MagnificationSpec magnificationSpec, Matrix transformMatrix, float[] magnifyMatrixFloats) {
        Matrix specMatrix = this.mTempMatrix1;
        transformMagnificationSpecToMatrix(magnificationSpec, specMatrix);
        Matrix resultMatrix = new Matrix(inputWindowHandle.transform);
        resultMatrix.preConcat(specMatrix);
        resultMatrix.preConcat(transformMatrix);
        resultMatrix.getValues(magnifyMatrixFloats);
    }

    private boolean selectProperMagnificationSpecByComparingIdentityDegree(float[] magnifyMatrixFloatsForSpecOne, float[] magnifyMatrixFloatsForSpecTwo) {
        float[] IdentityMatrixValues = this.mTempFloat3;
        Matrix.IDENTITY_MATRIX.getValues(IdentityMatrixValues);
        float scaleDiffForSpecOne = Math.abs(IdentityMatrixValues[0] - magnifyMatrixFloatsForSpecOne[0]);
        float scaleDiffForSpecTwo = Math.abs(IdentityMatrixValues[0] - magnifyMatrixFloatsForSpecTwo[0]);
        float offsetXDiffForSpecOne = Math.abs(IdentityMatrixValues[2] - magnifyMatrixFloatsForSpecOne[2]);
        float offsetXDiffForSpecTwo = Math.abs(IdentityMatrixValues[2] - magnifyMatrixFloatsForSpecTwo[2]);
        float offsetYDiffForSpecOne = Math.abs(IdentityMatrixValues[5] - magnifyMatrixFloatsForSpecOne[5]);
        float offsetYDiffForSpecTwo = Math.abs(IdentityMatrixValues[5] - magnifyMatrixFloatsForSpecTwo[5]);
        float offsetDiffForSpecOne = offsetXDiffForSpecOne + offsetYDiffForSpecOne;
        float offsetDiffForSpecTwo = offsetXDiffForSpecTwo + offsetYDiffForSpecTwo;
        if (Float.compare(scaleDiffForSpecTwo, scaleDiffForSpecOne) <= 0) goto L5;
    L10:
        return true;
    L5:
        if (Float.compare(scaleDiffForSpecTwo, scaleDiffForSpecOne) == 0) goto L7;
        return false;
    L7:
        if (Float.compare(offsetDiffForSpecTwo, offsetDiffForSpecOne) > 0) goto L10;
        return false;
    }

    private static void generateInverseMatrix(MagnificationSpec spec, Matrix outMatrix) {
        outMatrix.reset();
        Matrix tempMatrix = new Matrix();
        transformMagnificationSpecToMatrix(spec, tempMatrix);
        boolean result = tempMatrix.invert(outMatrix);
        if (result == true) goto L6;
        Slog.e(TAG, "Can't inverse the magnification spec matrix with the magnification spec = " + spec);
        outMatrix.reset();
        return;
    }

    private static void transformMagnificationSpecToMatrix(MagnificationSpec spec, Matrix outMatrix) {
        outMatrix.reset();
        outMatrix.postScale(spec.scale, spec.scale);
        outMatrix.postTranslate(spec.offsetX, spec.offsetY);
    }

    private void notifyWindowsChanged(List<Integer> displayIdsForWindowsChanged) {
        this.mHandler.removeMessages(3);
        int i = 0;
    L4:
        if (i >= displayIdsForWindowsChanged.size()) goto L7;
        this.mAccessibilityController.performComputeChangedWindowsNot(displayIdsForWindowsChanged.get(i).intValue(), false);
        i = i + 1;
        goto L4
    }

    private void forceUpdateWindows() {
        List<Integer> displayIdsForWindowsChanged = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int i = 0;
    L16:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mInputWindowHandlesOnDisplays.size()) goto L11;
        int displayId = this.mInputWindowHandlesOnDisplays.keyAt(i);     // Catch: Throwable -> L8
        displayIdsForWindowsChanged.add(Integer.valueOf(displayId));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L16
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L8
        notifyWindowsChanged(displayIdsForWindowsChanged);
    }

    void dump(final PrintWriter pw, final String prefix) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        pw.print(prefix);     // Catch: Throwable -> L18
        pw.println("AccessibilityWindowsPopulator");     // Catch: Throwable -> L18
        String prefix2 = prefix + "  ";     // Catch: Throwable -> L18
        pw.print(prefix2);     // Catch: Throwable -> L18
        pw.print("mWindowsNotificationEnabled: ");     // Catch: Throwable -> L18
        pw.println(this.mWindowsNotificationEnabled);     // Catch: Throwable -> L18
        if (this.mVisibleWindows.isEmpty() == true) goto L24;
        pw.print(prefix2);     // Catch: Throwable -> L18
        pw.print(this.mVisibleWindows.size());     // Catch: Throwable -> L18
        pw.print(" visible windows: ");     // Catch: Throwable -> L18
        pw.println(this.mVisibleWindows);     // Catch: Throwable -> L18
    L11:
        DumpUtils.KeyDumper noKeyDumper = new AccessibilityWindowsPopulator$$ExternalSyntheticLambda0();     // Catch: Throwable -> L18
        DumpUtils.KeyDumper displayDumper = new AccessibilityWindowsPopulator$$ExternalSyntheticLambda1(pw, prefix);     // Catch: Throwable -> L18
        DumpUtils.ValueDumper<MagnificationSpec> magnificationSpecDumper = new AccessibilityWindowsPopulator$$ExternalSyntheticLambda2(pw);     // Catch: Throwable -> L18
        DumpUtils.dumpSparseArray(pw, prefix2, this.mDisplayInfos, "display info", noKeyDumper, new AccessibilityWindowsPopulator$$ExternalSyntheticLambda3(pw));     // Catch: Throwable -> L16
        DumpUtils.dumpSparseArray(pw, prefix2, this.mInputWindowHandlesOnDisplays, "window handles on display", displayDumper, new AccessibilityWindowsPopulator$$ExternalSyntheticLambda4(pw));     // Catch: Throwable -> L16
        DumpUtils.dumpSparseArray(pw, prefix2, this.mMagnificationSpecInverseMatrix, "magnification spec matrix", noKeyDumper, new AccessibilityWindowsPopulator$$ExternalSyntheticLambda5(pw));     // Catch: Throwable -> L16
        DumpUtils.dumpSparseArray(pw, prefix2, this.mCurrentMagnificationSpec, "current magnification spec", noKeyDumper, magnificationSpecDumper);     // Catch: Throwable -> L16
        DumpUtils.dumpSparseArray(pw, prefix2, this.mPreviousMagnificationSpec, "previous magnification spec", noKeyDumper, magnificationSpecDumper);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L24:
        pw.print(prefix2);     // Catch: Throwable -> L8
        pw.println("No visible windows");     // Catch: Throwable -> L8
    L8:
        th = th;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L16
        throw th;
    L16:
        th = th;
    L18:
        th = th;
        goto L20
    }

    private static /* synthetic */ void lambda$dump$0(int i, int k) {
    }

    private static /* synthetic */ void lambda$dump$1(PrintWriter pw, String prefix, int i, int d) {
        pw.printf("%sDisplay #%d: ", new Object[]{prefix, Integer.valueOf(d)});
    }

    private static /* synthetic */ void lambda$dump$2(PrintWriter pw, MagnificationSpec spec) {
        pw.print(spec);
    }

    private static /* synthetic */ void lambda$dump$3(PrintWriter pw, WindowInfosListener.DisplayInfo d) {
        pw.print(d);
    }

    private static /* synthetic */ void lambda$dump$4(PrintWriter pw, List list) {
        pw.print(list);
    }

    private static /* synthetic */ void lambda$dump$5(PrintWriter pw, Matrix matrix) {
        matrix.dump(pw);
    }

    private void releaseResources() {
        this.mInputWindowHandlesOnDisplays.clear();
        this.mMagnificationSpecInverseMatrix.clear();
        this.mVisibleWindows.clear();
        this.mDisplayInfos.clear();
        this.mCurrentMagnificationSpec.clear();
        this.mPreviousMagnificationSpec.clear();
        this.mWindowsTransformMatrixMap.clear();
        this.mWindowsNotificationEnabled = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
