package com.android.server.credentials;

import android.content.ComponentName;
import android.content.Context;
import android.credentials.CredentialOption;
import android.credentials.CredentialProviderInfo;
import android.credentials.GetCredentialRequest;
import android.credentials.GetCredentialResponse;
import android.credentials.IGetCredentialCallback;
import android.credentials.selection.ProviderData;
import android.credentials.selection.RequestInfo;
import android.credentials.selection.UserSelectionDialogResult;
import android.os.Binder;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.service.credentials.CallingAppInfo;
import android.service.credentials.PermissionUtils;
import android.util.Slog;
import com.android.server.credentials.metrics.ProviderStatusForMetrics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class GetRequestSession extends RequestSession<GetCredentialRequest, IGetCredentialCallback, GetCredentialResponse> implements ProviderSession.ProviderInternalCallback<GetCredentialResponse> {
    private static final String TAG = "CredentialManager";

    /* JADX INFO: renamed from: $r8$lambda$0LtTRBV-lRduLp65nu5fZ6r7FyY, reason: not valid java name */
    public static /* synthetic */ void m3293$r8$lambda$0LtTRBVlRduLp65nu5fZ6r7FyY(GetRequestSession r0, ComponentName r1, String r2) {
        r0.lambda$handleEmptyAuthenticationSelection$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$F54EbIc40VBZ5z3EW237v9dIweU(GetRequestSession r0, ArrayList r1) {
        r0.lambda$launchUiWithProviderData$0(r1);
    }

    @Override // com.android.server.credentials.RequestSession
    public /* bridge */ /* synthetic */ void addProviderSession(ComponentName r1, ProviderSession r2) {
        super.addProviderSession(r1, r2);
    }

    @Override // com.android.server.credentials.RequestSession
    protected /* bridge */ /* synthetic */ void invokeClientCallbackSuccess(GetCredentialResponse r1) throws RemoteException {
        invokeClientCallbackSuccess2(r1);
    }

    @Override // com.android.server.credentials.ProviderSession.ProviderInternalCallback
    public /* bridge */ /* synthetic */ void onFinalResponseReceived(ComponentName r1, GetCredentialResponse r2) {
        onFinalResponseReceived2(r1, r2);
    }

    @Override // com.android.server.credentials.RequestSession, com.android.server.credentials.CredentialManagerUi.CredentialManagerUiCallback
    public /* bridge */ /* synthetic */ void onUiSelection(UserSelectionDialogResult r1) {
        super.onUiSelection(r1);
    }

    public GetRequestSession(Context context, RequestSession.SessionLifetime sessionCallback, Object lock, int userId, int callingUid, IGetCredentialCallback callback, GetCredentialRequest request, CallingAppInfo callingAppInfo, Set<ComponentName> enabledProviders, CancellationSignal cancellationSignal, long startedTimestamp) {
        super(context, sessionCallback, lock, userId, callingUid, request, callback, getRequestInfoFromRequest(request), callingAppInfo, enabledProviders, cancellationSignal, startedTimestamp, true);
        this.mRequestSessionMetric.collectGetFlowInitialMetricInfo(request);
    }

    private static String getRequestInfoFromRequest(GetCredentialRequest request) {
        Iterator<CredentialOption> r0 = request.getCredentialOptions().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        CredentialOption option = r0.next();
        if (option.getCredentialRetrievalData().getStringArrayList("android.credentials.GetCredentialOption.SUPPORTED_ELEMENT_KEYS") == null) goto L4;
        return "android.credentials.selection.TYPE_GET_VIA_REGISTRY";
    L10:
        return "android.credentials.selection.TYPE_GET";
    }

    @Override // com.android.server.credentials.RequestSession
    public ProviderSession initiateProviderSession(CredentialProviderInfo providerInfo, RemoteCredentialService remoteCredentialService) {
        ProviderGetSession providerGetSession = ProviderGetSession.createNewSession(this.mContext, this.mUserId, providerInfo, this, remoteCredentialService);
        if (providerGetSession == null) goto L5;
        Slog.i(TAG, "Provider session created and being added for: " + providerInfo.getComponentName());
        this.mProviders.put(providerGetSession.getComponentName().flattenToString(), providerGetSession);
    L5:
        return providerGetSession;
    }

    @Override // com.android.server.credentials.RequestSession
    protected void launchUiWithProviderData(final ArrayList<ProviderData> providerDataList) {
        this.mRequestSessionMetric.collectUiCallStartTime(System.nanoTime());
        this.mCredentialManagerUi.setStatus(CredentialManagerUi.UiStatus.USER_INTERACTION);
        Binder.withCleanCallingIdentity(new GetRequestSession$$ExternalSyntheticLambda1(this, providerDataList));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$launchUiWithProviderData$0(ArrayList providerDataList) throws Exception {
        cancelExistingPendingIntent();     // Catch: RemoteException -> L5
        this.mPendingIntent = this.mCredentialManagerUi.createPendingIntent(RequestInfo.newGetRequestInfo(this.mRequestId, (GetCredentialRequest) this.mClientRequest, this.mClientAppInfo.getPackageName(), PermissionUtils.hasPermission(this.mContext, this.mClientAppInfo.getPackageName(), "android.permission.CREDENTIAL_MANAGER_SET_ALLOWED_PROVIDERS"), false), providerDataList, this.mRequestSessionMetric);     // Catch: RemoteException -> L5
        ((IGetCredentialCallback) this.mClientCallback).onPendingIntent(this.mPendingIntent);     // Catch: RemoteException -> L5
        return;
    L6:
        this.mRequestSessionMetric.collectUiReturnedFinalPhase(false);
        this.mCredentialManagerUi.setStatus(CredentialManagerUi.UiStatus.TERMINATED);
        this.mRequestSessionMetric.collectFrameworkException("android.credentials.GetCredentialException.TYPE_UNKNOWN");
        respondToClientWithErrorAndFinish("android.credentials.GetCredentialException.TYPE_UNKNOWN", "Unable to instantiate selector");
    }

    /* JADX INFO: renamed from: invokeClientCallbackSuccess, reason: avoid collision after fix types in other method */
    protected void invokeClientCallbackSuccess2(GetCredentialResponse response) throws RemoteException {
        ((IGetCredentialCallback) this.mClientCallback).onResponse(response);
    }

    @Override // com.android.server.credentials.RequestSession
    protected void invokeClientCallbackError(String errorType, String errorMsg) throws RemoteException {
        ((IGetCredentialCallback) this.mClientCallback).onError(errorType, errorMsg);
    }

    /* JADX INFO: renamed from: onFinalResponseReceived, reason: avoid collision after fix types in other method */
    public void onFinalResponseReceived2(ComponentName componentName, GetCredentialResponse response) {
        Slog.i(TAG, "onFinalResponseReceived from: " + componentName.flattenToString());
        this.mRequestSessionMetric.collectUiResponseData(true, System.nanoTime());
        this.mRequestSessionMetric.updateMetricsOnResponseReceived(this.mProviders, componentName, isPrimaryProviderViaProviderInfo(componentName));
        if (response == null) goto L8;
        this.mRequestSessionMetric.collectChosenProviderStatus(ProviderStatusForMetrics.FINAL_SUCCESS.getMetricCode());
        if (response.getCredential() == null) goto L7;
        this.mRequestSessionMetric.collectChosenClassType(response.getCredential().getType());
    L7:
        respondToClientWithResponseAndFinish(response);
        return;
    L8:
        this.mRequestSessionMetric.collectChosenProviderStatus(ProviderStatusForMetrics.FINAL_FAILURE.getMetricCode());
        this.mRequestSessionMetric.collectFrameworkException("android.credentials.GetCredentialException.TYPE_NO_CREDENTIAL");
        respondToClientWithErrorAndFinish("android.credentials.GetCredentialException.TYPE_NO_CREDENTIAL", "Invalid response from provider");
    }

    @Override // com.android.server.credentials.ProviderSession.ProviderInternalCallback
    public void onFinalErrorReceived(ComponentName componentName, String errorType, String message) {
        respondToClientWithErrorAndFinish(errorType, message);
    }

    @Override // com.android.server.credentials.CredentialManagerUi.CredentialManagerUiCallback
    public void onUiCancellation(boolean isUserCancellation) {
        String exception = "android.credentials.GetCredentialException.TYPE_USER_CANCELED";
        String message = "User cancelled the selector";
        if (isUserCancellation == true) goto L5;
        exception = "android.credentials.GetCredentialException.TYPE_INTERRUPTED";
        message = "The UI was interrupted - please try again.";
    L5:
        this.mRequestSessionMetric.collectFrameworkException(exception);
        respondToClientWithErrorAndFinish(exception, message);
    }

    @Override // com.android.server.credentials.CredentialManagerUi.CredentialManagerUiCallback
    public void onUiSelectorInvocationFailure() {
        this.mRequestSessionMetric.collectFrameworkException("android.credentials.GetCredentialException.TYPE_NO_CREDENTIAL");
        respondToClientWithErrorAndFinish("android.credentials.GetCredentialException.TYPE_NO_CREDENTIAL", "No credentials available.");
    }

    @Override // com.android.server.credentials.ProviderSession.ProviderInternalCallback
    public void onProviderStatusChanged(ProviderSession.Status status, ComponentName componentName, ProviderSession.CredentialsSource source) {
        Slog.i(TAG, "Status changed for: " + componentName + ", with status: " + status + ", and source: " + source);
        if (status != ProviderSession.Status.NO_CREDENTIALS_FROM_AUTH_ENTRY) goto L7;
        handleEmptyAuthenticationSelection(componentName);
        return;
    L7:
        if (isAnyProviderPending() == false) goto L9;
        return;
    L9:
        if (isUiInvocationNeeded() == false) goto L11;
        Slog.i(TAG, "Provider status changed - ui invocation is needed");
        getProviderDataAndInitiateUi();
        return;
    L11:
        this.mRequestSessionMetric.collectFrameworkException("android.credentials.GetCredentialException.TYPE_NO_CREDENTIAL");
        respondToClientWithErrorAndFinish("android.credentials.GetCredentialException.TYPE_NO_CREDENTIAL", "No credentials available");
    }

    protected void handleEmptyAuthenticationSelection(final ComponentName componentName) {
        this.mProviders.keySet().forEach(new GetRequestSession$$ExternalSyntheticLambda0(this, componentName));
        getProviderDataAndInitiateUi();
        if (providerDataContainsEmptyAuthEntriesOnly() == false) goto L6;
        this.mRequestSessionMetric.collectFrameworkException("android.credentials.GetCredentialException.TYPE_NO_CREDENTIAL");
        respondToClientWithErrorAndFinish("android.credentials.GetCredentialException.TYPE_NO_CREDENTIAL", "No credentials available");
        return;
    }

    private /* synthetic */ void lambda$handleEmptyAuthenticationSelection$1(ComponentName componentName, String key) {
        ProviderGetSession session = (ProviderGetSession) this.mProviders.get(key);
        if (session.mComponentName.equals(componentName) == true) goto L6;
        session.updateAuthEntriesStatusFromAnotherSession();
        return;
    }

    private boolean providerDataContainsEmptyAuthEntriesOnly() {
        Iterator<String> r0 = this.mProviders.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String key = r0.next();
        ProviderGetSession session = (ProviderGetSession) this.mProviders.get(key);
        if (session.containsEmptyAuthEntriesOnly() == true) goto L4;
        return false;
    L10:
        return true;
    }
}
