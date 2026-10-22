package u5;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k implements nc.g {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14064c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ nc.g f14065f;

    public /* synthetic */ k(int i) {
        this.f14064c = i;
    }

    @Override // nc.g
    public final Object collect(nc.h hVar, nb.c cVar) {
        int i = this.f14064c;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                nc.g gVar = this.f14065f;
                j jVar = new j(0);
                jVar.f14063f = hVar;
                VarHandle.storeStoreFence();
                Object objCollect = gVar.collect(jVar, cVar);
                return objCollect == ob.a.f9351c ? objCollect : vVar;
            default:
                nc.g gVar2 = this.f14065f;
                j jVar2 = new j(1);
                jVar2.f14063f = hVar;
                VarHandle.storeStoreFence();
                Object objCollect2 = gVar2.collect(jVar2, cVar);
                return objCollect2 == ob.a.f9351c ? objCollect2 : vVar;
        }
    }
}
