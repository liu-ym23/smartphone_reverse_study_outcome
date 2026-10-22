package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.comm.common.VersioningStatusType;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class GetBucketVersioningOutput {

    @JsonIgnore
    private RequestInfo requestInfo;

    @JsonProperty("Status")
    private VersioningStatusType status;

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public VersioningStatusType getStatus() {
        return this.status;
    }

    public GetBucketVersioningOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public GetBucketVersioningOutput setStatus(VersioningStatusType versioningStatusType) {
        this.status = versioningStatusType;
        return this;
    }

    public String toString() {
        return "GetBucketVersioningOutput{requestInfo=" + this.requestInfo + ", status=" + this.status + '}';
    }
}
