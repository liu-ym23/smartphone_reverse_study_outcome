package e8;

import g8.C1472h;
import h8.InterfaceC1497E;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k8.C1643l;
import k8.w;
import k8.z;

/* loaded from: classes4.dex */
public final class k implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4386a;
    public final z b;

    public /* synthetic */ k(z zVar, int i) {
        this.f4386a = i;
        this.b = zVar;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f4386a) {
            case 0:
                return ((w) this.b.V(o.i)).g;
            case 1:
                return new C1472h(this.b);
            default:
                z zVar = this.b;
                u1.d dVar = zVar.g;
                if (dVar == null) {
                    StringBuilder sb = new StringBuilder("Dependencies of module ");
                    String str = zVar.getName().f690a;
                    kotlin.jvm.internal.k.e(str, "toString(...)");
                    sb.append(str);
                    sb.append(" were not set before querying module content");
                    throw new AssertionError(sb.toString());
                }
                List list = (List) dVar.b;
                zVar.Q0();
                list.contains(zVar);
                List list2 = list;
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    ((z) it.next()).getClass();
                }
                ArrayList arrayList = new ArrayList(D7.w.c0(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    InterfaceC1497E interfaceC1497E = ((z) it2.next()).h;
                    kotlin.jvm.internal.k.c(interfaceC1497E);
                    arrayList.add(interfaceC1497E);
                }
                return new C1643l(arrayList, "CompositeProvider@ModuleDescriptor for " + zVar.getName());
        }
    }
}
