package com.android.server.credentials;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.credentials.CredentialOption;
import android.credentials.GetCredentialException;
import android.credentials.GetCredentialResponse;
import android.credentials.selection.Entry;
import android.credentials.selection.GetCredentialProviderData;
import android.credentials.selection.ProviderData;
import android.credentials.selection.ProviderPendingIntentResponse;
import android.os.ICancellationSignal;
import android.service.credentials.CallingAppInfo;
import android.service.credentials.CredentialEntry;
import android.service.credentials.GetCredentialRequest;
import android.util.Slog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes.dex */
public class ProviderRegistryGetSession extends ProviderSession<CredentialOption, Set<CredentialDescriptionRegistry.FilterResult>> {
    static final String CREDENTIAL_ENTRY_KEY = "credential_key";
    private static final String TAG = "CredentialManager";
    private final CallingAppInfo mCallingAppInfo;
    private final CredentialDescriptionRegistry mCredentialDescriptionRegistry;
    List<CredentialEntry> mCredentialEntries;
    private final String mCredentialProviderPackageName;
    private final Set<String> mElementKeys;
    private final Map<String, CredentialEntry> mUiCredentialEntries;

    /* JADX INFO: renamed from: $r8$lambda$5K9Gjj3FHUFG4z7Rn9N-0lDRetU, reason: not valid java name */
    public static /* synthetic */ Stream m3308$r8$lambda$5K9Gjj3FHUFG4z7Rn9N0lDRetU(CredentialDescriptionRegistry.FilterResult r0) {
        return lambda$prepareUiData$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$wjzPfLM7STAnAbny-5OQUBVryDg, reason: not valid java name */
    public static /* synthetic */ Stream m3309$r8$lambda$wjzPfLM7STAnAbny5OQUBVryDg(CredentialDescriptionRegistry.FilterResult r0) {
        return lambda$invokeSession$1(r0);
    }

    @Override // com.android.server.credentials.RemoteCredentialService.ProviderCallbacks
    public /* bridge */ /* synthetic */ void onProviderResponseSuccess(Object r1) {
        onProviderResponseSuccess((Set) r1);
    }

    public static ProviderRegistryGetSession createNewSession(Context context, int userId, GetRequestSession getRequestSession, CallingAppInfo callingAppInfo, String credentialProviderPackageName, CredentialOption requestOption) {
        return new ProviderRegistryGetSession(context, userId, getRequestSession, callingAppInfo, credentialProviderPackageName, requestOption);
    }

    public static ProviderRegistryGetSession createNewSession(Context context, int userId, PrepareGetRequestSession getRequestSession, CallingAppInfo callingAppInfo, String credentialProviderPackageName, CredentialOption requestOption) {
        return new ProviderRegistryGetSession(context, userId, getRequestSession, callingAppInfo, credentialProviderPackageName, requestOption);
    }

    protected ProviderRegistryGetSession(Context context, int userId, GetRequestSession session, CallingAppInfo callingAppInfo, String servicePackageName, CredentialOption requestOption) {
        super(context, requestOption, session, new ComponentName(servicePackageName, UUID.randomUUID().toString()), userId, null);
        this.mUiCredentialEntries = new HashMap();
        this.mCredentialDescriptionRegistry = CredentialDescriptionRegistry.forUser(userId);
        this.mCallingAppInfo = callingAppInfo;
        this.mCredentialProviderPackageName = servicePackageName;
        this.mElementKeys = new HashSet(requestOption.getCredentialRetrievalData().getStringArrayList("android.credentials.GetCredentialOption.SUPPORTED_ELEMENT_KEYS"));
        this.mStatus = ProviderSession.Status.PENDING;
    }

    protected ProviderRegistryGetSession(Context context, int userId, PrepareGetRequestSession session, CallingAppInfo callingAppInfo, String servicePackageName, CredentialOption requestOption) {
        super(context, requestOption, session, new ComponentName(servicePackageName, UUID.randomUUID().toString()), userId, null);
        this.mUiCredentialEntries = new HashMap();
        this.mCredentialDescriptionRegistry = CredentialDescriptionRegistry.forUser(userId);
        this.mCallingAppInfo = callingAppInfo;
        this.mCredentialProviderPackageName = servicePackageName;
        this.mElementKeys = new HashSet(requestOption.getCredentialRetrievalData().getStringArrayList("android.credentials.GetCredentialOption.SUPPORTED_ELEMENT_KEYS"));
        this.mStatus = ProviderSession.Status.PENDING;
    }

    private List<Entry> prepareUiCredentialEntries(List<CredentialEntry> credentialEntries) {
        List<Entry> credentialUiEntries = new ArrayList();
        Iterator<CredentialEntry> r1 = credentialEntries.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        CredentialEntry credentialEntry = r1.next();
        String entryId = ProviderSession.generateUniqueId();
        this.mUiCredentialEntries.put(entryId, credentialEntry);
        credentialUiEntries.add(new Entry("credential_key", entryId, credentialEntry.getSlice(), setUpFillInIntent()));
        goto L4
    L6:
        return credentialUiEntries;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Intent setUpFillInIntent() {
        Intent intent = new Intent();
        intent.putExtra("android.service.credentials.extra.GET_CREDENTIAL_REQUEST", new GetCredentialRequest(this.mCallingAppInfo, List.of((CredentialOption) this.mProviderRequest)));
        return intent;
    }

    @Override // com.android.server.credentials.ProviderSession
    /* JADX INFO: renamed from: prepareUiData */
    protected ProviderData mo3297prepareUiData() {
        if (ProviderSession.isUiInvokingStatus(getStatus()) == true) goto L7;
        Slog.i(TAG, "No date for UI coming from: " + this.mComponentName.flattenToString());
        return null;
    L7:
        if (this.mProviderResponse != 0) goto L11;
        Slog.w(TAG, "response is null when preparing ui data. This is strange.");
        return null;
    L11:
        return new GetCredentialProviderData.Builder(this.mComponentName.flattenToString()).setActionChips(Collections.EMPTY_LIST).setAuthenticationEntries(Collections.EMPTY_LIST).setCredentialEntries(prepareUiCredentialEntries((List) ((Set) this.mProviderResponse).stream().flatMap(new ProviderRegistryGetSession$$ExternalSyntheticLambda1()).collect(Collectors.toList()))).build();
    }

    private static /* synthetic */ Stream lambda$prepareUiData$0(CredentialDescriptionRegistry.FilterResult filterResult) {
        return filterResult.mCredentialEntries.stream();
    }

    @Override // com.android.server.credentials.ProviderSession
    protected void onUiEntrySelected(String entryType, String entryKey, ProviderPendingIntentResponse providerPendingIntentResponse) {
        switch(entryType.hashCode()) {
            case 1208398455: goto L6;
            default: goto L8;
        };
    L8:
        byte r0 = -1;
    L10:
        switch(r0) {
            case 0: goto L12;
            default: goto L11;
        };
    L11:
        Slog.i(TAG, "Unsupported entry type selected");
        return;
    L12:
        CredentialEntry credentialEntry = this.mUiCredentialEntries.get(entryKey);
        if (credentialEntry != null) goto L16;
        Slog.i(TAG, "Unexpected credential entry key");
        return;
    L16:
        onCredentialEntrySelected(credentialEntry, providerPendingIntentResponse);
        return;
    L6:
        if (entryType.equals("credential_key") == false) goto L8;
        r0 = 0;
        goto L10
    }

    private void onCredentialEntrySelected(CredentialEntry credentialEntry, ProviderPendingIntentResponse providerPendingIntentResponse) {
        if (providerPendingIntentResponse == null) goto L13;
        GetCredentialException exception = maybeGetPendingIntentException(providerPendingIntentResponse);
        if (exception == null) goto L7;
        invokeCallbackWithError(exception.getType(), exception.getMessage());
        return;
    L7:
        GetCredentialResponse getCredentialResponse = PendingIntentResultHandler.extractGetCredentialResponse(providerPendingIntentResponse.getResultData());
        if (getCredentialResponse == null) goto L13;
        if (this.mCallbacks == null) goto L15;
        ((GetRequestSession) this.mCallbacks).onFinalResponseReceived2(this.mComponentName, getCredentialResponse);
        return;
    L15:
        return;
    L13:
        Slog.w(TAG, "CredentialEntry does not have a credential or a pending intent result");
    }

    public void onProviderResponseSuccess(Set<CredentialDescriptionRegistry.FilterResult> response) {
    }

    @Override // com.android.server.credentials.RemoteCredentialService.ProviderCallbacks
    public void onProviderResponseFailure(int internalErrorCode, Exception e) {
    }

    @Override // com.android.server.credentials.RemoteCredentialService.ProviderCallbacks
    public void onProviderServiceDied(RemoteCredentialService service) {
    }

    @Override // com.android.server.credentials.RemoteCredentialService.ProviderCallbacks
    public void onProviderCancellable(ICancellationSignal cancellation) {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [R, java.util.Set] */
    @Override // com.android.server.credentials.ProviderSession
    protected void invokeSession() {
        startCandidateMetrics();
        this.mProviderResponse = this.mCredentialDescriptionRegistry.getFilteredResultForProvider(this.mCredentialProviderPackageName, this.mElementKeys);
        this.mCredentialEntries = (List) ((Set) this.mProviderResponse).stream().flatMap(new ProviderRegistryGetSession$$ExternalSyntheticLambda0()).collect(Collectors.toList());
        updateStatusAndInvokeCallback(ProviderSession.Status.CREDENTIALS_RECEIVED, ProviderSession.CredentialsSource.REGISTRY);
        this.mProviderSessionMetric.collectCandidateEntryMetrics(this.mCredentialEntries);
    }

    private static /* synthetic */ Stream lambda$invokeSession$1(CredentialDescriptionRegistry.FilterResult filterResult) {
        return filterResult.mCredentialEntries.stream();
    }

    protected GetCredentialException maybeGetPendingIntentException(ProviderPendingIntentResponse pendingIntentResponse) {
        if (pendingIntentResponse != null) goto L6;
        return null;
    L6:
        if (PendingIntentResultHandler.isValidResponse(pendingIntentResponse) == false) goto L14;
        GetCredentialException exception = PendingIntentResultHandler.extractGetCredentialException(pendingIntentResponse.getResultData());
        if (exception == null) goto L12;
        Slog.i(TAG, "Pending intent contains provider exception");
        return exception;
    L12:
        return null;
    L14:
        if (PendingIntentResultHandler.isCancelledResponse(pendingIntentResponse) == false) goto L18;
        return new GetCredentialException("android.credentials.GetCredentialException.TYPE_USER_CANCELED");
    L18:
        return new GetCredentialException("android.credentials.GetCredentialException.TYPE_NO_CREDENTIAL");
    }
}
