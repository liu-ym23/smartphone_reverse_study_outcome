package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class DeleteBucketRealTimeLogInput {
    private String bucket;

    public static final class DeleteBucketRealTimeLogInputBuilder {
        private String bucket;

        public DeleteBucketRealTimeLogInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public DeleteBucketRealTimeLogInput build() {
            DeleteBucketRealTimeLogInput deleteBucketRealTimeLogInput = new DeleteBucketRealTimeLogInput();
            deleteBucketRealTimeLogInput.setBucket(this.bucket);
            return deleteBucketRealTimeLogInput;
        }

        private DeleteBucketRealTimeLogInputBuilder() {
        }
    }

    public static DeleteBucketRealTimeLogInputBuilder builder() {
        return new DeleteBucketRealTimeLogInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public DeleteBucketRealTimeLogInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("DeleteBucketRealTimeLogInput{bucket='"), this.bucket, "'}");
    }
}
