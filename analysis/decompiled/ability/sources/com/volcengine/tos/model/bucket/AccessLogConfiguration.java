package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class AccessLogConfiguration {

    @JsonProperty("TLSProjectID")
    private String tlsProjectID;

    @JsonProperty("TLSTopicID")
    private String tlsTopicID;

    @JsonProperty("UseServiceTopic")
    private boolean useServiceTopic;

    public static final class AccessLogConfigurationBuilder {
        private String tlsProjectID;
        private String tlsTopicID;
        private boolean useServiceTopic;

        public AccessLogConfiguration build() {
            AccessLogConfiguration accessLogConfiguration = new AccessLogConfiguration();
            accessLogConfiguration.setUseServiceTopic(this.useServiceTopic);
            accessLogConfiguration.setTlsProjectID(this.tlsProjectID);
            accessLogConfiguration.setTlsTopicID(this.tlsTopicID);
            return accessLogConfiguration;
        }

        public AccessLogConfigurationBuilder tlsProjectID(String str) {
            this.tlsProjectID = str;
            return this;
        }

        public AccessLogConfigurationBuilder tlsTopicID(String str) {
            this.tlsTopicID = str;
            return this;
        }

        public AccessLogConfigurationBuilder useServiceTopic(boolean z10) {
            this.useServiceTopic = z10;
            return this;
        }

        private AccessLogConfigurationBuilder() {
        }
    }

    public static AccessLogConfigurationBuilder builder() {
        return new AccessLogConfigurationBuilder();
    }

    public String getTlsProjectID() {
        return this.tlsProjectID;
    }

    public String getTlsTopicID() {
        return this.tlsTopicID;
    }

    public boolean isUseServiceTopic() {
        return this.useServiceTopic;
    }

    public AccessLogConfiguration setTlsProjectID(String str) {
        this.tlsProjectID = str;
        return this;
    }

    public AccessLogConfiguration setTlsTopicID(String str) {
        this.tlsTopicID = str;
        return this;
    }

    public AccessLogConfiguration setUseServiceTopic(boolean z10) {
        this.useServiceTopic = z10;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AccessLogConfiguration{useServiceTopic=");
        sb.append(this.useServiceTopic);
        sb.append(", tlsProjectID='");
        sb.append(this.tlsProjectID);
        sb.append("', tlsTopicID='");
        return a.q(sb, this.tlsTopicID, "'}");
    }
}
