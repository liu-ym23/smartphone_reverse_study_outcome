package s1;

import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t implements z0, h0 {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ w f11296c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ b0 f11297f;

    @Override // o2.c
    public final long E(float f5) {
        return this.f11296c.E(f5);
    }

    @Override // o2.c
    public final float J(int i) {
        return this.f11296c.J(i);
    }

    @Override // o2.c
    public final float M(float f5) {
        return f5 / this.f11296c.a();
    }

    @Override // o2.c
    public final float T() {
        return this.f11296c.f11320g;
    }

    @Override // s1.h0
    public final boolean V() {
        return this.f11296c.V();
    }

    @Override // s1.z0
    public final List W(Object obj, xb.p pVar) {
        b0 b0Var = this.f11297f;
        u1.g0 g0Var = b0Var.f11203c;
        u1.g0 g0Var2 = (u1.g0) b0Var.f11208k.g(obj);
        if (g0Var2 != null && ((m0.b) g0Var.n()).f8152c.i(g0Var2) < b0Var.f11206h) {
            return g0Var2.I.f13857p.Z();
        }
        p.f0 f0Var = b0Var.f11211n;
        m0.e eVar = b0Var.f11214q;
        if (eVar.f8160g < b0Var.i) {
            r1.a.a("Error: currentApproachIndex cannot be greater than the size of theapproachComposedSlotIds list.");
        }
        int i = eVar.f8160g;
        int i3 = b0Var.i;
        if (i == i3) {
            eVar.b(obj);
        } else {
            Object[] objArr = eVar.f8158c;
            Object obj2 = objArr[i3];
            objArr[i3] = obj;
        }
        b0Var.i++;
        if (f0Var.b(obj)) {
            u1.g0 g0Var3 = (u1.g0) f0Var.g(obj);
            u uVar = g0Var3 != null ? (u) b0Var.f11207j.g(g0Var3) : null;
            if (uVar != null && uVar.f11302d) {
                b0Var.h(g0Var3, obj, pVar);
            }
        } else {
            b0Var.f11213p.m(obj, b0Var.f(obj, pVar));
            if (g0Var.I.f13846d == u1.c0.f13738g) {
                g0Var.S(true);
            } else {
                u1.g0.T(g0Var, true, 6);
            }
        }
        u1.g0 g0Var4 = (u1.g0) f0Var.g(obj);
        if (g0Var4 == null) {
            return kb.s.f7404c;
        }
        List listZ = g0Var4.I.f13857p.Z();
        m0.b bVar = (m0.b) listZ;
        int i10 = bVar.f8152c.f8160g;
        for (int i11 = 0; i11 < i10; i11++) {
            ((u1.x0) bVar.get(i11)).f13956j.f13844b = true;
        }
        return listZ;
    }

    @Override // o2.c
    public final float X(float f5) {
        return this.f11296c.a() * f5;
    }

    @Override // s1.h0
    public final g0 Y(int i, int i3, Map map, xb.l lVar) {
        return this.f11296c.i(i, i3, map, null, lVar);
    }

    @Override // o2.c
    public final float a() {
        return this.f11296c.f11319f;
    }

    @Override // o2.c
    public final int e0(float f5) {
        return this.f11296c.e0(f5);
    }

    @Override // s1.h0
    public final o2.l getLayoutDirection() {
        return this.f11296c.f11318c;
    }

    @Override // s1.h0
    public final g0 i(int i, int i3, Map map, xb.l lVar, xb.l lVar2) {
        return this.f11296c.i(i, i3, map, lVar, lVar2);
    }

    @Override // o2.c
    public final long j0(long j10) {
        return this.f11296c.j0(j10);
    }

    @Override // o2.c
    public final float m0(long j10) {
        return this.f11296c.m0(j10);
    }

    @Override // o2.c
    public final long n(float f5) {
        return this.f11296c.n(f5);
    }

    @Override // o2.c
    public final float u(long j10) {
        return this.f11296c.u(j10);
    }
}
