package F9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import okhttp3.TlsVersion;

/* renamed from: F9.m, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0235m {
    public static final C0235m e;
    public static final C0235m f;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f650a;
    public final boolean b;
    public final String[] c;
    public final String[] d;

    static {
        C0232j c0232j = C0232j.f644r;
        C0232j c0232j2 = C0232j.f645s;
        C0232j c0232j3 = C0232j.f646t;
        C0232j c0232j4 = C0232j.l;
        C0232j c0232j5 = C0232j.n;
        C0232j c0232j6 = C0232j.m;
        C0232j c0232j7 = C0232j.o;
        C0232j c0232j8 = C0232j.f643q;
        C0232j c0232j9 = C0232j.p;
        C0232j[] c0232jArr = {c0232j, c0232j2, c0232j3, c0232j4, c0232j5, c0232j6, c0232j7, c0232j8, c0232j9};
        C0232j[] c0232jArr2 = {c0232j, c0232j2, c0232j3, c0232j4, c0232j5, c0232j6, c0232j7, c0232j8, c0232j9, C0232j.f642j, C0232j.k, C0232j.h, C0232j.i, C0232j.f, C0232j.g, C0232j.e};
        C0234l c0234l = new C0234l();
        c0234l.d((C0232j[]) Arrays.copyOf(c0232jArr, 9));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        c0234l.y(tlsVersion, tlsVersion2);
        if (!c0234l.f649a) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }
        c0234l.b = true;
        c0234l.c();
        C0234l c0234l2 = new C0234l();
        c0234l2.d((C0232j[]) Arrays.copyOf(c0232jArr2, 16));
        c0234l2.y(tlsVersion, tlsVersion2);
        if (!c0234l2.f649a) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }
        c0234l2.b = true;
        e = c0234l2.c();
        C0234l c0234l3 = new C0234l();
        c0234l3.d((C0232j[]) Arrays.copyOf(c0232jArr2, 16));
        c0234l3.y(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        if (!c0234l3.f649a) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }
        c0234l3.b = true;
        c0234l3.c();
        f = new C0235m(false, false, null, null);
    }

    public C0235m(boolean z10, boolean z11, String[] strArr, String[] strArr2) {
        this.f650a = z10;
        this.b = z11;
        this.c = strArr;
        this.d = strArr2;
    }

    public final List a() {
        String[] strArr = this.c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(C0232j.b.d(str));
        }
        return D7.v.f1(arrayList);
    }

    public final boolean b(SSLSocket sSLSocket) {
        if (!this.f650a) {
            return false;
        }
        String[] strArr = this.d;
        if (strArr != null && !G9.b.h(strArr, sSLSocket.getEnabledProtocols(), F7.b.b)) {
            return false;
        }
        String[] strArr2 = this.c;
        return strArr2 == null || G9.b.h(strArr2, sSLSocket.getEnabledCipherSuites(), C0232j.c);
    }

    public final List c() {
        String[] strArr = this.d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(AbstractC0226d.f(str));
        }
        return D7.v.f1(arrayList);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0235m)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C0235m c0235m = (C0235m) obj;
        boolean z10 = c0235m.f650a;
        boolean z11 = this.f650a;
        if (z11 != z10) {
            return false;
        }
        if (z11) {
            return Arrays.equals(this.c, c0235m.c) && Arrays.equals(this.d, c0235m.d) && this.b == c0235m.b;
        }
        return true;
    }

    public final int hashCode() {
        if (!this.f650a) {
            return 17;
        }
        String[] strArr = this.c;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.b ? 1 : 0);
    }

    public final String toString() {
        if (!this.f650a) {
            return "ConnectionSpec()";
        }
        StringBuilder sb = new StringBuilder("ConnectionSpec(cipherSuites=");
        sb.append(Objects.toString(a(), "[all enabled]"));
        sb.append(", tlsVersions=");
        sb.append(Objects.toString(c(), "[all enabled]"));
        sb.append(", supportsTlsExtensions=");
        return androidx.appfunctions.metadata.a.r(sb, this.b, ')');
    }
}
