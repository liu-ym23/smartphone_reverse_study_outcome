package com.android.server.credentials;

import android.content.ComponentName;
import android.content.Context;
import android.credentials.CreateCredentialRequest;
import android.credentials.CreateCredentialResponse;
import android.credentials.CredentialProviderInfo;
import android.credentials.ICreateCredentialCallback;
import android.credentials.selection.ProviderData;
import android.credentials.selection.RequestInfo;
import android.credentials.selection.UserSelectionDialogResult;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.service.credentials.CallingAppInfo;
import android.service.credentials.PermissionUtils;
import android.util.Slog;
import com.android.server.credentials.metrics.ProviderStatusForMetrics;
import com.android.server.credentials.metrics.RequestSessionMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class CreateRequestSession extends RequestSession<CreateCredentialRequest, ICreateCredentialCallback, CreateCredentialResponse> implements ProviderSession.ProviderInternalCallback<CreateCredentialResponse> {
    private static final String TAG = "CredentialManager";
    private final Set<ComponentName> mPrimaryProviders;

    @Override // com.android.server.credentials.RequestSession
    public /* bridge */ /* synthetic */ void addProviderSession(ComponentName r1, ProviderSession r2) {
        super.addProviderSession(r1, r2);
    }

    @Override // com.android.server.credentials.RequestSession
    protected /* bridge */ /* synthetic */ void invokeClientCallbackSuccess(CreateCredentialResponse r1) throws RemoteException {
        invokeClientCallbackSuccess2(r1);
    }

    @Override // com.android.server.credentials.ProviderSession.ProviderInternalCallback
    public /* bridge */ /* synthetic */ void onFinalResponseReceived(ComponentName r1, CreateCredentialResponse r2) {
        onFinalResponseReceived2(r1, r2);
    }

    @Override // com.android.server.credentials.RequestSession, com.android.server.credentials.CredentialManagerUi.CredentialManagerUiCallback
    public /* bridge */ /* synthetic */ void onUiSelection(UserSelectionDialogResult r1) {
        super.onUiSelection(r1);
    }

    CreateRequestSession(Context context, RequestSession.SessionLifetime sessionCallback, Object lock, int userId, int callingUid, CreateCredentialRequest request, ICreateCredentialCallback callback, CallingAppInfo callingAppInfo, Set<ComponentName> enabledProviders, Set<ComponentName> primaryProviders, CancellationSignal cancellationSignal, long startedTimestamp) {
        super(context, sessionCallback, lock, userId, callingUid, request, callback, "android.credentials.selection.TYPE_CREATE", callingAppInfo, enabledProviders, cancellationSignal, startedTimestamp, true);
        RequestSessionMetric r1 = this.mRequestSessionMetric;
        if (request.getOrigin() == null) goto L5;
        boolean r2 = true;
    L6:
        r1.collectCreateFlowInitialMetricInfo(r2, request);
        this.mPrimaryProviders = primaryProviders;
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.android.server.credentials.RequestSession
    public ProviderSession initiateProviderSession(CredentialProviderInfo providerInfo, RemoteCredentialService remoteCredentialService) {
        ProviderCreateSession providerCreateSession = ProviderCreateSession.createNewSession(this.mContext, this.mUserId, providerInfo, this, remoteCredentialService);
        if (providerCreateSession == null) goto L5;
        Slog.i(TAG, "Provider session created and being added for: " + providerInfo.getComponentName());
        this.mProviders.put(providerCreateSession.getComponentName().flattenToString(), providerCreateSession);
    L5:
        return providerCreateSession;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.server.credentials.RequestSession
    protected void launchUiWithProviderData(ArrayList<ProviderData> providerDataList) {
        this.mRequestSessionMetric.collectUiCallStartTime(System.nanoTime());
        this.mCredentialManagerUi.setStatus(CredentialManagerUi.UiStatus.USER_INTERACTION);
        cancelExistingPendingIntent();
        List<String> flattenedPrimaryProviders = new ArrayList();     // Catch: RemoteException -> L7
        Iterator<ComponentName> r0 = this.mPrimaryProviders.iterator();     // Catch: RemoteException -> L7
    L5:
        if (r0.hasNext() == false) goto L9;
        ComponentName cn = r0.next();     // Catch: RemoteException -> L7
        flattenedPrimaryProviders.add(cn.flattenToString());     // Catch: RemoteException -> L7
        goto L5
    L9:
        this.mPendingIntent = this.mCredentialManagerUi.createPendingIntent(RequestInfo.newCreateRequestInfo(this.mRequestId, (CreateCredentialRequest) this.mClientRequest, this.mClientAppInfo.getPackageName(), PermissionUtils.hasPermission(this.mContext, this.mClientAppInfo.getPackageName(), "android.permission.CREDENTIAL_MANAGER_SET_ALLOWED_PROVIDERS"), flattenedPrimaryProviders, false), providerDataList, this.mRequestSessionMetric);     // Catch: RemoteException -> L7
        ((ICreateCredentialCallback) this.mClientCallback).onPendingIntent(this.mPendingIntent);     // Catch: RemoteException -> L7
        return;
    L11:
        this.mRequestSessionMetric.collectUiReturnedFinalPhase(false);
        this.mCredentialManagerUi.setStatus(CredentialManagerUi.UiStatus.TERMINATED);
        respondToClientWithErrorAndFinish("android.credentials.CreateCredentialException.TYPE_UNKNOWN", "Unable to invoke selector");
    }

    /* JADX INFO: renamed from: invokeClientCallbackSuccess, reason: avoid collision after fix types in other method */
    protected void invokeClientCallbackSuccess2(CreateCredentialResponse response) throws RemoteException {
        ((ICreateCredentialCallback) this.mClientCallback).onResponse(response);
    }

    @Override // com.android.server.credentials.RequestSession
    protected void invokeClientCallbackError(String errorType, String errorMsg) throws RemoteException {
        ((ICreateCredentialCallback) this.mClientCallback).onError(errorType, errorMsg);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: onFinalResponseReceived, reason: avoid collision after fix types in other method */
    public void onFinalResponseReceived2(ComponentName componentName, CreateCredentialResponse response) {
        Slog.i(TAG, "Final credential received from: " + componentName.flattenToString());
        this.mRequestSessionMetric.collectUiResponseData(true, System.nanoTime());
        this.mRequestSessionMetric.updateMetricsOnResponseReceived(this.mProviders, componentName, isPrimaryProviderViaProviderInfo(componentName));
        if (response == null) goto L5;
        this.mRequestSessionMetric.collectChosenProviderStatus(ProviderStatusForMetrics.FINAL_SUCCESS.getMetricCode());
        this.mRequestSessionMetric.collectChosenClassType(((CreateCredentialRequest) this.mClientRequest).getType());
        respondToClientWithResponseAndFinish(response);
        return;
    L5:
        this.mRequestSessionMetric.collectChosenProviderStatus(ProviderStatusForMetrics.FINAL_FAILURE.getMetricCode());
        this.mRequestSessionMetric.collectFrameworkException("android.credentials.CreateCredentialException.TYPE_NO_CREATE_OPTIONS");
        respondToClientWithErrorAndFinish("android.credentials.CreateCredentialException.TYPE_NO_CREATE_OPTIONS", "Invalid response");
    }

    @Override // com.android.server.credentials.ProviderSession.ProviderInternalCallback
    public void onFinalErrorReceived(ComponentName componentName, String errorType, String message) {
        respondToClientWithErrorAndFinish(errorType, message);
    }

    @Override // com.android.server.credentials.CredentialManagerUi.CredentialManagerUiCallback
    public void onUiCancellation(boolean isUserCancellation) {
        String exception = "android.credentials.CreateCredentialException.TYPE_USER_CANCELED";
        String message = "User cancelled the selector";
        if (isUserCancellation == true) goto L5;
        exception = "android.credentials.CreateCredentialException.TYPE_INTERRUPTED";
        message = "The UI was interrupted - please try again.";
    L5:
        this.mRequestSessionMetric.collectFrameworkException(exception);
        respondToClientWithErrorAndFinish(exception, message);
    }

    @Override // com.android.server.credentials.CredentialManagerUi.CredentialManagerUiCallback
    public void onUiSelectorInvocationFailure() {
        this.mRequestSessionMetric.collectFrameworkException("android.credentials.CreateCredentialException.TYPE_NO_CREATE_OPTIONS");
        respondToClientWithErrorAndFinish("android.credentials.CreateCredentialException.TYPE_NO_CREATE_OPTIONS", "No create options available.");
    }

    @Override // com.android.server.credentials.ProviderSession.ProviderInternalCallback
    public void onProviderStatusChanged(ProviderSession.Status status, ComponentName componentName, ProviderSession.CredentialsSource source) {
        Slog.i(TAG, "Provider status changed: " + status + ", and source: " + source);
        if (isAnyProviderPending() == false) goto L5;
        return;
    L5:
        if (isUiInvocationNeeded() == false) goto L7;
        Slog.i(TAG, "Provider status changed - ui invocation is needed");
        getProviderDataAndInitiateUi();
        return;
    L7:
        this.mRequestSessionMetric.collectFrameworkException("android.credentials.CreateCredentialException.TYPE_NO_CREATE_OPTIONS");
        respondToClientWithErrorAndFinish("android.credentials.CreateCredentialException.TYPE_NO_CREATE_OPTIONS", "No create options available.");
    }
}
