package v4;

import com.google.protobuf.y0;
import com.stepos.agentbus.config.AgentBusConfig;
import ia.d0;
import la.u0;
import o4.t1;
import q5.c0;
import y4.t;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements p7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f10390f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k f10391g;

    public /* synthetic */ a(k kVar, int i2) {
        this.f10390f = i2;
        this.f10391g = kVar;
    }

    @Override // p7.a
    public final Object c() {
        t1 t1Var;
        switch (this.f10390f) {
            case 0:
                return this.f10391g.f10458x;
            case 1:
                y4.a aVar = this.f10391g.f10430e0;
                t tVar = aVar instanceof t ? (t) aVar : null;
                if (tVar != null) {
                    return tVar.f11664r;
                }
                return null;
            case 2:
                y4.m mVar = this.f10391g.f10434g0;
                if (mVar != null) {
                    return mVar.f11619r;
                }
                return null;
            case 3:
                return this.f10391g.Y.a();
            case 4:
                return this.f10391g.f10458x;
            case 5:
                return Boolean.valueOf(((AgentBusConfig) this.f10391g.f10439j.getCurrent().getValue()).getPrivacy().getEnabled());
            case 6:
                y4.m mVar2 = this.f10391g.f10434g0;
                if (mVar2 != null && (t1Var = mVar2.f11619r) != null) {
                    t1Var.n(true);
                }
                return c7.r.f1986a;
            case 7:
                String rootfsBase = this.f10391g.f10423b.getResource().getRootfsBase();
                if (ga.k.t0(rootfsBase)) {
                    rootfsBase = "/mnt/openclaw/rootfs";
                }
                return n7.o.v(rootfsBase);
            case 8:
                y4.a aVar2 = this.f10391g.f10430e0;
                t tVar2 = aVar2 instanceof t ? (t) aVar2 : null;
                if (tVar2 != null) {
                    return tVar2.f11664r;
                }
                return null;
            case 9:
                y4.m mVar3 = this.f10391g.f10434g0;
                if (mVar3 != null) {
                    return mVar3.f11619r;
                }
                return null;
            case 10:
                y4.a aVar3 = this.f10391g.f10430e0;
                t tVar3 = aVar3 instanceof t ? (t) aVar3 : null;
                if (tVar3 != null) {
                    return tVar3.f11664r;
                }
                return null;
            case 11:
                return Boolean.valueOf(this.f10391g.f10434g0 != null);
            case 12:
                k kVar = this.f10391g;
                d0.s(kVar.X, null, null, new f(kVar, null, 0), 3);
                return c7.r.f1986a;
            case 13:
                k kVar2 = this.f10391g;
                d0.s(kVar2.X, null, null, new e(kVar2, false, null), 3);
                return c7.r.f1986a;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                k kVar3 = this.f10391g;
                d0.s(kVar3.X, null, null, new e(kVar3, true, null), 3);
                return c7.r.f1986a;
            default:
                return new c0(null, null, null, null, (d5.t) ((u0) this.f10391g.f10455u.f10131c).getValue());
        }
    }
}
