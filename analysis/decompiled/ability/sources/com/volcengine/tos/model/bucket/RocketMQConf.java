package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class RocketMQConf {

    @JsonProperty("AccessKeyId")
    private String accessKeyID;

    @JsonProperty("InstanceId")
    private String instanceID;

    @JsonProperty("Topic")
    private String topic;

    public static final class RocketMQConfBuilder {
        private String accessKeyID;
        private String instanceID;
        private String topic;

        public RocketMQConfBuilder accessKeyID(String str) {
            this.accessKeyID = str;
            return this;
        }

        public RocketMQConf build() {
            RocketMQConf rocketMQConf = new RocketMQConf();
            rocketMQConf.setInstanceID(this.instanceID);
            rocketMQConf.setTopic(this.topic);
            rocketMQConf.setAccessKeyID(this.accessKeyID);
            return rocketMQConf;
        }

        public RocketMQConfBuilder instanceID(String str) {
            this.instanceID = str;
            return this;
        }

        public RocketMQConfBuilder topic(String str) {
            this.topic = str;
            return this;
        }

        private RocketMQConfBuilder() {
        }
    }

    public static RocketMQConfBuilder builder() {
        return new RocketMQConfBuilder();
    }

    public String getAccessKeyID() {
        return this.accessKeyID;
    }

    public String getInstanceID() {
        return this.instanceID;
    }

    public String getTopic() {
        return this.topic;
    }

    public RocketMQConf setAccessKeyID(String str) {
        this.accessKeyID = str;
        return this;
    }

    public RocketMQConf setInstanceID(String str) {
        this.instanceID = str;
        return this;
    }

    public RocketMQConf setTopic(String str) {
        this.topic = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RocketMQConf{instanceID='");
        sb.append(this.instanceID);
        sb.append("', topic='");
        sb.append(this.topic);
        sb.append("', accessKeyID='");
        return a.q(sb, this.accessKeyID, "'}");
    }
}
