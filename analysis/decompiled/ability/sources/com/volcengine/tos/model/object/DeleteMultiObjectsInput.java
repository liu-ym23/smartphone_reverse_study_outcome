package com.volcengine.tos.model.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

@Deprecated
/* loaded from: classes3.dex */
public class DeleteMultiObjectsInput {

    @JsonProperty("Objects")
    private ObjectTobeDeleted[] objectTobeDeleteds;

    @JsonProperty("Quiet")
    private boolean quiet;

    public DeleteMultiObjectsInput() {
    }

    public ObjectTobeDeleted[] getObjectTobeDeleteds() {
        return this.objectTobeDeleteds;
    }

    public boolean isQuiet() {
        return this.quiet;
    }

    public DeleteMultiObjectsInput setObjectTobeDeleteds(ObjectTobeDeleted[] objectTobeDeletedArr) {
        this.objectTobeDeleteds = objectTobeDeletedArr;
        return this;
    }

    public DeleteMultiObjectsInput setQuiet(boolean z10) {
        this.quiet = z10;
        return this;
    }

    public String toString() {
        return "DeleteMultiObjectsInput{quiet=" + this.quiet + ", objectTobeDeleteds=" + Arrays.toString(this.objectTobeDeleteds) + '}';
    }

    public DeleteMultiObjectsInput(ObjectTobeDeleted[] objectTobeDeletedArr, boolean z10) {
        this.objectTobeDeleteds = objectTobeDeletedArr;
        this.quiet = z10;
    }
}
