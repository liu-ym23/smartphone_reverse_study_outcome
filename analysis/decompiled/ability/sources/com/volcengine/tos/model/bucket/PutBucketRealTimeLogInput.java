package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class PutBucketRealTimeLogInput {

    @JsonIgnore
    private String bucket;

    @JsonProperty("RealTimeLogConfiguration")
    private RealTimeLogConfiguration configuration;

    public static final class PutBucketRealTimeLogInputBuilder {
        private String bucket;
        private RealTimeLogConfiguration configuration;

        public PutBucketRealTimeLogInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutBucketRealTimeLogInput build() {
            PutBucketRealTimeLogInput putBucketRealTimeLogInput = new PutBucketRealTimeLogInput();
            putBucketRealTimeLogInput.setBucket(this.bucket);
            putBucketRealTimeLogInput.setConfiguration(this.configuration);
            return putBucketRealTimeLogInput;
        }

        public PutBucketRealTimeLogInputBuilder configuration(RealTimeLogConfiguration realTimeLogConfiguration) {
            this.configuration = realTimeLogConfiguration;
            return this;
        }

        private PutBucketRealTimeLogInputBuilder() {
        }
    }

    public static PutBucketRealTimeLogInputBuilder builder() {
        return new PutBucketRealTimeLogInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public RealTimeLogConfiguration getConfiguration() {
        return this.configuration;
    }

    public PutBucketRealTimeLogInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutBucketRealTimeLogInput setConfiguration(RealTimeLogConfiguration realTimeLogConfiguration) {
        this.configuration = realTimeLogConfiguration;
        return this;
    }

    public String toString() {
        return "PutBucketRealTimeLogInput{bucket='" + this.bucket + "', configuration=" + this.configuration + '}';
    }
}
