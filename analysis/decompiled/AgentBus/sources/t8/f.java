package t8;

import c7.j;
import d7.r;
import d7.t;
import g9.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n7.m;
import o9.n;
import q7.k;
import v9.i0;
import v9.p;
import v9.p0;
import v9.v;
import v9.z;
import v9.z0;
import y9.i;

/* loaded from: classes.dex */
public final class f extends p implements i {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(z zVar, z zVar2) {
        super(zVar, zVar2);
        k.e(zVar, "lowerBound");
        k.e(zVar2, "upperBound");
        w9.e.f10930a.b(zVar, zVar2);
    }

    public static final ArrayList N0(g gVar, v vVar) throws IOException {
        List<p0> listC0 = vVar.C0();
        ArrayList arrayList = new ArrayList(t.A0(listC0, 10));
        for (p0 p0Var : listC0) {
            k.e(p0Var, "typeProjection");
            StringBuilder sb2 = new StringBuilder();
            r.T0(a.a.S(p0Var), sb2, ", ", null, null, new g9.e(gVar, 0), 60);
            String string = sb2.toString();
            k.d(string, "StringBuilder().apply(builderAction).toString()");
            arrayList.add(string);
        }
        return arrayList;
    }

    public static final String O0(String str, String str2) {
        if (!ga.k.l0(str, '<')) {
            return str;
        }
        return ga.k.I0(str, '<') + '<' + str2 + '>' + ga.k.G0('>', str, str);
    }

    @Override // v9.v
    public final v G0(w9.g gVar) {
        k.e(gVar, "kotlinTypeRefiner");
        z zVar = this.f10580g;
        k.e(zVar, "type");
        z zVar2 = this.f10581h;
        k.e(zVar2, "type");
        return new f(zVar, zVar2);
    }

    @Override // v9.z0
    public final z0 I0(boolean z4) {
        return new f(this.f10580g.I0(z4), this.f10581h.I0(z4));
    }

    @Override // v9.z0
    /* renamed from: J0 */
    public final z0 G0(w9.g gVar) {
        k.e(gVar, "kotlinTypeRefiner");
        z zVar = this.f10580g;
        k.e(zVar, "type");
        z zVar2 = this.f10581h;
        k.e(zVar2, "type");
        return new f(zVar, zVar2);
    }

    @Override // v9.z0
    public final z0 K0(i0 i0Var) {
        k.e(i0Var, "newAttributes");
        return new f(this.f10580g.K0(i0Var), this.f10581h.K0(i0Var));
    }

    @Override // v9.p
    public final z L0() {
        return this.f10580g;
    }

    @Override // v9.p
    public final String M0(g gVar, g gVar2) throws IOException {
        z zVar = this.f10580g;
        String strZ = gVar.Z(zVar);
        z zVar2 = this.f10581h;
        String strZ2 = gVar.Z(zVar2);
        if (gVar2.f3942a.o()) {
            return "raw (" + strZ + ".." + strZ2 + ')';
        }
        if (zVar2.C0().isEmpty()) {
            return gVar.G(strZ, strZ2, m.r(this));
        }
        ArrayList arrayListN0 = N0(gVar, zVar);
        ArrayList arrayListN02 = N0(gVar, zVar2);
        String strU0 = r.U0(arrayListN0, ", ", null, null, e.f9787g, 30);
        ArrayList arrayListS1 = r.s1(arrayListN0, arrayListN02);
        if (arrayListS1.isEmpty()) {
            strZ2 = O0(strZ2, strU0);
        } else {
            Iterator it = arrayListS1.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                String str = (String) jVar.f1973f;
                String str2 = (String) jVar.f1974g;
                if (!k.a(str, ga.k.z0(str2, "out ")) && !str2.equals("*")) {
                    break;
                }
            }
            strZ2 = O0(strZ2, strU0);
        }
        String strO0 = O0(strZ, strU0);
        return k.a(strO0, strZ2) ? strO0 : gVar.G(strO0, strZ2, m.r(this));
    }

    @Override // v9.p, v9.v
    public final n v0() {
        f8.g gVarC = E0().c();
        f8.e eVar = gVarC instanceof f8.e ? (f8.e) gVarC : null;
        if (eVar != null) {
            n nVarX = eVar.X(new d());
            k.d(nVarX, "classDescriptor.getMemberScope(RawSubstitution())");
            return nVarX;
        }
        throw new IllegalStateException(("Incorrect classifier: " + E0().c()).toString());
    }
}
