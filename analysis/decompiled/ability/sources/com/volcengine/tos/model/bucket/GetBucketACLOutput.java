package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import com.volcengine.tos.model.acl.GrantV2;
import com.volcengine.tos.model.acl.Owner;
import java.util.List;

/* loaded from: classes3.dex */
public class GetBucketACLOutput {

    @JsonProperty("Grants")
    private List<GrantV2> grants;

    @JsonProperty("Owner")
    private Owner owner;

    @JsonIgnore
    private RequestInfo requestInfo;

    public List<GrantV2> getGrants() {
        return this.grants;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public GetBucketACLOutput setGrants(List<GrantV2> list) {
        this.grants = list;
        return this;
    }

    public GetBucketACLOutput setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public GetBucketACLOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetBucketACLOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", owner=");
        sb.append(this.owner);
        sb.append(", grants=");
        return a.r(sb, this.grants, '}');
    }
}
