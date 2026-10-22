package com.volcengine.tos.model.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import com.volcengine.tos.model.acl.Owner;
import java.util.Arrays;

@Deprecated
/* loaded from: classes3.dex */
public class ListUploadedPartsOutput {

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
    private String storageClass;

    @JsonProperty("UploadId")
    private String uploadID;

    @JsonProperty("Parts")
    private UploadedPart[] uploadedParts;

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

    public String getStorageClass() {
        return this.storageClass;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public UploadedPart[] getUploadedParts() {
        return this.uploadedParts;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public ListUploadedPartsOutput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public ListUploadedPartsOutput setKey(String str) {
        this.key = str;
        return this;
    }

    public ListUploadedPartsOutput setMaxParts(int i) {
        this.maxParts = i;
        return this;
    }

    public ListUploadedPartsOutput setNextPartNumberMarker(int i) {
        this.nextPartNumberMarker = i;
        return this;
    }

    public ListUploadedPartsOutput setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public ListUploadedPartsOutput setPartNumberMarker(int i) {
        this.partNumberMarker = i;
        return this;
    }

    public ListUploadedPartsOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public ListUploadedPartsOutput setStorageClass(String str) {
        this.storageClass = str;
        return this;
    }

    public ListUploadedPartsOutput setTruncated(boolean z10) {
        this.isTruncated = z10;
        return this;
    }

    public ListUploadedPartsOutput setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public ListUploadedPartsOutput setUploadedParts(UploadedPart[] uploadedPartArr) {
        this.uploadedParts = uploadedPartArr;
        return this;
    }

    public String toString() {
        return "ListUploadedPartsOutput{requestInfo=" + this.requestInfo + ", bucket='" + this.bucket + "', key='" + this.key + "', uploadID='" + this.uploadID + "', partNumberMarker=" + this.partNumberMarker + ", nextPartNumberMarker=" + this.nextPartNumberMarker + ", maxParts=" + this.maxParts + ", isTruncated=" + this.isTruncated + ", storageClass='" + this.storageClass + "', owner=" + this.owner + ", uploadedParts=" + Arrays.toString(this.uploadedParts) + '}';
    }
}
