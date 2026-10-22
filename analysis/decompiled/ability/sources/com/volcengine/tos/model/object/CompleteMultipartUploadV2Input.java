package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* loaded from: classes3.dex */
public class CompleteMultipartUploadV2Input {

    @JsonIgnore
    private String bucket;
    private String callback;
    private String callbackVar;

    @JsonIgnore
    private boolean completeAll;

    @JsonIgnore
    private String key;

    @JsonIgnore
    private String uploadID;

    @JsonProperty("Parts")
    private List<UploadedPartV2> uploadedParts;

    public static final class CompleteMultipartUploadV2InputBuilder {
        private String bucket;
        private String callback;
        private String callbackVar;
        private boolean completeAll;
        private String key;
        private String uploadID;
        private List<UploadedPartV2> uploadedParts;

        public CompleteMultipartUploadV2InputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public CompleteMultipartUploadV2Input build() {
            CompleteMultipartUploadV2Input completeMultipartUploadV2Input = new CompleteMultipartUploadV2Input();
            completeMultipartUploadV2Input.setBucket(this.bucket);
            completeMultipartUploadV2Input.setKey(this.key);
            completeMultipartUploadV2Input.setUploadID(this.uploadID);
            completeMultipartUploadV2Input.setUploadedParts(this.uploadedParts);
            completeMultipartUploadV2Input.setCompleteAll(this.completeAll);
            completeMultipartUploadV2Input.setCallback(this.callback);
            completeMultipartUploadV2Input.setCallbackVar(this.callbackVar);
            return completeMultipartUploadV2Input;
        }

        public CompleteMultipartUploadV2InputBuilder callback(String str) {
            this.callback = str;
            return this;
        }

        public CompleteMultipartUploadV2InputBuilder callbackVar(String str) {
            this.callbackVar = str;
            return this;
        }

        public CompleteMultipartUploadV2InputBuilder completeAll(boolean z10) {
            this.completeAll = z10;
            return this;
        }

        public CompleteMultipartUploadV2InputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public CompleteMultipartUploadV2InputBuilder uploadID(String str) {
            this.uploadID = str;
            return this;
        }

        public CompleteMultipartUploadV2InputBuilder uploadedParts(List<UploadedPartV2> list) {
            this.uploadedParts = list;
            return this;
        }

        private CompleteMultipartUploadV2InputBuilder() {
        }
    }

    public static CompleteMultipartUploadV2InputBuilder builder() {
        return new CompleteMultipartUploadV2InputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getCallback() {
        return this.callback;
    }

    public String getCallbackVar() {
        return this.callbackVar;
    }

    public String getKey() {
        return this.key;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public List<UploadedPartV2> getUploadedParts() {
        return this.uploadedParts;
    }

    public boolean isCompleteAll() {
        return this.completeAll;
    }

    public CompleteMultipartUploadV2Input setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public CompleteMultipartUploadV2Input setCallback(String str) {
        this.callback = str;
        return this;
    }

    public CompleteMultipartUploadV2Input setCallbackVar(String str) {
        this.callbackVar = str;
        return this;
    }

    public CompleteMultipartUploadV2Input setCompleteAll(boolean z10) {
        this.completeAll = z10;
        return this;
    }

    public CompleteMultipartUploadV2Input setKey(String str) {
        this.key = str;
        return this;
    }

    public CompleteMultipartUploadV2Input setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public CompleteMultipartUploadV2Input setUploadedParts(List<UploadedPartV2> list) {
        this.uploadedParts = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CompleteMultipartUploadV2Input{bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', uploadID='");
        sb.append(this.uploadID);
        sb.append("', completeAll=");
        sb.append(this.completeAll);
        sb.append(", uploadedParts=");
        sb.append(this.uploadedParts);
        sb.append(", callback='");
        sb.append(this.callback);
        sb.append("', callbackVar='");
        return a.q(sb, this.callbackVar, "'}");
    }
}
