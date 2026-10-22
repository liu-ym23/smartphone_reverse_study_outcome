package okhttp3;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.capabilitykit.common.Ext;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: Cache.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f39738a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final okhttp3.internal.b.d f39739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f39740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f39741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f39742e;
    private int f;
    private int g;

    /* JADX INFO: compiled from: Cache.kt */
    private static final class a extends ae {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final okhttp3.internal.b.d.C1074d f39743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f39744c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f39745d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final e.g f39746e;

        public final okhttp3.internal.b.d.C1074d a() {
            return this.f39743b;
        }

        public a(okhttp3.internal.b.d.C1074d r2, String r3, String r4) {
            d.h.b.o.e(r2, "snapshot");
            this.f39743b = r2;
            this.f39744c = r3;
            this.f39745d = r4;
            final e.aa r5 = r2.a(1);
            this.f39746e = e.o.a((e.aa) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5, this), e.aa.class, "com.obric.aiagent.plugin"));
        }

        @Override // okhttp3.ae
        public x b() {
            String r1 = this.f39744c;
            if (r1 != null) goto L7;
            return null;
        L7:
            return x.f40220a.b(r1);
        }

        @Override // okhttp3.ae
        public long c() {
            String r2 = this.f39745d;
            if (r2 != null) goto L5;
            return -1;
        L5:
            return okhttp3.internal.c.a(r2, -1);
        }

        @Override // okhttp3.ae
        public e.g d() {
            return this.f39746e;
        }
    }

    /* JADX INFO: compiled from: Cache.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }

        public final String a(v r1) {
            d.h.b.o.e(r1, "url");
            return e.h.f38722a.a(r1.toString()).f().i();
        }

        public final int a(e.g r6) {
            e.g r5 = (e.g) ZeusTransformUtils.wrapperContextForParams(r6, e.g.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, DBHelper.BATTERY_COL_SOURCE);
            long r1 = r5.r();     // Catch: NumberFormatException -> L16
            String r7 = r5.v();     // Catch: NumberFormatException -> L16
            if (r1 < 0) goto L15;
            if (r1 > 2147483647L) goto L15;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L10;
            boolean r8 = true;
        L11:
            if (r8 == true) goto L15;
            return (int) r1;
        L10:
            r8 = false;
        L15:
            throw new IOException("expected an int but was \"" + r1 + r7 + '\"');     // Catch: NumberFormatException -> L16
        L16:
            e = move-exception;
            throw new IOException(e.getMessage());
        }

        public final boolean a(ad r4, u r5, ab r6) {
            d.h.b.o.e(r4, "cachedResponse");
            d.h.b.o.e(r5, "cachedRequest");
            d.h.b.o.e(r6, "newRequest");
            Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(a(r4.f()), Iterable.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L5;
        L7:
            Iterator r7 = r3.iterator();
        L9:
            if (r7.hasNext() == false) goto L18;
            String r8 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
            if ((!d.h.b.o.a(r5.b(r8), r6.b(r8))) == false) goto L9;
            return false;
        L18:
            return true;
        L5:
            if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
            return true;
        }

        public final boolean a(ad r2) {
            d.h.b.o.e(r2, "<this>");
            return a(r2.f()).contains("*");
        }

        private final Set<String> a(u r13) {
            int r12 = r13.a();
            Set<String> r1 = null;
            int r2 = 0;
        L3:
            if (r2 >= r12) goto L15;
            if (d.o.o.a("Vary", r13.a(r2), true) == false) goto L14;
            String r3 = r13.b(r2);
            if (r1 != null) goto L10;
            r1 = (Set) ZeusTransformUtils.preCheckCast(new TreeSet(d.o.o.a(d.h.b.ad.f38485a)), Set.class, "com.obric.aiagent.plugin");
        L10:
            Iterator r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{','}, false, 0, 6, null).iterator();
        L12:
            if (r4.hasNext() == false) goto L14;
            r1.add(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString());
        L14:
            r2 = r2 + 1;
            goto L3
        L15:
            if (r1 == null) goto L17;
            return r1;
        L17:
            return ax.b();
        }

        public final u b(ad r2) {
            d.h.b.o.e(r2, "<this>");
            ad r0 = r2.h();
            d.h.b.o.a(r0);
            return a(r0.a().c(), r2.f());
        }

        private final u a(u r5, u r6) {
            Set<String> r4 = a(r6);
            if (r4.isEmpty() == true) goto L5;
            u.a r7 = new u.a();
            int r0 = 0;
            int r1 = r5.a();
        L7:
            if (r0 >= r1) goto L13;
            String r2 = r5.a(r0);
            if (r4.contains(r2) == false) goto L11;
            r7.a(r2, r5.b(r0));
        L11:
            r0 = r0 + 1;
            goto L7
        L13:
            return r7.b();
        L5:
            return okhttp3.internal.c.f39834b;
        }
    }

    /* JADX INFO: renamed from: okhttp3.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Cache.kt */
    private static final class C1071c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f39748a = null;
        private static final String l = null;
        private static final String m = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final v f39749b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final u f39750c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f39751d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final aa f39752e;
        private final int f;
        private final String g;
        private final u h;
        private final t i;
        private final long j;
        private final long k;

        /* JADX INFO: renamed from: okhttp3.c$c$a */
        /* JADX INFO: compiled from: Cache.kt */
        public static final class a {
            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            private a() {
            }
        }

        private final boolean a() {
            return d.h.b.o.a(this.f39749b.a(), "https");
        }

        public C1071c(e.aa r11) {
            e.aa r12 = (e.aa) ZeusTransformUtils.wrapperContextForParams(r11, e.aa.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r12, "rawSource");
            Closeable r0 = (Closeable) ZeusTransformUtils.preCheckCast(r12, Closeable.class, "com.obric.aiagent.plugin");
            e.aa r2 = (e.aa) ZeusTransformUtils.preCheckCast(r0, e.aa.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
            e.g r13 = e.o.a(r12);     // Catch: Throwable -> L37
            String r3 = r13.v();     // Catch: Throwable -> L37
            v r4 = v.f40208a.d(r3);     // Catch: Throwable -> L37
            if (r4 == null) goto L35;
            this.f39749b = r4;     // Catch: Throwable -> L37
            this.f39751d = r13.v();     // Catch: Throwable -> L37
            u.a r5 = new u.a();     // Catch: Throwable -> L37
            int r6 = c.f39738a.a(r13);     // Catch: Throwable -> L37
            boolean r7 = false;
            int r8 = 0;
        L6:
            if (r8 >= r6) goto L8;
            r5.a(r13.v());     // Catch: Throwable -> L37
            r8 = r8 + 1;     // Catch: Throwable -> L37
            goto L6
        L8:
            this.f39750c = r5.b();     // Catch: Throwable -> L37
            okhttp3.internal.e.k r9 = okhttp3.internal.e.k.f39935a.a(r13.v());     // Catch: Throwable -> L37
            this.f39752e = r9.f39936b;     // Catch: Throwable -> L37
            this.f = r9.f39937c;     // Catch: Throwable -> L37
            this.g = r9.f39938d;     // Catch: Throwable -> L37
            u.a r10 = new u.a();     // Catch: Throwable -> L37
            int r14 = c.f39738a.a(r13);     // Catch: Throwable -> L37
            int r15 = 0;
        L9:
            if (r15 >= r14) goto L11;
            r10.a(r13.v());     // Catch: Throwable -> L37
            r15 = r15 + 1;     // Catch: Throwable -> L37
            goto L9
        L11:
            String r16 = l;     // Catch: Throwable -> L37
            String r17 = r10.c(r16);     // Catch: Throwable -> L37
            String r18 = m;     // Catch: Throwable -> L37
            String r19 = r10.c(r18);     // Catch: Throwable -> L37
            r10.b(r16);     // Catch: Throwable -> L37
            r10.b(r18);     // Catch: Throwable -> L37
            long r20 = 0;
            if (r17 == null) goto L14;
            long r21 = Long.parseLong(r17);     // Catch: Throwable -> L37
        L15:
            this.j = r21;     // Catch: Throwable -> L37
            if (r19 == null) goto L18;
            r20 = Long.parseLong(r19);     // Catch: Throwable -> L37
        L18:
            this.k = r20;     // Catch: Throwable -> L37
            this.h = r10.b();     // Catch: Throwable -> L37
            if (a() == false) goto L31;
            String r22 = r13.v();     // Catch: Throwable -> L37
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L23;
            r7 = true;
        L23:
            if (r7 == true) goto L30;
            i r1 = i.f39784a.a(r13.v());     // Catch: Throwable -> L37
            List<Certificate> r23 = a(r13);     // Catch: Throwable -> L37
            List<Certificate> r24 = a(r13);     // Catch: Throwable -> L37
            if (r13.h() == true) goto L27;
            ag r110 = ag.f39729a.a(r13.v());     // Catch: Throwable -> L37
        L28:
            this.i = t.f40197a.a(r110, r1, r23, r24);     // Catch: Throwable -> L37
        L32:
            d.x r111 = d.x.f38692a;     // Catch: Throwable -> L37
            d.f.c.a(r0, null);
            return;
        L27:
            r110 = ag.f;     // Catch: Throwable -> L37
            goto L28
        L30:
            throw new IOException("expected \"\" but was \"" + r22 + '\"');     // Catch: Throwable -> L37
        L31:
            this.i = null;     // Catch: Throwable -> L37
            goto L32
        L14:
            r21 = 0;
            goto L15
        L35:
            IOException r112 = new IOException("Cache corruption for " + r3);     // Catch: Throwable -> L37
            okhttp3.internal.i.h.f40147b.a().a("cache corruption", 5, (Throwable) ZeusTransformUtils.preCheckCast(r112, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L37
            throw ((Throwable) ZeusTransformUtils.preCheckCast(r112, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            throw th;     // Catch: Throwable -> L39
        L39:
            th = move-exception;
            d.f.c.a(r0, th);
            throw th;
        }

        public C1071c(ad r3) {
            d.h.b.o.e(r3, "response");
            this.f39749b = r3.a().a();
            this.f39750c = c.f39738a.b(r3);
            this.f39751d = r3.a().b();
            this.f39752e = r3.b();
            this.f = r3.d();
            this.g = r3.c();
            this.h = r3.f();
            this.i = r3.e();
            this.j = r3.k();
            this.k = r3.l();
        }

        public final void a(okhttp3.internal.b.d.b r9) {
            d.h.b.o.e(r9, "editor");
            int r0 = 0;
            Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(e.o.a(r9.a(0)), Closeable.class, "com.obric.aiagent.plugin");
            e.f r1 = (e.f) ZeusTransformUtils.preCheckCast(r10, e.f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            r1.b(this.f39749b.toString()).h(10);     // Catch: Throwable -> L17
            r1.b(this.f39751d).h(10);     // Catch: Throwable -> L17
            r1.n(this.f39750c.a()).h(10);     // Catch: Throwable -> L17
            int r2 = this.f39750c.a();     // Catch: Throwable -> L17
            int r4 = 0;
        L6:
            if (r4 >= r2) goto L8;
            r1.b(this.f39750c.a(r4)).b(": ").b(this.f39750c.b(r4)).h(10);     // Catch: Throwable -> L17
            r4 = r4 + 1;     // Catch: Throwable -> L17
            goto L6
        L8:
            r1.b(new okhttp3.internal.e.k(this.f39752e, this.f, this.g).toString()).h(10);     // Catch: Throwable -> L17
            r1.n(this.h.a() + 2).h(10);     // Catch: Throwable -> L17
            int r3 = this.h.a();     // Catch: Throwable -> L17
        L9:
            if (r0 >= r3) goto L11;
            r1.b(this.h.a(r0)).b(": ").b(this.h.b(r0)).h(10);     // Catch: Throwable -> L17
            r0 = r0 + 1;     // Catch: Throwable -> L17
            goto L9
        L11:
            r1.b(l).b(": ").n(this.j).h(10);     // Catch: Throwable -> L17
            r1.b(m).b(": ").n(this.k).h(10);     // Catch: Throwable -> L17
            if (a() == false) goto L14;
            r1.h(10);     // Catch: Throwable -> L17
            t r5 = this.i;     // Catch: Throwable -> L17
            d.h.b.o.a(r5);     // Catch: Throwable -> L17
            r1.b(r5.b().a()).h(10);     // Catch: Throwable -> L17
            a(r1, this.i.d());     // Catch: Throwable -> L17
            a(r1, this.i.c());     // Catch: Throwable -> L17
            r1.b(this.i.a().a()).h(10);     // Catch: Throwable -> L17
        L14:
            d.x r8 = d.x.f38692a;     // Catch: Throwable -> L17
            d.f.c.a(r10, null);
            return;
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            d.f.c.a(r10, th);
            throw th;
        }

        private final List<Certificate> a(e.g r8) {
            e.g r7 = (e.g) ZeusTransformUtils.wrapperContextForParams(r8, e.g.class, "com.obric.aiagent.plugin");
            int r9 = c.f39738a.a(r7);
            if (r9 == (-1)) goto L5;
            CertificateFactory r1 = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L15
            ArrayList r2 = new ArrayList(r9);     // Catch: CertificateException -> L15
            int r3 = 0;
        L7:
            if (r3 >= r9) goto L14;
            String r4 = r7.v();     // Catch: CertificateException -> L15
            e.e r5 = new e.e();     // Catch: CertificateException -> L15
            e.h r6 = e.h.f38722a.b(r4);     // Catch: CertificateException -> L15
            if (r6 == null) goto L12;
            r5.a(r6);     // Catch: CertificateException -> L15
            r2.add(r1.generateCertificate(r5.i()));     // Catch: CertificateException -> L15
            r3 = r3 + 1;     // Catch: CertificateException -> L15
            goto L7
        L12:
            throw new IOException("Corrupt certificate in cache entry");     // Catch: CertificateException -> L15
        L14:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L15:
            e = move-exception;
            throw new IOException(e.getMessage());
        L5:
            return d.a.p.b();
        }

        private final void a(e.f r9, List<? extends Certificate> r10) {
            e.f r8 = (e.f) ZeusTransformUtils.wrapperContextForParams(r9, e.f.class, "com.obric.aiagent.plugin");
            List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
            r8.n(r11.size()).h(10);     // Catch: CertificateEncodingException -> L9
            Iterator r12 = r11.iterator();     // Catch: CertificateEncodingException -> L9
        L5:
            if (r12.hasNext() == false) goto L8;
            byte[] r3 = ((Certificate) ZeusTransformUtils.preCheckCast(r12.next(), Certificate.class, "com.obric.aiagent.plugin")).getEncoded();     // Catch: CertificateEncodingException -> L9
            e.h.a r2 = e.h.f38722a;     // Catch: CertificateEncodingException -> L9
            d.h.b.o.c(r3, "bytes");     // Catch: CertificateEncodingException -> L9
            r8.b(e.h.a.a(r2, r3, 0, 0, 3, null).e()).h(10);     // Catch: CertificateEncodingException -> L9
            goto L5
        L8:
            return;
        L9:
            e = move-exception;
            throw new IOException(e.getMessage());
        }

        public final boolean a(ab r3, ad r4) {
            d.h.b.o.e(r3, Ext.KEY_REQUEST);
            d.h.b.o.e(r4, "response");
            if (d.h.b.o.a(this.f39749b, r3.a()) == true) goto L5;
        L9:
            return false;
        L5:
            if (d.h.b.o.a(this.f39751d, r3.b()) == false) goto L9;
            if (c.f39738a.a(r4, this.f39750c, r3) == false) goto L9;
            return true;
        }

        public final ad a(okhttp3.internal.b.d.C1074d r6) {
            d.h.b.o.e(r6, "snapshot");
            String r0 = this.h.a(DownloadHelper.CONTENT_TYPE);
            String r1 = this.h.a(DownloadUtils.CONTENT_LENGTH);
            ab r2 = new ab.a().a(this.f39749b).a(this.f39751d, null).a(this.f39750c).b();
            return new ad.a().a(r2).a(this.f39752e).a(this.f).a(this.g).a(this.h).a((ae) ZeusTransformUtils.preCheckCast(new a(r6, r0, r1), ae.class, "com.obric.aiagent.plugin")).a(this.i).a(this.j).b(this.k).b();
        }

        static {
            f39748a = new a(null);
            l = okhttp3.internal.i.h.f40147b.a().d() + "-Sent-Millis";
            m = okhttp3.internal.i.h.f40147b.a().d() + "-Received-Millis";
        }
    }

    /* JADX INFO: compiled from: Cache.kt */
    private final class d implements okhttp3.internal.b.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f39753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final okhttp3.internal.b.d.b f39754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final e.y f39755c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final e.y f39756d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f39757e;

        public d(final c r2, okhttp3.internal.b.d.b r3) {
            d.h.b.o.e(r3, "editor");
            this.f39753a = r2;
            this.f39754b = r3;
            final e.y r4 = r3.a(1);
            this.f39755c = r4;
            this.f39756d = (e.y) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2, this, r4), e.y.class, "com.obric.aiagent.plugin");
        }

        public static final /* synthetic */ okhttp3.internal.b.d.b a(d r0) {
            return r0.f39754b;
        }

        public final void a(boolean r1) {
            this.f39757e = r1;
        }

        public final boolean a() {
            return this.f39757e;
        }

        @Override // okhttp3.internal.b.b
        public void b() {
            c r0 = this.f39753a;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.f39757e == false) goto L9;
            monitor-exit(r0);
            return;
        L9:
            this.f39757e = true;     // Catch: Throwable -> L14
            r0.b(r0.b() + 1);     // Catch: Throwable -> L14
            monitor-exit(r0);
            okhttp3.internal.c.a((Closeable) ZeusTransformUtils.preCheckCast(this.f39755c, Closeable.class, "com.obric.aiagent.plugin"));
            this.f39754b.e();     // Catch: IOException -> L17
            return;
        }

        @Override // okhttp3.internal.b.b
        public e.y c() {
            return this.f39756d;
        }
    }

    static {
        f39738a = new b(null);
    }

    public final int a() {
        return this.f39740c;
    }

    public final void a(int r1) {
        this.f39740c = r1;
    }

    public final int b() {
        return this.f39741d;
    }

    public final void b(int r1) {
        this.f39741d = r1;
    }

    public final ad a(ab r5) {
        d.h.b.o.e(r5, Ext.KEY_REQUEST);
        String r1 = f39738a.a(r5.a());
        okhttp3.internal.b.d.C1074d r4 = this.f39739b.a(r1);     // Catch: IOException -> L16
        if (r4 != null) goto L17;
        return null;
    L17:
        C1071c r2 = new C1071c(r4.a(0));     // Catch: IOException -> L14
        ad r6 = r2.a(r4);
        if (r2.a(r5, r6) == true) goto L13;
        ae r7 = r6.g();
        if (r7 == null) goto L12;
        okhttp3.internal.c.a((Closeable) ZeusTransformUtils.preCheckCast(r7, Closeable.class, "com.obric.aiagent.plugin"));
    L12:
        return null;
    L13:
        return r6;
    L14:
        okhttp3.internal.c.a((Closeable) ZeusTransformUtils.preCheckCast(r4, Closeable.class, "com.obric.aiagent.plugin"));
    L15:
        return null;
    }

    public final okhttp3.internal.b.b a(ad r10) {
        d.h.b.o.e(r10, "response");
        String r0 = r10.a().b();
        if (okhttp3.internal.e.f.f39923a.a(r10.a().b()) == false) goto L7;
        b(r10.a());     // Catch: IOException -> L22
    L5:
        return null;
    L7:
        if (d.h.b.o.a(r0, "GET") == true) goto L9;
        return null;
    L9:
        b r1 = f39738a;
        if (r1.a(r10) == false) goto L12;
        return null;
    L12:
        C1071c r2 = new C1071c(r10);
        okhttp3.internal.b.d.b r11 = okhttp3.internal.b.d.a(this.f39739b, r1.a(r10.a().a()), 0, 2, null);     // Catch: IOException -> L18
        if (r11 != null) goto L25;
        return null;
    L25:
        r2.a(r11);     // Catch: IOException -> L21
        return (okhttp3.internal.b.b) ZeusTransformUtils.preCheckCast(new d(this, r11), okhttp3.internal.b.b.class, "com.obric.aiagent.plugin");
    L19:
        a(r11);
        return null;
    L18:
        r11 = null;
        goto L19
    }

    public final void b(ab r2) {
        d.h.b.o.e(r2, Ext.KEY_REQUEST);
        this.f39739b.b(f39738a.a(r2.a()));
    }

    public final void a(ad r3, ad r4) {
        d.h.b.o.e(r3, "cached");
        d.h.b.o.e(r4, "network");
        C1071c r0 = new C1071c(r4);
        ae r5 = r3.g();
        d.h.b.o.a(r5, "null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        okhttp3.internal.b.d.b r6 = ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin")).a().a();     // Catch: IOException -> L8
        if (r6 != null) goto L12;
        return;
    L12:
        r0.a(r6);     // Catch: IOException -> L11
        r6.d();     // Catch: IOException -> L11
        return;
    L9:
        a(r6);
        return;
    L8:
        r6 = null;
        goto L9
    }

    private final void a(okhttp3.internal.b.d.b r1) {
        if (r1 == null) goto L8;
        r1.e();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public final void delete() {
        this.f39739b.delete();
    }

    @Override // java.io.Flushable
    public void flush() {
        this.f39739b.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f39739b.close();
    }

    public final synchronized void a(okhttp3.internal.b.c r2) {
        monitor-enter(this);
        d.h.b.o.e(r2, "cacheStrategy");     // Catch: Throwable -> L11
        this.g++;     // Catch: Throwable -> L11
        if (r2.a() == null) goto L7;
        this.f39742e++;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L7:
        if (r2.b() == null) goto L9;
        this.f++;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized void c() {
        monitor-enter(this);
        this.f++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
