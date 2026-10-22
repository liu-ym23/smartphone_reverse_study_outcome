package gc;

import java.lang.invoke.VarHandle;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements k {

    /* renamed from: a, reason: collision with root package name */
    public final k f4690a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4691b;

    /* renamed from: c, reason: collision with root package name */
    public final xb.l f4692c;

    public h(k kVar, boolean z10, xb.l lVar) {
        this.f4690a = kVar;
        this.f4691b = z10;
        this.f4692c = lVar;
    }

    @Override // gc.k
    public final Iterator iterator() {
        g gVar = new g(0);
        gVar.i = this;
        gVar.f4687f = this.f4690a.iterator();
        gVar.f4688g = -1;
        VarHandle.storeStoreFence();
        return gVar;
    }
}
