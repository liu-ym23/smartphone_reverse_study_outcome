package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.acl.Owner;

@Deprecated
/* loaded from: classes3.dex */
public class UploadInfo {

    @JsonProperty("Initiated")
    private String initiated;

    @JsonProperty("Key")
    private String key;

    @JsonProperty("Owner")
    private Owner owner;

    @JsonProperty("StorageClass")
    private String storageClass;

    @JsonProperty("UploadId")
    private String uploadID;

    public String getInitiated() {
        return this.initiated;
    }

    public String getKey() {
        return this.key;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public UploadInfo setInitiated(String str) {
        this.initiated = str;
        return this;
    }

    public UploadInfo setKey(String str) {
        this.key = str;
        return this;
    }

    public UploadInfo setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public UploadInfo setStorageClass(String str) {
        this.storageClass = str;
        return this;
    }

    public UploadInfo setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadInfo{key='");
        sb.append(this.key);
        sb.append("', uploadID='");
        sb.append(this.uploadID);
        sb.append("', owner=");
        sb.append(this.owner);
        sb.append(", storageClass='");
        sb.append(this.storageClass);
        sb.append("', initiated='");
        return a.q(sb, this.initiated, "'}");
    }
}
