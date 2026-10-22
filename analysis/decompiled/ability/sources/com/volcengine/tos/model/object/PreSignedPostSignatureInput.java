package com.volcengine.tos.model.object;

import java.util.List;

/* loaded from: classes3.dex */
public class PreSignedPostSignatureInput {
    private String bucket;
    private List<PostSignatureCondition> conditions;
    private ContentLengthRange contentLengthRange;
    private long expires;
    private String key;

    public static final class PreSignedPostSignatureInputBuilder {
        private String bucket;
        private List<PostSignatureCondition> conditions;
        private ContentLengthRange contentLengthRange;
        private long expires;
        private String key;

        public PreSignedPostSignatureInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PreSignedPostSignatureInput build() {
            PreSignedPostSignatureInput preSignedPostSignatureInput = new PreSignedPostSignatureInput();
            preSignedPostSignatureInput.setBucket(this.bucket);
            preSignedPostSignatureInput.setKey(this.key);
            preSignedPostSignatureInput.setExpires(this.expires);
            preSignedPostSignatureInput.setConditions(this.conditions);
            preSignedPostSignatureInput.setContentLengthRange(this.contentLengthRange);
            return preSignedPostSignatureInput;
        }

        public PreSignedPostSignatureInputBuilder conditions(List<PostSignatureCondition> list) {
            this.conditions = list;
            return this;
        }

        public PreSignedPostSignatureInputBuilder contentLengthRange(ContentLengthRange contentLengthRange) {
            this.contentLengthRange = contentLengthRange;
            return this;
        }

        public PreSignedPostSignatureInputBuilder expires(long j5) {
            this.expires = j5;
            return this;
        }

        public PreSignedPostSignatureInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        private PreSignedPostSignatureInputBuilder() {
        }
    }

    public static PreSignedPostSignatureInputBuilder builder() {
        return new PreSignedPostSignatureInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public List<PostSignatureCondition> getConditions() {
        return this.conditions;
    }

    public ContentLengthRange getContentLengthRange() {
        return this.contentLengthRange;
    }

    public long getExpires() {
        return this.expires;
    }

    public String getKey() {
        return this.key;
    }

    public PreSignedPostSignatureInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PreSignedPostSignatureInput setConditions(List<PostSignatureCondition> list) {
        this.conditions = list;
        return this;
    }

    public PreSignedPostSignatureInput setContentLengthRange(ContentLengthRange contentLengthRange) {
        this.contentLengthRange = contentLengthRange;
        return this;
    }

    public PreSignedPostSignatureInput setExpires(long j5) {
        this.expires = j5;
        return this;
    }

    public PreSignedPostSignatureInput setKey(String str) {
        this.key = str;
        return this;
    }

    public String toString() {
        return "PreSignedPostSignatureInput{bucket='" + this.bucket + "', key='" + this.key + "', expires=" + this.expires + ", conditions=" + this.conditions + ", contentLengthRange=" + this.contentLengthRange + '}';
    }
}
