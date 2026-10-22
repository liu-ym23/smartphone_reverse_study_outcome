package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* loaded from: classes3.dex */
public class RocketMQConfiguration {

    @JsonProperty("Events")
    private List<String> events;

    @JsonProperty("Filter")
    private Filter filter;

    @JsonProperty("RuleId")
    private String id;

    @JsonProperty("RocketMQ")
    private RocketMQConf rocketMQ;

    @JsonProperty("Role")
    private String role;

    public static final class RocketMQConfigurationBuilder {
        private List<String> events;
        private Filter filter;
        private String id;
        private RocketMQConf rocketMQ;
        private String role;

        public RocketMQConfiguration build() {
            RocketMQConfiguration rocketMQConfiguration = new RocketMQConfiguration();
            rocketMQConfiguration.setId(this.id);
            rocketMQConfiguration.setRole(this.role);
            rocketMQConfiguration.setEvents(this.events);
            rocketMQConfiguration.setFilter(this.filter);
            rocketMQConfiguration.setRocketMQ(this.rocketMQ);
            return rocketMQConfiguration;
        }

        public RocketMQConfigurationBuilder events(List<String> list) {
            this.events = list;
            return this;
        }

        public RocketMQConfigurationBuilder filter(Filter filter) {
            this.filter = filter;
            return this;
        }

        public RocketMQConfigurationBuilder id(String str) {
            this.id = str;
            return this;
        }

        public RocketMQConfigurationBuilder rocketMQ(RocketMQConf rocketMQConf) {
            this.rocketMQ = rocketMQConf;
            return this;
        }

        public RocketMQConfigurationBuilder role(String str) {
            this.role = str;
            return this;
        }

        private RocketMQConfigurationBuilder() {
        }
    }

    public static RocketMQConfigurationBuilder builder() {
        return new RocketMQConfigurationBuilder();
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

    public RocketMQConf getRocketMQ() {
        return this.rocketMQ;
    }

    public String getRole() {
        return this.role;
    }

    public RocketMQConfiguration setEvents(List<String> list) {
        this.events = list;
        return this;
    }

    public RocketMQConfiguration setFilter(Filter filter) {
        this.filter = filter;
        return this;
    }

    public RocketMQConfiguration setId(String str) {
        this.id = str;
        return this;
    }

    public RocketMQConfiguration setRocketMQ(RocketMQConf rocketMQConf) {
        this.rocketMQ = rocketMQConf;
        return this;
    }

    public RocketMQConfiguration setRole(String str) {
        this.role = str;
        return this;
    }

    public String toString() {
        return "RocketMQConfiguration{id='" + this.id + "', role='" + this.role + "', events=" + this.events + ", filter=" + this.filter + ", rocketMQ=" + this.rocketMQ + '}';
    }
}
