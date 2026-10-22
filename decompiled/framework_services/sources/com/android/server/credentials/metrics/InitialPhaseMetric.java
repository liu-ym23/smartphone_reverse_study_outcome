package com.android.server.credentials.metrics;

import com.android.server.audio.AudioService$$ExternalSyntheticLambda2;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class InitialPhaseMetric {
    private static final String TAG = "InitialPhaseMetric";
    private int mApiName;
    private boolean mApiUsedPrepareFlow;
    private int mAutofillRequestId;
    private int mAutofillSessionId;
    private int mCallerUid;
    private long mCredentialServiceBeginQueryTimeNanoseconds;
    private long mCredentialServiceStartedTimeNanoseconds;
    private boolean mOriginSpecified;
    private Map<String, Integer> mRequestCounts;
    private final int mSessionIdCaller;

    public InitialPhaseMetric(int sessionIdTrackOne) {
        this.mApiName = ApiName.UNKNOWN.getMetricCode();
        this.mCallerUid = -1;
        this.mCredentialServiceStartedTimeNanoseconds = -1;
        this.mCredentialServiceBeginQueryTimeNanoseconds = -1;
        this.mOriginSpecified = false;
        this.mRequestCounts = new LinkedHashMap();
        this.mAutofillSessionId = -1;
        this.mAutofillRequestId = -1;
        this.mApiUsedPrepareFlow = false;
        this.mSessionIdCaller = sessionIdTrackOne;
    }

    public int getServiceStartToQueryLatencyMicroseconds() {
        return (int) ((this.mCredentialServiceStartedTimeNanoseconds - this.mCredentialServiceBeginQueryTimeNanoseconds) / 1000);
    }

    public void setCredentialServiceStartedTimeNanoseconds(long credentialServiceStartedTimeNanoseconds) {
        this.mCredentialServiceStartedTimeNanoseconds = credentialServiceStartedTimeNanoseconds;
    }

    public void setCredentialServiceBeginQueryTimeNanoseconds(long credentialServiceBeginQueryTimeNanoseconds) {
        this.mCredentialServiceBeginQueryTimeNanoseconds = credentialServiceBeginQueryTimeNanoseconds;
    }

    public long getCredentialServiceStartedTimeNanoseconds() {
        return this.mCredentialServiceStartedTimeNanoseconds;
    }

    public long getCredentialServiceBeginQueryTimeNanoseconds() {
        return this.mCredentialServiceBeginQueryTimeNanoseconds;
    }

    public void setApiName(int apiName) {
        this.mApiName = apiName;
    }

    public int getApiName() {
        return this.mApiName;
    }

    public void setCallerUid(int callerUid) {
        this.mCallerUid = callerUid;
    }

    public int getCallerUid() {
        return this.mCallerUid;
    }

    public int getSessionIdCaller() {
        return this.mSessionIdCaller;
    }

    public int getCountRequestClassType() {
        return this.mRequestCounts.size();
    }

    public void setOriginSpecified(boolean originSpecified) {
        this.mOriginSpecified = originSpecified;
    }

    public boolean isOriginSpecified() {
        return this.mOriginSpecified;
    }

    public void setAutofillSessionId(int autofillSessionId) {
        this.mAutofillSessionId = autofillSessionId;
    }

    public int getAutofillSessionId() {
        return this.mAutofillSessionId;
    }

    public void setAutofillRequestId(int autofillRequestId) {
        this.mAutofillRequestId = autofillRequestId;
    }

    public int getAutofillRequestId() {
        return this.mAutofillRequestId;
    }

    public void setRequestCounts(Map<String, Integer> requestCounts) {
        this.mRequestCounts = requestCounts;
    }

    public String[] getUniqueRequestStrings() {
        String[] result = new String[this.mRequestCounts.keySet().size()];
        this.mRequestCounts.keySet().toArray(result);
        return result;
    }

    public int[] getUniqueRequestCounts() {
        return this.mRequestCounts.values().stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray();
    }

    public void setApiUsedPrepareFlow(boolean apiUsedPrepareFlow) {
        this.mApiUsedPrepareFlow = apiUsedPrepareFlow;
    }

    public boolean hasApiUsedPrepareFlow() {
        return this.mApiUsedPrepareFlow;
    }
}
