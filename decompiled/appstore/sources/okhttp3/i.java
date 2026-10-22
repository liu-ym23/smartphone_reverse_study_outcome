package okhttp3;

import android.text.TextUtils;
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
import java.util.List;
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
public final class i implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InternalCache f22967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DiskLruCache f22968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f22971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f22972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f22973g;

    public class a implements InternalCache {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f22974a;

        public a(i r10) {
            this.f22974a = r10;
        }

        @Override // okhttp3.internal.cache.InternalCache
        public Response get(Request r10) {
            return this.f22974a.b(r10);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public CacheRequest put(Response r10) {
            return this.f22974a.d(r10);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void remove(Request r10) {
            this.f22974a.f(r10);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void trackConditionalCacheHit() {
            this.f22974a.g();
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void trackResponse(CacheStrategy r10) {
            this.f22974a.h(r10);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void update(Response r10, Response r11) {
            this.f22974a.i(r10, r11);
        }
    }

    public final class b implements CacheRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DiskLruCache.Editor f22975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Sink f22976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Sink f22977c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f22978d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ i f22979e;

        public class a extends fg.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f22980a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ DiskLruCache.Editor f22981b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f22982c;

            public a(b r10, Sink r11, i r12, DiskLruCache.Editor r13) {
                this.f22982c = r10;
                this.f22980a = r12;
                this.f22981b = r13;
                super(r11);
            }

            @Override // fg.e, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                i r10 = this.f22982c.f22979e;
                monitor-enter(r10);
                b r11 = this.f22982c;     // Catch: Throwable -> L8
                if (r11.f22978d == false) goto L10;
                monitor-exit(r10);     // Catch: Throwable -> L8
                return;
            L10:
                r11.f22978d = true;     // Catch: Throwable -> L8
                r11.f22979e.f22969c++;     // Catch: Throwable -> L8
                monitor-exit(r10);     // Catch: Throwable -> L8
                super.close();
                this.f22981b.commit();
                return;
            L8:
                th = move-exception;
                throw th;
            }
        }

        public b(i r10, DiskLruCache.Editor r11) {
            this.f22979e = r10;
            this.f22975a = r11;
            Sink r12 = r11.newSink(1);
            this.f22976b = r12;
            this.f22977c = new a(this, r12, r10, r11);
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            i r10 = this.f22979e;
            monitor-enter(r10);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.f22978d == false) goto L10;
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L10:
            this.f22978d = true;     // Catch: Throwable -> L8
            this.f22979e.f22970d++;     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            Util.closeQuietly(this.f22976b);
            this.f22975a.abort();     // Catch: IOException -> L17
            return;
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public Sink body() {
            return this.f22977c;
        }
    }

    public static class c extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DiskLruCache.Snapshot f22983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BufferedSource f22984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f22985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f22986d;

        public class a extends fg.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DiskLruCache.Snapshot f22987a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f22988b;

            public a(c r10, Source r11, DiskLruCache.Snapshot r12) {
                this.f22988b = r10;
                this.f22987a = r12;
                super(r11);
            }

            @Override // fg.f, okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                this.f22987a.close();
                super.close();
            }
        }

        public c(DiskLruCache.Snapshot r10, String r11, String r12) {
            this.f22983a = r10;
            this.f22985c = r11;
            this.f22986d = r12;
            this.f22984b = fg.j.d(new a(this, r10.getSource(1), r10));
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String r10 = this.f22986d;     // Catch: NumberFormatException -> L7
            if (r10 == null) goto L10;
            return Long.parseLong(r10);
        L10:
            return -1;
        L11:
            return -1;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String r10 = this.f22985c;
            if (r10 != null) goto L7;
            return null;
        L7:
            return MediaType.c(r10);
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return this.f22984b;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f22989k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f22990l = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Headers f22992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f22993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Protocol f22994d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f22995e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f22996f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Headers f22997g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Handshake f22998h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f22999i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f23000j;

        public class a extends RequestBody {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f23001a;

            public a(d r10) {
                this.f23001a = r10;
            }

            @Override // okhttp3.RequestBody
            public MediaType b() {
                return null;
            }

            @Override // okhttp3.RequestBody
            public void g(BufferedSink r10) {
            }
        }

        static {
            f22989k = Platform.get().getPrefix() + "-Sent-Millis";
            f22990l = Platform.get().getPrefix() + "-Received-Millis";
        }

        public d(Source r10) {
            BufferedSource r11 = fg.j.d(r10);     // Catch: Throwable -> L6
            this.f22991a = r11.readUtf8LineStrict();     // Catch: Throwable -> L6
            this.f22993c = r11.readUtf8LineStrict();     // Catch: Throwable -> L6
            Headers.Builder r12 = new Headers.Builder();     // Catch: Throwable -> L6
            int r13 = i.e(r11);     // Catch: Throwable -> L6
            int r14 = 0;
            int r15 = 0;
        L4:
            if (r15 >= r13) goto L8;
            r12.b(r11.readUtf8LineStrict());     // Catch: Throwable -> L6
            r15 = r15 + 1;     // Catch: Throwable -> L6
            goto L4
        L8:
            this.f22992b = r12.d();     // Catch: Throwable -> L6
            StatusLine r16 = StatusLine.parse(r11.readUtf8LineStrict());     // Catch: Throwable -> L6
            this.f22994d = r16.protocol;     // Catch: Throwable -> L6
            this.f22995e = r16.code;     // Catch: Throwable -> L6
            this.f22996f = r16.message;     // Catch: Throwable -> L6
            Headers.Builder r17 = new Headers.Builder();     // Catch: Throwable -> L6
            int r18 = i.e(r11);     // Catch: Throwable -> L6
        L9:
            if (r14 >= r18) goto L11;
            r17.b(r11.readUtf8LineStrict());     // Catch: Throwable -> L6
            r14 = r14 + 1;     // Catch: Throwable -> L6
            goto L9
        L11:
            String r19 = f22989k;     // Catch: Throwable -> L6
            String r20 = r17.f(r19);     // Catch: Throwable -> L6
            String r21 = f22990l;     // Catch: Throwable -> L6
            String r22 = r17.f(r21);     // Catch: Throwable -> L6
            r17.g(r19);     // Catch: Throwable -> L6
            r17.g(r21);     // Catch: Throwable -> L6
            long r23 = 0;
            if (r20 == null) goto L14;
            long r24 = Long.parseLong(r20);     // Catch: Throwable -> L6
        L15:
            this.f22999i = r24;     // Catch: Throwable -> L6
            if (r22 == null) goto L18;
            r23 = Long.parseLong(r22);     // Catch: Throwable -> L6
        L18:
            this.f23000j = r23;     // Catch: Throwable -> L6
            this.f22997g = r17.d();     // Catch: Throwable -> L6
            if (a() == false) goto L29;
            String r25 = r11.readUtf8LineStrict();     // Catch: Throwable -> L6
            if (r25.length() > 0) goto L28;
            okhttp3.d r26 = okhttp3.d.a(r11.readUtf8LineStrict());     // Catch: Throwable -> L6
            List r27 = c(r11);     // Catch: Throwable -> L6
            List r28 = c(r11);     // Catch: Throwable -> L6
            if (r11.exhausted() == true) goto L25;
            TlsVersion r29 = TlsVersion.forJavaName(r11.readUtf8LineStrict());     // Catch: Throwable -> L6
        L26:
            this.f22998h = Handshake.c(r29, r26, r27, r28);     // Catch: Throwable -> L6
        L30:
            r10.close();
            return;
        L25:
            r29 = TlsVersion.SSL_3_0;     // Catch: Throwable -> L6
            goto L26
        L28:
            throw new IOException("expected \"\" but was \"" + r25 + "\"");     // Catch: Throwable -> L6
        L29:
            this.f22998h = null;     // Catch: Throwable -> L6
            goto L30
        L14:
            r24 = 0;
        L6:
            th = move-exception;
            r10.close();
            throw th;
        }

        public final boolean a() {
            return this.f22991a.startsWith("https://");
        }

        public boolean b(Request r10, Response r11) {
            if (this.f22991a.equals(r10.k().toString()) == true) goto L5;
        L9:
            return false;
        L5:
            if (this.f22993c.equals(r10.g()) == false) goto L9;
            if (HttpHeaders.varyMatches(r11, this.f22992b, r10) == false) goto L9;
            return true;
        }

        public final List c(BufferedSource r10) {
            int r11 = i.e(r10);
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
            String r11 = this.f22997g.b("Content-Type");
            String r12 = this.f22997g.b("Content-Length");
            if (HttpMethod.requiresRequestBody(this.f22993c) == false) goto L5;
            a r13 = new a(this);
        L6:
            Request r14 = new Request.a().j(this.f22991a).f(this.f22993c, r13).e(this.f22992b).b();
            return new Response.Builder().p(r14).m(this.f22994d).g(this.f22995e).j(this.f22996f).i(this.f22997g).b(new c(r10, r11, r12)).h(this.f22998h).q(this.f22999i).n(this.f23000j).c();
        L5:
            r13 = null;
            goto L6
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
            r12.writeUtf8(this.f22991a).writeByte(10);
            r12.writeUtf8(this.f22993c).writeByte(10);
            r12.writeDecimalLong(this.f22992b.h()).writeByte(10);
            int r13 = this.f22992b.h();
            int r14 = 0;
        L4:
            if (r14 >= r13) goto L6;
            r12.writeUtf8(this.f22992b.d(r14)).writeUtf8(": ").writeUtf8(this.f22992b.j(r14)).writeByte(10);
            r14 = r14 + 1;
            goto L4
        L6:
            r12.writeUtf8(new StatusLine(this.f22994d, this.f22995e, this.f22996f).toString()).writeByte(10);
            r12.writeDecimalLong(this.f22997g.h() + 2).writeByte(10);
            int r15 = this.f22997g.h();
        L7:
            if (r11 >= r15) goto L9;
            r12.writeUtf8(this.f22997g.d(r11)).writeUtf8(": ").writeUtf8(this.f22997g.j(r11)).writeByte(10);
            r11 = r11 + 1;
            goto L7
        L9:
            r12.writeUtf8(f22989k).writeUtf8(": ").writeDecimalLong(this.f22999i).writeByte(10);
            r12.writeUtf8(f22990l).writeUtf8(": ").writeDecimalLong(this.f23000j).writeByte(10);
            if (a() == false) goto L12;
            r12.writeByte(10);
            r12.writeUtf8(this.f22998h.a().c()).writeByte(10);
            e(r12, this.f22998h.e());
            e(r12, this.f22998h.d());
            r12.writeUtf8(this.f22998h.f().javaName()).writeByte(10);
        L12:
            r12.close();
        }

        public d(Response r10) {
            this.f22991a = r10.r().k().toString();
            this.f22992b = HttpHeaders.varyHeaders(r10);
            this.f22993c = r10.r().g();
            this.f22994d = r10.p();
            this.f22995e = r10.d();
            this.f22996f = r10.l();
            this.f22997g = r10.i();
            this.f22998h = r10.e();
            this.f22999i = r10.s();
            this.f23000j = r10.q();
        }
    }

    public i(File r10, long r11) {
        this(r10, r11, FileSystem.SYSTEM);
    }

    public static String c(HttpUrl r10) {
        return ByteString.encodeUtf8(r10.toString()).md5().hex();
    }

    public static int e(BufferedSource r10) {
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

    public final void a(DiskLruCache.Editor r10) {
        if (r10 == null) goto L8;
        r10.abort();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public Response b(Request r10) {
        String r11 = c(r10.k());
        DiskLruCache.Snapshot r12 = this.f22968b.get(r11);     // Catch: IOException -> L14
        if (r12 != null) goto L17;
        return null;
    L17:
        d r13 = new d(r12.getSource(0));     // Catch: IOException -> L12
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f22968b.close();
    }

    public CacheRequest d(Response r10) {
        if (TextUtils.isEmpty(r10.f("Cache-Control")) == false) goto L6;
        return null;
    L6:
        if (HttpHeaders.hasVaryAll(r10) == false) goto L8;
        return null;
    L8:
        d r11 = new d(r10);
        DiskLruCache.Editor r12 = this.f22968b.edit(c(r10.r().k()));     // Catch: IOException -> L14
        if (r12 != null) goto L18;
        return null;
    L18:
        r11.f(r12);     // Catch: IOException -> L17
        return new b(this, r12);
    L15:
        a(r12);
        return null;
    L14:
        r12 = null;
        goto L15
    }

    public void f(Request r10) {
        this.f22968b.remove(c(r10.k()));
    }

    @Override // java.io.Flushable
    public void flush() {
        this.f22968b.flush();
    }

    public synchronized void g() {
        monitor-enter(this);
        this.f22972f++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void h(CacheStrategy r10) {
        monitor-enter(this);
        this.f22973g++;     // Catch: Throwable -> L6
        if (r10.networkRequest == null) goto L9;
        this.f22971e++;     // Catch: Throwable -> L6
    L11:
        monitor-exit(this);
        return;
    L9:
        if (r10.cacheResponse == null) goto L11;
        this.f22972f++;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public void i(Response r10, Response r11) {
        d r12 = new d(r11);
        DiskLruCache.Editor r13 = ((c) r10.a()).f22983a.edit();     // Catch: IOException -> L7
        if (r13 == null) goto L15;
        r12.f(r13);     // Catch: IOException -> L10
        r13.commit();     // Catch: IOException -> L10
        return;
    L8:
        a(r13);
        return;
    L15:
        return;
    L7:
        r13 = null;
        goto L8
    }

    public i(File r10, long r11, FileSystem r12) {
        this.f22967a = new a(this);
        this.f22968b = DiskLruCache.create(r12, r10, 201105, 2, r11);
    }
}
