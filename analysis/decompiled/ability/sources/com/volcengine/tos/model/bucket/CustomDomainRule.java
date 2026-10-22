package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.comm.common.CertStatusType;

/* loaded from: classes3.dex */
public class CustomDomainRule {

    @JsonProperty("CertId")
    private String certID;

    @JsonProperty("CertStatus")
    private CertStatusType certStatus;

    @JsonProperty("Cname")
    private String cname;

    @JsonProperty("Domain")
    private String domain;

    @JsonProperty("Forbidden")
    private boolean forbidden;

    @JsonProperty("ForbiddenReason")
    private String forbiddenReason;

    public static final class CustomDomainRuleBuilder {
        private String certID;
        private CertStatusType certStatus;
        private String cname;
        private String domain;
        private boolean forbidden;
        private String forbiddenReason;

        public CustomDomainRule build() {
            CustomDomainRule customDomainRule = new CustomDomainRule();
            customDomainRule.setCertID(this.certID);
            customDomainRule.setCertStatus(this.certStatus);
            customDomainRule.setCname(this.cname);
            customDomainRule.setDomain(this.domain);
            customDomainRule.setForbidden(this.forbidden);
            customDomainRule.setForbiddenReason(this.forbiddenReason);
            return customDomainRule;
        }

        public CustomDomainRuleBuilder certID(String str) {
            this.certID = str;
            return this;
        }

        public CustomDomainRuleBuilder certStatus(CertStatusType certStatusType) {
            this.certStatus = certStatusType;
            return this;
        }

        public CustomDomainRuleBuilder cname(String str) {
            this.cname = str;
            return this;
        }

        public CustomDomainRuleBuilder domain(String str) {
            this.domain = str;
            return this;
        }

        public CustomDomainRuleBuilder forbidden(boolean z10) {
            this.forbidden = z10;
            return this;
        }

        public CustomDomainRuleBuilder forbiddenReason(String str) {
            this.forbiddenReason = str;
            return this;
        }

        private CustomDomainRuleBuilder() {
        }
    }

    public static CustomDomainRuleBuilder builder() {
        return new CustomDomainRuleBuilder();
    }

    public String getCertID() {
        return this.certID;
    }

    public CertStatusType getCertStatus() {
        return this.certStatus;
    }

    public String getCname() {
        return this.cname;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getForbiddenReason() {
        return this.forbiddenReason;
    }

    public boolean isForbidden() {
        return this.forbidden;
    }

    public CustomDomainRule setCertID(String str) {
        this.certID = str;
        return this;
    }

    public CustomDomainRule setCertStatus(CertStatusType certStatusType) {
        this.certStatus = certStatusType;
        return this;
    }

    public CustomDomainRule setCname(String str) {
        this.cname = str;
        return this;
    }

    public CustomDomainRule setDomain(String str) {
        this.domain = str;
        return this;
    }

    public CustomDomainRule setForbidden(boolean z10) {
        this.forbidden = z10;
        return this;
    }

    public CustomDomainRule setForbiddenReason(String str) {
        this.forbiddenReason = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CustomDomainRule{certID='");
        sb.append(this.certID);
        sb.append("', cname='");
        sb.append(this.cname);
        sb.append("', certStatus=");
        sb.append(this.certStatus);
        sb.append(", domain='");
        sb.append(this.domain);
        sb.append("', forbidden=");
        sb.append(this.forbidden);
        sb.append(", forbiddenReason='");
        return a.q(sb, this.forbiddenReason, "'}");
    }
}
