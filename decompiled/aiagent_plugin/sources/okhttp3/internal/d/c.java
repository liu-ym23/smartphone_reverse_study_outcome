package okhttp3.internal.d;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.capabilitykit.common.Ext;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import e.aa;
import e.y;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.r;

/* JADX INFO: compiled from: Exchange.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f39860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r f39861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f39862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final okhttp3.internal.e.d f39863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f39864e;
    private boolean f;
    private final f g;

    /* JADX INFO: compiled from: Exchange.kt */
    private final class a extends e.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f39865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f39866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f39867c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f39868d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f39869e;

        public a(c r3, y r4, long r5) {
            y r6 = (y) ZeusTransformUtils.wrapperContextForParams(r4, y.class, "com.obric.aiagent.plugin");
            o.e(r6, "delegate");
            this.f39865a = r3;
            super(r6);
            this.f39866b = r5;
        }

        @Override // e.i, e.y
        public void a_(e.e r5, long r6) {
            o.e(r5, DBHelper.BATTERY_COL_SOURCE);
            if ((!this.f39869e) == false) goto L17;
            long r0 = this.f39866b;
            if (r0 != (-1)) goto L7;
        L18:
            super.a_(r5, r6);     // Catch: IOException -> L13
            this.f39868d += r6;     // Catch: IOException -> L13
            return;
        L13:
            e = move-exception;
            throw a(e);
        L7:
            if ((this.f39868d + r6) <= r0) goto L18;
            throw new ProtocolException("expected " + this.f39866b + " bytes but received " + (this.f39868d + r6));
        L17:
            throw new IllegalStateException("closed".toString());
        }

        @Override // e.i, e.y, java.io.Flushable
        public void flush() {
            super.flush();     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw a(e);
        }

        @Override // e.i, e.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f39869e == false) goto L5;
            return;
        L5:
            this.f39869e = true;
            long r0 = this.f39866b;
            if (r0 != (-1)) goto L8;
        L17:
            super.close();     // Catch: IOException -> L14
            a(null);     // Catch: IOException -> L14
            return;
        L14:
            e = move-exception;
            throw a(e);
        L8:
            if (this.f39868d == r0) goto L17;
            throw new ProtocolException("unexpected end of stream");
        }

        private final <E extends IOException> E a(E r8) {
            if (this.f39867c == false) goto L5;
            return r8;
        L5:
            this.f39867c = true;
            return (E) this.f39865a.a(this.f39868d, false, true, r8);
        }
    }

    /* JADX INFO: compiled from: Exchange.kt */
    public final class b extends e.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f39870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f39871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f39872c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f39873d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f39874e;
        private boolean f;

        public b(c r3, aa r4, long r5) {
            aa r6 = (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.aiagent.plugin");
            o.e(r6, "delegate");
            this.f39870a = r3;
            super(r6);
            this.f39871b = r5;
            this.f39873d = true;
            if (r5 != 0) goto L6;
            a(null);
            return;
        }

        @Override // e.j, e.aa
        public long a(e.e r8, long r9) {
            o.e(r8, "sink");
            if ((!this.f) == false) goto L26;
            long r10 = b().a(r8, r9);     // Catch: IOException -> L22
            if (this.f39873d == false) goto L8;
            this.f39873d = false;     // Catch: IOException -> L22
            this.f39870a.b().responseBodyStart((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39870a.a(), okhttp3.e.class, "com.obric.aiagent.plugin"));     // Catch: IOException -> L22
        L8:
            if (r10 != (-1)) goto L11;
            a(null);     // Catch: IOException -> L22
            return -1;
        L11:
            long r3 = this.f39872c + r10;     // Catch: IOException -> L22
            long r5 = this.f39871b;     // Catch: IOException -> L22
            if (r5 != (-1)) goto L14;
        L18:
            this.f39872c = r3;     // Catch: IOException -> L22
            if (r3 != r5) goto L21;
            a(null);     // Catch: IOException -> L22
        L21:
            return r10;
        L14:
            if (r3 <= r5) goto L18;
            throw new ProtocolException("expected " + this.f39871b + " bytes but received " + r3);     // Catch: IOException -> L22
        L22:
            e = move-exception;
            throw a(e);
        L26:
            throw new IllegalStateException("closed".toString());
        }

        @Override // e.j, e.aa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f == false) goto L5;
            return;
        L5:
            this.f = true;
            super.close();     // Catch: IOException -> L8
            a(null);     // Catch: IOException -> L8
            return;
        L8:
            e = move-exception;
            throw a(e);
        }

        public final <E extends IOException> E a(E r9) {
            if (this.f39874e == false) goto L5;
            return r9;
        L5:
            this.f39874e = true;
            if (r9 != null) goto L11;
            if (this.f39873d == false) goto L11;
            this.f39873d = false;
            this.f39870a.b().responseBodyStart((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39870a.a(), okhttp3.e.class, "com.obric.aiagent.plugin"));
        L11:
            return (E) this.f39870a.a(this.f39872c, true, false, r9);
        }
    }

    public c(e r3, r r4, d r5, okhttp3.internal.e.d r6) {
        okhttp3.internal.e.d r7 = (okhttp3.internal.e.d) ZeusTransformUtils.wrapperContextForParams(r6, okhttp3.internal.e.d.class, "com.obric.aiagent.plugin");
        o.e(r3, "call");
        o.e(r4, "eventListener");
        o.e(r5, "finder");
        o.e(r7, "codec");
        this.f39860a = r3;
        this.f39861b = r4;
        this.f39862c = r5;
        this.f39863d = r7;
        this.g = r7.a();
    }

    public final e a() {
        return this.f39860a;
    }

    public final r b() {
        return this.f39861b;
    }

    public final d c() {
        return this.f39862c;
    }

    public final boolean d() {
        return this.f39864e;
    }

    public final boolean e() {
        return this.f;
    }

    public final f f() {
        return this.g;
    }

    public final boolean g() {
        return !o.a(this.f39862c.a().i().b(), this.g.a().a().i().b());
    }

    public final void a(ab r5) {
        o.e(r5, Ext.KEY_REQUEST);
        this.f39861b.requestHeadersStart((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39860a, okhttp3.e.class, "com.obric.aiagent.plugin"));     // Catch: IOException -> L5
        this.f39863d.a(r5);     // Catch: IOException -> L5
        this.f39861b.requestHeadersEnd((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39860a, okhttp3.e.class, "com.obric.aiagent.plugin"), r5);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        this.f39861b.requestFailed((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39860a, okhttp3.e.class, "com.obric.aiagent.plugin"), e);
        a(e);
        throw e;
    }

    public final y a(ab r6, boolean r7) {
        o.e(r6, Ext.KEY_REQUEST);
        this.f39864e = r7;
        ac r8 = r6.d();
        o.a(r8);
        long r0 = r8.b();
        this.f39861b.requestBodyStart((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39860a, okhttp3.e.class, "com.obric.aiagent.plugin"));
        return (y) ZeusTransformUtils.preCheckCast(new a(this, this.f39863d.a(r6, r0), r0), y.class, "com.obric.aiagent.plugin");
    }

    public final void h() {
        this.f39863d.b();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.f39861b.requestFailed((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39860a, okhttp3.e.class, "com.obric.aiagent.plugin"), e);
        a(e);
        throw e;
    }

    public final void i() {
        this.f39863d.c();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.f39861b.requestFailed((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39860a, okhttp3.e.class, "com.obric.aiagent.plugin"), e);
        a(e);
        throw e;
    }

    public final void j() {
        this.f39861b.responseHeadersStart((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39860a, okhttp3.e.class, "com.obric.aiagent.plugin"));
    }

    public final ad.a a(boolean r5) {
        ad.a r6 = this.f39863d.a(r5);     // Catch: IOException -> L6
        if (r6 == null) goto L5;
        r6.a(this);     // Catch: IOException -> L6
    L5:
        return r6;
    L6:
        e = move-exception;
        this.f39861b.responseFailed((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39860a, okhttp3.e.class, "com.obric.aiagent.plugin"), e);
        a(e);
        throw e;
    }

    public final void a(ad r4) {
        o.e(r4, "response");
        this.f39861b.responseHeadersEnd((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39860a, okhttp3.e.class, "com.obric.aiagent.plugin"), r4);
    }

    public final ae b(ad r7) {
        o.e(r7, "response");
        String r1 = ad.a(r7, DownloadHelper.CONTENT_TYPE, null, 2, null);     // Catch: IOException -> L5
        long r2 = this.f39863d.a(r7);     // Catch: IOException -> L5
        return (ae) ZeusTransformUtils.preCheckCast(new okhttp3.internal.e.h(r1, r2, e.o.a((aa) ZeusTransformUtils.preCheckCast(new b(this, this.f39863d.b(r7), r2), aa.class, "com.obric.aiagent.plugin"))), ae.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        this.f39861b.responseFailed((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39860a, okhttp3.e.class, "com.obric.aiagent.plugin"), e);
        a(e);
        throw e;
    }

    public final void k() {
        this.f39863d.a().h();
    }

    public final void l() {
        this.f39863d.d();
    }

    public final void m() {
        this.f39863d.d();
        this.f39860a.a(this, true, true, null);
    }

    private final void a(IOException r2) {
        this.f = true;
        this.f39862c.a(r2);
        this.f39863d.a().a(this.f39860a, r2);
    }

    public final <E extends IOException> E a(long r5, boolean r7, boolean r8, E r9) {
        if (r9 == null) goto L5;
        a(r9);
    L5:
        if (r8 == false) goto L9;
        if (r9 == null) goto L8;
        this.f39861b.requestFailed((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39860a, okhttp3.e.class, "com.obric.aiagent.plugin"), r9);
        goto L9
    L8:
        this.f39861b.requestBodyEnd((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39860a, okhttp3.e.class, "com.obric.aiagent.plugin"), r5);
    L9:
        if (r7 == false) goto L14;
        if (r9 == null) goto L12;
        this.f39861b.responseFailed((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39860a, okhttp3.e.class, "com.obric.aiagent.plugin"), r9);
        goto L14
    L12:
        this.f39861b.responseBodyEnd((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39860a, okhttp3.e.class, "com.obric.aiagent.plugin"), r5);
    L14:
        return (E) this.f39860a.a(this, r8, r7, r9);
    }

    public final void n() {
        this.f39860a.a(this, true, false, null);
    }
}
