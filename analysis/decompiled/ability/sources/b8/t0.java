package b8;

import H8.AbstractC0241b;
import androidx.exifinterface.media.ExifInterface;
import g8.C1465a;
import h8.InterfaceC1501I;
import h8.InterfaceC1503K;
import h8.InterfaceC1522e;
import h8.InterfaceC1526i;
import h8.InterfaceC1527j;
import h8.InterfaceC1536s;
import java.lang.reflect.Method;
import k8.AbstractC1644m;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature;
import q8.AbstractC1847t;

/* loaded from: classes4.dex */
public abstract class t0 {

    /* renamed from: a, reason: collision with root package name */
    public static final G8.b f2056a;

    static {
        G8.c cVar = new G8.c("java.lang.Void");
        G8.c cVarE = cVar.e();
        G8.f fVarF = cVar.f();
        kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
        f2056a = new G8.b(cVarE, fVarF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static C0850k a(InterfaceC1536s interfaceC1536s) {
        String strY0 = S0.b.Y0(interfaceC1536s);
        if (strY0 == null) {
            if (interfaceC1536s instanceof k8.I) {
                String strB = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.k(interfaceC1536s).getName().b();
                kotlin.jvm.internal.k.e(strB, "asString(...)");
                strY0 = AbstractC1847t.a(strB);
            } else if (interfaceC1536s instanceof k8.J) {
                String strB2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.k(interfaceC1536s).getName().b();
                kotlin.jvm.internal.k.e(strB2, "asString(...)");
                strY0 = AbstractC1847t.b(strB2);
            } else {
                strY0 = ((AbstractC1644m) interfaceC1536s).getName().b();
                kotlin.jvm.internal.k.e(strY0, "asString(...)");
            }
        }
        return new C0850k(new F8.e(strY0, com.stepos.ability.task.executor.e.t(interfaceC1536s, 1)));
    }

    public static M0.i b(InterfaceC1501I possiblyOverriddenProperty) {
        kotlin.jvm.internal.k.f(possiblyOverriddenProperty, "possiblyOverriddenProperty");
        InterfaceC1501I interfaceC1501IA = ((InterfaceC1501I) J8.e.t(possiblyOverriddenProperty)).a();
        kotlin.jvm.internal.k.e(interfaceC1501IA, "getOriginal(...)");
        if (interfaceC1501IA instanceof V8.r) {
            V8.r rVar = (V8.r) interfaceC1501IA;
            ProtoBuf$Property protoBuf$Property = rVar.f1402A;
            H8.l propertySignature = E8.c.d;
            kotlin.jvm.internal.k.e(propertySignature, "propertySignature");
            JvmProtoBuf$JvmPropertySignature jvmProtoBuf$JvmPropertySignature = (JvmProtoBuf$JvmPropertySignature) D8.h.a(protoBuf$Property, propertySignature);
            if (jvmProtoBuf$JvmPropertySignature != null) {
                return new C0853n(interfaceC1501IA, protoBuf$Property, jvmProtoBuf$JvmPropertySignature, rVar.f1403B, rVar.f1404C);
            }
        } else if (interfaceC1501IA instanceof s8.e) {
            s8.e eVar = (s8.e) interfaceC1501IA;
            InterfaceC1503K source = eVar.getSource();
            m8.f fVar = source instanceof m8.f ? (m8.f) source : null;
            n8.l lVar = fVar != null ? fVar.f5310a : null;
            if (lVar instanceof n8.n) {
                return new C0851l(((n8.n) lVar).f5361a);
            }
            if (!(lVar instanceof n8.q)) {
                throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + interfaceC1501IA + " (source = " + lVar + ')');
            }
            Method method = ((n8.q) lVar).f5362a;
            k8.J j5 = eVar.f4837x;
            InterfaceC1503K source2 = j5 != null ? j5.getSource() : null;
            m8.f fVar2 = source2 instanceof m8.f ? (m8.f) source2 : null;
            n8.l lVar2 = fVar2 != null ? fVar2.f5310a : null;
            n8.q qVar = lVar2 instanceof n8.q ? (n8.q) lVar2 : null;
            return new C0852m(method, qVar != null ? qVar.f5362a : null);
        }
        k8.I getter = interfaceC1501IA.getGetter();
        kotlin.jvm.internal.k.c(getter);
        C0850k c0850kA = a(getter);
        k8.J setter = interfaceC1501IA.getSetter();
        return new C0854o(c0850kA, setter != null ? a(setter) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static M.a c(InterfaceC1536s possiblySubstitutedFunction) {
        Method method;
        kotlin.jvm.internal.k.f(possiblySubstitutedFunction, "possiblySubstitutedFunction");
        InterfaceC1536s interfaceC1536sA = ((InterfaceC1536s) J8.e.t(possiblySubstitutedFunction)).a();
        kotlin.jvm.internal.k.e(interfaceC1536sA, "getOriginal(...)");
        if (!(interfaceC1536sA instanceof V8.b)) {
            if (interfaceC1536sA instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.a) {
                InterfaceC1503K source = ((kotlin.reflect.jvm.internal.impl.load.java.descriptors.a) interfaceC1536sA).getSource();
                m8.f fVar = source instanceof m8.f ? (m8.f) source : null;
                n8.l lVar = fVar != null ? fVar.f5310a : null;
                n8.q qVar = lVar instanceof n8.q ? (n8.q) lVar : null;
                if (qVar != null && (method = qVar.f5362a) != null) {
                    return new C0848i(method);
                }
                throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + interfaceC1536sA);
            }
            if (!(interfaceC1536sA instanceof s8.b)) {
                AbstractC1644m abstractC1644m = (AbstractC1644m) interfaceC1536sA;
                if ((abstractC1644m.getName().equals(e8.o.c) && J8.m.n(interfaceC1536sA)) || ((abstractC1644m.getName().equals(e8.o.f4426a) && J8.m.n(interfaceC1536sA)) || (kotlin.jvm.internal.k.b(abstractC1644m.getName(), C1465a.e) && interfaceC1536sA.x().isEmpty()))) {
                    return a(interfaceC1536sA);
                }
                throw new KotlinReflectionInternalError("Unknown origin of " + interfaceC1536sA + " (" + interfaceC1536sA.getClass() + ')');
            }
            InterfaceC1503K source2 = ((s8.b) interfaceC1536sA).getSource();
            m8.f fVar2 = source2 instanceof m8.f ? (m8.f) source2 : null;
            Object obj = fVar2 != null ? fVar2.f5310a : null;
            if (obj instanceof n8.k) {
                return new C0847h(((n8.k) obj).f5360a);
            }
            if (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a) {
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a aVar = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a) obj;
                if (aVar.f4985a.isAnnotation()) {
                    return new C0846g(aVar.f4985a);
                }
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + interfaceC1536sA + " (" + obj + ')');
        }
        V8.k kVar = (V8.k) interfaceC1536sA;
        AbstractC0241b abstractC0241bD0 = kVar.d0();
        if (abstractC0241bD0 instanceof ProtoBuf$Function) {
            H8.h hVar = F8.i.f596a;
            F8.e eVarC = F8.i.c((ProtoBuf$Function) abstractC0241bD0, kVar.y(), kVar.v());
            if (eVarC != null) {
                return new C0850k(eVarC);
            }
        }
        if (abstractC0241bD0 instanceof ProtoBuf$Constructor) {
            H8.h hVar2 = F8.i.f596a;
            F8.e eVarA = F8.i.a((ProtoBuf$Constructor) abstractC0241bD0, kVar.y(), kVar.v());
            if (eVarA != null) {
                String name = eVarA.f593q;
                String str = eVarA.f594r;
                InterfaceC1527j interfaceC1527jD = possiblySubstitutedFunction.d();
                kotlin.jvm.internal.k.e(interfaceC1527jD, "getContainingDeclaration(...)");
                if (J8.g.b(interfaceC1527jD)) {
                    return new C0850k(eVarA);
                }
                InterfaceC1527j interfaceC1527jD2 = possiblySubstitutedFunction.d();
                kotlin.jvm.internal.k.e(interfaceC1527jD2, "getContainingDeclaration(...)");
                if (!J8.g.d(interfaceC1527jD2)) {
                    return new C0849j(eVarA);
                }
                InterfaceC1526i interfaceC1526i = (InterfaceC1526i) possiblySubstitutedFunction;
                if (interfaceC1526i.a0()) {
                    if (!kotlin.jvm.internal.k.b(name, "constructor-impl") || !j9.t.W(str, ")V", false)) {
                        throw new IllegalArgumentException(("Invalid signature: " + eVarA).toString());
                    }
                } else {
                    if (!kotlin.jvm.internal.k.b(name, "constructor-impl")) {
                        throw new IllegalArgumentException(("Invalid signature: " + eVarA).toString());
                    }
                    InterfaceC1522e interfaceC1522eB0 = interfaceC1526i.b0();
                    kotlin.jvm.internal.k.e(interfaceC1522eB0, "getConstructedClass(...)");
                    G8.b bVarF = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f(interfaceC1522eB0);
                    kotlin.jvm.internal.k.c(bVarF);
                    String strB = F8.b.b(bVarF.b());
                    if (j9.t.W(str, ")V", false)) {
                        String desc = j9.m.z0(str, ExifInterface.GPS_MEASUREMENT_INTERRUPTED) + strB;
                        kotlin.jvm.internal.k.f(name, "name");
                        kotlin.jvm.internal.k.f(desc, "desc");
                        eVarA = new F8.e(name, desc);
                    } else if (!j9.t.W(str, strB, false)) {
                        throw new IllegalArgumentException(("Invalid signature: " + eVarA).toString());
                    }
                }
                return new C0850k(eVarA);
            }
        }
        return a(interfaceC1536sA);
    }
}
