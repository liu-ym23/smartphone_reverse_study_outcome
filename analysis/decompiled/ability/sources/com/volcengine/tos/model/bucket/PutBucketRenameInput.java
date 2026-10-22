package com.volcengine.tos.model.bucket;

import androidx.appfunctions.metadata.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class PutBucketRenameInput {

    @JsonIgnore
    private String bucket;

    @JsonProperty("RenameEnable")
    private boolean renameEnable;

    public static final class PutBucketRenameInputBuilder {
        private String bucket;
        private boolean renameEnable;

        public PutBucketRenameInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutBucketRenameInput build() {
            PutBucketRenameInput putBucketRenameInput = new PutBucketRenameInput();
            putBucketRenameInput.setBucket(this.bucket);
            putBucketRenameInput.setRenameEnable(this.renameEnable);
            return putBucketRenameInput;
        }

        public PutBucketRenameInputBuilder renameEnable(boolean z10) {
            this.renameEnable = z10;
            return this;
        }

        private PutBucketRenameInputBuilder() {
        }
    }

    public static PutBucketRenameInputBuilder builder() {
        return new PutBucketRenameInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public boolean isRenameEnable() {
        return this.renameEnable;
    }

    public PutBucketRenameInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutBucketRenameInput setRenameEnable(boolean z10) {
        this.renameEnable = z10;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutBucketRenameInput{bucket='");
        sb.append(this.bucket);
        sb.append("', renameEnable=");
        return a.r(sb, this.renameEnable, '}');
    }
}
