package f8;

import D7.v;
import X8.w;
import d9.AbstractC1398s;
import h8.InterfaceC1503K;
import h8.InterfaceC1527j;
import h8.InterfaceC1536s;
import i8.C1560f;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k8.C1649s;
import k8.K;
import k8.Q;
import k8.t;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;

/* renamed from: f8.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1444e extends K {
    public C1444e(InterfaceC1527j interfaceC1527j, C1444e c1444e, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, boolean z10) {
        super(interfaceC1527j, c1444e, C1560f.f4611a, AbstractC1398s.g, callableMemberDescriptor$Kind, InterfaceC1503K.f4577I);
        this.m = true;
        this.u = z10;
        this.f4869v = false;
    }

    @Override // k8.K, k8.t
    public final t T0(G8.f fVar, InterfaceC1527j newOwner, InterfaceC1536s interfaceC1536s, InterfaceC1503K interfaceC1503K, InterfaceC1561g annotations, CallableMemberDescriptor$Kind kind) {
        kotlin.jvm.internal.k.f(newOwner, "newOwner");
        kotlin.jvm.internal.k.f(kind, "kind");
        kotlin.jvm.internal.k.f(annotations, "annotations");
        return new C1444e(newOwner, (C1444e) interfaceC1536s, kind, this.u);
    }

    @Override // k8.t
    public final t U0(C1649s c1649s) {
        G8.f fVar;
        C1444e c1444e = (C1444e) super.U0(c1649s);
        if (c1444e == null) {
            return null;
        }
        List listX = c1444e.x();
        kotlin.jvm.internal.k.e(listX, "getValueParameters(...)");
        List list = listX;
        if ((list instanceof Collection) && list.isEmpty()) {
            return c1444e;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            w type = ((Q) it.next()).getType();
            kotlin.jvm.internal.k.e(type, "getType(...)");
            if (M.a.S(type) != null) {
                List listX2 = c1444e.x();
                kotlin.jvm.internal.k.e(listX2, "getValueParameters(...)");
                List list2 = listX2;
                ArrayList arrayList = new ArrayList(D7.w.c0(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    w type2 = ((Q) it2.next()).getType();
                    kotlin.jvm.internal.k.e(type2, "getType(...)");
                    arrayList.add(M.a.S(type2));
                }
                int size = c1444e.x().size() - arrayList.size();
                boolean z10 = true;
                if (size == 0) {
                    List listX3 = c1444e.x();
                    kotlin.jvm.internal.k.e(listX3, "getValueParameters(...)");
                    ArrayList arrayListM1 = v.m1(arrayList, listX3);
                    if (arrayListM1.isEmpty()) {
                        return c1444e;
                    }
                    Iterator it3 = arrayListM1.iterator();
                    while (it3.hasNext()) {
                        Pair pair = (Pair) it3.next();
                        if (!kotlin.jvm.internal.k.b((G8.f) pair.f4886a, ((Q) pair.b).getName())) {
                        }
                    }
                    return c1444e;
                }
                List listX4 = c1444e.x();
                kotlin.jvm.internal.k.e(listX4, "getValueParameters(...)");
                List<Q> list3 = listX4;
                ArrayList arrayList2 = new ArrayList(D7.w.c0(list3, 10));
                for (Q q5 : list3) {
                    G8.f name = q5.getName();
                    kotlin.jvm.internal.k.e(name, "getName(...)");
                    int i = q5.f;
                    int i6 = i - size;
                    if (i6 >= 0 && (fVar = (G8.f) arrayList.get(i6)) != null) {
                        name = fVar;
                    }
                    arrayList2.add(q5.R0(c1444e, name, i));
                }
                C1649s c1649sX0 = c1444e.X0(kotlin.reflect.jvm.internal.impl.types.a.b);
                if (arrayList.isEmpty()) {
                    z10 = false;
                } else {
                    Iterator it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        if (((G8.f) it4.next()) == null) {
                            break;
                        }
                    }
                    z10 = false;
                }
                c1649sX0.f4858v = Boolean.valueOf(z10);
                c1649sX0.g = arrayList2;
                c1649sX0.e = c1444e.a();
                t tVarU0 = super.U0(c1649sX0);
                kotlin.jvm.internal.k.c(tVarU0);
                return tVarU0;
            }
        }
        return c1444e;
    }

    @Override // k8.t, h8.InterfaceC1539v
    public final boolean isExternal() {
        return false;
    }

    @Override // k8.t, h8.InterfaceC1536s
    public final boolean isInline() {
        return false;
    }

    @Override // k8.t, h8.InterfaceC1536s
    public final boolean t() {
        return false;
    }
}
