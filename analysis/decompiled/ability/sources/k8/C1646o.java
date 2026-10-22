package k8;

import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;

/* renamed from: k8.o, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1646o implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4850a;
    public final /* synthetic */ C1647p b;

    public /* synthetic */ C1646o(C1647p c1647p, int i) {
        this.f4850a = i;
        this.b = c1647p;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f4850a) {
            case 0:
                G8.f fVar = (G8.f) obj;
                if (fVar != null) {
                    C1647p c1647p = this.b;
                    return c1647p.i(fVar, c1647p.h().f(fVar, NoLookupLocation.f));
                }
                C1647p.g(8);
                throw null;
            default:
                G8.f fVar2 = (G8.f) obj;
                if (fVar2 != null) {
                    C1647p c1647p2 = this.b;
                    return c1647p2.i(fVar2, c1647p2.h().d(fVar2, NoLookupLocation.f));
                }
                C1647p.g(4);
                throw null;
        }
    }
}
