package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class DeleteBucketReplicationInput {
    private String bucket;

    public static final class DeleteBucketReplicationInputBuilder {
        private String bucket;

        public DeleteBucketReplicationInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public DeleteBucketReplicationInput build() {
            DeleteBucketReplicationInput deleteBucketReplicationInput = new DeleteBucketReplicationInput();
            deleteBucketReplicationInput.setBucket(this.bucket);
            return deleteBucketReplicationInput;
        }

        private DeleteBucketReplicationInputBuilder() {
        }
    }

    public static DeleteBucketReplicationInputBuilder builder() {
        return new DeleteBucketReplicationInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public DeleteBucketReplicationInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("DeleteBucketReplicationInput{bucket='"), this.bucket, "'}");
    }
}
