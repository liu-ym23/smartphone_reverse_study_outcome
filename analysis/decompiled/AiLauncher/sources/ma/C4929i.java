package ma;

import E9.InterfaceC0819y;
import Z8.F;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import ya.AbstractC5990d0;
import ya.S;

/* renamed from: ma.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4929i {

    /* renamed from: a, reason: collision with root package name */
    public static final C4929i f37195a = new C4929i();

    public static final S d(PrimitiveType primitiveType, InterfaceC0819y it) {
        kotlin.jvm.internal.p.i(it, "it");
        AbstractC5990d0 abstractC5990d0P = it.g().P(primitiveType);
        kotlin.jvm.internal.p.h(abstractC5990d0P, "getPrimitiveArrayKotlinType(...)");
        return abstractC5990d0P;
    }

    public static /* synthetic */ AbstractC4927g f(C4929i c4929i, Object obj, InterfaceC0819y interfaceC0819y, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            interfaceC0819y = null;
        }
        return c4929i.e(obj, interfaceC0819y);
    }

    public final C4922b b(List<?> list, InterfaceC0819y interfaceC0819y, PrimitiveType primitiveType) {
        List listM1 = F.m1(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            AbstractC4927g abstractC4927gF = f(this, it.next(), null, 2, null);
            if (abstractC4927gF != null) {
                arrayList.add(abstractC4927gF);
            }
        }
        if (interfaceC0819y == null) {
            return new C4922b(arrayList, new C4928h(primitiveType));
        }
        AbstractC5990d0 abstractC5990d0P = interfaceC0819y.g().P(primitiveType);
        kotlin.jvm.internal.p.h(abstractC5990d0P, "getPrimitiveArrayKotlinType(...)");
        return new z(arrayList, abstractC5990d0P);
    }

    public final C4922b c(List<? extends AbstractC4927g<?>> value, S type) {
        kotlin.jvm.internal.p.i(value, "value");
        kotlin.jvm.internal.p.i(type, "type");
        return new z(value, type);
    }

    public final AbstractC4927g<?> e(Object obj, InterfaceC0819y interfaceC0819y) {
        if (obj instanceof Byte) {
            return new C4924d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new w(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new n(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new t(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new C4925e(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new m(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new C4930j(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new C4923c(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new x((String) obj);
        }
        if (obj instanceof byte[]) {
            return b(Z8.r.N0((byte[]) obj), interfaceC0819y, PrimitiveType.BYTE);
        }
        if (obj instanceof short[]) {
            return b(Z8.r.U0((short[]) obj), interfaceC0819y, PrimitiveType.SHORT);
        }
        if (obj instanceof int[]) {
            return b(Z8.r.R0((int[]) obj), interfaceC0819y, PrimitiveType.INT);
        }
        if (obj instanceof long[]) {
            return b(Z8.r.S0((long[]) obj), interfaceC0819y, PrimitiveType.LONG);
        }
        if (obj instanceof char[]) {
            return b(Z8.r.O0((char[]) obj), interfaceC0819y, PrimitiveType.CHAR);
        }
        if (obj instanceof float[]) {
            return b(Z8.r.Q0((float[]) obj), interfaceC0819y, PrimitiveType.FLOAT);
        }
        if (obj instanceof double[]) {
            return b(Z8.r.P0((double[]) obj), interfaceC0819y, PrimitiveType.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            return b(Z8.r.V0((boolean[]) obj), interfaceC0819y, PrimitiveType.BOOLEAN);
        }
        if (obj == null) {
            return new u();
        }
        return null;
    }
}
