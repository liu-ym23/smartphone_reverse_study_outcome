package com.android.server.credentials;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.credentials.GetCredentialRequest;
import android.credentials.IGetCredentialCallback;
import android.credentials.IPrepareGetCredentialCallback;
import android.credentials.PrepareGetCredentialResponseInternal;
import android.credentials.selection.GetCredentialProviderData;
import android.credentials.selection.ProviderData;
import android.credentials.selection.RequestInfo;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.service.credentials.CallingAppInfo;
import android.service.credentials.PermissionUtils;
import android.util.Slog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes.dex */
public class PrepareGetRequestSession extends GetRequestSession {
    private static final String TAG = "CredentialManager";
    private final IPrepareGetCredentialCallback mPrepareGetCredentialCallback;

    /* JADX INFO: renamed from: com.android.server.credentials.PrepareGetRequestSession$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$server$credentials$ProviderSession$CredentialsSource = null;

        static {
            $SwitchMap$com$android$server$credentials$ProviderSession$CredentialsSource = new int[ProviderSession.CredentialsSource.values().length];
            $SwitchMap$com$android$server$credentials$ProviderSession$CredentialsSource[ProviderSession.CredentialsSource.REMOTE_PROVIDER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L12:
            $SwitchMap$com$android$server$credentials$ProviderSession$CredentialsSource[ProviderSession.CredentialsSource.AUTH_ENTRY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-0CQtGfTShVctYyJ1iEj_6UrIqw, reason: not valid java name */
    public static /* synthetic */ boolean m3294$r8$lambda$0CQtGfTShVctYyJ1iEj_6UrIqw(GetCredentialProviderData r0) {
        return lambda$hasRemoteResults$1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$HuLWy8LRkXrj9hkxoS-B-FySBgA, reason: not valid java name */
    public static /* synthetic */ GetCredentialProviderData m3295$r8$lambda$HuLWy8LRkXrj9hkxoSBFySBgA(ProviderData r0) {
        return lambda$hasAuthenticationResults$2(r0);
    }

    public static /* synthetic */ ProviderGetSession $r8$lambda$Jze0f_JthyeSqOdIvaCCsO0mnmY(ProviderSession r0) {
        return lambda$getCredentialResultTypes$4(r0);
    }

    public static /* synthetic */ Stream $r8$lambda$NpzfcPY27GOs30tJSwFfmPyMSjU(ProviderGetSession r0) {
        return lambda$getCredentialResultTypes$5(r0);
    }

    public static /* synthetic */ GetCredentialProviderData $r8$lambda$SM2dfiXALxAfPkoVa4oJa866xEo(ProviderData r0) {
        return lambda$hasRemoteResults$0(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$_f5O0h24JrtNICOPmJRXuMQPfJM(GetCredentialProviderData r0) {
        return lambda$hasAuthenticationResults$3(r0);
    }

    public PrepareGetRequestSession(Context context, RequestSession.SessionLifetime sessionCallback, Object lock, int userId, int callingUid, IGetCredentialCallback getCredCallback, GetCredentialRequest request, CallingAppInfo callingAppInfo, Set<ComponentName> enabledProviders, CancellationSignal cancellationSignal, long startedTimestamp, IPrepareGetCredentialCallback prepareGetCredentialCallback) {
        super(context, sessionCallback, lock, userId, callingUid, getCredCallback, request, callingAppInfo, enabledProviders, cancellationSignal, startedTimestamp);
        ((Set) request.getCredentialOptions().stream().map(new CredentialManagerService$CredentialManagerServiceStub$$ExternalSyntheticLambda3()).collect(Collectors.toSet())).size();
        this.mRequestSessionMetric.collectGetFlowInitialMetricInfo(request, true);
        this.mPrepareGetCredentialCallback = prepareGetCredentialCallback;
        Slog.i(TAG, "PrepareGetRequestSession constructed.");
    }

    @Override // com.android.server.credentials.GetRequestSession, com.android.server.credentials.ProviderSession.ProviderInternalCallback
    public void onProviderStatusChanged(ProviderSession.Status status, ComponentName componentName, ProviderSession.CredentialsSource source) {
        Slog.i(TAG, "Provider Status changed with status: " + status + ", and source: " + source);
        switch(AnonymousClass1.$SwitchMap$com$android$server$credentials$ProviderSession$CredentialsSource[source.ordinal()]) {
            case 1: goto L13;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        Slog.w(TAG, "Unexpected source");
        return;
    L6:
        if (status != ProviderSession.Status.NO_CREDENTIALS_FROM_AUTH_ENTRY) goto L9;
        super.handleEmptyAuthenticationSelection(componentName);
        return;
    L9:
        if (status != ProviderSession.Status.CREDENTIALS_RECEIVED) goto L28;
        getProviderDataAndInitiateUi();
        return;
    L28:
        return;
    L13:
        if (isAnyProviderPending() == false) goto L15;
        return;
    L15:
        boolean hasQueryCandidatePermission = PermissionUtils.hasPermission(this.mContext, this.mClientAppInfo.getPackageName(), "android.permission.CREDENTIAL_MANAGER_QUERY_CANDIDATE_CREDENTIALS");
        if (isUiInvocationNeeded() == false) goto L23;
        ArrayList<ProviderData> providerData = getProviderDataForUi();
        if (providerData.isEmpty() == true) goto L23;
        constructPendingResponseAndInvokeCallback(hasQueryCandidatePermission, getCredentialResultTypes(hasQueryCandidatePermission), hasAuthenticationResults(providerData, hasQueryCandidatePermission), hasRemoteResults(providerData, hasQueryCandidatePermission), getUiIntent());
        return;
    L23:
        constructEmptyPendingResponseAndInvokeCallback(hasQueryCandidatePermission);
    }

    private void constructPendingResponseAndInvokeCallback(boolean hasPermission, Set<String> credentialTypes, boolean hasAuthenticationResults, boolean hasRemoteResults, PendingIntent uiIntent) {
        IPrepareGetCredentialCallback r0 = this.mPrepareGetCredentialCallback;     // Catch: RemoteException -> L8
        r0.onResponse(new PrepareGetCredentialResponseInternal(hasPermission, credentialTypes, hasAuthenticationResults, hasRemoteResults, uiIntent));     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        RemoteException e = e;
    L10:
        Slog.e(TAG, "EXCEPTION while mPendingCallback.onResponse", e);
        return;
    L8:
        e = move-exception;
        e = e;
        goto L10
    }

    private void constructEmptyPendingResponseAndInvokeCallback(boolean hasQueryCandidatePermission) {
        IPrepareGetCredentialCallback r0 = this.mPrepareGetCredentialCallback;     // Catch: RemoteException -> L8
        r0.onResponse(new PrepareGetCredentialResponseInternal(hasQueryCandidatePermission, null, false, false, null));     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        RemoteException e = e;
    L10:
        Slog.e(TAG, "EXCEPTION while mPendingCallback.onResponse", e);
        return;
    L8:
        e = move-exception;
        e = e;
        goto L10
    }

    private boolean hasRemoteResults(ArrayList<ProviderData> providerData, boolean hasQueryCandidatePermission) {
        if (hasQueryCandidatePermission == true) goto L6;
        return false;
    L6:
        return providerData.stream().map(new PrepareGetRequestSession$$ExternalSyntheticLambda4()).anyMatch(new PrepareGetRequestSession$$ExternalSyntheticLambda5());
    }

    private static /* synthetic */ GetCredentialProviderData lambda$hasRemoteResults$0(ProviderData data) {
        return (GetCredentialProviderData) data;
    }

    private static /* synthetic */ boolean lambda$hasRemoteResults$1(GetCredentialProviderData getCredentialProviderData) {
        if (getCredentialProviderData.getRemoteEntry() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasAuthenticationResults(ArrayList<ProviderData> providerData, boolean hasQueryCandidatePermission) {
        if (hasQueryCandidatePermission == true) goto L6;
        return false;
    L6:
        return providerData.stream().map(new PrepareGetRequestSession$$ExternalSyntheticLambda2()).anyMatch(new PrepareGetRequestSession$$ExternalSyntheticLambda3());
    }

    private static /* synthetic */ GetCredentialProviderData lambda$hasAuthenticationResults$2(ProviderData data) {
        return (GetCredentialProviderData) data;
    }

    private static /* synthetic */ boolean lambda$hasAuthenticationResults$3(GetCredentialProviderData getCredentialProviderData) {
        return !getCredentialProviderData.getAuthenticationEntries().isEmpty();
    }

    private Set<String> getCredentialResultTypes(boolean hasQueryCandidatePermission) {
        if (hasQueryCandidatePermission == true) goto L6;
        return null;
    L6:
        return (Set) this.mProviders.values().stream().map(new PrepareGetRequestSession$$ExternalSyntheticLambda0()).flatMap(new PrepareGetRequestSession$$ExternalSyntheticLambda1()).collect(Collectors.toSet());
    }

    private static /* synthetic */ ProviderGetSession lambda$getCredentialResultTypes$4(ProviderSession session) {
        return (ProviderGetSession) session;
    }

    private static /* synthetic */ Stream lambda$getCredentialResultTypes$5(ProviderGetSession providerGetSession) {
        return providerGetSession.getCredentialEntryTypes().stream();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PendingIntent getUiIntent() {
        ArrayList<ProviderData> providerDataList = new ArrayList();
        Iterator<ProviderSession> r1 = this.mProviders.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        ProviderSession session = r1.next();
        ProviderData providerData = session.mo3297prepareUiData();
        if (providerData == null) goto L4;
        providerDataList.add(providerData);
        goto L4
    L10:
        if (providerDataList.isEmpty() == false) goto L12;
        return null;
    L12:
        return this.mCredentialManagerUi.createPendingIntent(RequestInfo.newGetRequestInfo(this.mRequestId, (GetCredentialRequest) this.mClientRequest, this.mClientAppInfo.getPackageName(), PermissionUtils.hasPermission(this.mContext, this.mClientAppInfo.getPackageName(), "android.permission.CREDENTIAL_MANAGER_SET_ALLOWED_PROVIDERS"), false), providerDataList, this.mRequestSessionMetric);
    }
}
