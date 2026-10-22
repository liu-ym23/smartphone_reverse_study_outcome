package okhttp3;

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
import java.util.NoSuchElementException;
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
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes4.dex */
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

    public class a implements InternalCache {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Cache f22641a;

        public a(Cache r10) {
            this.f22641a = r10;
        }

        @Override // okhttp3.internal.cache.InternalCache
        public Response get(Request r10) {
            return this.f22641a.get(r10);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public CacheRequest put(Response r10) {
            return this.f22641a.put(r10);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void remove(Request r10) {
            this.f22641a.remove(r10);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void trackConditionalCacheHit() {
            this.f22641a.trackConditionalCacheHit();
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void trackResponse(CacheStrategy r10) {
            this.f22641a.trackResponse(r10);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void update(Response r10, Response r11) {
            this.f22641a.update(r10, r11);
        }
    }

    public class b implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f22642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f22643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f22644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Cache f22645d;

        public b(Cache r10) {
            this.f22645d = r10;
            this.f22642a = r10.cache.snapshots();
        }

        public String a() {
            if (hasNext() == false) goto L7;
            String r10 = this.f22643b;
            this.f22643b = null;
            this.f22644c = true;
            return r10;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f22643b == null) goto L5;
            return true;
        L5:
            this.f22644c = false;
        L7:
            if (this.f22642a.hasNext() == false) goto L16;
            DiskLruCache.Snapshot r10 = (DiskLruCache.Snapshot) this.f22642a.next();
            this.f22643b = fg.j.d(r10.getSource(0)).readUtf8LineStrict();     // Catch: Throwable -> L12 IOException -> L15
        L10:
            r10.close();
            return true;
        L15:
            r10.close();
        L12:
            th = move-exception;
            r10.close();
            throw th;
        L16:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return a();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f22644c == false) goto L7;
            this.f22642a.remove();
            return;
        L7:
            throw new IllegalStateException("remove() before next()");
        }
    }

    public final class c implements CacheRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DiskLruCache.Editor f22646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Sink f22647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Sink f22648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f22649d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Cache f22650e;

        public class a extends fg.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Cache f22651a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ DiskLruCache.Editor f22652b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f22653c;

            public a(c r10, Sink r11, Cache r12, DiskLruCache.Editor r13) {
                this.f22653c = r10;
                this.f22651a = r12;
                this.f22652b = r13;
                super(r11);
            }

            @Override // fg.e, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Cache r10 = this.f22653c.f22650e;
                monitor-enter(r10);
                c r11 = this.f22653c;     // Catch: Throwable -> L8
                if (r11.f22649d == false) goto L10;
                monitor-exit(r10);     // Catch: Throwable -> L8
                return;
            L10:
                r11.f22649d = true;     // Catch: Throwable -> L8
                r11.f22650e.writeSuccessCount++;     // Catch: Throwable -> L8
                monitor-exit(r10);     // Catch: Throwable -> L8
                super.close();
                this.f22652b.commit();
                return;
            L8:
                th = move-exception;
                throw th;
            }
        }

        public c(Cache r10, DiskLruCache.Editor r11) {
            this.f22650e = r10;
            this.f22646a = r11;
            Sink r12 = r11.newSink(1);
            this.f22647b = r12;
            this.f22648c = new a(this, r12, r10, r11);
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            Cache r10 = this.f22650e;
            monitor-enter(r10);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.f22649d == false) goto L10;
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L10:
            this.f22649d = true;     // Catch: Throwable -> L8
            this.f22650e.writeAbortCount++;     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            Util.closeQuietly(this.f22647b);
            this.f22646a.abort();     // Catch: IOException -> L17
            return;
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public Sink body() {
            return this.f22648c;
        }
    }

    public static class d extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DiskLruCache.Snapshot f22654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BufferedSource f22655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f22656c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f22657d;

        public class a extends fg.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DiskLruCache.Snapshot f22658a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f22659b;

            public a(d r10, Source r11, DiskLruCache.Snapshot r12) {
                this.f22659b = r10;
                this.f22658a = r12;
                super(r11);
            }

            @Override // fg.f, okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                this.f22658a.close();
                super.close();
            }
        }

        public d(DiskLruCache.Snapshot r10, String r11, String r12) {
            this.f22654a = r10;
            this.f22656c = r11;
            this.f22657d = r12;
            this.f22655b = fg.j.d(new a(this, r10.getSource(1), r10));
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String r10 = this.f22657d;     // Catch: NumberFormatException -> L7
            if (r10 == null) goto L10;
            return Long.parseLong(r10);
        L10:
            return -1;
        L11:
            return -1;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String r10 = this.f22656c;
            if (r10 != null) goto L7;
            return null;
        L7:
            return MediaType.c(r10);
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return this.f22655b;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f22660k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f22661l = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Headers f22663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f22664c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Protocol f22665d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f22666e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f22667f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Headers f22668g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Handshake f22669h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f22670i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f22671j;

        static {
            f22660k = Platform.get().getPrefix() + "-Sent-Millis";
            f22661l = Platform.get().getPrefix() + "-Received-Millis";
        }

        public e(Source r10) {
            BufferedSource r11 = fg.j.d(r10);     // Catch: Throwable -> L6
            this.f22662a = r11.readUtf8LineStrict();     // Catch: Throwable -> L6
            this.f22664c = r11.readUtf8LineStrict();     // Catch: Throwable -> L6
            Headers.Builder r12 = new Headers.Builder();     // Catch: Throwable -> L6
            int r13 = Cache.readInt(r11);     // Catch: Throwable -> L6
            int r14 = 0;
            int r15 = 0;
        L4:
            if (r15 >= r13) goto L8;
            r12.b(r11.readUtf8LineStrict());     // Catch: Throwable -> L6
            r15 = r15 + 1;     // Catch: Throwable -> L6
            goto L4
        L8:
            this.f22663b = r12.d();     // Catch: Throwable -> L6
            StatusLine r16 = StatusLine.parse(r11.readUtf8LineStrict());     // Catch: Throwable -> L6
            this.f22665d = r16.protocol;     // Catch: Throwable -> L6
            this.f22666e = r16.code;     // Catch: Throwable -> L6
            this.f22667f = r16.message;     // Catch: Throwable -> L6
            Headers.Builder r17 = new Headers.Builder();     // Catch: Throwable -> L6
            int r18 = Cache.readInt(r11);     // Catch: Throwable -> L6
        L9:
            if (r14 >= r18) goto L11;
            r17.b(r11.readUtf8LineStrict());     // Catch: Throwable -> L6
            r14 = r14 + 1;     // Catch: Throwable -> L6
            goto L9
        L11:
            String r19 = f22660k;     // Catch: Throwable -> L6
            String r20 = r17.f(r19);     // Catch: Throwable -> L6
            String r21 = f22661l;     // Catch: Throwable -> L6
            String r22 = r17.f(r21);     // Catch: Throwable -> L6
            r17.g(r19);     // Catch: Throwable -> L6
            r17.g(r21);     // Catch: Throwable -> L6
            long r23 = 0;
            if (r20 == null) goto L14;
            long r24 = Long.parseLong(r20);     // Catch: Throwable -> L6
        L15:
            this.f22670i = r24;     // Catch: Throwable -> L6
            if (r22 == null) goto L18;
            r23 = Long.parseLong(r22);     // Catch: Throwable -> L6
        L18:
            this.f22671j = r23;     // Catch: Throwable -> L6
            this.f22668g = r17.d();     // Catch: Throwable -> L6
            if (a() == false) goto L29;
            String r25 = r11.readUtf8LineStrict();     // Catch: Throwable -> L6
            if (r25.length() > 0) goto L28;
            okhttp3.d r26 = okhttp3.d.a(r11.readUtf8LineStrict());     // Catch: Throwable -> L6
            List r27 = c(r11);     // Catch: Throwable -> L6
            List r28 = c(r11);     // Catch: Throwable -> L6
            if (r11.exhausted() == true) goto L25;
            TlsVersion r29 = TlsVersion.forJavaName(r11.readUtf8LineStrict());     // Catch: Throwable -> L6
        L26:
            this.f22669h = Handshake.c(r29, r26, r27, r28);     // Catch: Throwable -> L6
        L30:
            r10.close();
            return;
        L25:
            r29 = TlsVersion.SSL_3_0;     // Catch: Throwable -> L6
            goto L26
        L28:
            throw new IOException("expected \"\" but was \"" + r25 + "\"");     // Catch: Throwable -> L6
        L29:
            this.f22669h = null;     // Catch: Throwable -> L6
            goto L30
        L14:
            r24 = 0;
        L6:
            th = move-exception;
            r10.close();
            throw th;
        }

        public final boolean a() {
            return this.f22662a.startsWith("https://");
        }

        public boolean b(Request r10, Response r11) {
            if (this.f22662a.equals(r10.k().toString()) == true) goto L5;
        L9:
            return false;
        L5:
            if (this.f22664c.equals(r10.g()) == false) goto L9;
            if (HttpHeaders.varyMatches(r11, this.f22663b, r10) == false) goto L9;
            return true;
        }

        public final List c(BufferedSource r10) {
            int r11 = Cache.readInt(r10);
            if (r11 == (-1)) goto L5;
            CertificateFactory r12 = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L10
            ArrayList r13 = new ArrayList(r11);     // Catch: CertificateException -> L10
            int r14 = 0;
        L7:
            if (r14 >= r11) goto L12;
            String r15 = r10.readUtf8LineStrict();     // Catch: CertificateException -> L10
            Buffer r16 = new Buffer();     // Catch: CertificateException -> L10
            r16.q(ByteString.decodeBase64(r15));     // Catch: CertificateException -> L10
            r13.add(r12.generateCertificate(r16.inputStream()));     // Catch: CertificateException -> L10
            r14 = r14 + 1;
            goto L7
        L12:
            return r13;
        L10:
            e = move-exception;
            throw new IOException(e.getMessage());
        L5:
            return Collections.emptyList();
        }

        public Response d(DiskLruCache.Snapshot r10) {
            String r11 = this.f22668g.b("Content-Type");
            String r12 = this.f22668g.b("Content-Length");
            Request r13 = new Request.a().j(this.f22662a).f(this.f22664c, null).e(this.f22663b).b();
            return new Response.Builder().p(r13).m(this.f22665d).g(this.f22666e).j(this.f22667f).i(this.f22668g).b(new d(r10, r11, r12)).h(this.f22669h).q(this.f22670i).n(this.f22671j).c();
        }

        public final void e(BufferedSink r10, List r11) {
            r10.writeDecimalLong(r11.size()).writeByte(10);     // Catch: CertificateEncodingException -> L6
            int r12 = r11.size();     // Catch: CertificateEncodingException -> L6
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L8;
            r10.writeUtf8(ByteString.of(((Certificate) r11.get(r13)).getEncoded()).base64()).writeByte(10);     // Catch: CertificateEncodingException -> L6
            r13 = r13 + 1;
            goto L3
        L8:
            return;
        L6:
            e = move-exception;
            throw new IOException(e.getMessage());
        }

        public void f(DiskLruCache.Editor r10) {
            int r11 = 0;
            BufferedSink r12 = fg.j.c(r10.newSink(0));
            r12.writeUtf8(this.f22662a).writeByte(10);
            r12.writeUtf8(this.f22664c).writeByte(10);
            r12.writeDecimalLong(this.f22663b.h()).writeByte(10);
            int r13 = this.f22663b.h();
            int r14 = 0;
        L4:
            if (r14 >= r13) goto L6;
            r12.writeUtf8(this.f22663b.d(r14)).writeUtf8(": ").writeUtf8(this.f22663b.j(r14)).writeByte(10);
            r14 = r14 + 1;
            goto L4
        L6:
            r12.writeUtf8(new StatusLine(this.f22665d, this.f22666e, this.f22667f).toString()).writeByte(10);
            r12.writeDecimalLong(this.f22668g.h() + 2).writeByte(10);
            int r15 = this.f22668g.h();
        L7:
            if (r11 >= r15) goto L9;
            r12.writeUtf8(this.f22668g.d(r11)).writeUtf8(": ").writeUtf8(this.f22668g.j(r11)).writeByte(10);
            r11 = r11 + 1;
            goto L7
        L9:
            r12.writeUtf8(f22660k).writeUtf8(": ").writeDecimalLong(this.f22670i).writeByte(10);
            r12.writeUtf8(f22661l).writeUtf8(": ").writeDecimalLong(this.f22671j).writeByte(10);
            if (a() == false) goto L12;
            r12.writeByte(10);
            r12.writeUtf8(this.f22669h.a().c()).writeByte(10);
            e(r12, this.f22669h.e());
            e(r12, this.f22669h.d());
            r12.writeUtf8(this.f22669h.f().javaName()).writeByte(10);
        L12:
            r12.close();
        }

        public e(Response r10) {
            this.f22662a = r10.r().k().toString();
            this.f22663b = HttpHeaders.varyHeaders(r10);
            this.f22664c = r10.r().g();
            this.f22665d = r10.p();
            this.f22666e = r10.d();
            this.f22667f = r10.l();
            this.f22668g = r10.i();
            this.f22669h = r10.e();
            this.f22670i = r10.s();
            this.f22671j = r10.q();
        }
    }

    public Cache(File r10, long r11) {
        this(r10, r11, FileSystem.SYSTEM);
    }

    private void abortQuietly(@Nullable DiskLruCache.Editor r10) {
        if (r10 == null) goto L8;
        r10.abort();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static String key(HttpUrl r10) {
        return ByteString.encodeUtf8(r10.toString()).md5().hex();
    }

    public static int readInt(BufferedSource r10) throws IOException {
        long r11 = r10.readDecimalLong();     // Catch: NumberFormatException -> L10
        String r12 = r10.readUtf8LineStrict();     // Catch: NumberFormatException -> L10
        if (r11 < 0) goto L13;
        if (r11 > 2147483647L) goto L13;
        if (r12.isEmpty() == false) goto L13;
        return (int) r11;
    L13:
        throw new IOException("expected an int but was \"" + r11 + r12 + "\"");     // Catch: NumberFormatException -> L10
    L10:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    public void delete() throws IOException {
        this.cache.delete();
    }

    public File directory() {
        return this.cache.getDirectory();
    }

    public void evictAll() throws IOException {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    @Nullable
    public Response get(Request r10) {
        String r11 = key(r10.k());
        DiskLruCache.Snapshot r12 = this.cache.get(r11);     // Catch: IOException -> L14
        if (r12 != null) goto L17;
        return null;
    L17:
        e r13 = new e(r12.getSource(0));     // Catch: IOException -> L12
        Response r14 = r13.d(r12);
        if (r13.b(r10, r14) == true) goto L11;
        Util.closeQuietly(r14.a());
        return null;
    L11:
        return r14;
    L12:
        Util.closeQuietly(r12);
    L13:
        return null;
    }

    public synchronized int hitCount() {
        monitor-enter(this);
        int r10 = this.hitCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public void initialize() throws IOException {
        this.cache.initialize();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    public long maxSize() {
        return this.cache.getMaxSize();
    }

    public synchronized int networkCount() {
        monitor-enter(this);
        int r10 = this.networkCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public CacheRequest put(Response r10) {
        String r11 = r10.r().g();
        if (HttpMethod.invalidatesCache(r10.r().g()) == false) goto L7;
        remove(r10.r());     // Catch: IOException -> L22
    L5:
        return null;
    L7:
        if (r11.equals("GET") == true) goto L10;
        return null;
    L10:
        if (HttpHeaders.hasVaryAll(r10) == false) goto L12;
        return null;
    L12:
        e r12 = new e(r10);
        DiskLruCache.Editor r13 = this.cache.edit(key(r10.r().k()));     // Catch: IOException -> L18
        if (r13 != null) goto L23;
        return null;
    L23:
        r12.f(r13);     // Catch: IOException -> L21
        return new c(this, r13);
    L19:
        abortQuietly(r13);
        return null;
    L18:
        r13 = null;
        goto L19
    }

    public void remove(Request r10) throws IOException {
        this.cache.remove(key(r10.k()));
    }

    public synchronized int requestCount() {
        monitor-enter(this);
        int r10 = this.requestCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public long size() throws IOException {
        return this.cache.size();
    }

    public synchronized void trackConditionalCacheHit() {
        monitor-enter(this);
        this.hitCount++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void trackResponse(CacheStrategy r10) {
        monitor-enter(this);
        this.requestCount++;     // Catch: Throwable -> L6
        if (r10.networkRequest == null) goto L9;
        this.networkCount++;     // Catch: Throwable -> L6
    L11:
        monitor-exit(this);
        return;
    L9:
        if (r10.cacheResponse == null) goto L11;
        this.hitCount++;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public void update(Response r10, Response r11) {
        e r12 = new e(r11);
        DiskLruCache.Editor r13 = ((d) r10.a()).f22654a.edit();     // Catch: IOException -> L7
        if (r13 == null) goto L15;
        r12.f(r13);     // Catch: IOException -> L10
        r13.commit();     // Catch: IOException -> L10
        return;
    L8:
        abortQuietly(r13);
        return;
    L15:
        return;
    L7:
        r13 = null;
        goto L8
    }

    public Iterator<String> urls() throws IOException {
        return new b(this);
    }

    public synchronized int writeAbortCount() {
        monitor-enter(this);
        int r10 = this.writeAbortCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int writeSuccessCount() {
        monitor-enter(this);
        int r10 = this.writeSuccessCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public Cache(File r10, long r11, FileSystem r12) {
        this.internalCache = new a(this);
        this.cache = DiskLruCache.create(r12, r10, VERSION, 2, r11);
    }
}
