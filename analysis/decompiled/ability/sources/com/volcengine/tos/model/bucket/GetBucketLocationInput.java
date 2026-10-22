package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class GetBucketLocationInput {
    private String bucket;

    public static final class GetBucketLocationInputBuilder {
        private String bucket;

        public GetBucketLocationInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public GetBucketLocationInput build() {
            GetBucketLocationInput getBucketLocationInput = new GetBucketLocationInput();
            getBucketLocationInput.setBucket(this.bucket);
            return getBucketLocationInput;
        }

        private GetBucketLocationInputBuilder() {
        }
    }

    public static GetBucketLocationInputBuilder builder() {
        return new GetBucketLocationInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public GetBucketLocationInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("GetBucketLocationInput{bucket='"), this.bucket, "'}");
    }
}
