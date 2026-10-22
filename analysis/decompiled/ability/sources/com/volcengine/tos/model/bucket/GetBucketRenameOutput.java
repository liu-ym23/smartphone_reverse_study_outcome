package com.volcengine.tos.model.bucket;

import androidx.appfunctions.metadata.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class GetBucketRenameOutput {

    @JsonProperty("RenameEnable")
    private boolean renameEnable;

    @JsonIgnore
    private RequestInfo requestInfo;

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public boolean isRenameEnable() {
        return this.renameEnable;
    }

    public GetBucketRenameOutput setRenameEnable(boolean z10) {
        this.renameEnable = z10;
        return this;
    }

    public GetBucketRenameOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetBucketRenameOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", renameEnable=");
        return a.r(sb, this.renameEnable, '}');
    }
}
