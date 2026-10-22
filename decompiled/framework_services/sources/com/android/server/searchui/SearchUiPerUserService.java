package com.android.server.searchui;

import android.app.AppGlobals;
import android.app.search.ISearchCallback;
import android.app.search.Query;
import android.app.search.SearchContext;
import android.app.search.SearchSessionId;
import android.app.search.SearchTargetEvent;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.service.search.ISearchUiService;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.internal.infra.AbstractRemoteService;
import com.android.server.infra.AbstractPerUserSystemService;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class SearchUiPerUserService extends AbstractPerUserSystemService<SearchUiPerUserService, SearchUiManagerService> implements RemoteSearchUiService.RemoteSearchUiServiceCallbacks {
    private static final String TAG = null;
    private RemoteSearchUiService mRemoteService;
    private final ArrayMap<SearchSessionId, SearchSessionInfo> mSessionInfos;
    private boolean mZombie;

    private static final class SearchSessionInfo {
        private static final boolean DEBUG = true;
        private final RemoteCallbackList<ISearchCallback> mCallbacks;
        final IBinder.DeathRecipient mDeathRecipient;
        private final SearchContext mSearchContext;
        private final SearchSessionId mSessionId;
        final IBinder mToken;

        /* JADX INFO: renamed from: $r8$lambda$GM-px3ZBzriJKVUlO0z3IMahRFA, reason: not valid java name */
        public static /* synthetic */ void m8022$r8$lambda$GMpx3ZBzriJKVUlO0z3IMahRFA(SearchSessionInfo r0, SearchUiPerUserService r1, ISearchCallback r2) {
            r0.lambda$resurrectSessionLocked$0(r1, r2);
        }

        SearchSessionInfo(SearchSessionId id, SearchContext context, IBinder token, IBinder.DeathRecipient deathRecipient) {
            this.mCallbacks = new RemoteCallbackList();
            Slog.d(SearchUiPerUserService.m8021$$Nest$sfgetTAG(), "Creating SearchSessionInfo for session Id=" + id);
            this.mSessionId = id;
            this.mSearchContext = context;
            this.mToken = token;
            this.mDeathRecipient = deathRecipient;
        }

        void addCallbackLocked(ISearchCallback callback) {
            Slog.d(SearchUiPerUserService.m8021$$Nest$sfgetTAG(), "Storing callback for session Id=" + this.mSessionId + " and callback=" + callback.asBinder());
            this.mCallbacks.register(callback);
        }

        void removeCallbackLocked(ISearchCallback callback) {
            Slog.d(SearchUiPerUserService.m8021$$Nest$sfgetTAG(), "Removing callback for session Id=" + this.mSessionId + " and callback=" + callback.asBinder());
            this.mCallbacks.unregister(callback);
        }

        boolean linkToDeath() {
            this.mToken.linkToDeath(this.mDeathRecipient, 0);     // Catch: RemoteException -> L6
            return true;
        L7:
            Slog.w(SearchUiPerUserService.m8021$$Nest$sfgetTAG(), "Caller is dead before session can be started, sessionId: " + this.mSessionId);
            return false;
        }

        void destroy() {
            Slog.d(SearchUiPerUserService.m8021$$Nest$sfgetTAG(), "Removing all callbacks for session Id=" + this.mSessionId + " and " + this.mCallbacks.getRegisteredCallbackCount() + " callbacks.");
            if (this.mToken == null) goto L5;
            this.mToken.unlinkToDeath(this.mDeathRecipient, 0);
        L5:
            this.mCallbacks.kill();
        }

        void resurrectSessionLocked(final SearchUiPerUserService service, IBinder token) {
            int callbackCount = this.mCallbacks.getRegisteredCallbackCount();
            Slog.d(SearchUiPerUserService.m8021$$Nest$sfgetTAG(), "Resurrecting remote service (" + SearchUiPerUserService.m8020$$Nest$mgetRemoteServiceLocked(service) + ") for session Id=" + this.mSessionId + " and " + callbackCount + " callbacks.");
            service.onCreateSearchSessionLocked(this.mSearchContext, this.mSessionId, token);
            this.mCallbacks.broadcast(new SearchUiPerUserService$SearchSessionInfo$$ExternalSyntheticLambda0(this, service));
        }

        private /* synthetic */ void lambda$resurrectSessionLocked$0(SearchUiPerUserService service, ISearchCallback callback) {
            service.registerEmptyQueryResultUpdateCallbackLocked(this.mSessionId, callback);
        }
    }

    public static /* synthetic */ void $r8$lambda$BdZWF3bFvbwgU45BKdKDCcm6ueQ(SearchSessionId r0, Query r1, ISearchCallback r2, ISearchUiService r3) {
        lambda$queryLocked$3(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$DV1I4V-jodnXvFvmnt0TTp_7Nfc, reason: not valid java name */
    public static /* synthetic */ void m8019$r8$lambda$DV1I4VjodnXvFvmnt0TTp_7Nfc(SearchUiPerUserService r0, SearchSessionId r1) {
        r0.lambda$onCreateSearchSessionLocked$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$EoUfS3_FBEODTuzVH5dAjxRYbZ0(SearchContext r0, SearchSessionId r1, ISearchUiService r2) {
        lambda$onCreateSearchSessionLocked$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$OhDPF3m2CqC_XY1AgUrcs3n4PHY(SearchSessionId r0, Query r1, SearchTargetEvent r2, ISearchUiService r3) {
        lambda$notifyLocked$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$TlGm_b1Q9BbL5OdMr1loI8hEdmk(SearchSessionId r0, ISearchUiService r1) {
        lambda$onDestroyLocked$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$fpCI5YS0xF44TkBsXuF0iaZk4PY(SearchSessionId r0, ISearchCallback r1, ISearchUiService r2) {
        lambda$unregisterEmptyQueryResultUpdateCallbackLocked$5(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$tEZo6IsdKJAhsIoolXMLMCpcJOg(SearchSessionId r0, ISearchCallback r1, ISearchUiService r2) {
        lambda$registerEmptyQueryResultUpdateCallbackLocked$4(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetRemoteServiceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteSearchUiService m8020$$Nest$mgetRemoteServiceLocked(SearchUiPerUserService r0) {
        return r0.getRemoteServiceLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8021$$Nest$sfgetTAG() {
        return TAG;
    }

    public /* bridge */ /* synthetic */ void onServiceDied(Object r1) {
        onServiceDied((RemoteSearchUiService) r1);
    }

    static {
        TAG = SearchUiPerUserService.class.getSimpleName();
    }

    protected SearchUiPerUserService(SearchUiManagerService master, Object lock, int userId) {
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
        updateRemoteServiceLocked();
        goto L7
    }

    public void onCreateSearchSessionLocked(final SearchContext context, final SearchSessionId sessionId, IBinder token) {
        boolean serviceExists = resolveService(sessionId, new SearchUiPerUserService$$ExternalSyntheticLambda1(context, sessionId));
        if (serviceExists == true) goto L5;
        return;
    L5:
        if (this.mSessionInfos.containsKey(sessionId) == true) goto L12;
        SearchSessionInfo sessionInfo = new SearchSessionInfo(sessionId, context, token, new SearchUiPerUserService$$ExternalSyntheticLambda2(this, sessionId));
        if (sessionInfo.linkToDeath() == false) goto L9;
        this.mSessionInfos.put(sessionId, sessionInfo);
        return;
    L9:
        onDestroyLocked(sessionId);
        return;
    }

    private static /* synthetic */ void lambda$onCreateSearchSessionLocked$0(SearchContext context, SearchSessionId sessionId, ISearchUiService s) throws RemoteException {
        s.onCreateSearchSession(context, sessionId);
    }

    private /* synthetic */ void lambda$onCreateSearchSessionLocked$1(SearchSessionId sessionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        onDestroyLocked(sessionId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyLocked(final SearchSessionId sessionId, final Query query, final SearchTargetEvent event) {
        SearchSessionInfo sessionInfo = this.mSessionInfos.get(sessionId);
        if (sessionInfo != null) goto L5;
        return;
    L5:
        resolveService(sessionId, new SearchUiPerUserService$$ExternalSyntheticLambda0(sessionId, query, event));
    }

    private static /* synthetic */ void lambda$notifyLocked$2(SearchSessionId sessionId, Query query, SearchTargetEvent event, ISearchUiService s) throws RemoteException {
        s.onNotifyEvent(sessionId, query, event);
    }

    public void queryLocked(final SearchSessionId sessionId, final Query input, final ISearchCallback callback) {
        SearchSessionInfo sessionInfo = this.mSessionInfos.get(sessionId);
        if (sessionInfo != null) goto L5;
        return;
    L5:
        resolveService(sessionId, new SearchUiPerUserService$$ExternalSyntheticLambda6(sessionId, input, callback));
    }

    private static /* synthetic */ void lambda$queryLocked$3(SearchSessionId sessionId, Query input, ISearchCallback callback, ISearchUiService s) throws RemoteException {
        s.onQuery(sessionId, input, callback);
    }

    public void registerEmptyQueryResultUpdateCallbackLocked(final SearchSessionId sessionId, final ISearchCallback callback) {
        SearchSessionInfo sessionInfo = this.mSessionInfos.get(sessionId);
        if (sessionInfo != null) goto L5;
        return;
    L5:
        boolean serviceExists = resolveService(sessionId, new SearchUiPerUserService$$ExternalSyntheticLambda3(sessionId, callback));
        if (serviceExists == false) goto L9;
        sessionInfo.addCallbackLocked(callback);
        return;
    }

    private static /* synthetic */ void lambda$registerEmptyQueryResultUpdateCallbackLocked$4(SearchSessionId sessionId, ISearchCallback callback, ISearchUiService s) throws RemoteException {
        s.onRegisterEmptyQueryResultUpdateCallback(sessionId, callback);
    }

    public void unregisterEmptyQueryResultUpdateCallbackLocked(final SearchSessionId sessionId, final ISearchCallback callback) {
        SearchSessionInfo sessionInfo = this.mSessionInfos.get(sessionId);
        if (sessionInfo != null) goto L5;
        return;
    L5:
        boolean serviceExists = resolveService(sessionId, new SearchUiPerUserService$$ExternalSyntheticLambda4(sessionId, callback));
        if (serviceExists == false) goto L9;
        sessionInfo.removeCallbackLocked(callback);
        return;
    }

    private static /* synthetic */ void lambda$unregisterEmptyQueryResultUpdateCallbackLocked$5(SearchSessionId sessionId, ISearchCallback callback, ISearchUiService s) throws RemoteException {
        s.onUnregisterEmptyQueryResultUpdateCallback(sessionId, callback);
    }

    public void onDestroyLocked(final SearchSessionId sessionId) {
        if (isDebug() == false) goto L5;
        Slog.d(TAG, "onDestroyLocked(): sessionId=" + sessionId);
    L5:
        SearchSessionInfo sessionInfo = this.mSessionInfos.remove(sessionId);
        if (sessionInfo != null) goto L8;
        return;
    L8:
        resolveService(sessionId, new SearchUiPerUserService$$ExternalSyntheticLambda5(sessionId));
        sessionInfo.destroy();
    }

    private static /* synthetic */ void lambda$onDestroyLocked$6(SearchSessionId sessionId, ISearchUiService s) throws RemoteException {
        s.onDestroy(sessionId);
    }

    @Override // com.android.server.searchui.RemoteSearchUiService.RemoteSearchUiServiceCallbacks
    public void onFailureOrTimeout(boolean timedOut) {
        if (isDebug() == false) goto L6;
        Slog.d(TAG, "onFailureOrTimeout(): timed out=" + timedOut);
        return;
    }

    @Override // com.android.server.searchui.RemoteSearchUiService.RemoteSearchUiServiceCallbacks
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

    public void onServiceDied(RemoteSearchUiService service) {
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
        Iterator<SearchSessionInfo> r1 = this.mSessionInfos.values().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        SearchSessionInfo sessionInfo = r1.next();
        sessionInfo.resurrectSessionLocked(this, sessionInfo.mToken);
        goto L7
    }

    protected boolean resolveService(SearchSessionId sessionId, AbstractRemoteService.AsyncRequest<ISearchUiService> cb) {
        RemoteSearchUiService service = getRemoteServiceLocked();
        if (service == null) goto L5;
        service.executeOnResolvedService(cb);
    L5:
        if (service == null) goto L7;
        return true;
    L7:
        return false;
    }

    private RemoteSearchUiService getRemoteServiceLocked() {
        if (this.mRemoteService != null) goto L12;
        String serviceName = getComponentNameLocked();
        if (serviceName == null) goto L7;
        ComponentName serviceComponent = ComponentName.unflattenFromString(serviceName);
        SearchUiPerUserService r7 = this;
        r7.mRemoteService = new RemoteSearchUiService(getContext(), "android.service.search.SearchUiService", serviceComponent, this.mUserId, r7, ((SearchUiManagerService) this.mMaster).isBindInstantServiceAllowed(), ((SearchUiManagerService) this.mMaster).verbose);
    L14:
        return r7.mRemoteService;
    L7:
        if (((SearchUiManagerService) this.mMaster).verbose == false) goto L15;
        Slog.v(TAG, "getRemoteServiceLocked(): not set");
        return null;
    L15:
        return null;
    L12:
        r7 = this;
        goto L14
    }
}
