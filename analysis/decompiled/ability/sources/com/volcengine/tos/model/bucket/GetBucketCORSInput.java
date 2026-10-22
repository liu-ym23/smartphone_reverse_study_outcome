package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class GetBucketCORSInput {
    private String bucket;

    public static final class GetBucketCORSInputBuilder {
        private String bucket;

        public GetBucketCORSInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public GetBucketCORSInput build() {
            GetBucketCORSInput getBucketCORSInput = new GetBucketCORSInput();
            getBucketCORSInput.setBucket(this.bucket);
            return getBucketCORSInput;
        }

        private GetBucketCORSInputBuilder() {
        }
    }

    public static GetBucketCORSInputBuilder builder() {
        return new GetBucketCORSInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public GetBucketCORSInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("GetBucketCORSInput{bucket='"), this.bucket, "'}");
    }
}
