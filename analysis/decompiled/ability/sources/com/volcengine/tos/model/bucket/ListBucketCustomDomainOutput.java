package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class ListBucketCustomDomainOutput {

    @JsonIgnore
    private RequestInfo requestInfo;

    @JsonProperty("CustomDomainRules")
    private List<CustomDomainRule> rule;

    public static final class ListBucketCustomDomainOutputBuilder {
        private RequestInfo requestInfo;
        private List<CustomDomainRule> rule;

        public ListBucketCustomDomainOutput build() {
            ListBucketCustomDomainOutput listBucketCustomDomainOutput = new ListBucketCustomDomainOutput();
            listBucketCustomDomainOutput.setRequestInfo(this.requestInfo);
            listBucketCustomDomainOutput.setRule(this.rule);
            return listBucketCustomDomainOutput;
        }

        public ListBucketCustomDomainOutputBuilder requestInfo(RequestInfo requestInfo) {
            this.requestInfo = requestInfo;
            return this;
        }

        public ListBucketCustomDomainOutputBuilder rule(List<CustomDomainRule> list) {
            this.rule = list;
            return this;
        }

        private ListBucketCustomDomainOutputBuilder() {
        }
    }

    public static ListBucketCustomDomainOutputBuilder builder() {
        return new ListBucketCustomDomainOutputBuilder();
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public List<CustomDomainRule> getRule() {
        return this.rule;
    }

    public ListBucketCustomDomainOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public ListBucketCustomDomainOutput setRule(List<CustomDomainRule> list) {
        this.rule = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListBucketCustomDomainOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", rule=");
        return a.r(sb, this.rule, '}');
    }
}
