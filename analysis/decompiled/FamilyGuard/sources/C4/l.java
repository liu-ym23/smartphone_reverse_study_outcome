package C4;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: e, reason: collision with root package name */
    private static final C0279i[] f907e;

    /* renamed from: f, reason: collision with root package name */
    private static final C0279i[] f908f;

    /* renamed from: g, reason: collision with root package name */
    public static final l f909g;

    /* renamed from: h, reason: collision with root package name */
    public static final l f910h;

    /* renamed from: i, reason: collision with root package name */
    public static final l f911i;

    /* renamed from: j, reason: collision with root package name */
    public static final l f912j;

    /* renamed from: a, reason: collision with root package name */
    final boolean f913a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f914b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    final String[] f915c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    final String[] f916d;

    static {
        C0279i c0279i = C0279i.f876n1;
        C0279i c0279i2 = C0279i.f879o1;
        C0279i c0279i3 = C0279i.f882p1;
        C0279i c0279i4 = C0279i.f835Z0;
        C0279i c0279i5 = C0279i.f846d1;
        C0279i c0279i6 = C0279i.f837a1;
        C0279i c0279i7 = C0279i.f849e1;
        C0279i c0279i8 = C0279i.f867k1;
        C0279i c0279i9 = C0279i.f864j1;
        C0279i[] c0279iArr = {c0279i, c0279i2, c0279i3, c0279i4, c0279i5, c0279i6, c0279i7, c0279i8, c0279i9};
        f907e = c0279iArr;
        C0279i[] c0279iArr2 = {c0279i, c0279i2, c0279i3, c0279i4, c0279i5, c0279i6, c0279i7, c0279i8, c0279i9, C0279i.f805K0, C0279i.f807L0, C0279i.f860i0, C0279i.f863j0, C0279i.f796G, C0279i.f804K, C0279i.f865k};
        f908f = c0279iArr2;
        a aVarB = new a(true).b(c0279iArr);
        I i5 = I.TLS_1_3;
        I i6 = I.TLS_1_2;
        f909g = aVarB.e(i5, i6).d(true).a();
        f910h = new a(true).b(c0279iArr2).e(i5, i6).d(true).a();
        f911i = new a(true).b(c0279iArr2).e(i5, i6, I.TLS_1_1, I.TLS_1_0).d(true).a();
        f912j = new a(false).a();
    }

    l(a aVar) {
        this.f913a = aVar.f917a;
        this.f915c = aVar.f918b;
        this.f916d = aVar.f919c;
        this.f914b = aVar.f920d;
    }

    private l e(SSLSocket sSLSocket, boolean z5) {
        String[] strArrZ = this.f915c != null ? D4.e.z(C0279i.f838b, sSLSocket.getEnabledCipherSuites(), this.f915c) : sSLSocket.getEnabledCipherSuites();
        String[] strArrZ2 = this.f916d != null ? D4.e.z(D4.e.f1215j, sSLSocket.getEnabledProtocols(), this.f916d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iW = D4.e.w(C0279i.f838b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z5 && iW != -1) {
            strArrZ = D4.e.i(strArrZ, supportedCipherSuites[iW]);
        }
        return new a(this).c(strArrZ).f(strArrZ2).a();
    }

    void a(SSLSocket sSLSocket, boolean z5) {
        l lVarE = e(sSLSocket, z5);
        String[] strArr = lVarE.f916d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = lVarE.f915c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    @Nullable
    public List<C0279i> b() {
        String[] strArr = this.f915c;
        if (strArr != null) {
            return C0279i.c(strArr);
        }
        return null;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.f913a) {
            return false;
        }
        String[] strArr = this.f916d;
        if (strArr != null && !D4.e.B(D4.e.f1215j, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f915c;
        return strArr2 == null || D4.e.B(C0279i.f838b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean d() {
        return this.f913a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        l lVar = (l) obj;
        boolean z5 = this.f913a;
        if (z5 != lVar.f913a) {
            return false;
        }
        return !z5 || (Arrays.equals(this.f915c, lVar.f915c) && Arrays.equals(this.f916d, lVar.f916d) && this.f914b == lVar.f914b);
    }

    public boolean f() {
        return this.f914b;
    }

    @Nullable
    public List<I> g() {
        String[] strArr = this.f916d;
        if (strArr != null) {
            return I.d(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.f913a) {
            return ((((527 + Arrays.hashCode(this.f915c)) * 31) + Arrays.hashCode(this.f916d)) * 31) + (!this.f914b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f913a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(b(), "[all enabled]") + ", tlsVersions=" + Objects.toString(g(), "[all enabled]") + ", supportsTlsExtensions=" + this.f914b + ")";
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f917a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        String[] f918b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        String[] f919c;

        /* renamed from: d, reason: collision with root package name */
        boolean f920d;

        a(boolean z5) {
            this.f917a = z5;
        }

        public l a() {
            return new l(this);
        }

        public a b(C0279i... c0279iArr) {
            if (!this.f917a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[c0279iArr.length];
            for (int i5 = 0; i5 < c0279iArr.length; i5++) {
                strArr[i5] = c0279iArr[i5].f905a;
            }
            return c(strArr);
        }

        public a c(String... strArr) {
            if (!this.f917a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f918b = (String[]) strArr.clone();
            return this;
        }

        public a d(boolean z5) {
            if (!this.f917a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f920d = z5;
            return this;
        }

        public a e(I... iArr) {
            if (!this.f917a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[iArr.length];
            for (int i5 = 0; i5 < iArr.length; i5++) {
                strArr[i5] = iArr[i5].f740a;
            }
            return f(strArr);
        }

        public a f(String... strArr) {
            if (!this.f917a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f919c = (String[]) strArr.clone();
            return this;
        }

        public a(l lVar) {
            this.f917a = lVar.f913a;
            this.f918b = lVar.f915c;
            this.f919c = lVar.f916d;
            this.f920d = lVar.f914b;
        }
    }
}
