package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class GetBucketWebsiteInput {
    private String bucket;

    public static final class GetBucketWebsiteInputBuilder {
        private String bucket;

        public GetBucketWebsiteInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public GetBucketWebsiteInput build() {
            GetBucketWebsiteInput getBucketWebsiteInput = new GetBucketWebsiteInput();
            getBucketWebsiteInput.setBucket(this.bucket);
            return getBucketWebsiteInput;
        }

        private GetBucketWebsiteInputBuilder() {
        }
    }

    public static GetBucketWebsiteInputBuilder builder() {
        return new GetBucketWebsiteInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public GetBucketWebsiteInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("GetBucketWebsiteInput{bucket='"), this.bucket, "'}");
    }
}
