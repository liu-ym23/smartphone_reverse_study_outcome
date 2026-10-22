package com.volcengine.tos.model.object;

import B7.a;
import a7.AbstractC0306b;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.acl.Owner;
import java.util.Date;

/* loaded from: classes3.dex */
public class ListedDeleteMarkerEntry {

    @JsonProperty("IsLatest")
    private boolean isLatest;

    @JsonProperty("Key")
    private String key;

    @JsonProperty("LastModified")
    private String lastModified;

    @JsonProperty("Owner")
    private Owner owner;

    @JsonProperty("VersionId")
    private String versionID;

    public String getKey() {
        return this.key;
    }

    public String getLastModified() {
        return this.lastModified;
    }

    public Date getLastModifiedInDate() {
        return AbstractC0306b.b(this.lastModified);
    }

    public Owner getOwner() {
        return this.owner;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public boolean isLatest() {
        return this.isLatest;
    }

    public ListedDeleteMarkerEntry setKey(String str) {
        this.key = str;
        return this;
    }

    public ListedDeleteMarkerEntry setLastModified(String str) {
        this.lastModified = str;
        return this;
    }

    public ListedDeleteMarkerEntry setLatest(boolean z10) {
        this.isLatest = z10;
        return this;
    }

    public ListedDeleteMarkerEntry setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public ListedDeleteMarkerEntry setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListedDeleteMarkerEntry{isLatest=");
        sb.append(this.isLatest);
        sb.append(", key='");
        sb.append(this.key);
        sb.append("', lastModified='");
        sb.append(this.lastModified);
        sb.append("', owner=");
        sb.append(this.owner);
        sb.append(", versionID='");
        return a.q(sb, this.versionID, "'}");
    }
}
