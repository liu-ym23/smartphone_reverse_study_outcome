package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class EntityTemplate extends AbstractHttpEntity {
    private final ContentProducer contentproducer;

    public EntityTemplate(ContentProducer r10) {
        this.contentproducer = (ContentProducer) Args.notNull(r10, "Content producer");
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IOException {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        writeTo(r10);
        return new ByteArrayInputStream(r10.toByteArray());
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return -1;
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
        this.contentproducer.writeTo(r10);
    }
}
