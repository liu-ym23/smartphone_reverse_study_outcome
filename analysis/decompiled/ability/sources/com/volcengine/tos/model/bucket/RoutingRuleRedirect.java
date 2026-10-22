package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.comm.common.ProtocolType;

/* loaded from: classes3.dex */
public class RoutingRuleRedirect {

    @JsonProperty("HostName")
    private String hostname;

    @JsonProperty("HttpRedirectCode")
    private int httpRedirectCode;

    @JsonProperty("Protocol")
    private ProtocolType protocol;

    @JsonProperty("ReplaceKeyPrefixWith")
    private String replaceKeyPrefixWith;

    @JsonProperty("ReplaceKeyWith")
    private String replaceKeyWith;

    public static final class RoutingRuleRedirectBuilder {
        private String hostname;
        private int httpRedirectCode;
        private ProtocolType protocol;
        private String replaceKeyPrefixWith;
        private String replaceKeyWith;

        public RoutingRuleRedirect build() {
            RoutingRuleRedirect routingRuleRedirect = new RoutingRuleRedirect();
            routingRuleRedirect.setProtocol(this.protocol);
            routingRuleRedirect.setHostname(this.hostname);
            routingRuleRedirect.setReplaceKeyPrefixWith(this.replaceKeyPrefixWith);
            routingRuleRedirect.setReplaceKeyWith(this.replaceKeyWith);
            routingRuleRedirect.setHttpRedirectCode(this.httpRedirectCode);
            return routingRuleRedirect;
        }

        public RoutingRuleRedirectBuilder hostname(String str) {
            this.hostname = str;
            return this;
        }

        public RoutingRuleRedirectBuilder httpRedirectCode(int i) {
            this.httpRedirectCode = i;
            return this;
        }

        public RoutingRuleRedirectBuilder protocol(ProtocolType protocolType) {
            this.protocol = protocolType;
            return this;
        }

        public RoutingRuleRedirectBuilder replaceKeyPrefixWith(String str) {
            this.replaceKeyPrefixWith = str;
            return this;
        }

        public RoutingRuleRedirectBuilder replaceKeyWith(String str) {
            this.replaceKeyWith = str;
            return this;
        }

        private RoutingRuleRedirectBuilder() {
        }
    }

    public static RoutingRuleRedirectBuilder builder() {
        return new RoutingRuleRedirectBuilder();
    }

    public String getHostname() {
        return this.hostname;
    }

    public int getHttpRedirectCode() {
        return this.httpRedirectCode;
    }

    public ProtocolType getProtocol() {
        return this.protocol;
    }

    public String getReplaceKeyPrefixWith() {
        return this.replaceKeyPrefixWith;
    }

    public String getReplaceKeyWith() {
        return this.replaceKeyWith;
    }

    public RoutingRuleRedirect setHostname(String str) {
        this.hostname = str;
        return this;
    }

    public RoutingRuleRedirect setHttpRedirectCode(int i) {
        this.httpRedirectCode = i;
        return this;
    }

    public RoutingRuleRedirect setProtocol(ProtocolType protocolType) {
        this.protocol = protocolType;
        return this;
    }

    public RoutingRuleRedirect setReplaceKeyPrefixWith(String str) {
        this.replaceKeyPrefixWith = str;
        return this;
    }

    public RoutingRuleRedirect setReplaceKeyWith(String str) {
        this.replaceKeyWith = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RoutingRuleRedirect{protocol=");
        sb.append(this.protocol);
        sb.append(", hostname='");
        sb.append(this.hostname);
        sb.append("', replaceKeyPrefixWith='");
        sb.append(this.replaceKeyPrefixWith);
        sb.append("', replaceKeyWith='");
        sb.append(this.replaceKeyWith);
        sb.append("', httpRedirectCode=");
        return a.o(sb, this.httpRedirectCode, '}');
    }
}
