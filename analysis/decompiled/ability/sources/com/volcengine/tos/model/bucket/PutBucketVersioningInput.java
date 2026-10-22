package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.comm.common.VersioningStatusType;

/* loaded from: classes3.dex */
public class PutBucketVersioningInput {

    @JsonIgnore
    private String bucket;

    @JsonProperty("Status")
    private VersioningStatusType status;

    public static final class PutBucketVersioningInputBuilder {
        private String bucket;
        private VersioningStatusType status;

        public PutBucketVersioningInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutBucketVersioningInput build() {
            PutBucketVersioningInput putBucketVersioningInput = new PutBucketVersioningInput();
            putBucketVersioningInput.setBucket(this.bucket);
            putBucketVersioningInput.setStatus(this.status);
            return putBucketVersioningInput;
        }

        public PutBucketVersioningInputBuilder status(VersioningStatusType versioningStatusType) {
            this.status = versioningStatusType;
            return this;
        }

        private PutBucketVersioningInputBuilder() {
        }
    }

    public static PutBucketVersioningInputBuilder builder() {
        return new PutBucketVersioningInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public VersioningStatusType getStatus() {
        return this.status;
    }

    public PutBucketVersioningInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutBucketVersioningInput setStatus(VersioningStatusType versioningStatusType) {
        this.status = versioningStatusType;
        return this;
    }

    public String toString() {
        return "PutBucketVersioningInput{bucket='" + this.bucket + "', status=" + this.status + '}';
    }
}
