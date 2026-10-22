package org.apache.http.entity;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractHttpEntity implements HttpEntity {
    protected static final int OUTPUT_BUFFER_SIZE = 4096;
    protected boolean chunked;
    protected Header contentEncoding;
    protected Header contentType;

    public AbstractHttpEntity() {
    }

    @Override // org.apache.http.HttpEntity
    @Deprecated
    public void consumeContent() throws IOException {
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentType() {
        return this.contentType;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        return this.chunked;
    }

    public void setChunked(boolean r10) {
        this.chunked = r10;
    }

    public void setContentEncoding(Header r10) {
        this.contentEncoding = r10;
    }

    public void setContentType(Header r10) {
        this.contentType = r10;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append('[');
        if (this.contentType == null) goto L6;
        r10.append("Content-Type: ");
        r10.append(this.contentType.getValue());
        r10.append(',');
    L6:
        if (this.contentEncoding == null) goto L8;
        r10.append("Content-Encoding: ");
        r10.append(this.contentEncoding.getValue());
        r10.append(',');
    L8:
        long r11 = getContentLength();
        if (r11 < 0) goto L11;
        r10.append("Content-Length: ");
        r10.append(r11);
        r10.append(',');
    L11:
        r10.append("Chunked: ");
        r10.append(this.chunked);
        r10.append(']');
        return r10.toString();
    }

    public void setContentEncoding(String r10) {
        if (r10 == null) goto L4;
        BasicHeader r11 = new BasicHeader("Content-Encoding", r10);
    L5:
        setContentEncoding(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setContentType(String r10) {
        if (r10 == null) goto L4;
        BasicHeader r11 = new BasicHeader("Content-Type", r10);
    L5:
        setContentType(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }
}
