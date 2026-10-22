package com.android.server.accessibility;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.AccessibilityTrace;
import android.accessibilityservice.IAccessibilityServiceClient;
import android.accessibilityservice.IBrailleDisplayController;
import android.accessibilityservice.TouchInteractionController;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ParceledListSlice;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.Trace;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Slog;
import android.view.MotionEvent;
import com.android.internal.inputmethod.IAccessibilityInputMethodSession;
import com.android.internal.inputmethod.IAccessibilityInputMethodSessionCallback;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.am.ProcessList;
import com.android.server.inputmethod.InputMethodManagerInternal;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.WindowManagerInternal;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class AccessibilityServiceConnection extends AbstractAccessibilityServiceConnection {
    private static final String LOG_TAG = "AccessibilityServiceConnection";
    final ActivityTaskManagerInternal mActivityTaskManagerService;
    private BrailleDisplayConnection mBrailleDisplayConnection;
    final Intent mIntent;
    private final Handler mMainHandler;
    private List<Bundle> mTestBrailleDisplays;
    final int mUserId;
    final WeakReference<AccessibilityUserState> mUserStateWeakReference;

    private static final class AccessibilityInputMethodSessionCallback extends IAccessibilityInputMethodSessionCallback.Stub {
        private final int mUserId;

        AccessibilityInputMethodSessionCallback(int userId) {
            this.mUserId = userId;
        }

        public void sessionCreated(IAccessibilityInputMethodSession session, int id) {
            Trace.traceBegin(32, "ASC.sessionCreated");
            long ident = Binder.clearCallingIdentity();
            InputMethodManagerInternal.get().onSessionForAccessibilityCreated(id, session, this.mUserId);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            Trace.traceEnd(32);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-vsqAho-CSPZFPoPLFsi2YZ7meo, reason: not valid java name */
    public static /* synthetic */ void m633$r8$lambda$vsqAhoCSPZFPoPLFsi2YZ7meo(AccessibilityServiceConnection r0) {
        r0.initializeService();
    }

    public static /* synthetic */ boolean $r8$lambda$FPwVLGPhLLp1WibSlHJ3aupyl80(String r0, BluetoothDevice r1) {
        return lambda$connectBluetoothBrailleDisplay$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ix8XNkq65CEJcq-0nkzZFnOc2FE, reason: not valid java name */
    public static /* synthetic */ void m634$r8$lambda$Ix8XNkq65CEJcq0nkzZFnOc2FE(AccessibilityServiceConnection r0, int r1, int r2) {
        r0.notifyTouchStateInternal(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$i8qJgzPpUSKPjZzwVfoLPJozfFQ(AccessibilityServiceConnection r0, MotionEvent r1) {
        r0.notifyMotionEventInternal(r1);
    }

    AccessibilityServiceConnection(AccessibilityUserState userState, Context context, ComponentName componentName, AccessibilityServiceInfo accessibilityServiceInfo, int id, Handler mainHandler, Object lock, AccessibilitySecurityPolicy securityPolicy, AbstractAccessibilityServiceConnection.SystemSupport systemSupport, AccessibilityTrace trace, WindowManagerInternal windowManagerInternal, SystemActionPerformer systemActionPerfomer, AccessibilityWindowManager awm, ActivityTaskManagerInternal activityTaskManagerService) {
        super(context, componentName, accessibilityServiceInfo, id, mainHandler, lock, securityPolicy, systemSupport, trace, windowManagerInternal, systemActionPerfomer, awm);
        this.mTestBrailleDisplays = null;
        this.mUserStateWeakReference = new WeakReference(userState);
        if (userState != null) goto L5;
        int r0 = ProcessList.INVALID_ADJ;
    L6:
        this.mUserId = r0;
        this.mIntent = new Intent().setComponent(this.mComponentName);
        this.mMainHandler = mainHandler;
        this.mIntent.putExtra("android.intent.extra.client_label", R.string.accessibility_enable_service_title);
        this.mActivityTaskManagerService = activityTaskManagerService;
        long identity = Binder.clearCallingIdentity();
        this.mIntent.putExtra("android.intent.extra.client_intent", this.mSystemSupport.getPendingIntentActivity(this.mContext, 0, new Intent("android.settings.ACCESSIBILITY_SETTINGS"), 67108864));     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L5:
        r0 = userState.mUserId;
        goto L6
    }

    public void bindLocked() {
        AccessibilityUserState userState = this.mUserStateWeakReference.get();
        if (userState != null) goto L5;
        return;
    L5:
        long identity = Binder.clearCallingIdentity();
        int flags = 34607105;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L7:
        if (userState.getBindInstantServiceAllowedLocked() == false) goto L10;
        flags = 34607105 | 4194304;     // Catch: Throwable -> L15
    L10:
        if (this.mClientBinder == null) goto L12;
    L17:
        Binder.restoreCallingIdentity(identity);
        this.mActivityTaskManagerService.setAllowAppSwitches(this.mComponentName.flattenToString(), this.mAccessibilityServiceInfo.getResolveInfo().serviceInfo.applicationInfo.uid, userState.mUserId);
        return;
    L12:
        if (this.mContext.bindServiceAsUser(this.mIntent, this, flags, new UserHandle(userState.mUserId)) == false) goto L17;
        userState.getBindingServicesLocked().add(this.mComponentName);     // Catch: Throwable -> L15
        goto L17
    }

    public void unbindLocked() {
        if (requestImeApis() == false) goto L5;
        this.mSystemSupport.unbindImeLocked(this);
    L5:
        this.mContext.unbindService(this);
        AccessibilityUserState userState = this.mUserStateWeakReference.get();
        if (userState != null) goto L8;
        return;
    L8:
        userState.removeServiceLocked(this);
        this.mSystemSupport.getMagnificationProcessor().resetAllIfNeeded(this.mId);
        this.mActivityTaskManagerService.setAllowAppSwitches(this.mComponentName.flattenToString(), -1, userState.mUserId);
        resetLocked();
    }

    public boolean canRetrieveInteractiveWindowsLocked() {
        if (this.mSecurityPolicy.canRetrieveWindowContentLocked(this) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mRetrieveInteractiveWindows == false) goto L7;
        return true;
    }

    public void disableSelf() {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("disableSelf", "");
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        AccessibilityUserState userState = this.mUserStateWeakReference.get();     // Catch: Throwable -> L11
        if (userState != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L14:
        if (userState.getEnabledServicesLocked().remove(this.mComponentName) == false) goto L21;
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L11
        this.mSystemSupport.persistComponentNamesToSettingLocked("enabled_accessibility_services", userState.getEnabledServicesLocked(), userState.mUserId);     // Catch: Throwable -> L18
        this.mSystemSupport.onClientChangeLocked(false);     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        goto L21
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder service) {
        AccessibilityUserState userState = this.mUserStateWeakReference.get();
        if (userState == null) goto L5;
        addWindowTokensForAllDisplays();
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mClientBinder != service) goto L10;
    L21:
        this.mClient = IAccessibilityServiceClient.Stub.asInterface(service);     // Catch: Throwable -> L12
        if (userState != null) goto L25;
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L25:
        userState.addServiceLocked(this);     // Catch: Throwable -> L12
        this.mSystemSupport.onClientChangeLocked(false);     // Catch: Throwable -> L12
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityServiceConnection$$ExternalSyntheticLambda1(), this));     // Catch: Throwable -> L12
        if (requestImeApis() == false) goto L28;
        this.mSystemSupport.requestImeLocked(this);     // Catch: Throwable -> L12
    L28:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L10:
        if (this.mClientBinder == null) goto L14;
        this.mClientBinder.unlinkToDeath(this, 0);     // Catch: Throwable -> L12
    L14:
        this.mClientBinder = service;     // Catch: Throwable -> L12
        this.mClientBinder.linkToDeath(this, 0);     // Catch: Throwable -> L12 RemoteException -> L17
    L18:
        Slog.e(LOG_TAG, "Failed registering death link");     // Catch: Throwable -> L12
        binderDied();     // Catch: Throwable -> L12
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public AccessibilityServiceInfo getServiceInfo() {
        return this.mAccessibilityServiceInfo;
    }

    private void initializeService() {
        IAccessibilityServiceClient client = null;
        Object r1 = this.mLock;
        monitor-enter(r1);
        AccessibilityUserState userState = this.mUserStateWeakReference.get();     // Catch: Throwable -> L8
        if (userState != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        Set<ComponentName> bindingServices = userState.getBindingServicesLocked();     // Catch: Throwable -> L8
        Set<ComponentName> crashedServices = userState.getCrashedServicesLocked();     // Catch: Throwable -> L8
        if (bindingServices.contains(this.mComponentName) == false) goto L13;
    L14:
        bindingServices.remove(this.mComponentName);     // Catch: Throwable -> L8
        crashedServices.remove(this.mComponentName);     // Catch: Throwable -> L8
        this.mAccessibilityServiceInfo.crashed = false;     // Catch: Throwable -> L8
        client = this.mClient;     // Catch: Throwable -> L8
    L15:
        if (client != null) goto L17;
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L8
        if (client != null) goto L37;
        binderDied();
        return;
    L37:
    L28:
        re = move-exception;
        Slog.w(LOG_TAG, "Error while setting connection for service: " + client, re);
        binderDied();
        return;
    L26:
        if (svcClientTracingEnabled() == false) goto L30;
        logTraceSvcClient("init", this + "," + this.mId + "," + this.mOverlayWindowTokens.get(0));     // Catch: RemoteException -> L28
    L30:
        client.init(this, this.mId, this.mOverlayWindowTokens.get(0));     // Catch: RemoteException -> L28
        return;
    L17:
        if (userState.getEnabledServicesLocked().contains(this.mComponentName) == true) goto L21;
        this.mSystemSupport.onClientChangeLocked(false);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L13:
        if (crashedServices.contains(this.mComponentName) == false) goto L15;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        binderDied();
        AccessibilityUserState userState = this.mUserStateWeakReference.get();
        if (userState == null) goto L6;
        this.mActivityTaskManagerService.setAllowAppSwitches(this.mComponentName.flattenToString(), -1, userState.mUserId);
        return;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        unbindLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    protected boolean hasRightsToCurrentUserLocked() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 0) goto L5;
    L20:
        return true;
    L5:
        if (callingUid == 1000) goto L20;
        if (callingUid == 2000) goto L20;
        if (this.mSecurityPolicy.resolveProfileParentLocked(UserHandle.getUserId(callingUid)) != this.mSystemSupport.getCurrentUserIdLocked()) goto L13;
        return true;
    L13:
        if (this.mSecurityPolicy.hasPermission("android.permission.INTERACT_ACROSS_USERS") == false) goto L15;
    L19:
        return true;
    L15:
        if (this.mSecurityPolicy.hasPermission("android.permission.INTERACT_ACROSS_USERS_FULL") == true) goto L19;
        return false;
    }

    public boolean setSoftKeyboardShowMode(int showMode) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("setSoftKeyboardShowMode", "showMode=" + showMode);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (hasRightsToCurrentUserLocked() == true) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L13:
        AccessibilityUserState userState = this.mUserStateWeakReference.get();     // Catch: Throwable -> L11
        if (userState != null) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L17:
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L11
        boolean r4 = userState.setSoftKeyboardModeLocked(showMode, this.mComponentName);     // Catch: Throwable -> L22
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r4;
    L22:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    }

    public int getSoftKeyboardShowMode() {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("getSoftKeyboardShowMode", "");
    L5:
        AccessibilityUserState userState = this.mUserStateWeakReference.get();
        long identity = Binder.clearCallingIdentity();
        if (userState != null) goto L15;
        int r3 = 0;
    L13:
        Binder.restoreCallingIdentity(identity);
        return r3;
    L15:
        r3 = userState.getSoftKeyboardShowModeLocked();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public boolean switchToInputMethod(String imeId) {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("switchToInputMethod", "imeId=" + imeId);
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
        int callingUserId = UserHandle.getCallingUserId();
        long identity = Binder.clearCallingIdentity();
        boolean result = InputMethodManagerInternal.get().switchToInputMethod(imeId, callingUserId);     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(identity);
        return result;
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public int setInputMethodEnabled(String imeId, boolean enabled) throws SecurityException {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("switchToInputMethod", "imeId=" + imeId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (hasRightsToCurrentUserLocked() == true) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return 2;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        int callingUserId = UserHandle.getCallingUserId();
        InputMethodManagerInternal inputMethodManagerInternal = InputMethodManagerInternal.get();
        long identity = Binder.clearCallingIdentity();
        int checkResult = this.mSecurityPolicy.canEnableDisableInputMethod(imeId, this, callingUserId);     // Catch: Throwable -> L25
        if (checkResult == 0) goto L19;
        Binder.restoreCallingIdentity(identity);
        return checkResult;
    L19:
        if (inputMethodManagerInternal.setInputMethodEnabled(imeId, enabled, callingUserId) == false) goto L23;
        Binder.restoreCallingIdentity(identity);
        return 0;
    L23:
        Binder.restoreCallingIdentity(identity);
        return 2;
    L25:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public boolean isAccessibilityButtonAvailable() {
        if (svcConnTracingEnabled() == false) goto L5;
        logTraceSvcConn("isAccessibilityButtonAvailable", "");
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = false;
        if (hasRightsToCurrentUserLocked() == true) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L13:
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L11
        AccessibilityUserState userState = this.mUserStateWeakReference.get();     // Catch: Throwable -> L19
        if (userState == null) goto L21;
        if (isAccessibilityButtonAvailableLocked(userState) == false) goto L21;
        r2 = true;
        goto L21
    L21:
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (isConnectedLocked() == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (requestImeApis() == false) goto L13;
        this.mSystemSupport.unbindImeLocked(this);     // Catch: Throwable -> L8
    L13:
        this.mAccessibilityServiceInfo.crashed = true;     // Catch: Throwable -> L8
        AccessibilityUserState userState = this.mUserStateWeakReference.get();     // Catch: Throwable -> L8
        if (userState == null) goto L16;
        userState.serviceDisconnectedLocked(this);     // Catch: Throwable -> L8
    L16:
        resetLocked();     // Catch: Throwable -> L8
        this.mSystemSupport.getMagnificationProcessor().resetAllIfNeeded(this.mId);     // Catch: Throwable -> L8
        this.mSystemSupport.onClientChangeLocked(false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void resetLocked() {
        super.resetLocked();
        if (this.mBrailleDisplayConnection == null) goto L6;
        this.mBrailleDisplayConnection.disconnect();
        return;
    }

    public boolean isAccessibilityButtonAvailableLocked(AccessibilityUserState userState) {
        if (this.mRequestAccessibilityButton == true) goto L6;
        return false;
    L6:
        if (this.mSystemSupport.isAccessibilityButtonShown() == true) goto L8;
        return false;
    L8:
        return true;
    }

    @Override // com.android.server.accessibility.FingerprintGestureDispatcher.FingerprintGestureClient
    public boolean isCapturingFingerprintGestures() {
        if (this.mClient != null) goto L5;
    L9:
        return false;
    L5:
        if (this.mSecurityPolicy.canCaptureFingerprintGestures(this) == false) goto L9;
        if (this.mCaptureFingerprintGestures == false) goto L9;
        return true;
    }

    @Override // com.android.server.accessibility.FingerprintGestureDispatcher.FingerprintGestureClient
    public void onFingerprintGestureDetectionActiveChanged(boolean active) {
        if (isCapturingFingerprintGestures() == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        IAccessibilityServiceClient client = this.mClient;     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        if (client == null) goto L24;
        if (svcClientTracingEnabled() == false) goto L15;
        logTraceSvcClient("onFingerprintCapturingGesturesChanged", String.valueOf(active));     // Catch: RemoteException -> L13
    L15:
        this.mClient.onFingerprintCapturingGesturesChanged(active);     // Catch: RemoteException -> L13
        return;
    L25:
        return;
    L24:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.accessibility.FingerprintGestureDispatcher.FingerprintGestureClient
    public void onFingerprintGesture(int gesture) {
        if (isCapturingFingerprintGestures() == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        IAccessibilityServiceClient client = this.mClient;     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        if (client == null) goto L24;
        if (svcClientTracingEnabled() == false) goto L15;
        logTraceSvcClient("onFingerprintGesture", String.valueOf(gesture));     // Catch: RemoteException -> L13
    L15:
        this.mClient.onFingerprintGesture(gesture);     // Catch: RemoteException -> L13
        return;
    L25:
        return;
    L24:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void dispatchGesture(int sequence, ParceledListSlice gestureSteps, int displayId) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L42:
        th = move-exception;
        Throwable r11 = th;
    L47:
        monitor-exit(r1);     // Catch: Throwable -> L38
        throw r11;
    L5:
        if (this.mClient == null) goto L45;
        if (this.mSecurityPolicy.canPerformGestures(this) == false) goto L45;
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L42
        MotionEventInjector motionEventInjector = this.mSystemSupport.getMotionEventInjectorForDisplayLocked(displayId);     // Catch: Throwable -> L24
        if (wmTracingEnabled() == false) goto L54;
        logTraceWM("isTouchOrFaketouchDevice", "");     // Catch: Throwable -> L13
    L13:
        th = th;
    L40:
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L54:
        if (motionEventInjector == null) goto L55;
        if (this.mWindowManagerService.isTouchOrFaketouchDevice() == false) goto L55;
        motionEventInjector.injectEvents(gestureSteps.getList(), this.mClient, sequence, displayId, this.mAccessibilityServiceInfo.isAccessibilityTool());     // Catch: Throwable -> L22
    L37:
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L38
    L55:
    L31:
        re = move-exception;
        Slog.e(LOG_TAG, "Error sending motion event injection failure to " + this.mClient, re);     // Catch: Throwable -> L22
        goto L37
    L29:
        if (svcClientTracingEnabled() == false) goto L33;
        logTraceSvcClient("onPerformGestureResult", sequence + ", false");     // Catch: Throwable -> L22 RemoteException -> L31
    L33:
        this.mClient.onPerformGestureResult(sequence, false);     // Catch: Throwable -> L22 RemoteException -> L31
    L22:
        th = th;
    L24:
        th = th;
    L45:
        monitor-exit(r1);     // Catch: Throwable -> L38
        return;
    L38:
        th = move-exception;
        r11 = th;
        goto L47
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void setFocusAppearance(int strokeWidth, int color) {
        AccessibilityUserState userState = this.mUserStateWeakReference.get();
        if (userState != null) goto L5;
        return;
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (hasRightsToCurrentUserLocked() == true) goto L14;
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L14:
        if (this.mSecurityPolicy.checkAccessibilityAccess(this) == true) goto L18;
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L18:
        if (userState.getFocusStrokeWidthLocked() == strokeWidth) goto L20;
    L23:
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L11
        userState.setFocusAppearanceLocked(strokeWidth, color);     // Catch: Throwable -> L28
        this.mSystemSupport.onClientChangeLocked(false);     // Catch: Throwable -> L28
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L28:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L20:
        if (userState.getFocusColorLocked() != color) goto L23;
        monitor-exit(r1);     // Catch: Throwable -> L11
    }

    public void notifyMotionEvent(MotionEvent event) {
        Message msg = PooledLambda.obtainMessage(new AccessibilityServiceConnection$$ExternalSyntheticLambda0(), this, event);
        this.mMainHandler.sendMessage(msg);
    }

    public void notifyTouchState(int displayId, int state) {
        Message msg = PooledLambda.obtainMessage(new AccessibilityServiceConnection$$ExternalSyntheticLambda2(), this, Integer.valueOf(displayId), Integer.valueOf(state));
        this.mMainHandler.sendMessage(msg);
    }

    public boolean requestImeApis() {
        return this.mRequestImeApis;
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    protected void createImeSessionInternal() {
        IAccessibilityServiceClient client = getClientSafely();
        if (client == null) goto L15;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error requesting IME session from " + this.mClientBinder, re);
        return;
    L5:
        if (svcClientTracingEnabled() == false) goto L9;
        logTraceSvcClient("createImeSession", "");     // Catch: RemoteException -> L7
    L9:
        AccessibilityInputMethodSessionCallback callback = new AccessibilityInputMethodSessionCallback(this.mUserId);     // Catch: RemoteException -> L7
        client.createImeSession(callback);     // Catch: RemoteException -> L7
        return;
    }

    private void notifyMotionEventInternal(MotionEvent event) {
        IAccessibilityServiceClient client = getClientSafely();
        if (client == null) goto L15;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error sending motion event to" + this.mClientBinder, re);
        return;
    L5:
        if (this.mTrace.isA11yTracingEnabled() == false) goto L9;
        logTraceSvcClient(".onMotionEvent ", event.toString());     // Catch: RemoteException -> L7
    L9:
        client.onMotionEvent(event);     // Catch: RemoteException -> L7
        return;
    }

    private void notifyTouchStateInternal(int displayId, int state) {
        IAccessibilityServiceClient client = getClientSafely();
        if (client == null) goto L15;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error sending motion event to" + this.mClientBinder, re);
        return;
    L5:
        if (this.mTrace.isA11yTracingEnabled() == false) goto L9;
        logTraceSvcClient(".onTouchStateChanged ", TouchInteractionController.stateToString(state));     // Catch: RemoteException -> L7
    L9:
        client.onTouchStateChanged(displayId, state);     // Catch: RemoteException -> L7
        return;
    }

    private void checkAccessibilityAccessLocked() {
        if (hasRightsToCurrentUserLocked() == false) goto L8;
        if (this.mSecurityPolicy.checkAccessibilityAccess(this) == false) goto L8;
        return;
    L8:
        throw new SecurityException("Caller does not have accessibility access");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void connectBluetoothBrailleDisplay(final String bluetoothAddress, IBrailleDisplayController controller) {
        connectBluetoothBrailleDisplay_enforcePermission();
        bluetoothAddress.getClass();
        controller.getClass();
        if (BluetoothAdapter.checkBluetoothAddress(bluetoothAddress) == false) goto L25;
        BluetoothManager bluetoothManager = (BluetoothManager) this.mContext.getSystemService(BluetoothManager.class);
        String bluetoothDeviceName = null;
        if (bluetoothManager == null) goto L8;
        bluetoothDeviceName = (String) bluetoothManager.getAdapter().getBondedDevices().stream().filter(new AccessibilityServiceConnection$$ExternalSyntheticLambda3(bluetoothAddress)).map(new AccessibilityServiceConnection$$ExternalSyntheticLambda4()).findFirst().orElse(null);
    L8:
        Object r2 = this.mLock;
        monitor-enter(r2);
        checkAccessibilityAccessLocked();     // Catch: Throwable -> L15
        if (this.mBrailleDisplayConnection != null) goto L21;
        BrailleDisplayConnection connection = new BrailleDisplayConnection(this.mLock, this);     // Catch: Throwable -> L15
        if (this.mTestBrailleDisplays == null) goto L17;
        connection.setTestData(this.mTestBrailleDisplays);     // Catch: Throwable -> L15
    L17:
        connection.connectLocked(bluetoothAddress, bluetoothDeviceName, 5, controller);     // Catch: Throwable -> L15
        monitor-exit(r2);     // Catch: Throwable -> L15
        return;
    L21:
        throw new IllegalStateException("This service already has a connected Braille display");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L25:
        throw new IllegalArgumentException(bluetoothAddress + " is not a valid Bluetooth address");
    }

    private static /* synthetic */ boolean lambda$connectBluetoothBrailleDisplay$0(String bluetoothAddress, BluetoothDevice device) {
        return device.getAddress().equalsIgnoreCase(bluetoothAddress);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void connectUsbBrailleDisplay(UsbDevice usbDevice, IBrailleDisplayController controller) {
        usbDevice.getClass();
        controller.getClass();
        UsbManager usbManager = (UsbManager) this.mContext.getSystemService("usb");
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        long identity = Binder.clearCallingIdentity();
        if (usbManager == null) goto L34;
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L5:
        if (usbManager.hasPermission(usbDevice, this.mComponentName.getPackageName(), pid, uid) == false) goto L34;
        String usbSerialNumber = usbDevice.getSerialNumber();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(usbSerialNumber) == true) goto L37;
        Binder.restoreCallingIdentity(identity);
        Object r6 = this.mLock;
        monitor-enter(r6);
        checkAccessibilityAccessLocked();     // Catch: Throwable -> L24
        if (this.mBrailleDisplayConnection != null) goto L30;
        BrailleDisplayConnection connection = new BrailleDisplayConnection(this.mLock, this);     // Catch: Throwable -> L24
        if (this.mTestBrailleDisplays == null) goto L26;
        connection.setTestData(this.mTestBrailleDisplays);     // Catch: Throwable -> L24
    L26:
        connection.connectLocked(usbSerialNumber, usbDevice.getProductName(), 3, controller);     // Catch: Throwable -> L24
        monitor-exit(r6);     // Catch: Throwable -> L24
        return;
    L30:
        throw new IllegalStateException("This service already has a connected Braille display");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    L37:
        controller.onConnectionFailed(2);     // Catch: Throwable -> L11 RemoteException -> L13
    L15:
        Binder.restoreCallingIdentity(identity);
        return;
    L13:
        e = move-exception;
        Slog.e(LOG_TAG, "Error calling onConnectionFailed", e);     // Catch: Throwable -> L11
    L34:
        throw new SecurityException("Caller does not have permission to access this UsbDevice");     // Catch: Throwable -> L11
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void setTestBrailleDisplayData(List<Bundle> brailleDisplays) {
        setTestBrailleDisplayData_enforcePermission();
        this.mTestBrailleDisplays = brailleDisplays;
    }

    void onBrailleDisplayConnectedLocked(BrailleDisplayConnection connection) {
        this.mBrailleDisplayConnection = connection;
    }

    void onBrailleDisplayDisconnectedLocked() {
        this.mBrailleDisplayConnection = null;
    }
}
