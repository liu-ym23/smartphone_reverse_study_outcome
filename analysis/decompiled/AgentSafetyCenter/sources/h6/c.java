package h6;

import e6.j;
import java.lang.invoke.VarHandle;
import u5.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements e {
    @Override // h6.e
    public final f a(m mVar, j jVar) {
        d dVar = new d();
        dVar.f5394a = mVar;
        dVar.f5395b = jVar;
        VarHandle.storeStoreFence();
        return dVar;
    }

    public final boolean equals(Object obj) {
        return obj instanceof c;
    }

    public final int hashCode() {
        return c.class.hashCode();
    }
}
