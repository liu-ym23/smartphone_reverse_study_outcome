package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.comm.common.StorageClassInheritDirectiveType;
import com.volcengine.tos.comm.common.StorageClassType;

/* loaded from: classes3.dex */
public class Destination {

    @JsonProperty("Bucket")
    private String bucket;

    @JsonProperty("Location")
    private String location;

    @JsonProperty("StorageClass")
    private StorageClassType storageClass;

    @JsonProperty("StorageClassInheritDirective")
    private StorageClassInheritDirectiveType storageClassInheritDirectiveType;

    public static final class DestinationBuilder {
        private String bucket;
        private String location;
        private StorageClassType storageClass;
        private StorageClassInheritDirectiveType storageClassInheritDirectiveType;

        public DestinationBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public Destination build() {
            Destination destination = new Destination();
            destination.setBucket(this.bucket);
            destination.setLocation(this.location);
            destination.setStorageClass(this.storageClass);
            destination.setStorageClassInheritDirectiveType(this.storageClassInheritDirectiveType);
            return destination;
        }

        public DestinationBuilder location(String str) {
            this.location = str;
            return this;
        }

        public DestinationBuilder storageClass(StorageClassType storageClassType) {
            this.storageClass = storageClassType;
            return this;
        }

        public DestinationBuilder storageClassInheritDirectiveType(StorageClassInheritDirectiveType storageClassInheritDirectiveType) {
            this.storageClassInheritDirectiveType = storageClassInheritDirectiveType;
            return this;
        }

        private DestinationBuilder() {
        }
    }

    public static DestinationBuilder builder() {
        return new DestinationBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getLocation() {
        return this.location;
    }

    public StorageClassType getStorageClass() {
        return this.storageClass;
    }

    public StorageClassInheritDirectiveType getStorageClassInheritDirectiveType() {
        return this.storageClassInheritDirectiveType;
    }

    public Destination setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public Destination setLocation(String str) {
        this.location = str;
        return this;
    }

    public Destination setStorageClass(StorageClassType storageClassType) {
        this.storageClass = storageClassType;
        return this;
    }

    public Destination setStorageClassInheritDirectiveType(StorageClassInheritDirectiveType storageClassInheritDirectiveType) {
        this.storageClassInheritDirectiveType = storageClassInheritDirectiveType;
        return this;
    }

    public String toString() {
        return "Destination{bucket='" + this.bucket + "', location='" + this.location + "', storageClass=" + this.storageClass + ", storageClassInheritDirectiveType=" + this.storageClassInheritDirectiveType + '}';
    }
}
