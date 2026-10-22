package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.comm.common.ACLType;
import com.volcengine.tos.model.acl.GrantV2;
import com.volcengine.tos.model.acl.Owner;
import java.util.List;

/* loaded from: classes3.dex */
public class PutBucketACLInput {

    @JsonIgnore
    private ACLType acl;

    @JsonIgnore
    private String bucket;

    @JsonIgnore
    private String grantFullControl;

    @JsonIgnore
    private String grantRead;

    @JsonIgnore
    private String grantReadAcp;

    @JsonIgnore
    private String grantWrite;

    @JsonIgnore
    private String grantWriteAcp;

    @JsonProperty("Grants")
    private List<GrantV2> grants;

    @JsonProperty("Owner")
    private Owner owner;

    public static final class PutBucketACLInputBuilder {
        private ACLType acl;
        private String bucket;
        private String grantFullControl;
        private String grantRead;
        private String grantReadAcp;
        private String grantWrite;
        private String grantWriteAcp;
        private List<GrantV2> grants;
        private Owner owner;

        public PutBucketACLInputBuilder acl(ACLType aCLType) {
            this.acl = aCLType;
            return this;
        }

        public PutBucketACLInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutBucketACLInput build() {
            PutBucketACLInput putBucketACLInput = new PutBucketACLInput();
            putBucketACLInput.setBucket(this.bucket);
            putBucketACLInput.setAcl(this.acl);
            putBucketACLInput.setGrantFullControl(this.grantFullControl);
            putBucketACLInput.setGrantRead(this.grantRead);
            putBucketACLInput.setGrantReadAcp(this.grantReadAcp);
            putBucketACLInput.setGrantWrite(this.grantWrite);
            putBucketACLInput.setGrantWriteAcp(this.grantWriteAcp);
            putBucketACLInput.setOwner(this.owner);
            putBucketACLInput.setGrants(this.grants);
            return putBucketACLInput;
        }

        public PutBucketACLInputBuilder grantFullControl(String str) {
            this.grantFullControl = str;
            return this;
        }

        public PutBucketACLInputBuilder grantRead(String str) {
            this.grantRead = str;
            return this;
        }

        public PutBucketACLInputBuilder grantReadAcp(String str) {
            this.grantReadAcp = str;
            return this;
        }

        public PutBucketACLInputBuilder grantWrite(String str) {
            this.grantWrite = str;
            return this;
        }

        public PutBucketACLInputBuilder grantWriteAcp(String str) {
            this.grantWriteAcp = str;
            return this;
        }

        public PutBucketACLInputBuilder grants(List<GrantV2> list) {
            this.grants = list;
            return this;
        }

        public PutBucketACLInputBuilder owner(Owner owner) {
            this.owner = owner;
            return this;
        }

        private PutBucketACLInputBuilder() {
        }
    }

    public static PutBucketACLInputBuilder builder() {
        return new PutBucketACLInputBuilder();
    }

    public ACLType getAcl() {
        return this.acl;
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

    public List<GrantV2> getGrants() {
        return this.grants;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public PutBucketACLInput setAcl(ACLType aCLType) {
        this.acl = aCLType;
        return this;
    }

    public PutBucketACLInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutBucketACLInput setGrantFullControl(String str) {
        this.grantFullControl = str;
        return this;
    }

    public PutBucketACLInput setGrantRead(String str) {
        this.grantRead = str;
        return this;
    }

    public PutBucketACLInput setGrantReadAcp(String str) {
        this.grantReadAcp = str;
        return this;
    }

    public PutBucketACLInput setGrantWrite(String str) {
        this.grantWrite = str;
        return this;
    }

    public PutBucketACLInput setGrantWriteAcp(String str) {
        this.grantWriteAcp = str;
        return this;
    }

    public PutBucketACLInput setGrants(List<GrantV2> list) {
        this.grants = list;
        return this;
    }

    public PutBucketACLInput setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutBucketACLInput{bucket='");
        sb.append(this.bucket);
        sb.append("', acl=");
        sb.append(this.acl);
        sb.append(", grantFullControl='");
        sb.append(this.grantFullControl);
        sb.append("', grantRead='");
        sb.append(this.grantRead);
        sb.append("', grantReadAcp='");
        sb.append(this.grantReadAcp);
        sb.append("', grantWrite='");
        sb.append(this.grantWrite);
        sb.append("', grantWriteAcp='");
        sb.append(this.grantWriteAcp);
        sb.append("', owner=");
        sb.append(this.owner);
        sb.append(", grants=");
        return a.r(sb, this.grants, '}');
    }
}
