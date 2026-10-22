package com.android.server.accessibility;

import android.accessibilityservice.AccessibilityGestureEvent;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.AccessibilityTrace;
import android.accessibilityservice.IAccessibilityServiceClient;
import android.accessibilityservice.IAccessibilityServiceConnection;
import android.accessibilityservice.IBrailleDisplayController;
import android.accessibilityservice.MagnificationConfig;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ParceledListSlice;
import android.graphics.ParcelableColorSpace;
import android.graphics.Region;
import android.hardware.HardwareBuffer;
import android.hardware.display.DisplayManager;
import android.hardware.usb.UsbDevice;
import android.os.Binder;
import android.os.Bundle;
import android.os.FrozenObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PermissionEnforcer;
import android.os.PowerManager;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MagnificationSpec;
import android.view.MotionEvent;
import android.view.SurfaceControl;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import android.view.accessibility.IAccessibilityInteractionConnectionCallback;
import android.view.accessibility.IWindowSurfaceInfoCallback;
import android.view.inputmethod.EditorInfo;
import android.window.ScreenCapture;
import com.android.internal.compat.IPlatformCompat;
import com.android.internal.inputmethod.IAccessibilityInputMethodSession;
import com.android.internal.inputmethod.IRemoteAccessibilityInputConnection;
import com.android.internal.os.SomeArgs;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.accessibility.magnification.MagnificationProcessor;
import com.android.server.pm.UserManagerService;
import com.android.server.wm.WindowManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
abstract class AbstractAccessibilityServiceConnection extends IAccessibilityServiceConnection.Stub implements ServiceConnection, IBinder.DeathRecipient, KeyEventDispatcher.KeyEventFilter, FingerprintGestureDispatcher.FingerprintGestureClient {
    private static final boolean DEBUG = false;
    public static final int DISPLAY_TYPE_DEFAULT = 1;
    public static final int DISPLAY_TYPE_PROXY = 2;
    private static final String LOG_TAG = "AbstractAccessibilityServiceConnection";
    protected static final String TAKE_SCREENSHOT = "takeScreenshot";
    private static final String TRACE_SVC_CLIENT = "AbstractAccessibilityServiceConnection.IAccessibilityServiceClient";
    private static final String TRACE_SVC_CONN = "AbstractAccessibilityServiceConnection.IAccessibilityServiceConnection";
    private static final String TRACE_WM = "WindowManagerInternal";
    private static final int WAIT_WINDOWS_TIMEOUT_MILLIS = 5000;
    final AccessibilityWindowManager mA11yWindowManager;
    protected final AccessibilityServiceInfo mAccessibilityServiceInfo;
    protected String mAttributionTag;
    boolean mCaptureFingerprintGestures;
    IAccessibilityServiceClient mClient;
    IBinder mClientBinder;
    final ComponentName mComponentName;
    protected final Context mContext;
    private final DisplayManager mDisplayManager;
    protected int mDisplayTypes;
    public Handler mEventDispatchHandler;
    int mEventTypes;
    int mFeedbackType;
    int mFetchFlags;
    int mGenericMotionEventSources;
    private final IPlatformCompat mIPlatformCompat;
    final int mId;
    public final InvocationHandler mInvocationHandler;
    boolean mIsDefault;
    boolean mLastAccessibilityButtonCallbackState;
    protected final Object mLock;
    private final Handler mMainHandler;
    long mNotificationTimeout;
    int mObservedMotionEventSources;
    final SparseArray<IBinder> mOverlayWindowTokens;
    private List<SurfaceControl> mOverlays;
    Set<String> mPackageNames;
    final SparseArray<AccessibilityEvent> mPendingEvents;
    private final PowerManager mPowerManager;
    boolean mReceivedAccessibilityButtonCallbackSinceBind;
    boolean mRequestAccessibilityButton;
    boolean mRequestFilterKeyEvents;
    boolean mRequestImeApis;
    private boolean mRequestMultiFingerGestures;
    private SparseArray<Long> mRequestTakeScreenshotOfWindowTimestampMs;
    private long mRequestTakeScreenshotTimestampMs;
    boolean mRequestTouchExplorationMode;
    private boolean mRequestTwoFingerPassthrough;
    boolean mRetrieveInteractiveWindows;
    protected final AccessibilitySecurityPolicy mSecurityPolicy;
    private boolean mSendMotionEvents;
    private SparseArray<Boolean> mServiceDetectsGestures;
    private boolean mServiceHandlesDoubleTap;
    private final SystemActionPerformer mSystemActionPerformer;
    protected final SystemSupport mSystemSupport;
    protected final AccessibilityTrace mTrace;
    boolean mUsesAccessibilityCache;
    protected final WindowManagerInternal mWindowManagerService;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayTypes {
    }

    private final class InvocationHandler extends Handler {
        private static final int MSG_BIND_INPUT = 12;
        public static final int MSG_CLEAR_ACCESSIBILITY_CACHE = 2;
        private static final int MSG_CREATE_IME_SESSION = 10;
        private static final int MSG_ON_ACCESSIBILITY_BUTTON_AVAILABILITY_CHANGED = 8;
        private static final int MSG_ON_ACCESSIBILITY_BUTTON_CLICKED = 7;
        public static final int MSG_ON_GESTURE = 1;
        private static final int MSG_ON_MAGNIFICATION_CHANGED = 5;
        private static final int MSG_ON_SOFT_KEYBOARD_STATE_CHANGED = 6;
        private static final int MSG_ON_SYSTEM_ACTIONS_CHANGED = 9;
        private static final int MSG_SET_IME_SESSION_ENABLED = 11;
        private static final int MSG_START_INPUT = 14;
        private static final int MSG_UNBIND_INPUT = 13;
        private boolean mIsSoftKeyboardCallbackEnabled;
        private final SparseArray<Boolean> mMagnificationCallbackState;
        final /* synthetic */ AbstractAccessibilityServiceConnection this$0;

        public InvocationHandler(AbstractAccessibilityServiceConnection r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, true);
            this.mMagnificationCallbackState = new SparseArray(0);
            this.mIsSoftKeyboardCallbackEnabled = false;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int type = message.what;
            boolean restarting = false;
            switch(type) {
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L5;
                case 4: goto L5;
                case 5: goto L24;
                case 6: goto L23;
                case 7: goto L22;
                case 8: goto L19;
                case 9: goto L17;
                case 10: goto L16;
                case 11: goto L13;
                case 12: goto L11;
                case 13: goto L10;
                case 14: goto L7;
                default: goto L5;
            };
        L10:
            AbstractAccessibilityServiceConnection.m541$$Nest$munbindInputInternal(this.this$0);
            return;
        L11:
            AbstractAccessibilityServiceConnection.m529$$Nest$mbindInputInternal(this.this$0);
            return;
        L16:
            this.this$0.createImeSessionInternal();
            return;
        L17:
            AbstractAccessibilityServiceConnection.m538$$Nest$mnotifySystemActionsChangedInternal(this.this$0);
            return;
        L22:
            int displayId = message.arg1;
            AbstractAccessibilityServiceConnection.m532$$Nest$mnotifyAccessibilityButtonClickedInternal(this.this$0, displayId);
            return;
        L23:
            int showState = message.arg1;
            AbstractAccessibilityServiceConnection.m537$$Nest$mnotifySoftKeyboardShowModeChangedInternal(this.this$0, showState);
            return;
        L24:
            SomeArgs args = (SomeArgs) message.obj;
            Region region = (Region) args.arg1;
            MagnificationConfig config = (MagnificationConfig) args.arg2;
            int displayId2 = args.argi1;
            AbstractAccessibilityServiceConnection.m536$$Nest$mnotifyMagnificationChangedInternal(this.this$0, displayId2, region, config);
            args.recycle();
            return;
        L25:
            AbstractAccessibilityServiceConnection.m534$$Nest$mnotifyClearAccessibilityCacheInternal(this.this$0);
            return;
        L26:
            Object r1 = message.obj;
            if ((r1 instanceof AccessibilityGestureEvent) == false) goto L42;
            AccessibilityGestureEvent gesture = (AccessibilityGestureEvent) r1;
            AbstractAccessibilityServiceConnection.m535$$Nest$mnotifyGestureInternal(this.this$0, gesture);
            gesture.recycle();
            return;
        L42:
            return;
        L5:
            throw new IllegalArgumentException("Unknown message: " + type);
        L7:
            if (message.arg1 == 0) goto L9;
            restarting = true;
        L9:
            SomeArgs args2 = (SomeArgs) message.obj;
            IRemoteAccessibilityInputConnection connection = (IRemoteAccessibilityInputConnection) args2.arg1;
            EditorInfo editorInfo = (EditorInfo) args2.arg2;
            AbstractAccessibilityServiceConnection.m540$$Nest$mstartInputInternal(this.this$0, connection, editorInfo, restarting);
            args2.recycle();
            return;
        L13:
            if (message.arg1 == 0) goto L15;
            restarting = true;
        L15:
            IAccessibilityInputMethodSession session = (IAccessibilityInputMethodSession) message.obj;
            AbstractAccessibilityServiceConnection.m539$$Nest$msetImeSessionEnabledInternal(this.this$0, session, restarting);
            return;
        L19:
            if (message.arg1 == 0) goto L21;
            restarting = true;
        L21:
            AbstractAccessibilityServiceConnection.m531$$Nest$mnotifyAccessibilityButtonAvailabilityChangedInternal(this.this$0, restarting);
        }

