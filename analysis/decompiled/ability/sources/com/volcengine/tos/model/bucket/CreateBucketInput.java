package com.volcengine.tos.model.bucket;

import B7.a;

@Deprecated
/* loaded from: classes3.dex */
public class CreateBucketInput {
    private String acl;
    private String bucket;
    private String grantFullControl;
    private String grantRead;
    private String grantReadAcp;
    private String grantWrite;
    private String grantWriteAcp;
    private String storageClass;

    public CreateBucketInput(String str) {
        this.bucket = str;
    }

    public String getAcl() {
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

    public String getStorageClass() {
        return this.storageClass;
    }

    public CreateBucketInput setAcl(String str) {
        this.acl = str;
        return this;
    }

    public CreateBucketInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public CreateBucketInput setGrantFullControl(String str) {
        this.grantFullControl = str;
        return this;
    }

    public CreateBucketInput setGrantRead(String str) {
        this.grantRead = str;
        return this;
    }

    public CreateBucketInput setGrantReadAcp(String str) {
        this.grantReadAcp = str;
        return this;
    }

    public CreateBucketInput setGrantWrite(String str) {
        this.grantWrite = str;
        return this;
    }

    public CreateBucketInput setGrantWriteAcp(String str) {
        this.grantWriteAcp = str;
        return this;
    }

    public CreateBucketInput setStorageClass(String str) {
        this.storageClass = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreateBucketInput{bucket='");
        sb.append(this.bucket);
        sb.append("', acl='");
        sb.append(this.acl);
        sb.append("', grantFullControl='");
        sb.append(this.grantFullControl);
        sb.append("', grantRead='");
        sb.append(this.grantRead);
        sb.append("', grantReadAcp='");
        sb.append(this.grantReadAcp);
        sb.append("', grantWrite='");
        sb.append(this.grantWrite);
        sb.append("', grantWriteAcp='");
        sb.append(this.grantWriteAcp);
        sb.append("', storageClass='");
        return a.q(sb, this.storageClass, "'}");
    }

    public CreateBucketInput(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.bucket = str;
        this.acl = str2;
        this.grantFullControl = str3;
        this.grantRead = str4;
        this.grantReadAcp = str5;
        this.grantWrite = str6;
        this.grantWriteAcp = str7;
        this.storageClass = str8;
    }
}
