package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: ConnectionSpec.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f40164a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f40165b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f40166c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f40167d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f40168e = null;
    private static final i[] j = null;
    private static final i[] k = null;
    private final boolean f;
    private final boolean g;
    private final String[] h;
    private final String[] i;

    /* JADX INFO: compiled from: ConnectionSpec.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f40169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String[] f40170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String[] f40171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f40172d;

        public a(boolean r1) {
            this.f40169a = r1;
        }

        public a(l r2) {
            d.h.b.o.e(r2, "connectionSpec");
            this.f40169a = r2.a();
            this.f40170b = l.a(r2);
            this.f40171c = l.b(r2);
            this.f40172d = r2.b();
        }

        public final a a(i... r7) {
            d.h.b.o.e(r7, "cipherSuites");
            a r6 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (r6.f40169a == false) goto L10;
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r7.length), Collection.class, "com.obric.aiagent.plugin");
            int r2 = r7.length;
            int r4 = 0;
        L5:
            if (r4 >= r2) goto L7;
            r0.add(r7[r4].a());
            r4 = r4 + 1;
            goto L5
        L7:
            String[] r8 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
            return r6.a((String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r8, r8.length), String[].class, "com.obric.aiagent.plugin"));
        L10:
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final a a(String... r6) {
            d.h.b.o.e(r6, "cipherSuites");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (r2.f40169a == false) goto L15;
            if (r6.length != 0) goto L7;
            boolean r3 = true;
        L9:
            if ((!r3) == false) goto L13;
            r2.f40170b = (String[]) ZeusTransformUtils.preCheckCast(r6.clone(), String[].class, "com.obric.aiagent.plugin");
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L13:
            throw new IllegalArgumentException("At least one cipher suite is required".toString());
        L7:
            r3 = false;
            goto L9
        L15:
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final a a(ag... r7) {
            d.h.b.o.e(r7, "tlsVersions");
            a r6 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (r6.f40169a == false) goto L10;
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r7.length), Collection.class, "com.obric.aiagent.plugin");
            int r2 = r7.length;
            int r4 = 0;
        L5:
            if (r4 >= r2) goto L7;
            r0.add(r7[r4].a());
            r4 = r4 + 1;
            goto L5
        L7:
            String[] r8 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
            return r6.b((String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r8, r8.length), String[].class, "com.obric.aiagent.plugin"));
        L10:
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public final a b(String... r6) {
            d.h.b.o.e(r6, "tlsVersions");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (r2.f40169a == false) goto L15;
            if (r6.length != 0) goto L7;
            boolean r3 = true;
        L9:
            if ((!r3) == false) goto L13;
            r2.f40171c = (String[]) ZeusTransformUtils.preCheckCast(r6.clone(), String[].class, "com.obric.aiagent.plugin");
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L13:
            throw new IllegalArgumentException("At least one TLS version is required".toString());
        L7:
            r3 = false;
            goto L9
        L15:
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public final a a(boolean r5) {
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (r2.f40169a == false) goto L7;
            r2.f40172d = r5;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
        }

        public final l a() {
            return new l(this.f40169a, this.f40172d, this.f40170b, this.f40171c);
        }
    }

    /* JADX INFO: compiled from: ConnectionSpec.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    public l(boolean r1, boolean r2, String[] r3, String[] r4) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.i = r4;
    }

    public static final /* synthetic */ String[] a(l r0) {
        return r0.h;
    }

    public static final /* synthetic */ String[] b(l r0) {
        return r0.i;
    }

    public final boolean a() {
        return this.f;
    }

    public final boolean b() {
        return this.g;
    }

    public final List<i> c() {
        String[] r6 = this.h;
        if (r6 == null) goto L8;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r6.length), Collection.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        int r3 = r6.length;
    L5:
        if (r1 >= r3) goto L11;
        String r4 = r6[r1];
        r0.add(i.f39784a.a(r4));
        r1 = r1 + 1;
        goto L5
    L11:
        return d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    L8:
        return null;
    }

    public final List<ag> d() {
        String[] r6 = this.i;
        if (r6 == null) goto L8;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r6.length), Collection.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        int r3 = r6.length;
    L5:
        if (r1 >= r3) goto L11;
        String r4 = r6[r1];
        r0.add(ag.f39729a.a(r4));
        r1 = r1 + 1;
        goto L5
    L11:
        return d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    L8:
        return null;
    }

    public final void a(SSLSocket r2, boolean r3) {
        d.h.b.o.e(r2, "sslSocket");
        l r1 = b(r2, r3);
        if (r1.d() == null) goto L6;
        r2.setEnabledProtocols(r1.i);
    L6:
        if (r1.c() == null) goto L9;
        r2.setEnabledCipherSuites(r1.h);
        return;
    }

    private final l b(SSLSocket r5, boolean r6) {
        if (this.h == null) goto L5;
        String[] r0 = r5.getEnabledCipherSuites();
        d.h.b.o.c(r0, "sslSocket.enabledCipherSuites");
        String[] r1 = okhttp3.internal.c.a(r0, this.h, i.f39784a.a());
    L7:
        if (this.i == null) goto L9;
        String[] r2 = r5.getEnabledProtocols();
        d.h.b.o.c(r2, "sslSocket.enabledProtocols");
        String[] r3 = okhttp3.internal.c.a(r2, this.i, d.b.a.a());
    L10:
        String[] r7 = r5.getSupportedCipherSuites();
        d.h.b.o.c(r7, "supportedCipherSuites");
        int r4 = okhttp3.internal.c.a(r7, "TLS_FALLBACK_SCSV", i.f39784a.a());
        if (r6 == true) goto L13;
    L15:
        a r8 = new a(this);
        d.h.b.o.c(r1, "cipherSuitesIntersection");
        a r9 = r8.a((String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1, r1.length), String[].class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r3, "tlsVersionsIntersection");
        return r9.b((String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), String[].class, "com.obric.aiagent.plugin")).a();
    L13:
        if (r4 == (-1)) goto L15;
        d.h.b.o.c(r1, "cipherSuitesIntersection");
        String r10 = r7[r4];
        d.h.b.o.c(r10, "supportedCipherSuites[indexOfFallbackScsv]");
        r1 = okhttp3.internal.c.a(r1, r10);
        goto L15
    L9:
        r3 = r5.getEnabledProtocols();
        goto L10
    L5:
        r1 = r5.getEnabledCipherSuites();
        goto L7
    }

    public final boolean a(SSLSocket r5) {
        d.h.b.o.e(r5, "socket");
        if (this.f == true) goto L5;
        return false;
    L5:
        String[] r0 = this.i;
        if (r0 != null) goto L8;
    L10:
        String[] r4 = this.h;
        if (r4 != null) goto L13;
        return true;
    L13:
        if (okhttp3.internal.c.b(r4, r5.getEnabledCipherSuites(), i.f39784a.a()) == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        if (okhttp3.internal.c.b(r0, r5.getEnabledProtocols(), d.b.a.a()) == true) goto L10;
        return false;
    }

    public boolean equals(Object r7) {
        if (ZeusTransformUtils.instanceOf(r7, l.class) == true) goto L6;
        return false;
    L6:
        if (r7 != this) goto L9;
        return true;
    L9:
        if (this.f == ((l) ZeusTransformUtils.preCheckCast(r7, l.class, "com.obric.aiagent.plugin")).f) goto L12;
        return false;
    L12:
        if (this.f == true) goto L14;
    L22:
        return true;
    L14:
        if (Arrays.equals(this.h, ((l) ZeusTransformUtils.preCheckCast(r7, l.class, "com.obric.aiagent.plugin")).h) == true) goto L17;
        return false;
    L17:
        if (Arrays.equals(this.i, ((l) ZeusTransformUtils.preCheckCast(r7, l.class, "com.obric.aiagent.plugin")).i) == true) goto L20;
        return false;
    L20:
        if (this.g == ((l) ZeusTransformUtils.preCheckCast(r7, l.class, "com.obric.aiagent.plugin")).g) goto L22;
        return false;
    }

    public int hashCode() {
        if (this.f == false) goto L12;
        String[] r1 = this.h;
        int r2 = 0;
        if (r1 == null) goto L7;
        int r3 = Arrays.hashCode(r1);
    L8:
        int r0 = (527 + r3) * 31;
        String[] r4 = this.i;
        if (r4 == null) goto L14;
        r2 = Arrays.hashCode(r4);
    L14:
        return ((r0 + r2) * 31) + (!this.g ? 1 : 0);
    L7:
        r3 = 0;
        goto L8
    L12:
        return 17;
    }

    public String toString() {
        if (this.f == true) goto L7;
        return "ConnectionSpec()";
    L7:
        return "ConnectionSpec(cipherSuites=" + Objects.toString(c(), "[all enabled]") + ", tlsVersions=" + Objects.toString(d(), "[all enabled]") + ", supportsTlsExtensions=" + this.g + ')';
    }

    static {
        f40164a = new b(null);
        i[] r1 = {i.bl, i.bm, i.bn, i.aX, i.bb, i.aY, i.bc, i.bi, i.bh};
        j = r1;
        i[] r2 = {i.bl, i.bm, i.bn, i.aX, i.bb, i.aY, i.bc, i.bi, i.bh, i.aI, i.aJ, i.ag, i.ah, i.E, i.I, i.i};
        k = r2;
        f40165b = new a(true).a((i[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1, r1.length), i[].class, "com.obric.aiagent.plugin")).a(new ag[]{ag.f39730b, ag.f39731c}).a(true).a();
        f40166c = new a(true).a((i[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length), i[].class, "com.obric.aiagent.plugin")).a(new ag[]{ag.f39730b, ag.f39731c}).a(true).a();
        f40167d = new a(true).a((i[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length), i[].class, "com.obric.aiagent.plugin")).a(new ag[]{ag.f39730b, ag.f39731c, ag.f39732d, ag.f39733e}).a(true).a();
        f40168e = new a(false).a();
    }
}
