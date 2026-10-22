package com.volcengine.tos.model.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.volcengine.tos.internal.TosResponse;
import com.volcengine.tos.model.RequestInfo;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

@Deprecated
/* loaded from: classes3.dex */
public class GetObjectOutput implements Closeable, Serializable {

    @JsonIgnore
    private transient InputStream content;
    private String contentRange;
    private ObjectMeta objectMeta;

    @JsonIgnore
    private RequestInfo requestInfo;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.content;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public InputStream getContent() {
        return this.content;
    }

    public String getContentRange() {
        return this.contentRange;
    }

    public ObjectMeta getObjectMeta() {
        return this.objectMeta;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public GetObjectOutput setContent(InputStream inputStream) {
        this.content = inputStream;
        return this;
    }

    public GetObjectOutput setContentRange(String str) {
        this.contentRange = str;
        return this;
    }

    public GetObjectOutput setObjectMeta(ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
        return this;
    }

    public GetObjectOutput setObjectMetaFromResponse(TosResponse tosResponse) {
        this.objectMeta = new ObjectMeta().fromResponse(tosResponse);
        return this;
    }

    public GetObjectOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        return "GetObjectOutput{requestInfo=" + this.requestInfo + ", contentRange='" + this.contentRange + "', content=" + this.content + ", objectMeta=" + this.objectMeta + '}';
    }
}
