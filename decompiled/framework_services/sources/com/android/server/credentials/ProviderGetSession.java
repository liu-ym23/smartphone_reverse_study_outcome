package com.android.server.credentials;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.credentials.CredentialOption;
import android.credentials.CredentialProviderInfo;
import android.credentials.GetCredentialException;
import android.credentials.GetCredentialRequest;
import android.credentials.GetCredentialResponse;
import android.credentials.selection.AuthenticationEntry;
import android.credentials.selection.Entry;
import android.credentials.selection.GetCredentialProviderData;
import android.credentials.selection.ProviderData;
import android.credentials.selection.ProviderPendingIntentResponse;
import android.os.ICancellationSignal;
import android.os.Parcelable;
import android.service.credentials.Action;
import android.service.credentials.BeginGetCredentialOption;
import android.service.credentials.BeginGetCredentialRequest;
import android.service.credentials.BeginGetCredentialResponse;
import android.service.credentials.CallingAppInfo;
import android.service.credentials.CredentialEntry;
import android.service.credentials.RemoteEntry;
import android.util.Pair;
import android.util.Slog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ProviderGetSession extends ProviderSession<BeginGetCredentialRequest, BeginGetCredentialResponse> implements RemoteCredentialService.ProviderCallbacks<BeginGetCredentialResponse> {
    public static final String ACTION_ENTRY_KEY = "action_key";
    public static final String AUTHENTICATION_ACTION_ENTRY_KEY = "authentication_action_key";
    public static final String CREDENTIAL_ENTRY_KEY = "credential_key";
    public static final String REMOTE_ENTRY_KEY = "remote_entry_key";
    private static final String TAG = "CredentialManager";
    private final Map<String, CredentialOption> mBeginGetOptionToCredentialOptionMap;
    private final CallingAppInfo mCallingAppInfo;
    private final GetCredentialRequest mCompleteRequest;
    private GetCredentialException mProviderException;
    private final ProviderResponseDataHandler mProviderResponseDataHandler;

    private class ProviderResponseDataHandler {
        private final Set<String> mCredentialEntryTypes;
        private final ComponentName mExpectedRemoteEntryProviderService;
        private final Map<String, Pair<Action, Entry>> mUiActionsEntries;
        private final Map<String, Pair<Action, AuthenticationEntry>> mUiAuthenticationEntries;
        private final Map<String, Pair<CredentialEntry, Entry>> mUiCredentialEntries;
        private Pair<String, Pair<RemoteEntry, Entry>> mUiRemoteEntry;
        final /* synthetic */ ProviderGetSession this$0;

        public static /* synthetic */ void $r8$lambda$XteVbqALiBcKlLbDIybFMm78hkk(ProviderResponseDataHandler r0, Action r1) {
            r0.lambda$addResponseContent$0(r1);
        }

        public static /* synthetic */ boolean $r8$lambda$rQOarYEMg3aVPbkRVPKBmV9wCfw(Map.Entry r0) {
            return lambda$updatePreviousMostRecentAuthEntry$1(r0);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUiAuthenticationEntries, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m3303$$Nest$fgetmUiAuthenticationEntries(ProviderResponseDataHandler r0) {
            return r0.mUiAuthenticationEntries;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUiCredentialEntries, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m3304$$Nest$fgetmUiCredentialEntries(ProviderResponseDataHandler r0) {
            return r0.mUiCredentialEntries;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUiRemoteEntry, reason: not valid java name */
        static /* bridge */ /* synthetic */ Pair m3305$$Nest$fgetmUiRemoteEntry(ProviderResponseDataHandler r0) {
            return r0.mUiRemoteEntry;
        }

        /* JADX INFO: renamed from: -$$Nest$misEmptyResponse, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m3306$$Nest$misEmptyResponse(ProviderResponseDataHandler r0) {
            return r0.isEmptyResponse();
        }

        /* JADX INFO: renamed from: -$$Nest$misEmptyResponse, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m3307$$Nest$misEmptyResponse(ProviderResponseDataHandler r0, BeginGetCredentialResponse r1) {
            return r0.isEmptyResponse(r1);
        }

        ProviderResponseDataHandler(ProviderGetSession r1, ComponentName expectedRemoteEntryProviderService) {
            this.this$0 = r1;
            this.mUiCredentialEntries = new HashMap();
            this.mUiActionsEntries = new HashMap();
            this.mUiAuthenticationEntries = new HashMap();
            this.mCredentialEntryTypes = new HashSet();
            this.mUiRemoteEntry = null;
            this.mExpectedRemoteEntryProviderService = expectedRemoteEntryProviderService;
        }

        public void addResponseContent(List<CredentialEntry> credentialEntries, List<Action> actions, List<Action> authenticationActions, RemoteEntry remoteEntry, boolean isInitialResponse) {
            credentialEntries.forEach(new ProviderGetSession$ProviderResponseDataHandler$$ExternalSyntheticLambda1(this));
            actions.forEach(new ProviderGetSession$ProviderResponseDataHandler$$ExternalSyntheticLambda2(this));
            authenticationActions.forEach(new ProviderGetSession$ProviderResponseDataHandler$$ExternalSyntheticLambda3(this));
            if (remoteEntry != null) goto L5;
            if (isInitialResponse == false) goto L5;
            return;
        L5:
            setRemoteEntry(remoteEntry);
        }

        private /* synthetic */ void lambda$addResponseContent$0(Action authenticationAction) {
            addAuthenticationAction(authenticationAction, 0);
        }

        public void addCredentialEntry(CredentialEntry credentialEntry) {
            String id = ProviderSession.generateUniqueId();
            Entry entry = new Entry(ProviderGetSession.CREDENTIAL_ENTRY_KEY, id, credentialEntry.getSlice(), ProviderGetSession.m3301$$Nest$msetUpFillInIntentWithFinalRequest(this.this$0, credentialEntry.getBeginGetCredentialOptionId()));
            this.mUiCredentialEntries.put(id, new Pair(credentialEntry, entry));
            this.mCredentialEntryTypes.add(credentialEntry.getType());
        }

        public void addAction(Action action) {
            String id = ProviderSession.generateUniqueId();
            Entry entry = new Entry(ProviderGetSession.ACTION_ENTRY_KEY, id, action.getSlice(), ProviderGetSession.m3302$$Nest$msetUpFillInIntentWithQueryRequest(this.this$0));
            this.mUiActionsEntries.put(id, new Pair(action, entry));
        }

        public void addAuthenticationAction(Action authenticationAction, int status) {
            String id = ProviderSession.generateUniqueId();
            AuthenticationEntry entry = new AuthenticationEntry(ProviderGetSession.AUTHENTICATION_ACTION_ENTRY_KEY, id, authenticationAction.getSlice(), status, ProviderGetSession.m3302$$Nest$msetUpFillInIntentWithQueryRequest(this.this$0));
            this.mUiAuthenticationEntries.put(id, new Pair(authenticationAction, entry));
        }

        public void removeAuthenticationAction(String id) {
            this.mUiAuthenticationEntries.remove(id);
        }

        public void setRemoteEntry(RemoteEntry remoteEntry) {
            if (this.this$0.enforceRemoteEntryRestrictions(this.mExpectedRemoteEntryProviderService) == true) goto L6;
            Slog.w(ProviderGetSession.TAG, "Remote entry being dropped as it does not meet the restriction checks.");
            return;
        L6:
            if (remoteEntry != null) goto L9;
            this.mUiRemoteEntry = null;
            return;
        L9:
            String id = ProviderSession.generateUniqueId();
            Entry entry = new Entry(ProviderGetSession.REMOTE_ENTRY_KEY, id, remoteEntry.getSlice(), ProviderGetSession.m3300$$Nest$msetUpFillInIntentForRemoteEntry(this.this$0));
            this.mUiRemoteEntry = new Pair(id, new Pair(remoteEntry, entry));
        }

        public GetCredentialProviderData toGetCredentialProviderData() {
            return new GetCredentialProviderData.Builder(this.this$0.mComponentName.flattenToString()).setActionChips(prepareActionEntries()).setCredentialEntries(prepareCredentialEntries()).setAuthenticationEntries(prepareAuthenticationEntries()).setRemoteEntry(prepareRemoteEntry()).build();
        }

        private List<Entry> prepareActionEntries() {
            List<Entry> actionEntries = new ArrayList();
            Iterator<String> r1 = this.mUiActionsEntries.keySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            String key = r1.next();
            actionEntries.add((Entry) this.mUiActionsEntries.get(key).second);
            goto L4
        L6:
            return actionEntries;
        }

        private List<AuthenticationEntry> prepareAuthenticationEntries() {
            List<AuthenticationEntry> authEntries = new ArrayList();
            Iterator<String> r1 = this.mUiAuthenticationEntries.keySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            String key = r1.next();
            authEntries.add((AuthenticationEntry) this.mUiAuthenticationEntries.get(key).second);
            goto L4
        L6:
            return authEntries;
        }

        private List<Entry> prepareCredentialEntries() {
            List<Entry> credEntries = new ArrayList();
            Iterator<String> r1 = this.mUiCredentialEntries.keySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            String key = r1.next();
            credEntries.add((Entry) this.mUiCredentialEntries.get(key).second);
            goto L4
        L6:
            return credEntries;
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
            if (this.mUiCredentialEntries.isEmpty() == true) goto L5;
        L11:
            return false;
        L5:
            if (this.mUiActionsEntries.isEmpty() == false) goto L11;
            if (this.mUiAuthenticationEntries.isEmpty() == false) goto L11;
            if (this.mUiRemoteEntry != null) goto L11;
            return true;
        }

        private boolean isEmptyResponse(BeginGetCredentialResponse response) {
            if (response.getCredentialEntries().isEmpty() == true) goto L5;
        L11:
            return false;
        L5:
            if (response.getActions().isEmpty() == false) goto L11;
            if (response.getAuthenticationActions().isEmpty() == false) goto L11;
            if (response.getRemoteCredentialEntry() != null) goto L11;
            return true;
        }

        public Set<String> getCredentialEntryTypes() {
            return this.mCredentialEntryTypes;
        }

        public Action getAuthenticationAction(String entryKey) {
            if (this.mUiAuthenticationEntries.get(entryKey) != null) goto L6;
            return null;
        L6:
            return (Action) this.mUiAuthenticationEntries.get(entryKey).first;
        }

        public Action getActionEntry(String entryKey) {
            if (this.mUiActionsEntries.get(entryKey) != null) goto L6;
            return null;
        L6:
            return (Action) this.mUiActionsEntries.get(entryKey).first;
        }

        public RemoteEntry getRemoteEntry(String entryKey) {
            if (((String) this.mUiRemoteEntry.first).equals(entryKey) == true) goto L5;
        L7:
            return null;
        L5:
            if (this.mUiRemoteEntry.second == null) goto L7;
            return (RemoteEntry) ((Pair) this.mUiRemoteEntry.second).first;
        }

        public CredentialEntry getCredentialEntry(String entryKey) {
            if (this.mUiCredentialEntries.get(entryKey) != null) goto L6;
            return null;
        L6:
            return (CredentialEntry) this.mUiCredentialEntries.get(entryKey).first;
        }

        public void updateAuthEntryWithNoCredentialsReceived(String entryKey) {
            if (entryKey != null) goto L5;
            updatePreviousMostRecentAuthEntry();
            return;
        L5:
            updatePreviousMostRecentAuthEntry();
            updateMostRecentAuthEntry(entryKey);
        }

        private void updateMostRecentAuthEntry(String entryKey) {
            AuthenticationEntry previousAuthenticationEntry = (AuthenticationEntry) this.mUiAuthenticationEntries.get(entryKey).second;
            Action previousAuthenticationAction = (Action) this.mUiAuthenticationEntries.get(entryKey).first;
            this.mUiAuthenticationEntries.put(entryKey, new Pair(previousAuthenticationAction, copyAuthEntryAndChangeStatus(previousAuthenticationEntry, 2)));
        }

        private void updatePreviousMostRecentAuthEntry() {
            Optional<Map.Entry<String, Pair<Action, AuthenticationEntry>>> previousMostRecentAuthEntry = this.mUiAuthenticationEntries.entrySet().stream().filter(new ProviderGetSession$ProviderResponseDataHandler$$ExternalSyntheticLambda0()).findFirst();
            if (previousMostRecentAuthEntry.isEmpty() == false) goto L5;
            return;
        L5:
            String id = previousMostRecentAuthEntry.get().getKey();
            this.mUiAuthenticationEntries.remove(id);
            this.mUiAuthenticationEntries.put(id, new Pair((Action) previousMostRecentAuthEntry.get().getValue().first, copyAuthEntryAndChangeStatus((AuthenticationEntry) previousMostRecentAuthEntry.get().getValue().second, 1)));
        }

        private static /* synthetic */ boolean lambda$updatePreviousMostRecentAuthEntry$1(Map.Entry e) {
            if (((AuthenticationEntry) ((Pair) e.getValue()).second).getStatus() != 2) goto L5;
            return true;
        L5:
            return false;
        }

        private AuthenticationEntry copyAuthEntryAndChangeStatus(AuthenticationEntry from, Integer toStatus) {
            return new AuthenticationEntry(ProviderGetSession.AUTHENTICATION_ACTION_ENTRY_KEY, from.getSubkey(), from.getSlice(), toStatus.intValue(), from.getFrameworkExtrasIntent());
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$23mPFs-ic7IpBrwfHZTOzCdIWPU, reason: not valid java name */
    public static /* synthetic */ void m3299$r8$lambda$23mPFsic7IpBrwfHZTOzCdIWPU(BeginGetCredentialRequest.Builder r0, Map r1, CredentialOption r2) {
        lambda$constructQueryPhaseRequest$0(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$Tn_Fgo2Q82SnPVcoincPw538KEM(Pair r0) {
        return lambda$containsEmptyAuthEntriesOnly$1(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$msetUpFillInIntentForRemoteEntry, reason: not valid java name */
    static /* bridge */ /* synthetic */ Intent m3300$$Nest$msetUpFillInIntentForRemoteEntry(ProviderGetSession r0) {
        return r0.setUpFillInIntentForRemoteEntry();
    }

    /* JADX INFO: renamed from: -$$Nest$msetUpFillInIntentWithFinalRequest, reason: not valid java name */
    static /* bridge */ /* synthetic */ Intent m3301$$Nest$msetUpFillInIntentWithFinalRequest(ProviderGetSession r0, String r1) {
        return r0.setUpFillInIntentWithFinalRequest(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetUpFillInIntentWithQueryRequest, reason: not valid java name */
    static /* bridge */ /* synthetic */ Intent m3302$$Nest$msetUpFillInIntentWithQueryRequest(ProviderGetSession r0) {
        return r0.setUpFillInIntentWithQueryRequest();
    }

    @Override // com.android.server.credentials.RemoteCredentialService.ProviderCallbacks
    public /* bridge */ /* synthetic */ void onProviderResponseSuccess(BeginGetCredentialResponse r1) {
        onProviderResponseSuccess2(r1);
    }

    @Override // com.android.server.credentials.ProviderSession
    /* JADX INFO: renamed from: prepareUiData */
    protected /* bridge */ /* synthetic */ ProviderData mo3297prepareUiData() {
        return prepareUiData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ProviderGetSession createNewSession(Context context, int userId, CredentialProviderInfo providerInfo, GetRequestSession getRequestSession, RemoteCredentialService remoteCredentialService) {
        GetCredentialRequest filteredRequest = filterOptions(providerInfo.getCapabilities(), (GetCredentialRequest) getRequestSession.mClientRequest, providerInfo, getRequestSession.mHybridService);
        if (filteredRequest == null) goto L6;
        Map<String, CredentialOption> beginGetOptionToCredentialOptionMap = new HashMap();
        return new ProviderGetSession(context, providerInfo, getRequestSession, userId, remoteCredentialService, constructQueryPhaseRequest(filteredRequest, getRequestSession.mClientAppInfo, ((GetCredentialRequest) getRequestSession.mClientRequest).alwaysSendAppInfoToProvider(), beginGetOptionToCredentialOptionMap), filteredRequest, getRequestSession.mClientAppInfo, beginGetOptionToCredentialOptionMap, getRequestSession.mHybridService);
    L6:
        Slog.i(TAG, "Unable to create provider session for: " + providerInfo.getComponentName());
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ProviderGetSession createNewSession(Context context, int userId, CredentialProviderInfo providerInfo, GetCandidateRequestSession getRequestSession, RemoteCredentialService remoteCredentialService) {
        GetCredentialRequest filteredRequest = filterOptions(providerInfo.getCapabilities(), (GetCredentialRequest) getRequestSession.mClientRequest, providerInfo, getRequestSession.mHybridService);
        if (filteredRequest == null) goto L6;
        Map<String, CredentialOption> beginGetOptionToCredentialOptionMap = new HashMap();
        return new ProviderGetSession(context, providerInfo, getRequestSession, userId, remoteCredentialService, constructQueryPhaseRequest(filteredRequest, getRequestSession.mClientAppInfo, ((GetCredentialRequest) getRequestSession.mClientRequest).alwaysSendAppInfoToProvider(), beginGetOptionToCredentialOptionMap), filteredRequest, getRequestSession.mClientAppInfo, beginGetOptionToCredentialOptionMap, getRequestSession.mHybridService);
    L6:
        Slog.i(TAG, "Unable to create provider session for: " + providerInfo.getComponentName());
        return null;
    }

    private static BeginGetCredentialRequest constructQueryPhaseRequest(GetCredentialRequest filteredRequest, CallingAppInfo callingAppInfo, boolean propagateToProvider, final Map<String, CredentialOption> beginGetOptionToCredentialOptionMap) {
        final BeginGetCredentialRequest.Builder builder = new BeginGetCredentialRequest.Builder();
        filteredRequest.getCredentialOptions().forEach(new ProviderGetSession$$ExternalSyntheticLambda1(builder, beginGetOptionToCredentialOptionMap));
        if (propagateToProvider == false) goto L6;
        builder.setCallingAppInfo(callingAppInfo);
    L6:
        return builder.build();
    }

    private static /* synthetic */ void lambda$constructQueryPhaseRequest$0(BeginGetCredentialRequest.Builder builder, Map beginGetOptionToCredentialOptionMap, CredentialOption option) {
        String id = ProviderSession.generateUniqueId();
        builder.addBeginGetCredentialOption(new BeginGetCredentialOption(id, option.getType(), option.getCandidateQueryData()));
        beginGetOptionToCredentialOptionMap.put(id, option);
    }

    private static GetCredentialRequest filterOptions(List<String> providerCapabilities, GetCredentialRequest clientRequest, CredentialProviderInfo info, String hybridService) {
        Slog.i(TAG, "Filtering request options for: " + info.getComponentName());
        ComponentName hybridComponentName = ComponentName.unflattenFromString(hybridService);
        if (hybridComponentName != null) goto L5;
    L8:
        Slog.w(TAG, "Could not parse hybrid service while filtering options");
        List<CredentialOption> filteredOptions = new ArrayList();
        Iterator<CredentialOption> r2 = clientRequest.getCredentialOptions().iterator();
    L10:
        if (r2.hasNext() == false) goto L20;
        CredentialOption option = r2.next();
        if (providerCapabilities.contains(option.getType()) == false) goto L10;
        if (isProviderAllowed(option, info) == false) goto L10;
        if (checkSystemProviderRequirement(option, info.isSystemProvider()) == false) goto L10;
        Slog.i(TAG, "Option of type: " + option.getType() + " meets all filteringconditions");
        filteredOptions.add(option);
        goto L10
    L20:
        if (filteredOptions.isEmpty() == false) goto L22;
        Slog.i(TAG, "No options filtered");
        return null;
    L22:
        return new GetCredentialRequest.Builder(clientRequest.getData()).setCredentialOptions(filteredOptions).build();
    L5:
        if (hybridComponentName.equals(info.getComponentName()) == false) goto L8;
        Slog.i(TAG, "Skipping filtering of options for hybrid service");
        return clientRequest;
    }

    private static boolean isProviderAllowed(CredentialOption option, CredentialProviderInfo providerInfo) {
        if (providerInfo.isSystemProvider() == false) goto L6;
        return true;
    L6:
        if (option.getAllowedProviders().isEmpty() == false) goto L8;
    L11:
        return true;
    L8:
        if (option.getAllowedProviders().contains(providerInfo.getComponentName()) == true) goto L11;
        Slog.i(TAG, "Provider allow list specified but does not contain this provider");
        return false;
    }

    private static boolean checkSystemProviderRequirement(CredentialOption option, boolean isSystemProvider) {
        if (option.isSystemProviderRequired() == false) goto L7;
        if (isSystemProvider == true) goto L9;
        Slog.i(TAG, "System provider required, but this service is not a system provider");
        return false;
    L9:
        return true;
    L7:
        return true;
    }

    public ProviderGetSession(Context context, CredentialProviderInfo info, ProviderSession.ProviderInternalCallback callbacks, int userId, RemoteCredentialService remoteCredentialService, BeginGetCredentialRequest beginGetRequest, GetCredentialRequest completeGetRequest, CallingAppInfo callingAppInfo, Map<String, CredentialOption> beginGetOptionToCredentialOptionMap, String hybridService) {
        super(context, beginGetRequest, callbacks, info.getComponentName(), userId, remoteCredentialService);
        this.mCompleteRequest = completeGetRequest;
        this.mCallingAppInfo = callingAppInfo;
        setStatus(ProviderSession.Status.PENDING);
        this.mBeginGetOptionToCredentialOptionMap = new HashMap(beginGetOptionToCredentialOptionMap);
        this.mProviderResponseDataHandler = new ProviderResponseDataHandler(this, ComponentName.unflattenFromString(hybridService));
    }

    /* JADX INFO: renamed from: onProviderResponseSuccess, reason: avoid collision after fix types in other method */
    public void onProviderResponseSuccess2(BeginGetCredentialResponse response) {
        Slog.i(TAG, "Remote provider responded with a valid response: " + this.mComponentName);
        onSetInitialRemoteResponse(response);
    }

    @Override // com.android.server.credentials.RemoteCredentialService.ProviderCallbacks
    public void onProviderResponseFailure(int errorCode, Exception exception) {
        if ((exception instanceof GetCredentialException) == false) goto L5;
        this.mProviderException = (GetCredentialException) exception;
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
    protected void onUiEntrySelected(String entryType, String entryKey, ProviderPendingIntentResponse providerPendingIntentResponse) {
        Slog.i(TAG, "onUiEntrySelected with entryType: " + entryType + ", and entryKey: " + entryKey);
        switch(entryType.hashCode()) {
            case 1110515801: goto L15;
            case 1182857469: goto L12;
            case 1208398455: goto L9;
            case 1852195030: goto L6;
            default: goto L17;
        };
    L17:
        byte r0 = -1;
    L18:
        switch(r0) {
            case 0: goto L39;
            case 1: goto L34;
            case 2: goto L24;
            case 3: goto L21;
            default: goto L19;
        };
    L19:
        Slog.i(TAG, "Unsupported entry type selected");
        invokeCallbackOnInternalInvalidState();
        return;
    L24:
        Action authenticationEntry = this.mProviderResponseDataHandler.getAuthenticationAction(entryKey);
        this.mProviderSessionMetric.createAuthenticationBrowsingMetric();
        if (authenticationEntry != null) goto L28;
        Slog.i(TAG, "Unexpected authenticationEntry key");
        invokeCallbackOnInternalInvalidState();
        return;
    L28:
        boolean additionalContentReceived = onAuthenticationEntrySelected(providerPendingIntentResponse);
        if (additionalContentReceived == false) goto L33;
        Slog.i(TAG, "Additional content received - removing authentication entry");
        this.mProviderResponseDataHandler.removeAuthenticationAction(entryKey);
        if (ProviderResponseDataHandler.m3306$$Nest$misEmptyResponse(this.mProviderResponseDataHandler) == true) goto L48;
        updateStatusAndInvokeCallback(ProviderSession.Status.CREDENTIALS_RECEIVED, ProviderSession.CredentialsSource.AUTH_ENTRY);
        return;
    L48:
        return;
    L33:
        Slog.i(TAG, "Additional content not received from authentication entry");
        this.mProviderResponseDataHandler.updateAuthEntryWithNoCredentialsReceived(entryKey);
        updateStatusAndInvokeCallback(ProviderSession.Status.NO_CREDENTIALS_FROM_AUTH_ENTRY, ProviderSession.CredentialsSource.AUTH_ENTRY);
        return;
    L34:
        Action actionEntry = this.mProviderResponseDataHandler.getActionEntry(entryKey);
        if (actionEntry != null) goto L38;
        Slog.i(TAG, "Unexpected action entry key");
        invokeCallbackOnInternalInvalidState();
        return;
    L38:
        onActionEntrySelected(providerPendingIntentResponse);
        return;
    L39:
        CredentialEntry credentialEntry = this.mProviderResponseDataHandler.getCredentialEntry(entryKey);
        if (credentialEntry != null) goto L43;
        Slog.i(TAG, "Unexpected credential entry key");
        invokeCallbackOnInternalInvalidState();
        return;
    L43:
        onCredentialEntrySelected(providerPendingIntentResponse);
        return;
    L21:
        if (this.mProviderResponseDataHandler.getRemoteEntry(entryKey) == null) goto L23;
        onRemoteEntrySelected(providerPendingIntentResponse);
        return;
    L23:
        Slog.i(TAG, "Unexpected remote entry key");
        invokeCallbackOnInternalInvalidState();
        return;
    L6:
        if (entryType.equals(ACTION_ENTRY_KEY) == false) goto L17;
        r0 = 1;
        goto L18
    L9:
        if (entryType.equals(CREDENTIAL_ENTRY_KEY) == false) goto L17;
        r0 = 0;
        goto L18
    L12:
        if (entryType.equals(AUTHENTICATION_ACTION_ENTRY_KEY) == false) goto L17;
        r0 = 2;
        goto L18
    L15:
        if (entryType.equals(REMOTE_ENTRY_KEY) == false) goto L17;
        r0 = 3;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.server.credentials.ProviderSession
    protected void invokeSession() {
        if (this.mRemoteCredentialService == null) goto L6;
        startCandidateMetrics();
        this.mRemoteCredentialService.setCallback(this);
        this.mRemoteCredentialService.onBeginGetCredential((BeginGetCredentialRequest) this.mProviderRequest);
        return;
    }

    protected Set<String> getCredentialEntryTypes() {
        return this.mProviderResponseDataHandler.getCredentialEntryTypes();
    }

    protected GetCredentialProviderData prepareUiData() throws IllegalArgumentException {
        if (ProviderSession.isUiInvokingStatus(getStatus()) == true) goto L7;
        Slog.i(TAG, "No data for UI from: " + this.mComponentName.flattenToString());
        return null;
    L7:
        if (this.mProviderResponse != 0) goto L9;
    L12:
        return null;
    L9:
        if (ProviderResponseDataHandler.m3306$$Nest$misEmptyResponse(this.mProviderResponseDataHandler) == true) goto L12;
        return this.mProviderResponseDataHandler.toGetCredentialProviderData();
    }

    private Intent setUpFillInIntentWithFinalRequest(String id) {
        Intent intent = new Intent();
        CredentialOption credentialOption = this.mBeginGetOptionToCredentialOptionMap.get(id);
        if (credentialOption != null) goto L7;
        Slog.w(TAG, "Id from Credential Entry does not resolve to a valid option");
        return intent;
    L7:
        return intent.putExtra("android.service.credentials.extra.GET_CREDENTIAL_REQUEST", new android.service.credentials.GetCredentialRequest(this.mCallingAppInfo, List.of(credentialOption)));
    }

    private Intent setUpFillInIntentWithQueryRequest() {
        Intent intent = new Intent();
        intent.putExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_REQUEST", (Parcelable) this.mProviderRequest);
        return intent;
    }

    private void onRemoteEntrySelected(ProviderPendingIntentResponse providerPendingIntentResponse) {
        onCredentialEntrySelected(providerPendingIntentResponse);
    }

    private void onCredentialEntrySelected(ProviderPendingIntentResponse providerPendingIntentResponse) {
        if (providerPendingIntentResponse != null) goto L5;
        invokeCallbackOnInternalInvalidState();
        return;
    L5:
        GetCredentialException exception = maybeGetPendingIntentException(providerPendingIntentResponse);
        if (exception == null) goto L9;
        invokeCallbackWithError(exception.getType(), exception.getMessage());
        return;
    L9:
        GetCredentialResponse getCredentialResponse = PendingIntentResultHandler.extractGetCredentialResponse(providerPendingIntentResponse.getResultData());
        if (getCredentialResponse == null) goto L13;
        this.mCallbacks.onFinalResponseReceived(this.mComponentName, getCredentialResponse);
        return;
    L13:
        Slog.i(TAG, "Pending intent response contains no credential, or error for a credential entry");
        invokeCallbackOnInternalInvalidState();
    }

    private GetCredentialException maybeGetPendingIntentException(ProviderPendingIntentResponse pendingIntentResponse) {
        if (pendingIntentResponse != null) goto L6;
        return null;
    L6:
        if (PendingIntentResultHandler.isValidResponse(pendingIntentResponse) == false) goto L13;
        GetCredentialException exception = PendingIntentResultHandler.extractGetCredentialException(pendingIntentResponse.getResultData());
        if (exception == null) goto L11;
        return exception;
    L11:
        return null;
    L13:
        if (PendingIntentResultHandler.isCancelledResponse(pendingIntentResponse) == false) goto L17;
        return new GetCredentialException("android.credentials.GetCredentialException.TYPE_USER_CANCELED");
    L17:
        return new GetCredentialException("android.credentials.GetCredentialException.TYPE_NO_CREDENTIAL");
    }

    private boolean onAuthenticationEntrySelected(ProviderPendingIntentResponse providerPendingIntentResponse) {
        if (providerPendingIntentResponse != null) goto L5;
        return false;
    L5:
        GetCredentialException exception = maybeGetPendingIntentException(providerPendingIntentResponse);
        if (exception == null) goto L9;
        this.mProviderSessionMetric.collectAuthenticationExceptionStatus(true);
        invokeCallbackWithError(exception.getType(), exception.getMessage());
        return true;
    L9:
        BeginGetCredentialResponse response = PendingIntentResultHandler.extractResponseContent(providerPendingIntentResponse.getResultData());
        this.mProviderSessionMetric.collectCandidateEntryMetrics(response, true, null);
        if (response != null) goto L12;
    L15:
        return false;
    L12:
        if (ProviderResponseDataHandler.m3307$$Nest$misEmptyResponse(this.mProviderResponseDataHandler, response) == true) goto L15;
        addToInitialRemoteResponse(response, false);
        return true;
    }

    private void addToInitialRemoteResponse(BeginGetCredentialResponse content, boolean isInitialResponse) {
        if (content != null) goto L4;
        return;
    L4:
        this.mProviderResponseDataHandler.addResponseContent(content.getCredentialEntries(), content.getActions(), content.getAuthenticationActions(), content.getRemoteCredentialEntry(), isInitialResponse);
    }

    private void onActionEntrySelected(ProviderPendingIntentResponse providerPendingIntentResponse) {
        Slog.i(TAG, "onActionEntrySelected");
        onCredentialEntrySelected(providerPendingIntentResponse);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void onSetInitialRemoteResponse(BeginGetCredentialResponse r4) {
        this.mProviderResponse = r4;
        addToInitialRemoteResponse(r4, true);
        if (ProviderResponseDataHandler.m3307$$Nest$misEmptyResponse(this.mProviderResponseDataHandler, r4) == false) goto L6;
        this.mProviderSessionMetric.collectCandidateEntryMetrics(r4, false, null);
        updateStatusAndInvokeCallback(ProviderSession.Status.EMPTY_RESPONSE, ProviderSession.CredentialsSource.REMOTE_PROVIDER);
        return;
    L6:
        this.mProviderSessionMetric.collectCandidateEntryMetrics(r4, false, null);
        updateStatusAndInvokeCallback(ProviderSession.Status.CREDENTIALS_RECEIVED, ProviderSession.CredentialsSource.REMOTE_PROVIDER);
    }

    private void invokeCallbackOnInternalInvalidState() {
        this.mCallbacks.onFinalErrorReceived(this.mComponentName, "android.credentials.GetCredentialException.TYPE_NO_CREDENTIAL", null);
    }

    public void updateAuthEntriesStatusFromAnotherSession() {
        this.mProviderResponseDataHandler.updateAuthEntryWithNoCredentialsReceived(null);
    }

    public boolean containsEmptyAuthEntriesOnly() {
        if (ProviderResponseDataHandler.m3304$$Nest$fgetmUiCredentialEntries(this.mProviderResponseDataHandler).isEmpty() == true) goto L5;
    L9:
        return false;
    L5:
        if (ProviderResponseDataHandler.m3305$$Nest$fgetmUiRemoteEntry(this.mProviderResponseDataHandler) != null) goto L9;
        if (ProviderResponseDataHandler.m3303$$Nest$fgetmUiAuthenticationEntries(this.mProviderResponseDataHandler).values().stream().allMatch(new ProviderGetSession$$ExternalSyntheticLambda0()) == false) goto L9;
        return true;
    }

    private static /* synthetic */ boolean lambda$containsEmptyAuthEntriesOnly$1(Pair e) {
        if (((AuthenticationEntry) e.second).getStatus() != 1) goto L5;
        return true;
    L5:
        if (((AuthenticationEntry) e.second).getStatus() == 2) goto L11;
        return false;
    L11:
        return true;
    }

    private Intent setUpFillInIntentForRemoteEntry() {
        return new Intent().putExtra("android.service.credentials.extra.GET_CREDENTIAL_REQUEST", new android.service.credentials.GetCredentialRequest(this.mCallingAppInfo, this.mCompleteRequest.getCredentialOptions()));
    }
}
