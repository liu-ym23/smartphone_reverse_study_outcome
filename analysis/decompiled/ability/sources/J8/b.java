package J8;

import h8.InterfaceC1519b;
import h8.InterfaceC1527j;

/* loaded from: classes4.dex */
public final class b implements S7.n {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1519b f881a;
    public final InterfaceC1519b b;

    public b(InterfaceC1519b interfaceC1519b, InterfaceC1519b interfaceC1519b2) {
        this.f881a = interfaceC1519b;
        this.b = interfaceC1519b2;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return Boolean.valueOf(kotlin.jvm.internal.k.b((InterfaceC1527j) obj, this.f881a) && kotlin.jvm.internal.k.b((InterfaceC1527j) obj2, this.b));
    }
}
