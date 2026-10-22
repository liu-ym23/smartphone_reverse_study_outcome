package com.volcengine.tos.model.bucket;

import com.volcengine.tos.comm.common.StorageClassType;

/* loaded from: classes3.dex */
public class PutBucketStorageClassInput {
    private String bucket;
    private StorageClassType storageClass;

    public static final class PutBucketStorageClassInputBuilder {
        private String bucket;
        private StorageClassType storageClass;

        public PutBucketStorageClassInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutBucketStorageClassInput build() {
            PutBucketStorageClassInput putBucketStorageClassInput = new PutBucketStorageClassInput();
            putBucketStorageClassInput.setBucket(this.bucket);
            putBucketStorageClassInput.setStorageClass(this.storageClass);
            return putBucketStorageClassInput;
        }

        public PutBucketStorageClassInputBuilder storageClass(StorageClassType storageClassType) {
            this.storageClass = storageClassType;
            return this;
        }

        private PutBucketStorageClassInputBuilder() {
        }
    }

    public static PutBucketStorageClassInputBuilder builder() {
        return new PutBucketStorageClassInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public StorageClassType getStorageClass() {
        return this.storageClass;
    }

    public PutBucketStorageClassInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutBucketStorageClassInput setStorageClass(StorageClassType storageClassType) {
        this.storageClass = storageClassType;
        return this;
    }

    public String toString() {
        return "PutBucketStorageClassInput{bucket='" + this.bucket + "', storageClass=" + this.storageClass + '}';
    }
}
