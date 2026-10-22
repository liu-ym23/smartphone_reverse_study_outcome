package E9;

import Z8.C1173v;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ka.C4828h;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import ya.B0;
import ya.v0;

/* loaded from: classes5.dex */
public final class f0 {
    public static final N d(ya.S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        return e(s10, interfaceC0799dD instanceof InterfaceC0800e ? (InterfaceC0800e) interfaceC0799dD : null, 0);
    }

    public static final N e(ya.S s10, InterfaceC0800e interfaceC0800e, int i10) {
        if (interfaceC0800e == null || Aa.i.m(interfaceC0800e)) {
            return null;
        }
        int size = interfaceC0800e.o().size() + i10;
        if (interfaceC0800e.x()) {
            List<B0> listSubList = s10.F0().subList(i10, size);
            InterfaceC0803h interfaceC0803hB = interfaceC0800e.b();
            return new N(interfaceC0800e, listSubList, e(s10, interfaceC0803hB instanceof InterfaceC0800e ? (InterfaceC0800e) interfaceC0803hB : null, size));
        }
        if (size != s10.F0().size()) {
            C4828h.E(interfaceC0800e);
        }
        return new N(interfaceC0800e, s10.F0().subList(i10, s10.F0().size()), null);
    }

    public static final C0796a f(b0 b0Var, InterfaceC0803h interfaceC0803h, int i10) {
        return new C0796a(b0Var, interfaceC0803h, i10);
    }

    public static final List<b0> g(InterfaceC0800e interfaceC0800e) {
        List<b0> listM;
        InterfaceC0803h next;
        v0 v0VarJ;
        kotlin.jvm.internal.p.i(interfaceC0800e, "<this>");
        List<b0> listO = interfaceC0800e.o();
        kotlin.jvm.internal.p.h(listO, "getDeclaredTypeParameters(...)");
        if (!interfaceC0800e.x() && !(interfaceC0800e.b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.a)) {
            return listO;
        }
        List listD0 = SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.L(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.a0(DescriptorUtilsKt.u(interfaceC0800e), c0.f2450a), d0.f2451a), e0.f2452a));
        Iterator<InterfaceC0803h> it = DescriptorUtilsKt.u(interfaceC0800e).iterator();
        while (true) {
            listM = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next instanceof InterfaceC0797b) {
                break;
            }
        }
        InterfaceC0797b interfaceC0797b = (InterfaceC0797b) next;
        if (interfaceC0797b != null && (v0VarJ = interfaceC0797b.j()) != null) {
            listM = v0VarJ.getParameters();
        }
        if (listM == null) {
            listM = C1173v.m();
        }
        if (listD0.isEmpty() && listM.isEmpty()) {
            List<b0> listO2 = interfaceC0800e.o();
            kotlin.jvm.internal.p.h(listO2, "getDeclaredTypeParameters(...)");
            return listO2;
        }
        List<b0> listS0 = Z8.F.S0(listD0, listM);
        ArrayList arrayList = new ArrayList(C1174w.x(listS0, 10));
        for (b0 b0Var : listS0) {
            kotlin.jvm.internal.p.f(b0Var);
            arrayList.add(f(b0Var, interfaceC0800e, listO.size()));
        }
        return Z8.F.S0(listO, arrayList);
    }

    public static final boolean h(InterfaceC0803h it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it instanceof kotlin.reflect.jvm.internal.impl.descriptors.a;
    }

    public static final boolean i(InterfaceC0803h it) {
        kotlin.jvm.internal.p.i(it, "it");
        return !(it instanceof kotlin.reflect.jvm.internal.impl.descriptors.c);
    }

    public static final Ka.j j(InterfaceC0803h it) {
        kotlin.jvm.internal.p.i(it, "it");
        List<b0> typeParameters = ((kotlin.reflect.jvm.internal.impl.descriptors.a) it).getTypeParameters();
        kotlin.jvm.internal.p.h(typeParameters, "getTypeParameters(...)");
        return Z8.F.d0(typeParameters);
    }
}
