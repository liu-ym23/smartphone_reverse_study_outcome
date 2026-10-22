package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class HeadBucketV2Input {
    private String bucket;

    public static final class HeadBucketInputBuilder {
        private String bucket;

        public HeadBucketInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public HeadBucketV2Input build() {
            HeadBucketV2Input headBucketV2Input = new HeadBucketV2Input();
            headBucketV2Input.setBucket(this.bucket);
            return headBucketV2Input;
        }

        private HeadBucketInputBuilder() {
        }
    }

    public static HeadBucketInputBuilder builder() {
        return new HeadBucketInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public HeadBucketV2Input setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("HeadBucketInput{bucket='"), this.bucket, "'}");
    }
}
