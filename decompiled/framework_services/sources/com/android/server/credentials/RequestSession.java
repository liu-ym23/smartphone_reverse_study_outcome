package com.android.server.credentials;

import android.R;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.credentials.CredentialProviderInfo;
import android.credentials.selection.ProviderData;
import android.credentials.selection.UserSelectionDialogResult;
import android.os.Binder;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import android.service.credentials.CallingAppInfo;
import android.util.Slog;
import com.android.server.credentials.metrics.ApiName;
import com.android.server.credentials.metrics.ApiStatus;
import com.android.server.credentials.metrics.ProviderSessionMetric;
import com.android.server.credentials.metrics.ProviderStatusForMetrics;
import com.android.server.credentials.metrics.RequestSessionMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
abstract class RequestSession<T, U, V> implements CredentialManagerUi.CredentialManagerUiCallback {
    private static final String TAG = "CredentialManager";
    private final int mCallingUid;
    protected final CancellationSignal mCancellationSignal;
    protected final CallingAppInfo mClientAppInfo;
    protected final U mClientCallback;
    protected final T mClientRequest;
    protected final Context mContext;
    protected final CredentialManagerUi mCredentialManagerUi;
    private final RequestSession<T, U, V>.RequestSessionDeathRecipient mDeathRecipient;
    private final Set<ComponentName> mEnabledProviders;
    protected final Handler mHandler;
    protected final String mHybridService;
    protected final Object mLock;
    protected PendingIntent mPendingIntent;
    protected final Map<String, ProviderSession> mProviders;
    protected final IBinder mRequestId;
    protected final RequestSessionMetric mRequestSessionMetric;
    protected RequestSessionStatus mRequestSessionStatus;
    protected final String mRequestType;
    protected final SessionLifetime mSessionCallback;
    protected final int mUniqueSessionInteger;
    protected final int mUserId;

    private class RequestSessionDeathRecipient implements IBinder.DeathRecipient {
        final /* synthetic */ RequestSession this$0;

        /* synthetic */ RequestSessionDeathRecipient(RequestSession r1, RequestSessionIA r2) {
            this(r1);
        }

        private RequestSessionDeathRecipient(RequestSession r1) {
            this.this$0 = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Slog.d(RequestSession.TAG, "Client binder died - clearing session");
            this.this$0.finishSession(RequestSession.m3316$$Nest$misUiWaitingForData(this.this$0), ApiStatus.BINDER_DIED.getMetricCode());
        }
    }

    static final enum RequestSessionStatus extends Enum<RequestSessionStatus> {
        private static final /* synthetic */ RequestSessionStatus[] $VALUES = null;
        public static final RequestSessionStatus CANCELLED = null;
        public static final RequestSessionStatus COMPLETE = null;
        public static final RequestSessionStatus IN_PROGRESS = null;

        private static /* synthetic */ RequestSessionStatus[] $values() {
            return new RequestSessionStatus[]{IN_PROGRESS, CANCELLED, COMPLETE};
        }

        private RequestSessionStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static RequestSessionStatus valueOf(String name) {
            return (RequestSessionStatus) Enum.valueOf(RequestSessionStatus.class, name);
        }

        public static RequestSessionStatus[] values() {
            return (RequestSessionStatus[]) $VALUES.clone();
        }

        static {
            IN_PROGRESS = new RequestSessionStatus("IN_PROGRESS", 0);
            CANCELLED = new RequestSessionStatus("CANCELLED", 1);
            COMPLETE = new RequestSessionStatus("COMPLETE", 2);
            $VALUES = $values();
        }
    }

