package com.android.server.credentials.metrics;

import android.util.Slog;
import com.android.server.credentials.metrics.shared.ResponseCollective;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ChosenProviderFinalPhaseMetric {
    private static final String TAG = "ChosenFinalPhaseMetric";
    private String mChosenClassType;
    private int mChosenProviderStatus;
    private int mChosenUid;
    private int mFallbackUiUid;
    private long mFinalFinishTimeNanoseconds;
    private String mFrameworkException;
    private boolean mHasException;
    private boolean mIsPrimary;
    private int mOemUiUid;
    private OemUiUsageStatus mOemUiUsageStatus;
    private int mPreQueryPhaseLatencyMicroseconds;
    private long mQueryEndTimeNanoseconds;
    private int mQueryPhaseLatencyMicroseconds;
    private long mQueryStartTimeNanoseconds;
    private ResponseCollective mResponseCollective;
    private long mServiceBeganTimeNanoseconds;
    private final int mSessionIdCaller;
    private final int mSessionIdProvider;
    private long mUiCallEndTimeNanoseconds;
    private long mUiCallStartTimeNanoseconds;
    private boolean mUiReturned;

    public ChosenProviderFinalPhaseMetric(int sessionIdCaller, int sessionIdProvider) {
        this.mUiReturned = false;
        this.mChosenUid = -1;
        this.mPreQueryPhaseLatencyMicroseconds = -1;
        this.mQueryPhaseLatencyMicroseconds = -1;
        this.mServiceBeganTimeNanoseconds = -1;
        this.mQueryStartTimeNanoseconds = -1;
        this.mQueryEndTimeNanoseconds = -1;
        this.mUiCallStartTimeNanoseconds = -1;
        this.mUiCallEndTimeNanoseconds = -1;
        this.mFinalFinishTimeNanoseconds = -1;
        this.mOemUiUid = -1;
        this.mFallbackUiUid = -1;
        this.mOemUiUsageStatus = OemUiUsageStatus.UNKNOWN;
        this.mChosenProviderStatus = -1;
        this.mHasException = false;
        this.mFrameworkException = "";
        this.mResponseCollective = new ResponseCollective(Map.of(), Map.of());
        this.mIsPrimary = false;
        this.mChosenClassType = "";
        this.mSessionIdCaller = sessionIdCaller;
        this.mSessionIdProvider = sessionIdProvider;
    }

    public void setChosenClassType(String clickedClassType) {
        this.mChosenClassType = clickedClassType;
    }

    public String getChosenClassType() {
        return this.mChosenClassType;
    }

    public int getChosenUid() {
        return this.mChosenUid;
    }

    public void setChosenUid(int chosenUid) {
        this.mChosenUid = chosenUid;
    }

    public void setPreQueryPhaseLatencyMicroseconds(int preQueryPhaseLatencyMicroseconds) {
        this.mPreQueryPhaseLatencyMicroseconds = preQueryPhaseLatencyMicroseconds;
    }

    public void setQueryPhaseLatencyMicroseconds(int queryPhaseLatencyMicroseconds) {
        this.mQueryPhaseLatencyMicroseconds = queryPhaseLatencyMicroseconds;
    }

    public int getPreQueryPhaseLatencyMicroseconds() {
        return this.mPreQueryPhaseLatencyMicroseconds;
    }

    public int getQueryPhaseLatencyMicroseconds() {
        return this.mQueryPhaseLatencyMicroseconds;
    }

    public int getUiPhaseLatencyMicroseconds() {
        return (int) ((this.mUiCallEndTimeNanoseconds - this.mUiCallStartTimeNanoseconds) / 1000);
    }

    public int getEntireProviderLatencyMicroseconds() {
        return (int) ((this.mFinalFinishTimeNanoseconds - this.mQueryStartTimeNanoseconds) / 1000);
    }

    public int getEntireLatencyMicroseconds() {
        return (int) ((this.mFinalFinishTimeNanoseconds - this.mServiceBeganTimeNanoseconds) / 1000);
    }

    public void setServiceBeganTimeNanoseconds(long serviceBeganTimeNanoseconds) {
        this.mServiceBeganTimeNanoseconds = serviceBeganTimeNanoseconds;
    }

    public void setQueryStartTimeNanoseconds(long queryStartTimeNanoseconds) {
        this.mQueryStartTimeNanoseconds = queryStartTimeNanoseconds;
    }

    public void setQueryEndTimeNanoseconds(long queryEndTimeNanoseconds) {
        this.mQueryEndTimeNanoseconds = queryEndTimeNanoseconds;
    }

    public void setUiCallStartTimeNanoseconds(long uiCallStartTimeNanoseconds) {
        this.mUiCallStartTimeNanoseconds = uiCallStartTimeNanoseconds;
    }

    public void setUiCallEndTimeNanoseconds(long uiCallEndTimeNanoseconds) {
        this.mUiCallEndTimeNanoseconds = uiCallEndTimeNanoseconds;
    }

    public void setFinalFinishTimeNanoseconds(long finalFinishTimeNanoseconds) {
        this.mFinalFinishTimeNanoseconds = finalFinishTimeNanoseconds;
    }

    public long getServiceBeganTimeNanoseconds() {
        return this.mServiceBeganTimeNanoseconds;
    }

    public long getQueryStartTimeNanoseconds() {
        return this.mQueryStartTimeNanoseconds;
    }

    public long getQueryEndTimeNanoseconds() {
        return this.mQueryEndTimeNanoseconds;
    }

    public long getUiCallStartTimeNanoseconds() {
        return this.mUiCallStartTimeNanoseconds;
    }

    public long getUiCallEndTimeNanoseconds() {
        return this.mUiCallEndTimeNanoseconds;
    }

    public long getFinalFinishTimeNanoseconds() {
        return this.mFinalFinishTimeNanoseconds;
    }

    public int getTimestampFromReferenceStartMicroseconds(long specificTimestamp) {
        if (specificTimestamp >= this.mServiceBeganTimeNanoseconds) goto L7;
        Slog.i(TAG, "The timestamp is before service started, falling back to default int");
        return -1;
    L7:
        return (int) ((specificTimestamp - this.mServiceBeganTimeNanoseconds) / 1000);
    }

    public int getChosenProviderStatus() {
        return this.mChosenProviderStatus;
    }

    public void setChosenProviderStatus(int chosenProviderStatus) {
        this.mChosenProviderStatus = chosenProviderStatus;
    }

    public int getSessionIdProvider() {
        return this.mSessionIdProvider;
    }

    public void setUiReturned(boolean uiReturned) {
        this.mUiReturned = uiReturned;
    }

    public boolean isUiReturned() {
        return this.mUiReturned;
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

    public int getSessionIdCaller() {
        return this.mSessionIdCaller;
    }

    public void setPrimary(boolean primary) {
        this.mIsPrimary = primary;
    }

    public boolean isPrimary() {
        return this.mIsPrimary;
    }

    public void setOemUiUid(int oemUiUid) {
        this.mOemUiUid = oemUiUid;
    }

    public int getOemUiUid() {
        return this.mOemUiUid;
    }

    public void setFallbackUiUid(int fallbackUiUid) {
        this.mFallbackUiUid = fallbackUiUid;
    }

    public int getFallbackUiUid() {
        return this.mFallbackUiUid;
    }

    public void setOemUiUsageStatus(OemUiUsageStatus oemUiUsageStatus) {
        this.mOemUiUsageStatus = oemUiUsageStatus;
    }

    public int getOemUiUsageStatus() {
        return this.mOemUiUsageStatus.getLoggingInt();
    }
}
