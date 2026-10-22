package u8;

import X8.AbstractC0272c;
import X8.N;
import h8.InterfaceC1503K;
import h8.InterfaceC1507O;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import k8.Q;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import n8.AbstractC1744c;
import t8.C2024a;
import x8.InterfaceC2118a;

/* loaded from: classes4.dex */
public final class g implements s8.f {
    public static final /* synthetic */ Z7.t[] h;

    /* renamed from: a, reason: collision with root package name */
    public final K1.a f6718a;
    public final n8.d b;
    public final kotlin.reflect.jvm.internal.impl.storage.a c;
    public final W8.h d;
    public final m8.f e;
    public final W8.h f;
    public final boolean g;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        h = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.b(g.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), nVar.g(new PropertyReference1Impl(nVar.b(g.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), nVar.g(new PropertyReference1Impl(nVar.b(g.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public g(K1.a c, n8.d javaAnnotation, boolean z10) {
        kotlin.jvm.internal.k.f(c, "c");
        kotlin.jvm.internal.k.f(javaAnnotation, "javaAnnotation");
        this.f6718a = c;
        this.b = javaAnnotation;
        C2024a c2024a = (C2024a) c.f903a;
        W8.l lVar = c2024a.f6670a;
        f fVar = new f(this, 0);
        W8.i iVar = (W8.i) lVar;
        iVar.getClass();
        this.c = new kotlin.reflect.jvm.internal.impl.storage.a(iVar, fVar);
        f fVar2 = new f(this, 1);
        W8.i iVar2 = (W8.i) lVar;
        iVar2.getClass();
        this.d = new W8.h(iVar2, fVar2);
        this.e = c2024a.f6671j.b(javaAnnotation);
        f fVar3 = new f(this, 2);
        W8.i iVar3 = (W8.i) lVar;
        iVar3.getClass();
        this.f = new W8.h(iVar3, fVar3);
        this.g = z10;
    }

    @Override // i8.InterfaceC1556b
    public final Map a() {
        return (Map) S0.b.g1(this.f, h[2]);
    }

    @Override // i8.InterfaceC1556b
    public final G8.c b() {
        Z7.t p = h[0];
        kotlin.reflect.jvm.internal.impl.storage.a aVar = this.c;
        kotlin.jvm.internal.k.f(aVar, "<this>");
        kotlin.jvm.internal.k.f(p, "p");
        return (G8.c) aVar.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final L8.g c(InterfaceC2118a interfaceC2118a) {
        X8.w wVarG;
        if (interfaceC2118a instanceof n8.o) {
            return L8.h.b(((n8.o) interfaceC2118a).b, null);
        }
        if (interfaceC2118a instanceof n8.m) {
            n8.m mVar = (n8.m) interfaceC2118a;
            Class<?> enclosingClass = mVar.b.getClass();
            if (!enclosingClass.isEnum()) {
                enclosingClass = enclosingClass.getEnclosingClass();
            }
            kotlin.jvm.internal.k.c(enclosingClass);
            return new L8.i(AbstractC1744c.a(enclosingClass), G8.f.e(mVar.b.name()));
        }
        boolean z10 = interfaceC2118a instanceof n8.g;
        K1.a aVar = this.f6718a;
        if (z10) {
            n8.g gVar = (n8.g) interfaceC2118a;
            G8.f fVar = gVar.f5357a;
            if (fVar == null) {
                fVar = q8.u.b;
            }
            kotlin.jvm.internal.k.c(fVar);
            ArrayList arrayListA = gVar.a();
            if (!AbstractC0272c.k((X8.A) S0.b.g1(this.d, h[1]))) {
                InterfaceC1522e interfaceC1522eD = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.d(this);
                kotlin.jvm.internal.k.c(interfaceC1522eD);
                Q qB = com.stepos.ability.task.executor.e.B(fVar, interfaceC1522eD);
                if (qB == null || (wVarG = qB.getType()) == null) {
                    e8.i iVarC = ((C2024a) aVar.f903a).o.c();
                    Variance variance = Variance.c;
                    wVarG = iVarC.g(Z8.i.c(ErrorTypeKind.f5152D, new String[0]));
                }
                ArrayList arrayList = new ArrayList(D7.w.c0(arrayListA, 10));
                Iterator it = arrayListA.iterator();
                while (it.hasNext()) {
                    L8.g gVarC = c((InterfaceC2118a) it.next());
                    if (gVarC == null) {
                        gVarC = new L8.u(null);
                    }
                    arrayList.add(gVarC);
                }
                return new L8.x(arrayList, wVarG);
            }
        } else {
            if (interfaceC2118a instanceof n8.f) {
                return new L8.a((Object) new g(aVar, new n8.d(((n8.f) interfaceC2118a).b), false));
            }
            if (interfaceC2118a instanceof n8.i) {
                Class cls = ((n8.i) interfaceC2118a).b;
                X8.w wVarC = ((A5.c) aVar.e).C(cls.isPrimitive() ? new n8.s(cls) : ((cls instanceof GenericArrayType) || cls.isArray()) ? new n8.h(cls) : cls instanceof WildcardType ? new n8.x((WildcardType) cls) : new n8.j(cls), M.a.o0(TypeUsage.b, false, null, 7));
                if (!AbstractC0272c.k(wVarC)) {
                    X8.w wVarB = wVarC;
                    int i = 0;
                    while (e8.i.y(wVarB)) {
                        wVarB = ((N) D7.v.U0(wVarB.L())).b();
                        i++;
                    }
                    InterfaceC1524g interfaceC1524gD = wVarB.Q().d();
                    if (interfaceC1524gD instanceof InterfaceC1522e) {
                        G8.b bVarF = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f(interfaceC1524gD);
                        return bVarF == null ? new L8.s(new L8.p(wVarC)) : new L8.s(bVarF, i);
                    }
                    if (interfaceC1524gD instanceof InterfaceC1507O) {
                        G8.c cVarG = e8.n.f4413a.g();
                        G8.c cVarE = cVarG.e();
                        G8.f fVarF = cVarG.f();
                        kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
                        return new L8.s(new G8.b(cVarE, fVarF), 0);
                    }
                }
            }
        }
        return null;
    }

    @Override // i8.InterfaceC1556b
    public final InterfaceC1503K getSource() {
        return this.e;
    }

    @Override // i8.InterfaceC1556b
    public final X8.w getType() {
        return (X8.A) S0.b.g1(this.d, h[1]);
    }

    public final String toString() {
        return I8.g.c.v(this, null);
    }
}
