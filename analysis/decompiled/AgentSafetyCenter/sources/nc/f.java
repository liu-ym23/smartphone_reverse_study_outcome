package nc;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements g {

    /* renamed from: c, reason: collision with root package name */
    public g f8840c;

    @Override // nc.g
    public final Object collect(h hVar, nb.c cVar) {
        yb.u uVar = new yb.u();
        uVar.f16098c = oc.c.f9367b;
        g gVar = this.f8840c;
        e eVar = new e(0);
        eVar.f8838g = uVar;
        eVar.f8837f = hVar;
        VarHandle.storeStoreFence();
        Object objCollect = gVar.collect(eVar, cVar);
        return objCollect == ob.a.f9351c ? objCollect : jb.v.f6774a;
    }
}
