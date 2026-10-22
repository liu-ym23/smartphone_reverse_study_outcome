package okhttp3.internal.b;

import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.o.o;
import e.aa;
import e.ab;
import e.f;
import e.g;
import e.y;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.r;
import okhttp3.u;
import okhttp3.w;

/* JADX INFO: compiled from: CacheInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1073a f39791a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final okhttp3.c f39792c;

    /* JADX INFO: renamed from: okhttp3.internal.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CacheInterceptor.kt */
    public static final class C1073a {
        public /* synthetic */ C1073a(h r1) {
            this();
        }

        private C1073a() {
        }

        public static final /* synthetic */ ad a(C1073a r0, ad r1) {
            return r0.a(r1);
        }

        public static final /* synthetic */ u a(C1073a r0, u r1, u r2) {
            return r0.a(r1, r2);
        }

        private final ad a(ad r2) {
            if (r2 == null) goto L5;
            ae r0 = r2.g();
        L6:
            if (r0 != null) goto L8;
            return r2;
        L8:
            return r2.o().a(null).b();
        L5:
            r0 = null;
            goto L6
        }

        private final u a(u r10, u r11) {
            u.a r0 = new u.a();
            int r1 = r10.a();
            int r2 = 0;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L17;
            String r4 = r10.a(r3);
            String r5 = r10.b(r3);
            if (o.a("Warning", r4, true) == false) goto L10;
            if (o.b(r5, "1", false, 2, null) == false) goto L10;
        L16:
            r3 = r3 + 1;
        L10:
            if (b(r4) == false) goto L12;
        L15:
            r0.b(r4, r5);
            goto L16
        L12:
            if (a(r4) == false) goto L15;
            if (r11.a(r4) != null) goto L16;
        L17:
            int r12 = r11.a();
        L18:
            if (r2 >= r12) goto L26;
            String r6 = r11.a(r2);
            if (b(r6) == true) goto L24;
            if (a(r6) == false) goto L24;
            r0.b(r6, r11.b(r2));
        L24:
            r2 = r2 + 1;
            goto L18
        L26:
            return r0.b();
        }

        private final boolean a(String r2) {
            if (o.a("Connection", r2, true) == false) goto L5;
        L19:
            return false;
        L5:
            if (o.a("Keep-Alive", r2, true) == true) goto L19;
            if (o.a("Proxy-Authenticate", r2, true) == true) goto L19;
            if (o.a("Proxy-Authorization", r2, true) == true) goto L19;
            if (o.a("TE", r2, true) == true) goto L19;
            if (o.a("Trailers", r2, true) == true) goto L19;
            if (o.a(DownloadHelper.TRANSFER_ENCODING, r2, true) == true) goto L19;
            if (o.a("Upgrade", r2, true) == true) goto L19;
            return true;
        }

        private final boolean b(String r2) {
            if (o.a(DownloadUtils.CONTENT_LENGTH, r2, true) == false) goto L5;
            return true;
        L5:
            if (o.a(DownloadHelper.CONTENT_ENCODING, r2, true) == false) goto L7;
            return true;
        L7:
            if (o.a(DownloadHelper.CONTENT_TYPE, r2, true) == true) goto L13;
            return false;
        L13:
            return true;
        }
    }

    /* JADX INFO: compiled from: CacheInterceptor.kt */
    public static final class b implements aa {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f39793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ okhttp3.internal.b.b f39794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f39795c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f39796d;

        b(g r3, okhttp3.internal.b.b r4, f r5) {
            g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
            okhttp3.internal.b.b r7 = (okhttp3.internal.b.b) ZeusTransformUtils.wrapperContextForParams(r4, okhttp3.internal.b.b.class, "com.obric.aiagent.plugin");
            f r8 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.aiagent.plugin");
            this.f39793a = r6;
            this.f39794b = r7;
            this.f39795c = r8;
        }

        @Override // e.aa
        public long a(e.e r9, long r10) {
            d.h.b.o.e(r9, "sink");
            long r11 = this.f39793a.a(r9, r10);     // Catch: IOException -> L12
            if (r11 == (-1)) goto L7;
            r9.a(this.f39795c.d(), r9.b() - r11, r11);
            this.f39795c.B();
            return r11;
        L7:
            if (this.f39796d == true) goto L9;
            this.f39796d = true;
            this.f39795c.close();
        L9:
            return -1;
        L12:
            e = move-exception;
            if (this.f39796d == true) goto L16;
            this.f39796d = true;
            this.f39794b.b();
        L16:
            throw e;
        }

        @Override // e.aa
        public ab a() {
            return this.f39793a.a();
        }

        @Override // e.aa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f39796d == false) goto L5;
        L7:
            this.f39793a.close();
            return;
        L5:
            if (okhttp3.internal.c.b((aa) ZeusTransformUtils.preCheckCast(this, aa.class, "com.obric.aiagent.plugin"), 100, TimeUnit.MILLISECONDS) == true) goto L7;
            this.f39796d = true;
            this.f39794b.b();
            goto L7
        }
    }

    static {
        f39791a = new C1073a(null);
    }

    public a(okhttp3.c r1) {
        this.f39792c = r1;
    }

    @Override // okhttp3.w
    public ad intercept(w.a r9) {
        w.a r10 = (w.a) ZeusTransformUtils.wrapperContextForParams(r9, w.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "chain");
        okhttp3.e r0 = r10.call();
        okhttp3.c r2 = this.f39792c;
        okhttp3.internal.d.e r3 = null;
        if (r2 == null) goto L5;
        ad r4 = r2.a(r10.a());
    L6:
        c r5 = new c.b(System.currentTimeMillis(), r10.a(), r4).a();
        okhttp3.ab r6 = r5.a();
        ad r7 = r5.b();
        okhttp3.c r8 = this.f39792c;
        if (r8 == null) goto L10;
        r8.a(r5);
    L10:
        if (ZeusTransformUtils.instanceOf(r0, okhttp3.internal.d.e.class) == false) goto L12;
        r3 = (okhttp3.internal.d.e) ZeusTransformUtils.preCheckCast(r0, okhttp3.internal.d.e.class, "com.obric.aiagent.plugin");
    L12:
        if (r3 == null) goto L15;
        r r11 = r3.h();
        if (r11 == null) goto L15;
    L16:
        if (r4 == null) goto L21;
        if (r7 != null) goto L21;
        ae r12 = r4.g();
        if (r12 == null) goto L21;
        okhttp3.internal.c.a((Closeable) ZeusTransformUtils.preCheckCast(r12, Closeable.class, "com.obric.aiagent.plugin"));
    L21:
        if (r6 != null) goto L25;
        if (r7 != null) goto L25;
        ad r13 = new ad.a().a(r10.a()).a(okhttp3.aa.f39695c).a(504).a("Unsatisfiable Request (only-if-cached)").a(okhttp3.internal.c.f39835c).a(-1).b(System.currentTimeMillis()).b();
        r11.satisfactionFailure(r0, r13);
        return r13;
    L25:
        if (r6 != null) goto L28;
        d.h.b.o.a(r7);
        ad r14 = r7.o().b(C1073a.a(f39791a, r7)).b();
        r11.cacheHit(r0, r14);
        return r14;
    L28:
        if (r7 == null) goto L31;
        r11.cacheConditionalHit(r0, r7);
    L74:
        ad r15 = r10.a(r6);     // Catch: Throwable -> L65
        if (r15 != null) goto L39;
        if (r4 == null) goto L39;
        ae r16 = r4.g();
        if (r16 == null) goto L39;
        okhttp3.internal.c.a((Closeable) ZeusTransformUtils.preCheckCast(r16, Closeable.class, "com.obric.aiagent.plugin"));
    L39:
        if (r7 == null) goto L51;
        boolean r17 = false;
        if (r15 != null) goto L43;
    L45:
        if (r17 == false) goto L48;
        ad.a r1 = r7.o();
        C1073a r18 = f39791a;
        ad r19 = r1.a(C1073a.a(r18, r7.f(), r15.f())).a(r15.k()).b(r15.l()).b(C1073a.a(r18, r7)).a(C1073a.a(r18, r15)).b();
        ae r20 = r15.g();
        d.h.b.o.a(r20);
        r20.close();
        okhttp3.c r21 = this.f39792c;
        d.h.b.o.a(r21);
        r21.c();
        this.f39792c.a(r7, r19);
        r11.cacheHit(r0, r19);
        return r19;
    L48:
        ae r22 = r7.g();
        if (r22 == null) goto L51;
        okhttp3.internal.c.a((Closeable) ZeusTransformUtils.preCheckCast(r22, Closeable.class, "com.obric.aiagent.plugin"));
        goto L51
    L43:
        if (r15.d() != 304) goto L45;
        r17 = true;
    L51:
        d.h.b.o.a(r15);
        ad.a r23 = r15.o();
        C1073a r24 = f39791a;
        ad r25 = r23.b(C1073a.a(r24, r7)).a(C1073a.a(r24, r15)).b();
        if (this.f39792c != null) goto L54;
    L64:
        return r25;
    L54:
        if (okhttp3.internal.e.e.a(r25) == false) goto L62;
        if (c.f39797a.a(r25, r6) == false) goto L62;
        ad r26 = a(this.f39792c.a(r25), r25);
        if (r7 == null) goto L60;
        r11.cacheMiss(r0);
    L60:
        return r26;
    L62:
        if (okhttp3.internal.e.f.f39923a.a(r6.b()) == false) goto L64;
        this.f39792c.b(r6);     // Catch: IOException -> L71
    L65:
        th = move-exception;
        if (r4 == null) goto L70;
        ae r27 = r4.g();
        if (r27 == null) goto L70;
        okhttp3.internal.c.a((Closeable) ZeusTransformUtils.preCheckCast(r27, Closeable.class, "com.obric.aiagent.plugin"));
    L70:
        throw th;
    L31:
        if (this.f39792c == null) goto L74;
        r11.cacheMiss(r0);
    L15:
        r11 = r.NONE;
        goto L16
    L5:
        r4 = null;
        goto L6
    }

    private final ad a(okhttp3.internal.b.b r6, ad r7) {
        okhttp3.internal.b.b r5 = (okhttp3.internal.b.b) ZeusTransformUtils.wrapperContextForParams(r6, okhttp3.internal.b.b.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return r7;
    L5:
        y r8 = r5.c();
        ae r1 = r7.g();
        d.h.b.o.a(r1);
        b r2 = new b(r1.d(), r5, e.o.a(r8));
        String r9 = ad.a(r7, DownloadHelper.CONTENT_TYPE, null, 2, null);
        long r3 = r7.g().c();
        return r7.o().a((ae) ZeusTransformUtils.preCheckCast(new okhttp3.internal.e.h(r9, r3, e.o.a((aa) ZeusTransformUtils.preCheckCast(r2, aa.class, "com.obric.aiagent.plugin"))), ae.class, "com.obric.aiagent.plugin")).b();
    }
}
