package org.apache.http.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class FileEntity extends AbstractHttpEntity implements Cloneable {
    protected final File file;

    @Deprecated
    public FileEntity(File r10, String r11) {
        this.file = (File) Args.notNull(r10, "File");
        setContentType(r11);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IOException {
        return new FileInputStream(this.file);
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.file.length();
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
        FileInputStream r11 = new FileInputStream(this.file);
        byte[] r12 = new byte[4096];     // Catch: Throwable -> L7
    L4:
        int r13 = r11.read(r12);     // Catch: Throwable -> L7
        if (r13 == (-1)) goto L9;
        r10.write(r12, 0, r13);     // Catch: Throwable -> L7
        goto L4
    L9:
        r10.flush();     // Catch: Throwable -> L7
        r11.close();
        return;
    L7:
        th = move-exception;
        r11.close();
        throw th;
    }

    public FileEntity(File r10, ContentType r11) {
        this.file = (File) Args.notNull(r10, "File");
        if (r11 == null) goto L6;
        setContentType(r11.toString());
        return;
    }

    public FileEntity(File r10) {
        this.file = (File) Args.notNull(r10, "File");
    }
}
