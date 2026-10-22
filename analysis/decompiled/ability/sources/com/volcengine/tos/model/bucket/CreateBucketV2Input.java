package com.volcengine.tos.model.bucket;

import com.volcengine.tos.comm.common.ACLType;
import com.volcengine.tos.comm.common.AzRedundancyType;
import com.volcengine.tos.comm.common.StorageClassType;

/* loaded from: classes3.dex */
public class CreateBucketV2Input {
    private ACLType acl;
    private AzRedundancyType azRedundancy;
    private String bucket;
    private String grantFullControl;
    private String grantRead;
    private String grantReadAcp;
    private String grantWrite;
    private String grantWriteAcp;
    private StorageClassType storageClass;

    public static final class CreateBucketInputV2Builder {
        private ACLType acl;
        private AzRedundancyType azRedundancy;
        private String bucket;
        private String grantFullControl;
        private String grantRead;
        private String grantReadAcp;
        private String grantWrite;
        private String grantWriteAcp;
        private StorageClassType storageClass;

        public CreateBucketInputV2Builder acl(ACLType aCLType) {
            this.acl = aCLType;
            return this;
        }

        public CreateBucketInputV2Builder azRedundancy(AzRedundancyType azRedundancyType) {
            this.azRedundancy = azRedundancyType;
            return this;
        }

        public CreateBucketInputV2Builder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public CreateBucketV2Input build() {
            CreateBucketV2Input createBucketV2Input = new CreateBucketV2Input();
            createBucketV2Input.bucket = this.bucket;
            createBucketV2Input.acl = this.acl;
            createBucketV2Input.grantWriteAcp = this.grantWriteAcp;
            createBucketV2Input.grantReadAcp = this.grantReadAcp;
            createBucketV2Input.grantRead = this.grantRead;
            createBucketV2Input.grantFullControl = this.grantFullControl;
            createBucketV2Input.grantWrite = this.grantWrite;
            createBucketV2Input.storageClass = this.storageClass;
            createBucketV2Input.azRedundancy = this.azRedundancy;
            return createBucketV2Input;
        }

        public CreateBucketInputV2Builder grantFullControl(String str) {
            this.grantFullControl = str;
            return this;
        }

        public CreateBucketInputV2Builder grantRead(String str) {
            this.grantRead = str;
            return this;
        }

        public CreateBucketInputV2Builder grantReadAcp(String str) {
            this.grantReadAcp = str;
            return this;
        }

        public CreateBucketInputV2Builder grantWrite(String str) {
            this.grantWrite = str;
            return this;
        }

        public CreateBucketInputV2Builder grantWriteAcp(String str) {
            this.grantWriteAcp = str;
            return this;
        }

        public CreateBucketInputV2Builder storageClass(StorageClassType storageClassType) {
            this.storageClass = storageClassType;
            return this;
        }

        private CreateBucketInputV2Builder() {
        }
    }

    public CreateBucketV2Input() {
    }

    public static CreateBucketInputV2Builder builder() {
        return new CreateBucketInputV2Builder();
    }

    public ACLType getAcl() {
        return this.acl;
    }

    public AzRedundancyType getAzRedundancy() {
        return this.azRedundancy;
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getGrantFullControl() {
        return this.grantFullControl;
    }

    public String getGrantRead() {
        return this.grantRead;
    }

    public String getGrantReadAcp() {
        return this.grantReadAcp;
    }

    public String getGrantWrite() {
        return this.grantWrite;
    }

    public String getGrantWriteAcp() {
        return this.grantWriteAcp;
    }

    public StorageClassType getStorageClass() {
        return this.storageClass;
    }

    public CreateBucketV2Input setAcl(ACLType aCLType) {
        this.acl = aCLType;
        return this;
    }

    public CreateBucketV2Input setAzRedundancy(AzRedundancyType azRedundancyType) {
        this.azRedundancy = azRedundancyType;
        return this;
    }

    public CreateBucketV2Input setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public CreateBucketV2Input setGrantFullControl(String str) {
        this.grantFullControl = str;
        return this;
    }

    public CreateBucketV2Input setGrantRead(String str) {
        this.grantRead = str;
        return this;
    }

    public CreateBucketV2Input setGrantReadAcp(String str) {
        this.grantReadAcp = str;
        return this;
    }

    public CreateBucketV2Input setGrantWrite(String str) {
        this.grantWrite = str;
        return this;
    }

    public CreateBucketV2Input setGrantWriteAcp(String str) {
        this.grantWriteAcp = str;
        return this;
    }

    public CreateBucketV2Input setStorageClass(StorageClassType storageClassType) {
        this.storageClass = storageClassType;
        return this;
    }

    public String toString() {
        return "CreateBucketV2Input{bucket='" + this.bucket + "', acl=" + this.acl + ", grantFullControl='" + this.grantFullControl + "', grantRead='" + this.grantRead + "', grantReadAcp='" + this.grantReadAcp + "', grantWrite='" + this.grantWrite + "', grantWriteAcp='" + this.grantWriteAcp + "', storageClass=" + this.storageClass + ", azRedundancy=" + this.azRedundancy + '}';
    }

    public CreateBucketV2Input(String str) {
        this.bucket = str;
    }
}
