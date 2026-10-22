package com.android.server.credentials;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.credentials.CredentialProviderInfo;
import android.credentials.GetCandidateCredentialsResponse;
import android.credentials.GetCredentialRequest;
import android.credentials.GetCredentialResponse;
import android.credentials.IGetCandidateCredentialsCallback;
import android.credentials.selection.GetCredentialProviderData;
import android.credentials.selection.ProviderData;
import android.credentials.selection.RequestInfo;
import android.credentials.selection.UserSelectionDialogResult;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.service.credentials.CallingAppInfo;
import android.service.credentials.PermissionUtils;
import android.util.Slog;
import com.android.server.credentials.metrics.ApiStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class GetCandidateRequestSession extends RequestSession<GetCredentialRequest, IGetCandidateCredentialsCallback, GetCandidateCredentialsResponse> implements ProviderSession.ProviderInternalCallback<GetCredentialResponse> {
    private static final String REQUEST_ID_KEY = "autofill_request_id";
    private static final String SESSION_ID_KEY = "autofill_session_id";
    private static final String TAG = "CredentialManager";
    private final ResultReceiver mAutofillCallback;
    private final int mAutofillRequestId;
    private final int mAutofillSessionId;
    private final IBinder mClientBinder;
    private ComponentName mPrimaryProviderComponentName;

    @Override // com.android.server.credentials.RequestSession
    public /* bridge */ /* synthetic */ void addProviderSession(ComponentName r1, ProviderSession r2) {
        super.addProviderSession(r1, r2);
    }

    @Override // com.android.server.credentials.RequestSession
    protected /* bridge */ /* synthetic */ void invokeClientCallbackSuccess(GetCandidateCredentialsResponse r1) throws RemoteException {
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

    public GetCandidateRequestSession(Context context, RequestSession.SessionLifetime sessionCallback, Object lock, int userId, int callingUid, IGetCandidateCredentialsCallback callback, GetCredentialRequest request, CallingAppInfo callingAppInfo, Set<ComponentName> enabledProviders, CancellationSignal cancellationSignal, IBinder clientBinder) {
        super(context, sessionCallback, lock, userId, callingUid, request, callback, "android.credentials.selection.TYPE_GET", callingAppInfo, enabledProviders, cancellationSignal, 0, false);
        this.mPrimaryProviderComponentName = null;
        this.mClientBinder = clientBinder;
        this.mAutofillSessionId = request.getData().getInt(SESSION_ID_KEY, -1);
        this.mAutofillRequestId = request.getData().getInt(REQUEST_ID_KEY, -1);
        this.mAutofillCallback = (ResultReceiver) request.getData().getParcelable("android.credentials.AUTOFILL_RESULT_RECEIVER", ResultReceiver.class);
        if (this.mClientBinder == null) goto L6;
        setUpClientCallbackListener(this.mClientBinder);
        return;
    }

    @Override // com.android.server.credentials.RequestSession
    public ProviderSession initiateProviderSession(CredentialProviderInfo providerInfo, RemoteCredentialService remoteCredentialService) {
        ProviderGetSession providerGetCandidateSessions = ProviderGetSession.createNewSession(this.mContext, this.mUserId, providerInfo, this, remoteCredentialService);
        if (providerGetCandidateSessions == null) goto L8;
        Slog.d(TAG, "In startProviderSession - provider session created and being added for: " + providerInfo.getComponentName());
        ComponentName componentName = providerGetCandidateSessions.getComponentName();
        if (providerInfo.isPrimary() == false) goto L7;
        this.mPrimaryProviderComponentName = componentName;
    L7:
        this.mProviders.put(componentName.flattenToString(), providerGetCandidateSessions);
    L8:
        return providerGetCandidateSessions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.server.credentials.RequestSession
    protected void launchUiWithProviderData(ArrayList<ProviderData> providerDataList) {
        if (providerDataList != null) goto L4;
    L15:
        respondToClientWithErrorAndFinish("android.credentials.GetCandidateCredentialsException.TYPE_NO_CREDENTIAL", "No credentials found");
        return;
    L4:
        if (providerDataList.isEmpty() == true) goto L15;
        Intent intent = this.mCredentialManagerUi.createIntentForAutofill(RequestInfo.newGetRequestInfo(this.mRequestId, (GetCredentialRequest) this.mClientRequest, this.mClientAppInfo.getPackageName(), PermissionUtils.hasPermission(this.mContext, this.mClientAppInfo.getPackageName(), "android.permission.CREDENTIAL_MANAGER_SET_ALLOWED_PROVIDERS"), true), this.mRequestSessionMetric);
        List<GetCredentialProviderData> candidateProviderDataList = new ArrayList();
        Iterator<ProviderData> r2 = providerDataList.iterator();
    L8:
        if (r2.hasNext() == false) goto L17;
        candidateProviderDataList.add((ProviderData) r2.next());
        goto L8
    L17:
        invokeClientCallbackSuccess2(new GetCandidateCredentialsResponse(candidateProviderDataList, intent, this.mPrimaryProviderComponentName));     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        Slog.e(TAG, "Issue while responding to client with error : " + e);
    }

    /* JADX INFO: renamed from: invokeClientCallbackSuccess, reason: avoid collision after fix types in other method */
    protected void invokeClientCallbackSuccess2(GetCandidateCredentialsResponse response) throws RemoteException {
        ((IGetCandidateCredentialsCallback) this.mClientCallback).onResponse(response);
    }

    @Override // com.android.server.credentials.RequestSession
    protected void invokeClientCallbackError(String errorType, String errorMsg) throws RemoteException {
        ((IGetCandidateCredentialsCallback) this.mClientCallback).onError(errorType, errorMsg);
    }

    @Override // com.android.server.credentials.ProviderSession.ProviderInternalCallback
    public void onFinalErrorReceived(ComponentName componentName, String errorType, String message) {
        Slog.d(TAG, "onFinalErrorReceived");
        if ("android.credentials.GetCredentialException.TYPE_USER_CANCELED".equals(errorType) == false) goto L6;
        Slog.d(TAG, "User canceled but session is not being terminated");
        return;
    L6:
        respondToFinalReceiverWithFailureAndFinish(errorType, message);
    }

    @Override // com.android.server.credentials.CredentialManagerUi.CredentialManagerUiCallback
    public void onUiCancellation(boolean isUserCancellation) {
        Slog.d(TAG, "User canceled but session is not being terminated");
    }

    private void respondToFinalReceiverWithFailureAndFinish(String exception, String message) {
        if (this.mRequestSessionStatus != RequestSession.RequestSessionStatus.COMPLETE) goto L7;
        Slog.w(TAG, "Request has already been completed. This is strange.");
        return;
    L7:
        if (this.mAutofillCallback == null) goto L9;
        Bundle resultData = new Bundle();
        resultData.putStringArray("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION", new String[]{exception, message});
        this.mAutofillCallback.send(-1, resultData);
    L10:
        finishSession(false, ApiStatus.FAILURE.getMetricCode());
        return;
    L9:
        Slog.w(TAG, "onUiCancellation called but mAutofillCallback not found");
        goto L10
    }

    @Override // com.android.server.credentials.CredentialManagerUi.CredentialManagerUiCallback
    public void onUiSelectorInvocationFailure() {
        this.mRequestSessionMetric.collectFrameworkException("android.credentials.GetCandidateCredentialsException.TYPE_NO_CREDENTIAL");
    }

    @Override // com.android.server.credentials.ProviderSession.ProviderInternalCallback
    public void onProviderStatusChanged(ProviderSession.Status status, ComponentName componentName, ProviderSession.CredentialsSource source) {
        Slog.d(TAG, "in onStatusChanged with status: " + status + ", and source: " + source);
        if (isAnyProviderPending() == false) goto L5;
        return;
    L5:
        if (isUiInvocationNeeded() == false) goto L7;
        Slog.d(TAG, "in onProviderStatusChanged - isUiInvocationNeeded");
        getProviderDataAndInitiateUi();
        return;
    L7:
        respondToClientWithErrorAndFinish("android.credentials.GetCandidateCredentialsException.TYPE_NO_CREDENTIAL", "No credentials available");
    }

    /* JADX INFO: renamed from: onFinalResponseReceived, reason: avoid collision after fix types in other method */
    public void onFinalResponseReceived2(ComponentName componentName, GetCredentialResponse response) {
        Slog.d(TAG, "onFinalResponseReceived");
        if (this.mRequestSessionStatus != RequestSession.RequestSessionStatus.COMPLETE) goto L6;
        Slog.w(TAG, "Request has already been completed. This is strange.");
        return;
    L6:
        respondToFinalReceiverWithResponseAndFinish(response);
    }

    private void respondToFinalReceiverWithResponseAndFinish(GetCredentialResponse response) {
        if (this.mRequestSessionStatus != RequestSession.RequestSessionStatus.COMPLETE) goto L7;
        Slog.w(TAG, "Request has already been completed. This is strange.");
        return;
    L7:
        if (this.mAutofillCallback == null) goto L9;
        Slog.d(TAG, "onFinalResponseReceived sending through final receiver");
        Bundle resultData = new Bundle();
        resultData.putParcelable("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE", response);
        this.mAutofillCallback.send(0, resultData);
        finishSession(false, ApiStatus.SUCCESS.getMetricCode());
        return;
    L9:
        Slog.w(TAG, "onFinalResponseReceived result receiver not found for pinned entry");
        finishSession(false, ApiStatus.FAILURE.getMetricCode());
    }

    public int getAutofillSessionId() {
        return this.mAutofillSessionId;
    }

    public int getAutofillRequestId() {
        return this.mAutofillRequestId;
    }
}
