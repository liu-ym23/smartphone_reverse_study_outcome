package u8;

import X8.AbstractC0272c;
import X8.S;
import com.google.protobuf.C0958k1;
import h8.InterfaceC1528k;
import i8.InterfaceC1555a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import k8.AbstractC1634c;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import t8.C2024a;
import t8.C2026c;
import y8.C2140c;
import y8.C2148k;

/* loaded from: classes4.dex */
public final class E extends AbstractC1634c {
    public final K1.a k;
    public final n8.v l;

    /* JADX WARN: Illegal instructions before constructor call */
    public E(K1.a aVar, n8.v javaTypeParameter, int i, InterfaceC1528k interfaceC1528k) {
        kotlin.jvm.internal.k.f(javaTypeParameter, "javaTypeParameter");
        C2024a c2024a = (C2024a) aVar.f903a;
        super(c2024a.f6670a, interfaceC1528k, new C2026c(aVar, javaTypeParameter, false), G8.f.e(javaTypeParameter.f5366a.getName()), Variance.c, false, i, c2024a.m);
        this.k = aVar;
        this.l = javaTypeParameter;
    }

    @Override // k8.AbstractC1639h
    public final List R0(List bounds) {
        E e;
        C2140c c2140c;
        kotlin.jvm.internal.k.f(bounds, "bounds");
        K1.a aVar = this.k;
        C2140c c2140c2 = ((C2024a) aVar.f903a).f6673r;
        c2140c2.getClass();
        List<X8.w> list = bounds;
        ArrayList arrayList = new ArrayList(D7.w.c0(list, 10));
        for (X8.w wVar : list) {
            C2148k c2148k = C2148k.d;
            kotlin.jvm.internal.k.f(wVar, "<this>");
            if (S.c(wVar, c2148k, null)) {
                e = this;
                c2140c = c2140c2;
            } else {
                e = this;
                c2140c = c2140c2;
                X8.w wVarA = c2140c.a(new C0958k1((InterfaceC1555a) e, false, aVar, AnnotationQualifierApplicabilityType.f, false), wVar, EmptyList.f4893a, null, false);
                if (wVarA != null) {
                    wVar = wVarA;
                }
            }
            arrayList.add(wVar);
            this = e;
            c2140c2 = c2140c;
        }
        return arrayList;
    }

    @Override // k8.AbstractC1639h
    public final List S0() {
        Type[] bounds = this.l.f5366a.getBounds();
        kotlin.jvm.internal.k.e(bounds, "getBounds(...)");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new n8.j(type));
        }
        n8.j jVar = (n8.j) D7.v.W0(arrayList);
        RandomAccess randomAccess = arrayList;
        if (kotlin.jvm.internal.k.b(jVar != null ? jVar.f5359a : null, Object.class)) {
            randomAccess = EmptyList.f4893a;
        }
        ArrayList arrayList2 = (Collection) randomAccess;
        boolean zIsEmpty = arrayList2.isEmpty();
        K1.a aVar = this.k;
        if (zIsEmpty) {
            return H4.o.M(AbstractC0272c.f(((C2024a) aVar.f903a).o.c().e(), ((C2024a) aVar.f903a).o.c().o()));
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(D7.w.c0(arrayList3, 10));
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            arrayList4.add(((A5.c) aVar.e).C((n8.j) it.next(), M.a.o0(TypeUsage.b, false, this, 3)));
        }
        return arrayList4;
    }
}
