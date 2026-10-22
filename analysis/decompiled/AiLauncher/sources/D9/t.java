package D9;

import E9.InterfaceC0797b;
import E9.b0;
import Z8.C1174w;
import Z8.F;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ya.AbstractC5990d0;
import ya.w0;

/* loaded from: classes5.dex */
public final class t {
    public static final w0 a(InterfaceC0797b from, InterfaceC0797b to) {
        kotlin.jvm.internal.p.i(from, "from");
        kotlin.jvm.internal.p.i(to, "to");
        from.o().size();
        to.o().size();
        w0.a aVar = w0.f44131c;
        List<b0> listO = from.o();
        kotlin.jvm.internal.p.h(listO, "getDeclaredTypeParameters(...)");
        List<b0> list = listO;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((b0) it.next()).j());
        }
        List<b0> listO2 = to.o();
        kotlin.jvm.internal.p.h(listO2, "getDeclaredTypeParameters(...)");
        List<b0> list2 = listO2;
        ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            AbstractC5990d0 abstractC5990d0N = ((b0) it2.next()).n();
            kotlin.jvm.internal.p.h(abstractC5990d0N, "getDefaultType(...)");
            arrayList2.add(Da.d.d(abstractC5990d0N));
        }
        return w0.a.e(aVar, kotlin.collections.a.y(F.w1(arrayList, arrayList2)), false, 2, null);
    }
}
