package com.volcengine.tos.model.acl;

import com.fasterxml.jackson.annotation.JsonProperty;

@Deprecated
/* loaded from: classes3.dex */
public class ObjectAclGrant {

    @JsonProperty("ACL")
    private String acl;

    @JsonProperty("GrantFullControl")
    private String grantFullControl;

    @JsonProperty("GrantRead")
    private String grantRead;

    @JsonProperty("GrantReadAcp")
    private String grantReadAcp;

    @JsonProperty("GrantWrite")
    private String grantWrite;

    @JsonProperty("GrantWriteAcp")
    private String grantWriteAcp;

    public String getAcl() {
        return this.acl;
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

    public ObjectAclGrant setAcl(String str) {
        this.acl = str;
        return this;
    }

    public ObjectAclGrant setAclAuthRead() {
        this.acl = ACLConst.ACL_AUTH_READ;
        return this;
    }

    public ObjectAclGrant setAclBucketOwnerFullControl() {
        this.acl = ACLConst.ACL_BUCKET_OWNER_FULL_CONTROL;
        return this;
    }

    public ObjectAclGrant setAclBucketOwnerRead() {
        this.acl = ACLConst.ACL_BUCKET_OWNER_READ;
        return this;
    }

    public ObjectAclGrant setAclPrivate() {
        this.acl = ACLConst.ACL_PRIVATE;
        return this;
    }

    public ObjectAclGrant setAclPublicRead() {
        this.acl = ACLConst.ACL_PUBLIC_READ;
        return this;
    }

    public ObjectAclGrant setAclPublicReadWrite() {
        this.acl = ACLConst.ACL_PUBLIC_READ_WRITE;
        return this;
    }

    public ObjectAclGrant setGrantFullControl() {
        this.grantFullControl = ACLConst.PERMISSION_TYPE_FULL_CONTROL;
        return this;
    }

    public ObjectAclGrant setGrantRead() {
        this.grantRead = ACLConst.PERMISSION_TYPE_READ;
        return this;
    }

    public ObjectAclGrant setGrantReadAcp() {
        this.grantReadAcp = ACLConst.PERMISSION_TYPE_READ_ACP;
        return this;
    }

    public ObjectAclGrant setGrantWrite() {
        this.grantWrite = ACLConst.PERMISSION_TYPE_WRITE;
        return this;
    }

    public ObjectAclGrant setGrantWriteAcp() {
        this.grantWriteAcp = ACLConst.PERMISSION_TYPE_WRITE_ACP;
        return this;
    }

    @Deprecated
    public ObjectAclGrant setGrantFullControl(String str) {
        this.grantFullControl = str;
        return this;
    }

    @Deprecated
    public ObjectAclGrant setGrantRead(String str) {
        this.grantRead = str;
        return this;
    }

    @Deprecated
    public ObjectAclGrant setGrantReadAcp(String str) {
        this.grantReadAcp = str;
        return this;
    }

    @Deprecated
    public ObjectAclGrant setGrantWrite(String str) {
        this.grantWrite = str;
        return this;
    }

    @Deprecated
    public ObjectAclGrant setGrantWriteAcp(String str) {
        this.grantWriteAcp = str;
        return this;
    }
}
