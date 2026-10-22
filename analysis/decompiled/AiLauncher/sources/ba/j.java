package ba;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import ua.InterfaceC5637w;
import ya.AbstractC5990d0;
import ya.S;
import ya.V;

/* loaded from: classes5.dex */
public final class j implements InterfaceC5637w {

    /* renamed from: a, reason: collision with root package name */
    public static final j f15335a = new j();

    @Override // ua.InterfaceC5637w
    public S a(ProtoBuf$Type proto, String flexibleId, AbstractC5990d0 lowerBound, AbstractC5990d0 upperBound) {
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(flexibleId, "flexibleId");
        kotlin.jvm.internal.p.i(lowerBound, "lowerBound");
        kotlin.jvm.internal.p.i(upperBound, "upperBound");
        return !kotlin.jvm.internal.p.d(flexibleId, "kotlin.jvm.PlatformType") ? Aa.i.d(ErrorTypeKind.ERROR_FLEXIBLE_TYPE, flexibleId, lowerBound.toString(), upperBound.toString()) : proto.v(JvmProtoBuf.f35744g) ? new X9.j(lowerBound, upperBound) : V.e(lowerBound, upperBound);
    }
}
