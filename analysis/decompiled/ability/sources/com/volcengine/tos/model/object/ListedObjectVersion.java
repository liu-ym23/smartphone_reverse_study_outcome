package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.acl.Owner;

/* loaded from: classes3.dex */
public class ListedObjectVersion {

    @JsonProperty("ETag")
    private String etag;

    @JsonProperty("IsLatest")
    private boolean isLatest;

    @JsonProperty("Key")
    private String key;

    @JsonProperty("LastModified")
    private String lastModified;

    @JsonProperty("Owner")
    private Owner owner;

    @JsonProperty("Size")
    private long size;

    @JsonProperty("StorageClass")
    private String storageClass;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("VersionId")
    private String versionID;

    public String getEtag() {
        return this.etag;
    }

    public String getKey() {
        return this.key;
    }

    public String getLastModified() {
        return this.lastModified;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public long getSize() {
        return this.size;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public String getType() {
        return this.type;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public boolean isLatest() {
        return this.isLatest;
    }

    public ListedObjectVersion setEtag(String str) {
        this.etag = str;
        return this;
    }

    public ListedObjectVersion setKey(String str) {
        this.key = str;
        return this;
    }

    public ListedObjectVersion setLastModified(String str) {
        this.lastModified = str;
        return this;
    }

    public ListedObjectVersion setLatest(boolean z10) {
        this.isLatest = z10;
        return this;
    }

    public ListedObjectVersion setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public ListedObjectVersion setSize(long j5) {
        this.size = j5;
        return this;
    }

    public ListedObjectVersion setStorageClass(String str) {
        this.storageClass = str;
        return this;
    }

    public ListedObjectVersion setType(String str) {
        this.type = str;
        return this;
    }

    public ListedObjectVersion setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListedObjectVersion{etag='");
        sb.append(this.etag);
        sb.append("', isLatest=");
        sb.append(this.isLatest);
        sb.append(", key='");
        sb.append(this.key);
        sb.append("', lastModified='");
        sb.append(this.lastModified);
        sb.append("', owner=");
        sb.append(this.owner);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", storageClass='");
        sb.append(this.storageClass);
        sb.append("', type='");
        sb.append(this.type);
        sb.append("', versionID='");
        return a.q(sb, this.versionID, "'}");
    }
}
