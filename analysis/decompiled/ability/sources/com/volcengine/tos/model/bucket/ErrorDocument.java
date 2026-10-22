package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class ErrorDocument {

    @JsonProperty("Key")
    private String key;

    public static final class ErrorDocumentBuilder {
        private String key;

        public ErrorDocument build() {
            ErrorDocument errorDocument = new ErrorDocument();
            errorDocument.setKey(this.key);
            return errorDocument;
        }

        public ErrorDocumentBuilder key(String str) {
            this.key = str;
            return this;
        }

        private ErrorDocumentBuilder() {
        }
    }

    public static ErrorDocumentBuilder builder() {
        return new ErrorDocumentBuilder();
    }

    public String getKey() {
        return this.key;
    }

    public ErrorDocument setKey(String str) {
        this.key = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("ErrorDocument{key='"), this.key, "'}");
    }
}
