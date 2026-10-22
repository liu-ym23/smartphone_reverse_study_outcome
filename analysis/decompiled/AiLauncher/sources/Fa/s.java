package Fa;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.S;
import E9.a0;
import E9.i0;
import Fa.A;
import Fa.k;
import Fa.v;
import Z8.C1173v;
import Z8.F;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import p9.InterfaceC5074l;
import sa.C5458e;
import sa.InterfaceC5460g;

/* loaded from: classes5.dex */
public final class s extends b {

    /* renamed from: a, reason: collision with root package name */
    public static final s f2665a = new s();

    /* renamed from: b, reason: collision with root package name */
    public static final List<h> f2666b;

    static {
        ga.e eVar = t.f2710k;
        k.b bVar = k.b.f2654b;
        h hVar = new h(eVar, new f[]{bVar, new A.a(1)}, (InterfaceC5074l) null, 4, (kotlin.jvm.internal.i) null);
        h hVar2 = new h(t.f2711l, new f[]{bVar, new A.a(2)}, p.f2662a);
        ga.e eVar2 = t.f2695b;
        m mVar = m.f2656a;
        A.a aVar = new A.a(2);
        j jVar = j.f2650a;
        h hVar3 = new h(eVar2, new f[]{bVar, mVar, aVar, jVar}, (InterfaceC5074l) null, 4, (kotlin.jvm.internal.i) null);
        h hVar4 = new h(t.f2697c, new f[]{bVar, mVar, new A.a(3), jVar}, (InterfaceC5074l) null, 4, (kotlin.jvm.internal.i) null);
        h hVar5 = new h(t.f2699d, new f[]{bVar, mVar, new A.b(2), jVar}, (InterfaceC5074l) null, 4, (kotlin.jvm.internal.i) null);
        h hVar6 = new h(t.f2708i, new f[]{bVar}, (InterfaceC5074l) null, 4, (kotlin.jvm.internal.i) null);
        ga.e eVar3 = t.f2707h;
        A.d dVar = A.d.f2629b;
        v.a aVar2 = v.a.f2730d;
        h hVar7 = new h(eVar3, new f[]{bVar, dVar, mVar, aVar2}, (InterfaceC5074l) null, 4, (kotlin.jvm.internal.i) null);
        ga.e eVar4 = t.f2709j;
        A.c cVar = A.c.f2628b;
        f2666b = C1173v.p(hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, new h(eVar4, new f[]{bVar, cVar}, (InterfaceC5074l) null, 4, (kotlin.jvm.internal.i) null), new h(t.f2712m, new f[]{bVar, cVar}, (InterfaceC5074l) null, 4, (kotlin.jvm.internal.i) null), new h(t.f2713n, new f[]{bVar, cVar, aVar2}, (InterfaceC5074l) null, 4, (kotlin.jvm.internal.i) null), new h(t.f2674H, new f[]{bVar, dVar, mVar}, (InterfaceC5074l) null, 4, (kotlin.jvm.internal.i) null), new h(t.f2675I, new f[]{bVar, dVar, mVar}, (InterfaceC5074l) null, 4, (kotlin.jvm.internal.i) null), new h(t.f2701e, new f[]{k.a.f2653b}, q.f2663a), new h(t.f2705g, new f[]{bVar, v.b.f2731d, dVar, mVar}, (InterfaceC5074l) null, 4, (kotlin.jvm.internal.i) null), new h(t.f2690X, new f[]{bVar, dVar, mVar}, (InterfaceC5074l) null, 4, (kotlin.jvm.internal.i) null), new h(t.f2689W, new f[]{bVar, cVar}, (InterfaceC5074l) null, 4, (kotlin.jvm.internal.i) null), new h(C1173v.p(t.f2723x, t.f2724y), new f[]{bVar}, r.f2664a), new h(t.f2698c0, new f[]{bVar, v.c.f2732d, dVar, mVar}, (InterfaceC5074l) null, 4, (kotlin.jvm.internal.i) null), new h(t.f2715p, new f[]{bVar, cVar}, (InterfaceC5074l) null, 4, (kotlin.jvm.internal.i) null));
    }

