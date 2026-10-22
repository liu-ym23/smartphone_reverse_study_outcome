package ad;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: e, reason: collision with root package name */
    public static final i f512e;

    /* renamed from: f, reason: collision with root package name */
    public static final i f513f;

    /* renamed from: a, reason: collision with root package name */
    public boolean f514a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f515b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f516c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f517d;

    static {
        g gVar = g.f500r;
        g gVar2 = g.f501s;
        g gVar3 = g.f502t;
        g gVar4 = g.f494l;
        g gVar5 = g.f496n;
        g gVar6 = g.f495m;
        g gVar7 = g.f497o;
        g gVar8 = g.f499q;
        g gVar9 = g.f498p;
        g[] gVarArr = {gVar, gVar2, gVar3, gVar4, gVar5, gVar6, gVar7, gVar8, gVar9};
        g[] gVarArr2 = {gVar, gVar2, gVar3, gVar4, gVar5, gVar6, gVar7, gVar8, gVar9, g.f492j, g.f493k, g.f491h, g.i, g.f489f, g.f490g, g.f488e};
        h hVar = new h();
        hVar.b((g[]) Arrays.copyOf(gVarArr, 9));
        j0 j0Var = j0.TLS_1_3;
        j0 j0Var2 = j0.TLS_1_2;
        hVar.d(j0Var, j0Var2);
        hVar.f508b = true;
        hVar.a();
        h hVar2 = new h();
        hVar2.b((g[]) Arrays.copyOf(gVarArr2, 16));
        hVar2.d(j0Var, j0Var2);
        hVar2.f508b = true;
        f512e = hVar2.a();
        h hVar3 = new h();
        hVar3.b((g[]) Arrays.copyOf(gVarArr2, 16));
        hVar3.d(j0Var, j0Var2, j0.TLS_1_1, j0.TLS_1_0);
        hVar3.f508b = true;
        hVar3.a();
        i iVar = new i();
        iVar.f514a = false;
        iVar.f515b = false;
        iVar.f516c = null;
        iVar.f517d = null;
        VarHandle.storeStoreFence();
        f513f = iVar;
    }

    public final List a() {
        String[] strArr = this.f516c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(g.f485b.c(str));
        }
        return kb.l.L0(arrayList);
    }

    public final boolean b(SSLSocket sSLSocket) {
        if (!this.f514a) {
            return false;
        }
        String[] strArr = this.f517d;
        if (strArr != null && !bd.b.i(strArr, sSLSocket.getEnabledProtocols(), mb.a.f8547f)) {
            return false;
        }
        String[] strArr2 = this.f516c;
        return strArr2 == null || bd.b.i(strArr2, sSLSocket.getEnabledCipherSuites(), g.f486c);
    }

    public final List c() {
        String[] strArr = this.f517d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(a.a.v(str));
        }
        return kb.l.L0(arrayList);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z10 = this.f514a;
        i iVar = (i) obj;
        if (z10 != iVar.f514a) {
            return false;
        }
        if (z10) {
            return Arrays.equals(this.f516c, iVar.f516c) && Arrays.equals(this.f517d, iVar.f517d) && this.f515b == iVar.f515b;
        }
        return true;
    }

    public final int hashCode() {
        if (!this.f514a) {
            return 17;
        }
        String[] strArr = this.f516c;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f517d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f515b ? 1 : 0);
    }

    public final String toString() {
        if (!this.f514a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(a(), "[all enabled]") + ", tlsVersions=" + Objects.toString(c(), "[all enabled]") + ", supportsTlsExtensions=" + this.f515b + ')';
    }
}
