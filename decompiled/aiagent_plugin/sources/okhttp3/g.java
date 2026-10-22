package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: compiled from: CertificatePinner.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f39770a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f39771b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<c> f39772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final okhttp3.internal.k.c f39773d;

    /* JADX INFO: compiled from: CertificatePinner.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<c> f39774a;

        public a() {
            this.f39774a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final g a() {
            return new g(d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(this.f39774a, Iterable.class, "com.obric.aiagent.plugin")), null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: CertificatePinner.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }

        public final e.h a(X509Certificate r7) {
            d.h.b.o.e(r7, "<this>");
            e.h.a r0 = e.h.f38722a;
            byte[] r1 = r7.getPublicKey().getEncoded();
            d.h.b.o.c(r1, "publicKey.encoded");
            return e.h.a.a(r0, r1, 0, 0, 3, null).g();
        }

        public final e.h b(X509Certificate r7) {
            d.h.b.o.e(r7, "<this>");
            e.h.a r0 = e.h.f38722a;
            byte[] r1 = r7.getPublicKey().getEncoded();
            d.h.b.o.c(r1, "publicKey.encoded");
            return e.h.a.a(r0, r1, 0, 0, 3, null).h();
        }

        public final String a(Certificate r4) {
            d.h.b.o.e(r4, "certificate");
            if (ZeusTransformUtils.instanceOf(r4, X509Certificate.class) == false) goto L7;
            return "sha256/" + b((X509Certificate) ZeusTransformUtils.preCheckCast(r4, X509Certificate.class, "com.obric.aiagent.plugin")).e();
        L7:
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }
    }

    /* JADX INFO: compiled from: CertificatePinner.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f39775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f39776b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final e.h f39777c;

        public final String a() {
            return this.f39776b;
        }

        public final e.h b() {
            return this.f39777c;
        }

        public final boolean a(String r12) {
            d.h.b.o.e(r12, "hostname");
            if (d.o.o.b(this.f39775a, "**.", false, 2, null) == false) goto L11;
            int r7 = this.f39775a.length() - 3;
            int r0 = r12.length() - r7;
            if (d.o.o.a(r12, r12.length() - r7, this.f39775a, 3, r7, false, 16, null) == false) goto L19;
            if (r0 == 0) goto L21;
            if (r12.charAt(r0 - 1) == '.') goto L21;
            return false;
        L21:
            return true;
        L19:
            return false;
        L11:
            if (d.o.o.b(this.f39775a, "*.", false, 2, null) == false) goto L18;
            int r8 = this.f39775a.length() - 1;
            int r1 = r12.length() - r8;
            if (d.o.o.a(r12, r12.length() - r8, this.f39775a, 1, r8, false, 16, null) == true) goto L15;
            return false;
        L15:
            if (d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), '.', r1 - 1, false, 4, null) == (-1)) goto L21;
            return false;
        L18:
            return d.h.b.o.a(r12, this.f39775a);
        }

        public String toString() {
            return this.f39776b + '/' + this.f39777c.e();
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L9;
            return false;
        L9:
            if (d.h.b.o.a(this.f39775a, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f39775a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f39776b, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f39776b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f39777c, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f39777c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f39775a.hashCode() * 31) + this.f39776b.hashCode()) * 31) + this.f39777c.hashCode();
        }
    }

    /* JADX INFO: compiled from: CertificatePinner.kt */
    static final class d extends d.h.b.p implements d.h.a.a<List<? extends X509Certificate>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f39778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<Certificate> f39779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f39780c;

        d(g r3, List<? extends Certificate> r4, String r5) {
            List<Certificate> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f39778a = r3;
            this.f39779b = r6;
            this.f39780c = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ List<? extends X509Certificate> invoke() {
            return a();
        }

        public final List<X509Certificate> a() {
            okhttp3.internal.k.c r0 = this.f39778a.a();
            if (r0 == null) goto L6;
            List<Certificate> r1 = r0.a(this.f39779b, this.f39780c);
            if (r1 == null) goto L6;
        L7:
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r4, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r5 = r4.iterator();
        L9:
            if (r5.hasNext() == false) goto L12;
            Certificate r3 = (Certificate) ZeusTransformUtils.preCheckCast(r5.next(), Certificate.class, "com.obric.aiagent.plugin");
            d.h.b.o.a(r3, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            r2.add((X509Certificate) ZeusTransformUtils.preCheckCast(r3, X509Certificate.class, "com.obric.aiagent.plugin"));
            goto L9
        L12:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L6:
            r1 = this.f39779b;
            goto L7
        }
    }

    public g(Set<c> r3, okhttp3.internal.k.c r4) {
        Set<c> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "pins");
        this.f39772c = r5;
        this.f39773d = r4;
    }

    public /* synthetic */ g(Set r2, okhttp3.internal.k.c r3, int r4, d.h.b.h r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        this(r6, r3);
    }

    public final okhttp3.internal.k.c a() {
        return this.f39773d;
    }

    public final void a(String r3, List<? extends Certificate> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "hostname");
        d.h.b.o.e(r5, "peerCertificates");
        a(r3, (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this, r5, r3), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public final void a(String r10, d.h.a.a<? extends List<? extends X509Certificate>> r11) {
        d.h.a.a r12 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "hostname");
        d.h.b.o.e(r12, "cleanedPeerCertificatesFn");
        List<c> r9 = a(r10);
        if (r9.isEmpty() == false) goto L5;
        return;
    L5:
        List r13 = (List) ZeusTransformUtils.preCheckCast(r12.invoke(), List.class, "com.obric.aiagent.plugin");
        Iterator r0 = r13.iterator();
    L7:
        if (r0.hasNext() == false) goto L27;
        X509Certificate r2 = (X509Certificate) ZeusTransformUtils.preCheckCast(r0.next(), X509Certificate.class, "com.obric.aiagent.plugin");
        Iterator<c> r3 = r9.iterator();
        e.h r4 = null;
        e.h r5 = null;
    L10:
        if (r3.hasNext() == false) goto L7;
        c r6 = (c) ZeusTransformUtils.preCheckCast(r3.next(), c.class, "com.obric.aiagent.plugin");
        String r7 = r6.a();
        if (d.h.b.o.a(r7, "sha256") == true) goto L13;
        if (d.h.b.o.a(r7, "sha1") == false) goto L26;
        if (r5 != null) goto L23;
        r5 = f39770a.a(r2);
    L23:
        if (d.h.b.o.a(r6.b(), r5) == false) goto L10;
        return;
    L26:
        throw new AssertionError("unsupported hashAlgorithm: " + r6.a());
    L13:
        if (r4 != null) goto L16;
        r4 = f39770a.b(r2);
    L16:
        if (d.h.b.o.a(r6.b(), r4) == false) goto L10;
        return;
    L27:
        StringBuilder r1 = new StringBuilder();
        r1.append("Certificate pinning failure!");
        r1.append("\n  Peer certificate chain:");
        Iterator r14 = r13.iterator();
    L29:
        if (r14.hasNext() == false) goto L31;
        X509Certificate r8 = (X509Certificate) ZeusTransformUtils.preCheckCast(r14.next(), X509Certificate.class, "com.obric.aiagent.plugin");
        r1.append("\n    ");
        r1.append(f39770a.a((Certificate) ZeusTransformUtils.preCheckCast(r8, Certificate.class, "com.obric.aiagent.plugin")));
        r1.append(": ");
        r1.append(r8.getSubjectDN().getName());
        goto L29
    L31:
        r1.append("\n  Pinned certificates for ");
        r1.append(r10);
        r1.append(":");
        Iterator<c> r15 = r9.iterator();
    L33:
        if (r15.hasNext() == false) goto L35;
        c r16 = (c) ZeusTransformUtils.preCheckCast(r15.next(), c.class, "com.obric.aiagent.plugin");
        r1.append("\n    ");
        r1.append(r16);
        goto L33
    L35:
        String r17 = r1.toString();
        d.h.b.o.c(r17, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(r17);
    }

    public final List<c> a(String r5) {
        d.h.b.o.e(r5, "hostname");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.f39772c, Iterable.class, "com.obric.aiagent.plugin");
        List<c> r0 = d.a.p.b();
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        Object r2 = r6.next();
        if (((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin")).a(r5) == false) goto L4;
        if (r0.isEmpty() == false) goto L10;
        r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L10:
        d.h.b.o.a(r0, "null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal.Util.filterList>");
        d.h.b.ae.f(r0).add(r2);
        goto L4
    L11:
        return r0;
    }

    public final g a(okhttp3.internal.k.c r2) {
        d.h.b.o.e(r2, "certificateChainCleaner");
        if (d.h.b.o.a(this.f39773d, r2) == false) goto L6;
        return this;
    L6:
        return new g(this.f39772c, r2);
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (d.h.b.o.a(((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).f39772c, this.f39772c) == false) goto L9;
        if (d.h.b.o.a(((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).f39773d, this.f39773d) == false) goto L9;
        return true;
    }

    public int hashCode() {
        int r1 = (1517 + this.f39772c.hashCode()) * 41;
        okhttp3.internal.k.c r2 = this.f39773d;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    static {
        f39770a = new b(null);
        f39771b = new a().a();
    }
}
