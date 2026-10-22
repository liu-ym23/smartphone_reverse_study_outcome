package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class GetBucketVersioningInput {
    private String bucket;

    public static final class GetBucketVersioningInputBuilder {
        private String bucket;

        public GetBucketVersioningInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public GetBucketVersioningInput build() {
            GetBucketVersioningInput getBucketVersioningInput = new GetBucketVersioningInput();
            getBucketVersioningInput.setBucket(this.bucket);
            return getBucketVersioningInput;
        }

        private GetBucketVersioningInputBuilder() {
        }
    }

    public static GetBucketVersioningInputBuilder builder() {
        return new GetBucketVersioningInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public GetBucketVersioningInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("GetBucketVersioningInput{bucket='"), this.bucket, "'}");
    }
}
