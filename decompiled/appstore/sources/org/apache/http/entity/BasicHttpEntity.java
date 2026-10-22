package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.impl.io.EmptyInputStream;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

/* JADX INFO: loaded from: classes4.dex */
public class BasicHttpEntity extends AbstractHttpEntity {
    private InputStream content;
    private long length;

    public BasicHttpEntity() {
        this.length = -1;
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IllegalStateException {
        if (this.content == null) goto L5;
        boolean r10 = true;
    L6:
        Asserts.check(r10, "Content has not been provided");
        return this.content;
    L5:
        r10 = false;
        goto L6
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.length;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        InputStream r10 = this.content;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10 == EmptyInputStream.INSTANCE) goto L7;
        return true;
    }

    public void setContent(InputStream r10) {
        this.content = r10;
    }

    public void setContentLength(long r10) {
        this.length = r10;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream r10) throws IOException {
        Args.notNull(r10, "Output stream");
        InputStream r11 = getContent();
        byte[] r12 = new byte[4096];     // Catch: Throwable -> L8
    L4:
        int r13 = r11.read(r12);     // Catch: Throwable -> L8
        if (r13 == (-1)) goto L10;
        r10.write(r12, 0, r13);     // Catch: Throwable -> L8
        goto L4
    L10:
        r11.close();
        return;
    L8:
        th = move-exception;
        r11.close();
        throw th;
    }
}
