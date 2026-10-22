package com.android.server.credentials;

import android.content.ComponentName;
import android.content.Context;
import android.credentials.ClearCredentialStateRequest;
import android.credentials.CredentialProviderInfo;
import android.credentials.IClearCredentialStateCallback;
import android.credentials.selection.ProviderData;
import android.credentials.selection.UserSelectionDialogResult;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.service.credentials.CallingAppInfo;
import android.util.Slog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ClearRequestSession extends RequestSession<ClearCredentialStateRequest, IClearCredentialStateCallback, Void> implements ProviderSession.ProviderInternalCallback<Void> {
    private static final String TAG = "CredentialManager";

    @Override // com.android.server.credentials.RequestSession
    public /* bridge */ /* synthetic */ void addProviderSession(ComponentName r1, ProviderSession r2) {
        super.addProviderSession(r1, r2);
    }

    @Override // com.android.server.credentials.RequestSession
    protected /* bridge */ /* synthetic */ void invokeClientCallbackSuccess(Void r1) throws RemoteException {
        invokeClientCallbackSuccess2(r1);
    }

    @Override // com.android.server.credentials.ProviderSession.ProviderInternalCallback
    public /* bridge */ /* synthetic */ void onFinalResponseReceived(ComponentName r1, Void r2) {
        onFinalResponseReceived2(r1, r2);
    }

    @Override // com.android.server.credentials.RequestSession, com.android.server.credentials.CredentialManagerUi.CredentialManagerUiCallback
    public /* bridge */ /* synthetic */ void onUiSelection(UserSelectionDialogResult r1) {
        super.onUiSelection(r1);
    }

    public ClearRequestSession(Context context, RequestSession.SessionLifetime sessionCallback, Object lock, int userId, int callingUid, IClearCredentialStateCallback callback, ClearCredentialStateRequest request, CallingAppInfo callingAppInfo, Set<ComponentName> enabledProviders, CancellationSignal cancellationSignal, long startedTimestamp) {
        super(context, sessionCallback, lock, userId, callingUid, request, callback, "android.credentials.selection.TYPE_UNDEFINED", callingAppInfo, enabledProviders, cancellationSignal, startedTimestamp, true);
    }

    @Override // com.android.server.credentials.RequestSession
    public ProviderSession initiateProviderSession(CredentialProviderInfo providerInfo, RemoteCredentialService remoteCredentialService) {
        ProviderClearSession providerClearSession = ProviderClearSession.createNewSession(this.mContext, this.mUserId, providerInfo, this, remoteCredentialService);
        if (providerClearSession == null) goto L5;
        Slog.i(TAG, "Provider session created and being added for: " + providerInfo.getComponentName());
        this.mProviders.put(providerClearSession.getComponentName().flattenToString(), providerClearSession);
    L5:
        return providerClearSession;
    }

    @Override // com.android.server.credentials.ProviderSession.ProviderInternalCallback
    public void onProviderStatusChanged(ProviderSession.Status status, ComponentName componentName, ProviderSession.CredentialsSource source) {
        Slog.i(TAG, "Provider changed with status: " + status + ", and source: " + source);
        if (ProviderSession.isTerminatingStatus(status) == false) goto L6;
        Slog.i(TAG, "Provider terminating status");
        onProviderTerminated(componentName);
        return;
    L6:
        if (ProviderSession.isCompletionStatus(status) == false) goto L10;
        Slog.i(TAG, "Provider has completion status");
        onProviderResponseComplete(componentName);
        return;
    }

    /* JADX INFO: renamed from: onFinalResponseReceived, reason: avoid collision after fix types in other method */
    public void onFinalResponseReceived2(ComponentName componentName, Void response) {
        this.mRequestSessionMetric.collectUiResponseData(true, System.nanoTime());
        this.mRequestSessionMetric.updateMetricsOnResponseReceived(this.mProviders, componentName, isPrimaryProviderViaProviderInfo(componentName));
        respondToClientWithResponseAndFinish(null);
    }

    protected void onProviderResponseComplete(ComponentName componentName) {
        if (isAnyProviderPending() == true) goto L6;
        onFinalResponseReceived2(componentName, null);
        return;
    }

    protected void onProviderTerminated(ComponentName componentName) {
        if (isAnyProviderPending() == true) goto L6;
        processResponses();
        return;
    }

    @Override // com.android.server.credentials.RequestSession
    protected void launchUiWithProviderData(ArrayList<ProviderData> providerDataList) {
    }

    /* JADX INFO: renamed from: invokeClientCallbackSuccess, reason: avoid collision after fix types in other method */
    protected void invokeClientCallbackSuccess2(Void response) throws RemoteException {
        ((IClearCredentialStateCallback) this.mClientCallback).onSuccess();
    }

    @Override // com.android.server.credentials.RequestSession
    protected void invokeClientCallbackError(String errorType, String errorMsg) throws RemoteException {
        ((IClearCredentialStateCallback) this.mClientCallback).onError(errorType, errorMsg);
    }

    @Override // com.android.server.credentials.ProviderSession.ProviderInternalCallback
    public void onFinalErrorReceived(ComponentName componentName, String errorType, String message) {
    }

    private void processResponses() {
        Iterator<ProviderSession> r0 = this.mProviders.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ProviderSession session = r0.next();
        if (session.isProviderResponseSet().booleanValue() == false) goto L4;
        respondToClientWithResponseAndFinish(null);
        return;
    L10:
        this.mRequestSessionMetric.collectFrameworkException("android.credentials.ClearCredentialStateException.TYPE_UNKNOWN");
        respondToClientWithErrorAndFinish("android.credentials.ClearCredentialStateException.TYPE_UNKNOWN", "All providers failed");
    }

    @Override // com.android.server.credentials.CredentialManagerUi.CredentialManagerUiCallback
    public void onUiCancellation(boolean isUserCancellation) {
    }

    @Override // com.android.server.credentials.CredentialManagerUi.CredentialManagerUiCallback
    public void onUiSelectorInvocationFailure() {
    }
}
