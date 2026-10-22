package b8;

import com.fasterxml.jackson.core.JsonPointer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import m8.C1682b;
import n8.AbstractC1744c;
import u1.C2031a;
import z8.C2195g;

/* loaded from: classes4.dex */
public final class M implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2024a;
    public final O b;

    public /* synthetic */ M(O o, int i) {
        this.f2024a = i;
        this.b = o;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v6 */
    @Override // S7.a
    public final Object invoke() throws InvalidProtocolBufferException {
        ?? M5;
        switch (this.f2024a) {
            case 0:
                O o = this.b;
                p0 p0Var = o.c;
                Z7.t tVar = O.g[0];
                C1682b c1682b = (C1682b) p0Var.invoke();
                if (c1682b == null) {
                    return Q8.n.b;
                }
                p0 p0Var2 = o.f2016a;
                Z7.t tVar2 = AbstractC0828A.b[0];
                Object objInvoke = p0Var2.invoke();
                kotlin.jvm.internal.k.e(objInvoke, "getValue(...)");
                A5.c cVar = ((m8.e) objInvoke).b;
                C2195g c2195g = (C2195g) cVar.b;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) cVar.d;
                Class cls = c1682b.f5307a;
                G8.b bVarA = AbstractC1744c.a(cls);
                Object obj = concurrentHashMap.get(bVarA);
                if (obj == null) {
                    G8.c cVar2 = AbstractC1744c.a(cls).f687a;
                    A8.a aVar = c1682b.b;
                    KotlinClassHeader$Kind kotlinClassHeader$Kind = (KotlinClassHeader$Kind) aVar.c;
                    KotlinClassHeader$Kind kotlinClassHeader$Kind2 = KotlinClassHeader$Kind.h;
                    if (kotlinClassHeader$Kind == kotlinClassHeader$Kind2) {
                        String[] strArr = (String[]) aVar.e;
                        if (kotlinClassHeader$Kind != kotlinClassHeader$Kind2) {
                            strArr = null;
                        }
                        List listL = strArr != null ? D7.q.L(strArr) : null;
                        if (listL == null) {
                            listL = EmptyList.f4893a;
                        }
                        M5 = new ArrayList();
                        Iterator it = listL.iterator();
                        while (it.hasNext()) {
                            G8.c cVar3 = new G8.c(O8.b.c((String) it.next()).f1042a.replace(JsonPointer.SEPARATOR, '.'));
                            G8.c cVarE = cVar3.e();
                            G8.f fVarF = cVar3.f();
                            kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
                            G8.b bVar = new G8.b(cVarE, fVarF);
                            C2031a c2031a = (C2031a) cVar.c;
                            kotlin.jvm.internal.k.f(c2195g.c().c, "<this>");
                            C1682b c1682bV = Z6.k.v(c2031a, bVar, F8.f.g);
                            if (c1682bV != null) {
                                M5.add(c1682bV);
                            }
                        }
                    } else {
                        M5 = H4.o.M(c1682b);
                    }
                    g8.k kVar = new g8.k(c2195g.c().b, cVar2, 1);
                    ArrayList arrayList = new ArrayList();
                    Iterator it2 = ((Iterable) M5).iterator();
                    while (it2.hasNext()) {
                        V8.q qVarA = c2195g.a(kVar, (C1682b) it2.next());
                        if (qVarA != null) {
                            arrayList.add(qVarA);
                        }
                    }
                    Q8.o oVarP = com.stepos.statsrpk.d.p(D7.v.f1(arrayList), "package " + cVar2 + " (" + c1682b + ')');
                    Object objPutIfAbsent = concurrentHashMap.putIfAbsent(bVarA, oVarP);
                    obj = objPutIfAbsent == null ? oVarP : objPutIfAbsent;
                }
                kotlin.jvm.internal.k.e(obj, "getOrPut(...)");
                return (Q8.o) obj;
            default:
                p0 p0Var3 = this.b.c;
                Z7.t tVar3 = O.g[0];
                C1682b c1682b2 = (C1682b) p0Var3.invoke();
                if (c1682b2 != null) {
                    A8.a aVar2 = c1682b2.b;
                    String[] strArr2 = (String[]) aVar2.e;
                    String[] strArr3 = (String[]) aVar2.g;
                    if (strArr2 != null && strArr3 != null) {
                        Pair pairH = F8.i.h(strArr2, strArr3);
                        return new Triple((F8.g) pairH.f4886a, (ProtoBuf$Package) pairH.b, (F8.f) aVar2.d);
                    }
                }
                return null;
        }
    }
}
