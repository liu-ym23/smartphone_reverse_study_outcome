package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class GetBucketLocationOutput {

    @JsonProperty("ExtranetEndpoint")
    private String extranetEndpoint;

    @JsonProperty("IntranetEndpoint")
    private String intranetEndpoint;

    @JsonProperty("Region")
    private String region;

    @JsonIgnore
    private RequestInfo requestInfo;

    public String getExtranetEndpoint() {
        return this.extranetEndpoint;
    }

    public String getIntranetEndpoint() {
        return this.intranetEndpoint;
    }

    public String getRegion() {
        return this.region;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public GetBucketLocationOutput setExtranetEndpoint(String str) {
        this.extranetEndpoint = str;
        return this;
    }

    public GetBucketLocationOutput setIntranetEndpoint(String str) {
        this.intranetEndpoint = str;
        return this;
    }

    public GetBucketLocationOutput setRegion(String str) {
        this.region = str;
        return this;
    }

    public GetBucketLocationOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetBucketLocationOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", region='");
        sb.append(this.region);
        sb.append("', extranetEndpoint='");
        sb.append(this.extranetEndpoint);
        sb.append("', intranetEndpoint='");
        return a.q(sb, this.intranetEndpoint, "'}");
    }
}
