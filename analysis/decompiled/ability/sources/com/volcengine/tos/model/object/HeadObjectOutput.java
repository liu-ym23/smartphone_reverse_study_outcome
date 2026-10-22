package com.volcengine.tos.model.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.volcengine.tos.internal.TosResponse;
import com.volcengine.tos.model.RequestInfo;

@Deprecated
/* loaded from: classes3.dex */
public class HeadObjectOutput {
    private String contentRange;
    private ObjectMeta objectMeta;

    @JsonIgnore
    private RequestInfo requestInfo;

    public String getContentRange() {
        return this.contentRange;
    }

    public ObjectMeta getObjectMeta() {
        return this.objectMeta;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public HeadObjectOutput setContentRange(String str) {
        this.contentRange = str;
        return this;
    }

    public HeadObjectOutput setObjectMeta(TosResponse tosResponse) {
        this.objectMeta = new ObjectMeta().fromResponse(tosResponse);
        return this;
    }

    public HeadObjectOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        return "HeadObjectOutput{requestInfo=" + this.requestInfo + ", contentRange='" + this.contentRange + "', objectMeta=" + this.objectMeta + '}';
    }

    public HeadObjectOutput setObjectMeta(ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
        return this;
    }
}
