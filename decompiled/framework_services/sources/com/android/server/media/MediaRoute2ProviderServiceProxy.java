package com.android.server.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.media.IMediaRoute2ProviderService;
import android.media.IMediaRoute2ProviderServiceCallback;
import android.media.MediaRoute2Info;
import android.media.MediaRoute2ProviderInfo;
import android.media.RouteDiscoveryPreference;
import android.media.RoutingSessionInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Slog;
import com.android.internal.util.function.pooled.PooledLambda;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class MediaRoute2ProviderServiceProxy extends MediaRoute2Provider {
    private static final boolean DEBUG = false;
    private static final String TAG = "MR2ProviderSvcProxy";
    private Connection mActiveConnection;
    private boolean mBound;
    private boolean mConnectionReady;
    private final Context mContext;
    private final IMediaRouterServiceExt mExt;
    private final Handler mHandler;
    private boolean mIsManagerScanning;
    private final boolean mIsSelfScanOnlyProvider;
    private RouteDiscoveryPreference mLastDiscoveryPreference;
    private boolean mLastDiscoveryPreferenceIncludesThisPackage;
    private final List<RoutingSessionInfo> mReleasingSessions;
    private final LongSparseArray<MediaRoute2Provider.SessionCreationOrTransferRequest> mRequestIdToSessionCreationRequest;
    private final LongSparseArray<SystemMediaSessionCallback> mRequestIdToSystemSessionRequest;
    private boolean mRunning;
    private final ServiceConnection mServiceConnection;
    private final Map<String, MediaRoute2Provider.SessionCreationOrTransferRequest> mSessionOriginalIdToTransferRequest;
    private final boolean mSupportsSystemMediaRouting;
    private final Map<String, SystemMediaSessionCallback> mSystemSessionCallbacks;
    private final int mUserId;

    private final class Connection implements IBinder.DeathRecipient {
        private final ServiceCallbackStub mCallbackStub;
        private final IMediaRoute2ProviderService mService;
        final /* synthetic */ MediaRoute2ProviderServiceProxy this$0;

        /* JADX INFO: renamed from: $r8$lambda$284ORzb2BNFSsYWX1Wpcv1cM-RE, reason: not valid java name */
        public static /* synthetic */ void m5561$r8$lambda$284ORzb2BNFSsYWX1Wpcv1cMRE(Connection r0, RoutingSessionInfo r1) {
            r0.lambda$postSessionReleased$5(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$VSAxrHMYHMoRCKG-CR11Tt4dX6I, reason: not valid java name */
        public static /* synthetic */ void m5562$r8$lambda$VSAxrHMYHMoRCKGCR11Tt4dX6I(Connection r0, long r1, int r3) {
            r0.lambda$postRequestFailed$6(r1, r3);
        }

        public static /* synthetic */ void $r8$lambda$YlGhOiWevCxqHJXfOll2q1jJwrA(Connection r0) {
            r0.lambda$register$0();
        }

        public static /* synthetic */ void $r8$lambda$ZQNACZBXjNd5X97cC22250Uumi0(Connection r0, MediaRoute2ProviderInfo r1) {
            r0.lambda$postProviderUpdated$2(r1);
        }

        public static /* synthetic */ void $r8$lambda$kXt5dnSoORG7Pad_sUe5vDdZKA0(Connection r0) {
            r0.lambda$binderDied$1();
        }

        public static /* synthetic */ void $r8$lambda$mYCKlrI6G6oOQUbkr4Mv1_3cF64(Connection r0, List r1) {
            r0.lambda$postSessionsUpdated$4(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$vn-jOyYZFhvq0w-UCwoLaYegdyY, reason: not valid java name */
        public static /* synthetic */ void m5563$r8$lambda$vnjOyYZFhvq0wUCwoLaYegdyY(Connection r0, long r1, RoutingSessionInfo r3) {
            r0.lambda$postSessionCreated$3(r1, r3);
        }

        Connection(MediaRoute2ProviderServiceProxy r2, IMediaRoute2ProviderService serviceBinder) {
            this.this$0 = r2;
            this.mService = serviceBinder;
            this.mCallbackStub = new ServiceCallbackStub(this, MediaRoute2ProviderServiceProxy.m5550$$Nest$fgetmSupportsSystemMediaRouting(r2));
        }

        public boolean register() {
            this.mService.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L6
            this.mService.setCallback(this.mCallbackStub);     // Catch: RemoteException -> L6
            MediaRoute2ProviderServiceProxy.m5549$$Nest$fgetmHandler(this.this$0).post(new MediaRoute2ProviderServiceProxy$Connection$$ExternalSyntheticLambda5(this));     // Catch: RemoteException -> L6
            return true;
        L7:
            binderDied();
            return false;
        }

        private /* synthetic */ void lambda$register$0() {
            MediaRoute2ProviderServiceProxy.m5553$$Nest$monConnectionReady(this.this$0, this);
        }

        public void dispose() {
            this.mService.asBinder().unlinkToDeath(this, 0);
            this.mCallbackStub.dispose();
        }

        public void requestCreateSession(long requestId, String packageName, String routeId, Bundle sessionHints) {
            this.mService.requestCreateSession(requestId, packageName, routeId, sessionHints);     // Catch: RemoteException -> L6
            return;
        L10:
            Slog.e(MediaRoute2ProviderServiceProxy.TAG, "requestCreateSession: Failed to deliver request.");
        }

        public boolean requestCreateSystemMediaSession(long requestId, int uid, String packageName, String routeId, Bundle sessionHints) {
            this.mService.requestCreateSystemMediaSession(requestId, uid, packageName, routeId, sessionHints);     // Catch: RemoteException -> L7
            return true;
        L11:
            Slog.e(MediaRoute2ProviderServiceProxy.TAG, "requestCreateSystemMediaSession: Failed to deliver request.");
            return false;
        }

        public void releaseSession(long requestId, String sessionId) {
            this.mService.releaseSession(requestId, sessionId);     // Catch: RemoteException -> L4
            return;
        L5:
            Slog.e(MediaRoute2ProviderServiceProxy.TAG, "releaseSession: Failed to deliver request.");
        }

        public void updateDiscoveryPreference(RouteDiscoveryPreference discoveryPreference) {
            this.mService.updateDiscoveryPreference(discoveryPreference);     // Catch: RemoteException -> L4
            return;
        L5:
            Slog.e(MediaRoute2ProviderServiceProxy.TAG, "updateDiscoveryPreference: Failed to deliver request.");
        }

        public void selectRoute(long requestId, String sessionId, String routeId) {
            this.mService.selectRoute(requestId, sessionId, routeId);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.e(MediaRoute2ProviderServiceProxy.TAG, "selectRoute: Failed to deliver request.", ex);
        }

        public void deselectRoute(long requestId, String sessionId, String routeId) {
            this.mService.deselectRoute(requestId, sessionId, routeId);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.e(MediaRoute2ProviderServiceProxy.TAG, "deselectRoute: Failed to deliver request.", ex);
        }

        public void transferToRoute(long requestId, String sessionId, String routeId) {
            this.mService.transferToRoute(requestId, sessionId, routeId);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.e(MediaRoute2ProviderServiceProxy.TAG, "transferToRoute: Failed to deliver request.", ex);
        }

        public void setRouteVolume(long requestId, String routeId, int volume) {
            this.mService.setRouteVolume(requestId, routeId, volume);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.e(MediaRoute2ProviderServiceProxy.TAG, "setRouteVolume: Failed to deliver request.", ex);
        }

        public void setSessionVolume(long requestId, String sessionId, int volume) {
            this.mService.setSessionVolume(requestId, sessionId, volume);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.e(MediaRoute2ProviderServiceProxy.TAG, "setSessionVolume: Failed to deliver request.", ex);
        }

        private /* synthetic */ void lambda$binderDied$1() {
            MediaRoute2ProviderServiceProxy.m5552$$Nest$monConnectionDied(this.this$0, this);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaRoute2ProviderServiceProxy.m5549$$Nest$fgetmHandler(this.this$0).post(new MediaRoute2ProviderServiceProxy$Connection$$ExternalSyntheticLambda1(this));
        }

        private /* synthetic */ void lambda$postProviderUpdated$2(MediaRoute2ProviderInfo providerInfo) {
            MediaRoute2ProviderServiceProxy.m5554$$Nest$monProviderUpdated(this.this$0, this, providerInfo);
        }

        void postProviderUpdated(final MediaRoute2ProviderInfo providerInfo) {
            MediaRoute2ProviderServiceProxy.m5549$$Nest$fgetmHandler(this.this$0).post(new MediaRoute2ProviderServiceProxy$Connection$$ExternalSyntheticLambda2(this, providerInfo));
        }

        private /* synthetic */ void lambda$postSessionCreated$3(long requestId, RoutingSessionInfo sessionInfo) {
            MediaRoute2ProviderServiceProxy.m5558$$Nest$monSessionCreated(this.this$0, this, requestId, sessionInfo);
        }

        void postSessionCreated(final long requestId, final RoutingSessionInfo sessionInfo) {
            MediaRoute2ProviderServiceProxy.m5549$$Nest$fgetmHandler(this.this$0).post(new MediaRoute2ProviderServiceProxy$Connection$$ExternalSyntheticLambda4(this, requestId, sessionInfo));
        }

        private /* synthetic */ void lambda$postSessionsUpdated$4(List sessionInfo) {
            MediaRoute2ProviderServiceProxy.m5560$$Nest$monSessionsUpdated(this.this$0, this, sessionInfo);
        }

        void postSessionsUpdated(final List<RoutingSessionInfo> sessionInfo) {
            MediaRoute2ProviderServiceProxy.m5549$$Nest$fgetmHandler(this.this$0).post(new MediaRoute2ProviderServiceProxy$Connection$$ExternalSyntheticLambda6(this, sessionInfo));
        }

        private /* synthetic */ void lambda$postSessionReleased$5(RoutingSessionInfo sessionInfo) {
            MediaRoute2ProviderServiceProxy.m5559$$Nest$monSessionReleased(this.this$0, this, sessionInfo);
        }

        void postSessionReleased(final RoutingSessionInfo sessionInfo) {
            MediaRoute2ProviderServiceProxy.m5549$$Nest$fgetmHandler(this.this$0).post(new MediaRoute2ProviderServiceProxy$Connection$$ExternalSyntheticLambda3(this, sessionInfo));
        }

        private /* synthetic */ void lambda$postRequestFailed$6(long requestId, int reason) {
            MediaRoute2ProviderServiceProxy.m5555$$Nest$monRequestFailed(this.this$0, this, requestId, reason);
        }

        void postRequestFailed(final long requestId, final int reason) {
            MediaRoute2ProviderServiceProxy.m5549$$Nest$fgetmHandler(this.this$0).post(new MediaRoute2ProviderServiceProxy$Connection$$ExternalSyntheticLambda0(this, requestId, reason));
        }
    }

    private static final class ServiceCallbackStub extends IMediaRoute2ProviderServiceCallback.Stub {
        private final boolean mAllowSystemMediaRoutes;
        private final WeakReference<Connection> mConnectionRef;

        ServiceCallbackStub(Connection connection, boolean allowSystemMediaRoutes) {
            this.mConnectionRef = new WeakReference(connection);
            this.mAllowSystemMediaRoutes = allowSystemMediaRoutes;
        }

        public void dispose() {
            this.mConnectionRef.clear();
        }

        public void notifyProviderUpdated(MediaRoute2ProviderInfo providerInfo) {
            providerInfo.getClass();
            Iterator r0 = providerInfo.getRoutes().iterator();
        L4:
            if (r0.hasNext() == false) goto L25;
            MediaRoute2Info route = (MediaRoute2Info) r0.next();
            if (route.isSystemRoute() == true) goto L24;
            if (route.getSuitabilityStatus() == 2) goto L22;
            if (route.isSystemRouteType() == true) goto L20;
            if (route.supportsSystemMediaRouting() == false) goto L4;
            if (this.mAllowSystemMediaRoutes == true) goto L4;
            throw new SecurityException("This provider is not allowed to publish routes that support system media routing. Disallowed route: " + route);
        L20:
            throw new SecurityException("Only the system is allowed to publish routes with system route types. Disallowed route: " + route);
        L22:
            throw new SecurityException("Only the system is allowed to set not suitable for transfer status. Disallowed route: " + route);
        L24:
            throw new SecurityException("Only the system is allowed to publish system routes. Disallowed route: " + route);
        L25:
            Connection connection = this.mConnectionRef.get();
            if (connection == null) goto L38;
            connection.postProviderUpdated(providerInfo);
            return;
        }

        public void notifySessionCreated(long requestId, RoutingSessionInfo sessionInfo) {
            Connection connection = this.mConnectionRef.get();
            if (connection == null) goto L6;
            connection.postSessionCreated(requestId, sessionInfo);
            return;
        }

        public void notifySessionsUpdated(List<RoutingSessionInfo> sessionInfo) {
            Connection connection = this.mConnectionRef.get();
            if (connection == null) goto L6;
            connection.postSessionsUpdated(sessionInfo);
            return;
        }

        public void notifySessionReleased(RoutingSessionInfo sessionInfo) {
            Connection connection = this.mConnectionRef.get();
            if (connection == null) goto L6;
            connection.postSessionReleased(sessionInfo);
            return;
        }

        public void notifyRequestFailed(long requestId, int reason) {
            Connection connection = this.mConnectionRef.get();
            if (connection == null) goto L6;
            connection.postRequestFailed(requestId, reason);
            return;
        }
    }

    private final class ServiceConnectionImpl implements ServiceConnection {
        final /* synthetic */ MediaRoute2ProviderServiceProxy this$0;

        /* JADX INFO: renamed from: $r8$lambda$-Qp6FDGCPMY6kJUx4cABRpZqISs, reason: not valid java name */
        public static /* synthetic */ void m5564$r8$lambda$Qp6FDGCPMY6kJUx4cABRpZqISs(ServiceConnectionImpl r0, ComponentName r1) {
            r0.lambda$onBindingDied$2(r1);
        }

        public static /* synthetic */ void $r8$lambda$9G6KwvVUXkWq4WBpOxOTm0i6UqI(ServiceConnectionImpl r0) {
            r0.lambda$onServiceDisconnected$1();
        }

        public static /* synthetic */ void $r8$lambda$cmXHceT8mMS3tqJOwoEQosMdsjY(ServiceConnectionImpl r0, IBinder r1) {
            r0.lambda$onServiceConnected$0(r1);
        }

        /* synthetic */ ServiceConnectionImpl(MediaRoute2ProviderServiceProxy r1, MediaRoute2ProviderServiceProxyIA r2) {
            this(r1);
        }

        private ServiceConnectionImpl(MediaRoute2ProviderServiceProxy r1) {
            this.this$0 = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, final IBinder service) {
            MediaRoute2ProviderServiceProxy.m5549$$Nest$fgetmHandler(this.this$0).post(new MediaRoute2ProviderServiceProxy$ServiceConnectionImpl$$ExternalSyntheticLambda0(this, service));
        }

        private /* synthetic */ void lambda$onServiceConnected$0(IBinder service) {
            MediaRoute2ProviderServiceProxy.m5556$$Nest$monServiceConnectedInternal(this.this$0, service);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            MediaRoute2ProviderServiceProxy.m5549$$Nest$fgetmHandler(this.this$0).post(new MediaRoute2ProviderServiceProxy$ServiceConnectionImpl$$ExternalSyntheticLambda1(this));
        }

        private /* synthetic */ void lambda$onServiceDisconnected$1() {
            MediaRoute2ProviderServiceProxy.m5557$$Nest$monServiceDisconnectedInternal(this.this$0);
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(final ComponentName name) {
            MediaRoute2ProviderServiceProxy.m5549$$Nest$fgetmHandler(this.this$0).post(new MediaRoute2ProviderServiceProxy$ServiceConnectionImpl$$ExternalSyntheticLambda2(this, name));
        }

        private /* synthetic */ void lambda$onBindingDied$2(ComponentName name) {
            MediaRoute2ProviderServiceProxy.m5551$$Nest$monBindingDiedInternal(this.this$0, name);
        }
    }

    public interface SystemMediaSessionCallback {
        void onRequestFailed(long r1, int r3);

        void onSessionReleased();

        void onSessionUpdate(RoutingSessionInfo r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Qthpo6vjs-6QVrccoDGj86fRymI, reason: not valid java name */
    public static /* synthetic */ boolean m5547$r8$lambda$Qthpo6vjs6QVrccoDGj86fRymI(String r0, RoutingSessionInfo r1) {
        return lambda$onSessionCreated$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Xqe-hbMlgSdqkrJYHynRqEy7hv8, reason: not valid java name */
    public static /* synthetic */ boolean m5548$r8$lambda$XqehbMlgSdqkrJYHynRqEy7hv8(String r0, RoutingSessionInfo r1) {
        return lambda$onSessionCreated$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m5549$$Nest$fgetmHandler(MediaRoute2ProviderServiceProxy r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSupportsSystemMediaRouting, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5550$$Nest$fgetmSupportsSystemMediaRouting(MediaRoute2ProviderServiceProxy r0) {
        return r0.mSupportsSystemMediaRouting;
    }

    /* JADX INFO: renamed from: -$$Nest$monBindingDiedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5551$$Nest$monBindingDiedInternal(MediaRoute2ProviderServiceProxy r0, ComponentName r1) {
        r0.onBindingDiedInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monConnectionDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5552$$Nest$monConnectionDied(MediaRoute2ProviderServiceProxy r0, Connection r1) {
        r0.onConnectionDied(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monConnectionReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5553$$Nest$monConnectionReady(MediaRoute2ProviderServiceProxy r0, Connection r1) {
        r0.onConnectionReady(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monProviderUpdated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5554$$Nest$monProviderUpdated(MediaRoute2ProviderServiceProxy r0, Connection r1, MediaRoute2ProviderInfo r2) {
        r0.onProviderUpdated(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monRequestFailed, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5555$$Nest$monRequestFailed(MediaRoute2ProviderServiceProxy r0, Connection r1, long r2, int r4) {
        r0.onRequestFailed(r1, r2, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$monServiceConnectedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5556$$Nest$monServiceConnectedInternal(MediaRoute2ProviderServiceProxy r0, IBinder r1) {
        r0.onServiceConnectedInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monServiceDisconnectedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5557$$Nest$monServiceDisconnectedInternal(MediaRoute2ProviderServiceProxy r0) {
        r0.onServiceDisconnectedInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$monSessionCreated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5558$$Nest$monSessionCreated(MediaRoute2ProviderServiceProxy r0, Connection r1, long r2, RoutingSessionInfo r4) {
        r0.onSessionCreated(r1, r2, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$monSessionReleased, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5559$$Nest$monSessionReleased(MediaRoute2ProviderServiceProxy r0, Connection r1, RoutingSessionInfo r2) {
        r0.onSessionReleased(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monSessionsUpdated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5560$$Nest$monSessionsUpdated(MediaRoute2ProviderServiceProxy r0, Connection r1, List r2) {
        r0.onSessionsUpdated(r1, r2);
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    MediaRoute2ProviderServiceProxy(Context context, Looper looper, ComponentName componentName, boolean isSelfScanOnlyProvider, boolean supportsSystemMediaRouting, int userId) {
        super(componentName, false);
        this.mExt = IMediaRouterServiceExt.get(this);
        this.mServiceConnection = new ServiceConnectionImpl(this, null);
        this.mLastDiscoveryPreference = null;
        this.mLastDiscoveryPreferenceIncludesThisPackage = false;
        this.mReleasingSessions = new ArrayList();
        context.getClass();
        this.mContext = context;
        this.mRequestIdToSessionCreationRequest = new LongSparseArray();
        this.mSessionOriginalIdToTransferRequest = new HashMap();
        this.mRequestIdToSystemSessionRequest = new LongSparseArray();
        this.mSystemSessionCallbacks = new ArrayMap();
        this.mIsSelfScanOnlyProvider = isSelfScanOnlyProvider;
        this.mSupportsSystemMediaRouting = supportsSystemMediaRouting;
        this.mUserId = userId;
        this.mHandler = new Handler(looper);
    }

    public void setManagerScanning(boolean managerScanning) {
        if (this.mIsManagerScanning == managerScanning) goto L6;
        this.mIsManagerScanning = managerScanning;
        updateBinding();
        return;
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void requestCreateSession(long requestId, String packageName, String routeOriginalId, Bundle sessionHints, int transferReason, UserHandle transferInitiatorUserHandle, String transferInitiatorPackageName) {
        if (this.mConnectionReady == false) goto L12;
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mRequestIdToSessionCreationRequest.put(requestId, new MediaRoute2Provider.SessionCreationOrTransferRequest(requestId, routeOriginalId, transferReason, transferInitiatorUserHandle, transferInitiatorPackageName));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        this.mActiveConnection.requestCreateSession(requestId, packageName, routeOriginalId, sessionHints);
        updateBinding();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void releaseSession(long requestId, String sessionId) {
        if (this.mConnectionReady == false) goto L12;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSessionOriginalIdToTransferRequest.remove(sessionId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.mActiveConnection.releaseSession(requestId, sessionId);
        updateBinding();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void updateDiscoveryPreference(Set<String> activelyScanningPackages, RouteDiscoveryPreference discoveryPreference) {
        this.mLastDiscoveryPreference = discoveryPreference;
        this.mLastDiscoveryPreferenceIncludesThisPackage = activelyScanningPackages.contains(this.mComponentName.getPackageName());
        if (this.mConnectionReady == false) goto L5;
        this.mActiveConnection.updateDiscoveryPreference(discoveryPreference);
    L5:
        updateBinding();
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void selectRoute(long requestId, String sessionId, String routeId) {
        if (this.mConnectionReady == false) goto L6;
        this.mActiveConnection.selectRoute(requestId, sessionId, routeId);
        return;
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void deselectRoute(long requestId, String sessionId, String routeId) {
        if (this.mConnectionReady == false) goto L6;
        this.mActiveConnection.deselectRoute(requestId, sessionId, routeId);
        return;
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void transferToRoute(long requestId, UserHandle transferInitiatorUserHandle, String transferInitiatorPackageName, String sessionOriginalId, String routeOriginalId, int transferReason) {
        if (this.mConnectionReady == false) goto L12;
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mSessionOriginalIdToTransferRequest.put(sessionOriginalId, new MediaRoute2Provider.SessionCreationOrTransferRequest(requestId, routeOriginalId, transferReason, transferInitiatorUserHandle, transferInitiatorPackageName));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        this.mActiveConnection.transferToRoute(requestId, sessionOriginalId, routeOriginalId);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void setRouteVolume(long requestId, String routeOriginalId, int volume) {
        if (this.mConnectionReady == false) goto L6;
        this.mActiveConnection.setRouteVolume(requestId, routeOriginalId, volume);
        updateBinding();
        return;
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void setSessionVolume(long requestId, String sessionOriginalId, int volume) {
        if (this.mConnectionReady == false) goto L6;
        this.mActiveConnection.setSessionVolume(requestId, sessionOriginalId, volume);
        updateBinding();
        return;
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public void prepareReleaseSession(String sessionUniqueId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<RoutingSessionInfo> r1 = this.mSessionInfos.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L13;
        RoutingSessionInfo session = r1.next();     // Catch: Throwable -> L10
        if (TextUtils.equals(session.getId(), sessionUniqueId) == false) goto L6;
        this.mSessionInfos.remove(session);     // Catch: Throwable -> L10
        this.mReleasingSessions.add(session);     // Catch: Throwable -> L10
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void requestCreateSystemMediaSession(long requestId, int uid, String packageName, String routeId, Bundle sessionHints, SystemMediaSessionCallback callback) {
        throw new IllegalStateException("Unexpected call to requestCreateSystemMediaSession. Governing flag is disabled.");
    }

    @Override // com.android.server.media.MediaRoute2Provider
    public boolean hasComponentName(String packageName, String className) {
        if (this.mComponentName.getPackageName().equals(packageName) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mComponentName.getClassName().equals(className) == false) goto L7;
        return true;
    }

    public void start(boolean rebindIfDisconnected) {
        if (this.mRunning == false) goto L5;
    L8:
        if (rebindIfDisconnected == true) goto L10;
        return;
    L10:
        if (this.mActiveConnection == null) goto L12;
        return;
    L12:
        if (shouldBind() == false) goto L17;
        unbind();
        bind();
        return;
    L17:
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, this + ": Starting");
    L7:
        this.mRunning = true;
        this.mExt.start_onEnd(this.mComponentName.flattenToShortString());
        goto L8
    }

    public void stop() {
        if (this.mRunning == true) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, this + ": Stopping");
    L7:
        this.mRunning = false;
        updateBinding();
        this.mExt.stop_onEnd(this.mComponentName.flattenToShortString());
    }

    private void updateBinding() {
        if (shouldBind() == false) goto L5;
        bind();
        return;
    L5:
        unbind();
    }

    private boolean shouldBind() {
        if (this.mRunning == true) goto L6;
        return false;
    L6:
        if (this.mIsManagerScanning == true) goto L8;
    L8:
        if (this.mLastDiscoveryPreference != null) goto L10;
    L14:
        boolean bindDueToSystemMediaRoutingSupport = false;
    L16:
        if (getSessionInfos().isEmpty() == false) goto L35;
        if (0 != 0) goto L35;
        if (0 != 0) goto L35;
        if (bindDueToSystemMediaRoutingSupport == true) goto L35;
        if (this.mLastDiscoveryPreference != null) goto L24;
    L26:
        boolean anAppIsScanning = false;
    L28:
        if (anAppIsScanning == true) goto L30;
        return false;
    L30:
        if (this.mLastDiscoveryPreferenceIncludesThisPackage == true) goto L34;
        if (this.mIsSelfScanOnlyProvider == false) goto L34;
        return false;
    L34:
        return true;
    L24:
        if (this.mLastDiscoveryPreference.getPreferredFeatures().isEmpty() == true) goto L26;
        anAppIsScanning = true;
    L35:
        return true;
    L10:
        if (this.mLastDiscoveryPreference.shouldPerformActiveScan() == false) goto L14;
        if (this.mSupportsSystemMediaRouting == false) goto L14;
        bindDueToSystemMediaRoutingSupport = true;
        goto L16
    }

    private void bind() {
        if (this.mBound == false) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, this + ": Binding");
    L7:
        Intent service = new Intent("android.media.MediaRoute2ProviderService");
        service.setComponent(this.mComponentName);
        this.mBound = this.mContext.bindServiceAsUser(service, this.mServiceConnection, AudioFormat.AAC_MAIN, new UserHandle(this.mUserId));     // Catch: SecurityException -> L13
        if (this.mBound == false) goto L11;
    L15:
        this.mExt.bind_onEnd(this.mBound, this.mComponentName.flattenToShortString(), null);     // Catch: SecurityException -> L13
        return;
    L11:
        if (DEBUG == false) goto L15;
        Slog.d(TAG, this + ": Bind failed");     // Catch: SecurityException -> L13
    L13:
        ex = move-exception;
        if (DEBUG == false) goto L20;
        Slog.d(TAG, this + ": Bind failed", ex);
    L20:
        this.mExt.bind_onEnd(false, this.mComponentName.flattenToShortString(), ex);
    }

    private void unbind() {
        if (this.mBound == true) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, this + ": Unbinding");
    L7:
        this.mBound = false;
        disconnect();
        this.mContext.unbindService(this.mServiceConnection);
        this.mExt.unbind_onEnd(this.mComponentName.flattenToShortString());
    }

    private void onServiceConnectedInternal(IBinder service) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, this + ": Connected");
    L6:
        if (this.mBound == false) goto L19;
        disconnect();
        IMediaRoute2ProviderService serviceBinder = IMediaRoute2ProviderService.Stub.asInterface(service);
        if (serviceBinder == null) goto L17;
        Connection connection = new Connection(this, serviceBinder);
        if (connection.register() == false) goto L13;
        this.mActiveConnection = connection;
        this.mExt.onServiceConnectedInternal_onEnd(true, this.mComponentName.flattenToShortString(), null);
        return;
    L13:
        if (DEBUG == false) goto L15;
        Slog.d(TAG, this + ": Registration failed");
    L15:
        this.mExt.onServiceConnectedInternal_onEnd(false, this.mComponentName.flattenToShortString(), IMediaRouterServiceExt.ERROR_BIND_FAILED);
        return;
    L17:
        Slog.e(TAG, this + ": Service returned invalid binder");
        this.mExt.onServiceConnectedInternal_onEnd(false, this.mComponentName.flattenToShortString(), IMediaRouterServiceExt.ERROR_INVALID_BINDER);
        return;
    }

    private void onServiceDisconnectedInternal() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, this + ": Service disconnected");
    L5:
        this.mExt.onServiceDisconnectedInternal_onStart(this.mComponentName.flattenToShortString());
        disconnect();
    }

    private void onBindingDiedInternal(ComponentName name) {
        this.mExt.onBindingDiedInternal_onStart(name.flattenToShortString());
        unbind();
        Slog.w(TAG, TextUtils.formatSimple("Route provider service (%s) binding died, but we did not rebind.", new Object[]{name.toString()}));
    }

    private void onConnectionReady(Connection connection) {
        if (this.mActiveConnection != connection) goto L12;
        this.mConnectionReady = true;
        if (this.mLastDiscoveryPreference != null) goto L7;
        return;
    L7:
        if (this.mLastDiscoveryPreferenceIncludesThisPackage == false) goto L9;
        Set<String> r0 = Set.of(this.mComponentName.getPackageName());
    L10:
        updateDiscoveryPreference(r0, this.mLastDiscoveryPreference);
        return;
    L9:
        r0 = Set.of();
        goto L10
    }

    private void onConnectionDied(Connection connection) {
        if (this.mActiveConnection == connection) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, this + ": Service connection died");
    L7:
        disconnect();
    }

    private void onProviderUpdated(Connection connection, MediaRoute2ProviderInfo providerInfo) {
        if (this.mActiveConnection == connection) goto L6;
        return;
    L6:
        if (DEBUG == false) goto L8;
        Slog.d(TAG, this + ": updated");
    L8:
        setAndNotifyProviderState(providerInfo);
    }

    private void onSessionCreated(Connection connection, long requestId, RoutingSessionInfo newSession) {
        if (this.mActiveConnection == connection) goto L5;
        return;
    L5:
        if (newSession != null) goto L8;
        Slog.w(TAG, "onSessionCreated: Ignoring null session sent from " + this.mComponentName);
        return;
    L8:
        RoutingSessionInfo newSession2 = assignProviderIdForSession(newSession);
        final String newSessionId = newSession2.getId();
        Object r1 = this.mLock;
        monitor-enter(r1);
        SystemMediaSessionCallback systemMediaSessionCallback = this.mRequestIdToSystemSessionRequest.get(requestId);     // Catch: Throwable -> L15
        if (systemMediaSessionCallback == null) goto L17;
        this.mRequestIdToSystemSessionRequest.remove(requestId);     // Catch: Throwable -> L15
        this.mSystemSessionCallbacks.put(newSession2.getOriginalId(), systemMediaSessionCallback);     // Catch: Throwable -> L15
        systemMediaSessionCallback.onSessionUpdate(newSession2);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L17:
        RoutingSessionInfo newSession3 = createSessionWithPopulatedTransferInitiationDataLocked(requestId, null, newSession2);     // Catch: Throwable -> L15
        if (this.mSessionInfos.stream().anyMatch(new MediaRoute2ProviderServiceProxy$$ExternalSyntheticLambda0(newSessionId)) == false) goto L20;
    L26:
        Slog.w(TAG, "onSessionCreated: Duplicate session already exists. Ignoring.");     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L20:
        if (this.mReleasingSessions.stream().anyMatch(new MediaRoute2ProviderServiceProxy$$ExternalSyntheticLambda1(newSessionId)) == true) goto L26;
        this.mSessionInfos.add(newSession3);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        this.mCallback.onSessionCreated(this, requestId, newSession3);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$onSessionCreated$0(String newSessionId, RoutingSessionInfo session) {
        return TextUtils.equals(session.getId(), newSessionId);
    }

    private static /* synthetic */ boolean lambda$onSessionCreated$1(String newSessionId, RoutingSessionInfo session) {
        return TextUtils.equals(session.getId(), newSessionId);
    }

    private int findSessionByIdLocked(RoutingSessionInfo session) {
        int i = 0;
    L4:
        if (i >= this.mSessionInfos.size()) goto L9;
        if (TextUtils.equals(this.mSessionInfos.get(i).getId(), session.getId()) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return i;
    L9:
        return -1;
    }

    private void onSessionsUpdated(Connection connection, List<RoutingSessionInfo> sessions) {
        if (this.mActiveConnection == connection) goto L5;
        return;
    L5:
        int targetIndex = 0;
        Object r1 = this.mLock;
        monitor-enter(r1);
        Iterator<RoutingSessionInfo> r2 = sessions.iterator();     // Catch: Throwable -> L21
    L9:
        if (r2.hasNext() == false) goto L32;
        RoutingSessionInfo session = r2.next();     // Catch: Throwable -> L21
        if (session == null) goto L9;
        RoutingSessionInfo session2 = assignProviderIdForSession(session);     // Catch: Throwable -> L21
        int sourceIndex = findSessionByIdLocked(session2);     // Catch: Throwable -> L21
        if (sourceIndex < 0) goto L16;
        if (sourceIndex < targetIndex) goto L24;
        RoutingSessionInfo oldSessionInfo = this.mSessionInfos.get(sourceIndex);     // Catch: Throwable -> L21
        RoutingSessionInfo session3 = createSessionWithPopulatedTransferInitiationDataLocked(0, oldSessionInfo, session2);     // Catch: Throwable -> L21
        this.mSessionInfos.set(sourceIndex, session3);     // Catch: Throwable -> L21
        int targetIndex2 = targetIndex + 1;
        Collections.swap(this.mSessionInfos, sourceIndex, targetIndex);     // Catch: Throwable -> L30
        dispatchSessionUpdated(session3);     // Catch: Throwable -> L30
        targetIndex = targetIndex2;
        goto L9
    L46:
        Throwable th = th;
    L38:
        monitor-exit(r1);     // Catch: Throwable -> L30
    L30:
        th = th;
        goto L38
    L39:
        throw th;
    L24:
        Slog.w(TAG, "Ignoring duplicate session ID: " + session2.getId());     // Catch: Throwable -> L21
        goto L9
    L16:
        int targetIndex3 = targetIndex + 1;
        this.mSessionInfos.add(targetIndex, session2);     // Catch: Throwable -> L19
        dispatchSessionCreated(0, session2);     // Catch: Throwable -> L19
        targetIndex = targetIndex3;
    L19:
        th = th;
        goto L38
    L32:
        int i = this.mSessionInfos.size() - 1;     // Catch: Throwable -> L21
    L33:
        if (i < targetIndex) goto L36;
        RoutingSessionInfo releasedSession = this.mSessionInfos.remove(i);     // Catch: Throwable -> L21
        this.mSessionOriginalIdToTransferRequest.remove(releasedSession.getId());     // Catch: Throwable -> L21
        dispatchSessionReleased(releasedSession);     // Catch: Throwable -> L21
        i = i - 1;     // Catch: Throwable -> L21
        goto L33
    L36:
        monitor-exit(r1);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        th = th;
        goto L38
    }

    private RoutingSessionInfo createSessionWithPopulatedTransferInitiationDataLocked(long requestId, RoutingSessionInfo oldSessionInfo, RoutingSessionInfo newSessionInfo) {
        if (oldSessionInfo == null) goto L4;
        MediaRoute2Provider.SessionCreationOrTransferRequest pendingRequest = this.mSessionOriginalIdToTransferRequest.get(newSessionInfo.getOriginalId());
    L5:
        boolean pendingTargetRouteInTransferableRoutes = false;
        if (pendingRequest != null) goto L8;
    L10:
        boolean pendingTargetRouteInSelectedRoutes = false;
    L12:
        if (pendingRequest != null) goto L14;
    L18:
        if (pendingTargetRouteInSelectedRoutes == false) goto L20;
        int transferReason = pendingRequest.mTransferReason;
        UserHandle transferInitiatorUserHandle = pendingRequest.mTransferInitiatorUserHandle;
        String transferInitiatorPackageName = pendingRequest.mTransferInitiatorPackageName;
    L23:
        if (pendingTargetRouteInSelectedRoutes == true) goto L25;
        if (pendingTargetRouteInTransferableRoutes == false) goto L25;
    L30:
        return new RoutingSessionInfo.Builder(newSessionInfo).setTransferInitiator(transferInitiatorUserHandle, transferInitiatorPackageName).setTransferReason(transferReason).build();
    L25:
        if (oldSessionInfo == null) goto L27;
        this.mSessionOriginalIdToTransferRequest.remove(newSessionInfo.getId());
        goto L30
    L27:
        if (pendingRequest == null) goto L30;
        this.mRequestIdToSessionCreationRequest.remove(pendingRequest.mRequestId);
        goto L30
    L20:
        if (oldSessionInfo == null) goto L22;
        transferReason = oldSessionInfo.getTransferReason();
        transferInitiatorUserHandle = oldSessionInfo.getTransferInitiatorUserHandle();
        transferInitiatorPackageName = oldSessionInfo.getTransferInitiatorPackageName();
        goto L23
    L22:
        transferReason = 0;
        transferInitiatorUserHandle = UserHandle.of(this.mUserId);
        transferInitiatorPackageName = newSessionInfo.getClientPackageName();
        goto L23
    L14:
        if (pendingRequest.isTargetRouteIdInRouteUniqueIdList(newSessionInfo.getTransferableRoutes()) == false) goto L18;
        pendingTargetRouteInTransferableRoutes = true;
        goto L18
    L8:
        if (pendingRequest.isTargetRouteIdInRouteUniqueIdList(newSessionInfo.getSelectedRoutes()) == false) goto L10;
        pendingTargetRouteInSelectedRoutes = true;
        goto L12
    L4:
        pendingRequest = this.mRequestIdToSessionCreationRequest.get(requestId);
        goto L5
    }

    private void onSessionReleased(Connection connection, RoutingSessionInfo releasedSession) {
        if (this.mActiveConnection == connection) goto L5;
        return;
    L5:
        if (releasedSession != null) goto L8;
        Slog.w(TAG, "onSessionReleased: Ignoring null session sent from " + this.mComponentName);
        return;
    L8:
        RoutingSessionInfo releasedSession2 = assignProviderIdForSession(releasedSession);
        boolean found = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
        SystemMediaSessionCallback sessionCallback = this.mSystemSessionCallbacks.get(releasedSession2.getOriginalId());     // Catch: Throwable -> L15
        if (sessionCallback == null) goto L17;
        sessionCallback.onSessionReleased();     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L17:
        this.mSessionOriginalIdToTransferRequest.remove(releasedSession2.getId());     // Catch: Throwable -> L15
        Iterator<RoutingSessionInfo> r3 = this.mSessionInfos.iterator();     // Catch: Throwable -> L15
    L19:
        if (r3.hasNext() == false) goto L24;
        RoutingSessionInfo session = r3.next();     // Catch: Throwable -> L15
        if (TextUtils.equals(session.getId(), releasedSession2.getId()) == false) goto L19;
        this.mSessionInfos.remove(session);     // Catch: Throwable -> L15
        found = true;
    L24:
        if (found == true) goto L34;
        Iterator<RoutingSessionInfo> r4 = this.mReleasingSessions.iterator();     // Catch: Throwable -> L15
    L27:
        if (r4.hasNext() == false) goto L34;
        RoutingSessionInfo session2 = r4.next();     // Catch: Throwable -> L15
        if (TextUtils.equals(session2.getId(), releasedSession2.getId()) == false) goto L27;
        this.mReleasingSessions.remove(session2);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L34:
        monitor-exit(r1);     // Catch: Throwable -> L15
        if (found == true) goto L38;
        Slog.w(TAG, "onSessionReleased: Matching session info not found");
        return;
    L38:
        this.mCallback.onSessionReleased(this, releasedSession2);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void dispatchSessionCreated(long requestId, RoutingSessionInfo session) {
        Handler r0 = this.mHandler;
        final MediaRoute2Provider.Callback r1 = this.mCallback;
        r1.getClass();
        r0.sendMessage(PooledLambda.obtainMessage(new MediaRoute2ProviderServiceProxy$$ExternalSyntheticLambda4(r1), this, Long.valueOf(requestId), session));
    }

    private void dispatchSessionUpdated(RoutingSessionInfo session) {
        Handler r0 = this.mHandler;
        final MediaRoute2Provider.Callback r1 = this.mCallback;
        r1.getClass();
        r0.sendMessage(PooledLambda.obtainMessage(new MediaRoute2ProviderServiceProxy$$ExternalSyntheticLambda2(r1), this, session, Set.of()));
    }

    private void dispatchSessionReleased(RoutingSessionInfo session) {
        Handler r0 = this.mHandler;
        final MediaRoute2Provider.Callback r1 = this.mCallback;
        r1.getClass();
        r0.sendMessage(PooledLambda.obtainMessage(new MediaRoute2ProviderServiceProxy$$ExternalSyntheticLambda3(r1), this, session));
    }

    private RoutingSessionInfo assignProviderIdForSession(RoutingSessionInfo sessionInfo) {
        return new RoutingSessionInfo.Builder(sessionInfo).setOwnerPackageName(this.mComponentName.getPackageName()).setProviderId(getUniqueId()).build();
    }

    private void onRequestFailed(Connection connection, long requestId, int reason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mRequestIdToSessionCreationRequest.remove(requestId);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        if (this.mActiveConnection == connection) goto L10;
        return;
    L10:
        if (requestId != 0) goto L13;
        Slog.w(TAG, "onRequestFailed: Ignoring requestId REQUEST_ID_NONE");
        return;
    L13:
        this.mCallback.onRequestFailed(this, requestId, reason);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void disconnect() {
        if (this.mActiveConnection == null) goto L17;
        this.mConnectionReady = false;
        this.mActiveConnection.dispose();
        this.mActiveConnection = null;
        setAndNotifyProviderState(null);
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<RoutingSessionInfo> r1 = this.mSessionInfos.iterator();     // Catch: Throwable -> L10
    L8:
        if (r1.hasNext() == false) goto L12;
        RoutingSessionInfo sessionInfo = r1.next();     // Catch: Throwable -> L10
        this.mCallback.onSessionReleased(this, sessionInfo);     // Catch: Throwable -> L10
        goto L8
    L12:
        this.mSessionInfos.clear();     // Catch: Throwable -> L10
        this.mReleasingSessions.clear();     // Catch: Throwable -> L10
        this.mRequestIdToSessionCreationRequest.clear();     // Catch: Throwable -> L10
        this.mSessionOriginalIdToTransferRequest.clear();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.MediaRoute2Provider
    protected String getDebugString() {
        Object r1 = this.mLock;
        monitor-enter(r1);
        int pendingSessionCreationCount = this.mRequestIdToSessionCreationRequest.size();     // Catch: Throwable -> L12
        int pendingTransferCount = this.mSessionOriginalIdToTransferRequest.size();     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        String r4 = this.mComponentName.getPackageName();
        Boolean r5 = Boolean.valueOf(this.mBound);
        if (this.mActiveConnection == null) goto L9;
        boolean r3 = true;
    L11:
        return TextUtils.formatSimple("ProviderServiceProxy - package: %s, bound: %b, connection (active:%b, ready:%b), system media=%b, pending (session creations: %d, transfers: %d)", new Object[]{r4, r5, Boolean.valueOf(r3), Boolean.valueOf(this.mConnectionReady), Boolean.valueOf(this.mSupportsSystemMediaRouting), Integer.valueOf(pendingSessionCreationCount), Integer.valueOf(pendingTransferCount)});
    L9:
        r3 = false;
    L12:
        th = move-exception;
        throw th;
    }
}
