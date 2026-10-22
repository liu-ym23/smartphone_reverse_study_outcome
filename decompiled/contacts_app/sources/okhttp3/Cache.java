package okhttp3;

import com.bytedance.retrofit2.HttpMethodContrants;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes5.dex */
public final class Cache implements Closeable, Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    int writeAbortCount;
    int writeSuccessCount;

    private final class CacheRequestImpl implements CacheRequest {
        private Sink body;
        private Sink cacheOut;
        boolean done;
        private final DiskLruCache.Editor editor;
        final /* synthetic */ Cache this$0;

        CacheRequestImpl(final Cache r3, final DiskLruCache.Editor r4) {
            this.this$0 = r3;
            this.editor = r4;
            this.cacheOut = r4.newSink(1);
            final Sink r1 = this.cacheOut;
            this.body = new AnonymousClass1(this, r1, r3, r4);
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            Cache r0 = this.this$0;
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.done == false) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L8:
            this.done = true;     // Catch: Throwable -> L13
            this.this$0.writeAbortCount++;     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            Util.closeQuietly(this.cacheOut);
            this.editor.abort();     // Catch: IOException -> L16
            return;
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public Sink body() {
            return this.body;
        }
    }

    private static class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;

        @Nullable
        private final String contentLength;

        @Nullable
        private final String contentType;
        final DiskLruCache.Snapshot snapshot;

        CacheResponseBody(final DiskLruCache.Snapshot r1, String r2, String r3) {
            this.snapshot = r1;
            this.contentType = r2;
            this.contentLength = r3;
            final Source r4 = r1.getSource(1);
            this.bodySource = Okio.buffer(new AnonymousClass1(this, r4, r1));
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String r0 = this.contentType;
            if (r0 != null) goto L7;
            return null;
        L7:
            return MediaType.parse(r0);
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String r2 = this.contentLength;     // Catch: NumberFormatException -> L7
            if (r2 == null) goto L10;
            return Long.parseLong(r2);
        L10:
            return -1;
        L11:
            return -1;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return this.bodySource;
        }
    }

    private static final class Entry {
        private static final String RECEIVED_MILLIS = null;
        private static final String SENT_MILLIS = null;
        private final int code;

        @Nullable
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final String url;
        private final Headers varyHeaders;

        static {
            SENT_MILLIS = Platform.get().getPrefix() + "-Sent-Millis";
            RECEIVED_MILLIS = Platform.get().getPrefix() + "-Received-Millis";
        }

        Entry(Source r9) throws IOException {
            BufferedSource r0 = Okio.buffer(r9);     // Catch: Throwable -> L30
            this.url = r0.readUtf8LineStrict();     // Catch: Throwable -> L30
            this.requestMethod = r0.readUtf8LineStrict();     // Catch: Throwable -> L30
            Headers.Builder r1 = new Headers.Builder();     // Catch: Throwable -> L30
            int r2 = Cache.readInt(r0);     // Catch: Throwable -> L30
            int r3 = 0;
            int r4 = 0;
        L4:
            if (r4 >= r2) goto L6;
            r1.addLenient(r0.readUtf8LineStrict());     // Catch: Throwable -> L30
            r4 = r4 + 1;     // Catch: Throwable -> L30
            goto L4
        L6:
            this.varyHeaders = r1.build();     // Catch: Throwable -> L30
            StatusLine r5 = StatusLine.parse(r0.readUtf8LineStrict());     // Catch: Throwable -> L30
            this.protocol = r5.protocol;     // Catch: Throwable -> L30
            this.code = r5.code;     // Catch: Throwable -> L30
            this.message = r5.message;     // Catch: Throwable -> L30
            Headers.Builder r6 = new Headers.Builder();     // Catch: Throwable -> L30
            int r7 = Cache.readInt(r0);     // Catch: Throwable -> L30
        L7:
            if (r3 >= r7) goto L9;
            r6.addLenient(r0.readUtf8LineStrict());     // Catch: Throwable -> L30
            r3 = r3 + 1;     // Catch: Throwable -> L30
            goto L7
        L9:
            String r8 = SENT_MILLIS;     // Catch: Throwable -> L30
            String r10 = r6.get(r8);     // Catch: Throwable -> L30
            String r11 = RECEIVED_MILLIS;     // Catch: Throwable -> L30
            String r12 = r6.get(r11);     // Catch: Throwable -> L30
            r6.removeAll(r8);     // Catch: Throwable -> L30
            r6.removeAll(r11);     // Catch: Throwable -> L30
            long r13 = 0;
            if (r10 == null) goto L12;
            long r14 = Long.parseLong(r10);     // Catch: Throwable -> L30
        L13:
            this.sentRequestMillis = r14;     // Catch: Throwable -> L30
            if (r12 == null) goto L16;
            r13 = Long.parseLong(r12);     // Catch: Throwable -> L30
        L16:
            this.receivedResponseMillis = r13;     // Catch: Throwable -> L30
            this.responseHeaders = r6.build();     // Catch: Throwable -> L30
            if (isHttps() == false) goto L27;
            String r15 = r0.readUtf8LineStrict();     // Catch: Throwable -> L30
            if (r15.length() > 0) goto L26;
            CipherSuite r16 = CipherSuite.forJavaName(r0.readUtf8LineStrict());     // Catch: Throwable -> L30
            List<Certificate> r17 = readCertificateList(r0);     // Catch: Throwable -> L30
            List<Certificate> r18 = readCertificateList(r0);     // Catch: Throwable -> L30
            if (r0.exhausted() == true) goto L23;
            TlsVersion r19 = TlsVersion.forJavaName(r0.readUtf8LineStrict());     // Catch: Throwable -> L30
        L24:
            this.handshake = Handshake.get(r19, r16, r17, r18);     // Catch: Throwable -> L30
        L28:
            r9.close();
            return;
        L23:
            r19 = TlsVersion.SSL_3_0;     // Catch: Throwable -> L30
            goto L24
        L26:
            throw new IOException("expected \"\" but was \"" + r15 + "\"");     // Catch: Throwable -> L30
        L27:
            this.handshake = null;     // Catch: Throwable -> L30
            goto L28
        L12:
            r14 = 0;
        L30:
            th = move-exception;
            r9.close();
            throw th;
        }

        Entry(Response r3) {
            this.url = r3.request().url().toString();
            this.varyHeaders = HttpHeaders.varyHeaders(r3);
            this.requestMethod = r3.request().method();
            this.protocol = r3.protocol();
            this.code = r3.code();
            this.message = r3.message();
            this.responseHeaders = r3.headers();
            this.handshake = r3.handshake();
            this.sentRequestMillis = r3.sentRequestAtMillis();
            this.receivedResponseMillis = r3.receivedResponseAtMillis();
        }

        public void writeTo(DiskLruCache.Editor r8) throws IOException {
            int r0 = 0;
            BufferedSink r9 = Okio.buffer(r8.newSink(0));
            r9.writeUtf8(this.url).writeByte(10);
            r9.writeUtf8(this.requestMethod).writeByte(10);
            r9.writeDecimalLong(this.varyHeaders.size()).writeByte(10);
            int r1 = this.varyHeaders.size();
            int r3 = 0;
        L4:
            if (r3 >= r1) goto L6;
            r9.writeUtf8(this.varyHeaders.name(r3)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(r3)).writeByte(10);
            r3 = r3 + 1;
            goto L4
        L6:
            r9.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
            r9.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(10);
            int r2 = this.responseHeaders.size();
        L7:
            if (r0 >= r2) goto L9;
            r9.writeUtf8(this.responseHeaders.name(r0)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(r0)).writeByte(10);
            r0 = r0 + 1;
            goto L7
        L9:
            r9.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
            r9.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
            if (isHttps() == false) goto L12;
            r9.writeByte(10);
            r9.writeUtf8(this.handshake.cipherSuite().javaName()).writeByte(10);
            writeCertList(r9, this.handshake.peerCertificates());
            writeCertList(r9, this.handshake.localCertificates());
            r9.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
        L12:
            r9.close();
        }

        private boolean isHttps() {
            return this.url.startsWith("https://");
        }

        private List<Certificate> readCertificateList(BufferedSource r6) throws IOException {
            int r5 = Cache.readInt(r6);
            if (r5 == (-1)) goto L5;
            CertificateFactory r0 = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L11
            ArrayList r1 = new ArrayList(r5);     // Catch: CertificateException -> L11
            int r2 = 0;
        L7:
            if (r2 >= r5) goto L10;
            String r3 = r6.readUtf8LineStrict();     // Catch: CertificateException -> L11
            Buffer r4 = new Buffer();     // Catch: CertificateException -> L11
            r4.write(ByteString.decodeBase64(r3));     // Catch: CertificateException -> L11
            r1.add(r0.generateCertificate(r4.inputStream()));     // Catch: CertificateException -> L11
            r2 = r2 + 1;
            goto L7
        L10:
            return r1;
        L11:
            e = move-exception;
            throw new IOException(e.getMessage());
        L5:
            return Collections.emptyList();
        }

        private void writeCertList(BufferedSink r4, List<Certificate> r5) throws IOException {
            r4.writeDecimalLong(r5.size()).writeByte(10);     // Catch: CertificateEncodingException -> L7
            int r3 = r5.size();     // Catch: CertificateEncodingException -> L7
            int r1 = 0;
        L3:
            if (r1 >= r3) goto L6;
            r4.writeUtf8(ByteString.of(r5.get(r1).getEncoded()).base64()).writeByte(10);     // Catch: CertificateEncodingException -> L7
            r1 = r1 + 1;
            goto L3
        L6:
            return;
        L7:
            e = move-exception;
            throw new IOException(e.getMessage());
        }

        public boolean matches(Request r3, Response r4) {
            if (this.url.equals(r3.url().toString()) == true) goto L5;
        L9:
            return false;
        L5:
            if (this.requestMethod.equals(r3.method()) == false) goto L9;
            if (HttpHeaders.varyMatches(r4, this.varyHeaders, r3) == false) goto L9;
            return true;
        }

        public Response response(DiskLruCache.Snapshot r6) {
            String r0 = this.responseHeaders.get("Content-Type");
            String r1 = this.responseHeaders.get("Content-Length");
            Request r2 = new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build();
            return new Response.Builder().request(r2).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(r6, r0, r1)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }
    }

    public Cache(File r2, long r3) {
        this(r2, r3, FileSystem.SYSTEM);
    }

    Cache(File r8, long r9, FileSystem r11) {
        this.internalCache = new AnonymousClass1(this);
        this.cache = DiskLruCache.create(r11, r8, VERSION, 2, r9);
    }

    public static String key(HttpUrl r0) {
        return ByteString.encodeUtf8(r0.toString()).md5().hex();
    }

    @Nullable
    Response get(Request r4) {
        String r0 = key(r4.url());
        DiskLruCache.Snapshot r3 = this.cache.get(r0);     // Catch: IOException -> L14
        if (r3 != null) goto L17;
        return null;
    L17:
        Entry r1 = new Entry(r3.getSource(0));     // Catch: IOException -> L12
        Response r5 = r1.response(r3);
        if (r1.matches(r4, r5) == true) goto L11;
        Util.closeQuietly(r5.body());
        return null;
    L11:
        return r5;
    L12:
        Util.closeQuietly(r3);
    L13:
        return null;
    }

    @Nullable
    CacheRequest put(Response r4) {
        String r0 = r4.request().method();
        if (HttpMethod.invalidatesCache(r4.request().method()) == false) goto L7;
        remove(r4.request());     // Catch: IOException -> L22
    L5:
        return null;
    L7:
        if (r0.equals(HttpMethodContrants.GET) == true) goto L10;
        return null;
    L10:
        if (HttpHeaders.hasVaryAll(r4) == false) goto L12;
        return null;
    L12:
        Entry r1 = new Entry(r4);
        DiskLruCache.Editor r5 = this.cache.edit(key(r4.request().url()));     // Catch: IOException -> L18
        if (r5 != null) goto L23;
        return null;
    L23:
        r1.writeTo(r5);     // Catch: IOException -> L21
        return new CacheRequestImpl(this, r5);
    L19:
        abortQuietly(r5);
        return null;
    L18:
        r5 = null;
        goto L19
    }

    void remove(Request r1) throws IOException {
        this.cache.remove(key(r1.url()));
    }

    void update(Response r2, Response r3) {
        Entry r0 = new Entry(r3);
        DiskLruCache.Editor r4 = ((CacheResponseBody) r2.body()).snapshot.edit();     // Catch: IOException -> L7
        if (r4 == null) goto L15;
        r0.writeTo(r4);     // Catch: IOException -> L10
        r4.commit();     // Catch: IOException -> L10
        return;
    L8:
        abortQuietly(r4);
        return;
    L15:
        return;
    L7:
        r4 = null;
        goto L8
    }

    private void abortQuietly(@Nullable DiskLruCache.Editor r1) {
        if (r1 == null) goto L8;
        r1.abort();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public void initialize() throws IOException {
        this.cache.initialize();
    }

    public void delete() throws IOException {
        this.cache.delete();
    }

    public void evictAll() throws IOException {
        this.cache.evictAll();
    }

    public Iterator<String> urls() throws IOException {
        return new AnonymousClass2(this);
    }

    public synchronized int writeAbortCount() {
        monitor-enter(this);
        int r0 = this.writeAbortCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int writeSuccessCount() {
        monitor-enter(this);
        int r0 = this.writeSuccessCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public long size() throws IOException {
        return this.cache.size();
    }

    public long maxSize() {
        return this.cache.getMaxSize();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    public File directory() {
        return this.cache.getDirectory();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    synchronized void trackResponse(CacheStrategy r2) {
        monitor-enter(this);
        this.requestCount++;     // Catch: Throwable -> L11
        if (r2.networkRequest == null) goto L7;
        this.networkCount++;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L7:
        if (r2.cacheResponse == null) goto L9;
        this.hitCount++;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    synchronized void trackConditionalCacheHit() {
        monitor-enter(this);
        this.hitCount++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int networkCount() {
        monitor-enter(this);
        int r0 = this.networkCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int hitCount() {
        monitor-enter(this);
        int r0 = this.hitCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int requestCount() {
        monitor-enter(this);
        int r0 = this.requestCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    static int readInt(BufferedSource r5) throws IOException {
        long r1 = r5.readDecimalLong();     // Catch: NumberFormatException -> L13
        String r6 = r5.readUtf8LineStrict();     // Catch: NumberFormatException -> L13
        if (r1 < 0) goto L12;
        if (r1 > 2147483647L) goto L12;
        if (r6.isEmpty() == false) goto L12;
        return (int) r1;
    L12:
        throw new IOException("expected an int but was \"" + r1 + r6 + "\"");     // Catch: NumberFormatException -> L13
    L13:
        e = move-exception;
        throw new IOException(e.getMessage());
    }
}
