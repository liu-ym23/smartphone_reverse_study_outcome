package okhttp3;

import com.obric.capabilitykit.common.Ext;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.List;

/* JADX INFO: compiled from: Response.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ad implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ab f39712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final aa f39713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f39714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f39715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final t f39716e;
    private final u f;
    private final ae g;
    private final ad h;
    private final ad i;
    private final ad j;
    private final long k;
    private final long l;
    private final okhttp3.internal.d.c m;
    private d n;

    /* JADX INFO: compiled from: Response.kt */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ab f39717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private aa f39718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f39719c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f39720d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private t f39721e;
        private u.a f;
        private ae g;
        private ad h;
        private ad i;
        private ad j;
        private long k;
        private long l;
        private okhttp3.internal.d.c m;

        public final int a() {
            return this.f39719c;
        }

        public a() {
            this.f39719c = -1;
            this.f = new u.a();
        }

        public a(ad r3) {
            d.h.b.o.e(r3, "response");
            this.f39719c = -1;
            this.f39717a = r3.a();
            this.f39718b = r3.b();
            this.f39719c = r3.d();
            this.f39720d = r3.c();
            this.f39721e = r3.e();
            this.f = r3.f().d();
            this.g = r3.g();
            this.h = r3.h();
            this.i = r3.i();
            this.j = r3.j();
            this.k = r3.k();
            this.l = r3.l();
            this.m = r3.m();
        }

        public a a(ab r4) {
            d.h.b.o.e(r4, Ext.KEY_REQUEST);
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f39717a = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public a a(aa r4) {
            d.h.b.o.e(r4, MonitorConstants.PROTOCOL);
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f39718b = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public a a(int r4) {
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f39719c = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public a a(String r4) {
            d.h.b.o.e(r4, "message");
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f39720d = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public a a(t r4) {
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f39721e = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public a a(String r4, String r5) {
            d.h.b.o.e(r4, "name");
            d.h.b.o.e(r5, "value");
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f.c(r4, r5);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public a b(String r4, String r5) {
            d.h.b.o.e(r4, "name");
            d.h.b.o.e(r5, "value");
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f.a(r4, r5);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public a a(u r4) {
            d.h.b.o.e(r4, "headers");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            r2.f = r4.d();
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public a a(ae r4) {
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).g = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public a a(ad r5) {
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            r2.a("networkResponse", r5);
            r2.h = r5;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public a b(ad r5) {
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            r2.a("cacheResponse", r5);
            r2.i = r5;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        private final void a(String r3, ad r4) {
            if (r4 == null) goto L32;
            boolean r0 = true;
            if (r4.g() != null) goto L6;
            boolean r2 = true;
        L7:
            if (r2 == false) goto L31;
            if (r4.h() != null) goto L11;
            boolean r5 = true;
        L12:
            if (r5 == false) goto L29;
            if (r4.i() != null) goto L16;
            boolean r6 = true;
        L17:
            if (r6 == false) goto L27;
            if (r4.j() == null) goto L22;
            r0 = false;
        L22:
            if (r0 == false) goto L25;
            return;
        L25:
            throw new IllegalArgumentException((r3 + ".priorResponse != null").toString());
        L27:
            throw new IllegalArgumentException((r3 + ".cacheResponse != null").toString());
        L16:
            r6 = false;
            goto L17
        L29:
            throw new IllegalArgumentException((r3 + ".networkResponse != null").toString());
        L11:
            r5 = false;
            goto L12
        L31:
            throw new IllegalArgumentException((r3 + ".body != null").toString());
        L6:
            r2 = false;
            goto L7
        }

        public a c(ad r4) {
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            r2.d(r4);
            r2.j = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        private final void d(ad r1) {
            if (r1 != null) goto L4;
            return;
        L4:
            if (r1.g() != null) goto L6;
            boolean r0 = true;
        L7:
            if (r0 == false) goto L10;
            return;
        L10:
            throw new IllegalArgumentException("priorResponse.body != null".toString());
        L6:
            r0 = false;
            goto L7
        }

        public a a(long r4) {
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).k = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public a b(long r4) {
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).l = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final void a(okhttp3.internal.d.c r2) {
            d.h.b.o.e(r2, "deferredTrailers");
            this.m = r2;
        }

        public ad b() {
            int r4 = this.f39719c;
            if (r4 < 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L22;
            ab r2 = this.f39717a;
            if (r2 == null) goto L20;
            aa r3 = this.f39718b;
            if (r3 == null) goto L18;
            String r5 = this.f39720d;
            if (r5 == null) goto L16;
            return new ad(r2, r3, r5, r4, this.f39721e, this.f.b(), this.g, this.h, this.i, this.j, this.k, this.l, this.m);
        L16:
            throw new IllegalStateException("message == null".toString());
        L18:
            throw new IllegalStateException("protocol == null".toString());
        L20:
            throw new IllegalStateException("request == null".toString());
        L22:
            throw new IllegalStateException(("code < 0: " + this.f39719c).toString());
        L5:
            r1 = false;
            goto L6
        }
    }

    public final String b(String r3) {
        d.h.b.o.e(r3, "name");
        return a(this, r3, null, 2, null);
    }

    public ad(ab r7, aa r8, String r9, int r10, t r11, u r12, ae r13, ad r14, ad r15, ad r16, long r17, long r19, okhttp3.internal.d.c r21) {
        d.h.b.o.e(r7, Ext.KEY_REQUEST);
        d.h.b.o.e(r8, MonitorConstants.PROTOCOL);
        d.h.b.o.e(r9, "message");
        d.h.b.o.e(r12, "headers");
        this.f39712a = r7;
        this.f39713b = r8;
        this.f39714c = r9;
        this.f39715d = r10;
        this.f39716e = r11;
        this.f = r12;
        this.g = r13;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r19;
        this.m = r21;
    }

    public final ab a() {
        return this.f39712a;
    }

    public final aa b() {
        return this.f39713b;
    }

    public final String c() {
        return this.f39714c;
    }

    public final int d() {
        return this.f39715d;
    }

    public final t e() {
        return this.f39716e;
    }

    public final u f() {
        return this.f;
    }

    public final ae g() {
        return this.g;
    }

    public final ad h() {
        return this.h;
    }

    public final ad i() {
        return this.i;
    }

    public final ad j() {
        return this.j;
    }

    public final long k() {
        return this.k;
    }

    public final long l() {
        return this.l;
    }

    public final okhttp3.internal.d.c m() {
        return this.m;
    }

    public final boolean n() {
        int r2 = this.f39715d;
        if (200 <= r2) goto L5;
        return false;
    L5:
        if (r2 >= 300) goto L9;
        return true;
    L9:
        return false;
    }

    public final List<String> a(String r2) {
        d.h.b.o.e(r2, "name");
        return this.f.b(r2);
    }

    public static /* synthetic */ String a(ad r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.a(r1, r2);
    }

    public final String a(String r2, String r3) {
        d.h.b.o.e(r2, "name");
        String r1 = this.f.a(r2);
        if (r1 != null) goto L6;
        return r3;
    L6:
        return r1;
    }

    public final a o() {
        return new a(this);
    }

    public final boolean p() {
        int r1 = this.f39715d;
        if (r1 != 307) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 308) goto L8;
        switch(r1) {
            case 300: goto L8;
            case 301: goto L8;
            case 302: goto L8;
            case 303: goto L8;
            default: goto L7;
        };
    L7:
        return false;
    }

    public final List<h> q() {
        u r0 = this.f;
        int r2 = this.f39715d;
        if (r2 != 401) goto L5;
        String r3 = "WWW-Authenticate";
    L11:
        return okhttp3.internal.e.e.a(r0, r3);
    L5:
        if (r2 != 407) goto L7;
        r3 = "Proxy-Authenticate";
        goto L11
    L7:
        return d.a.p.b();
    }

    public final d r() {
        d r0 = this.n;
        if (r0 != null) goto L6;
        d r1 = d.f39760a.a(this.f);
        this.n = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ae r1 = this.g;
        if (r1 == null) goto L7;
        r1.close();
        return;
    L7:
        throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
    }

    public String toString() {
        return "Response{protocol=" + this.f39713b + ", code=" + this.f39715d + ", message=" + this.f39714c + ", url=" + this.f39712a.a() + '}';
    }
}
