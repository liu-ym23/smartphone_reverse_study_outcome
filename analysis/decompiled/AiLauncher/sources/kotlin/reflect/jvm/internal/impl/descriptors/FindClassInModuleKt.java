package kotlin.reflect.jvm.internal.impl.descriptors;

import E9.D;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0819y;
import E9.L;
import E9.a0;
import E9.r;
import Ka.t;
import Z8.F;
import java.util.List;
import ka.C4837q;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes5.dex */
public final class FindClassInModuleKt {
    public static final InterfaceC0797b b(InterfaceC0819y interfaceC0819y, ga.b classId) {
        p.i(interfaceC0819y, "<this>");
        p.i(classId, "classId");
        InterfaceC0799d interfaceC0799dC = c(interfaceC0819y, classId);
        if (interfaceC0799dC instanceof InterfaceC0797b) {
            return (InterfaceC0797b) interfaceC0799dC;
        }
        return null;
    }

    public static final InterfaceC0799d c(InterfaceC0819y interfaceC0819y, ga.b classId) {
        p.i(interfaceC0819y, "<this>");
        p.i(classId, "classId");
        InterfaceC0819y interfaceC0819yA = C4837q.a(interfaceC0819y);
        if (interfaceC0819yA == null) {
            L lF0 = interfaceC0819y.f0(classId.f());
            List<ga.e> listE = classId.g().e();
            InterfaceC0799d interfaceC0799dD = lF0.m().d((ga.e) F.q0(listE), NoLookupLocation.FROM_DESERIALIZATION);
            if (interfaceC0799dD == null) {
                return null;
            }
            for (ga.e eVar : listE.subList(1, listE.size())) {
                if (!(interfaceC0799dD instanceof InterfaceC0797b)) {
                    return null;
                }
                InterfaceC0799d interfaceC0799dD2 = ((InterfaceC0797b) interfaceC0799dD).O().d(eVar, NoLookupLocation.FROM_DESERIALIZATION);
                interfaceC0799dD = interfaceC0799dD2 instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD2 : null;
                if (interfaceC0799dD == null) {
                    return null;
                }
            }
            return interfaceC0799dD;
        }
        L lF02 = interfaceC0819yA.f0(classId.f());
        List<ga.e> listE2 = classId.g().e();
        InterfaceC0799d interfaceC0799dD3 = lF02.m().d((ga.e) F.q0(listE2), NoLookupLocation.FROM_DESERIALIZATION);
        if (interfaceC0799dD3 == null) {
            interfaceC0799dD3 = null;
            break;
        }
        for (ga.e eVar2 : listE2.subList(1, listE2.size())) {
            if (interfaceC0799dD3 instanceof InterfaceC0797b) {
                InterfaceC0799d interfaceC0799dD4 = ((InterfaceC0797b) interfaceC0799dD3).O().d(eVar2, NoLookupLocation.FROM_DESERIALIZATION);
                interfaceC0799dD3 = interfaceC0799dD4 instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD4 : null;
                if (interfaceC0799dD3 != null) {
                }
            }
            interfaceC0799dD3 = null;
        }
        if (interfaceC0799dD3 != null) {
            return interfaceC0799dD3;
        }
        L lF03 = interfaceC0819y.f0(classId.f());
        List<ga.e> listE3 = classId.g().e();
        InterfaceC0799d interfaceC0799dD5 = lF03.m().d((ga.e) F.q0(listE3), NoLookupLocation.FROM_DESERIALIZATION);
        if (interfaceC0799dD5 == null) {
            return null;
        }
        for (ga.e eVar3 : listE3.subList(1, listE3.size())) {
            if (!(interfaceC0799dD5 instanceof InterfaceC0797b)) {
                return null;
            }
            InterfaceC0799d interfaceC0799dD6 = ((InterfaceC0797b) interfaceC0799dD5).O().d(eVar3, NoLookupLocation.FROM_DESERIALIZATION);
            interfaceC0799dD5 = interfaceC0799dD6 instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD6 : null;
            if (interfaceC0799dD5 == null) {
                return null;
            }
        }
        return interfaceC0799dD5;
    }

    public static final InterfaceC0797b d(InterfaceC0819y interfaceC0819y, ga.b classId, D notFoundClasses) {
        p.i(interfaceC0819y, "<this>");
        p.i(classId, "classId");
        p.i(notFoundClasses, "notFoundClasses");
        InterfaceC0797b interfaceC0797bB = b(interfaceC0819y, classId);
        return interfaceC0797bB != null ? interfaceC0797bB : notFoundClasses.d(classId, SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.R(t.q(classId, new PropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return ((ga.b) obj).e();
            }
        }), r.f2486a)));
    }

    public static final int e(ga.b it) {
        p.i(it, "it");
        return 0;
    }

    public static final a0 f(InterfaceC0819y interfaceC0819y, ga.b classId) {
        p.i(interfaceC0819y, "<this>");
        p.i(classId, "classId");
        InterfaceC0799d interfaceC0799dC = c(interfaceC0819y, classId);
        if (interfaceC0799dC instanceof a0) {
            return (a0) interfaceC0799dC;
        }
        return null;
    }
}
