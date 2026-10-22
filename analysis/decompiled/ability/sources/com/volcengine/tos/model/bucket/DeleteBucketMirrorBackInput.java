package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class DeleteBucketMirrorBackInput {
    private String bucket;

    public static final class DeleteBucketMirrorBackInputBuilder {
        private String bucket;

        public DeleteBucketMirrorBackInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public DeleteBucketMirrorBackInput build() {
            DeleteBucketMirrorBackInput deleteBucketMirrorBackInput = new DeleteBucketMirrorBackInput();
            deleteBucketMirrorBackInput.setBucket(this.bucket);
            return deleteBucketMirrorBackInput;
        }

        private DeleteBucketMirrorBackInputBuilder() {
        }
    }

    public static DeleteBucketMirrorBackInputBuilder builder() {
        return new DeleteBucketMirrorBackInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public DeleteBucketMirrorBackInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("DeleteBucketMirrorBackInput{bucket='"), this.bucket, "'}");
    }
}
