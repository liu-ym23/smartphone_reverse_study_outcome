package com.volcengine.tos.model.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.Arrays;

@Deprecated
/* loaded from: classes3.dex */
public class DeleteMultiObjectsOutput {

    @JsonProperty("Deleted")
    private Deleted[] deleteds;

    @JsonProperty("Error")
    private DeleteError[] errors;

    @JsonIgnore
    private RequestInfo requestInfo;

    public Deleted[] getDeleteds() {
        return this.deleteds;
    }

    public DeleteError[] getErrors() {
        return this.errors;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public DeleteMultiObjectsOutput setDeleteds(Deleted[] deletedArr) {
        this.deleteds = deletedArr;
        return this;
    }

    public DeleteMultiObjectsOutput setErrors(DeleteError[] deleteErrorArr) {
        this.errors = deleteErrorArr;
        return this;
    }

    public DeleteMultiObjectsOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        return "DeleteMultiObjectsOutput{requestInfo=" + this.requestInfo + ", deleteds=" + Arrays.toString(this.deleteds) + ", errors=" + Arrays.toString(this.errors) + '}';
    }
}
