package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class GetBucketNotificationInput {
    private String bucket;

    public static final class GetBucketNotificationInputBuilder {
        private String bucket;

        public GetBucketNotificationInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public GetBucketNotificationInput build() {
            GetBucketNotificationInput getBucketNotificationInput = new GetBucketNotificationInput();
            getBucketNotificationInput.setBucket(this.bucket);
            return getBucketNotificationInput;
        }

        private GetBucketNotificationInputBuilder() {
        }
    }

    public static GetBucketNotificationInputBuilder builder() {
        return new GetBucketNotificationInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public GetBucketNotificationInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("GetBucketNotificationInput{bucket='"), this.bucket, "'}");
    }
}
