package h6;

import e6.j;
import e6.q;
import java.lang.invoke.VarHandle;
import u5.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements e {

    /* renamed from: b, reason: collision with root package name */
    public int f5390b;

    @Override // h6.e
    public final f a(m mVar, j jVar) {
        if (!(jVar instanceof q)) {
            d dVar = new d();
            dVar.f5394a = mVar;
            dVar.f5395b = jVar;
            VarHandle.storeStoreFence();
            return dVar;
        }
        if (((q) jVar).f3594c == v5.f.f14784c) {
            d dVar2 = new d();
            dVar2.f5394a = mVar;
            dVar2.f5395b = jVar;
            VarHandle.storeStoreFence();
            return dVar2;
        }
        int i = this.f5390b;
        b bVar = new b();
        bVar.f5391a = mVar;
        bVar.f5392b = jVar;
        bVar.f5393c = i;
        if (i > 0) {
            VarHandle.storeStoreFence();
            return bVar;
        }
        g5.f.s("durationMillis must be > 0.");
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f5390b == ((a) obj).f5390b;
    }

    public final int hashCode() {
        return Boolean.hashCode(false) + (this.f5390b * 31);
    }
}
