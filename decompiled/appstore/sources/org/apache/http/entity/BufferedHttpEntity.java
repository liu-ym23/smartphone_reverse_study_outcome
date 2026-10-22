package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class BufferedHttpEntity extends HttpEntityWrapper {
    private final byte[] buffer;

    public BufferedHttpEntity(HttpEntity r10) throws IOException {
        super(r10);
        if (r10.isRepeatable() == true) goto L5;
    L8:
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        r10.writeTo(r11);
        r11.flush();
        this.buffer = r11.toByteArray();
        return;
    L5:
        if (r10.getContentLength() < 0) goto L8;
        this.buffer = null;
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public InputStream getContent() throws IOException {
        if (this.buffer == null) goto L6;
        return new ByteArrayInputStream(this.buffer);
    L6:
        return super.getContent();
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public long getContentLength() {
        byte[] r10 = this.buffer;
        if (r10 == null) goto L6;
        return r10.length;
    L6:
        return super.getContentLength();
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public boolean isChunked() {
        if (this.buffer == null) goto L5;
    L7:
        return false;
    L5:
        if (super.isChunked() == false) goto L7;
        return true;
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public boolean isStreaming() {
        if (this.buffer == null) goto L5;
    L7:
        return false;
    L5:
        if (super.isStreaming() == false) goto L7;
        return true;
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public void writeTo(OutputStream r10) throws IOException {
        Args.notNull(r10, "Output stream");
        byte[] r11 = this.buffer;
        if (r11 == null) goto L5;
        r10.write(r11);
        return;
    L5:
        super.writeTo(r10);
    }
}
