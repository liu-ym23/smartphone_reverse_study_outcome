package u8;

import a.AbstractC0291a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import m8.C1682b;
import r8.AbstractC1881c;
import r8.AbstractC1883e;
import t8.C2024a;
import x8.InterfaceC2118a;

/* renamed from: u8.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2049d implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6716a;
    public final Object b;

    public /* synthetic */ C2049d(Object obj, int i) {
        this.f6716a = i;
        this.b = obj;
    }

    @Override // S7.a
    public final Object invoke() {
        L8.b bVarA;
        int i = this.f6716a;
        Object obj = this.b;
        switch (i) {
            case 0:
                C2050e c2050e = (C2050e) obj;
                p pVar = c2050e.c;
                Collection collectionValues = ((Map) S0.b.g1(pVar.i, p.m[0])).values();
                ArrayList arrayList = new ArrayList();
                Iterator it = collectionValues.iterator();
                while (it.hasNext()) {
                    V8.q qVarA = ((C2024a) c2050e.b.f903a).d.a(pVar, (C1682b) it.next());
                    if (qVarA != null) {
                        arrayList.add(qVarA);
                    }
                }
                return (Q8.o[]) AbstractC0291a.A(arrayList).toArray(new Q8.o[0]);
            default:
                InterfaceC2118a interfaceC2118a = ((r8.j) obj).d;
                if (interfaceC2118a instanceof n8.g) {
                    Object obj2 = AbstractC1883e.f5683a;
                    bVarA = AbstractC1883e.a(((n8.g) interfaceC2118a).a());
                } else if (interfaceC2118a instanceof n8.m) {
                    Object obj3 = AbstractC1883e.f5683a;
                    bVarA = AbstractC1883e.a(H4.o.M(interfaceC2118a));
                } else {
                    bVarA = null;
                }
                Map mapQ = bVarA != null ? kotlin.collections.a.Q(new Pair(AbstractC1881c.b, bVarA)) : null;
                return mapQ == null ? kotlin.collections.a.M() : mapQ;
        }
    }
}
