package com.android.server.credentials;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.credentials.CreateCredentialException;
import android.credentials.CreateCredentialResponse;
import android.credentials.CredentialProviderInfo;
import android.credentials.selection.CreateCredentialProviderData;
import android.credentials.selection.Entry;
import android.credentials.selection.ProviderData;
import android.credentials.selection.ProviderPendingIntentResponse;
import android.os.Bundle;
import android.os.ICancellationSignal;
import android.service.credentials.BeginCreateCredentialRequest;
import android.service.credentials.BeginCreateCredentialResponse;
import android.service.credentials.CallingAppInfo;
import android.service.credentials.CreateCredentialRequest;
import android.service.credentials.CreateEntry;
import android.service.credentials.RemoteEntry;
import android.util.Pair;
import android.util.Slog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ProviderCreateSession extends ProviderSession<BeginCreateCredentialRequest, BeginCreateCredentialResponse> {
    private static final String REMOTE_ENTRY_KEY = "remote_entry_key";
    public static final String SAVE_ENTRY_KEY = "save_entry_key";
    private static final String TAG = "CredentialManager";
    private final CreateCredentialRequest mCompleteRequest;
    private CreateCredentialException mProviderException;
    private final ProviderResponseDataHandler mProviderResponseDataHandler;

    private class ProviderResponseDataHandler {
        private final ComponentName mExpectedRemoteEntryProviderService;
        private final Map<String, Pair<CreateEntry, Entry>> mUiCreateEntries;
        private Pair<String, Pair<RemoteEntry, Entry>> mUiRemoteEntry;
        final /* synthetic */ ProviderCreateSession this$0;

        /* JADX INFO: renamed from: -$$Nest$misEmptyResponse, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m3298$$Nest$misEmptyResponse(ProviderResponseDataHandler r0) {
            return r0.isEmptyResponse();
        }

        ProviderResponseDataHandler(ProviderCreateSession r1, ComponentName expectedRemoteEntryProviderService) {
            this.this$0 = r1;
            this.mUiCreateEntries = new HashMap();
            this.mUiRemoteEntry = null;
            this.mExpectedRemoteEntryProviderService = expectedRemoteEntryProviderService;
        }

        public void addResponseContent(List<CreateEntry> createEntries, RemoteEntry remoteEntry) {
            createEntries.forEach(new ProviderCreateSession$ProviderResponseDataHandler$$ExternalSyntheticLambda0(this));
            if (remoteEntry == null) goto L6;
            setRemoteEntry(remoteEntry);
            return;
        }

        public void addCreateEntry(CreateEntry createEntry) {
            String id = ProviderSession.generateUniqueId();
            Entry entry = new Entry(ProviderCreateSession.SAVE_ENTRY_KEY, id, createEntry.getSlice(), ProviderCreateSession.m3296$$Nest$msetUpFillInIntent(this.this$0));
            this.mUiCreateEntries.put(id, new Pair(createEntry, entry));
        }

        public void setRemoteEntry(RemoteEntry remoteEntry) {
            if (this.this$0.enforceRemoteEntryRestrictions(this.mExpectedRemoteEntryProviderService) == true) goto L6;
            Slog.w(ProviderCreateSession.TAG, "Remote entry being dropped as it does not meet the restrictionchecks.");
            return;
        L6:
            if (remoteEntry != null) goto L9;
            this.mUiRemoteEntry = null;
            return;
        L9:
            String id = ProviderSession.generateUniqueId();
            Entry entry = new Entry("remote_entry_key", id, remoteEntry.getSlice(), ProviderCreateSession.m3296$$Nest$msetUpFillInIntent(this.this$0));
            this.mUiRemoteEntry = new Pair(id, new Pair(remoteEntry, entry));
        }

        public CreateCredentialProviderData toCreateCredentialProviderData() {
            return new CreateCredentialProviderData.Builder(this.this$0.mComponentName.flattenToString()).setSaveEntries(prepareUiCreateEntries()).setRemoteEntry(prepareRemoteEntry()).build();
        }

        private List<Entry> prepareUiCreateEntries() {
            List<Entry> createEntries = new ArrayList();
            Iterator<String> r1 = this.mUiCreateEntries.keySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            String key = r1.next();
            createEntries.add((Entry) this.mUiCreateEntries.get(key).second);
            goto L4
        L6:
            return createEntries;
        }

        private Entry prepareRemoteEntry() {
            if (this.mUiRemoteEntry != null) goto L5;
            return null;
        L5:
            if (this.mUiRemoteEntry.first != null) goto L7;
            return null;
        L7:
            if (this.mUiRemoteEntry.second != null) goto L10;
            return null;
        L10:
            return (Entry) ((Pair) this.mUiRemoteEntry.second).second;
        }

        private boolean isEmptyResponse() {
            if (this.mUiCreateEntries.isEmpty() == true) goto L5;
        L7:
            return false;
        L5:
            if (this.mUiRemoteEntry != null) goto L7;
            return true;
        }

        public RemoteEntry getRemoteEntry(String entryKey) {
            if (this.mUiRemoteEntry != null) goto L5;
        L12:
            return null;
        L5:
            if (this.mUiRemoteEntry.first == null) goto L12;
            if (((String) this.mUiRemoteEntry.first).equals(entryKey) == false) goto L12;
            if (this.mUiRemoteEntry.second == null) goto L12;
            return (RemoteEntry) ((Pair) this.mUiRemoteEntry.second).first;
        }

        public CreateEntry getCreateEntry(String entryKey) {
            if (this.mUiCreateEntries.get(entryKey) != null) goto L6;
            return null;
        L6:
            return (CreateEntry) this.mUiCreateEntries.get(entryKey).first;
        }

        public boolean isEmptyResponse(BeginCreateCredentialResponse response) {
            if (response.getCreateEntries() == null) goto L7;
            if (response.getCreateEntries().isEmpty() == true) goto L7;
        L9:
            return false;
        L7:
            if (response.getRemoteCreateEntry() != null) goto L9;
            return true;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$msetUpFillInIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ Intent m3296$$Nest$msetUpFillInIntent(ProviderCreateSession r0) {
        return r0.setUpFillInIntent();
    }

    @Override // com.android.server.credentials.RemoteCredentialService.ProviderCallbacks
    public /* bridge */ /* synthetic */ void onProviderResponseSuccess(Object r1) {
        onProviderResponseSuccess((BeginCreateCredentialResponse) r1);
    }

    @Override // com.android.server.credentials.ProviderSession
    /* JADX INFO: renamed from: prepareUiData, reason: collision with other method in class */
    protected /* bridge */ /* synthetic */ ProviderData mo3297prepareUiData() {
        return prepareUiData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ProviderCreateSession createNewSession(Context context, int userId, CredentialProviderInfo providerInfo, CreateRequestSession createRequestSession, RemoteCredentialService remoteCredentialService) {
        CreateCredentialRequest providerCreateRequest = createProviderRequest(providerInfo.getCapabilities(), (android.credentials.CreateCredentialRequest) createRequestSession.mClientRequest, createRequestSession.mClientAppInfo, providerInfo.isSystemProvider());
        if (providerCreateRequest != null) goto L5;
        Slog.i(TAG, "Unable to create provider session for: " + providerInfo.getComponentName());
        return null;
    L5:
        return new ProviderCreateSession(context, providerInfo, createRequestSession, userId, remoteCredentialService, constructQueryPhaseRequest(((android.credentials.CreateCredentialRequest) createRequestSession.mClientRequest).getType(), ((android.credentials.CreateCredentialRequest) createRequestSession.mClientRequest).getCandidateQueryData(), createRequestSession.mClientAppInfo, ((android.credentials.CreateCredentialRequest) createRequestSession.mClientRequest).alwaysSendAppInfoToProvider()), providerCreateRequest, createRequestSession.mHybridService);
    }

    private static BeginCreateCredentialRequest constructQueryPhaseRequest(String type, Bundle candidateQueryData, CallingAppInfo callingAppInfo, boolean propagateToProvider) {
        if (propagateToProvider == false) goto L6;
        return new BeginCreateCredentialRequest(type, candidateQueryData, callingAppInfo);
    L6:
        return new BeginCreateCredentialRequest(type, candidateQueryData);
    }

    private static CreateCredentialRequest createProviderRequest(List<String> providerCapabilities, android.credentials.CreateCredentialRequest clientRequest, CallingAppInfo callingAppInfo, boolean isSystemProvider) {
        if (clientRequest.isSystemProviderRequired() == false) goto L6;
        if (isSystemProvider == true) goto L6;
        return null;
    L6:
        String capability = clientRequest.getType();
        if (providerCapabilities.contains(capability) == true) goto L9;
        return null;
    L9:
        return new CreateCredentialRequest(callingAppInfo, capability, clientRequest.getCredentialData());
    }

    private ProviderCreateSession(Context context, CredentialProviderInfo info, ProviderSession.ProviderInternalCallback<CreateCredentialResponse> callbacks, int userId, RemoteCredentialService remoteCredentialService, BeginCreateCredentialRequest beginCreateRequest, CreateCredentialRequest completeCreateRequest, String hybridService) {
        super(context, beginCreateRequest, callbacks, info.getComponentName(), userId, remoteCredentialService);
        this.mCompleteRequest = completeCreateRequest;
        setStatus(ProviderSession.Status.PENDING);
        this.mProviderResponseDataHandler = new ProviderResponseDataHandler(this, ComponentName.unflattenFromString(hybridService));
    }

    public void onProviderResponseSuccess(BeginCreateCredentialResponse response) {
        Slog.i(TAG, "Remote provider responded with a valid response: " + this.mComponentName);
        onSetInitialRemoteResponse(response);
    }

    @Override // com.android.server.credentials.RemoteCredentialService.ProviderCallbacks
    public void onProviderResponseFailure(int errorCode, Exception exception) {
        if ((exception instanceof CreateCredentialException) == false) goto L5;
        this.mProviderException = (CreateCredentialException) exception;
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

    /* JADX WARN: Multi-variable type inference failed */
    private void onSetInitialRemoteResponse(BeginCreateCredentialResponse r4) {
        this.mProviderResponse = r4;
        this.mProviderResponseDataHandler.addResponseContent(r4.getCreateEntries(), r4.getRemoteCreateEntry());
        if (this.mProviderResponseDataHandler.isEmptyResponse(r4) == false) goto L5;
        this.mProviderSessionMetric.collectCandidateEntryMetrics(r4, false, ((RequestSession) this.mCallbacks).mRequestSessionMetric.getInitialPhaseMetric());
        updateStatusAndInvokeCallback(ProviderSession.Status.EMPTY_RESPONSE, ProviderSession.CredentialsSource.REMOTE_PROVIDER);
        return;
    L5:
        this.mProviderSessionMetric.collectCandidateEntryMetrics(r4, false, ((RequestSession) this.mCallbacks).mRequestSessionMetric.getInitialPhaseMetric());
        updateStatusAndInvokeCallback(ProviderSession.Status.SAVE_ENTRIES_RECEIVED, ProviderSession.CredentialsSource.REMOTE_PROVIDER);
    }

    protected CreateCredentialProviderData prepareUiData() throws IllegalArgumentException {
        if (ProviderSession.isUiInvokingStatus(getStatus()) == true) goto L7;
        Slog.i(TAG, "No data for UI from: " + this.mComponentName.flattenToString());
        return null;
    L7:
        if (this.mProviderResponse != 0) goto L9;
    L12:
        return null;
    L9:
        if (ProviderResponseDataHandler.m3298$$Nest$misEmptyResponse(this.mProviderResponseDataHandler) == true) goto L12;
        return this.mProviderResponseDataHandler.toCreateCredentialProviderData();
    }

    @Override // com.android.server.credentials.ProviderSession
    public void onUiEntrySelected(String entryType, String entryKey, ProviderPendingIntentResponse providerPendingIntentResponse) {
        switch(entryType.hashCode()) {
            case -1424551728: goto L9;
            case 1110515801: goto L6;
            default: goto L11;
        };
    L11:
        byte r0 = -1;
    L13:
        switch(r0) {
            case 0: goto L21;
            case 1: goto L16;
            default: goto L14;
        };
    L14:
        Slog.i(TAG, "Unsupported entry type selected");
        invokeCallbackOnInternalInvalidState();
        return;
    L16:
        if (this.mProviderResponseDataHandler.getRemoteEntry(entryKey) != null) goto L19;
        Slog.i(TAG, "Unexpected remote entry key");
        invokeCallbackOnInternalInvalidState();
        return;
    L19:
        onRemoteEntrySelected(providerPendingIntentResponse);
        return;
    L21:
        if (this.mProviderResponseDataHandler.getCreateEntry(entryKey) != null) goto L24;
        Slog.i(TAG, "Unexpected save entry key");
        invokeCallbackOnInternalInvalidState();
        return;
    L24:
        onCreateEntrySelected(providerPendingIntentResponse);
        return;
    L6:
        if (entryType.equals("remote_entry_key") == false) goto L11;
        r0 = 1;
        goto L13
    L9:
        if (entryType.equals(SAVE_ENTRY_KEY) == false) goto L11;
        r0 = 0;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.server.credentials.ProviderSession
    protected void invokeSession() {
        if (this.mRemoteCredentialService == null) goto L6;
        startCandidateMetrics();
        this.mRemoteCredentialService.setCallback(this);
        this.mRemoteCredentialService.onBeginCreateCredential((BeginCreateCredentialRequest) this.mProviderRequest);
        return;
    }

    private Intent setUpFillInIntent() {
        Intent intent = new Intent();
        intent.putExtra("android.service.credentials.extra.CREATE_CREDENTIAL_REQUEST", this.mCompleteRequest);
        return intent;
    }

    private void onCreateEntrySelected(ProviderPendingIntentResponse pendingIntentResponse) {
        CreateCredentialException exception = maybeGetPendingIntentException(pendingIntentResponse);
        if (exception == null) goto L6;
        invokeCallbackWithError(exception.getType(), exception.getMessage());
        return;
    L6:
        CreateCredentialResponse credentialResponse = PendingIntentResultHandler.extractCreateCredentialResponse(pendingIntentResponse.getResultData());
        if (credentialResponse == null) goto L9;
        this.mCallbacks.onFinalResponseReceived(this.mComponentName, credentialResponse);
        return;
    L9:
        Slog.i(TAG, "onSaveEntrySelected - no response or error found in pending intent response");
        invokeCallbackOnInternalInvalidState();
    }

    private void onRemoteEntrySelected(ProviderPendingIntentResponse pendingIntentResponse) {
        onCreateEntrySelected(pendingIntentResponse);
    }

    private CreateCredentialException maybeGetPendingIntentException(ProviderPendingIntentResponse pendingIntentResponse) {
        if (pendingIntentResponse != null) goto L7;
        Slog.i(TAG, "pendingIntentResponse is null");
        return new CreateCredentialException("android.credentials.CreateCredentialException.TYPE_NO_CREATE_OPTIONS");
    L7:
        if (PendingIntentResultHandler.isValidResponse(pendingIntentResponse) == false) goto L15;
        CreateCredentialException exception = PendingIntentResultHandler.extractCreateCredentialException(pendingIntentResponse.getResultData());
        if (exception == null) goto L12;
        Slog.i(TAG, "Pending intent contains provider exception");
        return exception;
    L12:
        return null;
    L15:
        if (PendingIntentResultHandler.isCancelledResponse(pendingIntentResponse) == false) goto L19;
        return new CreateCredentialException("android.credentials.CreateCredentialException.TYPE_USER_CANCELED");
    L19:
        return new CreateCredentialException("android.credentials.CreateCredentialException.TYPE_NO_CREATE_OPTIONS");
    }

    private void invokeCallbackOnInternalInvalidState() {
        this.mCallbacks.onFinalErrorReceived(this.mComponentName, "android.credentials.CreateCredentialException.TYPE_UNKNOWN", null);
    }
}
