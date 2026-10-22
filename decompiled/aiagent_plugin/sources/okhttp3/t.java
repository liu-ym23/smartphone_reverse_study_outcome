package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: Handshake.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40197a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ag f40198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i f40199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Certificate> f40200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.f f40201e;

    /* JADX INFO: compiled from: Handshake.kt */
    public static final class a {

        /* JADX INFO: renamed from: okhttp3.t$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Handshake.kt */
        static final class C1091a extends d.h.b.p implements d.h.a.a<List<? extends Certificate>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ List<Certificate> f40202a;

            C1091a(List<? extends Certificate> r3) {
                this.f40202a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ List<? extends Certificate> invoke() {
                return a();
            }

            public final List<Certificate> a() {
                return this.f40202a;
            }
        }

        /* JADX INFO: compiled from: Handshake.kt */
        static final class b extends d.h.b.p implements d.h.a.a<List<? extends Certificate>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ List<Certificate> f40203a;

            b(List<? extends Certificate> r3) {
                this.f40203a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
                super(0);
            }

            public final List<Certificate> a() {
                return this.f40203a;
            }

            @Override // d.h.a.a
            public /* synthetic */ List<? extends Certificate> invoke() {
                return a();
            }
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final t a(SSLSession r6) {
            SSLSession r7 = (SSLSession) ZeusTransformUtils.wrapperContextForParams(r6, SSLSession.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r7, "<this>");
            String r0 = r7.getCipherSuite();
            if (r0 == null) goto L26;
            if (d.h.b.o.a(r0, "TLS_NULL_WITH_NULL_NULL") == false) goto L7;
            boolean r2 = true;
        L8:
            if (r2 == true) goto L24;
            i r1 = i.f39784a.a(r0);
            String r3 = r7.getProtocol();
            if (r3 == null) goto L22;
            if (d.h.b.o.a("NONE", r3) == true) goto L20;
            ag r4 = ag.f39729a.a(r3);
            List<Certificate> r5 = a(r7.getPeerCertificates());     // Catch: SSLPeerUnverifiedException -> L16
        L18:
            return new t(r4, r1, a(r7.getLocalCertificates()), (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r5), d.h.a.a.class, "com.obric.aiagent.plugin"));
        L16:
            r5 = d.a.p.b();
            goto L18
        L20:
            throw new IOException("tlsVersion == NONE");
        L22:
            throw new IllegalStateException("tlsVersion == null".toString());
        L24:
            throw new IOException("cipherSuite == " + r0);
        L7:
            r2 = d.h.b.o.a(r0, "SSL_NULL_WITH_NULL_NULL");
            goto L8
        L26:
            throw new IllegalStateException("cipherSuite == null".toString());
        }

        private final List<Certificate> a(Certificate[] r1) {
            if (r1 == null) goto L5;
            return okhttp3.internal.c.a(Arrays.copyOf(r1, r1.length));
        L5:
            return d.a.p.b();
        }

        public final t a(ag r3, i r4, List<? extends Certificate> r5, List<? extends Certificate> r6) {
            List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "tlsVersion");
            d.h.b.o.e(r4, "cipherSuite");
            d.h.b.o.e(r2, "peerCertificates");
            d.h.b.o.e(r7, "localCertificates");
            List r8 = okhttp3.internal.c.b(r2);
            return new t(r3, r4, okhttp3.internal.c.b(r7), (d.h.a.a) ZeusTransformUtils.preCheckCast(new C1091a(r8), d.h.a.a.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Handshake.kt */
    static final class b extends d.h.b.p implements d.h.a.a<List<? extends Certificate>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<List<Certificate>> f40204a;

        b(d.h.a.a<? extends List<? extends Certificate>> r3) {
            this.f40204a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ List<? extends Certificate> invoke() {
            return a();
        }

        public final List<Certificate> a() {
            return (List) ZeusTransformUtils.preCheckCast(this.f40204a.invoke(), List.class, "com.obric.aiagent.plugin");
        L5:
            return d.a.p.b();
        }
    }

    static {
        f40197a = new a(null);
    }

    public t(ag r3, i r4, List<? extends Certificate> r5, d.h.a.a<? extends List<? extends Certificate>> r6) {
        List<Certificate> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "tlsVersion");
        d.h.b.o.e(r4, "cipherSuite");
        d.h.b.o.e(r7, "localCertificates");
        d.h.b.o.e(r8, "peerCertificatesFn");
        this.f40198b = r3;
        this.f40199c = r4;
        this.f40200d = r7;
        this.f40201e = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r8), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public final ag a() {
        return this.f40198b;
    }

    public final i b() {
        return this.f40199c;
    }

    public final List<Certificate> c() {
        return this.f40200d;
    }

    public final List<Certificate> d() {
        return (List) ZeusTransformUtils.preCheckCast(this.f40201e.b(), List.class, "com.obric.aiagent.plugin");
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, t.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (((t) ZeusTransformUtils.preCheckCast(r5, t.class, "com.obric.aiagent.plugin")).f40198b != this.f40198b) goto L13;
        if (d.h.b.o.a(((t) ZeusTransformUtils.preCheckCast(r5, t.class, "com.obric.aiagent.plugin")).f40199c, this.f40199c) == false) goto L13;
        if (d.h.b.o.a(((t) ZeusTransformUtils.preCheckCast(r5, t.class, "com.obric.aiagent.plugin")).d(), d()) == false) goto L13;
        if (d.h.b.o.a(((t) ZeusTransformUtils.preCheckCast(r5, t.class, "com.obric.aiagent.plugin")).f40200d, this.f40200d) == false) goto L13;
        return true;
    }

    public int hashCode() {
        return ((((((527 + this.f40198b.hashCode()) * 31) + this.f40199c.hashCode()) * 31) + d().hashCode()) * 31) + this.f40200d.hashCode();
    }

    public String toString() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(d(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r0, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(a((Certificate) ZeusTransformUtils.preCheckCast(r2.next(), Certificate.class, "com.obric.aiagent.plugin")));
        goto L4
    L6:
        String r3 = ((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin")).toString();
        StringBuilder r4 = new StringBuilder().append("Handshake{tlsVersion=").append(this.f40198b).append(" cipherSuite=").append(this.f40199c).append(" peerCertificates=").append(r3).append(" localCertificates=");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.f40200d, Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r5, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L11;
        r6.add(a((Certificate) ZeusTransformUtils.preCheckCast(r7.next(), Certificate.class, "com.obric.aiagent.plugin")));
        goto L8
    L11:
        return r4.append((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin")).append('}').toString();
    }

    private final String a(Certificate r2) {
        if (ZeusTransformUtils.instanceOf(r2, X509Certificate.class) == true) goto L7;
        String r1 = r2.getType();
        d.h.b.o.c(r1, "type");
        return r1;
    L7:
        return ((X509Certificate) ZeusTransformUtils.preCheckCast(r2, X509Certificate.class, "com.obric.aiagent.plugin")).getSubjectDN().toString();
    }
}
