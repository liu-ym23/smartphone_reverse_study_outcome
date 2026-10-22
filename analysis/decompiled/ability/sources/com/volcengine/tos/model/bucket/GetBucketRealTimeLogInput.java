package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class GetBucketRealTimeLogInput {
    private String bucket;

    public static final class GetBucketRealTimeLogInputBuilder {
        private String bucket;

        public GetBucketRealTimeLogInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public GetBucketRealTimeLogInput build() {
            GetBucketRealTimeLogInput getBucketRealTimeLogInput = new GetBucketRealTimeLogInput();
            getBucketRealTimeLogInput.setBucket(this.bucket);
            return getBucketRealTimeLogInput;
        }

        private GetBucketRealTimeLogInputBuilder() {
        }
    }

    public static GetBucketRealTimeLogInputBuilder builder() {
        return new GetBucketRealTimeLogInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public GetBucketRealTimeLogInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("GetBucketRealTimeLogInput{bucket='"), this.bucket, "'}");
    }
}
