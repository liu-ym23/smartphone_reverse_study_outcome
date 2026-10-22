package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.Arrays;

@Deprecated
/* loaded from: classes3.dex */
public class ListBucketsOutput {

    @JsonProperty("Buckets")
    private ListedBucket[] buckets;

    @JsonProperty("Owner")
    private ListedOwner owner;

    @JsonIgnore
    private RequestInfo requestInfo;

    public ListedBucket[] getBuckets() {
        return this.buckets;
    }

    public ListedOwner getOwner() {
        return this.owner;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public ListBucketsOutput setBuckets(ListedBucket[] listedBucketArr) {
        this.buckets = listedBucketArr;
        return this;
    }

    public ListBucketsOutput setOwner(ListedOwner listedOwner) {
        this.owner = listedOwner;
        return this;
    }

    public ListBucketsOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        return "ListBucketsOutput{requestInfo=" + this.requestInfo + ", buckets=" + Arrays.toString(this.buckets) + ", owner=" + this.owner + '}';
    }
}
