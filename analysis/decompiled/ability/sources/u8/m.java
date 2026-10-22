package u8;

import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import java.lang.reflect.Modifier;
import k8.K;

/* loaded from: classes4.dex */
public final class m implements S7.k {
    public static final m b = new m(0);
    public static final m c = new m(1);
    public static final m d = new m(2);
    public static final m e = new m(3);
    public static final m f = new m(4);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6729a;

    public /* synthetic */ m(int i) {
        this.f6729a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f6729a) {
            case 0:
                n8.p it = (n8.p) obj;
                int i = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a.f4997v;
                kotlin.jvm.internal.k.f(it, "it");
                return Boolean.valueOf(!Modifier.isStatic(it.b().getModifiers()));
            case 1:
                K selectMostSpecificInEachOverridableGroup = (K) obj;
                Z7.t[] tVarArr = z.m;
                kotlin.jvm.internal.k.f(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
                return selectMostSpecificInEachOverridableGroup;
            case 2:
                n8.p it2 = (n8.p) obj;
                int i6 = C2045C.p;
                kotlin.jvm.internal.k.f(it2, "it");
                return Boolean.valueOf(Modifier.isStatic(it2.b().getModifiers()));
            case 3:
                Q8.o it3 = (Q8.o) obj;
                int i10 = C2045C.p;
                kotlin.jvm.internal.k.f(it3, "it");
                return it3.getVariableNames();
            default:
                int i11 = C2045C.p;
                InterfaceC1524g interfaceC1524gD = ((X8.w) obj).Q().d();
                if (interfaceC1524gD instanceof InterfaceC1522e) {
                    return (InterfaceC1522e) interfaceC1524gD;
                }
                return null;
        }
    }
}
