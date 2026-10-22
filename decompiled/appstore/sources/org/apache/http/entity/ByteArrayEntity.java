package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class ByteArrayEntity extends AbstractHttpEntity implements Cloneable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f23032b;

    @Deprecated
    protected final byte[] content;
    private final int len;
    private final int off;

    public ByteArrayEntity(byte[] r10, ContentType r11) {
        Args.notNull(r10, "Source byte array");
        this.content = r10;
        this.f23032b = r10;
        this.off = 0;
        this.len = r10.length;
        if (r11 == null) goto L6;
        setContentType(r11.toString());
        return;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        return new ByteArrayInputStream(this.f23032b, this.off, this.len);
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.len;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream r10) throws IOException {
        Args.notNull(r10, "Output stream");
        r10.write(this.f23032b, this.off, this.len);
        r10.flush();
    }

    public ByteArrayEntity(byte[] r10, int r11, int r12, ContentType r13) {
        Args.notNull(r10, "Source byte array");
        if (r11 < 0) goto L16;
        if (r11 > r10.length) goto L16;
        if (r12 < 0) goto L16;
        int r14 = r11 + r12;
        if (r14 < 0) goto L16;
        if (r14 > r10.length) goto L16;
        this.content = r10;
        this.f23032b = r10;
        this.off = r11;
        this.len = r12;
        if (r13 == null) goto L17;
        setContentType(r13.toString());
        return;
    L17:
        return;
    L16:
        throw new IndexOutOfBoundsException("off: " + r11 + " len: " + r12 + " b.length: " + r10.length);
    }

    public ByteArrayEntity(byte[] r10) {
        this(r10, null);
    }

    public ByteArrayEntity(byte[] r10, int r11, int r12) {
        this(r10, r11, r12, null);
    }
}
