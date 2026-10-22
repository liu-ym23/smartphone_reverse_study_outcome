package com.volcengine.tos.model.object;

import androidx.appfunctions.metadata.a;
import java.util.List;

/* loaded from: classes3.dex */
public class PreSignedPolicyURLInput {
    private String alternativeEndpoint;
    private String bucket;
    private List<PolicySignatureCondition> conditions;
    private long expires;
    private boolean isCustomDomain;

    public static final class PreSignedPolicyURLInputBuilder {
        private String alternativeEndpoint;
        private String bucket;
        private List<PolicySignatureCondition> conditions;
        private long expires;
        private boolean useEndpointWithoutBucket;

        public PreSignedPolicyURLInputBuilder alternativeEndpoint(String str) {
            this.alternativeEndpoint = str;
            return this;
        }

        public PreSignedPolicyURLInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PreSignedPolicyURLInput build() {
            PreSignedPolicyURLInput preSignedPolicyURLInput = new PreSignedPolicyURLInput();
            preSignedPolicyURLInput.setBucket(this.bucket);
            preSignedPolicyURLInput.setExpires(this.expires);
            preSignedPolicyURLInput.setConditions(this.conditions);
            preSignedPolicyURLInput.setAlternativeEndpoint(this.alternativeEndpoint);
            preSignedPolicyURLInput.setCustomDomain(this.useEndpointWithoutBucket);
            return preSignedPolicyURLInput;
        }

        public PreSignedPolicyURLInputBuilder conditions(List<PolicySignatureCondition> list) {
            this.conditions = list;
            return this;
        }

        public PreSignedPolicyURLInputBuilder expires(long j5) {
            this.expires = j5;
            return this;
        }

        public PreSignedPolicyURLInputBuilder useEndpointWithoutBucket(boolean z10) {
            this.useEndpointWithoutBucket = z10;
            return this;
        }

        private PreSignedPolicyURLInputBuilder() {
        }
    }

    public static PreSignedPolicyURLInputBuilder builder() {
        return new PreSignedPolicyURLInputBuilder();
    }

    public String getAlternativeEndpoint() {
        return this.alternativeEndpoint;
    }

    public String getBucket() {
        return this.bucket;
    }

    public List<PolicySignatureCondition> getConditions() {
        return this.conditions;
    }

    public long getExpires() {
        return this.expires;
    }

    public boolean isCustomDomain() {
        return this.isCustomDomain;
    }

    public PreSignedPolicyURLInput setAlternativeEndpoint(String str) {
        this.alternativeEndpoint = str;
        return this;
    }

    public PreSignedPolicyURLInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PreSignedPolicyURLInput setConditions(List<PolicySignatureCondition> list) {
        this.conditions = list;
        return this;
    }

    public PreSignedPolicyURLInput setCustomDomain(boolean z10) {
        this.isCustomDomain = z10;
        return this;
    }

    public PreSignedPolicyURLInput setExpires(long j5) {
        this.expires = j5;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PreSignedPolicyURLInput{bucket='");
        sb.append(this.bucket);
        sb.append("', expires=");
        sb.append(this.expires);
        sb.append(", conditions=");
        sb.append(this.conditions);
        sb.append(", alternativeEndpoint='");
        sb.append(this.alternativeEndpoint);
        sb.append("', isCustomDomain=");
        return a.r(sb, this.isCustomDomain, '}');
    }
}
