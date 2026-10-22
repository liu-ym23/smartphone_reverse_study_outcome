package com.volcengine.tos.model.object;

import androidx.appfunctions.metadata.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import com.volcengine.tos.model.acl.GrantV2;
import com.volcengine.tos.model.acl.Owner;
import java.util.List;

/* loaded from: classes3.dex */
public class GetObjectACLV2Output {

    @JsonProperty("BucketOwnerEntrusted")
    private boolean bucketOwnerEntrusted;

    @JsonProperty("Grants")
    private List<GrantV2> grants;

    @JsonProperty("Owner")
    private Owner owner;

    @JsonIgnore
    private RequestInfo requestInfo;

    @JsonIgnore
    private String versionID;

    public List<GrantV2> getGrants() {
        return this.grants;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public boolean isBucketOwnerEntrusted() {
        return this.bucketOwnerEntrusted;
    }

    public GetObjectACLV2Output setBucketOwnerEntrusted(boolean z10) {
        this.bucketOwnerEntrusted = z10;
        return this;
    }

    public GetObjectACLV2Output setGrants(List<GrantV2> list) {
        this.grants = list;
        return this;
    }

    public GetObjectACLV2Output setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public GetObjectACLV2Output setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public GetObjectACLV2Output setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetObjectACLV2Output{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", versionID='");
        sb.append(this.versionID);
        sb.append("', owner=");
        sb.append(this.owner);
        sb.append(", grants=");
        sb.append(this.grants);
        sb.append(", bucketOwnerEntrusted=");
        return a.r(sb, this.bucketOwnerEntrusted, '}');
    }
}
