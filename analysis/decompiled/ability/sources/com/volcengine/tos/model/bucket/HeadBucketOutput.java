package com.volcengine.tos.model.bucket;

import B7.a;
import com.volcengine.tos.model.RequestInfo;
import java.io.Serializable;

@Deprecated
/* loaded from: classes3.dex */
public class HeadBucketOutput implements Serializable {
    private String region;
    private RequestInfo requestInfo;
    private String storageClass;

    public HeadBucketOutput(RequestInfo requestInfo, String str, String str2) {
        this.requestInfo = requestInfo;
        this.region = str;
        this.storageClass = str2;
    }

    public String getRegion() {
        return this.region;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HeadBucketOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", region='");
        sb.append(this.region);
        sb.append("', storageClass=");
        return a.g('}', this.storageClass, sb);
    }
}
