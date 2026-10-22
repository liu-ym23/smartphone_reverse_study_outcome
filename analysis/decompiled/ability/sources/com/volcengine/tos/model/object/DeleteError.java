package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class DeleteError {

    @JsonProperty("Code")
    private String code;

    @JsonProperty("Key")
    private String key;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("VersionId")
    private String versionID;

    public String getCode() {
        return this.code;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public DeleteError setCode(String str) {
        this.code = str;
        return this;
    }

    public DeleteError setKey(String str) {
        this.key = str;
        return this;
    }

    public DeleteError setMessage(String str) {
        this.message = str;
        return this;
    }

    public DeleteError setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeleteError{code='");
        sb.append(this.code);
        sb.append("', message='");
        sb.append(this.message);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', versionID='");
        return a.q(sb, this.versionID, "'}");
    }
}