    public interface SessionLifetime {
        void onFinishRequestSession(int r1, IBinder r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$z8XJE6lXBjTuh-4InriVpIBk-vc, reason: not valid java name */
    public static /* synthetic */ void m3315$r8$lambda$z8XJE6lXBjTuh4InriVpIBkvc(RequestSession r0) {
        r0.lambda$setCancellationListener$0();
    }

    /* JADX INFO: renamed from: -$$Nest$misUiWaitingForData, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3316$$Nest$misUiWaitingForData(RequestSession r0) {
        return r0.isUiWaitingForData();
    }

    public abstract ProviderSession initiateProviderSession(CredentialProviderInfo r1, RemoteCredentialService r2);

    protected abstract void invokeClientCallbackError(String r1, String r2) throws RemoteException;

    protected abstract void invokeClientCallbackSuccess(V r1) throws RemoteException;

    protected abstract void launchUiWithProviderData(ArrayList<ProviderData> r1);

    protected RequestSession(Context context, SessionLifetime sessionCallback, Object lock, int userId, int callingUid, T clientRequest, U clientCallback, String requestType, CallingAppInfo callingAppInfo, Set<ComponentName> enabledProviders, CancellationSignal cancellationSignal, long timestampStarted, boolean shouldBindClientToDeath) {
        this.mProviders = new ConcurrentHashMap();
        this.mDeathRecipient = new RequestSessionDeathRecipient(this, null);
        this.mRequestSessionStatus = RequestSessionStatus.IN_PROGRESS;
        this.mContext = context;
        this.mLock = lock;
        this.mSessionCallback = sessionCallback;
        this.mUserId = userId;
        this.mCallingUid = callingUid;
        this.mClientRequest = clientRequest;
        this.mClientCallback = clientCallback;
        this.mRequestType = requestType;
        this.mClientAppInfo = callingAppInfo;
        this.mEnabledProviders = enabledProviders;
        this.mCancellationSignal = cancellationSignal;
        this.mHandler = new Handler(Looper.getMainLooper(), null, true);
        this.mRequestId = new Binder();
        this.mCredentialManagerUi = new CredentialManagerUi(this.mContext, this.mUserId, this, this.mEnabledProviders);
        this.mHybridService = context.getResources().getString(R.string.config_dozeTapSensorType);
        this.mUniqueSessionInteger = MetricUtilities.getHighlyUniqueInteger();
        this.mRequestSessionMetric = new RequestSessionMetric(this.mUniqueSessionInteger, MetricUtilities.getHighlyUniqueInteger());
        this.mRequestSessionMetric.collectInitialPhaseMetricInfo(timestampStarted, this.mCallingUid, ApiName.getMetricCodeFromRequestInfo(this.mRequestType));
        setCancellationListener();
        if (shouldBindClientToDeath == true) goto L5;
        return;
    L5:
        if (this.mClientCallback != null) goto L7;
        return;
    L7:
        if ((this.mClientCallback instanceof IInterface) == false) goto L12;
        setUpClientCallbackListener(((IInterface) this.mClientCallback).asBinder());
        return;
    }

    protected void setUpClientCallbackListener(IBinder clientBinder) {
        if (this.mClientCallback != null) goto L5;
        return;
    L5:
        if ((this.mClientCallback instanceof IInterface) == false) goto L15;
        IInterface r0 = (IInterface) this.mClientCallback;
        clientBinder.linkToDeath(this.mDeathRecipient, 0);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, e.getMessage());
        return;
    }

    private void setCancellationListener() {
        this.mCancellationSignal.setOnCancelListener(new RequestSession$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$setCancellationListener$0() {
        Slog.d(TAG, "Cancellation invoked from the client - clearing session");
        boolean isUiActive = maybeCancelUi();
        finishSession(!isUiActive, ApiStatus.CLIENT_CANCELED.getMetricCode());
    }

    private boolean maybeCancelUi() {
        if (this.mCredentialManagerUi.getStatus() != CredentialManagerUi.UiStatus.USER_INTERACTION) goto L11;
        long originalCallingUidToken = Binder.clearCallingIdentity();
        this.mContext.startActivityAsUser(this.mCredentialManagerUi.createCancelIntent(this.mRequestId, this.mClientAppInfo.getPackageName()).addFlags(268435456), UserHandle.of(this.mUserId));     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(originalCallingUidToken);
        return true;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(originalCallingUidToken);
        throw th;
    L11:
        return false;
    }

    private boolean isUiWaitingForData() {
        if (this.mCredentialManagerUi.getStatus() != CredentialManagerUi.UiStatus.IN_PROGRESS) goto L5;
        return true;
    L5:
        return false;
    }

    public void addProviderSession(ComponentName componentName, ProviderSession providerSession) {
        this.mProviders.put(componentName.flattenToString(), providerSession);
    }

    @Override // com.android.server.credentials.CredentialManagerUi.CredentialManagerUiCallback
    public void onUiSelection(UserSelectionDialogResult selection) {
        if (this.mRequestSessionStatus != RequestSessionStatus.COMPLETE) goto L6;
        Slog.w(TAG, "Request has already been completed. This is strange.");
        return;
    L6:
        boolean authMetricLogged = true;
        if (isSessionCancelled() == false) goto L10;
        finishSession(true, ApiStatus.CLIENT_CANCELED.getMetricCode());
        return;
    L10:
        String providerId = selection.getProviderId();
        ProviderSession providerSession = this.mProviders.get(providerId);
        if (providerSession != null) goto L14;
        Slog.w(TAG, "providerSession not found in onUiSelection. This is strange.");
        return;
    L14:
        ProviderSessionMetric providerSessionMetric = providerSession.mProviderSessionMetric;
        int initialAuthMetricsProvider = providerSessionMetric.getBrowsedAuthenticationMetric().size();
        this.mRequestSessionMetric.collectMetricPerBrowsingSelect(selection, providerSession.mProviderSessionMetric.getCandidatePhasePerProviderMetric());
        providerSession.onUiEntrySelected(selection.getEntryKey(), selection.getEntrySubkey(), selection.getPendingIntentProviderResponse());
        int numAuthPerProvider = providerSessionMetric.getBrowsedAuthenticationMetric().size();
        if ((numAuthPerProvider - initialAuthMetricsProvider) == 1) goto L18;
        authMetricLogged = false;
    L18:
        if (authMetricLogged == false) goto L21;
        this.mRequestSessionMetric.logAuthEntry(providerSession.mProviderSessionMetric.getBrowsedAuthenticationMetric().get(numAuthPerProvider - 1));
        return;
    }

    protected void finishSession(boolean propagateCancellation, int apiStatus) {
        Slog.i(TAG, "finishing session with propagateCancellation " + propagateCancellation);
        if (propagateCancellation == false) goto L5;
        this.mProviders.values().forEach(new RequestSession$$ExternalSyntheticLambda0());
    L5:
        this.mRequestSessionStatus = RequestSessionStatus.COMPLETE;
        logTrackOneCandidatesAndPrepareFinalPhaseLogs(apiStatus);
        this.mRequestSessionMetric.logApiCalledAtFinish(apiStatus);
        this.mProviders.clear();
        clearRequestSessionLocked();
    }

    private void logTrackOneCandidatesAndPrepareFinalPhaseLogs(int apiStatus) {
        this.mRequestSessionMetric.logCandidateAggregateMetrics(this.mProviders);
        if (isRespondingWithError(apiStatus) == false) goto L6;
        this.mRequestSessionMetric.collectFinalPhaseProviderMetricStatus(true, ProviderStatusForMetrics.FINAL_FAILURE);
        return;
    L6:
        if (isRespondingWithUserCanceledError(apiStatus) == false) goto L9;
        this.mRequestSessionMetric.collectFinalPhaseProviderMetricStatus(false, ProviderStatusForMetrics.FINAL_FAILURE);
        return;
    L9:
        if (isRespondingWithSuccess(apiStatus) == false) goto L14;
        this.mRequestSessionMetric.collectFinalPhaseProviderMetricStatus(false, ProviderStatusForMetrics.FINAL_SUCCESS);
        return;
    }

    void cancelExistingPendingIntent() {
        if (this.mPendingIntent == null) goto L11;
        this.mPendingIntent.cancel();     // Catch: Exception -> L6
        this.mPendingIntent = null;     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Unable to cancel existing pending intent", e);
        return;
    }

    private void clearRequestSessionLocked() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSessionCallback.onFinishRequestSession(this.mUserId, this.mRequestId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected boolean isAnyProviderPending() {
        Iterator<ProviderSession> r0 = this.mProviders.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ProviderSession session = r0.next();
        if (ProviderSession.isStatusWaitingForRemoteResponse(session.getStatus()) == false) goto L4;
        return true;
    L10:
        return false;
    }

    protected boolean isSessionCancelled() {
        return this.mCancellationSignal.isCanceled();
    }

    protected boolean isUiInvocationNeeded() {
        Iterator<ProviderSession> r0 = this.mProviders.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        ProviderSession session = r0.next();
        if (ProviderSession.isUiInvokingStatus(session.getStatus()) == true) goto L7;
        if (ProviderSession.isStatusWaitingForRemoteResponse(session.getStatus()) == false) goto L4;
        return false;
    L7:
        return true;
    L13:
        return false;
    }

    void getProviderDataAndInitiateUi() {
        ArrayList<ProviderData> providerDataList = getProviderDataForUi();
        if (providerDataList.isEmpty() == true) goto L6;
        launchUiWithProviderData(providerDataList);
        return;
    }

    protected ArrayList<ProviderData> getProviderDataForUi() {
        Slog.i(TAG, "For ui, provider data size: " + this.mProviders.size());
        ArrayList<ProviderData> providerDataList = new ArrayList();
        this.mRequestSessionMetric.logCandidatePhaseMetrics(this.mProviders);
        if (isSessionCancelled() == false) goto L6;
        finishSession(true, ApiStatus.CLIENT_CANCELED.getMetricCode());
        return providerDataList;
    L6:
        Iterator<ProviderSession> r1 = this.mProviders.values().iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        ProviderSession session = r1.next();
        ProviderData providerData = session.mo3297prepareUiData();
        if (providerData == null) goto L8;
        providerDataList.add(providerData);
        goto L8
    L13:
        return providerDataList;
    }

    protected void respondToClientWithResponseAndFinish(V response) {
        if (this.mRequestSessionStatus != RequestSessionStatus.COMPLETE) goto L7;
        Slog.w(TAG, "Request has already been completed. This is strange.");
        return;
    L7:
        if (isSessionCancelled() == false) goto L16;
        finishSession(true, ApiStatus.CLIENT_CANCELED.getMetricCode());
        return;
    L16:
        invokeClientCallbackSuccess(response);     // Catch: RemoteException -> L13
        finishSession(false, ApiStatus.SUCCESS.getMetricCode());     // Catch: RemoteException -> L13
        return;
    L13:
        e = move-exception;
        Slog.e(TAG, "Issue while responding to client with a response : " + e);
        finishSession(false, ApiStatus.FAILURE.getMetricCode());
    }

    protected void respondToClientWithErrorAndFinish(String errorType, String errorMsg) {
        if (this.mRequestSessionStatus != RequestSessionStatus.COMPLETE) goto L7;
        Slog.w(TAG, "Request has already been completed. This is strange.");
        return;
    L7:
        if (isSessionCancelled() == false) goto L19;
        finishSession(true, ApiStatus.CLIENT_CANCELED.getMetricCode());
        return;
    L19:
        invokeClientCallbackError(errorType, errorMsg);     // Catch: RemoteException -> L12
    L14:
        boolean isUserCanceled = errorType.contains(MetricUtilities.USER_CANCELED_SUBSTRING);
        if (isUserCanceled == false) goto L17;
        finishSession(false, ApiStatus.USER_CANCELED.getMetricCode());
        return;
    L17:
        finishSession(false, ApiStatus.FAILURE.getMetricCode());
        return;
    L12:
        e = move-exception;
        Slog.e(TAG, "Issue while responding to client with error : " + e);
        goto L14
    }

    protected boolean isPrimaryProviderViaProviderInfo(ComponentName componentName) {
        ProviderSession chosenProviderSession = this.mProviders.get(componentName.flattenToString());
        if (chosenProviderSession != null) goto L5;
    L9:
        return false;
    L5:
        if (chosenProviderSession.mProviderInfo == null) goto L9;
        if (chosenProviderSession.mProviderInfo.isPrimary() == false) goto L9;
        return true;
    }

    private boolean isRespondingWithError(int apiStatus) {
        if (apiStatus != ApiStatus.FAILURE.getMetricCode()) goto L5;
    L8:
        return true;
    L5:
        if (apiStatus == ApiStatus.CLIENT_CANCELED.getMetricCode()) goto L8;
        return false;
    }

    private boolean isRespondingWithUserCanceledError(int apiStatus) {
        if (apiStatus != ApiStatus.USER_CANCELED.getMetricCode()) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isRespondingWithSuccess(int apiStatus) {
        if (apiStatus != ApiStatus.SUCCESS.getMetricCode()) goto L5;
        return true;
    L5:
        return false;
    }
}
