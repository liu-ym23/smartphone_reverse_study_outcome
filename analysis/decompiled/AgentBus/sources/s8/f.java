package s8;

import f8.n0;
import f8.q0;
import i8.r0;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import v9.p0;

/* loaded from: classes.dex */
public final class f implements g8.c, q8.g {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ w7.t[] f9544h;

    /* renamed from: a, reason: collision with root package name */
    public final a3.b f9545a;

    /* renamed from: b, reason: collision with root package name */
    public final l8.e f9546b;

    /* renamed from: c, reason: collision with root package name */
    public final u9.h f9547c;

    /* renamed from: d, reason: collision with root package name */
    public final u9.i f9548d;

    /* renamed from: e, reason: collision with root package name */
    public final k8.g f9549e;

    /* renamed from: f, reason: collision with root package name */
    public final u9.i f9550f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f9551g;

    static {
        q7.x xVar = q7.w.f8821a;
        f9544h = new w7.t[]{xVar.f(new q7.p(xVar.b(f.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), xVar.f(new q7.p(xVar.b(f.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), xVar.f(new q7.p(xVar.b(f.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public f(a3.b bVar, l8.e eVar, boolean z4) {
        q7.k.e(bVar, "c");
        q7.k.e(eVar, "javaAnnotation");
        this.f9545a = bVar;
        this.f9546b = eVar;
        r8.a aVar = (r8.a) bVar.f162f;
        u9.n nVar = aVar.f9002a;
        e eVar2 = new e(this, 1);
        u9.k kVar = (u9.k) nVar;
        kVar.getClass();
        this.f9547c = new u9.h(kVar, eVar2);
        e eVar3 = new e(this, 2);
        u9.k kVar2 = (u9.k) nVar;
        kVar2.getClass();
        this.f9548d = new u9.i(kVar2, eVar3);
        this.f9549e = aVar.f9011j.c(eVar);
        e eVar4 = new e(this, 0);
        u9.k kVar3 = (u9.k) nVar;
        kVar3.getClass();
        this.f9550f = new u9.i(kVar3, eVar4);
        this.f9551g = z4;
    }

    @Override // g8.c
    public final e9.c a() {
        w7.t tVar = f9544h[0];
        u9.h hVar = this.f9547c;
        q7.k.e(hVar, "<this>");
        q7.k.e(tVar, "p");
        return (e9.c) hVar.c();
    }

    @Override // g8.c
    public final Map b() {
        return (Map) n7.b.q(this.f9550f, f9544h[2]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final j9.g c(v8.a aVar) {
        v9.v vVarH;
        if (aVar instanceof l8.v) {
            return j9.h.b(((l8.v) aVar).f5885b, null);
        }
        if (aVar instanceof l8.t) {
            Enum r62 = ((l8.t) aVar).f5883b;
            Class<?> enclosingClass = r62.getClass();
            if (!enclosingClass.isEnum()) {
                enclosingClass = enclosingClass.getEnclosingClass();
            }
            q7.k.d(enclosingClass, "enumClass");
            return new j9.i(l8.d.a(enclosingClass), e9.f.e(r62.name()));
        }
        boolean z4 = aVar instanceof l8.h;
        a3.b bVar = this.f9545a;
        if (z4) {
            l8.h hVar = (l8.h) aVar;
            e9.f fVar = hVar.f5867a;
            if (fVar == null) {
                fVar = o8.x.f7859b;
            }
            q7.k.d(fVar, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
            ArrayList arrayListA = hVar.a();
            v9.z zVar = (v9.z) n7.b.q(this.f9548d, f9544h[1]);
            q7.k.d(zVar, "type");
            if (!v9.c.i(zVar)) {
                f8.e eVarD = l9.d.d(this);
                q7.k.b(eVarD);
                r0 r0VarQ = nb.i.q(fVar, eVarD);
                if (r0VarQ == null || (vVarH = r0VarQ.getType()) == null) {
                    vVarH = ((r8.a) bVar.f162f).f9016o.n().h(x9.i.c(x9.h.I, new String[0]));
                }
                ArrayList arrayList = new ArrayList(d7.t.A0(arrayListA, 10));
                Iterator it = arrayListA.iterator();
                while (it.hasNext()) {
                    j9.g gVarC = c((v8.a) it.next());
                    if (gVarC == null) {
                        gVarC = new j9.u(null);
                    }
                    arrayList.add(gVarC);
                }
                return new j9.x(arrayList, vVarH);
            }
        } else {
            if (aVar instanceof l8.g) {
                return new j9.a((Object) new f(bVar, new l8.e(((l8.g) aVar).f5868b), false));
            }
            if (aVar instanceof l8.p) {
                Class cls = ((l8.p) aVar).f5879b;
                v9.v vVarR = ((i5.l) bVar.f166j).R(cls.isPrimitive() ? new l8.z(cls) : ((cls instanceof GenericArrayType) || cls.isArray()) ? new l8.i(cls) : cls instanceof WildcardType ? new l8.e0((WildcardType) cls) : new l8.q(cls), n7.b.x(2, false, null, 7));
                if (!v9.c.i(vVarR)) {
                    v9.v vVarB = vVarR;
                    int i2 = 0;
                    while (c8.h.y(vVarB)) {
                        vVarB = ((p0) d7.r.f1(vVarB.C0())).b();
                        q7.k.d(vVarB, "type.arguments.single().type");
                        i2++;
                    }
                    f8.g gVarC2 = vVarB.E0().c();
                    if (gVarC2 instanceof f8.e) {
                        e9.b bVarF = l9.d.f(gVarC2);
                        return bVarF == null ? new j9.s(new j9.p(vVarR)) : new j9.s(bVarF, i2);
                    }
                    if (gVarC2 instanceof q0) {
                        return new j9.s(e9.b.j(c8.m.f2027a.g()), 0);
                    }
                }
            }
        }
        return null;
    }

    @Override // g8.c
    public final v9.v getType() {
        return (v9.z) n7.b.q(this.f9548d, f9544h[1]);
    }

    @Override // g8.c
    public final n0 q() {
        return this.f9549e;
    }

    public final String toString() {
        return g9.g.f3939c.y(this, null);
    }
}
