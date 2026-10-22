package okhttp3;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import ub.C5642b;
import ub.n;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0002\u001e\u000fB9\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0004\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b\"\u0010!R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$R\u0019\u0010*\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8G¢\u0006\u0006\u001a\u0004\b#\u0010)R\u0019\u0010-\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010'8G¢\u0006\u0006\u001a\u0004\b,\u0010)¨\u0006."}, d2 = {"Lokhttp3/b;", "", "", "isTls", "supportsTlsExtensions", "", "", "cipherSuitesAsString", "tlsVersionsAsString", "<init>", "(ZZ[Ljava/lang/String;[Ljava/lang/String;)V", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "isFallback", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljavax/net/ssl/SSLSocket;Z)V", "socket", "e", "(Ljavax/net/ssl/SSLSocket;)Z", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljavax/net/ssl/SSLSocket;Z)Lokhttp3/b;", Const.INTENT_KEY_APIKEY, "Z", "f", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "c", "[Ljava/lang/String;", Const.INTENT_KEY_UMID, "()[Ljava/lang/String;", "", "Lokhttp3/a;", "()Ljava/util/List;", "cipherSuites", "Lokhttp3/TlsVersion;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "tlsVersions", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final List<okhttp3.a> f37627f;

    /* renamed from: g, reason: collision with root package name */
    public static final List<okhttp3.a> f37628g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f37629h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f37630i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f37631j;

    /* renamed from: k, reason: collision with root package name */
    public static final b f37632k;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean isTls;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean supportsTlsExtensions;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String[] cipherSuitesAsString;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String[] tlsVersionsAsString;

    static {
        okhttp3.a aVar = okhttp3.a.f37598o1;
        okhttp3.a aVar2 = okhttp3.a.f37601p1;
        okhttp3.a aVar3 = okhttp3.a.f37604q1;
        okhttp3.a aVar4 = okhttp3.a.f37556a1;
        okhttp3.a aVar5 = okhttp3.a.f37568e1;
        okhttp3.a aVar6 = okhttp3.a.f37559b1;
        okhttp3.a aVar7 = okhttp3.a.f37571f1;
        okhttp3.a aVar8 = okhttp3.a.f37589l1;
        okhttp3.a aVar9 = okhttp3.a.f37586k1;
        List<okhttp3.a> listP = C1173v.p(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
        f37627f = listP;
        List<okhttp3.a> listP2 = C1173v.p(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, okhttp3.a.f37526L0, okhttp3.a.f37528M0, okhttp3.a.f37582j0, okhttp3.a.f37585k0, okhttp3.a.f37517H, okhttp3.a.f37525L, okhttp3.a.f37587l);
        f37628g = listP2;
        a aVar10 = new a(true);
        okhttp3.a[] aVarArr = (okhttp3.a[]) listP.toArray(new okhttp3.a[0]);
        a aVarC = aVar10.c((okhttp3.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        f37629h = aVarC.f(tlsVersion, tlsVersion2).d(true).a();
        a aVar11 = new a(true);
        okhttp3.a[] aVarArr2 = (okhttp3.a[]) listP2.toArray(new okhttp3.a[0]);
        f37630i = aVar11.c((okhttp3.a[]) Arrays.copyOf(aVarArr2, aVarArr2.length)).f(tlsVersion, tlsVersion2).d(true).a();
        a aVar12 = new a(true);
        okhttp3.a[] aVarArr3 = (okhttp3.a[]) listP2.toArray(new okhttp3.a[0]);
        f37631j = aVar12.c((okhttp3.a[]) Arrays.copyOf(aVarArr3, aVarArr3.length)).f(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).d(true).a();
        f37632k = new a(false).a();
    }

    public b(boolean z10, boolean z11, String[] strArr, String[] strArr2) {
        this.isTls = z10;
        this.supportsTlsExtensions = z11;
        this.cipherSuitesAsString = strArr;
        this.tlsVersionsAsString = strArr2;
    }

    public final void b(SSLSocket sslSocket, boolean isFallback) {
        p.i(sslSocket, "sslSocket");
        b bVarG = g(sslSocket, isFallback);
        if (bVarG.i() != null) {
            sslSocket.setEnabledProtocols(bVarG.tlsVersionsAsString);
        }
        if (bVarG.c() != null) {
            sslSocket.setEnabledCipherSuites(bVarG.cipherSuitesAsString);
        }
    }

    public final List<okhttp3.a> c() {
        String[] strArr = this.cipherSuitesAsString;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(okhttp3.a.INSTANCE.b(str));
        }
        return arrayList;
    }

    /* renamed from: d, reason: from getter */
    public final String[] getCipherSuitesAsString() {
        return this.cipherSuitesAsString;
    }

    public final boolean e(SSLSocket socket) {
        p.i(socket, "socket");
        if (!this.isTls) {
            return false;
        }
        String[] strArr = this.tlsVersionsAsString;
        if (strArr != null && !n.l(strArr, socket.getEnabledProtocols(), b9.b.f())) {
            return false;
        }
        String[] strArr2 = this.cipherSuitesAsString;
        return strArr2 == null || n.l(strArr2, socket.getEnabledCipherSuites(), okhttp3.a.INSTANCE.c());
    }

    public boolean equals(Object other) {
        if (!(other instanceof b)) {
            return false;
        }
        if (other == this) {
            return true;
        }
        boolean z10 = this.isTls;
        b bVar = (b) other;
        if (z10 != bVar.isTls) {
            return false;
        }
        return !z10 || (Arrays.equals(this.cipherSuitesAsString, bVar.cipherSuitesAsString) && Arrays.equals(this.tlsVersionsAsString, bVar.tlsVersionsAsString) && this.supportsTlsExtensions == bVar.supportsTlsExtensions);
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsTls() {
        return this.isTls;
    }

    public final b g(SSLSocket sslSocket, boolean isFallback) {
        String[] enabledProtocols;
        String[] enabledCipherSuites = sslSocket.getEnabledCipherSuites();
        p.f(enabledCipherSuites);
        String[] strArrC = C5642b.c(this, enabledCipherSuites);
        if (this.tlsVersionsAsString != null) {
            String[] enabledProtocols2 = sslSocket.getEnabledProtocols();
            p.h(enabledProtocols2, "getEnabledProtocols(...)");
            enabledProtocols = n.u(enabledProtocols2, this.tlsVersionsAsString, b9.b.f());
        } else {
            enabledProtocols = sslSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sslSocket.getSupportedCipherSuites();
        p.f(supportedCipherSuites);
        int iM = n.m(supportedCipherSuites, "TLS_FALLBACK_SCSV", okhttp3.a.INSTANCE.c());
        if (isFallback && iM != -1) {
            String str = supportedCipherSuites[iM];
            p.h(str, "get(...)");
            strArrC = n.g(strArrC, str);
        }
        return new a(this).b((String[]) Arrays.copyOf(strArrC, strArrC.length)).e((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length)).a();
    }

    /* renamed from: h, reason: from getter */
    public final boolean getSupportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    public int hashCode() {
        if (!this.isTls) {
            return 17;
        }
        String[] strArr = this.cipherSuitesAsString;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.tlsVersionsAsString;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
    }

    public final List<TlsVersion> i() {
        String[] strArr = this.tlsVersionsAsString;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(TlsVersion.INSTANCE.a(str));
        }
        return arrayList;
    }

    public String toString() {
        if (!this.isTls) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(c(), "[all enabled]") + ", tlsVersions=" + Objects.toString(i(), "[all enabled]") + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ')';
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ!\u0010\f\u001a\u00020\u00002\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00002\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\t\"\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\t\"\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0015\u001a\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\t\"\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0010J\u0017\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u0005R*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001f\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\"\u0010\u0016\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u0005¨\u0006("}, d2 = {"Lokhttp3/b$a;", "", "", "tls", "<init>", "(Z)V", "Lokhttp3/b;", "connectionSpec", "(Lokhttp3/b;)V", "", "Lokhttp3/a;", "cipherSuites", "c", "([Lokhttp3/a;)Lokhttp3/b$a;", "", Const.INTENT_KEY_PKGNAME, "([Ljava/lang/String;)Lokhttp3/b$a;", "Lokhttp3/TlsVersion;", "tlsVersions", "f", "([Lokhttp3/TlsVersion;)Lokhttp3/b$a;", "e", "supportsTlsExtensions", Const.INTENT_KEY_UMID, "(Z)Lokhttp3/b$a;", Const.INTENT_KEY_APIKEY, "()Lokhttp3/b;", "Z", "getTls$okhttp", "()Z", "setTls$okhttp", "[Ljava/lang/String;", "getCipherSuites$okhttp", "()[Ljava/lang/String;", "setCipherSuites$okhttp", "([Ljava/lang/String;)V", "getTlsVersions$okhttp", "setTlsVersions$okhttp", "getSupportsTlsExtensions$okhttp", "setSupportsTlsExtensions$okhttp", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public boolean tls;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public String[] cipherSuites;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public String[] tlsVersions;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public boolean supportsTlsExtensions;

        public a(boolean z10) {
            this.tls = z10;
        }

        public final b a() {
            return new b(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
        }

        public final a b(String... cipherSuites) {
            p.i(cipherSuites, "cipherSuites");
            if (!this.tls) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections");
            }
            if (cipherSuites.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            Object[] objArrCopyOf = Arrays.copyOf(cipherSuites, cipherSuites.length);
            p.h(objArrCopyOf, "copyOf(...)");
            this.cipherSuites = (String[]) objArrCopyOf;
            return this;
        }

        public final a c(okhttp3.a... cipherSuites) {
            p.i(cipherSuites, "cipherSuites");
            if (!this.tls) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections");
            }
            ArrayList arrayList = new ArrayList(cipherSuites.length);
            for (okhttp3.a aVar : cipherSuites) {
                arrayList.add(aVar.getJavaName());
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            return b((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final a d(boolean supportsTlsExtensions) {
            if (!this.tls) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections");
            }
            this.supportsTlsExtensions = supportsTlsExtensions;
            return this;
        }

        public final a e(String... tlsVersions) {
            p.i(tlsVersions, "tlsVersions");
            if (!this.tls) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections");
            }
            if (tlsVersions.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            Object[] objArrCopyOf = Arrays.copyOf(tlsVersions, tlsVersions.length);
            p.h(objArrCopyOf, "copyOf(...)");
            this.tlsVersions = (String[]) objArrCopyOf;
            return this;
        }

        public final a f(TlsVersion... tlsVersions) {
            p.i(tlsVersions, "tlsVersions");
            if (!this.tls) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections");
            }
            ArrayList arrayList = new ArrayList(tlsVersions.length);
            for (TlsVersion tlsVersion : tlsVersions) {
                arrayList.add(tlsVersion.javaName());
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            return e((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public a(b connectionSpec) {
            p.i(connectionSpec, "connectionSpec");
            this.tls = connectionSpec.getIsTls();
            this.cipherSuites = connectionSpec.getCipherSuitesAsString();
            this.tlsVersions = connectionSpec.tlsVersionsAsString;
            this.supportsTlsExtensions = connectionSpec.getSupportsTlsExtensions();
        }
    }
}
