package com.volcengine.tos.model.object;

import androidx.appfunctions.metadata.a;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public class PreSingedPolicyURLInput {
    private String alternativeEndpoint;
    private String bucket;
    private List<PolicySignatureCondition> conditions;
    private long expires;
    private boolean isCustomDomain;

    public static final class PreSingedPolicyURLInputBuilder {
        private String alternativeEndpoint;
        private String bucket;
        private List<PolicySignatureCondition> conditions;
        private long expires;
        private boolean useEndpointWithoutBucket;

        public PreSingedPolicyURLInputBuilder alternativeEndpoint(String str) {
            this.alternativeEndpoint = str;
            return this;
        }

        public PreSingedPolicyURLInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PreSingedPolicyURLInput build() {
            PreSingedPolicyURLInput preSingedPolicyURLInput = new PreSingedPolicyURLInput();
            preSingedPolicyURLInput.setBucket(this.bucket);
            preSingedPolicyURLInput.setExpires(this.expires);
            preSingedPolicyURLInput.setConditions(this.conditions);
            preSingedPolicyURLInput.setAlternativeEndpoint(this.alternativeEndpoint);
            preSingedPolicyURLInput.setCustomDomain(this.useEndpointWithoutBucket);
            return preSingedPolicyURLInput;
        }

        public PreSingedPolicyURLInputBuilder conditions(List<PolicySignatureCondition> list) {
            this.conditions = list;
            return this;
        }

        public PreSingedPolicyURLInputBuilder expires(long j5) {
            this.expires = j5;
            return this;
        }

        public PreSingedPolicyURLInputBuilder useEndpointWithoutBucket(boolean z10) {
            this.useEndpointWithoutBucket = z10;
            return this;
        }

        private PreSingedPolicyURLInputBuilder() {
        }
    }

    public static PreSingedPolicyURLInputBuilder builder() {
        return new PreSingedPolicyURLInputBuilder();
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

    public PreSingedPolicyURLInput setAlternativeEndpoint(String str) {
        this.alternativeEndpoint = str;
        return this;
    }

    public PreSingedPolicyURLInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PreSingedPolicyURLInput setConditions(List<PolicySignatureCondition> list) {
        this.conditions = list;
        return this;
    }

    public PreSingedPolicyURLInput setCustomDomain(boolean z10) {
        this.isCustomDomain = z10;
        return this;
    }

    public PreSingedPolicyURLInput setExpires(long j5) {
        this.expires = j5;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PreSingedPolicyURLInput{bucket='");
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
