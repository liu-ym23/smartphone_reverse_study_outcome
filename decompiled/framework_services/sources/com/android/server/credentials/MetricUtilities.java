package com.android.server.credentials;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.credentials.metrics.ApiName;
import com.android.server.credentials.metrics.ApiStatus;
import com.android.server.credentials.metrics.BrowsedAuthenticationMetric;
import com.android.server.credentials.metrics.CandidateAggregateMetric;
import com.android.server.credentials.metrics.CandidateBrowsingPhaseMetric;
import com.android.server.credentials.metrics.CandidatePhaseMetric;
import com.android.server.credentials.metrics.ChosenProviderFinalPhaseMetric;
import com.android.server.credentials.metrics.EntryEnum;
import com.android.server.credentials.metrics.InitialPhaseMetric;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MetricUtilities {
    public static final int DEFAULT_INT_32 = -1;
    public static final boolean[] DEFAULT_REPEATED_BOOL = null;
    public static final int[] DEFAULT_REPEATED_INT_32 = null;
    public static final String[] DEFAULT_REPEATED_STR = null;
    public static final String DEFAULT_STRING = "";
    public static final int DELTA_EXCEPTION_CUT = 30;
    public static final int DELTA_RESPONSES_CUT = 20;
    private static final boolean LOG_FLAG = true;
    public static final int MIN_EMIT_WAIT_TIME_MS = 10;
    private static final String TAG = "CredentialManager";
    public static final int UNIT = 1;
    public static final String USER_CANCELED_SUBSTRING = "TYPE_USER_CANCELED";
    public static final int ZERO = 0;

    public MetricUtilities() {
    }

    static {
        DEFAULT_REPEATED_INT_32 = new int[0];
        DEFAULT_REPEATED_STR = new String[0];
        DEFAULT_REPEATED_BOOL = new boolean[0];
    }

    protected static int getPackageUid(Context context, ComponentName componentName, int userId) {
        if (componentName != null) goto L6;
        return -1;
    L6:
        return getPackageUid(context, componentName.getPackageName(), userId);
    }

    public static int getPackageUid(Context context, String packageName, int userId) {
        if (packageName != null) goto L10;
        return -1;
    L10:
        return context.getPackageManager().getPackageUidAsUser(packageName, PackageManager.PackageInfoFlags.of(0), userId);
    L7:
        t = move-exception;
        Slog.i(TAG, "Couldn't find uid for " + packageName + ": " + t);
        return -1;
    }

    public static int getHighlyUniqueInteger() {
        return new SecureRandom().nextInt();
    }

    protected static int getMetricTimestampDifferenceMicroseconds(long t2, long t1) {
        if ((t2 - t1) <= 2147483647L) goto L7;
        Slog.i(TAG, "Input timestamps are too far apart and unsupported, falling back to default int");
        return -1;
    L7:
        if (t2 >= t1) goto L11;
        Slog.i(TAG, "The timestamps aren't in expected order, falling back to default int");
        return -1;
    L11:
        return (int) ((t2 - t1) / 1000);
    }

    public static String generateMetricKey(String classtype, int deltaFromEnd) {
        return classtype.substring(classtype.length() - deltaFromEnd);
    }

    public static void logApiCalledFinalPhase(ChosenProviderFinalPhaseMetric finalPhaseMetric, List<CandidateBrowsingPhaseMetric> browsingPhaseMetrics, int apiStatus, int emitSequenceId) {
        int browsedSize = browsingPhaseMetrics.size();     // Catch: Exception -> L7
        int[] browsedClickedEntries = new int[browsedSize];     // Catch: Exception -> L7
        int[] browsedProviderUid = new int[browsedSize];     // Catch: Exception -> L7
        int index = 0;
        Iterator<CandidateBrowsingPhaseMetric> r3 = browsingPhaseMetrics.iterator();     // Catch: Exception -> L7
    L5:
        if (r3.hasNext() == false) goto L9;
        CandidateBrowsingPhaseMetric metric = r3.next();     // Catch: Exception -> L7
        browsedClickedEntries[index] = metric.getEntryEnum();     // Catch: Exception -> L7
        browsedProviderUid[index] = metric.getProviderUid();     // Catch: Exception -> L7
        index = index + 1;     // Catch: Exception -> L7
        goto L5
    L9:
        FrameworkStatsLog.write(FrameworkStatsLog.CREDENTIAL_MANAGER_FINAL_PHASE_REPORTED, finalPhaseMetric.getSessionIdProvider(), emitSequenceId, finalPhaseMetric.isUiReturned(), finalPhaseMetric.getChosenUid(), finalPhaseMetric.getTimestampFromReferenceStartMicroseconds(finalPhaseMetric.getQueryStartTimeNanoseconds()), finalPhaseMetric.getTimestampFromReferenceStartMicroseconds(finalPhaseMetric.getQueryEndTimeNanoseconds()), finalPhaseMetric.getTimestampFromReferenceStartMicroseconds(finalPhaseMetric.getUiCallStartTimeNanoseconds()), finalPhaseMetric.getTimestampFromReferenceStartMicroseconds(finalPhaseMetric.getUiCallEndTimeNanoseconds()), finalPhaseMetric.getTimestampFromReferenceStartMicroseconds(finalPhaseMetric.getFinalFinishTimeNanoseconds()), finalPhaseMetric.getChosenProviderStatus(), finalPhaseMetric.isHasException(), DEFAULT_REPEATED_INT_32, -1, -1, -1, -1, -1, browsedClickedEntries, browsedProviderUid, apiStatus, finalPhaseMetric.getResponseCollective().getUniqueEntries(), finalPhaseMetric.getResponseCollective().getUniqueEntryCounts(), finalPhaseMetric.getResponseCollective().getUniqueResponseStrings(), finalPhaseMetric.getResponseCollective().getUniqueResponseCounts(), finalPhaseMetric.getFrameworkException(), finalPhaseMetric.isPrimary(), finalPhaseMetric.getChosenClassType());     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Slog.w(TAG, "Unexpected error during final provider uid emit: " + e);
    }

    public static void logApiCalledAuthenticationMetric(BrowsedAuthenticationMetric authenticationMetric, int emitSequenceId) {
        FrameworkStatsLog.write(FrameworkStatsLog.CREDENTIAL_MANAGER_AUTH_CLICK_REPORTED, authenticationMetric.getSessionIdProvider(), emitSequenceId, authenticationMetric.getProviderUid(), authenticationMetric.getAuthEntryCollective().getUniqueResponseStrings(), authenticationMetric.getAuthEntryCollective().getUniqueResponseCounts(), authenticationMetric.getAuthEntryCollective().getUniqueEntries(), authenticationMetric.getAuthEntryCollective().getUniqueEntryCounts(), authenticationMetric.getFrameworkException(), authenticationMetric.isHasException(), authenticationMetric.getProviderStatus(), authenticationMetric.isAuthReturned());     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Exception e = e;
    L10:
        Slog.w(TAG, "Unexpected error during candidate auth metric logging: " + e);
        return;
    L8:
        e = move-exception;
        e = e;
        goto L10
    }

    public static void logApiCalledCandidateGetMetric(Map<String, ProviderSession> providers, int emitSequenceId) {
        Collection<ProviderSession> sessions = providers.values();     // Catch: Exception -> L11
        Iterator<ProviderSession> r1 = sessions.iterator();     // Catch: Exception -> L11
    L4:
        if (r1.hasNext() == false) goto L21;
        ProviderSession session = r1.next();     // Catch: Exception -> L11
        CandidatePhaseMetric metric = session.getProviderSessionMetric().getCandidatePhasePerProviderMetric();     // Catch: Exception -> L11
        int emitSequenceId2 = emitSequenceId;
        FrameworkStatsLog.write(FrameworkStatsLog.CREDENTIAL_MANAGER_GET_REPORTED, metric.getSessionIdProvider(), emitSequenceId2, metric.getCandidateUid(), metric.getResponseCollective().getUniqueResponseStrings(), metric.getResponseCollective().getUniqueResponseCounts());     // Catch: Exception -> L9
        emitSequenceId = emitSequenceId2;
    L9:
        e = move-exception;
        Exception e = e;
    L14:
        Slog.w(TAG, "Unexpected error during candidate get metric logging: " + e);
        return;
    L21:
        return;
    L11:
        e = move-exception;
        e = e;
        goto L14
    }

    public static void logApiCalledCandidatePhase(Map<String, ProviderSession> providers, int emitSequenceId, InitialPhaseMetric initialPhaseMetric) {
        Collection<ProviderSession> providerSessions = providers.values();     // Catch: Exception -> L8
        int providerSize = providerSessions.size();     // Catch: Exception -> L8
        int[] candidateUidList = new int[providerSize];     // Catch: Exception -> L8
        int[] candidateQueryStartTimeStampList = new int[providerSize];     // Catch: Exception -> L8
        int[] candidateQueryEndTimeStampList = new int[providerSize];     // Catch: Exception -> L8
        int[] candidateStatusList = new int[providerSize];     // Catch: Exception -> L8
        boolean[] candidateHasExceptionList = new boolean[providerSize];     // Catch: Exception -> L8
        int[] candidateTotalEntryCountList = new int[providerSize];     // Catch: Exception -> L8
        int[] candidateCredentialEntryCountList = new int[providerSize];     // Catch: Exception -> L8
        int[] candidateCredentialTypeCountList = new int[providerSize];     // Catch: Exception -> L8
        int[] candidateActionEntryCountList = new int[providerSize];     // Catch: Exception -> L8
        int[] candidateAuthEntryCountList = new int[providerSize];     // Catch: Exception -> L8
        int[] candidateRemoteEntryCountList = new int[providerSize];     // Catch: Exception -> L8
        String[] frameworkExceptionList = new String[providerSize];     // Catch: Exception -> L8
        boolean[] candidatePrimaryProviderList = new boolean[providerSize];     // Catch: Exception -> L8
        int index = 0;
        Iterator<ProviderSession> r5 = providerSessions.iterator();     // Catch: Exception -> L8
        int sessionId = -1;
        boolean queryReturned = false;
    L4:
        if (r5.hasNext() == false) goto L13;
        ProviderSession session = r5.next();     // Catch: Exception -> L8
        CandidatePhaseMetric metric = session.mProviderSessionMetric.getCandidatePhasePerProviderMetric();     // Catch: Exception -> L8
        if (sessionId != (-1)) goto L10;
        sessionId = metric.getSessionIdProvider();     // Catch: Exception -> L8
    L10:
        if (queryReturned == true) goto L12;
        queryReturned = metric.isQueryReturned();     // Catch: Exception -> L8
    L12:
        candidateUidList[index] = metric.getCandidateUid();     // Catch: Exception -> L8
        candidateQueryStartTimeStampList[index] = metric.getTimestampFromReferenceStartMicroseconds(metric.getStartQueryTimeNanoseconds());     // Catch: Exception -> L8
        candidateQueryEndTimeStampList[index] = metric.getTimestampFromReferenceStartMicroseconds(metric.getQueryFinishTimeNanoseconds());     // Catch: Exception -> L8
        candidateStatusList[index] = metric.getProviderQueryStatus();     // Catch: Exception -> L8
        candidateHasExceptionList[index] = metric.isHasException();     // Catch: Exception -> L8
        candidateTotalEntryCountList[index] = metric.getResponseCollective().getNumEntriesTotal();     // Catch: Exception -> L8
        candidateCredentialEntryCountList[index] = metric.getResponseCollective().getCountForEntry(EntryEnum.CREDENTIAL_ENTRY);     // Catch: Exception -> L8
        candidateCredentialTypeCountList[index] = metric.getResponseCollective().getUniqueResponseStrings().length;     // Catch: Exception -> L8
        candidateActionEntryCountList[index] = metric.getResponseCollective().getCountForEntry(EntryEnum.ACTION_ENTRY);     // Catch: Exception -> L8
        candidateAuthEntryCountList[index] = metric.getResponseCollective().getCountForEntry(EntryEnum.AUTHENTICATION_ENTRY);     // Catch: Exception -> L8
        candidateRemoteEntryCountList[index] = metric.getResponseCollective().getCountForEntry(EntryEnum.REMOTE_ENTRY);     // Catch: Exception -> L8
        frameworkExceptionList[index] = metric.getFrameworkException();     // Catch: Exception -> L8
        candidatePrimaryProviderList[index] = metric.isPrimary();     // Catch: Exception -> L8
        index = index + 1;     // Catch: Exception -> L8
        providerSessions = providerSessions;
        providerSize = providerSize;
        goto L4
    L13:
        FrameworkStatsLog.write(FrameworkStatsLog.CREDENTIAL_MANAGER_CANDIDATE_PHASE_REPORTED, sessionId, emitSequenceId, queryReturned, candidateUidList, candidateQueryStartTimeStampList, candidateQueryEndTimeStampList, candidateStatusList, candidateHasExceptionList, candidateTotalEntryCountList, candidateActionEntryCountList, candidateCredentialEntryCountList, candidateCredentialTypeCountList, candidateRemoteEntryCountList, candidateAuthEntryCountList, frameworkExceptionList, initialPhaseMetric.isOriginSpecified(), initialPhaseMetric.getUniqueRequestStrings(), initialPhaseMetric.getUniqueRequestCounts(), initialPhaseMetric.getApiName(), candidatePrimaryProviderList, initialPhaseMetric.hasApiUsedPrepareFlow());     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Slog.w(TAG, "Unexpected error during candidate provider uid metric emit: " + e);
    }

    public static void logApiCalledSimpleV2(ApiName apiName, ApiStatus apiStatus, int callingUid) {
        FrameworkStatsLog.write(FrameworkStatsLog.CREDENTIAL_MANAGER_APIV2_CALLED, apiName.getMetricCode(), callingUid, apiStatus.getMetricCode());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Unexpected error during simple v2 metric logging: " + e);
    }

    public static void logApiCalledInitialPhase(InitialPhaseMetric initialPhaseMetric, int sequenceNum) {
        FrameworkStatsLog.write(FrameworkStatsLog.CREDENTIAL_MANAGER_INIT_PHASE_REPORTED, initialPhaseMetric.getApiName(), initialPhaseMetric.getCallerUid(), initialPhaseMetric.getSessionIdCaller(), sequenceNum, initialPhaseMetric.getCredentialServiceStartedTimeNanoseconds(), initialPhaseMetric.getCountRequestClassType(), initialPhaseMetric.getUniqueRequestStrings(), initialPhaseMetric.getUniqueRequestCounts(), initialPhaseMetric.isOriginSpecified(), initialPhaseMetric.getAutofillSessionId(), initialPhaseMetric.getAutofillRequestId(), initialPhaseMetric.hasApiUsedPrepareFlow());     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Exception e = e;
    L10:
        Slog.w(TAG, "Unexpected error during initial metric emit: " + e);
        return;
    L8:
        e = move-exception;
        e = e;
        goto L10
    }

    public static void logApiCalledAggregateCandidate(CandidateAggregateMetric candidateAggregateMetric, int sequenceNum) {
        FrameworkStatsLog.write(FrameworkStatsLog.CREDENTIAL_MANAGER_TOTAL_REPORTED, candidateAggregateMetric.getSessionIdProvider(), sequenceNum, candidateAggregateMetric.isQueryReturned(), candidateAggregateMetric.getNumProviders(), getMetricTimestampDifferenceMicroseconds(candidateAggregateMetric.getMinProviderTimestampNanoseconds(), candidateAggregateMetric.getServiceBeganTimeNanoseconds()), getMetricTimestampDifferenceMicroseconds(candidateAggregateMetric.getMaxProviderTimestampNanoseconds(), candidateAggregateMetric.getServiceBeganTimeNanoseconds()), candidateAggregateMetric.getAggregateCollectiveQuery().getUniqueResponseStrings(), candidateAggregateMetric.getAggregateCollectiveQuery().getUniqueResponseCounts(), candidateAggregateMetric.getAggregateCollectiveQuery().getUniqueEntries(), candidateAggregateMetric.getAggregateCollectiveQuery().getUniqueEntryCounts(), candidateAggregateMetric.getTotalQueryFailures(), candidateAggregateMetric.getUniqueExceptionStringsQuery(), candidateAggregateMetric.getUniqueExceptionCountsQuery(), candidateAggregateMetric.getAggregateCollectiveAuth().getUniqueResponseStrings(), candidateAggregateMetric.getAggregateCollectiveAuth().getUniqueResponseCounts(), candidateAggregateMetric.getAggregateCollectiveAuth().getUniqueEntries(), candidateAggregateMetric.getAggregateCollectiveAuth().getUniqueEntryCounts(), candidateAggregateMetric.getTotalAuthFailures(), candidateAggregateMetric.getUniqueExceptionStringsAuth(), candidateAggregateMetric.getUniqueExceptionCountsAuth(), candidateAggregateMetric.getNumAuthEntriesTapped(), candidateAggregateMetric.isAuthReturned());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Unexpected error during total candidate metric logging: " + e);
    }

    public static void logApiCalledNoUidFinal(ChosenProviderFinalPhaseMetric finalPhaseMetric, List<CandidateBrowsingPhaseMetric> browsingPhaseMetrics, int apiStatus, int emitSequenceId) {
        int browsedSize = browsingPhaseMetrics.size();     // Catch: Exception -> L7
        int[] browsedClickedEntries = new int[browsedSize];     // Catch: Exception -> L7
        int[] browsedProviderUid = new int[browsedSize];     // Catch: Exception -> L7
        int index = 0;
        Iterator<CandidateBrowsingPhaseMetric> r3 = browsingPhaseMetrics.iterator();     // Catch: Exception -> L7
    L5:
        if (r3.hasNext() == false) goto L9;
        CandidateBrowsingPhaseMetric metric = r3.next();     // Catch: Exception -> L7
        browsedClickedEntries[index] = metric.getEntryEnum();     // Catch: Exception -> L7
        browsedProviderUid[index] = -1;     // Catch: Exception -> L7
        index = index + 1;     // Catch: Exception -> L7
        goto L5
    L9:
        FrameworkStatsLog.write(FrameworkStatsLog.CREDENTIAL_MANAGER_FINALNOUID_REPORTED, finalPhaseMetric.getSessionIdCaller(), emitSequenceId, finalPhaseMetric.isUiReturned(), finalPhaseMetric.getTimestampFromReferenceStartMicroseconds(finalPhaseMetric.getQueryStartTimeNanoseconds()), finalPhaseMetric.getTimestampFromReferenceStartMicroseconds(finalPhaseMetric.getQueryEndTimeNanoseconds()), finalPhaseMetric.getTimestampFromReferenceStartMicroseconds(finalPhaseMetric.getUiCallStartTimeNanoseconds()), finalPhaseMetric.getTimestampFromReferenceStartMicroseconds(finalPhaseMetric.getUiCallEndTimeNanoseconds()), finalPhaseMetric.getTimestampFromReferenceStartMicroseconds(finalPhaseMetric.getFinalFinishTimeNanoseconds()), finalPhaseMetric.getChosenProviderStatus(), finalPhaseMetric.isHasException(), finalPhaseMetric.getResponseCollective().getUniqueEntries(), finalPhaseMetric.getResponseCollective().getUniqueEntryCounts(), finalPhaseMetric.getResponseCollective().getUniqueResponseStrings(), finalPhaseMetric.getResponseCollective().getUniqueResponseCounts(), finalPhaseMetric.getFrameworkException(), browsedClickedEntries, browsedProviderUid, apiStatus, finalPhaseMetric.isPrimary(), finalPhaseMetric.getOemUiUid(), finalPhaseMetric.getFallbackUiUid(), finalPhaseMetric.getOemUiUsageStatus(), finalPhaseMetric.getChosenClassType());     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Slog.w(TAG, "Unexpected error during final no uid metric logging: " + e);
    }
}
