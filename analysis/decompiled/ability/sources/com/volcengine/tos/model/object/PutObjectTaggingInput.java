package com.volcengine.tos.model.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class PutObjectTaggingInput {

    @JsonIgnore
    private String bucket;

    @JsonIgnore
    private String key;

    @JsonProperty("TagSet")
    private TagSet tagSet;

    @JsonIgnore
    private String versionID;

    public static final class PutObjectTaggingInputBuilder {
        private String bucket;
        private String key;
        private TagSet tagSet;
        private String versionID;

        public PutObjectTaggingInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutObjectTaggingInput build() {
            PutObjectTaggingInput putObjectTaggingInput = new PutObjectTaggingInput();
            putObjectTaggingInput.setBucket(this.bucket);
            putObjectTaggingInput.setKey(this.key);
            putObjectTaggingInput.setVersionID(this.versionID);
            putObjectTaggingInput.setTagSet(this.tagSet);
            return putObjectTaggingInput;
        }

        public PutObjectTaggingInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public PutObjectTaggingInputBuilder tagSet(TagSet tagSet) {
            this.tagSet = tagSet;
            return this;
        }

        public PutObjectTaggingInputBuilder versionID(String str) {
            this.versionID = str;
            return this;
        }

        private PutObjectTaggingInputBuilder() {
        }
    }

    public static PutObjectTaggingInputBuilder builder() {
        return new PutObjectTaggingInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getKey() {
        return this.key;
    }

    public TagSet getTagSet() {
        return this.tagSet;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public PutObjectTaggingInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutObjectTaggingInput setKey(String str) {
        this.key = str;
        return this;
    }

    public PutObjectTaggingInput setTagSet(TagSet tagSet) {
        this.tagSet = tagSet;
        return this;
    }

    public PutObjectTaggingInput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        return "PutObjectTaggingInput{bucket='" + this.bucket + "', key='" + this.key + "', versionID='" + this.versionID + "', tagSet=" + this.tagSet + '}';
    }
}