    public static final String f(kotlin.reflect.jvm.internal.impl.descriptors.e Checks) {
        kotlin.jvm.internal.p.i(Checks, "$this$Checks");
        List<i0> listI = Checks.i();
        kotlin.jvm.internal.p.h(listI, "getValueParameters(...)");
        i0 i0Var = (i0) F.E0(listI);
        boolean z10 = false;
        if (i0Var != null && !DescriptorUtilsKt.f(i0Var) && i0Var.p0() == null) {
            z10 = true;
        }
        if (z10) {
            return null;
        }
        return "last parameter should not have a default value or be a vararg";
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0050 A[EDGE_INSN: B:27:0x0050->B:17:0x0050 BREAK  A[LOOP:0: B:8:0x002d->B:28:?]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String g(kotlin.reflect.jvm.internal.impl.descriptors.e r3) {
        /*
            java.lang.String r0 = "$this$Checks"
            kotlin.jvm.internal.p.i(r3, r0)
            E9.h r0 = r3.b()
            java.lang.String r1 = "getContainingDeclaration(...)"
            kotlin.jvm.internal.p.h(r0, r1)
            boolean r0 = h(r0)
            if (r0 != 0) goto L50
            java.util.Collection r0 = r3.d()
            java.lang.String r2 = "getOverriddenDescriptors(...)"
            kotlin.jvm.internal.p.h(r0, r2)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L29
            goto L47
        L29:
            java.util.Iterator r0 = r0.iterator()
        L2d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L47
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.e r2 = (kotlin.reflect.jvm.internal.impl.descriptors.e) r2
            E9.h r2 = r2.b()
            kotlin.jvm.internal.p.h(r2, r1)
            boolean r2 = h(r2)
            if (r2 == 0) goto L2d
            goto L50
        L47:
            boolean r0 = E9.C0809n.c(r3)
            if (r0 == 0) goto L4e
            goto L50
        L4e:
            r0 = 0
            goto L51
        L50:
            r0 = 1
        L51:
            if (r0 != 0) goto La6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "must override ''equals()'' in Any"
            r0.append(r2)
            E9.h r2 = r3.b()
            kotlin.jvm.internal.p.h(r2, r1)
            boolean r1 = ka.C4829i.g(r2)
            if (r1 == 0) goto La1
            kotlin.reflect.jvm.internal.impl.renderer.b r1 = kotlin.reflect.jvm.internal.impl.renderer.b.f35919j
            E9.h r3 = r3.b()
            java.lang.String r2 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.p.g(r3, r2)
            E9.b r3 = (E9.InterfaceC0797b) r3
            ya.d0 r3 = r3.n()
            java.lang.String r2 = "getDefaultType(...)"
            kotlin.jvm.internal.p.h(r3, r2)
            ya.S r3 = Da.d.D(r3)
            java.lang.String r3 = r1.S(r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = " or define ''equals(other: "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = "): Boolean''"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.append(r3)
        La1:
            java.lang.String r3 = r0.toString()
            return r3
        La6:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: Fa.s.g(kotlin.reflect.jvm.internal.impl.descriptors.e):java.lang.String");
    }

    public static final boolean h(InterfaceC0803h interfaceC0803h) {
        return (interfaceC0803h instanceof InterfaceC0797b) && C9.j.b0((InterfaceC0797b) interfaceC0803h);
    }

    public static final String i(kotlin.reflect.jvm.internal.impl.descriptors.e Checks) {
        boolean zW;
        kotlin.jvm.internal.p.i(Checks, "$this$Checks");
        S sH = Checks.H();
        if (sH == null) {
            sH = Checks.K();
        }
        s sVar = f2665a;
        boolean z10 = false;
        if (sH != null) {
            ya.S returnType = Checks.getReturnType();
            if (returnType != null) {
                ya.S type = sH.getType();
                kotlin.jvm.internal.p.h(type, "getType(...)");
                zW = Da.d.w(returnType, type);
            } else {
                zW = false;
            }
            if (zW || sVar.j(Checks, sH)) {
                z10 = true;
            }
        }
        if (z10) {
            return null;
        }
        return "receiver must be a supertype of the return type";
    }

    @Override // Fa.b
    public List<h> b() {
        return f2666b;
    }

    public final boolean j(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, S s10) {
        ga.b bVarN;
        ya.S returnType;
        InterfaceC5460g value = s10.getValue();
        kotlin.jvm.internal.p.h(value, "getValue(...)");
        if (!(value instanceof C5458e)) {
            return false;
        }
        InterfaceC0797b interfaceC0797bR = ((C5458e) value).r();
        if (!interfaceC0797bR.e0() || (bVarN = DescriptorUtilsKt.n(interfaceC0797bR)) == null) {
            return false;
        }
        InterfaceC0799d interfaceC0799dC = FindClassInModuleKt.c(DescriptorUtilsKt.s(interfaceC0797bR), bVarN);
        a0 a0Var = interfaceC0799dC instanceof a0 ? (a0) interfaceC0799dC : null;
        if (a0Var == null || (returnType = eVar.getReturnType()) == null) {
            return false;
        }
        return Da.d.w(returnType, a0Var.E());
    }
}
