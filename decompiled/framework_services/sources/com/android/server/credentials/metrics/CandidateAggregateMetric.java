package com.android.server.credentials.metrics;

import com.android.server.audio.AudioService$$ExternalSyntheticLambda2;
import com.android.server.credentials.ProviderSession;
import com.android.server.credentials.metrics.shared.ResponseCollective;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CandidateAggregateMetric {
    private static final String TAG = "CandidateTotalMetric";
    private ResponseCollective mAggregateCollectiveAuth;
    private ResponseCollective mAggregateCollectiveQuery;
    private boolean mAuthReturned;
    private Map<String, Integer> mExceptionCountAuth;
    private Map<String, Integer> mExceptionCountQuery;
    private long mMaxProviderTimestampNanoseconds;
    private long mMinProviderTimestampNanoseconds;
    private int mNumAuthEntriesTapped;
    private int mNumProviders;
    private boolean mQueryReturned;
    private long mServiceBeganTimeNanoseconds;
    private final int mSessionIdProvider;
    private int mTotalAuthFailures;
    private int mTotalQueryFailures;

    public CandidateAggregateMetric(int sessionIdTrackOne) {
        this.mQueryReturned = false;
        this.mServiceBeganTimeNanoseconds = -1;
        this.mNumProviders = 0;
        this.mAuthReturned = false;
        this.mNumAuthEntriesTapped = 0;
        this.mAggregateCollectiveQuery = new ResponseCollective(Map.of(), Map.of());
        this.mAggregateCollectiveAuth = new ResponseCollective(Map.of(), Map.of());
        this.mMinProviderTimestampNanoseconds = -1;
        this.mMaxProviderTimestampNanoseconds = -1;
        this.mTotalQueryFailures = 0;
        this.mExceptionCountQuery = new LinkedHashMap();
        this.mTotalAuthFailures = 0;
        this.mExceptionCountAuth = new LinkedHashMap();
        this.mSessionIdProvider = sessionIdTrackOne;
    }

    public int getSessionIdProvider() {
        return this.mSessionIdProvider;
    }

    public void collectAverages(Map<String, ProviderSession> providers) {
        collectQueryAggregates(providers);
        collectAuthAggregates(providers);
    }

    private void collectQueryAggregates(Map<String, ProviderSession> r22) {
        this.mNumProviders = r22.size();
        LinkedHashMap r1 = new LinkedHashMap();
        LinkedHashMap r2 = new LinkedHashMap();
        Collection<ProviderSession> r3 = r22.values();
        long r4 = Long.MAX_VALUE;
        long r6 = Long.MIN_VALUE;
        Iterator<ProviderSession> r8 = r3.iterator();
    L4:
        if (r8.hasNext() == false) goto L23;
        CandidatePhaseMetric r11 = r8.next().getProviderSessionMetric().getCandidatePhasePerProviderMetric();
        if (r11.getCandidateUid() == (-1)) goto L7;
        if (this.mServiceBeganTimeNanoseconds != (-1)) goto L12;
        this.mServiceBeganTimeNanoseconds = r11.getServiceBeganTimeNanoseconds();
    L12:
        if (this.mQueryReturned == false) goto L14;
    L17:
        boolean r12 = true;
    L18:
        this.mQueryReturned = r12;
        ResponseCollective r13 = r11.getResponseCollective();
        ResponseCollective.combineTypeCountMaps(r1, r13.getResponseCountsMap());
        ResponseCollective.combineTypeCountMaps(r2, r13.getEntryCountsMap());
        long r5 = Math.min(r4, r11.getStartQueryTimeNanoseconds());
        r6 = Math.max(r6, r11.getQueryFinishTimeNanoseconds());
        this.mTotalQueryFailures += r11.isHasException() ? 1 : 0;
        if (r11.getFrameworkException().isEmpty() == true) goto L22;
        this.mExceptionCountQuery.put(r11.getFrameworkException(), Integer.valueOf(this.mExceptionCountQuery.getOrDefault(r11.getFrameworkException(), 0).intValue() + 1));
    L22:
        r3 = r3;
        r4 = r5;
        goto L4
    L14:
        if (r11.isQueryReturned() == true) goto L17;
        r12 = false;
        goto L18
    L7:
        this.mNumProviders--;
        goto L4
    L23:
        this.mMinProviderTimestampNanoseconds = r4;
        this.mMaxProviderTimestampNanoseconds = r6;
        this.mAggregateCollectiveQuery = new ResponseCollective(r1, r2);
    }

    private void collectAuthAggregates(Map<String, ProviderSession> r18) {
        LinkedHashMap r1 = new LinkedHashMap();
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<ProviderSession> r4 = r18.values().iterator();
    L4:
        if (r4.hasNext() == false) goto L23;
        Iterator<BrowsedAuthenticationMetric> r8 = r4.next().getProviderSessionMetric().getBrowsedAuthenticationMetric().iterator();
    L7:
        if (r8.hasNext() == false) goto L4;
        BrowsedAuthenticationMetric r9 = r8.next();
        if (r9.getProviderUid() == (-1)) goto L7;
        this.mNumAuthEntriesTapped++;
        if (this.mAuthReturned == false) goto L14;
    L17:
        boolean r10 = true;
    L18:
        this.mAuthReturned = r10;
        ResponseCollective r11 = r9.getAuthEntryCollective();
        ResponseCollective.combineTypeCountMaps(r1, r11.getResponseCountsMap());
        ResponseCollective.combineTypeCountMaps(r2, r11.getEntryCountsMap());
        this.mTotalQueryFailures += r9.isHasException() ? 1 : 0;
        if (r9.getFrameworkException().isEmpty() == true) goto L7;
        this.mExceptionCountQuery.put(r9.getFrameworkException(), Integer.valueOf(this.mExceptionCountQuery.getOrDefault(r9.getFrameworkException(), 0).intValue() + 1));
        goto L7
    L14:
        if (r9.isAuthReturned() == true) goto L17;
        r10 = false;
        goto L18
    L23:
        this.mAggregateCollectiveAuth = new ResponseCollective(r1, r2);
    }

    public int getNumProviders() {
        return this.mNumProviders;
    }

    public boolean isQueryReturned() {
        return this.mQueryReturned;
    }

    public int getNumAuthEntriesTapped() {
        return this.mNumAuthEntriesTapped;
    }

    public ResponseCollective getAggregateCollectiveQuery() {
        return this.mAggregateCollectiveQuery;
    }

    public ResponseCollective getAggregateCollectiveAuth() {
        return this.mAggregateCollectiveAuth;
    }

    public boolean isAuthReturned() {
        return this.mAuthReturned;
    }

    public long getMaxProviderTimestampNanoseconds() {
        return this.mMaxProviderTimestampNanoseconds;
    }

    public long getMinProviderTimestampNanoseconds() {
        return this.mMinProviderTimestampNanoseconds;
    }

    public int getTotalQueryFailures() {
        return this.mTotalQueryFailures;
    }

    public String[] getUniqueExceptionStringsQuery() {
        String[] result = new String[this.mExceptionCountQuery.keySet().size()];
        this.mExceptionCountQuery.keySet().toArray(result);
        return result;
    }

    public int[] getUniqueExceptionCountsQuery() {
        return this.mExceptionCountQuery.values().stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray();
    }

    public String[] getUniqueExceptionStringsAuth() {
        String[] result = new String[this.mExceptionCountAuth.keySet().size()];
        this.mExceptionCountAuth.keySet().toArray(result);
        return result;
    }

    public int[] getUniqueExceptionCountsAuth() {
        return this.mExceptionCountAuth.values().stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray();
    }

    public long getServiceBeganTimeNanoseconds() {
        return this.mServiceBeganTimeNanoseconds;
    }

    public int getTotalAuthFailures() {
        return this.mTotalAuthFailures;
    }
}
