package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class GetBucketMirrorBackInput {
    private String bucket;

    public static final class GetBucketMirrorBackInputBuilder {
        private String bucket;

        public GetBucketMirrorBackInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public GetBucketMirrorBackInput build() {
            GetBucketMirrorBackInput getBucketMirrorBackInput = new GetBucketMirrorBackInput();
            getBucketMirrorBackInput.setBucket(this.bucket);
            return getBucketMirrorBackInput;
        }

        private GetBucketMirrorBackInputBuilder() {
        }
    }

    public static GetBucketMirrorBackInputBuilder builder() {
        return new GetBucketMirrorBackInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public GetBucketMirrorBackInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("GetBucketMirrorBackInput{bucket='"), this.bucket, "'}");
    }
}
