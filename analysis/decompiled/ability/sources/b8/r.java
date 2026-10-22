package b8;

import h8.InterfaceC1499G;
import h8.InterfaceC1520c;

/* loaded from: classes4.dex */
public final class r implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1520c f2052a;
    public final int b;

    public r(InterfaceC1520c interfaceC1520c, int i) {
        this.f2052a = interfaceC1520c;
        this.b = i;
    }

    @Override // S7.a
    public final Object invoke() {
        Object obj = this.f2052a.x().get(this.b);
        kotlin.jvm.internal.k.e(obj, "get(...)");
        return (InterfaceC1499G) obj;
    }
}
