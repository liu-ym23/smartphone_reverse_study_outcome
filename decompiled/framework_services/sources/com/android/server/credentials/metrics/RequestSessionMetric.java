package com.android.server.credentials.metrics;

import android.content.ComponentName;
import android.content.Context;
import android.credentials.CreateCredentialRequest;
import android.credentials.CredentialOption;
import android.credentials.GetCredentialRequest;
import android.credentials.selection.IntentCreationResult;
import android.credentials.selection.UserSelectionDialogResult;
import android.util.Slog;
import com.android.server.credentials.MetricUtilities;
import com.android.server.credentials.ProviderSession;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class RequestSessionMetric {
    private static final String TAG = "RequestSessionMetric";
    protected final CandidateAggregateMetric mCandidateAggregateMetric;
    protected List<CandidateBrowsingPhaseMetric> mCandidateBrowsingPhaseMetric;
    protected final ChosenProviderFinalPhaseMetric mChosenProviderFinalPhaseMetric;
    protected final InitialPhaseMetric mInitialPhaseMetric;
    protected int mSequenceCounter;
    private final int mSessionIdTrackTwo;

    public static /* synthetic */ void $r8$lambda$kEazDx4T6PMjuY4Bf5XvCcdZak8(Map r0, CredentialOption r1) {
        lambda$getRequestCountMap$0(r0, r1);
    }

    public RequestSessionMetric(int sessionIdTrackOne, int sessionIdTrackTwo) {
        this.mSequenceCounter = 0;
        this.mCandidateBrowsingPhaseMetric = new ArrayList();
        this.mSessionIdTrackTwo = sessionIdTrackTwo;
        this.mInitialPhaseMetric = new InitialPhaseMetric(sessionIdTrackOne);
        this.mCandidateAggregateMetric = new CandidateAggregateMetric(sessionIdTrackOne);
        this.mChosenProviderFinalPhaseMetric = new ChosenProviderFinalPhaseMetric(sessionIdTrackOne, sessionIdTrackTwo);
    }

    public int returnIncrementSequence() {
        int r0 = this.mSequenceCounter + 1;
        this.mSequenceCounter = r0;
        return r0;
    }

    public InitialPhaseMetric getInitialPhaseMetric() {
        return this.mInitialPhaseMetric;
    }

    public CandidateAggregateMetric getCandidateAggregateMetric() {
        return this.mCandidateAggregateMetric;
    }

    public void collectInitialPhaseMetricInfo(long timestampStarted, int mCallingUid, int metricCode) {
        this.mInitialPhaseMetric.setCredentialServiceStartedTimeNanoseconds(timestampStarted);     // Catch: Exception -> L4
        this.mInitialPhaseMetric.setCallerUid(mCallingUid);     // Catch: Exception -> L4
        this.mInitialPhaseMetric.setApiName(metricCode);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Unexpected error collecting initial phase metric start info: " + e);
    }

    public void collectUiReturnedFinalPhase(boolean uiReturned) {
        this.mChosenProviderFinalPhaseMetric.setUiReturned(uiReturned);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Unexpected error collecting ui end time metric: " + e);
    }

    public void collectUiCallStartTime(long uiCallStartTime) {
        this.mChosenProviderFinalPhaseMetric.setUiCallStartTimeNanoseconds(uiCallStartTime);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Unexpected error collecting ui start metric: " + e);
    }

    public void collectUiResponseData(boolean uiReturned, long uiEndTimestamp) {
        this.mChosenProviderFinalPhaseMetric.setUiReturned(uiReturned);     // Catch: Exception -> L4
        this.mChosenProviderFinalPhaseMetric.setUiCallEndTimeNanoseconds(uiEndTimestamp);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Unexpected error collecting ui response metric: " + e);
    }

    public void collectChosenProviderStatus(int status) {
        this.mChosenProviderFinalPhaseMetric.setChosenProviderStatus(status);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Unexpected error setting chosen provider status metric: " + e);
    }

    public void collectCreateFlowInitialMetricInfo(boolean origin, CreateCredentialRequest request) {
        this.mInitialPhaseMetric.setOriginSpecified(origin);     // Catch: Exception -> L4
        this.mInitialPhaseMetric.setRequestCounts(Map.of(MetricUtilities.generateMetricKey(request.getType(), 20), 1));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Unexpected error collecting create flow metric: " + e);
    }

    private Map<String, Integer> getRequestCountMap(GetCredentialRequest request) {
        final Map<String, Integer> uniqueRequestCounts = new LinkedHashMap();
        request.getCredentialOptions().forEach(new RequestSessionMetric$$ExternalSyntheticLambda0(uniqueRequestCounts));     // Catch: Exception -> L5
    L7:
        return uniqueRequestCounts;
    L5:
        e = move-exception;
        Slog.i(TAG, "Unexpected error during get request count map metric logging: " + e);
        goto L7
    }

    private static /* synthetic */ void lambda$getRequestCountMap$0(Map uniqueRequestCounts, CredentialOption option) {
        String optionKey = MetricUtilities.generateMetricKey(option.getType(), 20);
        uniqueRequestCounts.put(optionKey, Integer.valueOf(((Integer) uniqueRequestCounts.getOrDefault(optionKey, 0)).intValue() + 1));
    }

    public void collectGetFlowInitialMetricInfo(GetCredentialRequest request) {
        InitialPhaseMetric r0 = this.mInitialPhaseMetric;     // Catch: Exception -> L8
        if (request.getOrigin() == null) goto L5;
        boolean r1 = true;
    L6:
        r0.setOriginSpecified(r1);     // Catch: Exception -> L8
        this.mInitialPhaseMetric.setRequestCounts(getRequestCountMap(request));     // Catch: Exception -> L8
        return;
    L5:
        r1 = false;
    L8:
        e = move-exception;
        Slog.i(TAG, "Unexpected error collecting get flow initial metric: " + e);
    }

    public void collectGetFlowInitialMetricInfo(GetCredentialRequest request, boolean isApiPrepared) {
        collectGetFlowInitialMetricInfo(request);     // Catch: Exception -> L4
        this.mInitialPhaseMetric.setApiUsedPrepareFlow(isApiPrepared);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Unexpected error collecting get flow initial metric: " + e);
    }

    public void collectMetricPerBrowsingSelect(UserSelectionDialogResult selection, CandidatePhaseMetric selectedProviderPhaseMetric) {
        CandidateBrowsingPhaseMetric browsingPhaseMetric = new CandidateBrowsingPhaseMetric();     // Catch: Exception -> L4
        browsingPhaseMetric.setEntryEnum(EntryEnum.getMetricCodeFromString(selection.getEntryKey()));     // Catch: Exception -> L4
        browsingPhaseMetric.setProviderUid(selectedProviderPhaseMetric.getCandidateUid());     // Catch: Exception -> L4
        this.mCandidateBrowsingPhaseMetric.add(browsingPhaseMetric);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Unexpected error collecting browsing metric: " + e);
    }

    public void collectChosenClassType(String createOrCredentialType) {
        String truncatedType = MetricUtilities.generateMetricKey(createOrCredentialType, 20);
        this.mChosenProviderFinalPhaseMetric.setChosenClassType(truncatedType);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Slog.i(TAG, "Unexpected error collecting chosen class type metadata: " + e);
    }

    public void setHasExceptionFinalPhase(boolean exceptionBitFinalPhase) {
        this.mChosenProviderFinalPhaseMetric.setHasException(exceptionBitFinalPhase);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Unexpected error setting final exception metric: " + e);
    }

    public void collectFrameworkException(String exception) {
        this.mChosenProviderFinalPhaseMetric.setFrameworkException(MetricUtilities.generateMetricKey(exception, 30));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Unexpected error during metric logging: " + e);
    }

    public void collectUiConfigurationResults(Context context, IntentCreationResult result, int userId) {
        this.mChosenProviderFinalPhaseMetric.setOemUiUid(MetricUtilities.getPackageUid(context, result.getOemUiPackageName(), userId));     // Catch: Exception -> L4
        this.mChosenProviderFinalPhaseMetric.setFallbackUiUid(MetricUtilities.getPackageUid(context, result.getFallbackUiPackageName(), userId));     // Catch: Exception -> L4
        this.mChosenProviderFinalPhaseMetric.setOemUiUsageStatus(OemUiUsageStatus.createFrom(result.getOemUiUsageStatus()));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Unexpected error during ui configuration result collection: " + e);
    }

    public void collectFinalPhaseProviderMetricStatus(boolean hasException, ProviderStatusForMetrics finalStatus) {
        this.mChosenProviderFinalPhaseMetric.setHasException(hasException);     // Catch: Exception -> L4
        this.mChosenProviderFinalPhaseMetric.setChosenProviderStatus(finalStatus.getMetricCode());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Unexpected error during final phase provider status metric logging: " + e);
    }

    public void updateMetricsOnResponseReceived(Map<String, ProviderSession> providers, ComponentName componentName, boolean isPrimary) {
        ProviderSession chosenProviderSession = providers.get(componentName.flattenToString());     // Catch: Exception -> L6
        if (chosenProviderSession == null) goto L13;
        ProviderSessionMetric providerSessionMetric = chosenProviderSession.getProviderSessionMetric();     // Catch: Exception -> L6
        collectChosenMetricViaCandidateTransfer(providerSessionMetric.getCandidatePhasePerProviderMetric(), isPrimary);     // Catch: Exception -> L6
        return;
    L13:
        return;
    L6:
        e = move-exception;
        Slog.i(TAG, "Exception upon candidate to chosen metric transfer: " + e);
    }

    public void collectChosenMetricViaCandidateTransfer(CandidatePhaseMetric candidatePhaseMetric, boolean isPrimary) {
        this.mChosenProviderFinalPhaseMetric.setChosenUid(candidatePhaseMetric.getCandidateUid());     // Catch: Exception -> L4
        this.mChosenProviderFinalPhaseMetric.setPrimary(isPrimary);     // Catch: Exception -> L4
        this.mChosenProviderFinalPhaseMetric.setQueryPhaseLatencyMicroseconds(candidatePhaseMetric.getQueryLatencyMicroseconds());     // Catch: Exception -> L4
        this.mChosenProviderFinalPhaseMetric.setServiceBeganTimeNanoseconds(candidatePhaseMetric.getServiceBeganTimeNanoseconds());     // Catch: Exception -> L4
        this.mChosenProviderFinalPhaseMetric.setQueryStartTimeNanoseconds(candidatePhaseMetric.getStartQueryTimeNanoseconds());     // Catch: Exception -> L4
        this.mChosenProviderFinalPhaseMetric.setQueryEndTimeNanoseconds(candidatePhaseMetric.getQueryFinishTimeNanoseconds());     // Catch: Exception -> L4
        this.mChosenProviderFinalPhaseMetric.setResponseCollective(candidatePhaseMetric.getResponseCollective());     // Catch: Exception -> L4
        this.mChosenProviderFinalPhaseMetric.setFinalFinishTimeNanoseconds(System.nanoTime());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Unexpected error during metric candidate to final transfer: " + e);
    }

    public void logFailureOrUserCancel(boolean isUserCanceledError) {
        if (isUserCanceledError == true) goto L4;
        logApiCalledAtFinish(ApiStatus.FAILURE.getMetricCode());     // Catch: Exception -> L5
    L11:
        return;
    L4:
        setHasExceptionFinalPhase(false);     // Catch: Exception -> L5
        logApiCalledAtFinish(ApiStatus.USER_CANCELED.getMetricCode());     // Catch: Exception -> L5
    L5:
        e = move-exception;
        Slog.i(TAG, "Unexpected error during final metric failure emit: " + e);
    }

    public void logCandidatePhaseMetrics(Map<String, ProviderSession> providers) {
        int r0 = this.mSequenceCounter + 1;     // Catch: Exception -> L7
        this.mSequenceCounter = r0;     // Catch: Exception -> L7
        MetricUtilities.logApiCalledCandidatePhase(providers, r0, this.mInitialPhaseMetric);     // Catch: Exception -> L7
        if (this.mInitialPhaseMetric.getApiName() != ApiName.GET_CREDENTIAL.getMetricCode()) goto L5;
    L9:
        MetricUtilities.logApiCalledCandidateGetMetric(providers, this.mSequenceCounter);     // Catch: Exception -> L7
        return;
    L5:
        if (this.mInitialPhaseMetric.getApiName() == ApiName.GET_CREDENTIAL_VIA_REGISTRY.getMetricCode()) goto L9;
        return;
    L7:
        e = move-exception;
        Slog.i(TAG, "Unexpected error during candidate metric emit: " + e);
    }

    public void logCandidateAggregateMetrics(Map<String, ProviderSession> providers) {
        this.mCandidateAggregateMetric.collectAverages(providers);     // Catch: Exception -> L4
        CandidateAggregateMetric r0 = this.mCandidateAggregateMetric;     // Catch: Exception -> L4
        int r1 = this.mSequenceCounter + 1;     // Catch: Exception -> L4
        this.mSequenceCounter = r1;     // Catch: Exception -> L4
        MetricUtilities.logApiCalledAggregateCandidate(r0, r1);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Unexpected error during aggregate candidate logging " + e);
    }

    public void logAuthEntry(BrowsedAuthenticationMetric browsedAuthenticationMetric) {
    L7:
        e = move-exception;
        Slog.i(TAG, "Unexpected error during auth entry metric emit: " + e);
        return;
    L4:
        if (browsedAuthenticationMetric.getProviderUid() != (-1)) goto L9;
        Slog.v(TAG, "An authentication entry was not clicked");     // Catch: Exception -> L7
        return;
    L9:
        int r1 = this.mSequenceCounter + 1;     // Catch: Exception -> L7
        this.mSequenceCounter = r1;     // Catch: Exception -> L7
        MetricUtilities.logApiCalledAuthenticationMetric(browsedAuthenticationMetric, r1);     // Catch: Exception -> L7
    }

    public void logApiCalledAtFinish(int apiStatus) {
        ChosenProviderFinalPhaseMetric r0 = this.mChosenProviderFinalPhaseMetric;     // Catch: Exception -> L4
        List<CandidateBrowsingPhaseMetric> r1 = this.mCandidateBrowsingPhaseMetric;     // Catch: Exception -> L4
        int r2 = this.mSequenceCounter + 1;     // Catch: Exception -> L4
        this.mSequenceCounter = r2;     // Catch: Exception -> L4
        MetricUtilities.logApiCalledFinalPhase(r0, r1, apiStatus, r2);     // Catch: Exception -> L4
        ChosenProviderFinalPhaseMetric r3 = this.mChosenProviderFinalPhaseMetric;     // Catch: Exception -> L4
        List<CandidateBrowsingPhaseMetric> r4 = this.mCandidateBrowsingPhaseMetric;     // Catch: Exception -> L4
        int r5 = this.mSequenceCounter + 1;     // Catch: Exception -> L4
        this.mSequenceCounter = r5;     // Catch: Exception -> L4
        MetricUtilities.logApiCalledNoUidFinal(r3, r4, apiStatus, r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Unexpected error during final metric emit: " + e);
    }

    public int getSessionIdTrackTwo() {
        return this.mSessionIdTrackTwo;
    }
}
