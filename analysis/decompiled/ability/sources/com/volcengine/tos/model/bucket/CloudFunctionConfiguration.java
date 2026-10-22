package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* loaded from: classes3.dex */
public class CloudFunctionConfiguration {

    @JsonProperty("CloudFunction")
    private String cloudFunction;

    @JsonProperty("Events")
    private List<String> events;

    @JsonProperty("Filter")
    private Filter filter;

    @JsonProperty("RuleId")
    private String id;

    public static final class CloudFunctionConfigurationBuilder {
        private String cloudFunction;
        private List<String> events;
        private Filter filter;
        private String id;

        public CloudFunctionConfiguration build() {
            CloudFunctionConfiguration cloudFunctionConfiguration = new CloudFunctionConfiguration();
            cloudFunctionConfiguration.setId(this.id);
            cloudFunctionConfiguration.setEvents(this.events);
            cloudFunctionConfiguration.setFilter(this.filter);
            cloudFunctionConfiguration.setCloudFunction(this.cloudFunction);
            return cloudFunctionConfiguration;
        }

        public CloudFunctionConfigurationBuilder cloudFunction(String str) {
            this.cloudFunction = str;
            return this;
        }

        public CloudFunctionConfigurationBuilder events(List<String> list) {
            this.events = list;
            return this;
        }

        public CloudFunctionConfigurationBuilder filter(Filter filter) {
            this.filter = filter;
            return this;
        }

        public CloudFunctionConfigurationBuilder id(String str) {
            this.id = str;
            return this;
        }

        private CloudFunctionConfigurationBuilder() {
        }
    }

    public static CloudFunctionConfigurationBuilder builder() {
        return new CloudFunctionConfigurationBuilder();
    }

    public String getCloudFunction() {
        return this.cloudFunction;
    }

    public List<String> getEvents() {
        return this.events;
    }

    public Filter getFilter() {
        return this.filter;
    }

    public String getId() {
        return this.id;
    }

    public CloudFunctionConfiguration setCloudFunction(String str) {
        this.cloudFunction = str;
        return this;
    }

    public CloudFunctionConfiguration setEvents(List<String> list) {
        this.events = list;
        return this;
    }

    public CloudFunctionConfiguration setFilter(Filter filter) {
        this.filter = filter;
        return this;
    }

    public CloudFunctionConfiguration setId(String str) {
        this.id = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CloudFunctionConfiguration{id='");
        sb.append(this.id);
        sb.append("', events=");
        sb.append(this.events);
        sb.append(", filter=");
        sb.append(this.filter);
        sb.append(", cloudFunction='");
        return a.q(sb, this.cloudFunction, "'}");
    }
}
