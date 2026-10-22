package R9;

import N9.l;
import N9.o;
import N9.q;
import N9.r;
import N9.s;
import N9.u;
import P9.i;
import P9.j;
import P9.k;
import P9.n;
import fa.AbstractC4067d;
import fa.C4071h;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* loaded from: classes5.dex */
public final class e implements n {
    @Override // P9.n
    public i a() {
        return null;
    }

    @Override // P9.n
    public P9.d b() {
        return null;
    }

    @Override // P9.n
    public void c(N9.g kmConstructor, ProtoBuf$Constructor proto, O9.d c10) {
        p.i(kmConstructor, "kmConstructor");
        p.i(proto, "proto");
        p.i(c10, "c");
        b bVarB = c.b(kmConstructor);
        List<ProtoBuf$Annotation> listN = proto.N();
        p.h(listN, "getAnnotationList(...)");
        List<N9.b> listA = kmConstructor.a();
        for (ProtoBuf$Annotation protoBuf$Annotation : listN) {
            p.f(protoBuf$Annotation);
            listA.add(O9.e.b(protoBuf$Annotation, c10.e()));
        }
        AbstractC4067d.b bVarB2 = C4071h.f32594a.b(proto, c10.e(), c10.g());
        bVarB.a(bVarB2 != null ? Q9.c.b(bVarB2) : null);
    }

    @Override // P9.n
    public void d(u kmValueParameter, ProtoBuf$ValueParameter proto, O9.d c10) {
        p.i(kmValueParameter, "kmValueParameter");
        p.i(proto, "proto");
        p.i(c10, "c");
        List<ProtoBuf$Annotation> listN = proto.N();
        p.h(listN, "getAnnotationList(...)");
        List<N9.b> listA = kmValueParameter.a();
        for (ProtoBuf$Annotation protoBuf$Annotation : listN) {
            p.f(protoBuf$Annotation);
            listA.add(O9.e.b(protoBuf$Annotation, c10.e()));
        }
    }

    @Override // P9.n
    public void e(N9.d kmClass, ProtoBuf$Class proto, O9.d c10) {
        String strB;
        p.i(kmClass, "kmClass");
        p.i(proto, "proto");
        p.i(c10, "c");
        a aVarA = c.a(kmClass);
        List<ProtoBuf$Annotation> listQ0 = proto.q0();
        p.h(listQ0, "getAnnotationList(...)");
        List<N9.b> listD = kmClass.d();
        for (ProtoBuf$Annotation protoBuf$Annotation : listQ0) {
            p.f(protoBuf$Annotation);
            listD.add(O9.e.b(protoBuf$Annotation, c10.e()));
        }
        GeneratedMessageLite.e<ProtoBuf$Class, Integer> anonymousObjectOriginName = JvmProtoBuf.f35748k;
        p.h(anonymousObjectOriginName, "anonymousObjectOriginName");
        Integer num = (Integer) ea.f.a(proto, anonymousObjectOriginName);
        if (num != null) {
            aVarA.c(c10.b(num.intValue()));
        }
        for (ProtoBuf$Property protoBuf$Property : (List) proto.s(JvmProtoBuf.f35747j)) {
            List<o> listB = aVarA.b();
            p.f(protoBuf$Property);
            listB.add(O9.f.q(protoBuf$Property, c10));
        }
        GeneratedMessageLite.e<ProtoBuf$Class, Integer> classModuleName = JvmProtoBuf.f35746i;
        p.h(classModuleName, "classModuleName");
        Integer num2 = (Integer) ea.f.a(proto, classModuleName);
        if (num2 == null || (strB = c10.b(num2.intValue())) == null) {
            strB = "main";
        }
        aVarA.e(strB);
        GeneratedMessageLite.e<ProtoBuf$Class, Integer> jvmClassFlags = JvmProtoBuf.f35749l;
        p.h(jvmClassFlags, "jvmClassFlags");
        Integer num3 = (Integer) ea.f.a(proto, jvmClassFlags);
        if (num3 != null) {
            aVarA.d(num3.intValue());
        }
    }

    @Override // P9.n
    public void f(l kmEnumEntry, ProtoBuf$EnumEntry proto, O9.d c10) {
        p.i(kmEnumEntry, "kmEnumEntry");
        p.i(proto, "proto");
        p.i(c10, "c");
        for (ProtoBuf$Annotation protoBuf$Annotation : proto.G()) {
            List<N9.b> listA = kmEnumEntry.a();
            p.f(protoBuf$Annotation);
            listA.add(O9.e.b(protoBuf$Annotation, c10.e()));
        }
    }

