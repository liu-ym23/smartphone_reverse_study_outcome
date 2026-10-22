package h8;

import java.util.List;
import k8.AbstractC1629B;

/* renamed from: h8.q, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1534q implements S7.k {
    public static final C1534q b = new C1534q(0);
    public static final C1534q c = new C1534q(1);
    public static final C1534q d = new C1534q(2);
    public static final C1534q e = new C1534q(3);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4587a;

    public /* synthetic */ C1534q(int i) {
        this.f4587a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f4587a) {
            case 0:
                kotlin.jvm.internal.k.f((G8.b) obj, "it");
                return 0;
            case 1:
                InterfaceC1494B it = (InterfaceC1494B) obj;
                kotlin.jvm.internal.k.f(it, "it");
                return ((AbstractC1629B) it).e;
            case 2:
                InterfaceC1527j it2 = (InterfaceC1527j) obj;
                kotlin.jvm.internal.k.f(it2, "it");
                return Boolean.valueOf(!(it2 instanceof InterfaceC1526i));
            default:
                InterfaceC1527j it3 = (InterfaceC1527j) obj;
                kotlin.jvm.internal.k.f(it3, "it");
                List typeParameters = ((InterfaceC1519b) it3).getTypeParameters();
                kotlin.jvm.internal.k.e(typeParameters, "getTypeParameters(...)");
                return D7.v.s0(typeParameters);
        }
    }
}
