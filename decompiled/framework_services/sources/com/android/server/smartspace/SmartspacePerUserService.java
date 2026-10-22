package com.android.server.smartspace;

import android.app.AppGlobals;
import android.app.smartspace.ISmartspaceCallback;
import android.app.smartspace.SmartspaceConfig;
import android.app.smartspace.SmartspaceSessionId;
import android.app.smartspace.SmartspaceTargetEvent;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.service.smartspace.ISmartspaceService;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.internal.infra.AbstractRemoteService;
import com.android.server.infra.AbstractPerUserSystemService;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class SmartspacePerUserService extends AbstractPerUserSystemService<SmartspacePerUserService, SmartspaceManagerService> implements RemoteSmartspaceService.RemoteSmartspaceServiceCallbacks {
    private static final String TAG = null;
    private RemoteSmartspaceService mRemoteService;
    private final ArrayMap<SmartspaceSessionId, SmartspaceSessionInfo> mSessionInfos;
    private boolean mZombie;

    private static final class SmartspaceSessionInfo {
        private static final boolean DEBUG = false;
        private final RemoteCallbackList<ISmartspaceCallback> mCallbacks;
        final IBinder.DeathRecipient mDeathRecipient;
        private final SmartspaceSessionId mSessionId;
        private final SmartspaceConfig mSmartspaceConfig;
        final IBinder mToken;

        public static /* synthetic */ void $r8$lambda$i51e0EerH4mLYSvHbasf_wgNdV8(SmartspaceSessionInfo r0, SmartspacePerUserService r1, ISmartspaceCallback r2) {
            r0.lambda$resurrectSessionLocked$0(r1, r2);
        }

        SmartspaceSessionInfo(SmartspaceSessionId id, SmartspaceConfig context, IBinder token, IBinder.DeathRecipient deathRecipient) {
            this.mCallbacks = new RemoteCallbackList();
            this.mSessionId = id;
            this.mSmartspaceConfig = context;
            this.mToken = token;
            this.mDeathRecipient = deathRecipient;
        }

        void addCallbackLocked(ISmartspaceCallback callback) {
            this.mCallbacks.register(callback);
        }

        void removeCallbackLocked(ISmartspaceCallback callback) {
            this.mCallbacks.unregister(callback);
        }

        boolean linkToDeath() {
            this.mToken.linkToDeath(this.mDeathRecipient, 0);     // Catch: RemoteException -> L6
            return true;
        L7:
            return false;
        }

        void destroy() {
            if (this.mToken == null) goto L5;
            this.mToken.unlinkToDeath(this.mDeathRecipient, 0);
        L5:
            this.mCallbacks.kill();
        }

        void resurrectSessionLocked(final SmartspacePerUserService service, IBinder token) {
            this.mCallbacks.getRegisteredCallbackCount();
            service.onCreateSmartspaceSessionLocked(this.mSmartspaceConfig, this.mSessionId, token);
            this.mCallbacks.broadcast(new SmartspacePerUserService$SmartspaceSessionInfo$$ExternalSyntheticLambda0(this, service));
        }

        private /* synthetic */ void lambda$resurrectSessionLocked$0(SmartspacePerUserService service, ISmartspaceCallback callback) {
            service.registerSmartspaceUpdatesLocked(this.mSessionId, callback);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-N1pBvBT33mDHPhscw34vXDyQOk, reason: not valid java name */
    public static /* synthetic */ void m8174$r8$lambda$N1pBvBT33mDHPhscw34vXDyQOk(SmartspacePerUserService r0, SmartspaceSessionId r1) {
        r0.lambda$onCreateSmartspaceSessionLocked$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$IY5l97yD8StPG1WT8TyJe1isNvQ(SmartspaceSessionId r0, SmartspaceTargetEvent r1, ISmartspaceService r2) {
        lambda$notifySmartspaceEventLocked$2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$TDsEcFW0ruvc7rXl2ML9ZZbwM1M(SmartspaceSessionId r0, ISmartspaceService r1) {
        lambda$onDestroyLocked$6(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$W7Kietf0V-6DcS9rDShraKv8_xg, reason: not valid java name */
    public static /* synthetic */ void m8175$r8$lambda$W7Kietf0V6DcS9rDShraKv8_xg(SmartspaceSessionId r0, ISmartspaceService r1) {
        lambda$requestSmartspaceUpdateLocked$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ajl3pwMUnhEiElW7LvGjEnEnSOw(SmartspaceSessionId r0, ISmartspaceCallback r1, ISmartspaceService r2) {
        lambda$unregisterSmartspaceUpdatesLocked$5(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$m7fVO1E9xzG7iEF5J5rbwrd_T4M(SmartspaceSessionId r0, ISmartspaceCallback r1, ISmartspaceService r2) {
        lambda$registerSmartspaceUpdatesLocked$4(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$t2U8r44TTh9gdSgeFgr3QSLD3nU(SmartspaceConfig r0, SmartspaceSessionId r1, ISmartspaceService r2) {
        lambda$onCreateSmartspaceSessionLocked$0(r0, r1, r2);
    }

    public /* bridge */ /* synthetic */ void onServiceDied(Object r1) {
        onServiceDied((RemoteSmartspaceService) r1);
    }

    static {
        TAG = SmartspacePerUserService.class.getSimpleName();
    }

    protected SmartspacePerUserService(SmartspaceManagerService master, Object lock, int userId) {
        super(master, lock, userId);
        this.mSessionInfos = new ArrayMap();
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected ServiceInfo newServiceInfoLocked(ComponentName serviceComponent) throws PackageManager.NameNotFoundException {
        ServiceInfo si = AppGlobals.getPackageManager().getServiceInfo(serviceComponent, 128, this.mUserId);     // Catch: RemoteException -> L4
        return si;
    L6:
        throw new PackageManager.NameNotFoundException("Could not get service for " + serviceComponent);
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected boolean updateLocked(boolean disabled) {
        boolean enabledChanged = super.updateLocked(disabled);
        if (enabledChanged == true) goto L5;
    L8:
        return enabledChanged;
    L5:
        if (isEnabledLocked() == false) goto L7;
        resurrectSessionsLocked();
        goto L8
    L7:
        updateRemoteServiceLocked();
        goto L8
    }

    public void onCreateSmartspaceSessionLocked(final SmartspaceConfig smartspaceConfig, final SmartspaceSessionId sessionId, IBinder token) {
        boolean serviceExists = resolveService(sessionId, new SmartspacePerUserService$$ExternalSyntheticLambda2(smartspaceConfig, sessionId));
        if (serviceExists == true) goto L5;
        return;
    L5:
        if (this.mSessionInfos.containsKey(sessionId) == true) goto L12;
        SmartspaceSessionInfo sessionInfo = new SmartspaceSessionInfo(sessionId, smartspaceConfig, token, new SmartspacePerUserService$$ExternalSyntheticLambda3(this, sessionId));
        if (sessionInfo.linkToDeath() == false) goto L9;
        this.mSessionInfos.put(sessionId, sessionInfo);
        return;
    L9:
        onDestroyLocked(sessionId);
        return;
    }

    private static /* synthetic */ void lambda$onCreateSmartspaceSessionLocked$0(SmartspaceConfig smartspaceConfig, SmartspaceSessionId sessionId, ISmartspaceService s) throws RemoteException {
        s.onCreateSmartspaceSession(smartspaceConfig, sessionId);
    }

    private /* synthetic */ void lambda$onCreateSmartspaceSessionLocked$1(SmartspaceSessionId sessionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        onDestroyLocked(sessionId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifySmartspaceEventLocked(final SmartspaceSessionId sessionId, final SmartspaceTargetEvent event) {
        SmartspaceSessionInfo sessionInfo = this.mSessionInfos.get(sessionId);
        if (sessionInfo != null) goto L5;
        return;
    L5:
        resolveService(sessionId, new SmartspacePerUserService$$ExternalSyntheticLambda1(sessionId, event));
    }

    private static /* synthetic */ void lambda$notifySmartspaceEventLocked$2(SmartspaceSessionId sessionId, SmartspaceTargetEvent event, ISmartspaceService s) throws RemoteException {
        s.notifySmartspaceEvent(sessionId, event);
    }

    public void requestSmartspaceUpdateLocked(final SmartspaceSessionId sessionId) {
        SmartspaceSessionInfo sessionInfo = this.mSessionInfos.get(sessionId);
        if (sessionInfo != null) goto L5;
        return;
    L5:
        resolveService(sessionId, new SmartspacePerUserService$$ExternalSyntheticLambda6(sessionId));
    }

    private static /* synthetic */ void lambda$requestSmartspaceUpdateLocked$3(SmartspaceSessionId sessionId, ISmartspaceService s) throws RemoteException {
        s.requestSmartspaceUpdate(sessionId);
    }

    public void registerSmartspaceUpdatesLocked(final SmartspaceSessionId sessionId, final ISmartspaceCallback callback) {
        SmartspaceSessionInfo sessionInfo = this.mSessionInfos.get(sessionId);
        if (sessionInfo != null) goto L5;
        return;
    L5:
        boolean serviceExists = resolveService(sessionId, new SmartspacePerUserService$$ExternalSyntheticLambda5(sessionId, callback));
        if (serviceExists == false) goto L9;
        sessionInfo.addCallbackLocked(callback);
        return;
    }

    private static /* synthetic */ void lambda$registerSmartspaceUpdatesLocked$4(SmartspaceSessionId sessionId, ISmartspaceCallback callback, ISmartspaceService s) throws RemoteException {
        s.registerSmartspaceUpdates(sessionId, callback);
    }

    public void unregisterSmartspaceUpdatesLocked(final SmartspaceSessionId sessionId, final ISmartspaceCallback callback) {
        SmartspaceSessionInfo sessionInfo = this.mSessionInfos.get(sessionId);
        if (sessionInfo != null) goto L5;
        return;
    L5:
        boolean serviceExists = resolveService(sessionId, new SmartspacePerUserService$$ExternalSyntheticLambda4(sessionId, callback));
        if (serviceExists == false) goto L9;
        sessionInfo.removeCallbackLocked(callback);
        return;
    }

    private static /* synthetic */ void lambda$unregisterSmartspaceUpdatesLocked$5(SmartspaceSessionId sessionId, ISmartspaceCallback callback, ISmartspaceService s) throws RemoteException {
        s.unregisterSmartspaceUpdates(sessionId, callback);
    }

    public void onDestroyLocked(final SmartspaceSessionId sessionId) {
        if (isDebug() == false) goto L5;
        Slog.d(TAG, "onDestroyLocked(): sessionId=" + sessionId);
    L5:
        SmartspaceSessionInfo sessionInfo = this.mSessionInfos.remove(sessionId);
        if (sessionInfo != null) goto L8;
        return;
    L8:
        resolveService(sessionId, new SmartspacePerUserService$$ExternalSyntheticLambda0(sessionId));
        sessionInfo.destroy();
    }

    private static /* synthetic */ void lambda$onDestroyLocked$6(SmartspaceSessionId sessionId, ISmartspaceService s) throws RemoteException {
        s.onDestroySmartspaceSession(sessionId);
    }

    @Override // com.android.server.smartspace.RemoteSmartspaceService.RemoteSmartspaceServiceCallbacks
    public void onFailureOrTimeout(boolean timedOut) {
        if (isDebug() == false) goto L6;
        Slog.d(TAG, "onFailureOrTimeout(): timed out=" + timedOut);
        return;
    }

    @Override // com.android.server.smartspace.RemoteSmartspaceService.RemoteSmartspaceServiceCallbacks
    public void onConnectedStateChanged(boolean connected) {
        if (isDebug() == false) goto L5;
        Slog.d(TAG, "onConnectedStateChanged(): connected=" + connected);
    L5:
        if (connected == false) goto L22;
        Object r0 = this.mLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L9:
        if (this.mZombie == true) goto L11;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L11:
        if (this.mRemoteService != null) goto L17;
        Slog.w(TAG, "Cannot resurrect sessions because remote service is null");     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L17:
        this.mZombie = false;     // Catch: Throwable -> L15
        resurrectSessionsLocked();     // Catch: Throwable -> L15
        goto L18
    }

    public void onServiceDied(RemoteSmartspaceService service) {
        if (isDebug() == false) goto L5;
        Slog.w(TAG, "onServiceDied(): service=" + service);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mZombie = true;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        updateRemoteServiceLocked();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void updateRemoteServiceLocked() {
        if (this.mRemoteService == null) goto L6;
        this.mRemoteService.destroy();
        this.mRemoteService = null;
        return;
    }

    void onPackageUpdatedLocked() {
        if (isDebug() == false) goto L5;
        Slog.v(TAG, "onPackageUpdatedLocked()");
    L5:
        destroyAndRebindRemoteService();
    }

    void onPackageRestartedLocked() {
        if (isDebug() == false) goto L5;
        Slog.v(TAG, "onPackageRestartedLocked()");
    L5:
        destroyAndRebindRemoteService();
    }

    private void destroyAndRebindRemoteService() {
        if (this.mRemoteService != null) goto L6;
        return;
    L6:
        if (isDebug() == false) goto L8;
        Slog.d(TAG, "Destroying the old remote service.");
    L8:
        this.mRemoteService.destroy();
        this.mRemoteService = null;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mZombie = true;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        this.mRemoteService = getRemoteServiceLocked();
        if (this.mRemoteService != null) goto L16;
        return;
    L16:
        if (isDebug() == false) goto L18;
        Slog.d(TAG, "Rebinding to the new remote service.");
    L18:
        this.mRemoteService.reconnect();
        return;
    L20:
        th = move-exception;
        throw th;
    }

    private void resurrectSessionsLocked() {
        int numSessions = this.mSessionInfos.size();
        if (isDebug() == false) goto L5;
        Slog.d(TAG, "Resurrecting remote service (" + this.mRemoteService + ") on " + numSessions + " sessions.");
    L5:
        Iterator<SmartspaceSessionInfo> r1 = this.mSessionInfos.values().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        SmartspaceSessionInfo sessionInfo = r1.next();
        sessionInfo.resurrectSessionLocked(this, sessionInfo.mToken);
        goto L7
    }

    protected boolean resolveService(SmartspaceSessionId sessionId, AbstractRemoteService.AsyncRequest<ISmartspaceService> cb) {
        RemoteSmartspaceService service = getRemoteServiceLocked();
        if (service == null) goto L5;
        service.executeOnResolvedService(cb);
    L5:
        if (service == null) goto L7;
        return true;
    L7:
        return false;
    }

    private RemoteSmartspaceService getRemoteServiceLocked() {
        if (this.mRemoteService != null) goto L12;
        String serviceName = getComponentNameLocked();
        if (serviceName == null) goto L7;
        ComponentName serviceComponent = ComponentName.unflattenFromString(serviceName);
        SmartspacePerUserService r7 = this;
        r7.mRemoteService = new RemoteSmartspaceService(getContext(), "android.service.smartspace.SmartspaceService", serviceComponent, this.mUserId, r7, ((SmartspaceManagerService) this.mMaster).isBindInstantServiceAllowed(), ((SmartspaceManagerService) this.mMaster).verbose);
    L14:
        return r7.mRemoteService;
    L7:
        if (((SmartspaceManagerService) this.mMaster).verbose == false) goto L15;
        Slog.v(TAG, "getRemoteServiceLocked(): not set");
        return null;
    L15:
        return null;
    L12:
        r7 = this;
        goto L14
    }
}
