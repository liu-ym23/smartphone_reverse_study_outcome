package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.comm.common.StorageClassType;
import com.volcengine.tos.model.RequestInfo;
import com.volcengine.tos.model.acl.Owner;
import java.util.List;

/* loaded from: classes3.dex */
public class ListPartsOutput {

    @JsonProperty("Bucket")
    private String bucket;

    @JsonProperty("IsTruncated")
    private boolean isTruncated;

    @JsonProperty("Key")
    private String key;

    @JsonProperty("MaxParts")
    private int maxParts;

    @JsonProperty("NextPartNumberMarker")
    private int nextPartNumberMarker;

    @JsonProperty("Owner")
    private Owner owner;

    @JsonProperty("PartNumberMarker")
    private int partNumberMarker;

    @JsonIgnore
    private RequestInfo requestInfo;

    @JsonProperty("StorageClass")
    private StorageClassType storageClass;

    @JsonProperty("UploadId")
    private String uploadID;

    @JsonProperty("Parts")
    private List<UploadedPartV2> uploadedParts;

    public String getBucket() {
        return this.bucket;
    }

    public String getKey() {
        return this.key;
    }

    public int getMaxParts() {
        return this.maxParts;
    }

    public int getNextPartNumberMarker() {
        return this.nextPartNumberMarker;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public int getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public StorageClassType getStorageClass() {
        return this.storageClass;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public List<UploadedPartV2> getUploadedParts() {
        return this.uploadedParts;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public ListPartsOutput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public ListPartsOutput setKey(String str) {
        this.key = str;
        return this;
    }

    public ListPartsOutput setMaxParts(int i) {
        this.maxParts = i;
        return this;
    }

    public ListPartsOutput setNextPartNumberMarker(int i) {
        this.nextPartNumberMarker = i;
        return this;
    }

    public ListPartsOutput setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public ListPartsOutput setPartNumberMarker(int i) {
        this.partNumberMarker = i;
        return this;
    }

    public ListPartsOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public ListPartsOutput setStorageClass(StorageClassType storageClassType) {
        this.storageClass = storageClassType;
        return this;
    }

    public ListPartsOutput setTruncated(boolean z10) {
        this.isTruncated = z10;
        return this;
    }

    public ListPartsOutput setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public ListPartsOutput setUploadedParts(List<UploadedPartV2> list) {
        this.uploadedParts = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListPartsOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', uploadID='");
        sb.append(this.uploadID);
        sb.append("', partNumberMarker=");
        sb.append(this.partNumberMarker);
        sb.append(", maxParts=");
        sb.append(this.maxParts);
        sb.append(", isTruncated=");
        sb.append(this.isTruncated);
        sb.append(", storageClass='");
        sb.append(this.storageClass);
        sb.append("', nextPartNumberMarker=");
        sb.append(this.nextPartNumberMarker);
        sb.append(", owner=");
        sb.append(this.owner);
        sb.append(", uploadedParts=");
        return a.r(sb, this.uploadedParts, '}');
    }
}
