package U9;

import E9.InterfaceC0797b;
import E9.W;
import E9.i0;
import H9.V;
import W9.Y;
import Z8.C1174w;
import Z8.F;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import ra.InterfaceC5238k;
import ya.S;

/* loaded from: classes5.dex */
public final class g {
    public static final List<i0> a(Collection<? extends S> newValueParameterTypes, Collection<? extends i0> oldValueParameters, kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        p.i(newValueParameterTypes, "newValueParameterTypes");
        p.i(oldValueParameters, "oldValueParameters");
        kotlin.reflect.jvm.internal.impl.descriptors.a newOwner = aVar;
        p.i(newOwner, "newOwner");
        newValueParameterTypes.size();
        oldValueParameters.size();
        List<Pair> listW1 = F.w1(newValueParameterTypes, oldValueParameters);
        ArrayList arrayList = new ArrayList(C1174w.x(listW1, 10));
        for (Pair pair : listW1) {
            S s10 = (S) pair.a();
            i0 i0Var = (i0) pair.b();
            int index = i0Var.getIndex();
            F9.g annotations = i0Var.getAnnotations();
            ga.e name = i0Var.getName();
            p.h(name, "getName(...)");
            boolean zV0 = i0Var.v0();
            boolean zL0 = i0Var.l0();
            boolean zJ0 = i0Var.j0();
            S sK = i0Var.p0() != null ? DescriptorUtilsKt.s(newOwner).g().k(s10) : null;
            W wE = i0Var.e();
            p.h(wE, "getSource(...)");
            arrayList.add(new V(newOwner, null, index, annotations, name, s10, zV0, zL0, zJ0, sK, wE));
            newOwner = aVar;
        }
        return arrayList;
    }

    public static final Y b(InterfaceC0797b interfaceC0797b) {
        p.i(interfaceC0797b, "<this>");
        InterfaceC0797b interfaceC0797bX = DescriptorUtilsKt.x(interfaceC0797b);
        if (interfaceC0797bX == null) {
            return null;
        }
        InterfaceC5238k interfaceC5238kG0 = interfaceC0797bX.g0();
        Y y10 = interfaceC5238kG0 instanceof Y ? (Y) interfaceC5238kG0 : null;
        return y10 == null ? b(interfaceC0797bX) : y10;
    }
}
