package com.android.server.credentials;

import android.content.Context;
import android.credentials.ClearCredentialStateException;
import android.credentials.CredentialProviderInfo;
import android.credentials.selection.ProviderData;
import android.credentials.selection.ProviderPendingIntentResponse;
import android.os.ICancellationSignal;
import android.service.credentials.CallingAppInfo;
import android.service.credentials.ClearCredentialStateRequest;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public final class ProviderClearSession extends ProviderSession<ClearCredentialStateRequest, Void> implements RemoteCredentialService.ProviderCallbacks<Void> {
    private static final String TAG = "CredentialManager";
    private ClearCredentialStateException mProviderException;

    @Override // com.android.server.credentials.RemoteCredentialService.ProviderCallbacks
    public /* bridge */ /* synthetic */ void onProviderResponseSuccess(Void r1) {
        onProviderResponseSuccess2(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ProviderClearSession createNewSession(Context context, int userId, CredentialProviderInfo providerInfo, ClearRequestSession clearRequestSession, RemoteCredentialService remoteCredentialService) {
        ClearCredentialStateRequest providerRequest = createProviderRequest((android.credentials.ClearCredentialStateRequest) clearRequestSession.mClientRequest, clearRequestSession.mClientAppInfo);
        return new ProviderClearSession(context, providerInfo, clearRequestSession, userId, remoteCredentialService, providerRequest);
    }

    private static ClearCredentialStateRequest createProviderRequest(android.credentials.ClearCredentialStateRequest clientRequest, CallingAppInfo callingAppInfo) {
        return new ClearCredentialStateRequest(callingAppInfo, clientRequest.getData());
    }

    public ProviderClearSession(Context context, CredentialProviderInfo info, ProviderSession.ProviderInternalCallback callbacks, int userId, RemoteCredentialService remoteCredentialService, ClearCredentialStateRequest providerRequest) {
        super(context, providerRequest, callbacks, info.getComponentName(), userId, remoteCredentialService);
        setStatus(ProviderSession.Status.PENDING);
    }

    /* JADX INFO: renamed from: onProviderResponseSuccess, reason: avoid collision after fix types in other method */
    public void onProviderResponseSuccess2(Void response) {
        Slog.i(TAG, "Remote provider responded with a valid response: " + this.mComponentName);
        this.mProviderResponseSet = true;
        updateStatusAndInvokeCallback(ProviderSession.Status.COMPLETE, ProviderSession.CredentialsSource.REMOTE_PROVIDER);
    }

    @Override // com.android.server.credentials.RemoteCredentialService.ProviderCallbacks
    public void onProviderResponseFailure(int errorCode, Exception exception) {
        if ((exception instanceof ClearCredentialStateException) == false) goto L5;
        this.mProviderException = (ClearCredentialStateException) exception;
        this.mProviderSessionMetric.collectCandidateFrameworkException(this.mProviderException.getType());
    L5:
        this.mProviderSessionMetric.collectCandidateExceptionStatus(true);
        updateStatusAndInvokeCallback(ProviderSession.Status.CANCELED, ProviderSession.CredentialsSource.REMOTE_PROVIDER);
    }

    @Override // com.android.server.credentials.RemoteCredentialService.ProviderCallbacks
    public void onProviderServiceDied(RemoteCredentialService service) {
        if (service.getComponentName().equals(this.mComponentName) == false) goto L5;
        updateStatusAndInvokeCallback(ProviderSession.Status.SERVICE_DEAD, ProviderSession.CredentialsSource.REMOTE_PROVIDER);
        return;
    L5:
        Slog.w(TAG, "Component names different in onProviderServiceDied - this should not happen");
    }

    @Override // com.android.server.credentials.RemoteCredentialService.ProviderCallbacks
    public void onProviderCancellable(ICancellationSignal cancellation) {
        this.mProviderCancellationSignal = cancellation;
    }

    @Override // com.android.server.credentials.ProviderSession
    /* JADX INFO: renamed from: prepareUiData */
    protected ProviderData mo3297prepareUiData() {
        return null;
    }

    @Override // com.android.server.credentials.ProviderSession
    protected void onUiEntrySelected(String entryType, String entryId, ProviderPendingIntentResponse providerPendingIntentResponse) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.server.credentials.ProviderSession
    protected void invokeSession() {
        if (this.mRemoteCredentialService == null) goto L6;
        startCandidateMetrics();
        this.mRemoteCredentialService.setCallback(this);
        this.mRemoteCredentialService.onClearCredentialState((ClearCredentialStateRequest) this.mProviderRequest);
        return;
    }
}
