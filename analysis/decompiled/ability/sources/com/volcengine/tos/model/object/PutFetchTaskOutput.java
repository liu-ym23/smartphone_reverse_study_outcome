package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class PutFetchTaskOutput {

    @JsonIgnore
    private RequestInfo requestInfo;

    @JsonProperty("TaskId")
    private String taskID;

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public String getTaskID() {
        return this.taskID;
    }

    public PutFetchTaskOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public PutFetchTaskOutput setTaskID(String str) {
        this.taskID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutFetchTaskOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", taskID='");
        return a.q(sb, this.taskID, "'}");
    }
}
