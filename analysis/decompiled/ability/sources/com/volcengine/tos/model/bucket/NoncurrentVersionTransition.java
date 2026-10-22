package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.comm.common.StorageClassType;

/* loaded from: classes3.dex */
public class NoncurrentVersionTransition {

    @JsonProperty("NoncurrentDays")
    private int noncurrentDays;

    @JsonProperty("StorageClass")
    private StorageClassType storageClass;

    public static final class NoncurrentVersionTransitionBuilder {
        private int noncurrentDays;
        private StorageClassType storageClass;

        public NoncurrentVersionTransition build() {
            NoncurrentVersionTransition noncurrentVersionTransition = new NoncurrentVersionTransition();
            noncurrentVersionTransition.setNoncurrentDays(this.noncurrentDays);
            noncurrentVersionTransition.setStorageClass(this.storageClass);
            return noncurrentVersionTransition;
        }

        public NoncurrentVersionTransitionBuilder noncurrentDays(int i) {
            this.noncurrentDays = i;
            return this;
        }

        public NoncurrentVersionTransitionBuilder storageClass(StorageClassType storageClassType) {
            this.storageClass = storageClassType;
            return this;
        }

        private NoncurrentVersionTransitionBuilder() {
        }
    }

    public static NoncurrentVersionTransitionBuilder builder() {
        return new NoncurrentVersionTransitionBuilder();
    }

    public int getNoncurrentDays() {
        return this.noncurrentDays;
    }

    public StorageClassType getStorageClass() {
        return this.storageClass;
    }

    public NoncurrentVersionTransition setNoncurrentDays(int i) {
        this.noncurrentDays = i;
        return this;
    }

    public NoncurrentVersionTransition setStorageClass(StorageClassType storageClassType) {
        this.storageClass = storageClassType;
        return this;
    }

    public String toString() {
        return "NoncurrentVersionTransition{noncurrentDays=" + this.noncurrentDays + ", storageClass=" + this.storageClass + '}';
    }
}
