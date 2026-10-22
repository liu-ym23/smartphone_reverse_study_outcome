package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class Deleted {

    @JsonProperty("DeleteMarker")
    private boolean deleteMarker;

    @JsonProperty("DeleteMarkerVersionId")
    private String deleteMarkerVersionID;

    @JsonProperty("Key")
    private String key;

    @JsonProperty("VersionId")
    private String versionID;

    public String getDeleteMarkerVersionID() {
        return this.deleteMarkerVersionID;
    }

    public String getKey() {
        return this.key;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public boolean isDeleteMarker() {
        return this.deleteMarker;
    }

    public Deleted setDeleteMarker(boolean z10) {
        this.deleteMarker = z10;
        return this;
    }

    public Deleted setDeleteMarkerVersionID(String str) {
        this.deleteMarkerVersionID = str;
        return this;
    }

    public Deleted setKey(String str) {
        this.key = str;
        return this;
    }

    public Deleted setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Deleted{key='");
        sb.append(this.key);
        sb.append("', versionID='");
        sb.append(this.versionID);
        sb.append("', deleteMarker=");
        sb.append(this.deleteMarker);
        sb.append(", deleteMarkerVersionID='");
        return a.q(sb, this.deleteMarkerVersionID, "'}");
    }
}
