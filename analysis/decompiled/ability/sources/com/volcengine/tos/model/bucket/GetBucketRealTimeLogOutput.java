package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class GetBucketRealTimeLogOutput {

    @JsonProperty("RealTimeLogConfiguration")
    private RealTimeLogConfiguration configuration;

    @JsonIgnore
    private RequestInfo requestInfo;

    public RealTimeLogConfiguration getConfiguration() {
        return this.configuration;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public GetBucketRealTimeLogOutput setConfiguration(RealTimeLogConfiguration realTimeLogConfiguration) {
        this.configuration = realTimeLogConfiguration;
        return this;
    }

    public GetBucketRealTimeLogOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        return "GetBucketRealTimeLogOutput{requestInfo=" + this.requestInfo + ", configuration=" + this.configuration + '}';
    }
}
