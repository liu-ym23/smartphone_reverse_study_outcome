package com.volcengine.tos.model.acl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;

@Deprecated
/* loaded from: classes3.dex */
public class GetObjectAclOutput {

    @JsonProperty("Grants")
    private Grant[] grants;

    @JsonProperty("Owner")
    private Owner owner;

    @JsonIgnore
    private RequestInfo requestInfo;

    @JsonProperty("VersionId")
    private String versionId;

    public Grant[] getGrants() {
        return this.grants;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public GetObjectAclOutput setGrants(Grant[] grantArr) {
        this.grants = grantArr;
        return this;
    }

    public GetObjectAclOutput setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public GetObjectAclOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public GetObjectAclOutput setVersionId(String str) {
        this.versionId = str;
        return this;
    }
}
