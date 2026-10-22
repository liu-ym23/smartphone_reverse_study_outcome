package com.android.server.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.AccessibilityTrace;
import android.accessibilityservice.IAccessibilityServiceClient;
import android.content.ComponentName;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.util.Slog;
import android.view.accessibility.AccessibilityEvent;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.Preconditions;
import com.android.server.utils.Slogf;
import com.android.server.wm.WindowManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
class UiAutomationManager {
    private static final ComponentName COMPONENT_NAME = null;
    private static final String LOG_TAG = "UiAutomationManager";
    private final Object mLock;
    private AbstractAccessibilityServiceConnection.SystemSupport mSystemSupport;
    private int mUiAutomationFlags;
    private UiAutomationService mUiAutomationService;
    private IBinder mUiAutomationServiceOwner;
    private final IBinder.DeathRecipient mUiAutomationServiceOwnerDeathRecipient;

    private class UiAutomationService extends AbstractAccessibilityServiceConnection {
        private final Handler mMainHandler;
        final /* synthetic */ UiAutomationManager this$0;

        public static /* synthetic */ void $r8$lambda$EBbVjiQaLueOGoICPHv_0YkCzl4(UiAutomationService r0) {
            r0.lambda$connectServiceUnknownThread$0();
        }

        UiAutomationService(UiAutomationManager r14, Context context, AccessibilityServiceInfo accessibilityServiceInfo, int id, Handler mainHandler, Object lock, AccessibilitySecurityPolicy securityPolicy, AbstractAccessibilityServiceConnection.SystemSupport systemSupport, AccessibilityTrace trace, WindowManagerInternal windowManagerInternal, SystemActionPerformer systemActionPerformer, AccessibilityWindowManager awm) {
            this.this$0 = r14;
            super(context, UiAutomationManager.m736$$Nest$sfgetCOMPONENT_NAME(), accessibilityServiceInfo, id, mainHandler, lock, securityPolicy, systemSupport, trace, windowManagerInternal, systemActionPerformer, awm);
            if (mainHandler.getLooper() != Looper.getMainLooper()) goto L5;
            boolean isMainHandler = true;
        L7:
            if (Build.IS_USERDEBUG == false) goto L9;
        L13:
            Preconditions.checkArgument(isMainHandler, "UiAutomationService must use the main handler");
        L14:
            this.mMainHandler = mainHandler;
            setDisplayTypes(3);
            return;
        L9:
            if (Build.IS_ENG == true) goto L13;
            if (isMainHandler == true) goto L14;
            Slog.e(UiAutomationManager.LOG_TAG, "UiAutomationService must use the main handler");
            goto L14
        L5:
            isMainHandler = false;
            goto L7
        }

        void connectServiceUnknownThread() {
            this.mMainHandler.post(new UiAutomationManager$UiAutomationService$$ExternalSyntheticLambda0(this));
        }

        private /* synthetic */ void lambda$connectServiceUnknownThread$0() {
            Object r0 = this.mLock;     // Catch: RemoteException -> L16
            monitor-enter(r0);     // Catch: RemoteException -> L16
            IAccessibilityServiceClient client = this.mClient;     // Catch: Throwable -> L7
            UiAutomationService uiAutomationService = UiAutomationManager.m732$$Nest$fgetmUiAutomationService(this.this$0);     // Catch: Throwable -> L7
            if (client != null) goto L9;
            this.mClientBinder = null;     // Catch: Throwable -> L7
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            if (client == null) goto L28;
            if (uiAutomationService == null) goto L29;
            uiAutomationService.addWindowTokensForAllDisplays();     // Catch: RemoteException -> L16
            if (this.mTrace.isA11yTracingEnabledForTypes(2) == false) goto L18;
            this.mTrace.logTrace("UiAutomationService.connectServiceUnknownThread", 2, "serviceConnection=" + this + ";connectionId=" + this.mId + "windowToken=" + this.mOverlayWindowTokens.get(0));     // Catch: RemoteException -> L16
        L18:
            client.init(this, this.mId, this.mOverlayWindowTokens.get(0));     // Catch: RemoteException -> L16
            return;
        L29:
            return;
        L28:
            return;
        L9:
            this.mClientBinder = this.mClient.asBinder();     // Catch: Throwable -> L7
            this.mClientBinder.linkToDeath(this, 0);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;     // Catch: RemoteException -> L16
        L16:
            re = move-exception;
            Slog.w(UiAutomationManager.LOG_TAG, "Error initializing connection", re);
            UiAutomationManager.m735$$Nest$mdestroyUiAutomationService(this.this$0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            UiAutomationManager.m735$$Nest$mdestroyUiAutomationService(this.this$0);
        }

        @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
        protected boolean hasRightsToCurrentUserLocked() {
            return true;
        }

        @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
        protected boolean supportsFlagForNotImportantViews(AccessibilityServiceInfo info) {
            return true;
        }

        @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
        public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.mContext, UiAutomationManager.LOG_TAG, pw) == true) goto L5;
            return;
        L5:
            Object r0 = this.mLock;
            monitor-enter(r0);
            pw.append("Ui Automation[eventTypes=" + AccessibilityEvent.eventTypeToString(this.mEventTypes));     // Catch: Throwable -> L10
            pw.append(", notificationTimeout=" + this.mNotificationTimeout);     // Catch: Throwable -> L10
            pw.append("]");     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public boolean setSoftKeyboardShowMode(int mode) {
            return false;
        }

