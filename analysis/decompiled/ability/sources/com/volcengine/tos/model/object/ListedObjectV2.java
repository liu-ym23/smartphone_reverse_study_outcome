package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.acl.Owner;
import java.util.Date;

/* loaded from: classes3.dex */
public class ListedObjectV2 {

    @JsonProperty("ETag")
    private String etag;

    @JsonProperty("HashCrc64ecma")
    private String hashCrc64ecma;

    @JsonProperty("Key")
    private String key;

    @JsonProperty("LastModified")
    private Date lastModified;

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

    public String getHashCrc64ecma() {
        return this.hashCrc64ecma;
    }

    public String getKey() {
        return this.key;
    }

    public Date getLastModified() {
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

    public ListedObjectV2 setEtag(String str) {
        this.etag = str;
        return this;
    }

    public ListedObjectV2 setHashCrc64ecma(String str) {
        this.hashCrc64ecma = str;
        return this;
    }

    public ListedObjectV2 setKey(String str) {
        this.key = str;
        return this;
    }

    public ListedObjectV2 setLastModified(Date date) {
        this.lastModified = date;
        return this;
    }

    public ListedObjectV2 setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public ListedObjectV2 setSize(long j5) {
        this.size = j5;
        return this;
    }

    public ListedObjectV2 setStorageClass(String str) {
        this.storageClass = str;
        return this;
    }

    public ListedObjectV2 setType(String str) {
        this.type = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListedObjectV2{key='");
        sb.append(this.key);
        sb.append("', lastModified=");
        sb.append(this.lastModified);
        sb.append(", etag='");
        sb.append(this.etag);
        sb.append("', size=");
        sb.append(this.size);
        sb.append(", owner=");
        sb.append(this.owner);
        sb.append(", storageClass=");
        sb.append(this.storageClass);
        sb.append(", type='");
        sb.append(this.type);
        sb.append("', hashCrc64ecma='");
        return a.q(sb, this.hashCrc64ecma, "'}");
    }
}
