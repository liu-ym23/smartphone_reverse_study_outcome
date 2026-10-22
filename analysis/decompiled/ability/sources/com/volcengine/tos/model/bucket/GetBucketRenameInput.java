package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class GetBucketRenameInput {
    private String bucket;

    public static final class GetBucketRenameInputBuilder {
        private String bucket;

        public GetBucketRenameInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public GetBucketRenameInput build() {
            GetBucketRenameInput getBucketRenameInput = new GetBucketRenameInput();
            getBucketRenameInput.setBucket(this.bucket);
            return getBucketRenameInput;
        }

        private GetBucketRenameInputBuilder() {
        }
    }

    public static GetBucketRenameInputBuilder builder() {
        return new GetBucketRenameInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public GetBucketRenameInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("GetBucketRenameInput{bucket='"), this.bucket, "'}");
    }
}
