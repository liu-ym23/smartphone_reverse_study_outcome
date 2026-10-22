package org.apache.http.entity;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class InputStreamEntity extends AbstractHttpEntity {
    private final InputStream content;
    private final long length;

    public InputStreamEntity(InputStream r10) {
        this(r10, -1);
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IOException {
        return this.content;
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
        return true;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream r11) throws IOException {
        Args.notNull(r11, "Output stream");
        InputStream r10 = this.content;
        byte[] r12 = new byte[4096];     // Catch: Throwable -> L8
        long r13 = this.length;     // Catch: Throwable -> L8
        if (r13 >= 0) goto L11;
    L5:
        int r14 = r10.read(r12);     // Catch: Throwable -> L8
        if (r14 == (-1)) goto L17;
        r11.write(r12, 0, r14);     // Catch: Throwable -> L8
    L17:
        r10.close();
        return;
    L11:
        if (r13 <= 0) goto L17;
        int r15 = r10.read(r12, 0, (int) Math.min(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM, r13));     // Catch: Throwable -> L8
        if (r15 == (-1)) goto L17;
        r11.write(r12, 0, r15);     // Catch: Throwable -> L8
        r13 = r13 - ((long) r15);
    L8:
        th = move-exception;
        r10.close();
        throw th;
    }

    public InputStreamEntity(InputStream r10, long r11) {
        this(r10, r11, null);
    }

    public InputStreamEntity(InputStream r10, ContentType r11) {
        this(r10, -1, r11);
    }

    public InputStreamEntity(InputStream r10, long r11, ContentType r12) {
        this.content = (InputStream) Args.notNull(r10, "Source input stream");
        this.length = r11;
        if (r12 == null) goto L6;
        setContentType(r12.toString());
        return;
    }
}
