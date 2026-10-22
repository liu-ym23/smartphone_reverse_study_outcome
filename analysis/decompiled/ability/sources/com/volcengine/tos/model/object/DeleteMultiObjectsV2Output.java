package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class DeleteMultiObjectsV2Output {

    @JsonProperty("Deleted")
    private List<Deleted> deleteds;

    @JsonProperty("Error")
    private List<DeleteError> errors;

    @JsonIgnore
    private RequestInfo requestInfo;

    public DeleteMultiObjectsV2Output deleteds(List<Deleted> list) {
        this.deleteds = list;
        return this;
    }

    public DeleteMultiObjectsV2Output errors(List<DeleteError> list) {
        this.errors = list;
        return this;
    }

    public List<Deleted> getDeleteds() {
        return this.deleteds;
    }

    public List<DeleteError> getErrors() {
        return this.errors;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public DeleteMultiObjectsV2Output requestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeleteMultiObjectsV2Output{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", deleteds=");
        sb.append(this.deleteds);
        sb.append(", errors=");
        return a.r(sb, this.errors, '}');
    }
}
