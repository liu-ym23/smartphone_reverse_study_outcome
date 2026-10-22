package f8;

import D7.v;
import D7.w;
import H4.o;
import X8.AbstractC0271b;
import X8.AbstractC0272c;
import X8.F;
import X8.H;
import h8.C1504L;
import h8.InterfaceC1507O;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1540w;
import h9.AbstractC1544a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k8.AbstractC1629B;

/* renamed from: f8.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1441b extends AbstractC0271b {
    public final /* synthetic */ C1442c c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1441b(C1442c c1442c) {
        super(c1442c.e);
        this.c = c1442c;
    }

    @Override // X8.AbstractC0275f
    public final Collection b() {
        List listN;
        C1442c c1442c = this.c;
        int i = c1442c.h;
        j jVar = c1442c.g;
        C1445f c1445f = C1445f.c;
        if (kotlin.jvm.internal.k.b(jVar, c1445f)) {
            listN = o.M(C1442c.l);
        } else if (kotlin.jvm.internal.k.b(jVar, C1446g.c)) {
            listN = o.N(C1442c.m, new G8.b(e8.o.l, c1445f.a(i)));
        } else {
            C1448i c1448i = C1448i.c;
            if (kotlin.jvm.internal.k.b(jVar, c1448i)) {
                listN = o.M(C1442c.l);
            } else {
                if (!kotlin.jvm.internal.k.b(jVar, C1447h.c)) {
                    int i6 = AbstractC1544a.f4593a;
                    throw new IllegalStateException("should not be called");
                }
                listN = o.N(C1442c.m, new G8.b(e8.o.f, c1448i.a(i)));
            }
        }
        InterfaceC1540w interfaceC1540wD = ((AbstractC1629B) c1442c.f).d();
        List<G8.b> list = listN;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        for (G8.b bVar : list) {
            InterfaceC1522e interfaceC1522eA = kotlin.reflect.jvm.internal.impl.descriptors.a.a(interfaceC1540wD, bVar);
            if (interfaceC1522eA == null) {
                throw new IllegalStateException(("Built-in class " + bVar + " not found").toString());
            }
            List listB1 = v.b1(interfaceC1522eA.m().getParameters().size(), c1442c.k);
            ArrayList arrayList2 = new ArrayList(w.c0(listB1, 10));
            Iterator it = listB1.iterator();
            while (it.hasNext()) {
                arrayList2.add(new F(((InterfaceC1507O) it.next()).g()));
            }
            H.b.getClass();
            arrayList.add(AbstractC0272c.t(H.c, interfaceC1522eA, arrayList2));
        }
        return v.f1(arrayList);
    }

    @Override // X8.AbstractC0271b, X8.K
    public final InterfaceC1524g d() {
        return this.c;
    }

    @Override // X8.K
    public final boolean f() {
        return true;
    }

    @Override // X8.K
    public final List getParameters() {
        return this.c.k;
    }

    @Override // X8.AbstractC0275f
    public final C1504L h() {
        return C1504L.c;
    }

    @Override // X8.AbstractC0271b
    /* renamed from: m */
    public final InterfaceC1522e d() {
        return this.c;
    }

    public final String toString() {
        return this.c.toString();
    }
}
