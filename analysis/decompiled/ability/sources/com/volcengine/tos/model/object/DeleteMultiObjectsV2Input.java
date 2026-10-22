package com.volcengine.tos.model.object;

import androidx.appfunctions.metadata.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class DeleteMultiObjectsV2Input {

    @JsonIgnore
    private String bucket;

    @JsonProperty("Objects")
    private List<ObjectTobeDeleted> objects;

    @JsonProperty("Quiet")
    private boolean quiet;

    public static final class DeleteMultiObjectsInputBuilder {
        private String bucket;
        private List<ObjectTobeDeleted> objects;
        private boolean quiet;

        public DeleteMultiObjectsInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public DeleteMultiObjectsV2Input build() {
            DeleteMultiObjectsV2Input deleteMultiObjectsV2Input = new DeleteMultiObjectsV2Input();
            deleteMultiObjectsV2Input.quiet = this.quiet;
            deleteMultiObjectsV2Input.objects = this.objects;
            deleteMultiObjectsV2Input.bucket = this.bucket;
            return deleteMultiObjectsV2Input;
        }

        public DeleteMultiObjectsInputBuilder objects(List<ObjectTobeDeleted> list) {
            this.objects = list;
            return this;
        }

        public DeleteMultiObjectsInputBuilder quiet(boolean z10) {
            this.quiet = z10;
            return this;
        }

        private DeleteMultiObjectsInputBuilder() {
        }
    }

    public static DeleteMultiObjectsInputBuilder builder() {
        return new DeleteMultiObjectsInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public List<ObjectTobeDeleted> getObjects() {
        return this.objects;
    }

    public boolean isQuiet() {
        return this.quiet;
    }

    public DeleteMultiObjectsV2Input setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public DeleteMultiObjectsV2Input setObjects(List<ObjectTobeDeleted> list) {
        this.objects = list;
        return this;
    }

    public DeleteMultiObjectsV2Input setQuiet(boolean z10) {
        this.quiet = z10;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeleteMultiObjectsInput{bucket='");
        sb.append(this.bucket);
        sb.append("', objects=");
        sb.append(Arrays.toString(this.objects.toArray()));
        sb.append(", quiet=");
        return a.r(sb, this.quiet, '}');
    }
}
