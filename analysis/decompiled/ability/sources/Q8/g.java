package Q8;

import h8.InterfaceC1520c;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class g extends J8.m {
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ h d;

    public g(ArrayList arrayList, h hVar) {
        this.c = arrayList;
        this.d = hVar;
    }

    @Override // J8.m
    public final void b(InterfaceC1520c fakeOverride) {
        kotlin.jvm.internal.k.f(fakeOverride, "fakeOverride");
        J8.k.r(fakeOverride, null);
        this.c.add(fakeOverride);
    }

    @Override // J8.m
    public final void d(InterfaceC1520c interfaceC1520c, InterfaceC1520c fromCurrent) {
        kotlin.jvm.internal.k.f(fromCurrent, "fromCurrent");
        throw new IllegalStateException(("Conflict in scope of " + this.d.b + ": " + interfaceC1520c + " vs " + fromCurrent).toString());
    }
}
