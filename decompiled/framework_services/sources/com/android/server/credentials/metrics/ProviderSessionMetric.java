package com.android.server.credentials.metrics;

import android.service.credentials.BeginCreateCredentialResponse;
import android.service.credentials.BeginGetCredentialResponse;
import android.service.credentials.CreateEntry;
import android.service.credentials.CredentialEntry;
import android.util.Slog;
import com.android.server.credentials.MetricUtilities;
import com.android.server.credentials.metrics.shared.ResponseCollective;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ProviderSessionMetric {
    private static final String TAG = "ProviderSessionMetric";
    protected final List<BrowsedAuthenticationMetric> mBrowsedAuthenticationMetric;
    protected final CandidatePhaseMetric mCandidatePhasePerProviderMetric;

    public static /* synthetic */ void $r8$lambda$0TLASEzCCwCE7T6Vbz6wy1BbPlQ(Map r0, CredentialEntry r1) {
        lambda$collectCandidateEntryMetrics$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Gpsn_a4wWpZ60ixgVyx2DXzVvts(Map r0, CredentialEntry r1) {
        lambda$beginGetCredentialResponseCollectionCandidateEntryMetrics$1(r0, r1);
    }

    public ProviderSessionMetric(int sessionIdTrackTwo) {
        this.mBrowsedAuthenticationMetric = new ArrayList();
        this.mCandidatePhasePerProviderMetric = new CandidatePhaseMetric(sessionIdTrackTwo);
        this.mBrowsedAuthenticationMetric.add(new BrowsedAuthenticationMetric(sessionIdTrackTwo));
    }

    public CandidatePhaseMetric getCandidatePhasePerProviderMetric() {
        return this.mCandidatePhasePerProviderMetric;
    }

    public List<BrowsedAuthenticationMetric> getBrowsedAuthenticationMetric() {
        return this.mBrowsedAuthenticationMetric;
    }

    public void collectCandidateExceptionStatus(boolean hasException) {
        this.mCandidatePhasePerProviderMetric.setHasException(hasException);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Error while setting candidate metric exception " + e);
    }

    public void collectAuthenticationExceptionStatus(boolean hasException) {
        BrowsedAuthenticationMetric mostRecentAuthenticationMetric = getUsedAuthenticationMetric();     // Catch: Exception -> L4
        mostRecentAuthenticationMetric.setHasException(hasException);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Error while setting authentication metric exception " + e);
    }

    public void collectCandidateFrameworkException(String exceptionType) {
        this.mCandidatePhasePerProviderMetric.setFrameworkException(exceptionType);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Unexpected error during candidate exception metric logging: " + e);
    }

    private void collectAuthEntryUpdate(boolean isFailureStatus, boolean isCompletionStatus, int providerSessionUid) {
        BrowsedAuthenticationMetric mostRecentAuthenticationMetric = getUsedAuthenticationMetric();
        mostRecentAuthenticationMetric.setProviderUid(providerSessionUid);
        if (isFailureStatus == false) goto L5;
        mostRecentAuthenticationMetric.setAuthReturned(false);
        mostRecentAuthenticationMetric.setProviderStatus(ProviderStatusForMetrics.QUERY_FAILURE.getMetricCode());
        return;
    L5:
        if (isCompletionStatus == false) goto L9;
        mostRecentAuthenticationMetric.setAuthReturned(true);
        mostRecentAuthenticationMetric.setProviderStatus(ProviderStatusForMetrics.QUERY_SUCCESS.getMetricCode());
        return;
    }

    private BrowsedAuthenticationMetric getUsedAuthenticationMetric() {
        return this.mBrowsedAuthenticationMetric.get(this.mBrowsedAuthenticationMetric.size() - 1);
    }

    public void collectCandidateMetricUpdate(boolean isFailureStatus, boolean isCompletionStatus, int providerSessionUid, boolean isAuthEntry, boolean isPrimary) {
        if (isAuthEntry == false) goto L7;
        collectAuthEntryUpdate(isFailureStatus, isCompletionStatus, providerSessionUid);     // Catch: Exception -> L5
        return;
    L7:
        this.mCandidatePhasePerProviderMetric.setPrimary(isPrimary);     // Catch: Exception -> L5
        this.mCandidatePhasePerProviderMetric.setCandidateUid(providerSessionUid);     // Catch: Exception -> L5
        this.mCandidatePhasePerProviderMetric.setQueryFinishTimeNanoseconds(System.nanoTime());     // Catch: Exception -> L5
        if (isFailureStatus == false) goto L10;
        this.mCandidatePhasePerProviderMetric.setQueryReturned(false);     // Catch: Exception -> L5
        this.mCandidatePhasePerProviderMetric.setProviderQueryStatus(ProviderStatusForMetrics.QUERY_FAILURE.getMetricCode());     // Catch: Exception -> L5
        return;
    L10:
        if (isCompletionStatus == false) goto L18;
        this.mCandidatePhasePerProviderMetric.setQueryReturned(true);     // Catch: Exception -> L5
        this.mCandidatePhasePerProviderMetric.setProviderQueryStatus(ProviderStatusForMetrics.QUERY_SUCCESS.getMetricCode());     // Catch: Exception -> L5
        return;
    L18:
        return;
    L5:
        e = move-exception;
        Slog.i(TAG, "Unexpected error during candidate update metric logging: " + e);
    }

    public void collectCandidateMetricSetupViaInitialMetric(InitialPhaseMetric initMetric) {
        this.mCandidatePhasePerProviderMetric.setServiceBeganTimeNanoseconds(initMetric.getCredentialServiceStartedTimeNanoseconds());     // Catch: Exception -> L4
        this.mCandidatePhasePerProviderMetric.setStartQueryTimeNanoseconds(System.nanoTime());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Unexpected error during candidate setup metric logging: " + e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <R> void collectCandidateEntryMetrics(R r5, boolean isAuthEntry, InitialPhaseMetric initialPhaseMetric) {
    L6:
        e = move-exception;
        Slog.i(TAG, "Unexpected error during candidate entry metric logging: " + e);
        return;
    L4:
        if ((r5 instanceof BeginGetCredentialResponse) == false) goto L9;
        beginGetCredentialResponseCollectionCandidateEntryMetrics((BeginGetCredentialResponse) r5, isAuthEntry);     // Catch: Exception -> L6
    L15:
        return;
    L9:
        if ((r5 instanceof BeginCreateCredentialResponse) == false) goto L11;
        beginCreateCredentialResponseCollectionCandidateEntryMetrics((BeginCreateCredentialResponse) r5, initialPhaseMetric);     // Catch: Exception -> L6
        goto L15
    L11:
        Slog.i(TAG, "Your response type is unsupported for candidate metric logging");     // Catch: Exception -> L6
        goto L15
    }

    public void collectCandidateEntryMetrics(List<CredentialEntry> entries) {
        int numCredEntries = entries.size();
        Map<EntryEnum, Integer> entryCounts = new LinkedHashMap();
        final Map<String, Integer> responseCounts = new LinkedHashMap();
        entryCounts.put(EntryEnum.REMOTE_ENTRY, 0);
        entryCounts.put(EntryEnum.CREDENTIAL_ENTRY, Integer.valueOf(numCredEntries));
        entryCounts.put(EntryEnum.ACTION_ENTRY, 0);
        entryCounts.put(EntryEnum.AUTHENTICATION_ENTRY, 0);
        entries.forEach(new ProviderSessionMetric$$ExternalSyntheticLambda0(responseCounts));
        ResponseCollective responseCollective = new ResponseCollective(responseCounts, entryCounts);
        this.mCandidatePhasePerProviderMetric.setResponseCollective(responseCollective);
    }

    private static /* synthetic */ void lambda$collectCandidateEntryMetrics$0(Map responseCounts, CredentialEntry entry) {
        String entryKey = MetricUtilities.generateMetricKey(entry.getType(), 20);
        responseCounts.put(entryKey, Integer.valueOf(((Integer) responseCounts.getOrDefault(entryKey, 0)).intValue() + 1));
    }

    public void createAuthenticationBrowsingMetric() {
        BrowsedAuthenticationMetric browsedAuthenticationMetric = new BrowsedAuthenticationMetric(this.mCandidatePhasePerProviderMetric.getSessionIdProvider());
        this.mBrowsedAuthenticationMetric.add(browsedAuthenticationMetric);
    }

    private void beginCreateCredentialResponseCollectionCandidateEntryMetrics(BeginCreateCredentialResponse response, InitialPhaseMetric initialPhaseMetric) {
        Map<EntryEnum, Integer> entryCounts = new LinkedHashMap();
        List<CreateEntry> createEntries = response.getCreateEntries();
        if (response.getRemoteCreateEntry() != null) goto L5;
        int numRemoteEntry = 0;
    L6:
        int numCreateEntries = createEntries.size();
        entryCounts.put(EntryEnum.REMOTE_ENTRY, Integer.valueOf(numRemoteEntry));
        entryCounts.put(EntryEnum.CREDENTIAL_ENTRY, Integer.valueOf(numCreateEntries));
        Map<String, Integer> responseCounts = new LinkedHashMap();
        if (initialPhaseMetric != null) goto L9;
        String[] requestStrings = new String[0];
    L11:
        if (requestStrings.length <= 0) goto L13;
        responseCounts.put(requestStrings[0], Integer.valueOf(initialPhaseMetric.getUniqueRequestCounts()[0]));
    L13:
        ResponseCollective responseCollective = new ResponseCollective(responseCounts, entryCounts);
        this.mCandidatePhasePerProviderMetric.setResponseCollective(responseCollective);
        return;
    L9:
        requestStrings = initialPhaseMetric.getUniqueRequestStrings();
        goto L11
    L5:
        numRemoteEntry = 1;
        goto L6
    }

    private void beginGetCredentialResponseCollectionCandidateEntryMetrics(BeginGetCredentialResponse response, boolean isAuthEntry) {
        Map<EntryEnum, Integer> entryCounts = new LinkedHashMap();
        final Map<String, Integer> responseCounts = new LinkedHashMap();
        int numCredEntries = response.getCredentialEntries().size();
        int numActionEntries = response.getActions().size();
        int numAuthEntries = response.getAuthenticationActions().size();
        if (response.getRemoteCredentialEntry() == null) goto L5;
        int numRemoteEntry = 0;
    L6:
        entryCounts.put(EntryEnum.REMOTE_ENTRY, Integer.valueOf(numRemoteEntry));
        entryCounts.put(EntryEnum.CREDENTIAL_ENTRY, Integer.valueOf(numCredEntries));
        entryCounts.put(EntryEnum.ACTION_ENTRY, Integer.valueOf(numActionEntries));
        entryCounts.put(EntryEnum.AUTHENTICATION_ENTRY, Integer.valueOf(numAuthEntries));
        response.getCredentialEntries().forEach(new ProviderSessionMetric$$ExternalSyntheticLambda1(responseCounts));
        ResponseCollective responseCollective = new ResponseCollective(responseCounts, entryCounts);
        if (isAuthEntry == true) goto L9;
        this.mCandidatePhasePerProviderMetric.setResponseCollective(responseCollective);
        return;
    L9:
        BrowsedAuthenticationMetric browsedAuthenticationMetric = this.mBrowsedAuthenticationMetric.get(this.mBrowsedAuthenticationMetric.size() - 1);
        browsedAuthenticationMetric.setAuthEntryCollective(responseCollective);
        return;
    L5:
        numRemoteEntry = 1;
        goto L6
    }

    private static /* synthetic */ void lambda$beginGetCredentialResponseCollectionCandidateEntryMetrics$1(Map responseCounts, CredentialEntry entry) {
        String entryKey = MetricUtilities.generateMetricKey(entry.getType(), 20);
        responseCounts.put(entryKey, Integer.valueOf(((Integer) responseCounts.getOrDefault(entryKey, 0)).intValue() + 1));
    }
}
