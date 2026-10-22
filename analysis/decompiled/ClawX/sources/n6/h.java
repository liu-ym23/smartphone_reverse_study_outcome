package n6;

import g.s1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: e, reason: collision with root package name */
    public static final h f4032e;

    /* renamed from: f, reason: collision with root package name */
    public static final h f4033f;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4034a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4035b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f4036c;
    public final String[] d;

    static {
        g gVar = g.f4028r;
        g gVar2 = g.f4029s;
        g gVar3 = g.f4030t;
        g gVar4 = g.f4022l;
        g gVar5 = g.f4024n;
        g gVar6 = g.f4023m;
        g gVar7 = g.f4025o;
        g gVar8 = g.f4027q;
        g gVar9 = g.f4026p;
        List listS = c5.l.S(new g[]{gVar, gVar2, gVar3, gVar4, gVar5, gVar6, gVar7, gVar8, gVar9});
        List listS2 = c5.l.S(new g[]{gVar, gVar2, gVar3, gVar4, gVar5, gVar6, gVar7, gVar8, gVar9, g.f4020j, g.f4021k, g.f4018h, g.f4019i, g.f4016f, g.f4017g, g.f4015e});
        s1 s1Var = new s1();
        g[] gVarArr = (g[]) listS.toArray(new g[0]);
        s1Var.c((g[]) Arrays.copyOf(gVarArr, gVarArr.length));
        y yVar = y.f4167c;
        y yVar2 = y.d;
        s1Var.e(yVar, yVar2);
        s1Var.f2823b = true;
        s1Var.a();
        s1 s1Var2 = new s1();
        g[] gVarArr2 = (g[]) listS2.toArray(new g[0]);
        s1Var2.c((g[]) Arrays.copyOf(gVarArr2, gVarArr2.length));
        s1Var2.e(yVar, yVar2);
        s1Var2.f2823b = true;
        f4032e = s1Var2.a();
        s1 s1Var3 = new s1();
        g[] gVarArr3 = (g[]) listS2.toArray(new g[0]);
        s1Var3.c((g[]) Arrays.copyOf(gVarArr3, gVarArr3.length));
        s1Var3.e(yVar, yVar2, y.f4168e, y.f4169f);
        s1Var3.f2823b = true;
        s1Var3.a();
        f4033f = new h(false, false, null, null);
    }

    public h(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.f4034a = z;
        this.f4035b = z2;
        this.f4036c = strArr;
        this.d = strArr2;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.Serializable, java.lang.String[]] */
    public final void a(SSLSocket sSLSocket, boolean z) {
        String[] enabledProtocols;
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        kotlin.jvm.internal.p.b(enabledCipherSuites);
        String[] strArr = this.f4036c;
        if (strArr != null) {
            enabledCipherSuites = o6.d.i(strArr, enabledCipherSuites, g.f4014c);
        }
        ?? r22 = this.d;
        if (r22 != 0) {
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            kotlin.jvm.internal.p.d(enabledProtocols2, "getEnabledProtocols(...)");
            enabledProtocols = o6.d.i(enabledProtocols2, r22, e5.a.f2366b);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        kotlin.jvm.internal.p.b(supportedCipherSuites);
        f fVar = g.f4014c;
        byte[] bArr = o6.d.f4327a;
        int length = supportedCipherSuites.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                i8 = -1;
                break;
            } else if (fVar.compare(supportedCipherSuites[i8], "TLS_FALLBACK_SCSV") == 0) {
                break;
            } else {
                i8++;
            }
        }
        if (z && i8 != -1) {
            String str = supportedCipherSuites[i8];
            kotlin.jvm.internal.p.d(str, "get(...)");
            kotlin.jvm.internal.p.e(enabledCipherSuites, "<this>");
            Object[] objArrCopyOf = Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            kotlin.jvm.internal.p.d(objArrCopyOf, "copyOf(...)");
            enabledCipherSuites = (String[]) objArrCopyOf;
            enabledCipherSuites[enabledCipherSuites.length - 1] = str;
        }
        s1 s1Var = new s1();
        s1Var.f2822a = this.f4034a;
        s1Var.f2824c = strArr;
        s1Var.d = r22;
        s1Var.f2823b = this.f4035b;
        s1Var.b((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        s1Var.d((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length));
        h hVarA = s1Var.a();
        if (hVarA.c() != null) {
            sSLSocket.setEnabledProtocols(hVarA.d);
        }
        if (hVarA.b() != null) {
            sSLSocket.setEnabledCipherSuites(hVarA.f4036c);
        }
    }

    public final ArrayList b() {
        String[] strArr = this.f4036c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(g.f4013b.b(str));
        }
        return arrayList;
    }

    public final ArrayList c() {
        String[] strArr = this.d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            y.f4166b.getClass();
            arrayList.add(b.c(str));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        h hVar = (h) obj;
        boolean z = hVar.f4034a;
        boolean z2 = this.f4034a;
        if (z2 != z) {
            return false;
        }
        if (z2) {
            return Arrays.equals(this.f4036c, hVar.f4036c) && Arrays.equals(this.d, hVar.d) && this.f4035b == hVar.f4035b;
        }
        return true;
    }

    public final int hashCode() {
        if (!this.f4034a) {
            return 17;
        }
        String[] strArr = this.f4036c;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f4035b ? 1 : 0);
    }

    public final String toString() {
        if (!this.f4034a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(b(), "[all enabled]") + ", tlsVersions=" + Objects.toString(c(), "[all enabled]") + ", supportsTlsExtensions=" + this.f4035b + ')';
    }
}
