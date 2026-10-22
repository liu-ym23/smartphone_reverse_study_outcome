package e8;

import X8.A;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;

/* loaded from: classes4.dex */
public final class f implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4381a;
    public final /* synthetic */ i b;

    public /* synthetic */ f(i iVar, int i) {
        this.f4381a = i;
        this.b = iVar;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f4381a;
        i iVar = this.b;
        switch (i) {
            case 0:
                return Arrays.asList(iVar.k().V(o.l), iVar.k().V(o.n), iVar.k().V(o.o), iVar.k().V(o.m));
            default:
                EnumMap enumMap = new EnumMap(PrimitiveType.class);
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                for (PrimitiveType primitiveType : PrimitiveType.values()) {
                    String strB = primitiveType.f4943a.b();
                    if (strB == null) {
                        i.a(47);
                        throw null;
                    }
                    A aG = iVar.j(strB).g();
                    if (aG == null) {
                        i.a(48);
                        throw null;
                    }
                    String strB2 = primitiveType.b.b();
                    if (strB2 == null) {
                        i.a(47);
                        throw null;
                    }
                    A aG2 = iVar.j(strB2).g();
                    if (aG2 == null) {
                        i.a(48);
                        throw null;
                    }
                    enumMap.put((EnumMap) primitiveType, (PrimitiveType) aG2);
                    map.put(aG, aG2);
                    map2.put(aG2, aG);
                }
                return new h(enumMap, map, map2);
        }
    }
}
