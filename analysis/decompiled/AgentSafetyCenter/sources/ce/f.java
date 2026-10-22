package ce;

import ge.j;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import zd.h;
import zd.k;
import zd.l;
import zd.n;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap f2274g;

    /* renamed from: a, reason: collision with root package name */
    public fe.b f2275a;

    /* renamed from: b, reason: collision with root package name */
    public zd.g f2276b;

    /* renamed from: c, reason: collision with root package name */
    public ne.b f2277c;

    /* renamed from: d, reason: collision with root package name */
    public ne.b f2278d;

    /* renamed from: e, reason: collision with root package name */
    public g f2279e;

    /* renamed from: f, reason: collision with root package name */
    public p5.e f2280f;

    static {
        HashMap map = new HashMap();
        f2274g = map;
        map.put("!", "!");
        map.put("!!", "tag:yaml.org,2002:");
    }

    public static l a(f fVar, yd.a aVar) {
        fVar.getClass();
        return new l(null, null, new h(true, false), "", aVar, aVar, vd.b.PLAIN);
    }

    public static zd.d b(f fVar, ge.e eVar) {
        fVar.getClass();
        yd.a aVar = eVar.f4744a;
        yd.a aVar2 = eVar.f4745b;
        String str = eVar.f4737d;
        int i = eVar.f4736c;
        zd.d dVar = new zd.d(aVar, aVar2);
        if (i == 0) {
            g5.f.g("Event Type must be provided.");
            return null;
        }
        dVar.f16581c = i;
        if (str == null) {
            g5.f.g("Value must be provided.");
            return null;
        }
        dVar.f16582d = str;
        VarHandle.storeStoreFence();
        return dVar;
    }

    public final k c(boolean z10, boolean z11) {
        yd.a aVar;
        p5.e eVar;
        yd.a aVar2;
        yd.a aVar3;
        String str;
        yd.a aVar4;
        yd.a aVar5;
        ne.b bVar = this.f2277c;
        fe.b bVar2 = this.f2275a;
        String strN = null;
        if (bVar2.c(1)) {
            ge.a aVar6 = (ge.a) bVar2.k();
            String str2 = aVar6.f4733c;
            zd.a aVar7 = new zd.a(str2, aVar6.f4744a, aVar6.f4745b);
            if (str2 != null) {
                this.f2279e = (g) bVar.f();
                return aVar7;
            }
            g5.f.g("anchor is not specified for alias");
            return null;
        }
        if (bVar2.c(2)) {
            ge.b bVar3 = (ge.b) bVar2.k();
            aVar = bVar3.f4744a;
            yd.a aVar8 = bVar3.f4745b;
            String str3 = bVar3.f4734c;
            if (bVar2.c(19)) {
                j jVar = (j) bVar2.k();
                aVar2 = jVar.f4744a;
                aVar3 = jVar.f4745b;
                eVar = jVar.f4743c;
            } else {
                eVar = null;
                aVar3 = aVar8;
                aVar2 = null;
            }
            str = str3;
        } else if (bVar2.c(19)) {
            j jVar2 = (j) bVar2.k();
            yd.a aVar9 = jVar2.f4744a;
            aVar3 = jVar2.f4745b;
            p5.e eVar2 = jVar2.f4743c;
            if (bVar2.c(2)) {
                ge.b bVar4 = (ge.b) bVar2.k();
                aVar3 = bVar4.f4745b;
                str = bVar4.f4734c;
            } else {
                str = null;
            }
            aVar2 = aVar9;
            eVar = eVar2;
            aVar = aVar2;
        } else {
            aVar = null;
            eVar = null;
            aVar2 = null;
            aVar3 = null;
            str = null;
        }
        if (eVar != null) {
            String str4 = (String) eVar.f9722f;
            strN = (String) eVar.f9723g;
            if (str4 != null) {
                if (!((HashMap) this.f2280f.f9723g).containsKey(str4)) {
                    throw new a("while parsing a node", aVar, "found undefined tag handle ".concat(str4), aVar2);
                }
                strN = androidx.activity.b.n(new StringBuilder(), (String) ((HashMap) this.f2280f.f9723g).get(str4), strN);
            }
        }
        String str5 = strN;
        if (aVar == null) {
            aVar4 = bVar2.m().f4744a;
            aVar5 = aVar4;
        } else {
            aVar4 = aVar;
            aVar5 = aVar3;
        }
        int i = 0;
        boolean z12 = str5 == null || str5.equals("!");
        yd.a aVar10 = aVar5;
        vd.a aVar11 = vd.a.BLOCK;
        if (z11 && bVar2.c(4)) {
            n nVar = new n(str, str5, z12, aVar4, bVar2.m().f4745b, aVar11);
            this.f2279e = new b(this, 18);
            return nVar;
        }
        int i3 = 16;
        if (bVar2.c(16)) {
            ge.g gVar = (ge.g) bVar2.k();
            l lVar = new l(str, str5, ((gVar.f4741d && str5 == null) || "!".equals(str5)) ? new h(true, false) : str5 == null ? new h(false, true) : new h(false, false), gVar.f4740c, aVar4, gVar.f4745b, gVar.f4742e);
            this.f2279e = (g) bVar.f();
            return lVar;
        }
        boolean zC = bVar2.c(14);
        vd.a aVar12 = vd.a.FLOW;
        if (zC) {
            n nVar2 = new n(str, str5, z12, aVar4, bVar2.m().f4745b, aVar12);
            b bVar5 = new b(i3);
            bVar5.f2264b = this;
            VarHandle.storeStoreFence();
            this.f2279e = bVar5;
            return nVar2;
        }
        if (bVar2.c(12)) {
            zd.j jVar3 = new zd.j(str, str5, z12, aVar4, bVar2.m().f4745b, aVar12);
            b bVar6 = new b(11);
            bVar6.f2264b = this;
            VarHandle.storeStoreFence();
            this.f2279e = bVar6;
            return jVar3;
        }
        int i10 = 5;
        if (z10 && bVar2.c(6)) {
            n nVar3 = new n(str, str5, z12, aVar4, bVar2.m().f4744a, aVar11);
            b bVar7 = new b(i10);
            bVar7.f2264b = this;
            VarHandle.storeStoreFence();
            this.f2279e = bVar7;
            return nVar3;
        }
        if (z10 && bVar2.c(5)) {
            zd.j jVar4 = new zd.j(str, str5, z12, aVar4, bVar2.m().f4744a, aVar11);
            b bVar8 = new b(i);
            bVar8.f2264b = this;
            VarHandle.storeStoreFence();
            this.f2279e = bVar8;
            return jVar4;
        }
        if (str != null || str5 != null) {
            l lVar2 = new l(str, str5, new h(z12, false), "", aVar4, aVar10, vd.b.PLAIN);
            this.f2279e = (g) bVar.f();
            return lVar2;
        }
        ge.k kVarM = bVar2.m();
        throw new a(androidx.activity.b.n(new StringBuilder("while parsing a "), z10 ? "block" : "flow", " node"), aVar4, "expected the node content, but found '" + androidx.activity.b.A(kVarM.a()) + "'", kVarM.f4744a);
    }
}
