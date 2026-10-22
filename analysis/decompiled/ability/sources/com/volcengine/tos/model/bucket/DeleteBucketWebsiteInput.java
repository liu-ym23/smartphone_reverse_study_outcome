package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class DeleteBucketWebsiteInput {
    private String bucket;

    public static final class DeleteBucketWebsiteInputBuilder {
        private String bucket;

        public DeleteBucketWebsiteInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public DeleteBucketWebsiteInput build() {
            DeleteBucketWebsiteInput deleteBucketWebsiteInput = new DeleteBucketWebsiteInput();
            deleteBucketWebsiteInput.setBucket(this.bucket);
            return deleteBucketWebsiteInput;
        }

        private DeleteBucketWebsiteInputBuilder() {
        }
    }

    public static DeleteBucketWebsiteInputBuilder builder() {
        return new DeleteBucketWebsiteInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public DeleteBucketWebsiteInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("DeleteBucketWebsiteInput{bucket='"), this.bucket, "'}");
    }
}
