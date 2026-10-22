package kotlin.reflect.jvm.internal.impl.descriptors;

import D7.v;
import G8.b;
import G8.f;
import J8.m;
import Q8.o;
import h8.C1534q;
import h8.InterfaceC1498F;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1540w;
import java.util.List;
import k8.w;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import u1.d;

/* loaded from: classes4.dex */
public abstract class a {
    public static final InterfaceC1522e a(InterfaceC1540w interfaceC1540w, b classId) {
        k.f(interfaceC1540w, "<this>");
        k.f(classId, "classId");
        InterfaceC1524g interfaceC1524gB = b(interfaceC1540w, classId);
        if (interfaceC1524gB instanceof InterfaceC1522e) {
            return (InterfaceC1522e) interfaceC1524gB;
        }
        return null;
    }

    public static final InterfaceC1524g b(InterfaceC1540w interfaceC1540w, b classId) {
        k.f(interfaceC1540w, "<this>");
        k.f(classId, "classId");
        if (interfaceC1540w.z(m.f889a) != null) {
            throw new ClassCastException();
        }
        InterfaceC1498F interfaceC1498FV = interfaceC1540w.V(classId.f687a);
        List listE = classId.b.f688a.e();
        Q8.k kVar = ((w) interfaceC1498FV).g;
        Object objA0 = v.A0(listE);
        k.e(objA0, "first(...)");
        InterfaceC1524g interfaceC1524gB = kVar.b((f) objA0, NoLookupLocation.g);
        if (interfaceC1524gB != null) {
            for (f fVar : listE.subList(1, listE.size())) {
                if (interfaceC1524gB instanceof InterfaceC1522e) {
                    o oVarO = ((InterfaceC1522e) interfaceC1524gB).O();
                    k.c(fVar);
                    InterfaceC1524g interfaceC1524gB2 = oVarO.b(fVar, NoLookupLocation.g);
                    interfaceC1524gB = interfaceC1524gB2 instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1524gB2 : null;
                    if (interfaceC1524gB != null) {
                    }
                }
            }
            return interfaceC1524gB;
        }
        return null;
    }

    public static final InterfaceC1522e c(InterfaceC1540w interfaceC1540w, b classId, d notFoundClasses) {
        k.f(interfaceC1540w, "<this>");
        k.f(classId, "classId");
        k.f(notFoundClasses, "notFoundClasses");
        InterfaceC1522e interfaceC1522eA = a(interfaceC1540w, classId);
        return interfaceC1522eA != null ? interfaceC1522eA : notFoundClasses.S(classId, kotlin.sequences.a.o0(kotlin.sequences.a.m0(kotlin.sequences.a.k0(new PropertyReference1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1
            @Override // Z7.s
            public final Object get(Object obj) {
                return ((b) obj).e();
            }

            @Override // kotlin.jvm.internal.CallableReference, Z7.c
            public final String getName() {
                return "outerClassId";
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final Z7.f getOwner() {
                return kotlin.jvm.internal.m.f4928a.b(b.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final String getSignature() {
                return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
            }
        }, classId), C1534q.b)));
    }
}
