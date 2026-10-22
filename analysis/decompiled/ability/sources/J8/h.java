package J8;

import h8.InterfaceC1501I;
import h8.InterfaceC1506N;
import h8.InterfaceC1522e;
import h8.InterfaceC1526i;
import h8.InterfaceC1527j;
import h8.InterfaceC1536s;
import java.util.Comparator;

/* loaded from: classes4.dex */
public final class h implements Comparator {
    public static final h b = new h(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f884a;

    public /* synthetic */ h(int i) {
        this.f884a = i;
    }

    public static int a(InterfaceC1527j interfaceC1527j) {
        if (e.m(interfaceC1527j)) {
            return 8;
        }
        if (interfaceC1527j instanceof InterfaceC1526i) {
            return 7;
        }
        if (interfaceC1527j instanceof InterfaceC1501I) {
            return ((InterfaceC1501I) interfaceC1527j).I() == null ? 6 : 5;
        }
        if (interfaceC1527j instanceof InterfaceC1536s) {
            return ((InterfaceC1536s) interfaceC1527j).I() == null ? 4 : 3;
        }
        if (interfaceC1527j instanceof InterfaceC1522e) {
            return 2;
        }
        return interfaceC1527j instanceof InterfaceC1506N ? 1 : 0;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Integer numValueOf;
        switch (this.f884a) {
            case 0:
                InterfaceC1527j interfaceC1527j = (InterfaceC1527j) obj;
                InterfaceC1527j interfaceC1527j2 = (InterfaceC1527j) obj2;
                int iA = a(interfaceC1527j2) - a(interfaceC1527j);
                if (iA != 0) {
                    numValueOf = Integer.valueOf(iA);
                } else if (e.m(interfaceC1527j) && e.m(interfaceC1527j2)) {
                    numValueOf = 0;
                } else {
                    int iCompareTo = interfaceC1527j.getName().f690a.compareTo(interfaceC1527j2.getName().f690a);
                    numValueOf = iCompareTo != 0 ? Integer.valueOf(iCompareTo) : null;
                }
                if (numValueOf != null) {
                    return numValueOf.intValue();
                }
                return 0;
            default:
                return N9.j.m(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g((InterfaceC1522e) obj).b(), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g((InterfaceC1522e) obj2).b());
        }
    }
}
