package t;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x implements t0 {

    /* renamed from: a, reason: collision with root package name */
    public static final x f13086a = new x();

    @Override // t.t0
    public final u1.l a(v.k kVar) {
        w wVar = new w();
        wVar.f13073s = kVar;
        VarHandle.storeStoreFence();
        return wVar;
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return -1;
    }
}
