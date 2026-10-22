package s1;

import java.lang.invoke.VarHandle;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w implements z0 {

    /* renamed from: c, reason: collision with root package name */
    public o2.l f11318c;

    /* renamed from: f, reason: collision with root package name */
    public float f11319f;

    /* renamed from: g, reason: collision with root package name */
    public float f11320g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ b0 f11321h;

    @Override // o2.c
    public final float T() {
        return this.f11320g;
    }

    @Override // s1.h0
    public final boolean V() {
        u1.c0 c0Var = this.f11321h.f11203c.I.f13846d;
        return c0Var == u1.c0.f13739h || c0Var == u1.c0.f13737f;
    }

    @Override // s1.z0
    public final List W(Object obj, xb.p pVar) {
        b0 b0Var = this.f11321h;
        b0Var.d();
        u1.g0 g0Var = b0Var.f11203c;
        u1.c0 c0Var = g0Var.I.f13846d;
        u1.c0 c0Var2 = u1.c0.f13736c;
        if (c0Var != c0Var2 && c0Var != u1.c0.f13738g && c0Var != u1.c0.f13737f && c0Var != u1.c0.f13739h) {
            r1.a.b("subcompose can only be used inside the measure or layout blocks");
        }
        p.f0 f0Var = b0Var.f11208k;
        Object objG = f0Var.g(obj);
        if (objG == null) {
            objG = (u1.g0) b0Var.f11211n.k(obj);
            if (objG != null) {
                if (b0Var.f11216s <= 0) {
                    r1.a.b("Check failed.");
                }
                b0Var.f11216s--;
            } else {
                objG = b0Var.i(obj);
                if (objG == null) {
                    int i = b0Var.f11206h;
                    u1.g0 g0Var2 = new u1.g0(2);
                    g0Var.f13803t = true;
                    g0Var.z(i, g0Var2);
                    g0Var.f13803t = false;
                    objG = g0Var2;
                }
            }
            f0Var.m(obj, objG);
        }
        u1.g0 g0Var3 = (u1.g0) objG;
        if (kb.l.y0(b0Var.f11206h, g0Var.n()) != g0Var3) {
            int i3 = ((m0.b) g0Var.n()).f8152c.i(g0Var3);
            if (i3 < b0Var.f11206h) {
                r1.a.a("Key \"" + obj + "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.");
            }
            int i10 = b0Var.f11206h;
            if (i10 != i3) {
                g0Var.f13803t = true;
                g0Var.K(i3, i10, 1);
                g0Var.f13803t = false;
            }
        }
        b0Var.f11206h++;
        b0Var.h(g0Var3, obj, pVar);
        return (c0Var == c0Var2 || c0Var == u1.c0.f13738g) ? g0Var3.I.f13857p.Z() : g0Var3.l();
    }

    @Override // o2.c
    public final float a() {
        return this.f11319f;
    }

    @Override // s1.h0
    public final o2.l getLayoutDirection() {
        return this.f11318c;
    }

    @Override // s1.h0
    public final g0 i(int i, int i3, Map map, xb.l lVar, xb.l lVar2) {
        if ((i & (-16777216)) != 0 || ((-16777216) & i3) != 0) {
            r1.a.b("Size(" + i + " x " + i3 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        b0 b0Var = this.f11321h;
        v vVar = new v();
        vVar.f11310a = i;
        vVar.f11311b = i3;
        vVar.f11312c = map;
        vVar.f11313d = lVar;
        vVar.f11314e = this;
        vVar.f11315f = b0Var;
        vVar.f11316g = lVar2;
        VarHandle.storeStoreFence();
        return vVar;
    }
}
