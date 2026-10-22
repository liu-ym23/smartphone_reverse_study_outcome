package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class GetBucketNotificationOutput {

    @JsonProperty("CloudFunctionConfigurations")
    private List<CloudFunctionConfiguration> cloudFunctionConfiguration;

    @JsonIgnore
    private RequestInfo requestInfo;

    public List<CloudFunctionConfiguration> getCloudFunctionConfiguration() {
        return this.cloudFunctionConfiguration;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public GetBucketNotificationOutput setCloudFunctionConfiguration(List<CloudFunctionConfiguration> list) {
        this.cloudFunctionConfiguration = list;
        return this;
    }

    public GetBucketNotificationOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetBucketNotificationOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", cloudFunctionConfiguration=");
        return a.r(sb, this.cloudFunctionConfiguration, '}');
    }
}
