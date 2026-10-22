package com.volcengine.tos.model.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.comm.common.StorageClassType;
import com.volcengine.tos.model.acl.Owner;
import java.util.Date;

/* loaded from: classes3.dex */
public class ListedUpload {

    @JsonProperty("Initiated")
    private Date initiated;

    @JsonProperty("Key")
    private String key;

    @JsonProperty("Owner")
    private Owner owner;

    @JsonProperty("StorageClass")
    private StorageClassType storageClass;

    @JsonProperty("UploadId")
    private String uploadID;

    public Date getInitiated() {
        return this.initiated;
    }

    public String getKey() {
        return this.key;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public StorageClassType getStorageClass() {
        return this.storageClass;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public ListedUpload setInitiated(Date date) {
        this.initiated = date;
        return this;
    }

    public ListedUpload setKey(String str) {
        this.key = str;
        return this;
    }

    public ListedUpload setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public ListedUpload setStorageClass(StorageClassType storageClassType) {
        this.storageClass = storageClassType;
        return this;
    }

    public ListedUpload setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public String toString() {
        return "ListedUpload{key='" + this.key + "', uploadID='" + this.uploadID + "', owner=" + this.owner + ", storageClass=" + this.storageClass + ", initiated=" + this.initiated + '}';
    }
}
