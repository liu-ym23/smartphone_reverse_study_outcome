package kotlin.reflect.jvm;

import Y8.e;
import com.autonavi.aps.amapapi.config.Const;
import ea.C4019c;
import ea.h;
import fa.C4068e;
import fa.C4071h;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.a;
import kotlin.reflect.jvm.internal.f;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import w9.InterfaceC5748g;
import z9.c1;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"R", "LY8/e;", "Lw9/g;", Const.INTENT_KEY_APIKEY, "(LY8/e;)Lw9/g;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ReflectLambdaKt {
    public static final <R> InterfaceC5748g<R> a(e<? extends R> eVar) {
        p.i(eVar, "<this>");
        Metadata metadata = (Metadata) eVar.getClass().getAnnotation(Metadata.class);
        if (metadata == null) {
            return null;
        }
        String[] strArrD1 = metadata.d1();
        if (strArrD1.length == 0) {
            strArrD1 = null;
        }
        if (strArrD1 == null) {
            return null;
        }
        Pair<C4068e, ProtoBuf$Function> pairJ = C4071h.j(strArrD1, metadata.d2());
        C4068e c4068eA = pairJ.a();
        ProtoBuf$Function protoBuf$FunctionB = pairJ.b();
        C4019c c4019c = new C4019c(metadata.mv(), (metadata.xi() & 8) != 0);
        Class<?> cls = eVar.getClass();
        ProtoBuf$TypeTable protoBuf$TypeTableF0 = protoBuf$FunctionB.F0();
        p.h(protoBuf$TypeTableF0, "getTypeTable(...)");
        return new f(a.f34875d, (g) c1.h(cls, protoBuf$FunctionB, c4068eA, new h(protoBuf$TypeTableF0), c4019c, ReflectLambdaKt$reflect$descriptor$1.f34866a));
    }
}
