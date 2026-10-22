package com.volcengine.tos.model.bucket;

import com.volcengine.tos.comm.common.StorageClassType;
import com.volcengine.tos.model.RequestInfo;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class HeadBucketV2Output implements Serializable {
    private String region;
    private RequestInfo requestInfo;
    private StorageClassType storageClass;

    public HeadBucketV2Output() {
    }

    public String getRegion() {
        return this.region;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public StorageClassType getStorageClass() {
        return this.storageClass;
    }

    public HeadBucketV2Output setRegion(String str) {
        this.region = str;
        return this;
    }

    public HeadBucketV2Output setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public HeadBucketV2Output setStorageClass(StorageClassType storageClassType) {
        this.storageClass = storageClassType;
        return this;
    }

    public String toString() {
        return "HeadBucketOutput{requestInfo=" + this.requestInfo + ", region='" + this.region + "', storageClass=" + this.storageClass + '}';
    }

    public HeadBucketV2Output(RequestInfo requestInfo, String str, StorageClassType storageClassType) {
        this.requestInfo = requestInfo;
        this.region = str;
        this.storageClass = storageClassType;
    }
}
