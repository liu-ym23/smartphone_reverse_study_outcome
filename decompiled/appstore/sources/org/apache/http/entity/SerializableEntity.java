package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class SerializableEntity extends AbstractHttpEntity {
    private Serializable objRef;
    private byte[] objSer;

    public SerializableEntity(Serializable r10, boolean r11) throws IOException {
        Args.notNull(r10, "Source object");
        if (r11 == false) goto L5;
        createBytes(r10);
        return;
    L5:
        this.objRef = r10;
    }

    private void createBytes(Serializable r10) throws IOException {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        ObjectOutputStream r12 = new ObjectOutputStream(r11);
        r12.writeObject(r10);
        r12.flush();
        this.objSer = r11.toByteArray();
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IOException, IllegalStateException {
        if (this.objSer != null) goto L6;
        createBytes(this.objRef);
    L6:
        return new ByteArrayInputStream(this.objSer);
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        byte[] r10 = this.objSer;
        if (r10 != null) goto L6;
        return -1;
    L6:
        return r10.length;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        if (this.objSer != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream r10) throws IOException {
        Args.notNull(r10, "Output stream");
        byte[] r11 = this.objSer;
        if (r11 != null) goto L5;
        ObjectOutputStream r12 = new ObjectOutputStream(r10);
        r12.writeObject(this.objRef);
        r12.flush();
        return;
    L5:
        r10.write(r11);
        r10.flush();
    }

    public SerializableEntity(Serializable r10) {
        Args.notNull(r10, "Source object");
        this.objRef = r10;
    }
}
