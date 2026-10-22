package org.apache.http.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.entity.ContentType;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;

    private EntityUtils() {
    }

    public static void consume(HttpEntity r10) throws IOException {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isStreaming() == false) goto L10;
        InputStream r11 = r10.getContent();
        if (r11 == null) goto L11;
        r11.close();
        return;
    L11:
        return;
    }

    public static void consumeQuietly(HttpEntity r10) {
        consume(r10);     // Catch: IOException -> L4
        return;
    }

    @Deprecated
    public static String getContentCharSet(HttpEntity r10) throws ParseException {
        Args.notNull(r10, "Entity");
        if (r10.getContentType() == null) goto L9;
        HeaderElement[] r11 = r10.getContentType().getElements();
        if (r11.length <= 0) goto L9;
        NameValuePair r12 = r11[0].getParameterByName("charset");
        if (r12 == null) goto L9;
        return r12.getValue();
    L9:
        return null;
    }

    @Deprecated
    public static String getContentMimeType(HttpEntity r10) throws ParseException {
        Args.notNull(r10, "Entity");
        if (r10.getContentType() == null) goto L7;
        HeaderElement[] r11 = r10.getContentType().getElements();
        if (r11.length <= 0) goto L7;
        return r11[0].getName();
    L7:
        return null;
    }

    public static byte[] toByteArray(HttpEntity r10) throws IOException {
        Args.notNull(r10, "Entity");
        InputStream r11 = r10.getContent();
        if (r11 != null) goto L24;
        return null;
    L24:
    L17:
        th = move-exception;
        r11.close();
        throw th;
    L7:
        if (r10.getContentLength() > 2147483647L) goto L9;
        boolean r12 = true;
    L10:
        Args.check(r12, "HTTP entity too large to be buffered in memory");     // Catch: Throwable -> L17
        int r13 = (int) r10.getContentLength();     // Catch: Throwable -> L17
        if (r13 >= 0) goto L13;
        r13 = 4096;
    L13:
        ByteArrayBuffer r14 = new ByteArrayBuffer(r13);     // Catch: Throwable -> L17
        byte[] r15 = new byte[4096];     // Catch: Throwable -> L17
    L14:
        int r16 = r11.read(r15);     // Catch: Throwable -> L17
        if (r16 == (-1)) goto L19;
        r14.append(r15, 0, r16);     // Catch: Throwable -> L17
        goto L14
    L19:
        byte[] r17 = r14.toByteArray();     // Catch: Throwable -> L17
        r11.close();
        return r17;
    L9:
        r12 = false;
        goto L10
    }

    private static String toString(HttpEntity r10, ContentType r11) throws IOException {
        InputStream r12 = r10.getContent();
        Charset r13 = null;
        if (r12 != null) goto L32;
        return null;
    L32:
    L18:
        th = move-exception;
        r12.close();
        throw th;
    L6:
        if (r10.getContentLength() > 2147483647L) goto L8;
        boolean r14 = true;
    L9:
        Args.check(r14, "HTTP entity too large to be buffered in memory");     // Catch: Throwable -> L18
        int r15 = (int) r10.getContentLength();     // Catch: Throwable -> L18
        if (r15 >= 0) goto L12;
        r15 = 4096;
    L12:
        if (r11 == null) goto L21;
        Charset r16 = r11.getCharset();     // Catch: Throwable -> L18
        if (r16 != null) goto L20;
        ContentType r17 = ContentType.getByMimeType(r11.getMimeType());     // Catch: Throwable -> L18
        if (r17 == null) goto L21;
        r13 = r17.getCharset();     // Catch: Throwable -> L18
        goto L21
    L20:
        r13 = r16;
    L21:
        if (r13 != null) goto L23;
        r13 = HTTP.DEF_CONTENT_CHARSET;     // Catch: Throwable -> L18
    L23:
        InputStreamReader r18 = new InputStreamReader(r12, r13);     // Catch: Throwable -> L18
        CharArrayBuffer r19 = new CharArrayBuffer(r15);     // Catch: Throwable -> L18
        char[] r20 = new char[1024];     // Catch: Throwable -> L18
    L24:
        int r21 = r18.read(r20);     // Catch: Throwable -> L18
        if (r21 == (-1)) goto L27;
        r19.append(r20, 0, r21);     // Catch: Throwable -> L18
        goto L24
    L27:
        String r22 = r19.toString();     // Catch: Throwable -> L18
        r12.close();
        return r22;
    L8:
        r14 = false;
        goto L9
    }

    public static void updateEntity(HttpResponse r10, HttpEntity r11) throws IOException {
        Args.notNull(r10, "Response");
        consume(r10.getEntity());
        r10.setEntity(r11);
    }

    public static String toString(HttpEntity r10, Charset r11) throws IOException, ParseException {
        Args.notNull(r10, "Entity");
        ContentType r12 = ContentType.get(r10);     // Catch: UnsupportedCharsetException -> L5
    L8:
        if (r12 != null) goto L10;
        r12 = ContentType.DEFAULT_TEXT.withCharset(r11);
    L14:
        return toString(r10, r12);
    L10:
        if (r12.getCharset() != null) goto L14;
        r12 = r12.withCharset(r11);
    L5:
        e = move-exception;
        if (r11 == null) goto L16;
        r12 = null;
        goto L8
    L16:
        throw new UnsupportedEncodingException(e.getMessage());
    }

    public static String toString(HttpEntity r10, String r11) throws IOException, ParseException {
        if (r11 == null) goto L4;
        Charset r12 = Charset.forName(r11);
    L6:
        return toString(r10, r12);
    L4:
        r12 = null;
        goto L6
    }

    public static String toString(HttpEntity r10) throws IOException, ParseException {
        Args.notNull(r10, "Entity");
        return toString(r10, ContentType.get(r10));
    }
}
