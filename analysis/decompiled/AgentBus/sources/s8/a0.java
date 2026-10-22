package s8;

import f8.q0;
import i8.r0;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import v9.z0;

/* loaded from: classes.dex */
public abstract class a0 extends o9.o {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ w7.t[] f9517m;

    /* renamed from: b, reason: collision with root package name */
    public final a3.b f9518b;

    /* renamed from: c, reason: collision with root package name */
    public final a0 f9519c;

    /* renamed from: d, reason: collision with root package name */
    public final u9.c f9520d;

    /* renamed from: e, reason: collision with root package name */
    public final u9.i f9521e;

    /* renamed from: f, reason: collision with root package name */
    public final u9.e f9522f;

    /* renamed from: g, reason: collision with root package name */
    public final b0.e f9523g;

    /* renamed from: h, reason: collision with root package name */
    public final u9.e f9524h;

    /* renamed from: i, reason: collision with root package name */
    public final u9.i f9525i;

    /* renamed from: j, reason: collision with root package name */
    public final u9.i f9526j;

    /* renamed from: k, reason: collision with root package name */
    public final u9.i f9527k;

    /* renamed from: l, reason: collision with root package name */
    public final u9.e f9528l;

    static {
        q7.x xVar = q7.w.f8821a;
        f9517m = new w7.t[]{xVar.f(new q7.p(xVar.b(a0.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), xVar.f(new q7.p(xVar.b(a0.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), xVar.f(new q7.p(xVar.b(a0.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    }

    public a0(a3.b bVar, p pVar) {
        q7.k.e(bVar, "c");
        this.f9518b = bVar;
        this.f9519c = pVar;
        u9.n nVar = ((r8.a) bVar.f162f).f9002a;
        y yVar = new y(this, 0);
        u9.k kVar = (u9.k) nVar;
        kVar.getClass();
        this.f9520d = new u9.c(kVar, yVar);
        y yVar2 = new y(this, 2);
        u9.k kVar2 = (u9.k) nVar;
        kVar2.getClass();
        this.f9521e = new u9.i(kVar2, yVar2);
        this.f9522f = ((u9.k) nVar).b(new z(this, 1));
        this.f9523g = ((u9.k) nVar).c(new z(this, 0));
        this.f9524h = ((u9.k) nVar).b(new z(this, 2));
        y yVar3 = new y(this, 3);
        u9.k kVar3 = (u9.k) nVar;
        kVar3.getClass();
        this.f9525i = new u9.i(kVar3, yVar3);
        y yVar4 = new y(this, 4);
        u9.k kVar4 = (u9.k) nVar;
        kVar4.getClass();
        this.f9526j = new u9.i(kVar4, yVar4);
        y yVar5 = new y(this, 1);
        u9.k kVar5 = (u9.k) nVar;
        kVar5.getClass();
        this.f9527k = new u9.i(kVar5, yVar5);
        this.f9528l = ((u9.k) nVar).b(new z(this, 3));
    }

    public static v9.v l(l8.x xVar, a3.b bVar) {
        q7.k.e(xVar, "method");
        Class<?> declaringClass = ((Method) xVar.b()).getDeclaringClass();
        q7.k.d(declaringClass, "member.declaringClass");
        return ((i5.l) bVar.f166j).R(xVar.f(), n7.b.x(2, declaringClass.isAnnotation(), null, 6));
    }

    public static a7.c u(a3.b bVar, i8.u uVar, List list) {
        c7.j jVar;
        v9.v vVar;
        e9.f fVar;
        e9.f fVarE;
        i5.l lVar = (i5.l) bVar.f166j;
        r8.a aVar = (r8.a) bVar.f162f;
        f8.z zVar = aVar.f9016o;
        d7.p pVarR1 = d7.r.r1(list);
        ArrayList arrayList = new ArrayList(d7.t.A0(pVarR1, 10));
        Iterator it = pVarR1.iterator();
        boolean z4 = false;
        while (true) {
            d7.d0 d0Var = (d7.d0) it;
            if (!d0Var.f2955g.hasNext()) {
                return new a7.c(d7.r.m1(arrayList), z4, 2);
            }
            d7.c0 c0Var = (d7.c0) d0Var.next();
            int i2 = c0Var.f2951a;
            l8.d0 d0Var2 = (l8.d0) c0Var.f2952b;
            r8.d dVarX = n7.o.x(bVar, d0Var2);
            t8.a aVarX = n7.b.x(2, false, null, 7);
            boolean z10 = d0Var2.f5864d;
            l8.b0 b0Var = d0Var2.f5861a;
            if (z10) {
                l8.i iVar = b0Var instanceof l8.i ? (l8.i) b0Var : null;
                if (iVar == null) {
                    throw new AssertionError("Vararg parameter should be an array: " + d0Var2);
                }
                z0 z0VarQ = lVar.Q(iVar, aVarX, true);
                jVar = new c7.j(z0VarQ, zVar.n().f(z0VarQ));
            } else {
                jVar = new c7.j(lVar.R(b0Var, aVarX), null);
            }
            v9.v vVar2 = (v9.v) jVar.f1973f;
            v9.v vVar3 = (v9.v) jVar.f1974g;
            if (q7.k.a(uVar.getName().b(), "equals") && list.size() == 1 && zVar.n().o().equals(vVar2)) {
                fVarE = e9.f.e("other");
            } else {
                String str = d0Var2.f5863c;
                e9.f fVarD = str != null ? e9.f.d(str) : null;
                if (fVarD == null) {
                    z4 = true;
                }
                if (fVarD == null) {
                    fVarE = e9.f.e("p" + i2);
                } else {
                    vVar = vVar2;
                    fVar = fVarD;
                    arrayList.add(new r0(uVar, null, i2, dVarX, fVar, vVar, false, false, false, vVar3, aVar.f9011j.c(d0Var2)));
                }
            }
            vVar = vVar2;
            fVar = fVarE;
            arrayList.add(new r0(uVar, null, i2, dVarX, fVar, vVar, false, false, false, vVar3, aVar.f9011j.c(d0Var2)));
        }
    }

    @Override // o9.o, o9.n
    public Collection a(e9.f fVar, n8.c cVar) {
        q7.k.e(fVar, "name");
        return !d().contains(fVar) ? d7.z.f2978f : (Collection) this.f9528l.invoke(fVar);
    }

    @Override // o9.o, o9.n
    public final Set c() {
        return (Set) n7.b.q(this.f9525i, f9517m[0]);
    }

    @Override // o9.o, o9.n
    public final Set d() {
        return (Set) n7.b.q(this.f9526j, f9517m[1]);
    }

    @Override // o9.o, o9.q
    public Collection e(o9.f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        q7.k.e(kVar, "nameFilter");
        return (Collection) this.f9520d.c();
    }

    @Override // o9.o, o9.q
    public Collection f(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        return !c().contains(fVar) ? d7.z.f2978f : (Collection) this.f9524h.invoke(fVar);
    }

    @Override // o9.o, o9.n
    public final Set g() {
        return (Set) n7.b.q(this.f9527k, f9517m[2]);
    }

    public abstract Set h(o9.f fVar, p7.k kVar);

    public abstract Set i(o9.f fVar, o9.k kVar);

    public void j(e9.f fVar, ArrayList arrayList) {
        q7.k.e(fVar, "name");
    }

    public abstract c k();

    public abstract void m(LinkedHashSet linkedHashSet, e9.f fVar);

    public abstract void n(e9.f fVar, ArrayList arrayList);

    public abstract Set o(o9.f fVar);

    public abstract i8.v p();

    public abstract f8.j q();

    public boolean r(q8.e eVar) {
        return true;
    }

    public abstract x s(l8.x xVar, ArrayList arrayList, v9.v vVar, List list);

    /* JADX WARN: Type inference failed for: r3v2, types: [c7.f, java.lang.Object] */
    public final q8.e t(l8.x xVar) {
        q7.k.e(xVar, "method");
        a3.b bVar = this.f9518b;
        int i2 = 1;
        q8.e eVarV0 = q8.e.V0(q(), n7.o.x(bVar, xVar), xVar.c(), ((r8.a) bVar.f162f).f9011j.c(xVar), ((c) this.f9521e.c()).f(xVar.c()) != null && ((ArrayList) xVar.g()).isEmpty());
        q7.k.e(bVar, "<this>");
        a3.b bVar2 = new a3.b((r8.a) bVar.f162f, new g3.e(bVar, eVarV0, xVar, 0), bVar.f164h);
        ArrayList typeParameters = xVar.getTypeParameters();
        ArrayList arrayList = new ArrayList(d7.t.A0(typeParameters, 10));
        Iterator it = typeParameters.iterator();
        while (it.hasNext()) {
            q0 q0VarA = ((r8.f) bVar2.f163g).a((l8.c0) it.next());
            q7.k.b(q0VarA);
            arrayList.add(q0VarA);
        }
        a7.c cVarU = u(bVar2, eVarV0, xVar.g());
        x xVarS = s(xVar, arrayList, l(xVar, bVar2), (List) cVarU.f409c);
        List list = xVarS.f9617d;
        i8.v vVarP = p();
        ArrayList arrayList2 = xVarS.f9616c;
        List list2 = xVarS.f9615b;
        v9.v vVar = xVarS.f9614a;
        boolean zIsAbstract = Modifier.isAbstract(((Method) xVar.b()).getModifiers());
        boolean zIsFinal = Modifier.isFinal(((Method) xVar.b()).getModifiers());
        if (zIsAbstract) {
            i2 = 4;
        } else if (!zIsFinal) {
            i2 = 3;
        }
        eVarV0.U0(null, vVarP, d7.z.f2978f, arrayList2, list2, vVar, i2, n7.a.B(xVar.e()), d7.a0.f2944f);
        eVarV0.W0(false, cVarU.f408b);
        if (list.isEmpty()) {
            return eVarV0;
        }
        ((r8.a) bVar2.f162f).f9006e.getClass();
        throw new UnsupportedOperationException("Should not be called");
    }

    public String toString() {
        return "Lazy scope for " + q();
    }
}
