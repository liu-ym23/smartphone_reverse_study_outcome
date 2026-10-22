package s0;

import e9.a0;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import k0.v1;
import xb.m;
import xb.n;
import xb.p;
import xb.q;
import xb.r;
import xb.s;
import xb.t;
import xb.u;
import xb.v;
import xb.w;
import yb.x;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements p, q, r, s, t, u, v, w, xb.b, xb.c, xb.e, xb.f, xb.g, xb.h, xb.i, xb.j, xb.k, m, n {

    /* renamed from: c, reason: collision with root package name */
    public final int f11171c;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11172f;

    /* renamed from: g, reason: collision with root package name */
    public Object f11173g;

    /* renamed from: h, reason: collision with root package name */
    public v1 f11174h;
    public ArrayList i;

    public c(int i, boolean z10, Object obj) {
        this.f11171c = i;
        this.f11172f = z10;
        this.f11173g = obj;
    }

    public final Object a(int i, k0.s sVar) {
        sVar.Z(this.f11171c);
        f(sVar);
        int iA = i | (sVar.f(this) ? h.a(2, 0) : h.a(1, 0));
        Object obj = this.f11173g;
        obj.getClass();
        x.c(2, obj);
        Object objInvoke = ((p) obj).invoke(sVar, Integer.valueOf(iA));
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new b(2, 8, c.class, this, "invoke", "invoke(Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;");
        }
        return objInvoke;
    }

    @Override // xb.r
    public final /* bridge */ /* synthetic */ Object c(Object obj, Object obj2, Object obj3, Object obj4) {
        return d(obj, obj2, (k0.s) obj3, ((Number) obj4).intValue());
    }

    public final Object d(Object obj, Object obj2, k0.s sVar, int i) {
        sVar.Z(this.f11171c);
        f(sVar);
        int i3 = 1;
        int iA = sVar.f(this) ? h.a(2, 2) : h.a(1, 2);
        Object obj3 = this.f11173g;
        obj3.getClass();
        x.c(4, obj3);
        Object objC = ((r) obj3).c(obj, obj2, sVar, Integer.valueOf(iA | i));
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            a0 a0Var = new a0(i3);
            a0Var.f3614g = this;
            a0Var.f3615h = obj;
            a0Var.i = obj2;
            a0Var.f3613f = i;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = a0Var;
        }
        return objC;
    }

    public final Object e(Object obj, k0.s sVar, int i) {
        sVar.Z(this.f11171c);
        f(sVar);
        int i3 = 2;
        int iA = sVar.f(this) ? h.a(2, 1) : h.a(1, 1);
        Object obj2 = this.f11173g;
        obj2.getClass();
        x.c(3, obj2);
        Object objInvoke = ((q) obj2).invoke(obj, sVar, Integer.valueOf(iA | i));
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            k0.a0 a0Var = new k0.a0(i3);
            a0Var.f6863h = this;
            a0Var.f6862g = obj;
            a0Var.f6861f = i;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = a0Var;
        }
        return objInvoke;
    }

    public final void f(k0.s sVar) {
        v1 v1VarY;
        if (!this.f11172f || (v1VarY = sVar.y()) == null) {
            return;
        }
        v1VarY.f7089b |= 1;
        if (h.e(this.f11174h, v1VarY)) {
            this.f11174h = v1VarY;
            return;
        }
        ArrayList arrayList = this.i;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            this.i = arrayList2;
            arrayList2.add(v1VarY);
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (h.e((v1) arrayList.get(i), v1VarY)) {
                arrayList.set(i, v1VarY);
                return;
            }
        }
        arrayList.add(v1VarY);
    }

    @Override // xb.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a(((Number) obj2).intValue(), (k0.s) obj);
    }

    @Override // xb.q
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return e(obj, (k0.s) obj2, ((Number) obj3).intValue());
    }
}
