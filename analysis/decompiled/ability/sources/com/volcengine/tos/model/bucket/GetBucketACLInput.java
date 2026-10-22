package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class GetBucketACLInput {
    private String bucket;

    public static final class GetBucketACLInputBuilder {
        private String bucket;

        public GetBucketACLInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public GetBucketACLInput build() {
            GetBucketACLInput getBucketACLInput = new GetBucketACLInput();
            getBucketACLInput.setBucket(this.bucket);
            return getBucketACLInput;
        }

        private GetBucketACLInputBuilder() {
        }
    }

    public static GetBucketACLInputBuilder builder() {
        return new GetBucketACLInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public GetBucketACLInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("GetBucketACLInput{bucket='"), this.bucket, "'}");
    }
}
