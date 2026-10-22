package com.volcengine.tos.model.bucket;

import B7.a;
import com.volcengine.tos.model.RequestInfo;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class CreateBucketV2Output implements Serializable {
    private String location;
    private RequestInfo requestInfo;

    public CreateBucketV2Output(RequestInfo requestInfo, String str) {
        this.requestInfo = requestInfo;
        this.location = str;
    }

    public String getLocation() {
        return this.location;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public CreateBucketV2Output setLocation(String str) {
        this.location = str;
        return this;
    }

    public CreateBucketV2Output setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        return this.location == null ? "" : a.q(new StringBuilder("{ Location: "), this.location, " }");
    }
}
