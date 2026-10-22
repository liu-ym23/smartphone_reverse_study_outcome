package N8;

import S7.k;
import h8.InterfaceC1520c;
import h8.InterfaceC1527j;

/* loaded from: classes4.dex */
public final class b implements k {
    public static final b b = new b(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1014a;

    public /* synthetic */ b(int i) {
        this.f1014a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1014a) {
            case 0:
                InterfaceC1527j it = (InterfaceC1527j) obj;
                int i = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f5120a;
                kotlin.jvm.internal.k.f(it, "it");
                return it.d();
            default:
                InterfaceC1520c interfaceC1520c = (InterfaceC1520c) obj;
                kotlin.jvm.internal.k.c(interfaceC1520c);
                return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.l(interfaceC1520c);
        }
    }
}
