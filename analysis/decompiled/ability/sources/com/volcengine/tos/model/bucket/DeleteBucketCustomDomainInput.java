package com.volcengine.tos.model.bucket;

import B7.a;

/* loaded from: classes3.dex */
public class DeleteBucketCustomDomainInput {
    private String bucket;
    private String domain;

    public static final class DeleteBucketCustomDomainInputBuilder {
        private String bucket;
        private String domain;

        public DeleteBucketCustomDomainInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public DeleteBucketCustomDomainInput build() {
            DeleteBucketCustomDomainInput deleteBucketCustomDomainInput = new DeleteBucketCustomDomainInput();
            deleteBucketCustomDomainInput.setBucket(this.bucket);
            deleteBucketCustomDomainInput.setDomain(this.domain);
            return deleteBucketCustomDomainInput;
        }

        public DeleteBucketCustomDomainInputBuilder domain(String str) {
            this.domain = str;
            return this;
        }

        private DeleteBucketCustomDomainInputBuilder() {
        }
    }

    public static DeleteBucketCustomDomainInputBuilder builder() {
        return new DeleteBucketCustomDomainInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getDomain() {
        return this.domain;
    }

    public DeleteBucketCustomDomainInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public DeleteBucketCustomDomainInput setDomain(String str) {
        this.domain = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeleteBucketCustomDomainInput{bucket='");
        sb.append(this.bucket);
        sb.append("', domain='");
        return a.q(sb, this.domain, "'}");
    }
}
