package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class ListBucketCustomDomainInput {
    private String bucket;

    public static final class ListBucketCustomDomainInputBuilder {
        private String bucket;

        public ListBucketCustomDomainInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public ListBucketCustomDomainInput build() {
            ListBucketCustomDomainInput listBucketCustomDomainInput = new ListBucketCustomDomainInput();
            listBucketCustomDomainInput.setBucket(this.bucket);
            return listBucketCustomDomainInput;
        }

        private ListBucketCustomDomainInputBuilder() {
        }
    }

    public static ListBucketCustomDomainInputBuilder builder() {
        return new ListBucketCustomDomainInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public ListBucketCustomDomainInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("ListBucketCustomDomainInput{bucket='"), this.bucket, "'}");
    }
}
