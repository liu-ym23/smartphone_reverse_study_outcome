package com.android.server.accessibility;

import android.R;
import android.accessibilityservice.AccessibilityGestureEvent;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.AccessibilityTrace;
import android.accessibilityservice.IAccessibilityServiceClient;
import android.accessibilityservice.IBrailleDisplayController;
import android.accessibilityservice.MagnificationConfig;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ParceledListSlice;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Region;
import android.hardware.usb.UsbDevice;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceControl;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import android.view.accessibility.IAccessibilityInteractionConnectionCallback;
import android.view.inputmethod.EditorInfo;
import android.window.ScreenCapture;
import com.android.internal.inputmethod.IAccessibilityInputMethodSession;
import com.android.internal.inputmethod.IRemoteAccessibilityInputConnection;
import com.android.internal.util.DumpUtils;
import com.android.server.wm.WindowManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ProxyAccessibilityServiceConnection extends AccessibilityServiceConnection {
    private static final String LOG_TAG = "ProxyAccessibilityServiceConnection";
    private int mDeviceId;
    private int mDisplayId;
    private int mFocusColor;
    private int mFocusStrokeWidth;
    private List<AccessibilityServiceInfo> mInstalledAndEnabledServices;
    private int mInteractiveTimeout;
    private int mNonInteractiveTimeout;

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void attachAccessibilityOverlayToDisplay(int r1, int r2, SurfaceControl r3, IAccessibilityInteractionConnectionCallback r4) {
        super.attachAccessibilityOverlayToDisplay(r1, r2, r3, r4);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void attachAccessibilityOverlayToWindow(int r1, int r2, SurfaceControl r3, IAccessibilityInteractionConnectionCallback r4) throws RemoteException {
        super.attachAccessibilityOverlayToWindow(r1, r2, r3, r4);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void bindInputLocked() {
        super.bindInputLocked();
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void bindLocked() {
        super.bindLocked();
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ boolean canReceiveEventsLocked() {
        return super.canReceiveEventsLocked();
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection
    public /* bridge */ /* synthetic */ boolean canRetrieveInteractiveWindowsLocked() {
        return super.canRetrieveInteractiveWindowsLocked();
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection, com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void connectBluetoothBrailleDisplay(String r1, IBrailleDisplayController r2) {
        super.connectBluetoothBrailleDisplay(r1, r2);
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection, com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void connectUsbBrailleDisplay(UsbDevice r1, IBrailleDisplayController r2) {
        super.connectUsbBrailleDisplay(r1, r2);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void createImeSessionLocked() {
        super.createImeSessionLocked();
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ String[] findAccessibilityNodeInfoByAccessibilityId(int r1, long r2, int r4, IAccessibilityInteractionConnectionCallback r5, int r6, long r7, Bundle r9) throws RemoteException {
        return super.findAccessibilityNodeInfoByAccessibilityId(r1, r2, r4, r5, r6, r7, r9);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ String[] findAccessibilityNodeInfosByText(int r1, long r2, String r4, int r5, IAccessibilityInteractionConnectionCallback r6, long r7) throws RemoteException {
        return super.findAccessibilityNodeInfosByText(r1, r2, r4, r5, r6, r7);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ String[] findAccessibilityNodeInfosByViewId(int r1, long r2, String r4, int r5, IAccessibilityInteractionConnectionCallback r6, long r7) throws RemoteException {
        return super.findAccessibilityNodeInfosByViewId(r1, r2, r4, r5, r6, r7);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ String[] findFocus(int r1, long r2, int r4, int r5, IAccessibilityInteractionConnectionCallback r6, long r7) throws RemoteException {
        return super.findFocus(r1, r2, r4, r5, r6, r7);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ String[] focusSearch(int r1, long r2, int r4, int r5, IAccessibilityInteractionConnectionCallback r6, long r7) throws RemoteException {
        return super.focusSearch(r1, r2, r4, r5, r6, r7);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ int getCapabilities() {
        return super.getCapabilities();
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ ComponentName getComponentName() {
        return super.getComponentName();
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ IBinder getOverlayWindowToken(int r1) {
        return super.getOverlayWindowToken(r1);
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection, com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ AccessibilityServiceInfo getServiceInfo() {
        return super.getServiceInfo();
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ AccessibilityWindowInfo getWindow(int r1) {
        return super.getWindow(r1);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ int getWindowIdForLeashToken(IBinder r1) {
        return super.getWindowIdForLeashToken(r1);
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection
    public /* bridge */ /* synthetic */ boolean isAccessibilityButtonAvailableLocked(AccessibilityUserState r1) {
        return super.isAccessibilityButtonAvailableLocked(r1);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ boolean isConnectedLocked() {
        return super.isConnectedLocked();
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ boolean isMultiFingerGesturesEnabled() {
        return super.isMultiFingerGesturesEnabled();
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ boolean isSendMotionEventsEnabled() {
        return super.isSendMotionEventsEnabled();
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ boolean isServiceDetectsGesturesEnabled(int r1) {
        return super.isServiceDetectsGesturesEnabled(r1);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ boolean isServiceHandlesDoubleTapEnabled() {
        return super.isServiceHandlesDoubleTapEnabled();
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ boolean isTwoFingerPassthroughEnabled() {
        return super.isTwoFingerPassthroughEnabled();
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void logTrace(long r1, String r3, long r4, String r6, int r7, long r8, int r10, Bundle r11) {
        super.logTrace(r1, r3, r4, r6, r7, r8, r10, r11);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void notifyAccessibilityButtonAvailabilityChangedLocked(boolean r1) {
        super.notifyAccessibilityButtonAvailabilityChangedLocked(r1);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void notifyAccessibilityButtonClickedLocked(int r1) {
        super.notifyAccessibilityButtonClickedLocked(r1);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void notifyAccessibilityEvent(AccessibilityEvent r1) {
        super.notifyAccessibilityEvent(r1);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void notifyClearAccessibilityNodeInfoCache() {
        super.notifyClearAccessibilityNodeInfoCache();
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void notifyGesture(AccessibilityGestureEvent r1) {
        super.notifyGesture(r1);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void notifyMagnificationChangedLocked(int r1, Region r2, MagnificationConfig r3) {
        super.notifyMagnificationChangedLocked(r1, r2, r3);
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void notifyMotionEvent(MotionEvent r1) {
        super.notifyMotionEvent(r1);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void notifySoftKeyboardShowModeChangedLocked(int r1) {
        super.notifySoftKeyboardShowModeChangedLocked(r1);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void notifySystemActionsChangedLocked() {
        super.notifySystemActionsChangedLocked();
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void notifyTouchState(int r1, int r2) {
        super.notifyTouchState(r1, r2);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void onDisplayRemoved(int r1) {
        super.onDisplayRemoved(r1);
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection, android.content.ServiceConnection
    public /* bridge */ /* synthetic */ void onNullBinding(ComponentName r1) {
        super.onNullBinding(r1);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void onRemoved() {
        super.onRemoved();
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ boolean performAccessibilityAction(int r1, long r2, int r4, Bundle r5, int r6, IAccessibilityInteractionConnectionCallback r7, long r8) throws RemoteException {
        return super.performAccessibilityAction(r1, r2, r4, r5, r6, r7, r8);
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection
    public /* bridge */ /* synthetic */ boolean requestImeApis() {
        return super.requestImeApis();
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection, com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void resetLocked() {
        super.resetLocked();
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void setAttributionTag(String r1) {
        super.setAttributionTag(r1);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void setCacheEnabled(boolean r1) {
        super.setCacheEnabled(r1);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void setDynamicallyConfigurableProperties(AccessibilityServiceInfo r1) {
        super.setDynamicallyConfigurableProperties(r1);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void setImeSessionEnabledLocked(IAccessibilityInputMethodSession r1, boolean r2) {
        super.setImeSessionEnabledLocked(r1, r2);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void setMinumumIntervalObric(String r1, int r2, int r3) {
        super.setMinumumIntervalObric(r1, r2, r3);
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection, com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void setTestBrailleDisplayData(List r1) {
        super.setTestBrailleDisplayData(r1);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void startInputLocked(IRemoteAccessibilityInputConnection r1, EditorInfo r2, boolean r3) {
        super.startInputLocked(r1, r2, r3);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void takeScreenshotOfWindow(int r1, int r2, ScreenCapture.ScreenCaptureListener r3, IAccessibilityInteractionConnectionCallback r4) throws RemoteException {
        super.takeScreenshotOfWindow(r1, r2, r3, r4);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void unbindInputLocked() {
        super.unbindInputLocked();
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection
    public /* bridge */ /* synthetic */ void unbindLocked() {
        super.unbindLocked();
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public /* bridge */ /* synthetic */ boolean wantsGenericMotionEvent(MotionEvent r1) {
        return super.wantsGenericMotionEvent(r1);
    }

    ProxyAccessibilityServiceConnection(Context context, ComponentName componentName, AccessibilityServiceInfo accessibilityServiceInfo, int id, Handler mainHandler, Object lock, AccessibilitySecurityPolicy securityPolicy, AbstractAccessibilityServiceConnection.SystemSupport systemSupport, AccessibilityTrace trace, WindowManagerInternal windowManagerInternal, AccessibilityWindowManager awm, int displayId, int deviceId) {
        super(null, context, componentName, accessibilityServiceInfo, id, mainHandler, lock, securityPolicy, systemSupport, trace, windowManagerInternal, null, awm, null);
        this.mDisplayId = displayId;
        setDisplayTypes(2);
        this.mFocusStrokeWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.accessibility_focus_highlight_stroke_width);
        this.mFocusColor = this.mContext.getResources().getColor(R.color.accessibility_magnification_thumbnail_background_color);
        this.mDeviceId = deviceId;
    }

    int getDisplayId() {
        return this.mDisplayId;
    }

    int getDeviceId() {
        return this.mDeviceId;
    }

    void initializeClient(IAccessibilityServiceClient client) throws RemoteException {
        this.mClient = client;
        this.mClientBinder = client.asBinder();
        this.mClient.init(this, this.mId, this.mOverlayWindowTokens.get(this.mDisplayId));
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void setInstalledAndEnabledServices(List<AccessibilityServiceInfo> infos) {
        long identity = Binder.clearCallingIdentity();
        Object r4 = this.mLock;     // Catch: Throwable -> L32
        monitor-enter(r4);     // Catch: Throwable -> L32
        this.mInstalledAndEnabledServices = infos;     // Catch: Throwable -> L16
        AccessibilityServiceInfo proxyInfo = this.mAccessibilityServiceInfo;     // Catch: Throwable -> L16
        proxyInfo.flags = 0;     // Catch: Throwable -> L16
        proxyInfo.eventTypes = 0;     // Catch: Throwable -> L16
        proxyInfo.notificationTimeout = 0;     // Catch: Throwable -> L16
        Set<String> packageNames = new HashSet();     // Catch: Throwable -> L16
        boolean hasNullPackagesNames = false;
        boolean isAccessibilityTool = false;
        int interactiveUiTimeout = 0;
        int nonInteractiveUiTimeout = 0;
        Iterator<AccessibilityServiceInfo> r12 = infos.iterator();     // Catch: Throwable -> L16
    L8:
        if (r12.hasNext() == false) goto L20;
        AccessibilityServiceInfo info = r12.next();     // Catch: Throwable -> L16
        isAccessibilityTool = isAccessibilityTool | info.isAccessibilityTool();     // Catch: Throwable -> L16
        if (info.packageNames == null) goto L18;
        if (info.packageNames.length == 0) goto L18;
        if (hasNullPackagesNames == true) goto L19;
        packageNames.addAll(Arrays.asList(info.packageNames));     // Catch: Throwable -> L16
    L19:
        interactiveUiTimeout = Math.max(interactiveUiTimeout, info.getInteractiveUiTimeoutMillis());     // Catch: Throwable -> L16
        nonInteractiveUiTimeout = Math.max(nonInteractiveUiTimeout, info.getNonInteractiveUiTimeoutMillis());     // Catch: Throwable -> L16
        proxyInfo.notificationTimeout = Math.max(proxyInfo.notificationTimeout, info.notificationTimeout);     // Catch: Throwable -> L16
        proxyInfo.eventTypes |= info.eventTypes;     // Catch: Throwable -> L16
        proxyInfo.feedbackType |= info.feedbackType;     // Catch: Throwable -> L16
        proxyInfo.flags |= info.flags;     // Catch: Throwable -> L16
        setDefaultPropertiesIfNullLocked(info);     // Catch: Throwable -> L16
        packageNames = packageNames;
    L18:
        hasNullPackagesNames = true;
        goto L19
    L20:
        Set<String> packageNames2 = packageNames;
        proxyInfo.setAccessibilityTool(isAccessibilityTool);     // Catch: Throwable -> L16
        proxyInfo.setInteractiveUiTimeoutMillis(interactiveUiTimeout);     // Catch: Throwable -> L16
        proxyInfo.setNonInteractiveUiTimeoutMillis(nonInteractiveUiTimeout);     // Catch: Throwable -> L16
        this.mInteractiveTimeout = interactiveUiTimeout;     // Catch: Throwable -> L16
        this.mNonInteractiveTimeout = nonInteractiveUiTimeout;     // Catch: Throwable -> L16
        if (hasNullPackagesNames == false) goto L23;
        proxyInfo.packageNames = null;     // Catch: Throwable -> L16
    L24:
        setDynamicallyConfigurableProperties(proxyInfo);     // Catch: Throwable -> L16
        this.mSystemSupport.onProxyChanged(this.mDeviceId);     // Catch: Throwable -> L16
        monitor-exit(r4);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(identity);
        return;
    L23:
        proxyInfo.packageNames = (String[]) packageNames2.toArray(new String[0]);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = th;
    L34:
        Binder.restoreCallingIdentity(identity);
        throw th;
    L32:
        th = th;
        goto L34
    }

    private void setDefaultPropertiesIfNullLocked(AccessibilityServiceInfo info) {
        String componentClassDisplayName = "ProxyClass" + this.mDisplayId;
        if (info.getResolveInfo() != null) goto L6;
        ResolveInfo resolveInfo = new ResolveInfo();
        ServiceInfo serviceInfo = new ServiceInfo();
        ApplicationInfo applicationInfo = new ApplicationInfo();
        serviceInfo.packageName = "ProxyPackage";
        serviceInfo.name = componentClassDisplayName;
        applicationInfo.processName = "ProxyPackage";
        applicationInfo.className = componentClassDisplayName;
        resolveInfo.serviceInfo = serviceInfo;
        serviceInfo.applicationInfo = applicationInfo;
        info.setResolveInfo(resolveInfo);
    L6:
        if (info.getComponentName() != null) goto L9;
        info.setComponentName(new ComponentName("ProxyPackage", componentClassDisplayName));
        return;
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public List<AccessibilityServiceInfo> getInstalledAndEnabledServices() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mInstalledAndEnabledServices == null) goto L9;
        List<AccessibilityServiceInfo> r1 = this.mInstalledAndEnabledServices;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L9:
        r1 = Collections.emptyList();     // Catch: Throwable -> L7
        goto L10
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public AccessibilityWindowInfo.WindowListSparseArray getWindows() {
        AccessibilityWindowInfo.WindowListSparseArray allWindows = super.getWindows();
        AccessibilityWindowInfo.WindowListSparseArray displayWindows = new AccessibilityWindowInfo.WindowListSparseArray();
        displayWindows.put(this.mDisplayId, (List) allWindows.get(this.mDisplayId, Collections.emptyList()));
        return displayWindows;
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection, com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void setFocusAppearance(int strokeWidth, int color) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (hasRightsToCurrentUserLocked() == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mSecurityPolicy.checkAccessibilityAccess(this) == true) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        if (getFocusStrokeWidthLocked() == strokeWidth) goto L17;
    L20:
        this.mFocusStrokeWidth = strokeWidth;     // Catch: Throwable -> L8
        this.mFocusColor = color;     // Catch: Throwable -> L8
        this.mSystemSupport.onProxyChanged(this.mDeviceId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L17:
        if (getFocusColorLocked() != color) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public int getFocusStrokeWidthLocked() {
        return this.mFocusStrokeWidth;
    }

    public int getFocusColorLocked() {
        return this.mFocusColor;
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    int resolveAccessibilityWindowIdForFindFocusLocked(int windowId, int focusType) {
        if (windowId != (-2)) goto L9;
        int focusedWindowId = this.mA11yWindowManager.getFocusedWindowId(focusType, this.mDisplayId);
        if (this.mA11yWindowManager.windowIdBelongsToDisplayType(focusedWindowId, this.mDisplayTypes) == true) goto L8;
        return -1;
    L8:
        return focusedWindowId;
    L9:
        return windowId;
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection, android.os.IBinder.DeathRecipient
    public void binderDied() {
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    protected boolean supportsFlagForNotImportantViews(AccessibilityServiceInfo info) {
        return true;
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection, com.android.server.accessibility.AbstractAccessibilityServiceConnection
    protected boolean hasRightsToCurrentUserLocked() {
        return true;
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection, com.android.server.accessibility.KeyEventDispatcher.KeyEventFilter
    public boolean onKeyEvent(KeyEvent keyEvent, int sequenceNumber) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("onKeyEvent is not supported");
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection, com.android.server.accessibility.FingerprintGestureDispatcher.FingerprintGestureClient
    public boolean isCapturingFingerprintGestures() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("isCapturingFingerprintGestures is not supported");
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection, com.android.server.accessibility.FingerprintGestureDispatcher.FingerprintGestureClient
    public void onFingerprintGestureDetectionActiveChanged(boolean active) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("onFingerprintGestureDetectionActiveChanged is not supported");
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection, com.android.server.accessibility.FingerprintGestureDispatcher.FingerprintGestureClient
    public void onFingerprintGesture(int gesture) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("onFingerprintGesture is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public boolean isFingerprintGestureDetectionAvailable() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("isFingerprintGestureDetectionAvailable is not supported");
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection, android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("onServiceConnected is not supported");
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection, android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("onServiceDisconnected is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void setServiceInfo(AccessibilityServiceInfo info) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setServiceInfo is not supported");
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection
    public void disableSelf() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("disableSelf is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public boolean performGlobalAction(int action) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("performGlobalAction is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void setOnKeyEventResult(boolean handled, int sequence) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setOnKeyEventResult is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public List<AccessibilityNodeInfo.AccessibilityAction> getSystemActions() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("getSystemActions is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public MagnificationConfig getMagnificationConfig(int displayId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("getMagnificationConfig is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public float getMagnificationScale(int displayId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("getMagnificationScale is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public float getMagnificationCenterX(int displayId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("getMagnificationCenterX is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public float getMagnificationCenterY(int displayId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("getMagnificationCenterY is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public Region getMagnificationRegion(int displayId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("getMagnificationRegion is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public Region getCurrentMagnificationRegion(int displayId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("getCurrentMagnificationRegion is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public boolean resetMagnification(int displayId, boolean animate) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("resetMagnification is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public boolean resetCurrentMagnification(int displayId, boolean animate) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("resetCurrentMagnification is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public boolean setMagnificationConfig(int displayId, MagnificationConfig config, boolean animate) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setMagnificationConfig is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void setMagnificationCallbackEnabled(int displayId, boolean enabled) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setMagnificationCallbackEnabled is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public boolean isMagnificationCallbackEnabled(int displayId) {
        throw new UnsupportedOperationException("isMagnificationCallbackEnabled is not supported");
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection
    public boolean setSoftKeyboardShowMode(int showMode) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setSoftKeyboardShowMode is not supported");
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection
    public int getSoftKeyboardShowMode() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("getSoftKeyboardShowMode is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void setSoftKeyboardCallbackEnabled(boolean enabled) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setSoftKeyboardCallbackEnabled is not supported");
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection
    public boolean switchToInputMethod(String imeId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("switchToInputMethod is not supported");
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection
    public int setInputMethodEnabled(String imeId, boolean enabled) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setInputMethodEnabled is not supported");
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection
    public boolean isAccessibilityButtonAvailable() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("isAccessibilityButtonAvailable is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void sendGesture(int sequence, ParceledListSlice gestureSteps) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("sendGesture is not supported");
    }

    @Override // com.android.server.accessibility.AccessibilityServiceConnection, com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void dispatchGesture(int sequence, ParceledListSlice gestureSteps, int displayId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("dispatchGesture is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void takeScreenshot(int displayId, RemoteCallback callback) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("takeScreenshot is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void setGestureDetectionPassthroughRegion(int displayId, Region region) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setGestureDetectionPassthroughRegion is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void setTouchExplorationPassthroughRegion(int displayId, Region region) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setTouchExplorationPassthroughRegion is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void setServiceDetectsGesturesEnabled(int displayId, boolean mode) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setServiceDetectsGesturesEnabled is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void requestTouchExploration(int displayId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("requestTouchExploration is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void requestDragging(int displayId, int pointerId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("requestDragging is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void requestDelegating(int displayId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("requestDelegating is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void onDoubleTap(int displayId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("onDoubleTap is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void onDoubleTapAndHold(int displayId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("onDoubleTapAndHold is not supported");
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void setAnimationScale(float scale) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setAnimationScale is not supported");
    }

    public int getInteractiveTimeout() {
        return this.mInteractiveTimeout;
    }

    public int getNonInteractiveTimeout() {
        return this.mNonInteractiveTimeout;
    }

    public boolean updateTimeouts(int nonInteractiveUiTimeout, int interactiveUiTimeout) {
        if (interactiveUiTimeout == 0) goto L4;
        int newInteractiveUiTimeout = interactiveUiTimeout;
    L6:
        if (nonInteractiveUiTimeout == 0) goto L8;
        int newNonInteractiveUiTimeout = nonInteractiveUiTimeout;
    L9:
        boolean updated = false;
        if (this.mInteractiveTimeout == newInteractiveUiTimeout) goto L13;
        this.mInteractiveTimeout = newInteractiveUiTimeout;
        updated = true;
    L13:
        if (this.mNonInteractiveTimeout == newNonInteractiveUiTimeout) goto L16;
        this.mNonInteractiveTimeout = newNonInteractiveUiTimeout;
        return true;
    L16:
        return updated;
    L8:
        newNonInteractiveUiTimeout = this.mAccessibilityServiceInfo.getNonInteractiveUiTimeoutMillis();
        goto L9
    L4:
        newInteractiveUiTimeout = this.mAccessibilityServiceInfo.getInteractiveUiTimeoutMillis();
        goto L6
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection
    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, LOG_TAG, pw) == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.append("Proxy[displayId=" + this.mDisplayId);     // Catch: Throwable -> L10
        pw.append(", deviceId=" + this.mDeviceId);     // Catch: Throwable -> L10
        pw.append(", feedbackType" + AccessibilityServiceInfo.feedbackTypeToString(this.mFeedbackType));     // Catch: Throwable -> L10
        pw.append(", capabilities=" + this.mAccessibilityServiceInfo.getCapabilities());     // Catch: Throwable -> L10
        pw.append(", eventTypes=" + AccessibilityEvent.eventTypeToString(this.mEventTypes));     // Catch: Throwable -> L10
        pw.append(", notificationTimeout=" + this.mNotificationTimeout);     // Catch: Throwable -> L10
        pw.append(", nonInteractiveUiTimeout=").append(String.valueOf(this.mNonInteractiveTimeout));     // Catch: Throwable -> L10
        pw.append(", interactiveUiTimeout=").append(String.valueOf(this.mInteractiveTimeout));     // Catch: Throwable -> L10
        pw.append(", focusStrokeWidth=").append(String.valueOf(this.mFocusStrokeWidth));     // Catch: Throwable -> L10
        pw.append(", focusColor=").append(String.valueOf(this.mFocusColor));     // Catch: Throwable -> L10
        pw.append(", installedAndEnabledServiceCount=").append(String.valueOf(this.mInstalledAndEnabledServices.size()));     // Catch: Throwable -> L10
        pw.append(", installedAndEnabledServices=").append(this.mInstalledAndEnabledServices.toString());     // Catch: Throwable -> L10
        pw.append("]");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
