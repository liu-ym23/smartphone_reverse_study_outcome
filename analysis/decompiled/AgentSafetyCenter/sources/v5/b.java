package v5;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements h {

    /* renamed from: a, reason: collision with root package name */
    public l f14773a;

    /* renamed from: b, reason: collision with root package name */
    public sc.h f14774b;

    @Override // v5.h
    public final i a(y5.m mVar, e6.m mVar2) {
        p pVar = mVar.f15925a;
        sc.h hVar = this.f14774b;
        l lVar = this.f14773a;
        d dVar = new d();
        dVar.f14779a = pVar;
        dVar.f14780b = mVar2;
        dVar.f14781c = hVar;
        dVar.f14782d = lVar;
        VarHandle.storeStoreFence();
        return dVar;
    }

    public final boolean equals(Object obj) {
        return obj instanceof b;
    }

    public final int hashCode() {
        return b.class.hashCode();
    }
}
