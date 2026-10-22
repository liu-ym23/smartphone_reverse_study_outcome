package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* loaded from: classes3.dex */
public class PutBucketWebsiteInput {

    @JsonIgnore
    private String bucket;

    @JsonProperty("ErrorDocument")
    private ErrorDocument errorDocument;

    @JsonProperty("IndexDocument")
    private IndexDocument indexDocument;

    @JsonProperty("RedirectAllRequestsTo")
    private RedirectAllRequestsTo redirectAllRequestsTo;

    @JsonProperty("RoutingRules")
    private List<RoutingRule> routingRules;

    public static final class PutBucketWebsiteInputBuilder {
        private String bucket;
        private ErrorDocument errorDocument;
        private IndexDocument indexDocument;
        private RedirectAllRequestsTo redirectAllRequestsTo;
        private List<RoutingRule> routingRules;

        public PutBucketWebsiteInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutBucketWebsiteInput build() {
            PutBucketWebsiteInput putBucketWebsiteInput = new PutBucketWebsiteInput();
            putBucketWebsiteInput.setBucket(this.bucket);
            putBucketWebsiteInput.setRedirectAllRequestsTo(this.redirectAllRequestsTo);
            putBucketWebsiteInput.setIndexDocument(this.indexDocument);
            putBucketWebsiteInput.setErrorDocument(this.errorDocument);
            putBucketWebsiteInput.setRoutingRules(this.routingRules);
            return putBucketWebsiteInput;
        }

        public PutBucketWebsiteInputBuilder errorDocument(ErrorDocument errorDocument) {
            this.errorDocument = errorDocument;
            return this;
        }

        public PutBucketWebsiteInputBuilder indexDocument(IndexDocument indexDocument) {
            this.indexDocument = indexDocument;
            return this;
        }

        public PutBucketWebsiteInputBuilder redirectAllRequestsTo(RedirectAllRequestsTo redirectAllRequestsTo) {
            this.redirectAllRequestsTo = redirectAllRequestsTo;
            return this;
        }

        public PutBucketWebsiteInputBuilder routingRules(List<RoutingRule> list) {
            this.routingRules = list;
            return this;
        }

        private PutBucketWebsiteInputBuilder() {
        }
    }

    public static PutBucketWebsiteInputBuilder builder() {
        return new PutBucketWebsiteInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public ErrorDocument getErrorDocument() {
        return this.errorDocument;
    }

    public IndexDocument getIndexDocument() {
        return this.indexDocument;
    }

    public RedirectAllRequestsTo getRedirectAllRequestsTo() {
        return this.redirectAllRequestsTo;
    }

    public List<RoutingRule> getRoutingRules() {
        return this.routingRules;
    }

    public PutBucketWebsiteInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutBucketWebsiteInput setErrorDocument(ErrorDocument errorDocument) {
        this.errorDocument = errorDocument;
        return this;
    }

    public PutBucketWebsiteInput setIndexDocument(IndexDocument indexDocument) {
        this.indexDocument = indexDocument;
        return this;
    }

    public PutBucketWebsiteInput setRedirectAllRequestsTo(RedirectAllRequestsTo redirectAllRequestsTo) {
        this.redirectAllRequestsTo = redirectAllRequestsTo;
        return this;
    }

    public PutBucketWebsiteInput setRoutingRules(List<RoutingRule> list) {
        this.routingRules = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutBucketWebsiteInput{bucket='");
        sb.append(this.bucket);
        sb.append("', redirectAllRequestsTo=");
        sb.append(this.redirectAllRequestsTo);
        sb.append(", indexDocument=");
        sb.append(this.indexDocument);
        sb.append(", errorDocument=");
        sb.append(this.errorDocument);
        sb.append(", routingRules=");
        return a.r(sb, this.routingRules, '}');
    }
}
