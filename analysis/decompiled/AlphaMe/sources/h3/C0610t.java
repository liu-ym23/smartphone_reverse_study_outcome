package h3;

import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* renamed from: h3.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0610t {

    /* renamed from: e, reason: collision with root package name */
    public static final C0610t f12967e;

    /* renamed from: f, reason: collision with root package name */
    public static final C0610t f12968f;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f12969a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12970b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f12971c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f12972d;

    static {
        C0607p c0607p = C0607p.f12958r;
        C0607p c0607p2 = C0607p.f12959s;
        C0607p c0607p3 = C0607p.f12960t;
        C0607p c0607p4 = C0607p.f12952l;
        C0607p c0607p5 = C0607p.f12954n;
        C0607p c0607p6 = C0607p.f12953m;
        C0607p c0607p7 = C0607p.f12955o;
        C0607p c0607p8 = C0607p.f12957q;
        C0607p c0607p9 = C0607p.f12956p;
        C0607p[] c0607pArr = {c0607p, c0607p2, c0607p3, c0607p4, c0607p5, c0607p6, c0607p7, c0607p8, c0607p9, C0607p.f12950j, C0607p.f12951k, C0607p.f12948h, C0607p.f12949i, C0607p.f12946f, C0607p.f12947g, C0607p.f12945e};
        C0609s c0609s = new C0609s();
        c0609s.b((C0607p[]) Arrays.copyOf(new C0607p[]{c0607p, c0607p2, c0607p3, c0607p4, c0607p5, c0607p6, c0607p7, c0607p8, c0607p9}, 9));
        h0 h0Var = h0.TLS_1_3;
        h0 h0Var2 = h0.TLS_1_2;
        c0609s.e(h0Var, h0Var2);
        c0609s.d();
        c0609s.a();
        C0609s c0609s2 = new C0609s();
        c0609s2.b((C0607p[]) Arrays.copyOf(c0607pArr, 16));
        c0609s2.e(h0Var, h0Var2);
        c0609s2.d();
        f12967e = c0609s2.a();
        C0609s c0609s3 = new C0609s();
        c0609s3.b((C0607p[]) Arrays.copyOf(c0607pArr, 16));
        c0609s3.e(h0Var, h0Var2, h0.TLS_1_1, h0.TLS_1_0);
        c0609s3.d();
        c0609s3.a();
        f12968f = new C0610t(false, false, null, null);
    }

    public C0610t(boolean z4, boolean z5, String[] strArr, String[] strArr2) {
        this.f12969a = z4;
        this.f12970b = z5;
        this.f12971c = strArr;
        this.f12972d = strArr2;
    }

    public final void a(SSLSocket sslSocket, boolean z4) {
        String[] cipherSuitesIntersection;
        String[] tlsVersionsIntersection;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        String[] strArr = this.f12971c;
        if (strArr != null) {
            String[] enabledCipherSuites = sslSocket.getEnabledCipherSuites();
            Intrinsics.checkNotNullExpressionValue(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            cipherSuitesIntersection = Util.intersect(enabledCipherSuites, strArr, C0607p.f12943c);
        } else {
            cipherSuitesIntersection = sslSocket.getEnabledCipherSuites();
        }
        String[] strArr2 = this.f12972d;
        if (strArr2 != null) {
            String[] enabledProtocols = sslSocket.getEnabledProtocols();
            Intrinsics.checkNotNullExpressionValue(enabledProtocols, "sslSocket.enabledProtocols");
            tlsVersionsIntersection = Util.intersect(enabledProtocols, strArr2, ComparisonsKt.naturalOrder());
        } else {
            tlsVersionsIntersection = sslSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sslSocket.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, "supportedCipherSuites");
        int iIndexOf = Util.indexOf(supportedCipherSuites, "TLS_FALLBACK_SCSV", C0607p.f12943c);
        if (z4 && iIndexOf != -1) {
            Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
            String str = supportedCipherSuites[iIndexOf];
            Intrinsics.checkNotNullExpressionValue(str, "supportedCipherSuites[indexOfFallbackScsv]");
            cipherSuitesIntersection = Util.concat(cipherSuitesIntersection, str);
        }
        Intrinsics.checkNotNullParameter(this, "connectionSpec");
        C0609s c0609s = new C0609s();
        c0609s.f12963a = this.f12969a;
        c0609s.f12964b = strArr;
        c0609s.f12965c = strArr2;
        c0609s.f12966d = this.f12970b;
        Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
        c0609s.c((String[]) Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length));
        Intrinsics.checkNotNullExpressionValue(tlsVersionsIntersection, "tlsVersionsIntersection");
        c0609s.f((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length));
        C0610t c0610tA = c0609s.a();
        if (c0610tA.d() != null) {
            sslSocket.setEnabledProtocols(c0610tA.f12972d);
        }
        if (c0610tA.b() != null) {
            sslSocket.setEnabledCipherSuites(c0610tA.f12971c);
        }
    }

    public final List b() {
        String[] strArr = this.f12971c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(C0607p.f12942b.b(str));
        }
        return CollectionsKt.toList(arrayList);
    }

    public final boolean c(SSLSocket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        if (!this.f12969a) {
            return false;
        }
        String[] strArr = this.f12972d;
        if (strArr != null && !Util.hasIntersection(strArr, socket.getEnabledProtocols(), ComparisonsKt.naturalOrder())) {
            return false;
        }
        String[] strArr2 = this.f12971c;
        return strArr2 == null || Util.hasIntersection(strArr2, socket.getEnabledCipherSuites(), C0607p.f12943c);
    }

    public final List d() {
        String[] strArr = this.f12972d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(C0611u.l(str));
        }
        return CollectionsKt.toList(arrayList);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0610t)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C0610t c0610t = (C0610t) obj;
        boolean z4 = c0610t.f12969a;
        boolean z5 = this.f12969a;
        if (z5 != z4) {
            return false;
        }
        return !z5 || (Arrays.equals(this.f12971c, c0610t.f12971c) && Arrays.equals(this.f12972d, c0610t.f12972d) && this.f12970b == c0610t.f12970b);
    }

    public final int hashCode() {
        if (!this.f12969a) {
            return 17;
        }
        String[] strArr = this.f12971c;
        int iHashCode = (527 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        String[] strArr2 = this.f12972d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f12970b ? 1 : 0);
    }

    public final String toString() {
        if (!this.f12969a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + ((Object) Objects.toString(b(), "[all enabled]")) + ", tlsVersions=" + ((Object) Objects.toString(d(), "[all enabled]")) + ", supportsTlsExtensions=" + this.f12970b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