    @Override // P9.n
    public P9.b g() {
        return new a();
    }

    @Override // P9.n
    public void h(o kmProperty, ProtoBuf$Property proto, O9.d c10) {
        p.i(kmProperty, "kmProperty");
        p.i(proto, "proto");
        p.i(c10, "c");
        f fVarD = c.d(kmProperty);
        List<ProtoBuf$Annotation> listM0 = proto.m0();
        p.h(listM0, "getAnnotationList(...)");
        List<N9.b> listA = kmProperty.a();
        for (ProtoBuf$Annotation protoBuf$Annotation : listM0) {
            p.f(protoBuf$Annotation);
            listA.add(O9.e.b(protoBuf$Annotation, c10.e()));
        }
        List<ProtoBuf$Annotation> listK0 = proto.K0();
        p.h(listK0, "getGetterAnnotationList(...)");
        List<N9.b> listA2 = kmProperty.h().a();
        for (ProtoBuf$Annotation protoBuf$Annotation2 : listK0) {
            p.f(protoBuf$Annotation2);
            listA2.add(O9.e.b(protoBuf$Annotation2, c10.e()));
        }
        N9.p pVarI = kmProperty.i();
        if (pVarI != null) {
            List<ProtoBuf$Annotation> listU0 = proto.U0();
            p.h(listU0, "getSetterAnnotationList(...)");
            List<N9.b> listA3 = pVarI.a();
            for (ProtoBuf$Annotation protoBuf$Annotation3 : listU0) {
                p.f(protoBuf$Annotation3);
                listA3.add(O9.e.b(protoBuf$Annotation3, c10.e()));
            }
        }
        List<ProtoBuf$Annotation> listG0 = proto.G0();
        p.h(listG0, "getExtensionReceiverAnnotationList(...)");
        List<N9.b> listE = kmProperty.e();
        for (ProtoBuf$Annotation protoBuf$Annotation4 : listG0) {
            p.f(protoBuf$Annotation4);
            listE.add(O9.e.b(protoBuf$Annotation4, c10.e()));
        }
        List<ProtoBuf$Annotation> listP0 = proto.p0();
        p.h(listP0, "getBackingFieldAnnotationList(...)");
        List<N9.b> listB = kmProperty.b();
        for (ProtoBuf$Annotation protoBuf$Annotation5 : listP0) {
            p.f(protoBuf$Annotation5);
            listB.add(O9.e.b(protoBuf$Annotation5, c10.e()));
        }
        List<ProtoBuf$Annotation> listD0 = proto.D0();
        p.h(listD0, "getDelegateFieldAnnotationList(...)");
        List<N9.b> listD = kmProperty.d();
        for (ProtoBuf$Annotation protoBuf$Annotation6 : listD0) {
            p.f(protoBuf$Annotation6);
            listD.add(O9.e.b(protoBuf$Annotation6, c10.e()));
        }
        AbstractC4067d.a aVarD = C4071h.d(C4071h.f32594a, proto, c10.e(), c10.g(), false, 8, null);
        GeneratedMessageLite.e<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.f35741d;
        p.h(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ea.f.a(proto, propertySignature);
        JvmProtoBuf.JvmMethodSignature jvmMethodSignatureZ = (jvmPropertySignature == null || !jvmPropertySignature.F()) ? null : jvmPropertySignature.z();
        JvmProtoBuf.JvmMethodSignature jvmMethodSignatureA = (jvmPropertySignature == null || !jvmPropertySignature.G()) ? null : jvmPropertySignature.A();
        Object objS = proto.s(JvmProtoBuf.f35742e);
        p.h(objS, "getExtension(...)");
        fVarD.c(((Number) objS).intValue());
        fVarD.a(aVarD != null ? Q9.c.a(aVarD) : null);
        fVarD.b(jvmMethodSignatureZ != null ? new Q9.d(c10.b(jvmMethodSignatureZ.v()), c10.b(jvmMethodSignatureZ.u())) : null);
        fVarD.d(jvmMethodSignatureA != null ? new Q9.d(c10.b(jvmMethodSignatureA.v()), c10.b(jvmMethodSignatureA.u())) : null);
        JvmProtoBuf.JvmMethodSignature jvmMethodSignatureC = (jvmPropertySignature == null || !jvmPropertySignature.H()) ? null : jvmPropertySignature.C();
        fVarD.e(jvmMethodSignatureC != null ? new Q9.d(c10.b(jvmMethodSignatureC.v()), c10.b(jvmMethodSignatureC.u())) : null);
        JvmProtoBuf.JvmMethodSignature jvmMethodSignatureX = (jvmPropertySignature == null || !jvmPropertySignature.D()) ? null : jvmPropertySignature.x();
        fVarD.f(jvmMethodSignatureX != null ? new Q9.d(c10.b(jvmMethodSignatureX.v()), c10.b(jvmMethodSignatureX.u())) : null);
    }

    @Override // P9.n
    public P9.c i() {
        return new b();
    }

    @Override // P9.n
    public P9.h j() {
        return new f();
    }

    @Override // P9.n
    public void k(q kmType, ProtoBuf$Type proto, O9.d c10) {
        p.i(kmType, "kmType");
        p.i(proto, "proto");
        p.i(c10, "c");
        g gVarE = c.e(kmType);
        Object objS = proto.s(JvmProtoBuf.f35744g);
        p.h(objS, "getExtension(...)");
        gVarE.b(((Boolean) objS).booleanValue());
        for (ProtoBuf$Annotation protoBuf$Annotation : (List) proto.s(JvmProtoBuf.f35743f)) {
            List<N9.b> listA = gVarE.a();
            p.f(protoBuf$Annotation);
            listA.add(O9.e.b(protoBuf$Annotation, c10.e()));
        }
    }

    @Override // P9.n
    public j l() {
        return new g();
    }

    @Override // P9.n
    public void m(N9.n kmFunction, ProtoBuf$Function proto, O9.d c10) {
        p.i(kmFunction, "kmFunction");
        p.i(proto, "proto");
        p.i(c10, "c");
        d dVarC = c.c(kmFunction);
        List<ProtoBuf$Annotation> listF0 = proto.f0();
        p.h(listF0, "getAnnotationList(...)");
        List<N9.b> listA = kmFunction.a();
        for (ProtoBuf$Annotation protoBuf$Annotation : listF0) {
            p.f(protoBuf$Annotation);
            listA.add(O9.e.b(protoBuf$Annotation, c10.e()));
        }
        List<ProtoBuf$Annotation> listU0 = proto.u0();
        p.h(listU0, "getExtensionReceiverAnnotationList(...)");
        List<N9.b> listC = kmFunction.c();
        for (ProtoBuf$Annotation protoBuf$Annotation2 : listU0) {
            p.f(protoBuf$Annotation2);
            listC.add(O9.e.b(protoBuf$Annotation2, c10.e()));
        }
        AbstractC4067d.b bVarE = C4071h.f32594a.e(proto, c10.e(), c10.g());
        dVarC.b(bVarE != null ? Q9.c.b(bVarE) : null);
        GeneratedMessageLite.e<ProtoBuf$Function, Integer> lambdaClassOriginName = JvmProtoBuf.f35740c;
        p.h(lambdaClassOriginName, "lambdaClassOriginName");
        Integer num = (Integer) ea.f.a(proto, lambdaClassOriginName);
        if (num != null) {
            dVarC.a(c10.b(num.intValue()));
        }
    }

    @Override // P9.n
    public void n(s kmTypeParameter, ProtoBuf$TypeParameter proto, O9.d c10) {
        p.i(kmTypeParameter, "kmTypeParameter");
        p.i(proto, "proto");
        p.i(c10, "c");
        h hVarF = c.f(kmTypeParameter);
        for (ProtoBuf$Annotation protoBuf$Annotation : (List) proto.s(JvmProtoBuf.f35745h)) {
            List<N9.b> listA = hVarF.a();
            p.f(protoBuf$Annotation);
            listA.add(O9.e.b(protoBuf$Annotation, c10.e()));
        }
    }

    @Override // P9.n
    public void o(r kmTypeAlias, ProtoBuf$TypeAlias proto, O9.d c10) {
        p.i(kmTypeAlias, "kmTypeAlias");
        p.i(proto, "proto");
        p.i(c10, "c");
    }

    @Override // P9.n
    public P9.g p() {
        return new d();
    }

    @Override // P9.n
    public k q() {
        return new h();
    }

    @Override // P9.n
    public P9.l r() {
        return null;
    }
}
