package z7;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class p1 {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f11933a = new ConcurrentHashMap();

    public static final k8.f a(Class cls) {
        h8.b bVarJ;
        h8.d dVarJ;
        q7.k.e(cls, "<this>");
        ClassLoader classLoaderD = l8.d.d(cls);
        y1 y1Var = new y1(classLoaderD);
        ConcurrentHashMap concurrentHashMap = f11933a;
        WeakReference weakReference = (WeakReference) concurrentHashMap.get(y1Var);
        if (weakReference != null) {
            k8.f fVar = (k8.f) weakReference.get();
            if (fVar != null) {
                return fVar;
            }
            concurrentHashMap.remove(y1Var, weakReference);
        }
        k8.b bVar = new k8.b(classLoaderD);
        ClassLoader classLoader = c7.r.class.getClassLoader();
        q7.k.d(classLoader, "Unit::class.java.classLoader");
        k8.b bVar2 = new k8.b(classLoader);
        k8.b bVar3 = new k8.b(classLoaderD);
        String str = "runtime module for " + classLoaderD;
        k8.e eVar = k8.e.f5655b;
        k8.e eVar2 = k8.e.f5656c;
        q7.k.e(str, "moduleName");
        u9.k kVar = new u9.k("DeserializationComponentsForJava.ModuleData");
        e8.i iVar = new e8.i(kVar);
        i8.a0 a0Var = new i8.a0(e9.f.g("<" + str + '>'), kVar, iVar, 56);
        u9.m mVar = kVar.f10208a;
        mVar.lock();
        try {
            if (iVar.f2000a != null) {
                throw new AssertionError("Built-ins module is already set: " + iVar.f2000a + " (attempting to reset to " + a0Var + ")");
            }
            iVar.f2000a = a0Var;
            mVar.unlock();
            iVar.f3150f = new c8.k(a0Var, 1);
            x8.d dVar = new x8.d();
            o4.d0 d0Var = new o4.d0(6, false);
            i5.f fVar2 = new i5.f(kVar, a0Var);
            x8.e eVar3 = x8.e.f11256c;
            p8.h hVar = p8.h.f8520c;
            p8.h hVar2 = p8.h.f8518a;
            h4.n nVar = new h4.n(kVar);
            f8.o0 o0Var = f8.o0.f3504h;
            c8.l lVar = new c8.l(a0Var, fVar2);
            o8.t tVar = o8.t.f7848c;
            o8.c cVar = new o8.c(tVar);
            r8.b bVar4 = r8.b.f9026a;
            w8.d dVar2 = new w8.d();
            w9.l.f10948b.getClass();
            w9.m mVar2 = w9.k.f10947b;
            r8.e eVar4 = new r8.e(new r8.a(kVar, bVar3, bVar, dVar, hVar, eVar, hVar2, nVar, eVar2, d0Var, eVar3, o0Var, n8.b.f6876a, a0Var, lVar, cVar, dVar2, o8.m.f7831a, bVar4, mVar2, tVar, new x8.e()));
            d9.f fVar3 = d9.f.f3008g;
            q7.k.e(fVar3, "jvmMetadataVersion");
            nb.f fVar4 = new nb.f(17, bVar, dVar);
            a4.p pVar = new a4.p();
            pVar.f192f = bVar;
            pVar.f193g = kVar.b(new r8.c(16, pVar));
            pVar.f194h = a0Var;
            pVar.f195i = fVar2;
            pVar.f196j = new nb.f(a0Var, fVar2);
            pVar.f197k = d9.f.f3008g;
            pVar.f197k = fVar3;
            List listS = a.a.S(v9.k.f10563a);
            c8.h hVar3 = a0Var.f4739i;
            e8.i iVar2 = hVar3 instanceof e8.i ? (e8.i) hVar3 : null;
            x8.e eVar5 = x8.e.f11255b;
            if (iVar2 == null || (bVarJ = iVar2.J()) == null) {
                bVarJ = h8.a.f4222b;
            }
            h8.b bVar5 = bVarJ;
            if (iVar2 == null || (dVarJ = iVar2.J()) == null) {
                dVarJ = h8.a.f4224d;
            }
            r9.i iVar3 = new r9.i(kVar, a0Var, fVar4, pVar, eVar4, eVar, eVar5, d7.z.f2978f, fVar2, bVar5, dVarJ, d9.h.f3015a, mVar2, new h4.n(kVar), listS, 262144);
            dVar.f11254a = iVar3;
            d0Var.f7326g = new a7.d(20, eVar4);
            e8.o oVarJ = iVar.J();
            e8.o oVarJ2 = iVar.J();
            h4.n nVar2 = new h4.n(kVar);
            q7.k.e(oVarJ, "additionalClassPartsProvider");
            q7.k.e(oVarJ2, "platformDependentDeclarationFilter");
            e8.p pVar2 = new e8.p(kVar, bVar2, a0Var);
            o4.d0 d0Var2 = new o4.d0(7, pVar2);
            s9.a aVar = s9.a.f9622m;
            pVar2.f3174c = new r9.i(kVar, a0Var, d0Var2, new nb.f(a0Var, fVar2, aVar), pVar2, r9.l.f9079a, r9.j.f9068c, d7.s.u0(new d8.a(kVar, a0Var), new e8.g(kVar, a0Var)), fVar2, oVarJ, oVarJ2, aVar.f8822a, mVar2, nVar2, null, 786432);
            a0Var.f4742l = new b9.g(d7.n.w0(new i8.a0[]{a0Var}));
            a0Var.f4743m = new i8.l(d7.s.u0(eVar4, pVar2), "CompositeProvider@RuntimeModuleData for " + a0Var);
            k8.f fVar5 = new k8.f(iVar3, new i5.l(dVar, bVar));
            while (true) {
                WeakReference weakReference2 = (WeakReference) concurrentHashMap.putIfAbsent(y1Var, new WeakReference(fVar5));
                if (weakReference2 == null) {
                    return fVar5;
                }
                k8.f fVar6 = (k8.f) weakReference2.get();
                if (fVar6 != null) {
                    return fVar6;
                }
                concurrentHashMap.remove(y1Var, weakReference2);
            }
        } finally {
        }
    }
}
