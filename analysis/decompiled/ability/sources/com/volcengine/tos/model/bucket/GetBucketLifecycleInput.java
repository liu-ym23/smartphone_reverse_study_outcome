package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class GetBucketLifecycleInput {
    private String bucket;

    public static final class GetBucketLifecycleInputBuilder {
        private String bucket;

        public GetBucketLifecycleInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public GetBucketLifecycleInput build() {
            GetBucketLifecycleInput getBucketLifecycleInput = new GetBucketLifecycleInput();
            getBucketLifecycleInput.setBucket(this.bucket);
            return getBucketLifecycleInput;
        }

        private GetBucketLifecycleInputBuilder() {
        }
    }

    public static GetBucketLifecycleInputBuilder builder() {
        return new GetBucketLifecycleInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public GetBucketLifecycleInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("GetBucketLifecycleInput{bucket='"), this.bucket, "'}");
    }
}
