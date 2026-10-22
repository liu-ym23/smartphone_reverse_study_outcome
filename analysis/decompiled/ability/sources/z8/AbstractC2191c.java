package z8;

import a.AbstractC0291a;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature;

/* renamed from: z8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2191c {
    public static final r a(ProtoBuf$Property proto, D8.f nameResolver, D8.j jVar, boolean z10, boolean z11, boolean z12) {
        kotlin.jvm.internal.k.f(proto, "proto");
        kotlin.jvm.internal.k.f(nameResolver, "nameResolver");
        H8.l propertySignature = E8.c.d;
        kotlin.jvm.internal.k.e(propertySignature, "propertySignature");
        JvmProtoBuf$JvmPropertySignature jvmProtoBuf$JvmPropertySignature = (JvmProtoBuf$JvmPropertySignature) D8.h.a(proto, propertySignature);
        if (jvmProtoBuf$JvmPropertySignature != null) {
            if (z10) {
                H8.h hVar = F8.i.f596a;
                F8.d dVarB = F8.i.b(proto, nameResolver, jVar, z12);
                if (dVarB != null) {
                    return AbstractC0291a.t(dVarB);
                }
            } else if (z11 && (jvmProtoBuf$JvmPropertySignature.b & 2) == 2) {
                JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature = jvmProtoBuf$JvmPropertySignature.d;
                kotlin.jvm.internal.k.e(jvmProtoBuf$JvmMethodSignature, "getSyntheticMethod(...)");
                return new r(nameResolver.getString(jvmProtoBuf$JvmMethodSignature.c).concat(nameResolver.getString(jvmProtoBuf$JvmMethodSignature.d)));
            }
        }
        return null;
    }
}
