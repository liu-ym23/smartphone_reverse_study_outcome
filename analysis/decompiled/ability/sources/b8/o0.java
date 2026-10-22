package b8;

import T8.C0250b;
import X8.C0280k;
import f8.C1440a;
import fa.C1449a;
import g8.C1471g;
import g8.C1473i;
import h8.C1504L;
import j8.C1602a;
import j8.InterfaceC1603b;
import j8.InterfaceC1605d;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import k8.C1643l;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$Kind;
import n8.AbstractC1744c;
import q8.C1828a;
import q8.C1838k;
import t8.C2024a;
import t8.C2025b;
import t8.C2027d;
import u1.C2031a;
import v0.C2054a;
import y8.C2140c;
import z8.C2193e;
import z8.C2195g;
import z8.C2196h;

/* loaded from: classes4.dex */
public abstract class o0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f2048a = new ConcurrentHashMap();

    public static final m8.e a(Class cls) {
        InterfaceC1603b interfaceC1603bJ;
        InterfaceC1605d interfaceC1605dJ;
        kotlin.jvm.internal.k.f(cls, "<this>");
        ClassLoader classLoaderD = AbstractC1744c.d(cls);
        w0 w0Var = new w0(classLoaderD);
        ConcurrentHashMap concurrentHashMap = f2048a;
        WeakReference weakReference = (WeakReference) concurrentHashMap.get(w0Var);
        if (weakReference != null) {
            m8.e eVar = (m8.e) weakReference.get();
            if (eVar != null) {
                return eVar;
            }
            concurrentHashMap.remove(w0Var, weakReference);
        }
        T8.l lVar = T8.l.f;
        C2031a c2031a = new C2031a(classLoaderD);
        ClassLoader classLoader = C7.r.class.getClassLoader();
        kotlin.jvm.internal.k.e(classLoader, "getClassLoader(...)");
        C2031a c2031a2 = new C2031a(classLoader);
        B1.c cVar = new B1.c(classLoaderD);
        String moduleName = "runtime module for " + classLoaderD;
        m8.d dVar = m8.d.b;
        m8.d dVar2 = m8.d.c;
        kotlin.jvm.internal.k.f(moduleName, "moduleName");
        W8.i iVar = new W8.i("DeserializationComponentsForJava.ModuleData");
        JvmBuiltIns$Kind[] jvmBuiltIns$KindArr = JvmBuiltIns$Kind.f4947a;
        C1473i c1473i = new C1473i(iVar);
        k8.z zVar = new k8.z(G8.f.g("<" + moduleName + '>'), iVar, c1473i, 56);
        W8.k kVar = iVar.f1495a;
        kVar.lock();
        try {
            if (c1473i.f4384a != null) {
                throw new AssertionError("Built-ins module is already set: " + c1473i.f4384a + " (attempting to reset to " + zVar + ")");
            }
            c1473i.f4384a = zVar;
            kVar.unlock();
            c1473i.f = new e8.k(zVar, 1);
            C2195g c2195g = new C2195g();
            A0.b bVar = new A0.b(9);
            u1.d dVar3 = new u1.d(iVar, zVar);
            C2196h c2196h = C2196h.c;
            r8.h hVar = r8.h.c;
            r8.h hVar2 = r8.h.f5685a;
            EmptyList emptyList = EmptyList.f4893a;
            C2054a c2054a = new C2054a(iVar, emptyList);
            C1504L c1504l = C1504L.c;
            e8.m mVar = new e8.m(zVar, dVar3);
            kotlin.reflect.jvm.internal.impl.load.java.a aVar = kotlin.reflect.jvm.internal.impl.load.java.a.d;
            C1828a c1828a = new C1828a(aVar);
            C2025b c2025b = C2025b.f6679a;
            C2140c c2140c = new C2140c();
            Y8.k.b.getClass();
            Y8.l lVar2 = Y8.j.b;
            C2027d c2027d = new C2027d(new C2024a(iVar, cVar, c2031a, c2195g, hVar, dVar, hVar2, c2054a, dVar2, bVar, c2196h, c1504l, p8.b.f5555a, zVar, mVar, c1828a, c2140c, C1838k.f5602a, c2025b, lVar2, aVar, new C2196h()));
            F8.f jvmMetadataVersion = F8.f.g;
            kotlin.jvm.internal.k.f(jvmMetadataVersion, "jvmMetadataVersion");
            C1449a c1449a = new C1449a(12, c2031a, false, c2195g);
            C2193e c2193e = new C2193e(zVar, dVar3, iVar, c2031a);
            c2193e.f = jvmMetadataVersion;
            List listM = H4.o.M(C0280k.f1533a);
            e8.i iVar2 = zVar.d;
            C1473i c1473i2 = iVar2 instanceof C1473i ? (C1473i) iVar2 : null;
            C2196h c2196h2 = C2196h.b;
            if (c1473i2 == null || (interfaceC1603bJ = c1473i2.J()) == null) {
                interfaceC1603bJ = C1602a.b;
            }
            if (c1473i2 == null || (interfaceC1605dJ = c1473i2.J()) == null) {
                interfaceC1605dJ = C1602a.d;
            }
            w0 w0Var2 = w0Var;
            T8.k kVar2 = new T8.k(iVar, zVar, c1449a, c2193e, c2027d, dVar, c2196h2, emptyList, dVar3, interfaceC1603bJ, interfaceC1605dJ, F8.i.f596a, lVar2, new C2054a(iVar, emptyList), listM, lVar);
            c2195g.f6984a = kVar2;
            bVar.b = new C2031a(c2027d);
            kotlin.reflect.jvm.internal.impl.builtins.jvm.b additionalClassPartsProvider = c1473i.J();
            kotlin.reflect.jvm.internal.impl.builtins.jvm.b platformDependentDeclarationFilter = c1473i.J();
            C2054a c2054a2 = new C2054a(iVar, emptyList);
            kotlin.jvm.internal.k.f(additionalClassPartsProvider, "additionalClassPartsProvider");
            kotlin.jvm.internal.k.f(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
            g8.m mVar2 = new g8.m(iVar, c2031a2, zVar);
            A8.d dVar4 = new A8.d(mVar2, 3);
            U8.a aVar2 = U8.a.m;
            mVar2.c = new T8.k(iVar, zVar, dVar4, new C0250b(zVar, dVar3, aVar2), mVar2, H4.o.N(new C1440a(iVar, zVar), new C1471g(iVar, zVar)), dVar3, additionalClassPartsProvider, platformDependentDeclarationFilter, aVar2.f1179a, lVar2, c2054a2, 262144);
            List descriptors = D7.q.I0(new k8.z[]{zVar});
            kotlin.jvm.internal.k.f(descriptors, "descriptors");
            EmptySet friends = EmptySet.f4895a;
            kotlin.jvm.internal.k.f(friends, "friends");
            zVar.g = new u1.d(descriptors, friends, emptyList, friends);
            zVar.h = new C1643l(H4.o.N(c2027d, mVar2), "CompositeProvider@RuntimeModuleData for " + zVar);
            m8.e eVar2 = new m8.e(kVar2, new A5.c(c2195g, c2031a));
            while (true) {
                w0 w0Var3 = w0Var2;
                WeakReference weakReference2 = (WeakReference) concurrentHashMap.putIfAbsent(w0Var3, new WeakReference(eVar2));
                if (weakReference2 == null) {
                    return eVar2;
                }
                m8.e eVar3 = (m8.e) weakReference2.get();
                if (eVar3 != null) {
                    return eVar3;
                }
                concurrentHashMap.remove(w0Var3, weakReference2);
                w0Var2 = w0Var3;
            }
        } finally {
        }
    }
}
