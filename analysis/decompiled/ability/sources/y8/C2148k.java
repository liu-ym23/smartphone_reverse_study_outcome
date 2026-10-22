package y8;

import C7.r;
import X8.U;
import X8.w;
import g8.C1468d;
import h8.InterfaceC1520c;
import h8.InterfaceC1524g;
import k8.u;
import v8.C2071g;

/* renamed from: y8.k, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2148k implements S7.k {
    public static final C2148k b = new C2148k(0);
    public static final C2148k c = new C2148k(1);
    public static final C2148k d = new C2148k(2);
    public static final C2148k e = new C2148k(3);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6918a;

    public /* synthetic */ C2148k(int i) {
        this.f6918a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f6918a) {
            case 0:
                InterfaceC1520c it = (InterfaceC1520c) obj;
                kotlin.jvm.internal.k.f(it, "it");
                u uVarI = it.I();
                kotlin.jvm.internal.k.c(uVarI);
                return uVarI.getType();
            case 1:
                InterfaceC1520c it2 = (InterfaceC1520c) obj;
                kotlin.jvm.internal.k.f(it2, "it");
                w returnType = it2.getReturnType();
                kotlin.jvm.internal.k.c(returnType);
                return returnType;
            case 2:
                U it3 = (U) obj;
                kotlin.jvm.internal.k.f(it3, "it");
                return Boolean.valueOf(it3 instanceof C2071g);
            case 3:
                InterfaceC1524g interfaceC1524gD = ((U) obj).Q().d();
                if (interfaceC1524gD == null) {
                    return Boolean.FALSE;
                }
                G8.f name = interfaceC1524gD.getName();
                G8.c cVar = C1468d.f;
                return Boolean.valueOf(kotlin.jvm.internal.k.b(name, cVar.f()) && kotlin.jvm.internal.k.b(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.c(interfaceC1524gD), cVar));
            default:
                C2149l function = (C2149l) obj;
                kotlin.jvm.internal.k.f(function, "$this$function");
                String strConcat = "java/util/".concat("Spliterator");
                C2141d c2141d = AbstractC2146i.b;
                function.b(strConcat, c2141d, c2141d);
                return r.f317a;
        }
    }
}
