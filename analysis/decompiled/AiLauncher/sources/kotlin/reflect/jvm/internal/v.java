package kotlin.reflect.jvm.internal;

import C9.o;
import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.O;
import E9.P;
import E9.Q;
import E9.W;
import K9.C0925f;
import K9.y;
import La.D;
import La.H;
import S9.E;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import fa.AbstractC4067d;
import fa.C4071h;
import java.lang.reflect.Method;
import ka.C4827g;
import ka.C4828h;
import ka.C4829i;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.b;
import kotlin.reflect.jvm.internal.c;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import wa.C5770L;
import wa.InterfaceC5778b;
import wa.InterfaceC5794r;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00102\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001eR\u001e\u0010#\u001a\u0004\u0018\u00010 *\u0006\u0012\u0002\b\u00030\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lkotlin/reflect/jvm/internal/v;", "", "<init>", "()V", "Lkotlin/reflect/jvm/internal/impl/descriptors/e;", "possiblySubstitutedFunction", "Lkotlin/reflect/jvm/internal/b;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lkotlin/reflect/jvm/internal/impl/descriptors/e;)Lkotlin/reflect/jvm/internal/b;", "LE9/O;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/c;", "f", "(LE9/O;)Lkotlin/reflect/jvm/internal/c;", "Ljava/lang/Class;", "klass", "Lga/b;", "c", "(Ljava/lang/Class;)Lga/b;", "descriptor", "", Const.INTENT_KEY_PKGNAME, "(Lkotlin/reflect/jvm/internal/impl/descriptors/e;)Z", "Lkotlin/reflect/jvm/internal/b$e;", Const.INTENT_KEY_UMID, "(Lkotlin/reflect/jvm/internal/impl/descriptors/e;)Lkotlin/reflect/jvm/internal/b$e;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "", "e", "(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;)Ljava/lang/String;", "Lga/b;", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "primitiveType", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final v f36168a = new v();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final ga.b JAVA_LANG_VOID = ga.b.f32721d.c(new ga.c("java.lang.Void"));

    public final PrimitiveType a(Class<?> cls) {
        if (cls.isPrimitive()) {
            return JvmPrimitiveType.get(cls.getSimpleName()).getPrimitiveType();
        }
        return null;
    }

    public final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.e descriptor) {
        if (C4827g.p(descriptor) || C4827g.q(descriptor)) {
            return true;
        }
        return kotlin.jvm.internal.p.d(descriptor.getName(), kotlin.reflect.jvm.internal.impl.builtins.jvm.a.f34997e.a()) && descriptor.i().isEmpty();
    }

    public final ga.b c(Class<?> klass) {
        ga.b bVarM;
        kotlin.jvm.internal.p.i(klass, "klass");
        if (klass.isArray()) {
            Class<?> componentType = klass.getComponentType();
            kotlin.jvm.internal.p.h(componentType, "getComponentType(...)");
            PrimitiveType primitiveTypeA = a(componentType);
            return primitiveTypeA != null ? new ga.b(C9.o.f1810B, primitiveTypeA.getArrayTypeName()) : ga.b.f32721d.c(o.a.f1910i.m());
        }
        if (kotlin.jvm.internal.p.d(klass, Void.TYPE)) {
            return JAVA_LANG_VOID;
        }
        PrimitiveType primitiveTypeA2 = a(klass);
        if (primitiveTypeA2 != null) {
            return new ga.b(C9.o.f1810B, primitiveTypeA2.getTypeName());
        }
        ga.b bVarE = C0925f.e(klass);
        return (bVarE.i() || (bVarM = D9.a.f2270a.m(bVarE.a())) == null) ? bVarE : bVarM;
    }

    public final b.e d(kotlin.reflect.jvm.internal.impl.descriptors.e descriptor) {
        return new b.e(new AbstractC4067d.b(e(descriptor), ba.u.c(descriptor, false, false, 1, null)));
    }

    public final String e(CallableMemberDescriptor descriptor) {
        String strE = kotlin.reflect.jvm.internal.impl.load.java.d.e(descriptor);
        if (strE != null) {
            return strE;
        }
        if (descriptor instanceof P) {
            String strB = DescriptorUtilsKt.w(descriptor).getName().b();
            kotlin.jvm.internal.p.h(strB, "asString(...)");
            return E.b(strB);
        }
        if (descriptor instanceof Q) {
            String strB2 = DescriptorUtilsKt.w(descriptor).getName().b();
            kotlin.jvm.internal.p.h(strB2, "asString(...)");
            return E.e(strB2);
        }
        String strB3 = descriptor.getName().b();
        kotlin.jvm.internal.p.h(strB3, "asString(...)");
        return strB3;
    }

    public final c f(O possiblyOverriddenProperty) {
        kotlin.jvm.internal.p.i(possiblyOverriddenProperty, "possiblyOverriddenProperty");
        O oA = ((O) C4828h.L(possiblyOverriddenProperty)).a();
        kotlin.jvm.internal.p.h(oA, "getOriginal(...)");
        if (oA instanceof C5770L) {
            C5770L c5770l = (C5770L) oA;
            ProtoBuf$Property protoBuf$PropertyZ0 = c5770l.a0();
            GeneratedMessageLite.e<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.f35741d;
            kotlin.jvm.internal.p.h(propertySignature, "propertySignature");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ea.f.a(protoBuf$PropertyZ0, propertySignature);
            if (jvmPropertySignature != null) {
                return new c.C0434c(oA, protoBuf$PropertyZ0, jvmPropertySignature, c5770l.F(), c5770l.C());
            }
        } else if (oA instanceof U9.e) {
            U9.e eVar = (U9.e) oA;
            W wE = eVar.e();
            Y9.a aVar = wE instanceof Y9.a ? (Y9.a) wE : null;
            Z9.l lVarC = aVar != null ? aVar.c() : null;
            if (lVarC instanceof K9.v) {
                return new c.a(((K9.v) lVarC).N());
            }
            if (lVarC instanceof y) {
                Method methodN = ((y) lVarC).N();
                Q setter = eVar.getSetter();
                W wE2 = setter != null ? setter.e() : null;
                Y9.a aVar2 = wE2 instanceof Y9.a ? (Y9.a) wE2 : null;
                Z9.l lVarC2 = aVar2 != null ? aVar2.c() : null;
                y yVar = lVarC2 instanceof y ? (y) lVarC2 : null;
                return new c.b(methodN, yVar != null ? yVar.N() : null);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + oA + " (source = " + lVarC + ')');
        }
        P getter = oA.getGetter();
        kotlin.jvm.internal.p.f(getter);
        b.e eVarD = d(getter);
        Q setter2 = oA.getSetter();
        return new c.d(eVarD, setter2 != null ? d(setter2) : null);
    }

    public final b g(kotlin.reflect.jvm.internal.impl.descriptors.e possiblySubstitutedFunction) {
        Method methodN;
        AbstractC4067d.b bVarB;
        AbstractC4067d.b bVarE;
        kotlin.jvm.internal.p.i(possiblySubstitutedFunction, "possiblySubstitutedFunction");
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarA = ((kotlin.reflect.jvm.internal.impl.descriptors.e) C4828h.L(possiblySubstitutedFunction)).a();
        kotlin.jvm.internal.p.h(eVarA, "getOriginal(...)");
        if (!(eVarA instanceof InterfaceC5778b)) {
            if (eVarA instanceof JavaMethodDescriptor) {
                W wE = ((JavaMethodDescriptor) eVarA).e();
                Y9.a aVar = wE instanceof Y9.a ? (Y9.a) wE : null;
                Z9.l lVarC = aVar != null ? aVar.c() : null;
                y yVar = lVarC instanceof y ? (y) lVarC : null;
                if (yVar != null && (methodN = yVar.N()) != null) {
                    return new b.c(methodN);
                }
                throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + eVarA);
            }
            if (!(eVarA instanceof U9.b)) {
                if (b(eVarA)) {
                    return d(eVarA);
                }
                throw new KotlinReflectionInternalError("Unknown origin of " + eVarA + " (" + eVarA.getClass() + ')');
            }
            W wE2 = ((U9.b) eVarA).e();
            Y9.a aVar2 = wE2 instanceof Y9.a ? (Y9.a) wE2 : null;
            Z9.l lVarC2 = aVar2 != null ? aVar2.c() : null;
            if (lVarC2 instanceof K9.s) {
                return new b.C0433b(((K9.s) lVarC2).N());
            }
            if (lVarC2 instanceof ReflectJavaClass) {
                ReflectJavaClass reflectJavaClass = (ReflectJavaClass) lVarC2;
                if (reflectJavaClass.o()) {
                    return new b.a(reflectJavaClass.s());
                }
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + eVarA + " (" + lVarC2 + ')');
        }
        InterfaceC5794r interfaceC5794r = (InterfaceC5794r) eVarA;
        kotlin.reflect.jvm.internal.impl.protobuf.h hVarA0 = interfaceC5794r.a0();
        if ((hVarA0 instanceof ProtoBuf$Function) && (bVarE = C4071h.f32594a.e((ProtoBuf$Function) hVarA0, interfaceC5794r.F(), interfaceC5794r.C())) != null) {
            return new b.e(bVarE);
        }
        if (!(hVarA0 instanceof ProtoBuf$Constructor) || (bVarB = C4071h.f32594a.b((ProtoBuf$Constructor) hVarA0, interfaceC5794r.F(), interfaceC5794r.C())) == null) {
            return d(eVarA);
        }
        InterfaceC0803h interfaceC0803hB = possiblySubstitutedFunction.b();
        kotlin.jvm.internal.p.h(interfaceC0803hB, "getContainingDeclaration(...)");
        if (C4829i.b(interfaceC0803hB)) {
            return new b.e(bVarB);
        }
        InterfaceC0803h interfaceC0803hB2 = possiblySubstitutedFunction.b();
        kotlin.jvm.internal.p.h(interfaceC0803hB2, "getContainingDeclaration(...)");
        if (!C4829i.d(interfaceC0803hB2)) {
            return new b.d(bVarB);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.c cVar = (kotlin.reflect.jvm.internal.impl.descriptors.c) possiblySubstitutedFunction;
        if (cVar.X()) {
            if (!kotlin.jvm.internal.p.d(bVarB.e(), "constructor-impl") || !D.K(bVarB.d(), ")V", false, 2, null)) {
                throw new IllegalArgumentException(("Invalid signature: " + bVarB).toString());
            }
        } else {
            if (!kotlin.jvm.internal.p.d(bVarB.e(), "constructor-impl")) {
                throw new IllegalArgumentException(("Invalid signature: " + bVarB).toString());
            }
            InterfaceC0797b interfaceC0797bY = cVar.Y();
            kotlin.jvm.internal.p.h(interfaceC0797bY, "getConstructedClass(...)");
            String strU = A9.n.u(interfaceC0797bY);
            if (D.K(bVarB.d(), ")V", false, 2, null)) {
                bVarB = AbstractC4067d.b.c(bVarB, null, H.T0(bVarB.d(), ExifInterface.GPS_MEASUREMENT_INTERRUPTED) + strU, 1, null);
            } else if (!D.K(bVarB.d(), strU, false, 2, null)) {
                throw new IllegalArgumentException(("Invalid signature: " + bVarB).toString());
            }
        }
        return new b.e(bVarB);
    }
}
