package e8;

import D7.v;
import X8.S;
import X8.w;
import h8.InterfaceC1494B;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import k8.AbstractC1629B;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedArrayType;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedType;

/* loaded from: classes4.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f4430a;
    public static final Set b;
    public static final HashMap c;
    public static final HashMap d;
    public static final LinkedHashSet e;

    static {
        UnsignedType[] unsignedTypeArrValues = UnsignedType.values();
        ArrayList arrayList = new ArrayList(unsignedTypeArrValues.length);
        for (UnsignedType unsignedType : unsignedTypeArrValues) {
            arrayList.add(unsignedType.b);
        }
        f4430a = v.j1(arrayList);
        UnsignedArrayType[] unsignedArrayTypeArrValues = UnsignedArrayType.values();
        ArrayList arrayList2 = new ArrayList(unsignedArrayTypeArrValues.length);
        for (UnsignedArrayType unsignedArrayType : unsignedArrayTypeArrValues) {
            arrayList2.add(unsignedArrayType.f4944a);
        }
        b = v.j1(arrayList2);
        c = new HashMap();
        d = new HashMap();
        kotlin.collections.a.W(new HashMap(kotlin.collections.a.P(4)), new Pair[]{new Pair(UnsignedArrayType.b, G8.f.e("ubyteArrayOf")), new Pair(UnsignedArrayType.c, G8.f.e("ushortArrayOf")), new Pair(UnsignedArrayType.d, G8.f.e("uintArrayOf")), new Pair(UnsignedArrayType.e, G8.f.e("ulongArrayOf"))});
        UnsignedType[] unsignedTypeArrValues2 = UnsignedType.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (UnsignedType unsignedType2 : unsignedTypeArrValues2) {
            linkedHashSet.add(unsignedType2.c.f());
        }
        e = linkedHashSet;
        for (UnsignedType unsignedType3 : UnsignedType.values()) {
            HashMap map = c;
            G8.b bVar = unsignedType3.c;
            G8.b bVar2 = unsignedType3.f4945a;
            map.put(bVar, bVar2);
            d.put(bVar2, unsignedType3.c);
        }
    }

    public static final boolean a(w wVar) {
        InterfaceC1524g interfaceC1524gD;
        if (S.l(wVar) || (interfaceC1524gD = wVar.Q().d()) == null) {
            return false;
        }
        InterfaceC1527j interfaceC1527jD = interfaceC1524gD.d();
        return (interfaceC1527jD instanceof InterfaceC1494B) && kotlin.jvm.internal.k.b(((AbstractC1629B) ((InterfaceC1494B) interfaceC1527jD)).e, o.l) && f4430a.contains(interfaceC1524gD.getName());
    }
}
