package com.android.server.media;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaRoute2Info;
import android.media.MediaRoute2ProviderInfo;
import android.media.MediaRouter2Utils;
import android.media.RouteDiscoveryPreference;
import android.media.RoutingSessionInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class SystemMediaRoute2Provider extends MediaRoute2Provider {
    private static final ComponentName COMPONENT_NAME = null;
    private static final boolean DEBUG = false;
    static final String SYSTEM_SESSION_ID = "SYSTEM_SESSION";
    static final String TAG = "MR2SystemProvider";
    private final AudioManager mAudioManager;
    private final AudioManagerBroadcastReceiver mAudioReceiver;
    private final BluetoothRouteController mBluetoothRouteController;
    private final Context mContext;
    MediaRoute2Info mDefaultRoute;
    RoutingSessionInfo mDefaultSessionInfo;
    private final DeviceRouteController mDeviceRouteController;
    protected final Handler mHandler;
    private volatile MediaRoute2Provider.SessionCreationOrTransferRequest mPendingSessionCreationOrTransferRequest;
    private volatile MediaRoute2Provider.SessionCreationOrTransferRequest mPendingTransferRequest;
    private final Object mRequestLock;
    private String mSelectedRouteId;
    RoutingSessionInfo mSystemSessionInfo;
    private final Object mTransferLock;
    private final UserHandle mUser;

    private class AudioManagerBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ SystemMediaRoute2Provider this$0;

        /* synthetic */ AudioManagerBroadcastReceiver(SystemMediaRoute2Provider r1, SystemMediaRoute2ProviderIA r2) {
            this(r1);
        }

        private AudioManagerBroadcastReceiver(SystemMediaRoute2Provider r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION") == false) goto L5;
        L7:
            int streamType = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
            if (streamType == 3) goto L10;
            return;
        L10:
            Handler r1 = this.this$0.mHandler;
            final SystemMediaRoute2Provider r2 = this.this$0;
            r1.post(new SystemMediaRoute2Provider$AudioManagerBroadcastReceiver$$ExternalSyntheticLambda0(r2));
            return;
        L5:
            if (intent.getAction().equals("android.media.STREAM_DEVICES_CHANGED_ACTION") == true) goto L7;
        }
    }

    public static /* synthetic */ void $r8$lambda$aQ6YhPsMldeMpKOd7EjglgHsk0w(SystemMediaRoute2Provider r0) {
        r0.lambda$new$2();
    }

    /* JADX INFO: renamed from: $r8$lambda$m21-NzGW5bJpo84JUmuDNLlocmI, reason: not valid java name */
    public static /* synthetic */ void m5773$r8$lambda$m21NzGW5bJpo84JUmuDNLlocmI(SystemMediaRoute2Provider r0) {
        r0.lambda$start$3();
    }

    /* JADX INFO: renamed from: $r8$lambda$mUlrxqDGOL_-p06n3SmK2tJKqMQ, reason: not valid java name */
    public static /* synthetic */ void m5774$r8$lambda$mUlrxqDGOL_p06n3SmK2tJKqMQ(SystemMediaRoute2Provider r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ void $r8$lambda$mbBDeUSHhOf0MqU1LCkAcyO_3ME(SystemMediaRoute2Provider r0) {
        r0.lambda$stop$4();
    }

    /* JADX INFO: renamed from: $r8$lambda$ojLWgCm6yw1GJ-lo9Kv5SEXgzj0, reason: not valid java name */
    public static /* synthetic */ boolean m5775$r8$lambda$ojLWgCm6yw1GJlo9Kv5SEXgzj0(String r0, MediaRoute2Info r1) {
        return lambda$transferToRoute$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$zMiSRTQtn2AnxIAf0BjD4kEsDMw(SystemMediaRoute2Provider r0) {
        r0.lambda$new$1();
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        COMPONENT_NAME = new ComponentName(SystemMediaRoute2Provider.class.getPackage().getName(), SystemMediaRoute2Provider.class.getName());
    }

    public static SystemMediaRoute2Provider create(Context context, UserHandle user, Looper looper) {
        SystemMediaRoute2Provider instance = new SystemMediaRoute2Provider(context, COMPONENT_NAME, user, looper);
        instance.updateProviderState();
        instance.updateSessionInfosIfNeeded();
        return instance;
    }

    protected SystemMediaRoute2Provider(Context context, ComponentName componentName, UserHandle user, Looper looper) {
        super(componentName, true);
        this.mAudioReceiver = new AudioManagerBroadcastReceiver(this, null);
        this.mRequestLock = new Object();
        this.mTransferLock = new Object();
        this.mContext = context;
        this.mUser = user;
        this.mHandler = new Handler(looper);
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.mBluetoothRouteController = BluetoothRouteController.createInstance(context, new SystemMediaRoute2Provider$$ExternalSyntheticLambda0(this));
        this.mDeviceRouteController = DeviceRouteController.createInstance(context, looper, new SystemMediaRoute2Provider$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$new$0() {
        publishProviderState();
        if (updateSessionInfosIfNeeded() == false) goto L6;
        notifyGlobalSessionInfoUpdated();
        return;
    }

    private /* synthetic */ void lambda$new$2() {
        this.mHandler.post(new SystemMediaRoute2Provider$$ExternalSyntheticLambda3(this));
    }

    private /* synthetic */ void lambda$new$1() {
        publishProviderState();
        if (updateSessionInfosIfNeeded() == false) goto L6;
        notifyGlobalSessionInfoUpdated();
        return;
    }

    public void start() {
        IntentFilter intentFilter = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
        intentFilter.addAction("android.media.STREAM_DEVICES_CHANGED_ACTION");
        this.mContext.registerReceiverAsUser(this.mAudioReceiver, this.mUser, intentFilter, null, null);
        this.mHandler.post(new SystemMediaRoute2Provider$$ExternalSyntheticLambda5(this));
        updateVolume();
    }

    private /* synthetic */ void lambda$start$3() {
        this.mDeviceRouteController.start(this.mUser);
        this.mBluetoothRouteController.start(this.mUser);
    }

    public void stop() {
        this.mContext.unregisterReceiver(this.mAudioReceiver);
        this.mHandler.post(new SystemMediaRoute2Provider$$ExternalSyntheticLambda4(this));
    }

    private /* synthetic */ void lambda$stop$4() {
        this.mBluetoothRouteController.stop();
        this.mDeviceRouteController.stop();
        notifyProviderState();
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void setCallback(MediaRoute2Provider.Callback callback) {
        super.setCallback(callback);
        notifyProviderState();
        notifyGlobalSessionInfoUpdated();
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void requestCreateSession(long requestId, String packageName, String routeOriginalId, Bundle sessionHints, int transferReason, UserHandle transferInitiatorUserHandle, String transferInitiatorPackageName) {
        if (TextUtils.equals(routeOriginalId, "DEFAULT_ROUTE") == false) goto L6;
        this.mCallback.onSessionCreated(this, requestId, this.mDefaultSessionInfo);
        return;
    L6:
        Object r9 = this.mRequestLock;
        monitor-enter(r9);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (this.mPendingSessionCreationOrTransferRequest == null) goto L13;
        this.mCallback.onRequestFailed(this, this.mPendingSessionCreationOrTransferRequest.mRequestId, 0);     // Catch: Throwable -> L11
    L13:
        this.mPendingSessionCreationOrTransferRequest = new MediaRoute2Provider.SessionCreationOrTransferRequest(requestId, routeOriginalId, 0, transferInitiatorUserHandle, transferInitiatorPackageName);     // Catch: Throwable -> L11
        monitor-exit(r9);     // Catch: Throwable -> L11
        transferToRoute(requestId, transferInitiatorUserHandle, transferInitiatorPackageName, SYSTEM_SESSION_ID, routeOriginalId, transferReason);
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void releaseSession(long requestId, String sessionId) {
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void updateDiscoveryPreference(Set<String> activelyScanningPackages, RouteDiscoveryPreference discoveryPreference) {
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void selectRoute(long requestId, String sessionId, String routeId) {
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void deselectRoute(long requestId, String sessionId, String routeId) {
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void transferToRoute(long requestId, UserHandle transferInitiatorUserHandle, String transferInitiatorPackageName, String sessionOriginalId, String routeOriginalId, int transferReason) {
        String selectedDeviceRouteId = this.mDeviceRouteController.getSelectedRoute().getId();
        if (TextUtils.equals(routeOriginalId, "DEFAULT_ROUTE") == false) goto L5;
        String routeOriginalId2 = selectedDeviceRouteId;
    L6:
        Object r9 = this.mTransferLock;
        monitor-enter(r9);
        this.mPendingTransferRequest = new MediaRoute2Provider.SessionCreationOrTransferRequest(requestId, routeOriginalId2, transferReason, transferInitiatorUserHandle, transferInitiatorPackageName);     // Catch: Throwable -> L20
        monitor-exit(r9);     // Catch: Throwable -> L20
        final String finalRouteId = routeOriginalId2;
        boolean isAvailableDeviceRoute = this.mDeviceRouteController.getAvailableRoutes().stream().anyMatch(new SystemMediaRoute2Provider$$ExternalSyntheticLambda2(finalRouteId));
        boolean isSelectedDeviceRoute = TextUtils.equals(routeOriginalId2, selectedDeviceRouteId);
        if (isSelectedDeviceRoute == true) goto L15;
        if (isAvailableDeviceRoute == true) goto L15;
        this.mDeviceRouteController.transferTo(null);
        this.mBluetoothRouteController.transferTo(routeOriginalId2);
    L17:
        if (updateSessionInfosIfNeeded() == false) goto L25;
        notifyGlobalSessionInfoUpdated();
        return;
    L25:
        return;
    L15:
        this.mDeviceRouteController.transferTo(routeOriginalId2);
        this.mBluetoothRouteController.transferTo(null);
    L20:
        th = move-exception;
        throw th;
    L5:
        routeOriginalId2 = routeOriginalId;
        goto L6
    }

    private static /* synthetic */ boolean lambda$transferToRoute$5(String finalRouteId, MediaRoute2Info it) {
        return it.getId().equals(finalRouteId);
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void setRouteVolume(long requestId, String routeOriginalId, int volume) {
        if (TextUtils.equals(routeOriginalId, this.mSelectedRouteId) == true) goto L5;
        return;
    L5:
        this.mAudioManager.setStreamVolume(3, volume, 0);
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void setSessionVolume(long requestId, String sessionOriginalId, int volume) {
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void prepareReleaseSession(String sessionUniqueId) {
    }

    public MediaRoute2Info getDefaultRoute() {
        return this.mDefaultRoute;
    }

    public RoutingSessionInfo getDefaultSessionInfo() {
        return this.mDefaultSessionInfo;
    }

    public RoutingSessionInfo getSessionForPackage(String targetPackageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mSessionInfos.isEmpty() == true) goto L11;
        RoutingSessionInfo r1 = new RoutingSessionInfo.Builder(this.mSessionInfos.get(0)).setClientPackageName(targetPackageName).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    }

    public RoutingSessionInfo generateDeviceRouteSelectedSessionInfo(String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mSessionInfos.isEmpty() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        MediaRoute2Info selectedDeviceRoute = this.mDeviceRouteController.getSelectedRoute();     // Catch: Throwable -> L9
        RoutingSessionInfo.Builder builder = new RoutingSessionInfo.Builder(SYSTEM_SESSION_ID, packageName).setSystemSession(true);     // Catch: Throwable -> L9
        builder.addSelectedRoute(selectedDeviceRoute.getId());     // Catch: Throwable -> L9
        Iterator<MediaRoute2Info> r3 = this.mBluetoothRouteController.getAllBluetoothRoutes().iterator();     // Catch: Throwable -> L9
    L13:
        if (r3.hasNext() == false) goto L15;
        builder.addTransferableRoute(r3.next().getId());     // Catch: Throwable -> L9
        goto L13
    L15:
        Iterator<MediaRoute2Info> r4 = this.mDeviceRouteController.getAvailableRoutes().iterator();     // Catch: Throwable -> L9
    L17:
        if (r4.hasNext() == false) goto L22;
        MediaRoute2Info route = r4.next();     // Catch: Throwable -> L9
        if (TextUtils.equals(selectedDeviceRoute.getId(), route.getId()) == true) goto L17;
        builder.addTransferableRoute(route.getId());     // Catch: Throwable -> L9
        goto L17
    L22:
        RoutingSessionInfo oldSessionInfo = this.mSessionInfos.get(0);     // Catch: Throwable -> L9
        builder.setTransferReason(oldSessionInfo.getTransferReason()).setTransferInitiator(oldSessionInfo.getTransferInitiatorUserHandle(), oldSessionInfo.getTransferInitiatorPackageName());     // Catch: Throwable -> L9
        RoutingSessionInfo r5 = builder.setProviderId(this.mUniqueId).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r5;
    }

    public void updateSystemMediaRoutesFromProxy(MediaRoute2ProviderServiceProxy serviceProxy) {
    }

    public void onSystemProviderRoutesChanged(MediaRoute2ProviderInfo providerInfo) {
        setProviderState(providerInfo);
    }

    protected void updateProviderState() {
        MediaRoute2ProviderInfo.Builder builder = new MediaRoute2ProviderInfo.Builder();
        List<MediaRoute2Info> deviceRoutes = this.mDeviceRouteController.getAvailableRoutes();
        Iterator<MediaRoute2Info> r2 = deviceRoutes.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        MediaRoute2Info route = r2.next();
        builder.addRoute(route);
        goto L4
    L6:
        setProviderState(builder.build());
        Iterator<MediaRoute2Info> r1 = this.mBluetoothRouteController.getAllBluetoothRoutes().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        MediaRoute2Info route2 = r1.next();
        builder.addRoute(route2);
        goto L8
    L10:
        MediaRoute2ProviderInfo providerInfo = builder.build();
        onSystemProviderRoutesChanged(providerInfo);
        if (DEBUG == false) goto L16;
        Slog.d(TAG, "Updating system provider info : " + providerInfo);
        return;
    }

    boolean updateSessionInfosIfNeeded() {
        Object r2 = this.mLock;
        monitor-enter(r2);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mSessionInfos.isEmpty() == false) goto L7;
        RoutingSessionInfo r0 = null;
    L8:
        RoutingSessionInfo oldSessionInfo = r0;
        RoutingSessionInfo.Builder builder = new RoutingSessionInfo.Builder(SYSTEM_SESSION_ID, "").setSystemSession(true);     // Catch: Throwable -> L11
        MediaRoute2Info selectedRoute = this.mDeviceRouteController.getSelectedRoute();     // Catch: Throwable -> L11
        MediaRoute2Info selectedBtRoute = this.mBluetoothRouteController.getSelectedRoute();     // Catch: Throwable -> L11
        List<String> transferableRoutes = new ArrayList();     // Catch: Throwable -> L11
        if (selectedBtRoute == null) goto L13;
        transferableRoutes.add(selectedRoute.getId());     // Catch: Throwable -> L11
        MediaRoute2Info selectedRoute2 = selectedBtRoute;
    L14:
        this.mSelectedRouteId = selectedRoute2.getId();     // Catch: Throwable -> L11
        this.mDefaultRoute = new MediaRoute2Info.Builder("DEFAULT_ROUTE", selectedRoute2).setSystemRoute(true).setProviderId(this.mUniqueId).build();     // Catch: Throwable -> L11
        builder.addSelectedRoute(this.mSelectedRouteId);     // Catch: Throwable -> L11
        Iterator<MediaRoute2Info> r1 = this.mDeviceRouteController.getAvailableRoutes().iterator();     // Catch: Throwable -> L11
    L16:
        if (r1.hasNext() == false) goto L21;
        MediaRoute2Info route = r1.next();     // Catch: Throwable -> L11
        String routeId = route.getId();     // Catch: Throwable -> L11
        if (this.mSelectedRouteId.equals(routeId) == true) goto L16;
        transferableRoutes.add(routeId);     // Catch: Throwable -> L11
        goto L16
    L21:
        Iterator<MediaRoute2Info> r3 = this.mBluetoothRouteController.getTransferableRoutes().iterator();     // Catch: Throwable -> L11
    L23:
        if (r3.hasNext() == false) goto L25;
        MediaRoute2Info route2 = r3.next();     // Catch: Throwable -> L11
        transferableRoutes.add(route2.getId());     // Catch: Throwable -> L11
        goto L23
    L25:
        Iterator<String> r4 = transferableRoutes.iterator();     // Catch: Throwable -> L11
    L27:
        if (r4.hasNext() == false) goto L30;
        String route3 = r4.next();     // Catch: Throwable -> L11
        builder.addTransferableRoute(route3);     // Catch: Throwable -> L11
        goto L27
    L30:
        if (oldSessionInfo != null) goto L32;
    L34:
        String transferInitiatorPackageName = null;
        UserHandle transferInitiatorUserHandle = null;
        int transferReason = 0;
    L35:
        Object r15 = this.mTransferLock;     // Catch: Throwable -> L11
        monitor-enter(r15);     // Catch: Throwable -> L11
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L38:
        if (this.mPendingTransferRequest == null) goto L46;
        boolean isTransferringToTheSelectedRoute = this.mPendingTransferRequest.isTargetRoute(selectedRoute2);     // Catch: Throwable -> L42
        boolean r16 = false;
        boolean canBePotentiallyTransferred = this.mPendingTransferRequest.isTargetRouteIdInRouteOriginalIdList(transferableRoutes);     // Catch: Throwable -> L42
        if (isTransferringToTheSelectedRoute == false) goto L44;
        transferReason = this.mPendingTransferRequest.mTransferReason;     // Catch: Throwable -> L42
        transferInitiatorUserHandle = this.mPendingTransferRequest.mTransferInitiatorUserHandle;     // Catch: Throwable -> L42
        transferInitiatorPackageName = this.mPendingTransferRequest.mTransferInitiatorPackageName;     // Catch: Throwable -> L42
        this.mPendingTransferRequest = null;     // Catch: Throwable -> L42
    L47:
        monitor-exit(r15);     // Catch: Throwable -> L42
        builder.setTransferReason(transferReason).setTransferInitiator(transferInitiatorUserHandle, transferInitiatorPackageName);     // Catch: Throwable -> L11
        RoutingSessionInfo newSessionInfo = builder.setProviderId(this.mUniqueId).build();     // Catch: Throwable -> L11
        Object r5 = this.mRequestLock;     // Catch: Throwable -> L11
        monitor-enter(r5);     // Catch: Throwable -> L11
        reportPendingSessionRequestResultLockedIfNeeded(newSessionInfo);     // Catch: Throwable -> L63
        monitor-exit(r5);     // Catch: Throwable -> L63
    L53:
        if (Objects.equals(oldSessionInfo, newSessionInfo) == false) goto L57;
        monitor-exit(r2);     // Catch: Throwable -> L11
        return r16;
    L57:
        if (DEBUG == false) goto L59;
        Slog.d(TAG, "Updating system routing session info : " + newSessionInfo);     // Catch: Throwable -> L11
    L59:
        this.mSystemSessionInfo = newSessionInfo;     // Catch: Throwable -> L11
        onSystemSessionInfoUpdated();     // Catch: Throwable -> L11
        this.mDefaultSessionInfo = new RoutingSessionInfo.Builder(SYSTEM_SESSION_ID, "").setProviderId(this.mUniqueId).setSystemSession(true).addSelectedRoute("DEFAULT_ROUTE").setTransferReason(newSessionInfo.getTransferReason()).setTransferInitiator(newSessionInfo.getTransferInitiatorUserHandle(), newSessionInfo.getTransferInitiatorPackageName()).build();     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return true;
    L63:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L44:
        if (canBePotentiallyTransferred == true) goto L47;
        this.mPendingTransferRequest = null;     // Catch: Throwable -> L42
        goto L47
    L46:
        r16 = false;
        goto L47
    L32:
        if (containsSelectedRouteWithId(oldSessionInfo, selectedRoute2.getId()) == false) goto L34;
        int transferReason2 = oldSessionInfo.getTransferReason();     // Catch: Throwable -> L11
        UserHandle transferInitiatorUserHandle2 = oldSessionInfo.getTransferInitiatorUserHandle();     // Catch: Throwable -> L11
        transferInitiatorPackageName = oldSessionInfo.getTransferInitiatorPackageName();     // Catch: Throwable -> L11
        transferInitiatorUserHandle = transferInitiatorUserHandle2;
        transferReason = transferReason2;
        goto L35
    L13:
        selectedRoute2 = selectedRoute;
        goto L14
    L7:
        r0 = this.mSessionInfos.get(0);     // Catch: Throwable -> L11
        goto L8
    }

    protected void onSystemSessionInfoUpdated() {
        this.mSessionInfos.clear();
        this.mSessionInfos.add(this.mSystemSessionInfo);
    }

    private void reportPendingSessionRequestResultLockedIfNeeded(RoutingSessionInfo newSessionInfo) {
        if (this.mPendingSessionCreationOrTransferRequest != null) goto L5;
        return;
    L5:
        long pendingRequestId = this.mPendingSessionCreationOrTransferRequest.mRequestId;
        if (this.mPendingSessionCreationOrTransferRequest.mTargetOriginalRouteId.equals(this.mSelectedRouteId) == true) goto L8;
        boolean isRequestedRouteConnectedBtRoute = isRequestedRouteConnectedBtRoute();
        if (isRequestedRouteConnectedBtRoute == true) goto L18;
        if (DEBUG == false) goto L16;
        Slog.w(TAG, "Session creation failed to route " + this.mPendingSessionCreationOrTransferRequest.mTargetOriginalRouteId);
    L16:
        this.mPendingSessionCreationOrTransferRequest = null;
        this.mCallback.onRequestFailed(this, pendingRequestId, 0);
        return;
    L18:
        if (DEBUG == false) goto L23;
        Slog.w(TAG, "Session creation waiting state to route " + this.mPendingSessionCreationOrTransferRequest.mTargetOriginalRouteId);
        return;
    L23:
        return;
    L8:
        if (DEBUG == false) goto L10;
        Slog.w(TAG, "Session creation success to route " + this.mPendingSessionCreationOrTransferRequest.mTargetOriginalRouteId);
    L10:
        this.mPendingSessionCreationOrTransferRequest = null;
        this.mCallback.onSessionCreated(this, pendingRequestId, newSessionInfo);
    }

    private boolean isRequestedRouteConnectedBtRoute() {
        Iterator<MediaRoute2Info> r0 = this.mBluetoothRouteController.getAllBluetoothRoutes().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        MediaRoute2Info btRoute = r0.next();
        if (TextUtils.equals(btRoute.getId(), this.mPendingSessionCreationOrTransferRequest.mTargetOriginalRouteId) == false) goto L4;
        return true;
    L10:
        return false;
    }

    private boolean containsSelectedRouteWithId(RoutingSessionInfo sessionInfo, String selectedRouteId) {
        if (sessionInfo != null) goto L5;
        return false;
    L5:
        List<String> selectedRoutes = sessionInfo.getSelectedRoutes();
        if (selectedRoutes.size() != 1) goto L14;
        String oldSelectedRouteId = MediaRouter2Utils.getOriginalId(selectedRoutes.get(0));
        if (oldSelectedRouteId != null) goto L10;
        return false;
    L10:
        if (oldSelectedRouteId.equals(selectedRouteId) == true) goto L12;
        return false;
    L12:
        return true;
    L14:
        throw new IllegalStateException("Selected routes list should contain only 1 route id.");
    }

    void publishProviderState() {
        updateProviderState();
        notifyProviderState();
    }

    void notifyGlobalSessionInfoUpdated() {
        if (this.mCallback != null) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (this.mSessionInfos.isEmpty() == false) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        RoutingSessionInfo sessionInfo = this.mSessionInfos.get(0);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.mCallback.onSessionUpdated(this, sessionInfo, Set.of());
    }

    @Override // com.android.server.media.MediaRoute2Provider
    protected String getDebugString() {
        return TextUtils.formatSimple("%s - package: %s, selected route id: %s, bluetooth impl: %s", new Object[]{getClass().getSimpleName(), this.mComponentName.getPackageName(), this.mSelectedRouteId, this.mBluetoothRouteController.getClass().getSimpleName()});
    }

    void updateVolume() {
        int devices = this.mAudioManager.getDevicesForStream(3);
        int volume = this.mAudioManager.getStreamVolume(3);
        if (this.mDefaultRoute.getVolume() == volume) goto L6;
        this.mDefaultRoute = new MediaRoute2Info.Builder(this.mDefaultRoute).setVolume(volume).build();
    L6:
        if (this.mBluetoothRouteController.updateVolumeForDevices(devices, volume) == false) goto L8;
        return;
    L8:
        this.mDeviceRouteController.updateVolume(volume);
        publishProviderState();
    }
}
