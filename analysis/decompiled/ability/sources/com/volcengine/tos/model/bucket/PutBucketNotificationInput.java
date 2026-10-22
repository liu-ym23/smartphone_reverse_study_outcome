package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* loaded from: classes3.dex */
public class PutBucketNotificationInput {

    @JsonIgnore
    private String bucket;

    @JsonProperty("CloudFunctionConfigurations")
    private List<CloudFunctionConfiguration> cloudFunctionConfigurations;

    @JsonProperty("RocketMQConfigurations")
    private List<RocketMQConfiguration> rocketMQConfigurations;

    public static final class PutBucketNotificationInputBuilder {
        private String bucket;
        private List<CloudFunctionConfiguration> cloudFunctionConfigurations;
        private List<RocketMQConfiguration> rocketMQConfigurations;

        public PutBucketNotificationInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutBucketNotificationInput build() {
            PutBucketNotificationInput putBucketNotificationInput = new PutBucketNotificationInput();
            putBucketNotificationInput.setBucket(this.bucket);
            putBucketNotificationInput.setCloudFunctionConfigurations(this.cloudFunctionConfigurations);
            putBucketNotificationInput.setRocketMQConfigurations(this.rocketMQConfigurations);
            return putBucketNotificationInput;
        }

        public PutBucketNotificationInputBuilder cloudFunctionConfigurations(List<CloudFunctionConfiguration> list) {
            this.cloudFunctionConfigurations = list;
            return this;
        }

        public PutBucketNotificationInputBuilder rocketMQConfigurations(List<RocketMQConfiguration> list) {
            this.rocketMQConfigurations = list;
            return this;
        }

        private PutBucketNotificationInputBuilder() {
        }
    }

    public static PutBucketNotificationInputBuilder builder() {
        return new PutBucketNotificationInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public List<CloudFunctionConfiguration> getCloudFunctionConfigurations() {
        return this.cloudFunctionConfigurations;
    }

    public List<RocketMQConfiguration> getRocketMQConfigurations() {
        return this.rocketMQConfigurations;
    }

    public PutBucketNotificationInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutBucketNotificationInput setCloudFunctionConfigurations(List<CloudFunctionConfiguration> list) {
        this.cloudFunctionConfigurations = list;
        return this;
    }

    public PutBucketNotificationInput setRocketMQConfigurations(List<RocketMQConfiguration> list) {
        this.rocketMQConfigurations = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutBucketNotificationInput{bucket='");
        sb.append(this.bucket);
        sb.append("', cloudFunctionConfigurations=");
        sb.append(this.cloudFunctionConfigurations);
        sb.append(", rocketMQConfigurations=");
        return a.r(sb, this.rocketMQConfigurations, '}');
    }
}
