package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes4.dex */
public final class ConnectionSpec {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d[] f22680e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConnectionSpec f22681f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConnectionSpec f22682g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConnectionSpec f22683h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f22684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f22685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f22686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f22687d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f22688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f22689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String[] f22690c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f22691d;

        public a(boolean r10) {
            this.f22688a = r10;
        }

        public ConnectionSpec a() {
            return new ConnectionSpec(this);
        }

        public a b(String... r10) {
            if (this.f22688a == false) goto L11;
            if (r10.length == 0) goto L9;
            this.f22689b = (String[]) r10.clone();
            return this;
        L9:
            throw new IllegalArgumentException("At least one cipher suite is required");
        L11:
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a c(d... r10) {
            if (this.f22688a == false) goto L11;
            String[] r11 = new String[r10.length];
            int r12 = 0;
        L6:
            if (r12 >= r10.length) goto L9;
            r11[r12] = r10[r12].f22922a;
            r12 = r12 + 1;
            goto L6
        L9:
            return b(r11);
        L11:
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a d(boolean r10) {
            if (this.f22688a == false) goto L7;
            this.f22691d = r10;
            return this;
        L7:
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a e(String... r10) {
            if (this.f22688a == false) goto L11;
            if (r10.length == 0) goto L9;
            this.f22690c = (String[]) r10.clone();
            return this;
        L9:
            throw new IllegalArgumentException("At least one TLS version is required");
        L11:
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a f(TlsVersion... r10) {
            if (this.f22688a == false) goto L11;
            String[] r11 = new String[r10.length];
            int r12 = 0;
        L6:
            if (r12 >= r10.length) goto L9;
            r11[r12] = r10[r12].javaName;
            r12 = r12 + 1;
            goto L6
        L9:
            return e(r11);
        L11:
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(ConnectionSpec r10) {
            this.f22688a = r10.f22684a;
            this.f22689b = r10.f22686c;
            this.f22690c = r10.f22687d;
            this.f22691d = r10.f22685b;
        }
    }

    static {
        d[] r10 = {d.Z0, d.f22870d1, d.f22861a1, d.f22873e1, d.f22891k1, d.f22888j1, d.K0, d.L0, d.f22884i0, d.f22887j0, d.G, d.K, d.f22889k};
        f22680e = r10;
        a r11 = new a(true).c(r10);
        TlsVersion r12 = TlsVersion.TLS_1_3;
        TlsVersion r13 = TlsVersion.TLS_1_2;
        TlsVersion r14 = TlsVersion.TLS_1_1;
        TlsVersion r15 = TlsVersion.TLS_1_0;
        ConnectionSpec r16 = r11.f(new TlsVersion[]{r12, r13, r14, r15}).d(true).a();
        f22681f = r16;
        f22682g = new a(r16).f(new TlsVersion[]{r15}).d(true).a();
        f22683h = new a(false).a();
    }

    public ConnectionSpec(a r10) {
        this.f22684a = r10.f22688a;
        this.f22686c = r10.f22689b;
        this.f22687d = r10.f22690c;
        this.f22685b = r10.f22691d;
    }

    public void a(SSLSocket r10, boolean r11) {
        ConnectionSpec r12 = e(r10, r11);
        String[] r13 = r12.f22687d;
        if (r13 == null) goto L5;
        r10.setEnabledProtocols(r13);
    L5:
        String[] r14 = r12.f22686c;
        if (r14 == null) goto L9;
        r10.setEnabledCipherSuites(r14);
        return;
    }

    public List b() {
        String[] r10 = this.f22686c;
        if (r10 != null) goto L7;
        return null;
    L7:
        return d.b(r10);
    }

    public boolean c(SSLSocket r10) {
        if (this.f22684a == true) goto L5;
        return false;
    L5:
        String[] r11 = this.f22687d;
        if (r11 != null) goto L8;
    L10:
        String[] r12 = this.f22686c;
        if (r12 != null) goto L13;
        return true;
    L13:
        if (Util.nonEmptyIntersection(d.f22862b, r12, r10.getEnabledCipherSuites()) == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        if (Util.nonEmptyIntersection(Util.NATURAL_ORDER, r11, r10.getEnabledProtocols()) == true) goto L10;
        return false;
    }

    public boolean d() {
        return this.f22684a;
    }

    public final ConnectionSpec e(SSLSocket r10, boolean r11) {
        if (this.f22686c == null) goto L5;
        String[] r12 = Util.intersect(d.f22862b, r10.getEnabledCipherSuites(), this.f22686c);
    L7:
        if (this.f22687d == null) goto L9;
        String[] r13 = Util.intersect(Util.NATURAL_ORDER, r10.getEnabledProtocols(), this.f22687d);
    L10:
        String[] r14 = r10.getSupportedCipherSuites();
        int r15 = Util.indexOf(d.f22862b, r14, "TLS_FALLBACK_SCSV");
        if (r11 == false) goto L16;
        if (r15 == (-1)) goto L16;
        r12 = Util.concat(r12, r14[r15]);
    L16:
        return new a(this).b(r12).e(r13).a();
    L9:
        r13 = r10.getEnabledProtocols();
        goto L10
    L5:
        r12 = r10.getEnabledCipherSuites();
        goto L7
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof ConnectionSpec) == true) goto L6;
        return false;
    L6:
        if (r10 != this) goto L8;
        return true;
    L8:
        ConnectionSpec r11 = (ConnectionSpec) r10;
        boolean r12 = this.f22684a;
        if (r12 == r11.f22684a) goto L11;
        return false;
    L11:
        if (r12 == true) goto L13;
    L21:
        return true;
    L13:
        if (Arrays.equals(this.f22686c, r11.f22686c) == true) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.f22687d, r11.f22687d) == true) goto L19;
        return false;
    L19:
        if (this.f22685b == r11.f22685b) goto L21;
        return false;
    }

    public boolean f() {
        return this.f22685b;
    }

    public List g() {
        String[] r10 = this.f22687d;
        if (r10 != null) goto L7;
        return null;
    L7:
        return TlsVersion.forJavaNames(r10);
    }

    public int hashCode() {
        if (this.f22684a == true) goto L7;
        return 17;
    L7:
        return ((((527 + Arrays.hashCode(this.f22686c)) * 31) + Arrays.hashCode(this.f22687d)) * 31) + (!this.f22685b ? 1 : 0);
    }

    public String toString() {
        if (this.f22684a == true) goto L6;
        return "ConnectionSpec()";
    L6:
        String r10 = "[all enabled]";
        if (this.f22686c == null) goto L9;
        String r11 = b().toString();
    L11:
        if (this.f22687d == null) goto L14;
        r10 = g().toString();
    L14:
        return "ConnectionSpec(cipherSuites=" + r11 + ", tlsVersions=" + r10 + ", supportsTlsExtensions=" + this.f22685b + ")";
    L9:
        r11 = "[all enabled]";
        goto L11
    }
}