        public void notifyMagnificationChangedLocked(int displayId, Region region, MagnificationConfig config) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mMagnificationCallbackState.get(displayId) != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            SomeArgs args = SomeArgs.obtain();
            args.arg1 = region;
            args.arg2 = config;
            args.argi1 = displayId;
            Message msg = obtainMessage(5, args);
            msg.sendToTarget();
        }

        public void setMagnificationCallbackEnabled(int displayId, boolean enabled) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            if (enabled == false) goto L8;
            this.mMagnificationCallbackState.put(displayId, true);     // Catch: Throwable -> L6
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L6
            return;
        L8:
            this.mMagnificationCallbackState.remove(displayId);     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }

        public boolean isMagnificationCallbackEnabled(int displayId) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mMagnificationCallbackState.get(displayId) == null) goto L7;
            boolean r1 = true;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = false;
            goto L8
        }

        public void notifySoftKeyboardShowModeChangedLocked(int showState) {
            if (this.mIsSoftKeyboardCallbackEnabled == true) goto L5;
            return;
        L5:
            Message msg = obtainMessage(6, showState, 0);
            msg.sendToTarget();
        }

        public void setSoftKeyboardCallbackEnabled(boolean enabled) {
            this.mIsSoftKeyboardCallbackEnabled = enabled;
        }

        public void notifyAccessibilityButtonClickedLocked(int displayId) {
            Message msg = obtainMessage(7, displayId, 0);
            msg.sendToTarget();
        }

        public void notifyAccessibilityButtonAvailabilityChangedLocked(boolean r3) {
            obtainMessage(8, r3 ? 1 : 0, 0).sendToTarget();
        }

        public void createImeSessionLocked() {
            Message msg = obtainMessage(10);
            msg.sendToTarget();
        }

        public void setImeSessionEnabledLocked(IAccessibilityInputMethodSession r3, boolean r4) {
            obtainMessage(11, r4 ? 1 : 0, 0, r3).sendToTarget();
        }

        public void bindInputLocked() {
            Message msg = obtainMessage(12);
            msg.sendToTarget();
        }

        public void unbindInputLocked() {
            Message msg = obtainMessage(13);
            msg.sendToTarget();
        }

        public void startInputLocked(IRemoteAccessibilityInputConnection r4, EditorInfo r5, boolean r6) {
            SomeArgs r0 = SomeArgs.obtain();
            r0.arg1 = r4;
            r0.arg2 = r5;
            obtainMessage(14, r6 ? 1 : 0, 0, r0).sendToTarget();
        }
    }

    public interface SystemSupport {
        void attachAccessibilityOverlayToDisplay(int r1, int r2, SurfaceControl r3, IAccessibilityInteractionConnectionCallback r4);

        void clearFrequencyLimit(AbstractAccessibilityServiceConnection r1);

        int getCurrentUserIdLocked();

        FingerprintGestureDispatcher getFingerprintGestureDispatcher();

        KeyEventDispatcher getKeyEventDispatcher();

        MagnificationProcessor getMagnificationProcessor();

        MotionEventInjector getMotionEventInjectorForDisplayLocked(int r1);

        PendingIntent getPendingIntentActivity(Context r1, int r2, Intent r3, int r4);

        Pair<float[], MagnificationSpec> getWindowTransformationMatrixAndMagnificationSpec(int r1);

        boolean isAccessibilityButtonShown();

        void onClientChangeLocked(boolean r1);

        void onDoubleTap(int r1);

        void onDoubleTapAndHold(int r1);

        void onProxyChanged(int r1);

        int performScreenCapture(ScreenCapture.LayerCaptureArgs r1, ScreenCapture.ScreenCaptureListener r2);

        void persistComponentNamesToSettingLocked(String r1, Set<ComponentName> r2, int r3);

        void requestDelegating(int r1);

        void requestDragging(int r1, int r2);

        void requestImeLocked(AbstractAccessibilityServiceConnection r1);

        void requestTouchExploration(int r1);

        void setGestureDetectionPassthroughRegion(int r1, Region r2);

        void setMinumumIntervalObric(String r1, int r2, int r3, AbstractAccessibilityServiceConnection r4);

        void setServiceDetectsGesturesEnabled(int r1, boolean r2);

        void setTouchExplorationPassthroughRegion(int r1, Region r2);

        void unbindImeLocked(AbstractAccessibilityServiceConnection r1);
    }

    public static /* synthetic */ void $r8$lambda$AuvBYYix9PvW1HK3NjTRutmS4m4(AbstractAccessibilityServiceConnection r0, RemoteCallback r1, ScreenCapture.ScreenshotHardwareBuffer r2, int r3) {
        r0.lambda$takeScreenshot$0(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$D3S1FxwmLPWdlQKfTxBY0p12z1g(ScreenCapture.ScreenshotHardwareBuffer r0, RemoteCallback r1, Object r2) {
        lambda$sendScreenshotSuccess$1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Nv4_Qh1fAqCkHZEv5tCu4GdCf0o(int r0, RemoteCallback r1, Object r2) {
        lambda$sendScreenshotFailure$2(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mbindInputInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m529$$Nest$mbindInputInternal(AbstractAccessibilityServiceConnection r0) {
        r0.bindInputInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mcanCaptureSecureLayers, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m530$$Nest$mcanCaptureSecureLayers(AbstractAccessibilityServiceConnection r0) {
        return r0.canCaptureSecureLayers();
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyAccessibilityButtonAvailabilityChangedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m531$$Nest$mnotifyAccessibilityButtonAvailabilityChangedInternal(AbstractAccessibilityServiceConnection r0, boolean r1) {
        r0.notifyAccessibilityButtonAvailabilityChangedInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyAccessibilityButtonClickedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m532$$Nest$mnotifyAccessibilityButtonClickedInternal(AbstractAccessibilityServiceConnection r0, int r1) {
        r0.notifyAccessibilityButtonClickedInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyAccessibilityEventInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m533$$Nest$mnotifyAccessibilityEventInternal(AbstractAccessibilityServiceConnection r0, int r1, AccessibilityEvent r2, boolean r3) {
        r0.notifyAccessibilityEventInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyClearAccessibilityCacheInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m534$$Nest$mnotifyClearAccessibilityCacheInternal(AbstractAccessibilityServiceConnection r0) {
        r0.notifyClearAccessibilityCacheInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyGestureInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m535$$Nest$mnotifyGestureInternal(AbstractAccessibilityServiceConnection r0, AccessibilityGestureEvent r1) {
        r0.notifyGestureInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyMagnificationChangedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m536$$Nest$mnotifyMagnificationChangedInternal(AbstractAccessibilityServiceConnection r0, int r1, Region r2, MagnificationConfig r3) {
        r0.notifyMagnificationChangedInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifySoftKeyboardShowModeChangedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m537$$Nest$mnotifySoftKeyboardShowModeChangedInternal(AbstractAccessibilityServiceConnection r0, int r1) {
        r0.notifySoftKeyboardShowModeChangedInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifySystemActionsChangedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m538$$Nest$mnotifySystemActionsChangedInternal(AbstractAccessibilityServiceConnection r0) {
        r0.notifySystemActionsChangedInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$msetImeSessionEnabledInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m539$$Nest$msetImeSessionEnabledInternal(AbstractAccessibilityServiceConnection r0, IAccessibilityInputMethodSession r1, boolean r2) {
        r0.setImeSessionEnabledInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartInputInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m540$$Nest$mstartInputInternal(AbstractAccessibilityServiceConnection r0, IRemoteAccessibilityInputConnection r1, EditorInfo r2, boolean r3) {
        r0.startInputInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$munbindInputInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m541$$Nest$munbindInputInternal(AbstractAccessibilityServiceConnection r0) {
        r0.unbindInputInternal();
    }

    protected abstract boolean hasRightsToCurrentUserLocked();

    public AbstractAccessibilityServiceConnection(Context context, ComponentName componentName, AccessibilityServiceInfo accessibilityServiceInfo, int id, Handler mainHandler, Object lock, AccessibilitySecurityPolicy securityPolicy, SystemSupport systemSupport, AccessibilityTrace trace, WindowManagerInternal windowManagerInternal, SystemActionPerformer systemActionPerfomer, AccessibilityWindowManager a11yWindowManager) {
        super(PermissionEnforcer.fromContext(context));
        this.mDisplayTypes = 1;
        this.mPackageNames = new HashSet();
        this.mServiceDetectsGestures = new SparseArray(0);
        this.mPendingEvents = new SparseArray();
        this.mUsesAccessibilityCache = false;
        this.mOverlayWindowTokens = new SparseArray();
        this.mOverlays = new ArrayList();
        this.mRequestTakeScreenshotOfWindowTimestampMs = new SparseArray();
        this.mContext = context;
        this.mWindowManagerService = windowManagerInternal;
        this.mId = id;
        this.mComponentName = componentName;
        this.mAccessibilityServiceInfo = accessibilityServiceInfo;
        this.mLock = lock;
        this.mSecurityPolicy = securityPolicy;
        this.mSystemActionPerformer = systemActionPerfomer;
        this.mSystemSupport = systemSupport;
        this.mTrace = trace;
        this.mMainHandler = mainHandler;
        this.mInvocationHandler = new InvocationHandler(this, mainHandler.getLooper());
        this.mA11yWindowManager = a11yWindowManager;
        this.mDisplayManager = (DisplayManager) context.getSystemService("display");
        this.mPowerManager = (PowerManager) this.mContext.getSystemService("power");
        this.mIPlatformCompat = IPlatformCompat.Stub.asInterface(ServiceManager.getService("platform_compat"));
        final Looper r1 = mainHandler.getLooper();
        this.mEventDispatchHandler = new AnonymousClass1(this, r1);
        setDynamicallyConfigurableProperties(accessibilityServiceInfo);
    }

    @Override // com.android.server.accessibility.KeyEventDispatcher.KeyEventFilter
    public boolean onKeyEvent(KeyEvent keyEvent, int sequenceNumber) {
        if (this.mRequestFilterKeyEvents == true) goto L5;
    L23:
        return false;
    L5:
        if (this.mClient == null) goto L23;
        if ((this.mAccessibilityServiceInfo.getCapabilities() & 8) != 0) goto L11;
        return false;
    L11:
        if (this.mSecurityPolicy.checkAccessibilityAccess(this) == true) goto L24;
        return false;
    L24:
        if (svcClientTracingEnabled() == false) goto L18;
        logTraceSvcClient("onKeyEvent", keyEvent + ", " + sequenceNumber);     // Catch: RemoteException -> L16
    L18:
        this.mClient.onKeyEvent(keyEvent, sequenceNumber);     // Catch: RemoteException -> L16
        return true;
    L22:
        return false;
    }

    public void setDynamicallyConfigurableProperties(AccessibilityServiceInfo info) {
        this.mEventTypes = info.eventTypes;
        this.mFeedbackType = info.feedbackType;
        String[] packageNames = info.packageNames;
        this.mPackageNames.clear();
        if (packageNames == null) goto L5;
        this.mPackageNames.addAll(Arrays.asList(packageNames));
    L5:
        this.mNotificationTimeout = info.notificationTimeout;
        boolean r2 = true;
        if ((info.flags & 1) == 0) goto L8;
        boolean r1 = true;
    L9:
        this.mIsDefault = r1;
        this.mGenericMotionEventSources = info.getMotionEventSources();
        this.mObservedMotionEventSources = info.getObservedMotionEventSources();
        if (supportsFlagForNotImportantViews(info) == false) goto L16;
        if ((info.flags & 2) == 0) goto L14;
        this.mFetchFlags |= 128;
        goto L16
    L14:
        this.mFetchFlags &= -129;
    L16:
        if ((info.flags & 16) == 0) goto L18;
        this.mFetchFlags |= 256;
    L20:
        if (this.mAccessibilityServiceInfo.isAccessibilityTool() == false) goto L22;
        this.mFetchFlags |= 512;
    L24:
        if ((info.flags & 4) == 0) goto L26;
        boolean r3 = true;
    L27:
        this.mRequestTouchExplorationMode = r3;
        if ((info.flags & 2048) == 0) goto L30;
        boolean r4 = true;
    L31:
        this.mServiceHandlesDoubleTap = r4;
        if ((info.flags & 4096) == 0) goto L34;
        boolean r5 = true;
    L35:
        this.mRequestMultiFingerGestures = r5;
        if ((info.flags & 8192) == 0) goto L38;
        boolean r6 = true;
    L39:
        this.mRequestTwoFingerPassthrough = r6;
        if ((info.flags & 16384) == 0) goto L42;
        boolean r7 = true;
    L43:
        this.mSendMotionEvents = r7;
        if ((info.flags & 32) == 0) goto L46;
        boolean r8 = true;
    L47:
        this.mRequestFilterKeyEvents = r8;
        if ((info.flags & 64) == 0) goto L50;
        boolean r9 = true;
    L51:
        this.mRetrieveInteractiveWindows = r9;
        if ((info.flags & 512) == 0) goto L54;
        boolean r10 = true;
    L55:
        this.mCaptureFingerprintGestures = r10;
        if ((info.flags & 256) == 0) goto L58;
        boolean r11 = true;
    L59:
        this.mRequestAccessibilityButton = r11;
        if ((info.flags & 32768) != 0) goto L63;
        r2 = false;
    L63:
        this.mRequestImeApis = r2;
        return;
    L58:
        r11 = false;
        goto L59
    L54:
        r10 = false;
        goto L55
    L50:
        r9 = false;
        goto L51
    L46:
        r8 = false;
        goto L47
    L42:
        r7 = false;
        goto L43
    L38:
        r6 = false;
        goto L39
    L34:
        r5 = false;
        goto L35
    L30:
        r4 = false;
        goto L31
    L26:
        r3 = false;
        goto L27
    L22:
        this.mFetchFlags &= -513;
        goto L24
    L18:
        this.mFetchFlags &= -257;
        goto L20
    L8:
        r1 = false;
        goto L9
    }

    protected boolean supportsFlagForNotImportantViews(AccessibilityServiceInfo info) {
        if (info.getResolveInfo().serviceInfo.applicationInfo.targetSdkVersion < 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean canReceiveEventsLocked() {
        if (this.mEventTypes != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mClientBinder == null) goto L7;
        return true;
    }

    public void setOnKeyEventResult(boolean handled, int sequence) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("setOnKeyEventResult", "handled=" + handled + ";sequence=" + sequence);
    L5:
        long identity = Binder.clearCallingIdentity();
        this.mSystemSupport.getKeyEventDispatcher().setOnKeyEventResult(this, handled, sequence);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(identity);
        return;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public AccessibilityServiceInfo getServiceInfo() {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("getServiceInfo", "");
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        AccessibilityServiceInfo r1 = this.mAccessibilityServiceInfo;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public int getCapabilities() {
        return this.mAccessibilityServiceInfo.getCapabilities();
    }

    int getRelevantEventTypes() {
        if (this.mUsesAccessibilityCache == false) goto L5;
        int r0 = 4307005;
    L7:
        return r0 | this.mEventTypes;
    L5:
        r0 = 32;
        goto L7
    }

    public void setServiceInfo(AccessibilityServiceInfo info) {
        if (svcConnTracingEnabled() == false) goto L6;
        logTraceSvcConn("setServiceInfo", "info=" + info);
    L6:
        if (info.isWithinParcelableSize() == false) goto L39;
        if (info.getObservedMotionEventSources() != 0) goto L10;
    L12:
        long identity = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L35
        monitor-enter(r2);     // Catch: Throwable -> L35
        boolean oldRequestIme = this.mRequestImeApis;     // Catch: Throwable -> L18
        AccessibilityServiceInfo oldInfo = this.mAccessibilityServiceInfo;     // Catch: Throwable -> L18
        if (oldInfo == null) goto L20;
        oldInfo.updateDynamicallyConfigurableProperties(this.mIPlatformCompat, info);     // Catch: Throwable -> L18
        setDynamicallyConfigurableProperties(oldInfo);     // Catch: Throwable -> L18
    L21:
        this.mSystemSupport.onClientChangeLocked(true);     // Catch: Throwable -> L18
        if (oldRequestIme == false) goto L24;
    L26:
        if (oldRequestIme == true) goto L28;
    L30:
        monitor-exit(r2);     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(identity);
        return;
    L28:
        if (this.mRequestImeApis == true) goto L30;
        this.mSystemSupport.unbindImeLocked(this);     // Catch: Throwable -> L18
        goto L30
    L24:
        if (this.mRequestImeApis == false) goto L26;
        this.mSystemSupport.requestImeLocked(this);     // Catch: Throwable -> L18
        goto L30
    L20:
        setDynamicallyConfigurableProperties(info);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L10:
        if (this.mContext.checkCallingPermission("android.permission.ACCESSIBILITY_MOTION_EVENT_OBSERVING") == 0) goto L12;
        Slog.e(LOG_TAG, "Observing motion events requires permission android.permission.ACCESSIBILITY_MOTION_EVENT_OBSERVING");
        info.setObservedMotionEventSources(0);
        goto L12
    L39:
        throw new IllegalStateException("Cannot update service info: size is larger than safe parcelable limits.");
    }

    public void setInstalledAndEnabledServices(List<AccessibilityServiceInfo> infos) {
    }

    public List<AccessibilityServiceInfo> getInstalledAndEnabledServices() {
        return null;
    }

    public void setAttributionTag(String attributionTag) {
        this.mAttributionTag = attributionTag;
    }

    String getAttributionTag() {
        return this.mAttributionTag;
    }

    public AccessibilityWindowInfo.WindowListSparseArray getWindows() {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("getWindows", "");
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (hasRightsToCurrentUserLocked() == true) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return null;
    L13:
        boolean permissionGranted = this.mSecurityPolicy.canRetrieveWindowsLocked(this);     // Catch: Throwable -> L11
        if (permissionGranted == true) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return null;
    L18:
        if (this.mSecurityPolicy.checkAccessibilityAccess(this) == true) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return null;
    L21:
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L11
        AccessibilityWindowInfo.WindowListSparseArray allWindows = new AccessibilityWindowInfo.WindowListSparseArray();     // Catch: Throwable -> L30
        ArrayList<Integer> displayList = this.mA11yWindowManager.getDisplayListLocked(this.mDisplayTypes);     // Catch: Throwable -> L30
        int displayListCounts = displayList.size();     // Catch: Throwable -> L30
        if (displayListCounts <= 0) goto L34;
        int i = 0;
    L25:
        if (i >= displayListCounts) goto L34;
        int displayId = displayList.get(i).intValue();     // Catch: Throwable -> L30
        ensureWindowsAvailableTimedLocked(displayId);     // Catch: Throwable -> L30
        List<AccessibilityWindowInfo> windowList = getWindowsByDisplayLocked(displayId);     // Catch: Throwable -> L30
        if (windowList == null) goto L32;
        allWindows.put(displayId, windowList);     // Catch: Throwable -> L30
    L32:
        i = i + 1;
    L34:
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return allWindows;
    L30:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    }

    protected void setDisplayTypes(int displayTypes) {
        this.mDisplayTypes = displayTypes;
    }

    public AccessibilityWindowInfo getWindow(int windowId) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("getWindow", "windowId=" + windowId);
    L5:
        int displayId = -1;
        if (windowId == (-1)) goto L8;
        displayId = this.mA11yWindowManager.getDisplayIdByUserIdAndWindowId(this.mSystemSupport.getCurrentUserIdLocked(), windowId);
    L8:
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureWindowsAvailableTimedLocked(displayId);     // Catch: Throwable -> L14
        if (hasRightsToCurrentUserLocked() == true) goto L16;
        monitor-exit(r1);     // Catch: Throwable -> L14
        return null;
    L16:
        boolean permissionGranted = this.mSecurityPolicy.canRetrieveWindowsLocked(this);     // Catch: Throwable -> L14
        if (permissionGranted == true) goto L21;
        monitor-exit(r1);     // Catch: Throwable -> L14
        return null;
    L21:
        if (this.mSecurityPolicy.checkAccessibilityAccess(this) == true) goto L24;
        monitor-exit(r1);     // Catch: Throwable -> L14
        return null;
    L24:
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L14
        AccessibilityWindowInfo window = this.mA11yWindowManager.findA11yWindowInfoByIdLocked(windowId);     // Catch: Throwable -> L31
        if (window == null) goto L33;
        AccessibilityWindowInfo windowClone = AccessibilityWindowInfo.obtain(window);     // Catch: Throwable -> L31
        windowClone.setConnectionId(this.mId);     // Catch: Throwable -> L31
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return windowClone;
    L33:
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return null;
    L31:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public String[] findAccessibilityNodeInfosByViewId(int accessibilityWindowId, long accessibilityNodeId, String viewIdResName, int interactionId, IAccessibilityInteractionConnectionCallback callback, long interrogatingTid) throws RemoteException {
        if (svcConnTracingEnabled() == false) goto L5;
        StringBuilder r2 = new StringBuilder();
        r2.append("accessibilityWindowId=");
        r2.append(accessibilityWindowId);
        r2.append(";accessibilityNodeId=");
        r2.append(accessibilityNodeId);
        r2.append(";viewIdResName=");
        r2.append(viewIdResName);
        r2.append(";interactionId=");
        r2.append(interactionId);
        r2.append(";callback=");
        IAccessibilityInteractionConnectionCallback r3 = callback;
        r2.append(r3);
        r2.append(";interrogatingTid=");
        r2.append(interrogatingTid);
        logTraceSvcConn("findAccessibilityNodeInfosByViewId", r2.toString());
    L6:
        Region partialInteractiveRegion = Region.obtain();
        Object r5 = this.mLock;
        monitor-enter(r5);
        this.mUsesAccessibilityCache = true;     // Catch: Throwable -> L13
        if (hasRightsToCurrentUserLocked() == true) goto L15;
        monitor-exit(r5);     // Catch: Throwable -> L13
        return null;
    L15:
        int resolvedWindowId = resolveAccessibilityWindowIdLocked(accessibilityWindowId);     // Catch: Throwable -> L13
        boolean permissionGranted = this.mSecurityPolicy.canGetAccessibilityNodeInfoLocked(this.mSystemSupport.getCurrentUserIdLocked(), this, resolvedWindowId);     // Catch: Throwable -> L13
        if (permissionGranted == true) goto L19;
        monitor-exit(r5);     // Catch: Throwable -> L13
        return null;
    L19:
        AccessibilityWindowManager.RemoteAccessibilityConnection connection = this.mA11yWindowManager.getConnectionLocked(this.mSystemSupport.getCurrentUserIdLocked(), resolvedWindowId);     // Catch: Throwable -> L13
        if (connection != null) goto L24;
        monitor-exit(r5);     // Catch: Throwable -> L13
        return null;
    L24:
        if (this.mA11yWindowManager.computePartialInteractiveRegionForWindowLocked(resolvedWindowId, partialInteractiveRegion) == true) goto L27;
        partialInteractiveRegion.recycle();     // Catch: Throwable -> L13
        Region partialInteractiveRegion2 = null;
    L77:
        monitor-exit(r5);     // Catch: Throwable -> L71
        Pair<float[], MagnificationSpec> transformMatrixAndSpec = getWindowTransformationMatrixAndMagnificationSpec(resolvedWindowId);
        float[] transformMatrix = (float[]) transformMatrixAndSpec.first;
        MagnificationSpec spec = (MagnificationSpec) transformMatrixAndSpec.second;
        if (this.mSecurityPolicy.checkAccessibilityAccess(this) == true) goto L32;
        return null;
    L32:
        int interrogatingPid = Binder.getCallingPid();
        IAccessibilityInteractionConnectionCallback callback2 = replaceCallbackIfNeeded(r3, resolvedWindowId, interactionId, interrogatingPid, interrogatingTid);
        long identityToken = Binder.clearCallingIdentity();
        if (intConnTracingEnabled() == false) goto L86;
        logTraceIntConn("findAccessibilityNodeInfosByViewId", accessibilityNodeId + ";" + viewIdResName + ";" + partialInteractiveRegion2 + ";" + interactionId + ";" + callback2 + ";" + this.mFetchFlags + ";" + interrogatingPid + ";" + interrogatingTid + ";" + spec + ";" + Arrays.toString(transformMatrix));
    L86:
        Region partialInteractiveRegion3 = partialInteractiveRegion2;
        connection.getRemote().findAccessibilityNodeInfosByViewId(accessibilityNodeId, viewIdResName, partialInteractiveRegion3, interactionId, callback2, this.mFetchFlags, interrogatingPid, interrogatingTid, spec, transformMatrix);     // Catch: Throwable -> L51 RemoteException -> L53
        goto L65
    L82:
        String[] r0 = this.mSecurityPolicy.computeValidReportedPackages(connection.getPackageName(), connection.getUid());     // Catch: Throwable -> L47 RemoteException -> L49
        Binder.restoreCallingIdentity(identityToken);
        if (partialInteractiveRegion3 != null) goto L44;
    L46:
        return r0;
    L44:
        if (Binder.isProxy(connection.getRemote()) == false) goto L46;
        partialInteractiveRegion3.recycle();
        goto L46
    L47:
        th = th;
    L59:
        Binder.restoreCallingIdentity(identityToken);
        if (partialInteractiveRegion3 != null) goto L62;
    L64:
        throw th;
    L62:
        if (Binder.isProxy(connection.getRemote()) == false) goto L64;
        partialInteractiveRegion3.recycle();
    L51:
        th = th;
    L65:
        Binder.restoreCallingIdentity(identityToken);
        if (partialInteractiveRegion3 != null) goto L68;
    L70:
        return 0;
    L68:
        if (Binder.isProxy(connection.getRemote()) == false) goto L70;
        partialInteractiveRegion3.recycle();
        goto L70
    L55:
        th = th;
        partialInteractiveRegion3 = partialInteractiveRegion2;
    L58:
        partialInteractiveRegion3 = partialInteractiveRegion2;
    L71:
        th = th;
    L79:
        monitor-exit(r5);     // Catch: Throwable -> L75
        throw th;
    L75:
        th = th;
        goto L79
    L27:
        partialInteractiveRegion2 = partialInteractiveRegion;
    L13:
        th = th;
        goto L79
    L5:
        r3 = callback;
        goto L6
    }

    public String[] findAccessibilityNodeInfosByText(int accessibilityWindowId, long accessibilityNodeId, String text, int interactionId, IAccessibilityInteractionConnectionCallback callback, long interrogatingTid) throws RemoteException {
        if (svcConnTracingEnabled() == false) goto L5;
        StringBuilder r2 = new StringBuilder();
        r2.append("accessibilityWindowId=");
        r2.append(accessibilityWindowId);
        r2.append(";accessibilityNodeId=");
        r2.append(accessibilityNodeId);
        r2.append(";text=");
        r2.append(text);
        r2.append(";interactionId=");
        r2.append(interactionId);
        r2.append(";callback=");
        IAccessibilityInteractionConnectionCallback r3 = callback;
        r2.append(r3);
        r2.append(";interrogatingTid=");
        r2.append(interrogatingTid);
        logTraceSvcConn("findAccessibilityNodeInfosByText", r2.toString());
    L6:
        Region partialInteractiveRegion = Region.obtain();
        Object r5 = this.mLock;
        monitor-enter(r5);
        this.mUsesAccessibilityCache = true;     // Catch: Throwable -> L13
        if (hasRightsToCurrentUserLocked() == true) goto L15;
        monitor-exit(r5);     // Catch: Throwable -> L13
        return null;
    L15:
        int resolvedWindowId = resolveAccessibilityWindowIdLocked(accessibilityWindowId);     // Catch: Throwable -> L13
        boolean permissionGranted = this.mSecurityPolicy.canGetAccessibilityNodeInfoLocked(this.mSystemSupport.getCurrentUserIdLocked(), this, resolvedWindowId);     // Catch: Throwable -> L13
        if (permissionGranted == true) goto L19;
        monitor-exit(r5);     // Catch: Throwable -> L13
        return null;
    L19:
        AccessibilityWindowManager.RemoteAccessibilityConnection connection = this.mA11yWindowManager.getConnectionLocked(this.mSystemSupport.getCurrentUserIdLocked(), resolvedWindowId);     // Catch: Throwable -> L13
        if (connection != null) goto L24;
        monitor-exit(r5);     // Catch: Throwable -> L13
        return null;
    L24:
        if (this.mA11yWindowManager.computePartialInteractiveRegionForWindowLocked(resolvedWindowId, partialInteractiveRegion) == true) goto L27;
        partialInteractiveRegion.recycle();     // Catch: Throwable -> L13
        Region partialInteractiveRegion2 = null;
    L77:
        monitor-exit(r5);     // Catch: Throwable -> L71
        Pair<float[], MagnificationSpec> transformMatrixAndSpec = getWindowTransformationMatrixAndMagnificationSpec(resolvedWindowId);
        float[] transformMatrix = (float[]) transformMatrixAndSpec.first;
        MagnificationSpec spec = (MagnificationSpec) transformMatrixAndSpec.second;
        if (this.mSecurityPolicy.checkAccessibilityAccess(this) == true) goto L32;
        return null;
    L32:
        int interrogatingPid = Binder.getCallingPid();
        IAccessibilityInteractionConnectionCallback callback2 = replaceCallbackIfNeeded(r3, resolvedWindowId, interactionId, interrogatingPid, interrogatingTid);
        long identityToken = Binder.clearCallingIdentity();
        if (intConnTracingEnabled() == false) goto L86;
        logTraceIntConn("findAccessibilityNodeInfosByText", accessibilityNodeId + ";" + text + ";" + partialInteractiveRegion2 + ";" + interactionId + ";" + callback2 + ";" + this.mFetchFlags + ";" + interrogatingPid + ";" + interrogatingTid + ";" + spec + ";" + Arrays.toString(transformMatrix));
    L86:
        Region partialInteractiveRegion3 = partialInteractiveRegion2;
        connection.getRemote().findAccessibilityNodeInfosByText(accessibilityNodeId, text, partialInteractiveRegion3, interactionId, callback2, this.mFetchFlags, interrogatingPid, interrogatingTid, spec, transformMatrix);     // Catch: Throwable -> L51 RemoteException -> L53
        goto L65
    L82:
        String[] r0 = this.mSecurityPolicy.computeValidReportedPackages(connection.getPackageName(), connection.getUid());     // Catch: Throwable -> L47 RemoteException -> L49
        Binder.restoreCallingIdentity(identityToken);
        if (partialInteractiveRegion3 != null) goto L44;
    L46:
        return r0;
    L44:
        if (Binder.isProxy(connection.getRemote()) == false) goto L46;
        partialInteractiveRegion3.recycle();
        goto L46
    L47:
        th = th;
    L59:
        Binder.restoreCallingIdentity(identityToken);
        if (partialInteractiveRegion3 != null) goto L62;
    L64:
        throw th;
    L62:
        if (Binder.isProxy(connection.getRemote()) == false) goto L64;
        partialInteractiveRegion3.recycle();
    L51:
        th = th;
    L65:
        Binder.restoreCallingIdentity(identityToken);
        if (partialInteractiveRegion3 != null) goto L68;
    L70:
        return 0;
    L68:
        if (Binder.isProxy(connection.getRemote()) == false) goto L70;
        partialInteractiveRegion3.recycle();
        goto L70
    L55:
        th = th;
        partialInteractiveRegion3 = partialInteractiveRegion2;
    L58:
        partialInteractiveRegion3 = partialInteractiveRegion2;
    L71:
        th = th;
    L79:
        monitor-exit(r5);     // Catch: Throwable -> L75
        throw th;
    L75:
        th = th;
        goto L79
    L27:
        partialInteractiveRegion2 = partialInteractiveRegion;
    L13:
        th = th;
        goto L79
    L5:
        r3 = callback;
        goto L6
    }

    public String[] findAccessibilityNodeInfoByAccessibilityId(int accessibilityWindowId, long accessibilityNodeId, int interactionId, IAccessibilityInteractionConnectionCallback callback, int flags, long interrogatingTid, Bundle arguments) throws RemoteException {
        if (svcConnTracingEnabled() == false) goto L5;
        StringBuilder r2 = new StringBuilder();
        r2.append("accessibilityWindowId=");
        r2.append(accessibilityWindowId);
        r2.append(";accessibilityNodeId=");
        r2.append(accessibilityNodeId);
        r2.append(";interactionId=");
        r2.append(interactionId);
        r2.append(";callback=");
        IAccessibilityInteractionConnectionCallback r3 = callback;
        r2.append(r3);
        r2.append(";flags=");
        r2.append(flags);
        r2.append(";interrogatingTid=");
        r2.append(interrogatingTid);
        r2.append(";arguments=");
        r2.append(arguments);
        logTraceSvcConn("findAccessibilityNodeInfoByAccessibilityId", r2.toString());
    L6:
        Region partialInteractiveRegion = Region.obtain();
        Object r5 = this.mLock;
        monitor-enter(r5);
        this.mUsesAccessibilityCache = true;     // Catch: Throwable -> L13
        if (hasRightsToCurrentUserLocked() == true) goto L15;
        monitor-exit(r5);     // Catch: Throwable -> L13
        return null;
    L15:
        int resolvedWindowId = resolveAccessibilityWindowIdLocked(accessibilityWindowId);     // Catch: Throwable -> L13
        boolean permissionGranted = this.mSecurityPolicy.canGetAccessibilityNodeInfoLocked(this.mSystemSupport.getCurrentUserIdLocked(), this, resolvedWindowId);     // Catch: Throwable -> L13
        if (permissionGranted == true) goto L19;
        monitor-exit(r5);     // Catch: Throwable -> L13
        return null;
    L19:
        AccessibilityWindowManager.RemoteAccessibilityConnection connection = this.mA11yWindowManager.getConnectionLocked(this.mSystemSupport.getCurrentUserIdLocked(), resolvedWindowId);     // Catch: Throwable -> L13
        if (connection != null) goto L24;
        monitor-exit(r5);     // Catch: Throwable -> L13
        return null;
    L24:
        if (this.mA11yWindowManager.computePartialInteractiveRegionForWindowLocked(resolvedWindowId, partialInteractiveRegion) == true) goto L27;
        partialInteractiveRegion.recycle();     // Catch: Throwable -> L13
        Region partialInteractiveRegion2 = null;
    L79:
        monitor-exit(r5);     // Catch: Throwable -> L70
        Pair<float[], MagnificationSpec> transformMatrixAndSpec = getWindowTransformationMatrixAndMagnificationSpec(resolvedWindowId);
        float[] transformMatrix = (float[]) transformMatrixAndSpec.first;
        MagnificationSpec spec = (MagnificationSpec) transformMatrixAndSpec.second;
        if (this.mSecurityPolicy.checkAccessibilityAccess(this) == true) goto L32;
        return null;
    L32:
        int interrogatingPid = Binder.getCallingPid();
        IAccessibilityInteractionConnectionCallback callback2 = replaceCallbackIfNeeded(r3, resolvedWindowId, interactionId, interrogatingPid, interrogatingTid);
        long identityToken = Binder.clearCallingIdentity();
        if (intConnTracingEnabled() == false) goto L81;
        logTraceIntConn("findAccessibilityNodeInfoByAccessibilityId", accessibilityNodeId + ";" + partialInteractiveRegion2 + ";" + interactionId + ";" + callback2 + ";" + (this.mFetchFlags | flags) + ";" + interrogatingPid + ";" + interrogatingTid + ";" + spec + ";" + Arrays.toString(transformMatrix) + ";" + arguments);
    L81:
        Region partialInteractiveRegion3 = partialInteractiveRegion2;
        connection.getRemote().findAccessibilityNodeInfoByAccessibilityId(accessibilityNodeId, partialInteractiveRegion3, interactionId, callback2, this.mFetchFlags | flags, interrogatingPid, interrogatingTid, spec, transformMatrix, arguments);     // Catch: Throwable -> L50 RemoteException -> L52
        goto L64
    L83:
        String[] r0 = this.mSecurityPolicy.computeValidReportedPackages(connection.getPackageName(), connection.getUid());     // Catch: Throwable -> L46 RemoteException -> L48
        Binder.restoreCallingIdentity(identityToken);
        if (partialInteractiveRegion3 != null) goto L43;
    L45:
        return r0;
    L43:
        if (Binder.isProxy(connection.getRemote()) == false) goto L45;
        partialInteractiveRegion3.recycle();
        goto L45
    L46:
        th = th;
    L58:
        Binder.restoreCallingIdentity(identityToken);
        if (partialInteractiveRegion3 != null) goto L61;
    L63:
        throw th;
    L61:
        if (Binder.isProxy(connection.getRemote()) == false) goto L63;
        partialInteractiveRegion3.recycle();
    L50:
        th = th;
    L64:
        Binder.restoreCallingIdentity(identityToken);
        if (partialInteractiveRegion3 != null) goto L67;
    L69:
        return null;
    L67:
        if (Binder.isProxy(connection.getRemote()) == false) goto L69;
        partialInteractiveRegion3.recycle();
        goto L69
    L54:
        th = th;
        partialInteractiveRegion3 = partialInteractiveRegion2;
    L57:
        partialInteractiveRegion3 = partialInteractiveRegion2;
    L70:
        th = th;
    L77:
        monitor-exit(r5);     // Catch: Throwable -> L74
        throw th;
    L74:
        th = th;
        goto L77
    L27:
        partialInteractiveRegion2 = partialInteractiveRegion;
    L13:
        th = th;
        goto L77
    L5:
        r3 = callback;
        goto L6
    }

    public String[] findFocus(int accessibilityWindowId, long accessibilityNodeId, int focusType, int interactionId, IAccessibilityInteractionConnectionCallback callback, long interrogatingTid) throws RemoteException {
        if (svcConnTracingEnabled() == false) goto L5;
        StringBuilder r2 = new StringBuilder();
        r2.append("accessibilityWindowId=");
        r2.append(accessibilityWindowId);
        r2.append(";accessibilityNodeId=");
        r2.append(accessibilityNodeId);
        r2.append(";focusType=");
        r2.append(focusType);
        r2.append(";interactionId=");
        r2.append(interactionId);
        r2.append(";callback=");
        IAccessibilityInteractionConnectionCallback r3 = callback;
        r2.append(r3);
        r2.append(";interrogatingTid=");
        r2.append(interrogatingTid);
        logTraceSvcConn("findFocus", r2.toString());
    L6:
        Region partialInteractiveRegion = Region.obtain();
        Object r4 = this.mLock;
        monitor-enter(r4);
    L12:
        th = th;
    L72:
        monitor-exit(r4);     // Catch: Throwable -> L12
        throw th;
    L9:
        if (hasRightsToCurrentUserLocked() == true) goto L14;
        monitor-exit(r4);     // Catch: Throwable -> L12
        return null;
    L14:
        int resolvedWindowId = resolveAccessibilityWindowIdForFindFocusLocked(accessibilityWindowId, focusType);     // Catch: Throwable -> L12
        boolean permissionGranted = this.mSecurityPolicy.canGetAccessibilityNodeInfoLocked(this.mSystemSupport.getCurrentUserIdLocked(), this, resolvedWindowId);     // Catch: Throwable -> L12
        if (permissionGranted == true) goto L18;
        monitor-exit(r4);     // Catch: Throwable -> L12
        return null;
    L18:
        AccessibilityWindowManager.RemoteAccessibilityConnection connection = this.mA11yWindowManager.getConnectionLocked(this.mSystemSupport.getCurrentUserIdLocked(), resolvedWindowId);     // Catch: Throwable -> L12
        if (connection != null) goto L23;
        monitor-exit(r4);     // Catch: Throwable -> L12
        return null;
    L23:
        if (this.mA11yWindowManager.computePartialInteractiveRegionForWindowLocked(resolvedWindowId, partialInteractiveRegion) == true) goto L26;
        partialInteractiveRegion.recycle();     // Catch: Throwable -> L12
        Region partialInteractiveRegion2 = null;
    L74:
        monitor-exit(r4);     // Catch: Throwable -> L70
        Pair<float[], MagnificationSpec> transformMatrixAndSpec = getWindowTransformationMatrixAndMagnificationSpec(resolvedWindowId);
        float[] transformMatrix = (float[]) transformMatrixAndSpec.first;
        MagnificationSpec spec = (MagnificationSpec) transformMatrixAndSpec.second;
        if (this.mSecurityPolicy.checkAccessibilityAccess(this) == true) goto L31;
        return null;
    L31:
        int interrogatingPid = Binder.getCallingPid();
        IAccessibilityInteractionConnectionCallback callback2 = replaceCallbackIfNeeded(r3, resolvedWindowId, interactionId, interrogatingPid, interrogatingTid);
        long identityToken = Binder.clearCallingIdentity();
        if (intConnTracingEnabled() == false) goto L79;
        logTraceIntConn("findFocus", accessibilityNodeId + ";" + focusType + ";" + partialInteractiveRegion2 + ";" + interactionId + ";" + callback2 + ";" + this.mFetchFlags + ";" + interrogatingPid + ";" + interrogatingTid + ";" + spec + ";" + Arrays.toString(transformMatrix));
    L79:
        goto L64
    L77:
        connection.getRemote().findFocus(accessibilityNodeId, focusType, partialInteractiveRegion2, interactionId, callback2, this.mFetchFlags, interrogatingPid, interrogatingTid, spec, transformMatrix);     // Catch: Throwable -> L50 RemoteException -> L52
        goto L64
    L81:
        String[] r0 = this.mSecurityPolicy.computeValidReportedPackages(connection.getPackageName(), connection.getUid());     // Catch: Throwable -> L46 RemoteException -> L48
        Binder.restoreCallingIdentity(identityToken);
        if (partialInteractiveRegion2 != null) goto L43;
    L45:
        return r0;
    L43:
        if (Binder.isProxy(connection.getRemote()) == false) goto L45;
        partialInteractiveRegion2.recycle();
        goto L45
    L46:
        th = th;
    L58:
        Binder.restoreCallingIdentity(identityToken);
        if (partialInteractiveRegion2 != null) goto L61;
    L63:
        throw th;
    L61:
        if (Binder.isProxy(connection.getRemote()) == false) goto L63;
        partialInteractiveRegion2.recycle();
    L50:
        th = th;
    L54:
        th = th;
    L64:
        Binder.restoreCallingIdentity(identityToken);
        if (partialInteractiveRegion2 != null) goto L67;
    L69:
        return null;
    L67:
        if (Binder.isProxy(connection.getRemote()) == false) goto L69;
        partialInteractiveRegion2.recycle();
    L70:
        th = th;
        goto L72
    L26:
        partialInteractiveRegion2 = partialInteractiveRegion;
        goto L74
    L5:
        r3 = callback;
        goto L6
    }

    public String[] focusSearch(int accessibilityWindowId, long accessibilityNodeId, int direction, int interactionId, IAccessibilityInteractionConnectionCallback callback, long interrogatingTid) throws RemoteException {
        if (svcConnTracingEnabled() == false) goto L5;
        StringBuilder r2 = new StringBuilder();
        r2.append("accessibilityWindowId=");
        r2.append(accessibilityWindowId);
        r2.append(";accessibilityNodeId=");
        r2.append(accessibilityNodeId);
        r2.append(";direction=");
        r2.append(direction);
        r2.append(";interactionId=");
        r2.append(interactionId);
        r2.append(";callback=");
        IAccessibilityInteractionConnectionCallback r3 = callback;
        r2.append(r3);
        r2.append(";interrogatingTid=");
        r2.append(interrogatingTid);
        logTraceSvcConn("focusSearch", r2.toString());
    L6:
        Region partialInteractiveRegion = Region.obtain();
        Object r5 = this.mLock;
        monitor-enter(r5);
    L12:
        th = th;
    L78:
        monitor-exit(r5);     // Catch: Throwable -> L74
        throw th;
    L74:
        th = th;
        goto L78
    L9:
        if (hasRightsToCurrentUserLocked() == true) goto L14;
        monitor-exit(r5);     // Catch: Throwable -> L12
        return null;
    L14:
        int resolvedWindowId = resolveAccessibilityWindowIdLocked(accessibilityWindowId);     // Catch: Throwable -> L12
        boolean permissionGranted = this.mSecurityPolicy.canGetAccessibilityNodeInfoLocked(this.mSystemSupport.getCurrentUserIdLocked(), this, resolvedWindowId);     // Catch: Throwable -> L12
        if (permissionGranted == true) goto L18;
        monitor-exit(r5);     // Catch: Throwable -> L12
        return null;
    L18:
        AccessibilityWindowManager.RemoteAccessibilityConnection connection = this.mA11yWindowManager.getConnectionLocked(this.mSystemSupport.getCurrentUserIdLocked(), resolvedWindowId);     // Catch: Throwable -> L12
        if (connection != null) goto L23;
        monitor-exit(r5);     // Catch: Throwable -> L12
        return null;
    L23:
        if (this.mA11yWindowManager.computePartialInteractiveRegionForWindowLocked(resolvedWindowId, partialInteractiveRegion) == true) goto L26;
        partialInteractiveRegion.recycle();     // Catch: Throwable -> L12
        Region partialInteractiveRegion2 = null;
    L76:
        monitor-exit(r5);     // Catch: Throwable -> L70
        Pair<float[], MagnificationSpec> transformMatrixAndSpec = getWindowTransformationMatrixAndMagnificationSpec(resolvedWindowId);
        float[] transformMatrix = (float[]) transformMatrixAndSpec.first;
        MagnificationSpec spec = (MagnificationSpec) transformMatrixAndSpec.second;
        if (this.mSecurityPolicy.checkAccessibilityAccess(this) == true) goto L31;
        return null;
    L31:
        int interrogatingPid = Binder.getCallingPid();
        IAccessibilityInteractionConnectionCallback callback2 = replaceCallbackIfNeeded(r3, resolvedWindowId, interactionId, interrogatingPid, interrogatingTid);
        long identityToken = Binder.clearCallingIdentity();
        if (intConnTracingEnabled() == false) goto L83;
        logTraceIntConn("focusSearch", accessibilityNodeId + ";" + direction + ";" + partialInteractiveRegion2 + ";" + interactionId + ";" + callback2 + ";" + this.mFetchFlags + ";" + interrogatingPid + ";" + interrogatingTid + ";" + spec + ";" + Arrays.toString(transformMatrix));
    L83:
        Region partialInteractiveRegion3 = partialInteractiveRegion2;
        connection.getRemote().focusSearch(accessibilityNodeId, direction, partialInteractiveRegion3, interactionId, callback2, this.mFetchFlags, interrogatingPid, interrogatingTid, spec, transformMatrix);     // Catch: Throwable -> L50 RemoteException -> L52
        goto L64
    L81:
        String[] r0 = this.mSecurityPolicy.computeValidReportedPackages(connection.getPackageName(), connection.getUid());     // Catch: Throwable -> L46 RemoteException -> L48
        Binder.restoreCallingIdentity(identityToken);
        if (partialInteractiveRegion3 != null) goto L43;
    L45:
        return r0;
    L43:
        if (Binder.isProxy(connection.getRemote()) == false) goto L45;
        partialInteractiveRegion3.recycle();
        goto L45
    L46:
        th = th;
    L58:
        Binder.restoreCallingIdentity(identityToken);
        if (partialInteractiveRegion3 != null) goto L61;
    L63:
        throw th;
    L61:
        if (Binder.isProxy(connection.getRemote()) == false) goto L63;
        partialInteractiveRegion3.recycle();
    L50:
        th = th;
    L64:
        Binder.restoreCallingIdentity(identityToken);
        if (partialInteractiveRegion3 != null) goto L67;
    L69:
        return 0;
    L67:
        if (Binder.isProxy(connection.getRemote()) == false) goto L69;
        partialInteractiveRegion3.recycle();
        goto L69
    L54:
        th = th;
        partialInteractiveRegion3 = partialInteractiveRegion2;
    L57:
        partialInteractiveRegion3 = partialInteractiveRegion2;
    L70:
        th = th;
        goto L78
    L26:
        partialInteractiveRegion2 = partialInteractiveRegion;
        goto L76
    L5:
        r3 = callback;
        goto L6
    }

    public void sendGesture(int sequence, ParceledListSlice gestureSteps) {
        if (svcConnTracingEnabled() == false) goto L6;
        logTraceSvcConn("sendGesture", "sequence=" + sequence + ";gestureSteps=" + gestureSteps);
        return;
    }

    public void dispatchGesture(int sequence, ParceledListSlice gestureSteps, int displayId) {
        if (svcConnTracingEnabled() == false) goto L6;
        logTraceSvcConn("dispatchGesture", "sequence=" + sequence + ";gestureSteps=" + gestureSteps + ";displayId=" + displayId);
        return;
    }

    public boolean performAccessibilityAction(int accessibilityWindowId, long accessibilityNodeId, int action, Bundle arguments, int interactionId, IAccessibilityInteractionConnectionCallback callback, long interrogatingTid) throws RemoteException {
        if (svcConnTracingEnabled() == false) goto L5;
        StringBuilder r2 = new StringBuilder();
        r2.append("accessibilityWindowId=");
        r2.append(accessibilityWindowId);
        r2.append(";accessibilityNodeId=");
        long r4 = accessibilityNodeId;
        r2.append(r4);
        r2.append(";action=");
        int r6 = action;
        r2.append(r6);
        r2.append(";arguments=");
        Bundle r7 = arguments;
        r2.append(r7);
        r2.append(";interactionId=");
        int r8 = interactionId;
        r2.append(r8);
        r2.append(";callback=");
        IAccessibilityInteractionConnectionCallback r9 = callback;
        r2.append(r9);
        r2.append(";interrogatingTid=");
        long r11 = interrogatingTid;
        r2.append(r11);
        logTraceSvcConn("performAccessibilityAction", r2.toString());
    L6:
        Object r3 = this.mLock;
        monitor-enter(r3);
    L12:
        th = move-exception;
        throw th;
    L9:
        if (hasRightsToCurrentUserLocked() == true) goto L14;
        monitor-exit(r3);     // Catch: Throwable -> L12
        return false;
    L14:
        int resolvedWindowId = resolveAccessibilityWindowIdLocked(accessibilityWindowId);     // Catch: Throwable -> L12
        if (this.mSecurityPolicy.canGetAccessibilityNodeInfoLocked(this.mSystemSupport.getCurrentUserIdLocked(), this, resolvedWindowId) == true) goto L18;
        monitor-exit(r3);     // Catch: Throwable -> L12
        return false;
    L18:
        monitor-exit(r3);     // Catch: Throwable -> L12
        if (this.mSecurityPolicy.checkAccessibilityAccess(this) == true) goto L23;
        return false;
    L23:
        return performAccessibilityActionInternal(this.mSystemSupport.getCurrentUserIdLocked(), resolvedWindowId, r4, r6, r7, r8, r9, this.mFetchFlags, r11);
    L5:
        r4 = accessibilityNodeId;
        r6 = action;
        r7 = arguments;
        r8 = interactionId;
        r9 = callback;
        r11 = interrogatingTid;
        goto L6
    }

    public boolean performGlobalAction(int action) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("performGlobalAction", "action=" + action);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (hasRightsToCurrentUserLocked() == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        UserManagerService.enforceCurrentUserIfVisibleBackgroundEnabled();
        long identity = Binder.clearCallingIdentity();
        boolean r2 = this.mSystemActionPerformer.performSystemAction(action);     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(identity);
        return r2;
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public List<AccessibilityNodeInfo.AccessibilityAction> getSystemActions() {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("getSystemActions", "");
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (hasRightsToCurrentUserLocked() == true) goto L14;
        List<AccessibilityNodeInfo.AccessibilityAction> r1 = Collections.emptyList();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        long identity = Binder.clearCallingIdentity();
        List<AccessibilityNodeInfo.AccessibilityAction> r2 = this.mSystemActionPerformer.getSystemActions();     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(identity);
        return r2;
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public boolean isFingerprintGestureDetectionAvailable() {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("isFingerprintGestureDetectionAvailable", "");
    L5:
        boolean r1 = false;
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint") == true) goto L8;
        return false;
    L8:
        long identity = Binder.clearCallingIdentity();
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L10:
        if (isCapturingFingerprintGestures() == false) goto L20;
        FingerprintGestureDispatcher dispatcher = this.mSystemSupport.getFingerprintGestureDispatcher();     // Catch: Throwable -> L16
        if (dispatcher == null) goto L18;
        if (dispatcher.isFingerprintGestureDetectionAvailable() == false) goto L18;
        r1 = true;
    L18:
        Binder.restoreCallingIdentity(identity);
        return r1;
    L20:
        Binder.restoreCallingIdentity(identity);
        return false;
    }

    public MagnificationConfig getMagnificationConfig(int displayId) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("getMagnificationConfig", "displayId=" + displayId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (hasRightsToCurrentUserLocked() == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return null;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        long identity = Binder.clearCallingIdentity();
        MagnificationConfig r2 = this.mSystemSupport.getMagnificationProcessor().getMagnificationConfig(displayId);     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(identity);
        return r2;
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public float getMagnificationScale(int displayId) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("getMagnificationScale", "displayId=" + displayId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (hasRightsToCurrentUserLocked() == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return 1.0f;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        long identity = Binder.clearCallingIdentity();
        float r2 = this.mSystemSupport.getMagnificationProcessor().getScale(displayId);     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(identity);
        return r2;
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public Region getMagnificationRegion(int displayId) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("getMagnificationRegion", "displayId=" + displayId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        Region region = Region.obtain();     // Catch: Throwable -> L11
        if (hasRightsToCurrentUserLocked() == true) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return region;
    L13:
        MagnificationProcessor magnificationProcessor = this.mSystemSupport.getMagnificationProcessor();     // Catch: Throwable -> L11
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L11
        magnificationProcessor.getFullscreenMagnificationRegion(displayId, region, this.mSecurityPolicy.canControlMagnification(this));     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return region;
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public Region getCurrentMagnificationRegion(int displayId) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("getCurrentMagnificationRegion", "displayId=" + displayId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        Region region = Region.obtain();     // Catch: Throwable -> L11
        if (hasRightsToCurrentUserLocked() == true) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return region;
    L13:
        MagnificationProcessor magnificationProcessor = this.mSystemSupport.getMagnificationProcessor();     // Catch: Throwable -> L11
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L11
        magnificationProcessor.getCurrentMagnificationRegion(displayId, region, this.mSecurityPolicy.canControlMagnification(this));     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return region;
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public float getMagnificationCenterX(int displayId) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("getMagnificationCenterX", "displayId=" + displayId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (hasRightsToCurrentUserLocked() == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return 0.0f;
    L14:
        MagnificationProcessor magnificationProcessor = this.mSystemSupport.getMagnificationProcessor();     // Catch: Throwable -> L12
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L12
        float r4 = magnificationProcessor.getCenterX(displayId, this.mSecurityPolicy.canControlMagnification(this));     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r4;
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    }

    public float getMagnificationCenterY(int displayId) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("getMagnificationCenterY", "displayId=" + displayId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (hasRightsToCurrentUserLocked() == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return 0.0f;
    L14:
        MagnificationProcessor magnificationProcessor = this.mSystemSupport.getMagnificationProcessor();     // Catch: Throwable -> L12
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L12
        float r4 = magnificationProcessor.getCenterY(displayId, this.mSecurityPolicy.canControlMagnification(this));     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r4;
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    }

    public boolean resetMagnification(int displayId, boolean animate) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("resetMagnification", "displayId=" + displayId + ";animate=" + animate);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = false;
        if (hasRightsToCurrentUserLocked() == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L14:
        if (this.mSecurityPolicy.canControlMagnification(this) == true) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L11
        long identity = Binder.clearCallingIdentity();
        MagnificationProcessor magnificationProcessor = this.mSystemSupport.getMagnificationProcessor();     // Catch: Throwable -> L24
        if (magnificationProcessor.resetFullscreenMagnification(displayId, animate) == true) goto L26;
        if (magnificationProcessor.isMagnifying(displayId) == false) goto L26;
    L27:
        Binder.restoreCallingIdentity(identity);
        return r2;
    L26:
        r2 = true;
    L24:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean resetCurrentMagnification(int displayId, boolean animate) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("resetCurrentMagnification", "displayId=" + displayId + ";animate=" + animate);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = false;
        if (hasRightsToCurrentUserLocked() == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L14:
        if (this.mSecurityPolicy.canControlMagnification(this) == true) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L11
        long identity = Binder.clearCallingIdentity();
        MagnificationProcessor magnificationProcessor = this.mSystemSupport.getMagnificationProcessor();     // Catch: Throwable -> L24
        if (magnificationProcessor.resetCurrentMagnification(displayId, animate) == true) goto L26;
        if (magnificationProcessor.isMagnifying(displayId) == false) goto L26;
    L27:
        Binder.restoreCallingIdentity(identity);
        return r2;
    L26:
        r2 = true;
    L24:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean setMagnificationConfig(int displayId, MagnificationConfig config, boolean animate) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("setMagnificationSpec", "displayId=" + displayId + ", config=" + config.toString());
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (hasRightsToCurrentUserLocked() == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L14:
        if (this.mSecurityPolicy.canControlMagnification(this) == true) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L17:
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L11
        MagnificationProcessor magnificationProcessor = this.mSystemSupport.getMagnificationProcessor();     // Catch: Throwable -> L22
        boolean r4 = magnificationProcessor.setMagnificationConfig(displayId, config, animate, this.mId);     // Catch: Throwable -> L22
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r4;
    L22:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    }

    public void setMagnificationCallbackEnabled(int displayId, boolean enabled) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("setMagnificationCallbackEnabled", "displayId=" + displayId + ";enabled=" + enabled);
    L5:
        long identity = Binder.clearCallingIdentity();
        this.mInvocationHandler.setMagnificationCallbackEnabled(displayId, enabled);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(identity);
        return;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public boolean isMagnificationCallbackEnabled(int displayId) {
        return this.mInvocationHandler.isMagnificationCallbackEnabled(displayId);
    }

    public void setSoftKeyboardCallbackEnabled(boolean enabled) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("setSoftKeyboardCallbackEnabled", "enabled=" + enabled);
    L5:
        long identity = Binder.clearCallingIdentity();
        this.mInvocationHandler.setSoftKeyboardCallbackEnabled(enabled);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(identity);
        return;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void takeScreenshotOfWindow(int accessibilityWindowId, final int interactionId, final ScreenCapture.ScreenCaptureListener listener, final IAccessibilityInteractionConnectionCallback callback) throws RemoteException {
        long currentTimestamp = SystemClock.uptimeMillis();
        if ((currentTimestamp - this.mRequestTakeScreenshotOfWindowTimestampMs.get(accessibilityWindowId, 0L).longValue()) > 333) goto L6;
        callback.sendTakeScreenshotOfWindowError(3, interactionId);
        return;
    L6:
        this.mRequestTakeScreenshotOfWindowTimestampMs.put(accessibilityWindowId, Long.valueOf(currentTimestamp));
        Object r2 = this.mLock;
        monitor-enter(r2);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (hasRightsToCurrentUserLocked() == true) goto L16;
        callback.sendTakeScreenshotOfWindowError(1, interactionId);     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return;
    L16:
        if (this.mSecurityPolicy.canTakeScreenshotLocked(this) == true) goto L20;
        callback.sendTakeScreenshotOfWindowError(2, interactionId);     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return;
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L13
        if (this.mSecurityPolicy.checkAccessibilityAccess(this) == true) goto L25;
        callback.sendTakeScreenshotOfWindowError(2, interactionId);
        return;
    L25:
        long identity = Binder.clearCallingIdentity();
        AccessibilityWindowManager.RemoteAccessibilityConnection connection = this.mA11yWindowManager.getConnectionLocked(this.mSystemSupport.getCurrentUserIdLocked(), resolveAccessibilityWindowIdLocked(accessibilityWindowId));     // Catch: Throwable -> L31
        if (connection != null) goto L34;
        callback.sendTakeScreenshotOfWindowError(5, interactionId);     // Catch: Throwable -> L31
        Binder.restoreCallingIdentity(identity);
        return;
    L34:
        IWindowSurfaceInfoCallback.Stub r5 = new AnonymousClass2(this, callback, interactionId, listener);     // Catch: Throwable -> L31
        connection.getRemote().getWindowSurfaceInfo(r5);     // Catch: Throwable -> L31
        Binder.restoreCallingIdentity(identity);
        return;
    L31:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void takeScreenshot(int displayId, final RemoteCallback callback) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn(TAKE_SCREENSHOT, "displayId=" + displayId + ";callback=" + callback);
    L5:
        long currentTimestamp = SystemClock.uptimeMillis();
        if (this.mRequestTakeScreenshotTimestampMs != 0) goto L8;
    L11:
        this.mRequestTakeScreenshotTimestampMs = currentTimestamp;
        Object r2 = this.mLock;
        monitor-enter(r2);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (hasRightsToCurrentUserLocked() == true) goto L21;
        sendScreenshotFailure(1, callback);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return;
    L21:
        if (this.mSecurityPolicy.canTakeScreenshotLocked(this) == false) goto L48;
        monitor-exit(r2);     // Catch: Throwable -> L18
        if (this.mSecurityPolicy.checkAccessibilityAccess(this) == true) goto L27;
        sendScreenshotFailure(2, callback);
        return;
    L27:
        DisplayManager displayManager = (DisplayManager) this.mContext.getSystemService("display");
        Display display = displayManager.getDisplay(displayId);
        if (display != null) goto L30;
    L45:
        sendScreenshotFailure(4, callback);
        return;
    L30:
        if (display.getType() == 5) goto L32;
    L34:
        long identity = Binder.clearCallingIdentity();
        ScreenCapture.ScreenCaptureListener screenCaptureListener = new ScreenCapture.ScreenCaptureListener(new AbstractAccessibilityServiceConnection$$ExternalSyntheticLambda1(this, callback));     // Catch: Throwable -> L37 Exception -> L39
        this.mWindowManagerService.captureDisplay(displayId, new ScreenCapture.CaptureArgs.Builder().setCaptureSecureLayers(canCaptureSecureLayers()).build(), screenCaptureListener);     // Catch: Throwable -> L37 Exception -> L39
    L36:
        Binder.restoreCallingIdentity(identity);
        return;
    L37:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L40:
        sendScreenshotFailure(4, callback);     // Catch: Throwable -> L37
        goto L36
    L32:
        if ((display.getFlags() & 4) == 0) goto L34;
    L48:
        throw new SecurityException("Services don't have the capability of taking the screenshot.");     // Catch: Throwable -> L18
    L8:
        if ((currentTimestamp - this.mRequestTakeScreenshotTimestampMs) > 333) goto L11;
        sendScreenshotFailure(3, callback);
    }

    private /* synthetic */ void lambda$takeScreenshot$0(RemoteCallback callback, ScreenCapture.ScreenshotHardwareBuffer screenshotBuffer, int result) {
        if (screenshotBuffer == null) goto L5;
        if (result != 0) goto L5;
        sendScreenshotSuccess(screenshotBuffer, callback);
        return;
    L5:
        sendScreenshotFailure(4, callback);
    }

    private void sendScreenshotSuccess(final ScreenCapture.ScreenshotHardwareBuffer screenshotBuffer, final RemoteCallback callback) {
        this.mMainHandler.post(PooledLambda.obtainRunnable(new AbstractAccessibilityServiceConnection$$ExternalSyntheticLambda2(screenshotBuffer, callback), null).recycleOnUse());
    }

    private static /* synthetic */ void lambda$sendScreenshotSuccess$1(ScreenCapture.ScreenshotHardwareBuffer screenshotBuffer, RemoteCallback callback, Object nonArg) {
        HardwareBuffer hardwareBuffer = screenshotBuffer.getHardwareBuffer();
        ParcelableColorSpace colorSpace = new ParcelableColorSpace(screenshotBuffer.getColorSpace());
        Bundle payload = new Bundle();
        payload.putInt("screenshot_status", 0);
        payload.putParcelable("screenshot_hardwareBuffer", hardwareBuffer);
        payload.putParcelable("screenshot_colorSpace", colorSpace);
        payload.putLong("screenshot_timestamp", SystemClock.uptimeMillis());
        callback.sendResult(payload);
        hardwareBuffer.close();
    }

    private void sendScreenshotFailure(final int errorCode, final RemoteCallback callback) {
        this.mMainHandler.post(PooledLambda.obtainRunnable(new AbstractAccessibilityServiceConnection$$ExternalSyntheticLambda0(errorCode, callback), null).recycleOnUse());
    }

    private static /* synthetic */ void lambda$sendScreenshotFailure$2(int errorCode, RemoteCallback callback, Object nonArg) {
        Bundle payload = new Bundle();
        payload.putInt("screenshot_status", errorCode);
        callback.sendResult(payload);
    }

    private boolean canCaptureSecureLayers() {
        if (this.mAccessibilityServiceInfo.isAccessibilityTool() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mAccessibilityServiceInfo.getResolveInfo().serviceInfo.applicationInfo.isSystemApp() == false) goto L7;
        return true;
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, LOG_TAG, pw) == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.append("Service[label=" + this.mAccessibilityServiceInfo.getResolveInfo().loadLabel(this.mContext.getPackageManager()));     // Catch: Throwable -> L10
        pw.append(", feedbackType" + AccessibilityServiceInfo.feedbackTypeToString(this.mFeedbackType));     // Catch: Throwable -> L10
        pw.append(", capabilities=" + this.mAccessibilityServiceInfo.getCapabilities());     // Catch: Throwable -> L10
        pw.append(", eventTypes=" + AccessibilityEvent.eventTypeToString(this.mEventTypes));     // Catch: Throwable -> L10
        pw.append(", notificationTimeout=" + this.mNotificationTimeout);     // Catch: Throwable -> L10
        pw.append(", requestA11yBtn=" + this.mRequestAccessibilityButton);     // Catch: Throwable -> L10
        pw.append("]");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void addWindowTokensForAllDisplays() {
        Display[] r0 = new Display[0];
        long identity = Binder.clearCallingIdentity();
        Display[] displays = this.mDisplayManager.getDisplays();     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        int i = 0;
    L6:
        if (i >= displays.length) goto L9;
        int displayId = displays[i].getDisplayId();
        addWindowTokenForDisplay(displayId);
        i = i + 1;
        goto L6
    L9:
        return;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    void addWindowTokenForDisplay(int displayId) {
        long identity = Binder.clearCallingIdentity();
        IBinder overlayWindowToken = new Binder();     // Catch: Throwable -> L6
        if (wmTracingEnabled() == false) goto L8;
        logTraceWM("addWindowToken", overlayWindowToken + ";TYPE_ACCESSIBILITY_OVERLAY;" + displayId + ";null");     // Catch: Throwable -> L6
    L8:
        this.mWindowManagerService.addWindowToken(overlayWindowToken, 2032, displayId, null);     // Catch: Throwable -> L6
        Object r3 = this.mLock;     // Catch: Throwable -> L6
        monitor-enter(r3);     // Catch: Throwable -> L6
        this.mOverlayWindowTokens.put(displayId, overlayWindowToken);     // Catch: Throwable -> L14
        monitor-exit(r3);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(identity);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void onRemoved() {
        this.mSystemSupport.clearFrequencyLimit(this);
        Display[] r0 = new Display[0];
        long identity = Binder.clearCallingIdentity();
        Display[] displays = this.mDisplayManager.getDisplays();     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        int i = 0;
    L6:
        if (i >= displays.length) goto L8;
        int displayId = displays[i].getDisplayId();
        onDisplayRemoved(displayId);
        i = i + 1;
        goto L6
    L8:
        detachAllOverlays();
        return;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void onDisplayRemoved(int displayId) {
        long identity = Binder.clearCallingIdentity();
        if (wmTracingEnabled() == false) goto L19;
        logTraceWM("addWindowToken", this.mOverlayWindowTokens.get(displayId) + ";true;" + displayId);
    L19:
        this.mWindowManagerService.removeWindowToken(this.mOverlayWindowTokens.get(displayId), true, displayId);     // Catch: Throwable -> L14
        Object r2 = this.mLock;     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        this.mOverlayWindowTokens.remove(displayId);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(identity);
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public IBinder getOverlayWindowToken(int displayId) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("getOverlayWindowToken", "displayId=" + displayId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L12
        IBinder r3 = this.mOverlayWindowTokens.get(displayId);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public int getWindowIdForLeashToken(IBinder token) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("getWindowIdForLeashToken", "token=" + token);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L12
        int r3 = this.mA11yWindowManager.getWindowIdLocked(token);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public void resetLocked() {
        this.mAccessibilityServiceInfo.resetDynamicallyConfigurableProperties();
        this.mSystemSupport.getKeyEventDispatcher().flush(this);
        if (this.mClient == null) goto L13;
        if (svcClientTracingEnabled() == false) goto L10;
        logTraceSvcClient("init", "null, " + this.mId + ", null");     // Catch: RemoteException -> L8
    L10:
        this.mClient.init(null, this.mId, null);     // Catch: RemoteException -> L8
    L13:
        if (this.mClientBinder != null) goto L21;
    L19:
        this.mClient = null;
        this.mReceivedAccessibilityButtonCallbackSinceBind = false;
        return;
    L21:
        this.mClientBinder.unlinkToDeath(this, 0);     // Catch: NoSuchElementException -> L16
    L18:
        this.mClientBinder = null;
    L17:
        Slog.e(LOG_TAG, "Failed unregistering death link");
        goto L18
    }

    public boolean isConnectedLocked() {
        if (this.mClientBinder == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void notifyAccessibilityEvent(AccessibilityEvent event) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int eventType = event.getEventType();     // Catch: Throwable -> L14
        boolean clientWantsEvent = clientWantsEventLocked(event);     // Catch: Throwable -> L14
        int r4 = 0;
        if (this.mUsesAccessibilityCache == true) goto L7;
    L9:
        boolean requiredForCacheConsistency = false;
    L10:
        if (clientWantsEvent == true) goto L17;
        if (requiredForCacheConsistency == true) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L17:
        if (this.mSecurityPolicy.checkAccessibilityAccess(this) == true) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L20:
        AccessibilityEvent newEvent = AccessibilityEvent.obtain(event);     // Catch: Throwable -> L14
        if (this.mNotificationTimeout > 0) goto L23;
    L28:
        Message message = this.mEventDispatchHandler.obtainMessage(eventType, newEvent);     // Catch: Throwable -> L14
    L29:
        if (clientWantsEvent == false) goto L31;
        r4 = 1;
    L31:
        message.arg1 = r4;     // Catch: Throwable -> L14
        this.mEventDispatchHandler.sendMessageDelayed(message, this.mNotificationTimeout);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L23:
        if (eventType == 2048) goto L28;
        AccessibilityEvent oldEvent = this.mPendingEvents.get(eventType);     // Catch: Throwable -> L14
        this.mPendingEvents.put(eventType, newEvent);     // Catch: Throwable -> L14
        if (oldEvent == null) goto L27;
        this.mEventDispatchHandler.removeMessages(eventType);     // Catch: Throwable -> L14
        oldEvent.recycle();     // Catch: Throwable -> L14
    L27:
        message = this.mEventDispatchHandler.obtainMessage(eventType);     // Catch: Throwable -> L14
        goto L29
    L7:
        if ((4307005 & eventType) == 0) goto L9;
        requiredForCacheConsistency = true;
    L14:
        th = move-exception;
        throw th;
    }

    private boolean clientWantsEventLocked(AccessibilityEvent event) {
        if (canReceiveEventsLocked() == true) goto L6;
        return false;
    L6:
        if ((this.mFetchFlags & 128) == 0) goto L8;
        boolean includeNotImportantViews = true;
    L10:
        if (event.getWindowId() == (-1)) goto L16;
        if (event.isImportantForAccessibility() == true) goto L16;
        if (includeNotImportantViews == true) goto L16;
        return false;
    L16:
        if (event.isAccessibilityDataSensitive() == true) goto L18;
    L20:
        int eventType = event.getEventType();
        if ((this.mEventTypes & eventType) == eventType) goto L23;
        return false;
    L23:
        Set<String> packageNames = this.mPackageNames;
        if (event.getPackageName() == null) goto L26;
        String packageName = event.getPackageName().toString();
    L28:
        if (packageNames.isEmpty() == true) goto L32;
        if (packageNames.contains(packageName) == true) goto L32;
        return false;
    L32:
        return true;
    L26:
        packageName = null;
        goto L28
    L18:
        if ((this.mFetchFlags & 512) != 0) goto L20;
        return false;
    L8:
        includeNotImportantViews = false;
        goto L10
    }

    private void notifyAccessibilityEventInternal(int eventType, AccessibilityEvent event, boolean clientWantsEvent) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        IAccessibilityServiceClient client = this.mClient;     // Catch: Throwable -> L8
        if (client != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        if (event != null) goto L17;
        event = this.mPendingEvents.get(eventType);     // Catch: Throwable -> L8
        if (event != null) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        this.mPendingEvents.remove(eventType);     // Catch: Throwable -> L8
    L17:
        if (this.mSecurityPolicy.canRetrieveWindowContentLocked(this) == false) goto L19;
        event.setConnectionId(this.mId);     // Catch: Throwable -> L8
    L20:
        event.setSealed(true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    L25:
        th = move-exception;
        event.recycle();
        throw th;
    L27:
        re = move-exception;
        Slog.e(LOG_TAG, "Error during sending " + event + " to " + client, re);     // Catch: Throwable -> L25
        goto L33
    L23:
        if (svcClientTracingEnabled() == false) goto L31;
        logTraceSvcClient("onAccessibilityEvent", event + ";" + clientWantsEvent);     // Catch: Throwable -> L25 RemoteException -> L27 FrozenObjectException -> L29
    L31:
        client.onAccessibilityEvent(event, clientWantsEvent);     // Catch: Throwable -> L25 RemoteException -> L27 FrozenObjectException -> L29
    L33:
        event.recycle();
        return;
    L19:
        event.setSource(null);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void notifyGesture(AccessibilityGestureEvent gestureEvent) {
        this.mInvocationHandler.obtainMessage(1, gestureEvent.copyForAsync()).sendToTarget();
    }

    public void notifySystemActionsChangedLocked() {
        this.mInvocationHandler.sendEmptyMessage(9);
    }

    public void notifyClearAccessibilityNodeInfoCache() {
        this.mInvocationHandler.sendEmptyMessage(2);
    }

    public void notifyMagnificationChangedLocked(int displayId, Region region, MagnificationConfig config) {
        this.mInvocationHandler.notifyMagnificationChangedLocked(displayId, region, config);
    }

    public void notifySoftKeyboardShowModeChangedLocked(int showState) {
        this.mInvocationHandler.notifySoftKeyboardShowModeChangedLocked(showState);
    }

    public void notifyAccessibilityButtonClickedLocked(int displayId) {
        this.mInvocationHandler.notifyAccessibilityButtonClickedLocked(displayId);
    }

    public void notifyAccessibilityButtonAvailabilityChangedLocked(boolean available) {
        this.mInvocationHandler.notifyAccessibilityButtonAvailabilityChangedLocked(available);
    }

    public void createImeSessionLocked() {
        this.mInvocationHandler.createImeSessionLocked();
    }

    public void setImeSessionEnabledLocked(IAccessibilityInputMethodSession session, boolean enabled) {
        this.mInvocationHandler.setImeSessionEnabledLocked(session, enabled);
    }

    public void bindInputLocked() {
        this.mInvocationHandler.bindInputLocked();
    }

    public void unbindInputLocked() {
        this.mInvocationHandler.unbindInputLocked();
    }

    public void startInputLocked(IRemoteAccessibilityInputConnection connection, EditorInfo editorInfo, boolean restarting) {
        this.mInvocationHandler.startInputLocked(connection, editorInfo, restarting);
    }

    private Pair<float[], MagnificationSpec> getWindowTransformationMatrixAndMagnificationSpec(int resolvedWindowId) {
        return this.mSystemSupport.getWindowTransformationMatrixAndMagnificationSpec(resolvedWindowId);
    }

    public boolean wantsGenericMotionEvent(MotionEvent event) {
        int eventSourceWithoutClass = event.getSource() & (-256);
        if ((this.mGenericMotionEventSources & eventSourceWithoutClass) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void notifyMagnificationChangedInternal(int displayId, Region region, MagnificationConfig config) {
        IAccessibilityServiceClient client = getClientSafely();
        if (client == null) goto L15;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error sending magnification changes to " + this.mClientBinder, re);
        return;
    L5:
        if (svcClientTracingEnabled() == false) goto L9;
        logTraceSvcClient("onMagnificationChanged", displayId + ", " + region + ", " + config.toString());     // Catch: RemoteException -> L7
    L9:
        client.onMagnificationChanged(displayId, region, config);     // Catch: RemoteException -> L7
        return;
    }

    private void notifySoftKeyboardShowModeChangedInternal(int showState) {
        IAccessibilityServiceClient client = getClientSafely();
        if (client == null) goto L15;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error sending soft keyboard show mode changes to " + this.mClientBinder, re);
        return;
    L5:
        if (svcClientTracingEnabled() == false) goto L9;
        logTraceSvcClient("onSoftKeyboardShowModeChanged", String.valueOf(showState));     // Catch: RemoteException -> L7
    L9:
        client.onSoftKeyboardShowModeChanged(showState);     // Catch: RemoteException -> L7
        return;
    }

    private void notifyAccessibilityButtonClickedInternal(int displayId) {
        IAccessibilityServiceClient client = getClientSafely();
        if (client == null) goto L15;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error sending accessibility button click to " + this.mClientBinder, re);
        return;
    L5:
        if (svcClientTracingEnabled() == false) goto L9;
        logTraceSvcClient("onAccessibilityButtonClicked", String.valueOf(displayId));     // Catch: RemoteException -> L7
    L9:
        client.onAccessibilityButtonClicked(displayId);     // Catch: RemoteException -> L7
        return;
    }

    private void notifyAccessibilityButtonAvailabilityChangedInternal(boolean available) {
        if (this.mReceivedAccessibilityButtonCallbackSinceBind == true) goto L5;
    L7:
        this.mReceivedAccessibilityButtonCallbackSinceBind = true;
        this.mLastAccessibilityButtonCallbackState = available;
        IAccessibilityServiceClient client = getClientSafely();
        if (client == null) goto L20;
    L12:
        re = move-exception;
        Slog.e(LOG_TAG, "Error sending accessibility button availability change to " + this.mClientBinder, re);
        return;
    L10:
        if (svcClientTracingEnabled() == false) goto L14;
        logTraceSvcClient("onAccessibilityButtonAvailabilityChanged", String.valueOf(available));     // Catch: RemoteException -> L12
    L14:
        client.onAccessibilityButtonAvailabilityChanged(available);     // Catch: RemoteException -> L12
        return;
    L20:
        return;
    L5:
        if (this.mLastAccessibilityButtonCallbackState != available) goto L7;
    }

    private void notifyGestureInternal(AccessibilityGestureEvent gestureInfo) {
        IAccessibilityServiceClient client = getClientSafely();
        if (client == null) goto L15;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error during sending gesture " + gestureInfo + " to " + this.mClientBinder, re);
        return;
    L5:
        if (svcClientTracingEnabled() == false) goto L9;
        logTraceSvcClient("onGesture", gestureInfo.toString());     // Catch: RemoteException -> L7
    L9:
        client.onGesture(gestureInfo);     // Catch: RemoteException -> L7
        return;
    }

    private void notifySystemActionsChangedInternal() {
        IAccessibilityServiceClient client = getClientSafely();
        if (client == null) goto L15;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error sending system actions change to " + this.mClientBinder, re);
        return;
    L5:
        if (svcClientTracingEnabled() == false) goto L9;
        logTraceSvcClient("onSystemActionsChanged", "");     // Catch: RemoteException -> L7
    L9:
        client.onSystemActionsChanged();     // Catch: RemoteException -> L7
        return;
    }

    private void notifyClearAccessibilityCacheInternal() {
        IAccessibilityServiceClient client = getClientSafely();
        if (client == null) goto L15;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error during requesting accessibility info cache to be cleared.", re);
        return;
    L5:
        if (svcClientTracingEnabled() == false) goto L9;
        logTraceSvcClient("clearAccessibilityCache", "");     // Catch: RemoteException -> L7
    L9:
        client.clearAccessibilityCache();     // Catch: RemoteException -> L7
        return;
    }

    protected void createImeSessionInternal() {
    }

    private void setImeSessionEnabledInternal(IAccessibilityInputMethodSession session, boolean enabled) {
        IAccessibilityServiceClient client = getClientSafely();
        if (client == null) goto L16;
        if (session == null) goto L17;
    L8:
        re = move-exception;
        Slog.e(LOG_TAG, "Error requesting IME session from " + this.mClientBinder, re);
        return;
    L6:
        if (svcClientTracingEnabled() == false) goto L10;
        logTraceSvcClient("createImeSession", "");     // Catch: RemoteException -> L8
    L10:
        client.setImeSessionEnabled(session, enabled);     // Catch: RemoteException -> L8
        return;
    L17:
        return;
    }

    private void bindInputInternal() {
        IAccessibilityServiceClient client = getClientSafely();
        if (client == null) goto L15;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error binding input to " + this.mClientBinder, re);
        return;
    L5:
        if (svcClientTracingEnabled() == false) goto L9;
        logTraceSvcClient("bindInput", "");     // Catch: RemoteException -> L7
    L9:
        client.bindInput();     // Catch: RemoteException -> L7
        return;
    }

    private void unbindInputInternal() {
        IAccessibilityServiceClient client = getClientSafely();
        if (client == null) goto L15;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error unbinding input to " + this.mClientBinder, re);
        return;
    L5:
        if (svcClientTracingEnabled() == false) goto L9;
        logTraceSvcClient("unbindInput", "");     // Catch: RemoteException -> L7
    L9:
        client.unbindInput();     // Catch: RemoteException -> L7
        return;
    }

    private void startInputInternal(IRemoteAccessibilityInputConnection connection, EditorInfo editorInfo, boolean restarting) {
        IAccessibilityServiceClient client = getClientSafely();
        if (client == null) goto L15;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error starting input to " + this.mClientBinder, re);
        return;
    L5:
        if (svcClientTracingEnabled() == false) goto L9;
        logTraceSvcClient("startInput", "editorInfo=" + editorInfo + " restarting=" + restarting);     // Catch: RemoteException -> L7
    L9:
        client.startInput(connection, editorInfo, restarting);     // Catch: RemoteException -> L7
        return;
    }

    protected IAccessibilityServiceClient getClientSafely() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        IAccessibilityServiceClient r1 = this.mClient;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private int resolveAccessibilityWindowIdLocked(int accessibilityWindowId) {
        if (accessibilityWindowId != Integer.MAX_VALUE) goto L9;
        int focusedWindowId = this.mA11yWindowManager.getActiveWindowId(this.mSystemSupport.getCurrentUserIdLocked());
        if (this.mA11yWindowManager.windowIdBelongsToDisplayType(focusedWindowId, this.mDisplayTypes) == true) goto L8;
        return -1;
    L8:
        return focusedWindowId;
    L9:
        return accessibilityWindowId;
    }

    int resolveAccessibilityWindowIdForFindFocusLocked(int windowId, int focusType) {
        if (windowId != (-2)) goto L9;
        int focusedWindowId = this.mA11yWindowManager.getFocusedWindowId(focusType);
        if (this.mA11yWindowManager.windowIdBelongsToDisplayType(focusedWindowId, this.mDisplayTypes) == true) goto L8;
        return -1;
    L8:
        return focusedWindowId;
    L9:
        return windowId;
    }

    private void ensureWindowsAvailableTimedLocked(int displayId) {
        if (displayId != (-1)) goto L6;
        return;
    L6:
        if (this.mA11yWindowManager.getWindowListLocked(displayId) == null) goto L9;
        return;
    L9:
        if (this.mA11yWindowManager.isTrackingWindowsLocked(displayId) == true) goto L12;
        this.mSystemSupport.onClientChangeLocked(false);
    L12:
        if (this.mA11yWindowManager.isTrackingWindowsLocked(displayId) == true) goto L14;
        return;
    L14:
        long startMillis = SystemClock.uptimeMillis();
    L16:
        if (this.mA11yWindowManager.getWindowListLocked(displayId) != null) goto L24;
        long elapsedMillis = SystemClock.uptimeMillis() - startMillis;
        long remainMillis = 5000 - elapsedMillis;
        if (remainMillis <= 0) goto L19;
        this.mLock.wait(remainMillis);     // Catch: InterruptedException -> L22
        goto L16
    L19:
        return;
    }

    private boolean performAccessibilityActionInternal(int userId, int resolvedWindowId, long accessibilityNodeId, int action, Bundle arguments, int interactionId, IAccessibilityInteractionConnectionCallback callback, int fetchFlags, long interrogatingTid) {
        IBinder windowToken = null;
        Object r5 = this.mLock;
        monitor-enter(r5);
        AccessibilityWindowManager.RemoteAccessibilityConnection connection = this.mA11yWindowManager.getConnectionLocked(userId, resolvedWindowId);     // Catch: Throwable -> L8
        if (connection != null) goto L11;
        monitor-exit(r5);     // Catch: Throwable -> L8
        return false;
    L11:
        if (action == 64) goto L16;
        if (action == 128) goto L16;
        boolean isA11yFocusAction = false;
    L17:
        if (isA11yFocusAction == false) goto L19;
    L105:
        AccessibilityWindowInfo a11yWindowInfo = this.mA11yWindowManager.findA11yWindowInfoByIdLocked(resolvedWindowId);     // Catch: Throwable -> L101
        if (a11yWindowInfo != null) goto L23;
    L29:
        AccessibilityWindowManager.RemoteAccessibilityConnection connection2 = connection;
    L30:
        monitor-exit(r5);     // Catch: Throwable -> L101
        int interrogatingPid = Binder.getCallingPid();
        long identityToken = Binder.clearCallingIdentity();
        this.mPowerManager.userActivity(SystemClock.uptimeMillis(), 3, 0);     // Catch: Throwable -> L93 RemoteException -> L95
        if (action != 16) goto L35;
    L36:
        this.mA11yWindowManager.notifyOutsideTouch(userId, resolvedWindowId);     // Catch: Throwable -> L93 RemoteException -> L95
    L37:
        if (windowToken != null) goto L110;
    L44:
        if (intConnTracingEnabled() == true) goto L116;
        long r8 = accessibilityNodeId;
        Bundle r6 = arguments;
        int r10 = interactionId;
        IAccessibilityInteractionConnectionCallback r11 = callback;
        long r13 = interrogatingTid;
    L124:
        goto L99
    L120:
        connection2.getRemote().performAccessibilityAction(r8, action, r6, r10, r11, fetchFlags, interrogatingPid, r13);     // Catch: Throwable -> L85 RemoteException -> L87
        Binder.restoreCallingIdentity(identityToken);
        return true;
    L85:
        th = th;
    L97:
        Binder.restoreCallingIdentity(identityToken);
        throw th;
    L89:
        th = th;
        goto L97
    L116:
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L74 RemoteException -> L76
        r8 = accessibilityNodeId;
        r7.append(r8);     // Catch: Throwable -> L70 RemoteException -> L72
        r7.append(";");     // Catch: Throwable -> L70 RemoteException -> L72
        r7.append(action);     // Catch: Throwable -> L70 RemoteException -> L72
        r7.append(";");     // Catch: Throwable -> L70 RemoteException -> L72
        r6 = arguments;
        r7.append(r6);     // Catch: Throwable -> L66 RemoteException -> L68
        r7.append(";");     // Catch: Throwable -> L66 RemoteException -> L68
        r10 = interactionId;
        r7.append(r10);     // Catch: Throwable -> L62 RemoteException -> L64
        r7.append(";");     // Catch: Throwable -> L62 RemoteException -> L64
        r11 = callback;
        r7.append(r11);     // Catch: Throwable -> L58 RemoteException -> L60
        r7.append(";");     // Catch: Throwable -> L58 RemoteException -> L60
        r7.append(this.mFetchFlags);     // Catch: Throwable -> L58 RemoteException -> L60
        r7.append(";");     // Catch: Throwable -> L58 RemoteException -> L60
        r7.append(interrogatingPid);     // Catch: Throwable -> L58 RemoteException -> L60
        r7.append(";");     // Catch: Throwable -> L58 RemoteException -> L60
        r13 = interrogatingTid;
        r7.append(r13);     // Catch: Throwable -> L40 RemoteException -> L42
        logTraceIntConn("performAccessibilityAction", r7.toString());     // Catch: Throwable -> L40 RemoteException -> L42
    L40:
        th = th;
        goto L97
    L58:
        th = th;
        goto L97
    L62:
        th = th;
        goto L97
    L66:
        th = th;
        goto L97
    L70:
        th = th;
        goto L97
    L74:
        th = th;
        goto L97
        goto L99
    L110:
        this.mWindowManagerService.requestWindowFocus(windowToken);     // Catch: Throwable -> L40 RemoteException -> L42
        goto L44
    L35:
        if (action != 32) goto L37;
    L93:
        th = th;
    L99:
        Binder.restoreCallingIdentity(identityToken);
        return false;
    L23:
        if (a11yWindowInfo.isInPictureInPictureMode() == false) goto L29;
        if (this.mA11yWindowManager.getPictureInPictureActionReplacingConnection() == null) goto L29;
        if (isA11yFocusAction == true) goto L29;
        connection2 = this.mA11yWindowManager.getPictureInPictureActionReplacingConnection();     // Catch: Throwable -> L8
    L101:
        re = th;
    L103:
        monitor-exit(r5);     // Catch: Throwable -> L8
        throw re;
    L19:
        windowToken = this.mA11yWindowManager.getWindowTokenForUserAndWindowIdLocked(userId, resolvedWindowId);     // Catch: Throwable -> L8
    L16:
        isA11yFocusAction = true;
    L8:
        re = th;
        goto L103
    }

    private IAccessibilityInteractionConnectionCallback replaceCallbackIfNeeded(IAccessibilityInteractionConnectionCallback originalCallback, int resolvedWindowId, int interactionId, int interrogatingPid, long interrogatingTid) {
        AccessibilityWindowManager.RemoteAccessibilityConnection pipActionReplacingConnection = this.mA11yWindowManager.getPictureInPictureActionReplacingConnection();
        Object r2 = this.mLock;
        monitor-enter(r2);
        AccessibilityWindowInfo windowInfo = this.mA11yWindowManager.findA11yWindowInfoByIdLocked(resolvedWindowId);     // Catch: Throwable -> L13
        if (windowInfo == null) goto L15;
        if (windowInfo.isInPictureInPictureMode() == false) goto L15;
        if (pipActionReplacingConnection == null) goto L15;
        monitor-exit(r2);     // Catch: Throwable -> L13
        return new ActionReplacingCallback(originalCallback, pipActionReplacingConnection.getRemote(), interactionId, interrogatingPid, interrogatingTid);
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L13
        return originalCallback;
    L13:
        th = move-exception;
        throw th;
    }

    private List<AccessibilityWindowInfo> getWindowsByDisplayLocked(int displayId) {
        List<AccessibilityWindowInfo> internalWindowList = this.mA11yWindowManager.getWindowListLocked(displayId);
        if (internalWindowList != null) goto L6;
        return null;
    L6:
        List<AccessibilityWindowInfo> returnedWindowList = new ArrayList();
        int windowCount = internalWindowList.size();
        int i = 0;
    L7:
        if (i >= windowCount) goto L10;
        AccessibilityWindowInfo window = internalWindowList.get(i);
        AccessibilityWindowInfo windowClone = AccessibilityWindowInfo.obtain(window);
        windowClone.setConnectionId(this.mId);
        returnedWindowList.add(windowClone);
        i = i + 1;
        goto L7
    L10:
        return returnedWindowList;
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    public boolean isServiceHandlesDoubleTapEnabled() {
        return this.mServiceHandlesDoubleTap;
    }

    public boolean isMultiFingerGesturesEnabled() {
        return this.mRequestMultiFingerGestures;
    }

    public boolean isTwoFingerPassthroughEnabled() {
        return this.mRequestTwoFingerPassthrough;
    }

    public boolean isSendMotionEventsEnabled() {
        return this.mSendMotionEvents;
    }

    public void setGestureDetectionPassthroughRegion(int displayId, Region region) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("setGestureDetectionPassthroughRegion", "displayId=" + displayId + ";region=" + region);
    L5:
        long identity = Binder.clearCallingIdentity();
        this.mSystemSupport.setGestureDetectionPassthroughRegion(displayId, region);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(identity);
        return;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void setTouchExplorationPassthroughRegion(int displayId, Region region) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("setTouchExplorationPassthroughRegion", "displayId=" + displayId + ";region=" + region);
    L5:
        long identity = Binder.clearCallingIdentity();
        this.mSystemSupport.setTouchExplorationPassthroughRegion(displayId, region);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(identity);
        return;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void setFocusAppearance(int strokeWidth, int color) {
        if (svcConnTracingEnabled() == false) goto L6;
        logTraceSvcConn("setFocusAppearance", "strokeWidth=" + strokeWidth + ";color=" + color);
        return;
    }

    public void setCacheEnabled(boolean enabled) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("setCacheEnabled", "enabled=" + enabled);
    L5:
        long identity = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L15
        monitor-enter(r2);     // Catch: Throwable -> L15
        this.mUsesAccessibilityCache = enabled;     // Catch: Throwable -> L12
        this.mSystemSupport.onClientChangeLocked(true);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(identity);
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void logTrace(long timestamp, String where, long loggingTypes, String callingParams, int processId, long threadId, int callingUid, Bundle callingStack) {
        long identity = Binder.clearCallingIdentity();
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L4:
        if (this.mTrace.isA11yTracingEnabledForTypes(loggingTypes) == false) goto L9;
        ArrayList<StackTraceElement> list = (ArrayList) callingStack.getSerializable("call_stack", ArrayList.class);     // Catch: Throwable -> L7
        HashSet<String> ignoreList = (HashSet) callingStack.getSerializable("ignore_call_stack", HashSet.class);     // Catch: Throwable -> L7
        this.mTrace.logTrace(timestamp, where, loggingTypes, callingParams, processId, threadId, callingUid, (StackTraceElement[]) list.toArray(new StackTraceElement[list.size()]), ignoreList);     // Catch: Throwable -> L7
    L9:
        Binder.restoreCallingIdentity(identity);
    }

    protected boolean svcClientTracingEnabled() {
        return this.mTrace.isA11yTracingEnabledForTypes(2);
    }

    protected void logTraceSvcClient(String methodName, String params) {
        this.mTrace.logTrace("AbstractAccessibilityServiceConnection.IAccessibilityServiceClient." + methodName, 2, params);
    }

    protected boolean svcConnTracingEnabled() {
        return this.mTrace.isA11yTracingEnabledForTypes(1);
    }

    protected void logTraceSvcConn(String methodName, String params) {
        this.mTrace.logTrace("AbstractAccessibilityServiceConnection.IAccessibilityServiceConnection." + methodName, 1, params);
    }

    protected boolean intConnTracingEnabled() {
        return this.mTrace.isA11yTracingEnabledForTypes(16);
    }

    protected void logTraceIntConn(String methodName, String params) {
        this.mTrace.logTrace("AbstractAccessibilityServiceConnection." + methodName, 16, params);
    }

    protected boolean wmTracingEnabled() {
        return this.mTrace.isA11yTracingEnabledForTypes(512);
    }

    protected void logTraceWM(String methodName, String params) {
        this.mTrace.logTrace("WindowManagerInternal." + methodName, 512, params);
    }

    public void setServiceDetectsGesturesEnabled(int displayId, boolean mode) {
        long identity = Binder.clearCallingIdentity();
        this.mServiceDetectsGestures.put(displayId, Boolean.valueOf(mode));     // Catch: Throwable -> L6
        this.mSystemSupport.setServiceDetectsGesturesEnabled(displayId, mode);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public boolean isServiceDetectsGesturesEnabled(int displayId) {
        if (this.mServiceDetectsGestures.contains(displayId) == true) goto L5;
        return false;
    L5:
        return this.mServiceDetectsGestures.get(displayId).booleanValue();
    }

    public void requestTouchExploration(int displayId) {
        long identity = Binder.clearCallingIdentity();
        this.mSystemSupport.requestTouchExploration(displayId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void requestDragging(int displayId, int pointerId) {
        long identity = Binder.clearCallingIdentity();
        this.mSystemSupport.requestDragging(displayId, pointerId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void requestDelegating(int displayId) {
        long identity = Binder.clearCallingIdentity();
        this.mSystemSupport.requestDelegating(displayId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void onDoubleTap(int displayId) {
        long identity = Binder.clearCallingIdentity();
        this.mSystemSupport.onDoubleTap(displayId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void onDoubleTapAndHold(int displayId) {
        long identity = Binder.clearCallingIdentity();
        this.mSystemSupport.onDoubleTapAndHold(displayId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void setAnimationScale(float scale) {
        UserManagerService.enforceCurrentUserIfVisibleBackgroundEnabled();
        long identity = Binder.clearCallingIdentity();
        Settings.Global.putFloat(this.mContext.getContentResolver(), "window_animation_scale", scale);     // Catch: Throwable -> L6
        Settings.Global.putFloat(this.mContext.getContentResolver(), "transition_animation_scale", scale);     // Catch: Throwable -> L6
        Settings.Global.putFloat(this.mContext.getContentResolver(), "animator_duration_scale", scale);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void attachAccessibilityOverlayToDisplay(int interactionId, int displayId, SurfaceControl sc, IAccessibilityInteractionConnectionCallback callback) {
        long identity = Binder.clearCallingIdentity();
        this.mSystemSupport.attachAccessibilityOverlayToDisplay(interactionId, displayId, sc, callback);     // Catch: Throwable -> L6
        this.mOverlays.add(sc);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void setMinumumIntervalObric(String targetPackageName, int eventType, int interval) {
        this.mSystemSupport.setMinumumIntervalObric(targetPackageName, eventType, interval, this);
    }

    public void attachAccessibilityOverlayToWindow(int interactionId, int accessibilityWindowId, SurfaceControl sc, IAccessibilityInteractionConnectionCallback callback) throws RemoteException {
        long identity = Binder.clearCallingIdentity();
        SurfaceControl.Transaction t = new SurfaceControl.Transaction();     // Catch: Throwable -> L20
        t.setTrustedOverlay(sc, true).apply();     // Catch: Throwable -> L20
        t.close();     // Catch: Throwable -> L20
        Object r3 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r3);     // Catch: Throwable -> L20
        AccessibilityWindowManager.RemoteAccessibilityConnection connection = this.mA11yWindowManager.getConnectionLocked(this.mSystemSupport.getCurrentUserIdLocked(), resolveAccessibilityWindowIdLocked(accessibilityWindowId));     // Catch: Throwable -> L11
        if (connection != null) goto L14;
        callback.sendAttachOverlayResult(2, interactionId);     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(identity);
        return;
    L14:
        connection.getRemote().attachAccessibilityOverlayToWindow(sc, interactionId, callback);     // Catch: Throwable -> L11
        this.mOverlays.add(sc);     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(identity);
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    protected void detachAllOverlays() {
        SurfaceControl.Transaction t = new SurfaceControl.Transaction();
        Iterator<SurfaceControl> r1 = this.mOverlays.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        SurfaceControl sc = r1.next();
        if (sc.isValid() == false) goto L4;
        t.reparent(sc, null);
        goto L4
    L9:
        t.apply();
        t.close();
        this.mOverlays.clear();
    }

    public void connectBluetoothBrailleDisplay(String bluetoothAddress, IBrailleDisplayController controller) {
        connectBluetoothBrailleDisplay_enforcePermission();
        throw new UnsupportedOperationException();
    }

    public void connectUsbBrailleDisplay(UsbDevice usbDevice, IBrailleDisplayController controller) {
        throw new UnsupportedOperationException();
    }

    public void setTestBrailleDisplayData(List<Bundle> brailleDisplays) {
        setTestBrailleDisplayData_enforcePermission();
        throw new UnsupportedOperationException();
    }
}
