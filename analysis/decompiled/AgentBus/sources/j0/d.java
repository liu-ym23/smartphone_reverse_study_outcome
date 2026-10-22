package j0;

import b0.z1;
import java.util.ArrayList;
import p7.m;
import p7.n;
import p7.o;
import p7.p;
import p7.q;
import p7.r;
import p7.s;
import p7.t;
import p7.u;
import q7.z;

/* loaded from: classes.dex */
public final class d implements n, o, p, q, r, s, t, u, p7.b, p7.c, p7.d, p7.e, p7.f, p7.g, p7.h, p7.i, p7.j, p7.l, m {

    /* renamed from: f, reason: collision with root package name */
    public final int f5071f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f5072g;

    /* renamed from: h, reason: collision with root package name */
    public c7.c f5073h;

    /* renamed from: i, reason: collision with root package name */
    public z1 f5074i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f5075j;

    public d(int i2, boolean z4, c7.c cVar) {
        this.f5071f = i2;
        this.f5072g = z4;
        this.f5073h = cVar;
    }

    public final Object a(int i2, b0.p pVar) {
        pVar.T(this.f5071f);
        h(pVar);
        int iA = i2 | (pVar.f(this) ? i.a(2, 0) : i.a(1, 0));
        c7.c cVar = this.f5073h;
        z.c(2, cVar);
        Object objInvoke = ((n) cVar).invoke(pVar, Integer.valueOf(iA));
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new c(2, d.class, this, "invoke", "invoke(Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;");
        }
        return objInvoke;
    }

    public final Object d(Object obj, b0.p pVar, int i2) {
        pVar.T(this.f5071f);
        h(pVar);
        int iA = pVar.f(this) ? i.a(2, 1) : i.a(1, 1);
        c7.c cVar = this.f5073h;
        z.c(3, cVar);
        Object objJ = ((o) cVar).j(obj, pVar, Integer.valueOf(iA | i2));
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new b0.z(i2, 1, this, obj);
        }
        return objJ;
    }

    public final Object f(Object obj, Object obj2, b0.p pVar, int i2) {
        pVar.T(this.f5071f);
        h(pVar);
        int iA = pVar.f(this) ? i.a(2, 2) : i.a(1, 2);
        c7.c cVar = this.f5073h;
        z.c(4, cVar);
        Object objU = ((p) cVar).u(obj, obj2, pVar, Integer.valueOf(iA | i2));
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new b(this, obj, obj2, i2, 0);
        }
        return objU;
    }

    public final void h(b0.p pVar) {
        z1 z1VarW;
        if (!this.f5072g || (z1VarW = pVar.w()) == null) {
            return;
        }
        z1VarW.f1442b |= 1;
        if (i.e(this.f5074i, z1VarW)) {
            this.f5074i = z1VarW;
            return;
        }
        ArrayList arrayList = this.f5075j;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            this.f5075j = arrayList2;
            arrayList2.add(z1VarW);
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i.e((z1) arrayList.get(i2), z1VarW)) {
                arrayList.set(i2, z1VarW);
                return;
            }
        }
        arrayList.add(z1VarW);
    }

    @Override // p7.n
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a(((Number) obj2).intValue(), (b0.p) obj);
    }

    @Override // p7.o
    public final /* bridge */ /* synthetic */ Object j(Object obj, Object obj2, Object obj3) {
        return d(obj, (b0.p) obj2, ((Number) obj3).intValue());
    }

    @Override // p7.p
    public final /* bridge */ /* synthetic */ Object u(Object obj, Object obj2, Object obj3, Object obj4) {
        return f(obj, obj2, (b0.p) obj3, ((Number) obj4).intValue());
    }
}
