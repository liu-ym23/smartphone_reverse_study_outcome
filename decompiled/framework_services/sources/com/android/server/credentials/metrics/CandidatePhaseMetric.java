package com.android.server.credentials.metrics;

import android.util.Slog;
import com.android.server.credentials.metrics.shared.ResponseCollective;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CandidatePhaseMetric {
    private static final String TAG = "CandidateProviderMetric";
    private int mCandidateUid;
    private String mFrameworkException;
    private boolean mHasException;
    private boolean mIsPrimary;
    private int mProviderQueryStatus;
    private long mQueryFinishTimeNanoseconds;
    private boolean mQueryReturned;
    private ResponseCollective mResponseCollective;
    private long mServiceBeganTimeNanoseconds;
    private final int mSessionIdProvider;
    private long mStartQueryTimeNanoseconds;

    public CandidatePhaseMetric(int sessionIdTrackTwo) {
        this.mQueryReturned = false;
        this.mCandidateUid = -1;
        this.mServiceBeganTimeNanoseconds = -1;
        this.mStartQueryTimeNanoseconds = -1;
        this.mQueryFinishTimeNanoseconds = -1;
        this.mProviderQueryStatus = -1;
        this.mHasException = false;
        this.mFrameworkException = "";
        this.mResponseCollective = new ResponseCollective(Map.of(), Map.of());
        this.mIsPrimary = false;
        this.mSessionIdProvider = sessionIdTrackTwo;
    }

    public void setServiceBeganTimeNanoseconds(long serviceBeganTimeNanoseconds) {
        this.mServiceBeganTimeNanoseconds = serviceBeganTimeNanoseconds;
    }

    public void setStartQueryTimeNanoseconds(long startQueryTimeNanoseconds) {
        this.mStartQueryTimeNanoseconds = startQueryTimeNanoseconds;
    }

    public void setQueryFinishTimeNanoseconds(long queryFinishTimeNanoseconds) {
        this.mQueryFinishTimeNanoseconds = queryFinishTimeNanoseconds;
    }

    public long getServiceBeganTimeNanoseconds() {
        return this.mServiceBeganTimeNanoseconds;
    }

    public long getStartQueryTimeNanoseconds() {
        return this.mStartQueryTimeNanoseconds;
    }

    public long getQueryFinishTimeNanoseconds() {
        return this.mQueryFinishTimeNanoseconds;
    }

    public int getQueryLatencyMicroseconds() {
        return (int) ((getQueryFinishTimeNanoseconds() - getStartQueryTimeNanoseconds()) / 1000);
    }

    public int getTimestampFromReferenceStartMicroseconds(long specificTimestamp) {
        if (specificTimestamp >= this.mServiceBeganTimeNanoseconds) goto L7;
        Slog.i(TAG, "The timestamp is before service started, falling back to default int");
        return -1;
    L7:
        return (int) ((specificTimestamp - this.mServiceBeganTimeNanoseconds) / 1000);
    }

    public void setProviderQueryStatus(int providerQueryStatus) {
        this.mProviderQueryStatus = providerQueryStatus;
    }

    public int getProviderQueryStatus() {
        return this.mProviderQueryStatus;
    }

    public void setCandidateUid(int candidateUid) {
        this.mCandidateUid = candidateUid;
    }

    public int getCandidateUid() {
        return this.mCandidateUid;
    }

    public int getSessionIdProvider() {
        return this.mSessionIdProvider;
    }

    public void setQueryReturned(boolean queryReturned) {
        this.mQueryReturned = queryReturned;
    }

    public boolean isQueryReturned() {
        return this.mQueryReturned;
    }

    public void setHasException(boolean hasException) {
        this.mHasException = hasException;
    }

    public boolean isHasException() {
        return this.mHasException;
    }

    public void setResponseCollective(ResponseCollective responseCollective) {
        this.mResponseCollective = responseCollective;
    }

    public ResponseCollective getResponseCollective() {
        return this.mResponseCollective;
    }

    public void setFrameworkException(String frameworkException) {
        this.mFrameworkException = frameworkException;
    }

    public String getFrameworkException() {
        return this.mFrameworkException;
    }

    public void setPrimary(boolean primary) {
        this.mIsPrimary = primary;
    }

    public boolean isPrimary() {
        return this.mIsPrimary;
    }
}
