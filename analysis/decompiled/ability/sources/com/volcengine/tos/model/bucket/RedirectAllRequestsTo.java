package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class RedirectAllRequestsTo {

    @JsonProperty("HostName")
    private String hostname;

    @JsonProperty("Protocol")
    private String protocol;

    public static final class RedirectAllRequestsToBuilder {
        private String hostname;
        private String protocol;

        public RedirectAllRequestsTo build() {
            RedirectAllRequestsTo redirectAllRequestsTo = new RedirectAllRequestsTo();
            redirectAllRequestsTo.setHostname(this.hostname);
            redirectAllRequestsTo.setProtocol(this.protocol);
            return redirectAllRequestsTo;
        }

        public RedirectAllRequestsToBuilder hostname(String str) {
            this.hostname = str;
            return this;
        }

        public RedirectAllRequestsToBuilder protocol(String str) {
            this.protocol = str;
            return this;
        }

        private RedirectAllRequestsToBuilder() {
        }
    }

    public static RedirectAllRequestsToBuilder builder() {
        return new RedirectAllRequestsToBuilder();
    }

    public String getHostname() {
        return this.hostname;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public RedirectAllRequestsTo setHostname(String str) {
        this.hostname = str;
        return this;
    }

    public RedirectAllRequestsTo setProtocol(String str) {
        this.protocol = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RedirectAllRequestsTo{hostname='");
        sb.append(this.hostname);
        sb.append("', protocol='");
        return a.q(sb, this.protocol, "'}");
    }
}
