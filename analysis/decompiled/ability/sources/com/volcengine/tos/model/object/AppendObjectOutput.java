package com.volcengine.tos.model.object;

import B7.a;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class AppendObjectOutput {

    @Deprecated
    private String etag;
    private String hashCrc64ecma;
    private long nextAppendOffset;
    private RequestInfo requestInfo;
    private String versionID;

    @Deprecated
    public String getCrc64() {
        return this.hashCrc64ecma;
    }

    @Deprecated
    public String getEtag() {
        return this.etag;
    }

    public String getHashCrc64ecma() {
        return this.hashCrc64ecma;
    }

    public long getNextAppendOffset() {
        return this.nextAppendOffset;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public String getVersionID() {
        return this.versionID;
    }

    @Deprecated
    public AppendObjectOutput setCrc64(String str) {
        this.hashCrc64ecma = str;
        return this;
    }

    @Deprecated
    public AppendObjectOutput setEtag(String str) {
        this.etag = str;
        return this;
    }

    public AppendObjectOutput setHashCrc64ecma(String str) {
        this.hashCrc64ecma = str;
        return this;
    }

    public AppendObjectOutput setNextAppendOffset(long j5) {
        this.nextAppendOffset = j5;
        return this;
    }

    public AppendObjectOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public AppendObjectOutput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppendObjectOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", versionID='");
        sb.append(this.versionID);
        sb.append("', hashCrc64ecma=");
        sb.append(this.hashCrc64ecma);
        sb.append(", nextAppendOffset=");
        return a.p(sb, this.nextAppendOffset, '}');
    }
}
