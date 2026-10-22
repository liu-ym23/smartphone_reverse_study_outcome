package C9;

import E9.E;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import Z8.F;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedArrayType;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedType;
import ya.H0;
import ya.S;

/* loaded from: classes5.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f1947a = new q();

    /* renamed from: b, reason: collision with root package name */
    public static final Set<ga.e> f1948b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set<ga.e> f1949c;

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap<ga.b, ga.b> f1950d;

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap<ga.b, ga.b> f1951e;

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap<UnsignedArrayType, ga.e> f1952f;

    /* renamed from: g, reason: collision with root package name */
    public static final Set<ga.e> f1953g;

    static {
        UnsignedType[] unsignedTypeArrValues = UnsignedType.values();
        ArrayList arrayList = new ArrayList(unsignedTypeArrValues.length);
        for (UnsignedType unsignedType : unsignedTypeArrValues) {
            arrayList.add(unsignedType.getTypeName());
        }
        f1948b = F.r1(arrayList);
        UnsignedArrayType[] unsignedArrayTypeArrValues = UnsignedArrayType.values();
        ArrayList arrayList2 = new ArrayList(unsignedArrayTypeArrValues.length);
        for (UnsignedArrayType unsignedArrayType : unsignedArrayTypeArrValues) {
            arrayList2.add(unsignedArrayType.getTypeName());
        }
        f1949c = F.r1(arrayList2);
        f1950d = new HashMap<>();
        f1951e = new HashMap<>();
        f1952f = kotlin.collections.a.k(Y8.j.a(UnsignedArrayType.UBYTEARRAY, ga.e.j("ubyteArrayOf")), Y8.j.a(UnsignedArrayType.USHORTARRAY, ga.e.j("ushortArrayOf")), Y8.j.a(UnsignedArrayType.UINTARRAY, ga.e.j("uintArrayOf")), Y8.j.a(UnsignedArrayType.ULONGARRAY, ga.e.j("ulongArrayOf")));
        UnsignedType[] unsignedTypeArrValues2 = UnsignedType.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (UnsignedType unsignedType2 : unsignedTypeArrValues2) {
            linkedHashSet.add(unsignedType2.getArrayClassId().h());
        }
        f1953g = linkedHashSet;
        for (UnsignedType unsignedType3 : UnsignedType.values()) {
            f1950d.put(unsignedType3.getArrayClassId(), unsignedType3.getClassId());
            f1951e.put(unsignedType3.getClassId(), unsignedType3.getArrayClassId());
        }
    }

    public static final boolean d(S type) {
        InterfaceC0799d interfaceC0799dD;
        kotlin.jvm.internal.p.i(type, "type");
        if (H0.w(type) || (interfaceC0799dD = type.H0().d()) == null) {
            return false;
        }
        return f1947a.c(interfaceC0799dD);
    }

    public final ga.b a(ga.b arrayClassId) {
        kotlin.jvm.internal.p.i(arrayClassId, "arrayClassId");
        return f1950d.get(arrayClassId);
    }

    public final boolean b(ga.e name) {
        kotlin.jvm.internal.p.i(name, "name");
        return f1953g.contains(name);
    }

    public final boolean c(InterfaceC0803h descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        InterfaceC0803h interfaceC0803hB = descriptor.b();
        return (interfaceC0803hB instanceof E) && kotlin.jvm.internal.p.d(((E) interfaceC0803hB).f(), o.f1810B) && f1948b.contains(descriptor.getName());
    }
}