        public int getSoftKeyboardShowMode() {
            return 0;
        }

        public boolean switchToInputMethod(String imeId) {
            return false;
        }

        public int setInputMethodEnabled(String imeId, boolean enabled) {
            return 2;
        }

        public boolean isAccessibilityButtonAvailable() {
            return false;
        }

        public void disableSelf() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder service) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // com.android.server.accessibility.FingerprintGestureDispatcher.FingerprintGestureClient
        public boolean isCapturingFingerprintGestures() {
            return false;
        }

        @Override // com.android.server.accessibility.FingerprintGestureDispatcher.FingerprintGestureClient
        public void onFingerprintGestureDetectionActiveChanged(boolean active) {
        }

        @Override // com.android.server.accessibility.FingerprintGestureDispatcher.FingerprintGestureClient
        public void onFingerprintGesture(int gesture) {
        }

        @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
        public void takeScreenshot(int displayId, RemoteCallback callback) {
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUiAutomationService, reason: not valid java name */
    static /* bridge */ /* synthetic */ UiAutomationService m732$$Nest$fgetmUiAutomationService(UiAutomationManager r0) {
        return r0.mUiAutomationService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUiAutomationServiceOwner, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m733$$Nest$fgetmUiAutomationServiceOwner(UiAutomationManager r0) {
        return r0.mUiAutomationServiceOwner;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUiAutomationServiceOwner, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m734$$Nest$fputmUiAutomationServiceOwner(UiAutomationManager r0, IBinder r1) {
        r0.mUiAutomationServiceOwner = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mdestroyUiAutomationService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m735$$Nest$mdestroyUiAutomationService(UiAutomationManager r0) {
        r0.destroyUiAutomationService();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetCOMPONENT_NAME, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComponentName m736$$Nest$sfgetCOMPONENT_NAME() {
        return COMPONENT_NAME;
    }

    static {
        COMPONENT_NAME = new ComponentName("com.android.server.accessibility", "UiAutomation");
    }

    UiAutomationManager(Object lock) {
        this.mUiAutomationServiceOwnerDeathRecipient = new AnonymousClass1(this);
        this.mLock = lock;
    }

    void registerUiTestAutomationServiceLocked(IBinder owner, IAccessibilityServiceClient serviceClient, Context context, AccessibilityServiceInfo accessibilityServiceInfo, int id, Handler mainHandler, AccessibilitySecurityPolicy securityPolicy, AbstractAccessibilityServiceConnection.SystemSupport systemSupport, AccessibilityTrace trace, WindowManagerInternal windowManagerInternal, SystemActionPerformer systemActionPerformer, AccessibilityWindowManager awm, int flags) {
        accessibilityServiceInfo.setComponentName(COMPONENT_NAME);
        Slogf.i(LOG_TAG, "Registering UiTestAutomationService (id=%s, flags=0x%x) when called by user %d", new Object[]{accessibilityServiceInfo.getId(), Integer.valueOf(flags), Integer.valueOf(Binder.getCallingUserHandle().getIdentifier())});
        if (this.mUiAutomationService != null) goto L19;
        owner.linkToDeath(this.mUiAutomationServiceOwnerDeathRecipient, 0);     // Catch: RemoteException -> L15
        this.mUiAutomationFlags = flags;
        this.mSystemSupport = systemSupport;
        if (useAccessibility() == true) goto L8;
        return;
    L8:
        this.mUiAutomationService = new UiAutomationService(this, context, accessibilityServiceInfo, id, mainHandler, this.mLock, securityPolicy, systemSupport, trace, windowManagerInternal, systemActionPerformer, awm);
        this.mUiAutomationServiceOwner = owner;
        this.mUiAutomationService.mClient = serviceClient;
        this.mUiAutomationService.mClient.asBinder().linkToDeath(this.mUiAutomationService, 0);     // Catch: RemoteException -> L12
        this.mUiAutomationService.connectServiceUnknownThread();
        return;
    L12:
        re = move-exception;
        Slog.e(LOG_TAG, "Failed registering death link: " + re);
        destroyUiAutomationService();
        return;
    L15:
        re = move-exception;
        Slog.e(LOG_TAG, "Couldn't register for the death of a UiTestAutomationService!", re);
        return;
    L19:
        throw new IllegalStateException("UiAutomationService " + this.mUiAutomationService.mClient + "already registered!");
    }

    void unregisterUiTestAutomationServiceLocked(IAccessibilityServiceClient serviceClient) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (useAccessibility() == true) goto L7;
    L18:
        destroyUiAutomationService();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.mUiAutomationService == null) goto L17;
        if (serviceClient == null) goto L17;
        if (this.mUiAutomationService.mClient == null) goto L17;
        if (serviceClient.asBinder() == this.mUiAutomationService.mClient.asBinder()) goto L18;
    L17:
        throw new IllegalStateException("UiAutomationService " + serviceClient + " not registered!");     // Catch: Throwable -> L14
    }

    void sendAccessibilityEventLocked(AccessibilityEvent event) {
        if (this.mUiAutomationService == null) goto L6;
        this.mUiAutomationService.notifyAccessibilityEvent(event);
        return;
    }

    boolean isUiAutomationRunningLocked() {
        if (this.mUiAutomationService == null) goto L5;
    L8:
        return true;
    L5:
        if (useAccessibility() == false) goto L8;
        return false;
    }

    boolean suppressingAccessibilityServicesLocked() {
        if (SystemProperties.getBoolean("debug.obric.uiautomator.suppress", false) == false) goto L7;
        Slog.d(LOG_TAG, "uiautomator NOT suppresses accessibility services");
        return false;
    L7:
        if (this.mUiAutomationService != null) goto L11;
        if (useAccessibility() == false) goto L11;
        return false;
    L11:
        if ((this.mUiAutomationFlags & 1) == 0) goto L13;
        return false;
    L13:
        return true;
    }

    boolean useAccessibility() {
        if ((this.mUiAutomationFlags & 2) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean canIntrospect() {
        if (this.mUiAutomationService == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isTouchExplorationEnabledLocked() {
        if (this.mUiAutomationService != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mUiAutomationService.mRequestTouchExplorationMode == false) goto L7;
        return true;
    }

    boolean canRetrieveInteractiveWindowsLocked() {
        if (this.mUiAutomationService != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mUiAutomationService.mRetrieveInteractiveWindows == false) goto L7;
        return true;
    }

    int getRequestedEventMaskLocked() {
        if (this.mUiAutomationService != null) goto L7;
        return 0;
    L7:
        return this.mUiAutomationService.mEventTypes;
    }

    int getRelevantEventTypes() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UiAutomationService uiAutomationService = this.mUiAutomationService;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        if (uiAutomationService != null) goto L10;
        return 0;
    L10:
        return uiAutomationService.getRelevantEventTypes();
    L11:
        th = move-exception;
        throw th;
    }

    AccessibilityServiceInfo getServiceInfo() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UiAutomationService uiAutomationService = this.mUiAutomationService;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        if (uiAutomationService != null) goto L10;
        return null;
    L10:
        return uiAutomationService.getServiceInfo();
    L11:
        th = move-exception;
        throw th;
    }

    void dumpUiAutomationService(FileDescriptor fd, PrintWriter pw, String[] args) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UiAutomationService uiAutomationService = this.mUiAutomationService;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (uiAutomationService == null) goto L14;
        uiAutomationService.dump(fd, pw, args);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void destroyUiAutomationService() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mUiAutomationService == null) goto L11;
        this.mUiAutomationService.mClient.asBinder().unlinkToDeath(this.mUiAutomationService, 0);     // Catch: Throwable -> L9
        this.mUiAutomationService.onRemoved();     // Catch: Throwable -> L9
        this.mUiAutomationService.resetLocked();     // Catch: Throwable -> L9
        this.mUiAutomationService = null;     // Catch: Throwable -> L9
        if (this.mUiAutomationServiceOwner == null) goto L11;
        this.mUiAutomationServiceOwner.unlinkToDeath(this.mUiAutomationServiceOwnerDeathRecipient, 0);     // Catch: Throwable -> L9
        this.mUiAutomationServiceOwner = null;     // Catch: Throwable -> L9
    L11:
        this.mUiAutomationFlags = 0;     // Catch: Throwable -> L9
        this.mSystemSupport.onClientChangeLocked(false);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }
}
