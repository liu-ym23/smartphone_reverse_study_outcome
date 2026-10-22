package gc;

import java.lang.invoke.VarHandle;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements k, e {

    /* renamed from: a, reason: collision with root package name */
    public final k f4683a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4684b;

    public d(k kVar, int i) {
        kVar.getClass();
        this.f4683a = kVar;
        this.f4684b = i;
        if (i >= 0) {
            return;
        }
        g5.f.d(i, 46, "count must be non-negative, but was ");
        throw null;
    }

    @Override // gc.e
    public final k a(int i) {
        int i3 = this.f4684b + i;
        return i3 < 0 ? new d(this, i) : new d(this.f4683a, i3);
    }

    @Override // gc.k
    public final Iterator iterator() {
        c cVar = new c(0);
        cVar.f4681f = this.f4683a.iterator();
        cVar.f4682g = this.f4684b;
        VarHandle.storeStoreFence();
        return cVar;
    }
}
