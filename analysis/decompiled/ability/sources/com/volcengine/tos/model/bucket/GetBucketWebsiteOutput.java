package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class GetBucketWebsiteOutput {

    @JsonProperty("ErrorDocument")
    private ErrorDocument errorDocument;

    @JsonProperty("IndexDocument")
    private IndexDocument indexDocument;

    @JsonProperty("RedirectAllRequestsTo")
    private RedirectAllRequestsTo redirectAllRequestsTo;

    @JsonIgnore
    private RequestInfo requestInfo;

    @JsonProperty("RoutingRules")
    private List<RoutingRule> routingRules;

    public ErrorDocument getErrorDocument() {
        return this.errorDocument;
    }

    public IndexDocument getIndexDocument() {
        return this.indexDocument;
    }

    public RedirectAllRequestsTo getRedirectAllRequestsTo() {
        return this.redirectAllRequestsTo;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public List<RoutingRule> getRoutingRules() {
        return this.routingRules;
    }

    public GetBucketWebsiteOutput setErrorDocument(ErrorDocument errorDocument) {
        this.errorDocument = errorDocument;
        return this;
    }

    public GetBucketWebsiteOutput setIndexDocument(IndexDocument indexDocument) {
        this.indexDocument = indexDocument;
        return this;
    }

    public GetBucketWebsiteOutput setRedirectAllRequestsTo(RedirectAllRequestsTo redirectAllRequestsTo) {
        this.redirectAllRequestsTo = redirectAllRequestsTo;
        return this;
    }

    public GetBucketWebsiteOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public GetBucketWebsiteOutput setRoutingRules(List<RoutingRule> list) {
        this.routingRules = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetBucketWebsiteOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", redirectAllRequestsTo=");
        sb.append(this.redirectAllRequestsTo);
        sb.append(", indexDocument=");
        sb.append(this.indexDocument);
        sb.append(", errorDocument=");
        sb.append(this.errorDocument);
        sb.append(", routingRules=");
        return a.r(sb, this.routingRules, '}');
    }
}
