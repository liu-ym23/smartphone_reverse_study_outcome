package okhttp3.internal.f;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.Ext;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import e.aa;
import e.ab;
import e.k;
import e.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.ad;
import okhttp3.internal.e.i;
import okhttp3.n;
import okhttp3.u;
import okhttp3.v;
import okhttp3.z;

/* JADX INFO: compiled from: Http1ExchangeCodec.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements okhttp3.internal.e.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f39942b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final z f39943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final okhttp3.internal.d.f f39944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e.g f39945e;
    private final e.f f;
    private int g;
    private final okhttp3.internal.f.a h;
    private u i;

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    private abstract class a implements aa {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f39946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final k f39947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f39948c;

        public a(b r2) {
            this.f39946a = r2;
            this.f39947b = new k(b.b(r2).a());
        }

        public final void a(boolean r1) {
            this.f39948c = r1;
        }

        public final boolean b() {
            return this.f39948c;
        }

        @Override // e.aa
        public ab a() {
            return (ab) ZeusTransformUtils.preCheckCast(this.f39947b, ab.class, "com.obric.aiagent.plugin");
        }

        @Override // e.aa
        public long a(e.e r2, long r3) {
            o.e(r2, "sink");
            return b.b(this.f39946a).a(r2, r3);
        L5:
            e = move-exception;
            this.f39946a.a().h();
            c();
            throw e;
        }

        public final void c() {
            if (b.c(this.f39946a) != 6) goto L6;
            return;
        L6:
            if (b.c(this.f39946a) != 5) goto L10;
            b.a(this.f39946a, this.f39947b);
            b.a(this.f39946a, 6);
            return;
        L10:
            throw new IllegalStateException("state: " + b.c(this.f39946a));
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.f.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    private final class C1077b implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f39949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final k f39950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f39951c;

        public C1077b(b r2) {
            this.f39949a = r2;
            this.f39950b = new k(b.a(r2).a());
        }

        @Override // e.y
        public ab a() {
            return (ab) ZeusTransformUtils.preCheckCast(this.f39950b, ab.class, "com.obric.aiagent.plugin");
        }

        @Override // e.y
        public void a_(e.e r3, long r4) {
            o.e(r3, DBHelper.BATTERY_COL_SOURCE);
            if ((!this.f39951c) == false) goto L10;
            if (r4 != 0) goto L7;
            return;
        L7:
            b.a(this.f39949a).o(r4);
            b.a(this.f39949a).b("\r\n");
            b.a(this.f39949a).a_(r3, r4);
            b.a(this.f39949a).b("\r\n");
            return;
        L10:
            throw new IllegalStateException("closed".toString());
        }

        @Override // e.y, java.io.Flushable
        public synchronized void flush() {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.f39951c == false) goto L7;
            monitor-exit(this);
            return;
        L7:
            b.a(this.f39949a).flush();     // Catch: Throwable -> L10
            monitor-exit(this);
        }

        @Override // e.y, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.f39951c == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.f39951c = true;     // Catch: Throwable -> L11
            b.a(this.f39949a).b("0\r\n\r\n");     // Catch: Throwable -> L11
            b.a(this.f39949a, this.f39950b);     // Catch: Throwable -> L11
            b.a(this.f39949a, 3);     // Catch: Throwable -> L11
            monitor-exit(this);
        }
    }

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    private final class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f39952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final v f39953c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f39954d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f39955e;

        public c(b r2, v r3) {
            o.e(r3, "url");
            this.f39952b = r2;
            super(r2);
            this.f39953c = r3;
            this.f39954d = -1;
            this.f39955e = true;
        }

        @Override // okhttp3.internal.f.b.a, e.aa
        public long a(e.e r8, long r9) {
            o.e(r8, "sink");
            if (r9 < 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L28;
            if ((!b()) == false) goto L26;
            if (this.f39955e == true) goto L12;
            return -1;
        L12:
            long r5 = this.f39954d;
            if (r5 != 0) goto L15;
        L16:
            d();
            if (this.f39955e == true) goto L19;
            return -1;
        L19:
            long r10 = super.a(r8, Math.min(r9, this.f39954d));
            if (r10 == (-1)) goto L23;
            this.f39954d -= r10;
            return r10;
        L23:
            this.f39952b.a().h();
            ProtocolException r11 = new ProtocolException("unexpected end of stream");
            c();
            throw r11;
        L15:
            if (r5 != (-1)) goto L19;
        L26:
            throw new IllegalStateException("closed".toString());
        L28:
            throw new IllegalArgumentException(("byteCount < 0: " + r9).toString());
        L5:
            r2 = false;
            goto L6
        }

        private final void d() {
            if (this.f39954d == (-1)) goto L23;
            b.b(this.f39952b).v();
        L23:
            this.f39954d = b.b(this.f39952b).s();     // Catch: NumberFormatException -> L20
            String r1 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(b.b(this.f39952b).v(), CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: NumberFormatException -> L20
            if (this.f39954d < 0) goto L19;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L10;
            boolean r0 = true;
        L11:
            if (r0 == false) goto L15;
            if (d.o.o.b(r1, ";", false, 2, null) == false) goto L19;
        L15:
            if (this.f39954d != 0) goto L25;
            this.f39955e = false;
            b r2 = this.f39952b;
            b.a(r2, b.d(r2).b());
            z r3 = b.e(this.f39952b);
            o.a(r3);
            n r4 = r3.j();
            v r5 = this.f39953c;
            u r6 = b.f(this.f39952b);
            o.a(r6);
            okhttp3.internal.e.e.a(r4, r5, r6);
            c();
            return;
        L25:
            return;
        L10:
            r0 = false;
        L19:
            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f39954d + r1 + '\"');     // Catch: NumberFormatException -> L20
        L20:
            e = move-exception;
            throw new ProtocolException(e.getMessage());
        }

        @Override // e.aa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (b() == false) goto L6;
            return;
        L6:
            if (this.f39955e == true) goto L8;
        L10:
            a(true);
            return;
        L8:
            if (okhttp3.internal.c.b((aa) ZeusTransformUtils.preCheckCast(this, aa.class, "com.obric.aiagent.plugin"), 100, TimeUnit.MILLISECONDS) == true) goto L10;
            this.f39952b.a().h();
            c();
            goto L10
        }
    }

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    public static final class d {
        public /* synthetic */ d(h r1) {
            this();
        }

        private d() {
        }
    }

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    private final class e extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f39956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f39957c;

        public e(b r3, long r4) {
            this.f39956b = r3;
            super(r3);
            this.f39957c = r4;
            if (r4 != 0) goto L6;
            c();
            return;
        }

        @Override // okhttp3.internal.f.b.a, e.aa
        public long a(e.e r8, long r9) {
            o.e(r8, "sink");
            if (r9 < 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L23;
            if ((!b()) == false) goto L21;
            long r3 = this.f39957c;
            if (r3 != 0) goto L12;
            return -1;
        L12:
            long r10 = super.a(r8, Math.min(r3, r9));
            if (r10 == (-1)) goto L18;
            long r4 = this.f39957c - r10;
            this.f39957c = r4;
            if (r4 != 0) goto L17;
            c();
        L17:
            return r10;
        L18:
            this.f39956b.a().h();
            ProtocolException r11 = new ProtocolException("unexpected end of stream");
            c();
            throw r11;
        L21:
            throw new IllegalStateException("closed".toString());
        L23:
            throw new IllegalArgumentException(("byteCount < 0: " + r9).toString());
        L5:
            r2 = false;
            goto L6
        }

        @Override // e.aa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (b() == false) goto L6;
            return;
        L6:
            if (this.f39957c != 0) goto L8;
        L10:
            a(true);
            return;
        L8:
            if (okhttp3.internal.c.b((aa) ZeusTransformUtils.preCheckCast(this, aa.class, "com.obric.aiagent.plugin"), 100, TimeUnit.MILLISECONDS) == true) goto L10;
            this.f39956b.a().h();
            c();
            goto L10
        }
    }

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    private final class f implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f39958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final k f39959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f39960c;

        public f(b r2) {
            this.f39958a = r2;
            this.f39959b = new k(b.a(r2).a());
        }

        @Override // e.y
        public ab a() {
            return (ab) ZeusTransformUtils.preCheckCast(this.f39959b, ab.class, "com.obric.aiagent.plugin");
        }

        @Override // e.y
        public void a_(e.e r8, long r9) {
            o.e(r8, DBHelper.BATTERY_COL_SOURCE);
            if ((!this.f39960c) == false) goto L7;
            okhttp3.internal.c.a(r8.b(), 0, r9);
            b.a(this.f39958a).a_(r8, r9);
            return;
        L7:
            throw new IllegalStateException("closed".toString());
        }

        @Override // e.y, java.io.Flushable
        public void flush() {
            if (this.f39960c == false) goto L5;
            return;
        L5:
            b.a(this.f39958a).flush();
        }

        @Override // e.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f39960c == false) goto L5;
            return;
        L5:
            this.f39960c = true;
            b.a(this.f39958a, this.f39959b);
            b.a(this.f39958a, 3);
        }
    }

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    private final class g extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f39961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f39962c;

        public g(b r1) {
            this.f39961b = r1;
            super(r1);
        }

        @Override // okhttp3.internal.f.b.a, e.aa
        public long a(e.e r5, long r6) {
            o.e(r5, "sink");
            if (r6 < 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L20;
            if ((!b()) == false) goto L18;
            if (this.f39962c == false) goto L12;
            return -1;
        L12:
            long r7 = super.a(r5, r6);
            if (r7 != (-1)) goto L16;
            this.f39962c = true;
            c();
            return -1;
        L16:
            return r7;
        L18:
            throw new IllegalStateException("closed".toString());
        L20:
            throw new IllegalArgumentException(("byteCount < 0: " + r6).toString());
        L5:
            r0 = false;
            goto L6
        }

        @Override // e.aa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (b() == false) goto L6;
            return;
        L6:
            if (this.f39962c == true) goto L8;
            c();
        L8:
            a(true);
        }
    }

    static {
        f39942b = new d(null);
    }

    public b(z r3, okhttp3.internal.d.f r4, e.g r5, e.f r6) {
        e.g r7 = (e.g) ZeusTransformUtils.wrapperContextForParams(r5, e.g.class, "com.obric.aiagent.plugin");
        e.f r8 = (e.f) ZeusTransformUtils.wrapperContextForParams(r6, e.f.class, "com.obric.aiagent.plugin");
        o.e(r4, WsConstants.KEY_CONNECTION);
        o.e(r7, DBHelper.BATTERY_COL_SOURCE);
        o.e(r8, "sink");
        this.f39943c = r3;
        this.f39944d = r4;
        this.f39945e = r7;
        this.f = r8;
        this.h = new okhttp3.internal.f.a(r7);
    }

    public static final /* synthetic */ e.f a(b r0) {
        return r0.f;
    }

    public static final /* synthetic */ void a(b r0, int r1) {
        r0.g = r1;
    }

    public static final /* synthetic */ void a(b r0, k r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(b r0, u r1) {
        r0.i = r1;
    }

    public static final /* synthetic */ e.g b(b r0) {
        return r0.f39945e;
    }

    public static final /* synthetic */ int c(b r0) {
        return r0.g;
    }

    public static final /* synthetic */ okhttp3.internal.f.a d(b r0) {
        return r0.h;
    }

    public static final /* synthetic */ z e(b r0) {
        return r0.f39943c;
    }

    public static final /* synthetic */ u f(b r0) {
        return r0.i;
    }

    @Override // okhttp3.internal.e.d
    public okhttp3.internal.d.f a() {
        return this.f39944d;
    }

    private final boolean d(ad r3) {
        return d.o.o.a(DownloadHelper.VALUE_CHUNKED, ad.a(r3, DownloadHelper.TRANSFER_ENCODING, null, 2, null), true);
    }

    private final boolean b(okhttp3.ab r2) {
        return d.o.o.a(DownloadHelper.VALUE_CHUNKED, r2.a(DownloadHelper.TRANSFER_ENCODING), true);
    }

    @Override // okhttp3.internal.e.d
    public y a(okhttp3.ab r3, long r4) {
        o.e(r3, Ext.KEY_REQUEST);
        if (r3.d() == null) goto L10;
        if (r3.d().d() == false) goto L10;
        throw new ProtocolException("Duplex connections are not supported for HTTP/1");
    L10:
        if (b(r3) == false) goto L13;
        return e();
    L13:
        if (r4 == (-1)) goto L17;
        return f();
    L17:
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.e.d
    public void d() {
        a().k();
    }

    @Override // okhttp3.internal.e.d
    public void a(okhttp3.ab r4) {
        o.e(r4, Ext.KEY_REQUEST);
        i r0 = i.f39932a;
        Proxy.Type r1 = a().a().b().type();
        o.c(r1, "connection.route().proxy.type()");
        String r2 = r0.a(r4, r1);
        a(r4.c(), r2);
    }

    @Override // okhttp3.internal.e.d
    public long a(ad r2) {
        o.e(r2, "response");
        if (okhttp3.internal.e.e.a(r2) == true) goto L6;
        return 0;
    L6:
        if (d(r2) == false) goto L9;
        return -1;
    L9:
        return okhttp3.internal.c.a(r2);
    }

    @Override // okhttp3.internal.e.d
    public aa b(ad r5) {
        o.e(r5, "response");
        if (okhttp3.internal.e.e.a(r5) == true) goto L6;
        return a(0);
    L6:
        if (d(r5) == true) goto L14;
        long r0 = okhttp3.internal.c.a(r5);
        if (r0 == (-1)) goto L12;
        return a(r0);
    L12:
        return g();
    L14:
        return a(r5.a().a());
    }

    @Override // okhttp3.internal.e.d
    public void b() {
        this.f.flush();
    }

    @Override // okhttp3.internal.e.d
    public void c() {
        this.f.flush();
    }

    public final void a(u r6, String r7) {
        o.e(r6, "headers");
        o.e(r7, "requestLine");
        int r1 = 0;
        if (this.g != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        this.f.b(r7).b("\r\n");
        int r8 = r6.a();
    L8:
        if (r1 >= r8) goto L10;
        this.f.b(r6.a(r1)).b(": ").b(r6.b(r1)).b("\r\n");
        r1 = r1 + 1;
        goto L8
    L10:
        this.f.b("\r\n");
        this.g = 1;
        return;
    L13:
        throw new IllegalStateException(("state: " + this.g).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okhttp3.internal.e.d
    public ad.a a(boolean r7) {
        int r0 = this.g;
        boolean r1 = false;
        if (r0 != 1) goto L5;
    L9:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L32;
        okhttp3.internal.e.k r3 = okhttp3.internal.e.k.f39935a.a(this.h.a());     // Catch: EOFException -> L28
        ad.a r4 = new ad.a().a(r3.f39936b).a(r3.f39937c).a(r3.f39938d).a(this.h.b());     // Catch: EOFException -> L28
        if (r7 == false) goto L17;
        if (r3.f39937c != 100) goto L17;
        return null;
    L17:
        if (r3.f39937c != 100) goto L19;
        this.g = 3;     // Catch: EOFException -> L28
        return r4;
    L19:
        int r8 = r3.f39937c;     // Catch: EOFException -> L28
        if (102 <= r8) goto L22;
    L24:
        if (r1 == false) goto L26;
        this.g = 3;     // Catch: EOFException -> L28
        return r4;
    L26:
        this.g = 4;     // Catch: EOFException -> L28
        return r4;
    L22:
        if (r8 >= 200) goto L24;
        r1 = true;
    L28:
        e = move-exception;
        throw new IOException("unexpected end of stream on " + a().a().a().i().m(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L32:
        throw new IllegalStateException(("state: " + this.g).toString());
    L5:
        if (r0 == 2) goto L9;
        if (r0 == 3) goto L9;
        r2 = false;
        goto L10
    }

    private final y e() {
        boolean r1 = true;
        if (this.g == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L10;
        this.g = 2;
        return (y) ZeusTransformUtils.preCheckCast(new C1077b(this), y.class, "com.obric.aiagent.plugin");
    L10:
        throw new IllegalStateException(("state: " + this.g).toString());
    }

    private final y f() {
        boolean r1 = true;
        if (this.g == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L10;
        this.g = 2;
        return (y) ZeusTransformUtils.preCheckCast(new f(this), y.class, "com.obric.aiagent.plugin");
    L10:
        throw new IllegalStateException(("state: " + this.g).toString());
    }

    private final aa a(long r3) {
        if (this.g != 4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.g = 5;
        return (aa) ZeusTransformUtils.preCheckCast(new e(this, r3), aa.class, "com.obric.aiagent.plugin");
    L10:
        throw new IllegalStateException(("state: " + this.g).toString());
    L5:
        r0 = false;
        goto L6
    }

    private final aa a(v r3) {
        if (this.g != 4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.g = 5;
        return (aa) ZeusTransformUtils.preCheckCast(new c(this, r3), aa.class, "com.obric.aiagent.plugin");
    L10:
        throw new IllegalStateException(("state: " + this.g).toString());
    L5:
        r0 = false;
        goto L6
    }

    private final aa g() {
        if (this.g != 4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.g = 5;
        a().h();
        return (aa) ZeusTransformUtils.preCheckCast(new g(this), aa.class, "com.obric.aiagent.plugin");
    L10:
        throw new IllegalStateException(("state: " + this.g).toString());
    L5:
        r0 = false;
        goto L6
    }

    private final void a(k r2) {
        ab r1 = r2.a();
        r2.a(ab.f38700d);
        r1.w_();
        r1.v_();
    }

    public final void c(ad r5) {
        o.e(r5, "response");
        long r0 = okhttp3.internal.c.a(r5);
        if (r0 != (-1)) goto L5;
        return;
    L5:
        aa r4 = a(r0);
        okhttp3.internal.c.a(r4, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        r4.close();
    }
}
