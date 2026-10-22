package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ResponseBody implements Closeable {
    private Reader reader;

    public static class a extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaType f22819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f22820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BufferedSource f22821c;

        public a(MediaType r10, long r11, BufferedSource r12) {
            this.f22819a = r10;
            this.f22820b = r11;
            this.f22821c = r12;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f22820b;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f22819a;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return this.f22821c;
        }
    }

    public static final class b extends Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BufferedSource f22822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Charset f22823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f22824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Reader f22825d;

        public b(BufferedSource r10, Charset r11) {
            this.f22822a = r10;
            this.f22823b = r11;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f22824c = true;
            Reader r10 = this.f22825d;
            if (r10 == null) goto L5;
            r10.close();
            return;
        L5:
            this.f22822a.close();
        }

        @Override // java.io.Reader
        public int read(char[] r10, int r11, int r12) {
            if (this.f22824c == true) goto L10;
            Reader r13 = this.f22825d;
            if (r13 != null) goto L8;
            Charset r14 = Util.bomAwareCharset(this.f22822a, this.f22823b);
            InputStreamReader r15 = new InputStreamReader(this.f22822a.inputStream(), r14);
            this.f22825d = r15;
            r13 = r15;
        L8:
            return r13.read(r10, r11, r12);
        L10:
            throw new IOException("Stream closed");
        }
    }

    public ResponseBody() {
    }

    public static ResponseBody create(@Nullable MediaType r10, String r11) {
        Charset r12 = Util.UTF_8;
        if (r10 == null) goto L8;
        Charset r13 = r10.a();
        if (r13 != null) goto L7;
        r10 = MediaType.c(r10 + "; charset=utf-8");
        goto L8
    L7:
        r12 = r13;
    L8:
        Buffer r14 = new Buffer().D(r11, r12);
        return create(r10, r14.size(), r14);
    }

    public final Charset a() {
        MediaType r10 = contentType();
        if (r10 == null) goto L6;
        return r10.b(Util.UTF_8);
    L6:
        return Util.UTF_8;
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    public final byte[] bytes() throws IOException {
        long r10 = contentLength();
        if (r10 > 2147483647L) goto L18;
        BufferedSource r11 = source();
        byte[] r12 = r11.readByteArray();     // Catch: Throwable -> L14
        Util.closeQuietly(r11);
        if (r10 != (-1)) goto L9;
    L13:
        return r12;
    L9:
        if (r10 == r12.length) goto L13;
        throw new IOException("Content-Length (" + r10 + ") and stream length (" + r12.length + ") disagree");
    L14:
        th = move-exception;
        Util.closeQuietly(r11);
        throw th;
    L18:
        throw new IOException("Cannot buffer entire body for content length: " + r10);
    }

    public final Reader charStream() {
        Reader r10 = this.reader;
        if (r10 != null) goto L7;
        b r11 = new b(source(), a());
        this.reader = r11;
        return r11;
    L7:
        return r10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final String string() throws IOException {
        BufferedSource r10 = source();
        String r11 = r10.readString(Util.bomAwareCharset(r10, a()));     // Catch: Throwable -> L6
        Util.closeQuietly(r10);
        return r11;
    L6:
        th = move-exception;
        Util.closeQuietly(r10);
        throw th;
    }

    public static ResponseBody create(@Nullable MediaType r10, byte[] r11) {
        return create(r10, r11.length, new Buffer().r(r11));
    }

    public static ResponseBody create(@Nullable MediaType r10, long r11, BufferedSource r12) {
        if (r12 == null) goto L6;
        return new a(r10, r11, r12);
    L6:
        throw new NullPointerException("source == null");
    }
}
