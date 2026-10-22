package ab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: e, reason: collision with root package name */
    public static final i f552e;

    /* renamed from: f, reason: collision with root package name */
    public static final i f553f;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f554a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f555b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f556c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f557d;

    static {
        g gVar = g.f544r;
        g gVar2 = g.f545s;
        g gVar3 = g.f546t;
        g gVar4 = g.f538l;
        g gVar5 = g.f540n;
        g gVar6 = g.f539m;
        g gVar7 = g.f541o;
        g gVar8 = g.f543q;
        g gVar9 = g.f542p;
        g[] gVarArr = {gVar, gVar2, gVar3, gVar4, gVar5, gVar6, gVar7, gVar8, gVar9};
        g[] gVarArr2 = {gVar, gVar2, gVar3, gVar4, gVar5, gVar6, gVar7, gVar8, gVar9, g.f536j, g.f537k, g.f534h, g.f535i, g.f532f, g.f533g, g.f531e};
        h hVar = new h();
        hVar.b((g[]) Arrays.copyOf(gVarArr, 9));
        d0 d0Var = d0.TLS_1_3;
        d0 d0Var2 = d0.TLS_1_2;
        hVar.d(d0Var, d0Var2);
        hVar.f551d = true;
        hVar.a();
        h hVar2 = new h();
        hVar2.b((g[]) Arrays.copyOf(gVarArr2, 16));
        hVar2.d(d0Var, d0Var2);
        hVar2.f551d = true;
        f552e = hVar2.a();
        h hVar3 = new h();
        hVar3.b((g[]) Arrays.copyOf(gVarArr2, 16));
        hVar3.d(d0Var, d0Var2, d0.TLS_1_1, d0.TLS_1_0);
        hVar3.f551d = true;
        hVar3.a();
        f553f = new i(false, false, null, null);
    }

    public i(boolean z4, boolean z10, String[] strArr, String[] strArr2) {
        this.f554a = z4;
        this.f555b = z10;
        this.f556c = strArr;
        this.f557d = strArr2;
    }

    public final List a() {
        String[] strArr = this.f556c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(g.f528b.c(str));
        }
        return d7.r.m1(arrayList);
    }

    public final boolean b(SSLSocket sSLSocket) {
        if (!this.f554a) {
            return false;
        }
        String[] strArr = this.f557d;
        if (strArr != null && !bb.b.j(strArr, sSLSocket.getEnabledProtocols(), f7.b.f3457b)) {
            return false;
        }
        String[] strArr2 = this.f556c;
        return strArr2 == null || bb.b.j(strArr2, sSLSocket.getEnabledCipherSuites(), g.f529c);
    }

    public final List c() {
        String[] strArr = this.f557d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(ib.k.x(str));
        }
        return d7.r.m1(arrayList);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        i iVar = (i) obj;
        boolean z4 = iVar.f554a;
        boolean z10 = this.f554a;
        if (z10 != z4) {
            return false;
        }
        if (z10) {
            return Arrays.equals(this.f556c, iVar.f556c) && Arrays.equals(this.f557d, iVar.f557d) && this.f555b == iVar.f555b;
        }
        return true;
    }

    public final int hashCode() {
        if (!this.f554a) {
            return 17;
        }
        String[] strArr = this.f556c;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f557d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f555b ? 1 : 0);
    }

    public final String toString() {
        if (!this.f554a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(a(), "[all enabled]") + ", tlsVersions=" + Objects.toString(c(), "[all enabled]") + ", supportsTlsExtensions=" + this.f555b + ')';
    }
}
