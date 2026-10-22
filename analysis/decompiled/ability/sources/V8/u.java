package V8;

import D7.w;
import h8.C1504L;
import h8.InterfaceC1527j;
import i8.C1560f;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k8.AbstractC1634c;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes4.dex */
public final class u extends AbstractC1634c {
    public final T8.m k;
    public final ProtoBuf$TypeParameter l;
    public final a m;

    /* JADX WARN: Illegal instructions before constructor call */
    public u(T8.m mVar, ProtoBuf$TypeParameter protoBuf$TypeParameter, int i) {
        Variance variance;
        W8.i iVar = mVar.f1228a.f1222a;
        InterfaceC1527j interfaceC1527j = mVar.c;
        G8.f fVarX = N9.j.x(mVar.b, protoBuf$TypeParameter.e);
        ProtoBuf$TypeParameter.Variance variance2 = protoBuf$TypeParameter.g;
        kotlin.jvm.internal.k.e(variance2, "getVariance(...)");
        int iOrdinal = variance2.ordinal();
        if (iOrdinal == 0) {
            variance = Variance.d;
        } else if (iOrdinal == 1) {
            variance = Variance.e;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            variance = Variance.c;
        }
        Variance variance3 = variance;
        super(iVar, interfaceC1527j, C1560f.f4611a, fVarX, variance3, protoBuf$TypeParameter.f, i, C1504L.c);
        this.k = mVar;
        this.l = protoBuf$TypeParameter;
        this.m = new a(iVar, new I8.e(this, 8));
    }

    @Override // k8.AbstractC1639h
    public final List S0() {
        T8.m mVar = this.k;
        D8.j jVar = mVar.d;
        ProtoBuf$TypeParameter protoBuf$TypeParameter = this.l;
        kotlin.jvm.internal.k.f(protoBuf$TypeParameter, "<this>");
        List list = protoBuf$TypeParameter.h;
        if (list.isEmpty()) {
            list = null;
        }
        if (list == null) {
            List list2 = protoBuf$TypeParameter.i;
            kotlin.jvm.internal.k.e(list2, "getUpperBoundIdList(...)");
            List<Integer> list3 = list2;
            ArrayList arrayList = new ArrayList(w.c0(list3, 10));
            for (Integer num : list3) {
                kotlin.jvm.internal.k.c(num);
                arrayList.add(jVar.b(num.intValue()));
            }
            list = arrayList;
        }
        if (list.isEmpty()) {
            return H4.o.M(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(this).m());
        }
        List list4 = list;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.a aVar = mVar.h;
        ArrayList arrayList2 = new ArrayList(w.c0(list4, 10));
        Iterator it = list4.iterator();
        while (it.hasNext()) {
            arrayList2.add(aVar.g((ProtoBuf$Type) it.next()));
        }
        return arrayList2;
    }

    @Override // A8.b, i8.InterfaceC1555a
    public final InterfaceC1561g getAnnotations() {
        return this.m;
    }
}
