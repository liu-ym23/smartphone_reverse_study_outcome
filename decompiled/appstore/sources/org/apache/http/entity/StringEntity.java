package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class StringEntity extends AbstractHttpEntity implements Cloneable {
    protected final byte[] content;

    public StringEntity(String r10, ContentType r11) throws UnsupportedCharsetException {
        Args.notNull(r10, "Source string");
        if (r11 == null) goto L5;
        Charset r12 = r11.getCharset();
    L6:
        if (r12 != null) goto L8;
        r12 = HTTP.DEF_CONTENT_CHARSET;
    L8:
        this.content = r10.getBytes(r12);
        if (r11 == null) goto L12;
        setContentType(r11.toString());
        return;
    L12:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IOException {
        return new ByteArrayInputStream(this.content);
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.content.length;
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
        r10.write(this.content);
        r10.flush();
    }

    @Deprecated
    public StringEntity(String r10, String r11, String r12) throws UnsupportedEncodingException {
        Args.notNull(r10, "Source string");
        if (r11 != null) goto L6;
        r11 = HTTP.PLAIN_TEXT_TYPE;
    L6:
        if (r12 != null) goto L9;
        r12 = "ISO-8859-1";
    L9:
        this.content = r10.getBytes(r12);
        setContentType(r11 + HTTP.CHARSET_PARAM + r12);
    }

    public StringEntity(String r10, String r11) throws UnsupportedCharsetException {
        this(r10, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), r11));
    }

    public StringEntity(String r10, Charset r11) {
        this(r10, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), r11));
    }

    public StringEntity(String r10) throws UnsupportedEncodingException {
        this(r10, ContentType.DEFAULT_TEXT);
    }
}
