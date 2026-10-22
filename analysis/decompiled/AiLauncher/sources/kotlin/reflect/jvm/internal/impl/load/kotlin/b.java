package kotlin.reflect.jvm.internal.impl.load.kotlin;

import ea.InterfaceC4020d;
import ea.h;
import fa.AbstractC4067d;
import fa.C4071h;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.load.kotlin.g;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* loaded from: classes5.dex */
public final class b {
    public static final g a(ProtoBuf$Property proto, InterfaceC4020d nameResolver, h typeTable, boolean z10, boolean z11, boolean z12) {
        p.i(proto, "proto");
        p.i(nameResolver, "nameResolver");
        p.i(typeTable, "typeTable");
        GeneratedMessageLite.e<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.f35741d;
        p.h(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ea.f.a(proto, propertySignature);
        if (jvmPropertySignature == null) {
            return null;
        }
        if (z10) {
            AbstractC4067d.a aVarC = C4071h.f32594a.c(proto, nameResolver, typeTable, z12);
            if (aVarC == null) {
                return null;
            }
            return g.f35201b.b(aVarC);
        }
        if (!z11 || !jvmPropertySignature.H()) {
            return null;
        }
        g.a aVar = g.f35201b;
        JvmProtoBuf.JvmMethodSignature jvmMethodSignatureC = jvmPropertySignature.C();
        p.h(jvmMethodSignatureC, "getSyntheticMethod(...)");
        return aVar.c(nameResolver, jvmMethodSignatureC);
    }

    public static /* synthetic */ g b(ProtoBuf$Property protoBuf$Property, InterfaceC4020d interfaceC4020d, h hVar, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        if ((i10 & 16) != 0) {
            z11 = false;
        }
        if ((i10 & 32) != 0) {
            z12 = true;
        }
        return a(protoBuf$Property, interfaceC4020d, hVar, z10, z11, z12);
    }
}
