package ua;

import E9.C0813s;
import E9.C0820z;
import E9.g0;
import Z8.C1174w;
import ea.C4018b;
import ea.InterfaceC4020d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import p9.InterfaceC5074l;

/* renamed from: ua.Y, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5614Y {
    public static final <T extends Ca.h> g0<T> a(ProtoBuf$Class protoBuf$Class, boolean z10, InterfaceC4020d nameResolver, ea.h typeTable, InterfaceC5074l<? super ProtoBuf$Type, ? extends T> typeDeserializer, InterfaceC5074l<? super ga.e, ? extends T> typeOfPublicProperty) {
        T tInvoke;
        kotlin.jvm.internal.p.i(protoBuf$Class, "<this>");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        kotlin.jvm.internal.p.i(typeTable, "typeTable");
        kotlin.jvm.internal.p.i(typeDeserializer, "typeDeserializer");
        kotlin.jvm.internal.p.i(typeOfPublicProperty, "typeOfPublicProperty");
        if (protoBuf$Class.j1()) {
            ga.e eVarB = C5602L.b(nameResolver, protoBuf$Class.L0());
            ProtoBuf$Type protoBuf$TypeI = ea.g.i(protoBuf$Class, typeTable);
            if ((protoBuf$TypeI != null && (tInvoke = typeDeserializer.invoke(protoBuf$TypeI)) != null) || (tInvoke = typeOfPublicProperty.invoke(eVarB)) != null) {
                return new C0813s(eVarB, tInvoke);
            }
            throw new IllegalStateException(("cannot determine underlying type for value class " + C5602L.b(nameResolver, protoBuf$Class.H0()) + " with property " + eVarB).toString());
        }
        if (!z10 || !C4018b.f32384k.d(protoBuf$Class.G0()).booleanValue()) {
            return null;
        }
        List<ProtoBuf$Constructor> listW0 = protoBuf$Class.w0();
        kotlin.jvm.internal.p.h(listW0, "getConstructorList(...)");
        Iterator<T> it = listW0.iterator();
        boolean z11 = false;
        Object obj = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (!C4018b.f32387n.d(((ProtoBuf$Constructor) next).S()).booleanValue()) {
                    if (z11) {
                        break;
                    }
                    z11 = true;
                    obj = next;
                }
            } else if (!z11) {
                break;
            }
        }
        obj = null;
        ProtoBuf$Constructor protoBuf$Constructor = (ProtoBuf$Constructor) obj;
        if (protoBuf$Constructor == null) {
            return null;
        }
        List<ProtoBuf$ValueParameter> listV = protoBuf$Constructor.V();
        kotlin.jvm.internal.p.h(listV, "getValueParameterList(...)");
        List<ProtoBuf$ValueParameter> list = listV;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (ProtoBuf$ValueParameter protoBuf$ValueParameter : list) {
            ga.e eVarB2 = C5602L.b(nameResolver, protoBuf$ValueParameter.S());
            kotlin.jvm.internal.p.f(protoBuf$ValueParameter);
            arrayList.add(Y8.j.a(eVarB2, typeDeserializer.invoke(ea.g.r(protoBuf$ValueParameter, typeTable))));
        }
        return new C0820z(arrayList);
    }
}
