package com.android.server.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.AccessibilityTrace;
import android.accessibilityservice.IAccessibilityServiceClient;
import android.companion.virtual.VirtualDevice;
import android.companion.virtual.VirtualDeviceManager;
import android.content.ComponentName;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.IAccessibilityManagerClient;
import com.android.internal.util.FunctionalUtils;
import com.android.internal.util.IntPair;
import com.android.server.LocalServices;
import com.android.server.companion.virtual.VirtualDeviceManagerInternal;
import com.android.server.wm.WindowManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class ProxyManager {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "ProxyManager";
    static final String PROXY_COMPONENT_CLASS_NAME = "ProxyClass";
    static final String PROXY_COMPONENT_PACKAGE_NAME = "ProxyPackage";
    private AccessibilityInputFilter mA11yInputFilter;
    private final AccessibilityWindowManager mA11yWindowManager;
    private VirtualDeviceManagerInternal.AppsOnVirtualDeviceListener mAppsOnVirtualDeviceListener;
    private final Context mContext;
    private final SparseIntArray mLastStates;
    private VirtualDeviceManagerInternal mLocalVdm;
    private final Object mLock;
    private final Handler mMainHandler;
    private final SparseArray<ProxyAccessibilityServiceConnection> mProxyA11yServiceConnections;
    private final SystemSupport mSystemSupport;
    private final UiAutomationManager mUiAutomationManager;
    private VirtualDeviceManager.VirtualDeviceListener mVirtualDeviceListener;

    public interface SystemSupport {
        RemoteCallbackList<IAccessibilityManagerClient> getCurrentUserClientsLocked();

        RemoteCallbackList<IAccessibilityManagerClient> getGlobalClientsLocked();

        void notifyClearAccessibilityCacheLocked();

        void removeDeviceIdLocked(int r1);

        void updateWindowsForAccessibilityCallbackLocked();
    }

    /* JADX INFO: renamed from: $r8$lambda$-YJUChS1oHy7NC4DJUxfU_r--Ts, reason: not valid java name */
    public static /* synthetic */ void m726$r8$lambda$YJUChS1oHy7NC4DJUxfU_rTs(ProxyManager r0, int r1) {
        r0.lambda$updateStateForRemovedDisplay$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$1lqOab7Nsxaydn03fWD7PulcQ8E(ProxyManager r0, Set r1) {
        r0.lambda$registerProxy$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$7t1bypd8xupNzvNLsoCOrpH3-DM, reason: not valid java name */
    public static /* synthetic */ void m727$r8$lambda$7t1bypd8xupNzvNLsoCOrpH3DM(ProxyManager r0, int r1) {
        r0.lambda$scheduleNotifyProxyClientsOfServicesStateChangeLocked$8(r1);
    }

    public static /* synthetic */ void $r8$lambda$889ArYMZ4A7VqmA7gDZErnGOzJw(ProxyManager r0, int r1) {
        r0.lambda$registerProxy$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$D3T8BY1IWQiWaMOHlE-dHSE5Kwc, reason: not valid java name */
    public static /* synthetic */ void m728$r8$lambda$D3T8BY1IWQiWaMOHlEdHSE5Kwc(ProxyManager r0, ProxyAccessibilityServiceConnection r1) {
        r0.lambda$updateFocusAppearanceLocked$10(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$WtX_FcMis-DiuxtV8ANe_2vXP0Y, reason: not valid java name */
    public static /* synthetic */ void m729$r8$lambda$WtX_FcMisDiuxtV8ANe_2vXP0Y(ProxyManager r0, int r1, AccessibilityManagerService.Client r2) {
        r0.lambda$updateRelevantEventTypesLocked$3(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$dXip0VjKEz0EtlE9HBuYxOuiv2A(ProxyManager r0, int r1) {
        r0.lambda$updateRelevantEventTypesLocked$4(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$j-_bFVCm984sRUc0SVl1rlA6o50, reason: not valid java name */
    public static /* synthetic */ void m730$r8$lambda$j_bFVCm984sRUc0SVl1rlA6o50(ProxyManager r0, int r1, int r2) {
        r0.lambda$scheduleUpdateProxyClientsIfNeededLocked$6(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$qLIY1M0GW0dykNfyz9sTUpQ_dmo(ProxyManager r0, int r1, AccessibilityManagerService.Client r2) {
        r0.lambda$scheduleNotifyProxyClientsOfServicesStateChangeLocked$7(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$yRJ56K5_K30I4mT4WBNIgvQ3VMg(int r0, int r1, AccessibilityManagerService.Client r2) {
        lambda$scheduleUpdateProxyClientsIfNeededLocked$5(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$z_mArRUv4PXeQkTo6ZTMR411tjU(ProxyAccessibilityServiceConnection r0, AccessibilityManagerService.Client r1) {
        lambda$updateFocusAppearanceLocked$9(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mclearConnectionAndUpdateState, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m731$$Nest$mclearConnectionAndUpdateState(ProxyManager r0, int r1) {
        return r0.clearConnectionAndUpdateState(r1);
    }

    static {
        if (Log.isLoggable(LOG_TAG, 3) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        DEBUG = r0;
        return;
    L5:
        if (Build.IS_DEBUGGABLE == false) goto L7;
        r0 = true;
        goto L8
    }

    public ProxyManager(Object lock, AccessibilityWindowManager awm, Context context, Handler mainHandler, UiAutomationManager uiAutomationManager, SystemSupport systemSupport) {
        this.mLastStates = new SparseIntArray();
        this.mProxyA11yServiceConnections = new SparseArray();
        this.mLock = lock;
        this.mA11yWindowManager = awm;
        this.mContext = context;
        this.mMainHandler = mainHandler;
        this.mUiAutomationManager = uiAutomationManager;
        this.mSystemSupport = systemSupport;
        this.mLocalVdm = (VirtualDeviceManagerInternal) LocalServices.getService(VirtualDeviceManagerInternal.class);
    }

    public void registerProxy(final IAccessibilityServiceClient client, final int displayId, int id, AccessibilitySecurityPolicy securityPolicy, AbstractAccessibilityServiceConnection.SystemSupport systemSupport, AccessibilityTrace trace, WindowManagerInternal windowManagerInternal) throws RemoteException {
        if (DEBUG == false) goto L5;
        Slog.v(LOG_TAG, "Register proxy for display id: " + displayId);
    L5:
        VirtualDeviceManager vdm = (VirtualDeviceManager) this.mContext.getSystemService(VirtualDeviceManager.class);
        if (vdm != null) goto L8;
        return;
    L8:
        int deviceId = vdm.getDeviceIdForDisplayId(displayId);
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.setCapabilities(3);
        String componentClassDisplayName = PROXY_COMPONENT_CLASS_NAME + displayId;
        info.setComponentName(new ComponentName(PROXY_COMPONENT_PACKAGE_NAME, componentClassDisplayName));
        ProxyAccessibilityServiceConnection connection = new ProxyAccessibilityServiceConnection(this.mContext, info.getComponentName(), info, id, this.mMainHandler, this.mLock, securityPolicy, systemSupport, trace, windowManagerInternal, this.mA11yWindowManager, displayId, deviceId);
        Object r4 = this.mLock;
        monitor-enter(r4);
        this.mProxyA11yServiceConnections.put(displayId, connection);     // Catch: Throwable -> L15
        if (this.mAppsOnVirtualDeviceListener != null) goto L18;
        this.mAppsOnVirtualDeviceListener = new ProxyManager$$ExternalSyntheticLambda2(this);     // Catch: Throwable -> L15
        VirtualDeviceManagerInternal localVdm = getLocalVdm();     // Catch: Throwable -> L15
        if (localVdm == null) goto L18;
        localVdm.registerAppsOnVirtualDeviceListener(this.mAppsOnVirtualDeviceListener);     // Catch: Throwable -> L15
    L18:
        if (this.mProxyA11yServiceConnections.size() != 1) goto L20;
        registerVirtualDeviceListener();     // Catch: Throwable -> L15
    L20:
        monitor-exit(r4);     // Catch: Throwable -> L15
        IBinder.DeathRecipient deathRecipient = new AnonymousClass1(this, client, displayId);
        client.asBinder().linkToDeath(deathRecipient, 0);
        this.mMainHandler.post(new ProxyManager$$ExternalSyntheticLambda3(this, displayId));
        connection.initializeClient(client);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$registerProxy$0(Set allRunningUids) {
        notifyProxyOfRunningAppsChange(allRunningUids);
    }

    private /* synthetic */ void lambda$registerProxy$1(int displayId) {
        if (this.mA11yInputFilter == null) goto L6;
        this.mA11yInputFilter.disableFeaturesForDisplayIfInstalled(displayId);
        return;
    }

    private void registerVirtualDeviceListener() {
        VirtualDeviceManager vdm = (VirtualDeviceManager) this.mContext.getSystemService(VirtualDeviceManager.class);
        if (vdm != null) goto L6;
        return;
    L6:
        if (this.mVirtualDeviceListener != null) goto L8;
        this.mVirtualDeviceListener = new AnonymousClass2(this);
    L8:
        vdm.registerVirtualDeviceListener(this.mContext.getMainExecutor(), this.mVirtualDeviceListener);
    }

    private void unregisterVirtualDeviceListener() {
        VirtualDeviceManager vdm = (VirtualDeviceManager) this.mContext.getSystemService(VirtualDeviceManager.class);
        if (vdm != null) goto L5;
        return;
    L5:
        vdm.unregisterVirtualDeviceListener(this.mVirtualDeviceListener);
    }

    public boolean unregisterProxy(int displayId) {
        return clearConnectionAndUpdateState(displayId);
    }

    public void clearConnections(int deviceId) {
        IntArray displaysToClear = new IntArray();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int i = 0;
    L25:
    L12:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mProxyA11yServiceConnections.size()) goto L16;
        ProxyAccessibilityServiceConnection proxy = this.mProxyA11yServiceConnections.valueAt(i);     // Catch: Throwable -> L12
        if (proxy == null) goto L14;
        if (proxy.getDeviceId() != deviceId) goto L14;
        displaysToClear.add(proxy.getDisplayId());     // Catch: Throwable -> L12
    L14:
        i = i + 1;     // Catch: Throwable -> L12
        goto L25
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L12
        int i2 = 0;
    L19:
        if (i2 >= displaysToClear.size()) goto L22;
        clearConnectionAndUpdateState(displaysToClear.get(i2));
        i2 = i2 + 1;
        goto L19
    }

    private boolean clearConnectionAndUpdateState(int displayId) {
        boolean removedFromConnections = false;
        int deviceId = -1;
        Object r2 = this.mLock;
        monitor-enter(r2);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mProxyA11yServiceConnections.contains(displayId) == false) goto L11;
        deviceId = this.mProxyA11yServiceConnections.get(displayId).getDeviceId();     // Catch: Throwable -> L9
        this.mProxyA11yServiceConnections.remove(displayId);     // Catch: Throwable -> L9
        removedFromConnections = true;
        if (this.mProxyA11yServiceConnections.size() != 0) goto L11;
        unregisterVirtualDeviceListener();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L9
        if (removedFromConnections == false) goto L15;
        updateStateForRemovedDisplay(displayId, deviceId);
    L15:
        if (DEBUG == false) goto L17;
        Slog.v(LOG_TAG, "Unregistered proxy for display id " + displayId + ": " + removedFromConnections);
    L17:
        return removedFromConnections;
    }

    private void updateStateForRemovedDisplay(final int displayId, int deviceId) {
        this.mA11yWindowManager.stopTrackingDisplayProxy(displayId);
        this.mMainHandler.post(new ProxyManager$$ExternalSyntheticLambda6(this, displayId));
        if (isProxyedDeviceId(deviceId) == true) goto L20;
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mProxyA11yServiceConnections.size() != 0) goto L15;
        VirtualDeviceManagerInternal localVdm = getLocalVdm();     // Catch: Throwable -> L13
        if (localVdm == null) goto L15;
        if (this.mAppsOnVirtualDeviceListener == null) goto L15;
        localVdm.unregisterAppsOnVirtualDeviceListener(this.mAppsOnVirtualDeviceListener);     // Catch: Throwable -> L13
        this.mAppsOnVirtualDeviceListener = null;     // Catch: Throwable -> L13
    L15:
        this.mSystemSupport.removeDeviceIdLocked(deviceId);     // Catch: Throwable -> L13
        this.mLastStates.delete(deviceId);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L20:
        onProxyChanged(deviceId);
    }

    private /* synthetic */ void lambda$updateStateForRemovedDisplay$2(int displayId) {
        if (this.mA11yInputFilter == null) goto L8;
        DisplayManager displayManager = (DisplayManager) this.mContext.getSystemService("display");
        Display proxyDisplay = displayManager.getDisplay(displayId);
        if (proxyDisplay == null) goto L9;
        this.mA11yInputFilter.enableFeaturesForDisplayIfInstalled(proxyDisplay);
        return;
    L9:
        return;
    }

    public boolean isProxyedDisplay(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean tracked = this.mProxyA11yServiceConnections.contains(displayId);     // Catch: Throwable -> L7
        if (DEBUG == false) goto L9;
        Slog.v(LOG_TAG, "Tracking proxy display " + displayId + " : " + tracked);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return tracked;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isProxyedDeviceId(int deviceId) {
        boolean isTrackingDeviceId = false;
        if (deviceId != 0) goto L5;
    L20:
        return false;
    L5:
        if (deviceId == (-1)) goto L20;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (getFirstProxyForDeviceIdLocked(deviceId) == null) goto L12;
        isTrackingDeviceId = true;
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L17
        if (DEBUG == false) goto L16;
        Slog.v(LOG_TAG, "Tracking device " + deviceId + " : " + isTrackingDeviceId);
    L16:
        return isTrackingDeviceId;
    }

    public boolean displayBelongsToCaller(int callingUid, int proxyDisplayId) {
        VirtualDeviceManager vdm = (VirtualDeviceManager) this.mContext.getSystemService(VirtualDeviceManager.class);
        VirtualDeviceManagerInternal localVdm = getLocalVdm();
        if (vdm == null) goto L17;
        if (localVdm == null) goto L17;
        List<VirtualDevice> virtualDevices = vdm.getVirtualDevices();
        Iterator<VirtualDevice> r4 = virtualDevices.iterator();
    L8:
        if (r4.hasNext() == false) goto L16;
        VirtualDevice device = r4.next();
        if (localVdm.getDisplayIdsForDevice(device.getDeviceId()).contains(Integer.valueOf(proxyDisplayId)) == false) goto L8;
        int ownerUid = localVdm.getDeviceOwnerUid(device.getDeviceId());
        if (callingUid != ownerUid) goto L8;
        return true;
    L16:
        return false;
    L17:
        return false;
    }

    public void sendAccessibilityEventLocked(AccessibilityEvent event) {
        ProxyAccessibilityServiceConnection proxy = this.mProxyA11yServiceConnections.get(event.getDisplayId());
        if (proxy != null) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.v(LOG_TAG, "Send proxy event " + event + " for display id " + event.getDisplayId());
    L7:
        proxy.notifyAccessibilityEvent(event);
    }

    public boolean canRetrieveInteractiveWindowsLocked() {
        boolean observingWindows = false;
        int i = 0;
    L4:
        if (i >= this.mProxyA11yServiceConnections.size()) goto L10;
        ProxyAccessibilityServiceConnection proxy = this.mProxyA11yServiceConnections.valueAt(i);
        if (proxy.mRetrieveInteractiveWindows == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        observingWindows = true;
    L10:
        if (DEBUG == false) goto L12;
        Slog.v(LOG_TAG, "At least one proxy can retrieve windows: " + observingWindows);
    L12:
        return observingWindows;
    }

    public int getStateLocked(int deviceId) {
        int clientState = 0;
        boolean uiAutomationCanIntrospect = this.mUiAutomationManager.canIntrospect();
        if (uiAutomationCanIntrospect == false) goto L5;
        clientState = 0 | 1;
    L5:
        int i = 0;
    L7:
        if (i >= this.mProxyA11yServiceConnections.size()) goto L15;
        ProxyAccessibilityServiceConnection proxy = this.mProxyA11yServiceConnections.valueAt(i);
        if (proxy == null) goto L13;
        if (proxy.getDeviceId() != deviceId) goto L13;
        clientState = clientState | getStateForDisplayIdLocked(proxy);
    L13:
        i = i + 1;
        goto L7
    L15:
        if (DEBUG == false) goto L24;
        StringBuilder r2 = new StringBuilder();
        r2.append("For device id ");
        r2.append(deviceId);
        r2.append(" a11y is enabled: ");
        boolean r5 = false;
        if ((clientState & 1) == 0) goto L19;
        boolean r4 = true;
    L20:
        r2.append(r4);
        Slog.v(LOG_TAG, r2.toString());
        StringBuilder r3 = new StringBuilder();
        r3.append("For device id ");
        r3.append(deviceId);
        r3.append(" touch exploration is enabled: ");
        if ((clientState & 2) == 0) goto L23;
        r5 = true;
    L23:
        r3.append(r5);
        Slog.v(LOG_TAG, r3.toString());
        goto L24
    L19:
        r4 = false;
    L24:
        return clientState;
    }

    private int getStateForDisplayIdLocked(ProxyAccessibilityServiceConnection proxy) {
        int clientState = 0;
        if (proxy == null) goto L8;
        clientState = 0 | 1;
        if (proxy.mRequestTouchExplorationMode == false) goto L8;
        clientState = clientState | 2;
    L8:
        if (DEBUG == false) goto L17;
        StringBuilder r1 = new StringBuilder();
        r1.append("Accessibility is enabled for all proxies: ");
        boolean r3 = false;
        if ((clientState & 1) == 0) goto L12;
        boolean r2 = true;
    L13:
        r1.append(r2);
        Slog.v(LOG_TAG, r1.toString());
        StringBuilder r4 = new StringBuilder();
        r4.append("Touch exploration is enabled for all proxies: ");
        if ((clientState & 2) == 0) goto L16;
        r3 = true;
    L16:
        r4.append(r3);
        Slog.v(LOG_TAG, r4.toString());
        goto L17
    L12:
        r2 = false;
    L17:
        return clientState;
    }

    private int getLastSentStateLocked(int deviceId) {
        return this.mLastStates.get(deviceId, 0);
    }

    private void setLastStateLocked(int deviceId, int proxyState) {
        this.mLastStates.put(deviceId, proxyState);
    }

    private void updateRelevantEventTypesLocked(final int deviceId) {
        if (isProxyedDeviceId(deviceId) == true) goto L5;
        return;
    L5:
        this.mMainHandler.post(new ProxyManager$$ExternalSyntheticLambda5(this, deviceId));
    }

    private /* synthetic */ void lambda$updateRelevantEventTypesLocked$4(final int deviceId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        broadcastToClientsLocked(FunctionalUtils.ignoreRemoteException(new ProxyManager$$ExternalSyntheticLambda8(this, deviceId)));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$updateRelevantEventTypesLocked$3(int deviceId, AccessibilityManagerService.Client client) throws RemoteException {
        if (client.mDeviceId != deviceId) goto L8;
        int relevantEventTypes = computeRelevantEventTypesLocked(client);
        if (client.mLastSentRelevantEventTypes == relevantEventTypes) goto L9;
        client.mLastSentRelevantEventTypes = relevantEventTypes;
        client.mCallback.setRelevantEventTypes(relevantEventTypes);
        return;
    L9:
        return;
    }

    public int computeRelevantEventTypesLocked(AccessibilityManagerService.Client client) {
        int relevantEventTypes = 0;
        int i = 0;
    L4:
        if (i >= this.mProxyA11yServiceConnections.size()) goto L16;
        ProxyAccessibilityServiceConnection proxy = this.mProxyA11yServiceConnections.valueAt(i);
        if (proxy == null) goto L14;
        if (proxy.getDeviceId() != client.mDeviceId) goto L14;
        int relevantEventTypes2 = relevantEventTypes | proxy.getRelevantEventTypes();
        if (AccessibilityManagerService.isClientInPackageAllowlist(this.mUiAutomationManager.getServiceInfo(), client) == false) goto L12;
        int r3 = this.mUiAutomationManager.getRelevantEventTypes();
    L13:
        relevantEventTypes = relevantEventTypes2 | r3;
        goto L14
    L12:
        r3 = 0;
    L14:
        i = i + 1;
        goto L4
    L16:
        if (DEBUG == false) goto L18;
        Slog.v(LOG_TAG, "Relevant event types for device id " + client.mDeviceId + ": " + AccessibilityEvent.eventTypeToString(relevantEventTypes));
    L18:
        return relevantEventTypes;
    }

    public void addServiceInterfacesLocked(List<IAccessibilityServiceClient> interfaces, int deviceId) {
        int i = 0;
    L4:
        if (i >= this.mProxyA11yServiceConnections.size()) goto L15;
        ProxyAccessibilityServiceConnection proxy = this.mProxyA11yServiceConnections.valueAt(i);
        if (proxy == null) goto L13;
        if (proxy.getDeviceId() != deviceId) goto L13;
        IBinder proxyBinder = proxy.mClientBinder;
        IAccessibilityServiceClient proxyInterface = proxy.mClient;
        if (proxyBinder == null) goto L13;
        if (proxyInterface == null) goto L13;
        interfaces.add(proxyInterface);
    L13:
        i = i + 1;
        goto L4
    }

    public List<AccessibilityServiceInfo> getInstalledAndEnabledServiceInfosLocked(int feedbackType, int deviceId) {
        List<AccessibilityServiceInfo> serviceInfos = new ArrayList();
        int i = 0;
    L4:
        if (i >= this.mProxyA11yServiceConnections.size()) goto L23;
        ProxyAccessibilityServiceConnection proxy = this.mProxyA11yServiceConnections.valueAt(i);
        if (proxy == null) goto L21;
        if (proxy.getDeviceId() != deviceId) goto L21;
        if (feedbackType != (-1)) goto L13;
        serviceInfos.addAll(proxy.getInstalledAndEnabledServices());
        goto L21
    L13:
        if ((proxy.mFeedbackType & feedbackType) == 0) goto L21;
        List<AccessibilityServiceInfo> proxyInfos = proxy.getInstalledAndEnabledServices();
        Iterator<AccessibilityServiceInfo> r4 = proxyInfos.iterator();
    L16:
        if (r4.hasNext() == false) goto L21;
        AccessibilityServiceInfo info = r4.next();
        if ((info.feedbackType & feedbackType) == 0) goto L16;
        serviceInfos.add(info);
    L21:
        i = i + 1;
        goto L4
    L23:
        return serviceInfos;
    }

    private void onProxyChanged(int deviceId, boolean forceUpdate) {
        if (DEBUG == false) goto L5;
        Slog.v(LOG_TAG, "onProxyChanged called for deviceId: " + deviceId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        updateDeviceIdsIfNeededLocked(deviceId);     // Catch: Throwable -> L10
        this.mSystemSupport.updateWindowsForAccessibilityCallbackLocked();     // Catch: Throwable -> L10
        updateRelevantEventTypesLocked(deviceId);     // Catch: Throwable -> L10
        scheduleUpdateProxyClientsIfNeededLocked(deviceId, forceUpdate);     // Catch: Throwable -> L10
        scheduleNotifyProxyClientsOfServicesStateChangeLocked(deviceId);     // Catch: Throwable -> L10
        updateFocusAppearanceLocked(deviceId);     // Catch: Throwable -> L10
        this.mSystemSupport.notifyClearAccessibilityCacheLocked();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void onProxyChanged(int deviceId) {
        onProxyChanged(deviceId, false);
    }

    private void scheduleUpdateProxyClientsIfNeededLocked(final int deviceId, boolean forceUpdate) {
        final int proxyState = getStateLocked(deviceId);
        if (DEBUG == false) goto L6;
        Slog.v(LOG_TAG, "State for device id " + deviceId + " is " + proxyState);
        Slog.v(LOG_TAG, "Last state for device id " + deviceId + " is " + getLastSentStateLocked(deviceId));
        StringBuilder r1 = new StringBuilder();
        r1.append("force update: ");
        r1.append(forceUpdate);
        Slog.v(LOG_TAG, r1.toString());
    L6:
        if (getLastSentStateLocked(deviceId) != proxyState) goto L8;
        if (forceUpdate == true) goto L8;
        return;
    L8:
        setLastStateLocked(deviceId, proxyState);
        this.mMainHandler.post(new ProxyManager$$ExternalSyntheticLambda1(this, deviceId, proxyState));
    }

    private /* synthetic */ void lambda$scheduleUpdateProxyClientsIfNeededLocked$6(final int deviceId, final int proxyState) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        broadcastToClientsLocked(FunctionalUtils.ignoreRemoteException(new ProxyManager$$ExternalSyntheticLambda0(deviceId, proxyState)));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$scheduleUpdateProxyClientsIfNeededLocked$5(int deviceId, int proxyState, AccessibilityManagerService.Client client) throws RemoteException {
        if (client.mDeviceId != deviceId) goto L6;
        client.mCallback.setState(proxyState);
        return;
    }

    private void scheduleNotifyProxyClientsOfServicesStateChangeLocked(final int deviceId) {
        if (DEBUG == false) goto L5;
        Slog.v(LOG_TAG, "Notify services state change at device id " + deviceId);
    L5:
        this.mMainHandler.post(new ProxyManager$$ExternalSyntheticLambda4(this, deviceId));
    }

    private /* synthetic */ void lambda$scheduleNotifyProxyClientsOfServicesStateChangeLocked$8(final int deviceId) {
        broadcastToClientsLocked(FunctionalUtils.ignoreRemoteException(new ProxyManager$$ExternalSyntheticLambda7(this, deviceId)));
    }

    private /* synthetic */ void lambda$scheduleNotifyProxyClientsOfServicesStateChangeLocked$7(int deviceId, AccessibilityManagerService.Client client) throws RemoteException {
        if (client.mDeviceId != deviceId) goto L12;
        Object r0 = this.mLock;
        monitor-enter(r0);
        client.mCallback.notifyServicesStateChanged(getRecommendedTimeoutMillisLocked(deviceId));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void updateFocusAppearanceLocked(int deviceId) {
        if (DEBUG == false) goto L5;
        Slog.v(LOG_TAG, "Update proxy focus appearance at device id " + deviceId);
    L5:
        final ProxyAccessibilityServiceConnection proxy = getFirstProxyForDeviceIdLocked(deviceId);
        if (proxy == null) goto L9;
        this.mMainHandler.post(new ProxyManager$$ExternalSyntheticLambda9(this, proxy));
        return;
    }

    private /* synthetic */ void lambda$updateFocusAppearanceLocked$10(final ProxyAccessibilityServiceConnection proxy) {
        broadcastToClientsLocked(FunctionalUtils.ignoreRemoteException(new ProxyManager$$ExternalSyntheticLambda10(proxy)));
    }

    private static /* synthetic */ void lambda$updateFocusAppearanceLocked$9(ProxyAccessibilityServiceConnection proxy, AccessibilityManagerService.Client client) throws RemoteException {
        if (client.mDeviceId != proxy.getDeviceId()) goto L6;
        client.mCallback.setFocusAppearance(proxy.getFocusStrokeWidthLocked(), proxy.getFocusColorLocked());
        return;
    }

    private ProxyAccessibilityServiceConnection getFirstProxyForDeviceIdLocked(int deviceId) {
        int i = 0;
    L4:
        if (i >= this.mProxyA11yServiceConnections.size()) goto L11;
        ProxyAccessibilityServiceConnection proxy = this.mProxyA11yServiceConnections.valueAt(i);
        if (proxy == null) goto L10;
        if (proxy.getDeviceId() != deviceId) goto L10;
        return proxy;
    L10:
        i = i + 1;
        goto L4
    L11:
        return null;
    }

    private void broadcastToClientsLocked(Consumer<AccessibilityManagerService.Client> clientAction) {
        RemoteCallbackList<IAccessibilityManagerClient> userClients = this.mSystemSupport.getCurrentUserClientsLocked();
        RemoteCallbackList<IAccessibilityManagerClient> globalClients = this.mSystemSupport.getGlobalClientsLocked();
        userClients.broadcastForEachCookie(clientAction);
        globalClients.broadcastForEachCookie(clientAction);
    }

    public void updateTimeoutsIfNeeded(int nonInteractiveUiTimeout, int interactiveUiTimeout) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L20:
    L12:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mProxyA11yServiceConnections.size()) goto L16;
        ProxyAccessibilityServiceConnection proxy = this.mProxyA11yServiceConnections.valueAt(i);     // Catch: Throwable -> L12
        if (proxy == null) goto L14;
        if (proxy.updateTimeouts(nonInteractiveUiTimeout, interactiveUiTimeout) == false) goto L14;
        scheduleNotifyProxyClientsOfServicesStateChangeLocked(proxy.getDeviceId());     // Catch: Throwable -> L12
    L14:
        i = i + 1;     // Catch: Throwable -> L12
        goto L20
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public long getRecommendedTimeoutMillisLocked(int deviceId) {
        int combinedInteractiveTimeout = 0;
        int combinedNonInteractiveTimeout = 0;
        int i = 0;
    L4:
        if (i >= this.mProxyA11yServiceConnections.size()) goto L12;
        ProxyAccessibilityServiceConnection proxy = this.mProxyA11yServiceConnections.valueAt(i);
        if (proxy == null) goto L10;
        if (proxy.getDeviceId() != deviceId) goto L10;
        int proxyInteractiveUiTimeout = proxy.getInteractiveTimeout();
        int nonInteractiveUiTimeout = proxy.getNonInteractiveTimeout();
        combinedInteractiveTimeout = Math.max(proxyInteractiveUiTimeout, combinedInteractiveTimeout);
        combinedNonInteractiveTimeout = Math.max(nonInteractiveUiTimeout, combinedNonInteractiveTimeout);
    L10:
        i = i + 1;
        goto L4
    L12:
        return IntPair.of(combinedInteractiveTimeout, combinedNonInteractiveTimeout);
    }

    public int getFocusStrokeWidthLocked(int deviceId) {
        ProxyAccessibilityServiceConnection proxy = getFirstProxyForDeviceIdLocked(deviceId);
        if (proxy != null) goto L5;
        return 0;
    L5:
        return proxy.getFocusStrokeWidthLocked();
    }

    public int getFocusColorLocked(int deviceId) {
        ProxyAccessibilityServiceConnection proxy = getFirstProxyForDeviceIdLocked(deviceId);
        if (proxy != null) goto L5;
        return 0;
    L5:
        return proxy.getFocusColorLocked();
    }

    public int getFirstDeviceIdForUidLocked(int callingUid) {
        VirtualDeviceManagerInternal localVdm = getLocalVdm();
        if (localVdm != null) goto L5;
        return -1;
    L5:
        Set<Integer> deviceIds = localVdm.getDeviceIdsForUid(callingUid);
        Iterator<Integer> r3 = deviceIds.iterator();
    L7:
        if (r3.hasNext() == false) goto L21;
        Integer uidDeviceId = r3.next();
        if (uidDeviceId.intValue() == 0) goto L7;
        if (uidDeviceId.intValue() == (-1)) goto L7;
        int firstDeviceId = uidDeviceId.intValue();
        return firstDeviceId;
    L21:
        return -1;
    }

    private void updateDeviceIdsIfNeededLocked(int deviceId) {
        RemoteCallbackList<IAccessibilityManagerClient> userClients = this.mSystemSupport.getCurrentUserClientsLocked();
        RemoteCallbackList<IAccessibilityManagerClient> globalClients = this.mSystemSupport.getGlobalClientsLocked();
        updateDeviceIdsIfNeededLocked(deviceId, userClients);
        updateDeviceIdsIfNeededLocked(deviceId, globalClients);
    }

    private void updateDeviceIdsIfNeededLocked(int deviceId, RemoteCallbackList<IAccessibilityManagerClient> clients) {
        VirtualDeviceManagerInternal localVdm = getLocalVdm();
        if (localVdm != null) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= clients.getRegisteredCallbackCount()) goto L28;
        AccessibilityManagerService.Client client = (AccessibilityManagerService.Client) clients.getRegisteredCallbackCookie(i);
        if (deviceId == 0) goto L26;
        if (deviceId == (-1)) goto L26;
        boolean uidBelongsToDevice = localVdm.getDeviceIdsForUid(client.mUid).contains(Integer.valueOf(deviceId));
        if (client.mDeviceId == deviceId) goto L21;
        if (uidBelongsToDevice == false) goto L21;
        if (DEBUG == false) goto L19;
        Slog.v(LOG_TAG, "Packages moved to device id " + deviceId + " are " + Arrays.toString(client.mPackageNames));
    L19:
        client.mDeviceId = deviceId;
    L21:
        if (client.mDeviceId != deviceId) goto L26;
        if (uidBelongsToDevice == true) goto L26;
        client.mDeviceId = 0;
        if (DEBUG == false) goto L26;
        Slog.v(LOG_TAG, "Packages moved to the default device from device id " + deviceId + " are " + Arrays.toString(client.mPackageNames));
    L26:
        i = i + 1;
        goto L7
    }

    void notifyProxyOfRunningAppsChange(Set<Integer> allRunningUids) {
        if (DEBUG == false) goto L5;
        Slog.v(LOG_TAG, "notifyProxyOfRunningAppsChange: " + allRunningUids);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (this.mProxyA11yServiceConnections.size() != 0) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        VirtualDeviceManagerInternal localVdm = getLocalVdm();     // Catch: Throwable -> L11
        if (localVdm != null) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L17:
        ArraySet<Integer> deviceIdsToUpdate = new ArraySet();     // Catch: Throwable -> L11
        int i = 0;
    L19:
        if (i >= this.mProxyA11yServiceConnections.size()) goto L30;
        ProxyAccessibilityServiceConnection proxy = this.mProxyA11yServiceConnections.valueAt(i);     // Catch: Throwable -> L11
        if (proxy == null) goto L29;
        int proxyDeviceId = proxy.getDeviceId();     // Catch: Throwable -> L11
        Iterator<Integer> r6 = allRunningUids.iterator();     // Catch: Throwable -> L11
    L24:
        if (r6.hasNext() == false) goto L29;
        Integer uid = r6.next();     // Catch: Throwable -> L11
        if (localVdm.getDeviceIdsForUid(uid.intValue()).contains(Integer.valueOf(proxyDeviceId)) == false) goto L24;
        deviceIdsToUpdate.add(Integer.valueOf(proxyDeviceId));     // Catch: Throwable -> L11
    L29:
        i = i + 1;     // Catch: Throwable -> L11
        goto L19
    L30:
        Iterator<Integer> r3 = deviceIdsToUpdate.iterator();     // Catch: Throwable -> L11
    L32:
        if (r3.hasNext() == false) goto L34;
        onProxyChanged(r3.next().intValue(), true);     // Catch: Throwable -> L11
        goto L32
    L34:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void clearCacheLocked() {
        int i = 0;
    L4:
        if (i >= this.mProxyA11yServiceConnections.size()) goto L7;
        ProxyAccessibilityServiceConnection proxy = this.mProxyA11yServiceConnections.valueAt(i);
        proxy.notifyClearAccessibilityNodeInfoCache();
        i = i + 1;
        goto L4
    }

    public void setAccessibilityInputFilter(AccessibilityInputFilter filter) {
        if (DEBUG == false) goto L5;
        Slog.v(LOG_TAG, "Set proxy input filter to " + filter);
    L5:
        this.mA11yInputFilter = filter;
    }

    private VirtualDeviceManagerInternal getLocalVdm() {
        if (this.mLocalVdm != null) goto L6;
        this.mLocalVdm = (VirtualDeviceManagerInternal) LocalServices.getService(VirtualDeviceManagerInternal.class);
    L6:
        return this.mLocalVdm;
    }

    void setLocalVirtualDeviceManager(VirtualDeviceManagerInternal localVdm) {
        this.mLocalVdm = localVdm;
    }

    void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println();     // Catch: Throwable -> L10
        pw.println("Proxy manager state:");     // Catch: Throwable -> L10
        pw.println("    Number of proxy connections: " + this.mProxyA11yServiceConnections.size());     // Catch: Throwable -> L10
        pw.println("    Registered proxy connections:");     // Catch: Throwable -> L10
        RemoteCallbackList<IAccessibilityManagerClient> userClients = this.mSystemSupport.getCurrentUserClientsLocked();     // Catch: Throwable -> L10
        RemoteCallbackList<IAccessibilityManagerClient> globalClients = this.mSystemSupport.getGlobalClientsLocked();     // Catch: Throwable -> L10
        int i = 0;
    L6:
        if (i >= this.mProxyA11yServiceConnections.size()) goto L14;
        ProxyAccessibilityServiceConnection proxy = this.mProxyA11yServiceConnections.valueAt(i);     // Catch: Throwable -> L10
        if (proxy == null) goto L12;
        proxy.dump(fd, pw, args);     // Catch: Throwable -> L10
    L12:
        pw.println();     // Catch: Throwable -> L10
        pw.println("        User clients for proxy's virtual device id");     // Catch: Throwable -> L10
        printClientsForDeviceId(pw, userClients, proxy.getDeviceId());     // Catch: Throwable -> L10
        pw.println();     // Catch: Throwable -> L10
        pw.println("        Global clients for proxy's virtual device id");     // Catch: Throwable -> L10
        printClientsForDeviceId(pw, globalClients, proxy.getDeviceId());     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L6
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void printClientsForDeviceId(PrintWriter pw, RemoteCallbackList<IAccessibilityManagerClient> clients, int deviceId) {
        if (clients == null) goto L10;
        int j = 0;
    L5:
        if (j >= clients.getRegisteredCallbackCount()) goto L14;
        AccessibilityManagerService.Client client = (AccessibilityManagerService.Client) clients.getRegisteredCallbackCookie(j);
        if (client.mDeviceId != deviceId) goto L9;
        pw.println("            " + Arrays.toString(client.mPackageNames) + "\n");
    L9:
        j = j + 1;
        goto L5
    L14:
        return;
    }
}
