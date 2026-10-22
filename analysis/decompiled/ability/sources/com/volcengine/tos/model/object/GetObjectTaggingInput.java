package com.volcengine.tos.model.object;

import B7.a;

/* loaded from: classes3.dex */
public class GetObjectTaggingInput {
    private String bucket;
    private String key;
    private String versionID;

    public static final class GetObjectTaggingInputBuilder {
        private String bucket;
        private String key;
        private String versionID;

        public GetObjectTaggingInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public GetObjectTaggingInput build() {
            GetObjectTaggingInput getObjectTaggingInput = new GetObjectTaggingInput();
            getObjectTaggingInput.setBucket(this.bucket);
            getObjectTaggingInput.setKey(this.key);
            getObjectTaggingInput.setVersionID(this.versionID);
            return getObjectTaggingInput;
        }

        public GetObjectTaggingInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public GetObjectTaggingInputBuilder versionID(String str) {
            this.versionID = str;
            return this;
        }

        private GetObjectTaggingInputBuilder() {
        }
    }

    public static GetObjectTaggingInputBuilder builder() {
        return new GetObjectTaggingInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getKey() {
        return this.key;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public GetObjectTaggingInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public GetObjectTaggingInput setKey(String str) {
        this.key = str;
        return this;
    }

    public GetObjectTaggingInput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetObjectTaggingInput{bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', versionID='");
        return a.q(sb, this.versionID, "'}");
    }
}
