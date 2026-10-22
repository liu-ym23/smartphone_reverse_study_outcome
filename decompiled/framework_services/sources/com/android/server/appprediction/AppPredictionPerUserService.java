package com.android.server.appprediction;

import android.app.AppGlobals;
import android.app.prediction.AppPredictionContext;
import android.app.prediction.AppPredictionSessionId;
import android.app.prediction.AppTargetEvent;
import android.app.prediction.IPredictionCallback;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.IRemoteCallback;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.provider.DeviceConfig;
import android.service.appprediction.IPredictionService;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.internal.infra.AbstractRemoteService;
import com.android.server.LocalServices;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.people.PeopleServiceInternal;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class AppPredictionPerUserService extends AbstractPerUserSystemService<AppPredictionPerUserService, AppPredictionManagerService> implements RemoteAppPredictionService.RemoteAppPredictionServiceCallbacks {
    private static final String PREDICT_USING_PEOPLE_SERVICE_PREFIX = "predict_using_people_service_";
    private static final String REMOTE_APP_PREDICTOR_KEY = "remote_app_predictor";
    private static final String TAG = null;
    private RemoteAppPredictionService mRemoteService;
    private final ArrayMap<AppPredictionSessionId, AppPredictionSessionInfo> mSessionInfos;
    private boolean mZombie;

    private static final class AppPredictionSessionInfo {
        private static final boolean DEBUG = false;
        private final RemoteCallbackList<IPredictionCallback> mCallbacks;
        final IBinder.DeathRecipient mDeathRecipient;
        private final AppPredictionContext mPredictionContext;
        private final AppPredictionSessionId mSessionId;
        final IBinder mToken;
        private final boolean mUsesPeopleService;

        public static /* synthetic */ void $r8$lambda$m4jO3oG5c3P0u21nKe615ZtJxzE(AppPredictionSessionInfo r0, AppPredictionPerUserService r1, IPredictionCallback r2) {
            r0.lambda$resurrectSessionLocked$0(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUsesPeopleService, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m1844$$Nest$fgetmUsesPeopleService(AppPredictionSessionInfo r0) {
            return r0.mUsesPeopleService;
        }

        AppPredictionSessionInfo(AppPredictionSessionId id, AppPredictionContext predictionContext, boolean usesPeopleService, IBinder token, IBinder.DeathRecipient deathRecipient) {
            this.mCallbacks = new RemoteCallbackList();
            this.mSessionId = id;
            this.mPredictionContext = predictionContext;
            this.mUsesPeopleService = usesPeopleService;
            this.mToken = token;
            this.mDeathRecipient = deathRecipient;
        }

        void addCallbackLocked(IPredictionCallback callback) {
            this.mCallbacks.register(callback);
        }

        void removeCallbackLocked(IPredictionCallback callback) {
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

        void resurrectSessionLocked(final AppPredictionPerUserService service, IBinder token) {
            this.mCallbacks.getRegisteredCallbackCount();
            service.onCreatePredictionSessionLocked(this.mPredictionContext, this.mSessionId, token);
            this.mCallbacks.broadcast(new AppPredictionPerUserService$AppPredictionSessionInfo$$ExternalSyntheticLambda0(this, service));
        }

        private /* synthetic */ void lambda$resurrectSessionLocked$0(AppPredictionPerUserService service, IPredictionCallback callback) {
            service.registerPredictionUpdatesLocked(this.mSessionId, callback);
        }
    }

    public static /* synthetic */ void $r8$lambda$0M4llCJ1OMgSxMQrjD4mDe5U28M(AppPredictionContext r0, AppPredictionSessionId r1, IPredictionService r2) {
        lambda$onCreatePredictionSessionLocked$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$3ufaqW8P6U06NYesQXJF9h1LFDg(AppPredictionSessionId r0, IPredictionService r1) {
        lambda$onDestroyPredictionSessionLocked$8(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$FNKQP6_y7DdBv6pfo1Ep4wSQ9X4(AppPredictionSessionId r0, AppTargetEvent r1, IPredictionService r2) {
        lambda$notifyAppTargetEventLocked$2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$M0d50QSOQtwoC_hvuMjEw9nw270(AppPredictionSessionId r0, IPredictionCallback r1, IPredictionService r2) {
        lambda$unregisterPredictionUpdatesLocked$6(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Rmvo5Nm9mSqVLkV-KREoc1ushk4, reason: not valid java name */
    public static /* synthetic */ void m1841$r8$lambda$Rmvo5Nm9mSqVLkVKREoc1ushk4(AppPredictionSessionId r0, ParceledListSlice r1, IPredictionCallback r2, IPredictionService r3) {
        lambda$sortAppTargetsLocked$4(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$jhe9Hk5Z-50y9B1JN2Y3WkZO2-4, reason: not valid java name */
    public static /* synthetic */ void m1842$r8$lambda$jhe9Hk5Z50y9B1JN2Y3WkZO24(AppPredictionPerUserService r0, AppPredictionSessionId r1) {
        r0.lambda$onCreatePredictionSessionLocked$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$lgEJNd82nZX0Y0l9piHhfp4NrPc(AppPredictionSessionId r0, IPredictionCallback r1, IPredictionService r2) {
        lambda$registerPredictionUpdatesLocked$5(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$mliZsNl13108ayIg_j4GD6Z0bnY(AppPredictionSessionId r0, IPredictionService r1) {
        lambda$requestPredictionUpdateLocked$7(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$oOMWVFdOEzmfmpUx-5SH2bBkin8, reason: not valid java name */
    public static /* synthetic */ void m1843$r8$lambda$oOMWVFdOEzmfmpUx5SH2bBkin8(AppPredictionSessionId r0, IRemoteCallback r1, IPredictionService r2) {
        lambda$requestServiceFeaturesLocked$9(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$pQ_4Htfw20fxorHT5b9IO8nKvXA(AppPredictionSessionId r0, String r1, ParceledListSlice r2, IPredictionService r3) {
        lambda$notifyLaunchLocationShownLocked$3(r0, r1, r2, r3);
    }

    public /* bridge */ /* synthetic */ void onServiceDied(Object r1) {
        onServiceDied((RemoteAppPredictionService) r1);
    }

    static {
        TAG = AppPredictionPerUserService.class.getSimpleName();
    }

    protected AppPredictionPerUserService(AppPredictionManagerService master, Object lock, int userId) {
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
    L7:
        return enabledChanged;
    L5:
        if (isEnabledLocked() == true) goto L7;
        this.mRemoteService = null;
        goto L7
    }

    public void onCreatePredictionSessionLocked(final AppPredictionContext context, final AppPredictionSessionId sessionId, IBinder token) {
        boolean usesPeopleService = DeviceConfig.getBoolean("systemui", PREDICT_USING_PEOPLE_SERVICE_PREFIX + context.getUiSurface(), false);
        if (context.getExtras() != null) goto L5;
    L9:
        boolean usesPeopleService2 = usesPeopleService;
    L10:
        boolean serviceExists = resolveService(sessionId, true, usesPeopleService2, new AppPredictionPerUserService$$ExternalSyntheticLambda1(context, sessionId));
        if (serviceExists == false) goto L19;
        if (this.mSessionInfos.containsKey(sessionId) == true) goto L19;
        AppPredictionSessionInfo sessionInfo = new AppPredictionSessionInfo(sessionId, context, usesPeopleService2, token, new AppPredictionPerUserService$$ExternalSyntheticLambda2(this, sessionId));
        if (sessionInfo.linkToDeath() == false) goto L17;
        this.mSessionInfos.put(sessionId, sessionInfo);
        return;
    L17:
        onDestroyPredictionSessionLocked(sessionId);
        return;
    L19:
        return;
    L5:
        if (context.getExtras().getBoolean(REMOTE_APP_PREDICTOR_KEY, false) == false) goto L9;
        if (DeviceConfig.getBoolean("systemui", "dark_launch_remote_prediction_service_enabled", false) == false) goto L9;
        usesPeopleService2 = false;
        goto L10
    }

    private static /* synthetic */ void lambda$onCreatePredictionSessionLocked$0(AppPredictionContext context, AppPredictionSessionId sessionId, IPredictionService s) throws RemoteException {
        s.onCreatePredictionSession(context, sessionId);
    }

    private /* synthetic */ void lambda$onCreatePredictionSessionLocked$1(AppPredictionSessionId sessionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        onDestroyPredictionSessionLocked(sessionId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyAppTargetEventLocked(final AppPredictionSessionId sessionId, final AppTargetEvent event) {
        AppPredictionSessionInfo sessionInfo = this.mSessionInfos.get(sessionId);
        if (sessionInfo != null) goto L5;
        return;
    L5:
        resolveService(sessionId, false, AppPredictionSessionInfo.m1844$$Nest$fgetmUsesPeopleService(sessionInfo), new AppPredictionPerUserService$$ExternalSyntheticLambda7(sessionId, event));
    }

    private static /* synthetic */ void lambda$notifyAppTargetEventLocked$2(AppPredictionSessionId sessionId, AppTargetEvent event, IPredictionService s) throws RemoteException {
        s.notifyAppTargetEvent(sessionId, event);
    }

    public void notifyLaunchLocationShownLocked(final AppPredictionSessionId sessionId, final String launchLocation, final ParceledListSlice targetIds) {
        AppPredictionSessionInfo sessionInfo = this.mSessionInfos.get(sessionId);
        if (sessionInfo != null) goto L5;
        return;
    L5:
        resolveService(sessionId, false, AppPredictionSessionInfo.m1844$$Nest$fgetmUsesPeopleService(sessionInfo), new AppPredictionPerUserService$$ExternalSyntheticLambda9(sessionId, launchLocation, targetIds));
    }

    private static /* synthetic */ void lambda$notifyLaunchLocationShownLocked$3(AppPredictionSessionId sessionId, String launchLocation, ParceledListSlice targetIds, IPredictionService s) throws RemoteException {
        s.notifyLaunchLocationShown(sessionId, launchLocation, targetIds);
    }

    public void sortAppTargetsLocked(final AppPredictionSessionId sessionId, final ParceledListSlice targets, final IPredictionCallback callback) {
        AppPredictionSessionInfo sessionInfo = this.mSessionInfos.get(sessionId);
        if (sessionInfo != null) goto L5;
        return;
    L5:
        resolveService(sessionId, true, AppPredictionSessionInfo.m1844$$Nest$fgetmUsesPeopleService(sessionInfo), new AppPredictionPerUserService$$ExternalSyntheticLambda0(sessionId, targets, callback));
    }

    private static /* synthetic */ void lambda$sortAppTargetsLocked$4(AppPredictionSessionId sessionId, ParceledListSlice targets, IPredictionCallback callback, IPredictionService s) throws RemoteException {
        s.sortAppTargets(sessionId, targets, callback);
    }

    public void registerPredictionUpdatesLocked(final AppPredictionSessionId sessionId, final IPredictionCallback callback) {
        AppPredictionSessionInfo sessionInfo = this.mSessionInfos.get(sessionId);
        if (sessionInfo != null) goto L5;
        return;
    L5:
        boolean serviceExists = resolveService(sessionId, true, AppPredictionSessionInfo.m1844$$Nest$fgetmUsesPeopleService(sessionInfo), new AppPredictionPerUserService$$ExternalSyntheticLambda4(sessionId, callback));
        if (serviceExists == false) goto L9;
        sessionInfo.addCallbackLocked(callback);
        return;
    }

    private static /* synthetic */ void lambda$registerPredictionUpdatesLocked$5(AppPredictionSessionId sessionId, IPredictionCallback callback, IPredictionService s) throws RemoteException {
        s.registerPredictionUpdates(sessionId, callback);
    }

    public void unregisterPredictionUpdatesLocked(final AppPredictionSessionId sessionId, final IPredictionCallback callback) {
        AppPredictionSessionInfo sessionInfo = this.mSessionInfos.get(sessionId);
        if (sessionInfo != null) goto L5;
        return;
    L5:
        boolean serviceExists = resolveService(sessionId, false, AppPredictionSessionInfo.m1844$$Nest$fgetmUsesPeopleService(sessionInfo), new AppPredictionPerUserService$$ExternalSyntheticLambda5(sessionId, callback));
        if (serviceExists == false) goto L9;
        sessionInfo.removeCallbackLocked(callback);
        return;
    }

    private static /* synthetic */ void lambda$unregisterPredictionUpdatesLocked$6(AppPredictionSessionId sessionId, IPredictionCallback callback, IPredictionService s) throws RemoteException {
        s.unregisterPredictionUpdates(sessionId, callback);
    }

    public void requestPredictionUpdateLocked(final AppPredictionSessionId sessionId) {
        AppPredictionSessionInfo sessionInfo = this.mSessionInfos.get(sessionId);
        if (sessionInfo != null) goto L5;
        return;
    L5:
        resolveService(sessionId, true, AppPredictionSessionInfo.m1844$$Nest$fgetmUsesPeopleService(sessionInfo), new AppPredictionPerUserService$$ExternalSyntheticLambda8(sessionId));
    }

    private static /* synthetic */ void lambda$requestPredictionUpdateLocked$7(AppPredictionSessionId sessionId, IPredictionService s) throws RemoteException {
        s.requestPredictionUpdate(sessionId);
    }

    public void onDestroyPredictionSessionLocked(final AppPredictionSessionId sessionId) {
        if (isDebug() == false) goto L5;
        Slog.d(TAG, "onDestroyPredictionSessionLocked(): sessionId=" + sessionId);
    L5:
        AppPredictionSessionInfo sessionInfo = this.mSessionInfos.remove(sessionId);
        if (sessionInfo != null) goto L8;
        return;
    L8:
        resolveService(sessionId, false, AppPredictionSessionInfo.m1844$$Nest$fgetmUsesPeopleService(sessionInfo), new AppPredictionPerUserService$$ExternalSyntheticLambda3(sessionId));
        sessionInfo.destroy();
    }

    private static /* synthetic */ void lambda$onDestroyPredictionSessionLocked$8(AppPredictionSessionId sessionId, IPredictionService s) throws RemoteException {
        s.onDestroyPredictionSession(sessionId);
    }

    public void requestServiceFeaturesLocked(final AppPredictionSessionId sessionId, final IRemoteCallback callback) {
        AppPredictionSessionInfo sessionInfo = this.mSessionInfos.get(sessionId);
        if (sessionInfo != null) goto L5;
        return;
    L5:
        resolveService(sessionId, true, AppPredictionSessionInfo.m1844$$Nest$fgetmUsesPeopleService(sessionInfo), new AppPredictionPerUserService$$ExternalSyntheticLambda6(sessionId, callback));
    }

    private static /* synthetic */ void lambda$requestServiceFeaturesLocked$9(AppPredictionSessionId sessionId, IRemoteCallback callback, IPredictionService s) throws RemoteException {
        s.requestServiceFeatures(sessionId, callback);
    }

    @Override // com.android.server.appprediction.RemoteAppPredictionService.RemoteAppPredictionServiceCallbacks
    public void onFailureOrTimeout(boolean timedOut) {
        if (isDebug() == false) goto L6;
        Slog.d(TAG, "onFailureOrTimeout(): timed out=" + timedOut);
        return;
    }

    @Override // com.android.server.appprediction.RemoteAppPredictionService.RemoteAppPredictionServiceCallbacks
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

    public void onServiceDied(RemoteAppPredictionService service) {
        if (isDebug() == false) goto L5;
        Slog.w(TAG, "onServiceDied(): service=" + service);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mZombie = true;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
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
        Iterator<AppPredictionSessionInfo> r1 = this.mSessionInfos.values().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        AppPredictionSessionInfo sessionInfo = r1.next();
        sessionInfo.resurrectSessionLocked(this, sessionInfo.mToken);
        goto L7
    }

    protected boolean resolveService(AppPredictionSessionId sessionId, boolean sendImmediately, boolean usesPeopleService, AbstractRemoteService.AsyncRequest<IPredictionService> cb) {
        if (usesPeopleService == false) goto L13;
        IPredictionService service = (IPredictionService) LocalServices.getService(PeopleServiceInternal.class);
        if (service != null) goto L21;
    L10:
        if (service != null) goto L12;
        return false;
    L12:
        return true;
    L21:
        cb.run(service);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        Slog.w(TAG, "Failed to invoke service:" + service, e);
        goto L10
    L13:
        RemoteAppPredictionService service2 = getRemoteServiceLocked();
        if (service2 == null) goto L18;
        if (sendImmediately == false) goto L17;
        service2.executeOnResolvedService(cb);
        goto L18
    L17:
        service2.scheduleOnResolvedService(cb);
    L18:
        if (service2 != null) goto L20;
        return false;
    L20:
        return true;
    }

    private RemoteAppPredictionService getRemoteServiceLocked() {
        if (this.mRemoteService != null) goto L12;
        String serviceName = getComponentNameLocked();
        if (serviceName == null) goto L7;
        ComponentName serviceComponent = ComponentName.unflattenFromString(serviceName);
        AppPredictionPerUserService r7 = this;
        r7.mRemoteService = new RemoteAppPredictionService(getContext(), "android.service.appprediction.AppPredictionService", serviceComponent, this.mUserId, r7, ((AppPredictionManagerService) this.mMaster).isBindInstantServiceAllowed(), ((AppPredictionManagerService) this.mMaster).verbose);
    L14:
        return r7.mRemoteService;
    L7:
        if (((AppPredictionManagerService) this.mMaster).verbose == false) goto L15;
        Slog.v(TAG, "getRemoteServiceLocked(): not set");
        return null;
    L15:
        return null;
    L12:
        r7 = this;
        goto L14
    }
}
