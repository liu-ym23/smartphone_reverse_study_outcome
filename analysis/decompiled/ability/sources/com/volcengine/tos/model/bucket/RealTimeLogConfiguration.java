package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class RealTimeLogConfiguration {

    @JsonProperty("AccessLogConfiguration")
    private AccessLogConfiguration configuration;

    @JsonProperty("Role")
    private String role;

    public static final class RealTimeLogConfigurationBuilder {
        private AccessLogConfiguration configuration;
        private String role;

        public RealTimeLogConfiguration build() {
            RealTimeLogConfiguration realTimeLogConfiguration = new RealTimeLogConfiguration();
            realTimeLogConfiguration.setRole(this.role);
            realTimeLogConfiguration.setConfiguration(this.configuration);
            return realTimeLogConfiguration;
        }

        public RealTimeLogConfigurationBuilder configuration(AccessLogConfiguration accessLogConfiguration) {
            this.configuration = accessLogConfiguration;
            return this;
        }

        public RealTimeLogConfigurationBuilder role(String str) {
            this.role = str;
            return this;
        }

        private RealTimeLogConfigurationBuilder() {
        }
    }

    public static RealTimeLogConfigurationBuilder builder() {
        return new RealTimeLogConfigurationBuilder();
    }

    public AccessLogConfiguration getConfiguration() {
        return this.configuration;
    }

    public String getRole() {
        return this.role;
    }

    public RealTimeLogConfiguration setConfiguration(AccessLogConfiguration accessLogConfiguration) {
        this.configuration = accessLogConfiguration;
        return this;
    }

    public RealTimeLogConfiguration setRole(String str) {
        this.role = str;
        return this;
    }

    public String toString() {
        return "RealTimeLogConfiguration{role='" + this.role + "', configuration=" + this.configuration + '}';
    }
}
