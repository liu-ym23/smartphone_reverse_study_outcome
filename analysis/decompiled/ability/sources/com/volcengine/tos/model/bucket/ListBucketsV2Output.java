package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import com.volcengine.tos.model.acl.Owner;
import java.util.List;

/* loaded from: classes3.dex */
public class ListBucketsV2Output {

    @JsonProperty("Buckets")
    private List<ListedBucket> buckets;

    @JsonProperty("Owner")
    private Owner owner;

    @JsonIgnore
    private RequestInfo requestInfo;

    public List<ListedBucket> getBuckets() {
        return this.buckets;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public ListBucketsV2Output setBuckets(List<ListedBucket> list) {
        this.buckets = list;
        return this;
    }

    public ListBucketsV2Output setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public ListBucketsV2Output setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        return "ListBucketsV2Output{requestInfo=" + this.requestInfo + ", buckets=" + this.buckets + ", owner=" + this.owner + '}';
    }
}
