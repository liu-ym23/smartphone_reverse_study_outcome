package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.acl.Owner;

@Deprecated
/* loaded from: classes3.dex */
public class ListedObject {

    @JsonProperty("ETag")
    private String etag;

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

    public ListedObject setEtag(String str) {
        this.etag = str;
        return this;
    }

    public ListedObject setKey(String str) {
        this.key = str;
        return this;
    }

    public ListedObject setLastModified(String str) {
        this.lastModified = str;
        return this;
    }

    public ListedObject setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public ListedObject setSize(long j5) {
        this.size = j5;
        return this;
    }

    public ListedObject setStorageClass(String str) {
        this.storageClass = str;
        return this;
    }

    public ListedObject setType(String str) {
        this.type = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListedObject{key='");
        sb.append(this.key);
        sb.append("', lastModified='");
        sb.append(this.lastModified);
        sb.append("', etag='");
        sb.append(this.etag);
        sb.append("', size=");
        sb.append(this.size);
        sb.append(", owner=");
        sb.append(this.owner);
        sb.append(", storageClass='");
        sb.append(this.storageClass);
        sb.append("', type='");
        return a.q(sb, this.type, "'}");
    }
}
