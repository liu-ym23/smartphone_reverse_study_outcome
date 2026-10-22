package J9;

import H9.C0837p;
import Z8.C1172u;
import Z8.F;
import ba.q;
import ga.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import pa.C5080d;
import ra.C5229b;
import ra.InterfaceC5238k;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.load.kotlin.e f3787a;

    /* renamed from: b, reason: collision with root package name */
    public final g f3788b;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<ga.b, InterfaceC5238k> f3789c;

    public a(kotlin.reflect.jvm.internal.impl.load.kotlin.e resolver, g kotlinClassFinder) {
        p.i(resolver, "resolver");
        p.i(kotlinClassFinder, "kotlinClassFinder");
        this.f3787a = resolver;
        this.f3788b = kotlinClassFinder;
        this.f3789c = new ConcurrentHashMap<>();
    }

    public final InterfaceC5238k a(f fileClass) {
        Collection collectionE;
        p.i(fileClass, "fileClass");
        ConcurrentHashMap<ga.b, InterfaceC5238k> concurrentHashMap = this.f3789c;
        ga.b bVarJ = fileClass.j();
        InterfaceC5238k interfaceC5238k = concurrentHashMap.get(bVarJ);
        if (interfaceC5238k == null) {
            ga.c cVarF = fileClass.j().f();
            if (fileClass.b().c() == KotlinClassHeader.Kind.MULTIFILE_CLASS) {
                List<String> listF = fileClass.b().f();
                collectionE = new ArrayList();
                for (String str : listF) {
                    b.a aVar = ga.b.f32721d;
                    ga.c cVarE = C5080d.d(str).e();
                    p.h(cVarE, "getFqNameForTopLevelClassMaybeWithDollars(...)");
                    kotlin.reflect.jvm.internal.impl.load.kotlin.f fVarB = q.b(this.f3788b, aVar.c(cVarE), this.f3787a.f().g().d());
                    if (fVarB != null) {
                        collectionE.add(fVarB);
                    }
                }
            } else {
                collectionE = C1172u.e(fileClass);
            }
            C0837p c0837p = new C0837p(this.f3787a.f().q(), cVarF);
            ArrayList arrayList = new ArrayList();
            Iterator it = collectionE.iterator();
            while (it.hasNext()) {
                InterfaceC5238k interfaceC5238kC = this.f3787a.c(c0837p, (kotlin.reflect.jvm.internal.impl.load.kotlin.f) it.next());
                if (interfaceC5238kC != null) {
                    arrayList.add(interfaceC5238kC);
                }
            }
            List listM1 = F.m1(arrayList);
            InterfaceC5238k interfaceC5238kA = C5229b.f38851d.a("package " + cVarF + " (" + fileClass + ')', listM1);
            InterfaceC5238k interfaceC5238kPutIfAbsent = concurrentHashMap.putIfAbsent(bVarJ, interfaceC5238kA);
            interfaceC5238k = interfaceC5238kPutIfAbsent == null ? interfaceC5238kA : interfaceC5238kPutIfAbsent;
        }
        p.h(interfaceC5238k, "getOrPut(...)");
        return interfaceC5238k;
    }
}
